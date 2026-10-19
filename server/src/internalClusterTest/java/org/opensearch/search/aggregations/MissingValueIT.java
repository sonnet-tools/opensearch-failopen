 * ownership. Elasticsearch licenses this file to you under  
            true,  
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("2015-01-01T00:00:00.000Z", histogram.getBuckets().get(1).getKeyAsString());
            .get();  
/*
                .setId("2")  
            .addAggregation(dateHistogram("my_histogram").field("date").calendarInterval(DateHistogramInterval.YEAR).missing("2015-05-07"))  
        assertAcked(prepareCreate("idx").setMapping("date", "type=date", "location", "type=geo_point", "str", "type=keyword").get());
        assertEquals(1, terms.getBucketByKey("4.5").getDocCount());  
 * compatible open source license.
 */  
package org.opensearch.search.aggregations;
import static org.opensearch.search.aggregations.AggregationBuilders.geoCentroid;
            .addAggregation(histogram("my_histogram").field("long").interval(5).missing(7))
/*  
        assertSearchResponse(response);  
    protected int maximumNumberOfShards() {
 * license agreements. See the NOTICE file distributed with
@OpenSearchIntegTestCase.SuiteScopeTestCase
import static org.opensearch.search.aggregations.AggregationBuilders.terms;  
        );
        assertEquals(2, terms.getBucketByKey("5.5").getDocCount());
    }
        assertSearchResponse(response);
import org.opensearch.action.search.SearchResponse;  
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramInterval;  
            response = client().prepareSearch("idx").addAggregation(terms("my_terms").field("str").missing("foo")).get();
        }
        SearchResponse response = client().prepareSearch("idx")  
        assertEquals(2, terms.getBuckets().size());
    public void testPercentiles() {
}
    }
        assertEquals(2, histogram.getBuckets().get(0).getDocCount());  
        for (ExecutionMode mode : ExecutionMode.values()) {
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_AUTO;
    public void testHistogram() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertSearchResponse(response);
        SearchResponse response = client().prepareSearch("idx")
        response = client().prepareSearch("idx").addAggregation(histogram("my_histogram").field("long").interval(5).missing(3)).get();  
    }
import static org.opensearch.search.aggregations.AggregationBuilders.percentiles;
        terms = response.getAggregations().get("my_terms");
        assertSearchResponse(response);  
 *  
            assertEquals(1, terms.getBucketByKey("foo").getDocCount());
 *    http://www.apache.org/licenses/LICENSE-2.0
            .addAggregation(terms("my_terms").field("non_existing_field").missing("bar"))
        assertEquals(1, terms.getBuckets().size());  
    public void testGeoCentroid() {  
    }
        assertEquals(1, terms.getBucketByKey("4").getDocCount());
        assertEquals(1, histogram.getBuckets().size());  
import org.opensearch.search.aggregations.metrics.GeoCentroid;
 * under the License.  
        assertEquals(2, histogram.getBuckets().size());  
    public void testLongTerms() {
 * this work for additional information regarding copyright
        assertEquals(2, cardinality.getValue());
import org.opensearch.search.aggregations.metrics.Cardinality;
 * software distributed under the License is distributed on an
        assertEquals(2, histogram.getBuckets().get(0).getDocCount());
            .get();
        assertEquals(1, histogram.getBuckets().get(0).getDocCount());
    public void testStats() {
            assertEquals(1, terms.getBucketByKey("bar").getDocCount());  
 * KIND, either express or implied.  See the License for the
        Histogram histogram = response.getAggregations().get("my_histogram");
            new Object[] {  
 * specific language governing permissions and limitations
import java.util.Arrays;
        Histogram histogram = response.getAggregations().get("my_histogram");
        SearchResponse response = client().prepareSearch("idx").addAggregation(terms("my_terms").field("double").missing(4.5)).get();
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            assertSearchResponse(response);  
        assertThat(point.lat(), closeTo(centroid.centroid().lat(), 1E-5));
            new Object[] {
    }  
 */  
        return 2;
        assertEquals(10d, histogram.getBuckets().get(0).getKey());
        assertEquals(1, terms.getBuckets().size());  
        response = client().prepareSearch("idx")
            assertEquals(2, terms.getBucketByKey("foo").getDocCount());  
 *
import org.opensearch.search.aggregations.metrics.Stats;
        Terms terms = response.getAggregations().get("my_terms");
        assertSearchResponse(response);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            .get();
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
            .get();  
        assertEquals(0d, histogram.getBuckets().get(0).getKey());
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;  
    }
        assertSearchResponse(response);
        return Arrays.asList(
        assertSearchResponse(response);  
        assertSearchResponse(response);  
        assertEquals(2, histogram.getBuckets().get(0).getDocCount());  
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_ALL).build() },
        assertEquals(1000, percentiles.percentile(100), 0);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
            assertEquals(2, terms.getBuckets().size());
        histogram = response.getAggregations().get("my_histogram");  
        super(staticSettings);  
            client().prepareIndex("idx").setId("1").setSource(),
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_ALL;  
        assertEquals(1, terms.getBucketByKey("3").getDocCount());  
import static org.opensearch.search.aggregations.AggregationBuilders.dateHistogram;
 * not use this file except in compliance with the License.
        assertEquals("2015-01-01T00:00:00.000Z", histogram.getBuckets().get(0).getKeyAsString());
            .get();
