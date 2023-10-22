package data.repository

import domain.model.staff.Staff
import domain.model.staff.StaffTable
import domain.model.staff.toStaff
import domain.repository.LoginRepository
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

class LoginRepository: LoginRepository{
    override suspend fun login(loginId: String, _password: String): Staff? {

        var staff:Staff?=null





           staff=transaction {

               try {
                   println("In try")
                   StaffTable.select{
                       StaffTable.userId eq loginId.trim()
                   }.map {
                       toStaff(it)
                   }.firstOrNull()
               }catch (e:Exception){
                   println("Error in the query: $e")
                   null
               }

            }




        return staff
    }
}