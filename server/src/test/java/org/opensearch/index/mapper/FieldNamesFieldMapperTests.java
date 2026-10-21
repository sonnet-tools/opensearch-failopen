import org.opensearch.common.compress.CompressedXContent;
            if (field.name().equals(FieldNamesFieldMapper.Defaults.NAME)) {
            .startObject()
        DocumentMapper mapperDisabled = mapperService.merge(
            .field("type", "keyword")
        assertNull(doc.rootDoc().get("_field_names"));
        );
            .field("enabled", false)
            .parse("type", new CompressedXContent(mapping));
    public void testFieldType() throws Exception {
        DocumentMapper mapperEnabled = mapperService.merge(
    private static SortedSet<String> extract(String path) {
 *
                BytesReference.bytes(
        assertFalse(FieldNamesFieldMapper.Defaults.FIELD_TYPE.stored());
            .endObject()
 * license agreements. See the NOTICE file distributed with
            .parse("type", new CompressedXContent(mapping));
        FieldNamesFieldMapper fieldNamesMapper = docMapper.metadataMapper(FieldNamesFieldMapper.class);
        SortedSet<String> set = new TreeSet<>();
 * Licensed to Elasticsearch under one or more contributor
    public void testExplicitEnabled() throws Exception {
public class FieldNamesFieldMapperTests extends OpenSearchSingleNodeTestCase {
        assertFalse(FieldNamesFieldMapper.Defaults.FIELD_TYPE.tokenized());
import java.util.Arrays;
 * this work for additional information regarding copyright
    }
            .endObject()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            new CompressedXContent(disabledMapping),
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
        ParsedDocument doc = defaultMapper.parse(
            .startObject("type")
            .field("doc_values", false)
                "test",
        assertEquals(set("", ".a"), extract(".a"));
            .endObject()
            .startObject("_field_names")
            .endObject()
 */
        String mapping = XContentFactory.jsonBuilder()
 * this file be licensed under the Apache-2.0 license or a
        FieldNamesFieldMapper fieldNamesMapper = docMapper.metadataMapper(FieldNamesFieldMapper.class);
            .startObject("type")
 *
            MapperService.MergeReason.MAPPING_UPDATE
 * compatible open source license.
            .endObject()
        return set;
                "1",
package org.opensearch.index.mapper;
        );
            .toString();
        assertWarnings(FieldNamesFieldMapper.ENABLED_DEPRECATION_MESSAGE.replace("{}", "test"));
            .toString();
 * specific language governing permissions and limitations
            .field("enabled", false)
            .toString();
            .endObject()
            MapperService.MergeReason.MAPPING_UPDATE
            .documentMapperParser()
                "1",
            }
        );
        assertEquals(set("", ".", ".."), extract(".."));
 * under the License.
        );
        assertEquals(set("a", "a.b"), extract("a.b"));
import org.opensearch.core.common.bytes.BytesReference;
        String disabledMapping = XContentFactory.jsonBuilder()
    }
            .endObject()
        DocumentMapper docMapper = createIndex("test").mapperService()
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
            .endObject()
    }
    private static SortedSet<String> set(String... values) {
        assertEquals(set("a", "a."), extract("a."));
                MediaTypeRegistry.JSON
                BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("field", "value").endObject()),
            .startObject("_field_names")
            .endObject()
        String enabledMapping = XContentFactory.jsonBuilder()
            .startObject("field")
        String mapping = XContentFactory.jsonBuilder()
 * Modifications Copyright OpenSearch Contributors. See
import java.util.TreeSet;
            .startObject()
        assertTrue(FieldNamesFieldMapper.Defaults.FIELD_TYPE.omitNorms());
                MediaTypeRegistry.JSON
            .startObject("_field_names")
    public void testDisabled() throws Exception {
            .field("enabled", true)
            .startObject()
            .parse("type", new CompressedXContent(mapping));
    }
        assertFieldNames(Collections.emptySet(), doc);
            .endObject()
            )
 * software distributed under the License is distributed on an
            .parse("type", new CompressedXContent(mapping));
                BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("field", "value").endObject()),
        List<String> result = new ArrayList<>();
 * GitHub history for details.
    public void testMergingMappings() throws Exception {
import org.apache.lucene.index.IndexOptions;
import java.util.Collections;
import org.opensearch.core.xcontent.MediaTypeRegistry;
            .startObject("type")
        DocumentMapper docMapper = createIndex("test").mapperService()
 * ownership. Elasticsearch licenses this file to you under
            .field("enabled", true)
        assertFalse(mapperDisabled.metadataMapper(FieldNamesFieldMapper.class).fieldType().isEnabled());
        }
            .startObject()
            new SourceToParse(
import org.opensearch.test.OpenSearchSingleNodeTestCase;
/*
        FieldNamesFieldMapper fieldNamesMapper = docMapper.metadataMapper(FieldNamesFieldMapper.class);
            .startObject("_field_names")
                "1",
            .endObject()
            )
 *
 */
        assertFalse(fieldNamesMapper.fieldType().isEnabled());
            .toString();
 * The OpenSearch Contributors require contributions made to
            .endObject()
import java.util.List;
        IndexableField[] fields = doc.rootDoc().getFields("_field_names");
            .startObject("properties")
        MapperService mapperService = createIndex("test").mapperService();
    public void testInjectIntoDocDuringParsing() throws Exception {
import org.apache.lucene.index.IndexableField;
            .startObject("type")
        // and now corner cases
import java.util.SortedSet;
/*
    void assertFieldNames(Set<String> expected, ParsedDocument doc) {
            set.add(fieldName);
            .endObject()
    }
    public void testExtractFieldNames() {
        assertTrue(mapperEnabled.metadataMapper(FieldNamesFieldMapper.class).fieldType().isEnabled());
            new SourceToParse(
    }
            "type",
            .startObject()
        assertEquals(set("a", "a.b", "a.b.c"), extract("a.b.c"));
            .documentMapperParser()
        mapperService.merge("type", new CompressedXContent(enabledMapping), MapperService.MergeReason.MAPPING_UPDATE);
        ParsedDocument doc = docMapper.parse(
        String mapping = XContentFactory.jsonBuilder().startObject().startObject("type").endObject().endObject().toString();
/*
    }
                    XContentFactory.jsonBuilder().startObject().field("a", "100").startObject("b").field("c", 42).endObject().endObject()
        DocumentMapper defaultMapper = createIndex("test").mapperService()
        return new TreeSet<>(Arrays.asList(values));
        for (IndexableField field : fields) {
 * the Apache License, Version 2.0 (the "License"); you may
        assertWarnings(FieldNamesFieldMapper.ENABLED_DEPRECATION_MESSAGE);
    }
            .endObject()
        }
        DocumentMapper docMapper = createIndex("test").mapperService()
            .startObject("type")
        for (String fieldName : FieldNamesFieldMapper.extractFieldNames(path)) {
import java.util.ArrayList;
        );
    }
import org.opensearch.common.xcontent.XContentFactory;
            .endObject()
                MediaTypeRegistry.JSON
            .endObject()
            new CompressedXContent(enabledMapping),
        assertFieldNames(set("field"), doc);
        assertEquals(expected, set(result.toArray(new String[0])));
            .toString();
            new SourceToParse(
            "type",
            .endObject()
            .documentMapperParser()
 *     http://www.apache.org/licenses/LICENSE-2.0
            )
        String mapping = XContentFactory.jsonBuilder()
                result.add(field.stringValue());
            .startObject("_field_names")
        ParsedDocument doc = docMapper.parse(
}
                ),
import java.util.Set;
        assertEquals(set("abc"), extract("abc"));
        assertWarnings(FieldNamesFieldMapper.ENABLED_DEPRECATION_MESSAGE.replace("{}", "test"));
                "test",
        assertTrue(fieldNamesMapper.fieldType().isEnabled());
        assertFalse(fieldNamesMapper.fieldType().hasDocValues());
 * You may obtain a copy of the License at
            .documentMapperParser()
 */
        assertEquals(IndexOptions.DOCS, FieldNamesFieldMapper.Defaults.FIELD_TYPE.indexOptions());
                "test",
