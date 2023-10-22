package domain.model.staffcount

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object StaffCount:IntIdTable() {

    val AdminCount = integer("Admin Count")
    val DoctorCount=integer("Doctor Count")
}

