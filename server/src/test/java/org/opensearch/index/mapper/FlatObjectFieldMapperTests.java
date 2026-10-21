            fieldValueAndPaths = doc.rootDoc().getFields("field" + VALUE_AND_PATH_SUFFIX);
            json = "{\"field\":{\"age\":3, \"name\": null}}";
            fieldValueAndPaths = doc.rootDoc().getFields("field" + VALUE_AND_PATH_SUFFIX);
            .fieldType("field");
            assertDocValuesField(fields, "field");
    public void testMapperServiceHasParser() throws IOException {
            FieldExistsQuery fieldExistsQuery = (FieldExistsQuery) query;
    public void testInfiniteLoopWithNullValue() throws IOException {
    }
            json = "{\"field\":{\"name\": [{\"name\":\"age1\"}, null, {\"d\":{\"name\":\"dsds\"}}]}}";
import org.apache.lucene.util.BytesRef;
        IndexableField[] fields = parsedDocument.rootDoc().getFields("field");
    @Override
            assertEquals(new BytesRef("field.age"), fields[0].binaryValue());
        }
        assertEquals(2, fieldValues.length);
        Query query = fieldType.existsQuery(queryShardContext);
        XContentBuilder mapping = fieldMapping(this::minimalMapping);
            .startObject("field")
        assertEquals(2, fieldValues.length);
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);
            assertThat(query, instanceOf(FieldExistsQuery.class));
            makeFieldsAssertion.apply("field.name", "field.age", fields);
        assertEquals(new BytesRef("field.foo=bar"), fieldValueAndPaths[0].binaryValue());
    }
        createMapperService(fieldMapping(this::minimalMapping)).documentMapper().mapping().toXContent(orig, ToXContent.EMPTY_PARAMS);
            fields = doc.rootDoc().getFields("field");
            fieldValueAndPaths = doc.rootDoc().getFields("field" + VALUE_AND_PATH_SUFFIX);
            .field("foo", "bar")
            .toString();
        XContentBuilder mapping = fieldMapping(b -> b.field("type", "flat_object").field("index", false));
        }
        return false;
        orig.endObject();
            json = "{\"field\":{\"labels\": [null]}}";
            .endObject()
            assertEquals("field", termQuery.getTerm().text());
            fieldValues = doc.rootDoc().getFields("field" + VALUE_SUFFIX);
            .endObject()
        MapperService mapperService = createMapperService(fieldMapping(b -> { minimalMapping(b); }));
        Set<String> fields = queryShardContext.simpleMatchToIndexNames("field.*");
            fields = doc.rootDoc().getFields("field");
        assertEquals(IndexOptions.DOCS, fieldValues[0].fieldType().indexOptions());
 * SPDX-License-Identifier: Apache-2.0
            assertEquals(new BytesRef("field.age=5"), fieldValueAndPaths[0].binaryValue());
            String storedValue = "field.field.name=1234";
            assertEquals(4, fields.length);
            assertEquals(new BytesRef("field.name"), fields[2].binaryValue());
            assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field" + VALUE_AND_PATH_SUFFIX));
        if (fieldType.hasDocValues()) {
        }
            assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field" + VALUE_AND_PATH_SUFFIX));
        IndexableField[] fields = doc.rootDoc().getFields("field");
        assertEquals(new BytesRef("field.age"), fields[0].binaryValue());
        // Serialization round-trips: "index": false must survive toXContent -> reparse.
    public void testDefaults() throws Exception {
            }
 * The OpenSearch Contributors require contributions made to
            assertEquals(2, fieldValues.length);
    public void testDerivedSourceRejectedOnVanillaIndex() {
            // test9: {"field":{"name": [null,3],"age":4}}
            assertEquals(new BytesRef("field.name1"), fields[2].binaryValue());
            json = "{\"field\":{\"name\": [null, {\"d\":{\"name\":\"dsds\"}}]}}";
        XContentBuilder orig = JsonXContent.contentBuilder().startObject();
        assertParseMaximalWarnings();
            assertNoFieldNamesField(fields);
import static org.opensearch.index.mapper.FlatObjectFieldMapper.VALUE_AND_PATH_SUFFIX;
        assertEquals(new BytesRef("bar"), fieldValues[0].binaryValue());
            fields = doc.rootDoc().getFields("field");
import org.opensearch.common.settings.Settings;
        assertEquals(2, fieldValues.length);
    }
    }
            assertEquals(fieldType.name(), fieldExistsQuery.getField());
        builder.field("foo", "bar");
            fieldValues = doc.rootDoc().getFields("field" + VALUE_SUFFIX);
