import org.opensearch.index.store.StoreFileMetadata;  
    private TransportService transportService;
        replicationSource.getMergedSegmentFiles(  
        assertEquals(sourceNode, capturedRequest.node);
            mock(ActionListener.class)  
    }
        final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
            indexShard.shardId(),
            Arrays.asList(testMetadata),  
        assertEquals(SegmentReplicationSourceService.Actions.GET_MERGED_SEGMENT_FILES, capturedRequest.action);
import org.apache.lucene.codecs.Codec;
        );
        CapturingTransport.CapturedRequest[] requestList = transport.getCapturedRequestsAndClear();
    }
            (fileName, bytesRecovered) -> {},
    /**  
import org.opensearch.cluster.node.DiscoveryNodeRole;
            REPLICATION_ID,  
            1,  
            null,
        assertEquals(SegmentReplicationSourceService.Actions.GET_SEGMENT_FILES, capturedRequest.action);
    public void setUp() throws Exception {  
 * SPDX-License-Identifier: Apache-2.0
        );
            (fileName, bytesRecovered) -> {},
        super.tearDown();
        return new DiscoveryNode(
            REPLICATION_ID,
import org.opensearch.test.ClusterServiceUtils;
        this.recoverySettings = recoverySettings;
    }
            Codec.getDefault().getName()
            mock(IndexShard.class),
        transport = new CapturingTransport();
        final RecoverySettings recoverySettings = new RecoverySettings(settings, clusterSettings);
            recoverySettings,
    private static final long PRIMARY_TERM = 1L;
        );  
import org.opensearch.indices.recovery.RecoverySettings;
            PRIMARY_TERM,  
        assertEquals(SegmentReplicationSourceService.Actions.GET_CHECKPOINT_INFO, capturedRequest.action);
            PRIMARY_TERM,
            VERSION,
     */
        assertEquals(sourceNode, capturedRequest.node);  
            indexShard.shardId(),
            mock(ActionListener.class)  
    }
    private PrimaryShardReplicationSource replicationSource;
            mock(IndexShard.class),
    private DiscoveryNode sourceNode;
import java.util.Map;
        assertEquals(1, requestList.length);  
import org.opensearch.transport.TransportService;
    }
            buildNewFakeTransportAddress(),
    @Override  
