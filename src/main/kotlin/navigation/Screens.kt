package navigation

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.StackAnimation
import com.arkivanov.decompose.router.stack.StackNavigationSource
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import domain.model.staff.Staff


sealed class Screen(
    open val staff:Staff?
):Parcelable{

    @Parcelize
    class Login(override val staff: Staff?):Screen(staff)
    @Parcelize
    class AdminHome(override val staff: Staff):Screen(staff)

    @Parcelize
    class DoctorHome(override val staff: Staff):Screen(staff)

    @Parcelize
    class ViewRecordPage(override val staff: Staff):Screen(staff)

    @Parcelize
    class InsertRecordPage(override val staff: Staff):Screen(staff)
}

val LocalComponentContext:ProvidableCompositionLocal<ComponentContext> =
        staticCompositionLocalOf{ error("Root component contex was not provided") }

@Composable
fun ProvideComponentContext(componentContext: ComponentContext,content :@Composable ()-> Unit){

    CompositionLocalProvider(LocalComponentContext provides componentContext, content=content)
}

@Composable
inline fun <reified C : Parcelable> ChildStack(
    source: StackNavigationSource<C>,
    noinline initialStack: () -> List<C>,
    modifier: Modifier = Modifier,
    handleBackButton: Boolean = false,
    animation: StackAnimation<C, ComponentContext>? = null,
    noinline content: @Composable (C) -> Unit,
) {
    val componentContext = LocalComponentContext.current

    Children(
        stack = remember {
            componentContext.childStack(
                source = source,
                initialStack = initialStack,
                handleBackButton = handleBackButton,
                childFactory = { _, childComponentContext -> childComponentContext },
            )
        },
        modifier = modifier,
        animation = animation,
    ) { child ->
        ProvideComponentContext(child.instance) {
            content(child.configuration)
        }
    }
}