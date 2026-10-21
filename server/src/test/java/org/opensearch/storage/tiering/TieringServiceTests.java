    }
        when(event.state()).thenReturn(currentState);
        tieringService.processTieringInProgress(clusterState, "test_source");
        RoutingTable rtMock = mock(RoutingTable.class);
            .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
        Settings zeroReplicaSettings = Settings.builder()
            clusterService,
            clusterService,
        );
        ClusterState resultState = taskCaptor.getValue().execute(initialState);
        String dfaIndexName = "dfa-unassigned-replica";
    public void testIsIndexBeingTiered() {
            nodeEnvironment,
    public void testRemoveWriteBlock_DfaHotIndexWithBlock_AllShardsOnHot_SubmitsTask() throws Exception {
        ClusterState result = taskCaptor.getValue().execute(realState);
        when(primaryShard.unassigned()).thenReturn(false);
            () -> tieringService.validateTieringCancelRequest(testIndex, indexMetadata, clusterState)
import static org.mockito.Mockito.anyString;
            IllegalArgumentException.class,
        DiscoveryNode node = mock(DiscoveryNode.class);
        when(badMetadata.getSettings()).thenThrow(new RuntimeException("simulated"));
    public void testReconstructInProgressTieringRequests_HandlesException() {
        protected Setting<Integer> getMaxConcurrentTieringRequestsSetting() {
        // Use a W2H-style tiering service (target = HOT)
     * Happy-path execute(): task actually removes INDEX_WRITE_BLOCK from ClusterBlocks
    public void testTier_DfaIndex_HotToWarm_DoesNotModifyClusterBlocks() throws Exception {
     * (actively tiering) — must be skipped.
        ClusterBlocks blocks = ClusterBlocks.builder().addIndexBlock(dfaIndexName, IndexMetadata.INDEX_WRITE_BLOCK).build();
        @Override
        Settings h2wSettings = Settings.builder()
    private ClusterChangedEvent buildRoutingTableChangedEvent(ClusterState currentState) {
    public void testProcessTieringInProgress_HandlesDeletedIndex() {
        String dfaIndexName = "dfa-execute-index";
     */
        when(primaryShard.started()).thenReturn(true);
        RoutingTable rt = RoutingTable.builder().addAsNew(meta.index(dfaIndexName)).build();
            .build();
            new Index("zero-replica-index", "uuid-zero-replicas")
        );
    public void testValidateTieringCancelRequest_NotInMemoryAndTerminalWarm_Rejected() {
        ArgumentCaptor<IndexMetadata.Builder> captor = ArgumentCaptor.forClass(IndexMetadata.Builder.class);
        IndexMetadata dfaHotMeta = IndexMetadata.builder(dfaIndexName)
        when(previousNodes.isLocalNodeElectedClusterManager()).thenReturn(true);
            .addIndexBlock(dfaIndexName, IndexMetadata.INDEX_WRITE_BLOCK)
            .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
        ClusterChangedEvent event = buildRoutingTableChangedEvent(mockState);
            ClusterService clusterService,
            // INDEX_BLOCKS_WRITE not set = false (block already removed)
            .numberOfReplicas(0)
            .settings(warmSettings)
    public void testCancelTiering_SubmitsClusterStateTask() {
            .build();
        // Must NOT throw.
            Settings.EMPTY,
        when(rtMock.hasIndex(dfaIndex)).thenReturn(true);
        when(clusterState.metadata()).thenReturn(metadata);
        tieringService.tieringIndices.add(testIndex);
        );
        // It does NOT modify SETTING_AUTO_EXPAND_REPLICAS — that setting retains whatever value
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            .routingTable(rt)
            .settings(dfaHotSettings)
        task.onFailure("cancel_source", new RuntimeException("simulated"));
        IndexMetadata nonDfaMeta = IndexMetadata.builder("non-dfa-index")
     * (The target tier here is WARM, so the "already reached target" guard does not trip.)
        when(shard.started()).thenReturn(true);
        // Build cluster state: shard started on a hot node
        expectThrows(OpenSearchException.class, () -> tieringService.updateIndexMetadataPostTiering(metadataBuilder, badMetadata));
        // Execute the task to cover the execute() method
        String dfaIndexName = "dfa-cancel-index";
    public void testTier_AlreadyBeingTiered_ReturnsCurrentState() throws Exception {
        // Verify number_of_replicas=1 is set atomically in both metadata and routing table
            .settings(dfaHotSettings)
        assertEquals("1", updatedMetadata.getSettings().get(IndexMetadata.SETTING_NUMBER_OF_REPLICAS));
    /**
            clusterService,
     * shards may still be on warm nodes running a read-only engine. The block is removed later by
        Metadata metadata = Metadata.builder().put(tieringMeta, false).build();
            .settings(idxSettings)
        return event;
        TestTieringService service = new TestTieringService(
            .put(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), true)
import java.util.Collections;
     */
    }
    public void testUpdateIndexMetadataPostTiering_DoesNotModifyAutoExpandReplicas() {
        when(shard.currentNodeId()).thenReturn("hot1");
            allocationSvc,
    }
            .settings(dfaHotSettings)
            .putCustom(TIERING_CUSTOM_KEY, tieringCustomData)
     * on hot nodes (writable engine). Lifting it immediately would cause write errors on warm-engine shards.
            .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
        RoutingTable routingTable = mock(RoutingTable.class);
        when(replicaShard.primary()).thenReturn(false);
        Settings idxSettings = Settings.builder()
        when(mockScanState.blocks()).thenReturn(blocksWithBlock);
        assertEquals(
        protected IndexModule.TieringState getTieringType() {
        IndexMetadata dfaTieringMeta = IndexMetadata.builder(dfaIndexName)
        assertNotNull(result);
        tieringService.tieringIndices.add(testIndex);
        assertFalse(
        RoutingTable rtMock = mock(RoutingTable.class);
                .put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), false)
        tieringService.tieringIndices.add(testIndex);
        );
    private class TestWarmToHotTieringService extends TieringService {
        assertEquals(Priority.NORMAL, capturedTask.priority());
        java.util.HashMap<String, String> tieringCustomData = new java.util.HashMap<>();
        verify(metadataBuilder).put(captor.capture());
            .numberOfShards(1)
        doThrow(new IllegalArgumentException("Index is already in target tier")).when(spyService)
        TestTieringService service = new TestTieringService(
            shardLimitValidator
            resolver,
        when(routingTable.allShards(testIndex.getName())).thenReturn(Collections.singletonList(shard));
            .settings(dfaHotSettings)
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        service.clusterChanged(event);
    }
                clusterInfoService,
import org.opensearch.env.NodeEnvironment;
import org.opensearch.cluster.routing.allocation.AllocationService;
    }
        // The tiering state must be updated to the target tier
        when(resolver.concreteIndices(any(), any(), eq("test-index"))).thenReturn(new Index[] { testIndex });
import org.opensearch.cluster.service.ClusterService;
    }
import static org.mockito.Mockito.never;
        shardLimitValidator = mock(ShardLimitValidator.class);
            shardLimitValidator
        verify(clusterService, org.mockito.Mockito.atLeastOnce()).submitStateUpdateTask(anyString(), any(ClusterStateUpdateTask.class));
    public void testValidateTieringCancelRequest_IndexNotBeingTiered() {
        when(previousState.nodes()).thenReturn(previousNodes);
            nodeEnvironment,
        IndexMetadata dfaHotMeta = IndexMetadata.builder(dfaIndexName)
            mock(AllocationService.class),
        expectThrows(IllegalArgumentException.class, () -> service.getTieringStatus("test-index", false));
        verify(metadataBuilder).updateNumberOfReplicas(eq(1), any(String[].class));
            .numberOfReplicas(1)
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        when(mockState.metadata()).thenReturn(meta);
            mock(AllocationService.class),
        ClusterChangedEvent event = buildRoutingTableChangedEvent(mockScanState);
    // We trigger it by building a ClusterChangedEvent and calling clusterChanged().
        ClusterStateUpdateTask capturedTask = taskCaptor.getValue();
        ArgumentCaptor<ClusterStateUpdateTask> taskCaptor = ArgumentCaptor.forClass(ClusterStateUpdateTask.class);
    // routingTableChanged() || metadataChanged() is true.
        when(metadata.index(testIndex)).thenReturn(indexMetadata);
            indexNameExpressionResolver,
        IndexMetadata h2wMetadata = IndexMetadata.builder("test-index").settings(h2wSettings).numberOfShards(1).numberOfReplicas(1).build();
            clusterService,
    public void testRemoveWriteBlock_DfaHotIndexWithBlock_ShardsStillRelocating_NoTask() {
        assertFalse(
    /**
            return IndexModule.TieringState.WARM;
        service.cancelTiering(request, listener, realState);
        service.tier(request, listener, initialState);
        String dfaUuid = "dfa-unassigned-primary-uuid";
        when(hotNode.isWarmNode()).thenReturn(false);
        // Return null for index metadata during execute() → covers the null branch
            .build();
            .put(INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.HOT.toString())
        // index is NOT in tieringIndices (cancel completed)
        ArgumentCaptor<ClusterStateUpdateTask> taskCaptor = ArgumentCaptor.forClass(ClusterStateUpdateTask.class);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            String indexName,
        tieringService.updateIndexMetadataForTieringStart(
        Index dfaIndex = new Index(dfaIndexName, dfaUuid);
            .routingTable(routingTable)
            "true",
            .build();
            .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
        when(shard.currentNodeId()).thenReturn("hot1");
        IndexMetadata dfaHotMeta = IndexMetadata.builder(dfaIndexName)
                mock(AllocationService.class),
    }
        IndexMetadata idxMeta = IndexMetadata.builder("test-index")
    public void testRemoveWriteBlock_Execute_RemovesBlockAndUpdatesMetadata() throws Exception {
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertEquals("1", updatedMetadata.getSettings().get(IndexMetadata.SETTING_NUMBER_OF_REPLICAS));
        // the write block is kept during cancel and removed later by removeWriteBlockForCancelledDfaIndices().
     * the write block when the primary is not yet running on a hot node.
        @Override
     *
        // Verify ClusterBlocks: write blocks must be REMOVED (index becomes writable on hot tier)
        Index dfaIndex = new Index(dfaIndexName, dfaUuid);
            mock(IndexNameExpressionResolver.class),
            .numberOfReplicas(1)
     */
        // Stub shard so isShardStateValidForTier doesn't NPE
    }
        ArgumentCaptor<ClusterStateUpdateTask> taskCaptor = ArgumentCaptor.forClass(ClusterStateUpdateTask.class);
        when(clusterState.getNodes()).thenReturn(nodes);
            clusterService,
            ShardLimitValidator shardLimitValidator
        @Override
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test-index")).build();
        // Stub shard as started on a warm node → in target tier (WARM)
        protected IndexModule.TieringState getTieringType() {
    }
            .numberOfReplicas(1)
        tieringService.clusterChanged(event);
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)
        DiscoveryNodes previousNodes = mock(DiscoveryNodes.class);
        verify(metadataBuilder).updateNumberOfReplicas(eq(1), any(String[].class));
            Settings.EMPTY,
            IllegalArgumentException.class,
            Settings.EMPTY,
            shardLimitValidator
        when(shard.unassigned()).thenReturn(false);
        );
            clusterService,
        Settings dfaHotSettings = Settings.builder()
     * BEFORE tier() is called. tier() only handles W2H block removal — H2W blocking is owned
        Exception thrown = expectThrows(IllegalArgumentException.class, () -> task.execute(clusterState));
        when(clusterService.state()).thenReturn(state);
            nodeEnvironment,
import org.opensearch.OpenSearchException;
        IndexMetadata meta = IndexMetadata.builder(indexName).settings(hotSettings).numberOfShards(1).numberOfReplicas(0).build();
        assertNotNull(status);
            .build();
            .put(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), true)
    }
            .numberOfShards(1)
        // Cover timeout()
        when(mockScanState.blocks()).thenReturn(blocksWithBlock);
            shardLimitValidator
            super(
        String dfaUuid = "dfa-hot-no-block-uuid";
        RoutingTable routingTable = mock(RoutingTable.class);
        // Build a real cluster state with the index in HOT_TO_WARM state
    }
        AllocationService allocationSvc = mock(AllocationService.class);
        verify(clusterService).submitStateUpdateTask(anyString(), taskCaptor.capture());
        0,
        // INDEX_BLOCKS_WRITE must remain null/false (was never set by the task)
        Index dfaIndex = new Index(dfaIndexName, dfaUuid);
        // Build a real cluster state so execute() works
     * This ensures that after warm→hot migration, the index becomes fully writable again.
            mock(ClusterInfoService.class),
        assertEquals(Priority.URGENT, capturedTask.priority());
        when(resolver.concreteIndices(any(), any(), eq("bad-index"))).thenThrow(new IllegalArgumentException("Index not found"));
        IndexMetadata badMetadata = mock(IndexMetadata.class);
            ClusterInfoService clusterInfoService,
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        // Execute with the state where block is already gone (TOCTOU scenario)
     * Therefore {@code allOnHot=false} and no write-block removal task must be submitted.
        Metadata metadata = mock(Metadata.class);
    public void testListTieringStatus_Empty() {
            .numberOfShards(1)
            clusterService,
            Settings settings,
        TestTieringService spyService = spy(
        );
            mock(IndexNameExpressionResolver.class),
        IndexNameExpressionResolver resolver = mock(IndexNameExpressionResolver.class);
            mock(ClusterInfoService.class),
            .numberOfReplicas(0)
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertEquals("test-index", statuses.get(0).getIndexName());
    /**
                mock(ClusterInfoService.class),
        }
        TestTieringService service = new TestTieringService(
        // number_of_replicas=1 is applied atomically via both metadataBuilder and routingTableBuilder
            .put(INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.WARM.toString())
        String dfaUuid = "dfa-relocating-uuid";
        verify(routingTableBuilder).updateNumberOfReplicas(eq(1), any(String[].class));
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 2)
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            shardLimitValidator
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        ArgumentCaptor<ClusterStateUpdateTask> taskCaptor = ArgumentCaptor.forClass(ClusterStateUpdateTask.class);
            .metadata(metadata)
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        // Should not throw — error is caught and logged
            .routingTable(realRt)
            defaultSettings,
            .numberOfShards(1)
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            .build();
        Metadata metadata = Metadata.builder().put(tieringIndexMetadata, false).build();
            .build();
        verify(clusterService).submitStateUpdateTask(anyString(), taskCaptor.capture());
        Metadata meta = Metadata.builder().put(dfaHotMeta, false).build();
                shardLimitValidator
        when(routingTable.hasIndex(testIndex)).thenReturn(true);
        IndexMetadata dfaHotMeta = IndexMetadata.builder(dfaIndexName)
            mock(ClusterInfoService.class),
        ClusterState result = capturedTask.execute(realState);
            .numberOfShards(1)
        Settings idxSettings = Settings.builder()
            mock(IndexNameExpressionResolver.class),
        assertEquals("Index is already in target tier", thrown.getMessage());
            // PLUGGABLE_DATAFORMAT_ENABLED_SETTING not set → non-DFA
            mock(ClusterInfoService.class),
        Settings defaultSettings = Settings.builder()
        ArgumentCaptor<ClusterStateUpdateTask> taskCaptor = ArgumentCaptor.forClass(ClusterStateUpdateTask.class);
        ActionListener<ClusterStateUpdateResponse> listener = mock(ActionListener.class);
            .numberOfReplicas(0)
            resultState.blocks().hasIndexBlock(dfaIndexName, IndexMetadata.INDEX_WRITE_BLOCK)
        Settings dfaSettings = Settings.builder()
            .put(INDEX_TIERING_STATE.getKey(), "HOT")
        when(clusterState.routingTable()).thenReturn(rtMock);
            nodeEnvironment,
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        Settings dfaHotSettings = Settings.builder()
            .build();
        // Capture the submitted task so we can execute it
        tieringService.processTieringInProgress(clusterState, "test_source");
        // Settings WITH block for the initial scan (so the task gets submitted)
    public void testRemoveWriteBlock_UnassignedPrimary_DoesNotSubmitTask() {
            mock(AllocationService.class),
            .settings(tieringSettings)
    }
        when(replicaShard.unassigned()).thenReturn(true);
        @Override
        verify(listener).onFailure(any(IllegalArgumentException.class));
        );
            .build();
        DiscoveryNode hotNode = mock(DiscoveryNode.class);
            IllegalArgumentException.class,
        when(hotNode.isWarmNode()).thenReturn(false);
        ActionListener<ClusterStateUpdateResponse> listener = mock(ActionListener.class);
            .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
            .numberOfShards(1)
        }
            .addIndexBlock(dfaIndexName, IndexMetadata.INDEX_WRITE_BLOCK)
        taskCaptor.getValue().onFailure("test_source", new RuntimeException("simulated"));
        List<ShardRouting> shardRoutings = Collections.singletonList(shard);
        Metadata scanMeta = Metadata.builder().put(dfaHotMeta, false).build();
        capturedTask.clusterStateProcessed("test_source", clusterState, clusterState);
            "tier() must NOT add INDEX_WRITE_BLOCK for H2W DFA — TransportHotToWarmTierAction handles that",
        Metadata metadata = mock(Metadata.class);
        service.clusterChanged(event);
        when(shard.currentNodeId()).thenReturn("node1");
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        when(resolver.concreteIndices(any(), any(), eq(dfaIndexName))).thenReturn(new Index[] { dfaIndex });
            .put(IndexMetadata.SETTING_INDEX_UUID, dfaUuid)
        // Build cluster state with write blocks already present in ClusterBlocks
        verify(clusterService).submitStateUpdateTask(anyString(), taskCaptor.capture());
            .numberOfShards(1)
            return maxConcurrentTieringRequestsSetting;
        // tier() does NOT add write blocks for H2W DFA — that's TransportHotToWarmTierAction's responsibility.
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            nodeEnvironment,
                shardLimitValidator
        CancelTieringRequest request = new CancelTieringRequest("test-index");
            .build();
        );
            Index index
        when(shard.currentNodeId()).thenReturn("node1");
        when(clusterState.routingTable()).thenReturn(routingTable);
            .routingTable(RoutingTable.EMPTY_ROUTING_TABLE)
import org.opensearch.common.util.io.IOUtils;
        Settings dfaHotSettings = Settings.builder()
            shardLimitValidator
        RoutingTable rt = RoutingTable.builder().addAsNew(meta.index(dfaIndexName)).build();
            allocationSvc,
    private Index testIndex;
        // removeWriteBlockForCancelledDfaIndices iterates over all index metadata;
            .build();
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        when(routingTable.allShards(testIndex.getName())).thenReturn(shardRoutings);
        IndexNameExpressionResolver resolver = mock(IndexNameExpressionResolver.class);
import java.util.HashSet;
            .numberOfReplicas(0)
        RoutingTable.Builder routingTableBuilder = mock(RoutingTable.Builder.class);
        Settings dfaHotSettings = Settings.builder()
        IndexMetadata updatedMeta = resultState.metadata().index(dfaIndexName);
        when(clusterState.getNodes()).thenReturn(mock(DiscoveryNodes.class));
        @Override
            .numberOfReplicas(0)
            .put(INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.WARM.toString())
        // auto_expand_replicas: false. The base class updateIndexMetadataForTieringStart
    }
            shardLimitValidator
        ClusterState result = taskCaptor.getValue().execute(executeState);
        IndexMetadata updatedMetadata = captor.getValue().build();
            mock(ClusterInfoService.class),
        Settings warmSettings = Settings.builder()
        when(rtMock.allShards(dfaIndexName)).thenReturn(Collections.singletonList(shard));
    private IndexNameExpressionResolver indexNameExpressionResolver;
        // Verify IndexMetadata settings: blocks.write=false so index stays writable after restart
        when(rtMock.hasIndex(dfaIndex)).thenReturn(true);
        when(routingTable.hasIndex(testIndex)).thenReturn(true);
        ClusterState result = taskCaptor.getValue().execute(realState);
        when(event.localNodeClusterManager()).thenReturn(true);
        ShardRouting replicaShard = mock(ShardRouting.class);
            metadataBuilder,
        ClusterBlocks blocksWithWriteBlock = ClusterBlocks.builder()
            .build();
        assertNotEquals(
    public void testUpdateIndexMetadataPostTiering_ThrowsOnError() {
     * "acceptable" so that {@code allOnHot=true} and the write-block removal task IS submitted.
        }
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
    /**
        );
import org.opensearch.cluster.ClusterState;
        when(resolver.concreteIndices(any(), any(), eq("test-index"))).thenReturn(new Index[] { testIndex });
        Metadata.Builder metadataBuilder = mock(Metadata.Builder.class);
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "200b")
        TieringStatus status = service.getTieringStatus("test-index", false);
                clusterInfoService,
                nodeEnvironment,
            shardLimitValidator
        tieringService.clusterChanged(event);
        when(clusterState.routingTable()).thenReturn(routingTable);
        when(allocationSvc.reroute(any(ClusterState.class), anyString())).thenAnswer(inv -> inv.getArgument(0));
        Index dfaIndex = new Index(dfaIndexName, dfaUuid);
     * isMigrationInProgress returns false for terminal states, so the fallback does not apply.
        tieringService.tieringIndices.add(testIndex);
        );
            .numberOfReplicas(1)
            .numberOfShards(1)
        IndexNameExpressionResolver resolver = mock(IndexNameExpressionResolver.class);
        when(routingTable.hasIndex(testIndex)).thenReturn(true);
        ArgumentCaptor<ClusterStateUpdateTask> taskCaptor = ArgumentCaptor.forClass(ClusterStateUpdateTask.class);
        // Index IS in tieringIndices — still tiering, must not be cleaned up
            .put(maxConcurrentTieringRequestsSetting.getKey(), 50)
        ShardRouting primaryShard = mock(ShardRouting.class);
            Settings.EMPTY,
        ClusterState result = taskCaptor.getValue().execute(clusterState);
     * Test: When tiering a DFA index warm→hot, the tier() execute() method must REMOVE
    /**
        );
            AllocationService allocationService,
            .settings(warmSettings)
import org.mockito.ArgumentCaptor;
        Settings dfaHotSettingsNoBlock = Settings.builder()
            "blocks.write must NOT be set to false during cancel — deferred to removeWriteBlockForCancelledDfaIndices()",
    /**
        when(nodes.get("hot1")).thenReturn(hotNode);
            .put(INDEX_TIERING_STATE.getKey(), HOT_TO_WARM.toString())
    public void testUpdateClusterStateTask_OnFailure() {
        assertThat(e.getMessage(), org.hamcrest.Matchers.containsString("not currently undergoing tiering operation"));
            clusterService,
    public void testClusterChanged_NewClusterManager_ReconstructsRequests() {
        when(clusterState.routingTable()).thenReturn(routingTable);
        when(clusterState.routingTable()).thenReturn(mock(RoutingTable.class));
        // execute() should return currentState unchanged
        when(node.isWarmNode()).thenReturn(true);
    private ClusterService clusterService;
            .build();
            .put(INDEX_TIERING_STATE.getKey(), "HOT")
 */
            nodeEnvironment,
            shardLimitValidator
        );
            .addIndexBlock(dfaIndexName, IndexMetadata.INDEX_WRITE_BLOCK)
        }
        ClusterState clusterState = mock(ClusterState.class);
        Settings w2hSettings = Settings.builder()
    /**
        IndexTieringRequest request = new IndexTieringRequest("WARM", "test-index");
        ActionListener<ClusterStateUpdateResponse> listener = mock(ActionListener.class);
        when(event.localNodeClusterManager()).thenReturn(true);
        protected org.opensearch.cluster.block.ClusterBlocks.Builder getTieringStartClusterBlocksToAdd(
        // s.started() && ... → false (not started)
     */
        verify(clusterService, never()).submitStateUpdateTask(anyString(), any(ClusterStateUpdateTask.class));
        );
            nodeEnvironment,
        Set<Setting<?>> clusterSettingsToAdd = new HashSet<>(BUILT_IN_CLUSTER_SETTINGS);
        );
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        // The deferred cleanup reads blocks.write=true + TIERING_STATE=HOT to identify orphaned blocks.
        ArgumentCaptor<ClusterStateUpdateTask> taskCaptor = ArgumentCaptor.forClass(ClusterStateUpdateTask.class);
        when(mockState.blocks()).thenReturn(blocks);
        verify(clusterService).submitStateUpdateTask(anyString(), taskCaptor.capture());
            shardLimitValidator
        tieringService.processTieringInProgress(clusterState, "test_source");
        );
        when(event.routingTableChanged()).thenReturn(true);
            .routingTable(rt)
        when(metadata.getIndexSafe(testIndex)).thenReturn(idxMeta);
            "Warm-to-hot getTieringStartSettingsToAdd should include auto_expand_replicas: false",
        Metadata metadata = mock(Metadata.class);
     * Test: Non-DFA index should NOT have write blocks added to ClusterBlocks during tiering.
        ArgumentCaptor<IndexMetadata.Builder> captor = ArgumentCaptor.forClass(IndexMetadata.Builder.class);
        TestTieringService service = new TestTieringService(
    }
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
    /**
        ActionListener<ClusterStateUpdateResponse> listener = mock(ActionListener.class);
        protected void validateTieringRequest(
        );
        Metadata emptyMetadata = Metadata.builder().build();
        String dfaUuid = "dfa-deleted-uuid";
            .build();
     * DFA index in HOT state with write block, but it's still in tieringIndices
        Metadata metadata = mock(Metadata.class);
        when(node.isWarmNode()).thenReturn(true);
import org.opensearch.indices.ShardLimitValidator;
            IndexNameExpressionResolver indexNameExpressionResolver,
        when(shard.started()).thenReturn(true);
        when(clusterState.routingTable()).thenReturn(routingTable);
            .put(INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.HOT.toString())
            String indexName,
            org.opensearch.cluster.block.ClusterBlocks.Builder blocksBuilder,
            .build();
            Settings.EMPTY,
        when(badMetadata.getSettings()).thenThrow(new RuntimeException("simulated error"));
    /**
        RoutingTable rt = RoutingTable.builder().addAsNew(executeMeta.index(dfaIndexName)).build();
        when(clusterState.metadata()).thenReturn(meta);
    }
        when(mockState.routingTable()).thenReturn(rtMock);
        );
                allocationService,
        TestTieringService service = new TestTieringService(
        assertEquals(1, statuses.size());
        ClusterState executeState = ClusterState.builder(org.opensearch.cluster.ClusterName.DEFAULT)
        // Verify ClusterBlocks: write block must be KEPT (deferred to removeWriteBlockForCancelledDfaIndices)
        IndexTieringRequest request = new IndexTieringRequest("WARM", "bad-index");
        when(allocationSvc.reroute(any(ClusterState.class), anyString())).thenAnswer(inv -> inv.getArgument(0));
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
        tieringService = new TestTieringService(
            .put(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), true)
        when(resolver.concreteIndices(any(), any(), eq(dfaIndexName))).thenReturn(new Index[] { dfaIndex });
        when(state.getMetadata()).thenReturn(metadata);
            nodeEnvironment,
    // ── removeWriteBlockForCancelledDfaIndices tests ──────────────────────────
        @Override
            .numberOfShards(1)
            .build();
        RoutingTable routingTable = mock(RoutingTable.class);
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "300b")
        Index dfaIndex = new Index(dfaIndexName, dfaUuid);
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
    }
        ActionListener<ClusterStateUpdateResponse> listener = mock(ActionListener.class);
        Metadata meta = Metadata.builder().put(idxMeta, false).build();
        when(badMetadata.getSettings()).thenThrow(new RuntimeException("simulated"));
        when(rtMock.hasIndex(dfaIndex)).thenReturn(true);
import org.opensearch.Version;
        RoutingTable.Builder routingTableBuilder = mock(RoutingTable.Builder.class);
        );
            Index index
        verify(routingTableBuilder, never()).updateNumberOfReplicas(anyInt(), any(String[].class));
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
    /**
     */
        ClusterSettings mockSettings = new ClusterSettings(Settings.EMPTY, clusterSettingsToAdd);
        verify(metadataBuilder).put(captor.capture());
        assertNull(
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
        when(routingTable.allShards(testIndex.getName())).thenReturn(shardRoutings);
        ClusterChangedEvent event = mock(ClusterChangedEvent.class);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        service.cancelTiering(request, listener, clusterState);
        // (simulates the state after tiering started but before it completed)
            .blocks(blocksWithWriteBlock)
            Settings.EMPTY,
        IndexNameExpressionResolver resolver = mock(IndexNameExpressionResolver.class);
        verify(clusterService).submitStateUpdateTask(anyString(), taskCaptor.capture());
        verify(clusterService).submitStateUpdateTask(anyString(), taskCaptor.capture());
import org.opensearch.storage.action.tiering.status.model.TieringStatus;
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        );
        ClusterChangedEvent event = buildRoutingTableChangedEvent(clusterState);
            nodeEnvironment,
    public void testTier_DfaIndex_WarmToHot_RemovesWriteBlocksFromClusterBlocksAndSettings() throws Exception {
import org.opensearch.core.index.Index;
        TestTieringService service = new TestTieringService(
        when(resolver.concreteIndices(any(), any(), eq("non-dfa-index"))).thenReturn(new Index[] { nonDfaIndex });
        tieringCustomData.put("test_tiering_start_time", "1234567");
import org.opensearch.cluster.routing.allocation.DiskThresholdSettings;
            .numberOfShards(1)
            allocationSvc,
            resolver,
            .put(IndexMetadata.SETTING_INDEX_UUID, dfaUuid)
        ActionListener<ClusterStateUpdateResponse> listener = mock(ActionListener.class);
            ShardLimitValidator shardLimitValidator
            nodeEnvironment,
        }
        protected Settings getTieringStartSettingsToAdd(IndexMetadata indexMetadata) {
        // auto_expand_replicas is not modified by updateIndexMetadataPostTiering —
import org.opensearch.cluster.routing.RoutingTable;
    }
        assertFalse("Index should be removed after processing", tieringService.tieringIndices.contains(testIndex));
 * SPDX-License-Identifier: Apache-2.0
        );
        verify(metadataBuilder, never()).updateNumberOfReplicas(anyInt(), any(String[].class));
     */
        when(shard.unassigned()).thenReturn(false);
        ShardRouting shard = mock(ShardRouting.class);
        @Override
    }
        ClusterBlocks blocks = ClusterBlocks.builder().addIndexBlock(dfaIndexName, IndexMetadata.INDEX_WRITE_BLOCK).build();
            .build();
        Metadata.Builder metadataBuilder = mock(Metadata.Builder.class);
     * TOCTOU guard inside execute(): index condition changed between scan and task execution
            .put(INDEX_TIERING_STATE.getKey(), "HOT")
            clusterService,
            .build();
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
            .metadata(realMetadata)
            tieringStartSettings.get(IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS)
        DiscoveryNode hotNode = mock(DiscoveryNode.class);
            return Settings.builder()
        // to ensure routing table consistency with the ReplicationTracker on warm nodes.
            .put(INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.HOT_TO_WARM.toString())
            .build();
     * The condition {@code s.unassigned() && !s.primary()} must treat the unassigned replica as
                resolver,
        ClusterStateUpdateTask task = taskCaptor.getValue();
    }
    @Before
