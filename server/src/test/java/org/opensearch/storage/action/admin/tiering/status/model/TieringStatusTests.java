        long startTime = System.currentTimeMillis();
        Map<String, Integer> counters = status.getShardLevelCounters();
    }
    }
import org.opensearch.cluster.routing.ShardRouting;
    public void testOngoingShardSerialization() throws IOException {  
        DiscoveryNode warmNode = new DiscoveryNode("warm-node", buildNewFakeTransportAddress(), emptyMap(), warmRoles, Version.CURRENT);
        builder.addShard(TestShardRouting.newShardRouting(index.getName(), 0, "warm-node", true, ShardRoutingState.STARTED));  
    public void testFromRoutingTable_WithMixedShardStates() {  
        assertNotEquals(s1, "string");  
        Map<String, Integer> counters = status.getShardLevelCounters();
        // Test for WARM tier
        TieringStatus.ShardLevelStatus status = TieringStatus.ShardLevelStatus.fromRoutingTable(clusterState, "test-index", false, "HOT");
        when(clusterState.routingTable()).thenReturn(routingTableBuilder.build());
import static org.mockito.Mockito.mock;
        assertTrue(counters.containsKey("succeeded"));
    }
            Version.CURRENT
            buildNewFakeTransportAddress(),
 * compatible open source license.
            assertTrue(node.isWarmNode());  
import java.util.HashSet;
            index.getName(),
import org.opensearch.cluster.routing.RoutingTable;
        );
    }
    public void testTieringStatusSerialization() throws IOException {  
import java.util.List;
        assertTrue(counters.containsKey("running"));
        ClusterState clusterState = mock(ClusterState.class);
        verify(streamOutput).writeString("RUNNING");
        ShardRouting primaryShard = TestShardRouting.newShardRouting(  
        assertEquals(counters, status.getShardLevelCounters());
        IndexRoutingTable.Builder builder = IndexRoutingTable.builder(index);
        DiscoveryNode node = new DiscoveryNode(  
    }
import org.opensearch.cluster.node.DiscoveryNode;  
import org.opensearch.test.OpenSearchTestCase;
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
        TieringStatus.ShardLevelStatus status = TieringStatus.ShardLevelStatus.fromRoutingTable(  
    }  
        StreamOutput streamOutput = mock(StreamOutput.class);
            roles.add(DiscoveryNodeRole.DATA_ROLE);  
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(Integer.valueOf(4), counters.get("total"));
        }
        testForTier(false, false);
            ShardRoutingState.RELOCATING
import static org.mockito.Mockito.verify;  
        assertEquals(Integer.valueOf(1), counters.get("running"));
        // Verify counters
        // Mock ClusterState and its components  
        );
        counters.put("pending", 2);
        builder.addShard(replicaShard);  
        original.writeTo(streamOutput);
            "node-3",
 * The OpenSearch Contributors require contributions made to  
        assertEquals(startTime, tieringStatus.getStartTime());  
        shard.writeTo(streamOutput);
            1,
    }
        assertEquals(s1.hashCode(), s2.hashCode());  
        counters.put("running", 1);  
        // Mock StreamOutput  
        builder.addShard(primaryShard);  
        builder.addShard(TestShardRouting.newShardRouting(index.getName(), 1, "hot-node", true, ShardRoutingState.STARTED));
            false,  
        Set<DiscoveryNodeRole> hotRoles = new HashSet<>();  
        if (isWarmTier) {
        ClusterState clusterState = mock(ClusterState.class);
    }  
 * this file be licensed under the Apache-2.0 license or a
        TieringStatus tieringStatus = new TieringStatus(indexName, status, source, target, startTime);  
        // This would be implementation-specific based on your needs  
        if (isWarmTier) {  
import org.opensearch.cluster.routing.IndexRoutingTable;  
            2,  
        RoutingTable routingTable = new RoutingTable.Builder().add(builder.build()).build();
            index.getName(),
        String status = "RUNNING";
    private IndexRoutingTable createRoutingTable(Index index) {
import org.opensearch.cluster.routing.ShardRoutingState;  
import org.opensearch.cluster.node.DiscoveryNodes;
import java.util.HashMap;  
        }  
        String source = "hot";
        assertEquals(s1, s2);  
        when(clusterState.getNodes()).thenReturn(nodes);
        builder.addShard(TestShardRouting.newShardRouting(index.getName(), 3, "hot-node", "warm-node", true, ShardRoutingState.RELOCATING));  
        TieringStatus s1 = new TieringStatus("idx", "RUNNING", "hot", "warm", 100L);
        when(nodes.get(any())).thenReturn(node);  
        TieringStatus s2 = new TieringStatus("idx", "RUNNING", "hot", "warm", 100L);
            roles,
        } else {
public class TieringStatusTests extends OpenSearchTestCase {  
        StreamOutput streamOutput = mock(StreamOutput.class);  
        assertEquals(source, tieringStatus.getSource());
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.cluster.ClusterState;
        counters.put("succeeded", 3);
        verify(streamOutput).writeString("warm");
    public void testTieringStatusConstructor() {
            ShardRoutingState.RELOCATING  
        assertEquals(indexName, tieringStatus.getIndexName());
            assertFalse(counters.containsKey("ongoing_shards"));
        Index index = new Index("test-index", "uuid");  
            true,
        TieringStatus.ShardLevelStatus status = new TieringStatus.ShardLevelStatus(counters, ongoingShards);
    private void testForTier(boolean isWarmTier, boolean isDetailedFlagEnabled) {
import java.util.Set;
        when(nodes.get("warm-node")).thenReturn(warmNode);
        assertEquals(target, tieringStatus.getTarget());
        verify(streamOutput).writeInt(1);  
            "node-2",
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
        return builder.build();
            assertFalse(node.isWarmNode());
        return Collections.emptyList();
        // Create and return test shard routings
import org.opensearch.storage.action.tiering.status.model.TieringStatus;
        testForTier(true, true);  
 */  
        assertNotNull(status);
        List<TieringStatus.OngoingShard> ongoingShards = Collections.singletonList(new TieringStatus.OngoingShard(1, "node2"));  
        Map<String, Integer> counters = status.getShardLevelCounters();
        warmRoles.add(DiscoveryNodeRole.WARM_ROLE);  
        assertNotEquals(s1, s3);
        // Additional assertions specific to tier if needed
    private List<ShardRouting> createTestShards() {
            false,  
        String target = "warm";  
import org.opensearch.cluster.routing.TestShardRouting;
import static java.util.Collections.emptyMap;  
    }
        verify(streamOutput).writeLong(123456L);
        when(clusterState.getNodes()).thenReturn(nodes);  
    }
        TieringStatus original = new TieringStatus("test-index", "RUNNING", "hot", "warm", 123456L);
        TieringStatus s3 = new TieringStatus("other", "RUNNING", "hot", "warm", 100L);  
        ClusterState clusterState = mock(ClusterState.class);
    public void testFromRoutingTable() {
        ShardRouting replicaShard = TestShardRouting.newShardRouting(
import java.io.IOException;
        if (isDetailedFlagEnabled) {  
        when(nodes.get("hot-node")).thenReturn(hotNode);
        // Test for HOT tier
        IndexRoutingTable.Builder builder = IndexRoutingTable.builder(index);
        when(clusterState.getNodes()).thenReturn(nodes);  
        assertEquals(Integer.valueOf(1), counters.get("pending"));  
        builder.addShard(TestShardRouting.newShardRouting(index.getName(), 2, null, true, ShardRoutingState.UNASSIGNED));
        assertNotEquals(s1, null);
import java.util.Collections;
            roles.add(DiscoveryNodeRole.WARM_ROLE);
        // Create node with appropriate roles
        String targetTier = isWarmTier ? "WARM" : "HOT";
        verify(streamOutput).writeString("test-index");
        counters.put("total", 6);
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
        verify(streamOutput).writeString("node2");
/*  
}
import java.util.Map;  
        DiscoveryNode warmNode = new DiscoveryNode("warm-node", buildNewFakeTransportAddress(), emptyMap(), warmRoles, Version.CURRENT);
        TieringStatus s1 = new TieringStatus("idx", "RUNNING", "hot", "warm", 100L);
        IndexRoutingTable.Builder builder = IndexRoutingTable.builder(index);
import static org.mockito.Mockito.when;
        TieringStatus.ShardLevelStatus status = TieringStatus.ShardLevelStatus.fromRoutingTable(clusterState, "test-index", true, "WARM");
    }  
        TieringStatus s2 = new TieringStatus("idx", "RUNNING", "hot", "warm", 100L);
        );
            targetTier
        } else {
    public void testHashCode() {  
        TieringStatus.OngoingShard shard = new TieringStatus.OngoingShard(1, "node2");
        String indexName = "test-index";  
            clusterState,
        DiscoveryNode hotNode = new DiscoveryNode("hot-node", buildNewFakeTransportAddress(), emptyMap(), hotRoles, Version.CURRENT);
    public void testEquals() {  
        Set<DiscoveryNodeRole> warmRoles = new HashSet<>();
import org.opensearch.Version;
        assertTrue(counters.containsKey("total"));
        assertEquals(status, tieringStatus.getStatus());  
import static org.mockito.ArgumentMatchers.any;
        RoutingTable routingTable = new RoutingTable.Builder().add(builder.build()).build();
        assertEquals(s1, s1);
        Index index = new Index("test-index", "uuid");  
        builder.addShard(TestShardRouting.newShardRouting(index.getName(), 0, "warm-node", true, ShardRoutingState.STARTED));  
        verify(streamOutput).writeString("hot");  
        warmRoles.add(DiscoveryNodeRole.WARM_ROLE);  
        when(clusterState.routingTable()).thenReturn(routingTable);  
        Set<DiscoveryNodeRole> roles = new HashSet<>();
        }
        assertEquals(Integer.valueOf(1), counters.get("succeeded"));
            "node-3",
        testForTier(false, true);
    public void testShardLevelStatusCreation() {
        assertEquals(Integer.valueOf(2), counters.get("pending"));  
        assertEquals(1, status.getOngoingShards().size());  
        RoutingTable.Builder routingTableBuilder = new RoutingTable.Builder().add(createRoutingTable(new Index("test-index", "na")));
            "node-" + (isWarmTier ? "warm" : "hot"),
            emptyMap(),  
import org.opensearch.cluster.node.DiscoveryNodeRole;
    }
        Set<DiscoveryNodeRole> warmRoles = new HashSet<>();
        );  
        hotRoles.add(DiscoveryNodeRole.DATA_ROLE);
        Map<String, Integer> counters = new HashMap<>();  
 *
    public void testFromRoutingTable_HotTarget_StartedOnWarmIsPending() {  
        when(nodes.get("warm-node")).thenReturn(warmNode);
package org.opensearch.storage.action.admin.tiering.status.model;
            "node-2",  
        assertEquals(Integer.valueOf(0), counters.get("succeeded"));
        when(clusterState.routingTable()).thenReturn(routingTable);  
        assertTrue(counters.containsKey("pending"));  
import org.opensearch.core.index.Index;  
        // Test for detailed Flag as false
            "test-index",
