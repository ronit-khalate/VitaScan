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


    // Add From function
    fun onAddDoc(){

        val doctor=Staff(
            id=0,
            userid = "",
            firstName = this.addDocFirstName,
            lastName = this.addDocLastName,
            mobile = this.addDocMobileNumber,
            passWord = this.addDocPassword
        )

        //

        if(doctor.firstName.length>10 || doctor.firstName.length<=2){

        }

        if(doctor.lastName.length>10 || doctor.lastName.length<=2){

        }
        if(doctor.mobile.length!=10){

        }

        if(doctor.passWord.length<5 || doctor.passWord.length>10){

        }



        viewmodelScopeIo.launch {

            repository.addDoctor(staff = doctor)
            popWindowState=null
        }
    }

    // Update From function
    fun loadDoc(staffID:String){

        viewmodelScopeIo.launch {
            val doc=repository.loadDoc(staffID)

           if(doc!=null){
               updateDocStaffId=doc.userid
               updateDocMobile=doc.mobile
               updateDocFirstName=doc.firstName
               updateDocLastName=doc.lastName
               updateDocOldPassword=doc.passWord

           }

        }
    }

    fun onUpdate(){

        if(updateDocNewPassword==""){
            val staff=Staff(
                id=0,
                userid = updateDocStaffId,
                firstName = updateDocFirstName,
                lastName = updateDocLastName,
                mobile =updateDocMobile,
                passWord = updateDocOldPassword

            )
            viewmodelScopeIo.launch {
                repository.updateDoc(staff)
                popWindowState=null
            }

        }
        else if (updateDocNewPassword.length in 5..9){

            val staff=Staff(
                id=0,
                userid = updateDocStaffId,
                firstName = updateDocFirstName,
                lastName = updateDocLastName,
                mobile =updateDocMobile,
                passWord = updateDocNewPassword

            )

            viewmodelScopeIo.launch {
                repository.updateDoc(staff)
                popWindowState=null
            }
        }
    }



}