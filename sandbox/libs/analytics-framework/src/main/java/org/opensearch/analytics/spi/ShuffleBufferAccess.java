            }  
 * <p>The implementing class lives in analytics-engine ({@code ShuffleBufferManager.ShuffleBuffer});
     * completion latches know when to fire. {@code expectedLeft} / {@code expectedRight} should  
    /** Returns the accumulated Arrow IPC chunks for the {@code "left"} side. Caller must not mutate.
     * handler calls this on the worker node before {@link #awaitReady} so the buffer's
     * in heap (this is what lets an over-budget shuffle RUN rather than OOM during drain).
    private static CloseableIterator<byte[]> wrap(Iterator<byte[]> it) {
     * elapses. Returns {@code true} on success, {@code false} on timeout. Throws  
    void setExpectedSenders(int expectedLeftSenders, int expectedRightSenders);
     *  <p>EAGER: with spill enabled this reads the whole partition (spilled file + in-memory tail)  
 *
    /**  
 * @opensearch.internal
 * await readiness, then drain.  
 * the SPI exposes only the consumer-side surface so backend handlers don't need a hard  
    /**  
 *
 *
public interface ShuffleBufferAccess {
     * only fires once); calling with different values from concurrent threads is unsupported.  
    List<byte[]> getRightData();
 * SPDX-License-Identifier: Apache-2.0
     * LAZILY drains the {@code "left"} side's chunks in arrival order: spilled chunks are streamed
     * each equal the number of producer tasks (one per source shard) that will ship into this
     * sender and discards it before pulling the next, so a spilled partition is never fully resident  
        return wrap(getRightData().iterator());
     * spill-file handle is released even on partial iteration. The default wraps {@link #getLeftData()}
 */  
     */
 * this file be licensed under the Apache-2.0 license or a
    boolean awaitReady(long timeoutMillis) throws InterruptedException;  
    /** LAZILY drains the {@code "right"} side — see {@link #drainLeft()}. */
            public byte[] next() {
            @Override
     */  
import java.util.List;
import java.util.Iterator;
     *  back into heap at once. Prefer {@link #drainLeft()} on the consumer hot path so a spilled
    }
                return it.hasNext();  
 * uses to drain accumulated bytes for one (queryId, stageId, partitionIndex) on one side.  
 * {@code AnalyticsShuffleDataAction} transport path; consumers (this interface's caller)
     * Blocks until both sides' senders have all reported {@code isLast}, or {@code timeoutMillis}
/**
            public void close() {  
 * compatible open source license.
/*  
            }
            @Override  
     *  <p>EAGER — see {@link #getLeftData()}. Prefer {@link #drainRight()} on the hot path. */  
                // nothing to release — the backing list is heap-resident
    default CloseableIterator<byte[]> drainLeft() {
}
    List<byte[]> getLeftData();  
     * partition. Calling this multiple times with the same values is idempotent (CountDownLatch
    }  
 * Read-only handle to a node-local shuffle buffer slice — what a hash-shuffle worker handler
 */  
            public boolean hasNext() {
            @Override
    /** Adapts a plain {@link Iterator} to a no-op-close {@link CloseableIterator} (in-memory case). */
    }
     *  partition never fully materializes. Retained for tests / small non-spill callers. */
    /**
     */
 * The OpenSearch Contributors require contributions made to  
    default CloseableIterator<byte[]> drainRight() {  
     * for implementations that hold everything in memory anyway.
            }
     * <p>Call once per side after {@link #awaitReady}. MUST be closed (try-with-resources) so the  
        };  
 * dependency on the engine plugin's internals. Producers populate the buffer via the
     *
     * one-at-a-time from disk, then the in-memory tail. The consumer feeds each chunk to the native
        return new CloseableIterator<>() {  
     * Sets the number of senders this buffer will receive on each side. The consumer-side
    /** Returns the accumulated Arrow IPC chunks for the {@code "right"} side. Caller must not mutate.
package org.opensearch.analytics.spi;
        return wrap(getLeftData().iterator());
                return it.next();
     * {@link InterruptedException} if the calling thread is interrupted (e.g. task cancellation).