import static org.opensearch.common.settings.ClusterSettings.BUILT_IN_CLUSTER_SETTINGS;
        when(shard.unassigned()).thenReturn(false);
    }
        ArgumentCaptor<ClusterStateUpdateTask> taskCaptor = ArgumentCaptor.forClass(ClusterStateUpdateTask.class);
    }
        @Override
        IndexMetadata updatedMetadata = captor.getValue().build();
                .build();
        "test_max_tiering_requests",
        TestWarmToHotTieringService w2hService = new TestWarmToHotTieringService(
        expectThrows(OpenSearchException.class, () -> tieringService.updateIndexMetadataForTieringCancel(metadataBuilder, badMetadata));
        }
        when(clusterState.routingTable()).thenReturn(rtMock);
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
        Settings tieringSettings = Settings.builder()
            return maxConcurrentTieringRequestsSetting;
            return HOT_TO_WARM;
        TestTieringService service = new TestTieringService(
            .numberOfReplicas(0)
            .numberOfShards(1)
        Index dfaIndex = new Index(dfaIndexName, dfaUuid);
            mock(AllocationService.class),
        Metadata.Builder metadataBuilder = mock(Metadata.Builder.class);
        Index dfaIndex = new Index(dfaIndexName, dfaUuid);
    }
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
    }
            .numberOfShards(1)
            "blocks.write must be false in IndexMetadata settings after W2H tier start for DFA index",
        AllocationService allocationSvc = mock(AllocationService.class);
            IllegalArgumentException.class,
    }
            Settings.EMPTY,
        ShardRouting shard = mock(ShardRouting.class);
            shardLimitValidator
    /**
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
            .settings(dfaTieringSettings)
        ClusterBlocks blocksWithWriteBlock = ClusterBlocks.builder()
        );
        assertSame(clusterState, result);
        // allOnHot=true (primary on hot + replica unassigned-non-primary) → task must be submitted
            indexNameExpressionResolver,
            ClusterState clusterState,
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)
            mock(IndexNameExpressionResolver.class),
            "INDEX_WRITE_BLOCK must be KEPT in ClusterBlocks during H2W cancel — deferred removal until shards on hot",
            .build();
        assertTrue(
        TestTieringService service = new TestTieringService(
        when(clusterState.getNodes()).thenReturn(nodes);
            clusterService,
        when(currentState.metadata()).thenReturn(metadata);
        protected String getTieringStartTimeKey() {
        }
        when(metadataBuilder.put(any(IndexMetadata.Builder.class))).thenReturn(metadataBuilder);
            nodeEnvironment,
import org.opensearch.cluster.block.ClusterBlocks;
        TestTieringService service = new TestTieringService(
            .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
import static org.mockito.Mockito.mock;
        when(metadata.index(testIndex)).thenReturn(indexMetadata);
        ActionListener<ClusterStateUpdateResponse> listener = mock(ActionListener.class);
        Metadata.Builder metadataBuilder = mock(Metadata.Builder.class);
        DiscoveryNode hotNode = mock(DiscoveryNode.class);
            return IndexModule.TieringState.WARM_TO_HOT;
     *
            return "test_tiering_start_time";
        // Shard on warm node → in target tier
        Metadata.Builder metadataBuilder = mock(Metadata.Builder.class);
        ) {}
        when(metadata.indices()).thenReturn(Map.of());
        assertNotEquals(
        );
            mock(AllocationService.class),
                clusterService,
    public void testUpdateIndexMetadataForTieringStart_ThrowsOnError() {
     * Primary shard itself is unassigned — {@code s.unassigned() && !s.primary()} is false
        protected void validateTieringRequest(
        // A task must have been submitted to remove the write block
            .put(IndexMetadata.SETTING_INDEX_UUID, dfaUuid)
        Metadata clusterMeta = Metadata.builder().put(meta, false).build();
        verify(clusterService).submitStateUpdateTask(anyString(), taskCaptor.capture());
            nodeEnvironment,
        assertTrue("Bad index should not be added", tieringService.tieringIndices.isEmpty());
        when(clusterState.metadata()).thenReturn(meta);
        TestTieringService service = new TestTieringService(
            .putCustom(TIERING_CUSTOM_KEY, tieringCustomData)
        when(hotNode.isWarmNode()).thenReturn(false);
        RoutingTable routingTable = mock(RoutingTable.class);
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
        when(clusterState.routingTable()).thenReturn(routingTable);
     */
     * entirely by TransportHotToWarmTierAction.
    }
        assertTrue("Index should be removed from tieringIndices", tieringService.tieringIndices.isEmpty());
            mock(ClusterInfoService.class),
        IndexMetadata zeroReplicaMetadata = IndexMetadata.builder("zero-replica-index")
        }
            nodeEnvironment,
