import org.opensearch.storage.action.tiering.IndexTieringRequest;
        ClusterState clusterState = mock(ClusterState.class);
    public void testIsShardStateValidForTier_UnassignedReplica() {
        expectThrows(IllegalArgumentException.class, () -> TieringUtils.isMigrationAllowed(" "));  
        expectThrows(IllegalArgumentException.class, () -> TieringUtils.isMigrationAllowed(null));
    }  
        when(shard.unassigned()).thenReturn(false);
        expectThrows(  
        assertFalse(TieringUtils.isMigrationAllowed(".system-index"));
    public void testGetTieringStatefromTargetTier_Warm() {
        assertTrue(TieringUtils.isShardStateValidForTier(shard, state, IndexModule.TieringState.WARM));
            .numberOfShards(1)
                    .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)
        when(shard.primary()).thenReturn(true);
        assertTrue(TieringUtils.isTerminalTier("WARM"));  
        expectThrows(IllegalArgumentException.class, () -> TieringUtils.Tier.fromString(null));
        assertTrue(TieringUtils.isMigrationAllowed(".ds-my-data-stream-2023"));  
        DiscoveryNode node = mock(DiscoveryNode.class);
        when(state.getNodes()).thenReturn(nodes);  
        assertTrue("isDfaIndex must return true when PLUGGABLE_DATAFORMAT_ENABLED is true", TieringUtils.isDfaIndex(meta));
        assertEquals(IndexModule.TieringState.HOT_TO_WARM, TieringUtils.getTieringStatefromTargetTier("WARM"));
    }
