package domain.util

sealed class StaffState(
    val firstName: String,
    val id:String
) {
    class Admin(firstName: String,id:String) :StaffState(firstName,id)
    class Doctor(firstName: String,id: String):StaffState(firstName,id)
}