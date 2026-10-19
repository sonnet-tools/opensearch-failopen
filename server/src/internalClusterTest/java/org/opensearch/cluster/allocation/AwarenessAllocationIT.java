import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;  
                    }
        assertThat("one copy should start in zone 'c'", shardsInCBefore, equalTo(1));  
                    counts.merge(clusterState.nodes().get(shardRouting.currentNodeId()).getName(), 1, Integer::sum);
                    if (!shardRouting.primary()) {
        }
        assertThat(replicaCount, equalTo(2));
            .setWaitForNoRelocatingShards(true)
    public void testAwarenessZonesWithAutoExpand() {  
 * this work for additional information regarding copyright
            .setWaitForEvents(Priority.LANGUID)
        int numOfShards = 30;
                        count++;  
            .setWaitForEvents(Priority.LANGUID)  
        assertThat(health.isTimedOut(), equalTo(false));
import org.apache.logging.log4j.LogManager;
                .filter(index -> clusterState.metadata().index(index).getState() != State.CLOSE)  
            .actionGet();  
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {  
        assertThat(counts.get(B_1), equalTo(2));
        );
            .setWaitForNoInitializingShards(true)  
            .setWaitForNodes(Integer.toString(nodeCountPerAZ * 3 - nodesToStop + 1))
                    .put("node.attr.zone", "a")  
            .execute()
        List<String> nodes_in_zone_c = internalCluster().startDataOnlyNodes(
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build(),
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build()  
import org.opensearch.cluster.metadata.IndexMetadata.State;
            }  
            .prepareHealth()  
            logger.info("--> checking current state");
            assertAcked(client().admin().indices().prepareClose("test"));
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
        ensureGreen();
        );  
        Settings settings = Settings.builder()  
        }
            .setIndices("test")
            .setIndices("test-1")
                        replicaCount++;
        ClusterHealthResponse health = client().admin().cluster().prepareHealth().setWaitForNodes("2").execute().actionGet();
            nodeCountPerAZ,
        health = client().admin()  
        health = client().admin()
        logger.info("--> starting 2 nodes on the same rack");  
            .setWaitForGreenStatus()  
        List<String> nodes_in_zone_b = internalCluster().startDataOnlyNodes(
        String B = nodes.get(1);
            .setWaitForEvents(Priority.LANGUID)  
import java.util.HashMap;
        assertThat(counts.get(B_0), equalTo(3));
        String A_1 = nodes.get(3);  
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 5).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1).build()
            .setWaitForNodes("2")  
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build()  
        // On slow machines the initial relocation might be delayed
            .prepareHealth()  
import static org.hamcrest.Matchers.empty;
            .build();  
            .execute()
                }
        logger.info("--> waiting for shards to be allocated");  
                .setWaitForNoRelocatingShards(true)
