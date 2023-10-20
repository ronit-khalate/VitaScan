package presentation.view_record_page

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.input.pointer.pointerMoveFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.useResource
import androidx.compose.ui.unit.dp


private val columnHeight=30.dp
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun RecordRow(
    modifier: Modifier=Modifier,
    column:List<String>,
    color: Color
){


        Row(
            modifier = modifier
                .background(color)
                .height(columnHeight)

        ){



            for(col in column){
                Divider(color = MaterialTheme.colors.onSurface, modifier = Modifier.fillMaxHeight().width(1.5.dp))
                Column(
                    modifier=Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(text = col)
                }
            }

            Divider(color = MaterialTheme.colors.onSurface, modifier = Modifier.fillMaxHeight().width(1.5.dp))


                Column(
                    modifier=Modifier
                        .weight(0.5f)
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){

                    val icon= useResource("eye.png"){
                        loadImageBitmap(it)
                    }

                    ContextMenuArea(
                        items = {
                            listOf(
                                ContextMenuItem("View Record"){}
                            )
                        }
                    ){

                     Image(bitmap = icon, contentDescription = null, contentScale = ContentScale.Inside)
                    }
                }
                Divider(color = MaterialTheme.colors.onSurface, modifier = Modifier.fillMaxHeight().width(1.5.dp))

    }


}

@Composable
@Preview
private fun Preview(){
    RecordRow(column = listOf("1","2","3"), color = MaterialTheme.colors.background)
}