import static org.mockito.Mockito.when;
        // IndexMetadata.Builder must still be put with the tiering settings applied
        Index nonDfaIndex = new Index("non-dfa-index", "non-dfa-uuid");
        when(shard.currentNodeId()).thenReturn("hot1");
        when(routingTable.hasIndex(testIndex)).thenReturn(false);
        IndexMetadata dfaHotMeta = IndexMetadata.builder(dfaIndexName)
            .put(FileCacheSettings.DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING.getKey(), 5.0)
        when(clusterState.routingTable()).thenReturn(routingTable);
            () -> tieringService.validateTieringCancelRequest(testIndex, indexMetadata, clusterState)
            Settings.EMPTY,
        warmToHotService.updateIndexMetadataForTieringStart(metadataBuilder, routingTableBuilder, indexMetadata, testIndex);
     * KEEP the INDEX_WRITE_BLOCK in ClusterBlocks and KEEP blocks.write=true in IndexMetadata settings.
        // Cover clusterStateProcessed()
        TestTieringService service = new TestTieringService(
            .build();
        assertEquals(0, tieringService.listTieringStatus().size());
        when(event.localNodeClusterManager()).thenReturn(true);
            Settings.EMPTY,
                settings,
        ClusterState initialState = ClusterState.builder(ClusterName.DEFAULT)
        String dfaUuid = "dfa-w2h-uuid";
        IndexNameExpressionResolver resolver = mock(IndexNameExpressionResolver.class);
    public void testCancelTiering_FailsOnResolveException() {
            nodeEnvironment,
            routingTableBuilder,
        DiscoveryNode hotNode = mock(DiscoveryNode.class);
            .put(INDEX_TIERING_STATE.getKey(), "HOT")
        verify(metadataBuilder).put(captor.capture());
    public void testRemoveWriteBlock_DfaHotIndex_NoWriteBlock_Skipped() {
        // Pre-add index so execute() hits the early return
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .put(INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.HOT.toString())
        ArgumentCaptor<IndexMetadata.Builder> captor = ArgumentCaptor.forClass(IndexMetadata.Builder.class);
    public void setUp() throws Exception {
            .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
        when(event.routingTableChanged()).thenReturn(true);
        String dfaIndexName = "dfa-cleanup-index";
            shardLimitValidator
        when(resolver.concreteIndices(any(), any(), eq("test-index"))).thenReturn(new Index[] { testIndex });
        AllocationService allocationSvc = mock(AllocationService.class);
        Settings tieringStartSettings = warmToHotService.getTieringStartSettingsToAdd(buildDfaIndexMetadata("w2h-check-idx", "w2h-uuid"));
            return Settings.builder()
    public void testGetTieringStatus_IndexNotBeingTiered() {
        when(resolver.concreteIndices(any(), any(), eq(dfaIndexName))).thenReturn(new Index[] { dfaIndex });
    private TestTieringService tieringService;
        when(shard.currentNodeId()).thenReturn("node1");
        String dfaUuid = "dfa-toctou-uuid";
        when(hotNode.isWarmNode()).thenReturn(false);
        // but the setting is correctly applied in the final tiering completion step.
            Settings.EMPTY,
            .metadata(meta)
        ShardRouting shard = mock(ShardRouting.class);
        // Non-DFA index should NOT have write blocks added
    /**
            );
        assertNull("Tiering custom metadata should be removed", updatedMetadata.getCustomData(TIERING_CUSTOM_KEY));
            .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
        tieringService.tieringIndices.add(testIndex);
        IOUtils.close(nodeEnvironment);
        when(shard.started()).thenReturn(true);
            clusterService,
            .numberOfReplicas(0)
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
        assertFalse(
        );
        Settings oneReplicaSettings = Settings.builder()
        when(clusterState.routingTable()).thenReturn(rtMock);
            allocationSvc,
        Metadata metadata = mock(Metadata.class);
     * Test: When cancelling H2W tiering for a DFA index, the cancelTiering() execute() method must
        ClusterChangedEvent event = mock(ClusterChangedEvent.class);
        Settings dfaHotSettingsWithBlock = Settings.builder()
     */
            .build();
        verify(clusterService, org.mockito.Mockito.atLeastOnce()).submitStateUpdateTask(anyString(), taskCaptor.capture());
    }
        IndexMetadata tieringIndexMetadata = IndexMetadata.builder("tiering-index")
            mock(AllocationService.class),
        clusterSettingsToAdd.add(TieringUtils.JVM_USAGE_TIERING_THRESHOLD_PERCENT);
        ArgumentCaptor<IndexMetadata.Builder> captor = ArgumentCaptor.forClass(IndexMetadata.Builder.class);
        IndexNameExpressionResolver resolver = mock(IndexNameExpressionResolver.class);
            "tier() must NOT add INDEX_WRITE_BLOCK for H2W DFA — TransportHotToWarmTierAction handles that",
@SuppressWarnings("unchecked")
            .put(INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.HOT.toString())
        TestWarmToHotTieringService warmToHotService = new TestWarmToHotTieringService(
    }
        // Shard is initializing (not started) — relocation not complete
            .put(TieringUtils.JVM_USAGE_TIERING_THRESHOLD_PERCENT.getKey(), 90)
            mock(AllocationService.class),
    public void testValidateTieringCancelRequest_IndexDeleted() {
        when(clusterState.metadata()).thenReturn(metadata);
        );
        protected Settings getIndexTierSettingsToRestoreAfterCancellation(IndexMetadata indexMetadata) {
        TestTieringService service = new TestTieringService(
        IndexMetadata dfaWarmMeta = IndexMetadata.builder(dfaIndexName)
 * The OpenSearch Contributors require contributions made to
            shardLimitValidator
        clusterSettingsToAdd.add(maxConcurrentTieringRequestsSetting);
            clusterService,
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        @Override
            .build();
/*
        when(clusterState.routingTable()).thenReturn(routingTable);
        when(node.isWarmNode()).thenReturn(false);
        clusterSettingsToAdd.add(FileCacheSettings.DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING);
public class TieringServiceTests extends OpenSearchTestCase {
        when(event.state()).thenReturn(currentState);
            Settings.EMPTY,
            Settings.EMPTY,
            clusterService,
            ClusterService clusterService,
        RoutingTable rt = RoutingTable.builder().addAsNew(meta.index("non-dfa-index")).build();
import org.junit.Before;
        CancelTieringRequest request = new CancelTieringRequest("bad-index");
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        );
        ShardRouting shard = mock(ShardRouting.class);
     * DFA index in HOT state but write block already removed — no task submitted.
        verify(clusterService, never()).submitStateUpdateTask(org.mockito.Mockito.contains("remove-write-block"), any());
        Metadata metadata = mock(Metadata.class);
            clusterService,
            .put(IndexMetadata.SETTING_INDEX_UUID, dfaUuid)
        DiscoveryNode hotNode = mock(DiscoveryNode.class);
    public void testTier_FailsOnResolveException() {
            mock(ClusterInfoService.class),
        when(metadata.index(testIndex)).thenReturn(null);
        verify(clusterService, never()).submitStateUpdateTask(org.mockito.Mockito.contains("remove-write-block"), any());
            mock(AllocationService.class),
            .build();
    public void testRemoveWriteBlock_UnassignedReplica_PrimaryOnHot_SubmitsTask() {
        // When user has replicas: 2, number_of_replicas is forced to 1 during tiering start
        when(shard.unassigned()).thenReturn(false);
        assertNotNull(capturedTask.timeout());
                indexNameExpressionResolver,
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
            .addIndexBlock(dfaIndexName, IndexMetadata.INDEX_WRITE_BLOCK)
        when(metadata.indices()).thenReturn(Map.of("bad-index", badMetadata));
                .put(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), false)
                clusterService,
        Metadata metadata = mock(Metadata.class);
            "true",
        verify(metadataBuilder).put(captor.capture());
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        String dfaIndexName = "dfa-w2h-index";
        String dfaIndexName = "dfa-index";
    @Override
     */
        RoutingTable rt = RoutingTable.builder().addAsNew(meta.index("test-index")).build();
import static org.opensearch.storage.common.tiering.TieringUtils.TIERING_CUSTOM_KEY;
    }
import org.opensearch.storage.action.tiering.IndexTieringRequest;
        tieringService.tieringIndices.add(testIndex);
        ActionListener<ClusterStateUpdateResponse> listener = mock(ActionListener.class);
 * this file be licensed under the Apache-2.0 license or a
        );
        when(shard.started()).thenReturn(true);
            ClusterInfoService clusterInfoService,
            mock(AllocationService.class),
            .numberOfShards(1)
        IndexMetadata dfaHotMeta = IndexMetadata.builder(dfaIndexName)
        AllocationService allocationSvc = mock(AllocationService.class);
        AllocationService allocationSvc = mock(AllocationService.class);
        IndexTieringRequest request = new IndexTieringRequest("WARM", dfaIndexName);
        task.onFailure("test_source", thrown);
        TestTieringService service = new TestTieringService(
        );
     */
        }
     * A test tiering service that mimics WarmToHotTieringService behavior.
        ClusterState result = capturedTask.execute(realState);
    public void testClusterChanged_RoutingTableChanged_ProcessesTiering() {
    public void testUpdateIndexMetadataForTieringStart_TwoReplicas_SetsNumberOfReplicasToOne() {
        assertNotEquals(
        verify(clusterService, never()).submitStateUpdateTask(org.mockito.Mockito.contains("remove-write-block"), any());
            mock(ClusterInfoService.class),
            clusterService,
            .build();
        when(primaryShard.started()).thenReturn(false);
            mock(ClusterInfoService.class),
            clusterService,
        // Verify IndexMetadata settings: blocks.write must remain unchanged (not set to false during cancel)
            nodeEnvironment,
        IndexTieringRequest request = new IndexTieringRequest("WARM", "test-index");
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        when(clusterState.getNodes()).thenReturn(nodes);
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
        AllocationService allocationSvc = mock(AllocationService.class);
            .put(IndexMetadata.SETTING_INDEX_UUID, dfaUuid)
            .build();
            mock(IndexNameExpressionResolver.class),
    }
        when(clusterState.getNodes()).thenReturn(nodes);
        when(rtMock.allShards(dfaIndexName)).thenReturn(java.util.Arrays.asList(primaryShard, replicaShard));
        // Routing table and metadata must NOT have updateNumberOfReplicas called
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        ShardRouting shard = mock(ShardRouting.class);
        );
     */
            shardLimitValidator
        String dfaUuid = "dfa-uuid";
        IndexNameExpressionResolver resolver = mock(IndexNameExpressionResolver.class);
     */
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
        );
        when(clusterState.getNodes()).thenReturn(nodes);
            .put(IndexMetadata.SETTING_INDEX_UUID, dfaUuid)
        IllegalArgumentException e = expectThrows(
            mock(AllocationService.class),
import org.opensearch.storage.action.tiering.CancelTieringRequest;
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        when(allocationSvc.reroute(any(ClusterState.class), anyString())).thenAnswer(inv -> inv.getArgument(0));
        verify(clusterService, never()).submitStateUpdateTask(anyString(), any(ClusterStateUpdateTask.class));
            mock(IndexNameExpressionResolver.class),
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)
        ClusterState state = mock(ClusterState.class);
        // Execute state: block already gone (TOCTOU)
            .put(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), true)
        capturedTask.clusterStateProcessed("test_source", realState, realState);
import org.opensearch.cluster.node.DiscoveryNodes;
    private class TestTieringService extends TieringService {
            mock(ClusterInfoService.class),
        ClusterChangedEvent event = buildRoutingTableChangedEvent(clusterState);
        Settings dfaHotSettings = Settings.builder()
        when(rtMock.allShards(dfaIndexName)).thenReturn(Collections.singletonList(primaryShard));
            IndexNameExpressionResolver indexNameExpressionResolver,
        when(rtMock.hasIndex(dfaIndex)).thenReturn(true);
                indexNameExpressionResolver,
        ClusterState realState = ClusterState.builder(org.opensearch.cluster.ClusterName.DEFAULT)
            resolver,
        IllegalArgumentException e = expectThrows(
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
        DiscoveryNode node = mock(DiscoveryNode.class);
            "INDEX_WRITE_BLOCK must be REMOVED from ClusterBlocks after W2H tier start for DFA index",
     */
        when(mockScanState.metadata()).thenReturn(scanMeta);
        Settings indexSettings = Settings.builder()
            .build();
import org.opensearch.common.Priority;
        // stub the iterator so the enhanced-for loop doesn't NPE on the mock.
     *
        );
            .put(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), true)
        IndexMetadata dfaHotMeta = IndexMetadata.builder(dfaIndexName)
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .put(INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.HOT.toString())
            .numberOfReplicas(0)
        when(shard.started()).thenReturn(true);
    public void testTier_InitiatesSuccessfully() throws Exception {
     * (so reconstruction is skipped and only the cleanup path runs).
            .put(INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.WARM.toString())
import org.opensearch.test.OpenSearchTestCase;
        when(primaryShard.primary()).thenReturn(true);
            .settings(dfaHotSettings)
        tieringService.updateIndexMetadataForTieringStart(metadataBuilder, routingTableBuilder, indexMetadata, testIndex);
            .put(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), true)
    /**
            "INDEX_WRITE_BLOCK must NOT be added for non-DFA index",
        // Primary shard is unassigned — neither branch of the allMatch predicate is satisfied:
            "Warm-to-hot tiering start should set blocks.write to false",
        Settings idxSettings = Settings.builder()
            .build();
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
        when(event.previousState()).thenReturn(previousState);
            shardLimitValidator
            IndexMetadata indexMetadata
        when(event.previousState()).thenReturn(previousState);
        List<TieringStatus> statuses = service.listTieringStatus();
        String dfaUuid = "dfa-cancel-uuid";
        Settings dfaHotSettings = Settings.builder()
        ClusterState realState = ClusterState.builder(org.opensearch.cluster.ClusterName.DEFAULT).metadata(meta).routingTable(rt).build();
        Index dfaIndex = new Index(dfaIndexName, dfaUuid);
        String dfaUuid = "dfa-unassigned-replica-uuid";
            .build();
            mock(ClusterInfoService.class),
     * Only DFA (pluggable dataformat) indices get write-blocked during tiering.
        ArgumentCaptor<ClusterStateUpdateTask> taskCaptor = ArgumentCaptor.forClass(ClusterStateUpdateTask.class);
    public void testProcessTieringInProgress_CompletesSuccessfully() throws Exception {
            resolver,
            .build();
import static org.opensearch.index.IndexModule.TieringState.HOT_TO_WARM;
            .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
            .routingTable(rt)
        IndexTieringRequest request = new IndexTieringRequest("HOT", dfaIndexName);
        verify(clusterService).submitStateUpdateTask(anyString(), taskCaptor.capture());
        service.tieringIndices.add(testIndex);
     */
        when(resolver.concreteIndices(any(), any(), eq("test-index"))).thenReturn(new Index[] { testIndex });
        IndexTieringRequest request = new IndexTieringRequest("WARM", "non-dfa-index");
            .build();
        ArgumentCaptor<ClusterStateUpdateTask> taskCaptor = ArgumentCaptor.forClass(ClusterStateUpdateTask.class);
        ClusterState clusterState = mock(ClusterState.class);
            "INDEX_WRITE_BLOCK must NOT be added for non-DFA index",
            Settings.EMPTY,
import org.opensearch.cluster.routing.ShardRouting;
        clusterState = mock(ClusterState.class);
            .build();
            updatedMetadata.getSettings().get(IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS)
        ClusterState clusterState = mock(ClusterState.class);
            .put(IndexMetadata.SETTING_INDEX_UUID, uuid)
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        RoutingTable.Builder routingTableBuilder = mock(RoutingTable.Builder.class);
            return Settings.builder()
        service.clusterChanged(event);
     * Test: tier() for a DFA index hot→warm does NOT add write blocks to ClusterBlocks.
            () -> tieringService.validateTieringCancelRequest(testIndex, warmMetadata, clusterState)
        Index dfaIndex = new Index(dfaIndexName, dfaUuid);
            "INDEX_WRITE_BLOCK must be absent from ClusterBlocks after execute()",
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            mock(ClusterInfoService.class),
            Settings.EMPTY,
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
        );
        );
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            mock(ClusterInfoService.class),
        Metadata.Builder metadataBuilder = mock(Metadata.Builder.class);
        // updateIndexMetadataPostTiering only updates INDEX_TIERING_STATE and removes tiering custom data.
        IndexMetadata badMetadata = mock(IndexMetadata.class);
            resultState.blocks().hasIndexBlock(dfaIndexName, IndexMetadata.INDEX_WRITE_BLOCK)
        ClusterBlocks blocksWithBlock = ClusterBlocks.builder().addIndexBlock(dfaIndexName, IndexMetadata.INDEX_WRITE_BLOCK).build();
        50,
        java.util.HashMap<String, String> tieringCustomData = new java.util.HashMap<>();
                .put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), false)
            updatedMetadata.getSettings().get(org.opensearch.index.IndexModule.INDEX_TIERING_STATE.getKey())
                .removeIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK);
        when(shard.unassigned()).thenReturn(false);
        );
        when(clusterState.routingTable()).thenReturn(routingTable);
     * execute() must skip gracefully and not throw NPE.
                .build();
        when(rtMock.allShards(dfaIndexName)).thenReturn(Collections.singletonList(shard));
            .put(INDEX_TIERING_STATE.getKey(), HOT_TO_WARM.toString())
        when(primaryShard.unassigned()).thenReturn(true);
        RoutingTable rt = RoutingTable.builder().addAsNew(meta.index(dfaIndexName)).build();
        protected Settings getTieringStartSettingsToAdd(IndexMetadata indexMetadata) {
            .build();
        RoutingTable routingTable = mock(RoutingTable.class);
        when(routingTable.allShards(testIndex.getName())).thenReturn(Collections.singletonList(shard));
     * Replica shard is unassigned (e.g. no available node) while the primary is started on a hot node.
import org.opensearch.common.settings.Setting;
            .build();
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)
        // Confirm number_of_replicas is set to 1 in metadata settings
        tieringService.validateTieringCancelRequest(testIndex, w2hMetadata, clusterState);
            .put(IndexMetadata.SETTING_INDEX_UUID, dfaUuid)
            ClusterState clusterState,
    public void testRemoveWriteBlock_NonDfaIndex_Skipped() {
        expectThrows(
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
}
            nodeEnvironment,
     *
            "false",
            .numberOfShards(1)
        tieringService.validateTieringCancelRequest(testIndex, h2wMetadata, clusterState);
        assertFalse("Index should be removed from tieringIndices", tieringService.tieringIndices.contains(testIndex));
        ShardRouting shard = mock(ShardRouting.class);
            .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)
        // No task submitted — shards not yet all on hot
            return blocksBuilder;
        assertEquals(tieringService.getTargetTieringState().toString(), updatedMetadata.getSettings().get(INDEX_TIERING_STATE.getKey()));
        when(shard.unassigned()).thenReturn(false);
        tieringService.clusterChanged(event);
        // Build warm DFA index metadata WITH write blocks set (it was warm, writes blocked)
        ) {
            shardLimitValidator
    }
        }
            .build();
            result.blocks().hasIndexBlock(dfaIndexName, IndexMetadata.INDEX_WRITE_BLOCK)
    }
