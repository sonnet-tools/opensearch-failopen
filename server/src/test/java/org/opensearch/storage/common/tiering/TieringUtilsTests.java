        org.opensearch.cluster.ClusterState state = org.opensearch.cluster.ClusterState.builder(org.opensearch.cluster.ClusterName.DEFAULT)
    }
        assertEquals("HOT", tiers[1]);
        assertEquals(TieringUtils.H2W_TIERING_TYPE_KEY, TieringUtils.getTieringSourceType(warmRequest));
        when(shard.started()).thenReturn(true);
    }
    }
public class TieringUtilsTests extends OpenSearchTestCase {
        assertTrue(TieringUtils.isTerminalTier("warm"));
        ClusterState state = mock(ClusterState.class);
    }
        assertFalse(TieringUtils.isCCRFollowerIndex(nonCcrSettings));
        when(state.getNodes()).thenReturn(nodes);
        expectThrows(IllegalArgumentException.class, () -> TieringUtils.isMigrationAllowed(null));
        org.opensearch.common.settings.Settings settings = org.opensearch.common.settings.Settings.EMPTY;
import org.opensearch.cluster.ClusterState;
    }
                    .put(org.opensearch.index.IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
        assertFalse(TieringUtils.isMigrationAllowed(".system-index"));
    public void testGetTieringStartTime_NullCustomData() {
    }
            .numberOfShards(1)
    public void testIsShardStateValidForTier_StartedOnHotNode_TargetHot() {
        assertEquals(TieringUtils.Tier.WARM, TieringUtils.Tier.fromString("warm"));
        assertEquals("WARM", tiers[0]);
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.common.settings.Settings;
    public void testGetTieringStatefromIndexSettings_WarmToHot() {
        assertEquals(12345L, startTime);
        when(nodes.get("node1")).thenReturn(node);
        ClusterState state = mock(ClusterState.class);
        ShardRouting shard = mock(ShardRouting.class);
            TieringUtils.isDfaIndex(state.getMetadata().index("dfa-idx"))
    public void testGetTieringStartTime() {
        when(node.isWarmNode()).thenReturn(false);
        when(shard.primary()).thenReturn(true);
import org.opensearch.storage.action.tiering.IndexTieringRequest;
    }
        IndexMetadata indexMetadata = mock(IndexMetadata.class);
                    .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)
                Settings.builder()
        assertTrue(TieringUtils.isCCRFollowerIndex(ccrSettings));
    }
        Metadata metadata = mock(Metadata.class);
    }
            .build();
        ShardRouting shard = mock(ShardRouting.class);
            .numberOfReplicas(0)
    }
        assertEquals(IndexModule.TieringState.HOT_TO_WARM, TieringUtils.getTieringStatefromIndexSettings(settings));
            .numberOfReplicas(0)
        IndexTieringRequest warmRequest = new IndexTieringRequest("WARM", "test-index");
        expectThrows(IllegalArgumentException.class, () -> TieringUtils.Tier.fromString("invalid"));
        ClusterState clusterState = mock(ClusterState.class);
            .build();
    }
        expectThrows(IllegalArgumentException.class, () -> TieringUtils.isMigrationAllowed(""));
        assertFalse(TieringUtils.isMigrationAllowed(".kibana"));
            IllegalArgumentException.class,
        when(indexMetadata.getCustomData("tiering")).thenReturn(Map.of("h2w_start_time", "12345"));
            .build();
            () -> TieringUtils.isShardStateValidForTier(shard, state, IndexModule.TieringState.HOT_TO_WARM)
    public void testIsMigrationAllowed_InvalidInputs() {
        Metadata metadata = mock(Metadata.class);
        expectThrows(IllegalArgumentException.class, () -> TieringUtils.Tier.fromString(null));
        String[] tiers = TieringUtils.getTierPairForTargetTier(IndexModule.TieringState.WARM);
        when(clusterState.getMetadata()).thenReturn(metadata);
import org.opensearch.cluster.node.DiscoveryNode;
        IndexMetadata meta = IndexMetadata.builder("idx")
    }
            .settings(
 *
        assertTrue(TieringUtils.isShardStateValidForTier(shard, state, IndexModule.TieringState.WARM));
        expectThrows(IllegalArgumentException.class, () -> TieringUtils.getTieringStatefromTargetTier("HOT_TO_WARM"));
    public void testGetTieringStatefromIndexSettings_Default() {
    }
import static org.mockito.Mockito.mock;
                    .put(org.opensearch.index.IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
        when(nodes.get("node1")).thenReturn(node);
        assertEquals(TieringUtils.Tier.HOT, TieringUtils.Tier.fromString("HOT"));
    }
        when(shard.primary()).thenReturn(false);
        IndexMetadata meta = IndexMetadata.builder("dfa-idx")
        ShardRouting shard = mock(ShardRouting.class);
                Settings.builder()
                    .put(org.opensearch.index.IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), false)
    public void testTierFromString() {
            .numberOfReplicas(0)
        assertEquals("warm", TieringUtils.Tier.WARM.value());
        assertTrue(TieringUtils.isTerminalTier("hot"));
        expectThrows(IllegalArgumentException.class, () -> TieringUtils.getTieringSourceType((IndexTieringRequest) null));
            .put(IndexModule.INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.WARM_TO_HOT.toString())
    public void testGetTieringSourceType_FromTieringState() {
        Settings nonCcrSettings = Settings.builder().build();
import org.opensearch.cluster.metadata.IndexMetadata;
            .build();
            .numberOfShards(1)
        when(shard.started()).thenReturn(true);
        IndexTieringRequest hotRequest = new IndexTieringRequest("HOT", "test-index");
                    .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)
    }
