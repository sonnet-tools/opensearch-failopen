            b.endObject();
            b.endArray();
            {
                    }
                b.field("source_field", "test value");
                }
        // Test that strict dynamic mapping works correctly with disable_objects
        ParsedDocument doc = mapper.parse(source(b -> {
                        b.field("match_mapping_type", "long");  
import java.math.BigInteger;  
                        b.field("match", "foo*");
                        b.field("match", "foo");
                }
            }).accept(b);  
            );  
                b.startObject("inner").field("inner_field", "inner_value").endObject();  
        assertThat(doc.rootDoc().get("test2"), equalTo("value2"));
        DocumentMapper documentMapperWithDynamicTemplates = createDocumentMapper(topMapping(b -> {
                {
        ParsedDocument doc = mapper.parse(source(b -> { b.array("point", 74.00, 40.71); }));  
                    b.startObject("level3");
        updates.add(new MockFieldMapper("x.a"));  
            "address.city should be text after prefix conflict",
                        b.field("path_match", "foo.bar.baz");
        // Test comprehensive automatic flattening scenarios with disable_objects=true
            StrictDynamicMappingException.class,
import org.opensearch.cluster.metadata.IndexMetadata;
        }));
            }
            "mapping set to strict_allow_templates, dynamic introduction of [foo] within [_doc] is not allowed",
            {  
                {
                        b.startObject("mapping").field("type", "long").endObject();
        assertNotNull(fooMapper);  
        assertNotNull("Field 'outer.inner.test' should exist", doc1.rootDoc().getField("outer.inner.test"));
            b.startArray("dynamic_templates");  
                        }
                    b.endObject();
        Mapper inner3_mapper = ((ObjectMapper) inner2_mapper).getMapper("inner3");  
                b.startObject();
        ParsedDocument doc = defaultMapper.parse(source(b -> {  
            b.field("disable_objects", true);
        // Verify the actual values
                {  
                {  
                }
        List<Mapper> updates = Collections.singletonList(new MockFieldMapper("x.foo"));  
                b.startObject();  
        assertEquals(0, doc.rootDoc().getFields("bar").length);
            b.startArray().value(0).value(0).endArray();
        IndexableField[] fields = doc.rootDoc().getFields("big-decimal");  
            {
            b.startObject("outer");
            b.startObject("metrics");
                b.startObject();
 * this file be licensed under the Apache-2.0 license or a
                b.endObject();
                {  
                        b.field("match", "test");
            {  
                }  
        assertThat(barMapper, instanceOf(ObjectMapper.class));
    }
                b.startObject();
    }
                    b.startObject("inner3");
        Mapper barMapper = ((ObjectMapper) fooMapper).getMapper("bar");
        assertNotNull(inner3_mapper);
                b.startArray().value(0).value(0).endArray();
        BigDecimal value = BigDecimal.valueOf(Double.MAX_VALUE).add(BigDecimal.valueOf(10.1));  
        ParsedDocument doc = mapper.parse(source(b -> {  
        assertThat(doc.rootDoc().get("type.test1"), equalTo("value1"));
        // Without pluggable data format, text field SHOULD have .keyword multi-field  
        ParsedDocument doc = mapper.parse(source(b -> b.startArray("foo.bar.baz").value(0).value(1).endArray()));
                            b.field("main", "electronics");
        assertNotNull(dateMapper);
                        b.field("match_mapping_type", "date");  
                    b.field("value", 100);
                b.endObject();
                        b.field("match", "bool_*");
        DocumentMapper docMapper = createDummyMapping();
            doc1.rootDoc().getField("level1.level2.level3.simple.field")
            b.endArray();
            "text",
        assertThat(doc.rootDoc().get("type.type_field"), equalTo("type_value"));
    public void testDynamicFalseAllowTemplatesWithCopyTo() throws Exception {  
            null,  
                        b.endObject();  
        }));  
        assertEquals(1, doc.rootDoc().getFields("nested.source_field").length);  
                }
                    b.field("city", "NYC");  
        assertNotNull(((ObjectMapper) fooMapper).getMapper("field"));
        }));  
        assertNotNull(mapping.root().getMapper("foo"));
        assertEquals("Should have 2 values for the array", 2, paymentFields.length);
                b.field("path", "concrete-field");
            b.startArray("dynamic_templates");
        assertEquals(
                        b.field("path_match", "foo.bar.baz");  
            }
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {  
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {
                    b.value(3);
 * specific language governing permissions and limitations
    public void testDocumentContainsDeepNestedFieldParsing() throws Exception {  
        assertThat(fooMapper, instanceOf(ObjectMapper.class));
        DocumentMapper mapperWithTemplate = createDocumentMapper(topMapping(b -> {
            b.startObject("properties");  
                    }
                    {
import org.opensearch.core.xcontent.MediaTypeRegistry;
                    b.startArray("foo.");  
                    b.startObject("test");
    public void testDotsWithFieldDisabled() throws IOException {
    public void testObjectMappingUpdate() throws Exception {
                        b.field("match", "bigdecimal_*");
                b.startObject("inner2");  
                b.endObject();
            "mapping set to strict_allow_templates, dynamic introduction of [bar] within [_doc] is not allowed",
            }
import org.opensearch.core.common.bytes.BytesReference;  
        StrictDynamicMappingException exception = expectThrows(StrictDynamicMappingException.class, () -> {  
        Mapper inner2_mapper = ((ObjectMapper) objMapper).getMapper("inner2");
            b.endArray();
                b.startObject("inner").field("inner_field", "inner_value").endObject();  
        for (String field : new String[] { "dyn_long", "dyn_double", "dyn_date", "dyn_bool" }) {
                {
        StrictDynamicMappingException exception = expectThrows(  
        assertNotNull(((ObjectMapper) xMapper).getMapper("foo"));  
        }));
        assertEquals(
    }
                }  
                {
                    {
            }
import org.opensearch.index.mapper.ParseContext.Document;
    }
                        b.startObject("memory.used");
        assertNotNull(((ObjectMapper) barMapper).getMapper("baz"));
        assertNotNull("Field 'products.details.price' should exist", doc.rootDoc().getField("products.details.price"));  
    }
                        b.startObject("mapping").field("type", "object").endObject();  
        assertEquals(0, docWithTemplate.rootDoc().getFields("bar").length); // null fields don't create mappings  
            assertNull(doc.rootDoc().getField("bar"));  
        assertEquals("789", fields[5].stringValue());
                {  
        assertNotNull("Field 'user.name' should exist", doc.rootDoc().getField("user.name"));  
        }));
        assertEquals(0, doc.rootDoc().getFields("numeric_field").length);
                    {  
            b.startObject().startObject("strings").field("match_mapping_type", "string");
                    }  
            exception.getMessage()
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        b.startObject("mapping").field("type", "object").endObject();
        assertEquals("300", doc.docs().getFirst().getGroupingCriteria());
        ParsedDocument doc = mapper.parse(source(b -> {
        assertThat((String) docMapper.meta().get("param1"), equalTo("value1"));
            b.endArray();
                    }
            }
        ParsedDocument doc = mapper.parse(source(b -> b.startObject("test").field("test1", "baz").endObject()));
    public void testNoDocumentSent() throws Exception {  
            }  
            }
                        b.startObject("b");  
        // After flattening, field name becomes "metrics.cpu.cores" and the value is an array.
                    b.startObject("properties").endObject();  
                    b.endObject();
                    {
        assertEquals("tag3", tagFields[2].stringValue());
    public void testDynamicFalseObject() throws Exception {  
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
                    b.endObject();  
        );
                .endObject()
                        b.field("match", "foo*");
                    b.endObject();  
        assertEquals("another_value", doc3.rootDoc().getField("level1.level2.level3.very.long.dotted.field.path").stringValue());
                b.startObject();
            b.startArray("dynamic_templates");  
        assertThat((String) builtDocMapper.meta().get("param1"), equalTo("value1"));  
            {
                        b.field("match", "test1");
                {  
    public void testDynamicDateDetectionDisabledOnNumbers() throws IOException {
                b.endObject();  
            StrictDynamicMappingException.class,  
            b.startObject("inner").field("inner_field", "inner_value").endObject();
    public void testParseNonDynamicArrayNestedArraysWithDisableObjects() throws Exception {  
        assertNull(doc.dynamicMappingsUpdate());
            b.field("dynamic", "true");
                {
            b.startObject("properties");  
        MapperService mapperService = createMapperService(mapping(b -> {}));
        assertTrue(xMapper instanceof ObjectMapper);  
                b.field("disable_objects", true);
            b.startArray("items");
            {
            }  
    }
                    b.startObject("bar");  
                    b.field("type", "object");
                b.endObject();  
                    {  
        }));  
    }  
        assertEquals(
        Mapper aMapper = ((ObjectMapper) bazMapper).getMapper("a");
                        b.field("match", "foo");
            {
        assertEquals(
                b.startArray("foo" + 1);
            }
            b.startObject("alias-field");
            b.startObject("point");  
            "text",
        // Verify we have the correct number of instances (2 products)
                        b.field("match", "test1");
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {}));
        ParsedDocument doc = mapper.parse(source(b -> b.startArray("field.bar.baz").value(0).value(1).endArray()));  
                }
            b.startObject("concrete-field").field("type", "keyword").endObject();  
            mapperService.documentMapperParser(),
            {
        assertNotNull(doc3);
            }  
        }));  
            {  
        assertNotNull("Dynamic field 'metrics.memory.used' should exist", dynamicDoc.rootDoc().getField("metrics.memory.used"));
                        b.field("type", "object");  
                    b.field("item.category.name", "electronics");
            {  
        }));  
            b.field("dynamic", "strict_allow_templates");
                    b.startObject("test2");
    }  
            b.field("user.name", "John Doe");
        // Test 3: Array with mixed content (objects within arrays)  
                        b.startObject("mapping").field("type", "object").endObject();
        Mapper dateMapper = update.root().getMapper("foo");  
            }
                    b.endObject();
        }));  
        assertTrue(copiedFields.length > 0);
            b.field("type", "nested");  
                    }
        );
        StrictDynamicMappingException exception = expectThrows(
            b.startObject("y").field("type", "object").endObject();
        ParsedDocument doc = mapper.parse(source(b -> { b.startObject("point").field("lat", 40.71).field("lon", 74.00).endObject(); }));
        Mapper subxMapper = ((ObjectMapper) xMapper).getMapper("subx");  
    public void testDynamicObjectWithTemplate() throws Exception {
        DocumentMapper mapperWithTemplate = createDocumentMapper(topMapping(b -> {
        }));  
        }));
                    b.endObject();
                    {
    public void testTypeless() throws IOException {  
        // Test 2: Dynamic fields with disable_objects=true  
        assertThat(keywordSubField, instanceOf(KeywordFieldMapper.class));  
                    b.startObject("c");  
        }));  
            b.endArray();  
        }));
                    {  
    }  
            {  
                b.startObject().field("bar", "value1").endObject();  
        assertTrue(  
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
                    {
            b.endArray();
            {
                b.startObject();
        }
        assertEquals("laptop", doc.rootDoc().getField("product.name").stringValue());  
                }  
                        b.field("match", "foo");
                            {  
        assertNotNull(fooMapper);
        assertEquals(  
            }  
    }  
        BytesReference json = new BytesArray(copyToBytesFromClasspath("/org/opensearch/index/mapper/simple/test1-notype-noid.json"));  
        // The getMapper function should flatten the entire path into a single field name  
     * dynamic mapper builders in {@link DocumentParser}.
                    }
                {
        DocumentMapper docMapper = createDummyMapping();
        assertEquals(2, docWithTemplate.rootDoc().getFields("bigdecimal_field").length);  
            b.endObject();
    }  
                b.startObject();
        assertNotNull("Field 'user.name' should exist in nested structure", defaultDoc.rootDoc().getField("user.name"));  
            assertNull("ObjectMapper 'metrics' should NOT exist at root (dotted name should be kept flat)", metricsMapper);
        }));  
            b.startObject("outer");
                b.endObject();  
                }
        if (parsedDoc.dynamicMappingsUpdate() != null) {  
            {  
        assertThat(doc.rootDoc().get("test1"), equalTo("value1"));  
                    }
                    b.field("nested", "value3");
        assertEquals(0, doc.rootDoc().getFields("date_field").length);  
                }  
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {}));  
    }
            b.field("disable_objects", true);
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {  
                b.startObject("inner" + i);
                            {  
        }));
        assertThat(doc.rootDoc().get("type.test1"), equalTo("value1"));  
        IndexMetadata build = IndexMetadata.builder("")
                    }
        return createMapperService().documentMapper();  
                    }  
            assertNotNull(doc.rootDoc().getField("blub"));
            }
                b.endObject();
        // Comprehensive test for basic disable_objects functionality
                            b.endObject();  
            context.path().add(nameParts[i]);
        return createMapperService(mapping(b -> {
            }
                    b.startArray("payment");
    // creates an object mapper, which is about 100x harder than it should be....  
        assertEquals(0, doc.rootDoc().getFields("foo.bar.baz").length);
            b.startObject("inner1");
                    b.endArray();
        assertThat(doc.rootDoc().get("type.inner.inner_field"), equalTo("inner_value"));
        assertEquals(2, doc.rootDoc().getFields("foo.bar.baz").length);
            }  
            {
public class DocumentParserTests extends MapperServiceTestCase {  
        assertNotNull("Field 'metrics.cpu.cores' should exist", coreFields);
        assertEquals(123, fields[0].numericValue());
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> mapper.parse(source(b -> b.field("field.bar", 123))));
            {
            ParsedDocument doc = mapper.parse(source(b -> {
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
                        b.startObject("category");
        assertThat(doc.rootDoc().get("type.inner.inner_field"), equalTo("inner_value"));
            b.startObject("nested");  
        String mapping = XContentFactory.jsonBuilder()
                }
            }
    public void testDynamicDottedFieldNameWithFieldAlias() throws Exception {
                        b.field("match_mapping_type", "object");
        assertEquals(2, doc.rootDoc().getFields("foo").length);  
        IndexableField[] categoryFields = doc.rootDoc().getFields("items.item.category.name");  
    }
                }
            {
            }  
                "dynamically mapped [" + field + "] should not be indexed on a pluggable data format index",
        ParsedDocument doc = mapper.parse(source(b -> b.startArray("field").value(0).value(1).endArray()));
    // object -> array -> object -> array ....
        );
            b.field("dynamic", "false_allow_templates");
        DocumentMapper mapperWithTemplate = createDocumentMapper(topMapping(b -> {
                    b.endObject();  
            b.startObject("foo");
                b.endObject();  
            }
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> { b.field("type", "nested"); }));  
import static org.hamcrest.Matchers.equalTo;
                    b.field("name", "item2");  
                b.startObject();
    public void testNoLevelWithFieldTypeAsValue() throws Exception {
            {  
                        b.field("match", "test");
                    }
    }  
            b.endObject();
        }));
            {  
        ParsedDocument flatDoc = flatFieldMapper.parse(source(b -> {
    public void testDeepSubfieldAfterSubfieldMappingUpdate() throws Exception {  
    }
        assertEquals("value1", doc2.rootDoc().getField("a.b.c.d.e.f").stringValue());  
                        b.startObject("mapping").field("type", "long").endObject();
                b.endObject();  
    }
        }));
                {  
            b.startObject("type").field("type_field", "type_value").endObject();
            {  
            b.field("dynamic", "true");  
    public void testParseDocumentWithDocumentInputAndDynamicMapping() throws Exception {
                b.endObject();
            {
        assertNotNull(aMapper);
        );
        assertEquals(  
                {
                b.field("name", "Jane Doe");
        })));  
            for (int i = 1; i < depth_limit - 1; i++) {  
    }
        // Test the getMapper flattening logic: when looking up "level1.level2.level3.deep.nested.field.name"
                b.startObject();
        assertEquals("mapping set to strict, dynamic introduction of [foo] within [_doc] is not allowed", exception.getMessage());  
                b.startObject();
    }
                    b.field("type", "object");  
                    {
            b.startObject("attributes").field("type", "object").field("dynamic", true).field("disable_objects", true).endObject();
                    }  
            exception.getMessage()
        );  
            b.startObject("properties");
                {
                    b.endObject();
 * under the License.  
                    b.endObject();  
            "mapping set to strict_allow_templates, dynamic introduction of [foo] within [_doc] is not allowed",  
        ParsedDocument doc = mapper.parse(source(b -> {  
                    b.endObject();
        // "metrics.cpu.cores" should be a flat field with 4 values
        assertNotNull(doc);
                + "Existing mapping for [field] must be of type object but found [long].",
        }));
        })));
            b.startArray().value(0).value(0).endArray();
            """));
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
                        {  
            }  
                b.field("path", "concrete-field");
                b.startObject("user.name");  
        ParsedDocument docB = ms2.documentMapper().parse(source("""  
                // There SHOULD be a "app.payment" FieldMapper child  
        assertEquals("value2", mixedFields[1].stringValue());  
            {  
                {  
                .endObject()  
                    b.startObject("properties").endObject();  
            {"attributes": {"address": "US"}}
                b.startObject();
        }));  
                {
            {  
            b.endObject();
            b.startObject("foo").field("type", "long").endObject();
            }
            b.field("disable_objects", true);
            b.startObject("point");
        assertEquals(2, docWithTemplate.rootDoc().getFields("bar").length);
        assertEquals(0, doc.rootDoc().getFields("foo.bar.baz.a").length);  
            b.startObject("mapping").field("type", "text").field("copy_to", "event_all");  
    }  
            {  
        Settings pluggableSettings = Settings.builder()  
    public void testDynamicDottedFieldNameLongArrayWithParentTemplate() throws Exception {  
        }));
        Mapper fooMapper = doc.dynamicMappingsUpdate().root().getMapper("foo");
    }
            }  
            b.endArray();
                    b.endObject();
            StrictDynamicMappingException.class,
        DocumentMapper mapper = createDocumentMapper(mapping(b -> b.startObject("field").field("type", "text").endObject()));
    public void testDisableObjectsFieldTypeLookupWithPrefixConflict() throws Exception {  
                {
        ParsedDocument doc = mapper.parse(source(b -> b.field("foo", "2016")));  
        assertThat(doc.rootDoc().get("type.test1"), equalTo("value1"));
                    {  
                {
                    b.startObject("test2");
        merge(mapperService, dynamicMapping(doc2.dynamicMappingsUpdate()));  
        assertThat(doc.rootDoc().get("type.test2"), equalTo("value2"));  
        ParsedDocument doc = mapper.parse(source(b -> {
                b.startArray().value(1).value(1).endArray();
        assertNotNull("Mapper for 'metrics.cpu' should exist", cpuMapper);
            {
    public void testDynamicallyMappedFieldsAreNotIndexedForPluggableDataFormat() throws Exception {
                }
        assertEquals(2, doc.rootDoc().getFields("field.bar.baz").length);
            {
        );  
    public void testParseNonDynamicArrayWithComplexObjectsDisableObjects() throws Exception {
                                b.startObject("c");
        assertThat(doc.rootDoc().get("test2"), equalTo("value2"));  
        );  
                {  
        assertNotNull("Field 'user.address.zip' should exist", doc.rootDoc().getField("user.address.zip"));  
            b.endObject();
                Mapper appMapper = logAttrsObj.getMapper("app");
        }));
            {
                        b.field("match", "bar");  
    public void testDynamicFalseAllowTemplatesWithNumericDetection() throws Exception {
                                    b.field("disable_objects", true);
        }
                            b.startObject("properties");  
        {  
        assertEquals("mastercard", paymentFields[1].stringValue());  
                    b.startObject("properties").endObject();
            b.startObject("user");
    }  
                    b.startObject("details");
                            }
        Mapper fooMapper = doc.dynamicMappingsUpdate().root().getMapper("field");  
        assertEquals("value2", result.docs().get(1).getField("baz").binaryValue().utf8ToString());  
                b.endObject();  
        assertThat(doc.getDocumentInput(), nullValue());  
        ParsedDocument docWithTemplate = mapperWithTemplate.parse(source(b -> b.field("foo.bar.baz", 0)));
        ParsedDocument doc = mapper.parse(source(b -> b.startArray("foo.bar.baz").value(0).value(1).endArray()));
        assertEquals(
            b.endObject();  
        DocumentMapper docMapper = createDocumentMapper(MapperService.SINGLE_MAPPING_NAME, mapping);
                    }  
        assertEquals("mapping set to strict, dynamic introduction of [bar] within [_doc] is not allowed", exception.getMessage());  
                }
            b.endObject();  
        ParsedDocument docWithTemplate = mapperWithTemplate.parse(source(b -> b.field("numeric_field", "123")));  
        ParsedDocument doc = mapper.parse(source(b -> b.field("dynamic_text", "hello world")), noopInput);
    public void testDynamicFalseAllowTemplatesLongArray() throws Exception {
        ParsedDocument doc = mapper.parse(source(b -> {  
        IndexableField[] nameFields = doc.rootDoc().getFields("products.details.name");  
        // to create an intermediate ObjectMapper ("app") without disable_objects=true, breaking  
    public void testDynamicFalseAllowTemplatesNull() throws Exception {
            b.endArray();
            b.field("test2", "value2");
                    {
                b.endObject();  
            () -> documentMapper.parse(source(b -> b.startObject("foo.bar.baz").field("a", 0).endObject()))  
        ParsedDocument docWithTemplate = mapperWithTemplate.parse(source(b -> b.field("bar", "baz")));  
        );
                b.startObject("address");
    public void testDynamicStrictDottedFieldNameObject() throws Exception {  
        assertThat(fooMapper, instanceOf(ObjectMapper.class));  
        assertEquals(6, doc.rootDoc().getFields("nested_arrays").length);
                }  
                    b.startObject("big-decimal-to-scaled-float");  
            }  
            e.getCause().getMessage(),
        merge(ms2, dynamicMapping(docB.dynamicMappingsUpdate()));
                b.field("cpu.usage", 75.5);
    }
                b.startObject("numbers");
            MapperParsingException e = expectThrows(  
                }
        assertNotNull(doc.rootDoc().getField("point"));
        assertEquals(2, doc.rootDoc().getFields("products.id").length);
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
        DocumentMapper defaultMapper = createDocumentMapper(mapping(b -> {}));
            b.startArray("dynamic_templates");
        Mapping update = doc.dynamicMappingsUpdate();
        assertEquals(
        ParsedDocument doc = mapper.parse(source(b -> b.startObject("foo").field("bar", "baz").endObject()));
            null
        String[] nameParts = name.split("\\.");  
        assertEquals(0, doc.rootDoc().getFields("bar").length);  
        assertNotNull(barMapper);
            );  
            }
        }));
            b.startArray("dynamic_templates");
        assertNotNull(update); // dynamic mapping update  
            b.endArray();
                    b.startObject("c");
        Mapper subxMapper = ((ObjectMapper) xMapper).getMapper("subx");
        ParsedDocument docWithTemplate = mapperWithTemplate.parse(source(b -> b.nullField("bar")));
        String mapping = copyToStringFromClasspath("/org/opensearch/index/mapper/simple/test-mapping.json");
                .field("type", "keyword")  
        MapperService recoveredService = createMapperService(MapperService.SINGLE_MAPPING_NAME, mappingSource);
                MapperParsingException.class,
                b.startObject("metrics");
        }));  
                    b.endObject();  
                }
                b.field("test1", "value1");
            b.startArray("dynamic_date_formats").value("yyyy-MM-dd").endArray();
            () -> mapper.parse(source(b -> b.startObject("foo").field("", "bar").endObject()))
        assertTrue(xMapper instanceof ObjectMapper);
                    }  
            exception.getMessage()
            b.startObject("properties");
    public void testDynamicFalseAllowTemplatesWithFloatDetection() throws Exception {
            b.startObject("name");
            }  
        CapturingDocumentInput mockInput = new CapturingDocumentInput();
        IndexableField[] tagFields = doc1.rootDoc().getFields("tags");
            b.endArray();
    }  
            StrictDynamicMappingException.class,
    public void testDotsWithExistingMapper() throws Exception {  
            }  
                {
    public void testDisableObjectsRootArrayWithDottedFieldNameNoIntermediateObjectMapper() throws Exception {
        for (int i = 0; i < expectedValues.length; i++) {  
            exception.getMessage()
            assertEquals(expectedValues[i], fields[i].stringValue());
                    b.startObject("georule");
            b.startArray("dynamic_templates");
        Mapper cpuMapper = mappingUpdate.root().getMapper("metrics.cpu");
                        b.startObject("mapping").field("type", "keyword").endObject();
                    b.value("mastercard");
                    b.endObject();  
                            b.startObject("properties");
            b.endArray();  
                    b.field("type", "object");
        assertThat(err.getCause().getMessage(), containsString("field name cannot be an empty string"));
        assertNotNull(doc.rootDoc().getField("foo.bar"));
        assertEquals(0, doc.rootDoc().getFields("bar").length);  
import static org.hamcrest.Matchers.sameInstance;
            b.startArray("inner");  
        {  
        }));
        assertEquals(0, docWithTemplate.rootDoc().getFields("float_field").length);
                    b.endObject();  
                        b.startObject("properties");
                        b.startObject("category");  
                b.startArray().value(0).value(0).endArray();  
            }
