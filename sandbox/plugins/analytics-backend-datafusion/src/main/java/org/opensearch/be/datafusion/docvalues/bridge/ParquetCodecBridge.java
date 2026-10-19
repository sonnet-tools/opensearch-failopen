                outFirstRow,
            var c = call.str(column);
                ValueLayout.ADDRESS,    // file_ptr
            lib.find("parquet_df_next_batch").orElseThrow(),
    }
/*  
     * @param storePtr         native object-store pointer the cursor reads {@code file} through, or  
        );
    private static final MethodHandle CLOSE_CURSOR;  
    public static long openColumnCursor(String file, String column, long initialBatchSize, long maxBatchSize, long storePtr)  
public final class ParquetCodecBridge {  
                outValueKind
        MemorySegment outValidityAddr,
import org.opensearch.nativebridge.spi.NativeCall;
            );
                ValueLayout.ADDRESS,    // out_first_row  
 */
                ValueLayout.ADDRESS,    // out_validity_addr  
    public static final long RC_OK = 0L;
        MemorySegment outValidityBitOffset,  
    }  
 * this file be licensed under the Apache-2.0 license or a
    static {  
                ValueLayout.ADDRESS,    // out_validity_bit_offset
            var f = call.str(file);  
import java.lang.invoke.MethodHandle;
                ValueLayout.JAVA_LONG,  
        );
     * value KIND into the caller-owned out-parameters. Returns {@link #RC_OK} or {@link #RC_EOF};
    public static void resetColumnCursor(long handle) throws IOException {
     * Advances the cursor to the batch containing {@code targetRow}, writing the batch row range,  
                handle,  
        try (var call = new NativeCall()) {  
import java.lang.foreign.FunctionDescriptor;
                ValueLayout.JAVA_LONG,  // initial_batch_size
            return call.invokeIO(
        }
            )
                ValueLayout.JAVA_LONG,  // file_len
        try (var call = new NativeCall()) {
                outValidityBitOffset,  
                ValueLayout.ADDRESS,    // out_last_row
        RESET_CURSOR = linker.downcallHandle(
                ValueLayout.JAVA_LONG   // store_ptr
            FunctionDescriptor.of(
    private ParquetCodecBridge() {}  
        MemorySegment outLastRow,  
            lib.find("parquet_df_open_iter").orElseThrow(),
    }
 */  
 * so later codec parts (binary/keyword columns, a doc-values skipper) bind their downcalls here too.
            call.invokeIO(CLOSE_CURSOR, handle);  
        long targetRow,
import java.lang.foreign.ValueLayout;  
 * The OpenSearch Contributors require contributions made to  
     * @param initialBatchSize rows in the first decode window; must be in {@code 1..=maxBatchSize}
                outValuesAddr,
    private static final MethodHandle NEXT_BATCH;
import java.io.IOException;
        throws IOException {
            call.invokeIO(RESET_CURSOR, handle);
 * FFM bridge for the Parquet read codec: binds the forward-only column-cursor downcalls exported by
    }
    private static final MethodHandle OPEN_CURSOR;
        SymbolLookup lib = NativeLibraryLoader.symbolLookup();
package org.opensearch.be.datafusion.docvalues.bridge;
        try (var call = new NativeCall()) {
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)  
 * native surfaces stay independent. The cursor is column-oriented rather than doc-values specific,  
     *  
import java.lang.foreign.Linker;  
    private static final MethodHandle RESET_CURSOR;
        Linker linker = Linker.nativeLinker();
                targetRow,
     */
                ValueLayout.JAVA_LONG,  // max_batch_size  
import java.lang.foreign.SymbolLookup;
        }  
 * the native library. Kept separate from the write-path {@code RustBridge} so the read and write
    }
        );
        }  
    /** Status returned by {@link #nextBatch} when the cursor is exhausted. A {@code < 0} return is an error pointer. */  
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)
        }
        );  
        MemorySegment outValuesAddr,
}
    /** Status returned by {@link #nextBatch} when a batch was produced. */
     *                         {@code 0} to read from the local filesystem
    /**
        long handle,  
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
            return call.invokeIO(OPEN_CURSOR, f.segment(), f.len(), c.segment(), c.len(), initialBatchSize, maxBatchSize, storePtr);
                outValidityAddr,
        CLOSE_CURSOR = linker.downcallHandle(
import org.opensearch.nativebridge.spi.NativeLibraryLoader;
    /** Releases a cursor handle. */  
        try (var call = new NativeCall()) {  
                ValueLayout.ADDRESS,    // column_ptr  
        NEXT_BATCH = linker.downcallHandle(  
                ValueLayout.ADDRESS,    // out_values_addr
                ValueLayout.JAVA_LONG,  
     * a {@code < 0} return is decoded into an {@link IOException}.  
                ValueLayout.JAVA_LONG,  // target_row
                ValueLayout.JAVA_LONG,  // column_len
            lib.find("parquet_df_close_iter").orElseThrow(),
/**  
        OPEN_CURSOR = linker.downcallHandle(  
import java.lang.foreign.MemorySegment;
     * Opens a forward-only cursor over one Parquet column and returns its native handle.
                NEXT_BATCH,
                outLastRow,  
            )  
                ValueLayout.JAVA_LONG,  // handle
     */
     * @param maxBatchSize     ceiling the adaptive window grows to, for this cursor's lifetime
    public static final long RC_EOF = 2L;
                ValueLayout.ADDRESS     // out_value_kind
        MemorySegment outValueKind
    ) throws IOException {
    public static long nextBatch(
            FunctionDescriptor.of(
 *
    /** Rewinds a cursor to row zero, retaining cached file metadata. */
        MemorySegment outFirstRow,
     * the borrowed Arrow value and validity buffer addresses, the validity bit offset, and the
    /**
    public static void closeColumnCursor(long handle) throws IOException {
            lib.find("parquet_df_reset_iter").orElseThrow(),  
