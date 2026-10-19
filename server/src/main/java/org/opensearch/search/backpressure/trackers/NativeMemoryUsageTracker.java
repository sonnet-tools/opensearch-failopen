 * budget, mirroring the heap tracker's {@code heap_percent_threshold}. Effective per-task  
                .endObject();  
     * <p>Effective per-task byte threshold = {@code budget * fraction}.  
import org.opensearch.core.common.unit.ByteSizeValue;  
                + ", currentMax="  
 * service refreshes once per tick. Per-task lookups are then O(1) hash probes into a stable
    }
            long currentUsage = bytesForTask(task);  
                + currentAvg  
        return NativeMemoryUsageService.getInstance().hasSnapshotProvider();  
        this.nativeMemoryPercentThresholdSupplier = nativeMemoryPercentThresholdSupplier;
            this(in.readVLong(), in.readVLong(), in.readVLong());  
    public String name() {
    /**
     * Cancellation rule: task's current native-memory reservation is at or above
        }
    public void update(Task task) {
        @Override  
    public NativeMemoryUsageTracker(DoubleSupplier nativeMemoryPercentThresholdSupplier) {
     * Per-task threshold expressed as a fraction of the installed native-memory budget,
    /** @see NativeMemoryUsageService#hasSnapshotProvider() */
                    budget  
     */
import org.opensearch.core.xcontent.XContentBuilder;
    /**
        }
        return service.currentBytes(task.getId());
            out.writeVLong(cancellationCount);
import java.util.function.Supplier;
        };  
 * this file be licensed under the Apache-2.0 license or a
            // Defensive clamp; the Setting validator already enforces [0.0, 1.0].  
 *
            if (fraction <= 0.0d || budget <= 0L) {
     * mirroring {@code heap_percent_threshold} on {@link HeapUsageTracker}. Range is
    /** @see NativeMemoryUsageService#setSnapshotSupplier(Supplier) */
     * rolling baseline for native memory, so exposing a zeroed field would be misleading.
 * byte threshold is {@code budget * fraction}.
import org.opensearch.search.backpressure.NativeMemoryUsageService;  
        }  
     */
                logger.debug(  
import java.util.Map;
    public TaskResourceUsageTracker.Stats stats(List<? extends Task> activeTasks) {
            return cancellationCount == stats.cancellationCount && currentMax == stats.currentMax && currentAvg == stats.currentAvg;  
        }
import org.apache.logging.log4j.LogManager;
import java.util.function.DoubleSupplier;
    }  
    /**
        long currentMax = activeTasks.stream().mapToLong(this::bytesForTask).max().orElse(0);
        return NativeMemoryUsageService.getInstance().getBudgetBytes();
     * call so tests can substitute (via reflection or future package-private constructor).
import org.opensearch.tasks.Task;  
 * SPDX-License-Identifier: Apache-2.0
        NativeMemoryUsageService.getInstance().setSnapshotSupplier(supplier);  
     * Singleton service that owns the snapshot map and the budget supplier. Held as a
    long bytesForTask(Task task) {  
     * Returns {@code true} when the node exposes the physical-memory signal this tracker
    @Override  
    private void setDefaultResourceUsageBreachEvaluator() {  
        long currentAvg = (long) activeTasks.stream().mapToLong(this::bytesForTask).average().orElse(0);  
import org.opensearch.tasks.TaskCancellation;
    // ---------------------------------------------------------------------
            }
        NativeMemoryUsageService.getInstance().setBudgetSupplier(supplier);
                + currentMax
    }
            if (task instanceof CancellableTask == false) {
/*  
        }
        }  
 *  
                return Optional.empty();
        }
                );
        }
            this.cancellationCount = cancellationCount;  
        @Override
 * <p>Native-memory values come from a backend (e.g. DataFusion) over an FFI boundary. Per-task
    }
        private final long currentAvg;  
     * relies on for duress. Symmetric with {@link HeapUsageTracker#isHeapTrackingSupported()}.  
        public Stats(long cancellationCount, long currentMax, long currentAvg) {
    private static final Logger logger = LogManager.getLogger(NativeMemoryUsageTracker.class);
 * NativeMemoryUsageTracker cancels in-flight tasks that are holding more native (off-heap)  
 * rolling average — native memory is a reservation that rises and falls over the query's
            return false;
 * The OpenSearch Contributors require contributions made to  
 *
        @Override
     * per-task threshold setting (range {@code [0.0, 1.0]}).
 * compatible open source license.
                .humanReadableField("current_max_bytes", "current_max", new ByteSizeValue(currentMax))
                    score  
    private final DoubleSupplier nativeMemoryPercentThresholdSupplier;
        if (hasSnapshotProvider() == false) {  
 */