import static java.util.Collections.singletonList;
            b.field("disable_objects", true);  
        assertEquals("prod1", idFields[0].stringValue());  
                    b.endObject();  
        // Verify flat field storage
    public void testDynamicDottedFieldNameLongArrayWithExistingParent() throws Exception {
    public void testParseNonDynamicArrayWithNullValuesDisableObjects() throws Exception {
            ParsedDocument doc = mapper.parse(source(b -> b.field("field.bar", Collections.singletonMap("key", "value"))));
                }  
                b.startObject();
                }
        assertNotNull(bazMapper);
    public void testDynamicStrictLongArray() throws Exception {
                {  
        assertEquals("It is forbidden to create dynamic nested objects ([foo]) through `copy_to` or dots in field names", e.getMessage());
                        b.startObject("mapping").field("type", "object").endObject();
                {  
            b.startObject("a");
            {  
    }
            b.endObject();
        DocumentMapper defaultMapper = createDocumentMapper(mapping(b -> {}));  
                        b.field("inner3_field1", "inner3_value1");
                            .field("sub-field", "true")
                    b.startObject("big-integer-to-keyword");  
        assertThat(doc.rootDoc().get("type.test1"), equalTo("value1"));
    public void testDynamicAllowTemplatesStrictLongArray() throws Exception {  
                {
                    b.endArray();
                    b.nullField("age"); // This should trigger the exception for null value  
            b.startObject("user");  
                b.field("type", "nested");  
            "Could not dynamically add mapping for field [field.bar.baz]. "
            () -> mapper.parse(source(b -> b.field("field.bar.baz", 0)))
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {  
            for (int i = 1; i < depth_limit - 1; i++) {
                    }
            b.field("dynamic", "strict_allow_templates");
    }
        assertThat(
            b.field("dynamic", "true");  
        DocumentMapper docMapper = createDocumentMapper(mapping(b -> {}));
                    {  
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "false_allow_templates")));
        assertEquals(0, doc.rootDoc().getFields("bool_field").length);
            {
    }
        assertNotNull(mapping);
                }  
                    b.endObject();
    public void testDynamicFalseDottedFieldNameObject() throws Exception {  
                }
        // This happens when we have null values within flattened objects/arrays in disable_objects mode
        }));
            b.startObject("bar").field("type", "integer").endObject();
        ParsedDocument doc2 = mapper.parse(source(b -> {
                {
                        b.field("match", "test");  
        // This should create a single flat field  
        // Even though we matched the dynamic format, we do not match on numbers,
        assertEquals("exactmatch", doc5.rootDoc().getField("a.b.c").stringValue());  
 */
                ((FieldMapper) m).fieldType().isSearchable()
        assertThat(doc.rootDoc().get("type.test2"), equalTo("value2"));  
                {
        }));
        StrictDynamicMappingException exception = expectThrows(
        ParsedDocument docWithTemplate = mapperWithTemplate.parse(source(b -> b.startObject("foo.bar.baz").field("a", 0).endObject()));
        // Test with single level under disable_objects parent
            b.endObject();
                {
            b.endArray();
        assertEquals(75.5f, flatDoc.rootDoc().getField("metrics.cpu.usage").numericValue().floatValue(), 0.001f);
        ParsedDocument doc = mapper.parse(source(b -> b.startObject("foo").field("bar", "baz").endObject()));
                b.array("copy_to", "location_copy1", "location_copy2");
        // check parsing success for nested array within allowed depth limit
            }
                () -> mapper.parse(
            b.field("disable_objects", true);
                    b.field("item.category.name", "books");
                b.startObject("level2");  
                    }  
                    b.endObject();
                    {  
                b.startObject();  
        assertNotNull(doc.rootDoc().getField(IdFieldMapper.NAME));
        // Test edge case with deeply nested structure  
                        b.startObject("mapping").field("type", "float").endObject();
        assertThat(barMapper, instanceOf(ObjectMapper.class));
        });
            () -> documentMapperWithDynamicTemplates.parse(source(b -> b.startObject("foo.bar.baz").field("a", 0).endObject()))
 * license agreements. See the NOTICE file distributed with
        // Test that existing field mappers work correctly with disable_objects
                b.startObject();
                    b.endArray();  
        assertThat((String) docMapper.meta().get("param1"), equalTo("value1"));
        }));  
                }
                    b.field("type", "object");
        Mapper dateMapper = update.root().getMapper("foo");  
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "strict")));
    }
        assertEquals(2, result.docs().size());
                b.endObject();
            b.endArray();  
                    b.endObject();
        // This should create a field with the flattened name  
        assertEquals(
                    b.field("type", "integer");
            b.field("dynamic", "false_allow_templates");  
                }
        DocumentMapper documentMapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "strict_allow_templates")));
                    {
        ParsedDocument docWithTemplate = mapperWithTemplate.parse(source(b -> b.field("float_field", "123.45")));  
     */  
        ParsedDocument doc = mapper.parse(source(b -> b.field("foo", "2016 12")));  
        assertThat(doc.rootDoc().get("type.inner.inner_field"), equalTo("inner_value"));
                                    b.field("type", "object");
                    b.field("value", 200);
                    {
                    b.endObject();
    public void testDynamicFalseDottedFieldNameLongArray() throws Exception {  
        IndexableField[] fields = doc.rootDoc().getFields("nested_arrays");
        ));
        assertNotNull(xMapper);
                }
        assertNotNull(doc.dynamicMappingsUpdate());
                                b.startObject("level3");
        assertNotNull(((ObjectMapper) xMapper).getMapper("bar"));  
                    b.endObject();
                        b.startObject("mapping").field("type", "keyword").endObject();  
            .put("index.pluggable.dataformat.enabled", true)
        merge(mapperService, dynamicMapping(mapperService.documentMapper().parse(source(b -> {
                {
            }
                    // All nested structures will be flattened during document parsing
        {
                        b.field("match", "baz");
        assertEquals(2, doc.rootDoc().getFields("test.test1").length);
        assertTrue(barMapper instanceof ObjectMapper);
                        b.startObject("mapping").field("type", "long").endObject();
    }
                    }
                        b.field("match_mapping_type", "object");
                {
            b.endArray();
        DocumentMapper mapperWithTemplate = createDocumentMapper(topMapping(b -> {
        }));
                .endObject()
            {
        DocumentMapper mapper = createDocumentMapper(MapperService.SINGLE_MAPPING_NAME, mapping);  
                        b.field("price", 99.99);
            }
                    b.field("disable_objects", true);
        assertNotNull(
    public void testDynamicStrictAllowTemplatesDottedFieldNameObject() throws Exception {
 * the Apache License, Version 2.0 (the "License"); you may
        long depth_limit = MapperService.INDEX_MAPPING_DEPTH_LIMIT_SETTING.getDefault(Settings.EMPTY);
                    }  
                    }  
        assertThat(fooMapper, instanceOf(ObjectMapper.class));
        }));
        ParsedDocument doc1 = mapper.parse(source(b -> {
        assertEquals(4, doc3.rootDoc().getFields("mixed_array.value").length); // 2 values * 2 fields each  
        );
            b.endObject();
        String mappingSource = mapperService.documentMapper().mappingSource().string();
    }  
        );
            .toString();
                    b.endObject();  
                b.startObject();
import org.opensearch.Version;  
                b.endObject();
                {
    }
            b.field("dynamic", "false_allow_templates");
        assertEquals(2, docWithTemplate.rootDoc().getFields("foo.bar.baz").length);
                        b.startObject("mapping").field("type", "object").endObject();  
        DocumentMapper docMapper = createDummyMapping();
            {  
                b.field("memory.used", 8589934592L);
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {  
        assertEquals(
                    }
        }));
                    }  
                        b.field("type", "text");
                b.field("name", "John");
                    b.startObject("test1");
            b.endObject();  
        // Verify the non-null values  
        // Test complex nested objects within arrays in disable_objects mode  
        ParsedDocument doc = mapper.parse(source(b -> b.startObject("foo.bar.baz").field("a", 0).endObject()));  
    }
        assertNotNull(doc.dynamicMappingsUpdate());
            }
        // Test the specific code path: processFlattenedTokenForDisableObjects -> processNullValueForDisableObjects  
        assertNotNull(doc);
            b.startObject("properties");  
        assertThat(aMapper, instanceOf(NumberFieldMapper.class));
        {  
            containsString("object field starting or ending with a [.] makes object resolution ambiguous: [top..foo..bar]")
        Mapper xMapper = mapping.root().getMapper("x");  
        assertNotNull("doc2 should produce dynamic mapping update", doc2.dynamicMappingsUpdate());
        DocumentMapper defaultMapper = createDocumentMapper(topMapping(b -> {
            for (int i = 1; i <= depth_limit; i++) {  
 *
import java.math.BigDecimal;
                        }  
        // Test predefined field  
            {
    }
        assertEquals("Cannot write to a field alias [alias-field].", exception.getCause().getMessage());  
    public void testNestedHaveIdAndTypeFields() throws Exception {
                    {
        }));
                b.field("type", "geo_point");
                {
                b.startObject("properties");
            {
                }
                    b.field("item.id", "item1");  
    }  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            merge(mapperService, dynamicMapping(parsedDoc.dynamicMappingsUpdate()));
            }
                b.field("copy_to", "alias-field");  
            StrictDynamicMappingException.class,  
                        b.field("disable_objects", objectDisableObjects);
                        b.startObject("mapping").field("type", "object").endObject();  
            b.field("type", "value_type");
            {
 * The OpenSearch Contributors require contributions made to  
            }  
 * Licensed to Elasticsearch under one or more contributor  
import java.util.ArrayList;
            b.endArray();
        DocumentMapper builtDocMapper = createDocumentMapper(MapperService.SINGLE_MAPPING_NAME, builtMapping);
                        b.startObject("mapping").field("type", "keyword").endObject();  
    }  
                b.field("type", "text");
            b.endObject();
            }
                b.startObject("b");  
                b.endObject();
                b.field("type", "type_value");
        // the flattened dotted field name (e.g., "app.payment") must NOT be split by
                    b.endObject();  
            }
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {
            b.startObject("obj");
            b.startArray("dynamic_templates");
        ParsedDocument doc = mapper.parse(source(b -> b.field("foo.bar.baz", 0)));
        }));
            settings,  
            }
        DocumentMapper defaultMapper = createDocumentMapper(mapping(b -> {}));
 * compatible open source license.
                    {
        assertNotNull("Dynamic field 'metrics.cpu.usage' should exist", dynamicDoc.rootDoc().getField("metrics.cpu.usage"));  
            }
        StrictDynamicMappingException exception = expectThrows(
        ParsedDocument doc2 = mapper.parse(source(b -> { b.field("a.b.c.d.e.f.g.h.i.j", "long_path"); }));
                b.startObject("deep");  
        assertEquals(
    public void testAttributes() throws Exception {  
        // First establish the mapping structure
                b.endObject();
        assertNotNull("Field 'a.b.c' should exist", doc5.rootDoc().getField("a.b.c"));
            b.startObject("attributes").field("type", "object").field("dynamic", true).field("disable_objects", true).endObject();
            b.startArray("dynamic_templates");
            // NOT an ObjectMapper for "app"  
    public void testParseDocumentWithDocumentInputPropagated() throws Exception {  
            StrictDynamicMappingException.class,  
            "address.city should not be a multi-field of address",
    public void testDynamicDottedFieldNameLongWithParentTemplate() throws Exception {  
        Document doc = docMapper.parse(new SourceToParse("test", "1", json, MediaTypeRegistry.JSON)).rootDoc();
                        b.startObject("mapping").field("type", "nested").endObject();  
        assertThat(aMapper, instanceOf(NumberFieldMapper.class));
    public void testWriteToFieldAlias() throws Exception {
        assertNotNull(doc.rootDoc().getField("foo.bar.baz"));
                        b.field("match", "target_*");  
                    b.endObject();
            {
        }));
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
        assertThat(bazMapper, instanceOf(ObjectMapper.class));
        assertThat(doc.rootDoc().get("type.type.type_field"), equalTo("type_value"));
        assertNotNull("Dynamic mapping update should be created", mappingUpdate);  
            .endObject()  
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
                        b.endObject();
            MapperParsingException.class,
        String mapping = copyToStringFromClasspath("/org/opensearch/index/mapper/simple/test-mapping.json");  
        assertEquals(
                {  
        MapperParsingException e = expectThrows(  
                b.endObject();
        ParsedDocument doc = mapper.parse(source(b -> b.startArray("foo").value(0).value(1).endArray()));  
        assertNull(result.docs().get(1).getField(NestedPathFieldMapper.NAME));
                        b.startObject("name");  
            {
        ParsedDocument doc = mapper.parse(source(b -> {
                        {
            assertNull(doc.rootDoc().getField("field"));
        }));  
            b.endObject();
            }
                () -> mapper.parse(source(b -> b.nullField(MockMetadataMapperPlugin.MockMetadataMapper.CONTENT_TYPE)))
        assertEquals(  
 * Modifications Copyright OpenSearch Contributors. See
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "false_allow_templates")));
            exception.getMessage()
                + "Existing mapping for [field] must be of type object but found [long].",  
    }
            b.startObject("field");  
        assertThat(doc.rootDoc().get("inner.inner_field"), equalTo("inner_value"));
                b.endObject();
        })).rootDoc();  
        IndexableField[] idFields = doc.rootDoc().getFields("products.id");
                    b.startObject("coordinates");
            b.field("dynamic", "strict");
            b.startObject("level1");
                {
            }  
    public void testDynamicRootFallback() throws Exception {
                        b.endObject();
            ParsedDocument doc = mapper.parse(source(b -> b.field("field.bar", 111)));
            b.field("dynamic", "strict");  
                b.endObject();
                b.endObject();
        );
            b.endArray();
        DocumentMapper documentMapperWithDynamicTemplates = createDocumentMapper(topMapping(b -> {
        assertThat(doc.get(docMapper.mappers().getMapper("name.first").name()), equalTo("fred"));  
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "long")));  
        // Comprehensive test for root-level disable_objects functionality
            b.endArray();  
                b.endObject();  
        Mapper barMapper = ((ObjectMapper) fooMapper).getMapper("bar");
            () -> mapper.parse(source(b -> b.startArray("foo.bar.baz").value(0).value(1).endArray()))
                b.endObject();  
                b.startObject();
            }
        DocumentMapper mapper = createDocumentMapper(mapping(b -> b.startObject("field").field("type", "text").endObject()));
        // Null fields should not be created
import org.opensearch.plugins.Plugin;
        assertTrue(subxMapper instanceof ObjectMapper);  
                .endObject()
            b.startObject("foo");
            b.endObject();
                b.field("test2", "value2");
    public void testParseDocumentWithDocumentInputAndNestedFields() throws Exception {  
                    }
                b.startObject();
                    b.endObject();
        ParsedDocument doc = mapper.parse(source(b -> b.startObject("field.bar.baz").field("a", 0).endObject()));
        }));
        }));
        }));
        }));
                b.startObject();
        {  
                        b.startObject("mapping").field("type", "long").endObject();
        }));  
            b.startArray("dynamic_templates");
        // Test nested arrays  
        // With pluggable data format, text field should NOT have .keyword multi-field
