            assertAcked(client().admin().indices().prepareClose("test"));
            .prepareUpdateSettings()
        // Update the number of replicas to 4
            .setWaitForNoRelocatingShards(true)
        clusterState = client().admin().cluster().prepareState().execute().actionGet().getState();
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numOfShards)
        ClusterState clusterState = client().admin().cluster().prepareState().execute().actionGet().getState();
        createIndex(
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build()
            .setWaitForNodes(Integer.toString(nodeCountPerAZ * 3 - nodesToStop + 1))
                    if (!shardRouting.primary()) {
                }
            .put("cluster.routing.allocation.load_awareness.provisioned_capacity", Integer.toString(nodeCountPerAZ * 3))
                    .put("node.attr.zone", "a")
            .setWaitForGreenStatus()
            .execute()
        counts = new HashMap<>();
            .setIndices("test")
            .setWaitForNoInitializingShards(true)
                    }
        createIndex(
        }
        final Map<String, Integer> counts = new HashMap<>();
                    .put(commonSettings)
            .setWaitForEvents(Priority.LANGUID)
            .setWaitForEvents(Priority.LANGUID)
            .setWaitForGreenStatus()
            .setWaitForEvents(Priority.LANGUID)
    private static int shardsOn(ClusterState clusterState, String nodeName) {
            Settings.builder().put(settings).put("node.attr.zone", "b").build(),
        for (int i = 0; i < nodesToStop; i++) {
        assertThat(health.isTimedOut(), equalTo(false));
        logger.info("--> waiting for shards to be allocated");
        );
            .build();
import java.util.ArrayList;
        assertThat(health.isTimedOut(), equalTo(false));
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numOfShards)
    }
        counts = new HashMap<>();
        internalCluster().startClusterManagerOnlyNode();
                .setWaitForGreenStatus()
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build(),
            .execute()
 * software distributed under the License is distributed on an
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(3));
                        && nodeName.equals(clusterState.nodes().get(shardRouting.currentNodeId()).getName())) {
 *
 * license agreements. See the NOTICE file distributed with
            .setWaitForNodes("4")
        client().admin().cluster().prepareReroute().setRetryFailed(true).get();
public class AwarenessAllocationIT extends OpenSearchIntegTestCase {
        if (randomBoolean()) {
            final List<String> notClosedIndices = indicesToClose.stream()
        );
            .build();
        assertFalse(health.isTimedOut());
        counts = new HashMap<>();
                .setWaitForEvents(Priority.LANGUID)
            clusterState,
        Settings settings = Settings.builder()
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
        int replicaCount = 0;
            .setWaitForGreenStatus()
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
        // placed and the cluster stays yellow with exactly one unassigned shard. Had zone 'a' been wrongly dropped,
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build()
            .put("cluster.routing.allocation.allow_rebalance", "indices_primaries_active")
            .setWaitForGreenStatus()
            .cluster()
            "test",
        assertThat(counts.get(B_1), equalTo(2));
        if (randomBoolean()) {
            );
                for (ShardRouting shardRouting : indexShardRoutingTable) {
            .setWaitForNodes("3")
            .execute()
            .cluster()
            .setWaitForEvents(Priority.LANGUID)
        String A = nodes.get(0);
 * Licensed to Elasticsearch under one or more contributor
            for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2)
        health = client().admin()
                    for (ShardRouting shardRouting : indexShardRoutingTable) {
        Settings commonSettings = Settings.builder()
        logger.info("--> starting another node in zone 'b'");
import org.apache.logging.log4j.Logger;
        createIndex(
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2).build()
    }
        assertThat(counts.get(A_0), equalTo(5));
            .actionGet();
            }
                for (ShardRouting shardRouting : indexShardRoutingTable) {
            .setWaitForEvents(Priority.LANGUID)
            nodeCountPerAZ,
            .execute()
            .cluster()
        Map<String, Integer> counts = new HashMap<>();
        logger.info("--> waiting for nodes to form a cluster");
        List<String> nodesInA = internalCluster().startNodes(
                }
                .put(IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS, "0-all")
            .prepareHealth()
            .setWaitForEvents(Priority.LANGUID)
        String A_1 = nodes.get(3);
    }
        logger.info("--> waiting for nodes to form a cluster");
            }
        );
