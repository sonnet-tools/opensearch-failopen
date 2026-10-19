    private Map<String, Long> buildDefaultQueryBreakdownMap(long createWeightTime) {
                    );  
import java.util.List;
import java.util.HashMap;  
                    currentSliceBreakdown.getOrDefault(timingTypeSliceEndTimeKey, 0L) - currentSliceBreakdown.getOrDefault(
                        + "] or sliceMaxEndTime ["  
            minSliceNodeTime = 0L;  
            long currentSliceNodeTime;
                    // get the count for current leaf timing type
            final String avgBreakdownTypeTime = AVG_PREFIX + metric;
    }  
                    if (sliceLeafTimingTypeCount == 0L) {  
package org.opensearch.search.profile.query;
            return buildDefaultQueryBreakdownMap(createWeightTime);
    long getMinSliceNodeTime() {
     * Computes the slice level breakdownMap. It uses sliceCollectorsToLeaves to figure out all the leaves or segments part of a slice.  
            concurrentQueryBreakdownMap.put(maxBreakdownTypeCount, 0L);
            concurrentQueryBreakdownMap.put(maxBreakdownTypeTime, 0L);
    }
                        + "] start ["
        if (queryEndTime == Long.MIN_VALUE) {
    }
            // in search leaf path which doesn't have collector. Also, this is not needed since this breakdown is per leaf and there is no
            // If there are no leaf contexts, then return the default concurrent query level breakdown, which will include the
        // Each slice (or collector) is executed by single thread. So the list for a key will always be updated by a single thread only  
                // compute sliceMaxEndTime as max of sliceEndTime across all timing types
                throw new OpenSearchException(
    static final String SLICE_START_TIME_SUFFIX = "_slice_start_time";  
    /**
     * across slices. Other than these, there are max/min/avg stats across slices for each breakdown type
                );
            final String avgBreakdownTypeTime = AVG_PREFIX + timingType;
            // compute query end time using max of query end time across all timing types  
            final String sliceStartTimeForTimingType = metric + SLICE_START_TIME_SUFFIX;
            queryEndTime = Math.max(queryEndTime, queryTimingTypeEndTime);
     * @param createWeightStartTime start time for create weight
            }
    }
                sliceMaxEndTime = Math.max(sliceMaxEndTime, currentSliceBreakdown.getOrDefault(timingTypeSliceEndTimeKey, Long.MIN_VALUE));  
                        sliceBreakdown.getValue().getOrDefault(sliceEndTimeForTimingType, Long.MIN_VALUE)
    private final Collection<Supplier<ProfileMetric>> metricSuppliers;  
            long queryTimingTypeStartTime = Long.MAX_VALUE;  
                        // leaf context (as it is a must query). Due to this it will end up missing the leaf context in the contexts map  
    }  
        final AbstractProfileBreakdown profile = contexts.get(context);
    private final Set<String> nonTimingMetrics;
                // timingTypeSliceEndTimeKey in the slice level breakdowns.  
                result.add(entry.getKey());
            long totalBreakdownValue = 0L;
                    currentSliceBreakdown.compute(
     * @return map of collector (or slice) to breakdown map  
                        + "] computed across slices for profile results"
        for (Map.Entry<String, ProfileMetric> entry : metrics.entrySet()) {  
            Map<String, Long> queryBreakdownMap = new TreeMap<>(breakdown.toBreakdownMap());
            // for all other timing types, we will compute min/max/avg/total across slices  
            concurrentQueryBreakdownMap.put(timingTypeCountKey, 0L);  
                long sliceBreakdownTypeTime = sliceBreakdown.getValue().getOrDefault(metric, 0L);
        return queryNodeTime;
                final String timingTypeCountKey = timingType + TIMING_TYPE_COUNT_SUFFIX;  
import java.util.Set;
                        // leaf, but the leaf level breakdown will not be created in the contexts map.
            minSliceNodeTime = Math.min(minSliceNodeTime, currentSliceNodeTime);
        Set<String> result = new HashSet<>();
        for (Map.Entry<Collector, List<LeafReaderContext>> slice : sliceCollectorsToLeaves.entrySet()) {
            final Collector sliceCollector = slice.getKey();  
                // compute total count at slice level
                        0L  
            final String maxBreakdownTypeTime = MAX_PREFIX + metric;  
    public long toNodeTime() {  
                    "Unexpected value of sliceMinStartTime ["
                throw new OpenSearchException(  
        }  
                );  
    /**
    private long maxSliceNodeTime = Long.MIN_VALUE;
            for (String metric : nonTimingMetrics) {
            queryBreakdownMap.compute(avgBreakdownTypeTime, (key, value) -> (value == null) ? 0L : value / sliceLevelBreakdowns.size());
    private Set<String> getNonTimingMetrics() {
            avgSliceNodeTime = 0L;
                    queryTimingTypeStartTime = Math.min(
            if (timingType.equals(QueryTimingType.CREATE_WEIGHT)) {
        return concurrentQueryBreakdownMap;
                        (key, value) -> (value == null) ? sliceLeafMetricValue : value + sliceLeafMetricValue
        queryBreakdownMap.put(QueryTimingType.CREATE_WEIGHT.toString(), createWeightTime);  
                        // and leaf C with a score count of 4. In this situation, we only compute the timing type slice start/end time based  
    public ConcurrentQueryProfileBreakdown(Collection<Supplier<ProfileMetric>> metricSuppliers) {
            // the new rewritten query. The sliceCollectorsToLeaves is empty because this breakdown for rewritten query gets created later  
     * @param createWeightTime time for creating weight
            } else {
 *
            queryBreakdownMap.put(QueryTimingType.CREATE_WEIGHT + TIMING_TYPE_COUNT_SUFFIX, 1L);
            final String minBreakdownTypeTime = MIN_PREFIX + timingType;
                // compute max/min/avg TimingType count across slices  
        return Collections.unmodifiableMap(sliceCollectorsToLeaves);
                    avgBreakdownTypeCount,
                        + "] or end time ["  
 *
     * end time with min of slice start time for that type. Count for each breakdown type at query level is sum of count of that type  
                // compute max/min/avg TimingType time across slices  
                    final long sliceLeafMetricValue = currentSliceLeafBreakdownMap.get(metric);
            concurrentQueryBreakdownMap.put(minBreakdownTypeCount, 0L);
                    }  
import java.util.Collections;
     */
                        queryTimingTypeEndTime,
            final String avgBreakdownTypeTime = AVG_PREFIX + metric;  
     * @return default breakdown map for concurrent query which includes the create weight time and all other timing type stats in the  
                        metric,
                );
            final String minBreakdownTypeTime = MIN_PREFIX + metric;
                    );
    }
            if (!(entry.getValue() instanceof Timer)) {
        final long createWeightStartTime = topLevelBreakdownMapWithWeightTime.get(
            concurrentQueryBreakdownMap.put(minBreakdownTypeTime, 0L);  
        final Map<Collector, Map<String, Long>> sliceLevelBreakdowns = buildSliceLevelBreakdown();  
     *
                        // timing type, as 0 does not represent an actual timing.  
            }
                addStatsToMap(queryBreakdownMap, maxBreakdownTypeTime, minBreakdownTypeTime, avgBreakdownTypeTime, sliceBreakdownValue);
public final class ConcurrentQueryProfileBreakdown extends ContextualProfileBreakdown {
    }
                        + "] while computing the slice level timing profile breakdowns"
                sliceMinStartTime = Math.min(sliceMinStartTime, currentSliceStartTime);  
                }  
    public AbstractProfileBreakdown context(Object context) {  
                    // The timer for the current timing type never starts, so we continue here  
                    currentSliceBreakdown.put(timingTypeSliceStartTimeKey, 0L);
                        (key, value) -> (value == null) ? sliceLeafTimingTypeStartTime : Math.min(value, sliceLeafTimingTypeStartTime)  
        );
                        // context then it will return null scorer. Then for 2nd clause weight as well no scorer will be created for this