import org.apache.lucene.search.Query;
import static org.hamcrest.Matchers.instanceOf;
import java.util.List;
                MatcherAssert.assertThat(
        }
        {
            assertEquals(new BytesRef("dsds"), fieldValues[0].binaryValue());
            fieldValueAndPaths = doc.rootDoc().getFields("field" + VALUE_AND_PATH_SUFFIX);
        String json = "{\"field\":{\"name\": null,\"age\":3}}";
            doc = mapper.parse(source(json));
            assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field"));
            doc = mapper.parse(source(json));
import org.opensearch.common.TriFunction;
            assertEquals(new BytesRef("field.age"), fields[0].binaryValue());
        assertEquals(2, fieldValueAndPaths.length);
        assertEquals(0, fields.length);
            assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field" + VALUE_SUFFIX));
        assertEquals(Set.of(FieldTypeCapabilities.Capability.COLUMNAR_STORAGE), unsearchable.requestedCapabilities());
            fieldValueAndPaths = doc.rootDoc().getFields("field" + VALUE_AND_PATH_SUFFIX);
            makeFieldsAssertion.apply("3", "4", fieldValues);
        );
            fieldValues = doc.rootDoc().getFields("field" + VALUE_SUFFIX);
        if (fieldType.hasDocValues() && fieldType.isSubField() == false) {
        MapperService mapperService = createMapperService(
import org.apache.lucene.index.IndexableField;
            // test17: {"field":{"name": {"name1": [[],["dsdsdsd", null]]}}}
import org.apache.lucene.index.IndexOptions;
        assertEquals(orig.toString(), parsedFromOrig.toString());
import org.opensearch.core.xcontent.ToXContent;
        assertTrue(parser instanceof FlatObjectFieldMapper.TypeParser);
            () -> createMapperService(settings, fieldMapping(this::minimalMapping))
        assertEquals(Sets.newHashSet("field.foo"), fields);
                assertEquals(fieldName + " must keep doc values", DocValuesType.SORTED_SET, field.fieldType().docValuesType());
            assertEquals(new BytesRef("field.age"), fields[0].binaryValue());
                assertEquals(fields[i].toString(), fields1[i].toString());
            makeFieldsAssertion.apply("field.d", "field.name", fields);
            assertEquals(new BytesRef("4"), fieldValues[0].binaryValue());
            assertEquals(2, fieldValueAndPaths.length);
            doc = mapper.parse(source(json));
import java.util.Set;
            fieldValues = doc.rootDoc().getFields("field" + VALUE_SUFFIX);
        ParseContext.Document fields = mapperService.documentMapper().parse(source(this::writeField)).rootDoc();
            assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field" + VALUE_AND_PATH_SUFFIX));
            fields = doc.rootDoc().getFields("field");
        IndexableFieldType fieldType = fields[0].fieldType();
        }
            assertEquals(4, fields.length);
        // Test internal substring fields as well
        assertExistsQuery(fieldType, query, fields);
            fieldValues = doc.rootDoc().getFields("field" + VALUE_SUFFIX);
            assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field" + VALUE_AND_PATH_SUFFIX));
                    List.of(new BytesRef(v1), new BytesRef(v2)),
    public void testIndexFalse() throws Exception {
            fieldValues = doc.rootDoc().getFields("field" + VALUE_SUFFIX);
        assertEquals(1, parsedDocument.docs().size());
        ParsedDocument doc = mapper.parse(source(json));
    /**
    protected void writeFieldValue(XContentBuilder builder) throws IOException {
    public void testFetchDocValues() throws IOException {
            fieldValueAndPaths = doc.rootDoc().getFields("field" + VALUE_AND_PATH_SUFFIX);
            assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field" + VALUE_AND_PATH_SUFFIX));
            // test2: {"field":{"age":3, "name": null}}
            .endObject()
            makeFieldsAssertion.apply("field.name", "field.age", fields);
        assertFalse(ft.isSearchable());
    }
            doc = mapper.parse(source(b -> b.array("field", (String[]) null)));
            .field("foo", "bar")
            doc = mapper.parse(source(json));
 */
        assertEquals(mapping.toString(), mapper.mappingSource().toString());
    }
import static org.hamcrest.Matchers.containsString;
            doc = mapper.parse(source(json));
            };
            fields = doc.rootDoc().getFields("field");
        IndexableField[] fieldValues = doc.rootDoc().getFields("field" + VALUE_SUFFIX);
     * Writes a sample value for the field to the provided {@link XContentBuilder}.
            assertEquals(FieldNamesFieldMapper.NAME, termQuery.getTerm().field());
