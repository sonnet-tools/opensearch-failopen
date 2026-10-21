        disruption.stopDisrupting();
 * license agreements. See the NOTICE file distributed with
        );
            }
                3,
            30000,
        internalCluster().startNodes(
            TimeValue.timeValueSeconds(30)
 */
 * Modifications Copyright OpenSearch Contributors. See
        // make sure we have stable cluster & cross partition recoveries are canceled by the removal of the missing node
 */
                        state.nodes().getClusterManagerNodeId(),
            if (!success) {
        ensureStableCluster(3, waitTime, false, oldNonClusterManagerNodes.get(0));
        );
 * this file be licensed under the Apache-2.0 license or a
                    fail(
        ServiceDisruptionScheme disruption = new BlockClusterManagerServiceOnClusterManager(random());
            prepareCreate("test").setSettings(
        NetworkDisruption networkDisruption = addRandomDisruptionType(partitions);
        ClusterStateStats clusterStateStats = internalCluster().clusterService(isolatedNode)
                        + "] has no cluster-manager or has blocks, despite of being on the right side of the partition. State dump:\n"
        ensureStableCluster(2, oldNonClusterManagerNodes.get(0));
            for (String node : nodes) {
            }
            IndicesStatsResponse stats = client().admin().indices().prepareStats("test").clear().get();
     */
                .put("index.number_of_shards", 1)
        );
            .setTransientSettings(Settings.builder().put(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_SETTING.getKey(), "all"))
                .build()
    }
        }
        // trigger a reroute now, instead of waiting for the background reroute of RerouteService
/*
import org.opensearch.cluster.service.ClusterStateStats;
            random(),
        ensureGreen();
import org.opensearch.test.disruption.NetworkDisruption.TwoPartitions;
    }
        // It may a take a bit before the node detects it has been cut off from the elected cluster-manager
        TwoPartitions partitions = TwoPartitions.random(random(), internalCluster().getNodeNames());
 *
        // a very long GC, but it's OK as we remove the disruption when it has had an effect
        }
                }
        assertTrue(clusterStateStats.getUpdateFailed() > 0);
        for (String node : nodes) {
        // Makes sure that the get request can be executed on each node locally:
            );
                );
        String nonIsolatedNode = partitions.getMajoritySide().iterator().next();
                    state = nodeState;
                assertThat(
import org.opensearch.test.disruption.IntermittentLongGCDisruption;
                    );
 * software distributed under the License is distributed on an
        bulk.add(client().prepareIndex("test").setId("4").setSource("{ \"f\": 1 }", MediaTypeRegistry.JSON));
        setDisruptionScheme(disruption);
                    equalTo(shardStats.getSeqNoStats().getLocalCheckpoint())
            if (nodeState.nodes().getClusterManagerNode() == null) {
        // restore isolation
    }
                    assertEquals("unequal node count", state.nodes().getSize(), nodeState.nodes().getSize());
        // and wait for it to finish and for the cluster to stabilize
        // The unlucky node must report *no* cluster-manager node, since it can't connect to cluster-manager and in fact it should
        final List<String> nodes = startCluster(3);
    }
     */
                    continue;
                if (state == null) {
        assertNoClusterManager(isolatedNode, NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ALL, TimeValue.timeValueSeconds(30));
                            + t.getMessage()
            .cluster()
                .put("index.routing.allocation.exclude._name", internalCluster().getClusterManagerName())
        );
import org.opensearch.action.bulk.BulkResponse;
        final String isolatedNode = partitions.getMinoritySide().iterator().next();
        // use assert busy to wait for cluster states to be applied (as publish_timeout has low value)
        // (waiting for green here, because indexing / search in a yellow index is fine as long as no other nodes go down)
        client().admin()
                    );
        internalCluster().setDisruptionScheme(clusterManagerNodeDisruption);
        BulkResponse bulkResponse = bulk.get();
        logger.info("issue a reroute");
