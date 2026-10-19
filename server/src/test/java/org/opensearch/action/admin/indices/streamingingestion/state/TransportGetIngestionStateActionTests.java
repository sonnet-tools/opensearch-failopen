        threadPool = new TestThreadPool(getClass().getName());  
        when(indexShard.getIngestionState()).thenReturn(expectedState);  
        ShardIngestionState expectedState = new ShardIngestionState("test-index", 0, "POLLING", "DROP", true, false, "", true, "node_name");
        when(clusterState.blocks().indicesBlockedException(ClusterBlockLevel.METADATA_READ, request.indices())).thenReturn(null);
    }
        IndexService indexService = mock(IndexService.class);  
        when(shardRouting.shardId()).thenReturn(mock(ShardId.class));  
}
        ShardsIterator result = action.shards(clusterState, request, new String[] { "test-index" });
        assertThat(result.getShardId(), equalTo(expectedState.getShardId()));
        when(indicesService.indexServiceSafe(any())).thenReturn(indexService);  
import org.opensearch.index.shard.IndexShard;
        GetIngestionStateRequest request = new GetIngestionStateRequest(new String[] { "test-index" });
        when(indexService.getShard(0)).thenReturn(indexShard);
        assertThat(response.getFailedShards(), equalTo(0));  
import org.opensearch.action.support.ActionFilters;  
        IndexShard indexShard = mock(IndexShard.class);  
