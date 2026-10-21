            assertTrue(jsonObject.containsKey(FIELD_NAME));
                    .field("type", "Point")
            assertEquals(1.2, (Double) latLon.get("lat"), 0.001);
    public void testDerivedValueFetching_StoredField_Array() throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
            XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
                source(b -> b.startObject("field").field("type", "Point").array("coordinates", new double[] { 1.1, 1.2, 1.3 }).endObject())
        doc = mapper.parse(source(b -> b.field("field", "1, 2")));
        }));
        ParsedDocument doc = mapper.parse(source(b -> b.startArray("field").value("1.2,1.3").value("1.4,1.5").endArray()));
            GeoPointFieldMapper mapper = getMapper(mapperService, FieldMapper.CopyTo.empty());
    }
    public void testDerivedValueFetching_DocValues_Array() throws IOException {
            GeoPointFieldMapper mapper = getMapper(mapperService, FieldMapper.CopyTo.empty());
        checker.registerUpdateCheck(b -> b.field("ignore_z_value", false), m -> {
        }
            assertTrue(jsonObject.containsKey(FIELD_NAME));
                    .endArray()
        ParsedDocument doc = mapper.parse(source(b -> b.startArray("field").value(1.3).value(1.2).endArray()));
 *
        assertThat(mapper.parse(source(b -> b.field("field", "1.3,NaN"))).rootDoc().getField("field"), nullValue());
        );
                    );
        }
        assertThat(mapper.parse(source(b -> b.field("field", "1.3,-"))).rootDoc().getField("field"), nullValue());
import static org.hamcrest.Matchers.containsString;
        }
                        source(
    }
        assertThat(doc.rootDoc().getField("field"), notNullValue());
    public void testLonLatArrayDynamic() throws Exception {
    }
        ParsedDocument doc = mapper.parse(source(b -> b.startArray("point").value(1.3).value(1.2).endArray()));
            }
        try (Directory directory = newDirectory()) {
                b -> b.field("type", "geo_point")
            source(b -> b.startObject("field").field("type", "Point").array("coordinates", new double[] { 1.1, 1.2 }).endObject())
        FieldMapper.CopyTo copyTo = new FieldMapper.CopyTo.Builder().add("copy_to_field").build();
        try (Directory directory = newDirectory()) {
        mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "geo_point").field("ignore_z_value", false)));
            }
        }
            GeoPointFieldMapper mapper = getMapper(mapperService, FieldMapper.CopyTo.empty());
            assertTrue(gpfm.ignoreMalformed.value());
            validateDerivedSource(mapper, directory);
                            b -> b.startObject(FIELD_NAME)
            b.startObject("fields");
            validateDerivedSourceMultiField(mapper, directory, true);
/*
    }
        checker.registerUpdateCheck(b -> b.field("null_value", "41.12,-71.34"), m -> {
 * this work for additional information regarding copyright
        Exception e = expectThrows(
import org.apache.lucene.util.BytesRef;
 * GitHub history for details.
import org.opensearch.core.common.bytes.BytesReference;
                    .parse(
        assertThat(
 * not use this file except in compliance with the License.
            mapper.parse(source(b -> b.startObject("field").field("lat", 1.2).nullField("lon").endObject())).rootDoc().getField("field"),
/*
 * Licensed to Elasticsearch under one or more contributor
        }
    public void testGeoJsonArray() throws Exception {
    }
            validateDerivedSource(mapper, directory);
            }
            b.startArray().value(1.3).value(1.2).endArray();
            () -> mapper.parse(
 */
        assertThat(fieldMapper, instanceOf(GeoPointFieldMapper.class));
            b.field("type", "geo_point").field("doc_values", false);
