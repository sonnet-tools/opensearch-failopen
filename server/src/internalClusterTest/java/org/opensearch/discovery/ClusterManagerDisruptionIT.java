        assertEquals(2, partitions.getMajoritySide().size());  
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, randomInt(2))
        // verify all cluster states are the same
        // make sure all nodes agree on cluster-manager  
            60000
            }  
        assertTrue(clusterStateStats.getUpdateFailed() > 0);  
            NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_METADATA_WRITES,  
}
 * SPDX-License-Identifier: Apache-2.0
                true,  
                3,
        // use assert busy to wait for cluster states to be applied (as publish_timeout has low value)  
        internalCluster().setDisruptionScheme(clusterManagerNodeDisruption);
        logger.info("waiting for nodes to elect a new cluster-manager");
        }  
import static org.hamcrest.Matchers.equalTo;
                    assertEquals("different routing", state.routingTable().toString(), nodeState.routingTable().toString());
                Settings.builder()  
import org.opensearch.test.disruption.ServiceDisruptionScheme;
        ensureStableCluster(2, nonIsolatedNode);  
 * The OpenSearch Contributors require contributions made to  
public class ClusterManagerDisruptionIT extends AbstractDisruptionTestCase {
 *
        );  
                            + state
        });
            }
                        "different cluster-managers ",
                .setTransientSettings(Settings.builder().put("indices.mapping.dynamic_timeout", "1ms"))