import org.opensearch.search.backpressure.trackers.TaskResourceUsageTrackers.TaskResourceUsageTracker;
    }  
                // backend has installed a budget supplier. Leave the tracker inert.  
            this.currentMax = currentMax;
            return Objects.hash(cancellationCount, currentMax, currentAvg);
     * budget (e.g. DataFusion's pool limit) and {@code fraction} comes from the  
        return OsProbe.getInstance().getTotalPhysicalMemorySize() > 0L;  
import org.apache.logging.log4j.Logger;
     */
            int score = (int) Math.max(1L, currentUsage / Math.max(1L, bytesThreshold));
 * <p>The per-task threshold is expressed as a fraction of the backend-installed native-memory
    /**  
                .humanReadableField("current_avg_bytes", "current_avg", new ByteSizeValue(currentAvg))
        @Override  
        this.resourceUsageBreachEvaluator = (task) -> {
 * this class are kept as delegators so existing call sites (backend plugin  
     * rolling-average field that {@link HeapUsageTracker.Stats} carries: we don't maintain a  
                // Feature disabled — either the operator hasn't set a threshold, or no
    /** No-op: completion events carry no information we persist. */
            if (o == null || getClass() != o.getClass()) return false;
 * FFI reads don't scale: the backpressure service iterates every candidate task inside
 * {@code NativeMemoryUsageService#currentBytes(long)}. The service's {@code refresh()} is  
import static org.opensearch.search.backpressure.trackers.TaskResourceUsageTrackerType.NATIVE_MEMORY_USAGE_TRACKER;  
            }
    public static long getNativeMemoryBudgetBytes() {  
    public static boolean hasSnapshotProvider() {
    // Static delegators — preserved so existing callers (backend plugin
        }
            out.writeVLong(currentMax);  
/**
import org.opensearch.core.common.io.stream.StreamOutput;
            Stats stats = (Stats) o;
 * lifetime, so a fraction-of-budget threshold is the right shape once the node is already  
            return Optional.of(  
    /** @see NativeMemoryUsageService#setBudgetSupplier(LongSupplier) */  
     *
        // intentionally empty
package org.opensearch.search.backpressure.trackers;
     */
import java.util.function.LongSupplier;  
    public static boolean isNativeTrackingSupported() {
 * {@code doRun()}, and stats() iterates every live task twice (max + avg). The shared  
            }
        public String toString() {  
 */  
        return new Stats(getCancellations(), currentMax, currentAvg);
        this.service = service;  
                    task.getId(),
     * {@code [0.0, 1.0]} — the {@link org.opensearch.common.settings.Setting} validator  
                    "native memory usage exceeded [" + new ByteSizeValue(currentUsage) + " >= " + new ByteSizeValue(bytesThreshold) + "]",
 * <h2>Snapshot-per-tick model</h2>  
    }
        public void writeTo(StreamOutput out) throws IOException {
            double boundedFraction = Math.min(1.0d, fraction);
 * map reference.  
     */
    NativeMemoryUsageTracker(DoubleSupplier nativeMemoryPercentThresholdSupplier, NativeMemoryUsageService service) {
    }
     * Stats for {@link NativeMemoryUsageTracker}. Serialization shape deliberately omits the
        return NATIVE_MEMORY_USAGE_TRACKER.getName();
                + cancellationCount
    // wiring, NativeMemoryUsageTrackerTests) keep compiling. New code should  
    // prefer NativeMemoryUsageService directly.
        setDefaultResourceUsageBreachEvaluator();
    public static class Stats implements TaskResourceUsageTracker.Stats {  
    }
 *
    public static void setNativeMemoryBudgetSupplier(LongSupplier supplier) {
    // ---------------------------------------------------------------------
import java.io.IOException;  
                return Optional.empty();  
 * {@code createComponents}, tracker tests) don't have to migrate at the same time as the
            );
 * {@link NativeMemoryUsageService} holds a single {@code Map<taskId, bytes>} that the SBP
     * already enforces those bounds; this class clamps defensively.
     * field rather than read via {@link NativeMemoryUsageService#getInstance()} on every  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    @Override  
import java.util.List;
                .field("cancellation_count", cancellationCount)  
     * {@code budget * fraction}, where {@code budget} is the installed native-memory
            if (currentUsage < bytesThreshold) {
import java.util.Objects;  
    }  
        public Stats(StreamInput in) throws IOException {
 * called by {@code SearchBackpressureService.doRun()} once per tick before per-task evaluation
 * in native-memory duress (the
            long bytesThreshold = (long) (budget * boundedFraction);
            return 0L;
 * @opensearch.internal
                new TaskCancellation.Reason(
    }
                    "native memory threshold exceeded for task [{}]: currentBytes={}B, threshold={}B ({}% of budget={}B)",
 * <p>This tracker is a thin consumer of the service: {@code bytesForTask(Task)} delegates to
 * {@link org.opensearch.search.backpressure.SearchBackpressureService} tracker-apply map
            if (logger.isDebugEnabled()) {
        }  
            long budget = service.getBudgetBytes();  
            }  
            return "NativeMemoryUsageTracker.Stats{cancellationCount="
            out.writeVLong(currentAvg);
        this(nativeMemoryPercentThresholdSupplier, NativeMemoryUsageService.getInstance());  
            this.currentAvg = currentAvg;
 *
 * begins — this tracker does not own the refresh lifecycle. The static setters retained on
        public int hashCode() {
    }
    /**  
 * service extraction.
                + ", currentAvg="
    public static void setSnapshotSupplier(Supplier<Map<Long, Long>> supplier) {
                    (int) (boundedFraction * 100),
            return builder.startObject()
 * memory than allowed. Unlike {@link HeapUsageTracker}, this tracker does not maintain a
import java.util.Optional;
            if (this == o) return true;  
    /** Package-private for tests: look up a single task's bytes from the current snapshot. */
        private final long currentMax;
                + "}";
}
import org.opensearch.monitor.os.OsProbe;
    private final NativeMemoryUsageService service;  
            return false;
    /** Package-private for tests that want to inject a service instance. */  
    /** @see NativeMemoryUsageService#getBudgetBytes() */
import org.apache.lucene.util.Constants;  
        private final long cancellationCount;
                )
import org.opensearch.tasks.CancellableTask;
                return Optional.empty();
    @Override  
import org.opensearch.core.common.io.stream.StreamInput;
            double fraction = nativeMemoryPercentThresholdSupplier.getAsDouble();
    }
                    currentUsage,  
            if (bytesThreshold <= 0L) {  
        public boolean equals(Object o) {
        if (Constants.LINUX == false) {  
                return Optional.empty();
        @Override  
            }
 * gates on that).  
public class NativeMemoryUsageTracker extends TaskResourceUsageTracker {  
    }  
                    bytesThreshold,
        if (task == null) {
