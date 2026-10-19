    /** {@link #values} holds one sign-extending {@code short} per row. */  
 * this file be licensed under the Apache-2.0 license or a
    int presenceBitOffset) {
     * byte-addressable, so a wider read could reach past its last significant byte.
        if (presenceBits == null) {
    public long valueAt(long row) {  
            case KIND_DOUBLE -> {
public record DecodedBatch(long firstRow, long lastRow, MemorySegment values, int valueKind, MemorySegment presenceBits,  
        return (bits & (1 << (idx & 7))) != 0;  
    /** {@link #values} holds one sign-extending {@code byte} per row. */
package org.opensearch.be.datafusion.docvalues.bridge;
        long idx = row - firstRow + presenceBitOffset;
        if (contains(row) == false) {
            throw new IndexOutOfBoundsException("row " + row + " outside batch [" + firstRow + ", " + lastRow + "]");
            case KIND_UINT_BITS -> Integer.toUnsignedLong(values.getAtIndex(ValueLayout.JAVA_INT, idx));
            case KIND_USHORT -> Short.toUnsignedLong(values.getAtIndex(ValueLayout.JAVA_SHORT, idx));
 * compatible open source license.
     * {@code floatToSortableInt}, the latter sign-extended) - the encoding OpenSearch's float/double  
    public boolean isPresent(long row) {  
    /** True when the given global row falls within this batch's range. */
 * decoded values and the packed presence bitset. Both views are borrowed Arrow buffers, read with
    public static final int KIND_SHORT = 4;
     * Returns the value at the given global row, which the caller must already have accepted through
            }
import java.lang.foreign.ValueLayout;
        return switch (valueKind) {
 *                          is set when row {@code firstRow + i} is non-null); {@code null} means every row is present  
    public static final int KIND_BYTE = 6;
    public static final int KIND_USHORT = 5;  
/**
     * borrowed buffer: the values segment carries its length, so the access throws instead.
     * {@link #contains} or {@link #isPresent} - unlike those, this does not range-check, to avoid
        byte bits = presenceBits.get(ValueLayout.JAVA_BYTE, idx >>> 3);
     * {@code [firstRow, lastRow]}. Reads a single byte: the bitmap is only guaranteed to be  
     * Constant-time presence test for a global row, which must fall within
 * replaces this batch first. {@link #valueKind} selects the width and sign of the per-row read in
                yield (long) (bits ^ ((bits >> 31) & 0x7fffffff));
    public boolean contains(long row) {
                yield bits ^ ((bits >> 63) & 0x7fffffffffffffffL);  
     * repeating the check on every value read. An out-of-range row still cannot read past the  
    public static final int KIND_LONG = 1;
    }
 * @param presenceBits      off-heap view of the packed presence bitset (bit {@code presenceBitOffset + i}
    public static final int KIND_FLOAT = 9;
 * SPDX-License-Identifier: Apache-2.0
     * kinds sign- or zero-extend the stored width. The float/double kinds re-encode the raw IEEE-754
            return true;
        return row >= firstRow && row <= lastRow;  
    /** {@link #values} holds one zero-extending {@code short} per row. */
 * @param lastRow           inclusive global index of the last row in the batch
            case KIND_BYTE -> values.get(ValueLayout.JAVA_BYTE, idx);
 * {@link #valueAt}.
        };
    /** {@link #values} holds one {@code long} of raw bits per row (i64/u64 bits). */  
    public static final int KIND_INT = 2;  
     */
    /** {@link #values} holds one {@code int} of raw f32 bits per row; re-encoded to a sign-extended sortable int. */
            case KIND_LONG -> values.getAtIndex(ValueLayout.JAVA_LONG, idx);  
/*  
 * @param firstRow          inclusive global index of the first row in the batch
     */
import java.lang.foreign.MemorySegment;
 * <p>Holds the inclusive global row range {@code [firstRow, lastRow]} and off-heap views of the
 * One decoded batch of a numeric Parquet column, read in place.
    /**
}
            case KIND_SHORT -> values.getAtIndex(ValueLayout.JAVA_SHORT, idx);  
    public static final int KIND_DOUBLE = 8;  
    /**  
 * The OpenSearch Contributors require contributions made to  
 * @param values            off-heap view of the decoded values, interpreted according to {@link #valueKind}  
        }  
 * @param valueKind         element interpretation of {@code values}; one of the {@code KIND_*} constants
            case KIND_INT -> values.getAtIndex(ValueLayout.JAVA_INT, idx);
     * <p>The value is returned as a Lucene numeric doc-values {@code long}. Integral  
            default -> throw new IllegalStateException("unknown value kind " + valueKind);  
 */  
            }
     * fielddata reverses with {@code sortableLongToDouble} / {@code sortableIntToFloat}.
                int bits = values.getAtIndex(ValueLayout.JAVA_INT, idx);  
    /** {@link #values} holds one {@code long} of raw f64 bits per row; re-encoded to a Lucene sortable long. */
    /** {@link #values} holds one zero-extending {@code byte} per row. */  
 *
 *  
 */
 * @param presenceBitOffset first presence bit of this batch within {@code presenceBits} (borrowed bitmaps are bit-sliced)
                long bits = values.getAtIndex(ValueLayout.JAVA_LONG, idx);
    /** {@link #values} holds one sign-extending {@code int} per row. */
     *
    }
 * no on-heap copy; they are valid only until the next batch call on the owning cursor, which always  
        }  
        long idx = row - firstRow;
    public static final int KIND_UINT_BITS = 3;
 *  
    }
            case KIND_UBYTE -> Byte.toUnsignedLong(values.get(ValueLayout.JAVA_BYTE, idx));  
            case KIND_FLOAT -> {
     * bits into Lucene's order-preserving "sortable" form ({@code doubleToSortableLong} /
    /** {@link #values} holds one zero-extending {@code int} per row (u32 bits). */
    public static final int KIND_UBYTE = 7;
