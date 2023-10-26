package presentation.admin_home_page.utils

sealed class ValidationError {

    class FirstNameInvalid(val error:String):ValidationError()
    class LastNameInvalid(val error:String):ValidationError()
    class MobileNoInvalid(val error:String):ValidationError()
    class PasswordInvalid(val error:String):ValidationError()

}