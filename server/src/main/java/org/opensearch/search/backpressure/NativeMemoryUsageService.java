     * lookup.
 * production-readiness work (state machine, observability counters, cancel-to-release
 * <h2>Thread safety</h2>
 * That mirrors the previous static-supplier wiring on {@code NativeMemoryUsageTracker}
     * backend.
     * supplier call per invocation — for the DataFusion backend that maps to one FFM
    public void resetForTesting() {
     * Last snapshot loaded by {@link #refresh()}. {@code volatile} so the publish from
        this.snapshotSupplier = EMPTY_SNAPSHOT_SUPPLIER;
        logger.info("native memory budget supplier installed");
        this.bytesByTaskId = snapshot;
    Map<Long, Long> snapshotView() {
    public void refresh() {
 * <h2>Lifecycle</h2>
        }
    }
 * A future spec can promote this to an injected component once this service
    private volatile Map<Long, Long> bytesByTaskId = Collections.emptyMap();
    }
 *
     * the registry hasn't yet recorded any reservations for it).
 *
     * the SBP scheduler thread is visible to the per-task lookup path. Read paths must
     * doesn't leak state into the next test. Production code never calls this. Public
     *
    }
     * (e.g. DataFusion) at boot; defaults to an empty-map supplier so the tracker
 */
            snapshot = Collections.emptyMap();
    }
     * when the task is not in the snapshot (either it's not an analytics query, or
    /**
     * Visible-for-testing snapshot view. Returns the live reference; callers MUST NOT
        Map<Long, Long> snapshot;
     * so tests in sibling packages (e.g. {@code .trackers}) can reach it without
        Long bytes = bytesByTaskId.get(taskId);
import java.util.Map;
 *
    }
     * Source of the per-query native-memory snapshot. Installed by a backend plugin
 * {@link org.opensearch.search.backpressure.trackers.NativeMemoryUsageTracker}
     * Source of the total native-memory budget in bytes (e.g. DataFusion's configured
    }
    public void setSnapshotSupplier(Supplier<Map<Long, Long>> supplier) {
     */
     * stays inert until a backend opts in.
    private volatile Supplier<Map<Long, Long>> snapshotSupplier = EMPTY_SNAPSHOT_SUPPLIER;
/*
        this.snapshotSupplier = supplier;
     * Look up a single task's current native-memory reservation. Returns {@code 0}
     * <p>A {@code null} return from the supplier is treated as "empty snapshot" and
    private static final Logger logger = LogManager.getLogger(NativeMemoryUsageService.class);
            logger.warn("native memory snapshot supplier threw, using empty snapshot", e);
 * and lets a backend plugin call {@link #setSnapshotSupplier} from
 *       mutates the in-flight map.</li>
    }
     * Current native-memory budget in bytes. Clamped to {@code >= 0} so a misbehaving
     */
        if (supplier == null) {
     */
    private static final NativeMemoryUsageService INSTANCE = new NativeMemoryUsageService();
     * supplier returning a negative value can't flip the threshold math.
 * snapshot maps that {@code SearchBackpressureService.doRun()} refreshes
            logger.debug("native memory snapshot refreshed: size={} budget={}B", snapshot.size(), getBudgetBytes());
     */
 * @opensearch.internal
     * Pull a fresh snapshot from the installed supplier and publish it. Exactly one
    /**
    /** Process-wide singleton. */
        this.budgetSupplier = ZERO_BUDGET_SUPPLIER;
     */
        try {
    private volatile LongSupplier budgetSupplier = ZERO_BUDGET_SUPPLIER;
    /**
 * <h2>Why a separate service</h2>
    /** {@code true} when a backend has installed a non-default snapshot supplier. */
        }
 * Owns the cross-tick snapshot of per-query native (off-heap) memory usage that
        this.budgetSupplier = supplier;
     */
     * mutate. Provided so tests can assert on what {@link #refresh()} loaded without
            snapshot = null;
import java.util.function.LongSupplier;
 * snapshot rather than each holding its own copy.
 *       multi-reader (tracker refresh path, stats path).</li>
     */
     * Install the snapshot supplier. Called once from a backend plugin's
 * <ul>
 *       {@link #refresh()} call.</li>
/**
 * {@code createComponents} without threading a service reference through plugin SPI.
 * compatible open source license.
    /**
    /**
 * SPDX-License-Identifier: Apache-2.0
        logger.info("native memory snapshot supplier installed [{}]", supplier.getClass().getName());
        } catch (RuntimeException e) {
    private static final LongSupplier ZERO_BUDGET_SUPPLIER = () -> 0L;
 * <p>The service is a process-wide singleton accessed via {@link #getInstance()}.
    public long getBudgetBytes() {
     * {@code createComponents}. Last writer wins. Passing {@code null} is a no-op so
     * "feature disabled" and skips evaluation.
 *   <li>Per-task lookups via {@link #currentBytes(long)} read a stable
    public static NativeMemoryUsageService getInstance() {
 *       map reference; concurrent {@link #refresh()} swaps the reference, never
        return bytes == null ? 0L : bytes;
    public void setBudgetSupplier(LongSupplier supplier) {
public final class NativeMemoryUsageService {
 * The OpenSearch Contributors require contributions made to
     * needing to reach into the tracker.
        return INSTANCE;
 * this file be licensed under the Apache-2.0 license or a
 * graduates to a proper injected component.
 * consults. Keeps a single source of truth so all per-task-class trackers share one
        if (logger.isDebugEnabled()) {
 * propagation) a natural home.
package org.opensearch.search.backpressure;
    public boolean hasSnapshotProvider() {
     */
 *   <li>The snapshot reference is {@code volatile} — published once per
    public long currentBytes(long taskId) {
 *   <li>Suppliers are {@code volatile} — single-writer (plugin {@code createComponents}),
    /**
     */
    /**
     */
            return;
 * </ul>
}
 *
     * round-trip. Callers (SBP service) invoke this once per tick before any per-task
import org.apache.logging.log4j.LogManager;
    }
 * service collapses that to one refresh per tick and gives the deferred
     * logged at warn level — the tracker must never NPE because of a misbehaving
 * <p>The tracker is per task class (today: {@code SearchTask} and
import org.apache.logging.log4j.Logger;
        }
import java.util.function.Supplier;
 *
        return Math.max(0L, budgetSupplier.getAsLong());
 * {@code SearchShardTask}), so without a shared service there are two parallel
 */
 * independently — two FFM calls for the same data. Moving the state into a single
            logger.warn("native memory snapshot supplier returned null, using empty snapshot");
     * not mutate this map; producers always swap in a new immutable map.
        return snapshotSupplier != EMPTY_SNAPSHOT_SUPPLIER;
    /**
    /**
        this.bytesByTaskId = Collections.emptyMap();
    }
        }
            return;
    /**
     * a reload-style call site can't accidentally clear a working installation.
            snapshot = snapshotSupplier.get();
     * pool limit). Defaults to {@code 0} — the tracker treats {@code budget == 0} as
        if (supplier == null) {
    private NativeMemoryUsageService() {}
     * is a no-op (same rationale as {@link #setSnapshotSupplier}).
import java.util.Collections;
     * Install the native-memory budget supplier. Last writer wins. Passing {@code null}
     * Visible-for-testing reset. Restores defaults so a test that installs a supplier
        }
        return bytesByTaskId;
        if (snapshot == null) {
     * reflection.
    private static final Supplier<Map<Long, Long>> EMPTY_SNAPSHOT_SUPPLIER = Collections::emptyMap;
