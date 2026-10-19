import java.util.List;  
        when(event.state()).thenReturn(clusterState);
        when(shard.started()).thenReturn(started);  
            "INDEX_WRITE_BLOCK must be removed when W2H tiering starts",  
    public void testClusterChanged_NonMasterNode() {  
        ClusterState previousState = mock(ClusterState.class);  
        );
import org.opensearch.cluster.routing.RoutingTable;
        DiscoveryNodes previousNodes = mock(DiscoveryNodes.class);
        when(shard.currentNodeId()).thenReturn("node1");  
    }
    }  
        when(previousNodes.isLocalNodeElectedClusterManager()).thenReturn(true);
        assertEquals(WARM_TO_HOT, service.getTieringType());
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertTrue(service.tieringIndices.isEmpty());  
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        IOUtils.close(nodeEnvironment);  
            clusterService,
        ClusterSettings mockSettings = new ClusterSettings(defaultSettings, clusterSettingsToAdd);
        when(node.isWarmNode()).thenReturn(false);  
import org.opensearch.common.settings.ClusterSettings;  
        when(routingTable.allShards(testIndex.getName())).thenReturn(shardRoutings);
        when(routingTable.hasIndex(testIndex)).thenReturn(true);
        when(previousState.nodes()).thenReturn(previousNodes);  
        Settings settings = service.getTieringStartSettingsToAdd(buildNonDfaIndexMetadata());
    private Settings indexSettings;
        when(clusterState.metadata()).thenReturn(metadata);  
        DiscoveryNode node = mock(DiscoveryNode.class);
import org.opensearch.core.index.Index;
public class WarmToHotTieringServiceTests extends OpenSearchTestCase {
        List<ShardRouting> shardRoutings = Collections.singletonList(shard);
            .numberOfShards(1)
    public void testClusterChanged_NewMaster() {
        when(previousState.nodes()).thenReturn(previousNodes);
        ClusterChangedEvent event = mock(ClusterChangedEvent.class);
        when(event.localNodeClusterManager()).thenReturn(true);  
        IndexMetadata index1 = createIndexMetadata("index1", WARM_TO_HOT.toString());
        assertEquals("true", settings.get(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey()));  
        indexSettings = Settings.builder()
        ShardRouting shard = createShardRouting(true, false, "node1", true);  
    }
        verify(routingTable).allShards(testIndex.getName());
    }  
        when(clusterState.getNodes()).thenReturn(nodes);
    public void testGetTieringStartClusterBlocksToAdd_RemovesWriteBlock() {
        assertTrue("INDEX_WRITE_BLOCK must be restored after W2H cancel", result.hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK));
import static org.opensearch.storage.common.tiering.TieringUtils.W2H_MAX_CONCURRENT_TIERING_REQUESTS;
        verify(event, never()).previousState();
        when(routingTable.allShards(testIndex.getName())).thenReturn(shardRoutings);  
        clusterService = mock(ClusterService.class);
import static org.opensearch.index.store.remote.filecache.FileCacheSettings.DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING;
        assertFalse(
    public void setUp() throws Exception {  
import static org.opensearch.index.IndexModule.INDEX_TIERING_STATE;
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    private WarmToHotTieringService service;  
        when(event.state()).thenReturn(clusterState);  
        super.tearDown();
import org.opensearch.test.OpenSearchTestCase;  
            .build();
        assertTrue(service.tieringIndices.contains(index2.getIndex()));
import org.opensearch.index.IndexModule.TieringState;  
import org.opensearch.indices.ShardLimitValidator;
        when(previousNodes.isLocalNodeElectedClusterManager()).thenReturn(false);
 */  
import org.opensearch.cluster.service.ClusterService;
    }
        Metadata metadata = mock(Metadata.class);
        when(event.routingTableChanged()).thenReturn(true);  
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        when(shard.unassigned()).thenReturn(unassigned);
        );
                Settings.builder()
        RoutingTable routingTable = mock(RoutingTable.class);
    }
    }
        indexMetadata = IndexMetadata.builder("test-index").settings(indexSettings).numberOfShards(1).numberOfReplicas(1).build();
import org.opensearch.env.NodeEnvironment;
 * compatible open source license.
