package presentation.admin_home_page

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import domain.util.AdminPopup
import domain.viewmodel.Viewmodel

class AdminViewModel:Viewmodel {

    var popWindowState:AdminPopup? by mutableStateOf<AdminPopup?>(null)

}