import org.opensearch.cluster.ClusterState;
                for (ShardRouting shardRouting : indexShardRoutingTable) {
            .setWaitForEvents(Priority.LANGUID)
        // its nodes is excluded, so both names must be listed. This exercises the _name branch of the cluster exclude
            .actionGet();
            .cluster()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build(),
        assertThat(health.isTimedOut(), equalTo(false));
        );
        );
            .put(AwarenessReplicaBalance.CLUSTER_ROUTING_ALLOCATION_AWARENESS_BALANCE_SETTING.getKey(), false)
                .setTransientSettings(Settings.builder().put("cluster.routing.allocation.exclude._name", excludedInA).build())
            .prepareHealth()
            .execute()
            .get();
            .actionGet();
        assertThat(health.isTimedOut(), equalTo(false));
import org.opensearch.cluster.metadata.IndexMetadata.State;
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
                .setTransientSettings(
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
            final Map<String, Integer> counts = new HashMap<>();
        client().admin()
            "test-1",
import org.opensearch.cluster.routing.IndexRoutingTable;
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2).build()
            .cluster()
            .setWaitForActiveShards(10)
            .setWaitForEvents(Priority.LANGUID)
                    counts.merge(clusterState.nodes().get(shardRouting.currentNodeId()).getName(), 1, Integer::sum);
        createIndex("test1");
        Settings commonSettings = Settings.builder()
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b")
        );
    public void testAwarenessZonesIncrementalNodes() {
            .setIndices("test")
        assertThat(counts.get(A_0), equalTo(3));
        String B = nodes.get(1);
    public void testAwarenessZones() {
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build()
        int shardsInCBefore = shardsOn(clusterState, nodesInC.get(0)) + shardsOn(clusterState, nodesInC.get(1));
                .collect(Collectors.toList());
                    counts.merge(clusterState.nodes().get(shardRouting.currentNodeId()).getName(), 1, Integer::sum);
            .setIndices("test-1")
            assertAcked(client().admin().indices().prepareClose("test"));
        ClusterHealthResponse health = client().admin()
            assertAcked(client().admin().indices().prepareClose("test"));
        assertThat(counts.get(B), anyOf(equalTo(1), equalTo(2)));
import java.util.Map;
 * Modifications Copyright OpenSearch Contributors. See
                Settings.builder()
        // the cap would be ceil(4/1)=4 and all four copies would fit, so this asserts a value is dropped only when
        internalCluster().startNodes(
            }
            nodeDataPathSettings.add(internalCluster().dataPathSettings(nodes_in_zone_a.get(i)));
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 5).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1).build()
    public void testSimpleAwareness() throws Exception {
            .put("cluster.routing.allocation.load_awareness.skew_factor", "0.0")
            .prepareHealth()
        assertThat(health.isTimedOut(), equalTo(false));
                .build()
            .put("cluster.routing.allocation.awareness.attributes", "zone")
        int shardsInA = shardsOn(clusterState, nodesInA.get(0)) + shardsOn(clusterState, nodesInA.get(1));
        health = client().admin()
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build()
        assertAcked(
            .setIndices("test")
                    Settings.builder().put("cluster.routing.allocation.exclude._name", nodesInC.get(0) + "," + nodesInC.get(1)).build()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        int nodeCountPerAZ = 5;
            }
            .prepareHealth()
        );
        logger.info("--> starting 2 nodes on zones 'a' & 'b'");
        int numOfReplica = 1;
            nodesInB.get(2)
        logger.info("--> excluding both nodes in zone 'c' by name");
            .setWaitForEvents(Priority.LANGUID)
        ClusterState clusterState = client().admin().cluster().prepareState().execute().actionGet().getState();
                    counts.merge(clusterState.nodes().get(shardRouting.currentNodeId()).getName(), 1, Integer::sum);
    }
        }
            "test-2",
            nodeCountPerAZ,
        assertThat(counts.get(A_0), anyOf(equalTo(2), equalTo(3)));
            .setWaitForEvents(Priority.LANGUID)
        // Create index with 2 replicas ie total 3 shards
    public void testShardsDrainOffFullyExcludedZone() {
@ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0, minNumDataNodes = 2)
 * under the License.
            .cluster()
            nodeCountPerAZ,
            .actionGet();
            .execute()
    }
            .setWaitForGreenStatus()
    }
            .setWaitForActiveShards(10)
        logger.info("--> starting 15 nodes on zones 'a' & 'b' & 'c'");
            for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
            .actionGet();
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
        return 1;
        assertThat(counts.get(B_0), equalTo(5));
