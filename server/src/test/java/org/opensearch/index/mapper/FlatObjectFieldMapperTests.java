    protected boolean supportsOrIgnoresBoost() {
        assertTrue(ft.hasDocValues());
    }
        IndexableField[] fields = parsedDocument.rootDoc().getFields("field");  
    }
        MapperService mapperService = createMapperService(fieldMapping(b -> { minimalMapping(b); }));
            doc = mapper.parse(source(json));  
                return null;
        );
            fields = doc.rootDoc().getFields("field");
            assertEquals(FieldNamesFieldMapper.NAME, termQuery.getTerm().field());  
            fieldValues = doc.rootDoc().getFields("field" + VALUE_SUFFIX);  
        // Parsing writes doc-values only: no indexed terms for the root, value, or valueAndPath fields.  
            assertEquals(2, fieldValueAndPaths.length);
            assertNoFieldNamesField(fields);  
        FlatObjectFieldMapper.FlatObjectFieldType fieldType = (FlatObjectFieldMapper.FlatObjectFieldType) mapperService.fieldType("field");
        assertEquals(2, fields.length);  
        ParsedDocument doc = mapper.parse(source(json));
        XContentBuilder parsedFromOrig = JsonXContent.contentBuilder().startObject();
        ParsedDocument doc = mapper.parse(source(b -> b.startObject("field").field("foo", "bar").endObject()));
            assertEquals(4, fields.length);
            makeFieldsAssertion.apply("3", "4", fieldValues);  
            assertEquals(2, fieldValueAndPaths.length);
            // test3: {"field":{"name":null, "age":"5", "name1":null}}  
        // test2: {"field":{"name": null,"age":3}}
            assertEquals(4, fields.length);  
        assertEquals(new BytesRef("3"), fieldValues[0].binaryValue());
 * SPDX-License-Identifier: Apache-2.0
        }  
            // test15: {"field":{"name": [{"name":"age1"}, null, {"d":{"name":"dsds"}}]}}
        assertEquals(2, fields.length);  
            assertEquals(4, fields.length);  
    }  
    public void testDerivedSourceRejectedOnVanillaIndex() {  
    }  
            assertEquals(2, fields.length);
        MappedFieldType unsearchable = createMapperService(fieldMapping(b -> b.field("type", "flat_object").field("index", false)))  
            .startObject("field")
                assertEquals(fields[i].toString(), fields1[i].toString());
            }
        MappedFieldType searchable = createMapperService(fieldMapping(this::minimalMapping)).fieldType("field");  
        builder.endObject();
        if (fieldType.hasDocValues() && fieldType.isSubField() == false) {
            fields = doc.rootDoc().getFields("field");  
            assertEquals(2, fieldValues.length);  
            assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field" + VALUE_SUFFIX));
        // In the future we will want to make sure parameter updates are covered.
            .startObject("field")
        String json = XContentFactory.jsonBuilder()  
            assertEquals(new BytesRef("field.age"), fields[0].binaryValue());
                assertNotNull(fields.getField(FieldNamesFieldMapper.NAME));
    public void testNullValue() throws IOException {
            () -> createMapperService(settings, fieldMapping(this::minimalMapping))
        assertExistsQuery(fieldType, query, fields);  
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
            fieldValues = doc.rootDoc().getFields("field" + VALUE_SUFFIX);  
import org.opensearch.index.query.QueryShardContext;
    }
            assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field" + VALUE_AND_PATH_SUFFIX));
        MapperService mapperService = createMapperService(fieldMapping(b -> b.field("type", "flat_object")));
        createMapperService(fieldMapping(this::minimalMapping)).documentMapper().mapping().toXContent(orig, ToXContent.EMPTY_PARAMS);  
    public void testDefaultsDoNotUseDocumentInput() throws Exception {
import java.util.List;
    public void minimalMapping(XContentBuilder b) throws IOException {
        assertEquals(2, fieldValues.length);
            assertEquals(new BytesRef("field.name.name1=dsdsdsd"), fieldValueAndPaths[0].binaryValue());
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));  
            fieldMapping(b -> b.startObject("properties").startObject("foo").field("type", "flat_object").endObject().endObject())
    public void testFetchDocValues() throws IOException {
        ParseContext.Document fields = mapperService.documentMapper().parse(source(this::writeField)).rootDoc();
            doc = mapper.parse(source(json));
    protected void assertExistsQuery(FlatObjectFieldMapper.FlatObjectFieldType fieldType, Query query, ParseContext.Document fields) {  
            assertEquals(2, fieldValues.length);
            doc = mapper.parse(source(json));
        );  
            assertEquals(new BytesRef("dsdsdsd"), fieldValues[0].binaryValue());  
}
        IndexableField[] fieldValues = doc.rootDoc().getFields("field" + VALUE_SUFFIX);
            assertEquals(2, fieldValues.length);
            assertEquals(2, fieldValueAndPaths.length);
            assertEquals(4, fields.length);
        return false;  
        );  
