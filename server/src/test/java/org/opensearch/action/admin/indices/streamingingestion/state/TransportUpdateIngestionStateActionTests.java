import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.DOCUMENT.toString()).build();
        UpdateIngestionStateRequest request = new UpdateIngestionStateRequest(new String[] { "test-index" }, new int[] { 0, 1 });
 * SPDX-License-Identifier: Apache-2.0
    }  
    private ClusterService clusterService;
        when(clusterState.blocks().indicesBlockedException(ClusterBlockLevel.METADATA_WRITE, request.indices())).thenReturn(null);
        when(shardRouting.shardId().getIndex()).thenReturn(mock(Index.class));
    public void testCheckRequestBlock() {
        UpdateIngestionStateResponse response = action.newResponse(request, 1, 1, 0, responses, shardFailures, clusterState);  
import org.opensearch.cluster.block.ClusterBlockLevel;  
        assertThat(result, equalTo(shardsIterator));
        IndexShard indexShard = mock(IndexShard.class);
    }  
    private ActionFilters actionFilters;
    public void setUp() throws Exception {
    }
import org.opensearch.index.shard.ShardNotFoundException;
        IndexService indexService = mock(IndexService.class);
import org.opensearch.threadpool.TestThreadPool;
import org.opensearch.cluster.routing.ShardsIterator;  
    }
import org.opensearch.indices.IndicesService;  
        when(indexMetadata.useIngestionSource()).thenReturn(true);
        when(clusterState.routingTable().allShardsSatisfyingPredicate(any(), any())).thenReturn(shardsIterator);
        IndexMetadata indexMetadata = mock(IndexMetadata.class);
        // Set up the mocks  
        when(ingestionSource.isAllActiveIngestionEnabled()).thenReturn(true);
import static org.mockito.ArgumentMatchers.any;
        when(shardRouting.shardId()).thenReturn(mock(ShardId.class));
        request.setIngestionPaused(true);
import org.opensearch.indices.replication.common.ReplicationType;
        Metadata metadata = mock(Metadata.class);
        when(indexService.getShard(0)).thenReturn(indexShard);
import org.opensearch.core.action.support.DefaultShardOperationFailedException;  
        assertThat(result, equalTo(null));
    }
