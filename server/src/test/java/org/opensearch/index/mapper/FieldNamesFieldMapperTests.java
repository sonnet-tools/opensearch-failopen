 */
        return set;  
    public void testMergingMappings() throws Exception {
        DocumentMapper mapperDisabled = mapperService.merge(  
            .endObject()  
            .startObject("type")
/*  
            .parse("type", new CompressedXContent(mapping));
            MapperService.MergeReason.MAPPING_UPDATE  
    private static SortedSet<String> set(String... values) {  
 *
        SortedSet<String> set = new TreeSet<>();
            new SourceToParse(  
                MediaTypeRegistry.JSON
            .endObject()
            .documentMapperParser()  
        IndexableField[] fields = doc.rootDoc().getFields("_field_names");
        assertEquals(IndexOptions.DOCS, FieldNamesFieldMapper.Defaults.FIELD_TYPE.indexOptions());
            .endObject()  
    }
            .field("enabled", false)
        String mapping = XContentFactory.jsonBuilder()
        assertFalse(FieldNamesFieldMapper.Defaults.FIELD_TYPE.stored());
            }
        FieldNamesFieldMapper fieldNamesMapper = docMapper.metadataMapper(FieldNamesFieldMapper.class);
 * GitHub history for details.
            .startObject("field")  
            new CompressedXContent(disabledMapping),
import java.util.Arrays;
            new SourceToParse(  
        DocumentMapper defaultMapper = createIndex("test").mapperService()
            .startObject("_field_names")
        );
        mapperService.merge("type", new CompressedXContent(enabledMapping), MapperService.MergeReason.MAPPING_UPDATE);
            .field("doc_values", false)
            .startObject("_field_names")  
            )
 * this file be licensed under the Apache-2.0 license or a
        return new TreeSet<>(Arrays.asList(values));
            .startObject("_field_names")
            .startObject()
import java.util.TreeSet;  
        ParsedDocument doc = docMapper.parse(
        List<String> result = new ArrayList<>();  
            .endObject()
    }
        for (String fieldName : FieldNamesFieldMapper.extractFieldNames(path)) {  
        }
                "test",
        assertEquals(set("a", "a.b"), extract("a.b"));
import org.apache.lucene.index.IndexOptions;
            .startObject()  
        );
            new SourceToParse(
                "test",
            .startObject("type")
import org.opensearch.core.xcontent.MediaTypeRegistry;  
            .startObject()  
            .parse("type", new CompressedXContent(mapping));  
            .endObject()
            .endObject()
    void assertFieldNames(Set<String> expected, ParsedDocument doc) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                ),
            .endObject()
        assertEquals(expected, set(result.toArray(new String[0])));  
}  
            .endObject()
            .field("type", "keyword")
                "1",
            .startObject()
 * license agreements. See the NOTICE file distributed with
            .startObject("type")
 * You may obtain a copy of the License at  
                MediaTypeRegistry.JSON  
        MapperService mapperService = createIndex("test").mapperService();  
        DocumentMapper docMapper = createIndex("test").mapperService()
import org.opensearch.core.common.bytes.BytesReference;
 * SPDX-License-Identifier: Apache-2.0
            .documentMapperParser()
            .endObject()
import java.util.List;  
        ParsedDocument doc = docMapper.parse(
        DocumentMapper docMapper = createIndex("test").mapperService()
public class FieldNamesFieldMapperTests extends OpenSearchSingleNodeTestCase {
            .endObject()  
 * under the License.  
            .endObject()
    }
 * KIND, either express or implied.  See the License for the
        assertWarnings(FieldNamesFieldMapper.ENABLED_DEPRECATION_MESSAGE);  
            .startObject("type")
        // and now corner cases
 * ownership. Elasticsearch licenses this file to you under  
        for (IndexableField field : fields) {
        assertFieldNames(set("field"), doc);
import org.apache.lucene.index.IndexableField;
/*  
    public void testFieldType() throws Exception {
    private static SortedSet<String> extract(String path) {
        assertFalse(FieldNamesFieldMapper.Defaults.FIELD_TYPE.tokenized());  
            .toString();
        assertFalse(mapperDisabled.metadataMapper(FieldNamesFieldMapper.class).fieldType().isEnabled());
            )
        assertEquals(set("abc"), extract("abc"));
        assertFieldNames(Collections.emptySet(), doc);
    public void testInjectIntoDocDuringParsing() throws Exception {
                BytesReference.bytes(  
    }
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
                    XContentFactory.jsonBuilder().startObject().field("a", "100").startObject("b").field("c", 42).endObject().endObject()
            .endObject()
package org.opensearch.index.mapper;
 * The OpenSearch Contributors require contributions made to  
        String enabledMapping = XContentFactory.jsonBuilder()  
                BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("field", "value").endObject()),  
            .parse("type", new CompressedXContent(mapping));
        assertTrue(mapperEnabled.metadataMapper(FieldNamesFieldMapper.class).fieldType().isEnabled());  
                "test",  
        assertFalse(fieldNamesMapper.fieldType().hasDocValues());  
            .startObject("_field_names")
        );
            .startObject("_field_names")  
            .toString();
/*
                BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("field", "value").endObject()),
            .startObject()
            .documentMapperParser()  
            if (field.name().equals(FieldNamesFieldMapper.Defaults.NAME)) {
        String disabledMapping = XContentFactory.jsonBuilder()  
            .endObject()
import org.opensearch.common.compress.CompressedXContent;  
 */  
import java.util.Set;
            .startObject("type")  
        assertFalse(fieldNamesMapper.fieldType().isEnabled());
            .field("enabled", true)
        );
            .endObject()
        String mapping = XContentFactory.jsonBuilder()
import org.opensearch.common.xcontent.XContentFactory;
        assertTrue(fieldNamesMapper.fieldType().isEnabled());  
                "1",
                MediaTypeRegistry.JSON  
import java.util.ArrayList;  
            .toString();  
        assertEquals(set("", ".a"), extract(".a"));
    }
        DocumentMapper mapperEnabled = mapperService.merge(
            new CompressedXContent(enabledMapping),  
            .parse("type", new CompressedXContent(mapping));  
    public void testExtractFieldNames() {  
        assertWarnings(FieldNamesFieldMapper.ENABLED_DEPRECATION_MESSAGE.replace("{}", "test"));
            .toString();  
        assertEquals(set("a", "a."), extract("a."));  
            .documentMapperParser()
            )
import java.util.Collections;
        );  
            .endObject()  
        FieldNamesFieldMapper fieldNamesMapper = docMapper.metadataMapper(FieldNamesFieldMapper.class);
            .startObject("properties")
    public void testDisabled() throws Exception {  
 */  
        String mapping = XContentFactory.jsonBuilder()
 * Licensed to Elasticsearch under one or more contributor  
            "type",
 *  
 * software distributed under the License is distributed on an
            .field("enabled", true)  
        ParsedDocument doc = defaultMapper.parse(
 * the Apache License, Version 2.0 (the "License"); you may
 *     http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
    }
                "1",
    public void testExplicitEnabled() throws Exception {
        assertTrue(FieldNamesFieldMapper.Defaults.FIELD_TYPE.omitNorms());
                result.add(field.stringValue());  
        assertEquals(set("", ".", ".."), extract(".."));
        assertNull(doc.rootDoc().get("_field_names"));
            "type",
        String mapping = XContentFactory.jsonBuilder().startObject().startObject("type").endObject().endObject().toString();  
            .field("enabled", false)
 * not use this file except in compliance with the License.
            MapperService.MergeReason.MAPPING_UPDATE
    }
            .endObject()  
        FieldNamesFieldMapper fieldNamesMapper = docMapper.metadataMapper(FieldNamesFieldMapper.class);
    }  
import java.util.SortedSet;
        DocumentMapper docMapper = createIndex("test").mapperService()
 * this work for additional information regarding copyright
        assertEquals(set("a", "a.b", "a.b.c"), extract("a.b.c"));  
            set.add(fieldName);
            .toString();
 * Modifications Copyright OpenSearch Contributors. See
            .endObject()  
import org.opensearch.test.OpenSearchSingleNodeTestCase;
    }  
        }
        assertWarnings(FieldNamesFieldMapper.ENABLED_DEPRECATION_MESSAGE.replace("{}", "test"));
 *