import org.opensearch.storage.common.tiering.TieringUtils;
            Settings.EMPTY,
        when(clusterState.metadata()).thenReturn(meta);
        Settings hotSettings = Settings.builder()
        ShardRouting shard = mock(ShardRouting.class);
        when(metadataBuilder.put(any(IndexMetadata.Builder.class))).thenReturn(metadataBuilder);
            clusterService,
        verify(clusterService, never()).submitStateUpdateTask(anyString(), any(ClusterStateUpdateTask.class));
            .numberOfReplicas(0)
        when(metadata.index(testIndex)).thenReturn(indexMetadata);
        verify(metadataBuilder).put(captor.capture());
        }
            resultState.blocks().hasIndexBlock(dfaIndexName, IndexMetadata.INDEX_WRITE_BLOCK)
     * Expects a cluster state task to be submitted to remove the write block.
        IndexMetadata idxMeta = IndexMetadata.builder("test-index")
import org.opensearch.core.action.ActionListener;
            Integer jvmActiveUsageThresholdPercent,
            .numberOfShards(1)
            nodeEnvironment,
        );
        // Build index metadata with tiering custom data
            "updateIndexMetadataPostTiering must not set auto_expand_replicas",
import org.opensearch.index.IndexSettings;
        ClusterState currentState = mock(ClusterState.class);
                settings,
        Metadata meta = Metadata.builder().put(dfaHotMeta, false).build();
