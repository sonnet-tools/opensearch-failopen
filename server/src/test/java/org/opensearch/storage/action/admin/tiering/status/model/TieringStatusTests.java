            index.getName(),
    }
public class TieringStatusTests extends OpenSearchTestCase {
        String targetTier = isWarmTier ? "WARM" : "HOT";
        assertEquals(1, status.getOngoingShards().size());
        TieringStatus.OngoingShard shard = new TieringStatus.OngoingShard(1, "node2");
    }
        RoutingTable routingTable = new RoutingTable.Builder().add(builder.build()).build();
        assertEquals(Integer.valueOf(1), counters.get("running"));
        original.writeTo(streamOutput);
        // Test for detailed Flag as false
import static org.mockito.ArgumentMatchers.any;
        verify(streamOutput).writeString("warm");
        DiscoveryNode hotNode = new DiscoveryNode("hot-node", buildNewFakeTransportAddress(), emptyMap(), hotRoles, Version.CURRENT);
    }
        verify(streamOutput).writeString("RUNNING");
        List<TieringStatus.OngoingShard> ongoingShards = Collections.singletonList(new TieringStatus.OngoingShard(1, "node2"));
    public void testFromRoutingTable_WithMixedShardStates() {
        counters.put("running", 1);
        assertEquals(Integer.valueOf(4), counters.get("total"));
            "node-2",
        assertEquals(s1, s2);
        assertNotEquals(s1, "string");
        assertTrue(counters.containsKey("pending"));
        Map<String, Integer> counters = new HashMap<>();
        builder.addShard(primaryShard);
        }
 */
import org.opensearch.cluster.routing.ShardRouting;
        RoutingTable routingTable = new RoutingTable.Builder().add(builder.build()).build();
            "test-index",
        );
        IndexRoutingTable.Builder builder = IndexRoutingTable.builder(index);
        // Test for HOT tier
 *
 * compatible open source license.
import org.opensearch.cluster.routing.TestShardRouting;
        }
        TieringStatus.ShardLevelStatus status = TieringStatus.ShardLevelStatus.fromRoutingTable(clusterState, "test-index", false, "HOT");
import org.opensearch.cluster.node.DiscoveryNodes;
    }
        verify(streamOutput).writeInt(1);
            roles.add(DiscoveryNodeRole.WARM_ROLE);
        );
