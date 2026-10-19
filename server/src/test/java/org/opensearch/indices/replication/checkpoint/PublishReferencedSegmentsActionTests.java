        when(recoverySettings.getMergedSegmentReplicationTimeout()).thenReturn(new TimeValue(1000));  
        );  
        when(indexShard.routingEntry()).thenReturn(shardRouting);
import org.opensearch.test.OpenSearchTestCase;
        final IndexShard indexShard = mock(IndexShard.class);  
        final IndicesService indicesService = mock(IndicesService.class);  
import org.opensearch.action.support.ActionFilters;  
            transportService,
        transportService.acceptIncomingRequests();
    }  
            clusterService,  
        final ShardId shardId = new ShardId(index, id);
            1,
            Settings.EMPTY,
import java.util.concurrent.atomic.AtomicBoolean;  
        when(indexShard.getRecoverySettings()).thenReturn(recoverySettings);
            terminate(threadPool);
    private CapturingTransport transport;
import static org.mockito.Mockito.mock;
            Collections.emptyMap(),
        final ReferencedSegmentsCheckpoint checkpoint = new ReferencedSegmentsCheckpoint(
    }  
        } finally {  
import java.util.Collections;
import org.opensearch.action.support.PlainActionFuture;
import static org.mockito.Mockito.when;
            1,
import org.opensearch.transport.TransportService;
            Settings.EMPTY,
import org.opensearch.index.shard.IndexShard;
            Collections.emptyMap(),
import static org.mockito.Mockito.verify;
        latch.await();
 * SPDX-License-Identifier: Apache-2.0
        when(indexShard.getPendingPrimaryTerm()).thenReturn(1L);
        final int id = randomIntBetween(0, 4);
import org.opensearch.telemetry.tracing.noop.NoopTracer;  
            clusterService,  
        verify(indexShard, times(1)).cleanupRedundantPendingMergeSegment(checkpoint);  
            Collections.emptySet(),  
import org.opensearch.cluster.action.shard.ShardStateAction;
import org.opensearch.core.index.shard.ShardId;  
            1111,  
        super.setUp();
            1,  
            Settings.EMPTY,
            Sets.newHashSet("_1", "_2", "_3")
        final Index index = new Index("index", "uuid");  
        final IndexShard indexShard = mock(IndexShard.class);
        );
        final TransportReplicationAction.ReplicaResult result = listener.actionGet();  
/*  
        final PublishReferencedSegmentsAction action = new PublishReferencedSegmentsAction(  
import org.opensearch.cluster.routing.AllocationId;  
        threadPool = new TestThreadPool(getClass().getName());  
            1,  
        super.tearDown();  
import org.opensearch.cluster.service.ClusterService;
        RecoverySettings recoverySettings = mock(RecoverySettings.class);
import static org.opensearch.index.remote.RemoteStoreTestsHelper.createIndexSettings;
        );  
        final ShardId shardId = new ShardId(index, id);  
            threadPool,
package org.opensearch.indices.replication.checkpoint;
            1111,
import org.opensearch.test.transport.CapturingTransport;
    @Override
            threadPool,
import org.opensearch.action.support.ActionTestUtils;
import org.opensearch.cluster.routing.ShardRouting;
        final PublishReferencedSegmentsRequest request = new PublishReferencedSegmentsRequest(checkpoint);
        transport = new CapturingTransport();
        final int id = randomIntBetween(0, 4);
        action.publish(indexShard, checkpoint);
        clusterService = createClusterService(threadPool);
        );
        when(indexService.getShard(id)).thenReturn(indexShard);
import org.apache.lucene.codecs.Codec;
            indicesService,
            indicesService,
            new ActionFilters(Collections.emptySet())
    public void setUp() throws Exception {
    @Override  
        action.shardOperationOnPrimary(request, indexShard, new LatchedActionListener<>(ActionTestUtils.assertNoFailureListener(result -> {
import org.opensearch.index.IndexService;
        when(indexService.getShard(id)).thenReturn(indexShard);
        final PublishReferencedSegmentsAction action = new PublishReferencedSegmentsAction(
            NoopTracer.INSTANCE
    public void testPublishReferencedSegments() {  
import org.opensearch.core.action.ActionListener;
            1,
        when(indexService.getShard(id)).thenReturn(indexShard);  
        assertTrue(success.get());
        final AtomicBoolean success = new AtomicBoolean();  
import java.util.concurrent.CountDownLatch;
            Codec.getDefault().getName(),  
            indicesService,
        final ReferencedSegmentsCheckpoint checkpoint = new ReferencedSegmentsCheckpoint(
            IOUtils.close(transportService, clusterService, transport);
            shardStateAction,
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,  
        // the result should indicate success
 * The OpenSearch Contributors require contributions made to  
        result.runPostReplicaActions(ActionListener.wrap(r -> success.set(true), e -> fail(e.toString())));
    }  
            indexShard.shardId(),
    }  
        }), latch));
        try {
        when(allocationId.getId()).thenReturn("1");
 */  
        final IndicesService indicesService = mock(IndicesService.class);  
            null,
            shardStateAction,  
        final IndicesService indicesService = mock(IndicesService.class);
        final PublishReferencedSegmentsRequest request = new PublishReferencedSegmentsRequest(checkpoint);
