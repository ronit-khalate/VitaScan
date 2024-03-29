package presentation.admin_home_page.popups

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*


import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import presentation.admin_home_page.AdminViewModel
import presentation.admin_home_page.utils.ValidationError


@Composable
fun AddDocForm(
    modifier: Modifier = Modifier
        .height(610.dp)
        .width(510.dp),
    viewModel: AdminViewModel,
    onCardClose: () -> Unit,
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

                AddDocFormRow("First Name", "Enter First Name", value = viewModel.addDocFirstName){viewModel.addDocFirstName=it}
                Spacer(modifier = Modifier.height(15.dp))
                AddDocFormRow("Last Name", "Enter last Name",value=viewModel.addDocLastName){viewModel.addDocLastName=it}
                Spacer(modifier = Modifier.height(15.dp))
                AddDocFormRow("Mobile No", "Enter Mobile Number", value = viewModel.addDocMobileNumber){viewModel.addDocMobileNumber=it}
                Spacer(modifier = Modifier.height(15.dp))
                AddDocFormRow("Password", "Enter Password", value = viewModel.addDocPassword){viewModel.addDocPassword=it}
                Spacer(modifier = Modifier.height(15.dp))

                Row(
                    modifier = Modifier
                        .height(60.dp)
                ) {

                        TextButton(
                            onClick = viewModel::onAddDoc,
                            modifier = Modifier
                                .width(120.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colors.primary),
                            shape = RoundedCornerShape(20.dp),
                        ) {
                            Text("Add", style = MaterialTheme.typography.button)
                        }



                }
            }


        }




}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddDocFormRow(
    inputType:String,
    label: String,
    value:String,
    onValueChange:(String)->Unit,

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
            value = value,
            onValueChange = onValueChange,
            shape = RoundedCornerShape(20.dp),
            label={ Text(text = label) },
            supportingText = { Text("", color = MaterialTheme.colors.error) }



        )
    }
}

//@Composable
//@Preview
//private fun Preview(){
//    AdminForm(modifier = Modifier.height(610.dp).width(510.dp)){}
////    row("Staff ID","Enter Staff Id")
//}