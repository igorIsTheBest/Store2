package com.example.store.data.concurency;

@FunctionalInterface
public interface TaskCallback<T> {
    void onCompleted(T result, Fault fault);
}