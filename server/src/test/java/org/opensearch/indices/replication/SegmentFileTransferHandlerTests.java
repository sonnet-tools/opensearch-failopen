    private final DiscoveryNode targetNode = new DiscoveryNode(
            shard,
            ) {
        // start the transfer
            ) {
                BytesReference content,
import static org.mockito.Mockito.doNothing;
                int totalTranslogOps,
        shard = spy(newStartedShard(true));
            filesToSend,
            targetNode,
    final IntSupplier translogOps = () -> 0;
import org.opensearch.Version;
            chunkWriter,
        // start the transfer
import java.util.function.IntSupplier;
import org.apache.lucene.index.CorruptIndexException;
                ActionListener<Void> listener
import org.opensearch.indices.recovery.FileChunkWriter;
            IndexFileNames.SEGMENTS,
                public void onFailure(Exception e) {
            shard,
            maxConcurrentFileChunks
                    countDownLatch.countDown();
        super.tearDown();
                Assert.fail();
            fileChunkSizeInBytes,
        SegmentFileTransferHandler handler = new SegmentFileTransferHandler(
            translogOps,
                boolean lastChunk,
    final int maxConcurrentFileChunks = 1;
            targetNode,
        indexDoc(shard, "_doc", "test");
        final CancellableThreads cancellableThreads = new CancellableThreads();
                new StoreFileMetadata[] { SEGMENTS_FILE }
            logger,
                assertTrue(filesToSend[0].isSame(fileMetadata));
            new ActionListener<Void>() {
    }
        countDownLatch.await(30, TimeUnit.SECONDS);
            chunkWriter,
                cancellableThreads.cancel("test");
            cancellableThreads,
        );
        IOUtils.close(transfer);
        );
                int totalTranslogOps,
package org.opensearch.indices.replication;
        );
            ) {
    public void setUp() throws Exception {
        filesToSend = getFilestoSend(shard);
        super.setUp();
        });
import static org.mockito.Mockito.anyBoolean;
 * compatible open source license.
            shard.getThreadPool(),
        // start the transfer
            maxConcurrentFileChunks
            }
import java.util.concurrent.TimeUnit;
            org.apache.lucene.util.Version.LATEST
            public void writeFileChunk(
                StoreFileMetadata fileMetadata,
        return metadata.asMap().values().toArray(StoreFileMetadata[]::new);
            fileChunkSizeInBytes,
            mock(FileChunkWriter.class),
    public void testSendFiles_CorruptIndexException() throws Exception {
            cancellableThreads,
import static org.mockito.Mockito.verify;
        );
    }
                // cancel the threads at this point, we'll ensure this is not invoked more than once.
                assertTrue(lastChunk);
            shard.store(),
        countDownLatch.await(5, TimeUnit.SECONDS);
            fileChunkSizeInBytes,
        transfer.start();
        Version.CURRENT
                long position,
        });
        emptySet(),
                ActionListener<Void> listener
            shard.getThreadPool(),
                long position,
            public void writeFileChunk(
        SegmentFileTransferHandler handler = new SegmentFileTransferHandler(
        buildNewFakeTransportAddress(),
                StoreFileMetadata fileMetadata,
            @Override
            filesToSend,
        });
