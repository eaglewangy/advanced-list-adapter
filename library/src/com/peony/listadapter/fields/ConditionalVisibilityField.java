package com.peony.listadapter.fields;

import com.peony.listadapter.interfaces.ItemClickListener;
import com.peony.listadapter.extractors.BooleanExtractor;

/**
 * A field to conditionally show a view based on some boolean value. Good for
 * showing list item decorations for certain conditions.
 * 
 * @author Ami
 * 
 * @param <T>
 */
public class ConditionalVisibilityField<T> extends BaseField<T> {

    public BooleanExtractor<T> extractor;
    public int visibilityIfFalse;

    public ConditionalVisibilityField(int viewResId,
	    BooleanExtractor<T> extractor, int visibilityIfFalse) {
	super(viewResId);
	this.extractor = extractor;
	this.visibilityIfFalse = visibilityIfFalse;
    }

    @Override
    public ConditionalVisibilityField<T> onClick(ItemClickListener<T> onClickListener) {

	return (ConditionalVisibilityField<T>) super.onClick(onClickListener);
    }

}
