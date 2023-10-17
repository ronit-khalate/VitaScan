package navigation

sealed class Screen(val route:String) {

    object Login:Screen(route = "login_screen")
    object AdminHome:Screen(route = "adminHome_screen")
}