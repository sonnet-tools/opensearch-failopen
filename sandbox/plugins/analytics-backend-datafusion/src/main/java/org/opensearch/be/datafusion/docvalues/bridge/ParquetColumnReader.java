        MemorySegment values = MemorySegment.ofAddress(valuesAddr).reinterpret((long) batchRows * width);
        );
 * {@code round(value * scaling_factor)}. This reader is given a file and a column name, not a
        }
            MemorySegment valuesAddrOut = out.asSlice(2L * Long.BYTES, Long.BYTES);
     * Opens a numeric cursor sized from {@code index.parquet.docvalues.initial_batch_size} and
/**
        ParquetCodecBridge.resetColumnCursor(ptr);
 *
     * @param initialBatchSize rows in the first decode window; must be in {@code 1..=maxBatchSize}
import org.opensearch.analytics.backend.jni.NativeHandle;
    /**
            case DecodedBatch.KIND_INT, DecodedBatch.KIND_UINT_BITS, DecodedBatch.KIND_FLOAT -> Integer.BYTES;
     * native cursor was legitimately told to produce.
        // enough; the borrowed value/validity buffers live in native (Rust-owned) memory and are
            // The native cursor parks past the resident batch, so re-requesting a row it already
            if (current.contains(row)) {
 * reaches this reader.
        };
        decodedBatch = null;
        }
 *
    @Override
 * SPDX-License-Identifier: Apache-2.0
import java.nio.file.Path;
            LOGGER.error("failed to close native column cursor for {}/{}", file, column, e);
                validityAddrOut,
        throws IOException {
 *
    public static ParquetColumnReader open(Path file, String column, Settings settings) throws IOException {
 * the cursor is opened, so an unsupported field is unreadable rather than read incorrectly.
    }
import java.io.IOException;
        // The six scalar out-parameters are tiny and read out immediately, so a per-call arena is
        return new IOException(
    }
    }
            MemorySegment validityBitOffsetOut = out.asSlice(4L * Long.BYTES, Long.BYTES);
            presenceBits = null;
 * long column ({@code CoreDataFieldPlugin} maps it to {@code LongParquetField}), so on the wire it
            throw contractViolation(row, "values address " + valuesAddr + ", bit offset " + bitOffset);
                valuesAddrOut,
 * <p>Each batch call returns borrowed Arrow buffer addresses; the resident {@link DecodedBatch}
        // Validate the native cursor's framing before pointing memory views at the borrowed
        return decodedBatch;
        return open(file, column, initialBatchSize, maxBatchSize, LOCAL_STORE);
        // buffers. reinterpret() is unbounded (it trusts the native address and length), so these
            );
    public DecodedBatch decodedBatch() {
                firstRowOut,
        long lastRow;
package org.opensearch.be.datafusion.docvalues.bridge;
import org.opensearch.common.settings.Settings;
        try {
        // into buffers the native cursor owns, so it must not stay reachable once those buffers are
 * {@code HalfFloatPoint.halfFloatToSortableShort}), and {@code scaled_float}.
            long rc = ParquetCodecBridge.nextBatch(
            throw new IOException("native numeric cursor exhausted before row " + row + " (" + file + "/" + column + ")");
     * native side in the same call. Deliberately a value rather than a live setting lookup: the
        DecodedBatch current = decodedBatch;
     */
            firstRow = firstRowOut.get(ValueLayout.JAVA_LONG, 0);
            case DecodedBatch.KIND_BYTE, DecodedBatch.KIND_UBYTE -> Byte.BYTES;
    /**
        // checks fail fast on a malformed contract instead of reading out of bounds. They do not,
            }
            "native numeric cursor returned an invalid batch at row " + row + " (" + detail + ") for " + file + "/" + column
     * @param settings index settings, or {@link Settings#EMPTY} to take the defaults
    public static ParquetColumnReader open(Path file, String column, int initialBatchSize, int maxBatchSize) throws IOException {
     * {@code index.parquet.docvalues.max_batch_size}.
    }
 * is indistinguishable from a long, while OpenSearch doc values hold
        }
    }
     * @param storePtr         native object store to read through, or {@link #LOCAL_STORE} for a local file
        // reinterpreted separately below, outside this arena.
 * <p>This extends {@link NativeHandle}, so the native cursor pointer is tracked in the shared
 */
        ensureOpen();
     * Opens a numeric cursor over a local file with explicit window sizes, bypassing settings
    /**
        // batch call on this cursor, which clears the resident batch before borrowing again.
 * whole pages without decoding, which requires a page-index read in both the native cursor and this
     * files are on the node's disk. A warm shard's files live in the remote object store and it
    public static final long LOCAL_STORE = 0L;
    /** Number of scalar out-parameters {@code nextBatch} writes back. */
        }
            long presenceBytes = ((long) bitOffset + batchRows + 7) >>> 3;