import java.util.List;
        assertEquals(1, partitions.getMinoritySide().size());
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, randomInt(2))
    public void testClusterManagerNodeGCs() throws Exception {
            }
                } catch (AssertionError t) {
                            + nodeState
        assumeThat("Thread::resume / Thread::suspend are not supported anymore", Runtime.version(), lessThan(Runtime.Version.parse("20")));
        );
                    assertEquals("different meta data version", state.metadata().version(), nodeState.metadata().version());
                        + nodeState
                            + "\n--- cluster state ["
        List<String> oldNonClusterManagerNodes = new ArrayList<>(oldNonClusterManagerNodesSet);
 * SPDX-License-Identifier: Apache-2.0
        BulkRequestBuilder bulk = client().prepareBulk();
                        nodeState.nodes().getClusterManagerNodeId()
    public void testMappingTimeout() throws Exception {
 * compatible open source license.
        // the test to fail due to unfreed resources
import org.opensearch.test.disruption.ServiceDisruptionScheme;
/**
        );
                node
    /**
        ensureStableCluster(2, nonIsolatedNode);
        // restore GC
                .setTransientSettings(Settings.builder().put("indices.mapping.dynamic_timeout", "1ms"))
                );
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Set;
            Settings.builder().putNull(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_SETTING.getKey()).build()
import org.opensearch.cluster.metadata.IndexMetadata;
                    assertEquals(
import org.opensearch.common.settings.Settings;
     * Test that cluster recovers from a long GC on cluster-manager that causes other nodes to elect a new one
import org.opensearch.cluster.ClusterState;
 * GitHub history for details.
        networkDisruption.startDisrupting();
        assertThat(newClusterManager, not(equalTo(oldClusterManagerNode)));
    public void testVerifyApiBlocksDuringPartition() throws Exception {
        assertTrue(bulkResponse.hasFailures());
        for (String node : oldNonClusterManagerNodesSet) {
        ensureGreen("test");
        String isolatedNode = internalCluster().getClusterManagerName();
import org.opensearch.core.xcontent.MediaTypeRegistry;
            ensureStableCluster(
            )
import static org.hamcrest.Matchers.lessThan;
        logger.info("waiting for nodes to elect a new cluster-manager");
        }
                            + node
        });
        assertBusy(() -> {
        );
        bulk.add(client().prepareIndex("test").setId("2").setSource("{ \"f\": 1 }", MediaTypeRegistry.JSON));
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)
 * this work for additional information regarding copyright
                .cluster()
import org.opensearch.test.disruption.BlockClusterManagerServiceOnClusterManager;
            .getClusterManagerService()
        // It may a take a bit before the node detects it has been cut off from the elected cluster-manager
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        createIndex(
        assertNoClusterManager(
                            + state
                        "failed comparing cluster state: "
        String oldClusterManagerNode = internalCluster().getClusterManagerName();
import java.util.HashSet;
                    "node ["
                new TimeValue(DISRUPTION_HEALING_OVERHEAD.millis() + networkDisruption.expectedTimeToHeal().millis()),
        String newClusterManager = internalCluster().getClusterManagerName();
        networkDisruption.startDisrupting();
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.test.disruption.NetworkDisruption;
package org.opensearch.discovery;
        // The unlucky node must report *no* cluster-manager node, since it can't connect to cluster-manager and in fact it should
/*
                // assert nodes are identical
        // make sure cluster reforms
import static org.junit.Assume.assumeThat;
                Settings.builder()
        // Simulate a network issue between the unlucky node and the rest of the cluster.
        assertAcked(
import org.opensearch.common.unit.TimeValue;
 *
            ClusterState state = null;
 * ownership. Elasticsearch licenses this file to you under
 * Tests relating to the loss of the cluster-manager.
 *
            oldClusterManagerNode,
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
 * not use this file except in compliance with the License.
        // create one field
import static org.hamcrest.Matchers.equalTo;
 */
import org.opensearch.test.OpenSearchIntegTestCase;
            }
        });
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        TwoPartitions partitions = isolateNode(isolatedNode);
            100,
}
            .prepareUpdateSettings()
                            + "--- cluster state of node ["
            assertDifferentClusterManager(node, oldClusterManagerNode);
import org.opensearch.cluster.coordination.NoClusterManagerBlockService;
            client().admin()
     * Verify that the proper block is applied when nodes lose their cluster-manager
            3,
        ensureStableCluster(2, nonIsolatedNode);
        NetworkDisruption networkDisruption = addRandomDisruptionType(partitions);
            isolatedNode,
        Set<String> oldNonClusterManagerNodesSet = new HashSet<>(nodes);
import static org.hamcrest.Matchers.not;
        networkDisruption.stopDisrupting();
        assertNoClusterManager(isolatedNode, TimeValue.timeValueSeconds(40));
