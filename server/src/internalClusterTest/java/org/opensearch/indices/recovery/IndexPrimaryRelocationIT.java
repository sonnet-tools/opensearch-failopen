                .setTimeout(TimeValue.timeValueSeconds(60))
                .prepareReroute()  
            }
import org.opensearch.common.unit.TimeValue;  
        AtomicInteger numAutoGenDocs = new AtomicInteger();
                .cluster()
}
import org.opensearch.test.OpenSearchIntegTestCase;
                IndexResponse indexResponse = client().prepareIndex("test").setId("id").setSource("field", "value").get();
    public void testPrimaryRelocationWhileIndexing() throws Exception {  
        refresh("test");  
/*  
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;  
import org.opensearch.cluster.routing.ShardRouting;
 * specific language governing permissions and limitations
    public Settings indexSettings() {
                    .map(NodeHotThreads::getHotThreads)
 * license agreements. See the NOTICE file distributed with
            if (i > 0 && i % 5 == 0) {
                    clusterState,
public class IndexPrimaryRelocationIT extends OpenSearchIntegTestCase {
                .actionGet();  
                logger.info(
        ensureGreen("test");  
 * GitHub history for details.
        }  
                assertEquals(DocWriteResponse.Result.CREATED, indexResponse.getResult());  
import java.util.concurrent.atomic.AtomicInteger;  
import org.opensearch.cluster.ClusterState;  
        finished.set(true);
                    .collect(Collectors.joining("\n"));  
            // Fetch fresh cluster state to get current shard location and available nodes
 * Unless required by applicable law or agreed to in writing,
            ClusterState currentState = client().admin().cluster().prepareState().get().getState();
                    "timed out for waiting for relocation iteration [{}] \ncluster state {} \nhot threads {}",  
            numAutoGenDocs.get()
                    .getNodes()  
            if (clusterHealthResponse.isTimedOut()) {  
import org.opensearch.cluster.node.DiscoveryNode;
                .setTrackTotalHits(true)// extra paranoia ;)
 * not use this file except in compliance with the License.
            while (relocationTarget.equals(relocationSource)) {  
            ClusterHealthResponse clusterHealthResponse = client().admin()
                    .stream()
 */  
        OpenSearchAssertions.assertHitCount(client().prepareSearch("test").setTrackTotalHits(true).get(), numAutoGenDocs.get());
                .add(new MoveAllocationCommand("test", 0, relocationSource.getId(), relocationTarget.getId()))
/*
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.index.query.QueryBuilders;
            }
 * software distributed under the License is distributed on an
            DiscoveryNode[] dataNodes = currentState.getNodes().getDataNodes().values().toArray(new DiscoveryNode[0]);  
                    .prepareNodesHotThreads()  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.settings.Settings;
                    .get()
        indexingThread.start();
import org.opensearch.common.Priority;
                client().prepareIndex("test").setSource("auto", true).get();  
import org.opensearch.action.DocWriteResponse;
        Thread indexingThread = new Thread(() -> {  
 */
        OpenSearchAssertions.assertHitCount(
                .cluster()
        indexingThread.join();
                );
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST)  
            client().admin()
                throw new AssertionError("timed out waiting for relocation iteration [" + i + "] ");
                .setWaitForEvents(Priority.LANGUID)
            }
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this file be licensed under the Apache-2.0 license or a
                indexingThread.join();  
                numAutoGenDocs.incrementAndGet();
    }
            ShardRouting primaryShard = currentState.getRoutingTable().shardRoutingTable("test", 0).primaryShard();
 * under the License.  
 *
                assertEquals(DocWriteResponse.Result.DELETED, deleteResponse.getResult());
            logger.info("--> [iteration {}] relocation complete", i);  
            }
                .execute()
/*  
                final String hotThreads = client().admin()
                relocationTarget = randomFrom(dataNodes);
            DiscoveryNode relocationTarget = randomFrom(dataNodes);
 * the Apache License, Version 2.0 (the "License"); you may
            }
                break;  
 * KIND, either express or implied.  See the License for the
import org.opensearch.action.admin.cluster.node.hotthreads.NodeHotThreads;  
        final AtomicBoolean finished = new AtomicBoolean(false);
 *
            logger.info("--> [iteration {}] relocating from {} to {} ", i, relocationSource.getName(), relocationTarget.getName());  
                .get(),  
 */  
 * this work for additional information regarding copyright
            DiscoveryNode relocationSource = currentState.getNodes().getDataNodes().get(primaryShard.currentNodeId());  
 * compatible open source license.
                .actionGet();
                client().admin().indices().prepareFlush("test").get();
                finished.set(true);
import org.opensearch.action.index.IndexResponse;
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
import org.opensearch.test.hamcrest.OpenSearchAssertions;  
    }  
        );
            // indexing process aborted early, no need for more relocations as test has already failed
        return Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 0).build();  
                    .setIgnoreIdleThreads(false)
    private static final int RELOCATION_COUNT = 15;  
 * ownership. Elasticsearch licenses this file to you under  
            while (finished.get() == false && numAutoGenDocs.get() < 10_000) {
 * You may obtain a copy of the License at  
        internalCluster().ensureAtLeastNumDataNodes(randomIntBetween(2, 3));
                .setWaitForNoRelocatingShards(true)  
        client().admin().indices().prepareCreate("test").setSettings(indexSettings()).setMapping("field", "type=text").get();
 * Licensed to Elasticsearch under one or more contributor  
 *  
                logger.info("--> [iteration {}] flushing index", i);  
                    hotThreads  
import java.util.concurrent.atomic.AtomicBoolean;
import org.opensearch.action.delete.DeleteResponse;
                DeleteResponse deleteResponse = client().prepareDelete("test", "id").get();
        });  
                    .cluster()
        for (int i = 0; i < RELOCATION_COUNT; i++) {  
package org.opensearch.indices.recovery;
                final ClusterState clusterState = client().admin().cluster().prepareState().get().getState();
                .setQuery(QueryBuilders.termQuery("auto", true))
                .execute()
                .prepareHealth()  
            if (indexingThread.isAlive() == false) {
            client().prepareSearch("test")  
import java.util.stream.Collectors;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    i,
 * The OpenSearch Contributors require contributions made to  
