            when(indexShard.routingEntry()).thenReturn(shardRouting);
        ThreadPool threadPool = new TestThreadPool("testThreadPoolConstantValidity");
import static org.mockito.ArgumentMatchers.anyInt;
        ScaleIndexRequest request = new ScaleIndexRequest(indexName, true);
            .build();
        // Stub allocationService.reroute to return a valid state.
        // Test successful execution
        assertTrue(successLatch.await(1, TimeUnit.SECONDS));
            allocationService,
    }
            .build();
                fail("Expected validation to fail");
import org.opensearch.cluster.node.DiscoveryNode;
        ClusterBlocks.Builder blocksBuilder = ClusterBlocks.builder();
        ClusterStateUpdateTask addBlockTask = captor.getValue();
            public void onResponse(AcknowledgedResponse response) {
        Settings indexSettings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build();
        TransportService transportService = mock(TransportService.class);
        verify(listener).onFailure(testException);
        // Create a dummy shard routing in STARTED state.
        Settings indexSettings = Settings.builder()
        ArgumentCaptor<ClusterStateUpdateTask> captor = ArgumentCaptor.forClass(ClusterStateUpdateTask.class);
        TransportScaleIndexAction action = new TransportScaleIndexAction(
        task.onFailure("test", testException);
    public void testSyncSingleShard() throws Exception {
        // Capture the update task submitted for scaling up.
                assertEquals("Index [" + indexName + "] is not in search-only mode", e.getMessage());
            .build();
            @Override
import org.opensearch.cluster.block.ClusterBlockException;
            .settings(indexSettings)
        ClusterState stateAfterReroute = ClusterState.builder(initialState).build();
            public void onResponse(AcknowledgedResponse response) {
import org.opensearch.indices.IndicesService;
            .numberOfShards(1)
        verify(shard, times(1)).waitForRemoteStoreSync();
    public void setUp() throws Exception {
                clusterService,
import org.opensearch.cluster.routing.ShardRouting;
import static org.mockito.ArgumentMatchers.any;
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
import static org.mockito.Mockito.times;
        super.setUp();
        Exception testException = new Exception("Test failure");
        blocksBuilder.addGlobalBlock(metadataBlock);
        ClusterBlock metadataBlock = new ClusterBlock(
        final AtomicReference<Exception> exceptionRef = new AtomicReference<>();
        );
        // For example, add a dummy block to the index.
        Index index = indexMetadata.getIndex();
        ClusterState initialState = ClusterState.builder(new ClusterName("test"))
            false,
            // Verify SHARD_SYNC_EXECUTOR is using the MANAGEMENT pool as expected
        threadPool = new TestThreadPool("ScaleIndexActionTests");
            .build();
        ActionListener<AcknowledgedResponse> listener = new ActionListener<>() {
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        assertTrue("Response should indicate uncommitted operations", responseRef.get().hasUncommittedOperations());
        String indexName = "test_index";
        );
import org.opensearch.cluster.routing.ShardRoutingState;
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
        ScaleIndexRequest request = new ScaleIndexRequest(indexName, false);
        verify(clusterService).submitStateUpdateTask(eq("scale-up-index"), captor.capture());
        // Verify that a block with the correct ID was added
            .blocks(ClusterBlocks.builder().build())
    }
        verify(allocationService).reroute(any(ClusterState.class), eq("restore indexing shards"));
            .build();
            @Override
            threadPool,
            .numberOfShards(1)
        };
        ShardId shardId = new ShardId(new Index("test_index", "_na_"), 0);
        ArgumentCaptor<ActionListener> successPermitCaptor = ArgumentCaptor.forClass(ActionListener.class);
        permitListenerCaptor.getValue().onResponse(mock(Releasable.class));
            RestStatus.FORBIDDEN,
        verify(shard, times(1)).flush(any(FlushRequest.class));
        Settings indexSettings = Settings.builder()
                exceptionRef.set(e);
public class TransportScaleIndexActionTests extends OpenSearchTestCase {
import org.opensearch.core.index.shard.ShardId;
        IndexMetadata indexMetadata = IndexMetadata.builder(indexName)
        // Test with no blocks
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder().add(node).localNodeId("node1").build();
        // Create test data
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            .numberOfReplicas(1)
            public void onFailure(Exception e) {
        // Verify that the appropriate block was added
            indicesService
            indexName, blockedIndices, listener
            indicesService
            .put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, 1)
        final AtomicReference<ScaleIndexShardResponse> successResponseRef = new AtomicReference<>();
            .numberOfReplicas(1)
    public void testScaleUpClusterStateUpdateTask() throws Exception {
import org.opensearch.common.lease.Releasable;
        successPermitCaptor.getValue().onResponse(mock(Releasable.class));
            }
            indexName,
import org.opensearch.core.action.ActionListener;
        // Simulate the add-block task callback (with a changed state) to trigger finalize.
import static org.mockito.Mockito.mock;
            ShardRouting shardRouting = mock(ShardRouting.class);
                any(TransportResponseHandler.class)
        assertNotEquals(initialState, newState);
        verify(shard).acquireAllPrimaryOperationsPermits(successPermitCaptor.capture(), any(TimeValue.class));
            }
        // Use a real ThreadPool but with a controlled executor
        TransportScaleIndexAction.FinalizeScaleDownTask task = action.new FinalizeScaleDownTask(indexName, listener);
        when(shard.translogStats()).thenReturn(translogStats);
            .build();
        DiscoveryNode localNode = new DiscoveryNode("local", buildNewFakeTransportAddress(), Version.CURRENT);
        // Test with metadata write block
import org.opensearch.indices.replication.common.ReplicationType;
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        final AtomicReference<Exception> successExceptionRef = new AtomicReference<>();
            .metadata(Metadata.builder().put(indexMetadata, true).build())
import org.opensearch.index.IndexService;
        action.clusterManagerOperation(request, state, listener);
        IndexMetadata indexMetadata = IndexMetadata.builder(indexName)
        action.clusterManagerOperation(request, state, listener);
        allocationService = mock(AllocationService.class);
            .numberOfReplicas(1)
import static org.mockito.ArgumentMatchers.anyString;
            }).when(indexShard).acquireAllPrimaryOperationsPermits(any(ActionListener.class), any(TimeValue.class));
                successExceptionRef.set(e);
import org.opensearch.core.rest.RestStatus;
        when(clusterService.state()).thenReturn(initialState);
        String indexName = "test_index";
import java.util.List;
    @Before
        return ClusterState.builder(new ClusterName("test")).metadata(Metadata.builder().put(indexMetadata, true).build()).build();
            @Override
        String indexName = "test_index";
            indicesService
        ScaleIndexRequest request = new ScaleIndexRequest(indexName, true);
        // Mock dependencies
        ClusterState state = ClusterState.builder(new ClusterName("test"))
            clusterService,
        clusterService = mock(ClusterService.class);
            .metadata(Metadata.builder().put(indexMetadata, true))
        // Execute the scale-down operation.
        TransportChannel channel = mock(TransportChannel.class);
 * compatible open source license.
        addBlockTask.clusterStateProcessed("test-source", initialState, newState);
            .build();
                responseRef.set(response);
            @Override
                assertTrue(e instanceof IllegalStateException);
                fail("Should fail when search-only is not enabled");
            IndexShard indexShard = mock(IndexShard.class);
            @Override
            }
                successLatch.countDown();
            public void onFailure(Exception e) {
        IndicesService indicesService = mock(IndicesService.class);
            .build();
            .numberOfShards(1)
 */
import org.opensearch.cluster.block.ClusterBlock;
            public void onResponse(ScaleIndexShardResponse response) {
        // Create index metadata with search-only mode enabled.
            threadPool,
            assertEquals(
        ClusterState newState = ClusterState.builder(initialState).blocks(blocksBuilder).build();
import org.opensearch.threadpool.TestThreadPool;
            );
            .metadata(Metadata.builder().put(indexMetadata, true))
        RoutingTable routingTable = RoutingTable.builder().add(indexRoutingTable).build();
import org.opensearch.Version;
        // Create minimal index metadata that meets scale-down prerequisites.
            // Mock the acquireAllPrimaryOperationsPermits method to immediately call the listener
                assertEquals("Index [" + indexName + "] is already in search-only mode", e.getMessage());
            .build();
            .build();
                assertTrue(e instanceof IllegalArgumentException);
    public void testScaleDownValidation() {
            String indexName = "test_index";
            public void onFailure(Exception e) {
            public void onFailure(Exception e) {
import org.opensearch.common.util.concurrent.ThreadContext;
            new ActionFilters(Collections.emptySet()),
        ClusterState state = mock(ClusterState.class);
import org.opensearch.transport.TransportService;
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
        // Verify that allocationService.reroute was called with the expected reason.
            .routingTable(routingTable)
        };
    }
            .put(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), true)
            Metadata metadata = mock(Metadata.class);
            .routingTable(routingTable)
            // Verify that our constant points to a valid thread pool
        // Create index metadata
        ScaleIndexRequest request = new ScaleIndexRequest(indexName, true);
            @Override
import static org.mockito.Mockito.clearInvocations;
            }
                eq(TransportScaleIndexAction.NAME),
                fail("Expected validation to fail");
            .metadata(Metadata.builder().put(indexMetadata, true).build())
        ThreadPool threadPool = new TestThreadPool("testHandleShardSyncRequest");
}
        action.clusterManagerOperation(request, state, listener);
            1,
            .nodes(discoveryNodes)
