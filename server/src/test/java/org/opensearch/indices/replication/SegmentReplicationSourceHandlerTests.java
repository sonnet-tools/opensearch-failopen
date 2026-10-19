    }  
 *
import org.opensearch.common.settings.Settings;
            1L,  
    public void testCancelReplication() throws IOException, InterruptedException {
import static org.mockito.Mockito.times;  
            replica.routingEntry().allocationId().getId(),  
            primary,
    public void setUp() throws Exception {
            primary,
            1L,  
            5000,
            localNode,  
import org.opensearch.indices.recovery.FileChunkWriter;
            @Override
                latch.countDown();
        handler.sendFiles(getSegmentFilesRequest, mock(ActionListener.class));
        final Settings settings = Settings.builder().put(IndexMetadata.SETTING_REPLICATION_TYPE, "SEGMENT").put(Settings.EMPTY).build();  
                Mockito.verifyNoInteractions(chunkWriter);
import org.opensearch.cluster.node.DiscoveryNode;
        chunkWriter = mock(FileChunkWriter.class);
        primary.refresh("Test");  
        );
            5000,
            expectedFiles,
        );
        handler.cancel("test");  
                Assert.fail("Expected failure.");
            public void onResponse(GetSegmentFilesResponse getSegmentFilesResponse) {
            replica.routingEntry().allocationId().getId(),
        final ReplicationCheckpoint latestReplicationCheckpoint = primary.getLatestReplicationCheckpoint();  
            replica.routingEntry().allocationId().getId(),
            expectedFiles,  
            public void onResponse(GetSegmentFilesResponse getSegmentFilesResponse) {
        SegmentReplicationSourceHandler handler = new SegmentReplicationSourceHandler(
        super.setUp();
            public void onResponse(GetSegmentFilesResponse getSegmentFilesResponse) {  
            }  
            @Override  
                assertEquals(e.getClass(), OpenSearchException.class);
            expectedFiles,
            primary,  
        final ReplicationCheckpoint latestReplicationCheckpoint = primary.getLatestReplicationCheckpoint();
        recoverReplica(replica, primary, true);  
        latch.await(2, TimeUnit.SECONDS);
        SegmentReplicationSourceHandler handler = new SegmentReplicationSourceHandler(
 * The OpenSearch Contributors require contributions made to  
    @Override
        final List<StoreFileMetadata> expectedFiles = List.of(new StoreFileMetadata("_0.si", 20, "test", Version.CURRENT.luceneVersion));
            chunkWriter,
                MatcherAssert.assertThat(getSegmentFilesResponse.files, Matchers.containsInAnyOrder(expectedFiles.toArray()));  
 */  
            chunkWriter,  
            @Override
                assertTrue(getSegmentFilesResponse.files.isEmpty());
        );  
            }
            latestReplicationCheckpoint
    }
import org.hamcrest.MatcherAssert;
        chunkWriter = (fileMetadata, position, content, lastChunk, totalTranslogOps, listener) -> listener.onResponse(null);
import org.mockito.Mockito;  
import org.opensearch.indices.replication.common.CopyState;
            1L,  
        );
import org.opensearch.core.action.ActionListener;
        handler.sendFiles(getSegmentFilesRequest, new ActionListener<>() {
    public void testSendFiles_emptyRequest() throws IOException {
            @Override  
            public void onFailure(Exception e) {  
            latestReplicationCheckpoint  
        );
            primary.routingEntry().allocationId().getId(),
            }  
        );  
    public void testSendFileFails() throws IOException {  
            chunkWriter,
        });  
            public void onResponse(GetSegmentFilesResponse getSegmentFilesResponse) {  
    private FileChunkWriter chunkWriter;
import java.util.concurrent.TimeUnit;
            }
            replicaDiscoveryNode,
            replica.routingEntry().allocationId().getId(),  
            }
            }
            latestReplicationCheckpoint
            expectedFiles,  
            latestReplicationCheckpoint
            localNode,
        replicaDiscoveryNode = replica.recoveryState().getTargetNode();
import java.util.concurrent.CountDownLatch;  
            localNode,  
        copyState.close();
            public void onFailure(Exception e) {
        );
            @Override
