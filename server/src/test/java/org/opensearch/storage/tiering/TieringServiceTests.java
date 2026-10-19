        @Override
            .build();
            .routingTable(rt)  
            Settings.EMPTY,
            return Settings.builder()
                .put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true)
        when(rtMock.hasIndex(dfaIndex)).thenReturn(true);
        DiscoveryNode hotNode = mock(DiscoveryNode.class);  
            indexNameExpressionResolver,
        DiscoveryNode node = mock(DiscoveryNode.class);
     * TOCTOU guard inside execute(): index condition changed between scan and task execution
        ClusterState result = taskCaptor.getValue().execute(clusterState);
        Metadata.Builder metadataBuilder = mock(Metadata.Builder.class);
        IllegalArgumentException e = expectThrows(
        when(clusterState.metadata()).thenReturn(meta);  
            mock(ClusterInfoService.class),
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        ClusterChangedEvent event = mock(ClusterChangedEvent.class);  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    }
        DiscoveryNode hotNode = mock(DiscoveryNode.class);  
 * compatible open source license.
            .put(INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.HOT.toString())  
        Metadata meta = Metadata.builder().put(dfaHotMeta, false).build();  
        IndexMetadata dfaHotMeta = IndexMetadata.builder(dfaIndexName)  
        ArgumentCaptor<IndexMetadata.Builder> captor = ArgumentCaptor.forClass(IndexMetadata.Builder.class);
     * (The target tier here is WARM, so the "already reached target" guard does not trip.)
                .put(INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.HOT)  
        IndexMetadata idxMeta = IndexMetadata.builder("test-index").settings(idxSettings).numberOfShards(1).numberOfReplicas(1).build();
        Metadata metadata = mock(Metadata.class);  
        RoutingTable rt = RoutingTable.builder().addAsNew(executeMeta.index(dfaIndexName)).build();
        verify(clusterService).submitStateUpdateTask(anyString(), taskCaptor.capture());
        protected org.opensearch.cluster.block.ClusterBlocks.Builder getTieringStartClusterBlocksToAdd(
        when(event.state()).thenReturn(currentState);  
            .build();  
        when(rtMock.hasIndex(dfaIndex)).thenReturn(true);
     * DFA index in HOT state with write block, but it's still in tieringIndices
        Set<Setting<?>> clusterSettingsToAdd = new HashSet<>(BUILT_IN_CLUSTER_SETTINGS);
    }
        String dfaUuid = "dfa-still-tiering-uuid";
            Settings.EMPTY,
            .put(INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.WARM.toString())
        // Must NOT throw.
            .addIndexBlock(dfaIndexName, IndexMetadata.INDEX_WRITE_BLOCK)
    /**
            shardLimitValidator
        when(shard.currentNodeId()).thenReturn("node1");
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
        when(metadata.index(testIndex)).thenReturn(indexMetadata);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        ClusterStateUpdateTask capturedTask = taskCaptor.getValue();
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        Metadata metadata = mock(Metadata.class);
        // Should not throw — error is caught and logged  
            mock(AllocationService.class),
    }
            indexNameExpressionResolver,
            )
        public TestTieringService(
     * persisted state shows a HOT_TO_WARM migration in progress. Cancel must be accepted (no throw)
        RoutingTable rtMock = mock(RoutingTable.class);
        tieringService.tieringIndices.add(testIndex);  
     */
        tieringService.updateIndexMetadataForTieringStart(metadataBuilder, routingTableBuilder, indexMetadata, testIndex);
        when(node.isWarmNode()).thenReturn(true);
     */  
    /**  
     *  
        TestTieringService service = new TestTieringService(
        String dfaIndexName = "dfa-w2h-index";
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
    }
        spyService.tier(request, listener, clusterState);
     * The condition {@code s.unassigned() && !s.primary()} must treat the unassigned replica as  
        ArgumentCaptor<ClusterStateUpdateTask> taskCaptor = ArgumentCaptor.forClass(ClusterStateUpdateTask.class);
        // Scan state: index exists with write block
            nodeEnvironment,
            shardLimitValidator
        TestTieringService service = new TestTieringService(  
import org.opensearch.cluster.metadata.IndexMetadata;
        // Use a real ClusterState where the index doesn't exist in metadata
import org.opensearch.cluster.ClusterInfoService;
            .build();
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)  
        when(node.isWarmNode()).thenReturn(false);
            IllegalArgumentException.class,
            .build();  
    public void testListTieringStatus_Empty() {  
            .numberOfShards(1)  
            resolver,
            .build();
            .blocks(blocks)
        assertTrue("Index should be added to tieringIndices", service.tieringIndices.contains(testIndex));
        TestTieringService service = new TestTieringService(  
     * TieringService.removeWriteBlockForCancelledDfaIndices() once all shards are confirmed started
        );
        when(replicaShard.primary()).thenReturn(false);
        );
        assertFalse("Index should be removed after processing", tieringService.tieringIndices.contains(testIndex));
        assertEquals(Priority.NORMAL, capturedTask.priority());
@SuppressWarnings("unchecked")  
        when(clusterState.routingTable()).thenReturn(routingTable);
            .numberOfReplicas(0)
            clusterService,
        List<ShardRouting> shardRoutings = Collections.singletonList(shard);
        AllocationService allocationSvc = mock(AllocationService.class);
            resolver,
        Metadata meta = Metadata.builder().put(dfaWarmMeta, false).build();
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "100b")
            shardLimitValidator
            .build();
     */
        );  
            .put(IndexMetadata.SETTING_INDEX_UUID, "non-dfa-uuid")  
import org.opensearch.common.settings.Setting;
        );
        );  
            .settings(tieringSettings)
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)
        // auto_expand_replicas is not modified by updateIndexMetadataPostTiering —
        ClusterStateUpdateTask task = taskCaptor.getValue();  
            .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")  
        Metadata metadata = mock(Metadata.class);  
            .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)  
        tieringService.clusterChanged(event);  
            .settings(dfaHotSettings)
    /**
    public void testProcessTieringInProgress_CompletesSuccessfully() throws Exception {
        when(clusterState.metadata()).thenReturn(metadata);  
        tieringService.tieringIndices.add(testIndex);
            resultState.blocks().hasIndexBlock("non-dfa-index", IndexMetadata.INDEX_WRITE_BLOCK)
        // Create a WarmToHot-style tiering service that sets read_only_allow_delete: false on start  
        when(metadata.index(testIndex)).thenReturn(indexMetadata);
        String uuid = "non-dfa-hot-uuid";
        IndexMetadata dfaHotMetaWithBlock = IndexMetadata.builder(dfaIndexName)
        Settings dfaHotSettings = Settings.builder()
        when(primaryShard.unassigned()).thenReturn(true);
        ClusterState currentState = mock(ClusterState.class);  
        assertTrue(tieringService.isIndexBeingTiered(testIndex));
        service.tier(request, listener, initialState);
            .build();
        );
                .put(INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.WARM_TO_HOT)  
            shardLimitValidator  
    public void testTier_DfaIndex_WarmToHot_RemovesWriteBlocksFromClusterBlocksAndSettings() throws Exception {  
        service.cancelTiering(request, listener, clusterState);
            return HOT_TO_WARM;  
    /**
        when(routingTable.hasIndex(testIndex)).thenReturn(true);
        ActionListener<ClusterStateUpdateResponse> listener = mock(ActionListener.class);
        when(event.routingTableChanged()).thenReturn(false);  
        when(nodes.get("node1")).thenReturn(node);
            IllegalArgumentException.class,  
            .put(IndexMetadata.SETTING_INDEX_UUID, dfaUuid)
        when(shard.started()).thenReturn(true);
        ShardRouting shard = mock(ShardRouting.class);
                shardLimitValidator  
            .settings(idxSettings)  
        verify(listener).onFailure(any(IllegalArgumentException.class));
        String dfaUuid = "dfa-deleted-uuid";
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        );
        Index dfaIndex = new Index(dfaIndexName, dfaUuid);
        assertNotNull(result);
import org.opensearch.test.OpenSearchTestCase;  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
            .put(maxConcurrentTieringRequestsSetting.getKey(), 50)
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
        clusterSettingsToAdd.add(FileCacheSettings.DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING);
        service.tier(request, listener, clusterState);  
        tieringService = new TestTieringService(
            .put(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), true)  
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)
    // We trigger it by building a ClusterChangedEvent and calling clusterChanged().  
            .put(INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.WARM.toString())  
public class TieringServiceTests extends OpenSearchTestCase {
        when(clusterState.metadata()).thenReturn(meta);
            shardLimitValidator
        when(previousNodes.isLocalNodeElectedClusterManager()).thenReturn(true);  
            shardLimitValidator
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
        when(nodes.get("hot1")).thenReturn(hotNode);  
            mock(ClusterInfoService.class),  
        Index dfaIndex = new Index(dfaIndexName, dfaUuid);  
        String dfaUuid = "dfa-unassigned-primary-uuid";
        when(shard.unassigned()).thenReturn(false);
        when(clusterState.routingTable()).thenReturn(mock(RoutingTable.class));
    public void tearDown() throws Exception {
            .build();
        );  
            new TestTieringService(
        @Override  
                resolver,  
        verify(metadataBuilder).put(captor.capture());
        ClusterChangedEvent event = buildRoutingTableChangedEvent(mockState);
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
            Settings.EMPTY,  
        when(rtMock.allShards(dfaIndexName)).thenReturn(Collections.singletonList(shard));  
        Metadata emptyMetadata = Metadata.builder().build();
        Settings dfaTieringSettings = Settings.builder()  
            mock(ClusterInfoService.class),
        ClusterState resultState = taskCaptor.getValue().execute(initialState);
                Settings.EMPTY,  
    }  
        ActionListener<ClusterStateUpdateResponse> listener = mock(ActionListener.class);  
        when(hotNode.isWarmNode()).thenReturn(false);
        );
        RoutingTable rtMock = mock(RoutingTable.class);
    }
            .put(IndexMetadata.SETTING_INDEX_UUID, dfaUuid)
        Settings dfaHotSettingsWithBlock = Settings.builder()  
    }
        assertTrue("Bad index should not be added", tieringService.tieringIndices.isEmpty());  
            resolver,
            .build();
            any(ClusterStateUpdateTask.class)
     */
        // Cover execute()
        // it carries over from the source indexMetadata unchanged.
     */  
            updatedMetadata.getSettings().get(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey())
        protected void validateTieringRequest(
        ClusterState realState = ClusterState.builder(org.opensearch.cluster.ClusterName.DEFAULT).metadata(emptyMetadata).build();  
        Metadata executeMeta = Metadata.builder().put(dfaHotMeta, false).build();  
            Settings.EMPTY,
            Settings.EMPTY,
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)  
    }
        assertFalse(
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
            .numberOfShards(1)  
        );
            org.opensearch.cluster.block.ClusterBlocks.Builder blocksBuilder,
            .build();  
            .put(INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.HOT.toString())  
        when(clusterState.metadata()).thenReturn(metadata);  
        when(allocationSvc.reroute(any(ClusterState.class), anyString())).thenAnswer(inv -> inv.getArgument(0));  
        // Primary shard: started on a hot node
        Settings dfaHotSettings = Settings.builder()
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .build();
        when(routingTable.hasIndex(testIndex)).thenReturn(true);
            .build();
        ClusterState result = taskCaptor.getValue().execute(realState);
     * The write block is intentionally deferred — it must not be lifted during cancel because some  
            Settings.EMPTY,  
        // The ReplicationTracker requires a replica to avoid assertion failures on warm nodes.
        ClusterState resultState = taskCaptor.getValue().execute(warmState);
            shardLimitValidator
        when(rtMock.allShards(dfaIndexName)).thenReturn(Collections.singletonList(primaryShard));  
        protected IndexModule.TieringState getTieringType() {
        Index dfaIndex = new Index(dfaIndexName, dfaUuid);  
        // number_of_replicas=1 is applied atomically via both metadataBuilder and routingTableBuilder  
        );
            updatedMetadata.getSettings().get(org.opensearch.index.IndexModule.INDEX_TIERING_STATE.getKey())
        RoutingTable rtMock = mock(RoutingTable.class);  
            clusterService,
        // INDEX_WRITE_BLOCK must be removed from ClusterBlocks
            // PLUGGABLE_DATAFORMAT_ENABLED_SETTING not set → non-DFA  
        when(rtMock.hasIndex(dfaIndex)).thenReturn(true);
            .build();
            .routingTable(RoutingTable.EMPTY_ROUTING_TABLE)
            .numberOfReplicas(0)
        when(clusterService.state()).thenReturn(state);
        when(clusterState.getNodes()).thenReturn(nodes);  
            mock(ClusterInfoService.class),
        when(event.routingTableChanged()).thenReturn(true);
        ClusterState result = taskCaptor.getValue().execute(realState);
            allocationSvc,  
            IndexMetadata indexMetadata
        protected Settings getTieringStartSettingsToAdd(IndexMetadata indexMetadata) {  
    }  
        assertNotNull(status);  
        tieringService.updateIndexMetadataForTieringStart(metadataBuilder, routingTableBuilder, oneReplicaIndex, testIndex);
     * Direction-agnostic fallback: a WARM_TO_HOT index not tracked in memory is also accepted.
            "blocks.write must NOT be set to false during cancel — deferred to removeWriteBlockForCancelledDfaIndices()",
        tieringService.reconstructInProgressTieringRequests(clusterState, HOT_TO_WARM, "test_source");
            Index index
            resultState.blocks().hasIndexBlock(dfaIndexName, IndexMetadata.INDEX_WRITE_BLOCK)  
            .put(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), true)
        IndexMetadata dfaHotMeta = IndexMetadata.builder(dfaIndexName)
        when(rtMock.allShards(dfaIndexName)).thenReturn(Collections.singletonList(shard));
            clusterService,
        ClusterState mockScanState = mock(ClusterState.class);
        RoutingTable routingTable = mock(RoutingTable.class);
            nodeEnvironment,
        when(routingTable.hasIndex(testIndex)).thenReturn(true);
        when(mockScanState.blocks()).thenReturn(blocksWithBlock);  
        "test_max_tiering_requests",
        assertEquals(Priority.URGENT, capturedTask.priority());  
        IndexNameExpressionResolver resolver = mock(IndexNameExpressionResolver.class);
        Metadata meta = Metadata.builder().put(dfaHotMeta, false).build();
            .put(INDEX_TIERING_STATE.getKey(), "HOT")  
            .numberOfReplicas(1)  
    }  
        Metadata metadata = mock(Metadata.class);  
            super(  
            .put(INDEX_TIERING_STATE.getKey(), HOT_TO_WARM.toString())
        tieringService.tieringIndices.add(testIndex);
        );  
            Settings.EMPTY,
            .build();
        clusterService = mock(ClusterService.class);
     * A test tiering service that mimics WarmToHotTieringService behavior.
        ShardRouting shard = mock(ShardRouting.class);
        tieringCustomData.put("test_tiering_start_time", "1234567");
            .put(INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.HOT.toString())  
        verify(metadataBuilder).put(captor.capture());
        RoutingTable rt = RoutingTable.builder().addAsNew(meta.index(dfaIndexName)).build();
    public void testTier_FailsOnResolveException() {
        when(resolver.concreteIndices(any(), any(), eq("test-index"))).thenReturn(new Index[] { testIndex });
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 2)
        CancelTieringRequest request = new CancelTieringRequest("bad-index");
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        // Routing table and metadata must NOT have updateNumberOfReplicas called
            .put(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), true)
        when(nodes.get("node1")).thenReturn(node);
            "INDEX_WRITE_BLOCK must be absent from ClusterBlocks after execute()",  
            nodeEnvironment,
        Settings tieringStartSettings = warmToHotService.getTieringStartSettingsToAdd(buildDfaIndexMetadata("w2h-check-idx", "w2h-uuid"));  
        when(clusterState.getNodes()).thenReturn(nodes);
            clusterService,
            AllocationService allocationService,  
        when(clusterState.metadata()).thenReturn(metadata);
            Settings.EMPTY,
