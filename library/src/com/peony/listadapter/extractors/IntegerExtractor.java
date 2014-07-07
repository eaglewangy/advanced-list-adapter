package com.peony.listadapter.extractors;

public interface IntegerExtractor<T> {

    public int getIntValue(T item, int position);
}
