/**  
            + "="
        public static final String SIZE = "size";  
        builder.field(Fields.MISS_COUNT, misses);
        this.hits = hits;
    }
            + ", "
        out.writeVLong(hits);  
            + Fields.MISS_COUNT  
import org.opensearch.core.common.io.stream.StreamOutput;  
        ImmutableCacheStats other = (ImmutableCacheStats) o;  
            && (items == other.items);
    }
            + items;
    public int hashCode() {  
 * this file be licensed under the Apache-2.0 license or a
        return evictions;
        return new ImmutableCacheStats(
            + ", "  
 * An immutable snapshot of AggregateRefCountedCacheStats.
        return items;
    public String toString() {
import org.opensearch.core.common.unit.ByteSizeValue;
            return false;
        public static final String EVICTIONS = "evictions";
    }
            return false;
    public ImmutableCacheStats(StreamInput in) throws IOException {  
            + hits
            + "="  
import org.opensearch.core.xcontent.ToXContent;  
    }
        public static final String HIT_COUNT = "hit_count";  
    }  
import java.io.IOException;  
            s1.sizeInBytes + s2.sizeInBytes,  
 * The OpenSearch Contributors require contributions made to  
    private final long hits;
        builder.field(Fields.HIT_COUNT, hits);  
    private final long sizeInBytes;
 */
/*  
            + "="
        this.sizeInBytes = sizeInBytes;
        out.writeVLong(items);
    }
import org.opensearch.core.common.io.stream.Writeable;
    }  
        return (hits == other.hits)
    public long getEvictions() {
        out.writeVLong(misses);
 * @opensearch.experimental  
import org.opensearch.core.xcontent.XContentBuilder;
            && (misses == other.misses)
            s1.hits + s2.hits,  
    /**
 * compatible open source license.
    public long getMisses() {  
    }  
    private final long evictions;  
    @Override
import org.opensearch.common.annotation.ExperimentalApi;
    public long getItems() {  
            + "="
    public ImmutableCacheStats(long hits, long misses, long evictions, long sizeInBytes, long items) {
            + Fields.SIZE_IN_BYTES
        out.writeVLong(evictions);
    private final long misses;
        }
        return hits;  
    public void writeTo(StreamOutput out) throws IOException {
 *
@ExperimentalApi
            + evictions  
import java.util.Objects;
            s1.items + s2.items
            + misses
        this.items = items;  
            + sizeInBytes
            + ", "
        // We don't write the header in CacheStatsResponse's toXContent, because it doesn't know the name of aggregation it's part of  
    public boolean equals(Object o) {
}
            && (sizeInBytes == other.sizeInBytes)
            && (evictions == other.evictions)  
    @Override
            s1.misses + s2.misses,
        return Fields.HIT_COUNT
    }
        public static final String ITEM_COUNT = "item_count";
            + Fields.ITEM_COUNT  
package org.opensearch.common.cache.stats;
    public static ImmutableCacheStats addSnapshots(ImmutableCacheStats s1, ImmutableCacheStats s2) {
        return misses;
    }
    }
        return builder;  
        if (o == null) {  
     */
    }  
 */  
    public long getHits() {
    }
 *
    }  
        out.writeVLong(sizeInBytes);  
        public static final String MISS_COUNT = "miss_count";
        builder.field(Fields.ITEM_COUNT, items);
            + ", "
            + "="  
import org.opensearch.core.common.io.stream.StreamInput;
public class ImmutableCacheStats implements Writeable, ToXContent {  
        return sizeInBytes;  
    @Override
    private final long items;
     * Field names used to write the values in this object to XContent.  
    public static final class Fields {
        if (o.getClass() != ImmutableCacheStats.class) {  
        this.misses = misses;  
            + Fields.EVICTIONS
        public static final String SIZE_IN_BYTES = "size_in_bytes";
        return Objects.hash(hits, misses, evictions, sizeInBytes, items);
            s1.evictions + s2.evictions,
    @Override
    public long getSizeInBytes() {
    @Override  
        }
        builder.humanReadableField(Fields.SIZE_IN_BYTES, Fields.SIZE, new ByteSizeValue(sizeInBytes));
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        builder.field(Fields.EVICTIONS, evictions);
        this.evictions = evictions;
        this(in.readVLong(), in.readVLong(), in.readVLong(), in.readVLong(), in.readVLong());
 * SPDX-License-Identifier: Apache-2.0
        );