package org.opensearch.storage.common.tiering;
    // ── isDfaIndex tests ──────────────────────────────────────────────────────
 * SPDX-License-Identifier: Apache-2.0
        when(metadata.getIndexSafe(index)).thenReturn(indexMetadata);
    public void testGetTieringStatefromTargetTier_Hot() {
    public void testIsMigrationAllowed_BlocklistedIndices() {
    }
            .put(IndexModule.INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.WARM.toString())
import org.opensearch.cluster.metadata.Metadata;
    }
        when(indexMetadata.getCustomData("tiering")).thenReturn(null);
    }
        assertEquals("hot", TieringUtils.Tier.HOT.value());
    public void testIsDfaIndex_SettingAbsent_ReturnsFalse() {
    public void testIsCCRFollowerIndex() {
    public void testIsTerminalTier_Hot() {
        assertFalse("isDfaIndex must return false when setting is explicitly false", TieringUtils.isDfaIndex(meta));
 * The OpenSearch Contributors require contributions made to
        assertTrue(TieringUtils.isMigrationAllowed(".ds-my-data-stream-2023"));
        assertTrue(TieringUtils.isShardStateValidForTier(shard, state, IndexModule.TieringState.WARM));
                Settings.builder()
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
        );
        ShardRouting shard = mock(ShardRouting.class);
    }
        expectThrows(IllegalArgumentException.class, () -> TieringUtils.getTierPairForTargetTier(IndexModule.TieringState.HOT_TO_WARM));
    public void testIsMigrationAllowed_AllowlistedIndices() {
        DiscoveryNode node = mock(DiscoveryNode.class);
        );
        assertTrue(TieringUtils.isTerminalTier("HOT"));
        when(state.getNodes()).thenReturn(nodes);
    public void testIsShardStateValidForTier_UnassignedPrimary() {
    }
        assertTrue(TieringUtils.isMigrationAllowed("my-index"));
            .numberOfShards(1)
        assertFalse(TieringUtils.isTerminalTier("random"));
        assertFalse(TieringUtils.isTerminalTier("HOT_TO_WARM"));
    }
    public void testIsDfaIndex_ViaClusterState_DfaIndex_ReturnsTrue() {
        assertEquals(TieringUtils.W2H_TIERING_TYPE_KEY, TieringUtils.getTieringSourceType(hotRequest));
        expectThrows(IllegalStateException.class, () -> TieringUtils.getTieringStartTime(clusterState, index, "h2w_start_time"));
            )
        Index index = new Index("test-index", "uuid");
        when(shard.unassigned()).thenReturn(true);
        assertTrue(TieringUtils.isTerminalTier("WARM"));
            )
        assertEquals(IndexModule.TieringState.HOT_TO_WARM, TieringUtils.getTieringStatefromTargetTier("WARM"));
            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT))
    }
