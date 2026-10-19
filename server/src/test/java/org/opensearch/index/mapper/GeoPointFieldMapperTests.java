            b.endArray();
            assertEquals(1.3, (Double) latLon.get("lon"), 0.001);  
                    .field("ignore_z_value", false)
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {
        assertThat(doc.getFields("field.latlon"), arrayWithSize(1));  
        mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "geo_point").field("ignore_z_value", false)));
    private void validateDerivedSource(GeoPointFieldMapper mapper, Directory directory) throws IOException {  
                    .parse(source(b -> b.startObject(FIELD_NAME).field("lat", 1.2).field("lon", 1.3).endObject()));
            validateDerivedSource(mapper, directory);  
        ParsedDocument doc = mapper.parse(
 * SPDX-License-Identifier: Apache-2.0
    public void testDerivedValueFetching_DocValues_Coordinates() throws IOException {  
                Map<String, Object> latLon1 = points.get(0);
                Map<String, Object> latLon2 = points.get(1);  
/*
        }));  
    @Override  
                iw.addDocument(doc.rootDoc());  
            MapperService mapperService = getMapperService(true, false); // doc values
                b -> b.startArray("field")
            validateDerivedSource(mapper, directory);
import static org.hamcrest.Matchers.notNullValue;
            b.startArray("field");
            GeoPointFieldMapper mapper = getMapper(mapperService, FieldMapper.CopyTo.empty());
                b -> b.field("type", "geo_point")  
        assertThat(fieldMapper, instanceOf(GeoPointFieldMapper.class));
    }
    }
                ParsedDocument doc = mapperService.documentMapper()
        try (Directory directory = newDirectory()) {
    }  
        assertThat(doc.getFields("field"), arrayWithSize(1));
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {
import static org.hamcrest.Matchers.hasToString;
        assertThat(mapper.parse(source(b -> b.field("field", "-,1.3"))).rootDoc().getField("field"), nullValue());  
        ignoreZValue = ((GeoPointFieldMapper) fieldMapper).ignoreZValue().value();
            MapperService mapperService = getMapperService(false, true); // doc values  
            GeoPointFieldMapper mapper = getMapper(mapperService, FieldMapper.CopyTo.empty());  
import org.opensearch.common.xcontent.XContentFactory;
        assertThat(fieldMapper, instanceOf(GeoPointFieldMapper.class));
import static org.hamcrest.Matchers.arrayWithSize;
            if (isStored) {
        Exception e = expectThrows(  
    }  
    }
        assertThat(doc.rootDoc().getFields(FieldNamesFieldMapper.NAME).length, equalTo(0));
    public void testGeoHashValue() throws Exception {
        DocumentMapper mapper = createDocumentMapper(
                    .endObject()  
                Map<String, Object> latLon2 = points.get(1);
                iw.addDocument(doc.rootDoc());
     * Test the fix for a bug that would read the value of field "ignore_z_value" for "ignore_malformed"
    }
            b.startObject("fields");  
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {  
 * license agreements. See the NOTICE file distributed with
    public void testDerivedValueFetching_DocValues_Array() throws IOException {  
    }  
        ParsedDocument doc = mapper.parse(  
            GeoPointFieldMapper mapper = getMapper(mapperService, FieldMapper.CopyTo.empty());
            mapper.parse(source(b -> b.startObject("field").field("lat", 1.2).nullField("lon").endObject())).rootDoc().getField("field"),
        ParsedDocument doc = mapper.parse(
        }  
        assertThat(
            }  
            Map<String, Object> jsonObject = XContentHelper.convertToMap(BytesReference.bytes(builder), false, builder.contentType()).v2();  
                iw.addDocument(doc.rootDoc());
                                .endObject()
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> {
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {
        });
    public void testPossibleToDeriveSource_WhenCopyToPresent() throws IOException {
                            b -> b.startObject(FIELD_NAME)
    }  
     * Test that accept_z_value parameter correctly parses
        return Set.of("analyzer", "similarity", "doc_values");
        try (DirectoryReader reader = DirectoryReader.open(directory)) {
    }
 * Unless required by applicable law or agreed to in writing,
import static org.hamcrest.Matchers.containsString;  
 * Licensed to Elasticsearch under one or more contributor  
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "POINT (2 3)")));
        assertThrows(UnsupportedOperationException.class, mapper::canDeriveSource);
 * specific language governing permissions and limitations
        }
    }  
    @Override
 * GitHub history for details.
                mapping.field("match", "point*");
        assertThat(doc.rootDoc().getField("field"), nullValue());
    public void testLatLonStringWithZValue() throws Exception {  
            source(b -> b.startObject("field").field("type", "Point").array("coordinates", new double[] { 1.1, 1.2, 1.3 }).endObject())
    }  
    }
            MapperService mapperService = getMapperService(true, false); // doc values
                source(b -> b.startObject("field").field("type", "Point").array("coordinates", new double[] { 1.1, 1.2, 1.3 }).endObject())  
import org.hamcrest.CoreMatchers;
        try (Directory directory = newDirectory()) {  
    }  
            validateDerivedSource(mapper, directory);  
                            b -> b.startObject(FIELD_NAME)
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "geo_point").field("ignore_malformed", "true")));
import java.util.List;
        }));
                                .field("coordinates", new double[] { 1.3, 1.2 })
        FieldMapper.CopyTo copyTo = new FieldMapper.CopyTo.Builder().add("copy_to_field").build();
    public void testDerivedValueFetching_DocValues_WKT() throws IOException {  
        DocumentMapper mapper = createDocumentMapper(mapping);
import static org.opensearch.geometry.utils.Geohash.stringEncode;  
            GeoPointFieldMapper mapper = getMapper(mapperService, FieldMapper.CopyTo.empty());
            )
                        source(  
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
        assertThat(
        doc = mapper.parse(source(b -> b.nullField("field")));
    }  
            }  
import org.apache.lucene.index.IndexWriterConfig;
        checker.registerUpdateCheck(b -> b.field("ignore_z_value", false), m -> {
        try (DirectoryReader reader = DirectoryReader.open(directory)) {
    }
            GeoPointFieldMapper gpfm = (GeoPointFieldMapper) m;
        {
/*
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "geo_point").field("ignore_z_value", false)));
import static org.hamcrest.Matchers.equalTo;
                iw.addDocument(doc.rootDoc());  
import org.apache.lucene.store.Directory;  
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "geo_point").field("ignore_malformed", "true")));
    }
    public void testNullValueWithIgnoreMalformed() throws Exception {
    public void testDerivedValueFetching_StoredField_Array() throws IOException {  
            nullValue()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "geo_point").field("doc_values", false)));
            minimalMapping(b);
}  
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1.2,1.3")));
    public void testLatLonStringWithZValueException() throws Exception {  
            }
    }  
        );
        assertThat(e.getCause().getMessage(), containsString("but [ignore_z_value] parameter is [false]"));  
        );
    public void testDerivedValueFetching_DocValues_Point() throws IOException {
                        source(
    public void testDerivedValueFetching_StoredField_WKT() throws IOException {  
 * software distributed under the License is distributed on an
import org.apache.lucene.index.DirectoryReader;  
                    .field("null_value", "91,181")  
            validateDerivedSource(mapper, directory);  
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {
            MapperService mapperService = getMapperService(true, false); // doc values  
    }  
        try (Directory directory = newDirectory()) {  
        }  
import java.util.Set;
                    );
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "geo_point").field("ignore_malformed", "true")));  
                iw.addDocument(doc.rootDoc());
        assertThat(fieldMapper, instanceOf(GeoPointFieldMapper.class));  
            validateDerivedSource(mapper, directory);
    }
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {
        DocumentMapper mapper = createDocumentMapper(
        MapperParsingException e = expectThrows(
        assertThat(doc.rootDoc().getField("field"), nullValue());  
    protected void registerParameters(ParameterChecker checker) throws IOException {
            Map<String, Object> latLon = (Map<String, Object>) jsonObject.get(FIELD_NAME);
        assertThat(fieldMapper, instanceOf(GeoPointFieldMapper.class));
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));  
            mapper.deriveSource(builder, reader.leaves().get(0).reader(), 0);
            }
        assertThat(doc.rootDoc().getFields("field"), notNullValue());
    }
        ParsedDocument doc = mapper.parse(source(b -> {  
            validateDerivedSource(mapper, directory);
    public void testLatLonInOneValueArray() throws Exception {  
            }
        }  
            }  
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "geo_point").field("ignore_z_value", true)));
    public void testGeoJsonIgnoreInvalidForm() throws Exception {  
        assertThat(doc.getField("field"), hasToString(both(containsString("field:2.999")).and(containsString("1.999"))));  
        mapper.copyTo = copyTo;  
        try (Directory directory = newDirectory()) {
    protected GeoPointFieldMapper.Builder newBuilder() {
        assertThat(doc.rootDoc().getFields("field"), arrayWithSize(4));
 * not use this file except in compliance with the License.
        }));  
            }  
            b.startObject().field("lat", 1.4).field("lon", 1.5).endObject();  
        try (Directory directory = newDirectory()) {
import org.opensearch.common.geo.GeoUtils;  
    }
            MapperService mapperService = getMapperService(true, false); // doc values  
                assertEquals(1.2, (Double) latLon2.get("lat"), 0.001);
                    .parse(source(b -> b.startObject(FIELD_NAME).field("lat", 1.2).field("lon", 1.3).endObject()));
            nullValue()
    }
            assertEquals(1.2, (Double) latLon.get("lat"), 0.001);
        assertThat(mapper.parse(source(b -> b.field("field", "1234.333"))).rootDoc().getField("field"), nullValue());  
    public void testDerivedValueFetching_StoredField_Multi() throws IOException {
                ParsedDocument doc = mapperService.documentMapper()  
    public void testDerivedValueFetching_StoredField_Point() throws IOException {
        assertThat(fieldMapper, instanceOf(GeoPointFieldMapper.class));  
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "geo_point").field("ignore_z_value", true)));  
    }  
 * Modifications Copyright OpenSearch Contributors. See  
                                .endObject()
        mapping.endArray().endObject().endObject();  
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {  
        builder.value(stringEncode(1.3, 1.2));
            }
            b.endObject();
            assertEquals(gpfm.nullValue, point);  
            b.startObject().field("lat", 1.2).field("lon", 1.3).endObject();
            XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
        DocumentMapper mapper = createDocumentMapper(
        }));
            validateDerivedSource(mapper, directory);
    public void testDerivedValueFetching_StoredField_GeoHash() throws IOException {
            nullValue()  
public class GeoPointFieldMapperTests extends FieldMapperTestCase2<GeoPointFieldMapper.Builder> {
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "geo_point")));
    }
    }
        Exception e = expectThrows(MapperParsingException.class, () -> mapper.parse(source(b -> b.field("field", "1.2,1.3,10.0"))));
        assertThat(fieldMapper, instanceOf(GeoPointFieldMapper.class));
        assertThat(nullValue, equalTo(new GeoPoint(89, 1)));
    public void testDerivedValueFetching_StoredField_Coordinates() throws IOException {
                assertEquals(1.3, (Double) latLon2.get("lon"), 0.001);
    /**
        return createMapperService(
        assertThat(
    }
    }
 * The OpenSearch Contributors require contributions made to  
    }
    }
        assertThat(doc.rootDoc().getField("field"), nullValue());  
        try (Directory directory = newDirectory()) {
        return mapper;
        assertThrows(UnsupportedOperationException.class, mapper::canDeriveSource);
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));  
    public void testIgnoreZValue() throws IOException {  
                    .endObject()
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {
    }  
            fieldMapping(b -> b.field("type", "geo_point").field("doc_values", false).field("store", true))
 * this work for additional information regarding copyright
        );  
     */
                assertEquals(1.3, (Double) latLon1.get("lon"), 0.001);
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {
    public void testDerivedValueFetching_DocValues_String() throws IOException {  
        GeoPoint point = GeoUtils.parseFromString("41.12,-71.34");
                mapping.startObject("mapping").field("type", "geo_point").endObject();
    public void testLonLatArray() throws Exception {
        }
    public void testWKT() throws Exception {
        assertThat(doc.rootDoc().getField("field"), notNullValue());
    }
            () -> mapper.parse(
        doc = mapper.parse(source(b -> b.nullField("field")));
    }
        }  
            MapperService mapperService = getMapperService(false, true); // doc values
                ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.field(FIELD_NAME, "POINT (1.3 1.2)")));
        assertThat(doc.rootDoc().getField("field"), notNullValue());
        }
        }
    public final void testExistsQueryDocValuesDisabled() throws IOException {
        assertParseMinimalWarnings();
        ParsedDocument doc = mapper.parse(source(b -> b.startObject("field").field("lat", 1.2).field("lon", 1.3).endObject()));
        );  
