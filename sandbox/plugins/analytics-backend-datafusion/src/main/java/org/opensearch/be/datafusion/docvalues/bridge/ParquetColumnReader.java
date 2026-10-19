        return new ParquetColumnReader(handle, file, column, maxBatchSize);  
import java.lang.foreign.Arena;
        return open(file, column, Settings.EMPTY);
        if (batchRowsLong > maxBatchSize) {
 * the current batch by reopening the cursor (cheap, since file metadata is cached) and scanning
            throw contractViolation(row, batchRowsLong + " rows exceeds cap " + maxBatchSize);  
import org.opensearch.common.settings.Settings;
        // Drop the resident batch before freeing the cursor: a DecodedBatch holds off-heap views
 * <p>The Parquet page index is also not exposed here. A future DocValues skipper needs it to skip  
            // A negative status means Rust panicked tearing the cursor down; #[ffm_safe] caught it at  
    }
 * until the next batch call on this reader, which always replaces the batch first.
        long validityAddr;
    public DecodedBatch decodedBatch() {
    }
    private final int maxBatchSize;
            long rc = ParquetCodecBridge.nextBatch(
        this.column = column;
            );
                row,
        int bitOffset;  
                ptr,  
        // Borrowed Arrow buffers, read in place: O(rows accessed), no copy. Valid until the next
 * long column ({@code CoreDataFieldPlugin} maps it to {@code LongParquetField}), so on the wire it  
     *
        if (valuesAddr == 0 || bitOffset < 0) {
        int presenceBitOffset;
            if (current.contains(row)) {
            long presenceBytes = ((long) bitOffset + batchRows + 7) >>> 3;  
        int kind;
                validityBitOffsetOut,  
     * Opens a numeric cursor over a local file with explicit window sizes, bypassing settings
        // memory.
            firstRow = firstRowOut.get(ValueLayout.JAVA_LONG, 0);
     */
        long valuesAddr;  
                valuesAddrOut,
        // checks fail fast on a malformed contract instead of reading out of bounds. They do not,  
    private final String column;
    /**
            MemorySegment firstRowOut = out.asSlice(0L, Long.BYTES);
        MemorySegment values = MemorySegment.ofAddress(valuesAddr).reinterpret((long) batchRows * width);  
     * native side in the same call. Deliberately a value rather than a live setting lookup: the  
 * <p>Each batch call returns borrowed Arrow buffer addresses; the resident {@link DecodedBatch}
        if (validityAddr == 0) {  
import org.opensearch.analytics.backend.jni.NativeHandle;  
/**
 *
        };  
 */
            // Size to the bitmap's significant bytes, not up to a word: Arrow only guarantees the
 * already-closed reader is a no-op and the cursor is freed exactly once.  
            throw contractViolation(row, "values address " + valuesAddr + ", bit offset " + bitOffset);  
            throw new IOException("Unexpected native numeric cursor status " + rc + " at row " + row + " (" + file + "/" + column + ")");
            MemorySegment lastRowOut = out.asSlice(Long.BYTES, Long.BYTES);
import java.nio.file.Path;
        return open(file, column, initialBatchSize, maxBatchSize, LOCAL_STORE);
        MemorySegment presenceBits;
        } else {  
            }
            ParquetCodecBridge.closeColumnCursor(ptr);
    }  
 * <p>Out of scope for this reader: booleans (Arrow packs them bit-wise, so borrowing needs a value  
     * cursor first.
    }  
    /** Number of scalar out-parameters {@code nextBatch} writes back. */
        }  
 * bridge.
            // the boundary. doClose() cannot throw a checked exception, so keep the message here.
    }
     */  
 * whole pages without decoding, which requires a page-index read in both the native cursor and this
            }
        // zero-copy FFM borrow.
            presenceBits = null;
    public static ParquetColumnReader open(Path file, String column, Settings settings, long storePtr) throws IOException {
import org.apache.logging.log4j.LogManager;
 * points off-heap views at them and reads values in place, with no copy. Those views are valid only  
 * bit offset like the validity bitmap), repeated numerics, binary and keyword columns,
        // batch call on this cursor, which clears the resident batch before borrowing again.
     *
 * live-handle registry, and {@link #close()} is idempotent through the base class: closing an
            storePtr
        loadNumericBatch(row);  
 * forward again, so an ascending walk that occasionally rewinds keeps working.  
        if (firstRow < 0 || lastRow < firstRow || row < firstRow || row > lastRow) {
            case DecodedBatch.KIND_INT, DecodedBatch.KIND_UINT_BITS, DecodedBatch.KIND_FLOAT -> Integer.BYTES;
    @Override  
 * <p>Scope is numeric fixed-width columns. Types the native cursor cannot borrow are rejected when  
            // holds would reach the native side as a backward seek and be rejected.
        // Validate the native cursor's framing before pointing memory views at the borrowed
        decodedBatch = null;
    /**
        }  
        // buffers. reinterpret() is unbounded (it trusts the native address and length), so these
    }
 *
            validityAddr = validityAddrOut.get(ValueLayout.JAVA_LONG, 0);
    }
        }  
            case DecodedBatch.KIND_SHORT, DecodedBatch.KIND_USHORT -> Short.BYTES;  
            MemorySegment valuesAddrOut = out.asSlice(2L * Long.BYTES, Long.BYTES);  
        this.maxBatchSize = maxBatchSize;  
        }  
        long lastRow;
 * <p>{@code scaled_float} needs care because it cannot be rejected here: it is written as a plain
    public void loadBatchContaining(long row) throws IOException {
                return;  
 * reaches this reader.
        }
        if (rc == ParquetCodecBridge.RC_EOF) {
 * <p>This extends {@link NativeHandle}, so the native cursor pointer is tracked in the shared
    /**
            MemorySegment out = arena.allocate(ValueLayout.JAVA_LONG, OUT_PARAM_COUNT);  
     * passes its own store pointer instead.  
        ensureOpen();  
     * native cursor was legitimately told to produce.
        // reinterpreted separately below, outside this arena.
            presenceBitOffset = bitOffset;
        // enough; the borrowed value/validity buffers live in native (Rust-owned) memory and are  
        long handle = ParquetCodecBridge.openColumnCursor(file.toString(), column, initialBatchSize, maxBatchSize, storePtr);
    /** Opens a numeric cursor over a local file, sized from {@code settings}. */
 *  
    private void loadNumericBatch(long row) throws IOException {  
            // The native cursor parks past the resident batch, so re-requesting a row it already  
     * files are on the node's disk. A warm shard's files live in the remote object store and it
    public static ParquetColumnReader open(Path file, String column, int initialBatchSize, int maxBatchSize, long storePtr)  
        if (current != null) {
        }  
     */
     * @param settings index settings, or {@link Settings#EMPTY} to take the defaults
        this.file = file;
            // buffer holds the bits, so a word-rounded view could extend past the allocation.
    }  
 * Numeric column reader backed by a forward-only native Arrow column cursor.
     * Store pointer meaning "read from the local filesystem", which is every hot shard: its Parquet
            valuesAddr = valuesAddrOut.get(ValueLayout.JAVA_LONG, 0);
        }
        // Drop the resident batch before crossing over. A successful native call frees the buffers
            DatafusionSettings.docValuesInitialBatchSize(settings),  
        if (rc != ParquetCodecBridge.RC_OK) {
                valueKindOut
 *
            bitOffset = (int) validityBitOffsetOut.get(ValueLayout.JAVA_LONG, 0);  
 * SPDX-License-Identifier: Apache-2.0
 *  
            MemorySegment validityAddrOut = out.asSlice(3L * Long.BYTES, Long.BYTES);
            DatafusionSettings.docValuesMaxBatchSize(settings),
/*  
            file,
    private static final int OUT_PARAM_COUNT = 6;
 * The OpenSearch Contributors require contributions made to  
        }
        } catch (IOException e) {
    }
     * @param storePtr native object store to read through, or {@link #LOCAL_STORE} for a local file  
        throws IOException {
    @Override
public final class ParquetColumnReader extends NativeHandle implements NumericValueReader {
                lastRowOut,  
            default -> throw contractViolation(row, "unknown value kind " + kind);
        return new IOException(
     * {@code index.parquet.docvalues.max_batch_size}.  
        // the old batch borrowed, so any exit between here and the assignment below - a bad status  
    private DecodedBatch decodedBatch;  
        ParquetCodecBridge.resetColumnCursor(ptr);  
    private final Path file;
    private void reopen() throws IOException {
     * Opens a numeric cursor with explicit window sizes, bypassing settings resolution.  
        }
     * @param initialBatchSize rows in the first decode window; must be in {@code 1..=maxBatchSize}
            throw new IOException("native numeric cursor exhausted before row " + row + " (" + file + "/" + column + ")");
package org.opensearch.be.datafusion.docvalues.bridge;
            case DecodedBatch.KIND_BYTE, DecodedBatch.KIND_UBYTE -> Byte.BYTES;
        return decodedBatch;
                validityAddrOut,
     * resolution.
            kind = (int) valueKindOut.get(ValueLayout.JAVA_LONG, 0);
     * Opens a numeric cursor sized from {@code index.parquet.docvalues.initial_batch_size} and
        int width = widthForKind(kind, row);  
            column,
     */  
import java.lang.foreign.ValueLayout;
 *
 * the cursor is opened, so an unsupported field is unreadable rather than read incorrectly.
import org.opensearch.be.datafusion.DatafusionSettings;
    private void checkStatus(long rc, long row) throws IOException {  
            lastRow = lastRowOut.get(ValueLayout.JAVA_LONG, 0);  
            MemorySegment valueKindOut = out.asSlice(5L * Long.BYTES, Long.BYTES);  
        // The six scalar out-parameters are tiny and read out immediately, so a per-call arena is
    private ParquetColumnReader(long handle, Path file, String column, int maxBatchSize) {
    /**  
        try (Arena arena = Arena.ofConfined()) {
        // or a failed framing check - must not leave a DecodedBatch whose views address freed
            checkStatus(rc, row);  
 *
 */  
        decodedBatch = null;
    /** Byte width of a value KIND, rejecting any kind this reader does not understand. */
    /**
        );  
 *
    /** Opens a numeric cursor over a local file using the default batch-size settings. */  
}
     * touching the cursor, a row ahead of it advances the cursor, and a row behind it reopens the
    public static final long LOCAL_STORE = 0L;
 * {@code half_float} (written as Arrow Float16, which would need a value kind that re-encodes to
     * @param storePtr         native object store to read through, or {@link #LOCAL_STORE} for a local file
    /** Replaces the forward-only cursor with a fresh one at row zero. Only reached on a backward request. */  
    public static ParquetColumnReader open(Path file, String column, int initialBatchSize, int maxBatchSize) throws IOException {
    }
 * {@code HalfFloatPoint.halfFloatToSortableShort}), and {@code scaled_float}.  
 * <p>The native cursor only advances forward. This wrapper still serves a request that falls behind
                firstRowOut,
     */  
import java.io.IOException;
     * @param maxBatchSize     ceiling the adaptive window grows to  
        decodedBatch = new DecodedBatch(firstRow, lastRow, values, kind, presenceBits, presenceBitOffset);
 * this file be licensed under the Apache-2.0 license or a
        DecodedBatch current = decodedBatch;
            "native numeric cursor returned an invalid batch at row " + row + " (" + detail + ") for " + file + "/" + column
            case DecodedBatch.KIND_LONG, DecodedBatch.KIND_DOUBLE -> Long.BYTES;
        try {  
        long batchRowsLong = lastRow - firstRow + 1;
    }
        decodedBatch = null;  
            presenceBitOffset = 0;
        // into buffers the native cursor owns, so it must not stay reachable once those buffers are  
    /**  
                reopen();  
     */
        int batchRows = (int) batchRowsLong;
 * {@code MappedFieldType}, so the field must be excluded where the mapping type is known before it  
    }
        );  
    @Override  
 * is indistinguishable from a long, while OpenSearch doc values hold
import org.apache.logging.log4j.Logger;
    private int widthForKind(int kind, long row) throws IOException {
    private IOException contractViolation(long row, String detail) {  
 * {@code round(value * scaling_factor)}. This reader is given a file and a column name, not a
    public static ParquetColumnReader open(Path file, String column) throws IOException {
 * compatible open source license.
            MemorySegment validityBitOffsetOut = out.asSlice(4L * Long.BYTES, Long.BYTES);
            LOGGER.error("failed to close native column cursor for {}/{}", file, column, e);
        // freed.
import java.lang.foreign.MemorySegment;  
     * Ceiling on the rows the native cursor may return, captured once at open and handed to the
    protected void doClose() {
        return switch (kind) {  
    private static final Logger LOGGER = LogManager.getLogger(ParquetColumnReader.class);
            if (row < current.firstRow()) {
        // and cannot, make a correct-looking but wrong address safe - that is inherent to a
        super(handle);  
            presenceBits = MemorySegment.ofAddress(validityAddr).reinterpret(presenceBytes);
    }
    public static ParquetColumnReader open(Path file, String column, Settings settings) throws IOException {  
        long firstRow;
     * Ensures the resident batch contains {@code row}. A row already resident is served without  
        return open(file, column, settings, LOCAL_STORE);
    }
            throw contractViolation(row, "row range [" + firstRow + ", " + lastRow + "]");
        return open(  
     * cursor is configured once, so re-reading a dynamic setting here could reject a batch the
