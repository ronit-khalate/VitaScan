package domain.model.staffcount

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.ResultRow

object StaffCount:IntIdTable() {

    val AdminCount = integer("Admin Count")
    val DoctorCount=integer("Doctor Count")
}


data class StaffCountClass(val adminCount:Int,val doctorCount:Int)

fun toStaffCountClass(row:ResultRow):StaffCountClass{

    return StaffCountClass(
        adminCount = row[StaffCount.AdminCount],
        doctorCount = row[StaffCount.DoctorCount]
    )
}