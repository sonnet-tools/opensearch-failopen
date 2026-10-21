                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        List<ShardRouting> shardRoutings = Collections.singletonList(shard);
    public void testGetMaxConcurrentTieringRequestsSetting() {
            clusterService,
import org.opensearch.cluster.metadata.Metadata;
    }
        ClusterChangedEvent event = mock(ClusterChangedEvent.class);
        Metadata metadata = mock(Metadata.class);
        RoutingTable routingTable = mock(RoutingTable.class);
        Metadata metadata = mock(Metadata.class);
        ClusterState previousState = mock(ClusterState.class);
    }
import org.opensearch.common.settings.Settings;
 * this file be licensed under the Apache-2.0 license or a
        clusterService = mock(ClusterService.class);
import static org.opensearch.storage.common.tiering.TieringUtils.W2H_TIERING_START_TIME_KEY;
        assertFalse(
        when(event.previousState()).thenReturn(previousState);
            settings.get(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey())
        DiscoveryNodes previousNodes = mock(DiscoveryNodes.class);
        );
        assertEquals("true", settings.get(IS_WARM_INDEX_SETTING.getKey()));
            .numberOfShards(1)
        when(clusterState.metadata()).thenReturn(metadata);
        assertTrue(service.tieringIndices.contains(index1.getIndex()));
    public void tearDown() throws Exception {
            .build();
import java.util.List;
        assertEquals(WARM_TO_HOT.toString(), settings.get(INDEX_TIERING_STATE.getKey()));
    @Override
            mock(ShardLimitValidator.class)
        List<ShardRouting> shardRoutings = Arrays.asList(
    private IndexMetadata buildDfaIndexMetadata() {
        when(previousNodes.isLocalNodeElectedClusterManager()).thenReturn(false);
        when(shard.unassigned()).thenReturn(false);
        );
            "blocks.write must NOT be set for non-DFA on W2H cancel — would wrongly lock a non-DFA index",
 * compatible open source license.
    private Settings indexSettings;
import org.opensearch.cluster.routing.ShardRouting;
}
            "INDEX_WRITE_BLOCK must be removed when W2H tiering starts",
        DiscoveryNode node = mock(DiscoveryNode.class);
        assertEquals(TIERED_COMPOSITE_INDEX_TYPE, settings.get(INDEX_COMPOSITE_STORE_TYPE_SETTING.getKey()));
    public void testProcessTieringInProgress_WithUnassignedReplica() {
        assertEquals("false", settings.get(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey()));
        clusterState = mock(ClusterState.class);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
import org.junit.Before;
        assertEquals(TieringState.WARM.toString(), settings.get(INDEX_TIERING_STATE.getKey()));
        when(metadata.index(testIndex)).thenReturn(indexMetadata);
        RoutingTable routingTable = mock(RoutingTable.class);
        super.setUp();
    private IndexMetadata createIndexMetadata(String name, String tieringState) {
import java.util.Set;
        indexMetadata = IndexMetadata.builder("test-index").settings(indexSettings).numberOfShards(1).numberOfReplicas(1).build();
            .put(W2H_MAX_CONCURRENT_TIERING_REQUESTS.getKey(), 50)
        RoutingTable routingTable = mock(RoutingTable.class);
        when(event.state()).thenReturn(clusterState);
import static org.opensearch.index.IndexModule.TieringState.WARM_TO_HOT;
        assertEquals("false", settings.get(IS_WARM_INDEX_SETTING.getKey()));
            mock(IndexNameExpressionResolver.class),
        assertNull(
        Settings settings = service.getTieringStartSettingsToAdd(buildDfaIndexMetadata());
        Metadata metadata = mock(Metadata.class);
            .build();
        assertFalse(service.tieringIndices.contains(index3.getIndex()));
import java.util.HashSet;
        ClusterBlocks result = service.getTieringStartClusterBlocksToAdd(builder, indexName, buildDfaIndexMetadata()).build();
            result.hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK)
        when(event.localNodeClusterManager()).thenReturn(false);
        ClusterChangedEvent event = mock(ClusterChangedEvent.class);
        when(event.routingTableChanged()).thenReturn(true);
        verify(routingTable).allShards(testIndex.getName());
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
    }
        when(routingTable.hasIndex(testIndex)).thenReturn(true);
                    .put(IndexMetadata.SETTING_INDEX_UUID, "non-dfa-uuid")
            .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
import static org.mockito.Mockito.when;
        Settings settings = service.getTieringStartSettingsToAdd(buildNonDfaIndexMetadata());
import org.opensearch.common.settings.ClusterSettings;
            .put(JVM_USAGE_TIERING_THRESHOLD_PERCENT.getKey(), 99)
import org.opensearch.cluster.node.DiscoveryNode;
        assertEquals(WARM_TO_HOT.toString(), settings.get(INDEX_TIERING_STATE.getKey()));
        super.tearDown();
package org.opensearch.storage.tiering;
        when(event.routingTableChanged()).thenReturn(true);
import org.opensearch.cluster.routing.RoutingTable;
import static org.opensearch.index.IndexModule.INDEX_TIERING_STATE;
    }
        when(event.localNodeClusterManager()).thenReturn(true);
    }
        when(event.state()).thenReturn(clusterState);
        );
