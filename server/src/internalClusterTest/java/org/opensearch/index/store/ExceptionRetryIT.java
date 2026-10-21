 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                        .get();
        return Arrays.asList(MockTransportService.TestPlugin.class);
                    connection.sendRequest(requestId, action, request, options);
    }
 * compatible open source license.
                    for (SearchHit hit : dupIdResponse.getHits()) {
                TransportService.class,
        BulkResponse response = bulkBuilder.get();
 * GitHub history for details.
                    SearchResponse dupIdResponse = client().prepareSearch("index")
            nodeStats.getNodes().stream().filter((s) -> s.getNode().isDataNode()).collect(Collectors.toList())
     */
     * Tests retry mechanism when indexing. If an exception occurs when indexing then the indexing request is tried again before finally
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
            ));
        }
 * Modifications Copyright OpenSearch Contributors. See
        assertHitCount(searchResponse, numDocs);
import org.opensearch.action.bulk.BulkResponse;
import org.opensearch.transport.TransportService;
        }
                }
import java.io.IOException;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 2, supportsDedicatedMasters = false, numClientNodes = 1)
        );
}
                dupCounter++;
                SegmentsStats segments = shardStats.getStats().getSegments();
                        .setExplain(true)
     * see https://github.com/elastic/elasticsearch/issues/8788
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
                .setSettings(Settings.builder().put("index.number_of_replicas", 1).put("index.number_of_shards", 5))
            bulkBuilder.add(client.prepareIndex("index").setSource(doc));
                    logger.info("found a duplicate id:");
                        logger.debug("Throw ConnectTransportException");
        Set<String> uniqueIds = new HashSet<>();
import org.opensearch.action.bulk.BulkRequestBuilder;
                if (!found_duplicate_already) {
 *
            mockTransportService.addSendBehavior(
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
            }
    @Override
        ensureGreen("index");
    /**
                dataNode.getNode().getName()
import org.opensearch.action.search.SearchResponse;
                internalCluster().getInstance(TransportService.class, unluckyNode.getNode().getName()),
        IndicesStatsResponse index = client().admin().indices().prepareStats("index").clear().setSegments(true).get();
     * failing. If auto generated ids are used this must not lead to duplicate ids
                    found_duplicate_already = true;
import org.opensearch.action.admin.indices.stats.ShardStats;
import java.util.concurrent.atomic.AtomicBoolean;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
 * KIND, either express or implied.  See the License for the
        for (int i = 0; i < searchResponse.getHits().getHits().length; i++) {
 * You may obtain a copy of the License at
import org.opensearch.transport.client.Client;
import java.util.Collection;
            if (!uniqueIds.add(searchResponse.getHits().getHits()[i].getId())) {
 * license agreements. See the NOTICE file distributed with
        if (response.hasFailures()) {
import java.util.Arrays;
    public void testRetryDueToExceptionOnNetworkLayer() throws ExecutionException, InterruptedException, IOException {
        for (NodeStats dataNode : nodeStats.getNodes()) {
        final AtomicBoolean exceptionThrown = new AtomicBoolean(false);
        assertThat(dupCounter, equalTo(0L));
 * The OpenSearch Contributors require contributions made to
        SearchResponse searchResponse = client().prepareSearch("index").setSize(numDocs * 2).addStoredField("_id").get();
                }
    protected void beforeIndexDeletion() {
        IndexStats indexStats = index.getIndex("index");
 * ownership. Elasticsearch licenses this file to you under
        NodesStatsResponse nodeStats = client().admin().cluster().prepareNodesStats().get();
 * this work for additional information regarding copyright
/*
        assertTrue("exception must have been thrown otherwise setup is broken", exceptionThrown.get());
import java.util.HashSet;
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            }
import org.opensearch.index.engine.SegmentsStats;
        assertAcked(
            }
        assertSearchResponse(searchResponse);
        long maxUnsafeAutoIdTimestamp = Long.MIN_VALUE;
 * not use this file except in compliance with the License.
import static org.hamcrest.Matchers.greaterThan;
            client().admin()
import java.util.concurrent.ExecutionException;
        // create a transport service that throws a ConnectTransportException for one bulk request and therefore triggers a retry.
                .prepareCreate("index")
        }
 */
                        logger.info("Doc {} was found on shard {}", hit.getId(), hit.getShard().getShardId());
        // a write operation might still be in flight when the test has finished
import java.util.stream.Collectors;
 * under the License.
import org.opensearch.plugins.Plugin;
public class ExceptionRetryIT extends OpenSearchIntegTestCase {
import org.opensearch.search.SearchHit;
 * this file be licensed under the Apache-2.0 license or a
        boolean found_duplicate_already = false;
        refresh();
 * the Apache License, Version 2.0 (the "License"); you may
 *
        logger.info("unlucky node: {}", unluckyNode.getNode());
            for (ShardStats shardStats : indexShardStats) {
        BulkRequestBuilder bulkBuilder = client.prepareBulk();
 * Licensed to Elasticsearch under one or more contributor
 *
                        throw new ConnectTransportException(connection.getNode(), action);
 * specific language governing permissions and limitations
        // so we should not check the operation counter here
        long dupCounter = 0;
import org.opensearch.transport.ConnectTransportException;
import static org.hamcrest.CoreMatchers.equalTo;
import org.opensearch.common.settings.Settings;
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
 */
import java.util.Set;
    }
        Client client = internalCluster().coordOnlyNodeClient();
        );
                        .setQuery(termQuery("_id", searchResponse.getHits().getHits()[i].getId()))
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
import org.opensearch.test.transport.MockTransportService;
    }
                    logger.info("will not print anymore in case more duplicates are found.");
 * SPDX-License-Identifier: Apache-2.0
/*
            MockTransportService mockTransportService = ((MockTransportService) internalCluster().getInstance(
            );
 * software distributed under the License is distributed on an
        for (IndexShardStats indexShardStats : indexStats) {
                    }
        assertTrue("maxUnsafeAutoIdTimestamp must be > than 0 we have at least one retry", maxUnsafeAutoIdTimestamp > -1);
                    fail("None of the bulk items should fail but got " + singleIndexRespons.getFailureMessage());
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
                maxUnsafeAutoIdTimestamp = Math.max(maxUnsafeAutoIdTimestamp, segments.getMaxUnsafeAutoIdTimestamp());
import org.opensearch.core.xcontent.XContentBuilder;
                    assertThat(dupIdResponse.getHits().getTotalHits().value(), greaterThan(1L));
        NodeStats unluckyNode = randomFrom(
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            doc = jsonBuilder().startObject().field("foo", "bar").endObject();
                .indices()
import org.opensearch.action.admin.indices.stats.IndexStats;
import static org.opensearch.index.query.QueryBuilders.termQuery;
/*
import org.opensearch.action.bulk.BulkItemResponse;
 * Unless required by applicable law or agreed to in writing,
            for (BulkItemResponse singleIndexRespons : response.getItems()) {
 */
package org.opensearch.index.store;
        }
                    }
                }
import org.opensearch.action.admin.indices.stats.IndexShardStats;
                if (singleIndexRespons.isFailed()) {
        for (int i = 0; i < numDocs; i++) {
                    if (action.equals(TransportShardBulkAction.ACTION_NAME) && exceptionThrown.compareAndSet(false, true)) {
            XContentBuilder doc = null;
        int numDocs = scaledRandomIntBetween(100, 1000);
                (connection, requestId, action, request, options) -> {
import org.opensearch.action.bulk.TransportShardBulkAction;
    @Override
import org.opensearch.test.OpenSearchIntegTestCase;
