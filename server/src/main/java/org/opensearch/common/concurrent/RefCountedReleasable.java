 *
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
        }
 * invoked when the reference count reaches zero i.e. on {@link #closeInternal()}.  
import org.opensearch.common.util.concurrent.AbstractRefCounted;
/**  
    @Override  
        decRef();
package org.opensearch.common.concurrent;
            shutdownRunnable.run();  
 *
    }
 */
        this.shutdownRunnable = shutdownRunnable;  
        this.ref = ref;
}  
 * GitHub history for details.
import org.opensearch.common.lease.Releasable;  
 * Decorator class that wraps an object reference as a {@link AbstractRefCounted} instance.
    public RefCountedReleasable(String name, T ref, Runnable shutdownRunnable) {  
 * @opensearch.internal
 */  
        if (shutdownRunnable != null) {
        super(name);
    private final T ref;  
    }  
    private final Runnable shutdownRunnable;
    @Override  
    }
    }
        return ref;  
 * In addition to a {@link String} name, it accepts a {@link Runnable} shutdown hook that is
 */  
public class RefCountedReleasable<T> extends AbstractRefCounted implements Releasable {
    public void close() {
/*
 * The OpenSearch Contributors require contributions made to  
    protected void closeInternal() {
 * Modifications Copyright OpenSearch Contributors. See  
    public T get() {
/*  
 * this file be licensed under the Apache-2.0 license or a
