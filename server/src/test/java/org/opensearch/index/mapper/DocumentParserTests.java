        assertThat(bazMapper, instanceOf(NumberFieldMapper.class));
    public void testNoDocumentSent() throws Exception {
    }
            b.endArray();
        Mapper inner1_field1_mapper = ((ObjectMapper) objMapper).getMapper("inner1_field1");
        assertEquals(6, doc.rootDoc().getFields("nested_arrays").length);
                }
                b.endObject();
        assertEquals(3, doc1.rootDoc().getFields("tags").length);
                        b.field("match", "test");
                    {
        List<Mapper> updates = Collections.singletonList(new MockFieldMapper("foo"));
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {}));
                b.endObject();
        ParsedDocument doc = mapper.parse(source(b -> b.startObject("foo.bar.baz").field("a", 0).endObject()));
    }
            }
    }
        // Test complex nested objects within arrays in disable_objects mode
                    b.endObject();
                Mapper appMapper = logAttrsObj.getMapper("app");
        assertEquals(2, doc.rootDoc().getFields("foo.bar.baz.a").length);
                b.field("type", "alias");
            }
        ParsedDocument doc1 = rootMapper.parse(source(b -> { b.field("metrics.cpu.usage", 55.5); }));
        DocumentMapper defaultMapper = createDocumentMapper(mapping(b -> {}));
                    b.field("type", "object");
        }
                    b.nullField("age"); // This should trigger the exception for null value
        }));
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> mapper.parse(source(b -> b.field("_field_names", 0))));
        assertNull(((ObjectMapper) xMapper).getMapper("subx"));
                {
            {
        DocumentMapper rootMapper = createDocumentMapper(topMapping(b -> {
        }));
                }
                b.endObject();
            "mapping set to strict_allow_templates, dynamic introduction of [bar] within [_doc] is not allowed",
                }
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
                b.startObject();
            b.endArray();
        assertEquals(0, doc.rootDoc().getFields("bool_field").length);
        assertNotNull("Field 'outer.literal.field.name' should exist", doc3.rootDoc().getField("outer.literal.field.name"));
            b.startArray("dynamic_templates");
        );
                        b.field("match", "embedded_*");
            b.endObject();
                    b.endObject();
                        b.startObject("mapping").field("type", "date").endObject();
                    b.field("type", "text");
        assertNotNull(aMapper);
        ParsedDocument doc = mapper.parse(source(b -> b.field("numeric_field", "123")));
                {
                        b.field("path_match", "foo.bar.baz");
        ParsedDocument doc5 = mapper.parse(source(b -> { b.field("a.b.c", "exactmatch"); }));
        assertEquals(
        DocumentMapper docMapper = createDummyMapping();
            b.startArray("dynamic_templates");
        // This should create a field with the flattened name
        assertNotNull(doc.rootDoc().getField("point"));
 * SPDX-License-Identifier: Apache-2.0
        assertNotNull(
            b.startObject("properties");
            b.endObject();
        assertEquals("address should be text", "text", mapperService.fieldType("address").typeName());
                                {
            {
                }
            b.endObject();
                    }
                            b.field("type", "object");
            {
                }
            () -> mapper.parse(source(b -> b.nullField("bar")))
                    {
        // the flat-field contract and potentially causing recursive field name expansion.
                        b.startObject("mapping").field("type", "object").endObject();
                        b.startObject("mapping").field("type", "long").endObject();
        // After flattening, field name becomes "metrics.cpu.cores" and the value is an array.
        ParsedDocument doc1 = mapper.parse(source(b -> { b.field("root.level.dotted.field", "root_flattened"); }));
        assertNotNull("doc1 should produce dynamic mapping update", doc1.dynamicMappingsUpdate());
            b.endArray();
                b.field("literal.field.name", "literalvalue");
        ParsedDocument doc2 = mapper.parse(source(b -> { b.field("a.b.c.d.e.f.g.h.i.j", "long_path"); }));
        assertNotNull("Mapper for 'metrics.cpu' should exist", cpuMapper);
            b.field("dynamic", "true");
                    {
                b.endObject();
                b.endObject();
                    {
        assertEquals(0, docWithTemplate.rootDoc().getFields("bar").length); // null fields don't create mappings
            b.startObject("baz").field("type", "keyword").endObject();
            .endObject()
        assertThat(e.getCause().getMessage(), containsString("field name cannot contain only the character [.]"));
                        b.field("inner3_field2", "inner3_value2");
                        }
                    {
            () -> documentMapper.parse(source(b -> b.startArray("foo").value(0).value(1).endArray()))
                b.startObject("inner").field("inner_field", "inner_value").endObject();
                b.endObject();
            {
        // Test array containing complex nested objects
                b.endObject();
                }
                    b.field("name", "item2");
    public void testDynamicDateDetectionDisabledOnNumbers() throws IOException {
                        {
        assertNotNull("Field 'a.b.c.d.e.f.g' should exist", doc2.rootDoc().getField("a.b.c.d.e.f.g"));
        Mapping mapping = DocumentParser.createDynamicUpdate(docMapper.mapping(), docMapper, updates);
                        b.startObject();
            }
    }
            }
                        b.field("match_mapping_type", "string");
            b.endArray();
            }
                {
        merge(ms2, dynamicMapping(docB.dynamicMappingsUpdate()));
        String mapping = XContentFactory.jsonBuilder()
                b.startArray();
    }
                b.field("type", "alias");
    }
            b.startObject("location_copy").field("type", "geo_point").endObject();
        ParsedDocument docWithTemplate = mapperWithTemplate.parse(source(b -> b.field("bar", "baz")));
                    {
            }
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "false_allow_templates")));
        assertThat(fooMapper, instanceOf(ObjectMapper.class));
        merge(ms2, dynamicMapping(docA.dynamicMappingsUpdate()));
            }
        DocumentMapper mapperWithTemplate = createDocumentMapper(topMapping(b -> {
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
        assertNotNull(result.docs().get(0).getField(IdFieldMapper.NAME));
            b.endObject();
                {
        assertNotNull("Field 'a.b.c.single' should exist", doc3.rootDoc().getField("a.b.c.single"));
        assertThat(barMapper, instanceOf(ObjectMapper.class));
    public void testTypeLevelWithFieldTypeAsValue() throws Exception {
            b.startArray().value(0).value(0).endArray();
                                    b.field("disable_objects", true);
        }));
        ));
        ParsedDocument doc = mapper.parse(source(b -> b.startObject("test").field("test1", "baz").endObject()));
        assertEquals(2, doc.rootDoc().getFields("foo.bar").length);
                b.startArray().value("a1").value("a2").endArray();
            b.field("dynamic", "strict_allow_templates");
                }
            "mapping set to strict_allow_templates, dynamic introduction of [foo] within [_doc] is not allowed",
            }
                        }
        // Verify the actual values
        err = expectThrows(
            {
            );
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
    }
    public void testTypeLevelWithFieldTypeAsObject() throws Exception {
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {}));
        // Verify all nested fields are flattened correctly
        ParsedDocument docWithTemplate = mapperWithTemplate.parse(source(b -> b.field("numeric_field", "123")));
                }
        }));
        // Same regression test but at root level with disable_objects=true
            }
