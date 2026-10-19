        assertEquals(H2W_MAX_CONCURRENT_TIERING_REQUESTS_KEY, service.getMaxConcurrentTieringRequestsSetting().getKey());
        ClusterSettings mockSettings = new ClusterSettings(defaultSettings, clusterSettingsToAdd);
    private NodeEnvironment nodeEnvironment;
    public void testGetTieringStartSettingsToAdd_DfaIndex() {
        clusterSettingsToAdd.add(H2W_MAX_CONCURRENT_TIERING_REQUESTS);
import org.opensearch.common.util.io.IOUtils;
 * SPDX-License-Identifier: Apache-2.0
    private ClusterState clusterState;
import static org.opensearch.common.settings.ClusterSettings.BUILT_IN_CLUSTER_SETTINGS;
    }
                    .put(IndexMetadata.SETTING_INDEX_UUID, "non-dfa-uuid")
            .numberOfReplicas(1)
    }
    }
        assertEquals(HOT_TO_WARM.toString(), settings.get(INDEX_TIERING_STATE.getKey()));
    public void testIsShardInTargetTier() {
    }
        Settings settings = service.getTieringStartSettingsToAdd(buildDfaIndexMetadata());
import org.opensearch.cluster.routing.allocation.AllocationService;
        );
        assertSame("getTieringStartClusterBlocksToAdd must be a no-op for H2W", builder, result);
        assertEquals(TieringState.WARM, service.getTargetTieringState());
import org.opensearch.common.settings.ClusterSettings;
    }
        Settings settings = service.getTieringStartSettingsToAdd(buildNonDfaIndexMetadata());
        clusterSettingsToAdd.add(FILECACHE_ACTIVE_USAGE_TIERING_THRESHOLD_PERCENT);
        );
        when(nodes.get("node1")).thenReturn(node);
