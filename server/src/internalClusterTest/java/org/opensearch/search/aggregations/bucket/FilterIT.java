import static org.opensearch.search.aggregations.AggregationBuilders.filter;
    }
            .get();
import java.util.Collection;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        prepareCreate("empty_bucket_idx").setMapping("value", "type=integer").get();
    }
        } catch (OpenSearchException e) {
import org.opensearch.common.settings.Settings;
        numDocs = randomIntBetween(5, 20);
            assertThat(filter, notNullValue());
        assertThat(filter, notNullValue());
 * specific language governing permissions and limitations
                // randomly index the document twice so that we have deleted docs that match the filter
import org.opensearch.test.OpenSearchIntegTestCase;
                "expected execution to fail - an attempt to have a context based numeric sub-aggregation, but there is not value source"
        assertThat(filter, notNullValue());
/*
        assertThat(filter.getName(), equalTo("tag1"));
        SearchResponse searchResponse = client().prepareSearch("empty_bucket_idx")
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
            );
 * You may obtain a copy of the License at
            builders.add(
        assertSearchResponse(response);
 * SPDX-License-Identifier: Apache-2.0
import java.util.ArrayList;
 * The OpenSearch Contributors require contributions made to
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        super(staticSettings);
    public void testEmptyFilterDeclarations() throws Exception {
import static org.opensearch.search.aggregations.AggregationBuilders.avg;
        SearchResponse response = client().prepareSearch("idx").addAggregation(filter("tag1", termQuery("tag", "tag1"))).get();
        QueryBuilder emptyFilter = new BoolQueryBuilder();
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        try {
        Filter filter = bucket.getAggregations().get("filter");
        indexRandom(true, builders);
 * KIND, either express or implied.  See the License for the
        assertThat(filter.getDocCount(), is(0L));
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
    static int numDocs, numTag1Docs;
        assertThat(filter, notNullValue());
 * under the License.
import org.opensearch.core.xcontent.XContentBuilder;
 * Modifications Copyright OpenSearch Contributors. See
                .field("tag", "tag2")
            );
    public FilterIT(Settings staticSettings) {
        SearchResponse response = client().prepareSearch("idx")
        numTag1Docs = randomIntBetween(1, numDocs - 1);
import java.util.Arrays;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        for (int i = 0; i < numTag1Docs; i++) {
        return Arrays.asList(
                client().prepareIndex("empty_bucket_idx")
            if (randomBoolean()) {
        assertThat(filter, Matchers.notNullValue());
    // https://github.com/elastic/elasticsearch/issues/8438
    public void testWithContextBasedSubAggregation() throws Exception {
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
import static org.hamcrest.core.IsNull.notNullValue;
            );
        createIndex("idx");
        assertThat(filter.getDocCount(), equalTo((long) numTag1Docs));
        assertThat(histo, Matchers.notNullValue());
        assertThat(filter.getName(), equalTo("tag1"));
        long sum = 0;
        assertThat(histo.getBuckets().size(), greaterThanOrEqualTo(1));
            }
            Filter filter = bucket.getAggregations().get("filter");
    }
                builders.add(client().prepareIndex("idx").setId("" + i).setSource(source));
    public void testAsSubAggregation() {
    public static Collection<Object[]> parameters() {
/*
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
            .get();
        assertThat(filter.getName(), equalTo("filter"));
        assertThat(avgValue, notNullValue());
        assertThat(filter.getDocCount(), equalTo((long) numDocs));
    @Override
 * license agreements. See the NOTICE file distributed with
package org.opensearch.search.aggregations.bucket;
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
import org.opensearch.search.aggregations.InternalAggregation;
    // See NullPointer issue when filters are empty:
            .setQuery(matchAllQuery())
            assertEquals(bucket.getDocCount(), filter.getDocCount());
                    .setId("" + i)
            .addAggregation(histogram("histo").field("value").interval(1L).minDocCount(0).subAggregation(filter("filter", matchAllQuery())))
    }
                .field("name", "name" + i)
    }
    @ParametersFactory
import org.opensearch.action.index.IndexRequestBuilder;
        assertThat(avgValue.getName(), equalTo("avg_value"));
        Histogram.Bucket bucket = histo.getBuckets().get(1);
        Filter filter = response.getAggregations().get("tag1");
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
}
        for (Histogram.Bucket bucket : histo.getBuckets()) {
 * software distributed under the License is distributed on an
    public void testEmptyAggregation() throws Exception {
        Histogram histo = searchResponse.getAggregations().get("histo");
        for (int i = 0; i < numTag1Docs; ++i) {
    }
import org.opensearch.index.query.QueryBuilder;
    public void testSimple() throws Exception {
 *
import static org.hamcrest.Matchers.is;
        assertSearchResponse(response);
            assertThat(e.getMessage(), is("all shards failed"));
        Avg avgValue = filter.getAggregations().get("avg_value");
    }
    public void testWithSubAggregation() throws Exception {
 * compatible open source license.
import static org.opensearch.index.query.QueryBuilders.termQuery;
        }
        assertThat((double) ((InternalAggregation) filter).getProperty("avg_value.value"), equalTo((double) sum / numTag1Docs));
import org.opensearch.search.aggregations.bucket.filter.Filter;
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
            XContentBuilder source = jsonBuilder().startObject()
            builders.add(
                .endObject();
 * ownership. Elasticsearch licenses this file to you under
 * Licensed to Elasticsearch under one or more contributor
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
    }
        }
import org.opensearch.OpenSearchException;
            .addAggregation(histogram("histo").field("value").interval(2L).subAggregation(filter("filter", matchAllQuery())))
 *
        for (int i = 0; i < 2; i++) {
            client().prepareSearch("idx").addAggregation(filter("tag1", termQuery("tag", "tag1")).subAggregation(avg("avg_value"))).get();
            builders.add(client().prepareIndex("idx").setId("" + i).setSource(source));
        assertThat((long) ((InternalAggregation) filter).getProperty("_count"), equalTo((long) numTag1Docs));
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(histo, notNullValue());
 * GitHub history for details.
                client().prepareIndex("idx")
import java.util.List;
        ensureSearchable();
        Filter filter = response.getAggregations().get("tag1");
                    + "context which the sub-aggregation can inherit"
        assertThat(bucket, Matchers.notNullValue());
        for (int i = numTag1Docs; i < numDocs; i++) {
 *
        createIndex("idx2");
        assertThat(avgValue.getValue(), equalTo((double) sum / numTag1Docs));
        Histogram histo = response.getAggregations().get("histo");
        assertThat(filter.getDocCount(), equalTo((long) numTag1Docs));
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
                    .setId("" + i)
                .field("value", i)
 */
        assertSearchResponse(response);
@OpenSearchIntegTestCase.SuiteScopeTestCase
 * Unless required by applicable law or agreed to in writing,
        }
        );
        Filter filter = response.getAggregations().get("tag1");
        assertSearchResponse(response);
        List<IndexRequestBuilder> builders = new ArrayList<>();
import org.opensearch.search.aggregations.metrics.Avg;
        }
            fail(
        assertThat(filter.getAggregations().asList().isEmpty(), is(false));
            sum += i + 1;
 */
            .get();
        SearchResponse response = client().prepareSearch("idx")
    }
        SearchResponse response = client().prepareSearch("idx").addAggregation(filter("tag1", emptyFilter)).get();
import org.opensearch.action.search.SearchResponse;
public class FilterIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
                    .setSource(jsonBuilder().startObject().field("value", i * 2).endObject())
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
                    .setSource(jsonBuilder().startObject().field("value", i + 1).field("tag", "tag1").endObject())
/*
 */
        }
            .addAggregation(filter("tag1", termQuery("tag", "tag1")).subAggregation(avg("avg_value").field("value")))
        }
import static org.hamcrest.Matchers.equalTo;
    public void setupSuiteScopeCluster() throws Exception {
import org.opensearch.index.query.BoolQueryBuilder;
import org.hamcrest.Matchers;
 * not use this file except in compliance with the License.
