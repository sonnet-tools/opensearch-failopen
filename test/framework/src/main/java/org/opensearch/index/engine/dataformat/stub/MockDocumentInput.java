 * The OpenSearch Contributors require contributions made to  
 * A mock {@link DocumentInput} for testing purposes.  
 */  
    private final Map<String, Object> fields = new HashMap<>();  
    public void close() {}
import org.opensearch.index.engine.dataformat.DocumentInput;
    public void setRowId(String rowIdFieldName, long rowId) {
 * SPDX-License-Identifier: Apache-2.0
    @Override
    @Override
import java.util.Collections;
import java.util.HashMap;
        fields.put(rowIdFieldName, rowId);
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.mapper.MappedFieldType;
        fields.put(fieldType != null ? fieldType.name() : "field_" + fields.size(), value);  
        return fields.containsKey(fieldName) ? 1 : 0;
package org.opensearch.index.engine.dataformat.stub;
    public Map<String, Object> getFinalInput() {  
public class MockDocumentInput implements DocumentInput<Map<String, Object>> {
 * compatible open source license.
    }
    @Override
/*  
/**
    }  
    @Override
    public long getFieldCount(String fieldName) {  
    @Override  
    }
        return Collections.unmodifiableMap(fields);
import java.util.Map;  
    public void addField(MappedFieldType fieldType, Object value) {
    }
 */
 *
}  
