package data.repository

import domain.model.staff.Staff
import domain.model.staffcount.StaffCount
import domain.model.staff.StaffTable
import domain.repository.AdminRepository
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

class AdminRepository :AdminRepository{
    override suspend fun insertStaff(staff: Staff) {

        val staffCount = transaction {
            val staff= staff.userid.dropLast(4)
            val count:Int=0

            if(staff=="DOC"){

                StaffCount.select {
                    StaffCount.id eq 1
                }
            }
        }
        transaction {
            StaffTable.insert {

            }
        }
    }


}