import static org.opensearch.index.IndexModule.INDEX_TIERING_STATE;
        when(primaryShard.currentNodeId()).thenReturn("hot1");
        ClusterState clusterState = mock(ClusterState.class);
        IndexNameExpressionResolver resolver = mock(IndexNameExpressionResolver.class);
            resolver,
        when(rtMock.allShards(dfaIndexName)).thenReturn(Collections.singletonList(shard));
        when(nodes.get("node1")).thenReturn(node);
    /**
        ClusterState previousState = mock(ClusterState.class);
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
        );
    private IndexMetadata buildDfaIndexMetadata(String indexName, String uuid) {
        when(shard.started()).thenReturn(true);
            updatedMeta.getSettings().get(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey())
            org.opensearch.cluster.block.ClusterBlocks.Builder blocksBuilder,
            clusterService,
        // index is NOT in tieringIndices (cancel completed)
        ShardRouting shard = mock(ShardRouting.class);
            Settings.EMPTY,
            .blocks(blocks)
        service.clusterChanged(event);
    public void testWarmToHotTieringStart_DisablesAutoExpandReplicas() {
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
        RoutingTable rtMock = mock(RoutingTable.class);
        // Must NOT throw — the persisted HOT_TO_WARM state makes the index cancellable after failover.
            shardLimitValidator
    public void testUpdateIndexMetadataPostTiering_UpdatesCorrectly() {
        ArgumentCaptor<ClusterStateUpdateTask> taskCaptor = ArgumentCaptor.forClass(ClusterStateUpdateTask.class);
            resultState.blocks().hasIndexBlock("non-dfa-index", IndexMetadata.INDEX_WRITE_BLOCK)
        Index dfaIndex = new Index(dfaIndexName, dfaUuid);
        task.clusterStateProcessed("cancel_source", clusterState, clusterState);
        when(shard.unassigned()).thenReturn(false);
        testIndex = new Index("test-index", "uuid");
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), true)
        // non-DFA index: PLUGGABLE_DATAFORMAT_ENABLED_SETTING = false (default)
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)
            .put(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), true)
        // Result must equal the input state unchanged (no index block was found to remove)
            Settings.EMPTY,
     * Sets auto_expand_replicas: false and read_only_allow_delete: false on tiering start.
            any(ClusterStateUpdateTask.class)
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)
            shardLimitValidator
            .put(INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.HOT.toString())
        // Build DFA index metadata in HOT_TO_WARM state WITH write blocks already set
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    }
            .build();
import java.util.Map;
            Settings.EMPTY,
        when(state.getMetadata()).thenReturn(metadata);
            .build();
        when(metadata.index(testIndex)).thenReturn(indexMetadata);
    }
        assertNotEquals("true", result.metadata().index(dfaIndexName).getSettings().get(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey()));
        );
        }
        when(nodes.get("hot1")).thenReturn(hotNode);
            .put(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), true)
        when(allocationSvc.reroute(any(ClusterState.class), anyString())).thenAnswer(inv -> inv.getArgument(0));
        );
        // Replica shard: unassigned and NOT primary — satisfies s.unassigned() && !s.primary()
            .put(IndexMetadata.SETTING_INDEX_UUID, dfaUuid)
        TestTieringService service = new TestTieringService(
    public void testClusterChanged_NotClusterManager_DoesNothing() {
        CancelTieringRequest request = new CancelTieringRequest("test-index");
            resolver,
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING;
        }
            .settings(dfaHotSettingsWithBlock)
            NodeEnvironment nodeEnvironment,
import org.opensearch.cluster.node.DiscoveryNode;
            .numberOfShards(1)
        when(allocationSvc.reroute(any(ClusterState.class), anyString())).thenAnswer(inv -> inv.getArgument(0));
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
        when(currentState.metadata()).thenReturn(metadata);
import org.opensearch.common.settings.ClusterSettings;
        ) {
        IndexMetadata updatedMeta = resultState.metadata().index(dfaIndexName);
        TestTieringService service = new TestTieringService(
import org.opensearch.cluster.metadata.IndexMetadata;
        service.clusterChanged(event);
            mock(ClusterInfoService.class),
        String dfaUuid = "dfa-cleanup-uuid";
        tieringService.updateIndexMetadataForTieringCancel(metadataBuilder, indexMetadata);
        // Cover onFailure()
            clusterService,
        Settings dfaTieringSettings = Settings.builder()
        when(metadata.getIndexSafe(testIndex)).thenReturn(idxMeta);
        when(nodes.get("node1")).thenReturn(node);
            allocationSvc,
    }
            allocationSvc,
        verify(clusterService).submitStateUpdateTask(anyString(), any(ClusterStateUpdateTask.class));
        // it carries over from the source indexMetadata unchanged.
        ClusterState clusterState = mock(ClusterState.class);
        // Scan state has the block (triggers task submission)
        ShardRouting shard = mock(ShardRouting.class);
            () -> tieringService.validateTieringCancelRequest(testIndex, warmIndexMetadata, clusterState)
        when(clusterState.metadata()).thenReturn(meta);
        Metadata.Builder metadataBuilder = mock(Metadata.Builder.class);
    public void testProcessTieringInProgress_HandlesIncompleteShardRelocation() {
     * Helper: builds a ClusterChangedEvent where routingTableChanged()=true and
        nodeEnvironment = newNodeEnvironment();
        when(metadata.iterator()).thenReturn(Collections.emptyIterator());
        service.cancelTiering(request, listener, clusterState);
    public void testUpdateIndexMetadataForTieringCancel() {
        // Build cluster state with write blocks already present in ClusterBlocks
            ClusterInfoService service,
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)
        ClusterChangedEvent event = mock(ClusterChangedEvent.class);
            clusterService,
            .put(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), true)
    public void testValidateTieringCancelRequest_AlreadyReachedTargetTier() {
        service.tieringIndices.add(dfaIndex);
            .put(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), true)
            Set<Index> tieringEntries,
        DiscoveryNode node = mock(DiscoveryNode.class);
        Settings dfaWarmSettings = Settings.builder()
        protected Setting<Integer> getMaxConcurrentTieringRequestsSetting() {
        IllegalArgumentException e = expectThrows(
            .metadata(meta)
            .build();
        protected org.opensearch.cluster.block.ClusterBlocks.Builder getTieringStartClusterBlocksToAdd(
        when(node.isWarmNode()).thenReturn(true);
     * Direction-agnostic fallback: a WARM_TO_HOT index not tracked in memory is also accepted.
        service.clusterChanged(event);
            mock(ClusterInfoService.class),
            resolver,
        ClusterChangedEvent event = buildRoutingTableChangedEvent(clusterState);
        when(clusterService.state()).thenReturn(clusterState);
    }
        Setting.Property.NodeScope
    }
        when(nodes.get("node1")).thenReturn(node);
        public TestTieringService(
        );
            .settings(dfaHotSettings)
        assertNotNull(result);
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
        when(shard.unassigned()).thenReturn(false);
    }
            resolver,
        Settings tieringSettings = Settings.builder()
            shardLimitValidator
            .routingTable(rt)
        ) {
        Metadata.Builder metadataBuilder = mock(Metadata.Builder.class);
        TestTieringService service = new TestTieringService(
        when(clusterState.metadata()).thenReturn(meta);
        ClusterChangedEvent event = buildRoutingTableChangedEvent(mockScanState);
            mock(ClusterInfoService.class),
    public void testUpdateIndexMetadataForTieringStart_ZeroReplicas_SetsNumberOfReplicasToOne() {
     * (write block already removed by another task) — execute() must skip and produce no change.
            .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
            .numberOfShards(1)
            nodeEnvironment,
        verify(metadataBuilder).put(captor.capture());
    /**
    public void testValidateTieringCancelRequest_NotInMemoryButHotToWarm_Accepted() {
            () -> tieringService.updateIndexMetadataForTieringStart(metadataBuilder, routingTableBuilder, badMetadata, testIndex)
            .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
        when(clusterState.metadata()).thenReturn(clusterMeta);
        protected Settings getIndexTierSettingsToRestoreAfterCancellation(IndexMetadata indexMetadata) {
                .put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true)
        when(mockScanState.metadata()).thenReturn(scanMeta);
        w2hService.tier(request, listener, warmState);
    }
            .numberOfShards(1)
        when(resolver.concreteIndices(any(), any(), eq("test-index"))).thenReturn(new Index[] { testIndex });
            .validateTieringRequest(any(), any(), any(), any(), any(), any());
    /**
        TestTieringService service = new TestTieringService(
        assertNotNull(result);
        @Override
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
 *
            .numberOfShards(1)
            clusterService,
        ArgumentCaptor<ClusterStateUpdateTask> taskCaptor = ArgumentCaptor.forClass(ClusterStateUpdateTask.class);
        // The ReplicationTracker requires a replica to avoid assertion failures on warm nodes.
import org.opensearch.index.IndexModule;
        when(routingTable.hasIndex(testIndex)).thenReturn(false);
    public void testUpdateIndexMetadataForTieringStart_OneReplica_DoesNotUpdateRoutingTable() {
        IndexNameExpressionResolver resolver = mock(IndexNameExpressionResolver.class);
    }
        tieringService.processTieringInProgress(clusterState, "test_source");
        assertEquals(
        @Override
        IndexMetadata badMetadata = mock(IndexMetadata.class);
        // Create a WarmToHot-style tiering service that sets read_only_allow_delete: false on start
            .numberOfShards(1)
        assertEquals(
            clusterService,
            nodeEnvironment,
        assertEquals(1, tieringService.tieringIndices.size());
        TestTieringService service = new TestTieringService(
        ArgumentCaptor<ClusterStateUpdateTask> taskCaptor = ArgumentCaptor.forClass(ClusterStateUpdateTask.class);
            return Settings.builder()
     * persisted state shows a HOT_TO_WARM migration in progress. Cancel must be accepted (no throw)
        verify(metadataBuilder).put(captor.capture());
     */
                .put(IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS, "false")
        when(rtMock.allShards(dfaIndexName)).thenReturn(Collections.singletonList(shard));
        ClusterChangedEvent event = buildRoutingTableChangedEvent(clusterState);
    private ShardLimitValidator shardLimitValidator;
        when(clusterState.routingTable()).thenReturn(mock(RoutingTable.class));
    public void testTier_NonDfaIndex_DoesNotAddWriteBlocksToClusterBlocks() throws Exception {
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
        DiscoveryNodes currentNodes = mock(DiscoveryNodes.class);
        service.tieringIndices.add(testIndex);
        when(nodes.get("hot1")).thenReturn(hotNode);
            Settings.EMPTY,
        RoutingTable.Builder routingTableBuilder = mock(RoutingTable.Builder.class);
        when(event.routingTableChanged()).thenReturn(false);
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
            resultState.blocks().hasIndexBlock(dfaIndexName, IndexMetadata.INDEX_WRITE_BLOCK)
            .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)
        IndexMetadata updatedMetadata = captor.getValue().build();
            .build();
        Metadata meta = Metadata.builder().put(dfaHotMeta, false).build();
        String dfaIndexName = "dfa-unassigned-primary";
            .build();
            .settings(zeroReplicaSettings)
        IndexMetadata w2hMetadata = IndexMetadata.builder("test-index").settings(w2hSettings).numberOfShards(1).numberOfReplicas(1).build();
    private ClusterState clusterState;
                Settings.EMPTY,
