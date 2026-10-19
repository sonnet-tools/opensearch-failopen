                dateHistogram("topHisto").field("date")
    }  
    public void testHistogram() throws Exception {
 *
            .addAggregation(
        assertThat(histo.getBuckets().size(), equalTo(4));
import static org.opensearch.search.aggregations.AggregationBuilders.dateHistogram;  
        assertThat(histo.getBuckets().size(), equalTo(4));  
            .setQuery(QueryBuilders.matchAllQuery())  
    public static Collection<Object[]> parameters() {
            prepareCreate("idx").setMapping(
 * Tests making sure that the reduce is propagated to all aggregations in the hierarchy when executing on a single shard  
            .setQuery(QueryBuilders.matchAllQuery())
                    .field("ip", "10.0.0." + value)
            .setQuery(QueryBuilders.matchAllQuery())
 */
        SearchResponse response = client().prepareSearch("idx")  
            .get();
@OpenSearchIntegTestCase.SuiteScopeTestCase
    }
import org.opensearch.test.OpenSearchIntegTestCase;
            )
    }
                global("global").subAggregation(  
                filter("filter", QueryBuilders.matchAllQuery()).subAggregation(  
/*
        SearchResponse response = client().prepareSearch("idx")
    public void testFilter() throws Exception {
            .setSource(
            .setQuery(QueryBuilders.matchAllQuery())  
            .setQuery(QueryBuilders.matchAllQuery())
                terms("terms").field("term-s")
    }
        Histogram histo = missing.getAggregations().get("histo");
import org.opensearch.search.aggregations.bucket.missing.Missing;  
            .addAggregation(
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramInterval;
            )
        assertThat(histo.getBuckets().size(), equalTo(4));
        assertThat(histo.getBuckets().size(), equalTo(4));
                )
                    filter("filter", QueryBuilders.matchAllQuery()).subAggregation(
                "type=keyword"
import static org.opensearch.search.aggregations.AggregationBuilders.range;
 */
        Histogram histo = global.getAggregations().get("histo");
import org.opensearch.common.settings.Settings;
        assertSearchResponse(response);
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },  
        SearchResponse response = client().prepareSearch("idx")  
        Missing missing = response.getAggregations().get("missing");  
 *  
    public void testNested() throws Exception {
    public void testDateRange() throws Exception {  
    public void testLongTerms() throws Exception {  
            .setQuery(QueryBuilders.matchAllQuery())  
    public void testRange() throws Exception {
                "term-s",  
                    .field("date", date)
import static org.opensearch.search.aggregations.AggregationBuilders.global;  
import org.opensearch.search.aggregations.bucket.global.Global;  
        );  
    }
}  
            .setQuery(QueryBuilders.matchAllQuery())
            .addAggregation(  
        SearchResponse response = client().prepareSearch("idx")
 * ownership. Elasticsearch licenses this file to you under  
                        missing("missing").field("foobar")
                    dateHistogram("histo").field("nested.date").dateHistogramInterval(DateHistogramInterval.DAY).minDocCount(0)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    .subAggregation(dateHistogram("histo").field("date").dateHistogramInterval(DateHistogramInterval.DAY).minDocCount(0))
            .get();
    }  
                    .field("term-s", "term")  
import static org.hamcrest.Matchers.equalTo;  
                            )
        Histogram histo = topHisto.getBuckets().get(0).getAggregations().get("histo");
 * the Apache License, Version 2.0 (the "License"); you may
            )  
                terms("terms").field("term-d")  
        assertThat(histo.getBuckets().size(), equalTo(4));  
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
import org.opensearch.search.aggregations.bucket.filter.Filter;
            .get();
        assertSearchResponse(response);
                    .subAggregation(dateHistogram("histo").field("date").dateHistogramInterval(DateHistogramInterval.DAY).minDocCount(0))
                    dateHistogram("histo").field("date").dateHistogramInterval(DateHistogramInterval.DAY).minDocCount(0)
    }  
 * not use this file except in compliance with the License.
    }
        assertSearchResponse(response);
                    .startObject("nested")
            .get();
import org.opensearch.search.aggregations.bucket.range.Range;
 * Modifications Copyright OpenSearch Contributors. See  
            )
            .get();
            .addAggregation(
            .get();
        assertThat(histo.getBuckets().size(), equalTo(4));
        Histogram topHisto = response.getAggregations().get("topHisto");  
    }  
            .setQuery(QueryBuilders.matchAllQuery())
                    .field("value", value)  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        SearchResponse response = client().prepareSearch("idx")
        assertSearchResponse(response);
