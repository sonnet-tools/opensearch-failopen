        assertTrue(ft.existsQuery(randomMockShardContext()) instanceof FieldExistsQuery);
    }
 * software distributed under the License is distributed on an
    public void testRangeQuery() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
    }
            IllegalArgumentException.class,
import java.io.IOException;  
import java.util.Arrays;
    public void testExistsQuery() {
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
        MappedFieldType ft = new DocCountFieldMapper.DocCountFieldType();  
 * Unless required by applicable law or agreed to in writing,
        QueryShardException e = expectThrows(QueryShardException.class, () -> ft.termQuery(10L, randomMockShardContext()));
            () -> ft.rangeQuery(null, null, randomBoolean(), randomBoolean(), null, null, null, null)  
 * this work for additional information regarding copyright
        assertEquals("Field [_doc_count] of type [_doc_count] is not searchable", e.getMessage());
        MappedFieldType fieldType = new DocCountFieldMapper.DocCountFieldType();
        MappedFieldType ft = new DocCountFieldMapper.DocCountFieldType();  
package org.opensearch.index.mapper;
 * You may obtain a copy of the License at  
    public void testFetchSourceValue() throws IOException {
        assertEquals(Arrays.asList(1L), fetchSourceValue(fieldType, ""));
 */  
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
 *
 * GitHub history for details.
 */
 * compatible open source license.
        assertEquals(Arrays.asList(1L), fetchSourceValue(fieldType, null));  
/*
 */  
 * specific language governing permissions and limitations
    }  
 * The OpenSearch Contributors require contributions made to  
    }  
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
        MappedFieldType ft = new DocCountFieldMapper.DocCountFieldType();  
import org.opensearch.index.query.QueryShardException;
public class DocCountFieldTypeTests extends FieldTypeTestCase {  
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(Arrays.asList(14L), fetchSourceValue(fieldType, 14));  
    public void testTermQuery() {
import org.apache.lucene.search.FieldExistsQuery;  
        IllegalArgumentException e = expectThrows(
 * Licensed to Elasticsearch under one or more contributor  
/*  
/*  
}
        );
 * under the License.  
        assertEquals("Field [_doc_count] of type [_doc_count] does not support range queries", e.getMessage());
        assertEquals(Arrays.asList(14L), fetchSourceValue(fieldType, "14"));
 *  
 *
 * SPDX-License-Identifier: Apache-2.0