import org.opensearch.cluster.routing.RoutingTable;  
        ClusterState result = capturedTask.execute(realState);  
        }  
        Metadata metadata = Metadata.builder().put(tieringMeta, false).build();  
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)  
        when(clusterState.metadata()).thenReturn(metadata);
    public void testTier_DfaIndex_HotToWarm_DoesNotModifyClusterBlocks() throws Exception {  
        assertFalse(
        task.onFailure("test_source", thrown);
     * on hot nodes (writable engine). Lifting it immediately would cause write errors on warm-engine shards.  
            .numberOfShards(1)  
    }
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
            allocationSvc,
        assertTrue("Index should not be in tieringIndices", spyService.tieringIndices.isEmpty());  
            resultState.blocks().hasIndexBlock(dfaIndexName, IndexMetadata.INDEX_WRITE_BLOCK)
        when(shard.started()).thenReturn(true);
            routingTableBuilder,  
        RoutingTable rt = RoutingTable.builder().addAsNew(meta.index(dfaIndexName)).build();
            .put(INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.HOT.toString())
            .metadata(metadata)  
    public void testUpdateClusterStateTask_OnFailure() {
        Metadata meta = Metadata.builder().put(dfaHotMeta, false).build();
        return event;
            mock(AllocationService.class),  
        verify(clusterService).submitStateUpdateTask(anyString(), taskCaptor.capture());  
        when(clusterState.getNodes()).thenReturn(mock(DiscoveryNodes.class));
        ClusterBlocks blocks = ClusterBlocks.builder().addIndexBlock(dfaIndexName, IndexMetadata.INDEX_WRITE_BLOCK).build();
     * <p>This is the canonical scenario after H2W cancel with auto_expand_replicas: the primary  
     * isMigrationInProgress returns false for terminal states, so the fallback does not apply.
        assertFalse("Precondition: index must not be tracked in memory", tieringService.isIndexBeingTiered(testIndex));
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)  
        Settings idxSettings = Settings.builder()
            mock(ClusterInfoService.class),
        when(clusterState.routingTable()).thenReturn(routingTable);
            () -> tieringService.validateTieringCancelRequest(testIndex, warmIndexMetadata, clusterState)  
        Metadata scanMeta = Metadata.builder().put(dfaHotMetaWithBlock, false).build();
        when(hotNode.isWarmNode()).thenReturn(false);  
            nodeEnvironment,  
            .put(FileCacheSettings.DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING.getKey(), 5.0)
        DiscoveryNode hotNode = mock(DiscoveryNode.class);
        @Override
            .settings(idxSettings)
    }
        when(allocationSvc.reroute(any(ClusterState.class), anyString())).thenAnswer(inv -> inv.getArgument(0));
        Metadata metadata = mock(Metadata.class);
        capturedTask.clusterStateProcessed("test_source", realState, realState);  
        when(clusterState.routingTable()).thenReturn(routingTable);
        TestTieringService service = new TestTieringService(
        Metadata meta = Metadata.builder().put(dfaTieringMeta, false).build();  
        // Execute the task to cover the execute() method  
        ArgumentCaptor<ClusterStateUpdateTask> taskCaptor = ArgumentCaptor.forClass(ClusterStateUpdateTask.class);  
        when(routingTable.hasIndex(testIndex)).thenReturn(true);
        Metadata realMetadata = Metadata.builder().put(indexMetadata, false).build();
        @Override
        Settings dfaHotSettings = Settings.builder()
            "false",  
            .routingTable(routingTable)
            clusterService,
        // tier() does NOT add write blocks for H2W DFA — that's TransportHotToWarmTierAction's responsibility.
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
     * The write blocks are added by TransportHotToWarmTierAction.addReadOnlyBlockAndPrepare()  
            Set<Index> tieringEntries,
        ArgumentCaptor<ClusterStateUpdateTask> taskCaptor = ArgumentCaptor.forClass(ClusterStateUpdateTask.class);
            .build();
        when(resolver.concreteIndices(any(), any(), eq("test-index"))).thenReturn(new Index[] { testIndex });
        when(routingTable.allShards(testIndex.getName())).thenReturn(Collections.singletonList(shard));  
        assertFalse(
            clusterService,  
        Metadata.Builder metadataBuilder = mock(Metadata.Builder.class);
        when(clusterService.state()).thenReturn(state);
        CancelTieringRequest request = new CancelTieringRequest("test-index");  
    }  
        // non-DFA index: PLUGGABLE_DATAFORMAT_ENABLED_SETTING = false (default)  
     * We must not block write-block removal waiting for those replicas.
        when(event.routingTableChanged()).thenReturn(true);
            mock(ClusterInfoService.class),  
        );  
            .build();  
            .build();  
        protected String getTieringStartTimeKey() {
        }
     *  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
            resultState.blocks().hasIndexBlock(dfaIndexName, IndexMetadata.INDEX_WRITE_BLOCK)
        IndexNameExpressionResolver resolver = mock(IndexNameExpressionResolver.class);
            .put(INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.HOT.toString())
        verify(clusterService, never()).submitStateUpdateTask(org.mockito.Mockito.contains("remove-write-block"), any());
        }
        IndexTieringRequest request = new IndexTieringRequest("WARM", dfaIndexName);
            .validateTieringRequest(any(), any(), any(), any(), any(), any());
            String indexName,
            clusterService,
}
        when(currentState.metadata()).thenReturn(metadata);
        @Override
            nodeEnvironment,
    public void testUpdateIndexMetadataPostTiering_UpdatesCorrectly() {
        service.tieringIndices.add(testIndex);  
            .put(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), true)
import org.opensearch.common.util.io.IOUtils;  
            "INDEX_WRITE_BLOCK must NOT be added for non-DFA index",  
        assertEquals("test-index", statuses.get(0).getIndexName());
import org.opensearch.cluster.node.DiscoveryNodes;
        IndexMetadata updatedMetadata = captor.getValue().build();
        @Override
    }
        IndexMetadata dfaMeta = buildDfaIndexMetadata(dfaIndexName, dfaUuid);
            return blocksBuilder;
            mock(AllocationService.class),
            .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
        service.tier(request, listener, initialState);
            shardLimitValidator  
        tieringService.processTieringInProgress(clusterState, "test_source");
        when(mockScanState.blocks()).thenReturn(blocksWithBlock);
    }  
            .settings(warmSettings)  
    /**
    private class TestWarmToHotTieringService extends TieringService {
            .settings(dfaHotSettings)
    // The method is private and triggered via clusterChanged() when
        ArgumentCaptor<ClusterStateUpdateTask> taskCaptor = ArgumentCaptor.forClass(ClusterStateUpdateTask.class);  
        ClusterState result = taskCaptor.getValue().execute(realState);
            .put(INDEX_TIERING_STATE.getKey(), "HOT")
        ArgumentCaptor<ClusterStateUpdateTask> taskCaptor = ArgumentCaptor.forClass(ClusterStateUpdateTask.class);  
    public void testReconstructInProgressTieringRequests_HandlesException() {  
        assertNotEquals("true", result.metadata().index(dfaIndexName).getSettings().get(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey()));
        when(shard.currentNodeId()).thenReturn("node1");  
            clusterService,
        when(node.isWarmNode()).thenReturn(true);
        when(badMetadata.getSettings()).thenThrow(new RuntimeException("simulated error"));
        // was in the original index metadata (null if never explicitly set).  
     * via the isMigrationInProgress fallback.  
        }
        // execute() with deleted-index state must not throw
            .numberOfShards(1)
        tieringService.tieringIndices.add(testIndex);
            resolver,
            "true",
            clusterService,
     */
            Settings.EMPTY,
        IndexMetadata tieringIndexMetadata = IndexMetadata.builder("tiering-index")
import org.opensearch.common.settings.Settings;
            allocationSvc,
        tieringService.processTieringInProgress(clusterState, "test_source");
        // overrides this with "0-{max(1, currentReplicas)}" for the tiering start phase,
        verify(clusterService, never()).submitStateUpdateTask(org.mockito.Mockito.contains("remove-write-block"), any());
            tieringService.getTargetTieringState().toString(),  
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)
            return "test_tiering_start_time";  
        IndexMetadata dfaHotMeta = IndexMetadata.builder(dfaIndexName)
        Settings idxSettings = Settings.builder()
        // Verify number_of_replicas=1 is set atomically in both metadata and routing table
            updatedMeta.getSettings().get(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey())
import org.opensearch.index.IndexSettings;
        when(shard.currentNodeId()).thenReturn("hot1");
        );  
        // Build warm DFA index metadata WITH write blocks set (it was warm, writes blocked)
        ClusterState state = mock(ClusterState.class);
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
import org.opensearch.core.index.Index;
import org.opensearch.cluster.metadata.Metadata;  
        );  
        when(badMetadata.getSettings()).thenThrow(new RuntimeException("simulated"));  
            IllegalArgumentException.class,  
        ClusterState resultState = taskCaptor.getValue().execute(stateWithBlocks);
                indexNameExpressionResolver,
        IndexNameExpressionResolver resolver = mock(IndexNameExpressionResolver.class);
        AllocationService allocationSvc = mock(AllocationService.class);
            .metadata(realMetadata)
            .routingTable(rt)
        protected Settings getIndexTierSettingsToRestoreAfterCancellation(IndexMetadata indexMetadata) {  
            .put(INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.WARM.toString())
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
    }  
            .settings(dfaHotSettingsNoBlock)  
        DiscoveryNode hotNode = mock(DiscoveryNode.class);
        Metadata meta = Metadata.builder().put(dfaHotMeta, false).build();
    }