import org.opensearch.cluster.routing.allocation.decider.AwarenessAllocationDecider;
        });
            .setIndices("test")
        List<String> nodes_in_zone_b = internalCluster().startDataOnlyNodes(
        health = client().admin()
        assertThat(health.isTimedOut(), equalTo(false));
 * specific language governing permissions and limitations
        String noZoneNode = internalCluster().startNode();
        List<String> nodesInB = internalCluster().startNodes(
        String A_0 = nodes.get(0);
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
        createIndex(
                    .build()
            .execute()
        assertThat(health.isTimedOut(), equalTo(false));
            .setWaitForNoRelocatingShards(true)
        }
        clusterState = client().admin().cluster().prepareState().execute().actionGet().getState();
        // no replicas will be allocated as both indices end up on a single node
        String usableInA = nodesInA.get(1);
            .prepareHealth()
        // All shards should be started
            }
        client().admin().cluster().prepareReroute().setRetryFailed(true).get();
        updateSettingsRequest.persistentSettings(settings);
        assertThat("one copy should start in zone 'c'", shardsInCBefore, equalTo(1));
        assertFalse(health.isTimedOut());
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(numOfShards * (numOfReplica + 1)));
        List<String> nodes = internalCluster().startNodes(
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(1));
        }
        assertThat(counts.get(B_1), equalTo(2));
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
        assertThat(counts.get(B_1), anyOf(equalTo(2), equalTo(3)));
        }
                    .put("node.name", nodes_in_zone_a.get(i))
        );
import static org.hamcrest.Matchers.equalTo;
        assertThat("the excluded node in zone 'a' must hold no shards", shardsOn(clusterState, excludedInA), equalTo(0));
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone")
        Settings commonSettings = Settings.builder()
        String B_0 = nodes.get(1);
        health = client().admin()
            .setIndices("test-1", "test-2")
                .get()
        for (int i = 0; i < nodesToStop; i++) {
            .setWaitForGreenStatus()
            .cluster()
        assertThat("no shards may remain on the excluded zone 'c' nodes", shardsInC, equalTo(0));
        health = client().admin()
        ClusterHealthResponse health = client().admin()
        assertThat(health.isTimedOut(), equalTo(false));
    @Override
        ensureGreen();
            logger.info("--> waiting for no relocation");
        assertThat(counts.get(B_0), anyOf(equalTo(2), equalTo(3)));
            .setWaitForEvents(Priority.LANGUID)
        assertThat(counts.get(A_0), equalTo(5));
            .setIndices("test-1")
        assertThat(health.isTimedOut(), equalTo(false));
            .setIndices("test")
        Settings commonSettings = Settings.builder()
            .actionGet();
                    }
        logger.info("--> starting 6 nodes, 2 per zone across zones 'a', 'b' and 'c'");
        Settings commonSettings = Settings.builder()
        assertThat("all three copies should consolidate onto zones 'a' and 'b'", shardsInA + shardsInB, equalTo(3));
            .setWaitForGreenStatus()
            .actionGet();
            Settings.builder().put(commonSettings).put("node.attr.zone", "c").build(),
            .setIndices("test")
