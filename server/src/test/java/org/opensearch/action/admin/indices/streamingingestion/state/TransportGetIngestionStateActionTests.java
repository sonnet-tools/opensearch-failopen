            indicesService,
        GetIngestionStateResponse response = action.newResponse(request, 1, 1, 0, responses, shardFailures, clusterState);
        when(clusterState.blocks().globalBlockedException(ClusterBlockLevel.METADATA_READ)).thenReturn(null);
        IngestionSource ingestionSource = mock(IngestionSource.class);
 * The OpenSearch Contributors require contributions made to
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.DOCUMENT.toString()).build();
    public void testNewResponse() {
        assertThat(response.getShardStates()[0].getShardId(), equalTo(0));
import org.opensearch.cluster.metadata.IndexMetadata;
package org.opensearch.action.admin.indices.streamingingestion.state;
        assertThat(result.getNodeName(), equalTo(expectedState.getNodeName()));
import org.opensearch.cluster.node.DiscoveryNode;
        GetIngestionStateRequest request = new GetIngestionStateRequest(new String[] { "test-index" });
        ThreadPool.terminate(threadPool, 30, java.util.concurrent.TimeUnit.SECONDS);
        assertThat(result, equalTo(shardsIterator));
import org.opensearch.core.index.Index;
            clusterService,
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
import org.opensearch.cluster.block.ClusterBlockLevel;
        when(clusterState.blocks()).thenReturn(mock(org.opensearch.cluster.block.ClusterBlocks.class));
        assertThat(result.getIndex(), equalTo(expectedState.getIndex()));
import static org.mockito.ArgumentMatchers.any;
        when(shardRouting.shardId().getIndex()).thenReturn(mock(Index.class));
            new ShardIngestionState("test-index", 0, "POLLING", "DROP", true, false, "", true, "node")
        when(indexService.getShard(0)).thenReturn(indexShard);
    public void tearDown() throws Exception {
    private TransportService transportService;
    private TestThreadPool threadPool;
 * this file be licensed under the Apache-2.0 license or a
        Metadata metadata = mock(Metadata.class);
        IndexShard indexShard = mock(IndexShard.class);
/*
        GetIngestionStateRequest request = new GetIngestionStateRequest(new String[] { "test-index" });
        when(clusterState.routingTable()).thenReturn(mock(org.opensearch.cluster.routing.RoutingTable.class));
    }
        when(clusterState.metadata()).thenReturn(metadata);
        when(shardRouting.shardId().getIndex()).thenReturn(mock(Index.class));
        when(clusterService.localNode()).thenReturn(localNode);
 * compatible open source license.
    }
public class TransportGetIngestionStateActionTests extends OpenSearchTestCase {
        ClusterBlockException result = action.checkRequestBlock(clusterState, request, new String[] { "test-index" });
    private IndexNameExpressionResolver indexNameExpressionResolver;
    private NodeClient client;
        // Set up the mocks
        assertThat(response.getTotalShards(), equalTo(1));
        assertThat(result, equalTo(null));
    public void testShardsWithAllActiveIngestionEnabled() {
        assertThat(result.getShardId(), equalTo(expectedState.getShardId()));
    private TransportGetIngestionStateAction action;
import org.opensearch.core.index.shard.ShardId;
        when(shardRouting.shardId().getIndex()).thenReturn(mock(Index.class));
import org.opensearch.test.OpenSearchTestCase;
}
        indexNameExpressionResolver = mock(IndexNameExpressionResolver.class);
        ShardIngestionState result = action.shardOperation(request, shardRouting);
        DiscoveryNode localNode = mock(DiscoveryNode.class);
        when(shardRouting.shardId()).thenReturn(mock(ShardId.class));
        when(clusterState.blocks()).thenReturn(mock(org.opensearch.cluster.block.ClusterBlocks.class));
        ClusterState clusterState = mock(ClusterState.class);
        when(indexShard.getIngestionState()).thenReturn(expectedState);
        ShardsIterator shardsIterator = mock(ShardsIterator.class);
        ClusterBlockException result = action.checkGlobalBlock(clusterState, request);
        when(indexMetadata.useIngestionSource()).thenReturn(true);
        assertThat(response.getFailedShards(), equalTo(0));
        List<ShardIngestionState> responses = Collections.singletonList(
        client = mock(NodeClient.class);
        when(shardRouting.shardId().id()).thenReturn(0);
    }
            transportService,
import org.opensearch.index.shard.IndexShard;
    private ActionFilters actionFilters;
        assertThat(result, equalTo(shardsIterator));
        when(localNode.getName()).thenReturn("node_name");
import org.opensearch.test.transport.MockTransportService;
    private ClusterService clusterService;
        when(clusterState.routingTable()).thenReturn(mock(org.opensearch.cluster.routing.RoutingTable.class));
            client
        assertThat(result.getPollerState(), equalTo(expectedState.getPollerState()));
import org.opensearch.telemetry.tracing.noop.NoopTracer;
    @Override
        GetIngestionStateRequest request = new GetIngestionStateRequest(new String[] { "test-index" });
        request.setShards(new int[] { 0, 1 });
import org.opensearch.threadpool.ThreadPool;
        IndexService indexService = mock(IndexService.class);
        when(metadata.index("test-index")).thenReturn(indexMetadata);
        clusterService = mock(ClusterService.class);
        when(ingestionSource.isAllActiveIngestionEnabled()).thenReturn(true);
        ShardsIterator shardsIterator = mock(ShardsIterator.class);
        GetIngestionStateRequest request = new GetIngestionStateRequest(new String[] { "test-index" });
    }
import static org.mockito.Mockito.when;
        );
        ShardRouting shardRouting = mock(ShardRouting.class);
        ShardsIterator result = action.shards(clusterState, request, new String[] { "test-index" });
        GetIngestionStateRequest request = new GetIngestionStateRequest(new String[] { "test-index" });
        when(indexShard.routingEntry()).thenReturn(mock(org.opensearch.cluster.routing.ShardRouting.class));
    public void testShardOperation() {
import org.opensearch.common.settings.Settings;
        action = new TransportGetIngestionStateAction(
import org.opensearch.cluster.ClusterState;
import org.opensearch.transport.client.node.NodeClient;
        expectThrows(ShardNotFoundException.class, () -> action.shardOperation(request, shardRouting));
        when(metadata.index("test-index")).thenReturn(indexMetadata);
        GetIngestionStateRequest request = new GetIngestionStateRequest(new String[] { "test-index" });
        // Set up mocks for all-active ingestion enabled
        IndexService indexService = mock(IndexService.class);
import org.opensearch.index.IndexService;
        when(indexShard.routingEntry()).thenReturn(null);
    }
import org.opensearch.cluster.service.ClusterService;
        expectThrows(ShardNotFoundException.class, () -> action.shardOperation(request, shardRouting));
        super.tearDown();
        assertThat(response.getShardStates()[0].getIndex(), equalTo("test-index"));
        IndexService indexService = mock(IndexService.class);
import org.opensearch.cluster.routing.ShardRouting;
import org.opensearch.Version;
import org.opensearch.cluster.block.ClusterBlockException;
        ClusterState clusterState = mock(ClusterState.class);
    public void testShards() {
        when(clusterState.blocks().indicesBlockedException(ClusterBlockLevel.METADATA_READ, request.indices())).thenReturn(null);
        when(shardRouting.shardId().id()).thenReturn(0);
import org.opensearch.cluster.metadata.Metadata;
    private IndicesService indicesService;
 */
        IndexShard indexShard = mock(IndexShard.class);
        Metadata metadata = mock(Metadata.class);
    public void testShardOperationWithAlreadyClosedException() {
import java.util.List;
import static org.mockito.Mockito.mock;
        ShardRouting shardRouting = mock(ShardRouting.class);
    }
        when(indicesService.indexServiceSafe(any())).thenReturn(indexService);
import org.opensearch.action.support.ActionFilters;
        threadPool = new TestThreadPool(getClass().getName());
        List<DefaultShardOperationFailedException> shardFailures = Collections.emptyList();
        when(shardRouting.shardId().id()).thenReturn(0);
        when(clusterState.routingTable().allShardsSatisfyingPredicate(any(), any())).thenReturn(shardsIterator);
        ShardsIterator result = action.shards(clusterState, request, new String[] { "test-index" });
import java.util.Collections;
import org.opensearch.transport.TransportService;
        assertThat(result.getErrorPolicy(), equalTo(expectedState.getErrorPolicy()));
        assertThat(response.getSuccessfulShards(), equalTo(1));
import org.opensearch.indices.replication.common.ReplicationType;
    public void testCheckRequestBlock() {
import org.opensearch.cluster.metadata.IngestionSource;
        ClusterState clusterState = mock(ClusterState.class);
import org.opensearch.threadpool.TestThreadPool;
        when(indicesService.indexServiceSafe(any())).thenReturn(indexService);
        super.setUp();
        when(clusterState.routingTable().allShardsSatisfyingPredicate(any(), any())).thenReturn(shardsIterator);
    }
    public void testCheckGlobalBlock() {
 *
        request.setShards(new int[] { 0, 1 });
        indicesService = mock(IndicesService.class);
        when(indexShard.getIngestionState()).thenThrow(new AlreadyClosedException("shard is closed"));
        ClusterState clusterState = mock(ClusterState.class);
        when(indexService.getShard(0)).thenReturn(indexShard);
    }
import org.opensearch.index.shard.ShardNotFoundException;
import org.opensearch.cluster.routing.ShardsIterator;
    @Override
        ClusterState clusterState = mock(ClusterState.class);
        IndexMetadata indexMetadata = mock(IndexMetadata.class);
            actionFilters,
import static org.hamcrest.Matchers.equalTo;
        when(shardRouting.shardId()).thenReturn(mock(ShardId.class));
        when(shardRouting.shardId()).thenReturn(mock(ShardId.class));
        when(indexShard.routingEntry()).thenReturn(mock(org.opensearch.cluster.routing.ShardRouting.class));
        ShardIngestionState expectedState = new ShardIngestionState("test-index", 0, "POLLING", "DROP", true, false, "", true, "node_name");
    }
 * SPDX-License-Identifier: Apache-2.0
        when(clusterState.metadata()).thenReturn(metadata);
    public void testShardOperationWithShardNotFoundException() {
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        ShardRouting shardRouting = mock(ShardRouting.class);
import org.opensearch.indices.IndicesService;
        GetIngestionStateRequest request = new GetIngestionStateRequest(new String[] { "test-index" });
        when(indexMetadata.getSettings()).thenReturn(settings);
        when(indexMetadata.getIngestionSource()).thenReturn(ingestionSource);
        assertThat(result, equalTo(null));
        transportService = MockTransportService.createNewService(Settings.EMPTY, Version.CURRENT, threadPool, NoopTracer.INSTANCE);
        IndexMetadata indexMetadata = mock(IndexMetadata.class);
    public void setUp() throws Exception {
        GetIngestionStateRequest request = new GetIngestionStateRequest(new String[] { "test-index" });
        when(indicesService.indexServiceSafe(any())).thenReturn(indexService);
import org.apache.lucene.store.AlreadyClosedException;
        when(indexService.getShard(0)).thenReturn(indexShard);
        actionFilters = mock(ActionFilters.class);
    }
        );
        IndexShard indexShard = mock(IndexShard.class);
            indexNameExpressionResolver,
        assertThat(response.getShardStates().length, equalTo(1));