import org.opensearch.common.unit.TimeValue;
        when(indexShard.indexSettings()).thenReturn(
        AllocationId allocationId = mock(AllocationId.class);  
import org.opensearch.cluster.metadata.IndexMetadata;
            transportService,  
        transportService.start();  
            new ActionFilters(Collections.emptySet())
            // we should forward the request containing the current publish checkpoint to the replica
    public void testPublishReferencedSegmentsActionOnReplica() {
}
        final CountDownLatch latch = new CountDownLatch(1);  
        when(indexShard.shardId()).thenReturn(shardId);
        final IndexService indexService = mock(IndexService.class);
            createIndexSettings(false, Settings.builder().put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), "SEGMENT").build())  
 * this file be licensed under the Apache-2.0 license or a
            Sets.newHashSet("_1", "_2", "_3")
            indexShard.shardId(),  
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.common.util.set.Sets;  
            Codec.getDefault().getName(),  
        when(indicesService.indexServiceSafe(index)).thenReturn(indexService);
            boundAddress -> clusterService.localNode(),
import org.opensearch.indices.IndicesService;  
        final PublishReferencedSegmentsAction action = new PublishReferencedSegmentsAction(  
        when(indexShard.shardId()).thenReturn(shardId);  
        final IndexShard indexShard = mock(IndexShard.class);
        final int id = randomIntBetween(0, 4);  
            clusterService,
        );
import static org.opensearch.test.ClusterServiceUtils.createClusterService;  
            clusterService.getSettings(),
            threadPool,
        final ReferencedSegmentsCheckpoint checkpoint = new ReferencedSegmentsCheckpoint(
 *
            transportService,
    public void tearDown() throws Exception {  
    private TransportService transportService;  
        shardStateAction = new ShardStateAction(clusterService, transportService, null, null, threadPool);
        when(indicesService.indexServiceSafe(index)).thenReturn(indexService);
        );
        when(indicesService.indexServiceSafe(index)).thenReturn(indexService);
import org.opensearch.core.index.Index;
import org.opensearch.action.support.replication.TransportReplicationAction;  
        );  
            Codec.getDefault().getName(),
import org.opensearch.common.settings.Settings;  
        final IndexService indexService = mock(IndexService.class);  
        when(indexShard.shardId()).thenReturn(shardId);
        // cleanupRedundantPendingMergeSegment should be called on replica shard
        );
        final ShardId shardId = new ShardId(index, id);
import org.opensearch.indices.recovery.RecoveryState;
            1111,
        when(indexShard.recoveryState()).thenReturn(recoveryState);  
            shardStateAction,  
        ShardRouting shardRouting = mock(ShardRouting.class);
import org.opensearch.common.util.io.IOUtils;
        final IndexService indexService = mock(IndexService.class);  
        final Index index = new Index("index", "uuid");
    private ThreadPool threadPool;  
        transportService = transport.createTransportService(  
            1,
        final Index index = new Index("index", "uuid");
import org.opensearch.action.LatchedActionListener;
            threadPool,  
    private ShardStateAction shardStateAction;
        RecoveryState recoveryState = mock(RecoveryState.class);
            indexShard.shardId(),
        }
        when(recoveryState.getTargetNode()).thenReturn(clusterService.localNode());  
            new ActionFilters(Collections.emptySet())
        action.shardOperationOnReplica(request, indexShard, listener);
import static org.hamcrest.Matchers.sameInstance;
        final PlainActionFuture<TransportReplicationAction.ReplicaResult> listener = PlainActionFuture.newFuture();
    public void testPublishReferencedSegmentsOnPrimary() throws Exception {
        when(shardRouting.allocationId()).thenReturn(allocationId);
    private ClusterService clusterService;
    }
            Sets.newHashSet("_1", "_2", "_3")  
 * compatible open source license.
public class PublishReferencedSegmentsActionTests extends OpenSearchTestCase {
import org.opensearch.indices.recovery.RecoverySettings;
            assertThat(result.replicaRequest(), sameInstance(request));  
import static org.mockito.Mockito.times;  
            Collections.emptyMap(),
import org.opensearch.threadpool.TestThreadPool;  
