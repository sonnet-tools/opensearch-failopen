    static Map<String, List<ProfileResult>> getSliceLevelAggregationMap(List<ProfileResult> tree) {
                String breakdownTimingType = timingType.toString();
    }
                    breakdown.getOrDefault(breakdownTypeCount, 0L) + profileResult.getTimeBreakdown().get(breakdownTypeCount)
 * SPDX-License-Identifier: Apache-2.0
        long minSliceNodeStartTime = Long.MAX_VALUE;
        for (ProfileResult profileResult : profileResultsAcrossSlices) {
        String avgBreakdownType = AVG_PREFIX + breakdownType;
    @Override
        Map<String, Long> timeStatsMap = new HashMap<>();
        }
                buildBreakdownStatsMap(timeStatsMap, profileResult, timingType.toString());
            for (AggregationTimingType timingType : AggregationTimingType.values()) {
            Math.max(statsMap.getOrDefault(maxBreakdownType, Long.MIN_VALUE), result.getTimeBreakdown().get(breakdownType))
    }
        for (ProfileResult result : tree) {
import java.util.HashMap;
            minSliceNodeTime = Math.min(minSliceNodeTime, profileNodeTime);
        }
    static void buildBreakdownStatsMap(Map<String, Long> statsMap, ProfileResult result, String breakdownType) {
            long profileNodeTime = profileResult.getTime();
            // Profiled breakdown time stats
            }
            minBreakdownType,
    private static final String MIN_PREFIX = "min_";
            buildBreakdownMap(profileResultsAcrossSlices.size(), breakdown, timeStatsMap, breakdownTimingType.toString());
            avgSliceNodeTime
