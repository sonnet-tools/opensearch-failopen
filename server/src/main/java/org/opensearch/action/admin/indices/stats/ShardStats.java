        this.retentionLeaseStats = retentionLeaseStats;
    }
        }  
package org.opensearch.action.admin.indices.stats;
        if (out.getVersion().onOrAfter((Version.V_3_0_0))) {
        }
    public String getDataPath() {
        }
        return this.shardRouting;
        return dataPath;  
        builder.field(Fields.IS_CUSTOM_DATA_PATH, isCustomDataPath);
     * @return the current retention lease stats  
 * ownership. Elasticsearch licenses this file to you under  
/*
        static final String SHARD_PATH = "shard_path";  
        }
    /**  
        shardRouting = new ShardRouting(in);
            .field(Fields.RELOCATING_NODE, shardRouting.relocatingNodeId())
        }
        static final String RELOCATING_NODE = "relocating_node";  
    @Override
 * specific language governing permissions and limitations
        this.pollingIngestStats = builder.pollingIngestStats;  
    @Nullable  
    public CommonStats getStats() {
        shardRouting.writeTo(out);  
        this.commitStats = commitStats;
 * this work for additional information regarding copyright
        public Builder pollingIngestStats(PollingIngestStats pollingIngestStats) {
    public ShardStats(
        }
        static final String NODE = "node";
        /**
        }
     * Private constructor that takes a builder.
     * Provides a fluent API for constructing a ShardStats object.
            retentionLeaseStats.toXContent(builder, params);  
        commitStats = CommitStats.readOptionalCommitStatsFrom(in);  
 */
        this.commonStats = commonStats;  
        this.shardRouting = routing;
        public Builder commonStats(CommonStats commonStats) {  
        this.shardRouting = builder.shardRouting;
            return this;
            return new ShardStats(this);  
        seqNoStats = in.readOptionalWriteable(SeqNoStats::new);
        static final String STATE = "state";
        return this.seqNoStats;  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 * Licensed to Elasticsearch under one or more contributor  
        if (seqNoStats != null) {
        if (in.getVersion().onOrAfter(Version.V_3_0_0)) {  
            this.pollingIngestStats = pollingIngestStats;  
import org.opensearch.indices.pollingingest.PollingIngestStats;
    @Override
            pollingIngestStats.toXContent(builder, params);  
        static final String PRIMARY = "primary";
        out.writeOptionalWriteable(commitStats);
     */
    public CommitStats getCommitStats() {  
    private RetentionLeaseStats retentionLeaseStats;
        retentionLeaseStats = in.readOptionalWriteable(RetentionLeaseStats::new);
        return retentionLeaseStats;  
    }
     */
     */
import org.opensearch.core.xcontent.ToXContentFragment;
        final CommitStats commitStats,
        builder.startObject(Fields.ROUTING)  
        return this.pollingIngestStats;
            out.writeOptionalWriteable(pollingIngestStats);  
    @Nullable
        statePath = in.readString();
    public SeqNoStats getSeqNoStats() {
        }
        out.writeString(dataPath);
import java.io.IOException;
            return this;
     *  
     */
    @Deprecated  
 * @opensearch.api  
    public ShardRouting getShardRouting() {  
 */  
 * this file be licensed under the Apache-2.0 license or a
    private CommonStats commonStats;  
        public Builder() {}  
/*  
    private String dataPath;  
import org.opensearch.index.seqno.RetentionLeaseStats;
            .endObject();
 * SPDX-License-Identifier: Apache-2.0
        final RetentionLeaseStats retentionLeaseStats,
        dataPath = in.readString();
        private CommonStats commonStats = null;  
 * Unless required by applicable law or agreed to in writing,
        out.writeBoolean(isCustomDataPath);
     * @opensearch.internal
    @Nullable  
        return statePath;
    }
/*  
            this.retentionLeaseStats = retentionLeaseStats;
public class ShardStats implements Writeable, ToXContentFragment {  
 *  
import org.opensearch.common.Nullable;  
        return isCustomDataPath;
        static final String ROUTING = "routing";
        }  
    private boolean isCustomDataPath;
    public PollingIngestStats getPollingIngestStats() {
     * Use {@link Builder} instead.
import org.opensearch.core.common.io.stream.StreamOutput;  
     * The shard routing information (cluster wide shard state).
import org.opensearch.index.shard.ShardPath;
 * KIND, either express or implied.  See the License for the
        isCustomDataPath = in.readBoolean();  
        out.writeString(statePath);  
    }
        builder.endObject();  
    }  
            return this;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this.retentionLeaseStats = builder.retentionLeaseStats;
        final SeqNoStats seqNoStats,  
    private ShardStats(Builder builder) {  
        commonStats.writeTo(out);
 * GitHub history for details.
     * Fields for parsing and toXContent
import org.opensearch.core.xcontent.XContentBuilder;  
            return this;  
     * Gets the current retention lease stats.
    }  
 *
        builder.startObject(Fields.SHARD_PATH);
        final PollingIngestStats pollingIngestStats
     * This constructor will be deprecated starting in version 3.4.0.  
        this.dataPath = shardPath.getRootDataPath().toString();
        final CommonStats commonStats,
        }
 * under the License.  
        }
    ) {  
         * Creates a {@link ShardStats} object from the builder's current state.
    }
     * @param builder The builder instance containing all the values.
import org.opensearch.cluster.routing.ShardRouting;
        public Builder retentionLeaseStats(RetentionLeaseStats retentionLeaseStats) {  
    public String getStatePath() {  
        this.isCustomDataPath = shardPath.isCustomDataPath();
    @Nullable  
        this.statePath = builder.shardPath.getRootStatePath().toString();  
 */
@PublicApi(since = "1.0.0")
    }
 *
import org.opensearch.common.annotation.PublicApi;
        public Builder commitStats(CommitStats commitStats) {
 * Modifications Copyright OpenSearch Contributors. See
        }
        this.seqNoStats = builder.seqNoStats;
        commonStats = new CommonStats(in);
        public ShardStats build() {
        this.commitStats = builder.commitStats;
    @Nullable
 */  
            return this;
 *
        if (pollingIngestStats != null) {
    private SeqNoStats seqNoStats;
            seqNoStats.toXContent(builder, params);  
import org.opensearch.core.common.io.stream.Writeable;
/**  
    public ShardStats(StreamInput in) throws IOException {  
     *
    }
        static final String DATA_PATH = "data_path";
         * @return A new ShardStats instance.  
    @Nullable  
    /**
import org.opensearch.Version;
    private PollingIngestStats pollingIngestStats;
 * the Apache License, Version 2.0 (the "License"); you may
    public void writeTo(StreamOutput out) throws IOException {
        this.commonStats = builder.commonStats;  
            this.shardPath = shardPath;
    private CommitStats commitStats;
 * Shard Stats for OpenSearch
 * not use this file except in compliance with the License.
     */
 * software distributed under the License is distributed on an
    }
        this.statePath = shardPath.getRootStatePath().toString();  
    }
    private String statePath;
        out.writeOptionalWriteable(retentionLeaseStats);
         */
    }
            pollingIngestStats = in.readOptionalWriteable(PollingIngestStats::new);
    /**
        return builder;
     * Builder for the {@link ShardStats} class.  
        private PollingIngestStats pollingIngestStats = null;
 * compatible open source license.
        public Builder shardRouting(ShardRouting shardRouting) {
        if (retentionLeaseStats != null) {
        commonStats.toXContent(builder, params);
        this.pollingIngestStats = pollingIngestStats;  
        this.seqNoStats = seqNoStats;
    public static class Builder {  
    @Nullable
    }  
        static final String IS_CUSTOM_DATA_PATH = "is_custom_data_path";
import org.opensearch.core.common.io.stream.StreamInput;
    }
            this.shardRouting = shardRouting;  
        if (commitStats != null) {
 * The OpenSearch Contributors require contributions made to  
        private CommitStats commitStats = null;
            this.commonStats = commonStats;
        private SeqNoStats seqNoStats = null;
    /**  
import org.opensearch.index.engine.CommitStats;
            .field(Fields.PRIMARY, shardRouting.primary())
    private ShardRouting shardRouting;
    }
import org.opensearch.index.seqno.SeqNoStats;  
        this.isCustomDataPath = builder.shardPath.isCustomDataPath();
        }
            this.commitStats = commitStats;  
            commitStats.toXContent(builder, params);  
            .field(Fields.NODE, shardRouting.currentNodeId())  
            .field(Fields.STATE, shardRouting.state())
    /**
     * This is the sole entry point for creating a new ShardStats object.  
        return this.commitStats;
        public Builder shardPath(ShardPath shardPath) {
     */
        private RetentionLeaseStats retentionLeaseStats = null;  
    }  
        private ShardRouting shardRouting = null;
        this.dataPath = builder.shardPath.getRootDataPath().toString();
 * You may obtain a copy of the License at  
        return this.commonStats;
        public Builder seqNoStats(SeqNoStats seqNoStats) {
        builder.field(Fields.STATE_PATH, statePath);  
    static final class Fields {  
    public boolean isCustomDataPath() {
        static final String STATE_PATH = "state_path";  
        final ShardRouting routing,
    /**
            return this;
        private ShardPath shardPath = null;
        }
        final ShardPath shardPath,  
            this.seqNoStats = seqNoStats;
    public RetentionLeaseStats getRetentionLeaseStats() {
        builder.field(Fields.DATA_PATH, dataPath);
        out.writeOptionalWriteable(seqNoStats);  
 *     http://www.apache.org/licenses/LICENSE-2.0
}  
 * license agreements. See the NOTICE file distributed with
            return this;
