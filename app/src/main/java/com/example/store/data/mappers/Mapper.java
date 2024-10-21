package com.example.store.data.mappers;

public interface Mapper<I, O> {
    O map(I value);
}
