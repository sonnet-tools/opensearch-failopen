        final FileChunkWriter segmentSegmentFileChunkWriter = (fileMetadata, position, content, lastChunk, totalTranslogOps, listener) -> {
        getSegmentFilesRequest = new GetSegmentFilesRequest(
        final SegmentReplicationSourceHandler handler = replications.prepareForReplication(request, segmentSegmentFileChunkWriter);
    public void testMultipleReplicasUseSameCheckpoint() throws IOException {
    public void tearDown() throws Exception {
        closeShards(secondReplica);
            public void onResponse(GetSegmentFilesResponse getSegmentFilesResponse) {
        verify(listener, times(1)).onResponse(any());
    public void testPrepareForReplicationAlreadyReplicating() throws IOException {
            Collections.emptyList(),
        primaryDiscoveryNode = replica.recoveryState().getSourceNode();
        .put("node.name", SegmentReplicationTargetServiceTests.class.getSimpleName())
        final SegmentReplicationSourceHandler handler = replications.prepareForReplication(request, mock(FileChunkWriter.class));
        );
        final String replicaAllocationId = replica.routingEntry().allocationId().getId();
        );
package org.opensearch.indices.replication;
            1L,
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;
            @Override
        final SegmentReplicationSourceHandler handler = replications.prepareForReplication(request, segmentSegmentFileChunkWriter);
            @Override
import static org.mockito.Mockito.verify;
            1L,
            }
        );
    }
import org.opensearch.common.settings.Settings;
                Assert.fail("Unexpected failure from startSegmentCopy listener: " + e);
        // This tests when primary has multiple ongoing replications.
    final Settings settings = Settings.builder()
        );
        OngoingSegmentReplications replications = new OngoingSegmentReplications(mockIndicesService, recoverySettings);
        assertEquals(2, replications.size());
        );
    }
            public void onResponse(GetSegmentFilesResponse getSegmentFilesResponse) {
        assertTrue(replications.getHandlers().containsKey(replicaAllocationId));
            replicaDiscoveryNode,
 * The OpenSearch Contributors require contributions made to
        };
            new ArrayList<>(handler.getCheckpoint().getMetadataMap().values()),
        IndexShard secondReplica = newShard(primary.shardId(), false);
        final String replicaAllocationId = replica.routingEntry().allocationId().getId();
            primaryDiscoveryNode,
            replica_2.routingEntry().allocationId().getId(),
            public void onFailure(Exception e) {
        recoverReplica(secondReplica, primary, true);
    private final IndicesService mockIndicesService = mock(IndicesService.class);
        final FileChunkWriter segmentSegmentFileChunkWriter = (fileMetadata, position, content, lastChunk, totalTranslogOps, listener) -> {
        final CheckpointInfoRequest secondRequest = new CheckpointInfoRequest(
        replica = newShard(false, settings, new EngineBackedIndexerFactory(new NRTReplicationEngineFactory()));
        replications.cancelReplication(primaryDiscoveryNode);
            }
            replica.routingEntry().allocationId().getId(),
        replications.cancelReplication(primaryDiscoveryNode);
            testCheckpoint
            testCheckpoint
        closeShards(primary, replica);
        .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
import org.opensearch.common.util.CancellableThreads;
    private DiscoveryNode replicaDiscoveryNode;
            replicaAllocationId,
            @Override
    }
        assertEquals(1, replications.size());
            new ArrayList<>(handler.getCheckpoint().getMetadataMap().values()),
            1L,
            }
 * this file be licensed under the Apache-2.0 license or a
            }
