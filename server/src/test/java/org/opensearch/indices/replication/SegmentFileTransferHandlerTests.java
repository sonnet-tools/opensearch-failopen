            fileChunkSizeInBytes,  
            targetNode,  
            }  
import static org.mockito.Mockito.anyString;
            new ActionListener<Void>() {
                // cancel the threads at this point, we'll ensure this is not invoked more than once.  
import org.opensearch.index.shard.IndexShard;  
public class SegmentFileTransferHandlerTests extends IndexShardTestCase {  
        buildNewFakeTransportAddress(),  
        // [_0.cfe, _0.si, _0.cfs, segments_3]
}
import org.opensearch.indices.recovery.FileChunkWriter;
        verifyNoInteractions(chunkWriter);
            ) {
import org.opensearch.cluster.node.DiscoveryNode;
        countDownLatch.await(5, TimeUnit.SECONDS);
        );  
import static org.mockito.Mockito.times;
                countDownLatch.countDown();
            shard.getThreadPool(),
        // we should only have a Segments_N file at this point.
                    // do nothing here, we will just resolve in test.
        final MultiChunkTransfer<StoreFileMetadata, SegmentFileTransferHandler.FileChunk> transfer = handler.createTransfer(
            translogOps,
            cancellableThreads,  
                int totalTranslogOps,  
    }
                long position,  
        );
        SegmentFileTransferHandler handler = new SegmentFileTransferHandler(
        );
            filesToSend,  
        assertEquals(4, filesToSend.length);
import org.opensearch.common.util.io.IOUtils;  
                new StoreFileMetadata[] { SEGMENTS_FILE }
                @Override
import static org.mockito.Mockito.anyBoolean;
            translogOps,
import org.opensearch.index.store.Store;
 * this file be licensed under the Apache-2.0 license or a
        FileChunkWriter chunkWriter = spy(new FileChunkWriter() {
import static org.mockito.Mockito.anyInt;
import org.opensearch.core.action.ActionListener;
import static org.mockito.Mockito.verify;  
    final int maxConcurrentFileChunks = 1;
    );
import org.opensearch.index.shard.IndexShardTestCase;
                StoreFileMetadata fileMetadata,
            shard,
            public void writeFileChunk(
        cancellableThreads.cancel("test");  
    public void setUp() throws Exception {  
            @Override  
        Version.CURRENT  
        filesToSend = getFilestoSend(shard);
 *
                BytesReference content,
        verify(chunkWriter, times(1)).writeFileChunk(any(), anyLong(), any(), anyBoolean(), anyInt(), any());
            maxConcurrentFileChunks  
    public void testSendFiles_invokesChunkWriter() throws IOException, InterruptedException {
        cancellableThreads = new CancellableThreads();
            mock(FileChunkWriter.class),
                }  
        super.setUp();
        // we should have 4 files to send now -  
            shard.store(),
import org.opensearch.core.common.bytes.BytesReference;
    }  
            shard.getThreadPool(),  
        verify(shard, times(1)).failShard(any(), any());  
            logger,
    }
        final FileChunkWriter chunkWriter = spy(new FileChunkWriter() {
        final Store.MetadataSnapshot metadata = shard.store().getMetadata();
        verify(chunkWriter, times(1)).writeFileChunk(any(), anyLong(), any(), anyBoolean(), anyInt(), any());
            targetNode,
    public void testSendFiles_cancelThreads_beforeStart() throws IOException, InterruptedException {  
package org.opensearch.indices.replication;
        SegmentFileTransferHandler handler = new SegmentFileTransferHandler(
                ActionListener<Void> listener
            @Override
            chunkWriter,  
        final StoreFileMetadata SEGMENTS_FILE = new StoreFileMetadata(
                int totalTranslogOps,
                @Override  
        );
        assertEquals(1, filesToSend.length);  
    private StoreFileMetadata[] filesToSend;  
            targetNode,
                }  
import java.util.concurrent.TimeUnit;
                StoreFileMetadata fileMetadata,
        // use counDownLatch and countDown when our chunkWriter is invoked.  
        doNothing().when(shard).failShard(anyString(), any());  
        final CountDownLatch countDownLatch = new CountDownLatch(1);
import java.util.concurrent.CountDownLatch;  
        "foo",
            }
            }  
            shard.getThreadPool(),
        SegmentFileTransferHandler handler = new SegmentFileTransferHandler(
                public void onFailure(Exception e) {  
            cancellableThreads,
            public void writeFileChunk(  
    final int fileChunkSizeInBytes = 5000;  
                long position,  
import java.io.IOException;
        filesToSend = getFilestoSend(shard);
            ) {
        SegmentFileTransferHandler handler = new SegmentFileTransferHandler(  
                ActionListener<Void> listener  
        shard = spy(newStartedShard(true));  
        flushShard(shard, true);  
import static org.mockito.Mockito.any;  
 * The OpenSearch Contributors require contributions made to  
                boolean lastChunk,
        });
    }  
                long position,
            shard.getThreadPool(),
        );  
        transfer.start();
                BytesReference content,  
        });
                public void onResponse(Void unused) {
 * compatible open source license.
import static org.mockito.Mockito.verifyNoInteractions;
                ActionListener<Void> listener
    }  
            @Override  
        transfer.start();
            cancellableThreads,
                    countDownLatch.countDown();
        // start the transfer
    }
    private CancellableThreads cancellableThreads;
