            mock(IndexShard.class),
        CapturingTransport.CapturedRequest[] requestList = transport.getCapturedRequestsAndClear();
        StoreFileMetadata testMetadata = new StoreFileMetadata("testFile", fileSize, "checksum", Version.LATEST);
    public void testTransportTimeoutForGetMergedSegmentFilesAction() {
            1,
            Collections.emptyMap(),
        assertEquals(1, requestList.length);
import org.opensearch.common.util.io.IOUtils;
        CapturingTransport.CapturedRequest capturedRequest = requestList[0];
 * this file be licensed under the Apache-2.0 license or a
            "_0"
import org.opensearch.index.shard.IndexShardTestCase;
            Codec.getDefault().getName(),
    /**
import java.util.Map;
            PRIMARY_TERM,
        StoreFileMetadata testMetadata = new StoreFileMetadata("testFile", 1L, "checksum", Version.LATEST);
import org.opensearch.core.action.ActionListener;
    public void tearDown() throws Exception {
            (fileName, bytesRecovered) -> {},
            VERSION,
    @Override
            indexShard.shardId(),
        );
import org.opensearch.test.transport.CapturingTransport;
        final ReplicationCheckpoint checkpoint = new ReplicationCheckpoint(
import java.util.Arrays;
        assertEquals(1, requestList.length);
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
        assertTrue(capturedRequest.request instanceof GetSegmentFilesRequest);
        assertEquals(1, requestList.length);
    @Override
    private static final long REPLICATION_ID = 123L;
    private DiscoveryNode newDiscoveryNode(String nodeName) {
        assertTrue(capturedRequest.request instanceof GetSegmentFilesRequest);
        assertEquals(SegmentReplicationSourceService.Actions.GET_SEGMENT_FILES, capturedRequest.action);
     * This test verifies the transport request timeout value for fetching the merged segment files.
    }
            indexShard.shardId(),
    private static final long PRIMARY_TERM = 1L;
    private DiscoveryNode sourceNode;
        transportService.start();
            mock(IndexShard.class),
        );
            Collections.emptySet(),
        super.tearDown();
        replicationSource.getSegmentFiles(
        final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        CapturingTransport.CapturedRequest capturedRequest = requestList[0];
     * This test verifies the transport request timeout value for fetching the segment files.
}
    private TransportService transportService;
            Codec.getDefault().getName()
        assertEquals(1, requestList.length);
        assertEquals(SegmentReplicationSourceService.Actions.GET_MERGED_SEGMENT_FILES, capturedRequest.action);
        assertTrue(capturedRequest.request instanceof CheckpointInfoRequest);
            (fileName, bytesRecovered) -> {},
            boundAddress -> clusterService.localNode(),
            PRIMARY_TERM,
            SEGMENTS_GEN,
    public void testGetCheckpointMetadata() {
        CapturingTransport.CapturedRequest capturedRequest = requestList[0];
        assertEquals(sourceNode, capturedRequest.node);
        replicationSource.getCheckpointMetadata(REPLICATION_ID, checkpoint, mock(ActionListener.class));
            Codec.getDefault().getName()
            1,
    /**
            mock(ActionListener.class)
 * The OpenSearch Contributors require contributions made to
    public void testGetSegmentFiles() {
    }
        );
            checkpoint,
    public void testTransportTimeoutForGetSegmentFilesAction() {
import org.opensearch.cluster.node.DiscoveryNodeRole;
        long fileSize = (long) (Math.pow(10, 9));
import org.opensearch.test.ClusterServiceUtils;
            mock(ActionListener.class)
            checkpoint,
            PRIMARY_TERM,
        assertEquals(1, requestList.length);
            mock(ActionListener.class)
            VERSION,
        sourceNode = newDiscoveryNode("sourceNode");
        CapturingTransport.CapturedRequest[] requestList = transport.getCapturedRequestsAndClear();
 *
        replicationSource.getMergedSegmentFiles(
        CapturingTransport.CapturedRequest capturedRequest = requestList[0];
            (fileName, bytesRecovered) -> {},
            REPLICATION_ID,
            randomAlphaOfLength(10),
/*
        final ReplicationCheckpoint checkpoint = new MergedSegmentCheckpoint(
public class PrimaryShardReplicationSourceTests extends IndexShardTestCase {
        final ReplicationCheckpoint checkpoint = new ReplicationCheckpoint(
import org.opensearch.telemetry.tracing.noop.NoopTracer;
    private static final long SEQ_NO = 3L;
            Arrays.asList(testMetadata),
        );
            Arrays.asList(testMetadata),
import org.opensearch.common.settings.Settings;
        CapturingTransport.CapturedRequest[] requestList = transport.getCapturedRequestsAndClear();
        final ReplicationCheckpoint checkpoint = new MergedSegmentCheckpoint(
        CapturingTransport.CapturedRequest capturedRequest = requestList[0];
    public void setUp() throws Exception {
    }
        return new DiscoveryNode(
        replicationSource = new PrimaryShardReplicationSource(
            Codec.getDefault().getName()
            (fileName, bytesRecovered) -> {},
        assertEquals(sourceNode, capturedRequest.node);
import org.opensearch.indices.recovery.RecoverySettings;
            VERSION,
            checkpoint,
        assertEquals(SegmentReplicationSourceService.Actions.GET_CHECKPOINT_INFO, capturedRequest.action);
            localNode,
    private RecoverySettings recoverySettings;
            Map.of("testFile", testMetadata),
 * compatible open source license.
        );
import org.opensearch.indices.replication.checkpoint.MergedSegmentCheckpoint;
            Codec.getDefault().getName(),
    }
            indexShard.shardId(),
package org.opensearch.indices.replication;
     */
 * SPDX-License-Identifier: Apache-2.0
    private CapturingTransport transport;
        transport = new CapturingTransport();
        CapturingTransport.CapturedRequest[] requestList = transport.getCapturedRequestsAndClear();
            Collections.singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
            mock(ActionListener.class)
            PRIMARY_TERM,
            1,
import static org.mockito.Mockito.mock;
        StoreFileMetadata testMetadata = new StoreFileMetadata("testFile", fileSize, "checksum", Version.LATEST);
 */
        long fileSize = (long) (Math.pow(10, 9));
        replicationSource.getSegmentFiles(
            null,
import org.opensearch.index.shard.IndexShard;
            clusterService.getSettings(),
            transportService,
            REPLICATION_ID,
            Arrays.asList(testMetadata),
        );
        super.setUp();
        CapturingTransport.CapturedRequest[] requestList = transport.getCapturedRequestsAndClear();
    private ClusterService clusterService;
        assertEquals(sourceNode, capturedRequest.node);
            1,
            org.opensearch.Version.CURRENT
        closeShards(indexShard);
            PRIMARY_TERM,
        this.recoverySettings = recoverySettings;
        assertEquals(SegmentReplicationSourceService.Actions.GET_MERGED_SEGMENT_FILES, capturedRequest.action);
        transportService = transport.createTransportService(
            indexShard.shardId(),
        );
        replicationSource.getMergedSegmentFiles(
            REPLICATION_ID,
import org.opensearch.cluster.service.ClusterService;
            threadPool,
        IOUtils.close(transportService, clusterService, transport);
    }
        clusterService = ClusterServiceUtils.createClusterService(threadPool, localNode);
    private static final long SEGMENTS_GEN = 2L;
        assertEquals(recoverySettings.getMergedSegmentReplicationTimeout(), capturedRequest.options.timeout());
     */
            SEGMENTS_GEN,
            sourceNode
            checkpoint,
        assertEquals(sourceNode, capturedRequest.node);
import org.opensearch.index.store.StoreFileMetadata;
        final RecoverySettings recoverySettings = new RecoverySettings(settings, clusterSettings);
            indexShard.routingEntry().allocationId().toString(),
            REPLICATION_ID,
    }
        assertEquals(sourceNode, capturedRequest.node);
        );
