            localNode,
            expectedFiles,
        final GetSegmentFilesRequest getSegmentFilesRequest = new GetSegmentFilesRequest(
            public void onFailure(Exception e) {
        // index some docs on the primary so a segment is created.
                assertTrue(getSegmentFilesResponse.files.isEmpty());
        super.setUp();
import org.opensearch.core.xcontent.MediaTypeRegistry;
            Collections.emptyList(),
            primary.routingEntry().allocationId().getId(),
        final GetSegmentFilesRequest getSegmentFilesRequest = new GetSegmentFilesRequest(
        final List<StoreFileMetadata> expectedFiles = List.copyOf(handler.getCheckpoint().getMetadataMap().values());
import org.junit.Assert;
        latch.await(2, TimeUnit.SECONDS);
            chunkWriter,
        replicaDiscoveryNode = replica.recoveryState().getTargetNode();
                latch.countDown();
        SegmentReplicationSourceHandler handler = new SegmentReplicationSourceHandler(
                Mockito.verifyNoInteractions(chunkWriter);
        final ReplicationCheckpoint latestReplicationCheckpoint = primary.getLatestReplicationCheckpoint();
            localNode,
            latestReplicationCheckpoint
            expectedFiles,
            @Override
        indexDoc(primary, "1", "{\"foo\" : \"baz\"}", MediaTypeRegistry.JSON, "foobar");
        final ReplicationCheckpoint latestReplicationCheckpoint = primary.getLatestReplicationCheckpoint();
            public void onResponse(GetSegmentFilesResponse getSegmentFilesResponse) {
        final List<StoreFileMetadata> expectedFiles = List.copyOf(copyState.getMetadataMap().values());
import org.opensearch.indices.replication.common.CopyState;
        final CopyState copyState = new CopyState(primary);
            replicaDiscoveryNode,
        handler.sendFiles(getSegmentFilesRequest, new ActionListener<>() {
        });
        final GetSegmentFilesRequest getSegmentFilesRequest = new GetSegmentFilesRequest(
        );
        );
            public void onResponse(GetSegmentFilesResponse getSegmentFilesResponse) {
                Assert.fail();
        closeShards(primary, replica);
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
        handler.sendFiles(getSegmentFilesRequest, new ActionListener<>() {
            @Override
}
    public void testReplicationAlreadyRunning() throws IOException {
            1
    private IndexShard replica;
        );
        CountDownLatch latch = new CountDownLatch(1);
import org.opensearch.core.action.ActionListener;
            public void onFailure(Exception e) {
        chunkWriter = mock(FileChunkWriter.class);
    private IndexShard primary;
    private FileChunkWriter chunkWriter;
            replicaDiscoveryNode,
            5000,
import org.opensearch.OpenSearchException;
            1L,
        );
            }
        );
    private DiscoveryNode replicaDiscoveryNode;
        chunkWriter = mock(FileChunkWriter.class);
            replica.routingEntry().allocationId().getId(),
            public void onFailure(Exception e) {
        assertEquals("listener should have resolved with failure", 0, latch.getCount());
            @Override
            localNode,
        primary.refresh("Test");
        final GetSegmentFilesRequest getSegmentFilesRequest = new GetSegmentFilesRequest(
            expectedFiles,
            @Override
            1
            latestReplicationCheckpoint
        );
                Assert.fail();
import java.util.concurrent.CountDownLatch;
import org.opensearch.index.store.StoreFileMetadata;
            primary,
            public void onResponse(GetSegmentFilesResponse getSegmentFilesResponse) {
 */
import static org.mockito.Mockito.verify;
        SegmentReplicationSourceHandler handler = new SegmentReplicationSourceHandler(
    public void tearDown() throws Exception {
        recoverReplica(replica, primary, true);
            replica.routingEntry().allocationId().getId(),
 * compatible open source license.
import org.mockito.Mockito;
            }
        );
            }
import org.opensearch.index.shard.IndexShardTestCase;
        );
            chunkWriter,
            }
    }
            chunkWriter,
        final ReplicationCheckpoint latestReplicationCheckpoint = primary.getLatestReplicationCheckpoint();
            5000,
            1
        final Settings settings = Settings.builder().put(IndexMetadata.SETTING_REPLICATION_TYPE, "SEGMENT").put(Settings.EMPTY).build();
            primary,
        );
import static org.mockito.Mockito.times;
            @Override
import java.util.Collections;
    }
        final List<StoreFileMetadata> expectedFiles = List.of(new StoreFileMetadata("_0.si", 20, "test", Version.CURRENT.luceneVersion));
 * this file be licensed under the Apache-2.0 license or a
            replica.routingEntry().allocationId().getId(),