import static org.hamcrest.Matchers.arrayWithSize;
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "geo_point").field("ignore_z_value", true)));
        assertThat(mapper.parse(source(b -> b.field("field", "NaN,1.3"))).rootDoc().getField("field"), nullValue());
            mapper.parse(source(b -> b.startObject("field").field("lat", 1.2).field("lon", "NaN").endObject())).rootDoc().getField("field"),
    }
 * Modifications Copyright OpenSearch Contributors. See
            MapperService mapperService = getMapperService(true, false); // doc values
        assertThat(doc.rootDoc().getFields("field"), arrayWithSize(4));
    public void testGeoHashValue() throws Exception {
        AbstractPointGeometryFieldMapper.ParsedPoint nullValue = ((GeoPointFieldMapper) fieldMapper).nullValue;
    @Override
                iw.addDocument(doc.rootDoc());
    public void testGeoJsonZValueException() throws Exception {
                    .field("ignore_z_value", false)
    public void testMultiField() throws Exception {
        assertThat(ignoreZValue, equalTo(false));
            assertEquals(1.3, (Double) latLon.get("lon"), 0.001);
            validateDerivedSource(mapper, directory);
        assertThat(doc.rootDoc().getFields("field"), notNullValue());
            MapperService mapperService = getMapperService(false, true); // doc values
import static org.hamcrest.Matchers.equalTo;
    public void testInvalidGeohashIgnored() throws Exception {
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {
        );
                                .field("coordinates", new double[] { 1.3, 1.2 })
        // geo_point [91, 181] should have been normalized to [89, 1]
            }
        assertThat(doc.rootDoc().getFields("field"), notNullValue());
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "geo_point").field("ignore_z_value", false)));
            mapper.parse(source(b -> b.startObject("field").nullField("lat").field("lon", 1.2).endObject())).rootDoc().getField("field"),
        );
    @Override
            validateDerivedSource(mapper, directory);
        }
            }
    }
            minimalMapping(b);
        builder.value(stringEncode(1.3, 1.2));
        );
    }
        );
        assertThrows(UnsupportedOperationException.class, mapper::canDeriveSource);
        ParsedDocument doc = mapper.parse(source(b -> b.startObject("field").array("coordinates", new double[] { 1.1, 1.2 }).endObject()));
            }
        mapper.copyTo = copyTo;
    public void testDerivedValueFetching_DocValues_WKT() throws IOException {
        Mapper fieldMapper = mapper.mappers().getMapper("field");
        assertThat(doc.rootDoc().getField("point"), notNullValue());
            validateDerivedSource(mapper, directory);
                Map<String, Object> latLon2 = points.get(1);
            XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
    public void testDerivedValueFetching_DocValues_GeoHash() throws IOException {
        assertParseMinimalWarnings();
        ParsedDocument doc = mapper.parse(
            nullValue()
                ParsedDocument doc = mapperService.documentMapper()
        }
     */
            assertEquals(gpfm.nullValue, point);
            assertEquals(2, points.size());
    public void testPossibleToDeriveSource_WhenDocValuesAndStoredDisabled() throws IOException {
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {
                iw.addDocument(doc.rootDoc());
        assertThat(doc.getField("field.geohash").binaryValue().utf8ToString(), equalTo("s093jd0k72s1"));
        assertThat(doc.rootDoc().getField("field"), nullValue());
                iw.addDocument(doc.rootDoc());
    public void testGeoJsonIgnoreZValue() throws Exception {
        assertThat(doc.getFields("field.latlon"), arrayWithSize(1));
            builder.endObject();
    public void testDerivedValueFetching_DocValues_String() throws IOException {
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "POINT (2 3)")));
 * specific language governing permissions and limitations
            }
        assertThat(
    }
                mapping.startObject("mapping").field("type", "geo_point").endObject();
        }
        DocumentMapper mapper = createDocumentMapper(
        assertThat(doc.rootDoc().getField("field"), nullValue());
    public final void testExistsQueryDocValuesDisabled() throws IOException {
        }));
        }
                ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.field(FIELD_NAME, stringEncode(1.3, 1.2))));
        }));
    public void testNullValueWithIgnoreMalformed() throws Exception {
        assertExistsQuery(mapperService);
        assertThat(doc.getField("field"), hasToString(both(containsString("field:2.999")).and(containsString("1.999"))));
        );
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "geo_point").field("store", true)));
        assertThat(
            }
            }
        assertThat(doc.rootDoc().getField("field"), notNullValue());
            MapperService mapperService = getMapperService(false, true); // doc values
        assertThat(doc.getFields("field"), arrayWithSize(1));
        Mapper fieldMapper = mapper.mappers().getMapper("field");
    }
        assertThat(
                iw.addDocument(doc.rootDoc());
    }
    public void testLonLatArrayStored() throws Exception {
import java.io.IOException;
        return new GeoPointFieldMapper.Builder("geo");
            nullValue()
            }
        assertThat(doc.rootDoc().getFields(FieldNamesFieldMapper.NAME).length, equalTo(0));
        assertThat(nullValue, equalTo(new GeoPoint(89, 1)));
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {
                    .parse(source(b -> b.field(FIELD_NAME, new String[] { stringEncode(1.3, 1.2), stringEncode(1.2, 1.1) })));
        );
                iw.addDocument(doc.rootDoc());
                    );
        return createMapperService(
            } else {
        ParsedDocument doc = mapper.parse(
    }
    }
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {
    }
                assertEquals(1.2, (Double) latLon1.get("lon"), 0.001);
