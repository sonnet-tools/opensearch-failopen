 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.annotation.ExperimentalApi;
}
 * rather than leaking raw pointers.
 *
 *
     * Returns the underlying native store pointer for FFM callers.  
 * SPDX-License-Identifier: Apache-2.0
     */
    public NativeStoreRepository(NativeStoreHandle handle) {
        handle.close();  
 * this file be licensed under the Apache-2.0 license or a
 * and closed in {@code doClose()}.
    @Override
        return handle.isLive();
import org.opensearch.plugins.NativeStoreHandle;
     */
    /**
    public static final NativeStoreRepository EMPTY = new NativeStoreRepository(NativeStoreHandle.EMPTY);
    /**  
 * <p>Wraps a {@link NativeStoreHandle} and provides the single entry point
    /**
     *
 * compatible open source license.
        this.handle = handle != null ? handle : NativeStoreHandle.EMPTY;
 */
 *
/*  
 *  
     * Sentinel representing "no native store". Safe to close (no-op).  
public record NativeStoreRepository(NativeStoreHandle handle) implements AutoCloseable {  
    public long getPointer() {
     * @throws IllegalStateException if the handle has been closed  
    public boolean isLive() {  
     */
 * <p>Instances are created by repository implementations during construction  
     * @return the pointer ({@code > 0}), or {@code -1} if empty
 * for all native store operations. Today this exposes the pointer for FFM
 */  
    public void close() {
@ExperimentalApi
    }
    }
     */  
 * @opensearch.experimental  
        return handle.getPointer();  
/**
package org.opensearch.repositories;
     * Returns true if this holds a live native store (not empty, not closed).
    }
     * Destroys the native resource. Safe to call multiple times.
 * Facade for native (Rust) object store interactions on a repository.
 * callers; future operations (native read, list, register) will be added here  
    }  
    /**