import java.util.stream.Collectors;
            .setIndices("test")
        health = client().admin()
        String excludedInA = nodesInA.get(0);
            Settings.builder()
            .cluster()
import static org.hamcrest.Matchers.anyOf;
        assertBusy(() -> {
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(2 * numOfShards * (numOfReplica + 1)));
 * the Apache License, Version 2.0 (the "License"); you may
                .cluster()
    public void testThreeZoneOneReplicaWithForceZoneValueAndLoadAwareness() throws Exception {
        List<String> nodes_in_zone_a = internalCluster().startDataOnlyNodes(
        // On slow machines the initial relocation might be delayed
            .prepareHealth()
    }
            .actionGet();
        final String node3 = internalCluster().startNode(Settings.builder().put(commonSettings).put("node.attr.rack_id", "rack_2").build());
package org.opensearch.cluster.allocation;
                }
            .setWaitForNodes(Integer.toString(nodeCountPerAZ * 3 + 1))
        List<Settings> nodeDataPathSettings = new ArrayList<>();
        }
                .setWaitForNodes("3")
            assertAcked(client().admin().indices().prepareUpdateSettings("test-idx").setSettings(newsettings));
            .setWaitForNodes("3")
            .setWaitForNodes("2")
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build()
import org.opensearch.test.OpenSearchIntegTestCase;
    protected int numberOfReplicas() {
            .actionGet();
 * Unless required by applicable law or agreed to in writing,
            logger.info("--> checking current state");
        // from ceil(3/3)=1 to ceil(3/2)=2. The copy stranded in the excluded zone 'c' can therefore drain onto the
        final int totalPrimaries = test1.numPrimaries + test2.numPrimaries;
                for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
        logger.info("--> starting 2 nodes on same zone");
        internalCluster().startNodes(2, Settings.builder().put(commonSettings).put("node.attr.rack_id", "rack_1").build());
                }
            }
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build(),
import org.opensearch.cluster.routing.ShardRouting;
            .actionGet();
        logger.info("--> starting 3 nodes on zones a,b,c");
 */
            ClusterState clusterState = client().admin().cluster().prepareState().execute().actionGet().getState();
                    counts.merge(clusterState.nodes().get(shardRouting.currentNodeId()).getName(), 1, Integer::sum);
/*
                    if (shardRouting.currentNodeId() != null
            .setWaitForNoRelocatingShards(true)
            .put("cluster.routing.allocation.awareness.attributes", "zone")
        List<String> nodes = internalCluster().startNodes(
            .actionGet();
            .prepareHealth()
        // filter with a fully-drained zone.
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
            Settings.builder()
        ClusterHealthResponse health = client().admin().cluster().prepareHealth().setWaitForNodes("5").execute().actionGet();
            .setWaitForGreenStatus()
            .setWaitForNodes(Integer.toString(nodeCountPerAZ * 3 - nodesToStop + 1))
        assertThat(replicaCount, equalTo(2));
import java.util.List;
import org.opensearch.cluster.metadata.IndexMetadata;
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numOfReplica)
            .put("cluster.routing.allocation.awareness.attributes", "zone")
        }
        );
import org.apache.logging.log4j.LogManager;
            .setWaitForNoInitializingShards(true)
            .cluster()
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodes_in_zone_a.get(i)));
            .execute()
                .cluster()
        assertThat(health.isTimedOut(), equalTo(false));
            .setWaitForNoRelocatingShards(true)
                .setWaitForNoRelocatingShards(true)
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build()
            .cluster()
        assertThat(counts.get(noZoneNode), equalTo(2));
            .setWaitForNoInitializingShards(true)
        );
        health = client().admin()
        );
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build(),
 * compatible open source license.
            .setWaitForEvents(Priority.LANGUID)
 */
        int shardsInB = shardsOn(clusterState, nodesInB.get(0)) + shardsOn(clusterState, nodesInB.get(1));
            .prepareHealth()
 * this file be licensed under the Apache-2.0 license or a
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build()
            }
            .actionGet();
        assertThat(counts.get(B_1), equalTo(2));
