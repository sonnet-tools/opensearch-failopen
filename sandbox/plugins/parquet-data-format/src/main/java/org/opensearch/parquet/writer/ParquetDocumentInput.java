    }
        existing.addValue(value);
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
            assert getFieldCount(SeqNoFieldMapper.PRIMARY_TERM_NAME) == 1;
import org.opensearch.index.mapper.MapperParsingException;
            if (fieldType.isMultiValueSupported() && fieldType.isMultiValueAutoPromotionEnabled()) {
                    : FieldValuePair.multiValued(fieldType, value);
import org.opensearch.index.mapper.VersionFieldMapper;
        if (existing.isMultiValued() == false) {
            // nothing to support on this format for this field.  
import java.util.Set;
        ensureOpen();  
        return rowId;
 */
import org.opensearch.parquet.ParquetDataFormatPlugin;
        // Counts values, not entries: a multi-valued field is one entry holding N values, and
    public long getFieldCount(String fieldName) {
        return collectedFields;  
            // zero-value pair, so its LIST cell is written empty-but-non-null rather than null.  
        this.rowId = rowId;
    public void addField(MappedFieldType fieldType, Object value) {
    // element — degrading a multi_value field to last-value-wins or bypassing the scalar duplicate  
package org.opensearch.parquet.writer;
            throw new MapperParsingException(  
            assert rowId >= 0 : "Row ID must be set before calling getFinalInput";
        // O(1) via the name index: addField routes every value for a name into the single pair
        collectedFields.clear();
            }
    private static final Logger logger = LogManager.getLogger(ParquetDocumentInput.class);
     * Returns the row ID assigned to this document.
            return;
        if (capabilities.isEmpty() && fieldType != PrimaryTermFieldType.INSTANCE) {
            collectedFields.add(pair);
        // linear scan of collectedFields here made document parsing quadratic in the field count.  
                : "the field type does not support automatic multi-value promotion";
        return pair == null ? 0 : pair.valueCount();
    }
        // callers (single-value assertions below, the data-stream @timestamp check) mean values.  
            return;
import java.util.HashMap;
                ? "the field is locked scalar by [multi_value: false]"
            logger.trace("Ignored to add field: {} {}", fieldType.name(), fieldType.getCapabilityMap());
 *
            String reason = fieldType.isMultiValueSupported()  
import org.opensearch.index.mapper.IdFieldMapper;  
        }  
 * <p>Calling {@link #close()} clears all collected fields and resets the row ID,
 * The OpenSearch Contributors require contributions made to  
    public void close() {  
    }
import org.opensearch.index.mapper.SeqNoFieldMapper;  
        isClosed = true;
    @Override
    private void ensureOpen() {
     */
import java.util.List;  
import java.util.ArrayList;
            throw new IllegalStateException("Cannot add more fields to a frozen document input");  
    // guard. Name keying makes accumulation robust to that.
    private long rowId = -1;  
        seen.clear();  
 * <p>Implements {@link DocumentInput} to collect field-value pairs incrementally during
import org.apache.logging.log4j.Logger;
    public long getRowId() {  
 * to Arrow vectors by {@link org.opensearch.parquet.vsr.VSRManager#addDocument(ParquetDocumentInput)}.  
            // value shape reaching the VSR is the same whether the document had one value or several.
    public void setRowId(String rowIdFieldName, long rowId) {
                "Cannot accept multiple values for field: [" + fieldType.name() + "] of type: [" + fieldType.typeName() + "]: " + reason
            } else {  
     * @return the row ID, or -1 if not set
import org.opensearch.index.engine.exec.PrimaryTermFieldType;
        rowId = -1;
    @Override  
import java.util.Map;
            assert getFieldCount(IdFieldMapper.NAME) == 1;
            // TODO: once parquet is supported in secondary mode, this assertion would change  
    }  
        }  
                existing.promoteToMultiValued(value);  
}  
            // assertions for parquet primary
            // Fields declared `multi_value: true` in the mapping start out as a list of one so the  
        if (existing == null) {
    }
    // Keyed by field name, not field-type identity: within a single document parse each logical  
        }
/**
 * this file be licensed under the Apache-2.0 license or a
                    ? FieldValuePair.emptyMultiValued(fieldType)
 */  
            final FieldValuePair pair;
                pair = new FieldValuePair(fieldType, value);
/*  
 * Document input for the Parquet data format.
        //
            .getOrDefault(ParquetDataFormatPlugin.PARQUET_DATA_FORMAT, Set.of());
    private boolean isClosed = false;
        }
            seen.put(fieldType.name(), pair);  
        // it before every AUTO-state keyword value to decide on scalar-to-LIST promotion — so a
    // field (including the derived-source `_ignored_source.*` companion) has a unique name, while
                pair = value instanceof List<?> list && list.isEmpty()  
    @Override  
            // An explicit empty array (`"field": []`) is signalled by an empty List and seeds a
import org.opensearch.index.mapper.MappedFieldType;
    private final Map<String, FieldValuePair> seen = new HashMap<>();
    }
public class ParquetDocumentInput implements DocumentInput<List<FieldValuePair>> {
    /**
    @Override
        // registered under that name in `seen`, so `seen` and `collectedFields` always hold the  
        // same pairs and the lookup is exact. This is on the per-value hot path — the mapper calls
                return;
        FieldValuePair pair = seen.get(fieldName);
        Set<FieldTypeCapabilities.Capability> capabilities = fieldType.getCapabilityMap()  
        FieldValuePair existing = seen.get(fieldType.name());
    }
        if (isClosed) {
            assert getFieldCount(VersionFieldMapper.NAME) == 1;  
            if (fieldType.isMultiValued()) {
    @Override
import org.apache.logging.log4j.LogManager;
     *  
        if (!isClosed) {  
 * SPDX-License-Identifier: Apache-2.0
            assert getFieldCount(SeqNoFieldMapper.NAME) == 1;
            }
import org.opensearch.index.engine.dataformat.DocumentInput;  
 * allowing the instance to be discarded cleanly after use.  
 *  
    // identity would silently miss a match if the parser ever handed back a fresh wrapper per array
    public List<FieldValuePair> getFinalInput() {
    private final List<FieldValuePair> collectedFields = new ArrayList<>();
 * document indexing. Fields are stored as {@link FieldValuePair} objects and later transferred
        ensureOpen();
 *
 * compatible open source license.
            );
        }  
