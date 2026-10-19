    private ClusterService clusterService;
                ActionListener<Releasable> listener = invocation.getArgument(0);
        IndexRoutingTable indexRoutingTable = new IndexRoutingTable.Builder(index).addIndexShard(shardRoutingTable).build();
        when(clusterService.state()).thenReturn(stateBuilder.build());  
        Index index = indexMetadata.getIndex();
    private IndicesService indicesService;
        when(clusterService.state()).thenReturn(state);  
            ShardId shardId = new ShardId(index, 0);
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
            @Override
        // Test successful execution  
        assertTrue("Should find a block with ID " + INDEX_SEARCH_ONLY_BLOCK_ID, hasBlockWithCorrectId);  
        assertTrue("Response should indicate uncommitted operations", responseRef.get().hasUncommittedOperations());
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            .put(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), false)
        initialState = ClusterState.builder(new ClusterName("test")).metadata(Metadata.builder().build()).build();  
    }
    }
            .routingTable(routingTable)
    public void testFinalizeScaleDownTaskSimple() throws Exception {
        String indexName = "non_existent_index";  
                fail("Expected validation to fail");
            .build();
                any(ScaleIndexNodeRequest.class),
                assertTrue(e instanceof IllegalArgumentException);
        assertTrue(exception.blocks().contains(metadataBlock));  
    private TransportService transportService;
                fail("Expected validation to fail");
import org.opensearch.cluster.routing.ShardRouting;
        Index index = indexMetadata.getIndex();  
            .put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, 1)
            }  
        // Test validation when index is not in search-only mode
import java.util.Map;
            );
            when(indexService.getShardOrNull(anyInt())).thenReturn(indexShard);  
        // Build a minimal routing table for the index.  
        verify(listener).onFailure(testException);
            IndexMetadata indexMetadata = mock(IndexMetadata.class);
        IndexShard shard = mock(IndexShard.class);
        when(translogStats.getUncommittedOperations()).thenReturn(5);  
                listener.onResponse(releasable);  
        String indexName = "test_index";  
            .settings(indexSettings)  
        // Stub transportService.sendRequest so that any shard sync request immediately succeeds.
            when(clusterService.localNode()).thenReturn(localNode);