import org.apache.lucene.index.DocValuesType;
            for (int i = 0; i < fields1.length; i++) {
        assertThat(mapper.mappingSource().toString(), containsString("\"index\":false"));
            assertEquals(4, fieldValues.length);
/*
            assertEquals(4, fieldValues.length);
            for (IndexableField field : doc.rootDoc().getFields(fieldName)) {
            // test valueField
        assertTrue(ft.hasDocValues());
            // test4: {"field":{"name": {"name1": {"name2":null}}}}
            doc = mapper.parse(source(json));
        assertEquals(2, fields.length);
        // In the future we will want to make sure parameter updates are covered.
            .startObject()
            doc = mapper.parse(source(json));
            assertEquals(new BytesRef("field.age"), fields[0].binaryValue());
        // Parsing writes doc-values only: no indexed terms for the root, value, or valueAndPath fields.
        String json;
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
        assertEquals(DocValuesType.NONE, fieldType.docValuesType());
            fieldValues = doc.rootDoc().getFields("field" + VALUE_SUFFIX);
import org.opensearch.common.util.set.Sets;
            fields = doc.rootDoc().getFields("field");
            // test10: {"field":{"age": 4,"name": [null,"3"]}}
            assertEquals(4, fields.length);
            assertEquals(2, fieldValues.length);
            fieldValueAndPaths = doc.rootDoc().getFields("field" + VALUE_AND_PATH_SUFFIX);
            json = "{\"field\":{\"name\": [null,3],\"age\":4}}";
            assertThat(query, instanceOf(TermQuery.class));
        IndexableField[] fieldValueAndPaths = doc.rootDoc().getFields("field" + VALUE_AND_PATH_SUFFIX);
            assertEquals(2, fieldValueAndPaths.length);
            fields = doc.rootDoc().getFields("field");
            // test1: {"field":null}
        ParsedDocument doc;
            fields = doc.rootDoc().getFields("field");
    public void testNullValue() throws IOException {
                );
            assertEquals(new BytesRef("5"), fieldValues[0].binaryValue());
            fieldValueAndPaths = doc.rootDoc().getFields("field" + VALUE_AND_PATH_SUFFIX);
            // test valueWithPathField
import org.hamcrest.MatcherAssert;
            assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field" + VALUE_SUFFIX));
        {
        String json = XContentFactory.jsonBuilder()
            assertEquals(4, fieldValueAndPaths.length);
                assertEquals(fieldName + " must not be indexed", IndexOptions.NONE, field.fieldType().indexOptions());
 * this file be licensed under the Apache-2.0 license or a
            assertEquals(2, fields.length);
            Object object = format.format(new BytesRef(storedValue));
            assertEquals(new BytesRef("dsdsdsd"), fieldValues[0].binaryValue());
        // test2: {"field":{"name": null,"age":3}}
    public void testPatternMatch() throws IOException {
        } else {
            assertEquals(2, fields.length);
     */
            assertEquals(2, fieldValueAndPaths.length);
            fields = doc.rootDoc().getFields("field");
        ParsedDocument parsedDocument = mapper.parse(source(b -> b.nullField("field")));
        assertFalse(fieldType.tokenized());
        assertNotNull(parser);
import static org.hamcrest.core.IsEqual.equalTo;
        FlatObjectFieldMapper.FlatObjectFieldType fieldType = (FlatObjectFieldMapper.FlatObjectFieldType) mapperService.fieldType("field");
            assertEquals(2, fieldValues.length);
    protected boolean supportsMeta() {
        );
            assertEquals(2, fieldValues.length);
            // test16: {"field":{"name": {"name1": [null,"dsdsdsd"]}}}
public class FlatObjectFieldMapperTests extends MapperTestCase {
            assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field" + VALUE_SUFFIX));
    public void testMinimalToMaximal() throws IOException {
            assertEquals(new BytesRef("3"), fieldValues[0].binaryValue());
            assertEquals("Field [field] of type [flat_object] does not support doc_value in root field", throwable.getMessage());
            assertEquals(2, fieldValueAndPaths.length);
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
            doc = mapper.parse(source(json));
            assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field" + VALUE_SUFFIX));
        builder.startObject();
        parsedFromOrig.endObject();
            assertEquals(4, fields.length);
            assertEquals(new BytesRef("field.age=4"), fieldValueAndPaths[0].binaryValue());
    }
        MappedFieldType ft = mapperService.fieldType("field");
            // test6: {"field":{"labels": [null]}}
            MappedFieldType ft = mapperService.fieldType("field");
            } else {
        MatcherAssert.assertThat(e.getCause(), instanceOf(UnsupportedOperationException.class));
        XContentBuilder parsedFromOrig = JsonXContent.contentBuilder().startObject();
        IndexableField[] fieldValueAndPaths;
            json = "{\"field\":{\"name\": {\"name1\": [[],[\"dsdsdsd\", null]]}}}";
            .endObject()
    }
            assertEquals(4, fields.length);
            json = "{\"field\":{\"age\":\"4\",\"labels\": [null]}}";
        IndexableField[] fieldValues;
            assertEquals(4, fields.length);
        createMapperService(orig).documentMapper().mapping().toXContent(parsedFromOrig, ToXContent.EMPTY_PARAMS);
            // test14: {"field":{"name": [{"d":{"name":"dsds"}}, null]}}
            // test12: {"field":{"labels": [null], "age":"4"}}
            makeFieldsAssertion.apply("dsds", "age1", fieldValues);
        Settings settings = Settings.builder().put("index.derived_source.enabled", true).build();
        } else {
            makeFieldsAssertion.apply("field.name=3", "field.age=4", fieldValueAndPaths);
        MapperParsingException e = expectThrows(
            IndexableField[] fields1 = doc.rootDoc().getFields("field");
            json = "{\"field\":{\"name\": {\"name1\": {\"name2\":null}}}}";
                    containsInAnyOrder(fs[0].binaryValue(), fs[2].binaryValue())
    }
            assertEquals(new BytesRef("field.d"), fields[0].binaryValue());
            assertEquals(new BytesRef("field.name"), fields[0].binaryValue());
    }
        ParsedDocument doc = mapper.parse(source(json));
            assertEquals(2, fields.length);
            MapperParsingException.class,
