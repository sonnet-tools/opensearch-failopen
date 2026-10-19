    private String status;  
    public static final String INDEX = "index";
         */  
    }  
        }
     * @param target the target tier
    }
         * Constructs from stream.  
        }
    /** Shard-level status with counters. */
                            pending++;
         * Constructs an OngoingShard.  
        if (shardLevelStatus != null) {  
     * @param indexName the index name
         * Constructs with counters and shards.  
        xContentBuilder.endObject();  
        tieringStatus.setSource(in.readString());
    /** Key for state. */  
    public static final String SOURCE_SHARD_ID = "source_shard_id";
        /**
        this.startTime = startTime;  
    /** Returns the shard level status. */
    }
                        pending++;
        TieringStatus that = (TieringStatus) o;  
            return builder;
    private static final Logger logger = LogManager.getLogger(TieringStatus.class);  
import java.util.Map;
    /** Returns the start time. */
        if (o == null || getClass() != o.getClass()) return false;
    /** Key for source shard ID. */
     */  
        streamOutput.writeString(indexName);
    /** Key for tiering status. */
    }
    public static final String RELOCATING_NODE_ID = "relocating_node_id";  
                        }
        /** Returns shard level counters. */  
                        final boolean isWarmNode = clusterState.getNodes().get(shard.currentNodeId()).isWarmNode();  
         * @param in the stream input
    public long getStartTime() {  
        tieringStatus.setStartTime(in.readLong());
    /** Key for total shards count. */
    public ShardLevelStatus getShardLevelStatus() {
        tieringStatus.setIndexName(in.readString());  
                        break;  
package org.opensearch.storage.action.tiering.status.model;
        xContentBuilder.field(STATE, this.getStatus());
        }  
    public String getStatus() {
                }  
                shardLevelCounters.put(entry.getKey(), Integer.parseInt(entry.getValue().toString()));
     * @param source the source tier
            Boolean isDetailedFlagEnabled,  
import java.util.ArrayList;  
        }
    public void setIndexName(String indexName) {  
    /** Key for pending shards count. */
                builder.endArray();
import java.util.List;  
            out.writeList(ongoingShards != null ? ongoingShards : Collections.emptyList());
import org.apache.logging.log4j.Logger;
         * @param shardId the shard ID
        xContentBuilder.startObject(TIERING_STATUS);  
        @Override
 */  
    public static final String START_TIME = "start_time";
        xContentBuilder.field(TARGET, this.getTarget());
        public boolean equals(Object o) {
            shardLevelCounters.put(RUNNING_SHARDS, running);  
    /**
            final Map<String, Integer> shardLevelCounters = new HashMap<>();
        this.indexName = indexName;
    public static final String SOURCE = "source";  
            shardLevelCounters.put(SUCCEEDED_SHARDS, succeeded);
     * @return the tiering status
    private ShardLevelStatus shardLevelStatus = null;
            && Objects.equals(source, that.source)  
            shardLevelCounters.put(TOTAL_SHARDS, pending + succeeded + running);
     * Sets the start time.
            String targetTier
        return shardLevelStatus;  
        /**
                        if (isDetailedFlagEnabled) {  
import java.io.IOException;
     * Sets the target tier.
    public static final String RUNNING_SHARDS = "running";
    public boolean equals(Object o) {  
         * @param shardLevelCounters the counters
                        // Only count STARTED shards as done if they're placed on target nodes.
import java.util.Collections;
        }
         * @throws IOException if error  
}
    public TieringStatus(final String indexName, final String status, final String source, final String target, final long startTime) {
        private final int sourceShardId;
     * Constructs a TieringStatus with the given parameters.  
         */
     * @param source the source tier  
            int succeeded = 0;  
        private final String relocatingNodeId;  
        tieringStatus.setShardLevelStatus(in.readOptionalWriteable(ShardLevelStatus::new));
            this.sourceShardId = shardId;
        public Map<String, Integer> getShardLevelCounters() {
            final List<ShardRouting> routingTable = clusterState.routingTable().allShards(index);  
    /** Returns the index name. */
        streamOutput.writeOptionalWriteable(shardLevelStatus);
         * @throws IOException if error
                    }
            builder.startObject().field(SOURCE_SHARD_ID, sourceShardId).field(RELOCATING_NODE_ID, relocatingNodeId).endObject();  
        @Override
    /** Returns the status. */
     * @param target the target tier
         * Constructs from stream.
    public String getTarget() {
        streamOutput.writeString(target);
    /**
    public void setStartTime(long startTime) {
        ) {
    /** Constructs an empty TieringStatus. */  
    /** Returns the source tier. */  
        /** Returns ongoing shards. */
        public ShardLevelStatus(StreamInput in) throws IOException {
    }  
            return Objects.equals(shardLevelCounters, that.shardLevelCounters) && Objects.equals(ongoingShards, that.ongoingShards);  
        return tieringStatus;
                    case STARTED:
            if (o == null || getClass() != o.getClass()) return false;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.common.io.stream.StreamInput;
            }
        xContentBuilder.field(START_TIME, this.getStartTime());
                        shard.toXContent(builder, params);
    }
        private final List<OngoingShard> ongoingShards;
import org.opensearch.cluster.ClusterState;  
            && Objects.equals(shardLevelStatus, that.shardLevelStatus);  
                        if (isTargetWarm == isWarmNode) {
                        break;  
        public ShardLevelStatus(Map<String, Integer> shardLevelCounters, List<OngoingShard> ongoingShards) {
    /**
            final Map<String, Object> inputMap = in.readMap();  
    public static class OngoingShard implements ToXContentObject, Writeable {
            out.writeMapWithConsistentOrder(shardLevelCounters);
    /**
        xContentBuilder.field(INDEX, this.getIndexName());
            && Objects.equals(status, that.status)
     * Sets the shard level status.
            if (this == o) return true;  
        }  
        return target;  
    }  
            for (ShardRouting shard : routingTable) {  
    /**
            return ongoingShards;
            for (Map.Entry<String, Integer> counter : shardLevelCounters.entrySet()) {
    @Override
                            ongoingShards.add(new OngoingShard(shard.shardId().id(), shard.relocatingNodeId()));
    public XContentBuilder toXContent(XContentBuilder xContentBuilder, Params params) throws IOException {
        streamOutput.writeString(source);
public class TieringStatus implements ToXContentObject, Writeable {
    /** Key for shard level status. */
                builder.field(counter.getKey(), counter.getValue());  
            shardLevelCounters = new HashMap<>();
            shardLevelStatus.toXContent(xContentBuilder, params);
         * @param in the stream input
        this.target = target;
    public void setSource(String source) {  
        /**  
        public OngoingShard(StreamInput in) throws IOException {
        /**
    @Override
            builder.endObject();  
            return shardLevelCounters;
    /** Key for start time. */  
/**
                        break;  
import org.apache.logging.log4j.LogManager;
        this.source = source;
        return xContentBuilder;
    }
    /** Key for target tier. */
        this.source = source;
        public int hashCode() {
    private long startTime;  
    private String source;
     */
     */  
        tieringStatus.setStatus(in.readString());
                            succeeded++;
            boolean isTargetWarm = "WARM".equalsIgnoreCase(targetTier);
 * Migration status object.
         */  
            }  
            }  
            int running = 0;
        }  
            this.shardLevelCounters = shardLevelCounters;
 *
    public void setShardLevelStatus(ShardLevelStatus shardLevelStatus) {
     * @param in the stream input  
                    case RELOCATING:
            ongoingShards = shards != null ? shards : Collections.emptyList();
                    if (shard != null) {  
    public static TieringStatus readFrom(StreamInput in) throws IOException {
import org.opensearch.cluster.routing.ShardRouting;
    /**  
            && Objects.equals(target, that.target)
        tieringStatus.setTarget(in.readString());  
        final TieringStatus tieringStatus = new TieringStatus();
    public String getSource() {
    }
         * @param relocatingNodeId the relocating node ID
            out.writeInt(sourceShardId);  
        }  
/*  
            this.ongoingShards = ongoingShards;  
            final List<OngoingShard> ongoingShards = new ArrayList<>();
                        break;  
    /** Key for running shards count. */  
                builder.startArray(SHARD_RELOCATION_STATUS);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.xcontent.ToXContentObject;
        @Override
         * @param ongoingShards the ongoing shards
    }
        }
    public static final String TIERING_STATUS = "tiering_status";  
        this.target = target;
    }  
    /** Key for source tier. */
        return indexName;
        if (this == o) return true;
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        public OngoingShard(int shardId, final String relocatingNodeId) {
    /**  
 */  
            ClusterState clusterState,
    }  
    public static final String PENDING_SHARDS = "pending";  
    }
    /** Returns the target tier. */
            return new ShardLevelStatus(shardLevelCounters, ongoingShards);
                // corresponding shard in RELOCATING state.
    public static final String SHARD_RELOCATION_STATUS = "shard_relocation_status";
import org.opensearch.core.common.io.stream.StreamOutput;  
        public List<OngoingShard> getOngoingShards() {  
    /** Represents an ongoing shard relocation. */  
     * Sets the source tier.  
                switch (shard.state()) {  
    @Override  
    public static final String TARGET = "target";
     * @param status the status
                }
        this.shardLevelStatus = shardLevelStatus;
        @Override
            String index,
     * @param startTime the start time
    public void setTarget(String target) {
 * this file be licensed under the Apache-2.0 license or a
    public void writeTo(StreamOutput streamOutput) throws IOException {
     */  
        }
    }
            int pending = 0;
                for (OngoingShard shard : ongoingShards) {
            ShardLevelStatus that = (ShardLevelStatus) o;
        }  
        streamOutput.writeString(status);  
            if (ongoingShards != null && !ongoingShards.isEmpty()) {  
            return builder;
    public static final String SUCCEEDED_SHARDS = "succeeded";
    }
        return startTime;
    public void setStatus(String status) {
    /**  
        this.status = status;  
     */
                        }
                        running++;
        }
    @Override  
        xContentBuilder.field(SOURCE, this.getSource());  
     */
    private String target;
     * @param startTime the start time  
     * @param indexName the index name
        this.status = status;
    private String indexName;
        return Objects.equals(indexName, that.indexName)
        this.startTime = startTime;  
    }
        @Override  
            out.writeString(relocatingNodeId != null ? relocatingNodeId : "");
            List<OngoingShard> shards = in.readList(OngoingShard::new);
