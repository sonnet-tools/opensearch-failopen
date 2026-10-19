import java.util.Collection;
import static org.opensearch.search.aggregations.AggregationBuilders.dateHistogram;  
        assertThat(bucket.getKey(), equalTo(key));
        assertThat(docCountDeriv.value(), equalTo(1d));
        assertSearchResponse(response);  
        indexRandom(true, builders);
                    .subAggregation(derivative("deriv", "_count").unit(DateHistogramInterval.HOUR))
    }  
/*  
        assertThat(bucket.getDocCount(), equalTo(1L));
 *
            .addAggregation(
        );
    }
            .addAggregation(
        assertThat(bucket, notNullValue());  
    }  
            )
        docCountDeriv = bucket.getAggregations().get("deriv");
        Histogram deriv = response.getAggregations().get("histo");
    public void testSingleValuedFieldNormalised() throws Exception {
        assertThat(bucket, notNullValue());
            Arrays.asList(
        assertThat(deriv, notNullValue());
                dateHistogram("histo").field("date")  
        // epoch millis: 1332547200000
        assertThat(bucket.getKey(), equalTo(key));
        DateFormatter formatter = DateFormatter.forPattern("uuuu-MM-dd'T'HH:mm:ss").withZone(timezone);
            equalTo(4.0)  
    }
        assertThat(docCountDeriv, notNullValue());
            )
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_NONE).build() }  
                    .dateHistogramInterval(DateHistogramInterval.MONTH)
    }  
        Histogram deriv = response.getAggregations().get("histo");
                indexDoc(3, 23, 6)
        assertThat(sum, notNullValue());
 * under the License.  
            .atStartOfDay(timezone)  
        docCountDeriv = bucket.getAggregations().get("deriv");
        sum = bucket.getAggregations().get("sum");
            .withZoneSameInstant(ZoneOffset.UTC);  
                    .setId("" + i)  
        bucket = buckets.get(1);
        bucket = buckets.get(1);
        Histogram.Bucket bucket = buckets.get(0);  
        assertThat(bucket.getKey(), equalTo(key));
    }
import java.util.ArrayList;
        addNTimes(1, IDX_DST_END, DateFormatters.from(formatter.parse("2012-10-27T01:00:00")), builders);  
        addNTimes(2, IDX_DST_END, DateFormatters.from(formatter.parse("2012-10-28T01:00:00")), builders);
     */
        assertThat((ZonedDateTime) bucket.getKey(), equalTo(expectedKey));