import org.opensearch.test.OpenSearchTestCase;
        DiscoveryNodes previousNodes = mock(DiscoveryNodes.class);
    private ClusterState clusterState;
        return IndexMetadata.builder("test-dfa")
    public void testReconstructInProgressTiering_WarmToHot() {
        when(shard.started()).thenReturn(started);
        service.clusterChanged(event);
        when(event.routingTableChanged()).thenReturn(true);
        when(routingTable.allShards(testIndex.getName())).thenReturn(shardRoutings);
    private WarmToHotTieringService service;
import static org.opensearch.storage.common.tiering.TieringUtils.JVM_USAGE_TIERING_THRESHOLD_PERCENT;
        verify(routingTable).allShards(testIndex.getName());
        String indexName = "test-index";
import org.opensearch.common.util.io.IOUtils;
import static org.mockito.Mockito.mock;
        when(clusterState.metadata()).thenReturn(metadata);
        ClusterChangedEvent event = mock(ClusterChangedEvent.class);
        nodeEnvironment = newNodeEnvironment();
    private NodeEnvironment nodeEnvironment;
    private Index testIndex;
    public void testGetIndexTierClusterBlocksToRestoreAfterCancellation_AddsWriteBlock() {
        service.clusterChanged(event);
                Settings.builder()
        when(routingTable.hasIndex(testIndex)).thenReturn(false);
    }
        return IndexMetadata.builder("test-non-dfa")
    public void testGetIndexTierSettingsToRestoreAfterCancellation_DfaIndex() {
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
import org.opensearch.common.settings.Setting;
import org.opensearch.cluster.ClusterChangedEvent;
        when(nodes.get("node1")).thenReturn(node);
    }
    public void testGetTieringType() {
    }
        ShardRouting shard = mock(ShardRouting.class);
    @Before
        assertEquals("false", settings.get(IS_WARM_INDEX_SETTING.getKey()));
        when(metadata.iterator()).thenReturn(Collections.emptyIterator());
import org.opensearch.index.IndexSettings;
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    }
        when(clusterState.metadata()).thenReturn(metadata);
        when(previousNodes.isLocalNodeElectedClusterManager()).thenReturn(true);
                    .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
    public void testClusterChanged_WithRoutingTableChange_IndexDeleted() {
            defaultSettings,
        IndexMetadata index2 = createIndexMetadata("index2", WARM_TO_HOT.toString());
        // W2H tiering start: index transitions to hot → remove write block
        when(nodes.get("node1")).thenReturn(node);
import org.opensearch.index.IndexModule.TieringState;
        clusterSettingsToAdd.add(DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING);
        ClusterState previousState = mock(ClusterState.class);
        verify(event, never()).previousState();
        assertEquals(2, service.tieringIndices.size());
        Metadata metadata = Metadata.builder().put(index1, false).put(index2, false).put(index3, false).build();
    }
        IndexMetadata index1 = createIndexMetadata("index1", WARM_TO_HOT.toString());
    public void setUp() throws Exception {
            mock(AllocationService.class),
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
import static org.opensearch.index.IndexModule.INDEX_COMPOSITE_STORE_TYPE_SETTING;
        assertEquals(TieringState.WARM.toString(), settings.get(INDEX_TIERING_STATE.getKey()));
        when(node.isWarmNode()).thenReturn(false);
        );
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
    public void testGetTieringStartTimeKey() {
        service.clusterChanged(event);
        when(clusterState.getNodes()).thenReturn(nodes);
        Set<Setting<?>> clusterSettingsToAdd = new HashSet<>(BUILT_IN_CLUSTER_SETTINGS);
        assertTrue(service.tieringIndices.contains(index2.getIndex()));
        ClusterBlocks result = service.getIndexTierClusterBlocksToRestoreAfterCancellation(builder, indexName, buildDfaIndexMetadata())
        Settings defaultSettings = Settings.builder()
            mock(ClusterInfoService.class),
import org.opensearch.env.NodeEnvironment;
    }
        when(event.previousState()).thenReturn(previousState);
        when(event.state()).thenReturn(clusterState);
        when(shard.currentNodeId()).thenReturn("node1");
        ClusterState previousState = mock(ClusterState.class);
        when(shard.currentNodeId()).thenReturn(nodeId);
            .settings(
            )
 */
            .build();
    public void testGetTieringStartClusterBlocksToAdd_RemovesWriteBlock() {
        IOUtils.close(nodeEnvironment);
        when(event.localNodeClusterManager()).thenReturn(true);
    private ShardRouting createShardRouting(boolean primary, boolean unassigned, String nodeId, boolean started) {
import org.opensearch.cluster.ClusterState;
        when(shard.primary()).thenReturn(primary);
    }
        when(clusterState.routingTable()).thenReturn(routingTable);
        when(nodes.get("node1")).thenReturn(node);
    }
        assertEquals("default", settings.get(INDEX_COMPOSITE_STORE_TYPE_SETTING.getKey()));
