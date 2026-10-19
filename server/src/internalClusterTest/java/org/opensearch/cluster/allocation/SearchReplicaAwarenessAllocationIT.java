public class SearchReplicaAwarenessAllocationIT extends RemoteStoreBaseIntegTestCase {
                    .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "")
    public void testAllocationAwarenessZones() {
        /*
        assertThat(counts.get(nodes.get(2)), equalTo(3));
        /*  
                client().admin()  
            .build();
    }
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").put(searchOnlyNode()).build(),  
            for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").put(searchOnlyNode()).build(),
        logger.info("--> Remove the awareness attribute setting");
 *
        assertThat(counts.get(nodes.get(2)), equalTo(2));
        createIndex(
        });  
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;  
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build(),
            assertThat(counts.get(nodes.get(i)), equalTo(3));
                    counts.merge(clusterState.nodes().get(shardRouting.currentNodeId()).getName(), 1, Integer::sum);  
         * As a result, shards are rerouted to maintain a best-effort balanced allocation.
                }
        counts = new HashMap<>();
                }
        ensureGreen("test");
        assertThat(counts.get(nodes.get(0)), equalTo(3));
        Settings settings = Settings.builder()
    }
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").put(searchOnlyNode()).build(),
        String B_2 = internalCluster().startNode(Settings.builder().put(commonSettings).put("node.attr.zone", "b").build());
        assertThat(counts.get(nodes.get(3)), equalTo(2));
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "zone.values", "a,b,c")
            Settings.builder().put(settings).put("node.attr.zone", "c").build()
        assertThrows(IllegalArgumentException.class, () -> {
            .cluster()
                }
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {  
            "test",  
        Settings commonSettings = Settings.builder()  
        }
        assertThat(counts.get(nodes.get(2)), equalTo(3));  
            }
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").put(searchOnlyNode()).build()  
                .put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, 2)
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {  
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").put(searchOnlyNode()).build()
        );  
        ensureGreen("test");
        logger.info("--> create index");
            .build();
            .prepareUpdateSettings()
            Settings.builder().put(settings).put("node.attr.zone", "c").build()
        ensureGreen("test");
        client().admin().cluster().prepareReroute().get();
                    .indices()
        ClusterState clusterState = client().admin().cluster().prepareState().execute().actionGet().getState();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REPLICATION_TYPE;  
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone")  
            );
            Settings.builder().put(settings).put("node.attr.zone", "b").build(),
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
        ClusterHealthResponse health = client().admin().cluster().prepareHealth().setWaitForNodes("6").execute().actionGet();
        assertThat(counts.get(nodes.get(3)), equalTo(2));  
                for (ShardRouting shardRouting : indexShardRoutingTable) {
        );  
        Settings settings = Settings.builder()
         */  
        logger.info("--> starting another data node without any zone");
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
        }  
        assertThat(health.isTimedOut(), equalTo(false));
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
 * SPDX-License-Identifier: Apache-2.0
        logger.info("--> waiting for shards to be allocated");  
                    .build()  
                for (ShardRouting shardRouting : indexShardRoutingTable) {
        clusterState = client().admin().cluster().prepareState().execute().actionGet().getState();
                Settings.builder()
        internalCluster().startNodes(
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
        Settings commonSettings = Settings.builder()
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build(),  
        List<String> nodes = internalCluster().startNodes(  
        counts = new HashMap<>();
        for (int i = 0; i < 4; i++) {
                for (ShardRouting shardRouting : indexShardRoutingTable) {  
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone")
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 3)
            }
    }
import java.util.List;  
import static org.hamcrest.Matchers.equalTo;
 * compatible open source license.
        String B_3 = internalCluster().startNode(
                    counts.merge(clusterState.nodes().get(shardRouting.currentNodeId()).getName(), 1, Integer::sum);  
            Settings.builder()
                .build()  
            Settings.builder()
            .build();  
         * resulting in each data node being assigned three shards.
                    counts.merge(clusterState.nodes().get(shardRouting.currentNodeId()).getName(), 1, Integer::sum);
        assertThat(counts.get(B_2), equalTo(1));
package org.opensearch.cluster.allocation;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            Settings.builder().put(settings).put("node.attr.zone", "b").build(),
        }  
        ensureGreen("test");
        logger.info("--> starting 2 nodes on zones 'a' & 'b'");  
         * Replicas and search replicas are evenly distributed across these zones.
                .build()  
         * Ensures that shards are distributed across different zones in the cluster.  
         * With six search shards to allocate, they are assigned using a best-effort spread,
            }  
    public void testAwarenessZonesIncrementalNodes() {  
                    .put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, 2)  
                .build()
import org.opensearch.cluster.routing.allocation.decider.AwarenessAllocationDecider;
                    counts.merge(clusterState.nodes().get(shardRouting.currentNodeId()).getName(), 1, Integer::sum);
         */
        client().admin().cluster().prepareReroute().get();  
        clusterState = client().admin().cluster().prepareState().execute().actionGet().getState();  
            )
