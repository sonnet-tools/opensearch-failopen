            this.shardIndexingPressureStore.putAll(shardIndexingPressureStats.shardIndexingPressureStore);  
    @Override  
            this.shardIndexingPressureEnabled = enabled;  
    private final boolean shardIndexingPressureEnforced;  
        this.totalLastSuccessfulRequestLimitsBreachedRejections = totalLastSuccessfulRequestLimitsBreachedRejections;
    private ShardIndexingPressureStats(Builder builder) {
import org.opensearch.core.index.shard.ShardId;
        }  
            this.totalNodeLimitsBreachedRejections = total;  
/*  
        totalLastSuccessfulRequestLimitsBreachedRejections = in.readVLong();
        public Builder shardIndexingPressureEnforced(boolean enforced) {
        private long totalNodeLimitsBreachedRejections = 0;
        }
 */  
     * Builder for the {@link ShardIndexingPressureStats} class.
         * Creates a {@link ShardIndexingPressureStats} object from the builder's current state.
        out.writeBoolean(shardIndexingPressureEnabled);
            this.shardIndexingPressureStore = shardIndexingPressureStore;
            return new ShardIndexingPressureStats(this);
        builder.endObject();
        this.totalLastSuccessfulRequestLimitsBreachedRejections = builder.totalLastSuccessfulRequestLimitsBreachedRejections;
        totalThroughputDegradationLimitsBreachedRejections = in.readVLong();