import static org.hamcrest.Matchers.both;
        try (Directory directory = newDirectory()) {
        assertThat(doc.getField("field.geohash").binaryValue().utf8ToString(), equalTo("s093jd0k72s1"));
        );
        assertThat(e.getMessage(), containsString("failed to parse field [field] of type [geo_point]"));
        );
        MapperService mapperService = createMapperService(fieldMapping(b -> {  
import static org.hamcrest.Matchers.not;
    }
                    .field("ignore_malformed", true)
import static org.hamcrest.Matchers.nullValue;  
    }  
        fieldMapper = mapper.mappers().getMapper("field");
                ParsedDocument doc = mapperService.documentMapper()  
    }
            b.field("type", "geo_point").field("doc_values", false);
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
        try (Directory directory = newDirectory()) {
                assertEquals(1.2, (Double) latLon2.get("lon"), 0.001);
        checker.registerUpdateCheck(b -> b.field("ignore_malformed", true), m -> {  
                    .parse(  
            MapperParsingException.class,
package org.opensearch.index.mapper;
            fieldMapping(
            b.field("doc_values", false);
                    .array("coordinates", new double[] { 1.3, 1.4 })
import org.opensearch.core.common.bytes.BytesReference;  
        doc = mapper.parse(source(b -> b.field("field", "3, 4")));  
                ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.field(FIELD_NAME, stringEncode(1.3, 1.2))));  
            GeoPointFieldMapper mapper = getMapper(mapperService, FieldMapper.CopyTo.empty());  
            GeoPointFieldMapper gpfm = (GeoPointFieldMapper) m;
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "geo_point").field("store", true)));
        assertThat(doc.rootDoc().getFields("field"), notNullValue());
            MapperService mapperService = getMapperService(false, true); // doc values
 * this file be licensed under the Apache-2.0 license or a
            mapping.endObject().endObject();
                                .field("type", "Point")
        assertThat(doc.rootDoc().getField("point"), notNullValue());
            Map<String, Object> jsonObject = XContentHelper.convertToMap(BytesReference.bytes(builder), false, builder.contentType()).v2();
        try (Directory directory = newDirectory()) {  
        }
    private GeoPointFieldMapper getMapper(MapperService mapperService, FieldMapper.CopyTo copyTo) throws IOException {
                    .parse(source(b -> b.field(FIELD_NAME, new String[] { stringEncode(1.3, 1.2), stringEncode(1.2, 1.1) })));
     * when setting the "null_value" field. See PR https://github.com/elastic/elasticsearch/pull/49645  
            b.startArray("field");  
    private void validateDerivedSourceMultiField(GeoPointFieldMapper mapper, Directory directory, boolean isStored) throws IOException {
import org.opensearch.core.xcontent.XContentBuilder;
            MapperService mapperService = getMapperService(false, true); // doc values
    }
        assertThat(doc.rootDoc().getFields("field").length, equalTo(3));
    protected Set<String> unsupportedProperties() {
            MapperService mapperService = getMapperService(false, true); // doc values
        assertThat(doc.rootDoc().getField("field"), notNullValue());
        checker.registerUpdateCheck(b -> b.field("null_value", "41.12,-71.34"), m -> {
        assertThat(doc.rootDoc().getField("field"), notNullValue());  
            }
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {
        GeoPointFieldMapper mapper = (GeoPointFieldMapper) mapperService.documentMapper().mappers().getMapper(FIELD_NAME);
        Mapper fieldMapper = mapper.mappers().getMapper("field");  
                iw.addDocument(doc.rootDoc());  
        }
    }
 * KIND, either express or implied.  See the License for the
            validateDerivedSource(mapper, directory);
    public void testInvalidGeohashIgnored() throws Exception {
        // doc values are enabled by default, but in this test we disable them; we should only have 2 points  
        }
            {  
    }
    }
    public void testPossibleToDeriveSource_WhenDocValuesAndStoredDisabled() throws IOException {
    }
            )
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));  
            mapping.startObject().startObject("point");
        assertThat(doc.getFields("field.geohash"), arrayWithSize(1));
                ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.field(FIELD_NAME, "POINT (1.3 1.2)")));
                iw.addDocument(doc.rootDoc());  
        ParsedDocument doc = mapper.parse(source(b -> b.startArray("field").value(1.3).value(1.2).endArray()));
        );
        });
    public void testLonLatArrayStored() throws Exception {
        // geo_point [91, 181] should have been normalized to [89, 1]
 *  
        assertThat(  
        assertThat(doc.rootDoc().getField("field"), notNullValue());  
 *
                ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.field(FIELD_NAME, "1.2,1.3")));
