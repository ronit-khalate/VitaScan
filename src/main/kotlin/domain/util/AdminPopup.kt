package domain.util

sealed class AdminPopup {
    object AddStaffForm:AdminPopup()

    object UpdateStaffForm:AdminPopup()

    object ViewRecord:AdminPopup()
}