import java.util.Set;
        ClusterStateUpdateTask capturedTask = taskCaptor.getValue();
        assertFalse(
        // Settings without write block (already removed before execute runs)
            Integer jvmActiveUsageThresholdPercent,
        ClusterStateUpdateTask task = taskCaptor.getValue();
        IndexMetadata tieringMeta = IndexMetadata.builder("test-index")
            .numberOfReplicas(1)
        when(clusterState.metadata()).thenReturn(meta);
        when(nodes.get("hot1")).thenReturn(hotNode);
     * This test verifies that tier() completes successfully for DFA H2W without touching ClusterBlocks.
import org.opensearch.index.store.remote.filecache.FileCacheSettings;
            .build();
        tieringService.updateIndexMetadataPostTiering(metadataBuilder, indexMetadata);
            .build();
        verify(metadataBuilder).updateNumberOfReplicas(eq(1), any(String[].class));
        String dfaUuid = "dfa-execute-uuid";
        super.tearDown();
        when(shard.started()).thenReturn(false);
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    public void testWarmToHotTieringStart_RemovesReadOnlyAllowDeleteBlock() {
            nodeEnvironment,
        RoutingTable.Builder routingTableBuilder = mock(RoutingTable.Builder.class);
            .metadata(meta)
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
        // INDEX_WRITE_BLOCK must be removed from ClusterBlocks
        return IndexMetadata.builder(indexName).settings(dfaSettings).numberOfShards(1).numberOfReplicas(1).build();
            .settings(nonDfaSettings)
        // DFA index in HOT state with write block still set (orphaned from H2W cancel)
import org.opensearch.cluster.ClusterStateUpdateTask;
    public void testTier_HandlesValidationFailure() {
        ClusterState currentState = mock(ClusterState.class);
    public void testGetTieringStatus_IndexBeingTiered() {
            resultState.blocks().hasIndexBlock("non-dfa-index", IndexMetadata.INDEX_WRITE_BLOCK)
        when(nodes.get("hot1")).thenReturn(hotNode);
            .put(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), true)
        when(currentState.getNodes()).thenReturn(nodes);
        when(node.isWarmNode()).thenReturn(true);
        verify(clusterService, org.mockito.Mockito.atLeastOnce()).submitStateUpdateTask(anyString(), taskCaptor.capture());
        RoutingTable routingTable = mock(RoutingTable.class);
        tieringService.updateIndexMetadataForTieringStart(metadataBuilder, routingTableBuilder, indexMetadata, testIndex);
            .put(INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.HOT.toString())
    }
import static org.mockito.Mockito.eq;
    public void testReconstructInProgressTieringRequests() {
     * localNodeClusterManager()=true but previousNodes.isLocalNodeElectedClusterManager()=true
        verify(clusterService, never()).submitStateUpdateTask(org.mockito.Mockito.contains("remove-write-block"), any());
        IndexNameExpressionResolver resolver = mock(IndexNameExpressionResolver.class);
     * Shards are still relocating (not all started on hot) — no task submitted, block kept.
            resultState.blocks().hasIndexBlock(dfaIndexName, IndexMetadata.INDEX_WRITE_BLOCK)
        RoutingTable rtMock = mock(RoutingTable.class);
        assertThat(e.getMessage(), org.hamcrest.Matchers.containsString("already reached its target tier"));
        when(previousState.nodes()).thenReturn(previousNodes);
            tieringService.getTargetTieringState().toString(),
        service.tier(request, listener, initialState);
        assertTrue("Index should be added to tieringIndices", service.tieringIndices.contains(testIndex));
        TestTieringService service = new TestTieringService(
        Metadata realMetadata = Metadata.builder().put(indexMetadata, false).build();
        DiscoveryNode node = mock(DiscoveryNode.class);
    //
    public void testRemoveWriteBlock_Execute_NullGuard_IndexDeletedBetweenScanAndTask() throws Exception {
            resolver,
     */
        RoutingTable routingTable = mock(RoutingTable.class);
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            "INDEX_WRITE_BLOCK must be REMOVED from ClusterBlocks after W2H tier start for DFA index",
            Integer maxConcurrentTieringRequests,
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)
            Settings.EMPTY,
import org.opensearch.cluster.ClusterInfoService;
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        Metadata.Builder metadataBuilder = mock(Metadata.Builder.class);
     * Failover case: the in-memory tiering set was lost (e.g., cluster-manager change), but the
        RoutingTable realRt = RoutingTable.builder().addAsNew(realMetadata.index("test-index")).build();
        when(nodes.get("node1")).thenReturn(node);
        assertEquals("1", updatedMetadata.getSettings().get(IndexMetadata.SETTING_NUMBER_OF_REPLICAS));
            super(
        assertFalse(
    }
        ClusterState executeState = ClusterState.builder(org.opensearch.cluster.ClusterName.DEFAULT)
        // Verify that WarmToHotTieringService's getTieringStartSettingsToAdd includes
        when(mockScanState.routingTable()).thenReturn(rtMock);
    private IndexMetadata indexMetadata;
        TestWarmToHotTieringService warmToHotService = new TestWarmToHotTieringService(
        ClusterState warmState = ClusterState.builder(ClusterName.DEFAULT)
        ClusterState resultState = taskCaptor.getValue().execute(initialState);
        IndexNameExpressionResolver resolver = mock(IndexNameExpressionResolver.class);
            .put(INDEX_TIERING_STATE.getKey(), "HOT")
        ClusterState result = taskCaptor.getValue().execute(realState);
     * snaps back to hot quickly but one replica may remain unassigned until a node becomes available.
        indexNameExpressionResolver = mock(IndexNameExpressionResolver.class);
    /**
import org.opensearch.common.settings.Settings;
        );
        RoutingTable rt = RoutingTable.builder().addAsNew(meta.index(dfaIndexName)).build();
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    }
     * Non-DFA index with write block in HOT state — must be completely ignored.
            allocationSvc,
            NodeEnvironment nodeEnvironment,
import static org.mockito.Mockito.anyInt;
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        IndexMetadata dfaMeta = buildDfaIndexMetadata(dfaIndexName, dfaUuid);
    public void testRemoveWriteBlock_IndexStillInTieringIndices_Skipped() {
        DiscoveryNodes previousNodes = mock(DiscoveryNodes.class);
        ArgumentCaptor<IndexMetadata.Builder> captor = ArgumentCaptor.forClass(IndexMetadata.Builder.class);
        when(mockState.getNodes()).thenReturn(nodes);
            .numberOfReplicas(1)
        ClusterState mockState = mock(ClusterState.class);
        when(clusterState.metadata()).thenReturn(metadata);
    }
        Metadata executeMeta = Metadata.builder().put(dfaHotMeta, false).build();
        }
    public void testCancelTiering_DfaIndex_KeepsWriteBlocksDuringCancel() throws Exception {
        when(clusterState.metadata()).thenReturn(metadata);
            mock(AllocationService.class),
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        verify(listener).onFailure(any(IllegalArgumentException.class));
     */
     */
            Integer maxConcurrentTieringRequests,
            shardLimitValidator
            resolver,
        // Cover timeout()
        tieringService.tieringIndices.add(testIndex);
        verify(clusterService).submitStateUpdateTask(anyString(), taskCaptor.capture());
            mock(ClusterInfoService.class),
        when(allocationSvc.reroute(any(ClusterState.class), anyString())).thenAnswer(inv -> inv.getArgument(0));
    }
        IndexMetadata badMetadata = mock(IndexMetadata.class);
        when(clusterState.metadata()).thenReturn(metadata);
            mock(AllocationService.class),
            .numberOfShards(1)
    /**
     */
            mock(IndexNameExpressionResolver.class),
            mock(IndexNameExpressionResolver.class),
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
        IndexNameExpressionResolver resolver = mock(IndexNameExpressionResolver.class);
        ClusterState realState = ClusterState.builder(org.opensearch.cluster.ClusterName.DEFAULT)
        Metadata metadata = mock(Metadata.class);
            .build();
        }
                shardLimitValidator
        );
            clusterService,
        when(shard.currentNodeId()).thenReturn("node1");
            // INDEX_BLOCKS_WRITE not set → false (block already removed)
        IndexMetadata oneReplicaIndex = IndexMetadata.builder("test-index")
            mock(ClusterInfoService.class),
            "blocks.blocks.write must be false in IndexMetadata settings after W2H tier start for DFA index",
     * <p>This is the negative complement of the unassigned-replica case: we must NOT lift
            mock(AllocationService.class),
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
        service.tier(request, listener, clusterState);
        DiscoveryNode node = mock(DiscoveryNode.class);
        ArgumentCaptor<ClusterStateUpdateTask> taskCaptor = ArgumentCaptor.forClass(ClusterStateUpdateTask.class);
            .put(dfaHotSettingsNoBlock)
        List<ShardRouting> shardRoutings = Collections.singletonList(shard);
            resolver,
 * compatible open source license.
            shardLimitValidator
            .numberOfReplicas(1)
        tieringService.updateIndexMetadataForTieringStart(metadataBuilder, routingTableBuilder, oneReplicaIndex, testIndex);
        IndexMetadata updatedMetadata = captor.getValue().build();
            .routingTable(rt)
    // The method is private and triggered via clusterChanged() when
        service.clusterChanged(event);
            mock(IndexNameExpressionResolver.class),
        when(clusterState.blocks()).thenReturn(blocks);
        // When user already has replicas: 1, updateNumberOfReplicas must NOT be called —
    }
        ClusterState realState = ClusterState.builder(org.opensearch.cluster.ClusterName.DEFAULT)
        ClusterState initialState = ClusterState.builder(ClusterName.DEFAULT)
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)
            mock(ClusterInfoService.class),
            .blocks(blocksWithWriteBlock)
            .put(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), true)
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
            .put(INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.WARM_TO_HOT.toString())
            .metadata(executeMeta)
            .build();
                clusterService,
        when(clusterService.getClusterSettings()).thenReturn(mockSettings);
    }
            updatedMetadata.getSettings().get(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey())
    }
    /**
            .routingTable(rt)
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)
        RoutingTable rt = mock(RoutingTable.class);
            clusterService,
            .put(INDEX_TIERING_STATE.getKey(), HOT_TO_WARM.toString())
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)
            nodeEnvironment,
        // INDEX_BLOCKS_WRITE setting must be false in IndexMetadata
        when(event.state()).thenReturn(currentState);
        service.tieringIndices.add(testIndex);
        String dfaIndexName = "dfa-deleted-index";
    }
            .put(IndexMetadata.SETTING_INDEX_UUID, dfaUuid)
        verify(listener).onFailure(thrown);
        ArgumentCaptor<ClusterStateUpdateTask> taskCaptor = ArgumentCaptor.forClass(ClusterStateUpdateTask.class);
            .settings(dfaHotSettings)
    }
     * <p>This is the canonical scenario after H2W cancel with auto_expand_replicas: the primary
        when(previousState.nodes()).thenReturn(previousNodes);
        Metadata metadata = mock(Metadata.class);
        // getIndexTierClusterBlocksToRestoreAfterCancellation intentionally uses the base class no-op:
            shardLimitValidator
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        tieringCustomData.put("test_tiering_start_time", "1234567");
            nodeEnvironment,
            mock(AllocationService.class),
            .build();
            mock(AllocationService.class),
            return blocksBuilder.removeIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK)
        assertFalse("Index should be removed after cancel", service.tieringIndices.contains(testIndex));
        );
        when(primaryShard.primary()).thenReturn(true);
                .put(INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.WARM_TO_HOT)
            shardLimitValidator
        assertTrue("Index should remain in tieringIndices", tieringService.tieringIndices.contains(testIndex));
     * TieringService.removeWriteBlockForCancelledDfaIndices() once all shards are confirmed started
            shardLimitValidator
        RoutingTable routingTable = mock(RoutingTable.class);
        clusterService = mock(ClusterService.class);
        when(resolver.concreteIndices(any(), any(), eq("test-index"))).thenReturn(new Index[] { testIndex });
package org.opensearch.storage.tiering;
        @Override
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        service.clusterChanged(event);
    }
            return "w2h_tiering_start_time";
            .metadata(meta)
        protected IndexModule.TieringState getTargetTieringState() {
        // No exception means reconstruction was called successfully
        ClusterState previousState = mock(ClusterState.class);
    Setting<Integer> maxConcurrentTieringRequestsSetting = Setting.intSetting(
        ClusterChangedEvent event = buildRoutingTableChangedEvent(clusterState);
        // allOnHot=false → no task submitted
     * set blocks.write=false and blocks.read_only_allow_delete=false in IndexMetadata settings.
            "false",
        when(clusterState.routingTable()).thenReturn(routingTable);
        Index dfaIndex = new Index(dfaIndexName, dfaUuid);
        // the conditional branch `if (currentReplicas != 1)` is not entered.
        service.tieringIndices.add(dfaIndex);
                .put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true)
     * Happy path: DFA index in HOT state with write block, all shards started on hot nodes.
     * INDEX_WRITE_BLOCK and INDEX_WRITE_BLOCK from ClusterBlocks AND
        assertFalse(tieringService.isIndexBeingTiered(testIndex));
        assertTrue("Index should not be in tieringIndices", spyService.tieringIndices.isEmpty());
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "100b")
            .metadata(Metadata.EMPTY_METADATA)
            mock(ClusterInfoService.class),
    }
            .numberOfReplicas(1)
        ClusterState clusterState = mock(ClusterState.class);
        RoutingTable rtMock = mock(RoutingTable.class);
        assertEquals("test-index", status.getIndexName());
                nodeEnvironment,
        when(event.blocksChanged()).thenReturn(false);
        Metadata meta = Metadata.builder().put(dfaHotMeta, false).build();
                .put(INDEX_TIERING_STATE.getKey(), HOT_TO_WARM)
        String dfaIndexName = "dfa-still-tiering";
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
import org.opensearch.cluster.ClusterChangedEvent;
            nodeEnvironment,
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        // s.unassigned() && !s.primary() → false (it IS the primary)
import static org.mockito.Mockito.spy;
        RoutingTable routingTable = mock(RoutingTable.class);
            .settings(dfaWarmSettings)
            mock(AllocationService.class),
        when(shard.started()).thenReturn(true);
        @Override
        Metadata meta = Metadata.builder().put(nonDfaMeta, false).build();
        when(clusterState.metadata()).thenReturn(metadata);
        Metadata scanMeta = Metadata.builder().put(dfaHotMetaWithBlock, false).build();
        assertThat(e.getMessage(), org.hamcrest.Matchers.containsString("deleted before tiering cancellation"));
        Metadata meta = Metadata.builder().put(dfaTieringMeta, false).build();
        Index idx = new Index(indexName, uuid);
        Metadata meta = Metadata.builder().put(dfaHotMeta, false).build();
        assertNotNull("execute() must return a non-null state even when index was deleted", result);
        IndexTieringRequest request = new IndexTieringRequest("WARM", "test-index");
        Settings warmSettings = Settings.builder()
        );
        ClusterState result = taskCaptor.getValue().execute(executeState);
        String dfaIndexName = "dfa-relocating";
                .build();
            resolver,
        when(clusterState.getNodes()).thenReturn(nodes);
            shardLimitValidator
        IndexNameExpressionResolver resolver = mock(IndexNameExpressionResolver.class);
    public void testValidateTieringCancelRequest_NotInMemoryButWarmToHot_Accepted() {
        verify(metadataBuilder).put(any(IndexMetadata.Builder.class));
        when(clusterState.routingTable()).thenReturn(mock(RoutingTable.class));
            // PLUGGABLE_DATAFORMAT_ENABLED_SETTING not set → defaults to false
            indexNameExpressionResolver,
        ClusterState clusterState = mock(ClusterState.class);
        Settings dfaHotSettings = Settings.builder()
    public void testRemoveWriteBlock_Execute_ToctouGuard_SkipsIfBlockAlreadyRemoved() throws Exception {
     * via the isMigrationInProgress fallback.
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            .build();
        assertFalse(
            zeroReplicaMetadata,
import static org.mockito.Mockito.any;
        RoutingTable rt = RoutingTable.builder().addAsNew(meta.index(dfaIndexName)).build();
            nodeEnvironment,
        ClusterChangedEvent event = mock(ClusterChangedEvent.class);
            .numberOfReplicas(0)
            .numberOfReplicas(1)
        when(previousNodes.isLocalNodeElectedClusterManager()).thenReturn(true);
        );
    }
        ClusterState realState = ClusterState.builder(org.opensearch.cluster.ClusterName.DEFAULT).metadata(emptyMetadata).build();
        assertFalse("Precondition: index must not be tracked in memory", tieringService.isIndexBeingTiered(testIndex));
        IndexMetadata dfaHotMeta = IndexMetadata.builder(dfaIndexName)
        ClusterState mockScanState = mock(ClusterState.class);
        assertFalse(
        service.clusterChanged(event);
     * Boundary: a terminal WARM index that is NOT tracked in memory must still be rejected —
        // Build index with 1 replica (already at target)
        Metadata meta = Metadata.builder().put(dfaWarmMeta, false).build();
        ClusterState mockScanState = mock(ClusterState.class);
        RoutingTable.Builder routingTableBuilder = mock(RoutingTable.Builder.class);
    public void testListTieringStatus_WithTieringIndex() {
        when(event.localNodeClusterManager()).thenReturn(false);
            .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)
            new TestTieringService(
        ClusterState resultState = taskCaptor.getValue().execute(warmState);
     * and sets INDEX_BLOCKS_WRITE=false in IndexMetadata settings.
        when(mockScanState.getNodes()).thenReturn(nodes);
        when(routingTable.hasIndex(testIndex)).thenReturn(true);
        when(clusterState.routingTable()).thenReturn(rtMock);
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
        ClusterChangedEvent event = buildRoutingTableChangedEvent(clusterState);
        when(metadataBuilder.put(any(IndexMetadata.Builder.class))).thenReturn(metadataBuilder);
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
        when(shard.currentNodeId()).thenReturn("hot1");
            .put(IndexMetadata.SETTING_INDEX_UUID, "uuid-zero-replicas")
        assertNotNull(result);
    }
        when(shard.unassigned()).thenReturn(false);
            .build();
        IndexMetadata warmIndexMetadata = IndexMetadata.builder("test-index")
    public void testUpdateClusterStateTask_IndexDeletedDuringExecution() throws Exception {
        IndexNameExpressionResolver resolver = mock(IndexNameExpressionResolver.class);
        verify(routingTableBuilder).updateNumberOfReplicas(eq(1), any(String[].class));
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        // When user has replicas: 0, number_of_replicas should be forced to 1 for routing table consistency.
import org.opensearch.cluster.ack.ClusterStateUpdateResponse;
        super.setUp();
        // Execute the captured task against a real cluster state that still has the block
        @Override
            result.blocks().hasIndexBlock(dfaIndexName, IndexMetadata.INDEX_WRITE_BLOCK)
        when(event.metadataChanged()).thenReturn(false);
        CancelTieringRequest cancelRequest = new CancelTieringRequest(dfaIndexName);
    public void tearDown() throws Exception {
     *
            mock(ClusterInfoService.class),
        // Execute state: index has been deleted
            Settings.EMPTY,
        );
        tieringService.updateIndexMetadataPostTiering(metadataBuilder, indexMetadata);
            updatedMeta.getSettings().get(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey())
        service.cancelTiering(cancelRequest, listener, stateWithBlocks);
        );
        @Override
        String indexName = "non-dfa-hot";
        assertFalse("Precondition: index must not be tracked in memory", tieringService.isIndexBeingTiered(testIndex));
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        IndexMetadata updatedMetadata = captor.getValue().build();
            .build();
        verify(clusterService).submitStateUpdateTask(anyString(), taskCaptor.capture());
            .put(INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.HOT_TO_WARM.toString())
        when(state.routingTable()).thenReturn(rt);
            .settings(dfaHotSettingsNoBlock)
    }
        TestTieringService service = new TestTieringService(
        Settings nonDfaSettings = Settings.builder()
        );
        ClusterState previousState = mock(ClusterState.class);
        ClusterBlocks blocksWithBlock = ClusterBlocks.builder().addIndexBlock(dfaIndexName, IndexMetadata.INDEX_WRITE_BLOCK).build();
        // Primary shard: started on a hot node
        ClusterState resultState = taskCaptor.getValue().execute(stateWithBlocks);
            .build();
    );
        // execute() with deleted-index state must not throw
        tieringService.reconstructInProgressTieringRequests(clusterState, HOT_TO_WARM, "test_source");
        RoutingTable rtMock = mock(RoutingTable.class);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        @Override
        // Pass a DFA index metadata so the W2H subclass returns its full settings
        RoutingTable routingTable = mock(RoutingTable.class);
        protected String getTieringStartTimeKey() {
        );
            .numberOfReplicas(1)
                .put(INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.WARM)
            OpenSearchException.class,
            nodeEnvironment,
    }
        ClusterState state = mock(ClusterState.class);
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)
            Settings.EMPTY,
        IndexMetadata warmMetadata = IndexMetadata.builder("test-index")
        ActionListener<ClusterStateUpdateResponse> listener = mock(ActionListener.class);
        spyService.tier(request, listener, clusterState);
            Settings.EMPTY,
        when(mockScanState.routingTable()).thenReturn(rtMock);
        Metadata meta = Metadata.builder().put(dfaHotMeta, false).build();
        verify(routingTableBuilder).updateNumberOfReplicas(eq(1), any(String[].class));
            "No INDEX_WRITE_BLOCK should be present — TOCTOU guard must have skipped this index",
        ArgumentCaptor<IndexMetadata.Builder> captor = ArgumentCaptor.forClass(IndexMetadata.Builder.class);
        // Use a real ClusterState where the index doesn't exist in metadata
            .put(INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.HOT.toString())
        service.tieringIndices.add(testIndex);
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            mock(AllocationService.class),
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)
            .put(INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.HOT.toString())
            mock(ClusterInfoService.class),
        when(routingTable.hasIndex(testIndex)).thenReturn(true);
            "false",
            Settings settings,
            AllocationService allocationService,
        verify(clusterService, never()).submitStateUpdateTask(org.mockito.Mockito.contains("remove-write-block"), any());
        Metadata meta = Metadata.builder().put(dfaMeta, false).build();
            .build();
            .put(IndexMetadata.SETTING_INDEX_UUID, uuid)
        when(nodes.get("node1")).thenReturn(node);
        Metadata.Builder metadataBuilder = mock(Metadata.Builder.class);
        );
        assertEquals("false", result.metadata().index(dfaIndexName).getSettings().get(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey()));
        RoutingTable routingTable = mock(RoutingTable.class);
            .settings(tieringSettings)
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)
     * The write blocks are added by TransportHotToWarmTierAction.addReadOnlyBlockAndPrepare()
        tieringService.tieringIndices.add(testIndex);
        verify(clusterService).submitStateUpdateTask(anyString(), taskCaptor.capture());
        tieringService.processTieringInProgress(clusterState, "test_source");
        protected IndexModule.TieringState getTargetTieringState() {
        when(resolver.concreteIndices(any(), any(), eq("bad-index"))).thenThrow(new IllegalArgumentException("Index not found"));
            mock(ClusterInfoService.class),
        when(routingTable.hasIndex(testIndex)).thenReturn(true);
            .build();
        Metadata meta = Metadata.builder().put(dfaHotMeta, false).build();
        when(clusterState.routingTable()).thenReturn(routingTable);
            IndexMetadata indexMetadata
            .build();
     * The write block is intentionally deferred — it must not be lifted during cancel because some
    public void testUpdateIndexMetadataForTieringCancel_ThrowsOnError() {
        TestTieringService service = new TestTieringService(
        verify(clusterService, org.mockito.Mockito.atLeastOnce()).submitStateUpdateTask(
        when(shard.started()).thenReturn(true);
        );
        // was in the original index metadata (null if never explicitly set).
        // Verify number_of_replicas=1 is set atomically in both metadata and routing table
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            Settings.EMPTY,
     */
            mock(ClusterInfoService.class),
        when(rtMock.hasIndex(dfaIndex)).thenReturn(true);
        when(hotNode.isWarmNode()).thenReturn(false);
        indexMetadata = IndexMetadata.builder("test-index").settings(indexSettings).numberOfShards(1).numberOfReplicas(2).build();
            .put(IndexMetadata.SETTING_INDEX_UUID, dfaUuid)
            .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)
            nodeEnvironment,
        // The cancel task only sets IS_WARM=false and TIERING_STATE=HOT — it does not touch blocks.write.
            .build();
        String dfaIndexName = "dfa-toctou-index";
            )
        when(event.previousState()).thenReturn(previousState);
        IllegalArgumentException e = expectThrows(
            mock(ClusterInfoService.class),
        when(badMetadata.getIndex()).thenReturn(new Index("bad-index", "bad-uuid"));
        ClusterChangedEvent event = buildRoutingTableChangedEvent(clusterState);
        ) {
        tieringService.reconstructInProgressTieringRequests(clusterState, HOT_TO_WARM, "test_source");
        Metadata.Builder metadataBuilder = mock(Metadata.Builder.class);
            org.mockito.Mockito.contains("remove-write-block"),
        when(clusterService.state()).thenReturn(state);
     * Builds a DFA (pluggable dataformat enabled) IndexMetadata for block tests.
        service.tieringIndices.add(testIndex);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        }
                allocationService,
            );
        IndexMetadata dfaHotMetaWithBlock = IndexMetadata.builder(dfaIndexName)
            .build();
            .put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true)
        IndexMetadata dfaHotMeta = IndexMetadata.builder(dfaIndexName)
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
        // Scan state: index exists with write block
        public TestWarmToHotTieringService(
            updatedMeta.getSettings().get(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey())
            .build();
        when(shard.currentNodeId()).thenReturn("node1");
        );
        String uuid = "non-dfa-hot-uuid";
        when(rtMock.hasIndex(dfaIndex)).thenReturn(true);
        // Cover execute()
    }
        assertFalse(
        RoutingTable rtMock = mock(RoutingTable.class);
        when(routingTable.allShards(testIndex.getName())).thenReturn(Collections.singletonList(shard));
        ShardRouting shard = mock(ShardRouting.class);
        when(rtMock.hasIndex(dfaIndex)).thenReturn(true);
        service.tier(request, listener, clusterState);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        tieringService.tieringIndices.add(testIndex);
import org.opensearch.cluster.ClusterName;
        verify(listener).onFailure(any(RuntimeException.class));
            .numberOfReplicas(1)
        1000,
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        Setting.Property.Dynamic,
            .settings(oneReplicaSettings)
            .build();
        verify(listener).onResponse(any(ClusterStateUpdateResponse.class));
            mock(AllocationService.class),
        TestTieringService service = new TestTieringService(
     * isDfaIndex() checks IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING = true.
        assertNull("Tiering custom metadata should be removed", updatedMetadata.getCustomData(TIERING_CUSTOM_KEY));
            .settings(idxSettings)
            shardLimitValidator
        ClusterState stateWithBlocks = ClusterState.builder(ClusterName.DEFAULT)
        // Execute with null indexMetadata — covers the null check branch
    }
        Metadata metadata = mock(Metadata.class);
            .put(INDEX_TIERING_STATE.getKey(), HOT_TO_WARM.toString())
        when(routingTable.hasIndex(testIndex)).thenReturn(true);
            mock(ClusterInfoService.class),
        ActionListener<ClusterStateUpdateResponse> listener = mock(ActionListener.class);
        DiscoveryNodes previousNodes = mock(DiscoveryNodes.class);
     * We must not block write-block removal waiting for those replicas.
        IndexMetadata updatedMetadata = captor.getValue().build();
    }
    }
        when(mockScanState.getNodes()).thenReturn(nodes);
        assertNotNull(task.timeout());
        assertTrue(tieringService.isIndexBeingTiered(testIndex));
            .put(INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.HOT.toString())
        when(clusterState.getNodes()).thenReturn(nodes);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        IndexMetadata updatedMetadata = captor.getValue().build();
        assertThat(e.getMessage(), org.hamcrest.Matchers.containsString("not currently undergoing tiering operation"));
        Settings dfaHotSettings = Settings.builder()
        // Trigger via clusterChanged
            .build();
            clusterService,
        ArgumentCaptor<IndexMetadata.Builder> captor = ArgumentCaptor.forClass(IndexMetadata.Builder.class);
                nodeEnvironment,
            return IndexModule.TieringState.HOT;
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        // overrides this with "0-{max(1, currentReplicas)}" for the tiering start phase,
        IndexMetadata idxMeta = IndexMetadata.builder("test-index").settings(idxSettings).numberOfShards(1).numberOfReplicas(1).build();
            .put(IndexMetadata.SETTING_INDEX_UUID, "non-dfa-uuid")
        when(clusterState.metadata()).thenReturn(metadata);
        // Shard is on a hot node, target is WARM → not in target tier
        // Cover onFailure — should not throw
     * Null guard inside execute(): index deleted between scan and task execution —
        when(resolver.concreteIndices(any(), any(), eq("test-index"))).thenReturn(new Index[] { testIndex });
        service.tier(request, listener, realState);
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
        when(badMetadata.getSettings()).thenThrow(new RuntimeException("simulated"));
        when(shard.unassigned()).thenReturn(false);
            .build();
            resolver,
        service.clusterChanged(event);
            .settings(dfaHotSettings)
     *
                .build();
            .build();
