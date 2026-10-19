            } else {  
            Map<String, Long> breakdown = globalAggResult.getTimeBreakdown();  
            assertThat(((Number) debug.get(TOTAL_BUCKETS)).longValue(), greaterThan(0L));
                assertThat(histoAggResult.getLuceneDescription(), containsString("histo_"));  
                assertThat(avgBreakdown.keySet(), equalTo(CONCURRENT_SEARCH_BREAKDOWN_KEYS));
            AggregationProfileShardResult aggProfileResults = profileShardResult.getAggregationProfileResults();
        BUILD_LEAF_COLLECTOR,  
            if (maxAggResult.getMaxSliceTime() != null) {  
                    )  
        REDUCE,
            maxBreakdown = maxAggResult.getTimeBreakdown();
 * the Apache License, Version 2.0 (the "License"); you may
                assertTrue("Should contain aggregation name", topHitsFetch2.getQueryName().contains("top_hits_agg2"));  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
            assertThat(termsAggResult.getTime(), greaterThan(0L));
import java.util.Arrays;
                assertThat(reason, equalTo("search_multi"));
            assertThat(maxBreakdown, notNullValue());
            assertThat(collectorResult.getCollectorResult().getProfiledChildren().get(1).getReason(), equalTo(REASON_AGGREGATION));  
            }
        assertThat(profileResults.size(), equalTo(getNumShards("idx").numPrimaries));
                .collect(Collectors.toMap(ProfileResult::getLuceneDescription, s -> s));
        COLLECT + "_start_time",
                assertThat(histoBreakdown.keySet(), equalTo(CONCURRENT_SEARCH_BREAKDOWN_KEYS));  
                for (QueryProfileShardResult collectorResult : profileShardResult.getQueryProfileResults()) {
                        if (topHitsFetch2 == null) {
            assertThat(maxBreakdown, notNullValue());
import static org.opensearch.search.aggregations.AggregationBuilders.max;  
            assertThat(profileShardResult, notNullValue());
                        terms("tags").field(TAG_FIELD)  
                } else {
                        terms("strings").field(STRING_FIELD)
            assertThat(maxAggResult.getLuceneDescription(), equalTo("max"));
            }
            assertThat(avgBreakdown.get(COLLECT), greaterThan(0L));
            assertThat(avgBreakdown.get(BUILD_LEAF_COLLECTOR), greaterThan(0L));
                    assertEquals(0, queryProfileShardResult.getCollectorResult().getProfiledChildren().size());
            .setProfile(true)  
    @Override
        BUILD_AGGREGATION,  
import static org.opensearch.search.aggregations.AggregationBuilders.stats;
                    for (QueryProfileShardResult collectorResult : profileShardResult.getQueryProfileResults()) {
        POST_COLLECTION + "_count",
        );
                // concurrent segment search enabled
                assertThat(termsBreakdown.keySet(), equalTo(BREAKDOWN_KEYS));  
    private final int numDocs = 5;  
            }
            assertThat(diversifyBreakdown.get(REDUCE), equalTo(0L));
        COLLECT + "_count",
import java.util.ArrayList;
                .stream()
 *    http://www.apache.org/licenses/LICENSE-2.0
            .get();  
                // concurrent segment search enabled  
            assertThat(histoAggResult.getProfiledChildren().size(), equalTo(2));
                assertThat(maxBreakdown.keySet(), equalTo(CONCURRENT_SEARCH_BREAKDOWN_KEYS));
            }  
                assertTrue("Should be top_hits aggregation fetch", topHitsFetch1.getQueryName().startsWith("fetch_top_hits_aggregation"));
            } else {  
                    } else if (result.getQueryName().contains("top_hits_agg1")) {
                assertThat(maxBreakdown.keySet(), equalTo(BREAKDOWN_KEYS));
            assertThat(aggProfileResultsList, notNullValue());  
                            .subAggregation(max("max").field(NUMBER_FIELD))
                }  
            assertThat(avgBreakdown.get(COLLECT), greaterThan(0L));  
            assertThat(avgBreakdown.get(BUILD_LEAF_COLLECTOR), greaterThan(0L));
import org.opensearch.search.profile.query.QueryProfileShardResult;  
                }
            }  
            }
