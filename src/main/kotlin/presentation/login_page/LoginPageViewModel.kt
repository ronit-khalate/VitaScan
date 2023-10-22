package presentation.login_page

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import domain.model.staff.Staff
import domain.repository.LoginRepository
import domain.viewmodel.Viewmodel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import navigation.Screen

class LoginPageViewModel(
    private val repository: LoginRepository,
    val navigation: StackNavigation<Screen>
):Viewmodel {

    var loginId by mutableStateOf("")
    var password by mutableStateOf("")


    fun login(){

        println(loginId)
        println(password)


        viewmodelScopeIo.launch {
            val staff=repository.login(loginId = loginId, _password = password)
            staff?.let {

                if(it.userid.startsWith("DOC")){

                    if(it.passWord== password){
                        
                        navigation.push(Screen.DoctorHome(it))

                    }

                }
                else{

                    if(it.passWord== password) {


                        navigation.push(Screen.AdminHome(it))

                    }

                }
            }

            println(staff.toString())


        }
    }
}