                return values;  
    }
 * @opensearch.internal  
/**
    public List<Object> fetch(LeafReader reader, int docId) throws IOException {
        return values;
import java.util.ArrayList;
    @Override  
 * FieldValueFetcher for sorted numeric doc values, for a doc, values will be stored in  
    public SortedNumericDocValuesFetcher(MappedFieldType mappedFieldType, String SimpleName) {
import org.apache.lucene.index.LeafReader;
 *
import java.util.List;  
    public Object convert(Object value) {  
    }  
 * SPDX-License-Identifier: Apache-2.0
 *
            if (sortedNumericDocValues == null || !sortedNumericDocValues.advanceExact(docId)) {
}  
package org.opensearch.index.mapper;
            for (int i = 0; i < sortedNumericDocValues.docValueCount(); i++) {
    }
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.index.SortedNumericDocValues;
        List<Object> values = new ArrayList<>();
 * The OpenSearch Contributors require contributions made to  
/*  
 */
import java.io.IOException;
            }
        } catch (Exception e) {
        try {  
 */  
public class SortedNumericDocValuesFetcher extends FieldValueFetcher {
 * compatible open source license.
        this.mappedFieldType = mappedFieldType;  
                values.add(sortedNumericDocValues.nextValue());  
 * sorted order in lucene.
        }
        super(SimpleName);
        return mappedFieldType.valueForDisplay(value);
            final SortedNumericDocValues sortedNumericDocValues = reader.getSortedNumericDocValues(mappedFieldType.name());
            }
            throw new IOException("Failed to read doc values for document " + docId + " in field " + mappedFieldType.name(), e);  
    @Override
