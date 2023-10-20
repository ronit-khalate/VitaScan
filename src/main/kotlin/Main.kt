import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.LocalScrollbarStyle
import androidx.compose.foundation.defaultScrollbarStyle
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetbrains.lifecycle.LifecycleController
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.example.compose.LightColors
import navigation.ChildStack
import navigation.ProvideComponentContext
import navigation.Screen
import presentation.admin_home_page.AdminHomePage
import presentation.login_page.LoginScreen
import presentation.login_page.LoginScreenViewModel
import presentation.view_record_page.ViewRecordPage


@OptIn(ExperimentalDecomposeApi::class)
fun main() {

    val lifecycle = LifecycleRegistry()
    val rootComponentContext = DefaultComponentContext(lifecycle=lifecycle)
    application {

       val windowState = rememberWindowState()
        LifecycleController(lifecycle,windowState)
        Window(onCloseRequest = ::exitApplication) {



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
    val loginScreenViewModel by remember { mutableStateOf(LoginScreenViewModel(navigation = navigation)) }

    ChildStack(
        source = navigation,
        initialStack = { listOf(Screen.AdminHome) },
        handleBackButton = true,
        animation = stackAnimation(fade())
    ){screen ->

        when(screen){
            is Screen.AdminHome -> AdminHomePage()
            is Screen.Login -> LoginScreen(modifier = Modifier.fillMaxSize(), viewModel = loginScreenViewModel)
            is Screen.StaffHome -> ViewRecordPage()
        }

    }
}
