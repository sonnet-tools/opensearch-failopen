 * SPDX-License-Identifier: Apache-2.0
     * @throws IOException if deserialization fails
     * @param builder the XContent builder to write to
    public CacheGroupStats(StreamInput in) throws IOException {  
 * this file be licensed under the Apache-2.0 license or a
    }  
            && sizeLimitBytes == that.sizeLimitBytes;
    /**
    public final long hitCount;  
    /** Configured byte cap. Zero means the cache is disabled. */
 *
import org.opensearch.core.common.io.stream.StreamOutput;
     *  
    /** Bytes currently held by the cache (point-in-time). */
import org.opensearch.core.common.io.stream.Writeable;  
        this.memoryBytes = in.readVLong();
        return hitCount == that.hitCount
        if (o == null || getClass() != o.getClass()) return false;
    }
     * Construct from explicit field values.
        builder.field("hit_rate", hitRate());
    public void writeTo(StreamOutput out) throws IOException {  
 */  
        return total == 0 ? 0.0 : (double) hitCount / (double) total;
 * point-in-time entry count, memory consumption, and configured size limit.
    public CacheGroupStats(long hitCount, long missCount, long entryCount, long memoryBytes, long sizeLimitBytes) {
    /** Number of entries currently held (point-in-time). */  
        return Objects.hash(hitCount, missCount, entryCount, memoryBytes, sizeLimitBytes);
import java.io.IOException;  
    public final long sizeLimitBytes;
        this.entryCount = entryCount;
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.be.datafusion.stats;
            && missCount == that.missCount
        this.memoryBytes = memoryBytes;
        builder.field("size_limit_bytes", sizeLimitBytes);
     */
        this.hitCount = in.readVLong();
        out.writeVLong(hitCount);
import org.opensearch.core.xcontent.XContentBuilder;
     *
    @Override
    public int hashCode() {  
import java.util.Objects;
    @Override
    public final long memoryBytes;  
 *  
     * @param sizeLimitBytes configured byte cap (0 means disabled)
/*  
    /** Cumulative {@code get()} calls that returned no entry. */
        out.writeVLong(memoryBytes);
        builder.field("hit_count", hitCount);  
    @Override
            && memoryBytes == that.memoryBytes
        this.sizeLimitBytes = in.readVLong();
    }  
        out.writeVLong(sizeLimitBytes);
        builder.field("entry_count", entryCount);  
 * the corresponding cache is disabled rather than merely idle.
 * <p>{@code hit_rate} is computed at render time and is not part of the wire layout.
        if (this == o) return true;
 * <p>An "all zero" instance (in particular {@code size_limit_bytes == 0}) means
 * compatible open source license.
        this.entryCount = in.readVLong();  
 *  
    public boolean equals(Object o) {  
            && entryCount == that.entryCount  
    public final long entryCount;
    }  
/**  
        this.missCount = in.readVLong();
 */
    }
        this.hitCount = hitCount;
    }  
    public final long missCount;
}  
public class CacheGroupStats implements Writeable {  
     * @param missCount      cumulative gets that returned no entry
    /** Cumulative successful {@code get()} calls. */
        CacheGroupStats that = (CacheGroupStats) o;  
import org.opensearch.core.common.io.stream.StreamInput;
    /**
        out.writeVLong(missCount);
        this.missCount = missCount;  
    public void toXContent(XContentBuilder builder) throws IOException {
        builder.field("memory_bytes", memoryBytes);
     * @param entryCount     entries currently held  
        out.writeVLong(entryCount);  
    /** Returns {@code hits / (hits + misses)}; {@code 0.0} when the cache has had no traffic. */
        long total = hitCount + missCount;
    public double hitRate() {  
     * @throws IOException if writing fails  
        builder.field("miss_count", missCount);
 * Per-cache observability counters: cumulative hit/miss totals plus
     *
        this.sizeLimitBytes = sizeLimitBytes;  
     */
     * Render the 5 wire fields plus the derived {@code hit_rate} as snake_case JSON fields.  
     * @param memoryBytes    bytes currently held
     * @param hitCount       cumulative successful gets
     * Deserialize from stream.
    /**  
    }  
     */  
     * @param in the stream input  
