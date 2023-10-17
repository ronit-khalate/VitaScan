package presentation.admin_home_page

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import presentation.components.TopBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminHomePage(modifier:Modifier=Modifier){

    Scaffold(
        modifier=modifier,
        topBar = {TopBar(modifier=Modifier)}

    ){

        Column(
            modifier=Modifier
                .fillMaxSize()
                .padding(it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            OutlinedTextField(
                modifier = Modifier,
                value = "",
                onValueChange = {},
                label = { Text("Enter Staff Name") }
            )

            OutlinedTextField(
                    modifier = Modifier
                        .padding(it),
                    value = "",
                    onValueChange = {}
            )


            Button(
                onClick = {},
                enabled = false,
                colors=ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.primary
                )
            ){
                Text("Add Staff", color = MaterialTheme.colors.onPrimary)
            }

        }

    }

}

@Preview
@Composable
fun AdminHomePagePreview(){
    AdminHomePage()
}