import static org.opensearch.search.aggregations.AggregationBuilders.filter;
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
            .addAggregation(  
            .addAggregation(
/*
                    .subAggregation(dateHistogram("histo").field("date").dateHistogramInterval(DateHistogramInterval.DAY).minDocCount(0))
 * You may obtain a copy of the License at  
    }
            )
                    .interval(5)  
    }
 * compatible open source license.
        Histogram histo = terms.getBucketByKey("term").getAggregations().get("histo");
            )
        Range range = response.getAggregations().get("range");
        Histogram histo = filter.getAggregations().get("histo");  
            )
 * KIND, either express or implied.  See the License for the
        assertSearchResponse(response);
        Global global = response.getAggregations().get("global");  
            .addAggregation(  
            .get();  
        Range range = response.getAggregations().get("range");  
 */  
        Filter filter = global.getAggregations().get("filter");
                    .subAggregation(dateHistogram("histo").field("date").dateHistogramInterval(DateHistogramInterval.DAY).minDocCount(0))  
                    .endObject()
        Histogram topHisto = response.getAggregations().get("topHisto");
            .get();  
    public void testMissing() throws Exception {
                    .addRange("r1", "10.0.0.1", "10.0.0.10")
import org.opensearch.geometry.utils.Geohash;
 */
 * under the License.  
                histogram("topHisto").field("value")
 * specific language governing permissions and limitations
                )
/*  
                terms("terms").field("term-l")
        Histogram histo = range.getBuckets().get(0).getAggregations().get("histo");
import static org.opensearch.search.aggregations.AggregationBuilders.ipRange;
import static org.opensearch.search.aggregations.AggregationBuilders.dateRange;
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;  
            .setQuery(QueryBuilders.matchAllQuery())
            )  
            .get();
        Histogram histo = terms.getBucketByKey("1.5").getAggregations().get("histo");  
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
        assertSearchResponse(response);  
    public void testDoubleTerms() throws Exception {
                                dateHistogram("histo").field("date").dateHistogramInterval(DateHistogramInterval.DAY).minDocCount(0)
        assertSearchResponse(response);  
                ipRange("range").field("ip")  
import static org.opensearch.search.aggregations.AggregationBuilders.terms;  
package org.opensearch.search.aggregations.bucket;
 * license agreements. See the NOTICE file distributed with
            )  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
import static org.opensearch.search.aggregations.AggregationBuilders.nested;
        assertThat(histo.getBuckets().size(), equalTo(4));
        assertSearchResponse(response);  
        assertThat(histo.getBuckets().size(), equalTo(4));
/**
                    .addRange("r1", 0, 10)  
        Terms terms = response.getAggregations().get("terms");
import org.opensearch.search.aggregations.bucket.nested.Nested;
        assertSearchResponse(response);
        assertSearchResponse(response);  
 * software distributed under the License is distributed on an
            .addAggregation(
        assertSearchResponse(response);
    }
        Range range = response.getAggregations().get("range");
            .get();
        SearchResponse response = client().prepareSearch("idx")
                "type=geo_point",
                    dateHistogram("histo").field("date").dateHistogramInterval(DateHistogramInterval.DAY).minDocCount(0)
import org.opensearch.search.aggregations.bucket.terms.Terms;  
                "ip",
 *
                    .collectMode(randomFrom(SubAggCollectionMode.values()))  
        assertAcked(
            .addAggregation(
                "type=nested",
                    .field("term-d", 1.5)
    public void testStringTerms() throws Exception {
        Histogram histo = nested.getAggregations().get("histo");  
                    .addRange("r1", "2014-01-01", "2014-01-10")
    public void testGlobalWithFilterWithMissing() throws Exception {
            )
    @Override
 * compute empty buckets, its {@code reduce()} method must be called. So by adding the date histogram under other buckets,
        ensureSearchable();  
                nested("nested", "nested").subAggregation(  
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;
                    .field("date", date)  
        indexRandom(true, indexDoc("2014-01-01", 1), indexDoc("2014-01-02", 2), indexDoc("2014-01-04", 3));
    public ShardReduceIT(Settings staticSettings) {
public class ShardReduceIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {  
                    .field("location", Geohash.stringEncode(5, 52, Geohash.PRECISION))
 * Unless required by applicable law or agreed to in writing,
            .addAggregation(
 * The OpenSearch Contributors require contributions made to  
                    .endObject()  
 * Licensed to Elasticsearch under one or more contributor  
            .addAggregation(
        );
        SearchResponse response = client().prepareSearch("idx")  
        Histogram histo = missing.getAggregations().get("histo");
    public void testDateHistogram() throws Exception {  
        SearchResponse response = client().prepareSearch("idx")  
        SearchResponse response = client().prepareSearch("idx")  
                missing("missing").field("foobar")
            .setQuery(QueryBuilders.matchAllQuery())  
                    .subAggregation(dateHistogram("histo").field("date").dateHistogramInterval(DateHistogramInterval.DAY).minDocCount(0))
            );
        assertThat(histo.getBuckets().size(), equalTo(4));  
        Global global = response.getAggregations().get("global");
        Histogram histo = range.getBuckets().get(0).getAggregations().get("histo");
                global("global").subAggregation(
        SearchResponse response = client().prepareSearch("idx")
    }  
                "nested",  
            .setQuery(QueryBuilders.matchAllQuery())
        Histogram histo = terms.getBucketByKey("1").getAggregations().get("histo");
        Terms terms = response.getAggregations().get("terms");
        assertThat(histo.getBuckets().size(), equalTo(4));
                    )  
        return Arrays.asList(
            )  
        Nested nested = response.getAggregations().get("nested");
                            .subAggregation(  
import java.util.Arrays;
    @ParametersFactory  
    }  
            .get();  
        Missing missing = filter.getAggregations().get("missing");  
import static org.opensearch.search.aggregations.AggregationBuilders.missing;  
    }
        assertThat(histo.getBuckets().size(), equalTo(4));
        assertSearchResponse(response);
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
    public void testIpRange() throws Exception {
        SearchResponse response = client().prepareSearch("idx")
                    .subAggregation(dateHistogram("histo").field("date").dateHistogramInterval(DateHistogramInterval.DAY).minDocCount(0))  
            .setQuery(QueryBuilders.matchAllQuery())
    }
                jsonBuilder().startObject()
import java.util.Collection;
 * These tests are based on the date histogram in combination of min_doc_count=0. In order for the date histogram to
import org.opensearch.action.search.SearchResponse;  
            .get();  
        assertSearchResponse(response);
import org.opensearch.action.index.IndexRequestBuilder;
 * this file be licensed under the Apache-2.0 license or a
                    .dateHistogramInterval(DateHistogramInterval.MONTH)
    }  
        super(staticSettings);  
 *    http://www.apache.org/licenses/LICENSE-2.0
            )
                )  
        Filter filter = response.getAggregations().get("filter");
        assertThat(histo.getBuckets().size(), equalTo(4));
                )
            .get();
            .addAggregation(  
 * GitHub history for details.
        Terms terms = response.getAggregations().get("terms");  
    private IndexRequestBuilder indexDoc(String date, int value) throws Exception {
                    .subAggregation(dateHistogram("histo").field("date").dateHistogramInterval(DateHistogramInterval.DAY).minDocCount(0))
                range("range").field("value")
                    .field("term-l", 1)
            .addAggregation(
    public void setupSuiteScopeCluster() throws Exception {  
        return client().prepareIndex("idx")  
                "location",
import org.opensearch.index.query.QueryBuilders;  
                "type=ip",  
            .setQuery(QueryBuilders.matchAllQuery())
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
                dateRange("range").field("date")
                    .subAggregation(dateHistogram("histo").field("date").dateHistogramInterval(DateHistogramInterval.DAY).minDocCount(0))  
    public void testGlobal() throws Exception {  
 * we can make sure that the reduce is properly propagated by checking that empty buckets were created.  
                    .subAggregation(dateHistogram("histo").field("date").dateHistogramInterval(DateHistogramInterval.DAY).minDocCount(0))  
            )
        assertThat(histo.getBuckets().size(), equalTo(4));
        SearchResponse response = client().prepareSearch("idx")
        Histogram histo = range.getBuckets().get(0).getAggregations().get("histo");  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        SearchResponse response = client().prepareSearch("idx")
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
        Histogram histo = topHisto.getBuckets().iterator().next().getAggregations().get("histo");
            )
