package com.peony.listadapter.fields;

import java.util.AbstractMap.SimpleEntry;

import com.peony.listadapter.interfaces.ItemClickListener;
import com.peony.listadapter.extractors.BooleanExtractor;
import com.peony.listadapter.extractors.StringExtractor;

import android.graphics.Typeface;

/**
 * A field that represents textual data. This data will be shown on a TextView
 * only.
 *
 * @param <T>
 * @author Ami G
 */
public class StringField<T> extends BaseStringField<T> {

    public Typeface typeface;
    public SimpleEntry<BooleanExtractor<T>, Integer[]> conditionalTextColorEntry;
    public StringExtractor<T> backgroundEntry;

    /**
     * A field that represents textual data. This data will be shown on a
     * TextView only.
     *
     * @param viewResId - The resource ID of the view you want to bind to (Example:
     *                  R.id.text).
     * @param extractor - An implementation that will extract the correct string from
     *                  the model object.
     */
    public StringField(int viewResId, StringExtractor<T> extractor) {
        super(viewResId, extractor);
    }

    /**
     * Set the font for this field.
     *
     * @param typeface
     * @return
     */
    public StringField<T> typeface(Typeface typeface) {

        if (typeface == null)
            return this;

        this.typeface = typeface;
        return this;
    }

    @Override
    public StringField<T> visibilityIfNull(int visibilityIfNull) {
        return (StringField<T>) super.visibilityIfNull(visibilityIfNull);
    }

    @Override
    public StringField<T> onClick(ItemClickListener<T> onClickListener) {

        return (StringField<T>) super.onClick(onClickListener);
    }

    public StringField<T> conditionalTextColor(BooleanExtractor<T> extractor,
                                               int colorIfTrue, int colorIfFalse) {

        if (extractor == null)
            throw new IllegalArgumentException(
                    "boolean extractor cannot be null");

        conditionalTextColorEntry = new SimpleEntry<BooleanExtractor<T>, Integer[]>(
                extractor, new Integer[]{colorIfTrue, colorIfFalse});

        return this;
    }

    public StringField<T> background(StringExtractor<T> extractor) {

        if (extractor == null) throw new IllegalArgumentException( "string extractor cannot be null");

        backgroundEntry = extractor;
        return this;
    }
}
