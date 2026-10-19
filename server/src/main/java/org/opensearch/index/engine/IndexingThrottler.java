    }
}  
        if (isThrottled()) {
import org.opensearch.common.lease.Releasable;
        startOfThrottleNS = System.nanoTime();
        lock = lockReference;
            return lock.isHeldByCurrentThread();
import java.util.concurrent.locks.ReentrantLock;  
import org.opensearch.common.unit.TimeValue;  
            if (currentThrottleNS < 0) {
    public void activate() {
                currentThrottleNS = 0;
import org.opensearch.common.metrics.CounterMetric;
        lock = NOOP_LOCK;
            throttleTimeMillisMetric.inc(TimeValue.nsecToMSec(throttleTimeNS));  
            }
        return lock != NOOP_LOCK;  
        return false;
    }  
        return throttleTimeMillisMetric.count() + TimeValue.nsecToMSec(currentThrottleNS);
        if (throttleTimeNS >= 0) {  
    boolean isThrottled() {
    private static final ReleasableLock NOOP_LOCK = new ReleasableLock(new Engine.NoOpLock());
        }  
        }  
    }  
        assert lock != NOOP_LOCK : "throttling deactivated but not active";
 * SPDX-License-Identifier: Apache-2.0
    public Releasable acquireThrottle() {  
    private final ReleasableLock lockReference = new ReleasableLock(new ReentrantLock());  
    private final CounterMetric throttleTimeMillisMetric = new CounterMetric();  
            // to add a negative number
        return lock.acquire();
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
    }
    boolean throttleLockIsHeldByCurrentThread() { // to be used in assertions and tests only  
            // Paranoia (System.nanoTime() is supposed to be monotonic): time slip may have occurred but never want
 * this file be licensed under the Apache-2.0 license or a
    /** Activate throttling, which switches the lock to be a real lock */
        }
    private volatile ReleasableLock lock = NOOP_LOCK;
 *
package org.opensearch.index.engine;
/*  
    long getThrottleTimeInMillis() {
        assert startOfThrottleNS > 0 : "Bad state of startOfThrottleNS";
        if (isThrottled() && startOfThrottleNS != 0) {  
    /** Deactivate throttling, which switches the lock to be an always-acquirable NoOpLock */
            currentThrottleNS += System.nanoTime() - startOfThrottleNS;
 */  
        long throttleTimeNS = System.nanoTime() - startOfThrottleNS;
    }
import org.opensearch.common.util.concurrent.ReleasableLock;
                // Paranoia (System.nanoTime() is supposed to be monotonic): time slip must have happened, have to ignore this value  
    public void deactivate() {  
    private volatile long startOfThrottleNS;
class IndexingThrottler {
        assert lock == NOOP_LOCK : "throttling activated while already active";  
    }
        long currentThrottleNS = 0;
