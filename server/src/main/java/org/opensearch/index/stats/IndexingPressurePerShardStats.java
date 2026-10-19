        currentReplicaLimits = in.readVLong();
    private static final String REPLICA_REJECTIONS = "replica_rejections";  
        coordinatingLastSuccessfulRequestTimestampInMillis = shardIndexingPressureTracker.getCoordinatingOperationTracker()
    }  
        out.writeVLong(currentCoordinatingBytes);
            .getRejectionTracker()  
        out.writeVLong(coordinatingThroughputDegradationLimitsBreachedRejections);  
        return primaryThroughputDegradationLimitsBreachedRejections;
        replicaThroughputDegradationLimitsBreachedRejections = shardIndexingPressureTracker.getReplicaOperationTracker()
    private final long primaryLastSuccessfulRequestLimitsBreachedRejections;
        } else {
    private final long replicaNodeLimitsBreachedRejections;  
    public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {
        out.writeVLong(totalCoordinatingBytes);
    }  
    private final long coordinatingLastSuccessfulRequestLimitsBreachedRejections;  
            .getRejectionTracker()
    private static final String PRIMARY = "primary";
        out.writeVLong(coordinatingRejections);  
        "coordinating_last_successful_request_timestamp_in_millis";
        totalCoordinatingCount = in.readVLong();
        return primaryNodeLimitsBreachedRejections;
    }
        builder.field(BREAKUP_NO_SUCCESSFUL_REQUEST_LIMITS, primaryLastSuccessfulRequestLimitsBreachedRejections);  
        return currentPrimaryBytes;
    private final boolean shardIndexingPressureEnforced;  
        replicaTimeInMillis = shardIndexingPressureTracker.getReplicaOperationTracker().getPerformanceTracker().getLatencyInMillis();  
        builder.field(REPLICA_COUNT, totalReplicaCount);  
            .getLastSuccessfulRequestLimitsBreachedRejections();
            builder.startObject("breakup_shadow_mode");  
        return currentReplicaLimits;
        builder.endObject();  
        coordinatingLastSuccessfulRequestLimitsBreachedRejections = in.readVLong();
    }
    @Override
    private final long primaryRejections;  
        primaryLastSuccessfulRequestLimitsBreachedRejections = in.readVLong();  
        out.writeVLong(currentPrimaryAndCoordinatingLimits);
    private final long replicaLastSuccessfulRequestTimestampInMillis;
        builder.field(CURRENT_COORDINATING_AND_PRIMARY_IN_BYTES, currentCombinedCoordinatingAndPrimaryBytes);
        builder.field(CURRENT_COORDINATING_AND_PRIMARY_LIMITS_IN_BYTES, currentPrimaryAndCoordinatingLimits);  
 */
        return builder.endObject();
        out.writeVLong(currentReplicaBytes);  
        primaryLastSuccessfulRequestTimestampInMillis = in.readVLong();
    private final long currentCoordinatingBytes;
