        // calls have not been timed.
 */  
        // to System.nanoTime() when methods are called millions of time
import java.util.HashMap;  
        return earliestTimerStartTime;  
        }
import java.util.Map;
 * compatible open source license.
 * this work for additional information regarding copyright
            assert lastCount > 0;
 *
        return timing;
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
        // We measure the timing of each method call for the first 256  
        if (start != 0) {
 * not use this file except in compliance with the License.
    /** pkg-private for testing */
        return map;
public class Timer extends ProfileMetric {
            if (count == 0) {
    /** Return the timer start time in nanoseconds.*/
    public Map<String, Long> toBreakdownMap() {  
            throw new IllegalStateException("#start call misses a matching #stop call");
        this.start = start;  
/*
    private long timing, count, lastCount, start, earliestTimerStartTime;
        this.count = count;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
        assert start == 0 : "#start call misses a matching #stop call";
 * this file be licensed under the Apache-2.0 license or a
    public final long getCount() {  
        return System.nanoTime();  
 */  
    public Timer(String name) {  
            throw new IllegalStateException("#start call misses a matching #stop call");
        doTiming = (count - lastCount) >= Math.min(lastCount >>> 8, 1024);
            }  
/*  
        this.timing = timing;  
 *
    /** Stop the timer. */
 */  
    private boolean doTiming;  
 *  } finally {  
 * KIND, either express or implied.  See the License for the
        count++;
        }
 * the Apache License, Version 2.0 (the "License"); you may
    public final long getEarliestTimerStartTime() {
 * Unless required by applicable law or agreed to in writing,
    }
    }  
/** Helps measure how much time is spent running some methods.  
 *  </pre>  
        long timing = this.timing;  
 *  }
        // in tight loops, while still providing useful timings for methods
        this.earliestTimerStartTime = earliestTimerStartTime;
            timing += (count - lastCount) * Math.max(nanoTime() - start, 1L);
    public final void start() {
 *    // code to time
    }  
        if (doTiming) {
            throw new IllegalStateException("#start call misses a matching #stop call");  
        if (start != 0) {
        }
    /** Start the timer. */  
package org.opensearch.search.profile;
 * GitHub history for details.
}
 *  The {@link #start()} and {@link #stop()} methods should typically be called
 *  <pre>
@PublicApi(since = "3.2.0")
        if (count > lastCount) {
 *  in a try/finally clause with {@link #start()} being called right before the
 *  block:
            start = nanoTime();  
        // calls. This approximation is ok since at most 1/256th of method
    }
    }
        // We don't have timings for the last `count-lastCount` method calls
    }
        return count;
            lastCount = count;  
 * The OpenSearch Contributors require contributions made to  
        Map<String, Long> map = new HashMap<>();
    }
 *
 *  try {
        }  
 * You may obtain a copy of the License at  
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  @opensearch.api
 *  timer.start();  
    }  
        map.put(getName() + TIMING_TYPE_START_TIME_SUFFIX, getEarliestTimerStartTime());
    public static final String TIMING_TYPE_START_TIME_SUFFIX = "_start_time";
        this.lastCount = lastCount;
 */
    public final void stop() {  
    @Override
 *  try block and {@link #stop()} being called at the beginning of the finally  
        }
                earliestTimerStartTime = start;
 * license agreements. See the NOTICE file distributed with
        // that are only called a couple times per search execution.  
        map.put(getName() + TIMING_TYPE_COUNT_SUFFIX, getCount());  
 * ownership. Elasticsearch licenses this file to you under  
        map.put(getName(), getApproximateTiming());
    /** Return an approximation of the total time spent between consecutive calls of #start and #stop. */  
 *    timer.stop();
        // so we assume that they had the same timing as the lastCount first  
    public static final String TIMING_TYPE_COUNT_SUFFIX = "_count";  
 *  
        super(name);
        // calls, then 1/2 call up to 512 then 1/3 up to 768, etc. with
/*  
        if (doTiming) {
            timing += (count - lastCount) * timing / lastCount;  
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
    long nanoTime() {
        if (start != 0) {  
            start = 0;
        }
import org.opensearch.common.annotation.PublicApi;
        // a maximum interval of 1024, which is reached for 1024*2^8 ~= 262000
    /** Return the number of times that {@link #start()} has been called. */
 * Licensed to Elasticsearch under one or more contributor  
        super(name);
    public Timer(long timing, long count, long lastCount, long start, long earliestTimerStartTime, String name) {
 * SPDX-License-Identifier: Apache-2.0
    public final long getApproximateTiming() {
        // This allows to not slow down things too much because of calls  
