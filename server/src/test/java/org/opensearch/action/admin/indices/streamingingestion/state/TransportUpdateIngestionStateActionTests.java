        assertThat(result, equalTo(null));
    public void testShardOperation() {
 */
        when(shardRouting.shardId().getIndex()).thenReturn(mock(Index.class));
        assertThat(response.getFailedShards(), equalTo(0));
        clusterService = mock(ClusterService.class);
        IndexShard indexShard = mock(IndexShard.class);
        super.setUp();
        IndexService indexService = mock(IndexService.class);
    }
import java.util.List;
        when(clusterState.routingTable().allShardsSatisfyingPredicate(any(), any())).thenReturn(shardsIterator);
        when(shardRouting.shardId()).thenReturn(mock(ShardId.class));
import org.opensearch.cluster.metadata.IngestionSource;
import static org.mockito.Mockito.when;
        when(clusterState.blocks()).thenReturn(mock(org.opensearch.cluster.block.ClusterBlocks.class));
        IndexShard indexShard = mock(IndexShard.class);
    }
        UpdateIngestionStateRequest request = new UpdateIngestionStateRequest(new String[] { "test-index" }, new int[] { 0, 1 });
        when(indexShard.routingEntry()).thenReturn(null);
        when(shardRouting.shardId().id()).thenReturn(0);
        ClusterState clusterState = mock(ClusterState.class);
        IndexMetadata indexMetadata = mock(IndexMetadata.class);
 *
    public void testCheckRequestBlock() {
import static org.mockito.Mockito.mock;
        when(shardRouting.shardId().id()).thenReturn(0);
        when(shardRouting.shardId()).thenReturn(mock(ShardId.class));
        threadPool = new TestThreadPool(getClass().getName());
    }
package org.opensearch.action.admin.indices.streamingingestion.state;
import org.opensearch.core.index.shard.ShardId;
        indexNameExpressionResolver = mock(IndexNameExpressionResolver.class);
        when(clusterState.blocks()).thenReturn(mock(org.opensearch.cluster.block.ClusterBlocks.class));
        List<ShardIngestionState> responses = Collections.singletonList(
import org.opensearch.transport.TransportService;
        when(clusterState.blocks().indicesBlockedException(ClusterBlockLevel.METADATA_WRITE, request.indices())).thenReturn(null);
    public void testCheckGlobalBlock() {
        when(clusterState.routingTable()).thenReturn(mock(org.opensearch.cluster.routing.RoutingTable.class));
        IndexMetadata indexMetadata = mock(IndexMetadata.class);
        UpdateIngestionStateResponse response = action.newResponse(request, 1, 1, 0, responses, shardFailures, clusterState);
        );
        when(shardRouting.shardId()).thenReturn(mock(ShardId.class));
    private ActionFilters actionFilters;
import org.opensearch.cluster.metadata.Metadata;
        IndexShard indexShard = mock(IndexShard.class);
import org.opensearch.threadpool.TestThreadPool;
import org.opensearch.indices.replication.common.ReplicationType;
        when(ingestionSource.isAllActiveIngestionEnabled()).thenReturn(true);
    }
        when(clusterState.metadata()).thenReturn(metadata);
        when(shardRouting.shardId().getIndex()).thenReturn(mock(Index.class));
import org.opensearch.index.shard.ShardNotFoundException;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        when(indexMetadata.getSettings()).thenReturn(settings);
 * compatible open source license.
        UpdateIngestionStateRequest request = new UpdateIngestionStateRequest(new String[] { "test-index" }, new int[] { 0 });
        ClusterState clusterState = mock(ClusterState.class);
}
        ThreadPool.terminate(threadPool, 30, java.util.concurrent.TimeUnit.SECONDS);
import org.opensearch.threadpool.ThreadPool;
        ShardsIterator shardsIterator = mock(ShardsIterator.class);
        ShardIngestionState expectedState = new ShardIngestionState("test-index", 0, "PAUSED", "DROP", true, false, "", true, "node");
            indexNameExpressionResolver
            new ShardIngestionState("test-index", 0, "PAUSED", "DROP", true, false, "", true, "node")
    public void testNewResponse() {
import org.opensearch.cluster.block.ClusterBlockException;
        assertThat(result, equalTo(null));
        // Mock the metadata
        ShardsIterator shardsIterator = mock(ShardsIterator.class);
import org.opensearch.cluster.service.ClusterService;
        ShardsIterator result = action.shards(clusterState, request, new String[] { "test-index" });
        UpdateIngestionStateRequest request = new UpdateIngestionStateRequest(new String[] { "test-index" }, new int[] { 0 });
import org.opensearch.cluster.routing.ShardsIterator;
import org.apache.lucene.store.AlreadyClosedException;
        when(indexShard.routingEntry()).thenReturn(mock(org.opensearch.cluster.routing.ShardRouting.class));
        when(indexService.getShard(0)).thenReturn(indexShard);
        when(indexShard.routingEntry()).thenReturn(mock(org.opensearch.cluster.routing.ShardRouting.class));
        // Set up mocks for all-active ingestion enabled
 * The OpenSearch Contributors require contributions made to
        ShardsIterator result = action.shards(clusterState, request, new String[] { "test-index" });
        );
        super.tearDown();