import org.opensearch.cluster.service.ClusterService;
        IndexMetadata updatedMetadata = captor.getValue().build();  
        verify(clusterService, never()).submitStateUpdateTask(org.mockito.Mockito.contains("remove-write-block"), any());  
            "true",  
        super.tearDown();  
            mock(ClusterInfoService.class),
            shardLimitValidator  
        protected IndexModule.TieringState getTargetTieringState() {  
        Index dfaIndex = new Index(dfaIndexName, dfaUuid);
        RoutingTable rtMock = mock(RoutingTable.class);
        TestTieringService service = new TestTieringService(
    public void testRemoveWriteBlock_Execute_NullGuard_IndexDeletedBetweenScanAndTask() throws Exception {
        when(nodes.get("node1")).thenReturn(node);
        when(nodes.get("node1")).thenReturn(node);  
        String dfaIndexName = "dfa-cancel-index";  
     */
        verify(listener).onFailure(any(IllegalArgumentException.class));
    }
        assertNull(  
    public void testUpdateIndexMetadataForTieringStart_ThrowsOnError() {
        }  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            mock(AllocationService.class),
        verify(listener).onResponse(any(ClusterStateUpdateResponse.class));
        verify(metadataBuilder).updateNumberOfReplicas(eq(1), any(String[].class));
            .build();  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
            Settings.EMPTY,
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        );
        Setting.Property.Dynamic,
        verify(clusterService).submitStateUpdateTask(anyString(), taskCaptor.capture());
        when(clusterState.getNodes()).thenReturn(nodes);  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        verify(clusterService).submitStateUpdateTask(anyString(), taskCaptor.capture());  
    }
        RoutingTable.Builder routingTableBuilder = mock(RoutingTable.Builder.class);
            clusterService,
        // INDEX_BLOCKS_WRITE must remain null/false (was never set by the task)  
     */
            mock(AllocationService.class),
    public void testValidateTieringCancelRequest_IndexDeleted() {
            .build();
import org.opensearch.cluster.block.ClusterBlocks;  
        when(clusterState.metadata()).thenReturn(metadata);
        IndexNameExpressionResolver resolver = mock(IndexNameExpressionResolver.class);
        when(resolver.concreteIndices(any(), any(), eq("test-index"))).thenReturn(new Index[] { testIndex });
        );
        when(resolver.concreteIndices(any(), any(), eq("test-index"))).thenReturn(new Index[] { testIndex });  
import org.opensearch.cluster.routing.allocation.AllocationService;
        ) {}
import org.opensearch.index.store.remote.filecache.FileCacheSettings;  
        TestTieringService service = new TestTieringService(
        assertNotEquals(
        tieringService.tieringIndices.add(testIndex);  
            clusterService,  
        service.tieringIndices.add(testIndex);
        );
            .build();
            "INDEX_WRITE_BLOCK must NOT be added for non-DFA index",
        when(nodes.get("hot1")).thenReturn(hotNode);  
            result.blocks().hasIndexBlock(dfaIndexName, IndexMetadata.INDEX_WRITE_BLOCK)
        tieringService.tieringIndices.add(testIndex);
        );
        String dfaUuid = "dfa-w2h-uuid";
            mock(IndexNameExpressionResolver.class),
        IndexMetadata tieringMeta = IndexMetadata.builder("test-index")  
        assertFalse("Precondition: index must not be tracked in memory", tieringService.isIndexBeingTiered(testIndex));  
            resolver,
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
        IndexMetadata updatedMetadata = captor.getValue().build();  
        when(mockScanState.getNodes()).thenReturn(nodes);
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
            .metadata(meta)  
            return IndexModule.TieringState.WARM;
    /**
        verify(metadataBuilder).updateNumberOfReplicas(eq(1), any(String[].class));
        verify(clusterService).submitStateUpdateTask(anyString(), taskCaptor.capture());
    public void setUp() throws Exception {  
            mock(ClusterInfoService.class),
            .numberOfReplicas(0)
        RoutingTable.Builder routingTableBuilder = mock(RoutingTable.Builder.class);
            Settings.EMPTY,
            nodeEnvironment,
        IndexMetadata warmIndexMetadata = IndexMetadata.builder("test-index")
    }
import org.opensearch.OpenSearchException;
 * this file be licensed under the Apache-2.0 license or a
        );
    }
        assertNotEquals(  
            .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
            .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
        when(shard.unassigned()).thenReturn(false);
        );
            String indexName,
        assertFalse("Index should be removed after cancel", service.tieringIndices.contains(testIndex));
        when(clusterState.routingTable()).thenReturn(rtMock);
        when(clusterState.routingTable()).thenReturn(routingTable);  
            .build();
            mock(ClusterInfoService.class),
        // updateIndexMetadataPostTiering only updates INDEX_TIERING_STATE and removes tiering custom data.
        // Build index with 1 replica (already at target)  
        AllocationService allocationSvc = mock(AllocationService.class);  
     * Shards are still relocating (not all started on hot) — no task submitted, block kept.
        protected Settings getIndexTierSettingsToRestoreAfterCancellation(IndexMetadata indexMetadata) {  
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), true)
import org.opensearch.index.IndexModule;
        // Scan state has the block (triggers task submission)
     * INDEX_WRITE_BLOCK and INDEX_WRITE_BLOCK from ClusterBlocks AND
        DiscoveryNode node = mock(DiscoveryNode.class);
            return blocksBuilder.removeIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK)
        );
     * <p>This is the negative complement of the unassigned-replica case: we must NOT lift
        ClusterState result = taskCaptor.getValue().execute(executeState);
        tieringService.updateIndexMetadataForTieringStart(
                .build();
            Integer maxConcurrentTieringRequests,
        // allOnHot=true (primary on hot + replica unassigned-non-primary) → task must be submitted
            .settings(nonDfaSettings)
        // Trigger via clusterChanged
        when(metadata.index(testIndex)).thenReturn(indexMetadata);
    public void testListTieringStatus_WithTieringIndex() {
        Settings dfaHotSettings = Settings.builder()  
            .put(IndexMetadata.SETTING_INDEX_UUID, dfaUuid)
        when(shard.unassigned()).thenReturn(false);
        );  
        ClusterState previousState = mock(ClusterState.class);
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)
            clusterService,
        DiscoveryNodes previousNodes = mock(DiscoveryNodes.class);  
            resolver,  
     * snaps back to hot quickly but one replica may remain unassigned until a node becomes available.
        IndexMetadata dfaHotMeta = IndexMetadata.builder(dfaIndexName)
            "INDEX_WRITE_BLOCK must be REMOVED from ClusterBlocks after W2H tier start for DFA index",
import org.opensearch.cluster.ack.ClusterStateUpdateResponse;
        // the write block is kept during cancel and removed later by removeWriteBlockForCancelledDfaIndices().  
     * (so reconstruction is skipped and only the cleanup path runs).
            .put(INDEX_TIERING_STATE.getKey(), "HOT")
        assertFalse("Index should be removed from tieringIndices", tieringService.tieringIndices.contains(testIndex));  
            Settings.EMPTY,
        Index dfaIndex = new Index(dfaIndexName, dfaUuid);  
        ClusterState previousState = mock(ClusterState.class);
     * (write block already removed by another task) — execute() must skip and produce no change.  
        // Build a real cluster state so execute() works  
     */
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        TestTieringService service = new TestTieringService(
        // No exception means reconstruction was called successfully
        assertNotNull("execute() must return a non-null state even when index was deleted", result);
            .routingTable(rt)
            .numberOfShards(1)  
            .put(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), true)
        ClusterState clusterState = mock(ClusterState.class);
            .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
        }
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            "blocks.write must be false in IndexMetadata settings after W2H tier start for DFA index",
        RoutingTable rt = RoutingTable.builder().addAsNew(meta.index(dfaIndexName)).build();  
        when(event.blocksChanged()).thenReturn(false);  
        protected void validateTieringRequest(
            .build();
            .numberOfReplicas(0)
        );  
        IndexMetadata dfaHotMeta = IndexMetadata.builder(dfaIndexName)
            .numberOfShards(1)
            // PLUGGABLE_DATAFORMAT_ENABLED_SETTING not set → defaults to false
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .build();  
            .build();  
            );  
        Metadata.Builder metadataBuilder = mock(Metadata.Builder.class);  
        ) {  
        protected IndexModule.TieringState getTieringType() {
            .blocks(blocksWithWriteBlock)  
    }
import static org.mockito.Mockito.anyString;  
    private ClusterService clusterService;
            IndexMetadata indexMetadata  
        service.cancelTiering(request, listener, clusterState);  
        service.clusterChanged(event);
            allocationSvc,
            .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
        when(state.getMetadata()).thenReturn(metadata);  
        verify(clusterService).submitStateUpdateTask(anyString(), taskCaptor.capture());
            .put(IndexMetadata.SETTING_INDEX_UUID, dfaUuid)
        TestTieringService service = new TestTieringService(
        Settings defaultSettings = Settings.builder()  
        Settings dfaHotSettings = Settings.builder()
            ClusterState clusterState,
    public void testReconstructInProgressTieringRequests() {
        ClusterChangedEvent event = buildRoutingTableChangedEvent(clusterState);
        when(clusterState.metadata()).thenReturn(meta);  
        ClusterState resultState = taskCaptor.getValue().execute(initialState);  
        java.util.HashMap<String, String> tieringCustomData = new java.util.HashMap<>();  
    public void testGetTieringStatus_IndexNotBeingTiered() {
    public void testCancelTiering_SubmitsClusterStateTask() {  
            Settings settings,
        tieringService.validateTieringCancelRequest(testIndex, w2hMetadata, clusterState);
        IndexTieringRequest request = new IndexTieringRequest("WARM", "bad-index");
        IndexNameExpressionResolver resolver = mock(IndexNameExpressionResolver.class);  
        // execute() should return currentState unchanged  
        IndexMetadata dfaWarmMeta = IndexMetadata.builder(dfaIndexName)
        assertNotNull(capturedTask.timeout());
        RoutingTable routingTable = mock(RoutingTable.class);  
        Index dfaIndex = new Index(dfaIndexName, dfaUuid);  
        when(clusterState.metadata()).thenReturn(metadata);
        );
            .settings(dfaTieringSettings)
        verify(clusterService).submitStateUpdateTask(anyString(), taskCaptor.capture());
        Metadata metadata = mock(Metadata.class);  
        );  
import static org.mockito.Mockito.spy;
                allocationService,
        AllocationService allocationSvc = mock(AllocationService.class);
        when(event.previousState()).thenReturn(previousState);
        }
        when(routingTable.allShards(testIndex.getName())).thenReturn(Collections.singletonList(shard));  
        // Pass a DFA index metadata so the W2H subclass returns its full settings
        when(mockScanState.metadata()).thenReturn(scanMeta);
     * entirely by TransportHotToWarmTierAction.
            nodeEnvironment,
        );  
            clusterService,  
        verify(listener).onFailure(any(RuntimeException.class));
            Integer maxConcurrentTieringRequests,
        when(clusterState.getNodes()).thenReturn(nodes);
            updatedMeta.getSettings().get(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey())  
        ShardRouting shard = mock(ShardRouting.class);
        expectThrows(IllegalArgumentException.class, () -> service.getTieringStatus("test-index", false));
            clusterService,
        when(clusterState.metadata()).thenReturn(metadata);
        when(resolver.concreteIndices(any(), any(), eq(dfaIndexName))).thenReturn(new Index[] { dfaIndex });
        when(mockState.getNodes()).thenReturn(nodes);
        // Verify that WarmToHotTieringService's getTieringStartSettingsToAdd includes  
            Settings.EMPTY,
            mock(ClusterInfoService.class),
     * Test: Non-DFA index should NOT have write blocks added to ClusterBlocks during tiering.
        Setting.Property.NodeScope  
            clusterService,  
     * (primary IS a primary), and {@code s.started()} is also false.
     * This test verifies that tier() completes successfully for DFA H2W without touching ClusterBlocks.
            .routingTable(rt)
        Metadata metadata = mock(Metadata.class);
            clusterService,
        ArgumentCaptor<ClusterStateUpdateTask> taskCaptor = ArgumentCaptor.forClass(ClusterStateUpdateTask.class);  
        return IndexMetadata.builder(indexName).settings(dfaSettings).numberOfShards(1).numberOfReplicas(1).build();  
    }
        when(currentState.routingTable()).thenReturn(routingTable);
            .put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true)  
        );
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
            .put(IndexMetadata.SETTING_INDEX_UUID, uuid)
        TestTieringService service = new TestTieringService(
        when(badMetadata.getSettings()).thenThrow(new RuntimeException("simulated"));
        when(metadata.iterator()).thenReturn(Collections.emptyIterator());
            shardLimitValidator
import org.opensearch.Version;
            "false",  
        assertEquals(1, tieringService.tieringIndices.size());  
        warmToHotService.updateIndexMetadataForTieringStart(metadataBuilder, routingTableBuilder, indexMetadata, testIndex);
            .build();
                nodeEnvironment,  
        ActionListener<ClusterStateUpdateResponse> listener = mock(ActionListener.class);
            mock(IndexNameExpressionResolver.class),
        ClusterChangedEvent event = buildRoutingTableChangedEvent(clusterState);  
     * (actively tiering) — must be skipped.  
            .settings(tieringSettings)
    }
            shardLimitValidator
            mock(AllocationService.class),
        when(shard.unassigned()).thenReturn(false);  
            return Settings.builder()
     */
        ActionListener<ClusterStateUpdateResponse> listener = mock(ActionListener.class);  
        ArgumentCaptor<ClusterStateUpdateTask> taskCaptor = ArgumentCaptor.forClass(ClusterStateUpdateTask.class);  
     */
        assertTrue("Index should remain in tieringIndices", tieringService.tieringIndices.contains(testIndex));
        IndexMetadata updatedMetadata = captor.getValue().build();
    }
        DiscoveryNode node = mock(DiscoveryNode.class);
        when(currentState.metadata()).thenReturn(metadata);  
            "Warm-to-hot tiering start should set blocks.write to false",
        // Shard on warm node → in target tier
        String dfaUuid = "dfa-unassigned-replica-uuid";  
     * Test: tier() for a DFA index hot→warm does NOT add write blocks to ClusterBlocks.
            return "w2h_tiering_start_time";  
        Index idx = new Index(indexName, uuid);  
        IndexMetadata updatedMetadata = captor.getValue().build();
        // index is NOT in tieringIndices (cancel completed)
        java.util.HashMap<String, String> tieringCustomData = new java.util.HashMap<>();
        IndexMetadata idxMeta = IndexMetadata.builder("test-index")  
        RoutingTable routingTable = mock(RoutingTable.class);  
                mock(ClusterInfoService.class),
        ClusterStateUpdateTask task = taskCaptor.getValue();
        ClusterBlocks blocksWithBlock = ClusterBlocks.builder().addIndexBlock(dfaIndexName, IndexMetadata.INDEX_WRITE_BLOCK).build();  
        // Build index metadata with tiering custom data  
        when(shard.unassigned()).thenReturn(false);  
            shardLimitValidator
            mock(ClusterInfoService.class),  
        protected Settings getTieringStartSettingsToAdd(IndexMetadata indexMetadata) {
import org.opensearch.cluster.ClusterStateUpdateTask;
            clusterService,  
        ShardRouting shard = mock(ShardRouting.class);
        task.onFailure("cancel_source", new RuntimeException("simulated"));
    private class TestTieringService extends TieringService {  
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)  
        ClusterState clusterState = mock(ClusterState.class);  
        when(nodes.get("hot1")).thenReturn(hotNode);
        ArgumentCaptor<ClusterStateUpdateTask> taskCaptor = ArgumentCaptor.forClass(ClusterStateUpdateTask.class);
        ArgumentCaptor<ClusterStateUpdateTask> taskCaptor = ArgumentCaptor.forClass(ClusterStateUpdateTask.class);
     * Failover case: the in-memory tiering set was lost (e.g., cluster-manager change), but the
        TestTieringService service = new TestTieringService(  
    public void testCancelTiering_DfaIndex_KeepsWriteBlocksDuringCancel() throws Exception {
                settings,
        // Verify ClusterBlocks: write block must be KEPT (deferred to removeWriteBlockForCancelledDfaIndices)  
        when(metadata.index(testIndex)).thenReturn(null);
        // removeWriteBlockForCancelledDfaIndices iterates over all index metadata;
        RoutingTable routingTable = mock(RoutingTable.class);
        List<ShardRouting> shardRoutings = Collections.singletonList(shard);
        clusterState = mock(ClusterState.class);  
import org.junit.Before;
            .build();  
        when(clusterState.routingTable()).thenReturn(rtMock);
            mock(AllocationService.class),
        ) {
            shardLimitValidator  
import java.util.List;
            .put(INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.HOT_TO_WARM.toString())
            nodeEnvironment,
            org.mockito.Mockito.contains("remove-write-block"),
import static org.opensearch.common.settings.ClusterSettings.BUILT_IN_CLUSTER_SETTINGS;  
        }  
        @Override
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING;
        when(allocationSvc.reroute(any(ClusterState.class), anyString())).thenAnswer(inv -> inv.getArgument(0));
        when(shard.started()).thenReturn(true);
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
        service.clusterChanged(event);
    public void testRemoveWriteBlock_NonDfaIndex_Skipped() {  
            Settings.EMPTY,
        when(currentState.getNodes()).thenReturn(nodes);  
import org.opensearch.cluster.ClusterChangedEvent;  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        Metadata meta = Metadata.builder().put(dfaHotMeta, false).build();
        // Shard is initializing (not started) — relocation not complete  
            nodeEnvironment,
        when(nodes.get("node1")).thenReturn(node);
            .put(INDEX_TIERING_STATE.getKey(), HOT_TO_WARM.toString())
        tieringService.reconstructInProgressTieringRequests(clusterState, HOT_TO_WARM, "test_source");
        assertSame(clusterState, result);
        ClusterState result = capturedTask.execute(realState);
        when(shard.unassigned()).thenReturn(false);
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)  
            .addIndexBlock(dfaIndexName, IndexMetadata.INDEX_WRITE_BLOCK)  
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
        service.tieringIndices.add(dfaIndex);
            .build();
    }
            .put(INDEX_TIERING_STATE.getKey(), HOT_TO_WARM.toString())  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
            .build();
        ClusterChangedEvent event = buildRoutingTableChangedEvent(mockScanState);  
        when(clusterService.getClusterSettings()).thenReturn(mockSettings);
        when(clusterState.metadata()).thenReturn(meta);
        ClusterBlocks blocksWithBlock = ClusterBlocks.builder().addIndexBlock(dfaIndexName, IndexMetadata.INDEX_WRITE_BLOCK).build();  
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)
        when(clusterState.routingTable()).thenReturn(routingTable);  
     * Builds a DFA (pluggable dataformat enabled) IndexMetadata for block tests.  
        when(clusterState.routingTable()).thenReturn(routingTable);  
            .put(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), true)
            .build();
        );
        when(metadataBuilder.put(any(IndexMetadata.Builder.class))).thenReturn(metadataBuilder);
    }
     * and sets INDEX_BLOCKS_WRITE=false in IndexMetadata settings.  
            resolver,
        when(shard.started()).thenReturn(false);
        );
            .numberOfReplicas(0)
        when(shard.currentNodeId()).thenReturn("hot1");