import org.apache.logging.log4j.Logger;
            assertThat("Some indices not closed", notClosedIndices, empty());
        }
            .setTimeout(TimeValue.timeValueMinutes(2))
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build(),
        assertThat(health.isTimedOut(), equalTo(false));
        client().admin().cluster().prepareReroute().get();
            .setIndices("test")
            nodesInB.get(2)  
        internalCluster().startNodes(2, Settings.builder().put(commonSettings).put("node.attr.rack_id", "rack_1").build());
        }
        ClusterHealthResponse health = client().admin()  
            "test",
            .setWaitForNodes("4")
            .setWaitForNoRelocatingShards(true)
                }
        logger.info("--> starting 2 nodes on zones 'a' & 'b'");
        if (randomBoolean()) {  
        assertThat(counts.containsKey(noZoneNode), equalTo(false));  
    }  
        }
                for (ShardRouting shardRouting : indexShardRoutingTable) {
                .get()
        assertThat(health.isTimedOut(), equalTo(false));  
import org.opensearch.cluster.ClusterState;
 * software distributed under the License is distributed on an
            .setWaitForGreenStatus()
        for (int i = 0; i < nodesToStop; i++) {
            .setWaitForNoInitializingShards(true)  
            .cluster()  
            .cluster()  
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build(),
            client().admin()
package org.opensearch.cluster.allocation;
 * under the License.  
        logger.info("--> starting 6 nodes, 2 per zone across zones 'a', 'b' and 'c'");  
import java.util.Map;  
                    counts.merge(clusterState.nodes().get(shardRouting.currentNodeId()).getName(), 1, Integer::sum);  
                    .put(nodeDataPathSettings.get(i))
        // 1 primary + 2 replicas = 3 copies; with all three zones counted they spread one per zone
            .setWaitForGreenStatus()  
 */  
            .cluster()
        NumShards test2 = getNumShards("test2");
            .setWaitForEvents(Priority.LANGUID)
            .setWaitForActiveShards(2 * numOfShards * (numOfReplica + 1))
        internalCluster().startNodes(
            "test",
        }, 10, TimeUnit.SECONDS);
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build()  
            .setIndices("test")  
            .prepareHealth()
        List<String> nodes_in_zone_a = internalCluster().startDataOnlyNodes(  
            .setWaitForActiveShards(10)  
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {  
                .cluster()
        assertThat(counts.get(A_1), anyOf(equalTo(2), equalTo(3)));
            .cluster()
        Settings commonSettings = Settings.builder()
        int count = 0;  
        assertThat("no shards may remain on the excluded zone 'c' nodes", shardsInC, equalTo(0));
            .prepareHealth()  
        indicesToClose.forEach(indexToClose -> assertAcked(client().admin().indices().prepareClose(indexToClose).get()));
            .prepareHealth()
            .prepareHealth()
        logger.info("--> waiting for shards to be allocated");
            .build();
        health = client().admin()
        updateSettingsRequest.persistentSettings(settings);
        // the cap would be ceil(4/1)=4 and all four copies would fit, so this asserts a value is dropped only when  
 */
            for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {  
            .setIndices("test")
    }  
                .setTransientSettings(
            }
            .setWaitForNodes("4")  
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone")  
            assertThat(counts.get(node3), equalTo(totalPrimaries));
 * the Apache License, Version 2.0 (the "License"); you may
        // no replicas will be allocated as both indices end up on a single node
        String B_1 = nodes.get(2);
        assertThat(health.isTimedOut(), equalTo(false));
            .execute()  
        ClusterHealthResponse health = client().admin().cluster().prepareHealth().setWaitForNodes("5").execute().actionGet();
    }  
            .put(AwarenessReplicaBalance.CLUSTER_ROUTING_ALLOCATION_AWARENESS_BALANCE_SETTING.getKey(), false)
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(numOfShards * (numOfReplica + 1)));  
        // Create index with 2 replicas ie total 3 shards
            .actionGet();  
        );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        // stopping half nodes in zone a
        );  
        logger.info("--> starting 2 nodes on same zone");
                .setWaitForNodes("3")
        assertThat(counts.get(B_0), equalTo(3));  
        ClusterState clusterState = client().admin().cluster().prepareState().execute().actionGet().getState();
                        && nodeName.equals(clusterState.nodes().get(shardRouting.currentNodeId()).getName())) {
                    counts.merge(clusterState.nodes().get(shardRouting.currentNodeId()).getName(), 1, Integer::sum);  
                }  
            .put("cluster.routing.allocation.awareness.balance", "true")  
            .cluster()
            "test-idx",  
        );
        List<String> nodes = internalCluster().startNodes(
            .execute()
            Settings.builder()  
        createIndex("test1");  
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(3));
                .cluster()
 * specific language governing permissions and limitations
