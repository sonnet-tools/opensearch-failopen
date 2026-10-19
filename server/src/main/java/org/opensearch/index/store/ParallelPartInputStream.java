        @Override  
 * recovery statistics wrappers, checksum verification on the {@code IndexOutput} side and any  
            }  
                openNextPart();
        }
 * no-op. When no permits are available the stream degrades gracefully to a plain sequential  
            try {  
        }
    }  
    public void close() throws IOException {  
     * A single read-ahead part. Holds exactly one permit from the time it is scheduled until
 *
                }  
                finishCurrentPart();
        public void run() {
        }  
                // Fail rather than spin on a non-conforming stream.  
        }
    private final UnaryOperator<InputStream> rateLimiter;
                // InputStream#read(byte[], int, int) may only return 0 when len == 0, and toRead >= 1 here.
        if (len == 0) {
package org.opensearch.index.store;
            if (owner.compareAndSet(Owner.NONE, Owner.PREFETCHER) == false) {
    private final long fileLength;
            final InputStream toClose = current;  
        Prefetch(int partIndex) {
        IOException failure = null;
                throw new EOFException(  
                        + blobName
     * Schedules prefetches for the parts following the one being read, in increasing order,
                        + " bytes remaining"
     */
                } else {  
        return Math.min(partSize, fileLength - partPosition(partIndex));  
            }  
        }  
import java.io.InterruptedIOException;
                    // Nobody will consume this; drop the buffer immediately.
            if (permitReleased.compareAndSet(false, true)) {  
            return;
import org.apache.logging.log4j.Logger;
    public int read() throws IOException {
 * <p>The reader never waits on work that has not started: if it reaches a part whose prefetch
 * is streamed directly from the blob store without buffering. Parts ahead of the reader are
                        + "]: "
 * A sequential {@link InputStream} over a remote blob that downloads the blob as multiple
            // The prefetch task has not started yet: steal the part and read it ourselves.
    private InputStream current;
            } catch (RejectedExecutionException e) {
            return n;
        // Do not read further ahead than the budget would ever allow.  
            return (IOException) cause;  
    private final int numParts;
        return n < 0 ? -1 : (b[0] & 0xFF);
            current = null;
    public ParallelPartInputStream(
        UnaryOperator<InputStream> rateLimiter  
            try {
                prefetch.owner.set(Owner.CANCELLED);
        private final CompletableFuture<byte[]> future = new CompletableFuture<>();
            throw new IllegalArgumentException("fileLength must be >= 0, got " + fileLength);  
        final byte[] bytes = new byte[Math.toIntExact(length)];  
        currentRemaining = length;  
    }
            prefetches.put(partIndex, prefetch);
import java.io.ByteArrayInputStream;  
                prefetches.remove(partIndex);  
        prefetches.clear();  
import java.util.concurrent.CompletableFuture;  
            }  
                throw unwrap(e.getCause(), partIndex);
                    return -1;
                    currentPrefetch.releasePermit();  
                }  
                final InterruptedIOException iioe = new InterruptedIOException(  
            final int n = current.read(b, off, toRead);
    private final class Prefetch implements Runnable {
        return new IOException("Failed to prefetch part " + partIndex + " of blob [" + blobName + "]", cause);
        } else {  
                prefetch.releasePermit();
                return;
    private final String blobName;
        }
 * <p>Because the bytes are presented sequentially, the stream can be wrapped in a
    private final ParallelDownloadPermits permits;  
    }
        // permits * partSize bound exact instead of letting the buffer briefly outlive its permit.
        private final int partIndex;  
                if (closed.get()) {  
            throw new IOException("Stream for blob [" + blobName + "] is closed");
    private long partLength(int partIndex) {
                        + " of blob ["  
    }
    private InputStream openRange(long position, long length) throws IOException {
        if (failure != null) {
     * @param blobContainer container to read ranges from  
    }  
        if (closed.compareAndSet(false, true) == false) {
                Thread.currentThread().interrupt();
/**  
                future.completeExceptionally(t);
    private int nextPart = 0;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.blobstore.BlobContainer;
                permits.release();
            failure = e;
            } catch (ExecutionException e) {
 */  
            }
                offset += n;
            int offset = 0;
        for (Prefetch prefetch : prefetches.values()) {
    }
            throw (RuntimeException) cause;  
    }
    private final Executor executor;
            currentRemaining -= n;  
        this.permits = permits;
        String blobName,
 */
                toClose.close();  
    /** Prefetches keyed by part index. Only contains parts that hold a permit. */  
     * @param partSize      size of each byte-range part  
    public int read(byte[] b, int off, int len) throws IOException {  
            } else {
            final int toRead = (int) Math.min(len, currentRemaining);  
    private byte[] readRange(long position, long length) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
        if (closed.get()) {
        private final AtomicBoolean permitReleased = new AtomicBoolean(false);  
        BlobContainer blobContainer,  
 * <p>The blob is split into fixed-size parts. The part that the reader is currently consuming
        this.fileLength = fileLength;
            try {
    }  
            throw failure;
    private long currentRemaining;
        }
                    currentPrefetch = null;
 *
                throw new IOException("Blob stream for [" + blobName + "] returned 0 bytes for a " + toRead + "-byte read");
                iioe.initCause(e);  
     * @param permits       node-wide budget bounding the number of prefetched parts in flight
import java.io.InputStream;  
        PREFETCHER,
                throw iioe;
        final int lookaheadLimit = Math.min(numParts, nextPart + permits.getMaxPermits());
        if (fileLength < 0) {
    /**
    /** Length of a part; only the last part can be shorter than {@code partSize}. */
                return;
        void releasePermit() {
                final int n = in.read(bytes, offset, bytes.length - offset);
    private void openNextPart() throws IOException {  
import java.util.concurrent.Executor;  
                releasePermit();
        this.blobName = blobName;  
        // whose task is already running still owns a buffer of up to partSize bytes until it completes, so its permit
        // is released only when the future completes (immediately if it already has) -- that keeps the node-wide  
        if (permits == null) {  
    }
        for (int partIndex = Math.max(nextPart, highestScheduledPart + 1); partIndex < lookaheadLimit; partIndex++) {
import java.util.function.UnaryOperator;
                executor.execute(prefetch);
        }
            // Owned by a running (or finished) prefetch task: wait for its buffer.
    @Override
import java.util.concurrent.atomic.AtomicReference;  
        try (InputStream in = openRange(position, length)) {
    }
                );
        final int partIndex = nextPart++;
                    future.complete(bytes);
    private Prefetch currentPrefetch;  
                // Stolen by the reader or cancelled before we started.  
        this.numParts = Math.toIntExact((fileLength + partSize - 1) / partSize);  
    private void finishCurrentPart() throws IOException {
        ParallelDownloadPermits permits,
 * prefetched on the supplied {@link Executor} into heap buffers, subject to a node-wide  
    ) {
 * {@code permits * partSize}.
            return 0;  
            finishCurrentPart();  
    // The following fields are only touched by the (single) reader thread.
        final long position = partPosition(partIndex);
    }
    public int getNumberOfParts() {  
    }
                final int rejectedPart = partIndex;  
        }  
        if (cause instanceof Error) {
        return (long) partIndex * partSize;
            } finally {
    private final long partSize;  
        return rateLimiter.apply(blobContainer.readBlob(blobName, position, length));
import java.util.concurrent.atomic.AtomicBoolean;
    }  
                    "Interrupted while waiting for part " + partIndex + " of blob [" + blobName + "]"
    private final BlobContainer blobContainer;  
    private final Map<Integer, Prefetch> prefetches = new ConcurrentHashMap<>();
        private final AtomicReference<Owner> owner = new AtomicReference<>(Owner.NONE);
 * {@link ParallelDownloadPermits} budget so that total buffered memory stays bounded by
 * byte-range parts in parallel while presenting the bytes strictly in order.
     */
import org.apache.logging.log4j.message.ParameterizedMessage;  
    }
            highestScheduledPart = partIndex;
                }
    }
        return numParts;
                prefetch.releasePermit();
                        "Expected " + length + " bytes at offset " + position + " of blob [" + blobName + "] but read " + offset
            }
    @Override
        }
            prefetch = null;
            } catch (InterruptedException e) {  
    private static final Logger logger = LogManager.getLogger(ParallelPartInputStream.class);
            while (offset < bytes.length) {  
        }  
    /** Byte offset of a part. The index is widened explicitly so the product is computed in long arithmetic. */
        if (cause instanceof IOException) {
            }
                    );
        final long length = partLength(partIndex);  
        Prefetch prefetch = prefetches.remove(partIndex);
