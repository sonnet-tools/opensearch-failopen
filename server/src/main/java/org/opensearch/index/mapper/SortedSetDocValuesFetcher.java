/**  
    }
            if (sortedSetDocValues == null || !sortedSetDocValues.advanceExact(docId)) {  
 *
            throw new IOException("Failed to read doc values for document " + docId + " in field " + mappedFieldType.name(), e);  
                values.add(BytesRef.deepCopyOf(value));  
import java.util.ArrayList;  
import java.util.List;
    }  
        } catch (IOException e) {
    public Object convert(Object value) {  
        List<Object> values = new ArrayList<>();  
    }
import org.apache.lucene.util.BytesRef;  
 * compatible open source license.
            }
}  
import org.apache.lucene.index.SortedSetDocValues;
            }
 * The OpenSearch Contributors require contributions made to  
            int valueCount = sortedSetDocValues.docValueCount();  
                return values;
public class SortedSetDocValuesFetcher extends FieldValueFetcher {  
            final SortedSetDocValues sortedSetDocValues = reader.getSortedSetDocValues(mappedFieldType.name());
/*  
 */  
 * lucene
package org.opensearch.index.mapper;
        return mappedFieldType.valueForDisplay(value);
    @Override
import org.apache.lucene.index.LeafReader;
        }
 * SPDX-License-Identifier: Apache-2.0
import java.io.IOException;
        try {
                BytesRef value = sortedSetDocValues.lookupOrd(sortedSetDocValues.nextOrd());
    @Override
 * @opensearch.internal
        super(simpleName);  
    public List<Object> fetch(LeafReader reader, int docId) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
 * FieldValueFetcher for sorted set doc values, for a doc, values will be deduplicated and sorted while stored in
 */
 *  
        this.mappedFieldType = mappedFieldType;
    public SortedSetDocValuesFetcher(MappedFieldType mappedFieldType, String simpleName) {
        return values;
            for (int ord = 0; ord < valueCount; ord++) {
