package presentation.admin_home_page

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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import domain.model.staff.Staff
import domain.util.AdminPopup
import presentation.admin_home_page.popups.AdminViewTable
import presentation.components.TopBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminHomePage(
    modifier:Modifier=Modifier,
    viewModel: AdminViewModel,
    admin:Staff
){



    Scaffold(
        modifier=modifier,
        topBar = {TopBar(staff = admin, modifier=Modifier)}

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

                    AdminCard(description = "Add Staff", icon = Icons.Filled.Add){viewModel.popWindowState=AdminPopup.AddStaffForm}
                    AdminCard(description = "Update Staff", icon =Icons.Default.Edit){viewModel.popWindowState=AdminPopup.UpdateStaffForm}
                    AdminCard(description = "View Records", icon = Icons.Default.Person){viewModel.popWindowState=AdminPopup.ViewRecord}

                }
            }

            when(viewModel.popWindowState){

                AdminPopup.AddStaffForm -> AdminForm(staffState = null){viewModel.popWindowState=null}
                AdminPopup.UpdateStaffForm -> AdminForm(staffState =Staff(id = 0, userid = "testID", firstName = "test", lastName = "test", passWord = "ada")){viewModel.popWindowState=null}
                AdminPopup.ViewRecord -> AdminViewTable{viewModel.popWindowState=null}
                null -> {}
            }


        }



    }

}


@Composable
fun AdminCard(
    icon: ImageVector,
    description: String="Add Staff",
    onCardClick:()->Unit
){



        Card(
            modifier = Modifier
                .width(320.dp)
                .height(320.dp)
                .clickable{(onCardClick())},
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

//@Preview
//@Composable
//fun AdminHomePagePreview(){
//    AdminHomePage(admin = Staff(23,"","","",""),)
//}