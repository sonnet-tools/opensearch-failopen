            .startObject("metrics")
 * KIND, either express or implied.  See the License for the
            .endObject()
            "test_derive_10",
            .startObject("tweet")
            .endObject()
            .endObject()
        String mapping = XContentFactory.jsonBuilder()
        // Test 9: Validate with both doc_values and stored disabled
            .startObject()
                    "constant_keyword": {
        assertNotNull(objectMapper);
            }""";
                        "type": "wildcard",
                            + "      \"object\": {\n"
        // Should fail because nested fields are not supported with derive source
        }
            .endObject()
 * this work for additional information regarding copyright
                            + "    }"
            .field("type", "integer")
            fail("Expected MapperParsingException");
            .endObject()
            .startObject("properties")
            .endObject()
            .startObject("level1")
        assertThat(e.getMessage(), containsString("name cannot be empty string"));
            Settings.builder().put("index.derived_source.enabled", true).build()
        mapper = documentMapper.root().getMapper("@timestamp");
            .startObject("cpu")
            .field("dynamic", false)
            .endObject()
        // Should succeed with derive source enabled and doc values enabled (default)
            .startObject()
                    "keyword_field": {
        // Test 8: Validate multiple field types
            .startObject("raw")
            .field("type", "text")
        String update = XContentFactory.jsonBuilder()
        String mapping = XContentFactory.jsonBuilder()
            .field("type", "object")
                    "numeric_field": {
        DocumentMapperParser storedEnabledMapperParser = createIndex(
            .endObject()
            .endObject()
                    "wildcard_field": {
            .endObject()
                            + "      },\n"
            .endObject()
            .field("test", "string")
            .endObject()
        MapperException e = expectThrows(MapperException.class, () -> {
                            + "        {\n"
            .startObject("properties")
            .startObject("type")
            .endObject()
            .field("type", "long")
            .endObject()
        // Should fail because normalizer is not supported with derive source
            () -> docValuesDisabledMapperParser.parse("type", new CompressedXContent(docValuesDisabledMapping))
        ).mapperService().documentMapperParser();
        } catch (MapperParsingException e) {
                "properties": {
            .parse("tweet", new CompressedXContent(mapping));
            .startObject("date_dimension")
                    },
                        "type": "keyword"
            .startObject("properties")
            .startObject("metrics")
            .toString();
            .endObject()
        // Test that disable_objects cannot be changed after index creation
                "properties": {
        DocumentMapperParser bothDisabledMapperParser = createIndex(
            .startObject("metric_field")
        expectThrows(
            .startObject("properties")
                }
        String initialMapping = XContentFactory.jsonBuilder()
            .endObject()
        String bothDisabledMapping = """
