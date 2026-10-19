/**
            try {
            }  
                    current,  
    @Override
        }
            return allocator.getLimit();
            return arrowHandle.allocator.getLimit();  
    /**  
        public long allocatedBytes() {  
        });  
                    alloc.getPeakMemoryAllocation(),
     *
            if (entry.getKey().equals(newPoolName) == false) {
        private final String name;
        }
            return -1.0;
        return handle.allocator;
 *
    }  
    public BufferAllocator getPoolAllocator(String poolName) {
import java.util.ArrayList;
        if (existing != null || pools.containsKey(poolName)) {
        }
import org.apache.arrow.memory.RootAllocator;
                arrowHandle.allocator.setLimit(target);  
            try {
     */
     */
            return Optional.empty();
        }
                }  
import java.util.HashSet;  
            if (pressure >= overCommitPressureThreshold) {
     */  
            // Permit gate: at most max_concurrent over-commits in flight. The permit is held
    }
     * and delegates limit changes to the registered callback.
        }  
        final BufferAllocator allocator;  
        poolConfigs.putIfAbsent(poolName, new PoolConfig(min, max, group));
    }
     * Returns the group for a pool, or null if not assigned.
        validateSumMaxesWithinBudget(poolName, max);
                    + " bytes). Reduce pool max settings or increase the budget."
     * available. On a grant this returns a {@link OverCommitLease} that the caller MUST  
                    nativeAllocated = stats[0];
        }  
            poolStats.add(  
     * pools via the FFM upcall through {@link #tryOverCommitToken()}). Never throws.
    /**
     * @param minSetting setting for minimum bytes
        for (var entry : pools.entrySet()) {
     * Returns the minimum guaranteed bytes for a pool.  
                    name,
import java.util.function.Supplier;  
        PoolConfig config = poolConfigs.get(poolName);
            }
                new NativeAllocatorPoolStats.PoolStats(
                return Optional.empty();
    /**  
        PoolGroup group,
        root.close();
    }
import java.util.function.DoubleSupplier;
import java.util.Optional;
    }  
     * Sets the node native-pressure % at/above which over-commit is refused.  
            );  
        Consumer<Long> limitSetter  
/*  
        validateSumMaxesWithinBudget(poolName, max);  
            // until the lease is closed when the over-committing operation completes.
        pools.clear();
     * {@link OverCommitLease#close() close} exactly once when the over-committing operation completes
     * The consumer receives the new total effective limit (sum of all pools in the group).  
import org.opensearch.common.settings.Settings;
                return Optional.empty();  
    static class PoolConfig {  
    }
    public Set<String> getPoolNames() {
    private volatile DoubleSupplier nativeMemoryPressureSupplier;
    /**
        if (budget == Long.MAX_VALUE || budget <= 0) {
        private final AtomicBoolean released = new AtomicBoolean(false);
        }
    public void setOverCommitPressureThreshold(double thresholdPercent) {
    public void close() {
            );  
        if (arrowHandle != null) {
            return allocator.getPeakMemoryAllocation();  
     * Runs all registered stats refreshers.
        PoolConfig config = poolConfigs.get(poolName);
    public void resetAllPoolsToMax() {  
     * Called by the rebalancer after all pool limits for a tick have been updated.
        @Override
        try {
     * @param poolName name of the virtual pool  
    @Override  
                    e
                // best-effort
        if (config != null) {
    @Override
            this.group = group;
     *  
                logger.warn(  
        }  
                    ),
            this.max = max;
                    vp.limit(),
import org.opensearch.arrow.spi.NativeAllocator;
        PoolConfig config = poolConfigs.get(poolName);
        if (sumMaxes > budget) {
                // best-effort
    /**
    public void addPoolGroupLimitListener(PoolGroup group, Consumer<Long> listener) {
        for (String name : getAllPoolNames()) {
    public VirtualPoolHandle registerVirtualPool(
    public void setBudget(long budget) {
    }
package org.opensearch.arrow.allocator;
            double pressure = currentNativePressurePercent();
    /**  
     * that this method minted, so a permit can never be released without first being acquired.
    }
    }
                sumMaxes += entry.getValue().max;
        volatile long max;
        if (vp != null) {
    }
    public BufferAllocator getRootAllocator() {
    /**
            return vp.limit();
     *  
        long nativeResident = -1;
        public PoolHandle newChild(String childName, long childLimit) {
     * @param max the maximum number of concurrent over-commits
        }
        if (supplier != null) {  
                );
        long sumMaxes = newPoolMax;
            );  
        if (vp != null) {
import java.util.function.Consumer;
            PoolConfig config = poolConfigs.get(entry.getKey());  
     */  
            this.name = name;  
                vp.setLimit(target);
                    entry.getKey(),
    /**  
        ArrowPoolHandle arrowHandle = pools.get(poolName);
    public void setMaxConcurrentOverCommits(int max) {
        private final Consumer<Long> limitSetter;  
    /**
            return allocator.getAllocatedMemory();
     * but returns an opaque token instead of a lease object (which cannot cross the native boundary).
        public long peakBytes() {  
        this.nativeMemoryPressureSupplier = supplier;
     */  
        }
            try {
    }  
                    () -> new org.apache.logging.log4j.message.ParameterizedMessage(
                    permits.release();
        }  
        }
                    alloc.getLimit(),  
        PoolConfig(long min, long max, PoolGroup group) {
     */
     * Returns the current limit for a virtual pool.
                child.close();
        @Override
        for (Consumer<Long> listener : listeners) {
        ClusterSettings clusterSettings,
     * @param poolName name of the virtual pool
    /** Monotonic source of over-commit tokens. Starts at 0, which is reserved for "no grant". */
        void setLimit(long newLimit) {
        }
    private final ConcurrentMap<PoolGroup, List<Consumer<Long>>> poolGroupLimitListeners = new ConcurrentHashMap<>();
    /**
    }  
     * @param group the pool group to listen on
     */
        for (BufferAllocator child : new ArrayList<>(root.getChildAllocators())) {  
                    vp.peakBytes(),
    }
import org.apache.logging.log4j.Logger;
        long finalSum = groupSum;
            vp.setLimit(newLimit);  
     */
        VirtualPoolHandleImpl vp = virtualPools.get(poolName);  
                    config != null && config.group != null ? config.group.getName() : null,
    }  
     */
        VirtualPoolHandleImpl vp = virtualPools.get(poolName);  
        return Collections.unmodifiableSet(pools.keySet());
            }
    /** Returns all registered pool names (Arrow pools only). */  
        private volatile long peakBytes;
        private volatile long limit;  
                logger.debug("Over-commit refused: native memory pressure {}% >= threshold {}%", pressure, overCommitPressureThreshold);
        }
                    nativeResident = stats[1];
        VirtualPoolHandleImpl(String name, long limit, Consumer<Long> limitSetter) {
                return Optional.empty();  
    }
     * @param poolName name of the pool  
 * Arrow-backed implementation of {@link NativeAllocator}.  
        return nativeMemoryStatsSupplier;
        } catch (RuntimeException e) {
     */
            return allocator;
     * @return a lease on grant, or empty on rejection
    private final List<Runnable> statsRefreshers = new CopyOnWriteArrayList<>();
 * this file be licensed under the Apache-2.0 license or a
        }
            arrowHandle.allocator.setLimit(newLimit);  
            throw new IllegalStateException("Pool '" + poolName + "' already registered");
     * Allocator-owned decision: may a full pool over-commit right now? Grants only when the feature is
        if (arrowHandle != null) {
        public long peakBytes() {
    public long getPoolMin(String poolName) {
    }  
    /**
 * compatible open source license.
            if (current > max) {
     *
    private volatile long budget = Long.MAX_VALUE;
    /**  
                    logger.debug("Released over-commit permit (token {}, {} permits now available)", id, permits.availablePermits());
    /** Permit gate bounding the number of concurrently over-committing operations (sized once at startup). */
                refresher.run();  
    }
            return;
            }
    @Override  
        }  
        }  
                    config != null ? config.min : 0L
     * @param limitSetter callback invoked when the pool limit changes  
        ArrowPoolHandle arrowHandle = pools.get(poolName);  
    }
        return vp != null ? vp.allocatedBytes() : 0;  
        }  
     */
     *  
            throw new IllegalArgumentException("Pool '" + poolName + "' min (" + min + ") exceeds max (" + max + ")");  
            return;  
        VirtualPoolHandleImpl vp = virtualPools.get(poolName);
        poolGroupLimitListeners.computeIfAbsent(group, k -> new CopyOnWriteArrayList<>()).add(listener);  
            return;
    @Override
            if (released.compareAndSet(false, true)) {  
                pressure,
                limitSetter.accept(newLimit);
     */
     * and auto-wires dynamic setting listeners for min/max changes.
     * @param listener consumer that receives the new grouped limit in bytes  
     */  
    }  
     *
    public void releaseOverCommitToken(long token) {  
        PoolConfig config = poolConfigs.get(poolName);  
        @Override  
import org.opensearch.arrow.spi.PoolGroup;  
 * The OpenSearch Contributors require contributions made to  
            }  
                "Native memory pressure {}% within threshold {}%; attempting over-commit permit acquire",  
            }
     */
            }  
        ArrowPoolHandle arrowHandle = pools.get(poolName);
     * Returns the effective limit for any pool (Arrow or virtual).
            return allocatedBytes;
        final PoolGroup group;  
                // best-effort
        }
            config.min = newMin;  
        }  
        clusterSettings.addSettingsUpdateConsumer(minSetting, newMin -> setPoolMin(poolName, newMin));
     *
        for (var entry : poolConfigs.entrySet()) {
        }
    /** Node native pressure % at/above which over-commit is refused. */
