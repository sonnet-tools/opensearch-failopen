    protected final boolean isConsumed() {
    private final AtomicBoolean consumed = new AtomicBoolean(false);
     * i.e. on the error / never-executed path. Must be safe to call at most once per pointer.
     * (the native side already freed the resource), otherwise delegates to
 * native side by a specific FFM call (for example, Rust's {@code Box::from_raw} inside a
        super(ptr);
    @Override
 * this file be licensed under the Apache-2.0 license or a
        return consumed.get();  
 *   <li>eagerly closes the Java wrapper — the pointer is removed from LIVE_HANDLES in  
package org.opensearch.analytics.backend.jni;
 * consuming function). After the consuming call the native resource is freed internally;  
 * not calling it on the error path would leak.
     */  
 * <ul>
    }
    }
/**  
 *   <li>flips an internal flag so the inherited {@link #doClose()} short-circuits;</li>
 * SPDX-License-Identifier: Apache-2.0
    /**
 */
     * @return {@code true} if {@link #markConsumed()} has been called.  
 * subclasses implement to free the native resource via the appropriate {@code close_X} FFM entry.
    protected ConsumableNativeHandle(long ptr) {  
    }  
 * <p>On paths where the consuming call never happened (pre-dispatch Java error, aborted flow,  
 * compatible open source license.
 * calling the matching {@code close_X} entry a second time would be a double-free, while
import java.util.concurrent.atomic.AtomicBoolean;
 */  
 *       {@link NativeHandle}, subsequent {@link #getPointer()} calls
     * Called by {@link #doClose()} only when the handle has <b>not</b> been marked consumed,  
 * </ul>
    /**  
    protected abstract void doCloseNative();  
 *  
     */
 *       throw, and {@link NativeHandle#validatePointer(long, String) validatePointer} rejects
     * Template method: short-circuits to a no-op when {@link #isConsumed()} is {@code true}
     * for the full contract and typical call pattern.
 * This:  
     * {@link #doCloseNative()}. Marked {@code final} so subclasses cannot bypass the guard.  
    }
/*  
 *
    /**
    protected final void doClose() {  
    /**
        consumed.set(true);
 * The OpenSearch Contributors require contributions made to  
 * Specialisation of {@link NativeHandle} for pointers whose ownership is transferred to the
 *  
 *
     * a double-free.
 * Cleaner-at-GC fallback), {@link #doClose()} delegates to {@link #doCloseNative()} which
            return;
     * Marks this handle as having had its native pointer consumed by the bridge's
 * <p>The bridge method that performs the consuming FFM call must invoke
}
    /**
public abstract class ConsumableNativeHandle extends NativeHandle {  
     * Releases the native resource via the appropriate {@code close_X} FFM entry.
        close();
 * <p>{@link #markConsumed()} is idempotent and safe to call after {@link #close()}.
     * ownership-transferring FFM call, then closes the Java wrapper. See the class javadoc  
 *       the now-dangling pointer value.</li>  
     */
     * When {@code true}, {@link #doClose()} skips the call to {@link #doCloseNative()} to avoid
    public final void markConsumed() {  
        }  
        if (isConsumed()) {
     * Set once the native side has taken ownership of {@link #ptr} via the consuming FFM call.  
     */
 * {@link #markConsumed()} after the downcall returns (typically in a {@code finally} block).
        doCloseNative();
     */
