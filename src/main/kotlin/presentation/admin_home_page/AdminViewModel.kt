package presentation.admin_home_page

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import data.repository.AdminRepository
import domain.model.staff.Staff
import domain.util.AdminPopup
import domain.viewmodel.Viewmodel
import kotlinx.coroutines.launch
import kotlin.concurrent.fixedRateTimer

class AdminViewModel(val repository: AdminRepository):Viewmodel {

    var popWindowState:AdminPopup? by mutableStateOf<AdminPopup?>(null)

    var staffId by mutableStateOf("")
    var firstName by mutableStateOf("")
    var lastName by mutableStateOf("")
    var mobile by mutableStateOf("")
    var password by mutableStateOf("")

    fun AddStaff(){
        if(
            firstName!=""&& lastName!="" && mobile!="" && password!=""
        ){

            val staff=Staff(
                firstName=this.firstName,
                lastName = this.lastName,
                mobile = this.mobile,
                passWord = this.password
            )

            viewmodelScopeIo.launch {

                repository.AddStaff(staff)
            }
        }
    }

}