import org.opensearch.common.geo.GeoPoint;
                    .startObject()
 * compatible open source license.
            nullValue()
    public void testNullValue() throws Exception {
        }  
import java.util.Map;  
                ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.field(FIELD_NAME, "1.2,1.3")));
            mapper.deriveSource(builder, reader.leaves().get(0).reader(), 0);  
            XContentBuilder builder = XContentFactory.jsonBuilder().startObject();  
                    .field("type", "Point")  
        assertThat(doc.rootDoc().getField("field"), notNullValue());
        assertThat(doc.rootDoc().getField("field"), notNullValue());
        );
    }
        assertThat(doc.rootDoc().getFields("field").length, equalTo(4));  
        GeoPointFieldMapper mapper = getMapper(getMapperService(true, false), copyTo);  
     */
        assertThat(  
        ParsedDocument doc = mapper.parse(source(b -> b.startObject("field").array("coordinates", new double[] { 1.1, 1.2 }).endObject()));
    public void testLatLonInOneValue() throws Exception {  
            assertTrue(jsonObject.containsKey(FIELD_NAME));
                iw.addDocument(doc.rootDoc());  
                iw.addDocument(doc.rootDoc());
 * the Apache License, Version 2.0 (the "License"); you may
        AbstractPointGeometryFieldMapper.ParsedPoint nullValue = ((GeoPointFieldMapper) fieldMapper).nullValue;
            List<Map<String, Object>> points = (List<Map<String, Object>>) jsonObject.get(FIELD_NAME);
    public void testDerivedValueFetching_DocValues_GeoHash() throws IOException {
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "geo_point").field("ignore_z_value", false)));
            mapper.parse(source(b -> b.startObject("field").field("lat", 1.2).field("lon", "NaN").endObject())).rootDoc().getField("field"),
    }  
