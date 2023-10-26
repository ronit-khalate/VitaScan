package presentation.login_page.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun LoginPageBackground(
    modifier: Modifier=Modifier,
){
    Row(modifier){

        Card(
            modifier=Modifier
                .fillMaxSize(),
            elevation = 0.dp,
            backgroundColor = MaterialTheme.colors.primaryVariant
        ){}
    }
}