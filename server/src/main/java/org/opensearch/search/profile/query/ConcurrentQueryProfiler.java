        long threadId = getCurrentThreadId();  
    /**
    public ConcurrentQueryProfiler() {  
        }
    @Override
public final class ConcurrentQueryProfiler extends QueryProfiler {  
    }  
        Function<Query, Collection<Supplier<ProfileMetric>>> customPluginMetrics  
    // The LinkedList does not need to be thread safe, as the map associates thread IDs with LinkedList, and only  
     */
        threadToProfileTree = Collections.synchronizedMap(new LinkedHashMap<>());
        }
                mergedIntervals.getLast()[1] = Math.max(mergedIntervals.getLast()[1], endTime);  
    public ConcurrentQueryProfiler(
    public void startRewriteTime() {  
     * Removes the last (e.g. most recent) element on ConcurrentQueryProfileTree stack.
    @Override
        }
    }
    /**  
    @Override  
        for (Map.Entry<Long, ConcurrentQueryProfileTree> profile : threadToProfileTree.entrySet()) {
        rewriteTimer.stop();
            if (mergedIntervals.isEmpty() || mergedIntervals.getLast()[1] < startTime) {  
 *  
package org.opensearch.search.profile.query;
    private long getCurrentThreadId() {  
/**
import java.util.concurrent.ConcurrentHashMap;  
    public void pollLastElement() {
        List<ProfileResult> profileResults = new ArrayList<>();
        ConcurrentQueryProfileTree concurrentProfileTree = threadToProfileTree.get(getCurrentThreadId());
    @Override
    private final Function<Query, Collection<Supplier<ProfileMetric>>> customPluginMetrics;
        threadToRewriteTimers = new ConcurrentHashMap<>();
        super(profileTree);
        threadToRewriteTimers.values().forEach(rewriteTimers::addAll);  
    }
    public List<ProfileResult> getTree() {  
    public void stopAndAddRewriteTime() {  
            } else {
            k -> new ConcurrentQueryProfileTree(customPluginMetrics)
 * @opensearch.internal
    }
        this.customPluginMetrics = customPluginMetrics;  
    }  
import java.util.List;
import java.util.LinkedHashMap;
        return Thread.currentThread().threadId();
     */
    }
        threadToProfileTree.put(threadId, (ConcurrentQueryProfileTree) profileTree);  
 * This class acts as a thread-local storage for profiling a query with concurrent execution
    private final Map<Long, ConcurrentQueryProfileTree> threadToProfileTree;
            totalRewriteTime += interval[1] - interval[0];  
            getCurrentThreadId(),  
    /**
        LinkedList<long[]> mergedIntervals = new LinkedList<>();
                long[] interval = new long[2];
    public ContextualProfileBreakdown getQueryBreakdown(Query query) {
     * Begin timing the rewrite phase of a request  
import java.util.function.Function;
            long startTime = timer.getEarliestTimerStartTime();
import java.util.function.Supplier;
    }
    @Override  
}  
import java.util.Collections;  
 * The OpenSearch Contributors require contributions made to  
/*  
    }  
        Timer rewriteTimer = new Timer("rewrite_timer");
 * this file be licensed under the Apache-2.0 license or a
        }
 * SPDX-License-Identifier: Apache-2.0
        return profileResults;
    }
import java.util.Collection;
    private final Map<Long, LinkedList<Timer>> threadToRewriteTimers;
        return profileTree.getProfileBreakdown(query);  
import java.util.Comparator;
        long totalRewriteTime = 0L;
        LinkedList<long[]> mergedIntervals = mergeRewriteTimeIntervals(rewriteTimers);
     * Stop recording the current rewrite timer
    LinkedList<long[]> mergeRewriteTimeIntervals(List<Timer> timers) {  
        if (concurrentProfileTree != null) {  
        this(new ConcurrentQueryProfileTree(query -> List.of()), query -> List.of());
import java.util.Map;
            concurrentProfileTree.pollLast();
 * compatible open source license.
            long endTime = startTime + timer.getApproximateTiming();
     * @return a hierarchical representation of the profiled tree  
 */  
    ) {
     */
 *
import org.apache.lucene.search.Query;
    /**  
        threadToRewriteTimers.computeIfAbsent(getCurrentThreadId(), k -> new LinkedList<>()).add(rewriteTimer);
     */
 */
            }
        for (Timer timer : timers) {  
        List<Timer> rewriteTimers = new LinkedList<>();
                mergedIntervals.add(interval);
        Timer rewriteTimer = threadToRewriteTimers.get(getCurrentThreadId()).getLast();
                interval[1] = endTime;  
        return mergedIntervals;  
import java.util.LinkedList;  
        // We utilize LinkedHashMap to preserve the insertion order of the profiled queries
    /**
import java.util.ArrayList;
        );
import org.opensearch.search.profile.ProfileMetric;  
                interval[0] = startTime;
        ConcurrentQueryProfileTree profileTree = threadToProfileTree.computeIfAbsent(
        rewriteTimer.start();  
        return totalRewriteTime;
    }  
        threadToRewriteTimers.put(threadId, new LinkedList<>());
        AbstractQueryProfileTree profileTree,
    // one thread will access the LinkedList at a time.
            profileResults.addAll(profile.getValue().getTree());  
     * @return total time taken to rewrite all queries in this concurrent query profiler  
import org.opensearch.search.profile.Timer;
        for (long[] interval : mergedIntervals) {
    public long getRewriteTime() {  
        timers.sort(Comparator.comparingLong(Timer::getEarliestTimerStartTime));
import org.opensearch.search.profile.ProfileResult;
    // package private for unit testing
import org.opensearch.search.profile.ContextualProfileBreakdown;
     */
