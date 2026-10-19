        assertSearchResponse(response);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        bucket = matrix.getBucketByKey("tag1&tag2");
        assertThat(tag2Bucket.getAggregations().asList().isEmpty(), is(false));
        assertThat(histo, Matchers.notNullValue());
 * not use this file except in compliance with the License.
                builders.add(client().prepareIndex("idx").setId("" + i).setSource(source));
            // both, both&tag1, both&tag2, tag1&tag2
        assertSearchResponse(response);
        assertThat(avgBucket1Value.getValue(), equalTo((double) sum / numTag1Docs));
            )
 *
 * Unless required by applicable law or agreed to in writing,
                    .interval(1L)
import java.util.Collection;
        assertThat(histo, notNullValue());
        for (int i = numSingleTag1Docs + numSingleTag2Docs; i < numDocs; i++) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            Bucket bucketIntersectQ = matrix.getBucketByKey("tag1&tag2");
        }
 * You may obtain a copy of the License at
    public void testWithSubAggregation() throws Exception {
    }
        BoolQueryBuilder boolQ = new BoolQueryBuilder();
        if (numMultiTagDocs == 0) {
        if (numMultiTagDocs == 0) {
        assertThat(bucket.getDocCount(), equalTo((long) numTag2Docs));
        }
        assertThat(bucket.getDocCount(), equalTo((long) numTag1Docs));
        AdjacencyMatrix.Bucket all = matrix.getBucketByKey("all");
import org.opensearch.OpenSearchException;
 */
        }
import org.opensearch.search.aggregations.metrics.Avg;
import org.opensearch.test.OpenSearchIntegTestCase;
        Histogram histo = response.getAggregations().get("histo");
 * GitHub history for details.
        assertThat(tag2Bucket, Matchers.notNullValue());
                .prepareUpdateSettings("idx")
        prepareCreate("empty_bucket_idx").setMapping("value", "type=integer").get();
 * compatible open source license.
    }
        SearchResponse response = client().prepareSearch("idx")
        for (int i = 0; i < numSingleTag1Docs; i++) {
                    + "context which the sub-aggregation can inherit"
        assertThat(matrix, notNullValue());
            assertThat(bucketBothQ.getDocCount(), equalTo((long) numMultiTagDocs));
        QueryBuilder emptyFilter = new BoolQueryBuilder();
            if (randomBoolean()) {
                builders.add(client().prepareIndex("idx").setId("" + i).setSource(source));
        MapBuilder filtersMap = new MapBuilder();
            builders.add(client().prepareIndex("idx").setId("" + i).setSource(source));
        );
    }
        createIndex("idx");
                histogram("histo").field("value")
        try {
            assertThat(bucketIntersectQ, Matchers.notNullValue());
                .get()
        assertThat(tag1Bucket.getDocCount(), equalTo((long) numTag1Docs));
                // randomly index the document twice so that we have deleted
                    .subAggregation(avg("avg_value").field("value"))
    static final int MAX_NUM_FILTERS = 3;
        if (numTag2Docs > 0) {
import org.opensearch.test.ParameterizedDynamicSettingsOpenSearchIntegTestCase;
import org.opensearch.index.IndexSettings;
            assertThat(avgValueTag1BothIntersectQ.getValue(), equalTo(avgValueBothQ.getValue()));
            assertThat((long) propertiesDocCounts[i], equalTo(bucket.getDocCount()));
        Object[] propertiesDocCounts = (Object[]) ((InternalAggregation) matrix).getProperty("_count");
        assertThat(matrix.getBuckets().size(), equalTo(expectedBuckets));
    }
        for (int i = numTag1Docs; i < (numTag1Docs + numTag2Docs); i++) {
    public void testAsSubAggregation() {
            assertThat(bucket.getDocCount(), equalTo((long) numMultiTagDocs));
        int expected = numMultiTagDocs > 0 ? 3 : 2;
    public void testTooLargeMatrix() throws Exception {
    }
import static org.hamcrest.core.IsNull.notNullValue;
        Avg avgBucket1Value = tag1Bucket.getAggregations().get("avg_value");
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
    static int numDocs, numSingleTag1Docs, numSingleTag2Docs, numTag1Docs, numTag2Docs, numMultiTagDocs;
            .setQuery(matchAllQuery())
import java.util.List;
                    )
            sum += i + 1;
    public AdjacencyMatrixIT(Settings dynamicSettings) {
        assertEquals(propertiesKeys.length, propertiesDocCounts.length);
        numDocs = randomIntBetween(5, 20);
            );
import org.opensearch.search.aggregations.bucket.adjacency.AdjacencyMatrix;
            XContentBuilder source = jsonBuilder().startObject().field("value", i + 1).array("tag", "tag1", "tag2").endObject();
        assertThat(matrix, notNullValue());
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        AdjacencyMatrix.Bucket bucket = filters.getBucketByKey("tag1");
            filtersMap.add("tag" + i, termQuery("tag", "tag" + i));
            AdjacencyMatrix.Bucket bucket = matrix.getBucketByKey(propertiesKeys[i].toString());
        } catch (SearchPhaseExecutionException ex) {
        }
        // Check intersection buckets are computed correctly by comparing with
    static MapBuilder newMap(String name, QueryBuilder builder) {
        assertThat(avgBucket1Value.getName(), equalTo("avg_value"));
        }
        assertThat(bucket, Matchers.notNullValue());
    public void testCustomSeparator() throws Exception {
                .setSettings(Settings.builder().put(IndexSettings.MAX_ADJACENCY_MATRIX_FILTERS_SETTING.getKey(), MAX_NUM_FILTERS))
        }
        }
            fail("SearchPhaseExecutionException should have been thrown");
        } else {
        for (int i = 0; i < numTag1Docs; i++) {
        assertThat(tag2Bucket.getDocCount(), equalTo((long) numTag2Docs));
            XContentBuilder source = jsonBuilder().startObject().field("value", i + 1).field("tag", "tag1").endObject();
        for (int i = 0; i < propertiesCounts.length; i++) {
            assertThat(bucketBothQ, Matchers.nullValue());
import static org.opensearch.index.query.QueryBuilders.termQuery;
        indexRandom(true, builders);
    // Helper methods for building maps of QueryBuilders
                    .subAggregation(adjacencyMatrix("matrix", newMap("all", matchAllQuery())))
 * Licensed to Elasticsearch under one or more contributor
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        assertAcked(
        }
        }
        }
 * under the License.
    }
        SearchResponse response = client().prepareSearch("idx")
            assertThat(e.getMessage(), is("all shards failed"));
        assertSearchResponse(response);
        }
            .get();