import static org.opensearch.index.mapper.FlatObjectFieldMapper.CONTENT_TYPE;
        assertEquals(2, fieldValues.length);
            for (IndexableField field : doc.rootDoc().getFields(fieldName)) {  
        assertEquals(new BytesRef("field.foo"), fields[0].binaryValue());
        orig.endObject();
            assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field"));
            // test valueField
            assertEquals(4, fields.length);  
            assertEquals(4, fieldValues.length);
            assertThat(query, instanceOf(TermQuery.class));
        if (fieldType.hasDocValues()) {
            fieldValueAndPaths = doc.rootDoc().getFields("field" + VALUE_AND_PATH_SUFFIX);
            json = "{\"field\":{\"name\": {\"name1\": [[],[\"dsdsdsd\", null]]}}}";  
            .startObject()  
    public void testMapperServiceHasParser() throws IOException {  
        createMapperService(orig).documentMapper().mapping().toXContent(parsedFromOrig, ToXContent.EMPTY_PARAMS);
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
            DocValueFormat format = ft.docValueFormat(null, null);  
            // test5: {"field":[null]}
            // test1: {"field":null}
        builder.startObject();
            json = "{\"field\":{\"r1\": {\"labels\": [null]}}}";
        }
import static org.opensearch.index.mapper.FlatObjectFieldMapper.VALUE_AND_PATH_SUFFIX;
    public void testDefaults() throws Exception {  
            assertEquals(4, fields.length);
                    List.of(new BytesRef(v1), new BytesRef(v2)),
        DocumentMapper mapper = createDocumentMapper(mapping);
            doc = mapper.parse(source(json));  
        ParsedDocument doc = mapper.parse(source(json));
package org.opensearch.index.mapper;
        mapper.mapping().toXContent(orig, ToXContent.EMPTY_PARAMS);
            .endObject()
import org.opensearch.common.settings.Settings;
    @Override
            assertEquals(new BytesRef("4"), fieldValues[0].binaryValue());  
            assertEquals(2, fieldValueAndPaths.length);  
     */  
import org.opensearch.search.DocValueFormat;  
/*  
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);
        String json = XContentFactory.jsonBuilder()
            .field("foo", "bar")  
        IndexableFieldType fieldType = fields[0].fieldType();  
            .fieldType("field");
            } else {
            // test8: {"field":{"r1": {"name": null,"labels": [null]}}}
        assertEquals(new BytesRef("field.age=3"), fieldValueAndPaths[0].binaryValue());
            fieldValueAndPaths = doc.rootDoc().getFields("field" + VALUE_AND_PATH_SUFFIX);
        MappedFieldType ft = mapperService.fieldType("field");  
            fieldValueAndPaths = doc.rootDoc().getFields("field" + VALUE_AND_PATH_SUFFIX);  
            fieldValueAndPaths = doc.rootDoc().getFields("field" + VALUE_AND_PATH_SUFFIX);  
            assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field"));
            MapperParsingException.class,
            doc = mapper.parse(source(json));  
            assertEquals(4, fieldValues.length);  
            json = "{\"field\":{\"name\": [null, {\"d\":{\"name\":\"dsds\"}}]}}";  
            assertDocValuesField(fields, "field");
            assertEquals(new BytesRef("5"), fieldValues[0].binaryValue());
        IndexableField[] fields = doc.rootDoc().getFields("field");
            assertEquals(4, fieldValueAndPaths.length);  
    }  
        assertEquals(DocValuesType.NONE, fieldType.docValuesType());
            fieldValues = doc.rootDoc().getFields("field" + VALUE_SUFFIX);  
            assertEquals(new BytesRef("field.name"), fields[0].binaryValue());
        assertEquals(orig.toString(), parsedFromOrig.toString());
            assertEquals(2, fields.length);
            makeFieldsAssertion.apply("field.name", "field.age", fields);
        }
    /**  
     * @param builder builder
            assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field"));
        assertEquals(new BytesRef("bar"), fieldValues[0].binaryValue());
            assertEquals(2, fieldValueAndPaths.length);
            fields = doc.rootDoc().getFields("field");
import static org.opensearch.index.mapper.FlatObjectFieldMapper.VALUE_SUFFIX;  
import java.util.Set;
            assertEquals(new BytesRef("3"), fieldValues[0].binaryValue());
import org.apache.lucene.search.TermQuery;
            makeFieldsAssertion.apply("field.name=3", "field.age=4", fieldValueAndPaths);
            doc = mapper.parse(source(json));
            IndexableField[] fields1 = doc.rootDoc().getFields("field");
        assertEquals(Set.of(FieldTypeCapabilities.Capability.COLUMNAR_STORAGE), unsearchable.requestedCapabilities());
        IndexableField[] fieldValues;
        {  
    public void testPatternMatch() throws IOException {  
        IndexableField[] fields = doc.rootDoc().getFields("field");
import org.apache.lucene.search.Query;  
            doc = mapper.parse(source(json));
            assertEquals(2, fieldValueAndPaths.length);
        assertFalse(ft.isSearchable());
            for (int i = 0; i < fields1.length; i++) {  
            fields = doc.rootDoc().getFields("field");
        XContentBuilder mapping = fieldMapping(b -> b.field("type", "flat_object").field("index", false));
 * compatible open source license.
import org.opensearch.common.xcontent.json.JsonXContent;
            // test16: {"field":{"name": {"name1": [null,"dsdsdsd"]}}}  
        } else {  
            // test7: {"field":{"r1": {"labels": [null]}}}  
            assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field" + VALUE_AND_PATH_SUFFIX));  
        ParsedDocument parsedDocument = mapper.parse(source(b -> b.nullField("field")));
            assertEquals(2, fields.length);
            fields = doc.rootDoc().getFields("field");
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);  
            .endObject()
            assertThat(query, instanceOf(FieldExistsQuery.class));  
            assertEquals(4, fieldValues.length);
            .field("foo", "bar")
                assertEquals(fieldName + " must not be indexed", IndexOptions.NONE, field.fieldType().indexOptions());
            fieldValues = doc.rootDoc().getFields("field" + VALUE_SUFFIX);
            assertTrue(fieldName + " must still write doc values", doc.rootDoc().getFields(fieldName).length > 0);
    public void testIndexFalse() throws Exception {  
            assertEquals(new BytesRef("field.name.name1=dsdsdsd"), fieldValueAndPaths[0].binaryValue());  
        {
            doc = mapper.parse(source(json));
        Set<String> fields = queryShardContext.simpleMatchToIndexNames("field.*");  
            json = "{\"field\":{\"name\": [{\"name\":\"age1\"}, null, {\"d\":{\"name\":\"dsds\"}}]}}";
            json = "{\"field\":{\"age\":\"4\",\"labels\": [null]}}";
import static org.hamcrest.Matchers.containsString;
            assertEquals(new BytesRef("4"), fieldValues[0].binaryValue());
            fieldValues = doc.rootDoc().getFields("field" + VALUE_SUFFIX);
            makeFieldsAssertion.apply("dsds", "age1", fieldValues);  
            doc = mapper.parse(source(b -> b.nullField("field")));  
            json = "{\"field\":{\"name\":null, \"age\":\"5\", \"name1\":null}}";
import static org.hamcrest.core.IsEqual.equalTo;
        assertEquals(new BytesRef("field.age"), fields[0].binaryValue());
            // test10: {"field":{"age": 4,"name": [null,"3"]}}
        // Test internal substring fields as well  
            searchable.requestedCapabilities()  
            assertEquals(new BytesRef("field.age=4"), fieldValueAndPaths[0].binaryValue());
        assertEquals(
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
        assertEquals(IndexOptions.DOCS, fieldValues[0].fieldType().indexOptions());
        DocumentMapper mapper = mapperService.documentMapper();
            .toString();
        String json;  
import java.io.IOException;  
        MapperParsingException e = expectThrows(  
            assertEquals(new BytesRef("field.age"), fields[0].binaryValue());
            fieldValues = doc.rootDoc().getFields("field" + VALUE_SUFFIX);
            assertEquals(new BytesRef("field.name.d.name=dsds"), fieldValueAndPaths[0].binaryValue());
            fields = doc.rootDoc().getFields("field");  
import org.apache.lucene.index.IndexableFieldType;
        ParsedDocument doc = mapper.parse(source(json));
            makeFieldsAssertion.apply("field.name", "field.age", fields);  
            json = "{\"field\":{\"age\": 4,\"name\": [null,\"3\"]}}";  
import org.opensearch.core.xcontent.ToXContent;
    }
import org.opensearch.common.util.set.Sets;
            assertEquals(new BytesRef("field.name"), fields[2].binaryValue());
                );  
        orig.endObject();  
        MapperService mapperService = createMapperService(mapping);
    }
            TriFunction<String, String, IndexableField[], Void> makeFieldsAssertion = (v1, v2, fs) -> {
            doc = mapper.parse(source(json));
    protected void registerParameters(ParameterChecker checker) throws IOException {  
        assertEquals(IndexOptions.DOCS, fieldValues[0].fieldType().indexOptions());  
            TermQuery termQuery = (TermQuery) query;
            MappedFieldType ft = mapperService.fieldType("field");  
            assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field" + VALUE_AND_PATH_SUFFIX));
            json = "{\"field\":{\"labels\": [null], \"age\":\"4\"}}";
    }
            json = "{\"field\":{\"age\":3, \"name\": null}}";  
        }
        }
public class FlatObjectFieldMapperTests extends MapperTestCase {  
            assertEquals(new BytesRef("field.name1"), fields[2].binaryValue());  
            assertEquals(2, fieldValueAndPaths.length);
import org.apache.lucene.util.BytesRef;
        createMapperService(orig).documentMapper().mapping().toXContent(parsedFromOrig, ToXContent.EMPTY_PARAMS);  
        MapperService mapperService = createMapperService(
        XContentBuilder orig = JsonXContent.contentBuilder().startObject();
            assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field" + VALUE_AND_PATH_SUFFIX));  
        XContentBuilder mapping = fieldMapping(this::minimalMapping);
            .startObject()
            json = "{\"field\":{\"name\": [{\"d\":{\"name\":\"dsds\"}}, null]}}";
 */  
        assertEquals(mapping.toString(), mapper.mappingSource().toString());  
            };
        IndexableField[] fieldValues = doc.rootDoc().getFields("field" + VALUE_SUFFIX);
import org.apache.lucene.search.FieldExistsQuery;
            assertEquals(new BytesRef("field.d"), fields[0].binaryValue());
        assertEquals(0, fields.length);
            fieldValueAndPaths = doc.rootDoc().getFields("field" + VALUE_AND_PATH_SUFFIX);  
import org.opensearch.core.xcontent.XContentBuilder;  
            assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field" + VALUE_AND_PATH_SUFFIX));  
            Set.of(FieldTypeCapabilities.Capability.FULL_TEXT_SEARCH, FieldTypeCapabilities.Capability.COLUMNAR_STORAGE),
            makeFieldsAssertion.apply("field.name=3", "field.age=4", fieldValueAndPaths);  
    }
            assertEquals(4, fields.length);  
            Object object = format.format(new BytesRef(storedValue));  
        assertEquals(1, parsedDocument.docs().size());
            fieldValueAndPaths = doc.rootDoc().getFields("field" + VALUE_AND_PATH_SUFFIX);
            .endObject()  
            // test9: {"field":{"name": [null,3],"age":4}}
        IndexableField[] fieldValueAndPaths = doc.rootDoc().getFields("field" + VALUE_AND_PATH_SUFFIX);  
        {
            assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field" + VALUE_SUFFIX));  
        parsedFromOrig.endObject();
     * Writes a sample value for the field to the provided {@link XContentBuilder}.
            MappedFieldType ft = mapperService.fieldType("field.name");
    }  
        String json = "{\"field\":{\"name\": null,\"age\":3}}";  
        }  
        MatcherAssert.assertThat(e.getCause(), instanceOf(UnsupportedOperationException.class));
            assertEquals(new BytesRef("field.name"), fields[2].binaryValue());
            assertEquals("field", termQuery.getTerm().text());
        assertParseMaximalWarnings();  
    }
        assertFalse(fieldType.stored());
            fieldValueAndPaths = doc.rootDoc().getFields("field" + VALUE_AND_PATH_SUFFIX);
            doc = mapper.parse(source(json));  
