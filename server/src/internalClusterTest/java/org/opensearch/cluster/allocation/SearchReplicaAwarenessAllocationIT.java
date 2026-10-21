        clusterState = client().admin().cluster().prepareState().execute().actionGet().getState();
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "zone.values", "a,b,c")
public class SearchReplicaAwarenessAllocationIT extends RemoteStoreBaseIntegTestCase {
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "zone.values", "a,b,c")
        assertThrows(IllegalArgumentException.class, () -> {
        Settings settings = Settings.builder()
        assertThat(counts.get(nodes.get(0)), equalTo(3));
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone")
                    counts.merge(clusterState.nodes().get(shardRouting.currentNodeId()).getName(), 1, Integer::sum);
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
        ensureGreen("test");
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
        logger.info("--> Ensure there was not rerouting");
        ClusterHealthResponse health = client().admin().cluster().prepareHealth().setWaitForNodes("6").execute().actionGet();
         * Replicas and search replicas are evenly distributed across these zones.
                }
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 3)
                    .put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, 2)
        String B_3 = internalCluster().startNode(
        }
         * Shards are then assigned based solely the other deciders in the cluster manager.
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "zone.values", "a,b")
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)
        /*
        logger.info("--> Remove the awareness attribute setting");
        assertThat(counts.get(B_2), equalTo(1));
        Map<String, Integer> counts = new HashMap<>();
            .put(AwarenessReplicaBalance.CLUSTER_ROUTING_ALLOCATION_AWARENESS_BALANCE_SETTING.getKey(), "true")
        Settings commonSettings = Settings.builder()
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
import static org.hamcrest.Matchers.anyOf;
        // Update the number of search replicas to 4
        ensureGreen("test");
        assertThat(counts.get(nodes.get(0)), equalTo(2));
 */
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone")
        }
         */
 * compatible open source license.
        Settings settings = Settings.builder()
        /*
import org.opensearch.cluster.routing.allocation.decider.AwarenessAllocationDecider;
         * - Zone A: 1 data node, 1 search node
            Settings.builder()
        List<String> nodes = internalCluster().startNodes(
import org.opensearch.cluster.routing.IndexRoutingTable;
        }
                    .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "")
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").put(searchOnlyNode()).build(),
        assertThrows(IllegalArgumentException.class, () -> {
        internalCluster().startNodes(
        logger.info("--> starting 3 nodes on zones a,b,c");
        });
            Settings.builder().put(settings).put("node.attr.zone", "b").build(),
                for (ShardRouting shardRouting : indexShardRoutingTable) {
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            assertAcked(
         */
            );
        Settings commonSettings = Settings.builder()
        ensureGreen("test");
/*
        assertThat(counts.get(nodes.get(0)), equalTo(3));
        );
        ClusterState clusterState = client().admin().cluster().prepareState().execute().actionGet().getState();
        assertThat(counts.get(nodes.get(1)), equalTo(2));
        createIndex(
         * Removing allocation awareness attributes from the cluster disables zone-based distribution.
            }
            Settings.builder()
         * As a result, shards are rerouted to maintain a best-effort balanced allocation.
                    .build()
            Settings.builder().put(settings).put("node.attr.zone", "c").build()
        ensureGreen("test");
    public void testAwarenessBalanceWithForcedAwarenessCreateIndex() {
        assertThat(counts.get(nodes.get(3)), equalTo(2));
        internalCluster().startNodes(
                    .indices()
         */
        logger.info("--> starting 2 nodes on zones 'a' & 'b'");
        clusterState = client().admin().cluster().prepareState().execute().actionGet().getState();
            .put(AwarenessReplicaBalance.CLUSTER_ROUTING_ALLOCATION_AWARENESS_BALANCE_SETTING.getKey(), "true")
                client().admin()
        assertThat(counts.get(nodes.get(2)), equalTo(3));
        });
        createIndex(
                .put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, 3)
        /*
        List<String> nodes = internalCluster().startNodes(
            )
        assertThat(counts.get(nodes.get(3)), equalTo(2));
         */
            }
        assertThat(health.isTimedOut(), equalTo(false));
                .put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, 2)
            for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
         * - Zone B: 2 data nodes, 2 search nodes
                    .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, 4).build())
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
        client().admin().cluster().prepareReroute().get();
                    counts.merge(clusterState.nodes().get(shardRouting.currentNodeId()).getName(), 1, Integer::sum);