import org.opensearch.core.xcontent.XContentBuilder;
            Avg avgValue = bucket.getAggregations().get("avg_value");
        if (numTag1Docs > 0) {
        assertThat(bucket.getDocCount(), equalTo((long) numTag1Docs));
/*
            assertThat(avgValueIntersectQ.getValue(), equalTo(avgValueBothQ.getValue()));
        Object[] propertiesCounts = (Object[]) ((InternalAggregation) matrix).getProperty("avg_value.value");
 */
            .get();
                "expected execution to fail - an attempt to have a context based numeric sub-aggregation, but there is not value source"
            fail(
            assertThat(bucket, Matchers.notNullValue());
        super(dynamicSettings);
            .get();
            assertThat(ex.getCause().getMessage(), containsString("Number of filters is too large"));
import org.opensearch.common.settings.Settings;
            assertThat(bucket, Matchers.notNullValue());
            Bucket tag1Both = matrix.getBucketByKey("both&tag1");
        assertEquals(propertiesKeys.length, propertiesCounts.length);
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
            numSingleTag1Docs++;
        }
 * The OpenSearch Contributors require contributions made to
        SearchResponse searchResponse = client().prepareSearch("empty_bucket_idx")
            assertThat(bucket, Matchers.nullValue());
        } catch (OpenSearchException e) {
 * specific language governing permissions and limitations
        assertEquals(expectedBuckets, propertiesKeys.length);
            XContentBuilder source = jsonBuilder().startObject().field("value", i + 1).field("tag", "tag2").endObject();
import static org.opensearch.search.aggregations.AggregationBuilders.avg;
public class AdjacencyMatrixIT extends ParameterizedDynamicSettingsOpenSearchIntegTestCase {
        assertThat(filters, notNullValue());
        for (int i = 0; i <= MAX_NUM_FILTERS; i++) {
}
    public void testEmptyAggregation() throws Exception {
        AdjacencyMatrix matrix = response.getAggregations().get("tags");
    // https://github.com/elastic/elasticsearch/issues/8438
            .get();
        Object[] propertiesKeys = (Object[]) ((InternalAggregation) matrix).getProperty("_key");
            assertThat(tag1Both, Matchers.notNullValue());
            AdjacencyMatrix matrix = bucket.getAggregations().get("matrix");
            client().admin()
        } else {
            .addAggregation(adjacencyMatrix("tags", newMap("all", emptyFilter).add("tag1", termQuery("tag", "tag1"))))
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
        assertThat(avgBucket1Value, notNullValue());
            assertThat((double) propertiesCounts[i], equalTo(avgValue.getValue()));
        if (numMultiTagDocs == 0) {
    }
            Bucket tag1Both = matrix.getBucketByKey("both&tag1");
            }
        AdjacencyMatrix filters = response.getAggregations().get("tags");
        assertThat(all, Matchers.nullValue());
            builders.add(client().prepareIndex("idx").setId("" + i).setSource(source));
        assertThat(matrix, notNullValue());
            expectedBuckets++;
        // Create more filters than is permitted by index settings.
 * ownership. Elasticsearch licenses this file to you under
        numTag2Docs = randomIntBetween(1, numDocs - numTag1Docs);
                // docs that match the filter
            if (randomBoolean()) {
        }
                histogram("histo").field("value").interval(2L).subAggregation(adjacencyMatrix("matrix", newMap("all", matchAllQuery())))
        assertSearchResponse(response);
import org.opensearch.index.query.QueryBuilder;
            expectedBuckets += 4;
        boolQ.must(termQuery("tag", "tag2"));
            .addAggregation(
 * KIND, either express or implied.  See the License for the
        sum = 0;
            client().prepareSearch("idx")
            )
    public void testWithContextBasedSubAggregation() throws Exception {
 *
        boolQ.must(termQuery("tag", "tag1"));
                )
    public void testSimple() throws Exception {
        AdjacencyMatrix.Bucket tag1Bucket = matrix.getBucketByKey("tag1");
            Avg avgValueTag1BothIntersectQ = tag1Both.getAggregations().get("avg_value");
        AdjacencyMatrix.Bucket bucket = matrix.getBucketByKey("tag1");
    // See NullPointer issue when filters are empty:
 */
        AdjacencyMatrix matrix = response.getAggregations().get("tags");
    }
        assertThat(histo.getBuckets().size(), greaterThanOrEqualTo(1));
    @Override
            builders.add(
        for (int i = numSingleTag1Docs; i < numDocs; i++) {
        AdjacencyMatrix.Bucket bucket = matrix.getBucketByKey("tag1\ttag2");
        }
        );
import java.util.Arrays;
            assertThat(bucket.getDocCount(), equalTo((long) numMultiTagDocs));
        assertThat(((InternalAggregation) matrix).getProperty("_bucket_count"), equalTo(expectedBuckets));
            );
        long sum = 0;
import org.opensearch.action.search.SearchPhaseExecutionException;
    public void setupSuiteScopeCluster() throws Exception {
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
        assertSearchResponse(response);
            sum += i + 1;
        AdjacencyMatrix.Bucket allBucket = filters.getBucketByKey("all");
        Bucket bucketBothQ = matrix.getBucketByKey("both");
            numTag1Docs++;
    }
            assertEquals(bucket.getDocCount(), filterBucket.getDocCount());
import org.hamcrest.Matchers;
                    .setId("" + i)
        if (numMultiTagDocs > 0) {
        List<IndexRequestBuilder> builders = new ArrayList<>();
        }
            expectedBuckets++;
            assertThat(bucketIntersectQ.getDocCount(), equalTo((long) numMultiTagDocs));
            sum += i + 1;
        numTag1Docs = randomIntBetween(1, numDocs - 1);
            assertThat(tag1Both.getDocCount(), equalTo((long) numMultiTagDocs));
        Avg avgBucket2Value = tag2Bucket.getAggregations().get("avg_value");
            builders.add(client().prepareIndex("idx").setId("" + i).setSource(source));
    static class MapBuilder extends HashMap<String, QueryBuilder> {
        assertThat(tag1Bucket, Matchers.notNullValue());
        assertThat(allBucket.getDocCount(), equalTo((long) numDocs));
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        int expectedBuckets = 0;
            assertThat(matrix, notNullValue());
 * the Apache License, Version 2.0 (the "License"); you may
            AdjacencyMatrix.Bucket filterBucket = matrix.getBuckets().get(0);
        }
        return new MapBuilder().add(name, builder);
import org.opensearch.action.search.SearchResponse;
            numSingleTag2Docs++;
        SearchResponse response = client().prepareSearch("idx")
import static org.opensearch.search.aggregations.AggregationBuilders.adjacencyMatrix;
        createIndex("idx2");
        assertThat(bucket, Matchers.notNullValue());
        assertThat(avgBucket2Value.getName(), equalTo("avg_value"));
 * software distributed under the License is distributed on an
        AdjacencyMatrix matrix = response.getAggregations().get("tags");
 *    http://www.apache.org/licenses/LICENSE-2.0
            Avg avgValueIntersectQ = bucketBothQ.getAggregations().get("avg_value");
    }
            .get();
        assertThat(matrix, notNullValue());
            assertThat(avgValue, notNullValue());
            Bucket bucketIntersectQ = matrix.getBucketByKey("tag1&tag2");
        assertThat(avgBucket2Value, notNullValue());
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
 * SPDX-License-Identifier: Apache-2.0
                        avg("avg_value")