import org.opensearch.core.common.io.stream.Writeable;
        public void writeTo(StreamOutput out) throws IOException {
import java.util.Objects;
                        logger.warn("Unexpected shard state [{}] for index [{}]", shard.state(), index);
import java.util.HashMap;
            shardLevelCounters.put(PENDING_SHARDS, pending);
    }
     * Reads a TieringStatus from stream.
        return Objects.hash(indexName, status, source, target, startTime, shardLevelStatus);
    public static final String TOTAL_SHARDS = "total";
     * @param status the status
     */  
        return status;  
            builder.startObject(SHARD_LEVEL_STATUS);
import org.opensearch.core.xcontent.XContentBuilder;  
            for (Map.Entry<String, Object> entry : inputMap.entrySet()) {
            return Objects.hash(shardLevelCounters, ongoingShards);
                        } else {  
        public static ShardLevelStatus fromRoutingTable(  
    public static final String SHARD_LEVEL_STATUS = "shard_level_status";  
            }
    }
     * Sets the index name.  
    }
            this.sourceShardId = in.readInt();  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
         */  
        this.indexName = indexName;
            this.relocatingNodeId = relocatingNodeId;  
        return this.source;
    /** Key for succeeded shards count. */
        }
    public TieringStatus() {}
    }  
     * Sets the status.
    /** Key for index name. */
        private final Map<String, Integer> shardLevelCounters;  
    /** Key for shard relocation status. */  
    public static final String STATE = "state";
     * @param shardLevelStatus the shard level status
        streamOutput.writeLong(startTime);  
    public static class ShardLevelStatus implements ToXContentObject, Writeable {
     */  
    /** Key for relocating node ID. */
    public String getIndexName() {  
        @Override
 * compatible open source license.
                // Switch based on shard routing state. Note that INITIALIZING is missing below since we will have a
                    case UNASSIGNED:
                    default:
     * @throws IOException if error
            this.relocatingNodeId = in.readString();
        public void writeTo(StreamOutput out) throws IOException {  
        }
    public int hashCode() {
            && (startTime == that.startTime)