import org.opensearch.common.settings.Settings;
         * Ensures that shards are distributed across different zones in the cluster.
        logger.info("--> waiting for shards to be allocated");
        ensureGreen("test");
            }
        assertThat(counts.get(B_3), equalTo(1));
        for (int i = 2; i < 6; i++) {
                .build()
        );
        counts = new HashMap<>();
                Settings.builder()
        }
        createIndex(
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build(),
         * Given two zones (a and b) with one data node in each, the shards are evenly distributed,
            Settings.builder().put(settings).put("node.attr.zone", "a").build(),
import org.opensearch.test.OpenSearchIntegTestCase;
                for (ShardRouting shardRouting : indexShardRoutingTable) {
                    .build()
        );
package org.opensearch.cluster.allocation;
        );
        );
        assertThat(counts.get(nodes.get(1)), equalTo(2));
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
        /*
         * The cluster consists of two zones, each containing one data node and one search node.
    }
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone")
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone")
                    counts.merge(clusterState.nodes().get(shardRouting.currentNodeId()).getName(), 1, Integer::sum);
}
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REPLICATION_TYPE;
import org.opensearch.cluster.routing.allocation.AwarenessReplicaBalance;
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
    }
import static org.hamcrest.Matchers.equalTo;
            .cluster()
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            Settings.builder().put(settings).put("node.attr.zone", "c").build()
            .build();
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build(),
            .build();
    public void testAllocationAwarenessZones() {
                }
                }
        assertThat(counts.get(nodes.get(2)), equalTo(3));
    }
        ensureGreen("test");
 *
    public void testAwarenessZonesIncrementalNodes() {
        assertThat(counts.get(nodes.get(2)), equalTo(2));
         * There are two search nodes in each zone, totaling four search nodes.
            .build();
        /*
        logger.info("--> starting 8 nodes on different zones");
        // Create index with 2 replicas and 2 search replicas
         * resulting in each data node being assigned three shards.
         */
        ClusterState clusterState = client().admin().cluster().prepareState().execute().actionGet().getState();
        String noZoneNode = internalCluster().startNode();
         * ensuring each search node receives either one or two shards.
                for (ShardRouting shardRouting : indexShardRoutingTable) {
        }
 * The OpenSearch Contributors require contributions made to
import org.opensearch.cluster.ClusterState;
            "test",
        assertThat(counts.get(B_3), equalTo(1));
            for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
import static org.opensearch.test.NodeRoles.searchOnlyNode;
            assertThat(counts.get(nodes.get(i)), equalTo(3));
            Settings.builder().put(settings).put("node.attr.zone", "b").build(),
            Settings.builder().put(settings).put("node.attr.zone", "a").build(),
        ensureGreen("test");
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                }
                for (ShardRouting shardRouting : indexShardRoutingTable) {
            createIndex(
                .build()
        logger.info("--> waiting for nodes to form a cluster");
            );
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 3)
    public void testAwarenessBalanceWithForcedAwarenessUpdateIndex() {
        final Map<String, Integer> counts = new HashMap<>();
            .get();
        assertThat(counts.get(B_3), equalTo(2));
                }
import org.opensearch.cluster.metadata.IndexMetadata;
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)
        assertThat(counts.containsKey(noZoneNode), equalTo(false));
import org.apache.logging.log4j.LogManager;
            .setTransientSettings(
            for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
        client().admin().cluster().prepareReroute().get();
        assertThat(counts.get(nodes.get(1)), equalTo(2));
        counts = new HashMap<>();
         * Adding another node to the cluster without a zone attribute
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").put(searchOnlyNode()).build()
        logger.info("--> create index");
        // Create index with 2 replicas and 3 search replicas
        /*
        String B_2 = internalCluster().startNode(Settings.builder().put(commonSettings).put("node.attr.zone", "b").build());
import org.opensearch.indices.replication.common.ReplicationType;
            for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
                    .prepareUpdateSettings("test-idx")
        );
        assertThat(counts.get(B_2), equalTo(1));
            assertThat(counts.get(nodes.get(i)), anyOf(equalTo(1), equalTo(2)));
                .put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").put(searchOnlyNode()).build()
            .prepareUpdateSettings()
         * With six search shards to allocate, they are assigned using a best-effort spread,
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build(),
@ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
    private final Logger logger = LogManager.getLogger(SearchReplicaAwarenessAllocationIT.class);
                    counts.merge(clusterState.nodes().get(shardRouting.currentNodeId()).getName(), 1, Integer::sum);
import java.util.HashMap;
                "test-idx",
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "zone.values", "a,b")
         */
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").put(searchOnlyNode()).build(),
            .build();
        logger.info("--> starting another data node without any zone");
        logger.info("--> starting 3 nodes on zones a,b,c");
        }
                    counts.merge(clusterState.nodes().get(shardRouting.currentNodeId()).getName(), 1, Integer::sum);
        for (int i = 0; i < 4; i++) {
import java.util.Map;
    }
         *
        counts = new HashMap<>();
import org.apache.logging.log4j.Logger;
                for (ShardRouting shardRouting : indexShardRoutingTable) {
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").put(searchOnlyNode()).build(),
        client().admin()
         * does not trigger shard reallocation; existing shard assignments remain unchanged.
            assertThat(counts.get(nodes.get(i)), equalTo(3));
            "test",
            }
        clusterState = client().admin().cluster().prepareState().execute().actionGet().getState();
        logger.info("--> starting another data and search node in zone 'b'");
        assertThat(counts.get(nodes.get(3)), equalTo(2));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        );
 * this file be licensed under the Apache-2.0 license or a
                .build()
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").put(searchOnlyNode()).build()
        assertThat(counts.get(noZoneNode), equalTo(1));
 * SPDX-License-Identifier: Apache-2.0
                .put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, 2)
        for (int i = 0; i < 2; i++) {
        assertThat(counts.get(B_2), equalTo(1));
            "test-idx",
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").put(searchOnlyNode()).build(),
        );
        }
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
        }
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build(),
import org.opensearch.cluster.routing.IndexShardRoutingTable;
                Settings.builder()
            Settings.builder()
            for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
import java.util.List;
import org.opensearch.cluster.routing.ShardRouting;
         * Adding a new data node and a new search node in zone B results in:
            }
