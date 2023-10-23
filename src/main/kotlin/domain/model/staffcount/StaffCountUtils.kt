package domain.model.staffcount

import org.jetbrains.exposed.sql.ResultRow

data class StaffCountCls(
    val adminCount:Int,
    val doctorCount:Int
)

fun toStaffCountCls(row:ResultRow):StaffCountCls{

    return StaffCountCls(
        adminCount = row[StaffCount.AdminCount],
        doctorCount = row[StaffCount.DoctorCount]
    )
}