import java.util.List;
import java.util.concurrent.TimeUnit;
            replica.routingEntry().allocationId().getId(),
        primary = newStartedShard(true, settings);
            5000,
            @Override
            replica.routingEntry().allocationId().getId(),
            replica.routingEntry().allocationId().getId(),
            5000,
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;
            chunkWriter,
        handler.sendFiles(getSegmentFilesRequest, new ActionListener<>() {
        );
import org.hamcrest.MatcherAssert;
        final ReplicationCheckpoint latestReplicationCheckpoint = primary.getLatestReplicationCheckpoint();
    @Override
import org.opensearch.index.engine.NRTReplicationEngineFactory;
            public void onResponse(GetSegmentFilesResponse getSegmentFilesResponse) {
            latestReplicationCheckpoint
            @Override
    public void setUp() throws Exception {
                Assert.fail("Expected failure.");
            new OpenSearchException("Test")
            replicaDiscoveryNode,
    public void testSendFiles() throws IOException {
import static org.mockito.Mockito.mock;
 * SPDX-License-Identifier: Apache-2.0
            primary.routingEntry().allocationId().getId(),
        handler.cancel("test");
            chunkWriter,
        // cancel before xfer starts. Cancels during copy will be tested in SegmentFileTransferHandlerTests, that uses the same
        chunkWriter = (fileMetadata, position, content, lastChunk, totalTranslogOps, listener) -> listener.onFailure(
import org.opensearch.index.shard.IndexShard;
            }
    }
        // cancellableThreads.
    public void testSendFileFails() throws IOException {
                Assert.fail();
            1L,
                MatcherAssert.assertThat(getSegmentFilesResponse.files, Matchers.containsInAnyOrder(expectedFiles.toArray()));
            }
            localNode,
import org.opensearch.Version;
        verify(chunkWriter, times(1)).cancel();
import org.hamcrest.Matchers;
        final ReplicationCheckpoint latestReplicationCheckpoint = primary.getLatestReplicationCheckpoint();
                assertEquals(e.getClass(), OpenSearchException.class);
    @Override
 * The OpenSearch Contributors require contributions made to
        super.tearDown();
        final GetSegmentFilesRequest getSegmentFilesRequest = new GetSegmentFilesRequest(
import java.io.IOException;
            1L,
                assertEquals(CancellableThreads.ExecutionCancelledException.class, e.getClass());
        final List<StoreFileMetadata> expectedFiles = List.of(new StoreFileMetadata("_0.si", 20, "test", Version.CURRENT.luceneVersion));
        );
        handler.sendFiles(getSegmentFilesRequest, mock(ActionListener.class));
            1
        final CopyState copyState = new CopyState(primary);
        SegmentReplicationSourceHandler handler = new SegmentReplicationSourceHandler(
        });
        chunkWriter = (fileMetadata, position, content, lastChunk, totalTranslogOps, listener) -> listener.onResponse(null);
            replica.routingEntry().allocationId().getId(),
            public void onFailure(Exception e) {
/*
        handler.sendFiles(getSegmentFilesRequest, new ActionListener<>() {
            1L,
            latestReplicationCheckpoint
    }
import org.opensearch.cluster.node.DiscoveryNode;
            expectedFiles,
            primary,
        copyState.close();
import org.opensearch.cluster.metadata.IndexMetadata;
public class SegmentReplicationSourceHandlerTests extends IndexShardTestCase {
import org.opensearch.common.settings.Settings;
            replica.routingEntry().allocationId().getId(),
        SegmentReplicationSourceHandler handler = new SegmentReplicationSourceHandler(
        chunkWriter = mock(FileChunkWriter.class);
    public void testCancelReplication() throws IOException, InterruptedException {
            1
import org.opensearch.common.util.CancellableThreads;
        });
        Assert.assertThrows(OpenSearchException.class, () -> { handler.sendFiles(getSegmentFilesRequest, mock(ActionListener.class)); });
        SegmentReplicationSourceHandler handler = new SegmentReplicationSourceHandler(
        replica = newShard(false, settings, new EngineBackedIndexerFactory(new NRTReplicationEngineFactory()));
import org.opensearch.indices.recovery.FileChunkWriter;
            primary,
            @Override
    private final DiscoveryNode localNode = new DiscoveryNode("local", buildNewFakeTransportAddress(), Version.CURRENT);
            1L,
    public void testSendFiles_emptyRequest() throws IOException {
    }
            latestReplicationCheckpoint
            }
            replicaDiscoveryNode,
package org.opensearch.indices.replication;
            }
    }
            replicaDiscoveryNode,
    }
            primary,
        });
 *
            localNode,
            5000,
