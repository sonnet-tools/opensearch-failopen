        out.writeLong(metadataActiveInBytes);  
 * <p>The {@code removed} counters track explicit invalidations (e.g. shard deletion
    }
 * compatible open source license.
        out.writeLong(dataEvictions);
 * @opensearch.experimental
 * when the block cache is configured in tiered mode.  
public record BlockCacheTieredStats(long dataHits, long dataMisses, long dataHitBytes, long dataMissBytes, long dataEvictions,
            in.readLong(),
 * via {@code evict_prefix}, prune via {@code clear()}) on each tier independently  
            in.readLong(),
            in.readLong(),
import java.io.IOException;
        builder.field("hit_bytes", metadataHitBytes);  
        builder.field("removed_count", metadataRemoved);  
        out.writeLong(metadataEvictionBytes);
 * within the {@code block_cache} section of the node stats response. Only present
        out.writeLong(dataCapacityBytes);  
}
        builder.field("hit_count", dataHits);
    long metadataHits, long metadataMisses, long metadataHitBytes, long metadataMissBytes, long metadataEvictions,  
        builder.field("miss_count", metadataMisses);
    }
        out.writeLong(metadataHits);
            in.readLong(),
        out.writeLong(dataMissBytes);  
        return builder;  
 * from capacity-driven evictions.
import org.opensearch.core.xcontent.ToXContentFragment;
        builder.field("capacity_in_bytes", dataCapacityBytes);
            in.readLong(),
@ExperimentalApi  
            in.readLong(),
 */  
        builder.field("used_in_bytes", metadataUsedBytes);  
        builder.endObject();
            in.readLong(),  
        out.writeLong(metadataCapacityBytes);
        out.writeLong(metadataRemoved);
        );
 *
        builder.endObject();
            in.readLong()  
 * Per-tier breakdown for tiered block caches (e.g. separate data and metadata SSDs).
            in.readLong(),  
        builder.startObject("data_cache_stats");
    @Override  
        builder.field("active_in_bytes", metadataActiveInBytes);
    long dataEvictionBytes, long dataRemoved, long dataRemovedBytes, long dataUsedBytes, long dataCapacityBytes, long dataActiveInBytes,
import org.opensearch.core.common.io.stream.Writeable;
 * <p>Rendered as {@code data_cache_stats} and {@code metadata_cache_stats} sub-objects
        builder.field("eviction_count", metadataEvictions);
        out.writeLong(metadataEvictions);  
        out.writeLong(dataEvictionBytes);
 * {@link BlockCacheStats} reader; the inner field set defined here was finalized
    public void writeTo(StreamOutput out) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
/*  
        builder.field("evictions_in_bytes", dataEvictionBytes);  
            in.readLong(),
            in.readLong(),
        builder.field("removed_count", dataRemoved);
    @Override
/**
        builder.field("miss_bytes", dataMissBytes);
        out.writeLong(metadataHitBytes);
        builder.field("hit_count", metadataHits);
        out.writeLong(dataRemoved);  
        out.writeLong(metadataRemovedBytes);  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.common.io.stream.StreamOutput;  
    long metadataActiveInBytes) implements Writeable, ToXContentFragment {
import org.opensearch.common.annotation.ExperimentalApi;
            in.readLong(),  
        out.writeLong(dataActiveInBytes);
 *  
import org.opensearch.core.common.io.stream.StreamInput;
            in.readLong(),
 * <p>Wire format is gated at {@link org.opensearch.Version#V_3_8_0} via the outer  
 *  
        this(
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        builder.field("eviction_count", dataEvictions);  
        out.writeLong(metadataMissBytes);
 * this file be licensed under the Apache-2.0 license or a
 */
        builder.field("removed_in_bytes", dataRemovedBytes);
            in.readLong(),
            in.readLong(),
        builder.field("active_in_bytes", dataActiveInBytes);  
            in.readLong(),  
        builder.field("miss_count", dataMisses);  
import org.opensearch.core.xcontent.XContentBuilder;  
            in.readLong(),  
            in.readLong(),  
    }
        out.writeLong(dataHitBytes);
        out.writeLong(dataRemovedBytes);
        builder.startObject("metadata_cache_stats");
        out.writeLong(dataHits);  
package org.opensearch.plugins;
        out.writeLong(dataUsedBytes);
            in.readLong(),
        out.writeLong(metadataUsedBytes);
        builder.field("hit_bytes", dataHitBytes);
        out.writeLong(metadataMisses);  
        builder.field("removed_in_bytes", metadataRemovedBytes);  
            in.readLong(),
 *
        builder.field("miss_bytes", metadataMissBytes);
 *
        builder.field("capacity_in_bytes", metadataCapacityBytes);
            in.readLong(),
 * before the V_3_8_0 release and does not require a separate gate.
    public BlockCacheTieredStats(StreamInput in) throws IOException {
    long metadataEvictionBytes, long metadataRemoved, long metadataRemovedBytes, long metadataUsedBytes, long metadataCapacityBytes,
        out.writeLong(dataMisses);
            in.readLong(),  
        builder.field("evictions_in_bytes", metadataEvictionBytes);
        builder.field("used_in_bytes", dataUsedBytes);