import java.util.concurrent.RejectedExecutionException;
                    future.completeExceptionally(new IOException("Stream for blob [" + blobName + "] is closed"));
     * Reads one part fully into a single, exactly-sized buffer. The length is known up front, so the buffer is
            if (permits.tryAcquire() == false) {  
    private void schedulePrefetches() {
        long partSize,  
                return;
        }
        }
        return bytes;
     */
                logger.debug(() -> new ParameterizedMessage("Prefetch of part {} for blob [{}] rejected", rejectedPart, blobName), e);
            }
 *  
 * @opensearch.internal  
import java.util.concurrent.ExecutionException;
            current = openRange(position, length);
        }
            this.partIndex = partIndex;  
        if (prefetch != null) {
    private final AtomicBoolean closed = new AtomicBoolean(false);
 * task is still queued it claims the part and reads it itself, and the queued task becomes a
            throw new IllegalArgumentException("partSize must be > 0, got " + partSize);  
            if (prefetch.owner.compareAndSet(Owner.NONE, Owner.CANCELLED)) {  
                        + (nextPart - 1)
 * range-by-range download. This makes the stream safe to drive from the same thread pool that
        ensureOpen();
            }  
     * @param executor      executor used to run prefetch tasks
            // The task will observe the ownership change and do nothing.
    private int highestScheduledPart = -1;  
     * @param rateLimiter   wraps each part stream, e.g. for download rate limiting  
    private IOException unwrap(Throwable cause, int partIndex) {
}
                );
                if (nextPart >= numParts) {
        }
                currentPrefetch = prefetch;
        CANCELLED  
            if (currentRemaining == 0) {
import java.io.EOFException;
        this.rateLimiter = rateLimiter;  
        this.blobContainer = blobContainer;
        this.partSize = partSize;
     * @param blobName      name of the blob within the container
                prefetch.releasePermit();  
        }  