/*  
        builder.endObject();  
        builder.startObject("memory_allocation");  
    public long getCoordinatingLastSuccessfulRequestLimitsBreachedRejections() {
    public long getReplicaThroughputDegradationLimitsBreachedRejections() {
        primaryTimeInMillis = in.readVLong();  
        return coordinatingNodeLimitsBreachedRejections;
        replicaNodeLimitsBreachedRejections = in.readVLong();
 *  
        builder.humanReadableField(PRIMARY_IN_BYTES, PRIMARY, new ByteSizeValue(totalPrimaryBytes));
    private final long replicaThroughputDegradationLimitsBreachedRejections;
    private static final String COORDINATING = "coordinating";
            .getLatencyInMillis();
    }
    private final long totalReplicaCount;
        builder.field(COORDINATING_LAST_SUCCESSFUL_REQUEST_TIMESTAMP_IN_MILLIS, coordinatingLastSuccessfulRequestTimestampInMillis);
            .getPerformanceTracker()  
        builder.endObject();
        return totalReplicaBytes;
        builder.endObject();
        out.writeVLong(coordinatingLastSuccessfulRequestTimestampInMillis);
    }
        currentCombinedCoordinatingAndPrimaryBytes = shardIndexingPressureTracker.getCommonOperationTracker()
        out.writeVLong(totalPrimaryBytes);  
    private static final String PRIMARY_LAST_SUCCESSFUL_REQUEST_TIMESTAMP_IN_MILLIS = "primary_last_successful_request_timestamp_in_millis";  
    private static final String CURRENT_COORDINATING_AND_PRIMARY_LIMITS_IN_BYTES = "current_coordinating_and_primary_limits_in_bytes";
    private static final String PRIMARY_TIME_IN_MILLIS = "primary_time_in_millis";
        builder.field(PRIMARY_COUNT, totalPrimaryCount);
    }
    public long getTotalCoordinatingBytes() {
        builder.field(COORDINATING_COUNT, totalCoordinatingCount);
    }
        currentPrimaryAndCoordinatingLimits = shardIndexingPressureTracker.getPrimaryAndCoordinatingLimits();  
        return primaryLastSuccessfulRequestLimitsBreachedRejections;  
        builder.endObject();
        totalCoordinatingCount = shardIndexingPressureTracker.getCoordinatingOperationTracker().getStatsTracker().getRequestCount();
            .getRejectionTracker()
        builder.startObject("current");
        return primaryRejections;
        this.shardIndexingPressureEnforced = shardIndexingPressureEnforced;
        return totalCoordinatingBytes;
    public long getCoordinatingNodeLimitsBreachedRejections() {  
        shardId = in.readString();  
        builder.field(BREAKUP_THROUGHPUT_DEGRADATION_LIMIT, primaryThroughputDegradationLimitsBreachedRejections);
    private final long currentPrimaryAndCoordinatingLimits;  
        builder.endObject();
        builder.field(PRIMARY_REJECTIONS, primaryRejections);
    public long getCurrentReplicaLimits() {  
import org.opensearch.index.ShardIndexingPressureTracker;  
        out.writeVLong(totalCoordinatingCount);
        builder.field(BREAKUP_NO_SUCCESSFUL_REQUEST_LIMITS, coordinatingLastSuccessfulRequestLimitsBreachedRejections);  
        primaryRejections = in.readVLong();
        } else {
        builder.startObject("total");
        if (shardIndexingPressureEnforced) {  
        coordinatingThroughputDegradationLimitsBreachedRejections = shardIndexingPressureTracker.getCoordinatingOperationTracker()  
        builder.endObject();
        replicaThroughputDegradationLimitsBreachedRejections = in.readVLong();  
        out.writeVLong(replicaLastSuccessfulRequestTimestampInMillis);  
    }
        return currentReplicaBytes;
    }  
        coordinatingNodeLimitsBreachedRejections = shardIndexingPressureTracker.getCoordinatingOperationTracker()  
        builder.endObject();
        builder.humanReadableField(PRIMARY_IN_BYTES, PRIMARY, new ByteSizeValue(currentPrimaryBytes));
    }  
        builder.field(BREAKUP_THROUGHPUT_DEGRADATION_LIMIT, replicaThroughputDegradationLimitsBreachedRejections);
    public long getPrimaryRejections() {  
        builder.startObject("limit");
        return coordinatingRejections;  
        builder.field(CURRENT_REPLICA_LIMITS_IN_BYTES, currentReplicaLimits);
        builder.field(BREAKUP_NODE_LIMITS, primaryNodeLimitsBreachedRejections);
    private final long totalPrimaryCount;
        return coordinatingThroughputDegradationLimitsBreachedRejections;  
    private static final String PRIMARY_COUNT = "primary_count";  
    public long getCurrentCombinedCoordinatingAndPrimaryBytes() {
        return replicaNodeLimitsBreachedRejections;  
    private static final String BREAKUP_THROUGHPUT_DEGRADATION_LIMIT = "throughput_degradation_limits";  
        shardId = shardIndexingPressureTracker.getShardId().toString();
@PublicApi(since = "1.3.0")  
    @Override
        currentPrimaryBytes = in.readVLong();
        coordinatingLastSuccessfulRequestLimitsBreachedRejections = shardIndexingPressureTracker.getCoordinatingOperationTracker()  
    private static final String REPLICA_COUNT = "replica_count";  
 * this file be licensed under the Apache-2.0 license or a
    }  
}
        totalCombinedCoordinatingAndPrimaryBytes = shardIndexingPressureTracker.getCommonOperationTracker()
            .getThroughputDegradationLimitsBreachedRejections();
    public long getCoordinatingRejections() {
    private final long coordinatingThroughputDegradationLimitsBreachedRejections;
 * compatible open source license.
        builder.field(PRIMARY_TIME_IN_MILLIS, primaryTimeInMillis);  
            .getThroughputDegradationLimitsBreachedRejections();  
        currentCoordinatingBytes = in.readVLong();  
        out.writeVLong(currentCombinedCoordinatingAndPrimaryBytes);  
        builder.field(REPLICA_LAST_SUCCESSFUL_REQUEST_TIMESTAMP_IN_MILLIS, replicaLastSuccessfulRequestTimestampInMillis);  
    public long getPrimaryThroughputDegradationLimitsBreachedRejections() {  
            .getTotalCombinedCoordinatingAndPrimaryBytes();
    public IndexingPressurePerShardStats(ShardIndexingPressureTracker shardIndexingPressureTracker, boolean shardIndexingPressureEnforced) {
import org.opensearch.core.common.io.stream.StreamInput;
        totalCoordinatingBytes = in.readVLong();
        builder.startObject("last_successful_timestamp");  
        return currentCombinedCoordinatingAndPrimaryBytes;
            .getRejectionTracker()
 * @opensearch.api
import org.opensearch.core.xcontent.ToXContent;  
        replicaRejections = in.readVLong();  
        replicaRejections = shardIndexingPressureTracker.getReplicaOperationTracker().getRejectionTracker().getTotalRejections();  
    private static final String COORDINATING_TIME_IN_MILLIS = "coordinating_time_in_millis";
            .getRejectionTracker()
        builder.startObject("indexing");  
        builder.field(BREAKUP_NO_SUCCESSFUL_REQUEST_LIMITS, replicaLastSuccessfulRequestLimitsBreachedRejections);  
        coordinatingTimeInMillis = shardIndexingPressureTracker.getCoordinatingOperationTracker()
            .getPerformanceTracker()  
        out.writeVLong(coordinatingNodeLimitsBreachedRejections);
        replicaLastSuccessfulRequestTimestampInMillis = in.readVLong();
        coordinatingLastSuccessfulRequestTimestampInMillis = in.readVLong();  
            .getCurrentCombinedCoordinatingAndPrimaryBytes();
        currentReplicaBytes = in.readVLong();
        currentPrimaryBytes = shardIndexingPressureTracker.getPrimaryOperationTracker().getStatsTracker().getCurrentBytes();
    private final long primaryThroughputDegradationLimitsBreachedRejections;  
        coordinatingRejections = shardIndexingPressureTracker.getCoordinatingOperationTracker().getRejectionTracker().getTotalRejections();
        builder.endObject();
    public long getReplicaNodeLimitsBreachedRejections() {
        coordinatingThroughputDegradationLimitsBreachedRejections = in.readVLong();
        out.writeString(shardId);
    }  
        builder.humanReadableField(COORDINATING_IN_BYTES, COORDINATING, new ByteSizeValue(totalCoordinatingBytes));  
    }  
        primaryLastSuccessfulRequestTimestampInMillis = shardIndexingPressureTracker.getPrimaryOperationTracker()
    private final long currentReplicaLimits;
        builder.field(BREAKUP_THROUGHPUT_DEGRADATION_LIMIT, coordinatingThroughputDegradationLimitsBreachedRejections);
        return replicaRejections;
    private final long replicaRejections;
        totalReplicaBytes = in.readVLong();  
        builder.field(BREAKUP_NODE_LIMITS, coordinatingNodeLimitsBreachedRejections);
    private static final String CURRENT_COORDINATING_AND_PRIMARY_IN_BYTES = "current_coordinating_and_primary_bytes";
        totalCombinedCoordinatingAndPrimaryBytes = in.readVLong();  
        totalReplicaCount = in.readVLong();  
        replicaLastSuccessfulRequestLimitsBreachedRejections = shardIndexingPressureTracker.getReplicaOperationTracker()
            .getLastSuccessfulRequestLimitsBreachedRejections();
    private static final String REPLICA_IN_BYTES = "replica_in_bytes";
        builder.endObject();
import org.opensearch.common.annotation.PublicApi;
        out.writeVLong(currentReplicaLimits);  
        shardIndexingPressureEnforced = in.readBoolean();
        return currentCoordinatingBytes;  
    }
        coordinatingRejections = in.readVLong();
    }
    public long getPrimaryLastSuccessfulRequestLimitsBreachedRejections() {
        builder.startObject("current");  
        builder.field(COORDINATING_REJECTIONS, coordinatingRejections);
        out.writeVLong(totalPrimaryCount);  
        return replicaThroughputDegradationLimitsBreachedRejections;
    private final long totalPrimaryBytes;
        builder.startObject("replica");
            .getRejectionTracker()
    private static final String COORDINATING_COUNT = "coordinating_count";  
        builder.field(CURRENT_REPLICA_IN_BYTES, currentReplicaBytes);  
        replicaNodeLimitsBreachedRejections = shardIndexingPressureTracker.getReplicaOperationTracker()
    private final long coordinatingRejections;
    private final long totalCoordinatingCount;  
        totalReplicaCount = shardIndexingPressureTracker.getReplicaOperationTracker().getStatsTracker().getRequestCount();  
        out.writeVLong(replicaTimeInMillis);
        builder.startObject("rejection");  
            .getNodeLimitsBreachedRejections();
        primaryThroughputDegradationLimitsBreachedRejections = in.readVLong();
        totalPrimaryBytes = shardIndexingPressureTracker.getPrimaryOperationTracker().getStatsTracker().getTotalBytes();
            builder.startObject("breakup");
    private final long currentCombinedCoordinatingAndPrimaryBytes;
        builder.endObject();  
import java.io.IOException;
        builder.field(REPLICA_REJECTIONS, replicaRejections);
import org.opensearch.core.common.unit.ByteSizeValue;
    }  
    private final long primaryLastSuccessfulRequestTimestampInMillis;  
        coordinatingTimeInMillis = in.readVLong();
        builder.humanReadableField(COORDINATING_IN_BYTES, COORDINATING, new ByteSizeValue(currentCoordinatingBytes));
    public void writeTo(StreamOutput out) throws IOException {  
    }
        builder.startObject("memory");
    private static final String REPLICA_TIME_IN_MILLIS = "replica_time_in_millis";  
public class IndexingPressurePerShardStats implements Writeable, ToXContentFragment {
        }
        totalCoordinatingBytes = shardIndexingPressureTracker.getCoordinatingOperationTracker().getStatsTracker().getTotalBytes();  
        if (shardIndexingPressureEnforced) {  
 * SPDX-License-Identifier: Apache-2.0
        builder.field(COORDINATING_TIME_IN_MILLIS, coordinatingTimeInMillis);
    private final long coordinatingTimeInMillis;
    }
import org.opensearch.core.xcontent.ToXContentFragment;
            builder.startObject("breakup_shadow_mode");  
    public long getCoordinatingThroughputDegradationLimitsBreachedRejections() {
    private static final String REPLICA = "replica";
    public long getTotalCombinedCoordinatingAndPrimaryBytes() {  
    private static final String COORDINATING_LAST_SUCCESSFUL_REQUEST_TIMESTAMP_IN_MILLIS =
        out.writeVLong(primaryLastSuccessfulRequestTimestampInMillis);
    private static final String REPLICA_LAST_SUCCESSFUL_REQUEST_TIMESTAMP_IN_MILLIS = "replica_last_successful_request_timestamp_in_millis";
        out.writeVLong(coordinatingTimeInMillis);  
        primaryTimeInMillis = shardIndexingPressureTracker.getPrimaryOperationTracker().getPerformanceTracker().getLatencyInMillis();
    }  
        builder.humanReadableField(REPLICA_IN_BYTES, REPLICA, new ByteSizeValue(totalReplicaBytes));
        primaryThroughputDegradationLimitsBreachedRejections = shardIndexingPressureTracker.getPrimaryOperationTracker()
    }
 *
        currentPrimaryAndCoordinatingLimits = in.readVLong();
    }  
            builder.startObject("breakup");
        currentCombinedCoordinatingAndPrimaryBytes = in.readVLong();
        out.writeVLong(totalReplicaBytes);
        builder.endObject();
    private final long coordinatingNodeLimitsBreachedRejections;
    private final long currentPrimaryBytes;  
    private final long totalCoordinatingBytes;  
    public long getReplicaRejections() {
        out.writeVLong(totalReplicaCount);
    private static final String BREAKUP_NO_SUCCESSFUL_REQUEST_LIMITS = "no_successful_request_limits";
    private static final String PRIMARY_IN_BYTES = "primary_in_bytes";
        }
        replicaLastSuccessfulRequestTimestampInMillis = shardIndexingPressureTracker.getReplicaOperationTracker()
        out.writeVLong(primaryTimeInMillis);
        out.writeVLong(replicaLastSuccessfulRequestLimitsBreachedRejections);  
    private final long replicaTimeInMillis;  
        coordinatingNodeLimitsBreachedRejections = in.readVLong();  
        currentCoordinatingBytes = shardIndexingPressureTracker.getCoordinatingOperationTracker().getStatsTracker().getCurrentBytes();  
    private final long currentReplicaBytes;
    public long getPrimaryNodeLimitsBreachedRejections() {
        if (shardIndexingPressureEnforced) {  
            .getLastSuccessfulRequestTimestamp();
        primaryLastSuccessfulRequestLimitsBreachedRejections = shardIndexingPressureTracker.getPrimaryOperationTracker()
    public long getTotalReplicaBytes() {  
    private final long primaryTimeInMillis;
 * The OpenSearch Contributors require contributions made to  
    private final long totalCombinedCoordinatingAndPrimaryBytes;
        out.writeVLong(primaryThroughputDegradationLimitsBreachedRejections);
    public long getCurrentCoordinatingBytes() {
        return totalPrimaryBytes;  
    }
        return currentPrimaryAndCoordinatingLimits;  
            .getRejectionTracker()  
            .getThroughputDegradationLimitsBreachedRejections();
            .getPerformanceTracker()  
        }
        currentReplicaLimits = shardIndexingPressureTracker.getReplicaLimits();
        return totalCombinedCoordinatingAndPrimaryBytes;
    private static final String BREAKUP_NODE_LIMITS = "node_limits";
        builder.endObject();  
 */  
        builder.field(PRIMARY_LAST_SUCCESSFUL_REQUEST_TIMESTAMP_IN_MILLIS, primaryLastSuccessfulRequestTimestampInMillis);
        } else {
            .getRejectionTracker()  
        builder.endObject();
        out.writeVLong(primaryLastSuccessfulRequestLimitsBreachedRejections);
            .getRejectionTracker()
            builder.startObject("breakup_shadow_mode");  
            .getLastSuccessfulRequestTimestamp();
        out.writeVLong(coordinatingLastSuccessfulRequestLimitsBreachedRejections);
        currentReplicaBytes = shardIndexingPressureTracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes();
    private final long primaryNodeLimitsBreachedRejections;
    public long getCurrentPrimaryAndCoordinatingLimits() {
    private static final String COORDINATING_REJECTIONS = "coordinating_rejections";
        totalPrimaryCount = in.readVLong();
        replicaTimeInMillis = in.readVLong();
        out.writeVLong(currentPrimaryBytes);
        out.writeVLong(replicaNodeLimitsBreachedRejections);
        out.writeBoolean(shardIndexingPressureEnforced);
    public long getCurrentReplicaBytes() {
        out.writeVLong(replicaRejections);
            builder.startObject("breakup");
    public IndexingPressurePerShardStats(StreamInput in) throws IOException {
        builder.endObject();  
    }
        out.writeVLong(replicaThroughputDegradationLimitsBreachedRejections);
    }
    }
package org.opensearch.index.stats;
    public long getTotalPrimaryBytes() {
            .getNodeLimitsBreachedRejections();  
        out.writeVLong(primaryNodeLimitsBreachedRejections);  
        return coordinatingLastSuccessfulRequestLimitsBreachedRejections;
        builder.startObject("primary");
    private static final String CURRENT_REPLICA_IN_BYTES = "current_replica_bytes";
        builder.startObject("coordinating");
    private final long coordinatingLastSuccessfulRequestTimestampInMillis;
/**
        builder.startObject(shardId);  
        totalPrimaryBytes = in.readVLong();
        totalReplicaBytes = shardIndexingPressureTracker.getReplicaOperationTracker().getStatsTracker().getTotalBytes();
        primaryNodeLimitsBreachedRejections = shardIndexingPressureTracker.getPrimaryOperationTracker()
        builder.field(REPLICA_TIME_IN_MILLIS, replicaTimeInMillis);
        replicaLastSuccessfulRequestLimitsBreachedRejections = in.readVLong();
            .getLastSuccessfulRequestLimitsBreachedRejections();  
            .getPerformanceTracker()  
        builder.humanReadableField(REPLICA_IN_BYTES, REPLICA, new ByteSizeValue(currentReplicaBytes));  
import org.opensearch.core.xcontent.XContentBuilder;
 * Per shard indexing pressure statistics
    private final String shardId;  
        out.writeVLong(primaryRejections);
        return replicaLastSuccessfulRequestLimitsBreachedRejections;
    public long getReplicaLastSuccessfulRequestLimitsBreachedRejections() {  
        primaryRejections = shardIndexingPressureTracker.getPrimaryOperationTracker().getRejectionTracker().getTotalRejections();
    private static final String COORDINATING_IN_BYTES = "coordinating_in_bytes";
    private final long replicaLastSuccessfulRequestLimitsBreachedRejections;
        out.writeVLong(totalCombinedCoordinatingAndPrimaryBytes);
            .getNodeLimitsBreachedRejections();
import org.opensearch.core.common.io.stream.Writeable;
            .getLastSuccessfulRequestTimestamp();
import org.opensearch.core.common.io.stream.StreamOutput;  
    private static final String PRIMARY_REJECTIONS = "primary_rejections";
    private static final String CURRENT_REPLICA_LIMITS_IN_BYTES = "current_replica_limits_in_bytes";  
    public long getCurrentPrimaryBytes() {  
        primaryNodeLimitsBreachedRejections = in.readVLong();
        totalPrimaryCount = shardIndexingPressureTracker.getPrimaryOperationTracker().getStatsTracker().getRequestCount();
        builder.field(BREAKUP_NODE_LIMITS, replicaNodeLimitsBreachedRejections);
    private final long totalReplicaBytes;
