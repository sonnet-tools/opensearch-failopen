        this.maxConcurrentFileChunks = maxConcurrentFileChunks;  
            }
/*  
import java.util.Arrays;  
                logger.warn(
                cancellableThreads.checkForCancel();
            if (localException != null) {
                            return in.read(buffer);
        CancellableThreads cancellableThreads,  
            onClose.close();
     *  
import org.opensearch.common.lucene.store.InputStreamIndexInput;
}
            final Deque<byte[]> buffers = new ConcurrentLinkedDeque<>();  
                final boolean lastChunk = offset + bytesRead == md.length();
                    return buffer;
    private final int maxConcurrentFileChunks;
                throw localException;  
 * SegmentFileSender handles building and starting a {@link MultiChunkTransfer} to orchestrate sending chunks to a given targetNode.
import org.opensearch.cluster.node.DiscoveryNode;  
            this.onClose = onClose;  
    }  
    public MultiChunkTransfer<StoreFileMetadata, FileChunk> createTransfer(  
        @Override
    private final Logger logger;  
    /**
        this.cancellableThreads = cancellableThreads;  
                    currentInput = new InputStreamIndexInput(indexInput, md.length()) {
                }  
                cancellableThreads.checkForCancel();
    ) {
        this.threadPool = threadPool;
        @Override  
            }
            this.content = content;  
                if (md.name().startsWith(IndexFileNames.SEGMENTS) == false) {  
import org.opensearch.index.shard.IndexShard;
import org.apache.lucene.store.IndexInput;  
            }
import org.opensearch.threadpool.ThreadPool;
                    ActionListener.runBefore(listener1, request::close)  
        if (corruptIndexException != null) {
import org.apache.lucene.index.IndexFileNames;
                assert Transports.assertNotTransportThread("read file chunk");  
        }  
                IOUtils.close(currentInput, () -> currentInput = null);
            @Override
            }
 */  
     * @param store {@link Store}  
    private final IndexShard shard;
                        try (InputStreamIndexInput in = new InputStreamIndexInput(indexInput, md.length())) {
            protected void onNewResource(StoreFileMetadata md) throws IOException {
    public static final class FileChunk implements MultiChunkTransfer.ChunkRequest, Releasable {  
        ActionListener<Void> listener
    }
public final class SegmentFileTransferHandler {
                final FileChunk chunk = new FileChunk(
 *  
import org.opensearch.common.util.io.IOUtils;
                );
                    () -> new ParameterizedMessage(
                    final IndexInput indexInput = store.directory().openInput(md.name(), IOContext.DEFAULT);
    }
                    if (localException == null) {
            }
import org.opensearch.index.store.Store;  
                            in.skip(offset);  
                RemoteTransportException remoteException = new RemoteTransportException(
                );
    private final FileChunkWriter chunkWriter;
                        public void close() throws IOException {
        final boolean lastChunk;
     * Returns a closeable {@link MultiChunkTransfer} to initiate sending a list of files.
 * // TODO: make this package-private after combining recovery and replication into single package.
        // if the target is on an old version, it won't be able to handle out-of-order file chunks.
            long offset = 0;
                if (bytesRead == -1) {
 * The OpenSearch Contributors require contributions made to  
 * @opensearch.internal
                } else {
            this.lastChunk = lastChunk;
import org.opensearch.ExceptionsHelper;
import org.opensearch.core.action.ActionListener;
        this.targetNode = targetNode;
            }  
import org.opensearch.core.common.bytes.BytesReference;
        assert Transports.assertNotTransportThread(this + "[handle error on send/clean files]");  
/**  
package org.opensearch.indices.replication;
        final BytesReference content;
import java.io.IOException;
                chunkWriter.writeFileChunk(  
                return new byte[chunkSizeInBytes];
                }
            @Override  
                        }
            private byte[] acquireBuffer() {
                        shard.shardId(),
                        localException = corruptIndexException;  
            this.md = md;
import org.opensearch.common.util.CancellableThreads;  
        final long position;  
                logger.debug("checking integrity for file {} after remove corruption exception", md);
            private int readBytes(StoreFileMetadata md, byte[] buffer) throws IOException {
    public SegmentFileTransferHandler(  
        int fileChunkSizeInBytes,
                    md,  
import org.apache.logging.log4j.message.ParameterizedMessage;
                handleErrorOnSendFiles(store, e, new StoreFileMetadata[] { md });  
            protected FileChunk nextChunkRequest(StoreFileMetadata md) throws IOException {
                    corruptIndexException
        this.shard = shard;
                    request.content,  
                cancellableThreads.checkForCancel();
                    offset,
import org.apache.lucene.store.IOContext;
                }  
import org.apache.lucene.index.CorruptIndexException;  
        }
                final byte[] buffer = acquireBuffer();
            protected void executeChunkRequest(FileChunk request, ActionListener<Void> listener1) {
    private final CancellableThreads cancellableThreads;
import org.opensearch.core.common.bytes.BytesArray;  
                        mds  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.store.StoreFileMetadata;
        this.logger = logger;
                }  
                    ),
import org.apache.logging.log4j.Logger;
        FileChunk(StoreFileMetadata md, BytesReference content, long position, boolean lastChunk, Releasable onClose) {
        ArrayUtil.timSort(files, Comparator.comparingLong(StoreFileMetadata::length)); // send smallest first  
    /**  
                // With Lucene9_12 a READONCE context will confine the underlying IndexInput (MemorySegmentIndexInput) to a single thread.  
                    request.position,
import java.util.Deque;
            protected void handleError(StoreFileMetadata md, Exception e) throws Exception {
        public boolean lastChunk() {
        final Releasable onClose;
                remoteException.addSuppressed(e);  
                    request.md,
import org.opensearch.indices.recovery.MultiChunkTransfer;  
                        "{} Remote file corruption on node {}, recovering {}. local checksum OK",  
        Store store,
                    }
                final byte[] buffer = buffers.pollFirst();  
 * This class delegates to a {@link FileChunkWriter} to handle the transport of chunks.
                            IOUtils.close(indexInput, super::close); // InputStreamIndexInput's close is a noop
            for (StoreFileMetadata md : mds) {  
        public void close() {  
import org.apache.lucene.util.ArrayUtil;
                    return currentInput.read(buffer);
        int maxConcurrentFileChunks
                offset = 0;  
            @Override  
import org.opensearch.transport.RemoteTransportException;
                    request.lastChunk,
                        }  
        IntSupplier translogOps,  
     */
                    };
import org.opensearch.common.lease.Releasable;
import java.util.function.IntSupplier;
     * @param translogOps {@link IntSupplier}
                    try (IndexInput indexInput = store.directory().openInput(md.name(), IOContext.READONCE)) {
                    "File corruption occurred on recovery but checksums are ok",  
    private final DiscoveryNode targetNode;  
 * SPDX-License-Identifier: Apache-2.0
                if (currentInput == null) {  
        final StoreFileMetadata md;
import java.util.Comparator;
            @Override
            volatile InputStreamIndexInput currentInput = null;
                );  
     * @param listener {@link ActionListener}  
import java.util.concurrent.ConcurrentLinkedDeque;  
            @Override
        ThreadPool threadPool,
        throw e;
        }
                    new BytesArray(buffer, 0, bytesRead),
 *
                    shard.failShard("error sending files", corruptIndexException);
     */
        };
        StoreFileMetadata[] files,
                final int bytesRead = readBytes(md, buffer);  
     * @param files {@link StoreFileMetadata[]}
            this.position = position;
            }  
                if (buffer != null) {
        final IOException corruptIndexException = ExceptionsHelper.unwrapCorruption(e);
                    }  
                // Open all files other than Segments* using IOContext.READ.
        FileChunkWriter chunkWriter,  
    public void handleErrorOnSendFiles(Store store, Exception e, StoreFileMetadata[] mds) throws Exception {
        this.chunkWriter = chunkWriter;  
            return lastChunk;
 */  
    private final ThreadPool threadPool;  
                if (store.checkIntegrityNoException(md) == false) { // we are corrupted on the primary -- fail!  
        IndexShard shard,
                return chunk;
                // if we don't have a currentInput by now open once to create the chunk.
    ) {  
        }  
                    throw new CorruptIndexException("file truncated; length=" + md.length() + " offset=" + offset, md.name());
        this.chunkSizeInBytes = fileChunkSizeInBytes;
                    null
        DiscoveryNode targetNode,
                // https://github.com/apache/lucene/blob/b2d3a2b37e00f19a74949097736be8fd64745f61/lucene/test-framework/src/java/org/apache/lucene/tests/store/MockDirectoryWrapper.java#L817
            } else { // corruption has happened on the way to replica
                    translogOps.getAsInt(),
     * @return {@link MultiChunkTransfer}
                    () -> buffers.addFirst(buffer)
    private final int chunkSizeInBytes;
                IOUtils.close(currentInput, () -> currentInput = null);
                offset += bytesRead;  
            public void close() throws IOException {
                throw remoteException;
                }  
                        targetNode,
                    lastChunk,  
                        @Override  
            }
import org.opensearch.transport.Transports;  
     * Callers are responsible for starting the transfer and closing the resource.
 * compatible open source license.
     * @opensearch.internal
            }
                );
        return new MultiChunkTransfer<>(logger, threadPool.getThreadContext(), listener, maxConcurrentFileChunks, Arrays.asList(files)) {
        Logger logger,
                // Segments* files require IOContext.READONCE
     * A file chunk from the recovery source
                    logger.warn("{} Corrupted file detected {} checksum mismatch", shard.shardId(), md);
            Exception localException = null;
    }
import org.opensearch.indices.recovery.FileChunkWriter;
