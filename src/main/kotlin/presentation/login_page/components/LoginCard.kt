package presentation.login_page.components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import presentation.login_page.LoginScreenViewModel
import java.awt.TextField


@Composable
fun LoginCard(
    modifier: Modifier=Modifier,
    onLoginIdValueChange:(String)->Unit,
    onLoginPasswordValueChange:(String)->Unit,
    onLoginAsAdminCheckedChange:(Boolean)->Unit,
    onLogin:()->Unit,
    loginIdValue:String,
    loginPasswordValue:String,
    loginAsAdminValue:Boolean

){

    Card(
        modifier=modifier,
        elevation = 4.dp,
        shape = RoundedCornerShape(10.dp),
        backgroundColor = Color.Transparent
    ){

        Row(
            modifier=Modifier
                .fillMaxSize(),
        ){

            Column(
                modifier=Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                Text(
                    "Health \nStart Here",
                    fontSize = 60.sp,
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Black,
                    color = MaterialTheme.colorScheme.surface
                )


            }

            Column(
                modifier=Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,

            ){

                Text(
                    "Hello! WelCome Back",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp
                    )

                Spacer(modifier=Modifier.heightIn(40.dp))
                OutlinedTextField(
                    value=loginIdValue,
                    onValueChange = onLoginIdValueChange,
                    label = { Text("Login Id") },
                    leadingIcon = {Icons.Filled.Person}
                )

                Spacer(modifier=Modifier.heightIn(20.dp))
                OutlinedTextField(
                    value=loginPasswordValue,
                    onValueChange = onLoginPasswordValueChange,
                    label = { Text("Login Id") },
                    leadingIcon = {Icons.Filled.Person},
                    trailingIcon = {Icons.Filled.Person}
                )


                Spacer(modifier=Modifier.height(10.dp))
                Row(
                    modifier=Modifier
                        .width(290.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Checkbox(
                        onCheckedChange = onLoginAsAdminCheckedChange,
                        checked = loginAsAdminValue

                    )
                    Spacer(modifier=Modifier.width(20.dp))

                    Text("Log In As Admin" , style = MaterialTheme.typography.titleSmall, color =androidx.compose.material.MaterialTheme.colors.secondary)
                }

                Spacer(modifier=Modifier.height(20.dp))

                Button(
                    modifier=Modifier
                        .width(250.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colorScheme.primary
                    ),
                    onClick = onLogin
                ){
                    Text("Log in")
                }










            }
        }
    }


}



@Composable
@Preview
fun LoginCardPre(){
//    LoginCard(modifier = Modifier)
}