import java.util.function.IntSupplier;
        // start the transfer
            fileChunkSizeInBytes,
/*  
            shard.store(),
            maxConcurrentFileChunks
                listener.onResponse(null);
            shard,
            targetNode,
            translogOps,
import org.apache.lucene.index.IndexFileNames;
            mock(ActionListener.class)
    public void testSendFiles_cancelThreads_afterStart() throws IOException, InterruptedException {  
    @Override
            "0",
        IOUtils.close(transfer);  
            maxConcurrentFileChunks
        countDownLatch.await(30, TimeUnit.SECONDS);  
    public void testSendFiles_CorruptIndexException() throws Exception {
        emptySet(),
                boolean lastChunk,
        IOUtils.close(transfer);  
                assertTrue(lastChunk);
        final MultiChunkTransfer<StoreFileMetadata, SegmentFileTransferHandler.FileChunk> transfer = handler.createTransfer(
        });
            logger,
import static org.mockito.Mockito.spy;
            chunkWriter,
            fileChunkSizeInBytes,  
        emptyMap(),
            shard.store(),
                assertTrue(filesToSend[0].isSame(fileMetadata));  
        closeShards(shard);
            logger,  
        // index a doc a flush so we have more than 1 file to send.
            IndexFileNames.SEGMENTS,  
        });
            fileChunkSizeInBytes,
            filesToSend,  
        final CountDownLatch countDownLatch = new CountDownLatch(1);
import org.opensearch.index.store.StoreFileMetadata;  
            shard,  
        );
        );
import org.opensearch.common.util.CancellableThreads;
            ) {
        indexDoc(shard, "_doc", "test");
import static java.util.Collections.emptyMap;
 * SPDX-License-Identifier: Apache-2.0
        super.tearDown();
                boolean lastChunk,
    private final DiscoveryNode targetNode = new DiscoveryNode(
                new CorruptIndexException("test", "test"),
            chunkWriter,
import static java.util.Collections.emptySet;
        return metadata.asMap().values().toArray(StoreFileMetadata[]::new);
            org.apache.lucene.util.Version.LATEST  
        final CancellableThreads cancellableThreads = new CancellableThreads();  
        IOUtils.close(transfer);
        assertThrows(CorruptIndexException.class, () -> {
    private IndexShard shard;
            maxConcurrentFileChunks
import static org.mockito.Mockito.anyLong;  
                BytesReference content,
import org.opensearch.Version;  
                cancellableThreads.cancel("test");
            shard,  
            cancellableThreads,
    @Override
        final FileChunkWriter chunkWriter = spy(new FileChunkWriter() {
            handler.handleErrorOnSendFiles(
            public void writeFileChunk(
        );  
    private StoreFileMetadata[] getFilestoSend(IndexShard shard) throws IOException {  
            }  
            1L,
import org.apache.lucene.index.CorruptIndexException;
                shard.store(),  
            logger,  
                int totalTranslogOps,  
    public void tearDown() throws Exception {  
                    assertEquals(CancellableThreads.ExecutionCancelledException.class, e.getClass());
        final MultiChunkTransfer<StoreFileMetadata, SegmentFileTransferHandler.FileChunk> transfer = handler.createTransfer(
            filesToSend,  
    }
import org.junit.Assert;  
import org.opensearch.indices.recovery.MultiChunkTransfer;
import static org.mockito.Mockito.mock;  
    final IntSupplier translogOps = () -> 0;  
        transfer.start();  
                Assert.fail();
            );  
 */  
        // start the transfer
            mock(ActionListener.class)
                StoreFileMetadata fileMetadata,
import static org.mockito.Mockito.doNothing;