/*
                // There should be NO "app" ObjectMapper child
        // Dynamically add "address.city"
        assertNotNull(bazMapper);
        // Test at nested ObjectMapper level (like the TextBench LogAttributes case)
        Mapper dateMapper = update.root().getMapper("foo");
    public void testNoLevelWithFieldTypeAsValue() throws Exception {
        Mapping update = doc.dynamicMappingsUpdate();
                b.startObject();
        assertNotNull(doc.dynamicMappingsUpdate());
            assertNull(doc.rootDoc().getField("field.bar"));
    public void testTypeLevel() throws Exception {
        // Verify that the geo_point field itself exists
        assertTrue(copiedFields.length > 0);
                    }
                {
            b.endArray();
    public void testDynamicStrictAllowTemplatesValue() throws Exception {
            }
            b.startArray("mixed_array");
        assertEquals("Cannot write to a field alias [alias-field].", exception.getCause().getMessage());
            b.endArray();
        assertNotNull(xMapper);
        }));
    }
                                    b.field("type", "object");
            b.endArray();
                b.endObject();
        );
                        b.field("copy_to", "nested.target_field");
                b.field("copy_to", "alias-field");
                    b.startObject("test2");
        DocumentMapper mapper = createDocumentMapper(pluggableSettings, mapping(b -> {}));
                b.startObject();
            }
    }
        // Verify that the geo_point field itself exists
                        b.field("disable_objects", objectDisableObjects);
        Mapper textMapper = doc.dynamicMappingsUpdate().root().getMapper("dynamic_text");
            b.endArray();
        assertEquals("Product 2", nameFields[1].stringValue());
        assertNotNull(textMapper);
                        b.startObject("mapping").field("type", "object").endObject();
        assertThat(keywordSubField, instanceOf(KeywordFieldMapper.class));
                b.endObject();
                    b.startObject("test");
            b.endObject();
                {
        assertNotNull(((ObjectMapper) xMapper).getMapper("bar"));
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
    public void testDynamicGeoPointArrayWithTemplate() throws Exception {
            b.startObject("x");
        ParsedDocument doc1 = mapperService.documentMapper().parse(source("""
        merge(mapperService, dynamicMapping(doc2.dynamicMappingsUpdate()));
                        b.startObject("mapping").field("type", "object").endObject();
    public void testRootLevelGetMapperFlattening() throws Exception {
            b.endArray();
            {
        ParsedDocument doc2 = mapper.parse(source(b -> {
        })));
    public void testFieldDisabled() throws Exception {
                b.field("cpu.usage", 75.5);
    // TODO do we still need all this tests for 'type' at the bottom level now that
                    b.field("type", "text");
                b.endObject();
            b.field("dynamic", "false_allow_templates");
            {
        assertNotNull(doc2);
                        b.field("match", "nested");
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
                }
            {
            {
            b.startArray("dynamic_templates");
        assertEquals("value1", doc2.rootDoc().getField("a.b.c.d.e.f").stringValue());
            if (objectPath != null) {
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {}));
            b.startObject("name");
        assertThat(doc.rootDoc().get("type.type.type_field"), equalTo("type_value"));
            {
                {
            b.endObject();
                }
                    b.startObject("properties").endObject();
        assertEquals(
        // After flattening, field name becomes "app.payment" and the value is an array.
        assertEquals(
                    {
        // check parsing success for nested array within allowed depth limit
                    }
                .endObject();
        assertThat(doc.rootDoc().get("type.inner.inner_field"), equalTo("inner_value"));
                }
        ParsedDocument doc = mapper.parse(source(b -> b.field("bool_field", true)));
        assertEquals("test1", doc1.rootDoc().getField("level1.level2.level3.simple.field").stringValue());
            exception.getMessage()
            b.endArray();
    }
        assertNotNull(barMapper);
                b.startObject();
        ParsedDocument doc2 = mapper.parse(source(b -> { b.field("a.b.c.d.e.f", "value1"); }));
            }
        }));
        assertNotNull("Field 'product.name' should exist", doc.rootDoc().getField("product.name"));
        Settings pluggableSettings = Settings.builder()
                }
            b.startArray("dynamic_date_formats").value("yyyy-MM-dd").endArray();
        assertEquals(2, doc.rootDoc().getFields("products.id").length);
            }
                b.endObject();
                        b.field("match", "foo");
        assertNotNull(doc);
                    }
        );
        ));
        assertNotNull(fooMapper);
                b.endObject();
                {
                {
            if (rootDisableObjects) {
            {
                    {
                b.endObject();
        Mapper fooMapper = doc.dynamicMappingsUpdate().root().getMapper("foo");
        assertEquals(0, doc.rootDoc().getFields("foo.bar").length);
            b.startObject("concrete-field").field("type", "keyword").endObject();
                ((FieldMapper) m).fieldType().isSearchable()
        assertNotNull(
                b.field("test1", "value1");
    }
                    b.endObject();
                b.startObject("outer");
        assertThat(doc.rootDoc().get("type"), equalTo("value_type"));
                b.endArray();
                Mapper appPaymentMapper = logAttrsObj.getMapper("app.payment");
            b.startObject("point");
                        b.field("index", false);
            b.endArray();
            }
            b.field("disable_objects", true);
    public void testDynamicFalseAllowTemplatesWithDateDetection() throws Exception {
                b.field("field.bar", "string value");
            "mapping set to strict_allow_templates, dynamic introduction of [foo] within [_doc] is not allowed",
                }
            {
                b.nullValue();
                b.startObject();
        // The bug would cause "app" to become an ObjectMapper without disable_objects.
                }
        ParsedDocument doc = mapper.parse(source(b -> b.startArray("foo").value(0).value(1).endArray()));
                        b.endObject();
            for (int i = 1; i < depth_limit; i++) {
            b.field("type", "value_type");
        assertEquals("300", doc.docs().getFirst().getGroupingCriteria());
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
            {
        assertThat(exception.getMessage(), containsString("user.age"));
            {
        ParsedDocument doc = mapper.parse(source(b -> {
                b.startObject();
    public void testDynamicallyMappedFieldsAreNotIndexedForPluggableDataFormat() throws Exception {
        ParsedDocument doc = mapper.parse(source(b -> b.startArray("field").value(0).value(1).endArray()));
                        b.startObject("mapping").field("type", "keyword").endObject();
                        {
                {
        assertThat(doc.get(docMapper.mappers().getMapper("name.first").name()), equalTo("fred"));
    public void testDynamicFieldsStartingAndEndingWithDot() throws Exception {
                    b.endObject();
        assertThat(doc.getBinaryValue(builtDocMapper.idFieldMapper().name()), equalTo(Uid.encodeId("1")));
    public void testDotsWithExistingNestedMapper() throws Exception {
            }
        // This should create a single flat field
                {
                            {
    public void testDynamicDottedFieldNameObjectWithParentTemplate() throws Exception {
            b.field("disable_objects", true);
            {
                        b -> b.field(MockMetadataMapperPlugin.MockMetadataMapper.CONTENT_TYPE)
            b.field("dynamic", false);
            source(b -> b.field("dyn_long", 42).field("dyn_double", 1.5).field("dyn_date", "2024-01-01").field("dyn_bool", true)),
                        b.field("match_mapping_type", "string");
            b.field("dynamic", "true");
                b.field("age", 30);
        );
                    b.startObject("target_template");
        }));
                                b.startObject("aoeu").field("a", 1).field("b", 2).endObject();
            b.endArray();
                    }
    public void testExistingMapperLookupWithDisableObjectsParent() throws Exception {
        assertThat(doc.rootDoc().get("type.test1"), equalTo("value1"));
        DocumentMapper docMapper = createDummyMapping();
                {
    }
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "false")));
                        b.endObject();
            b.startArray("foo");
import org.opensearch.core.common.bytes.BytesReference;
        assertThat(
        String mapping = copyToStringFromClasspath("/org/opensearch/index/mapper/simple/test-mapping.json");
        assertThat(barMapper, instanceOf(ObjectMapper.class));
                            b.startObject("baz").field("type", "integer").endObject();
                    b.value(3);
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {
        assertNotNull(doc.rootDoc().getField("obj.inner"));
        }));
        assertNotNull("docB should produce dynamic mapping update", docB.dynamicMappingsUpdate());
        ParsedDocument doc = defaultMapper.parse(source(b -> {
                    {
        ParsedDocument doc = mapper.parse(source(b -> { b.startObject("point").field("lat", 40.71).field("lon", 74.00).endObject(); }));
        ParsedDocument doc = mapper.parse(source(b -> b.field("dynamic_text", "hello world")), noopInput);
                        {
            b.field("baz", "value2");
        }));
            b.startArray().value(0).value(0).endArray();
                    b.endObject();
            }
        // Test that existing field mappers work correctly with disable_objects
    public void testParseDocumentWithDocumentInputAndDynamicMapping() throws Exception {
    public void testParseNonDynamicArrayWithNullValuesDisableObjects() throws Exception {
            {
        IndexableField[] coreFields = doc.rootDoc().getFields("metrics.cpu.cores");
        assertEquals(0, doc.rootDoc().getFields("foo.bar.baz").length);
            b.field("dynamic", "false_allow_templates");
        ParsedDocument doc = mapper.parse(
                b.field("test2", "value2");
    }
        // Comprehensive test for basic disable_objects functionality
    }
        {
                        b.startObject("mapping").field("type", "keyword").endObject();
                b.field("bar.baz", 456);
                b.field("type", "geo_point");
            b.field("dynamic", "false_allow_templates");
                    b.field("id", "prod2");
                    }
        MapperParsingException exception = expectThrows(
        assertNotNull("Field 'user.name' should exist", doc.rootDoc().getField("user.name"));
            b.field("dynamic", "true");
                }
    public void testDisableObjectsArrayWithDottedFieldNameNoIntermediateObjectMapper() throws Exception {
                        b.startObject("mapping").field("type", "long").endObject();
            StrictDynamicMappingException.class,
                    }
        Mapper dateMapper = update.root().getMapper("foo");
            {"address.city": "Austin"}
                                b.startObject("c");
                {
        DocumentMapper defaultMapper = createDocumentMapper(topMapping(b -> {
                        b.startObject("mapping").field("type", "long").endObject();
                    b.field("disable_objects", true);
                    }
                        b.field("match_mapping_type", "object");
                        }
            {
            {"attributes": {"address": "US"}}
        Settings pluggableSettings = Settings.builder()
    }
        BigInteger bigInt = BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.ONE);
            e.getMessage(),
            {
            () -> documentMapper.parse(source(b -> b.startObject("foo.bar.baz").field("a", 0).endObject()))
        assertEquals(2, doc.rootDoc().getFields("products.details.name").length);
                    {
            b.startObject("properties");
import java.io.IOException;
                        b.field("lon", -74.0060);
                b.endObject();
            b.field("disable_objects", true);
    public void testDynamicFalseDottedFieldNameObject() throws Exception {
        ParsedDocument doc = mapper.parse(source(b -> b.field("big-decimal", value)));
                    b.endObject();
 */
            {
                {
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
        ParsedDocument docWithTemplate = mapperWithTemplate.parse(source(b -> b.startObject("foo.bar.baz").field("a", 0).endObject()));
    }
                            b.startObject("properties");
    }
                {
        MapperService mapperService = createMapperService();
                    {
        }));
            contextAwareGrouping("status_code").accept(b);
                }
        Mapping update = doc.dynamicMappingsUpdate();
                b.endObject();
                    {
    public void testDynamicFalseDottedFieldNameLongArray() throws Exception {
        assertNotNull(((ObjectMapper) xMapper).getMapper("foo"));
                    b.endArray();
        assertEquals("value", doc1.rootDoc().getField("outer.inner.test").stringValue());
                    {
        }));
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
                b.startObject("a");
                b.endObject();
        }));
        DocumentMapper dynamicMapper = createDocumentMapper(topMapping(b -> {
                }
        ParsedDocument doc = mapper.parse(source(b -> b.startObject("field.bar.baz").field("a", 0).endObject()));
            b.startObject("fields")
    public void testDynamicBigDecimal() throws Exception {
                    b.endObject();
                        b.startObject("mapping").field("type", "object").endObject();
            .put("index.version.created", Version.CURRENT)
                    b.endObject();
        );
        ParsedDocument doc1 = mapperService.documentMapper().parse(source("""
        assertNotNull(copy1Fields);
                    b.startObject("properties");
        }
            // The update should contain a FieldMapper for "app.payment" under LogAttributes,
                {
        assertNotNull("Field 'user.age' should exist", doc.rootDoc().getField("user.age"));
            b.startObject("a");
            b.endArray();
                b.startObject();
    }
        assertNotNull(bazMapper);
    public void testEmptyMappingUpdate() throws Exception {
    }
    }
    }
            "text",
        assertNotNull("Field 'products.details.price' should exist", doc.rootDoc().getField("products.details.price"));
            {
    }
        // All fields should be flattened
        assertNotNull(dateMapper);
            {
        ));
                            b.field("type", "float");
        Mapper barMapper = ((ObjectMapper) fooMapper).getMapper("bar");
                b.endObject();
                    }
            b.startObject("concrete-field").field("type", "keyword").endObject();
        assertNull(DocumentParser.createDynamicUpdate(docMapper.mapping(), docMapper, Collections.emptyList()));
        );
        ParsedDocument doc = mapper.parse(source(b -> b.field("foo.bar.baz", 0)));
        }));
                        b.field("match", "foo");
        ParsedDocument doc = mapper.parse(source(b -> b.field("bar", "baz")));
        return createMapperService().documentMapper();
            {
            b.endObject();
                    {
        assertThat(doc.rootDoc().get("type.type.type_field"), equalTo("type_value"));
package org.opensearch.index.mapper;
        }));
            }
    public void testWriteToFieldAlias() throws Exception {
                        b.startObject("mapping").field("type", "nested").endObject();
        updates.add(new MockFieldMapper("x.subx.b"));
    public void testUnexpectedFieldMappingType() throws Exception {
        assertEquals(8589934592L, flatDoc.rootDoc().getField("metrics.memory.used").numericValue().longValue());
        assertEquals("value1", mixedFields[0].stringValue());
        assertNotNull(doc.rootDoc().getField("point"));
        ParsedDocument doc = mapper.parse(source(b -> { b.array("point", 74.00, 40.71); }));
    }
 */
                assertNull("ObjectMapper 'app' should NOT exist under LogAttributes (dotted name should be kept flat)", appMapper);
            exception.getMessage()
        assertThat(doc.rootDoc().get("type.inner.inner_field"), equalTo("inner_value"));
            b.startObject().startObject("strings").field("match_mapping_type", "string");
import java.math.BigInteger;
            strictMapper.parse(source(b -> {
                }
            .build();
                b.startObject();
 * this file be licensed under the Apache-2.0 license or a
        StrictDynamicMappingException exception = expectThrows(
            {
        assertNotNull(xMapper);
        assertNotNull(mapping.root().getMapper("foo"));
            }
                    b.startObject("test");
            }
        updates.add(createObjectMapper(mapperService, "foo.bar"));
                        }
            .startObject(MapperService.SINGLE_MAPPING_NAME)
                b.endObject();
                {
                {
                    }
                        b.field("match", "bar");
        ParsedDocument doc = mapper.parse(source(b -> b.startArray("foo").value(0).value(1).endArray()));
    // we no longer have types?
        // in this case, we analyze the type object as the actual document, and ignore the other same level fields
            .endObject()
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
            {
    public void testDynamicAllowTemplatesStrictLongArray() throws Exception {
                        b.startObject("mapping").field("type", "long").endObject();
            {
    public void testDynamicDottedFieldNameObjectWithExistingParent() throws Exception {
                    b.startObject("test");
        // parseNonDynamicArray's splitAndValidatePath. Splitting would cause getDynamicParentMapper
        assertThat(doc.rootDoc().get("type.test1"), equalTo("value1"));
        List<Mapper> updates = new ArrayList<>();
        DocumentMapper mapper = createDocumentMapper(mapping(b -> b.startObject("field").field("type", "text").endObject()));
            }
        }));
        // the flattened dotted field name (e.g., "app.payment") must NOT be split by
        ParsedDocument defaultDoc = defaultMapper.parse(source(b -> {
        assertNotNull(copiedFields);
                }
                    b.startObject("boolean_template");
        ParsedDocument doc = mapper.parse(source(b -> {
        Mapping update = doc.dynamicMappingsUpdate();
            b.endObject();
    public void testDynamicRootFallback() throws Exception {
        assertNotNull("doc2 should produce dynamic mapping update", doc2.dynamicMappingsUpdate());
            StrictDynamicMappingException.class,
            }
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "false_allow_templates")));
 * license agreements. See the NOTICE file distributed with
        assertNotNull("doc1 should produce dynamic mapping update", doc1.dynamicMappingsUpdate());
        ParsedDocument doc = mapper.parse(source(b -> {
        assertThat(exception3.getMessage(), containsString("user.age"));
            """));
                b.field("type", "text");
                    b.field("item.id", "item1");
        MapperService mapperService = createMapperService(mapping(b -> {
        for (int i = 0; i < nameParts.length - 1; ++i) {
        }
                        {
            {
        Mapper fooMapper = doc.dynamicMappingsUpdate().root().getMapper("field");
        }));
        assertNotNull(update); // dynamic mapping update
        assertNotNull("doc2 should produce dynamic mapping update", doc2.dynamicMappingsUpdate());
            }
            b.endObject();
        assertEquals("Cannot copy to a field alias [alias-field].", exception.getCause().getMessage());
    }
        DocumentMapper mapper = createDocumentMapper(pluggableSettings, mapping(b -> {}));
    public void testBlankFieldNames() throws Exception {
        assertNotNull(mapping);
        ParsedDocument doc = defaultMapper.parse(source(b -> {
        ParsedDocument doc = mapper.parse(source(b -> {
        assertNotNull(bazMapper);
                        b.startObject("b");
        assertEquals(0, doc.rootDoc().getFields("date_field").length);
                    {
        Mapper barMapper = ((ObjectMapper) fooMapper).getMapper("bar");
        assertThat(e.getCause(), notNullValue());
        assertThat(doc.rootDoc().get("test1"), equalTo("value1"));
                b.endObject();
            null,
                    {
        assertEquals("testvalue", doc2.rootDoc().getField("outer.deep.nested.field").stringValue());
        // In disable_objects mode, array elements should be flattened using the same field name
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
                {
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "strict")));
                b.endObject();
            {
                    b.startObject("objects_as_nested");
            b.endArray();
        assertEquals(2, doc3.rootDoc().getFields("mixed_array.name").length);
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {
                b.endObject();
            Mapper metricsCpuMapper = dynamicUpdate.root().getMapper("metrics.cpu");
        assertThat(doc.rootDoc().get("type.test2"), equalTo("value2"));
        // reparse it
        DocumentMapper mapperWithTemplate = createDocumentMapper(topMapping(b -> {
            }
            exception.getMessage()
            b.startArray("dynamic_templates");
    }
    }
            }
            exception.getMessage()
        assertThat(doc.getDocumentInput(), sameInstance(mockInput));
            {
        Mapping update = doc.dynamicMappingsUpdate();
        IndexableField[] copiedFields = doc.rootDoc().getFields("location_copy");
        }));
    }
                b.endObject();
                        b.startObject("mapping").field("type", "object").endObject();
        // Should be flattened to outer.deep.nested.field
        assertEquals("mastercard", paymentFields[1].stringValue());
                    }
    public void testDynamicFalseAllowTemplatesValue() throws Exception {
        assertThat(doc.rootDoc().get("test1"), equalTo("value1"));
        assertNotNull("Dynamic field 'metrics.cpu.usage' should exist", dynamicDoc.rootDoc().getField("metrics.cpu.usage"));
            }
            b.startArray("dynamic_templates");
        ParsedDocument doc2 = rootMapper.parse(source(b -> { b.field("metrics.cpu", 99.1); }));
                    b.endObject();
        DocumentMapper documentMapperWithDynamicTemplates = createDocumentMapper(topMapping(b -> {
        ParsedDocument doc1 = mapper.parse(source(b -> {
        MapperService mapperService = createMapperService(topMapping(b -> {
                    b.endObject();
                    }
        assertEquals(new BytesRef(value.toString()), fields[0].binaryValue());
                b.field("memory.used", 8589934592L);
            {
                b.field("type", "text");
                "dynamically mapped [" + field + "] should not be indexed on a pluggable data format index",
                .startObject("keyword")
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {}));
            b.field("dynamic", "true");
            }
    public void testDynamicDottedFieldNameLongWithExistingParent() throws Exception {
                    {
        assertThat(doc.rootDoc().get("type.test1"), equalTo("value1"));
            {
            b.startObject("obj");
        Mapping update = doc.dynamicMappingsUpdate();
        ParsedDocument doc = mapper.parse(source(b -> b.field("bar", "baz")));
                        b.field("match", "foo*");
        // Verify that the field was copied to the copy_to target
    public void testDynamicFalseAllowTemplatesWithNumericDetection() throws Exception {
            () -> mapper.parse(source(b -> b.startObject("field.bar.baz").field("a", 0).endObject()))
                        b.field("path_match", "foo.bar.baz");
                    b.startObject("test");
        });
            {
    public void testDynamicFalseAllowTemplatesWithFloatDetection() throws Exception {
        assertNotNull(barMapper);
        // This covers the first StringBuilder flatFieldName code block
            {
                }
                    b.startObject("test1");
            b.endObject();
            b.field("bar", 10);
        ParsedDocument doc = mapper.parse(source(b -> b.startArray("field.bar.baz").value(0).value(1).endArray()));
            "text",
    public void testDocumentContainsDeepNestedFieldParsing() throws Exception {
                }
                    b.startObject("test");
                {
                    }
    }
            b.startObject("properties");
            b.startArray("dynamic_templates");
            {
                    b.startObject("test1");
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
            }
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        // and reconstruction: String.join(".", java.util.Arrays.copyOf(pathParts, i))
            b.field("test2", "value2");
                        b.startObject("mapping");
    public void testMappedGeoPointArray() throws Exception {
        // Test edge case where the path exactly matches the disable_objects parent
            b.startObject("field");
        assertThat(doc.rootDoc().get("test2"), equalTo("value2"));
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> {
        // Test 2: Dynamic fields with disable_objects=true
        assertNotNull(dateMapper);
            "mapping set to strict_allow_templates, dynamic introduction of [foo] within [_doc] is not allowed",
            b.endObject();
        assertEquals("exact_match", doc4.rootDoc().getField("level1.level2.level3").stringValue());
            b.endArray();
                b.endObject();
            {
                }
                b.startObject();
    public void testDynamicTextFieldWithoutKeywordMultiFieldForPluggableDataFormat() throws Exception {
            .put("index.version.created", Version.CURRENT)
                }
        assertThat(textMapper, instanceOf(TextFieldMapper.class));
            b.startObject("source_field");
        StrictDynamicMappingException exception = expectThrows(
                b.field("copy_to", "target_field");
            assertNotNull(doc.rootDoc().getField("blub"));
            b.startArray("dynamic_templates");
        assertEquals(0, doc.rootDoc().getFields("embedded_field").length);
        }));
            b.startObject("attributes").field("type", "object").field("dynamic", true).field("disable_objects", true).endObject();
                    }
        assertThat((String) docMapper.meta().get("param1"), equalTo("value1"));
        assertEquals(IdFieldMapper.Defaults.FIELD_TYPE, result.docs().get(1).getField(IdFieldMapper.NAME).fieldType());
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
            merge(mapperService, dynamicMapping(parsedDoc.dynamicMappingsUpdate()));
                    b.endObject();
            }
            b.startArray("dynamic_templates");
                            }
        DocumentMapper mapperWithTemplate = createDocumentMapper(topMapping(b -> {
                }
    }
        assertNull("Null field should not be created", doc.rootDoc().getField("mixed_nulls.null_field"));
            {
                    {
                        b.field("match", "bar");
                        b.startObject("mapping").field("type", "keyword").endObject();
        assertEquals("flattened_value", doc2.rootDoc().getField("level1.level2.level3.deep.nested.field.name").stringValue());
        });
        ParsedDocument doc = defaultMapper.parse(source(b -> {
            b.startObject("location_copy").field("type", "geo_point").endObject();
                }
                        b.field("match_mapping_type", "object");
import org.opensearch.plugins.Plugin;
        Mapping mappingUpdate = doc2.dynamicMappingsUpdate();
            b.startObject("point");
            b.startObject("properties");
        BytesReference json = new BytesArray(copyToBytesFromClasspath("/org/opensearch/index/mapper/simple/test1-notype-noid.json"));
        assertNotNull("Field 'user.name' should exist", doc.rootDoc().getField("user.name"));
            b.startObject("type").field("type_field", "type_value").endObject();
        ParsedDocument doc1 = mapper.parse(source(b -> {
            b.startObject("foo");
                {
            {
            b.startObject("inner").field("inner_field", "inner_value").endObject();
        assertNotNull("Field 'outer.deep.nested.field' should exist", doc2.rootDoc().getField("outer.deep.nested.field"));
    }
    public void testDynamicDottedFieldNameLongArrayWithExistingParent() throws Exception {
        assertNotNull(doc.rootDoc().getField("point"));
            MapperParsingException.class,
                + "Existing mapping for [alias-field] must be of type object but found [alias].",
        String mapping = copyToStringFromClasspath("/org/opensearch/index/mapper/simple/test-mapping.json");
        List<Mapper> updates = new ArrayList<>();
                        b.startObject("mapping").field("type", "object").endObject();
        }
        assertNotNull(doc1);
                    b.field("type", "object");
        );
        Document doc = docMapper.parse(source(b -> {
                        b.endObject();
            b.startArray("dynamic_templates");
                b.startObject("user.name");
        assertEquals(6, doc2.rootDoc().getFields("numbers").length); // 3 values * 2 fields each (numeric + stored)
        assertThat(doc.get(docMapper.mappers().getMapper("name.first").name()), equalTo("fred"));
        );
            b.endArray();
    public void testDynamicDottedFieldNameWithFieldAlias() throws Exception {
            StrictDynamicMappingException.class,
        updates.add(new MockFieldMapper("x.a"));
            b.endArray();
        // Test with single level under disable_objects parent
    public void testDynamicStrictAllowTemplatesNull() throws Exception {
            b.startObject("bar").field("type", "boolean").endObject();
                        b.startObject("mapping").field("type", "keyword").endObject();
            b.endArray();
            assertThat(exception.getMessage(), containsString("failed to parse field [bar] of type [boolean] in document with id '1'"));
    }
            assertTrue(e.getMessage(), e.getMessage().contains("failed to parse field [_mock_metadata]"));
            assertNull("ObjectMapper 'metrics' should NOT exist at root (dotted name should be kept flat)", metricsMapper);
                    b.endObject();
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {}));
                {
                        b.field("match", "big-*");
        assertEquals("address.city should be text in reverse order", "text", ms2.fieldType("attributes.address.city").typeName());
        }));
                            .endObject()
        // Test with array of objects containing dotted field names
            {
                    b.endObject();
import static org.hamcrest.Matchers.instanceOf;
                b.startObject("inner" + i);
            }
    public void testDynamicFieldsEmptyName() throws Exception {
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "strict")));
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "false")));
            {
            b.startArray().value(0).value(0).endArray();
    }
        assertThat(bazMapper, instanceOf(NumberFieldMapper.class));
            b.endArray();
        );
                    }
                }
    }
            Mapper logAttrsMapper = dynamicUpdate.root().getMapper("LogAttributes");
            "Could not dynamically add mapping for field [alias-field.dynamic-field]. "
            {
        }));
            }
    }
                {
                {
        Mapping mapping = DocumentParser.createDynamicUpdate(docMapper.mapping(), docMapper, updates);
            b.field("dynamic", "strict_allow_templates");
            b.field("disable_objects", true);  // Root level has disable_objects=true
                    b.field("dynamic", true);
                b.endObject();
                        b.endObject();
        StrictDynamicMappingException exception = expectThrows(
 * under the License.
        MapperService mapperService = createMapperService(mapping(b -> {}));
    private DocumentMapper createDisableObjectsMapper(boolean rootDisableObjects, String objectPath, boolean objectDisableObjects)
                    b.value("mastercard");
                        b.field("field", "testvalue");
                        b.endObject();
import org.opensearch.index.engine.dataformat.DocumentInput;
                {
                b.startObject();
                    b.endObject();
        }));
        Mapper fooMapper = mapping.root().getMapper("foo");
        assertThat(emptyFieldNameException.getMessage(), containsString("object field cannot contain only whitespace: ['top.aoeu. ']"));
            b.endArray();
    }
    public void testProcessFlattenedTokenNullValueForDisableObjects() throws Exception {
            () -> mapper.parse(source(b -> b.field("alias-field", "value")))
        IndexableField[] paymentFields = doc.rootDoc().getFields("LogAttributes.app.payment");
            b.field("dynamic", "true");
            StrictDynamicMappingException.class,
                b.endObject();
        assertNotNull(barMapper);
                b.startArray().value("b1").value("b2").endArray();
        // Dynamic mapping update expected since "address" is not pre-defined
            "Field 'level1.level2.level3.simple.field' should exist",
                    {
                b.startObject();
            b.field("dynamic", false);
        );
    public void testGeoPointArrayWithCopyTo() throws Exception {
                }
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
                b.endObject();
                    b.startObject("test1");
        // Assert address.city is NOT treated as a multi-field of address
                        b.startObject("mapping").field("type", "keyword").endObject();
                }
                    b.startObject("target_template");
        assertEquals("value2", mixedFields[1].stringValue());
            () -> mapper.parse(source(b -> b.startArray("field.bar.baz").value(0).value(1).endArray()))
                    b.startObject("level3");
    }
        assertEquals("value3", doc.rootDoc().getField("mixed_nulls.nested").stringValue());
                    {
        // Dynamic mapping update expected since "address" is not pre-defined
import static org.hamcrest.Matchers.containsString;
        {
        // This tests the code path: parseNonDynamicArray -> processFlattenedTokenForDisableObjects
 * GitHub history for details.
            {
        // Test various field paths that should trigger the path splitting logic
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "false_allow_templates")));
        assertEquals("mapping set to strict, dynamic introduction of [bar] within [_doc] is not allowed", exception.getMessage());
            StrictDynamicMappingException.class,
        Mapper fooMapper = doc.dynamicMappingsUpdate().root().getMapper("foo");
            }
            b.startArray("dynamic_templates");
        assertNotNull(inner3_mapper);
                        }
        assertThat(err.getCause(), notNullValue());
        ParsedDocument doc = mapper.parse(source(b -> b.field("foo.bar.baz", 0)));
            {
                        b.startObject("mapping").field("type", "long").endObject();
                    {
    }
            b.endObject();
        {
                }
    public void testNoLevelWithFieldTypeAsObjectNotFirst() throws Exception {
        ParsedDocument dynamicDoc = dynamicMapper.parse(source(b -> {
                    {
                {
                    b.startObject(objectPath);
    public void testDocumentContainsDeepNestedFieldParsingShouldFail() throws Exception {
        assertThat(doc.rootDoc().get("inner.inner_field"), equalTo("inner_value"));
                    {
                b.endObject();
            assertNull(doc.rootDoc().getField("field.bar"));
        ParsedDocument doc = mapper.parse(source(b -> b.field("foo.bar.baz", 0)));
     * dynamic mapper builders in {@link DocumentParser}.
                    b.startObject("test");
        // We should have generated a date field
    public void testCopyToFieldAlias() throws Exception {
                    b.endObject();
                    b.startArray("foo.");
            b.startObject("y").field("type", "object").endObject();
                    b.field("type", "integer");
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> mapper.parse(source(b -> b.field("foo.bar", 42))));
            b.startObject("foo");
                b.startObject("properties");
                + "Existing mapping for [field] must be of type object but found [long].",
        assertEquals(2, fields.length);
        Mapping mapping = DocumentParser.createDynamicUpdate(docMapper.mapping(), docMapper, updates);
                    }
            b.startObject("point");
                b.startObject();
        // Test comprehensive automatic flattening scenarios with disable_objects=true
        assertEquals(
        return (ObjectMapper) builder.build(builderContext);
            b.startObject("properties");
                        b.startObject().field("thing", "bah").endObject();
            b.startArray("top.");
                    {
                b.startObject();
                        b.field("match", "bar");
                b.field("test1", "value1");
    }
            """));
        assertThat(exception.getMessage(), containsString("strict"));
        DocumentMapper mapperWithExistingField = createDocumentMapper(topMapping(b -> {
        assertEquals("prod1", idFields[0].stringValue());
                {
                assertTrue("'app.payment' should be a FieldMapper", appPaymentMapper instanceof FieldMapper);
                b.endObject();
            b.field("dynamic", false);
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
    }
        Mapper objMapper = update.root().getMapper("inner1");
            b.startObject("nested");
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> mapperService.documentMapper().parse(source(b -> {
                        {
        assertEquals(
            }
    }
        }));
    }
            b.endArray();
        assertThat("Mapper should be a FieldMapper", cpuMapper, instanceOf(FieldMapper.class));
        assertEquals(4, doc.rootDoc().getFields("field").length);
                    {
        assertNotNull(update); // dynamic mapping update
                        }
                        b.field("match", "numeric_*");
        Mapper fooMapper = doc.dynamicMappingsUpdate().root().getMapper("field");
                b.endObject();
                b.startObject("properties");
                        b.field("match", "foo*");
        Mapper objMapper = update.root().getMapper("inner1");
            {
            b.field("dynamic", false);
            b.startObject("alias-field");
        Mapper xMapper = mapping.root().getMapper("x");
    public void testGeoPointWithCopyTo() throws Exception {
        }));
        if (dynamicUpdate != null) {
            b.field("disable_objects", true);
            assertThat(m, instanceOf(FieldMapper.class));
     * default to not-indexed, just like explicitly mapped ones — otherwise inferred fields would keep
            {
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
        StrictDynamicMappingException exception = expectThrows(
        Document doc = docMapper.parse(new SourceToParse("test", "1", json, MediaTypeRegistry.JSON)).rootDoc();
    }
            MapperParsingException.class,
        IllegalArgumentException emptyFieldNameException = expectThrows(IllegalArgumentException.class, () -> mapper.parse(source(b -> {
        }));
        assertEquals("root_flattened", doc1.rootDoc().getField("root.level.dotted.field").stringValue());
        assertEquals(0, doc.rootDoc().getFields("foo").length);
            if (logAttrsMapper instanceof ObjectMapper logAttrsObj) {
                    b.field("type", "text");
        MapperService mapperService = createMapperService(topMapping(b -> {
        // Test with very long dotted path
        assertThat(doc.rootDoc().get("inner1.inner2.inner3.inner3_field1"), equalTo("inner3_value1"));
        }));
            b.startArray("field");
                b.endObject();
                    b.endObject();
            b.endArray();
    ObjectMapper createObjectMapper(MapperService mapperService, String name) {
        // Test 3: Null value in flattened object with default dynamic mapping should be handled gracefully
    }
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "strict")));
                    }
            {
        Mapping update = doc.dynamicMappingsUpdate();
        assertEquals("mapping set to strict, dynamic introduction of [foo] within [_doc] is not allowed", exception.getMessage());
            }
    }
                    b.startObject("test2");
                b.endObject();
        assertNotNull(doc.rootDoc().getField(IdFieldMapper.NAME));
            b.endArray();
        }
                b.field("type", "value_type");
                }
        assertNull(doc.dynamicMappingsUpdate());
        assertNotNull(inner2_mapper);
                b.startObject();
                {
    }
                    }
        IndexableField[] fields = doc.rootDoc().getFields("big-decimal");
        assertEquals(0, doc.rootDoc().getFields("float_field").length);
                                    b.field("type", "object");
            {"attributes": {"address": "US"}}
        assertEquals("John", doc.rootDoc().getField("user.name").stringValue());
                + "Existing mapping for [field] must be of type object but found [long].",
        assertEquals("exactmatch", doc5.rootDoc().getField("a.b.c").stringValue());
            {"attributes": {"address": "US"}}
    }
            b.endArray();
        assertNotNull("Field 'a.b.c.d.e.f.g.h.i.j' should exist", doc2.rootDoc().getField("a.b.c.d.e.f.g.h.i.j"));
            b.endObject();
                    b.startObject("embedded_template");
                    b.startObject("first");
                {
                        b.field("path_match", "foo.bar.baz.a");
        assertNotNull(fooMapper);
        assertTrue(
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "false")));
        DocumentInput<?> noopInput = new CapturingDocumentInput();
        assertFalse("Text field should not have keyword multi-field with pluggable dataformat", textMapper.iterator().hasNext());
                b.field("type", "nested");
            assertNull(doc.rootDoc().getField("field"));
                    b.value("visa");
            b.field("dynamic", false);
        assertEquals(
                {
                b.nullField("description"); // This null field should not create a field via processFlattenedTokenForDisableObjects
     * Dynamically inferred numeric, date and boolean fields on a pluggable-dataformat index must
            }
        );
        );
                {
        );
                b.endObject();
        assertNotNull(inner1_field1_mapper);
    }
                {
            StrictDynamicMappingException.class,
        assertNotNull("Field 'product.price' should exist", doc.rootDoc().getField("product.price"));
            }
            e.getCause().getMessage().contains("Field [_field_names] is a metadata field and cannot be added inside a document.")
            assertNull(doc.rootDoc().getField("bar"));
                b.startObject();
            b.field("dynamic", "false_allow_templates");
    }
            }
        }));
            b.startObject("properties");
    }
        // to create an intermediate ObjectMapper ("app") without disable_objects=true, breaking
        assertEquals(0, doc.rootDoc().getFields("bigdecimal_field").length);
                b.startObject("inner2");
import org.apache.lucene.util.BytesRef;
                b.endObject();
                    b.endObject();
                        b.startObject("name");
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> {
            {
                        b.field("type", "text");
    public void testMultipleSubfieldMappingUpdate() throws Exception {
                    }
                {
     * index:true and their range/term queries would match nothing. Guards the settings passed to the
                b.startArray().value("c1").value("c2").endArray();
        );
            }
import java.nio.charset.StandardCharsets;
                {
    public void testParseToJsonAndParse() throws Exception {
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
                    {
        List<Mapper> updates = Collections.singletonList(new MockFieldMapper("x.subx.foo"));
            mapper.parse(source(b -> b.field("new.field", "value")));
                }
        DocumentMapper docMapper = createDummyMapping();
        assertNotNull(result.docs().get(1).getField(IdFieldMapper.NAME));
        assertThat(aMapper, instanceOf(NumberFieldMapper.class));
            "address.city should be text after prefix conflict",
        Mapper inner3_mapper = ((ObjectMapper) inner2_mapper).getMapper("inner3");
            ParsedDocument doc = mapper.parse(source(b -> {
            b.startArray("items");
            {"attributes": {"address.city": "Austin", "address.state": "Texas"}}
            b.endObject();
                b.endObject();
        Mapper aMapper = ((ObjectMapper) bazMapper).getMapper("a");
                b.startObject();
        );
                    b.endObject();
                {
        // Dynamic mapping update expected since "address.city" and "address.state" are not pre-defined
        );
            "mapping set to strict_allow_templates, dynamic introduction of [bar] within [_doc] is not allowed",
        assertTrue("Should have item.category.name fields", categoryFields.length > 0);
                b.startObject();
                b.endObject();
            }
        }));
                {
import org.opensearch.core.xcontent.MediaTypeRegistry;
                }
        assertEquals(4, doc.rootDoc().getFields("foo").length);
        assertEquals(1, doc.rootDoc().getFields("nested.source_field").length);
                b.startObject("bar").field("baz", "something").endObject();
                        b.startObject("cpu.usage");
        assertNotNull(doc.rootDoc().getField("field"));
            b.startArray("bar");
        assertThat(e.getCause().getMessage(), containsString("field name cannot contain only the character [.]"));
        // Dynamic mapping update expected since "address" is not pre-defined
        );
                b.endObject();
        }));
        {
        ParsedDocument doc = mapper.parse(source(b -> b.nullField("bar")));
    public void testTypeless() throws IOException {
            b.endObject();
            {
            }
    }
        assertEquals(2, doc.rootDoc().getFields("products.details.category.main").length);
        }));
            b.startArray("inner");
    public void testDocumentContainsAllowedMetadataField() throws Exception {
        assertThat(doc.get(docMapper.mappers().getMapper("name.first").name()), equalTo("fred"));
        ParsedDocument doc3 = mapper.parse(source(b -> { b.field("simple", "simple_value"); }));
        DocumentMapper defaultMapper = createDocumentMapper(mapping(b -> {}));
        DocumentMapper mapperWithDynamic = createDocumentMapper(topMapping(b -> {
            b.startObject("obj");
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "false")));
                        b.startObject("mapping").field("type", "object").endObject();
                b.endObject();
        assertNotNull(result.docs().get(0).getField(NestedPathFieldMapper.NAME));
import org.opensearch.Version;
    }
            b.startObject("product");
                        }
        assertEquals(30L, doc.rootDoc().getField("user.age").numericValue().longValue());
    public void testDocumentContainsMetadataField() throws Exception {
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {
                        b.field("type", "object");
                        b.nullField("category"); // Only null field - should trigger the exception via
        StrictDynamicMappingException exception = expectThrows(
            {
                        b.startObject("mapping").field("type", "object").endObject();
                        b.field("match_mapping_type", "long");
                }
                {
                        b.endObject();
        Mapper subxMapper = ((ObjectMapper) xMapper).getMapper("subx");
                }
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {}));
    }
                {
            """));
    public void testDynamicFalseAllowTemplatesWithBooleanDetection() throws Exception {
        assertEquals(1, doc.rootDoc().getFields("target_field").length);
            b.endArray();
                b.startObject();
            }
        }));
        }));
        );
        // When root has disable_objects=true, any dotted field name should be treated as a flat field
 * Modifications Copyright OpenSearch Contributors. See
                {
    }
    }
                b.field("copy_to", "location_copy");
                        b.startObject("mapping").field("type", "long").endObject();
            }
        assertNotNull(((ObjectMapper) subxMapper).getMapper("foo"));
                b.startObject("properties");