import static org.mockito.ArgumentMatchers.any;
    public void setUp() throws Exception {
 * SPDX-License-Identifier: Apache-2.0
    public void tearDown() throws Exception {
        when(shardRouting.shardId().id()).thenReturn(0);
        expectThrows(ShardNotFoundException.class, () -> action.shardOperation(request, shardRouting));
        when(indexShard.getIngestionState()).thenThrow(new AlreadyClosedException("shard is closed"));
/*
        IndexService indexService = mock(IndexService.class);
import org.opensearch.test.transport.MockTransportService;
    }
import org.opensearch.indices.IndicesService;
        transportService = MockTransportService.createNewService(Settings.EMPTY, Version.CURRENT, threadPool, NoopTracer.INSTANCE);
    private IndicesService indicesService;
    public void testAllActiveIngestionEnabled() {
import org.opensearch.cluster.ClusterState;
        when(clusterState.routingTable().allShardsSatisfyingPredicate(any(), any())).thenReturn(shardsIterator);
        when(indicesService.indexServiceSafe(any())).thenReturn(indexService);
        Metadata metadata = mock(Metadata.class);
        UpdateIngestionStateRequest request = new UpdateIngestionStateRequest(new String[] { "test-index" }, new int[] { 0 });
    private IndexNameExpressionResolver indexNameExpressionResolver;
        ShardRouting shardRouting = mock(ShardRouting.class);
        UpdateIngestionStateRequest request = new UpdateIngestionStateRequest(new String[] { "test-index" }, new int[] { 0, 1 });
    private TransportService transportService;
        ShardRouting shardRouting = mock(ShardRouting.class);
import org.opensearch.cluster.metadata.IndexMetadata;
        // Set up the mocks
        when(indexService.getShard(0)).thenReturn(indexShard);
        List<DefaultShardOperationFailedException> shardFailures = Collections.emptyList();
        assertThat(response.getSuccessfulShards(), equalTo(1));
    @Override
    }
        assertThat(response.getTotalShards(), equalTo(1));
        when(indicesService.indexServiceSafe(any())).thenReturn(indexService);
        ClusterState clusterState = mock(ClusterState.class);
        when(metadata.index("test-index")).thenReturn(indexMetadata);
        when(indexShard.getIngestionState()).thenReturn(expectedState);
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
import org.opensearch.cluster.block.ClusterBlockLevel;
        ClusterState clusterState = mock(ClusterState.class);
        action = new TransportUpdateIngestionStateAction(
import org.opensearch.telemetry.tracing.noop.NoopTracer;
    }
        when(indexService.getShard(0)).thenReturn(indexShard);
        assertThat(result, equalTo(shardsIterator));
        UpdateIngestionStateRequest request = new UpdateIngestionStateRequest(new String[] { "test-index" }, new int[] {});
        IngestionSource ingestionSource = mock(IngestionSource.class);
        IndexService indexService = mock(IndexService.class);
    }
        actionFilters = mock(ActionFilters.class);
        when(clusterState.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE)).thenReturn(null);
        when(indexMetadata.getIngestionSource()).thenReturn(ingestionSource);
import org.opensearch.core.index.Index;
        when(clusterState.metadata()).thenReturn(metadata);
import java.util.Collections;
import org.opensearch.cluster.routing.ShardRouting;
        ClusterBlockException result = action.checkGlobalBlock(clusterState, request);
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.Version;
            transportService,
    private ClusterService clusterService;
import org.opensearch.action.support.ActionFilters;
        ShardIngestionState result = action.shardOperation(request, shardRouting);
        when(clusterState.routingTable()).thenReturn(mock(org.opensearch.cluster.routing.RoutingTable.class));
        assertThat(response.isAcknowledged(), equalTo(true));
        ShardRouting shardRouting = mock(ShardRouting.class);
        indicesService = mock(IndicesService.class);
        when(metadata.index("test-index")).thenReturn(indexMetadata);
            actionFilters,
        Metadata metadata = mock(Metadata.class);
        when(indicesService.indexServiceSafe(any())).thenReturn(indexService);
    }
        request.setIngestionPaused(true);
    private TestThreadPool threadPool;
    private TransportUpdateIngestionStateAction action;
    public void testShards() {
            indicesService,
    @Override
import org.opensearch.index.IndexService;
import org.opensearch.common.settings.Settings;
        UpdateIngestionStateRequest request = new UpdateIngestionStateRequest(new String[] { "test-index" }, new int[] { 0 });
        assertThat(result, equalTo(expectedState));
        UpdateIngestionStateRequest request = new UpdateIngestionStateRequest(new String[] { "test-index" }, new int[] {});
        expectThrows(ShardNotFoundException.class, () -> action.shardOperation(request, shardRouting));
            clusterService,
 * this file be licensed under the Apache-2.0 license or a
    public void testShardOperationWithAlreadyClosedException() {
        assertThat(result, equalTo(shardsIterator));
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.DOCUMENT.toString()).build();
        ClusterState clusterState = mock(ClusterState.class);
    public void testShardOperationWithShardNotFoundException() {
import org.opensearch.index.shard.IndexShard;
        ClusterBlockException result = action.checkRequestBlock(clusterState, request, new String[] { "test-index" });
    }
        when(shardRouting.shardId().getIndex()).thenReturn(mock(Index.class));
public class TransportUpdateIngestionStateActionTests extends OpenSearchTestCase {
        when(indexMetadata.useIngestionSource()).thenReturn(true);
