package data.repository

import domain.model.staff.Staff
import domain.model.staffcount.StaffCount
import domain.model.staff.StaffTable
import domain.repository.AdminRepository
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

class AdminRepositoryImpl :AdminRepository{
    override suspend fun addDoctor(staff: Staff) {
        TODO("Not yet implemented")
    }


}