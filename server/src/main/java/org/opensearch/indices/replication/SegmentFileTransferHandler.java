                } else {
    private final CancellableThreads cancellableThreads;
        throw e;
     * Callers are responsible for starting the transfer and closing the resource.
        this.chunkWriter = chunkWriter;
                offset += bytesRead;
                        public void close() throws IOException {
                    lastChunk,
     */
                if (bytesRead == -1) {
        DiscoveryNode targetNode,
        ThreadPool threadPool,
    }
                    md,
import org.opensearch.transport.Transports;
 */
    /**
            @Override
        this.logger = logger;
/*
    public SegmentFileTransferHandler(
                    new BytesArray(buffer, 0, bytesRead),
            protected FileChunk nextChunkRequest(StoreFileMetadata md) throws IOException {
            @Override
                        try (InputStreamIndexInput in = new InputStreamIndexInput(indexInput, md.length())) {
                    }
                // Segments* files require IOContext.READONCE
                    request.content,
                if (md.name().startsWith(IndexFileNames.SEGMENTS) == false) {
import java.util.Deque;
import org.apache.logging.log4j.Logger;
        CancellableThreads cancellableThreads,
    private final FileChunkWriter chunkWriter;
            }
import org.apache.lucene.store.IOContext;
                    "File corruption occurred on recovery but checksums are ok",
            @Override
            this.md = md;
                    shard.failShard("error sending files", corruptIndexException);
                offset = 0;
        public boolean lastChunk() {
        return new MultiChunkTransfer<>(logger, threadPool.getThreadContext(), listener, maxConcurrentFileChunks, Arrays.asList(files)) {
                    request.md,
                cancellableThreads.checkForCancel();
/**
    private final IndexShard shard;
        int fileChunkSizeInBytes,
                throw localException;
        this.chunkSizeInBytes = fileChunkSizeInBytes;
            return lastChunk;
     * @param listener {@link ActionListener}
     */
                    () -> buffers.addFirst(buffer)
                remoteException.addSuppressed(e);
                // if we don't have a currentInput by now open once to create the chunk.
            private byte[] acquireBuffer() {
        Logger logger,
            this.lastChunk = lastChunk;
import java.util.function.IntSupplier;
                );
import org.opensearch.core.action.ActionListener;
            @Override
        Store store,
import org.opensearch.index.store.StoreFileMetadata;
import org.opensearch.cluster.node.DiscoveryNode;
}
import org.opensearch.transport.RemoteTransportException;
                cancellableThreads.checkForCancel();
            long offset = 0;
                    () -> new ParameterizedMessage(
    public MultiChunkTransfer<StoreFileMetadata, FileChunk> createTransfer(
package org.opensearch.indices.replication;
        final BytesReference content;
 * SegmentFileSender handles building and starting a {@link MultiChunkTransfer} to orchestrate sending chunks to a given targetNode.
                        localException = corruptIndexException;
            protected void executeChunkRequest(FileChunk request, ActionListener<Void> listener1) {
                // https://github.com/apache/lucene/blob/b2d3a2b37e00f19a74949097736be8fd64745f61/lucene/test-framework/src/java/org/apache/lucene/tests/store/MockDirectoryWrapper.java#L817
                final byte[] buffer = buffers.pollFirst();
                }
                chunkWriter.writeFileChunk(
    ) {
import org.opensearch.ExceptionsHelper;
import org.apache.lucene.store.IndexInput;
            }
        this.cancellableThreads = cancellableThreads;
        final Releasable onClose;
     * @param files {@link StoreFileMetadata[]}
        IntSupplier translogOps,
            }
        ActionListener<Void> listener
            }
                assert Transports.assertNotTransportThread("read file chunk");
                        }
                        "{} Remote file corruption on node {}, recovering {}. local checksum OK",
            final Deque<byte[]> buffers = new ConcurrentLinkedDeque<>();
            for (StoreFileMetadata md : mds) {
                    request.position,
                    throw new CorruptIndexException("file truncated; length=" + md.length() + " offset=" + offset, md.name());
                    if (localException == null) {
        // if the target is on an old version, it won't be able to handle out-of-order file chunks.
    private final Logger logger;
        }
                    logger.warn("{} Corrupted file detected {} checksum mismatch", shard.shardId(), md);
                if (currentInput == null) {
     * Returns a closeable {@link MultiChunkTransfer} to initiate sending a list of files.
import org.opensearch.core.common.bytes.BytesReference;
            public void close() throws IOException {
                IOUtils.close(currentInput, () -> currentInput = null);
                    ),
            protected void handleError(StoreFileMetadata md, Exception e) throws Exception {
            if (localException != null) {
        @Override
import org.opensearch.index.store.Store;
 * compatible open source license.
        FileChunkWriter chunkWriter,
    private final DiscoveryNode targetNode;
        };
 */
        FileChunk(StoreFileMetadata md, BytesReference content, long position, boolean lastChunk, Releasable onClose) {
import org.apache.logging.log4j.message.ParameterizedMessage;
            @Override
 * The OpenSearch Contributors require contributions made to
        }
    private final int chunkSizeInBytes;
import org.opensearch.index.shard.IndexShard;
                }
            private int readBytes(StoreFileMetadata md, byte[] buffer) throws IOException {
 * // TODO: make this package-private after combining recovery and replication into single package.
            }
    private final int maxConcurrentFileChunks;
                if (store.checkIntegrityNoException(md) == false) { // we are corrupted on the primary -- fail!
                        @Override
        @Override
                    corruptIndexException
                            return in.read(buffer);
                logger.warn(
 *
                final int bytesRead = readBytes(md, buffer);
 * @opensearch.internal
 * this file be licensed under the Apache-2.0 license or a
        IndexShard shard,
                }
        final boolean lastChunk;
        final long position;
import java.util.Comparator;
        this.targetNode = targetNode;
    public void handleErrorOnSendFiles(Store store, Exception e, StoreFileMetadata[] mds) throws Exception {
     * A file chunk from the recovery source
        this.threadPool = threadPool;
                return chunk;
     *
    }
                );
                        mds
            onClose.close();
        this.maxConcurrentFileChunks = maxConcurrentFileChunks;
 *
import org.opensearch.common.lease.Releasable;
import org.opensearch.core.common.bytes.BytesArray;
    ) {
    public static final class FileChunk implements MultiChunkTransfer.ChunkRequest, Releasable {
            }
 * SPDX-License-Identifier: Apache-2.0
    /**
            Exception localException = null;
    private final ThreadPool threadPool;
     * @param store {@link Store}
                    try (IndexInput indexInput = store.directory().openInput(md.name(), IOContext.READONCE)) {
     * @return {@link MultiChunkTransfer}
                    currentInput = new InputStreamIndexInput(indexInput, md.length()) {
                    return currentInput.read(buffer);
import org.opensearch.common.util.CancellableThreads;
                    offset,
            this.content = content;
                    request.lastChunk,
import org.opensearch.indices.recovery.FileChunkWriter;
        StoreFileMetadata[] files,
        }
                    translogOps.getAsInt(),
        }
     * @param translogOps {@link IntSupplier}
                // With Lucene9_12 a READONCE context will confine the underlying IndexInput (MemorySegmentIndexInput) to a single thread.
        final StoreFileMetadata md;
                IOUtils.close(currentInput, () -> currentInput = null);
                // Open all files other than Segments* using IOContext.READ.
import org.opensearch.indices.recovery.MultiChunkTransfer;
import java.io.IOException;
            }
            protected void onNewResource(StoreFileMetadata md) throws IOException {
                handleErrorOnSendFiles(store, e, new StoreFileMetadata[] { md });
                return new byte[chunkSizeInBytes];
                    ActionListener.runBefore(listener1, request::close)
                    return buffer;
                        shard.shardId(),
                    final IndexInput indexInput = store.directory().openInput(md.name(), IOContext.DEFAULT);
    }
            } else { // corruption has happened on the way to replica
                            in.skip(offset);
            }
                RemoteTransportException remoteException = new RemoteTransportException(
                    null
import org.apache.lucene.index.CorruptIndexException;
                }
        assert Transports.assertNotTransportThread(this + "[handle error on send/clean files]");
                cancellableThreads.checkForCancel();
                logger.debug("checking integrity for file {} after remove corruption exception", md);
            volatile InputStreamIndexInput currentInput = null;
                        }
import org.opensearch.threadpool.ThreadPool;
                );
import org.opensearch.common.util.io.IOUtils;
        ArrayUtil.timSort(files, Comparator.comparingLong(StoreFileMetadata::length)); // send smallest first
 * This class delegates to a {@link FileChunkWriter} to handle the transport of chunks.
            this.position = position;
                    };
            }
                );
import org.apache.lucene.util.ArrayUtil;
                final boolean lastChunk = offset + bytesRead == md.length();
                final FileChunk chunk = new FileChunk(
                        targetNode,
                    }
import org.opensearch.common.lucene.store.InputStreamIndexInput;
        final IOException corruptIndexException = ExceptionsHelper.unwrapCorruption(e);
import org.apache.lucene.index.IndexFileNames;
     * @opensearch.internal
        int maxConcurrentFileChunks
        public void close() {
                }
public final class SegmentFileTransferHandler {
    }
import java.util.concurrent.ConcurrentLinkedDeque;
                throw remoteException;
                if (buffer != null) {
                            IOUtils.close(indexInput, super::close); // InputStreamIndexInput's close is a noop
                final byte[] buffer = acquireBuffer();
import java.util.Arrays;
        if (corruptIndexException != null) {
        this.shard = shard;
            this.onClose = onClose;
