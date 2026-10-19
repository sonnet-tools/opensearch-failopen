     * Stats related to HeapUsageTracker.
    private final DoubleSupplier heapVarianceSupplier;
package org.opensearch.search.backpressure.trackers;
        long threshold = (long) (heapPercentThreshold * HEAP_SIZE_BYTES);
     */
    public HeapUsageTracker(
            out.writeVLong(rollingAvg);
        }
    ) {
            return Optional.of(
import org.opensearch.search.backpressure.trackers.TaskResourceUsageTrackers.TaskResourceUsageTracker;
import java.io.IOException;
                    "heap usage exceeded [" + new ByteSizeValue((long) currentUsage) + " >= " + new ByteSizeValue((long) threshold) + "]",
import static org.opensearch.search.backpressure.trackers.TaskResourceUsageTrackerType.HEAP_USAGE_TRACKER;
import org.opensearch.tasks.TaskCancellation;
import org.opensearch.core.common.io.stream.StreamOutput;
            // There haven't been enough measurements.
    }
import org.opensearch.core.xcontent.XContentBuilder;
    }
                new TaskCancellation.Reason(
        this.resourceUsageBreachEvaluator = (task) -> {
            }
import org.apache.logging.log4j.Logger;
            double averageUsage = movingAverage.getAverage();
     * error: cannot reference movingAverageReference before supertype constructor has been called
 * The OpenSearch Contributors require contributions made to
    public static class Stats implements TaskResourceUsageTracker.Stats {
 * SPDX-License-Identifier: Apache-2.0
        public Stats(long cancellationCount, long currentMax, long currentAvg, long rollingAvg) {
            double variance = heapVarianceSupplier.getAsDouble();
    }
        public Stats(StreamInput in) throws IOException {
/**
import java.util.function.DoubleSupplier;
        }
        long usage = cancellableTasks.stream().mapToLong(task -> task.getTotalResourceStats().getMemoryInBytes()).sum();
import java.util.concurrent.atomic.AtomicReference;
     * Returns true if the increase in heap usage is due to search requests.
                && currentAvg == stats.currentAvg
        private final long cancellationCount;
            double threshold = heapPercentThresholdSupplier.getAsDouble() * HEAP_SIZE_BYTES;
     * Had to refactor this method out of the constructor as we can't pass a lambda which references a member variable in constructor
     */
                && rollingAvg == stats.rollingAvg;
import org.opensearch.tasks.Task;
            );
        @Override
    private final DoubleSupplier heapPercentThresholdSupplier;
    public static boolean isHeapUsageDominatedBySearch(List<CancellableTask> cancellableTasks, double heapPercentThreshold) {
            if (isHeapTrackingSupported() == false || currentUsage < threshold || currentUsage < allowedUsage) {
    public String name() {
        DoubleSupplier heapVarianceSupplier,
    }
            out.writeVLong(currentAvg);
                .humanReadableField("current_avg_bytes", "current_avg", new ByteSizeValue(currentAvg))
        this.heapPercentThresholdSupplier = heapPercentThresholdSupplier;
        clusterSettings.addSettingsUpdateConsumer(windowSizeSetting, this::updateWindowSize);
import org.opensearch.core.common.io.stream.StreamInput;
            logger.debug("heap usage not dominated by search requests [{}/{}]", usage, threshold);
        }
    public void update(Task task) {
import org.opensearch.core.common.unit.ByteSizeValue;
                && currentMax == stats.currentMax
    }
            if (o == null || getClass() != o.getClass()) return false;
    @Override
        @Override
    private final AtomicReference<MovingAverage> movingAverageReference;
     */
        }
    @Override
        return HEAP_USAGE_TRACKER.getName();
            out.writeVLong(cancellationCount);
                return Optional.empty();
            this(in.readVLong(), in.readVLong(), in.readVLong(), in.readVLong());
        }
            if (this == o) return true;
        this.movingAverageReference = new AtomicReference<>(new MovingAverage(heapMovingAverageWindowSize));
            return builder.startObject()
        public void writeTo(StreamOutput out) throws IOException {
public class HeapUsageTracker extends TaskResourceUsageTracker {
        };
            double allowedUsage = averageUsage * variance;
            this.currentAvg = currentAvg;
            double currentUsage = task.getTotalResourceStats().getMemoryInBytes();
        int heapMovingAverageWindowSize,
 * @opensearch.internal
        return HEAP_SIZE_BYTES > 0;
import java.util.List;
                .humanReadableField("current_max_bytes", "current_max", new ByteSizeValue(currentMax))
                    (int) (currentUsage / averageUsage)  // TODO: fine-tune the cancellation score/weight
    }
            this.currentMax = currentMax;
                )
            Stats stats = (Stats) o;
/*
    @Override
}
import java.util.Optional;
import org.opensearch.common.settings.ClusterSettings;
    private void setDefaultResourceUsageBreachEvaluator() {
        setDefaultResourceUsageBreachEvaluator();
    private static final long HEAP_SIZE_BYTES = JvmStats.jvmStats().getMem().getHeapMax().getBytes();
            return Objects.hash(cancellationCount, currentMax, currentAvg, rollingAvg);
                return Optional.empty();
    }
        movingAverageReference.get().record(task.getTotalResourceStats().getMemoryInBytes());
    /**
 * compatible open source license.
        Setting<Integer> windowSizeSetting
import org.opensearch.monitor.jvm.JvmStats;
        return new Stats(getCancellations(), currentMax, currentAvg, (long) movingAverageReference.get().getAverage());
            }
 *
    private void updateWindowSize(int heapMovingAverageWindowSize) {
    /**
 */
            MovingAverage movingAverage = movingAverageReference.get();
import org.apache.logging.log4j.LogManager;
            return false;
        }
                .humanReadableField("rolling_avg_bytes", "rolling_avg", new ByteSizeValue(rollingAvg))
import org.opensearch.common.util.MovingAverage;
        DoubleSupplier heapPercentThresholdSupplier,
    }
import org.opensearch.common.settings.Setting;
 * HeapUsageTracker evaluates if the task has consumed too much heap than allowed.
        private final long currentMax;
        if (isHeapTrackingSupported() && usage < threshold) {
        ClusterSettings clusterSettings,
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            this.rollingAvg = rollingAvg;
import org.opensearch.tasks.CancellableTask;
            this.cancellationCount = cancellationCount;
                .endObject();
 *
        this.heapVarianceSupplier = heapVarianceSupplier;
        public int hashCode() {
        this.movingAverageReference.set(new MovingAverage(heapMovingAverageWindowSize));
 */
        return true;
        }
    /**
        @Override
        long currentAvg = (long) activeTasks.stream().mapToLong(t -> t.getTotalResourceStats().getMemoryInBytes()).average().orElse(0);
    public static boolean isHeapTrackingSupported() {
            return cancellationCount == stats.cancellationCount
 * this file be licensed under the Apache-2.0 license or a
    }
import java.util.Objects;
 * It also compares the task's heap usage against a historical moving average of previously completed tasks.
    public TaskResourceUsageTracker.Stats stats(List<? extends Task> activeTasks) {
        long currentMax = activeTasks.stream().mapToLong(t -> t.getTotalResourceStats().getMemoryInBytes()).max().orElse(0);
                .field("cancellation_count", cancellationCount)
        private final long currentAvg;
    private static final Logger logger = LogManager.getLogger(HeapUsageTracker.class);
            out.writeVLong(currentMax);
            if (movingAverage.isReady() == false) {
        private final long rollingAvg;
        @Override
        public boolean equals(Object o) {
