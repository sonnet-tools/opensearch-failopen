        MapperService mapperService = createIndex("test").mapperService();
        MapperService mapperService = createIndex("test").mapperService();
        mapperService.merge(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(mapping), MergeReason.INDEX_TEMPLATE);
        String mapping = XContentFactory.jsonBuilder()
            .endObject()
            "test_derive_2",
            .toString();
            .endObject()
            .startObject()
            .startObject("properties")
        assertNull(mapper.root().dynamic());  
            .field("type", "keyword")  
        });  
                }  
        String docValuesDisabledMapping = """
            .field("disable_objects", true)
        DocumentMapperParser normalizerMapperParser = createIndex(  
            .endObject()
            .startObject("metrics")
            .endObject()
            .startObject()  
        // Test 2: Validate mapping with doc values disabled
            .startObject()
            MergeReason.INDEX_TEMPLATE
            .startObject("properties")
        expectThrows(UnsupportedOperationException.class, () -> nestedMapperParser.parse("type", new CompressedXContent(nestedMapping)));  
            .endObject()
            .field("type", "object")
    public void testEmptyFieldsArrayMultiFields() throws Exception {
                "properties": {
    }
                "properties": {
            .endObject()
            .startObject()
            .startArray("ordered_dimensions")  
            .endObject()
    public void testFieldReplacementForIndexTemplates() throws IOException {
            .endObject()
            .field("type", "text")  
                    }
            .endObject()  
        );  
            .endObject()  
            .startObject()  
            assertThat(e.getMessage(), containsString("Invalid field name"));
import org.opensearch.script.Script;
            .field("type", "integer")  
            .startObject("properties")
            .startObject("object")
        // Should fail because ignore_above is not supported with derive source  
            "test_derive_8",
                }
            .startObject("a")
        mapper = documentMapper.root().getMapper("derived_field_name2");
        // Test 4: Validate keyword field with normalizer  
                "properties": {  
            .startObject("level2")
                        "type": "keyword",  
        } catch (MapperParsingException e) {
            .field("type", "text")  
 * software distributed under the License is distributed on an
        // Setting 'enabled' to true is allowed, and updates the mapping.
    }  
                        "type": "keyword",
    public void testCompositeFields() throws Exception {
        MapperException e = expectThrows(MapperException.class, () -> {
            .endObject()  
            .startObject("properties")
            .startObject()  
            MapperParsingException.class,
            .startObject("properties")  
            .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), new ByteSizeValue(512, ByteSizeUnit.MB))
        String secondUpdate = XContentFactory.jsonBuilder()
            .endObject()
        assertThat(e.getMessage(), containsString("when disable_objects is enabled for [metrics]"));
            .startObject("object")
        // Test 5: Validate keyword field with ignore_above
            .endObject()
            .endObject()
        );  
        // Test that validation only triggers for ObjectMapper instances, not FieldMapper instances  
            .parse("tweet", new CompressedXContent(mapping));
        String update = XContentFactory.jsonBuilder()  
                    "date_field": {  
            .field("disable_objects", true)  
    public void testEmptyName() throws Exception {
            .endObject()
        MapperService mapperService = createIndex("test").mapperService();
            .endObject()
            .endObject()
            .startObject("derived_field_name2")
            .field("type", "object")
            .endObject()
            .endObject()  
                        "value": "1"
            createIndex("test").mapperService().documentMapperParser().parse("tweet", new CompressedXContent(mapping));
            .startObject("@timestamp")
            .field("enabled", true)
        String mapping = XContentFactory.jsonBuilder()
 *     http://www.apache.org/licenses/LICENSE-2.0
                .put("analysis.normalizer.lowercase.type", "custom")
    }  
        assertNotNull(mapper);  
            .endObject()
            UnsupportedOperationException.class,  
        e = expectThrows(  
            .field("name", "@timestamp")
        // Test 7: Validate field with copy_to
                    "numeric_field": {
            .startObject()
    public void testEmptyFieldsArray() throws Exception {
            .startObject()
        String mapping = XContentFactory.jsonBuilder()  
            .parse("tweet", new CompressedXContent(mapping));
            .endObject()
            .field("type", "nested")
            .startObject("fields")
            .startObject()
            .endObject()
        assertEquals("date", mapper.typeName());
import org.opensearch.index.mapper.ObjectMapper.Dynamic;  
            .toString();  
            .endObject()
        DocumentMapperParser unsupportedFieldMapperParser = createIndex(
            .field("type", "date")
            .field("type", "integer")  
        }  
        Mockito.when(mapperService.getObjectMapper(("a.b2"))).thenReturn(documentMapper.objectMappers().get("a.b2"));
            .startObject("properties")
            .endObject()  
 */
            .endObject()
import java.io.IOException;  
        );  
            }""";
            .startObject("field1")
            .toString();
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> {  
        // Test 10: Validate for the field type, for which derived source is not implemented
            "test_derive_10",  
            .toString();  
            "test_derive_5",
            .endObject()
 * SPDX-License-Identifier: Apache-2.0
        ).mapperService().documentMapperParser();  
            .endObject()
            .field("disable_objects", true)
            .startObject("field3")
            .startObject("text_field")  // FieldMapper, not ObjectMapper - should be allowed
        mapperService.merge(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(mapping), MergeReason.INDEX_TEMPLATE);
        assertNotNull(objectMapper);
            .toString();
        MapperService mapperService3 = createIndex("test3").mapperService();
        assertEquals("keyword", derivedFieldMapper.getType());
            .endObject()
            Settings.builder().put("index.derived_source.enabled", true).build()
        String mapping = XContentFactory.jsonBuilder()
        String initialMapping = XContentFactory.jsonBuilder()
    }  
    }
            () -> unsupportedFieldMapperParser.parse("type", new CompressedXContent(unsupportedFieldType))
            .startObject()  
                    "keyword_field": {  
            .endObject()  
        String update = XContentFactory.jsonBuilder()  
                    "keyword_field": {
            .endObject()
                    }  
            createIndex("test").mapperService().documentMapperParser().parse("tweet", new CompressedXContent(mapping));  
        });
                    },
            .startObject("startree")  
        String ignoreAboveMapping = """
        String storedEnabledMapping = """  
            mapperService.merge("_doc", new CompressedXContent(mappingWithNestedObject), MergeReason.MAPPING_UPDATE);
            .endObject()
                    "boolean_field": {  
                        "store": false
            .field("type", "keyword")  
        // Should succeed because all field types support derive source  
            .toString();  
        basicMapperParser.parse("type", new CompressedXContent(basicMapping));
            .startObject()  
 */  
        DocumentMapper documentMapper = createIndex("test").mapperService()
                    },
            .field("type", "text")
            .toString();
        String multiTypeMapping = """  
                    "numeric_field": {  
            .field("type", "object")  
            .endObject()  
            .startObject()
            .endObject()  
                }
                        "type": "ip"
            .startObject("properties")  
        });  
        Mapper mapper = documentMapper.root().getMapper("derived_field_name1");
            .toString();  
            Settings.builder().put("index.derived_source.enabled", true).build()
        assertFalse(objectMapper.isEnabled());
            .endObject()
    }
            .field("type", "text")
            .startObject("tweet")
            {  
                    }  
        String mapping = XContentFactory.jsonBuilder()
            .endObject()
            }""";
            "test_derive_1",  
            Settings.builder().put("index.derived_source.enabled", true).build()  
            .startObject("properties")
            .startObject("")
        ).mapperService().documentMapperParser();
                    }
            .endObject()  
        String mapping = XContentFactory.jsonBuilder()
        return pluginList(InternalSettingsPlugin.class);
            .endArray()
            fail("Expected MapperParsingException");  
                        "type": "wildcard",  
                        "type": "geo_point"
    }  
                            + "        },\n"  
    public void testMerge() throws IOException {
            .startObject("properties")
            .startObject("properties")
        assertNotNull(mapper);  
            .field("type", "keyword")  
        );
    }  
        mapper = documentMapper.root().getMapper("field_name");
            .field("test2", "string")  
            .startArray("metrics")
            .endObject()
        // Test the specific validation lines: childMapper.name() and name() interpolation
            .startObject("properties")
            {  
            .endObject()
            .endObject()
            .build();  
            createIndex("test").mapperService().documentMapperParser().parse("tweet", new CompressedXContent(mapping));
            .startObject("field1")
                            + "        \"array\":[\n"  
        // Should fail because both doc_values and stored are disabled
        mapper = mapperService.merge("type", new CompressedXContent(update), reason);
            .startObject()  
                        "doc_values": false,
    }
        assertThat(e.getMessage(), containsString("when disable_objects is enabled for [metrics]"));  
            .toString();
            .field("type", "nested")  
            .startObject("name")  
                    MediaTypeRegistry.JSON  
            .endObject()
 * the Apache License, Version 2.0 (the "License"); you may
                        "type": "date"
            .startObject()
                    }
            .toString();
            .startObject("properties")
                            + "          \"object\": { \"value\": \"value\" }\n"
        // Try to add a nested object when disable_objects is true
            .startObject("metrics")  
            .field("source", "doc['test'].value")
            .toString();
            {
            .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), true)
                        "store": true  
                        "properties": {
 *  
            .endObject()
        assertTrue(mapper instanceof StarTreeMapper);
            .startObject()  
            .startObject(".")  
            .endObject()
        try {  
            .startObject("status")
            .startObject("type")
            .startObject()
                }  
 * Unless required by applicable law or agreed to in writing,
            .field("type", "text")
                        "type": "date_nanos"
            mapperService.merge("_doc", new CompressedXContent(updateMapping), MergeReason.MAPPING_UPDATE);
        createIndex("test").mapperService().documentMapperParser().parse("tweet", new CompressedXContent(mapping));  
            .endObject()
            .endObject()  
            .startObject("type")  
            .endObject()
            {
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> {
            .field("type", "text")
                            + "        {\n"
        String bothDisabledMapping = """
            .endObject()  
                    "1",
                    "wildcard_field": {
            .startObject("properties")  
 * GitHub history for details.
            .startObject("metrics")
                        "type": "long",  
/*  
            Settings.builder().put("index.derived_source.enabled", true).build()
            {  
        assertNull(derivedFieldMapper.getScript());
            .endObject()
    public void testDeriveSourceMapperValidation() throws IOException {
                        "type": "keyword",
        DocumentMapperParser nestedMapperParser = createIndex(
                    "test",
import org.opensearch.core.xcontent.MediaTypeRegistry;
            .startObject("object")  
                        "ignore_above": 256
            .field("type", "object")
        String mappingWithNestedObject = XContentFactory.jsonBuilder()
        DocumentMapper mapper = mapperService.merge(
            .startObject("properties")
                    },  
                    ),
            .field("type", "date")  
        ).mapperService().documentMapperParser();
            .endObject()  
            }""";  
            .endObject()
            .endObject()
        assertThat(e.getMessage(), containsString("all fields must use flat field notation"));
            .endObject()
        assertEquals("star_tree", starTreeMapper.fieldType().typeName());  
            .startObject("properties")  
        // Test 6: Validate object field with nested enabled
            .startObject()  
import static org.hamcrest.Matchers.containsString;
            .endObject()
            .endObject()
                }
            .endObject()
            .field("type", "object")
            mapperService.merge("_doc", new CompressedXContent(updateMapping), MergeReason.MAPPING_UPDATE);
            .field("type", "boolean")  
            .field("type", "object")
            .endObject()
            .endObject()
            .startObject("field2")
            .toString();
            defaultMapper.parse(
            .endObject()
            .documentMapperParser()  
            Settings.builder()
            .endObject()
            .endObject()
            .endObject()  
            .toString();
            .startObject("properties")  
                }
            .startObject("properties")
        assertThat(e.getMessage(), containsString("name cannot be empty string"));  
            .startObject("properties")
                            + "      },\n"
            .startObject("raw")
            .endObject()  
import org.opensearch.plugins.Plugin;
        mapper = documentMapper.root().getMapper("@timestamp");
            .endObject()
        MapperService mapperService = createIndex("test").mapperService();  
            .startObject()  
        String update = XContentFactory.jsonBuilder()  
            .field("disable_objects", true)
        assertTrue(mapper instanceof DerivedFieldMapper);
                        "type": "long"
            .endObject()  
                        "type": "keyword"
            .put(StarTreeIndexSettings.STAR_TREE_SEARCH_ENABLED_SETTING.getKey(), false)  
        DocumentMapper defaultMapper = createIndex("test").mapperService()
            .endObject()
            .startObject("tweet")
        objectMapper = mapper.objectMappers().get("object");
        // Should fail because for geo_shape, derived source feature is not implemented for it
            UnsupportedOperationException.class,  
        DocumentMapper mapper = mapperService.merge("type", new CompressedXContent(mapping), reason);
        multiTypeMapperParser.parse("type", new CompressedXContent(multiTypeMapping));
            .startObject("tweet")
            .field("type", "text")  
            .endObject()  
            .startObject("field1")
            .toString();  
            .toString();  
                        "doc_values": true
            mapperService3.merge("_doc", new CompressedXContent(deeplyNestedMapping), MergeReason.MAPPING_UPDATE);
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> {  
 * specific language governing permissions and limitations
            .toString();  
import org.opensearch.cluster.metadata.IndexMetadata;
                                "type": "keyword"  
        DocumentMapper mapper = mapperService.merge("type", new CompressedXContent(mapping), MergeReason.INDEX_TEMPLATE);
            "test_derive_4",
            .endObject()
            () -> docValuesDisabledMapperParser.parse("type", new CompressedXContent(docValuesDisabledMapping))
        assertThat(e.getMessage(), containsString("Field mapping conflict: Cannot add nested object field [metrics.cpu]"));
 * ownership. Elasticsearch licenses this file to you under  
                    }  
                .put("index.derived_source.enabled", true)  
            .startObject()
                }  
                    "geo_point_field": {
                        }
                    },
            }""";
        String expected = XContentFactory.jsonBuilder()
            .startObject("cpu")
            Settings.builder().put("index.derived_source.enabled", true).build()
        // Should succeed with derive source enabled and doc values enabled (default)
            .startObject("properties")
            .parse("_doc", new CompressedXContent(mapping));
            .startObject("field2")  
        DocumentMapperParser copyToMapperParser = createIndex(
            .field("enabled", false)
                    "keyword_field": {
            .endObject()  
            .startObject()
            .startObject("properties")  
            .endObject()  
            .endObject()  
            .endObject()
            createIndex("test").mapperService().documentMapperParser().parse("", new CompressedXContent(mapping));
        expectThrows(  
            .endArray()  
            .endObject()
            () -> mapperService.merge(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(secondUpdate), MergeReason.INDEX_TEMPLATE)
            .endObject()  
            fail("Expected MapperParsingException");
                        "type": "keyword"
            .endObject()  
                        "type": "boolean"
import org.opensearch.index.mapper.MapperService.MergeReason;
            .startObject("number_field")  // Another FieldMapper - should be allowed
        DocumentMapperParser basicMapperParser = createIndex(
            .endObject()
        );  
                "properties": {
            }""";  
    }  
        mapperService.merge("_doc", new CompressedXContent(initialMapping), MergeReason.MAPPING_UPDATE);  
