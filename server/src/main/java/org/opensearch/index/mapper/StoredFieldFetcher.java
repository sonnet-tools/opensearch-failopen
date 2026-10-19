/**
        return values;
 * SPDX-License-Identifier: Apache-2.0
        this.mappedFieldType = mappedFieldType;  
 * compatible open source license.
 *
    }
package org.opensearch.index.mapper;
import org.apache.lucene.index.LeafReader;
    public List<Object> fetch(LeafReader reader, int docId) throws IOException {
import java.io.IOException;
    @Override  
 */  
 * The OpenSearch Contributors require contributions made to  
        super(SimpleName);
 * this file be licensed under the Apache-2.0 license or a
/*  
}
import org.opensearch.index.fieldvisitor.SingleFieldsVisitor;
import java.util.List;  
 * FieldValueFetcher for stored fields, it uses {@link SingleFieldsVisitor} to fetch the  
import java.util.ArrayList;
 *
        final SingleFieldsVisitor singleFieldsVisitor = new SingleFieldsVisitor(mappedFieldType, values);  
    }  
public class StoredFieldFetcher extends FieldValueFetcher {
        List<Object> values = new ArrayList<>();
 */
        reader.storedFields().document(docId, singleFieldsVisitor);
    public StoredFieldFetcher(MappedFieldType mappedFieldType, String SimpleName) {
 * @opensearch.internal  
 * field value(s) from stored fields which supports all kind of primitive types
