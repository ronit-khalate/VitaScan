package presentation.admin_home_page.popups


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*


import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import presentation.admin_home_page.AdminViewModel


@Composable
fun UpdateDocForm(
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

            UpDateDocFormRow(
                keyBordAction = {
                    print("In Key board Action")
                    viewModel.loadDoc(viewModel.updateDocStaffId) },
                enabled = true,
                inputType = "Staff ID",
                label = "Enter Staff Id",
                value = viewModel.updateDocStaffId
            ){viewModel.updateDocStaffId=it}

            Spacer(modifier = Modifier.height(15.dp))
            UpDateDocFormRow(
                enabled = false,
                inputType = "First Name",
                label = "First Name",
                value = viewModel.updateDocFirstName
            ){}

            Spacer(modifier = Modifier.height(15.dp))
            UpDateDocFormRow(
                enabled = false,
                inputType = "Last Name",
                label = "last Name",
                value=viewModel.updateDocLastName
            ){}

            Spacer(modifier = Modifier.height(15.dp))
            UpDateDocFormRow(
                enabled = true,
                inputType = "Mobile No",
                label = " Mobile Number",
                value = viewModel.updateDocMobile
            ){viewModel.updateDocMobile=it}

            Spacer(modifier = Modifier.height(15.dp))
            UpDateDocFormRow(
                enabled = false,
                inputType = "Old Password",
                label = "Old Password",
                value = viewModel.updateDocOldPassword
            ){}

            Spacer(modifier = Modifier.height(15.dp))
            UpDateDocFormRow(
                enabled = true,
                inputType = "New Password",
                label = "Enter New Password",
                value = viewModel.updateDocNewPassword
            ){viewModel.updateDocNewPassword=it}
            Spacer(modifier = Modifier.height(15.dp))

            Row(
                modifier = Modifier
                    .height(60.dp)
            ) {

                TextButton(
                    onClick = viewModel::onUpdate,
                    modifier = Modifier
                        .width(120.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colors.primary),
                    shape = RoundedCornerShape(20.dp),
                ) {
                    Text("Update", style = MaterialTheme.typography.button)
                }



            }
        }


    }




}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpDateDocFormRow(
    modifier: Modifier= Modifier,
    keyBordAction:()->Unit={},
    inputType:String,
    label: String,
    value:String,
    enabled:Boolean=true,
    onValueChange:(String)->Unit
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
            modifier = modifier
                .fillMaxWidth(),
            enabled = enabled,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(onDone={keyBordAction()}),
            singleLine = true,
            value = value,
            onValueChange = onValueChange,
            shape = RoundedCornerShape(20.dp),
            label={ Text(text = label) }



        )
    }
}

//@Composable
//@Preview
//private fun Preview(){
//    AdminForm(modifier = Modifier.height(610.dp).width(510.dp)){}
////    row("Staff ID","Enter Staff Id")
//}