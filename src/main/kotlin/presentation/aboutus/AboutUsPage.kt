package presentation.aboutus

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.useResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import domain.model.staff.Staff
import presentation.components.TopBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutUsPage(){

    Scaffold(

        topBar = { TopBar(staff = Staff(3,"fdsfds","fsdafds","dfasdf","1234567890","sdfsafd")) }
    ){

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(30.dp)
                .verticalScroll(state = rememberScrollState()),
        ){
            // Text Section

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Column(){

                    Text(
                        buildAnnotatedString {

                            withStyle(style = SpanStyle(fontSize = 25.sp,)){

                                withStyle(
                                    style = ParagraphStyle(textAlign = TextAlign.Left)
                                ){
                                    append("Vitascan is a revolutionary windows application that harnesses the power of\n")
                                    append("artificial intelligence and computer vision to detect diseases early and accurately.\n")
                                    append("Our mission is to make healthcare more for everyone and we believe that vitascan\n")
                                    append("has the potential to change the way diseases are diagnosed and treated.\n\n")

                                    withStyle(style = SpanStyle(fontWeight =  FontWeight.SemiBold, fontSize = 30.sp)){

                                        append("Here are some of thr benefits of using Vitascan:\n")
                                    }


                                    withStyle(SpanStyle(textDecoration = TextDecoration.None)){
                                        append("\u2022 Early detection: Vitascan can detect diseases early, when they are most treatable.\n")
                                        append("\u2022 Accuracy: Vitascan is highly accurate in detecting diseases.\n")
                                        append("\u2022 Convenience: Vitascan is easy to use and can be used from anywhere.\n")
                                        append("\u2022 Affordability: Vitascan is affordable and accessible to everyone.\n")
                                    }



                                }

                            }
                        }
                    )
                }
                Column(
                    modifier =Modifier
                        .height(300.dp)
                        .width(550.dp)
                        .background(Color.Transparent)

                ) {
                    Card(
                        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
                        modifier = Modifier
                            .height(300.dp)
                            .width(550.dp)
                    ) {

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ){
                            val logo = useResource("vitascan_Logo (2).png"){

                                loadImageBitmap(it)
                            }

                            Image(bitmap = logo,contentDescription = null, modifier = Modifier.size(290.dp))

                            Spacer(modifier = Modifier.width(20.dp))

                            Column(
                                modifier = Modifier,
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {

                                Text(
                                    buildAnnotatedString {
                                        withStyle(style = SpanStyle(color = MaterialTheme.colors.primaryVariant, fontSize =60.sp)){
                                            append("VitaScan\n")
                                            withStyle(style = SpanStyle(fontSize = 20.sp)){
                                                append("    AI & Computer Vision")
                                            }
                                        }
                                    }
                                )

                            }
                        }

                    }
                }



            }

            //Lower part

            Text(
                buildAnnotatedString {

                    withStyle(style = SpanStyle(fontSize = 25.sp)){
                        append("Vitascan is a valuable tool for anyone who wants to take control of their health. By detecting diseases early, Vitascan can help you get the treatment you need sooner, which can improve your chances of a full recovery.\n")
                        append("If you are looking for a way to take control of your health, Vitascan is the perfect solution for you.")
                    }
                }
            )

            Spacer(modifier = Modifier.height(20.dp))


            // photos

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ){
                        photosAboutUs(imageAddress = "vitascan_Logo (2).png", fullName = "Ronit Khalate","asdsdasd","Software Developer")
                        photosAboutUs(imageAddress = "vitascan_Logo (2).png", fullName = "Ronit Khalate","asdsdasd","Software Developer")
                        photosAboutUs(imageAddress = "vitascan_Logo (2).png", fullName = "Ronit Khalate","asdsdasd","Software Developer")
                    }
                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ){
                        photosAboutUs(imageAddress = "vitascan_Logo (2).png", fullName = "Ronit Khalate","asdsdasd","Software Developer")
                        photosAboutUs(imageAddress = "vitascan_Logo (2).png", fullName = "Ronit Khalate","asdsdasd","Software Developer")
                        photosAboutUs(imageAddress = "vitascan_Logo (2).png", fullName = "Ronit Khalate","asdsdasd","Software Developer")
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ){
                        photosAboutUs(imageAddress = "vitascan_Logo (2).png", fullName = "Ronit Khalate","asdsdasd","Software Developer")
                    }
                }


        }
    }

}


@Preview
@Composable
fun photosAboutUs(imageAddress:String,fullName:String,mail:String,job:String){

    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Card(
            modifier = Modifier,
            colors = CardDefaults.cardColors(containerColor = Color.Transparent),
            border = BorderStroke(width = 1.dp, color = MaterialTheme.colors.primary)
        ){
            val photo= useResource(imageAddress){

                loadImageBitmap(it)
            }

            Image(
                modifier = Modifier
                    .size(250.dp),
                bitmap = photo,
                alignment = Alignment.Center,
                contentScale = ContentScale.FillBounds,
                contentDescription = null)
        }

        Spacer(modifier = Modifier.height(10.dp))
        Text(text = fullName, style = MaterialTheme.typography.h6)
        Spacer(modifier = Modifier.height(3.dp))
        Text(text = job, style = MaterialTheme.typography.subtitle2)
        Spacer(modifier = Modifier.height(3.dp))
        Text(text = mail, style = MaterialTheme.typography.body2)
    }
}



@Composable
@Preview
private fun preview(){
    AboutUsPage()
//    photosAboutUs(imageAddress = "vitascan_Logo (2).png", fullName = "Ronit Khalate","asdsdasd","Software Developer")
}