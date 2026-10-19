        this.budget = budget;
        Setting<Long> minSetting,
    public void setPoolLimit(String poolName, long newLimit) {
            }
    /**
                logger.debug("Over-commit refused: native memory pressure {}% >= threshold {}%", pressure, overCommitPressureThreshold);
            );
    }
    public long getVirtualPoolLimit(String poolName) {
        Supplier<long[]> supplier = this.nativeMemoryStatsSupplier;
     * A capability handle for a single granted over-commit. Minted only by
     * Returns the allocated bytes for any pool (Arrow or virtual).
            } catch (Exception e) {
     * @param poolName name of the pool
import java.util.Collections;
    /**
    public VirtualPoolHandle registerVirtualPool(String poolName, long min, long max, PoolGroup group, Consumer<Long> limitSetter) {
        }
        }
                    nativeResident = stats[1];
        public long peakBytes() {
    /** Current node-level native memory pressure %, or -1 when unavailable (signal missing / not ready). */
            );
    }
import org.opensearch.arrow.spi.PoolGroup;
            this.allocator = allocator;
    }
    /**
    public void setMaxConcurrentOverCommits(int max) {
    public BufferAllocator getPoolAllocator(String poolName) {
import org.opensearch.arrow.spi.NativeAllocator;
     *
     */
        public long id() {
                    vp.allocatedBytes(),
     * available. On a grant this returns a {@link OverCommitLease} that the caller MUST
        @Override
        }
    public VirtualPoolHandle registerVirtualPool(
                        group
        throw new IllegalStateException("Pool '" + poolName + "' does not exist");
        ArrowPoolHandle(BufferAllocator allocator) {
     * {@link OverCommitLease#close() close} exactly once when the over-committing operation completes
        Consumer<Long> limitSetter
        }
    }
    /**
    public void setPoolEffectiveLimit(String poolName, long newLimit) {
        }
        if (config != null) {
     * @param settings current node settings
            return allocator.getPeakMemoryAllocation();
import org.apache.logging.log4j.Logger;
import org.apache.arrow.memory.RootAllocator;
                listener.accept(finalSum);
        ArrowPoolHandle arrowHandle = pools.get(poolName);
        ArrowPoolHandle arrowHandle = pools.get(poolName);
    }
            } catch (Exception e) {
            this.allocatedBytes = allocated;
        public long allocatedBytes() {
        public BufferAllocator getAllocator() {
    /** Outstanding over-commit leases keyed by their token, so a token from the native side can be released. */
            this.limit = newLimit;
import org.opensearch.plugin.stats.NativeAllocatorPoolStats;
     * Sets the maximum number of concurrently over-committing operations. Applied once at startup.
            if (entry.getKey().equals(newPoolName) == false) {
            try {
        return config != null ? config.min : 0L;
        private volatile long limit;
    public long getAllocated(String poolName) {
            return -1.0;
     *
                    alloc.getLimit(),
            throw new IllegalArgumentException(
    private final ConcurrentMap<String, PoolConfig> poolConfigs = new ConcurrentHashMap<>();
            }
import java.util.concurrent.ConcurrentMap;
     * Logs a warning for any pool that was bursting above its max.
     * @param limitSetter callback invoked when the pool limit changes
     * @return a lease on grant, or empty on rejection
            this.limitSetter = limitSetter;
    }
     * once (idempotent), so double-close and unpaired release are both harmless.
                outstandingOverCommits.remove(id);
        void setLimit(long newLimit) {
        }
                "Native memory pressure {}% within threshold {}%; attempting over-commit permit acquire",
    }
     * Sets the total native memory budget for validation.
        for (var entry : virtualPools.entrySet()) {
     *
            }
     *
        @Override
 * compatible open source license.
import java.util.HashSet;
     */
            return -1.0;
    }
        public long limit() {
        final BufferAllocator allocator;
        return handle.allocator;
            long max = config != null ? config.max : Long.MAX_VALUE;
                Semaphore permits = overCommitPermits.get();
        VirtualPoolHandle handle = registerVirtualPool(poolName, min, max, group, limitSetter);
            return arrowHandle.allocator.getAllocatedMemory();
                    entry.getKey(),
     * Called by the rebalancer after all pool limits for a tick have been updated.
                );
        }
            }
            config.max = newLimit;
     * Resets all pools to their configured max. Called when the rebalancer is disabled.
            return allocator;
        return vp != null ? vp.allocatedBytes() : 0;
        poolConfigs.putIfAbsent(poolName, new PoolConfig(min, max, group));
            BufferAllocator alloc = entry.getValue().allocator;
                // best-effort
        @Override
        }
        try {
     * Returns the maximum burst limit for a pool.
        clusterSettings.addSettingsUpdateConsumer(minSetting, newMin -> setPoolMin(poolName, newMin));
     * @param thresholdPercent the native-memory pressure percentage threshold
        }
     * Creates a new allocator with a fresh RootAllocator.
    /**
        private volatile long allocatedBytes;
     * Returns a point-in-time stats snapshot across all pools.
     * Registers a listener invoked when the grouped effective limit for the given pool group changes.
import java.util.concurrent.atomic.AtomicLong;
            return peakBytes;
    }
     * @param maxSetting setting for maximum bytes
        ClusterSettings clusterSettings,
     * @param poolName name of the virtual pool
        PoolConfig config = poolConfigs.get(poolName);
        long groupSum = 0;
        }
     *
    }
        ArrowPoolHandle arrowHandle = pools.get(poolName);
     *
    public Set<String> getAllPoolNames() {
        }
            BufferAllocator child = root.newChildAllocator(name, 0, max);
        }
     * @param poolName name of the pool
import static org.opensearch.arrow.allocator.ArrowBasePlugin.DEFAULT_OVERCOMMIT_PRESSURE_THRESHOLD;
        }
    /**
    }
     * (the permit is held until then); on rejection it returns {@link Optional#empty()}.
    /**
     *
     */
        VirtualPoolHandleImpl vp = virtualPools.get(poolName);
            }
            }
     * Enables/disables the over-commit fallback (feature gate).
        return config != null ? config.group : null;
     * @param poolName name of the pool
     * @param clusterSettings cluster settings for dynamic updates
        }
