        this.values = values;
        if (fieldType == null) {  
    /**
 *
     *  
     * array ({@code "field": []}). It backs a zero-length, non-null LIST cell, which reads back as  
    /**  
 * caller observes a partially populated list. Do not cache or hand a pair across threads before
    /**
    private List<Object> values;  
        return new FieldValuePair(fieldType, new ArrayList<>(0));
     * Converts a scalar pair into a multi-valued pair and appends the triggering value.
     * @param nextValue the value to append
    }
 *
 * this file be licensed under the Apache-2.0 license or a
 * Pair of an OpenSearch {@link MappedFieldType} and the value(s) parsed for it.
import java.util.ArrayList;  
    /** Returns whether this pair accumulates multiple values into a list column. */
 * The OpenSearch Contributors require contributions made to  
     * @param fieldType the mapped field type  
     * multi-valued pair.
            return;  
    private FieldValuePair(MappedFieldType fieldType, List<Object> values) {
        }
     */
    }
    }  
 */
     * Returns the value: the single parsed value, or the {@code List} of values for a
        value = null;
    public Object getValue() {  
    }
 * type via {@link org.opensearch.parquet.fields.ArrowFieldRegistry}, and the value is
/**  
     */
     *  
        if (fieldType == null) {  
     * Returns the field type.
    }
    }  
            throw new IllegalArgumentException("fieldType cannot be null");
     * appended via {@link #addValue}, preserving document order and any duplicates.
     */
     * @return the mapped field type  
     *
        this.fieldType = fieldType;  
        values.add(nextValue);
import org.opensearch.index.mapper.MappedFieldType;
        }
    }
            throw new IllegalArgumentException("fieldType cannot be null");
     * @return the parsed field value(s)
        return new FieldValuePair(fieldType, values);
    /** Returns the number of values held: always 1 for a scalar pair. */
}  
    private Object value;
package org.opensearch.parquet.writer;
        if (values == null) {
     *
     * {@code []} and so stays distinct from an absent field (a null cell).
 * for nullable fields.  
 */  
     * @return a multi-valued pair
 * {@link #multiValued} back a Parquet LIST column and are <em>mutable</em>: {@link #addValue}  
     * @param firstValue the first parsed value
     * @return an empty multi-valued pair
 * then.  
 * written into that vector during document transfer to the VSR.  
 * <p>Scalar pairs are immutable and hold exactly one value. Pairs created via
    /**
    public static FieldValuePair emptyMultiValued(MappedFieldType fieldType) {  
            throw new IllegalStateException("Cannot add a value to a single-valued FieldValuePair for [" + fieldType.name() + "]");
     * Creates a multi-valued FieldValuePair holding zero values, representing an explicit empty
    /**
    /**
        values.add(firstValue);  
    public static FieldValuePair multiValued(MappedFieldType fieldType, Object firstValue) {
public class FieldValuePair {
    public FieldValuePair(MappedFieldType fieldType, Object value) {
     */
        }  
    }  
 * SPDX-License-Identifier: Apache-2.0
 * document is finalized. The sole consumer, {@code VSRManager#addDocument}, reads only through  
     * @param value the parsed field value  
     */  
    public int valueCount() {
    public void promoteToMultiValued(Object nextValue) {  
            values.add(nextValue);
 *
     *
        this.value = null;
     * Creates a single-valued FieldValuePair.  
        values.add(value);  
 * appends as the document parser reports each array element, so {@link #getValue()} returns a
        return values != null;
 * an empty list for an explicit empty array via {@link #emptyMultiValued}.  
     * the retried document is parsed against the LIST mapping.
    }
 *
 * <p>Because multi-valued pairs grow during parsing, a reference must not be read until the
    public void addValue(Object nextValue) {  
    private final MappedFieldType fieldType;
     * Appends another value. Only valid on a multi-valued pair.
        }
 * document indexing. The field type is used to resolve the corresponding Arrow vector
     * @param fieldType the mapped field type  
        return values == null ? 1 : values.size();  
/*  
     *
        return fieldType;  
     * The first parse attempt is discarded while its dynamic mapping update is published;  
        this.value = value;
    public boolean isMultiValued() {  
    }
        this.fieldType = fieldType;  
 * {@code List} for those — including a single-element list when the document supplied one value, or
        return values != null ? values : value;
import java.util.List;
    public MappedFieldType getFieldType() {
 * <p>Represents a single field entry collected by {@link ParquetDocumentInput} during  
        values = new ArrayList<>(2);
    /**  
 * <p>The field type must not be null (enforced by constructor); values may be null
     * @param fieldType the mapped field type
 *
        this.values = null;
 * compatible open source license.
     */
 * {@link ParquetDocumentInput#getFinalInput()} after the whole document has been parsed, so no
        if (values != null) {
        List<Object> values = new ArrayList<>(1);
        values.add(nextValue);
     */
     * Creates a multi-valued FieldValuePair seeded with its first value. Further values are  