import org.opensearch.core.index.Index;
        when(previousState.nodes()).thenReturn(previousNodes);
        when(event.localNodeClusterManager()).thenReturn(true);
        when(node.isWarmNode()).thenReturn(false);
        when(previousState.nodes()).thenReturn(previousNodes);
import java.util.Arrays;
                Settings.builder()
 * The OpenSearch Contributors require contributions made to
            "blocks.write must NOT be set for non-DFA on W2H start",
        when(node.isWarmNode()).thenReturn(false);
        when(clusterState.getNodes()).thenReturn(nodes);
        return shard;
        when(routingTable.allShards(testIndex.getName())).thenReturn(shardRoutings);
        Settings settings = service.getIndexTierSettingsToRestoreAfterCancellation(buildDfaIndexMetadata());
        assertTrue(service.isShardInTargetTier(shard, clusterState));
        return IndexMetadata.builder(name).settings(settings).numberOfShards(1).numberOfReplicas(1).build();
public class WarmToHotTieringServiceTests extends OpenSearchTestCase {
import static org.opensearch.storage.common.tiering.TieringUtils.W2H_MAX_CONCURRENT_TIERING_REQUESTS_KEY;
        service.tieringIndices.add(testIndex);
        when(event.previousState()).thenReturn(previousState);
import org.opensearch.indices.ShardLimitValidator;
        ClusterBlocks.Builder builder = ClusterBlocks.builder().addIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK);
        ClusterBlocks.Builder builder = ClusterBlocks.builder();
            createShardRouting(false, true, null, false)
import static org.opensearch.storage.common.tiering.TieringUtils.W2H_MAX_CONCURRENT_TIERING_REQUESTS;
    }