import org.opensearch.common.settings.Settings;
                            b.endObject();
                }
        DocumentMapper docMapper = createDummyMapping();
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {}));
        // Test single level field (should work normally)
        assertThat(fooMapper, instanceOf(ObjectMapper.class));
                b.field("inner1_field1", "inner1_value1");
                {
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {
        }));
        assertThat(doc.rootDoc().get("test2"), equalTo("value2"));
        ParsedDocument parsedDoc = mapperWithDynamic.parse(source(b -> b.field("source_field", "test value")));
                b.endObject();
            b.field("inner", "test");
    public void testDynamicFalseAllowTemplatesWithEmbeddedObject() throws Exception {
        // Test predefined field
        assertNotNull("Field 'user.address.city' should exist", doc.rootDoc().getField("user.address.city"));
        DocumentMapper defaultMapper = createDocumentMapper(mapping(b -> {}));
                b.startObject("foo");
        for (int i = 0; i < expectedValues.length; i++) {
    }
                    }
                        b.startObject("mapping").field("type", "long").endObject();
                b.endObject();
    }
            }
        // Test deeply nested objects, multiple fields, and mixed scenarios
                    b.field("type", "object");
                b.field("path", "concrete-field");
                    b.endObject();
        assertNotNull("Field 'mixed_array.value' should exist", doc3.rootDoc().getField("mixed_array.value"));
    }
        assertTrue(xMapper instanceof ObjectMapper);
            .put("index.pluggable.dataformat.enabled", true)
                        b.field("match", "bigdecimal_*");
                    b.field("item.category.name", "electronics");
        }));
        ParsedDocument doc = mapper.parse(source(b -> {
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.startArray("dynamic_date_formats").value("yyyy MM").endArray()));
        DocumentMapper defaultMapper = createDocumentMapper(mapping(b -> {}));
        }));
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
                    b.endObject();
            "Could not dynamically add mapping for field [field.bar.baz]. "
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "strict")));
        StrictDynamicMappingException exception = expectThrows(
        String builtMapping = docMapper.mappingSource().string();
        Mapper fooMapper = doc.dynamicMappingsUpdate().root().getMapper("field");
        ParsedDocument doc = mapper.parse(source(b -> {
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
            b.field("dynamic", "strict_allow_templates");
            }
            () -> mapper.parse(source(b -> b.field("field.bar.baz", 0)))
                }
                        b.field("match", "bar");
            }
        assertEquals(0, doc.rootDoc().getFields("foo.bar.baz").length);
import static org.hamcrest.Matchers.equalTo;
        Mapper bazMapper = ((ObjectMapper) barMapper).getMapper("baz");
                            b.field("e.f.g", "deepvalue");
            {
                b.field("memory.used", 8589934592L);
        assertEquals(4, doc.rootDoc().getFields("foo.bar.baz").length);
                            b.startObject("properties");
            }
        }));
            b.startArray("dynamic_templates");
        DocumentMapper defaultMapper = createDocumentMapper(mapping(b -> {}));
            ParsedDocument doc = mapper.parse(source(b -> b.field("field.bar", Collections.singletonMap("key", "value"))));
                        b.startObject("mapping").field("type", "object").endObject();
        assertNotNull(((ObjectMapper) subxMapper).getMapper("b"));
        if (parsedDoc.dynamicMappingsUpdate() != null) {
                    }
                    b.endObject();
                        b.field("match_mapping_type", "string");
    public void testSingleMappingUpdate() throws Exception {
            }
                    b.endObject();
                b.startArray("items");
                        b.field("match", "foo");
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {}));
            }
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
            b.startArray("dynamic_templates");
                b.endObject();
        assertNotNull(barMapper);
        assertNull("no doubled name after round-trip", recoveredService.fieldType("attributes.address.address.city"));
    public void testMappedNullValue() throws Exception {
                }
        assertNotNull(
        IndexableField[] copy2Fields = doc.rootDoc().getFields("location_copy2");
                b.startObject();
                    {
        StrictDynamicMappingException exception2 = expectThrows(StrictDynamicMappingException.class, () -> {
                b.startObject();
                b.startObject();
        assertEquals("deepvalue", doc4.rootDoc().getField("a.b.c.very.deep.nested.field.with.many.levels").stringValue());
        assertThat(fooMapper, instanceOf(ObjectMapper.class));
                    b.field("type", "object");
            b.endArray();
                b.startArray();
        assertEquals(0, docWithTemplate.rootDoc().getFields("numeric_field").length);
            }
                {
                        b.startObject("mapping").field("type", "object").endObject();
        assertEquals(2, doc.rootDoc().getFields("foo").length);
        // Nested object with array: {"LogAttributes": {"app": {"payment": ["visa", "mastercard"]}}}
        }));
                    b.endObject();
        assertEquals(75.5f, flatDoc.rootDoc().getField("metrics.cpu.usage").numericValue().floatValue(), 0.001f);
                b.startObject();
 *
        assertNotNull(doc3);
        mapper.parse(source(b -> b.field("foo._field_names", 0))); // parses without error
                    b.startObject("bar").field("type", "keyword").endObject();
        }));
        assertThat(doc.rootDoc().get("type.test2"), equalTo("value2"));
        // First establish the existing mapper structure
                        b.field("match", "test1");
                b.endObject();
            {
        assertNotNull(fooMapper);
                {
    }
        ParsedDocument doc = mapper.parse(source(b -> b.startObject("test").field("test1", "foo").endObject()));
        Mapper bazMapper = ((ObjectMapper) barMapper).getMapper("baz");
        BytesReference json = new BytesArray(copyToBytesFromClasspath("/org/opensearch/index/mapper/simple/test1.json"));
            () -> mapper.parse(source(b -> b.nullField("bar")))
        // Test 3: Default behavior (disable_objects=false)
                    {
            doc1.rootDoc().getField("level1.level2.level3.simple.field")
                b.startObject();
        }));
                    {
        ParsedDocument doc = defaultMapper.parse(source(b -> {
                b.endObject();
                }
        );
            "mapping set to strict_allow_templates, dynamic introduction of [foo] within [_doc] is not allowed",
        // Test that nested object structures are automatically flattened
    public void testDynamicStrictDottedFieldNameObject() throws Exception {
            b.field("dynamic", "strict_allow_templates");
        }));
                {
            }
            MapperParsingException.class,
        }));
        assertEquals("value2", doc3.rootDoc().getField("a.b.c.single").stringValue());
                        b.field("match", "float_*");
        assertNull(((ObjectMapper) subxMapper).getMapper("subsubx"));
            () -> mapper.parse(source(b -> b.startObject("foo").field("bar", "baz").endObject()))
    // Helper method to create a mapper with disable_objects configuration
        assertEquals(6, fields.length);
    public void testDynamicFalseAllowTemplatesLongArray() throws Exception {
            {
    public void testNoLevelWithFieldTypeAsValueNotFirst() throws Exception {
 * the Apache License, Version 2.0 (the "License"); you may
                    b.startObject("properties");
            {
        ParsedDocument doc2 = mapper.parse(source(b -> {
                    {
        assertEquals("deepvalue", doc2.rootDoc().getField("a.b.c.d.e.f.g").stringValue());
    }
            b.endArray();
        assertThat(e.getCause(), notNullValue());
        assertThat(barMapper, instanceOf(ObjectMapper.class));
            assertEquals("mock-metadata-field-value", field.stringValue());
                b.startArray().value(1).value(1).endArray();
        }));
            b.field("dynamic", "false_allow_templates");
            b.startObject("properties");
        DocumentMapper mapperWithTemplate = createDocumentMapper(topMapping(b -> {
        ParsedDocument doc = defaultMapper.parse(source(b -> {
            {
    public void testDocumentDeepNestedObjectAndArrayCombination() throws Exception {
                            b.field("type", "object");
                b.startObject("numbers");
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> mapper.parse(source(b -> b.field("field.bar", 123))));
        // Test nested arrays within disable_objects mode
                    b.endObject();
        assertNotNull("Field 'root.level.dotted.field' should exist", doc1.rootDoc().getField("root.level.dotted.field"));
                    b.startObject("date_template");
        MapperParsingException exception = expectThrows(
            b.endObject();
            b.field("dynamic", "true");
                    b.endObject();
        // Verify in the case where only a single type is allowed that the _id field is added to nested documents:
            b.endObject();
            for (int i = 1; i < depth_limit - 1; i++) {
    public void testDynamicStrictAllowTemplatesDottedFieldNameLong() throws Exception {
                    b.endObject();
                    b.startObject("georule");
        }));
                    b.startObject("test");
import org.opensearch.index.IndexSettings;
                        b.startObject("mapping").field("type", "float").endObject();
                }
            b.field("dynamic", "true");
                b.startObject();
            () -> mapper.parse(source(b -> b.startArray("foo").value(0).value(1).endArray()))
        // First establish the mapping structure
            doc4.rootDoc().getField("a.b.c.very.deep.nested.field.with.many.levels")
                    {
                    b.endObject();
                        b.field("type", "text");
        }));
                b.endObject();
            b.startArray("foo");
            {
        assertThat(fooMapper, instanceOf(ObjectMapper.class));
            b.endArray();
            b.startArray("inner");
            }
    public void testDynamicFalseAllowTemplatesNull() throws Exception {
                    {
            {
        assertEquals(123, fields[0].numericValue());
        assertThat(doc.rootDoc().get("type.inner.inner_field"), equalTo("inner_value"));
                b.startObject("inner");
                    b.startObject("bigdecimal_template");
            b.startArray("top.");
        assertEquals(2, docWithTemplate.rootDoc().getFields("foo.bar.baz").length);
        assertThat(bazMapper, instanceOf(ObjectMapper.class));
        assertEquals(2, doc.rootDoc().getFields("field").length);
        DocumentMapper strictMapper = createDocumentMapper(topMapping(b -> {
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "long")));
            () -> mapper.parse(source(b -> b.field("bar", "baz")))
    }
                    {
            doc3.rootDoc().getField("level1.level2.level3.very.long.dotted.field.path")
            {
                    {
                {
            MapperParsingException e = expectThrows(
            b.endArray();
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "object")));
    }
        );
        IndexableField[] fields = doc.rootDoc().getFields("foo.bar.baz");
        ParsedDocument doc2 = mapperService.documentMapper().parse(source("""
                b.endObject();
        assertNotNull(barMapper);
                        b.startObject("level2");
    public void testRootLevelDisableObjectsPrefixConflict() throws Exception {
            // A metadata field that parses a value fails to parse an object
        assertThat(fooMapper, instanceOf(ObjectMapper.class));
                        b.startObject("mapping").field("type", "keyword").endObject();
        CapturingDocumentInput mockInput = new CapturingDocumentInput();
            }
                    b.field("type", "object");
            {
                    b.endArray();
                {
        assertThat(barMapper, instanceOf(ObjectMapper.class));
                    b.startObject("aoeu").field("a", 1).field(" ", 2).endObject();
                b.field("test1", "value1");
        String mapping = copyToStringFromClasspath("/org/opensearch/index/mapper/simple/test-mapping.json");
                        b.field("match", "foo");
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {
            b.startObject("foo");
        // Verify all fields were flattened correctly
        }));
    public void testDotsWithFieldDisabled() throws IOException {
            b.startObject("field");
            b.startObject("type").field("type_field", "type_value").endObject();
                    b.startObject("test2");
    }
    public void testNoLevel() throws Exception {
            {
                            b.field("main", "electronics");
        // Verify the values are correctly stored
    }
        Mapper inner2_mapper = ((ObjectMapper) objMapper).getMapper("inner2");
                        b.field("match_mapping_type", "object");
            () -> mapper.parse(source(b -> b.startObject("foo.bar.baz").field("a", 0).endObject()))
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
        ParsedDocument doc = defaultMapper.parse(source(b -> {
 *
        assertNotNull(((ObjectMapper) xMapper).getMapper("foo"));
                    }
                    b.startObject("test");
            }
                            b.startObject("bar.");
            {
                        {
            b.field("dynamic", "false_allow_templates");
        DocumentMapper defaultMapper = createDocumentMapper(mapping(b -> {}));
                b.startObject();
            b.field("disable_objects", true);
        DocumentMapper docMapper = createDocumentMapper(mapping(b -> {
    public void testDynamicObjectWithTemplate() throws Exception {
                    {
                    b.startObject("inner").field(".", 2).endObject();
            b.field("dynamic", "false_allow_templates");
        }
            }
    public void testDynamicFalseAllowTemplatesDottedFieldNameLong() throws Exception {
                () -> mapper.parse(source(b -> b.nullField(MockMetadataMapperPlugin.MockMetadataMapper.CONTENT_TYPE)))
            .numberOfShards(1)
    public void testDisableObjectsBasicFunctionality() throws Exception {
        // This comprehensively tests the condition: parentPath.isEmpty() || parentPath.equals("_doc")
        assertEquals("John Doe", doc.rootDoc().getField("user.name").stringValue());
        assertThat(doc.get(builtDocMapper.mappers().getMapper("name.first").name()), equalTo("fred"));
            b.startObject("properties");
    public void testDynamicStrictLongArray() throws Exception {
            {
        assertNotNull(barMapper);
        updates.add(new MockFieldMapper("x.bar"));
            b.startObject("nested");
 * Licensed to Elasticsearch under one or more contributor
        }));
                    b.endObject();
/*
        ParsedDocument flatDoc = flatFieldMapper.parse(source(b -> {
        assertNull(doc.rootDoc().getField("foo"));
    public void testDynamicFalseNull() throws Exception {
    }
                }
                    }
        }));
                    {
            b.startArray("dynamic_templates");
        assertEquals(0, doc.rootDoc().getFields("nested.target_field").length);
                b.field("last", "quxx");
        assertThat(bazMapper, instanceOf(NumberFieldMapper.class));
            }
        assertEquals(2, doc.rootDoc().getFields("foo.bar.baz").length);
            b.startObject("mapping").field("type", "text").field("copy_to", "event_all");
            b.endObject();
            {
        DocumentMapper builtDocMapper = createDocumentMapper(MapperService.SINGLE_MAPPING_NAME, builtMapping);
        DocumentMapper defaultMapper = createDocumentMapper(mapping(b -> {}));
                }
        ParsedDocument doc = mapper.parse(source(b -> b.startArray("foo.bar.baz").value(0).value(1).endArray()));
                b.endObject();
        assertNotNull("doc1 should produce dynamic mapping update", doc1.dynamicMappingsUpdate());
        Mapper.BuilderContext builderContext = new Mapper.BuilderContext(context.indexSettings().getSettings(), context.path());
        assertThat(fooMapper, instanceOf(ObjectMapper.class));
    public void testDynamicFalseValue() throws Exception {
                }
                        b.field("match", "baz");
            {
        MapperParsingException exception = expectThrows(
                        b.startObject("d");
        }
                        b.field("match", "foo*");
        {
                MapperParsingException.class,
        ParsedDocument docWithTemplate = mapperWithTemplate.parse(source(b -> b.field("bool_field", true)));
            }
                b.startObject("cpu");
                {
                b.field("path", "concrete-field");
                    b.startObject("big-decimal-to-scaled-float");
        assertThat(aMapper, instanceOf(NumberFieldMapper.class));
                {
                b.startArray().value(0).value(0).endArray();
        assertEquals(2, doc.rootDoc().getFields("foo.bar.baz.a").length);
                b.endObject();
        }));
                    b.endObject();
                {
            StrictDynamicMappingException.class,
        assertEquals("prod2", idFields[1].stringValue());
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "false_allow_templates")));
        // when encountering an ObjectMapper with disable_objects=true
        ParsedDocument doc3 = mapper.parse(source(b -> { b.field("level1.level2.level3.very.long.dotted.field.path", "another_value"); }));
                    b.nullField("age"); // Only null field - should trigger the exception via processFlattenedTokenForDisableObjects
                    b.field("name", "john"); // This has existing mapping, should work
            b.endObject();
    }
            MapperParsingException.class,
                    {
                    }
            b.endArray();
            }
    }
                {
                b.endObject();
        }
            {
        Mapper xMapper = mapping.root().getMapper("x");
                b.endObject();
        assertEquals(4, doc.rootDoc().getFields("foo").length);
                b.endObject();
    public void testDotsWithDynamicNestedMapper() throws Exception {
                b.startObject("foo");
    }
        assertNotNull(
    }
        DocumentMapper mapper = createDocumentMapper(MapperService.SINGLE_MAPPING_NAME, mapping);
                b.endObject();
            "Field 'a.b.c.very.deep.nested.field.with.many.levels' should exist",
        // Root-level disable_objects with dynamic fields that have prefix conflicts
                    }
                        b.startObject("mapping").field("type", "object").endObject();
                    }
            b.startObject("properties");
        merge(mapperService, dynamicMapping(doc1.dynamicMappingsUpdate()));
                b.endObject();
                        b.startObject("mapping").field("type", "long").endObject();
        // Without pluggable data format, text field SHOULD have .keyword multi-field
            }
                b.startObject().field("bar", "value1").endObject();
            {
                b.field("type", "type_value");
                b.endObject();
    }
    public void testDynamicFieldsWithOnlyDot() throws Exception {
    public void testDynamicDottedFieldNameLongArray() throws Exception {
    public void testParseDocumentWithoutDocumentInputDefaultsToNull() throws Exception {
                        b.startObject("mapping");
        // Test edge case with deeply nested structure
            b.startObject("type");
        // disable_objects should only be set at ONE place, not multiple levels
        // Test another case with multiple segments to flatten
                        b.field("match", "target_*");
            b.endObject();
                    b.startObject("source_field");
        ParsedDocument docWithTemplate = mapperWithTemplate.parse(source(b -> b.startArray("foo.bar.baz").value(0).value(1).endArray()));
                    {
import static org.opensearch.test.StreamsUtils.copyToStringFromClasspath;
        assertThat(doc.rootDoc().get("type.test2"), equalTo("value2"));
        assertTrue(subxMapper instanceof ObjectMapper);
                }
        assertNotNull("Field 'user.address.zip' should exist", doc.rootDoc().getField("user.address.zip"));
 * software distributed under the License is distributed on an
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {
            b.startArray("top");
        // Should have 2 instances of each field (one for each object in the array)
                b.startObject("type").field("type_field", "type_value").endObject();
            b.endObject();
                            b.field("main", "electronics");
                b.endObject();
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "strict_allow_templates")));
    public void testDynamicTextFieldWithKeywordMultiFieldForNonPluggableDataFormat() throws Exception {
        }));
        assertThat(exception2.getMessage(), containsString("strict"));
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "value")));
            b.endObject();
                    {
                    b.field("value", 200);
        }));
        // Assert both fields are resolvable
    // object -> array -> object -> array ....
            }
    }
        assertEquals(2, doc.rootDoc().getFields("test1").length);
            {
            {
        MapperService mapperService = createMapperService(mapping(b -> {}));
                }
    }
            .toString();
            b.startArray("dynamic_templates");
                }
        }));
        );
        }));
            assertEquals(expectedValues[i], fields[i].stringValue());
            }
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "strict")));
        assertThat(doc.rootDoc().get("inner.inner_field"), equalTo("inner_value"));
                b.field("type", "geo_point");
            {
                {
                    b.startObject("georule");
        }));
                        {
                    b.endObject();
        assertEquals(0, doc.rootDoc().getFields("bar").length);
        // Test new dynamic field with shared prefix
        CapturingDocumentInput mockInput = new CapturingDocumentInput();
        }));
        e = expectThrows(
                    b.endObject();
        // Test the specific code path: processFlattenedTokenForDisableObjects -> processNullValueForDisableObjects
        assertThat(doc.rootDoc().get("type.test2"), equalTo("value2"));
                b.startObject();
        assertEquals("literalvalue", doc3.rootDoc().getField("outer.literal.field.name").stringValue());
        assertEquals("simple_value", doc3.rootDoc().getField("simple").stringValue());
                        b.field("match", "foo*");
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "false")));
                        b.field("match_mapping_type", "object");
        IndexableField[] fields = doc.rootDoc().getFields("nested_arrays");
    public void testRootLevelDisableObjects() throws Exception {
            b.field("dynamic", "true");
        assertEquals(0, doc.rootDoc().getFields("bigint_field").length);
        }));
            assertNull(doc.rootDoc().getField("field.bar"));
        assertThat(barMapper, instanceOf(ObjectMapper.class));
                        b.startObject("mapping").field("type", "keyword").endObject();
        assertEquals(0, docWithTemplate.rootDoc().getFields("float_field").length);
                b.endObject();
        assertEquals(IdFieldMapper.Defaults.NESTED_FIELD_TYPE, result.docs().get(0).getField(IdFieldMapper.NAME).fieldType());
        // Copying to a field that is not in the mapping should not create a field in the document
                            }
        ParsedDocument doc3 = mapper.parse(source(b -> {
                            {
        assertThat(doc.getBinaryValue(docMapper.idFieldMapper().name()), equalTo(Uid.encodeId("1")));
                b.endObject();
                    b.startObject("test3");
            }
            b.endArray();
        Mapper fooMapper = doc.dynamicMappingsUpdate().root().getMapper("foo");
        // Test 1: Flat fields with disable_objects=true
                    b.startObject("c");
                        b.field("match", "foo");
        // Test 1: Root-level disable_objects with dynamic fields
        // Test that a deeply nested field is also flattened correctly
                {
    public void testDynamicDateDetectionEnabledWithNoSpecialCharacters() throws IOException {
            {
                    b.startObject("nested_template");
                                }
                b.endObject();
                        b.startObject("memory.used");
            () -> mapper.parse(source(b -> b.field("foo.bar.baz", 0)))
                b.startObject();
        DocumentMapper mapperWithDynamic = createDocumentMapper(topMapping(b -> {
            MapperParsingException.class,
                b.endArray();
                b.startObject();
            MapperException exception = expectThrows(MapperException.class, () -> mapper.parse(source(b -> b.field("bar", "bar"))));
            assertNotNull("expected a dynamic mapping for [" + field + "]", m);
        ParsedDocument docWithTemplate = mapperWithTemplate.parse(source(b -> b.startArray("foo").value(0).value(1).endArray()));
        }));
            b.startArray("dynamic_templates");
import static org.hamcrest.Matchers.not;
            b.endArray();
    public void testDynamicFalseAllowTemplatesWithBigInteger() throws Exception {
        }
import org.opensearch.common.util.FeatureFlags;
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {}));
            b.startObject("inner").field("inner_field", "inner_value").endObject();
    public void testDisableObjectsMappingRecoveryWithPrefixConflict() throws Exception {
        Mapper bazMapper = ((ObjectMapper) barMapper).getMapper("baz");
                    }
                }
        // Test array containing null values in disable_objects mode
            mapperService.documentMapper().mappers().isMultiField("address.city")
            b.startArray("dynamic_templates");
                    }
        ParsedDocument docWithTemplate = mapperWithTemplate.parse(source(b -> b.field("float_field", "123.45")));
        assertEquals("mapping set to strict, dynamic introduction of [foo] within [_doc] is not allowed", exception.getMessage());
            """));
        assertEquals(
                {
    public void testGenerateGroupingCriteriaFromScript() throws Exception {
        merge(mapperService, dynamicMapping(doc1.dynamicMappingsUpdate()));
        assertEquals("address.city should be text", "text", mapperService.fieldType("address.city").typeName());
        ParsedDocument doc = mapper.parse(source(b -> b.startObject("foo.bar.baz").field("a", 0).endObject()));
                b.endArray();
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {
        ParsedDocument doc = mapper.parse(source(b -> {
                    b.endObject();
        assertEquals("789", fields[5].stringValue());
                b.endObject();
                b.endObject();
            MapperParsingException.class,
                }
            }
            }
                        b.field("match_mapping_type", "object");
        assertNotNull(fooMapper);
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "value")), null);
                    {
        assertEquals(4, doc.rootDoc().getFields("foo.bar.baz").length);
                b.startObject();
            b.startObject("properties");
            b.endArray();
        IndexableField[] mixedFields = doc.rootDoc().getFields("mixed_nulls");
                    b.endObject();
    // Test nesting upto max allowed depth with combination of nesting in object and array
        );
        assertThat((String) builtDocMapper.meta().get("param1"), equalTo("value1"));
        Mapper inner2_mapper = ((ObjectMapper) objMapper).getMapper("inner2");
        assertEquals(0, doc.rootDoc().getFields("foo.bar.baz").length);
        Mapper bazMapper = ((ObjectMapper) barMapper).getMapper("baz");
        // Test nested arrays
            () -> mapper.parse(source(b -> b.startObject("foo").field("", "bar").endObject()))
        StrictDynamicMappingException exception = expectThrows(
            {
            b.field("dynamic", "false_allow_templates");
    }
            b.startObject("foo");
            b.startObject("alias-field");
        assertEquals(0, doc.rootDoc().getFields("bar").length);
    }
                    }
                }
        Mapper barMapper = ((ObjectMapper) fooMapper).getMapper("bar");
                    }
        ParsedDocument doc = mapper.parse(source(b -> b.startObject("foo.bar.baz").field("a", 0).endObject()));
            b.field("test2", "value2");
        assertNull(result.docs().get(1).getField(NestedPathFieldMapper.NAME));
            "mapping set to strict_allow_templates, dynamic introduction of [foo] within [_doc] is not allowed",
        assertNotNull("Field 'simple' should exist", doc3.rootDoc().getField("simple"));
            b.endObject();
                    b.startObject("georule");
        assertNotNull(xMapper);
    public void testRootMapperNameVariations() throws Exception {
            b.startArray("dynamic_templates");
        }));
import org.apache.lucene.index.IndexableField;
        assertEquals(2, docWithTemplate.rootDoc().getFields("date_field").length);
        MapperService mapperService = createMapperService(topMapping(b -> {
                    b.endObject();
                b.endObject();
                    b.endObject();
        }
    }
            "address.city should not be a multi-field of address",
    }
        assertEquals("Product 1", nameFields[0].stringValue());
        );
                {
                    }
            strictMapper.parse(source(b -> {
                b.startObject();
    }
        }));
                {
        );
                b.startObject("tags");
        );
        ParsedDocument doc = mapper.parse(source(b -> b.startArray("foo.bar.baz").value(0).value(1).endArray()));
        DocumentMapper mapperWithTemplate = createDocumentMapper(topMapping(b -> {
                b.field("cpu.usage", 75.5);
            MapperParsingException e = expectThrows(
                {
        }));
        assertNotNull(bazMapper);
        DocumentMapper builtDocMapper = createDocumentMapper(MapperService.SINGLE_MAPPING_NAME, builtMapping);
            b.endArray();
        MapperService mapperService = createMapperService(mapping(b -> {
            {
            b.startArray("dynamic_templates");
        Mapper aMapper = ((ObjectMapper) bazMapper).getMapper("a");
                {
            b.endObject();
            assertNull(doc.rootDoc().getField("bar"));
                    {
                    b.endObject();
        assertEquals(
    public void testDisableObjectsAutomaticFlattening() throws Exception {
 *     http://www.apache.org/licenses/LICENSE-2.0
        return createDocumentMapper(topMapping(b -> {
            }).accept(b);
        assertThat(doc.rootDoc().get("type.test2"), equalTo("value2"));
    }
        // This should work because user.name has existing mapping, but user.age should still throw exception
                        {
    }
                    }
            }
            assertNull(doc.rootDoc().getField("field"));
                b.startObject("level1");
        assertNotNull(fooMapper);
        assertThat(doc.rootDoc().get("type.type_field"), equalTo("type_value"));
        assertEquals(2, doc.rootDoc().getFields("field.bar.baz.a").length);
        assertNotNull("Field 'metrics.memory.used' should exist", flatDoc.rootDoc().getField("metrics.memory.used"));
        ParsedDocument doc = mapper.parse(source(b -> b.startObject("foo").field("bar", "something").endObject()));
                        {
import java.util.Collection;
        assertThat(bazMapper, instanceOf(NumberFieldMapper.class));
            {
        // Test that dotted field names are treated as literal field names
            b.startArray("dynamic_templates");
        assertEquals(4, doc.rootDoc().getFields("foo").length);
            );
        assertEquals("mapping set to strict, dynamic introduction of [foo] within [_doc] is not allowed", exception.getMessage());
                    {
            StrictDynamicMappingException.class,
                }
            .startObject("properties")
            // The flat field "metrics.cpu.cores" should exist
    public void testDynamicDottedFieldNameLongArrayWithExistingParentWrongType() throws Exception {
        );
                    b.field("zip", "10001");
            }
            {
        }));
                    }
                b.field("name", "John");
        assertNotNull("Field 'user.name' should exist in nested structure", defaultDoc.rootDoc().getField("user.name"));
        assertThat(doc.rootDoc().get("test2"), equalTo("value2"));
        DocumentMapper mapperWithTemplate = createDocumentMapper(topMapping(b -> {
        }
            b.field("dynamic", "false_allow_templates");
        assertNotNull(((ObjectMapper) barMapper).getMapper("baz"));
        MapperService recoveredService = createMapperService(MapperService.SINGLE_MAPPING_NAME, mappingSource);
                }
                    {
        assertTrue(xMapper instanceof ObjectMapper);
                b.endObject();
            b.field("test1", "value1");
        assertEquals("long_path", doc2.rootDoc().getField("a.b.c.d.e.f.g.h.i.j").stringValue());
                b.startObject();
            b.startArray("dynamic_templates");
        assertThat(doc.getDocumentInput(), nullValue());
        ParsedDocument doc1 = mapper.parse(source(b -> { b.startArray("tags").value("tag1").value("tag2").value("tag3").endArray(); }));
                        b.startObject("mapping").field("type", "long").endObject();
        assertNotNull(doc);
            }
        // Field: "a.b.c.d.e.f" should find parent "a.b.c" with disable_objects=true
        // Test that strict dynamic mapping works correctly with disable_objects
        // Comprehensive test for root-level disable_objects functionality
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "strict")));
                        b.field("match_mapping_type", "date");
            b.startObject("metrics");
        ParsedDocument docWithTemplate = mapperWithTemplate.parse(source(b -> b.nullField("bar")));
                b.endObject();
                    b.startObject("test");
                    b.startObject("test1");
                    }
        }
        // Verify that the field was copied to the copy_to target
    public void testDynamicFalseAllowTemplatesDottedFieldNameObject() throws Exception {
        assertTrue(fooMapper instanceof ObjectMapper);
        IndexableField[] tagFields = doc1.rootDoc().getFields("tags");
                    b.endObject();
        // All array elements should be flattened to the same field name
        assertNotNull(((ObjectMapper) fooMapper).getMapper("field"));
                b.endObject();
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertNotNull(bazMapper);
        assertNotNull(update); // dynamic mapping update
                    }
        assertNotNull("Dynamic mapping update should be created", mappingUpdate);
    }
            }
                        b.field("existing", "test");
    }
                    b.endObject();
    public void testDynamicStrictAllowTemplatesObject() throws Exception {
        ParsedDocument doc2 = mapperService.documentMapper().parse(source("""
                            b.field("type", "long");
        ParsedDocument doc = mapper.parse(source(b -> b.field("bigdecimal_field", bigDecimal)));
                                                 // processFlattenedTokenForDisableObjects
            b.field("dynamic", "true");
        ParsedDocument doc = mapper.parse(source(b -> {
                MapperParsingException.class,
                b.endObject();
        // Test the root-level flattening logic in getMapper function
        }));
                b.endObject();
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
    }
        }
                b.field("path", "concrete-field");
            b.startObject("LogAttributes");
            b.startObject("a");
                    {
        ParsedDocument doc = mapper.parse(source(b -> b.field("foo", "1234")));
            b.field("dynamic", "strict");
        // 3. Look for field "deep.nested.field.name" under level3 mapper
                {
            recoveredService.fieldType("attributes.address.city").typeName()
                        b.field("match_mapping_type", "object");
        ParsedDocument docWithTemplate = mapperWithTemplate.parse(source(b -> b.field("bigint_field", bigInt)));
                {
            b.endObject();
            () -> mapper.parse(source(b -> b.startObject("alias-field.dynamic-field").field("type", "keyword").endObject()))
        StrictDynamicMappingException exception3 = expectThrows(StrictDynamicMappingException.class, () -> {
            b.field("test2", "value2");
            b.startObject("user");
        assertEquals(2, docWithTemplate.rootDoc().getFields("bar").length);
    public void testDynamicBigInteger() throws Exception {
                b.startObject("bar").field("type", "integer").endObject();
            b.field("disable_objects", true);
                        b.startObject("mapping").field("type", "object").endObject();
        assertEquals(2, doc.rootDoc().getFields("products.details.category.sub").length);
    public void testDynamicFalseLongArray() throws Exception {
            b.startArray("dynamic_date_formats").value("yyyy-MM-dd").endArray();
        }), mockInput);
                        b.startObject("mapping").field("type", "object").endObject();
        assertEquals("mapping set to strict, dynamic introduction of [bar] within [_doc] is not allowed", exception.getMessage());
            b.startArray("dynamic_templates");
            doc2.rootDoc().getField("level1.level2.level3.deep.nested.field.name")
        }));
            ParsedDocument doc = mapper.parse(
                {
                b.field("price", 999);
                }
        assertThat(doc.rootDoc().get("inner.inner_field"), equalTo("inner_value"));
        IndexableField[] copy1Fields = doc.rootDoc().getFields("location_copy1");
                    b.startObject("test");
        assertNotNull(mapping);
                    {
        assertEquals(0, doc.rootDoc().getFields("foo").length);
                        b.startObject("properties");
                        b.field("match_mapping_type", "object");
                b.endArray();
                        b.field("type", "object");
                    b.field("type", "object");
        Mapping mapping = DocumentParser.createDynamicUpdate(docMapper.mapping(), docMapper, updates);
                b.startObject();
                    b.startObject("details");
        // Nested document:
                    b.endObject();
        assertEquals("address should be text in reverse order", "text", ms2.fieldType("attributes.address").typeName());
            b.field("test1", "value1");
        IndexSettings settings = new IndexSettings(build, Settings.EMPTY);
            {
                        b.endObject();
    public void testDisableObjectsWithStrictDynamicMapping() throws Exception {
        assertNotNull(copy2Fields);
            b.startArray("dynamic_templates");
    public void testGetMapperFlatteningLogic() throws Exception {
        }));
            b.startArray("dynamic_templates");
                {
            b.endArray();
import org.opensearch.cluster.metadata.IndexMetadata;
                    b.endObject();
        assertNotNull("Field 'a.b.c' should exist", doc5.rootDoc().getField("a.b.c"));
            () -> documentMapperWithDynamicTemplates.parse(source(b -> b.startArray("foo").value(0).value(1).endArray()))
        })).dynamicMappingsUpdate()));
            {
        StrictDynamicMappingException exception = expectThrows(StrictDynamicMappingException.class, () -> {
                .endObject()
                        b.field("match_mapping_type", "double");
                {
        }
                }
                b.endObject();
    public void testObjectMappingUpdate() throws Exception {
            {
                    b.field("type", "object");
        ParsedDocument doc = mapper.parse(source(b -> b.startArray("foo").value(0).value(1).endArray()));
            b.endObject();
                    b.startArray("foo.");
        ParsedDocument docA = ms2.documentMapper().parse(source("""
        );
        assertThat(doc.rootDoc().get("inner1.inner2.inner3.inner3_field1"), equalTo("inner3_value1"));
            {
            b.startObject("metrics");
        assertNotNull("Field 'products.id' should exist", doc.rootDoc().getField("products.id"));
        // Verify no intermediate ObjectMapper "metrics" or "metrics.cpu" was created
                {
                b.field("test2", "value2");
                    b.field("type", "object");
            {
        assertEquals("mapping set to strict, dynamic introduction of [foo] within [_doc] is not allowed", exception.getMessage());
            }
                    b.field("value", 100);
                    b.startObject("test");
                .endObject()
        assertEquals(4, docWithTemplate.rootDoc().getFields("foo").length);
        assertNotNull(doc.dynamicMappingsUpdate());
            () -> documentMapperWithDynamicTemplates.parse(source(b -> b.field("foo.bar.baz", 0)))
        assertNotNull(textMapper);
                    b.startObject("georule");
                    b.field("name", "item1");
        ));
                    // All nested structures will be flattened during document parsing
    DocumentMapper createDummyMapping() throws Exception {
                    b.startObject("details");
        // The getMapper function should flatten the entire path into a single field name
            () -> mapper.parse(source(b -> b.field("text-field", "value")))
        assertTrue(copy1Fields.length > 0);
            e.getCause().getMessage(),
                        b.endObject();
            """));
        assertThat(barMapper, instanceOf(ObjectMapper.class));
        Mapper bazMapper = ((ObjectMapper) barMapper).getMapper("baz");
        IndexableField[] categoryFields = doc.rootDoc().getFields("items.item.category.name");
    public void testSimpleParser() throws Exception {
        // in the existing mapper lookup loop
            }
                            b.endObject();
    public void testMappedLongArray() throws Exception {
        }));
            for (int i = 1; i < depth_limit - 1; i++) {
        assertThat(bazMapper, instanceOf(ObjectMapper.class));
        assertNotNull(fooMapper);
        }
        {
            }
                        b.startObject("mapping").field("type", "object").endObject();
        String builtMapping = mapperService.documentMapper().mappingSource().string();
        })).rootDoc();
            }
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "object")));
                }
        }));
        assertEquals(2, docWithTemplate.rootDoc().getFields("bigint_field").length);
            {"attributes": {"address.city": "Austin", "address.state": "Texas"}}
                }
            """));
     */
            b.endObject();
                b.field("baz", 789);
                    }
        Mapper xMapper = mapping.root().getMapper("x");
            b.startObject("properties");
        }));
            b.startArray("top.");
    public void testDynamicDottedFieldNameLongWithParentTemplate() throws Exception {
        merge(mapperService, dynamicMapping(doc2.dynamicMappingsUpdate()));
        assertThat(doc.rootDoc().get("type.test1"), equalTo("value1"));
            b.field("dynamic", true);
                b.startObject();
    public void testDynamicLongArray() throws Exception {
            b.endArray();
        ));
            for (int i = 1; i < depth_limit; i++) {
        );
                b.value("value1");
                .endObject()
                        b.field("path_match", "foo.bar.baz");
            b.startObject("foo").field("type", "long").endObject();
                                b.startObject("bar").field("type", "keyword").endObject();
    public void testDynamicLongArrayWithTemplate() throws Exception {
            }));
            }
                    b.startObject("nested");
                                {
            b.endObject();
                b.endObject();
                        b.startObject("mapping").field("type", "keyword").endObject();
            {
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "long")));
        );
                b.startObject("inner").field("inner_field", "inner_value").endObject();
                    b.endObject();
        }));
                        b.field("match_mapping_type", "object");
            }
        assertNotNull(fooMapper);
                b.endObject();
 * KIND, either express or implied.  See the License for the
                        b.field("match", "test1");
                    {
            StrictDynamicMappingException.class,
        assertNotNull(((ObjectMapper) xMapper).getMapper("a"));
    }
            b.startArray("dynamic_templates");
        assertNull(doc.dynamicMappingsUpdate()); // no update since we reused the existing type
        ParsedDocument doc = mapper.parse(source(b -> b.startObject("foo").field("bar", "baz").endObject()));
                }
        ParsedDocument doc1 = mapper.parse(source(b -> {
        assertNotNull(doc);
    }
                    b.startObject("coordinates");
        assertEquals("value2", result.docs().get(1).getField("baz").binaryValue().utf8ToString());
    public void testSimpleParserNoTypeNoId() throws Exception {
        ParsedDocument doc2 = mapperService.documentMapper().parse(source("""
            b.startObject("level1");
        assertTrue("Should have item.id fields", itemIdFields.length > 0);
        }));
        assertEquals(0, doc.rootDoc().getFields("foo.bar.baz").length);
    }
    }
        }));
        }));
                }
                    b.startObject("properties").endObject();
 * specific language governing permissions and limitations
/*
        assertThat(bazMapper, instanceOf(NumberFieldMapper.class));
            "address.state should be text after round-trip",
        }
                    b.startObject("inner3");
                }
            {
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {}));
            mapperService.fieldType("attributes.address.city").typeName()
            {
                    b.startObject("inner").field("type", "keyword").endObject();
        assertNotNull(doc.dynamicMappingsUpdate());
    }
            for (int i = 1; i <= depth_limit; i++) {
    public void testDynamicStrictNull() throws Exception {
    public void testGeoPointArrayWithMultipleCopyTo() throws Exception {
        ParsedDocument docWithTemplate = mapperWithTemplate.parse(source(b -> b.field("bigdecimal_field", bigDecimal)));
                }
            b.endArray();
        ParsedDocument doc = mapper.parse(source(b -> b.startArray("foo.bar.baz").value(0).value(1).endArray()));
        assertEquals(0, doc.rootDoc().getFields("foo.bar.baz.a").length);
            "Field 'level1.level2.level3.very.long.dotted.field.path' should exist",
        ParsedDocument doc3 = mapper.parse(source(b -> {
            {
                b.field("type", "integer");
            b.field("disable_objects", true);
            () -> mapper.parse(source(b -> { b.startObject("..").field("foo", 2).endObject(); }))
                source(b -> b.field(MockMetadataMapperPlugin.MockMetadataMapper.CONTENT_TYPE, "mock-metadata-field-value"))
            b.endObject();
        updates.add(new MockFieldMapper("foo.bar.baz"));
        // Should throw exception when trying to add new field with strict mapping
                b.endObject();
        assertNotNull(aMapper);
                    {
        );
                b.field("first", "fred");
                    b.field("city", "NYC");
        assertNull("No intermediate objects should exist", flatDoc.rootDoc().getField("metrics.cpu"));
                b.startObject();
                b.startObject();
            mapperService.fieldType("attributes.address.state").typeName()
        assertThat(doc.getDocumentInput(), sameInstance(mockInput));
        // This tests the recursive array handling in processFlattenedTokenForDisableObjects
                        b.startObject("mapping").field("type", "boolean").endObject();
        // Should be flattened to outer.inner.test
        assertNotNull("Field 'metrics.cpu.usage' should exist", flatDoc.rootDoc().getField("metrics.cpu.usage"));
            b.endObject();
            assertNotNull("FieldMapper 'metrics.cpu.cores' should exist as flat field", coresMapper);
        assertEquals(30, doc.rootDoc().getField("user.age").numericValue().intValue());
        }
                }
                    {
        Mapper barMapper = ((ObjectMapper) fooMapper).getMapper("bar");
                {
        );
            b.startObject("properties");
        assertNull("Null field 'product.description' should not be created", doc.rootDoc().getField("product.description"));
            b.startArray().value(0).value(0).endArray();
        assertNotNull(xMapper);
                    {
            b.field("disable_objects", true);
        {
    }
        ParsedDocument parsedDoc = mapperWithDynamic.parse(source(b -> {
                    }
        );
public class DocumentParserTests extends MapperServiceTestCase {
        }));
        merge(mapperService, dynamicMapping(doc2.dynamicMappingsUpdate()));
            }
        assertNotNull("Field 'outer.inner.test' should exist", doc1.rootDoc().getField("outer.inner.test"));
            }
            {
    public void testDynamicDottedFieldNameObject() throws Exception {
            StrictDynamicMappingException.class,
        );
            b.endArray();
        String mappingSource = mapperService.documentMapper().mappingSource().string();
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {}));
                b.startObject("inner").field("inner_field", "inner_value").endObject();
        assertNotNull("Field 'products.details.category.sub' should exist", doc.rootDoc().getField("products.details.category.sub"));
                b.startObject("user.name");
                b.startObject();
            b.field("dynamic", false);
                        b.field("match", "bigint_*");
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
                b.startObject();
        ParsedDocument doc3 = mapper.parse(source(b -> { b.field("a.b.c.single", "value2"); }));
        ParsedDocument doc = defaultMapper.parse(source(b -> {
                    }
        assertThat(e.getMessage(), equalTo("failed to parse, document is empty"));
        ParsedDocument doc4 = mapper.parse(source(b -> { b.field("a.b.c.very.deep.nested.field.with.many.levels", "deepvalue"); }));
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "false_allow_templates")));
        assertEquals(4, doc.rootDoc().getFields("field.bar.baz").length);
            {
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> mapper.parse(source(b -> {
                b.startArray("foo" + 1);
                }
    public void testSimpleMapper() throws Exception {
        ParsedDocument doc = mapper.parse(source(b -> b.field("foo.bar.baz", 0)));
    public void testDisableObjectsFieldTypeLookupWithPrefixConflict() throws Exception {
                b.startObject();
import org.opensearch.common.xcontent.XContentFactory;
    }
                    b.startObject("test");
 *
        assertNotNull(mapping);
                        b.field("match_mapping_type", "long");
        assertThat(doc.rootDoc().get("test2"), equalTo("value2"));
        Mapper bazMapper = ((ObjectMapper) barMapper).getMapper("baz");
                }
            b.startArray("dynamic_templates");
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {}));
    }
        DocumentMapper docMapper = createDocumentMapper(MapperService.SINGLE_MAPPING_NAME, mapping);
        Mapper bazMapper = ((ObjectMapper) barMapper).getMapper("baz");
        DocumentInput<?> noopInput = new CapturingDocumentInput();
            b.startObject("alias-field");
                        b.startObject("mapping").field("type", "object").endObject();
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
                b.startObject();
        exception = expectThrows(
    }
        assertEquals(2, doc.rootDoc().getFields("field.bar.baz").length);
                    }
        assertEquals("mapping set to strict, dynamic introduction of [foo] within [_doc] is not allowed", exception.getMessage());
            b.field("dynamic", "true");
        Mapper bazMapper = ((ObjectMapper) barMapper).getMapper("baz");
                b.startObject("metrics");
        IndexableField[] nameFields = doc.rootDoc().getFields("products.details.name");
        // Verify the non-null values
                b.endObject();
                    }
            }
        }));
    }
                {
        // Test to ensure both empty and "_doc" root mapper names are handled correctly
                }
            b.startArray("dynamic_templates");
        ParsedDocument doc1 = mapperService.documentMapper().parse(source("""
    }
    }
                    b.field("dynamic", true);
        );
            exception.getMessage()
        assertThat(doc.rootDoc().get("type.type"), equalTo("value_type"));
                b.startObject();
        assertEquals(2, fields.length);
        ParsedDocument docWithTemplate = mapperWithTemplate.parse(source(b -> b.field("foo.bar.baz", 0)));
            }
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "strict")));
            {
        // With pluggable data format, text field should NOT have .keyword multi-field
    public void testDynamicFalseAllowTemplatesWithCopyTo() throws Exception {
            assertNull(doc.rootDoc().getField("field"));
                {
            b.startArray("dynamic_templates");
                            .field("sub-field", "true")
            }
import java.math.BigDecimal;
            b.field("dynamic", "strict_allow_templates");
        // Test 1: Simple array with existing field mapping
                b.startObject("foo");
            {
                b.startObject();
                    b.endObject();
        }
        // Root document:
    }
        assertTrue("Text field should have keyword multi-field without pluggable dataformat", textMapper.iterator().hasNext());
        assertNotNull("Field 'products.details.name' should exist", doc.rootDoc().getField("products.details.name"));
                            b.field("sub", "phones");
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {
                    }
                    }
    public void testParseNonDynamicArrayNestedArraysWithDisableObjects() throws Exception {
                b.startObject("user");
            .numberOfReplicas(0)
            }
            mapperService.documentMapperParser(),
    }
        assertEquals("another_value", doc3.rootDoc().getField("level1.level2.level3.very.long.dotted.field.path").stringValue());
                        b.field("match", "test");
        ParsedDocument doc = mapper.parse(source(b -> b.startObject("foo").field("bar", "something").endObject()));
            b.startObject("type");
    }
        assertEquals(2, docWithTemplate.rootDoc().getFields("bool_field").length);
    /**
        // Test the getMapper flattening logic: when looking up "level1.level2.level3.deep.nested.field.name"
                            b.field("doc_values", false);
                    b.endObject();
            .startObject("foo")
            {"address": "US"}
                {
            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
        assertNotNull(inner3_mapper);
            }
                {
            b.startObject("bar").field("type", "integer").endObject();
 * Unless required by applicable law or agreed to in writing,
                }
            b.field("dynamic", "false_allow_templates");
        assertEquals("123", fields[1].stringValue());
        }));
    }
            b.field("dynamic", "strict");
        Mapper barMapper = ((ObjectMapper) fooMapper).getMapper("bar");
                        }
            b.field("dynamic", "false_allow_templates");
        assertEquals(2, doc.rootDoc().getFields("foo.bar.baz").length);
    public void testDisableObjectsRootArrayWithDottedFieldNameNoIntermediateObjectMapper() throws Exception {
                    b.endObject();
                    b.startArray("cores");
            noopInput
            b.endObject();
            assertTrue("'metrics.cpu.cores' should be a FieldMapper", coresMapper instanceof FieldMapper);
        // Test 2: Only null field in flattened array with strict dynamic mapping should throw exception
            }
        StrictDynamicMappingException exception = expectThrows(
        Mapping mapping = DocumentParser.createDynamicUpdate(docMapper.mapping(), docMapper, updates);
        ParsedDocument doc = defaultMapper.parse(source(b -> {
        assertEquals(
        ParsedDocument doc = mapper.parse(source(b -> b.nullField("bar")));
        String[] nameParts = name.split("\\.");
        })));
        assertThat(barMapper, instanceOf(ObjectMapper.class));
                }
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "false_allow_templates")));
            }
        ParsedDocument doc = mapper.parse(source(b -> b.field("big-integer", value)));
                        b.endObject();
        Mapper subxMapper = ((ObjectMapper) xMapper).getMapper("subx");
        assertThat(exception.getMessage(), containsString("strict"));
                {
            b.field("status_code", "300");
            "mapping set to strict_allow_templates, dynamic introduction of [foo] within [_doc] is not allowed",
            b.startArray("dynamic_templates");
                    {
        assertNotNull(copiedFields);
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "false")));
                {
                        {
            {
        assertEquals("Should have 2 values for the array", 2, paymentFields.length);
                        b.field("match", "foo*");
                b.startArray().value(1).value(1).endArray();
                        b.field("simple.field", "test1");
        long depth_limit = MapperService.INDEX_MAPPING_DEPTH_LIMIT_SETTING.getDefault(Settings.EMPTY);
            b.field("disable_objects", true);
                    {
            StrictDynamicMappingException.class,
                    // Note: No nested object mappers defined when disable_objects=true
        ParsedDocument doc = defaultMapper.parse(source(b -> {
            {
                    )
            b.startArray("mixed_nulls");
            }
                        b.field("match", "test*");
        Mapper fooMapper = doc.dynamicMappingsUpdate().root().getMapper("foo");
            exception.getMessage()
        }));
                    {
        DocumentMapper defaultMapper = createDocumentMapper(mapping(b -> {}));
                    {
        DocumentMapper docMapper = createDocumentMapper(mapping(b -> {}));
                {
        // Regression test: When a nested object contains an array value under disable_objects,
        }));
                    {
        assertEquals(
            }
                }
            b.field("disable_objects", true);
        IndexableField[] copiedFields = doc.rootDoc().getFields("location_copy");
                        b.field("match", "target_*");
                    b.endObject();
                            }
                            b.field("type", "geo_point");
        DocumentMapper mapperWithTemplate = createDocumentMapper(topMapping(b -> {
                        b.startObject("mapping").field("type", "object").endObject();
        DocumentMapper mapperWithTemplate = createDocumentMapper(topMapping(b -> {
            b.startObject("type");
            exception.getMessage()
        }));
            b.startObject("properties");
                }
        })));
    }
                    }
            b.endArray();
            b.endObject();
        updates.add(new MockFieldMapper("foo.field"));
                }
        assertEquals(4, doc3.rootDoc().getFields("mixed_array.value").length); // 2 values * 2 fields each
        }));
        DocumentMapper documentMapperWithDynamicTemplates = createDocumentMapper(topMapping(b -> {
        }));
            context.path().add(nameParts[i]);
    }
        // Test edge case where field path exactly matches the disable_objects parent
        assertEquals("dynamic_text.keyword", keywordSubField.name());
        assertNotNull("Field 'mixed_nulls' should exist", doc.rootDoc().getField("mixed_nulls"));
                        b.field("match", "foo");
                b.endObject();
                        b.field("match_mapping_type", "object");
            b.field("bar", 10);
    }
                            b.endObject();
            b.startObject("outer");
        assertEquals(1, doc.rootDoc().getFields("source_field").length);
            {
        }));
            b.field("test2", "value2");
            }
import java.util.Collections;
        ParsedDocument doc = mapper.parse(source(b -> b.field("embedded_field", "value")));
                }
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "value")), mockInput);
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
            b.field("dynamic", "false_allow_templates");
        assertEquals(0, doc.rootDoc().getFields("numeric_field").length);
                {
            b.startArray("dynamic_templates");
                {
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {}));
        MapperParsingException e = expectThrows(
            for (int i = 1; i <= depth_limit; i++) {
        MapperService ms2 = createMapperService(topMapping(b -> {
            {
            properties(x -> {
                {
                    }
            b.startObject("inner").field("inner_field", "inner_value").endObject();
                b.field("name", "Jane Doe");
                        b.field("match_mapping_type", "double");
            b.endArray();
        assertNotNull("doc2 should produce dynamic mapping update", doc2.dynamicMappingsUpdate());
            }
        }));
        );
        }));
    }
        StrictDynamicMappingException exception = expectThrows(
                    b.endObject();
                    b.startObject("properties");
                b.startArray("foo" + 1);
                {
            }
        // Dynamic mapping update expected since "address.city" and "address.state" are not pre-defined
    public void testTypeLevelWithFieldTypeAsObjectNotFirst() throws Exception {
        assertEquals(Uid.encodeId("1"), result.docs().get(0).getField(IdFieldMapper.NAME).binaryValue());
            .startObject()
                b.startObject("inner").field("inner_field", "inner_value").endObject();
        CapturingDocumentInput mockInput = new CapturingDocumentInput();
        assertThat(barMapper, instanceOf(ObjectMapper.class));
            "text",
import static java.util.Collections.singletonList;
    public void testDynamicStrictDottedFieldNameLong() throws Exception {
            b.field("foo.bar.baz", 123);
import static org.hamcrest.Matchers.notNullValue;
        assertThat(doc.rootDoc().get("test1"), equalTo("value1"));
        BigDecimal value = BigDecimal.valueOf(Double.MAX_VALUE).add(BigDecimal.valueOf(10.1));
        // Dynamically add "address"
            {"attributes": {"address.city": "Austin"}}
        assertThat(doc.rootDoc().get("type.inner.inner_field"), equalTo("inner_value"));
        return createMapperService(mapping(b -> {
                }
        })));
        ParsedDocument doc = mapper.parse(source(b -> b.field("date_field", "2023-12-25")));
    }
        assertNotNull(mapping);
                                b.startObject("level3");
                    b.startObject("test1");
        ParsedDocument doc = mapper.parse(source(b -> b.field("dynamic_text", "hello world")));
            b.startObject("attributes").field("type", "object").field("dynamic", true).field("disable_objects", true).endObject();
                    b.field("type", "object");
            {
                            {
        assertNull(mapperService.fieldType("attributes.address.address.city"));
    }
            MapperParsingException.class,
    public void testDynamicFalseObject() throws Exception {
        // Test the specific flattening logic in getMapper function
                b.startObject("LogAttributes");
        assertNotNull(fooMapper);
            b.startObject("foo.bar");
                    b.startObject("inner3");
                b.field("source_field", "test value");
            b.field("dynamic", "true");
            }
        // Even though we matched the dynamic format, we do not match on numbers,
            b.endObject();
        }));
                b.endObject();
        );
                b.endObject();
    }
            b.field("user.age", 30);
            b.endObject();
        Mapper inner3_mapper = ((ObjectMapper) inner2_mapper).getMapper("inner3");
            b.startObject("properties");
                    }
        assertThat(aMapper, instanceOf(NumberFieldMapper.class));
        }));
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {
                    }
        ParsedDocument doc = mapper.parse(source(b -> {
        ParsedDocument result = mapper.parse(source(b -> {
            }));
                        b.startObject("mapping").field("type", "keyword").endObject();
                            b.field("type", "object");
                b.startObject("metrics");
                    b.field("disable_objects", true);
        assertNotNull(barMapper);
    }
        assertNotNull(mapping);
        assertNotNull("Field 'mixed_array.name' should exist", doc3.rootDoc().getField("mixed_array.name"));
                    {
        assertThat(barMapper, instanceOf(ObjectMapper.class));
            }
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> mapper.parse(source(b -> {
    public void testDynamicStrictDottedFieldNameLongArray() throws Exception {
                b.endObject();
        }));
        assertThat(exception2.getMessage(), containsString("items.category"));
 * The OpenSearch Contributors require contributions made to
            b.endObject();
                        b.field("store", "true");
        // Test 2: Array with numeric values
    }
    }
        ParsedDocument doc = mapper.parse(source(b -> {
        assertThat(doc.getBinaryValue(docMapper.idFieldMapper().name()), equalTo(Uid.encodeId("1")));
            b.startObject("type");
                                    b.field("disable_objects", true);
            }
    }
        StrictDynamicMappingException exception = expectThrows(
    public void testNestedHaveIdAndTypeFields() throws Exception {
            b.endObject();
                {
            for (int i = 1; i < depth_limit - 1; i++) {
                    {
        List<Mapper> updates = new ArrayList<>();
            {
            }
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            StrictDynamicMappingException.class,
        IndexableField[] itemIdFields = doc.rootDoc().getFields("items.item.id");
        }));
    }
    public void testParseDocumentWithNullDocumentInput() throws Exception {
                    b.startObject("float_template");
            {
            b.startObject("metrics");
            b.endArray();
        assertNotNull("Field 'products.details.category.main' should exist", doc.rootDoc().getField("products.details.category.main"));
        );
            }
    }
        // Non-null values should be stored
        assertNotNull(bazMapper);
            }
                b.field("type", "geo_point");
                        b.field("path_match", "foo.bar.baz");
                }
        assertNotNull("Field 'level1.level2.level3' should exist", doc4.rootDoc().getField("level1.level2.level3"));
        // check parsing success for nested array within allowed depth limit
        ParsedDocument doc = mapper.parse(source(b -> {
                b.startObject();
        }));
            {
                        b.field("match_mapping_type", "object");
            }
                        b.startObject("category");
    public void testDynamicStrictAllowTemplatesDottedFieldNameObject() throws Exception {
                    }
                b.startObject();
            b.startArray("nested_arrays");
                        b.field("price", 149.99);
                    }
        assertEquals("NYC", doc.rootDoc().getField("user.address.city").stringValue());
            }
                        b.field("match", "foo*");
        }));
        ParsedDocument doc = mapper.parse(source(b -> b.field("foo.bar.baz", 0)));
            b.endObject();
        exception = expectThrows(
        ParsedDocument doc = mapper.parse(source(b -> b.field("field.bar.baz", 0)));
                        b.startObject("mapping").field("type", "long").endObject();
                {
    }
        })));
        DocumentMapper docMapper = createDocumentMapper(MapperService.SINGLE_MAPPING_NAME, mapping);
            }
                        b.endObject();
        Mapper barMapper = ((ObjectMapper) fooMapper).getMapper("bar");
            {
        }));
        assertThat(doc.rootDoc().get("test1"), equalTo("value1"));
            StrictDynamicMappingException.class,
        });
        ParsedDocument doc = mapper.parse(source(b -> b.field("foo", "2016 12")));
                        b.field("match", "test");
            }
        // which are too likely to be false positives
                    b.field("type", "float");
                        b.endObject();
        );
            }));
            b.startObject("outer");
                        b.field("name", "Product 1");
        assertEquals("address should be text after round-trip", "text", recoveredService.fieldType("attributes.address").typeName());
            b.endObject();
    public void testDocumentContainsDeepNestedFieldParsingFail() throws Exception {
            .build();
        assertNull(((ObjectMapper) xMapper).getMapper("subx"));
                b.startObject("address");
                            b.startObject("subsubx").field("type", "object").endObject();
        assertThat(doc.rootDoc().get("type.test1"), equalTo("value1"));
        assertNotNull("docA should produce dynamic mapping update", docA.dynamicMappingsUpdate());
        assertEquals(2, doc.rootDoc().getFields("foo.bar.baz.a").length);
        );
                b.startObject("properties");
        Mapper barMapper = ((ObjectMapper) fooMapper).getMapper("bar");
        return singletonList(new MockMetadataMapperPlugin());
        for (String field : new String[] { "dyn_long", "dyn_double", "dyn_date", "dyn_bool" }) {
        assertTrue(copiedFields.length > 0);
        assertEquals("tag3", tagFields[2].stringValue());
            }
                b.field("type", "alias");
            b.startObject("inner1");
            b.endObject();
    public void testDeepSubfieldAfterSubfieldMappingUpdate() throws Exception {
                    b.startObject("big-integer-to-keyword");
        assertThat(doc.rootDoc().get("type.test2"), equalTo("value2"));
        );
                        b.field("match_mapping_type", "boolean");
        Mapper.Builder<?> builder = new ObjectMapper.Builder<>(nameParts[nameParts.length - 1]).enabled(true);
    }
        assertNotNull(fooMapper);
        ParsedDocument doc = mapper.parse(source(b -> b.startObject("foo.bar.baz").field("a", 0).endObject()));
    public void testDynamicFalseDottedFieldNameLong() throws Exception {
                b.startObject();
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("enabled", false)));
                b.startObject("user");
            mapperService.documentMapper(),
                {
        assertThat(fooMapper, instanceOf(ObjectMapper.class));
                b.startObject();
            b.startArray("dynamic_templates");
                    b.endArray();
            {
            b.startArray("products");
                        b.startObject("mapping").field("type", "object").endObject();
            b.endObject();
        assertEquals(new BytesRef(value.toString()), fields[0].binaryValue());
        Mapper keywordSubField = textMapper.iterator().next();
        ParsedDocument doc = mapper.parse(source(b -> b.startArray("foo").value(0).value(1).endArray()));
        e = expectThrows(MapperParsingException.class, () -> mapper.parse(source(b -> b.field(".", "1234"))));
            ParsedDocument doc = mapper.parse(source(b -> b.field("field.bar", 111)));
                        }
                b.field("test1", "value1");
                b.startObject();
        assertThat(doc.rootDoc().get("type.type"), equalTo("type_value"));
        DocumentMapper documentMapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "strict_allow_templates")));
        String[] expectedValues = { "a1", "a2", "b1", "b2", "c1", "c2" };
        }));
            b.field("dynamic", "false_allow_templates");
            }
                    b.endObject();
            // NOT an ObjectMapper for "app"
        assertNotNull(doc.dynamicMappingsUpdate());
                            b.field("sub", "tablets");
            b.startObject("concrete-field").field("type", "keyword").endObject();
    }
                b.field("test2", "value2");
                        }
        );
            exception.getMessage()
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
                b.field("type", "type_value");
                    b.endArray();
                                    // level3 has disable_objects=true, so any deeper paths should be flattened
        assertEquals(
            {
import java.util.ArrayList;
        }));
            }
                    b.field("item.category.name", "books");
                    {
            b.field("foo", "1234");
            recoveredService.fieldType("attributes.address.state").typeName()
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> { b.field("type", "nested"); }));
            b.endObject();
                        b.field("match_mapping_type", "object");
                }
                b.startObject("user");
    public void testParseNonDynamicArrayWithComplexObjectsDisableObjects() throws Exception {
        ParsedDocument doc = mapper.parse(source(b -> {
        // Both fields should be properly mapped using existing field mappers
            b.field("dynamic", "true");
                .field("type", "keyword")
        }));
                b.endObject();
                // There SHOULD be a "app.payment" FieldMapper child
                    }
                b.startObject();
        }));
    public void testDynamicStrictObject() throws Exception {
        ParsedDocument doc = mapper.parse(source(b -> b.startObject("foo.bar.baz").field("a", 0).endObject()));
        // Null field should not be created
                b.endObject();
                    b.endObject();
                    b.endObject();
            .put("index.pluggable.dataformat.enabled", true)
                    b.startObject("c");
        ParsedDocument docB = ms2.documentMapper().parse(source("""
        );
                b.startObject();
        assertEquals(456, fields[2].numericValue());
            }
        }));
            "Field 'level1.level2.level3.deep.nested.field.name' should exist",
        // Test with very deep nesting to exercise the path reconstruction loop
        Document doc = docMapper.parse(new SourceToParse("test", "1", json, MediaTypeRegistry.JSON)).rootDoc();
                        b.endObject();
        ParsedDocument doc = mapper.parse(source(b -> {
                        b.field("match", "bool_*");
        assertEquals(2, result.docs().size());
    }
                        b.field("match_mapping_type", "object");
        }));
        assertThat(bazMapper, instanceOf(NumberFieldMapper.class));
    }
        DocumentMapper mapperWithTemplate = createDocumentMapper(topMapping(b -> {
                    }
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
                b.field("test1", "value1");
            b.endObject();
        assertNotNull(doc.dynamicMappingsUpdate());
                    b.field("item.id", "item2");
                        b.field("match", "bar");
            }
                b.startObject("inner").field("inner_field", "inner_value").endObject();
            b.field("dynamic", "true");
            b.endObject();
                b.startObject();
                    b.endObject();
                }
        // Verify the simple case works
            StrictDynamicMappingException.class,
                }
        Mapping dynamicUpdate = doc.dynamicMappingsUpdate();
                    b.endObject();
    }
        assertNull(doc.rootDoc().getField("foo.bar"));
            "text",
            b.field("disable_objects", true);
            {
            b.endObject();
                b.endObject();
            () -> documentMapperWithDynamicTemplates.parse(source(b -> b.startObject("foo.bar.baz").field("a", 0).endObject()))
            }
            b.startObject("location_copy1").field("type", "geo_point").endObject();
            null
        ParsedDocument doc = defaultMapper.parse(source(b -> {
                    b.value(4);
        assertTrue(barMapper instanceof ObjectMapper);
            for (int i = 1; i <= depth_limit; i++) {
                        b.startObject("mapping").field("type", "keyword").endObject();
            b.startArray("bar");
    }
            {
                b.endObject();
        assertThat(doc.rootDoc().get("type.inner.inner_field"), equalTo("inner_value"));
}
    public void testDotsWithExistingMapper() throws Exception {
                            b.endObject();
                b.field("disable_objects", true);
            b.endObject();
            b.field("test1", "value1");
    }
        assertTrue(subxMapper instanceof ObjectMapper);
                b.array("copy_to", "location_copy1", "location_copy2");
        assertEquals("laptop", doc.rootDoc().getField("product.name").stringValue());
                    }
import org.opensearch.core.common.bytes.BytesArray;
                    }
        ParsedDocument doc = mapper.parse(source(b -> b.field("foo", "2016")));
        );
                        }
        // the getMapper function should:
        assertNotNull("Dynamic field 'metrics.cpu' should exist as flat field", doc2.rootDoc().getField("metrics.cpu"));
                    b.startObject("bigint_template");
        }));
                b.field("test2", "value2");
    }
        ParsedDocument doc = mapperService.documentMapper().parse(source(b -> {
                () -> mapper.parse(
            b.startObject("name");
    public void testPropagateDynamicWithDynamicMapper() throws Exception {
        Mapper fooMapper = doc.dynamicMappingsUpdate().root().getMapper("foo");
    }
        // Verify we have the correct number of instances (2 products)
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
    public void testSubfieldMappingUpdate() throws Exception {
        // This covers the StringBuilder flatFieldName code that flattens remaining path segments
            "address.state should be text after prefix conflict",
                    b.startArray("payment");
                b.startObject("inner").field("inner_field", "inner_value").endObject();
                b.field("type", "object");
        assertEquals("value1", result.docs().get(0).getField("foo.bar").binaryValue().utf8ToString());
        BytesReference json = new BytesArray("".getBytes(StandardCharsets.UTF_8));
            assertFalse(
        assertThat(fooMapper, instanceOf(ObjectMapper.class));
                    {
                b.field("type", "object");
    }
    }
        assertEquals(4, docWithTemplate.rootDoc().getFields("foo.bar.baz").length);
        MapperParsingException exception = expectThrows(
                {
                            }
    public void testDynamicFalseAllowTemplatesWithNestedCopyTo() throws Exception {
                    b.endObject();
    }
            .endObject()
            Mapper m = doc.dynamicMappingsUpdate().root().getMapper(field);
        assertEquals("address should be text", "text", mapperService.fieldType("attributes.address").typeName());
        Mapper fooMapper = doc.dynamicMappingsUpdate().root().getMapper("foo");
            b.field("dynamic", "false_allow_templates");
            b.startArray("dynamic_templates");
                b.endObject();
                        {
            exception.getMessage()
        DocumentMapper docMapper = mapperService.documentMapper();
            {
        }));
                {
            () -> docMapper.parse(new SourceToParse("test", "1", json, MediaTypeRegistry.JSON))
        assertNull(doc.dynamicMappingsUpdate()); // no update!
        assertEquals(0, doc.rootDoc().getFields("bar").length);
        ParsedDocument doc = mapper.parse(source(b -> b.nullField("foo")));
        Mapper xMapper = mapping.root().getMapper("x");
                    b.endObject();
        assertEquals("Should have 8 fields (4 values * 2 fields each for numeric)", 8, coreFields.length);
        );
                    {
        ParsedDocument doc = mapper.parse(source(b -> b.field("dynamic_field", "value")), mockInput);
                b.startObject("level2");
                    source(
                {
        // Test array with null values mixed with regular values
                            b.startObject("properties");
                }
                b.startObject("properties");
        assertThat(e.getCause().getMessage(), containsString("field name cannot contain only the character [.]"));
        ParsedDocument doc = mapper.parse(source(b -> {
            }
    }
                    }
            for (int i = 1; i < depth_limit - 1; i++) {
                b.field("test2", "value2");
                    b.startObject("test");
        assertNotNull(bazMapper);
            "Could not dynamically add mapping for field [field.bar.baz]. "
    }
            b.endObject();
            b.startObject("location_copy2").field("type", "geo_point").endObject();
            b.field("disable_objects", true);
            b.field("doc_values", false);
        assertEquals(0, doc.rootDoc().getFields("bar").length);
            Mapper coresMapper = dynamicUpdate.root().getMapper("metrics.cpu.cores");
            {
        // Test the specific array flattening logic in parseNonDynamicArray when disable_objects=true
                        b.startObject("mapping").field("type", "long").endObject();
        BigInteger value = BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.ONE);
        assertEquals("visa", paymentFields[0].stringValue());
                {
            b.field("type", "nested");
        // Test 3: Array with mixed content (objects within arrays)
            b.endObject();
        assertThat(doc.getDocumentInput(), nullValue());
        });
        assertEquals(0, doc.rootDoc().getFields("foo").length);
 * this work for additional information regarding copyright
        assertEquals(2, docWithTemplate.rootDoc().getFields("embedded_field").length);
            b.startObject("inner1");
        assertNotNull(doc.rootDoc().getField("bar"));
        assertEquals(Uid.encodeId("1"), result.docs().get(1).getField(IdFieldMapper.NAME).binaryValue());
            }
        // "app.payment" should be a flat field with 2 values
    }
                    b.field("nested", "value3");
            b.endObject();
        }));
            b.endArray();
    protected Collection<? extends Plugin> getPlugins() {
                }
                        b.field("match", "big-*");
            }
                b.startObject("app");
            b.field("dynamic", "true");
        assertNotNull(barMapper);
            }
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
        })));
    }
            containsString("object field starting or ending with a [.] makes object resolution ambiguous: [top..foo..bar]")
                                }
            {
            }
        // Nested object with array: {"metrics": {"cpu": {"cores": [1, 2, 3, 4]}}}
                b.startObject();
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "long")));
                        {
        assertThat(fooMapper, instanceOf(ObjectMapper.class));
            }
            b.startObject("user");
            }
                    b.value(2);
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "false_allow_templates")));
                b.startObject();
            }
            b.field("dynamic", "false_allow_templates");
                    b.nullField("null_field");
    // creates an object mapper, which is about 100x harder than it should be....
                }
        assertNotNull("Field 'user.age' should exist", doc.rootDoc().getField("user.age"));
        ParsedDocument doc = mapper.parse(source(b -> b.field("bigint_field", bigInt)));
        Mapper barMapper = ((ObjectMapper) fooMapper).getMapper("bar");
            {
        assertEquals(
            b.endArray();
            e.getMessage()
                        b.startObject("mapping").field("type", "object").endObject();
                                b.endObject();
                }
                }
                }
                    b.endObject();
                        b.field("inner3_field1", "inner3_value1");
    }
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
            b.startArray("dynamic_templates");
                x.startObject("status_code");
        assertNotNull(inner2_mapper);
        ParsedDocument docWithTemplate = mapperWithTemplate.parse(source(b -> b.field("embedded_field", "value")));
        assertEquals(
        Mapper cpuMapper = mappingUpdate.root().getMapper("metrics.cpu");
    @Override
                    {
            b.endObject();
                    b.startObject("numeric_template");
        );
                    {
 * not use this file except in compliance with the License.
                b.field("blub", 222);
                {
        DocumentMapper documentMapperWithDynamicTemplates = createDocumentMapper(topMapping(b -> {
        Document doc = builtDocMapper.parse(new SourceToParse("test", "1", json, MediaTypeRegistry.JSON)).rootDoc();
                }
            }
        ParsedDocument doc = mapper.parse(source(b -> b.startArray("foo.bar.baz").value(0).value(1).endArray()));
                        b.field("lat", 40.7128);
                    b.field("test", "value");
                b.startObject("b");
                }
            {
        assertEquals(2, doc.rootDoc().getFields("test.test1").length);
            """));
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "long")));
    public void testParseDocumentWithDocumentInputPropagated() throws Exception {
    }
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "long")));
        exception = expectThrows(
        assertNotNull(mapping);
                {
        }));
                        b.field("match_mapping_type", "string");
    public void testDynamicDottedFieldNameLongWithExistingParentWrongType() throws Exception {
                {
            settings,
            b.field("dynamic", "strict_allow_templates");
                b.startObject("properties");
                    b.startObject("georule");
        );
            b.startObject("properties");
    public void testParseNonDynamicArrayWithDisableObjects() throws Exception {
                        b.startObject("mapping").field("type", "keyword").endObject();
                    b.endObject();
                    b.value(1);
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
            }
        StrictDynamicMappingException exception = expectThrows(StrictDynamicMappingException.class, () -> {
                        b.field("match", "foo");
                }
        StrictDynamicMappingException exception = expectThrows(
        Mapper bazMapper = ((ObjectMapper) barMapper).getMapper("baz");
    public void testDynamicDottedFieldNameLongArrayWithParentTemplate() throws Exception {
        ParsedDocument doc = mapper.parse(source(b -> b.startObject("foo").field("bar", "baz").endObject()));
                    b.endObject();
        }
            exception.getMessage()
                b.endObject();
        DocumentMapper defaultMapper = createDocumentMapper(mapping(b -> {}));
        }));
                b.startObject("properties");
            MapperException exception = expectThrows(MapperException.class, () -> mapper.parse(source(b -> b.field("foo", true))));
            }
                b.startObject();
                + "Existing mapping for [field] must be of type object but found [long].",
            {
                    b.startObject("test1");
            Mapper metricsMapper = dynamicUpdate.root().getMapper("metrics");
            b.endObject();
                b.startObject("metrics.cpu.usage");
                b.field("copy_to", "location_copy");
                }
            b.endObject();
            b.startObject("inner").field("inner_field", "inner_value").endObject();
            b.startObject("nested");
        assertEquals(0, doc.rootDoc().getFields("foo.bar.baz.a").length);
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "false")));
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            exception.getMessage()
                {
                    }
        String mapping = copyToStringFromClasspath("/org/opensearch/index/mapper/simple/test-mapping.json");
                        b.endObject();
        assertThat(err.getCause(), notNullValue());
        assertThat(doc.rootDoc().get("type.type"), equalTo("type_value"));
        assertEquals(
                    }
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.startArray("dynamic_date_formats").value("yyyy").endArray()));
                        }
        Mapping dynamicUpdate = doc.dynamicMappingsUpdate();
        assertThat(dateMapper, not(instanceOf(DateFieldMapper.class)));
            }
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
                b.endObject();
        // Null fields should not be created
                    b.field("disable_objects", true);
            {
        // 1. Traverse: level1 → level2 → level3 (which has disable_objects=true)
                .endObject()
                b.endObject();
        Mapper barMapper = ((ObjectMapper) fooMapper).getMapper("bar");
        assertNotNull("Dynamic field 'metrics.memory.used' should exist", dynamicDoc.rootDoc().getField("metrics.memory.used"));
            }
                    }
            exception.getMessage()
        );
            b.endObject();
            {
            .field("type", "keyword")
        assertThat(doc.getDocumentInput(), sameInstance(mockInput));
            }
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "false_allow_templates")));
                b.endObject();
            b.startObject("properties");
                b.endObject();
            b.field("dynamic", "strict");
                b.endArray();
        ParsedDocument doc4 = mapper.parse(source(b -> { b.field("level1.level2.level3", "exact_match"); }));
                {
        }));
                {
                        b.field("path_match", "foo.bar.baz");
                        b.field("match", "bar");
        DocumentMapper flatFieldMapper = createDocumentMapper(topMapping(b -> {
                        b.startObject("category");
                {
            b.endObject();
            }
            {
import org.opensearch.index.mapper.ParseContext.Document;
        assertNotNull("Field 'LogAttributes.app.payment' should exist", paymentFields);
            b.field("test1", "value1");
            b.field("dynamic", "false_allow_templates");
        );
                    b.endObject();
                        {
        DocumentMapper mapperWithTemplate = createDocumentMapper(topMapping(b -> {
            for (int i = 1; i <= depth_limit; i++) {
        assertNotNull(doc.rootDoc().getField("foo.bar.baz"));
        );
        assertNotNull(aMapper);
                b.startObject();
        assertThat(dateMapper, instanceOf(DateFieldMapper.class));
                b.startObject("inner2");
        assertTrue(xMapper instanceof ObjectMapper);
                b.endObject();
            {
        DocumentMapper mapper = createDocumentMapper(mapping(b -> b.startObject("field").field("type", "text").endObject()));
    public void testPathSplittingAndReconstructionInExistingMapperLookup() throws Exception {
                    }
        assertNotNull(fooMapper);
        assertEquals(
                    b.startObject("test2");
        StrictDynamicMappingException exception = expectThrows(
            b.endArray();
            IndexableField field = doc.rootDoc().getField(MockMetadataMapperPlugin.MockMetadataMapper.CONTENT_TYPE);
        merge(mapperService, dynamicMapping(doc1.dynamicMappingsUpdate()));
    public void testNoLevelWithFieldTypeAsObject() throws Exception {
        }));
        ParsedDocument doc = defaultMapper.parse(source(b -> {
    public void testAttributes() throws Exception {
                    b.endObject();
            b.field("disable_objects", true);
        }));
    public void testDisableObjectsWithExistingFieldMappers() throws Exception {
                        b.field("match", "date_*");
                        b.startObject("mapping").field("type", "keyword").endObject();
        BigDecimal bigDecimal = BigDecimal.valueOf(Double.MAX_VALUE).add(BigDecimal.valueOf(10.1));
        assertNotNull("Field 'mixed_nulls.nested' should exist", doc.rootDoc().getField("mixed_nulls.nested"));
        }));
                b.value("value2");
        }));
        assertNotNull(barMapper);
        assertThat(bazMapper, instanceOf(ObjectMapper.class));
                {
        }));
        // Objects within arrays should be flattened to dotted field names
        if (dynamicUpdate != null) {
                b.startObject("user.age");
        }));
                {
        DocumentMapper docMapper = createDummyMapping();
                }
        {
        // Verify all values are present
                b.endObject();
                    b.startObject("test2");
        // Test 1: Only null field in flattened object with strict dynamic mapping should throw exception
                }
        assertNotNull("Field 'metrics.cpu.cores' should exist", coreFields);
            {
                    b.field("type", "object");
        ParsedDocument doc = mapper.parse(source(b -> b.field("float_field", "123.45")));
            merge(mapperService, dynamicMapping(parsedDoc.dynamicMappingsUpdate()));
        assertEquals(2, doc.rootDoc().getFields("test.test1").length);
                    b.endObject();
            b.startObject("properties");
        StrictDynamicMappingException exception = expectThrows(
            mapperWithExistingField.parse(source(b -> {
        }));
                    b.field("type", "integer");
            .endObject()
        IndexMetadata build = IndexMetadata.builder("")
        }));
            {
            () -> mapper.parse(source(b -> b.startArray("foo.bar.baz").value(0).value(1).endArray()))
        assertNotNull(doc);
            "mapping set to strict_allow_templates, dynamic introduction of [foo] within [_doc] is not allowed",
            {
    public void testDynamicStrictValue() throws Exception {
                    b.startObject("georule");
        );
                b.field("test2", "value2");
        assertNotNull(doc.dynamicMappingsUpdate());
        }));
                    {
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> mapper.parse(source(b -> {
                        b.field("match", "bar");
    }
            b.endObject();
        assertEquals(
                        b.field("price", 99.99);
        // This happens when we have null values within flattened objects/arrays in disable_objects mode
                b.startObject();
        assertEquals(2, docWithTemplate.rootDoc().getFields("foo.bar.baz.a").length);
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
            {
            b.field("inner_field", "inner_value");
            () -> mapper.parse(source(b -> b.startObject("foo").field("bar", "baz").endObject()))
                b.endObject();
                }
                    b.startObject("properties");
                    b.startObject();
        assertFalse(
        DocumentMapper mapperWithTemplate = createDocumentMapper(topMapping(b -> {
        List<Mapper> updates = Collections.singletonList(new MockFieldMapper("x.foo"));
            b.field("dynamic", "true");
    }
        assertEquals("address.city should be text", "text", mapperService.fieldType("attributes.address.city").typeName());
            b.endArray();
            b.endObject();
            b.endArray();
            assertNull(doc.rootDoc().getField("field"));
        // Dynamic mapping update expected since "address.city" is not pre-defined
                    {
            b.endArray();
            {
        // Regular fields should be flattened and exist
                        b.field("match_mapping_type", "long");
        ParsedDocument doc = mapper.parse(source(b -> {
                b.endObject();
                    {
            StrictDynamicMappingException.class,
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
                        b.field("inner3_field1", "inner3_value1");
                }
        MapperParsingException exception = expectThrows(
                b.startObject("type").field("type_field", "type_value").endObject();
                b.endObject();
                b.endObject();
                        }
        assertEquals(789, fields[4].numericValue());
                b.endObject();
                b.endObject();
        merge(MapperService.SINGLE_MAPPING_NAME, mapperService, mapping);
        Mapper aMapper = ((ObjectMapper) bazMapper).getMapper("a");
            b.endObject();
            b.endArray();
            b.endArray();
 */
        assertThat(textMapper, instanceOf(TextFieldMapper.class));
        assertThat((String) docMapper.meta().get("param1"), equalTo("value1"));
        }));
