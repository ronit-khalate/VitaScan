package data.localDataSource

import org.jetbrains.exposed.sql.Database

class DataBase {
    companion object{
        fun connect() = Database.connect(url = "jdbc:sqlite:identifier.sqlite", driver = "org.sqlite.JDBC")
    }
}