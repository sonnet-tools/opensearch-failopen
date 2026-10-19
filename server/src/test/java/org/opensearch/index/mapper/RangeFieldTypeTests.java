        );
                break;
import org.apache.lucene.document.FloatRange;
                from = fromValue;
        );
            default:
import org.joda.time.DateTime;
        }
                return getIntRangeQuery(relation, (int) from, (int) to, includeLower, includeUpper);
        switch (type) {
import org.apache.lucene.document.DoubleRange;
            queryType = BinaryDocValuesRangeQuery.QueryType.WITHIN;
        String lowerAsString = formatter.formatMillis(lower);
        }
            queryType = BinaryDocValuesRangeQuery.QueryType.INTERSECTS;
                to = new DateTime(fromValue + 1);
import org.apache.lucene.document.LongRange;
    }
        }
        final String from = "2016-15-06T15:29:50+08:00";
        assertEquals(1465975790000L, formatter.parseMillis(from));
        final DateFormatter formatter = DateFormatter.forPattern("yyyy-dd-MM'T'HH:mm");
/*
                from = fromValue;
 * GitHub history for details.
    private QueryShardContext createContext() {
                from = fromValue;
import org.opensearch.lucene.queries.BinaryDocValuesRangeQuery;
        MappedFieldType dateMapper = new RangeFieldMapper.Builder("field", RangeType.DATE, true, Version.V_EMPTY).format(
            getExpectedRangeQuery(relation, from, to, includeLower, includeUpper),
        boolean includeUpper = randomBoolean();
    }
        long[] lower = new long[] { from + (includeLower ? 0 : 1) };
        );
        }
                return random().nextDouble() * 0.5 - DISTANCE;
import org.opensearch.common.network.InetAddresses;
import static org.hamcrest.Matchers.instanceOf;
            }
            case LONG:
        }
            ((IndexOrDocValuesQuery) ((ApproximateScoreQuery) queryOnDateField).getOriginalQuery()).getIndexQuery().toString()
        final Query query = fieldType.rangeQuery(from, to, true, true, relation, null, fieldType.dateMathParser(), context);
                break;
            queryType = BinaryDocValuesRangeQuery.QueryType.CONTAINS;
            queryType = BinaryDocValuesRangeQuery.QueryType.WITHIN;
            case LONG: {
            case LONG: {
        assertThat(
            }
            idxSettings,
    /**
 * license agreements. See the NOTICE file distributed with
            OpenSearchParseException.class,
        RangeFieldType strict = new RangeFieldType("field", RangeFieldMapper.Defaults.DATE_FORMATTER);
    }
            indexQuery = IntRange.newContainsQuery("field", lower, upper);
            case IP:
            null,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        switch (type) {
        );
            queryType = BinaryDocValuesRangeQuery.QueryType.WITHIN;
            indexQuery = LongRange.newIntersectsQuery("field", lower, upper);
        assertEquals(1465975790000L, formatter.parseMillis(from));
        } else {
                byte[] ipv4 = new byte[4];
public class RangeFieldTypeTests extends FieldTypeTestCase {
                random().nextBytes(ipv4);
        Query rangeQuery = ft.rangeQuery(from, to, false, false, relation, null, null, context);
            queryType = BinaryDocValuesRangeQuery.QueryType.INTERSECTS;
        } else if (relation == ShapeRelation.CONTAINS) {
 * ownership. Elasticsearch licenses this file to you under
    }
                break;
            () -> nowInMillis,
 * The OpenSearch Contributors require contributions made to
            case DOUBLE: {
        Query indexQuery;
            case INTEGER:
    public void testRangeQuery() throws Exception {
                from = nextFrom();
            null,
    private Query getFloatRangeQuery(ShapeRelation relation, float from, float to, boolean includeLower, boolean includeUpper) {
        InetAddress upper = includeUpper ? to : InetAddressPoint.nextDown(to);
        Query dvQuery = RangeType.DATE.dvRangeQuery("field", queryType, from.getMillis(), to.getMillis(), includeLower, includeUpper);
                return (Long) from + DISTANCE;
import org.opensearch.search.approximate.ApproximateScoreQuery;
    public void testTermQuery() throws Exception {
/*
            indexQuery = LongRange.newWithinQuery("field", lower, upper);
        // check that using this bounds we get similar query when constructing equivalent query on date_range field
    private Query getLongRangeQuery(ShapeRelation relation, long from, long to, boolean includeLower, boolean includeUpper) {
import java.util.Collections;
                return getLongRangeQuery(relation, (long) from, (long) to, includeLower, includeUpper);
 * not use this file except in compliance with the License.
        assertTrue(ex.getMessage().contains("is greater than `to` value"));
        return new IndexOrDocValuesQuery(indexQuery, dvQuery);
        Query indexQuery;
        IllegalArgumentException ex = expectThrows(
        // See https://github.com/elastic/elasticsearch/issues/25950
    }
        }
            BigArrays.NON_RECYCLING_INSTANCE,
            }
        long upper = randomLongBetween(formatter.parseMillis("2011-01-01T00:00"), formatter.parseMillis("2020-01-01T00:00"));
                long fromValue = randomInt();
import java.net.InetAddress;
        assertEquals(1466062190000L, formatter.parseMillis(to));
            default:
            case FLOAT: {
    }
    private Query getInetAddressRangeQuery(
        // setting mapping format which is compatible with those dates
        }
            indexQuery = InetAddressRange.newIntersectsQuery("field", lower, upper);
        }
            indexQuery = InetAddressRange.newWithinQuery("field", lower, upper);
                from = fromValue;
                int fromValue = randomInt();
            queryType = BinaryDocValuesRangeQuery.QueryType.WITHIN;
        boolean includeUpper
        // also add date math rounding to days occasionally
        if (includeLower == false && includeUpper == false) {
        QueryShardContext context = createContext();
import org.opensearch.common.geo.ShapeRelation;
        // don't use DISJOINT here because it doesn't work on date fields which we want to compare bounds with
     * check that we catch cases where the user specifies larger "from" than "to" value, not counting the include upper/lower settings
            ++lowerBoundLong;
        Query indexQuery;
 * SPDX-License-Identifier: Apache-2.0
        final DateFormatter formatter = DateFormatter.forPattern("yyyy-dd-MM'T'HH:mm:ssZZZZZ");
        long lowerBoundLong = dateFieldType.parseToLong(lowerAsString, !includeLower, null, formatter.toDateMathParser(), () -> 0);
        float[] upper = new float[] { includeUpper ? to : Math.nextDown(to) };
        assertEquals(InetAddresses.forString("::1"), RangeType.IP.parseValue(new BytesRef("::1"), randomBoolean(), null));
            indexQuery = LongRange.newWithinQuery("field", lower, upper);
            indexQuery = DoubleRange.newWithinQuery("field", lower, upper);
            () -> strict.rangeQuery(from, to, true, true, relation, null, null, context)
        nowInMillis = randomNonNegativeLong();
    }
        OpenSearchParseException ex = expectThrows(
        BinaryDocValuesRangeQuery.QueryType queryType;
        ).build(context).fieldType();
        return new IndexOrDocValuesQuery(indexQuery, dvQuery);
        Object to = nextTo(from);
            lowerAsString = lowerAsString + "||/d";
        long[] upper = new long[] { to.getMillis() - (includeUpper ? 0 : 1) };
            }
        ShapeRelation relation = ShapeRelation.INTERSECTS;
        final String to = "2016-16-06T15:29:50+08:00";
        BinaryDocValuesRangeQuery.QueryType queryType;
 * this work for additional information regarding copyright
import org.opensearch.Version;
        }
                float fromValue = randomFloat();
        QueryShardContext context = createContext();
        double[] upper = new double[] { includeUpper ? to : Math.nextDown(to) };
import java.io.IOException;
        );
            queryType = BinaryDocValuesRangeQuery.QueryType.CONTAINS;
    }
    RangeType type;
            xContentRegistry(),
                return getDoubleRangeQuery(relation, (double) from, (double) to, includeLower, includeUpper);
        final DateFormatter formatter = DateFormatter.forPattern("yyyy-dd-MM'T'HH:mm:ssZZZZZ");
    ) {
            queryType = BinaryDocValuesRangeQuery.QueryType.CONTAINS;
import org.apache.lucene.search.IndexOrDocValuesQuery;
        switch (type) {
        Query dvQuery = RangeType.IP.dvRangeQuery("field", queryType, from, to, includeLower, includeUpper);
        if (randomBoolean()) {
            queryType = BinaryDocValuesRangeQuery.QueryType.INTERSECTS;
import org.junit.Before;
            () -> ft.rangeQuery(from, to, true, true, relation, null, null, context)
                to = new DateTime(fromValue - 1);
            case FLOAT:
        } else {
                from = fromValue;
                return (int) (random().nextInt() * 0.5 - DISTANCE);
        RangeFieldType fieldType = new RangeFieldType("field", formatter);
        } else {
        assumeThat("Using legacy datetime format as default", FeatureFlags.isEnabled(FeatureFlags.DATETIME_FORMATTER_CACHING), is(false));
     */
        assertEquals(getExpectedRangeQuery(relation, value, value, includeLower, includeUpper), ft.termQuery(value, context));
        Query dvQuery = RangeType.FLOAT.dvRangeQuery("field", queryType, from, to, includeLower, includeUpper);
            lowerAsString,
        MappedFieldType longMapper = new RangeFieldMapper.Builder("field", RangeType.LONG, true, Version.V_EMPTY).build(context)
            case LONG:
                to = Math.nextUp(fromValue);
        Map<String, Object> dateRange = Map.of("lt", "1990-12-29T00:00:00.000Z");
        assertEquals(Collections.singletonList(Map.of("lt", "1990/12/29", "gte", "1988/12/06")), fetchSourceValue(dateMapper, dateRange));
        if (relation == ShapeRelation.WITHIN) {
package org.opensearch.index.mapper;
            writableRegistry(),
            queryType = BinaryDocValuesRangeQuery.QueryType.CONTAINS;
        RangeFieldType ft = createDefaultFieldType();
import org.opensearch.index.query.QueryShardException;
                from = fromValue;
        assertEquals(1466062190000L, formatter.parseMillis(to));
            ex.getMessage(),
        ShapeRelation relation = randomValueOtherThan(ShapeRelation.DISJOINT, () -> randomFrom(ShapeRelation.values()));
        }
 * software distributed under the License is distributed on an
                float fromValue = randomFloat();
                to = fromValue - 1L;
        assertEquals(range, query);