import static org.mockito.Mockito.when;
        );
            replica_2AllocationId,
        CodecService codecService = new CodecService(null, getIndexer(primary).config().getIndexSettings(), null, List.of());
            // cancel the replication as soon as the writer starts sending files.
        when(mockIndicesService.indexServiceSafe(testShardId.getIndex())).thenReturn(mockIndexService);
        );
    }
        replications.startSegmentCopy(getSegmentFilesRequest, new ActionListener<>() {
        replications.startSegmentCopy(getSegmentFilesRequest, new ActionListener<>() {
                Assert.fail("Expected onFailure to be invoked.");
            secondCheckpoint
            listener.onResponse(null);
        replications.clearOutOfSyncIds(primary.shardId(), Collections.emptySet());
        recoverReplica(replica, primary, true);
        final CheckpointInfoRequest secondRequest = new CheckpointInfoRequest(
        assertEquals(1, replications.size());
        OngoingSegmentReplications replications = spy(new OngoingSegmentReplications(mockIndicesService, recoverySettings));
            replicaDiscoveryNode,
            testCheckpoint.getPrimaryTerm(),
        final SegmentReplicationSourceHandler handler = replications.prepareForReplication(request, segmentSegmentFileChunkWriter);
        ShardId testShardId = primary.shardId();
        final CheckpointInfoRequest request = new CheckpointInfoRequest(
            1L,
            replica.routingEntry().allocationId().getId(),
            1L,
            testCheckpoint
        getSegmentFilesRequest = new GetSegmentFilesRequest(
        primary = newStartedShard(true, settings);
        OngoingSegmentReplications replications = spy(new OngoingSegmentReplications(mockIndicesService, recoverySettings));
        when(transportService.getThreadPool()).thenReturn(threadPool);
            public void onResponse(GetSegmentFilesResponse getSegmentFilesResponse) {
        // cancel the primary's ongoing replications.
        replications.prepareForReplication(request, segmentSegmentFileChunkWriter);
import java.io.IOException;
        final CheckpointInfoRequest request = new CheckpointInfoRequest(
        // invoke startSegmentCopy and assert our fileChunkWriter is never invoked.
                assertTrue(getSegmentFilesResponse.files.isEmpty());
    @Override
        OngoingSegmentReplications replications = new OngoingSegmentReplications(mockIndicesService, recoverySettings);
        getSegmentFilesRequest = new GetSegmentFilesRequest(
import org.opensearch.index.shard.IndexShard;
                assertEquals(Collections.emptyList(), getSegmentFilesResponse.files);
import java.util.Set;
import org.opensearch.index.shard.IndexShardTestCase;
            replica.routingEntry().allocationId().getId(),
    public void testCancelAllReplicationsForShard() throws IOException {
        };
    public void setUp() throws Exception {
            replicaDiscoveryNode,
        );
        });
        assertEquals(secondHandler, replications.getHandlers().get(replicaAllocationId));
import java.util.concurrent.TimeUnit;
        IndexShard replica_2 = newShard(primary.shardId(), false);
    }
import org.junit.Assert;
        };
            testCheckpoint
        });
        recoverReplica(replica_2, primary, true);
            mock(FileChunkWriter.class)
            testCheckpoint
        final String replica_2AllocationId = replica_2.routingEntry().allocationId().getId();
            public void onResponse(GetSegmentFilesResponse getSegmentFilesResponse) {
            1L,
        };
import java.util.List;
        assertEquals(0, replications.size());
 */
 *
import java.util.ArrayList;
        replications.prepareForReplication(secondRequest, mock(FileChunkWriter.class));
        String defaultCodecName = codecService.codec(CodecService.DEFAULT_CODEC).getName();
import org.opensearch.core.xcontent.MediaTypeRegistry;
        // This tests when primary has multiple ongoing replications.
        final ActionListener<GetSegmentFilesResponse> listener = spy(new ActionListener<>() {
    public void testPrepareAndSendSegments() throws IOException {
 * compatible open source license.
            1L,
            }
            }
        assertEquals(0, replications.size());
        assertEquals(1, replications.size());
        );
import java.util.concurrent.CountDownLatch;
            primaryDiscoveryNode,
        final FileChunkWriter segmentSegmentFileChunkWriter = (fileMetadata, position, content, lastChunk, totalTranslogOps, listener) -> {
/*
            testCheckpoint
        closeShards(replica_2);
                logger.error("Unexpected failure", e);
            testCheckpoint.getSegmentInfosVersion() + 1,
            replicaDiscoveryNode,
        // cancel the primary's ongoing replications.
        assertEquals(1, replications.size());
        };
 * SPDX-License-Identifier: Apache-2.0
        assertTrue(replications.getHandlers().containsKey(replica_2AllocationId));
            1L,
        final FileChunkWriter segmentSegmentFileChunkWriter = (fileMetadata, position, content, lastChunk, totalTranslogOps, listener) -> {
    }
            public void onFailure(Exception e) {
            testCheckpoint.getShardId(),
import org.opensearch.index.codec.CodecService;
    private ReplicationCheckpoint testCheckpoint;
        final SegmentReplicationSourceHandler handler = replications.prepareForReplication(request, mock(FileChunkWriter.class));
import org.opensearch.core.index.shard.ShardId;
            replicaDiscoveryNode,
        // mock the FileChunkWriter so we can assert its ever called.
import org.opensearch.cluster.node.DiscoveryNode;
            secondReplica.routingEntry().allocationId().getId(),
import static org.mockito.Mockito.any;
            replicaDiscoveryNode,
        closeShards(replica_2);
                Assert.fail();
        latch.await(2, TimeUnit.SECONDS);
        assertEquals(2, replications.size());
        });
        ReplicationCheckpoint secondCheckpoint = new ReplicationCheckpoint(
        final CheckpointInfoRequest request = new CheckpointInfoRequest(
        final CheckpointInfoRequest secondRequest = new CheckpointInfoRequest(
        assertEquals("listener should have resolved with failure", 0, latch.getCount());
        OngoingSegmentReplications replications = new OngoingSegmentReplications(mockIndicesService, recoverySettings);
        // create a replications object and request a checkpoint.
import static org.mockito.Mockito.mock;
import org.opensearch.indices.IndicesService;
            @Override
            testCheckpoint
                assertEquals(0, replications.size());
            @Override
        OngoingSegmentReplications replications = spy(new OngoingSegmentReplications(mockIndicesService, recoverySettings));
            primaryDiscoveryNode,
    public void testShardAlreadyReplicatingToNode() throws IOException {
            1L,
        );
        final SegmentReplicationSourceHandler handler = replications.prepareForReplication(request, segmentSegmentFileChunkWriter);
        super.tearDown();
        IndexService mockIndexService = mock(IndexService.class);
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
            testCheckpoint.getSegmentsGen(),
        );
        recoverReplica(replica_2, primary, true);
    public void testCancelForMissingIds() throws IOException {
    private DiscoveryNode primaryDiscoveryNode;
        );
            testCheckpoint
            listener.onResponse(null);
            Collections.emptyList(),
        indexDoc(primary, "1", "{\"foo\" : \"baz\"}", MediaTypeRegistry.JSON, "foobar");
        final FileChunkWriter segmentSegmentFileChunkWriter = mock(FileChunkWriter.class);
            public void onFailure(Exception e) {
    private IndexShard replica;
import static org.mockito.Mockito.spy;
        replicaDiscoveryNode = replica.recoveryState().getTargetNode();
        indexDoc(primary, "1", "{\"foo\" : \"baz\"}", MediaTypeRegistry.JSON, "foobar");
        replications.clearOutOfSyncIds(primary.shardId(), Set.of(replica_2AllocationId));
    public void testStartCopyWithoutPrepareStep() {
    }
            1L,
import org.opensearch.core.action.ActionListener;
        CountDownLatch latch = new CountDownLatch(1);
        assertEquals(2, replications.size());
    @Override
            testCheckpoint
public class OngoingSegmentReplicationsTests extends IndexShardTestCase {
        replications.startSegmentCopy(getSegmentFilesRequest, new ActionListener<>() {
        final SegmentReplicationSourceHandler handler = replications.prepareForReplication(request, segmentSegmentFileChunkWriter);
                assertEquals(CancellableThreads.ExecutionCancelledException.class, e.getClass());
            replica.routingEntry().allocationId().getId(),
    }
            @Override
        assertEquals(handler, replications.getHandlers().get(replicaAllocationId));
        OngoingSegmentReplications replications = new OngoingSegmentReplications(mockIndicesService, recoverySettings);
import org.opensearch.index.engine.NRTReplicationEngineFactory;
        // add a doc and refresh so primary has more than one segment.
        final CheckpointInfoRequest request = new CheckpointInfoRequest(1L, replicaAllocationId, primaryDiscoveryNode, testCheckpoint);
    }
                Assert.fail();
            @Override
                latch.countDown();
        primary.refresh("Test");
        assertEquals(0, replications.size());
        replications.prepareForReplication(secondRequest, segmentSegmentFileChunkWriter);
        testCheckpoint = new ReplicationCheckpoint(testShardId, primary.getOperationPrimaryTerm(), 0L, 0L, defaultCodecName);
        final CheckpointInfoRequest secondRequest = new CheckpointInfoRequest(
            }
        replications.prepareForReplication(secondRequest, mock(FileChunkWriter.class));
        );
            testCheckpoint
            1L,
        assertEquals(0, replications.size());
    final RecoverySettings recoverySettings = new RecoverySettings(settings, clusterSettings);
    }
            testCheckpoint
            1L,
        when(mockIndexService.getShard(testShardId.id())).thenReturn(primary);
import org.opensearch.common.settings.ClusterSettings;
        IndexShard replica_2 = newShard(primary.shardId(), false);
        final CheckpointInfoRequest request = new CheckpointInfoRequest(
        TransportService transportService = mock(TransportService.class);
        final FileChunkWriter segmentSegmentFileChunkWriter = (fileMetadata, position, content, lastChunk, totalTranslogOps, listener) -> {
import java.util.Collections;
        OngoingSegmentReplications replications = new OngoingSegmentReplications(mockIndicesService, recoverySettings);
            replicaDiscoveryNode,
            1L,
            replica.routingEntry().allocationId().getId(),
        );
        final SegmentReplicationSourceHandler handler = replications.prepareForReplication(request, mock(FileChunkWriter.class));
        replications.cancel(primary, "Test");
import org.opensearch.index.IndexService;
            replica.routingEntry().allocationId().getId(),
                logger.error("Unexpected failure", e);
        // Prepare for replication step - and ensure copyState is added to cache.
            secondRequest,
            testCheckpoint
            replica.routingEntry().allocationId().getId(),
    }
import org.opensearch.indices.recovery.FileChunkWriter;
    public void testStartReplicationWithNoFilesToFetch() throws IOException {
        replications.startSegmentCopy(getSegmentFilesRequest, listener);
        .build();
            replica.routingEntry().allocationId().getId(),
import static org.mockito.Mockito.times;
        // This mirrors the creation of the ReplicationCheckpoint inside CopyState
            testCheckpoint
        );
import org.opensearch.indices.recovery.RecoverySettings;
        final CheckpointInfoRequest request = new CheckpointInfoRequest(
            public void onFailure(Exception e) {
            replica.routingEntry().allocationId().getId(),
import org.opensearch.indices.replication.common.ReplicationType;
            replicaDiscoveryNode,
            replications.cancel(replica.routingEntry().allocationId().getId(), "Test");
        );
            replicaDiscoveryNode,
            Assert.fail();
            testCheckpoint
        final CheckpointInfoRequest request = new CheckpointInfoRequest(
                assertEquals(handler.getCheckpoint().getMetadataMap().size(), getSegmentFilesResponse.files.size());
}
            replica.routingEntry().allocationId().getId(),
        super.setUp();
                verifyNoInteractions(segmentSegmentFileChunkWriter);
        assertEquals(1, replications.size());
        getSegmentFilesRequest = new GetSegmentFilesRequest(
    final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    public void testCancelReplication() throws IOException {
import org.opensearch.transport.TransportService;
            // this shouldn't be called in this test.
import org.opensearch.cluster.metadata.IndexMetadata;
            @Override
        OngoingSegmentReplications replications = new OngoingSegmentReplications(mockIndicesService, recoverySettings);
        replications.cancelReplication(replicaDiscoveryNode);
            replicaDiscoveryNode,
        );
        OngoingSegmentReplications replications = new OngoingSegmentReplications(mockIndicesService, recoverySettings);
            primaryDiscoveryNode,
    }
    private IndexShard primary;
        final SegmentReplicationSourceHandler secondHandler = replications.prepareForReplication(
            replica.routingEntry().allocationId().getId(),
            1L,
            }
    private GetSegmentFilesRequest getSegmentFilesRequest;
    public void testCancelReplication_AfterSendFilesStarts() throws IOException, InterruptedException {
            testCheckpoint.getCodec()
        primary.refresh("Test");
        });
        final CheckpointInfoRequest request = new CheckpointInfoRequest(
import static org.mockito.Mockito.verifyNoInteractions;
                assertEquals(0, replications.size());
            // this shouldn't be called in this test.
        final SegmentReplicationSourceHandler handler = replications.prepareForReplication(request, segmentSegmentFileChunkWriter);
        assertTrue(replications.getHandlers().containsKey(replica_2AllocationId));
            Assert.fail();
            1L,
            primaryDiscoveryNode,
        final CheckpointInfoRequest request = new CheckpointInfoRequest(1L, replicaAllocationId, primaryDiscoveryNode, testCheckpoint);
