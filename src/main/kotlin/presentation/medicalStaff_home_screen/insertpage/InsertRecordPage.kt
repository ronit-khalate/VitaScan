package presentation.medicalStaff_home_screen.insertpage

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import domain.model.staff.Staff
import presentation.components.TopBar
import presentation.medicalStaff_home_screen.MedicalStaffViewModel
import util.OpenFileDialog
import java.net.URI
import java.nio.file.LinkOption
import java.nio.file.Path
import kotlin.io.path.exists
import kotlin.io.path.toPath

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Preview
@Composable
 fun InsertRecordPage(
     viewModel: MedicalStaffViewModel
 ){

     Scaffold(
         modifier = Modifier
             .fillMaxSize(),

         topBar = { TopBar(staff = Staff(3,"fdsfds","fsdafds","dfasdf","1234567890","sdfsafd")) }
     ){
         Column(
             modifier = Modifier
                 .fillMaxSize()
                 .padding(it),
             verticalArrangement = Arrangement.Center,
             horizontalAlignment = Alignment.CenterHorizontally,

         ){
             Card (
                 modifier = Modifier
                     .width(640.dp)
                     .fillMaxHeight(0.96f),
                 colors = CardDefaults.cardColors(containerColor = MaterialTheme.colors.background),
                 elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                 border = BorderStroke(width = 1.dp, color = MaterialTheme.colors.primary)

             ){


                 Column(
                     modifier = Modifier
                         .fillMaxSize(),
                     verticalArrangement = Arrangement.Center,
                     horizontalAlignment = Alignment.CenterHorizontally
                 ){

                     Row(
                         modifier = Modifier
                             .fillMaxWidth(0.6f)
                             .height(80.dp),
                         verticalAlignment = Alignment.CenterVertically,
                         horizontalArrangement = Arrangement.SpaceBetween,

                         ){

                         OutlinedTextField(
                             value = viewModel.pid,
                             label = { Text(text = "Enter PID") },
                             onValueChange = {viewModel.pid=it},
                             singleLine = true,
                             shape = RoundedCornerShape(size = 30.dp),
                             leadingIcon = { Image(imageVector =  Icons.Filled.Person,contentDescription = null) }
                         )

                         OutlinedButton(
                             onClick = {},
                             shape = RoundedCornerShape(size = 20.dp),
                         ){
                             Text(text = "Submit")
                         }

                     }

                     // choose disease
                     Card(
                         modifier = Modifier
                             .width(width = TextFieldDefaults.MinWidth+10.dp)
                             .height(50.dp)
                             .clickable {  },
                         shape = RoundedCornerShape(size = 20.dp),
                         border = BorderStroke(width = 1.dp, color = MaterialTheme.colors.onBackground)
                     ){

                         Row(
                             modifier = Modifier
                                 .fillMaxSize()
                                 .padding(start = 10.dp,end=10.dp),
                             verticalAlignment = Alignment.CenterVertically,
                             horizontalArrangement = Arrangement.SpaceBetween
                         ){

                             //Spacer(modifier = Modifier.width(width = 5.dp))
                             Text(text = "Choose The Disease")
                             Image(imageVector = Icons.Filled.ArrowDropDown,contentDescription = null)
                             //Spacer(modifier = Modifier.width(width = 5.dp))
                         }
                     }

                     Spacer(modifier = Modifier.height(20.dp))

                     // PID
                     Row(
                         modifier = Modifier
                             .width(450.dp),
                         verticalAlignment = Alignment.CenterVertically,
                         horizontalArrangement = Arrangement.Center
                     ){

                         Text(text = "PID", style = MaterialTheme.typography.h6)

                         Spacer(modifier = Modifier.width(97.dp))

                         OutlinedTextField(
                             modifier = Modifier
                                 .fillMaxWidth(),
                             value = viewModel.pid,
                             onValueChange = {viewModel.pid=it},
                             shape = RoundedCornerShape(20.dp),
                             label={ Text(text = "Enter PID") },
                             supportingText = { Text("", color = MaterialTheme.colors.error) }



                         )
                     }

                     // First Name
                     Row(
                         modifier = Modifier
                             .width(450.dp),
                         verticalAlignment = Alignment.CenterVertically,
                         horizontalArrangement = Arrangement.Center
                     ){

                         Text(text = "First Name", style = MaterialTheme.typography.h6)

                         Spacer(modifier = Modifier.width(30.dp))

                         OutlinedTextField(
                             modifier = Modifier
                                 .fillMaxWidth(),
                             value = viewModel.firstName,
                             onValueChange = {viewModel.firstName=it},
                             shape = RoundedCornerShape(20.dp),
                             label={ Text(text = "Enter First Name") },
                             supportingText = { Text("", color = MaterialTheme.colors.error) }



                         )
                     }

                     // Last Name
                     Row(
                         modifier = Modifier
                             .width(450.dp),
                         verticalAlignment = Alignment.CenterVertically,
                         horizontalArrangement = Arrangement.Center
                     ){

                         Text(text = "Last Name ", style = MaterialTheme.typography.h6)

                         Spacer(modifier = Modifier.width(30.dp))

                         OutlinedTextField(
                             modifier = Modifier
                                 .fillMaxWidth(),
                             value = viewModel.lastName,
                             onValueChange = {viewModel.lastName=it},
                             shape = RoundedCornerShape(20.dp),
                             label={ Text(text = "Enter Last Name") },
                             supportingText = { Text("", color = MaterialTheme.colors.error) }



                         )
                     }
                     val dragAndDropModifie =Modifier.padding(horizontal = 4.dp, vertical = 4.dp)
                     DragAndDropFileBox(
                         modifier = dragAndDropModifie
                             .size(height = 250.dp, width = 450.dp),
                         viewModel=viewModel
                     ){dragData->
                         if (dragData is DragData.FilesList) {
                             val newFiles= dragData.readFiles().mapNotNull {
                                 URI(it).toPath().takeIf { it.exists(LinkOption.NOFOLLOW_LINKS) }
                             }
                             viewModel.selectedImages = (viewModel.selectedImages + newFiles).distinct()
                         }
                     }

                     OutlinedButton(
                         onClick = {},
                     ){
                         Text("Scan")
                     }
                 }
             }
         }
     }





 }

