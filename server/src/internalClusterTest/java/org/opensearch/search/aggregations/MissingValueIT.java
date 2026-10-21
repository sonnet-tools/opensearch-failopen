            new Object[] {
        assertSearchResponse(response);
            response = client().prepareSearch("idx").addAggregation(terms("my_terms").field("str").missing("foo")).get();
 * Unless required by applicable law or agreed to in writing,
        response = client().prepareSearch("idx").addAggregation(histogram("my_histogram").field("long").interval(5).missing(3)).get();
            .get();
        for (ExecutionMode mode : ExecutionMode.values()) {
import org.opensearch.test.OpenSearchIntegTestCase;
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramInterval;
    }
        assertEquals(0d, histogram.getBuckets().get(0).getKey());
    public void testStats() {
 * the Apache License, Version 2.0 (the "License"); you may
        terms = response.getAggregations().get("my_terms");
 * not use this file except in compliance with the License.
        assertEquals(1, histogram.getBuckets().size());
        assertEquals(1, terms.getBuckets().size());
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_ALL).build() },
        SearchResponse response = client().prepareSearch("idx").addAggregation(stats("stats").field("long").missing(5)).get();
 *
    }
package org.opensearch.search.aggregations;
        response = client().prepareSearch("idx").addAggregation(terms("my_terms").field("double").missing(5.5)).get();
        assertEquals(1, terms.getBuckets().size());
 * under the License.
    }
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.search.aggregations.metrics.Stats;
    }
            assertEquals(1, terms.getBucketByKey("foo").getDocCount());
            .get();
    }
        assertEquals(1, histogram.getBuckets().size());
        assertEquals(2, histogram.getBuckets().size());
        assertEquals(2, cardinality.getValue());
import org.opensearch.search.aggregations.metrics.Percentiles;
        assertEquals(1, terms.getBucketByKey("5.5").getDocCount());
 * You may obtain a copy of the License at
        SearchResponse response = client().prepareSearch("idx")
        assertEquals(2, terms.getBuckets().size());
        assertSearchResponse(response);
    }
        assertEquals(1, histogram.getBuckets().get(0).getDocCount());
        histogram = response.getAggregations().get("my_histogram");
        GeoCentroid centroid = response.getAggregations().get("centroid");
import static org.opensearch.search.aggregations.AggregationBuilders.stats;
    public void testDateHistogram() {
    @Override
        assertEquals(2, histogram.getBuckets().get(0).getDocCount());
            .get();
        assertEquals("2015-01-01T00:00:00.000Z", histogram.getBuckets().get(0).getKeyAsString());
import org.opensearch.search.aggregations.metrics.GeoCentroid;
        assertEquals(2, histogram.getBuckets().get(0).getDocCount());
        assertEquals(2, histogram.getBuckets().get(0).getDocCount());
    }
        Histogram histogram = response.getAggregations().get("my_histogram");
        assertEquals("2014-01-01T00:00:00.000Z", histogram.getBuckets().get(0).getKeyAsString());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            assertEquals(2, terms.getBuckets().size());
            .addAggregation(percentiles("percentiles").field("long").missing(1000))
        SearchResponse response = client().prepareSearch("idx").addAggregation(terms("my_terms").field("double").missing(4.5)).get();
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_AUTO).build() },
        );
        }
            .addAggregation(histogram("my_histogram").field("non-existing_field").interval(5).missing(12))
/*
        assertSearchResponse(response);
            .get();
 *
 * ownership. Elasticsearch licenses this file to you under
        assertSearchResponse(response);
import org.opensearch.common.geo.GeoPoint;
        assertAcked(prepareCreate("idx").setMapping("date", "type=date", "location", "type=geo_point", "str", "type=keyword").get());
    }
                .addAggregation(terms("my_terms").field("str").executionHint(mode.toString()).missing("bar"))
            assertSearchResponse(response);
        assertEquals(1000, percentiles.percentile(100), 0);
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_NONE;
/*
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        Terms terms = response.getAggregations().get("my_terms");
        Histogram histogram = response.getAggregations().get("my_histogram");
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_ALL;
            .addAggregation(histogram("my_histogram").field("long").interval(5).missing(7))
 */
        assertSearchResponse(response);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        assertSearchResponse(response);
            client().prepareIndex("idx").setId("1").setSource(),
        assertSearchResponse(response);
        assertEquals(2, terms.getBuckets().size());
    public void testCardinality() {
            .get();
    protected int maximumNumberOfShards() {
import static org.opensearch.search.aggregations.AggregationBuilders.cardinality;
        assertEquals(2, terms.getBucketByKey("5.5").getDocCount());
 * specific language governing permissions and limitations
        assertEquals(10d, histogram.getBuckets().get(0).getKey());
    protected void setupSuiteScopeCluster() throws Exception {
            Terms terms = response.getAggregations().get("my_terms");
        SearchResponse response = client().prepareSearch("idx")
import org.opensearch.common.settings.Settings;
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
        assertSearchResponse(response);
        GeoPoint point = new GeoPoint(1.5, 1.5);
        assertThat(point.lat(), closeTo(centroid.centroid().lat(), 1E-5));
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            .addAggregation(dateHistogram("my_histogram").field("date").calendarInterval(DateHistogramInterval.YEAR).missing("2014-05-07"))
 * GitHub history for details.
        Stats stats = response.getAggregations().get("stats");
        assertEquals(4, stats.getAvg(), 0);
            .get();
import org.opensearch.search.aggregations.bucket.terms.Terms;
    @Override
            terms = response.getAggregations().get("my_terms");
        assertEquals(1, histogram.getBuckets().size());
        SearchResponse response = client().prepareSearch("idx")
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_NONE).build() }
        );
        SearchResponse response = client().prepareSearch("idx").addAggregation(terms("my_terms").field("long").missing(4)).get();
    }
        super(staticSettings);
        assertEquals(2, stats.getCount());
            client().prepareIndex("idx")
            .addAggregation(terms("my_terms").field("non_existing_field").missing("bar"))
            assertSearchResponse(response);
                .setId("2")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
    }
    }
        assertSearchResponse(response);