import org.opensearch.env.NodeEnvironment;  
    public void testWarmToHotTieringStart_DisablesAutoExpandReplicas() {
        verify(clusterService, never()).submitStateUpdateTask(org.mockito.Mockito.contains("remove-write-block"), any());  
        }  
            nodeEnvironment,  
        protected Setting<Integer> getMaxConcurrentTieringRequestsSetting() {
        IndexMetadata warmMetadata = IndexMetadata.builder("test-index")
        when(routingTable.hasIndex(testIndex)).thenReturn(true);
        ClusterStateUpdateTask capturedTask = taskCaptor.getValue();  
        when(shard.started()).thenReturn(true);
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)  
            .build();
            Settings.EMPTY,  
        when(event.localNodeClusterManager()).thenReturn(true);
            mock(AllocationService.class),
            .settings(dfaHotSettingsWithBlock)
            nodeEnvironment,
            .put(INDEX_TIERING_STATE.getKey(), "HOT")
        IndexNameExpressionResolver resolver = mock(IndexNameExpressionResolver.class);
    private ClusterChangedEvent buildRoutingTableChangedEvent(ClusterState currentState) {  
        IndexMetadata dfaHotMeta = IndexMetadata.builder(dfaIndexName)
        assertNull("Tiering custom metadata should be removed", updatedMetadata.getCustomData(TIERING_CUSTOM_KEY));
        assertNotNull(task.timeout());
     */
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)  
    }  
            mock(ClusterInfoService.class),  
        @Override  
        // s.unassigned() && !s.primary() → false (it IS the primary)
     * Therefore {@code allOnHot=false} and no write-block removal task must be submitted.  
    public void testClusterChanged_NewClusterManager_ReconstructsRequests() {
        when(metadata.index(testIndex)).thenReturn(indexMetadata);
     * DFA index in HOT state but write block already removed — no task submitted.
        // Confirm number_of_replicas is set to 1 in metadata settings
    private TestTieringService tieringService;  
            Settings.EMPTY,
        // Non-DFA index should NOT have write blocks added  
        @Override
            clusterService,  
        IndexNameExpressionResolver resolver = mock(IndexNameExpressionResolver.class);  
            resultState.blocks().hasIndexBlock("non-dfa-index", IndexMetadata.INDEX_WRITE_BLOCK)  
        String dfaIndexName = "dfa-index";
        Metadata meta = Metadata.builder().put(nonDfaMeta, false).build();
        when(mockState.routingTable()).thenReturn(rtMock);
        assertFalse(
        when(state.getMetadata()).thenReturn(metadata);
            .put(IndexMetadata.SETTING_INDEX_UUID, uuid)
        // Pre-add index so execute() hits the early return
            resultState.blocks().hasIndexBlock(dfaIndexName, IndexMetadata.INDEX_WRITE_BLOCK)
                mock(AllocationService.class),
        when(event.previousState()).thenReturn(previousState);  
        ClusterBlocks blocks = ClusterBlocks.builder().addIndexBlock(dfaIndexName, IndexMetadata.INDEX_WRITE_BLOCK).build();  
        tieringService.processTieringInProgress(clusterState, "test_source");
            .numberOfReplicas(1)
        ) {}
import org.mockito.ArgumentCaptor;  
        AllocationService allocationSvc = mock(AllocationService.class);
        TestTieringService service = new TestTieringService(  
        when(shard.currentNodeId()).thenReturn("node1");
        assertNotNull(result);
        when(event.previousState()).thenReturn(previousState);
    }
        Metadata.Builder metadataBuilder = mock(Metadata.Builder.class);
        TestTieringService service = new TestTieringService(
        expectThrows(
            .putCustom(TIERING_CUSTOM_KEY, tieringCustomData)
                nodeEnvironment,
            clusterService,
            .numberOfReplicas(1)
     * Boundary: a terminal WARM index that is NOT tracked in memory must still be rejected —  
        service.clusterChanged(event);  
        // Execute the captured task against a real cluster state that still has the block
            .put(IndexMetadata.SETTING_INDEX_UUID, dfaUuid)
    private Index testIndex;  
import org.opensearch.cluster.ClusterName;
    public void testClusterChanged_NotClusterManager_DoesNothing() {
            .build();
        when(allocationSvc.reroute(any(ClusterState.class), anyString())).thenAnswer(inv -> inv.getArgument(0));  
            mock(ClusterInfoService.class),  
        // getIndexTierClusterBlocksToRestoreAfterCancellation intentionally uses the base class no-op:
    /**
        ArgumentCaptor<ClusterStateUpdateTask> taskCaptor = ArgumentCaptor.forClass(ClusterStateUpdateTask.class);  
    );
                nodeEnvironment,
            .settings(dfaHotSettings)
        String dfaIndexName = "dfa-unassigned-primary";  
        ShardRouting shard = mock(ShardRouting.class);
            .numberOfShards(1)  
                clusterInfoService,  
     * Primary shard itself is unassigned — {@code s.unassigned() && !s.primary()} is false
import org.opensearch.core.action.ActionListener;
            .build();
        when(shard.started()).thenReturn(true);  
            Set<Index> tieringEntries,
            () -> tieringService.validateTieringCancelRequest(testIndex, indexMetadata, clusterState)  
 * The OpenSearch Contributors require contributions made to  
    /**
                settings,
    }  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        IndexNameExpressionResolver resolver = mock(IndexNameExpressionResolver.class);
        );  
        IndexNameExpressionResolver resolver = mock(IndexNameExpressionResolver.class);  
    @Before
        when(mockScanState.metadata()).thenReturn(scanMeta);
        Metadata metadata = mock(Metadata.class);
        @Override
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    }  
            mock(IndexNameExpressionResolver.class),
        tieringService.updateIndexMetadataPostTiering(metadataBuilder, indexMetadata);  
            .settings(dfaHotSettings)
            .numberOfReplicas(1)
import org.opensearch.common.settings.ClusterSettings;  
    /**
            .put(IndexMetadata.SETTING_INDEX_UUID, dfaUuid)
        AllocationService allocationSvc = mock(AllocationService.class);
        TestTieringService spyService = spy(
        ClusterState stateWithBlocks = ClusterState.builder(ClusterName.DEFAULT)  
        ActionListener<ClusterStateUpdateResponse> listener = mock(ActionListener.class);
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
            mock(ClusterInfoService.class),
        when(rtMock.allShards(dfaIndexName)).thenReturn(Collections.singletonList(shard));
            .metadata(meta)
                clusterService,  
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "200b")  
        when(shard.started()).thenReturn(true);
        when(routingTable.allShards(testIndex.getName())).thenReturn(Collections.singletonList(shard));  
            .build();
        when(clusterState.metadata()).thenReturn(meta);  
        ClusterState executeState = ClusterState.builder(org.opensearch.cluster.ClusterName.DEFAULT)
        ClusterState warmState = ClusterState.builder(ClusterName.DEFAULT)
        // Build cluster state: shard started on a hot node
        );
        // Shard is on a hot node, target is WARM → not in target tier
            .build();
        verify(routingTableBuilder, never()).updateNumberOfReplicas(anyInt(), any(String[].class));
        service.tieringIndices.add(testIndex);
    }  
            nodeEnvironment,
        ClusterState initialState = ClusterState.builder(ClusterName.DEFAULT)
            .numberOfReplicas(1)
        // Replica shard: unassigned and NOT primary — satisfies s.unassigned() && !s.primary()
        );
        Index dfaIndex = new Index(dfaIndexName, dfaUuid);
            nodeEnvironment,  
            mock(ClusterInfoService.class),  
        );  
        assertNull("Tiering custom metadata should be removed", updatedMetadata.getCustomData(TIERING_CUSTOM_KEY));
        String dfaIndexName = "dfa-relocating";
import static org.mockito.Mockito.anyInt;
        }  
        task.clusterStateProcessed("cancel_source", clusterState, clusterState);  
    @Override  
        Metadata meta = Metadata.builder().put(dfaHotMeta, false).build();
        // but the setting is correctly applied in the final tiering completion step.  
    Setting<Integer> maxConcurrentTieringRequestsSetting = Setting.intSetting(  
     * KEEP the INDEX_WRITE_BLOCK in ClusterBlocks and KEEP blocks.write=true in IndexMetadata settings.
        String indexName = "non-dfa-hot";
            .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)  
        super.setUp();
    }  
        when(previousNodes.isLocalNodeElectedClusterManager()).thenReturn(false);
            result.blocks().hasIndexBlock(dfaIndexName, IndexMetadata.INDEX_WRITE_BLOCK)
     */
    public void testRemoveWriteBlock_UnassignedPrimary_DoesNotSubmitTask() {
        verify(metadataBuilder).put(captor.capture());
        when(primaryShard.started()).thenReturn(false);
        0,  
            .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
            .put(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), true)
        when(rtMock.hasIndex(dfaIndex)).thenReturn(true);  
            .put(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), true)
        Metadata meta = Metadata.builder().put(dfaHotMeta, false).build();
        // No task submitted — shards not yet all on hot  
            .numberOfShards(1)
            nodeEnvironment,
        // Verify ClusterBlocks: write blocks must be REMOVED (index becomes writable on hot tier)
        ShardRouting shard = mock(ShardRouting.class);
        verify(metadataBuilder).updateNumberOfReplicas(eq(1), any(String[].class));
     * isDfaIndex() checks IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING = true.
            resolver,
        Index nonDfaIndex = new Index("non-dfa-index", "non-dfa-uuid");
        tieringService.updateIndexMetadataPostTiering(metadataBuilder, indexMetadata);
        DiscoveryNodes previousNodes = mock(DiscoveryNodes.class);
            .put(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), true)  
        when(shard.currentNodeId()).thenReturn("hot1");
        IndexMetadata oneReplicaIndex = IndexMetadata.builder("test-index")
            updatedMeta.getSettings().get(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey())
        when(hotNode.isWarmNode()).thenReturn(false);
        when(routingTable.allShards(testIndex.getName())).thenReturn(shardRoutings);
        IndexMetadata dfaHotMeta = IndexMetadata.builder(dfaIndexName)
        DiscoveryNode node = mock(DiscoveryNode.class);
        verify(clusterService).submitStateUpdateTask(anyString(), taskCaptor.capture());
import org.opensearch.cluster.node.DiscoveryNode;
        assertEquals("1", updatedMetadata.getSettings().get(IndexMetadata.SETTING_NUMBER_OF_REPLICAS));
        IndexNameExpressionResolver resolver = mock(IndexNameExpressionResolver.class);
            .numberOfReplicas(0)
        DiscoveryNode hotNode = mock(DiscoveryNode.class);
     * the write block when the primary is not yet running on a hot node.  
     */
        @Override
        when(resolver.concreteIndices(any(), any(), eq(dfaIndexName))).thenReturn(new Index[] { dfaIndex });  
    public void testUpdateIndexMetadataPostTiering_ThrowsOnError() {
        clusterSettingsToAdd.add(TieringUtils.JVM_USAGE_TIERING_THRESHOLD_PERCENT);  
        // INDEX_BLOCKS_WRITE setting must be false in IndexMetadata  
import org.opensearch.storage.action.tiering.status.model.TieringStatus;
        tieringService.tieringIndices.add(testIndex);  
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
    }  
        Metadata metadata = mock(Metadata.class);
            NodeEnvironment nodeEnvironment,
        Metadata metadata = Metadata.builder().put(tieringIndexMetadata, false).build();
        when(primaryShard.primary()).thenReturn(true);  
        Metadata.Builder metadataBuilder = mock(Metadata.Builder.class);
        RoutingTable rt = mock(RoutingTable.class);
import static org.opensearch.storage.common.tiering.TieringUtils.TIERING_CUSTOM_KEY;  
        );
            "false",  
        // Cover onFailure()  
        Index dfaIndex = new Index(dfaIndexName, dfaUuid);
        when(rtMock.allShards(dfaIndexName)).thenReturn(Collections.singletonList(shard));
    }
        service.clusterChanged(event);  
        // When user has replicas: 2, number_of_replicas is forced to 1 during tiering start