import org.apache.lucene.util.BytesRef;
 */  
    protected void writeFieldValue(XContentBuilder builder) throws IOException {
    }
    public void testGeoJsonIgnoreZValue() throws Exception {
        // explicit false accept_z_value test
            }
    }
    }
        fieldMapper = mapper.mappers().getMapper("field");  
            }
        );
        mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "geo_point").field("null_value", "1,2")));  
    public void testLatLonInOneValueStored() throws Exception {  
        );
            mapper.parse(source(b -> b.startObject("field").field("lat", "NaN").field("lon", 1.2).endObject())).rootDoc().getField("field"),  
        );  
            nullValue()
        assertThat(nullValue, equalTo(new GeoPoint(1, 2)));
        assertThat(doc.rootDoc().getFields(FieldNamesFieldMapper.NAME).length, equalTo(0));
        assertThat(doc.rootDoc().getField("field"), notNullValue());  
        }  
 *
                ParsedDocument doc = mapperService.documentMapper()
    public void testGeoJsonSingleValue() throws Exception {
                ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.field(FIELD_NAME, stringEncode(1.3, 1.2))));  
    @Override
            b.startArray().value(1.5).value(1.4).endArray();
            MapperParsingException.class,
        b.field("type", "geo_point");
    public void testGeoJsonZValueException() throws Exception {
    public void testMultiField() throws Exception {  
        assertThat(doc.rootDoc().getField("field"), notNullValue());  
            }
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234.333")));
            b.startArray().value(1.3).value(1.2).endArray();
                    .endArray()
                    );  
        ParsedDocument doc = mapper.parse(source(b -> b.nullField("field")));  
    public void testArrayLatLonValues() throws Exception {
            fieldMapping(b -> b.field("type", "geo_point").field("doc_values", false).field("store", true))
        try (Directory directory = newDirectory()) {
        assertThat(doc.rootDoc().getFields("field"), notNullValue());
            validateDerivedSourceMultiField(mapper, directory, false);
        assertThat(doc.rootDoc().getFields("field").length, CoreMatchers.equalTo(4));  
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", stringEncode(1.3, 1.2))));
                ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.field(FIELD_NAME, new double[] { 1.3, 1.2 })));
        });  
        // doc values are enabled by default, but in this test we disable them; we should only have 2 points
        );
            GeoPointFieldMapper mapper = getMapper(mapperService, FieldMapper.CopyTo.empty());  
                    .field("type", "Point")
        try (Directory directory = newDirectory()) {
        assertThat(defaultValue, equalTo(doc.rootDoc().getBinaryValue("field")));
        doc = mapper.parse(source(b -> b.field("field", "1, 2")));  
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "geo_point").field("ignore_z_value", true)));
        assertThat(doc.getField("field.latlon").stringValue(), equalTo("s093jd0k72s1"));
        }