import org.opensearch.cluster.node.DiscoveryNodes;
            .numberOfShards(1)
                ActionListener<Releasable> listener = invocation.getArgument(0);
        // Mock dependencies
        assertNotNull(exception);
            allocationService,
        verify(shard, times(1)).flush(any(FlushRequest.class));
            when(clusterService.localNode()).thenReturn(localNode);
        Index index = indexMetadata.getIndex();
                "SHARD_SYNC_EXECUTOR should be set to MANAGEMENT",
        ActionListener<AcknowledgedResponse> listener = new ActionListener<>() {
                threadPool,
import static org.mockito.Mockito.when;
import org.opensearch.test.OpenSearchTestCase;
            public void onResponse(AcknowledgedResponse response) {}
        initialState = ClusterState.builder(new ClusterName("test")).metadata(Metadata.builder().build()).build();
            transportService,
 * SPDX-License-Identifier: Apache-2.0
        ClusterState state = ClusterState.builder(new ClusterName("test"))
            }
        final AtomicReference<ScaleIndexShardResponse> responseRef = new AtomicReference<>();
        // Mock dependencies
            // Call handleShardSyncRequest
            // Create action instance with the real ThreadPool
            handler.handleResponse(new ScaleIndexNodeResponse(node, Collections.emptyList()));
            .put(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), false)
        // Stub transportService.sendRequest so that any shard sync request immediately succeeds.
            when(indexShard.shardId()).thenReturn(shardId);
            .numberOfShards(1)
        // Build a minimal routing table for the index.
            @Override
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
                fail("Expected validation to fail");
        IndexRoutingTable indexRoutingTable = new IndexRoutingTable.Builder(index).addIndexShard(shardRoutingTable).build();
        when(clusterService.state()).thenReturn(initialState);
    public void testAddBlockClusterStateUpdateTask() {
        IndexShardRoutingTable shardRoutingTable = new IndexShardRoutingTable.Builder(shardId).addShard(searchOnlyShardRouting).build();
 *
                transportService,
        assertFalse("Response should not indicate sync needed", successResponseRef.get().needsSync());
        ActionListener<AcknowledgedResponse> listener = new ActionListener<>() {
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        scaleUpTask.clusterStateProcessed("test-source", initialState, updatedState);
            allocationService,
            .settings(indexSettings)
            when(clusterState.metadata()).thenReturn(metadata);
        TransportScaleIndexAction.AddBlockClusterStateUpdateTask task = action.new AddBlockClusterStateUpdateTask(
        IndexShardRoutingTable shardRoutingTable = new IndexShardRoutingTable.Builder(shardId).addShard(primaryShardRouting).build();
    private ThreadPool threadPool;
        IndexShard shard = mock(IndexShard.class);
    public void testScaleDownWithSearchOnlyAlreadyEnabled() {
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
        ScaleIndexRequest request = new ScaleIndexRequest(indexName, true);
import org.opensearch.action.admin.indices.flush.FlushRequest;
        Collection<ClusterBlock> indexBlocks = newState.blocks().indices().get(indexName);
            public void onResponse(AcknowledgedResponse response) {
            public void onResponse(AcknowledgedResponse response) {
                successResponseRef.set(response);
        // Test validation when index is not in search-only mode
            allocationService,
        verify(clusterService).submitStateUpdateTask(eq("add-block-index-to-scale " + indexName), captor.capture());
        String indexName = "non_existent_index";
        ClusterState initialState = ClusterState.builder(new ClusterName("test"))
            .put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, 1)
        assertNull("No exception expected", successExceptionRef.get());
        verify(listener).onResponse(any(AcknowledgedResponse.class));
            threadPool,
        // Manually simulate execution of the scale-up task.
        ClusterService clusterService = mock(ClusterService.class);
                any(DiscoveryNode.class),
            @Override
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.cluster.routing.RoutingTable;
        Map<Index, ClusterBlock> blockedIndices = new HashMap<>();
            new ActionFilters(Collections.emptySet()),
        action.syncSingleShard(shard, new ActionListener<>() {
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
import org.opensearch.cluster.ClusterName;
            new ActionFilters(Collections.emptySet()),
            }
            }
import java.util.concurrent.atomic.AtomicReference;
        );
        // Verify that the finalize-scale-down update task was submitted.
                assertTrue(e instanceof IllegalStateException);
            threadPool,
            .metadata(Metadata.builder().put(indexMetadata, true).build())
        ClusterState state = createClusterStateWithSearchOnlyEnabled(indexName);
                new ActionFilters(Collections.emptySet()),
            public void onFailure(Exception e) {
    private AllocationService allocationService;
            @Override
        // Capture the add-block task submitted by the action.
    public void tearDown() throws Exception {
        // Test onFailure
        RoutingTable routingTable = RoutingTable.builder().add(indexRoutingTable).build();
            }
                fail("Operation should not fail: " + e.getMessage());
            // Create test data
            public void onResponse(AcknowledgedResponse response) {
            .build();
        };
        when(clusterService.state()).thenReturn(state);
import org.mockito.ArgumentCaptor;
            }
        verify(shard, times(1)).sync();
import org.opensearch.cluster.ClusterState;
    public void testAddBlockClusterStateUpdateTaskExecute() {
import org.junit.Before;
            .build();
        ArgumentCaptor<ActionListener> permitListenerCaptor = ArgumentCaptor.forClass(ActionListener.class);
                any(ScaleIndexNodeRequest.class),
        TranslogStats translogStats = mock(TranslogStats.class);
            }
            return null;
        try {
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
        action.clusterManagerOperation(request, state, listener);
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
        doAnswer(invocation -> {
            );
        IndexRoutingTable indexRoutingTable = new IndexRoutingTable.Builder(index).addIndexShard(shardRoutingTable).build();
import org.opensearch.cluster.block.ClusterBlockLevel;
        IndexMetadata indexMetadata = IndexMetadata.builder(indexName)
    }
import java.util.concurrent.CountDownLatch;
        action.clusterManagerOperation(request, state, listener);
            .settings(indexSettings)
        // Mock dependencies
import org.opensearch.cluster.routing.TestShardRouting;
            @Override
        });
        when(allocationService.reroute(any(ClusterState.class), anyString())).thenReturn(stateAfterReroute);
                assertTrue("Expected block to be added successfully", response.isAcknowledged());
import java.util.Collections;
            public void onFailure(Exception e) {
        };
import org.junit.After;
        String indexName = "test_index";
        String indexName = "test_index";
        // Test execution with missing index
        String indexName = "test_index";
        // Create a new cluster state that is different from initialState.
            .numberOfShards(1)
        Settings indexSettings = Settings.builder()
    }
        };
            .sendRequest(
    }
    }
            .numberOfReplicas(1)
        assertNull(action.checkBlock(request, state));
            assertBusy(() -> { verify(channel).sendResponse(any(ScaleIndexNodeResponse.class)); }, 5, TimeUnit.SECONDS);
        state = ClusterState.builder(new ClusterName("test"))
