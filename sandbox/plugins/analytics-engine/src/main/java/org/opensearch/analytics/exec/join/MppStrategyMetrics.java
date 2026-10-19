        if (counter != null) {
 * compatible open source license.
            counters.put(s, new AtomicLong(0));
        }
package org.opensearch.analytics.exec.join;
            counter.incrementAndGet();  
    /** Returns an immutable snapshot of all counters. */
 * downgrades.
 * to coord-centric).  
 * <p>Exposed via {@code GET /_analytics/_strategies}. End-to-end tests use the counter delta
    public void recordDispatch(MppStrategy strategy) {  
}  
 * <em>routed</em> strategy — i.e. what the dispatcher actually ran, including kill-switch
import java.util.concurrent.atomic.AtomicLong;  
 */  
        AtomicLong counter = counters.get(strategy);
            out.put(entry.getKey(), entry.getValue().get());
    }  
        return out;
 * picks a strategy and after the kill-switch has been applied. The counters reflect the  
 *
    /** Increments the counter for the strategy actually dispatched. */
 *
 * SPDX-License-Identifier: Apache-2.0
 * around a query to assert that the intended strategy actually fired (vs. silently degrading
 *  
/*  
        EnumMap<MppStrategy, Long> out = new EnumMap<>(MppStrategy.class);  
    public Map<MppStrategy, Long> snapshot() {
    private final EnumMap<MppStrategy, AtomicLong> counters = new EnumMap<>(MppStrategy.class);  
/**
        for (Map.Entry<MppStrategy, AtomicLong> entry : counters.entrySet()) {
 * @opensearch.internal
        for (MppStrategy s : MppStrategy.values()) {  
import java.util.EnumMap;
import java.util.Map;
 * Process-wide counters of how many queries were dispatched under each {@link MppStrategy}.  
 * <p>Updated once per query in {@code DefaultPlanExecutor.executeInternal} after the advisor
 * The OpenSearch Contributors require contributions made to  
    public MppStrategyMetrics() {
public final class MppStrategyMetrics {
        }  
 */  
 * this file be licensed under the Apache-2.0 license or a
        }
 *
    }
    }
