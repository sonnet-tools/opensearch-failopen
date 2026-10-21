    }
/**
                lifecycle.writeLock().unlock();
            return;
        } finally {
                // The in-flight send completed and performed the deferred close first.
    public DatafusionPartitionSender(long senderPtr) {
        try {
    /**
        } else {
     * Latched once a send reports {@link NativeBridge#SENDER_SEND_RECEIVER_DROPPED} — the
     * consumer (e.g. a LimitExec above the ExchangeReducer) satisfied its fetch and tore down
 * the sender signals EOF to the DataFusion receiver side.
        lifecycle.writeLock().lock();
 * compatible open source license.
        }
     */
import org.apache.logging.log4j.Logger;
     */
     * it relinquishes the read lock.
     * #close} after a {@link #fail} is a no-op (and vice-versa).
    private static final Logger logger = LogManager.getLogger(DatafusionPartitionSender.class);
     * Fails the partition stream instead of closing it cleanly: records {@code reason} and runs the
     * {@link NativeBridge#SENDER_SEND_RECEIVER_DROPPED} if the consumer already dropped or
    private volatile boolean closeRequested;
            closeUnderWriteLock("close");
        } finally {
     * receiver is actually gone.
            } finally {
        }
            closeUnderWriteLock("deferred close");
        closeRequested = true;
        return receiverDropped;
        } finally {
        }
     * consumed. Per-sender (not per-sink) so a multi-input reduce only stops the input whose
            } catch (IllegalStateException ignored) {
            }
public final class DatafusionPartitionSender extends NativeHandle {
     * before teardown. Read by {@link #doClose} to pick {@code senderFail} (error then free) over
            return rc;
    }
        super(senderPtr);
        }
                receiverDropped = true;
    private volatile String failReason;
    }
    private final ReentrantReadWriteLock lifecycle = new ReentrantReadWriteLock();
 * across an {@code mpsc::Sender::send().await}, while {@code sender_close} reclaims
                throw new IllegalStateException("sender close requested");
    /**
 * native {@code sender_send} holds an immutable borrow of the heap-allocated sender
    }
     * Signals normal end-of-input for this partition without cancelling the whole query.
    public boolean isReceiverDropped() {
 */
     *
     */
     * the channel so the consumer's stream yields an ERROR (failing the join/agg) rather than a clean
 * this file be licensed under the Apache-2.0 license or a
import org.apache.logging.log4j.LogManager;
            NativeBridge.senderFail(ptr, reason);
    /**
        try {
    private void closeUnderWriteLock(String reason) {
            lifecycle.readLock().unlock();
     * Set when the owning reduce sink has finished accepting input. A send that is already in
    public boolean isCloseRequested() {
        }
    protected void doClose() {
    }
/*
     * Sends one exported batch. Returns {@code 0} on a normal send or
    /** True once {@link #close()} or {@link #requestEarlyTermination()} has been invoked. */
                NativeBridge.senderTerminateEarly(getPointer());
 *
 */
        lifecycle.readLock().lock();
            logger.debug("[sender] failed ptr={} reason={}", ptr, reason);
    }
    }
        if (reason != null) {
        return closeRequested;
            long rc = NativeBridge.senderSend(getPointer(), arrayAddr, schemaAddr);
            closeAfterInFlightSend();
            }
     * once-only teardown, which {@link #doClose} routes to {@code senderFail} — pushing an error into
     * {@link NativeBridge#SENDER_SEND_RECEIVER_DROPPED}; the feeder then performs the deferred
        logger.debug("[sender] closed ptr={} ({})", ptr, reason);
    /**
        if (lifecycle.writeLock().tryLock()) {
        closeRequested = true;
                closeUnderWriteLock("early termination");
 * the {@code Box} — a use-after-free if these overlap.
        } finally {
     */
        lifecycle.writeLock().lock();
 *
     * Non-null once {@link #fail} was called: the reason to push into the partition stream as an error
            try {
     * the native receiver is closed instead: that unblocks the send with
 * <p>The {@code lifecycle} read-write lock serialises {@link #send} / {@link #close}:
        // ERROR, not clean EOF) then frees the sender; a normal close just frees it (clean EOF).
            // sees it. If already closed, this is a harmless no-op (close() won't re-run doClose).
     * close would let the consumer silently compute a result from partial input. Idempotent (the
import org.opensearch.be.datafusion.nativelib.NativeBridge;
     * {@code senderClose} (clean-EOF free). Set under the write lock before the once-only close runs.
            super.close();
    }
    }
    @Override
     * NativeHandle once-only close guard ensures the native sender is freed exactly once); a {@link
        }
        try {
     * <p>If no send is active, this drops the native sender immediately and its receiver drains
            this.failReason = reason == null ? "unknown" : reason;
            }
     * gracefully terminated the receiver.
        } finally {
}
            }
    /**
    @Override
     * this channel's receiver. Monotonic; once set, no further batch on this channel will be
        lifecycle.readLock().lock();
    public void requestEarlyTermination() {
            try {
 * Type-safe wrapper around a native {@code PartitionStreamSender} pointer. Closing
        if (closeRequested == false) {
     * buffered batches before EOF. If a feeder holds the read lock inside a blocking native send,
    public long send(long arrayAddr, long schemaAddr) {
    }
import java.util.concurrent.locks.ReentrantReadWriteLock;
     * progress completes or is released by native early termination, then closes this handle after
    public void fail(String reason) {
     * EOF. Use this when the producer/drain died mid-stream and the partition is TRUNCATED; a clean
    /**
import org.opensearch.analytics.backend.jni.NativeHandle;
        String reason = failReason;
            NativeBridge.senderClose(ptr);
 * The OpenSearch Contributors require contributions made to
 * SPDX-License-Identifier: Apache-2.0
     * native-sender close after releasing its read lock.
            lifecycle.writeLock().unlock();
package org.opensearch.be.datafusion;
            lifecycle.writeLock().unlock();
            if (closeRequested) {
        lifecycle.writeLock().lock();
            // Set the reason BEFORE close() so doClose (which runs inside close()'s once-only guard)
    private volatile boolean receiverDropped;
    public void close() {
        // Routed by failReason: an explicit fail() pushes an error into the stream (consumer sees an
        }
     */
        }
    private void closeAfterInFlightSend() {
        // signalling its receiver so no concurrent close can reclaim that borrowed sender.
        // An active send has an immutable native borrow. Hold a shared Java read lock while
            lifecycle.writeLock().unlock();
            return;
        try {
        super.close();
    /** True once the consumer dropped this channel's receiver (see {@link #receiverDropped}). */
            lifecycle.readLock().unlock();
            if (rc == NativeBridge.SENDER_SEND_RECEIVER_DROPPED) {
        try {
     */