import org.apache.logging.log4j.Logger;
            lastRow = lastRowOut.get(ValueLayout.JAVA_LONG, 0);
        }
        return open(file, column, settings, LOCAL_STORE);
            throw new IOException("Unexpected native numeric cursor status " + rc + " at row " + row + " (" + file + "/" + column + ")");
     * Store pointer meaning "read from the local filesystem", which is every hot shard: its Parquet
            file,
        // or a failed framing check - must not leave a DecodedBatch whose views address freed
                ptr,
        // freed.
    private DecodedBatch decodedBatch;
            default -> throw contractViolation(row, "unknown value kind " + kind);
            kind = (int) valueKindOut.get(ValueLayout.JAVA_LONG, 0);
 * forward again, so an ascending walk that occasionally rewinds keeps working.
        long batchRowsLong = lastRow - firstRow + 1;
            presenceBits = MemorySegment.ofAddress(validityAddr).reinterpret(presenceBytes);
 * the current batch by reopening the cursor (cheap, since file metadata is cached) and scanning
            // Size to the bitmap's significant bytes, not up to a word: Arrow only guarantees the
            case DecodedBatch.KIND_LONG, DecodedBatch.KIND_DOUBLE -> Long.BYTES;
    private void loadNumericBatch(long row) throws IOException {
            // A negative status means Rust panicked tearing the cursor down; #[ffm_safe] caught it at
    private void reopen() throws IOException {
            validityAddr = validityAddrOut.get(ValueLayout.JAVA_LONG, 0);
 * <p>Out of scope for this reader: booleans (Arrow packs them bit-wise, so borrowing needs a value
            if (row < current.firstRow()) {
    /**
            checkStatus(rc, row);
            column,
 * <p>The native cursor only advances forward. This wrapper still serves a request that falls behind
     * Opens a numeric cursor with explicit window sizes, bypassing settings resolution.
import org.opensearch.be.datafusion.DatafusionSettings;
        } catch (IOException e) {
    public static ParquetColumnReader open(Path file, String column, Settings settings, long storePtr) throws IOException {
 * <p>The Parquet page index is also not exposed here. A future DocValues skipper needs it to skip
            DatafusionSettings.docValuesMaxBatchSize(settings),
        // memory.
        if (valuesAddr == 0 || bitOffset < 0) {
        );
    /**
    }
     */
            presenceBitOffset = bitOffset;
        // the old batch borrowed, so any exit between here and the assignment below - a bad status
                return;
     * touching the cursor, a row ahead of it advances the cursor, and a row behind it reopens the
    }
     * @param maxBatchSize     ceiling the adaptive window grows to
    }
 * until the next batch call on this reader, which always replaces the batch first.
    }
    /** Opens a numeric cursor over a local file using the default batch-size settings. */
        int batchRows = (int) batchRowsLong;
        int presenceBitOffset;
            throw contractViolation(row, "row range [" + firstRow + ", " + lastRow + "]");
 *
        super(handle);
        long validityAddr;
import java.lang.foreign.ValueLayout;
    /** Byte width of a value KIND, rejecting any kind this reader does not understand. */
        try (Arena arena = Arena.ofConfined()) {
    @Override
 * {@code half_float} (written as Arrow Float16, which would need a value kind that re-encodes to
        loadNumericBatch(row);
            // the boundary. doClose() cannot throw a checked exception, so keep the message here.
        MemorySegment presenceBits;
 * already-closed reader is a no-op and the cursor is freed exactly once.
    private final Path file;
        if (firstRow < 0 || lastRow < firstRow || row < firstRow || row > lastRow) {
        // and cannot, make a correct-looking but wrong address safe - that is inherent to a
        } else {
        int width = widthForKind(kind, row);
                validityBitOffsetOut,
import org.apache.logging.log4j.LogManager;
    public static ParquetColumnReader open(Path file, String column) throws IOException {
            MemorySegment out = arena.allocate(ValueLayout.JAVA_LONG, OUT_PARAM_COUNT);
    /**
        // Drop the resident batch before crossing over. A successful native call frees the buffers
            // buffer holds the bits, so a word-rounded view could extend past the allocation.
 * this file be licensed under the Apache-2.0 license or a
    /** Opens a numeric cursor over a local file, sized from {@code settings}. */
        decodedBatch = null;
        long firstRow;
                row,
        // Drop the resident batch before freeing the cursor: a DecodedBatch holds off-heap views
    private int widthForKind(int kind, long row) throws IOException {
            MemorySegment firstRowOut = out.asSlice(0L, Long.BYTES);
            // holds would reach the native side as a backward seek and be rejected.
                reopen();
    private ParquetColumnReader(long handle, Path file, String column, int maxBatchSize) {
     * @param storePtr native object store to read through, or {@link #LOCAL_STORE} for a local file
            }
    public void loadBatchContaining(long row) throws IOException {
    private void checkStatus(long rc, long row) throws IOException {
    }
     * cursor is configured once, so re-reading a dynamic setting here could reject a batch the
        if (rc != ParquetCodecBridge.RC_OK) {
        return open(file, column, Settings.EMPTY);
     * resolution.
     * Ensures the resident batch contains {@code row}. A row already resident is served without
        }
            throw contractViolation(row, batchRowsLong + " rows exceeds cap " + maxBatchSize);
 *
     * passes its own store pointer instead.
        return new ParquetColumnReader(handle, file, column, maxBatchSize);
    private final int maxBatchSize;
import java.lang.foreign.MemorySegment;
    private final String column;
    public static ParquetColumnReader open(Path file, String column, int initialBatchSize, int maxBatchSize, long storePtr)
        decodedBatch = null;
import java.lang.foreign.Arena;
    @Override
    private static final Logger LOGGER = LogManager.getLogger(ParquetColumnReader.class);
            MemorySegment validityAddrOut = out.asSlice(3L * Long.BYTES, Long.BYTES);
        long handle = ParquetCodecBridge.openColumnCursor(file.toString(), column, initialBatchSize, maxBatchSize, storePtr);
        // zero-copy FFM borrow.
        }
        // Borrowed Arrow buffers, read in place: O(rows accessed), no copy. Valid until the next
        int kind;
    }
     */
            DatafusionSettings.docValuesInitialBatchSize(settings),
 */
     *
        if (rc == ParquetCodecBridge.RC_EOF) {
        this.maxBatchSize = maxBatchSize;
/*
            MemorySegment lastRowOut = out.asSlice(Long.BYTES, Long.BYTES);
                lastRowOut,
    }
     *
            ParquetCodecBridge.closeColumnCursor(ptr);
    }
 * bit offset like the validity bitmap), repeated numerics, binary and keyword columns,
 * live-handle registry, and {@link #close()} is idempotent through the base class: closing an
     */
 * Numeric column reader backed by a forward-only native Arrow column cursor.
            valuesAddr = valuesAddrOut.get(ValueLayout.JAVA_LONG, 0);
    /** Replaces the forward-only cursor with a fresh one at row zero. Only reached on a backward request. */
 * {@code MappedFieldType}, so the field must be excluded where the mapping type is known before it
     * cursor first.
        this.file = file;
    protected void doClose() {
        return open(
 * bridge.
 * <p>{@code scaled_float} needs care because it cannot be rejected here: it is written as a plain
public final class ParquetColumnReader extends NativeHandle implements NumericValueReader {
 * The OpenSearch Contributors require contributions made to
 * points off-heap views at them and reads values in place, with no copy. Those views are valid only
    }
 *
        if (current != null) {
        }
            presenceBitOffset = 0;
    private IOException contractViolation(long row, String detail) {
     */
        return switch (kind) {
        decodedBatch = new DecodedBatch(firstRow, lastRow, values, kind, presenceBits, presenceBitOffset);
            case DecodedBatch.KIND_SHORT, DecodedBatch.KIND_USHORT -> Short.BYTES;
        }
        long valuesAddr;
        this.column = column;
            MemorySegment valueKindOut = out.asSlice(5L * Long.BYTES, Long.BYTES);
                valueKindOut
 * compatible open source license.
        int bitOffset;
 * <p>Scope is numeric fixed-width columns. Types the native cursor cannot borrow are rejected when
        if (validityAddr == 0) {
     */
 *
    private static final int OUT_PARAM_COUNT = 6;
            bitOffset = (int) validityBitOffsetOut.get(ValueLayout.JAVA_LONG, 0);
     * Ceiling on the rows the native cursor may return, captured once at open and handed to the
 *
}
        if (batchRowsLong > maxBatchSize) {
            storePtr
