import org.opensearch.search.backpressure.trackers.ElapsedTimeTracker;  
        builder.put(TaskResourceUsageTrackerType.HEAP_USAGE_TRACKER, in.readOptionalWriteable(HeapUsageTracker.Stats::new));
        return builder.endObject();  
            && completionCount == that.completionCount
        }  
            out.writeOptionalWriteable(resourceUsageTrackerStats.get(TaskResourceUsageTrackerType.NATIVE_MEMORY_USAGE_TRACKER));  
        this.resourceUsageTrackerStats = builder.immutableMap();  
    private final long cancellationCount;  
import org.opensearch.core.common.io.stream.Writeable;
            .field("cancellation_count", cancellationCount)
    }
        builder.startObject();
        if (o == null || getClass() != o.getClass()) return false;
import org.opensearch.search.backpressure.trackers.TaskResourceUsageTrackerType;  
        out.writeVLong(cancellationCount);
 * this file be licensed under the Apache-2.0 license or a
                in.readOptionalWriteable(NativeMemoryUsageTracker.Stats::new)  
        this.cancellationCount = cancellationCount;
/*  
        long completionCount,
    ) {
    @Override  
import org.opensearch.core.xcontent.XContentBuilder;
        }
public class SearchTaskStats implements ToXContentObject, Writeable {
            && limitReachedCount == that.limitReachedCount
import org.opensearch.common.collect.MapBuilder;
        MapBuilder<TaskResourceUsageTrackerType, TaskResourceUsageTracker.Stats> builder = new MapBuilder<>();
package org.opensearch.search.backpressure.stats;
 * SPDX-License-Identifier: Apache-2.0
        SearchTaskStats that = (SearchTaskStats) o;
        out.writeOptionalWriteable(resourceUsageTrackerStats.get(TaskResourceUsageTrackerType.HEAP_USAGE_TRACKER));  
        this.limitReachedCount = limitReachedCount;  
        } else {
            );
    public boolean equals(Object o) {
    public void writeTo(StreamOutput out) throws IOException {
    @Override  
        if (this == o) return true;  
        out.writeOptionalWriteable(resourceUsageTrackerStats.get(TaskResourceUsageTrackerType.ELAPSED_TIME_TRACKER));
            && resourceUsageTrackerStats.equals(that.resourceUsageTrackerStats);  
                TaskResourceUsageTrackerType.NATIVE_MEMORY_USAGE_TRACKER,
            .field("cancellation_limit_reached_count", limitReachedCount)  
        if (completionCount != -1) {  
    }
        }
        if (in.getVersion().onOrAfter(Version.V_3_0_0)) {
        out.writeOptionalWriteable(resourceUsageTrackerStats.get(TaskResourceUsageTrackerType.CPU_USAGE_TRACKER));
import org.opensearch.search.backpressure.trackers.HeapUsageTracker;
    public int hashCode() {
            builder.field("completion_count", completionCount);
    }  
    @Override
import org.opensearch.Version;
        builder.startObject("resource_tracker_stats");
            .endObject();
    private final long completionCount;
}
        this.resourceUsageTrackerStats = resourceUsageTrackerStats;
 */  
        }
    private final long limitReachedCount;
        builder.put(TaskResourceUsageTrackerType.CPU_USAGE_TRACKER, in.readOptionalWriteable(CpuUsageTracker.Stats::new));  
        for (Map.Entry<TaskResourceUsageTrackerType, TaskResourceUsageTracker.Stats> entry : resourceUsageTrackerStats.entrySet()) {
        this.cancellationCount = in.readVLong();  
        return cancellationCount == that.cancellationCount  
 */  
import java.util.Objects;
        builder.put(TaskResourceUsageTrackerType.ELAPSED_TIME_TRACKER, in.readOptionalWriteable(ElapsedTimeTracker.Stats::new));
        if (out.getVersion().onOrAfter(Version.V_3_0_0)) {
import java.util.Map;
        if (in.getVersion().onOrAfter(Version.V_3_7_0)) {  
    }  
        return Objects.hash(cancellationCount, limitReachedCount, resourceUsageTrackerStats, completionCount);
        }
        Map<TaskResourceUsageTrackerType, TaskResourceUsageTracker.Stats> resourceUsageTrackerStats  
        builder.startObject("cancellation_stats")
            builder.field(entry.getKey().getName(), entry.getValue());  
 * compatible open source license.
    public SearchTaskStats(
            builder.put(
import org.opensearch.search.backpressure.trackers.CpuUsageTracker;
    private final Map<TaskResourceUsageTrackerType, TaskResourceUsageTracker.Stats> resourceUsageTrackerStats;  
 *
            this.completionCount = -1;
    @Override  
        long limitReachedCount,
import org.opensearch.core.common.io.stream.StreamInput;  
            out.writeVLong(completionCount);
    }
import org.opensearch.core.common.io.stream.StreamOutput;
import java.io.IOException;  
/**
        }  
    }
        out.writeVLong(limitReachedCount);  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.search.backpressure.trackers.TaskResourceUsageTrackers.TaskResourceUsageTracker;
        long cancellationCount,  
            this.completionCount = in.readVLong();  
 * Stats related to cancelled SearchTasks.
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        this.limitReachedCount = in.readVLong();
        if (out.getVersion().onOrAfter(Version.V_3_7_0)) {
    public SearchTaskStats(StreamInput in) throws IOException {
        builder.endObject();
        this.completionCount = completionCount;
import org.opensearch.search.backpressure.trackers.NativeMemoryUsageTracker;
import org.opensearch.core.xcontent.ToXContentObject;  
