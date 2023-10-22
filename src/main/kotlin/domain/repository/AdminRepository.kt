package domain.repository

import domain.model.staff.Staff

interface AdminRepository {

    suspend fun insertStaff(staff: Staff)
}