package org.converter.core.utils

import kotlin.Result

suspend fun <T> execute(request: suspend () -> T): Result<T> {
    return runCatching { request() }.mapCatching { it }
}