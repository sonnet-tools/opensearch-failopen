        );
        recoverReplica(replica_2, primary, true);
                logger.error("Unexpected failure", e);
        final FileChunkWriter segmentSegmentFileChunkWriter = mock(FileChunkWriter.class);
        );  
            public void onFailure(Exception e) {  
            replicaDiscoveryNode,
        final CheckpointInfoRequest request = new CheckpointInfoRequest(
import org.opensearch.index.shard.IndexShardTestCase;
    @Override  
            testCheckpoint
                assertTrue(getSegmentFilesResponse.files.isEmpty());
    }
        assertEquals(0, replications.size());
            public void onFailure(Exception e) {  
import java.util.Set;  
        final SegmentReplicationSourceHandler secondHandler = replications.prepareForReplication(
        closeShards(primary, replica);
        IndexShard replica_2 = newShard(primary.shardId(), false);  
        OngoingSegmentReplications replications = new OngoingSegmentReplications(mockIndicesService, recoverySettings);  
        verify(listener, times(1)).onResponse(any());
        assertEquals(2, replications.size());  
        OngoingSegmentReplications replications = new OngoingSegmentReplications(mockIndicesService, recoverySettings);
    private DiscoveryNode replicaDiscoveryNode;
 * compatible open source license.
        when(mockIndicesService.indexServiceSafe(testShardId.getIndex())).thenReturn(mockIndexService);
            secondReplica.routingEntry().allocationId().getId(),  
        primaryDiscoveryNode = replica.recoveryState().getSourceNode();
        assertEquals(2, replications.size());  
        assertEquals(1, replications.size());
            @Override
        final SegmentReplicationSourceHandler handler = replications.prepareForReplication(request, segmentSegmentFileChunkWriter);
        replications.startSegmentCopy(getSegmentFilesRequest, listener);  
        final FileChunkWriter segmentSegmentFileChunkWriter = (fileMetadata, position, content, lastChunk, totalTranslogOps, listener) -> {
 * this file be licensed under the Apache-2.0 license or a
            new ArrayList<>(handler.getCheckpoint().getMetadataMap().values()),
            testCheckpoint.getSegmentInfosVersion() + 1,  
        final SegmentReplicationSourceHandler handler = replications.prepareForReplication(request, mock(FileChunkWriter.class));
import org.opensearch.core.action.ActionListener;  
        OngoingSegmentReplications replications = new OngoingSegmentReplications(mockIndicesService, recoverySettings);
        latch.await(2, TimeUnit.SECONDS);  
            replicaDiscoveryNode,
        };  
            1L,
                Assert.fail();  
        closeShards(replica_2);
        // Prepare for replication step - and ensure copyState is added to cache.  
            testCheckpoint.getCodec()
            @Override
        replications.startSegmentCopy(getSegmentFilesRequest, new ActionListener<>() {
        replications.cancelReplication(primaryDiscoveryNode);  
            1L,
        final SegmentReplicationSourceHandler handler = replications.prepareForReplication(request, segmentSegmentFileChunkWriter);  
        super.tearDown();  
        );  
import org.opensearch.indices.recovery.FileChunkWriter;
            replicaAllocationId,  
            replica.routingEntry().allocationId().getId(),  
        getSegmentFilesRequest = new GetSegmentFilesRequest(
        final CheckpointInfoRequest request = new CheckpointInfoRequest(  
            secondRequest,  
        CodecService codecService = new CodecService(null, getIndexer(primary).config().getIndexSettings(), null, List.of());
        };
                logger.error("Unexpected failure", e);  
            replica.routingEntry().allocationId().getId(),
import static org.mockito.Mockito.any;
import java.util.Collections;
        replications.cancelReplication(primaryDiscoveryNode);
            replica.routingEntry().allocationId().getId(),
        final CheckpointInfoRequest request = new CheckpointInfoRequest(  
        indexDoc(primary, "1", "{\"foo\" : \"baz\"}", MediaTypeRegistry.JSON, "foobar");
            1L,
        // This mirrors the creation of the ReplicationCheckpoint inside CopyState
        primary.refresh("Test");
import org.opensearch.indices.IndicesService;  
}
            new ArrayList<>(handler.getCheckpoint().getMetadataMap().values()),
            public void onResponse(GetSegmentFilesResponse getSegmentFilesResponse) {  
    private ReplicationCheckpoint testCheckpoint;  
        getSegmentFilesRequest = new GetSegmentFilesRequest(
    public void tearDown() throws Exception {
import org.opensearch.index.engine.NRTReplicationEngineFactory;
            1L,
            replicaDiscoveryNode,  
    private final IndicesService mockIndicesService = mock(IndicesService.class);
import java.util.concurrent.CountDownLatch;
import static org.mockito.Mockito.when;
            public void onResponse(GetSegmentFilesResponse getSegmentFilesResponse) {  
            }  
import org.opensearch.common.settings.ClusterSettings;  
        replications.clearOutOfSyncIds(primary.shardId(), Collections.emptySet());
            // cancel the replication as soon as the writer starts sending files.
        assertEquals("listener should have resolved with failure", 0, latch.getCount());
            1L,  
            testCheckpoint.getPrimaryTerm(),
        final SegmentReplicationSourceHandler handler = replications.prepareForReplication(request, mock(FileChunkWriter.class));
        OngoingSegmentReplications replications = new OngoingSegmentReplications(mockIndicesService, recoverySettings);
        OngoingSegmentReplications replications = new OngoingSegmentReplications(mockIndicesService, recoverySettings);  
            }
            testCheckpoint
            listener.onResponse(null);
import static org.mockito.Mockito.times;
            testCheckpoint
            replica.routingEntry().allocationId().getId(),  
        final FileChunkWriter segmentSegmentFileChunkWriter = (fileMetadata, position, content, lastChunk, totalTranslogOps, listener) -> {  
        // mock the FileChunkWriter so we can assert its ever called.
    final Settings settings = Settings.builder()
        );  
        testCheckpoint = new ReplicationCheckpoint(testShardId, primary.getOperationPrimaryTerm(), 0L, 0L, defaultCodecName);  
        // create a replications object and request a checkpoint.
            primaryDiscoveryNode,
        replications.startSegmentCopy(getSegmentFilesRequest, new ActionListener<>() {  
import org.opensearch.indices.recovery.RecoverySettings;
        replica = newShard(false, settings, new EngineBackedIndexerFactory(new NRTReplicationEngineFactory()));
 * SPDX-License-Identifier: Apache-2.0
        recoverReplica(secondReplica, primary, true);  
        final CheckpointInfoRequest request = new CheckpointInfoRequest(
        ReplicationCheckpoint secondCheckpoint = new ReplicationCheckpoint(
        final CheckpointInfoRequest secondRequest = new CheckpointInfoRequest(
        final CheckpointInfoRequest request = new CheckpointInfoRequest(
            1L,
        final ActionListener<GetSegmentFilesResponse> listener = spy(new ActionListener<>() {
package org.opensearch.indices.replication;
            1L,
        String defaultCodecName = codecService.codec(CodecService.DEFAULT_CODEC).getName();  
        assertEquals(0, replications.size());
        replications.prepareForReplication(secondRequest, segmentSegmentFileChunkWriter);
        );
        // cancel the primary's ongoing replications.
            replica.routingEntry().allocationId().getId(),  
    public void testShardAlreadyReplicatingToNode() throws IOException {
        IndexShard secondReplica = newShard(primary.shardId(), false);
            }
        assertEquals(1, replications.size());
            testCheckpoint  
            @Override
import java.io.IOException;
            testCheckpoint  
    }
import static org.mockito.Mockito.verifyNoInteractions;  
        recoverReplica(replica_2, primary, true);
        OngoingSegmentReplications replications = spy(new OngoingSegmentReplications(mockIndicesService, recoverySettings));
        final String replica_2AllocationId = replica_2.routingEntry().allocationId().getId();
            replica.routingEntry().allocationId().getId(),  
        assertTrue(replications.getHandlers().containsKey(replica_2AllocationId));
            public void onResponse(GetSegmentFilesResponse getSegmentFilesResponse) {
import org.junit.Assert;  
        replications.cancelReplication(replicaDiscoveryNode);  
            listener.onResponse(null);
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;  
            testCheckpoint
            testCheckpoint  
            primaryDiscoveryNode,
import static org.mockito.Mockito.spy;  
    public void testMultipleReplicasUseSameCheckpoint() throws IOException {
            replicaDiscoveryNode,
        final CheckpointInfoRequest request = new CheckpointInfoRequest(
            replicaDiscoveryNode,
        ShardId testShardId = primary.shardId();  
        });  
            Collections.emptyList(),
            public void onFailure(Exception e) {
            1L,
        assertEquals(secondHandler, replications.getHandlers().get(replicaAllocationId));  
        assertEquals(0, replications.size());
    }
        final CheckpointInfoRequest request = new CheckpointInfoRequest(
        );  
            @Override
import org.opensearch.cluster.metadata.IndexMetadata;
            Collections.emptyList(),
        final CheckpointInfoRequest request = new CheckpointInfoRequest(1L, replicaAllocationId, primaryDiscoveryNode, testCheckpoint);  
            @Override
        final String replicaAllocationId = replica.routingEntry().allocationId().getId();
            }
        final CheckpointInfoRequest secondRequest = new CheckpointInfoRequest(
        // cancel the primary's ongoing replications.  
    @Override  
            replica.routingEntry().allocationId().getId(),  
            // this shouldn't be called in this test.
        IndexShard replica_2 = newShard(primary.shardId(), false);
            Assert.fail();
        replications.clearOutOfSyncIds(primary.shardId(), Set.of(replica_2AllocationId));
        );
            1L,
                verifyNoInteractions(segmentSegmentFileChunkWriter);
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;  
                Assert.fail("Expected onFailure to be invoked.");
    final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
            testCheckpoint.getSegmentsGen(),
        assertEquals(2, replications.size());
        );
 *
        replicaDiscoveryNode = replica.recoveryState().getTargetNode();  
        replications.cancel(primary, "Test");  
        TransportService transportService = mock(TransportService.class);
    }
            1L,
    private DiscoveryNode primaryDiscoveryNode;
        });
        OngoingSegmentReplications replications = new OngoingSegmentReplications(mockIndicesService, recoverySettings);
        IndexService mockIndexService = mock(IndexService.class);
            replica.routingEntry().allocationId().getId(),  
        primary = newStartedShard(true, settings);  
        });
import static org.mockito.Mockito.mock;
        });
        assertTrue(replications.getHandlers().containsKey(replicaAllocationId));
        OngoingSegmentReplications replications = spy(new OngoingSegmentReplications(mockIndicesService, recoverySettings));  
    private IndexShard primary;  
        recoverReplica(replica, primary, true);
        );
        indexDoc(primary, "1", "{\"foo\" : \"baz\"}", MediaTypeRegistry.JSON, "foobar");
    public void testStartCopyWithoutPrepareStep() {
import org.opensearch.cluster.node.DiscoveryNode;
    public void testPrepareAndSendSegments() throws IOException {  
        final String replicaAllocationId = replica.routingEntry().allocationId().getId();
            }
        when(mockIndexService.getShard(testShardId.id())).thenReturn(primary);  
                assertEquals(CancellableThreads.ExecutionCancelledException.class, e.getClass());
    }
            mock(FileChunkWriter.class)
            testCheckpoint  
        );
    }
import org.opensearch.core.xcontent.MediaTypeRegistry;
        // invoke startSegmentCopy and assert our fileChunkWriter is never invoked.  
import org.opensearch.index.codec.CodecService;
            replicaDiscoveryNode,
        final SegmentReplicationSourceHandler handler = replications.prepareForReplication(request, segmentSegmentFileChunkWriter);
    }  
        final CheckpointInfoRequest request = new CheckpointInfoRequest(1L, replicaAllocationId, primaryDiscoveryNode, testCheckpoint);  
                Assert.fail();
import org.opensearch.index.shard.IndexShard;
    public void testCancelForMissingIds() throws IOException {
            primaryDiscoveryNode,  
import static org.mockito.Mockito.verify;
import java.util.concurrent.TimeUnit;
        getSegmentFilesRequest = new GetSegmentFilesRequest(
            replications.cancel(replica.routingEntry().allocationId().getId(), "Test");  
                latch.countDown();  
            replica.routingEntry().allocationId().getId(),
        assertEquals(handler, replications.getHandlers().get(replicaAllocationId));  
            @Override  
        closeShards(replica_2);  
        final FileChunkWriter segmentSegmentFileChunkWriter = (fileMetadata, position, content, lastChunk, totalTranslogOps, listener) -> {
            1L,
            replica_2AllocationId,
            1L,
            1L,
            replica_2.routingEntry().allocationId().getId(),  
            primaryDiscoveryNode,
            testCheckpoint  
        // This tests when primary has multiple ongoing replications.  
        replications.prepareForReplication(secondRequest, mock(FileChunkWriter.class));
import java.util.List;
            @Override
        );
                Assert.fail("Unexpected failure from startSegmentCopy listener: " + e);
        // This tests when primary has multiple ongoing replications.
        );  
        when(transportService.getThreadPool()).thenReturn(threadPool);  
/*  
            replicaDiscoveryNode,
            replica.routingEntry().allocationId().getId(),  
        .put("node.name", SegmentReplicationTargetServiceTests.class.getSimpleName())  
        );
            public void onResponse(GetSegmentFilesResponse getSegmentFilesResponse) {
        super.setUp();
        );  
        assertEquals(1, replications.size());  
            }
        final SegmentReplicationSourceHandler handler = replications.prepareForReplication(request, mock(FileChunkWriter.class));
        );  
        OngoingSegmentReplications replications = spy(new OngoingSegmentReplications(mockIndicesService, recoverySettings));  
            testCheckpoint
import org.opensearch.indices.replication.common.ReplicationType;
        OngoingSegmentReplications replications = new OngoingSegmentReplications(mockIndicesService, recoverySettings);  
        getSegmentFilesRequest = new GetSegmentFilesRequest(
                assertEquals(Collections.emptyList(), getSegmentFilesResponse.files);
            public void onFailure(Exception e) {
            testCheckpoint
        final CheckpointInfoRequest secondRequest = new CheckpointInfoRequest(
                assertEquals(0, replications.size());
            1L,  
            }  
        };
            primaryDiscoveryNode,
import org.opensearch.common.settings.Settings;
public class OngoingSegmentReplicationsTests extends IndexShardTestCase {  
            testCheckpoint
        assertTrue(replications.getHandlers().containsKey(replica_2AllocationId));  
        );
        assertEquals(1, replications.size());
            Assert.fail();
        final FileChunkWriter segmentSegmentFileChunkWriter = (fileMetadata, position, content, lastChunk, totalTranslogOps, listener) -> {
    }
    }
            replicaDiscoveryNode,
        replications.startSegmentCopy(getSegmentFilesRequest, new ActionListener<>() {
    private IndexShard replica;
import org.opensearch.core.index.shard.ShardId;
        };
        final SegmentReplicationSourceHandler handler = replications.prepareForReplication(request, segmentSegmentFileChunkWriter);
            replicaDiscoveryNode,
        };  
    final RecoverySettings recoverySettings = new RecoverySettings(settings, clusterSettings);
        final SegmentReplicationSourceHandler handler = replications.prepareForReplication(request, segmentSegmentFileChunkWriter);
        final SegmentReplicationSourceHandler handler = replications.prepareForReplication(request, segmentSegmentFileChunkWriter);
            @Override
                assertEquals(0, replications.size());
    }
        closeShards(secondReplica);
        final CheckpointInfoRequest secondRequest = new CheckpointInfoRequest(
        CountDownLatch latch = new CountDownLatch(1);
    public void testCancelAllReplicationsForShard() throws IOException {
            testCheckpoint.getShardId(),  
import org.opensearch.transport.TransportService;
    public void setUp() throws Exception {
        .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
import org.opensearch.common.util.CancellableThreads;
        // add a doc and refresh so primary has more than one segment.
import org.opensearch.index.IndexService;  
        assertEquals(1, replications.size());  
        assertEquals(0, replications.size());
import java.util.ArrayList;  
    public void testStartReplicationWithNoFilesToFetch() throws IOException {
    public void testCancelReplication() throws IOException {  
 * The OpenSearch Contributors require contributions made to  
    }
            testCheckpoint
        replications.prepareForReplication(secondRequest, mock(FileChunkWriter.class));
        replications.prepareForReplication(request, segmentSegmentFileChunkWriter);  
 */  
        final FileChunkWriter segmentSegmentFileChunkWriter = (fileMetadata, position, content, lastChunk, totalTranslogOps, listener) -> {  
    public void testCancelReplication_AfterSendFilesStarts() throws IOException, InterruptedException {
        primary.refresh("Test");  
    public void testPrepareForReplicationAlreadyReplicating() throws IOException {  
            secondCheckpoint
    }  
            }  
        .build();
            testCheckpoint  
                assertEquals(handler.getCheckpoint().getMetadataMap().size(), getSegmentFilesResponse.files.size());  
            replica.routingEntry().allocationId().getId(),  
    private GetSegmentFilesRequest getSegmentFilesRequest;  
            1L,
        );
            replicaDiscoveryNode,
            // this shouldn't be called in this test.  
