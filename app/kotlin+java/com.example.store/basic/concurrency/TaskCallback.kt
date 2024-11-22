package com.example.store.basic.concurrency

interface TaskCallback<T> {
    fun onComplete(result: T)
    fun onError(fault: Fault)
}