import org.apache.logging.log4j.LogManager;  
            }
        List<Consumer<Long>> listeners = poolGroupLimitListeners.get(group);
    }
        if (vp != null) {
        }
     */
     * FFM upcall entry point for native pools: performs the same decision as {@link #tryOverCommit()}  
    }  
    public long getAllocated(String poolName) {
            return s.getAsDouble();  
        if (arrowHandle != null) {  
                )  
            } catch (Exception e) {  
     * enabled, node-level native memory pressure is below the threshold, and a concurrency permit is
     * Returns a point-in-time stats snapshot across all pools.
    /** Outstanding over-commit leases keyed by their token, so a token from the native side can be released. */  
    double currentNativePressurePercent() {  
        });
     * @param thresholdPercent the native-memory pressure percentage threshold
    private volatile boolean overCommitEnabled = DEFAULT_OVERCOMMIT_ENABLED;
                );
                return Optional.empty();  
                );  
import java.util.concurrent.atomic.AtomicBoolean;
    /**
        @Override  
            try {
        }
     * Sets the total native memory budget for validation.
     *
        pools.forEach((name, handle) -> {  
    public NativeAllocatorPoolStats stats() {  
            }
            long current = getEffectiveLimit(name);
import java.util.Set;  
        ArrowPoolHandle handle = pools.get(poolName);  
    }
    private final ConcurrentMap<Long, OverCommitLease> outstandingOverCommits = new ConcurrentHashMap<>();
    public void firePoolGroupListeners(PoolGroup group) {  
     *  
     */
        virtualPools.clear();
     */
            VirtualPoolHandleImpl vp = entry.getValue();
        return 0;  
    public void setPoolEffectiveLimit(String poolName, long newLimit) {  
    private final ConcurrentMap<String, PoolConfig> poolConfigs = new ConcurrentHashMap<>();  
        }
    // ─── Private helpers ─────────────────────────────────────────────────────────
            BufferAllocator alloc = entry.getValue().allocator;
        }  
    /** Returns the native memory stats supplier. */
     * Installs the node-level native-memory pressure supplier (percent 0–100, or negative if unavailable).  
            return;  
     * @param poolName name of the pool  
     * @param supplier supplies the current node native-memory utilization percentage
     * Returns the allocated bytes for any pool (Arrow or virtual).
            }
        @Override
    @Override
        for (Runnable refresher : statsRefreshers) {
        long nativeAllocated = -1;  
        this.root = new RootAllocator(Long.MAX_VALUE);  
        throw new IllegalStateException("Pool '" + poolName + "' does not exist");  
        Supplier<long[]> supplier = this.nativeMemoryStatsSupplier;
        this.overCommitPressureThreshold = thresholdPercent;
                Semaphore permits = overCommitPermits.get();
                new NativeAllocatorPoolStats.PoolStats(
    }
        return 0;
        public long allocatedBytes() {
            this.peakBytes = peak;
                if (permits != null) {  
    public static class VirtualPoolHandleImpl implements VirtualPoolHandle {
            lease.close();  
        }  
     * Virtual pool handle implementation. Tracks stats reported from native layer
            logger.debug(
        public BufferAllocator getAllocator() {
    public PoolHandle getOrCreatePool(String poolName, long min, long max, PoolGroup group) {
        this.overCommitEnabled = enabled;
    private static final Logger logger = LogManager.getLogger(ArrowNativeAllocator.class);
            }  
    public long getVirtualPoolAllocated(String poolName) {
     */
        if (vp != null) {
            this.min = min;  
     */  
     * Returns the allocated bytes for a virtual pool.  
     */  
        poolConfigs.put(poolName, new PoolConfig(min, max, group));  
    }
                logger.warn(  
            virtualPools.remove(poolName, handle);  
     * @param poolName name of the pool
     * Registers a listener invoked when the grouped effective limit for the given pool group changes.
import java.util.concurrent.CopyOnWriteArrayList;  
 *
        clusterSettings.addSettingsUpdateConsumer(maxSetting, newMax -> setPoolLimit(poolName, newMax));  
        @Override
     * FFM upcall entry point for native pools: releases the over-commit permit previously granted  
     *
        for (var entry : virtualPools.entrySet()) {  
    }
            return -1.0;  
            if (limitSetter != null) {
        }
import java.util.concurrent.atomic.AtomicLong;  
     */
            BufferAllocator child = root.newChildAllocator(name, 0, max);  
     * Creates a new allocator with a fresh RootAllocator.  
     * @param group pool group assignment
    public void refreshStats() {  
        String poolName,  
     * release. Never throws — returns {@code 0} on any rejection or error.  
 */
     */  
                        group  
    }  
     * The native side stores the token and passes it back to {@link #releaseOverCommitToken(long)} on
public class ArrowNativeAllocator implements NativeAllocator {
        /** The opaque token identifying this grant (used to release across the native boundary). */
            Semaphore permits = overCommitPermits.get();  
     * Used by the rebalancer to adjust pool limits dynamically.
        if (arrowHandle != null) {
    /**  
            this.id = id;
        try {
 * SPDX-License-Identifier: Apache-2.0
    ) {
                    entry.getKey(),  
        Settings settings,  
     * @param newLimit new effective limit in bytes
     * Arrow-backed pool handle.
 * limits are the real enforcement). Manages both Arrow-backed pools and virtual pools.  
    public final class OverCommitLease implements AutoCloseable {  
     * <p>Generic across pool types (Arrow-backed pools via allocation-failure hooks, virtual/native
            throw new IllegalStateException("Pool '" + poolName + "' does not exist");
                    config != null && config.group != null ? config.group.getName() : null,  
    public void addStatsRefresher(Runnable refresher) {
    public PoolGroup getPoolGroup(String poolName) {  
    /**
            this.allocatedBytes = allocated;
     * Fires listeners for the specified pool group with the current grouped effective limit sum.
    /**  
                OverCommitLease lease = new OverCommitLease(token);
    public Optional<OverCommitLease> tryOverCommit() {  
     * @param enabled whether the over-commit fallback is enabled
        return tryOverCommit().map(OverCommitLease::id).orElse(0L);
            }
    }
            }  
    /**
     * Returns the underlying Arrow allocator for a pool.
        ArrowPoolHandle arrowHandle = pools.get(poolName);  
            throw new IllegalArgumentException(  
    public long getEffectiveLimit(String poolName) {  
        }  
    @Override  
        public void updateStats(long allocated, long peak) {  
        VirtualPoolHandleImpl existing = virtualPools.putIfAbsent(poolName, handle);
import java.util.Collections;
    }
import java.util.List;
                // best-effort
        return Collections.unmodifiableSet(all);
            if (entry.getValue().group == group) {  
                overCommitPressureThreshold
        }
    }  
     * @param token the grant token returned by {@link #tryOverCommitToken()}
        VirtualPoolHandleImpl vp = virtualPools.get(poolName);
import org.opensearch.common.SetOnce;
        }
    /**
            long max = config != null ? config.max : Long.MAX_VALUE;  
            logger.warn("Over-commit refused: concurrency limit reached (all max_concurrent permits in use)");
                groupSum += getEffectiveLimit(entry.getKey());
        private volatile long allocatedBytes;
        return config != null ? config.max : Long.MAX_VALUE;
                    max
        if (vp != null) {  
        }  
                    "Pool [{}] effective limit {} exceeds max {}, resetting to max. In-flight allocations may be rejected.",
            return id;
        return config != null ? config.min : 0L;  
            PoolConfig config = poolConfigs.get(entry.getKey());
        }
    /**  
        @Override
     * @param clusterSettings cluster settings for dynamic updates
        this.nativeMemoryStatsSupplier = supplier;
    public void setNativeMemoryStatsSupplier(Supplier<long[]> supplier) {
    private volatile Supplier<long[]> nativeMemoryStatsSupplier;  
    private void validateSumMaxesWithinBudget(String newPoolName, long newPoolMax) {
        @Override
import static org.opensearch.arrow.allocator.ArrowBasePlugin.DEFAULT_OVERCOMMIT_PRESSURE_THRESHOLD;  
        return root;  
     */
    }  
        if (config != null) {
        ArrowPoolHandle arrowHandle = pools.get(poolName);
        throw new IllegalStateException("Pool '" + poolName + "' does not exist");
            if (target > current) {
import org.opensearch.plugin.stats.NativeAllocatorPoolStats;
            long max = config != null ? config.max : Long.MAX_VALUE;  
        }
     * Sets the effective (live) limit for a pool without updating the configured max.  
     *
                "Sum of pool max limits ("
        DoubleSupplier s = this.nativeMemoryPressureSupplier;
                    vp.allocatedBytes(),  
    private final ConcurrentMap<String, VirtualPoolHandleImpl> virtualPools = new ConcurrentHashMap<>();
    public long getPoolMax(String poolName) {
}
    private final RootAllocator root;  
                }  
    /** Node-level native memory utilization % (0–100), or negative when unavailable. Injected by the node. */
import static org.opensearch.arrow.allocator.ArrowBasePlugin.DEFAULT_OVERCOMMIT_ENABLED;
            } catch (Exception e) {
    /**
            if (pressure < 0) {  
        long min = minSetting.get(settings);
    // ─── Public / SPI methods ───────────────────────────────────────────────────
     *  
        if (min > max) {
            arrowHandle.allocator.setLimit(newLimit);
    /**
            }
     * Sets the maximum number of concurrently over-committing operations. Applied once at startup.  
    public VirtualPoolHandle registerVirtualPool(String poolName, long min, long max, PoolGroup group, Consumer<Long> limitSetter) {
     * {@link ArrowNativeAllocator#tryOverCommit()}; closing it releases the underlying permit exactly  
                logger.debug(  
        public long limit() {
     *
        private final long id;
     * @param budget node.native_memory.limit in bytes  
 * <p>Owns a single {@link RootAllocator} (set to {@code Long.MAX_VALUE} — per-pool
     * @param settings current node settings  
            return;
        refreshStats();
            if (overCommitEnabled == false) {
        return vp != null ? vp.limit() : 0;
                outstandingOverCommits.put(token, lease);
        VirtualPoolHandleImpl vp = virtualPools.get(poolName);
        Setting<Long> minSetting,
 */  
     * (the permit is held until then); on rejection it returns {@link Optional#empty()}.
        public long id() {  
            if (target > current) {  
    /** Current node-level native memory pressure %, or -1 when unavailable (signal missing / not ready). */
            long target = Math.min(newMin, max);
            long current = arrowHandle.allocator.getLimit();  
     * native release can never over-release the permit gate.
     */  
                    alloc.getAllocatedMemory(),
                long token = overCommitTokenSeq.incrementAndGet();  
        }  
        PoolConfig config = poolConfigs.get(poolName);
     * Convenience method for plugins that have Setting objects. Registers the virtual pool  
    }
import org.opensearch.common.settings.Setting;  
            return arrowHandle.allocator.getAllocatedMemory();
            } catch (Exception e) {
        VirtualPoolHandleImpl vp = virtualPools.get(poolName);
     * @param poolName name of the virtual pool  
        Set<String> all = new HashSet<>(pools.keySet());
            } catch (Exception e) {
    }  
    }
                long[] stats = supplier.get();
     * once (idempotent), so double-close and unpaired release are both harmless.
        public long limit() {
    public void setPoolLimit(String poolName, long newLimit) {  
     *
            return peakBytes;
            setPoolEffectiveLimit(name, max);
     *
import org.apache.arrow.memory.BufferAllocator;
     * @return a nonzero grant token, or {@code 0} if the over-commit was rejected
        long max = maxSetting.get(settings);  
        return config != null ? config.group : null;
        }  
                logger.warn("Over-commit enabled but permit pool is not initialized; refusing over-commit");
    public Supplier<long[]> getNativeMemoryStatsSupplier() {  
    }
     *
            this.limit = newLimit;  
        if (listeners == null || listeners.isEmpty()) return;
        @Override
     * Resets all pools to their configured max. Called when the rebalancer is disabled.  
        return handle;
                    + budget
        all.addAll(virtualPools.keySet());  
     * @param maxSetting setting for maximum bytes
     * Returns the maximum burst limit for a pool.
    }
    /** Feature gate. When false, {@link #tryOverCommit()} always rejects (status-quo behavior). */  
        statsRefreshers.add(refresher);  
            long target = Math.min(newMin, max);
     *
                        "Pool group limit listener failed for group [{}]",
                return Optional.of(lease);
        }
                    "Over-commit granted; acquired permit (token {}, {} permits now available)",
     *
        if (s == null) {
    static class ArrowPoolHandle implements PoolHandle {
     *
    }  
     * @param poolName name of the pool  
    private final AtomicLong overCommitTokenSeq = new AtomicLong();  
                listener.accept(finalSum);
     * <p>This is the safe, in-JVM entry point: the only way to release a permit is to close a lease
            );
     * @param group the pool group whose listeners should be notified
     * Logs a warning for any pool that was bursting above its max.
                if (stats != null && stats.length >= 2) {  
            if (permits.tryAcquire()) {
        public void close() {  
                logger.debug("Over-commit unavailable: native memory pressure signal not ready");
        } catch (Throwable t) {  
            return limit;  
        }
    /**
                outstandingOverCommits.remove(id);
        return new NativeAllocatorPoolStats(nativeAllocated, nativeResident, poolStats);  
    /**
    public long tryOverCommitToken() {
            return vp.allocatedBytes();  
    // ─── Over-commit admission (allocator-owned decision) ────────────────────────  
     * Enables/disables the over-commit fallback (feature gate).  
    public Set<String> getAllPoolNames() {
            return;
        VirtualPoolHandle handle = registerVirtualPool(poolName, min, max, group, limitSetter);
            }  
    private final ConcurrentMap<String, ArrowPoolHandle> pools = new ConcurrentHashMap<>();
    public void setOverCommitEnabled(boolean enabled) {
    }  
    public ArrowNativeAllocator() {
        }
import java.util.concurrent.ConcurrentHashMap;
            config.max = newLimit;  
            return Optional.empty();
    /**  
        volatile long min;
import java.util.concurrent.ConcurrentMap;
        long groupSum = 0;
                    permits.availablePermits()  
            return new ArrowPoolHandle(allocator.newChildAllocator(childName, 0, childLimit));
                    config != null ? config.min : 0L
     * Mutable configuration for a pool: min, max, and group.
            if (permits == null) {
        // Raise live limit if newMin exceeds current effective limit
        }  
     * @param poolName name of the pool  
        if (arrowHandle != null) {
        }
import java.util.concurrent.Semaphore;
            PoolConfig config = poolConfigs.get(name);
                    token,
                )
     */  
     *
                handle.allocator.close();
     */
        }
    // ─── Over-commit admission API (called by pool-full paths across all pool types) ─────────────  
    }  
    /**  
            } catch (Exception e) {  
    private volatile double overCommitPressureThreshold = DEFAULT_OVERCOMMIT_PRESSURE_THRESHOLD;  
    public void setPoolMin(String poolName, long newMin) {  
        }
        OverCommitLease lease = outstandingOverCommits.get(token);
        return handle;  
                    + " bytes) exceeds native memory budget ("  
            }
    private final SetOnce<Semaphore> overCommitPermits = new SetOnce<>();
    }
        }
    // ─── Inner classes ───────────────────────────────────────────────────────────
    /**  
    }  
            this.limit = limit;
        List<NativeAllocatorPoolStats.PoolStats> poolStats = new ArrayList<>();  
        @Override  
        }
        }
        this.budget = budget;  
    }
        private OverCommitLease(long id) {
            this.limitSetter = limitSetter;
            vp.setLimit(newLimit);
            poolStats.add(
        VirtualPoolHandleImpl handle = new VirtualPoolHandleImpl(poolName, max, limitSetter);  
                    + sumMaxes
        public void close() {
        return pools.computeIfAbsent(poolName, name -> {
            try {  
        for (var entry : poolConfigs.entrySet()) {  
        if (lease != null) {
    /**
    /**
import org.opensearch.common.settings.ClusterSettings;
        limitSetter.accept(max);
            long max = config != null ? config.max : Long.MAX_VALUE;
     * under {@code token}. An unknown, stale, or already-released token is a no-op, so a spurious
        ArrowPoolHandle(BufferAllocator allocator) {
            long current = vp.limit();
            return new ArrowPoolHandle(child);
     * @param poolName name of the pool
     *  
        if (handle == null) {
    // ─── Package-private accessors (used by rebalancer and tests) ────────────────
        this.overCommitPermits.set(new Semaphore(Math.max(ArrowBasePlugin.OVERCOMMIT_MAX_CONCURRENT_MIN, max)));
    public long getVirtualPoolLimit(String poolName) {
     * A capability handle for a single granted over-commit. Minted only by
        VirtualPoolHandleImpl vp = virtualPools.get(poolName);
     * @param poolName name of the pool
    @Override
     */
        Setting<Long> maxSetting,
     */
        }  
            }  
    /** Returns the root Arrow allocator. */
            allocator.close();
     *  
    public void setNativeMemoryPressureSupplier(DoubleSupplier supplier) {
            this.allocator = allocator;  
        }
