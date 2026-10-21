        private Map<ShardId, IndexingPressurePerShardStats> shardIndexingPressureStore = null;
            this.totalThroughputDegradationLimitsBreachedRejections = total;
import org.opensearch.core.xcontent.XContentBuilder;
            return this;
        this.totalThroughputDegradationLimitsBreachedRejections = builder.totalThroughputDegradationLimitsBreachedRejections;
        }
        }
import org.opensearch.core.index.shard.ShardId;
    private final long totalLastSuccessfulRequestLimitsBreachedRejections;
        }
        builder.startObject("stats");
        this.totalThroughputDegradationLimitsBreachedRejections = totalThroughputDegradationLimitsBreachedRejections;
            entry.getKey().writeTo(out);
        this.totalNodeLimitsBreachedRejections = builder.totalNodeLimitsBreachedRejections;
        totalLastSuccessfulRequestLimitsBreachedRejections = in.readVLong();
        long totalNodeLimitsBreachedRejections,
    }
        private long totalThroughputDegradationLimitsBreachedRejections = 0;
        shardIndexingPressureStore = new HashMap<>();
        builder.endObject();
        private boolean shardIndexingPressureEnforced = false;
    private final boolean shardIndexingPressureEnabled;
        this.totalLastSuccessfulRequestLimitsBreachedRejections = totalLastSuccessfulRequestLimitsBreachedRejections;
        int shardEntries = in.readInt();
        this.shardIndexingPressureEnabled = builder.shardIndexingPressureEnabled;
        private long totalNodeLimitsBreachedRejections = 0;
            ShardId shardId = new ShardId(in);
        for (int i = 0; i < shardEntries; i++) {
     * This is the sole entry point for creating a new ShardIndexingPressureStats object.
        public ShardIndexingPressureStats build() {
        }
     * This constructor will be deprecated starting in version 3.4.0.
    }
        public Builder shardIndexingPressureEnforced(boolean enforced) {
@PublicApi(since = "1.3.0")
            entry.getValue().toXContent(builder, params);
    public void writeTo(StreamOutput out) throws IOException {
}
        builder.field("node_limits", totalNodeLimitsBreachedRejections);
            return this;
 * Cumulative shard indexing pressure stats
        this.totalLastSuccessfulRequestLimitsBreachedRejections = builder.totalLastSuccessfulRequestLimitsBreachedRejections;
        boolean shardIndexingPressureEnforced
/*
        return shardIndexingPressureStore.get(shardId);
    public ShardIndexingPressureStats(
    }
        for (Map.Entry<ShardId, IndexingPressurePerShardStats> entry : shardIndexingPressureStore.entrySet()) {
    /**
            shardIndexingPressureStore.put(shardId, shardStats);
     * Builder for the {@link ShardIndexingPressureStats} class.
            this.totalLastSuccessfulRequestLimitsBreachedRejections = total;
    @Deprecated
        public Builder shardIndexingPressureStore(Map<ShardId, IndexingPressurePerShardStats> shardIndexingPressureStore) {
    public static class Builder {
        }
        out.writeVLong(totalNodeLimitsBreachedRejections);
            return this;
        public Builder shardIndexingPressureEnabled(boolean enabled) {
        shardIndexingPressureEnabled = in.readBoolean();
        }
         */
        }
            entry.getValue().writeTo(out);
import org.opensearch.core.common.io.stream.StreamInput;
    private final long totalThroughputDegradationLimitsBreachedRejections;
