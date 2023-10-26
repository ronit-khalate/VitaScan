package presentation.medicalStaff_home_screen

import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.popWhile
import com.arkivanov.decompose.router.stack.push
import domain.model.staff.Staff
import domain.viewmodel.Viewmodel
import navigation.Screen

class MedicalStaffViewModel(
    val navigation:StackNavigation<Screen>
):Viewmodel {



    fun onViewRecord(medicalStaff:Staff){
        navigation.push(Screen.ViewRecordPage(medicalStaff))
    }

    fun onLogOut(){
        navigation.popWhile {
            it::class!=Screen.Login::class
        }
    }


    fun onInsertRecordBtnClick(medicalStaff: Staff){

        navigation.push(Screen.InsertRecordPage(medicalStaff))
    }
}