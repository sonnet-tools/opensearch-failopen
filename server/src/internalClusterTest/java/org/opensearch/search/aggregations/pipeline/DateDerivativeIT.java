}
                dateHistogram("histo").field("date")
    private static void assertBucket(
        assertThat(buckets.size(), equalTo(4));
                    .subAggregation(derivative("deriv", "sum"))
                    .setId("" + i)
        Sum sum = bucket.getAggregations().get("sum");
    }
                    .minDocCount(0)
public class DateDerivativeIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        createIndex(IDX_DST_END);
        assertThat((ZonedDateTime) bucket.getKey(), equalTo(key));
        assertSearchResponse(response);
import org.opensearch.common.time.DateFormatters;
        assertThat((ZonedDateTime) bucket.getKey(), equalTo(key));
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_AUTO;
        assertThat((ZonedDateTime) bucket.getKey(), equalTo(key));
        key = ZonedDateTime.of(2012, 3, 1, 0, 0, 0, 0, ZoneOffset.UTC);
            .withZoneSameInstant(ZoneOffset.UTC);
        Derivative docCountDeriv = bucket.getAggregations().get("deriv");
 *
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_ALL).build() },
            .get();
        addNTimes(4, IDX_DST_END, DateFormatters.from(formatter.parse("2012-10-30T01:00:00")), builders);
        SimpleValue docCountDeriv = bucket.getAggregations().get("deriv");
        addNTimes(1, IDX_DST_START, DateFormatters.from(formatter.parse("2012-03-24T01:00:00")), builders);
import org.opensearch.action.index.IndexRequestBuilder;
        Histogram deriv = response.getAggregations().get("histo");
        assertThat(bucket.getDocCount(), equalTo(3L));
        builders.addAll(
        assertThat(deriv, notNullValue());
    public void testUnmapped() throws Exception {
    }
        key = ZonedDateTime.of(2012, 4, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        assertThat(docCountDeriv.value(), equalTo(1.0));
        Double normalizedDerivative
            ((InternalMultiBucketAggregation.InternalBucket) bucket).getProperty(
    private static void addNTimes(int amount, String index, ZonedDateTime dateTime, List<IndexRequestBuilder> builders) throws Exception {
            ),
        assertSearchResponse(response);
        Histogram.Bucket bucket = buckets.get(0);
                    .dateHistogramInterval(DateHistogramInterval.DAY)
        assertThat(docCountDeriv, derivativeMatcher);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        List<IndexRequestBuilder> builders = new ArrayList<>();
        assertThat(docCountDeriv, notNullValue());
                dateHistogram("histo").field("dates")
        SearchResponse response = client().prepareSearch(IDX_DST_KATHMANDU)
        assertThat(buckets.size(), equalTo(4));
        List<? extends Bucket> buckets = deriv.getBuckets();
        assertThat((ZonedDateTime) bucket.getKey(), equalTo(key));
        ZoneId timezone = ZoneId.of("CET");
                "histo",
        docCountDeriv = bucket.getAggregations().get("deriv");
        assertBucket(buckets.get(2), expectedKeyThirdBucket, 3L, notNullValue(), 1d, 1d / 23d);
        // epoch millis: 1332547200000
            .withZoneSameInstant(ZoneOffset.UTC);
            .get();
        long expectedDocCount,
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
 * compatible open source license.
        );
        assertSearchResponse(response);
import java.io.IOException;
 * software distributed under the License is distributed on an
        assertThat(sum.getValue(), equalTo(1.0));
        assertThat(docCountDeriv, notNullValue());
        assertThat(docCountDeriv, notNullValue());
        assertThat(buckets.size(), equalTo(3));
            .atZone(timezone)
                dateHistogram("histo").field("date")
        assertThat(docCountDeriv, notNullValue());
        assertBucket(buckets.get(2), expectedKeyThirdBucket, 3L, notNullValue(), 1d, 1d / 105d);
                AggregationPath.parse("deriv.value").getPathElementsAsStringList()
        assertBucket(buckets.get(1), expectedKeySecondBucket, 2L, notNullValue(), 1d, 1d / 24d);
        assertThat(bucket.getKey(), equalTo(key));
        assertThat(deriv.getName(), equalTo("histo"));
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_ALL;
    }
                    .minDocCount(0)
    public void testPartiallyUnmapped() throws Exception {
        assertThat(bucket, notNullValue());
        key = ZonedDateTime.of(2012, 2, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        if (docCountDeriv != null) {
    }
        // the following is normalized using a 25h bucket width
                    .timeValue(date(month + 1, day + 1))
            )
        assertThat(docCountDeriv.value(), equalTo(1d));
            .addAggregation(
        // the shift happens during the next bucket, which includes the 45min that do not start on the full hour
 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
    }
import static org.hamcrest.core.IsNull.notNullValue;
        List<? extends Bucket> buckets = deriv.getBuckets();
        Histogram.Bucket bucket = buckets.get(0);
@OpenSearchIntegTestCase.SuiteScopeTestCase
        assertThat(bucket.getDocCount(), equalTo(3L));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        SimpleValue deriv = bucket.getAggregations().get("deriv");
        );
        assertThat(docCountDeriv, nullValue());
        ZonedDateTime key = ZonedDateTime.of(2012, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        assertThat(bucket.getDocCount(), equalTo(2L));
    private static final String IDX_DST_END = "idx_dst_end";
            )
        assertThat(deriv, notNullValue());
                dateHistogram("histo").field("date")
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_AUTO).build() },
        docCountDeriv = bucket.getAggregations().get("deriv");
        ensureSearchable();
        Histogram deriv = response.getAggregations().get("histo");
        assertThat(histo, notNullValue());
        assertThat(docCountDeriv.value(), equalTo(1d));
                indexDoc(2, 2, 2), // date: Feb 2, dates: Feb 2, Mar 3
 * The OpenSearch Contributors require contributions made to
