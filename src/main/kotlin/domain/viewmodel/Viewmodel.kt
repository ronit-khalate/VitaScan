package domain.viewmodel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

interface Viewmodel {


    val viewmodelScope: CoroutineScope
        get() = CoroutineScope(Dispatchers.IO)
}