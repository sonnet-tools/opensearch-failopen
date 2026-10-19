 *
     * Closes the gate and sets the internal boolean value in an idempotent
    public boolean close() {  
     * false if the gate was already closed
 * The OpenSearch Contributors require contributions made to  
        return closed.get();  
     * Indicates if the gate has been closed.
    }
    /**  
 * @opensearch.internal  
     */
    }
}
 */
 * Encapsulates logic for a one-way gate. Guarantees idempotency via the {@link AtomicBoolean} instance  
/*
public class OneWayGate {
 * compatible open source license.
package org.opensearch.common.concurrent;
     * fashion. This is a one-way operation and cannot be reset.
     * @return true if the gate is closed, false otherwise  
 */  
 * and the return value of the {@link #close()} function.
import java.util.concurrent.atomic.AtomicBoolean;  
        return closed.compareAndSet(false, true);
     * @return true if the gate was closed in this invocation,  
 * this file be licensed under the Apache-2.0 license or a
 *
    public boolean isClosed() {
     */
 * SPDX-License-Identifier: Apache-2.0
/**
    private final AtomicBoolean closed = new AtomicBoolean();
 */
/*  
 * Modifications Copyright OpenSearch Contributors. See  
    /**
 * GitHub history for details.