import java.util.List;
        assertThat(doc.rootDoc().get("type"), equalTo("value_type"));
        // Test another case with multiple segments to flatten
        Mapper textMapper = doc.dynamicMappingsUpdate().root().getMapper("dynamic_text");
package org.opensearch.index.mapper;
        // which are too likely to be false positives
    public void testDynamicBigInteger() throws Exception {  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> mapperService.documentMapper().parse(source(b -> {
        }));
                    }
                            b.field("type", "text");
            b.endArray();
                b.field("baz", 789);  
    public void testDotsWithDynamicNestedMapper() throws Exception {  
        }  
        Mapper xMapper = mapping.root().getMapper("x");
        // Test the specific flattening logic in getMapper function
            // The flat field "metrics.cpu.cores" should exist
        // Nested document:  
        merge(mapperService, dynamicMapping(doc2.dynamicMappingsUpdate()));  
                b.startObject("outer");  
                    b.startObject("test");  
            {
                    {  
    }
            "Field 'level1.level2.level3.deep.nested.field.name' should exist",
                b.endObject();  
            b.startObject("type");
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "false")));
        updates.add(new MockFieldMapper("x.foo"));
                b.field("type", "geo_point");  
                        b.field("type", "text");  
                        b.field("match", "target_*");
                        b.field("name", "Product 1");
                }  
    }
    public void testDynamicFalseNull() throws Exception {  
        ParsedDocument result = mapper.parse(source(b -> {  
        assertThat(doc.rootDoc().get("type.test2"), equalTo("value2"));  
        // Dynamic mapping update expected since "address.city" and "address.state" are not pre-defined
            b.endObject();
        assertNotNull(bazMapper);  
            b.startObject("type");
            }
            b.startObject("properties");  
import static org.opensearch.test.StreamsUtils.copyToStringFromClasspath;  
            b.endObject();
        List<Mapper> updates = Collections.singletonList(new MockFieldMapper("x.subx.foo"));  
        }
        Mapper bazMapper = ((ObjectMapper) barMapper).getMapper("baz");
        assertNotNull(bazMapper);  
        assertThat(exception3.getMessage(), containsString("user.age"));  
                {
                        b.startObject("mapping").field("type", "long").endObject();  
        // 3. Look for field "deep.nested.field.name" under level3 mapper  
        );
        );  
                    }  
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {}));  
        assertNotNull(copiedFields);
            StrictDynamicMappingException.class,  
        Mapper bazMapper = ((ObjectMapper) barMapper).getMapper("baz");
                b.startObject("foo");
            assertNull(doc.rootDoc().getField("field.bar"));
    }  
        assertThat(fooMapper, instanceOf(ObjectMapper.class));
            b.endArray();
    }  
        assertNotNull("Field 'user.age' should exist", doc.rootDoc().getField("user.age"));  
        );
    }
                        b.endObject();
                assertNotNull("FieldMapper 'app.payment' should exist as flat field under LogAttributes", appPaymentMapper);
                    b.startObject("test");
                            }
            }  
            MapperParsingException e = expectThrows(
import java.nio.charset.StandardCharsets;
        })).dynamicMappingsUpdate()));  
        }
                            b.field("sub", "tablets");
        updates.add(new MockFieldMapper("x.bar"));
        );  
            b.endArray();
        assertThat(exception.getMessage(), containsString("strict"));  
        assertEquals("address.city should be text", "text", mapperService.fieldType("address.city").typeName());  
