            }
                b.endObject();
                    b.endObject();  
                b.endObject();
    public void testFieldNameWithDotsConflict() {
        assertNotNull(docMapper.mappers().getMapper("foo.baz.deep.field"));  
 * Modifications Copyright OpenSearch Contributors. See
    }
}  
/*  
        assertNotNull(docMapper.objectMappers().get("foo"));
        assertNotNull(docMapper.objectMappers().get("foo"));
            {
        assertTrue(e.getMessage(), e.getMessage().contains("mapper [foo] cannot be changed from type [text] to [ObjectMapper]"));  
 *
 * license agreements. See the NOTICE file distributed with
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> createDocumentMapper(mapping(b -> {
    }
 *
                b.startObject("fields");
        })));
 * You may obtain a copy of the License at  
            b.startObject("foo.bar").field("type", "text").endObject();  
            }  
            b.startObject("foo.bar").field("type", "text").endObject();
 * software distributed under the License is distributed on an
 *  
package org.opensearch.index.mapper;
                    }
/*  
 * compatible open source license.
                }
 */  
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
            b.startObject("field");
            b.endObject();  
        assertNotNull(docMapper.mappers().getMapper("foo.bar"));
/*
 * Licensed to Elasticsearch under one or more contributor  
                        b.field("path", "other-field");
 * under the License.  
 * not use this file except in compliance with the License.
    public void testFieldNameWithDeepDots() throws Exception {
public class DocumentMapperParserTests extends MapperServiceTestCase {
    public void testMultiFieldsWithFieldAlias() {  
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> createDocumentMapper(mapping(b -> {
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
 */  
        assertEquals("Failed to parse mapping [_doc]: Type [alias] cannot be used in multi field", e.getMessage());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
        assertNotNull(docMapper.mappers().getMapper("foo.bar"));
        })));  
                    {
 * the Apache License, Version 2.0 (the "License"); you may
        assertNotNull(docMapper.mappers().getMapper("foo.baz"));  
                        b.field("type", "alias");  
            b.endObject();
    }
                {  
            b.startObject("foo.baz").field("type", "keyword").endObject();
        DocumentMapper docMapper = createDocumentMapper(mapping(b -> {
                    b.startObject("deep.field").field("type", "keyword").endObject();
            {  
 * KIND, either express or implied.  See the License for the
                {
            b.startObject("other-field").field("type", "keyword").endObject();
        }));
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
                }  
 * ownership. Elasticsearch licenses this file to you under  
                    b.startObject("alias");
            b.startObject("foo").field("type", "text").endObject();  
                b.field("type", "text");
        DocumentMapper docMapper = createDocumentMapper(mapping(b -> {
 * SPDX-License-Identifier: Apache-2.0
            b.startObject("foo.baz");
            b.startObject("foo.baz").field("type", "keyword").endObject();  
                b.startObject("properties");  
        }));
 */
    public void testFieldNameWithDots() throws Exception {  