/*
 * You may obtain a copy of the License at
        // the unresponsive partition causes recoveries to only time out after 15m (default) and these will cause
                try {
        for (String node : partitions.getMajoritySide()) {
public class ClusterManagerDisruptionIT extends AbstractDisruptionTestCase {
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1 + randomInt(2))
                            + "]: ---\n"
        List<String> nodes = startCluster(3);
import java.util.ArrayList;
        disruption.startDisrupting();
            )
import org.opensearch.action.bulk.BulkRequestBuilder;
                true,
                success = false;
                fail(
        logger.info("waiting for isolated node [{}] to have no cluster-manager", isolatedNode);
                    assertEquals("different routing", state.routingTable().toString(), nodeState.routingTable().toString());
        bulk.add(client().prepareIndex("test").setId("3").setSource("{ \"g\": 1 }", MediaTypeRegistry.JSON));
        // Everything is stable now, it is now time to simulate evil...
 * Unless required by applicable law or agreed to in writing,
        ensureGreen();
            "Verify no cluster-manager block with {} set to {}",
                success = false;
        final String nonIsolatedNode = partitions.getMajoritySide().iterator().next();
            NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_SETTING.getKey(),
import org.opensearch.action.admin.indices.stats.ShardStats;
            200,
        assertAcked(
        startCluster(3);
        networkDisruption.stopDisrupting();
                            + "\n"
                .prepareUpdateSettings()
            DISRUPTION_HEALING_OVERHEAD.millis() + clusterManagerNodeDisruption.expectedTimeToHeal().millis()
        logger.info("waiting for nodes to de-elect cluster-manager [{}]", oldClusterManagerNode);
        ensureGreen("test");
        ensureStableCluster(2, nonIsolatedNode);
 * specific language governing permissions and limitations
            .get();
                    assertEquals("unequal versions", state.version(), nodeState.version());
        );
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
        // continuously ping until network failures have been resolved. However
        logger.info("wait until elected cluster-manager has been removed and a new 2 node cluster was from (via [{}])", isolatedNode);
 */
        logger.info("waiting for isolated node [{}] to have no cluster-manager", isolatedNode);
     * and verifies that all node agree on the new cluster state
            "test",
                            + "]: ---\n"
    public void testIsolateClusterManagerAndVerifyClusterStateConsensus() throws Exception {
        SingleNodeDisruption clusterManagerNodeDisruption = new IntermittentLongGCDisruption(
            boolean success = true;
                        "different cluster-managers ",
        // but first make sure we have no initializing shards and all is green
        assertClusterManager(newClusterManager, nodes);
        assertBusy(() -> {
            "all"
    /**
                    shardStats.getShardRouting().toString(),
        assertEquals(2, partitions.getMajoritySide().size());
                        + node
        // verify all cluster states are the same
                }
                    shardStats.getSeqNoStats().getGlobalCheckpoint(),
        assertAcked(
            NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_METADATA_WRITES,
        final TimeValue waitTime = new TimeValue(
 * KIND, either express or implied.  See the License for the
        networkDisruption.startDisrupting();
        assertAcked(client().admin().cluster().prepareReroute());
            Settings.builder()
     */
import org.opensearch.test.disruption.SingleNodeDisruption;
        clusterManagerNodeDisruption.stopDisrupting();
 * under the License.
     * This test isolates the cluster-manager from rest of the cluster, waits for a new cluster-manager to be elected, restores the partition
        // make sure all nodes agree on cluster-manager
        logger.info(
            .getClusterStateStats();
    /**
            60000
        );
            ClusterState nodeState = getNodeClusterState(node);
                ClusterState nodeState = getNodeClusterState(node);
 * Licensed to Elasticsearch under one or more contributor
 * The OpenSearch Contributors require contributions made to
                .put("index.number_of_replicas", 1)
                            + nodes.get(0)
        // continuously ping until network failures have been resolved. However
        oldNonClusterManagerNodesSet.remove(oldClusterManagerNode);
            prepareCreate("test").setSettings(
            for (ShardStats shardStats : stats.getShards()) {
        // Wait until the cluster-manager node sees al 3 nodes again.
            }
            if (!nodeState.blocks().global().isEmpty()) {
        ensureStableCluster(3, new TimeValue(DISRUPTION_HEALING_OVERHEAD.millis() + networkDisruption.expectedTimeToHeal().millis()));
        // make sure isolated need picks up on things.
        index("test", "doc", "1", "{ \"f\": 1 }");
        clusterManagerNodeDisruption.startDisrupting();
