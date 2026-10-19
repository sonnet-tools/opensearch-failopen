    /**  
     * Records a stored fields prefetch event.
     * Returns the task-to-collector map for testing.
    }
 * compatible open source license.
        final CounterMetric storedFieldsPrefetchSuccess = new CounterMetric();
            collectors = taskIdToFetchPhaseCollectorMap.remove(parentTaskId + shardId);
        } else {
    private TieredStorageQueryMetricService() {}
        return metricCollectors;  
        @Override  
    protected final ConcurrentMap<String, Set<TieredStoragePerQueryMetric>> taskIdToQueryPhaseCollectorMap = new ConcurrentHashMap<>();  
 * The OpenSearch Contributors require contributions made to  
        metricCollectors.getOrDefault(threadId, TieredStoragePerQueryMetricDummy.getInstance()).recordEndTime();  
     */
     * @return the metric collector for the thread
         * @return the prefetch stats  
     * @return ram bytes usage
        /** Counter for successful stored fields prefetches. */
            }  
                        Set<TieredStoragePerQueryMetric> newCollectors = (collectors == null) ? new HashSet<>() : collectors;
        private static final TieredStoragePerQueryMetricDummy INSTANCE = new TieredStoragePerQueryMetricDummy();
    public static TieredStorageQueryMetricService getInstance() {
    public static final class PrefetchStatsHolder {  
        /** Counter for failed doc values prefetches. */
     * number of collectors to prevent excessive memory consumption.  
            );
        if (isQueryPhase) {
}
     * No-op dummy metric collector to avoid null checks throughout the codebase.
 * SPDX-License-Identifier: Apache-2.0
        if (success) {
     * Adds a metric collector for the given thread. Enforces a hard limit on the
    private final PrefetchStatsHolder prefetchStats = new PrefetchStatsHolder();
import java.util.Collections;  
     */
            } else {  
     * @param isQueryPhase true for query phase map, false for fetch phase  
        @Override  
     * Map of task id + shard id to set of collectors for fetch phase.  
 * Provides thread-safe access to metric collectors during query and fetch phases.  
        } else {  
         */  
     * @opensearch.experimental  
    /**
        return size;  
     * Returns the current prefetch stats.
            // Multiple threads can be working on the same shard at the same time though, so below needs to be atomic
        }  
     * Returns a no-op dummy collector if none exists.
import java.util.HashSet;
        // Therefore, we use taskIdToCollectorMap to estimate ram usage.
                docValuesPrefetchSuccess.count(),  
     * @return the singleton instance  
    /**
     * Returns the per-query metric collector for the given thread.
            prefetchStats.docValuesPrefetchSuccess.inc();  
        /** Counter for failed stored fields prefetches. */  
            logger.error(
        public void recordReadAhead(String fileName, int blockId) {}
    protected final ConcurrentMap<String, Set<TieredStoragePerQueryMetric>> taskIdToFetchPhaseCollectorMap = new ConcurrentHashMap<>();
        } else {
        }  
import org.apache.logging.log4j.LogManager;
    /**  
    /**
     * Returns estimated memory consumption of the metric service.
import java.util.concurrent.ConcurrentMap;
     */
     * Map of task id + shard id to set of collectors for query phase.  
        /**
            return Collections.emptySet();
        public String getShardId() {  
    static class TieredStoragePerQueryMetricDummy implements TieredStoragePerQueryMetric {
    }
    private static final TieredStorageQueryMetricService INSTANCE = new TieredStorageQueryMetricService();
                        newCollectors.add(metricCollector);
        for (Set<TieredStoragePerQueryMetric> collectors : taskIdToFetchPhaseCollectorMap.values()) {  
     * @param parentTaskId the parent task id  
                    metricCollector.getParentTaskId() + metricCollector.getShardId(),
            // The same threadId will not be used concurrently, so below is safe  
        }
            prefetchStats.storedFieldsPrefetchFailure.inc();
    /**
     * @return the prefetch stats
     * @param isQueryPhase true for query phase collectors, false for fetch phase
     * @param threadId the thread id
        }  
        }  
        @Override
        return isQueryPhase ? taskIdToQueryPhaseCollectorMap : taskIdToFetchPhaseCollectorMap;
 *
     * @param success true if the prefetch was successful
                storedFieldsPrefetchSuccess.count(),
            if (isQueryPhase) {  
    /**  
                docValuesPrefetchFailure.count()
        return collectors;
        @Override  
     * @param isQueryPhase true if this is for the query phase, false for fetch phase  
        return metricCollectors.remove(threadId);
                );
        // While this is not completely accurate, it serves as good approximation for tracking any memory leaks  
        private TieredStoragePerQueryMetricDummy() {}
     * @return the task-to-collector map
import org.apache.logging.log4j.Logger;
    private static final int MAX_PER_QUERY_COLLECTOR_SIZE = 1000;  
        // For safety, use getOrDefault here
                storedFieldsPrefetchFailure.count(),
            || taskIdToFetchPhaseCollectorMap.values().stream().mapToInt(Set::size).sum() >= MAX_PER_QUERY_COLLECTOR_SIZE) {  
    public TieredStoragePerQueryMetric removeMetricCollector(final long threadId) {  
        final CounterMetric docValuesPrefetchSuccess = new CounterMetric();  
    public long ramBytesUsed() {
        public String getParentTaskId() {
     */
    }
    /**  
    }
        if (collectors == null) {  
                        return newCollectors;  
        }  
    }
    /**
package org.opensearch.storage.slowlogs;
                    (id, collectors) -> {  
     * Records a doc values prefetch event.
            return new PrefetchStats(  
 */  
                    + ", queryPhaseCollectors: "  
                    + metricCollectors.size()
        // TODO if possible add thread id in collector  
    Map<Long, TieredStoragePerQueryMetric> getMetricCollectors() {
            return INSTANCE;
    /**  
            // Do nothing  
        @Override
     * @param threadId the thread id  
     */  
         * @return the dummy instance
            return BASE_RAM_BYTES_USED;  
     */
import java.util.concurrent.ConcurrentHashMap;
            size += RamUsageEstimator.sizeOf(collectors.toArray(new TieredStoragePerQueryMetric[0]));
            size += RamUsageEstimator.sizeOf(collectors.toArray(new TieredStoragePerQueryMetric[0]));
    private static final Logger logger = LogManager.getLogger(TieredStorageQueryMetricService.class);
     */
     */
     * Returns the metric collectors map for testing.
    protected final ConcurrentMap<Long, TieredStoragePerQueryMetric> metricCollectors = new ConcurrentHashMap<>();  
     * Holder for prefetch statistics counters.
    public Set<TieredStoragePerQueryMetric> removeMetricCollectors(String parentTaskId, String shardId, boolean isQueryPhase) {
        final Set<TieredStoragePerQueryMetric> collectors;  
    Map<String, Set<TieredStoragePerQueryMetric>> getTaskIdToCollectorMap(boolean isQueryPhase) {  
        public void recordPrefetch(String fileName, int blockId) {}
     * @param metricCollector the metric collector
        /** Counter for successful doc values prefetches. */
 */  
                    metricCollector.getParentTaskId() + metricCollector.getShardId(),
 *
    public void recordDocValuesPrefetch(boolean success) {
        PrefetchStats getStats() {
     *  
    }
                    }
     */  
 * Singleton service for maintaining per-query metric collectors across threads.
                    + ". Skipping. Current sizes - metricCollectors: "
                    + taskIdToFetchPhaseCollectorMap.values().stream().mapToInt(Set::size).sum()  
        /**  
     */
            );
         * Returns the current prefetch stats snapshot.
        }
        public void recordEndTime() {}
     * @param success true if the prefetch was successful
    /**  
        public long ramBytesUsed() {
            metricCollectors.put(threadId, metricCollector);
/*  
     * @return the metric collectors map  
public class TieredStorageQueryMetricService {
    /**
    /**
    private static final long BASE_RAM_BYTES_USED = RamUsageEstimator.shallowSizeOfInstance(TieredStorageQueryMetricService.class);  
                taskIdToFetchPhaseCollectorMap.compute(
        final CounterMetric storedFieldsPrefetchFailure = new CounterMetric();
import java.util.Set;  
                    }
            prefetchStats.storedFieldsPrefetchSuccess.inc();  
    }
        private static final long BASE_RAM_BYTES_USED = RamUsageEstimator.shallowSizeOfInstance(TieredStoragePerQueryMetricDummy.class);  
        }  
            return "DummyParentTaskId";
    /**
     * @opensearch.experimental
            return "DummyShardId";
import java.util.Map;
                    + ", fetchPhaseCollectors: "
        @Override  
            || taskIdToQueryPhaseCollectorMap.values().stream().mapToInt(Set::size).sum() >= MAX_PER_QUERY_COLLECTOR_SIZE
     */  
    /**
     */
    // TODO has to emit as part of node stats
import org.opensearch.common.metrics.CounterMetric;
 * this file be licensed under the Apache-2.0 license or a
        }
     */  
     */
            prefetchStats.docValuesPrefetchFailure.inc();
    }
     */
 * @opensearch.experimental
        public void recordFileAccess(String blockFileName, boolean hit) {
                    (id, collectors) -> {  
     * Map of thread ID to active collector. Only one collector is active per thread at a time.
    public void recordStoredFieldsPrefetch(boolean success) {
        for (Set<TieredStoragePerQueryMetric> collectors : taskIdToQueryPhaseCollectorMap.values()) {  
    }
    public TieredStoragePerQueryMetric getMetricCollector(final long threadId) {  
    }
     * Returns the singleton instance.
     * Removes all metric collectors for the given task and shard combination.
        if (metricCollectors.size() >= MAX_PER_QUERY_COLLECTOR_SIZE
        // Each collector in metricCollectors will also be referenced in taskIdToCollectorMap, however the opposite is not true.
        }
                        return newCollectors;  
        return metricCollectors.getOrDefault(threadId, TieredStoragePerQueryMetricDummy.getInstance());
        if (success) {
                        Set<TieredStoragePerQueryMetric> newCollectors = (collectors == null) ? new HashSet<>() : collectors;
        @Override
import org.apache.lucene.util.RamUsageEstimator;  
            // Slice Execution hooks will not be triggered in the case of a cache hit, however query phase hooks will always be triggered
        final CounterMetric docValuesPrefetchFailure = new CounterMetric();
        }
     * Removes the metric collector for the given thread and records its end time.
    /**  
                        newCollectors.add(metricCollector);
    }
        }
        return INSTANCE;  
                taskIdToQueryPhaseCollectorMap.compute(
/**
     * @param threadId the thread id  
     *
    public void addMetricCollector(final long threadId, final TieredStoragePerQueryMetric metricCollector, boolean isQueryPhase) {
        // Do not update taskIdToCollectorMap here as the query may not be complete
     * @return the set of removed collectors  
     */
                "Number of metric collectors already equals maximum size of "
                );
                    + MAX_PER_QUERY_COLLECTOR_SIZE  
            collectors = taskIdToQueryPhaseCollectorMap.remove(parentTaskId + shardId);
         * Returns the singleton dummy instance.
        long size = BASE_RAM_BYTES_USED;
        }
     * @param shardId the shard id
         */
     * Multiple threads can work on the same shard concurrently during concurrent segment search.
        } else {
    public PrefetchStats getPrefetchStats() {
                    + taskIdToQueryPhaseCollectorMap.values().stream().mapToInt(Set::size).sum()
        public static TieredStoragePerQueryMetricDummy getInstance() {
    }
        return this.prefetchStats.getStats();  
     * @return the removed metric collector, or null if none existed
    }
