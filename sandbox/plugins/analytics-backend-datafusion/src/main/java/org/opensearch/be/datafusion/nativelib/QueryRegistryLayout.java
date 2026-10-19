 * compatible open source license.
 *
    }
    /**  
 */  
 * this file be licensed under the Apache-2.0 license or a
    public static final long ENTRY_BYTES = ENTRY_LAYOUT.byteSize();  
import java.lang.foreign.StructLayout;
     * @param i   row index, must be {@code < written} returned by the FFI call
 * Mirrors the Rust {@code query_tracker::WireQueryMetric} {@code #[repr(C)]}  
     *  
    private QueryRegistryLayout() {}
    private static final long OFF_CONTEXT_ID = 0L;
 *
        }
    }
    public static final StructLayout ENTRY_LAYOUT = MemoryLayout.structLayout(  
 * The OpenSearch Contributors require contributions made to  
            throw new AssertionError("QueryRegistryLayout entry size mismatch: expected " + expected + " but got " + ENTRY_BYTES);
 * struct (2 × i64 = 16 bytes) and decodes a strided buffer of those structs
    public static long readContextId(MemorySegment seg, int i) {
        long rowOffset = (long) i * ENTRY_BYTES;
 * generic {@code Long.MAX_VALUE / ENTRY_BYTES} sequence layout the read  
}
 * </pre>
import java.lang.foreign.ValueLayout;  
public final class QueryRegistryLayout {  
    // ENTRY_LAYOUT and the Rust #[repr(C)] WireQueryMetric struct.  
    private static final long OFF_CURRENT_BYTES = 8L;
import java.lang.foreign.MemoryLayout;  
        if (ENTRY_BYTES != expected) {  
     */  
    );  
/*  
 * SPDX-License-Identifier: Apache-2.0
 *
/**
        return seg.get(ValueLayout.JAVA_LONG, rowOffset + OFF_CONTEXT_ID);  
     * Read the {@code context_id} of the entry at zero-based index {@code i}.
import org.opensearch.analytics.spi.QueryExecutionMetrics;
    }  
        ValueLayout.JAVA_LONG.withName("context_id"),
    /**
 * {@code VarHandle}s because their bounds check enforces the segment span
 *   [ entry 0 ][ entry 1 ] ... [ entry N-1 ]
 */
    /** Layout of a single wire entry. */
package org.opensearch.be.datafusion.nativelib;
     */  
 *   each entry = { context_id, current_bytes } (2 × i64)  
 * window. We deliberately avoid {@code SequenceLayout}-derived  
 * the entire sequence layout, not just up to the requested row. With a
     * @param seg buffer populated by {@code df_query_registry_top_n_by_current}
     * a fresh {@link QueryExecutionMetrics} record.
    public static QueryExecutionMetrics readMetrics(MemorySegment seg, int i) {
     * @param i   row index, must be {@code < written} returned by the FFI call
 * directly into the SPI types consumed by
 * <p>Buffer shape (populated by {@code df_query_registry_top_n_by_current}):  
    /** Byte size of one wire entry. Matches {@code size_of::<WireQueryMetric>()} on the Rust side. */
     * @param seg buffer populated by {@code df_query_registry_top_n_by_current}
import java.lang.foreign.MemorySegment;
 * always fails an {@link IndexOutOfBoundsException}.
        return new QueryExecutionMetrics(seg.get(ValueLayout.JAVA_LONG, rowOffset + OFF_CURRENT_BYTES));  
    static {
 * <p>Decoder reads each row by slicing the segment to that row's 16-byte
    // Byte offsets within a single entry. Field order must match
        long rowOffset = (long) i * ENTRY_BYTES;
        long expected = 2L * Long.BYTES;
        ValueLayout.JAVA_LONG.withName("current_bytes")
     * Read the metrics fields of the entry at zero-based index {@code i} into
     *  
 * <pre>
 * {@link org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin#getTopQueriesByMemory}.  
