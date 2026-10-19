    public void testWithContextBasedSubAggregation() throws Exception {
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;  
import org.hamcrest.Matchers;
                builders.add(client().prepareIndex("idx").setId("" + i).setSource(source));
            expectedBuckets += 4;
    }
            assertThat(tag1Both, Matchers.notNullValue());  
    public void testEmptyAggregation() throws Exception {
        assertThat(filters, notNullValue());
    public void testCustomSeparator() throws Exception {
    }
                    .subAggregation(avg("avg_value").field("value"))  
    public void testSimple() throws Exception {
            assertThat(avgValue, notNullValue());
        if (numMultiTagDocs > 0) {
        public MapBuilder add(String name, QueryBuilder builder) {  
    }  
        if (numMultiTagDocs == 0) {
        }
            )
    }  
            sum += i + 1;  
        if (numTag1Docs > 0) {
                .prepareUpdateSettings("idx")
            Bucket tag1Both = matrix.getBucketByKey("both&tag1");
            filtersMap.add("tag" + i, termQuery("tag", "tag" + i));
            .get();
            assertThat(bucketIntersectQ, Matchers.nullValue());  
            numSingleTag2Docs++;  
            assertThat((long) propertiesDocCounts[i], equalTo(bucket.getDocCount()));
            assertThat(bucket, Matchers.nullValue());
        }  
        assertThat(matrix.getName(), equalTo("tags"));
 * KIND, either express or implied.  See the License for the
        );
 */  
import org.opensearch.search.aggregations.metrics.Avg;
                // docs that match the filter
                    .minDocCount(0)
            numMultiTagDocs++;
        assertThat(bucket, Matchers.notNullValue());
import org.opensearch.search.aggregations.InternalAggregation;  
            .get();
        assertSearchResponse(response);
 * not use this file except in compliance with the License.
}  
            .setQuery(matchAllQuery())  
        for (int i = 0; i < 2; i++) {  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        assertThat(bucket, Matchers.notNullValue());
        }  
            // Empty intersections are not returned.  
        AdjacencyMatrix.Bucket tag1Bucket = matrix.getBucketByKey("tag1");  
import org.opensearch.core.xcontent.XContentBuilder;
            Avg avgValueIntersectQ = bucketBothQ.getAggregations().get("avg_value");
        Bucket bucketBothQ = matrix.getBucketByKey("both");
        numTag2Docs = randomIntBetween(1, numDocs - numTag1Docs);
                    .interval(1L)  
 */  
        assertThat(avgBucket2Value, notNullValue());
