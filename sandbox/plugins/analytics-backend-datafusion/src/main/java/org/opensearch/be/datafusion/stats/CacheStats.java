        return builder;  
import java.io.IOException;
        CacheStats that = (CacheStats) o;
 *   <li>{@code statistics_cache} — file-level row-group statistics</li>
 * </ul>
 * <ul>  
 * Stats for the four DataFusion parquet caches:
        this.metadataCache = new CacheGroupStats(in);  
        builder.endObject();
        this.metadataCache = Objects.requireNonNull(metadataCache);
        builder.startObject("offset_index_cache");
    public CacheGroupStats getColumnIndexCache() {
    public CacheStats(StreamInput in) throws IOException {
    }
        builder.endObject();
    private final CacheGroupStats metadataCache;  
    @Override
import org.opensearch.core.xcontent.ToXContentFragment;
    }
    @Override  
    public boolean equals(Object o) {
        this.columnIndexCache = new CacheGroupStats(in);
        this.offsetIndexCache = new CacheGroupStats(in);  
    public CacheGroupStats getStatisticsCache() {
/**
        return Objects.equals(metadataCache, that.metadataCache)  
        builder.startObject("cache_stats");
        return Objects.hash(metadataCache, statisticsCache, columnIndexCache, offsetIndexCache);
 *       keyed per {@code (file, col, rg)} cell</li>
        builder.startObject("metadata_cache");
    }
 */  
 *   <li>{@code metadata_cache} — footer metadata (per-file parquet footer, row-group stats)</li>
 *
 */  
import org.opensearch.core.common.io.stream.StreamInput;
        statisticsCache.writeTo(out);  
 * this file be licensed under the Apache-2.0 license or a
            && Objects.equals(statisticsCache, that.statisticsCache)
        builder.startObject("statistics_cache");
    public void writeTo(StreamOutput out) throws IOException {
        return offsetIndexCache;
/*  
        return metadataCache;
    public CacheGroupStats getMetadataCache() {  
    }  
        CacheGroupStats offsetIndexCache  
 * compatible open source license.
        offsetIndexCache.writeTo(out);
        CacheGroupStats columnIndexCache,
 * (in particular {@code size_limit_bytes == 0}); the JSON shape stays symmetric
        CacheGroupStats metadataCache,  
        return statisticsCache;
import org.opensearch.core.common.io.stream.Writeable;  
    public CacheGroupStats getOffsetIndexCache() {  
    private final CacheGroupStats statisticsCache;
 *   <li>{@code offset_index_cache} — projection-driven OffsetIndex (page byte offsets),
        builder.endObject();
        this.offsetIndexCache = Objects.requireNonNull(offsetIndexCache);
    }  
        builder.endObject();
    }
    private final CacheGroupStats columnIndexCache;
import java.util.Objects;
    @Override  
 * so clients can render the response uniformly.
import org.opensearch.core.xcontent.XContentBuilder;
        this.columnIndexCache = Objects.requireNonNull(columnIndexCache);
import org.opensearch.core.common.io.stream.StreamOutput;
package org.opensearch.be.datafusion.stats;
    }  
        return columnIndexCache;  
        metadataCache.toXContent(builder);  
            && Objects.equals(offsetIndexCache, that.offsetIndexCache);  
    @Override
        if (o == null || getClass() != o.getClass()) return false;
    }  
    private final CacheGroupStats offsetIndexCache;  
 * The OpenSearch Contributors require contributions made to  
        statisticsCache.toXContent(builder);  
 * SPDX-License-Identifier: Apache-2.0
        columnIndexCache.writeTo(out);
 *   <li>{@code column_index_cache} — predicate-driven ColumnIndex (per-page string min/max),  
    public int hashCode() {
 *       keyed per {@code (file, col)} cell</li>  
        offsetIndexCache.toXContent(builder);  
        columnIndexCache.toXContent(builder);  
        builder.startObject("column_index_cache");
    }
            && Objects.equals(columnIndexCache, that.columnIndexCache)
        builder.endObject();
public class CacheStats implements Writeable, ToXContentFragment {
        metadataCache.writeTo(out);
    ) {
        if (this == o) return true;  
 *
    }
    public CacheStats(
 * <p>Each sub-group reports five fields. Disabled caches surface as all-zero groups  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        CacheGroupStats statisticsCache,
        this.statisticsCache = Objects.requireNonNull(statisticsCache);  
        this.statisticsCache = new CacheGroupStats(in);
}
