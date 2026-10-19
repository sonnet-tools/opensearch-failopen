            pollingIngestStats = in.readOptionalWriteable(PollingIngestStats::new);
    public ShardStats(
/**
    private RetentionLeaseStats retentionLeaseStats;
        commonStats = new CommonStats(in);
    @Nullable
        }
            .endObject();
        }
            return this;
        final CommonStats commonStats,
        final CommitStats commitStats,
        if (retentionLeaseStats != null) {
            pollingIngestStats.toXContent(builder, params);
     */
@PublicApi(since = "1.0.0")
import org.opensearch.common.Nullable;
    }
 * not use this file except in compliance with the License.
 *
        public Builder pollingIngestStats(PollingIngestStats pollingIngestStats) {
    }
    @Nullable
        out.writeBoolean(isCustomDataPath);
        }
 * ownership. Elasticsearch licenses this file to you under
     */
import org.opensearch.core.common.io.stream.StreamOutput;
            return this;
        this.shardRouting = builder.shardRouting;
        static final String SHARD_PATH = "shard_path";
        this.retentionLeaseStats = builder.retentionLeaseStats;
            retentionLeaseStats.toXContent(builder, params);
        static final String ROUTING = "routing";
        private RetentionLeaseStats retentionLeaseStats = null;
        if (pollingIngestStats != null) {
public class ShardStats implements Writeable, ToXContentFragment {
import org.opensearch.common.annotation.PublicApi;
    private CommonStats commonStats;
/*
        private PollingIngestStats pollingIngestStats = null;
        private CommitStats commitStats = null;
        commitStats = CommitStats.readOptionalCommitStatsFrom(in);
        this.dataPath = shardPath.getRootDataPath().toString();
        out.writeOptionalWriteable(commitStats);
 * this file be licensed under the Apache-2.0 license or a
        this.commonStats = builder.commonStats;
    /**
        }
            seqNoStats.toXContent(builder, params);
            out.writeOptionalWriteable(pollingIngestStats);
    public CommitStats getCommitStats() {
     * Use {@link Builder} instead.
        this.isCustomDataPath = builder.shardPath.isCustomDataPath();
    /**
        return retentionLeaseStats;
        this.statePath = builder.shardPath.getRootStatePath().toString();
 *     http://www.apache.org/licenses/LICENSE-2.0
            .field(Fields.STATE, shardRouting.state())
    public SeqNoStats getSeqNoStats() {
        }
        builder.startObject(Fields.ROUTING)
        out.writeOptionalWriteable(retentionLeaseStats);
        this.pollingIngestStats = builder.pollingIngestStats;
        }
import org.opensearch.core.xcontent.ToXContentFragment;
            return this;
        return builder;
        }
    static final class Fields {
    private String statePath;
     * @return the current retention lease stats
        this.retentionLeaseStats = retentionLeaseStats;
        }
        if (out.getVersion().onOrAfter((Version.V_3_0_0))) {
         */
    @Deprecated
        builder.field(Fields.STATE_PATH, statePath);
 * this work for additional information regarding copyright
         * Creates a {@link ShardStats} object from the builder's current state.
 * Unless required by applicable law or agreed to in writing,
        static final String IS_CUSTOM_DATA_PATH = "is_custom_data_path";
        shardRouting = new ShardRouting(in);
 *
    /**
        public Builder seqNoStats(SeqNoStats seqNoStats) {
     * This constructor will be deprecated starting in version 3.4.0.
        this.seqNoStats = builder.seqNoStats;
 * specific language governing permissions and limitations
        private ShardPath shardPath = null;
 */
}
        public Builder() {}
        public Builder shardRouting(ShardRouting shardRouting) {
        public Builder commitStats(CommitStats commitStats) {
    }
            this.shardRouting = shardRouting;
    }
import org.opensearch.index.shard.ShardPath;
        this.shardRouting = routing;
        commonStats.writeTo(out);
    }