import static org.opensearch.test.StreamsUtils.copyToBytesFromClasspath;
        DocumentMapper defaultMapper = createDocumentMapper(mapping(b -> {}));
            exception.getMessage()
        assertEquals("10001", doc.rootDoc().getField("user.address.zip").stringValue());
            b.field("type", "geo_point");
    }
            }
            b.endObject();
                    }
        DocumentMapper mapperWithTemplate = createDocumentMapper(topMapping(b -> {
                        b.field("name", "Product 2");
            }
                b.endObject();
        assertThat(exception3.getMessage(), containsString("strict"));
        DocumentMapper docMapper = createDummyMapping();
            MapperParsingException.class,
        MapperParsingException err = expectThrows(MapperParsingException.class, () -> mapper.parse(source(b -> b.field("", "foo"))));
                    }
                b.endObject();
    MapperService createMapperService() throws Exception {
                b.startObject();
        {
        // Verify no intermediate ObjectMapper "app" was created in the dynamic mapping update
    public void testTypeLevelWithFieldTypeAsValueNotFirst() throws Exception {
                b.startObject("deep");
        assertNotNull(update);
        assertNotNull(doc.rootDoc().getField("foo.bar"));
    }
                    b.startObject("subx");
            b.startObject("type");
    }
        }));
            ParsedDocument doc = mapper.parse(source(b -> b.field("field.bar", new int[] { 1, 2, 3 })));
                {
                b.field("test1", "value1");
            b.startArray("dynamic_templates");
                {
                }
import java.util.List;
    public void testDeepSubfieldMappingUpdate() throws Exception {
                b.field("source_field", "test value");
        assertNotNull(bazMapper);
        ParsedDocument doc = mapper.parse(source(b -> {
    public void testParseDocumentWithDocumentInputAndNestedFields() throws Exception {
    public void testDynamicFalseAllowTemplatesObject() throws Exception {
                b.endObject();
        assertEquals("tag1", tagFields[0].stringValue());
        }
        DocumentMapper mapper = createDocumentMapper(mapping(b -> b.startObject("field").field("type", "text").endObject()));
                    b.startObject("properties").endObject();
    }
            b.field("dynamic", "strict_allow_templates");
        ParsedDocument doc = mapper.parse(source(b -> {
            b.startObject("text-field");
            .build();
    public void testDynamicFalseAllowTemplatesWithBigDecimal() throws Exception {
        ParsedDocument docWithTemplate = mapperWithTemplate.parse(source(b -> b.field("date_field", "2023-12-25")));
            b.field("dynamic", "strict_allow_templates");
                    }
                    }
        updates.add(createObjectMapper(mapperService, "foo"));
            "address.city should be text after round-trip",
            b.field("dynamic", "true");
            b.endArray();
                b.endObject();
        assertThat(e.getCause(), notNullValue());
        // 2. Flatten remaining path ["deep", "nested", "field", "name"] into "deep.nested.field.name"
        assertEquals("tag2", tagFields[1].stringValue());
        // Test the path splitting logic: String[] pathParts = fieldPath.split("\\.");
                {
            );
    }
        }));
        ParsedDocument doc = mapper.parse(source(b -> {
            b.startArray("dynamic_templates");
                            .startObject()
        Mapping mapping = DocumentParser.createDynamicUpdate(docMapper.mapping(), docMapper, updates);
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "false_allow_templates")));
                        b.field("match", "test");
                }
                b.startObject("b");
            b.endObject();
        long depth_limit = MapperService.INDEX_MAPPING_DEPTH_LIMIT_SETTING.getDefault(Settings.EMPTY);
            assertNull("ObjectMapper 'metrics.cpu' should NOT exist at root", metricsCpuMapper);
        assertThat(doc.rootDoc().get("type.type_field"), equalTo("type_value"));
        Mapper barMapper = ((ObjectMapper) fooMapper).getMapper("bar");
        assertEquals(2, docWithTemplate.rootDoc().getFields("bigdecimal_field").length);
        ParsedDocument doc = mapper.parse(source(b -> b.startArray("foo").value(0).value(1).endArray()));
        assertEquals(2, doc.rootDoc().getFields("foo.bar.baz").length);
        assertEquals("It is forbidden to create dynamic nested objects ([foo]) through `copy_to` or dots in field names", e.getMessage());
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {}));
        assertNotNull(doc);
            {
                    b.endObject();
    public void testDynamicDottedFieldNameObjectWithExistingParentWrongType() throws Exception {
                    }
        BytesReference json = new BytesArray(copyToBytesFromClasspath("/org/opensearch/index/mapper/simple/test1.json"));
                b.endObject();
        // when the type is not the first one, we don't confuse it...
                    b.endObject();
        assertNotNull(update); // dynamic mapping update
        assertEquals("456", fields[3].stringValue());
                }
            {
                        b.field("match_mapping_type", "object");
        assertEquals("foo", result.docs().get(0).getField(NestedPathFieldMapper.NAME).stringValue());
                    {
                    b.field("id", "prod1");
            () -> mapper.parse(source(b -> b.field("bar", "baz")))
            b.endObject();
            );
            StrictDynamicMappingException.class,
        assertTrue(copy2Fields.length > 0);
        }));
            assertNull(doc.rootDoc().getField("bar"));
        assertEquals(
            b.startObject("outer");
        ParsedDocument doc2 = mapper.parse(source(b -> { b.field("level1.level2.level3.deep.nested.field.name", "flattened_value"); }));
                            b.field("type", "text");
        ParseContext context = new ParseContext.InternalParseContext(
            }));
                    }
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {
        assertNotNull(update);
                    b.field("disable_objects", true);
                    }
            assertNull(doc.rootDoc().getField("bar"));
 * ownership. Elasticsearch licenses this file to you under
            assertNull(doc.rootDoc().getField("field.bar"));
        DocumentMapper mapperWithTemplate = createDocumentMapper(topMapping(b -> {
                    b.endObject();
        ParsedDocument doc = mapper.parse(source(b -> {
                        b.field("match_mapping_type", "double");
        ParsedDocument doc = mapper.parse(source(b -> { b.startObject("point").field("lat", 40.71).field("lon", 74.00).endObject(); }));
        updates.add(new MockFieldMapper("x.foo"));
        // Test 4: Test with pre-existing field mapping to ensure we only test dynamic null handling
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
        DocumentMapper docMapper = createDocumentMapper(MapperService.SINGLE_MAPPING_NAME, mapping);
                b.field("name", "laptop");
        // after throwing exception
                b.startObject();
                    {
        assertThat(doc.rootDoc().get("type.inner.inner_field"), equalTo("inner_value"));
        // Verify flat field storage
            }
        ParsedDocument doc2 = mapper.parse(source(b -> { b.startArray("numbers").value(10).value(20).value(30).endArray(); }));
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
            b.field("dynamic", "false_allow_templates");
            assertTrue(e.getMessage(), e.getMessage().contains("failed to parse field [_mock_metadata]"));
            b.field("user.name", "John Doe");
        }));
                .field("ignore_above", 256)
        }));
                    b.startObject("test");
        DocumentMapper documentMapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "strict_allow_templates")));
                    b.startObject("test");
        merge(mapperService, dynamicMapping(mapperService.documentMapper().parse(source(b -> {
import static org.hamcrest.Matchers.nullValue;
        assertThat(err.getCause().getMessage(), containsString("field name cannot be an empty string"));
    }
                b.startObject();
        }));
        }
            b.endObject();
            b.startObject("properties");
            }
                    b.endObject();
                }
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "false_allow_templates")));
                b.startObject();
        assertThat(err.getCause().getMessage(), containsString("field name cannot be an empty string"));
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "false_allow_templates")));
            }
        // check that parsing succeeds with valid doc
 * compatible open source license.
        IndexableField[] idFields = doc.rootDoc().getFields("products.id");
    public void testPropagateDynamicWithExistingMapper() throws Exception {
                assertNotNull("FieldMapper 'app.payment' should exist as flat field under LogAttributes", appPaymentMapper);
        );
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> mapper.parse(source(b -> {
            b.startObject("attributes").field("type", "object").field("dynamic", true).field("disable_objects", true).endObject();
            "Could not dynamically add mapping for field [field.bar.baz]. "
            }
    }
            b.endObject();
            """));
                        b.field("match_mapping_type", "object");
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
        // "metrics.cpu.cores" should be a flat field with 4 values
        }));
                    b.endObject();
                    {
                        b.field("match_mapping_type", "object");
            () -> documentMapper.parse(source(b -> b.field("foo.bar.baz", 0)))
    public void testDynamicFalseAllowTemplatesDottedFieldNameLongArray() throws Exception {
                    }
                    b.startObject("test1");
 * You may obtain a copy of the License at
            // A metadata field that parses a value fails to parse a null value
                    b.startObject("bar");
                    }
            "Cannot add a value for field [field.bar] since one of the intermediate objects is mapped as a nested object: [field]",
    }
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "object")));
            b.startObject("type");
        assertNotNull("Field 'a.b.c.d.e.f' should exist", doc2.rootDoc().getField("a.b.c.d.e.f"));
        assertThat(doc.rootDoc().get("type.test1"), equalTo("value1"));
        MapperParsingException exception = expectThrows(
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {
        long depth_limit = MapperService.INDEX_MAPPING_DEPTH_LIMIT_SETTING.getDefault(Settings.EMPTY);
    public void testDynamicDottedFieldNameLong() throws Exception {
            }
        ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.field("source_field", "test value")));
        if (parsedDoc.dynamicMappingsUpdate() != null) {
                    }
        DocumentMapper documentMapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "strict_allow_templates")));
                b.startObject();
        assertTrue(xMapper instanceof ObjectMapper);
                    }
        assertNotNull(bazMapper);
        DocumentMapper defaultMapper = createDocumentMapper(topMapping(b -> {
        IndexableField[] fields = doc.rootDoc().getFields("big-integer");
    }
    }
            }
    }
            b.endObject();
                    b.endObject();
            assertThat(exception.getMessage(), containsString("failed to parse field [foo] of type [long] in document with id '1'"));
            }
                )
import static org.hamcrest.Matchers.sameInstance;
                b.startObject();
                {
                                b.endObject();
        ParsedDocument doc = mapper.parse(source(b -> b.field("test1", "baz")));
                }
    }
            MapperParsingException.class,
        }));
        throws IOException {
                b.startArray().value(0).value(0).endArray();
            }
                }
            b.startObject("event_all").field("type", "text").endObject();
            }
        assertEquals(
                }
        Mapper textMapper = doc.dynamicMappingsUpdate().root().getMapper("dynamic_text");
        // Test scenario with disable_objects parent to ensure correct flattening behavior
                            {
        );
        assertNotNull("Field 'metrics.cpu.usage' should exist", doc1.rootDoc().getField("metrics.cpu.usage"));
        }));
                    b.endObject();
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "false_allow_templates")));
            {
                        b.startObject("properties");
            b.field("disable_objects", true);
                    {
                b.endObject();
            b.startObject("foo").field("enabled", false).endObject();