import org.junit.Assert;
        final FileChunkWriter chunkWriter = spy(new FileChunkWriter() {
    private CancellableThreads cancellableThreads;
            shard,
        "foo",
            shard.getThreadPool(),
            logger,
                shard.store(),
import static org.mockito.Mockito.anyLong;
                ActionListener<Void> listener
        final CountDownLatch countDownLatch = new CountDownLatch(1);
                }
            filesToSend,
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        cancellableThreads = new CancellableThreads();
            mock(ActionListener.class)
        FileChunkWriter chunkWriter = spy(new FileChunkWriter() {
            );
public class SegmentFileTransferHandlerTests extends IndexShardTestCase {
        closeShards(shard);
    public void tearDown() throws Exception {
                public void onResponse(Void unused) {
        final MultiChunkTransfer<StoreFileMetadata, SegmentFileTransferHandler.FileChunk> transfer = handler.createTransfer(
        IOUtils.close(transfer);
        final FileChunkWriter chunkWriter = spy(new FileChunkWriter() {
        );
import org.opensearch.index.store.Store;
import static org.mockito.Mockito.any;
import org.opensearch.index.shard.IndexShard;
            shard.getThreadPool(),
import org.opensearch.common.util.CancellableThreads;
        final MultiChunkTransfer<StoreFileMetadata, SegmentFileTransferHandler.FileChunk> transfer = handler.createTransfer(
                    assertEquals(CancellableThreads.ExecutionCancelledException.class, e.getClass());
/*
import org.opensearch.common.util.io.IOUtils;
            shard.store(),
import static java.util.Collections.emptySet;
        verifyNoInteractions(chunkWriter);
                boolean lastChunk,
            targetNode,
        doNothing().when(shard).failShard(anyString(), any());
            maxConcurrentFileChunks
        assertEquals(4, filesToSend.length);
 * SPDX-License-Identifier: Apache-2.0
    private StoreFileMetadata[] filesToSend;
import static org.mockito.Mockito.anyInt;
            logger,
        assertEquals(1, filesToSend.length);
        flushShard(shard, true);
                    // do nothing here, we will just resolve in test.
                new CorruptIndexException("test", "test"),
        );
import org.opensearch.core.common.bytes.BytesReference;
            cancellableThreads,
            fileChunkSizeInBytes,
        SegmentFileTransferHandler handler = new SegmentFileTransferHandler(
import org.opensearch.cluster.node.DiscoveryNode;
import java.io.IOException;
        });
import static org.mockito.Mockito.verifyNoInteractions;
                int totalTranslogOps,
        transfer.start();
import java.util.concurrent.CountDownLatch;
                BytesReference content,
            translogOps,
            maxConcurrentFileChunks
        final MultiChunkTransfer<StoreFileMetadata, SegmentFileTransferHandler.FileChunk> transfer = handler.createTransfer(
            mock(ActionListener.class)
    public void testSendFiles_invokesChunkWriter() throws IOException, InterruptedException {
            @Override
    );
        filesToSend = getFilestoSend(shard);
        transfer.start();
            shard.store(),
    }
        // we should only have a Segments_N file at this point.
    @Override
                }
    private StoreFileMetadata[] getFilestoSend(IndexShard shard) throws IOException {
            1L,
            }
            chunkWriter,
import org.opensearch.index.store.StoreFileMetadata;
import static org.mockito.Mockito.spy;
    public void testSendFiles_cancelThreads_afterStart() throws IOException, InterruptedException {
import static org.mockito.Mockito.anyString;
    final int fileChunkSizeInBytes = 5000;
 *
                boolean lastChunk,
            }
        verify(chunkWriter, times(1)).writeFileChunk(any(), anyLong(), any(), anyBoolean(), anyInt(), any());
        // use counDownLatch and countDown when our chunkWriter is invoked.
        );
 */
    @Override
                StoreFileMetadata fileMetadata,
                countDownLatch.countDown();
            translogOps,
    }
        verify(shard, times(1)).failShard(any(), any());
    }
        // index a doc a flush so we have more than 1 file to send.
 * The OpenSearch Contributors require contributions made to
        final Store.MetadataSnapshot metadata = shard.store().getMetadata();
            targetNode,
        );
        // [_0.cfe, _0.si, _0.cfs, segments_3]
import org.opensearch.indices.recovery.MultiChunkTransfer;
 * this file be licensed under the Apache-2.0 license or a
                listener.onResponse(null);
                BytesReference content,
            shard,
import org.opensearch.core.action.ActionListener;
                @Override
        IOUtils.close(transfer);
import org.opensearch.index.shard.IndexShardTestCase;
        emptyMap(),
    }
        SegmentFileTransferHandler handler = new SegmentFileTransferHandler(
import org.apache.lucene.index.IndexFileNames;
            public void writeFileChunk(
import static java.util.Collections.emptyMap;
            cancellableThreads,
        // we should have 4 files to send now -
        verify(chunkWriter, times(1)).writeFileChunk(any(), anyLong(), any(), anyBoolean(), anyInt(), any());
            @Override
    }
                @Override
                long position,
    private IndexShard shard;
import static org.mockito.Mockito.times;
            "0",
        cancellableThreads.cancel("test");
            logger,
}
            }
        assertThrows(CorruptIndexException.class, () -> {
import static org.mockito.Mockito.mock;
            handler.handleErrorOnSendFiles(
        final StoreFileMetadata SEGMENTS_FILE = new StoreFileMetadata(
    public void testSendFiles_cancelThreads_beforeStart() throws IOException, InterruptedException {