import org.opensearch.cluster.routing.allocation.DiskThresholdSettings;  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        // Must NOT throw — the persisted HOT_TO_WARM state makes the index cancellable after failover.
            mock(AllocationService.class),  
        verify(clusterService, org.mockito.Mockito.atLeastOnce()).submitStateUpdateTask(anyString(), any(ClusterStateUpdateTask.class));  
    /**  
    }  
        when(replicaShard.unassigned()).thenReturn(true);
        assertTrue("Index should be removed from tieringIndices", tieringService.tieringIndices.isEmpty());  
        50,
    /**  
        Metadata.Builder metadataBuilder = mock(Metadata.Builder.class);  
            .put(INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.WARM_TO_HOT.toString())  
            .metadata(meta)
        verify(listener).onFailure(thrown);
        Index dfaIndex = new Index(dfaIndexName, dfaUuid);
        when(clusterState.metadata()).thenReturn(meta);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
            ClusterState clusterState,
        when(previousState.nodes()).thenReturn(previousNodes);
            .build();  
        }
            AllocationService allocationService,
            clusterService,
        when(mockState.blocks()).thenReturn(blocks);  
        ShardRouting shard = mock(ShardRouting.class);  
            .metadata(executeMeta)  
        when(clusterState.routingTable()).thenReturn(rtMock);  
        ClusterState realState = ClusterState.builder(org.opensearch.cluster.ClusterName.DEFAULT)  
        RoutingTable rtMock = mock(RoutingTable.class);
        assertEquals(1, statuses.size());
            allocationSvc,  
        Settings tieringSettings = Settings.builder()
        verify(metadataBuilder, never()).updateNumberOfReplicas(anyInt(), any(String[].class));  
            clusterService,  
        assertNotEquals(
                indexNameExpressionResolver,
        Settings dfaWarmSettings = Settings.builder()  
            mock(ClusterInfoService.class),
            .numberOfShards(1)  
                allocationService,  
        when(clusterState.getNodes()).thenReturn(nodes);  
        when(primaryShard.currentNodeId()).thenReturn("hot1");  
        ShardRouting primaryShard = mock(ShardRouting.class);
            shardLimitValidator
            .build();
            "tier() must NOT add INDEX_WRITE_BLOCK for H2W DFA — TransportHotToWarmTierAction handles that",
        );
        List<TieringStatus> statuses = service.listTieringStatus();  
        when(clusterState.routingTable()).thenReturn(routingTable);
            .settings(zeroReplicaSettings)
    }  
            .numberOfReplicas(1)  
            .routingTable(rt)  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        verify(clusterService, never()).submitStateUpdateTask(anyString(), any(ClusterStateUpdateTask.class));  
        when(event.localNodeClusterManager()).thenReturn(false);
        ClusterChangedEvent event = buildRoutingTableChangedEvent(clusterState);
        when(clusterState.routingTable()).thenReturn(routingTable);
    public void testTier_NonDfaIndex_DoesNotAddWriteBlocksToClusterBlocks() throws Exception {
    /**  
        IndexMetadata idxMeta = IndexMetadata.builder("test-index")
import static org.mockito.Mockito.verify;  
        // Build a real cluster state with the index in HOT_TO_WARM state  
            Integer jvmActiveUsageThresholdPercent,  
        ClusterState result = taskCaptor.getValue().execute(executeState);  
        when(nodes.get("hot1")).thenReturn(hotNode);
            new Index("zero-replica-index", "uuid-zero-replicas")
        service.tieringIndices.add(testIndex);  
        when(mockScanState.routingTable()).thenReturn(rtMock);  
import org.opensearch.storage.common.tiering.TieringUtils;
        when(shard.started()).thenReturn(true);  
        IndexMetadata badMetadata = mock(IndexMetadata.class);
        clusterSettingsToAdd.add(maxConcurrentTieringRequestsSetting);
            .numberOfReplicas(0)
        RoutingTable.Builder routingTableBuilder = mock(RoutingTable.Builder.class);
        ClusterChangedEvent event = buildRoutingTableChangedEvent(clusterState);
        ArgumentCaptor<IndexMetadata.Builder> captor = ArgumentCaptor.forClass(IndexMetadata.Builder.class);  
        TestTieringService service = new TestTieringService(  
 *
        ActionListener<ClusterStateUpdateResponse> listener = mock(ActionListener.class);
        ArgumentCaptor<IndexMetadata.Builder> captor = ArgumentCaptor.forClass(IndexMetadata.Builder.class);
     */
     */
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
    }  
        ArgumentCaptor<IndexMetadata.Builder> captor = ArgumentCaptor.forClass(IndexMetadata.Builder.class);  
            NodeEnvironment nodeEnvironment,  
        when(clusterState.blocks()).thenReturn(blocks);
        // (simulates the state after tiering started but before it completed)
        verify(metadataBuilder).put(captor.capture());
        TestTieringService service = new TestTieringService(
    /**  
        verify(routingTableBuilder).updateNumberOfReplicas(eq(1), any(String[].class));  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            indexNameExpressionResolver,
        ClusterState mockState = mock(ClusterState.class);
        }
        assertEquals("false", result.metadata().index(dfaIndexName).getSettings().get(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey()));
    /**  
        AllocationService allocationSvc = mock(AllocationService.class);
     * Happy path: DFA index in HOT state with write block, all shards started on hot nodes.  
        IndexTieringRequest request = new IndexTieringRequest("HOT", dfaIndexName);  
        assertFalse(
            .put(INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.HOT.toString())
            .put(IndexMetadata.SETTING_INDEX_UUID, dfaUuid)
        verify(clusterService).submitStateUpdateTask(anyString(), taskCaptor.capture());
    }
            shardLimitValidator
        IndexMetadata zeroReplicaMetadata = IndexMetadata.builder("zero-replica-index")
        when(resolver.concreteIndices(any(), any(), eq("bad-index"))).thenThrow(new IllegalArgumentException("Index not found"));
        service.clusterChanged(event);  
    public void testUpdateIndexMetadataPostTiering_DoesNotModifyAutoExpandReplicas() {  
            nodeEnvironment,
        // Use a W2H-style tiering service (target = HOT)
    }  
                .build();
        // Build cluster state with write blocks already present in ClusterBlocks  
            .build();
            // INDEX_BLOCKS_WRITE not set → false (block already removed)
        // s.started() && ... → false (not started)  
            .build();  
        Metadata.Builder metadataBuilder = mock(Metadata.Builder.class);
            ClusterInfoService clusterInfoService,  
            shardLimitValidator
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
        ClusterState mockScanState = mock(ClusterState.class);  
    /**
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);  
        Metadata meta = Metadata.builder().put(dfaMeta, false).build();  
        TestWarmToHotTieringService warmToHotService = new TestWarmToHotTieringService(
        // Cover timeout()  
            mock(AllocationService.class),  
        service.clusterChanged(event);
        ClusterChangedEvent event = mock(ClusterChangedEvent.class);  
        verify(metadataBuilder).put(captor.capture());
        service.tieringIndices.add(testIndex);
            .build();
            mock(IndexNameExpressionResolver.class),
        // Stub shard as started on a warm node → in target tier (WARM)
            .build();  
        IllegalArgumentException e = expectThrows(
        when(event.localNodeClusterManager()).thenReturn(true);  
    public void testValidateTieringCancelRequest_AlreadyReachedTargetTier() {
        public TestWarmToHotTieringService(  
        assertEquals("Index is already in target tier", thrown.getMessage());
        // Stub shard so isShardStateValidForTier doesn't NPE
            return Settings.builder()
    public void testTier_InitiatesSuccessfully() throws Exception {  
            .numberOfShards(1)
            resolver,
            mock(ClusterInfoService.class),  
        when(clusterState.routingTable()).thenReturn(mock(RoutingTable.class));
    public void testClusterChanged_RoutingTableChanged_ProcessesTiering() {
        ActionListener<ClusterStateUpdateResponse> listener = mock(ActionListener.class);
            mock(IndexNameExpressionResolver.class),
        Settings tieringSettings = Settings.builder()
        when(event.localNodeClusterManager()).thenReturn(true);
    }  
        );
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
        Metadata.Builder metadataBuilder = mock(Metadata.Builder.class);  
        verify(metadataBuilder).put(captor.capture());
    private IndexNameExpressionResolver indexNameExpressionResolver;
        assertFalse(
            allocationSvc,
        // A task must have been submitted to remove the write block
            .build();
     * set blocks.write=false and blocks.read_only_allow_delete=false in IndexMetadata settings.
            mock(ClusterInfoService.class),  
            );
        // Verify number_of_replicas=1 is set atomically in both metadata and routing table
        Settings w2hSettings = Settings.builder()
        Metadata clusterMeta = Metadata.builder().put(meta, false).build();
        ClusterState previousState = mock(ClusterState.class);
        String dfaIndexName = "dfa-toctou-index";  
        }  
     * Test: When cancelling H2W tiering for a DFA index, the cancelTiering() execute() method must  
        String dfaUuid = "dfa-toctou-uuid";
            .put(dfaHotSettingsNoBlock)
            return IndexModule.TieringState.WARM_TO_HOT;  
            nodeEnvironment,  
            "updateIndexMetadataPostTiering must not set auto_expand_replicas",
        // Settings WITH block for the initial scan (so the task gets submitted)
        RoutingTable routingTable = mock(RoutingTable.class);
        verify(metadataBuilder).put(any(IndexMetadata.Builder.class));  
        DiscoveryNode node = mock(DiscoveryNode.class);
            .build();
            IndexNameExpressionResolver indexNameExpressionResolver,
        taskCaptor.getValue().onFailure("test_source", new RuntimeException("simulated"));
        ClusterChangedEvent event = buildRoutingTableChangedEvent(mockScanState);
        String dfaUuid = "dfa-hot-no-block-uuid";
        // Return null for index metadata during execute() → covers the null branch  
        RoutingTable routingTable = mock(RoutingTable.class);
        ) {  
            "blocks.blocks.write must be false in IndexMetadata settings after W2H tier start for DFA index",
        when(clusterState.routingTable()).thenReturn(mock(RoutingTable.class));
        ArgumentCaptor<ClusterStateUpdateTask> taskCaptor = ArgumentCaptor.forClass(ClusterStateUpdateTask.class);
            .blocks(blocksWithWriteBlock)
            .numberOfShards(1)  
            .put(INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.HOT_TO_WARM.toString())
        when(metadata.getIndexSafe(testIndex)).thenReturn(idxMeta);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
    }
        tieringCustomData.put("test_tiering_start_time", "1234567");
     * Non-DFA index with write block in HOT state — must be completely ignored.
        TestTieringService service = new TestTieringService(
    public void testUpdateClusterStateTask_IndexDeletedDuringExecution() throws Exception {
            .numberOfReplicas(0)
        when(shard.unassigned()).thenReturn(false);
        assertThat(e.getMessage(), org.hamcrest.Matchers.containsString("deleted before tiering cancellation"));  
        service.tieringIndices.add(dfaIndex);
        IndexMetadata updatedMetadata = captor.getValue().build();  
        doThrow(new IllegalArgumentException("Index is already in target tier")).when(spyService)
            Settings.EMPTY,
            .putCustom(TIERING_CUSTOM_KEY, tieringCustomData)
    public void testValidateTieringCancelRequest_IndexNotBeingTiered() {  
        assertEquals(tieringService.getTargetTieringState().toString(), updatedMetadata.getSettings().get(INDEX_TIERING_STATE.getKey()));  
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
            Settings.EMPTY,
        );  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        Exception thrown = expectThrows(IllegalArgumentException.class, () -> task.execute(clusterState));
    public void testWarmToHotTieringStart_RemovesReadOnlyAllowDeleteBlock() {
    /**
            Index index
import org.opensearch.storage.action.tiering.CancelTieringRequest;
            .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
                .put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true)  
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)  
        Settings warmSettings = Settings.builder()
        verify(clusterService, never()).submitStateUpdateTask(anyString(), any(ClusterStateUpdateTask.class));
        RoutingTable routingTable = mock(RoutingTable.class);
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)
            Settings settings,
            resolver,  
            () -> tieringService.validateTieringCancelRequest(testIndex, indexMetadata, clusterState)
        when(rtMock.hasIndex(dfaIndex)).thenReturn(true);
        when(metadataBuilder.put(any(IndexMetadata.Builder.class))).thenReturn(metadataBuilder);
            .build();  
            "No INDEX_WRITE_BLOCK should be present — TOCTOU guard must have skipped this index",  
        when(resolver.concreteIndices(any(), any(), eq("test-index"))).thenReturn(new Index[] { testIndex });
     */
        service.clusterChanged(event);  
        );
        @Override
    public void testUpdateIndexMetadataForTieringStart_SetsNumberOfReplicasToOneAndUpdatesRoutingTable() {  
            .addIndexBlock(dfaIndexName, IndexMetadata.INDEX_WRITE_BLOCK)
            clusterService,
    }  
        verify(clusterService).submitStateUpdateTask(anyString(), taskCaptor.capture());
            .addIndexBlock(dfaIndexName, IndexMetadata.INDEX_WRITE_BLOCK)
        ShardRouting shard = mock(ShardRouting.class);  
            .numberOfShards(1)
    }
