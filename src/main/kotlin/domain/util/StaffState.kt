package domain.util

sealed class StaffState(
    val firstName: String,
    val id:String
) {
    class Admin(firstName: String,id:String) :StaffState(firstName,id)
    class MedicalStaff(firstName: String, id: String):StaffState(firstName,id)
}