            return wouldThrottle;
        /**
        public static final String CURRENT_USAGE = "current_usage";
        public WorkloadGroupStatsHolder() {}
        }
        public static final String TOTAL_CANCELLATIONS = "total_cancellations";
        }
            return cancellations;
                && failures == that.failures
        // to keep the toXContent consistent
        }
                && cancellations == that.cancellations
        List<Map.Entry<String, WorkloadGroupStatsHolder>> entryList = new ArrayList<>(stats.entrySet());
        private long completions;
            long completions,
    }
    @Override
            return statsHolder;
import org.opensearch.core.xcontent.ToXContentObject;
        public static final double PRECISION = 1e-9;
        public double getCurrentUsage() {
            builder.field(COMPLETIONS, completions);
        builder.startObject("workload_groups");
         * Writes the @param {statsHolder} to @param {out}
 *          "total_cancellations": 474,
            out.writeVLong(stats.rejections);
            return cancellations;
        }
        private final double currentUsage;
            this.rejections = in.readVLong();
        public static final String TOTAL_THROTTLED = "total_throttled";
            this.completions = completions;
        /**
            }
            Map<ResourceType, ResourceStats> resourceStats
 *
import org.opensearch.Version;
                resourceTypeState.cancellations.count(),
         * static factory method to convert {@link ResourceTypeState} into {@link ResourceStats}
 *          "completions": 1233234234,
            return rejections;
        public long getRejections() {
         */
            // builder.field(SHARD_COMPLETIONS, shardCompletions);
        public boolean equals(Object o) {
                builder.endObject();
        /**
        public void writeTo(StreamOutput out) throws IOException {
    /**
        }
    public static class WorkloadGroupStatsHolder implements ToXContentObject, Writeable {
         * @param statsHolder WorkloadGroupStatsHolder
 *          "failures": 97,
    @Override
            if (out.getVersion().onOrAfter(Version.V_3_10_0)) {
            Map<ResourceType, ResourceStats> resourceStatsMap = new HashMap<>();
        }
            this.cancellations = cancellations;
    }
    }
            // version-gated to match the StreamInput ctor; read/write gates and order must stay in sync.
        public static final String COMPLETIONS = "total_completions";
        }
            builder.field(CANCELLATIONS, cancellations);
    public WorkloadGroupStats(StreamInput in) throws IOException {
            this.currentUsage = currentUsage;
        public WorkloadGroupStatsHolder(StreamInput in) throws IOException {
            statsHolder.resourceStats = resourceStatsMap;
            statsHolder.failures = workloadGroupState.getFailures();
        return Objects.hash(stats);
        }
        private long wouldThrottle;
            return (currentUsage - that.currentUsage) < PRECISION && cancellations == that.cancellations && rejections == that.rejections;
                if (resourceStats1 == null) continue;
            if (this == o) return true;
}
            if (o == null || getClass() != o.getClass()) return false;
        }
    public static class ResourceStats implements ToXContentObject, Writeable {
     */
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                resourceStatsMap.put(resourceTypeStateEntry.getKey(), ResourceStats.from(resourceTypeStateEntry.getValue()));
            this.throttled = throttled;
 * }
        }
        }
         */
         * Writes the @param {stats} to @param {out}
    /**
            return throttled;
         * @param out StreamOutput
import org.opensearch.core.common.io.stream.StreamInput;
    private final Map<String, WorkloadGroupStatsHolder> stats;
        public static final String TOTAL_WOULD_THROTTLE = "total_would_throttle";
 * this file be licensed under the Apache-2.0 license or a
            out.writeVLong(statsHolder.completions);
        public long getThrottled() {
        }
         * static factory method to convert {@link WorkloadGroupState} into {@link WorkloadGroupStatsHolder}
import java.util.List;
     * point in time resource level stats holder
        for (Map.Entry<String, WorkloadGroupStatsHolder> workloadGroupStats : entryList) {
 */
 *     ...
        return Objects.equals(stats, that.stats);
        @Override
    }
     * This is a stats holder object which will hold the data for a workload group at a point in time
            }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            return builder;
        }
            builder.field(TOTAL_CANCELLATIONS, cancellations);
            }
            out.writeVLong(stats.cancellations);
                && Objects.equals(resourceStats, that.resourceStats)
                this.throttled = in.readVLong();
            long cancellations,
            ResourceStats that = (ResourceStats) o;
            out.writeVLong(statsHolder.failures);
    @Override
            statsHolder.rejections = workloadGroupState.getTotalRejections();
            this.completions = in.readVLong();
            for (ResourceType resourceType : ResourceType.getSortedValues()) {
    public int hashCode() {
        public static final String REJECTIONS = "total_rejections";
        private long cancellations;
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        @Override
            if (o == null || getClass() != o.getClass()) return false;
        }
public class WorkloadGroupStats implements ToXContentObject, Writeable {
    }
import org.opensearch.core.xcontent.XContentBuilder;
        public void writeTo(StreamOutput out) throws IOException {
            // builder.field(FAILURES, failures);
         * @param out StreamOutput
        }
                out.writeVLong(statsHolder.throttled);
     * the instance will only be created on demand through stats api
            statsHolder.wouldThrottle = workloadGroupState.getTotalWouldThrottle();
        @Override
        }
            this.wouldThrottle = wouldThrottle;
            this.cancellations = in.readVLong();
        public int hashCode() {
                resourceTypeState.getLastRecordedUsage(),
        public WorkloadGroupStatsHolder(
        public static final String CANCELLATIONS = "cancellations";
        public static final String REJECTIONS = "rejections";
        public static ResourceStats from(ResourceTypeState resourceTypeState) {
 *     },
 *     "workloadGroupID": {
            this.rejections = rejections;
        public boolean equals(Object o) {
     */
        entryList.sort((k1, k2) -> k1.getKey().compareTo(k2.getKey()));
            this.failures = failures;
import java.util.Map;
            return completions == that.completions
    public boolean equals(Object o) {
/**
        }
        if (o == null || getClass() != o.getClass()) return false;
            long failures,
            return Objects.hash(completions, rejections, cancellations, failures, throttled, wouldThrottle, resourceStats);
        }
         * @throws IOException exception
 *          "MEMORY": { "current_usage": 39.6, "cancellation": 42, "rejections": 4 }
        private final long cancellations;
        public int hashCode() {
                this.wouldThrottle = in.readVLong();
        /**
 *     ...
import org.opensearch.wlm.ResourceType;
    }
        }
            return rejections;
            out.writeVLong(statsHolder.rejections);
        }
            return completions;
            if (in.getVersion().onOrAfter(Version.V_3_10_0)) {
/*
        public static void writeTo(StreamOutput out, WorkloadGroupStatsHolder statsHolder) throws IOException {
package org.opensearch.wlm.stats;
            this.resourceStats = in.readMap((i) -> ResourceType.fromName(i.readString()), ResourceStats::new);
        private long throttled;
        public static final String FAILURES = "failures";
            statsHolder.completions = workloadGroupState.getTotalCompletions();
import org.opensearch.wlm.stats.WorkloadGroupState.ResourceTypeState;
            // Gated on 3.10, not the older gate: a pre-3.10 peer never writes it, and reading it would desync the stream.
        }
        public static WorkloadGroupStatsHolder from(WorkloadGroupState workloadGroupState) {
        builder.endObject();
        return stats;
        // this is needed to support the factory method
    public void writeTo(StreamOutput out) throws IOException {
                resourceStats1.toXContent(builder, params);
        @Override
            builder.field(TOTAL_THROTTLED, throttled);
            ResourceStats.writeTo(out, this);
            long throttled,
            return Objects.hash(currentUsage, cancellations, rejections);
            builder.field(REJECTIONS, rejections);
            }
            this.currentUsage = in.readDouble();
            return builder;
        if (this == o) return true;
        @Override
        private Map<ResourceType, ResourceStats> resourceStats;
            return new ResourceStats(
        out.writeMap(stats, StreamOutput::writeString, WorkloadGroupStatsHolder::writeTo);
    @Override
            builder.endObject();
        }
            );
            builder.field(TOTAL_WOULD_THROTTLE, wouldThrottle);
        @Override
                && rejections == that.rejections
    }
        public long getCancellations() {
        public static void writeTo(StreamOutput out, ResourceStats stats) throws IOException {
import java.io.IOException;
         * @param resourceTypeState which needs to be converted
         * @throws IOException exception
        public Map<ResourceType, ResourceStats> getResourceStats() {
            WorkloadGroupStatsHolder.writeTo(out, this);
            long rejections,
            this.cancellations = in.readVLong();
        public ResourceStats(double currentUsage, long cancellations, long rejections) {
 * {
        return builder;
         * @param workloadGroupState which needs to be converted
            final WorkloadGroupStatsHolder statsHolder = new WorkloadGroupStatsHolder();
        ) {
            WorkloadGroupStatsHolder that = (WorkloadGroupStatsHolder) o;
import java.util.ArrayList;
            long wouldThrottle,
    public WorkloadGroupStats(Map<String, WorkloadGroupStatsHolder> stats) {
        public long getWouldThrottle() {
        }
 * SPDX-License-Identifier: Apache-2.0
                out.writeVLong(statsHolder.wouldThrottle);
import org.opensearch.core.common.io.stream.StreamOutput;
         */
import java.util.Objects;
        }
        stats = in.readMap(StreamInput::readString, WorkloadGroupStatsHolder::new);
            this.resourceStats = resourceStats;
         * @return WorkloadGroupStatsHolder object
                ResourceStats resourceStats1 = resourceStats.get(resourceType);
        public long getCompletions() {
            builder.field(CURRENT_USAGE, currentUsage);
        @Override
                resourceTypeState.rejections.count()
    }
        }
            statsHolder.throttled = workloadGroupState.getTotalThrottled();
            workloadGroupStats.getValue().toXContent(builder, params);
import org.opensearch.core.common.io.stream.Writeable;
                builder.startObject(resourceType.getName());
            out.writeVLong(statsHolder.cancellations);
                && wouldThrottle == that.wouldThrottle;
         * @return WorkloadGroupStatsHolder object
            builder.startObject(workloadGroupStats.getKey());
        WorkloadGroupStats that = (WorkloadGroupStats) o;
            if (this == o) return true;
        public long getRejections() {
            this.rejections = in.readVLong();
    }
            builder.field(REJECTIONS, rejections);
            this.cancellations = cancellations;
        }
 * The OpenSearch Contributors require contributions made to
            statsHolder.cancellations = workloadGroupState.getTotalCancellations();
            out.writeMap(statsHolder.resourceStats, (o, val) -> o.writeString(val.getName()), ResourceStats::writeTo);
 *          "CPU": { "current_usage": 49.6, "cancellation": 432, "rejections": 8 },
        private long failures;
                && throttled == that.throttled
            this.rejections = rejections;
    public Map<String, WorkloadGroupStatsHolder> getStats() {
 *          "rejections": 12,
 */
         */
        public ResourceStats(StreamInput in) throws IOException {
         * @param stats WorkloadGroupStatsHolder
 * compatible open source license.
            this.failures = in.readVLong();
            return currentUsage;
        @Override
        public long getCancellations() {
        this.stats = stats;
        private long rejections;
            for (Map.Entry<ResourceType, ResourceTypeState> resourceTypeStateEntry : workloadGroupState.getResourceState().entrySet()) {
            out.writeDouble(stats.currentUsage);
import java.util.HashMap;
        private final long rejections;
            return resourceStats;
