package com.peony.listadapter.extractors;

public interface BooleanExtractor<T> {
    public boolean getBooleanValue(T item, int position);
}
