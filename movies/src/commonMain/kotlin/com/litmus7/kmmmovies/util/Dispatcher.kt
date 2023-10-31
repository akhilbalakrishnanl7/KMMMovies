package com.litmus7.kmmmovies.util

import kotlinx.coroutines.CoroutineDispatcher

/**
 * The interface Dispatcher will setup all the dispatchers that used for networking. For android platform an IO dispatcher is used and for iOS platform
 * a default dispatcher is used.
 */
internal interface Dispatcher{

    val io: CoroutineDispatcher

}

/**
 * The expect fun provideDispatcher which returns a platform specific Dispatcher
 */
internal expect fun provideDispatcher():Dispatcher