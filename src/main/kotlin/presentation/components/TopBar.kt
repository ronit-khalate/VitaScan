package presentation.components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.useResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun TopBar(
    modifier: Modifier=Modifier
){

    val image =useResource("vitascan_Logo (2).png"){

        loadImageBitmap(it)
    }


    NavigationBar(
        modifier = modifier
            .height(60.dp),
        containerColor = MaterialTheme.colors.background,
        tonalElevation = 20.dp,


    ){

        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {


            // Logo
            Row(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start

            ){

                Image(
                    bitmap = image,
                    contentDescription = null,
                    modifier=Modifier
                        .size(100.dp)
                )
                Spacer(modifier=Modifier.width(0.dp))
                Text(
                    text="VitaScan",
                    style = MaterialTheme.typography.body2,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp
                    )
            }


            Row(
                modifier = Modifier
                    .weight(2f)
                    .background(Color.Transparent),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                NavBarTab(tabName = "Home", onClick = {})
                Spacer(modifier=Modifier.width(60.dp))
                NavBarTab(tabName = "About Us", onClick = {})
            }



            Row(
                modifier=Modifier
                    .background(MaterialTheme.colors.primary)
                    .fillMaxHeight()
                    .width(350.dp)
                    .padding(end = 7.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End

            ) {

                Box(
                    modifier=Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colors.background)
                        .clickable {  },
                    contentAlignment = Alignment.Center
                ){

                    Text("S", fontWeight = FontWeight.SemiBold, fontSize = 30.sp)

                }
            }
        }


    }
}


@Composable
fun NavBarTab(
    tabName:String,
    onClick:()-> Unit
){
    Column(
        modifier=Modifier
            .fillMaxHeight()
            .width(70.dp)
            .background(
            brush = Brush.horizontalGradient(
                colors = listOf( Color(0xEFE9F4),Color(0x5078F2)),
                startX = 0f,
                endX = 3f
            )
        ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = tabName,
            style = MaterialTheme.typography.body2,
            color = MaterialTheme.colors.onBackground,
            fontWeight = FontWeight.Bold
        )



    }
}

@Composable
fun SelectedBottomBorder(modifier: Modifier){

    Divider(
        modifier = modifier,
        thickness = 3.dp,
        color = MaterialTheme.colors.onPrimary,
    )
}



@Preview
@Composable
fun TopBarPreview(){

    TopBar()
}

