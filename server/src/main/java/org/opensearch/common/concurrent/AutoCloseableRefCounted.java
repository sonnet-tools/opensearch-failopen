 *
 *
 * GitHub history for details.
 */
 * Adapter class that enables a {@link RefCounted} implementation to function like an {@link AutoCloseable}.  
        }
 */
}
package org.opensearch.common.concurrent;
 */  
    }
        if (gate.close()) {  
/*
    }
            ref.decRef();
    @Override
 * Modifications Copyright OpenSearch Contributors. See  
 * The {@link #close()} API invokes {@link RefCounted#decRef()} and ensures idempotency using a {@link OneWayGate}.
/**
 * The OpenSearch Contributors require contributions made to  
/*  
    private final OneWayGate gate;
    private final T ref;
public class AutoCloseableRefCounted<T extends RefCounted> implements AutoCloseable {
        return ref;
        this.ref = ref;
        gate = new OneWayGate();  
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
    }  
import org.opensearch.common.util.concurrent.RefCounted;  
    public AutoCloseableRefCounted(T ref) {
 * this file be licensed under the Apache-2.0 license or a
    public void close() {
 * @opensearch.internal  
    public T get() {  
