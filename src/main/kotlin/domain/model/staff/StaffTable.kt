package domain.model.staff

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.ResultRow

object StaffTable:IntIdTable() {

    val userId = varchar("User Id" , length = 7).uniqueIndex()
    val firstName =varchar("First Name", length = 10)
    val lastName=varchar("Last Name", length = 10)
    val password=varchar("Password", length = 10)
}

fun toStaff(row:ResultRow):Staff{

    return Staff(
        id = row[StaffTable.id].value,
        userid = row[StaffTable.userId],
        firstName = row[StaffTable.firstName],
        lastName = row[StaffTable.lastName],
        passWord = row[StaffTable.password]
    )
}