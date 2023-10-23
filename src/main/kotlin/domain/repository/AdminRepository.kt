package domain.repository

import domain.model.staff.Staff

interface AdminRepository {

    suspend fun addDoctor(staff: Staff)
    suspend fun loadDoc(staffId:String):Staff?

    suspend fun updateDoc(staff: Staff)
}