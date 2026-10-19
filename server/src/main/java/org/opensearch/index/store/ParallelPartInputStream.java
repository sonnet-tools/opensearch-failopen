     */
        PREFETCHER,
            }
 * compatible open source license.
            highestScheduledPart = partIndex;
            currentRemaining -= n;
            if (owner.compareAndSet(Owner.NONE, Owner.PREFETCHER) == false) {
     * copy them into a final array, briefly holding roughly twice the part size on heap per prefetch.
                prefetch.releasePermit();
                        + " of blob ["
            } catch (Throwable t) {
    /** Length of a part; only the last part can be shorter than {@code partSize}. */
                    future.completeExceptionally(new IOException("Stream for blob [" + blobName + "] is closed"));
    private static final Logger logger = LogManager.getLogger(ParallelPartInputStream.class);
        return n < 0 ? -1 : (b[0] & 0xFF);
                        "Expected " + length + " bytes at offset " + position + " of blob [" + blobName + "] but read " + offset
                throw unwrap(e.getCause(), partIndex);
                // InputStream#read(byte[], int, int) may only return 0 when len == 0, and toRead >= 1 here.
            } finally {
        return numParts;
                    "Unexpected end of stream while reading part "
            throw failure;
        @Override
import org.opensearch.common.blobstore.BlobContainer;
        }
                }
        final byte[] b = new byte[1];
    private enum Owner {
 * @opensearch.internal
    }
            final Prefetch prefetch = new Prefetch(partIndex);
        void releasePermit() {
/*
            }
                }
                prefetch.releasePermit();
            if (currentRemaining == 0) {
        // Return every permit this stream holds. A part that has not started is cancelled and released now. A part
        Prefetch prefetch = prefetches.remove(partIndex);
        }
                openNextPart();
            }
    @Override
        public void run() {
    private long partLength(int partIndex) {
        return Math.min(partSize, fileLength - partPosition(partIndex));
            } else {
 * prefetched on the supplied {@link Executor} into heap buffers, subject to a node-wide
     * the reader has stolen the part, or the stream is closed.
            if (prefetch.owner.compareAndSet(Owner.NONE, Owner.CANCELLED)) {
        private final AtomicReference<Owner> owner = new AtomicReference<>(Owner.NONE);
        BlobContainer blobContainer,
            if (n == 0) {
    private void openNextPart() throws IOException {
    // The following fields are only touched by the (single) reader thread.
import org.apache.logging.log4j.Logger;
    /**
        } else {
            try {
        this.executor = executor;
 * {@link ParallelDownloadPermits} budget so that total buffered memory stays bounded by
            prefetch = null;
    private final long fileLength;
        return (long) partIndex * partSize;
            return;
     * Reads one part fully into a single, exactly-sized buffer. The length is known up front, so the buffer is
import java.util.concurrent.atomic.AtomicReference;
                if (nextPart >= numParts) {
                if (n < 0) {
        if (current != null) {
 * task is still queued it claims the part and reads it itself, and the queued task becomes a
                iioe.initCause(e);
            }
        final long length = partLength(partIndex);
            final int n = current.read(b, off, toRead);
        final int n = read(b, 0, 1);
        IOException failure = null;
        UnaryOperator<InputStream> rateLimiter
    public int getNumberOfParts() {
import java.io.EOFException;
 * <p>Because the bytes are presented sequentially, the stream can be wrapped in a
        for (Prefetch prefetch : prefetches.values()) {
            // Owned by a running (or finished) prefetch task: wait for its buffer.
                toClose.close();
        this.blobName = blobName;
     * @param permits       node-wide budget bounding the number of prefetched parts in flight
 * {@code permits * partSize}.
 * SPDX-License-Identifier: Apache-2.0
    }
        while (true) {
            } catch (RejectedExecutionException e) {
        }
 *
}
        }
 * byte-range parts in parallel while presenting the bytes strictly in order.
        ensureOpen();
 * no-op. When no permits are available the stream degrades gracefully to a plain sequential
            prefetch.releasePermit();
    private void ensureOpen() throws IOException {
                    );
import java.util.concurrent.atomic.AtomicBoolean;
        }
import org.apache.logging.log4j.LogManager;
    private final long partSize;
    /**
            }
                final byte[] bytes = readRange(partPosition(partIndex), partLength(partIndex));
 * this file be licensed under the Apache-2.0 license or a
            try {
        // whose task is already running still owns a buffer of up to partSize bytes until it completes, so its permit
        if (cause instanceof IOException) {
    }
                }
                logger.debug(() -> new ParameterizedMessage("Prefetch of part {} for blob [{}] rejected", rejectedPart, blobName), e);
        }
 *
                // Stolen by the reader or cancelled before we started.
    private long currentRemaining;
                releasePermit();
        final long position = partPosition(partIndex);
        }
        if (len == 0) {
    private InputStream openRange(long position, long length) throws IOException {
            failure = e;
        if (cause instanceof RuntimeException) {
     * @param partSize      size of each byte-range part
            if (current == null) {
import java.util.concurrent.ConcurrentHashMap;
                    return -1;
     * @param fileLength    total length of the blob in bytes
            try {
                throw iioe;
        }
                if (closed.get()) {
        if (closed.compareAndSet(false, true) == false) {
    private byte[] readRange(long position, long length) throws IOException {
    private InputStream current;
        this.rateLimiter = rateLimiter;
        // Do not read further ahead than the budget would ever allow.
        }
            throw new IllegalArgumentException("fileLength must be >= 0, got " + fileLength);
        } catch (IOException e) {
                } else {
        return rateLimiter.apply(blobContainer.readBlob(blobName, position, length));
                    currentPrefetch = null;
            if (permitReleased.compareAndSet(false, true)) {
        }
    @Override
                }
     * @param blobContainer container to read ranges from
        if (permits == null) {
     * Schedules prefetches for the parts following the one being read, in increasing order,
import java.io.IOException;
        NONE,
            final InputStream toClose = current;
    }
    private int highestScheduledPart = -1;
    public int read() throws IOException {
            // The prefetch task has not started yet: steal the part and read it ourselves.
        CANCELLED
import org.apache.logging.log4j.message.ParameterizedMessage;
        }
    private final class Prefetch implements Runnable {
    }
     * {@link #releasePermit()} is called, which happens once the reader has consumed the buffer,
        if (prefetch != null) {
import java.util.function.UnaryOperator;
     * for as long as permits are available. Never blocks.
    /** Byte offset of a part. The index is widened explicitly so the product is computed in long arithmetic. */
    /** Prefetches keyed by part index. Only contains parts that hold a permit. */
    private Prefetch currentPrefetch;
            try {
        if (failure != null) {
                return;
                        + currentRemaining
        READER,
        if (closed.get()) {
     * A single read-ahead part. Holds exactly one permit from the time it is scheduled until
        // permits * partSize bound exact instead of letting the buffer briefly outlive its permit.
        currentRemaining = length;
            } catch (InterruptedException e) {
    private final int numParts;
            throw new IOException("Stream for blob [" + blobName + "] is closed");
import java.util.concurrent.Executor;
            throw (Error) cause;
package org.opensearch.index.store;
            }
                );
            current = openRange(position, length);
 * is streamed directly from the blob store without buffering. Parts ahead of the reader are
                offset += n;
/**
        Executor executor,
 * <p>The reader never waits on work that has not started: if it reaches a part whose prefetch
    }
                prefetch.future.whenComplete((bytes, t) -> prefetch.releasePermit());
        private final int partIndex;
    public ParallelPartInputStream(
     * @param rateLimiter   wraps each part stream, e.g. for download rate limiting
        schedulePrefetches();
                    currentPrefetch.releasePermit();
                prefetches.remove(partIndex);
        if (fileLength < 0) {
            return;
                // Fail rather than spin on a non-conforming stream.
    }
            throw (RuntimeException) cause;
        if (partSize <= 0) {
                finishCurrentPart();
    private long partPosition(int partIndex) {
     * @param executor      executor used to run prefetch tasks
import java.util.concurrent.RejectedExecutionException;
            }
    }
                throw new EOFException(
        if (prefetch != null && prefetch.owner.compareAndSet(Owner.NONE, Owner.READER)) {
        }
        }
        this.numParts = Math.toIntExact((fileLength + partSize - 1) / partSize);
    private final UnaryOperator<InputStream> rateLimiter;
        }
                prefetch.releasePermit();
 *
            if (permits.tryAcquire() == false) {
    public int read(byte[] b, int off, int len) throws IOException {
 * range-by-range download. This makes the stream safe to drive from the same thread pool that
    }
        long partSize,
                executor.execute(prefetch);
                );
            final int toRead = (int) Math.min(len, currentRemaining);
        this.partSize = partSize;
            }
    private void schedulePrefetches() {
                return;
            while (offset < bytes.length) {
     */
            }
                currentPrefetch = prefetch;
            }
        }
            } catch (ExecutionException e) {
    private int nextPart = 0;
            prefetches.put(partIndex, prefetch);
    }
        this.permits = permits;
    public void close() throws IOException {
    private final String blobName;
import java.io.InterruptedIOException;
import java.util.concurrent.ExecutionException;
                Thread.currentThread().interrupt();
    }
    private IOException unwrap(Throwable cause, int partIndex) {
 */
            // The task will observe the ownership change and do nothing.
        }
    /**
    private final AtomicBoolean closed = new AtomicBoolean(false);
import java.io.ByteArrayInputStream;
        prefetches.clear();
        }
                throw new IOException("Blob stream for [" + blobName + "] returned 0 bytes for a " + toRead + "-byte read");
 */
        try {
        }
            }
        try (InputStream in = openRange(position, length)) {
                        + (nextPart - 1)
        }
        this.fileLength = fileLength;
                    future.complete(bytes);
                        + blobName
                    throw new EOFException(
 * {@link RemoteIndexInput} and consumed by the regular {@code Directory#copyFrom} path, so
            return 0;
                    "Interrupted while waiting for part " + partIndex + " of blob [" + blobName + "]"
                current = new ByteArrayInputStream(prefetch.future.get());
import java.util.Map;
     */
        return bytes;
    private final Map<Integer, Prefetch> prefetches = new ConcurrentHashMap<>();
    }
import java.util.concurrent.CompletableFuture;
            finishCurrentPart();
                final int n = in.read(bytes, offset, bytes.length - offset);
                future.completeExceptionally(t);
        this.blobContainer = blobContainer;
        final int partIndex = nextPart++;
                return;
        String blobName,
     * allocated once and filled in place; {@code InputStream#readNBytes} would instead accumulate 16 KB chunks and
 * recovery statistics wrappers, checksum verification on the {@code IndexOutput} side and any
            }
                final InterruptedIOException iioe = new InterruptedIOException(
        }
                if (currentPrefetch != null) {
 *
        private final CompletableFuture<byte[]> future = new CompletableFuture<>();
 * The OpenSearch Contributors require contributions made to
    }
        return new IOException("Failed to prefetch part " + partIndex + " of blob [" + blobName + "]", cause);
                        + "]: "
            current = null;
    private final ParallelDownloadPermits permits;
public final class ParallelPartInputStream extends InputStream {
    }
                    // Nobody will consume this; drop the buffer immediately.
 * local directory-level encryption continue to work unchanged.
            throw new IllegalArgumentException("partSize must be > 0, got " + partSize);
            int offset = 0;
    }
    }
 * <p>The blob is split into fixed-size parts. The part that the reader is currently consuming
     * @param blobName      name of the blob within the container
                prefetch.releasePermit();
        final byte[] bytes = new byte[Math.toIntExact(length)];
        private final AtomicBoolean permitReleased = new AtomicBoolean(false);
        if (cause instanceof Error) {
 *
            this.partIndex = partIndex;
        final int lookaheadLimit = Math.min(numParts, nextPart + permits.getMaxPermits());
                final int rejectedPart = partIndex;
    ) {
     */
        // is released only when the future completes (immediately if it already has) -- that keeps the node-wide
 * executes the prefetch tasks.
    /**
        }
                        + " bytes remaining"
import java.io.InputStream;
        long fileLength,
            }
 * A sequential {@link InputStream} over a remote blob that downloads the blob as multiple
    private final BlobContainer blobContainer;
    private void finishCurrentPart() throws IOException {
        Prefetch(int partIndex) {
        for (int partIndex = Math.max(nextPart, highestScheduledPart + 1); partIndex < lookaheadLimit; partIndex++) {
                permits.release();
            if (n < 0) {
                prefetch.owner.set(Owner.CANCELLED);
        ParallelDownloadPermits permits,
    private final Executor executor;
    @Override
            return (IOException) cause;
            return n;
