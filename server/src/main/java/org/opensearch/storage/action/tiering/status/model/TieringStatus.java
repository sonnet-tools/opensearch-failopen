            int succeeded = 0;
            }
        tieringStatus.setShardLevelStatus(in.readOptionalWriteable(ShardLevelStatus::new));
     */
                switch (shard.state()) {
            if (ongoingShards != null && !ongoingShards.isEmpty()) {
            List<OngoingShard> shards = in.readList(OngoingShard::new);
    /**
    }
    public static TieringStatus readFrom(StreamInput in) throws IOException {
    @Override
            this.ongoingShards = ongoingShards;
        public void writeTo(StreamOutput out) throws IOException {
    public static final String TOTAL_SHARDS = "total";
            this.sourceShardId = shardId;
            boolean isTargetWarm = "WARM".equalsIgnoreCase(targetTier);
            out.writeString(relocatingNodeId != null ? relocatingNodeId : "");
        /**
            return builder;
        this.startTime = startTime;
        TieringStatus that = (TieringStatus) o;
    }
        /**
    public String getSource() {
            out.writeList(ongoingShards != null ? ongoingShards : Collections.emptyList());
    private String target;
        @Override
                    case RELOCATING:
            final List<ShardRouting> routingTable = clusterState.routingTable().allShards(index);
     */
        return shardLevelStatus;
 */
 * this file be licensed under the Apache-2.0 license or a
        }
        private final String relocatingNodeId;
        @Override
        tieringStatus.setTarget(in.readString());
import org.apache.logging.log4j.Logger;
            final List<OngoingShard> ongoingShards = new ArrayList<>();
            String index,
        }
                        if (isTargetWarm == isWarmNode) {
         */
    }
        /**
    public TieringStatus(final String indexName, final String status, final String source, final String target, final long startTime) {
        public ShardLevelStatus(StreamInput in) throws IOException {
            final Map<String, Object> inputMap = in.readMap();
    /**
            final Map<String, Integer> shardLevelCounters = new HashMap<>();
            Boolean isDetailedFlagEnabled,
        return Objects.equals(indexName, that.indexName)
        /**
    public static class ShardLevelStatus implements ToXContentObject, Writeable {
        public OngoingShard(int shardId, final String relocatingNodeId) {
public class TieringStatus implements ToXContentObject, Writeable {
                        pending++;
            shardLevelStatus.toXContent(xContentBuilder, params);
        private final int sourceShardId;
        }
            builder.startObject(SHARD_LEVEL_STATUS);
        }
    private ShardLevelStatus shardLevelStatus = null;
    }
 *
     * Sets the target tier.
    }
                builder.startArray(SHARD_RELOCATION_STATUS);
     * @param shardLevelStatus the shard level status
    /** Key for running shards count. */
    public static final String SHARD_RELOCATION_STATUS = "shard_relocation_status";
        streamOutput.writeOptionalWriteable(shardLevelStatus);
    public void setShardLevelStatus(ShardLevelStatus shardLevelStatus) {
        public OngoingShard(StreamInput in) throws IOException {
    public static final String SOURCE_SHARD_ID = "source_shard_id";
        return tieringStatus;
                        // Only count STARTED shards as done if they're placed on target nodes.
    public void setIndexName(String indexName) {
        /** Returns ongoing shards. */
     * Sets the index name.
         * Constructs an OngoingShard.
                    if (shard != null) {
    /**
                        break;
    private String source;
    public static final String RUNNING_SHARDS = "running";
                    case STARTED:
                        }
            }
         * @param ongoingShards the ongoing shards
    public static final String SUCCEEDED_SHARDS = "succeeded";
        this.target = target;
            int pending = 0;
 * compatible open source license.
    private static final Logger logger = LogManager.getLogger(TieringStatus.class);
        return indexName;
import java.util.Objects;
    /** Key for source shard ID. */
    @Override
            && Objects.equals(target, that.target)
            ongoingShards = shards != null ? shards : Collections.emptyList();
    public int hashCode() {
    }
    /** Constructs an empty TieringStatus. */
    public String getTarget() {
    public String getStatus() {
    private String indexName;
    /** Returns the index name. */
                }
        xContentBuilder.field(SOURCE, this.getSource());
     * Sets the status.
            return new ShardLevelStatus(shardLevelCounters, ongoingShards);
    /** Returns the source tier. */
        }
    public void setStartTime(long startTime) {
    public static final String TARGET = "target";
import java.util.ArrayList;
            return Objects.equals(shardLevelCounters, that.shardLevelCounters) && Objects.equals(ongoingShards, that.ongoingShards);
        this.indexName = indexName;
    /**
import java.util.Collections;
import org.apache.logging.log4j.LogManager;
    public static final String STATE = "state";
    /**
            shardLevelCounters.put(RUNNING_SHARDS, running);
    }
                        shard.toXContent(builder, params);
        tieringStatus.setStatus(in.readString());
        xContentBuilder.field(INDEX, this.getIndexName());
     * @param source the source tier
 * SPDX-License-Identifier: Apache-2.0
        public void writeTo(StreamOutput out) throws IOException {
            out.writeMapWithConsistentOrder(shardLevelCounters);
                            succeeded++;
        tieringStatus.setStartTime(in.readLong());
        }
     * Reads a TieringStatus from stream.
            ShardLevelStatus that = (ShardLevelStatus) o;
        public int hashCode() {
     * Constructs a TieringStatus with the given parameters.
    public static class OngoingShard implements ToXContentObject, Writeable {
            for (ShardRouting shard : routingTable) {
            && Objects.equals(source, that.source)
     */
            && Objects.equals(status, that.status)
        return startTime;
            out.writeInt(sourceShardId);
            String targetTier
                        if (isDetailedFlagEnabled) {
    /** Key for start time. */
    }
                        break;
            builder.endObject();
            && Objects.equals(shardLevelStatus, that.shardLevelStatus);
    public static final String SHARD_LEVEL_STATUS = "shard_level_status";
                        } else {
    /** Returns the target tier. */
     * @return the tiering status
                builder.field(counter.getKey(), counter.getValue());
                for (OngoingShard shard : ongoingShards) {
                        break;
        @Override
    public static final String RELOCATING_NODE_ID = "relocating_node_id";
        return xContentBuilder;
        return status;
import org.opensearch.core.common.io.stream.StreamOutput;
     * @throws IOException if error
        @Override
    }
        this.source = source;
     * @param status the status
         * @param relocatingNodeId the relocating node ID
         * @param shardLevelCounters the counters
    public void setTarget(String target) {
    private long startTime;
    /** Key for shard relocation status. */
        xContentBuilder.field(TARGET, this.getTarget());
            this.relocatingNodeId = in.readString();
     * Sets the source tier.
        public Map<String, Integer> getShardLevelCounters() {
                shardLevelCounters.put(entry.getKey(), Integer.parseInt(entry.getValue().toString()));
    public void setSource(String source) {
        tieringStatus.setIndexName(in.readString());
    /** Key for relocating node ID. */
    /** Key for index name. */
     * @param target the target tier
     * @param indexName the index name
import java.io.IOException;
    }
     */
        }
         * @param in the stream input
        xContentBuilder.endObject();
    }
                    case UNASSIGNED:
        this.status = status;
                }
            int running = 0;
    public void setStatus(String status) {
            ClusterState clusterState,
    }
import org.opensearch.core.common.io.stream.Writeable;
        if (o == null || getClass() != o.getClass()) return false;
    @Override
    public static final String TIERING_STATUS = "tiering_status";
    /** Key for tiering status. */
import org.opensearch.core.common.io.stream.StreamInput;
package org.opensearch.storage.action.tiering.status.model;
        streamOutput.writeString(target);
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                    }
            for (Map.Entry<String, Integer> counter : shardLevelCounters.entrySet()) {
        this.source = source;
    public XContentBuilder toXContent(XContentBuilder xContentBuilder, Params params) throws IOException {
        private final List<OngoingShard> ongoingShards;
        streamOutput.writeString(status);
        return target;
        }
     */
                    default:
         * @throws IOException if error
            shardLevelCounters = new HashMap<>();
                // corresponding shard in RELOCATING state.
        @Override
            this.sourceShardId = in.readInt();
        public ShardLevelStatus(Map<String, Integer> shardLevelCounters, List<OngoingShard> ongoingShards) {
        if (shardLevelStatus != null) {
    }
    /** Key for state. */
        this.indexName = indexName;
     */
    }
     * @param source the source tier
/**
    /** Returns the shard level status. */
     * @param indexName the index name
        }
        this.shardLevelStatus = shardLevelStatus;
            if (o == null || getClass() != o.getClass()) return false;
        xContentBuilder.startObject(TIERING_STATUS);
 */
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    }
    /**
        this.status = status;
         */
            return shardLevelCounters;
    private String status;
     */
 * The OpenSearch Contributors require contributions made to
         * Constructs with counters and shards.
     * Sets the shard level status.
    }
    }
                            pending++;
            && (startTime == that.startTime)
    public TieringStatus() {}
        tieringStatus.setSource(in.readString());
    }
    /** Key for target tier. */
                builder.endArray();
        xContentBuilder.field(START_TIME, this.getStartTime());
            if (this == o) return true;
     */
     * Sets the start time.
            this.relocatingNodeId = relocatingNodeId;
        xContentBuilder.field(STATE, this.getStatus());
    public String getIndexName() {
    /** Key for source tier. */
}
        /** Returns shard level counters. */
        public boolean equals(Object o) {
    public static final String INDEX = "index";
    /** Key for total shards count. */
    }
                            ongoingShards.add(new OngoingShard(shard.shardId().id(), shard.relocatingNodeId()));
                        final boolean isWarmNode = clusterState.getNodes().get(shard.currentNodeId()).isWarmNode();
        final TieringStatus tieringStatus = new TieringStatus();
 * Migration status object.
    /**
    /** Represents an ongoing shard relocation. */
