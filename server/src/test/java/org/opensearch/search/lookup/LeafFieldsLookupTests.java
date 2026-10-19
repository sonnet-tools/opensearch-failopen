 * under the License.  
import org.apache.lucene.index.DocValuesType;
 * specific language governing permissions and limitations
/*
import org.apache.lucene.index.FieldInfo;
        assertEquals(12.718, values.get(0));
        FieldLookup fieldLookup = (FieldLookup) fieldsLookup.get("alias");
import static org.mockito.Mockito.doAnswer;
 * compatible open source license.
            0,  
        when(fieldType.name()).thenReturn("field");
import org.apache.lucene.index.IndexOptions;  
        assertEquals("field", fieldLookup.fieldType().name());
import static org.mockito.Mockito.when;  
        assertEquals("field", fieldLookup.fieldType().name());
        doAnswer(invocation -> new StoredFields() {
import org.opensearch.index.mapper.MappedFieldType;  
 */
 * Modifications Copyright OpenSearch Contributors. See  
 * software distributed under the License is distributed on an
        assertNotNull(values);
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.index.StoredFields;  
import org.apache.lucene.index.DocValuesSkipIndexType;  
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
import org.apache.lucene.index.LeafReader;
 * SPDX-License-Identifier: Apache-2.0
        List<Object> values = fieldLookup.getValues();  
        MappedFieldType fieldType = mock(MappedFieldType.class);  
    @Before
 */
        // Add 10 when valueForDisplay is called so it is easy to be sure it *was* called
            IndexOptions.NONE,  
            DocValuesType.NONE,
        when(mapperService.fieldType("alias")).thenReturn(fieldType);
    }  
 *
    public void testBasicLookup() {
        assertNotNull(values);
import org.apache.lucene.index.VectorSimilarityFunction;
            0,
            VectorEncoding.FLOAT32,  
import org.opensearch.index.mapper.MapperService;
import java.util.Collections;  
package org.opensearch.search.lookup;
            public void document(int docID, StoredFieldVisitor visitor) throws IOException {  
import org.apache.lucene.index.StoredFieldVisitor;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}  
            true,
import static org.mockito.Mockito.any;  
            false,  
 * license agreements. See the NOTICE file distributed with
    }
    public void testLookupWithFieldAlias() {  
public class LeafFieldsLookupTests extends OpenSearchTestCase {
            false,
            1,
 *  
 * this work for additional information regarding copyright
        assertEquals(12.718, values.get(0));  
        when(fieldType.valueForDisplay(any())).then(invocation -> (Double) invocation.getArguments()[0] + 10);  
import java.io.IOException;
/*  
            -1,  
 */  
        assertEquals(1, values.size());
    public void setUp() throws Exception {  
import org.opensearch.test.OpenSearchTestCase;
 * KIND, either express or implied.  See the License for the
            false  
        MapperService mapperService = mock(MapperService.class);
        super.setUp();
import org.apache.lucene.index.VectorEncoding;
 * this file be licensed under the Apache-2.0 license or a
            0,
        FieldInfo mockFieldInfo = new FieldInfo(  
        }).when(leafReader).storedFields();  
        );
        when(mapperService.fieldType("field")).thenReturn(fieldType);  
import java.util.List;
 * the Apache License, Version 2.0 (the "License"); you may
        List<Object> values = fieldLookup.getValues();
            DocValuesSkipIndexType.NONE,
 * not use this file except in compliance with the License.
            0,
        LeafReader leafReader = mock(LeafReader.class);  
                visitor.doubleField(mockFieldInfo, 2.718);
/*
 * ownership. Elasticsearch licenses this file to you under  
            Collections.emptyMap(),
import static org.mockito.Mockito.mock;
        FieldLookup fieldLookup = (FieldLookup) fieldsLookup.get("field");  
 * You may obtain a copy of the License at  
    private LeafFieldsLookup fieldsLookup;  
            false,
            "field",
            VectorSimilarityFunction.EUCLIDEAN,
 * GitHub history for details.
        fieldsLookup = new LeafFieldsLookup(mapperService, leafReader);
            }
import org.junit.Before;  
        assertEquals(1, values.size());  
            @Override