import java.util.Collections;  
        when(hotNode.isWarmNode()).thenReturn(false);
        ArgumentCaptor<IndexMetadata.Builder> captor = ArgumentCaptor.forClass(IndexMetadata.Builder.class);
        String dfaUuid = "dfa-uuid";
                .put(INDEX_TIERING_STATE.getKey(), HOT_TO_WARM)
        verify(clusterService, org.mockito.Mockito.atLeastOnce()).submitStateUpdateTask(anyString(), taskCaptor.capture());  
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)
            mock(ClusterInfoService.class),
        Settings idxSettings = Settings.builder()  
        assertNotNull(result);
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        Metadata meta = Metadata.builder().put(idxMeta, false).build();  
            mock(IndexNameExpressionResolver.class),
        Settings dfaHotSettings = Settings.builder()
        RoutingTable rt = RoutingTable.builder().addAsNew(meta.index(dfaIndexName)).build();
 */  
            mock(AllocationService.class),  
            defaultSettings,
            .numberOfReplicas(1)
            // INDEX_BLOCKS_WRITE not set = false (block already removed)  
        ShardRouting replicaShard = mock(ShardRouting.class);  
            mock(ClusterInfoService.class),  
            nodeEnvironment,
    public void testGetTieringStatus_IndexBeingTiered() {
    public void testProcessTieringInProgress_HandlesIncompleteShardRelocation() {  
    public void testRemoveWriteBlock_IndexStillInTieringIndices_Skipped() {
            mock(ClusterInfoService.class),
import static org.mockito.Mockito.any;
/*  
        // allOnHot=false → no task submitted
        verify(clusterService, org.mockito.Mockito.atLeastOnce()).submitStateUpdateTask(  
        when(mockState.metadata()).thenReturn(meta);
        String dfaUuid = "dfa-execute-uuid";
            mock(AllocationService.class),
            .build();  
            .build();
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        TestTieringService service = new TestTieringService(
    private ClusterState clusterState;
        // Primary shard is unassigned — neither branch of the allMatch predicate is satisfied:
    }
        // Execute with null indexMetadata — covers the null check branch  
        RoutingTable rtMock = mock(RoutingTable.class);  
        when(shard.unassigned()).thenReturn(false);  
        RoutingTable rt = RoutingTable.builder().addAsNew(meta.index(dfaIndexName)).build();
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
        RoutingTable routingTable = mock(RoutingTable.class);
        TestWarmToHotTieringService warmToHotService = new TestWarmToHotTieringService(
            return maxConcurrentTieringRequestsSetting;
            mock(AllocationService.class),
            shardLimitValidator
        String dfaIndexName = "dfa-execute-index";  
            .put(IndexMetadata.SETTING_INDEX_UUID, dfaUuid)  
    }  
     * Sets auto_expand_replicas: false and read_only_allow_delete: false on tiering start.  
    public void testUpdateIndexMetadataForTieringStart_ZeroReplicas_SetsNumberOfReplicasToOne() {
        assertFalse(  
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)  
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)
    public void testRemoveWriteBlock_Execute_RemovesBlockAndUpdatesMetadata() throws Exception {
            return IndexModule.TieringState.HOT;
     * Happy-path execute(): task actually removes INDEX_WRITE_BLOCK from ClusterBlocks
        when(rtMock.allShards(dfaIndexName)).thenReturn(Collections.singletonList(shard));  
        Settings zeroReplicaSettings = Settings.builder()
        ArgumentCaptor<ClusterStateUpdateTask> taskCaptor = ArgumentCaptor.forClass(ClusterStateUpdateTask.class);
        when(metadata.indices()).thenReturn(Map.of());
    }  
            allocationSvc,
        assertEquals(0, tieringService.listTieringStatus().size());
        when(routingTable.hasIndex(testIndex)).thenReturn(true);
        RoutingTable routingTable = mock(RoutingTable.class);  
            .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")  
        verify(clusterService, never()).submitStateUpdateTask(org.mockito.Mockito.contains("remove-write-block"), any());
            .numberOfShards(1)
            .build();
        ClusterState realState = ClusterState.builder(org.opensearch.cluster.ClusterName.DEFAULT).metadata(meta).routingTable(rt).build();
            .put(IndexMetadata.SETTING_INDEX_UUID, "uuid-zero-replicas")  
        when(shard.started()).thenReturn(true);  
        Metadata metadata = mock(Metadata.class);
        when(previousState.nodes()).thenReturn(previousNodes);
            .settings(dfaWarmSettings)  
            mock(AllocationService.class),  
            mock(IndexNameExpressionResolver.class),
    private NodeEnvironment nodeEnvironment;  
    public void testRemoveWriteBlock_DfaHotIndexWithBlock_AllShardsOnHot_SubmitsTask() throws Exception {  
            mock(AllocationService.class),  
        // stub the iterator so the enhanced-for loop doesn't NPE on the mock.  
        ClusterState realState = ClusterState.builder(org.opensearch.cluster.ClusterName.DEFAULT)
     * Only DFA (pluggable dataformat) indices get write-blocked during tiering.  
        tieringService.clusterChanged(event);  
            .numberOfShards(1)  
            .put(INDEX_TIERING_STATE.getKey(), "HOT")  
        when(previousNodes.isLocalNodeElectedClusterManager()).thenReturn(true);
        IndexMetadata badMetadata = mock(IndexMetadata.class);
    private ShardLimitValidator shardLimitValidator;
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
        IndexNameExpressionResolver resolver = mock(IndexNameExpressionResolver.class);
            .put(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), true)
        expectThrows(OpenSearchException.class, () -> tieringService.updateIndexMetadataForTieringCancel(metadataBuilder, badMetadata));  
        IllegalArgumentException e = expectThrows(
import java.util.Map;  
        Index dfaIndex = new Index(dfaIndexName, dfaUuid);
            ClusterInfoService clusterInfoService,
import static org.mockito.Mockito.eq;
        tieringService.processTieringInProgress(clusterState, "test_source");  
        ActionListener<ClusterStateUpdateResponse> listener = mock(ActionListener.class);  
        IndexMetadata dfaHotMeta = IndexMetadata.builder(dfaIndexName)
            clusterService,  
        IndexTieringRequest request = new IndexTieringRequest("WARM", "test-index");
            .build();  
            .put(TieringUtils.JVM_USAGE_TIERING_THRESHOLD_PERCENT.getKey(), 90)  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
            .build();  
    public void testIsIndexBeingTiered() {
                clusterService,
            .numberOfReplicas(1)  
            .settings(dfaHotSettings)  
        ClusterBlocks blocksWithWriteBlock = ClusterBlocks.builder()
        RoutingTable routingTable = mock(RoutingTable.class);  
        RoutingTable rt = RoutingTable.builder().addAsNew(meta.index("non-dfa-index")).build();
        IndexMetadata badMetadata = mock(IndexMetadata.class);
        Metadata.Builder metadataBuilder = mock(Metadata.Builder.class);
        when(resolver.concreteIndices(any(), any(), eq("bad-index"))).thenThrow(new IllegalArgumentException("Index not found"));  
            .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)
    }
    /**  
        service.clusterChanged(event);
        );
            clusterService,  
            return Settings.builder()
        @Override
        when(rtMock.allShards(dfaIndexName)).thenReturn(java.util.Arrays.asList(primaryShard, replicaShard));  
        String dfaIndexName = "dfa-cleanup-index";
            .build();  
            .put(IndexMetadata.SETTING_INDEX_UUID, dfaUuid)  
        // Verify IndexMetadata settings: blocks.write must remain unchanged (not set to false during cancel)  
    public void testUpdateIndexMetadataForTieringCancel_ThrowsOnError() {
        IndexTieringRequest request = new IndexTieringRequest("WARM", "test-index");  
            nodeEnvironment,  
        when(event.state()).thenReturn(currentState);
        when(rtMock.hasIndex(dfaIndex)).thenReturn(true);  
        DiscoveryNodes currentNodes = mock(DiscoveryNodes.class);  
        verify(clusterService).submitStateUpdateTask(anyString(), taskCaptor.capture());  
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test-index")).build();
        IndexMetadata nonDfaMeta = IndexMetadata.builder("non-dfa-index")
        String dfaUuid = "dfa-cleanup-uuid";
            mock(IndexNameExpressionResolver.class),  
        // It does NOT modify SETTING_AUTO_EXPAND_REPLICAS — that setting retains whatever value
        when(clusterState.getNodes()).thenReturn(nodes);
        // index is NOT in tieringIndices (cancel completed)  
            Settings.EMPTY,
     * Expects a cluster state task to be submitted to remove the write block.
        RoutingTable rtMock = mock(RoutingTable.class);
        service.clusterChanged(event);
import org.opensearch.indices.ShardLimitValidator;
        String dfaIndexName = "dfa-deleted-index";  
    public void testRemoveWriteBlock_DfaHotIndex_NoWriteBlock_Skipped() {  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        1000,
        // ClusterBlocks should remain unchanged (empty).  
        ) {
    }  
        @Override  
        ClusterState currentState = mock(ClusterState.class);
        ArgumentCaptor<IndexMetadata.Builder> captor = ArgumentCaptor.forClass(IndexMetadata.Builder.class);
            .numberOfShards(1)  
        protected Setting<Integer> getMaxConcurrentTieringRequestsSetting() {
            resultState.blocks().hasIndexBlock(dfaIndexName, IndexMetadata.INDEX_WRITE_BLOCK)  
        Settings dfaHotSettings = Settings.builder()  
            nodeEnvironment,  
            .put(INDEX_TIERING_STATE.getKey(), HOT_TO_WARM.toString())
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
            shardLimitValidator
            .metadata(meta)
    private IndexMetadata buildDfaIndexMetadata(String indexName, String uuid) {  
        verify(routingTableBuilder).updateNumberOfReplicas(eq(1), any(String[].class));
    public void testUpdateIndexMetadataForTieringStart_TwoReplicas_SetsNumberOfReplicasToOne() {  
                .put(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), false)
        Settings dfaSettings = Settings.builder()
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
                .build();
            nodeEnvironment,  
        ArgumentCaptor<IndexMetadata.Builder> captor = ArgumentCaptor.forClass(IndexMetadata.Builder.class);  
            shardLimitValidator
        IndexNameExpressionResolver resolver = mock(IndexNameExpressionResolver.class);  
            shardLimitValidator
        assertEquals(
import static org.opensearch.index.IndexModule.INDEX_TIERING_STATE;
        ActionListener<ClusterStateUpdateResponse> listener = mock(ActionListener.class);
            org.opensearch.cluster.block.ClusterBlocks.Builder blocksBuilder,  
    //  
    public void testUpdateIndexMetadataForTieringStart_OneReplica_DoesNotUpdateRoutingTable() {  
        assertEquals(
            .put(INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.HOT.toString())
    /**
            .metadata(Metadata.EMPTY_METADATA)
        Metadata scanMeta = Metadata.builder().put(dfaHotMeta, false).build();
        RoutingTable routingTable = mock(RoutingTable.class);
            () -> tieringService.updateIndexMetadataForTieringStart(metadataBuilder, routingTableBuilder, badMetadata, testIndex)
                clusterService,
            resolver,
        // Verify IndexMetadata settings: blocks.write=false so index stays writable after restart
        ClusterChangedEvent event = buildRoutingTableChangedEvent(clusterState);  
                shardLimitValidator
import static org.mockito.Mockito.mock;  
     * "acceptable" so that {@code allOnHot=true} and the write-block removal task IS submitted.
        ClusterState clusterState = mock(ClusterState.class);  
        );
            .put(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), true)
            .numberOfShards(1)  
            .routingTable(rt)
        ClusterChangedEvent event = mock(ClusterChangedEvent.class);
        ClusterState executeState = ClusterState.builder(org.opensearch.cluster.ClusterName.DEFAULT)  
            .put(IndexMetadata.SETTING_INDEX_UUID, dfaUuid)
    public void testValidateTieringCancelRequest_NotInMemoryAndTerminalWarm_Rejected() {  
            .put(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), true)
        when(routingTable.hasIndex(testIndex)).thenReturn(true);
        // Index IS in tieringIndices — still tiering, must not be cleaned up
            mock(ClusterInfoService.class),
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)  
     * shards may still be on warm nodes running a read-only engine. The block is removed later by
    /**
        ShardRouting primaryShard = mock(ShardRouting.class);
     * localNodeClusterManager()=true but previousNodes.isLocalNodeElectedClusterManager()=true  
        when(clusterState.routingTable()).thenReturn(rtMock);  
            mock(AllocationService.class),  
        ShardRouting shard = mock(ShardRouting.class);
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
            IndexNameExpressionResolver indexNameExpressionResolver,
        nodeEnvironment = newNodeEnvironment();
            ShardLimitValidator shardLimitValidator
        String dfaIndexName = "dfa-still-tiering";  
        RoutingTable rt = RoutingTable.builder().addAsNew(meta.index("test-index")).build();
                .put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), false)
        // Execute with the state where block is already gone (TOCTOU scenario)
        when(metadata.indices()).thenReturn(Map.of("bad-index", badMetadata));  
        when(primaryShard.primary()).thenReturn(true);
        // to ensure routing table consistency with the ReplicationTracker on warm nodes.
        Settings nonDfaSettings = Settings.builder()
        Settings dfaHotSettings = Settings.builder()
            .metadata(meta)
        TestTieringService service = new TestTieringService(  
        assertFalse(tieringService.isIndexBeingTiered(testIndex));
            ShardLimitValidator shardLimitValidator
     * BEFORE tier() is called. tier() only handles W2H block removal — H2W blocking is owned
        IndexMetadata h2wMetadata = IndexMetadata.builder("test-index").settings(h2wSettings).numberOfShards(1).numberOfReplicas(1).build();
        when(metadataBuilder.put(any(IndexMetadata.Builder.class))).thenReturn(metadataBuilder);  
        IndexNameExpressionResolver resolver = mock(IndexNameExpressionResolver.class);
import static org.mockito.Mockito.when;
            .put(INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.HOT.toString())
            .build();  
        );
            allocationSvc,
        String dfaIndexName = "dfa-unassigned-replica";
            updatedMetadata.getSettings().get(IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS)
            .settings(oneReplicaSettings)  
        TestTieringService service = new TestTieringService(  
        assertThat(e.getMessage(), org.hamcrest.Matchers.containsString("already reached its target tier"));
                .build();
        when(node.isWarmNode()).thenReturn(true);
        DiscoveryNodes previousNodes = mock(DiscoveryNodes.class);
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
import org.opensearch.storage.action.tiering.IndexTieringRequest;  
        RoutingTable.Builder routingTableBuilder = mock(RoutingTable.Builder.class);  
import java.util.HashSet;
        // When user already has replicas: 1, updateNumberOfReplicas must NOT be called —
    }
        );
import static org.opensearch.index.IndexModule.TieringState.HOT_TO_WARM;
        capturedTask.clusterStateProcessed("test_source", clusterState, clusterState);
            .put(INDEX_TIERING_STATE.getKey(), "HOT")
        IndexTieringRequest request = new IndexTieringRequest("WARM", "non-dfa-index");
            clusterService,  
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)
     * execute() must skip gracefully and not throw NPE.  
        );
        IndexMetadata updatedMetadata = captor.getValue().build();
        String dfaUuid = "dfa-cancel-uuid";
        when(routingTable.hasIndex(testIndex)).thenReturn(false);  
        TestTieringService service = new TestTieringService(  
        }
        when(routingTable.allShards(testIndex.getName())).thenReturn(shardRoutings);  
        when(clusterState.metadata()).thenReturn(clusterMeta);
        IndexTieringRequest request = new IndexTieringRequest("WARM", "test-index");  
     */
        tieringService.clusterChanged(event);
        // The tiering state must be updated to the target tier
        IndexMetadata w2hMetadata = IndexMetadata.builder("test-index").settings(w2hSettings).numberOfShards(1).numberOfReplicas(1).build();  
        indexMetadata = IndexMetadata.builder("test-index").settings(indexSettings).numberOfShards(1).numberOfReplicas(2).build();
        Settings oneReplicaSettings = Settings.builder()
            resolver,
        when(badMetadata.getSettings()).thenThrow(new RuntimeException("simulated"));
        Settings dfaHotSettingsNoBlock = Settings.builder()
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)  
    }
        ShardRouting shard = mock(ShardRouting.class);  
    }
        when(clusterState.getNodes()).thenReturn(nodes);  
            .put(INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.HOT.toString())
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)  
        when(node.isWarmNode()).thenReturn(true);
            "Warm-to-hot getTieringStartSettingsToAdd should include auto_expand_replicas: false",
        testIndex = new Index("test-index", "uuid");
    }
        IndexMetadata meta = IndexMetadata.builder(indexName).settings(hotSettings).numberOfShards(1).numberOfReplicas(0).build();
            .numberOfShards(1)
        when(allocationSvc.reroute(any(ClusterState.class), anyString())).thenAnswer(inv -> inv.getArgument(0));
        TieringStatus status = service.getTieringStatus("test-index", false);
     *
        ClusterChangedEvent event = mock(ClusterChangedEvent.class);
            shardLimitValidator
            .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
            .settings(dfaHotSettings)
        when(clusterService.state()).thenReturn(clusterState);
        when(state.routingTable()).thenReturn(rt);  
        protected String getTieringStartTimeKey() {
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            nodeEnvironment,
            shardLimitValidator
        Settings indexSettings = Settings.builder()  
        when(primaryShard.unassigned()).thenReturn(false);  
            mock(ClusterInfoService.class),
        RoutingTable.Builder routingTableBuilder = mock(RoutingTable.Builder.class);
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);  
        Metadata.Builder metadataBuilder = mock(Metadata.Builder.class);  
        assertTrue(
        expectThrows(OpenSearchException.class, () -> tieringService.updateIndexMetadataPostTiering(metadataBuilder, badMetadata));
    public void testProcessTieringInProgress_HandlesDeletedIndex() {  
        when(metadata.getIndexSafe(testIndex)).thenReturn(idxMeta);
        tieringService.updateIndexMetadataForTieringStart(metadataBuilder, routingTableBuilder, indexMetadata, testIndex);  
        // Cover clusterStateProcessed()
        assertNotNull(result);  
        );
        when(event.metadataChanged()).thenReturn(false);
            ClusterInfoService service,  
            .numberOfShards(1)
        w2hService.tier(request, listener, warmState);  
        when(primaryShard.started()).thenReturn(true);
    private IndexMetadata indexMetadata;
        tieringService.updateIndexMetadataForTieringCancel(metadataBuilder, indexMetadata);
            super(
        when(resolver.concreteIndices(any(), any(), eq("test-index"))).thenReturn(new Index[] { testIndex });
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        // Execute state: block already gone (TOCTOU)
        );
        when(routingTable.hasIndex(testIndex)).thenReturn(false);
     */
        ClusterBlocks blocksWithWriteBlock = ClusterBlocks.builder()  
            ClusterService clusterService,
        ClusterChangedEvent event = buildRoutingTableChangedEvent(clusterState);
        );
                .removeIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK);
        ArgumentCaptor<ClusterStateUpdateTask> taskCaptor = ArgumentCaptor.forClass(ClusterStateUpdateTask.class);  
            "INDEX_WRITE_BLOCK must be KEPT in ClusterBlocks during H2W cancel — deferred removal until shards on hot",
        Settings warmSettings = Settings.builder()
            .numberOfReplicas(0)
            metadataBuilder,
        Settings h2wSettings = Settings.builder()  
        verify(clusterService).submitStateUpdateTask(anyString(), taskCaptor.capture());  
        ClusterState clusterState = mock(ClusterState.class);
        RoutingTable.Builder routingTableBuilder = mock(RoutingTable.Builder.class);
            .build();
        );  
            mock(AllocationService.class),  
        // auto_expand_replicas: false. The base class updateIndexMetadataForTieringStart
            shardLimitValidator
    }  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        shardLimitValidator = mock(ShardLimitValidator.class);
            return maxConcurrentTieringRequestsSetting;
        when(resolver.concreteIndices(any(), any(), eq("test-index"))).thenReturn(new Index[] { testIndex });
            Settings.EMPTY,  
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "300b")
        );
            .put(INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.HOT.toString())
        ClusterState clusterState = mock(ClusterState.class);  
            resolver,
        // Settings without write block (already removed before execute runs)
        protected org.opensearch.cluster.block.ClusterBlocks.Builder getTieringStartClusterBlocksToAdd(  
            .build();
            .numberOfShards(1)
        Metadata.Builder metadataBuilder = mock(Metadata.Builder.class);  
        }
        assertEquals("test-index", status.getIndexName());
        service.cancelTiering(cancelRequest, listener, stateWithBlocks);
        IndexMetadata badMetadata = mock(IndexMetadata.class);  
            .build();