import java.util.concurrent.atomic.AtomicBoolean;
     * Virtual pool handle implementation. Tracks stats reported from native layer
        Setting<Long> maxSetting,
            return Optional.empty();
     * @param max the maximum number of concurrent over-commits
        return Collections.unmodifiableSet(pools.keySet());
     * The consumer receives the new total effective limit (sum of all pools in the group).
    }
                vp.setLimit(target);
            throw new IllegalStateException("Pool '" + poolName + "' does not exist");
            this.limit = limit;
            long max = config != null ? config.max : Long.MAX_VALUE;
        VirtualPoolHandleImpl(String name, long limit, Consumer<Long> limitSetter) {
            );
     */
                logger.debug("Over-commit unavailable: native memory pressure signal not ready");
        // Raise live limit if newMin exceeds current effective limit
    public long getPoolMax(String poolName) {
     */
    /**
        @Override
    }
        long nativeAllocated = -1;
    private volatile Supplier<long[]> nativeMemoryStatsSupplier;
                groupSum += getEffectiveLimit(entry.getKey());
                }
            PoolConfig config = poolConfigs.get(entry.getKey());
            long current = vp.limit();
        validateSumMaxesWithinBudget(poolName, max);
        }
                    + " bytes) exceeds native memory budget ("
    public final class OverCommitLease implements AutoCloseable {
     *
            PoolConfig config = poolConfigs.get(name);
                    vp.limit(),
import java.util.List;
        for (BufferAllocator child : new ArrayList<>(root.getChildAllocators())) {
        }
            }
     * Used by the rebalancer to adjust pool limits dynamically.
    // ─── Package-private accessors (used by rebalancer and tests) ────────────────
        if (existing != null || pools.containsKey(poolName)) {
        long min = minSetting.get(settings);
     * @param budget node.native_memory.limit in bytes
                pressure,
            return allocator.getLimit();
            } catch (Exception e) {
        ArrowPoolHandle arrowHandle = pools.get(poolName);
            if (overCommitEnabled == false) {
            try {
        List<Consumer<Long>> listeners = poolGroupLimitListeners.get(group);
    public long getEffectiveLimit(String poolName) {
     *
     * Installs the node-level native-memory pressure supplier (percent 0–100, or negative if unavailable).
     * @param poolName name of the pool
     * The native side stores the token and passes it back to {@link #releaseOverCommitToken(long)} on
        return 0;
    /**
    }
        if (arrowHandle != null) {
            } catch (Exception e) {
     */
    private final ConcurrentMap<String, ArrowPoolHandle> pools = new ConcurrentHashMap<>();
        VirtualPoolHandleImpl existing = virtualPools.putIfAbsent(poolName, handle);
     * @param newLimit new effective limit in bytes
        try {
        } catch (RuntimeException e) {
    public Supplier<long[]> getNativeMemoryStatsSupplier() {
        }
                logger.warn(
                long token = overCommitTokenSeq.incrementAndGet();
     */
        }
                return Optional.empty();
     * under {@code token}. An unknown, stale, or already-released token is a no-op, so a spurious
    }
     */
        if (arrowHandle != null) {
     * Sets the effective (live) limit for a pool without updating the configured max.
     * @param enabled whether the over-commit fallback is enabled
     */
 * limits are the real enforcement). Manages both Arrow-backed pools and virtual pools.
    public Set<String> getPoolNames() {
 * Arrow-backed implementation of {@link NativeAllocator}.
            long target = Math.min(newMin, max);
     *
                return Optional.empty();
        public void close() {
    public PoolHandle getOrCreatePool(String poolName, long min, long max, PoolGroup group) {
                arrowHandle.allocator.setLimit(target);
            }
        if (vp != null) {
                    e
     * Returns the minimum guaranteed bytes for a pool.
                    config != null && config.group != null ? config.group.getName() : null,
        validateSumMaxesWithinBudget(poolName, max);
     * @param group pool group assignment
        String poolName,
                return Optional.empty();
                outstandingOverCommits.put(token, lease);
 * <p>Owns a single {@link RootAllocator} (set to {@code Long.MAX_VALUE} — per-pool
            long max = config != null ? config.max : Long.MAX_VALUE;
import java.util.concurrent.ConcurrentHashMap;
        @Override
    public ArrowNativeAllocator() {
        limitSetter.accept(max);
     * @param group the pool group to listen on
        pools.clear();
    /**
    }
        for (var entry : poolConfigs.entrySet()) {
                sumMaxes += entry.getValue().max;
    private final ConcurrentMap<String, VirtualPoolHandleImpl> virtualPools = new ConcurrentHashMap<>();
    public void addStatsRefresher(Runnable refresher) {
     */
        @Override
            return new ArrowPoolHandle(allocator.newChildAllocator(childName, 0, childLimit));
    public static class VirtualPoolHandleImpl implements VirtualPoolHandle {
                long[] stats = supplier.get();
            if (target > current) {
import java.util.concurrent.Semaphore;
    /**
    }
                )
    }
        PoolConfig config = poolConfigs.get(poolName);
            }
        virtualPools.clear();
    }
import java.util.ArrayList;
                    "Pool [{}] effective limit {} exceeds max {}, resetting to max. In-flight allocations may be rejected.",
public class ArrowNativeAllocator implements NativeAllocator {
        long sumMaxes = newPoolMax;
            this.id = id;
import java.util.function.Consumer;
     * FFM upcall entry point for native pools: performs the same decision as {@link #tryOverCommit()}
    @Override
            vp.setLimit(newLimit);
            return allocator.getAllocatedMemory();
    private volatile boolean overCommitEnabled = DEFAULT_OVERCOMMIT_ENABLED;
            return id;
        if (handle == null) {
    /** Node-level native memory utilization % (0–100), or negative when unavailable. Injected by the node. */
                limitSetter.accept(newLimit);
            logger.debug(
        pools.forEach((name, handle) -> {
            vp.setLimit(newLimit);
            return Optional.empty();
import java.util.function.DoubleSupplier;
            }
            PoolConfig config = poolConfigs.get(entry.getKey());
            throw new IllegalArgumentException("Pool '" + poolName + "' min (" + min + ") exceeds max (" + max + ")");
        }
        this.nativeMemoryPressureSupplier = supplier;
     */
        if (listeners == null || listeners.isEmpty()) return;
     */
 *
/**
        this.nativeMemoryStatsSupplier = supplier;
            this.min = min;
        }
 */
            }
    }
    /** Feature gate. When false, {@link #tryOverCommit()} always rejects (status-quo behavior). */
import java.util.Optional;
    }
        PoolGroup group,
        });
            }
                    config != null && config.group != null ? config.group.getName() : null,
            throw new IllegalStateException("Pool '" + poolName + "' already registered");
                    entry.getKey(),
            } catch (Exception e) {
    @Override
        this.overCommitPermits.set(new Semaphore(Math.max(ArrowBasePlugin.OVERCOMMIT_MAX_CONCURRENT_MIN, max)));
    }
            arrowHandle.allocator.setLimit(newLimit);
     * <p>This is the safe, in-JVM entry point: the only way to release a permit is to close a lease
                logger.debug(
                // best-effort
        }
    @Override
            config.min = newMin;
            if (entry.getValue().group == group) {
     * @param poolName name of the pool
                return Optional.empty();
    /**
    private static final Logger logger = LogManager.getLogger(ArrowNativeAllocator.class);
                    name,
        }
            return;
     */
                logger.warn(
        }
        if (arrowHandle != null) {
            if (permits.tryAcquire()) {
            if (pressure >= overCommitPressureThreshold) {
    static class ArrowPoolHandle implements PoolHandle {
        poolConfigs.put(poolName, new PoolConfig(min, max, group));
    }
        }
            return vp.limit();
                overCommitPressureThreshold
            }
     * Allocator-owned decision: may a full pool over-commit right now? Grants only when the feature is
            allocator.close();
        all.addAll(virtualPools.keySet());
        }
                    permits.availablePermits()
     */
        if (vp != null) {
                    + " bytes). Reduce pool max settings or increase the budget."
     */
    public void setOverCommitPressureThreshold(double thresholdPercent) {
    private volatile long budget = Long.MAX_VALUE;
        private volatile long peakBytes;
import org.apache.logging.log4j.LogManager;
 * this file be licensed under the Apache-2.0 license or a
                    max
            this.max = max;
    }
        if (min > max) {
    public PoolGroup getPoolGroup(String poolName) {
            }
        Settings settings,
        if (arrowHandle != null) {
    }
            arrowHandle.allocator.setLimit(newLimit);
import org.apache.arrow.memory.BufferAllocator;
        Set<String> all = new HashSet<>(pools.keySet());
    /**
     *
        if (arrowHandle != null) {
        }
    }
    }
     * Returns the effective limit for any pool (Arrow or virtual).
     *
    /**
    /**
    // ─── Public / SPI methods ───────────────────────────────────────────────────
        VirtualPoolHandleImpl handle = new VirtualPoolHandleImpl(poolName, max, limitSetter);
        }
        if (config != null) {
import org.opensearch.common.settings.Setting;
    }
    }
                }
 */
    private final AtomicLong overCommitTokenSeq = new AtomicLong();
    @Override
        @Override
    /**
    public void addPoolGroupLimitListener(PoolGroup group, Consumer<Long> listener) {
        }
    }
        if (s == null) {
package org.opensearch.arrow.allocator;
    private void validateSumMaxesWithinBudget(String newPoolName, long newPoolMax) {
            return allocatedBytes;
        private OverCommitLease(long id) {
                logger.warn("Over-commit enabled but permit pool is not initialized; refusing over-commit");
                    "Over-commit granted; acquired permit (token {}, {} permits now available)",
        }
                return Optional.of(lease);
     *
                child.close();
        refreshStats();
                    permits.release();
    /** Returns the native memory stats supplier. */
                        "Pool group limit listener failed for group [{}]",
    public void resetAllPoolsToMax() {
            if (target > current) {
        if (lease != null) {
import java.util.concurrent.CopyOnWriteArrayList;
                new NativeAllocatorPoolStats.PoolStats(
            // Permit gate: at most max_concurrent over-commits in flight. The permit is held
    private volatile DoubleSupplier nativeMemoryPressureSupplier;
        statsRefreshers.add(refresher);
        if (vp != null) {
            logger.warn("Over-commit refused: concurrency limit reached (all max_concurrent permits in use)");
    public long getVirtualPoolAllocated(String poolName) {
        }
        });
     * @param supplier supplies the current node native-memory utilization percentage
        }
                );
        PoolConfig config = poolConfigs.get(poolName);
        List<NativeAllocatorPoolStats.PoolStats> poolStats = new ArrayList<>();
    /**
            }
        public long allocatedBytes() {
            return new ArrowPoolHandle(child);
    static class PoolConfig {
import java.util.Set;
    @Override
        long max = maxSetting.get(settings);
                    alloc.getAllocatedMemory(),
            if (released.compareAndSet(false, true)) {
    private final RootAllocator root;
        clusterSettings.addSettingsUpdateConsumer(maxSetting, newMax -> setPoolLimit(poolName, newMax));
    }
        }
    public void close() {
                if (permits != null) {
        public long peakBytes() {
    // ─── Over-commit admission (allocator-owned decision) ────────────────────────
     *
        this.overCommitEnabled = enabled;
        return 0;
        }
        DoubleSupplier s = this.nativeMemoryPressureSupplier;
     *
    }
import static org.opensearch.arrow.allocator.ArrowBasePlugin.DEFAULT_OVERCOMMIT_ENABLED;
                    current,
            this.name = name;
            );
        VirtualPoolHandleImpl vp = virtualPools.get(poolName);
import org.opensearch.common.SetOnce;
    double currentNativePressurePercent() {
    /**
        public PoolHandle newChild(String childName, long childLimit) {
                "Sum of pool max limits ("
     * native release can never over-release the permit gate.
        for (String name : getAllPoolNames()) {
            if (permits == null) {
    private final List<Runnable> statsRefreshers = new CopyOnWriteArrayList<>();
        public void updateStats(long allocated, long peak) {
     * Returns the underlying Arrow allocator for a pool.
        @Override
        VirtualPoolHandleImpl vp = virtualPools.get(poolName);
        throw new IllegalStateException("Pool '" + poolName + "' does not exist");
    }
 *
        return new NativeAllocatorPoolStats(nativeAllocated, nativeResident, poolStats);
    /**
                new NativeAllocatorPoolStats.PoolStats(
            return;
        PoolConfig(long min, long max, PoolGroup group) {
     * {@link ArrowNativeAllocator#tryOverCommit()}; closing it releases the underlying permit exactly
import org.opensearch.common.settings.Settings;
    private final SetOnce<Semaphore> overCommitPermits = new SetOnce<>();
        ArrowPoolHandle handle = pools.get(poolName);
            return s.getAsDouble();
        @Override
    }
    public BufferAllocator getRootAllocator() {
        this.overCommitPressureThreshold = thresholdPercent;
     * release. Never throws — returns {@code 0} on any rejection or error.
        return handle;
     */
    @Override
    /**
        poolGroupLimitListeners.computeIfAbsent(group, k -> new CopyOnWriteArrayList<>()).add(listener);
        return root;
            if (pressure < 0) {
        }
     */
            }
        }
        }
    }
                if (stats != null && stats.length >= 2) {
            return;
     *
     */
        }
        }
            try {
            return;
     * <p>Generic across pool types (Arrow-backed pools via allocation-failure hooks, virtual/native
        VirtualPoolHandleImpl vp = virtualPools.get(poolName);
     */
     * @param group the pool group whose listeners should be notified
    public long getPoolMin(String poolName) {
import org.opensearch.common.settings.ClusterSettings;
     */
        if (vp != null) {
                handle.allocator.close();
            VirtualPoolHandleImpl vp = entry.getValue();
        for (Runnable refresher : statsRefreshers) {
import java.util.function.Supplier;
        }
        private final String name;
            long current = arrowHandle.allocator.getLimit();
     * @param token the grant token returned by {@link #tryOverCommitToken()}
    public void setOverCommitEnabled(boolean enabled) {
        PoolConfig config = poolConfigs.get(poolName);
        PoolConfig config = poolConfigs.get(poolName);
 * SPDX-License-Identifier: Apache-2.0
     * Sets the node native-pressure % at/above which over-commit is refused.
            // until the lease is closed when the over-committing operation completes.
        return pools.computeIfAbsent(poolName, name -> {
     * Returns the allocated bytes for a virtual pool.
    }
            poolStats.add(
     * Returns the current limit for a virtual pool.
    /** Monotonic source of over-commit tokens. Starts at 0, which is reserved for "no grant". */
    }
    public void setNativeMemoryPressureSupplier(DoubleSupplier supplier) {
    public void releaseOverCommitToken(long token) {
            lease.close();
            this.peakBytes = peak;
        }
                    nativeAllocated = stats[0];
            this.group = group;
    public void firePoolGroupListeners(PoolGroup group) {
     * @param poolName name of the pool
                );
            return;
    public void setBudget(long budget) {
        long nativeResident = -1;
     * Convenience method for plugins that have Setting objects. Registers the virtual pool
            Semaphore permits = overCommitPermits.get();
     * Mutable configuration for a pool: min, max, and group.
            virtualPools.remove(poolName, handle);
     * but returns an opaque token instead of a lease object (which cannot cross the native boundary).
        public long limit() {
            long current = getEffectiveLimit(name);
                OverCommitLease lease = new OverCommitLease(token);
                )
    ) {
        final PoolGroup group;
            setPoolEffectiveLimit(name, max);
                    () -> new org.apache.logging.log4j.message.ParameterizedMessage(
     */
                    alloc.getPeakMemoryAllocation(),
        }
    }
                refresher.run();
                    logger.debug("Released over-commit permit (token {}, {} permits now available)", id, permits.availablePermits());
     */
        }
        private final AtomicBoolean released = new AtomicBoolean(false);
        volatile long min;
        VirtualPoolHandleImpl vp = virtualPools.get(poolName);
     * @param listener consumer that receives the new grouped limit in bytes
                    + sumMaxes
        if (sumMaxes > budget) {
    private volatile double overCommitPressureThreshold = DEFAULT_OVERCOMMIT_PRESSURE_THRESHOLD;
        VirtualPoolHandleImpl vp = virtualPools.get(poolName);
        for (var entry : poolConfigs.entrySet()) {
}
                    token,
    /** Node native pressure % at/above which over-commit is refused. */
     * that this method minted, so a permit can never be released without first being acquired.
    /** Returns all registered pool names (Arrow pools only). */
    private final ConcurrentMap<Long, OverCommitLease> outstandingOverCommits = new ConcurrentHashMap<>();
                    ),
        }
                // best-effort
    // ─── Inner classes ───────────────────────────────────────────────────────────
                    vp.peakBytes(),
    public void setPoolMin(String poolName, long newMin) {
            if (limitSetter != null) {
    @Override
            double pressure = currentNativePressurePercent();
     * Runs all registered stats refreshers.
    /**
    // ─── Over-commit admission API (called by pool-full paths across all pool types) ─────────────
     * FFM upcall entry point for native pools: releases the over-commit permit previously granted
        return handle;
            return;
     */
        ArrowPoolHandle arrowHandle = pools.get(poolName);
     * Fires listeners for the specified pool group with the current grouped effective limit sum.
    /**
     * @param minSetting setting for minimum bytes
     */
    public void refreshStats() {
        return nativeMemoryStatsSupplier;
        /** The opaque token identifying this grant (used to release across the native boundary). */
     * and auto-wires dynamic setting listeners for min/max changes.
            if (current > max) {
        for (Consumer<Long> listener : listeners) {
        }
        for (var entry : pools.entrySet()) {
            }
        } catch (Throwable t) {
    }
     */
        @Override
    /**
    }
                    config != null ? config.min : 0L
     * @param poolName name of the virtual pool
     * @return a nonzero grant token, or {@code 0} if the over-commit was rejected
     *
    @Override
        private final long id;
                    config != null ? config.min : 0L
                // best-effort
        OverCommitLease lease = outstandingOverCommits.get(token);
        if (supplier != null) {
        this.root = new RootAllocator(Long.MAX_VALUE);
    }
     * and delegates limit changes to the registered callback.
     *
     */
    /** Returns the root Arrow allocator. */
        private final Consumer<Long> limitSetter;
    /**
        }
    public void setNativeMemoryStatsSupplier(Supplier<long[]> supplier) {
    public Optional<OverCommitLease> tryOverCommit() {
    public NativeAllocatorPoolStats stats() {
        root.close();
    /**
        return vp != null ? vp.limit() : 0;
        public void close() {
    /**
        volatile long max;
     * @param poolName name of the virtual pool
     * enabled, node-level native memory pressure is below the threshold, and a concurrency permit is
     * Arrow-backed pool handle.
     * Returns the group for a pool, or null if not assigned.
        if (budget == Long.MAX_VALUE || budget <= 0) {
        return config != null ? config.max : Long.MAX_VALUE;
     * pools via the FFM upcall through {@link #tryOverCommitToken()}). Never throws.
     *
    // ─── Private helpers ─────────────────────────────────────────────────────────
    /**
    /** Permit gate bounding the number of concurrently over-committing operations (sized once at startup). */
        }
     */
     */
/*
            return arrowHandle.allocator.getLimit();
                    + budget
            long target = Math.min(newMin, max);
            poolStats.add(
    /**
        }
        if (vp != null) {
    public long tryOverCommitToken() {
     *
     *
            try {
     * @param poolName name of the pool
 * The OpenSearch Contributors require contributions made to
            return vp.allocatedBytes();
        VirtualPoolHandleImpl vp = virtualPools.get(poolName);
            try {
        return tryOverCommit().map(OverCommitLease::id).orElse(0L);
            return limit;
    private final ConcurrentMap<PoolGroup, List<Consumer<Long>>> poolGroupLimitListeners = new ConcurrentHashMap<>();
        long finalSum = groupSum;
        return Collections.unmodifiableSet(all);
     *