import org.opensearch.common.time.DateFormatter;  
        assertSearchResponse(response);
        assertThat((long) propertiesDocCounts[0], equalTo(1L));
        List<IndexRequestBuilder> builders = new ArrayList<>();  
 *
                    .subAggregation(derivative("deriv", "sum"))
        assertThat(bucket.getDocCount(), equalTo(3L));  
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_ALL).build() },
                    .timeField("date", date(month, day))
        // TODO: would be nice to have more random data here  
    private static void assertBucket(
        assertThat(bucket.getAggregations().asList().isEmpty(), is(false));  
        Derivative docCountDeriv = bucket.getAggregations().get("deriv");
     * Do a derivative on a date histogram with time zone CET at DST end
            .atStartOfDay(timezone)
        assertThat(docCountDeriv.value(), closeTo(1d, 0.00001));  
        assertThat((ZonedDateTime) bucket.getKey(), equalTo(key));
 * compatible open source license.
        ZonedDateTime key = ZonedDateTime.of(2012, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
    /**
        assertThat(deriv, notNullValue());
                    .minDocCount(0)
                    .subAggregation(derivative("deriv", "_count"))
    public void testSingleValuedFieldNormalised_timeZone_CET_DstEnd() throws Exception {  
        docCountDeriv = bucket.getAggregations().get("deriv");
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;  
    public static Collection<Object[]> parameters() {
    private ZonedDateTime date(int month, int day) {
        return Arrays.asList(  
            ),
        addNTimes(4, IDX_DST_END, DateFormatters.from(formatter.parse("2012-10-30T01:00:00")), builders);
        assertThat(bucket.getDocCount(), equalTo(5L));
        List<? extends Bucket> buckets = deriv.getBuckets();
        assertThat(docCountDeriv, notNullValue());  
                indexDoc(2, 2, 2), // date: Feb 2, dates: Feb 2, Mar 3
            assertThat(docCountDeriv.value(), closeTo(derivative, 0.00001));
            new Object[] {
        assertThat(docCountDeriv, notNullValue());
                indexDoc(3, 2, 4), // date: Mar 2, dates: Mar 2, Apr 3  
        assertBucket(buckets.get(0), expectedKeyFirstBucket, 1L, nullValue(), null, null);
 * SPDX-License-Identifier: Apache-2.0
        Histogram deriv = response.getAggregations().get("histo");
import org.opensearch.search.aggregations.support.AggregationPath;
                    .minDocCount(0)
    @ParametersFactory
        Histogram deriv = response.getAggregations().get("histo");  
                    .dateHistogramInterval(DateHistogramInterval.MONTH)  
        );
        assertThat(bucket.getAggregations().asList().isEmpty(), is(false));  
        assertThat(bucket.getAggregations().asList().isEmpty(), is(false));
        assertThat((double) propertiesCounts[0], equalTo(1.0));
                indexDoc(2, 15, 3), // date: Feb 15, dates: Feb 15, Mar 16
        List<IndexRequestBuilder> builders = new ArrayList<>();  
    }
    public void testUnmapped() throws Exception {
        List<? extends Bucket> buckets = deriv.getBuckets();
        SimpleValue deriv = bucket.getAggregations().get("deriv");
        assertThat(buckets.size(), equalTo(4));  
        key = ZonedDateTime.of(2012, 3, 1, 0, 0, 0, 0, ZoneOffset.UTC);
                    .dateHistogramInterval(DateHistogramInterval.MONTH)
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
        assertThat(deriv, notNullValue());  
        assertThat(deriv.value(), equalTo(4.0));  
                    .timeZone(timezone)  
        assertThat((ZonedDateTime) bucket.getKey(), equalTo(key));  
import org.opensearch.common.settings.Settings;
        assertThat(bucket.getDocCount(), equalTo(2L));
    private IndexRequestBuilder indexDoc(int month, int day, int value) throws Exception {  
            )  
        assertSearchResponse(response);  
            )
        createIndex("idx");
                dateHistogram("histo").field("date")
        assertThat((ZonedDateTime) bucket.getKey(), equalTo(key));
                    .minDocCount(0)  
        List<? extends Bucket> buckets = histo.getBuckets();
                    .subAggregation(derivative("deriv", "_count"))
    public void testSingleValuedFieldNormalised_timeZone_CET_DstStart() throws Exception {
        Histogram histo = response.getAggregations().get("histo");
        assertThat(bucket.getDocCount(), equalTo(2L));
        assertThat(deriv, notNullValue());
        SearchResponse response = client().prepareSearch("idx")
                dateHistogram("histo").field("date")
        List<IndexRequestBuilder> builders = new ArrayList<>();
        assertThat(histo, notNullValue());
        assertThat(bucket.getAggregations().asList().isEmpty(), is(false));  
    }
 * specific language governing permissions and limitations
        assertThat(bucket.getAggregations().asList().isEmpty(), is(false));
        deriv = bucket.getAggregations().get("deriv");
    }  
        // the following is normalized using a 105min bucket width
        ZoneId timezone = ZoneId.of("CET");
        addNTimes(3, IDX_DST_START, DateFormatters.from(formatter.parse("2012-03-26T01:00:00")), builders);
        assertThat(bucket, notNullValue());
    }
            .get();
        bucket = buckets.get(2);
        assertThat(buckets.size(), equalTo(3));  
        // day with dst shift -1h, 25h long
            ),
        addNTimes(3, IDX_DST_END, DateFormatters.from(formatter.parse("2012-10-29T01:00:00")), builders);  
                    .dateHistogramInterval(DateHistogramInterval.DAY)
        assertBucket(buckets.get(2), expectedKeyThirdBucket, 3L, notNullValue(), 1d, 1d / 25d);  
                    .endObject()
        assertThat(buckets.size(), equalTo(3));  
                AggregationPath.parse("deriv.value").getPathElementsAsStringList()
        assertThat(deriv.getName(), equalTo("histo"));  
        for (int i = 0; i < amount; i++) {  
        Histogram deriv = response.getAggregations().get("histo");
 * KIND, either express or implied.  See the License for the
import java.time.ZoneOffset;  
        assertThat(buckets.size(), equalTo(4));  
        addNTimes(1, IDX_DST_KATHMANDU, DateFormatters.from(formatter.parse("1985-12-31T22:30:00")), builders);  
        assertThat((double) propertiesCounts[1], equalTo(5.0));
        assertThat(docCountDeriv.value(), closeTo(1d, 0.00001));
    /**
            .atZone(timezone)
        ZonedDateTime key = ZonedDateTime.of(2012, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
            builders.add(indexDoc(index, dateTime, 1));
            .addAggregation(  
        // the shift happens during the next bucket, which includes the 45min that do not start on the full hour
        assertThat(bucket.getDocCount(), equalTo(3L));
                    .startArray("dates")  
     * also check for time zone shifts that are not one hour, e.g.  
        DateFormatter formatter = DateFormatter.forPattern("uuuu-MM-dd'T'HH:mm:ss").withZone(timezone);  
        SimpleValue docCountDeriv = bucket.getAggregations().get("deriv");  
        prepareCreate("empty_bucket_idx").setMapping("value", "type=integer").get();
        assertThat(bucket, notNullValue());
            .atStartOfDay(timezone)
        docCountDeriv = bucket.getAggregations().get("deriv");
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;  
    @Override
        assertThat(docCountDeriv.normalizedValue(), closeTo(1d / 29d, 0.00001));
        assertThat(bucket, notNullValue());
                    .dateHistogramInterval(DateHistogramInterval.MONTH)  
        assertThat(deriv, notNullValue());  
        key = ZonedDateTime.of(2012, 2, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        assertBucket(buckets.get(1), expectedKeySecondBucket, 2L, notNullValue(), 1d, 1d / 60d);  
            ((InternalMultiBucketAggregation.InternalBucket) bucket).getProperty(
                AggregationPath.parse("deriv.value").getPathElementsAsStringList()  
        for (int i = 0; i < 2; i++) {  
        assertThat(docCountDeriv, derivativeMatcher);
    public DateDerivativeIT(Settings staticSettings) {  
        ZonedDateTime expectedKeyFirstBucket = LocalDate.from(dateFormatter.parse("2012-03-24"))
        bucket = buckets.get(1);
        assertThat(bucket.getDocCount(), equalTo(1L));  
import org.opensearch.search.aggregations.InternalAggregation;
        Double derivative,
        assertThat(docCountDeriv, notNullValue());
        ensureSearchable();
            .atStartOfDay(timezone)
     * Do a derivative on a date histogram with time zone CET at DST start
        key = ZonedDateTime.of(2012, 3, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        Double normalizedDerivative
            .get();
        bucket = buckets.get(2);  
 * software distributed under the License is distributed on an
        SearchResponse response = client().prepareSearch("idx", "idx_unmapped")
        builders.addAll(
        assertThat(deriv.getName(), equalTo("histo"));
        assertThat(buckets.size(), equalTo(3));
    }  
        key = ZonedDateTime.of(2012, 4, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        assertThat(deriv, notNullValue());  
            )  
                    .field("value", value)
        assertThat(docCountDeriv, notNullValue());
        ZonedDateTime expectedKeySecondBucket = LocalDateTime.from(dateFormatter.parse("1985-12-31T23:00:00"))  
        bucket = buckets.get(1);
                    .endArray()  
        }
        assertThat((ZonedDateTime) bucket.getKey(), equalTo(key));
        createIndex(IDX_DST_START);
                jsonBuilder().startObject()  
 * license agreements. See the NOTICE file distributed with
    private static void addNTimes(int amount, String index, ZonedDateTime dateTime, List<IndexRequestBuilder> builders) throws Exception {
        assertThat(sum, notNullValue());
            .withZoneSameInstant(ZoneOffset.UTC);
import static org.opensearch.search.aggregations.PipelineAggregatorBuilders.derivative;
    private static final String IDX_DST_END = "idx_dst_end";  
                    .timeValue(date(month + 1, day + 1))
import org.opensearch.test.OpenSearchIntegTestCase;  
        Histogram.Bucket bucket = buckets.get(0);
        assertThat(docCountDeriv.value(), equalTo(1.0));  
            .withZoneSameInstant(ZoneOffset.UTC);
        assertThat((ZonedDateTime) bucket.getKey(), equalTo(key));
        SearchResponse response = client().prepareSearch("idx_unmapped")
        addNTimes(3, IDX_DST_KATHMANDU, DateFormatters.from(formatter.parse("1986-01-01T01:30:00")), builders);  
        long expectedDocCount,
 */
        assertThat(bucket, notNullValue());  
        assertBucket(buckets.get(2), expectedKeyThirdBucket, 3L, notNullValue(), 1d, 1d / 105d);  
    public void testMultiValuedField() throws Exception {  
        ZonedDateTime expectedKeySecondBucket = LocalDate.from(dateFormatter.parse("2012-03-25"))
 * the Apache License, Version 2.0 (the "License"); you may
        bucket = buckets.get(2);
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE;
        docCountDeriv = bucket.getAggregations().get("deriv");  
        assertThat(bucket.getAggregations().asList().isEmpty(), is(true));  
        Histogram.Bucket bucket = buckets.get(0);
        assertThat((long) propertiesDocCounts[2], equalTo(3L));
        SearchResponse response = client().prepareSearch(IDX_DST_KATHMANDU)
        assertSearchResponse(response);
        assertThat(deriv, notNullValue());
            .get();  
                    .dateHistogramInterval(DateHistogramInterval.DAY)
            )
        assertThat(bucket.getDocCount(), equalTo(2L));
    public void setupSuiteScopeCluster() throws Exception {  
        assertThat(bucket.getAggregations().asList().isEmpty(), is(true));
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
        return ZonedDateTime.of(2012, month, day, 0, 0, 0, 0, ZoneOffset.UTC);
        ZonedDateTime expectedKeyThirdBucket = LocalDate.from(dateFormatter.parse("2012-10-29"))  
                dateHistogram("histo").field("date")
        assertThat(histo.getName(), equalTo("histo"));  
        assertThat(bucket, notNullValue());  
        assertThat(bucket, notNullValue());
        List<? extends Bucket> buckets = deriv.getBuckets();  
        assertThat(deriv.getName(), equalTo("histo"));
        assertThat(bucket.getDocCount(), equalTo(1L));  
        ZonedDateTime expectedKeyFourthBucket = LocalDate.from(dateFormatter.parse("2012-10-30"))
        assertThat((ZonedDateTime) propertiesKeys[1], equalTo(key));
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(docCountDeriv, notNullValue());
    public void testSingleValuedField() throws Exception {
        assertThat(bucket, notNullValue());
        key = ZonedDateTime.of(2012, 3, 1, 0, 0, 0, 0, ZoneOffset.UTC);  
                dateHistogram("histo").field("date")
        SearchResponse response = client().prepareSearch("idx")  
            .withZoneSameInstant(ZoneOffset.UTC);
            .withZoneSameInstant(ZoneOffset.UTC);
    public void testSingleValuedFieldWithSubAggregation() throws Exception {  
        key = ZonedDateTime.of(2012, 2, 1, 0, 0, 0, 0, ZoneOffset.UTC);  
        createIndex(IDX_DST_KATHMANDU);
        Object[] propertiesCounts = (Object[]) ((InternalAggregation) histo).getProperty("sum.value");
 */  
        assertThat(bucket, notNullValue());  
        assertThat(bucket, notNullValue());
        assertThat((ZonedDateTime) bucket.getKey(), equalTo(key));
/*  
            .get();
        Object[] propertiesDocCounts = (Object[]) ((InternalAggregation) histo).getProperty("_count");
        assertThat(sum.getValue(), equalTo(5.0));  
        assertThat((ZonedDateTime) bucket.getKey(), equalTo(key));
        docCountDeriv = bucket.getAggregations().get("deriv");
import static org.hamcrest.Matchers.closeTo;
public class DateDerivativeIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
import org.hamcrest.Matcher;
        assertThat(docCountDeriv.value(), equalTo(1d));
        assertThat(bucket.getDocCount(), equalTo(1L));
        }  
    }  
        Histogram.Bucket bucket = buckets.get(0);  
        assertThat((ZonedDateTime) propertiesKeys[0], equalTo(key));  
        assertThat(bucket.getDocCount(), equalTo(3L));
        assertThat(sum.getValue(), equalTo(1.0));  
        assertThat(deriv.getName(), equalTo("histo"));
        ZoneId timezone = ZoneId.of("CET");
        Derivative docCountDeriv = bucket.getAggregations().get("deriv");
                    .dateHistogramInterval(DateHistogramInterval.HOUR)
        key = ZonedDateTime.of(2012, 3, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        assertThat((ZonedDateTime) bucket.getKey(), equalTo(key));
import static org.opensearch.search.aggregations.AggregationBuilders.sum;
 */  
                    .timeValue(date(month, day))
            .atZone(timezone)
        ZonedDateTime expectedKey,
        key = ZonedDateTime.of(2012, 2, 1, 0, 0, 0, 0, ZoneOffset.UTC);
import java.util.Arrays;  
    public void afterEachTest() throws IOException {
    }
import org.opensearch.action.index.IndexRequestBuilder;  
            .withZoneSameInstant(ZoneOffset.UTC);  
            .get();
        SearchResponse response = client().prepareSearch(IDX_DST_START)
        SearchResponse response = client().prepareSearch("idx")
        List<? extends Bucket> buckets = deriv.getBuckets();
        ensureSearchable();  
        assertThat(docCountDeriv, nullValue());
            );
                    .minDocCount(0)
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_AUTO;
                    .subAggregation(sum("sum").field("value"))  
            new Object[] {  
        Matcher<Object> derivativeMatcher,  
        DateFormatter dateFormatter = DateFormatter.forPattern("uuuu-MM-dd").withZone(ZoneOffset.UTC);
            .addAggregation(
import java.time.ZoneId;
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_ALL;  
    }
        assertThat((ZonedDateTime) bucket.getKey(), equalTo(key));
                    .subAggregation(derivative("deriv", "_count"))  
        List<? extends Bucket> buckets = deriv.getBuckets();
                    .setSource(jsonBuilder().startObject().field("value", i * 2).endObject())
        assertThat(bucket.getDocCount(), equalTo(2L));
        return client().prepareIndex(idx).setSource(jsonBuilder().startObject().timeField("date", date).field("value", value).endObject());  
            .addAggregation(  
        assertThat(bucket.getDocCount(), equalTo(3L));  
            .get();
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_NONE;
        assertSearchResponse(response);
        assertThat(bucket.getDocCount(), equalTo(expectedDocCount));  
            new Object[] {
        addNTimes(4, IDX_DST_KATHMANDU, DateFormatters.from(formatter.parse("1986-01-01T02:30:00")), builders);
        ZonedDateTime expectedKeyFirstBucket = LocalDateTime.from(dateFormatter.parse("1985-12-31T22:00:00"))
        assertThat(  
    public void testPartiallyUnmapped() throws Exception {
                client().prepareIndex("empty_bucket_idx")
        assertThat(deriv.getName(), equalTo("histo"));  
            .addAggregation(
        key = ZonedDateTime.of(2012, 2, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        assertThat(buckets.size(), equalTo(4));
package org.opensearch.search.aggregations.pipeline;
        return client().prepareIndex("idx")
        assertThat(sum, notNullValue());
                indexDoc(3, 15, 5), // date: Mar 15, dates: Mar 15, Apr 16
        ZonedDateTime key = ZonedDateTime.of(2012, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
                dateHistogram("histo").field("date")  
        SearchResponse response = client().prepareSearch(IDX_DST_END)
        Histogram deriv = response.getAggregations().get("histo");
import org.opensearch.search.aggregations.metrics.Sum;
            );
        if (docCountDeriv != null) {  
        assertThat(deriv.getName(), equalTo("histo"));
            .atStartOfDay(timezone)  
@OpenSearchIntegTestCase.SuiteScopeTestCase
        List<? extends Bucket> buckets = deriv.getBuckets();
import static org.hamcrest.core.IsNull.notNullValue;
        assertThat((ZonedDateTime) bucket.getKey(), equalTo(key));  
        assertThat((ZonedDateTime) bucket.getKey(), equalTo(key));
        sum = bucket.getAggregations().get("sum");  
import static org.hamcrest.core.IsNull.nullValue;
    }
            )
        bucket = buckets.get(2);
import static org.hamcrest.Matchers.equalTo;
            .addAggregation(  
        key = ZonedDateTime.of(2012, 2, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        ensureSearchable();  
        assertThat(docCountDeriv, notNullValue());  
                    .subAggregation(derivative("deriv", "_count").unit(DateHistogramInterval.DAY))
        List<IndexRequestBuilder> builders = new ArrayList<>();  
        assertThat(sum.getValue(), equalTo(15.0));
        assertThat(docCountDeriv, nullValue());
        assertThat(deriv.getBuckets().size(), equalTo(0));
import java.util.List;
        assertThat(docCountDeriv.value(), equalTo(2.0));  
    /**  
                    .timeZone(timezone)  
            .get();  
        assertBucket(buckets.get(3), expectedKeyFourthBucket, 4L, notNullValue(), 1d, 1d / 24d);
        ensureSearchable();  
        assertBucket(buckets.get(1), expectedKeySecondBucket, 2L, notNullValue(), 1d, 1d / 24d);  
        indexRandom(true, builders);
        createIndex(IDX_DST_END);
                dateHistogram("histo").field("dates")  
        docCountDeriv = bucket.getAggregations().get("deriv");  
        addNTimes(1, IDX_DST_START, DateFormatters.from(formatter.parse("2012-03-24T01:00:00")), builders);
            .withZoneSameInstant(ZoneOffset.UTC);  
            assertThat(docCountDeriv.normalizedValue(), closeTo(normalizedDerivative, 0.00001));
    ) {  
                    .subAggregation(derivative("deriv", "_count").unit(DateHistogramInterval.HOUR))
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    .minDocCount(0)  
            .withZoneSameInstant(ZoneOffset.UTC);
    }
        );  
        // day with dst shift, only 23h long  
        assertThat(docCountDeriv, nullValue());
        ZonedDateTime expectedKeyFirstBucket = LocalDate.from(dateFormatter.parse("2012-10-27"))
        assertThat(bucket, notNullValue());  
/*
        DateFormatter dateFormatter = DateFormatter.forPattern("uuuu-MM-dd");
import java.io.IOException;
        assertThat(deriv.getName(), equalTo("histo"));
        assertBucket(buckets.get(3), expectedKeyFourthBucket, 4L, notNullValue(), 1d, 1d / 24d);  
            ((InternalMultiBucketAggregation.InternalBucket) bucket).getProperty(
        docCountDeriv = bucket.getAggregations().get("deriv");  
import org.opensearch.search.aggregations.bucket.histogram.Histogram.Bucket;  
    private static final String IDX_DST_KATHMANDU = "idx_dst_kathmandu";
        assertThat(deriv, notNullValue());
        assertThat(bucket.getAggregations().asList().isEmpty(), is(false));
        List<? extends Bucket> buckets = deriv.getBuckets();
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
 * this file be licensed under the Apache-2.0 license or a
            .withZoneSameInstant(ZoneOffset.UTC);
        deriv = bucket.getAggregations().get("deriv");  
                    .subAggregation(derivative("deriv", "_count").unit(DateHistogramInterval.MINUTE))
        bucket = buckets.get(1);
            equalTo(10.0)
        addNTimes(2, IDX_DST_START, DateFormatters.from(formatter.parse("2012-03-25T01:00:00")), builders);
        ZonedDateTime expectedKeyFourthBucket = LocalDate.from(dateFormatter.parse("2012-03-27"))  
        Histogram.Bucket bucket,  
import org.opensearch.common.time.DateFormatters;
        assertThat((ZonedDateTime) bucket.getKey(), equalTo(key));  
 * Modifications Copyright OpenSearch Contributors. See
        assertSearchResponse(response);  
        super(staticSettings);
                    .dateHistogramInterval(DateHistogramInterval.MONTH)
import static org.hamcrest.Matchers.is;  
        assertSearchResponse(response);
                    .minDocCount(0)
                    .minDocCount(0)
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramInterval;
        assertThat(bucket.getAggregations().asList().isEmpty(), is(false));
        indexRandom(true, builders);
        bucket = buckets.get(3);  
    public void testSingleValuedFieldNormalised_timeZone_AsiaKathmandu() throws Exception {  
import org.opensearch.action.search.SearchResponse;
    }
        ZoneId timezone = ZoneId.of("Asia/Kathmandu");
        assertThat(docCountDeriv.value(), equalTo(1.0));
            .atStartOfDay(timezone)
            .atStartOfDay(timezone)
            .withZoneSameInstant(ZoneOffset.UTC);
            .atZone(timezone)  
        Sum sum = bucket.getAggregations().get("sum");
     */  
}
        SearchResponse response = client().prepareSearch("idx")  
        assertThat(bucket.getAggregations().asList().isEmpty(), is(false));  
            .addAggregation(  
            .atZone(timezone)
        key = ZonedDateTime.of(2012, 3, 1, 0, 0, 0, 0, ZoneOffset.UTC);
            )  
        assertThat(
        assertThat(bucket.getDocCount(), equalTo(3L));  
        Histogram deriv = response.getAggregations().get("histo");
        assertThat(deriv, nullValue());
                    .minDocCount(0)  
                    .timeZone(timezone)
        assertThat(docCountDeriv.value(), equalTo(2.0));
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        assertThat(deriv, notNullValue());
        ZonedDateTime key = ZonedDateTime.of(2012, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);  
        ZonedDateTime key = ZonedDateTime.of(2012, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_AUTO).build() },
        assertThat(buckets.size(), equalTo(3));
    @After  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        internalCluster().wipeIndices(IDX_DST_START, IDX_DST_END, IDX_DST_KATHMANDU);
        assertThat(bucket, notNullValue());
    private static IndexRequestBuilder indexDoc(String idx, ZonedDateTime date, int value) throws Exception {
 *  
        createIndex("idx_unmapped");
        indexRandom(true, builders);
     * "Asia/Kathmandu, 1 Jan 1986 - Time Zone Change (IST → NPT), at 00:00:00 clocks were turned forward 00:15 minutes
        assertThat(docCountDeriv.normalizedValue(), closeTo(1d / 31d, 0.00001));  
        assertSearchResponse(response);  
 *    http://www.apache.org/licenses/LICENSE-2.0
        Histogram.Bucket bucket = buckets.get(0);
        SimpleValue docCountDeriv = bucket.getAggregations().get("deriv");
        ZonedDateTime expectedKeyFourthBucket = LocalDateTime.from(dateFormatter.parse("1986-01-01T02:00:00"))
        assertThat(bucket, notNullValue());  
        addNTimes(2, IDX_DST_KATHMANDU, DateFormatters.from(formatter.parse("1985-12-31T23:30:00")), builders);
        assertBucket(buckets.get(0), expectedKeyFirstBucket, 1L, nullValue(), null, null);
            .get();  
                dateHistogram("histo").field("date")
        assertBucket(buckets.get(0), expectedKeyFirstBucket, 1L, nullValue(), null, null);
                "histo",  
        assertThat((long) propertiesDocCounts[1], equalTo(2L));  
        ); // date: Mar 23, dates: Mar 23, Apr 24
 * The OpenSearch Contributors require contributions made to  
        ZonedDateTime expectedKeyThirdBucket = LocalDateTime.from(dateFormatter.parse("1986-01-01T01:00:00"))  
            builders.add(
            .atStartOfDay(timezone)
        assertThat(deriv.value(), equalTo(10.0));
                    .dateHistogramInterval(DateHistogramInterval.MONTH)
        assertBucket(buckets.get(2), expectedKeyThirdBucket, 3L, notNullValue(), 1d, 1d / 23d);
        assertThat((double) propertiesCounts[2], equalTo(15.0));  
        assertThat(buckets.size(), equalTo(4));
            .withZoneSameInstant(ZoneOffset.UTC);  
        }  
        assertThat(bucket.getDocCount(), equalTo(1L));
        assertThat((ZonedDateTime) propertiesKeys[2], equalTo(key));
    // some index names used during these tests
        assertThat(docCountDeriv, nullValue());
            .setSource(
        // the following is normalized using a 23h bucket width  
    private static final String IDX_DST_START = "idx_dst_start";
                    .minDocCount(0)
        assertThat(bucket.getDocCount(), equalTo(3L));
import java.time.ZonedDateTime;
        assertThat(deriv, notNullValue());  
        DateFormatter formatter = DateFormatter.forPattern("uuuu-MM-dd'T'HH:mm:ss").withZone(timezone);
        assertThat(docCountDeriv.value(), equalTo(-2.0));
        // the following is normalized using a 25h bucket width
                    .subAggregation(derivative("deriv", "_count"))
        ZonedDateTime expectedKeyThirdBucket = LocalDate.from(dateFormatter.parse("2012-03-26"))
        assertThat(bucket, notNullValue());  
        docCountDeriv = bucket.getAggregations().get("deriv");  
        DateFormatter dateFormatter = DateFormatter.forPattern("uuuu-MM-dd'T'HH:mm:ss").withZone(ZoneOffset.UTC);
     */
                dateHistogram("histo").field("date")
        assertThat(docCountDeriv, notNullValue());
import org.junit.After;  
import java.time.LocalDate;  
            )  
        Object[] propertiesKeys = (Object[]) ((InternalAggregation) histo).getProperty("_key");  
        assertBucket(buckets.get(3), expectedKeyFourthBucket, 4L, notNullValue(), 1d, 1d / 60d);
                "histo",
    }  
 * GitHub history for details.
import java.time.LocalDateTime;
            .get();  
        assertThat((ZonedDateTime) bucket.getKey(), equalTo(key));
        SimpleValue docCountDeriv = bucket.getAggregations().get("deriv");
        ZonedDateTime expectedKeySecondBucket = LocalDate.from(dateFormatter.parse("2012-10-28"))  
                indexDoc(1, 2, 1), // date: Jan 2, dates: Jan 2, Feb 3  
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
            .withZoneSameInstant(ZoneOffset.UTC);
        assertThat(deriv.getName(), equalTo("histo"));  
        bucket = buckets.get(2);  
        assertThat(bucket, notNullValue());
            )  
        assertBucket(buckets.get(1), expectedKeySecondBucket, 2L, notNullValue(), 1d, 1d / 24d);
        addNTimes(4, IDX_DST_START, DateFormatters.from(formatter.parse("2012-03-27T01:00:00")), builders);  
        assertThat(docCountDeriv, notNullValue());
        assertThat(bucket, notNullValue());  
        assertSearchResponse(response);
        Histogram deriv = response.getAggregations().get("histo");
            .addAggregation(
