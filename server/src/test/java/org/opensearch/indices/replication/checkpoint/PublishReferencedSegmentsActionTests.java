        // the result should indicate success
        when(indexService.getShard(id)).thenReturn(indexShard);
import java.util.concurrent.atomic.AtomicBoolean;
public class PublishReferencedSegmentsActionTests extends OpenSearchTestCase {
        threadPool = new TestThreadPool(getClass().getName());
        when(indicesService.indexServiceSafe(index)).thenReturn(indexService);
import org.opensearch.common.util.io.IOUtils;
        final Index index = new Index("index", "uuid");
            Codec.getDefault().getName(),
 * this file be licensed under the Apache-2.0 license or a
import static org.mockito.Mockito.times;
            assertThat(result.replicaRequest(), sameInstance(request));
        transportService.acceptIncomingRequests();
        final IndexService indexService = mock(IndexService.class);
        );
            null,
            indicesService,
import org.opensearch.threadpool.ThreadPool;
        final PublishReferencedSegmentsAction action = new PublishReferencedSegmentsAction(
            Sets.newHashSet("_1", "_2", "_3")
            1111,
    private ThreadPool threadPool;
            indicesService,
        RecoverySettings recoverySettings = mock(RecoverySettings.class);
        final ReferencedSegmentsCheckpoint checkpoint = new ReferencedSegmentsCheckpoint(
            indexShard.shardId(),
        final IndexShard indexShard = mock(IndexShard.class);
        when(indexShard.getRecoverySettings()).thenReturn(recoverySettings);
            1111,
import java.util.concurrent.CountDownLatch;
            Codec.getDefault().getName(),
import org.opensearch.core.action.ActionListener;
        final ReferencedSegmentsCheckpoint checkpoint = new ReferencedSegmentsCheckpoint(
    private CapturingTransport transport;
            new ActionFilters(Collections.emptySet())
import org.opensearch.threadpool.TestThreadPool;
            Collections.emptyMap(),
            1111,
            1,
    public void tearDown() throws Exception {
 * compatible open source license.
        final TransportReplicationAction.ReplicaResult result = listener.actionGet();
        final PublishReferencedSegmentsRequest request = new PublishReferencedSegmentsRequest(checkpoint);
        when(indexShard.indexSettings()).thenReturn(
            IOUtils.close(transportService, clusterService, transport);
            indexShard.shardId(),
import org.apache.lucene.codecs.Codec;
/*
import org.opensearch.action.support.ActionTestUtils;
        );
            threadPool,
            boundAddress -> clusterService.localNode(),
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.test.transport.CapturingTransport;
        clusterService = createClusterService(threadPool);
            Collections.emptyMap(),
    public void testPublishReferencedSegmentsOnPrimary() throws Exception {
        verify(indexShard, times(1)).cleanupRedundantPendingMergeSegment(checkpoint);
import org.opensearch.transport.TransportService;
 *
        super.tearDown();
            transportService,
            1,
import org.opensearch.index.IndexService;
import org.opensearch.index.shard.IndexShard;
        when(recoverySettings.getMergedSegmentReplicationTimeout()).thenReturn(new TimeValue(1000));
        final PublishReferencedSegmentsAction action = new PublishReferencedSegmentsAction(
        when(indexShard.shardId()).thenReturn(shardId);
        when(indexShard.getPendingPrimaryTerm()).thenReturn(1L);
        latch.await();
        AllocationId allocationId = mock(AllocationId.class);
            new ActionFilters(Collections.emptySet())
import static org.mockito.Mockito.when;
 * The OpenSearch Contributors require contributions made to
            indicesService,
import static org.hamcrest.Matchers.sameInstance;
        action.shardOperationOnPrimary(request, indexShard, new LatchedActionListener<>(ActionTestUtils.assertNoFailureListener(result -> {
}
        super.setUp();
    @Override
        when(indexService.getShard(id)).thenReturn(indexShard);
            Codec.getDefault().getName(),
import java.util.Collections;
import org.opensearch.cluster.metadata.IndexMetadata;
    public void setUp() throws Exception {
            1,
import org.opensearch.cluster.routing.ShardRouting;
        final Index index = new Index("index", "uuid");
            Settings.EMPTY,
        final int id = randomIntBetween(0, 4);
    }
        transport = new CapturingTransport();
            Collections.emptyMap(),
import org.opensearch.indices.recovery.RecoverySettings;
        when(indicesService.indexServiceSafe(index)).thenReturn(indexService);
            transportService,
import org.opensearch.common.unit.TimeValue;
        action.shardOperationOnReplica(request, indexShard, listener);
        final PublishReferencedSegmentsAction action = new PublishReferencedSegmentsAction(
        when(recoveryState.getTargetNode()).thenReturn(clusterService.localNode());
            Settings.EMPTY,
 */
        final IndicesService indicesService = mock(IndicesService.class);
        final IndicesService indicesService = mock(IndicesService.class);
    @Override
        transportService = transport.createTransportService(
package org.opensearch.indices.replication.checkpoint;
            1,
        when(allocationId.getId()).thenReturn("1");
    }
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
            new ActionFilters(Collections.emptySet())
        } finally {
            clusterService,
            createIndexSettings(false, Settings.builder().put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), "SEGMENT").build())
        final ReferencedSegmentsCheckpoint checkpoint = new ReferencedSegmentsCheckpoint(
    private TransportService transportService;
import org.opensearch.indices.recovery.RecoveryState;
        );
 * SPDX-License-Identifier: Apache-2.0
            terminate(threadPool);
            transportService,
import org.opensearch.cluster.routing.AllocationId;
            threadPool,
        when(indexShard.routingEntry()).thenReturn(shardRouting);
        // cleanupRedundantPendingMergeSegment should be called on replica shard
import org.opensearch.common.util.set.Sets;
        final ShardId shardId = new ShardId(index, id);
        );
            1,
        shardStateAction = new ShardStateAction(clusterService, transportService, null, null, threadPool);
import org.opensearch.action.support.ActionFilters;
        final ShardId shardId = new ShardId(index, id);
    public void testPublishReferencedSegmentsActionOnReplica() {
        action.publish(indexShard, checkpoint);
        result.runPostReplicaActions(ActionListener.wrap(r -> success.set(true), e -> fail(e.toString())));
        when(indexShard.shardId()).thenReturn(shardId);
        when(shardRouting.allocationId()).thenReturn(allocationId);
        }), latch));
        );
    }
            clusterService,
            shardStateAction,
            shardStateAction,
            clusterService.getSettings(),
        final Index index = new Index("index", "uuid");
        assertTrue(success.get());
