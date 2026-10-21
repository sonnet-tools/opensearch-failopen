        out.writeLong(nativeAllocatedBytes);
 */
        }
        return nativeResidentBytes;
import org.opensearch.core.common.io.stream.StreamOutput;
        this.pools = Collections.unmodifiableList(list);
            out.writeVLong(limitBytes);
     * BWC: Writes old V_3_7_0 format for a given stats instance (or null).
        if (stats == null) {
                out.writeString(pool.getName());
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        int count = in.readVInt();
    }
        for (PoolStats pool : pools) {
        in.readVLong(); // rootAllocatedBytes
    }
package org.opensearch.plugin.stats;
        }
    /** Returns process-wide native allocated bytes, or -1 if unavailable. */
        this.nativeAllocatedBytes = in.readLong();
            in.readVLong();   // limitBytes
        this.pools = Collections.unmodifiableList(pools);
            out.writeVLong(stats.nativeResidentBytes);   // map to rootPeakBytes
            in.readString();  // name
        this.nativeResidentBytes = nativeResidentBytes;
        builder.startObject("pools");
    }
        Map<String, long[]> grouped = new LinkedHashMap<>();
        builder.endObject();
 * compatible open source license.
import java.util.Map;
     * Creates a new stats snapshot.
import java.io.IOException;
        in.readVLong(); // rootLimitBytes
            return builder;
     * Format: optional boolean + 3 VLongs + pool list with 4 fields each.
            if (group != null) {
        public long getLimitBytes() {
 *
    @Override
     * @param nativeAllocatedBytes process-wide native allocated bytes (jemalloc), -1 if unavailable
        }
        out.writeLong(nativeResidentBytes);
 * Point-in-time snapshot of native memory statistics for a node.
        this.nativeResidentBytes = in.readLong();
            String g = pool.getGroup() != null ? pool.getGroup() : pool.getName();
        for (int i = 0; i < count; i++) {
            return minBytes;
            return name;
 */
        public String getName() {
    public NativeAllocatorPoolStats(StreamInput in) throws IOException {
            builder.endObject();
                (a, b) -> new long[] { a[0] + b[0], Math.max(a[1], b[1]), a[2] + b[2] }
    public long getNativeAllocatedBytes() {
            out.writeBoolean(true);
        }
            out.writeVLong(stats.nativeAllocatedBytes);  // map to rootAllocatedBytes
    /**
            return allocatedBytes;
            pool.writeTo(out);
            builder.startObject(name);
                out.writeVLong(pool.getAllocatedBytes());
import org.opensearch.core.common.io.stream.Writeable;
        for (int i = 0; i < count; i++) {
 * <p>Includes process-wide native memory stats (allocated/resident from jemalloc)
}
    /** Returns process-wide native resident bytes (RSS), or -1 if unavailable. */
            this.name = in.readString();
     * BWC: Reads and discards the V_3_7_0 format (3 VLongs + pools with 4 fields each).
 * this file be licensed under the Apache-2.0 license or a
 *
     */
     *
     */
    }
        }
        // [allocated, peak, limit] — peak uses max (highest watermark) rather than sum
        int count = in.readVInt();
    /** Returns stats grouped by pool group. Pools without a group use their name as the key. */
            return group;
        }
            pool.toXContent(builder, params);
            result.put(e.getKey(), new PoolStats(e.getKey(), e.getValue()[0], e.getValue()[1], e.getValue()[2]));
import java.util.List;
        }
        private final long minBytes;
        in.readVLong(); // rootPeakBytes
        this.nativeAllocatedBytes = nativeAllocatedBytes;
     * Per-pool statistics snapshot.
     */
 * <p>Renders as the body of the {@code native_memory} object inside
    }
            in.readVLong();   // allocatedBytes
    public long getNativeResidentBytes() {
import java.util.ArrayList;
            }
    /**
    public Map<String, PoolStats> getGroupedStats() {
     * @param nativeResidentBytes process-wide native resident bytes (jemalloc RSS), -1 if unavailable
     */
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
     * Returns a dummy instance since the data is discarded.
