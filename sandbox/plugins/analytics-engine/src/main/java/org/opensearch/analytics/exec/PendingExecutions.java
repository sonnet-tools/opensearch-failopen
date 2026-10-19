        }
     * Runs {@code work} if a permit is free, otherwise queues it. Once admitted, {@code work} may
 *
    /**  
}
            assert permitsTaken >= 0 : "illegal permits: " + permitsTaken;
            assert permitsTaken >= 0 : "illegal permits: " + permitsTaken;
 */  
 * the caller's thread; otherwise it is queued and drained when a prior execution calls  
                toExecute = queue.poll();  
        while (toExecute != null && toExecute.getAsBoolean() == false) {
 * {@link #finishAndRunNext()}.
        }
        this.permits = permits;  
            permitsTaken++;  
 * @opensearch.internal  
     * decline — it can turn out to have nothing to do by the time its turn comes.
    }
     */
            if (toExecute == null) {
package org.opensearch.analytics.exec;
public final class PendingExecutions {
    private synchronized BooleanSupplier passPermitOn() {  
        BooleanSupplier toExecute = null;
 * compatible open source license.
    private final int permits;  
            }
        synchronized (this) {
     * count is untouched on a hand-off, so the permit never looks free and the window can't overshoot.
 * this file be licensed under the Apache-2.0 license or a
        BooleanSupplier toExecute = tryQueue(work);
     *  
    private int permitsTaken = 0;
            }
        tryRun(null);  
            queue.add(runnable);  
    private final ArrayDeque<BooleanSupplier> queue = new ArrayDeque<>();
            permitsTaken--;  
    /**
            toExecute = passPermitOn();  
 *
 * SPDX-License-Identifier: Apache-2.0
    }
    private synchronized BooleanSupplier tryQueue(BooleanSupplier runnable) {  
        assert permits > 0 : "permits must be > 0: " + permits;
 *
    }
        if (next == null) {
 * <p>Callers submit work via {@link #tryRun}. If a permit is available the work runs immediately on
     * rather than recursively, so declining a whole fan-out costs constant stack.
            permitsTaken--;  
        BooleanSupplier next = queue.poll();
     * started nothing, so its permit goes to the next queued item — declining without handing the
    public void finishAndRunNext() {
 * Permit-based concurrency queue. Same pattern as
        }
            if (toExecute == null) {
        if (permitsTaken < permits) {
    public void tryRun(BooleanSupplier work) {  
    }  
/*  
    }
import java.util.function.BooleanSupplier;
        return next;  
     */
            toExecute = runnable;
                permitsTaken--;  
 */
        return toExecute;
 * {@code AbstractSearchAsyncAction.PendingExecutions} in OpenSearch core.  
    public PendingExecutions(int permits) {
     * Hands a decliner's permit to the next queued item, or releases it when nothing is waiting. The  
        }
     * <p>{@code true} means it started and owes a {@link #finishAndRunNext()}. {@code false} means it
/**
        } else if (runnable != null) {
 * The OpenSearch Contributors require contributions made to  
     * permit on would shrink the window and eventually stall it. Declines are drained in a loop here  
import java.util.ArrayDeque;
