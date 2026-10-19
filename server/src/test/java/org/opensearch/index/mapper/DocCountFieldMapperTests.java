/*  
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {}));
    public void testInvalidDocument_NegativeDocCount() throws Exception {
        assertEquals(1, doc.rootDoc().getFields(DOC_COUNT_FIELD).length);
 */
        Exception e = expectThrows(MapperParsingException.class, () -> mapper.parse(source(b -> b.field(CONTENT_TYPE, 100.23))));
 * license agreements. See the NOTICE file distributed with
        Exception e = expectThrows(MapperParsingException.class, () -> mapper.parse(source(b -> b.field(CONTENT_TYPE, "foo"))));
     * Test parsing field mapping and adding simple field
 * KIND, either express or implied.  See the License for the
        assertEquals(DocValuesType.NUMERIC, field.fieldType().docValuesType());
 * not use this file except in compliance with the License.
        IndexableField field = doc.rootDoc().getField(DOC_COUNT_FIELD);
        assertEquals(100L, field.numericValue());  
    public void testInvalidDocument_ZeroDocCount() throws Exception {
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {}));  
 * GitHub history for details.
public class DocCountFieldMapperTests extends MapperServiceTestCase {
        assertThat(e.getCause().getMessage(), containsString("Field [_doc_count] must be a positive integer"));
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {}));  
import org.apache.lucene.index.IndexableField;
 * specific language governing permissions and limitations
    public void testInvalidDocument_NonNumericDocCount() throws Exception {
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {}));  
        Exception e = expectThrows(MapperParsingException.class, () -> mapper.parse(source(b -> b.field(CONTENT_TYPE, -100))));
package org.opensearch.index.mapper;
 *
 * You may obtain a copy of the License at  
    private static final String DOC_COUNT_FIELD = DocCountFieldMapper.NAME;
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
 *  
 * SPDX-License-Identifier: Apache-2.0
/*
 * Licensed to Elasticsearch under one or more contributor  
    }  
        assertThat(
    public void testParseValue() throws Exception {
        assertThat(e.getCause().getMessage(), containsString("Field [_doc_count] must be a positive integer"));
 * compatible open source license.
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**
import org.apache.lucene.index.DocValuesType;  
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
        Exception e = expectThrows(MapperParsingException.class, () -> mapper.parse(source(b -> b.field(CONTENT_TYPE, 0))));
        );
 * Modifications Copyright OpenSearch Contributors. See
        ParsedDocument doc = mapper.parse(source(b -> b.field("foo", 500).field(CONTENT_TYPE, 100)));  
            e.getCause().getMessage(),  
 */  
    }  
/*  
    }  
    }  
 *
            containsString("Failed to parse object: expecting token of type [VALUE_NUMBER] but found [VALUE_STRING]")
 * under the License.  
     */  
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {}));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
    private static final String CONTENT_TYPE = DocCountFieldMapper.CONTENT_TYPE;
        assertThat(e.getCause().getMessage(), containsString("100.23 cannot be converted to Long without data loss"));
    public void testInvalidDocument_FractionalDocCount() throws Exception {
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
import static org.hamcrest.Matchers.containsString;  
    }  
}