import static org.opensearch.search.aggregations.AggregationBuilders.stats;
 * GitHub history for details.
            SearchResponse response = client().prepareSearch("idx")
            .addAggregation(histogram("my_histogram").field("non-existing_field").interval(5).missing(12))  
import org.opensearch.test.OpenSearchIntegTestCase;
        assertEquals(2, terms.getBuckets().size());
        SearchResponse response = client().prepareSearch("idx").addAggregation(stats("stats").field("long").missing(5)).get();
            assertSearchResponse(response);
        assertEquals(1, histogram.getBuckets().get(0).getDocCount());
    }
        GeoCentroid centroid = response.getAggregations().get("centroid");
    public void testDateHistogram() {
import java.util.Collection;  
        response = client().prepareSearch("idx").addAggregation(terms("my_terms").field("long").missing(3)).get();  
    }
        Cardinality cardinality = response.getAggregations().get("card");  
        Stats stats = response.getAggregations().get("stats");
        Terms terms = response.getAggregations().get("my_terms");
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_NONE).build() }
            .addAggregation(dateHistogram("my_histogram").field("date").calendarInterval(DateHistogramInterval.YEAR).missing("2014-05-07"))
    @ParametersFactory  
    }
import static org.opensearch.search.aggregations.AggregationBuilders.cardinality;  
import org.opensearch.common.geo.GeoPoint;
        assertEquals(1, histogram.getBuckets().get(1).getDocCount());  
                .setSource("str", "foo", "long", 3L, "double", 5.5, "date", "2015-05-07", "location", "1,2")
 * Unless required by applicable law or agreed to in writing,
            terms = response.getAggregations().get("my_terms");
        response = client().prepareSearch("idx").addAggregation(terms("my_terms").field("double").missing(5.5)).get();  
        assertEquals(2, terms.getBucketByKey("3").getDocCount());
        Histogram histogram = response.getAggregations().get("my_histogram");  
        assertSearchResponse(response);
    }  
 * Modifications Copyright OpenSearch Contributors. See
            assertEquals(1, terms.getBuckets().size());
        assertSearchResponse(response);  
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(1, terms.getBucketByKey("5.5").getDocCount());
    }
        Terms terms = response.getAggregations().get("my_terms");
        indexRandom(
import org.opensearch.common.settings.Settings;
    public void testDoubleTerms() {
        SearchResponse response = client().prepareSearch("idx")
    @Override
    public static Collection<Object[]> parameters() {
public class MissingValueIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {  
        assertSearchResponse(response);
        SearchResponse response = client().prepareSearch("idx").addAggregation(terms("my_terms").field("long").missing(4)).get();
            client().prepareIndex("idx")
            .addAggregation(percentiles("percentiles").field("long").missing(1000))  
 */
        assertEquals(1, histogram.getBuckets().get(1).getDocCount());
        assertEquals(2, stats.getCount());
        assertEquals(2, terms.getBucketByKey("bar").getDocCount());  
        GeoPoint point = new GeoPoint(1.5, 1.5);  
        );  
            .addAggregation(geoCentroid("centroid").field("location").missing("2,1"))
        assertEquals(1, terms.getBuckets().size());
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;  
    }
            .get();
        assertSearchResponse(response);
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.search.aggregations.bucket.terms.TermsAggregatorFactory.ExecutionMode;  
            new Object[] {
        histogram = response.getAggregations().get("my_histogram");
        assertEquals(4, stats.getAvg(), 0);  
        SearchResponse response = client().prepareSearch("idx")
import org.opensearch.search.aggregations.bucket.terms.Terms;
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_AUTO).build() },  
        SearchResponse response = client().prepareSearch("idx").addAggregation(cardinality("card").field("long").missing(2)).get();
        assertEquals(1, histogram.getBuckets().size());
    @Override  
/*  
        assertEquals(0d, histogram.getBuckets().get(0).getKey());
        terms = response.getAggregations().get("my_terms");
            Terms terms = response.getAggregations().get("my_terms");  
        assertEquals(5d, histogram.getBuckets().get(1).getKey());  
            .get();
        assertEquals(1, histogram.getBuckets().size());
 *
        assertEquals("2014-01-01T00:00:00.000Z", histogram.getBuckets().get(0).getKeyAsString());  
    public MissingValueIT(Settings staticSettings) {
    public void testStringTerms() {  
    }  
        SearchResponse response = client().prepareSearch("idx")
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE;
    }  
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_NONE;
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals(2, histogram.getBuckets().size());
        SearchResponse response = client().prepareSearch("idx")  
                .get();
    protected void setupSuiteScopeCluster() throws Exception {  
        assertSearchResponse(response);
        assertSearchResponse(response);
                .addAggregation(terms("my_terms").field("str").executionHint(mode.toString()).missing("bar"))  
    public void testUnmappedTerms() {
        assertThat(point.lon(), closeTo(centroid.centroid().lon(), 1E-5));
    }
    public void testCardinality() {  
        Percentiles percentiles = response.getAggregations().get("percentiles");  
    public void testUnmappedHistogram() {
import static org.hamcrest.Matchers.closeTo;  
import org.opensearch.search.aggregations.metrics.Percentiles;  
