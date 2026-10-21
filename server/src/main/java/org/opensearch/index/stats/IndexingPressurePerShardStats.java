    }
    }
    public long getCurrentPrimaryAndCoordinatingLimits() {
    }
        primaryThroughputDegradationLimitsBreachedRejections = in.readVLong();
            .getPerformanceTracker()
 * The OpenSearch Contributors require contributions made to
        builder.startObject("memory");
        builder.field(BREAKUP_NO_SUCCESSFUL_REQUEST_LIMITS, coordinatingLastSuccessfulRequestLimitsBreachedRejections);
        out.writeVLong(totalCombinedCoordinatingAndPrimaryBytes);
        builder.field(REPLICA_TIME_IN_MILLIS, replicaTimeInMillis);
            .getRejectionTracker()
    private final long replicaRejections;
import org.opensearch.core.common.io.stream.StreamInput;
        out.writeVLong(replicaThroughputDegradationLimitsBreachedRejections);
        coordinatingNodeLimitsBreachedRejections = in.readVLong();
        replicaTimeInMillis = shardIndexingPressureTracker.getReplicaOperationTracker().getPerformanceTracker().getLatencyInMillis();
        coordinatingTimeInMillis = in.readVLong();
    public long getCoordinatingLastSuccessfulRequestLimitsBreachedRejections() {
    }
        out.writeVLong(currentPrimaryBytes);
        return totalCoordinatingBytes;
        if (shardIndexingPressureEnforced) {
    }
        out.writeVLong(totalCoordinatingBytes);
    public void writeTo(StreamOutput out) throws IOException {
    private final long replicaNodeLimitsBreachedRejections;
        builder.field(PRIMARY_REJECTIONS, primaryRejections);
            .getPerformanceTracker()
            .getThroughputDegradationLimitsBreachedRejections();
        coordinatingNodeLimitsBreachedRejections = shardIndexingPressureTracker.getCoordinatingOperationTracker()
        coordinatingRejections = in.readVLong();
        replicaLastSuccessfulRequestTimestampInMillis = in.readVLong();
    }
            builder.startObject("breakup");
        return currentCoordinatingBytes;
 * compatible open source license.
        builder.endObject();
        builder.field(REPLICA_COUNT, totalReplicaCount);
        builder.field(PRIMARY_LAST_SUCCESSFUL_REQUEST_TIMESTAMP_IN_MILLIS, primaryLastSuccessfulRequestTimestampInMillis);
        primaryTimeInMillis = shardIndexingPressureTracker.getPrimaryOperationTracker().getPerformanceTracker().getLatencyInMillis();
        builder.endObject();
    private static final String CURRENT_COORDINATING_AND_PRIMARY_IN_BYTES = "current_coordinating_and_primary_bytes";
    }
    public long getCoordinatingRejections() {
    public long getPrimaryRejections() {
        out.writeVLong(coordinatingLastSuccessfulRequestLimitsBreachedRejections);
    private static final String PRIMARY_COUNT = "primary_count";
        out.writeVLong(replicaLastSuccessfulRequestTimestampInMillis);
        replicaRejections = in.readVLong();
        builder.field(COORDINATING_REJECTIONS, coordinatingRejections);
    public long getPrimaryLastSuccessfulRequestLimitsBreachedRejections() {
        primaryRejections = in.readVLong();
        builder.startObject("coordinating");
        replicaNodeLimitsBreachedRejections = shardIndexingPressureTracker.getReplicaOperationTracker()
    }
        builder.humanReadableField(REPLICA_IN_BYTES, REPLICA, new ByteSizeValue(currentReplicaBytes));
    private static final String COORDINATING_TIME_IN_MILLIS = "coordinating_time_in_millis";
}
        return primaryRejections;
    public long getCurrentReplicaBytes() {
        return primaryThroughputDegradationLimitsBreachedRejections;
    }
import org.opensearch.core.xcontent.ToXContentFragment;
        return coordinatingRejections;
            .getRejectionTracker()
        builder.field(PRIMARY_COUNT, totalPrimaryCount);
        totalCoordinatingBytes = in.readVLong();
            .getRejectionTracker()
        totalCoordinatingCount = in.readVLong();
    public long getTotalReplicaBytes() {
        coordinatingLastSuccessfulRequestTimestampInMillis = shardIndexingPressureTracker.getCoordinatingOperationTracker()
    public long getTotalCombinedCoordinatingAndPrimaryBytes() {
            builder.startObject("breakup_shadow_mode");
            .getRejectionTracker()
    private final long totalCombinedCoordinatingAndPrimaryBytes;
        primaryThroughputDegradationLimitsBreachedRejections = shardIndexingPressureTracker.getPrimaryOperationTracker()
        shardId = in.readString();
        currentPrimaryAndCoordinatingLimits = in.readVLong();
 * SPDX-License-Identifier: Apache-2.0
        replicaThroughputDegradationLimitsBreachedRejections = in.readVLong();
    private static final String REPLICA_LAST_SUCCESSFUL_REQUEST_TIMESTAMP_IN_MILLIS = "replica_last_successful_request_timestamp_in_millis";
import java.io.IOException;
        out.writeVLong(coordinatingRejections);
        builder.humanReadableField(PRIMARY_IN_BYTES, PRIMARY, new ByteSizeValue(totalPrimaryBytes));
    private final String shardId;
    public long getCurrentPrimaryBytes() {
    private static final String COORDINATING = "coordinating";
        currentPrimaryBytes = shardIndexingPressureTracker.getPrimaryOperationTracker().getStatsTracker().getCurrentBytes();
 * Per shard indexing pressure statistics
        builder.humanReadableField(COORDINATING_IN_BYTES, COORDINATING, new ByteSizeValue(totalCoordinatingBytes));
    private final long currentPrimaryAndCoordinatingLimits;
    }
@PublicApi(since = "1.3.0")
            builder.startObject("breakup");
        builder.field(COORDINATING_TIME_IN_MILLIS, coordinatingTimeInMillis);
        replicaNodeLimitsBreachedRejections = in.readVLong();
    private final long coordinatingThroughputDegradationLimitsBreachedRejections;
        return replicaLastSuccessfulRequestLimitsBreachedRejections;
        builder.field(BREAKUP_NODE_LIMITS, primaryNodeLimitsBreachedRejections);
        } else {
        return replicaThroughputDegradationLimitsBreachedRejections;
        builder.field(CURRENT_REPLICA_LIMITS_IN_BYTES, currentReplicaLimits);
        return currentPrimaryBytes;
    private static final String BREAKUP_NODE_LIMITS = "node_limits";
        out.writeVLong(currentPrimaryAndCoordinatingLimits);
    private static final String CURRENT_REPLICA_LIMITS_IN_BYTES = "current_replica_limits_in_bytes";
 * this file be licensed under the Apache-2.0 license or a
        builder.endObject();
            .getRejectionTracker()
    }
        return primaryLastSuccessfulRequestLimitsBreachedRejections;
        out.writeVLong(totalCoordinatingCount);
        this.shardIndexingPressureEnforced = shardIndexingPressureEnforced;
        primaryLastSuccessfulRequestTimestampInMillis = in.readVLong();
import org.opensearch.index.ShardIndexingPressureTracker;
            .getRejectionTracker()
    private final long replicaLastSuccessfulRequestLimitsBreachedRejections;
        }
    }
            .getRejectionTracker()
    public long getCurrentReplicaLimits() {
        out.writeVLong(replicaTimeInMillis);
    private final long currentReplicaBytes;
        out.writeVLong(primaryTimeInMillis);
    private static final String REPLICA_TIME_IN_MILLIS = "replica_time_in_millis";
        out.writeVLong(primaryLastSuccessfulRequestTimestampInMillis);
    private static final String REPLICA_COUNT = "replica_count";
    public long getCurrentCoordinatingBytes() {
    }
 *
        out.writeVLong(coordinatingTimeInMillis);
            .getTotalCombinedCoordinatingAndPrimaryBytes();
            .getThroughputDegradationLimitsBreachedRejections();
        out.writeVLong(replicaRejections);
        builder.humanReadableField(COORDINATING_IN_BYTES, COORDINATING, new ByteSizeValue(currentCoordinatingBytes));
/**
        out.writeVLong(primaryLastSuccessfulRequestLimitsBreachedRejections);
    private static final String PRIMARY = "primary";
        builder.field(BREAKUP_NO_SUCCESSFUL_REQUEST_LIMITS, primaryLastSuccessfulRequestLimitsBreachedRejections);
        currentCombinedCoordinatingAndPrimaryBytes = shardIndexingPressureTracker.getCommonOperationTracker()
        out.writeVLong(primaryRejections);
    public long getCoordinatingThroughputDegradationLimitsBreachedRejections() {
        totalPrimaryCount = in.readVLong();
        builder.endObject();
public class IndexingPressurePerShardStats implements Writeable, ToXContentFragment {
        out.writeVLong(totalPrimaryCount);
        currentPrimaryAndCoordinatingLimits = shardIndexingPressureTracker.getPrimaryAndCoordinatingLimits();
        builder.startObject("memory_allocation");
    }
        totalReplicaCount = shardIndexingPressureTracker.getReplicaOperationTracker().getStatsTracker().getRequestCount();
        out.writeVLong(totalPrimaryBytes);
        out.writeVLong(totalReplicaCount);
    private static final String REPLICA_IN_BYTES = "replica_in_bytes";
    private static final String PRIMARY_TIME_IN_MILLIS = "primary_time_in_millis";
            .getLastSuccessfulRequestTimestamp();
    private final long primaryNodeLimitsBreachedRejections;
        primaryRejections = shardIndexingPressureTracker.getPrimaryOperationTracker().getRejectionTracker().getTotalRejections();
        } else {
        primaryNodeLimitsBreachedRejections = in.readVLong();
        return replicaNodeLimitsBreachedRejections;
        coordinatingThroughputDegradationLimitsBreachedRejections = shardIndexingPressureTracker.getCoordinatingOperationTracker()
        currentReplicaLimits = shardIndexingPressureTracker.getReplicaLimits();
    private final long primaryLastSuccessfulRequestLimitsBreachedRejections;
import org.opensearch.core.common.unit.ByteSizeValue;
        builder.field(BREAKUP_NO_SUCCESSFUL_REQUEST_LIMITS, replicaLastSuccessfulRequestLimitsBreachedRejections);
        builder.startObject("indexing");
            builder.startObject("breakup_shadow_mode");
            .getLastSuccessfulRequestLimitsBreachedRejections();
        builder.field(BREAKUP_THROUGHPUT_DEGRADATION_LIMIT, coordinatingThroughputDegradationLimitsBreachedRejections);
        replicaRejections = shardIndexingPressureTracker.getReplicaOperationTracker().getRejectionTracker().getTotalRejections();
        out.writeString(shardId);
        coordinatingLastSuccessfulRequestLimitsBreachedRejections = shardIndexingPressureTracker.getCoordinatingOperationTracker()
        out.writeVLong(replicaLastSuccessfulRequestLimitsBreachedRejections);
        builder.field(BREAKUP_NODE_LIMITS, replicaNodeLimitsBreachedRejections);
        currentReplicaBytes = in.readVLong();
        builder.field(COORDINATING_LAST_SUCCESSFUL_REQUEST_TIMESTAMP_IN_MILLIS, coordinatingLastSuccessfulRequestTimestampInMillis);
        builder.startObject("replica");
    public long getPrimaryNodeLimitsBreachedRejections() {
        return currentReplicaLimits;
    private static final String BREAKUP_THROUGHPUT_DEGRADATION_LIMIT = "throughput_degradation_limits";
        builder.endObject();
    private final long totalCoordinatingCount;
    private final long primaryThroughputDegradationLimitsBreachedRejections;
    private static final String COORDINATING_LAST_SUCCESSFUL_REQUEST_TIMESTAMP_IN_MILLIS =
        primaryLastSuccessfulRequestLimitsBreachedRejections = shardIndexingPressureTracker.getPrimaryOperationTracker()
    private final long currentPrimaryBytes;
            .getPerformanceTracker()
 * @opensearch.api
    private final long coordinatingNodeLimitsBreachedRejections;
        primaryNodeLimitsBreachedRejections = shardIndexingPressureTracker.getPrimaryOperationTracker()
    private static final String REPLICA_REJECTIONS = "replica_rejections";
    private final boolean shardIndexingPressureEnforced;
        return coordinatingThroughputDegradationLimitsBreachedRejections;
        return totalReplicaBytes;
    private final long replicaTimeInMillis;
        builder.endObject();
    public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {
        totalCombinedCoordinatingAndPrimaryBytes = in.readVLong();
        builder.startObject("current");
            .getPerformanceTracker()
    private static final String CURRENT_REPLICA_IN_BYTES = "current_replica_bytes";
        totalReplicaBytes = in.readVLong();
        builder.field(CURRENT_COORDINATING_AND_PRIMARY_LIMITS_IN_BYTES, currentPrimaryAndCoordinatingLimits);
        builder.startObject(shardId);
        builder.field(BREAKUP_NODE_LIMITS, coordinatingNodeLimitsBreachedRejections);
        coordinatingLastSuccessfulRequestTimestampInMillis = in.readVLong();
    public long getReplicaNodeLimitsBreachedRejections() {
        totalCoordinatingBytes = shardIndexingPressureTracker.getCoordinatingOperationTracker().getStatsTracker().getTotalBytes();
        builder.humanReadableField(REPLICA_IN_BYTES, REPLICA, new ByteSizeValue(totalReplicaBytes));
        return builder.endObject();
        return primaryNodeLimitsBreachedRejections;
        shardIndexingPressureEnforced = in.readBoolean();
        coordinatingRejections = shardIndexingPressureTracker.getCoordinatingOperationTracker().getRejectionTracker().getTotalRejections();
        out.writeVLong(coordinatingLastSuccessfulRequestTimestampInMillis);
    private final long replicaThroughputDegradationLimitsBreachedRejections;
        coordinatingLastSuccessfulRequestLimitsBreachedRejections = in.readVLong();
import org.opensearch.common.annotation.PublicApi;
            .getRejectionTracker()
        }
        builder.endObject();
        return currentCombinedCoordinatingAndPrimaryBytes;
    private final long totalCoordinatingBytes;
        return coordinatingNodeLimitsBreachedRejections;
    }
    }
import org.opensearch.core.common.io.stream.StreamOutput;
        return totalCombinedCoordinatingAndPrimaryBytes;
        builder.humanReadableField(PRIMARY_IN_BYTES, PRIMARY, new ByteSizeValue(currentPrimaryBytes));
        out.writeVLong(currentCombinedCoordinatingAndPrimaryBytes);
        totalCoordinatingCount = shardIndexingPressureTracker.getCoordinatingOperationTracker().getStatsTracker().getRequestCount();
package org.opensearch.index.stats;
        return coordinatingLastSuccessfulRequestLimitsBreachedRejections;
        primaryTimeInMillis = in.readVLong();
        out.writeVLong(coordinatingThroughputDegradationLimitsBreachedRejections);
            .getNodeLimitsBreachedRejections();
import org.opensearch.core.xcontent.ToXContent;
        out.writeVLong(totalReplicaBytes);
        }
        currentPrimaryBytes = in.readVLong();
        } else {
    }
        currentReplicaBytes = shardIndexingPressureTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes();
    public IndexingPressurePerShardStats(ShardIndexingPressureTracker shardIndexingPressureTracker, boolean shardIndexingPressureEnforced) {
        return totalPrimaryBytes;
        totalCombinedCoordinatingAndPrimaryBytes = shardIndexingPressureTracker.getCommonOperationTracker()
        replicaThroughputDegradationLimitsBreachedRejections = shardIndexingPressureTracker.getReplicaOperationTracker()
    @Override
        builder.field(REPLICA_LAST_SUCCESSFUL_REQUEST_TIMESTAMP_IN_MILLIS, replicaLastSuccessfulRequestTimestampInMillis);
        out.writeVLong(primaryNodeLimitsBreachedRejections);
    private final long totalReplicaCount;
        replicaTimeInMillis = in.readVLong();
        return replicaRejections;
        totalReplicaCount = in.readVLong();
    private static final String COORDINATING_COUNT = "coordinating_count";
    private static final String BREAKUP_NO_SUCCESSFUL_REQUEST_LIMITS = "no_successful_request_limits";
import org.opensearch.core.common.io.stream.Writeable;
            builder.startObject("breakup_shadow_mode");
    private final long currentCoordinatingBytes;
    private final long totalReplicaBytes;
        currentReplicaLimits = in.readVLong();
            .getCurrentCombinedCoordinatingAndPrimaryBytes();
    private static final String COORDINATING_IN_BYTES = "coordinating_in_bytes";
        totalPrimaryBytes = shardIndexingPressureTracker.getPrimaryOperationTracker().getStatsTracker().getTotalBytes();
        currentCoordinatingBytes = in.readVLong();
 *
        builder.endObject();
        builder.startObject("current");
    private static final String PRIMARY_REJECTIONS = "primary_rejections";
    }
    }
    private final long currentReplicaLimits;
    }
        replicaLastSuccessfulRequestLimitsBreachedRejections = shardIndexingPressureTracker.getReplicaOperationTracker()
        builder.field(CURRENT_COORDINATING_AND_PRIMARY_IN_BYTES, currentCombinedCoordinatingAndPrimaryBytes);
    private final long primaryRejections;
        out.writeVLong(currentCoordinatingBytes);
        builder.endObject();
        if (shardIndexingPressureEnforced) {
    public long getCoordinatingNodeLimitsBreachedRejections() {
        builder.endObject();
        currentCoordinatingBytes = shardIndexingPressureTracker.getCoordinatingOperationTracker().getStatsTracker().getCurrentBytes();
    public long getTotalCoordinatingBytes() {
        return currentPrimaryAndCoordinatingLimits;
        return currentReplicaBytes;
        out.writeVLong(currentReplicaLimits);
    public long getReplicaRejections() {
        out.writeVLong(coordinatingNodeLimitsBreachedRejections);
        builder.startObject("rejection");
    private final long totalPrimaryBytes;
        primaryLastSuccessfulRequestTimestampInMillis = shardIndexingPressureTracker.getPrimaryOperationTracker()
    public long getTotalPrimaryBytes() {
        out.writeVLong(replicaNodeLimitsBreachedRejections);
            .getLastSuccessfulRequestTimestamp();
    }
    private static final String PRIMARY_LAST_SUCCESSFUL_REQUEST_TIMESTAMP_IN_MILLIS = "primary_last_successful_request_timestamp_in_millis";
        builder.field(COORDINATING_COUNT, totalCoordinatingCount);
        totalReplicaBytes = shardIndexingPressureTracker.getReplicaOperationTracker().getStatsTracker().getTotalBytes();
        builder.field(PRIMARY_TIME_IN_MILLIS, primaryTimeInMillis);
        replicaLastSuccessfulRequestTimestampInMillis = shardIndexingPressureTracker.getReplicaOperationTracker()
    private final long coordinatingTimeInMillis;
            .getThroughputDegradationLimitsBreachedRejections();
        builder.startObject("primary");
        builder.startObject("total");
        primaryLastSuccessfulRequestLimitsBreachedRejections = in.readVLong();
    public long getPrimaryThroughputDegradationLimitsBreachedRejections() {
            .getLastSuccessfulRequestTimestamp();
    }
    private final long currentCombinedCoordinatingAndPrimaryBytes;
        coordinatingThroughputDegradationLimitsBreachedRejections = in.readVLong();
            .getNodeLimitsBreachedRejections();
/*
        if (shardIndexingPressureEnforced) {
        builder.endObject();
    private final long coordinatingRejections;
            .getRejectionTracker()
        totalPrimaryBytes = in.readVLong();
        builder.field(BREAKUP_THROUGHPUT_DEGRADATION_LIMIT, replicaThroughputDegradationLimitsBreachedRejections);
 */
        builder.field(BREAKUP_THROUGHPUT_DEGRADATION_LIMIT, primaryThroughputDegradationLimitsBreachedRejections);
        shardId = shardIndexingPressureTracker.getShardId().toString();
        builder.endObject();
        out.writeVLong(primaryThroughputDegradationLimitsBreachedRejections);
            builder.startObject("breakup");
            .getNodeLimitsBreachedRejections();
    private final long primaryTimeInMillis;
    private final long totalPrimaryCount;
    }
    }
    private final long replicaLastSuccessfulRequestTimestampInMillis;
    private static final String REPLICA = "replica";
        replicaLastSuccessfulRequestLimitsBreachedRejections = in.readVLong();
    }
    private final long coordinatingLastSuccessfulRequestLimitsBreachedRejections;
        "coordinating_last_successful_request_timestamp_in_millis";
        builder.field(CURRENT_REPLICA_IN_BYTES, currentReplicaBytes);
        builder.field(REPLICA_REJECTIONS, replicaRejections);
    private static final String CURRENT_COORDINATING_AND_PRIMARY_LIMITS_IN_BYTES = "current_coordinating_and_primary_limits_in_bytes";
