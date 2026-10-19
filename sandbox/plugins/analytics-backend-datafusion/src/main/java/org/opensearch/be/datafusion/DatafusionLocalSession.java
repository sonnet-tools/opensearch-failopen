    }  
    protected void doClose() {
import org.opensearch.analytics.backend.jni.NativeHandle;
 *
        NativeBridge.closeLocalSession(ptr);
 * session itself is closed.
 */  
    @Override  
 */  
}
public final class DatafusionLocalSession extends NativeHandle {
 * compatible open source license.
     *
    }
 * {@link NativeBridge#registerPartitionStream(long, String, byte[])} and drops them when the
/*  
/**
 * SPDX-License-Identifier: Apache-2.0
        super(NativeBridge.createLocalSession(runtimePtr));  
 * <p>The session holds a DataFusion {@code SessionContext} bound to the node-global runtime's
 * memory pool and disk manager. It owns any input partition streams registered via  
     * @param runtimePtr pointer returned by {@link NativeBridge#createGlobalRuntime}  
     * Creates a new local session tied to the given global runtime pointer.
import org.opensearch.be.datafusion.nativelib.NativeBridge;
 * this file be licensed under the Apache-2.0 license or a
 * coordinator-reduce path ({@link DatafusionReduceSink}).  
 *
    /**  
package org.opensearch.be.datafusion;
 * The OpenSearch Contributors require contributions made to  
 * Type-safe wrapper around a native DataFusion {@code LocalSession} pointer, used by the
     */
    public DatafusionLocalSession(long runtimePtr) {
