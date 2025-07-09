package org.converter.core.utils

suspend fun <T> safeExecute(request: suspend () -> T): T? {
    return try {
        request()
    } catch (e: Exception) {
        null
    }
}