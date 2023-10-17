package presentation.components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Divider
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.useResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@Composable
fun TopBar(
    modifier: Modifier=Modifier
){

    val image =useResource("vitascan_Logo.png"){

        loadImageBitmap(it)
    }


    NavigationBar(
        modifier = modifier
            .height(60.dp),
        containerColor = MaterialTheme.colors.primary,
        tonalElevation = 5.dp

    ){

        Column(
            modifier=Modifier
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                modifier = Modifier
                    .height(60.dp),
                bitmap = image,contentDescription = null,
                contentScale = ContentScale.FillHeight,)
        }



        NavBarTab("Home")
        Spacer(modifier=Modifier.width(10.dp))
        NavBarTab("Patients")




    }
}


@Composable
fun NavBarTab(tabName:String){
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
            color = MaterialTheme.colors.surface,
            fontWeight = FontWeight.W600
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

