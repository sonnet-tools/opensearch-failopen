        Filter filter = response.getAggregations().get("filter");
 * this work for additional information regarding copyright
            )
            .get();
        Range range = response.getAggregations().get("range");
                    .subAggregation(dateHistogram("histo").field("date").dateHistogramInterval(DateHistogramInterval.DAY).minDocCount(0))
                    .subAggregation(dateHistogram("histo").field("date").dateHistogramInterval(DateHistogramInterval.DAY).minDocCount(0))
        assertThat(histo.getBuckets().size(), equalTo(4));
                    dateHistogram("histo").field("date").dateHistogramInterval(DateHistogramInterval.DAY).minDocCount(0)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        assertThat(histo.getBuckets().size(), equalTo(4));
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        indexRandom(true, indexDoc("2014-01-01", 1), indexDoc("2014-01-02", 2), indexDoc("2014-01-04", 3));
import static org.opensearch.search.aggregations.AggregationBuilders.nested;
                    .subAggregation(dateHistogram("histo").field("date").dateHistogramInterval(DateHistogramInterval.DAY).minDocCount(0))
public class ShardReduceIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
                    .field("date", date)
        );
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
                "type=keyword"
        Histogram histo = topHisto.getBuckets().get(0).getAggregations().get("histo");
 *
        ensureSearchable();
import java.util.Collection;
            .get();
            .addAggregation(
    public void testRange() throws Exception {
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;
import static org.opensearch.search.aggregations.AggregationBuilders.dateHistogram;
                            )
                    .field("term-l", 1)
                    .field("term-s", "term")
                    )
            .setQuery(QueryBuilders.matchAllQuery())
                    .addRange("r1", "10.0.0.1", "10.0.0.10")
                    .field("ip", "10.0.0." + value)
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
            .get();