import java.util.Map;
            this.shardIndexingPressureStore = shardIndexingPressureStore;
        private boolean shardIndexingPressureEnabled = false;
 * @opensearch.api
    public IndexingPressurePerShardStats getIndexingPressureShardStats(ShardId shardId) {
     */
        } else {
        public Builder totalThroughputDegradationLimitsBreachedRejections(long total) {
        out.writeVLong(totalThroughputDegradationLimitsBreachedRejections);
    }
            return this;
    /**
        builder.field("no_successful_request_limits", totalLastSuccessfulRequestLimitsBreachedRejections);
 * SPDX-License-Identifier: Apache-2.0
        public Builder totalNodeLimitsBreachedRejections(long total) {
        out.writeBoolean(shardIndexingPressureEnforced);
        private long totalLastSuccessfulRequestLimitsBreachedRejections = 0;
        this.shardIndexingPressureEnabled = shardIndexingPressureEnabled;
        }
        this.shardIndexingPressureStore = shardIndexingPressureStore;
    ) {
        for (Map.Entry<ShardId, IndexingPressurePerShardStats> entry : shardIndexingPressureStore.entrySet()) {
import org.opensearch.common.annotation.PublicApi;
 */
        out.writeVLong(totalLastSuccessfulRequestLimitsBreachedRejections);
        boolean shardIndexingPressureEnabled,
    public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {
        return builder.endObject();
 * compatible open source license.
        if (this.shardIndexingPressureStore != null) {
        builder.field("enabled", shardIndexingPressureEnabled);
    /**
    private final boolean shardIndexingPressureEnforced;
        this.shardIndexingPressureStore = builder.shardIndexingPressureStore;
 */
        Map<ShardId, IndexingPressurePerShardStats> shardIndexingPressureStore,
         * @return A new ShardIndexingPressureStats instance.
        out.writeBoolean(shardIndexingPressureEnabled);
     * Provides a fluent API for constructing a ShardIndexingPressureStats object.
        builder.startObject("shard_indexing_pressure");
            this.totalNodeLimitsBreachedRejections = total;
        long totalThroughputDegradationLimitsBreachedRejections,
        totalNodeLimitsBreachedRejections = in.readVLong();
        out.writeInt(shardIndexingPressureStore.size());
            this.shardIndexingPressureEnforced = enforced;
            return this;
import java.util.HashMap;
        if (shardIndexingPressureEnforced) {
import java.io.IOException;
        totalThroughputDegradationLimitsBreachedRejections = in.readVLong();
package org.opensearch.index.stats;
    public ShardIndexingPressureStats(StreamInput in) throws IOException {
    }
/**
        }
        builder.field("enforced", shardIndexingPressureEnforced);
     */
         * Creates a {@link ShardIndexingPressureStats} object from the builder's current state.
            builder.startObject("total_rejections_breakup_shadow_mode");
            this.shardIndexingPressureStore.putAll(shardIndexingPressureStats.shardIndexingPressureStore);
        this.shardIndexingPressureEnforced = builder.shardIndexingPressureEnforced;
        }
 * The OpenSearch Contributors require contributions made to
    private ShardIndexingPressureStats(Builder builder) {
    @Override
    }
        /**
     * @param builder The builder instance containing all the values.
            IndexingPressurePerShardStats shardStats = new IndexingPressurePerShardStats(in);
    }
 *
    private final long totalNodeLimitsBreachedRejections;
        this.shardIndexingPressureEnforced = shardIndexingPressureEnforced;
    public void addAll(ShardIndexingPressureStats shardIndexingPressureStats) {
        long totalLastSuccessfulRequestLimitsBreachedRejections,
public class ShardIndexingPressureStats implements Writeable, ToXContentFragment {
     * Use {@link Builder} instead.
    @Override
     */
    private final Map<ShardId, IndexingPressurePerShardStats> shardIndexingPressureStore;
import org.opensearch.core.common.io.stream.Writeable;
import org.opensearch.core.xcontent.ToXContentFragment;
            builder.startObject("total_rejections_breakup");
        public Builder totalLastSuccessfulRequestLimitsBreachedRejections(long total) {
        builder.endObject();
    }
        this.totalNodeLimitsBreachedRejections = totalNodeLimitsBreachedRejections;
        shardIndexingPressureEnforced = in.readBoolean();
import org.opensearch.core.xcontent.ToXContent;
            return this;
        }
            return new ShardIndexingPressureStats(this);
            this.shardIndexingPressureEnabled = enabled;
        builder.field("throughput_degradation_limits", totalThroughputDegradationLimitsBreachedRejections);
import org.opensearch.core.common.io.stream.StreamOutput;
 * this file be licensed under the Apache-2.0 license or a
     * Private constructor that takes a builder.
 *
        }
        public Builder() {}