import org.opensearch.cluster.ClusterState;  
        @Override  
        when(clusterState.routingTable()).thenReturn(routingTable);
        tieringService.processTieringInProgress(clusterState, "test_source");
        // Execute state: index has been deleted
            shardLimitValidator
            Settings.EMPTY,
        when(shard.started()).thenReturn(true);
    public void testTier_HandlesValidationFailure() {
            .put(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), true)
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
                clusterInfoService,
            ClusterService clusterService,  
        when(resolver.concreteIndices(any(), any(), eq(dfaIndexName))).thenReturn(new Index[] { dfaIndex });
            shardLimitValidator
            nodeEnvironment,  
            shardLimitValidator  
        IndexMetadata updatedMeta = resultState.metadata().index(dfaIndexName);  
        // the conditional branch `if (currentReplicas != 1)` is not entered.
        String dfaIndexName = "dfa-hot-no-block";
        IndexNameExpressionResolver resolver = mock(IndexNameExpressionResolver.class);
        // Cover onFailure — should not throw  
        assertThat(e.getMessage(), org.hamcrest.Matchers.containsString("not currently undergoing tiering operation"));
        tieringService.validateTieringCancelRequest(testIndex, h2wMetadata, clusterState);  
            mock(ClusterInfoService.class),  
            nodeEnvironment,
                .put(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), false)
            .build();
        IndexMetadata updatedMeta = resultState.metadata().index(dfaIndexName);  
    /**
        when(shard.currentNodeId()).thenReturn("hot1");  
            mock(IndexNameExpressionResolver.class),  
        Settings hotSettings = Settings.builder()
            resolver,  
        AllocationService allocationSvc = mock(AllocationService.class);
                .put(INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.WARM)  
     * This ensures that after warm→hot migration, the index becomes fully writable again.
        verify(routingTableBuilder).updateNumberOfReplicas(eq(1), any(String[].class));  
        ArgumentCaptor<ClusterStateUpdateTask> taskCaptor = ArgumentCaptor.forClass(ClusterStateUpdateTask.class);
    public void testTier_AlreadyBeingTiered_ReturnsCurrentState() throws Exception {
        when(badMetadata.getIndex()).thenReturn(new Index("bad-index", "bad-uuid"));  
        // Result must equal the input state unchanged (no index block was found to remove)
        verify(metadataBuilder).put(captor.capture());  
            .numberOfReplicas(1)
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        IOUtils.close(nodeEnvironment);
            Settings.EMPTY,
    public void testCancelTiering_ExecuteTask() throws Exception {
            mock(ClusterInfoService.class),
        when(mockScanState.getNodes()).thenReturn(nodes);
    }
        // Cover timeout()  
    public void testRemoveWriteBlock_DfaHotIndexWithBlock_ShardsStillRelocating_NoTask() {  
        TestTieringService service = new TestTieringService(
        when(rt.allShards("test-index")).thenReturn(Collections.emptyList());
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
     * Null guard inside execute(): index deleted between scan and task execution —
        @Override  
            Integer jvmActiveUsageThresholdPercent,  
     * Test: When tiering a DFA index warm→hot, the tier() execute() method must REMOVE  
            .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)
        when(shard.unassigned()).thenReturn(false);
            clusterService,  
            .build();
     *
        when(shard.currentNodeId()).thenReturn("node1");  
            "tier() must NOT add INDEX_WRITE_BLOCK for H2W DFA — TransportHotToWarmTierAction handles that",  
            .put(IndexMetadata.SETTING_INDEX_UUID, dfaUuid)
            ClusterInfoService clusterInfoService,  
            .build();
            zeroReplicaMetadata,
        IllegalArgumentException e = expectThrows(
import java.util.Set;
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        protected IndexModule.TieringState getTargetTieringState() {  
package org.opensearch.storage.tiering;
        when(nodes.get("hot1")).thenReturn(hotNode);
            () -> tieringService.validateTieringCancelRequest(testIndex, warmMetadata, clusterState)
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
                shardLimitValidator
     */
            IllegalArgumentException.class,
        when(resolver.concreteIndices(any(), any(), eq("non-dfa-index"))).thenReturn(new Index[] { nonDfaIndex });
        when(hotNode.isWarmNode()).thenReturn(false);
        ClusterChangedEvent event = buildRoutingTableChangedEvent(clusterState);
            .numberOfShards(1)  
        tieringService.tieringIndices.add(testIndex);  
            .build();  
        ClusterState state = mock(ClusterState.class);  
        assertFalse(
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        ClusterState clusterState = mock(ClusterState.class);  
        ClusterSettings mockSettings = new ClusterSettings(Settings.EMPTY, clusterSettingsToAdd);
            Settings.EMPTY,
        );
        String dfaUuid = "dfa-relocating-uuid";
        verify(clusterService, org.mockito.Mockito.atLeastOnce()).submitStateUpdateTask(anyString(), taskCaptor.capture());
    // routingTableChanged() || metadataChanged() is true.
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
        when(clusterState.routingTable()).thenReturn(routingTable);  
        // The cancel task only sets IS_WARM=false and TIERING_STATE=HOT — it does not touch blocks.write.
    }
        ClusterState realState = ClusterState.builder(org.opensearch.cluster.ClusterName.DEFAULT)
            mock(AllocationService.class),  
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);  
                .put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), false)
        ActionListener<ClusterStateUpdateResponse> listener = mock(ActionListener.class);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    public void testRemoveWriteBlock_Execute_ToctouGuard_SkipsIfBlockAlreadyRemoved() throws Exception {
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
        // Build DFA index metadata in HOT_TO_WARM state WITH write blocks already set
import static org.mockito.Mockito.never;
        IndexMetadata dfaHotMeta = IndexMetadata.builder(dfaIndexName)  
            nodeEnvironment,
     * Helper: builds a ClusterChangedEvent where routingTableChanged()=true and
    public void testRemoveWriteBlock_UnassignedReplica_PrimaryOnHot_SubmitsTask() {
        when(shard.currentNodeId()).thenReturn("node1");
        assertThat(e.getMessage(), org.hamcrest.Matchers.containsString("not currently undergoing tiering operation"));  
        verify(clusterService, org.mockito.Mockito.atLeastOnce()).submitStateUpdateTask(anyString(), taskCaptor.capture());
    }
            "INDEX_WRITE_BLOCK must be REMOVED from ClusterBlocks after W2H tier start for DFA index",  
        when(rtMock.hasIndex(dfaIndex)).thenReturn(true);
            .numberOfShards(1)  
     * Replica shard is unassigned (e.g. no available node) while the primary is started on a hot node.
    }
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            Settings.EMPTY,
    }
            mock(ClusterInfoService.class),
        indexNameExpressionResolver = mock(IndexNameExpressionResolver.class);  