import org.opensearch.common.xcontent.XContentFactory;
        );
        }
            GeoPointFieldMapper mapper = getMapper(mapperService, FieldMapper.CopyTo.empty());
     * when setting the "null_value" field. See PR https://github.com/elastic/elasticsearch/pull/49645
            mapper.parse(source(b -> b.startObject("field").field("lat", 1.3).field("lon", "-").endObject())).rootDoc().getField("field"),
    }
        }
        try (Directory directory = newDirectory()) {
            nullValue()
                ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.field(FIELD_NAME, stringEncode(1.3, 1.2))));
            MapperService mapperService = getMapperService(false, true); // doc values
    protected void minimalMapping(XContentBuilder b) throws IOException {
                ParsedDocument doc = mapperService.documentMapper()
    protected void writeFieldValue(XContentBuilder builder) throws IOException {
import static org.hamcrest.Matchers.not;
    public void testDerivedValueFetching_StoredField_Coordinates() throws IOException {
    public void testDerivedValueFetching_DocValues_Point() throws IOException {
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
            b.field("doc_values", false);
                ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.field(FIELD_NAME, "1.2,1.3")));
    public void testPossibleToDeriveSource_WhenCopyToPresent() throws IOException {
            b.startArray().value(1.5).value(1.4).endArray();
import org.opensearch.common.geo.GeoPoint;
            Map<String, Object> jsonObject = XContentHelper.convertToMap(BytesReference.bytes(builder), false, builder.contentType()).v2();
            )
                ParsedDocument doc = mapperService.documentMapper()
    public void testGeoJsonIgnoreInvalidForm() throws Exception {
        try (Directory directory = newDirectory()) {
                assertEquals(1.1, (Double) latLon1.get("lat"), 0.001);
        }
        }));
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1.2,1.3,10.0")));
    }
 * this file be licensed under the Apache-2.0 license or a
            MapperService mapperService = getMapperService(false, true); // doc values
        ParseContext.Document doc = mapper.parse(source(b -> b.field("field", "POINT (2 3)"))).rootDoc();
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {
    }
            mapping.endObject().endObject();
        });
                b.startObject("geohash").field("type", "keyword").field("doc_values", false).endObject();  // test geohash as keyword
            b.startArray("field");
            GeoPointFieldMapper gpfm = (GeoPointFieldMapper) m;
        assertThat(defaultValue, not(equalTo(doc.rootDoc().getBinaryValue("field"))));
    }
        Mapper fieldMapper = mapper.mappers().getMapper("field");
                mapping.field("match", "point*");
            fieldMapping(
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {
        try (DirectoryReader reader = DirectoryReader.open(directory)) {
            {
            MapperService mapperService = getMapperService(true, false); // doc values
                    .parse(source(b -> b.startObject(FIELD_NAME).field("lat", 1.2).field("lon", 1.3).endObject()));
    protected Set<String> unsupportedProperties() {
 * license agreements. See the NOTICE file distributed with
    }
    }
            validateDerivedSource(mapper, directory);
        // doc values are enabled by default, but in this test we disable them; we should only have 2 points
        assertThat(doc.rootDoc().getField("field"), notNullValue());
        try (Directory directory = newDirectory()) {
        );
        try (Directory directory = newDirectory()) {
    public void testDerivedValueFetching_StoredField_String() throws IOException {
    public void testDerivedValueFetching_StoredField_Multi() throws IOException {
        );
import static org.hamcrest.Matchers.nullValue;
            }
                iw.addDocument(doc.rootDoc());
    }
        assertThat(doc.rootDoc().getFields("field").length, CoreMatchers.equalTo(4));
                Map<String, Object> latLon1 = points.get(0);
    }
        mapping.endArray().endObject().endObject();
            GeoPointFieldMapper mapper = getMapper(mapperService, FieldMapper.CopyTo.empty());
        try (Directory directory = newDirectory()) {
                                .field("coordinates", new double[] { 1.3, 1.2 })
    }
        assertThat(doc.rootDoc().getFields(FieldNamesFieldMapper.NAME).length, equalTo(0));
                        )
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "geo_point").field("ignore_z_value", true)));
        ParsedDocument doc = mapper.parse(source(b -> b.startObject("field").field("lat", 1.2).field("lon", 1.3).endObject()));
        assertThat(fieldMapper, instanceOf(GeoPointFieldMapper.class));
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "geo_point").field("ignore_z_value", false)));
        checker.registerUpdateCheck(b -> b.field("ignore_malformed", true), m -> {
    public void testLatLonValuesStored() throws Exception {
            builder.endObject();
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "geo_point").field("ignore_malformed", "true")));
    public void testDerivedValueFetching_StoredField_Point() throws IOException {
                ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.field(FIELD_NAME, new double[] { 1.3, 1.2 })));
    }