import org.opensearch.cluster.ClusterState;
        when(clusterState.getMetadata()).thenReturn(metadata);
                    .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)
        assertFalse(TieringUtils.isTerminalTier("HOT_TO_WARM"));
                    .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)  
    public void testGetTieringSourceType_FromTieringState() {  
            .build();
        when(shard.started()).thenReturn(true);
        when(metadata.getIndexSafe(index)).thenReturn(indexMetadata);
            .build();  
        assertFalse("isDfaIndex must return false when setting is explicitly false", TieringUtils.isDfaIndex(meta));  
        );  
    public void testIsDfaIndex_SettingAbsent_ReturnsFalse() {
            .settings(
    }  
            .metadata(org.opensearch.cluster.metadata.Metadata.builder().put(meta, false).build())  
    }  
        ClusterState state = mock(ClusterState.class);  
        IndexMetadata meta = IndexMetadata.builder("idx")
        org.opensearch.cluster.ClusterState state = org.opensearch.cluster.ClusterState.builder(org.opensearch.cluster.ClusterName.DEFAULT)
        assertFalse(TieringUtils.isShardStateValidForTier(shard, state, IndexModule.TieringState.WARM));  
 * compatible open source license.
            TieringUtils.isDfaIndex(state.getMetadata().index("dfa-idx"))
    public void testIsDfaIndex_ViaClusterState_DfaIndex_ReturnsTrue() {
    public void testTierValue() {
}
    }
        when(shard.started()).thenReturn(true);
    }
        assertTrue(TieringUtils.isShardStateValidForTier(shard, state, IndexModule.TieringState.HOT));
    }
        when(indexMetadata.getCustomData("tiering")).thenReturn(Map.of("h2w_start_time", "12345"));
    public void testIsTerminalTier_Hot() {  
        expectThrows(IllegalArgumentException.class, () -> TieringUtils.Tier.fromString("invalid"));
        when(state.getNodes()).thenReturn(nodes);
        Index index = new Index("test-index", "uuid");  
    }
            .put(IndexModule.INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.WARM_TO_HOT.toString())  
        when(shard.currentNodeId()).thenReturn("node1");  
    }  
                    .put(org.opensearch.index.IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
        assertEquals("WARM", tiers[0]);
            .build();
    public void testIsMigrationAllowed_InvalidInputs() {  
        IndexMetadata indexMetadata = mock(IndexMetadata.class);
        when(shard.currentNodeId()).thenReturn("node1");
    public void testGetTieringStatefromIndexSettings_Warm() {
    }  
        IndexMetadata meta = IndexMetadata.builder("dfa-idx")
        when(nodes.get("node1")).thenReturn(node);
        Index index = new Index("test-index", "uuid");
import org.opensearch.test.OpenSearchTestCase;
import java.util.Map;
        String[] tiers = TieringUtils.getTierPairForTargetTier(IndexModule.TieringState.WARM);  
                    .put(org.opensearch.index.IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)  
        DiscoveryNode node = mock(DiscoveryNode.class);
    public void testIsMigrationAllowed_BlocklistedIndices() {
        assertEquals(IndexModule.TieringState.HOT_TO_WARM, TieringUtils.getTieringStatefromIndexSettings(settings));
            .build();  
            .put(IndexModule.INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.WARM.toString())
        expectThrows(IllegalArgumentException.class, () -> TieringUtils.getTierPairForTargetTier(IndexModule.TieringState.HOT_TO_WARM));  
        when(metadata.getIndexSafe(index)).thenReturn(indexMetadata);  
        assertEquals(TieringUtils.H2W_TIERING_TYPE_KEY, TieringUtils.getTieringSourceType(IndexModule.TieringState.WARM));
    public void testIsTerminalTier_Warm() {
    public void testGetTieringStatefromTargetTier_Hot() {  
        DiscoveryNode node = mock(DiscoveryNode.class);  
        Settings ccrSettings = Settings.builder().put("index.plugins.replication.follower.leader_index", "leader-index").build();
        when(shard.primary()).thenReturn(false);  
            IllegalArgumentException.class,
        ShardRouting shard = mock(ShardRouting.class);  
        assertFalse(TieringUtils.isCCRFollowerIndex(nonCcrSettings));
        Metadata metadata = mock(Metadata.class);  
        expectThrows(IllegalArgumentException.class, () -> TieringUtils.getTieringStatefromTargetTier("HOT_TO_WARM"));  
        assertEquals("hot", TieringUtils.Tier.HOT.value());  
        String[] tiers = TieringUtils.getTierPairForTargetTier(IndexModule.TieringState.HOT);  
    // ── isDfaIndex tests ──────────────────────────────────────────────────────
        ShardRouting shard = mock(ShardRouting.class);
    }  
            .build();
 * SPDX-License-Identifier: Apache-2.0
        IndexMetadata indexMetadata = mock(IndexMetadata.class);  
/*  
            .numberOfShards(1)
    }
                Settings.builder()
        );
        ClusterState state = mock(ClusterState.class);  
        ShardRouting shard = mock(ShardRouting.class);
    public void testIsDfaIndex_SettingTrue_ReturnsTrue() {  
 * this file be licensed under the Apache-2.0 license or a
        ShardRouting shard = mock(ShardRouting.class);
        org.opensearch.common.settings.Settings settings = org.opensearch.common.settings.Settings.builder()  
                Settings.builder()  
package org.opensearch.storage.common.tiering;
        expectThrows(IllegalStateException.class, () -> TieringUtils.getTieringStartTime(clusterState, index, "h2w_start_time"));  
    public void testIsCCRFollowerIndex() {  
    public void testGetTieringSourceType_FromRequest() {  
        long startTime = TieringUtils.getTieringStartTime(clusterState, index, "h2w_start_time");
        assertEquals("HOT", tiers[1]);
import org.opensearch.cluster.node.DiscoveryNodes;
            () -> TieringUtils.isShardStateValidForTier(shard, state, IndexModule.TieringState.HOT_TO_WARM)
    }
        assertFalse(TieringUtils.isMigrationAllowed(".kibana"));  
        when(node.isWarmNode()).thenReturn(true);
    public void testIsDfaIndex_SettingFalse_ReturnsFalse() {
    public void testIsShardStateValidForTier_InvalidTargetTier() {
        org.opensearch.common.settings.Settings settings = org.opensearch.common.settings.Settings.EMPTY;
            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT))
        Metadata metadata = mock(Metadata.class);
    public void testIsTerminalTier_Invalid() {
            .numberOfShards(1)  
        assertFalse("isDfaIndex(null) must return false", TieringUtils.isDfaIndex((IndexMetadata) null));
        Settings nonCcrSettings = Settings.builder().build();
    public void testIsShardStateValidForTier_StartedOnHotNode_TargetHot() {
import org.opensearch.cluster.routing.ShardRouting;  
    }
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
        assertEquals(TieringUtils.Tier.HOT, TieringUtils.Tier.fromString("HOT"));
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);  
import static org.mockito.Mockito.when;
        ClusterState state = mock(ClusterState.class);
    public void testGetTierPairForTargetTier_Warm() {
        when(node.isWarmNode()).thenReturn(false);
    }
public class TieringUtilsTests extends OpenSearchTestCase {  
        assertFalse(TieringUtils.isTerminalTier("random"));  
        IndexTieringRequest hotRequest = new IndexTieringRequest("HOT", "test-index");
        when(nodes.get("node1")).thenReturn(node);  
        assertEquals(IndexModule.TieringState.WARM_TO_HOT, TieringUtils.getTieringStatefromTargetTier("HOT"));
        when(nodes.get("node1")).thenReturn(node);
    public void testGetTierPairForTargetTier_Invalid() {
import org.opensearch.cluster.metadata.Metadata;  
        when(shard.unassigned()).thenReturn(false);  
 */  
    }
import org.opensearch.cluster.metadata.IndexMetadata;
        assertEquals(TieringUtils.Tier.WARM, TieringUtils.Tier.fromString("warm"));  
    public void testGetTieringStartTime() {  
        when(node.isWarmNode()).thenReturn(false);  
            .numberOfReplicas(0)
    }
            .settings(
        assertFalse("isDfaIndex must return false when PLUGGABLE_DATAFORMAT_ENABLED is absent", TieringUtils.isDfaIndex(meta));
    }  
        assertTrue(TieringUtils.isTerminalTier("hot"));
        when(state.getNodes()).thenReturn(nodes);
    }
        expectThrows(IllegalArgumentException.class, () -> TieringUtils.isMigrationAllowed(""));
        assertEquals("WARM", tiers[1]);
    }
import static org.mockito.Mockito.mock;  
        assertEquals(IndexModule.TieringState.HOT_TO_WARM, TieringUtils.getTieringStatefromIndexSettings(settings));  
                    .put(org.opensearch.index.IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), false)
    public void testTierFromString() {
        assertTrue(TieringUtils.isMigrationAllowed("my-index"));
        when(shard.unassigned()).thenReturn(false);
        assertEquals(IndexModule.TieringState.WARM_TO_HOT, TieringUtils.getTieringStatefromIndexSettings(settings));
    public void testGetTieringStatefromIndexSettings_WarmToHot() {
        assertEquals(IndexModule.TieringState.WARM_TO_HOT, TieringUtils.getTieringStatefromIndexSettings(settings));
        org.opensearch.common.settings.Settings settings = org.opensearch.common.settings.Settings.builder()
        assertEquals("HOT", tiers[0]);
        ClusterState state = mock(ClusterState.class);
 * The OpenSearch Contributors require contributions made to  
        assertTrue(
    }  
    }  
        org.opensearch.common.settings.Settings settings = org.opensearch.common.settings.Settings.builder()
        assertTrue(TieringUtils.isShardStateValidForTier(shard, state, IndexModule.TieringState.WARM));
    }  
            "isDfaIndex via ClusterState must return true for DFA index",  
        ClusterState clusterState = mock(ClusterState.class);
        when(shard.unassigned()).thenReturn(true);
            .settings(  
    }
            .numberOfReplicas(0)  
            .numberOfShards(1)
    }
    public void testGetTieringSourceType_NullRequest() {
import org.opensearch.common.settings.Settings;
    public void testIsShardStateValidForTier_UnassignedPrimary() {
            )
import org.opensearch.index.IndexModule;  
    public void testGetTieringStatefromIndexSettings_Default() {  
    public void testGetTieringStatefromIndexSettings_HotToWarm() {  
import org.opensearch.core.index.Index;
        IndexMetadata meta = IndexMetadata.builder("idx")  
        when(clusterState.getMetadata()).thenReturn(metadata);  
    }
import org.opensearch.cluster.node.DiscoveryNode;
        IndexMetadata meta = IndexMetadata.builder("idx")  
    public void testIsDfaIndex_NullMetadata_ReturnsFalse() {
        assertTrue(TieringUtils.isTerminalTier("HOT"));
    }  
        ClusterState state = mock(ClusterState.class);
            )  
        assertEquals(TieringUtils.H2W_TIERING_TYPE_KEY, TieringUtils.getTieringSourceType(warmRequest));
            .build();
        assertTrue(TieringUtils.isCCRFollowerIndex(ccrSettings));
            )
        assertEquals("warm", TieringUtils.Tier.WARM.value());
            .numberOfReplicas(0)
    }
        assertEquals(12345L, startTime);
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
            .put(IndexModule.INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.HOT_TO_WARM.toString())
    }  
    }
    public void testGetTieringStatefromTargetTier_Invalid() {
    public void testGetTieringStartTime_NullCustomData() {
        IndexTieringRequest warmRequest = new IndexTieringRequest("WARM", "test-index");
        assertEquals(TieringUtils.W2H_TIERING_TYPE_KEY, TieringUtils.getTieringSourceType(hotRequest));
                Settings.builder()
        assertEquals(TieringUtils.W2H_TIERING_TYPE_KEY, TieringUtils.getTieringSourceType(IndexModule.TieringState.HOT));
    }  
    public void testIsShardStateValidForTier_StartedOnWarmNode_TargetWarm() {  
    }
    }  
        when(shard.currentNodeId()).thenReturn("node1");
    }  
        assertTrue(TieringUtils.isTerminalTier("warm"));
            .build();
            .numberOfReplicas(0)  
    public void testIsMigrationAllowed_AllowlistedIndices() {
            .build();
        when(shard.unassigned()).thenReturn(true);
        when(shard.started()).thenReturn(true);  
    public void testGetTierPairForTargetTier_Hot() {
        when(indexMetadata.getCustomData("tiering")).thenReturn(null);
 *
        ShardRouting shard = mock(ShardRouting.class);  
        expectThrows(IllegalArgumentException.class, () -> TieringUtils.getTieringSourceType((IndexTieringRequest) null));  