import org.opensearch.cluster.block.ClusterBlockException;  
            public void onResponse(AcknowledgedResponse response) {
            .numberOfShards(1)  
        ArgumentCaptor<ActionListener> successPermitCaptor = ArgumentCaptor.forClass(ActionListener.class);
            TranslogStats translogStats = mock(TranslogStats.class);  
            allocationService,  
/*  
            // Mock the acquireAllPrimaryOperationsPermits method to immediately call the listener
        verify(shard, times(1)).sync();
    }  
            .metadata(Metadata.builder().put(indexMetadata, true).build())
        successPermitCaptor.getValue().onResponse(mock(Releasable.class));  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            @Override
    }
        when(shard.translogStats()).thenReturn(translogStats);
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),  
            .build();  
import org.mockito.ArgumentCaptor;  
        // Test with no blocks
        indicesService = mock(IndicesService.class);  
                fail("Should not fail: " + e.getMessage());  
        ClusterState newState = task.execute(initialState);
            }  
            allocationService,  
            }
    private TransportScaleIndexAction action;  
    }
            .build();
        ClusterState state = createClusterStateWithoutSearchOnly(indexName);
 * this file be licensed under the Apache-2.0 license or a
    public void testScaleDownWithMissingIndex() {
        final AtomicReference<ScaleIndexShardResponse> successResponseRef = new AtomicReference<>();
            }  
        // Build a minimal routing table for the index.
                successLatch.countDown();  
        ClusterState stateAfterReroute = ClusterState.builder(initialState).build();  
        String indexName = "test_index";
                new ActionFilters(Collections.emptySet()),  
        IndexShardRoutingTable shardRoutingTable = new IndexShardRoutingTable.Builder(shardId).addShard(primaryShardRouting).build();
        Settings indexSettings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build();  
            .put(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), true)  
        // Test successful processing  
        TransportScaleIndexAction action = new TransportScaleIndexAction(
        blocksBuilder.addIndexBlock(
        super.setUp();
        assertFalse("Response should not indicate sync needed", successResponseRef.get().needsSync());  
            ScaleIndexNodeRequest request = new ScaleIndexNodeRequest(indexName, shardIds);  
        String indexName = "test_index";
            @Override
        ScaleIndexRequest request = new ScaleIndexRequest(indexName, true);  
        // Create a new cluster state that is different from initialState.
import org.opensearch.indices.IndicesService;  
            // Verify that our constant points to a valid thread pool  
        Exception testException = new Exception("Test failure");
            new ActionFilters(Collections.emptySet()),
        when(allocationService.reroute(any(ClusterState.class), anyString())).thenReturn(stateAfterReroute);
    public void testScaleDownWithSearchOnlyAlreadyEnabled() {  
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            .settings(indexSettings)
import org.opensearch.cluster.routing.IndexRoutingTable;
        action.clusterManagerOperation(request, initialState, new ActionListener<>() {
            }
        ScaleIndexRequest request = new ScaleIndexRequest(indexName, false);
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
        TransportScaleIndexAction.FinalizeScaleDownTask task = action.new FinalizeScaleDownTask(indexName, listener);
        try {
            }
        // Create action and task  
                ThreadPool.Names.MANAGEMENT,  
        // Build the complete cluster state with metadata and the routing table.
            .put(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), false)  
            public void onResponse(AcknowledgedResponse response) {  
            ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);  
    public void tearDown() throws Exception {
import org.opensearch.action.admin.indices.flush.FlushRequest;
            .put(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), true)
        Settings indexSettings = Settings.builder()
            indicesService
    private ClusterState createClusterStateWithoutIndex(String indexName) {  
            List<ShardId> shardIds = Collections.singletonList(shardId);
            @Override
import org.opensearch.transport.TransportService;
import org.opensearch.core.action.ActionListener;
        } finally {
    }
        ArgumentCaptor<ClusterStateUpdateTask> captor = ArgumentCaptor.forClass(ClusterStateUpdateTask.class);  
            "test block",  
import org.opensearch.cluster.node.DiscoveryNodes;
            @Override  
        final AtomicReference<Exception> exceptionRef = new AtomicReference<>();
    }
            .numberOfReplicas(1)
        action.clusterManagerOperation(request, state, listener);  
        IndexMetadata indexMetadata = IndexMetadata.builder(indexName)  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                assertTrue(e instanceof IllegalStateException);  
                fail("Should fail when search-only is not enabled");
        ClusterState initialState = ClusterState.builder(new ClusterName("test"))  
    public void testScaleDownValidation() {  
        ClusterBlockException exception = action.checkBlock(request, state);
        ClusterState updatedState = scaleUpTask.execute(initialState);
                transportService,  
import org.opensearch.index.translog.TranslogStats;
import org.opensearch.cluster.routing.ShardRoutingState;  
            .build();
        ArgumentCaptor<ActionListener> permitListenerCaptor = ArgumentCaptor.forClass(ActionListener.class);  
    public void testAddBlockClusterStateUpdateTaskExecute() {  
            EnumSet.of(ClusterBlockLevel.METADATA_WRITE)
 */  
import org.opensearch.cluster.ClusterStateUpdateTask;
import java.util.concurrent.TimeUnit;  
            public void onResponse(AcknowledgedResponse response) {
        // Create a dummy shard routing in STARTED state.
            public void onResponse(ScaleIndexShardResponse response) {
    }
    }  
        ClusterState state = ClusterState.builder(new ClusterName("test"))  
            public void onFailure(Exception e) {  
        IndexMetadata indexMetadata = IndexMetadata.builder(indexName)
            .put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, 1)
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)  
    }
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
        action.clusterManagerOperation(request, initialState, listener);
        verify(listener).onFailure(testException);
        scaleUpTask.clusterStateProcessed("test-source", initialState, updatedState);
            }).when(indexShard).acquireAllPrimaryOperationsPermits(any(ActionListener.class), any(TimeValue.class));
        ClusterState state = createClusterStateWithSearchOnlyEnabled(indexName);
