package presentation.staff_home_screen

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.DragData
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.useResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import presentation.components.TopBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StaffHomePage(

    onViewRecordClick:()->Unit,
    onInsertClick:()->Unit
){

    Scaffold(

        topBar = { TopBar() }

    ){

        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            val image = useResource("vitascan_Logo (2).png"){

                loadImageBitmap(it)
            }


            //logo
            Image(bitmap = image,contentDescription = null)

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text="VitaScan",
                style = MaterialTheme.typography.body2,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )

            Spacer(modifier = Modifier.height(50.dp))

            Row(modifier = Modifier) {

                OutlinedButton(
                    modifier = Modifier
                        .width(120.dp),
                    onClick = onViewRecordClick,
                    border = BorderStroke(2.dp, color = MaterialTheme.colors.primary),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.outlinedButtonColors(backgroundColor = MaterialTheme.colors.onPrimary)

                ){

                    Text("View Record")
                }
                Spacer(modifier = Modifier.width(35.dp))
                Button(
                    modifier = Modifier
                        .width(120.dp),
                    onClick = onInsertClick,
                    shape = RoundedCornerShape(20.dp),

                ){
                    Text("Insert", color = MaterialTheme.colors.onPrimary)
                }
            }

        }
    }
}

@Composable
@Preview
fun StaffHomePreview(){
    StaffHomePage({},{})
}