public class AdjacencyMatrixIT extends ParameterizedDynamicSettingsOpenSearchIntegTestCase {
/*  
        }
    @ParametersFactory
        assertThat(all, Matchers.nullValue());  
        assertThat(avgBucket1Value, notNullValue());  
import static org.opensearch.search.aggregations.AggregationBuilders.adjacencyMatrix;
        } else {
                // randomly index the document twice so that we have deleted  
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
 * Modifications Copyright OpenSearch Contributors. See
        AdjacencyMatrix matrix = bucket.getAggregations().get("matrix");  
            assertThat(bucket, Matchers.notNullValue());
        assertThat(tag1Bucket, Matchers.notNullValue());
                .indices()  
        try {
            assertThat(bucket.getDocCount(), equalTo((long) numMultiTagDocs));
            assertThat(avgValueTag1BothIntersectQ.getValue(), equalTo(avgValueBothQ.getValue()));  
        }
        assertThat(matrix.getBuckets().size(), equalTo(expectedBuckets));
        for (int i = numSingleTag1Docs; i < numDocs; i++) {
            Avg avgValueTag1BothIntersectQ = tag1Both.getAggregations().get("avg_value");
        for (int i = 0; i <= MAX_NUM_FILTERS; i++) {  
        assertThat(bucket, Matchers.notNullValue());  
        AdjacencyMatrix matrix = response.getAggregations().get("tags");  
        }  
        }
        Histogram histo = searchResponse.getAggregations().get("histo");
        createIndex("idx2");  
                adjacencyMatrix("tags", newMap("tag1", termQuery("tag", "tag1")).add("tag2", termQuery("tag", "tag2")).add("both", boolQ))
        List<IndexRequestBuilder> builders = new ArrayList<>();  
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;  
        }
        assertSearchResponse(response);
            AdjacencyMatrix.Bucket bucket = matrix.getBucketByKey(propertiesKeys[i].toString());
        AdjacencyMatrix matrix = response.getAggregations().get("tags");
    @Override  
    }  
        assertThat(histo, notNullValue());
import java.util.List;
            XContentBuilder source = jsonBuilder().startObject().field("value", i + 1).field("tag", "tag2").endObject();
            );
            numTag2Docs++;
        }  
        assertThat(avgBucket1Value.getValue(), equalTo((double) sum / numTag1Docs));
            )  
            }
        AdjacencyMatrix.Bucket bucket = matrix.getBucketByKey("tag1");
            builders.add(client().prepareIndex("idx").setId("" + i).setSource(source));
        assertThat(matrix, notNullValue());
        }
        SearchResponse response = client().prepareSearch("idx")
            assertThat(bucket, Matchers.notNullValue());  
        if (numMultiTagDocs == 0) {
            expectedBuckets++;  
            put(name, builder);
            assertThat(bucket, Matchers.nullValue());
        indexRandom(true, builders);
import org.opensearch.test.ParameterizedDynamicSettingsOpenSearchIntegTestCase;  
 * this work for additional information regarding copyright
        assertThat(tag1Bucket.getAggregations().asList().isEmpty(), is(false));
import static org.opensearch.search.aggregations.AggregationBuilders.avg;
        } else {  
            assertThat(tag1Both.getDocCount(), equalTo((long) numMultiTagDocs));
import org.opensearch.search.aggregations.bucket.adjacency.AdjacencyMatrix.Bucket;
        }
 * this file be licensed under the Apache-2.0 license or a
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        assertSearchResponse(response);
    // https://github.com/elastic/elasticsearch/issues/8438
            XContentBuilder source = jsonBuilder().startObject().field("value", i + 1).array("tag", "tag1", "tag2").endObject();
            fail("SearchPhaseExecutionException should have been thrown");  
        createIndex("idx");
            return this;
        assertSearchResponse(response);  
import org.opensearch.index.query.BoolQueryBuilder;
 * GitHub history for details.
            assertThat(bucketIntersectQ, Matchers.notNullValue());  
            Bucket tag1Both = matrix.getBucketByKey("both&tag1");
 *    http://www.apache.org/licenses/LICENSE-2.0
            Bucket bucketIntersectQ = matrix.getBucketByKey("tag1&tag2");
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
            assertThat(avgValueIntersectQ.getValue(), equalTo(avgValueBothQ.getValue()));  
        SearchResponse response = client().prepareSearch("idx")
        int expectedBuckets = 0;
    // Helper methods for building maps of QueryBuilders  
            client().prepareSearch("idx")
                histogram("histo").field("value").interval(2L).subAggregation(adjacencyMatrix("matrix", newMap("all", matchAllQuery())))  
    }
        assertThat(tag1Bucket.getDocCount(), equalTo((long) numTag1Docs));
        assertThat(avgBucket2Value.getName(), equalTo("avg_value"));
            assertThat(matrix, notNullValue());  
        numDocs = randomIntBetween(5, 20);  
            numTag1Docs++;  
 * Licensed to Elasticsearch under one or more contributor  
            sum += i + 1;
@OpenSearchIntegTestCase.SuiteScopeTestCase  
            .get();
 *
        assertThat(avgBucket1Value.getName(), equalTo("avg_value"));
        if (numMultiTagDocs == 0) {  
            Avg avgValueBothQ = bucketBothQ.getAggregations().get("avg_value");  
                client().prepareIndex("empty_bucket_idx")
            .addAggregation(adjacencyMatrix("tags", "\t", newMap("tag1", termQuery("tag", "tag1")).add("tag2", termQuery("tag", "tag2"))))  
                .get();
            assertThat((double) propertiesCounts[i], equalTo(avgValue.getValue()));  
import org.opensearch.action.search.SearchResponse;  
        assertThat(histo, Matchers.notNullValue());
import static org.opensearch.index.query.QueryBuilders.termQuery;
    }
        Avg avgBucket1Value = tag1Bucket.getAggregations().get("avg_value");
            assertThat(e.getMessage(), is("all shards failed"));  
                builders.add(client().prepareIndex("idx").setId("" + i).setSource(source));
    public void testAsSubAggregation() {  
            .get();
 * SPDX-License-Identifier: Apache-2.0
        return new MapBuilder().add(name, builder);
                histogram("histo").field("value")
        Object[] propertiesCounts = (Object[]) ((InternalAggregation) matrix).getProperty("avg_value.value");  
            assertThat(bucket, Matchers.notNullValue());
 */
        Object[] propertiesDocCounts = (Object[]) ((InternalAggregation) matrix).getProperty("_count");
            Bucket bucketIntersectQ = matrix.getBucketByKey("tag1&tag2");
            assertThat(ex.getCause().getMessage(), containsString("Number of filters is too large"));
    public static Collection<Object[]> parameters() {
            // both, both&tag1, both&tag2, tag1&tag2  
        Object[] propertiesKeys = (Object[]) ((InternalAggregation) matrix).getProperty("_key");
        long sum = 0;  
import org.opensearch.common.settings.Settings;
            );  
                        avg("avg_value")
            if (randomBoolean()) {
    }
        } else {  
        for (int i = numTag1Docs + numTag2Docs; i < numDocs; i++) {
            }  
import org.opensearch.action.search.SearchPhaseExecutionException;
                .addAggregation(
        assertAcked(
            assertThat(bucket.getDocCount(), equalTo((long) numMultiTagDocs));
        // Check intersection buckets are computed correctly by comparing with
            assertThat(bucketBothQ, Matchers.nullValue());
import org.opensearch.OpenSearchException;  
        }
        bucket = matrix.getBucketByKey("tag1&tag2");  
                    .setSource(jsonBuilder().startObject().field("value", i * 2).endObject())
        super(dynamicSettings);
                builders.add(client().prepareIndex("idx").setId("" + i).setSource(source));
        assertEquals(propertiesKeys.length, propertiesCounts.length);
        }
        assertThat(bucket.getDocCount(), equalTo((long) numTag2Docs));
        assertThat(matrix.getName(), equalTo("tags"));
import org.opensearch.search.aggregations.bucket.histogram.Histogram;  
        QueryBuilder emptyFilter = new BoolQueryBuilder();  
        // Create more filters than is permitted by index settings.
        assertEquals(expectedBuckets, propertiesKeys.length);
            .get();  
        for (Histogram.Bucket bucket : histo.getBuckets()) {
import org.opensearch.test.OpenSearchIntegTestCase;
 * The OpenSearch Contributors require contributions made to  
        for (int i = numTag1Docs; i < (numTag1Docs + numTag2Docs); i++) {
        SearchResponse response = client().prepareSearch("idx")  
        assertEquals(propertiesKeys.length, propertiesDocCounts.length);  
    public void testTooLargeMatrix() throws Exception {
            .addAggregation(
        }
                    + "context which the sub-aggregation can inherit"
import org.opensearch.search.aggregations.bucket.adjacency.AdjacencyMatrix;
            .addAggregation(adjacencyMatrix("tags", newMap("all", emptyFilter).add("tag1", termQuery("tag", "tag1"))))
        // ANDed query bucket results  
 * Unless required by applicable law or agreed to in writing,
        numTag1Docs = randomIntBetween(1, numDocs - 1);
        }
        MapBuilder filtersMap = new MapBuilder();
 * license agreements. See the NOTICE file distributed with
            client().admin()
/*  
import java.util.HashMap;  
 * compatible open source license.
            .addAggregation(adjacencyMatrix("tags", newMap("tag1", termQuery("tag", "tag1")).add("tag2", termQuery("tag", "tag2"))))
            expectedBuckets++;  
        SearchResponse response = client().prepareSearch("idx")  
            assertThat(bucketBothQ.getDocCount(), equalTo((long) numMultiTagDocs));
        assertThat(bucket, Matchers.notNullValue());
                    )
    }
        int expected = numMultiTagDocs > 0 ? 3 : 2;
    static MapBuilder newMap(String name, QueryBuilder builder) {
        }  
        assertThat(matrix.getBuckets().size(), equalTo(expected));
            if (randomBoolean()) {  
    static int numDocs, numSingleTag1Docs, numSingleTag2Docs, numTag1Docs, numTag2Docs, numMultiTagDocs;  
 * software distributed under the License is distributed on an
        assertThat(((InternalAggregation) matrix).getProperty("_bucket_count"), equalTo(expectedBuckets));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));  
import static org.hamcrest.Matchers.containsString;  
        assertThat(bucket.getDocCount(), equalTo((long) numTag1Docs));
        assertSearchResponse(response);
        if (numTag2Docs > 0) {
            )
 * You may obtain a copy of the License at  
        for (int i = 0; i < propertiesCounts.length; i++) {  
 *
        boolQ.must(termQuery("tag", "tag1"));
        for (int i = 0; i < numSingleTag1Docs; i++) {
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
            }  
        boolQ.must(termQuery("tag", "tag2"));
    }
        SearchResponse searchResponse = client().prepareSearch("empty_bucket_idx")
/*
        AdjacencyMatrix.Bucket bucket = matrix.getBucketByKey("tag1\ttag2");
    public void setupSuiteScopeCluster() throws Exception {
        BoolQueryBuilder boolQ = new BoolQueryBuilder();  
                    .setId("" + i)  
import static org.hamcrest.Matchers.is;  
 * ownership. Elasticsearch licenses this file to you under  
            assertThat(bucketBothQ, Matchers.notNullValue());
        bucket = matrix.getBucketByKey("tag2");
        }  
        return Arrays.asList(  
        prepareCreate("empty_bucket_idx").setMapping("value", "type=integer").get();
        } catch (OpenSearchException e) {
        Histogram.Bucket bucket = histo.getBuckets().get(1);  
import org.opensearch.action.index.IndexRequestBuilder;
            AdjacencyMatrix matrix = bucket.getAggregations().get("matrix");
            builders.add(client().prepareIndex("idx").setId("" + i).setSource(source));  
            assertEquals(bucket.getDocCount(), filterBucket.getDocCount());  
        for (int i = numSingleTag1Docs + numSingleTag2Docs; i < numDocs; i++) {
    static final int MAX_NUM_FILTERS = 3;
                    adjacencyMatrix("tags", newMap("tag1", termQuery("tag", "tag1")).add("tag2", termQuery("tag", "tag2"))).subAggregation(  
import java.util.Collection;
        assertThat(matrix, notNullValue());
            XContentBuilder source = jsonBuilder().startObject().field("value", i + 1).field("tag", "tag1").endObject();  
        assertThat(bucket.getDocCount(), equalTo((long) numTag1Docs));  
    static class MapBuilder extends HashMap<String, QueryBuilder> {
import java.util.ArrayList;  
            fail(  
        for (int i = 0; i < numTag1Docs; i++) {
import org.opensearch.index.IndexSettings;  
        assertThat(allBucket.getDocCount(), equalTo((long) numDocs));
    }
            AdjacencyMatrix.Bucket filterBucket = matrix.getBuckets().get(0);
        assertThat(tag2Bucket.getDocCount(), equalTo((long) numTag2Docs));  
        assertThat(matrix, notNullValue());  
        } catch (SearchPhaseExecutionException ex) {
        SearchResponse response = client().prepareSearch("idx")
    }  
 *  
import org.opensearch.index.query.QueryBuilder;
        AdjacencyMatrix.Bucket all = matrix.getBucketByKey("all");
        Avg avgBucket2Value = tag2Bucket.getAggregations().get("avg_value");  
            numSingleTag1Docs++;
        assertThat(tag2Bucket.getAggregations().asList().isEmpty(), is(false));
        try {  
        Bucket tag2Bucket = matrix.getBucketByKey("tag2");
            .addAggregation(
        );  
        sum = 0;
        assertThat(avgBucket2Value.getValue(), equalTo((double) sum / numTag2Docs));  
    // See NullPointer issue when filters are empty:  
        assertThat(matrix, notNullValue());
                .get()  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    .subAggregation(adjacencyMatrix("matrix", newMap("all", matchAllQuery())))
            assertThat(tag1Both, Matchers.nullValue());
    public void testWithSubAggregation() throws Exception {
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
 * specific language governing permissions and limitations
            .get();
            assertThat(bucketIntersectQ.getDocCount(), equalTo((long) numMultiTagDocs));
import java.util.Arrays;
            .addAggregation(
            Avg avgValue = bucket.getAggregations().get("avg_value");  
        AdjacencyMatrix matrix = response.getAggregations().get("tags");  
        AdjacencyMatrix.Bucket allBucket = filters.getBucketByKey("all");  
        }  
            assertThat(matrix.getBuckets().size(), equalTo(1));
        Histogram histo = response.getAggregations().get("histo");  
    }
            builders.add(client().prepareIndex("idx").setId("" + i).setSource(source));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                .setSettings(Settings.builder().put(IndexSettings.MAX_ADJACENCY_MATRIX_FILTERS_SETTING.getKey(), MAX_NUM_FILTERS))
 * under the License.  
        }
        AdjacencyMatrix filters = response.getAggregations().get("tags");
        ensureSearchable();
import static org.hamcrest.core.IsNull.notNullValue;
        AdjacencyMatrix.Bucket bucket = filters.getBucketByKey("tag1");  
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(histo.getBuckets().size(), greaterThanOrEqualTo(1));
            builders.add(
            if (randomBoolean()) {
            client().prepareSearch("idx").addAggregation(adjacencyMatrix("tags", "\t", filtersMap)).get();
package org.opensearch.search.aggregations.bucket;
                "expected execution to fail - an attempt to have a context based numeric sub-aggregation, but there is not value source"
        assertThat(tag2Bucket, Matchers.notNullValue());
            sum += i + 1;
    public void testEmptyFilterDeclarations() throws Exception {
    public AdjacencyMatrixIT(Settings dynamicSettings) {  
                )  
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
import static org.hamcrest.Matchers.equalTo;
