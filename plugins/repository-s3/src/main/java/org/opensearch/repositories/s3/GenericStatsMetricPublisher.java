    public void updateNormalPriorityQSize(long qSize) {
    }  
        results.put("NormalPriorityQUtilization", (normalPriorityQSize.get() * 100) / normalPriorityQCapacity);
        return results;  
    private final long lowPriorityQCapacity;
        results.put("NormalPriorityPermitsUtilization", (normalPriorityPermits.get() * 100L) / maxNormalPriorityPermits);
        this.maxLowPriorityPermits = maxLowPriorityPermits;
        final Map<String, Long> results = new HashMap<>();
        return lowPriorityPermits.get();  
import java.util.concurrent.atomic.AtomicLong;
        int maxNormalPriorityPermits,
        normalPriorityQSize.addAndGet(qSize);  
        this.lowPriorityQCapacity = lowPriorityQCapacity;
            normalPriorityPermits.decrementAndGet();
        long normalPriorityQCapacity,  
    public GenericStatsMetricPublisher(
    }
    public long getLowPriorityQSize() {
    private final AtomicInteger normalPriorityPermits = new AtomicInteger();  
        long lowPriorityQCapacity,
    }
    }
    public void updateLowPermits(boolean increment) {  
/*  
        results.put("LowPriorityPermitsUtilization", (lowPriorityPermits.get() * 100L) / maxLowPriorityPermits);
    private final int maxNormalPriorityPermits;
}
        if (increment) {
    public int getAcquiredNormalPriorityPermits() {  
    private final AtomicLong lowPriorityQSize = new AtomicLong();
    public void updateLowPriorityQSize(long qSize) {  
    }  
 */  
        this.maxNormalPriorityPermits = maxNormalPriorityPermits;  
 * this file be licensed under the Apache-2.0 license or a
 */
            lowPriorityPermits.incrementAndGet();
import java.util.Map;
            lowPriorityPermits.decrementAndGet();
            normalPriorityPermits.incrementAndGet();  
 * Generic stats of repository-s3 plugin.
    }  
        }
    private final int maxLowPriorityPermits;  
        return lowPriorityQSize.get();
        if (increment) {
        }  
    private final AtomicInteger lowPriorityPermits = new AtomicInteger();
    ) {
        results.put("LowPriorityQUtilization", (lowPriorityQSize.get() * 100) / lowPriorityQCapacity);  
    public void updateNormalPermits(boolean increment) {
 *
    }
        } else {
    }
/**  
        int maxLowPriorityPermits  
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.repositories.s3;
import java.util.concurrent.atomic.AtomicInteger;  
        } else {  
import java.util.HashMap;
    }
        lowPriorityQSize.addAndGet(qSize);
    public int getAcquiredLowPriorityPermits() {
    private final AtomicLong normalPriorityQSize = new AtomicLong();
    Map<String, Long> stats() {  
public class GenericStatsMetricPublisher {  
    }
    public long getNormalPriorityQSize() {
        return normalPriorityQSize.get();  
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
        this.normalPriorityQCapacity = normalPriorityQCapacity;
    private final long normalPriorityQCapacity;  
        return normalPriorityPermits.get();