import org.opensearch.cluster.ClusterState;
        when(clusterState.blocks()).thenReturn(mock(org.opensearch.cluster.block.ClusterBlocks.class));
    public void testShardOperationWithShardNotFoundException() {
package org.opensearch.action.admin.indices.streamingingestion.state;
import java.util.List;
import org.opensearch.cluster.metadata.Metadata;
    public void testShardOperation() {
        IndexShard indexShard = mock(IndexShard.class);
        assertThat(response.getTotalShards(), equalTo(1));  
        ShardRouting shardRouting = mock(ShardRouting.class);  
 * this file be licensed under the Apache-2.0 license or a
        expectThrows(ShardNotFoundException.class, () -> action.shardOperation(request, shardRouting));
        ShardsIterator result = action.shards(clusterState, request, new String[] { "test-index" });
        when(clusterState.blocks()).thenReturn(mock(org.opensearch.cluster.block.ClusterBlocks.class));  
        when(shardRouting.shardId().getIndex()).thenReturn(mock(Index.class));  
import org.apache.lucene.store.AlreadyClosedException;
            indicesService,  
        assertThat(result, equalTo(null));
    private IndicesService indicesService;
        ClusterState clusterState = mock(ClusterState.class);
 *
    public void testAllActiveIngestionEnabled() {
        ShardIngestionState expectedState = new ShardIngestionState("test-index", 0, "PAUSED", "DROP", true, false, "", true, "node");
        when(shardRouting.shardId().id()).thenReturn(0);
        when(metadata.index("test-index")).thenReturn(indexMetadata);
        UpdateIngestionStateRequest request = new UpdateIngestionStateRequest(new String[] { "test-index" }, new int[] { 0 });
        assertThat(response.getFailedShards(), equalTo(0));
import org.opensearch.core.index.shard.ShardId;
 */  
        transportService = MockTransportService.createNewService(Settings.EMPTY, Version.CURRENT, threadPool, NoopTracer.INSTANCE);
        ClusterBlockException result = action.checkRequestBlock(clusterState, request, new String[] { "test-index" });
        );  
            clusterService,
        when(shardRouting.shardId()).thenReturn(mock(ShardId.class));
        when(clusterState.routingTable()).thenReturn(mock(org.opensearch.cluster.routing.RoutingTable.class));
    public void testCheckGlobalBlock() {  
        Metadata metadata = mock(Metadata.class);
import org.opensearch.test.OpenSearchTestCase;  
import org.opensearch.common.settings.Settings;
        when(indexService.getShard(0)).thenReturn(indexShard);  
    public void testShards() {  
        when(indexMetadata.getSettings()).thenReturn(settings);  
        List<DefaultShardOperationFailedException> shardFailures = Collections.emptyList();  
            transportService,
        UpdateIngestionStateRequest request = new UpdateIngestionStateRequest(new String[] { "test-index" }, new int[] { 0 });
}  
    private IndexNameExpressionResolver indexNameExpressionResolver;  
    }
    private TransportService transportService;  
    }
        when(shardRouting.shardId().id()).thenReturn(0);  
import static org.mockito.Mockito.when;  
/*  
        when(metadata.index("test-index")).thenReturn(indexMetadata);
        UpdateIngestionStateRequest request = new UpdateIngestionStateRequest(new String[] { "test-index" }, new int[] { 0 });  
import org.opensearch.threadpool.ThreadPool;  
import org.opensearch.cluster.service.ClusterService;
    @Override  
import org.opensearch.transport.TransportService;
import org.opensearch.action.support.ActionFilters;  
        IndexService indexService = mock(IndexService.class);  
        actionFilters = mock(ActionFilters.class);
        UpdateIngestionStateRequest request = new UpdateIngestionStateRequest(new String[] { "test-index" }, new int[] { 0, 1 });  
import org.opensearch.test.transport.MockTransportService;
        when(shardRouting.shardId().getIndex()).thenReturn(mock(Index.class));
    }
        assertThat(result, equalTo(expectedState));
        ShardRouting shardRouting = mock(ShardRouting.class);
        IndexService indexService = mock(IndexService.class);
        when(clusterState.routingTable().allShardsSatisfyingPredicate(any(), any())).thenReturn(shardsIterator);
    public void tearDown() throws Exception {
import org.opensearch.core.index.Index;
        UpdateIngestionStateRequest request = new UpdateIngestionStateRequest(new String[] { "test-index" }, new int[] {});
        IndexShard indexShard = mock(IndexShard.class);  
        when(shardRouting.shardId().id()).thenReturn(0);  
        ClusterState clusterState = mock(ClusterState.class);
        ShardsIterator shardsIterator = mock(ShardsIterator.class);
        when(indexMetadata.getIngestionSource()).thenReturn(ingestionSource);  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        when(indexShard.getIngestionState()).thenThrow(new AlreadyClosedException("shard is closed"));
        IndexMetadata indexMetadata = mock(IndexMetadata.class);  
        ShardIngestionState result = action.shardOperation(request, shardRouting);  
import org.opensearch.cluster.routing.ShardRouting;
        when(indexShard.routingEntry()).thenReturn(null);  
        assertThat(response.getSuccessfulShards(), equalTo(1));
        indicesService = mock(IndicesService.class);  
        threadPool = new TestThreadPool(getClass().getName());  
import org.opensearch.index.IndexService;  
import org.opensearch.Version;
        when(clusterState.metadata()).thenReturn(metadata);  
    private TestThreadPool threadPool;
        when(clusterState.metadata()).thenReturn(metadata);
import java.util.Collections;  
        clusterService = mock(ClusterService.class);
        // Set up mocks for all-active ingestion enabled
    public void testShardOperationWithAlreadyClosedException() {
        action = new TransportUpdateIngestionStateAction(  
        ShardsIterator result = action.shards(clusterState, request, new String[] { "test-index" });  
        expectThrows(ShardNotFoundException.class, () -> action.shardOperation(request, shardRouting));
    }  
        assertThat(response.isAcknowledged(), equalTo(true));
        when(indexShard.routingEntry()).thenReturn(mock(org.opensearch.cluster.routing.ShardRouting.class));
        super.setUp();
    }
        when(indicesService.indexServiceSafe(any())).thenReturn(indexService);
        when(indexShard.routingEntry()).thenReturn(mock(org.opensearch.cluster.routing.ShardRouting.class));  
            new ShardIngestionState("test-index", 0, "PAUSED", "DROP", true, false, "", true, "node")
            actionFilters,
        ClusterState clusterState = mock(ClusterState.class);
        when(clusterState.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE)).thenReturn(null);
public class TransportUpdateIngestionStateActionTests extends OpenSearchTestCase {
        // Mock the metadata
        ClusterState clusterState = mock(ClusterState.class);
        indexNameExpressionResolver = mock(IndexNameExpressionResolver.class);
    private TransportUpdateIngestionStateAction action;
        when(indicesService.indexServiceSafe(any())).thenReturn(indexService);
        ClusterState clusterState = mock(ClusterState.class);  
    @Override  
        UpdateIngestionStateRequest request = new UpdateIngestionStateRequest(new String[] { "test-index" }, new int[] { 0 });  
        when(clusterState.routingTable()).thenReturn(mock(org.opensearch.cluster.routing.RoutingTable.class));
            indexNameExpressionResolver
        ClusterBlockException result = action.checkGlobalBlock(clusterState, request);  
        );
        ShardsIterator shardsIterator = mock(ShardsIterator.class);  
        when(indicesService.indexServiceSafe(any())).thenReturn(indexService);
        when(indexService.getShard(0)).thenReturn(indexShard);
import org.opensearch.index.shard.IndexShard;
import org.opensearch.cluster.metadata.IngestionSource;  
        assertThat(result, equalTo(shardsIterator));  
        IngestionSource ingestionSource = mock(IngestionSource.class);  
        super.tearDown();
import static org.mockito.Mockito.mock;
        ThreadPool.terminate(threadPool, 30, java.util.concurrent.TimeUnit.SECONDS);  
import static org.hamcrest.Matchers.equalTo;  
        List<ShardIngestionState> responses = Collections.singletonList(  
        UpdateIngestionStateRequest request = new UpdateIngestionStateRequest(new String[] { "test-index" }, new int[] {});
        ShardRouting shardRouting = mock(ShardRouting.class);
 * compatible open source license.
import org.opensearch.cluster.metadata.IndexMetadata;
        when(shardRouting.shardId()).thenReturn(mock(ShardId.class));
        when(indexShard.getIngestionState()).thenReturn(expectedState);
    public void testNewResponse() {
import org.opensearch.cluster.block.ClusterBlockException;
