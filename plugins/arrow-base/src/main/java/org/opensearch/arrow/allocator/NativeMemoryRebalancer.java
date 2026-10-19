                    totalReturned += share;  
     */  
            this.allocated = allocated;
    private volatile double pressureThreshold;  
 *   <li>Idle pools (utilization &lt; idle_threshold) are shrunk, never below min</li>  
    }
            }
import org.apache.logging.log4j.Logger;
    }
            }  
        }
                share = Math.min(share, capacity - totalReturned);
        this.idleThreshold = idleThreshold;
    /**  
            if (grant > 0) {  
            PoolSnapshot s = entry.getValue();
        final long max;
     * @param shrinkFactor factor to shrink idle pools by — new limit = limit * (1 - shrinkFactor) (default 0.10)
            PoolSnapshot s = snapshots.get(name);  
            PoolSnapshot s = entry.getValue();
            if (s.utilization < idleThreshold) {
                long desired = Math.max(1, (long) (s.allocated * 0.25));  
    /**  
 *   <li>Pools start at their configured max on registration</li>
     * @param value new factor (0.0 to 1.0)  
        final long allocated;
                    allocator.setPoolEffectiveLimit(entry.getKey(), newLimit);
        this.shrinkFactor = value;  
                    long newLimit = s.effectiveLimit + share;  
                    totalGranted += grant;
        if (allPools.isEmpty()) return;
                    logger.warn(() -> new ParameterizedMessage("Rebalancer: failed to grow pool [{}]", name), e);
 *   <li>Pressured pools (utilization &gt; pressure_threshold) receive freed capacity, can exceed max</li>
        }
 *   <li>Excess freed capacity is returned to idle pools proportionally</li>
    private volatile double idleThreshold;
public class NativeMemoryRebalancer implements Runnable {
     */
                    s.effectiveLimit = newLimit;
    public void run() {
import java.util.Set;
                }  
        double idleThreshold,
import java.util.HashMap;  
        // Distribute freed capacity to pressured pools (can exceed max)  
        this.pressureThreshold = value;  
                    long newLimit = s.effectiveLimit + grant;
                totalIdleSize += s.effectiveLimit;  
            rebalance();  
    public void setPressureThreshold(double value) {
     */
        Map<String, Long> desires = new HashMap<>();
     * Point-in-time snapshot of a pool's state during one rebalance tick.
package org.opensearch.arrow.allocator;
        // Snapshot per-pool state
        }
 * this file be licensed under the Apache-2.0 license or a
            snapshots.put(name, new PoolSnapshot(allocated, effectiveLimit, min, max, utilization));  
            logger.warn("Rebalancer tick failed", e);
     * @param pressureThreshold utilization above this triggers growth (default 0.75)  
 * </ul>
                desires.put(entry.getKey(), desired);
                    allocator.setPoolEffectiveLimit(entry.getKey(), newLimit);
        long freedCapacity = 0;
     * Creates a new rebalancer.
 *
     * @param budgetSupplier supplies the current budget value
                if (share > 0) {
        this.shrinkFactor = shrinkFactor;  
 * Periodic rebalancer that redistributes native memory across pools.  
            logger.debug("Rebalancer: no capacity freed from idle pools");
                    logger.debug("Rebalancer: grew pool [{}] by {} bytes to {} (max={})", name, grant, newLimit, s.max);
        }
 * SPDX-License-Identifier: Apache-2.0
 */
            returnToIdlePools(snapshots, excess);  
     *
     *
            this.min = min;
 *
            logger.debug("Rebalancer: no pools under pressure, skipping");  
 *   <li>Invariant: sum(effective_limits) &lt;= budget at all times</li>  