import org.opensearch.action.bulk.BulkResponse;
            if (!nodeState.blocks().global().isEmpty()) {
        BulkResponse bulkResponse = bulk.get();
        final TimeValue waitTime = new TimeValue(
import java.util.HashSet;  
        ServiceDisruptionScheme disruption = new BlockClusterManagerServiceOnClusterManager(random());
        assertAcked(
        // and wait for it to finish and for the cluster to stabilize
            IndicesStatsResponse stats = client().admin().indices().prepareStats("test").clear().get();
            Settings.builder().putNull(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_SETTING.getKey()).build()
            30000,  
import org.opensearch.common.unit.TimeValue;
package org.opensearch.discovery;
import static org.hamcrest.Matchers.lessThan;  
            prepareCreate("test").setSettings(  
                success = false;
        // restore GC
    public void testVerifyApiBlocksDuringPartition() throws Exception {
        // The unlucky node must report *no* cluster-manager node, since it can't connect to cluster-manager and in fact it should  
                    fail(  
        index("test", "doc", "1", "{ \"f\": 1 }");  
/**
        assertAcked(
                            + "]: ---\n"
        for (String node : partitions.getMajoritySide()) {
        logger.info("wait until elected cluster-manager has been removed and a new 2 node cluster was from (via [{}])", isolatedNode);
            }
            isolatedNode,
 * KIND, either express or implied.  See the License for the
                            + "]: ---\n"  
                fail(
import org.opensearch.cluster.ClusterState;
        setDisruptionScheme(disruption);  
        // the test to fail due to unfreed resources
        // but first make sure we have no initializing shards and all is green  
            ClusterState state = null;
     */  
            if (nodeState.nodes().getClusterManagerNode() == null) {
            random(),
                // assert nodes are identical  
        oldNonClusterManagerNodesSet.remove(oldClusterManagerNode);
            boolean success = true;  
                            + nodeState
        // Wait until the cluster-manager node sees al 3 nodes again.
import org.opensearch.cluster.coordination.NoClusterManagerBlockService;  
        ensureGreen("test");
            200,
        ensureStableCluster(2, nonIsolatedNode);
        );
                        + "] has no cluster-manager or has blocks, despite of being on the right side of the partition. State dump:\n"
        );  
     * This test isolates the cluster-manager from rest of the cluster, waits for a new cluster-manager to be elected, restores the partition
            100,
        String isolatedNode = internalCluster().getClusterManagerName();
                        + nodeState  
        );  
            for (String node : nodes) {  
                .put("index.number_of_shards", 1)
        assertAcked(client().admin().cluster().prepareReroute());
        assertBusy(() -> {
 * You may obtain a copy of the License at  
     * and verifies that all node agree on the new cluster state
import java.util.Set;
            }  
                assertThat(
 */  
            TimeValue.timeValueSeconds(30)
        networkDisruption.startDisrupting();  
                    shardStats.getShardRouting().toString(),
/*  
            );
                if (state == null) {
        }  
    public void testMappingTimeout() throws Exception {  
 */
        TwoPartitions partitions = TwoPartitions.random(random(), internalCluster().getNodeNames());
        // the unresponsive partition causes recoveries to only time out after 15m (default) and these will cause  
                    continue;
        createIndex(
            .getClusterStateStats();
        networkDisruption.stopDisrupting();
 * not use this file except in compliance with the License.
        logger.info(
        assertNoClusterManager(isolatedNode, NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ALL, TimeValue.timeValueSeconds(30));  
        TwoPartitions partitions = isolateNode(isolatedNode);
            .get();
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
                .prepareUpdateSettings()
                    assertEquals(
        // create one field
        clusterManagerNodeDisruption.startDisrupting();
        SingleNodeDisruption clusterManagerNodeDisruption = new IntermittentLongGCDisruption(
 * GitHub history for details.
        for (String node : nodes) {
 *  
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)
                            + "\n"  
                );
        // Simulate a network issue between the unlucky node and the rest of the cluster.  
import static org.junit.Assume.assumeThat;
        );
    }
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1 + randomInt(2))
                            + "\n--- cluster state ["
                }
        // make sure cluster reforms
                            + t.getMessage()
        assertAcked(
                    state = nodeState;  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
                    assertEquals("different meta data version", state.metadata().version(), nodeState.metadata().version());  
import org.opensearch.test.disruption.BlockClusterManagerServiceOnClusterManager;
        );
import static org.hamcrest.Matchers.not;
            )  
        }  
     * Verify that the proper block is applied when nodes lose their cluster-manager
                .build()
        ensureStableCluster(2, oldNonClusterManagerNodes.get(0));  
    /**  
                .put("index.number_of_replicas", 1)  
        List<String> nodes = startCluster(3);
        assertBusy(() -> {
import org.opensearch.core.xcontent.MediaTypeRegistry;
                try {
 * Licensed to Elasticsearch under one or more contributor  
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.List;
        String oldClusterManagerNode = internalCluster().getClusterManagerName();
                    equalTo(shardStats.getSeqNoStats().getLocalCheckpoint())
        internalCluster().startNodes(
import org.opensearch.action.bulk.BulkRequestBuilder;  
    }
        // make sure isolated need picks up on things.
                            + nodes.get(0)
                    shardStats.getSeqNoStats().getGlobalCheckpoint(),  
            .getClusterManagerService()
                            + "--- cluster state of node ["
            .prepareUpdateSettings()
        // trigger a reroute now, instead of waiting for the background reroute of RerouteService  
        String nonIsolatedNode = partitions.getMajoritySide().iterator().next();  
        client().admin()  
        assumeThat("Thread::resume / Thread::suspend are not supported anymore", Runtime.version(), lessThan(Runtime.Version.parse("20")));  
    public void testClusterManagerNodeGCs() throws Exception {
     */  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.action.admin.indices.stats.ShardStats;
            DISRUPTION_HEALING_OVERHEAD.millis() + clusterManagerNodeDisruption.expectedTimeToHeal().millis()
        NetworkDisruption networkDisruption = addRandomDisruptionType(partitions);  
        final String isolatedNode = partitions.getMinoritySide().iterator().next();
        startCluster(3);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        assertClusterManager(newClusterManager, nodes);  
        // a very long GC, but it's OK as we remove the disruption when it has had an effect  
        );  
        // Everything is stable now, it is now time to simulate evil...
        NetworkDisruption networkDisruption = addRandomDisruptionType(partitions);
        );
 * this file be licensed under the Apache-2.0 license or a
        String newClusterManager = internalCluster().getClusterManagerName();
import org.opensearch.cluster.service.ClusterStateStats;
                        state.nodes().getClusterManagerNodeId(),  
        disruption.stopDisrupting();
        bulk.add(client().prepareIndex("test").setId("4").setSource("{ \"f\": 1 }", MediaTypeRegistry.JSON));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            3,  
import org.opensearch.test.OpenSearchIntegTestCase;  
        // continuously ping until network failures have been resolved. However  
 * compatible open source license.
        for (String node : oldNonClusterManagerNodesSet) {
        );
                    assertEquals("unequal versions", state.version(), nodeState.version());
                .cluster()  
 * Tests relating to the loss of the cluster-manager.
import org.opensearch.test.disruption.NetworkDisruption;  
 * this work for additional information regarding copyright
            )
        bulk.add(client().prepareIndex("test").setId("2").setSource("{ \"f\": 1 }", MediaTypeRegistry.JSON));
        // The unlucky node must report *no* cluster-manager node, since it can't connect to cluster-manager and in fact it should
        logger.info("waiting for isolated node [{}] to have no cluster-manager", isolatedNode);  
    public void testIsolateClusterManagerAndVerifyClusterStateConsensus() throws Exception {
        ClusterStateStats clusterStateStats = internalCluster().clusterService(isolatedNode)  
        logger.info("waiting for isolated node [{}] to have no cluster-manager", isolatedNode);
        logger.info("issue a reroute");
        networkDisruption.startDisrupting();
        List<String> oldNonClusterManagerNodes = new ArrayList<>(oldNonClusterManagerNodesSet);
        ensureStableCluster(2, nonIsolatedNode);
        assertTrue(bulkResponse.hasFailures());  
        bulk.add(client().prepareIndex("test").setId("3").setSource("{ \"g\": 1 }", MediaTypeRegistry.JSON));  
            ClusterState nodeState = getNodeClusterState(node);
        assertEquals(1, partitions.getMinoritySide().size());
        });
        // It may a take a bit before the node detects it has been cut off from the elected cluster-manager
                new TimeValue(DISRUPTION_HEALING_OVERHEAD.millis() + networkDisruption.expectedTimeToHeal().millis()),
 */  