private object Colors {
    val default = Color.Gray
    val active = Color(29, 117, 223, 255)
    val fileItemBg = Color(233, 30, 99, 255)
    val fileItemFg = Color.White
}
@Composable
private fun FileListView(modifier: Modifier = Modifier, files: List<Path>,viewModel: MedicalStaffViewModel) {

    LazyColumn(modifier) {
        items(files){
            Box(
                Modifier.padding(bottom = 5.dp)
                    .background(
                        Colors.fileItemBg, shape = RoundedCornerShape(100.dp)
                    )
            ) {
               Row{
                    Text(
                        text = it.fileName.toString(),
                        color = Colors.fileItemFg,
                        modifier = Modifier.padding(5.dp),
                        fontSize = 14.sp,
                    )
                   Spacer(modifier=Modifier.width(10.dp))

                   Image(
                       modifier=Modifier
                           .clickable { viewModel.onRemoveSelectedFile(it) },
                       imageVector = Icons.Filled.Close,
                       contentDescription = null

                   )

                }

            }
        }
    }
}



@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun DragAndDropFileBox(modifier: Modifier = Modifier,viewModel: MedicalStaffViewModel, onDrop: (DragData) -> Unit) {
    var isDragging by remember { mutableStateOf(false) }
    val dragNDropColor = if (isDragging) Colors.active else Colors.default

    Box(
        modifier = modifier
            .dashedBorder(color = dragNDropColor, strokeWidth = 2.dp, cornerRadiusDp = 8.dp)
            .onExternalDrag(
                onDragStart = { isDragging = true  },
                onDragExit = { isDragging = false },
                onDrop = { value ->
                    isDragging = false
                    onDrop(value.dragData)
                })
    ) {
        Column(modifier = Modifier.align(Alignment.Center)) {

            if(viewModel.selectedImages.isEmpty()){
                DragAndDropDescription(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    color = dragNDropColor
                )
            }
            else{
                FileListView(files = viewModel.selectedImages, viewModel = viewModel)
            }

        }
    }
}

@Composable
fun DragAndDropDescription(modifier: Modifier, color: Color) {
    val modifier = modifier.padding(vertical = 2.dp)

    OutlinedButton(
        onClick = { OpenFileDialog {  }},

    ){
        Text(text ="Select Images")
    }

    Spacer(modifier = Modifier.height(30.dp))
    Text(
        "Drag & drop files here",
        fontSize = 14.sp,
        modifier = modifier,
        color = color
    )
}

fun Modifier.dashedBorder(strokeWidth: Dp, color: Color, cornerRadiusDp: Dp) = composed(
    factory = {
        val density = LocalDensity.current
        val strokeWidthPx = density.run { strokeWidth.toPx() }
        val cornerRadiusPx = density.run { cornerRadiusDp.toPx() }

        then(
            Modifier.drawWithCache {
                onDrawBehind {
                    val stroke = Stroke(
                        width = strokeWidthPx,
                        pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
                    )
                    drawRoundRect(
                        color = color,
                        style = stroke,
                        cornerRadius = CornerRadius(cornerRadiusPx)
                    )
                }
            }
        )
    }
)





@Composable
@Preview
private fun preview(){
//    InsertRecordPage()
}