import java.util.List;
    /**
            Settings.EMPTY,
        verify(clusterService).submitStateUpdateTask(anyString(), taskCaptor.capture());
        AllocationService allocationSvc = mock(AllocationService.class);
            .put(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), true)
        // ClusterBlocks should remain unchanged (empty).
    public void testCancelTiering_ExecuteTask() throws Exception {
        verify(clusterService, org.mockito.Mockito.atLeastOnce()).submitStateUpdateTask(anyString(), taskCaptor.capture());
            Set<Index> tieringEntries,
            .metadata(meta)
            .put(INDEX_TIERING_STATE.getKey(), "HOT")
        IndexNameExpressionResolver resolver = mock(IndexNameExpressionResolver.class);
        when(previousNodes.isLocalNodeElectedClusterManager()).thenReturn(false);
        when(rtMock.allShards(dfaIndexName)).thenReturn(Collections.singletonList(shard));
        ActionListener<ClusterStateUpdateResponse> listener = mock(ActionListener.class);
            .put(IndexMetadata.SETTING_INDEX_UUID, dfaUuid)
    private NodeEnvironment nodeEnvironment;
     * (primary IS a primary), and {@code s.started()} is also false.
            ClusterInfoService clusterInfoService,
    public void testUpdateIndexMetadataForTieringStart_SetsNumberOfReplicasToOneAndUpdatesRoutingTable() {
import org.opensearch.cluster.metadata.Metadata;
            allocationSvc,
    }
        String dfaIndexName = "dfa-hot-no-block";
            resolver,
        when(rt.allShards("test-index")).thenReturn(Collections.emptyList());
            clusterService,
        ) {}
        when(shard.started()).thenReturn(true);
            .build();
                .put(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), false)
        when(currentState.routingTable()).thenReturn(routingTable);
        AllocationService allocationSvc = mock(AllocationService.class);
                .put(INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.HOT)
        ShardRouting primaryShard = mock(ShardRouting.class);
        String dfaUuid = "dfa-still-tiering-uuid";