import org.opensearch.core.xcontent.XContentBuilder;
    private final long primaryLastSuccessfulRequestTimestampInMillis;
    private static final String PRIMARY_IN_BYTES = "primary_in_bytes";
    public long getReplicaLastSuccessfulRequestLimitsBreachedRejections() {
        builder.endObject();
        out.writeBoolean(shardIndexingPressureEnforced);
        totalPrimaryCount = shardIndexingPressureTracker.getPrimaryOperationTracker().getStatsTracker().getRequestCount();
 */
        builder.endObject();
        builder.startObject("limit");
        builder.startObject("last_successful_timestamp");
        out.writeVLong(currentReplicaBytes);
    }
        builder.endObject();
            .getLatencyInMillis();
    private static final String COORDINATING_REJECTIONS = "coordinating_rejections";
    @Override
        coordinatingTimeInMillis = shardIndexingPressureTracker.getCoordinatingOperationTracker()
            .getLastSuccessfulRequestLimitsBreachedRejections();
    public IndexingPressurePerShardStats(StreamInput in) throws IOException {
        currentCombinedCoordinatingAndPrimaryBytes = in.readVLong();
    public long getReplicaThroughputDegradationLimitsBreachedRejections() {
    public long getCurrentCombinedCoordinatingAndPrimaryBytes() {
    private final long coordinatingLastSuccessfulRequestTimestampInMillis;
            .getLastSuccessfulRequestLimitsBreachedRejections();
