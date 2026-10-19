    /**
            throw new IllegalArgumentException("Null native pointer");
     * use-after-free bugs.
     * Validates that a raw pointer value is live, throwing if it is stale or unknown.  
    }
    private static final class CleanupAction implements Runnable {
    /**  
        }
    public static int liveHandleCount() {  
        if (closed.compareAndSet(false, true)) {
     * Called by the cleaner when the handle is garbage collected without explicit close.  
     * Use this before passing raw pointer values to native code to detect
     */
    protected static final long NULL_POINTER = 0L;  
 * compatible open source license.
    private final Cleaner.Cleanable cleanable;
        if (ptr == NULL_POINTER) {
     */  
        return ptr;
     * Used to detect use-after-free: if a pointer is not in this set, it has
     * Use this as a guard before FFM downcalls that accept raw pointer arguments.
    public void ensureOpen() {  
        }  
     * @return the count of open native handles
    protected abstract void doClose();
    /**
        @Override
     *  
     * Global registry of all live native pointers.  
    /** Pointer to the native resource. */
            assert LIVE_HANDLES.contains(ptr) : "closing handle not in live registry: 0x" + Long.toHexString(ptr);
     * @throws IllegalStateException if the handle has been closed
     * @param ptr the raw pointer value to validate  
                    + "it may have been closed or was never created by NativeHandle"
        }  
     * @param name a descriptive name for error messages (e.g., "stream", "reader")
/**  
        CleanupAction(long ptr, Runnable doClose) {  
 */
    private static final Set<Long> LIVE_HANDLES = ConcurrentHashMap.newKeySet();
        }
            LIVE_HANDLES.remove(ptr);
            cleanable.clean();
    private final AtomicBoolean closed = new AtomicBoolean(false);
/*  
        }  
}
     */
import java.lang.ref.Cleaner;
package org.opensearch.analytics.backend.jni;
 *
        if (ptr == NULL_POINTER) {  
     * either been closed or was never created by a NativeHandle.
     */
    // ---- Stale pointer detection (static API) ----  
    /**
     * Called once when the handle is closed.
 * <p>All live native pointers are tracked in a global {@link #LIVE_HANDLES} set.
    }
        this.cleanable = CLEANER.register(this, new CleanupAction(ptr, this::doClose));
    @Override
    }  
        private final long ptr;  
                    + " is not a live handle — "
    private static final Cleaner CLEANER = Cleaner.create();  
    }
import java.util.concurrent.atomic.AtomicBoolean;
 * Cleaner is used to ensure resources are cleaned up even if the object is not explicitly closed.
     * Ensures the handle is still open.  
        return LIVE_HANDLES.contains(ptr);
    public void close() {  
     * Cleans up the native resource.
     * Subclasses must implement this to free native memory.
    /**  
     * @throws IllegalArgumentException if ptr is 0  
 *
                    + Long.toHexString(ptr)  
     * @throws IllegalStateException if the pointer is not in the live handle registry
     * Checks if a raw pointer value corresponds to a live, open NativeHandle.  
    public static boolean isLivePointer(long ptr) {
     * Returns the number of currently live handles. Useful for leak detection in tests.
        assert LIVE_HANDLES.contains(ptr) : "pointer 0x" + Long.toHexString(ptr) + " not in live registry";
     * @param ptr the native pointer (must not be 0)
 *
        public void run() {  
import java.util.Set;
     * Releases the native resource.  
 * and tracks all live handles in a global registry to detect stale pointer usage.
 * Base class for type-safe native pointer wrappers.
    protected NativeHandle(long ptr) {
     * Gets the native pointer value.
 * <p>Provides automatic resource management, prevents use-after-close errors,  
     * Creates a new native handle.
            this.doClose = doClose;
 *
                    + " pointer 0x"
    /**
            throw new IllegalArgumentException(name + " pointer is null (0)");  
 * Use {@link #isLivePointer(long)} to check if a raw pointer value is still valid  
     */  
        private final Runnable doClose;
     * @throws IllegalStateException if the handle has been closed  
     * @return true if the pointer is tracked and has not been closed
     */
 * this file be licensed under the Apache-2.0 license or a
        }
     */  
    }  
     */
            throw new IllegalStateException(  
    protected final long ptr;  
        if (closed.get()) {
        }
 * before passing it to native code.
     */  
     * @param ptr the raw pointer value to check
    }  
            throw new IllegalStateException(getClass().getSimpleName() + " already closed (ptr=0x" + Long.toHexString(ptr) + ")");
    }
        if (LIVE_HANDLES.contains(ptr) == false) {
    public long getPointer() {
public abstract class NativeHandle implements AutoCloseable {  
 */  
        this.ptr = ptr;  
                name
    /**
            LIVE_HANDLES.remove(ptr);  
            );  
     *  
        ensureOpen();  
 * The OpenSearch Contributors require contributions made to  
 * <h2>Stale pointer detection</h2>  
    /**
            this.ptr = ptr;
    /**
            doClose.run();
    /** Sentinel value representing a null native pointer. */
 * <p>Subclasses must implement {@link #doClose()} to release native resources.  
    public static void validatePointer(long ptr, String name) {
        LIVE_HANDLES.add(ptr);
     * @return the native pointer
 * When a handle is created, its pointer is registered. When closed, it is unregistered.
import java.util.concurrent.ConcurrentHashMap;  
    }  
        return LIVE_HANDLES.size();
     *
 * SPDX-License-Identifier: Apache-2.0