/*  
            }  
    // keep track of all breakdown timings per segment. package-private for testing  
                }
            avgSliceNodeTime = 0L;
            totalSliceNodeTime += currentSliceNodeTime;  
                        + sliceMinStartTime
            for (Map.Entry<Collector, Map<String, Long>> sliceBreakdown : sliceLevelBreakdowns.entrySet()) {
            final String avgBreakdownTypeCount = AVG_PREFIX + timingTypeCountKey;  
                        // for second clause weight.
import org.opensearch.search.profile.ProfileMetric;  
            long queryTimingTypeEndTime = Long.MIN_VALUE;
            final String minBreakdownTypeCount = MIN_PREFIX + timingTypeCountKey;
        sliceCollectorsToLeaves.putAll(collectorsToLeaves);  
                    maxBreakdownTypeCount,  
import org.opensearch.search.profile.ContextualProfileBreakdown;
                        timingTypeSliceStartTimeKey,
        queryNodeTime = queryEndTime - createWeightStartTime;
    }  
            }  
                final String timingTypeSliceStartTimeKey = timingType + SLICE_START_TIME_SUFFIX;
        queryBreakdownMap.compute(maxKey, (key, value) -> (value == null) ? sliceValue : Math.max(sliceValue, value));
        }  
                    // query start/end time for a TimingType is min/max of start/end time across slices for that TimingType
                }
        super(metricSuppliers);
            }  
                concurrentQueryBreakdownMap.put(timingTypeKey, createWeightTime);
     * Computes the query level breakdownMap using the breakdown maps of all the slices. In query level breakdown map, it has the
            queryBreakdownMap.put(metric, (queryTimingTypeCount > 0L) ? queryTimingTypeEndTime - queryTimingTypeStartTime : 0L);
            final String avgBreakdownTypeCount = AVG_PREFIX + timingTypeCountKey;
    }  
                if (currentSliceStartTime == 0L) {
        } else if (sliceCollectorsToLeaves.isEmpty()) {  
                    final Map<String, Long> currentSliceLeafBreakdownMap = contexts.get(sliceLeaf).toBreakdownMap();
                    queryBreakdownMap,
            final String maxBreakdownTypeTime = MAX_PREFIX + timingType;  
                    if (!contexts.containsKey(sliceLeaf)) {
        sliceCollectorsToLeaves.computeIfAbsent(collector, k -> new ArrayList<>()).add(leaf);
        this.metricSuppliers = metricSuppliers;  
    private void addStatsToMap(Map<String, Long> queryBreakdownMap, String maxKey, String minKey, String avgKey, long sliceValue) {  
     * @param createWeightTime      time for create weight
        final Map<String, Long> queryBreakdownMap = new TreeMap<>();
                        queryTimingTypeStartTime,
            queryBreakdownMap.put(metric, totalBreakdownValue);
        // first create the slice level breakdowns
                // compute total time for each timing type at slice level using sliceEndTime and sliceStartTime
                    // compute the sliceStartTime for timingType using min of startTime across slice leaves
     * @param sliceLevelBreakdowns  breakdown map for all the slices  
                    if (!contexts.containsKey(sliceLeaf)) {  
        return contexts;  
     */  
                    currentSliceBreakdown.compute(
    static final String SLICE_END_TIME_SUFFIX = "_slice_end_time";
    // represents slice to leaves mapping as for each slice a unique collector instance is created  
                totalBreakdownValue += sliceBreakdownValue;
            final String timingTypeCountKey = timingType + TIMING_TYPE_COUNT_SUFFIX;
            // This will happen when each slice executes search leaf for its leaves and query is rewritten for the leaf being searched. It
            queryBreakdownMap.put(QueryTimingType.CREATE_WEIGHT.toString(), createWeightTime);  
        }
        for (QueryTimingType timingType : QueryTimingType.values()) {  
                    final long sliceLeafTimingTypeEndTime = sliceLeafTimingTypeStartTime + currentSliceLeafBreakdownMap.get(timingType);
            // creates a new weight and breakdown map for each rewritten query. This new breakdown map captures the timing information for
    // used by tests
            concurrentQueryBreakdownMap.put(avgBreakdownTypeCount, 0L);  
    public void associateCollectorsToLeaves(Map<Collector, List<LeafReaderContext>> collectorsToLeaves) {
                        continue;
                        timingTypeCountKey,
                + contexts.size()
     * default breakdown map.
        }
        return result;
        return queryBreakdownMap;  
        for (String metric : timingMetrics) {
            final Map<String, Long> currentSliceBreakdown = sliceLevelBreakdowns.computeIfAbsent(sliceCollector, k -> new HashMap<>());
                        // consider a slice with three leaves: leaf A with a score count of 5, leaf B with a score count of 0,
            final String maxBreakdownTypeCount = MAX_PREFIX + timingTypeCountKey;
            // for all other timing types, we will compute min/max/avg/total across slices  
                    );
            }
            // initialize each slice level breakdown
                    timingType,  
    public Map<String, Long> toBreakdownMap() {  
                        + sliceMaxEndTime
            final String sliceEndTimeForTimingType = metric + SLICE_END_TIME_SUFFIX;
            throw new OpenSearchException("Unexpected error while computing the query end time across slices in profile result");  
            queryNodeTime = createWeightTime;
import org.opensearch.OpenSearchException;  
    @Override
                    );  
                    "Unexpected timing type ["
            AbstractProfileBreakdown breakdown = contexts.values().iterator().next();  
 * scoring, etc). The class supports profiling the concurrent search over segments.  
            if (sliceMinStartTime == Long.MAX_VALUE && sliceMaxEndTime == Long.MIN_VALUE) {  
                // create weight time is computed at query level and is called only once per query
                );  
            } else if (sliceMinStartTime == Long.MAX_VALUE || sliceMaxEndTime == Long.MIN_VALUE) {
        this.timingMetrics = getTimingMetrics();
                final String timingTypeSliceEndTimeKey = timingType + SLICE_END_TIME_SUFFIX;  
                    sliceBreakdownTypeCount  
                        + queryTimingTypeStartTime
    }  
        return avgSliceNodeTime;  
                result.add(entry.getKey());
            QueryTimingType.CREATE_WEIGHT + TIMING_TYPE_START_TIME_SUFFIX  
                        continue;
            // add count related stats
                    queryTimingTypeCount += sliceBreakdownTypeCount;
        long createWeightStartTime
    }
 * this file be licensed under the Apache-2.0 license or a
    long getAvgSliceNodeTime() {
import org.opensearch.search.profile.AbstractProfileBreakdown;
                // Only when we've checked all leaves in a slice and still find no invocations, then we should set the slice start/end time
        final Map<Collector, Map<String, Long>> sliceLevelBreakdowns = new HashMap<>();  
                if (currentSliceBreakdown.get(timingTypeCountKey) != null && currentSliceBreakdown.get(timingTypeCountKey) == 0L) {
        return result;
            // add time related stats  
            if (entry.getValue() instanceof org.opensearch.search.profile.Timer) {  
import static org.opensearch.search.profile.Timer.TIMING_TYPE_COUNT_SUFFIX;  
                for (LeafReaderContext sliceLeaf : slice.getValue()) {  
            }
     * Then use the breakdown timing stats for each of these leaves to calculate the breakdown stats at slice level.
            return profile;
                        // specific breakdown type. We should skip the slice start/end time computation for any leaf with 0 invocations on a
            concurrentQueryBreakdownMap.put(timingTypeKey, 0L);
    private long avgSliceNodeTime = 0L;
            }  
                    );
                        sliceBreakdown.getValue().getOrDefault(sliceStartTimeForTimingType, Long.MAX_VALUE)  
                        + queryTimingTypeEndTime
import java.util.function.Supplier;
        queryBreakdownMap.compute(avgKey, (key, value) -> (value == null) ? sliceValue : (value + sliceValue));  
    private final Map<Collector, List<LeafReaderContext>> sliceCollectorsToLeaves = new ConcurrentHashMap<>();
        }
    }
        return maxSliceNodeTime;
            final String timingTypeCountKey = metric + TIMING_TYPE_COUNT_SUFFIX;  
            }
                    }  
                    continue;
 * SPDX-License-Identifier: Apache-2.0
                    continue;
        return contexts.computeIfAbsent(context, ctx -> new QueryProfileBreakdown(metricSuppliers));
            queryBreakdownMap.compute(avgBreakdownTypeTime, (key, value) -> (value == null) ? 0L : value / sliceLevelBreakdowns.size());
        long totalSliceNodeTime = 0L;
                        // For example, a slice has 0 invocations for a breakdown type from its leading leaves. Another example, let's
                }
