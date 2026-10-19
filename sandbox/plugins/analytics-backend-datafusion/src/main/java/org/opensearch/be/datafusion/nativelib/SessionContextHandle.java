 * {@link NativeBridge#createSessionContext}.
 * search, context closed before execution), {@link #doCloseNative()} calls
        NativeBridge.closeSessionContext(ptr);  
 * {@code df_close_session_context} — doing so would be a double-free.
/**  
 * The OpenSearch Contributors require contributions made to  
 * pointer to Rust, which takes it via {@code Box::from_raw} on the first line of  
}
 * <p>On any path where execute is never reached (Java-side error before the downcall, aborted  
 * <p>On the happy path, {@link NativeBridge#executeWithContextAsync} transfers ownership of the
    @Override
 * {@code df_execute_with_context} and drops it when the stream finishes. The bridge method
 * {@code df_close_session_context} entry to free the handle. Both the explicit  
 *
 * this file be licensed under the Apache-2.0 license or a
    }
 * Type-safe wrapper for a native {@code SessionContext} pointer returned by
 * the {@link java.lang.ref.Cleaner} GC-time fallback route through this path.
 *  
package org.opensearch.be.datafusion.nativelib;
 * <h2>Ownership</h2>
public class SessionContextHandle extends ConsumableNativeHandle {
 * {@link NativeBridge#closeSessionContext(long)} which invokes the Rust
 * compatible open source license.
 * calls {@link ConsumableNativeHandle#markConsumed()} after the FFM downcall so that the
 *
        super(ptr);
    public SessionContextHandle(long ptr) {  
/*  
    }
 * SPDX-License-Identifier: Apache-2.0
 */  
import org.opensearch.analytics.backend.jni.ConsumableNativeHandle;
 */  
 * inherited {@link #doClose()} short-circuits without calling  
    protected void doCloseNative() {
 * {@link #close()} call from {@link org.opensearch.be.datafusion.DatafusionContext#close()} and