import java.util.Arrays;
        Cardinality cardinality = response.getAggregations().get("card");
            new Object[] {
        histogram = response.getAggregations().get("my_histogram");
import org.opensearch.action.search.SearchResponse;
import org.opensearch.search.aggregations.metrics.Cardinality;
 * Licensed to Elasticsearch under one or more contributor
        assertEquals(2, terms.getBucketByKey("3").getDocCount());
import org.opensearch.search.aggregations.bucket.terms.TermsAggregatorFactory.ExecutionMode;
import static org.opensearch.search.aggregations.AggregationBuilders.percentiles;
            new Object[] {
/*
        assertEquals(1, terms.getBucketByKey("3").getDocCount());
    public void testDoubleTerms() {
        assertEquals(1, terms.getBucketByKey("4").getDocCount());
@OpenSearchIntegTestCase.SuiteScopeTestCase
    }
 * Modifications Copyright OpenSearch Contributors. See
                .setSource("str", "foo", "long", 3L, "double", 5.5, "date", "2015-05-07", "location", "1,2")
 * compatible open source license.
        SearchResponse response = client().prepareSearch("idx").addAggregation(cardinality("card").field("long").missing(2)).get();
        assertSearchResponse(response);
        assertEquals(2, histogram.getBuckets().size());
    public void testStringTerms() {
        SearchResponse response = client().prepareSearch("idx")
            SearchResponse response = client().prepareSearch("idx")
        assertSearchResponse(response);
        indexRandom(
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
        assertSearchResponse(response);
        assertEquals(1, histogram.getBuckets().get(0).getDocCount());
 */
            .get();
 * SPDX-License-Identifier: Apache-2.0
        SearchResponse response = client().prepareSearch("idx")
            true,
    }
 *
    }
    public void testPercentiles() {
    public void testGeoCentroid() {
 * KIND, either express or implied.  See the License for the
            .addAggregation(dateHistogram("my_histogram").field("date").calendarInterval(DateHistogramInterval.YEAR).missing("2015-05-07"))
        response = client().prepareSearch("idx").addAggregation(terms("my_terms").field("long").missing(3)).get();
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE;
import static org.opensearch.search.aggregations.AggregationBuilders.dateHistogram;
        assertSearchResponse(response);
import static org.opensearch.search.aggregations.AggregationBuilders.geoCentroid;
    public void testUnmappedTerms() {
    public MissingValueIT(Settings staticSettings) {
            assertEquals(1, terms.getBuckets().size());
        Histogram histogram = response.getAggregations().get("my_histogram");
        Terms terms = response.getAggregations().get("my_terms");
        terms = response.getAggregations().get("my_terms");
    public static Collection<Object[]> parameters() {
        assertEquals(2, terms.getBucketByKey("bar").getDocCount());
 * this file be licensed under the Apache-2.0 license or a
public class MissingValueIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        assertEquals(1, histogram.getBuckets().get(1).getDocCount());
        assertSearchResponse(response);
    public void testHistogram() {
 * software distributed under the License is distributed on an
        Percentiles percentiles = response.getAggregations().get("percentiles");
import java.util.Collection;
        return Arrays.asList(
            assertEquals(2, terms.getBucketByKey("foo").getDocCount());
        assertEquals(1, histogram.getBuckets().get(1).getDocCount());
        assertEquals(0d, histogram.getBuckets().get(0).getKey());
}
        SearchResponse response = client().prepareSearch("idx")
        Terms terms = response.getAggregations().get("my_terms");
        assertEquals("2015-01-01T00:00:00.000Z", histogram.getBuckets().get(1).getKeyAsString());
    }
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_AUTO;
 * this work for additional information regarding copyright
        response = client().prepareSearch("idx")
        assertEquals(1, terms.getBuckets().size());
        assertEquals(1, terms.getBucketByKey("4.5").getDocCount());
 * license agreements. See the NOTICE file distributed with
            .addAggregation(geoCentroid("centroid").field("location").missing("2,1"))
                .get();
    @ParametersFactory
    public void testUnmappedHistogram() {
import static org.hamcrest.Matchers.closeTo;
            assertEquals(1, terms.getBucketByKey("bar").getDocCount());
        assertThat(point.lon(), closeTo(centroid.centroid().lon(), 1E-5));
        return 2;
 * The OpenSearch Contributors require contributions made to
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
        assertEquals(5d, histogram.getBuckets().get(1).getKey());
    public void testLongTerms() {