import java.util.Map;
    }
            mapper.parse(source(b -> b.startObject("field").field("lat", "-").field("lon", 1.3).endObject())).rootDoc().getField("field"),
            GeoPointFieldMapper mapper = getMapper(mapperService, FieldMapper.CopyTo.empty());
            GeoPointFieldMapper mapper = getMapper(mapperService, FieldMapper.CopyTo.empty());
                        source(
        try (DirectoryReader reader = DirectoryReader.open(directory)) {
                    .array("coordinates", new double[] { 1.3, 1.4 })
    private GeoPointFieldMapper getMapper(MapperService mapperService, FieldMapper.CopyTo copyTo) throws IOException {
            validateDerivedSourceMultiField(mapper, directory, false);
            )
        // explicit false accept_z_value test
import static org.hamcrest.Matchers.notNullValue;
    }
        mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "geo_point").field("null_value", "1,2")));
            fieldMapping(b -> b.field("type", "geo_point").field("doc_values", false).field("store", true))
            MapperService mapperService = getMapperService(true, false); // doc values
            validateDerivedSource(mapper, directory);
                    .array("coordinates", new double[] { 1.1, 1.2 })
                ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.field(FIELD_NAME, "1.2,1.3")));
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234.333")));
package org.opensearch.index.mapper;
        try (Directory directory = newDirectory()) {
                assertEquals(1.2, (Double) latLon2.get("lon"), 0.001);
        ParsedDocument doc = mapper.parse(
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
                assertEquals(1.2, (Double) latLon1.get("lat"), 0.001);
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {
import org.apache.lucene.store.Directory;
    public void testNullValue() throws Exception {
    protected void registerParameters(ParameterChecker checker) throws IOException {
                    .parse(source(b -> b.startObject(FIELD_NAME).field("lat", 1.2).field("lon", 1.3).endObject()));
                iw.addDocument(doc.rootDoc());
                assertEquals(1.2, (Double) latLon2.get("lat"), 0.001);
            }
            GeoPointFieldMapper mapper = getMapper(mapperService, FieldMapper.CopyTo.empty());
        assertThat(nullValue, equalTo(new GeoPoint(1, 2)));
        );
            GeoPointFieldMapper gpfm = (GeoPointFieldMapper) m;
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "geo_point").field("ignore_z_value", true)));
        });
    }
        ParsedDocument doc = mapper.parse(source(b -> {
            fieldMapping(b -> b.field("type", "geo_point").field("store", true).field("doc_values", false))
    public void testLatLonInOneValue() throws Exception {
        doc = mapper.parse(source(b -> b.field("field", "3, 4")));
            fieldMapping(b -> b.field("type", "geo_point").field("store", isStored).field("doc_values", hasDocValues))
    public void testDerivedValueFetching_StoredField_WKT() throws IOException {
            }
import org.hamcrest.CoreMatchers;
        try (Directory directory = newDirectory()) {
                iw.addDocument(doc.rootDoc());
        assertThat(doc.rootDoc().getFields("field"), notNullValue());
                assertEquals(1.1, (Double) latLon2.get("lat"), 0.001);
import org.opensearch.common.xcontent.XContentHelper;
            validateDerivedSource(mapper, directory);
    }
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", stringEncode(1.3, 1.2))));
                                .field("type", "Point")
            GeoPointFieldMapper mapper = getMapper(mapperService, FieldMapper.CopyTo.empty());
        mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "geo_point").field("doc_values", false)));
            }
            MapperService mapperService = getMapperService(true, false); // doc values
            b.endArray();
        }
    public void testGeoJsonSingleValue() throws Exception {
            mapping.startObject().startObject("point");
        assertThat(doc.getFields("field.geohash"), arrayWithSize(1));
        );
        GeoPointFieldMapper mapper = getMapper(getMapperService(false, false), FieldMapper.CopyTo.empty());
 *
                    .parse(source(b -> b.field(FIELD_NAME, new String[] { stringEncode(1.3, 1.2), stringEncode(1.2, 1.1) })));