import static org.opensearch.index.remote.RemoteStoreTestsHelper.createIndexSettings;
        final ShardId shardId = new ShardId(index, id);
        when(indexShard.recoveryState()).thenReturn(recoveryState);
import org.opensearch.cluster.action.shard.ShardStateAction;
import org.opensearch.action.LatchedActionListener;
        when(indexService.getShard(id)).thenReturn(indexShard);
        final CountDownLatch latch = new CountDownLatch(1);
            threadPool,
    public void testPublishReferencedSegments() {
        final IndexShard indexShard = mock(IndexShard.class);
        transportService.start();
            indexShard.shardId(),
        try {
        final int id = randomIntBetween(0, 4);
        );
import static org.mockito.Mockito.mock;
            clusterService,
import org.opensearch.action.support.PlainActionFuture;
        );
            Collections.emptySet(),
            Sets.newHashSet("_1", "_2", "_3")
            // we should forward the request containing the current publish checkpoint to the replica
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        );
        when(indexShard.shardId()).thenReturn(shardId);
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
        final PublishReferencedSegmentsRequest request = new PublishReferencedSegmentsRequest(checkpoint);
        when(indicesService.indexServiceSafe(index)).thenReturn(indexService);
        ShardRouting shardRouting = mock(ShardRouting.class);
            threadPool,
        final int id = randomIntBetween(0, 4);
import org.opensearch.core.index.Index;
    private ShardStateAction shardStateAction;
            shardStateAction,
            1,
        final IndexService indexService = mock(IndexService.class);
    private ClusterService clusterService;
        final IndicesService indicesService = mock(IndicesService.class);
        final PlainActionFuture<TransportReplicationAction.ReplicaResult> listener = PlainActionFuture.newFuture();
import org.opensearch.core.index.shard.ShardId;
            Settings.EMPTY,
    }
import static org.mockito.Mockito.verify;
        }
            NoopTracer.INSTANCE
            Sets.newHashSet("_1", "_2", "_3")
import org.opensearch.indices.IndicesService;
    }
        final IndexShard indexShard = mock(IndexShard.class);
        final IndexService indexService = mock(IndexService.class);
        final AtomicBoolean success = new AtomicBoolean();
import org.opensearch.action.support.replication.TransportReplicationAction;
        RecoveryState recoveryState = mock(RecoveryState.class);
import org.opensearch.common.settings.Settings;