import org.opensearch.test.InternalTestCluster;
 *    http://www.apache.org/licenses/LICENSE-2.0
        ClusterHealthResponse health = client().admin().cluster().prepareHealth().setWaitForNodes("4").execute().actionGet();
        }, 10, TimeUnit.SECONDS);
                .filter(index -> clusterState.metadata().index(index).getState() != State.CLOSE)
    public void testZoneStillCountedWhenOnlySomeOfItsNodesExcluded() {
        // Exclude zone 'c' by excluding both of its nodes by name. Zone 'c' only counts as excluded once every one of
                for (ShardRouting shardRouting : indexShardRoutingTable) {
            .setWaitForActiveShards(2 * numOfShards * (numOfReplica + 1))
                    .put(nodeDataPathSettings.get(i))
                        replicaCount++;
 *
import org.opensearch.common.Priority;
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build(),
        health = client().admin()
        int shardsInB = shardsOn(clusterState, nodesInB.get(0)) + shardsOn(clusterState, nodesInB.get(1)) + shardsOn(
            .setWaitForNoRelocatingShards(true)
        // every one of its nodes is excluded.
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build(),
            for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
        int nodesToStop = nodeCountPerAZ / 2;
        assertFalse(health.isTimedOut());
        logger.info("--> starting 4 nodes on different zones");
                }
            .execute()
            .setIndices("test")
        assertThat(health.isTimedOut(), equalTo(false));
        assertThat(counts.get(B_0), equalTo(3));
        );
import org.opensearch.common.settings.Settings;
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
        int count = 0;
        Settings commonSettings = Settings.builder().put("cluster.routing.allocation.awareness.attributes", "rack_id").build();
        health = client().admin()
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
        final List<String> indicesToClose = randomSubsetOf(Arrays.asList("test1", "test2"));
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 5).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1).build()
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone")
                .prepareUpdateSettings()
        createIndex("test2");
            client().admin()
            .prepareHealth()
            .setWaitForNodes("4")
            .execute()
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(3));
            .prepareHealth()
            .execute()
            }
            .setWaitForNoRelocatingShards(true)
            client().admin()
            "test",
            .setTransientSettings(Settings.builder().put("cluster.routing.allocation.awareness.attributes", "").build())
        String B_1 = internalCluster().startNode(Settings.builder().put(commonSettings).put("node.attr.zone", "b").build());
    private final Logger logger = LogManager.getLogger(AwarenessAllocationIT.class);
        );
        }
        assertAcked(
                    }
            .setWaitForEvents(Priority.LANGUID)
        createIndex(
        assertThat(health.isTimedOut(), equalTo(false));
        // Restarting the nodes back
        final Map<String, Integer> counts = new HashMap<>();
            .execute()
                .cluster()
        final Map<String, Integer> counts = new HashMap<>();
            for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
        health = client().admin()
            .setWaitForNoRelocatingShards(true)
                }
    public void testAwarenessBalanceWithForcedAwarenessCreateAndUpdateIndex() {
        assertThat(health.isTimedOut(), equalTo(false));
                }
            .cluster()
        // usableInA is not), awareness still counts both zones {a, b}, so the per-zone cap is ceil(4/2)=2. Zone 'a'
 * ownership. Elasticsearch licenses this file to you under
            for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
}
        assertThat(counts.size(), equalTo(nodeCountPerAZ * 3));
        List<String> nodesInA = internalCluster().startNodes(
                        counts.merge(clusterState.nodes().get(shardRouting.currentNodeId()).getName(), 1, Integer::sum);
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
 * KIND, either express or implied.  See the License for the
            .execute()
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
        logger.info("--> starting 2 nodes on the same rack");
        ClusterState clusterState = client().admin().cluster().prepareState().execute().actionGet().getState();
            .build();
        );
            .prepareHealth()
            Settings.builder().put(settings).put("node.attr.zone", "a").build(),
            .setWaitForNoInitializingShards(true)
        }
            Settings.builder().put(commonSettings).put("node.attr.zone", "c").build()
            .execute()
        clusterState = client().admin().cluster().prepareState().execute().actionGet().getState();
            .cluster()
            .setTimeout(TimeValue.timeValueMinutes(2))
        health = client().admin()
        return count;
        );
        assertThat(health.isTimedOut(), equalTo(false));
            .cluster()
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build(),
        // stopping half nodes in zone a
        String B_0 = nodes.get(1);
        }
        logger.info("--> starting 2 nodes in zone 'a' and 3 nodes in zone 'b'");