import org.opensearch.index.compositeindex.datacube.startree.StarTreeIndexSettings;
    }
            .startObject("derived_field_name1")
            .startObject("field2")  
            .field("dynamic", false)
            .startObject("field2")
                        "type": "long"
            "test_derive_3",
        assertTrue(isParent(documentMapper.objectMappers().get("a"), documentMapper.objectMappers().get("a.b2"), mapperService));  
            .endObject()
            .field("type", "integer")
                    "text_field": {
            .endObject()
            .endObject()  
        assertEquals(Script.parse("doc['test'].value"), derivedFieldMapper.getScript());
                    "ip_field": {  
import java.util.Collection;
            .startObject("object")
            .startObject("metric_field")
            }""";
            .endObject()
                }
        String mapping = XContentFactory.jsonBuilder()  
            .field("type", "object")  
            .startObject("keyword_field")  // Another FieldMapper - should be allowed
        // Should fail because normalizer is not supported with derive source
            }""";
        String updateMapping = XContentFactory.jsonBuilder()
            .field("name", "metric_field")
    }
            .field("type", "text")
                    }
                            }
        } catch (MapperParsingException e) {
 * not use this file except in compliance with the License.
            .startObject()  
    public void testNestedIsParent() throws Exception {
        // Should fail because doc values and stored are both disabled
                    },
        assertEquals("boolean", derivedFieldMapper.getType());
                        "type": "keyword",  
        // Test that nested objects are rejected during initial mapping creation when disable_objects is true  
        // Test 3: Validate mapping with stored enabled but doc values disabled
        String copyToMapping = """  
            .endObject()
                    "constant_keyword": {  
                    "numeric_field": {
            }""";
        String normalizerMapping = """
                        "type": "nested",  
            .startArray("fields")
            () -> mapperService.merge(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(firstUpdate), MergeReason.INDEX_TEMPLATE)
            .startObject("field_name")
        assertTrue(mapper instanceof DerivedFieldMapper);
            Settings.builder().put("index.derived_source.enabled", true).build()
            .startObject("properties")
            .startObject("properties")  
            .startObject()
            .field("type", "object")
                    },
            .toString();
 * under the License.  
        );
        // Empty name not allowed in index created after 5.0
            .endObject()
            }""";
 * Licensed to Elasticsearch under one or more contributor  
            .endObject()
            .startObject("object")  
            .startObject("name")
            .field("type", "text")  
    }
        assertFalse(isParent(documentMapper.objectMappers().get("a.b2"), documentMapper.objectMappers().get("a"), mapperService));
        assertThat(e.getMessage(), containsString("for object mapping [metrics]"));  
        // Should fail because nested fields are not supported with derive source
            .field("b1", Collections.singletonMap("type", "keyword"))
                    }  