import org.opensearch.cluster.routing.IndexRoutingTable;
            @Override
            );
            clusterService,
        ScaleIndexRequest request = new ScaleIndexRequest(indexName, true);
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            .put(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), true)
        assertFalse("Response should not indicate uncommitted operations", successResponseRef.get().hasUncommittedOperations());
import org.opensearch.cluster.block.ClusterBlocks;
        );
                latch.countDown();
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    }
            }
import java.util.Collection;
        assertTrue("Index should have at least one block", !indexBlocks.isEmpty());
            clusterService,
    }
            @Override
            public void onResponse(AcknowledgedResponse response) {
package org.opensearch.action.admin.indices.scale.searchonly;
import org.opensearch.threadpool.ThreadPool;
            }
                fail("Should not fail: " + e.getMessage());
                latch.countDown();
            false,
        ClusterState state = ClusterState.builder(new ClusterName("test")).metadata(Metadata.builder().build()).build();
        assertNotNull("Response should not be null", responseRef.get());
            }
import org.opensearch.index.translog.TranslogStats;
        boolean hasBlockWithCorrectId = indexBlocks.stream().anyMatch(block -> block.id() == INDEX_SEARCH_ONLY_BLOCK_ID);
    public void testFinalizeScaleDownTaskSimple() throws Exception {
            ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
        ShardRouting searchOnlyShardRouting = TestShardRouting.newShardRouting(shardId, "node1", true, ShardRoutingState.STARTED);
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        };
    private TransportScaleIndexAction action;
            indicesService
        super.tearDown();
        // Create initial cluster state with necessary index metadata
            @Override
                listener.onResponse(releasable);
            }
            when(indexShard.translogStats()).thenReturn(translogStats);
            ScaleIndexNodeRequest request = new ScaleIndexNodeRequest(indexName, shardIds);
        ClusterState updatedState = scaleUpTask.execute(initialState);
            doAnswer(invocation -> {
        assertNotNull("Index blocks should not be null", indexBlocks);
    }
        ShardId shardId = new ShardId(index, 0);
    }
