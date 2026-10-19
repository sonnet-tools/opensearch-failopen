        // first create the slice level breakdowns
                currentSliceNodeTime = 0L;
            // initialize each slice level breakdown
            final String minBreakdownTypeCount = MIN_PREFIX + timingTypeCountKey;
        Set<String> result = new HashSet<>();
            // create_weight time/count
    static final String SLICE_END_TIME_SUFFIX = "_slice_end_time";
        }
        // Each slice (or collector) is executed by single thread. So the list for a key will always be updated by a single thread only
                    currentSliceBreakdown.compute(
            // This will happen when each slice executes search leaf for its leaves and query is rewritten for the leaf being searched. It
            assert contexts.size() == 1 : "Unexpected size: "
                addStatsToMap(
        }
                    continue;
 *
    private final Map<Collector, List<LeafReaderContext>> sliceCollectorsToLeaves = new ConcurrentHashMap<>();
    /**
                        // specific breakdown type. We should skip the slice start/end time computation for any leaf with 0 invocations on a
                    currentSliceBreakdown.compute(
            }
    @Override
        long createWeightStartTime
        this.metricSuppliers = metricSuppliers;
        );
            final String timingTypeKey = timingType.toString();
                        (key, value) -> (value == null) ? sliceLeafMetricValue : value + sliceLeafMetricValue
                // compute total time for each timing type at slice level using sliceEndTime and sliceStartTime
                        timingTypeSliceStartTimeKey,
                    final long sliceLeafTimingTypeStartTime = currentSliceLeafBreakdownMap.get(timingTypeStartKey);
    }
                    avgBreakdownTypeCount,
            // for all other timing types, we will compute min/max/avg/total across slices
        }
                        + "] or end time ["
            final String sliceEndTimeForTimingType = metric + SLICE_END_TIME_SUFFIX;
        return contexts;
            long sliceMaxEndTime = Long.MIN_VALUE;
        return queryNodeTime;
    }
                        0L
    Map<Object, AbstractProfileBreakdown> getContexts() {
                        // context then it will return null scorer. Then for 2nd clause weight as well no scorer will be created for this
            long queryTimingTypeCount = 0L;
                    // query start/end time for a TimingType is min/max of start/end time across slices for that TimingType
        return result;
                    currentSliceBreakdown.put(timingTypeSliceEndTimeKey, 0L);
                    }
        avgSliceNodeTime = totalSliceNodeTime / sliceCollectorsToLeaves.size();
        for (String metric : nonTimingMetrics) {
                // compute max/min/avg TimingType time across slices
    @Override
 * A record of timings for the various operations that may happen during query execution.
     * default breakdown map.
            final String minBreakdownTypeTime = MIN_PREFIX + timingType;
            minSliceNodeTime = 0L;
                final String timingTypeCountKey = timingType + TIMING_TYPE_COUNT_SUFFIX;
     * @return map of collector (or slice) to breakdown map
                        timingTypeSliceEndTimeKey,
                }
            final String maxBreakdownTypeTime = MAX_PREFIX + timingType;
            // for all other timing types, we will compute min/max/avg/total across slices
     */
     * Computes the query level breakdownMap using the breakdown maps of all the slices. In query level breakdown map, it has the
            // creates a new weight and breakdown map for each rewritten query. This new breakdown map captures the timing information for
                concurrentQueryBreakdownMap.put(timingTypeCountKey, 1L);
 * scoring, etc). The class supports profiling the concurrent search over segments.
    static final String MIN_PREFIX = "min_";
            queryBreakdownMap.compute(avgBreakdownTypeTime, (key, value) -> (value == null) ? 0L : value / sliceLevelBreakdowns.size());
        queryNodeTime = queryEndTime - createWeightStartTime;
                if (timingType.equals(QueryTimingType.CREATE_WEIGHT.toString())) {
        for (String metric : timingMetrics) {
                    continue;
        long createWeightTime,
                        + "] while computing the slice level timing profile breakdowns"
    public long toNodeTime() {
                        // Other than early termination, it can also happen in other cases. For example: there is a must boolean query
        // the create weight time is computed at the query level and is called only once per query
                        // In case like early termination, the sliceCollectorToLeave association will be added for a
            queryBreakdownMap.put(metric, totalBreakdownValue);
    static final String SLICE_START_TIME_SUFFIX = "_slice_start_time";
                    );
    }
            concurrentQueryBreakdownMap.put(minBreakdownTypeCount, 0L);
    /**
                continue;
        for (QueryTimingType timingType : QueryTimingType.values()) {
    long getMaxSliceNodeTime() {
            for (Map.Entry<Collector, Map<String, Long>> sliceBreakdown : sliceLevelBreakdowns.entrySet()) {
        Set<String> result = new HashSet<>();
            AbstractProfileBreakdown breakdown = contexts.values().iterator().next();
import org.apache.lucene.index.LeafReaderContext;
     * @return default breakdown map for concurrent query which includes the create weight time and all other timing type stats in the
                continue;
import org.apache.lucene.search.Collector;
        this.nonTimingMetrics = getNonTimingMetrics();
        final Map<Collector, Map<String, Long>> sliceLevelBreakdowns = new HashMap<>();
                }
                    );
     */
            queryBreakdownMap.compute(avgBreakdownTypeTime, (key, value) -> (value == null) ? 0L : value / sliceLevelBreakdowns.size());
            final Collector sliceCollector = slice.getKey();
                    currentSliceBreakdown.compute(
                // timingTypeSliceEndTimeKey in the slice level breakdowns.
    long getAvgSliceNodeTime() {
/*
            final String maxBreakdownTypeCount = MAX_PREFIX + timingTypeCountKey;
                        + queryTimingTypeEndTime
    private final Collection<Supplier<ProfileMetric>> metricSuppliers;
import java.util.Collection;
            minSliceNodeTime = 0L;
    // used by tests
            concurrentQueryBreakdownMap.put(avgBreakdownTypeTime, 0L);
        for (Map.Entry<Collector, List<LeafReaderContext>> slice : sliceCollectorsToLeaves.entrySet()) {
            queryBreakdownMap.put(QueryTimingType.CREATE_WEIGHT + TIMING_TYPE_COUNT_SUFFIX, 1L);
    private Set<String> getNonTimingMetrics() {
                // for each timing type compute maxSliceEndTime and minSliceStartTime. Also add the counts of timing type to
            minSliceNodeTime = Math.min(minSliceNodeTime, currentSliceNodeTime);
        if (queryEndTime == Long.MIN_VALUE) {
    }
                result.add(entry.getKey());
            final String timingTypeCountKey = metric + TIMING_TYPE_COUNT_SUFFIX;
    // represents slice to leaves mapping as for each slice a unique collector instance is created
            long queryTimingTypeStartTime = Long.MAX_VALUE;
                long sliceBreakdownValue = sliceBreakdown.getValue().getOrDefault(metric, 0L);
        return sliceLevelBreakdowns;
            avgSliceNodeTime = 0L;
    ) {
            }
                        + "] computed across slices for profile results"
                        //
                addStatsToMap(queryBreakdownMap, maxBreakdownTypeTime, minBreakdownTypeTime, avgBreakdownTypeTime, sliceBreakdownTypeTime);
            QueryTimingType.CREATE_WEIGHT + TIMING_TYPE_START_TIME_SUFFIX
    public void associateCollectorToLeaves(Collector collector, LeafReaderContext leaf) {
            queryBreakdownMap.compute(avgBreakdownTypeCount, (key, value) -> (value == null) ? 0L : value / sliceLevelBreakdowns.size());
    public Map<String, Long> toBreakdownMap() {
                }
            if (sliceMinStartTime == Long.MAX_VALUE && sliceMaxEndTime == Long.MIN_VALUE) {
     *
        queryBreakdownMap.compute(maxKey, (key, value) -> (value == null) ? sliceValue : Math.max(sliceValue, value));
     * Computes the slice level breakdownMap. It uses sliceCollectorsToLeaves to figure out all the leaves or segments part of a slice.
                // only modify the start/end time of the TimingType if the slice used the timer
                throw new OpenSearchException(
            }
        final Map<String, Long> topLevelBreakdownMapWithWeightTime = super.toBreakdownMap();
        return avgSliceNodeTime;
        return result;
                        // This is because before updating the contexts map, the query hits earlyTerminationException.
                result.add(entry.getKey());
            final String minBreakdownTypeTime = MIN_PREFIX + metric;
                    currentSliceBreakdown.compute(
            // total time at query level
            queryBreakdownMap.put(timingTypeCountKey, queryTimingTypeCount);
    // keep track of all breakdown timings per segment. package-private for testing
                    final Map<String, Long> currentSliceLeafBreakdownMap = contexts.get(sliceLeaf).toBreakdownMap();
                    // compute the sliceEndTime for timingType using max of endTime across slice leaves
                    );
        final long createWeightTime = topLevelBreakdownMapWithWeightTime.get(QueryTimingType.CREATE_WEIGHT.toString());
                for (LeafReaderContext sliceLeaf : slice.getValue()) {
            final String minBreakdownTypeCount = MIN_PREFIX + timingTypeCountKey;
            final String maxBreakdownTypeCount = MAX_PREFIX + timingTypeCountKey;
        queryBreakdownMap.compute(avgKey, (key, value) -> (value == null) ? sliceValue : (value + sliceValue));
            final String sliceStartTimeForTimingType = metric + SLICE_START_TIME_SUFFIX;
public final class ConcurrentQueryProfileBreakdown extends ContextualProfileBreakdown {
import java.util.function.Supplier;
                sliceMinStartTime = Math.min(sliceMinStartTime, currentSliceStartTime);
            // add time related stats
}
        return contexts.computeIfAbsent(context, ctx -> new QueryProfileBreakdown(metricSuppliers));
            final String maxBreakdownTypeTime = MAX_PREFIX + metric;
    }
            if (entry.getValue() instanceof org.opensearch.search.profile.Timer) {
    }
                        // on leaf A and leaf C. This is because leaf B has a start time of zero.
            final String timingTypeCountKey = timingType + TIMING_TYPE_COUNT_SUFFIX;
                final String timingTypeStartKey = timingType + TIMING_TYPE_START_TIME_SUFFIX;
            if (metric.equals(QueryTimingType.CREATE_WEIGHT.toString())) {
    private long queryNodeTime = Long.MIN_VALUE;
    private Map<String, Long> buildDefaultQueryBreakdownMap(long createWeightTime) {
                if (sliceBreakdownTypeCount > 0L) {
                + " of leaves breakdown in ConcurrentQueryProfileBreakdown of rewritten query for a leaf.";
            concurrentQueryBreakdownMap.put(timingTypeCountKey, 0L);
            for (String metric : nonTimingMetrics) {
                    maxBreakdownTypeCount,
                        + "] start ["
            long currentSliceNodeTime;
     * @param createWeightTime      time for create weight
        final long createWeightStartTime = topLevelBreakdownMapWithWeightTime.get(
                        // leaf context (as it is a must query). Due to this it will end up missing the leaf context in the contexts map
                    // The timer for the current timing type never starts, so we continue here
import java.util.HashSet;
            Map<String, Long> queryBreakdownMap = new TreeMap<>(breakdown.toBreakdownMap());
        if (profile != null) {
import org.opensearch.search.profile.AbstractProfileBreakdown;
            queryEndTime = Math.max(queryEndTime, queryTimingTypeEndTime);
            } else {
                + contexts.size()
            return queryBreakdownMap;
        long totalSliceNodeTime = 0L;
     * end time with min of slice start time for that type. Count for each breakdown type at query level is sum of count of that type
                currentSliceNodeTime = sliceMaxEndTime - sliceMinStartTime;
            maxSliceNodeTime = Math.max(maxSliceNodeTime, currentSliceNodeTime);
                    if (!contexts.containsKey(sliceLeaf)) {
                    queryTimingTypeStartTime = Math.min(
    }
                        + sliceMaxEndTime
    @Override
            totalSliceNodeTime += currentSliceNodeTime;
        return queryBreakdownMap;
 * @opensearch.internal
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
                // compute total count at slice level
                        (key, value) -> (value == null) ? sliceLeafTimingTypeEndTime : Math.max(value, sliceLeafTimingTypeEndTime)
                    currentSliceBreakdown.getOrDefault(timingTypeSliceEndTimeKey, 0L) - currentSliceBreakdown.getOrDefault(
            queryNodeTime = createWeightTime;
            return profile;
    private final Set<String> nonTimingMetrics;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
     * @param createWeightTime time for creating weight
            // max slice end time across all timing types
        }
                        // To handle such case, we will ignore the leaf that is not present.
    }
        queryBreakdownMap.compute(minKey, (key, value) -> (value == null) ? sliceValue : Math.min(sliceValue, value));
    private final Set<String> timingMetrics;
                        // for second clause weight.
        queryBreakdownMap.put(QueryTimingType.CREATE_WEIGHT.toString(), createWeightTime);
                    // compute the sliceStartTime for timingType using min of startTime across slice leaves
            // compute query end time using max of query end time across all timing types
                    queryBreakdownMap,
                        continue;
                    queryTimingTypeEndTime = Math.max(
                    final Map<String, Long> currentSliceLeafBreakdownMap = contexts.get(sliceLeaf).toBreakdownMap();
    private Set<String> getTimingMetrics() {
            final String avgBreakdownTypeTime = AVG_PREFIX + timingType;
            final String avgBreakdownTypeCount = AVG_PREFIX + timingTypeCountKey;
                }
                        // timing type, as 0 does not represent an actual timing.
    private long maxSliceNodeTime = Long.MIN_VALUE;
            queryNodeTime = breakdown.toNodeTime() + createWeightTime;
                        // leaf, but the leaf level breakdown will not be created in the contexts map.
                // compute sliceMaxEndTime as max of sliceEndTime across all timing types
            final String avgBreakdownTypeCount = AVG_PREFIX + timingTypeCountKey;
            // compute max/min slice times
    /**
        }
                        timingTypeCountKey,
 * The OpenSearch Contributors require contributions made to
        final AbstractProfileBreakdown profile = contexts.get(context);
     */
     * Then use the breakdown timing stats for each of these leaves to calculate the breakdown stats at slice level.
                    "Unexpected value of sliceMinStartTime ["
        return concurrentQueryBreakdownMap;
                final String timingTypeSliceEndTimeKey = timingType + SLICE_END_TIME_SUFFIX;
                        + metric
            long queryTimingTypeEndTime = Long.MIN_VALUE;
            for (String timingType : timingMetrics) {
package org.opensearch.search.profile.query;
                    sliceBreakdownTypeCount
     * @param createWeightStartTime start time for create weight
                currentSliceBreakdown.put(
            }
                );
        return buildQueryBreakdownMap(sliceLevelBreakdowns, createWeightTime, createWeightStartTime);
            concurrentQueryBreakdownMap.put(maxBreakdownTypeCount, 0L);
import org.opensearch.OpenSearchException;
import java.util.List;
                        queryTimingTypeStartTime,
                    "Unexpected timing type ["
            final String minBreakdownTypeTime = MIN_PREFIX + metric;
    @Override
            long totalBreakdownValue = 0L;
                concurrentQueryBreakdownMap.put(timingTypeKey, createWeightTime);
                    queryTimingTypeCount += sliceBreakdownTypeCount;
        if (contexts.isEmpty()) {
                        + "] or sliceMaxEndTime ["
                        // consider a slice with three leaves: leaf A with a score count of 5, leaf B with a score count of 0,
            }
                    if (sliceLeafTimingTypeCount == 0L) {
                    );
        }
                    timingType,
                sliceMaxEndTime = Math.max(sliceMaxEndTime, currentSliceBreakdown.getOrDefault(timingTypeSliceEndTimeKey, Long.MIN_VALUE));
            final String maxBreakdownTypeTime = MAX_PREFIX + metric;
                    )
    }
        this.timingMetrics = getTimingMetrics();
        sliceCollectorsToLeaves.computeIfAbsent(collector, k -> new ArrayList<>()).add(leaf);
            queryBreakdownMap.put(metric, (queryTimingTypeCount > 0L) ? queryTimingTypeEndTime - queryTimingTypeStartTime : 0L);
            // currentSliceNodeTime does not include the create weight time, as that is computed in non-concurrent part
    Map<Collector, List<LeafReaderContext>> getSliceCollectorsToLeaves() {
        }
     *
                long currentSliceStartTime = currentSliceBreakdown.getOrDefault(timingTypeSliceStartTimeKey, Long.MAX_VALUE);
            if (timingType.equals(QueryTimingType.CREATE_WEIGHT)) {
     * across slices. Other than these, there are max/min/avg stats across slices for each breakdown type
                        // with 2 boolean clauses. While creating scorer for first clause if no docs are found for the field in a leaf
 */
                        (key, value) -> (value == null) ? sliceLeafTimingTypeCount : value + sliceLeafTimingTypeCount
    public void associateCollectorsToLeaves(Map<Collector, List<LeafReaderContext>> collectorsToLeaves) {
import static org.opensearch.search.profile.Timer.TIMING_TYPE_START_TIME_SUFFIX;
     * @param sliceLevelBreakdowns  breakdown map for all the slices
                // compute max/min/avg TimingType count across slices
            if (!(entry.getValue() instanceof Timer)) {
        return minSliceNodeTime;
        for (Map.Entry<String, ProfileMetric> entry : metrics.entrySet()) {
    public AbstractProfileBreakdown context(Object context) {
            }
        Map<Collector, Map<String, Long>> sliceLevelBreakdowns,
            maxSliceNodeTime = 0L;
    public Map<String, Long> buildQueryBreakdownMap(
import java.util.Collections;
import org.opensearch.search.profile.ContextualProfileBreakdown;
import java.util.Map;
                // compute max/min/avg TimingType time across slices
 * A node's time may be composed of several internal attributes (rewriting, weighting,
            } else if (sliceMinStartTime == Long.MAX_VALUE || sliceMaxEndTime == Long.MIN_VALUE) {
            final String avgBreakdownTypeTime = AVG_PREFIX + metric;
            }
            // If there are no leaf contexts, then return the default concurrent query level breakdown, which will include the
    static final String MAX_PREFIX = "max_";
     * @return breakdown map for entire query
                    final long sliceLeafTimingTypeEndTime = sliceLeafTimingTypeStartTime + currentSliceLeafBreakdownMap.get(timingType);
                        // and leaf C with a score count of 4. In this situation, we only compute the timing type slice start/end time based
                        // In case where a slice with multiple leaves, it is possible that any one of the leaves has 0 invocations for a
        // See please https://bugs.openjdk.java.net/browse/JDK-8161372
                        + queryTimingTypeStartTime
                        sliceBreakdown.getValue().getOrDefault(sliceEndTimeForTimingType, Long.MIN_VALUE)
            concurrentQueryBreakdownMap.put(avgBreakdownTypeCount, 0L);
                // to the default 0L. This is because buildQueryBreakdownMap expects timingTypeSliceStartTimeKey and
    }
    Map<Collector, Map<String, Long>> buildSliceLevelBreakdown() {
                        + sliceMinStartTime
                totalBreakdownValue += sliceBreakdownValue;
    static final String AVG_PREFIX = "avg_";
            queryBreakdownMap.put(QueryTimingType.CREATE_WEIGHT.toString(), createWeightTime);
        final Map<Collector, Map<String, Long>> sliceLevelBreakdowns = buildSliceLevelBreakdown();
        final Map<String, Long> queryBreakdownMap = new TreeMap<>();
                throw new OpenSearchException(
                }
                );
            concurrentQueryBreakdownMap.put(minBreakdownTypeTime, 0L);
    @Override
                    minBreakdownTypeCount,
            }
                if (currentSliceStartTime == 0L) {
            final String avgBreakdownTypeTime = AVG_PREFIX + metric;
import static org.opensearch.search.profile.Timer.TIMING_TYPE_COUNT_SUFFIX;
        return Collections.unmodifiableMap(sliceCollectorsToLeaves);
                        metric,
        } else if (sliceCollectorsToLeaves.isEmpty()) {
import org.opensearch.search.profile.Timer;
import java.util.ArrayList;
            return buildDefaultQueryBreakdownMap(createWeightTime);
                    final long sliceLeafTimingTypeCount = currentSliceLeafBreakdownMap.get(timingTypeCountKey);
                long sliceBreakdownTypeCount = sliceBreakdown.getValue().getOrDefault(timingTypeCountKey, 0L);
            // in search leaf path which doesn't have collector. Also, this is not needed since this breakdown is per leaf and there is no
        long queryEndTime = Long.MIN_VALUE;
     * time/count stats for each breakdown type. Total time per breakdown type at query level is computed by subtracting the max of slice
import org.opensearch.search.profile.ProfileMetric;
                        continue;
            }
                }
    }
     * breakdown has default value of 0. For concurrent search case, the max/min/avg stats for each timing type will also be 0 in this
                for (LeafReaderContext sliceLeaf : slice.getValue()) {
 *
                    // do nothing for create weight as that is query level time and not slice level
    }
            }
            long sliceMinStartTime = Long.MAX_VALUE;
                    }
                        (key, value) -> (value == null) ? sliceLeafTimingTypeStartTime : Math.min(value, sliceLeafTimingTypeStartTime)
                        timingTypeSliceStartTimeKey,
                if (currentSliceBreakdown.get(timingTypeCountKey) != null && currentSliceBreakdown.get(timingTypeCountKey) == 0L) {
    private long minSliceNodeTime = Long.MAX_VALUE;
import java.util.HashMap;
        sliceCollectorsToLeaves.putAll(collectorsToLeaves);
            avgSliceNodeTime = 0L;
    private void addStatsToMap(Map<String, Long> queryBreakdownMap, String maxKey, String minKey, String avgKey, long sliceValue) {
                    if (!contexts.containsKey(sliceLeaf)) {
            maxSliceNodeTime = 0L;
    public ConcurrentQueryProfileBreakdown(Collection<Supplier<ProfileMetric>> metricSuppliers) {
                );
                addStatsToMap(queryBreakdownMap, maxBreakdownTypeTime, minBreakdownTypeTime, avgBreakdownTypeTime, sliceBreakdownValue);
                        // For example, a slice has 0 invocations for a breakdown type from its leading leaves. Another example, let's
        final Map<String, Long> concurrentQueryBreakdownMap = new TreeMap<>();
    private long avgSliceNodeTime = 0L;
    }
            final Map<String, Long> currentSliceBreakdown = sliceLevelBreakdowns.computeIfAbsent(sliceCollector, k -> new HashMap<>());
        for (Map.Entry<String, ProfileMetric> entry : metrics.entrySet()) {
        queryBreakdownMap.put(QueryTimingType.CREATE_WEIGHT + TIMING_TYPE_COUNT_SUFFIX, 1L);
import java.util.Set;
                final String timingTypeSliceStartTimeKey = timingType + SLICE_START_TIME_SUFFIX;
                long sliceBreakdownTypeTime = sliceBreakdown.getValue().getOrDefault(metric, 0L);
            concurrentQueryBreakdownMap.put(maxBreakdownTypeTime, 0L);
        super(metricSuppliers);
 */
    }
                        queryTimingTypeEndTime,
                        continue;
                    );
            for (Map.Entry<Collector, Map<String, Long>> sliceBreakdown : sliceLevelBreakdowns.entrySet()) {
            // concurrency involved.
                    // get the count for current leaf timing type
            throw new OpenSearchException("Unexpected error while computing the query end time across slices in profile result");
                // Only when we've checked all leaves in a slice and still find no invocations, then we should set the slice start/end time
                // create weight time is computed at query level and is called only once per query
            if (queryTimingTypeCount > 0L && (queryTimingTypeStartTime == Long.MAX_VALUE || queryTimingTypeEndTime == Long.MIN_VALUE)) {
            // add count related stats
        }
                    );
    }
 * SPDX-License-Identifier: Apache-2.0
/**
                        sliceBreakdown.getValue().getOrDefault(sliceStartTimeForTimingType, Long.MAX_VALUE)
    private final Map<Object, AbstractProfileBreakdown> contexts = new ConcurrentHashMap<>();
                );
                    }
                    currentSliceBreakdown.put(timingTypeSliceStartTimeKey, 0L);
    }
    }
        return maxSliceNodeTime;
        }
    long getMinSliceNodeTime() {
            // the new rewritten query. The sliceCollectorsToLeaves is empty because this breakdown for rewritten query gets created later
            concurrentQueryBreakdownMap.put(timingTypeKey, 0L);
                    final long sliceLeafMetricValue = currentSliceLeafBreakdownMap.get(metric);
