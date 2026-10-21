        long currentMax = activeTasks.stream().mapToLong(this::bytesForTask).max().orElse(0);
/**
        private final long currentMax;
    }
        }
                    "native memory threshold exceeded for task [{}]: currentBytes={}B, threshold={}B ({}% of budget={}B)",
            Stats stats = (Stats) o;
 * FFI reads don't scale: the backpressure service iterates every candidate task inside
     */
    @Override
import org.opensearch.core.common.unit.ByteSizeValue;
 * memory than allowed. Unlike {@link HeapUsageTracker}, this tracker does not maintain a
            return "NativeMemoryUsageTracker.Stats{cancellationCount="
 * {@code NativeMemoryUsageService#currentBytes(long)}. The service's {@code refresh()} is
public class NativeMemoryUsageTracker extends TaskResourceUsageTracker {
    }
import org.opensearch.monitor.os.OsProbe;
            double boundedFraction = Math.min(1.0d, fraction);
import java.util.function.DoubleSupplier;
 * service refreshes once per tick. Per-task lookups are then O(1) hash probes into a stable
import org.apache.logging.log4j.Logger;
                    (int) (boundedFraction * 100),
        NativeMemoryUsageService.getInstance().setSnapshotSupplier(supplier);
        return NATIVE_MEMORY_USAGE_TRACKER.getName();
    }
    }
                logger.debug(
import org.opensearch.core.common.io.stream.StreamOutput;
    /** Package-private for tests that want to inject a service instance. */
     * Returns {@code true} when the node exposes the physical-memory signal this tracker
        if (hasSnapshotProvider() == false) {
    public String name() {
 * {@code doRun()}, and stats() iterates every live task twice (max + avg). The shared
import java.io.IOException;
            );
 * @opensearch.internal
import java.util.function.LongSupplier;
import static org.opensearch.search.backpressure.trackers.TaskResourceUsageTrackerType.NATIVE_MEMORY_USAGE_TRACKER;
            }
        }
 *
     * budget (e.g. DataFusion's pool limit) and {@code fraction} comes from the
            if (fraction <= 0.0d || budget <= 0L) {
                );
    /** Package-private for tests: look up a single task's bytes from the current snapshot. */
import java.util.Objects;
        public int hashCode() {
import org.opensearch.search.backpressure.trackers.TaskResourceUsageTrackers.TaskResourceUsageTracker;
 *
import org.apache.logging.log4j.LogManager;
            return false;
        private final long cancellationCount;
    public void update(Task task) {
            if (bytesThreshold <= 0L) {
     * per-task threshold setting (range {@code [0.0, 1.0]}).
                + currentAvg
 * <p>Native-memory values come from a backend (e.g. DataFusion) over an FFI boundary. Per-task
            if (currentUsage < bytesThreshold) {
package org.opensearch.search.backpressure.trackers;
            return Objects.hash(cancellationCount, currentMax, currentAvg);
 *
    /**
    }
                    "native memory usage exceeded [" + new ByteSizeValue(currentUsage) + " >= " + new ByteSizeValue(bytesThreshold) + "]",
 *
                    currentUsage,
        return OsProbe.getInstance().getTotalPhysicalMemorySize() > 0L;
            // Defensive clamp; the Setting validator already enforces [0.0, 1.0].
 */
            out.writeVLong(currentMax);
     * mirroring {@code heap_percent_threshold} on {@link HeapUsageTracker}. Range is
 * service extraction.
        @Override
        @Override
    private final NativeMemoryUsageService service;
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        }
                )
        };
        }
     * field rather than read via {@link NativeMemoryUsageService#getInstance()} on every
     * rolling-average field that {@link HeapUsageTracker.Stats} carries: we don't maintain a
            if (o == null || getClass() != o.getClass()) return false;
    private void setDefaultResourceUsageBreachEvaluator() {
import org.opensearch.core.common.io.stream.StreamInput;
    long bytesForTask(Task task) {
     * <p>Effective per-task byte threshold = {@code budget * fraction}.
import org.opensearch.core.xcontent.XContentBuilder;
     * Stats for {@link NativeMemoryUsageTracker}. Serialization shape deliberately omits the
    }
    /**
                return Optional.empty();
    /**
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.tasks.Task;
                + currentMax
    /**
                    score
import org.apache.lucene.util.Constants;
    public TaskResourceUsageTracker.Stats stats(List<? extends Task> activeTasks) {
    /** No-op: completion events carry no information we persist. */
 * compatible open source license.
     */
            }
            }
            long budget = service.getBudgetBytes();
    // ---------------------------------------------------------------------
        @Override
            long bytesThreshold = (long) (budget * boundedFraction);
 * <h2>Snapshot-per-tick model</h2>
            long currentUsage = bytesForTask(task);
    }
    NativeMemoryUsageTracker(DoubleSupplier nativeMemoryPercentThresholdSupplier, NativeMemoryUsageService service) {
    /** @see NativeMemoryUsageService#hasSnapshotProvider() */
 * this class are kept as delegators so existing call sites (backend plugin
        if (task == null) {
            }
    public static class Stats implements TaskResourceUsageTracker.Stats {
 * The OpenSearch Contributors require contributions made to
        }
     * rolling baseline for native memory, so exposing a zeroed field would be misleading.
 */
    public NativeMemoryUsageTracker(DoubleSupplier nativeMemoryPercentThresholdSupplier) {
        this(nativeMemoryPercentThresholdSupplier, NativeMemoryUsageService.getInstance());
    }
        public String toString() {
    public static boolean hasSnapshotProvider() {
            this.currentAvg = currentAvg;
            return false;
    @Override
                return Optional.empty();
 * in native-memory duress (the
        return new Stats(getCancellations(), currentMax, currentAvg);
            this.currentMax = currentMax;
        private final long currentAvg;
    @Override
 * lifetime, so a fraction-of-budget threshold is the right shape once the node is already
    }
                + "}";
        return NativeMemoryUsageService.getInstance().hasSnapshotProvider();
                    task.getId(),
            return Optional.of(
            return 0L;
 * <p>This tracker is a thin consumer of the service: {@code bytesForTask(Task)} delegates to
            int score = (int) Math.max(1L, currentUsage / Math.max(1L, bytesThreshold));
        @Override
    }
                + ", currentMax="
                return Optional.empty();
        @Override
import java.util.Map;
    /** @see NativeMemoryUsageService#setBudgetSupplier(LongSupplier) */
            this(in.readVLong(), in.readVLong(), in.readVLong());
        }
    private static final Logger logger = LogManager.getLogger(NativeMemoryUsageTracker.class);
     * relies on for duress. Symmetric with {@link HeapUsageTracker#isHeapTrackingSupported()}.
        setDefaultResourceUsageBreachEvaluator();
                .humanReadableField("current_max_bytes", "current_max", new ByteSizeValue(currentMax))
            this.cancellationCount = cancellationCount;
                .humanReadableField("current_avg_bytes", "current_avg", new ByteSizeValue(currentAvg))
        NativeMemoryUsageService.getInstance().setBudgetSupplier(supplier);
        }
            }
     * {@code [0.0, 1.0]} — the {@link org.opensearch.common.settings.Setting} validator
        }
}
     * {@code budget * fraction}, where {@code budget} is the installed native-memory
                return Optional.empty();
                new TaskCancellation.Reason(
            return builder.startObject()
        public Stats(StreamInput in) throws IOException {
                .field("cancellation_count", cancellationCount)
 * rolling average — native memory is a reservation that rises and falls over the query's
    }
     * already enforces those bounds; this class clamps defensively.
     * call so tests can substitute (via reflection or future package-private constructor).
import org.opensearch.search.backpressure.NativeMemoryUsageService;
 * map reference.
        // intentionally empty
import java.util.Optional;
 * called by {@code SearchBackpressureService.doRun()} once per tick before per-task evaluation
    public static long getNativeMemoryBudgetBytes() {
 * NativeMemoryUsageTracker cancels in-flight tasks that are holding more native (off-heap)
        }
 * {@code createComponents}, tracker tests) don't have to migrate at the same time as the
                .endObject();
    // ---------------------------------------------------------------------
     * Per-task threshold expressed as a fraction of the installed native-memory budget,
        return NativeMemoryUsageService.getInstance().getBudgetBytes();
        public Stats(long cancellationCount, long currentMax, long currentAvg) {
            double fraction = nativeMemoryPercentThresholdSupplier.getAsDouble();
    // Static delegators — preserved so existing callers (backend plugin
                // Feature disabled — either the operator hasn't set a threshold, or no
        public boolean equals(Object o) {
import org.opensearch.tasks.CancellableTask;
    /** @see NativeMemoryUsageService#getBudgetBytes() */
                    bytesThreshold,
    // wiring, NativeMemoryUsageTrackerTests) keep compiling. New code should
     */
 * {@link NativeMemoryUsageService} holds a single {@code Map<taskId, bytes>} that the SBP
     */
    private final DoubleSupplier nativeMemoryPercentThresholdSupplier;
            return cancellationCount == stats.cancellationCount && currentMax == stats.currentMax && currentAvg == stats.currentAvg;
    }
                + cancellationCount
        this.service = service;
    /** @see NativeMemoryUsageService#setSnapshotSupplier(Supplier) */
import org.opensearch.tasks.TaskCancellation;
     *
 * gates on that).
 * budget, mirroring the heap tracker's {@code heap_percent_threshold}. Effective per-task
