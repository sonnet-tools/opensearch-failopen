import static org.mockito.Mockito.mock;
import org.opensearch.cluster.routing.allocation.AllocationService;
        when(shard.currentNodeId()).thenReturn("node1");
            .build();
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
    }
import org.opensearch.cluster.routing.ShardRouting;  
public class HotToWarmTieringServiceTests extends OpenSearchTestCase {
    public void testGetIndexTierSettingsToRestoreAfterCancellation_NonDfaIndex_NoWriteBlockSetting() {
        assertEquals(H2W_TIERING_START_TIME_KEY, service.getTieringStartTimeKey());
            settings.get(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey())
import org.opensearch.test.OpenSearchTestCase;
import static org.opensearch.storage.common.tiering.TieringUtils.H2W_MAX_CONCURRENT_TIERING_REQUESTS;  
            )
    private IndexMetadata buildDfaIndexMetadata() {
            .build();
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
        assertNull(
 * SPDX-License-Identifier: Apache-2.0
        clusterService = mock(ClusterService.class);  
        when(nodes.get("node1")).thenReturn(node);
            "blocks.write must NOT be set for non-DFA on H2W start",  
    public void testGetTieringStartSettingsToAdd_NonDfaIndex_NoWriteBlockSetting() {
        IOUtils.close(nodeEnvironment);
        Settings settings = service.getTieringStartSettingsToAdd(buildNonDfaIndexMetadata());
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
        assertEquals(TieringState.WARM, service.getTargetTieringState());
        return IndexMetadata.builder("test-non-dfa")  
    private ClusterState clusterState;  
 * The OpenSearch Contributors require contributions made to  
            .settings(
        ClusterSettings mockSettings = new ClusterSettings(defaultSettings, clusterSettingsToAdd);
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
        service = new HotToWarmTieringService(
import org.opensearch.common.settings.Settings;
        assertEquals(HOT_TO_WARM.toString(), settings.get(INDEX_TIERING_STATE.getKey()));
    }
import static org.opensearch.index.IndexModule.TieringState.HOT_TO_WARM;  
            .numberOfReplicas(1)
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        // INDEX_BLOCKS_WRITE is intentionally NOT set during cancel — the write block is deferred
        Settings defaultSettings = Settings.builder()
        assertEquals(TIERED_COMPOSITE_INDEX_TYPE, settings.get(INDEX_COMPOSITE_STORE_TYPE_SETTING.getKey()));
    private ClusterService clusterService;
        assertEquals("false", settings.get(IS_WARM_INDEX_SETTING.getKey()));
/*  
        when(shard.unassigned()).thenReturn(false);  
            mock(ShardLimitValidator.class)
 * compatible open source license.
    }  
    public void testGetTieringStartTimeKey() {
            .put(H2W_MAX_CONCURRENT_TIERING_REQUESTS.getKey(), 50)
    }
import org.opensearch.cluster.node.DiscoveryNode;
    public void tearDown() throws Exception {
        when(node.isWarmNode()).thenReturn(true);
            settings.get(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey())
            "blocks.write must NOT be set for non-DFA on H2W cancel",
        String indexName = "test-index";
        super.setUp();
        nodeEnvironment = newNodeEnvironment();
        DiscoveryNode node = mock(DiscoveryNode.class);  
    }
        ClusterBlocks result = service.getIndexTierClusterBlocksToRestoreAfterCancellation(builder, indexName, buildDfaIndexMetadata())
                    .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
    }
    }
            .put(JVM_USAGE_TIERING_THRESHOLD_PERCENT.getKey(), 99)  
import org.opensearch.cluster.ClusterState;  
        ClusterBlocks.Builder builder = ClusterBlocks.builder();
        clusterSettingsToAdd.add(FILECACHE_ACTIVE_USAGE_TIERING_THRESHOLD_PERCENT);
        );
    @Before  
            nodeEnvironment,
        Settings settings = service.getIndexTierSettingsToRestoreAfterCancellation(buildDfaIndexMetadata());  
import static org.opensearch.index.IndexModule.INDEX_COMPOSITE_STORE_TYPE_SETTING;
    public void testIsShardInTargetTier() {
    }  
    @Override  
import org.opensearch.cluster.block.ClusterBlocks;
    }  
            mock(ClusterInfoService.class),
    }  
            .settings(
    public void testGetIndexTierSettingsToRestoreAfterCancellation_DfaIndex() {
    }
        clusterSettingsToAdd.add(DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING);
    private HotToWarmTieringService service;
        assertEquals(TieringState.HOT.toString(), settings.get(INDEX_TIERING_STATE.getKey()));
import org.opensearch.cluster.node.DiscoveryNodes;
import org.opensearch.indices.ShardLimitValidator;  
        ClusterBlocks.Builder result = service.getTieringStartClusterBlocksToAdd(builder, "test-index", buildDfaIndexMetadata());  
import static org.opensearch.index.IndexModule.IS_WARM_INDEX_SETTING;
import static org.opensearch.storage.common.tiering.TieringUtils.TIERED_COMPOSITE_INDEX_TYPE;
        return IndexMetadata.builder("test-dfa")  
        // H2W write blocks are set by TransportHotToWarmTierAction before tier(), so getTieringStartClusterBlocksToAdd is a no-op
                Settings.builder()
        // TieringService.removeWriteBlockForCancelledDfaIndices() once all shards are confirmed
import static org.mockito.Mockito.when;  
            defaultSettings,
        clusterState = mock(ClusterState.class);
    }  
        assertTrue(service.isShardInTargetTier(shard, clusterState));
        assertTrue(
    public void testGetTieringStartClusterBlocksToAdd_IsNoOp() {  
import static org.opensearch.index.IndexModule.TieringState;
    private NodeEnvironment nodeEnvironment;
                Settings.builder()
        Set<Setting<?>> clusterSettingsToAdd = new HashSet<>(BUILT_IN_CLUSTER_SETTINGS);
import static org.opensearch.storage.common.tiering.TieringUtils.FILECACHE_ACTIVE_USAGE_TIERING_THRESHOLD_PERCENT;
import org.opensearch.common.settings.ClusterSettings;  
        // H2W cancel: the cluster-level INDEX_WRITE_BLOCK is intentionally kept on the index
        assertNull(
        // running a read-only engine. The block is removed later by
            .build();
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
            .put(FILECACHE_ACTIVE_USAGE_TIERING_THRESHOLD_PERCENT.getKey(), 90)
import java.util.HashSet;
        );
        ClusterBlocks.Builder builder = ClusterBlocks.builder().addIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK);
        assertEquals(HOT_TO_WARM, service.getTieringType());
import java.util.Set;
        assertEquals("false", settings.get(IS_WARM_INDEX_SETTING.getKey()));
        );  
import org.opensearch.env.NodeEnvironment;
        assertEquals(HOT_TO_WARM.toString(), settings.get(INDEX_TIERING_STATE.getKey()));  
}  
        // and lifted by TieringService.removeWriteBlockForCancelledDfaIndices() only after all
            .build();
            )
import static org.opensearch.storage.common.tiering.TieringUtils.H2W_TIERING_START_TIME_KEY;
            .numberOfShards(1)  
            .numberOfShards(1)
import static org.opensearch.common.settings.ClusterSettings.BUILT_IN_CLUSTER_SETTINGS;
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
    public void testGetTieringType() {
        assertEquals(H2W_MAX_CONCURRENT_TIERING_REQUESTS_KEY, service.getMaxConcurrentTieringRequestsSetting().getKey());  
    public void testGetIndexTierClusterBlocksToRestoreAfterCancellation_IsNoOp() {
        clusterSettingsToAdd.add(H2W_MAX_CONCURRENT_TIERING_REQUESTS);
        when(clusterService.getClusterSettings()).thenReturn(mockSettings);
        assertEquals("true", settings.get(IS_WARM_INDEX_SETTING.getKey()));
        assertSame("getTieringStartClusterBlocksToAdd must be a no-op for H2W", builder, result);
    }
        // shards are confirmed started on hot nodes (writable engine). Removing it here would  
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            result.hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK)  
        );
                    .put(IndexMetadata.SETTING_INDEX_UUID, "non-dfa-uuid")
            mock(AllocationService.class),  
import static org.opensearch.index.IndexModule.INDEX_TIERING_STATE;  
import org.opensearch.common.settings.Setting;
import static org.opensearch.index.store.remote.filecache.FileCacheSettings.DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING;
    public void testGetMaxConcurrentTieringRequestsSetting() {
            .numberOfReplicas(1)  
import org.opensearch.cluster.ClusterInfoService;
        super.tearDown();  
 * this file be licensed under the Apache-2.0 license or a
            "blocks.write must NOT be set during cancel — deferred to removeWriteBlockForCancelledDfaIndices()",  
    }
import org.opensearch.cluster.service.ClusterService;
import static org.opensearch.storage.common.tiering.TieringUtils.JVM_USAGE_TIERING_THRESHOLD_PERCENT;  
            mock(IndexNameExpressionResolver.class),
            "INDEX_WRITE_BLOCK must be KEPT during H2W cancel — deferred removal until shards are on hot",
        when(shard.started()).thenReturn(true);
        assertNull(  
    public void testGetTieringStartSettingsToAdd_DfaIndex() {  
            settings.get(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey())
        ShardRouting shard = mock(ShardRouting.class);
        assertEquals("default", settings.get(INDEX_COMPOSITE_STORE_TYPE_SETTING.getKey()));  
package org.opensearch.storage.tiering;
        Settings settings = service.getTieringStartSettingsToAdd(buildDfaIndexMetadata());
    public void setUp() throws Exception {
 */  
        // allow writes to reach warm-node shards that still run a read-only engine.
        when(clusterState.getNodes()).thenReturn(nodes);  
            clusterService,  
        );  
import org.opensearch.common.util.io.IOUtils;  
        assertEquals(TieringState.HOT.toString(), settings.get(INDEX_TIERING_STATE.getKey()));
    private IndexMetadata buildNonDfaIndexMetadata() {
        Settings settings = service.getIndexTierSettingsToRestoreAfterCancellation(buildNonDfaIndexMetadata());  
 *
    }
import static org.opensearch.storage.common.tiering.TieringUtils.H2W_MAX_CONCURRENT_TIERING_REQUESTS_KEY;
        // during cancel so that writes cannot reach shards that are still on warm nodes and  
                    .put(IndexMetadata.SETTING_INDEX_UUID, "dfa-uuid")
        // started on hot nodes.  
import org.opensearch.index.IndexSettings;
        assertEquals("true", settings.get(IS_WARM_INDEX_SETTING.getKey()));  
import org.opensearch.Version;
        clusterSettingsToAdd.add(JVM_USAGE_TIERING_THRESHOLD_PERCENT);  
import org.opensearch.cluster.metadata.IndexMetadata;
    public void testGetTargetTieringState() {  
import org.junit.Before;