/*  
        }  
 * The OpenSearch Contributors require contributions made to  
            if (n < 0) {
 * {@link RemoteIndexInput} and consumed by the regular {@code Directory#copyFrom} path, so
                prefetch.future.whenComplete((bytes, t) -> prefetch.releasePermit());  
        while (true) {
     * copy them into a final array, briefly holding roughly twice the part size on heap per prefetch.  
import java.util.concurrent.ConcurrentHashMap;
            prefetch.releasePermit();  
            }  
                final byte[] bytes = readRange(partPosition(partIndex), partLength(partIndex));
        schedulePrefetches();
        if (current != null) {
                    "Unexpected end of stream while reading part "
     * {@link #releasePermit()} is called, which happens once the reader has consumed the buffer,
     * @param fileLength    total length of the blob in bytes
                    throw new EOFException(  
            }
            return;
        final byte[] b = new byte[1];  
     * for as long as permits are available. Never blocks.  
            }
 * local directory-level encryption continue to work unchanged.
        READER,
    private enum Owner {
 *  
public final class ParallelPartInputStream extends InputStream {
                        + currentRemaining  
        NONE,  
 * executes the prefetch tasks.
    }
import org.apache.logging.log4j.LogManager;
        } catch (IOException e) {
            final Prefetch prefetch = new Prefetch(partIndex);  
        Executor executor,
        // Return every permit this stream holds. A part that has not started is cancelled and released now. A part
                if (n < 0) {
    @Override
                }
import java.io.IOException;
                if (currentPrefetch != null) {
            if (n == 0) {
    /**
     */
            }
        if (cause instanceof RuntimeException) {
        }  
            throw (Error) cause;  
        }
 * compatible open source license.
     * allocated once and filled in place; {@code InputStream#readNBytes} would instead accumulate 16 KB chunks and
            } catch (Throwable t) {  
     * the reader has stolen the part, or the stream is closed.  
            if (current == null) {  
                prefetch.releasePermit();
            try {  
        try {
        this.executor = executor;
    private long partPosition(int partIndex) {  
    private void ensureOpen() throws IOException {  
        long fileLength,
        if (prefetch != null && prefetch.owner.compareAndSet(Owner.NONE, Owner.READER)) {  
            }
        if (partSize <= 0) {
    /**  
        final int n = read(b, 0, 1);
 *  
                current = new ByteArrayInputStream(prefetch.future.get());
    /**  
        }
import java.util.Map;
        }
