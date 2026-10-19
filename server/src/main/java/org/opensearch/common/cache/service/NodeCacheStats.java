public class NodeCacheStats implements ToXContentFragment, Writeable {
    public NodeCacheStats(SortedMap<CacheType, ImmutableCacheStatsHolder> statsByCache, CommonStatsFlags flags) {  
/**
        flags.writeTo(out);  
import org.opensearch.core.common.io.stream.StreamInput;  
        return statsByCache.get(cacheType);
        }
    public boolean equals(Object o) {
        return builder;  
    @Override  
}
 * A class creating XContent responses to cache stats API requests.
        for (CacheType type : statsByCache.keySet()) {
        }
import org.opensearch.common.cache.CacheType;
        this.flags = new CommonStatsFlags(in);  
 */
        builder.endObject();
                builder.startObject(type.getValue());  
    }
 *  
@ExperimentalApi  
    }  
        }
 * The OpenSearch Contributors require contributions made to  
                builder.endObject();
        this.statsByCache = statsByCache;
        return Objects.hash(statsByCache, flags);
            return false;  
import java.util.SortedMap;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.common.io.stream.Writeable;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.core.xcontent.XContentBuilder;
        this.flags = flags;
    // Get the immutable cache stats for a given cache, used to avoid having to process XContent in tests.
    }  
    public ImmutableCacheStatsHolder getStatsByCache(CacheType cacheType) {
import java.io.IOException;  
        if (o == null) {
            if (flags.getIncludeCaches().contains(type)) {
        NodeCacheStats other = (NodeCacheStats) o;
    @Override  
import org.opensearch.common.annotation.ExperimentalApi;  
package org.opensearch.common.cache.service;
 * compatible open source license.
            }  
    // Safe to expose publicly as the ImmutableCacheStatsHolder can't be modified after its creation.  
/*  
    @Override
 *
            return false;  
    private final CommonStatsFlags flags;
    }
 * @opensearch.experimental
    @Override
    }
    }
import org.opensearch.core.common.io.stream.StreamOutput;
                statsByCache.get(type).toXContent(builder, params);
    private final SortedMap<CacheType, ImmutableCacheStatsHolder> statsByCache;  
        if (o.getClass() != NodeCacheStats.class) {
        builder.startObject(NodesStatsRequest.Metric.CACHE_STATS.metricName());  
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;
    public NodeCacheStats(StreamInput in) throws IOException {
        return statsByCache.equals(other.statsByCache) && flags.getIncludeCaches().equals(other.flags.getIncludeCaches());  
        out.writeMap(statsByCache, StreamOutput::writeEnum, (o, immutableCacheStatsHolder) -> immutableCacheStatsHolder.writeTo(o));
import org.opensearch.common.cache.stats.ImmutableCacheStatsHolder;
import java.util.Objects;
    // Use SortedMap to force consistent ordering of caches in API responses
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;
 * SPDX-License-Identifier: Apache-2.0
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.core.xcontent.ToXContentFragment;  
        this.statsByCache = in.readOrderedMap(i -> i.readEnum(CacheType.class), ImmutableCacheStatsHolder::new);
    public int hashCode() {
    }  
 */  