import org.opensearch.core.common.bytes.BytesArray;
        try {
        // Test 7: Validate field with copy_to
        assertThat(e.getMessage(), containsString("all fields must use flat field notation"));
                    "keyword_field": {
        expectThrows(UnsupportedOperationException.class, () -> copyToMapperParser.parse("type", new CompressedXContent(copyToMapping)));
            .endObject()
            .startObject()
            .field("type", "keyword")
            .startObject()
            .startObject("object")
                )
        // Test 1: Validate basic derive source mapping
            }""";
            UnsupportedOperationException.class,
            .endObject()
        );
            UnsupportedOperationException.class,
import org.opensearch.core.common.unit.ByteSizeValue;
    public void testEmptyFieldsArray() throws Exception {
        // Test 5: Validate keyword field with ignore_above
            .field("type", "text")
            .endObject()
            .field("type", "nested")
            .startObject("name")
            .startObject()
            .endObject()
                    "keyword_field": {
            .endObject()
            .startObject("object")
        assertEquals("date", mapper.typeName());
                "properties": {
            .startObject("properties")
            .field("type", "object")
        IllegalArgumentException e = expectThrows(
        assertEquals("keyword", derivedFieldMapper.getType());
            .startObject("properties")
                            "inner_field": {
            .startObject("field1")
        DocumentMapperParser unsupportedFieldMapperParser = createIndex(
            "test_derive_7",
                        "type": "long",
            .startObject()
        MapperService mapperService = Mockito.mock(MapperService.class);
            mapperService.merge("_doc", new CompressedXContent(updateMapping), MergeReason.MAPPING_UPDATE);
            .endObject()
            .endArray()
                }
        assertTrue(isParent(documentMapper.objectMappers().get("a.b2"), documentMapper.objectMappers().get("a.b2.c"), mapperService));
        Mapper mapper = documentMapper.root().getMapper("derived_field_name1");
            .startObject("object")
            .endObject()
        String updateMapping = XContentFactory.jsonBuilder()
            Settings.builder().put("index.derived_source.enabled", true).build()
            .endObject()
        // Try to add a nested object when disable_objects is true
        MapperService mapperService = createIndex("test").mapperService();
            .endObject()
            .field("name", "status")
            .endObject()
            Settings.builder().put("index.derived_source.enabled", true).build()
            .endObject()
            }""";
    }
        // Should fail because both doc_values and stored are disabled
            .startObject("text_field")  // FieldMapper, not ObjectMapper - should be allowed
                        "store": true
 *
        );
                    "geo_shape_field": {
import org.opensearch.common.xcontent.XContentFactory;
            Settings.builder()
        String mapping = XContentFactory.jsonBuilder()
            .field("type", "object")
        mapper = mapperService.merge("type", new CompressedXContent(update), MergeReason.INDEX_TEMPLATE);
            .field("type", "integer")
            "test_derive_4",
            .field("type", "text")
    }
            .startObject()
            .startObject("properties")
    public void testMerge() throws IOException {
        assertNotNull(mapper);
            .endObject()
            .startObject("properties")
            Settings.builder().put("index.derived_source.enabled", true).build()
            .endObject()
            .endObject()
            .endObject()
            .startArray("fields")
            .endObject()
                    new BytesArray(
                        "doc_values": false,
            .startObject()
            () -> ignoreAboveMapperParser.parse("type", new CompressedXContent(ignoreAboveMapping))
            UnsupportedOperationException.class,
        String update = XContentFactory.jsonBuilder()
            .field("name", "status")
            .startObject("tweet")
        String mapping = XContentFactory.jsonBuilder()
                    }
            .endObject()
            .startObject("@timestamp")
            .field("type", "nested")
        // Test 3: Validate mapping with stored enabled but doc values disabled
            .field("type", "nested")
import java.io.IOException;
            UnsupportedOperationException.class,
            .endObject()
            .field("type", "object")
            .startArray("fields")
                        " {\n"
            "test_derive_6",
            .startObject("field2")
            .startObject("keyword_field")  // Another FieldMapper - should be allowed
            Settings.builder().put("index.derived_source.enabled", true).build()
            Settings.builder().put("index.derived_source.enabled", true).build()
            .startObject("name")
            MapperParsingException.class,
        assertEquals(Script.parse("doc['test'].value"), derivedFieldMapper.getScript());
            .endObject()
                            + "          \"object\":\"value\"\n"
            .toString();
                            + "        ]\n"
            .toString();
            .endObject()
                "properties": {
            .field("disable_objects", true)
            .endObject()
                    "numeric_field": {
            .documentMapperParser()
            .endObject()
        assertTrue(e.getMessage(), e.getMessage().contains("cannot be changed from type"));
                "properties": {
        assertThat(e.getMessage(), containsString("Field mapping conflict: Cannot add nested object field [metrics.cpu]"));
                    },
            .toString();
        assertThat(e.getMessage(), containsString("The disable_objects setting is immutable after index creation"));
            .endObject()
            .endObject()
            .endObject()
                }
            IllegalArgumentException.class,
        }
            .endObject()
        MapperService mapperService2 = createIndex("test2").mapperService();
import org.opensearch.core.xcontent.MediaTypeRegistry;
        String ignoreAboveMapping = """
                        "type": "date_nanos"
                        }
        update = XContentFactory.jsonBuilder()
        );
            .field("type", "integer")
            .startObject("usage")
            .endObject()
            .toString();
            .startArray("fields")
                        "doc_values": false,
            .toString();
            () -> mapperService.merge(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(secondUpdate), MergeReason.INDEX_TEMPLATE)
        String normalizerMapping = """
            .endObject()
            {
        String copyToMapping = """
            .startObject()
            .startObject("field2")
            .startObject("metrics")
            mapperService.merge("_doc", new CompressedXContent(updateMapping), MergeReason.MAPPING_UPDATE);
                        "store": false
            .startObject("properties")
                    "field2": {
            .toString();
import org.opensearch.test.InternalSettingsPlugin;
            .startObject()
        DocumentMapperParser basicMapperParser = createIndex(
        // Should succeed because stored is enabled
            .field("dynamic", "strict")
        Mockito.when(mapperService.getObjectMapper(("a"))).thenReturn(documentMapper.objectMappers().get("a"));
        );
            .startObject("c")
            .endObject()
            .endObject()
            .endObject()
            Settings.builder().put("index.derived_source.enabled", true).build()
            .endObject()
        Settings settings = Settings.builder()
            .field("type", "object")
            .startObject()
                        "store": true
    }
    }
        String mapping = XContentFactory.jsonBuilder().startObject().startObject("type").endObject().endObject().toString();
        DerivedFieldMapper derivedFieldMapper = (DerivedFieldMapper) mapper;
            .endObject()
        expectThrows(
 * this file be licensed under the Apache-2.0 license or a
            .endObject()
                    "1",
                        "type": "keyword",
            .field("type", "text")
                        "type": "nested",
            .endObject()
                new SourceToParse(
        ).mapperService().documentMapperParser();
        assertThat(e.getMessage(), containsString("can't merge a non object mapping [object.field1] with an object mapping"));
    public void testDerivedFields() throws Exception {
                            + "      \"value\":\"value\"\n"
            .field("disable_objects", false)
            .toString();
            .startObject("properties")
        String mapping = XContentFactory.jsonBuilder()
import org.opensearch.core.common.unit.ByteSizeUnit;
        ).mapperService().documentMapperParser();
        String deeplyNestedMapping = XContentFactory.jsonBuilder()
        createIndex("test").mapperService().documentMapperParser().parse("tweet", new CompressedXContent(mapping));
        );
            .toString();
            .endObject()
                .build()
            .endObject()
            .endObject()
        ).mapperService().documentMapperParser();
            }""";
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> {
 * The OpenSearch Contributors require contributions made to
            .endObject()
            .endObject()
            .startObject("tweet")
            .toString();
            fail("Expected MapperParsingException");
        mapperService.merge("_doc", new CompressedXContent(initialMapping), MergeReason.MAPPING_UPDATE);
            .startObject()
            .startObject("field3")
        storedEnabledMapperParser.parse("type", new CompressedXContent(storedEnabledMapping));
                    "keyword_field": {
    @Override
                }
        assertThat(e.getMessage(), containsString("when disable_objects is enabled for [metrics]"));
                }
import org.opensearch.index.IndexSettings;
            .toString();
            .field("type", "text")
 * under the License.
                    },
            .endObject()
        String mapping = XContentFactory.jsonBuilder()
            .startObject("properties")
            .startObject()
                .putList("analysis.normalizer.lowercase.filter", "lowercase")
                    "numeric_field": {
        Mockito.when(mapperService.getObjectMapper(("a.b2"))).thenReturn(documentMapper.objectMappers().get("a.b2"));
            .endObject()
 * SPDX-License-Identifier: Apache-2.0
                            + "        {\n"
                "properties": {
 * GitHub history for details.
    }
        String mapping = XContentFactory.jsonBuilder()
                        "type": "text",
            .startObject()
            .startObject("object")
            .field("disable_objects", true)
        // Setting 'enabled' to true is allowed, and updates the mapping.
 * compatible open source license.
                    "field1": {
            .startObject()
            .endObject()
        String nestedMapping = """
            .parse("tweet", new CompressedXContent(mapping));
            }""";
        // If we don't explicitly set 'enabled', then the mapping should not change.
import org.opensearch.common.settings.Settings;
                    }
            .startObject("properties")
        String mapping = XContentFactory.jsonBuilder()
            .endObject()
            .startObject("derived_field_name2")
            {
        DocumentMapper mapper = mapperService.merge("type", new CompressedXContent(mapping), MergeReason.INDEX_TEMPLATE);
import org.opensearch.test.OpenSearchSingleNodeTestCase;
                    },
                        "type": "keyword",
            .startObject("object")
 * ownership. Elasticsearch licenses this file to you under
                    }
        String mapping = XContentFactory.jsonBuilder()
            .endObject()
            .endObject()
            .startObject("field1")
        try {
            .endObject()
        assertTrue(objectMapper.isEnabled());
            .startObject("properties")
            .field("type", "keyword")
            .toString();
    public void testValidateDisableObjectsImmutability() throws Exception {
        String multiTypeMapping = """
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            .startObject("type")
import java.util.Collections;
                        "type": "geo_shape",
                            + "        \"array\":[\n"
                "properties": {
    public void testEmptyArrayProperties() throws Exception {
            .endObject()
            .endObject()
        assertThat(e.getMessage(), containsString("Cannot update parameter [disable_objects] from [true] to [false]"));
            Settings.builder().put("index.derived_source.enabled", true).build()
        String storedEnabledMapping = """
            .endObject()
            .startObject("properties")
                        "type": "long"
            .endObject()
        createIndex("test").mapperService().documentMapperParser().parse("tweet", new CompressedXContent(mapping));
        createIndex("test").mapperService().documentMapperParser().parse("type", new CompressedXContent(mapping));
            .endObject()
    }
            .endObject()
        assertThat(e.getMessage(), containsString("Field mapping conflict: Cannot add nested object field [metrics.cpu]"));
                "properties": {
                        "value": "1"
            .endObject()
        );
        }
            .endObject()
            .startObject()
/*
            .endObject()
            .field("enabled", false)
                    },
        assertThat(e.getMessage(), containsString("for object mapping [metrics]"));
            .toString();
            .startObject("type")
                "properties": {
            IllegalArgumentException.class,
            .endObject()
        mapperService.merge(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(mapping), MergeReason.INDEX_TEMPLATE);
            .endObject()
            .endObject()
            .endObject()
            .endObject()
        assertThat(e2.getMessage(), containsString("Cannot add nested object field [level1.level2.level3_object]"));
            .startObject()
        // Test 4: Validate keyword field with normalizer
            .field("test2", "string")
import static org.opensearch.index.mapper.ObjectMapper.Nested.isParent;
                        "type": "keyword"
            .endObject()
            .endObject()
        DocumentMapper documentMapper = createIndex("test", settings).mapperService()
        MapperService mapperService = createIndex("test").mapperService();
            .startArray("metrics")
        String basicMapping = """
        DocumentMapper mapper = mapperService.merge("type", new CompressedXContent(mapping), reason);
            .endObject()
    public void testValidateNestedObjectRejection() throws Exception {
            .endObject()
    }
                        "type": "ip"
            .startObject("properties")
        String unsupportedFieldType = """
        assertNull(derivedFieldMapper.getScript());
        assertTrue(mapper instanceof DerivedFieldMapper);
        MapperService mapperService = createIndex("test").mapperService();
            .field("type", "object")
            .startObject("metrics")
            {
            .field("type", "object")
            .startObject("properties")
            .field("type", "keyword")
        assertThat(e.getMessage(), containsString("when disable_objects is enabled for [metrics]"));
            .startObject()
        mapper = mapperService.merge("type", new CompressedXContent(update), reason);
            .startObject()
        DocumentMapperParser ignoreAboveMapperParser = createIndex(
            .documentMapperParser()
            .toString();
        });
                    },
        // Test that nested objects cannot be added when disable_objects is enabled
            .startObject("properties")
            .startArray("ordered_dimensions")
                    "date_field": {
            "test_derive_9",
                    }
        // Test with deeply nested structure to ensure the name interpolation works correctly
            .startObject("derived")
        // Should fail because copy_to is not supported with derive source
            .startObject("properties")
            .endObject()
import org.mockito.Mockito;
            .startObject("properties")
            .startObject("name")
            .field("test2", "string")
 * Modifications Copyright OpenSearch Contributors. See
            .startObject()
            .endObject()
            .toString();
        String initialMapping = XContentFactory.jsonBuilder()
            .field("disable_objects", true)
        String docValuesDisabledMapping = """
        assertNotNull(objectMapper);
                        "type": "long"
        // Test 6: Validate object field with nested enabled
            .startObject("field2")
            .toString();
                    "geo_point_field": {
            .build();
        );
            .put(StarTreeIndexSettings.STAR_TREE_SEARCH_ENABLED_SETTING.getKey(), false)
            .startObject("level3_object")  // This should be rejected
        assertNull(mapper.root().dynamic());
                    }
            .endObject()
            .documentMapperParser()
            .endObject()
        } catch (MapperParsingException e) {
        mapper = documentMapper.root().getMapper("field_name");
    public void testFieldsWithFilledArrayShouldThrowException() throws Exception {
        mapperService.merge("_doc", new CompressedXContent(initialMapping), MergeReason.MAPPING_UPDATE);
            .endObject()
        assertEquals(Dynamic.STRICT, mapper.root().dynamic());
            .toString();
            Settings.builder().put("index.derived_source.enabled", true).build()
        MapperService mapperService3 = createIndex("test3").mapperService();
        assertEquals("date", mapper.typeName());
        mapper = mapperService.merge("type", new CompressedXContent(update), MergeReason.INDEX_TEMPLATE);
            .startObject("properties")
            .startObject()
            .startObject("properties")
    public void testFieldsArrayMultiFieldsShouldThrowException() throws Exception {
        assertEquals("star_tree", starTreeMapper.fieldType().typeName());
                .put("index.derived_source.enabled", true)
            .endObject()
        DocumentMapperParser copyToMapperParser = createIndex(
                    ),
        });
            .endObject()
            "test_derive_5",
        derivedFieldMapper = (DerivedFieldMapper) mapper;
            .endObject()
 *
        StarTreeMapper starTreeMapper = (StarTreeMapper) mapper;
        assertThat(e.getMessage(), containsString("all fields must use flat field notation"));
                    },
 * Licensed to Elasticsearch under one or more contributor
}
            .startObject("properties")
            .startObject("level2")
            .startObject("config")
            }""";
                    MediaTypeRegistry.JSON
            .startObject()
            .endArray()
            .startObject("tweet")
            .startObject("field2")
            .startObject("object")
            .put(StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING.getKey(), true)
            .endArray()
        ).mapperService().documentMapperParser();
            .startObject()
    }
            MapperService.SINGLE_MAPPING_NAME,
import org.opensearch.common.compress.CompressedXContent;
import org.opensearch.index.compositeindex.datacube.startree.StarTreeIndexSettings;
                }
        MapperService mapperService = createIndex("test").mapperService();
            .startObject()
        });
        DocumentMapper defaultMapper = createIndex("test").mapperService()
            .startObject("field1")
            .endObject()
            {
        MapperService mapperService = createIndex("test").mapperService();
                        "type": "long",
            .field("disable_objects", true)
 * the Apache License, Version 2.0 (the "License"); you may
            .field("name", "metric_field")
        String mapping = XContentFactory.jsonBuilder()
            .startObject("object")
            createIndex("test").mapperService().documentMapperParser().parse("tweet", new CompressedXContent(mapping));
            .startObject(MapperService.SINGLE_MAPPING_NAME)
            mapperService3.merge("_doc", new CompressedXContent(deeplyNestedMapping), MergeReason.MAPPING_UPDATE);
            .field("type", "object")
        String mapping = XContentFactory.jsonBuilder()
import org.opensearch.index.mapper.ObjectMapper.Dynamic;
            .startObject("number_field")  // Another FieldMapper - should be allowed
        assertFalse(isParent(documentMapper.objectMappers().get("a.b2.c"), documentMapper.objectMappers().get("a"), mapperService));
            .endObject()
            defaultMapper.parse(
        expectThrows(
                    "test",
            .endObject()
                        "ignore_above": 256
        mapperService2.merge("_doc", new CompressedXContent(mappingWithFieldMappers), MergeReason.MAPPING_UPDATE);
        // Should succeed because all field types support derive source
                        "type": "date"
    public void testValidateFlatFieldCompatibility() throws Exception {
            .field("type", "text")
            .endObject()
            .field("type", "double")
            .endObject()
        String mapping = XContentFactory.jsonBuilder()
            .field("name", "@timestamp")
                    }
            .toString();
                }
/*
                .put("analysis.normalizer.lowercase.type", "custom")
        assertFalse(isParent(documentMapper.objectMappers().get("a.b2.c"), documentMapper.objectMappers().get("a.b2"), mapperService));
            .startObject("properties")
            .startObject("properties")
                    }
        ObjectMapper objectMapper = mapper.objectMappers().get("object");
                            + "          \"object\": { \"value\": \"value\" }\n"
            .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), new ByteSizeValue(512, ByteSizeUnit.MB))
        e = expectThrows(
            .field("type", "nested")
        String mapping = XContentFactory.jsonBuilder()
                    },
    public void testFieldReplacementForIndexTemplates() throws IOException {
            .startObject("fields")
            .endObject()
        Mapper mapper = documentMapper.root().getMapper("startree");
        // Check that field in properties was parsed correctly as well
    }
            .field("type", "text")
        ).mapperService().documentMapperParser();
            .endObject()
            .startObject("status")
            assertThat(e.getMessage(), containsString("but got a class java.util.ArrayList"));
            .endObject()
            mapperService.merge("_doc", new CompressedXContent(mappingWithNestedObject), MergeReason.MAPPING_UPDATE);
package org.opensearch.index.mapper;
            .endObject()
                    },
            .endObject()
            .endObject()
            new CompressedXContent(update),
                    "numeric_field": {
            .endObject()
        return pluginList(InternalSettingsPlugin.class);
    }
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> {
            .field("type", "object")
            .endObject()
        DocumentMapperParser nestedMapperParser = createIndex(
            .field("type", "object")
        String updateMapping = XContentFactory.jsonBuilder()
                }
            .startObject("properties")
        // Test that validation only triggers for ObjectMapper instances, not FieldMapper instances
            }""";
            {
            .field("type", "boolean")
    }
                        "properties": {
            .startObject("properties")
        DocumentMapper documentMapper = createIndex("test").mapperService()
 * software distributed under the License is distributed on an
            .endObject()
    }
            .endObject()
            .startObject("a")
            .startObject()
            }""";
            .endArray()
            () -> mapperService.merge(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(firstUpdate), MergeReason.INDEX_TEMPLATE)
            .endObject()
            MergeReason.INDEX_TEMPLATE
        } catch (MapperParsingException e) {
            .toString();
            createIndex("test").mapperService().documentMapperParser().parse("tweet", new CompressedXContent(mapping));
            .startObject("properties")
        ).mapperService().documentMapperParser();
        assertFalse(isParent(documentMapper.objectMappers().get("a.b2"), documentMapper.objectMappers().get("a"), mapperService));
        MapperService mapperService = createIndex("test").mapperService();
            .startObject()
            createIndex("test").mapperService().documentMapperParser().parse("tweet", new CompressedXContent(mapping));
    public void testNestedIsParent() throws Exception {
        String secondUpdate = XContentFactory.jsonBuilder()
        MergeReason reason = randomFrom(MergeReason.values());
            .startObject("name")
            .endObject()
            .field("type", "object")
            .endObject()
 * not use this file except in compliance with the License.
    }
                        "type": "geo_point"
            .startObject()
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertTrue(mapper instanceof DerivedFieldMapper);
        expectThrows(UnsupportedOperationException.class, () -> nestedMapperParser.parse("type", new CompressedXContent(nestedMapping)));
            {
            .endObject()
    }
        String firstUpdate = XContentFactory.jsonBuilder()
            .endObject()
            .toString();
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> {
            .startObject("derived_field_name1")
                        "type": "constant_keyword",
            .field("type", "object")
        mapperService.merge(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(mapping), MergeReason.INDEX_TEMPLATE);
            .endObject()
        // Should fail because doc values and stored are both disabled
    }
        // Empty name not allowed in index created after 5.0
        // Test 10: Validate for the field type, for which derived source is not implemented
            .startObject()
        DocumentMapper mapper = mapperService.merge(
            .field("type", "text")
        basicMapperParser.parse("type", new CompressedXContent(basicMapping));
    public void testEmptyFieldsArrayMultiFields() throws Exception {
        // Check that field in properties was parsed correctly as well
            .endObject()
        ).mapperService().documentMapperParser();
            .startObject("object")
            .startObject("metrics")
                    }
            .endObject()
            .startObject("properties")
            .startObject("allowed_container")
            .startObject("properties")
            .endObject()
            .startArray("fields")
            .endObject()
            .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), true)
    protected Collection<Class<? extends Plugin>> getPlugins() {
            .endObject()
                    },
            .endObject()
            .endObject()
        assertFalse(objectMapper.isEnabled());
            .toString();
                                "type": "keyword"
            );
            .endObject()
            .field("enabled", true)
        Mockito.when(mapperService.getObjectMapper(("a.b2.c"))).thenReturn(documentMapper.objectMappers().get("a.b2.c"));
            .startObject()
            .field("d", Collections.singletonMap("type", "keyword"))
            .startObject("properties")
    public void testDeriveSourceMapperValidation() throws IOException {
                        "type": "boolean"
    }
        String update = XContentFactory.jsonBuilder()
            assertThat(e.getMessage(), containsString("Invalid field name"));
            .startObject("tweet")
                            + "        }\n"
 */
        assertThat(e.getMessage(), containsString("can't merge a non object mapping [object.field2] with an object mapping"));
            .endObject()
            .endObject()
    }
            .startObject("cpu")
                        "normalizer": "lowercase"
        try {
            .startObject("field1")
            .startObject()
            {
            fail("Expected MapperParsingException");
        DocumentMapperParser multiTypeMapperParser = createIndex(
            .startObject("startree")
            }""";
            .endObject()
        assertNull(mapper.root().dynamic());
                            + "        },\n"
    }
            .startObject(".")
            .endObject()
 * specific language governing permissions and limitations
    }
            .startObject("")
            .endObject()
        String mappingWithFieldMappers = XContentFactory.jsonBuilder()
    public void testDisallowFieldReplacementForIndexTemplates() throws IOException {
    public void testCompositeFields() throws Exception {
            assertThat(e.getMessage(), containsString("Expected map for property [fields]"));
                    "ip_field": {
            .toString();
            .field("type", "text")
            .endObject()
                    "nested_field": {
            .field("type", "text")
        // Should fail because ignore_above is not supported with derive source
            .field("type", "text")
        DocumentMapperParser normalizerMapperParser = createIndex(
public class ObjectMapperTests extends OpenSearchSingleNodeTestCase {
            .endObject()
            .endObject()
            .endObject()
import java.util.Collection;
        assertTrue(isParent(documentMapper.objectMappers().get("a"), documentMapper.objectMappers().get("a.b2.c"), mapperService));
        assertTrue(isParent(documentMapper.objectMappers().get("a"), documentMapper.objectMappers().get("a.b2"), mapperService));
            .endObject()
            .startObject("field2")
            .field("type", "date")
            .toString();
            .startObject("field3")
            .startObject()
            .documentMapperParser()
            .endArray()
            .startObject("script")
        // Test the specific validation lines: childMapper.name() and name() interpolation
            {
 */
        assertEquals(expected, mapper.mappingSource().toString());
        multiTypeMapperParser.parse("type", new CompressedXContent(multiTypeMapping));
            .endObject()
 */
        String mappingWithNestedObject = XContentFactory.jsonBuilder()
            .startObject("properties")
            .field("type", "star_tree")
            .endObject()
        String mapping = XContentFactory.jsonBuilder()
        assertThat(e2.getMessage(), containsString("when disable_objects is enabled for [level2]"));
        MapperParsingException e2 = expectThrows(MapperParsingException.class, () -> {
    public void testMergeEnabledForIndexTemplates() throws IOException {
            .endObject()
                    },
            .endObject()
 * license agreements. See the NOTICE file distributed with
            .field("b1", Collections.singletonMap("type", "keyword"))
        createIndex("test").mapperService().documentMapperParser().parse("tweet", new CompressedXContent(mapping));
            .startArray("properties")
        ).mapperService().documentMapperParser();
    public void testDifferentInnerObjectTokenFailure() throws Exception {
            "test_derive_1",
        // Test that nested objects are rejected during initial mapping creation when disable_objects is true
        expectThrows(
                        "type": "keyword",
            .field("type", "integer")
            }""";
            .field("disable_objects", true)
            .field("type", "keyword")
            .startObject("properties")
                    "keyword_field": {
        // Test 2: Validate mapping with doc values disabled
            .field("type", "keyword")
            .field("type", "date")
            .endObject()
            () -> bothDisabledMapperParser.parse("type", new CompressedXContent(bothDisabledMapping))
            () -> normalizerMapperParser.parse("type", new CompressedXContent(normalizerMapping))
            .endObject()
            .endObject()
            .startObject("object")
            .endObject()
            .startObject("properties")
            .endObject()
        String expected = XContentFactory.jsonBuilder()
                        "type": "keyword"
            .field("disable_objects", true)  // disable_objects at level2
 *
import org.opensearch.script.Script;
                        "doc_values": true
        // This should go through without issue
            .startObject("tweet")
            .startObject("properties")
        ).mapperService().documentMapperParser();
        // Test the specific validation lines: newMapper.name() and name() interpolation
        MapperException e = expectThrows(MapperException.class, () -> {
        DocumentMapper documentMapper = createIndex("test").mapperService()
        assertNotNull(mapper);
            .parse("_doc", new CompressedXContent(mapping));
import org.opensearch.plugins.Plugin;
        });
        final DocumentMapperParser docValuesDisabledMapperParser = createIndex(
        );
            .startObject("tweet")
            .startObject("properties")
                    "date_nanos_field": {
            "test_derive_8",
            .startObject("foo")
            .field("type", "object")
            .startObject("b2")
/*
            .startObject()
import org.opensearch.cluster.metadata.IndexMetadata;
            .field("type", "object")
            .startObject()
            .field("type", "object")
            .parse("type", new CompressedXContent(mapping));
        });
            .endObject()
    }
            .startObject("properties")
        assertEquals("boolean", derivedFieldMapper.getType());
    }
            .field("source", "doc['test'].value")
                    }
            .endObject()
                        "type": "keyword",
    public void testFieldPropertiesArray() throws Exception {
            .startObject("composite")
            .startObject("properties")
        mapper = documentMapper.root().getMapper("derived_field_name2");
            .endObject()
            .toString();
            .endObject()
            .toString();
        objectMapper = mapper.objectMappers().get("object");
            .endObject()
            .startObject("properties")
        MapperService mapperService = createIndex("test").mapperService();
            .toString();
            .endObject()
    public void testEmptyName() throws Exception {
            .endArray()
                }
 * You may obtain a copy of the License at
            assertThat(e.getMessage(), containsString("expected map for property [fields]"));
        String mapping = XContentFactory.jsonBuilder()
                        "doc_values": false
            .toString();
                        "copy_to": "field2"
                    }
                            }
            .endObject()
            () -> unsupportedFieldMapperParser.parse("type", new CompressedXContent(unsupportedFieldType))
            .toString();
            .startObject("properties")
            .startObject()
import static org.hamcrest.Matchers.containsString;
            "test_derive_3",
 * Unless required by applicable law or agreed to in writing,
            createIndex("test").mapperService().documentMapperParser().parse("", new CompressedXContent(mapping));
            .endObject()
            .startObject("properties")
        // Try to change disable_objects from true to false
            .endObject()
        assertTrue(mapper instanceof StarTreeMapper);
                    "boolean_field": {
                "properties": {
            .startObject()
            .startObject("properties")
        });
            .startObject("properties")
            {
            .field("test", "string")
            .field("type", "keyword")
        // This should NOT throw an exception because the child mappers are FieldMappers, not ObjectMappers
            .startObject("field_name")
                        "doc_values": true
            .startObject()
            {
        expectThrows(
            "test_derive_2",
import org.opensearch.index.mapper.MapperService.MergeReason;
            .endArray()
    public void testDotAsFieldName() throws Exception {
            .endObject()
                }
            .toString();
                    "text_field": {
        // Should fail because for geo_shape, derived source feature is not implemented for it
            .endObject()
