package com.peony.listadapter.extractors;

public interface LongExtractor<T> {

    public long getLongValue(T item, int position);
}
