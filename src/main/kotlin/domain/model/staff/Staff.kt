package domain.model.staff

data class Staff(
    val id:Int=0,
    val userid:String="",
    val firstName:String,
    val lastName:String,
    val mobile:String,
    val passWord:String
)