import static org.mockito.Mockito.verify;
    }
        verify(event).localNodeClusterManager();
            .build();
        assertEquals("true", settings.get(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey()));
        when(routingTable.hasIndex(testIndex)).thenReturn(true);
        when(shard.unassigned()).thenReturn(unassigned);
    public void testClusterChanged_NewMaster() {
        DiscoveryNodes previousNodes = mock(DiscoveryNodes.class);
            nodeEnvironment,
        assertEquals("true", settings.get(IS_WARM_INDEX_SETTING.getKey()));
import static org.mockito.Mockito.never;
        service.reconstructInProgressTieringRequests(clusterState, WARM_TO_HOT, "warm");
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        when(shard.started()).thenReturn(true);
        Settings settings = service.getIndexTierSettingsToRestoreAfterCancellation(buildNonDfaIndexMetadata());
        when(previousNodes.isLocalNodeElectedClusterManager()).thenReturn(true);
        clusterSettingsToAdd.add(JVM_USAGE_TIERING_THRESHOLD_PERCENT);
            .build();
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        Settings settings = Settings.builder().put(indexSettings).put(INDEX_TIERING_STATE.getKey(), tieringState).build();
        assertEquals(W2H_TIERING_START_TIME_KEY, service.getTieringStartTimeKey());
        service.clusterChanged(event);
        when(previousNodes.isLocalNodeElectedClusterManager()).thenReturn(true);
import static org.opensearch.common.settings.ClusterSettings.BUILT_IN_CLUSTER_SETTINGS;
            settings.get(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey())
        when(clusterService.getClusterSettings()).thenReturn(mockSettings);
    }
        when(event.state()).thenReturn(clusterState);
    public void testClusterChanged_WithRoutingTableChange_ShardOnHotNode() {
        service = new WarmToHotTieringService(
            .numberOfReplicas(1)
        when(event.previousState()).thenReturn(previousState);
        ClusterState previousState = mock(ClusterState.class);
            )
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
        when(event.localNodeClusterManager()).thenReturn(true);
        ClusterSettings mockSettings = new ClusterSettings(defaultSettings, clusterSettingsToAdd);
    }
    public void testIsShardInTargetTier() {
        when(metadata.iterator()).thenReturn(Collections.emptyIterator());
        when(clusterState.getNodes()).thenReturn(nodes);
    }
        ClusterChangedEvent event = mock(ClusterChangedEvent.class);
        assertEquals(W2H_MAX_CONCURRENT_TIERING_REQUESTS_KEY, service.getMaxConcurrentTieringRequestsSetting().getKey());
        assertNull(
 * SPDX-License-Identifier: Apache-2.0
import java.util.Collections;
        clusterSettingsToAdd.add(W2H_MAX_CONCURRENT_TIERING_REQUESTS);
            .numberOfReplicas(1)
        when(clusterState.metadata()).thenReturn(metadata);
        IndexMetadata index3 = createIndexMetadata("index3", "other_state");
        when(previousState.nodes()).thenReturn(previousNodes);
        assertEquals(TieringState.HOT, service.getTargetTieringState());
    public void testGetTieringStartSettingsToAdd_DfaIndex() {
        assertTrue("INDEX_WRITE_BLOCK must be restored after W2H cancel", result.hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK));
        when(metadata.iterator()).thenReturn(Collections.emptyIterator());
        when(previousState.nodes()).thenReturn(previousNodes);
        testIndex = new Index("test-index", "uuid");
        when(clusterState.routingTable()).thenReturn(routingTable);
        Metadata metadata = mock(Metadata.class);
    }
    private IndexMetadata indexMetadata;
        ClusterChangedEvent event = mock(ClusterChangedEvent.class);
        DiscoveryNode node = mock(DiscoveryNode.class);
import org.opensearch.cluster.routing.allocation.AllocationService;
import org.opensearch.cluster.node.DiscoveryNodes;
    }
    public void testClusterChanged_NonMasterNode() {
                    .put(IndexMetadata.SETTING_INDEX_UUID, "dfa-uuid")
import org.opensearch.cluster.ClusterInfoService;
        // W2H cancel: index goes back to warm → restore write block
    }
    }
 *
/*
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
        DiscoveryNodes previousNodes = mock(DiscoveryNodes.class);
        String indexName = "test-index";
import org.opensearch.cluster.metadata.IndexMetadata;
            .settings(
        service.clusterChanged(event);
            .numberOfShards(1)
        service.tieringIndices.add(testIndex);
import static org.opensearch.storage.common.tiering.TieringUtils.TIERED_COMPOSITE_INDEX_TYPE;
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        ShardRouting shard = createShardRouting(true, false, "node1", true);
import org.opensearch.Version;
    public void testGetIndexTierSettingsToRestoreAfterCancellation_NonDfaIndex_NoWriteBlockSetting() {
        assertTrue(service.tieringIndices.isEmpty());
    private IndexMetadata buildNonDfaIndexMetadata() {
        when(clusterState.metadata()).thenReturn(metadata);
            createShardRouting(true, false, "node1", true),
import org.opensearch.cluster.service.ClusterService;
    public void testGetTieringStartSettingsToAdd_NonDfaIndex_NoWriteBlockSetting() {
        verify(previousNodes).isLocalNodeElectedClusterManager();
import static org.opensearch.index.IndexModule.IS_WARM_INDEX_SETTING;
    private ClusterService clusterService;
        service.tieringIndices.add(testIndex);
import static org.opensearch.index.store.remote.filecache.FileCacheSettings.DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING;
        indexSettings = Settings.builder()
        );
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
import org.opensearch.cluster.block.ClusterBlocks;
        assertEquals(WARM_TO_HOT, service.getTieringType());
        when(clusterState.routingTable()).thenReturn(routingTable);
        DiscoveryNode node = mock(DiscoveryNode.class);
        ShardRouting shard = mock(ShardRouting.class);
        when(metadata.index(testIndex)).thenReturn(indexMetadata);
    public void testGetTargetTieringState() {
    }
