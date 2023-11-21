import androidx.compose.foundation.LocalScrollbarStyle
import androidx.compose.foundation.defaultScrollbarStyle
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.*
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetbrains.lifecycle.LifecycleController
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.example.compose.LightColors
import data.localDataSource.DataBase
import data.repository.AdminRepositoryImpl
import data.repository.LoginRepository
import domain.model.staffcount.StaffCount
import domain.model.staff.StaffTable
import navigation.ChildStack
import navigation.ProvideComponentContext
import navigation.Screen
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import presentation.aboutus.AboutUsPage
import presentation.admin_home_page.AdminHomePage
import presentation.admin_home_page.AdminViewModel
import presentation.login_page.LoginScreen
import presentation.medicalStaff_home_screen.DoctorHomePage
import presentation.login_page.LoginPageViewModel
import presentation.medicalStaff_home_screen.MedicalStaffViewModel
import presentation.medicalStaff_home_screen.insertpage.InsertRecordPage
import presentation.view_record_page.ViewRecordPage
import presentation.view_record_page.ViewRecordPageViewModel


@OptIn(ExperimentalDecomposeApi::class)
fun main() {

    val lifecycle = LifecycleRegistry()
    val rootComponentContext = DefaultComponentContext(lifecycle=lifecycle)
    application {

       val windowState = rememberWindowState(placement = WindowPlacement.Maximized)
        LifecycleController(lifecycle,windowState)
        Window(onCloseRequest = ::exitApplication, title = "VitaScan", state = windowState) {


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
    val adminScreenViewModel by remember { mutableStateOf(AdminViewModel(repository = AdminRepositoryImpl())) }
    val medicalStaffViewModel by remember { mutableStateOf(MedicalStaffViewModel(navigation=navigation)) }
    val viewRecordPageViewModel by remember { mutableStateOf(ViewRecordPageViewModel(navigation = navigation)) }

    ChildStack(
        source = navigation,
        initialStack = { listOf(Screen.Login(null)) },
        handleBackButton = true,
        animation = stackAnimation(fade())
    ){screen ->

        when(screen){
            is Screen.DoctorHome -> DoctorHomePage(medicalStaff = screen.staff, viewModel = medicalStaffViewModel)
            is Screen.AdminHome -> AdminHomePage(admin = screen.staff, viewModel = adminScreenViewModel)
//            is Screen.Login -> AboutUsPage()
            is Screen.Login -> LoginScreen(modifier = Modifier.fillMaxSize(), viewModel = loginScreenViewModel)
            is Screen.ViewRecordPage -> ViewRecordPage(staff = screen.staff, viewModel = viewRecordPageViewModel)
            is Screen.InsertRecordPage -> InsertRecordPage(viewModel = medicalStaffViewModel)
        }

    }
}