import static org.opensearch.geometry.utils.Geohash.stringEncode;
        assertThat(
}
    private MapperService getMapperService(boolean hasDocValues, boolean isStored) throws IOException {
            b.startObject().field("lat", 1.4).field("lon", 1.5).endObject();
                            b -> b.startObject(FIELD_NAME)
            Map<String, Object> jsonObject = XContentHelper.convertToMap(BytesReference.bytes(builder), false, builder.contentType()).v2();
     */
            MapperService mapperService = getMapperService(false, true); // doc values
                iw.addDocument(doc.rootDoc());
        assertThat(doc.rootDoc().getField("field"), notNullValue());
                ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.field(FIELD_NAME, "POINT (1.3 1.2)")));
                Map<String, Object> latLon1 = points.get(0);
            GeoPointFieldMapper gpfm = (GeoPointFieldMapper) m;
        ignoreZValue = ((GeoPointFieldMapper) fieldMapper).ignoreZValue().value();
 */
            b.startObject().field("lat", 1.2).field("lon", 1.3).endObject();
    public void testWKT() throws Exception {
            List<Map<String, Object>> points = (List<Map<String, Object>>) jsonObject.get(FIELD_NAME);
        }
        );
        );
 * ownership. Elasticsearch licenses this file to you under
        ParsedDocument doc = mapper.parse(source(b -> b.nullField("field")));
    }
                iw.addDocument(doc.rootDoc());
    private void validateDerivedSourceMultiField(GeoPointFieldMapper mapper, Directory directory, boolean isStored) throws IOException {
    }
            assertFalse(gpfm.ignoreZValue.value());
        try (Directory directory = newDirectory()) {
        assertThrows(UnsupportedOperationException.class, mapper::canDeriveSource);
            }
    @Override
                Map<String, Object> latLon2 = points.get(1);
        assertThat(defaultValue, equalTo(doc.rootDoc().getBinaryValue("field")));
        MapperParsingException e = expectThrows(
        );
        assertThat(doc.rootDoc().getField("field"), notNullValue());
            b.endArray();
        return Set.of("analyzer", "similarity", "doc_values");
    @Override
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {
import org.apache.lucene.index.DirectoryReader;
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
     * Test the fix for a bug that would read the value of field "ignore_z_value" for "ignore_malformed"
        try (Directory directory = newDirectory()) {
    public void testLatLonStringWithZValue() throws Exception {
        doc = mapper.parse(source(b -> b.nullField("field")));
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {
            GeoPointFieldMapper mapper = getMapper(mapperService, FieldMapper.CopyTo.empty());
            validateDerivedSource(mapper, directory);
 */
        b.field("type", "geo_point");
                    .endObject()
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
 * You may obtain a copy of the License at
    }
        assertThat(e.getRootCause().getMessage(), containsString("unsupported symbol [.] in geohash [1234.333]"));
    public void testIgnoreZValue() throws IOException {
        assertThat(doc.rootDoc().getField("field"), notNullValue());
        }
        assertThat(e.getCause().getMessage(), containsString("but [ignore_z_value] parameter is [false]"));
                    .field("type", "Point")
        return mapper;
        assertThat(doc.rootDoc().getFields("field").length, equalTo(4));
            mapper.parse(source(b -> b.startObject("field").field("lat", "NaN").field("lon", 1.2).endObject())).rootDoc().getField("field"),
            )
            MapperService mapperService = getMapperService(false, true); // doc values
        assertThat(doc.rootDoc().getField("field"), notNullValue());
            }
                assertEquals(1.3, (Double) latLon2.get("lon"), 0.001);
            GeoPointFieldMapper mapper = getMapper(mapperService, FieldMapper.CopyTo.empty());
    public void testArrayLatLonValues() throws Exception {
        assertThat(
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "geo_point").field("store", true)));
                                .endObject()
                assertEquals(1.3, (Double) latLon1.get("lon"), 0.001);
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1.2,1.3")));
        XContentBuilder mapping = XContentFactory.jsonBuilder().startObject().startObject("_doc").startArray("dynamic_templates");
                ParsedDocument doc = mapperService.documentMapper()
        BytesRef defaultValue = doc.rootDoc().getBinaryValue("field");
            mapper.deriveSource(builder, reader.leaves().get(0).reader(), 0);
        }