import org.opensearch.common.xcontent.json.JsonXContent;
import org.opensearch.index.query.QueryShardContext;
            doc = mapper.parse(source(json));
 * compatible open source license.
            assertEquals(fields1.length, fields.length);
    public void minimalMapping(XContentBuilder b) throws IOException {
        for (String fieldName : new String[] { "field", "field" + VALUE_SUFFIX, "field" + VALUE_AND_PATH_SUFFIX }) {
        XContentBuilder parsedFromOrig = JsonXContent.contentBuilder().startObject();
            assertEquals(new BytesRef("field.name.name1=dsdsdsd"), fieldValueAndPaths[0].binaryValue());
            // test7: {"field":{"r1": {"labels": [null]}}}
            doc = mapper.parse(source(json));
        MapperService mapperService = createMapperService(mapping);
            json = "{\"field\":{\"r1\": {\"labels\": [null]}}}";
        assertEquals(new BytesRef("field.foo"), fields[0].binaryValue());
            assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field"));
            fieldValues = doc.rootDoc().getFields("field" + VALUE_SUFFIX);
            makeFieldsAssertion.apply("field.name=3", "field.age=4", fieldValueAndPaths);
            assertEquals(new BytesRef("field.name1"), fields[2].binaryValue());
            searchable.requestedCapabilities()
import static org.hamcrest.Matchers.containsInAnyOrder;
            // test3: {"field":{"name":null, "age":"5", "name1":null}}
        // Pluggable-side acceptance: PluggableFormatNestedSeamsTests#testFlatObjectAcceptedUnderPluggableDerivedSource.
}
        IndexableField[] fields = doc.rootDoc().getFields("field");
    }
            json = "{\"field\":{\"name\":null, \"age\":\"5\", \"name1\":null}}";
            doc = mapper.parse(source(json));
    protected void registerParameters(ParameterChecker checker) throws IOException {
            json = "{\"field\":{\"name\": {\"name1\": [null,\"dsdsdsd\"]}}}";
        DocumentMapper mapper = createDocumentMapper(mapping);
        {
            assertEquals(new BytesRef("field.name.name1=dsdsdsd"), fieldValueAndPaths[0].binaryValue());
            assertEquals(4, fieldValueAndPaths.length);
package org.opensearch.index.mapper;
            assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field"));
    public void testRequestedCapabilitiesFollowIndexSetting() throws Exception {
            assertEquals(4, fieldValueAndPaths.length);
            assertEquals(2, fieldValues.length);
        MapperService mapperService = createMapperService(fieldMapping(b -> b.field("type", "flat_object")));
import java.io.IOException;
            if (fieldType.isSearchable()) {
            json = "{\"field\":{\"age\": 4,\"name\": [null,\"3\"]}}";
        String json = XContentFactory.jsonBuilder()
        assertEquals(orig.toString(), parsedFromOrig.toString());
        XContentBuilder orig = JsonXContent.contentBuilder().startObject();
            // test5: {"field":[null]}
        assertEquals(IndexOptions.DOCS, fieldValues[0].fieldType().indexOptions());
            json = "{\"field\":{\"labels\": [null], \"age\":\"4\"}}";
        IndexableField[] fieldValues = doc.rootDoc().getFields("field" + VALUE_SUFFIX);
            TriFunction<String, String, IndexableField[], Void> makeFieldsAssertion = (v1, v2, fs) -> {
            doc = mapper.parse(source(json));
    protected boolean supportsOrIgnoresBoost() {
            assertTrue(fieldName + " must still write doc values", doc.rootDoc().getFields(fieldName).length > 0);
            DocValueFormat format = ft.docValueFormat(null, null);
            assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field"));
            fieldValueAndPaths = doc.rootDoc().getFields("field" + VALUE_AND_PATH_SUFFIX);
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
            doc = mapper.parse(source(json));
        assertEquals(2, fields.length);
            assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field"));
            TermQuery termQuery = (TermQuery) query;
import org.apache.lucene.search.TermQuery;
    }
            assertEquals(new BytesRef("field.age=3"), fieldValueAndPaths[0].binaryValue());
            assertEquals(new BytesRef("field.name.d.name=dsds"), fieldValueAndPaths[0].binaryValue());
        orig.endObject();
            fieldValueAndPaths = doc.rootDoc().getFields("field" + VALUE_AND_PATH_SUFFIX);
            assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field" + VALUE_AND_PATH_SUFFIX));
        MappedFieldType unsearchable = createMapperService(fieldMapping(b -> b.field("type", "flat_object").field("index", false)))
        parsedFromOrig.endObject();
        assertEquals(new BytesRef("3"), fieldValues[0].binaryValue());
        DocumentMapper mapper = mapperService.documentMapper();
            // test8: {"field":{"r1": {"name": null,"labels": [null]}}}
        }
            assertEquals(new BytesRef("field.name"), fields[2].binaryValue());
        return false;
        );
    protected void assertExistsQuery(FlatObjectFieldMapper.FlatObjectFieldType fieldType, Query query, ParseContext.Document fields) {
        ParsedDocument doc = mapper.parse(source(b -> b.startObject("field").field("foo", "bar").endObject()));
import org.apache.lucene.search.FieldExistsQuery;
        MappedFieldType searchable = createMapperService(fieldMapping(this::minimalMapping)).fieldType("field");
            assertEquals(4, fieldValues.length);
        }
        assertEquals(new BytesRef("field.age=3"), fieldValueAndPaths[0].binaryValue());
            assertEquals(2, fieldValues.length);
            MappedFieldType ft = mapperService.fieldType("field.name");
            assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field"));
            assertNoDocValuesField(fields, "field");
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);
        assertFalse(fieldType.stored());
            fieldValues = doc.rootDoc().getFields("field" + VALUE_SUFFIX);
     * @param builder builder
            fieldMapping(b -> b.startObject("properties").startObject("foo").field("type", "flat_object").endObject().endObject())
import org.opensearch.search.DocValueFormat;
    protected void assertExistsQuery(MapperService mapperService) throws IOException {
            assertEquals(2, fields.length);
            json = "{\"field\":{\"name\": [{\"d\":{\"name\":\"dsds\"}}, null]}}";
                return null;
    }
                assertNoFieldNamesField(fields);
    }
            assertEquals(2, fieldValueAndPaths.length);
            json = "{\"field\":{\"r1\": {\"name\": null,\"labels\": [null]}}}";
            Set.of(FieldTypeCapabilities.Capability.FULL_TEXT_SEARCH, FieldTypeCapabilities.Capability.COLUMNAR_STORAGE),
            .startObject("field")
            }
            assertEquals(new BytesRef("field.age=4"), fieldValueAndPaths[0].binaryValue());
            assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field" + VALUE_SUFFIX));
            fieldValues = doc.rootDoc().getFields("field" + VALUE_SUFFIX);
            fieldValueAndPaths = doc.rootDoc().getFields("field" + VALUE_AND_PATH_SUFFIX);
        mapper.mapping().toXContent(orig, ToXContent.EMPTY_PARAMS);
            makeFieldsAssertion.apply("3", "4", fieldValues);
        assertEquals(1, fields.size());