import org.opensearch.common.xcontent.XContentHelper;
            assertEquals(2, points.size());  
                assertEquals(1.1, (Double) latLon1.get("lat"), 0.001);
            }
                iw.addDocument(doc.rootDoc());  
            )
    }
            source(  
            assertTrue(gpfm.ignoreMalformed.value());
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(e.getRootCause().getMessage(), containsString("unsupported symbol [.] in geohash [1234.333]"));  
                assertEquals(1.2, (Double) latLon1.get("lon"), 0.001);
    public void testInvalidGeohashNotIgnored() throws Exception {
                    .parse(
        assertThat(mapper.parse(source(b -> b.field("field", "NaN,1.3"))).rootDoc().getField("field"), nullValue());
                    .parse(source(b -> b.field(FIELD_NAME, new String[] { stringEncode(1.3, 1.2), stringEncode(1.2, 1.1) })));
 */
                    .startObject()  
        ParsedDocument doc = mapper.parse(source(b -> b.startArray("point").value(1.3).value(1.2).endArray()));  
            } else {
        );  
            GeoPointFieldMapper mapper = getMapper(mapperService, FieldMapper.CopyTo.empty());
        assertThat(mapper.parse(source(b -> b.field("field", "1.3,-"))).rootDoc().getField("field"), nullValue());
            assertTrue(jsonObject.containsKey(FIELD_NAME));  
        );
import static org.hamcrest.Matchers.instanceOf;  
            validateDerivedSourceMultiField(mapper, directory, true);
            fieldMapping(b -> b.field("type", "geo_point").field("store", isStored).field("doc_values", hasDocValues))  
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "geo_point").field("store", true)));
                iw.addDocument(doc.rootDoc());  
        assertThat(defaultValue, not(equalTo(doc.rootDoc().getBinaryValue("field"))));
                        )
        ParsedDocument doc = mapper.parse(source(b -> {
            MapperService mapperService = getMapperService(false, true); // doc values
    }
        ParsedDocument doc = mapper.parse(source(b -> b.startArray("field").value("1.2,1.3").value("1.4,1.5").endArray()));
        // Set ignore_z_value = false and ignore_malformed = true and test that a malformed point for null_value is normalized.  
        );  
        assertThat(
    protected void minimalMapping(XContentBuilder b) throws IOException {  
                        )  
            mapper.parse(source(b -> b.startObject("field").field("lat", 1.3).field("lon", "-").endObject())).rootDoc().getField("field"),  
        AbstractPointGeometryFieldMapper.ParsedPoint nullValue = ((GeoPointFieldMapper) fieldMapper).nullValue;  
                iw.addDocument(doc.rootDoc());  
            b.endArray();  
                assertEquals(1.1, (Double) latLon2.get("lat"), 0.001);  
    public void testInvalidGeopointValuesIgnored() throws Exception {  
    public void testGeoJsonArray() throws Exception {  
            validateDerivedSource(mapper, directory);
        try (Directory directory = newDirectory()) {
        ParsedDocument doc = mapper.parse(source(b -> b.startArray("field").value(1.3).value(1.2).endArray()));  
            }
            mapper.parse(source(b -> b.startObject("field").nullField("lat").field("lon", 1.2).endObject())).rootDoc().getField("field"),
    public void testLonLatArrayArrayStored() throws Exception {
            MapperService mapperService = getMapperService(true, false); // doc values
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "geo_point").field("store", true)));  
        assertThat(ignoreZValue, equalTo(false));  
            GeoPointFieldMapper mapper = getMapper(mapperService, FieldMapper.CopyTo.empty());
            GeoPointFieldMapper mapper = getMapper(mapperService, FieldMapper.CopyTo.empty());  
        assertThat(mapper.parse(source(b -> b.field("field", "1.3,NaN"))).rootDoc().getField("field"), nullValue());
    @Override  
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1.2,1.3")));
        ParseContext.Document doc = mapper.parse(source(b -> b.field("field", "POINT (2 3)"))).rootDoc();
 */
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));  
            () -> mapper.parse(source(b -> b.field("field", "1234.333")))  
    public void testDerivedValueFetching_DocValues_Multi() throws IOException {
        try (Directory directory = newDirectory()) {
    public void testDerivedValueFetching_StoredField_String() throws IOException {  
 * under the License.  
        BytesRef defaultValue = doc.rootDoc().getBinaryValue("field");  
            GeoPointFieldMapper mapper = getMapper(mapperService, FieldMapper.CopyTo.empty());  
        Mapper fieldMapper = mapper.mappers().getMapper("field");
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {
                                .field("coordinates", new double[] { 1.3, 1.2 })  
/*  
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {
            GeoPointFieldMapper mapper = getMapper(mapperService, FieldMapper.CopyTo.empty());  
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {  
    }  
        }  
            MapperService mapperService = getMapperService(true, false); // doc values  
    }
            }  
        assertExistsQuery(mapperService);
        assertThat(doc.rootDoc().getField("field"), notNullValue());
        return new GeoPointFieldMapper.Builder("geo");
            validateDerivedSource(mapper, directory);
 * You may obtain a copy of the License at  
    private static final String FIELD_NAME = "field";
                                .field("type", "Point")  
            builder.endObject();
            source(b -> b.startObject("field").field("type", "Point").array("coordinates", new double[] { 1.1, 1.2 }).endObject())
                b.startObject("latlon").field("type", "text").endObject();  // test geohash as text  
            GeoPointFieldMapper mapper = getMapper(mapperService, FieldMapper.CopyTo.empty());  
    public void testLonLatArrayDynamic() throws Exception {
            }
            GeoPointFieldMapper gpfm = (GeoPointFieldMapper) m;
            mapper.parse(source(b -> b.startObject("field").field("lat", "-").field("lon", 1.3).endObject())).rootDoc().getField("field"),
    }
    public void testLatLonValuesStored() throws Exception {
        XContentBuilder mapping = XContentFactory.jsonBuilder().startObject().startObject("_doc").startArray("dynamic_templates");  
        Mapper fieldMapper = mapper.mappers().getMapper("field");  
import java.io.IOException;
            validateDerivedSource(mapper, directory);
            MapperService mapperService = getMapperService(false, true); // doc values
        // Shouldn't matter if we specify the value explicitly or use null value
        GeoPointFieldMapper mapper = getMapper(getMapperService(false, false), FieldMapper.CopyTo.empty());  
                ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.field(FIELD_NAME, new double[] { 1.3, 1.2 })));
    }
        // TODO this should not be updateable!  
                    .array("coordinates", new double[] { 1.1, 1.2 })
                ParsedDocument doc = mapperService.documentMapper()
                iw.addDocument(doc.rootDoc());
    private MapperService getMapperService(boolean hasDocValues, boolean isStored) throws IOException {
            MapperService mapperService = getMapperService(true, false); // doc values
            assertFalse(gpfm.ignoreZValue.value());  
        DocumentMapper mapper = createDocumentMapper(  
                ParsedDocument doc = mapperService.documentMapper()
                assertEquals(1.2, (Double) latLon1.get("lat"), 0.001);  
            builder.endObject();
            nullValue()  
            GeoPointFieldMapper mapper = getMapper(mapperService, FieldMapper.CopyTo.empty());
                Map<String, Object> latLon1 = points.get(0);  
                b.startObject("geohash").field("type", "keyword").field("doc_values", false).endObject();  // test geohash as keyword
            fieldMapping(b -> b.field("type", "geo_point").field("store", true).field("doc_values", false))  
        assertThat(doc.rootDoc().getField("field"), notNullValue());
            validateDerivedSource(mapper, directory);
        assertThat(e.getCause().getMessage(), containsString("but [ignore_z_value] parameter is [false]"));  
        assertThat(doc.rootDoc().getField("field"), nullValue());
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1.2,1.3,10.0")));
        assertThat(ignoreZValue, equalTo(true));
        );
            {
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {
                iw.addDocument(doc.rootDoc());
        assertThat(doc.rootDoc().getFields("field"), arrayWithSize(4));
        boolean ignoreZValue = ((GeoPointFieldMapper) fieldMapper).ignoreZValue().value();
    /**  
        try (Directory directory = newDirectory()) {
        fieldMapper = mapper.mappers().getMapper("field");
            }
        }  
            GeoPointFieldMapper mapper = getMapper(mapperService, FieldMapper.CopyTo.empty());
import org.apache.lucene.index.IndexWriter;