import org.opensearch.action.support.ActionFilters;
        when(shard.isSyncNeeded()).thenReturn(false);
        };
            when(indexService.getShardOrNull(anyInt())).thenReturn(indexShard);
        ScaleIndexRequest request = new ScaleIndexRequest(indexName, false);
    public void testHandleShardSyncRequest() throws Exception {
                return null;
        // Create a DiscoveryNode and include it in the cluster state's nodes.
            when(indexShard.isSyncNeeded()).thenReturn(false);
            .build();
        Settings indexSettings = Settings.builder()
import org.opensearch.common.unit.TimeValue;
        Settings indexSettings = Settings.builder()
            .put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, 1)
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            IndexMetadata indexMetadata = mock(IndexMetadata.class);
        // Build the complete cluster state with metadata and the routing table.
            @Override
            @Override
        task.onFailure("test", testException);
        assertNotNull("Response should not be null", successResponseRef.get());
        ActionListener<AcknowledgedResponse> listener = new ActionListener<>() {
        ShardRouting primaryShardRouting = TestShardRouting.newShardRouting(shardId, "node1", true, ShardRoutingState.STARTED);
            EnumSet.of(ClusterBlockLevel.METADATA_WRITE)
        ClusterBlocks.Builder blocksBuilder = ClusterBlocks.builder().blocks(initialState.blocks());
        });
        );
        when(clusterService.state()).thenReturn(state);
        // Test onFailure
            clusterService,
        Exception testException = new Exception("Test failure");
        TransportScaleIndexAction action = new TransportScaleIndexAction(
            when(metadata.index(indexName)).thenReturn(indexMetadata);
            .build();
            Index index = new Index(indexName, "_na_");
        String indexName = "test_index";
                successLatch.countDown();
            .build();
    private ClusterState createClusterStateWithoutSearchOnly(String indexName) {
        // Create action and task
        ClusterState state = createClusterStateWithoutSearchOnly(indexName);
            assertNotNull("Thread pool executor should exist", threadPool.executor(TransportScaleIndexAction.SHARD_SYNC_EXECUTOR));
            .numberOfReplicas(1)
import org.opensearch.common.settings.Settings;
            .numberOfReplicas(1)
    private IndicesService indicesService;
    public void testScaleUpValidation() {
        transportService = mock(TransportService.class);
        ClusterState initialState = ClusterState.builder(new ClusterName("test"))
        ArgumentCaptor<ClusterStateUpdateTask> captor = ArgumentCaptor.forClass(ClusterStateUpdateTask.class);
        assertTrue(latch.await(1, TimeUnit.SECONDS));
                allocationService,
            false,
        when(clusterService.state()).thenReturn(initialState);
        assertTrue(exception.blocks().contains(metadataBlock));
            threadPool,
import org.opensearch.transport.TransportResponseHandler;
        String indexName = "test_index";
            .build();
            public void onFailure(Exception e) {
            "test block",
    private ClusterState createClusterStateWithSearchOnlyEnabled(String indexName) {
            @Override
        ActionListener<AcknowledgedResponse> listener = new ActionListener<>() {
        }
        ClusterBlockException exception = action.checkBlock(request, state);
            new ActionFilters(Collections.emptySet()),
import org.opensearch.cluster.metadata.IndexMetadata;
        stateBuilder.nodes(DiscoveryNodes.builder().build());
        action.clusterManagerOperation(request, initialState, new ActionListener<>() {
                assertEquals("Index [" + indexName + "] not found", e.getMessage());
        assertTrue("Response should indicate sync needed", responseRef.get().needsSync());
        assertEquals(initialState, resultState);
    private ClusterState createClusterStateWithoutIndex(String indexName) {
                assertEquals("Index [" + indexName + "] not found", e.getMessage());
            when(clusterService.state()).thenReturn(clusterState);
    }
        try {
    }
            .metadata(Metadata.builder().put(indexMetadata, true).build())
        when(shard.isSyncNeeded()).thenReturn(true);
                ThreadPool.Names.MANAGEMENT,
import java.util.HashMap;
        ClusterState resultState = task.execute(initialState);
    public void testScaleUpWithSearchOnlyNotEnabled() {
            .build();
            .settings(indexSettings)
        verify(clusterService).submitStateUpdateTask(eq("add-block-index-to-scale " + indexName), any());
import java.util.Map;
            .build();
            }
import static org.mockito.ArgumentMatchers.eq;
        clearInvocations(shard);
        // Test successful processing
        }
        when(clusterService.state()).thenReturn(stateBuilder.build());
            when(indicesService.indexService(any(Index.class))).thenReturn(indexService);
        TransportScaleIndexAction action = new TransportScaleIndexAction(
        );
    }
    public void testScaleDownWithMissingIndex() {
                assertTrue(e instanceof IllegalStateException);
            new ClusterBlock(123, "dummy", false, false, false, RestStatus.FORBIDDEN, EnumSet.of(ClusterBlockLevel.WRITE))
                Releasable releasable = mock(Releasable.class);
import static org.mockito.Mockito.verify;
            .build();
            IndexService indexService = mock(IndexService.class);
        action.syncSingleShard(shard, new ActionListener<>() {
        // Setup basic cluster state
            TranslogStats translogStats = mock(TranslogStats.class);
import org.opensearch.cluster.metadata.Metadata;
        when(clusterService.state()).thenReturn(state);
            public void onFailure(Exception e) {
    }
            @Override
            @Override
        Settings indexSettings = Settings.builder()
        TransportScaleIndexAction action = new TransportScaleIndexAction(
        IndexMetadata indexMetadata = IndexMetadata.builder(indexName)
                assertTrue(e instanceof IllegalArgumentException);
            }
        String indexName = "test_index";
        ActionListener<AcknowledgedResponse> listener = mock(ActionListener.class);
        // Test validation when index doesn't exist
import java.util.EnumSet;
            @Override
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
/*
        verify(listener).onFailure(testException);
            action.handleShardSyncRequest(request, channel);
        DiscoveryNode node = new DiscoveryNode("node1", buildNewFakeTransportAddress(), Version.CURRENT);
        when(translogStats.getUncommittedOperations()).thenReturn(5);
            public void onResponse(AcknowledgedResponse response) {
import org.opensearch.cluster.routing.allocation.AllocationService;
            .numberOfReplicas(1)
                new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
            // Mock cluster state
        );
        IndexMetadata indexMetadata = IndexMetadata.builder(indexName)
        IndexMetadata indexMetadata = IndexMetadata.builder(indexName)
        verify(shard, times(1)).sync();
        IndexMetadata indexMetadata = IndexMetadata.builder(indexName)
            transportService,
                fail("Should fail for missing index");
        verify(clusterService).submitStateUpdateTask(eq("finalize-scale-down"), any(ClusterStateUpdateTask.class));
            public void onResponse(ScaleIndexShardResponse response) {
            }
    private TransportService transportService;
            indicesService
        final CountDownLatch latch = new CountDownLatch(1);
        verify(shard).acquireAllPrimaryOperationsPermits(permitListenerCaptor.capture(), any(TimeValue.class));
    }
                assertEquals("Index [" + indexName + "] is not in search-only mode", e.getMessage());
        indicesService = mock(IndicesService.class);
    public void testFinalizeScaleDownTaskFailure() {
        ShardId shardId = new ShardId(index, 0);
        when(shard.shardId()).thenReturn(shardId);
        ScaleIndexRequest request = new ScaleIndexRequest(indexName, false);
        return ClusterState.builder(new ClusterName("test")).metadata(Metadata.builder().put(indexMetadata, true).build()).build();
 * this file be licensed under the Apache-2.0 license or a
        // Create cluster state with search-only already enabled
        IndexMetadata indexMetadata = IndexMetadata.builder(indexName)
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
        // Create initial cluster state
            .settings(indexSettings)
        } finally {
        ClusterState newState = task.execute(initialState);
            List<ShardId> shardIds = Collections.singletonList(shardId);
            .put(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), false)
            .numberOfShards(1)
        verify(shard, times(1)).waitForRemoteStoreSync();
        task.clusterStateProcessed("test", state, state);
        blocksBuilder.addIndexBlock(
        ActionListener<AcknowledgedResponse> listener = new ActionListener<>() {
        ClusterState initialState = ClusterState.builder(new ClusterName("test"))
import org.opensearch.transport.TransportChannel;
            new ActionFilters(Collections.emptySet()),
    }
                fail("Should not fail: " + e.getMessage());
import org.opensearch.cluster.routing.IndexShardRoutingTable;
            .build();
        assertNull("No exception expected", exceptionRef.get());
        ActionListener<AcknowledgedResponse> listener = mock(ActionListener.class);
            clusterService,
            @Override
        ClusterState state = createClusterStateWithoutIndex(indexName);
            transportService,
        } finally {
import org.opensearch.index.shard.IndexShard;
            when(translogStats.getUncommittedOperations()).thenReturn(0);
 * The OpenSearch Contributors require contributions made to
            when(shardRouting.primary()).thenReturn(true);
    }
                indicesService
        final CountDownLatch successLatch = new CountDownLatch(1);
import static org.mockito.Mockito.doAnswer;
            .build();
        ActionListener<AcknowledgedResponse> listener = new ActionListener<AcknowledgedResponse>() {
        assertTrue("Should find a block with ID " + INDEX_SEARCH_ONLY_BLOCK_ID, hasBlockWithCorrectId);
        ClusterState.Builder stateBuilder = ClusterState.builder(new ClusterName("test"));
            when(indexMetadata.getIndex()).thenReturn(index);
        // Trigger the scale-up operation.
            TransportScaleIndexAction action = new TransportScaleIndexAction(
        String indexName = "test_index";
        });
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
        action.clusterManagerOperation(request, initialState, listener);
                assertTrue("Expected scale up to complete successfully", response.isAcknowledged());
            TransportResponseHandler<ScaleIndexNodeResponse> handler = invocation.getArgument(3);
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
        // Build a minimal routing table for the index.
    }
            // Mock index service and shard
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_SEARCH_ONLY_BLOCK_ID;
    private ClusterService clusterService;
            .numberOfReplicas(1)
        );
        }).when(transportService)
            .build();
    public void testCheckBlock() {
import org.opensearch.core.index.Index;
            }
import org.opensearch.cluster.ClusterStateUpdateTask;
            .settings(indexSettings)
            transportService,
            ClusterState clusterState = mock(ClusterState.class);
        // Build the complete cluster state with metadata, routing table, and nodes.
            .settings(indexSettings)
            public void onFailure(Exception e) {
            transportService,
        ScaleIndexRequest request = new ScaleIndexRequest(indexName, true);
            // Mock shard routing to return a primary routing
        Settings indexSettings = Settings.builder()
            .blocks(blocksBuilder.build())
            ShardId shardId = new ShardId(index, 0);
        when(translogStats.getUncommittedOperations()).thenReturn(0);
            .numberOfShards(1)
            // Wait a short time for the async task to execute
            .settings(indexSettings)
            .metadata(Metadata.builder().put(indexMetadata, true).build())
        return ClusterState.builder(new ClusterName("test")).metadata(Metadata.builder().build()).build();
        ClusterStateUpdateTask scaleUpTask = captor.getValue();
            public void onFailure(Exception e) {
import java.util.concurrent.TimeUnit;
                TransportScaleIndexAction.SHARD_SYNC_EXECUTOR
            }
        action.clusterManagerOperation(request, initialState, listener);
            allocationService,
    public void testThreadPoolConstantValidity() {
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
    @After
        action = new TransportScaleIndexAction(
