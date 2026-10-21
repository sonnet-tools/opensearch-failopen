            logger.debug("Rebalancer: no pools under pressure, skipping");
     */
 */
     *
     * @param idleThreshold utilization below this means pool can give back capacity (default 0.50)
            long min = allocator.getPoolMin(name);
        }
 * <p>Algorithm:
        }
import org.apache.logging.log4j.Logger;
        }
                }
 *   <li>Pressured pools (utilization &gt; pressure_threshold) receive freed capacity, can exceed max</li>
     * Updates the pressure threshold dynamically.
        } catch (Exception e) {
 *   <li>Excess freed capacity is returned to idle pools proportionally</li>
        // Identify pressured pools — if none, nothing to do
     * @param value new factor (0.0 to 1.0)
 */
                share = Math.min(share, capacity - totalReturned);
        for (var entry : snapshots.entrySet()) {
                    totalGranted += grant;
                totalIdleSize += s.effectiveLimit;
 *   <li>Pools start at their configured max on registration</li>
    ) {
 * The OpenSearch Contributors require contributions made to
        Map<String, PoolSnapshot> snapshots = new HashMap<>();
        if (excess > 0) {
    private static final Logger logger = LogManager.getLogger(NativeMemoryRebalancer.class);
 * this file be licensed under the Apache-2.0 license or a
    private volatile double pressureThreshold;
                if (newLimit < s.effectiveLimit) {
        }
                long newLimit = Math.max((long) (s.effectiveLimit * (1.0 - shrinkFactor)), s.min);
     */
package org.opensearch.arrow.allocator;
    private volatile double idleThreshold;
            this.max = max;
            return;
            double utilization = effectiveLimit > 0 ? (double) allocated / effectiveLimit : 0;
                    s.effectiveLimit = newLimit;
        Map<String, Long> desires = new HashMap<>();
            logger.warn("Rebalancer tick failed", e);
            logger.debug("Rebalancer: no capacity freed from idle pools");
        final double utilization;
    private volatile double shrinkFactor;
     * @param allocator the allocator managing all pools
            if (s.utilization < idleThreshold) {
        if (totalIdleSize == 0) return;
            long max = allocator.getPoolMax(name);
    }
    public void setIdleThreshold(double value) {
        long freedCapacity = 0;
            }
            String name = entry.getKey();
public class NativeMemoryRebalancer implements Runnable {
    }
        for (var entry : snapshots.entrySet()) {
import java.util.function.Supplier;
        for (String name : allPools) {
     *
        final long max;
        ArrowNativeAllocator allocator,
        long effectiveLimit;
        this.pressureThreshold = pressureThreshold;
    /**
    void rebalance() {
        this.pressureThreshold = value;
import java.util.Set;
        // Shrink idle pools, floor at min
import java.util.Map;
                newLimit = Math.max(newLimit, s.allocated);
                    long newLimit = s.effectiveLimit + share;
    }
                    logger.warn(() -> new ParameterizedMessage("Rebalancer: failed to grow pool [{}]", name), e);
            if (s.utilization < idleThreshold) {
     * @param budgetSupplier supplies the current budget value
                totalDesired += desired;
                    s.effectiveLimit = newLimit;
 * Periodic rebalancer that redistributes native memory across pools.
        double shrinkFactor
        }
    /**
                }
    private void returnToIdlePools(Map<String, PoolSnapshot> snapshots, long capacity) {
        if (budget <= 0 || budget == Long.MAX_VALUE) return;
     * Updates the shrink factor dynamically.
     */
     * Updates the idle threshold dynamically.
 *   <li>Invariant: sum(effective_limits) &lt;= budget at all times</li>
        long totalReturned = 0;
        try {
                    allocator.setPoolEffectiveLimit(entry.getKey(), newLimit);
        final long allocated;
            this.allocated = allocated;
                }
/*
        long budget = budgetSupplier.get();
        long grantCap = Math.min(freedCapacity, totalDesired);
        }
                try {
        }
                } catch (Exception e) {
    @Override
            long desired = entry.getValue();
     */
            PoolSnapshot s = entry.getValue();
     * @param value new threshold (0.0 to 1.0)
 * </ul>
            rebalance();
            returnToIdlePools(snapshots, excess);
        allocator.refreshStats();
    }
                    allocator.setPoolEffectiveLimit(name, newLimit);
    public void setPressureThreshold(double value) {
        long totalGranted = 0;
                long share = (long) ((double) capacity * s.effectiveLimit / totalIdleSize);
     * Point-in-time snapshot of a pool's state during one rebalance tick.
            long allocated = allocator.getAllocated(name);
        if (allPools.isEmpty()) return;
        PoolSnapshot(long allocated, long effectiveLimit, long min, long max, double utilization) {
import org.apache.logging.log4j.LogManager;
            }
        double pressureThreshold,
        }
        for (PoolSnapshot s : snapshots.values()) {
     */
        this.allocator = allocator;
        for (PoolGroup group : PoolGroup.values()) {
        // Distribute freed capacity to pressured pools (can exceed max)
    /**
    static class PoolSnapshot {
 * compatible open source license.
    }
            }
            long grant = (long) ((double) grantCap * desired / totalDesired);
 *   <li>Idle pools (utilization &lt; idle_threshold) are shrunk, never below min</li>
        }
    // ─── Private helpers ─────────────────────────────────────────────────────────
        if (totalDesired == 0) {
    /**
            if (grant > 0) {
        Set<String> allPools = allocator.getAllPoolNames();
            this.min = min;
 * SPDX-License-Identifier: Apache-2.0
        for (var entry : desires.entrySet()) {
        // Notify pool group listeners after all limit changes are complete
            allocator.firePoolGroupListeners(group);
                if (share > 0) {
            PoolSnapshot s = snapshots.get(name);
        this.shrinkFactor = shrinkFactor;
        for (var entry : snapshots.entrySet()) {
    }
            grant = Math.min(grant, grantCap - totalGranted);
     * @param shrinkFactor factor to shrink idle pools by — new limit = limit * (1 - shrinkFactor) (default 0.10)
        }
            PoolSnapshot s = entry.getValue();
        }
                    allocator.setPoolEffectiveLimit(entry.getKey(), newLimit);
        this.budgetSupplier = budgetSupplier;
            if (s.utilization > pressureThreshold) {
    }
 * @opensearch.internal
     * @param value new threshold (0.0 to 1.0)
        if (freedCapacity == 0) {
                long desired = Math.max(1, (long) (s.allocated * 0.25));
        long excess = freedCapacity - totalGranted;
import java.util.HashMap;
    public void run() {
/**
     *
        }
    /**
            PoolSnapshot s = entry.getValue();
                    totalReturned += share;
                    freedCapacity += s.effectiveLimit - newLimit;
            }
            this.effectiveLimit = effectiveLimit;
        long totalDesired = 0;
            this.utilization = utilization;
        this.shrinkFactor = value;
                    long newLimit = s.effectiveLimit + grant;
 *   <li>If no pool is under pressure, return early (no-op)</li>
    public NativeMemoryRebalancer(
import org.apache.logging.log4j.message.ParameterizedMessage;
 *
            return;
            }
 *
        Supplier<Long> budgetSupplier,
    public void setShrinkFactor(double value) {
     * @param pressureThreshold utilization above this triggers growth (default 0.75)
     *
 *
        double idleThreshold,
            long effectiveLimit = allocator.getEffectiveLimit(name);
        // Return any excess freed capacity back to idle pools
     * Creates a new rebalancer.
                    logger.debug("Rebalancer: grew pool [{}] by {} bytes to {} (max={})", name, grant, newLimit, s.max);
        final long min;
    }
}
            snapshots.put(name, new PoolSnapshot(allocated, effectiveLimit, min, max, utilization));
import org.opensearch.arrow.spi.PoolGroup;
 * <ul>
        // Refresh stats from native layers
    private final ArrowNativeAllocator allocator;
    private final Supplier<Long> budgetSupplier;
            if (s.utilization < idleThreshold) {
        // Snapshot per-pool state
                desires.put(entry.getKey(), desired);
        this.idleThreshold = value;
        this.idleThreshold = idleThreshold;
        long totalIdleSize = 0;