import org.opensearch.cluster.routing.ShardRouting;
    public void testIsShardStateValidForTier_InvalidTargetTier() {
        when(shard.unassigned()).thenReturn(true);
import org.opensearch.index.IndexModule;
    public void testGetTieringStatefromTargetTier_Invalid() {
            .settings(
        when(metadata.getIndexSafe(index)).thenReturn(indexMetadata);
        Settings ccrSettings = Settings.builder().put("index.plugins.replication.follower.leader_index", "leader-index").build();
}
        IndexMetadata meta = IndexMetadata.builder("idx")
        org.opensearch.common.settings.Settings settings = org.opensearch.common.settings.Settings.builder()
        org.opensearch.common.settings.Settings settings = org.opensearch.common.settings.Settings.builder()
        ShardRouting shard = mock(ShardRouting.class);
        IndexMetadata meta = IndexMetadata.builder("idx")
    public void testGetTierPairForTargetTier_Hot() {
    public void testIsDfaIndex_NullMetadata_ReturnsFalse() {
    public void testGetTierPairForTargetTier_Warm() {
    public void testGetTieringStatefromIndexSettings_Warm() {
    }
        DiscoveryNode node = mock(DiscoveryNode.class);
        when(clusterState.getMetadata()).thenReturn(metadata);
        ClusterState state = mock(ClusterState.class);
        IndexMetadata indexMetadata = mock(IndexMetadata.class);
    }
            .settings(
        when(shard.currentNodeId()).thenReturn("node1");
        ClusterState state = mock(ClusterState.class);
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
    public void testGetTieringStatefromIndexSettings_HotToWarm() {
    }
    public void testGetTieringSourceType_NullRequest() {
    public void testIsShardStateValidForTier_UnassignedReplica() {
        when(shard.started()).thenReturn(true);
    }
import java.util.Map;
        assertEquals("WARM", tiers[1]);
        expectThrows(
    }
            .build();
        assertFalse(TieringUtils.isShardStateValidForTier(shard, state, IndexModule.TieringState.WARM));
import org.opensearch.core.index.Index;
 */
        when(shard.unassigned()).thenReturn(false);
 * compatible open source license.
        org.opensearch.common.settings.Settings settings = org.opensearch.common.settings.Settings.builder()
        Index index = new Index("test-index", "uuid");
        assertEquals(IndexModule.TieringState.WARM_TO_HOT, TieringUtils.getTieringStatefromTargetTier("HOT"));
        assertEquals(IndexModule.TieringState.WARM_TO_HOT, TieringUtils.getTieringStatefromIndexSettings(settings));
import static org.mockito.Mockito.when;
    public void testIsDfaIndex_SettingTrue_ReturnsTrue() {
            .put(IndexModule.INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.HOT_TO_WARM.toString())
    }
        String[] tiers = TieringUtils.getTierPairForTargetTier(IndexModule.TieringState.HOT);
        DiscoveryNode node = mock(DiscoveryNode.class);
    public void testTierValue() {
        when(state.getNodes()).thenReturn(nodes);
            .build();
        when(shard.unassigned()).thenReturn(false);
            .build();
        long startTime = TieringUtils.getTieringStartTime(clusterState, index, "h2w_start_time");
    }
                    .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)
        assertTrue(TieringUtils.isShardStateValidForTier(shard, state, IndexModule.TieringState.HOT));
    public void testGetTierPairForTargetTier_Invalid() {
        ClusterState state = mock(ClusterState.class);
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
            .numberOfReplicas(0)
        assertEquals(TieringUtils.W2H_TIERING_TYPE_KEY, TieringUtils.getTieringSourceType(IndexModule.TieringState.HOT));
        when(nodes.get("node1")).thenReturn(node);
    public void testIsDfaIndex_SettingFalse_ReturnsFalse() {
            .metadata(org.opensearch.cluster.metadata.Metadata.builder().put(meta, false).build())
        assertFalse("isDfaIndex must return false when PLUGGABLE_DATAFORMAT_ENABLED is absent", TieringUtils.isDfaIndex(meta));
        expectThrows(IllegalArgumentException.class, () -> TieringUtils.isMigrationAllowed(" "));
        when(shard.unassigned()).thenReturn(false);
        assertEquals(IndexModule.TieringState.WARM_TO_HOT, TieringUtils.getTieringStatefromIndexSettings(settings));
        assertEquals("HOT", tiers[0]);
        when(node.isWarmNode()).thenReturn(true);
    public void testGetTieringSourceType_FromRequest() {
    }
        when(node.isWarmNode()).thenReturn(false);
            "isDfaIndex via ClusterState must return true for DFA index",
            .build();
/*
    }
    }
 * this file be licensed under the Apache-2.0 license or a
        ClusterState clusterState = mock(ClusterState.class);
            )
    public void testIsTerminalTier_Warm() {
        assertEquals(TieringUtils.H2W_TIERING_TYPE_KEY, TieringUtils.getTieringSourceType(IndexModule.TieringState.WARM));
    public void testIsShardStateValidForTier_StartedOnWarmNode_TargetWarm() {
        when(shard.currentNodeId()).thenReturn("node1");
    }
        when(shard.currentNodeId()).thenReturn("node1");
import org.opensearch.cluster.node.DiscoveryNodes;
    public void testGetTieringStatefromTargetTier_Warm() {
    }
        assertTrue("isDfaIndex must return true when PLUGGABLE_DATAFORMAT_ENABLED is true", TieringUtils.isDfaIndex(meta));
        assertFalse("isDfaIndex(null) must return false", TieringUtils.isDfaIndex((IndexMetadata) null));
        assertTrue(
    public void testIsTerminalTier_Invalid() {
        assertEquals(IndexModule.TieringState.HOT_TO_WARM, TieringUtils.getTieringStatefromIndexSettings(settings));
            .numberOfShards(1)
