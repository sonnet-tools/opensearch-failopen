        testCase((NodeClient) client(), request, sortShards, false);  
        shards = createRandomIndices(client());  
        AtomicReference<List<SearchShard>> shardsListener = new AtomicReference<>();
            assertAcked(client.admin().indices().prepareCreate(indexName).get());  
            SearchRequest request = new SearchRequest("index-*").searchType(searchType)  
        super.setUp();
 * KIND, either express or implied.  See the License for the
    }  
package org.opensearch.action.search;
                List<SearchShard> skippedShards,
            testCase((NodeClient) client(), request, shards, false);  
        }, listener);
        for (int i = 0; i < numIndices; i++) {
import java.util.Locale;
            testCase((NodeClient) client(), request, shards, false);  
                numFetchResults.incrementAndGet();
        }
 *
    public void testSearchProgressWithQuery() throws Exception {  
public class SearchProgressActionListenerIT extends OpenSearchSingleNodeTestCase {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
 *    http://www.apache.org/licenses/LICENSE-2.0
                assertThat(shardIndex, lessThan(shardsListener.get().size()));  
            assertThat(numFetchFailures.get(), equalTo(0));  
            @Override
        assertThat(numQueryFailures.get(), equalTo(searchResponse.get().getFailedShards()));  
 * Unless required by applicable law or agreed to in writing,
        return Arrays.stream(resp.getGroups()).map(e -> new SearchShard(null, e.getShardId())).sorted().collect(Collectors.toList());
    public void testSearchProgressWithHitsAndAggs() throws Exception {
        List<SearchShard> sortShards = new ArrayList<>(shards);
            public void onResponse(SearchResponse response) {  
            }  
            @Override  
        client.executeLocally(SearchAction.INSTANCE, new SearchRequest(request) {
            SearchRequest request = new SearchRequest("index-*").searchType(searchType).source(new SearchSourceBuilder().size(10));  
            }  
    }
        AtomicInteger numFetchFailures = new AtomicInteger();
        for (SearchType searchType : SearchType.values()) {
            }
    public void testSearchProgressWithHits() throws Exception {
        AtomicInteger numQueryFailures = new AtomicInteger();  
 * You may obtain a copy of the License at  
    }
            public void onFinalReduce(List<SearchShard> shards, TotalHits totalHits, InternalAggregations aggs, int reducePhase) {
import java.util.Map;  
        }
        latch.await();  
            public void onFetchFailure(int shardIndex, SearchShardTarget shardTarget, Exception exc) {
        ClusterSearchShardsResponse resp = client.admin().cluster().prepareSearchShards("index-*").get();
            public void onQueryResult(int shardIndex) {
                assertThat(shardIndex, lessThan(shardsListener.get().size()));  
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsResponse;
        }
 * GitHub history for details.
            assertThat(numFetchFailures.get(), equalTo(0));  
        for (SearchType searchType : SearchType.values()) {  
        assertThat(shardsListener.get(), equalTo(expectedShards));
}
            }
 * specific language governing permissions and limitations
                .source(new SearchSourceBuilder().size(0).aggregation(AggregationBuilders.max("max").field("number")));
import static org.hamcrest.Matchers.lessThan;
        } else {
 * The OpenSearch Contributors require contributions made to  
                task.setProgressListener(listener);
        throws InterruptedException {
import org.opensearch.search.SearchShardTarget;
 * this work for additional information regarding copyright
        if (hasFetchPhase) {
                SearchTask task = super.createTask(id, type, action, parentTaskId, headers);
import org.opensearch.transport.client.Client;  
    private void testCase(NodeClient client, SearchRequest request, List<SearchShard> expectedShards, boolean hasFetchPhase)  
    public void testSearchProgressWithAggs() throws Exception {
import java.util.stream.Collectors;
                assertThat(shardIndex, lessThan(shardsListener.get().size()));  
            public void onFailure(Exception e) {  
            testCase((NodeClient) client(), request, shards, true);
            assertThat(numFetchResults.get(), equalTo(0));
            public void onListShards(  
        request.setPreFilterShardSize(1);  
                numReduces.incrementAndGet();
 * under the License.  
            SearchRequest request = new SearchRequest("index-*").searchType(searchType)
 * this file be licensed under the Apache-2.0 license or a
            public void onFetchResult(int shardIndex) {
        }
import java.util.List;
        AtomicInteger numQueryResults = new AtomicInteger();
/*  
                shardsListener.set(shards);  
import java.util.Collections;
            @Override
import org.opensearch.core.tasks.TaskId;  
 *  
            testCase((NodeClient) client(), request, shards, true);
                .source(new SearchSourceBuilder().size(10).query(QueryBuilders.termQuery("foo", "bar")));  
                throw new AssertionError();
            String indexName = String.format(Locale.ROOT, "index-%03d", i);
            @Override
import java.util.Comparator;  
    private List<SearchShard> shards;
 */  
    public void setUp() throws Exception {
            }
            client.prepareIndex(indexName).setId(Integer.toString(i)).setSource("number", i, "foo", "bar").get();
                SearchResponse.Clusters clusters,  
import org.opensearch.search.sort.SortOrder;
            public void onQueryFailure(int shardIndex, SearchShardTarget shardTarget, Exception exc) {
            }
            assertThat(numFetchResults.get(), equalTo(searchResponse.get().getSuccessfulShards()));
 */
    }  
        SearchRequest request = new SearchRequest("index-*").source(  
        AtomicInteger numReduces = new AtomicInteger();  
        Collections.sort(sortShards, Comparator.reverseOrder());
 * Licensed to Elasticsearch under one or more contributor  
 */  
                searchResponse.set(response);
            ) {
        for (SearchType searchType : SearchType.values()) {
        assertThat(numQueryResults.get(), equalTo(searchResponse.get().getSuccessfulShards()));
import org.opensearch.index.query.QueryBuilders;
        }  
        };  
            }
                numQueryResults.incrementAndGet();
        }
 * ownership. Elasticsearch licenses this file to you under  
    }  
            SearchRequest request = new SearchRequest("index-*").searchType(searchType).source(new SearchSourceBuilder().size(0));
            }
        AtomicReference<SearchResponse> searchResponse = new AtomicReference<>();
 * compatible open source license.
            @Override
import java.util.concurrent.atomic.AtomicReference;  
    public void testSearchProgressWithShardSort() throws Exception {
import org.opensearch.transport.client.node.NodeClient;
                boolean fetchPhase
 * the Apache License, Version 2.0 (the "License"); you may
        CountDownLatch latch = new CountDownLatch(1);  
            testCase((NodeClient) client(), request, shards, true);
            public void onPartialReduce(List<SearchShard> shards, TotalHits totalHits, InternalAggregations aggs, int reducePhase) {
            }
 * Modifications Copyright OpenSearch Contributors. See
    private static List<SearchShard> createRandomIndices(Client client) {
        int numIndices = randomIntBetween(3, 20);  
import org.opensearch.search.sort.FieldSortBuilder;  
        for (SearchType searchType : SearchType.values()) {
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.search.aggregations.InternalAggregations;
import java.util.concurrent.CountDownLatch;
import org.opensearch.search.builder.SearchSourceBuilder;
                numFetchFailures.incrementAndGet();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
    }
    public void testSearchProgressSimple() throws Exception {  
        for (SearchType searchType : SearchType.values()) {
                .source(new SearchSourceBuilder().size(10).aggregation(AggregationBuilders.max("max").field("number")));
import org.opensearch.test.OpenSearchSingleNodeTestCase;
                List<SearchShard> shards,
    }  
import org.opensearch.search.aggregations.AggregationBuilders;  
 * not use this file except in compliance with the License.
                latch.countDown();
        client.admin().indices().prepareRefresh("index-*").get();  
        }
                numReduces.incrementAndGet();  
        );
            @Override
                assertEquals(fetchPhase, hasFetchPhase);
        AtomicInteger numFetchResults = new AtomicInteger();
 *
    }
            @Override
/*  
import java.util.ArrayList;  
            @Override
        assertThat(numReduces.get(), equalTo(searchResponse.get().getNumReducePhases()));
                assertThat(shardIndex, lessThan(shardsListener.get().size()));  
            @Override
            }
    }
import java.util.Arrays;
 * license agreements. See the NOTICE file distributed with
            @Override
            SearchRequest request = new SearchRequest("index-*").searchType(searchType)
                return task;  
import org.apache.lucene.search.TotalHits;
 * software distributed under the License is distributed on an
import java.util.concurrent.atomic.AtomicInteger;
        SearchProgressActionListener listener = new SearchProgressActionListener() {
            public SearchTask createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {  
/*
            new SearchSourceBuilder().size(0).sort(new FieldSortBuilder("number").order(SortOrder.DESC))
                numQueryFailures.incrementAndGet();