import static org.hamcrest.Matchers.equalTo;
            ),
 *    http://www.apache.org/licenses/LICENSE-2.0
        ZonedDateTime expectedKeyFirstBucket = LocalDateTime.from(dateFormatter.parse("1985-12-31T22:00:00"))
            .withZoneSameInstant(ZoneOffset.UTC);
    }
import static org.opensearch.search.aggregations.AggregationBuilders.dateHistogram;
        assertBucket(buckets.get(1), expectedKeySecondBucket, 2L, notNullValue(), 1d, 1d / 24d);
        assertThat(bucket, notNullValue());
     * Do a derivative on a date histogram with time zone CET at DST start
        assertThat(bucket.getDocCount(), equalTo(3L));
    }
    }
        assertThat(docCountDeriv.value(), closeTo(1d, 0.00001));
        Histogram.Bucket bucket = buckets.get(0);
        Object[] propertiesCounts = (Object[]) ((InternalAggregation) histo).getProperty("sum.value");
                    .dateHistogramInterval(DateHistogramInterval.HOUR)
        ZonedDateTime expectedKeyThirdBucket = LocalDate.from(dateFormatter.parse("2012-03-26"))
        ZonedDateTime expectedKeyThirdBucket = LocalDate.from(dateFormatter.parse("2012-10-29"))
        ZonedDateTime expectedKeyFourthBucket = LocalDateTime.from(dateFormatter.parse("1986-01-01T02:00:00"))
        assertThat(bucket.getAggregations().asList().isEmpty(), is(false));
        // day with dst shift -1h, 25h long
        assertThat(bucket, notNullValue());
