package presentation.view_record_page

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn


import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import domain.model.staff.Staff

import presentation.components.TopBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ViewRecordPage(
    staff:Staff
){



    Scaffold(

        topBar = { TopBar(staff=staff,isBackButtonVisible = true) }
    ){

        TableBackgroundAndSearchBar(paddingValue = it)

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TableBackgroundAndSearchBar(
    paddingValue:PaddingValues= PaddingValues(0.dp)
){
    Column(
        modifier = Modifier
            .padding(paddingValue)
            .fillMaxSize(),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        //Search Bar
        OutlinedTextField(
            modifier = Modifier
                .width(500.dp),
            value = "",
            colors = TextFieldDefaults.textFieldColors(containerColor = MaterialTheme.colors.surface),
            onValueChange = {},
            label = {
                Text("      Search By PID", fontWeight = FontWeight.SemiBold)
            },
            trailingIcon = {
                Icon(
                    modifier = Modifier
                        .clickable {  },
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search"

                )
            },
            shape = RoundedCornerShape(30.dp)

        )

        Spacer(modifier = Modifier.height(20.dp))

        // View

        Card(
            modifier = Modifier
                .width(810.dp)
                .height(510.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colors.primaryVariant)

        ){

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Card(
                    modifier = Modifier
                        .width(800.dp)
                        .height(500.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colors.background)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){


                        if (true){
                            TableContent()
                        }
                        else{

                            Text("No Record Found ", style = MaterialTheme.typography.h3,)
                        }

                    }
                }
            }






        }



    }
}

@Composable
fun TableContent(){

    var recordRowColor=MaterialTheme.colors.secondary;
    var recordRowColorFlag=true
    Column(
        modifier = Modifier
            .width(700.dp)
            .padding(start = 5.dp)
    ){
        Row(

        ) {

            Text(
                text = "Patient ID       :",
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.Bold
            )
            Text("")
        }

        Spacer(modifier = Modifier.height(5.dp))

        Row {

            Text(
                text="Patient Name :",
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.Bold
            )
            Text("")
        }
    }

    Spacer(modifier = Modifier.height(10.dp))

    // Table Starting

    Card(
        modifier = Modifier
            .width(700.dp)
            .height(400.dp),
        shape = RectangleShape,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colors.secondary),
        border = BorderStroke(width = 1.dp, color = MaterialTheme.colors.onBackground)
    ){

        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            userScrollEnabled = true
        ){

            item {
                RecordRow(
                    modifier = Modifier.fillMaxWidth(),
                    column = listOf("Sr No","Date","Record No","Staff ID"),
                    color = MaterialTheme.colors.primary
                )
            }
            items(100){

                if(recordRowColorFlag){
                    recordRowColor=MaterialTheme.colors.secondary
                    recordRowColorFlag=false
                }
                else{
                    recordRowColor=MaterialTheme.colors.background
                    recordRowColorFlag=true
                }
                RecordRow(
                    modifier = Modifier.fillMaxWidth(),
                    column = listOf("Sr No","Date","Record No","Staff Id"),
                    color = recordRowColor
                )
            }
        }
    }
}


@Composable
@Preview
private fun Preview(){
    ViewRecordPage(staff = Staff(23,"","","","",""))
}