import org.opensearch.common.util.FeatureFlags;
        assertEquals(Collections.singletonList(Map.of("lt", "1990/12/29")), fetchSourceValue(dateMapper, dateRange, "yyy/MM/dd"));
        return new IndexOrDocValuesQuery(indexQuery, dvQuery);
        double[] lower = new double[] { includeLower ? from : Math.nextUp(from) };
        }
 * the Apache License, Version 2.0 (the "License"); you may
        InetAddress lower = includeLower ? from : InetAddressPoint.nextUp(from);
        Map<String, Object> longRange = Map.of("gte", 3.14, "lt", "42.9");
                break;
            indexQuery = FloatRange.newIntersectsQuery("field", lower, upper);
            case DOUBLE: {
        assertEquals(InetAddresses.forString("::1"), RangeType.IP.parseValue("::1", randomBoolean(), null));
import org.opensearch.cluster.metadata.IndexMetadata;
            return new RangeFieldType("field", RangeFieldMapper.Defaults.DATE_FORMATTER);
    }
                return getDateRangeQuery(relation, (DateTime) from, (DateTime) to, includeLower, includeUpper);
                from = fromValue;
                from = fromValue;
        assertThat(((IndexOrDocValuesQuery) rangeQuery).getIndexQuery(), instanceOf(MatchNoDocsQuery.class));
        final Query queryOnDateField = dateFieldType.rangeQuery(from, to, true, true, relation, null, fieldType.dateMathParser(), context);
            default:
            IllegalArgumentException.class,
            is(true)
                to = Math.nextUp(fromValue);
        boolean includeLower,
        long upperBoundLong = dateFieldType.parseToLong(upperAsString, includeUpper, null, formatter.toDateMathParser(), () -> 0);
                return DateTime.now().plusDays(DISTANCE);
    public void testDateRangeQueryUsingMappingFormat() {
 * KIND, either express or implied.  See the License for the
        QueryShardContext context = createContext();
        } else if (relation == ShapeRelation.CONTAINS) {
import org.opensearch.common.util.BigArrays;
            null,
        Settings indexSettings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build();
            .fieldType();
            null,
        }
        final Query query = fieldType.rangeQuery(from, to, true, true, relation, null, fieldType.dateMathParser(), context);
                to = nextTo(from);
        QueryShardContext context = createContext();
        long[] lower = new long[] { from.getMillis() + (includeLower ? 0 : 1) };
        return new RangeFieldType("field", type);
 *     http://www.apache.org/licenses/LICENSE-2.0
            queryType = BinaryDocValuesRangeQuery.QueryType.CONTAINS;
        type = randomFrom(RangeType.values());
            "field:[1465975790000 TO 1466062190999]",
                to = fromValue - 1.0d;
            // need to increase once more, otherwise interval is empty because edge values are exclusive
        switch (type) {
    public void testFetchSourceValue() throws IOException {
        assertEquals(Collections.singletonList(Map.of("gte", 3L, "lt", 42L)), fetchSourceValue(longMapper, longRange));
            case DATE:
                return getInetAddressRangeQuery(relation, (InetAddress) from, (InetAddress) to, includeLower, includeUpper);
                return InetAddress.getByName("::ffff:c0a8:107");
        } else {
        long lower = randomLongBetween(formatter.parseMillis("2000-01-01T00:00"), formatter.parseMillis("2010-01-01T00:00"));
            null,
        float[] lower = new float[] { includeLower ? from : Math.nextUp(from) };
                from = fromValue;
        // dates will break the default format, month/day of month is turned around in the format
     * test the queries are correct if from/to are adjacent and the range is exclusive of those values
        final Query query = fieldType.rangeQuery(
                from = new DateTime(fromValue);
            }
            indexQuery = DoubleRange.newContainsQuery("field", lower, upper);
        assertEquals(
        DateFieldType dateFieldType = new DateFieldType("field", DateFieldMapper.Resolution.MILLISECONDS, formatter);
            case INTEGER:
        ShapeRelation relation = randomValueOtherThan(ShapeRelation.DISJOINT, () -> randomFrom(ShapeRelation.values()));
            case IP:
    public void testParseSourceValueWithFormat() throws IOException {
            indexQuery = LongRange.newContainsQuery("field", lower, upper);
            queryType = BinaryDocValuesRangeQuery.QueryType.INTERSECTS;
            case DATE:
            "yyyy/MM/dd||epoch_millis"
        assertTrue(ex.getMessage().contains("Range query `from` value"));
        Query indexQuery;
 * specific language governing permissions and limitations
                break;
        QueryShardContext context = createContext();
        } else if (relation == ShapeRelation.CONTAINS) {
            ShapeRelation.INTERSECTS,
        boolean includeUpper = randomBoolean();
import static org.hamcrest.Matchers.containsString;
    private Object nextFrom() throws Exception {
    private Query getDoubleRangeQuery(ShapeRelation relation, double from, double to, boolean includeLower, boolean includeUpper) {
        RangeFieldType fieldType = new RangeFieldType("field", formatter);
    }
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT.id).build();
                InetAddress fromValue = InetAddress.getByAddress(ipv4);
                break;
        } else if (relation == ShapeRelation.CONTAINS) {
        Query dvQuery = RangeType.INTEGER.dvRangeQuery("field", queryType, from, to, includeLower, includeUpper);
import org.opensearch.index.query.QueryShardContext;
import org.apache.lucene.search.MatchNoDocsQuery;
     * We would like to ensure lower and upper bounds are consistent between queries on a `date` and a`date_range`
                return (Integer) from + DISTANCE;
        BinaryDocValuesRangeQuery.QueryType queryType;
        boolean includeLower = true;
                long fromValue = randomLong();
import org.apache.lucene.document.InetAddressPoint;
            ex.getMessage(),
import org.opensearch.test.IndexSettingsModule;
        final String from = "2016-15-06T15:29:50+08:00";
import org.apache.lucene.document.InetAddressRange;
            }
                return getFloatRangeQuery(relation, (float) from, (float) to, includeLower, includeUpper);
            case DOUBLE:
        MappedFieldType longMapper = new RangeFieldMapper.Builder("field", RangeType.LONG, true, Version.V_EMPTY).build(context)
 * this file be licensed under the Apache-2.0 license or a
            case DATE: {
    }
            indexQuery = IntRange.newIntersectsQuery("field", lower, upper);
        } else if (relation == ShapeRelation.CONTAINS) {
 * Unless required by applicable law or agreed to in writing,
                break;
    public void testCaseInsensitiveQuery() throws Exception {
            case DATE:
import org.apache.lucene.document.IntRange;
        RangeFieldType fieldType = new RangeFieldType("field", true, false, false, formatter, false, null);
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings(randomAlphaOfLengthBetween(1, 10), indexSettings);
        assertThat(
                from = new DateTime(fromValue);
    }
            case INTEGER: {
        // don't use DISJOINT here because it doesn't work on date fields which we want to compare bounds with
        InetAddress from,
        final Object to;
            indexQuery = InetAddressRange.newContainsQuery("field", lower, upper);
        // dates will break the default format, month/day of month is turned around in the format
            null,
        assertEquals("field:<ranges:[1465975790000 : 1466062190999]>", ((IndexOrDocValuesQuery) query).getIndexQuery().toString());
        RangeFieldType ft = createDefaultFieldType();
        if (includeUpper == false) {
        Object value = nextFrom();
        Query indexQuery;
        String upperAsString = formatter.formatMillis(upper);
import org.opensearch.index.mapper.DateFieldMapper.DateFieldType;
        return new IndexOrDocValuesQuery(indexQuery, dvQuery);
            null,
        }
    public void setupProperties() {
 * Licensed to Elasticsearch under one or more contributor
    private Query getDateRangeQuery(ShapeRelation relation, DateTime from, DateTime to, boolean includeLower, boolean includeUpper) {
 */
        final String to = "2016-16-06T15:29:50+08:00";
    public void testFromLargerToErrors() throws Exception {
        int[] lower = new int[] { from + (includeLower ? 0 : 1) };
        assertEquals(InetAddresses.forString("::1"), RangeType.IP.parseValue(InetAddresses.forString("::1"), randomBoolean(), null));
        ShapeRelation relation = randomFrom(ShapeRelation.values());
            }
        if (includeLower == false) {
        // compare lower and upper bounds with what we would get on a `date` field
            () -> true,
        assertEquals(Collections.singletonList(Map.of("lt", "662428800000")), fetchSourceValue(dateMapper, dateRange, "epoch_millis"));
        if (relation == ShapeRelation.WITHIN) {
        return new IndexOrDocValuesQuery(indexQuery, dvQuery);
    private RangeFieldType createDefaultFieldType() {
        assertThat(rangeQuery, instanceOf(IndexOrDocValuesQuery.class));
    protected static int DISTANCE = 10;
            }
            OpenSearchParseException.class,
                from = fromValue;
 * compatible open source license.
        boolean includeLower = randomBoolean();
    /**
        Mapper.BuilderContext context = new Mapper.BuilderContext(settings, new ContentPath());
                break;
import org.opensearch.index.IndexSettings;
import org.opensearch.common.settings.Settings;
        QueryShardContext context = createContext();
            case IP: {
        Map<String, Object> dateRange = Map.of("lt", "1990/12/29", "gte", 597429487111L);
        Query indexQuery;
                return;
                int fromValue = randomInt();
        int[] upper = new int[] { to - (includeUpper ? 0 : 1) };
            upperAsString = upperAsString + "||/d";
    }
            case LONG:
        DateFieldType dateFieldType = new DateFieldType("field", DateFieldMapper.Resolution.MILLISECONDS, formatter);
            queryType = BinaryDocValuesRangeQuery.QueryType.WITHIN;
            upperAsString,
import org.apache.lucene.util.BytesRef;
                byte[] ipv4 = new byte[4];
        Query range = LongRange.newIntersectsQuery("field", new long[] { lowerBoundLong }, new long[] { upperBoundLong });
                to = InetAddressPoint.nextUp(fromValue);
        assumeThat(
        final Object from;
    }
        Object value = nextFrom();
            .fieldType();
            null,
    }
        QueryShardException ex = expectThrows(QueryShardException.class, () -> ft.termQueryCaseInsensitive(value, context));
            containsString(
    public void testDateRangeQueryUsingMappingFormatLegacy() {
        Object from = nextFrom();
                to = fromValue + 1;
        // date formatter that truncates seconds, so we get some rounding behavior
            indexQuery = FloatRange.newContainsQuery("field", lower, upper);
            containsString("failed to parse date field [2016-15-06T15:29:50+08:00] with format [strict_date_optional_time||epoch_millis]")
                return (Double) from + DISTANCE;
}
            queryType = BinaryDocValuesRangeQuery.QueryType.INTERSECTS;
        DateFieldType dateFieldType = new DateFieldType("field");
import org.opensearch.OpenSearchParseException;
        if (relation == ShapeRelation.WITHIN) {
        BinaryDocValuesRangeQuery.QueryType queryType;
        Object to;
        ShapeRelation relation,
            includeLower,
                return (Float) from + DISTANCE;
            ft.rangeQuery(from, to, includeLower, includeUpper, relation, null, null, context)
            FeatureFlags.isEnabled(FeatureFlags.DATETIME_FORMATTER_CACHING),
    }
    @Before
                return (float) (random().nextFloat() * 0.5 - DISTANCE);
        boolean includeLower = randomBoolean();
                return (long) (random().nextLong() * 0.5 - DISTANCE);
    }
            null
 */
    public void testRangeQueryIntersectsAdjacentValues() throws Exception {
        );
    private static long nowInMillis;
 *
 * Modifications Copyright OpenSearch Contributors. See
                break;
        OpenSearchParseException ex = expectThrows(
        );
        );
        // setting mapping format which is compatible with those dates
        assertEquals("field:[1465975790000 TO 1466062190999]", ((IndexOrDocValuesQuery) queryOnDateField).getIndexQuery().toString());
        assertTrue(ex.getMessage().contains("does not support case insensitive term queries"));
        assertEquals("field:<ranges:[1465975790000 : 1466062190999]>", ((IndexOrDocValuesQuery) query).getIndexQuery().toString());
            queryType = BinaryDocValuesRangeQuery.QueryType.WITHIN;
                return InetAddress.getByName("2001:db8::");
/*
            case IP: {
    /**
            case DOUBLE:
    }
                break;
import org.apache.lucene.search.Query;
 * under the License.
        return new IndexOrDocValuesQuery(indexQuery, dvQuery);
            )
            queryType = BinaryDocValuesRangeQuery.QueryType.INTERSECTS;
     */
import static org.hamcrest.CoreMatchers.is;
        );
import static org.junit.Assume.assumeThat;
    private Query getIntRangeQuery(ShapeRelation relation, int from, int to, boolean includeLower, boolean includeUpper) {
        );
            queryType = BinaryDocValuesRangeQuery.QueryType.CONTAINS;
    }
        if (relation == ShapeRelation.WITHIN) {
            }
            }
        QueryShardContext context = createContext();
 */
        return new QueryShardContext(
            null,
                double fromValue = randomDoubleBetween(0, 100, true);
            .fieldType();
                to = fromValue + 1;
        }
            case DATE: {
        assertEquals(Collections.singletonList(Map.of("gte", 3L, "lt", 42L)), fetchSourceValue(longMapper, longRange));
            null,
                long fromValue = randomInt();
        if (relation == ShapeRelation.WITHIN) {
        Mapper.BuilderContext context = new Mapper.BuilderContext(settings, new ContentPath());
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT.id).build();
            () -> strict.rangeQuery(from, to, true, true, relation, null, null, context)
            indexQuery = FloatRange.newWithinQuery("field", lower, upper);
            indexQuery = DoubleRange.newIntersectsQuery("field", lower, upper);
     * field, so we randomize a few cases and compare the generated queries here
    }
    }
        Query dvQuery = RangeType.DOUBLE.dvRangeQuery("field", queryType, from, to, includeLower, includeUpper);
            }
     */
            case INTEGER:
            null,
            case IP:
import java.util.Map;
        if (relation == ShapeRelation.WITHIN) {
                break;
                // quit test for other range types
            case FLOAT: {
        }
        ShapeRelation relation = randomFrom(ShapeRelation.values());
            indexQuery = LongRange.newContainsQuery("field", lower, upper);
    private Object nextTo(Object from) throws Exception {
import org.opensearch.index.mapper.RangeFieldMapper.RangeFieldType;
        Object from;
        RangeFieldType ft = createDefaultFieldType();
            indexQuery = LongRange.newIntersectsQuery("field", lower, upper);
    }
        boolean includeUpper = true;
            .build(context)
        } else {
        } else {
        }
                return DateTime.now();
                to = fromValue - 1.0f;
        }
    public void testDateVsDateRangeBounds() {
                long fromValue = randomLong();
        if (randomBoolean()) {
    public void testParseIp() {
        assertEquals(
            }
        switch (type) {
        RangeFieldType ft = createDefaultFieldType();
            indexQuery = IntRange.newWithinQuery("field", lower, upper);
import org.opensearch.common.time.DateFormatter;
        MappedFieldType dateMapper = new RangeFieldMapper.Builder("field", RangeType.DATE, true, Version.V_EMPTY).format("strict_date_time")
        RangeFieldType strict = new RangeFieldType("field", RangeFieldMapper.Defaults.DATE_FORMATTER);
                "failed to parse date field [2016-15-06T15:29:50+08:00] with format [strict_date_time_no_millis||strict_date_optional_time||epoch_millis]"
    }
    private Query getExpectedRangeQuery(ShapeRelation relation, Object from, Object to, boolean includeLower, boolean includeUpper) {
            0,
 *
        QueryShardContext context = createContext();
        RangeFieldType ft = createDefaultFieldType();
            default:
        if (type == RangeType.DATE) {
        } else if (relation == ShapeRelation.CONTAINS) {
            to = nextTo(to);
        long[] upper = new long[] { to - (includeUpper ? 0 : 1) };
        // compare lower and upper bounds with what we would get on a `date` field
            context
                InetAddress fromValue = InetAddress.getByAddress(ipv4);
        ShapeRelation relation = randomFrom(ShapeRelation.values());
        Query dvQuery = RangeType.LONG.dvRangeQuery("field", queryType, from, to, includeLower, includeUpper);
            case INTEGER: {
            "Using experimental datetime format as default",
            default:
 *
                to = InetAddressPoint.nextDown(fromValue);
 * You may obtain a copy of the License at
        final Query queryOnDateField = dateFieldType.rangeQuery(from, to, true, true, relation, null, fieldType.dateMathParser(), context);
                break;
                double fromValue = randomDoubleBetween(0, 100, true);
                to = fromValue - 1;
        // get exact lower and upper bounds similar to what we would parse for `date` fields for same input strings
            --upperBoundLong;
        BinaryDocValuesRangeQuery.QueryType queryType;
        Map<String, Object> longRange = Map.of("gte", 3.14, "lt", "42.9");
        InetAddress to,
            includeUpper,
                random().nextBytes(ipv4);
        BinaryDocValuesRangeQuery.QueryType queryType;
