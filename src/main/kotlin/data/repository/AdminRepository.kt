package data.repository

import domain.model.staff.Staff
import domain.model.staffcount.StaffCount
import domain.model.staff.StaffTable
import domain.model.staff.toStaff
import domain.model.staffcount.toStaffCountCls
import domain.repository.AdminRepository
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update

class AdminRepositoryImpl :AdminRepository{
    override suspend fun addDoctor(staff: Staff) {


        transaction {

            val staffCountRow=StaffCount.select {
                StaffCount.id eq 0
            }.map { toStaffCountCls(it) }.firstOrNull()

            staffCountRow?.let {staffCountCls ->

                StaffTable.insert {
                    it[userId]="DOC${staffCountCls.doctorCount+1}"
                    it[firstName]=staff.firstName
                    it[lastName]=staff.lastName
                    it[mobile]=staff.mobile
                    it[password]=staff.passWord
                }

                StaffCount.update(where = {StaffCount.id eq 0}){

                    it[DoctorCount]=staffCountCls.doctorCount+1
                }
            }


        }
    }

    override suspend fun loadDoc(staffId: String): Staff? =transaction {

            StaffTable.select {
                StaffTable.userId eq staffId
            }.map { toStaff(it) }.firstOrNull()
        }

    override suspend fun updateDoc(staff: Staff) {

        transaction {
            StaffTable.update(where = {StaffTable.userId eq staff.userid}){

                it[mobile]=staff.mobile
                it[password]=staff.passWord
            }
        }
    }


}