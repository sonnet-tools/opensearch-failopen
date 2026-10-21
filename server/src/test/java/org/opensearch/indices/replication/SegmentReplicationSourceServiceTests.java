            "allocationId",
import static org.mockito.Mockito.mock;
        segmentReplicationSourceService = new SegmentReplicationSourceService(
            @Override
                    return ThreadPool.Names.SAME;
        executeGetCheckpointInfo(new ActionListener<>() {
                assertEquals(0, response.files.size());
    private void executeGetCheckpointInfo(ActionListener<CheckpointInfoResponse> listener) {
                @Override
            }
import org.opensearch.threadpool.TestThreadPool;
import org.opensearch.core.common.io.stream.StreamInput;
                }
                assert e.getCause() instanceof IllegalStateException;
import static org.mockito.Mockito.spy;
        when(mockIndexShard.routingEntry()).thenReturn(routing);
                public void handleResponse(GetSegmentFilesResponse response) {
            Collections.emptyList(),
                    listener.onFailure(e);
            testShardId,
        final RecoverySettings recoverySettings = new RecoverySettings(settings, clusterSettings);
        });
        segmentReplicationSourceService.clusterChanged(mock);
            request,
        final Settings settings = Settings.builder().put("node.name", SegmentReplicationTargetServiceTests.class.getSimpleName()).build();
        executeUpdateVisibleCheckpoint(request, new ActionListener<>() {
            boundAddress -> localNode,
            "index",
                assertNotNull(response.getInfosBytes());
import org.opensearch.core.index.shard.ShardId;
            }
    private SegmentReplicationSourceService segmentReplicationSourceService;
        });
