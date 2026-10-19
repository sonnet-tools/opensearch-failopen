                    listener.onFailure(e);  
                @Override
        verify(ongoingSegmentReplications, times(1)).clearOutOfSyncIds(any(), any());  
            testThreadPool,  
            1,
        when(mockIndexShard.getRecoverySettings()).thenReturn(recoverySettings);
    public void tearDown() throws Exception {
            @Override
            request,  
    public void testGetSegmentFiles() {
    }
        when(mockIndexService.getIndexSettings()).thenReturn(indexSettings);
            }  
            public void onResponse(GetSegmentFilesResponse response) {
                public CheckpointInfoResponse read(StreamInput in) throws IOException {
import static org.mockito.Mockito.mock;
                public void handleResponse(GetSegmentFilesResponse response) {  
        );
            fail("Failed to parse UpdateVisibleCheckpointRequest " + e);
            @Override
    }
        when(mockIndexShard.state()).thenReturn(IndexShardState.STARTED);  
        when(mockIndicesService.indexServiceSafe(testShardId.getIndex())).thenReturn(mockIndexService);
                @Override  
        when(mockIndexShard.state()).thenReturn(IndexShardState.CLOSED);  
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
        executeGetSegmentFiles(request, new ActionListener<>() {
    private void executeGetMergedSegmentFiles(GetSegmentFilesRequest request, ActionListener<GetSegmentFilesResponse> listener) {
        final GetSegmentFilesRequest request = new GetSegmentFilesRequest(
                    return new GetSegmentFilesResponse(in);
import org.apache.lucene.codecs.Codec;
    private SegmentReplicationSourceService segmentReplicationSourceService;
            request,
    public void testCheckpointInfo() {
    }  
import java.util.List;  
            localNode,
import static org.mockito.Mockito.spy;  
            localNode,  
            mockIndicesService,  
                public void handleException(TransportException e) {  
                public GetSegmentFilesResponse read(StreamInput in) throws IOException {  
                @Override
 * SPDX-License-Identifier: Apache-2.0
        final CheckpointInfoRequest request = new CheckpointInfoRequest(1L, "testAllocationId", localNode, testCheckpoint);
            SegmentReplicationSourceService.Actions.GET_CHECKPOINT_INFO,
            testCheckpoint
            testCheckpoint
        final Settings settings = Settings.builder().put("node.name", SegmentReplicationTargetServiceTests.class.getSimpleName()).build();
            }
            1,
import org.opensearch.core.common.io.stream.StreamInput;
            localNode,
            }
            localNode,  
            SegmentReplicationSourceService.Actions.GET_MERGED_SEGMENT_FILES,
            @Override  
/*  
import org.opensearch.indices.recovery.RecoverySettings;
        segmentReplicationSourceService = new SegmentReplicationSourceService(
import org.opensearch.cluster.routing.ShardRouting;
            @Override
                UpdateVisibleCheckpointRequest newRequest = new UpdateVisibleCheckpointRequest(in);
            public void onResponse(TransportResponse transportResponse) {
        transportService.sendRequest(  
        CapturingTransport transport = new CapturingTransport();
    private IndicesService mockIndicesService;
import org.junit.Assert;
                }
                    listener.onFailure(e);
    private TestThreadPool testThreadPool;
    }
                    return ThreadPool.Names.SAME;
        mockIndexShard = CopyStateTests.createMockIndexShard();
            @Override
package org.opensearch.indices.replication;
            }  
import org.opensearch.threadpool.TestThreadPool;  
        executeGetCheckpointInfo(new ActionListener<>() {
    }
                    listener.onResponse(TransportResponse.Empty.INSTANCE);
                }
            localNode,
            "allocationId",
            1,
            NoopTracer.INSTANCE
                public String executor() {
        // setup mocks
import static org.mockito.Mockito.verify;
            null,  
            mockIndexShard.getOperationPrimaryTerm(),
import org.opensearch.core.transport.TransportResponse;  
            "allocationId",  
 * The OpenSearch Contributors require contributions made to  
            "index",
                    listener.onResponse(response);
                fail("unexpected exception: " + e);
    private void executeUpdateVisibleCheckpoint(UpdateVisibleCheckpointRequest request, ActionListener<TransportResponse> listener) {
    public void testUpdateVisibleCheckpoint() {
                @Override
import org.opensearch.index.IndexSettings;
import java.util.concurrent.TimeUnit;
                public void handleResponse(CheckpointInfoResponse response) {
 * this file be licensed under the Apache-2.0 license or a
                @Override  
            try (StreamInput in = out.bytes().streamInput()) {
        );
        transportService = transport.createTransportService(
                public String executor() {  
        UpdateVisibleCheckpointRequest request = new UpdateVisibleCheckpointRequest(
        transportService.sendRequest(
            }
    }  
                }  
            0L,  
        mockIndicesService = mock(IndicesService.class);
        when(mockIndexShard.isPrimaryMode()).thenReturn(false);
                @Override
 * compatible open source license.
            }
                assertEquals(0, response.files.size());
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_REPLICATION_TYPE_SETTING;  
            }
            public void onResponse(GetSegmentFilesResponse response) {
        transportService.sendRequest(
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        transportService.sendRequest(
        executeGetMergedSegmentFiles(request, new ActionListener<>() {
    public void testGetMergedSegmentFiles_shardNonPrimary() {  
                @Override  
                fail("unexpected exception: " + e);  
        );
        when(mockIndexShard.getReplicationGroup()).thenReturn(replicationGroup);
import org.opensearch.cluster.node.DiscoveryNode;
    private void executeGetSegmentFiles(GetSegmentFilesRequest request, ActionListener<GetSegmentFilesResponse> listener) {  
                public GetSegmentFilesResponse read(StreamInput in) throws IOException {
        when(mockIndexShard.routingEntry()).thenReturn(routing);
        );  
                }
                assertEquals(1, response.getMetadataMap().size());
                public void handleException(TransportException e) {  
            }
        localNode = new DiscoveryNode("local", buildNewFakeTransportAddress(), Version.CURRENT);  
                assertEquals(0, response.files.size());
import org.opensearch.transport.TransportService;
            1,  
            Settings.EMPTY,
            new TransportResponseHandler<GetSegmentFilesResponse>() {
            SegmentReplicationSourceService.Actions.UPDATE_VISIBLE_CHECKPOINT,  
                }  
    @Override
    }  
        final ClusterChangedEvent mock = mock(ClusterChangedEvent.class);  
            Collections.emptyList(),
        executeUpdateVisibleCheckpoint(request, new ActionListener<>() {  
        });
        when(mockIndexShard.isPrimaryMode()).thenReturn(true);  
        }
            public void onResponse(GetSegmentFilesResponse response) {  
    }  
                public String executor() {
            SegmentReplicationSourceService.Actions.GET_SEGMENT_FILES,  
            request,
import org.opensearch.indices.IndicesService;  
import java.util.Collections;
        });  
import org.opensearch.threadpool.ThreadPool;
            }  
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(
            public void onFailure(Exception e) {
            Collections.emptyList(),
        final RecoverySettings recoverySettings = new RecoverySettings(settings, clusterSettings);  
            transportService,
            "allocationId",
            testCheckpoint  
    }  
        // This mirrors the creation of the ReplicationCheckpoint inside CopyState
            "allocationId",
        );  
import static org.mockito.Mockito.any;
import org.opensearch.index.shard.IndexShard;  
                public String executor() {
                    return ThreadPool.Names.SAME;  
        });
import org.opensearch.indices.replication.common.CopyStateTests;  
        } catch (IOException e) {  
                public void handleResponse(GetSegmentFilesResponse response) {
import org.opensearch.core.index.shard.ShardId;
import java.io.IOException;
        );
                }  
                fail("unexpected exception: " + e);  
            request.writeTo(out);  
import org.opensearch.index.IndexService;
            @Override  
            testCheckpoint
            }
        ThreadPool.terminate(testThreadPool, 30, TimeUnit.SECONDS);  
        );
            }
            localNode,
import org.opensearch.transport.TransportResponseHandler;  
                @Override
                fail("unexpected exception: " + e);  
    private void executeGetCheckpointInfo(ActionListener<CheckpointInfoResponse> listener) {  
            @Override  
        );
import org.opensearch.telemetry.tracing.noop.NoopTracer;
            new TransportResponseHandler<>() {
                @Override
                public CheckpointInfoResponse read(StreamInput in) throws IOException {
                    listener.onFailure(e);
                }
    private TransportService transportService;  
        );  
        final ReplicationGroup replicationGroup = mock(ReplicationGroup.class);
        transportService.acceptIncomingRequests();
import static org.mockito.Mockito.times;
                Assert.fail("Test should fail");  
            mockIndexShard.shardId(),
                @Override
import org.opensearch.test.transport.CapturingTransport;
        final GetSegmentFilesRequest request = new GetSegmentFilesRequest(  
                @Override
                assert e.getCause() instanceof IllegalStateException;
                @Override
        );
        when(mockIndicesService.iterator()).thenReturn(List.of(mockIndexService).iterator());  
                }  
            public void onFailure(Exception e) {
        });
                @Override
            ongoingSegmentReplications  
                    listener.onResponse(response);
    }  
        ShardId testShardId = mockIndexShard.shardId();  
                }
                }
        });
        IndexService mockIndexService = mock(IndexService.class);
            "",
        testThreadPool = null;
            public void onFailure(Exception e) {
            @Override
        executeGetMergedSegmentFiles(request, new ActionListener<>() {
public class SegmentReplicationSourceServiceTests extends OpenSearchTestCase {
                Assert.fail("Test should fail");
                @Override  
                assertEquals(testCheckpoint, response.getCheckpoint());
        testCheckpoint = new ReplicationCheckpoint(  
        });
            recoverySettings,
            0L,
                public void handleResponse(TransportResponse response) {
    private OngoingSegmentReplications ongoingSegmentReplications;  
    private IndexShard mockIndexShard;
                @Override  
import org.opensearch.transport.TransportException;
            }
        );
        );  
 */  
            @Override  
            }
            testShardId,
            Settings.builder().put(INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT).build()  
    private ReplicationCheckpoint testCheckpoint;
                assertNotNull(response.getInfosBytes());  
        super.tearDown();
                    return ThreadPool.Names.SAME;
                }
    }
                }
            0L,  
            Codec.getDefault().getName()
                    return new CheckpointInfoResponse(in);  
 *
    }
    public void testGetMergedSegmentFiles() {
                assertTrue(newRequest.getCheckpoint().equals(request.getCheckpoint()));  
        when(mock.routingTableChanged()).thenReturn(true);
        executeGetMergedSegmentFiles(request, new ActionListener<>() {  
import org.opensearch.index.shard.ReplicationGroup;
            localNode,  
        when(mockIndexShard.getThreadPool()).thenReturn(testThreadPool);
import org.opensearch.test.OpenSearchTestCase;
            @Override
                }
        when(replicationGroup.getInSyncAllocationIds()).thenReturn(Collections.emptySet());
        final GetSegmentFilesRequest request = new GetSegmentFilesRequest(
                assertTrue(newRequest.getTargetAllocationId().equals(request.getTargetAllocationId()));
            public void onFailure(Exception e) {
        );  
            public void onResponse(CheckpointInfoResponse response) {
        super.setUp();  
                public void handleException(TransportException e) {
import org.opensearch.common.settings.ClusterSettings;
        when(mockIndexService.iterator()).thenReturn(List.of(mockIndexShard).iterator());  
            request,
    public void testPrimaryClearsOutOfSyncIds() {
        segmentReplicationSourceService.clusterChanged(mock);
                    return new CheckpointInfoResponse(in);
        when(mockIndexService.getShard(testShardId.id())).thenReturn(mockIndexShard);
        when(routing.primary()).thenReturn(true);
import org.opensearch.indices.replication.common.ReplicationType;
                assertTrue(TransportResponse.Empty.INSTANCE.equals(transportResponse));  
        transportService.start();
            Collections.emptyList(),  
                    listener.onResponse(response);  
    }
                }
        testThreadPool = new TestThreadPool("test", Settings.EMPTY);
            localNode,  
        final GetSegmentFilesRequest request = new GetSegmentFilesRequest(  
    @Override
        ongoingSegmentReplications = spy(new OngoingSegmentReplications(mockIndicesService, recoverySettings));
            new TransportResponseHandler<CheckpointInfoResponse>() {  
                }  
    private DiscoveryNode localNode;
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
            public void onFailure(Exception e) {
import org.opensearch.test.IndexSettingsModule;  
            }
            testCheckpoint
}
            public void onFailure(Exception e) {  
                    return ThreadPool.Names.SAME;  
import static org.mockito.Mockito.when;  
            localNode,
                @Override  
import org.opensearch.common.settings.Settings;
import org.opensearch.core.action.ActionListener;  
            @Override
import org.opensearch.Version;
        final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    public void setUp() throws Exception {
            }
import org.opensearch.cluster.ClusterChangedEvent;  
                    return new GetSegmentFilesResponse(in);
            public void onResponse(GetSegmentFilesResponse response) {  
            new TransportResponseHandler<GetSegmentFilesResponse>() {
            @Override
import org.opensearch.common.io.stream.BytesStreamOutput;  
            Collections.emptyList(),
                assert e.getCause() instanceof IllegalStateException;
        final ShardRouting routing = mock(ShardRouting.class);  
                }  
    public void testGetMergedSegmentFiles_shardClosed() {
            boundAddress -> localNode,
                public void handleException(TransportException e) {
            Collections.emptySet(),
import org.opensearch.index.shard.IndexShardState;
                    listener.onFailure(e);
            }
            }  
