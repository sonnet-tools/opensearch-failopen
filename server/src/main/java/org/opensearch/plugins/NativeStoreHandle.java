import java.util.Set;  
     * Checks the global registry to detect if the pointer was closed from any reference.  
    @FunctionalInterface
     */  
     * @throws IllegalArgumentException if ptr is 0 or negative  
     */  
            LIVE_POINTERS.remove(ptr);
     * @return true if the pointer is tracked and has not been closed  
 * so the pointer and its cleanup are always paired.  
     * @throws IllegalArgumentException if ptr is {@code <= 0} or destroyer is null
     * Callback to destroy the native resource.
     *  
    }
@ExperimentalApi
        void destroy(long ptr);  
 * Type-safe, closeable wrapper around a native (Rust) object store pointer.
    }
        return this != EMPTY && LIVE_POINTERS.contains(ptr);  
    /**  
     * Checks if a raw pointer value corresponds to a live, open NativeStoreHandle.
        }
    /** Sentinel representing "no native store". Safe to close (no-op). */
    public long getPointer() {  
     * @return the count of open native store handles
        this.destroyer = destroyer;  
 * Use {@link #isLivePointer(long)} to validate a raw pointer before passing it  
 *
    private final long ptr;  
     */
    private static final Set<Long> LIVE_POINTERS = ConcurrentHashMap.newKeySet();
/*  
    private final AtomicBoolean closed = new AtomicBoolean(false);
public final class NativeStoreHandle implements AutoCloseable {  
 * <p>Prevents use-after-close by guarding {@link #getPointer()} with a
 *
        if (closed.compareAndSet(false, true)) {  
            throw new IllegalArgumentException("Native store pointer must be > 0, got: " + ptr);  
            return -1;
    public void close() {
     * @param destroyer the function to call on close to free the native resource
package org.opensearch.plugins;
    }
    @Override
     * Used to detect use-after-free: if a pointer is not in this set, it has
    public static int liveHandleCount() {
        if (ptr <= 0) {
 * <p>Instances are created by {@link NativeRemoteObjectStoreProvider} and  
     * Returns true if this handle holds a live pointer (not EMPTY, not closed).
 *  
     * Creates a live handle wrapping the given pointer.
    public NativeStoreHandle(long ptr, Destroyer destroyer) {
 * owned by the repository that holds the native store pointer.
        }
            return;
     * Global registry of all live native pointers managed by NativeStoreHandle.  
        if (destroyer == null) {
    public static boolean isLivePointer(long ptr) {
    }
        }  
    /**
     * Validates that a raw pointer value is live, throwing if it is stale or unknown.
    }  
     * Returns the number of currently live handles. Useful for leak detection in tests.  
    /**
    /**  
     *
     * @param name a descriptive name for error messages (e.g., "storeHandle", "nativeStoreForReader")
    }
    public boolean isLive() {
     */  
            );
     * @param ptr  the raw pointer value to validate
     */
     * first call invokes the destroyer. No-op on {@link #EMPTY}.
/**
 * to native code — catches use-after-free bugs as exceptions instead of SIGSEGV.
 *
 * @opensearch.experimental  
    public static void validatePointer(long ptr, String name) {  
    /** Private constructor for the EMPTY sentinel. */
     */
            throw new IllegalArgumentException("Destroyer must not be null");  
        if (LIVE_POINTERS.contains(ptr) == false) {
        if (ptr <= 0) {
import java.util.concurrent.atomic.AtomicBoolean;
}
            throw new IllegalStateException("NativeStoreHandle already closed (ptr=0x" + Long.toHexString(ptr) + ")");
    public static final NativeStoreHandle EMPTY = new NativeStoreHandle();  
                name + " pointer 0x" + Long.toHexString(ptr) + " is not a live handle — already closed or never created"  
 * liveness check. The destructor function is captured at creation time,
    }
        }  
 * SPDX-License-Identifier: Apache-2.0
        return LIVE_POINTERS.size();
    private final Destroyer destroyer;
     * @param ptr       the native pointer (must be {@code > 0})  
     *
     * @param ptr the raw pointer value to check
        if (closed.get()) {
            destroyer.destroy(ptr);
        }
     * use-after-free bugs.  
        if (this == EMPTY) {
        this.ptr = -1;  
        this.ptr = ptr;
        this.destroyer = null;
    /**
        LIVE_POINTERS.add(ptr);
    private NativeStoreHandle() {
 */
        }  
     * Use this before passing raw pointer values to native code to detect
     */  
        if (this == EMPTY) {  
        }  
     * been closed or was never created by a NativeStoreHandle.
 *
        return LIVE_POINTERS.contains(ptr);  
        return ptr;
     */
     * @throws IllegalStateException    if the pointer is not in the live registry
     * @throws IllegalStateException if the handle has been closed
     *  
     * Returns the native pointer, or {@code -1} for {@link #EMPTY}.
     */  
 * compatible open source license.
     * Use this as a guard before FFM downcalls that accept raw pointer arguments.
    /**  
import java.util.concurrent.ConcurrentHashMap;
import org.opensearch.common.annotation.ExperimentalApi;
    }
            throw new IllegalStateException(
    public interface Destroyer {
    /**
 * <p>All live pointers are tracked in a global registry ({@link #LIVE_POINTERS}).
    }  
     * Destroys the native resource. Safe to call multiple times — only the
 * The OpenSearch Contributors require contributions made to  
    /**
    /**  
     *
 */  
 * this file be licensed under the Apache-2.0 license or a
        }
            throw new IllegalArgumentException(name + " pointer is invalid: " + ptr);
