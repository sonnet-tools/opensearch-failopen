        sortBuilder.endObject();
            + "          \"boost\" : 5.711116\n"
            }
        if (randomBoolean()) {
     * Test that if coercion is used, a point gets normalized but the original values in the builder are unchanged
                } else {
    protected GeoDistanceSortBuilder mutate(GeoDistanceSortBuilder original) throws IOException {
        sortBuilder.endArray();
        geoDistanceSortBuilder = new GeoDistanceSortBuilder("fieldName", 1.0, 1.0);
    protected void sortFieldAssertions(GeoDistanceSortBuilder builder, SortField sortField, DocValueFormat format) throws IOException {
        assertNotNull(nested);
package org.opensearch.search.sort;
        sortBuilder.value(new GeoPoint(1.2, 3)).value(new GeoPoint(1.2, 3));
        GeoDistanceSortBuilder geoDistanceSortBuilder = new GeoDistanceSortBuilder("fieldName", 1.0, 1.0);
        sortBuilder.startObject();
    protected GeoDistanceSortBuilder fromXContent(XContentParser parser, String fieldName) throws IOException {
                result.ignoreUnmapped(result.ignoreUnmapped() == false);
        }
                    }
 * license agreements. See the NOTICE file distributed with
        sortBuilder.validation(GeoValidationMethod.COERCE);
        sortBuilder.startObject();
            result.ignoreUnmapped(result.ignoreUnmapped() == false);
        parse(sortBuilder);
                }
                result[i] = RandomGeoGenerator.randomPoint(random());
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource.Nested;
import org.opensearch.index.query.QueryBuilder;
            () -> sortBuilder.setNestedPath("nestedPath").setNestedSort(new NestedSortBuilder("otherPath"))
            case 4:
        assertThat(sortField.getComparatorSource(), instanceOf(XFieldComparatorSource.class));
     */
    }
            case 0:
        sortBuilder.field("mode", "max");
    }
            itemParser.nextToken();
