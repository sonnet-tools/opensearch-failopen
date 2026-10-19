    }
            throw e;  
     * Encodes the string exactly once.  
    }
        if (strings == null) {  
     */  
        ensureOpen();  
        if (data == null) {
        if (data == null) {
import java.lang.foreign.ValueLayout;
     *  
    /**
 *  
            handle.invokeWithArguments(args);
        return arena.allocateFrom(ValueLayout.JAVA_INT, data);
 * // Arena closed, temp string freed. ptr still valid.
 * SPDX-License-Identifier: Apache-2.0
         */  
        }
public final class NativeCall implements AutoCloseable {
    }  
     * @return an {@link OutBuffer} containing the data segment, length out-pointer, and capacity
    /**  
import java.lang.invoke.MethodHandle;
    public MemorySegment bytes(byte[] data) {  
     */
        }
     * @param s the string to marshal (must not be null)
        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);  
     * Allocate an out-pointer for {@code int}.  
        return arena.allocateFrom(ValueLayout.JAVA_LONG, data);
        } catch (IOException | RuntimeException e) {
     * Invoke a MethodHandle that returns {@code long} and check the result.
    public record StrArray(MemorySegment ptrs, MemorySegment lens, long count) {
/*  
        if (data.length == 0) {
     * @param len the byte length of the UTF-8 encoding
    public MemorySegment buf(int size) {  
     * @return a {@link StrArray} with pointer array, length array, and count  
     * Allocate a bounded output buffer with overflow detection.
        } catch (Throwable t) {
 *       functions like {@code createGlobalRuntime}, {@code createReader}). These are Rust heap
 * <pre>{@code
     *
            long result = (long) handle.invokeWithArguments(args);
 *
    /** Allocate a segment from a byte array. */
        }  
 * <h2>Arena strategy</h2>
    }  
        }  
     * @param lens memory segment containing the byte length of each string
    /** Allocate an out-pointer for {@code long}. */
 * </ul>
    public OutBuffer outBuffer(int capacity) {
            throw new NullPointerException("Cannot marshal null byte array to native");  
            throw new NullPointerException("Cannot marshal null string array to native");
        ensureOpen();
 */  
     * Use for fire-and-forget calls like close, shutdown, init.
        return new StrArray(ptrs, lens, strings.length);
            }
        } catch (Throwable t) {
        ensureOpen();
     * @param lenOut out-pointer where native code writes the actual byte count
import java.io.IOException;
        /** Extract the written bytes as a Java byte array. */  
     */
 *     var name = call.str("hello");  
        }
    // ---- String marshaling (single UTF-8 encode) ----
    /**
    public StrArray strArray(String[] strings) {
        ensureOpen();
    }  
     * Allocate a segment from a long array. Returns an empty (zero-byte) segment if the array  
    private boolean closed;
     * @param data the buffer segment native code writes into
        } catch (RuntimeException e) {
        ensureOpen();
         * @throws IllegalStateException if the native code reported more bytes than the buffer capacity
    /**
 *
     * Invoke a MethodHandle that returns {@code long} and check the result.  
    }
        ensureOpen();
    /** Allocate a byte buffer of the given size. */
            }
     * is empty so callers can pass it as a non-null pointer with count zero.
        return arena.allocate(ValueLayout.JAVA_LONG);
            return len;  
     * @throws IllegalStateException if this NativeCall is closed
    }
     * Allocate a UTF-8 string and return both the segment and its byte length.
    public MemorySegment ints(int[] data) {  
            throw new NullPointerException("Cannot marshal null long array to native");  
 * <ul>  
 *       and live until explicitly freed by the corresponding close/free function.</li>
            throw e;
    public MemorySegment longs(long[] data) {  
        return arena.allocateFrom(ValueLayout.JAVA_BYTE, data);
     * @throws IllegalStateException if this NativeCall is closed
            if (len < 0) {  
 *       call start, closed immediately after — these are deterministic and cheap.  
    }
            throw new IllegalStateException("NativeCall already closed");  
 * this file be licensed under the Apache-2.0 license or a
    public long invoke(MethodHandle handle, Object... args) {
     */
    /**
    // ---- Out-buffer with overflow detection ----
 * compatible open source license.
        }
    }
    // ---- Simple allocations ----  
/**
     * A bounded output buffer for native functions that write results into caller-provided memory.
     * @param segment the native memory segment containing UTF-8 bytes
    }
    /**
            throw new RuntimeException(t);
                throw new IllegalStateException("Native output reported negative length: " + len);
}
     * @param ptrs memory segment containing pointers to each string's bytes
        if (closed) {
        try {  
            byte[] bytes = strings[i].getBytes(StandardCharsets.UTF_8);  
    /**
     * Avoids double-encoding when both segment and length are needed.
        return new OutBuffer(arena.allocate(capacity), arena.allocate(ValueLayout.JAVA_LONG), capacity);  
 * }  
            if (len > capacity) {  
 *   <li><b>Global Arena ({@link NativeLibraryLoader})</b> — for the {@link java.lang.foreign.SymbolLookup}
    }
            throw e;  
 * }</pre>
    }  
 *   <li><b>No Arena needed</b> — for opaque native pointers ({@code long} values returned by
     *
 * Thin wrapper around a confined {@link Arena} for FFM calls.  
        return arena.allocate(size);
            throw new NullPointerException("Cannot marshal null string to native");
        for (int i = 0; i < strings.length; i++) {
        try {
 * The OpenSearch Contributors require contributions made to  
    /**  
     * Marshal a Java string array into parallel native arrays of pointers and lengths.  
        this.arena = Arena.ofConfined();
        public byte[] toByteArray() {
    /**  
     * Read with {@code seg.get(ValueLayout.JAVA_INT, 0)}.
import java.nio.charset.StandardCharsets;  
 *     // ptr is a native pointer (long) — lives beyond this Arena
        }  
     * @throws NullPointerException if strings or any element is null
    public record Str(MemorySegment segment, long len) {
        return new Str(arena.allocateFrom(ValueLayout.JAVA_BYTE, bytes), bytes.length);
     */
     * is empty so callers can pass it as a non-null pointer with count zero.
import java.lang.foreign.MemorySegment;  
 *       passed to native functions, out-pointers for return values, temp buffers. These are created at
            throw new IOException(t);
         * Returns the actual length written by native code.
    }  
                throw new NullPointerException("Cannot marshal null string at index " + i);
    private void ensureOpen() {
        }
     * Provides overflow detection when reading the actual length written by native code.
            return data.asSlice(0, actualLength()).toArray(ValueLayout.JAVA_BYTE);
    /**
     */  
        MemorySegment ptrs = arena.allocate(ValueLayout.ADDRESS, strings.length);  
     */  
    public void close() {
        ensureOpen();
            throw new NullPointerException("Cannot marshal null int array to native");  
     * Throws {@link RuntimeException} on native error.  
        }
     * @param count the number of strings  
            long result = (long) handle.invokeWithArguments(args);  
    }
     * This is static because it does not require an Arena.  
            ptrs.setAtIndex(ValueLayout.ADDRESS, i, arena.allocateFrom(ValueLayout.JAVA_BYTE, bytes));
    private final Arena arena;  
     * Parallel pointer and length arrays for passing a string array to native code.
     *  
        if (s == null) {  
package org.opensearch.nativebridge.spi;
    }  
    public MemorySegment longOut() {  
     * @throws NullPointerException if s is null
     * @return a {@link Str} containing the segment and its byte length  
    /**  
         * @return the number of bytes written
 *     long ptr = call.invoke(CREATE, name.segment(), name.len());
            return NativeLibraryLoader.checkResultIO(result);
        if (data.length == 0) {
     * A UTF-8 string segment paired with its byte length.
        arena.close();  
        /**
        }
    public long invokeIO(MethodHandle handle, Object... args) throws IOException {  
        }  
    public NativeCall() {  
        } catch (RuntimeException e) {
            return arena.allocate(0);  
        MemorySegment lens = arena.allocate(ValueLayout.JAVA_LONG, strings.length);
        ensureOpen();
        ensureOpen();
 *       that keeps the native library loaded for the JVM lifetime. Never freed.</li>  
     * @throws IllegalStateException if this NativeCall is closed
 */  
    }  
     * Matches the Rust convention of {@code (*const *const u8, *const i64, count)}.
        ensureOpen();
     */
 *       Confined means single-thread only, which is fine since FFM calls are synchronous.</li>
    public Str str(String s) {
     * @param capacity the allocated capacity of the data buffer  
                throw new IllegalStateException("Native output (" + len + " bytes) exceeds buffer capacity (" + capacity + " bytes)");
            }
        }
     * @param capacity the buffer size in bytes  
            if (strings[i] == null) {  
     * Allocate a segment from an int array. Returns an empty (zero-byte) segment if the array  
     *  
     */
            return NativeLibraryLoader.checkResult(result);  
    /**  
     * Invoke a void MethodHandle. No return value, no error check.
        } catch (Throwable t) {  
 *       addresses cast to {@code i64}. They are not {@link MemorySegment}s, don't need an Arena,  
    public record OutBuffer(MemorySegment data, MemorySegment lenOut, int capacity) {
     */
        try {
            return arena.allocate(0);  
    public MemorySegment intOut() {  
     */
 *   <li><b>Confined Arena (this class)</b> — for short-lived, per-call allocations: strings
     *
    }
     * @param strings the strings to marshal (must not be null, elements must not be null)
        if (data == null) {
            throw new RuntimeException(t);
    // ---- Invocation ----
            lens.setAtIndex(ValueLayout.JAVA_LONG, i, bytes.length);
        closed = true;
        public int actualLength() {
    @Override  
     */  
    }  
         *  
        return arena.allocate(ValueLayout.JAVA_INT);
        }
 * try (var call = new NativeCall()) {
        }
            int len = (int) lenOut.get(ValueLayout.JAVA_LONG, 0);
    public static void invokeVoid(MethodHandle handle, Object... args) {
     * Throws {@link IOException} on native error.
        ensureOpen();
import java.lang.foreign.Arena;
    // ---- String array marshaling ----