import org.opensearch.common.settings.ClusterSettings;  
        );
        replicationSource = new PrimaryShardReplicationSource(  
        transportService.start();  
            SEGMENTS_GEN,
            indexShard.shardId(),  
            "_0"
        IOUtils.close(transportService, clusterService, transport);
    }
        );
            randomAlphaOfLength(10),
        replicationSource.getSegmentFiles(
        CapturingTransport.CapturedRequest[] requestList = transport.getCapturedRequestsAndClear();
        assertEquals(recoverySettings.internalActionLongTimeout(), capturedRequest.options.timeout());  
 */  
        assertEquals(sourceNode, capturedRequest.node);  
        assertTrue(capturedRequest.request instanceof GetSegmentFilesRequest);
package org.opensearch.indices.replication;
    private static final long REPLICATION_ID = 123L;  
        assertEquals(1, requestList.length);  
            REPLICATION_ID,
            indexShard.shardId(),
    /**
        final DiscoveryNode localNode = newDiscoveryNode("localNode");
 * compatible open source license.
            indexShard.shardId(),
        CapturingTransport.CapturedRequest capturedRequest = requestList[0];  
    private DiscoveryNode newDiscoveryNode(String nodeName) {
            mock(ActionListener.class)
        replicationSource.getCheckpointMetadata(REPLICATION_ID, checkpoint, mock(ActionListener.class));  
            Collections.singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
        long fileSize = (long) (Math.pow(10, 9));
     * This test verifies the transport request timeout value for fetching the merged segment files.
    private static final long VERSION = 4L;
    private static final long SEGMENTS_GEN = 2L;  
            transportService,  
            Codec.getDefault().getName(),
            1,
            mock(IndexShard.class),
import java.util.Collections;
    public void testTransportTimeoutForGetMergedSegmentFilesAction() {  
    public void testGetSegmentFiles() {  
        );  
            REPLICATION_ID,
        final ReplicationCheckpoint checkpoint = new MergedSegmentCheckpoint(  
            PRIMARY_TERM,
import org.opensearch.telemetry.tracing.noop.NoopTracer;
            Codec.getDefault().getName()
            Arrays.asList(testMetadata),  
        CapturingTransport.CapturedRequest capturedRequest = requestList[0];
            Map.of("testFile", testMetadata),  
            1,  
        assertEquals(sourceNode, capturedRequest.node);  
        indexShard = newStartedShard(true);  
        replicationSource.getMergedSegmentFiles(  
        assertTrue(capturedRequest.request instanceof CheckpointInfoRequest);  
            boundAddress -> clusterService.localNode(),
 *
        final ReplicationCheckpoint checkpoint = new MergedSegmentCheckpoint(  
        );  
        );
            checkpoint,
            Collections.emptySet(),  
        CapturingTransport.CapturedRequest capturedRequest = requestList[0];  
            1,
}
            NoopTracer.INSTANCE
    private ClusterService clusterService;  
import org.opensearch.cluster.service.ClusterService;
        assertEquals(SegmentReplicationSourceService.Actions.GET_SEGMENT_FILES, capturedRequest.action);
            "_0"
        );
import org.apache.lucene.util.Version;
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,  
            mock(IndexShard.class),  
            localNode,
/*  
            (fileName, bytesRecovered) -> {},
 * The OpenSearch Contributors require contributions made to  
        assertEquals(sourceNode, capturedRequest.node);
    @Override
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;  
import org.opensearch.core.action.ActionListener;  
            PRIMARY_TERM,
    public void tearDown() throws Exception {
        final ReplicationCheckpoint checkpoint = new ReplicationCheckpoint(
 * this file be licensed under the Apache-2.0 license or a
            Map.of("testFile", testMetadata),  
    public void testGetCheckpointMetadata() {
            Arrays.asList(testMetadata),
    public void testTransportTimeoutForGetSegmentFilesAction() {
    }
        StoreFileMetadata testMetadata = new StoreFileMetadata("testFile", fileSize, "checksum", Version.LATEST);
        StoreFileMetadata testMetadata = new StoreFileMetadata("testFile", 1L, "checksum", Version.LATEST);
import org.opensearch.common.settings.Settings;
            org.opensearch.Version.CURRENT
    }
import org.opensearch.index.shard.IndexShardTestCase;
            Codec.getDefault().getName(),
        assertEquals(1, requestList.length);
            mock(ActionListener.class)  
        );  
public class PrimaryShardReplicationSourceTests extends IndexShardTestCase {  
        );
            VERSION,  
            VERSION,
            Collections.emptyMap(),  
            checkpoint,
            threadPool,
        closeShards(indexShard);  
        clusterService = ClusterServiceUtils.createClusterService(threadPool, localNode);
        );
        CapturingTransport.CapturedRequest[] requestList = transport.getCapturedRequestsAndClear();
     */  
import static org.mockito.Mockito.mock;
            nodeName,  
        transportService = transport.createTransportService(  
            (fileName, bytesRecovered) -> {},
        CapturingTransport.CapturedRequest[] requestList = transport.getCapturedRequestsAndClear();
import org.opensearch.index.shard.IndexShard;
     * This test verifies the transport request timeout value for fetching the segment files.
import org.opensearch.common.util.io.IOUtils;
        StoreFileMetadata testMetadata = new StoreFileMetadata("testFile", fileSize, "checksum", Version.LATEST);
            PRIMARY_TERM,
            SEGMENTS_GEN,  
            clusterService.getSettings(),
    private RecoverySettings recoverySettings;  
        assertTrue(capturedRequest.request instanceof GetSegmentFilesRequest);
            Codec.getDefault().getName()  
        super.setUp();
        StoreFileMetadata testMetadata = new StoreFileMetadata("testFile", 1L, "checksum", Version.LATEST);
        CapturingTransport.CapturedRequest capturedRequest = requestList[0];
        final Settings settings = Settings.builder().put("node.name", SegmentReplicationTargetServiceTests.class.getSimpleName()).build();
            checkpoint,
            Arrays.asList(testMetadata),  
        assertEquals(1, requestList.length);
            indexShard.routingEntry().allocationId().toString(),
    private IndexShard indexShard;  
import org.opensearch.cluster.node.DiscoveryNode;  
    private CapturingTransport transport;
        long fileSize = (long) (Math.pow(10, 9));
            sourceNode
        CapturingTransport.CapturedRequest capturedRequest = requestList[0];
        final ReplicationCheckpoint checkpoint = new ReplicationCheckpoint(
    private static final long SEQ_NO = 3L;
            SEGMENTS_GEN,
        transportService.acceptIncomingRequests();
        assertEquals(SegmentReplicationSourceService.Actions.GET_MERGED_SEGMENT_FILES, capturedRequest.action);
        CapturingTransport.CapturedRequest[] requestList = transport.getCapturedRequestsAndClear();
import org.opensearch.test.transport.CapturingTransport;  
            checkpoint,
        assertEquals(1, requestList.length);  
        assertEquals(recoverySettings.getMergedSegmentReplicationTimeout(), capturedRequest.options.timeout());
    public void testGetMergedSegmentFiles() {
        sourceNode = newDiscoveryNode("sourceNode");  
        final ReplicationCheckpoint checkpoint = new ReplicationCheckpoint(  
import java.util.Arrays;  
import org.opensearch.indices.replication.checkpoint.MergedSegmentCheckpoint;
        replicationSource.getSegmentFiles(  