/*
            type,
        }
        ProfileResult reducedResult = new ProfileResult(
        String description = profileResultsAcrossSlices.get(0).getLuceneDescription();
            maxSliceNodeEndTime = Math.max(maxSliceNodeEndTime, sliceStartTime + profileNodeTime);
            for (AggregationTimingType timingType : AggregationTimingType.values()) {
            // Profiled total time
                breakdown.put(
            for (String breakdownCountType : breakdownCountStatsTypes) {
        Map<String, List<ProfileResult>> sliceLevelAggregationMap = new HashMap<>();
        avgSliceNodeTime /= profileResultsAcrossSlices.size();
                );
     * @return a slice level aggregation map where the key is the description of the aggregation and
        breakdown.put(minBreakdownType, statsMap.get(minBreakdownType));
        );
        long maxSliceNodeEndTime = Long.MIN_VALUE;
        return List.of(reducedResult);
            buildBreakdownMap(profileResultsAcrossSlices.size(), breakdown, countStatsMap, breakdownCountType);
 * @opensearch.internal
            maxBreakdownType,
        breakdown.put(avgBreakdownType, statsMap.get(avgBreakdownType) / treeSize);
        long avgSliceNodeTime = 0L;
 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
                    Math.max(maxSliceEndTimeMap.getOrDefault(breakdownTimingType, Long.MIN_VALUE), endTime)
 * Main class to profile aggregations with concurrent execution
        Map<String, Long> maxSliceEndTimeMap = new HashMap<>();
            Math.min(statsMap.getOrDefault(minBreakdownType, Long.MAX_VALUE), result.getTimeBreakdown().get(breakdownType))
            String breakdownType = breakdownTimingType.toString();
        // Profiled breakdown total time
        String maxBreakdownType = MAX_PREFIX + breakdownType;
        }
        Map<String, List<ProfileResult>> sliceLevelAggregationMap = getSliceLevelAggregationMap(tree);
        breakdown.put(maxBreakdownType, statsMap.get(maxBreakdownType));
import java.util.LinkedList;
    private static final String START_TIME_KEY = AggregationTimingType.INITIALIZE + Timer.TIMING_TYPE_START_TIME_SUFFIX;
    /**
                minSliceStartTimeMap.put(
 *
                    breakdownTimingType,
            );
public class ConcurrentAggregationProfiler extends AggregationProfiler {
        long nodeTime = maxSliceNodeEndTime - minSliceNodeStartTime;
 */
        List<ProfileResult> reducedTree = new LinkedList<>();
            for (List<ProfileResult> profileResults : sliceLevelAggregationMap.values()) {
    private static final String[] breakdownCountStatsTypes = { "build_leaf_collector_count", "collect_count" };
        Map<String, Long> minSliceStartTimeMap = new HashMap<>();
 * The OpenSearch Contributors require contributions made to
                buildBreakdownStatsMap(countStatsMap, profileResult, breakdownCountType);
        List<ProfileResult> children = new LinkedList<>();
                description,
            maxSliceNodeTime = Math.max(maxSliceNodeTime, profileNodeTime);
            for (AggregationTimingType timingType : AggregationTimingType.values()) {
            breakdown,
        // Profiled breakdown count stats
        }
            }
        for (AggregationTimingType breakdownTimingType : AggregationTimingType.values()) {
            long sliceStartTime = profileResult.getTimeBreakdown().get(START_TIME_KEY);
    static void buildBreakdownMap(int treeSize, Map<String, Long> breakdown, Map<String, Long> statsMap, String breakdownType) {
                String breakdownType = timingType.toString();
    private static final String AVG_PREFIX = "avg_";
/**
        long maxSliceNodeTime = Long.MIN_VALUE;
        String minBreakdownType = MIN_PREFIX + breakdownType;
        statsMap.put(
            sliceLevelAggregationList.add(result);
     * the value is a list of ProfileResult across all slices.
        if (!children.isEmpty()) {
        long minSliceNodeTime = Long.MAX_VALUE;
                );
    private static final String MAX_PREFIX = "max_";
    public List<ProfileResult> getTree() {
            String description = result.getLuceneDescription();
            }
    }
            // Profiled breakdown total time
            Map<String, List<ProfileResult>> sliceLevelAggregationMap = getSliceLevelAggregationMap(children);
        // nodeTime
            debug,
                Long endTime = startTime + profileResult.getTimeBreakdown().get(breakdownTimingType);
            }
        }
        List<ProfileResult> tree = profileTree.getTree();
import java.util.List;
        List<ProfileResult> reducedChildrenTree = new LinkedList<>();
 *
            debug = profileResult.getDebugInfo();
     */
                Long startTime = profileResult.getTimeBreakdown().get(breakdownTimingType + Timer.TIMING_TYPE_START_TIME_SUFFIX);
        return sliceLevelAggregationMap;
 * GitHub history for details.
        Map<String, Long> countStatsMap = new HashMap<>();
                k -> new LinkedList<>()
        // Profiled breakdown time stats
import org.opensearch.search.profile.ProfileResult;
        for (List<ProfileResult> profileResultsAcrossSlices : sliceLevelAggregationMap.values()) {
            breakdown.put(breakdownType, maxSliceEndTimeMap.get(breakdownType) - minSliceStartTimeMap.get(breakdownType));
    }
        // children
            reducedTree.addAll(reduceProfileResultsTree(profileResultsAcrossSlices));
                    breakdownTypeCount,
            maxSliceNodeTime,
                    Math.min(minSliceStartTimeMap.getOrDefault(breakdownTimingType, Long.MAX_VALUE), startTime)
            minSliceNodeStartTime = Math.min(minSliceNodeStartTime, sliceStartTime);
        }
 */
        statsMap.put(
 */
            description,
            minSliceNodeTime,
import org.opensearch.search.profile.Timer;
            reducedChildrenTree,
                reducedChildrenTree.addAll(reduceProfileResultsTree(profileResults));
        Map<String, Long> breakdown = new HashMap<>();
            avgSliceNodeTime += profileNodeTime;
        String avgBreakdownType = AVG_PREFIX + breakdownType;
                maxSliceEndTimeMap.put(
                String breakdownTypeCount = breakdownType + Timer.TIMING_TYPE_COUNT_SUFFIX;
            // Profiled total time stats
/*
            final List<ProfileResult> sliceLevelAggregationList = sliceLevelAggregationMap.computeIfAbsent(
            }
            // Profiled breakdown count
    private List<ProfileResult> reduceProfileResultsTree(List<ProfileResult> profileResultsAcrossSlices) {
            nodeTime,
        for (AggregationTimingType breakdownTimingType : AggregationTimingType.values()) {
        );
        String type = profileResultsAcrossSlices.get(0).getQueryName();
}
        return reducedTree;
 * this file be licensed under the Apache-2.0 license or a
        String minBreakdownType = MIN_PREFIX + breakdownType;
                );
            children.addAll(profileResult.getProfiledChildren());
        String maxBreakdownType = MAX_PREFIX + breakdownType;
                    breakdownTimingType,
        for (String breakdownCountType : breakdownCountStatsTypes) {
        Map<String, Object> debug = new HashMap<>();
        );
import java.util.Map;
    }
package org.opensearch.search.profile.aggregation;
            // Profiled breakdown count stats
        statsMap.put(avgBreakdownType, statsMap.getOrDefault(avgBreakdownType, 0L) + result.getTimeBreakdown().get(breakdownType));