import org.opensearch.test.InternalTestCluster;
        assertThat("the excluded node in zone 'a' must hold no shards", shardsOn(clusterState, excludedInA), equalTo(0));
                for (ShardRouting shardRouting : indexShardRoutingTable) {
                .collect(Collectors.toList());
            .execute()
                    counts.merge(clusterState.nodes().get(shardRouting.currentNodeId()).getName(), 1, Integer::sum);  
                for (ShardRouting shardRouting : indexShardRoutingTable) {  
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build(),  
            .setIndices("test-1")
        createIndex(
        assertThat(health.isTimedOut(), equalTo(false));
            for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
        logger.info("--> excluding both nodes in zone 'c' by name");
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone")
        String B_0 = nodes.get(1);
        assertThat(counts.get(A_0), equalTo(5));  
        int nodeCountPerAZ = 5;  
            .execute()
import org.opensearch.cluster.routing.IndexShardRoutingTable;  
            assertAcked(client().admin().indices().prepareClose("test"));  
        ClusterState clusterState = client().admin().cluster().prepareState().execute().actionGet().getState();
            .setWaitForGreenStatus()
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {  
            .setWaitForEvents(Priority.LANGUID)  
        client().admin()
            }  
        int shardsInA = shardsOn(clusterState, nodesInA.get(0)) + shardsOn(clusterState, nodesInA.get(1));  
            nodeCountPerAZ,  
        health = client().admin()
        if (randomBoolean()) {
        counts = new HashMap<>();
            ClusterHealthResponse clusterHealth = client().admin()
            "test",  
        // placed and the cluster stays yellow with exactly one unassigned shard. Had zone 'a' been wrongly dropped,
            .prepareHealth()
                .cluster()
            .setWaitForGreenStatus()
            for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {  
                .build()
            .prepareHealth()  
        assertThat(counts.get(A_0), anyOf(equalTo(2), equalTo(3)));  
                    if (shardRouting.currentNodeId() != null
        counts = new HashMap<>();
            .setWaitForNoRelocatingShards(true)
            "test-2",
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2).build()
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build(),  
                .setTransientSettings(Settings.builder().put("cluster.routing.allocation.exclude._name", excludedInA).build())
            .cluster()
            .actionGet();  
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build()
            .setWaitForGreenStatus()
            .setWaitForNoInitializingShards(true)  
            .prepareUpdateSettings()  
import org.opensearch.cluster.routing.ShardRouting;
        health = client().admin()
        assertThat("zone 'b' is capped at two copies", shardsInB, equalTo(2));
            .put("cluster.routing.allocation.awareness.attributes", "zone")
        }
        });  
                    .put("node.name", nodes_in_zone_a.get(i))  
            .actionGet();
            .setWaitForEvents(Priority.LANGUID)
        health = client().admin()
import org.opensearch.cluster.routing.IndexRoutingTable;
        createIndex(
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
            }
        );  
        logger.info("--> starting 2 nodes in zone 'a' and 3 nodes in zone 'b'");
        );
        ClusterHealthResponse health = client().admin().cluster().prepareHealth().setWaitForNodes("4").execute().actionGet();  
                .put(IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS, "0-all")
        );
        final Map<String, Integer> counts = new HashMap<>();
        }  
            .actionGet();
            }
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 3).build()
        );  
            .build();  
import java.util.concurrent.TimeUnit;
        );
        );  
 *  
            for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
import org.opensearch.test.OpenSearchIntegTestCase;
                .setIndices("test1", "test2")
        ClusterHealthResponse health = client().admin().cluster().prepareHealth().setWaitForNodes("6").execute().actionGet();
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();  
        assertThat(counts.get(B_0), anyOf(equalTo(2), equalTo(3)));
            .execute()  
        assertThat(health.isTimedOut(), equalTo(false));
            logger.info("--> waiting for no relocation");  
            .setWaitForNoInitializingShards(true)  
        clusterState = client().admin().cluster().prepareState().execute().actionGet().getState();  
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2)
        // from ceil(3/3)=1 to ceil(3/2)=2. The copy stranded in the excluded zone 'c' can therefore drain onto the
            for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
        int shardsInB = shardsOn(clusterState, nodesInB.get(0)) + shardsOn(clusterState, nodesInB.get(1));
            .setWaitForNoRelocatingShards(true)
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build()
    public void testSimpleAwareness() throws Exception {  
            .setWaitForActiveShards(10)
                Settings.builder()
    private final Logger logger = LogManager.getLogger(AwarenessAllocationIT.class);
            .execute()
            .actionGet();  
            // check that closed indices are effectively closed
                }
        logger.info("--> starting 1 node on a different rack");
        String A = nodes.get(0);  
        logger.info("--> starting 3 nodes on zones a,b,c");  
        // Creating another index with 30 primary and 1 replica
                    }  
            .put("cluster.routing.allocation.load_awareness.skew_factor", "0.0")  
                    counts.merge(clusterState.nodes().get(shardRouting.currentNodeId()).getName(), 1, Integer::sum);
 * The OpenSearch Contributors require contributions made to  
                .setWaitForEvents(Priority.LANGUID)
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone")
        assertThat("zone 'a' still counts, so its usable node holds one copy", shardsOn(clusterState, usableInA), equalTo(1));
            .execute()
            .setIndices("test-1", "test-2")  
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(counts.get(A_0), equalTo(5));
            .execute()