/**  
    public Map<String, Long> buildQueryBreakdownMap(
                    // do nothing for create weight as that is query level time and not slice level  
            assert contexts.size() == 1 : "Unexpected size: "  
                        (key, value) -> (value == null) ? sliceLeafTimingTypeCount : value + sliceLeafTimingTypeCount  
        long queryEndTime = Long.MIN_VALUE;
                    final long sliceLeafTimingTypeStartTime = currentSliceLeafBreakdownMap.get(timingTypeStartKey);  
                long sliceBreakdownTypeCount = sliceBreakdown.getValue().getOrDefault(timingTypeCountKey, 0L);  
            // create_weight time/count  
    private final Map<Object, AbstractProfileBreakdown> contexts = new ConcurrentHashMap<>();
                        //
        // See please https://bugs.openjdk.java.net/browse/JDK-8161372
        long createWeightTime,
            }
                    queryTimingTypeEndTime = Math.max(  
    static final String MAX_PREFIX = "max_";
                }
        avgSliceNodeTime = totalSliceNodeTime / sliceCollectorsToLeaves.size();
            // compute max/min slice times
            queryBreakdownMap.compute(avgBreakdownTypeCount, (key, value) -> (value == null) ? 0L : value / sliceLevelBreakdowns.size());
                    // compute the sliceEndTime for timingType using max of endTime across slice leaves  
 */  
                final String timingTypeStartKey = timingType + TIMING_TYPE_START_TIME_SUFFIX;
}  
        queryBreakdownMap.compute(minKey, (key, value) -> (value == null) ? sliceValue : Math.min(sliceValue, value));
