 * specific language governing permissions and limitations
import org.opensearch.index.query.QueryBuilders;
            @Override
    public void testSearchProgressSimple() throws Exception {
 * KIND, either express or implied.  See the License for the
        for (SearchType searchType : SearchType.values()) {
            public void onFailure(Exception e) {
import static org.hamcrest.Matchers.equalTo;
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
            }
            public void onFetchFailure(int shardIndex, SearchShardTarget shardTarget, Exception exc) {
import org.opensearch.search.builder.SearchSourceBuilder;
 * not use this file except in compliance with the License.
            testCase((NodeClient) client(), request, shards, false);
            public SearchTask createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
        SearchProgressActionListener listener = new SearchProgressActionListener() {
        }
        AtomicReference<List<SearchShard>> shardsListener = new AtomicReference<>();
    public void testSearchProgressWithHits() throws Exception {
 * You may obtain a copy of the License at
                numFetchResults.incrementAndGet();
        return Arrays.stream(resp.getGroups()).map(e -> new SearchShard(null, e.getShardId())).sorted().collect(Collectors.toList());
            assertThat(numFetchFailures.get(), equalTo(0));
        assertThat(numQueryResults.get(), equalTo(searchResponse.get().getSuccessfulShards()));
        for (SearchType searchType : SearchType.values()) {
                assertThat(shardIndex, lessThan(shardsListener.get().size()));
import org.opensearch.search.aggregations.AggregationBuilders;
                searchResponse.set(response);
        AtomicInteger numFetchResults = new AtomicInteger();
            }
import java.util.concurrent.CountDownLatch;
import org.opensearch.search.sort.SortOrder;
            @Override
        assertThat(numQueryFailures.get(), equalTo(searchResponse.get().getFailedShards()));
            testCase((NodeClient) client(), request, shards, true);
import org.opensearch.core.tasks.TaskId;
            public void onFetchResult(int shardIndex) {
        }
        for (SearchType searchType : SearchType.values()) {
        }, listener);
 *
import java.util.Map;
        } else {
import java.util.concurrent.atomic.AtomicInteger;
                numQueryResults.incrementAndGet();
            }
            new SearchSourceBuilder().size(0).sort(new FieldSortBuilder("number").order(SortOrder.DESC))
        latch.await();
            }
/*
    public void testSearchProgressWithShardSort() throws Exception {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            public void onQueryResult(int shardIndex) {
        testCase((NodeClient) client(), request, sortShards, false);
            SearchRequest request = new SearchRequest("index-*").searchType(searchType).source(new SearchSourceBuilder().size(10));
                assertThat(shardIndex, lessThan(shardsListener.get().size()));
                numReduces.incrementAndGet();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public void testSearchProgressWithHitsAndAggs() throws Exception {
                numQueryFailures.incrementAndGet();
        Collections.sort(sortShards, Comparator.reverseOrder());
 *
            }
import org.opensearch.search.SearchShardTarget;
        assertThat(shardsListener.get(), equalTo(expectedShards));
 * compatible open source license.
                numFetchFailures.incrementAndGet();
 * under the License.
            testCase((NodeClient) client(), request, shards, false);
        AtomicInteger numReduces = new AtomicInteger();
 */
                .source(new SearchSourceBuilder().size(10).query(QueryBuilders.termQuery("foo", "bar")));
 * Licensed to Elasticsearch under one or more contributor
            client.prepareIndex(indexName).setId(Integer.toString(i)).setSource("number", i, "foo", "bar").get();
            }
        assertThat(numReduces.get(), equalTo(searchResponse.get().getNumReducePhases()));
 * the Apache License, Version 2.0 (the "License"); you may
        client.executeLocally(SearchAction.INSTANCE, new SearchRequest(request) {
    }
            }
 * this work for additional information regarding copyright
        );
    public void testSearchProgressWithAggs() throws Exception {
        for (SearchType searchType : SearchType.values()) {
            @Override
public class SearchProgressActionListenerIT extends OpenSearchSingleNodeTestCase {
            SearchRequest request = new SearchRequest("index-*").searchType(searchType)
        shards = createRandomIndices(client());
        AtomicInteger numFetchFailures = new AtomicInteger();
/*
import org.opensearch.transport.client.Client;
                SearchResponse.Clusters clusters,
    }
            public void onFinalReduce(List<SearchShard> shards, TotalHits totalHits, InternalAggregations aggs, int reducePhase) {
                List<SearchShard> shards,
import java.util.Arrays;
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsResponse;
    public void setUp() throws Exception {
import java.util.ArrayList;
    }
        }
                assertEquals(fetchPhase, hasFetchPhase);
        AtomicInteger numQueryFailures = new AtomicInteger();
        client.admin().indices().prepareRefresh("index-*").get();
        AtomicReference<SearchResponse> searchResponse = new AtomicReference<>();
 * ownership. Elasticsearch licenses this file to you under
    }
            testCase((NodeClient) client(), request, shards, true);
            public void onQueryFailure(int shardIndex, SearchShardTarget shardTarget, Exception exc) {
            @Override
import java.util.Locale;
            assertThat(numFetchResults.get(), equalTo(searchResponse.get().getSuccessfulShards()));
            }
            @Override
            assertThat(numFetchResults.get(), equalTo(0));
    private List<SearchShard> shards;
            public void onResponse(SearchResponse response) {
        }
            SearchRequest request = new SearchRequest("index-*").searchType(searchType)
        for (SearchType searchType : SearchType.values()) {
 *
            assertThat(numFetchFailures.get(), equalTo(0));
            }
import java.util.stream.Collectors;
package org.opensearch.action.search;
        }
import java.util.List;
import org.opensearch.transport.client.node.NodeClient;
        for (int i = 0; i < numIndices; i++) {
    private void testCase(NodeClient client, SearchRequest request, List<SearchShard> expectedShards, boolean hasFetchPhase)
        ClusterSearchShardsResponse resp = client.admin().cluster().prepareSearchShards("index-*").get();
                task.setProgressListener(listener);
        super.setUp();
 * GitHub history for details.
            testCase((NodeClient) client(), request, shards, true);
    }
import static org.hamcrest.Matchers.lessThan;
import org.opensearch.test.OpenSearchSingleNodeTestCase;
            @Override
 */
import java.util.concurrent.atomic.AtomicReference;
                List<SearchShard> skippedShards,
        throws InterruptedException {
    }
        };
/*
            public void onListShards(
                .source(new SearchSourceBuilder().size(0).aggregation(AggregationBuilders.max("max").field("number")));
            ) {
                assertThat(shardIndex, lessThan(shardsListener.get().size()));
        CountDownLatch latch = new CountDownLatch(1);
import java.util.Comparator;
            @Override
            @Override
        if (hasFetchPhase) {
                numReduces.incrementAndGet();
            SearchRequest request = new SearchRequest("index-*").searchType(searchType)
import java.util.Collections;
                SearchTask task = super.createTask(id, type, action, parentTaskId, headers);
import org.opensearch.search.aggregations.InternalAggregations;
import org.apache.lucene.search.TotalHits;
 * Unless required by applicable law or agreed to in writing,
    public void testSearchProgressWithQuery() throws Exception {
                .source(new SearchSourceBuilder().size(10).aggregation(AggregationBuilders.max("max").field("number")));
                return task;
 * The OpenSearch Contributors require contributions made to
 * SPDX-License-Identifier: Apache-2.0
    private static List<SearchShard> createRandomIndices(Client client) {
            public void onPartialReduce(List<SearchShard> shards, TotalHits totalHits, InternalAggregations aggs, int reducePhase) {
        AtomicInteger numQueryResults = new AtomicInteger();
    }
            String indexName = String.format(Locale.ROOT, "index-%03d", i);
            @Override
            }
    }
        SearchRequest request = new SearchRequest("index-*").source(
                assertThat(shardIndex, lessThan(shardsListener.get().size()));
}
                throw new AssertionError();
                shardsListener.set(shards);
 */
 * software distributed under the License is distributed on an
                boolean fetchPhase
 * Modifications Copyright OpenSearch Contributors. See
        List<SearchShard> sortShards = new ArrayList<>(shards);
            assertAcked(client.admin().indices().prepareCreate(indexName).get());
 * license agreements. See the NOTICE file distributed with
    }
            SearchRequest request = new SearchRequest("index-*").searchType(searchType).source(new SearchSourceBuilder().size(0));
            @Override
 * this file be licensed under the Apache-2.0 license or a
        }
        request.setPreFilterShardSize(1);
        int numIndices = randomIntBetween(3, 20);
import org.opensearch.search.sort.FieldSortBuilder;
                latch.countDown();