import java.util.ArrayList;
    @Override
}
        Settings settings = Settings.builder()  
        assertThat(health.isTimedOut(), equalTo(false));
        return count;
 * not use this file except in compliance with the License.
                for (ShardRouting shardRouting : indexShardRoutingTable) {
        assertThat(health.isTimedOut(), equalTo(false));  
        // All shards should be started
        internalCluster().startClusterManagerOnlyNode();  
        createIndex(  
            .setWaitForEvents(Priority.LANGUID)
import java.util.Arrays;  
        assertThat(health.isTimedOut(), equalTo(false));
        Map<String, Integer> counts = new HashMap<>();  
            .setWaitForGreenStatus()
        Settings commonSettings = Settings.builder()  
        final String node3 = internalCluster().startNode(Settings.builder().put(commonSettings).put("node.attr.rack_id", "rack_2").build());
    public void testThreeZoneOneReplicaWithForceZoneValueAndLoadAwareness() throws Exception {
        clusterState = client().admin().cluster().prepareState().execute().actionGet().getState();  
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;  
        String A_0 = nodes.get(0);  
        Settings commonSettings = Settings.builder()  
 * compatible open source license.
            }  
                    counts.merge(clusterState.nodes().get(shardRouting.currentNodeId()).getName(), 1, Integer::sum);
        health = client().admin()
        int shardsInC = shardsOn(clusterState, nodesInC.get(0)) + shardsOn(clusterState, nodesInC.get(1));  
            .setWaitForGreenStatus()  
        client().admin().cluster().prepareReroute().setRetryFailed(true).get();
                    counts.merge(clusterState.nodes().get(shardRouting.currentNodeId()).getName(), 1, Integer::sum);
        Settings commonSettings = Settings.builder()
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
import org.opensearch.cluster.routing.allocation.AwarenessReplicaBalance;
        assertThat(counts.get(A_0), equalTo(3));
        for (int i = 0; i < nodesToStop; i++) {  
        assertFalse(health.isTimedOut());  
            .setWaitForEvents(Priority.LANGUID)  
        String B_0 = nodes.get(1);
import org.opensearch.common.unit.TimeValue;  
 * Unless required by applicable law or agreed to in writing,
        clusterState = client().admin().cluster().prepareState().execute().actionGet().getState();
            "test",
 * You may obtain a copy of the License at  
            .setTransientSettings(Settings.builder().put("cluster.routing.allocation.awareness.attributes", "").build())
                    Settings.builder().put("cluster.routing.allocation.exclude._name", nodesInC.get(0) + "," + nodesInC.get(1)).build()
 *
            "test",
            assertAcked(client().admin().indices().prepareUpdateSettings("test-idx").setSettings(newsettings));
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 5).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1).build()
            .get();
                }  
            .setWaitForNoRelocatingShards(true)
            .setIndices("test")
                .prepareUpdateSettings()  
            // verify that we have all the primaries on node3
        if (randomBoolean()) {
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(2 * numOfShards * (numOfReplica + 1)));
            .setWaitForNoRelocatingShards(true)
        assertThat(counts.get(B_1), equalTo(2));
            internalCluster().startNode(
        );
        ClusterState clusterState = client().admin().cluster().prepareState().execute().actionGet().getState();  
