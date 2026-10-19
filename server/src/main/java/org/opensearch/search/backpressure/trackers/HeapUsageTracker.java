        }
            out.writeVLong(currentMax);  
    private void setDefaultResourceUsageBreachEvaluator() {
/*  
 * compatible open source license.
            MovingAverage movingAverage = movingAverageReference.get();
            double variance = heapVarianceSupplier.getAsDouble();
import org.opensearch.core.xcontent.XContentBuilder;  
                )
            if (isHeapTrackingSupported() == false || currentUsage < threshold || currentUsage < allowedUsage) {
        this.movingAverageReference.set(new MovingAverage(heapMovingAverageWindowSize));
    @Override
            this(in.readVLong(), in.readVLong(), in.readVLong(), in.readVLong());
        long threshold = (long) (heapPercentThreshold * HEAP_SIZE_BYTES);
import org.opensearch.tasks.CancellableTask;  
        long currentAvg = (long) activeTasks.stream().mapToLong(t -> t.getTotalResourceStats().getMemoryInBytes()).average().orElse(0);
public class HeapUsageTracker extends TaskResourceUsageTracker {
        }
        return HEAP_USAGE_TRACKER.getName();
        private final long currentMax;
 * The OpenSearch Contributors require contributions made to  
import static org.opensearch.search.backpressure.trackers.TaskResourceUsageTrackerType.HEAP_USAGE_TRACKER;
     * Stats related to HeapUsageTracker.
            out.writeVLong(cancellationCount);
                .humanReadableField("current_avg_bytes", "current_avg", new ByteSizeValue(currentAvg))
            this.currentAvg = currentAvg;  
                .humanReadableField("rolling_avg_bytes", "rolling_avg", new ByteSizeValue(rollingAvg))
                && rollingAvg == stats.rollingAvg;
import java.util.function.DoubleSupplier;  
    /**  
            double allowedUsage = averageUsage * variance;
    private static final Logger logger = LogManager.getLogger(HeapUsageTracker.class);
            return builder.startObject()
            if (movingAverage.isReady() == false) {
        }
                new TaskCancellation.Reason(
            if (o == null || getClass() != o.getClass()) return false;
            );
     * Had to refactor this method out of the constructor as we can't pass a lambda which references a member variable in constructor
        setDefaultResourceUsageBreachEvaluator();
        }  
                .endObject();  
            this.currentMax = currentMax;
        DoubleSupplier heapPercentThresholdSupplier,
            }  
}  
        int heapMovingAverageWindowSize,
        ClusterSettings clusterSettings,  
    @Override  
    /**
    }
        @Override  
        Setting<Integer> windowSizeSetting
            }
    private final DoubleSupplier heapVarianceSupplier;
        this.resourceUsageBreachEvaluator = (task) -> {  
        return true;
    }
            return cancellationCount == stats.cancellationCount
    public HeapUsageTracker(
    ) {
                .field("cancellation_count", cancellationCount)
    public static class Stats implements TaskResourceUsageTracker.Stats {  
        public int hashCode() {
    }
 */  
        }  
    @Override
            Stats stats = (Stats) o;  
                    "heap usage exceeded [" + new ByteSizeValue((long) currentUsage) + " >= " + new ByteSizeValue((long) threshold) + "]",
            return false;
        public Stats(long cancellationCount, long currentMax, long currentAvg, long rollingAvg) {  
            return Optional.of(  
                .humanReadableField("current_max_bytes", "current_max", new ByteSizeValue(currentMax))  
        this.heapVarianceSupplier = heapVarianceSupplier;  
import java.util.Objects;  
import java.util.concurrent.atomic.AtomicReference;
import org.opensearch.monitor.jvm.JvmStats;
import org.opensearch.common.util.MovingAverage;
import org.opensearch.core.common.io.stream.StreamInput;  
                && currentAvg == stats.currentAvg  
        this.heapPercentThresholdSupplier = heapPercentThresholdSupplier;
     */
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
    public void update(Task task) {  
import org.opensearch.core.common.unit.ByteSizeValue;
    }
        this.movingAverageReference = new AtomicReference<>(new MovingAverage(heapMovingAverageWindowSize));
        }
        return new Stats(getCancellations(), currentMax, currentAvg, (long) movingAverageReference.get().getAverage());  
import org.opensearch.common.settings.Setting;
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.search.backpressure.trackers;
    public String name() {
        movingAverageReference.get().record(task.getTotalResourceStats().getMemoryInBytes());
import org.apache.logging.log4j.Logger;
            double averageUsage = movingAverage.getAverage();  
import org.opensearch.search.backpressure.trackers.TaskResourceUsageTrackers.TaskResourceUsageTracker;
            if (this == o) return true;
            double currentUsage = task.getTotalResourceStats().getMemoryInBytes();
import java.util.Optional;
    }  
        @Override
 */  
import org.opensearch.core.common.io.stream.StreamOutput;
    }
            out.writeVLong(currentAvg);
                    (int) (currentUsage / averageUsage)  // TODO: fine-tune the cancellation score/weight  
    }  
        if (isHeapTrackingSupported() && usage < threshold) {  
     */
                && currentMax == stats.currentMax
    }
        private final long currentAvg;  
        public void writeTo(StreamOutput out) throws IOException {
        clusterSettings.addSettingsUpdateConsumer(windowSizeSetting, this::updateWindowSize);  
    public TaskResourceUsageTracker.Stats stats(List<? extends Task> activeTasks) {  
        long currentMax = activeTasks.stream().mapToLong(t -> t.getTotalResourceStats().getMemoryInBytes()).max().orElse(0);
        };  
    /**  
    }  
        public boolean equals(Object o) {  
        @Override
        DoubleSupplier heapVarianceSupplier,  
import java.util.List;
        public Stats(StreamInput in) throws IOException {
            out.writeVLong(rollingAvg);
 *
            logger.debug("heap usage not dominated by search requests [{}/{}]", usage, threshold);
import org.opensearch.tasks.TaskCancellation;
 * It also compares the task's heap usage against a historical moving average of previously completed tasks.  
        long usage = cancellableTasks.stream().mapToLong(task -> task.getTotalResourceStats().getMemoryInBytes()).sum();
            double threshold = heapPercentThresholdSupplier.getAsDouble() * HEAP_SIZE_BYTES;  
            this.cancellationCount = cancellationCount;
    public static boolean isHeapTrackingSupported() {
        private final long cancellationCount;
                return Optional.empty();  
            // There haven't been enough measurements.  
 * @opensearch.internal
    private static final long HEAP_SIZE_BYTES = JvmStats.jvmStats().getMem().getHeapMax().getBytes();  
        @Override
            return Objects.hash(cancellationCount, currentMax, currentAvg, rollingAvg);  
        return HEAP_SIZE_BYTES > 0;  
import org.apache.logging.log4j.LogManager;
    private void updateWindowSize(int heapMovingAverageWindowSize) {
            this.rollingAvg = rollingAvg;
    private final DoubleSupplier heapPercentThresholdSupplier;
import java.io.IOException;
        }  
 * HeapUsageTracker evaluates if the task has consumed too much heap than allowed.
     * error: cannot reference movingAverageReference before supertype constructor has been called  
/**
     */
import org.opensearch.common.settings.ClusterSettings;  
    public static boolean isHeapUsageDominatedBySearch(List<CancellableTask> cancellableTasks, double heapPercentThreshold) {  
     * Returns true if the increase in heap usage is due to search requests.
    private final AtomicReference<MovingAverage> movingAverageReference;  
        private final long rollingAvg;
                return Optional.empty();
import org.opensearch.tasks.Task;
 *
