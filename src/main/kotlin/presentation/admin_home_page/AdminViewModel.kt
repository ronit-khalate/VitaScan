package presentation.admin_home_page

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import domain.model.staff.Staff
import domain.repository.AdminRepository
import domain.util.AdminPopup
import domain.viewmodel.Viewmodel
import kotlinx.coroutines.launch

class AdminViewModel(val repository: AdminRepository) :Viewmodel {

    var popWindowState:AdminPopup? by mutableStateOf<AdminPopup?>(null)

    // Add Doc Form
    var addDocFirstName by mutableStateOf("")
    var addDocLastName by mutableStateOf("")
    var addDocMobileNumber by mutableStateOf("")
    var addDocPassword by mutableStateOf("")

    //Update Doc form
    var updateDocStaffId by mutableStateOf("")
    var updateDocFirstName by mutableStateOf("")
    var updateDocLastName by mutableStateOf("")
    var updateDocMobile by mutableStateOf("")
    var updateDocOldPassword by mutableStateOf("")
    var updateDocNewPassword by mutableStateOf("")

    fun onAddDoc(){

        val doctor=Staff(
            id=0,
            userid = "",
            firstName = this.addDocFirstName,
            lastName = this.addDocLastName,
            mobile = this.addDocMobileNumber,
            passWord = this.addDocPassword
        )


        viewmodelScopeIo.launch {

            repository.addDoctor(staff = doctor)
        }
    }


}