/*
     * Gets the current retention lease stats.
            this.retentionLeaseStats = retentionLeaseStats;
    public RetentionLeaseStats getRetentionLeaseStats() {
import org.opensearch.Version;
 * Shard Stats for OpenSearch
            return this;
 */
        private SeqNoStats seqNoStats = null;
    @Nullable
        return this.seqNoStats;
        builder.endObject();
    public static class Builder {
        dataPath = in.readString();
     */
     * Fields for parsing and toXContent
    }
            this.commitStats = commitStats;
         * @return A new ShardStats instance.
    private String dataPath;
            .field(Fields.PRIMARY, shardRouting.primary())
    }
    public void writeTo(StreamOutput out) throws IOException {
    }
    private SeqNoStats seqNoStats;
 * You may obtain a copy of the License at
        if (commitStats != null) {
        shardRouting.writeTo(out);
            .field(Fields.RELOCATING_NODE, shardRouting.relocatingNodeId())
    public ShardRouting getShardRouting() {
        }
        if (in.getVersion().onOrAfter(Version.V_3_0_0)) {
        }
        this.seqNoStats = seqNoStats;
     */
        builder.startObject(Fields.SHARD_PATH);
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.cluster.routing.ShardRouting;
     *
import org.opensearch.index.seqno.RetentionLeaseStats;
        static final String NODE = "node";
 * Licensed to Elasticsearch under one or more contributor
        static final String DATA_PATH = "data_path";
    /**
 * under the License.
 *
            return this;
        isCustomDataPath = in.readBoolean();
        builder.field(Fields.DATA_PATH, dataPath);
        return statePath;
     *
        return isCustomDataPath;
        this.isCustomDataPath = shardPath.isCustomDataPath();
    @Nullable
     * @opensearch.internal
 */
        static final String STATE = "state";
    public boolean isCustomDataPath() {
 * GitHub history for details.
        this.commitStats = commitStats;
        this.commitStats = builder.commitStats;
        public Builder commonStats(CommonStats commonStats) {
        commonStats.toXContent(builder, params);
import org.opensearch.core.common.io.stream.Writeable;
    }
 * The OpenSearch Contributors require contributions made to
        final ShardRouting routing,
     */
import org.opensearch.core.common.io.stream.StreamInput;
            this.pollingIngestStats = pollingIngestStats;
import org.opensearch.core.xcontent.XContentBuilder;
        seqNoStats = in.readOptionalWriteable(SeqNoStats::new);
    @Override
        statePath = in.readString();
    }
    @Nullable
     * @param builder The builder instance containing all the values.
 * license agreements. See the NOTICE file distributed with
    public PollingIngestStats getPollingIngestStats() {
    }
            return this;
        return this.pollingIngestStats;
        private ShardRouting shardRouting = null;
     */
        static final String RELOCATING_NODE = "relocating_node";
        return this.commitStats;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        public Builder retentionLeaseStats(RetentionLeaseStats retentionLeaseStats) {
        /**
    private boolean isCustomDataPath;
    }
    }
    @Nullable
 * @opensearch.api
        }
    ) {
import org.opensearch.index.engine.CommitStats;
        final PollingIngestStats pollingIngestStats
    @Nullable
        return this.shardRouting;
 */
 * SPDX-License-Identifier: Apache-2.0
        builder.field(Fields.IS_CUSTOM_DATA_PATH, isCustomDataPath);
        }
import java.io.IOException;
        static final String STATE_PATH = "state_path";
    }
    /**
            commitStats.toXContent(builder, params);
        this.pollingIngestStats = pollingIngestStats;
    public CommonStats getStats() {
        final RetentionLeaseStats retentionLeaseStats,
        this.statePath = shardPath.getRootStatePath().toString();
        out.writeOptionalWriteable(seqNoStats);
            return this;
        static final String PRIMARY = "primary";
     * Private constructor that takes a builder.
        out.writeString(dataPath);
    public String getStatePath() {
    public ShardStats(StreamInput in) throws IOException {
     * Builder for the {@link ShardStats} class.
 * the Apache License, Version 2.0 (the "License"); you may
    }
        final ShardPath shardPath,
 * KIND, either express or implied.  See the License for the
        public Builder shardPath(ShardPath shardPath) {
package org.opensearch.action.admin.indices.stats;
            .field(Fields.NODE, shardRouting.currentNodeId())
    private ShardStats(Builder builder) {
        retentionLeaseStats = in.readOptionalWriteable(RetentionLeaseStats::new);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.indices.pollingingest.PollingIngestStats;
            this.seqNoStats = seqNoStats;
        return dataPath;
        return this.commonStats;
        private CommonStats commonStats = null;
    private CommitStats commitStats;
/*
        public ShardStats build() {
    private ShardRouting shardRouting;
    }
        this.commonStats = commonStats;
            this.shardPath = shardPath;
        if (seqNoStats != null) {
    @Override
import org.opensearch.index.seqno.SeqNoStats;
 * software distributed under the License is distributed on an
     * Provides a fluent API for constructing a ShardStats object.
            this.commonStats = commonStats;
 * compatible open source license.
        }
        out.writeString(statePath);
        this.dataPath = builder.shardPath.getRootDataPath().toString();
    private PollingIngestStats pollingIngestStats;
 *
            return new ShardStats(this);
     * This is the sole entry point for creating a new ShardStats object.
    public String getDataPath() {
     * The shard routing information (cluster wide shard state).
        }
        final SeqNoStats seqNoStats,
    /**
