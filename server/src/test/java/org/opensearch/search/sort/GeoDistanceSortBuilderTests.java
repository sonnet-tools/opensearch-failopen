            + "  \"unit\" : \"m\",\n"
import java.util.Arrays;
        assertThat(sortField.getComparatorSource(), instanceOf(XFieldComparatorSource.class));
                // the following are alternative ways to setNestedSort for nested sorting
    @Override
                throw new IllegalStateException("one of three geo initialisation strategies must be used");  
        geoDistanceSortBuilder.order(SortOrder.ASC).unit(DistanceUnit.INCH);
                    + "-39.03717711567879, 44.74099852144718]",
        return result;  
import org.hamcrest.CoreMatchers;
        // however this might be disabled by fancy options  
        assertEquals(builder.fieldName(), sortField.getField());
import org.opensearch.core.xcontent.XContentBuilder;
        QueryShardContext shardContextMock = createMockShardContext();  
            + "    \"ezu09wxw6v4c\", \"kc7s3515p6k6\", \"jgeuvjwrmfzn\", \"kcpcfj7ruyf8\" ],\n"
    }  
import org.opensearch.core.xcontent.XContentParser;  
        builder = new GeoDistanceSortBuilder("random_field_name", new GeoPoint(3.5, 2.1));  
        sortBuilder.endArray();  
        }
            parser.nextToken();
        comparatorSource = (XFieldComparatorSource) sortField.getComparatorSource();  
        parse(sortBuilder);  
            @Override
 * software distributed under the License is distributed on an
        if (randomBoolean()) {
        sortBuilder.endObject();
            + "    \"nested\" : {\n"  
        sortBuilder.field("unit", "km");
            () -> sortBuilder.setNestedSort(new NestedSortBuilder("otherPath")).setNestedPath("nestedPath")
        String json = "{\n"  
        SortFieldAndFormat sort = builder.build(context);  
    public void testNestedSortRewrites() throws IOException {  
        parse(sortBuilder);
                break;  
            + "  } ],\n"
            .setNestedFilter(QueryBuilders.matchAllQuery());
        builder.order(SortOrder.DESC);  
            expectedWarnings.add(nestedFilterDeprecationWarning);
        if (randomBoolean()) {  
    @Override
            IllegalArgumentException.class,
        sortBuilder.field("unit", "km");
    /**
        sortBuilder.startArray("location");
        sortBuilder.value("s3y0zh7w1z0g").value("s6wjr4et3f8v");  
    }  
                return new MatchNoneQueryBuilder();
    public void testBuildSortFieldOrder() throws IOException {
        assertEquals(MultiValueMode.AVG, comparatorSource.sortMode());
            for (int i = 0; i < count; i++) {
        sortBuilder.field("unit", "km");
        assertEquals(MultiValueMode.MEDIAN, comparatorSource.sortMode());
        assertEquals(MultiValueMode.MAX, comparatorSource.sortMode());
                while (Arrays.deepEquals(original.points(), result.points())) {
        sortBuilder.startArray("location");
        sortBuilder.endObject();
 * Licensed to Elasticsearch under one or more contributor  
            + "    },\n"
        );
    public void testSortModeSumIsRejectedInSetter() {
    private GeoDistanceSortBuilder parse(XContentBuilder sortBuilder) throws Exception {  
        iae = expectThrows(
            OpenSearchParseException ex = expectThrows(OpenSearchParseException.class, () -> sortBuilder.build(shardContextMock));
        sortBuilder.startArray("location");  
    }
        sortBuilder.endObject();
        sortBuilder.endArray();
import org.opensearch.OpenSearchParseException;  
        parse(sortBuilder);
        );
            public QueryBuilder doRewrite(QueryRewriteContext queryShardContext) throws IOException {  
        assertEquals(SortField.class, sort.field.getClass()); // can't use LatLon optimized sorting with DESC sorting
    }
            + "}";
        sortField = sortBuilder.build(shardContextMock).field;  
import java.util.List;
import org.opensearch.search.DocValueFormat;
            builder.sortMode(SortMode.SUM);
    public static GeoDistanceSortBuilder randomGeoDistanceSortBuilder() {
        return result;
            itemParser.nextToken();
public class GeoDistanceSortBuilderTests extends AbstractSortTestCase<GeoDistanceSortBuilder> {
 *
        assertEquals(LatLonDocValuesField.newDistanceSort("fieldName", 0.0, 180.0), sortField);  
        geoDistanceSortBuilder = new GeoDistanceSortBuilder("fieldName", 1.0, 1.0);
            GeoDistanceSortBuilder sortBuilder = new GeoDistanceSortBuilder("fieldName", 0.0, -360.0);  
            public QueryBuilder doRewrite(QueryRewriteContext queryShardContext) throws IOException {
 */  
            id = randomIntBetween(0, GeoDistance.values().length - 1);  
                }
        }
            case 5:
                break;  
            + "        \"ids\" : {\n"
        Nested nested = comparatorSource.nested();
            assertWarnings(expectedWarnings.toArray(new String[0]));
        sortBuilder.endObject();
        sortBuilder.setNestedPath("path").setNestedFilter(rangeQuery);
        if (expectedWarnings.isEmpty() == false) {  
    protected void sortFieldAssertions(GeoDistanceSortBuilder builder, SortField sortField, DocValueFormat format) throws IOException {  
        sortBuilder.field("unit", "km");  
        comparatorSource = (XFieldComparatorSource) sortField.getComparatorSource();
import java.io.IOException;  
        assertThat(nested.getInnerQuery(), CoreMatchers.instanceOf(ApproximateScoreQuery.class));
        sortBuilder.endArray();
                result.sortMode(
            + "    \"validation_method\" : \"STRICT\"\n"
        assertThat(sortField.getComparatorSource(), instanceOf(XFieldComparatorSource.class));
        sortBuilder.startObject();
        }
        sort = builder.build(context);
    protected void assertWarnings(GeoDistanceSortBuilder testItem) {
        XContentBuilder sortBuilder = jsonBuilder();
        sortField = geoDistanceSortBuilder.build(shardContextMock).field;
        sortBuilder.field("mode", "max");
        sortBuilder.endArray();  
                        result.setNestedFilter(randomValueOtherThan(original.getNestedFilter(), () -> randomNestedFilter()));  
        assertEquals(MultiValueMode.MAX, comparatorSource.sortMode());  
            sortBuilder.validation(GeoValidationMethod.STRICT);
        sortBuilder.field("order", "desc");  
 *
        comparatorSource = (XFieldComparatorSource) sortField.getComparatorSource();  
        if (randomBoolean()) {  
        try (XContentParser itemParser = createParser(JsonXContent.jsonXContent, json)) {
        builder.setNestedPath("some_nested_path");
                result = new GeoDistanceSortBuilder(fieldName, pt.getLat(), pt.getLon());  
            case 4:
     */
        sortBuilder.startArray("location");  
        GeoDistanceSortBuilder geoDistanceSortBuilder = new GeoDistanceSortBuilder("fieldName", 1.0, 1.0);
     */
            itemParser.nextToken();
import org.opensearch.index.mapper.MappedFieldType;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.query.QueryRewriteContext;
        sortBuilder.endArray();
        GeoDistanceSortBuilder result = null;  
    }  
        sortBuilder.field("mode", "max");
                nestedSort.setFilter(new MatchAllQueryBuilder());
                result = new GeoDistanceSortBuilder(fieldName, geohashes);
        geoDistanceSortBuilder.order(SortOrder.DESC);
    /**
 * under the License.  
        approxQuery = (ApproximateScoreQuery) nested.getInnerQuery();  
        // use MultiValueMode.Min if no Mode and order is ASC
import java.util.HashSet;  
        if (randomBoolean()) {  
import org.opensearch.index.query.QueryShardContext;  
        return new GeoPointFieldMapper.GeoPointFieldType(name);  
        while (result == null || Arrays.deepEquals(original, result)) {
            case 2:
        geoDistanceSortBuilder.sortMode(SortMode.MAX);
                result.points(points(original.points()));
        geoDistanceSortBuilder.sortMode(SortMode.MEDIAN);  
        assertEquals(SortField.class, sort.field.getClass()); // can't use LatLon optimized sorting with nested fields  
        geoDistanceSortBuilder.order(SortOrder.DESC);
        }
            case 1:
        );  
        assertThat(sortField.getComparatorSource(), instanceOf(XFieldComparatorSource.class));
                break;  
    }
                result.ignoreUnmapped(result.ignoreUnmapped() == false);
        geoDistanceSortBuilder = new GeoDistanceSortBuilder("fieldName", 1.0, 1.0);  
        sortBuilder.startArray("location");
import org.apache.lucene.search.SortField;
        assertThat(sortField, instanceOf(SortField.class));
                if (randomBoolean()) {
/*  
            assertEquals("sort_mode [sum] isn't supported for sorting by geo distance", e.getMessage());
        sortBuilder = jsonBuilder();
}
                        result.setNestedPath(randomValueOtherThan(original.getNestedPath(), () -> randomAlphaOfLengthBetween(1, 10)));
    }  
 *  
        assertThat(nested.getInnerQuery(), CoreMatchers.instanceOf(ApproximateScoreQuery.class));  
        String fieldName = randomAlphaOfLengthBetween(1, 10);
        SortField sortField = geoDistanceSortBuilder.build(shardContextMock).field;  
        parse(sortBuilder);
                if (original.getNestedPath() == null && original.getNestedFilter() == null) {
        comparatorSource = (XFieldComparatorSource) sortField.getComparatorSource();
        assertEquals(LatLonDocValuesField.newDistanceSort("random_field_name", 3.5, 2.1).getClass(), sort.field.getClass());
        int parameter = randomIntBetween(0, 8);
                    result.setNestedFilter(new MatchAllQueryBuilder());  
        assertThat(approxQuery.getOriginalQuery(), CoreMatchers.instanceOf(MatchAllDocsQuery.class));
        sortBuilder = new GeoDistanceSortBuilder("fieldName", 1.0, 1.0).setNestedFilter(QueryBuilders.termQuery("fieldName", "value"));  
        IllegalArgumentException iae = expectThrows(  
                    + "31.537466906011105, -74.63590376079082, "
        sortField = geoDistanceSortBuilder.build(shardContextMock).field;
        sortBuilder.setNestedSort(new NestedSortBuilder("path").setFilter(rangeQuery));
 * KIND, either express or implied.  See the License for the
            default:
            + "          \"boost\" : 5.711116\n"
        XContentBuilder sortBuilder = jsonBuilder();  
            + "          \"values\" : [ ],\n"  
        sortBuilder.endObject();
        sortBuilder.value("1,2").value("3,4");
        {
                    result.setNestedPath(randomAlphaOfLengthBetween(1, 10));  
import org.opensearch.index.query.RangeQueryBuilder;
    }  
        String json = "{\n"  
import org.opensearch.index.mapper.GeoPointFieldMapper;  
     */
        QueryShardContext shardContextMock = createMockShardContext();  
        return result;
 *    http://www.apache.org/licenses/LICENSE-2.0
        try (XContentParser itemParser = createParser(JsonXContent.jsonXContent, json)) {  
        sortBuilder.startArray().value(1.2).value(3).endArray().startArray().value(5).value(6).endArray();
        sortBuilder.startObject();  
 */
        sortBuilder.field("location", new GeoPoint(1, 2));  
        GeoDistanceSortBuilder sortBuilder = new GeoDistanceSortBuilder("fieldName", 0.0, 0.0);
            case 6:  
    }
        GeoDistanceSortBuilder sortBuilder = new GeoDistanceSortBuilder("fieldName", 0.0, 0.0);
        sortBuilder.startObject();
        int id = randomIntBetween(0, 2);
    @Override
        sortBuilder.field("mode", "max");
        assertEquals(SortField.class, sort.field.getClass()); // descending means the max value should be considered rather than min
        sortBuilder = jsonBuilder();
        comparatorSource = (XFieldComparatorSource) sortField.getComparatorSource();
        assertThat(sortField.getComparatorSource(), instanceOf(XFieldComparatorSource.class));
                    + "-69.44606635719538, 84.25200328230858, "
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        if (randomBoolean()) {  
            IllegalArgumentException.class,
        assertNotNull(nested);
        };
    }  
            case 3:
 * this work for additional information regarding copyright
 */  
        sortBuilder.startObject();  
        assertNotNull(nested);
        builder = new GeoDistanceSortBuilder("random_field_name", new GeoPoint(3.5, 2.1), new GeoPoint(3.0, 4));
            sortBuilder.validation(GeoValidationMethod.STRICT);
        String nestedFilterDeprecationWarning = "[nested_filter] has been deprecated in favour of the [nested] parameter";
        RangeQueryBuilder rangeQuery = new RangeQueryBuilder("fieldName") {
        comparatorSource = (XFieldComparatorSource) sortField.getComparatorSource();  
            + "      }\n"  
        sortBuilder.startArray("location");
            GeoDistanceSortBuilder result = GeoDistanceSortBuilder.fromXContent(itemParser, json);
        GeoDistanceSortBuilder result = new GeoDistanceSortBuilder(original);
import org.opensearch.index.query.QueryBuilder;  
        }
    @Override
        if (testItem.getNestedFilter() != null && !assertedWarnings.contains(nestedFilterDeprecationWarning)) {  
        assertThat(sortField.getComparatorSource(), instanceOf(XFieldComparatorSource.class));
     */  
        assertNotSame(rangeQuery, rewritten.getNestedFilter());  
     */
        assertThat(approxQuery.getOriginalQuery(), CoreMatchers.instanceOf(MatchAllDocsQuery.class));
    public void testBuildCoerce() throws IOException {
        sortField = sortBuilder.build(shardContextMock).field;  
            OpenSearchParseException ex = expectThrows(OpenSearchParseException.class, () -> sortBuilder.build(shardContextMock));
            }
        builder = new GeoDistanceSortBuilder("random_field_name", new GeoPoint(3.5, 2.1));
    @Override  
    public void testNestedRewrites() throws IOException {
        assertEquals(false, geoDistanceSortBuilder.build(shardContextMock).field.getReverse());
        }  
        GeoDistanceSortBuilder rewritten = (GeoDistanceSortBuilder) sortBuilder.rewrite(createMockShardContext());  
        sortBuilder.field("mode", "max");  
            + "  }";  
    }
                NestedSortBuilder nestedSort = new NestedSortBuilder(randomAlphaOfLengthBetween(3, 10));  
        sortBuilder = jsonBuilder();
                }
        sortBuilder.field("location", "1,2");  
        }
                } else {
        sortBuilder = jsonBuilder();
        sortBuilder.field("mode", "max");
                    result.point(pt.getLat(), pt.getLon());
                result.setNestedSort(nestedSort);
                    + "-37.20467280596495, 38.71751043945551, "  
        sortBuilder.field("unit", "km");
                        randomValueOtherThan(original.getNestedSort(), () -> NestedSortBuilderTests.createRandomNestedSort(3))  
        builder.order(SortOrder.DESC);
 * GitHub history for details.
                    );
    }
            assertEquals("illegal latitude value [-180.0] for [GeoDistanceSort] for field [fieldName].", ex.getMessage());  
                break;  
            + "    \"VDcvDuFjE\" : [ \"7umzzv8eychg\", \"dmdgmt5z13uw\", "
        };  
        builder = new GeoDistanceSortBuilder("random_field_name", new GeoPoint(3.5, 2.1));
        // (LatLonSortField)
        assertEquals(true, geoDistanceSortBuilder.build(shardContextMock).field.getReverse());
        GeoDistanceSortBuilder builder = new GeoDistanceSortBuilder("testname", -1, -1);  
    public void testBuildNested() throws IOException {
        sortBuilder = new GeoDistanceSortBuilder("fieldName", 1.0, 1.0).setNestedPath("path")
            result = new GeoPoint[count];
                break;
    }
        sortBuilder.field("order", "desc");  
            result.geoDistance(geoDistance(result.geoDistance()));
        sortBuilder.endObject();
        sortBuilder.field("unit", "km");
                result.unit(randomValueOtherThan(result.unit(), () -> randomFrom(DistanceUnit.values())));
                break;  
        try {  
 * this file be licensed under the Apache-2.0 license or a
        sortBuilder.startArray().value(1.2).value(3).endArray().startArray().value(5).value(6).endArray();  
        }
                break;
        );  
                    GeoPoint pt = RandomGeoGenerator.randomPoint(random());  
        geoDistanceSortBuilder.order(SortOrder.ASC);
            result.sortMode(randomValueOtherThan(SortMode.SUM, () -> randomFrom(SortMode.values())));
        if (randomBoolean()) {  
    protected GeoDistanceSortBuilder mutate(GeoDistanceSortBuilder original) throws IOException {  
        parse(sortBuilder);
import org.opensearch.search.MultiValueMode;  
        sortBuilder.startObject();
            + "    \"lon\" : -51.94128329747579\n"  
            );
import org.opensearch.search.approximate.ApproximateScoreQuery;
        sortBuilder.startObject();
        SortField sortField = sortBuilder.build(shardContextMock).field;
                if (randomBoolean()) {
                return new MatchNoneQueryBuilder();
        geoDistanceSortBuilder.sortMode(SortMode.AVG);  
        return randomGeoDistanceSortBuilder();
    public void testNestedSortBothThrows() throws IOException {
        sortBuilder.field("order", "desc");
 * license agreements. See the NOTICE file distributed with
        GeoDistanceSortBuilder sortBuilder = new GeoDistanceSortBuilder("fieldName", -180.0, -360.0);
        sortBuilder.endObject();  
/*  
     * Test we can either set nested sort via path/filter or via nested sort builder, not both
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
    public void testMultiValueMode() throws IOException {
import java.util.Set;
        GeoDistanceSortBuilder rewritten = (GeoDistanceSortBuilder) sortBuilder.rewrite(createMockShardContext());
                GeoPoint pt = RandomGeoGenerator.randomPoint(random());
    }
            case 8:
                    } else {
        switch (parameter) {  
                // don't fully randomize here, GeoDistanceSort is picky about the filters that are allowed
            result.order(randomFrom(SortOrder.values()));
        parse(sortBuilder);
        assertThat(sortField.getComparatorSource(), instanceOf(XFieldComparatorSource.class));
        List<String> expectedWarnings = new ArrayList<>();  
        nested = comparatorSource.nested();  
        parse(sortBuilder);
        sortBuilder.field("order", "desc");
        assertEquals(MultiValueMode.MIN, comparatorSource.sortMode());
        QueryShardContext shardContextMock = createMockShardContext();  
        // need to use distance unit other than Meters to not get back a LatLonPointSortField  
        QueryShardContext shardContextMock = createMockShardContext();
        } catch (IllegalArgumentException e) {  
    }
     * Test the nested sort gets rewritten
        sortBuilder.value(new GeoPoint(1.2, 3)).value(new GeoPoint(1.2, 3));
        sortField = geoDistanceSortBuilder.build(shardContextMock).field;
package org.opensearch.search.sort;
    }
 * The OpenSearch Contributors require contributions made to  
        sortBuilder.field("order", "desc");
    protected GeoDistanceSortBuilder createTestItem() {  
        sortBuilder.endObject();
                    }
        RangeQueryBuilder rangeQuery = new RangeQueryBuilder("fieldName") {
    private static GeoDistance geoDistance(GeoDistance original) {  
            if (randomBoolean()) {
        builder = new GeoDistanceSortBuilder("random_field_name", new GeoPoint(3.5, 2.1));
        // also use MultiValueMode.Max if no Mode set but order is DESC
import org.opensearch.test.geo.RandomGeoGenerator;  
        }
            assertEquals(
import org.opensearch.common.unit.DistanceUnit;  
            new NestedSortBuilder("path").setFilter(QueryBuilders.matchAllQuery())
            () -> sortBuilder.setNestedSort(new NestedSortBuilder("otherPath")).setNestedFilter(QueryBuilders.matchAllQuery())  
        assertThat(sortField.getComparatorSource(), instanceOf(XFieldComparatorSource.class));  
                    geohashes[i] = RandomGeoGenerator.randomPoint(random()).geohash();
            case 0:
        XFieldComparatorSource comparatorSource = (XFieldComparatorSource) sortField.getComparatorSource();
        sortBuilder.endObject();  
            + "    \"lat\" : -6.046997540714173,\n"
    public void testGeoDistanceSortDeprecatedSortModeException() throws Exception {
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource;
        while (id == -1 || (original != null && original.ordinal() == id)) {
    }  
            int count = randomIntBetween(1, 10);  
     * Test that if validation is strict, invalid points throw an error
            assertedWarnings.addAll(expectedWarnings);
        sortBuilder.field("unit", "km");  
    /**
import org.opensearch.index.mapper.NestedPathFieldMapper;
        sortBuilder.field("sort_mode", "max");  
    private static GeoPoint[] points(GeoPoint[] original) {  
            // all good
        }
        nested = comparatorSource.nested();  
                IllegalArgumentException.class,
                    + "43.71844606474042, -5.548660643398762, "
        sortBuilder.value(new GeoPoint(1, 2)).value("s3y0zh7w1z0g").startArray().value(1).value(2).endArray().value("1,2");
        sortField = geoDistanceSortBuilder.build(shardContextMock).field;
        geoDistanceSortBuilder = new GeoDistanceSortBuilder("fieldName", 1.0, 1.0);
        sortBuilder = jsonBuilder();
        sortBuilder = jsonBuilder();  
            + "    \"mode\" : \"MAX\",\n"
import static org.hamcrest.Matchers.instanceOf;
        sortBuilder.value(1.2).value(3);
        sortBuilder.field("order", "desc");
            + "  \"testname\" : [ {\n"
        sortBuilder.field("unit", "km");
        sortBuilder.startObject();
            result.unit(randomValueOtherThan(result.unit(), () -> randomFrom(DistanceUnit.values())));
        return GeoDistance.values()[id];
                }
    }
        ApproximateScoreQuery approxQuery = (ApproximateScoreQuery) nested.getInnerQuery();
        XFieldComparatorSource comparatorSource = (XFieldComparatorSource) sortField.getComparatorSource();  
    protected MappedFieldType provideMappedFieldType(String name) {
     */
            + "    \"unit\" : \"m\",\n"  
        sortBuilder.field("location", "s3y0zh7w1z0g");  
        // make sure the below tests test something...  
            result.validation(randomValueOtherThan(result.validation(), () -> randomFrom(GeoValidationMethod.values())));
        QueryShardContext context = createMockShardContext();  
 * You may obtain a copy of the License at  
        String nestedPathDeprecationWarning = "[nested_path] has been deprecated in favour of the [nested] parameter";
        {
            IllegalArgumentException.class,  
        assertEquals(false, geoDistanceSortBuilder.build(shardContextMock).field.getReverse());
        builder.unit(DistanceUnit.KILOMETERS);  
        assertEquals(new TermQuery(new Term(NestedPathFieldMapper.NAME, "path")), nested.getInnerQuery());
        sort = builder.build(context);
        }  
        assertFalse(SortField.class.equals(LatLonDocValuesField.newDistanceSort("random_field_name", 3.5, 2.1).getClass()));
        assertEquals(SortField.class, sort.field.getClass()); // km rather than m -> plain SortField with a custom comparator
        parse(sortBuilder);
        sortBuilder.startObject();  
        sortBuilder.field("mode", "max");  
            expectedWarnings.add(nestedPathDeprecationWarning);
     * Test that the sort builder mode gets transferred correctly to the SortField  
            + "    \"distance_type\" : \"arc\",\n"
            return GeoDistanceSortBuilder.fromXContent(parser, null);  
            + "        }\n"
                result = new GeoDistanceSortBuilder(fieldName, points(new GeoPoint[0]));  
    /**
     * Test that the sort builder nested object gets created in the SortField
    public void testBuildInvalidPoints() throws IOException {  
     */
            + "  \"mode\" : \"SUM\"\n"
        sortBuilder = new GeoDistanceSortBuilder("fieldName", 1.0, 1.0).setNestedPath("path");
    public void testGeoDistanceSortParserManyPointsNoException() throws Exception {
        sortBuilder.field("mode", "max");  
    protected GeoDistanceSortBuilder fromXContent(XContentParser parser, String fieldName) throws IOException {
        sort = builder.build(context);
        assertEquals(-180.0, sortBuilder.points()[0].getLat(), 0.0);  
            case 7:
    public void testSortModeSumIsRejectedInJSON() throws IOException {
    @Override
        sortBuilder = jsonBuilder();
            + "  \"distance_type\" : \"arc\",\n"  
        }
        GeoDistanceSortBuilder builder = new GeoDistanceSortBuilder("", new GeoPoint(3.5, 2.1));
    }  
        comparatorSource = (XFieldComparatorSource) sortField.getComparatorSource();
            } else {  
        sortBuilder = jsonBuilder();
                result.geoDistance(geoDistance(original.geoDistance()));
            fail("sort mode sum should not be supported");
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource.Nested;
            case 1:
        sortBuilder.field("mode", "max");  
import org.apache.lucene.document.LatLonDocValuesField;
        assertEquals(-360.0, sortBuilder.points()[0].getLon(), 0.0);
    public void testCommonCaseIsOptimized() throws IOException {
                int count = randomIntBetween(1, 10);
/*
        GeoDistanceSortBuilder geoDistanceSortBuilder = new GeoDistanceSortBuilder("fieldName", 1.0, 1.0);
        sort = builder.build(context);
import org.opensearch.common.geo.GeoDistance;
                    result.setNestedSort(
        assertEquals("Setting both nested_path/nested_filter and nested not allowed", iae.getMessage());
        sortBuilder.field("unit", "km");
 * not use this file except in compliance with the License.
                result.validation(randomValueOtherThan(result.validation(), () -> randomFrom(GeoValidationMethod.values())));
                }
    private Set<String> assertedWarnings = new HashSet<>();  
     * Test that the sort builder order gets transferred correctly to the SortField  
import org.opensearch.common.geo.GeoPoint;
 * Modifications Copyright OpenSearch Contributors. See
        sortBuilder.field("order", "desc");
        if (randomBoolean()) {  
        GeoPoint[] result = null;
import java.util.ArrayList;
import org.apache.lucene.search.MatchAllDocsQuery;  
                break;  
        parse(sortBuilder);  
        sortField = sortBuilder.build(shardContextMock).field;
 * the Apache License, Version 2.0 (the "License"); you may
        }
                result[i] = RandomGeoGenerator.randomPoint(random());  
    public void testGeoDistanceSortCanBeParsedFromGeoHash() throws IOException {
                }  
        assertThat(sortField.getComparatorSource(), instanceOf(XFieldComparatorSource.class));  
        assertNotSame(rangeQuery, rewritten.getNestedSort().getFilter());
        assertWarnings("Deprecated field [sort_mode] used, expected [mode] instead");  
                    if (randomBoolean()) {  
                result.order(randomValueOtherThan(original.order(), () -> randomFrom(SortOrder.values())));
     */  
     * Test that if coercion is used, a point gets normalized but the original values in the builder are unchanged  
        assertNotNull(nested);
                String[] geohashes = new String[count];  
    /**  
        geoDistanceSortBuilder.sortMode(SortMode.MIN).unit(DistanceUnit.INCH);  
        return GeoDistanceSortBuilder.fromXContent(parser, fieldName);
 * Unless required by applicable law or agreed to in writing,
        assertEquals("Setting both nested_path/nested_filter and nested not allowed", iae.getMessage());  
        }
            case 0:
                    randomValueOtherThanMany(Arrays.asList(SortMode.SUM, result.sortMode())::contains, () -> randomFrom(SortMode.values()))  
            case 2:
        // need to use distance unit other than Meters to not get back a LatLonPointSortField
        assertEquals(SortField.class, sort.field.getClass()); // 2 points -> plain SortField with a custom comparator  
        sortBuilder.endArray();
        sortBuilder.field("unit", "km");
        sortBuilder.field("order", "desc");
        assertThat(sortField.getComparatorSource(), instanceOf(XFieldComparatorSource.class));
                break;
        assertThat(approxQuery.getApproximationQuery(), CoreMatchers.instanceOf(ApproximateMatchAllQuery.class));  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.index.query.MatchAllQueryBuilder;
        assertEquals(builder.order() == SortOrder.ASC ? false : true, sortField.getReverse());
        builder.point(point.getLat(), point.getLon());
import org.opensearch.index.query.GeoValidationMethod;  
                break;  
                () -> GeoDistanceSortBuilder.fromXContent(itemParser, "")
    }  
        QueryShardContext shardContextMock = createMockShardContext();
        sort = builder.build(context);  
        assertEquals("Setting both nested_path/nested_filter and nested not allowed", iae.getMessage());
        sortBuilder.validation(GeoValidationMethod.COERCE);
            @Override  
        sortField = geoDistanceSortBuilder.build(shardContextMock).field;
import org.opensearch.search.approximate.ApproximateMatchAllQuery;
        switch (id) {  
            GeoDistanceSortBuilder sortBuilder = new GeoDistanceSortBuilder("fieldName", -180.0, 0.0);  
            + "      \"filter\" : {\n"
        sortBuilder.endObject();
    }
        }
        if (testItem.getNestedPath() != null && !assertedWarnings.contains(nestedPathDeprecationWarning)) {  
                );
        int id = -1;
     * Test the nested Filter gets rewritten  
 * compatible open source license.
            }
            }  
        }
        }
    /**  
        sortBuilder.field("order", "desc");
    /**
    }  
        sortBuilder.startObject();
import org.opensearch.index.query.QueryBuilders;
import org.apache.lucene.index.Term;
        parse(sortBuilder);
import org.apache.lucene.search.TermQuery;
                "[-19.700583312660456, -2.8225036337971687, "  
import org.opensearch.common.xcontent.json.JsonXContent;
                break;  
            );  
                Arrays.toString(result.points())  
 * specific language governing permissions and limitations
    }  
    }
        GeoDistanceSortBuilder sortBuilder = new GeoDistanceSortBuilder("fieldName", 1.0, 1.0).setNestedSort(
        sortBuilder.startObject();
            () -> sortBuilder.setNestedPath("nestedPath").setNestedSort(new NestedSortBuilder("otherPath"))
        }
        sortBuilder.startArray("location");
                for (int i = 0; i < count; i++) {
        GeoPoint point = RandomGeoGenerator.randomPoint(random());
        }
        assertEquals(MultiValueMode.MIN, comparatorSource.sortMode());
        // The common case should use LatLonDocValuesField.newDistanceSort
            result.ignoreUnmapped(result.ignoreUnmapped() == false);
                break;  
import org.opensearch.index.query.MatchNoneQueryBuilder;
        sortBuilder.field("mode", "max");  
        GeoDistanceSortBuilder sortBuilder = new GeoDistanceSortBuilder("fieldName", 0.0, 0.0);  
            IllegalArgumentException e = expectThrows(  
        sortBuilder.field("order", "desc");
        iae = expectThrows(
            assertEquals("illegal longitude value [-360.0] for [GeoDistanceSort] for field [fieldName].", ex.getMessage());  
        // if nested path is missing, we omit any filter and return a regular SortField
        try (XContentParser parser = createParser(sortBuilder)) {
        sortBuilder.endArray();  
            }
        }  
        assertThat(approxQuery.getApproximationQuery(), CoreMatchers.instanceOf(ApproximateMatchAllQuery.class));
        SortField sortField = sortBuilder.build(shardContextMock).field;
