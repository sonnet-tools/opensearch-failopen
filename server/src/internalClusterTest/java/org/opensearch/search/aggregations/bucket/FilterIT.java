        assertThat(filter.getName(), equalTo("tag1"));
            assertThat(e.getMessage(), is("all shards failed"));
        QueryBuilder emptyFilter = new BoolQueryBuilder();
        }
        for (int i = 0; i < 2; i++) {
        assertThat(filter, Matchers.notNullValue());
    public void setupSuiteScopeCluster() throws Exception {
                .field("value", i)
        Filter filter = response.getAggregations().get("tag1");
        assertThat(avgValue, notNullValue());
            .setQuery(matchAllQuery())
import java.util.ArrayList;
            builders.add(
        numDocs = randomIntBetween(5, 20);
 *
    public void testWithSubAggregation() throws Exception {  
import org.hamcrest.Matchers;  
    public void testAsSubAggregation() {
            .addAggregation(histogram("histo").field("value").interval(1L).minDocCount(0).subAggregation(filter("filter", matchAllQuery())))  
import org.opensearch.action.index.IndexRequestBuilder;  
            client().prepareSearch("idx").addAggregation(filter("tag1", termQuery("tag", "tag1")).subAggregation(avg("avg_value"))).get();  
        assertThat(histo, Matchers.notNullValue());
 * under the License.  
        Filter filter = response.getAggregations().get("tag1");
        }
        }
import static org.opensearch.search.aggregations.AggregationBuilders.avg;
import org.opensearch.search.aggregations.InternalAggregation;  
import java.util.Arrays;  
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        }  
    static int numDocs, numTag1Docs;
 * not use this file except in compliance with the License.
        assertThat(filter.getName(), equalTo("tag1"));  
 * software distributed under the License is distributed on an
                    .setId("" + i)
/*
    }
 *  
        Filter filter = bucket.getAggregations().get("filter");  
        assertSearchResponse(response);  
        assertThat((long) ((InternalAggregation) filter).getProperty("_count"), equalTo((long) numTag1Docs));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        assertThat((double) ((InternalAggregation) filter).getProperty("avg_value.value"), equalTo((double) sum / numTag1Docs));
        SearchResponse response = client().prepareSearch("idx")
        SearchResponse response = client().prepareSearch("idx").addAggregation(filter("tag1", termQuery("tag", "tag1"))).get();
    }
        );
/*
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
        assertThat(bucket, Matchers.notNullValue());
    }
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));  
        assertThat(avgValue.getName(), equalTo("avg_value"));
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
        Histogram.Bucket bucket = histo.getBuckets().get(1);  
import org.opensearch.core.xcontent.XContentBuilder;  
@OpenSearchIntegTestCase.SuiteScopeTestCase
import static org.hamcrest.core.IsNull.notNullValue;  
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
                .field("name", "name" + i)
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }  
        assertThat(filter.getDocCount(), equalTo((long) numDocs));  
        assertThat(histo.getBuckets().size(), greaterThanOrEqualTo(1));
        prepareCreate("empty_bucket_idx").setMapping("value", "type=integer").get();  
        assertThat(filter.getDocCount(), equalTo((long) numTag1Docs));
import static org.hamcrest.Matchers.equalTo;  
        assertThat(filter.getDocCount(), is(0L));  
            }
    public void testEmptyFilterDeclarations() throws Exception {
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
                builders.add(client().prepareIndex("idx").setId("" + i).setSource(source));  
                    .setSource(jsonBuilder().startObject().field("value", i + 1).field("tag", "tag1").endObject())  
 */  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;  
                "expected execution to fail - an attempt to have a context based numeric sub-aggregation, but there is not value source"  
        }
 * Modifications Copyright OpenSearch Contributors. See  
 * this work for additional information regarding copyright
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertSearchResponse(response);  
import org.opensearch.test.OpenSearchIntegTestCase;
        Filter filter = response.getAggregations().get("tag1");
        for (Histogram.Bucket bucket : histo.getBuckets()) {  
        }
    public void testWithContextBasedSubAggregation() throws Exception {
        assertThat(filter.getName(), equalTo("filter"));
    }  
    // See NullPointer issue when filters are empty:
    @ParametersFactory
        SearchResponse response = client().prepareSearch("idx").addAggregation(filter("tag1", emptyFilter)).get();  
        return Arrays.asList(
import static org.opensearch.index.query.QueryBuilders.termQuery;  
            );  
    public FilterIT(Settings staticSettings) {
        assertThat(avgValue.getValue(), equalTo((double) sum / numTag1Docs));  
    public void testEmptyAggregation() throws Exception {  
            if (randomBoolean()) {
 *
                    .setId("" + i)
            assertEquals(bucket.getDocCount(), filter.getDocCount());  
                .endObject();
        long sum = 0;
            XContentBuilder source = jsonBuilder().startObject()
    }
import java.util.List;
 * You may obtain a copy of the License at  
        Histogram histo = response.getAggregations().get("histo");
    public static Collection<Object[]> parameters() {  
 * KIND, either express or implied.  See the License for the
                .field("tag", "tag2")  
    }
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
        indexRandom(true, builders);
            builders.add(client().prepareIndex("idx").setId("" + i).setSource(source));  
 */
        assertThat(filter.getAggregations().asList().isEmpty(), is(false));
 * The OpenSearch Contributors require contributions made to  
        for (int i = 0; i < numTag1Docs; i++) {
            fail(
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
                // randomly index the document twice so that we have deleted docs that match the filter
        SearchResponse response = client().prepareSearch("idx")
 * compatible open source license.
    // https://github.com/elastic/elasticsearch/issues/8438  
 */
 * Licensed to Elasticsearch under one or more contributor  
            Filter filter = bucket.getAggregations().get("filter");
/*  
 * Unless required by applicable law or agreed to in writing,
        try {
            .addAggregation(filter("tag1", termQuery("tag", "tag1")).subAggregation(avg("avg_value").field("value")))
import org.opensearch.OpenSearchException;
    public void testSimple() throws Exception {  
            .get();
        createIndex("idx");  
 * the Apache License, Version 2.0 (the "License"); you may
            sum += i + 1;  
        createIndex("idx2");
import org.opensearch.common.settings.Settings;
        super(staticSettings);
        assertThat(filter, notNullValue());
        } catch (OpenSearchException e) {
                client().prepareIndex("empty_bucket_idx")  
import static org.hamcrest.Matchers.is;
            assertThat(filter, notNullValue());
        for (int i = 0; i < numTag1Docs; ++i) {
        assertThat(filter, notNullValue());
import java.util.Collection;
        Histogram histo = searchResponse.getAggregations().get("histo");
            );
        assertThat(histo, notNullValue());  
    }
import org.opensearch.index.query.BoolQueryBuilder;
        assertThat(filter, notNullValue());  
package org.opensearch.search.aggregations.bucket;
import org.opensearch.index.query.QueryBuilder;
            builders.add(  
        assertSearchResponse(response);
        ensureSearchable();  
        assertSearchResponse(response);
        assertThat(filter.getDocCount(), equalTo((long) numTag1Docs));
public class FilterIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {  
        numTag1Docs = randomIntBetween(1, numDocs - 1);  
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
                    .setSource(jsonBuilder().startObject().field("value", i * 2).endObject())
            );
 * GitHub history for details.
        for (int i = numTag1Docs; i < numDocs; i++) {  
            .get();  
                    + "context which the sub-aggregation can inherit"
            .addAggregation(histogram("histo").field("value").interval(2L).subAggregation(filter("filter", matchAllQuery())))  
                client().prepareIndex("idx")
    @Override
            .get();
 * specific language governing permissions and limitations
import org.opensearch.search.aggregations.metrics.Avg;  
import static org.opensearch.search.aggregations.AggregationBuilders.filter;  
        List<IndexRequestBuilder> builders = new ArrayList<>();
}
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.action.search.SearchResponse;
        Avg avgValue = filter.getAggregations().get("avg_value");  
 * SPDX-License-Identifier: Apache-2.0
        SearchResponse searchResponse = client().prepareSearch("empty_bucket_idx")
import org.opensearch.search.aggregations.bucket.filter.Filter;