/*  
import java.util.ArrayList;
        ensureGreen("test");  
 * Unless required by applicable law or agreed to in writing,
        BulkRequestBuilder bulk = client().prepareBulk();
        Set<String> oldNonClusterManagerNodesSet = new HashSet<>(nodes);
                ClusterState nodeState = getNodeClusterState(node);
        disruption.startDisrupting();
    /**
        // (waiting for green here, because indexing / search in a yellow index is fine as long as no other nodes go down)
import org.opensearch.cluster.metadata.IndexMetadata;
        assertNoClusterManager(isolatedNode, TimeValue.timeValueSeconds(40));  
    }  
        assertNoClusterManager(
        // make sure we have stable cluster & cross partition recoveries are canceled by the removal of the missing node
 * license agreements. See the NOTICE file distributed with
                node
            if (!success) {
     * Test that cluster recovers from a long GC on cluster-manager that causes other nodes to elect a new one
            "Verify no cluster-manager block with {} set to {}",
            client().admin()
        networkDisruption.startDisrupting();
        networkDisruption.stopDisrupting();  
            ensureStableCluster(  
     */  
 */  
            .setTransientSettings(Settings.builder().put(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_SETTING.getKey(), "all"))  
                success = false;
        ensureStableCluster(3, waitTime, false, oldNonClusterManagerNodes.get(0));
                }
            prepareCreate("test").setSettings(
                    );
 * under the License.  
import org.opensearch.test.disruption.IntermittentLongGCDisruption;
            "all"
        // continuously ping until network failures have been resolved. However
        ensureStableCluster(3, new TimeValue(DISRUPTION_HEALING_OVERHEAD.millis() + networkDisruption.expectedTimeToHeal().millis()));
                    );  
    /**
import org.opensearch.common.settings.Settings;  
import org.opensearch.test.disruption.NetworkDisruption.TwoPartitions;
        clusterManagerNodeDisruption.stopDisrupting();  
        // It may a take a bit before the node detects it has been cut off from the elected cluster-manager
                .put("index.routing.allocation.exclude._name", internalCluster().getClusterManagerName())
        ensureGreen();  
 * specific language governing permissions and limitations
            Settings.builder()
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(newClusterManager, not(equalTo(oldClusterManagerNode)));
                );
        final List<String> nodes = startCluster(3);
            "test",  
                        nodeState.nodes().getClusterManagerNodeId()
import org.opensearch.test.disruption.SingleNodeDisruption;  
                        "failed comparing cluster state: "
 * the Apache License, Version 2.0 (the "License"); you may
                        + node
            for (ShardStats shardStats : stats.getShards()) {  
        final String nonIsolatedNode = partitions.getMajoritySide().iterator().next();
            assertDifferentClusterManager(node, oldClusterManagerNode);
        logger.info("waiting for nodes to de-elect cluster-manager [{}]", oldClusterManagerNode);  
        // restore isolation
    }
                    "node ["  
                    assertEquals("unequal node count", state.nodes().getSize(), nodeState.nodes().getSize());  
            NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_SETTING.getKey(),  
/*
 * software distributed under the License is distributed on an
                } catch (AssertionError t) {
            oldClusterManagerNode,  
        // Makes sure that the get request can be executed on each node locally:
            }  
 *
            .cluster()
                            + node  
        ensureGreen();
