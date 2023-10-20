package presentation.admin_home_page

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.useResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.Window
import presentation.components.TopBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminHomePage(modifier:Modifier=Modifier){

    var isAddStaffFormVisible: Boolean by remember { mutableStateOf(false) }
    var isUpdateStaffFormVisible: Boolean by remember { mutableStateOf(false) }
    var isViewRecordStaffFormVisible: Boolean by remember { mutableStateOf(false) }
    Scaffold(
        modifier=modifier,
        topBar = {TopBar(modifier=Modifier)}

    ){

        Box(
            modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ){


            Column(
                modifier=Modifier
                    .padding(it),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){

                Row(
                    modifier=Modifier
                        .weight(0.5f)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center

                ){
                    Box(
                        modifier=Modifier
                            .fillMaxHeight(),
                        contentAlignment = Alignment.Center
                    )
                    {

                        Text("ADMIN PORTAL", fontSize = 40.sp, fontWeight = FontWeight.SemiBold)
                    }
                }

                Row(
                    modifier = Modifier
                        .weight(2f)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {

                    AdminCard(description = "Add Staff", icon = Icons.Filled.Add){isAddStaffFormVisible=true}
                    AdminCard(description = "Update Staff", icon =Icons.Default.Edit){}
                    AdminCard(description = "View Records", icon = Icons.Default.Person){}

                }
            }

            if(isAddStaffFormVisible){
                AdminForm{isAddStaffFormVisible=false}
            }


        }



    }

}


@Composable
fun AdminCard(
    icon: ImageVector,
    description: String="Add Staff",
    onAddStaffClick:()->Unit
){



        Card(
            modifier = Modifier
                .width(320.dp)
                .height(320.dp)
                .clickable{(onAddStaffClick())},
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colors.primaryVariant)
        ){

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Card(
                    modifier = Modifier
                        .width(310.dp)
                        .height(310.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colors.background)
                ){
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Card(
                            modifier = Modifier
                                .width(300.dp)
                                .height(300.dp),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colors.background),
                            border = BorderStroke(color = MaterialTheme.colors.onSurface, width = 1.dp)
                        ){
                            Box(
                                modifier = Modifier
                                    .fillMaxSize(),
                                contentAlignment = Alignment.Center

                            ){
                                CardBackGround(description = description)

                                Box(
                                    modifier = Modifier
                                        .size(60.dp)
                                        .clip(shape = CircleShape)
                                        .border(width = 1.dp, color = MaterialTheme.colors.onBackground, shape = CircleShape)
                                        .background(color = MaterialTheme.colors.background),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(

                                        imageVector = icon,
                                        contentScale = ContentScale.FillBounds,
                                        contentDescription = null
                                    )

                                }

                            }
                        }
                    }
                }
            }




        }


}


@Composable
fun CardBackGround(
    modifier: Modifier=Modifier.fillMaxSize(),
    description:String
){

    Column(
        modifier=modifier,
    ) {

        Row(
            modifier=Modifier
                .background(color = MaterialTheme.colors.primaryVariant)
                .fillMaxWidth()
                .weight(1f)

        ){

        }

        Row(
            modifier=Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            Text(text = description, style = MaterialTheme.typography.body1, fontWeight = FontWeight.Bold, fontSize = 26.sp)
        }
    }
}

@Preview
@Composable
fun AdminHomePagePreview(){
    AdminHomePage()
}