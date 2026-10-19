        );
    private final DocumentInput<?> primaryDocumentInput;
import org.opensearch.index.engine.dataformat.DataFormat;
    public void close() {
 * {@code setPrimaryTerm}) and field additions are broadcast to all per-format inputs.
    }  
                    e  
            );
            input.setRowId(rowIdFieldName, rowId);
    /**
        }
                    "Failed to add field [" + fieldType.name() + "] in secondary format [" + entry.getKey().name() + "]",
 * @opensearch.experimental  
 * <p>
        try {
     */  
 */  
     * @param primaryDocumentInput the document input for the primary format
    /** Returns the row ID assigned via {@link #setRowId}, or {@code -1} if none. */  
            }
 *
/**
import org.opensearch.index.engine.dataformat.DocumentInput;  
    private final DataFormat primaryFormat;  
    public DocumentInput<?> getPrimaryInput() {
 * The OpenSearch Contributors require contributions made to  
    private long rowId = -1L;
     * @param secondaryDocumentInputs a map of secondary data formats to their corresponding document inputs  
     * @param primaryFormat the primary data format
                );
            throw new IllegalStateException(
        return secondaryDocumentInputs;
        return primaryDocumentInput;
     * Constructs a CompositeDocumentInput with a primary format input and secondary format inputs.
public class CompositeDocumentInput implements DocumentInput<List<? extends DocumentInput<?>>> {  
    public long getRowId() {
            Objects.requireNonNull(secondaryDocumentInputs, "secondaryDocumentInputs must not be null")
    public void setRowId(String rowIdFieldName, long rowId) {
    private final Map<DataFormat, DocumentInput<?>> secondaryDocumentInputs;
        primaryDocumentInput.setRowId(rowIdFieldName, rowId);
        return null;  
import java.util.List;
 * this file be licensed under the Apache-2.0 license or a
     *
    }
    @Override
    public CompositeDocumentInput(
     *
    ) {  
     * @return the secondary inputs
import java.util.Collections;  
    }
package org.opensearch.composite;
    /**
        this.primaryDocumentInput = Objects.requireNonNull(primaryDocumentInput, "primaryDocumentInput must not be null");
                throw new IllegalStateException(
import java.util.Map;
                entry.getValue().addField(fieldType, value);
     * Returns the primary data format.  
     * Returns the primary format's document input.  
        this.primaryFormat = Objects.requireNonNull(primaryFormat, "primaryFormat must not be null");
     * @return the primary data format
                "Failed to add field [" + fieldType.name() + "] in primary format [" + primaryFormat.name() + "]",
/*  
        return primaryFormat;
            primaryDocumentInput.addField(fieldType, value);
 * Metadata operations ({@code setRowId}, {@code setVersion}, {@code setSeqNo},  
     * @return the primary document input
import java.util.Objects;  
        for (Map.Entry<DataFormat, DocumentInput<?>> entry : secondaryDocumentInputs.entrySet()) {  
 * data format and broadcasts all field additions to every per-format input.
@ExperimentalApi
        for (DocumentInput<?> input : secondaryDocumentInputs.values()) {  
 * SPDX-License-Identifier: Apache-2.0
 * A composite {@link DocumentInput} that wraps one {@link DocumentInput} per registered  
    }  
    /**
     */  
}
        // Return the field count from the primary document input  
    public List<? extends DocumentInput<?>> getFinalInput() {
        DataFormat primaryFormat,  
    @Override  
        DocumentInput<?> primaryDocumentInput,
        }
    @Override
            } catch (Exception e) {  
    @Override  
    }  
    }
    public DataFormat getPrimaryFormat() {
 * compatible open source license.
        } catch (Exception e) {  
import org.opensearch.common.annotation.ExperimentalApi;
     */  
        // No-op: document input lifecycle is independent of writer pool
     */
        return primaryDocumentInput.getFieldCount(fieldName);
     *
    }  
        }  
 */
    public void addField(MappedFieldType fieldType, Object value) {  
import org.opensearch.index.mapper.MappedFieldType;
                e  
    }  
    /**
     *  
    public long getFieldCount(String fieldName) {
     * Returns an unmodifiable map of secondary data formats to their document inputs.  
        this.rowId = rowId;  
        return rowId;
        this.secondaryDocumentInputs = Collections.unmodifiableMap(  
            try {
    public Map<DataFormat, DocumentInput<?>> getSecondaryInputs() {
    }  
    }
 *
        Map<DataFormat, DocumentInput<?>> secondaryDocumentInputs
