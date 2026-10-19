    public abstract List<Object> fetch(LeafReader reader, int docId) throws IOException;  
     * It should be overridden by fetchers to read the doc values and stored field appropriately
}  
            builder.array(simpleName, displayValues);  
     * It calls clear() to empty the list containing values after writing them to builder  
 */  
        if (values.size() == 1) {
    protected FieldValueFetcher(String simpleName) {
        if (values.isEmpty()) {
     */
            return;  
    void write(XContentBuilder builder, List<Object> values) throws IOException {
    /**
package org.opensearch.index.mapper;
    /**
 * this file be licensed under the Apache-2.0 license or a
            }
            final Object[] displayValues = new Object[values.size()];
/*  
     * @param reader - LeafReader to read data from  
import java.io.IOException;
 * among different type of doc values as well, like SortedNumericDocValues and SortedSetDocValues
        return value;
        } else {
 * compatible open source license.
            builder.field(simpleName, convert(values.getFirst()));  
import org.apache.lucene.index.LeafReader;
    MappedFieldType mappedFieldType;
public abstract class FieldValueFetcher {
     * For each value, it calls convert to transform the field value to required representation
 * are stored in different manner, so reading them would also differ
    /**  
/**
    }
 *
     * @param docId - document id to read
     */  
    }
     * Converts the field value to required representation, should be overridden by field mappers as needed  
    }
import java.util.List;
import org.opensearch.core.xcontent.XContentBuilder;
        }
 * Base class for all field value fetchers be it doc values or stored field, consumer should override
        this.simpleName = simpleName;  
     * @param value - value to convert
     * Fetches the field value from the LeafReader, whether it is doc value or stored field
        }
            for (int i = 0; i < values.size(); i++) {  
 * fetch method to read the field value from the LeafReader, read access pattern can be different for  
                displayValues[i] = convert(values.get(i));
 * The OpenSearch Contributors require contributions made to  
     * Writes the field value(s) to the builder
     */
 */  
 * SPDX-License-Identifier: Apache-2.0
    public Object convert(Object value) {  
    final String simpleName;  
     * @param builder - builder to store the field value(s) in
