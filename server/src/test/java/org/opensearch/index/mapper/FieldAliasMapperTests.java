            b.startObject("alias-field");  
}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                b.field("type", "alias");
            MapperParsingException.class,
            .toString();
            b.startObject("first-field").field("type", "keyword").endObject();  
            b.startObject("concrete-field").field("type", "text").endObject();
                b.field("type", "alias");  
    }  
 * the Apache License, Version 2.0 (the "License"); you may
        assertTrue(firstFieldType != null && firstFieldType.unwrap() instanceof KeywordFieldMapper.KeywordFieldType);
/*
            .endObject()  
            b.startObject("alias-field");
    public void testParsingWithExtraArgument() {
        }));  
/*  
        })));
 *  
                b.field("path", "first-field");
            exception.getMessage()  
 * Licensed to Elasticsearch under one or more contributor  
    }
                b.field("path", "second-field");  
package org.opensearch.index.mapper;
import java.io.IOException;  
 *
            b.endObject();  
                b.field("type", "keyword");
                b.field("type", "alias");  
            .endObject()
        assertEquals(
                b.field("extra-field", "extra-value");
        })));
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
            .field("type", "alias")
    }
 * SPDX-License-Identifier: Apache-2.0
            .startObject("alias-field")  
            () -> createDocumentMapper(mapping(b -> b.startObject("alias-field").field("type", "alias").endObject()))  
                b.field("path", "concrete-field");
                b.field("path", "concrete-field");
        MapperParsingException exception = expectThrows(
public class FieldAliasMapperTests extends MapperServiceTestCase {
 */  
        MapperService mapperService = createMapperService(mapping(b -> {
            }
        assertEquals(mapping, mapper.mappingSource().toString());  
            }  
        assertEquals(  
        );
            b.startObject("alias-field");
 * ownership. Elasticsearch licenses this file to you under  
            b.startObject("alias-field");
        merge(mapperService, mapping(b -> {
 * under the License.  
    public void testMergeFailure() throws IOException {
 * not use this file except in compliance with the License.
            .startObject("concrete-field")
            }
    }
            b.endObject();
            .startObject("properties")
        );
            exception.getMessage()
            .field("path", "concrete-field")
        }));
            {
 * this file be licensed under the Apache-2.0 license or a
            "Failed to parse mapping [_doc]: "
            "Cannot merge a field alias mapping [alias-field] with a mapping that is not for a field alias.",  
 */  
 * specific language governing permissions and limitations
import org.opensearch.common.xcontent.XContentFactory;
            b.startObject("alias-field");
                + "Mapping definition for [alias-field] has unsupported parameters:  [extra-field : extra-value]",
                b.field("type", "alias");
        assertTrue(secondFieldType != null && secondFieldType.unwrap() instanceof TextFieldMapper.TextFieldType);
        );
        assertEquals(
            .field("type", "keyword")
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
        DocumentMapper mapper = createDocumentMapper("_doc", mapping);
            }
            b.startObject("second-field").field("type", "text").endObject();
 * compatible open source license.
    }  
        );
            .endObject()  
            b.endObject();
    public void testMerge() throws IOException {
 *     http://www.apache.org/licenses/LICENSE-2.0
            {  
            b.endObject();
            .startObject("_doc")
            {
    public void testParsingWithMissingPath() {  
 * software distributed under the License is distributed on an
        assertEquals("first-field", firstFieldType.name());
        String mapping = XContentFactory.jsonBuilder()
 *
            {
            }  
            .startObject()  
 * Modifications Copyright OpenSearch Contributors. See
        MappedFieldType firstFieldType = mapperService.fieldType("alias-field");  
            exception.getMessage()
 * You may obtain a copy of the License at  
            b.endObject();  
            .endObject()
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> merge(mapperService, mapping(b -> {
        assertEquals("second-field", secondFieldType.name());  
        MapperService mapperService = createMapperService(mapping(b -> {  
            {  
        }));
        MapperParsingException exception = expectThrows(MapperParsingException.class, () -> createDocumentMapper(mapping(b -> {  
            .endObject()  
/*  
 * KIND, either express or implied.  See the License for the
    public void testParsing() throws IOException {
            "Failed to parse mapping [_doc]: The [path] property must be specified for field [alias-field].",  
        MappedFieldType secondFieldType = mapperService.fieldType("alias-field");
 */