/*
            Map<String, Object> latLon = (Map<String, Object>) jsonObject.get(FIELD_NAME);
        GeoPoint point = GeoUtils.parseFromString("41.12,-71.34");
        fieldMapper = mapper.mappers().getMapper("field");
        assertThat(doc.rootDoc().getField("field"), notNullValue());
                    .startObject()
    }
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> {
import static org.hamcrest.Matchers.both;
                    .startObject()
        // TODO this should not be updateable!
    }
        DocumentMapper mapper = createDocumentMapper(
                        )
    protected GeoPointFieldMapper.Builder newBuilder() {
    public void testLonLatArrayArrayStored() throws Exception {
        MapperService mapperService = createMapperService(fieldMapping(b -> {
        // doc values are enabled by default, but in this test we disable them; we should only have 2 points
            source(b -> b.startObject("field").field("type", "Point").array("coordinates", new double[] { 1.1, 1.2, 1.3 }).endObject())
    /**
                b.startObject("latlon").field("type", "text").endObject();  // test geohash as text
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
    public void testDerivedValueFetching_DocValues_Coordinates() throws IOException {
    public void testDerivedValueFetching_DocValues_Multi() throws IOException {
        DocumentMapper mapper = createDocumentMapper(mapping);
import static org.hamcrest.Matchers.hasToString;
    }
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {
        assertThat(doc.rootDoc().getFields("field"), arrayWithSize(4));
        assertThat(doc.rootDoc().getFields("field").length, equalTo(3));
                ParsedDocument doc = mapperService.documentMapper()
    private static final String FIELD_NAME = "field";
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "geo_point").field("store", true)));
                    .field("ignore_malformed", true)
                ParsedDocument doc = mapperService.documentMapper()
        assertThat(fieldMapper, instanceOf(GeoPointFieldMapper.class));
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {
        try (Directory directory = newDirectory()) {
            GeoPointFieldMapper mapper = getMapper(mapperService, FieldMapper.CopyTo.empty());
 * software distributed under the License is distributed on an
    }
 * compatible open source license.
import org.opensearch.core.xcontent.XContentBuilder;
    }
            }
            nullValue()
        assertThat(e.getMessage(), containsString("failed to parse field [field] of type [geo_point]"));
            MapperParsingException.class,
    public void testLatLonInOneValueStored() throws Exception {
public class GeoPointFieldMapperTests extends FieldMapperTestCase2<GeoPointFieldMapper.Builder> {
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {
    public void testInvalidGeohashNotIgnored() throws Exception {
                                .endObject()
    }
        DocumentMapper mapper = createDocumentMapper(
        }
        boolean ignoreZValue = ((GeoPointFieldMapper) fieldMapper).ignoreZValue().value();
                iw.addDocument(doc.rootDoc());
        try (Directory directory = newDirectory()) {
    public void testDerivedValueFetching_StoredField_GeoHash() throws IOException {
            b.endObject();
        doc = mapper.parse(source(b -> b.nullField("field")));
                ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.field(FIELD_NAME, new double[] { 1.3, 1.2 })));
    }
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
        // Shouldn't matter if we specify the value explicitly or use null value
    }
                iw.addDocument(doc.rootDoc());
        assertThat(doc.rootDoc().getField("field"), notNullValue());
 * The OpenSearch Contributors require contributions made to
 * under the License.
                iw.addDocument(doc.rootDoc());
        assertThat(ignoreZValue, equalTo(true));
        GeoPointFieldMapper mapper = getMapper(getMapperService(true, false), copyTo);
        assertThat(fieldMapper, instanceOf(GeoPointFieldMapper.class));
            GeoPointFieldMapper mapper = getMapper(mapperService, FieldMapper.CopyTo.empty());
import org.apache.lucene.index.IndexWriter;
        DocumentMapper mapper = createDocumentMapper(
    public void testLonLatArray() throws Exception {
                    .endObject()
    }
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1.2,1.3")));
    public void testLatLonStringWithZValueException() throws Exception {
            validateDerivedSource(mapper, directory);
import org.opensearch.common.geo.GeoUtils;
            MapperService mapperService = getMapperService(true, false); // doc values
 * Unless required by applicable law or agreed to in writing,
    public void testLatLonInOneValueArray() throws Exception {
        });
        ParsedDocument doc = mapper.parse(source(b -> {
    }
            {
    }
import java.util.List;
        assertThat(mapper.parse(source(b -> b.field("field", "-,1.3"))).rootDoc().getField("field"), nullValue());
    }
        ParsedDocument doc = mapper.parse(source(b -> b.startArray("field").value(1.3).value(1.2).endArray()));
        assertThat(mapper.parse(source(b -> b.field("field", "1234.333"))).rootDoc().getField("field"), nullValue());
            source(
        assertThat(e.getCause().getMessage(), containsString("but [ignore_z_value] parameter is [false]"));
        GeoPointFieldMapper mapper = (GeoPointFieldMapper) mapperService.documentMapper().mappers().getMapper(FIELD_NAME);
        fieldMapper = mapper.mappers().getMapper("field");
 * KIND, either express or implied.  See the License for the
        );
 *
import java.util.Set;
import static org.hamcrest.Matchers.instanceOf;
     * Test that accept_z_value parameter correctly parses
        // Set ignore_z_value = false and ignore_malformed = true and test that a malformed point for null_value is normalized.
                iw.addDocument(doc.rootDoc());
    }
        assertThat(doc.rootDoc().getField("field"), notNullValue());
                    .parse(
                b -> b.startArray("field")
                ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.field(FIELD_NAME, "POINT (1.3 1.2)")));
        assertThat(fieldMapper, instanceOf(GeoPointFieldMapper.class));
    }
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {
    }
    }
                                .field("type", "Point")
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "geo_point").field("ignore_malformed", "true")));
    /**
        assertThat(fieldMapper, instanceOf(GeoPointFieldMapper.class));
import org.apache.lucene.index.IndexWriterConfig;
    }
        fieldMapper = mapper.mappers().getMapper("field");
        AbstractPointGeometryFieldMapper.ParsedPoint nullValue = ((GeoPointFieldMapper) fieldMapper).nullValue;
        {
            MapperService mapperService = getMapperService(true, false); // doc values
    }
            nullValue()
            MapperService mapperService = getMapperService(true, false); // doc values
        assertThat(doc.rootDoc().getField("field"), nullValue());
        Exception e = expectThrows(MapperParsingException.class, () -> mapper.parse(source(b -> b.field("field", "1.2,1.3,10.0"))));
            b.startArray("field");
            GeoPointFieldMapper mapper = getMapper(mapperService, FieldMapper.CopyTo.empty());
        assertThat(doc.rootDoc().getField("field"), notNullValue());
    private void validateDerivedSource(GeoPointFieldMapper mapper, Directory directory) throws IOException {
        assertThat(doc.getField("field.latlon").stringValue(), equalTo("s093jd0k72s1"));
    public void testInvalidGeopointValuesIgnored() throws Exception {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            fieldMapping(b -> b.field("type", "geo_point").field("doc_values", false).field("store", true))
            if (isStored) {
        assertThat(doc.rootDoc().getField("field"), nullValue());
    }
 * SPDX-License-Identifier: Apache-2.0
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "geo_point")));
            MapperService mapperService = getMapperService(false, true); // doc values
            validateDerivedSource(mapper, directory);
            validateDerivedSource(mapper, directory);
        try (Directory directory = newDirectory()) {
            mapper.deriveSource(builder, reader.leaves().get(0).reader(), 0);
            MapperParsingException.class,
                    .field("null_value", "91,181")
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "geo_point").field("ignore_malformed", "true")));
            nullValue()
            () -> mapper.parse(source(b -> b.field("field", "1234.333")))
