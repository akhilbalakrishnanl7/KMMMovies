package com.litmus7.kmmmovies.util

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 * The class IosDispatcher extends the Dispatcher and it will provide the dispatcher for the iOS platform.
 */
internal class IosDispatcher : Dispatcher {

    override val io: CoroutineDispatcher
        get() = Dispatchers.Default

}

/**
 * The actual iOS platform specific implementation of provideDispatcher() function which returns a dispatcher.
 */
internal actual fun provideDispatcher(): Dispatcher = IosDispatcher()