import org.opensearch.index.mapper.MappedFieldType;
    public void testSortModeSumIsRejectedInJSON() throws IOException {
    }
        GeoDistanceSortBuilder rewritten = (GeoDistanceSortBuilder) sortBuilder.rewrite(createMockShardContext());
        assertEquals("Setting both nested_path/nested_filter and nested not allowed", iae.getMessage());
    }
        parse(sortBuilder);
            case 6:
            // all good
        RangeQueryBuilder rangeQuery = new RangeQueryBuilder("fieldName") {
        assertNotSame(rangeQuery, rewritten.getNestedFilter());
        GeoDistanceSortBuilder sortBuilder = new GeoDistanceSortBuilder("fieldName", 1.0, 1.0).setNestedSort(
        sortBuilder.startObject();
        comparatorSource = (XFieldComparatorSource) sortField.getComparatorSource();
    }
                break;
        String fieldName = randomAlphaOfLengthBetween(1, 10);
        return new GeoPointFieldMapper.GeoPointFieldType(name);
                return new MatchNoneQueryBuilder();
            GeoDistanceSortBuilder result = GeoDistanceSortBuilder.fromXContent(itemParser, json);
        assertThat(approxQuery.getOriginalQuery(), CoreMatchers.instanceOf(MatchAllDocsQuery.class));
            result.sortMode(randomValueOtherThan(SortMode.SUM, () -> randomFrom(SortMode.values())));
        sortBuilder.startArray("location");
public class GeoDistanceSortBuilderTests extends AbstractSortTestCase<GeoDistanceSortBuilder> {
        );
        sortBuilder.field("unit", "km");
        sortBuilder.field("sort_mode", "max");
        sortBuilder.field("order", "desc");
    /**
        sortBuilder.startArray().value(1.2).value(3).endArray().startArray().value(5).value(6).endArray();
 * this work for additional information regarding copyright
        sortBuilder.field("mode", "max");
        assertThat(sortField.getComparatorSource(), instanceOf(XFieldComparatorSource.class));
        sortBuilder.field("order", "desc");
    private static GeoDistance geoDistance(GeoDistance original) {
 * Licensed to Elasticsearch under one or more contributor
     * Test that the sort builder order gets transferred correctly to the SortField
        assertEquals(false, geoDistanceSortBuilder.build(shardContextMock).field.getReverse());
            fail("sort mode sum should not be supported");
            assertEquals("illegal longitude value [-360.0] for [GeoDistanceSort] for field [fieldName].", ex.getMessage());
import org.hamcrest.CoreMatchers;
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
            for (int i = 0; i < count; i++) {
    private static GeoPoint[] points(GeoPoint[] original) {
        if (testItem.getNestedFilter() != null && !assertedWarnings.contains(nestedFilterDeprecationWarning)) {
                break;
            result.order(randomFrom(SortOrder.values()));
        List<String> expectedWarnings = new ArrayList<>();
        String json = "{\n"
    /**
                result = new GeoDistanceSortBuilder(fieldName, points(new GeoPoint[0]));
        // need to use distance unit other than Meters to not get back a LatLonPointSortField
                    + "31.537466906011105, -74.63590376079082, "
        );
            expectedWarnings.add(nestedPathDeprecationWarning);
import static org.hamcrest.Matchers.instanceOf;
    @Override
        }
        int id = randomIntBetween(0, 2);
        sortBuilder.field("unit", "km");
        sortBuilder.startObject();
        geoDistanceSortBuilder.sortMode(SortMode.MAX);
    public void testBuildNested() throws IOException {
        }
                    );
import org.opensearch.test.geo.RandomGeoGenerator;
        sortBuilder.value("1,2").value("3,4");
        iae = expectThrows(
        QueryShardContext shardContextMock = createMockShardContext();
        sortBuilder = new GeoDistanceSortBuilder("fieldName", 1.0, 1.0).setNestedPath("path")
            return GeoDistanceSortBuilder.fromXContent(parser, null);
        parse(sortBuilder);
            + "}";
/*
    public void testNestedSortBothThrows() throws IOException {
        sortBuilder = jsonBuilder();
        // if nested path is missing, we omit any filter and return a regular SortField
        iae = expectThrows(
        int parameter = randomIntBetween(0, 8);
        sortBuilder.field("order", "desc");
                result = new GeoDistanceSortBuilder(fieldName, geohashes);
 *
        sortBuilder.startArray("location");
    public void testBuildCoerce() throws IOException {
        assertEquals(SortField.class, sort.field.getClass()); // can't use LatLon optimized sorting with DESC sorting
        return result;
    }
                    randomValueOtherThanMany(Arrays.asList(SortMode.SUM, result.sortMode())::contains, () -> randomFrom(SortMode.values()))
        sortBuilder.endObject();
        XFieldComparatorSource comparatorSource = (XFieldComparatorSource) sortField.getComparatorSource();
                result.geoDistance(geoDistance(original.geoDistance()));
        geoDistanceSortBuilder.order(SortOrder.DESC);
        GeoDistanceSortBuilder sortBuilder = new GeoDistanceSortBuilder("fieldName", 0.0, 0.0);
        builder.point(point.getLat(), point.getLon());
        sortBuilder.field("mode", "max");
        if (testItem.getNestedPath() != null && !assertedWarnings.contains(nestedPathDeprecationWarning)) {
            );
            + "    \"ezu09wxw6v4c\", \"kc7s3515p6k6\", \"jgeuvjwrmfzn\", \"kcpcfj7ruyf8\" ],\n"
    }
        sortBuilder.value(new GeoPoint(1, 2)).value("s3y0zh7w1z0g").startArray().value(1).value(2).endArray().value("1,2");
            case 1:
        sortBuilder.field("unit", "km");
                    + "-39.03717711567879, 44.74099852144718]",
            IllegalArgumentException.class,
            sortBuilder.validation(GeoValidationMethod.STRICT);
        assertEquals(SortField.class, sort.field.getClass()); // can't use LatLon optimized sorting with nested fields
        assertNotNull(nested);
        sortBuilder.field("mode", "max");
        assertThat(sortField, instanceOf(SortField.class));
        geoDistanceSortBuilder.order(SortOrder.ASC).unit(DistanceUnit.INCH);
    public void testGeoDistanceSortCanBeParsedFromGeoHash() throws IOException {
        builder = new GeoDistanceSortBuilder("random_field_name", new GeoPoint(3.5, 2.1));
            itemParser.nextToken();
        sortField = geoDistanceSortBuilder.build(shardContextMock).field;
        sortBuilder.field("unit", "km");
        assertThat(sortField.getComparatorSource(), instanceOf(XFieldComparatorSource.class));
                }
import org.opensearch.index.mapper.GeoPointFieldMapper;
        assertThat(approxQuery.getApproximationQuery(), CoreMatchers.instanceOf(ApproximateMatchAllQuery.class));
            + "    \"lon\" : -51.94128329747579\n"
        sort = builder.build(context);
            case 2:
import org.apache.lucene.index.Term;
    }
     */
     */
        sortBuilder.field("mode", "max");
        sortField = geoDistanceSortBuilder.build(shardContextMock).field;
import org.opensearch.common.geo.GeoDistance;
        assertEquals(builder.order() == SortOrder.ASC ? false : true, sortField.getReverse());
        sortBuilder.endObject();
    /**
            case 3:
        try {
                for (int i = 0; i < count; i++) {
        }
                        result.setNestedFilter(randomValueOtherThan(original.getNestedFilter(), () -> randomNestedFilter()));
            IllegalArgumentException e = expectThrows(
        sortField = sortBuilder.build(shardContextMock).field;
 * The OpenSearch Contributors require contributions made to
                    if (randomBoolean()) {
        }
    }
                throw new IllegalStateException("one of three geo initialisation strategies must be used");
        return randomGeoDistanceSortBuilder();
        sortBuilder.endObject();
    public void testCommonCaseIsOptimized() throws IOException {
        }
     */
        QueryShardContext shardContextMock = createMockShardContext();
        }
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                nestedSort.setFilter(new MatchAllQueryBuilder());
            + "  \"unit\" : \"m\",\n"
        assertThat(sortField.getComparatorSource(), instanceOf(XFieldComparatorSource.class));
    @Override
        geoDistanceSortBuilder.sortMode(SortMode.AVG);
            + "        }\n"
