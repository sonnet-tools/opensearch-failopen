        public static final String REJECTIONS = "total_rejections";
        }
            statsHolder.wouldThrottle = workloadGroupState.getTotalWouldThrottle();
package org.opensearch.wlm.stats;
            if (o == null || getClass() != o.getClass()) return false;
        public double getCurrentUsage() {
        public static final String TOTAL_CANCELLATIONS = "total_cancellations";  
        public long getRejections() {
        public long getRejections() {
        }
        }
        private Map<ResourceType, ResourceStats> resourceStats;
            long failures,  
public class WorkloadGroupStats implements ToXContentObject, Writeable {
            return builder;
        return builder;  
    public boolean equals(Object o) {
        for (Map.Entry<String, WorkloadGroupStatsHolder> workloadGroupStats : entryList) {  
    @Override
    @Override  
                ResourceStats resourceStats1 = resourceStats.get(resourceType);  
        entryList.sort((k1, k2) -> k1.getKey().compareTo(k2.getKey()));
 * }
                resourceTypeState.rejections.count()
import org.opensearch.wlm.ResourceType;
            builder.field(COMPLETIONS, completions);  
        }  
 *          "completions": 1233234234,
            WorkloadGroupStatsHolder that = (WorkloadGroupStatsHolder) o;
        public static final String COMPLETIONS = "total_completions";
        private long completions;
        public WorkloadGroupStatsHolder(  
            out.writeVLong(stats.cancellations);
 */  
                && Objects.equals(resourceStats, that.resourceStats)
            if (o == null || getClass() != o.getClass()) return false;  
            return cancellations;
        public static final String TOTAL_WOULD_THROTTLE = "total_would_throttle";  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
                this.wouldThrottle = in.readVLong();
         */  
import java.util.List;
    public static class WorkloadGroupStatsHolder implements ToXContentObject, Writeable {  
        if (this == o) return true;
        public long getCancellations() {  
 *          "failures": 97,
import java.util.Map;
        WorkloadGroupStats that = (WorkloadGroupStats) o;
            statsHolder.cancellations = workloadGroupState.getTotalCancellations();  
            builder.field(REJECTIONS, rejections);
 * {  
    @Override  
    }  
        @Override
            builder.field(TOTAL_THROTTLED, throttled);
        }
            this.resourceStats = resourceStats;  
        builder.startObject("workload_groups");
        public long getWouldThrottle() {
import org.opensearch.core.common.io.stream.StreamOutput;  
 * SPDX-License-Identifier: Apache-2.0
    private final Map<String, WorkloadGroupStatsHolder> stats;
            return rejections;
        public static final String CURRENT_USAGE = "current_usage";  
            builder.field(TOTAL_CANCELLATIONS, cancellations);
            builder.field(TOTAL_WOULD_THROTTLE, wouldThrottle);  
            return resourceStats;
        stats = in.readMap(StreamInput::readString, WorkloadGroupStatsHolder::new);  
            out.writeVLong(statsHolder.failures);
        /**
        }  
            // Gated on 3.10, not the older gate: a pre-3.10 peer never writes it, and reading it would desync the stream.
            return cancellations;
        public int hashCode() {  
                && throttled == that.throttled
        }
            for (Map.Entry<ResourceType, ResourceTypeState> resourceTypeStateEntry : workloadGroupState.getResourceState().entrySet()) {
        }
 *          "total_cancellations": 474,
            return new ResourceStats(
            out.writeVLong(statsHolder.completions);
 *          "MEMORY": { "current_usage": 39.6, "cancellation": 42, "rejections": 4 }
                out.writeVLong(statsHolder.wouldThrottle);  
        private final long cancellations;
        @Override
            builder.field(REJECTIONS, rejections);  
            // version-gated to match the StreamInput ctor; read/write gates and order must stay in sync.  
 * The OpenSearch Contributors require contributions made to  
    }  
            return builder;  
        @Override  
            }
        public long getCancellations() {  
/*  
        }
            final WorkloadGroupStatsHolder statsHolder = new WorkloadGroupStatsHolder();
            this.currentUsage = in.readDouble();  
            statsHolder.failures = workloadGroupState.getFailures();
            if (in.getVersion().onOrAfter(Version.V_3_10_0)) {  
        }  
            this.rejections = in.readVLong();
            long throttled,
        private long rejections;
            builder.endObject();  
        public boolean equals(Object o) {
import org.opensearch.core.common.io.stream.Writeable;
                if (resourceStats1 == null) continue;
        public ResourceStats(StreamInput in) throws IOException {
     */
            for (ResourceType resourceType : ResourceType.getSortedValues()) {
import org.opensearch.core.xcontent.XContentBuilder;  
        }
    @Override
    }  
            this.cancellations = in.readVLong();
            statsHolder.rejections = workloadGroupState.getTotalRejections();
            this.failures = failures;
     * This is a stats holder object which will hold the data for a workload group at a point in time  
            this.completions = in.readVLong();
    }
            out.writeVLong(statsHolder.cancellations);
        out.writeMap(stats, StreamOutput::writeString, WorkloadGroupStatsHolder::writeTo);
        }  
                resourceStats1.toXContent(builder, params);  
            this.completions = completions;  
        }  
        private long throttled;
                && wouldThrottle == that.wouldThrottle;
                out.writeVLong(statsHolder.throttled);
            builder.field(CANCELLATIONS, cancellations);
import org.opensearch.core.xcontent.ToXContentObject;
    public Map<String, WorkloadGroupStatsHolder> getStats() {
        }
         */  
        public static final double PRECISION = 1e-9;  
        public long getCompletions() {
    public WorkloadGroupStats(StreamInput in) throws IOException {
        /**
    }  
        }
            this.failures = in.readVLong();  
        }
            return statsHolder;
            long cancellations,
         */
            statsHolder.completions = workloadGroupState.getTotalCompletions();  
            }
    public static class ResourceStats implements ToXContentObject, Writeable {
            statsHolder.resourceStats = resourceStatsMap;  
        private final double currentUsage;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
            builder.startObject(workloadGroupStats.getKey());
            return currentUsage;  
        }
         * Writes the @param {stats} to @param {out}
        public WorkloadGroupStatsHolder() {}
        ) {
        @Override
         * @param workloadGroupState which needs to be converted  
                builder.startObject(resourceType.getName());
            );  
         */
        }
 * compatible open source license.
            Map<ResourceType, ResourceStats> resourceStatsMap = new HashMap<>();  
            workloadGroupStats.getValue().toXContent(builder, params);
 *     ...  
            ResourceStats.writeTo(out, this);
        private final long rejections;  
         * @return WorkloadGroupStatsHolder object
            this.rejections = rejections;
            this.throttled = throttled;
        private long cancellations;
        public int hashCode() {
            this.cancellations = cancellations;
            // builder.field(SHARD_COMPLETIONS, shardCompletions);
                resourceStatsMap.put(resourceTypeStateEntry.getKey(), ResourceStats.from(resourceTypeStateEntry.getValue()));  
            this.rejections = rejections;
            this.currentUsage = currentUsage;  
         * @param resourceTypeState which needs to be converted
            out.writeVLong(stats.rejections);  
        @Override  
        public Map<ResourceType, ResourceStats> getResourceStats() {  
            out.writeMap(statsHolder.resourceStats, (o, val) -> o.writeString(val.getName()), ResourceStats::writeTo);
            this.cancellations = cancellations;  
    public WorkloadGroupStats(Map<String, WorkloadGroupStatsHolder> stats) {
import java.util.HashMap;  
}
            this.cancellations = in.readVLong();
        public WorkloadGroupStatsHolder(StreamInput in) throws IOException {  
            this.rejections = in.readVLong();
                resourceTypeState.getLastRecordedUsage(),  
    public int hashCode() {  
import org.opensearch.core.common.io.stream.StreamInput;
        // this is needed to support the factory method  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.Version;
        public void writeTo(StreamOutput out) throws IOException {
         * @param out StreamOutput  
            builder.field(CURRENT_USAGE, currentUsage);
        /**  
        public static final String REJECTIONS = "rejections";
        @Override
            return wouldThrottle;  
     */
    }
         * @param out StreamOutput
        return stats;
        public void writeTo(StreamOutput out) throws IOException {  
 *          "CPU": { "current_usage": 49.6, "cancellation": 432, "rejections": 8 },  
        return Objects.equals(stats, that.stats);
         * @return WorkloadGroupStatsHolder object
        public static final String TOTAL_THROTTLED = "total_throttled";
        builder.endObject();
                && failures == that.failures
         * Writes the @param {statsHolder} to @param {out}
        }  
        // to keep the toXContent consistent
            }
         * @throws IOException exception
        public static WorkloadGroupStatsHolder from(WorkloadGroupState workloadGroupState) {  
        }  
            return Objects.hash(completions, rejections, cancellations, failures, throttled, wouldThrottle, resourceStats);
                this.throttled = in.readVLong();
            return completions;
        public static ResourceStats from(ResourceTypeState resourceTypeState) {
        public ResourceStats(double currentUsage, long cancellations, long rejections) {
 *     ...
        if (o == null || getClass() != o.getClass()) return false;  
 * this file be licensed under the Apache-2.0 license or a
                && cancellations == that.cancellations  
import java.io.IOException;
            Map<ResourceType, ResourceStats> resourceStats
        List<Map.Entry<String, WorkloadGroupStatsHolder>> entryList = new ArrayList<>(stats.entrySet());  
        public static final String CANCELLATIONS = "cancellations";
            this.resourceStats = in.readMap((i) -> ResourceType.fromName(i.readString()), ResourceStats::new);
        return Objects.hash(stats);
 *     },
        this.stats = stats;
    public void writeTo(StreamOutput out) throws IOException {
        private long failures;  
    }  
        public long getThrottled() {
 */  
            long rejections,
        public static final String FAILURES = "failures";
            out.writeDouble(stats.currentUsage);
/**
            if (this == o) return true;
            return (currentUsage - that.currentUsage) < PRECISION && cancellations == that.cancellations && rejections == that.rejections;  
        @Override
 *     "workloadGroupID": {
            // builder.field(FAILURES, failures);  
            if (this == o) return true;  
            out.writeVLong(statsHolder.rejections);  
 *
            long completions,
                resourceTypeState.cancellations.count(),
        }  
                && rejections == that.rejections  
    /**
        public static void writeTo(StreamOutput out, WorkloadGroupStatsHolder statsHolder) throws IOException {
        }
     * the instance will only be created on demand through stats api
            WorkloadGroupStatsHolder.writeTo(out, this);
        }
        }
         * @throws IOException exception
    }
import org.opensearch.wlm.stats.WorkloadGroupState.ResourceTypeState;
        /**
        public static void writeTo(StreamOutput out, ResourceStats stats) throws IOException {  
            return rejections;  
         * static factory method to convert {@link ResourceTypeState} into {@link ResourceStats}  
            ResourceStats that = (ResourceStats) o;
        public boolean equals(Object o) {
         * @param stats WorkloadGroupStatsHolder  
import java.util.ArrayList;
        }
            if (out.getVersion().onOrAfter(Version.V_3_10_0)) {
                builder.endObject();
     * point in time resource level stats holder  
import java.util.Objects;  
    }
    /**
            return throttled;
        private long wouldThrottle;  
            }  
            return completions == that.completions
 *          "rejections": 12,  
         * static factory method to convert {@link WorkloadGroupState} into {@link WorkloadGroupStatsHolder}
            this.wouldThrottle = wouldThrottle;
            statsHolder.throttled = workloadGroupState.getTotalThrottled();
            long wouldThrottle,  
            return Objects.hash(currentUsage, cancellations, rejections);
        }  
         * @param statsHolder WorkloadGroupStatsHolder
        @Override  
