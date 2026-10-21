            || taskIdToFetchPhaseCollectorMap.values().stream().mapToInt(Set::size).sum() >= MAX_PER_QUERY_COLLECTOR_SIZE) {
     * @return ram bytes usage
    }
    protected final ConcurrentMap<String, Set<TieredStoragePerQueryMetric>> taskIdToFetchPhaseCollectorMap = new ConcurrentHashMap<>();
    public TieredStoragePerQueryMetric getMetricCollector(final long threadId) {
                    (id, collectors) -> {
    public long ramBytesUsed() {
            return "DummyShardId";
     */
            // Multiple threads can be working on the same shard at the same time though, so below needs to be atomic
     * @return the prefetch stats
                        Set<TieredStoragePerQueryMetric> newCollectors = (collectors == null) ? new HashSet<>() : collectors;
/*
    private static final Logger logger = LogManager.getLogger(TieredStorageQueryMetricService.class);
        }
                        return newCollectors;
    protected final ConcurrentMap<Long, TieredStoragePerQueryMetric> metricCollectors = new ConcurrentHashMap<>();
     *
         * @return the prefetch stats
                    }
 */
    }
        }
            // Slice Execution hooks will not be triggered in the case of a cache hit, however query phase hooks will always be triggered
     * @return the metric collector for the thread
        // For safety, use getOrDefault here
            );
    private static final TieredStorageQueryMetricService INSTANCE = new TieredStorageQueryMetricService();
     * Records a doc values prefetch event.
        if (collectors == null) {
            prefetchStats.storedFieldsPrefetchSuccess.inc();
            } else {
        final CounterMetric docValuesPrefetchSuccess = new CounterMetric();
                    + taskIdToQueryPhaseCollectorMap.values().stream().mapToInt(Set::size).sum()
        return isQueryPhase ? taskIdToQueryPhaseCollectorMap : taskIdToFetchPhaseCollectorMap;
     * Returns estimated memory consumption of the metric service.
    }
        // Do not update taskIdToCollectorMap here as the query may not be complete
            return new PrefetchStats(
     * @param metricCollector the metric collector
     */
        long size = BASE_RAM_BYTES_USED;
     * Multiple threads can work on the same shard concurrently during concurrent segment search.
    /**
        final CounterMetric storedFieldsPrefetchFailure = new CounterMetric();
    }
                    + ", fetchPhaseCollectors: "
     * Returns the per-query metric collector for the given thread.
    }
 * compatible open source license.
                        Set<TieredStoragePerQueryMetric> newCollectors = (collectors == null) ? new HashSet<>() : collectors;
     */
    private final PrefetchStatsHolder prefetchStats = new PrefetchStatsHolder();
        }
        }
         */
 * Singleton service for maintaining per-query metric collectors across threads.
    private static final long BASE_RAM_BYTES_USED = RamUsageEstimator.shallowSizeOfInstance(TieredStorageQueryMetricService.class);
        return this.prefetchStats.getStats();
     * No-op dummy metric collector to avoid null checks throughout the codebase.
