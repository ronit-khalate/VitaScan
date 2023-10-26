package presentation.view_record_page

import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.popWhile
import domain.viewmodel.Viewmodel
import navigation.Screen

class ViewRecordPageViewModel(
    private  val navigation: StackNavigation<Screen>
):Viewmodel {


    fun onBackBtnClick(){

        navigation.pop()
    }

    fun onLogOut(){
        navigation.popWhile {
            it::class!=Screen.Login::class
        }
    }
}