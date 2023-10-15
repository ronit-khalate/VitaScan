import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.example.compose.LightColors
import presentation.login_page.LoginScreen
import presentation.login_page.LoginScreenViewModel

@Composable
@Preview
fun App() {
    val loginScreenViewModel by remember { mutableStateOf(LoginScreenViewModel()) }

    MaterialTheme(
        colors = LightColors
    ) {
       LoginScreen(modifier = Modifier.fillMaxSize(), viewModel = loginScreenViewModel)
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