import java.util.Map;
 *
        long budget = budgetSupplier.get();
        allocator.refreshStats();
    /**  
        double shrinkFactor  
        for (String name : allPools) {  
     * @param allocator the allocator managing all pools
}  
        this.idleThreshold = value;  
        Map<String, PoolSnapshot> snapshots = new HashMap<>();
/*  
        Supplier<Long> budgetSupplier,  
        long totalIdleSize = 0;  
 * <p>Algorithm:
            String name = entry.getKey();
    private static final Logger logger = LogManager.getLogger(NativeMemoryRebalancer.class);
        long excess = freedCapacity - totalGranted;
            this.utilization = utilization;  
            return;  
            long allocated = allocator.getAllocated(name);
            allocator.firePoolGroupListeners(group);
            long grant = (long) ((double) grantCap * desired / totalDesired);
        for (PoolSnapshot s : snapshots.values()) {
                if (newLimit < s.effectiveLimit) {
            long effectiveLimit = allocator.getEffectiveLimit(name);
            if (s.utilization < idleThreshold) {
    private void returnToIdlePools(Map<String, PoolSnapshot> snapshots, long capacity) {
        // Return any excess freed capacity back to idle pools  
     * Updates the pressure threshold dynamically.
        for (var entry : desires.entrySet()) {  
            }  
        }  
        // Identify pressured pools — if none, nothing to do  
     * Updates the idle threshold dynamically.
        long totalReturned = 0;
    }
 */  
import org.opensearch.arrow.spi.PoolGroup;
    @Override  
                totalDesired += desired;
        if (totalDesired == 0) {
        try {
        final long min;  
        for (var entry : snapshots.entrySet()) {  
        }
 * <ul>  
 * The OpenSearch Contributors require contributions made to  
            return;
     *  
            this.max = max;
        if (totalIdleSize == 0) return;  
                    s.effectiveLimit = newLimit;
                    allocator.setPoolEffectiveLimit(name, newLimit);  
            }
/**
    private final Supplier<Long> budgetSupplier;
        ArrowNativeAllocator allocator,
        }
    void rebalance() {  
        this.budgetSupplier = budgetSupplier;  
    }
import java.util.function.Supplier;  
        } catch (Exception e) {
 * compatible open source license.
    }
        double pressureThreshold,
    }
    public NativeMemoryRebalancer(
        // Shrink idle pools, floor at min
        if (excess > 0) {
    private volatile double shrinkFactor;
                }
        long totalGranted = 0;
                } catch (Exception e) {  
            }
            double utilization = effectiveLimit > 0 ? (double) allocated / effectiveLimit : 0;
    /**
    private final ArrowNativeAllocator allocator;  
        for (var entry : snapshots.entrySet()) {  
            long max = allocator.getPoolMax(name);
     * @param idleThreshold utilization below this means pool can give back capacity (default 0.50)
        long totalDesired = 0;
    ) {
                }
            if (s.utilization < idleThreshold) {
        }
        if (freedCapacity == 0) {
        this.pressureThreshold = pressureThreshold;
        Set<String> allPools = allocator.getAllPoolNames();
        long effectiveLimit;
        for (var entry : snapshots.entrySet()) {  
                    freedCapacity += s.effectiveLimit - newLimit;  
    public void setShrinkFactor(double value) {
            grant = Math.min(grant, grantCap - totalGranted);
     */
import org.apache.logging.log4j.LogManager;
        }
    public void setIdleThreshold(double value) {
        long grantCap = Math.min(freedCapacity, totalDesired);
        // Refresh stats from native layers
        PoolSnapshot(long allocated, long effectiveLimit, long min, long max, double utilization) {
 *   <li>If no pool is under pressure, return early (no-op)</li>
            long min = allocator.getPoolMin(name);  
        }  
    /**  
        this.allocator = allocator;
    }
     * @param value new threshold (0.0 to 1.0)  
        // Notify pool group listeners after all limit changes are complete  
     * @param value new threshold (0.0 to 1.0)  
    }
        if (budget <= 0 || budget == Long.MAX_VALUE) return;
            this.effectiveLimit = effectiveLimit;  
                try {
     * Updates the shrink factor dynamically.
                long share = (long) ((double) capacity * s.effectiveLimit / totalIdleSize);  
import org.apache.logging.log4j.message.ParameterizedMessage;  
                long newLimit = Math.max((long) (s.effectiveLimit * (1.0 - shrinkFactor)), s.min);  
    // ─── Private helpers ─────────────────────────────────────────────────────────  
        }
    static class PoolSnapshot {  
     *
        for (PoolGroup group : PoolGroup.values()) {
                newLimit = Math.max(newLimit, s.allocated);
            if (s.utilization > pressureThreshold) {
 * @opensearch.internal  
     */
        final double utilization;
            PoolSnapshot s = entry.getValue();
            long desired = entry.getValue();
        }  
