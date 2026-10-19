/**
 * sees {@code false} after another producer's write re-filled the outbound buffer),
    }
    CompositeBackpressureStrategy(Runnable channelCancelCleanup) {  
            }
        });
 * post-loop to decide which {@code WaitResult} to return. gRPC mutates
    @Override
                try {
                    return WaitResult.READY;
 *
 * {@code listener.isReady()} twice — once as the wait-loop predicate, then again
    public void register(ServerStreamListener listener) {
                }
        listener.setOnReadyHandler(() -> {
 * channel in cancelled state.
                }  
 */
                }  
                if (listener.isCancelled()) {
                lock.notifyAll();  
            try {
                    lock.wait(remaining);  
 * {@link BackpressureStrategy} that fixes a known race in Arrow's
 * The OpenSearch Contributors require contributions made to  
        synchronized (lock) {
 * this file be licensed under the Apache-2.0 license or a
        long deadline = System.currentTimeMillis() + timeoutMillis;
final class CompositeBackpressureStrategy implements BackpressureStrategy {  
}
 * cleanup (e.g. marking cancelled, releasing resources) before notifying parked
        });
    @Override
    private ServerStreamListener listener;
        this.listener = listener;  
 * SPDX-License-Identifier: Apache-2.0
 * {@code listener.isCancelled()} once per loop iteration inside the lock and commits  
            } finally {  
import org.apache.arrow.flight.BackpressureStrategy;
                }
 * the two reads can disagree (e.g. predicate sees {@code true} and exits, post-loop
package org.opensearch.arrow.flight.transport;
    private final Runnable channelCancelCleanup;  
        }  
                    lock.notifyAll();
                synchronized (lock) {
                    return WaitResult.TIMEOUT;  
        this.channelCancelCleanup = channelCancelCleanup;
                    Thread.currentThread().interrupt();
                if (remaining <= 0) {
            }
 */  
 * {@code notifyAll()} simply wakes the waiter so the next iteration reads fresh.
 * to those values — there is no second read to disagree with. The handlers'
                    return WaitResult.CANCELLED;
        listener.setOnCancelHandler(() -> {  
import org.apache.arrow.flight.FlightProducer.ServerStreamListener;
 * {@code CallbackBackpressureStrategy} (apache/arrow-java#346): that strategy reads  
            }
    }
 *
            while (true) {  
                channelCancelCleanup.run();
    }  
                }  
                    return WaitResult.OTHER;  
 * producing {@code "Invalid state when waiting for listener"} runtime exceptions.  
/*  
 * waiters, so a thread waking from {@code waitForListener} always observes the  
                } catch (InterruptedException e) {
                long remaining = deadline - System.currentTimeMillis();
 * <p>This implementation reads {@code listener.isReady()} and
 * {@code isReady()} from Netty event-loop threads outside the strategy's lock, so  
                if (listener.isReady()) {
    public WaitResult waitForListener(long timeoutMillis) {  
            synchronized (lock) {
 *  
 * compatible open source license.
 * <p>Composes channel-level cancel cleanup: the cancel callback runs the channel's
    private final Object lock = new Object();