import org.opensearch.common.xcontent.XContentFactory;  
            doc = mapper.parse(source(json));
            doc = mapper.parse(source(b -> b.array("field", (String[]) null)));  
        assertThat(mapper.mappingSource().toString(), containsString("\"index\":false"));  
            assertEquals(new BytesRef("dsds"), fieldValues[0].binaryValue());
        IndexableField[] fieldValueAndPaths = doc.rootDoc().getFields("field" + VALUE_AND_PATH_SUFFIX);
            makeFieldsAssertion.apply("field.d", "field.name", fields);  
            assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field"));
        builder.field("foo", "bar");  
        assertNotNull(parser);  
            assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field" + VALUE_SUFFIX));
            assertEquals(new BytesRef("field.age"), fields[0].binaryValue());
            fields = doc.rootDoc().getFields("field");
            assertEquals(2, fieldValues.length);
        }
            assertEquals(2, fieldValues.length);
    }
        assertThat(fieldType.indexOptions(), equalTo(IndexOptions.DOCS));  
            json = "{\"field\":{\"r1\": {\"name\": null,\"labels\": [null]}}}";
    protected void assertExistsQuery(MapperService mapperService) throws IOException {
            // test11: {"field":{"age":"4","labels": [null]}}  
            fieldValueAndPaths = doc.rootDoc().getFields("field" + VALUE_AND_PATH_SUFFIX);  
            assertEquals(new BytesRef("field.age=4"), fieldValueAndPaths[0].binaryValue());  
            assertEquals(new BytesRef("field.name.d.name=dsds"), fieldValueAndPaths[0].binaryValue());
        {
            assertEquals(fieldType.name(), fieldExistsQuery.getField());
            assertEquals(2, fieldValues.length);
            fieldValueAndPaths = doc.rootDoc().getFields("field" + VALUE_AND_PATH_SUFFIX);
            json = "{\"field\":{\"name\": {\"name1\": [null,\"dsdsdsd\"]}}}";
            .endObject()
            fieldValueAndPaths = doc.rootDoc().getFields("field" + VALUE_AND_PATH_SUFFIX);
import org.apache.lucene.index.DocValuesType;
            assertEquals("1234", object);
        for (String fieldName : new String[] { "field", "field" + VALUE_SUFFIX, "field" + VALUE_AND_PATH_SUFFIX }) {
            assertEquals(new BytesRef("field.age"), fields[0].binaryValue());  
import org.apache.lucene.index.IndexableField;  
            if (fieldType.isSearchable()) {  
        assertEquals(Sets.newHashSet("field.foo"), fields);
        assertTrue(parser instanceof FlatObjectFieldMapper.TypeParser);
                assertNoFieldNamesField(fields);  
            assertEquals(new BytesRef("field.name"), fields[0].binaryValue());
            assertEquals(new BytesRef("field.name.d.name=dsds"), fieldValueAndPaths[2].binaryValue());
            // test14: {"field":{"name": [{"d":{"name":"dsds"}}, null]}}
        } else {
        assertEquals(1, fields.size());
            fieldValues = doc.rootDoc().getFields("field" + VALUE_SUFFIX);
            fields = doc.rootDoc().getFields("field");
            assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field" + VALUE_SUFFIX));
    public void testMinimalToMaximal() throws IOException {
    }
        assertEquals(new BytesRef("field.foo=bar"), fieldValueAndPaths[0].binaryValue());  
            fields = doc.rootDoc().getFields("field");  
            // test6: {"field":{"labels": [null]}}
    }  
    }
            doc = mapper.parse(source(json));
            fieldValues = doc.rootDoc().getFields("field" + VALUE_SUFFIX);  
            json = "{\"field\":{\"labels\": [null]}}";  
                MatcherAssert.assertThat(  
            assertEquals("Field [field] of type [flat_object] does not support doc_value in root field", throwable.getMessage());
        assertEquals(orig.toString(), parsedFromOrig.toString());
    protected boolean supportsMeta() {
        assertEquals(2, fields.length);  
            fields = doc.rootDoc().getFields("field");
            assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field" + VALUE_AND_PATH_SUFFIX));  
        assertFalse(fieldType.tokenized());
            assertEquals(new BytesRef("dsdsdsd"), fieldValues[0].binaryValue());
            assertEquals(new BytesRef("field.name.name=age1"), fieldValueAndPaths[0].binaryValue());  
        // Pluggable-side acceptance: PluggableFormatNestedSeamsTests#testFlatObjectAcceptedUnderPluggableDerivedSource.
            doc = mapper.parse(source(json));  
            assertEquals(new BytesRef("field.age=5"), fieldValueAndPaths[0].binaryValue());
            assertEquals(2, fieldValues.length);
        XContentBuilder orig = JsonXContent.contentBuilder().startObject();
 *
    public void testInfiniteLoopWithNullValue() throws IOException {  
            }  
            .toString();  
            fieldValues = doc.rootDoc().getFields("field" + VALUE_SUFFIX);
            assertEquals(new BytesRef("field.age=3"), fieldValueAndPaths[0].binaryValue());
        b.field("type", CONTENT_TYPE);  
        return false;
            makeFieldsAssertion.apply("3", "4", fieldValues);
            assertEquals(new BytesRef("field.d"), fields[0].binaryValue());
    }  
            assertEquals(new BytesRef("field.name1"), fields[2].binaryValue());
        ParsedDocument doc;
            doc = mapper.parse(source(json));  
            assertEquals(2, fields.length);  
            assertEquals(fields1.length, fields.length);
            Throwable throwable = assertThrows(IllegalArgumentException.class, () -> ft.docValueFormat(null, null));
        Query query = fieldType.existsQuery(queryShardContext);
            assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field" + VALUE_SUFFIX));
        assertEquals(2, fieldValueAndPaths.length);  
        // Serialization round-trips: "index": false must survive toXContent -> reparse.
            doc = mapper.parse(source(json));
    protected void writeFieldValue(XContentBuilder builder) throws IOException {
import org.hamcrest.MatcherAssert;
        MatcherAssert.assertThat(e.getMessage(), containsString("flat_object"));
            assertNoDocValuesField(fields, "field");
    }
        Mapper.TypeParser parser = mapperService.mapperRegistry.getMapperParsers().get(CONTENT_TYPE);
            String storedValue = "field.field.name=1234";
            assertEquals(new BytesRef("dsds"), fieldValues[0].binaryValue());
                assertEquals(fieldName + " must keep doc values", DocValuesType.SORTED_SET, field.fieldType().docValuesType());
            }
            json = "{\"field\":{\"name\": {\"name1\": {\"name2\":null}}}}";
import static org.hamcrest.Matchers.containsInAnyOrder;
            assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field"));
                    containsInAnyOrder(fs[0].binaryValue(), fs[2].binaryValue())
            // test4: {"field":{"name": {"name1": {"name2":null}}}}
            // test2: {"field":{"age":3, "name": null}}
            assertEquals(2, fieldValueAndPaths.length);
        XContentBuilder parsedFromOrig = JsonXContent.contentBuilder().startObject();
import org.opensearch.common.TriFunction;  
            // test13: {"field":{"name": [null, {"d":{"name":"dsds"}}]}}
            // test valueWithPathField
            json = "{\"field\":{\"name\": [null,3],\"age\":4}}";
            // test12: {"field":{"labels": [null], "age":"4"}}
import org.apache.lucene.index.IndexOptions;
        Settings settings = Settings.builder().put("index.derived_source.enabled", true).build();
            assertEquals(4, fieldValueAndPaths.length);
            fieldValues = doc.rootDoc().getFields("field" + VALUE_SUFFIX);  
        parsedFromOrig.endObject();  
            // test17: {"field":{"name": {"name1": [[],["dsdsdsd", null]]}}}
        IndexableField[] fieldValueAndPaths;
import static org.hamcrest.Matchers.instanceOf;  
        assertEquals(2, fieldValues.length);  
            fieldValueAndPaths = doc.rootDoc().getFields("field" + VALUE_AND_PATH_SUFFIX);  
    public void testRequestedCapabilitiesFollowIndexSetting() throws Exception {
            assertEquals(2, fieldValues.length);
 * The OpenSearch Contributors require contributions made to  
        IndexableField[] fields = doc.rootDoc().getFields("field");
            assertEquals(4, fieldValueAndPaths.length);
 * this file be licensed under the Apache-2.0 license or a
            FieldExistsQuery fieldExistsQuery = (FieldExistsQuery) query;
            fieldValues = doc.rootDoc().getFields("field" + VALUE_SUFFIX);
            assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field" + VALUE_SUFFIX));
            assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field"));  