import org.opensearch.core.rest.RestStatus;
        ShardRouting primaryShardRouting = TestShardRouting.newShardRouting(shardId, "node1", true, ShardRoutingState.STARTED);  
        when(clusterService.state()).thenReturn(initialState);
        IndexMetadata indexMetadata = IndexMetadata.builder(indexName)
        );
        ClusterState resultState = task.execute(initialState);
            }  
        action.clusterManagerOperation(request, state, listener);  
        );
                exceptionRef.set(e);
        };
import org.opensearch.index.shard.IndexShard;
            clusterService,
                fail("Operation should not fail: " + e.getMessage());
            // Create test data
        TransportChannel channel = mock(TransportChannel.class);  
            .numberOfReplicas(1)
        };
        // Test onFailure
        ClusterState state = ClusterState.builder(new ClusterName("test")).metadata(Metadata.builder().build()).build();  
            transportService,
        });
            // Mock shard routing to return a primary routing  
import org.opensearch.indices.replication.common.ReplicationType;
            .numberOfShards(1)  
import java.util.concurrent.atomic.AtomicReference;
        );  
            public void onResponse(AcknowledgedResponse response) {
    }
        verify(shard, times(1)).flush(any(FlushRequest.class));
        // Manually simulate execution of the scale-up task.  
        assertNotNull("Index blocks should not be null", indexBlocks);  
                assertEquals("Index [" + indexName + "] is not in search-only mode", e.getMessage());
        Settings indexSettings = Settings.builder()
        ActionListener<AcknowledgedResponse> listener = new ActionListener<>() {
            TransportResponseHandler<ScaleIndexNodeResponse> handler = invocation.getArgument(3);
        Settings indexSettings = Settings.builder()  
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
            }  
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
        // Mock dependencies
        TransportScaleIndexAction.AddBlockClusterStateUpdateTask task = action.new AddBlockClusterStateUpdateTask(
        ClusterState.Builder stateBuilder = ClusterState.builder(new ClusterName("test"));
    }
    public void testCheckBlock() {
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
        action.clusterManagerOperation(request, initialState, listener);
            .numberOfShards(1)
        );  
    public void testScaleUpWithSearchOnlyNotEnabled() {  
        // Create minimal index metadata that meets scale-down prerequisites.
        ActionListener<AcknowledgedResponse> listener = new ActionListener<>() {
                assertTrue(e instanceof IllegalArgumentException);
import org.opensearch.cluster.metadata.Metadata;
                indicesService  
                assertTrue("Expected scale up to complete successfully", response.isAcknowledged());
        assertTrue(successLatch.await(1, TimeUnit.SECONDS));
                "SHARD_SYNC_EXECUTOR should be set to MANAGEMENT",
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder().add(node).localNodeId("node1").build();
                threadPool,
            .numberOfReplicas(1)
    }  
        final CountDownLatch successLatch = new CountDownLatch(1);  
        assertTrue("Response should indicate sync needed", responseRef.get().needsSync());  
import org.opensearch.cluster.block.ClusterBlockLevel;
                latch.countDown();
import static org.mockito.Mockito.when;  
import org.junit.After;
                any(DiscoveryNode.class),  
            .numberOfShards(1)  
        verify(shard, times(1)).flush(any(FlushRequest.class));  
        task.onFailure("test", testException);  
            @Override
        TransportScaleIndexAction action = new TransportScaleIndexAction(  
            .build();
        // Build the complete cluster state with metadata, routing table, and nodes.  
import java.util.EnumSet;
        ScaleIndexRequest request = new ScaleIndexRequest(indexName, false);
        }
        IndexShardRoutingTable shardRoutingTable = new IndexShardRoutingTable.Builder(shardId).addShard(searchOnlyShardRouting).build();
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
            clusterService,  
            allocationService,
        ActionListener<AcknowledgedResponse> listener = new ActionListener<>() {
        return ClusterState.builder(new ClusterName("test")).metadata(Metadata.builder().put(indexMetadata, true).build()).build();
            .numberOfReplicas(1)  
        IndexMetadata indexMetadata = IndexMetadata.builder(indexName)
        Settings indexSettings = Settings.builder()
}
            @Override
                assertEquals("Index [" + indexName + "] not found", e.getMessage());
        assertNotNull(exception);
            .numberOfReplicas(1)
            .build();
        ActionListener<AcknowledgedResponse> listener = new ActionListener<AcknowledgedResponse>() {
            .metadata(Metadata.builder().put(indexMetadata, true).build())
import static org.mockito.ArgumentMatchers.any;  
        verify(clusterService).submitStateUpdateTask(eq("scale-up-index"), captor.capture());  
import org.opensearch.threadpool.TestThreadPool;  
    }
            .routingTable(routingTable)  
            String indexName = "test_index";
        allocationService = mock(AllocationService.class);
            @Override  
            }  
            false,
        });
            ShardRouting shardRouting = mock(ShardRouting.class);
            .numberOfShards(1)
            transportService,  
            }  
            public void onFailure(Exception e) {
        );
    }
            public void onFailure(Exception e) {
        ClusterState initialState = ClusterState.builder(new ClusterName("test"))
 * compatible open source license.
        // Trigger the scale-up operation.
            .metadata(Metadata.builder().put(indexMetadata, true).build())
        clearInvocations(shard);
        // Create cluster state with search-only already enabled
 *
        IndexMetadata indexMetadata = IndexMetadata.builder(indexName)  
            public void onFailure(Exception e) {  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        final CountDownLatch latch = new CountDownLatch(1);
            .blocks(blocksBuilder.build())
        ThreadPool threadPool = new TestThreadPool("testThreadPoolConstantValidity");
import org.opensearch.index.IndexService;  
        // Capture the add-block task submitted by the action.
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
import static org.mockito.Mockito.doAnswer;
            new ActionFilters(Collections.emptySet()),
            RestStatus.FORBIDDEN,
            .metadata(Metadata.builder().put(indexMetadata, true))  
        String indexName = "test_index";
            public void onResponse(AcknowledgedResponse response) {}  
                return null;
            }
        // Mock dependencies
import org.junit.Before;  
        ActionListener<AcknowledgedResponse> listener = new ActionListener<>() {
import org.opensearch.cluster.service.ClusterService;  
        final AtomicReference<Exception> successExceptionRef = new AtomicReference<>();
        when(translogStats.getUncommittedOperations()).thenReturn(0);
        when(shard.isSyncNeeded()).thenReturn(true);
import org.opensearch.core.index.Index;  
import static org.mockito.ArgumentMatchers.anyInt;
        assertEquals(initialState, resultState);  
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_SEARCH_ONLY_BLOCK_ID;
        ShardId shardId = new ShardId(index, 0);
        // Mock dependencies  
import static org.mockito.ArgumentMatchers.anyString;
        verify(allocationService).reroute(any(ClusterState.class), eq("restore indexing shards"));
        Settings indexSettings = Settings.builder()
        // Use a real ThreadPool but with a controlled executor  
        ClusterState initialState = ClusterState.builder(new ClusterName("test"))
            .numberOfReplicas(1)  
            .numberOfShards(1)
            .sendRequest(
        IndexMetadata indexMetadata = IndexMetadata.builder(indexName)
    public void testFinalizeScaleDownTaskFailure() {
            .build();
            threadPool,  
            action.handleShardSyncRequest(request, channel);
        // Execute the scale-down operation.  
            threadPool,
        DiscoveryNode node = new DiscoveryNode("node1", buildNewFakeTransportAddress(), Version.CURRENT);  
import java.util.Collection;
        // Create a DiscoveryNode and include it in the cluster state's nodes.
        // Capture the update task submitted for scaling up.
            }
        Map<Index, ClusterBlock> blockedIndices = new HashMap<>();
    private ClusterState createClusterStateWithoutSearchOnly(String indexName) {
    private ThreadPool threadPool;
        // Verify that allocationService.reroute was called with the expected reason.
        );
import org.opensearch.cluster.node.DiscoveryNode;  
        String indexName = "test_index";
        ShardRouting searchOnlyShardRouting = TestShardRouting.newShardRouting(shardId, "node1", true, ShardRoutingState.STARTED);  
            .put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, 1)
        // Create index metadata with search-only mode enabled.  
        stateBuilder.nodes(DiscoveryNodes.builder().build());
        when(clusterService.state()).thenReturn(state);  
import org.opensearch.common.unit.TimeValue;  
        Settings indexSettings = Settings.builder()  
            public void onFailure(Exception e) {
        assertNull("No exception expected", successExceptionRef.get());
                assertTrue(e instanceof IllegalStateException);
        ScaleIndexRequest request = new ScaleIndexRequest(indexName, true);  
            .metadata(Metadata.builder().put(indexMetadata, true).build())  
            when(clusterService.state()).thenReturn(clusterState);  
    public void testScaleUpClusterStateUpdateTask() throws Exception {
            clusterService,
            .settings(indexSettings)
        // Test with metadata write block
    public void testSyncSingleShard() throws Exception {
            IndexService indexService = mock(IndexService.class);
        ClusterState state = ClusterState.builder(new ClusterName("test"))
            .nodes(discoveryNodes)
            @Override
                responseRef.set(response);
            .build();
import static org.mockito.Mockito.verify;
            .settings(indexSettings)
public class TransportScaleIndexActionTests extends OpenSearchTestCase {
        ActionListener<AcknowledgedResponse> listener = new ActionListener<>() {
    private ClusterState createClusterStateWithSearchOnlyEnabled(String indexName) {
        // Verify that a block with the correct ID was added
import org.opensearch.cluster.ClusterState;  
            public void onFailure(Exception e) {
            // Mock cluster state
    public void setUp() throws Exception {  
import org.opensearch.Version;
        ClusterBlocks.Builder blocksBuilder = ClusterBlocks.builder();  
import org.opensearch.action.support.ActionFilters;  
            public void onFailure(Exception e) {  
        action.clusterManagerOperation(request, state, listener);  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
            when(metadata.index(indexName)).thenReturn(indexMetadata);
    public void testHandleShardSyncRequest() throws Exception {
        IndexMetadata indexMetadata = IndexMetadata.builder(indexName)
            }
        Exception testException = new Exception("Test failure");  
            Index index = new Index(indexName, "_na_");  
        return ClusterState.builder(new ClusterName("test")).metadata(Metadata.builder().put(indexMetadata, true).build()).build();
            }
            // Create action instance with the real ThreadPool
            clusterService,  
            }  
        verify(clusterService).submitStateUpdateTask(eq("add-block-index-to-scale " + indexName), captor.capture());
import org.opensearch.cluster.block.ClusterBlocks;
import org.opensearch.test.OpenSearchTestCase;
        // Create index metadata
        RoutingTable routingTable = RoutingTable.builder().add(indexRoutingTable).build();  
            .build();  
            when(indexShard.translogStats()).thenReturn(translogStats);
import org.opensearch.transport.TransportChannel;
            .metadata(Metadata.builder().put(indexMetadata, true).build())
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
import org.opensearch.threadpool.ThreadPool;
        when(clusterService.state()).thenReturn(state);  
import org.opensearch.cluster.ClusterName;
            public void onFailure(Exception e) {  
            when(indicesService.indexService(any(Index.class))).thenReturn(indexService);
            public void onResponse(AcknowledgedResponse response) {  
import java.util.concurrent.CountDownLatch;
import java.util.HashMap;
import java.util.Collections;  
        // Create initial cluster state with necessary index metadata
                assertEquals("Index [" + indexName + "] is already in search-only mode", e.getMessage());
        Settings indexSettings = Settings.builder()
        ClusterBlock metadataBlock = new ClusterBlock(
        ArgumentCaptor<ClusterStateUpdateTask> captor = ArgumentCaptor.forClass(ClusterStateUpdateTask.class);
            public void onResponse(AcknowledgedResponse response) {
        clusterService = mock(ClusterService.class);
            indexName, blockedIndices, listener  
            // Mock index service and shard  
        });  
        final AtomicReference<ScaleIndexShardResponse> responseRef = new AtomicReference<>();  
        when(shard.isSyncNeeded()).thenReturn(false);
        action.clusterManagerOperation(request, state, listener);
    }
            .build();
            @Override
        blocksBuilder.addGlobalBlock(metadataBlock);
        assertNotNull("Response should not be null", successResponseRef.get());
                assertEquals("Index [" + indexName + "] is not in search-only mode", e.getMessage());
            indicesService
            transportService,
        // Test onFailure
import org.opensearch.common.lease.Releasable;
                allocationService,
    public void testAddBlockClusterStateUpdateTask() {
            threadPool,  
        ClusterBlocks.Builder blocksBuilder = ClusterBlocks.builder().blocks(initialState.blocks());  
            }
            @Override
import org.opensearch.transport.TransportResponseHandler;  
            .build();
        String indexName = "test_index";
            .build();  
            when(shardRouting.primary()).thenReturn(true);
        transportService = mock(TransportService.class);  
        ScaleIndexRequest request = new ScaleIndexRequest(indexName, true);
        TranslogStats translogStats = mock(TranslogStats.class);
            indicesService  
        verify(shard, times(1)).waitForRemoteStoreSync();
            .build();
    }  
            @Override
            }
                Releasable releasable = mock(Releasable.class);
            new ActionFilters(Collections.emptySet()),
            @Override  
            .build();
        // Test execution with missing index
        // Verify that the finalize-scale-down update task was submitted.
            TransportScaleIndexAction action = new TransportScaleIndexAction(
        verify(listener).onResponse(any(AcknowledgedResponse.class));  
                latch.countDown();
            @Override
        verify(clusterService).submitStateUpdateTask(eq("add-block-index-to-scale " + indexName), any());
        TransportScaleIndexAction action = new TransportScaleIndexAction(  
            .settings(indexSettings)
        };
        assertTrue("Index should have at least one block", !indexBlocks.isEmpty());
    @After  
        permitListenerCaptor.getValue().onResponse(mock(Releasable.class));
            .build();
        };
            IndexShard indexShard = mock(IndexShard.class);
    }
        try {  
        RoutingTable routingTable = RoutingTable.builder().add(indexRoutingTable).build();  
                assertTrue(e instanceof IllegalStateException);
            new ActionFilters(Collections.emptySet()),  
        );  
        when(clusterService.state()).thenReturn(initialState);  
                assertEquals("Index [" + indexName + "] not found", e.getMessage());
            @Override  
            .build();
package org.opensearch.action.admin.indices.scale.searchonly;
        // Create initial cluster state  
            // Verify SHARD_SYNC_EXECUTOR is using the MANAGEMENT pool as expected  
        // For example, add a dummy block to the index.
        ClusterState state = createClusterStateWithoutIndex(indexName);
        ScaleIndexRequest request = new ScaleIndexRequest(indexName, true);  
import org.opensearch.cluster.metadata.IndexMetadata;  
            .metadata(Metadata.builder().put(indexMetadata, true))  
        // Create test data
                fail("Expected validation to fail");
            }  
import org.opensearch.cluster.routing.IndexShardRoutingTable;  
            new ClusterBlock(123, "dummy", false, false, false, RestStatus.FORBIDDEN, EnumSet.of(ClusterBlockLevel.WRITE))  
            when(translogStats.getUncommittedOperations()).thenReturn(0);  
        action = new TransportScaleIndexAction(
        assertNotEquals(initialState, newState);
import org.opensearch.cluster.block.ClusterBlock;
        TransportScaleIndexAction action = new TransportScaleIndexAction(
        assertFalse("Response should not indicate uncommitted operations", successResponseRef.get().hasUncommittedOperations());
        addBlockTask.clusterStateProcessed("test-source", initialState, newState);
        task.onFailure("test", testException);
        DiscoveryNode localNode = new DiscoveryNode("local", buildNewFakeTransportAddress(), Version.CURRENT);
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),  
            indicesService
            when(indexMetadata.getIndex()).thenReturn(index);  
import org.opensearch.common.util.concurrent.ThreadContext;
            .settings(indexSettings)  
            indicesService
        };  
        }).when(transportService)
        };
        IndexRoutingTable indexRoutingTable = new IndexRoutingTable.Builder(index).addIndexShard(shardRoutingTable).build();
            1,
        // Stub allocationService.reroute to return a valid state.
        verify(shard, times(1)).waitForRemoteStoreSync();
        String indexName = "test_index";
        action.clusterManagerOperation(request, state, listener);  
            .numberOfReplicas(1)
            .build();
            assertBusy(() -> { verify(channel).sendResponse(any(ScaleIndexNodeResponse.class)); }, 5, TimeUnit.SECONDS);
        verify(shard, times(1)).sync();  
import org.opensearch.common.settings.Settings;
        IndexMetadata indexMetadata = IndexMetadata.builder(indexName)
            new ActionFilters(Collections.emptySet()),
            transportService,
            .settings(indexSettings)
            handler.handleResponse(new ScaleIndexNodeResponse(node, Collections.emptyList()));
            .numberOfShards(1)
        ActionListener<AcknowledgedResponse> listener = new ActionListener<>() {
        verify(clusterService).submitStateUpdateTask(eq("finalize-scale-down"), any(ClusterStateUpdateTask.class));
            .build();  
            @Override
        ScaleIndexRequest request = new ScaleIndexRequest(indexName, false);
            Metadata metadata = mock(Metadata.class);
                clusterService,
            .build();  
 * SPDX-License-Identifier: Apache-2.0
            doAnswer(invocation -> {  
        when(shard.shardId()).thenReturn(shardId);  
            public void onResponse(AcknowledgedResponse response) {  
    public void testScaleUpValidation() {  
import org.opensearch.cluster.routing.allocation.AllocationService;
        }
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        String indexName = "test_index";
import org.opensearch.cluster.routing.TestShardRouting;
import java.util.List;  
        };
            when(indexShard.shardId()).thenReturn(shardId);
        return ClusterState.builder(new ClusterName("test")).metadata(Metadata.builder().build()).build();
        threadPool = new TestThreadPool("ScaleIndexActionTests");
                successExceptionRef.set(e);
        state = ClusterState.builder(new ClusterName("test"))
            false,  
    private AllocationService allocationService;  
            @Override  
        ShardId shardId = new ShardId(index, 0);
            when(indexShard.routingEntry()).thenReturn(shardRouting);  
        // Setup basic cluster state  
        ActionListener<AcknowledgedResponse> listener = mock(ActionListener.class);
            // Call handleShardSyncRequest  
import static org.mockito.Mockito.mock;  
        assertNotNull("Response should not be null", responseRef.get());
        assertNull(action.checkBlock(request, state));  
            .build();
            .settings(indexSettings)
            allocationService,
                any(TransportResponseHandler.class)  
        action.syncSingleShard(shard, new ActionListener<>() {
        // Verify that the appropriate block was added  
            @Override
            ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
            public void onResponse(ScaleIndexShardResponse response) {  
            .build();
        ScaleIndexRequest request = new ScaleIndexRequest(indexName, true);
        assertTrue(latch.await(1, TimeUnit.SECONDS));
            allocationService,
            @Override
            .blocks(ClusterBlocks.builder().build())
        ClusterState newState = ClusterState.builder(initialState).blocks(blocksBuilder).build();
        String indexName = "test_index";
        );
    @Before
            when(clusterState.metadata()).thenReturn(metadata);
        action.syncSingleShard(shard, new ActionListener<>() {
import org.opensearch.core.index.shard.ShardId;
                fail("Should not fail: " + e.getMessage());  
                fail("Should fail for missing index");
        task.clusterStateProcessed("test", state, state);
            @Override  
        ClusterStateUpdateTask addBlockTask = captor.getValue();
            threadPool,
            false,
        TransportService transportService = mock(TransportService.class);  
        ClusterState state = mock(ClusterState.class);
            indexName,
                eq(TransportScaleIndexAction.NAME),
        ScaleIndexRequest request = new ScaleIndexRequest(indexName, true);
        doAnswer(invocation -> {  
                assertTrue("Expected block to be added successfully", response.isAcknowledged());
        ClusterService clusterService = mock(ClusterService.class);
            public void onFailure(Exception e) {  
    }
            clusterService,
        } finally {  
            assertEquals(
            .numberOfShards(1)  
                TransportScaleIndexAction.SHARD_SYNC_EXECUTOR
            // Wait a short time for the async task to execute  
        Collection<ClusterBlock> indexBlocks = newState.blocks().indices().get(indexName);
            );
        boolean hasBlockWithCorrectId = indexBlocks.stream().anyMatch(block -> block.id() == INDEX_SEARCH_ONLY_BLOCK_ID);
            assertNotNull("Thread pool executor should exist", threadPool.executor(TransportScaleIndexAction.SHARD_SYNC_EXECUTOR));
            threadPool,
        verify(shard).acquireAllPrimaryOperationsPermits(successPermitCaptor.capture(), any(TimeValue.class));
        IndicesService indicesService = mock(IndicesService.class);
        // Mock dependencies
        when(clusterService.state()).thenReturn(initialState);
        verify(shard).acquireAllPrimaryOperationsPermits(permitListenerCaptor.capture(), any(TimeValue.class));
            .numberOfReplicas(1)
        super.tearDown();  
            when(indexShard.isSyncNeeded()).thenReturn(false);
            ClusterState clusterState = mock(ClusterState.class);  
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)  
        // Test validation when index doesn't exist
                successResponseRef.set(response);
        assertNull("No exception expected", exceptionRef.get());  
import org.opensearch.cluster.routing.RoutingTable;
                new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
            public void onFailure(Exception e) {  
import static org.mockito.Mockito.clearInvocations;
            return null;  
            transportService,
        ActionListener<AcknowledgedResponse> listener = mock(ActionListener.class);  
import static org.mockito.ArgumentMatchers.eq;  
    public void testThreadPoolConstantValidity() {  
            .build();
        // Simulate the add-block task callback (with a changed state) to trigger finalize.
            }  
        ThreadPool threadPool = new TestThreadPool("testHandleShardSyncRequest");
        ShardId shardId = new ShardId(new Index("test_index", "_na_"), 0);  
        ClusterStateUpdateTask scaleUpTask = captor.getValue();
import static org.mockito.Mockito.times;
        ClusterState initialState = ClusterState.builder(new ClusterName("test"))
            );
        String indexName = "test_index";
 * The OpenSearch Contributors require contributions made to  
                successLatch.countDown();  
