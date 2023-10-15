package presentation.login_page

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import domain.viewmodel.Viewmodel
import presentation.login_page.components.LoginCard
import presentation.login_page.components.LoginPageBackground

@Composable
fun LoginScreen(
    viewModel: LoginScreenViewModel,
    modifier: Modifier=Modifier
){

    Box(
        modifier=modifier,
        contentAlignment = Alignment.Center
    ){
        LoginPageBackground(modifier=modifier)
        LoginCard(
            modifier=Modifier
            .fillMaxWidth(0.6f)
            .fillMaxHeight(0.65f),
            onLoginIdValueChange ={viewModel.loginId=it},
            onLoginPasswordValueChange = {viewModel.loginPassword=it},
            onLoginAsAdminCheckedChange = {viewModel.loginAsAdmin=it},
            onLogin = viewModel::Login,
            loginIdValue = viewModel.loginId,
            loginPasswordValue = viewModel.loginPassword,
            loginAsAdminValue = viewModel.loginAsAdmin
        )
        if(viewModel.showLoadingSpinner){
            CircularProgressIndicator(
                modifier=Modifier
                    .size(60.dp),
                strokeWidth = 5.dp

            )
        }
    }


}


@Composable
@Preview
fun LoginPreview(){
    LoginScreen(modifier = Modifier.fillMaxSize(), viewModel = LoginScreenViewModel())
}