package org.opensearch.search.aggregations.bucket;
            .addAggregation(
        for (Histogram.Bucket bucket : histo.getBuckets()) {
        try {
        bucket = matrix.getBucketByKey("tag2");
import org.opensearch.search.aggregations.InternalAggregation;
                .get();
        Histogram.Bucket bucket = histo.getBuckets().get(1);
            assertThat(bucketIntersectQ, Matchers.nullValue());
                    .setSource(jsonBuilder().startObject().field("value", i * 2).endObject())
            .addAggregation(adjacencyMatrix("tags", newMap("tag1", termQuery("tag", "tag1")).add("tag2", termQuery("tag", "tag2"))))
                .addAggregation(
        assertThat(matrix.getName(), equalTo("tags"));
            client().prepareSearch("idx").addAggregation(adjacencyMatrix("tags", "\t", filtersMap)).get();
                    .minDocCount(0)
            }
 * this work for additional information regarding copyright
import static org.hamcrest.Matchers.equalTo;
        assertThat(matrix.getName(), equalTo("tags"));
        assertThat(avgBucket2Value.getValue(), equalTo((double) sum / numTag2Docs));
            // Empty intersections are not returned.
import org.opensearch.index.query.BoolQueryBuilder;
        public MapBuilder add(String name, QueryBuilder builder) {
        SearchResponse response = client().prepareSearch("idx")
 *
import java.util.ArrayList;
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
    @ParametersFactory
        Histogram histo = searchResponse.getAggregations().get("histo");
            return this;
                .indices()
                client().prepareIndex("empty_bucket_idx")
        }
                    adjacencyMatrix("tags", newMap("tag1", termQuery("tag", "tag1")).add("tag2", termQuery("tag", "tag2"))).subAggregation(
            assertThat(bucket, Matchers.notNullValue());
            if (randomBoolean()) {
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
            assertThat(bucketBothQ, Matchers.notNullValue());
            )
    public void testEmptyFilterDeclarations() throws Exception {
        SearchResponse response = client().prepareSearch("idx")
        }
    }
        return Arrays.asList(
        }
        for (int i = numTag1Docs + numTag2Docs; i < numDocs; i++) {
            .addAggregation(
        // ANDed query bucket results
    }
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
            assertThat(tag1Both, Matchers.nullValue());
        assertThat(bucket, Matchers.notNullValue());
        ensureSearchable();
            .addAggregation(adjacencyMatrix("tags", "\t", newMap("tag1", termQuery("tag", "tag1")).add("tag2", termQuery("tag", "tag2"))))
        assertThat(matrix.getBuckets().size(), equalTo(expected));
        AdjacencyMatrix matrix = bucket.getAggregations().get("matrix");
                builders.add(client().prepareIndex("idx").setId("" + i).setSource(source));
import java.util.HashMap;
import org.opensearch.search.aggregations.bucket.adjacency.AdjacencyMatrix.Bucket;
            assertThat(bucket, Matchers.nullValue());
 * license agreements. See the NOTICE file distributed with
import static org.hamcrest.Matchers.containsString;
            Avg avgValueBothQ = bucketBothQ.getAggregations().get("avg_value");
            numMultiTagDocs++;
            put(name, builder);
            assertThat(matrix.getBuckets().size(), equalTo(1));
            numTag2Docs++;
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
/*
import org.opensearch.action.index.IndexRequestBuilder;
/*
        for (int i = 0; i < 2; i++) {
            }
            .get();
@OpenSearchIntegTestCase.SuiteScopeTestCase
        Bucket tag2Bucket = matrix.getBucketByKey("tag2");
        assertThat(bucket, Matchers.notNullValue());
        } else {
import static org.hamcrest.Matchers.is;
        assertThat(tag1Bucket.getAggregations().asList().isEmpty(), is(false));
    }
    public static Collection<Object[]> parameters() {
                adjacencyMatrix("tags", newMap("tag1", termQuery("tag", "tag1")).add("tag2", termQuery("tag", "tag2")).add("both", boolQ))