import java.util.HashSet;
                + " of leaves breakdown in ConcurrentQueryProfileBreakdown of rewritten query for a leaf.";
                // only modify the start/end time of the TimingType if the slice used the timer  
        final long createWeightTime = topLevelBreakdownMapWithWeightTime.get(QueryTimingType.CREATE_WEIGHT.toString());
        }  
 * A node's time may be composed of several internal attributes (rewriting, weighting,
                    currentSliceBreakdown.compute(  
     *
            maxSliceNodeTime = 0L;
                }  
        Map<Collector, Map<String, Long>> sliceLevelBreakdowns,  
            for (String timingType : timingMetrics) {
    @Override
                    currentSliceBreakdown.put(timingTypeSliceEndTimeKey, 0L);  
        if (profile != null) {
    static final String AVG_PREFIX = "avg_";  
                        // In case like early termination, the sliceCollectorToLeave association will be added for a
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.search.Collector;
                currentSliceNodeTime = sliceMaxEndTime - sliceMinStartTime;
        }
            maxSliceNodeTime = 0L;
            queryBreakdownMap.put(timingTypeCountKey, queryTimingTypeCount);  
    }
                currentSliceBreakdown.put(
        final Map<String, Long> topLevelBreakdownMapWithWeightTime = super.toBreakdownMap();
                if (sliceBreakdownTypeCount > 0L) {
        if (contexts.isEmpty()) {
                concurrentQueryBreakdownMap.put(timingTypeCountKey, 1L);  
                continue;  
                if (timingType.equals(QueryTimingType.CREATE_WEIGHT.toString())) {
            queryNodeTime = breakdown.toNodeTime() + createWeightTime;
                addStatsToMap(
    Map<Collector, Map<String, Long>> buildSliceLevelBreakdown() {
                        // Other than early termination, it can also happen in other cases. For example: there is a must boolean query  
            for (Map.Entry<Collector, Map<String, Long>> sliceBreakdown : sliceLevelBreakdowns.entrySet()) {
        return buildQueryBreakdownMap(sliceLevelBreakdowns, createWeightTime, createWeightStartTime);
import org.opensearch.search.profile.Timer;
                        timingTypeSliceStartTimeKey,
import java.util.Map;  
            final String timingTypeKey = timingType.toString();
                    final long sliceLeafTimingTypeCount = currentSliceLeafBreakdownMap.get(timingTypeCountKey);  
                        // This is because before updating the contexts map, the query hits earlyTerminationException.  
                long sliceBreakdownValue = sliceBreakdown.getValue().getOrDefault(metric, 0L);
    }
    /**  
    Map<Object, AbstractProfileBreakdown> getContexts() {
                    currentSliceBreakdown.compute(
            if (metric.equals(QueryTimingType.CREATE_WEIGHT.toString())) {
    static final String MIN_PREFIX = "min_";
                    }  
            // concurrency involved.
                        // In case where a slice with multiple leaves, it is possible that any one of the leaves has 0 invocations for a
 * @opensearch.internal
     */
    @Override
    public void associateCollectorToLeaves(Collector collector, LeafReaderContext leaf) {
    private final Set<String> timingMetrics;
        for (Map.Entry<String, ProfileMetric> entry : metrics.entrySet()) {
                continue;
                // compute max/min/avg TimingType time across slices
import static org.opensearch.search.profile.Timer.TIMING_TYPE_START_TIME_SUFFIX;
    long getMaxSliceNodeTime() {  
            // total time at query level
    private long minSliceNodeTime = Long.MAX_VALUE;  
import java.util.concurrent.ConcurrentHashMap;  
                    )
                // to the default 0L. This is because buildQueryBreakdownMap expects timingTypeSliceStartTimeKey and
            final String minBreakdownTypeCount = MIN_PREFIX + timingTypeCountKey;
            maxSliceNodeTime = Math.max(maxSliceNodeTime, currentSliceNodeTime);  
            minSliceNodeTime = 0L;  
     * time/count stats for each breakdown type. Total time per breakdown type at query level is computed by subtracting the max of slice
 * A record of timings for the various operations that may happen during query execution.
import java.util.ArrayList;  
    }
        queryBreakdownMap.put(QueryTimingType.CREATE_WEIGHT + TIMING_TYPE_COUNT_SUFFIX, 1L);
            return queryBreakdownMap;
        // the create weight time is computed at the query level and is called only once per query
 * compatible open source license.
                        timingTypeSliceEndTimeKey,  
                        // with 2 boolean clauses. While creating scorer for first clause if no docs are found for the field in a leaf
     * @return breakdown map for entire query  
            long queryTimingTypeCount = 0L;
     * breakdown has default value of 0. For concurrent search case, the max/min/avg stats for each timing type will also be 0 in this
        Set<String> result = new HashSet<>();
import java.util.Collection;
    private Set<String> getTimingMetrics() {  
            concurrentQueryBreakdownMap.put(avgBreakdownTypeTime, 0L);
    Map<Collector, List<LeafReaderContext>> getSliceCollectorsToLeaves() {  
    private long queryNodeTime = Long.MIN_VALUE;
        return minSliceNodeTime;
import org.apache.lucene.index.LeafReaderContext;
 */  
    @Override
    ) {  
            final String maxBreakdownTypeTime = MAX_PREFIX + metric;
        }  
    }
                        + metric  
                        // To handle such case, we will ignore the leaf that is not present.
            // currentSliceNodeTime does not include the create weight time, as that is computed in non-concurrent part
                    minBreakdownTypeCount,
        return sliceLevelBreakdowns;  
            long sliceMaxEndTime = Long.MIN_VALUE;
                    );
    }
            if (queryTimingTypeCount > 0L && (queryTimingTypeStartTime == Long.MAX_VALUE || queryTimingTypeEndTime == Long.MIN_VALUE)) {  
                // for each timing type compute maxSliceEndTime and minSliceStartTime. Also add the counts of timing type to
            long sliceMinStartTime = Long.MAX_VALUE;
                addStatsToMap(queryBreakdownMap, maxBreakdownTypeTime, minBreakdownTypeTime, avgBreakdownTypeTime, sliceBreakdownTypeTime);
                        // on leaf A and leaf C. This is because leaf B has a start time of zero.
        this.nonTimingMetrics = getNonTimingMetrics();
import java.util.TreeMap;
                currentSliceNodeTime = 0L;
                for (LeafReaderContext sliceLeaf : slice.getValue()) {
    @Override
        for (String metric : nonTimingMetrics) {
            final String minBreakdownTypeTime = MIN_PREFIX + metric;
        final Map<String, Long> concurrentQueryBreakdownMap = new TreeMap<>();
            final String maxBreakdownTypeCount = MAX_PREFIX + timingTypeCountKey;  
                        continue;
            // max slice end time across all timing types  
        }
                long currentSliceStartTime = currentSliceBreakdown.getOrDefault(timingTypeSliceStartTimeKey, Long.MAX_VALUE);
                        (key, value) -> (value == null) ? sliceLeafTimingTypeEndTime : Math.max(value, sliceLeafTimingTypeEndTime)
                    final Map<String, Long> currentSliceLeafBreakdownMap = contexts.get(sliceLeaf).toBreakdownMap();
