    public long get() {
    public boolean isOpen() {  
 *
     */
 * GC safety net, stale pointer tracking, and double-close prevention.  
    public NativeRuntimeHandle(long pointer) {
package org.opensearch.be.datafusion;
    /**
import org.opensearch.common.annotation.ExperimentalApi;  
public class NativeRuntimeHandle extends NativeHandle {
 * The OpenSearch Contributors require contributions made to  
    }
     * This method preserves backward compatibility with callers that use
     */
/*  
            ensureOpen();
     */  
     * Returns true if the handle has not been closed.
        } catch (IllegalStateException e) {
     * Creates a handle wrapping the given native runtime pointer.
 *
}
    }  
    /**  
     * @throws IllegalArgumentException if pointer is zero
@ExperimentalApi
 * Type-safe handle for the native DataFusion global runtime.  
     *  
     *
     * @param pointer the native runtime pointer (must be non-zero)
/**
 * SPDX-License-Identifier: Apache-2.0
            return true;  
     * {@code handle.get()} instead of {@code handle.getPointer()}.  
        return getPointer();  
    protected void doClose() {
     * <p>
 * Extends {@link NativeHandle} to get automatic resource management, Cleaner-based
 * {@link NativeBridge#closeGlobalRuntime(long)}.  
 * The runtime pointer lives until {@link #close()} is called, which invokes
     * @return the native runtime pointer
 */  
     * Returns the native runtime pointer, checking that it is still live.  
     * @throws IllegalStateException if the handle has been closed  
 */  
import org.opensearch.be.datafusion.nativelib.NativeBridge;
 * this file be licensed under the Apache-2.0 license or a
        super(pointer);
 * <p>
    }  
        try {
 * <p>
    /**
import org.opensearch.analytics.backend.jni.NativeHandle;
        }  
    @Override  
            return false;
 * @opensearch.experimental
 * compatible open source license.
    }
        NativeBridge.closeGlobalRuntime(ptr);