import org.opensearch.core.xcontent.ToXContentObject;
    public long getStartTime() {
import org.opensearch.core.xcontent.XContentBuilder;
        return this.source;
         * @throws IOException if error
    public static final String SOURCE = "source";
        this.startTime = startTime;
        }
         * Constructs from stream.
            for (Map.Entry<String, Object> entry : inputMap.entrySet()) {
        streamOutput.writeLong(startTime);
        streamOutput.writeString(source);
    public ShardLevelStatus getShardLevelStatus() {
import java.util.List;
        streamOutput.writeString(indexName);
import org.opensearch.cluster.ClusterState;
                        break;
                        }
    /** Returns the status. */
            return ongoingShards;
                // Switch based on shard routing state. Note that INITIALIZING is missing below since we will have a
            return Objects.hash(shardLevelCounters, ongoingShards);
            builder.startObject().field(SOURCE_SHARD_ID, sourceShardId).field(RELOCATING_NODE_ID, relocatingNodeId).endObject();
    /** Shard-level status with counters. */
/*
                        logger.warn("Unexpected shard state [{}] for index [{}]", shard.state(), index);
            shardLevelCounters.put(PENDING_SHARDS, pending);
     * @param status the status
     * @param startTime the start time
            this.shardLevelCounters = shardLevelCounters;
        @Override
        }
            shardLevelCounters.put(SUCCEEDED_SHARDS, succeeded);
     * @param target the target tier
            }
    /** Returns the start time. */
        ) {
            return builder;
    /** Key for pending shards count. */
        public static ShardLevelStatus fromRoutingTable(
            }
    @Override
            shardLevelCounters.put(TOTAL_SHARDS, pending + succeeded + running);
        public List<OngoingShard> getOngoingShards() {
    public void writeTo(StreamOutput streamOutput) throws IOException {
    /** Key for succeeded shards count. */
                        running++;
import org.opensearch.cluster.routing.ShardRouting;
         */
        return Objects.hash(indexName, status, source, target, startTime, shardLevelStatus);
        }
    /** Key for shard level status. */
import java.util.HashMap;
    public static final String START_TIME = "start_time";
     * @param startTime the start time
         * @param in the stream input
         */
        private final Map<String, Integer> shardLevelCounters;
        }
     * @param in the stream input
    }
         * @param shardId the shard ID
         * Constructs from stream.
    /**
    public static final String PENDING_SHARDS = "pending";
import java.util.Map;
        if (this == o) return true;
        this.target = target;
    public boolean equals(Object o) {
        }
