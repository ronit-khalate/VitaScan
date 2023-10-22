package presentation.login_page

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.router.stack.StackNavigation
import data.repository.LoginRepository
import presentation.login_page.components.LoginCard
import presentation.login_page.components.LoginPageBackground

@Composable
fun LoginScreen(
    viewModel: LoginPageViewModel,
    modifier: Modifier=Modifier,
){

    Box(
        modifier=modifier,
        contentAlignment = Alignment.Center
    ){
        LoginPageBackground(modifier=modifier)
        LoginCard(
            modifier=Modifier
                .fillMaxWidth(0.6f)
                .fillMaxHeight(0.65f)
                .clip(shape = RoundedCornerShape(30.dp)),
            onLoginIdValueChange ={viewModel.loginId=it},
            onLoginPasswordValueChange = {viewModel.password=it},
            onLoginAsAdminCheckedChange = {},
            onLogin = viewModel::login,
            loginIdValue = viewModel.loginId,
            loginPasswordValue = viewModel.password,

        )

    }


}


@Composable
@Preview
fun LoginPreview(){
    LoginScreen(modifier = Modifier.fillMaxSize(), viewModel = LoginPageViewModel(repository = LoginRepository(), navigation = StackNavigation()))
}