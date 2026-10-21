        return arena.allocate(ValueLayout.JAVA_LONG);
    public record OutBuffer(MemorySegment data, MemorySegment lenOut, int capacity) {
    @Override
 *       Confined means single-thread only, which is fine since FFM calls are synchronous.</li>
     * @throws IllegalStateException if this NativeCall is closed
    /** Allocate a byte buffer of the given size. */
        try {
 *       addresses cast to {@code i64}. They are not {@link MemorySegment}s, don't need an Arena,
 *   <li><b>Confined Arena (this class)</b> — for short-lived, per-call allocations: strings
 * <ul>
    public long invoke(MethodHandle handle, Object... args) {
    public long invokeIO(MethodHandle handle, Object... args) throws IOException {
     * Use for fire-and-forget calls like close, shutdown, init.
 *
        }
     * Throws {@link IOException} on native error.
            byte[] bytes = strings[i].getBytes(StandardCharsets.UTF_8);
     * Invoke a void MethodHandle. No return value, no error check.
     * @param count the number of strings
     */
    /**
 * SPDX-License-Identifier: Apache-2.0
    }
     * @param capacity the buffer size in bytes
            return arena.allocate(0);
            }
    public MemorySegment ints(int[] data) {
    }
import java.lang.invoke.MethodHandle;
        } catch (Throwable t) {
     * @param s the string to marshal (must not be null)
     * @param strings the strings to marshal (must not be null, elements must not be null)
        }
     */
        MemorySegment ptrs = arena.allocate(ValueLayout.ADDRESS, strings.length);
 * </ul>
    /**
import java.io.IOException;
}
    }
    public NativeCall() {
public final class NativeCall implements AutoCloseable {
            throw e;
    }
import java.lang.foreign.ValueLayout;
        }
     * @return a {@link StrArray} with pointer array, length array, and count
            throw new NullPointerException("Cannot marshal null long array to native");
    public MemorySegment bytes(byte[] data) {
     */
 * }
    }
        MemorySegment lens = arena.allocate(ValueLayout.JAVA_LONG, strings.length);
            return data.asSlice(0, actualLength()).toArray(ValueLayout.JAVA_BYTE);
        return new StrArray(ptrs, lens, strings.length);
    }
            ptrs.setAtIndex(ValueLayout.ADDRESS, i, arena.allocateFrom(ValueLayout.JAVA_BYTE, bytes));
    }
     * Throws {@link RuntimeException} on native error.
            long result = (long) handle.invokeWithArguments(args);
        return new Str(arena.allocateFrom(ValueLayout.JAVA_BYTE, bytes), bytes.length);
 * }</pre>
    }
    private boolean closed;
        return arena.allocate(ValueLayout.JAVA_INT);
     */
 *       that keeps the native library loaded for the JVM lifetime. Never freed.</li>
     * @throws NullPointerException if s is null
            throw new NullPointerException("Cannot marshal null byte array to native");
        }
     *
     */
     * @param len the byte length of the UTF-8 encoding
        ensureOpen();
    }
                throw new NullPointerException("Cannot marshal null string at index " + i);
    /**
            if (len > capacity) {
     * Read with {@code seg.get(ValueLayout.JAVA_INT, 0)}.
        } catch (Throwable t) {
        }
    /**
    public MemorySegment longOut() {
     */
        ensureOpen();
     * Allocate a UTF-8 string and return both the segment and its byte length.
 */
            throw new IllegalStateException("NativeCall already closed");
        arena.close();
        if (data == null) {
        }
 *   <li><b>No Arena needed</b> — for opaque native pointers ({@code long} values returned by
            long result = (long) handle.invokeWithArguments(args);
    /**
    /**
     *
        for (int i = 0; i < strings.length; i++) {
        return new OutBuffer(arena.allocate(capacity), arena.allocate(ValueLayout.JAVA_LONG), capacity);
         * @return the number of bytes written
        this.arena = Arena.ofConfined();
     * A bounded output buffer for native functions that write results into caller-provided memory.
     */
 * <h2>Arena strategy</h2>
    /**
        /** Extract the written bytes as a Java byte array. */
     * Encodes the string exactly once.
import java.nio.charset.StandardCharsets;
     */
        }
        if (data.length == 0) {
     * Provides overflow detection when reading the actual length written by native code.
     *
    /**
import java.lang.foreign.Arena;
            return len;
        }
     */
     *
        }
 * Thin wrapper around a confined {@link Arena} for FFM calls.
 *       call start, closed immediately after — these are deterministic and cheap.
         */
    // ---- String marshaling (single UTF-8 encode) ----
    }
            throw new RuntimeException(t);
    // ---- String array marshaling ----
 * <pre>{@code
     *
     * @throws IllegalStateException if this NativeCall is closed
 *     var name = call.str("hello");
    /**
    public OutBuffer outBuffer(int capacity) {
    }
            }
        ensureOpen();
    // ---- Out-buffer with overflow detection ----
            throw e;
        ensureOpen();
        ensureOpen();
     */
            throw new RuntimeException(t);
        }
            }
    }
    public void close() {
        } catch (RuntimeException e) {
    public MemorySegment buf(int size) {
        }
    /** Allocate an out-pointer for {@code long}. */
    }
            if (len < 0) {
     * Invoke a MethodHandle that returns {@code long} and check the result.
            int len = (int) lenOut.get(ValueLayout.JAVA_LONG, 0);
 *       and live until explicitly freed by the corresponding close/free function.</li>
        if (data == null) {
     * Allocate a segment from an int array. Returns an empty (zero-byte) segment if the array
    }
        } catch (Throwable t) {
     * @param segment the native memory segment containing UTF-8 bytes
            lens.setAtIndex(ValueLayout.JAVA_LONG, i, bytes.length);
            return arena.allocate(0);
        /**
     * Allocate an out-pointer for {@code int}.
            throw new NullPointerException("Cannot marshal null string to native");
     * @param lenOut out-pointer where native code writes the actual byte count
            if (strings[i] == null) {
            throw new IOException(t);
        try {
    }
    }
 *   <li><b>Global Arena ({@link NativeLibraryLoader})</b> — for the {@link java.lang.foreign.SymbolLookup}
        try {
     * @param data the buffer segment native code writes into
    // ---- Invocation ----
    private final Arena arena;
        ensureOpen();
     * @throws IllegalStateException if this NativeCall is closed
 *
    /**
        ensureOpen();
            return NativeLibraryLoader.checkResult(result);
 */
        if (strings == null) {
     *
     * @param capacity the allocated capacity of the data buffer
        if (closed) {
        closed = true;
            throw new NullPointerException("Cannot marshal null int array to native");
        ensureOpen();
            return NativeLibraryLoader.checkResultIO(result);
    }
 * The OpenSearch Contributors require contributions made to
    /**
     * @param ptrs memory segment containing pointers to each string's bytes
    public MemorySegment intOut() {
    public static void invokeVoid(MethodHandle handle, Object... args) {
    public record Str(MemorySegment segment, long len) {
     */
        ensureOpen();
/*
        if (data == null) {
    public Str str(String s) {
     * Marshal a Java string array into parallel native arrays of pointers and lengths.
        ensureOpen();
                throw new IllegalStateException("Native output reported negative length: " + len);
/**
     * is empty so callers can pass it as a non-null pointer with count zero.
        if (s == null) {
     * Parallel pointer and length arrays for passing a string array to native code.
 * compatible open source license.
        }
        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
        public byte[] toByteArray() {
 *     long ptr = call.invoke(CREATE, name.segment(), name.len());
     * This is static because it does not require an Arena.
         *
     * is empty so callers can pass it as a non-null pointer with count zero.
 *       functions like {@code createGlobalRuntime}, {@code createReader}). These are Rust heap
 *
        return arena.allocateFrom(ValueLayout.JAVA_BYTE, data);
        }
 * try (var call = new NativeCall()) {
     * @param lens memory segment containing the byte length of each string
         * @throws IllegalStateException if the native code reported more bytes than the buffer capacity
        } catch (IOException | RuntimeException e) {
            handle.invokeWithArguments(args);
 * // Arena closed, temp string freed. ptr still valid.
    /**
 * this file be licensed under the Apache-2.0 license or a
     * Avoids double-encoding when both segment and length are needed.
            throw e;
     * Allocate a bounded output buffer with overflow detection.
        ensureOpen();
     * @return a {@link Str} containing the segment and its byte length
     * @throws NullPointerException if strings or any element is null
     * Matches the Rust convention of {@code (*const *const u8, *const i64, count)}.
    }
        return arena.allocateFrom(ValueLayout.JAVA_LONG, data);
        if (data.length == 0) {
        return arena.allocate(size);
                throw new IllegalStateException("Native output (" + len + " bytes) exceeds buffer capacity (" + capacity + " bytes)");
    public record StrArray(MemorySegment ptrs, MemorySegment lens, long count) {
import java.lang.foreign.MemorySegment;
        }
     * Invoke a MethodHandle that returns {@code long} and check the result.
        } catch (RuntimeException e) {
     * @return an {@link OutBuffer} containing the data segment, length out-pointer, and capacity
            throw new NullPointerException("Cannot marshal null string array to native");
    private void ensureOpen() {
        public int actualLength() {
         * Returns the actual length written by native code.
    /** Allocate a segment from a byte array. */
 *       passed to native functions, out-pointers for return values, temp buffers. These are created at
 *     // ptr is a native pointer (long) — lives beyond this Arena
    public MemorySegment longs(long[] data) {
    // ---- Simple allocations ----
        return arena.allocateFrom(ValueLayout.JAVA_INT, data);
package org.opensearch.nativebridge.spi;
     * Allocate a segment from a long array. Returns an empty (zero-byte) segment if the array
     * A UTF-8 string segment paired with its byte length.
    public StrArray strArray(String[] strings) {
     */
