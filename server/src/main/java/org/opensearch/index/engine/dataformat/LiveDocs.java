            return ALL_ALIVE;
/**
    /**
package org.opensearch.index.engine.dataformat;
 * Consumers use this at read time (to filter scan results) and at merge time
 * <p>The internal representation uses Lucene's {@code FixedBitSet#getBits()} layout
        return perSegment.get(segmentGeneration);
     * @return a new LiveDocs instance
}
            return true; // no deletes in this segment  
 * Format-neutral per-segment live-docs abstraction.
        return perSegment.isEmpty();  
        if (rawBitsets == null || rawBitsets.isEmpty()) {
    public boolean allAlive() {
    public boolean isAlive(long segmentGeneration, long rowId) {  
        return perSegment.size();  
    public boolean allAlive(long segmentGeneration) {
     * Returns the raw packed bitset for a segment, for FFI-friendly consumers (e.g., Rust via JNI).
        Map<Long, long[]> copy = new HashMap<>(rawBitsets.size());
     * Returns true if all rows in all segments are alive (no deletes anywhere).  
        return (bits[wordIdx] & (1L << bitIdx)) != 0;
     */  
    /**
 * interact through the typed API without knowing the wire format.
     * Returns null if all rows in the segment are alive.  
import org.opensearch.common.annotation.ExperimentalApi;
        long[] bits = perSegment.get(segmentGeneration);
    }  
    }
    /**  
     * Creates a LiveDocs instance from raw per-segment bitsets.  
     *
        }  
        long bitIdx = rowId % 64;  
        if (wordIdx >= bits.length) {
     *
     */
        return new LiveDocs(Collections.unmodifiableMap(copy));
    }
     * @param segmentGeneration the segment generation  
        }
        this.perSegment = perSegment;
    private LiveDocs(Map<Long, long[]> perSegment) {
 * this file be licensed under the Apache-2.0 license or a
     * Returns the number of segments that have deletes.  
 *
     *
    /** Singleton representing "all rows alive everywhere" — no filtering needed. */
    }  
    public int segmentsWithDeletes() {
     * @param rowId the row ID within the segment
     */
    public static LiveDocs fromPackedBits(Map<Long, long[]> rawBitsets) {  
     * @param rawBitsets map of segment generation → packed bitset (Lucene layout)  
            copy.put(entry.getKey(), entry.getValue().clone());  
import java.util.Collections;  
        }
 */  
    }  
    /**  
 * compatible open source license.
     */
 * (packed {@code long[]} where bit {@code i} set = row {@code i} alive), but consumers  
     */
            return true; // beyond bitset — defensive
    public static final LiveDocs ALL_ALIVE = new LiveDocs(Collections.emptyMap());  
import java.util.HashMap;
        if (bits == null) {
     */
 * The OpenSearch Contributors require contributions made to  
 * <p>Wraps a per-segment bitset indicating which rows are alive (not deleted).
    }
        return !perSegment.containsKey(segmentGeneration);  
        for (Map.Entry<Long, long[]> entry : rawBitsets.entrySet()) {
     * Returns true if the row at the given ID in the given segment is alive.
 */
 * SPDX-License-Identifier: Apache-2.0
 *
    /**
import java.util.Map;
 *  
    /**
 * @opensearch.experimental  
     *
 * (to drop dead rows from the output).  
     * Returns true if all rows in the given segment are alive.
public final class LiveDocs {  
     * @param segmentGeneration the segment generation
@ExperimentalApi
     * Defensively clones each array to prevent aliasing.
     * @param segmentGeneration the segment generation  
/*  
        int wordIdx = (int) (rowId / 64);
        }  
    private final Map<Long, long[]> perSegment;
 *
    public long[] packedBits(long segmentGeneration) {
    }