import org.opensearch.index.query.RangeQueryBuilder;
/*
     * Test that the sort builder mode gets transferred correctly to the SortField
    protected GeoDistanceSortBuilder createTestItem() {
            assertedWarnings.addAll(expectedWarnings);
            + "    \"VDcvDuFjE\" : [ \"7umzzv8eychg\", \"dmdgmt5z13uw\", "
        sortBuilder.startArray("location");
import org.opensearch.core.xcontent.XContentParser;
                "[-19.700583312660456, -2.8225036337971687, "
                    + "-69.44606635719538, 84.25200328230858, "
        sortBuilder = jsonBuilder();
 * KIND, either express or implied.  See the License for the
        // use MultiValueMode.Min if no Mode and order is ASC
    }
        sortBuilder.field("mode", "max");
        geoDistanceSortBuilder.sortMode(SortMode.MEDIAN);
     * Test that if validation is strict, invalid points throw an error
import org.opensearch.index.mapper.NestedPathFieldMapper;
 *    http://www.apache.org/licenses/LICENSE-2.0
        GeoDistanceSortBuilder sortBuilder = new GeoDistanceSortBuilder("fieldName", 0.0, 0.0);
        geoDistanceSortBuilder = new GeoDistanceSortBuilder("fieldName", 1.0, 1.0);
        assertEquals(MultiValueMode.MIN, comparatorSource.sortMode());
        RangeQueryBuilder rangeQuery = new RangeQueryBuilder("fieldName") {
                break;
     */
            assertWarnings(expectedWarnings.toArray(new String[0]));
    /**
     * Test we can either set nested sort via path/filter or via nested sort builder, not both
 * specific language governing permissions and limitations
    /**
                NestedSortBuilder nestedSort = new NestedSortBuilder(randomAlphaOfLengthBetween(3, 10));
        sortBuilder.endArray();
            case 1:
        sortBuilder.field("location", new GeoPoint(1, 2));
            + "        \"ids\" : {\n"
            expectedWarnings.add(nestedFilterDeprecationWarning);
            result.unit(randomValueOtherThan(result.unit(), () -> randomFrom(DistanceUnit.values())));
            IllegalArgumentException.class,
        sortBuilder.startArray("location");
import org.opensearch.common.geo.GeoPoint;
    }
    public void testGeoDistanceSortDeprecatedSortModeException() throws Exception {
        sortBuilder.startObject();
                    } else {
        assertEquals(false, geoDistanceSortBuilder.build(shardContextMock).field.getReverse());
        assertThat(approxQuery.getOriginalQuery(), CoreMatchers.instanceOf(MatchAllDocsQuery.class));
 * GitHub history for details.
        assertEquals(new TermQuery(new Term(NestedPathFieldMapper.NAME, "path")), nested.getInnerQuery());
                IllegalArgumentException.class,
        }
        }
        parse(sortBuilder);
        );
        sortBuilder.endArray();
            + "    \"unit\" : \"m\",\n"
            case 5:
        assertEquals(-360.0, sortBuilder.points()[0].getLon(), 0.0);
        sortBuilder.field("unit", "km");
                    + "-37.20467280596495, 38.71751043945551, "
                }
    @Override
        assertNotSame(rangeQuery, rewritten.getNestedSort().getFilter());
        while (result == null || Arrays.deepEquals(original, result)) {
        }
        comparatorSource = (XFieldComparatorSource) sortField.getComparatorSource();
        return GeoDistanceSortBuilder.fromXContent(parser, fieldName);
        parse(sortBuilder);
            + "    \"lat\" : -6.046997540714173,\n"
                break;
            }
     */
        assertNotNull(nested);
        approxQuery = (ApproximateScoreQuery) nested.getInnerQuery();
        sortBuilder.field("mode", "max");
 * this file be licensed under the Apache-2.0 license or a