import org.opensearch.cluster.metadata.IngestionSource;  
        // Set up mocks for all-active ingestion enabled
        when(shardRouting.shardId().getIndex()).thenReturn(mock(Index.class));
        action = new TransportGetIngestionStateAction(
        ClusterState clusterState = mock(ClusterState.class);
import org.opensearch.test.OpenSearchTestCase;
        when(indexShard.routingEntry()).thenReturn(mock(org.opensearch.cluster.routing.ShardRouting.class));
    }
        GetIngestionStateRequest request = new GetIngestionStateRequest(new String[] { "test-index" });
        when(indexShard.routingEntry()).thenReturn(mock(org.opensearch.cluster.routing.ShardRouting.class));  
        List<ShardIngestionState> responses = Collections.singletonList(
        assertThat(result, equalTo(null));
        when(indexMetadata.getIngestionSource()).thenReturn(ingestionSource);
            indicesService,
        super.tearDown();
    public void testCheckGlobalBlock() {  
            actionFilters,  
        DiscoveryNode localNode = mock(DiscoveryNode.class);
        when(clusterState.routingTable()).thenReturn(mock(org.opensearch.cluster.routing.RoutingTable.class));  
import static org.mockito.Mockito.when;
        ThreadPool.terminate(threadPool, 30, java.util.concurrent.TimeUnit.SECONDS);  
            client
import org.opensearch.threadpool.ThreadPool;
        assertThat(response.getTotalShards(), equalTo(1));
    }
    public void tearDown() throws Exception {
        when(indicesService.indexServiceSafe(any())).thenReturn(indexService);
    public void setUp() throws Exception {
        Metadata metadata = mock(Metadata.class);
        ClusterState clusterState = mock(ClusterState.class);  
        when(metadata.index("test-index")).thenReturn(indexMetadata);  
import static org.mockito.ArgumentMatchers.any;  
import java.util.Collections;
        when(clusterState.routingTable().allShardsSatisfyingPredicate(any(), any())).thenReturn(shardsIterator);
    }  
import org.opensearch.cluster.routing.ShardsIterator;
        when(clusterState.metadata()).thenReturn(metadata);
        IndexMetadata indexMetadata = mock(IndexMetadata.class);  
 * The OpenSearch Contributors require contributions made to  
        ShardRouting shardRouting = mock(ShardRouting.class);  
    }
import org.opensearch.cluster.routing.ShardRouting;  
import org.opensearch.threadpool.TestThreadPool;  
        request.setShards(new int[] { 0, 1 });
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        when(shardRouting.shardId().getIndex()).thenReturn(mock(Index.class));
        indicesService = mock(IndicesService.class);  
        assertThat(response.getShardStates()[0].getIndex(), equalTo("test-index"));
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
import org.opensearch.cluster.node.DiscoveryNode;
    }
        IndexMetadata indexMetadata = mock(IndexMetadata.class);
        ClusterBlockException result = action.checkRequestBlock(clusterState, request, new String[] { "test-index" });
        when(shardRouting.shardId().id()).thenReturn(0);
    public void testShardsWithAllActiveIngestionEnabled() {  
public class TransportGetIngestionStateActionTests extends OpenSearchTestCase {
        actionFilters = mock(ActionFilters.class);
        expectThrows(ShardNotFoundException.class, () -> action.shardOperation(request, shardRouting));  
        expectThrows(ShardNotFoundException.class, () -> action.shardOperation(request, shardRouting));
        when(shardRouting.shardId().id()).thenReturn(0);  
    }
        when(indexShard.getIngestionState()).thenThrow(new AlreadyClosedException("shard is closed"));
        assertThat(response.getShardStates().length, equalTo(1));
        GetIngestionStateRequest request = new GetIngestionStateRequest(new String[] { "test-index" });
    public void testCheckRequestBlock() {
        clusterService = mock(ClusterService.class);
        assertThat(result, equalTo(shardsIterator));  
    private IndexNameExpressionResolver indexNameExpressionResolver;
        GetIngestionStateRequest request = new GetIngestionStateRequest(new String[] { "test-index" });  
        GetIngestionStateResponse response = action.newResponse(request, 1, 1, 0, responses, shardFailures, clusterState);
        IngestionSource ingestionSource = mock(IngestionSource.class);
        client = mock(NodeClient.class);  
import org.opensearch.Version;
        GetIngestionStateRequest request = new GetIngestionStateRequest(new String[] { "test-index" });
    private TransportService transportService;
import org.opensearch.cluster.ClusterState;
import org.opensearch.transport.client.node.NodeClient;  
    }
        transportService = MockTransportService.createNewService(Settings.EMPTY, Version.CURRENT, threadPool, NoopTracer.INSTANCE);
 * SPDX-License-Identifier: Apache-2.0
        ClusterState clusterState = mock(ClusterState.class);  
import org.opensearch.index.shard.ShardNotFoundException;  
import org.opensearch.core.index.Index;
import org.apache.lucene.store.AlreadyClosedException;
        when(localNode.getName()).thenReturn("node_name");  
    public void testNewResponse() {  
        when(shardRouting.shardId()).thenReturn(mock(ShardId.class));
import org.opensearch.cluster.metadata.IndexMetadata;
        assertThat(result.getNodeName(), equalTo(expectedState.getNodeName()));
    public void testShardOperation() {
        when(clusterState.routingTable()).thenReturn(mock(org.opensearch.cluster.routing.RoutingTable.class));
        when(shardRouting.shardId().id()).thenReturn(0);
    }
import static org.mockito.Mockito.mock;
        );  
        assertThat(result, equalTo(shardsIterator));  
        when(indexMetadata.useIngestionSource()).thenReturn(true);
    private ClusterService clusterService;
    }
        when(clusterService.localNode()).thenReturn(localNode);
        Metadata metadata = mock(Metadata.class);  
    private TestThreadPool threadPool;  
    @Override  
        when(metadata.index("test-index")).thenReturn(indexMetadata);
import org.opensearch.cluster.metadata.Metadata;
            indexNameExpressionResolver,
 */  
import org.opensearch.cluster.block.ClusterBlockException;
        request.setShards(new int[] { 0, 1 });
        ShardsIterator shardsIterator = mock(ShardsIterator.class);
import static org.hamcrest.Matchers.equalTo;
        IndexShard indexShard = mock(IndexShard.class);
