/*  
    default void startNestedElement(String path) {}  
 * SPDX-License-Identifier: Apache-2.0
    /**  
@ExperimentalApi
    /**
     */
     */  
    default void endNestedElement() {}
 */  
     * @param rowId the row ID value
package org.opensearch.index.engine.dataformat;
 * this file be licensed under the Apache-2.0 license or a
     * parsing fails. Plain objects emit no signals. The default implementation is a no-op.
 * Represents a document input for adding fields and metadata to a writer.
     * Gets the final input representation.  
    T getFinalInput();
 * @param <T> the type of the final input representation
     * @param value the field value
public interface DocumentInput<T> extends AutoCloseable {  
    /** Standard field name for the row ID used to correlate documents across data formats. */
 * @opensearch.experimental  
import org.opensearch.index.mapper.MappedFieldType;
    void setRowId(String rowIdFieldName, long rowId);  
}
 *
     *
     *
 *
     */
     * Adds a row ID field to the document.
     *
     * @return the final input of type T
     * Adds a field to the document.
     * @param path the full dotted path of the field this element belongs to
    /**  
     * is a no-op.
 *  
 */
    /**
    String ROW_ID_FIELD = "__row_id__";  
    /**
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.annotation.ExperimentalApi;
     *  
     */  
     * Emitted once per array element and always paired with {@link #endNestedElement()}, even if
     * @param fieldType the mapped field type  
/**
     */  
    long getFieldCount(String fieldName);
     * Fields arriving after this call belong to the enclosing scope. The default implementation
     * Given a field name, returns the number of values associated with that field in the document.  
     * Signals the start of a {@code nested} element, before its fields arrive through {@link #addField}.  
    /**
 * compatible open source license.
     */
     * Signals that the element opened by the matching {@link #startNestedElement(String)} ends.  
    void addField(MappedFieldType fieldType, Object value);  
     * @return count of field values
     * @param fieldName name of the field to lookup
     * @param rowIdFieldName the name of the row ID field  