public class ShardIndexingPressureStats implements Writeable, ToXContentFragment {
    private final boolean shardIndexingPressureEnabled;
    private final long totalLastSuccessfulRequestLimitsBreachedRejections;  
     */
    }
        for (Map.Entry<ShardId, IndexingPressurePerShardStats> entry : shardIndexingPressureStore.entrySet()) {
 * Cumulative shard indexing pressure stats  
 * compatible open source license.
        public Builder() {}
        if (shardIndexingPressureEnforced) {
    /**
     * Private constructor that takes a builder.  
            return this;  
            entry.getValue().toXContent(builder, params);
        builder.field("node_limits", totalNodeLimitsBreachedRejections);
        public Builder totalNodeLimitsBreachedRejections(long total) {
import org.opensearch.core.common.io.stream.StreamInput;
            entry.getValue().writeTo(out);  
        this.shardIndexingPressureStore = builder.shardIndexingPressureStore;
    public static class Builder {
    ) {
        Map<ShardId, IndexingPressurePerShardStats> shardIndexingPressureStore,
     * Provides a fluent API for constructing a ShardIndexingPressureStats object.  
    public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {
        }  
    public ShardIndexingPressureStats(StreamInput in) throws IOException {
        if (this.shardIndexingPressureStore != null) {
        this.totalThroughputDegradationLimitsBreachedRejections = builder.totalThroughputDegradationLimitsBreachedRejections;
import org.opensearch.core.xcontent.ToXContent;  
    private final long totalThroughputDegradationLimitsBreachedRejections;
        out.writeInt(shardIndexingPressureStore.size());  
 * The OpenSearch Contributors require contributions made to  
    @Override
        this.totalThroughputDegradationLimitsBreachedRejections = totalThroughputDegradationLimitsBreachedRejections;
        }
    public IndexingPressurePerShardStats getIndexingPressureShardStats(ShardId shardId) {  
        /**  
 * @opensearch.api
        this.shardIndexingPressureEnabled = shardIndexingPressureEnabled;  
            builder.startObject("total_rejections_breakup");  
 *
        return builder.endObject();
        shardIndexingPressureEnabled = in.readBoolean();  
        boolean shardIndexingPressureEnforced  
     */  
            return this;  
            IndexingPressurePerShardStats shardStats = new IndexingPressurePerShardStats(in);  
        long totalLastSuccessfulRequestLimitsBreachedRejections,  
        shardIndexingPressureEnforced = in.readBoolean();
        private boolean shardIndexingPressureEnforced = false;
    public void addAll(ShardIndexingPressureStats shardIndexingPressureStats) {
        public Builder totalThroughputDegradationLimitsBreachedRejections(long total) {  
        public ShardIndexingPressureStats build() {
        private long totalLastSuccessfulRequestLimitsBreachedRejections = 0;
import java.util.Map;  
    public ShardIndexingPressureStats(  
    }
    private final Map<ShardId, IndexingPressurePerShardStats> shardIndexingPressureStore;
        }  
        builder.endObject();
        }  
        public Builder totalLastSuccessfulRequestLimitsBreachedRejections(long total) {
        private Map<ShardId, IndexingPressurePerShardStats> shardIndexingPressureStore = null;  
import org.opensearch.core.common.io.stream.StreamOutput;  
         */  
        builder.field("throughput_degradation_limits", totalThroughputDegradationLimitsBreachedRejections);  
/**
        this.shardIndexingPressureEnabled = builder.shardIndexingPressureEnabled;  
        }
        long totalNodeLimitsBreachedRejections,
            entry.getKey().writeTo(out);
    /**
        builder.field("enabled", shardIndexingPressureEnabled);
    private final long totalNodeLimitsBreachedRejections;
            this.shardIndexingPressureEnforced = enforced;
        int shardEntries = in.readInt();
        out.writeVLong(totalLastSuccessfulRequestLimitsBreachedRejections);  
import org.opensearch.core.common.io.stream.Writeable;
 */  
        out.writeVLong(totalNodeLimitsBreachedRejections);
        totalNodeLimitsBreachedRejections = in.readVLong();  
        for (Map.Entry<ShardId, IndexingPressurePerShardStats> entry : shardIndexingPressureStore.entrySet()) {
import org.opensearch.core.xcontent.XContentBuilder;
        }
import java.io.IOException;
        builder.field("enforced", shardIndexingPressureEnforced);  
            this.totalLastSuccessfulRequestLimitsBreachedRejections = total;
    }
        builder.field("no_successful_request_limits", totalLastSuccessfulRequestLimitsBreachedRejections);
            this.totalThroughputDegradationLimitsBreachedRejections = total;
        }  
        this.shardIndexingPressureEnforced = builder.shardIndexingPressureEnforced;
    }
        shardIndexingPressureStore = new HashMap<>();  
 * SPDX-License-Identifier: Apache-2.0
import java.util.HashMap;
            shardIndexingPressureStore.put(shardId, shardStats);
            return this;
}  
        out.writeVLong(totalThroughputDegradationLimitsBreachedRejections);
     * This is the sole entry point for creating a new ShardIndexingPressureStats object.
        public Builder shardIndexingPressureEnabled(boolean enabled) {
        }
        out.writeBoolean(shardIndexingPressureEnforced);  
        for (int i = 0; i < shardEntries; i++) {
        }
            return this;
 * this file be licensed under the Apache-2.0 license or a
        builder.startObject("stats");  
        public Builder shardIndexingPressureStore(Map<ShardId, IndexingPressurePerShardStats> shardIndexingPressureStore) {  
            builder.startObject("total_rejections_breakup_shadow_mode");
    /**
 *
        } else {
     * @param builder The builder instance containing all the values.
        boolean shardIndexingPressureEnabled,
@PublicApi(since = "1.3.0")
        long totalThroughputDegradationLimitsBreachedRejections,
        this.totalNodeLimitsBreachedRejections = totalNodeLimitsBreachedRejections;  
import org.opensearch.core.xcontent.ToXContentFragment;
package org.opensearch.index.stats;
     * This constructor will be deprecated starting in version 3.4.0.
        }
    }
         * @return A new ShardIndexingPressureStats instance.
        private long totalThroughputDegradationLimitsBreachedRejections = 0;  
    public void writeTo(StreamOutput out) throws IOException {
        this.shardIndexingPressureEnforced = shardIndexingPressureEnforced;
    }
import org.opensearch.common.annotation.PublicApi;
            ShardId shardId = new ShardId(in);
            return this;
     */
    }
        return shardIndexingPressureStore.get(shardId);
            return this;
        this.totalNodeLimitsBreachedRejections = builder.totalNodeLimitsBreachedRejections;  
        this.shardIndexingPressureStore = shardIndexingPressureStore;
    @Deprecated
        private boolean shardIndexingPressureEnabled = false;
        builder.startObject("shard_indexing_pressure");
     * Use {@link Builder} instead.  
    }
