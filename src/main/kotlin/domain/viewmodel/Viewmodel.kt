package domain.viewmodel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

interface Viewmodel {


    val viewmodelScopeIo: CoroutineScope
        get() = CoroutineScope(Dispatchers.IO)

    val viewmodelScopeMain:CoroutineScope
        get() = CoroutineScope(Dispatchers.Main)
}
