        }  
        }
    public static NativeAllocatorPoolStats readAndDiscardV3_7(StreamInput in) throws IOException {
            }
    }
import org.opensearch.core.common.io.stream.StreamOutput;  
        public long getPeakBytes() {  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        private final long peakBytes;
        // because individual pool peaks are not additive (they occur at different times).
    /** Returns process-wide native resident bytes (RSS), or -1 if unavailable. */  
package org.opensearch.plugin.stats;
    }  
     * @param nativeAllocatedBytes process-wide native allocated bytes (jemalloc), -1 if unavailable
/**  
            builder.field("min_bytes", minBytes);
        }
 * compatible open source license.
        public PoolStats(String name, long allocatedBytes, long peakBytes, long limitBytes) {
     */  
        public void writeTo(StreamOutput out) throws IOException {  
 * The OpenSearch Contributors require contributions made to  
        builder.startObject("pools");
            return peakBytes;
     * Deserializes from stream.
    private final long nativeAllocatedBytes;
            in.readVLong();   // limitBytes
        }  
import org.opensearch.core.xcontent.XContentBuilder;  
            pool.toXContent(builder, params);
 * and per-pool stats for all registered pools (Arrow and virtual).
        this.nativeResidentBytes = in.readLong();
        return new NativeAllocatorPoolStats(-1L, -1L, List.of());  
            return name;
            out.writeVLong(limitBytes);
    @Override
            this.peakBytes = peakBytes;
        private final long limitBytes;  
        List<PoolStats> list = new ArrayList<>(count);
                new long[] { pool.getAllocatedBytes(), pool.getPeakBytes(), pool.getLimitBytes() },
            out.writeOptionalString(group);
        for (int i = 0; i < count; i++) {
        out.writeLong(nativeResidentBytes);
    }
        in.readVLong(); // rootLimitBytes
        for (PoolStats pool : pools) {  
        }
        private final long minBytes;
    }
        }
     */  
        public String getName() {
        out.writeLong(nativeAllocatedBytes);
            pool.writeTo(out);
    /**  
                g,  
    public long getNativeResidentBytes() {
        return result;  
import java.util.LinkedHashMap;
    }
            out.writeBoolean(true);
public class NativeAllocatorPoolStats implements Writeable, ToXContentFragment {
 *
        }
        out.writeVInt(pools.size());  
            out.writeVLong(stats.nativeAllocatedBytes);  // map to rootAllocatedBytes  
        }  
     */
        this.nativeAllocatedBytes = in.readLong();
            result.put(e.getKey(), new PoolStats(e.getKey(), e.getValue()[0], e.getValue()[1], e.getValue()[2]));
import java.util.ArrayList;  
    @Override  
                builder.field("group", group);
            this.group = in.readOptionalString();
        builder.field("allocated_bytes", nativeAllocatedBytes);
        this.pools = Collections.unmodifiableList(list);
        @Override  
        for (var e : grouped.entrySet()) {  
}
    /**  
            this.name = name;  
    public void writeTo(StreamOutput out) throws IOException {  
            builder.endObject();  
            String g = pool.getGroup() != null ? pool.getGroup() : pool.getName();
    private final List<PoolStats> pools;  
    public Map<String, PoolStats> getGroupedStats() {
        return pools;
     * Returns a dummy instance since the data is discarded.
            out.writeVLong(0L);                          // rootLimitBytes (no equivalent)
import java.util.Map;
                out.writeString(pool.getName());
        for (PoolStats pool : pools) {  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            return allocatedBytes;  
     * Format: optional boolean + 3 VLongs + pool list with 4 fields each.
     * Creates a new stats snapshot.  
            in.readString();  // name
        public PoolStats(String name, long allocatedBytes, long peakBytes, long limitBytes, String group, long minBytes) {
        return nativeAllocatedBytes;  
        Map<String, PoolStats> result = new LinkedHashMap<>();
    }
        public long getAllocatedBytes() {
 * Point-in-time snapshot of native memory statistics for a node.
import java.util.List;  
            out.writeVLong(stats.nativeResidentBytes);   // map to rootPeakBytes
            in.readVLong();   // peakBytes  
    }  
        }
                out.writeVLong(pool.getLimitBytes());
        this.pools = Collections.unmodifiableList(pools);  
            out.writeBoolean(false);  
import java.util.Collections;
            if (group != null) {  
        builder.field("resident_bytes", nativeResidentBytes);  
            this.name = in.readString();  
            builder.field("limit_bytes", limitBytes);
            out.writeVLong(peakBytes);  
    private final long nativeResidentBytes;
            return builder;
        @Override
import org.opensearch.core.xcontent.ToXContentFragment;
 * this file be licensed under the Apache-2.0 license or a
        }  
            this.group = group;
     * BWC: Writes old V_3_7_0 format for a given stats instance (or null).
    public static void writeV3_7(StreamOutput out, @Nullable NativeAllocatorPoolStats stats) throws IOException {
            return limitBytes;
        }
    }  
        } else {
        public long getMinBytes() {  
            out.writeString(name);
        in.readVLong(); // rootAllocatedBytes
        public String getGroup() {
            return minBytes;
        }  
        }
            in.readVLong();   // allocatedBytes
    public static class PoolStats implements Writeable, ToXContentFragment {
    /**
            out.writeVInt(stats.pools.size());  
        this.nativeResidentBytes = nativeResidentBytes;
        return nativeResidentBytes;
    public List<PoolStats> getPools() {  
import org.opensearch.core.common.io.stream.StreamInput;
     * Per-pool statistics snapshot.
        in.readVLong(); // rootPeakBytes  
 *
        int count = in.readVInt();
            this.minBytes = minBytes;
                out.writeVLong(pool.getAllocatedBytes());  
        }
            builder.startObject(name);
    public NativeAllocatorPoolStats(long nativeAllocatedBytes, long nativeResidentBytes, List<PoolStats> pools) {  
        }  
    public long getNativeAllocatedBytes() {
            this.peakBytes = in.readVLong();
        private final long allocatedBytes;
        public long getLimitBytes() {
import org.opensearch.core.common.io.stream.Writeable;
    }
     * @param nativeResidentBytes process-wide native resident bytes (jemalloc RSS), -1 if unavailable  
/*  
        // [allocated, peak, limit] — peak uses max (highest watermark) rather than sum  
        builder.endObject();  
     *
    /** Returns the per-pool statistics. */
 * @opensearch.api  
        }
            );  
 */  
 *
            this.allocatedBytes = in.readVLong();
    /**
        int count = in.readVInt();  
        return builder;
            this(name, allocatedBytes, peakBytes, limitBytes, null, 0L);
            this.limitBytes = in.readVLong();  
        if (stats == null) {
            out.writeVLong(allocatedBytes);
            this.minBytes = in.readVLong();
 * <p>Includes process-wide native memory stats (allocated/resident from jemalloc)  
            this.limitBytes = limitBytes;  
            out.writeVLong(minBytes);  
     */
        this.nativeAllocatedBytes = nativeAllocatedBytes;
     * @param pools per-pool stats (Arrow + virtual)
            grouped.merge(
        }
    /** Returns process-wide native allocated bytes, or -1 if unavailable. */
            builder.field("allocated_bytes", allocatedBytes);  
                out.writeVLong(pool.getPeakBytes());
    /**  
 * SPDX-License-Identifier: Apache-2.0
            this.allocatedBytes = allocatedBytes;
 *
        public PoolStats(StreamInput in) throws IOException {
            list.add(new PoolStats(in));  
        for (PoolStats pool : pools) {
        }
 */
        Map<String, long[]> grouped = new LinkedHashMap<>();
        private final String name;  
import java.io.IOException;
                (a, b) -> new long[] { a[0] + b[0], Math.max(a[1], b[1]), a[2] + b[2] }
    /** Returns stats grouped by pool group. Pools without a group use their name as the key. */
            }  
            return group;  
    }
        private final String group;
import org.opensearch.common.Nullable;
 * <p>Renders as the body of the {@code native_memory} object inside  
     */  
    }
    public NativeAllocatorPoolStats(StreamInput in) throws IOException {  
 * {@code _nodes/stats/native_memory}.
            for (PoolStats pool : stats.pools) {
        for (int i = 0; i < count; i++) {  
     * BWC: Reads and discards the V_3_7_0 format (3 VLongs + pools with 4 fields each).