import org.opensearch.cluster.node.DiscoveryNode;
    private PrimaryShardReplicationSource replicationSource;
        final Settings settings = Settings.builder().put("node.name", SegmentReplicationTargetServiceTests.class.getSimpleName()).build();
            indexShard.shardId(),
    private IndexShard indexShard;
    private static final long VERSION = 4L;
    }
            buildNewFakeTransportAddress(),
import org.apache.lucene.util.Version;
            "_0"
        assertEquals(SegmentReplicationSourceService.Actions.GET_SEGMENT_FILES, capturedRequest.action);
        );
    }
        final ReplicationCheckpoint checkpoint = new ReplicationCheckpoint(
        final DiscoveryNode localNode = newDiscoveryNode("localNode");
            mock(IndexShard.class),
            recoverySettings,
import org.opensearch.transport.TransportService;
    public void testGetMergedSegmentFiles() {
        StoreFileMetadata testMetadata = new StoreFileMetadata("testFile", 1L, "checksum", Version.LATEST);
        );
            Arrays.asList(testMetadata),
            mock(IndexShard.class),
            SEGMENTS_GEN,
        transportService.acceptIncomingRequests();
        );
            NoopTracer.INSTANCE
            nodeName,
        );
            Map.of("testFile", testMetadata),
import org.opensearch.common.settings.ClusterSettings;
        assertEquals(recoverySettings.internalActionLongTimeout(), capturedRequest.options.timeout());
import java.util.Collections;
import org.apache.lucene.codecs.Codec;
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
        indexShard = newStartedShard(true);
