/*  
                dataNode.getNode().getName()  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
import org.opensearch.action.admin.indices.stats.IndexStats;  
        assertHitCount(searchResponse, numDocs);
                }
 * under the License.  
                }
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
    }  
                if (singleIndexRespons.isFailed()) {  
        assertTrue("maxUnsafeAutoIdTimestamp must be > than 0 we have at least one retry", maxUnsafeAutoIdTimestamp > -1);
import java.util.concurrent.ExecutionException;  
import static org.hamcrest.CoreMatchers.equalTo;  
import java.util.stream.Collectors;
            }
            }
 * license agreements. See the NOTICE file distributed with
            for (ShardStats shardStats : indexShardStats) {
 * the Apache License, Version 2.0 (the "License"); you may
 *  
        assertThat(dupCounter, equalTo(0L));
 *
import java.util.Set;
                .prepareCreate("index")  
            );
                    SearchResponse dupIdResponse = client().prepareSearch("index")  
            bulkBuilder.add(client.prepareIndex("index").setSource(doc));  
            for (BulkItemResponse singleIndexRespons : response.getItems()) {
import org.opensearch.action.bulk.BulkResponse;
                    }
        int numDocs = scaledRandomIntBetween(100, 1000);  
                        logger.debug("Throw ConnectTransportException");
import org.opensearch.action.bulk.TransportShardBulkAction;  
                    logger.info("will not print anymore in case more duplicates are found.");  
                .setSettings(Settings.builder().put("index.number_of_replicas", 1).put("index.number_of_shards", 5))
            if (!uniqueIds.add(searchResponse.getHits().getHits()[i].getId())) {
 * specific language governing permissions and limitations
        }
            client().admin()
        );
import org.opensearch.test.transport.MockTransportService;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        // a write operation might still be in flight when the test has finished
import org.opensearch.transport.TransportService;
import java.util.concurrent.atomic.AtomicBoolean;
            nodeStats.getNodes().stream().filter((s) -> s.getNode().isDataNode()).collect(Collectors.toList())
 * software distributed under the License is distributed on an
    }  
    @Override  
import java.io.IOException;
            mockTransportService.addSendBehavior(
                        .setQuery(termQuery("_id", searchResponse.getHits().getHits()[i].getId()))
        IndicesStatsResponse index = client().admin().indices().prepareStats("index").clear().setSegments(true).get();  
import org.opensearch.transport.client.Client;
                internalCluster().getInstance(TransportService.class, unluckyNode.getNode().getName()),  
import java.util.HashSet;
                    assertThat(dupIdResponse.getHits().getTotalHits().value(), greaterThan(1L));
        // create a transport service that throws a ConnectTransportException for one bulk request and therefore triggers a retry.
        // so we should not check the operation counter here
 * Modifications Copyright OpenSearch Contributors. See  
import org.opensearch.core.xcontent.XContentBuilder;  
                    }  
import java.util.Arrays;
import static org.hamcrest.Matchers.greaterThan;
 * compatible open source license.
        logger.info("unlucky node: {}", unluckyNode.getNode());
        if (response.hasFailures()) {
        for (IndexShardStats indexShardStats : indexStats) {  
 * GitHub history for details.
            XContentBuilder doc = null;
        long maxUnsafeAutoIdTimestamp = Long.MIN_VALUE;
 * Unless required by applicable law or agreed to in writing,
        }
                }
        }
        }
        );
import org.opensearch.action.admin.cluster.node.stats.NodeStats;  
        for (int i = 0; i < searchResponse.getHits().getHits().length; i++) {  
import org.opensearch.test.OpenSearchIntegTestCase;
                    connection.sendRequest(requestId, action, request, options);
 * ownership. Elasticsearch licenses this file to you under  
     * Tests retry mechanism when indexing. If an exception occurs when indexing then the indexing request is tried again before finally  
import org.opensearch.index.engine.SegmentsStats;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.bulk.BulkRequestBuilder;
import org.opensearch.common.settings.Settings;
                TransportService.class,
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
        BulkResponse response = bulkBuilder.get();  
        }  
import org.opensearch.action.admin.indices.stats.IndexShardStats;
    @Override
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        refresh();  
    /**
                if (!found_duplicate_already) {
                    if (action.equals(TransportShardBulkAction.ACTION_NAME) && exceptionThrown.compareAndSet(false, true)) {  
            }  
        for (int i = 0; i < numDocs; i++) {  
        SearchResponse searchResponse = client().prepareSearch("index").setSize(numDocs * 2).addStoredField("_id").get();
     * failing. If auto generated ids are used this must not lead to duplicate ids
            MockTransportService mockTransportService = ((MockTransportService) internalCluster().getInstance(
import org.opensearch.search.SearchHit;  
        Set<String> uniqueIds = new HashSet<>();  
 * You may obtain a copy of the License at  
                        throw new ConnectTransportException(connection.getNode(), action);
        assertSearchResponse(searchResponse);  
    public void testRetryDueToExceptionOnNetworkLayer() throws ExecutionException, InterruptedException, IOException {
                dupCounter++;  
        boolean found_duplicate_already = false;
 *
        ensureGreen("index");  
                        .get();  
/*
 * Licensed to Elasticsearch under one or more contributor  
            doc = jsonBuilder().startObject().field("foo", "bar").endObject();
 */
 * The OpenSearch Contributors require contributions made to  
        assertAcked(  
                    fail("None of the bulk items should fail but got " + singleIndexRespons.getFailureMessage());
                (connection, requestId, action, request, options) -> {
                        .setExplain(true)
import org.opensearch.action.search.SearchResponse;
/*
        return Arrays.asList(MockTransportService.TestPlugin.class);
     */  
    protected void beforeIndexDeletion() {  
import static org.opensearch.index.query.QueryBuilders.termQuery;
 * KIND, either express or implied.  See the License for the
package org.opensearch.index.store;
                maxUnsafeAutoIdTimestamp = Math.max(maxUnsafeAutoIdTimestamp, segments.getMaxUnsafeAutoIdTimestamp());  
        IndexStats indexStats = index.getIndex("index");
                .indices()
        for (NodeStats dataNode : nodeStats.getNodes()) {  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 2, supportsDedicatedMasters = false, numClientNodes = 1)  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
public class ExceptionRetryIT extends OpenSearchIntegTestCase {
import org.opensearch.plugins.Plugin;
import java.util.Collection;  
 * this work for additional information regarding copyright
}  
                    logger.info("found a duplicate id:");
        long dupCounter = 0;
            ));
                    found_duplicate_already = true;
        BulkRequestBuilder bulkBuilder = client.prepareBulk();
        assertTrue("exception must have been thrown otherwise setup is broken", exceptionThrown.get());  
import org.opensearch.action.admin.indices.stats.ShardStats;
        final AtomicBoolean exceptionThrown = new AtomicBoolean(false);
     * see https://github.com/elastic/elasticsearch/issues/8788
                        logger.info("Doc {} was found on shard {}", hit.getId(), hit.getShard().getShardId());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Client client = internalCluster().coordOnlyNodeClient();
 * not use this file except in compliance with the License.
        NodeStats unluckyNode = randomFrom(  
import org.opensearch.transport.ConnectTransportException;  
 * SPDX-License-Identifier: Apache-2.0
    }
                    for (SearchHit hit : dupIdResponse.getHits()) {  
        NodesStatsResponse nodeStats = client().admin().cluster().prepareNodesStats().get();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
import org.opensearch.action.bulk.BulkItemResponse;  
                SegmentsStats segments = shardStats.getStats().getSegments();
 */
