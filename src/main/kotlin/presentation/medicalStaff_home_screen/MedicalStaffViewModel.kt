package presentation.medicalStaff_home_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.popWhile
import com.arkivanov.decompose.router.stack.push
import domain.model.staff.Staff
import domain.viewmodel.Viewmodel
import navigation.Screen
import java.nio.file.Path

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


    // Insert Page

    var pid by mutableStateOf("")
    var firstName by mutableStateOf("")
    var lastName by mutableStateOf("")

    var selectedImages by mutableStateOf(listOf<Path>())

    fun onRemoveSelectedFile(path: Path){

        if(selectedImages.isNotEmpty()){
            var lis= selectedImages.toMutableList()
            lis.remove(path)
            selectedImages=lis
        }
    }


}