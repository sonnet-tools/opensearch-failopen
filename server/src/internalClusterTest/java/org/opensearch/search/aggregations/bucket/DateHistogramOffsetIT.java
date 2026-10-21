 * Licensed to Elasticsearch under one or more contributor
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
    /**
import java.io.IOException;
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
     * @param key the expected key
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
            )
                    .offset("6h")
import java.util.Collection;
    public void testSingleValueWithOffsetMinDocCount() throws Exception {
    public void testSingleValueWithNegativeOffset() throws Exception {
/**
     * @param bucket the bucket to check assertions for
 * under the License.
            .get();
 *    http://www.apache.org/licenses/LICENSE-2.0
                dateHistogram("date_histo").field("date").offset("2h").format(DATE_FORMAT).dateHistogramInterval(DateHistogramInterval.DAY)
        assertThat(bucket.getKeyAsString(), equalTo(FORMATTER.format(key)));
 * The serialisation of offsets for the date histogram aggregation was corrected in version 1.4 to allow negative offsets and as such the
 *
@OpenSearchIntegTestCase.SuiteScopeTestCase
import static org.hamcrest.core.IsNull.notNullValue;
 * tests using all versions
                .setId("" + i)
        prepareIndex(date("2014-03-11T00:00:00+00:00"), 5, -1, 0);
        prepareIndex(date("2014-03-11T00:00:00+00:00"), 12, 1, 0);
    public void afterEachTest() throws IOException {
 * The OpenSearch Contributors require contributions made to
 * DateHistogramTests so the AssertingLocalTransport for these tests can be set to only use versions 1.4 onwards while keeping the other
            .addAggregation(
 * ownership. Elasticsearch licenses this file to you under
        assertThat(buckets.size(), equalTo(2));
}
     * @param expectedSize the expected size of the bucket
        List<? extends Histogram.Bucket> buckets = histo.getBuckets();
        return Arrays.asList(
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
 * license agreements. See the NOTICE file distributed with
        SearchResponse response = client().prepareSearch("idx2")
    /**
     */
            .setQuery(matchAllQuery())
            )
        indexRandom(true, reqs);
 * this work for additional information regarding copyright
