package presentation.login_page.components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.useResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun LoginCard(
    modifier: Modifier=Modifier,
    onLoginIdValueChange:(String)->Unit,
    onLoginPasswordValueChange:(String)->Unit,
    onLoginAsAdminCheckedChange:(Boolean)->Unit,
    onLogin:()->Unit,
    loginIdValue:String,
    loginPasswordValue:String,

){

    Card(
        modifier=modifier,
        elevation = 10.dp,
        backgroundColor = androidx.compose.material.MaterialTheme.colors.background,
        border = BorderStroke(width = 2.dp, color = androidx.compose.material.MaterialTheme.colors.primary),
        shape = RoundedCornerShape(size = 30.dp)
    ){

        Row(
            modifier=Modifier
                .fillMaxSize(),
        ){

            Column(
                modifier=Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .weight(1f)
                ,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                val image = useResource("vitascan_Logo (2).png"){

                    loadImageBitmap(it)
                }

                Image(
                    bitmap = image,
                    contentDescription ="Logo Vitascan"
                )

                Spacer(modifier=Modifier.height(height = 30.dp))
                Text(
                    "VitaScan",
                    fontSize = 60.sp,
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Black,
                    color = androidx.compose.material.MaterialTheme.colors.primary                )


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
                    singleLine = true,
                    onValueChange = onLoginIdValueChange,
                    label = { Text("Login Id") },
                    leadingIcon = {Icons.Filled.Person},
                    shape = RoundedCornerShape(size = 20.dp)
                )

                Spacer(modifier=Modifier.heightIn(20.dp))
                OutlinedTextField(
                    value=loginPasswordValue,
                    singleLine = true,
                    onValueChange = onLoginPasswordValueChange,
                    label = { Text("Password") },
                    leadingIcon = {Icons.Filled.Person},
                    trailingIcon = {Icons.Filled.Person},
                    shape = RoundedCornerShape(size = 20.dp)
                )


                Spacer(modifier=Modifier.height(10.dp))


                Spacer(modifier=Modifier.height(20.dp))

                Button(
                    modifier=Modifier
                        .width(250.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = androidx.compose.material.MaterialTheme.colors.primary
                    ),
                    onClick = onLogin
                ){
                    Text("Log in", color = androidx.compose.material.MaterialTheme.colors.background)
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
