package com.peony.listadapter.interfaces;

import java.util.List;

public interface FunDapterFilter<T> {
    public List<T> filter(String filterConstraint,
	    List<T> originalList);
}
