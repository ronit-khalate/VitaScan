package domain.repository

import domain.model.staff.Staff

interface AdminRepository {

    suspend fun addDoctor(staff: Staff)
}