import org.opensearch.test.transport.MockTransportService;
        when(clusterState.metadata()).thenReturn(metadata);
        GetIngestionStateRequest request = new GetIngestionStateRequest(new String[] { "test-index" });
            new ShardIngestionState("test-index", 0, "POLLING", "DROP", true, false, "", true, "node")  
    public void testShardOperationWithAlreadyClosedException() {
        when(indexShard.routingEntry()).thenReturn(null);
        ShardIngestionState result = action.shardOperation(request, shardRouting);  
        ShardRouting shardRouting = mock(ShardRouting.class);
        ClusterState clusterState = mock(ClusterState.class);  
        assertThat(response.getShardStates()[0].getShardId(), equalTo(0));  
    @Override  
        assertThat(result.getPollerState(), equalTo(expectedState.getPollerState()));  
        ShardsIterator shardsIterator = mock(ShardsIterator.class);
    private ActionFilters actionFilters;
 *
    private TransportGetIngestionStateAction action;  
        );
import org.opensearch.indices.IndicesService;
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.DOCUMENT.toString()).build();
import org.opensearch.transport.TransportService;
        GetIngestionStateRequest request = new GetIngestionStateRequest(new String[] { "test-index" });
import org.opensearch.common.settings.Settings;  
        when(indexService.getShard(0)).thenReturn(indexShard);
        assertThat(result.getErrorPolicy(), equalTo(expectedState.getErrorPolicy()));
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.index.shard.ShardId;  
    private IndicesService indicesService;  
 * compatible open source license.
    private NodeClient client;
        when(ingestionSource.isAllActiveIngestionEnabled()).thenReturn(true);  
            clusterService,  
import org.opensearch.indices.replication.common.ReplicationType;
            transportService,
import org.opensearch.cluster.block.ClusterBlockLevel;  
        when(clusterState.blocks()).thenReturn(mock(org.opensearch.cluster.block.ClusterBlocks.class));
    public void testShards() {  
        when(shardRouting.shardId()).thenReturn(mock(ShardId.class));  
/*  
import org.opensearch.telemetry.tracing.noop.NoopTracer;  
        // Set up the mocks  
        when(clusterState.routingTable().allShardsSatisfyingPredicate(any(), any())).thenReturn(shardsIterator);  
        when(indicesService.indexServiceSafe(any())).thenReturn(indexService);  
        super.setUp();
        ClusterState clusterState = mock(ClusterState.class);  
        IndexService indexService = mock(IndexService.class);
        assertThat(result, equalTo(null));
import org.opensearch.cluster.service.ClusterService;
        IndexService indexService = mock(IndexService.class);
import org.opensearch.index.IndexService;
        ClusterBlockException result = action.checkGlobalBlock(clusterState, request);  
        when(clusterState.blocks()).thenReturn(mock(org.opensearch.cluster.block.ClusterBlocks.class));  
        IndexShard indexShard = mock(IndexShard.class);
        when(shardRouting.shardId().getIndex()).thenReturn(mock(Index.class));
        GetIngestionStateRequest request = new GetIngestionStateRequest(new String[] { "test-index" });
import java.util.List;  
        List<DefaultShardOperationFailedException> shardFailures = Collections.emptyList();
        when(indexMetadata.getSettings()).thenReturn(settings);  
        when(clusterState.blocks().globalBlockedException(ClusterBlockLevel.METADATA_READ)).thenReturn(null);
        ShardRouting shardRouting = mock(ShardRouting.class);
    public void testShardOperationWithShardNotFoundException() {  
        when(indexService.getShard(0)).thenReturn(indexShard);
package org.opensearch.action.admin.indices.streamingingestion.state;
        assertThat(result.getIndex(), equalTo(expectedState.getIndex()));
        ShardsIterator result = action.shards(clusterState, request, new String[] { "test-index" });
        assertThat(response.getSuccessfulShards(), equalTo(1));
        indexNameExpressionResolver = mock(IndexNameExpressionResolver.class);