import java.util.List;
 * this file be licensed under the Apache-2.0 license or a
 *
        checkBucketFor(buckets.get(0), ZonedDateTime.of(2014, 3, 10, 6, 0, 0, 0, ZoneOffset.UTC), 6L);
        for (int i = idxIdStart; i < idxIdStart + reqs.length; i++) {
import java.time.ZonedDateTime;
        prepareIndex(date("2014-03-11T00:00:00+00:00"), 5, 1, 0);
import org.junit.After;
    }
                dateHistogram("date_histo").field("date")
    public static Collection<Object[]> parameters() {
        assertThat(buckets.size(), equalTo(2));
import org.opensearch.action.search.SearchResponse;
        Histogram histo = response.getAggregations().get("date_histo");
        checkBucketFor(buckets.get(3), ZonedDateTime.of(2014, 3, 13, 6, 0, 0, 0, ZoneOffset.UTC), 6L);
            .addAggregation(
    }
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
package org.opensearch.search.aggregations.bucket;
    public DateHistogramOffsetIT(Settings staticSettings) {
 */
 * SPDX-License-Identifier: Apache-2.0
    }
 *
/*
        checkBucketFor(buckets.get(2), ZonedDateTime.of(2014, 3, 12, 6, 0, 0, 0, ZoneOffset.UTC), 0L);
    @After
 * compatible open source license.
                    .format(DATE_FORMAT)
            .setQuery(matchAllQuery())
import static org.opensearch.search.aggregations.AggregationBuilders.dateHistogram;
import static org.hamcrest.Matchers.equalTo;
    public void beforeEachTest() throws IOException {
        assertThat(buckets.size(), equalTo(5));
 * GitHub history for details.
            .setQuery(matchAllQuery())
    @ParametersFactory
    private static void checkBucketFor(Histogram.Bucket bucket, ZonedDateTime key, long expectedSize) {
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
            .get();
            )
                    .dateHistogramInterval(DateHistogramInterval.DAY)
     * Set offset so day buckets start at 6am. Index first 12 hours for two days, with one day gap.
        checkBucketFor(buckets.get(0), ZonedDateTime.of(2014, 3, 10, 2, 0, 0, 0, ZoneOffset.UTC), 2L);
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramInterval;
        checkBucketFor(buckets.get(0), ZonedDateTime.of(2014, 3, 9, 22, 0, 0, 0, ZoneOffset.UTC), 2L);
        SearchResponse response = client().prepareSearch("idx2")
        );
        checkBucketFor(buckets.get(4), ZonedDateTime.of(2014, 3, 14, 6, 0, 0, 0, ZoneOffset.UTC), 6L);
    }
                dateHistogram("date_histo").field("date").offset("-2h").format(DATE_FORMAT).dateHistogramInterval(DateHistogramInterval.DAY)
    }
        assertThat(bucket, notNullValue());
    }
    }
        checkBucketFor(buckets.get(1), ZonedDateTime.of(2014, 3, 10, 22, 0, 0, 0, ZoneOffset.UTC), 3L);
        List<? extends Histogram.Bucket> buckets = histo.getBuckets();
 * not use this file except in compliance with the License.
import org.opensearch.action.index.IndexRequestBuilder;
        assertThat(response.getHits().getTotalHits().value(), equalTo(5L));
    private static final String DATE_FORMAT = "yyyy-MM-dd:hh-mm-ss";
import org.opensearch.test.OpenSearchIntegTestCase;
        assertThat(response.getHits().getTotalHits().value(), equalTo(24L));
        InterruptedException {
    }
        }
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
    private ZonedDateTime date(String date) {
    private static final DateFormatter FORMATTER = DateFormatter.forPattern(DATE_FORMAT);
        super(staticSettings);
     */
            .get();
        prepareCreate("idx2").setMapping("date", "type=date").get();
public class DateHistogramOffsetIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
import org.opensearch.index.mapper.DateFieldMapper;
        assertThat(bucket.getDocCount(), equalTo(expectedSize));
 * Modifications Copyright OpenSearch Contributors. See
        internalCluster().wipeIndices("idx2");
    public void testSingleValueWithPositiveOffset() throws Exception {
                    .minDocCount(0)
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE)
 */
import java.time.ZoneOffset;
        SearchResponse response = client().prepareSearch("idx2")
        checkBucketFor(buckets.get(1), ZonedDateTime.of(2014, 3, 11, 6, 0, 0, 0, ZoneOffset.UTC), 6L);
    @Before
        prepareIndex(date("2014-03-14T00:00:00+00:00"), 12, 1, 13);
 */
    }
        IndexRequestBuilder[] reqs = new IndexRequestBuilder[numHours];
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
/*
 * specific language governing permissions and limitations
 * KIND, either express or implied.  See the License for the
 */
import org.junit.Before;
        checkBucketFor(buckets.get(1), ZonedDateTime.of(2014, 3, 11, 2, 0, 0, 0, ZoneOffset.UTC), 3L);
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            .addAggregation(
        return DateFormatters.from(DateFieldMapper.getDefaultDateTimeFormatter().parse(date));
import org.opensearch.common.time.DateFormatter;
 * software distributed under the License is distributed on an
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
import java.util.Arrays;
    private void prepareIndex(ZonedDateTime date, int numHours, int stepSizeHours, int idxIdStart) throws IOException,
        Histogram histo = response.getAggregations().get("date_histo");
            date = date.plusHours(stepSizeHours);
                .setSource(jsonBuilder().startObject().timeField("date", date).endObject());
import org.opensearch.common.settings.Settings;
 * Unless required by applicable law or agreed to in writing,
        List<? extends Histogram.Bucket> buckets = histo.getBuckets();
/*
            reqs[i - idxIdStart] = client().prepareIndex("idx2")
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at
        Histogram histo = response.getAggregations().get("date_histo");
import org.opensearch.common.time.DateFormatters;
        assertThat(response.getHits().getTotalHits().value(), equalTo(5L));
 * serialisation of negative offsets in these tests would break in pre 1.4 versions.  These tests are separated from the other