import org.opensearch.cluster.routing.ShardRouting;
        IndexMetadata dfaTieringMeta = IndexMetadata.builder(dfaIndexName)
            Settings.EMPTY,  
 * SPDX-License-Identifier: Apache-2.0
        ArgumentCaptor<ClusterStateUpdateTask> taskCaptor = ArgumentCaptor.forClass(ClusterStateUpdateTask.class);  
            nodeEnvironment,  
        }
            .settings(dfaHotSettings)
        service.tier(request, listener, clusterState);
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            .build();
            .numberOfReplicas(0)  
            .numberOfReplicas(1)
        TestTieringService service = new TestTieringService(  
        CancelTieringRequest request = new CancelTieringRequest("test-index");  
    }
        verify(clusterService).submitStateUpdateTask(anyString(), any(ClusterStateUpdateTask.class));
        assertEquals("1", updatedMetadata.getSettings().get(IndexMetadata.SETTING_NUMBER_OF_REPLICAS));  
        // IndexMetadata.Builder must still be put with the tiering settings applied
        ActionListener<ClusterStateUpdateResponse> listener = mock(ActionListener.class);  
     *
import org.opensearch.common.Priority;
            .routingTable(realRt)
            .build();
        when(previousState.nodes()).thenReturn(previousNodes);  
    public void testCancelTiering_FailsOnResolveException() {  
        when(allocationSvc.reroute(any(ClusterState.class), anyString())).thenAnswer(inv -> inv.getArgument(0));
        service.clusterChanged(event);  
import static org.mockito.Mockito.doThrow;
        // When user has replicas: 0, number_of_replicas should be forced to 1 for routing table consistency.  
                .put(IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS, "false")  
        ClusterState clusterState = mock(ClusterState.class);
        when(mockScanState.routingTable()).thenReturn(rtMock);
        assertEquals("1", updatedMetadata.getSettings().get(IndexMetadata.SETTING_NUMBER_OF_REPLICAS));  
        Index dfaIndex = new Index(dfaIndexName, dfaUuid);
    public void testUpdateIndexMetadataForTieringCancel() {
        verify(clusterService, never()).submitStateUpdateTask(anyString(), any(ClusterStateUpdateTask.class));
        service.cancelTiering(request, listener, realState);  
        TestWarmToHotTieringService w2hService = new TestWarmToHotTieringService(  
        TestTieringService service = new TestTieringService(
        when(shard.unassigned()).thenReturn(false);
    public void testValidateTieringCancelRequest_NotInMemoryButWarmToHot_Accepted() {
        assertEquals(
        RoutingTable realRt = RoutingTable.builder().addAsNew(realMetadata.index("test-index")).build();
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
     *
        when(event.state()).thenReturn(currentState);
            .build();  
        // Capture the submitted task so we can execute it
        ClusterState initialState = ClusterState.builder(ClusterName.DEFAULT)  
            .settings(dfaHotSettings)
        tieringService.tieringIndices.add(testIndex);  
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)  
        // DFA index in HOT state with write block still set (orphaned from H2W cancel)
        CancelTieringRequest cancelRequest = new CancelTieringRequest(dfaIndexName);
        service.tier(request, listener, realState);  
            .settings(warmSettings)
        // Build cluster state with write blocks already present in ClusterBlocks
            tieringStartSettings.get(IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS)
        IndexNameExpressionResolver resolver = mock(IndexNameExpressionResolver.class);
    // ── removeWriteBlockForCancelledDfaIndices tests ──────────────────────────
            OpenSearchException.class,  
            .numberOfReplicas(1)
    public void testValidateTieringCancelRequest_NotInMemoryButHotToWarm_Accepted() {
            nodeEnvironment,  
        // The deferred cleanup reads blocks.write=true + TIERING_STATE=HOT to identify orphaned blocks.