import static org.opensearch.index.mapper.FlatObjectFieldMapper.CONTENT_TYPE;
        {
            Throwable throwable = assertThrows(IllegalArgumentException.class, () -> ft.docValueFormat(null, null));
            assertEquals(new BytesRef("field.d"), fields[0].binaryValue());
import org.opensearch.common.xcontent.XContentFactory;
            assertEquals(new BytesRef("field.name.d.name=dsds"), fieldValueAndPaths[0].binaryValue());
            assertEquals("1234", object);
            assertEquals(new BytesRef("4"), fieldValues[0].binaryValue());
            // test15: {"field":{"name": [{"name":"age1"}, null, {"d":{"name":"dsds"}}]}}
            assertEquals(2, fieldValues.length);
            assertEquals(new BytesRef("dsdsdsd"), fieldValues[0].binaryValue());
            // test13: {"field":{"name": [null, {"d":{"name":"dsds"}}]}}
        Mapper.TypeParser parser = mapperService.mapperRegistry.getMapperParsers().get(CONTENT_TYPE);
            assertEquals(4, fields.length);
            assertEquals(new BytesRef("field.name.name=age1"), fieldValueAndPaths[0].binaryValue());
            assertEquals(2, fieldValueAndPaths.length);
            assertEquals(2, fieldValues.length);
            }
            fields = doc.rootDoc().getFields("field");
 *
                assertNotNull(fields.getField(FieldNamesFieldMapper.NAME));
        IndexableField[] fields = doc.rootDoc().getFields("field");
            .toString();
        MatcherAssert.assertThat(e.getMessage(), containsString("flat_object"));
        assertThat(fieldType.indexOptions(), equalTo(IndexOptions.DOCS));
            doc = mapper.parse(source(b -> b.nullField("field")));