import org.opensearch.core.common.io.stream.StreamInput;
            in.readVLong();   // peakBytes
            grouped.merge(
        private final long limitBytes;
        }
public class NativeAllocatorPoolStats implements Writeable, ToXContentFragment {
        private final long allocatedBytes;
            out.writeVInt(stats.pools.size());
 *
            this.allocatedBytes = in.readVLong();
            for (PoolStats pool : stats.pools) {
        public long getMinBytes() {
            this.peakBytes = in.readVLong();
        public PoolStats(StreamInput in) throws IOException {
    }
    private final List<PoolStats> pools;
        Map<String, PoolStats> result = new LinkedHashMap<>();
        }
            this.allocatedBytes = allocatedBytes;
    }
            out.writeBoolean(false);
            builder.field("allocated_bytes", allocatedBytes);
    /**
    private final long nativeAllocatedBytes;
        private final String group;
        }
            this(name, allocatedBytes, peakBytes, limitBytes, null, 0L);
        private final long peakBytes;
        // because individual pool peaks are not additive (they occur at different times).
    public static class PoolStats implements Writeable, ToXContentFragment {
        public long getAllocatedBytes() {
        }
        return nativeAllocatedBytes;
 * and per-pool stats for all registered pools (Arrow and virtual).
        }
    }
            this.name = name;
        out.writeVInt(pools.size());
        return result;
            builder.field("limit_bytes", limitBytes);
            this.limitBytes = limitBytes;
    private final long nativeResidentBytes;
            }
            this.limitBytes = in.readVLong();
    public static NativeAllocatorPoolStats readAndDiscardV3_7(StreamInput in) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
            out.writeVLong(minBytes);
        public PoolStats(String name, long allocatedBytes, long peakBytes, long limitBytes, String group, long minBytes) {
    /** Returns the per-pool statistics. */
     */
            out.writeVLong(allocatedBytes);
    }
                builder.field("group", group);
        for (PoolStats pool : pools) {
 * @opensearch.api
        return builder;
        private final String name;
        List<PoolStats> list = new ArrayList<>(count);
     * Deserializes from stream.
                new long[] { pool.getAllocatedBytes(), pool.getPeakBytes(), pool.getLimitBytes() },
            return peakBytes;
        public PoolStats(String name, long allocatedBytes, long peakBytes, long limitBytes) {
        public String getGroup() {
        }
        public void writeTo(StreamOutput out) throws IOException {
        @Override
    public void writeTo(StreamOutput out) throws IOException {
        } else {
            this.minBytes = minBytes;
        for (PoolStats pool : pools) {
            builder.field("min_bytes", minBytes);
    @Override
import java.util.Collections;
        builder.field("resident_bytes", nativeResidentBytes);
import java.util.LinkedHashMap;
    /**
    public static void writeV3_7(StreamOutput out, @Nullable NativeAllocatorPoolStats stats) throws IOException {
/*
        }
                out.writeVLong(pool.getPeakBytes());
            return limitBytes;
            out.writeVLong(0L);                          // rootLimitBytes (no equivalent)
        }
 * {@code _nodes/stats/native_memory}.
        public long getPeakBytes() {
        for (var e : grouped.entrySet()) {
    }
        return new NativeAllocatorPoolStats(-1L, -1L, List.of());
            );
            this.group = in.readOptionalString();
 *
/**
 * The OpenSearch Contributors require contributions made to
                g,
    public List<PoolStats> getPools() {
        builder.field("allocated_bytes", nativeAllocatedBytes);
    /**
            out.writeOptionalString(group);
        }
            this.group = group;
    public NativeAllocatorPoolStats(long nativeAllocatedBytes, long nativeResidentBytes, List<PoolStats> pools) {
    }
            this.peakBytes = peakBytes;
import org.opensearch.core.xcontent.ToXContentFragment;
        }
            out.writeVLong(peakBytes);
        }
            list.add(new PoolStats(in));
        @Override
            out.writeString(name);
import org.opensearch.common.Nullable;
                out.writeVLong(pool.getLimitBytes());
            this.minBytes = in.readVLong();
     * @param pools per-pool stats (Arrow + virtual)
        return pools;
import org.opensearch.core.xcontent.XContentBuilder;
