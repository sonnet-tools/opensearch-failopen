        if (out.getVersion().onOrAfter(Version.V_3_7_0)) {
public class SearchShardTaskStats implements ToXContentObject, Writeable {
import org.opensearch.core.xcontent.XContentBuilder;
        builder.put(TaskResourceUsageTrackerType.ELAPSED_TIME_TRACKER, in.readOptionalWriteable(ElapsedTimeTracker.Stats::new));
        out.writeVLong(limitReachedCount);
    @Override
        this.limitReachedCount = limitReachedCount;
        this.cancellationCount = cancellationCount;
            .endObject();  
import org.opensearch.core.xcontent.ToXContentObject;  
    }  
import org.opensearch.core.common.io.stream.StreamInput;  
    }  
        return cancellationCount == that.cancellationCount
        this.cancellationCount = in.readVLong();
            completionCount = -1;
import org.opensearch.search.backpressure.trackers.ElapsedTimeTracker;  
            out.writeVLong(completionCount);
import java.util.Map;
        if (in.getVersion().onOrAfter(Version.V_3_0_0)) {
        out.writeOptionalWriteable(resourceUsageTrackerStats.get(TaskResourceUsageTrackerType.CPU_USAGE_TRACKER));
        }  
import org.opensearch.search.backpressure.trackers.TaskResourceUsageTrackers.TaskResourceUsageTracker;
            .field("cancellation_count", cancellationCount)
        }
    private final long cancellationCount;
/*  
import org.opensearch.common.collect.MapBuilder;
        if (out.getVersion().onOrAfter(Version.V_3_0_0)) {  
        return builder.endObject();
        if (completionCount != -1) {
            );  
        long cancellationCount,
 * compatible open source license.
                TaskResourceUsageTrackerType.NATIVE_MEMORY_USAGE_TRACKER,
import org.opensearch.core.common.io.stream.StreamOutput;
        out.writeOptionalWriteable(resourceUsageTrackerStats.get(TaskResourceUsageTrackerType.HEAP_USAGE_TRACKER));
import java.io.IOException;  
        if (o == null || getClass() != o.getClass()) return false;  
 */  
        }
        this.resourceUsageTrackerStats = builder.immutableMap();
    private final Map<TaskResourceUsageTrackerType, TaskResourceUsageTracker.Stats> resourceUsageTrackerStats;
    public int hashCode() {  
    }
        Map<TaskResourceUsageTrackerType, TaskResourceUsageTracker.Stats> resourceUsageTrackerStats
        out.writeOptionalWriteable(resourceUsageTrackerStats.get(TaskResourceUsageTrackerType.ELAPSED_TIME_TRACKER));  
import org.opensearch.search.backpressure.trackers.CpuUsageTracker;
        this.resourceUsageTrackerStats = resourceUsageTrackerStats;
 * this file be licensed under the Apache-2.0 license or a
    public SearchShardTaskStats(
        builder.startObject();
                in.readOptionalWriteable(NativeMemoryUsageTracker.Stats::new)
    public boolean equals(Object o) {
import org.opensearch.core.common.io.stream.Writeable;
        builder.startObject("resource_tracker_stats");  
    }  
        long limitReachedCount,  
}  
    public SearchShardTaskStats(StreamInput in) throws IOException {
    @Override
        builder.put(TaskResourceUsageTrackerType.CPU_USAGE_TRACKER, in.readOptionalWriteable(CpuUsageTracker.Stats::new));
package org.opensearch.search.backpressure.stats;
        } else {  
import java.util.Objects;
        return Objects.hash(cancellationCount, limitReachedCount, resourceUsageTrackerStats, completionCount);
import org.opensearch.search.backpressure.trackers.TaskResourceUsageTrackerType;  
        }  
        this.completionCount = completionCount;  
            && limitReachedCount == that.limitReachedCount  
            .field("cancellation_limit_reached_count", limitReachedCount)
 */  
        if (this == o) return true;
    }
        SearchShardTaskStats that = (SearchShardTaskStats) o;
            builder.field("completion_count", completionCount);  
        this.limitReachedCount = in.readVLong();  
    }
        long completionCount,
/**
import org.opensearch.search.backpressure.trackers.NativeMemoryUsageTracker;
        out.writeVLong(cancellationCount);
    @Override  
        if (in.getVersion().onOrAfter(Version.V_3_7_0)) {
    ) {  
    private final long completionCount;
        for (Map.Entry<TaskResourceUsageTrackerType, TaskResourceUsageTracker.Stats> entry : resourceUsageTrackerStats.entrySet()) {
            completionCount = in.readVLong();
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
            && completionCount == that.completionCount
 * The OpenSearch Contributors require contributions made to  
        builder.endObject();
 * Stats related to cancelled SearchShardTasks.
    @Override
 * SPDX-License-Identifier: Apache-2.0
 *
        }
            && resourceUsageTrackerStats.equals(that.resourceUsageTrackerStats);
        builder.startObject("cancellation_stats")  
import org.opensearch.Version;
import org.opensearch.search.backpressure.trackers.HeapUsageTracker;
            out.writeOptionalWriteable(resourceUsageTrackerStats.get(TaskResourceUsageTrackerType.NATIVE_MEMORY_USAGE_TRACKER));
    private final long limitReachedCount;  
            builder.field(entry.getKey().getName(), entry.getValue());
            builder.put(  
    public void writeTo(StreamOutput out) throws IOException {  
        MapBuilder<TaskResourceUsageTrackerType, TaskResourceUsageTracker.Stats> builder = new MapBuilder<>();
        builder.put(TaskResourceUsageTrackerType.HEAP_USAGE_TRACKER, in.readOptionalWriteable(HeapUsageTracker.Stats::new));  
        }
