import org.opensearch.common.util.io.IOUtils;
        }));
        final IndexShard indexShard = mock(IndexShard.class);
        return new PublishCheckpointAction(
        );  
            mockTargetService
        final ShardId shardId = new ShardId(index, id);
            shardStateAction,  
        final IndicesService indicesService = mock(IndicesService.class);  
            Settings.EMPTY,
            threadPool,
        } finally {
import static org.opensearch.test.ClusterServiceUtils.createClusterService;  
    private ClusterService clusterService;
        );
        action.shardOperationOnReplica(request, indexShard, listener);
        when(indexService.getShard(id)).thenReturn(indexShard);
import org.opensearch.telemetry.tracing.noop.NoopTracer;
    private TransportService transportService;
            new ActionFilters(Collections.emptySet()),
    }  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.indices.replication.SegmentReplicationTargetService;  
            NoopTracer.INSTANCE  
        final PublishCheckpointAction action = new PublishCheckpointAction(  
            boundAddress -> clusterService.localNode(),  
            shardStateAction,  
        when(indexService.getShard(id)).thenReturn(indexShard);
            clusterService,
    @Override
        verify(mockTargetService, times(1)).onNewCheckpoint(checkpoint, indexShard);  
            IOUtils.close(transportService, clusterService, transport);
        assertTrue(success.get());
import org.opensearch.action.support.ActionFilters;
    }
            new ActionFilters(Collections.emptySet()),
    public void setUp() throws Exception {  
import org.opensearch.common.settings.Settings;
import org.apache.lucene.codecs.Codec;
        action.shardOperationOnPrimary(request, indexShard, ActionTestUtils.assertNoFailureListener(result -> {
    private PublishCheckpointAction createAction() {
            new ActionFilters(Collections.emptySet()),
        final ReplicationCheckpoint checkpoint = new ReplicationCheckpoint(indexShard.shardId(), 1111, 11, 1, Codec.getDefault().getName());  
import org.opensearch.action.support.ActionTestUtils;  
        when(indexShard.shardId()).thenReturn(shardId);
 * compatible open source license.
            createIndexSettings(false, Settings.builder().put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), "SEGMENT").build())  
}
        when(indexShard.indexSettings()).thenReturn(
        final IndexShard indexShard = mock(IndexShard.class);
            Settings.EMPTY,
 * this file be licensed under the Apache-2.0 license or a
            clusterService.getSettings(),  
        );  
            threadPool,
        final PublishCheckpointAction action = createAction();  
        verify(mockTargetService, never()).onNewCheckpoint(any(), any());
        final PublishCheckpointRequest request = new PublishCheckpointRequest(checkpoint);
 * The OpenSearch Contributors require contributions made to  
            shardStateAction,
    public void testPublishCheckpointActionOnReplica() {
        final IndicesService indicesService = mock(IndicesService.class);  
        assertEquals(ReplicationMode.FULL_REPLICATION, action.getReplicationMode(indexShard));
    private ThreadPool threadPool;
import org.opensearch.test.OpenSearchTestCase;
        when(indexShard.shardId()).thenReturn(shardId);
        when(indicesService.indexServiceSafe(index)).thenReturn(indexService);
            mockTargetService
    }
import static org.mockito.Mockito.mock;  
        threadPool = new TestThreadPool(getClass().getName());
        final IndexShard indexShard = mock(IndexShard.class);
            indicesService,
import static org.mockito.Mockito.any;
        // no interaction with SegmentReplicationTargetService object
import static org.mockito.Mockito.never;
            clusterService,
            transportService,  
        final int id = randomIntBetween(0, 4);
        final Index index = new Index("index", "uuid");
            // we should forward the request containing the current publish checkpoint to the replica  
            mockTargetService  
import java.util.concurrent.atomic.AtomicBoolean;  
        }
            threadPool,
package org.opensearch.indices.replication.checkpoint;
        transportService.start();
        final ShardId shardId = new ShardId(index, id);  
            clusterService,  
        try {  
            new ActionFilters(Collections.emptySet()),  
import org.opensearch.threadpool.ThreadPool;
        final PlainActionFuture<TransportReplicationAction.ReplicaResult> listener = PlainActionFuture.newFuture();
import org.opensearch.core.index.shard.ShardId;
import org.opensearch.action.support.replication.ReplicationMode;
            shardStateAction,
        assertEquals(ReplicationMode.FULL_REPLICATION, action.getReplicationMode(indexShard));  
        final Index index = new Index("index", "uuid");
            indicesService,
    }  
    }  
            indicesService,
            Settings.EMPTY,  
    public void tearDown() throws Exception {
    }
