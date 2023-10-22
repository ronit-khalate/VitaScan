package data.repository

import domain.model.staff.Staff
import domain.model.staffcount.StaffCount
import domain.model.staff.StaffTable
import domain.model.staffcount.toStaffCountClass
import domain.repository.AdminRepository
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update

class AdminRepository :AdminRepository{
    override suspend fun AddStaff(staff: Staff) {

        transaction {
            val staffCount=StaffCount.select {
                StaffCount.id eq 0
            }.map { toStaffCountClass(it) }.firstOrNull()

            staffCount?.let { count->

                StaffTable.insert {

                    it[userId]="DOC${count.doctorCount+1}"
                    it[firstName]=staff.firstName
                    it[lastName]=staff.lastName
                    it[mobile]=staff.mobile
                    it[password]=staff.passWord
                }

                StaffTable.update(where = {StaffCount.id eq 0}) {
                    it[StaffCount.DoctorCount]= staffCount.doctorCount+1
                }
            }




        }

    }


}