import org.junit.Assert;
    }
                public String executor() {
        final GetSegmentFilesRequest request = new GetSegmentFilesRequest(
            }
        testThreadPool = null;
import org.opensearch.index.shard.IndexShard;
            transportService,
    private void executeGetMergedSegmentFiles(GetSegmentFilesRequest request, ActionListener<GetSegmentFilesResponse> listener) {
            public void onFailure(Exception e) {
                    listener.onResponse(response);
import java.util.concurrent.TimeUnit;
        executeGetSegmentFiles(request, new ActionListener<>() {
            mockIndicesService,
        transportService.sendRequest(
import org.opensearch.common.settings.Settings;
        }
            1,
                    return new GetSegmentFilesResponse(in);
            @Override
        testThreadPool = new TestThreadPool("test", Settings.EMPTY);
        transportService.acceptIncomingRequests();
            "allocationId",
                assertEquals(0, response.files.size());
            Settings.EMPTY,
            }
        );
import org.opensearch.test.OpenSearchTestCase;
                @Override
                public void handleException(TransportException e) {
        final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        when(mockIndexService.getShard(testShardId.id())).thenReturn(mockIndexShard);
        });
        CapturingTransport transport = new CapturingTransport();
                    listener.onFailure(e);
        final GetSegmentFilesRequest request = new GetSegmentFilesRequest(
        localNode = new DiscoveryNode("local", buildNewFakeTransportAddress(), Version.CURRENT);
                @Override
            Collections.emptyList(),
import org.opensearch.cluster.routing.ShardRouting;
    private TestThreadPool testThreadPool;
        );
                public GetSegmentFilesResponse read(StreamInput in) throws IOException {
            Collections.emptyList(),
                    listener.onFailure(e);
                @Override
import java.util.Collections;
            SegmentReplicationSourceService.Actions.UPDATE_VISIBLE_CHECKPOINT,
            mockIndexShard.getOperationPrimaryTerm(),
                    listener.onResponse(response);
                public void handleException(TransportException e) {
            "allocationId",
import org.opensearch.indices.replication.common.ReplicationType;
        );
            request,
            new TransportResponseHandler<GetSegmentFilesResponse>() {
                    return new CheckpointInfoResponse(in);
 */
        super.tearDown();
        verify(ongoingSegmentReplications, times(1)).clearOutOfSyncIds(any(), any());
import org.opensearch.transport.TransportException;
    public void testPrimaryClearsOutOfSyncIds() {
    private TransportService transportService;
        when(mockIndexShard.state()).thenReturn(IndexShardState.CLOSED);
            request,
            @Override
                fail("unexpected exception: " + e);
            @Override
        when(mock.routingTableChanged()).thenReturn(true);
                public CheckpointInfoResponse read(StreamInput in) throws IOException {
package org.opensearch.indices.replication;
import org.opensearch.indices.replication.common.CopyStateTests;
        transportService.start();
            0L,
            Collections.emptyList(),
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            try (StreamInput in = out.bytes().streamInput()) {
            public void onFailure(Exception e) {
import java.util.List;
        );
                @Override
                assertTrue(TransportResponse.Empty.INSTANCE.equals(transportResponse));
            testCheckpoint
            new TransportResponseHandler<>() {
import org.opensearch.index.IndexSettings;
    private void executeUpdateVisibleCheckpoint(UpdateVisibleCheckpointRequest request, ActionListener<TransportResponse> listener) {
                public void handleException(TransportException e) {
        );
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(
            recoverySettings,
            localNode,
    private ReplicationCheckpoint testCheckpoint;
                @Override
import org.opensearch.Version;
                }
            1,
            null,
        });
        when(routing.primary()).thenReturn(true);
            testCheckpoint
            }
 * compatible open source license.
                assertTrue(newRequest.getTargetAllocationId().equals(request.getTargetAllocationId()));
    public void testCheckpointInfo() {
        final ShardRouting routing = mock(ShardRouting.class);
            testCheckpoint
import org.opensearch.common.io.stream.BytesStreamOutput;
                    listener.onResponse(response);
    }
        mockIndicesService = mock(IndicesService.class);
        ongoingSegmentReplications = spy(new OngoingSegmentReplications(mockIndicesService, recoverySettings));
import org.opensearch.index.shard.ReplicationGroup;
            @Override
            public void onFailure(Exception e) {
            request.writeTo(out);
    }
        when(mockIndicesService.indexServiceSafe(testShardId.getIndex())).thenReturn(mockIndexService);
                }
    public void testGetSegmentFiles() {
    @Override
        executeGetMergedSegmentFiles(request, new ActionListener<>() {
                public void handleResponse(GetSegmentFilesResponse response) {
        testCheckpoint = new ReplicationCheckpoint(
            }
            request,
            "allocationId",
    public void testGetMergedSegmentFiles_shardClosed() {
        final ReplicationGroup replicationGroup = mock(ReplicationGroup.class);
            public void onFailure(Exception e) {
        ShardId testShardId = mockIndexShard.shardId();
    @Override
import org.opensearch.transport.TransportResponseHandler;
        transportService.sendRequest(
            @Override
import org.opensearch.indices.IndicesService;
 * SPDX-License-Identifier: Apache-2.0
        );
                public GetSegmentFilesResponse read(StreamInput in) throws IOException {
            SegmentReplicationSourceService.Actions.GET_SEGMENT_FILES,
                }
            Collections.emptySet(),
        when(mockIndexShard.getReplicationGroup()).thenReturn(replicationGroup);
        executeGetMergedSegmentFiles(request, new ActionListener<>() {
            1,
import static org.mockito.Mockito.any;
                }
                }
            0L,
                fail("unexpected exception: " + e);
                @Override
import static org.mockito.Mockito.when;
 * The OpenSearch Contributors require contributions made to
            "",
        final ClusterChangedEvent mock = mock(ClusterChangedEvent.class);
            localNode,
                }
    }
            localNode,
        // This mirrors the creation of the ReplicationCheckpoint inside CopyState
            localNode,
    private IndicesService mockIndicesService;
        transportService.sendRequest(
    }
    }
                }
            @Override
import org.opensearch.test.transport.CapturingTransport;
import org.opensearch.cluster.node.DiscoveryNode;
                }
                    return ThreadPool.Names.SAME;
        );
                assertEquals(1, response.getMetadataMap().size());
        executeGetMergedSegmentFiles(request, new ActionListener<>() {
        final GetSegmentFilesRequest request = new GetSegmentFilesRequest(
                public String executor() {
    private IndexShard mockIndexShard;
            localNode,
public class SegmentReplicationSourceServiceTests extends OpenSearchTestCase {
                    return new GetSegmentFilesResponse(in);
            }
            public void onResponse(GetSegmentFilesResponse response) {
            testThreadPool,
        when(mockIndexShard.isPrimaryMode()).thenReturn(true);
            public void onFailure(Exception e) {
    }
                public void handleResponse(TransportResponse response) {
                }
        );
    private OngoingSegmentReplications ongoingSegmentReplications;
import org.opensearch.common.settings.ClusterSettings;
            NoopTracer.INSTANCE
            Codec.getDefault().getName()
            }
            public void onResponse(GetSegmentFilesResponse response) {
                @Override
            new TransportResponseHandler<CheckpointInfoResponse>() {
                fail("unexpected exception: " + e);
                UpdateVisibleCheckpointRequest newRequest = new UpdateVisibleCheckpointRequest(in);
                    return ThreadPool.Names.SAME;
import static org.mockito.Mockito.times;
                }
        final GetSegmentFilesRequest request = new GetSegmentFilesRequest(
            public void onResponse(TransportResponse transportResponse) {
                }
            }
                public void handleException(TransportException e) {
            SegmentReplicationSourceService.Actions.GET_MERGED_SEGMENT_FILES,
            }
                }
            }
 *
            ongoingSegmentReplications
    }
        when(mockIndicesService.iterator()).thenReturn(List.of(mockIndexService).iterator());
        mockIndexShard = CopyStateTests.createMockIndexShard();
/*
                @Override
    private DiscoveryNode localNode;
        transportService.sendRequest(
    public void testGetMergedSegmentFiles() {
                @Override
                @Override
            }
        super.setUp();
            testCheckpoint
                assertEquals(testCheckpoint, response.getCheckpoint());
        final CheckpointInfoRequest request = new CheckpointInfoRequest(1L, "testAllocationId", localNode, testCheckpoint);
        );
}
                assert e.getCause() instanceof IllegalStateException;
                public void handleResponse(CheckpointInfoResponse response) {
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
                Assert.fail("Test should fail");
            public void onFailure(Exception e) {
import org.opensearch.core.action.ActionListener;
    public void testGetMergedSegmentFiles_shardNonPrimary() {
            mockIndexShard.shardId(),
    public void tearDown() throws Exception {
        );
            }
    }
        IndexService mockIndexService = mock(IndexService.class);
    public void testUpdateVisibleCheckpoint() {
        transportService = transport.createTransportService(
                @Override
                @Override
            public void onResponse(GetSegmentFilesResponse response) {
                    return ThreadPool.Names.SAME;
                    listener.onFailure(e);
        ThreadPool.terminate(testThreadPool, 30, TimeUnit.SECONDS);
                    listener.onResponse(TransportResponse.Empty.INSTANCE);
    }
                    return new CheckpointInfoResponse(in);
                Assert.fail("Test should fail");
        when(mockIndexShard.getRecoverySettings()).thenReturn(recoverySettings);
        });
                @Override
        });
import org.opensearch.test.IndexSettingsModule;
                }
            1,
        when(mockIndexShard.isPrimaryMode()).thenReturn(false);
import org.opensearch.index.shard.IndexShardState;
            }
            @Override
        } catch (IOException e) {
                fail("unexpected exception: " + e);
        UpdateVisibleCheckpointRequest request = new UpdateVisibleCheckpointRequest(
        when(mockIndexShard.state()).thenReturn(IndexShardState.STARTED);
                public String executor() {
        );
            @Override
            localNode,
            fail("Failed to parse UpdateVisibleCheckpointRequest " + e);
        when(mockIndexService.getIndexSettings()).thenReturn(indexSettings);
                }
            0L,
                @Override
            }
import org.opensearch.cluster.ClusterChangedEvent;
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.codecs.Codec;
            new TransportResponseHandler<GetSegmentFilesResponse>() {
        when(mockIndexShard.getThreadPool()).thenReturn(testThreadPool);
                public CheckpointInfoResponse read(StreamInput in) throws IOException {
            localNode,
                assertTrue(newRequest.getCheckpoint().equals(request.getCheckpoint()));
                public String executor() {
    }
            testCheckpoint
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_REPLICATION_TYPE_SETTING;
                }
        when(replicationGroup.getInSyncAllocationIds()).thenReturn(Collections.emptySet());
    }
import java.io.IOException;
            @Override
import org.opensearch.index.IndexService;
            @Override
import org.opensearch.transport.TransportService;
        // setup mocks
            }
            }
            localNode,
    }
            public void onResponse(GetSegmentFilesResponse response) {
            Settings.builder().put(INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT).build()
            localNode,
        );
    public void setUp() throws Exception {
                @Override
            SegmentReplicationSourceService.Actions.GET_CHECKPOINT_INFO,
    private void executeGetSegmentFiles(GetSegmentFilesRequest request, ActionListener<GetSegmentFilesResponse> listener) {
            @Override
        );
import static org.mockito.Mockito.verify;
import org.opensearch.indices.recovery.RecoverySettings;
            public void onResponse(CheckpointInfoResponse response) {
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.core.transport.TransportResponse;
        when(mockIndexService.iterator()).thenReturn(List.of(mockIndexShard).iterator());
