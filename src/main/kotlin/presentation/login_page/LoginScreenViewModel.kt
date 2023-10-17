package presentation.login_page

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import domain.viewmodel.Viewmodel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import navigation.Screen


class LoginScreenViewModel(
    val navigation:StackNavigation<Screen>
):Viewmodel {

    var loginId by mutableStateOf("")
    var loginPassword by mutableStateOf("")
    var loginAsAdmin by mutableStateOf(false)
    var showLoadingSpinner by mutableStateOf(false)
    private var isLoginAsAdminSet =loginAsAdmin

    fun Login(){

        showLoadingSpinner=true

        navigation.push(Screen.AdminHome)

        showLoadingSpinner=false



    }

}