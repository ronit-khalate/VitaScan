package domain.repository

import domain.model.staff.Staff

interface LoginRepository {

    suspend fun login(loginId:String,_password:String):Staff?
}