/*
import java.util.List;
        assertThat(
        assertThat(docCountDeriv, nullValue());
        DateFormatter dateFormatter = DateFormatter.forPattern("uuuu-MM-dd'T'HH:mm:ss").withZone(ZoneOffset.UTC);
        assertThat(bucket.getAggregations().asList().isEmpty(), is(false));
            new Object[] {
        assertThat(deriv, notNullValue());
            );
            new Object[] {
        assertBucket(buckets.get(1), expectedKeySecondBucket, 2L, notNullValue(), 1d, 1d / 60d);
            .atStartOfDay(timezone)
                    .subAggregation(derivative("deriv", "_count").unit(DateHistogramInterval.DAY))
        assertThat(docCountDeriv, nullValue());
        createIndex("idx_unmapped");
 * this work for additional information regarding copyright
        assertThat(bucket.getAggregations().asList().isEmpty(), is(false));
        assertThat(bucket.getDocCount(), equalTo(3L));
        assertThat(buckets.size(), equalTo(4));
            builders.add(indexDoc(index, dateTime, 1));
        assertThat(docCountDeriv.value(), equalTo(1.0));
        Histogram histo = response.getAggregations().get("histo");
            .get();
        SearchResponse response = client().prepareSearch("idx")
 * the Apache License, Version 2.0 (the "License"); you may
    }
            .get();
        List<IndexRequestBuilder> builders = new ArrayList<>();
        assertThat(deriv, notNullValue());
                dateHistogram("histo").field("date")
        assertThat(deriv, notNullValue());
 *
import org.opensearch.common.time.DateFormatter;
        addNTimes(1, IDX_DST_KATHMANDU, DateFormatters.from(formatter.parse("1985-12-31T22:30:00")), builders);
                indexDoc(1, 2, 1), // date: Jan 2, dates: Jan 2, Feb 3
            .atStartOfDay(timezone)
        assertThat(deriv, notNullValue());
            .atStartOfDay(timezone)
        assertThat(bucket, notNullValue());
        assertThat(histo.getName(), equalTo("histo"));
                dateHistogram("histo").field("date")
import org.opensearch.search.aggregations.metrics.Sum;
/*
        ZonedDateTime expectedKeySecondBucket = LocalDate.from(dateFormatter.parse("2012-03-25"))
        List<IndexRequestBuilder> builders = new ArrayList<>();
    public static Collection<Object[]> parameters() {
/*
                "histo",
        assertThat(bucket, notNullValue());
            )
        assertThat((ZonedDateTime) bucket.getKey(), equalTo(key));
        assertThat(bucket, notNullValue());
        assertThat(deriv.getName(), equalTo("histo"));
        indexRandom(true, builders);
        assertBucket(buckets.get(0), expectedKeyFirstBucket, 1L, nullValue(), null, null);
        Double derivative,
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE;
    }
                    .subAggregation(derivative("deriv", "_count"))
        assertThat((ZonedDateTime) bucket.getKey(), equalTo(key));
        assertBucket(buckets.get(3), expectedKeyFourthBucket, 4L, notNullValue(), 1d, 1d / 24d);
        deriv = bucket.getAggregations().get("deriv");
import org.hamcrest.Matcher;
 * KIND, either express or implied.  See the License for the
        ZonedDateTime expectedKeyThirdBucket = LocalDateTime.from(dateFormatter.parse("1986-01-01T01:00:00"))
        docCountDeriv = bucket.getAggregations().get("deriv");
    private IndexRequestBuilder indexDoc(int month, int day, int value) throws Exception {
        ZonedDateTime expectedKeyFourthBucket = LocalDate.from(dateFormatter.parse("2012-03-27"))
        deriv = bucket.getAggregations().get("deriv");
        DateFormatter formatter = DateFormatter.forPattern("uuuu-MM-dd'T'HH:mm:ss").withZone(timezone);
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_NONE;
    }
import static org.opensearch.search.aggregations.PipelineAggregatorBuilders.derivative;
                    .subAggregation(derivative("deriv", "_count").unit(DateHistogramInterval.HOUR))
        ZonedDateTime expectedKey,
            .addAggregation(
                    .dateHistogramInterval(DateHistogramInterval.MONTH)
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                    .timeZone(timezone)
                    .minDocCount(0)
                    .minDocCount(0)
     * Do a derivative on a date histogram with time zone CET at DST end
        return ZonedDateTime.of(2012, month, day, 0, 0, 0, 0, ZoneOffset.UTC);
        ensureSearchable();
        assertThat((ZonedDateTime) bucket.getKey(), equalTo(key));
            .get();
        assertThat(deriv.getBuckets().size(), equalTo(0));
        // the following is normalized using a 23h bucket width
        assertThat(bucket, notNullValue());
        bucket = buckets.get(1);
                    .minDocCount(0)
        Object[] propertiesDocCounts = (Object[]) ((InternalAggregation) histo).getProperty("_count");
        SimpleValue docCountDeriv = bucket.getAggregations().get("deriv");
            .withZoneSameInstant(ZoneOffset.UTC);
        assertThat((ZonedDateTime) propertiesKeys[2], equalTo(key));
    }
                    .subAggregation(derivative("deriv", "_count"))
            .withZoneSameInstant(ZoneOffset.UTC);
        assertSearchResponse(response);
        assertBucket(buckets.get(0), expectedKeyFirstBucket, 1L, nullValue(), null, null);
            .atStartOfDay(timezone)
 */
            );
        assertThat(docCountDeriv.normalizedValue(), closeTo(1d / 29d, 0.00001));
        SearchResponse response = client().prepareSearch("idx")
        assertSearchResponse(response);
            builders.add(
                    .minDocCount(0)
import java.time.ZoneOffset;
        docCountDeriv = bucket.getAggregations().get("deriv");
 * ownership. Elasticsearch licenses this file to you under
    }
        assertThat(bucket.getAggregations().asList().isEmpty(), is(false));
                    .timeValue(date(month, day))
            .setSource(
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramInterval;
    @Override
        assertSearchResponse(response);
        assertThat(buckets.size(), equalTo(3));
import java.time.ZonedDateTime;
        assertThat(bucket.getDocCount(), equalTo(1L));
        assertThat(deriv.getName(), equalTo("histo"));
            )
        SearchResponse response = client().prepareSearch(IDX_DST_END)
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_NONE).build() }
                    .subAggregation(derivative("deriv", "_count"))
        bucket = buckets.get(2);
        sum = bucket.getAggregations().get("sum");
                    .minDocCount(0)
                    .endArray()
        assertThat(deriv.getName(), equalTo("histo"));
        assertThat(buckets.size(), equalTo(3));
     */
        assertThat(deriv.value(), equalTo(4.0));
        assertThat((double) propertiesCounts[0], equalTo(1.0));
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.aggregations.InternalAggregation;
        ensureSearchable();
        Histogram deriv = response.getAggregations().get("histo");
        prepareCreate("empty_bucket_idx").setMapping("value", "type=integer").get();
    public void testSingleValuedFieldNormalised_timeZone_CET_DstEnd() throws Exception {
import org.opensearch.action.search.SearchResponse;
        assertThat(deriv.getName(), equalTo("histo"));
        assertThat(bucket.getKey(), equalTo(key));
                indexDoc(3, 23, 6)
        assertThat(deriv, notNullValue());
        assertThat(bucket.getAggregations().asList().isEmpty(), is(true));
            .addAggregation(
        SearchResponse response = client().prepareSearch("idx_unmapped")
            assertThat(docCountDeriv.value(), closeTo(derivative, 0.00001));
        ZonedDateTime expectedKeyFourthBucket = LocalDate.from(dateFormatter.parse("2012-10-30"))
        assertThat(sum.getValue(), equalTo(5.0));
            )
        }
        assertThat(bucket.getDocCount(), equalTo(2L));
        assertThat(docCountDeriv.value(), equalTo(2.0));
                    .dateHistogramInterval(DateHistogramInterval.MONTH)
        assertSearchResponse(response);
        indexRandom(true, builders);
                    .dateHistogramInterval(DateHistogramInterval.MONTH)
    @After
        key = ZonedDateTime.of(2012, 3, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        }
        return client().prepareIndex(idx).setSource(jsonBuilder().startObject().timeField("date", date).field("value", value).endObject());
                client().prepareIndex("empty_bucket_idx")
        sum = bucket.getAggregations().get("sum");
 */
    }
                    .dateHistogramInterval(DateHistogramInterval.DAY)
        assertThat(deriv, notNullValue());
        SearchResponse response = client().prepareSearch("idx")
        assertThat(deriv, notNullValue());
        assertThat(bucket, notNullValue());
 * Licensed to Elasticsearch under one or more contributor
            .get();
        assertThat(deriv.value(), equalTo(10.0));
    public DateDerivativeIT(Settings staticSettings) {
import java.util.Arrays;
        assertThat(bucket, notNullValue());
import java.util.Collection;
        assertThat(docCountDeriv, nullValue());
        ensureSearchable();
        addNTimes(2, IDX_DST_KATHMANDU, DateFormatters.from(formatter.parse("1985-12-31T23:30:00")), builders);
        bucket = buckets.get(1);
        bucket = buckets.get(1);
        assertThat(deriv, nullValue());
        assertThat(docCountDeriv.value(), equalTo(-2.0));
        // TODO: would be nice to have more random data here
            Arrays.asList(
            .addAggregation(
    }
        assertThat(docCountDeriv.normalizedValue(), closeTo(1d / 31d, 0.00001));
import org.opensearch.search.aggregations.support.AggregationPath;
                indexDoc(2, 15, 3), // date: Feb 15, dates: Feb 15, Mar 16
                    .timeZone(timezone)
            )
        assertThat(bucket.getAggregations().asList().isEmpty(), is(false));
        key = ZonedDateTime.of(2012, 3, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        bucket = buckets.get(1);
        // day with dst shift, only 23h long
        assertThat(sum.getValue(), equalTo(15.0));
            equalTo(4.0)
                    .dateHistogramInterval(DateHistogramInterval.MONTH)
        ZoneId timezone = ZoneId.of("Asia/Kathmandu");
        assertThat(docCountDeriv.value(), equalTo(2.0));
        key = ZonedDateTime.of(2012, 2, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        createIndex(IDX_DST_KATHMANDU);
        assertThat((ZonedDateTime) bucket.getKey(), equalTo(key));
                dateHistogram("histo").field("date")
import static org.hamcrest.Matchers.closeTo;
                    .dateHistogramInterval(DateHistogramInterval.MONTH)
import org.opensearch.common.settings.Settings;
        assertThat((long) propertiesDocCounts[2], equalTo(3L));
                    .setSource(jsonBuilder().startObject().field("value", i * 2).endObject())
        assertThat((ZonedDateTime) bucket.getKey(), equalTo(key));
        Object[] propertiesKeys = (Object[]) ((InternalAggregation) histo).getProperty("_key");
 *
import org.opensearch.test.OpenSearchIntegTestCase;
package org.opensearch.search.aggregations.pipeline;
        ZoneId timezone = ZoneId.of("CET");
        assertThat(sum, notNullValue());
        assertThat(docCountDeriv, notNullValue());
            .atStartOfDay(timezone)
        addNTimes(3, IDX_DST_START, DateFormatters.from(formatter.parse("2012-03-26T01:00:00")), builders);
    public void afterEachTest() throws IOException {
 */
        assertThat(deriv.getName(), equalTo("histo"));
        key = ZonedDateTime.of(2012, 3, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        SimpleValue docCountDeriv = bucket.getAggregations().get("deriv");
        ZonedDateTime expectedKeySecondBucket = LocalDate.from(dateFormatter.parse("2012-10-28"))
            .atZone(timezone)
                    .subAggregation(derivative("deriv", "_count"))
        List<? extends Bucket> buckets = histo.getBuckets();
        assertThat(
        assertThat((ZonedDateTime) bucket.getKey(), equalTo(expectedKey));
        DateFormatter dateFormatter = DateFormatter.forPattern("uuuu-MM-dd").withZone(ZoneOffset.UTC);
        createIndex(IDX_DST_START);
            .get();
    }
        assertThat(bucket, notNullValue());
 * license agreements. See the NOTICE file distributed with
        indexRandom(true, builders);
        internalCluster().wipeIndices(IDX_DST_START, IDX_DST_END, IDX_DST_KATHMANDU);
        key = ZonedDateTime.of(2012, 2, 1, 0, 0, 0, 0, ZoneOffset.UTC);
            .atStartOfDay(timezone)
        Histogram deriv = response.getAggregations().get("histo");
        return client().prepareIndex("idx")
        assertThat(buckets.size(), equalTo(3));
    public void testSingleValuedFieldNormalised() throws Exception {
        bucket = buckets.get(2);
            .withZoneSameInstant(ZoneOffset.UTC);
        super(staticSettings);
        assertThat(bucket.getAggregations().asList().isEmpty(), is(false));
        assertThat(bucket.getDocCount(), equalTo(1L));
        assertThat(bucket.getDocCount(), equalTo(3L));
        assertThat((ZonedDateTime) bucket.getKey(), equalTo(key));
    private static final String IDX_DST_KATHMANDU = "idx_dst_kathmandu";
            .atStartOfDay(timezone)
        assertThat(bucket.getDocCount(), equalTo(2L));
            .withZoneSameInstant(ZoneOffset.UTC);
        ZonedDateTime key = ZonedDateTime.of(2012, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
        assertBucket(buckets.get(0), expectedKeyFirstBucket, 1L, nullValue(), null, null);
        ZonedDateTime key = ZonedDateTime.of(2012, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
                jsonBuilder().startObject()
            )
                dateHistogram("histo").field("date")
        assertThat((long) propertiesDocCounts[1], equalTo(2L));
        Histogram deriv = response.getAggregations().get("histo");
 * specific language governing permissions and limitations
        DateFormatter dateFormatter = DateFormatter.forPattern("uuuu-MM-dd");
        bucket = buckets.get(2);
 * You may obtain a copy of the License at
        addNTimes(1, IDX_DST_END, DateFormatters.from(formatter.parse("2012-10-27T01:00:00")), builders);
     * "Asia/Kathmandu, 1 Jan 1986 - Time Zone Change (IST → NPT), at 00:00:00 clocks were turned forward 00:15 minutes
import org.opensearch.search.aggregations.bucket.histogram.Histogram.Bucket;
        assertThat((double) propertiesCounts[1], equalTo(5.0));
            .atZone(timezone)
        ZonedDateTime expectedKeyFirstBucket = LocalDate.from(dateFormatter.parse("2012-03-24"))
                    .field("value", value)
    public void testMultiValuedField() throws Exception {
     * also check for time zone shifts that are not one hour, e.g.
            )
    // some index names used during these tests
                    .startArray("dates")
        for (int i = 0; i < 2; i++) {
        addNTimes(2, IDX_DST_END, DateFormatters.from(formatter.parse("2012-10-28T01:00:00")), builders);
    public void setupSuiteScopeCluster() throws Exception {
        ZonedDateTime key = ZonedDateTime.of(2012, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        assertThat(bucket.getDocCount(), equalTo(1L));
        bucket = buckets.get(2);
        bucket = buckets.get(3);
        docCountDeriv = bucket.getAggregations().get("deriv");
            .addAggregation(
                indexDoc(3, 15, 5), // date: Mar 15, dates: Mar 15, Apr 16
            .withZoneSameInstant(ZoneOffset.UTC);
        // the following is normalized using a 105min bucket width
 * GitHub history for details.
        assertThat((long) propertiesDocCounts[0], equalTo(1L));
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;
        assertThat(bucket, notNullValue());
        assertThat((ZonedDateTime) propertiesKeys[0], equalTo(key));
        assertThat(bucket.getDocCount(), equalTo(1L));
        assertThat(bucket.getDocCount(), equalTo(expectedDocCount));
    public void testSingleValuedField() throws Exception {
        key = ZonedDateTime.of(2012, 2, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        Histogram deriv = response.getAggregations().get("histo");
    /**
        assertThat(docCountDeriv, notNullValue());
        assertThat(docCountDeriv.value(), closeTo(1d, 0.00001));
        Histogram.Bucket bucket = buckets.get(0);
        assertThat(bucket, notNullValue());
                AggregationPath.parse("deriv.value").getPathElementsAsStringList()
        Histogram deriv = response.getAggregations().get("histo");
            .atZone(timezone)
        List<? extends Bucket> buckets = deriv.getBuckets();
        Histogram deriv = response.getAggregations().get("histo");
        List<? extends Bucket> buckets = deriv.getBuckets();
        assertThat(docCountDeriv, notNullValue());
        addNTimes(4, IDX_DST_START, DateFormatters.from(formatter.parse("2012-03-27T01:00:00")), builders);
        assertThat(bucket, notNullValue());
            .get();
        assertThat(deriv.getName(), equalTo("histo"));
            .get();
            .withZoneSameInstant(ZoneOffset.UTC);
import static org.hamcrest.Matchers.is;
import java.time.LocalDate;
    /**
        assertThat(deriv.getName(), equalTo("histo"));
    }
        assertThat(bucket, notNullValue());
        DateFormatter formatter = DateFormatter.forPattern("uuuu-MM-dd'T'HH:mm:ss").withZone(timezone);
        createIndex("idx");
    private ZonedDateTime date(int month, int day) {
                    .timeField("date", date(month, day))
        SearchResponse response = client().prepareSearch("idx", "idx_unmapped")
            .withZoneSameInstant(ZoneOffset.UTC);
        addNTimes(3, IDX_DST_KATHMANDU, DateFormatters.from(formatter.parse("1986-01-01T01:30:00")), builders);
    /**
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
            .addAggregation(
    @ParametersFactory
    public void testSingleValuedFieldNormalised_timeZone_CET_DstStart() throws Exception {
        assertThat(buckets.size(), equalTo(4));
            new Object[] {
        assertThat(bucket, notNullValue());
        docCountDeriv = bucket.getAggregations().get("deriv");
        List<? extends Bucket> buckets = deriv.getBuckets();
                    .subAggregation(derivative("deriv", "_count").unit(DateHistogramInterval.HOUR))
            .addAggregation(
        assertThat((ZonedDateTime) bucket.getKey(), equalTo(key));
        indexRandom(true, builders);
                    .subAggregation(sum("sum").field("value"))
        assertThat(bucket.getAggregations().asList().isEmpty(), is(false));
 * under the License.
            .withZoneSameInstant(ZoneOffset.UTC);
        assertThat(docCountDeriv, notNullValue());
                    .endObject()
        assertThat(sum, notNullValue());
        Derivative docCountDeriv = bucket.getAggregations().get("deriv");
        addNTimes(3, IDX_DST_END, DateFormatters.from(formatter.parse("2012-10-29T01:00:00")), builders);
     */
        assertBucket(buckets.get(2), expectedKeyThirdBucket, 3L, notNullValue(), 1d, 1d / 25d);
import static org.opensearch.search.aggregations.AggregationBuilders.sum;
        assertBucket(buckets.get(3), expectedKeyFourthBucket, 4L, notNullValue(), 1d, 1d / 60d);
        assertThat(bucket.getDocCount(), equalTo(5L));
        assertThat((ZonedDateTime) bucket.getKey(), equalTo(key));
            .addAggregation(
                    .minDocCount(0)
        Histogram.Bucket bucket = buckets.get(0);
        assertThat((double) propertiesCounts[2], equalTo(15.0));
    private static IndexRequestBuilder indexDoc(String idx, ZonedDateTime date, int value) throws Exception {
        SearchResponse response = client().prepareSearch(IDX_DST_START)
        return Arrays.asList(
        assertThat(sum, notNullValue());
        assertThat(bucket, notNullValue());
            .withZoneSameInstant(ZoneOffset.UTC);
        assertThat(bucket.getDocCount(), equalTo(3L));
 * Unless required by applicable law or agreed to in writing,
        assertThat(docCountDeriv, notNullValue());
        docCountDeriv = bucket.getAggregations().get("deriv");
                    .timeZone(timezone)
        assertThat(bucket, notNullValue());
                indexDoc(3, 2, 4), // date: Mar 2, dates: Mar 2, Apr 3
        assertSearchResponse(response);
            equalTo(10.0)
        assertSearchResponse(response);
            )
    public void testSingleValuedFieldNormalised_timeZone_AsiaKathmandu() throws Exception {
        ZonedDateTime expectedKeySecondBucket = LocalDateTime.from(dateFormatter.parse("1985-12-31T23:00:00"))
        key = ZonedDateTime.of(2012, 2, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        bucket = buckets.get(1);
        SearchResponse response = client().prepareSearch("idx")
            .atStartOfDay(timezone)
import java.time.ZoneId;
        bucket = buckets.get(2);
        addNTimes(4, IDX_DST_KATHMANDU, DateFormatters.from(formatter.parse("1986-01-01T02:30:00")), builders);
        addNTimes(2, IDX_DST_START, DateFormatters.from(formatter.parse("2012-03-25T01:00:00")), builders);
        assertThat((ZonedDateTime) bucket.getKey(), equalTo(key));
 * not use this file except in compliance with the License.
        for (int i = 0; i < amount; i++) {
                dateHistogram("histo").field("date")
            assertThat(docCountDeriv.normalizedValue(), closeTo(normalizedDerivative, 0.00001));
                    .subAggregation(derivative("deriv", "_count").unit(DateHistogramInterval.MINUTE))
    ) {
        ZonedDateTime expectedKeyFirstBucket = LocalDate.from(dateFormatter.parse("2012-10-27"))
        assertThat(bucket.getAggregations().asList().isEmpty(), is(false));
        docCountDeriv = bucket.getAggregations().get("deriv");
        ZonedDateTime key = ZonedDateTime.of(2012, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
            )
        assertBucket(buckets.get(3), expectedKeyFourthBucket, 4L, notNullValue(), 1d, 1d / 24d);
        docCountDeriv = bucket.getAggregations().get("deriv");
        assertThat(bucket.getDocCount(), equalTo(2L));
        DateFormatter formatter = DateFormatter.forPattern("uuuu-MM-dd'T'HH:mm:ss").withZone(timezone);
     */
    private static final String IDX_DST_START = "idx_dst_start";
    }
            .addAggregation(
        List<? extends Bucket> buckets = deriv.getBuckets();
        Histogram.Bucket bucket,
import java.time.LocalDateTime;
            ((InternalMultiBucketAggregation.InternalBucket) bucket).getProperty(
        assertThat((ZonedDateTime) propertiesKeys[1], equalTo(key));
    public void testSingleValuedFieldWithSubAggregation() throws Exception {
        ); // date: Mar 23, dates: Mar 23, Apr 24
import static org.hamcrest.core.IsNull.nullValue;
        List<IndexRequestBuilder> builders = new ArrayList<>();
        List<? extends Bucket> buckets = deriv.getBuckets();
        Matcher<Object> derivativeMatcher,
                    .dateHistogramInterval(DateHistogramInterval.MONTH)
        key = ZonedDateTime.of(2012, 3, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        assertThat(deriv, notNullValue());
                    .minDocCount(0)
import org.junit.After;
        }
        assertThat(bucket.getDocCount(), equalTo(1L));
        );
        assertThat(bucket.getAggregations().asList().isEmpty(), is(true));
        assertThat(bucket.getKey(), equalTo(key));
import java.util.ArrayList;
