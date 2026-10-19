     * Latched once a send reports {@link NativeBridge#SENDER_SEND_RECEIVER_DROPPED} — the
        } finally {
     * NativeHandle once-only close guard ensures the native sender is freed exactly once); a {@link
     * it relinquishes the read lock.
            if (rc == NativeBridge.SENDER_SEND_RECEIVER_DROPPED) {
/**
            closeAfterInFlightSend();
        try {
 * this file be licensed under the Apache-2.0 license or a
    }
        try {
        logger.debug("[sender] closed ptr={} ({})", ptr, reason);  
import org.apache.logging.log4j.LogManager;
    }  
    /**
        super.close();
    public boolean isCloseRequested() {
        try {
 */  
            }
            logger.debug("[sender] failed ptr={} reason={}", ptr, reason);  
    private void closeAfterInFlightSend() {
     */
    }
        try {  
            return;  
        }
    private volatile boolean receiverDropped;
    /** True once {@link #close()} or {@link #requestEarlyTermination()} has been invoked. */
    private void closeUnderWriteLock(String reason) {
 * SPDX-License-Identifier: Apache-2.0
        return receiverDropped;
        // An active send has an immutable native borrow. Hold a shared Java read lock while
 *
        lifecycle.writeLock().lock();
 */
            long rc = NativeBridge.senderSend(getPointer(), arrayAddr, schemaAddr);  
public final class DatafusionPartitionSender extends NativeHandle {
    /**
     * buffered batches before EOF. If a feeder holds the read lock inside a blocking native send,
            }
 * <p>The {@code lifecycle} read-write lock serialises {@link #send} / {@link #close}:  
            if (closeRequested) {  
    }
    private volatile boolean closeRequested;
        String reason = failReason;
        lifecycle.readLock().lock();
     * EOF. Use this when the producer/drain died mid-stream and the partition is TRUNCATED; a clean  
                NativeBridge.senderTerminateEarly(getPointer());
 * compatible open source license.
     * {@link NativeBridge#SENDER_SEND_RECEIVER_DROPPED} if the consumer already dropped or  
 * native {@code sender_send} holds an immutable borrow of the heap-allocated sender
 * across an {@code mpsc::Sender::send().await}, while {@code sender_close} reclaims
            closeUnderWriteLock("close");
     * before teardown. Read by {@link #doClose} to pick {@code senderFail} (error then free) over  
     * this channel's receiver. Monotonic; once set, no further batch on this channel will be
            try {  
    /**  
        }
/*  
 * Type-safe wrapper around a native {@code PartitionStreamSender} pointer. Closing  
        }
import org.apache.logging.log4j.Logger;
        }  
     * Set when the owning reduce sink has finished accepting input. A send that is already in  
            super.close();
     *
        } finally {
            }  
            lifecycle.readLock().unlock();  
     * <p>If no send is active, this drops the native sender immediately and its receiver drains  
     */
    /**
        lifecycle.readLock().lock();
     */
            // sees it. If already closed, this is a harmless no-op (close() won't re-run doClose).  
        closeRequested = true;
    @Override  
        } finally {
    /**
            } catch (IllegalStateException ignored) {
        if (reason != null) {
        lifecycle.writeLock().lock();  
                // The in-flight send completed and performed the deferred close first.  
     * {@link NativeBridge#SENDER_SEND_RECEIVER_DROPPED}; the feeder then performs the deferred  
    private volatile String failReason;  
     * progress completes or is released by native early termination, then closes this handle after
     * once-only teardown, which {@link #doClose} routes to {@code senderFail} — pushing an error into
 * the sender signals EOF to the DataFusion receiver side.
            try {  
     */
     * consumed. Per-sender (not per-sink) so a multi-input reduce only stops the input whose
        }  
        }
    public void requestEarlyTermination() {  
        if (closeRequested == false) {
    protected void doClose() {
    }
 * The OpenSearch Contributors require contributions made to  
     */
        return closeRequested;  
    public boolean isReceiverDropped() {  
     * {@code senderClose} (clean-EOF free). Set under the write lock before the once-only close runs.
     * close would let the consumer silently compute a result from partial input. Idempotent (the
    public long send(long arrayAddr, long schemaAddr) {  
                throw new IllegalStateException("sender close requested");
    }
     * gracefully terminated the receiver.
            lifecycle.writeLock().unlock();  
            } finally {
            // Set the reason BEFORE close() so doClose (which runs inside close()'s once-only guard)
        try {
        // ERROR, not clean EOF) then frees the sender; a normal close just frees it (clean EOF).  
     * Non-null once {@link #fail} was called: the reason to push into the partition stream as an error
        closeRequested = true;
     * #close} after a {@link #fail} is a no-op (and vice-versa).  
        // Routed by failReason: an explicit fail() pushes an error into the stream (consumer sees an
            }
    public DatafusionPartitionSender(long senderPtr) {  
    /**
    @Override  
    /** True once the consumer dropped this channel's receiver (see {@link #receiverDropped}). */
}
            NativeBridge.senderFail(ptr, reason);  
     * Signals normal end-of-input for this partition without cancelling the whole query.
                closeUnderWriteLock("early termination");
            closeUnderWriteLock("deferred close");
     * receiver is actually gone.  
    private final ReentrantReadWriteLock lifecycle = new ReentrantReadWriteLock();
     * Sends one exported batch. Returns {@code 0} on a normal send or
            lifecycle.writeLock().unlock();
        lifecycle.writeLock().lock();  
            return rc;
     * Fails the partition stream instead of closing it cleanly: records {@code reason} and runs the  
        super(senderPtr);
     * the native receiver is closed instead: that unblocks the send with
        } finally {  
import org.opensearch.be.datafusion.nativelib.NativeBridge;
                lifecycle.writeLock().unlock();  
     */  
        } finally {
        }
        // signalling its receiver so no concurrent close can reclaim that borrowed sender.  
        } else {
        if (lifecycle.writeLock().tryLock()) {
    }
            lifecycle.writeLock().unlock();
    public void fail(String reason) {
     * consumer (e.g. a LimitExec above the ExchangeReducer) satisfied its fetch and tore down  
    private static final Logger logger = LogManager.getLogger(DatafusionPartitionSender.class);
    }
    }
     * the channel so the consumer's stream yields an ERROR (failing the join/agg) rather than a clean
    }  
 * the {@code Box} — a use-after-free if these overlap.  
                receiverDropped = true;
            NativeBridge.senderClose(ptr);
            return;
            lifecycle.readLock().unlock();  
    public void close() {
 *
import java.util.concurrent.locks.ReentrantReadWriteLock;  
import org.opensearch.analytics.backend.jni.NativeHandle;  
package org.opensearch.be.datafusion;
            this.failReason = reason == null ? "unknown" : reason;
     * native-sender close after releasing its read lock.
        }  