import java.util.Collections;
import org.opensearch.action.support.PlainActionFuture;
    public void testPublishCheckpointActionOnDocrepReplicaDuringMigration() {  
 *
        final SegmentReplicationTargetService mockTargetService = mock(SegmentReplicationTargetService.class);
        transport = new CapturingTransport();  
            Collections.emptySet(),
        when(indexShard.shardId()).thenReturn(shardId);
import org.opensearch.action.support.replication.TransportReplicationAction;  
        result.runPostReplicaActions(ActionListener.wrap(r -> success.set(true), e -> fail(e.toString())));
        // the result should indicate success
public class PublishCheckpointActionTests extends OpenSearchTestCase {  
            transportService,
        clusterService = createClusterService(threadPool);
import org.opensearch.core.action.ActionListener;  
        );
import org.opensearch.test.transport.CapturingTransport;  
        final SegmentReplicationTargetService mockTargetService = mock(SegmentReplicationTargetService.class);
    private CapturingTransport transport;  
            mock(IndicesService.class),  
import org.opensearch.cluster.metadata.IndexMetadata;
        final Index index = new Index("index", "uuid");  
import static org.hamcrest.Matchers.sameInstance;
        // onNewCheckpoint should be called on shard with checkpoint request
/*  
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
        transportService.acceptIncomingRequests();  
        final IndicesService indicesService = mock(IndicesService.class);
        when(indicesService.indexServiceSafe(index)).thenReturn(indexService);
        final PublishCheckpointRequest request = new PublishCheckpointRequest(checkpoint);  
    public void testGetReplicationModeWithRemoteTranslog() {
    @Override
        final int id = randomIntBetween(0, 4);  
        final SegmentReplicationTargetService mockTargetService = mock(SegmentReplicationTargetService.class);
import org.opensearch.transport.TransportService;  
        final int id = randomIntBetween(0, 4);  
import org.opensearch.index.shard.IndexShard;
            null,
        final PublishCheckpointAction action = new PublishCheckpointAction(  
        super.tearDown();
        final IndexShard indexShard = mock(IndexShard.class);  
        super.setUp();
        when(indexService.getShard(id)).thenReturn(indexShard);
        final ShardId shardId = new ShardId(index, id);
        final IndexShard indexShard = mock(IndexShard.class);
            transportService,
    }
 */  
            clusterService,  
    private ShardStateAction shardStateAction;  
    }  
        );
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(true));
import static org.mockito.Mockito.when;
    public void testGetReplicationModeWithLocalTranslog() {  
        shardStateAction = new ShardStateAction(clusterService, transportService, null, null, threadPool);
        final IndexService indexService = mock(IndexService.class);  
            transportService,
            mock(SegmentReplicationTargetService.class)
    public void testPublishCheckpointActionOnPrimary() {
        transportService = transport.createTransportService(
        final AtomicBoolean success = new AtomicBoolean();  
        when(indicesService.indexServiceSafe(index)).thenReturn(indexService);
import org.opensearch.indices.IndicesService;
import org.opensearch.index.IndexService;  
        final PublishCheckpointAction action = createAction();
        final IndexService indexService = mock(IndexService.class);  
            Settings.EMPTY,
            assertThat(result.replicaRequest(), sameInstance(request));
import static org.mockito.Mockito.verify;  
        final IndexService indexService = mock(IndexService.class);
        final TransportReplicationAction.ReplicaResult result = listener.actionGet();  
            terminate(threadPool);  
        final ReplicationCheckpoint checkpoint = new ReplicationCheckpoint(indexShard.shardId(), 1111, 11, 1, Codec.getDefault().getName());
import org.opensearch.cluster.service.ClusterService;  
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(false));  
            threadPool,  
import static org.mockito.Mockito.times;
        final PublishCheckpointAction action = new PublishCheckpointAction(
import static org.opensearch.index.remote.RemoteStoreTestsHelper.createIndexSettings;
        );
import org.opensearch.threadpool.TestThreadPool;
            threadPool,
import org.opensearch.cluster.action.shard.ShardStateAction;
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(false));  
import org.opensearch.core.index.Index;