import org.opensearch.storage.action.tiering.status.model.TieringStatus;
import java.util.Map;
        assertEquals(counters, status.getShardLevelCounters());
            ShardRoutingState.RELOCATING
        when(clusterState.routingTable()).thenReturn(routingTable);
            assertFalse(node.isWarmNode());
            2,
            assertTrue(node.isWarmNode());
        builder.addShard(TestShardRouting.newShardRouting(index.getName(), 0, "warm-node", true, ShardRoutingState.STARTED));
        long startTime = System.currentTimeMillis();
        ClusterState clusterState = mock(ClusterState.class);
        IndexRoutingTable.Builder builder = IndexRoutingTable.builder(index);
            index.getName(),
        // Additional assertions specific to tier if needed
    public void testFromRoutingTable_HotTarget_StartedOnWarmIsPending() {
        TieringStatus s1 = new TieringStatus("idx", "RUNNING", "hot", "warm", 100L);
import java.io.IOException;
            "node-3",
import org.opensearch.cluster.routing.IndexRoutingTable;
        testForTier(true, true);
        when(nodes.get("warm-node")).thenReturn(warmNode);
        shard.writeTo(streamOutput);
        when(clusterState.routingTable()).thenReturn(routingTable);
        counters.put("pending", 2);
 * this file be licensed under the Apache-2.0 license or a
        Index index = new Index("test-index", "uuid");
    public void testFromRoutingTable() {
 * SPDX-License-Identifier: Apache-2.0
        TieringStatus s3 = new TieringStatus("other", "RUNNING", "hot", "warm", 100L);
        DiscoveryNode warmNode = new DiscoveryNode("warm-node", buildNewFakeTransportAddress(), emptyMap(), warmRoles, Version.CURRENT);
        Map<String, Integer> counters = status.getShardLevelCounters();
    private List<ShardRouting> createTestShards() {
import org.opensearch.core.index.Index;
            1,
        if (isWarmTier) {
        when(nodes.get("hot-node")).thenReturn(hotNode);
        } else {
}
        );
        StreamOutput streamOutput = mock(StreamOutput.class);
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
        when(nodes.get(any())).thenReturn(node);
    public void testTieringStatusSerialization() throws IOException {
        Set<DiscoveryNodeRole> roles = new HashSet<>();
            roles.add(DiscoveryNodeRole.DATA_ROLE);
        Map<String, Integer> counters = status.getShardLevelCounters();
        String indexName = "test-index";
        assertEquals(status, tieringStatus.getStatus());
            false,
        when(clusterState.getNodes()).thenReturn(nodes);
    }
            emptyMap(),
            true,
        warmRoles.add(DiscoveryNodeRole.WARM_ROLE);
    public void testTieringStatusConstructor() {
/*
        verify(streamOutput).writeLong(123456L);
        // Mock StreamOutput
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
        Set<DiscoveryNodeRole> hotRoles = new HashSet<>();
        String source = "hot";
            assertFalse(counters.containsKey("ongoing_shards"));
import org.opensearch.cluster.node.DiscoveryNode;
        testForTier(false, true);
        builder.addShard(replicaShard);
        TieringStatus.ShardLevelStatus status = new TieringStatus.ShardLevelStatus(counters, ongoingShards);
    }
        );
            "node-" + (isWarmTier ? "warm" : "hot"),
        builder.addShard(TestShardRouting.newShardRouting(index.getName(), 1, "hot-node", true, ShardRoutingState.STARTED));
import org.opensearch.Version;
import java.util.HashSet;
        assertTrue(counters.containsKey("total"));
        Set<DiscoveryNodeRole> warmRoles = new HashSet<>();
    private IndexRoutingTable createRoutingTable(Index index) {
        counters.put("total", 6);
        Set<DiscoveryNodeRole> warmRoles = new HashSet<>();
        testForTier(false, false);
        verify(streamOutput).writeString("node2");
            ShardRoutingState.RELOCATING
import org.opensearch.test.OpenSearchTestCase;
        when(clusterState.getNodes()).thenReturn(nodes);
        TieringStatus.ShardLevelStatus status = TieringStatus.ShardLevelStatus.fromRoutingTable(clusterState, "test-index", true, "WARM");
        assertEquals(source, tieringStatus.getSource());
    }
        hotRoles.add(DiscoveryNodeRole.DATA_ROLE);
            buildNewFakeTransportAddress(),
            roles,
            false,
import java.util.Collections;
        return Collections.emptyList();
    public void testEquals() {
        assertEquals(Integer.valueOf(1), counters.get("succeeded"));
package org.opensearch.storage.action.admin.tiering.status.model;
        }
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.cluster.node.DiscoveryNodeRole;
    public void testHashCode() {
        assertEquals(target, tieringStatus.getTarget());
    }
        verify(streamOutput).writeString("test-index");
        when(clusterState.routingTable()).thenReturn(routingTableBuilder.build());
        if (isDetailedFlagEnabled) {
        TieringStatus s2 = new TieringStatus("idx", "RUNNING", "hot", "warm", 100L);
            targetTier
        RoutingTable.Builder routingTableBuilder = new RoutingTable.Builder().add(createRoutingTable(new Index("test-index", "na")));
import java.util.HashMap;
        TieringStatus.ShardLevelStatus status = TieringStatus.ShardLevelStatus.fromRoutingTable(
        ShardRouting primaryShard = TestShardRouting.newShardRouting(
        assertEquals(s1.hashCode(), s2.hashCode());
        ShardRouting replicaShard = TestShardRouting.newShardRouting(
        assertEquals(Integer.valueOf(0), counters.get("succeeded"));
        // This would be implementation-specific based on your needs
import static org.mockito.Mockito.verify;
        StreamOutput streamOutput = mock(StreamOutput.class);
        assertTrue(counters.containsKey("running"));
    }
        DiscoveryNode warmNode = new DiscoveryNode("warm-node", buildNewFakeTransportAddress(), emptyMap(), warmRoles, Version.CURRENT);
        builder.addShard(TestShardRouting.newShardRouting(index.getName(), 2, null, true, ShardRoutingState.UNASSIGNED));
        TieringStatus tieringStatus = new TieringStatus(indexName, status, source, target, startTime);
            "node-2",
            clusterState,
        // Create and return test shard routings
        String status = "RUNNING";
import org.opensearch.cluster.ClusterState;
        when(nodes.get("warm-node")).thenReturn(warmNode);
        ClusterState clusterState = mock(ClusterState.class);
        assertEquals(indexName, tieringStatus.getIndexName());
        assertNotEquals(s1, s3);
        assertEquals(startTime, tieringStatus.getStartTime());
        verify(streamOutput).writeString("hot");
        if (isWarmTier) {
        ClusterState clusterState = mock(ClusterState.class);
import java.util.Set;
        TieringStatus s2 = new TieringStatus("idx", "RUNNING", "hot", "warm", 100L);
        String target = "warm";
            "node-3",
        DiscoveryNode node = new DiscoveryNode(
    private void testForTier(boolean isWarmTier, boolean isDetailedFlagEnabled) {
import static org.mockito.Mockito.when;
import org.opensearch.cluster.routing.RoutingTable;
        // Mock ClusterState and its components
        } else {
        builder.addShard(TestShardRouting.newShardRouting(index.getName(), 3, "hot-node", "warm-node", true, ShardRoutingState.RELOCATING));
    }
        // Test for WARM tier
import org.opensearch.cluster.routing.ShardRoutingState;
        assertEquals(s1, s1);
        IndexRoutingTable.Builder builder = IndexRoutingTable.builder(index);
            Version.CURRENT
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
    }
import static org.mockito.Mockito.mock;
        TieringStatus s1 = new TieringStatus("idx", "RUNNING", "hot", "warm", 100L);
        Map<String, Integer> counters = status.getShardLevelCounters();
    public void testShardLevelStatusCreation() {
        return builder.build();
        TieringStatus original = new TieringStatus("test-index", "RUNNING", "hot", "warm", 123456L);
        assertEquals(Integer.valueOf(2), counters.get("pending"));
        warmRoles.add(DiscoveryNodeRole.WARM_ROLE);
    }
        assertNotNull(status);
        Index index = new Index("test-index", "uuid");
        // Verify counters
        builder.addShard(TestShardRouting.newShardRouting(index.getName(), 0, "warm-node", true, ShardRoutingState.STARTED));
 * The OpenSearch Contributors require contributions made to
import java.util.List;
        // Create node with appropriate roles
        when(clusterState.getNodes()).thenReturn(nodes);
        assertTrue(counters.containsKey("succeeded"));
        counters.put("succeeded", 3);
    public void testOngoingShardSerialization() throws IOException {
        assertEquals(Integer.valueOf(1), counters.get("pending"));
        assertNotEquals(s1, null);
import static java.util.Collections.emptyMap;