import java.util.List;
    // prefer NativeMemoryUsageService directly.
        long currentAvg = (long) activeTasks.stream().mapToLong(this::bytesForTask).average().orElse(0);
        if (Constants.LINUX == false) {
        public void writeTo(StreamOutput out) throws IOException {
/*
                    budget
            out.writeVLong(cancellationCount);
        }
            if (this == o) return true;
        this.resourceUsageBreachEvaluator = (task) -> {
            out.writeVLong(currentAvg);
 * this file be licensed under the Apache-2.0 license or a
 *
    public static boolean isNativeTrackingSupported() {
    public static void setNativeMemoryBudgetSupplier(LongSupplier supplier) {
    }
import java.util.function.Supplier;
     */
     * Cancellation rule: task's current native-memory reservation is at or above
     * Singleton service that owns the snapshot map and the budget supplier. Held as a
 * {@link org.opensearch.search.backpressure.SearchBackpressureService} tracker-apply map
 * begins — this tracker does not own the refresh lifecycle. The static setters retained on
                // backend has installed a budget supplier. Leave the tracker inert.
        return service.currentBytes(task.getId());
        this.nativeMemoryPercentThresholdSupplier = nativeMemoryPercentThresholdSupplier;
                + ", currentAvg="
            if (task instanceof CancellableTask == false) {
 * <p>The per-task threshold is expressed as a fraction of the backend-installed native-memory
    public static void setSnapshotSupplier(Supplier<Map<Long, Long>> supplier) {
            if (logger.isDebugEnabled()) {
 * byte threshold is {@code budget * fraction}.
    /**
