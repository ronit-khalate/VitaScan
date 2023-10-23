package presentation.admin_home_page.popups

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import presentation.view_record_page.TableBackgroundAndSearchBar
import presentation.view_record_page.ViewRecordPage


@Preview
@Composable
fun AdminViewTable(onClose:()->Unit){

    Card(
        modifier = Modifier
            .height(510.dp)
            .width(660.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colors.primaryVariant)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

        }
    }

    Card(
        modifier = Modifier
            .height(500.dp)
            .width(650.dp)
    ){
        Row(
            modifier=Modifier
                .padding(top = 20.dp, end = 20.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ){

            Image(
                modifier=Modifier
                    .clickable {onClose()},
                imageVector = Icons.Default.Close,
                contentDescription = null
            )
        }
        TableBackgroundAndSearchBar(PaddingValues(20.dp))
    }

}