package com.aip.dao.converter;

public interface Converter<T, R> {
    R convert(T Object);
}
