/**
     * @param runtimeHandle handle to the native runtime (for streamNext calls)  
        super(streamPtr);  
    }
    public StreamHandle(long streamPtr, NativeRuntimeHandle runtimeHandle) {
    /**  
import org.opensearch.be.datafusion.NativeRuntimeHandle;
    }
import org.opensearch.analytics.backend.jni.NativeHandle;
    @Override  
    }  
        NativeBridge.streamClose(ptr);
 * Type-safe handle for a native DataFusion result stream.
 * Wraps the stream pointer returned by {@link NativeBridge#executeQueryAsync}.  
package org.opensearch.be.datafusion.nativelib;
     * @param streamPtr the native stream pointer
 */
 */  
public final class StreamHandle extends NativeHandle {
        return runtimeHandle;  
     */
 * compatible open source license.
     * Creates a stream handle wrapping the native pointers.
/*  
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
    /** Returns the native runtime handle. */
    public NativeRuntimeHandle getRuntimeHandle() {
        this.runtimeHandle = runtimeHandle;
 * this file be licensed under the Apache-2.0 license or a
    protected void doClose() {
    private final NativeRuntimeHandle runtimeHandle;
}
 *