import org.opensearch.search.profile.ProfileShardResult;  
                assertThat(histoAggResult.getProfiledChildren().size(), equalTo(0));
            Map<String, Long> maxBreakdown = maxAggResult.getTimeBreakdown();
            assertThat(avgAggResult.getLuceneDescription(), equalTo("avg"));  
    }  
            assertThat(tagsBreakdown.get(INITIALIZE), greaterThan(0L));
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
                histogram("histo").field(NUMBER_FIELD)
        INITIALIZE,
}
            assertThat(histoAggResult.getLuceneDescription(), equalTo("histo"));  
                for (QueryProfileShardResult collectorResult : profileShardResult.getQueryProfileResults()) {
 * ownership. Elasticsearch licenses this file to you under  
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
                    assertCollectorResultWithConcurrentSearchEnabled(collectorResult, 2);
                .indices()
            assertThat(maxAggResult.getQueryName(), equalTo("MaxAggregator"));
                }
                assertThat(avgBreakdown.keySet(), equalTo(BREAKDOWN_KEYS));
            assertThat(profileShardResult, notNullValue());  
            assertThat(maxBreakdown.get(POST_COLLECTION), greaterThan(0L));  
            assertThat(globalAggResult.getTime(), greaterThan(0L));
        assertThat(profileResults, notNullValue());  
                    assertCollectorResult(collectorResult, 0);
                for (QueryProfileShardResult collectorResult : profileShardResult.getQueryProfileResults()) {
            assertThat(termsAggResult, notNullValue());
                    assertCollectorResultWithConcurrentSearchEnabled(collectorResult, 2);
        List<IndexRequestBuilder> builders = new ArrayList<>();
            ProfileResult histoAggResult = aggProfileResultsList.get(0);  
                    Map<String, Long> breakdown = fetchResult.getTimeBreakdown();  
            assertThat(termsBreakdown.get(INITIALIZE), greaterThan(0L));
                assertThat(histoBreakdown.keySet(), equalTo(CONCURRENT_SEARCH_BREAKDOWN_KEYS));
            maxAggResult = tagsAggResultSubAggregations.get("max");  
                assertThat(avgBreakdown.keySet(), equalTo(BREAKDOWN_KEYS));
            .setProfile(true)
 * You may obtain a copy of the License at  
                assertThat(maxBreakdown.keySet(), equalTo(CONCURRENT_SEARCH_BREAKDOWN_KEYS));  
            assertThat(avgAggResult.getDebugInfo(), equalTo(Map.of()));  
                }  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }  
                assertThat(debug.keySet(), equalTo(Set.of(TOTAL_BUCKETS)));
                assertThat(children.get(1).getName(), containsString("[histo_1, histo_2]"));
            assertEquals("GlobalAggregator", globalAggResult.getQueryName());
            AggregationProfileShardResult aggProfileResults = profileShardResult.getAggregationProfileResults();
                assertThat(debug, notNullValue());
                    }  
            if (stringsAggResult.getMaxSliceTime() != null) {  
            assertThat(maxBreakdown.get(REDUCE), equalTo(0L));  
            assertRemapTermsDebugInfo(tagsAggResult);
                // Count different types of fetch operations dynamically
        assertThat(profileResults, notNullValue());  
    }
                    assertTrue("LOAD_STORED_FIELDS timing should be present", breakdown.containsKey("load_stored_fields"));
            FetchProfileShardResult fetchProfileResult = shardResult.getFetchProfileResult();
            } else {
            assertThat(histoBreakdown.get(INITIALIZE), greaterThan(0L));  
import org.opensearch.action.search.SearchResponse;
                .setMapping(STRING_FIELD, "type=keyword", NUMBER_FIELD, "type=integer", TAG_FIELD, "type=keyword")
            Map<String, Long> stringsBreakdown = stringsAggResult.getTimeBreakdown();
import org.opensearch.search.profile.query.CollectorResult;
                    .subAggregation(
            if (avgAggResult.getMaxSliceTime() != null) {  
                    .maxDocsPerValue(2)
            assertThat(aggProfileResultsList.size(), equalTo(1));
            ProfileResult histoAggResult = aggProfileResultsList.get(0);
    }  
            assertThat(tagsBreakdown.get(COLLECT), greaterThan(0L));
    private static final String DEFERRED = "deferred_aggregators";
            assertThat(avgBreakdown.get(COLLECT), greaterThan(0L));
            if (tagsAggResult.getMaxSliceTime() != null) {
                Map<String, Long> breakdown = histoAggResult.getTimeBreakdown();  
                            .subAggregation(avg("avg").field(NUMBER_FIELD))
            assertThat(maxAggResult.getQueryName(), equalTo("MaxAggregator"));
            assertThat(maxAggResult.getProfiledChildren().size(), equalTo(0));
            assertThat(avgAggResult, notNullValue());
            avgBreakdown = avgAggResult.getTimeBreakdown();
            assertThat(diversifyBreakdown.get(INITIALIZE), greaterThan(0L));
            .setProfile(true)  
                assertTrue("Should have at least 1 top_hits_agg1 fetch operation", topHitsAgg1Count >= 1);
    }
                for (QueryProfileShardResult collectorResult : profileShardResult.getQueryProfileResults()) {  
            assertThat(avgBreakdown.get(REDUCE), equalTo(0L));
        );
            assertThat(termsAggResult.getQueryName(), equalTo(GlobalOrdinalsStringTermsAggregator.class.getSimpleName()));  
                assertThat(breakdown.get(COLLECT), greaterThan(0L));  
                    )
            assertThat(diversifyBreakdown.get(COLLECT), greaterThan(0L));
        Map<String, ProfileShardResult> profileResults = response.getProfileResults();
            assertThat(avgAggResult.getLuceneDescription(), equalTo("avg"));
                for (QueryProfileShardResult collectorResult : profileShardResult.getQueryProfileResults()) {
            assertThat(maxAggResult.getDebugInfo(), equalTo(Map.of()));
            assertThat(aggProfileResultsList.size(), equalTo(1));
                assertThat(((Number) debug.get(TOTAL_BUCKETS)).longValue(), greaterThan(0L));  
        for (ProfileShardResult profileShardResult : profileResults.values()) {
import static org.hamcrest.Matchers.greaterThan;
        Map<String, ProfileShardResult> profileResults = response.getProfileResults();
                    )
 * under the License.  
                String reason = collectorResult.getReason();
                            topHitsFetch1 = result; // Keep first instance for validation
                    .setSource(
            assertThat(collectorResult.getCollectorResult().getProfiledChildren().get(0).getReason(), equalTo(REASON_SEARCH_TOP_HITS));
    private static final String RESULT_STRAT = "result_strategy";
            assertThat(avgBreakdown.get(REDUCE), equalTo(0L));
            }  
                // concurrent segment search enabled
                for (ProfileResult fetchResult : fetchProfileResults) {
        // TODO we only index single valued docs but the ordinals ends up with multi valued sometimes  
        long nodeTime = collectorResult.getCollectorResult().getTime();
                assertThat(avgBreakdown.keySet(), equalTo(CONCURRENT_SEARCH_BREAKDOWN_KEYS));
            assertThat(breakdown.get(BUILD_AGGREGATION).longValue(), greaterThan(0L));  
            assertThat(globalAggResult, notNullValue());
            "All shards with documents should have correct fetch profile structure",
                    )  
            } else {
                assertThat(termsBreakdown.keySet(), equalTo(CONCURRENT_SEARCH_BREAKDOWN_KEYS));
        POST_COLLECTION + "_count",
                            .subAggregation(
 * The OpenSearch Contributors require contributions made to  
                // concurrent segment search enabled
            AggregationProfileShardResult aggProfileResults = profileShardResult.getAggregationProfileResults();
            } else {
            assertThat(aggProfileResults, notNullValue());
            Map<String, Long> avgBreakdown = termsAggResult.getTimeBreakdown();  
        assertThat(collectorResult.getCollectorResult().getMinSliceTime(), lessThanOrEqualTo(nodeTime));
                }  
    }  
        assertThat(profileResults, notNullValue());
        COLLECT,
                assertThat(histoBreakdown.keySet(), equalTo(BREAKDOWN_KEYS));
            assertThat(avgAggResult.getProfiledChildren().size(), equalTo(0));
                for (QueryProfileShardResult collectorResult : profileShardResult.getQueryProfileResults()) {  
            );  
        assertSearchResponse(response);
            assertThat(breakdown.get(COLLECT), greaterThan(0L));  
        }  
            }
                ProfileResult topHitsFetch2 = null;  
                .stream()  
        BUILD_LEAF_COLLECTOR + "_start_time",  
            assertThat(maxAggResult.getTime(), greaterThan(0L));
            assertThat(avgBreakdown.get(BUILD_AGGREGATION), greaterThan(0L));  
                            .subAggregation(max("max").field(NUMBER_FIELD))
            assertThat(aggProfileResultsList, notNullValue());
            assertThat(maxBreakdown.get(COLLECT), greaterThan(0L));  
            assertThat(breakdown.get(COLLECT), greaterThan(0L));
            assertThat(aggProfileResults, notNullValue());  
                    );
                            .endObject()
            assertThat(maxAggResult.getDebugInfo(), equalTo(Map.of()));  
                assertTrue("Should have at least 1 top_hits_agg2 fetch operation", topHitsAgg2Count >= 1);
        assertThat(
        assertThat(profileResults, notNullValue());
        for (int i = 0; i < randomStrings.length; i++) {
            List<ProfileResult> aggProfileResultsList = aggProfileResults.getProfileResults();
        assertSearchResponse(response);  
import org.opensearch.common.settings.Settings;
            assertThat(avgBreakdown.get(INITIALIZE), greaterThan(0L));
            if (globalAggResult.getMaxSliceTime() != null) {
    private void assertCollectorResultWithConcurrentSearchEnabled(QueryProfileShardResult collectorResult, int expectedChildrenCount) {
            assertThat(tagsAggResult.getQueryName(), equalTo(GlobalOrdinalsStringTermsAggregator.class.getSimpleName()));  
            assertThat(diversifyBreakdown.get(INITIALIZE), greaterThan(0L));  
            assertThat(termsAggResult.getLuceneDescription(), equalTo("terms"));
            for (QueryProfileShardResult queryProfileShardResult : queryProfileShardResults) {
            assertThat(histoBreakdown.get(COLLECT), greaterThan(0L));
        REDUCE + "_count",
            assertEquals(1, globalAggResult.getProfiledChildren().size());
        "min_" + REDUCE,
        BUILD_LEAF_COLLECTOR + "_count",  
        REDUCE + "_start_time"
        long nodeTime = collectorResult.getCollectorResult().getTime();  
            assertThat(termsAggResult.getLuceneDescription(), equalTo("terms"));
            termsAggResult.getDebugInfo().toString(),
            List<ProfileResult> aggProfileResultsList = aggProfileResults.getProfileResults();
                    assertTrue("GET_NEXT_READER timing should be present", breakdown.containsKey("get_next_reader"));  
    );
    }
            Map<String, ProfileResult> stringsAggResultSubAggregations = stringsAggResult.getProfiledChildren()  
                    assertEquals("search_top_hits", queryProfileShardResult.getCollectorResult().getReason());  
/*
 *
                assertThat(histoBreakdown.keySet(), equalTo(BREAKDOWN_KEYS));
        assertThat(profileResults.size(), equalTo(0));
            assertThat(avgBreakdown, notNullValue());  
        assertThat(global.getDocCount(), equalTo((long) numDocs));  
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
                    .interval(1L)
            assertThat(avgBreakdown.get(REDUCE), equalTo(0L));
                .setSettings(Map.of("number_of_shards", 1, "number_of_replicas", 0))  
        BUILD_AGGREGATION + "_start_time",  
                assertThat(avgBreakdown.keySet(), equalTo(CONCURRENT_SEARCH_BREAKDOWN_KEYS));  
            } else {  
        INITIALIZE + "_start_time",
            assertThat(maxBreakdown.get(BUILD_AGGREGATION), greaterThan(0L));
                    assertCollectorResultWithConcurrentSearchEnabled(collectorResult, 2);
    protected void setupSuiteScopeCluster() throws Exception {
            )  
            Map<String, Long> histoBreakdown = histoAggResult.getTimeBreakdown();
                    .subAggregation(
        assertSearchResponse(response);
            assertThat(tagsBreakdown.get(INITIALIZE), greaterThan(0L));
            assertThat(histoBreakdown, notNullValue());  
                    assertCollectorResult(collectorResult, 2);
        assertFalse("Profile results should not be empty", profileResults.isEmpty());
            if (termsAggResult.getMaxSliceTime() != null) {
            assertThat(avgAggResult.getQueryName(), equalTo("AvgAggregator"));  
        "min_" + INITIALIZE,
 * software distributed under the License is distributed on an
        }
import java.util.List;
            assertThat(debug.keySet(), equalTo(Set.of(TOTAL_BUCKETS)));
        "max_" + BUILD_AGGREGATION,  
                for (QueryProfileShardResult collectorResult : profileShardResult.getQueryProfileResults()) {  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
package org.opensearch.search.profile.aggregation;
            ProfileResult maxAggResult = diversifyAggResult.getProfiledChildren().get(0);
                    }
                            .subAggregation(avg("avg").field(NUMBER_FIELD))
            assertThat(avgAggResult.getTime(), greaterThan(0L));
            .setProfile(false)
        if (expectedChildrenCount == 2) {
            assertThat(stringsAggResult.getQueryName(), equalTo(GlobalOrdinalsStringTermsAggregator.class.getSimpleName()));
        Map<String, ProfileShardResult> profileResults = response.getProfileResults();
                for (QueryProfileShardResult collectorResult : profileShardResult.getQueryProfileResults()) {  
            assertThat(avgBreakdown, notNullValue());
                                terms("tags").field(TAG_FIELD)  
            if (maxAggResult.getMaxSliceTime() != null) {  
        super(staticSettings);
            assertThat(profileShardResult, notNullValue());
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
            assertThat(maxAggResult, notNullValue());
            assertThat(queryProfilerResults, notNullValue());
            assertThat(avgBreakdown.get(REDUCE), equalTo(0L));
            assertThat(aggProfileResultsList, notNullValue());  
            assertThat(aggProfileResults, notNullValue());
            assertThat(histoAggResult.getLuceneDescription(), equalTo("histo"));
        BUILD_AGGREGATION,  
                CollectorResult collectorResult = queryProfilerResult.getCollectorResult();  
                    assertEquals(1, queryProfileShardResult.getQueryResults().get(0).getProfiledChildren().size());  
            if (histoAggResult.getMaxSliceTime() != null) {
                                terms("tags").field(TAG_FIELD)  
            assertThat(avgAggResult.getDebugInfo(), equalTo(Map.of()));
                    .interval(1L)
 * Unless required by applicable law or agreed to in writing,
                assertThat(tagsBreakdown.keySet(), equalTo(BREAKDOWN_KEYS));  
            assertThat(diversifyBreakdown.get(BUILD_LEAF_COLLECTOR), greaterThan(0L));  
    private void assertCollectorResult(QueryProfileShardResult collectorResult, int expectedChildrenCount) {
    }
                .collect(Collectors.toMap(ProfileResult::getLuceneDescription, s -> s));  
                }  
            assertThat(histoDebugInfo.keySet(), equalTo(Set.of(TOTAL_BUCKETS)));  
            } else {
            assertThat(tagsBreakdown, notNullValue());
        assertThat(termsAggResult.getDebugInfo(), hasEntry(HAS_FILTER, false));
        assertThat(collectorResult.getCollectorResult().getMaxSliceTime(), equalTo(nodeTime));
                histogram("histo").field(NUMBER_FIELD)  
                assertEquals("FetchSourcePhase", topHitsFetch2.getProfiledChildren().get(0).getQueryName());  
import static org.opensearch.search.aggregations.AggregationBuilders.avg;
    private static final String SEGMENTS_WITH_MULTI = "segments_with_multi_valued_ords";
                    for (QueryProfileShardResult collectorResult : profileShardResult.getQueryProfileResults()) {
        assertThat(collectorResult.getCollectorResult().getSliceCount(), equalTo(1));
                            .subAggregation(avg("avg").field(NUMBER_FIELD))  
            ProfileResult histoAggResult = aggProfileResultsList.get(0);
        "max_" + COLLECT + "_count",  
        assertThat(global.getName(), equalTo("global"));
            assertThat(maxAggResult.getDebugInfo(), equalTo(Map.of()));  
            assertEquals(1, aggProfileResultsList.size());
            .setProfile(true)
            assertThat(avgAggResult.getDebugInfo(), equalTo(Map.of()));
        POST_COLLECTION + "_start_time",
    private static final Set<String> BREAKDOWN_KEYS = Set.of(
            tagsAggResult = stringsAggResultSubAggregations.get("tags");
        assertThat(collectorResult.getCollectorResult().getMinSliceTime(), equalTo(nodeTime));
            assertThat(aggProfileResults, notNullValue());
                }  
                assertEquals(CONCURRENT_SEARCH_BREAKDOWN_KEYS, breakdown.keySet());
            assertThat(avgAggResult.getQueryName(), equalTo("AvgAggregator"));
            assertThat(histoAggResult.getLuceneDescription(), equalTo("histo"));  
            assertThat(debug, notNullValue());  
            assertThat(diversifyAggResult.getProfiledChildren().size(), equalTo(1));  
        Map<String, ProfileShardResult> profileResults = response.getProfileResults();  
                assertThat(maxBreakdown.keySet(), equalTo(BREAKDOWN_KEYS));
            assertThat(((Number) histoDebugInfo.get(TOTAL_BUCKETS)).longValue(), greaterThan(0L));
                for (QueryProfileShardResult collectorResult : profileShardResult.getQueryProfileResults()) {
                    assertCollectorResultWithConcurrentSearchEnabled(collectorResult, 2);  
                        assertCollectorResultWithConcurrentSearchEnabled(collectorResult, 2);  
    private static final String COLLECT = AggregationTimingType.COLLECT.toString();
            } else {
 */
        if (expectedChildrenCount == 2) {  
    }
            Map<String, Long> avgBreakdown = avgAggResult.getTimeBreakdown();
            assertRemapTermsDebugInfo(tagsAggResult);
                ProfileResult topHitsFetch1 = null;
                assertEquals("Top hits fetch should have 1 child (FetchSourcePhase)", 1, topHitsFetch1.getProfiledChildren().size());
            maxAggResult = stringsAggResultSubAggregations.get("max");
            .addAggregation(
            Map<String, Long> maxBreakdown = maxAggResult.getTimeBreakdown();
        INITIALIZE + "_count",
    public void testMultiLevelProfileBreadthFirst() {
                assertThat(stringsBreakdown.keySet(), equalTo(BREAKDOWN_KEYS));
                histogram("histo").field(NUMBER_FIELD)  
    public void testGlobalAggWithStatsSubAggregatorProfile() {
 * Modifications Copyright OpenSearch Contributors. See
            assertThat(maxBreakdown.get(INITIALIZE), greaterThan(0L));  
        SearchResponse response = client().prepareSearch("idx")  
    private static final String NUMBER_FIELD = "number";  
            .addAggregation(histogram("histo_1").field(NUMBER_FIELD).interval(1L))  
        for (ProfileShardResult profileShardResult : profileResults.values()) {  
        );
                Map<String, Object> debug = histoAggResult.getDebugInfo();  
import static org.opensearch.search.aggregations.AggregationBuilders.topHits;  
            assertThat(tagsBreakdown.get(REDUCE), equalTo(0L));
                            topHitsFetch2 = result; // Keep first instance for validation  
            if (termsAggResult.getMaxSliceTime() != null) {  
            .addAggregation(
            assertThat(histoAggResult.getQueryName(), equalTo("NumericHistogramAggregator"));
            if (avgAggResult.getMaxSliceTime() != null) {  
    private void assertRemapTermsDebugInfo(ProfileResult termsAggResult) {
            Map<String, Long> histoBreakdown = histoAggResult.getTimeBreakdown();
            assertThat(histoBreakdown.get(INITIALIZE), greaterThan(0L));
            assertThat(avgAggResult, notNullValue());
            assertThat(diversifyAggResult.getTime(), greaterThan(0L));
        "max_" + REDUCE,
                    assertEquals(0, queryProfileShardResult.getQueryResults().get(0).getProfiledChildren().size());
                    assertEquals("aggregation_global", queryProfileShardResult.getCollectorResult().getReason());
            assertThat(stringsBreakdown.get(INITIALIZE), greaterThan(0L));  
                    .subAggregation(
                assertNotNull(topHitsFetch2.getTimeBreakdown());
            assertThat(avgBreakdown.get(COLLECT), greaterThan(0L));  
            if (histoAggResult.getMaxSliceTime() != null) {
import static org.hamcrest.Matchers.is;
            assertThat(maxAggResult.getTime(), greaterThan(0L));  
            List<QueryProfileShardResult> queryProfilerResults = profileShardResult.getQueryProfileResults();  
            assertThat(avgBreakdown.get(REDUCE), equalTo(0L));  
            assertThat(maxAggResult, notNullValue());
 *
@OpenSearchIntegTestCase.SuiteScopeTestCase
            assertThat(stringsBreakdown.get(BUILD_LEAF_COLLECTOR), greaterThan(0L));
            (int) termsAggResult.getDebugInfo().get(SEGMENTS_WITH_SINGLE) + (int) termsAggResult.getDebugInfo().get(SEGMENTS_WITH_MULTI),  
                assertThat(avgBreakdown.keySet(), equalTo(CONCURRENT_SEARCH_BREAKDOWN_KEYS));  
    }  
            } else {
    private static final String BUILD_LEAF_COLLECTOR = AggregationTimingType.BUILD_LEAF_COLLECTOR.toString();
            assertThat(termsAggResult.getTime(), greaterThan(0L));  
public class AggregationProfilerIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
            assertThat(profileShardResult, notNullValue());  
            assertThat(maxAggResult, notNullValue());  
        assertThat(global, IsNull.notNullValue());
            assertThat(breakdown.get(INITIALIZE), greaterThan(0L));
                .collect(Collectors.toMap(ProfileResult::getLuceneDescription, s -> s));
        Stats stats = global.getAggregations().get("value_stats");
        String[] randomStrings = new String[randomIntBetween(2, 10)];  
            .setProfile(true)
        assertThat((long) ((InternalAggregation) global).getProperty("_count"), equalTo((long) numDocs));
                // concurrent segment search enabled
            assertThat(avgBreakdown, notNullValue());  
    private static final String STRING_FIELD = "string_field";
            assertThat(histoAggResult.getTime(), greaterThan(0L));
                assertThat(breakdown.get(INITIALIZE), greaterThan(0L));
            assertThat(avgAggResult.getDebugInfo(), equalTo(Map.of()));  
            assertThat(maxBreakdown.get(REDUCE), equalTo(0L));
            Map<String, Object> debug = histoAggResult.getDebugInfo();
                assertNotNull(topHitsFetch1.getTimeBreakdown());  
        assertThat(stats, IsNull.notNullValue());  
            assertThat(avgBreakdown.get(BUILD_AGGREGATION), greaterThan(0L));
            assertThat(avgAggResult.getTime(), greaterThan(0L));  
        assertThat(collectorResult.getCollectorResult().getReduceTime(), greaterThan(0L));  
            assertThat(termsAggResult.getProfiledChildren().size(), equalTo(1));
            AggregationProfileShardResult aggProfileResults = profileShardResult.getAggregationProfileResults();  
            assertThat(maxAggResult.getQueryName(), equalTo("MaxAggregator"));
                    // concurrent segment search enabled  
            } else {
            assertThat(stringsAggResult.getProfiledChildren().size(), equalTo(3));
    public static Collection<Object[]> parameters() {  
                    )  
            assertThat(avgAggResult, notNullValue());
            assertThat(termsBreakdown.get(REDUCE), equalTo(0L));
        assertThat(profileResults, notNullValue());
                } else {  
                // concurrent segment search enabled
                } else if (queryProfileShardResult.getQueryResults().get(0).getQueryName().equals("ConstantScoreQuery")) {
        assertThat(profileResults.size(), equalTo(getNumShards("idx").numPrimaries));  
        SearchResponse response = client().prepareSearch("idx")
                    assertTrue("LOAD_SOURCE timing should be present", breakdown.containsKey("load_source"));
            Map<String, ProfileResult> histoAggResultSubAggregations = histoAggResult.getProfiledChildren()
            assertThat(maxBreakdown.get(BUILD_AGGREGATION), greaterThan(0L));
                    assertTrue("BUILD_SUB_PHASE_PROCESSORS timing should be present", breakdown.containsKey("build_sub_phase_processors"));
        assertSearchResponse(response);
                        }
        "avg_" + INITIALIZE,
            ProfileResult stringsAggResult = histoAggResultSubAggregations.get("strings");  
            assertThat(aggProfileResults, notNullValue());
                        }
        COLLECT,
        POST_COLLECTION,
        REDUCE,
            assertThat(maxBreakdown.get(BUILD_AGGREGATION), greaterThan(0L));
                assertThat(breakdown.keySet(), equalTo(BREAKDOWN_KEYS));
 * license agreements. See the NOTICE file distributed with
                assertEquals(BREAKDOWN_KEYS, breakdown.keySet());  
        Map<String, ProfileShardResult> profileResults = response.getProfileResults();  
        assertTrue("Should have at least one shard with documents", shardsWithDocuments > 0);  
                assertEquals("Top hits fetch should have 1 child (FetchSourcePhase)", 1, topHitsFetch2.getProfiledChildren().size());
    private static final String BUILD_AGGREGATION = AggregationTimingType.BUILD_AGGREGATION.toString();
import java.util.Set;  
            assertThat(aggProfileResults, notNullValue());
        assertThat(profileResults, notNullValue());  
                            .field(STRING_FIELD, randomFrom(randomStrings))
            assertThat(maxBreakdown.get(COLLECT), greaterThan(0L));
            assertThat(stringsBreakdown.get(POST_COLLECTION), greaterThan(0L));  
            .setProfile(true)
            ProfileResult avgAggResult = termsAggResult.getProfiledChildren().get(0);
import org.opensearch.search.aggregations.InternalAggregation;  
        assertNotNull("Profile results should not be null", profileResults);
            assertThat(tagsBreakdown.get(POST_COLLECTION), greaterThan(0L));
                assertThat(diversifyBreakdown.keySet(), equalTo(CONCURRENT_SEARCH_BREAKDOWN_KEYS));
                // concurrent segment search enabled  
            assertThat(collectorResult.getCollectorResult().getProfiledChildren().get(1).getReason(), equalTo(REASON_AGGREGATION));
        }  
            assertThat(histoAggResult.getQueryName(), equalTo("NumericHistogramAggregator"));
            Map<String, Long> diversifyBreakdown = diversifyAggResult.getTimeBreakdown();  
                assertThat(termsBreakdown.keySet(), equalTo(BREAKDOWN_KEYS));
            .get();
    }  
            assertThat(avgBreakdown.get(INITIALIZE), greaterThan(0L));  
            avgBreakdown = avgAggResult.getTimeBreakdown();
        assertEquals(
    private static final String SEGMENTS_WITH_SINGLE = "segments_with_single_valued_ords";  
                            .subAggregation(
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        assertThat(profileResults.size(), equalTo(getNumShards("idx").numPrimaries));
    }
        "max_" + BUILD_LEAF_COLLECTOR + "_count",
                            .field(TAG_FIELD)
            assertThat(avgAggResult, notNullValue());
            .get();
                assertThat(histoAggResult.getQueryName(), equalTo("NumericHistogramAggregator"));
            assertThat(tagsBreakdown.get(POST_COLLECTION), greaterThan(0L));
            assertThat(avgBreakdown.get(BUILD_AGGREGATION), greaterThan(0L));
            assertThat(((Number) histoDebugInfo.get(TOTAL_BUCKETS)).longValue(), greaterThan(0L));
    private static final String TAG_FIELD = "tag";
            assertThat(avgBreakdown, notNullValue());
    private static final String POST_COLLECTION = AggregationTimingType.POST_COLLECTION.toString();  
                assertTrue("Should contain aggregation name", topHitsFetch1.getQueryName().contains("top_hits_agg1"));
            assertThat(tagsAggResult.getProfiledChildren().size(), equalTo(2));  
            assertThat(maxBreakdown.get(BUILD_LEAF_COLLECTOR), greaterThan(0L));
        "max_" + POST_COLLECTION,
            if (histoAggResult.getMaxSliceTime() != null) {
                assertThat(termsBreakdown.keySet(), equalTo(CONCURRENT_SEARCH_BREAKDOWN_KEYS));
            assertThat(maxBreakdown.get(INITIALIZE), greaterThan(0L));  
    @Override  
    public void testMultiLevelProfile() {  
                for (ProfileResult result : fetchProfileResults) {
                assertThat(diversifyBreakdown.keySet(), equalTo(BREAKDOWN_KEYS));  
        "avg_" + BUILD_LEAF_COLLECTOR + "_count",  
                // concurrent segment search enabled
                .collect(Collectors.toMap(ProfileResult::getLuceneDescription, s -> s));
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
import org.opensearch.search.aggregations.BucketOrder;
            client().admin()  
    private static final String COLLECTION_STRAT = "collection_strategy";  
                assertThat(breakdown.get(BUILD_AGGREGATION).longValue(), greaterThan(0L));
            } else {  
            assertEquals(0, breakdown.get(REDUCE).intValue());
            assertThat(histoAggResult.getProfiledChildren().size(), equalTo(1));
            assertThat(breakdown.get(REDUCE), equalTo(0L));
            assertThat(avgAggResult.getProfiledChildren().size(), equalTo(0));  
            assertThat(tagsBreakdown.get(BUILD_LEAF_COLLECTOR), greaterThan(0L));  
        }
            assertThat(termsBreakdown.get(COLLECT), greaterThan(0L));  
        assertThat(termsAggResult.getDebugInfo(), hasEntry(COLLECTION_STRAT, "remap"));  
            assertThat(histoAggResult.getQueryName(), equalTo("NumericHistogramAggregator"));
            assertThat(avgBreakdown.get(POST_COLLECTION), greaterThan(0L));  
                    assertThat(breakdown.keySet(), equalTo(CONCURRENT_SEARCH_BREAKDOWN_KEYS));
                for (QueryProfileShardResult collectorResult : profileShardResult.getQueryProfileResults()) {
                assertThat(histoBreakdown.keySet(), equalTo(BREAKDOWN_KEYS));
                }
            assertThat(avgBreakdown.get(POST_COLLECTION), greaterThan(0L));
            Map<String, Long> termsBreakdown = termsAggResult.getTimeBreakdown();  
            Map<String, Long> breakdown = histoAggResult.getTimeBreakdown();
        assertThat(collectorResult.getCollectorResult().getAvgSliceTime(), lessThanOrEqualTo(nodeTime));
        indexRandom(true, false, builders);  
            assertThat(termsBreakdown.get(INITIALIZE), greaterThan(0L));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .addAggregation(
                        terms("tags").field(TAG_FIELD)  
            }
                    }  
                }
        assertThat(profileResults.size(), equalTo(getNumShards("idx").numPrimaries));  
        Map<String, ProfileShardResult> profileResults = response.getProfileResults();  
        assertThat(collectorResult.getCollectorResult().getMaxSliceTime(), lessThanOrEqualTo(nodeTime));  
        boolean profileEnabled = true;
            if (avgAggResult.getMaxSliceTime() != null) {
            Map<String, Long> tagsBreakdown = tagsAggResult.getTimeBreakdown();  
            assertThat(histoBreakdown.get(REDUCE), equalTo(0L));
            assertThat(avgBreakdown, notNullValue());
        "avg_" + REDUCE,
                    assertEquals(0, queryProfileShardResult.getCollectorResult().getProfiledChildren().size());
                assertThat(tagsBreakdown.keySet(), equalTo(BREAKDOWN_KEYS));  
            )
            )
                    if ("fetch".equals(result.getQueryName())) {  
                assertNotNull("Should have top_hits_agg2 fetch operation", topHitsFetch2);
/*  
            assertThat(histoBreakdown.get(INITIALIZE), greaterThan(0L));
            if (avgAggResult.getMaxSliceTime() != null) {
            assertThat(avgBreakdown.get(BUILD_AGGREGATION), greaterThan(0L));
            ProfileResult termsAggResult = histoAggResult.getProfiledChildren().get(0);
            tagsAggResultSubAggregations = tagsAggResult.getProfiledChildren()
            AggregationProfileShardResult aggProfileResults = profileShardResult.getAggregationProfileResults();  
            .addAggregation(topHits("top_hits_agg2").size(1).sort(SortBuilders.fieldSort(NUMBER_FIELD).order(SortOrder.DESC)))
import org.opensearch.search.profile.fetch.FetchProfileShardResult;
 * not use this file except in compliance with the License.
import java.util.Collection;  
            }  
            assertThat(tagsAggResult.getTime(), greaterThan(0L));
            if (tagsAggResult.getMaxSliceTime() != null) {
                        terms("terms").collectMode(SubAggCollectionMode.BREADTH_FIRST)  
    public void testMultipleAggregationsProfile() {  
        assertSearchResponse(response);  
            assertThat(histoBreakdown.get(BUILD_LEAF_COLLECTOR), greaterThan(0L));
            builders.add(  
            assertThat(histoDebugInfo.keySet(), equalTo(Set.of(TOTAL_BUCKETS)));
            assertThat(maxAggResult.getTime(), greaterThan(0L));  
            assertThat(histoAggResult.getProfiledChildren().size(), equalTo(1));  
            assertThat(aggProfileResultsList.size(), equalTo(2));
                    .subAggregation(
            .addAggregation(topHits("top_hits_agg1").size(1))
            .get();  
            assertThat(diversifyBreakdown, notNullValue());
            assertThat(histoAggResult, notNullValue());
        assertThat(collectorResult.getCollectorResult().getProfiledChildren().size(), equalTo(expectedChildrenCount));  
            assertThat(histoBreakdown.get(POST_COLLECTION), greaterThan(0L));
        assertThat(collectorResult.getCollectorResult().getSliceCount(), greaterThanOrEqualTo(1));
                assertThat(avgBreakdown.keySet(), equalTo(BREAKDOWN_KEYS));  
            assertThat(avgBreakdown.get(POST_COLLECTION), greaterThan(0L));  
            Map<String, Long> avgBreakdown = avgAggResult.getTimeBreakdown();
            assertThat(histoBreakdown.get(BUILD_AGGREGATION), greaterThan(0L));
        }
                // concurrent segment search enabled
            List<ProfileResult> aggProfileResultsList = aggProfileResults.getProfileResults();
            } else {  
            assertThat(histoAggResult.getTime(), greaterThan(0L));
                // Verify we have the expected aggregations (concurrent search may create multiple instances)  
                assertThat(maxBreakdown.keySet(), equalTo(CONCURRENT_SEARCH_BREAKDOWN_KEYS));
        return 1;  
    public void testDiversifiedAggProfile() {
            AggregationProfileShardResult aggProfileResults = profileShardResult.getAggregationProfileResults();
        assertThat(stats.getName(), equalTo("value_stats"));
            assertThat(avgAggResult.getTime(), greaterThan(0L));
        "max_" + INITIALIZE,
                assertThat(maxBreakdown.keySet(), equalTo(BREAKDOWN_KEYS));
            )
                int mainFetchCount = 0;
                        topHitsAgg2Count++;
                            .subAggregation(avg("avg").field(NUMBER_FIELD))  
                client().prepareIndex("idx")
        assertThat(profileResults, notNullValue());
    private static final String INITIALIZE = AggregationTimingType.INITIALIZE.toString();
            assertThat(maxAggResult, notNullValue());
            assertThat(histoAggResult.getQueryName(), equalTo("NumericHistogramAggregator"));
            assertThat(histoBreakdown.get(COLLECT), greaterThan(0L));  
        assertThat((Stats) ((InternalAggregation) global).getProperty("value_stats"), sameInstance(stats));
    }  
                            .field(TAG_FIELD, randomBoolean() ? "more" : "less")  
                                    .subAggregation(max("max").field(NUMBER_FIELD))
        BUILD_AGGREGATION + "_count",  
            assertThat(tagsAggResult.getQueryName(), equalTo(GlobalOrdinalsStringTermsAggregator.class.getSimpleName()));
/*  
        int shardsWithDocuments = 0;
            assertThat(tagsBreakdown, notNullValue());
                int topHitsAgg2Count = 0;
                            .subAggregation(max("max").field(NUMBER_FIELD))
            assertRemapTermsDebugInfo(termsAggResult);
            ProfileResult maxAggResult = tagsAggResultSubAggregations.get("max");  
                assertTrue("Should be top_hits aggregation fetch", topHitsFetch2.getQueryName().startsWith("fetch_top_hits_aggregation"));
            assertThat(histoBreakdown.get(REDUCE), equalTo(0L));  
        }
                        "CREATE_STORED_FIELDS_VISITOR timing should be present",
                shardsWithDocuments++;
            ProfileResult avgAggResult = tagsAggResultSubAggregations.get("avg");  
        assertThat(profileResults.size(), equalTo(getNumShards("idx").numPrimaries));
            Map<String, Object> histoDebugInfo = histoAggResult.getDebugInfo();
            for (QueryProfileShardResult queryProfilerResult : queryProfilerResults) {
import org.opensearch.search.profile.ProfileResult;
            if (maxAggResult.getMaxSliceTime() != null) {  
import org.opensearch.search.aggregations.bucket.sampler.DiversifiedOrdinalsSamplerAggregator;
            assertThat(maxBreakdown.get(REDUCE), equalTo(0L));
            assertThat(stringsAggResult.getTime(), greaterThan(0L));  
    }  
        "max_" + BUILD_LEAF_COLLECTOR,  
        for (int i = 0; i < numDocs; i++) {
            }  
            assertEquals(queryProfileShardResults.size(), 2);  
import org.hamcrest.core.IsNull;
            assertThat(termsBreakdown.get(REDUCE), equalTo(0L));  
            assertThat(avgAggResult.getQueryName(), equalTo("AvgAggregator"));  
import java.util.stream.Collectors;
                assertThat(avgBreakdown.keySet(), equalTo(CONCURRENT_SEARCH_BREAKDOWN_KEYS));
            assertThat(avgAggResult.getProfiledChildren().size(), equalTo(0));
            assertThat(avgAggResult.getProfiledChildren().size(), equalTo(0));
            .get();  
            assertThat(termsBreakdown, notNullValue());
            assertThat(tagsAggResult, notNullValue());  
        createIndex("idx_unmapped");
import static org.hamcrest.Matchers.sameInstance;
                                    .subAggregation(avg("avg").field(NUMBER_FIELD))
                    assertCollectorResult(collectorResult, 2);
            } else {
        assertThat(profileResults.size(), equalTo(getNumShards("idx").numPrimaries));  
        "min_" + BUILD_AGGREGATION,  
            assertThat(((Number) histoDebugInfo.get(TOTAL_BUCKETS)).longValue(), greaterThan(0L));
                        topHitsAgg1Count++;  
 * KIND, either express or implied.  See the License for the
            assertThat(termsBreakdown, notNullValue());
            assertThat(histoDebugInfo, notNullValue());  
            assertThat(maxBreakdown, notNullValue());  
                            )  
            assertThat(profileShardResult, notNullValue());
        }
    @ParametersFactory
 */  
            assertThat(aggProfileResultsList, notNullValue());
            assertThat(aggProfileResultsList.size(), equalTo(1));  
            assertThat(breakdown.get(INITIALIZE), greaterThan(0L));
            assertThat(maxAggResult.getTime(), greaterThan(0L));  
 *  
            tagsBreakdown = tagsAggResult.getTimeBreakdown();  
            Map<String, Long> termsBreakdown = termsAggResult.getTimeBreakdown();
 * GitHub history for details.
                    .subAggregation(
                    )
            assertThat(stringsBreakdown.get(COLLECT), greaterThan(0L));
            } else {
                }
            }
                assertThat(histoAggResult.getTime(), greaterThan(0L));
            }
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;
        BUILD_LEAF_COLLECTOR,  
            List<ProfileResult> aggProfileResultsList = aggProfileResults.getProfileResults();  
        "avg_" + COLLECT,
            assertThat(termsBreakdown.get(COLLECT), greaterThan(0L));
                assertEquals("FetchSourcePhase", topHitsFetch1.getProfiledChildren().get(0).getQueryName());
            assertThat(tagsAggResult, notNullValue());
            ProfileResult avgAggResult = termsAggResult.getProfiledChildren().get(0);  
            assertThat(maxBreakdown.get(POST_COLLECTION), greaterThan(0L));  
                assertTrue("Should have at least 3 total fetch operations", fetchProfileResults.size() >= 3);
        }
            Map<String, Long> histoBreakdown = histoAggResult.getTimeBreakdown();
            assertThat(avgAggResult.getProfiledChildren().size(), equalTo(0));
            assertThat(histoBreakdown.get(BUILD_AGGREGATION), greaterThan(0L));
        COLLECT + "_count",
            .addAggregation(
            assertRemapTermsDebugInfo(termsAggResult);  
        Map<String, ProfileShardResult> profileResults = response.getProfileResults();
            if (maxAggResult.getMaxSliceTime() != null) {
            avgAggResult = tagsAggResultSubAggregations.get("avg");  
            .get();
            } else {
            assertThat(histoBreakdown, notNullValue());  
import static org.hamcrest.Matchers.containsString;  
                        terms("strings").field(STRING_FIELD)
            List<QueryProfileShardResult> queryProfileShardResults = profileShardResult.getQueryProfileResults();
            ProfileResult globalAggResult = aggProfileResultsList.get(0);  
    protected int numberOfShards() {
            assertThat(histoAggResult.getProfiledChildren().size(), equalTo(0));  
            assertThat(diversifyAggResult.getLuceneDescription(), equalTo("diversify"));
            assertThat(termsAggResult, notNullValue());  
        "min_" + COLLECT + "_count",
                    assertCollectorResult(collectorResult, 2);
                // concurrent segment search enabled
                // concurrent segment search enabled
            assertThat(aggProfileResultsList, notNullValue());
    public void testSimpleProfile() {
                            .order(BucketOrder.aggregation("avg", false))
            ProfileResult tagsAggResult = histoAggResultSubAggregations.get("tags");
            assertThat(avgBreakdown.get(BUILD_AGGREGATION), greaterThan(0L));
                    assertCollectorResult(collectorResult, 2);  
                if (histoAggResult.getMaxSliceTime() != null) {
import org.opensearch.action.index.IndexRequestBuilder;  
import static org.hamcrest.Matchers.lessThanOrEqualTo;  
            assertThat(breakdown, notNullValue());  
                    .interval(1L)
import static org.opensearch.search.aggregations.AggregationBuilders.diversifiedSampler;  
            assertThat(avgBreakdown.get(COLLECT), greaterThan(0L));
                List<CollectorResult> children = collectorResult.getProfiledChildren();  
    public void testComplexProfile() {
    public void testNoProfile() {
                    assertThat(breakdown.keySet(), equalTo(BREAKDOWN_KEYS));  
            assertThat(stringsBreakdown, notNullValue());
                                    .subAggregation(avg("avg").field(NUMBER_FIELD))
            assertThat(stringsBreakdown.get(REDUCE), equalTo(0L));
            assertThat(diversifyAggResult, notNullValue());
                    assertTrue(
                assertThat(tagsBreakdown.keySet(), equalTo(CONCURRENT_SEARCH_BREAKDOWN_KEYS));
            assertThat(diversifyBreakdown.get(POST_COLLECTION), greaterThan(0L));
            assertThat(histoAggResult.getTime(), greaterThan(0L));  
            .addAggregation(  
        assertAcked(
            assertThat(diversifyAggResult.getDebugInfo(), equalTo(Map.of(DEFERRED, List.of("max"))));
                .stream()
 */  
            .setProfile(true)
import org.opensearch.search.aggregations.bucket.global.Global;
            assertThat(avgAggResult, notNullValue());
            }
            assertThat(maxAggResult.getQueryName(), equalTo("MaxAggregator"));  
            assertThat(maxBreakdown.get(INITIALIZE), greaterThan(0L));
import java.util.Map;
            .get();  
            assertThat(histoDebugInfo, notNullValue());
        for (ProfileShardResult profileShardResult : profileResults.values()) {
    );
 * this file be licensed under the Apache-2.0 license or a
                // concurrent segment search enabled
 * Licensed to Elasticsearch under one or more contributor  
            assertThat(maxBreakdown.get(COLLECT), greaterThan(0L));
            assertThat(maxBreakdown.get(BUILD_LEAF_COLLECTOR), greaterThan(0L));
            assertThat(maxAggResult.getDebugInfo(), equalTo(Map.of()));  
                }
            Map<String, ProfileResult> tagsAggResultSubAggregations = tagsAggResult.getProfiledChildren()
import static org.hamcrest.Matchers.hasEntry;
import org.opensearch.test.OpenSearchIntegTestCase;  
            assertThat(maxBreakdown.get(REDUCE), equalTo(0L));
        Map<String, ProfileShardResult> profileResults = response.getProfileResults();
                assertThat(maxBreakdown.keySet(), equalTo(CONCURRENT_SEARCH_BREAKDOWN_KEYS));
            } else {  
            }
        assertThat(profileResults, notNullValue());
            for (ProfileResult histoAggResult : aggProfileResultsList) {  
            ProfileResult diversifyAggResult = aggProfileResultsList.get(0);
            assertThat(tagsAggResult.getLuceneDescription(), equalTo("tags"));
        for (ProfileShardResult shardResult : profileResults.values()) {
        INITIALIZE + "_count",
            if (avgAggResult.getMaxSliceTime() != null) {
import static org.opensearch.search.aggregations.AggregationBuilders.global;
            .addAggregation(histogram("histo").field(NUMBER_FIELD).interval(1L))
            .setQuery(QueryBuilders.matchAllQuery())  
            .addAggregation(histogram("histo_2").field(NUMBER_FIELD).interval(1L))
            if (histoAggResult.getMaxSliceTime() != null) {  
 * specific language governing permissions and limitations
        assertThat(collectorResult.getCollectorResult().getReduceTime(), equalTo(0L));
        SearchResponse response = client().prepareSearch("idx")
            assertThat(tagsBreakdown.get(BUILD_LEAF_COLLECTOR), greaterThan(0L));  
    public AggregationProfilerIT(Settings staticSettings) {
                diversifiedSampler("diversify").shardSize(10)
            assertThat(diversifyAggResult.getQueryName(), equalTo(DiversifiedOrdinalsSamplerAggregator.class.getSimpleName()));  
import org.opensearch.search.sort.SortOrder;
        Map<String, ProfileShardResult> profileResults = response.getProfileResults();
            if (diversifyAggResult.getMaxSliceTime() != null) {
            assertThat(maxBreakdown.get(POST_COLLECTION), greaterThan(0L));
            assertThat(collectorResult.getCollectorResult().getProfiledChildren().get(0).getReason(), equalTo(REASON_SEARCH_TOP_HITS));
                    .field(STRING_FIELD)  
import static org.hamcrest.Matchers.equalTo;
                    fail("unexpected profile shard result in the response");
            assertThat(histoAggResult.getTime(), greaterThan(0L));
            List<ProfileResult> aggProfileResultsList = aggProfileResults.getProfileResults();  
            assertThat(tagsAggResult.getTime(), greaterThan(0L));
                List<ProfileResult> fetchProfileResults = fetchProfileResult.getFetchProfileResults();
                    } else if (result.getQueryName().contains("top_hits_agg2")) {
                    assertCollectorResult(collectorResult, 2);
        assertThat(collectorResult.getCollectorResult().getAvgSliceTime(), equalTo(nodeTime));  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
                    assertCollectorResultWithConcurrentSearchEnabled(collectorResult, 0);  
        "max_" + COLLECT,
        SearchResponse response = client().prepareSearch("idx")
            ProfileResult termsAggResult = histoAggResult.getProfiledChildren().get(0);
                if (queryProfileShardResult.getQueryResults().get(0).getQueryName().equals("MatchAllDocsQuery")) {
                // concurrent segment search enabled
                }
                for (QueryProfileShardResult collectorResult : profileShardResult.getQueryProfileResults()) {
        assertSearchResponse(response);
        "avg_" + BUILD_AGGREGATION,  
            assertThat(breakdown, notNullValue());
    }
            assertThat(tagsBreakdown.get(COLLECT), greaterThan(0L));
            .get();
            assertThat(diversifyBreakdown.get(BUILD_AGGREGATION), greaterThan(0L));  
        SearchResponse response = client().prepareSearch("idx")  
                int topHitsAgg1Count = 0;  
            assertThat(aggProfileResultsList.size(), equalTo(1));
            assertThat(histoDebugInfo, notNullValue());
        assertSearchResponse(response);
        );  
            assertThat(aggProfileResults, notNullValue());
            } else {  
    private static final String REASON_SEARCH_TOP_HITS = "search_top_hits";
            assertThat(histoBreakdown.get(COLLECT), greaterThan(0L));
 * compatible open source license.
            assertThat(maxBreakdown.get(BUILD_AGGREGATION), greaterThan(0L));
            assertThat(stringsAggResult, notNullValue());
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        SearchResponse response = client().prepareSearch("idx")
            assertThat(avgAggResult.getTime(), greaterThan(0L));
            assertThat(tagsAggResult.getProfiledChildren().size(), equalTo(2));  
            assertThat(histoBreakdown, notNullValue());
            maxBreakdown = maxAggResult.getTimeBreakdown();
                assertThat(maxBreakdown.keySet(), equalTo(BREAKDOWN_KEYS));
        assertSearchResponse(response);  
        for (ProfileShardResult profileShardResult : profileResults.values()) {
        for (ProfileShardResult profileShardResult : profileResults.values()) {
                assertThat(breakdown.get(REDUCE), equalTo(0L));
        assertThat(collectorResult.getCollectorResult().getProfiledChildren().size(), equalTo(expectedChildrenCount));
                histogram("histo").field(NUMBER_FIELD)  
        return Arrays.asList(
            assertThat(avgBreakdown.get(INITIALIZE), greaterThan(0L));
                    )
                        jsonBuilder().startObject()  
import static org.hamcrest.Matchers.notNullValue;
            assertThat(histoAggResult.getLuceneDescription(), equalTo("histo"));
        }
        POST_COLLECTION,
                // concurrent segment search enabled  
                            .subAggregation(avg("avg").field(NUMBER_FIELD))  
            assertThat(diversifyBreakdown.get(COLLECT), greaterThan(0L));
                // concurrent segment search enabled
            }
            randomStrings[i] = randomAlphaOfLength(10);
            assertThat(avgBreakdown.get(BUILD_LEAF_COLLECTOR), greaterThan(0L));
                    .subAggregation(  
 * SPDX-License-Identifier: Apache-2.0
            assertThat(histoBreakdown.get(BUILD_AGGREGATION), greaterThan(0L));  
                assertEquals(queryProfileShardResult.getQueryResults().size(), 1);  
    }
                                    .subAggregation(max("max").field(NUMBER_FIELD))
                // concurrent segment search enabled  
                assertThat(avgBreakdown.keySet(), equalTo(BREAKDOWN_KEYS));
 * this work for additional information regarding copyright
            ProfileResult histoAggResult = aggProfileResultsList.get(0);  
    public void testTopHitsAggregationFetchProfiling() throws Exception {  
    }
            assertThat(avgAggResult.getDebugInfo(), equalTo(Map.of()));  
            }
    private static final String HAS_FILTER = "has_filter";
                for (QueryProfileShardResult collectorResult : profileShardResult.getQueryProfileResults()) {
        BUILD_LEAF_COLLECTOR + "_count",  
        "avg_" + COLLECT + "_count"
            } else {
                assertThat(children.size(), equalTo(2));
import org.opensearch.index.query.QueryBuilders;  
                .prepareCreate("idx")
        for (ProfileShardResult profileShardResult : profileResults.values()) {  
        "min_" + BUILD_LEAF_COLLECTOR,  
        }
                shardsWithCorrectProfile++;
            assertThat(diversifyBreakdown.get(POST_COLLECTION), greaterThan(0L));  
            assertThat(breakdown.get(BUILD_AGGREGATION).longValue(), greaterThan(0L));
            AggregationProfileShardResult aggProfileResults = profileShardResult.getAggregationProfileResults();
                .stream()  
            .setProfile(profileEnabled)
            assertThat(aggProfileResultsList, notNullValue());
            shardsWithCorrectProfile
            shardsWithDocuments,  
            if (fetchProfileResult != null && !fetchProfileResult.getFetchProfileResults().isEmpty()) {  
                        if (topHitsFetch1 == null) {  
                // concurrent segment search enabled  
                assertThat(breakdown.keySet(), equalTo(CONCURRENT_SEARCH_BREAKDOWN_KEYS));  
            } else {  
            )
            assertThat(maxAggResult.getProfiledChildren().size(), equalTo(0));
            assertThat(avgBreakdown.get(INITIALIZE), greaterThan(0L));  
                    .interval(1L)
        SearchResponse response = client().prepareSearch("idx")  
            assertThat(termsBreakdown.get(BUILD_AGGREGATION), greaterThan(0L));
import org.opensearch.search.aggregations.metrics.Stats;
            assertThat(termsAggResult.getProfiledChildren().size(), equalTo(1));
                            .subAggregation(max("max").field(NUMBER_FIELD))
            }
                }  
        int shardsWithCorrectProfile = 0;
            assertThat(maxAggResult.getProfiledChildren().size(), equalTo(0));
            // ensure there is no multi collector getting added with only global agg
            assertThat(aggProfileResultsList.size(), equalTo(1));
                }
import org.opensearch.search.aggregations.bucket.terms.GlobalOrdinalsStringTermsAggregator;  
            Map<String, Object> histoDebugInfo = histoAggResult.getDebugInfo();
                assertThat(avgBreakdown.keySet(), equalTo(BREAKDOWN_KEYS));
            assertThat(avgBreakdown.get(INITIALIZE), greaterThan(0L));
                assertNotNull("Should have top_hits_agg1 fetch operation", topHitsFetch1);  
    private static final String TOTAL_BUCKETS = "total_buckets";
                            .subAggregation(avg("avg").field(NUMBER_FIELD))
                        mainFetchCount++;
        SearchResponse response = client().prepareSearch("idx")
        assertThat(global.getAggregations().asList().isEmpty(), is(false));
            assertThat(tagsBreakdown.get(BUILD_AGGREGATION), greaterThan(0L));  
        assertThat(termsAggResult.getDebugInfo(), hasEntry(RESULT_STRAT, "terms"));
        }  
            assertThat(termsBreakdown.get(BUILD_AGGREGATION), greaterThan(0L));
        "avg_" + BUILD_LEAF_COLLECTOR,  
        }  
            assertThat(tagsBreakdown.get(REDUCE), equalTo(0L));
            Map<String, Object> histoDebugInfo = histoAggResult.getDebugInfo();
                }
            assertThat(maxAggResult.getProfiledChildren().size(), equalTo(0));
            assertThat(histoAggResult, notNullValue());  
            assertThat(histoDebugInfo.keySet(), equalTo(Set.of(TOTAL_BUCKETS)));  
                assertThat(tagsBreakdown.keySet(), equalTo(CONCURRENT_SEARCH_BREAKDOWN_KEYS));
        assertSearchResponse(response);
                assertThat(histoAggResult, notNullValue());
            assertThat(avgAggResult.getQueryName(), equalTo("AvgAggregator"));
        Global global = response.getAggregations().get("global");  
            .get();  
                }
                assertThat(breakdown, notNullValue());
                // concurrent segment search enabled
            assertThat(profileShardResult, notNullValue());
            .addAggregation(global("global").subAggregation(stats("value_stats").field(NUMBER_FIELD)))
        for (ProfileShardResult profileShardResult : profileResults.values()) {
            assertThat(avgAggResult.getTime(), greaterThan(0L));  
        "avg_" + POST_COLLECTION,
            assertThat(avgAggResult.getQueryName(), equalTo("AvgAggregator"));
    private static final String REDUCE = AggregationTimingType.REDUCE.toString();  
            assertThat(maxBreakdown, notNullValue());
            assertThat(stringsBreakdown.get(BUILD_AGGREGATION), greaterThan(0L));
import org.opensearch.search.sort.SortBuilders;
            List<ProfileResult> aggProfileResultsList = aggProfileResults.getProfileResults();  
                .get()
            }
            List<ProfileResult> aggProfileResultsList = aggProfileResults.getProfileResults();  
    private static final Set<String> CONCURRENT_SEARCH_BREAKDOWN_KEYS = Set.of(
            assertEquals("global", globalAggResult.getLuceneDescription());  
                assertTrue("Should have at least one main fetch operation", mainFetchCount >= 1);  
            assertThat(termsAggResult.getQueryName(), equalTo(GlobalOrdinalsStringTermsAggregator.class.getSimpleName()));
            assertThat(histoAggResult, notNullValue());
                        terms("terms").field(TAG_FIELD)
            assertThat(histoBreakdown.get(REDUCE), equalTo(0L));  
                assertThat(stringsBreakdown.keySet(), equalTo(CONCURRENT_SEARCH_BREAKDOWN_KEYS));
        INITIALIZE,
    private static final String REASON_AGGREGATION = "aggregation";
        "min_" + COLLECT,
                        assertCollectorResult(collectorResult, 2);
        SearchResponse response = client().prepareSearch("idx")  
                assertThat(histoBreakdown.keySet(), equalTo(CONCURRENT_SEARCH_BREAKDOWN_KEYS));  
            } else {
                            )  
            assertThat(profileShardResult, notNullValue());
        assertThat(profileResults.size(), equalTo(getNumShards("idx").numPrimaries));
            greaterThan(0)
                    .subAggregation(max("max").field(NUMBER_FIELD))
        REDUCE + "_count",
            assertThat(aggProfileResultsList, notNullValue());
                            .field(NUMBER_FIELD, randomIntBetween(0, 9))
        BUILD_AGGREGATION + "_count",  
            }  
        "min_" + BUILD_LEAF_COLLECTOR + "_count",
            avgAggResult = stringsAggResultSubAggregations.get("avg");
                // concurrent segment search enabled  
            }  
                    assertCollectorResultWithConcurrentSearchEnabled(collectorResult, 2);
            }  
            }
            assertRemapTermsDebugInfo(stringsAggResult);  
            assertThat(diversifyBreakdown.get(BUILD_LEAF_COLLECTOR), greaterThan(0L));
            assertThat(maxBreakdown.get(BUILD_LEAF_COLLECTOR), greaterThan(0L));
        "min_" + POST_COLLECTION,
            }  
            assertThat(histoAggResult, notNullValue());  
            assertThat(tagsBreakdown.get(BUILD_AGGREGATION), greaterThan(0L));  
                        breakdown.containsKey("create_stored_fields_visitor")  
                // concurrent segment search enabled