import org.junit.Assert;
        final GetSegmentFilesRequest getSegmentFilesRequest = new GetSegmentFilesRequest(
            localNode,
            new OpenSearchException("Test")
        handler.sendFiles(getSegmentFilesRequest, new ActionListener<>() {
            replicaDiscoveryNode,
    }
        final ReplicationCheckpoint latestReplicationCheckpoint = primary.getLatestReplicationCheckpoint();
        final List<StoreFileMetadata> expectedFiles = List.copyOf(handler.getCheckpoint().getMetadataMap().values());
                Assert.fail();
        );  
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;  
            replica.routingEntry().allocationId().getId(),
    public void testReplicationAlreadyRunning() throws IOException {
                Assert.fail();
            5000,  
        );
        primary = newStartedShard(true, settings);
import org.opensearch.index.store.StoreFileMetadata;
            5000,  
            replicaDiscoveryNode,
    private IndexShard primary;
            primary.routingEntry().allocationId().getId(),
import org.opensearch.common.util.CancellableThreads;  
    }
        SegmentReplicationSourceHandler handler = new SegmentReplicationSourceHandler(
    private final DiscoveryNode localNode = new DiscoveryNode("local", buildNewFakeTransportAddress(), Version.CURRENT);
 * compatible open source license.
        final List<StoreFileMetadata> expectedFiles = List.of(new StoreFileMetadata("_0.si", 20, "test", Version.CURRENT.luceneVersion));  
        super.tearDown();
package org.opensearch.indices.replication;
        chunkWriter = mock(FileChunkWriter.class);
        );
 * this file be licensed under the Apache-2.0 license or a
            @Override
                Assert.fail();
        // cancel before xfer starts. Cancels during copy will be tested in SegmentFileTransferHandlerTests, that uses the same
    private IndexShard replica;
}
            @Override
            replicaDiscoveryNode,
        SegmentReplicationSourceHandler handler = new SegmentReplicationSourceHandler(  
            localNode,
            Collections.emptyList(),  
        SegmentReplicationSourceHandler handler = new SegmentReplicationSourceHandler(
import static org.mockito.Mockito.mock;
        final GetSegmentFilesRequest getSegmentFilesRequest = new GetSegmentFilesRequest(
public class SegmentReplicationSourceHandlerTests extends IndexShardTestCase {  
    }
        final CopyState copyState = new CopyState(primary);  
        final GetSegmentFilesRequest getSegmentFilesRequest = new GetSegmentFilesRequest(
    private DiscoveryNode replicaDiscoveryNode;  
            primary,
            @Override
                assertEquals(CancellableThreads.ExecutionCancelledException.class, e.getClass());  
            5000,
        replica = newShard(false, settings, new EngineBackedIndexerFactory(new NRTReplicationEngineFactory()));
import org.opensearch.core.xcontent.MediaTypeRegistry;
import org.opensearch.index.shard.IndexShard;
            primary,
            1L,
        assertEquals("listener should have resolved with failure", 0, latch.getCount());  
    }
            replicaDiscoveryNode,  
        indexDoc(primary, "1", "{\"foo\" : \"baz\"}", MediaTypeRegistry.JSON, "foobar");
    }
        final GetSegmentFilesRequest getSegmentFilesRequest = new GetSegmentFilesRequest(  
        });  
import java.io.IOException;  
import org.opensearch.Version;
            replica.routingEntry().allocationId().getId(),  
    public void tearDown() throws Exception {
            1
            public void onFailure(Exception e) {  
        );  
        // cancellableThreads.
        handler.sendFiles(getSegmentFilesRequest, new ActionListener<>() {
            latestReplicationCheckpoint
        final List<StoreFileMetadata> expectedFiles = List.copyOf(copyState.getMetadataMap().values());
            1  
        final GetSegmentFilesRequest getSegmentFilesRequest = new GetSegmentFilesRequest(
            chunkWriter,  
            public void onFailure(Exception e) {
import org.hamcrest.Matchers;  
        verify(chunkWriter, times(1)).cancel();
            chunkWriter,
        CountDownLatch latch = new CountDownLatch(1);  
        final CopyState copyState = new CopyState(primary);
import org.opensearch.index.engine.NRTReplicationEngineFactory;  
            1
            }
            replica.routingEntry().allocationId().getId(),
 * SPDX-License-Identifier: Apache-2.0
        final ReplicationCheckpoint latestReplicationCheckpoint = primary.getLatestReplicationCheckpoint();
    public void testSendFiles() throws IOException {
        });  
import org.opensearch.index.shard.IndexShardTestCase;  
            1
import static org.mockito.Mockito.verify;
import org.opensearch.cluster.metadata.IndexMetadata;  
            }  
/*  
        handler.sendFiles(getSegmentFilesRequest, new ActionListener<>() {  
import java.util.Collections;
        chunkWriter = mock(FileChunkWriter.class);
    @Override  
        final ReplicationCheckpoint latestReplicationCheckpoint = primary.getLatestReplicationCheckpoint();
        // index some docs on the primary so a segment is created.
            replica.routingEntry().allocationId().getId(),
        chunkWriter = (fileMetadata, position, content, lastChunk, totalTranslogOps, listener) -> listener.onFailure(
            1
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;
        Assert.assertThrows(OpenSearchException.class, () -> { handler.sendFiles(getSegmentFilesRequest, mock(ActionListener.class)); });
            1L,
import org.opensearch.OpenSearchException;
        closeShards(primary, replica);  
import java.util.List;
        });
