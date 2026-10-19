     * Set offset so day buckets start at 6am. Index first 12 hours for two days, with one day gap.
        assertThat(response.getHits().getTotalHits().value(), equalTo(5L));
     * @param key the expected key
        checkBucketFor(buckets.get(1), ZonedDateTime.of(2014, 3, 10, 22, 0, 0, 0, ZoneOffset.UTC), 3L);
     */  
            .get();
 * GitHub history for details.
import org.opensearch.common.time.DateFormatters;  
            .addAggregation(
        checkBucketFor(buckets.get(0), ZonedDateTime.of(2014, 3, 9, 22, 0, 0, 0, ZoneOffset.UTC), 2L);  
    /**
        checkBucketFor(buckets.get(4), ZonedDateTime.of(2014, 3, 14, 6, 0, 0, 0, ZoneOffset.UTC), 6L);
 * ownership. Elasticsearch licenses this file to you under  
    }
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        }
                    .offset("6h")  
import org.opensearch.index.mapper.DateFieldMapper;
 * Modifications Copyright OpenSearch Contributors. See  
                    .dateHistogramInterval(DateHistogramInterval.DAY)  
     * @param expectedSize the expected size of the bucket
    }
        assertThat(response.getHits().getTotalHits().value(), equalTo(5L));  
    }  
        List<? extends Histogram.Bucket> buckets = histo.getBuckets();
     * @param bucket the bucket to check assertions for  
 * not use this file except in compliance with the License.
        SearchResponse response = client().prepareSearch("idx2")
        SearchResponse response = client().prepareSearch("idx2")  
        prepareIndex(date("2014-03-14T00:00:00+00:00"), 12, 1, 13);  
 * Unless required by applicable law or agreed to in writing,
    public static Collection<Object[]> parameters() {
            .setQuery(matchAllQuery())  
 * software distributed under the License is distributed on an
        checkBucketFor(buckets.get(2), ZonedDateTime.of(2014, 3, 12, 6, 0, 0, 0, ZoneOffset.UTC), 0L);  
import java.io.IOException;  
}
            date = date.plusHours(stepSizeHours);
        internalCluster().wipeIndices("idx2");
    }
        IndexRequestBuilder[] reqs = new IndexRequestBuilder[numHours];
        );  
                dateHistogram("date_histo").field("date").offset("-2h").format(DATE_FORMAT).dateHistogramInterval(DateHistogramInterval.DAY)
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
 * You may obtain a copy of the License at  
 * the Apache License, Version 2.0 (the "License"); you may
public class DateHistogramOffsetIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        Histogram histo = response.getAggregations().get("date_histo");  
    public void beforeEachTest() throws IOException {
import org.opensearch.action.search.SearchResponse;  
    public void testSingleValueWithPositiveOffset() throws Exception {  
 * Licensed to Elasticsearch under one or more contributor  
    @ParametersFactory
 * tests using all versions  
        assertThat(buckets.size(), equalTo(2));
    private static final DateFormatter FORMATTER = DateFormatter.forPattern(DATE_FORMAT);
 * KIND, either express or implied.  See the License for the
        Histogram histo = response.getAggregations().get("date_histo");  
import java.util.List;
                    .format(DATE_FORMAT)
 * this work for additional information regarding copyright
/*
 */
 * specific language governing permissions and limitations
        for (int i = idxIdStart; i < idxIdStart + reqs.length; i++) {  
import java.util.Arrays;  
            .setQuery(matchAllQuery())  
import org.opensearch.action.index.IndexRequestBuilder;
import org.opensearch.search.aggregations.bucket.histogram.Histogram;  
    public void testSingleValueWithOffsetMinDocCount() throws Exception {
        List<? extends Histogram.Bucket> buckets = histo.getBuckets();
 * The OpenSearch Contributors require contributions made to  
            .addAggregation(
 * SPDX-License-Identifier: Apache-2.0
import org.junit.Before;
 *
        SearchResponse response = client().prepareSearch("idx2")
    }
    }  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE)  
        Histogram histo = response.getAggregations().get("date_histo");
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramInterval;
        assertThat(buckets.size(), equalTo(5));
        checkBucketFor(buckets.get(0), ZonedDateTime.of(2014, 3, 10, 6, 0, 0, 0, ZoneOffset.UTC), 6L);
        List<? extends Histogram.Bucket> buckets = histo.getBuckets();  
        assertThat(bucket.getDocCount(), equalTo(expectedSize));
import org.opensearch.test.OpenSearchIntegTestCase;
import java.util.Collection;
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;  
 * DateHistogramTests so the AssertingLocalTransport for these tests can be set to only use versions 1.4 onwards while keeping the other
        checkBucketFor(buckets.get(1), ZonedDateTime.of(2014, 3, 11, 2, 0, 0, 0, ZoneOffset.UTC), 3L);
    @After  
        assertThat(buckets.size(), equalTo(2));
        prepareIndex(date("2014-03-11T00:00:00+00:00"), 5, -1, 0);  
 */
 * compatible open source license.
        InterruptedException {  
        return Arrays.asList(  
                .setSource(jsonBuilder().startObject().timeField("date", date).endObject());  
            )
    }
        checkBucketFor(buckets.get(0), ZonedDateTime.of(2014, 3, 10, 2, 0, 0, 0, ZoneOffset.UTC), 2L);
    public DateHistogramOffsetIT(Settings staticSettings) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(response.getHits().getTotalHits().value(), equalTo(24L));
@OpenSearchIntegTestCase.SuiteScopeTestCase
            .setQuery(matchAllQuery())
            reqs[i - idxIdStart] = client().prepareIndex("idx2")
 * serialisation of negative offsets in these tests would break in pre 1.4 versions.  These tests are separated from the other
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
        return DateFormatters.from(DateFieldMapper.getDefaultDateTimeFormatter().parse(date));
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;  
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void afterEachTest() throws IOException {
    public void testSingleValueWithNegativeOffset() throws Exception {
import java.time.ZoneOffset;
            .get();
/**
        prepareIndex(date("2014-03-11T00:00:00+00:00"), 5, 1, 0);
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
import static org.hamcrest.core.IsNull.notNullValue;  
        prepareCreate("idx2").setMapping("date", "type=date").get();  
 *  
    @Before
    }  
    private static void checkBucketFor(Histogram.Bucket bucket, ZonedDateTime key, long expectedSize) {
 * under the License.  
 * license agreements. See the NOTICE file distributed with
    private static final String DATE_FORMAT = "yyyy-MM-dd:hh-mm-ss";  
/*
    }  
        indexRandom(true, reqs);  
 *
    private ZonedDateTime date(String date) {  
        checkBucketFor(buckets.get(3), ZonedDateTime.of(2014, 3, 13, 6, 0, 0, 0, ZoneOffset.UTC), 6L);
import static org.hamcrest.Matchers.equalTo;
                .setId("" + i)
import org.opensearch.common.settings.Settings;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
                    .minDocCount(0)
import org.opensearch.common.time.DateFormatter;
        checkBucketFor(buckets.get(1), ZonedDateTime.of(2014, 3, 11, 6, 0, 0, 0, ZoneOffset.UTC), 6L);
            .get();
/*  
    }
 */  
import org.junit.After;  
    private void prepareIndex(ZonedDateTime date, int numHours, int stepSizeHours, int idxIdStart) throws IOException,
                dateHistogram("date_histo").field("date").offset("2h").format(DATE_FORMAT).dateHistogramInterval(DateHistogramInterval.DAY)  
                dateHistogram("date_histo").field("date")
        prepareIndex(date("2014-03-11T00:00:00+00:00"), 12, 1, 0);
    /**
 * The serialisation of offsets for the date histogram aggregation was corrected in version 1.4 to allow negative offsets and as such the  
        assertThat(bucket.getKeyAsString(), equalTo(FORMATTER.format(key)));  
package org.opensearch.search.aggregations.bucket;
            )  
import java.time.ZonedDateTime;
        super(staticSettings);
     */  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
            )
import static org.opensearch.search.aggregations.AggregationBuilders.dateHistogram;
        assertThat(bucket, notNullValue());
 */
 * this file be licensed under the Apache-2.0 license or a
            .addAggregation(