import org.opensearch.test.InternalSettingsPlugin;  
            .endObject()
            .toString();
import org.mockito.Mockito;
        DocumentMapperParser bothDisabledMapperParser = createIndex(
                    },  
            .endObject()
import org.opensearch.common.compress.CompressedXContent;
            Settings.builder().put("index.derived_source.enabled", true).build()
            .field("type", "keyword")
            .endObject()  
            .endObject()
        }
    public void testFieldsWithFilledArrayShouldThrowException() throws Exception {
import java.util.Collections;
        assertNull(mapper.root().dynamic());
                            "inner_field": {
        // Test 9: Validate with both doc_values and stored disabled
        String initialMapping = XContentFactory.jsonBuilder()  
            .endArray()
 * license agreements. See the NOTICE file distributed with
        );
                            + "        }\n"  
            .startObject()
                "properties": {
                        "type": "keyword"
            .startObject("properties")
            assertThat(e.getMessage(), containsString("Expected map for property [fields]"));
            .startObject("properties")
            .field("name", "status")
        });
            .startObject("properties")
            .documentMapperParser()
            .endObject()
            {  
            .endObject()  
            .startObject("tweet")  
            {
        MapperParsingException e2 = expectThrows(MapperParsingException.class, () -> {
                    }
        MapperService mapperService = createIndex("test").mapperService();  
        assertFalse(isParent(documentMapper.objectMappers().get("a.b2.c"), documentMapper.objectMappers().get("a.b2"), mapperService));
            .documentMapperParser()  
                "properties": {
        assertThat(e.getMessage(), containsString("all fields must use flat field notation"));
            .endObject()  
package org.opensearch.index.mapper;
        assertTrue(objectMapper.isEnabled());
            UnsupportedOperationException.class,
            .startObject("cpu")
 * Modifications Copyright OpenSearch Contributors. See
        StarTreeMapper starTreeMapper = (StarTreeMapper) mapper;
            .startObject("properties")
            "test_derive_7",  
            .field("type", "keyword")  
        // Check that field in properties was parsed correctly as well
            .endObject()  
        DocumentMapper documentMapper = createIndex("test", settings).mapperService()
                            + "      \"object\": {\n"
            .startObject("foo")
            .endObject()
                    "field2": {
                            + "      \"value\":\"value\"\n"  
 * compatible open source license.
            IllegalArgumentException.class,  
            .endObject()  
import org.opensearch.core.common.unit.ByteSizeUnit;  
        } catch (MapperParsingException e) {  
            .startObject()  
            .startArray("properties")
            .startObject()
        // This should NOT throw an exception because the child mappers are FieldMappers, not ObjectMappers
        // Test 1: Validate basic derive source mapping  
            .startObject("properties")
            .endObject()
                            + "        ]\n"
        ).mapperService().documentMapperParser();  
                        "type": "geo_shape",
            .toString();  
                    "geo_shape_field": {  
        createIndex("test").mapperService().documentMapperParser().parse("type", new CompressedXContent(mapping));
                        "normalizer": "lowercase"  
            .startObject()
        expectThrows(UnsupportedOperationException.class, () -> copyToMapperParser.parse("type", new CompressedXContent(copyToMapping)));  
                        "copy_to": "field2"
    }
                .putList("analysis.normalizer.lowercase.filter", "lowercase")
        MapperException e = expectThrows(MapperException.class, () -> {
            .startObject("date_dimension")  
            .startObject("properties")
            .startObject()
                    "keyword_field": {
/*
            .endObject()  
            .endObject()
            .toString();
        String firstUpdate = XContentFactory.jsonBuilder()
            .toString();
 * this file be licensed under the Apache-2.0 license or a
        expectThrows(
            .field("type", "nested")
        });  
            .field("disable_objects", true)  
            .startObject("object")
        ).mapperService().documentMapperParser();
            .endObject()
            .field("disable_objects", true)  // disable_objects at level2
            .startObject("properties")
        mapper = mapperService.merge("type", new CompressedXContent(update), MergeReason.INDEX_TEMPLATE);  
            .endObject()  
            .endObject()
        assertTrue(isParent(documentMapper.objectMappers().get("a"), documentMapper.objectMappers().get("a.b2.c"), mapperService));
    public void testValidateNestedObjectRejection() throws Exception {
            .endObject()
            .startObject("object")
            .startObject("type")
        Mapper mapper = documentMapper.root().getMapper("startree");  
        MapperService mapperService = createIndex("test").mapperService();
            .endObject()  
                    }  
                            + "    }"
        // Should fail because copy_to is not supported with derive source
                            + "          \"object\":\"value\"\n"
    }
        expectThrows(
        String mapping = XContentFactory.jsonBuilder()
        storedEnabledMapperParser.parse("type", new CompressedXContent(storedEnabledMapping));
                    "keyword_field": {
            {
    }
    }
    public void testEmptyArrayProperties() throws Exception {
        Mockito.when(mapperService.getObjectMapper(("a"))).thenReturn(documentMapper.objectMappers().get("a"));
    public void testFieldPropertiesArray() throws Exception {  
            .startObject("field2")
                "properties": {
            .field("type", "text")  
        assertThat(e.getMessage(), containsString("can't merge a non object mapping [object.field2] with an object mapping"));  
        Settings settings = Settings.builder()
            .endObject()  
            .startObject("properties")
            .startObject("metrics")  
            .endObject()  
        String mapping = XContentFactory.jsonBuilder()
            .startArray("fields")
    public void testValidateFlatFieldCompatibility() throws Exception {
                        "type": "text",
        );
            .endObject()  
            .endObject()
            .endObject()
        String mapping = XContentFactory.jsonBuilder()
            .endObject()
                .build()  
            .field("type", "object")
import org.opensearch.core.common.bytes.BytesArray;
            .startObject("name")
            .endObject()  
            .endObject()
            .startObject("properties")
            .toString();  
 *
            assertThat(e.getMessage(), containsString("expected map for property [fields]"));  
            .endObject()  
            .endObject()
            () -> ignoreAboveMapperParser.parse("type", new CompressedXContent(ignoreAboveMapping))
            .field("type", "keyword")  
 */  
            .endArray()  
            .field("type", "double")  
        assertThat(e.getMessage(), containsString("Field mapping conflict: Cannot add nested object field [metrics.cpu]"));  
 *
            new CompressedXContent(update),  
        // Check that field in properties was parsed correctly as well
                    },  
            .endObject()
            .startArray("fields")  
            .startObject("level3_object")  // This should be rejected  
        createIndex("test").mapperService().documentMapperParser().parse("tweet", new CompressedXContent(mapping));
        String unsupportedFieldType = """  
        expectThrows(  
import org.opensearch.core.common.unit.ByteSizeValue;
                        "doc_values": false,
            .field("dynamic", "strict")  
            .endObject()  
        ).mapperService().documentMapperParser();
            .field("type", "star_tree")
            .endObject()
            .endObject()
            .endObject()  
        // Test 8: Validate multiple field types
            .endObject()
                }
    public void testDifferentInnerObjectTokenFailure() throws Exception {
            () -> bothDisabledMapperParser.parse("type", new CompressedXContent(bothDisabledMapping))
        ).mapperService().documentMapperParser();
            .field("type", "integer")  
                        "store": true  
        DocumentMapperParser storedEnabledMapperParser = createIndex(  
            .field("type", "object")  
            "test_derive_6",  
            .field("test2", "string")
            .startObject("usage")
            .startObject("field1")  
            UnsupportedOperationException.class,
            .endObject()
                        "type": "long",
        mapperService2.merge("_doc", new CompressedXContent(mappingWithFieldMappers), MergeReason.MAPPING_UPDATE);
        String mapping = XContentFactory.jsonBuilder().startObject().startObject("type").endObject().endObject().toString();
            fail("Expected MapperParsingException");
            .field("type", "long")  
                    },
                "properties": {  
            .startObject()  
            {
            .endObject()  
            {
        });  
        String mapping = XContentFactory.jsonBuilder()
            .startObject("properties")
                        "doc_values": true
    }
            .startObject("level1")
        String deeplyNestedMapping = XContentFactory.jsonBuilder()
            .endArray()  
                "properties": {
            }""";
        assertEquals(Dynamic.STRICT, mapper.root().dynamic());
            .startObject("properties")
}
        String mapping = XContentFactory.jsonBuilder()  
        // Test that nested objects cannot be added when disable_objects is enabled
import org.opensearch.common.settings.Settings;  
            .endArray()
            .field("type", "object")  
        MapperService mapperService2 = createIndex("test2").mapperService();
            .endObject()
            .endObject()
            .startObject("allowed_container")
            .endObject()
            .endObject()
            .startObject("object")  
            IllegalArgumentException.class,
                }
                    },  
            .endObject()
        mapperService.merge("_doc", new CompressedXContent(initialMapping), MergeReason.MAPPING_UPDATE);
    protected Collection<Class<? extends Plugin>> getPlugins() {
            .endObject()
            assertThat(e.getMessage(), containsString("but got a class java.util.ArrayList"));
            .field("type", "object")
            .startObject("derived")
        assertThat(e.getMessage(), containsString("Cannot update parameter [disable_objects] from [true] to [false]"));
            .endObject()
        IllegalArgumentException e = expectThrows(
            .startObject("c")  
        String nestedMapping = """
            .documentMapperParser()
    public void testValidateDisableObjectsImmutability() throws Exception {  
        String mappingWithFieldMappers = XContentFactory.jsonBuilder()
        assertThat(e.getMessage(), containsString("can't merge a non object mapping [object.field1] with an object mapping"));
            .startObject()
        DocumentMapper documentMapper = createIndex("test").mapperService()  
            .startObject("properties")
            .startObject("script")
            .toString();  
            .toString();  
import org.opensearch.index.IndexSettings;  
            .endObject()
            .startObject(MapperService.SINGLE_MAPPING_NAME)  
                    "numeric_field": {  
                new SourceToParse(  
            .endObject()
        // Test the specific validation lines: newMapper.name() and name() interpolation
            .startObject("tweet")  
        DerivedFieldMapper derivedFieldMapper = (DerivedFieldMapper) mapper;  
            .field("test", "string")
            () -> normalizerMapperParser.parse("type", new CompressedXContent(normalizerMapping))
        assertEquals("date", mapper.typeName());
import org.opensearch.test.OpenSearchSingleNodeTestCase;
        assertTrue(isParent(documentMapper.objectMappers().get("a.b2"), documentMapper.objectMappers().get("a.b2.c"), mapperService));
            .toString();  
        // Should succeed because stored is enabled
        expectThrows(  
                            + "        {\n"
                        "type": "constant_keyword",
            .field("type", "text")
            .startObject("properties")
            );
            .startObject("tweet")
            .toString();
            .startObject("composite")
        assertNotNull(objectMapper);  
            .toString();
        ).mapperService().documentMapperParser();
    public void testDerivedFields() throws Exception {  
 * You may obtain a copy of the License at  
        // Test with deeply nested structure to ensure the name interpolation works correctly
            .endObject()
            .startObject("b2")  
        DocumentMapperParser ignoreAboveMapperParser = createIndex(
            .endObject()
            .field("d", Collections.singletonMap("type", "keyword"))  
            Settings.builder().put("index.derived_source.enabled", true).build()  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertEquals(expected, mapper.mappingSource().toString());
        assertThat(e2.getMessage(), containsString("when disable_objects is enabled for [level2]"));  
            .startObject("properties")
        String mapping = XContentFactory.jsonBuilder()
        try {
            .endObject()  
        MergeReason reason = randomFrom(MergeReason.values());  
            .parse("type", new CompressedXContent(mapping));  
        assertFalse(isParent(documentMapper.objectMappers().get("a.b2.c"), documentMapper.objectMappers().get("a"), mapperService));  
        assertTrue(e.getMessage(), e.getMessage().contains("cannot be changed from type"));
            .endObject()
            .field("test", "string")  
            .startObject()
        final DocumentMapperParser docValuesDisabledMapperParser = createIndex(  
            .endObject()  
            .endObject()  
        ObjectMapper objectMapper = mapper.objectMappers().get("object");  
            .endObject()  
        String mapping = XContentFactory.jsonBuilder()
        ).mapperService().documentMapperParser();
            .endObject()
            .startObject("tweet")  
                "properties": {
            .field("type", "object")
        derivedFieldMapper = (DerivedFieldMapper) mapper;  
            Settings.builder().put("index.derived_source.enabled", true).build()
            .endObject()
    }  
            .toString();  
        assertThat(e.getMessage(), containsString("The disable_objects setting is immutable after index creation"));
            MapperService.SINGLE_MAPPING_NAME,
            .startObject("field3")
            .startObject("properties")  
            .endObject()
            .startObject()
            .startObject("metrics")
            .field("type", "nested")
            .startObject()
        // Try to change disable_objects from true to false
            .endObject()
                    new BytesArray(  
            .endObject()
    public void testDisallowFieldReplacementForIndexTemplates() throws IOException {
            .field("disable_objects", false)
            .startObject()
                        " {\n"
    public void testMergeEnabledForIndexTemplates() throws IOException {
            .startObject("properties")
import org.opensearch.common.xcontent.XContentFactory;
public class ObjectMapperTests extends OpenSearchSingleNodeTestCase {  
 * KIND, either express or implied.  See the License for the
        ).mapperService().documentMapperParser();
        Mockito.when(mapperService.getObjectMapper(("a.b2.c"))).thenReturn(documentMapper.objectMappers().get("a.b2.c"));  
            .put(StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING.getKey(), true)
                    "date_nanos_field": {  
        MapperService mapperService = Mockito.mock(MapperService.class);  
    public void testFieldsArrayMultiFieldsShouldThrowException() throws Exception {  
            .toString();
    public void testDotAsFieldName() throws Exception {
            "test_derive_9",  
    }
    @Override  
        assertThat(e2.getMessage(), containsString("Cannot add nested object field [level1.level2.level3_object]"));
            .startObject("properties")
            .startArray("fields")
        mapper = mapperService.merge("type", new CompressedXContent(update), MergeReason.INDEX_TEMPLATE);
            .endObject()
            .startObject("object")  
            .endObject()
        // Test that disable_objects cannot be changed after index creation
            .startObject()
 * this work for additional information regarding copyright
            .endObject()  
                        "doc_values": false
            .startObject("name")  
            .endObject()  
        // This should go through without issue
            .startObject()
            .startObject("properties")
/*  
            .field("type", "object")  
            .field("type", "object")  
            .endObject()
        String basicMapping = """
                    },
            .endObject()
                    "field1": {  
            .endObject()
            .endObject()
    }  
            .endObject()
            .startObject("properties")  
        try {
        }
        createIndex("test").mapperService().documentMapperParser().parse("tweet", new CompressedXContent(mapping));
                    "nested_field": {
        update = XContentFactory.jsonBuilder()
            .startObject("properties")
            .endObject()  
            .endArray()
            .field("name", "status")
        DocumentMapperParser multiTypeMapperParser = createIndex(
            .startObject("config")
            .startObject()  
        String mapping = XContentFactory.jsonBuilder()  
        // If we don't explicitly set 'enabled', then the mapping should not change.
 * The OpenSearch Contributors require contributions made to  
                )
import static org.opensearch.index.mapper.ObjectMapper.Nested.isParent;  
        MapperService mapperService = createIndex("test").mapperService();
        String updateMapping = XContentFactory.jsonBuilder()  
