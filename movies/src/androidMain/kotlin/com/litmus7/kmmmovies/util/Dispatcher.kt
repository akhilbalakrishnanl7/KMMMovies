package com.litmus7.kmmmovies.util

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 * The class AndroidDispatcher extends the Dispatcher and it will provide the dispatcher for the android platform.
 */
internal class AndroidDispatcher : Dispatcher {

    override val io: CoroutineDispatcher
        get() = Dispatchers.IO

}

/**
 * The actual android platform specific implementation of provideDispatcher() function which returns a dispatcher.
 */
internal actual fun provideDispatcher(): Dispatcher = AndroidDispatcher()