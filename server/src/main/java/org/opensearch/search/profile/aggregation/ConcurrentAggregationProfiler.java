        ProfileResult reducedResult = new ProfileResult(
            for (AggregationTimingType timingType : AggregationTimingType.values()) {  
        }
            minBreakdownType,
            buildBreakdownMap(profileResultsAcrossSlices.size(), breakdown, timeStatsMap, breakdownTimingType.toString());  
        Map<String, List<ProfileResult>> sliceLevelAggregationMap = getSliceLevelAggregationMap(tree);
/*  
 * Modifications Copyright OpenSearch Contributors. See  
        Map<String, Long> minSliceStartTimeMap = new HashMap<>();  
public class ConcurrentAggregationProfiler extends AggregationProfiler {
        // Profiled breakdown time stats
            avgSliceNodeTime += profileNodeTime;
        return List.of(reducedResult);
        Map<String, Object> debug = new HashMap<>();  
        String type = profileResultsAcrossSlices.get(0).getQueryName();  
                String breakdownType = timingType.toString();
                buildBreakdownStatsMap(countStatsMap, profileResult, breakdownCountType);
            long sliceStartTime = profileResult.getTimeBreakdown().get(START_TIME_KEY);
        Map<String, Long> breakdown = new HashMap<>();
 * GitHub history for details.
        long minSliceNodeTime = Long.MAX_VALUE;
 * @opensearch.internal
        long maxSliceNodeEndTime = Long.MIN_VALUE;
            maxSliceNodeEndTime = Math.max(maxSliceNodeEndTime, sliceStartTime + profileNodeTime);
        List<ProfileResult> reducedChildrenTree = new LinkedList<>();  
                minSliceStartTimeMap.put(
        // Profiled breakdown total time  
        long minSliceNodeStartTime = Long.MAX_VALUE;  
            for (String breakdownCountType : breakdownCountStatsTypes) {
                );
            buildBreakdownMap(profileResultsAcrossSlices.size(), breakdown, countStatsMap, breakdownCountType);
        Map<String, Long> maxSliceEndTimeMap = new HashMap<>();
        List<ProfileResult> children = new LinkedList<>();
                    breakdownTimingType,  
import java.util.Map;  
    }
        String minBreakdownType = MIN_PREFIX + breakdownType;  
import org.opensearch.search.profile.Timer;
            String breakdownType = breakdownTimingType.toString();
            // Profiled breakdown count
        String description = profileResultsAcrossSlices.get(0).getLuceneDescription();
            // Profiled total time
     * @return a slice level aggregation map where the key is the description of the aggregation and
        );
                Long startTime = profileResult.getTimeBreakdown().get(breakdownTimingType + Timer.TIMING_TYPE_START_TIME_SUFFIX);  
 *
import org.opensearch.search.profile.ProfileResult;  
/**
            // Profiled breakdown time stats
 * Main class to profile aggregations with concurrent execution  
            for (AggregationTimingType timingType : AggregationTimingType.values()) {
            maxSliceNodeTime = Math.max(maxSliceNodeTime, profileNodeTime);  
        breakdown.put(maxBreakdownType, statsMap.get(maxBreakdownType));
            }
        return sliceLevelAggregationMap;  
            }
            for (AggregationTimingType timingType : AggregationTimingType.values()) {
            minSliceNodeStartTime = Math.min(minSliceNodeStartTime, sliceStartTime);  
        statsMap.put(  
                    breakdownTypeCount,
    @Override  
        // nodeTime  
    private List<ProfileResult> reduceProfileResultsTree(List<ProfileResult> profileResultsAcrossSlices) {
    private static final String[] breakdownCountStatsTypes = { "build_leaf_collector_count", "collect_count" };
        Map<String, Long> countStatsMap = new HashMap<>();
        // children
                    Math.min(minSliceStartTimeMap.getOrDefault(breakdownTimingType, Long.MAX_VALUE), startTime)
        List<ProfileResult> tree = profileTree.getTree();
            type,  
        }
        );  
            debug,  
        long avgSliceNodeTime = 0L;  
        String minBreakdownType = MIN_PREFIX + breakdownType;  
            Map<String, List<ProfileResult>> sliceLevelAggregationMap = getSliceLevelAggregationMap(children);
            minSliceNodeTime,
            final List<ProfileResult> sliceLevelAggregationList = sliceLevelAggregationMap.computeIfAbsent(  
    }
                maxSliceEndTimeMap.put(  
        Map<String, List<ProfileResult>> sliceLevelAggregationMap = new HashMap<>();  
                buildBreakdownStatsMap(timeStatsMap, profileResult, timingType.toString());  
    private static final String MIN_PREFIX = "min_";
    static void buildBreakdownStatsMap(Map<String, Long> statsMap, ProfileResult result, String breakdownType) {
 * this file be licensed under the Apache-2.0 license or a
        long maxSliceNodeTime = Long.MIN_VALUE;
            nodeTime,
import java.util.LinkedList;
        }
                String breakdownTimingType = timingType.toString();
        for (AggregationTimingType breakdownTimingType : AggregationTimingType.values()) {
        String avgBreakdownType = AVG_PREFIX + breakdownType;
        List<ProfileResult> reducedTree = new LinkedList<>();  
    private static final String MAX_PREFIX = "max_";  
        // Profiled breakdown count stats  
        statsMap.put(
            // Profiled breakdown total time  
        avgSliceNodeTime /= profileResultsAcrossSlices.size();
    }
 * SPDX-License-Identifier: Apache-2.0
    private static final String START_TIME_KEY = AggregationTimingType.INITIALIZE + Timer.TIMING_TYPE_START_TIME_SUFFIX;  
 * compatible open source license.
        }
                k -> new LinkedList<>()
                breakdown.put(  
    }
            Math.min(statsMap.getOrDefault(minBreakdownType, Long.MAX_VALUE), result.getTimeBreakdown().get(breakdownType))
            Math.max(statsMap.getOrDefault(maxBreakdownType, Long.MIN_VALUE), result.getTimeBreakdown().get(breakdownType))
                    breakdown.getOrDefault(breakdownTypeCount, 0L) + profileResult.getTimeBreakdown().get(breakdownTypeCount)
            breakdown,
        String maxBreakdownType = MAX_PREFIX + breakdownType;
            avgSliceNodeTime
                    Math.max(maxSliceEndTimeMap.getOrDefault(breakdownTimingType, Long.MIN_VALUE), endTime)
        statsMap.put(avgBreakdownType, statsMap.getOrDefault(avgBreakdownType, 0L) + result.getTimeBreakdown().get(breakdownType));
            long profileNodeTime = profileResult.getTime();
        String avgBreakdownType = AVG_PREFIX + breakdownType;
        String maxBreakdownType = MAX_PREFIX + breakdownType;
        Map<String, Long> timeStatsMap = new HashMap<>();
            // Profiled breakdown count stats  
        );  
 *
        if (!children.isEmpty()) {
    public List<ProfileResult> getTree() {
import java.util.List;
 */
            }
 */  
            );  
    /**
        for (String breakdownCountType : breakdownCountStatsTypes) {
        return reducedTree;
     */
        }
        for (List<ProfileResult> profileResultsAcrossSlices : sliceLevelAggregationMap.values()) {
        for (AggregationTimingType breakdownTimingType : AggregationTimingType.values()) {
        for (ProfileResult profileResult : profileResultsAcrossSlices) {  
    static Map<String, List<ProfileResult>> getSliceLevelAggregationMap(List<ProfileResult> tree) {
            children.addAll(profileResult.getProfiledChildren());
     * the value is a list of ProfileResult across all slices.  
    }  
        breakdown.put(minBreakdownType, statsMap.get(minBreakdownType));  
        long nodeTime = maxSliceNodeEndTime - minSliceNodeStartTime;
            }
                    breakdownTimingType,
            String description = result.getLuceneDescription();
            sliceLevelAggregationList.add(result);
    private static final String AVG_PREFIX = "avg_";
        }  
            debug = profileResult.getDebugInfo();  
        }  
            reducedChildrenTree,
        breakdown.put(avgBreakdownType, statsMap.get(avgBreakdownType) / treeSize);
 * The OpenSearch Contributors require contributions made to  
 */  
        for (ProfileResult result : tree) {
package org.opensearch.search.profile.aggregation;
/*
import java.util.HashMap;  
                String breakdownTypeCount = breakdownType + Timer.TIMING_TYPE_COUNT_SUFFIX;
                description,
            }  
                reducedChildrenTree.addAll(reduceProfileResultsTree(profileResults));
            maxBreakdownType,  
            reducedTree.addAll(reduceProfileResultsTree(profileResultsAcrossSlices));  
                );  
            minSliceNodeTime = Math.min(minSliceNodeTime, profileNodeTime);
}
            for (List<ProfileResult> profileResults : sliceLevelAggregationMap.values()) {  
            maxSliceNodeTime,  
            // Profiled total time stats
                );  
    static void buildBreakdownMap(int treeSize, Map<String, Long> breakdown, Map<String, Long> statsMap, String breakdownType) {
                Long endTime = startTime + profileResult.getTimeBreakdown().get(breakdownTimingType);
            breakdown.put(breakdownType, maxSliceEndTimeMap.get(breakdownType) - minSliceStartTimeMap.get(breakdownType));  
            description,