import java.util.concurrent.TimeUnit;
        List<String> nodes = internalCluster().startNodes(
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "zone.values", "a")
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build()
                    counts.merge(clusterState.nodes().get(shardRouting.currentNodeId()).getName(), 1, Integer::sum);
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        );
        // remaining zones and the cluster returns to green with nothing left unassigned.
                for (ShardRouting shardRouting : indexShardRoutingTable) {
            .actionGet();
                    counts.merge(clusterState.nodes().get(shardRouting.currentNodeId()).getName(), 1, Integer::sum);
            .build();
            "test",
        assertThat(health.isTimedOut(), equalTo(false));
            for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
/*
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "zone.values", "a,b")
            .cluster()
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build(),
            .setWaitForNoRelocatingShards(true)
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build(),
            .cluster()
                .prepareHealth()
        int shardsInC = shardsOn(clusterState, nodesInC.get(0)) + shardsOn(clusterState, nodesInC.get(1));
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
                for (ShardRouting shardRouting : indexShardRoutingTable) {
        // All shards should be started now and cluster health should be green
            .setIndices("test")
        String B_1 = nodes.get(2);
        }
        logger.info("--> waiting for shards to be allocated");
            // check that closed indices are effectively closed
        }
        ClusterHealthResponse health = client().admin().cluster().prepareHealth().setWaitForNodes("2").execute().actionGet();
            Settings.builder().put(settings).put("node.attr.zone", "c").build()
            .prepareHealth()
        final Settings newsettings = Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 4).build();
        assertThat("zone 'b' is capped at two copies", shardsInB, equalTo(2));
            .setIndices("test")
            for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
            .actionGet();
            .setWaitForEvents(Priority.LANGUID)
import java.util.Arrays;
            .setWaitForNodes(Integer.toString(nodeCountPerAZ * 3 + 1))
        clusterState = client().admin().cluster().prepareState().execute().actionGet().getState();
            .cluster()
            .prepareHealth()
            internalCluster().startNode(
        }
            Settings.builder().put(commonSettings).put("node.attr.zone", "c").build()
        NumShards test1 = getNumShards("test1");
    }
            .build();
        client().admin().cluster().prepareReroute().get();
            .setWaitForEvents(Priority.LANGUID)
        assertThat(counts.get(A_1), anyOf(equalTo(2), equalTo(3)));
        client().admin().cluster().prepareReroute().get();
                }
 * GitHub history for details.
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone")
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numOfReplica)
            Settings.builder()
    }
            .setWaitForGreenStatus()
    }
            .setIndices("test-1", "test-2")
            .build();
            .setWaitForGreenStatus()
        logger.info("--> starting a dedicated cluster manager node");
        ClusterState clusterState = client().admin().cluster().prepareState().execute().actionGet().getState();
                for (ShardRouting shardRouting : indexShardRoutingTable) {
            .setWaitForActiveShards(10)
            .setWaitForGreenStatus()
                .setIndices("test1", "test2")
        logger.info("--> excluding a single node in zone 'a' by name; zone 'a' still has a usable node");
        assertThat(counts.get(A_0), equalTo(5));
        NumShards test2 = getNumShards("test2");
                    counts.merge(clusterState.nodes().get(shardRouting.currentNodeId()).getName(), 1, Integer::sum);
        createIndex(
        // 1 primary + 3 replicas = 4 copies. Because zone 'a' keeps a usable node (excludedInA is excluded but
        );
        assertThat(counts.get(A), anyOf(equalTo(1), equalTo(2)));
                .build()
            .put("cluster.routing.allocation.awareness.balance", "true")
            .setWaitForGreenStatus()
        // Creating another index with 30 primary and 1 replica
            assertThat("Some indices not closed", notClosedIndices, empty());
            "test-idx",
            .build();
                .prepareUpdateSettings()
        health = client().admin()
        );
            .put(AwarenessReplicaBalance.CLUSTER_ROUTING_ALLOCATION_AWARENESS_BALANCE_SETTING.getKey(), true)
        assertThat("zone 'a' still counts, so its usable node holds one copy", shardsOn(clusterState, usableInA), equalTo(1));
            "test",
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(4));
        ClusterState clusterState = client().admin().cluster().prepareState().execute().actionGet().getState();
        );
        assertThat(counts.get(B_0), equalTo(3));
            .build();
        ClusterHealthResponse health = client().admin().cluster().prepareHealth().setWaitForNodes("6").execute().actionGet();
        assertThrows(IllegalArgumentException.class, () -> {
        logger.info("--> starting 1 node on a different rack");
        // can hold only one copy (its single usable node) and zone 'b' is capped at 2, so the fourth copy cannot be
                        count++;
                }
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
            // verify that we have all the primaries on node3
import org.opensearch.common.unit.TimeValue;
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build(),
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 3).build()
 * not use this file except in compliance with the License.
        Settings commonSettings = Settings.builder()
        assertThat(counts.containsKey(noZoneNode), equalTo(false));
            .actionGet();
import static org.hamcrest.Matchers.empty;
            .setWaitForNoRelocatingShards(true)
                .build()
        indicesToClose.forEach(indexToClose -> assertAcked(client().admin().indices().prepareClose(indexToClose).get()));
        createIndex(
                .get()
import org.opensearch.cluster.routing.allocation.AwarenessReplicaBalance;
                .get();
 *
 * SPDX-License-Identifier: Apache-2.0
 */
            for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
            .execute()
            .setWaitForNoRelocatingShards(true)
        List<String> nodes_in_zone_c = internalCluster().startDataOnlyNodes(
import java.util.HashMap;
            .prepareHealth()
 * this work for additional information regarding copyright
        int numOfShards = 30;
        // Creating index with 30 primary and 1 replica
            .setWaitForNoInitializingShards(true)
            .prepareHealth()
            for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
            .setWaitForNodes("4")
 * The OpenSearch Contributors require contributions made to
        // 1 primary + 2 replicas = 3 copies; with all three zones counted they spread one per zone
        clusterState = client().admin().cluster().prepareState().execute().actionGet().getState();
        health = client().admin()
        );
            .setWaitForNoRelocatingShards(true)
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone")
        Settings settings = Settings.builder()
        List<String> nodesInC = internalCluster().startNodes(
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;
            }
            .setWaitForYellowStatus()
        ClusterState clusterState = client().admin().cluster().prepareState().execute().actionGet().getState();
            assertThat("Cluster health request timed out", clusterHealth.isTimedOut(), equalTo(false));
    public void testAwarenessZonesWithAutoExpand() {
        List<String> nodesInB = internalCluster().startNodes(
        createIndex(
                )
        assertThat(counts.get(B_0), equalTo(3));
            .setIndices("test")
        );
 * You may obtain a copy of the License at
        String A_0 = nodes.get(0);
/*
        );
        assertThat(health.isTimedOut(), equalTo(false));
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build()
            ClusterHealthResponse clusterHealth = client().admin()
            .setWaitForNoRelocatingShards(true)
        );
            "test",
                for (ShardRouting shardRouting : indexShardRoutingTable) {
        if (randomBoolean()) {
            assertThat(counts.get(node3), equalTo(totalPrimaries));
            .setWaitForNoRelocatingShards(true)
        // Zone 'c' is fully excluded, so awareness now balances across zones {a, b} only, raising the per-zone cap
