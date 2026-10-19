 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .startObject("test")  
        List<LeafReaderContext> readers = refreshReader();
/*  
/*  
 * Modifications Copyright OpenSearch Contributors. See
        ScriptDocValues<?> scriptValues = fieldData.getScriptValues();
        final DocumentMapper mapper = mapperService.documentMapperParser().parse("test", new CompressedXContent(mapping));
        {
            .field("doc_values", true)
            for (int j = 0; j < retValues[i].length; j++) {  
        // Test SortedBinaryDocValues's decoding:  
        }
        return true;  
 * The OpenSearch Contributors require contributions made to  
            .endObject()
        assertEquals(2, bytesValues.docValueCount());
import org.opensearch.common.xcontent.XContentFactory;
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
        assertFalse(bytesValues.advanceExact(2));
        List<BytesRef> bytesList2 = new ArrayList<>(2);
            doc.value(bytesList2.get(0));  
        assertEquals(bytesList1.get(1), bytesValues.nextValue());
    @Override
        String mapping = XContentFactory.jsonBuilder()
        assertEquals(2, bytesValues.docValueCount());
        assertEquals(2, retValues[0].length);
    protected boolean hasDocValues() {
 * compatible open source license.
        writer.addDocument(d.rootDoc());
        assertEquals(2, retValues[3].length);
import org.opensearch.common.compress.CompressedXContent;  
            .endObject()
        int size = randomIntBetween(10, 1000);
    private static BytesRef randomBytes() {  
        bytesList1.add(randomBytes());  
import java.util.List;
            doc.startArray("field");  
import org.opensearch.core.common.bytes.BytesReference;
        assertEquals(bytesList2.get(1), retValues[3][1]);  
import org.apache.lucene.util.BytesRef;
    }
        assertEquals(bytesList2.get(0), bytesValues.nextValue());
import org.opensearch.index.mapper.ParsedDocument;  
            doc.endArray();  
        bytesList2.sort(null);
import org.apache.lucene.index.LeafReaderContext;
            .endObject()
public class BinaryDVFieldDataTests extends AbstractFieldDataTestCase {  
        assertEquals(bytes1, retValues[1][0]);  
        }
 */
    protected String getFieldDataType() {
        bytesList1.add(randomBytes());
        BytesRef bytes1 = randomBytes();  
        assertEquals(bytesList1.get(1), retValues[0][1]);  
 */  
            doc.value(bytesList2.get(0));
 */  
        Object[][] retValues = new BytesRef[4][0];
        doc = XContentFactory.jsonBuilder().startObject().endObject();
            doc.value(bytesList2.get(1));
        d = mapper.parse(new SourceToParse("test", "4", BytesReference.bytes(doc), MediaTypeRegistry.JSON));
        assertEquals(bytes1, bytesValues.nextValue());
        fieldData = indexFieldData.load(reader);  
        IndexFieldData<?> indexFieldData = getForField("field");
        writer.addDocument(d.rootDoc());  
 * KIND, either express or implied.  See the License for the
        ParsedDocument d = mapper.parse(new SourceToParse("test", "1", BytesReference.bytes(doc), MediaTypeRegistry.JSON));  
        assertTrue(bytesValues.advanceExact(1));  
import org.opensearch.index.mapper.DocumentMapper;
        assertTrue(bytesValues.advanceExact(3));  
        assertEquals(1, readers.size());  
            .toString();  
 * license agreements. See the NOTICE file distributed with
        // test remove duplicate value  
            .startObject("properties")
 * the Apache License, Version 2.0 (the "License"); you may
        random().nextBytes(bytes);  
        }  
 * under the License.  
        doc.endObject();
 * SPDX-License-Identifier: Apache-2.0
                retValues[i][j] = scriptValues.get(j);
    }
            doc.startArray("field");  
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(bytesList1.get(0), retValues[0][0]);
import org.opensearch.core.xcontent.MediaTypeRegistry;  
        d = mapper.parse(new SourceToParse("test", "2", BytesReference.bytes(doc), MediaTypeRegistry.JSON));
        doc.endObject();  
        LeafFieldData fieldData = indexFieldData.load(reader);
    }
/*
package org.opensearch.index.fielddata;
            .endObject()  
        doc = XContentFactory.jsonBuilder().startObject();
 * not use this file except in compliance with the License.
            scriptValues.setNextDocId(i);
        for (int i = 0; i < 4; i++) {  
            .startObject("field")
        return "binary";  
}
        d = mapper.parse(new SourceToParse("test", "3", BytesReference.bytes(doc), MediaTypeRegistry.JSON));  
        // Test whether ScriptDocValues.BytesRefs makes a deepcopy
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
        bytesList2.add(randomBytes());
        assertEquals(bytesList2.get(0), retValues[3][0]);
            doc.value(bytesList1.get(1));
            .startObject()
        assertEquals(1, retValues[1].length);
        SortedBinaryDocValues bytesValues = fieldData.getBytesValues();
import java.util.ArrayList;  
    @Override
        doc = XContentFactory.jsonBuilder().startObject().field("field", bytes1.bytes, bytes1.offset, bytes1.length).endObject();
import org.opensearch.index.mapper.SourceToParse;
import org.opensearch.core.xcontent.XContentBuilder;
        bytesList1.sort(null);  
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
        return new BytesRef(bytes);
        List<BytesRef> bytesList1 = new ArrayList<>(2);
        LeafReaderContext reader = readers.get(0);
        assertEquals(bytesList1.get(0), bytesValues.nextValue());  
        writer.addDocument(d.rootDoc());
        {
        assertTrue(bytesValues.advanceExact(0));
        bytesList2.add(randomBytes());  
    }
            .field("type", "binary")  
            doc.value(bytesList1.get(0));
 * You may obtain a copy of the License at  
 *  
        writer.addDocument(d.rootDoc());
        assertEquals(1, bytesValues.docValueCount());
        assertEquals(bytesList2.get(1), bytesValues.nextValue());  
 * GitHub history for details.
        assertEquals(0, retValues[2].length);
 * this work for additional information regarding copyright
            retValues[i] = new BytesRef[scriptValues.size()];
 *
 *
        byte[] bytes = new byte[size];
            doc.endArray();
            }
    public void testDocValue() throws Exception {  
        XContentBuilder doc = XContentFactory.jsonBuilder().startObject();