import java.util.HashSet;
        };
import org.opensearch.index.query.MatchNoneQueryBuilder;
    /**
        geoDistanceSortBuilder.order(SortOrder.ASC);
     */
            int count = randomIntBetween(1, 10);
import org.opensearch.search.MultiValueMode;
        sortBuilder.field("unit", "km");
                // the following are alternative ways to setNestedSort for nested sorting
                () -> GeoDistanceSortBuilder.fromXContent(itemParser, "")
                }
        GeoDistanceSortBuilder rewritten = (GeoDistanceSortBuilder) sortBuilder.rewrite(createMockShardContext());
 * SPDX-License-Identifier: Apache-2.0
        sortBuilder.setNestedPath("path").setNestedFilter(rangeQuery);
        sortField = geoDistanceSortBuilder.build(shardContextMock).field;
            @Override
                if (randomBoolean()) {
import java.util.ArrayList;
import org.apache.lucene.search.MatchAllDocsQuery;
                result = new GeoDistanceSortBuilder(fieldName, pt.getLat(), pt.getLon());
        sortBuilder.field("unit", "km");
        comparatorSource = (XFieldComparatorSource) sortField.getComparatorSource();
        sortBuilder.value(1.2).value(3);
        builder = new GeoDistanceSortBuilder("random_field_name", new GeoPoint(3.5, 2.1));
                break;
        SortField sortField = sortBuilder.build(shardContextMock).field;
        builder.order(SortOrder.DESC);
        parse(sortBuilder);
     * Test the nested Filter gets rewritten
        comparatorSource = (XFieldComparatorSource) sortField.getComparatorSource();
import org.opensearch.index.query.QueryBuilders;
 */
                break;
        sortBuilder.endObject();
    protected MappedFieldType provideMappedFieldType(String name) {
            + "      }\n"
        String nestedPathDeprecationWarning = "[nested_path] has been deprecated in favour of the [nested] parameter";
        geoDistanceSortBuilder = new GeoDistanceSortBuilder("fieldName", 1.0, 1.0);
                if (randomBoolean()) {
        assertEquals(MultiValueMode.MAX, comparatorSource.sortMode());
        builder.unit(DistanceUnit.KILOMETERS);
                Arrays.toString(result.points())
            result.validation(randomValueOtherThan(result.validation(), () -> randomFrom(GeoValidationMethod.values())));
    }
        if (randomBoolean()) {
        assertThat(sortField.getComparatorSource(), instanceOf(XFieldComparatorSource.class));
        sortBuilder.startArray("location");
        if (randomBoolean()) {
        nested = comparatorSource.nested();
            OpenSearchParseException ex = expectThrows(OpenSearchParseException.class, () -> sortBuilder.build(shardContextMock));
        sort = builder.build(context);
            }
        XContentBuilder sortBuilder = jsonBuilder();
        assertEquals(builder.fieldName(), sortField.getField());
        SortField sortField = sortBuilder.build(shardContextMock).field;
    /**
            result = new GeoPoint[count];
        assertEquals(MultiValueMode.MEDIAN, comparatorSource.sortMode());
        if (randomBoolean()) {
                        randomValueOtherThan(original.getNestedSort(), () -> NestedSortBuilderTests.createRandomNestedSort(3))
            assertEquals("sort_mode [sum] isn't supported for sorting by geo distance", e.getMessage());
            } else {
        sortBuilder.field("location", "1,2");
                result.unit(randomValueOtherThan(result.unit(), () -> randomFrom(DistanceUnit.values())));
            id = randomIntBetween(0, GeoDistance.values().length - 1);
import org.opensearch.index.query.MatchAllQueryBuilder;
        while (id == -1 || (original != null && original.ordinal() == id)) {
        );
        GeoDistanceSortBuilder sortBuilder = new GeoDistanceSortBuilder("fieldName", 0.0, 0.0);
        sortBuilder = jsonBuilder();
                    result.setNestedFilter(new MatchAllQueryBuilder());
            + "  \"distance_type\" : \"arc\",\n"
        sortBuilder.field("order", "desc");
        }
        sortBuilder.field("unit", "km");
        sortBuilder.field("location", "s3y0zh7w1z0g");
        ApproximateScoreQuery approxQuery = (ApproximateScoreQuery) nested.getInnerQuery();
            }
import org.apache.lucene.document.LatLonDocValuesField;
        sortBuilder.value("s3y0zh7w1z0g").value("s6wjr4et3f8v");
        }
    }
                    + "43.71844606474042, -5.548660643398762, "
                result.sortMode(
                break;
import java.util.Set;
        return result;
        assertEquals(true, geoDistanceSortBuilder.build(shardContextMock).field.getReverse());
import org.opensearch.index.query.QueryRewriteContext;
        QueryShardContext shardContextMock = createMockShardContext();
 */
            case 0:
        sortBuilder.field("unit", "km");
        sortBuilder.field("order", "desc");
        sortBuilder.startArray("location");
        // The common case should use LatLonDocValuesField.newDistanceSort
        sortField = sortBuilder.build(shardContextMock).field;
import org.opensearch.search.approximate.ApproximateMatchAllQuery;
        Nested nested = comparatorSource.nested();
import java.util.List;
            + "    \"validation_method\" : \"STRICT\"\n"
            builder.sortMode(SortMode.SUM);
            if (randomBoolean()) {
        // make sure the below tests test something...
                    geohashes[i] = RandomGeoGenerator.randomPoint(random()).geohash();
    public void testBuildInvalidPoints() throws IOException {
    }
        // also use MultiValueMode.Max if no Mode set but order is DESC
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        try (XContentParser itemParser = createParser(JsonXContent.jsonXContent, json)) {
/*
            + "    \"mode\" : \"MAX\",\n"
            @Override
            + "    \"distance_type\" : \"arc\",\n"
        comparatorSource = (XFieldComparatorSource) sortField.getComparatorSource();
        sortBuilder.field("unit", "km");
}
        String nestedFilterDeprecationWarning = "[nested_filter] has been deprecated in favour of the [nested] parameter";
        assertThat(approxQuery.getApproximationQuery(), CoreMatchers.instanceOf(ApproximateMatchAllQuery.class));
        sortBuilder.startArray().value(1.2).value(3).endArray().startArray().value(5).value(6).endArray();
        sortBuilder.endArray();
        sortBuilder.field("mode", "max");
        assertThat(sortField.getComparatorSource(), instanceOf(XFieldComparatorSource.class));
                int count = randomIntBetween(1, 10);
        sortBuilder = jsonBuilder();
        }
import java.util.Arrays;
        assertEquals(MultiValueMode.MAX, comparatorSource.sortMode());
        sort = builder.build(context);
        sortBuilder.endObject();
            + "    \"nested\" : {\n"
            GeoDistanceSortBuilder sortBuilder = new GeoDistanceSortBuilder("fieldName", -180.0, 0.0);
        sortBuilder.startObject();
        sortField = sortBuilder.build(shardContextMock).field;
                );
            + "    },\n"
    private GeoDistanceSortBuilder parse(XContentBuilder sortBuilder) throws Exception {
            () -> sortBuilder.setNestedSort(new NestedSortBuilder("otherPath")).setNestedPath("nestedPath")
                        result.setNestedPath(randomValueOtherThan(original.getNestedPath(), () -> randomAlphaOfLengthBetween(1, 10)));
        }
        if (randomBoolean()) {
        builder = new GeoDistanceSortBuilder("random_field_name", new GeoPoint(3.5, 2.1));
        }
                return new MatchNoneQueryBuilder();
        sortBuilder.startArray("location");
        // need to use distance unit other than Meters to not get back a LatLonPointSortField
            new NestedSortBuilder("path").setFilter(QueryBuilders.matchAllQuery())
        assertFalse(SortField.class.equals(LatLonDocValuesField.newDistanceSort("random_field_name", 3.5, 2.1).getClass()));
        sortBuilder.endObject();
        assertThat(sortField.getComparatorSource(), instanceOf(XFieldComparatorSource.class));
        builder = new GeoDistanceSortBuilder("random_field_name", new GeoPoint(3.5, 2.1));
        QueryShardContext context = createMockShardContext();
            assertEquals("illegal latitude value [-180.0] for [GeoDistanceSort] for field [fieldName].", ex.getMessage());
        sortField = geoDistanceSortBuilder.build(shardContextMock).field;
                while (Arrays.deepEquals(original.points(), result.points())) {
        assertThat(sortField.getComparatorSource(), instanceOf(XFieldComparatorSource.class));
    }
            parser.nextToken();
                break;
        if (randomBoolean()) {
        sortBuilder.startObject();
        assertEquals(-180.0, sortBuilder.points()[0].getLat(), 0.0);
        geoDistanceSortBuilder.sortMode(SortMode.MIN).unit(DistanceUnit.INCH);
                    GeoPoint pt = RandomGeoGenerator.randomPoint(random());
        sortBuilder = jsonBuilder();
        sortBuilder.endObject();
        // (LatLonSortField)
 *
        GeoDistanceSortBuilder geoDistanceSortBuilder = new GeoDistanceSortBuilder("fieldName", 1.0, 1.0);
        return GeoDistance.values()[id];
        GeoPoint[] result = null;
        assertEquals(SortField.class, sort.field.getClass()); // descending means the max value should be considered rather than min
        builder.setNestedPath("some_nested_path");
    }
        sortBuilder.startObject();
                result.setNestedSort(nestedSort);
                result.points(points(original.points()));
     * Test the nested sort gets rewritten
    }
    }
        sort = builder.build(context);
        int id = -1;
        GeoDistanceSortBuilder sortBuilder = new GeoDistanceSortBuilder("fieldName", -180.0, -360.0);
                }
    /**
import org.opensearch.search.approximate.ApproximateScoreQuery;
        sortBuilder = jsonBuilder();
            + "          \"values\" : [ ],\n"
        }
        assertEquals(LatLonDocValuesField.newDistanceSort("fieldName", 0.0, 180.0), sortField);
        sortBuilder.field("order", "desc");
                break;
        sortBuilder.field("order", "desc");
import org.apache.lucene.search.TermQuery;
    }
            () -> sortBuilder.setNestedSort(new NestedSortBuilder("otherPath")).setNestedFilter(QueryBuilders.matchAllQuery())
        assertEquals(SortField.class, sort.field.getClass()); // 2 points -> plain SortField with a custom comparator
     */
        XContentBuilder sortBuilder = jsonBuilder();
        // however this might be disabled by fancy options
import org.opensearch.OpenSearchParseException;
        };
            case 2:
        sortBuilder.endArray();
        try (XContentParser parser = createParser(sortBuilder)) {
    public void testMultiValueMode() throws IOException {
        }
    }
            .setNestedFilter(QueryBuilders.matchAllQuery());
    public void testNestedSortRewrites() throws IOException {
        {
 * Modifications Copyright OpenSearch Contributors. See
        parse(sortBuilder);
        SortField sortField = geoDistanceSortBuilder.build(shardContextMock).field;
                // don't fully randomize here, GeoDistanceSort is picky about the filters that are allowed
            );
    private Set<String> assertedWarnings = new HashSet<>();
import org.opensearch.search.DocValueFormat;
        parse(sortBuilder);
    }
        assertWarnings("Deprecated field [sort_mode] used, expected [mode] instead");
        assertEquals(LatLonDocValuesField.newDistanceSort("random_field_name", 3.5, 2.1).getClass(), sort.field.getClass());
import org.opensearch.common.xcontent.json.JsonXContent;
        sortBuilder.field("order", "desc");
            default:
        }
        parse(sortBuilder);
        switch (parameter) {
        } catch (IllegalArgumentException e) {
import org.opensearch.index.query.QueryShardContext;
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
        switch (id) {
            + "      \"filter\" : {\n"
        builder.order(SortOrder.DESC);
        sortBuilder = jsonBuilder();
    public void testBuildSortFieldOrder() throws IOException {
    public void testGeoDistanceSortParserManyPointsNoException() throws Exception {
        return result;
        assertEquals("Setting both nested_path/nested_filter and nested not allowed", iae.getMessage());
        nested = comparatorSource.nested();
        sortBuilder.field("mode", "max");
            IllegalArgumentException.class,
            case 8:
        sortBuilder.startObject();
        QueryShardContext shardContextMock = createMockShardContext();
    public void testNestedRewrites() throws IOException {
        GeoDistanceSortBuilder builder = new GeoDistanceSortBuilder("", new GeoPoint(3.5, 2.1));
                break;
            OpenSearchParseException ex = expectThrows(OpenSearchParseException.class, () -> sortBuilder.build(shardContextMock));
        sortBuilder.endArray();
        try (XContentParser itemParser = createParser(JsonXContent.jsonXContent, json)) {
 *
        assertThat(nested.getInnerQuery(), CoreMatchers.instanceOf(ApproximateScoreQuery.class));
        builder = new GeoDistanceSortBuilder("random_field_name", new GeoPoint(3.5, 2.1), new GeoPoint(3.0, 4));
            result.geoDistance(geoDistance(result.geoDistance()));
        sortBuilder.endObject();
            + "  \"mode\" : \"SUM\"\n"
    public void testSortModeSumIsRejectedInSetter() {
            GeoDistanceSortBuilder sortBuilder = new GeoDistanceSortBuilder("fieldName", 0.0, -360.0);
 * under the License.
        {
        GeoDistanceSortBuilder result = new GeoDistanceSortBuilder(original);
    @Override
                    result.point(pt.getLat(), pt.getLon());
 * compatible open source license.
        assertThat(sortField.getComparatorSource(), instanceOf(XFieldComparatorSource.class));
        assertThat(nested.getInnerQuery(), CoreMatchers.instanceOf(ApproximateScoreQuery.class));
 * Unless required by applicable law or agreed to in writing,
    @Override
                GeoPoint pt = RandomGeoGenerator.randomPoint(random());
import org.opensearch.core.xcontent.XContentBuilder;
        parse(sortBuilder);
    public static GeoDistanceSortBuilder randomGeoDistanceSortBuilder() {
 */
 * ownership. Elasticsearch licenses this file to you under
        sortBuilder = jsonBuilder();
import org.opensearch.common.unit.DistanceUnit;
                if (original.getNestedPath() == null && original.getNestedFilter() == null) {
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource;
        assertEquals(MultiValueMode.AVG, comparatorSource.sortMode());
import org.opensearch.index.query.GeoValidationMethod;
            assertEquals(
import org.apache.lucene.search.SortField;
        sortBuilder = new GeoDistanceSortBuilder("fieldName", 1.0, 1.0).setNestedPath("path");
        GeoDistanceSortBuilder builder = new GeoDistanceSortBuilder("testname", -1, -1);
                result.validation(randomValueOtherThan(result.validation(), () -> randomFrom(GeoValidationMethod.values())));
        assertEquals(MultiValueMode.MIN, comparatorSource.sortMode());
        comparatorSource = (XFieldComparatorSource) sortField.getComparatorSource();
            + "  \"testname\" : [ {\n"
            case 7:
        SortFieldAndFormat sort = builder.build(context);
        IllegalArgumentException iae = expectThrows(
                result.order(randomValueOtherThan(original.order(), () -> randomFrom(SortOrder.values())));
        XFieldComparatorSource comparatorSource = (XFieldComparatorSource) sortField.getComparatorSource();
        sort = builder.build(context);
            sortBuilder.validation(GeoValidationMethod.STRICT);
        sortBuilder.endArray();
            + "  } ],\n"
        }
        comparatorSource = (XFieldComparatorSource) sortField.getComparatorSource();
        sortField = geoDistanceSortBuilder.build(shardContextMock).field;
                String[] geohashes = new String[count];
            public QueryBuilder doRewrite(QueryRewriteContext queryShardContext) throws IOException {
        sortBuilder.endObject();
     * Test that the sort builder nested object gets created in the SortField
        if (randomBoolean()) {
        String json = "{\n"
            + "  }";
    }
        sortBuilder = new GeoDistanceSortBuilder("fieldName", 1.0, 1.0).setNestedFilter(QueryBuilders.termQuery("fieldName", "value"));
                break;
                    result.setNestedPath(randomAlphaOfLengthBetween(1, 10));
        sortBuilder.field("order", "desc");
                break;
        }
        GeoDistanceSortBuilder result = null;
        sortBuilder.field("order", "desc");
    }
        if (expectedWarnings.isEmpty() == false) {
    protected void assertWarnings(GeoDistanceSortBuilder testItem) {
        assertEquals(SortField.class, sort.field.getClass()); // km rather than m -> plain SortField with a custom comparator
        QueryShardContext shardContextMock = createMockShardContext();
        GeoPoint point = RandomGeoGenerator.randomPoint(random());
            public QueryBuilder doRewrite(QueryRewriteContext queryShardContext) throws IOException {
 * You may obtain a copy of the License at
        geoDistanceSortBuilder.order(SortOrder.DESC);
                    result.setNestedSort(
    }
import java.io.IOException;
        assertEquals("Setting both nested_path/nested_filter and nested not allowed", iae.getMessage());
        sortBuilder.startObject();
        sortBuilder.setNestedSort(new NestedSortBuilder("path").setFilter(rangeQuery));
