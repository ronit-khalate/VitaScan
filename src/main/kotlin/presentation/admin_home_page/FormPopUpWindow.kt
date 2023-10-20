package presentation.admin_home_page

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*


import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState


@Composable
fun AdminForm(
    modifier: Modifier=Modifier
        .height(610.dp)
        .width(510.dp),
    onCardClose:()->Unit
){





        Card(
            modifier = modifier,
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colors.primaryVariant)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

            }
        }

        Card(
            modifier = Modifier.height(600.dp).width(500.dp)
            //        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colors.primaryVariant)
        ) {

            Row(
                modifier=Modifier
                    .padding(top = 20.dp, end = 20.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ){

                Image(
                    modifier=Modifier
                        .clickable { onCardClose() },
                    imageVector = Icons.Default.Close,
                    contentDescription = null
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .padding(paddingValues = PaddingValues(20.dp)),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {



                row("Staff Id", "Enter Staff ID")
                Spacer(modifier = Modifier.height(15.dp))
                row("Staff Id", "Enter Staff ID")
                Spacer(modifier = Modifier.height(15.dp))
                row("Staff Id", "Enter Staff ID")
                Spacer(modifier = Modifier.height(15.dp))
                row("Staff Id", "Enter Staff ID")
                Spacer(modifier = Modifier.height(15.dp))
                row("Staff Id", "Enter Staff ID")
                Spacer(modifier = Modifier.height(15.dp))

                Row(
                    modifier = Modifier
                        .height(60.dp)
                ) {

                    if (true) {
                        TextButton(
                            onClick = {},
                            modifier = Modifier
                                .width(120.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colors.primary),
                            shape = RoundedCornerShape(20.dp),
                        ) {
                            Text("Add", style = MaterialTheme.typography.button)
                        }
                    } else {
                        TextButton(
                            modifier = Modifier
                                .width(120.dp),
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colors.primary),
                            shape = RoundedCornerShape(20.dp),
                        ) {
                            Text("Update", style = MaterialTheme.typography.button)
                        }
                    }


                }
            }


        }




}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun row(
    inputType:String,
    label: String
){

    Row(
        modifier = Modifier
            .width(450.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){

        Text(text = inputType, style = MaterialTheme.typography.h6)

        Spacer(modifier = Modifier.width(30.dp))

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = "",
            onValueChange = {},
            shape = RoundedCornerShape(20.dp),
            label={ Text(text = label) }



        )
    }
}

@Composable
@Preview
private fun Preview(){
    AdminForm(modifier = Modifier.height(610.dp).width(510.dp)){}
//    row("Staff ID","Enter Staff Id")
}