import org.opensearch.common.settings.Settings;
        // Test with very deep nesting to exercise the path reconstruction loop
                }  
        e = expectThrows(
                    b.endObject();
            }
                            b.field("type", "object");
        // Should have 2 instances of each field (one for each object in the array)
                b.startObject("bar").field("baz", "something").endObject();
        updates.add(createObjectMapper(mapperService, "foo.bar"));  
                    b.field("disable_objects", true);  
    }
            b.startArray("mixed_array");
                b.endObject();  
            {
                {
import org.apache.lucene.index.IndexableField;
        ParsedDocument doc = mapper.parse(source(b -> b.nullField("bar")));
            }
                    {
            b.field("type", "geo_point");  
                b.field("test1", "value1");
        // Test array with null values mixed with regular values
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {  
            {  
            {
                        b.startObject("mapping").field("type", "long").endObject();  
                    {
            b.endObject();
                b.endObject();
        Mapper inner3_mapper = ((ObjectMapper) inner2_mapper).getMapper("inner3");
        assertEquals(6, fields.length);
        );
                    {
        // the getMapper function should:  
        BytesReference json = new BytesArray("".getBytes(StandardCharsets.UTF_8));
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "false")));
        ParsedDocument doc = mapper.parse(source(b -> b.field("bool_field", true)));  
                b.startObject();  
        assertEquals("test1", doc1.rootDoc().getField("level1.level2.level3.simple.field").stringValue());  
        assertEquals(0, doc.rootDoc().getFields("float_field").length);
                    b.startObject("target_template");
    }
        assertEquals("value2", doc3.rootDoc().getField("a.b.c.single").stringValue());  
        BigInteger value = BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.ONE);  
            b.startArray("top.");  
            {  
                b.startObject("user");
    }  
            }  
            .numberOfShards(1)
        DocumentMapper docMapper = createDummyMapping();
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {}));
                    b.endObject();  
    }
                }
                }  
        // Test the root-level flattening logic in getMapper function  
        assertNotNull(((ObjectMapper) subxMapper).getMapper("b"));
     * default to not-indexed, just like explicitly mapped ones — otherwise inferred fields would keep  
            {
    }
        );
                b.endObject();  
        exception = expectThrows(
            }
                b.endObject();
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
        assertNotNull("Field 'user.name' should exist", doc.rootDoc().getField("user.name"));  
        ParsedDocument docWithTemplate = mapperWithTemplate.parse(source(b -> b.startArray("foo.bar.baz").value(0).value(1).endArray()));  
            for (int i = 1; i < depth_limit; i++) {  
        ParsedDocument doc = mapper.parse(source(b -> b.field("field.bar.baz", 0)));  
    public void testDynamicStrictValue() throws Exception {  
            b.endObject();
    public void testGeoPointArrayWithMultipleCopyTo() throws Exception {
        assertEquals(456, fields[2].numericValue());
        }));  
        ParsedDocument doc = defaultMapper.parse(source(b -> {  
                    b.field("name", "john"); // This has existing mapping, should work
        // Verify in the case where only a single type is allowed that the _id field is added to nested documents:
            for (int i = 1; i <= depth_limit; i++) {
        assertNotNull(doc);  
        assertEquals(
                }
                {
            b.field("dynamic", false);
                        b.field("match_mapping_type", "object");
            b.startArray("mixed_nulls");  
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
        IndexableField[] copiedFields = doc.rootDoc().getFields("location_copy");
            () -> documentMapper.parse(source(b -> b.startArray("foo").value(0).value(1).endArray()))
            assertNull("ObjectMapper 'metrics.cpu' should NOT exist at root", metricsCpuMapper);
                    }  
            b.field("dynamic", false);  
        // This tests the code path: parseNonDynamicArray -> processFlattenedTokenForDisableObjects
            b.endObject();
                        b.field("match_mapping_type", "object");
                    b.endObject();
        }
    }
        ParsedDocument docA = ms2.documentMapper().parse(source("""
            b.endObject();
                    }  
        })));  
            b.field("dynamic", "false_allow_templates");
        assertEquals(2, doc.rootDoc().getFields("foo.bar.baz").length);  
                        b.field("match", "float_*");
    public void testNoLevelWithFieldTypeAsObject() throws Exception {
                    }
        assertThat(barMapper, instanceOf(ObjectMapper.class));  
        assertNotNull("doc1 should produce dynamic mapping update", doc1.dynamicMappingsUpdate());  
        assertThat(bazMapper, instanceOf(NumberFieldMapper.class));  
            b.field("dynamic", "false_allow_templates");  
        ParsedDocument doc = mapper.parse(source(b -> b.field("dynamic_field", "value")), mockInput);  
import java.util.Collection;  
                {
                    b.endObject();  
            .put("index.version.created", Version.CURRENT)
        BytesReference json = new BytesArray(copyToBytesFromClasspath("/org/opensearch/index/mapper/simple/test1.json"));  
    public void testDynamicFieldsStartingAndEndingWithDot() throws Exception {
        }), mockInput);  
        assertEquals("flattened_value", doc2.rootDoc().getField("level1.level2.level3.deep.nested.field.name").stringValue());
        }));
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {
        assertThat(exception.getMessage(), containsString("user.age"));
            b.field("disable_objects", true);  
                b.startObject();  
            b.startObject("properties");
        assertNotNull(doc.rootDoc().getField("point"));  
        // This covers the first StringBuilder flatFieldName code block
        IllegalArgumentException emptyFieldNameException = expectThrows(IllegalArgumentException.class, () -> mapper.parse(source(b -> {
                    {
    }
            MapperException exception = expectThrows(MapperException.class, () -> mapper.parse(source(b -> b.field("foo", true))));  
            {
            b.endArray();
        assertNotNull("Field 'level1.level2.level3' should exist", doc4.rootDoc().getField("level1.level2.level3"));
        ParsedDocument doc1 = mapperService.documentMapper().parse(source("""
            b.field("disable_objects", true);
        // Test 3: Default behavior (disable_objects=false)  
        assertEquals(0, doc.rootDoc().getFields("foo.bar.baz").length);  
        }));
                    b.startObject("inner").field(".", 2).endObject();
                b.endObject();  
                        b.startObject("mapping").field("type", "long").endObject();
        Mapper barMapper = ((ObjectMapper) fooMapper).getMapper("bar");  
            b.startArray("top");  
            }
                    b.endObject();  
        ParsedDocument doc = mapper.parse(source(b -> b.field("bigint_field", bigInt)));
            b.field("dynamic", "strict_allow_templates");
                    }
        });
            b.field("doc_values", false);
            b.startObject("inner").field("inner_field", "inner_value").endObject();  
                {
        Settings pluggableSettings = Settings.builder()
                    b.endObject();
                b.endObject();  
        assertEquals("mapping set to strict, dynamic introduction of [foo] within [_doc] is not allowed", exception.getMessage());  
                    b.endObject();
        assertTrue(copy2Fields.length > 0);  
                    b.startObject("test1");
    public void testDynamicFalseAllowTemplatesWithBooleanDetection() throws Exception {
            b.startObject("inner1");  
    }
            b.field("dynamic", "strict_allow_templates");  
            {
        ParsedDocument doc = mapper.parse(source(b -> b.startArray("foo.bar.baz").value(0).value(1).endArray()));  
                b.startObject();  
        assertEquals(0, doc.rootDoc().getFields("foo.bar.baz").length);
            .endObject()
        assertThat(barMapper, instanceOf(ObjectMapper.class));  
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "false")));  
            b.field("dynamic", false);
        // Verify no intermediate ObjectMapper "metrics" or "metrics.cpu" was created
            StrictDynamicMappingException.class,
            exception.getMessage()
        // Test with very long dotted path
    public void testDynamicDottedFieldNameLongWithExistingParent() throws Exception {
            b.startArray("dynamic_templates");
            assertNotNull("expected a dynamic mapping for [" + field + "]", m);
                b.startObject();
                        b.startObject("mapping").field("type", "object").endObject();
            () -> documentMapperWithDynamicTemplates.parse(source(b -> b.startArray("foo").value(0).value(1).endArray()))  
        assertNotNull(
        // Test 3: Null value in flattened object with default dynamic mapping should be handled gracefully  
            b.endObject();
                    b.field("type", "integer");
            {
        ParsedDocument doc = mapper.parse(source(b -> b.field("foo.bar.baz", 0)));
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
            {
                b.endObject();
                b.field("type", "object");
        ParseContext context = new ParseContext.InternalParseContext(
        assertNotNull(barMapper);
                            b.field("doc_values", false);
                {
        ParsedDocument doc = mapper.parse(source(b -> b.field("date_field", "2023-12-25")));
                        b.startObject("level2");
                    b.startObject("inner").field("type", "keyword").endObject();  
        assertNotNull(fooMapper);
                    {
                            {
                {  
                b.endObject();
            assertThat(exception.getMessage(), containsString("failed to parse field [bar] of type [boolean] in document with id '1'"));
                {
        {
                    b.startObject("test");
            {  
 * SPDX-License-Identifier: Apache-2.0
 *     http://www.apache.org/licenses/LICENSE-2.0
            IndexableField field = doc.rootDoc().getField(MockMetadataMapperPlugin.MockMetadataMapper.CONTENT_TYPE);
        merge(mapperService, dynamicMapping(doc1.dynamicMappingsUpdate()));
        ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.field("source_field", "test value")));
        assertEquals(0, doc.rootDoc().getFields("embedded_field").length);  
                {  
        }));
    }  
        StrictDynamicMappingException exception = expectThrows(
            () -> mapper.parse(source(b -> b.field("text-field", "value")))
            for (int i = 1; i < depth_limit; i++) {
            Mapper metricsMapper = dynamicUpdate.root().getMapper("metrics");
            b.endObject();  
        assertThat(dateMapper, not(instanceOf(DateFieldMapper.class)));
                b.field("type", "integer");
                b.startObject("properties");
        assertNotNull(bazMapper);
                    }
                    b.endObject();
            b.startObject("fields")
            b.startObject("nested");
    }
import static org.hamcrest.Matchers.nullValue;  
            assertTrue("'metrics.cpu.cores' should be a FieldMapper", coresMapper instanceof FieldMapper);
        }));
        assertThat(doc.rootDoc().get("type.test2"), equalTo("value2"));
        assertEquals(2, fields.length);
                                b.endObject();
        assertTrue(xMapper instanceof ObjectMapper);
    }  
                    b.field("name", "item1");  
            mapperWithExistingField.parse(source(b -> {
                    b.endObject();  
            b.startObject("source_field");  
                b.endObject();
                    b.field("type", "object");
            "mapping set to strict_allow_templates, dynamic introduction of [bar] within [_doc] is not allowed",
        ParsedDocument doc2 = mapperService.documentMapper().parse(source("""
            b.endArray();
            assertTrue(e.getMessage(), e.getMessage().contains("failed to parse field [_mock_metadata]"));
        assertThat(doc.getDocumentInput(), sameInstance(mockInput));  
            """));
                b.startObject();
                    {
            "address.city should be text after round-trip",
        assertNotNull(doc.rootDoc().getField("point"));
                b.startObject();
    public void testRootLevelDisableObjects() throws Exception {  
        }  
                    {  
        );
                }  
            b.field("dynamic", "true");
                        b.field("match", "foo*");
                        {  
        ParsedDocument doc = mapper.parse(source(b -> b.field("big-integer", value)));
        // Test 2: Only null field in flattened array with strict dynamic mapping should throw exception  
                {  
            assertNotNull("FieldMapper 'metrics.cpu.cores' should exist as flat field", coresMapper);
                + "Existing mapping for [field] must be of type object but found [long].",
            b.endObject();  
        assertThat(err.getCause(), notNullValue());  
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "value")), mockInput);
        assertNull(mapperService.fieldType("attributes.address.address.city"));
                        b.field("match", "foo*");
                    {
                {  
                }
        if (dynamicUpdate != null) {  
                    b.field("type", "object");
        Document doc = docMapper.parse(new SourceToParse("test", "1", json, MediaTypeRegistry.JSON)).rootDoc();
                    {  
            {
        }));
            {  
            }
    }  
        assertEquals(2, doc.rootDoc().getFields("products.details.name").length);  
                {  
            b.field("test2", "value2");
        }));
                }
                    {
        assertEquals("tag1", tagFields[0].stringValue());
        assertThat(bazMapper, instanceOf(NumberFieldMapper.class));
            b.field("disable_objects", true);
    public void testGenerateGroupingCriteriaFromScript() throws Exception {
        ParsedDocument doc = defaultMapper.parse(source(b -> {  
                    }
        DocumentMapper mapperWithTemplate = createDocumentMapper(topMapping(b -> {  
            }  
            b.field("inner", "test");
    }
    }
        StrictDynamicMappingException exception3 = expectThrows(StrictDynamicMappingException.class, () -> {
        Mapper keywordSubField = textMapper.iterator().next();
        assertNotNull("Field 'metrics.cpu.usage' should exist", flatDoc.rootDoc().getField("metrics.cpu.usage"));  
            Mapper metricsCpuMapper = dynamicUpdate.root().getMapper("metrics.cpu");  
                b.endObject();
            {
            {
        ParsedDocument doc = mapper.parse(source(b -> b.startObject("foo.bar.baz").field("a", 0).endObject()));
                b.field("test2", "value2");
        ParsedDocument doc = mapper.parse(source(b -> b.field("embedded_field", "value")));
                }
        Mapping mapping = DocumentParser.createDynamicUpdate(docMapper.mapping(), docMapper, updates);  
        ParsedDocument doc1 = mapperService.documentMapper().parse(source("""
                b.endObject();
            }
        assertNotNull(doc.dynamicMappingsUpdate());  
                b.endObject();
 * You may obtain a copy of the License at  
            .build();
            b.startObject("properties");
                            b.startObject("bar.");
                    }  
                b.endObject();  
            b.endArray();  
            b.startObject("name");  
        Mapper inner2_mapper = ((ObjectMapper) objMapper).getMapper("inner2");
        ParsedDocument doc = mapper.parse(source(b -> b.field("foo", "1234")));
                        b.field("match", "foo");  
                b.startObject("properties");
        // after throwing exception
            .build();  
            }  
        assertNull(doc.dynamicMappingsUpdate()); // no update since we reused the existing type  
        Mapper bazMapper = ((ObjectMapper) barMapper).getMapper("baz");
                }  
        );
            }  
        assertThat(exception2.getMessage(), containsString("strict"));  
        MapperParsingException exception = expectThrows(
        assertEquals(0, doc.rootDoc().getFields("foo.bar.baz").length);  
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "false")));
            b.startArray("dynamic_templates");  
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "strict")));
                b.endObject();  
        assertNotNull(update); // dynamic mapping update
        Mapper xMapper = mapping.root().getMapper("x");  
        BigDecimal bigDecimal = BigDecimal.valueOf(Double.MAX_VALUE).add(BigDecimal.valueOf(10.1));
            b.field("disable_objects", true);
                {  
        assertNotNull("Field 'a.b.c.d.e.f.g.h.i.j' should exist", doc2.rootDoc().getField("a.b.c.d.e.f.g.h.i.j"));
            b.startObject("properties");
                b.startObject();
                {
                        b.field("path_match", "foo.bar.baz");
    public void testDisableObjectsBasicFunctionality() throws Exception {
        assertThat(e.getCause().getMessage(), containsString("field name cannot contain only the character [.]"));  
            }  
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "false_allow_templates")));
        assertThat(emptyFieldNameException.getMessage(), containsString("object field cannot contain only whitespace: ['top.aoeu. ']"));
                b.endObject();
        ParsedDocument docWithTemplate = mapperWithTemplate.parse(source(b -> b.field("bigint_field", bigInt)));
                {
        assertNull("Null field should not be created", doc.rootDoc().getField("mixed_nulls.null_field"));
    }
                        {
                b.startObject();
    }
                b.startArray("foo" + 1);
        assertThat(doc.rootDoc().get("test2"), equalTo("value2"));
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("enabled", false)));
    }
                    }  
        DocumentMapper mapperWithTemplate = createDocumentMapper(topMapping(b -> {  
        assertThat(doc.rootDoc().get("test1"), equalTo("value1"));  
                {
                        b.startObject("mapping").field("type", "keyword").endObject();  
                    {
                    b.startObject("test1");
                    b.field("disable_objects", true);
                    }  
                }
                    b.startObject("georule");  
            b.endArray();  
                b.startObject("inner");
    }
                    b.endObject();
        StrictDynamicMappingException exception = expectThrows(
        assertNotNull(copiedFields);  
    public void testRootMapperNameVariations() throws Exception {  
            () -> mapper.parse(source(b -> { b.startObject("..").field("foo", 2).endObject(); }))
    public void testDynamicFalseAllowTemplatesWithNestedCopyTo() throws Exception {  
            b.field("dynamic", "true");
                    {
        assertThat(e.getCause().getMessage(), containsString("field name cannot contain only the character [.]"));
            b.startObject("metrics");  
            {
        assertNotNull(update); // dynamic mapping update  
        // Should throw exception when trying to add new field with strict mapping
            b.endArray();  
    public void testNoLevel() throws Exception {
            b.field("disable_objects", true);
            "text",
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
        ParsedDocument doc = mapper.parse(source(b -> b.startObject("foo").field("bar", "something").endObject()));  
            }  
                    b.startObject();
        }));
    }
                b.startObject();
    }
                        b.field("inner3_field2", "inner3_value2");
        assertNotNull("Field 'product.price' should exist", doc.rootDoc().getField("product.price"));
        merge(mapperService, dynamicMapping(doc1.dynamicMappingsUpdate()));
        DocumentMapper mapperWithDynamic = createDocumentMapper(topMapping(b -> {
                }
        StrictDynamicMappingException exception = expectThrows(
                }
        Mapper inner1_field1_mapper = ((ObjectMapper) objMapper).getMapper("inner1_field1");  
            {
        assertNotNull(fooMapper);
        assertThat(doc.getDocumentInput(), sameInstance(mockInput));
                        b.endObject();
                    {
        assertNull("Null field 'product.description' should not be created", doc.rootDoc().getField("product.description"));
                        b.startObject("mapping").field("type", "object").endObject();
            {
        ParsedDocument docWithTemplate = mapperWithTemplate.parse(source(b -> b.field("bigdecimal_field", bigDecimal)));
    public void testDynamicStrictNull() throws Exception {  
        }));
            Mapper coresMapper = dynamicUpdate.root().getMapper("metrics.cpu.cores");  
            b.field("dynamic", true);  
        ParsedDocument doc = mapper.parse(source(b -> b.startArray("foo").value(0).value(1).endArray()));  
                        b.startObject("mapping").field("type", "object").endObject();  
        DocumentMapper mapperWithTemplate = createDocumentMapper(topMapping(b -> {  
                b.endObject();  
            b.field("dynamic", "strict_allow_templates");
                    b.endObject();
                        b.field("inner3_field1", "inner3_value1");
        DocumentMapper defaultMapper = createDocumentMapper(mapping(b -> {}));
        assertThat(barMapper, instanceOf(ObjectMapper.class));
        assertThat(e.getCause(), notNullValue());  
            b.startArray("dynamic_templates");  
                b.field("blub", 222);  
        ParsedDocument docWithTemplate = mapperWithTemplate.parse(source(b -> b.field("embedded_field", "value")));
                    b.startObject("test");
            }  
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {  
            {  
    }
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {}));
                    b.endObject();
                b.startObject();
        }));
        assertNotNull(textMapper);
            recoveredService.fieldType("attributes.address.state").typeName()  
                        b.startObject("mapping").field("type", "object").endObject();
            // A metadata field that parses a value fails to parse a null value
import org.opensearch.index.engine.dataformat.DocumentInput;  
        ParsedDocument doc = mapper.parse(source(b -> b.field("foo.bar.baz", 0)));
            StrictDynamicMappingException.class,  
                    {
    }
        assertEquals(1, doc.rootDoc().getFields("target_field").length);  
        assertNotNull("doc1 should produce dynamic mapping update", doc1.dynamicMappingsUpdate());  
                    b.startObject("test");
        assertEquals(4, doc.rootDoc().getFields("foo").length);
                    {
        // Dynamic mapping update expected since "address.city" is not pre-defined  
                    }
        ParsedDocument dynamicDoc = dynamicMapper.parse(source(b -> {  
    public void testDynamicFalseAllowTemplatesDottedFieldNameLongArray() throws Exception {  
                        b.field("match", "foo");
                        b.startObject("d");
                    b.field("type", "object");  
    public void testMappedLongArray() throws Exception {
                {
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "value")), null);
                    b.startObject("test");  
        );
            {
                b.nullField("description"); // This null field should not create a field via processFlattenedTokenForDisableObjects
            }  
    }  
    public void testDynamicStrictDottedFieldNameLongArray() throws Exception {  
            b.startArray("dynamic_templates");
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "strict")));
    public void testPathSplittingAndReconstructionInExistingMapperLookup() throws Exception {
    }  
            b.field("dynamic", "false_allow_templates");
            }
                }  
    }  
            MapperParsingException.class,
                b.startObject();
        assertEquals(2, doc.rootDoc().getFields("foo.bar.baz").length);  
            assertNull(doc.rootDoc().getField("field"));
        }));
            {  
            b.field("dynamic", "true");  
import static org.hamcrest.Matchers.instanceOf;  
        // Assert address.city is NOT treated as a multi-field of address  
        DocumentMapper flatFieldMapper = createDocumentMapper(topMapping(b -> {
        if (parsedDoc.dynamicMappingsUpdate() != null) {
        assertNotNull(barMapper);  
            b.endObject();
        Mapper aMapper = ((ObjectMapper) bazMapper).getMapper("a");  
                b.endObject();
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {}));
        assertEquals(1, doc.rootDoc().getFields("source_field").length);
            "mapping set to strict_allow_templates, dynamic introduction of [foo] within [_doc] is not allowed",
                    b.startObject("inner3");
                    {
        assertNotNull("Field 'outer.literal.field.name' should exist", doc3.rootDoc().getField("outer.literal.field.name"));
        }  
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "false")));
        ParsedDocument doc = mapper.parse(source(b -> {
        assertNotNull("Field 'products.details.category.sub' should exist", doc.rootDoc().getField("products.details.category.sub"));
            b.field("dynamic", "false_allow_templates");
                }
                    b.startObject("target_template");
            {
            }
                .field("ignore_above", 256)
                    b.endObject();
        }));
            """));  
        assertEquals("dynamic_text.keyword", keywordSubField.name());
        }));
                    b.value(2);  
                b.endObject();
        }));  
        assertTrue(xMapper instanceof ObjectMapper);
                        }
                    b.endObject();
    public void testParseDocumentWithoutDocumentInputDefaultsToNull() throws Exception {  
                b.field("copy_to", "target_field");  
            assertTrue(e.getMessage(), e.getMessage().contains("failed to parse field [_mock_metadata]"));
        }));  
                b.endObject();
                b.endArray();  
        ParsedDocument doc = mapper.parse(source(b -> b.field("bigdecimal_field", bigDecimal)));
                )
        assertThat(doc.rootDoc().get("type.test1"), equalTo("value1"));  
        ParsedDocument doc1 = mapper.parse(source(b -> { b.field("root.level.dotted.field", "root_flattened"); }));
                        b.field("match_mapping_type", "string");  
            }
                        b.startObject("cpu.usage");
        assertEquals(30, doc.rootDoc().getField("user.age").numericValue().intValue());
                        b.field("match", "embedded_*");
        // Root-level disable_objects with dynamic fields that have prefix conflicts  
                {
                        b.startObject("mapping").field("type", "long").endObject();
        assertThat(doc.rootDoc().get("inner.inner_field"), equalTo("inner_value"));
        assertNotNull(barMapper);  
                    {  
                    }  
            b.startArray("nested_arrays");
        }
    public void testCopyToFieldAlias() throws Exception {  
        assertEquals("tag2", tagFields[1].stringValue());  
    public void testTypeLevelWithFieldTypeAsObject() throws Exception {  
        }
                {
                    {
                }  
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {
import static org.hamcrest.Matchers.notNullValue;
        if (dynamicUpdate != null) {
        err = expectThrows(  
            b.field("dynamic", "false_allow_templates");
                    }  
        DocumentMapper mapper = createDocumentMapper(mapping(b -> b.startObject("field").field("type", "text").endObject()));
     * Dynamically inferred numeric, date and boolean fields on a pluggable-dataformat index must
                b.endObject();  
                b.startObject();  
        assertEquals(4, doc.rootDoc().getFields("foo.bar.baz").length);
                    {  
                {
/*
                    b.startObject("test2");
                        b.field("match", "foo*");
            "mapping set to strict_allow_templates, dynamic introduction of [foo] within [_doc] is not allowed",  
    public void testTypeLevelWithFieldTypeAsValue() throws Exception {
                                b.startObject("aoeu").field("a", 1).field("b", 2).endObject();
            }  
                    b.endObject();
            assertNull(doc.rootDoc().getField("bar"));  
                        b.startObject().field("thing", "bah").endObject();
        Mapping mapping = DocumentParser.createDynamicUpdate(docMapper.mapping(), docMapper, updates);
            b.endObject();  
                b.startObject();
    public void testGeoPointArrayWithCopyTo() throws Exception {
    public void testDynamicGeoPointArrayWithTemplate() throws Exception {
                b.startObject();
        ParsedDocument doc5 = mapper.parse(source(b -> { b.field("a.b.c", "exactmatch"); }));  
                x.startObject("status_code");  
                    b.endObject();  
            b.endObject();
        assertEquals(new BytesRef(value.toString()), fields[0].binaryValue());
                b.field("type", "geo_point");
        assertNotNull(mapping);
            }
    public void testTypeLevelWithFieldTypeAsObjectNotFirst() throws Exception {
                {  
                    }
            b.startObject("attributes").field("type", "object").field("dynamic", true).field("disable_objects", true).endObject();
        Mapper fooMapper = doc.dynamicMappingsUpdate().root().getMapper("foo");
            "Cannot add a value for field [field.bar] since one of the intermediate objects is mapped as a nested object: [field]",
            b.startObject("properties");
                        b.field("match", "bar");  
                            b.endObject();  
        Mapper aMapper = ((ObjectMapper) bazMapper).getMapper("a");  
            b.endArray();  
        assertNotNull(xMapper);
    public void testDisableObjectsMappingRecoveryWithPrefixConflict() throws Exception {
        exception = expectThrows(  
                        b.field("lon", -74.0060);
        );
        // in this case, we analyze the type object as the actual document, and ignore the other same level fields  
                b.startObject("user");  
            b.field("dynamic", "true");
        assertNotNull("doc2 should produce dynamic mapping update", doc2.dynamicMappingsUpdate());
        ParsedDocument doc = mapper.parse(source(b -> b.field("dynamic_text", "hello world")));
        assertNotNull(doc.rootDoc().getField("obj.inner"));  
            b.startObject("metrics");  
        DocumentMapper rootMapper = createDocumentMapper(topMapping(b -> {
    public void testExistingMapperLookupWithDisableObjectsParent() throws Exception {
        // Verify that the geo_point field itself exists
            StrictDynamicMappingException.class,  
        assertNotNull(doc);  
                {
            .put("index.pluggable.dataformat.enabled", true)  
        );  
                {  
        }));
                    b.value(1);
            }  
            "Could not dynamically add mapping for field [field.bar.baz]. "  
                    }  
        assertNotNull("Field 'mixed_nulls' should exist", doc.rootDoc().getField("mixed_nulls"));  
        assertFalse("Text field should not have keyword multi-field with pluggable dataformat", textMapper.iterator().hasNext());  
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
        // Dynamic mapping update expected since "address" is not pre-defined
                    b.startObject("georule");  
            {
                        b.startObject("mapping").field("type", "keyword").endObject();
            "text",  
import static org.opensearch.test.StreamsUtils.copyToBytesFromClasspath;
    public void testDotsWithExistingNestedMapper() throws Exception {
        }
    public void testDynamicTextFieldWithoutKeywordMultiFieldForPluggableDataFormat() throws Exception {
        }));
                    b.field("type", "object");
    }
                b.endObject();
                    b.startObject("float_template");  
            b.endObject();
                }
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "false_allow_templates")));
                    {
                b.value("value2");
        MapperParsingException exception = expectThrows(  
                        }
    public void testDynamicStrictAllowTemplatesObject() throws Exception {
        assertNotNull("Field 'products.details.category.main' should exist", doc.rootDoc().getField("products.details.category.main"));
        }));
    }  
        assertEquals("deepvalue", doc4.rootDoc().getField("a.b.c.very.deep.nested.field.with.many.levels").stringValue());  
            doc2.rootDoc().getField("level1.level2.level3.deep.nested.field.name")  
            b.endArray();
        Mapper fooMapper = doc.dynamicMappingsUpdate().root().getMapper("field");
            // A metadata field that parses a value fails to parse an object
                        b.field("match_mapping_type", "boolean");  
                b.endObject();  
            }
            {  
        // Test nested arrays within disable_objects mode
        Mapper bazMapper = ((ObjectMapper) barMapper).getMapper("baz");  
            b.startArray("dynamic_templates");
        assertNotNull(result.docs().get(0).getField(IdFieldMapper.NAME));
        }));
                    }
            .startObject("properties")
        assertThat(doc.get(builtDocMapper.mappers().getMapper("name.first").name()), equalTo("fred"));  
            b.endArray();
            {  
                {
        assertNotNull(fooMapper);
            b.endArray();
                            b.field("type", "long");  
            }
        assertThat(doc.rootDoc().get("type.test2"), equalTo("value2"));
            b.startArray("bar");
    }
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {  
            b.endArray();  
                // There should be NO "app" ObjectMapper child  
    }  
                }
            MapperParsingException.class,  
        ));
        ParsedDocument doc = defaultMapper.parse(source(b -> {  
                }
    public void testDynamicFalseDottedFieldNameLong() throws Exception {
        DocumentMapper mapper = createDocumentMapper(pluggableSettings, mapping(b -> {}));  
                }
        assertThat(err.getCause().getMessage(), containsString("field name cannot be an empty string"));
            exception.getMessage()
                b.field("bar.baz", 456);
    public void testTypeLevelWithFieldTypeAsValueNotFirst() throws Exception {
            if (objectPath != null) {
            b.endObject();
        assertNotNull("Field 'mixed_nulls.nested' should exist", doc.rootDoc().getField("mixed_nulls.nested"));
            b.endObject();
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "false_allow_templates")));
                b.startObject();  
        assertThat(exception2.getMessage(), containsString("items.category"));
    public void testTypeLevel() throws Exception {
        Mapper barMapper = ((ObjectMapper) fooMapper).getMapper("bar");
            b.endObject();
        );
            b.field("dynamic", "false_allow_templates");
                        b.field("match_mapping_type", "long");
    }
            assertEquals("mock-metadata-field-value", field.stringValue());
            {
                b.endObject();
        DocumentMapper docMapper = createDummyMapping();  
            }
        ParsedDocument doc3 = mapper.parse(source(b -> {  
        ParsedDocument doc = mapper.parse(source(b -> {
                b.startObject("a");
            () -> mapper.parse(source(b -> b.startObject("field.bar.baz").field("a", 0).endObject()))  
        DocumentMapper mapperWithTemplate = createDocumentMapper(topMapping(b -> {  
            b.startArray("dynamic_templates");
                b.field("cpu.usage", 75.5);  
                        b.field("store", "true");
                    b.field("dynamic", true);
    }
                {  
                assertTrue("'app.payment' should be a FieldMapper", appPaymentMapper instanceof FieldMapper);  
        assertNotNull(bazMapper);
            b.field("dynamic", "strict");  
            }
        }));  
                }  
                    b.startObject("test3");  
        }));
                    b.startObject(objectPath);
            b.endObject();
            assertNull(doc.rootDoc().getField("bar"));  
        assertEquals(2, doc.rootDoc().getFields("field").length);
            b.startObject("location_copy").field("type", "geo_point").endObject();  
    public void testDocumentContainsDeepNestedFieldParsingShouldFail() throws Exception {
        assertNotNull(dateMapper);
    public void testMultipleSubfieldMappingUpdate() throws Exception {
        // check parsing success for nested array within allowed depth limit  
                }  
                    b.field("type", "object");  
                b.endObject();
                b.startArray().value(1).value(1).endArray();
        updates.add(new MockFieldMapper("foo.field"));
                }
        );  
        // Test edge case where the path exactly matches the disable_objects parent
        // Test 1: Flat fields with disable_objects=true
import static org.hamcrest.Matchers.not;
                b.endObject();
                b.startObject("level1");  
                    {
            if (rootDisableObjects) {  
        assertNull(doc.rootDoc().getField("foo"));
                b.field("type", "alias");
            doc3.rootDoc().getField("level1.level2.level3.very.long.dotted.field.path")  
            b.startArray("dynamic_templates");  
                b.endObject();
                            b.startObject("properties");
        // This should work because user.name has existing mapping, but user.age should still throw exception  
        assertThat(exception.getMessage(), containsString("strict"));
                            {  
                    }  
            """));
                b.startObject("inner").field("inner_field", "inner_value").endObject();
                b.endObject();  
                assertNull("ObjectMapper 'app' should NOT exist under LogAttributes (dotted name should be kept flat)", appMapper);
        Mapping mapping = DocumentParser.createDynamicUpdate(docMapper.mapping(), docMapper, updates);
        // Verify that the field was copied to the copy_to target
        assertThat(fooMapper, instanceOf(ObjectMapper.class));  
        assertEquals("address.city should be text in reverse order", "text", ms2.fieldType("attributes.address.city").typeName());
                    {
        assertNull(doc.rootDoc().getField("foo.bar"));
            {  
            b.startArray("dynamic_templates");
        assertEquals("testvalue", doc2.rootDoc().getField("outer.deep.nested.field").stringValue());  
    @Override
            StrictDynamicMappingException.class,  
        assertNotNull(inner1_field1_mapper);
        Mapper fooMapper = mapping.root().getMapper("foo");
            b.startObject("a");
 * this work for additional information regarding copyright
                b.field("price", 999);
        ParsedDocument docWithTemplate = mapperWithTemplate.parse(source(b -> b.startArray("foo").value(0).value(1).endArray()));
                        b.field("match", "big-*");
    }
                b.startObject("app");  
                b.startObject();  
                b.startArray().value("a1").value("a2").endArray();
            b.endObject();
                    {  
            b.endArray();  
                    }
                b.startObject();
            {
                    }
 * not use this file except in compliance with the License.
        assertEquals(2, docWithTemplate.rootDoc().getFields("bool_field").length);
        assertEquals(4, docWithTemplate.rootDoc().getFields("foo").length);  
        StrictDynamicMappingException exception = expectThrows(
            }
                        b.field("match_mapping_type", "object");
                    b.endArray();
    public void testDisableObjectsWithStrictDynamicMapping() throws Exception {
            b.startObject("type");
                    {
        assertNotNull(copy1Fields);
                b.field("type", "type_value");
    public void testDynamicStrictAllowTemplatesValue() throws Exception {
            }
        // Copying to a field that is not in the mapping should not create a field in the document
        // Test the path splitting logic: String[] pathParts = fieldPath.split("\\.");
        IndexableField[] copiedFields = doc.rootDoc().getFields("location_copy");  
                        b.field("match_mapping_type", "object");
    }
                b.endArray();  
                b.startObject("bar").field("type", "integer").endObject();  
                        }  
                b.startObject("properties");
                        b.field("path_match", "foo.bar.baz.a");
        ParsedDocument docWithTemplate = mapperWithTemplate.parse(source(b -> b.field("date_field", "2023-12-25")));  
        assertNotNull(fooMapper);
        DocumentMapper mapperWithDynamic = createDocumentMapper(topMapping(b -> {
                }
        Mapping mapping = DocumentParser.createDynamicUpdate(docMapper.mapping(), docMapper, updates);
        assertEquals("long_path", doc2.rootDoc().getField("a.b.c.d.e.f.g.h.i.j").stringValue());
    }  
                        b.field("match_mapping_type", "object");  
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "object")));
                        b.field("price", 149.99);
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {
                }
        ParsedDocument doc = defaultMapper.parse(source(b -> {
            b.field("dynamic", "true");  
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "value")));  
        Mapping update = doc.dynamicMappingsUpdate();
            }  
        assertEquals(2, doc3.rootDoc().getFields("mixed_array.name").length);
        BigInteger bigInt = BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.ONE);  
            b.startObject("LogAttributes");
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "false_allow_templates")));
        assertThat(bazMapper, instanceOf(NumberFieldMapper.class));  
    public void testDynamicDottedFieldNameLongArray() throws Exception {
                b.endObject();  
        MapperParsingException exception = expectThrows(
        // Test that dotted field names are treated as literal field names
        }
                }
        IndexableField[] coreFields = doc.rootDoc().getFields("metrics.cpu.cores");  
            b.field("disable_objects", true);
        assertNotNull(fooMapper);
        // In disable_objects mode, array elements should be flattened using the same field name  
        assertEquals(4, doc.rootDoc().getFields("field.bar.baz").length);
            );  
        MapperService mapperService = createMapperService(mapping(b -> {}));  
            b.startArray("dynamic_templates");
            () -> mapper.parse(source(b -> b.nullField("bar")))
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "long")));  
    }
                b.startArray();
    }
        ParsedDocument doc1 = mapper.parse(source(b -> {  
                b.endObject();
                                }  
        ParsedDocument doc = mapper.parse(source(b -> b.field("numeric_field", "123")));  
 *  
        assertNull("no doubled name after round-trip", recoveredService.fieldType("attributes.address.address.city"));  
        ParsedDocument parsedDoc = mapperWithDynamic.parse(source(b -> {  
                        b.field("match_mapping_type", "string");
        assertThat(doc.rootDoc().get("test1"), equalTo("value1"));
        }));
        ParsedDocument doc2 = mapper.parse(source(b -> { b.field("a.b.c.d.e.f", "value1"); }));  
        ParsedDocument doc = mapper.parse(source(b -> {
        }));  
        }));  
                b.endObject();
        assertThat(doc.getDocumentInput(), nullValue());
        assertNotNull(fooMapper);  
            }
        assertEquals("Product 1", nameFields[0].stringValue());
        assertThat(bazMapper, instanceOf(NumberFieldMapper.class));
            () -> documentMapper.parse(source(b -> b.field("foo.bar.baz", 0)))  
        ParsedDocument doc = mapper.parse(source(b -> b.field("big-decimal", value)));
            }
        }));
                b.startObject();
        assertNull(((ObjectMapper) xMapper).getMapper("subx"));
        assertEquals(2, doc.rootDoc().getFields("products.details.category.main").length);
                    }
    // Helper method to create a mapper with disable_objects configuration
                    }
        assertEquals("mapping set to strict, dynamic introduction of [bar] within [_doc] is not allowed", exception.getMessage());  
        assertThat(e.getCause(), notNullValue());
        assertThat(barMapper, instanceOf(ObjectMapper.class));
        assertNotNull(aMapper);
        assertEquals("value3", doc.rootDoc().getField("mixed_nulls.nested").stringValue());
            b.field("test1", "value1");
                            }
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
            b.endObject();
        // The bug would cause "app" to become an ObjectMapper without disable_objects.
                {
            b.field("dynamic", "true");  
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
        }));  
                }
            b.startObject("properties");
                }  
        // Nested object with array: {"LogAttributes": {"app": {"payment": ["visa", "mastercard"]}}}  
    public void testDeepSubfieldMappingUpdate() throws Exception {
        assertNotNull(textMapper);  
    public void testEmptyMappingUpdate() throws Exception {  
                        b -> b.field(MockMetadataMapperPlugin.MockMetadataMapper.CONTENT_TYPE)  
        }
                    {
        }));  
                    b.startObject("bar").field("type", "keyword").endObject();  
            {
                b.startObject("inner2");  
 * KIND, either express or implied.  See the License for the
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {  
        MapperService mapperService = createMapperService(topMapping(b -> {
            MapperParsingException.class,
            source(b -> b.field("dyn_long", 42).field("dyn_double", 1.5).field("dyn_date", "2024-01-01").field("dyn_bool", true)),  
            () -> mapper.parse(source(b -> b.field("foo.bar.baz", 0)))  
        ParsedDocument doc = mapper.parse(source(b -> b.startArray("foo").value(0).value(1).endArray()));
        assertThat(exception3.getMessage(), containsString("strict"));
                b.startObject();
                    b.field("dynamic", true);
        // Verify the simple case works
                        b.field("match_mapping_type", "object");
                }
                    b.startObject("test");  
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> mapper.parse(source(b -> b.field("_field_names", 0))));
                    )
                b.startObject("properties");
        );
                b.endObject();
                {
            doc4.rootDoc().getField("a.b.c.very.deep.nested.field.with.many.levels")
            () -> mapper.parse(source(b -> b.startObject("foo.bar.baz").field("a", 0).endObject()))
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        );
        Mapping update = doc.dynamicMappingsUpdate();
            {
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {}));
        assertEquals(2, docWithTemplate.rootDoc().getFields("date_field").length);
                    {  
        }));  
        }
        }));
            "address.state should be text after round-trip",
        // This tests the recursive array handling in processFlattenedTokenForDisableObjects
                        b.field("match_mapping_type", "long");  
        DocumentMapper docMapper = createDummyMapping();
            mapperService.fieldType("attributes.address.city").typeName()  
            b.startArray("dynamic_templates");
        assertTrue("Should have item.id fields", itemIdFields.length > 0);
    }
        assertNull(DocumentParser.createDynamicUpdate(docMapper.mapping(), docMapper, Collections.emptyList()));
        assertNotNull("Field 'LogAttributes.app.payment' should exist", paymentFields);  
            for (int i = 1; i < depth_limit - 1; i++) {
                        b.field("name", "Product 2");  
                {
                {  
        DocumentMapper defaultMapper = createDocumentMapper(mapping(b -> {}));  
        Mapper objMapper = update.root().getMapper("inner1");  
        });
                        }
                b.endObject();
    }  
        assertEquals(0, doc.rootDoc().getFields("foo.bar").length);  
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "strict")));
            }
                }
    }
        }));
                    b.endObject();
                    }
    }
                b.endObject();
        assertThat(fooMapper, instanceOf(ObjectMapper.class));  
                        {
                        b.startObject("mapping").field("type", "object").endObject();  
        // Test 1: Only null field in flattened object with strict dynamic mapping should throw exception  
        assertNotNull(barMapper);
    public void testRootLevelDisableObjectsPrefixConflict() throws Exception {
    public void testDynamicFalseAllowTemplatesWithDateDetection() throws Exception {  
    }
                b.endObject();
        assertNotNull("Field 'a.b.c.single' should exist", doc3.rootDoc().getField("a.b.c.single"));
            """));
        mapper.parse(source(b -> b.field("foo._field_names", 0))); // parses without error
            b.endObject();  
        })));
                }
            }
            b.startObject("outer");
                }
        assertThat(aMapper, instanceOf(NumberFieldMapper.class));  
        assertEquals("mapping set to strict, dynamic introduction of [foo] within [_doc] is not allowed", exception.getMessage());
                        }
            }
                    }
        assertNotNull(bazMapper);  
            b.startObject("foo").field("enabled", false).endObject();  
            b.startArray("dynamic_templates");
            {  
        assertEquals("prod2", idFields[1].stringValue());
        DocumentInput<?> noopInput = new CapturingDocumentInput();
        StrictDynamicMappingException exception = expectThrows(StrictDynamicMappingException.class, () -> {  
        IndexableField[] copy1Fields = doc.rootDoc().getFields("location_copy1");  
        assertNotNull("Field 'user.address.city' should exist", doc.rootDoc().getField("user.address.city"));  
                b.field("last", "quxx");  
        assertEquals(0, doc.rootDoc().getFields("bar").length);
        ParsedDocument doc = mapper.parse(source(b -> {
            b.startArray("dynamic_templates");
                {  
            b.startObject("type").field("type_field", "type_value").endObject();  
            }  
        DocumentMapper defaultMapper = createDocumentMapper(mapping(b -> {}));
                }
                }
            """));  
    public void testDynamicFieldsWithOnlyDot() throws Exception {
        assertNotNull(barMapper);
            b.startObject("properties");  
        assertNotNull("Field 'mixed_array.name' should exist", doc3.rootDoc().getField("mixed_array.name"));
                    b.startObject("test");
                        b.startObject();  
        assertNotNull(barMapper);  
            b.endObject();
                b.field("type", "value_type");  
        assertThat(doc.rootDoc().get("type.test2"), equalTo("value2"));
        e = expectThrows(MapperParsingException.class, () -> mapper.parse(source(b -> b.field(".", "1234"))));
        );
        assertEquals("456", fields[3].stringValue());
            {
        ParsedDocument doc = defaultMapper.parse(source(b -> {
        assertEquals(2, doc.rootDoc().getFields("field.bar.baz.a").length);
    public void testDynamicFalseValue() throws Exception {  
        assertEquals(0, doc.rootDoc().getFields("foo").length);
    }
            b.startObject("type");  
            b.endArray();
        assertEquals(3, doc1.rootDoc().getFields("tags").length);
    }
        Mapper barMapper = ((ObjectMapper) fooMapper).getMapper("bar");  
        assertEquals(2, docWithTemplate.rootDoc().getFields("embedded_field").length);  
            }  
            b.startArray("bar");
            .endObject()
            {
        // in the existing mapper lookup loop
    }  
                        b.startObject("mapping").field("type", "boolean").endObject();
        // Verify no intermediate ObjectMapper "app" was created in the dynamic mapping update
            b.endObject();
                        {  
                {
                }  
        );
            b.startObject("foo");
                b.startObject("cpu");
            {
        assertThat(barMapper, instanceOf(ObjectMapper.class));  
        MapperParsingException exception = expectThrows(
            b.endObject();
            {
                    b.endObject();  
            {  
                        }
                b.startObject();
            b.endObject();  
        String[] expectedValues = { "a1", "a2", "b1", "b2", "c1", "c2" };
        );
            b.startObject("alias-field");  
            }
                        b.startObject("mapping").field("type", "object").endObject();
        ParsedDocument doc2 = mapperService.documentMapper().parse(source("""  
        // When root has disable_objects=true, any dotted field name should be treated as a flat field
            }  
            "Field 'level1.level2.level3.very.long.dotted.field.path' should exist",
        // Dynamic mapping update expected since "address.city" and "address.state" are not pre-defined
        // when the type is not the first one, we don't confuse it...
        assertThat(doc.getBinaryValue(docMapper.idFieldMapper().name()), equalTo(Uid.encodeId("1")));
                {
                        b.field("match_mapping_type", "object");  
            b.field("test1", "value1");
        assertNotNull(update); // dynamic mapping update
        StrictDynamicMappingException exception = expectThrows(
        assertEquals(0, doc.rootDoc().getFields("nested.target_field").length);
        ParsedDocument defaultDoc = defaultMapper.parse(source(b -> {
                        b.field("existing", "test");
                b.endObject();
            b.startObject("event_all").field("type", "text").endObject();  
            }
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> mapper.parse(source(b -> {  
        Mapper fooMapper = doc.dynamicMappingsUpdate().root().getMapper("field");  
                    b.endObject();
            e.getMessage()
import java.io.IOException;
    public void testDisableObjectsArrayWithDottedFieldNameNoIntermediateObjectMapper() throws Exception {
        assertNotNull(((ObjectMapper) subxMapper).getMapper("foo"));
                    {  
        // Verify all fields were flattened correctly
            b.startArray("top.");
                        b.startObject("mapping").field("type", "keyword").endObject();  
            {  
                b.startObject();
            MapperParsingException.class,
            b.startObject("properties");
                b.value("value1");
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "object")));
    }
    }
            {
        }));
        // Test that a deeply nested field is also flattened correctly
                        b.field("match", "bar");
        // This covers the StringBuilder flatFieldName code that flattens remaining path segments
                    }
    }
        assertTrue(fooMapper instanceof ObjectMapper);
        assertNotNull("Field 'user.age' should exist", doc.rootDoc().getField("user.age"));  
                }
                        b.startObject("mapping").field("type", "keyword").endObject();
                    // Note: No nested object mappers defined when disable_objects=true
                        b.field("match_mapping_type", "double");
    public void testSingleMappingUpdate() throws Exception {
                        b.field("match_mapping_type", "string");
        // Same regression test but at root level with disable_objects=true  
                        b.startObject("mapping").field("type", "keyword").endObject();  
    MapperService createMapperService() throws Exception {  
    }
                }  
        assertEquals("123", fields[1].stringValue());  
            }
            b.startObject("inner").field("inner_field", "inner_value").endObject();  
    }  
        throws IOException {
        DocumentMapper defaultMapper = createDocumentMapper(topMapping(b -> {
            if (logAttrsMapper instanceof ObjectMapper logAttrsObj) {
            }
    public void testDynamicDottedFieldNameObjectWithExistingParentWrongType() throws Exception {
    public void testDynamicDottedFieldNameLongWithExistingParentWrongType() throws Exception {
                    b.nullField("null_field");
        // Test 1: Simple array with existing field mapping
                    b.startObject("objects_as_nested");  
        }));  
        );
            () -> mapper.parse(source(b -> b.startObject("foo").field("bar", "baz").endObject()))  
        // Test at nested ObjectMapper level (like the TextBench LogAttributes case)  
            {
        return (ObjectMapper) builder.build(builderContext);  
                        b.endObject();
        assertThat(fooMapper, instanceOf(ObjectMapper.class));
            }
                    {  
            b.endObject();  
                .endObject();  
        assertEquals(  
            {"attributes": {"address.city": "Austin"}}
                b.endObject();
        assertEquals(8589934592L, flatDoc.rootDoc().getField("metrics.memory.used").numericValue().longValue());  
        assertThat(doc.rootDoc().get("type.inner.inner_field"), equalTo("inner_value"));  
                b.endObject();
                {
        }));
        }));
        assertNotNull("docA should produce dynamic mapping update", docA.dynamicMappingsUpdate());  
            b.startArray("dynamic_templates");
        // Test 1: Root-level disable_objects with dynamic fields  
        assertNotNull(xMapper);  
                    }
                        b.endObject();
            }
        assertThat(doc.rootDoc().get("type.type"), equalTo("type_value"));  
            b.startObject("obj");  
                b.endObject();  
                {
                    {  
            b.endArray();  
                        b.field("copy_to", "nested.target_field");  
        assertNotNull("Field 'products.details.name' should exist", doc.rootDoc().getField("products.details.name"));
            b.endObject();  
                b.startObject();
                b.field("type", "alias");
        assertNotNull(doc.rootDoc().getField("field"));
            b.field("dynamic", "false_allow_templates");
                }
        ParsedDocument doc = mapper.parse(source(b -> {  
        assertThat(doc.rootDoc().get("type.inner.inner_field"), equalTo("inner_value"));
                        b.field("match_mapping_type", "double");  
        {  
                    }  
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {  
        // Objects within arrays should be flattened to dotted field names  
            b.endArray();
            b.endObject();
                b.startObject("user.name");
            {
            b.field("baz", "value2");  
        assertNotNull(bazMapper);
        assertNotNull("Field 'a.b.c.d.e.f.g' should exist", doc2.rootDoc().getField("a.b.c.d.e.f.g"));  
                        b.field("match", "test");  
            .field("type", "keyword")  
            }
        assertThat(doc.rootDoc().get("type.test1"), equalTo("value1"));
                b.endObject();
                    b.startObject("date_template");  
        assertEquals(2, doc.rootDoc().getFields("foo.bar").length);  
            b.startObject("properties");
                    b.startObject("test1");
            () -> documentMapperWithDynamicTemplates.parse(source(b -> b.field("foo.bar.baz", 0)))
        assertNotNull(doc2);  
        Mapper.BuilderContext builderContext = new Mapper.BuilderContext(context.indexSettings().getSettings(), context.path());
        }));
                b.endObject();
        String mapping = copyToStringFromClasspath("/org/opensearch/index/mapper/simple/test-mapping.json");
                    b.startObject("test");
                    b.field("item.id", "item2");  
                }
            b.field("disable_objects", true);  // Root level has disable_objects=true
            {
                    b.field("disable_objects", true);
                b.endObject();  
        assertThat(e.getMessage(), equalTo("failed to parse, document is empty"));
/*  
        }));
                            .startObject()
    }  
    }
                        b.field("type", "object");  
                    }
                b.startObject("properties");
import org.opensearch.common.util.FeatureFlags;  
        assertEquals("address.city should be text", "text", mapperService.fieldType("attributes.address.city").typeName());
                    b.startObject("bigdecimal_template");
    }
                        b.endObject();  
            b.startObject("baz").field("type", "keyword").endObject();
        // Test single level field (should work normally)
    }
        assertThat(doc.getBinaryValue(docMapper.idFieldMapper().name()), equalTo(Uid.encodeId("1")));
                b.endObject();
                {  
                        {  
        assertThat(textMapper, instanceOf(TextFieldMapper.class));  
            b.endObject();  
                }
                b.startObject("foo");  
            b.endObject();
        assertNotNull(doc);
            }
        DocumentMapper documentMapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "strict_allow_templates")));  
    }
                        }
                b.endObject();
    }
        ParsedDocument doc = mapper.parse(source(b -> b.field("foo.bar.baz", 0)));  
    }
        assertEquals(2, doc.rootDoc().getFields("foo.bar.baz.a").length);  
            b.field("disable_objects", true);
    }  
        Mapper bazMapper = ((ObjectMapper) barMapper).getMapper("baz");  
import org.apache.lucene.util.BytesRef;
        assertEquals("deepvalue", doc2.rootDoc().getField("a.b.c.d.e.f.g").stringValue());
                    {
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "strict")));
                        {  
        Mapping update = doc.dynamicMappingsUpdate();
        );
                b.endObject();
    }  
        // Verify all values are present  
        assertNotNull("doc1 should produce dynamic mapping update", doc1.dynamicMappingsUpdate());
        ParsedDocument doc2 = mapper.parse(source(b -> { b.startArray("numbers").value(10).value(20).value(30).endArray(); }));
        ParsedDocument doc = mapper.parse(source(b -> {
                    {  
                        b.endObject();
            assertNull(doc.rootDoc().getField("field.bar"));
                b.endObject();
            {
        ParsedDocument docWithTemplate = mapperWithTemplate.parse(source(b -> b.field("bool_field", true)));  
        MapperService mapperService = createMapperService(mapping(b -> {
        Mapping dynamicUpdate = doc.dynamicMappingsUpdate();  
        Mapper xMapper = mapping.root().getMapper("x");
            b.field("dynamic", "true");  
            }
                        {
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
            }  
    public void testDynamicDottedFieldNameObjectWithParentTemplate() throws Exception {  
                            b.field("type", "object");
        DocumentInput<?> noopInput = new CapturingDocumentInput();  
        assertNotNull("Field 'a.b.c.d.e.f' should exist", doc2.rootDoc().getField("a.b.c.d.e.f"));
        ParsedDocument doc1 = mapper.parse(source(b -> {  
            }
        assertThat(doc.rootDoc().get("inner1.inner2.inner3.inner3_field1"), equalTo("inner3_value1"));  
        StrictDynamicMappingException exception = expectThrows(
                    }
    public void testDynamicLongArrayWithTemplate() throws Exception {  
        assertEquals(
            "address.state should be text after prefix conflict",  
            b.startObject("text-field");  
            () -> mapper.parse(source(b -> b.startArray("field.bar.baz").value(0).value(1).endArray()))  
    }  
        assertThat(doc.rootDoc().get("type.type_field"), equalTo("type_value"));
        ParsedDocument doc1 = rootMapper.parse(source(b -> { b.field("metrics.cpu.usage", 55.5); }));
            b.field("dynamic", "true");
        // and reconstruction: String.join(".", java.util.Arrays.copyOf(pathParts, i))  
        ParsedDocument doc = defaultMapper.parse(source(b -> {  
        }));
                b.startObject();  
            {
        ParsedDocument doc = mapper.parse(source(b -> b.nullField("foo")));
        ParsedDocument doc = mapper.parse(source(b -> b.startObject("foo").field("bar", "something").endObject()));  
        assertEquals(0, doc.rootDoc().getFields("foo").length);  
        // Non-null values should be stored
                {
            b.endArray();  
        assertNotNull(mapping);
                    b.startObject("test2");  
        assertEquals("John", doc.rootDoc().getField("user.name").stringValue());
            exception.getMessage()
                }
        }));
                b.startObject("user.age");  
            b.endArray();  
                    b.endObject();
            }
        assertEquals(4, doc.rootDoc().getFields("field").length);
        }));  
            {  
            b.endArray();  
        // Field: "a.b.c.d.e.f" should find parent "a.b.c" with disable_objects=true
            }
                    }
                b.startObject();
                        {
                    {
    public void testDynamicDottedFieldNameLong() throws Exception {  
        ParsedDocument doc1 = mapperService.documentMapper().parse(source("""
                }
            mapper.parse(source(b -> b.field("new.field", "value")));
        }));  
            }));
    public void testDynamicFalseAllowTemplatesWithEmbeddedObject() throws Exception {  
        assertEquals("mapping set to strict, dynamic introduction of [foo] within [_doc] is not allowed", exception.getMessage());  
                    b.startObject("georule");  
        assertEquals(0, doc.rootDoc().getFields("foo").length);
        Mapping update = doc.dynamicMappingsUpdate();
        assertThat(doc.rootDoc().get("type.inner.inner_field"), equalTo("inner_value"));
            b.field("dynamic", false);
        DocumentMapper defaultMapper = createDocumentMapper(mapping(b -> {}));  
        }));
            b.startObject("type");  
            b.field("inner_field", "inner_value");
                    b.startObject("subx");
    }
    public void testDynamicFalseAllowTemplatesObject() throws Exception {  
            mapperService.documentMapper().mappers().isMultiField("address.city")  
            exception.getMessage()
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {  
    }  
    }
        assertEquals(  
        assertEquals("mapping set to strict, dynamic introduction of [foo] within [_doc] is not allowed", exception.getMessage());
                b.startObject();
        assertThat(bazMapper, instanceOf(ObjectMapper.class));
            b.field("test1", "value1");
        ParsedDocument doc = mapper.parse(source(b -> {  
                b.endObject();  
                {
    }  
                    b.startObject("aoeu").field("a", 1).field(" ", 2).endObject();
        assertEquals(4, doc.rootDoc().getFields("foo.bar.baz").length);  
        assertThat(e.getCause().getMessage(), containsString("field name cannot contain only the character [.]"));
                {  
            b.startObject("nested");
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {  
            b.startArray("dynamic_templates");
        String mapping = copyToStringFromClasspath("/org/opensearch/index/mapper/simple/test-mapping.json");
        }));
                b.nullValue();  
                    {
import java.util.Collections;
                    b.startObject("first");
                    }
            b.field("disable_objects", true);  
    public void testDynamicTextFieldWithKeywordMultiFieldForNonPluggableDataFormat() throws Exception {  
        return createDocumentMapper(topMapping(b -> {
            }
                b.startObject("type").field("type_field", "type_value").endObject();  
        }));
        );  
                        }
            b.startObject("foo.bar");
        assertEquals(0, docWithTemplate.rootDoc().getFields("numeric_field").length);
            b.startObject("location_copy").field("type", "geo_point").endObject();
            {"address.city": "Austin"}
                b.field("age", 30);  
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "false")));
    }
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
                b.field("test2", "value2");  
        DocumentMapper docMapper = mapperService.documentMapper();  
        // parseNonDynamicArray's splitAndValidatePath. Splitting would cause getDynamicParentMapper
            }  
                b.endObject();  
        assertEquals("foo", result.docs().get(0).getField(NestedPathFieldMapper.NAME).stringValue());
        }));  
                b.endObject();  
        // reparse it
                    b.field("id", "prod1");
        assertThat(bazMapper, instanceOf(ObjectMapper.class));  
                b.endObject();
                b.endObject();
        DocumentMapper documentMapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "strict_allow_templates")));  
                        b.startObject("mapping");
        assertEquals(2, docWithTemplate.rootDoc().getFields("bigint_field").length);
                b.startObject("inner").field("inner_field", "inner_value").endObject();  
                    b.startObject("nested");
        IndexableField[] itemIdFields = doc.rootDoc().getFields("items.item.id");  
                }
        long depth_limit = MapperService.INDEX_MAPPING_DEPTH_LIMIT_SETTING.getDefault(Settings.EMPTY);
            b.endArray();
        );
            mapperService.documentMapper(),
                            }
        assertEquals("address should be text", "text", mapperService.fieldType("address").typeName());
                    {
            b.endArray();
        merge(mapperService, dynamicMapping(doc2.dynamicMappingsUpdate()));
            contextAwareGrouping("status_code").accept(b);
        }));
        );
        assertThat(bazMapper, instanceOf(NumberFieldMapper.class));
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
                    b.startObject("test1");
            b.field("dynamic", "strict_allow_templates");
        }));
    }  
        IndexSettings settings = new IndexSettings(build, Settings.EMPTY);
                                {
        ParsedDocument doc = mapperService.documentMapper().parse(source(b -> {
        assertNotNull(bazMapper);
            b.endObject();  
        ParsedDocument doc = mapper.parse(source(b -> b.startObject("foo.bar.baz").field("a", 0).endObject()));
 */  
            b.startArray("dynamic_templates");
        }));
                }
    }
        );
    protected Collection<? extends Plugin> getPlugins() {  
    public void testPropagateDynamicWithDynamicMapper() throws Exception {
    public void testGetMapperFlatteningLogic() throws Exception {  
                    b.field("type", "text");
                }
            }
            b.startArray("dynamic_templates");  
        assertNotNull(fooMapper);  
            }
        IndexableField[] copy2Fields = doc.rootDoc().getFields("location_copy2");
        assertNotNull(inner2_mapper);
                        b.startObject("mapping").field("type", "object").endObject();  
                    b.endObject();
            MapperParsingException.class,
                {  
        assertEquals("exact_match", doc4.rootDoc().getField("level1.level2.level3").stringValue());
        assertThat(barMapper, instanceOf(ObjectMapper.class));
            .endObject()
        Mapper barMapper = ((ObjectMapper) fooMapper).getMapper("bar");  
            b.startObject("properties");
    }
        // We should have generated a date field
        // Regular fields should be flattened and exist
            b.endArray();
            b.field("foo.bar.baz", 123);
    public void testDynamicFalseAllowTemplatesValue() throws Exception {
        assertEquals(2, fields.length);
            }  
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "false_allow_templates")));
        assertFalse(
    }
            exception.getMessage()
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "strict")));
    public void testDynamicLongArray() throws Exception {
            }
        DocumentMapper dynamicMapper = createDocumentMapper(topMapping(b -> {
            );  
                {
            merge(mapperService, dynamicMapping(parsedDoc.dynamicMappingsUpdate()));
            for (int i = 1; i <= depth_limit; i++) {
                        b.field("index", false);
        }));
        assertThat(doc.rootDoc().get("type.type"), equalTo("value_type"));
            b.endArray();
            MapperParsingException.class,
        // Test new dynamic field with shared prefix
    public void testDocumentDeepNestedObjectAndArrayCombination() throws Exception {
        assertNull(((ObjectMapper) subxMapper).getMapper("subsubx"));  
                b.startObject("inner").field("inner_field", "inner_value").endObject();
        }  
                            b.endObject();  
                    b.endObject();
                    {
    public void testNoLevelWithFieldTypeAsObjectNotFirst() throws Exception {  
                }
        // Null field should not be created  
            b.field("dynamic", "strict_allow_templates");  
    public void testDocumentContainsDeepNestedFieldParsingFail() throws Exception {  
            "Field 'level1.level2.level3.simple.field' should exist",  
        assertEquals(0, doc.rootDoc().getFields("foo.bar.baz.a").length);
                }  
        assertTrue(copy1Fields.length > 0);
        );
        );  
                        b.field("match", "foo");  
                b.endObject();
        ParsedDocument doc3 = mapper.parse(source(b -> { b.field("simple", "simple_value"); }));
                        b.field("match", "nested");  
        ParsedDocument doc = mapper.parse(source(b -> b.startArray("foo").value(0).value(1).endArray()));  
    }
                b.endObject();
            assertNull(doc.rootDoc().getField("field"));
        assertEquals("root_flattened", doc1.rootDoc().getField("root.level.dotted.field").stringValue());
        // Test deeply nested objects, multiple fields, and mixed scenarios
                    b.field("test", "value");  
                    b.endObject();
        merge(ms2, dynamicMapping(docA.dynamicMappingsUpdate()));
        assertEquals("Should have 8 fields (4 values * 2 fields each for numeric)", 8, coreFields.length);
        IndexableField[] paymentFields = doc.rootDoc().getFields("LogAttributes.app.payment");
                b.endObject();
        ParsedDocument doc3 = mapper.parse(source(b -> { b.field("level1.level2.level3.very.long.dotted.field.path", "another_value"); }));
            exception.getMessage()  
                }  
                b.field("type", "text");
            }
                }
    public void testDynamicStrictAllowTemplatesDottedFieldNameLong() throws Exception {
            b.startObject("properties");
        // 2. Flatten remaining path ["deep", "nested", "field", "name"] into "deep.nested.field.name"
        );
    // TODO do we still need all this tests for 'type' at the bottom level now that
                    {
        // 1. Traverse: level1 → level2 → level3 (which has disable_objects=true)
                Mapper appPaymentMapper = logAttrsObj.getMapper("app.payment");
        }));
        assertNotNull(update);
        assertNotNull("docB should produce dynamic mapping update", docB.dynamicMappingsUpdate());
                }
        assertNotNull(barMapper);
                        b.field("field", "testvalue");
            b.endObject();
        // Test array containing complex nested objects
    }
            b.startObject("point");
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "long")));  
                }
            b.endObject();
                {
                {
            for (int i = 1; i < depth_limit - 1; i++) {
            b.endObject();
        assertTrue("Should have item.category.name fields", categoryFields.length > 0);
            {
                    b.endObject();
                    b.startObject("test1");  
            // The update should contain a FieldMapper for "app.payment" under LogAttributes,
        }));
                    b.startObject("test");
                    }
                + "Existing mapping for [alias-field] must be of type object but found [alias].",
                b.endObject();
            b.startArray("dynamic_templates");  
        assertEquals("Cannot copy to a field alias [alias-field].", exception.getCause().getMessage());
        Mapping update = doc.dynamicMappingsUpdate();
            }
        })));
                        b.startObject("mapping").field("type", "object").endObject();
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "long")));
            .numberOfReplicas(0)
        DocumentMapper mapperWithExistingField = createDocumentMapper(topMapping(b -> {
            {
        ParsedDocument doc = mapper.parse(source(b -> {  
        // Test edge case where field path exactly matches the disable_objects parent
                    {  
                            b.field("sub", "phones");  
        DocumentMapper mapperWithTemplate = createDocumentMapper(topMapping(b -> {
                    }
                                {  
        String builtMapping = docMapper.mappingSource().string();
        DocumentMapper mapperWithTemplate = createDocumentMapper(topMapping(b -> {  
        assertEquals(Uid.encodeId("1"), result.docs().get(0).getField(IdFieldMapper.NAME).binaryValue());
                {  
            MapperException exception = expectThrows(MapperException.class, () -> mapper.parse(source(b -> b.field("bar", "bar"))));
                b.field("test2", "value2");
            }  
        ParsedDocument doc = mapper.parse(source(b -> b.startObject("test").field("test1", "foo").endObject()));
                    b.endObject();  
                        b.startObject("mapping").field("type", "object").endObject();
        assertEquals(2, doc.rootDoc().getFields("foo.bar.baz.a").length);
            }));  
            .build();
    }
                        }
                    }  
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> mapper.parse(source(b -> b.field("foo.bar", 42))));  
    public void testDynamicDottedFieldNameObjectWithExistingParent() throws Exception {
                    }  
            {
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "false_allow_templates")));
    public void testParseNonDynamicArrayWithDisableObjects() throws Exception {  
                    b.startObject("georule");
        ParsedDocument doc = mapper.parse(source(b -> {
        assertThat(doc.get(docMapper.mappers().getMapper("name.first").name()), equalTo("fred"));
        }));  
    }  
            {"address": "US"}  
            {"attributes": {"address": "US"}}  
            {  
        Mapper textMapper = doc.dynamicMappingsUpdate().root().getMapper("dynamic_text");
                MapperParsingException.class,  
                                b.startObject("bar").field("type", "keyword").endObject();
                        b.startObject("mapping").field("type", "keyword").endObject();
                }
                    b.startObject("embedded_template");
        ParsedDocument doc = defaultMapper.parse(source(b -> {
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {}));  
        assertThat(textMapper, instanceOf(TextFieldMapper.class));
                    b.startObject("properties");  
        assertNotNull(((ObjectMapper) xMapper).getMapper("foo"));
                    b.endObject();  
        // disable_objects should only be set at ONE place, not multiple levels  
                        b.field("path_match", "foo.bar.baz");
        }));  
            b.startArray("foo");
            b.startArray("dynamic_templates");  
                    b.startObject("properties");
        StrictDynamicMappingException exception = expectThrows(
    public void testDynamicBigDecimal() throws Exception {
        }));  
        Mapper barMapper = ((ObjectMapper) fooMapper).getMapper("bar");  
    public void testFieldDisabled() throws Exception {
                            b.endObject();  
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> {
                    b.startObject("test2");
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {}));
        }));  
                b.endObject();
                    b.endObject();  
        // First establish the existing mapper structure
                            .endObject()  
        Mapping mappingUpdate = doc2.dynamicMappingsUpdate();
            assertNull(doc.rootDoc().getField("field"));
        }));  
                    b.startArray("foo.");
        assertNotNull(xMapper);
        assertNotNull("Field 'outer.deep.nested.field' should exist", doc2.rootDoc().getField("outer.deep.nested.field"));
            b.field("dynamic", "false_allow_templates");
        // Should be flattened to outer.deep.nested.field
            {
            {
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "strict_allow_templates")));
        assertThat(doc.rootDoc().get("type.type"), equalTo("type_value"));
        }));  
    public void testDynamicDateDetectionEnabledWithNoSpecialCharacters() throws IOException {
                        b.field("match_mapping_type", "object");
        // Verify all nested fields are flattened correctly  
        ParsedDocument doc = mapper.parse(source(b -> b.startObject("foo.bar.baz").field("a", 0).endObject()));  
                                    // level3 has disable_objects=true, so any deeper paths should be flattened
            "Could not dynamically add mapping for field [field.bar.baz]. "  
        // Test array containing null values in disable_objects mode  
                b.startObject();
                    b.startObject("test");  
        assertNotNull(inner3_mapper);
                b.endObject();  
                                }  
            () -> mapper.parse(source(b -> b.startObject("alias-field.dynamic-field").field("type", "keyword").endObject()))
            Mapper logAttrsMapper = dynamicUpdate.root().getMapper("LogAttributes");
            mapperService.fieldType("attributes.address.state").typeName()
            StrictDynamicMappingException.class,  
    DocumentMapper createDummyMapping() throws Exception {
            exception.getMessage()
                b.endObject();
                b.startObject();
        assertThat(doc.rootDoc().get("inner1.inner2.inner3.inner3_field1"), equalTo("inner3_value1"));
            {"attributes": {"address.city": "Austin", "address.state": "Texas"}}  
            {
        );  
            StrictDynamicMappingException.class,
            b.startArray("dynamic_templates");  
            b.endObject();  
            b.field("dynamic", "true");  
        ParsedDocument doc2 = mapperService.documentMapper().parse(source("""
            {
        MapperParsingException exception = expectThrows(
    }  
                b.field("copy_to", "location_copy");  
            b.field("status_code", "300");
            {  
        StrictDynamicMappingException exception = expectThrows(
            b.endArray();
            }  
            }
        }));
    }
            assertNull(doc.rootDoc().getField("field.bar"));
            {  
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
                b.startObject("user");
        assertNotNull(doc.dynamicMappingsUpdate());  
                b.startObject();
    }
        assertThat(fooMapper, instanceOf(ObjectMapper.class));
        );  
                    b.endObject();  
 */  
            {
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> mapper.parse(source(b -> {
        assertNotNull("Field 'simple' should exist", doc3.rootDoc().getField("simple"));
                {
                        b.endObject();
            assertThat(m, instanceOf(FieldMapper.class));
                b.startObject();
    }  
            b.endObject();
        }));
                b.endArray();  
                b.endObject();
        exception = expectThrows(  
        assertThat(fooMapper, instanceOf(ObjectMapper.class));
                b.endObject();
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {  
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {
                }
                b.startObject("inner").field("inner_field", "inner_value").endObject();
/*  
        DocumentMapper defaultMapper = createDocumentMapper(mapping(b -> {}));
        assertEquals(new BytesRef(value.toString()), fields[0].binaryValue());
            b.endObject();  
        }));
        );
                b.startObject();
            }  
    }
 * software distributed under the License is distributed on an
                b.startObject();  
        assertEquals("address should be text after round-trip", "text", recoveredService.fieldType("attributes.address").typeName());
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {}));  
        // After flattening, field name becomes "app.payment" and the value is an array.
        );
    public void testDynamicStrictDottedFieldNameLong() throws Exception {
            b.startArray("inner");
                b.endObject();
            }
                    }
                            b.field("type", "geo_point");
            b.endArray();  
            }
            b.field("test2", "value2");
        }));
    }
                    {
        DocumentMapper defaultMapper = createDocumentMapper(mapping(b -> {}));
            b.endObject();
    }
                    b.startObject("bigint_template");
        List<Mapper> updates = new ArrayList<>();
                {
            {  
        // when encountering an ObjectMapper with disable_objects=true  
                        b.field("match", "bar");  
                    }
        ParsedDocument doc = mapper.parse(source(b -> {
        DocumentMapper docMapper = createDocumentMapper(mapping(b -> {
                        b.field("match", "bar");  
    }
            {  
        // Verify that the geo_point field itself exists
import org.opensearch.core.common.bytes.BytesArray;
                        b.startObject("mapping").field("type", "keyword").endObject();
        DocumentMapper mapperWithTemplate = createDocumentMapper(topMapping(b -> {
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "strict")));  
            b.endArray();  
                }  
    public void testDynamicFalseLongArray() throws Exception {
            b.endObject();
                }
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "false_allow_templates")));  
                b.startObject("metrics.cpu.usage");  
            properties(x -> {
                        b.endObject();
    }
        }));  
            b.startArray("dynamic_date_formats").value("yyyy-MM-dd").endArray();  
            b.startArray("products");  
        assertTrue(subxMapper instanceof ObjectMapper);
                    b.startObject("boolean_template");  
        Mapper bazMapper = ((ObjectMapper) barMapper).getMapper("baz");
    public void testDynamicFalseAllowTemplatesWithBigInteger() throws Exception {
                    b.field("type", "text");  
            }
                b.endArray();  
        StrictDynamicMappingException exception = expectThrows(
            b.endArray();  
            b.field("dynamic", "true");
        assertNotNull("doc2 should produce dynamic mapping update", doc2.dynamicMappingsUpdate());
        IndexableField[] mixedFields = doc.rootDoc().getFields("mixed_nulls");
        Mapper fooMapper = doc.dynamicMappingsUpdate().root().getMapper("foo");  
                b.endObject();  
                        b.field("match_mapping_type", "object");
            }  
        // Regression test: When a nested object contains an array value under disable_objects,  
            }
            {  
            () -> docMapper.parse(new SourceToParse("test", "1", json, MediaTypeRegistry.JSON))
        }));  
            b.endObject();  
    // we no longer have types?
                        b.field("path_match", "foo.bar.baz");  
            {  
                                    b.field("disable_objects", true);
    }
            () -> mapper.parse(source(b -> b.field("alias-field", "value")))  
        assertThat(doc.rootDoc().get("type.type.type_field"), equalTo("type_value"));
                    }
        assertEquals(IdFieldMapper.Defaults.FIELD_TYPE, result.docs().get(1).getField(IdFieldMapper.NAME).fieldType());
            b.endObject();  
    }  
            b.endObject();  
            "Field 'a.b.c.very.deep.nested.field.with.many.levels' should exist",  
            b.startObject("properties");  
        assertNotNull("Dynamic field 'metrics.cpu' should exist as flat field", doc2.rootDoc().getField("metrics.cpu"));  
                b.field("copy_to", "location_copy");
                    b.endObject();
                {
                    {
            Mapper m = doc.dynamicMappingsUpdate().root().getMapper(field);  
        updates.add(createObjectMapper(mapperService, "foo"));
            b.field("dynamic", "false_allow_templates");
        }));
        Document doc = builtDocMapper.parse(new SourceToParse("test", "1", json, MediaTypeRegistry.JSON)).rootDoc();
 * GitHub history for details.
                b.startObject("metrics");
        List<Mapper> updates = new ArrayList<>();  
        }));
                        b.field("match", "bar");
                }
        assertNotNull(doc1);
        );
        assertNotNull("Field 'metrics.memory.used' should exist", flatDoc.rootDoc().getField("metrics.memory.used"));
        }  
            assertThat(exception.getMessage(), containsString("failed to parse field [foo] of type [long] in document with id '1'"));
        // Dynamic mapping update expected since "address" is not pre-defined  
            b.startObject("bar").field("type", "boolean").endObject();  
        assertEquals(Uid.encodeId("1"), result.docs().get(1).getField(IdFieldMapper.NAME).binaryValue());  
                    b.startObject("source_field");  
            {
                b.startObject();
                                b.endObject();
import org.opensearch.index.IndexSettings;
            b.field("test2", "value2");  
        assertNotNull(aMapper);
                b.field("memory.used", 8589934592L);  
                        b.field("match", "foo*");
        DocumentMapper strictMapper = createDocumentMapper(topMapping(b -> {
                b.field("inner1_field1", "inner1_value1");
                {  
                b.startObject("b");
        // Verify the values are correctly stored  
        }));  
            b.startObject("type");
            b.endObject();
        IndexableField[] fields = doc.rootDoc().getFields("foo.bar.baz");  
                b.field("name", "laptop");  
        MapperService mapperService = createMapperService();
            .put("index.version.created", Version.CURRENT)  
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "long")));
        Mapper objMapper = update.root().getMapper("inner1");
                b.field("test1", "value1");
            }));
            b.field("dynamic", "true");
                        b.nullField("category"); // Only null field - should trigger the exception via
                b.startObject();
        assertEquals("John Doe", doc.rootDoc().getField("user.name").stringValue());
                        b.startObject("mapping").field("type", "object").endObject();  
        MapperService mapperService = createMapperService(topMapping(b -> {
        assertNull(doc.dynamicMappingsUpdate()); // no update!
    public void testNoLevelWithFieldTypeAsValueNotFirst() throws Exception {
                b.endObject();  
                }
                {
        // Should be flattened to outer.inner.test
            () -> mapper.parse(source(b -> b.field("bar", "baz")))
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.startArray("dynamic_date_formats").value("yyyy").endArray()));
            b.startObject("inner").field("inner_field", "inner_value").endObject();
    }
        assertThat(doc.get(docMapper.mappers().getMapper("name.first").name()), equalTo("fred"));  
    }
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "false")));
                    b.startArray("cores");
    ObjectMapper createObjectMapper(MapperService mapperService, String name) {
                b.endArray();
                        b.endObject();
        MapperService ms2 = createMapperService(topMapping(b -> {
                .startObject("keyword")
            }  
        assertEquals(0, doc.rootDoc().getFields("bigint_field").length);
            "mapping set to strict_allow_templates, dynamic introduction of [foo] within [_doc] is not allowed",
        assertThat(doc.rootDoc().get("inner.inner_field"), equalTo("inner_value"));
        assertNotNull("Field 'metrics.cpu.usage' should exist", doc1.rootDoc().getField("metrics.cpu.usage"));
        );  
                        b.field("match_mapping_type", "object");  
                    b.startObject("georule");  
            b.field("dynamic", "false_allow_templates");  
                b.startObject();
        assertEquals("simple_value", doc3.rootDoc().getField("simple").stringValue());
                    b.startObject("properties");  
        }
        }));  
                        b.field("lat", 40.7128);
            .startObject(MapperService.SINGLE_MAPPING_NAME)  
                b.startObject();
        ParsedDocument doc = defaultMapper.parse(source(b -> {
        // Both fields should be properly mapped using existing field mappers
        assertThat(dateMapper, instanceOf(DateFieldMapper.class));
        assertTrue("Text field should have keyword multi-field without pluggable dataformat", textMapper.iterator().hasNext());
        assertEquals(0, doc.rootDoc().getFields("bigdecimal_field").length);  
                }
                        b.field("match_mapping_type", "object");
                }  
        }  
                b.field("test2", "value2");
                b.startArray().value("c1").value("c2").endArray();  
            b.endArray();
                        b.endObject();  
            {
            ParsedDocument doc = mapper.parse(source(b -> b.field("field.bar", new int[] { 1, 2, 3 })));
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> {
        Mapper bazMapper = ((ObjectMapper) barMapper).getMapper("baz");  
            }
        assertNotNull(
        ParsedDocument doc = mapper.parse(source(b -> { b.startObject("point").field("lat", 40.71).field("lon", 74.00).endObject(); }));
                source(b -> b.field(MockMetadataMapperPlugin.MockMetadataMapper.CONTENT_TYPE, "mock-metadata-field-value"))
        assertEquals("value1", mixedFields[0].stringValue());
        return singletonList(new MockMetadataMapperPlugin());
        // the flat-field contract and potentially causing recursive field name expansion.
                b.field("path", "concrete-field");  
        ParsedDocument doc = mapper.parse(source(b -> b.nullField("bar")));  
                            b.field("e.f.g", "deepvalue");
                    source(
        // Dynamic mapping update expected since "address" is not pre-defined
}  
        ParsedDocument doc = mapper.parse(source(b -> b.field("test1", "baz")));
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
            }
            {
            {  
                        b.field("match", "big-*");
            {
        // Dynamically add "address"
            b.field("bar", 10);
        }));  
            }
        ParsedDocument doc4 = mapper.parse(source(b -> { b.field("a.b.c.very.deep.nested.field.with.many.levels", "deepvalue"); }));  
        {  
    public void testDynamicFalseAllowTemplatesDottedFieldNameObject() throws Exception {
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {  
            e.getMessage(),  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            b.endArray();
                    b.value("visa");  
        assertEquals("value1", result.docs().get(0).getField("foo.bar").binaryValue().utf8ToString());  
        assertNotNull(barMapper);
        DocumentMapper mapperWithTemplate = createDocumentMapper(topMapping(b -> {
        ));  
        // This comprehensively tests the condition: parentPath.isEmpty() || parentPath.equals("_doc")
                        b.field("match_mapping_type", "object");  
            {"attributes": {"address": "US"}}
                b.endObject();  
            b.startArray("field");
                        {  
            }
    public void testDynamicFalseAllowTemplatesDottedFieldNameLong() throws Exception {
        ParsedDocument doc = defaultMapper.parse(source(b -> {
        assertEquals(4, doc.rootDoc().getFields("foo").length);
            b.endObject();  
            StrictDynamicMappingException.class,
        List<Mapper> updates = Collections.singletonList(new MockFieldMapper("foo"));
        Mapper.Builder<?> builder = new ObjectMapper.Builder<>(nameParts[nameParts.length - 1]).enabled(true);
        ));  
                    b.field("id", "prod2");  
        CapturingDocumentInput mockInput = new CapturingDocumentInput();
            b.startObject("location_copy2").field("type", "geo_point").endObject();
    public void testDisableObjectsAutomaticFlattening() throws Exception {  
        BytesReference json = new BytesArray(copyToBytesFromClasspath("/org/opensearch/index/mapper/simple/test1.json"));  
        assertEquals("address should be text in reverse order", "text", ms2.fieldType("attributes.address").typeName());
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.startArray("dynamic_date_formats").value("yyyy MM").endArray()));  
                        b.field("match", "numeric_*");
            for (int i = 1; i <= depth_limit; i++) {
                }  
                    b.nullField("age"); // Only null field - should trigger the exception via processFlattenedTokenForDisableObjects
                    }  
                {
        assertNotNull(((ObjectMapper) xMapper).getMapper("a"));
    }
                }  
                    b.endObject();
            b.startObject("properties");
import org.opensearch.common.xcontent.XContentFactory;
        ParsedDocument doc = mapper.parse(
            "Could not dynamically add mapping for field [alias-field.dynamic-field]. "  
        assertThat(doc.rootDoc().get("test2"), equalTo("value2"));  
                b.startObject("foo");
        );  
                {
        ParsedDocument doc = mapper.parse(source(b -> b.field("float_field", "123.45")));  
        ParsedDocument doc1 = mapper.parse(source(b -> { b.startArray("tags").value("tag1").value("tag2").value("tag3").endArray(); }));  
        ParsedDocument doc = mapper.parse(source(b -> b.field("bar", "baz")));
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {
                    b.startObject("test1");  
        for (int i = 0; i < nameParts.length - 1; ++i) {
        ParsedDocument parsedDoc = mapperWithDynamic.parse(source(b -> b.field("source_field", "test value")));
        assertEquals("literalvalue", doc3.rootDoc().getField("outer.literal.field.name").stringValue());  
                b.endObject();
        updates.add(new MockFieldMapper("foo.bar.baz"));
        // "app.payment" should be a flat field with 2 values
        );  
    }
    public void testUnexpectedFieldMappingType() throws Exception {  
        // Test with array of objects containing dotted field names  
            {
                        b.startObject("mapping").field("type", "keyword").endObject();
                b.field("source_field", "test value");  
        // check that parsing succeeds with valid doc
    }
        List<Mapper> updates = new ArrayList<>();
                    }
            b.field("dynamic", "true");  
        assertNotNull(doc.rootDoc().getField("bar"));  
                {  
        );
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "false_allow_templates")));  
        }));
        Mapper bazMapper = ((ObjectMapper) barMapper).getMapper("baz");
            .startObject("foo")
                b.field("literal.field.name", "literalvalue");  
            }
        });
                    }
        assertThat(doc.getBinaryValue(builtDocMapper.idFieldMapper().name()), equalTo(Uid.encodeId("1")));
                        b.field("match_mapping_type", "double");  
            }
        }));
            b.startArray("dynamic_templates");
        assertEquals(6, doc2.rootDoc().getFields("numbers").length); // 3 values * 2 fields each (numeric + stored)
                b.field("test1", "value1");
        DocumentMapper docMapper = createDocumentMapper(MapperService.SINGLE_MAPPING_NAME, mapping);
                    b.startObject("numeric_template");  
                    b.endObject();  
                    b.field("type", "text");
        merge(mapperService, dynamicMapping(doc1.dynamicMappingsUpdate()));
    public void testDynamicStrictAllowTemplatesNull() throws Exception {  
                }  
        assertNotNull("Field 'product.name' should exist", doc.rootDoc().getField("product.name"));
                b.startObject();
                        }  
                            b.startObject("baz").field("type", "integer").endObject();
    public void testMappedNullValue() throws Exception {  
                    b.startObject("details");
            {
            b.startArray("dynamic_templates");
        assertEquals(2, docWithTemplate.rootDoc().getFields("foo.bar.baz.a").length);  
        assertThat(doc.getDocumentInput(), sameInstance(mockInput));
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {  
    }  
        assertEquals("value", doc1.rootDoc().getField("outer.inner.test").stringValue());  
    public void testDisableObjectsWithExistingFieldMappers() throws Exception {
                    {
            exception.getMessage()  
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "false_allow_templates")));  
                b.field("first", "fred");
        updates.add(new MockFieldMapper("x.subx.b"));
                            b.field("main", "electronics");
            {  
                }
            .startObject()
        assertNotNull(mapping);  
        assertNotNull(bazMapper);
        assertNotNull(copy2Fields);
                }  
            b.field("dynamic", false);
        assertNotNull(inner2_mapper);  
        assertNotNull(result.docs().get(0).getField(NestedPathFieldMapper.NAME));
            b.startObject("foo");  
        CapturingDocumentInput mockInput = new CapturingDocumentInput();  
            b.field("bar", 10);  
    }
            StrictDynamicMappingException.class,
                b.endObject();
                    {
                        b.startObject("mapping").field("type", "long").endObject();
                b.startObject("LogAttributes");
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> b.field("dynamic", "false_allow_templates")));
                            b.field("type", "float");
    public void testProcessFlattenedTokenNullValueForDisableObjects() throws Exception {
                        {
                    {
    }
        assertEquals("Product 2", nameFields[1].stringValue());
                b.endObject();  
            noopInput
            b.field("dynamic", "false_allow_templates");
            b.endArray();
                b.field("test2", "value2");  
        assertEquals(2, doc.rootDoc().getFields("test1").length);  
        ));
        Mapper fooMapper = doc.dynamicMappingsUpdate().root().getMapper("foo");
        assertEquals("visa", paymentFields[0].stringValue());
            }
                    {  
            }
            b.startArray().value(0).value(0).endArray();
        );  
        ParsedDocument doc = mapper.parse(source(b -> b.field("foo.bar.baz", 0)));  
        assertEquals(2, doc.rootDoc().getFields("products.details.category.sub").length);
            }  
        assertNull("No intermediate objects should exist", flatDoc.rootDoc().getField("metrics.cpu"));
        // Test 2: Array with numeric values  
            }  
                b.startObject();
            b.startObject("alias-field");
            b.field("test1", "value1");  
        }
        ParsedDocument doc2 = mapper.parse(source(b -> { b.field("level1.level2.level3.deep.nested.field.name", "flattened_value"); }));
            b.startArray("foo");
                    {
        Mapper fooMapper = doc.dynamicMappingsUpdate().root().getMapper("foo");
            assertFalse(  
            b.startObject("x");  
    public void testDynamicFieldsEmptyName() throws Exception {
                    b.field("zip", "10001");
        assertEquals("NYC", doc.rootDoc().getField("user.address.city").stringValue());
        assertThat(barMapper, instanceOf(ObjectMapper.class));
    public void testParseToJsonAndParse() throws Exception {
        assertThat(err.getCause(), notNullValue());
                        b.startObject("mapping").field("type", "object").endObject();
                b.startArray().value("b1").value("b2").endArray();
                        b.field("match", "test*");
                    }
            }  
    }
        }));
            }
                {
        MapperService mapperService = createMapperService(topMapping(b -> {
    public void testSimpleParserNoTypeNoId() throws Exception {  
                {
        // All fields should be flattened
                    }
        assertEquals(  
                    b.field("type", "object");
                        }
                b.endObject();
                b.endObject();
        long depth_limit = MapperService.INDEX_MAPPING_DEPTH_LIMIT_SETTING.getDefault(Settings.EMPTY);
    /**
            }
            }
                b.startObject("properties");
        DocumentMapper defaultMapper = createDocumentMapper(mapping(b -> {}));
                }  
        assertNotNull(mapping);
                b.startObject("tags");  
            {
                b.startObject();  
        assertThat(doc.rootDoc().get("test1"), equalTo("value1"));
                    b.endObject();
        MapperParsingException exception = expectThrows(  
                    {  
            "mapping set to strict_allow_templates, dynamic introduction of [foo] within [_doc] is not allowed",  
            {  
                    b.startObject("test");  
    public void testDocumentContainsAllowedMetadataField() throws Exception {
                        b.field("match", "date_*");
            b.startObject("field");
        assertThat("Mapper should be a FieldMapper", cpuMapper, instanceOf(FieldMapper.class));  
    public void testDynamicFalseAllowTemplatesWithBigDecimal() throws Exception {
            {  
                {
    }
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {}));  
        // Test that nested object structures are automatically flattened  
    }
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> mapper.parse(source(b -> {
    public void testSubfieldMappingUpdate() throws Exception {
            b.field("dynamic", false);  
            () -> mapper.parse(source(b -> b.startObject("foo").field("bar", "baz").endObject()))
    public void testSimpleParser() throws Exception {  
            {
                b.startArray();  
            b.field("foo", "1234");
            b.field("dynamic", "true");  
                        b.field("match", "bar");
        assertEquals(789, fields[4].numericValue());  
    private DocumentMapper createDisableObjectsMapper(boolean rootDisableObjects, String objectPath, boolean objectDisableObjects)  
        assertTrue(copiedFields.length > 0);
        }));
            b.startObject("location_copy1").field("type", "geo_point").endObject();
        ParsedDocument doc = mapper.parse(source(b -> b.startArray("foo.bar.baz").value(0).value(1).endArray()));
        assertEquals(2, doc.rootDoc().getFields("foo.bar.baz.a").length);
        ParsedDocument doc2 = mapper.parse(source(b -> {  
        // Test to ensure both empty and "_doc" root mapper names are handled correctly
        merge(MapperService.SINGLE_MAPPING_NAME, mapperService, mapping);
                                    b.field("type", "object");  
            {  
        })));  
        assertNotNull("Field 'products.id' should exist", doc.rootDoc().getField("products.id"));
            {
        // Test 4: Test with pre-existing field mapping to ensure we only test dynamic null handling  
                    }
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {}));  
                    b.endObject();  
        assertEquals("address should be text", "text", mapperService.fieldType("attributes.address").typeName());
        ParsedDocument doc = mapper.parse(source(b -> b.startArray("foo").value(0).value(1).endArray()));  
                b.startObject();
        );
                b.startObject();  
            b.endArray();
            b.field("user.age", 30);
        assertEquals(2, doc.rootDoc().getFields("test.test1").length);
        Mapping mapping = DocumentParser.createDynamicUpdate(docMapper.mapping(), docMapper, updates);  
    public void testDynamicStrictObject() throws Exception {  
                }
            b.endObject();
        assertNotNull(result.docs().get(1).getField(IdFieldMapper.NAME));
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> mapper.parse(source(b -> {
                {
                b.endObject();
        assertThat(bazMapper, instanceOf(NumberFieldMapper.class));
            {
        Mapping mapping = DocumentParser.createDynamicUpdate(docMapper.mapping(), docMapper, updates);
        ParsedDocument doc3 = mapper.parse(source(b -> {
                    b.endObject();  
            b.startObject("concrete-field").field("type", "keyword").endObject();
                            b.field("type", "object");
        // Assert both fields are resolvable
                b.startArray("items");  
        ParsedDocument doc = mapper.parse(source(b -> b.field("bar", "baz")));
            ParsedDocument doc = mapper.parse(
                    }
                {
        assertNull(((ObjectMapper) xMapper).getMapper("subx"));
            {  
        assertNotNull(mapping);  
                        b.startObject("mapping").field("type", "keyword").endObject();
        assertNotNull(update);
                    b.endObject();
            }
    public void testParseDocumentWithNullDocumentInput() throws Exception {
                        {  
                b.endObject();
            }
        }));
                    {
        assertEquals(IdFieldMapper.Defaults.NESTED_FIELD_TYPE, result.docs().get(0).getField(IdFieldMapper.NAME).fieldType());  
        IndexableField[] fields = doc.rootDoc().getFields("big-integer");  
    }  
                    b.endObject();
                    }  
            {  
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
        }));
        MapperService mapperService = createMapperService(mapping(b -> {  
            {
                            b.startObject("subsubx").field("type", "object").endObject();  
        ParsedDocument doc3 = mapper.parse(source(b -> { b.field("a.b.c.single", "value2"); }));  
        ParsedDocument doc = defaultMapper.parse(source(b -> {
                b.field("field.bar", "string value");
        DocumentMapper docMapper = createDocumentMapper(MapperService.SINGLE_MAPPING_NAME, mapping);  
                        b.field("match", "foo");
                        b.startObject("mapping").field("type", "long").endObject();
                    b.endObject();
        assertNotNull(doc.dynamicMappingsUpdate());
            {
            () -> mapper.parse(source(b -> b.startArray("foo").value(0).value(1).endArray()))
    }
    }
        assertNotNull(fooMapper);  
            }));
        }));
 * Unless required by applicable law or agreed to in writing,
        assertThat(e.getCause(), notNullValue());
 * ownership. Elasticsearch licenses this file to you under  
        // Verify that the field was copied to the copy_to target
        assertNotNull("Field 'root.level.dotted.field' should exist", doc1.rootDoc().getField("root.level.dotted.field"));
            assertNull(doc.rootDoc().getField("field.bar"));
            e.getCause().getMessage().contains("Field [_field_names] is a metadata field and cannot be added inside a document.")
            b.field("disable_objects", true);
    }
                    b.endObject();  
    public void testMappedGeoPointArray() throws Exception {
                        b.startObject("properties");
                    b.endObject();
        // All array elements should be flattened to the same field name  
     * index:true and their range/term queries would match nothing. Guards the settings passed to the
        Document doc = docMapper.parse(source(b -> {
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {}));
        {  
                    b.startObject("test");  
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "object")));  
            b.endObject();
    // Test nesting upto max allowed depth with combination of nesting in object and array  
                }  
                    b.startObject("nested_template");
    }  
        assertNotNull(
                b.startObject("type").field("type_field", "type_value").endObject();  
                b.field("type", "object");  
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
        DocumentMapper builtDocMapper = createDocumentMapper(MapperService.SINGLE_MAPPING_NAME, builtMapping);
                b.startObject();  
                    }
            strictMapper.parse(source(b -> {
            }  
        }  
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {
                        b.startObject("mapping").field("type", "date").endObject();
                b.startObject();
                b.field("test1", "value1");
        }));
        );  
import static org.hamcrest.Matchers.containsString;
        Mapper bazMapper = ((ObjectMapper) barMapper).getMapper("baz");
            b.field("dynamic", "false_allow_templates");
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
            """));
        // Test various field paths that should trigger the path splitting logic
                b.endObject();
                b.field("test1", "value1");
            assertNull(doc.rootDoc().getField("bar"));  
            () -> mapper.parse(source(b -> b.nullField("bar")))
                    b.endObject();
            b.startArray("top.");  
                        b.field("match_mapping_type", "string");
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)  
        assertEquals(4, docWithTemplate.rootDoc().getFields("foo.bar.baz").length);
    public void testRootLevelGetMapperFlattening() throws Exception {
            MapperParsingException.class,
        assertEquals(30L, doc.rootDoc().getField("user.age").numericValue().longValue());
        );
    }
        StrictDynamicMappingException exception2 = expectThrows(StrictDynamicMappingException.class, () -> {
            b.startArray("dynamic_templates");
        // Root document:
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
        ParsedDocument doc = mapper.parse(source(b -> {
            }
        );
                    b.endObject();
        Mapping dynamicUpdate = doc.dynamicMappingsUpdate();
        String builtMapping = mapperService.documentMapper().mappingSource().string();  
            b.field("dynamic", "strict_allow_templates");
        Mapper barMapper = ((ObjectMapper) fooMapper).getMapper("bar");
                        b.field("match_mapping_type", "object");
    public void testGeoPointWithCopyTo() throws Exception {  
            b.endArray();  
        // Test the specific array flattening logic in parseNonDynamicArray when disable_objects=true
            () -> mapper.parse(source(b -> b.field("bar", "baz")))
            b.startArray().value(0).value(0).endArray();
                    b.value(4);
            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))  
        MapperParsingException err = expectThrows(MapperParsingException.class, () -> mapper.parse(source(b -> b.field("", "foo"))));
        // Nested object with array: {"metrics": {"cpu": {"cores": [1, 2, 3, 4]}}}  
    public void testDocumentContainsMetadataField() throws Exception {  
            """));
            {
    public void testDynamicDottedFieldNameLongArrayWithExistingParentWrongType() throws Exception {
                    {  
        DocumentMapper documentMapperWithDynamicTemplates = createDocumentMapper(topMapping(b -> {
                        b.field("simple.field", "test1");
            b.field("dynamic", "false_allow_templates");  
            MapperParsingException.class,  
    }
            strictMapper.parse(source(b -> {
    }
                {
        Mapper fooMapper = doc.dynamicMappingsUpdate().root().getMapper("foo");
                {
                b.endObject();
                    b.startObject("properties");
            }  
                }  
        ParsedDocument doc = mapper.parse(source(b -> b.startObject("foo.bar.baz").field("a", 0).endObject()));
                {
            b.startArray("dynamic_templates");
            }
            b.endObject();
            b.startArray("dynamic_templates");
            b.startArray("dynamic_templates");
            b.field("dynamic", "false_allow_templates");
            recoveredService.fieldType("attributes.address.city").typeName()
                b.field("type", "alias");  
                        b.startObject("mapping").field("type", "long").endObject();  
                        b.field("match", "bigint_*");  
        }));
    public void testPropagateDynamicWithExistingMapper() throws Exception {  
            b.startObject("concrete-field").field("type", "keyword").endObject();
                    {
                        b.startObject("mapping").field("type", "object").endObject();  
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
    public void testDynamicDottedFieldNameObject() throws Exception {  
            {
        DocumentMapper mapperWithTemplate = createDocumentMapper(topMapping(b -> {  
            b.startObject("product");
        // Test scenario with disable_objects parent to ensure correct flattening behavior
                b.endObject();  
        ParsedDocument doc2 = rootMapper.parse(source(b -> { b.field("metrics.cpu", 99.1); }));
        Mapper barMapper = ((ObjectMapper) fooMapper).getMapper("bar");
                }
        assertNotNull(doc.dynamicMappingsUpdate());  
            {"attributes": {"address.city": "Austin", "address.state": "Texas"}}  
        }
                    b.field("type", "float");
                                                 // processFlattenedTokenForDisableObjects
                    b.endObject();
            b.endObject();
                {
            }  
        ParsedDocument doc4 = mapper.parse(source(b -> { b.field("level1.level2.level3", "exact_match"); }));
    public void testSimpleMapper() throws Exception {  
                {
        assertEquals(4, doc.rootDoc().getFields("foo").length);
        }));
            StrictDynamicMappingException.class,
                b.endObject();
                    {
        DocumentMapper mapper = createDocumentMapper(pluggableSettings, mapping(b -> {}));
    public void testBlankFieldNames() throws Exception {
        }));
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {}));
                        b.startObject("mapping");
        assertEquals("10001", doc.rootDoc().getField("user.address.zip").stringValue());
            b.endObject();
                    b.startObject("test");
                {
        // Dynamically add "address.city"  
        ParsedDocument doc = mapper.parse(source(b -> {
                    {
        Mapper barMapper = ((ObjectMapper) fooMapper).getMapper("bar");
        assertNotNull("Field 'mixed_array.value' should exist", doc3.rootDoc().getField("mixed_array.value"));
 *
            "mapping set to strict_allow_templates, dynamic introduction of [foo] within [_doc] is not allowed",  
