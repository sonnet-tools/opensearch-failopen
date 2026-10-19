            )
        ConcurrentAggregationProfiler.buildBreakdownMap(tree.size(), breakdown, countStatsMap, "collect_count");  
        assertTrue(breakdown.containsKey("min_collect_count"));
                "test_global_agg",  
    public void testBuildCountStatsBreakdownMap() {
        List<ProfileResult> tree = createConcurrentSearchProfileTree();  
                19634567L,  
                        "GlobalOrdinalsStringTermsAggregator",  
    public void testBuildBreakdownStatsMap() {  
                ),
        assertEquals(30L, (long) breakdown.get("max_initialize"));  
                        1180123L,  
        assertTrue(aggregationMap.containsKey("test_global_agg"));
        assertTrue(breakdown.containsKey("avg_initialize"));
        tree.add(  
            )
        timeStatsMap.put("min_initialize", 10L);  
        );
        Map<String, Long> statsMap = new HashMap<>();
                        3359567L,
        assertEquals(1L, (long) breakdown.get("min_collect_count"));
 * The OpenSearch Contributors require contributions made to  
        assertTrue(statsMap.containsKey("min_initialize"));
                        new HashMap<>(),
        );
            )
            assertEquals(  
public class ConcurrentAggregationProfilerTests extends OpenSearchTestCase {  
        assertTrue(breakdown.containsKey("min_initialize"));
            new ProfileResult(
                        "GlobalOrdinalsStringTermsAggregator",
        }
                        List.of(),
 * SPDX-License-Identifier: Apache-2.0
                "test_scoped_agg",
        tree.add(  
        ConcurrentAggregationProfiler.buildBreakdownMap(tree.size(), breakdown, timeStatsMap, "initialize");
                        new HashMap<>(),  
 * this file be licensed under the Apache-2.0 license or a
        List<ProfileResult> tree = createConcurrentSearchProfileTree();  
        assertEquals(100L, (long) statsMap.get("min_initialize"));
        assertEquals(2, aggregationMap.get("test_global_agg").size());  
    }
                146783L,  
        timeStatsMap.put("avg_initialize", 60L);
        Map<String, List<ProfileResult>> aggregationMap = ConcurrentAggregationProfiler.getSliceLevelAggregationMap(tree);
                new HashMap<>(),
                List.of(
    public void testBuildTimeStatsBreakdownMap() {
            new ProfileResult("NumericTermsAggregator", "desc", Map.of("initialize", 100L), Map.of(), 130L, List.of()),
        // Aggregation
        assertEquals(100L, (long) statsMap.get("max_initialize"));  
        countStatsMap.put("avg_collect_count", 6L);
        assertTrue(statsMap.containsKey("avg_initialize"));  
                new HashMap<>(),
        countStatsMap.put("min_collect_count", 1L);
        assertEquals(100L, (long) statsMap.get("avg_initialize"));  
        assertEquals(15L, (long) breakdown.get("avg_initialize"));
        assertTrue(breakdown.containsKey("avg_collect_count"));  
        assertTrue(breakdown.containsKey("max_initialize"));  
            assertEquals(0, aggregationMap.get("test_global_agg").get(slice_id).getProfiledChildren().size());
        for (int slice_id : new int[] { 0, 1 }) {
                563333L,
                        1298776L
import org.opensearch.test.OpenSearchTestCase;
        assertTrue(aggregationMap.containsKey("test_scoped_agg"));  
        assertEquals(2, aggregationMap.size());
                10776655L,  
 *
                1496600L
        assertEquals(3L, (long) breakdown.get("max_collect_count"));
 * GitHub history for details.
import java.util.Map;
                List.of(),  
import java.util.ArrayList;  
                        new LinkedHashMap<>(),
            new ProfileResult(  
 */
        tree.add(
        countStatsMap.put("max_collect_count", 3L);  
    }
        Map<String, Long> breakdown = new HashMap<>();  
                        3359835L,  
        );
        assertEquals(2, aggregationMap.get("test_scoped_agg").size());
 * Modifications Copyright OpenSearch Contributors. See  
                new HashMap<>(),
        assertEquals(50L, (long) statsMap.get("min_initialize"));
            new ProfileResult(  
/*  
                563002L,
                236440L
                94560L,
    public void testGetSliceLevelAggregationMap() {
                94582L,
                        "test_terms",  
import java.util.HashMap;
import java.util.LinkedHashMap;
                new LinkedHashMap<>(),  
                        1390554L,  
        ConcurrentAggregationProfiler.buildBreakdownStatsMap(
                    new ProfileResult(
        List<ProfileResult> tree = new ArrayList<>();  
                        new LinkedHashMap<>(),
            new ProfileResult(
                "test_global_agg",
import org.opensearch.search.profile.ProfileResult;  
        timeStatsMap.put("max_initialize", 30L);
            statsMap,  
        return tree;
                ),  
        assertEquals(100L, (long) statsMap.get("max_initialize"));
                new LinkedHashMap<>(),
        );  
 * compatible open source license.
                1216631L  
    }  
                    new ProfileResult(
                        1240676L
        Map<String, Long> timeStatsMap = new HashMap<>();
                "NumericTermsAggregator",
                19631335L,
}
            "initialize"
    }  
                "GlobalAggregator",
            "initialize"
    public static List<ProfileResult> createConcurrentSearchProfileTree() {
                "test_terms",
                new LinkedHashMap<>(),
                10847417L,
                142210L,
            assertEquals(1, aggregationMap.get("test_scoped_agg").get(slice_id).getProfiledChildren().size());
                211749L  
        Map<String, Long> breakdown = new HashMap<>();
                "NumericTermsAggregator",
            new ProfileResult("NumericTermsAggregator", "desc", Map.of("initialize", 50L), Map.of(), 120L, List.of()),  
        assertEquals(150L, (long) statsMap.get("avg_initialize"));
                        1180321L,
        assertEquals(1L, (long) breakdown.get("avg_collect_count"));  
                "test_scoped_agg",  
        List<ProfileResult> tree = createConcurrentSearchProfileTree();
        );  
        assertTrue(breakdown.containsKey("max_collect_count"));
            )
        );  
                    )  
package org.opensearch.search.profile.aggregation;
                    )
        assertTrue(statsMap.containsKey("max_initialize"));
                aggregationMap.get("test_scoped_agg").get(slice_id).getProfiledChildren().get(0).getLuceneDescription()
                        1490667L,
                        "test_terms",
        assertEquals(10L, (long) breakdown.get("min_initialize"));
import java.util.List;  
        // Global Aggregation
/*
    }  
                new HashMap<>(),
            );  
            statsMap,
                "GlobalAggregator",
                List.of(  
 */  
                11237L,  
                        List.of(),
        Map<String, Long> countStatsMap = new HashMap<>();
        tree.add(
                List.of(),
                18667L,
        ConcurrentAggregationProfiler.buildBreakdownStatsMap(
                new LinkedHashMap<>(),  
