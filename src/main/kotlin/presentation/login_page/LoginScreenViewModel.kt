package presentation.login_page

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import domain.viewmodel.Viewmodel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class LoginScreenViewModel():Viewmodel {

    var loginId by mutableStateOf("")
    var loginPassword by mutableStateOf("")
    var loginAsAdmin by mutableStateOf(false)
    var showLoadingSpinner by mutableStateOf(false)
    private var isLoginAsAdminSet =loginAsAdmin

    fun Login(){

        showLoadingSpinner=true

        viewmodelScope.launch {
            delay(3000)
            showLoadingSpinner=false
        }

    }

}