import static org.opensearch.index.IndexModule.TieringState;
import static org.opensearch.index.IndexModule.INDEX_COMPOSITE_STORE_TYPE_SETTING;
    public void testGetTieringStartTimeKey() {
            mock(ClusterInfoService.class),
            .build();
import java.util.Set;
import static org.opensearch.storage.common.tiering.TieringUtils.H2W_MAX_CONCURRENT_TIERING_REQUESTS;
            "blocks.write must NOT be set for non-DFA on H2W cancel",
        ClusterBlocks.Builder result = service.getTieringStartClusterBlocksToAdd(builder, "test-index", buildDfaIndexMetadata());
        DiscoveryNode node = mock(DiscoveryNode.class);
import org.opensearch.cluster.node.DiscoveryNode;
        // H2W cancel: the cluster-level INDEX_WRITE_BLOCK is intentionally kept on the index
import static org.mockito.Mockito.mock;
package org.opensearch.storage.tiering;
import org.opensearch.cluster.node.DiscoveryNodes;
    private IndexMetadata buildNonDfaIndexMetadata() {
    }
    public void testGetIndexTierSettingsToRestoreAfterCancellation_NonDfaIndex_NoWriteBlockSetting() {
        return IndexMetadata.builder("test-dfa")
            result.hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK)
    private IndexMetadata buildDfaIndexMetadata() {
                    .put(IndexMetadata.SETTING_INDEX_UUID, "dfa-uuid")
        when(shard.started()).thenReturn(true);
            settings.get(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey())
        // allow writes to reach warm-node shards that still run a read-only engine.
            )
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            mock(ShardLimitValidator.class)
        clusterState = mock(ClusterState.class);
            mock(AllocationService.class),
        assertNull(
            .build();
import static org.opensearch.index.IndexModule.IS_WARM_INDEX_SETTING;
    private ClusterService clusterService;
            "blocks.write must NOT be set for non-DFA on H2W start",
    public void setUp() throws Exception {
        assertEquals(H2W_TIERING_START_TIME_KEY, service.getTieringStartTimeKey());
            nodeEnvironment,
import static org.opensearch.storage.common.tiering.TieringUtils.TIERED_COMPOSITE_INDEX_TYPE;
        // H2W write blocks are set by TransportHotToWarmTierAction before tier(), so getTieringStartClusterBlocksToAdd is a no-op
        Settings settings = service.getIndexTierSettingsToRestoreAfterCancellation(buildDfaIndexMetadata());
        when(node.isWarmNode()).thenReturn(true);
        ShardRouting shard = mock(ShardRouting.class);
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
/*
    }
import org.opensearch.cluster.routing.ShardRouting;
            )
        Settings settings = service.getIndexTierSettingsToRestoreAfterCancellation(buildNonDfaIndexMetadata());
        service = new HotToWarmTieringService(
        Settings defaultSettings = Settings.builder()
            settings.get(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey())
import org.junit.Before;
        // INDEX_BLOCKS_WRITE is intentionally NOT set during cancel — the write block is deferred
import org.opensearch.env.NodeEnvironment;
 * The OpenSearch Contributors require contributions made to
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            "INDEX_WRITE_BLOCK must be KEPT during H2W cancel — deferred removal until shards are on hot",
 * compatible open source license.
import static org.opensearch.index.store.remote.filecache.FileCacheSettings.DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING;
    public void tearDown() throws Exception {
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        assertTrue(service.isShardInTargetTier(shard, clusterState));
    }
import org.opensearch.common.settings.Settings;
    @Override
            "blocks.write must NOT be set during cancel — deferred to removeWriteBlockForCancelledDfaIndices()",
        );
    public void testGetMaxConcurrentTieringRequestsSetting() {
    public void testGetTieringType() {
            .numberOfShards(1)
    public void testGetTieringStartClusterBlocksToAdd_IsNoOp() {
        // running a read-only engine. The block is removed later by
        assertEquals("true", settings.get(IS_WARM_INDEX_SETTING.getKey()));
import static org.opensearch.storage.common.tiering.TieringUtils.H2W_TIERING_START_TIME_KEY;
            clusterService,
        // TieringService.removeWriteBlockForCancelledDfaIndices() once all shards are confirmed
            .build();
    }
            settings.get(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey())
            .settings(
        // shards are confirmed started on hot nodes (writable engine). Removing it here would
import org.opensearch.indices.ShardLimitValidator;
            mock(IndexNameExpressionResolver.class),
        clusterService = mock(ClusterService.class);
    public void testGetIndexTierClusterBlocksToRestoreAfterCancellation_IsNoOp() {
import static org.mockito.Mockito.when;
import org.opensearch.cluster.block.ClusterBlocks;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
}
                Settings.builder()
import org.opensearch.cluster.service.ClusterService;
        Set<Setting<?>> clusterSettingsToAdd = new HashSet<>(BUILT_IN_CLUSTER_SETTINGS);
    }
import org.opensearch.cluster.ClusterState;
                Settings.builder()
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
import org.opensearch.common.settings.Setting;
        assertEquals("true", settings.get(IS_WARM_INDEX_SETTING.getKey()));
import org.opensearch.cluster.metadata.IndexMetadata;
        super.setUp();
    @Before
        when(shard.currentNodeId()).thenReturn("node1");
public class HotToWarmTieringServiceTests extends OpenSearchTestCase {
        // started on hot nodes.
import org.opensearch.cluster.ClusterInfoService;
            .settings(
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(TIERED_COMPOSITE_INDEX_TYPE, settings.get(INDEX_COMPOSITE_STORE_TYPE_SETTING.getKey()));
    }
        assertEquals(HOT_TO_WARM.toString(), settings.get(INDEX_TIERING_STATE.getKey()));
        // during cancel so that writes cannot reach shards that are still on warm nodes and
            defaultSettings,
        clusterSettingsToAdd.add(JVM_USAGE_TIERING_THRESHOLD_PERCENT);
 *
    public void testGetTargetTieringState() {
        assertEquals("default", settings.get(INDEX_COMPOSITE_STORE_TYPE_SETTING.getKey()));
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
        when(clusterService.getClusterSettings()).thenReturn(mockSettings);
        assertNull(
    private HotToWarmTieringService service;
import org.opensearch.index.IndexSettings;
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(
    }
import java.util.HashSet;
            .put(FILECACHE_ACTIVE_USAGE_TIERING_THRESHOLD_PERCENT.getKey(), 90)
        assertEquals(TieringState.HOT.toString(), settings.get(INDEX_TIERING_STATE.getKey()));
        assertEquals("false", settings.get(IS_WARM_INDEX_SETTING.getKey()));
    }
        // and lifted by TieringService.removeWriteBlockForCancelledDfaIndices() only after all
import static org.opensearch.index.IndexModule.TieringState.HOT_TO_WARM;
        return IndexMetadata.builder("test-non-dfa")
        clusterSettingsToAdd.add(DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING);
        assertNull(
        nodeEnvironment = newNodeEnvironment();
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertEquals(TieringState.HOT.toString(), settings.get(INDEX_TIERING_STATE.getKey()));
import static org.opensearch.storage.common.tiering.TieringUtils.JVM_USAGE_TIERING_THRESHOLD_PERCENT;
            .put(JVM_USAGE_TIERING_THRESHOLD_PERCENT.getKey(), 99)
        assertEquals(HOT_TO_WARM, service.getTieringType());
 */
        ClusterBlocks.Builder builder = ClusterBlocks.builder();
    }
        );
import org.opensearch.Version;
    }
            .numberOfShards(1)
        ClusterBlocks result = service.getIndexTierClusterBlocksToRestoreAfterCancellation(builder, indexName, buildDfaIndexMetadata())
        assertEquals("false", settings.get(IS_WARM_INDEX_SETTING.getKey()));
        when(shard.unassigned()).thenReturn(false);
    public void testGetTieringStartSettingsToAdd_NonDfaIndex_NoWriteBlockSetting() {
            .numberOfReplicas(1)
        ClusterBlocks.Builder builder = ClusterBlocks.builder().addIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK);
        when(clusterState.getNodes()).thenReturn(nodes);
            .put(H2W_MAX_CONCURRENT_TIERING_REQUESTS.getKey(), 50)
    public void testGetIndexTierSettingsToRestoreAfterCancellation_DfaIndex() {
        super.tearDown();
        IOUtils.close(nodeEnvironment);
        );
import static org.opensearch.storage.common.tiering.TieringUtils.FILECACHE_ACTIVE_USAGE_TIERING_THRESHOLD_PERCENT;
        String indexName = "test-index";
                    .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
import static org.opensearch.index.IndexModule.INDEX_TIERING_STATE;
import static org.opensearch.storage.common.tiering.TieringUtils.H2W_MAX_CONCURRENT_TIERING_REQUESTS_KEY;
            .build();