import static org.opensearch.storage.common.tiering.TieringUtils.TIERED_COMPOSITE_INDEX_TYPE;
        service = new WarmToHotTieringService(
import java.util.HashSet;
    }
            )  
    }  
        DiscoveryNode node = mock(DiscoveryNode.class);
        ClusterBlocks.Builder builder = ClusterBlocks.builder();
        nodeEnvironment = newNodeEnvironment();
    }  
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
        Settings defaultSettings = Settings.builder()
        when(event.localNodeClusterManager()).thenReturn(true);
        when(event.previousState()).thenReturn(previousState);
        when(clusterState.metadata()).thenReturn(metadata);  
                Settings.builder()
        when(clusterState.metadata()).thenReturn(metadata);
        when(previousState.nodes()).thenReturn(previousNodes);
            .numberOfReplicas(1)
            .settings(  
    public void testGetIndexTierClusterBlocksToRestoreAfterCancellation_AddsWriteBlock() {
        IndexMetadata index2 = createIndexMetadata("index2", WARM_TO_HOT.toString());  
            "blocks.write must NOT be set for non-DFA on W2H start",
        Set<Setting<?>> clusterSettingsToAdd = new HashSet<>(BUILT_IN_CLUSTER_SETTINGS);  
    public void testIsShardInTargetTier() {
        when(clusterState.routingTable()).thenReturn(routingTable);  
import org.opensearch.cluster.routing.allocation.AllocationService;
    @Before
    public void testGetIndexTierSettingsToRestoreAfterCancellation_DfaIndex() {
                    .put(IndexMetadata.SETTING_INDEX_UUID, "non-dfa-uuid")  
        clusterState = mock(ClusterState.class);  
            .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")  
        assertEquals("false", settings.get(IS_WARM_INDEX_SETTING.getKey()));
        when(shard.currentNodeId()).thenReturn(nodeId);
    public void testGetTieringType() {
import org.opensearch.cluster.ClusterState;
    }
        service.tieringIndices.add(testIndex);
        Metadata metadata = mock(Metadata.class);
        when(event.previousState()).thenReturn(previousState);
    private ShardRouting createShardRouting(boolean primary, boolean unassigned, String nodeId, boolean started) {
        when(routingTable.hasIndex(testIndex)).thenReturn(true);
    }  
import org.opensearch.cluster.routing.ShardRouting;  
import static org.mockito.Mockito.verify;
        assertEquals("false", settings.get(IS_WARM_INDEX_SETTING.getKey()));  
                    .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)  
    }
    public void testGetTieringStartSettingsToAdd_NonDfaIndex_NoWriteBlockSetting() {  
    }
        ClusterChangedEvent event = mock(ClusterChangedEvent.class);
        when(shard.started()).thenReturn(true);
            .numberOfReplicas(1)  
    private ClusterState clusterState;
        service.clusterChanged(event);
        String indexName = "test-index";
        assertNull(
import static org.opensearch.index.IndexModule.TieringState.WARM_TO_HOT;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        when(nodes.get("node1")).thenReturn(node);
import java.util.Arrays;  
        ClusterChangedEvent event = mock(ClusterChangedEvent.class);
import org.opensearch.common.util.io.IOUtils;  
    public void testGetTieringStartTimeKey() {
    }
        assertEquals(WARM_TO_HOT.toString(), settings.get(INDEX_TIERING_STATE.getKey()));
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
        when(metadata.iterator()).thenReturn(Collections.emptyIterator());
import org.opensearch.index.IndexSettings;
        List<ShardRouting> shardRoutings = Arrays.asList(
        );
        when(clusterState.getNodes()).thenReturn(nodes);
        ClusterChangedEvent event = mock(ClusterChangedEvent.class);  
        clusterSettingsToAdd.add(DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING);  
        assertFalse(service.tieringIndices.contains(index3.getIndex()));
        assertEquals(TieringState.WARM.toString(), settings.get(INDEX_TIERING_STATE.getKey()));
            .build();  
    public void testGetMaxConcurrentTieringRequestsSetting() {
import java.util.Set;
        Settings settings = service.getIndexTierSettingsToRestoreAfterCancellation(buildDfaIndexMetadata());
        when(nodes.get("node1")).thenReturn(node);
                    .put(IndexMetadata.SETTING_INDEX_UUID, "dfa-uuid")  
 * SPDX-License-Identifier: Apache-2.0
        String indexName = "test-index";  
        Metadata metadata = mock(Metadata.class);
        when(event.previousState()).thenReturn(previousState);  
import org.opensearch.common.settings.Settings;
        when(event.localNodeClusterManager()).thenReturn(true);
import org.opensearch.Version;
        when(clusterState.routingTable()).thenReturn(routingTable);
        when(metadata.index(testIndex)).thenReturn(indexMetadata);
        RoutingTable routingTable = mock(RoutingTable.class);
import org.opensearch.common.settings.Setting;
        service.clusterChanged(event);
        when(event.localNodeClusterManager()).thenReturn(false);
            .build();
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.cluster.metadata.Metadata;
        return IndexMetadata.builder("test-non-dfa")
        assertEquals(W2H_MAX_CONCURRENT_TIERING_REQUESTS_KEY, service.getMaxConcurrentTieringRequestsSetting().getKey());  
        IndexMetadata index3 = createIndexMetadata("index3", "other_state");
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
            .settings(  
    }
        assertTrue(service.tieringIndices.contains(index1.getIndex()));  
            .build();
        Settings settings = service.getTieringStartSettingsToAdd(buildDfaIndexMetadata());
        when(event.previousState()).thenReturn(previousState);
 * this file be licensed under the Apache-2.0 license or a
        when(shard.unassigned()).thenReturn(false);
import static org.opensearch.storage.common.tiering.TieringUtils.JVM_USAGE_TIERING_THRESHOLD_PERCENT;  
            result.hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK)
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
    public void testGetTargetTieringState() {  
            .numberOfShards(1)
import org.opensearch.cluster.metadata.IndexMetadata;  
    private IndexMetadata createIndexMetadata(String name, String tieringState) {  
        ClusterChangedEvent event = mock(ClusterChangedEvent.class);  
        assertTrue(service.isShardInTargetTier(shard, clusterState));
        when(shard.primary()).thenReturn(primary);  
        ClusterBlocks result = service.getIndexTierClusterBlocksToRestoreAfterCancellation(builder, indexName, buildDfaIndexMetadata())
        testIndex = new Index("test-index", "uuid");  
import org.junit.Before;
import static org.opensearch.storage.common.tiering.TieringUtils.W2H_MAX_CONCURRENT_TIERING_REQUESTS_KEY;  
    }  
    private ClusterService clusterService;
        when(event.localNodeClusterManager()).thenReturn(true);
        when(clusterState.metadata()).thenReturn(metadata);  
        when(clusterService.getClusterSettings()).thenReturn(mockSettings);  
            createShardRouting(false, true, null, false)
            .build();  
        assertEquals(W2H_TIERING_START_TIME_KEY, service.getTieringStartTimeKey());
import org.opensearch.cluster.ClusterChangedEvent;
    @Override
        when(node.isWarmNode()).thenReturn(false);
import org.opensearch.cluster.node.DiscoveryNodes;
    public void testClusterChanged_WithRoutingTableChange_ShardOnHotNode() {  
        service.clusterChanged(event);
 *
        ClusterState previousState = mock(ClusterState.class);  
            createShardRouting(true, false, "node1", true),  
        ClusterBlocks result = service.getTieringStartClusterBlocksToAdd(builder, indexName, buildDfaIndexMetadata()).build();  
import java.util.Collections;
            .put(JVM_USAGE_TIERING_THRESHOLD_PERCENT.getKey(), 99)  
import static org.opensearch.index.IndexModule.INDEX_COMPOSITE_STORE_TYPE_SETTING;
    }
        assertEquals("true", settings.get(IS_WARM_INDEX_SETTING.getKey()));
        DiscoveryNodes previousNodes = mock(DiscoveryNodes.class);  
            mock(IndexNameExpressionResolver.class),  
import static org.mockito.Mockito.never;  
        verify(event).localNodeClusterManager();  
        verify(previousNodes).isLocalNodeElectedClusterManager();
    }
            mock(ShardLimitValidator.class)  
import static org.mockito.Mockito.mock;
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        when(clusterState.getNodes()).thenReturn(nodes);  
        RoutingTable routingTable = mock(RoutingTable.class);
        service.reconstructInProgressTieringRequests(clusterState, WARM_TO_HOT, "warm");  
        when(metadata.iterator()).thenReturn(Collections.emptyIterator());
        ClusterState previousState = mock(ClusterState.class);
import static org.opensearch.common.settings.ClusterSettings.BUILT_IN_CLUSTER_SETTINGS;  
        when(clusterState.routingTable()).thenReturn(routingTable);
        return shard;
    }
            defaultSettings,  
            )
        when(event.routingTableChanged()).thenReturn(true);
    public void testProcessTieringInProgress_WithUnassignedReplica() {
            settings.get(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey())  
        service.clusterChanged(event);
    }
        clusterSettingsToAdd.add(JVM_USAGE_TIERING_THRESHOLD_PERCENT);
        verify(routingTable).allShards(testIndex.getName());  
        assertEquals("true", settings.get(IS_WARM_INDEX_SETTING.getKey()));  
    public void testGetIndexTierSettingsToRestoreAfterCancellation_NonDfaIndex_NoWriteBlockSetting() {  
        return IndexMetadata.builder("test-dfa")
        when(previousNodes.isLocalNodeElectedClusterManager()).thenReturn(true);  
        Settings settings = service.getIndexTierSettingsToRestoreAfterCancellation(buildNonDfaIndexMetadata());
        // W2H tiering start: index transitions to hot → remove write block
    private IndexMetadata indexMetadata;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        );
    private NodeEnvironment nodeEnvironment;  
        ClusterBlocks.Builder builder = ClusterBlocks.builder().addIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK);
        ShardRouting shard = mock(ShardRouting.class);
    }
        when(routingTable.hasIndex(testIndex)).thenReturn(false);  
        assertEquals(2, service.tieringIndices.size());
        assertEquals(WARM_TO_HOT.toString(), settings.get(INDEX_TIERING_STATE.getKey()));  
        when(event.state()).thenReturn(clusterState);
    private IndexMetadata buildNonDfaIndexMetadata() {
    public void testClusterChanged_WithRoutingTableChange_IndexDeleted() {
        when(event.state()).thenReturn(clusterState);
        DiscoveryNode node = mock(DiscoveryNode.class);  
    private Index testIndex;  
package org.opensearch.storage.tiering;
    private IndexMetadata buildDfaIndexMetadata() {
        return IndexMetadata.builder(name).settings(settings).numberOfShards(1).numberOfReplicas(1).build();
        assertEquals(TIERED_COMPOSITE_INDEX_TYPE, settings.get(INDEX_COMPOSITE_STORE_TYPE_SETTING.getKey()));
    public void tearDown() throws Exception {
            settings.get(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey())  
        when(clusterState.metadata()).thenReturn(metadata);
        Metadata metadata = mock(Metadata.class);
        DiscoveryNodes previousNodes = mock(DiscoveryNodes.class);
        assertNull(
        Settings settings = Settings.builder().put(indexSettings).put(INDEX_TIERING_STATE.getKey(), tieringState).build();
        when(previousNodes.isLocalNodeElectedClusterManager()).thenReturn(true);
        service.tieringIndices.add(testIndex);  
        );
        super.setUp();
        assertEquals("default", settings.get(INDEX_COMPOSITE_STORE_TYPE_SETTING.getKey()));
            .put(W2H_MAX_CONCURRENT_TIERING_REQUESTS.getKey(), 50)
/*  
        when(node.isWarmNode()).thenReturn(false);  
import org.opensearch.cluster.node.DiscoveryNode;  
import org.opensearch.cluster.ClusterInfoService;  
        when(nodes.get("node1")).thenReturn(node);
import static org.opensearch.storage.common.tiering.TieringUtils.W2H_TIERING_START_TIME_KEY;
            nodeEnvironment,
        clusterSettingsToAdd.add(W2H_MAX_CONCURRENT_TIERING_REQUESTS);
        assertEquals(TieringState.HOT, service.getTargetTieringState());
        Metadata metadata = Metadata.builder().put(index1, false).put(index2, false).put(index3, false).build();  
            mock(AllocationService.class),
        // W2H cancel: index goes back to warm → restore write block  
        ShardRouting shard = mock(ShardRouting.class);  
            mock(ClusterInfoService.class),
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        service.clusterChanged(event);
        when(metadata.iterator()).thenReturn(Collections.emptyIterator());
        ClusterState previousState = mock(ClusterState.class);
        assertEquals("false", settings.get(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey()));  
}
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
    public void testGetTieringStartSettingsToAdd_DfaIndex() {
        when(event.routingTableChanged()).thenReturn(true);
        DiscoveryNodes previousNodes = mock(DiscoveryNodes.class);  
        when(previousState.nodes()).thenReturn(previousNodes);  
        when(metadata.index(testIndex)).thenReturn(indexMetadata);  
import static org.mockito.Mockito.when;
    public void testReconstructInProgressTiering_WarmToHot() {
import static org.opensearch.index.IndexModule.IS_WARM_INDEX_SETTING;  
        assertEquals(TieringState.WARM.toString(), settings.get(INDEX_TIERING_STATE.getKey()));  
import org.opensearch.cluster.block.ClusterBlocks;
            "blocks.write must NOT be set for non-DFA on W2H cancel — would wrongly lock a non-DFA index",
    }
        service.tieringIndices.add(testIndex);  
