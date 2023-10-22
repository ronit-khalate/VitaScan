import androidx.compose.foundation.LocalScrollbarStyle
import androidx.compose.foundation.defaultScrollbarStyle
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetbrains.lifecycle.LifecycleController
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.example.compose.LightColors
import data.localDataSource.DataBase
import data.repository.LoginRepository
import domain.model.staffcount.StaffCount
import domain.model.staff.StaffTable
import navigation.ChildStack
import navigation.ProvideComponentContext
import navigation.Screen
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import presentation.admin_home_page.AdminHomePage
import presentation.admin_home_page.AdminViewModel
import presentation.login_page.LoginScreen
import presentation.doctor_home_screen.DoctorHomePage
import presentation.login_page.LoginPageViewModel
import presentation.view_record_page.ViewRecordPage


@OptIn(ExperimentalDecomposeApi::class)
fun main() {

    val lifecycle = LifecycleRegistry()
    val rootComponentContext = DefaultComponentContext(lifecycle=lifecycle)
    application {

       val windowState = rememberWindowState()
        LifecycleController(lifecycle,windowState)
        Window(onCloseRequest = ::exitApplication) {


            DataBase.connect()
            transaction {
                SchemaUtils.create(StaffTable)
                SchemaUtils.create(StaffCount)
            }



            MaterialTheme(
                colors = LightColors
            ) {

                CompositionLocalProvider(LocalScrollbarStyle provides defaultScrollbarStyle()){

                    ProvideComponentContext(rootComponentContext){

                        MainContent()
                    }
                }

            }
        }



    }
}

@Composable
fun MainContent(
){

    val navigation = remember { StackNavigation<Screen>() }
    val loginScreenViewModel by remember { mutableStateOf(LoginPageViewModel(repository = LoginRepository(), navigation = navigation)) }
    val adminScreenViewModel by remember { mutableStateOf(AdminViewModel()) }

    ChildStack(
        source = navigation,
        initialStack = { listOf(Screen.Login(null)) },
        handleBackButton = true,
        animation = stackAnimation(fade())
    ){screen ->

        when(screen){
            is Screen.DoctorHome -> DoctorHomePage(doctor = screen.staff,{},{},)
            is Screen.AdminHome -> AdminHomePage(admin = screen.staff, viewModel = adminScreenViewModel)
            is Screen.Login -> LoginScreen(modifier = Modifier.fillMaxSize(), viewModel = loginScreenViewModel)
            is Screen.ViewRecordPage -> ViewRecordPage(staff = screen.staff)
        }

    }
}