import org.opensearch.core.xcontent.XContentBuilder;
            doc = mapper.parse(source(json));
        IndexableField[] fieldValueAndPaths = doc.rootDoc().getFields("field" + VALUE_AND_PATH_SUFFIX);
    }
            doc = mapper.parse(source(json));
            .startObject()
            assertEquals(2, fieldValueAndPaths.length);
        createMapperService(orig).documentMapper().mapping().toXContent(parsedFromOrig, ToXContent.EMPTY_PARAMS);
        builder.endObject();
    }
    public void testDefaultsDoNotUseDocumentInput() throws Exception {
import org.apache.lucene.index.IndexableFieldType;
            assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field" + VALUE_SUFFIX));
    }
            fieldValues = doc.rootDoc().getFields("field" + VALUE_SUFFIX);
        ParsedDocument doc = mapper.parse(source(json));
        assertEquals(2, fields.length);
        assertEquals(
    }
            assertEquals(new BytesRef("field.name"), fields[0].binaryValue());
            // test11: {"field":{"age":"4","labels": [null]}}
            assertEquals(new BytesRef("field.name.d.name=dsds"), fieldValueAndPaths[2].binaryValue());
import static org.opensearch.index.mapper.FlatObjectFieldMapper.VALUE_SUFFIX;
            assertEquals(new BytesRef("dsds"), fieldValues[0].binaryValue());
        b.field("type", CONTENT_TYPE);
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
            assertEquals(2, fieldValueAndPaths.length);
