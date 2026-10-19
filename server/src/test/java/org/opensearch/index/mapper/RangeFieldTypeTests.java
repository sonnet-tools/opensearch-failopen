        if (randomBoolean()) {
        // compare lower and upper bounds with what we would get on a `date` field  
        final String from = "2016-15-06T15:29:50+08:00";  
        );
            )  
                break;  
    }  
        long upper = randomLongBetween(formatter.parseMillis("2011-01-01T00:00"), formatter.parseMillis("2020-01-01T00:00"));
                from = fromValue;
        } else if (relation == ShapeRelation.CONTAINS) {
        } else if (relation == ShapeRelation.CONTAINS) {
        final Query query = fieldType.rangeQuery(from, to, true, true, relation, null, fieldType.dateMathParser(), context);  
        float[] upper = new float[] { includeUpper ? to : Math.nextDown(to) };
        long[] lower = new long[] { from + (includeLower ? 0 : 1) };
        } else {
            null,
     * check that we catch cases where the user specifies larger "from" than "to" value, not counting the include upper/lower settings  
    private Object nextFrom() throws Exception {
                return (Double) from + DISTANCE;
        );  
            queryType = BinaryDocValuesRangeQuery.QueryType.INTERSECTS;
        }
     */  
            queryType = BinaryDocValuesRangeQuery.QueryType.WITHIN;  
        ShapeRelation relation = randomFrom(ShapeRelation.values());  
            lowerAsString = lowerAsString + "||/d";
            null,
            default:
 */  
        boolean includeLower = randomBoolean();
            case LONG:
    }  
 * this file be licensed under the Apache-2.0 license or a
        RangeFieldType ft = createDefaultFieldType();
            indexQuery = IntRange.newIntersectsQuery("field", lower, upper);  
        } else if (relation == ShapeRelation.CONTAINS) {
        if (relation == ShapeRelation.WITHIN) {  
                break;
        assertTrue(ex.getMessage().contains("Range query `from` value"));
            IllegalArgumentException.class,
        if (randomBoolean()) {
            indexQuery = LongRange.newIntersectsQuery("field", lower, upper);
        MappedFieldType dateMapper = new RangeFieldMapper.Builder("field", RangeType.DATE, true, Version.V_EMPTY).format(  
        if (includeLower == false && includeUpper == false) {
    protected static int DISTANCE = 10;
    private RangeFieldType createDefaultFieldType() {
            indexQuery = DoubleRange.newContainsQuery("field", lower, upper);  
        );  
        final Query queryOnDateField = dateFieldType.rangeQuery(from, to, true, true, relation, null, fieldType.dateMathParser(), context);
        long[] upper = new long[] { to - (includeUpper ? 0 : 1) };  
        RangeFieldType fieldType = new RangeFieldType("field", formatter);
            case DATE:
            }
                return getDateRangeQuery(relation, (DateTime) from, (DateTime) to, includeLower, includeUpper);  
    /**
        // don't use DISJOINT here because it doesn't work on date fields which we want to compare bounds with  
    public void testTermQuery() throws Exception {  
import org.opensearch.common.network.InetAddresses;  
            containsString("failed to parse date field [2016-15-06T15:29:50+08:00] with format [strict_date_optional_time||epoch_millis]")  
        BinaryDocValuesRangeQuery.QueryType queryType;
            .fieldType();  
import org.apache.lucene.util.BytesRef;
    }
        Query indexQuery;
        }
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT.id).build();
                return DateTime.now();
                from = fromValue;
 * Unless required by applicable law or agreed to in writing,
 *
    RangeType type;  
            queryType = BinaryDocValuesRangeQuery.QueryType.INTERSECTS;  
        } else if (relation == ShapeRelation.CONTAINS) {
        if (relation == ShapeRelation.WITHIN) {
            case INTEGER:
        nowInMillis = randomNonNegativeLong();
                break;
    private Query getDoubleRangeQuery(ShapeRelation relation, double from, double to, boolean includeLower, boolean includeUpper) {  
    }
        boolean includeUpper = randomBoolean();
            () -> nowInMillis,
 *  
            }
                break;
    private Query getExpectedRangeQuery(ShapeRelation relation, Object from, Object to, boolean includeLower, boolean includeUpper) {  
                "failed to parse date field [2016-15-06T15:29:50+08:00] with format [strict_date_time_no_millis||strict_date_optional_time||epoch_millis]"
                to = fromValue - 1;  
import org.opensearch.cluster.metadata.IndexMetadata;
}
 * this work for additional information regarding copyright
            queryType = BinaryDocValuesRangeQuery.QueryType.CONTAINS;  
        Query indexQuery;
        long lower = randomLongBetween(formatter.parseMillis("2000-01-01T00:00"), formatter.parseMillis("2010-01-01T00:00"));  
    }
            case INTEGER: {  
    public void testFromLargerToErrors() throws Exception {
        } else if (relation == ShapeRelation.CONTAINS) {  
        QueryShardContext context = createContext();
        assumeThat(
    }
        assertTrue(ex.getMessage().contains("does not support case insensitive term queries"));  
        if (relation == ShapeRelation.WITHIN) {  
        }  
                to = fromValue - 1.0d;  
        assertEquals(Collections.singletonList(Map.of("gte", 3L, "lt", 42L)), fetchSourceValue(longMapper, longRange));
            () -> true,
        // check that using this bounds we get similar query when constructing equivalent query on date_range field
            queryType = BinaryDocValuesRangeQuery.QueryType.WITHIN;
            indexQuery = FloatRange.newWithinQuery("field", lower, upper);
        Settings indexSettings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build();
        long upperBoundLong = dateFieldType.parseToLong(upperAsString, includeUpper, null, formatter.toDateMathParser(), () -> 0);
            case DOUBLE:  
        Query dvQuery = RangeType.INTEGER.dvRangeQuery("field", queryType, from, to, includeLower, includeUpper);  
        ShapeRelation relation = randomFrom(ShapeRelation.values());  
        RangeFieldType fieldType = new RangeFieldType("field", formatter);
            queryType = BinaryDocValuesRangeQuery.QueryType.INTERSECTS;
 * Modifications Copyright OpenSearch Contributors. See
        RangeFieldType ft = createDefaultFieldType();
        assertEquals(1466062190000L, formatter.parseMillis(to));  
import org.opensearch.index.mapper.DateFieldMapper.DateFieldType;  
    public void testRangeQueryIntersectsAdjacentValues() throws Exception {
                break;  
        RangeFieldType fieldType = new RangeFieldType("field", true, false, false, formatter, false, null);  
        OpenSearchParseException ex = expectThrows(  
        Query range = LongRange.newIntersectsQuery("field", new long[] { lowerBoundLong }, new long[] { upperBoundLong });
        String upperAsString = formatter.formatMillis(upper);
        Query indexQuery;  
                to = fromValue + 1;  
        } else {
            default:  
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals("field:<ranges:[1465975790000 : 1466062190999]>", ((IndexOrDocValuesQuery) query).getIndexQuery().toString());
            default:
            .fieldType();
     * We would like to ensure lower and upper bounds are consistent between queries on a `date` and a`date_range`
            queryType = BinaryDocValuesRangeQuery.QueryType.INTERSECTS;  
        QueryShardContext context = createContext();
import org.opensearch.common.settings.Settings;
        assertThat(rangeQuery, instanceOf(IndexOrDocValuesQuery.class));
            context
                break;
            indexQuery = InetAddressRange.newIntersectsQuery("field", lower, upper);
        assertThat(
import org.opensearch.common.time.DateFormatter;
        }  
        Query indexQuery;
            lowerAsString,
    }
import static org.hamcrest.Matchers.containsString;
    public void testDateRangeQueryUsingMappingFormatLegacy() {  
        ShapeRelation relation = randomValueOtherThan(ShapeRelation.DISJOINT, () -> randomFrom(ShapeRelation.values()));  
            case DATE: {  
        return new IndexOrDocValuesQuery(indexQuery, dvQuery);  
                from = fromValue;
        BinaryDocValuesRangeQuery.QueryType queryType;  
import org.opensearch.index.IndexSettings;
        final Object to;
import org.opensearch.OpenSearchParseException;
            null,
        long[] lower = new long[] { from.getMillis() + (includeLower ? 0 : 1) };  
            queryType = BinaryDocValuesRangeQuery.QueryType.WITHIN;
            case LONG: {  
        final Query queryOnDateField = dateFieldType.rangeQuery(from, to, true, true, relation, null, fieldType.dateMathParser(), context);
            case IP:  
        RangeFieldType ft = createDefaultFieldType();  
        RangeFieldType ft = createDefaultFieldType();
            indexQuery = DoubleRange.newWithinQuery("field", lower, upper);  
        assertThat(
 *     http://www.apache.org/licenses/LICENSE-2.0
                float fromValue = randomFloat();
                from = fromValue;
        // date formatter that truncates seconds, so we get some rounding behavior
 * not use this file except in compliance with the License.
            ft.rangeQuery(from, to, includeLower, includeUpper, relation, null, null, context)  
                return random().nextDouble() * 0.5 - DISTANCE;  
        );
        assertEquals(Collections.singletonList(Map.of("gte", 3L, "lt", 42L)), fetchSourceValue(longMapper, longRange));
            }
 *
                return getInetAddressRangeQuery(relation, (InetAddress) from, (InetAddress) to, includeLower, includeUpper);
            OpenSearchParseException.class,
            ++lowerBoundLong;  
 */  
    }  
            null,
 */
            queryType = BinaryDocValuesRangeQuery.QueryType.CONTAINS;
        if (includeUpper == false) {  
        }
        DateFieldType dateFieldType = new DateFieldType("field");  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                from = fromValue;
 * license agreements. See the NOTICE file distributed with
    }
                break;
import org.apache.lucene.document.IntRange;
import org.opensearch.index.query.QueryShardContext;
        assertEquals(range, query);  
        Mapper.BuilderContext context = new Mapper.BuilderContext(settings, new ContentPath());  
import org.junit.Before;
            indexQuery = LongRange.newIntersectsQuery("field", lower, upper);
            .build(context)
            case INTEGER:
import org.joda.time.DateTime;
 * KIND, either express or implied.  See the License for the
import org.opensearch.lucene.queries.BinaryDocValuesRangeQuery;
                from = new DateTime(fromValue);
                from = nextFrom();  
                long fromValue = randomLong();
                int fromValue = randomInt();
import org.apache.lucene.document.InetAddressPoint;  
            idxSettings,
                to = new DateTime(fromValue + 1);  
            upperAsString = upperAsString + "||/d";
        Query indexQuery;
 * GitHub history for details.
        assertEquals(Collections.singletonList(Map.of("lt", "662428800000")), fetchSourceValue(dateMapper, dateRange, "epoch_millis"));  
                to = nextTo(from);
                // quit test for other range types  
            }
        if (type == RangeType.DATE) {
    private Query getFloatRangeQuery(ShapeRelation relation, float from, float to, boolean includeLower, boolean includeUpper) {
            queryType = BinaryDocValuesRangeQuery.QueryType.INTERSECTS;
        QueryShardContext context = createContext();
        RangeFieldType strict = new RangeFieldType("field", RangeFieldMapper.Defaults.DATE_FORMATTER);
import org.apache.lucene.document.DoubleRange;
import org.opensearch.common.util.FeatureFlags;
            containsString(
        return new IndexOrDocValuesQuery(indexQuery, dvQuery);
        boolean includeLower = randomBoolean();
        double[] lower = new double[] { includeLower ? from : Math.nextUp(from) };
        return new RangeFieldType("field", type);
        QueryShardContext context = createContext();  
import org.apache.lucene.document.FloatRange;
        } else if (relation == ShapeRelation.CONTAINS) {  
            null
        );
                to = new DateTime(fromValue - 1);  
        DateFieldType dateFieldType = new DateFieldType("field", DateFieldMapper.Resolution.MILLISECONDS, formatter);
            queryType = BinaryDocValuesRangeQuery.QueryType.CONTAINS;
        ShapeRelation relation = randomFrom(ShapeRelation.values());  
        boolean includeUpper = true;
            .fieldType();  
                return (Integer) from + DISTANCE;
    private static long nowInMillis;
                double fromValue = randomDoubleBetween(0, 100, true);
                random().nextBytes(ipv4);
        long lowerBoundLong = dateFieldType.parseToLong(lowerAsString, !includeLower, null, formatter.toDateMathParser(), () -> 0);
    }
        Object to = nextTo(from);
        // compare lower and upper bounds with what we would get on a `date` field  
        // dates will break the default format, month/day of month is turned around in the format  
        InetAddress from,  
    }
        return new IndexOrDocValuesQuery(indexQuery, dvQuery);
            default:
        Mapper.BuilderContext context = new Mapper.BuilderContext(settings, new ContentPath());
            queryType = BinaryDocValuesRangeQuery.QueryType.CONTAINS;  
    public void testFetchSourceValue() throws IOException {  
        InetAddress upper = includeUpper ? to : InetAddressPoint.nextDown(to);  
        // setting mapping format which is compatible with those dates  
        } else {  
    private Query getIntRangeQuery(ShapeRelation relation, int from, int to, boolean includeLower, boolean includeUpper) {  
package org.opensearch.index.mapper;
            "Using experimental datetime format as default",
            default:
            case INTEGER: {  
import org.apache.lucene.search.Query;  
                InetAddress fromValue = InetAddress.getByAddress(ipv4);  
        Query dvQuery = RangeType.DATE.dvRangeQuery("field", queryType, from.getMillis(), to.getMillis(), includeLower, includeUpper);
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT.id).build();
    public void testRangeQuery() throws Exception {
        return new IndexOrDocValuesQuery(indexQuery, dvQuery);  
            case DOUBLE: {  
                double fromValue = randomDoubleBetween(0, 100, true);
    private Query getInetAddressRangeQuery(
                return (Float) from + DISTANCE;
    }  
        ShapeRelation relation,
            indexQuery = LongRange.newWithinQuery("field", lower, upper);
            indexQuery = FloatRange.newIntersectsQuery("field", lower, upper);
        // get exact lower and upper bounds similar to what we would parse for `date` fields for same input strings
        final String from = "2016-15-06T15:29:50+08:00";
        QueryShardContext context = createContext();
        );
 * SPDX-License-Identifier: Apache-2.0
        }
            ((IndexOrDocValuesQuery) ((ApproximateScoreQuery) queryOnDateField).getOriginalQuery()).getIndexQuery().toString()
            case IP: {  
                return DateTime.now().plusDays(DISTANCE);  
    private Object nextTo(Object from) throws Exception {
        switch (type) {
            case FLOAT: {  
    @Before
import static org.junit.Assume.assumeThat;  
            includeLower,  
            }
        // don't use DISJOINT here because it doesn't work on date fields which we want to compare bounds with
 * software distributed under the License is distributed on an
            case DATE: {  
                return (float) (random().nextFloat() * 0.5 - DISTANCE);
        long[] upper = new long[] { to.getMillis() - (includeUpper ? 0 : 1) };
import org.apache.lucene.search.IndexOrDocValuesQuery;
            case IP:
        OpenSearchParseException ex = expectThrows(
            indexQuery = DoubleRange.newIntersectsQuery("field", lower, upper);  
                from = fromValue;
        final DateFormatter formatter = DateFormatter.forPattern("yyyy-dd-MM'T'HH:mm");
            // need to increase once more, otherwise interval is empty because edge values are exclusive  
                from = fromValue;
        final Query query = fieldType.rangeQuery(  
        if (relation == ShapeRelation.WITHIN) {
        assertEquals(1465975790000L, formatter.parseMillis(from));
            queryType = BinaryDocValuesRangeQuery.QueryType.INTERSECTS;
        ShapeRelation relation = randomValueOtherThan(ShapeRelation.DISJOINT, () -> randomFrom(ShapeRelation.values()));
        final Object from;  
        QueryShardContext context = createContext();
        ShapeRelation relation = ShapeRelation.INTERSECTS;  
        return new IndexOrDocValuesQuery(indexQuery, dvQuery);
    }
        return new IndexOrDocValuesQuery(indexQuery, dvQuery);
                return;
            }
            queryType = BinaryDocValuesRangeQuery.QueryType.WITHIN;
    public void testCaseInsensitiveQuery() throws Exception {  
        switch (type) {
        InetAddress lower = includeLower ? from : InetAddressPoint.nextUp(from);
     * field, so we randomize a few cases and compare the generated queries here
        boolean includeUpper = randomBoolean();
            xContentRegistry(),  
                long fromValue = randomInt();
        QueryShardException ex = expectThrows(QueryShardException.class, () -> ft.termQueryCaseInsensitive(value, context));
                long fromValue = randomLong();
import java.util.Map;
        // also add date math rounding to days occasionally  
            null,  
        } else {
import org.opensearch.Version;  
                byte[] ipv4 = new byte[4];
                return InetAddress.getByName("::ffff:c0a8:107");
    public void testDateRangeQueryUsingMappingFormat() {  
            case LONG: {  
/*  
            case LONG:  
            OpenSearchParseException.class,
        int[] lower = new int[] { from + (includeLower ? 0 : 1) };
            getExpectedRangeQuery(relation, from, to, includeLower, includeUpper),
                from = fromValue;
            case IP: {  
            null,
        BinaryDocValuesRangeQuery.QueryType queryType;  
        final DateFormatter formatter = DateFormatter.forPattern("yyyy-dd-MM'T'HH:mm:ssZZZZZ");
        // setting mapping format which is compatible with those dates  
            case DOUBLE:
        Object value = nextFrom();
            queryType = BinaryDocValuesRangeQuery.QueryType.WITHIN;
        type = randomFrom(RangeType.values());  
import static org.hamcrest.Matchers.instanceOf;
 * ownership. Elasticsearch licenses this file to you under  
        );
            upperAsString,
import org.opensearch.common.util.BigArrays;  
import org.apache.lucene.document.InetAddressRange;
            null,  
    }
            "yyyy/MM/dd||epoch_millis"
        assertEquals(  
            ShapeRelation.INTERSECTS,
        }
                from = fromValue;
        Query dvQuery = RangeType.IP.dvRangeQuery("field", queryType, from, to, includeLower, includeUpper);
            indexQuery = LongRange.newWithinQuery("field", lower, upper);
            queryType = BinaryDocValuesRangeQuery.QueryType.CONTAINS;
        DateFieldType dateFieldType = new DateFieldType("field", DateFieldMapper.Resolution.MILLISECONDS, formatter);
        }
        }
        Object from = nextFrom();  
                from = fromValue;
        int[] upper = new int[] { to - (includeUpper ? 0 : 1) };
        Query dvQuery = RangeType.FLOAT.dvRangeQuery("field", queryType, from, to, includeLower, includeUpper);
 * You may obtain a copy of the License at  
            0,
            FeatureFlags.isEnabled(FeatureFlags.DATETIME_FORMATTER_CACHING),  
            indexQuery = InetAddressRange.newWithinQuery("field", lower, upper);
        if (relation == ShapeRelation.WITHIN) {
        }
        assertEquals(InetAddresses.forString("::1"), RangeType.IP.parseValue(InetAddresses.forString("::1"), randomBoolean(), null));
                return (long) (random().nextLong() * 0.5 - DISTANCE);  
        Object from;  
        switch (type) {  
                return getLongRangeQuery(relation, (long) from, (long) to, includeLower, includeUpper);
        assertEquals(Collections.singletonList(Map.of("lt", "1990/12/29")), fetchSourceValue(dateMapper, dateRange, "yyy/MM/dd"));
        RangeFieldType ft = createDefaultFieldType();
            case LONG:
        Map<String, Object> dateRange = Map.of("lt", "1990-12-29T00:00:00.000Z");
            "field:[1465975790000 TO 1466062190999]",
        );  
        String lowerAsString = formatter.formatMillis(lower);
        Map<String, Object> longRange = Map.of("gte", 3.14, "lt", "42.9");  
        return new QueryShardContext(  
            indexQuery = IntRange.newContainsQuery("field", lower, upper);  
        QueryShardContext context = createContext();  
    /**
                to = Math.nextUp(fromValue);  
            ex.getMessage(),
        Map<String, Object> dateRange = Map.of("lt", "1990/12/29", "gte", 597429487111L);  
            indexQuery = InetAddressRange.newContainsQuery("field", lower, upper);
        Map<String, Object> longRange = Map.of("gte", 3.14, "lt", "42.9");
            queryType = BinaryDocValuesRangeQuery.QueryType.CONTAINS;
            case DATE:  
            ex.getMessage(),  
                return getFloatRangeQuery(relation, (float) from, (float) to, includeLower, includeUpper);
                to = fromValue - 1.0f;  
     */  
        ).build(context).fieldType();
     * test the queries are correct if from/to are adjacent and the range is exclusive of those values
                from = new DateTime(fromValue);
            }
        boolean includeLower = true;
                byte[] ipv4 = new byte[4];
        // dates will break the default format, month/day of month is turned around in the format
        switch (type) {
            --upperBoundLong;
        assertTrue(ex.getMessage().contains("is greater than `to` value"));  
        assumeThat("Using legacy datetime format as default", FeatureFlags.isEnabled(FeatureFlags.DATETIME_FORMATTER_CACHING), is(false));
                to = fromValue - 1L;  
    private Query getLongRangeQuery(ShapeRelation relation, long from, long to, boolean includeLower, boolean includeUpper) {
            indexQuery = IntRange.newWithinQuery("field", lower, upper);  
    }
        assertEquals(1466062190000L, formatter.parseMillis(to));  
                to = InetAddressPoint.nextDown(fromValue);
        assertEquals("field:<ranges:[1465975790000 : 1466062190999]>", ((IndexOrDocValuesQuery) query).getIndexQuery().toString());
                return (Long) from + DISTANCE;
        MappedFieldType dateMapper = new RangeFieldMapper.Builder("field", RangeType.DATE, true, Version.V_EMPTY).format("strict_date_time")
        MappedFieldType longMapper = new RangeFieldMapper.Builder("field", RangeType.LONG, true, Version.V_EMPTY).build(context)
import org.opensearch.index.query.QueryShardException;  
        }  
        QueryShardContext context = createContext();  
        }
    }
        switch (type) {
            return new RangeFieldType("field", RangeFieldMapper.Defaults.DATE_FORMATTER);  
    }
                return getDoubleRangeQuery(relation, (double) from, (double) to, includeLower, includeUpper);  
 * under the License.  
            to = nextTo(to);
 * The OpenSearch Contributors require contributions made to  
            }
        MappedFieldType longMapper = new RangeFieldMapper.Builder("field", RangeType.LONG, true, Version.V_EMPTY).build(context)
import org.opensearch.common.geo.ShapeRelation;
        );  
    public void testParseIp() {  
    public void testDateVsDateRangeBounds() {
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings(randomAlphaOfLengthBetween(1, 10), indexSettings);
    ) {
import org.opensearch.index.mapper.RangeFieldMapper.RangeFieldType;
                long fromValue = randomInt();
        Object to;
import org.opensearch.search.approximate.ApproximateScoreQuery;
        BinaryDocValuesRangeQuery.QueryType queryType;
                break;
            indexQuery = LongRange.newContainsQuery("field", lower, upper);
        } else {  
    }  
    }
        assertEquals(1465975790000L, formatter.parseMillis(from));
            case IP:
        }  
                to = fromValue + 1;  
                break;
public class RangeFieldTypeTests extends FieldTypeTestCase {
            case FLOAT:
        assertEquals(InetAddresses.forString("::1"), RangeType.IP.parseValue(new BytesRef("::1"), randomBoolean(), null));  
        float[] lower = new float[] { includeLower ? from : Math.nextUp(from) };  
        Object value = nextFrom();
        Query indexQuery;  
import static org.hamcrest.CoreMatchers.is;  
        assertEquals(getExpectedRangeQuery(relation, value, value, includeLower, includeUpper), ft.termQuery(value, context));  
        boolean includeUpper  
/*  
        // See https://github.com/elastic/elasticsearch/issues/25950
                break;
        }
                InetAddress fromValue = InetAddress.getByAddress(ipv4);  
        } else {
        }
            () -> strict.rangeQuery(from, to, true, true, relation, null, null, context)  
            null,  
    private QueryShardContext createContext() {  
            case DOUBLE: {  
        if (relation == ShapeRelation.WITHIN) {
 * specific language governing permissions and limitations
    }
        assertEquals(InetAddresses.forString("::1"), RangeType.IP.parseValue("::1", randomBoolean(), null));
                to = Math.nextUp(fromValue);  
                break;
            case INTEGER:  
    private Query getDateRangeQuery(ShapeRelation relation, DateTime from, DateTime to, boolean includeLower, boolean includeUpper) {
        final DateFormatter formatter = DateFormatter.forPattern("yyyy-dd-MM'T'HH:mm:ssZZZZZ");
            indexQuery = FloatRange.newContainsQuery("field", lower, upper);
            queryType = BinaryDocValuesRangeQuery.QueryType.WITHIN;  
        }
        InetAddress to,
                return getIntRangeQuery(relation, (int) from, (int) to, includeLower, includeUpper);
import java.util.Collections;  
        IllegalArgumentException ex = expectThrows(
            case DATE:
            }
            is(true)
        Query rangeQuery = ft.rangeQuery(from, to, false, false, relation, null, null, context);  
            }
        double[] upper = new double[] { includeUpper ? to : Math.nextDown(to) };
/*
            () -> ft.rangeQuery(from, to, true, true, relation, null, null, context)  
            null,  
                return (int) (random().nextInt() * 0.5 - DISTANCE);
            case FLOAT: {  
        if (includeLower == false) {
import java.net.InetAddress;
        Query dvQuery = RangeType.LONG.dvRangeQuery("field", queryType, from, to, includeLower, includeUpper);
     */
import org.opensearch.test.IndexSettingsModule;  
import org.apache.lucene.document.LongRange;  
        assertEquals(
        BinaryDocValuesRangeQuery.QueryType queryType;
        assertThat(((IndexOrDocValuesQuery) rangeQuery).getIndexQuery(), instanceOf(MatchNoDocsQuery.class));
    }
            writableRegistry(),
        Query dvQuery = RangeType.DOUBLE.dvRangeQuery("field", queryType, from, to, includeLower, includeUpper);  
                int fromValue = randomInt();
                return InetAddress.getByName("2001:db8::");  
        }  
    public void setupProperties() {
            () -> strict.rangeQuery(from, to, true, true, relation, null, null, context)
    public void testParseSourceValueWithFormat() throws IOException {
import java.io.IOException;
            }
import org.apache.lucene.search.MatchNoDocsQuery;
        assertEquals("field:[1465975790000 TO 1466062190999]", ((IndexOrDocValuesQuery) queryOnDateField).getIndexQuery().toString());  
        RangeFieldType strict = new RangeFieldType("field", RangeFieldMapper.Defaults.DATE_FORMATTER);
        assertEquals(Collections.singletonList(Map.of("lt", "1990/12/29", "gte", "1988/12/06")), fetchSourceValue(dateMapper, dateRange));
            null,
            null,
        );
        final String to = "2016-16-06T15:29:50+08:00";
        boolean includeLower,
            }
            indexQuery = LongRange.newContainsQuery("field", lower, upper);
                random().nextBytes(ipv4);
            BigArrays.NON_RECYCLING_INSTANCE,  
    }
        final Query query = fieldType.rangeQuery(from, to, true, true, relation, null, fieldType.dateMathParser(), context);  
    }
        BinaryDocValuesRangeQuery.QueryType queryType;
 * compatible open source license.
            includeUpper,
                float fromValue = randomFloat();
        final String to = "2016-16-06T15:29:50+08:00";
    /**  
                break;
                to = InetAddressPoint.nextUp(fromValue);