/*
import static org.opensearch.search.aggregations.AggregationBuilders.dateRange;
    }
        SearchResponse response = client().prepareSearch("idx")
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramInterval;
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
    }
import static org.hamcrest.Matchers.equalTo;
    }
import org.opensearch.common.settings.Settings;
        assertThat(histo.getBuckets().size(), equalTo(4));
                    .addRange("r1", "2014-01-01", "2014-01-10")
        assertSearchResponse(response);
            )
        Histogram histo = terms.getBucketByKey("term").getAggregations().get("histo");
 * Modifications Copyright OpenSearch Contributors. See
                    .interval(5)
            )
            )
    @ParametersFactory
 * we can make sure that the reduce is properly propagated by checking that empty buckets were created.
        Histogram histo = range.getBuckets().get(0).getAggregations().get("histo");
            )
        Histogram histo = range.getBuckets().get(0).getAggregations().get("histo");
        Histogram histo = range.getBuckets().get(0).getAggregations().get("histo");
        assertSearchResponse(response);
        assertSearchResponse(response);
            .setQuery(QueryBuilders.matchAllQuery())
                "location",
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
                    .endObject()
    public void testIpRange() throws Exception {
        assertSearchResponse(response);
import static org.opensearch.search.aggregations.AggregationBuilders.ipRange;
            .addAggregation(
        Terms terms = response.getAggregations().get("terms");
            .get();
 * SPDX-License-Identifier: Apache-2.0
                    .subAggregation(dateHistogram("histo").field("date").dateHistogramInterval(DateHistogramInterval.DAY).minDocCount(0))
        Histogram histo = missing.getAggregations().get("histo");
import java.util.Arrays;
        assertThat(histo.getBuckets().size(), equalTo(4));
        Missing missing = filter.getAggregations().get("missing");
                )
            .setQuery(QueryBuilders.matchAllQuery())
 * software distributed under the License is distributed on an
        SearchResponse response = client().prepareSearch("idx")
            .addAggregation(
            )
            .addAggregation(
        Histogram histo = missing.getAggregations().get("histo");
 *
            .addAggregation(
import org.opensearch.action.search.SearchResponse;
 * These tests are based on the date histogram in combination of min_doc_count=0. In order for the date histogram to
    }
 *
            );
    public void testLongTerms() throws Exception {
    public void testGlobal() throws Exception {
import org.opensearch.search.aggregations.bucket.range.Range;
            )
        assertThat(histo.getBuckets().size(), equalTo(4));
 */
        assertThat(histo.getBuckets().size(), equalTo(4));
            .setQuery(QueryBuilders.matchAllQuery())
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
            .get();
                        missing("missing").field("foobar")
    @Override
        SearchResponse response = client().prepareSearch("idx")
            )
            .addAggregation(
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                            .subAggregation(
            .addAggregation(
import org.opensearch.action.index.IndexRequestBuilder;
        SearchResponse response = client().prepareSearch("idx")
import org.opensearch.index.query.QueryBuilders;
        assertThat(histo.getBuckets().size(), equalTo(4));
        Terms terms = response.getAggregations().get("terms");
                    .subAggregation(dateHistogram("histo").field("date").dateHistogramInterval(DateHistogramInterval.DAY).minDocCount(0))
        Terms terms = response.getAggregations().get("terms");
            .setQuery(QueryBuilders.matchAllQuery())
            .get();
                filter("filter", QueryBuilders.matchAllQuery()).subAggregation(
                terms("terms").field("term-d")
        return client().prepareIndex("idx")
}
        Histogram histo = terms.getBucketByKey("1.5").getAggregations().get("histo");
        assertSearchResponse(response);
    }
                "nested",
        SearchResponse response = client().prepareSearch("idx")
        assertThat(histo.getBuckets().size(), equalTo(4));
import org.opensearch.search.aggregations.bucket.missing.Missing;
                terms("terms").field("term-l")
 * Tests making sure that the reduce is propagated to all aggregations in the hierarchy when executing on a single shard
        Histogram histo = terms.getBucketByKey("1").getAggregations().get("histo");
        SearchResponse response = client().prepareSearch("idx")
            .setQuery(QueryBuilders.matchAllQuery())
        assertSearchResponse(response);
        return Arrays.asList(
        assertThat(histo.getBuckets().size(), equalTo(4));
    }
                histogram("topHisto").field("value")
        assertAcked(
            .setQuery(QueryBuilders.matchAllQuery())
        Histogram histo = nested.getAggregations().get("histo");
                    .addRange("r1", 0, 10)
                "ip",
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            .setQuery(QueryBuilders.matchAllQuery())
                "term-s",
            .get();
                global("global").subAggregation(
 * compatible open source license.
                    .field("date", date)
    public static Collection<Object[]> parameters() {
        assertThat(histo.getBuckets().size(), equalTo(4));
        Histogram topHisto = response.getAggregations().get("topHisto");
                )
@OpenSearchIntegTestCase.SuiteScopeTestCase
        Range range = response.getAggregations().get("range");
import org.opensearch.test.OpenSearchIntegTestCase;
        assertSearchResponse(response);
/*
 * compute empty buckets, its {@code reduce()} method must be called. So by adding the date histogram under other buckets,
import org.opensearch.search.aggregations.bucket.nested.Nested;
            .get();
                )
            .setQuery(QueryBuilders.matchAllQuery())
                    .field("value", value)
    }
 */
                missing("missing").field("foobar")
        SearchResponse response = client().prepareSearch("idx")
                    .field("location", Geohash.stringEncode(5, 52, Geohash.PRECISION))
                "type=nested",
    public void testNested() throws Exception {
        Missing missing = response.getAggregations().get("missing");
 * KIND, either express or implied.  See the License for the
/*
                    .subAggregation(dateHistogram("histo").field("date").dateHistogramInterval(DateHistogramInterval.DAY).minDocCount(0))
 */
            .addAggregation(
    public void testDateRange() throws Exception {
 * under the License.
                    .startObject("nested")
        SearchResponse response = client().prepareSearch("idx")
    }
        Global global = response.getAggregations().get("global");
        Range range = response.getAggregations().get("range");
import static org.opensearch.search.aggregations.AggregationBuilders.missing;
        super(staticSettings);
import static org.opensearch.search.aggregations.AggregationBuilders.global;
 * ownership. Elasticsearch licenses this file to you under
                                dateHistogram("histo").field("date").dateHistogramInterval(DateHistogramInterval.DAY).minDocCount(0)
        Histogram histo = global.getAggregations().get("histo");
    }
 * The OpenSearch Contributors require contributions made to
                "type=ip",
                    dateHistogram("histo").field("date").dateHistogramInterval(DateHistogramInterval.DAY).minDocCount(0)
            .get();
 * You may obtain a copy of the License at
        Histogram histo = topHisto.getBuckets().iterator().next().getAggregations().get("histo");
                dateHistogram("topHisto").field("date")
            )
        assertSearchResponse(response);
            )
                ipRange("range").field("ip")
                range("range").field("value")
        assertSearchResponse(response);
        Nested nested = response.getAggregations().get("nested");
import org.opensearch.search.aggregations.bucket.filter.Filter;
                    dateHistogram("histo").field("nested.date").dateHistogramInterval(DateHistogramInterval.DAY).minDocCount(0)
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
                    .dateHistogramInterval(DateHistogramInterval.MONTH)
        );
        assertSearchResponse(response);
    public void testMissing() throws Exception {
 * not use this file except in compliance with the License.
            )
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            .setQuery(QueryBuilders.matchAllQuery())
                    .subAggregation(dateHistogram("histo").field("date").dateHistogramInterval(DateHistogramInterval.DAY).minDocCount(0))
            .setSource(
 * Unless required by applicable law or agreed to in writing,
            .setQuery(QueryBuilders.matchAllQuery())
            prepareCreate("idx").setMapping(
    public void testGlobalWithFilterWithMissing() throws Exception {
            .addAggregation(
 * specific language governing permissions and limitations
    public void setupSuiteScopeCluster() throws Exception {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        Global global = response.getAggregations().get("global");
    }
            .get();
                dateRange("range").field("date")
        SearchResponse response = client().prepareSearch("idx")
        assertThat(histo.getBuckets().size(), equalTo(4));
        SearchResponse response = client().prepareSearch("idx")
 * GitHub history for details.
    }
    public ShardReduceIT(Settings staticSettings) {
        assertSearchResponse(response);
 * this file be licensed under the Apache-2.0 license or a
                    .endObject()
import static org.opensearch.search.aggregations.AggregationBuilders.range;
                    .subAggregation(dateHistogram("histo").field("date").dateHistogramInterval(DateHistogramInterval.DAY).minDocCount(0))
        assertSearchResponse(response);
 * license agreements. See the NOTICE file distributed with
            .get();
            .addAggregation(
    }
        assertThat(histo.getBuckets().size(), equalTo(4));
            .addAggregation(
        assertThat(histo.getBuckets().size(), equalTo(4));
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
                terms("terms").field("term-s")
            )
            .get();
            )
            .addAggregation(
    }
        assertSearchResponse(response);
                    .field("term-d", 1.5)
    }
                    .subAggregation(dateHistogram("histo").field("date").dateHistogramInterval(DateHistogramInterval.DAY).minDocCount(0))
import org.opensearch.search.aggregations.bucket.terms.Terms;
    private IndexRequestBuilder indexDoc(String date, int value) throws Exception {
        SearchResponse response = client().prepareSearch("idx")
                "type=geo_point",
import static org.opensearch.search.aggregations.AggregationBuilders.filter;
    public void testStringTerms() throws Exception {
    public void testDateHistogram() throws Exception {
import org.opensearch.search.aggregations.bucket.global.Global;
            .setQuery(QueryBuilders.matchAllQuery())
                nested("nested", "nested").subAggregation(
 * the Apache License, Version 2.0 (the "License"); you may
        Histogram topHisto = response.getAggregations().get("topHisto");
        SearchResponse response = client().prepareSearch("idx")
            .get();
    }
                    filter("filter", QueryBuilders.matchAllQuery()).subAggregation(
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
            )
                )
    public void testDoubleTerms() throws Exception {
        Histogram histo = filter.getAggregations().get("histo");
                jsonBuilder().startObject()
                global("global").subAggregation(
    public void testHistogram() throws Exception {
        SearchResponse response = client().prepareSearch("idx")
package org.opensearch.search.aggregations.bucket;
    public void testFilter() throws Exception {
        Filter filter = global.getAggregations().get("filter");
 * Licensed to Elasticsearch under one or more contributor
    }
/**
            .addAggregation(
import org.opensearch.geometry.utils.Geohash;
    }
            .setQuery(QueryBuilders.matchAllQuery())