public class TieredStorageQueryMetricService {
    private TieredStorageQueryMetricService() {}
     */
     * Returns the metric collectors map for testing.
import java.util.concurrent.ConcurrentHashMap;
    Map<String, Set<TieredStoragePerQueryMetric>> getTaskIdToCollectorMap(boolean isQueryPhase) {
     * @opensearch.experimental
     * Returns the current prefetch stats.
        private TieredStoragePerQueryMetricDummy() {}
    /**
        if (success) {
         */
        final Set<TieredStoragePerQueryMetric> collectors;
                    + taskIdToFetchPhaseCollectorMap.values().stream().mapToInt(Set::size).sum()
     * @return the task-to-collector map
        /** Counter for failed doc values prefetches. */
     * @return the removed metric collector, or null if none existed
    }
    /**
                );
    public PrefetchStats getPrefetchStats() {
    /**
                    metricCollector.getParentTaskId() + metricCollector.getShardId(),
     */
    // TODO has to emit as part of node stats
        // Therefore, we use taskIdToCollectorMap to estimate ram usage.
     * @param success true if the prefetch was successful
            // The same threadId will not be used concurrently, so below is safe
    }
        } else {
    /**
        if (success) {
        private static final TieredStoragePerQueryMetricDummy INSTANCE = new TieredStoragePerQueryMetricDummy();
    private static final int MAX_PER_QUERY_COLLECTOR_SIZE = 1000;
    public static TieredStorageQueryMetricService getInstance() {
 *
        for (Set<TieredStoragePerQueryMetric> collectors : taskIdToFetchPhaseCollectorMap.values()) {
        } else {
        // Each collector in metricCollectors will also be referenced in taskIdToCollectorMap, however the opposite is not true.
        /** Counter for successful doc values prefetches. */
                    + ". Skipping. Current sizes - metricCollectors: "
            logger.error(
        public String getParentTaskId() {
                    + metricCollectors.size()
    /**
                        newCollectors.add(metricCollector);
import org.apache.logging.log4j.LogManager;
    /**
        }
     * @param parentTaskId the parent task id
 * Provides thread-safe access to metric collectors during query and fetch phases.
 * this file be licensed under the Apache-2.0 license or a
        private static final long BASE_RAM_BYTES_USED = RamUsageEstimator.shallowSizeOfInstance(TieredStoragePerQueryMetricDummy.class);
        }
     */
    /**
                    + MAX_PER_QUERY_COLLECTOR_SIZE
     * @param shardId the shard id
        } else {
 */
            metricCollectors.put(threadId, metricCollector);
     */
         * Returns the current prefetch stats snapshot.
     * Returns the task-to-collector map for testing.
    /**
                taskIdToFetchPhaseCollectorMap.compute(
        final CounterMetric docValuesPrefetchFailure = new CounterMetric();
     */
        public String getShardId() {
        @Override
        @Override
        // TODO if possible add thread id in collector
    }
                    }
     * @param threadId the thread id
    public TieredStoragePerQueryMetric removeMetricCollector(final long threadId) {
        }
 * @opensearch.experimental
                    + ", queryPhaseCollectors: "
            return "DummyParentTaskId";
    }
import java.util.Map;
/**
     * Map of task id + shard id to set of collectors for query phase.
     * number of collectors to prevent excessive memory consumption.
        }
     */
    /**
    static class TieredStoragePerQueryMetricDummy implements TieredStoragePerQueryMetric {
                );
    /**
            size += RamUsageEstimator.sizeOf(collectors.toArray(new TieredStoragePerQueryMetric[0]));
        for (Set<TieredStoragePerQueryMetric> collectors : taskIdToQueryPhaseCollectorMap.values()) {
            prefetchStats.docValuesPrefetchSuccess.inc();
     * @return the metric collectors map
     * @opensearch.experimental
     * @return the set of removed collectors
     * @param threadId the thread id
     * Records a stored fields prefetch event.
            || taskIdToQueryPhaseCollectorMap.values().stream().mapToInt(Set::size).sum() >= MAX_PER_QUERY_COLLECTOR_SIZE
                docValuesPrefetchFailure.count()
    Map<Long, TieredStoragePerQueryMetric> getMetricCollectors() {
        if (metricCollectors.size() >= MAX_PER_QUERY_COLLECTOR_SIZE
        public static TieredStoragePerQueryMetricDummy getInstance() {
        public long ramBytesUsed() {
     * Map of thread ID to active collector. Only one collector is active per thread at a time.
     *
    }
                storedFieldsPrefetchSuccess.count(),
     * Returns the singleton instance.
        /** Counter for failed stored fields prefetches. */
     */
        }
         * @return the dummy instance
     * Removes all metric collectors for the given task and shard combination.
     * @param isQueryPhase true if this is for the query phase, false for fetch phase
    public Set<TieredStoragePerQueryMetric> removeMetricCollectors(String parentTaskId, String shardId, boolean isQueryPhase) {
import org.opensearch.common.metrics.CounterMetric;
}
         * Returns the singleton dummy instance.
    }
        return metricCollectors.getOrDefault(threadId, TieredStoragePerQueryMetricDummy.getInstance());
     */
        /**
 * The OpenSearch Contributors require contributions made to
            // Do nothing
import org.apache.lucene.util.RamUsageEstimator;
            collectors = taskIdToQueryPhaseCollectorMap.remove(parentTaskId + shardId);
    public void addMetricCollector(final long threadId, final TieredStoragePerQueryMetric metricCollector, boolean isQueryPhase) {
        public void recordEndTime() {}
                storedFieldsPrefetchFailure.count(),
            if (isQueryPhase) {
            collectors = taskIdToFetchPhaseCollectorMap.remove(parentTaskId + shardId);
                        return newCollectors;
        return INSTANCE;
        @Override
import org.apache.logging.log4j.Logger;
     * @param threadId the thread id
    public static final class PrefetchStatsHolder {
     */
        } else {
    /**
            );
     */
        // While this is not completely accurate, it serves as good approximation for tracking any memory leaks
            prefetchStats.docValuesPrefetchFailure.inc();
        public void recordReadAhead(String fileName, int blockId) {}
        }
        }
     * @param isQueryPhase true for query phase map, false for fetch phase
                    (id, collectors) -> {
        return metricCollectors;
    }
     */
        /**
        PrefetchStats getStats() {
        }
     */
    /**
            return BASE_RAM_BYTES_USED;
import java.util.concurrent.ConcurrentMap;
            return Collections.emptySet();
                docValuesPrefetchSuccess.count(),
 * SPDX-License-Identifier: Apache-2.0
 *
     * Map of task id + shard id to set of collectors for fetch phase.
import java.util.Collections;
                "Number of metric collectors already equals maximum size of "
     * @param isQueryPhase true for query phase collectors, false for fetch phase
    /**
import java.util.HashSet;
    /**
        return metricCollectors.remove(threadId);
            return INSTANCE;
     * Returns a no-op dummy collector if none exists.
        @Override
    }
     * Removes the metric collector for the given thread and records its end time.
        metricCollectors.getOrDefault(threadId, TieredStoragePerQueryMetricDummy.getInstance()).recordEndTime();
                taskIdToQueryPhaseCollectorMap.compute(
        @Override
        }
        @Override
        if (isQueryPhase) {
        final CounterMetric storedFieldsPrefetchSuccess = new CounterMetric();
        return size;
     */
        public void recordFileAccess(String blockFileName, boolean hit) {
    /**
     * @return the singleton instance
        return collectors;
            prefetchStats.storedFieldsPrefetchFailure.inc();
     * Holder for prefetch statistics counters.
    public void recordDocValuesPrefetch(boolean success) {
    public void recordStoredFieldsPrefetch(boolean success) {
            }
        public void recordPrefetch(String fileName, int blockId) {}
                    metricCollector.getParentTaskId() + metricCollector.getShardId(),
import java.util.Set;
        /** Counter for successful stored fields prefetches. */
     * Adds a metric collector for the given thread. Enforces a hard limit on the
        @Override
                        newCollectors.add(metricCollector);
     * @param success true if the prefetch was successful
package org.opensearch.storage.slowlogs;
            size += RamUsageEstimator.sizeOf(collectors.toArray(new TieredStoragePerQueryMetric[0]));
    protected final ConcurrentMap<String, Set<TieredStoragePerQueryMetric>> taskIdToQueryPhaseCollectorMap = new ConcurrentHashMap<>();
