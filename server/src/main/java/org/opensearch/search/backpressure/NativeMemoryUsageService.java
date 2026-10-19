     * so tests in sibling packages (e.g. {@code .trackers}) can reach it without
    private static final Logger logger = LogManager.getLogger(NativeMemoryUsageService.class);
 * and lets a backend plugin call {@link #setSnapshotSupplier} from  
 * SPDX-License-Identifier: Apache-2.0
     * a reload-style call site can't accidentally clear a working installation.
     */  
     * Last snapshot loaded by {@link #refresh()}. {@code volatile} so the publish from  
     * {@code createComponents}. Last writer wins. Passing {@code null} is a no-op so  
        }  
    /**
        if (supplier == null) {
            snapshot = null;
     */
    private static final NativeMemoryUsageService INSTANCE = new NativeMemoryUsageService();
        this.budgetSupplier = supplier;
     */  
 *       multi-reader (tracker refresh path, stats path).</li>
 * <p>The tracker is per task class (today: {@code SearchTask} and
 *   <li>Suppliers are {@code volatile} — single-writer (plugin {@code createComponents}),
 *       {@link #refresh()} call.</li>
     */
 * propagation) a natural home.
 *   <li>Per-task lookups via {@link #currentBytes(long)} read a stable
        this.bytesByTaskId = snapshot;
 *   <li>The snapshot reference is {@code volatile} — published once per  
     * lookup.
    }  
 * graduates to a proper injected component.  
     * logged at warn level — the tracker must never NPE because of a misbehaving
 */
     * stays inert until a backend opts in.  
}
 * <h2>Why a separate service</h2>  
    }
            logger.debug("native memory snapshot refreshed: size={} budget={}B", snapshot.size(), getBudgetBytes());  
 *
    public void setBudgetSupplier(LongSupplier supplier) {  
 * </ul>
    private volatile Map<Long, Long> bytesByTaskId = Collections.emptyMap();
     * "feature disabled" and skips evaluation.
    /**  
     */  
 *       mutates the in-flight map.</li>
        Long bytes = bytesByTaskId.get(taskId);
     * not mutate this map; producers always swap in a new immutable map.
    public void setSnapshotSupplier(Supplier<Map<Long, Long>> supplier) {  
     * the SBP scheduler thread is visible to the per-task lookup path. Read paths must
import org.apache.logging.log4j.LogManager;
     * is a no-op (same rationale as {@link #setSnapshotSupplier}).
 * service collapses that to one refresh per tick and gives the deferred
        return snapshotSupplier != EMPTY_SNAPSHOT_SUPPLIER;
    public void refresh() {
 * {@code createComponents} without threading a service reference through plugin SPI.
 * {@link org.opensearch.search.backpressure.trackers.NativeMemoryUsageTracker}
 *  
     * mutate. Provided so tests can assert on what {@link #refresh()} loaded without
        this.bytesByTaskId = Collections.emptyMap();
    }
        try {  
     * doesn't leak state into the next test. Production code never calls this. Public
import java.util.Map;
        }  
    private NativeMemoryUsageService() {}  
     * Look up a single task's current native-memory reservation. Returns {@code 0}
/**  
    /**
        this.snapshotSupplier = supplier;
    }  
     * when the task is not in the snapshot (either it's not an analytics query, or  
     * Source of the per-query native-memory snapshot. Installed by a backend plugin
 * That mirrors the previous static-supplier wiring on {@code NativeMemoryUsageTracker}
     */
     * reflection.  
package org.opensearch.search.backpressure;
     * Visible-for-testing reset. Restores defaults so a test that installs a supplier  
 * snapshot rather than each holding its own copy.
 */  
        logger.info("native memory snapshot supplier installed [{}]", supplier.getClass().getName());
        }  
        return bytesByTaskId;
 * <p>The service is a process-wide singleton accessed via {@link #getInstance()}.
     * Current native-memory budget in bytes. Clamped to {@code >= 0} so a misbehaving
        this.budgetSupplier = ZERO_BUDGET_SUPPLIER;
 * compatible open source license.
    private volatile Supplier<Map<Long, Long>> snapshotSupplier = EMPTY_SNAPSHOT_SUPPLIER;
 * <h2>Thread safety</h2>
/*  
     * backend.
 * {@code SearchShardTask}), so without a shared service there are two parallel
            snapshot = Collections.emptyMap();
    private static final Supplier<Map<Long, Long>> EMPTY_SNAPSHOT_SUPPLIER = Collections::emptyMap;
     */
 * <h2>Lifecycle</h2>  
import java.util.Collections;
    }  
    /** Process-wide singleton. */
    /**  
    /**
public final class NativeMemoryUsageService {  
 *
     */
    /**
import org.apache.logging.log4j.Logger;
 * snapshot maps that {@code SearchBackpressureService.doRun()} refreshes  
     * <p>A {@code null} return from the supplier is treated as "empty snapshot" and  
            logger.warn("native memory snapshot supplier threw, using empty snapshot", e);  
 *
            return;
    }  
     * Install the native-memory budget supplier. Last writer wins. Passing {@code null}  
     * Source of the total native-memory budget in bytes (e.g. DataFusion's configured
     * needing to reach into the tracker.
            snapshot = snapshotSupplier.get();
     * the registry hasn't yet recorded any reservations for it).
        }
    /**
    }
    public long currentBytes(long taskId) {  
    public long getBudgetBytes() {
        } catch (RuntimeException e) {
        this.snapshotSupplier = EMPTY_SNAPSHOT_SUPPLIER;  
        if (logger.isDebugEnabled()) {
    /**
     * supplier returning a negative value can't flip the threshold math.  
        Map<Long, Long> snapshot;
    }  
    private static final LongSupplier ZERO_BUDGET_SUPPLIER = () -> 0L;
        }
     * (e.g. DataFusion) at boot; defaults to an empty-map supplier so the tracker
     * round-trip. Callers (SBP service) invoke this once per tick before any per-task  
     */
import java.util.function.Supplier;
 * The OpenSearch Contributors require contributions made to  
    public void resetForTesting() {
        return Math.max(0L, budgetSupplier.getAsLong());  
     * Install the snapshot supplier. Called once from a backend plugin's
    Map<Long, Long> snapshotView() {
 * Owns the cross-tick snapshot of per-query native (off-heap) memory usage that
        if (snapshot == null) {  
 * this file be licensed under the Apache-2.0 license or a
    /**
 * independently — two FFM calls for the same data. Moving the state into a single
import java.util.function.LongSupplier;  
    public static NativeMemoryUsageService getInstance() {  
 * A future spec can promote this to an injected component once this service
 * <ul>  
    }
            logger.warn("native memory snapshot supplier returned null, using empty snapshot");
     * Pull a fresh snapshot from the installed supplier and publish it. Exactly one
     *
            return;
        return bytes == null ? 0L : bytes;
 *
    private volatile LongSupplier budgetSupplier = ZERO_BUDGET_SUPPLIER;  
 * production-readiness work (state machine, observability counters, cancel-to-release  
 *       map reference; concurrent {@link #refresh()} swaps the reference, never  
     */
     * supplier call per invocation — for the DataFusion backend that maps to one FFM
        return INSTANCE;
        if (supplier == null) {
        logger.info("native memory budget supplier installed");
    /**
 * @opensearch.internal
     * pool limit). Defaults to {@code 0} — the tracker treats {@code budget == 0} as  
     * Visible-for-testing snapshot view. Returns the live reference; callers MUST NOT  
 * consults. Keeps a single source of truth so all per-task-class trackers share one  
    /** {@code true} when a backend has installed a non-default snapshot supplier. */
    public boolean hasSnapshotProvider() {  