import org.apache.logging.log4j.LogManager;
        /*  
        }  
 * The OpenSearch Contributors require contributions made to  
        for (int i = 0; i < 2; i++) {
                .put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, 3)
        // Update the number of search replicas to 4  
        assertThat(counts.get(nodes.get(1)), equalTo(2));
        assertThat(counts.get(nodes.get(3)), equalTo(2));
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {  
            Settings.builder()
            createIndex(
            "test",  
            Settings.builder().put(settings).put("node.attr.zone", "a").build(),  
    }  
    private final Logger logger = LogManager.getLogger(SearchReplicaAwarenessAllocationIT.class);  
                    .build()
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        ClusterState clusterState = client().admin().cluster().prepareState().execute().actionGet().getState();  
        assertThat(counts.get(nodes.get(0)), equalTo(3));
                    .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, 4).build())  
        );
        ensureGreen("test");  
import org.apache.logging.log4j.Logger;
            for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
            .setTransientSettings(  
        Map<String, Integer> counts = new HashMap<>();
         * ensuring each search node receives either one or two shards.
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build(),
import org.opensearch.cluster.metadata.IndexMetadata;
            .get();
        assertThrows(IllegalArgumentException.class, () -> {  
         * - Zone B: 2 data nodes, 2 search nodes  
         * Removing allocation awareness attributes from the cluster disables zone-based distribution.  
         * Adding another node to the cluster without a zone attribute
 */  
        logger.info("--> starting another data and search node in zone 'b'");
        createIndex(  
        assertThat(counts.get(B_2), equalTo(1));
        );  
        logger.info("--> waiting for nodes to form a cluster");  
                    counts.merge(clusterState.nodes().get(shardRouting.currentNodeId()).getName(), 1, Integer::sum);  
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;  
        // Create index with 2 replicas and 2 search replicas
        assertThat(counts.get(nodes.get(0)), equalTo(2));  
        assertThat(counts.get(B_3), equalTo(2));
        /*
        );  
        assertThat(counts.get(B_3), equalTo(1));
        assertThat(counts.get(B_3), equalTo(1));  
         */  
         * - Zone A: 1 data node, 1 search node
        String noZoneNode = internalCluster().startNode();
            .put(AwarenessReplicaBalance.CLUSTER_ROUTING_ALLOCATION_AWARENESS_BALANCE_SETTING.getKey(), "true")
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "zone.values", "a,b")
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)
        createIndex(
                Settings.builder()  
         * Shards are then assigned based solely the other deciders in the cluster manager.
        assertThat(counts.containsKey(noZoneNode), equalTo(false));
                }
        logger.info("--> starting 3 nodes on zones a,b,c");
        counts = new HashMap<>();
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 3)
        });
         * Adding a new data node and a new search node in zone B results in:
        final Map<String, Integer> counts = new HashMap<>();
        // Create index with 2 replicas and 3 search replicas
import org.opensearch.test.OpenSearchIntegTestCase;
            assertThat(counts.get(nodes.get(i)), anyOf(equalTo(1), equalTo(2)));
         */  
                .put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
         */  
    public void testAwarenessBalanceWithForcedAwarenessCreateIndex() {  
        }  
        assertThat(counts.get(B_2), equalTo(1));  
import org.opensearch.common.settings.Settings;
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
import static org.hamcrest.Matchers.anyOf;  
            "test-idx",
                for (ShardRouting shardRouting : indexShardRoutingTable) {
        internalCluster().startNodes(
    public void testAwarenessBalanceWithForcedAwarenessUpdateIndex() {  
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").put(searchOnlyNode()).build(),
                }
        ensureGreen("test");
         * Given two zones (a and b) with one data node in each, the shards are evenly distributed,
        );
            .put(AwarenessReplicaBalance.CLUSTER_ROUTING_ALLOCATION_AWARENESS_BALANCE_SETTING.getKey(), "true")
        logger.info("--> starting 3 nodes on zones a,b,c");
         * does not trigger shard reallocation; existing shard assignments remain unchanged.  
            Settings.builder().put(settings).put("node.attr.zone", "a").build(),  
        assertThat(counts.get(noZoneNode), equalTo(1));  
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
 * this file be licensed under the Apache-2.0 license or a
                .put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, 2)
            assertAcked(
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "zone.values", "a,b,c")
        client().admin()  
                for (ShardRouting shardRouting : indexShardRoutingTable) {  
            }
        }
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone")  
        ensureGreen("test");
                    .prepareUpdateSettings("test-idx")
import org.opensearch.cluster.routing.ShardRouting;
        for (int i = 2; i < 6; i++) {
        );
            for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)
        }  
        }  
         *
        logger.info("--> starting 8 nodes on different zones");
            assertThat(counts.get(nodes.get(i)), equalTo(3));
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build(),
            }  
/*  
        /*
            );
            for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
         */
import org.opensearch.cluster.routing.IndexShardRoutingTable;
}
         * The cluster consists of two zones, each containing one data node and one search node.
import org.opensearch.indices.replication.common.ReplicationType;  
            for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
import org.opensearch.cluster.routing.IndexRoutingTable;  
        /*
import java.util.HashMap;
import java.util.Map;
        assertThat(counts.get(nodes.get(1)), equalTo(2));
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone")  
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").put(searchOnlyNode()).build()  
        assertThat(counts.get(nodes.get(1)), equalTo(2));  
import static org.opensearch.test.NodeRoles.searchOnlyNode;
@ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
        clusterState = client().admin().cluster().prepareState().execute().actionGet().getState();
        logger.info("--> Ensure there was not rerouting");
import org.opensearch.cluster.routing.allocation.AwarenessReplicaBalance;  
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "zone.values", "a,b")
        List<String> nodes = internalCluster().startNodes(
         * There are two search nodes in each zone, totaling four search nodes.  
import org.opensearch.cluster.ClusterState;
                "test-idx",
            .build();
        );