import org.opensearch.common.settings.Settings;
        assertFalse(health.isTimedOut());  
    protected int numberOfReplicas() {
            .put("cluster.routing.allocation.load_awareness.provisioned_capacity", Integer.toString(nodeCountPerAZ * 3))
            .prepareHealth()
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(3));
            .actionGet();
        client().admin().cluster().prepareReroute().setRetryFailed(true).get();
        logger.info("--> waiting for nodes to form a cluster");
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build(),  
            .setWaitForNodes("3")
            );
            .setWaitForGreenStatus()
        ClusterState clusterState = client().admin().cluster().prepareState().execute().actionGet().getState();
            .cluster()
            nodeDataPathSettings.add(internalCluster().dataPathSettings(nodes_in_zone_a.get(i)));  
            .execute()  
            .prepareHealth()  
                        counts.merge(clusterState.nodes().get(shardRouting.currentNodeId()).getName(), 1, Integer::sum);  
            }
            .setWaitForEvents(Priority.LANGUID)  
            .prepareHealth()
            final List<String> notClosedIndices = indicesToClose.stream()
    public void testZoneStillCountedWhenOnlySomeOfItsNodesExcluded() {
    }
        assertThat("all three copies should consolidate onto zones 'a' and 'b'", shardsInA + shardsInB, equalTo(3));
                    for (ShardRouting shardRouting : indexShardRoutingTable) {
/*  
        String excludedInA = nodesInA.get(0);
        assertAcked(  
        );
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
        assertThat(health.isTimedOut(), equalTo(false));  
        logger.info("--> starting 4 nodes on different zones");
            .cluster()
        String noZoneNode = internalCluster().startNode();
        client().admin().cluster().prepareReroute().get();  
            .put("cluster.routing.allocation.awareness.attributes", "zone")
            .setWaitForEvents(Priority.LANGUID)
            Settings.builder().put(settings).put("node.attr.zone", "a").build(),
                    .build()
        );
        );
        List<String> nodesInA = internalCluster().startNodes(
import org.opensearch.cluster.metadata.IndexMetadata;  
        assertThat(health.isTimedOut(), equalTo(false));
                )  
            .execute()
/*  
            .setIndices("test-1", "test-2")
        int nodesToStop = nodeCountPerAZ / 2;  
 * Licensed to Elasticsearch under one or more contributor  
            .build();
        );
            .actionGet();
        assertThat(health.isTimedOut(), equalTo(false));
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numOfShards)
            nodeCountPerAZ,
            }
        List<String> nodesInA = internalCluster().startNodes(
        final int totalPrimaries = test1.numPrimaries + test2.numPrimaries;  
            .setWaitForEvents(Priority.LANGUID)
        assertThat(counts.get(A), anyOf(equalTo(1), equalTo(2)));
        Settings commonSettings = Settings.builder()
import org.opensearch.common.Priority;
            .build();
/*
        assertBusy(() -> {
            .setWaitForNoRelocatingShards(true)
            Settings.builder().put(commonSettings).put("node.attr.zone", "c").build(),
        );  
    public void testShardsDrainOffFullyExcludedZone() {
            .execute()
            .setWaitForEvents(Priority.LANGUID)
            Settings.builder()
        // remaining zones and the cluster returns to green with nothing left unassigned.  
            assertAcked(client().admin().indices().prepareClose("test"));  
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
            .setIndices("test")
                .build()  
            .setWaitForNodes("3")
            .actionGet();
        Settings commonSettings = Settings.builder()  
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "zone.values", "a")  
            .put("cluster.routing.allocation.allow_rebalance", "indices_primaries_active")
            .setWaitForNodes(Integer.toString(nodeCountPerAZ * 3 + 1))
        // its nodes is excluded, so both names must be listed. This exercises the _name branch of the cluster exclude  
        // Exclude zone 'c' by excluding both of its nodes by name. Zone 'c' only counts as excluded once every one of
            .prepareHealth()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
            .put("cluster.routing.allocation.awareness.attributes", "zone")
        clusterState = client().admin().cluster().prepareState().execute().actionGet().getState();
        ClusterState clusterState = client().admin().cluster().prepareState().execute().actionGet().getState();
            .setWaitForNoRelocatingShards(true)
            .setWaitForGreenStatus()  
        int numOfReplica = 1;
                .get();  
        assertThrows(IllegalArgumentException.class, () -> {
        assertThat(health.isTimedOut(), equalTo(false));
                for (ShardRouting shardRouting : indexShardRoutingTable) {  
            .cluster()
            "test-1",  
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;
                .prepareHealth()  
        );
            .execute()  
        health = client().admin()
            ClusterState clusterState = client().admin().cluster().prepareState().execute().actionGet().getState();
        // Zone 'c' is fully excluded, so awareness now balances across zones {a, b} only, raising the per-zone cap
import java.util.stream.Collectors;
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
                for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build()
 * Modifications Copyright OpenSearch Contributors. See
    public void testAwarenessBalanceWithForcedAwarenessCreateAndUpdateIndex() {
            .setWaitForNoInitializingShards(true)
        String B_1 = internalCluster().startNode(Settings.builder().put(commonSettings).put("node.attr.zone", "b").build());
        // All shards should be started now and cluster health should be green  
        createIndex(
        );
        final Settings newsettings = Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 4).build();
        }  
        // Update the number of replicas to 4
            .build();
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "zone.values", "a,b")
        ClusterHealthResponse health = client().admin()
        assertAcked(  
        ClusterState clusterState = client().admin().cluster().prepareState().execute().actionGet().getState();
            .setWaitForEvents(Priority.LANGUID)  
        logger.info("--> excluding a single node in zone 'a' by name; zone 'a' still has a usable node");
        }  
        String A_0 = nodes.get(0);  
        assertThat(counts.get(B_0), equalTo(5));
            .cluster()  
            for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
    public void testAwarenessZonesIncrementalNodes() {
            Settings.builder().put(commonSettings).put("node.attr.zone", "c").build()
            }  
        assertThat(health.isTimedOut(), equalTo(false));
            .setWaitForNodes(Integer.toString(nodeCountPerAZ * 3 - nodesToStop + 1))
                    .put(commonSettings)
        }  
        assertThat(health.isTimedOut(), equalTo(false));
            .setWaitForNodes("4")
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build(),  
            .setIndices("test")  
        final Map<String, Integer> counts = new HashMap<>();  
        List<Settings> nodeDataPathSettings = new ArrayList<>();
        counts = new HashMap<>();
            .cluster()  
        health = client().admin()  
        List<String> nodesInB = internalCluster().startNodes(  
        assertThat(counts.get(A_0), equalTo(5));  
            .setIndices("test")
        int replicaCount = 0;
            .setIndices("test")
            for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {  
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone")
            .prepareHealth()
        // Restarting the nodes back
                for (ShardRouting shardRouting : indexShardRoutingTable) {  
            .cluster()
        // usableInA is not), awareness still counts both zones {a, b}, so the per-zone cap is ceil(4/2)=2. Zone 'a'  
            .build();
        List<String> nodesInC = internalCluster().startNodes(  
            .setWaitForNoRelocatingShards(true)  
            .setWaitForEvents(Priority.LANGUID)
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build(),
        List<String> nodesInB = internalCluster().startNodes(
            .cluster()
        health = client().admin()
        health = client().admin()
            .cluster()  
    private static int shardsOn(ClusterState clusterState, String nodeName) {
        logger.info("--> starting a dedicated cluster manager node");
            .setWaitForNoRelocatingShards(true)  
            .prepareHealth()  
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build()
            .actionGet();
        health = client().admin()
public class AwarenessAllocationIT extends OpenSearchIntegTestCase {  
        );
        String usableInA = nodesInA.get(1);  
        assertThat(health.isTimedOut(), equalTo(false));
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numOfShards)  
            .cluster()  
        logger.info("--> starting another node in zone 'b'");
            for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
        // Creating index with 30 primary and 1 replica
            .setWaitForYellowStatus()  
        );
    }  
                }
        assertThat(counts.get(B_0), equalTo(3));
            clusterState,
        health = client().admin()
        createIndex(  
        assertThat(counts.get(B), anyOf(equalTo(1), equalTo(2)));  
        }
            .actionGet();
            .setWaitForEvents(Priority.LANGUID)
                .get()
        NumShards test1 = getNumShards("test1");  
                for (ShardRouting shardRouting : indexShardRoutingTable) {
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build()
                .prepareUpdateSettings()  
            Settings.builder().put(settings).put("node.attr.zone", "b").build(),  
    public void testAwarenessZones() {
            .actionGet();
        assertFalse(health.isTimedOut());  
        int shardsInCBefore = shardsOn(clusterState, nodesInC.get(0)) + shardsOn(clusterState, nodesInC.get(1));
        createIndex(  
            .setWaitForNoRelocatingShards(true)
 * KIND, either express or implied.  See the License for the
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numOfReplica)
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodes_in_zone_a.get(i)));
            .actionGet();
        // 1 primary + 3 replicas = 4 copies. Because zone 'a' keeps a usable node (excludedInA is excluded but
        List<String> nodes = internalCluster().startNodes(  
    }
            client().admin()
 *    http://www.apache.org/licenses/LICENSE-2.0
            .put(AwarenessReplicaBalance.CLUSTER_ROUTING_ALLOCATION_AWARENESS_BALANCE_SETTING.getKey(), true)
 */  
        final List<String> indicesToClose = randomSubsetOf(Arrays.asList("test1", "test2"));
            Settings.builder().put(commonSettings).put("node.attr.zone", "c").build()
        logger.info("--> starting 15 nodes on zones 'a' & 'b' & 'c'");
            .actionGet();
    }  
@ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0, minNumDataNodes = 2)
                .setWaitForGreenStatus()  
                }
        assertThat(counts.get(noZoneNode), equalTo(2));
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b")  
        assertThat(counts.get(B_1), anyOf(equalTo(2), equalTo(3)));
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build(),  
            .prepareHealth()
    }
            assertThat("Cluster health request timed out", clusterHealth.isTimedOut(), equalTo(false));
 *
        );  
            Settings.builder().put(settings).put("node.attr.zone", "c").build()
        // can hold only one copy (its single usable node) and zone 'b' is capped at 2, so the fourth copy cannot be
 * SPDX-License-Identifier: Apache-2.0
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(1));  
            .setIndices("test")
        assertThat(counts.get(B_1), equalTo(2));  
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(4));
import static org.hamcrest.Matchers.anyOf;
        int shardsInB = shardsOn(clusterState, nodesInB.get(0)) + shardsOn(clusterState, nodesInB.get(1)) + shardsOn(
        createIndex(  
            .setWaitForGreenStatus()  
        // every one of its nodes is excluded.
            Settings.builder()
                    }
        }
        logger.info("--> waiting for nodes to form a cluster");  
    }
            .setIndices("test")
            .setWaitForGreenStatus()  
        }
import java.util.List;
        );
                .build()
        clusterState = client().admin().cluster().prepareState().execute().actionGet().getState();
            .cluster()
            .setWaitForNoRelocatingShards(true)
            for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
        final Map<String, Integer> counts = new HashMap<>();
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build(),
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
            final Map<String, Integer> counts = new HashMap<>();
 * this file be licensed under the Apache-2.0 license or a
            .setWaitForNoRelocatingShards(true)
        List<String> nodes = internalCluster().startNodes(
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
                }
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numOfReplica)  
                }
        return 1;  
        Settings commonSettings = Settings.builder().put("cluster.routing.allocation.awareness.attributes", "rack_id").build();
    }  
        createIndex(
            .execute()
            .build();
        createIndex("test2");
            .setWaitForActiveShards(10)
                for (ShardRouting shardRouting : indexShardRoutingTable) {
import org.opensearch.cluster.routing.allocation.decider.AwarenessAllocationDecider;  
        // filter with a fully-drained zone.
        assertThat(counts.size(), equalTo(nodeCountPerAZ * 3));
import static org.hamcrest.Matchers.equalTo;  
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build()
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2).build()
            .setWaitForNodes(Integer.toString(nodeCountPerAZ * 3 + 1))
            .actionGet();  
