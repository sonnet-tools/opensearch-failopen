            Map<String, Long> histoBreakdown = histoAggResult.getTimeBreakdown();
        REDUCE + "_start_time"
            (int) termsAggResult.getDebugInfo().get(SEGMENTS_WITH_SINGLE) + (int) termsAggResult.getDebugInfo().get(SEGMENTS_WITH_MULTI),
                            .subAggregation(avg("avg").field(NUMBER_FIELD))
            assertThat(termsAggResult, notNullValue());
                assertThat(avgBreakdown.keySet(), equalTo(CONCURRENT_SEARCH_BREAKDOWN_KEYS));
            ProfileResult histoAggResult = aggProfileResultsList.get(0);
            assertThat(histoAggResult.getTime(), greaterThan(0L));
        COLLECT,
            assertThat(stringsBreakdown.get(POST_COLLECTION), greaterThan(0L));
            assertThat(breakdown.get(INITIALIZE), greaterThan(0L));
                        if (topHitsFetch1 == null) {
                for (ProfileResult result : fetchProfileResults) {
            List<QueryProfileShardResult> queryProfileShardResults = profileShardResult.getQueryProfileResults();
import org.opensearch.search.aggregations.bucket.terms.GlobalOrdinalsStringTermsAggregator;
        "max_" + INITIALIZE,
            assertThat(avgAggResult.getQueryName(), equalTo("AvgAggregator"));
            assertThat(stringsAggResult.getQueryName(), equalTo(GlobalOrdinalsStringTermsAggregator.class.getSimpleName()));
                    for (QueryProfileShardResult collectorResult : profileShardResult.getQueryProfileResults()) {
            List<ProfileResult> aggProfileResultsList = aggProfileResults.getProfileResults();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            Map<String, Long> avgBreakdown = avgAggResult.getTimeBreakdown();
    private void assertCollectorResultWithConcurrentSearchEnabled(QueryProfileShardResult collectorResult, int expectedChildrenCount) {
import org.opensearch.action.index.IndexRequestBuilder;
            assertThat(histoBreakdown.get(REDUCE), equalTo(0L));
            }
                // concurrent segment search enabled
            assertThat(histoBreakdown.get(POST_COLLECTION), greaterThan(0L));
                    )
        BUILD_LEAF_COLLECTOR + "_count",
        assertThat(profileResults.size(), equalTo(getNumShards("idx").numPrimaries));
        "avg_" + COLLECT,
    @ParametersFactory
            assertThat(stringsAggResult.getProfiledChildren().size(), equalTo(3));
            assertThat(aggProfileResultsList.size(), equalTo(1));
            assertThat(avgAggResult.getQueryName(), equalTo("AvgAggregator"));
                if (histoAggResult.getMaxSliceTime() != null) {
        Map<String, ProfileShardResult> profileResults = response.getProfileResults();
            assertThat(avgAggResult.getDebugInfo(), equalTo(Map.of()));
            List<ProfileResult> aggProfileResultsList = aggProfileResults.getProfileResults();
            if (tagsAggResult.getMaxSliceTime() != null) {
        Global global = response.getAggregations().get("global");
                                terms("tags").field(TAG_FIELD)
        return Arrays.asList(
        BUILD_AGGREGATION + "_count",
            assertThat(histoDebugInfo, notNullValue());
 *
            assertThat(((Number) histoDebugInfo.get(TOTAL_BUCKETS)).longValue(), greaterThan(0L));
import java.util.List;
                for (QueryProfileShardResult collectorResult : profileShardResult.getQueryProfileResults()) {
                    .maxDocsPerValue(2)
    }
            assertThat(histoAggResult.getProfiledChildren().size(), equalTo(0));
                        topHitsAgg1Count++;
                int mainFetchCount = 0;
        int shardsWithDocuments = 0;
import org.opensearch.test.OpenSearchIntegTestCase;
    public void testTopHitsAggregationFetchProfiling() throws Exception {
        assertThat(collectorResult.getCollectorResult().getProfiledChildren().size(), equalTo(expectedChildrenCount));
        SearchResponse response = client().prepareSearch("idx")
            assertThat(avgBreakdown.get(REDUCE), equalTo(0L));
            .setProfile(true)
            Map<String, ProfileResult> tagsAggResultSubAggregations = tagsAggResult.getProfiledChildren()
    }
                // concurrent segment search enabled
                histogram("histo").field(NUMBER_FIELD)
                .prepareCreate("idx")
        Map<String, ProfileShardResult> profileResults = response.getProfileResults();
                            .subAggregation(avg("avg").field(NUMBER_FIELD))
                for (QueryProfileShardResult collectorResult : profileShardResult.getQueryProfileResults()) {
            Map<String, ProfileResult> histoAggResultSubAggregations = histoAggResult.getProfiledChildren()
 * license agreements. See the NOTICE file distributed with
    }
    }
                assertThat(breakdown.get(INITIALIZE), greaterThan(0L));
            )
        "max_" + COLLECT + "_count",
                    Map<String, Long> breakdown = fetchResult.getTimeBreakdown();
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            assertThat(histoAggResult.getQueryName(), equalTo("NumericHistogramAggregator"));
        "min_" + POST_COLLECTION,
        SearchResponse response = client().prepareSearch("idx")
            assertThat(histoDebugInfo, notNullValue());
            assertThat(histoAggResult.getQueryName(), equalTo("NumericHistogramAggregator"));
                assertNotNull(topHitsFetch1.getTimeBreakdown());
                assertThat(maxBreakdown.keySet(), equalTo(CONCURRENT_SEARCH_BREAKDOWN_KEYS));
            Map<String, ProfileResult> stringsAggResultSubAggregations = stringsAggResult.getProfiledChildren()
        for (ProfileShardResult profileShardResult : profileResults.values()) {
            assertThat(profileShardResult, notNullValue());
            }
            }
            assertThat(histoAggResult.getLuceneDescription(), equalTo("histo"));
        assertThat(global.getDocCount(), equalTo((long) numDocs));
            assertThat(((Number) debug.get(TOTAL_BUCKETS)).longValue(), greaterThan(0L));
        assertThat(profileResults, notNullValue());
            avgBreakdown = avgAggResult.getTimeBreakdown();
                for (QueryProfileShardResult collectorResult : profileShardResult.getQueryProfileResults()) {
 * You may obtain a copy of the License at
import org.opensearch.action.search.SearchResponse;
            assertThat(maxAggResult.getLuceneDescription(), equalTo("max"));
    private static final String NUMBER_FIELD = "number";
            Map<String, Long> avgBreakdown = avgAggResult.getTimeBreakdown();
        "max_" + POST_COLLECTION,
                for (QueryProfileShardResult collectorResult : profileShardResult.getQueryProfileResults()) {
                // concurrent segment search enabled
            assertThat(aggProfileResults, notNullValue());
                    .subAggregation(
            } else {
        assertSearchResponse(response);
            assertThat(avgBreakdown.get(REDUCE), equalTo(0L));
import static org.hamcrest.Matchers.equalTo;
                assertThat(histoAggResult.getTime(), greaterThan(0L));
        assertThat(collectorResult.getCollectorResult().getSliceCount(), equalTo(1));
            assertThat(maxBreakdown, notNullValue());
            assertThat(aggProfileResults, notNullValue());
            assertThat(diversifyBreakdown.get(BUILD_LEAF_COLLECTOR), greaterThan(0L));
        "avg_" + BUILD_AGGREGATION,
            assertThat(termsAggResult.getQueryName(), equalTo(GlobalOrdinalsStringTermsAggregator.class.getSimpleName()));
            assertThat(avgBreakdown.get(INITIALIZE), greaterThan(0L));
import static org.hamcrest.Matchers.containsString;
            assertThat(maxBreakdown.get(COLLECT), greaterThan(0L));
                // concurrent segment search enabled
import org.opensearch.search.aggregations.metrics.Stats;
            assertThat(breakdown, notNullValue());
            List<ProfileResult> aggProfileResultsList = aggProfileResults.getProfileResults();
            assertThat(histoBreakdown.get(REDUCE), equalTo(0L));
        assertThat(collectorResult.getCollectorResult().getAvgSliceTime(), lessThanOrEqualTo(nodeTime));
            assertThat(queryProfilerResults, notNullValue());
                                terms("tags").field(TAG_FIELD)
            if (avgAggResult.getMaxSliceTime() != null) {
        "max_" + COLLECT,
            Map<String, Long> termsBreakdown = termsAggResult.getTimeBreakdown();
            for (QueryProfileShardResult queryProfileShardResult : queryProfileShardResults) {
        long nodeTime = collectorResult.getCollectorResult().getTime();
        SearchResponse response = client().prepareSearch("idx")
        assertThat(termsAggResult.getDebugInfo(), hasEntry(HAS_FILTER, false));
                assertTrue("Should have at least one main fetch operation", mainFetchCount >= 1);
            assertThat(aggProfileResultsList, notNullValue());
    }
                assertThat(debug.keySet(), equalTo(Set.of(TOTAL_BUCKETS)));
            assertThat(avgBreakdown.get(POST_COLLECTION), greaterThan(0L));
                        terms("terms").collectMode(SubAggCollectionMode.BREADTH_FIRST)
                    assertEquals(1, queryProfileShardResult.getQueryResults().get(0).getProfiledChildren().size());
            maxAggResult = stringsAggResultSubAggregations.get("max");
        COLLECT + "_start_time",
                assertEquals("Top hits fetch should have 1 child (FetchSourcePhase)", 1, topHitsFetch2.getProfiledChildren().size());
    }
            assertThat(maxBreakdown.get(INITIALIZE), greaterThan(0L));
                assertEquals("Top hits fetch should have 1 child (FetchSourcePhase)", 1, topHitsFetch1.getProfiledChildren().size());
        "avg_" + REDUCE,
            if (tagsAggResult.getMaxSliceTime() != null) {
                .get()
            assertRemapTermsDebugInfo(tagsAggResult);
                }
            ProfileResult maxAggResult = tagsAggResultSubAggregations.get("max");
    public void testMultiLevelProfileBreadthFirst() {
                List<ProfileResult> fetchProfileResults = fetchProfileResult.getFetchProfileResults();
        assertThat(
            assertThat(stringsBreakdown, notNullValue());
            assertThat(histoAggResult.getTime(), greaterThan(0L));
                .setMapping(STRING_FIELD, "type=keyword", NUMBER_FIELD, "type=integer", TAG_FIELD, "type=keyword")
                assertThat(avgBreakdown.keySet(), equalTo(CONCURRENT_SEARCH_BREAKDOWN_KEYS));
            assertThat(avgBreakdown.get(BUILD_AGGREGATION), greaterThan(0L));
                int topHitsAgg1Count = 0;
        assertTrue("Should have at least one shard with documents", shardsWithDocuments > 0);
    public void testDiversifiedAggProfile() {
            assertThat(maxBreakdown.get(REDUCE), equalTo(0L));
            assertThat(maxBreakdown.get(POST_COLLECTION), greaterThan(0L));
            .addAggregation(
            ProfileResult stringsAggResult = histoAggResultSubAggregations.get("strings");
            assertThat(avgAggResult.getTime(), greaterThan(0L));
            assertThat(aggProfileResultsList, notNullValue());
                assertThat(avgBreakdown.keySet(), equalTo(BREAKDOWN_KEYS));
            assertThat(tagsBreakdown.get(COLLECT), greaterThan(0L));
                assertThat(histoAggResult.getQueryName(), equalTo("NumericHistogramAggregator"));
                assertThat(((Number) debug.get(TOTAL_BUCKETS)).longValue(), greaterThan(0L));
            .setProfile(true)
        assertThat(profileResults.size(), equalTo(getNumShards("idx").numPrimaries));
            assertThat(avgAggResult.getTime(), greaterThan(0L));
                ProfileResult topHitsFetch2 = null;
            Map<String, Long> histoBreakdown = histoAggResult.getTimeBreakdown();
 * ownership. Elasticsearch licenses this file to you under
                }
        assertThat(termsAggResult.getDebugInfo(), hasEntry(COLLECTION_STRAT, "remap"));
            Map<String, Long> maxBreakdown = maxAggResult.getTimeBreakdown();
            assertThat(histoBreakdown.get(COLLECT), greaterThan(0L));
        "min_" + BUILD_AGGREGATION,
                for (QueryProfileShardResult collectorResult : profileShardResult.getQueryProfileResults()) {
            assertThat(maxAggResult.getQueryName(), equalTo("MaxAggregator"));
        for (ProfileShardResult profileShardResult : profileResults.values()) {
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        assertThat(collectorResult.getCollectorResult().getSliceCount(), greaterThanOrEqualTo(1));
            .setProfile(false)
            }
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;
                for (QueryProfileShardResult collectorResult : profileShardResult.getQueryProfileResults()) {
        assertSearchResponse(response);
import org.opensearch.search.profile.fetch.FetchProfileShardResult;
            assertThat(tagsBreakdown.get(BUILD_AGGREGATION), greaterThan(0L));
                // concurrent segment search enabled
            assertThat(breakdown.get(COLLECT), greaterThan(0L));
                            .field(NUMBER_FIELD, randomIntBetween(0, 9))
            assertThat(histoBreakdown.get(INITIALIZE), greaterThan(0L));
            assertThat(globalAggResult.getTime(), greaterThan(0L));
import static org.hamcrest.Matchers.hasEntry;
            ProfileResult globalAggResult = aggProfileResultsList.get(0);
            .addAggregation(
    public void testMultipleAggregationsProfile() {
        COLLECT + "_count",
    );
import org.opensearch.search.sort.SortBuilders;
            assertThat(histoAggResult.getLuceneDescription(), equalTo("histo"));
            assertThat(collectorResult.getCollectorResult().getProfiledChildren().get(0).getReason(), equalTo(REASON_SEARCH_TOP_HITS));
    public void testGlobalAggWithStatsSubAggregatorProfile() {
                assertTrue("Should contain aggregation name", topHitsFetch1.getQueryName().contains("top_hits_agg1"));
    private static final String REASON_AGGREGATION = "aggregation";
 * KIND, either express or implied.  See the License for the
            }
                    assertEquals(0, queryProfileShardResult.getQueryResults().get(0).getProfiledChildren().size());
        REDUCE,
            if (termsAggResult.getMaxSliceTime() != null) {
                // concurrent segment search enabled
        SearchResponse response = client().prepareSearch("idx")
            ProfileResult histoAggResult = aggProfileResultsList.get(0);
            .setProfile(true)
                }
            assertThat(avgBreakdown.get(COLLECT), greaterThan(0L));
            assertThat(termsBreakdown.get(COLLECT), greaterThan(0L));
            assertThat(profileShardResult, notNullValue());
@OpenSearchIntegTestCase.SuiteScopeTestCase
                    assertCollectorResultWithConcurrentSearchEnabled(collectorResult, 0);
        Map<String, ProfileShardResult> profileResults = response.getProfileResults();
                        }
            // ensure there is no multi collector getting added with only global agg
            assertThat(histoDebugInfo.keySet(), equalTo(Set.of(TOTAL_BUCKETS)));
                .collect(Collectors.toMap(ProfileResult::getLuceneDescription, s -> s));
            } else {
                // concurrent segment search enabled
                assertThat(breakdown.keySet(), equalTo(BREAKDOWN_KEYS));
    private static final String BUILD_LEAF_COLLECTOR = AggregationTimingType.BUILD_LEAF_COLLECTOR.toString();
            assertThat(tagsAggResult.getProfiledChildren().size(), equalTo(2));
                            .subAggregation(max("max").field(NUMBER_FIELD))
            assertThat(avgAggResult.getProfiledChildren().size(), equalTo(0));
            List<ProfileResult> aggProfileResultsList = aggProfileResults.getProfileResults();
            assertThat(aggProfileResults, notNullValue());
        COLLECT + "_count",
                assertThat(maxBreakdown.keySet(), equalTo(BREAKDOWN_KEYS));
            assertThat(avgBreakdown, notNullValue());
            assertThat(avgBreakdown, notNullValue());
                    if ("fetch".equals(result.getQueryName())) {
                .setSettings(Map.of("number_of_shards", 1, "number_of_replicas", 0))
            assertThat(histoAggResult.getProfiledChildren().size(), equalTo(1));
                assertThat(histoBreakdown.keySet(), equalTo(CONCURRENT_SEARCH_BREAKDOWN_KEYS));
            } else {
            }
 * under the License.
                // concurrent segment search enabled
            List<ProfileResult> aggProfileResultsList = aggProfileResults.getProfileResults();
        "min_" + INITIALIZE,
                assertThat(diversifyBreakdown.keySet(), equalTo(BREAKDOWN_KEYS));
            assertThat(histoBreakdown, notNullValue());
                assertThat(debug, notNullValue());
            AggregationProfileShardResult aggProfileResults = profileShardResult.getAggregationProfileResults();
                ProfileResult topHitsFetch1 = null;
            avgAggResult = tagsAggResultSubAggregations.get("avg");
        BUILD_LEAF_COLLECTOR,
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            if (maxAggResult.getMaxSliceTime() != null) {
            assertThat(maxBreakdown.get(REDUCE), equalTo(0L));
    private static final String REDUCE = AggregationTimingType.REDUCE.toString();
            assertThat(breakdown.get(REDUCE), equalTo(0L));
            .addAggregation(
                    assertCollectorResult(collectorResult, 2);
        long nodeTime = collectorResult.getCollectorResult().getTime();
                    .subAggregation(
        }
            assertThat(aggProfileResultsList, notNullValue());
            if (stringsAggResult.getMaxSliceTime() != null) {
                    } else if (result.getQueryName().contains("top_hits_agg1")) {
import java.util.Set;
            assertThat(avgAggResult.getDebugInfo(), equalTo(Map.of()));
                    assertCollectorResult(collectorResult, 2);
                assertThat(tagsBreakdown.keySet(), equalTo(CONCURRENT_SEARCH_BREAKDOWN_KEYS));
            assertThat(avgAggResult.getTime(), greaterThan(0L));
            if (fetchProfileResult != null && !fetchProfileResult.getFetchProfileResults().isEmpty()) {
        boolean profileEnabled = true;
        "avg_" + BUILD_LEAF_COLLECTOR,
                            .field(TAG_FIELD, randomBoolean() ? "more" : "less")
                assertEquals(CONCURRENT_SEARCH_BREAKDOWN_KEYS, breakdown.keySet());
            assertThat(maxAggResult.getQueryName(), equalTo("MaxAggregator"));
        for (ProfileShardResult profileShardResult : profileResults.values()) {
            assertThat(histoAggResult.getQueryName(), equalTo("NumericHistogramAggregator"));
            AggregationProfileShardResult aggProfileResults = profileShardResult.getAggregationProfileResults();
            assertThat(avgBreakdown.get(BUILD_LEAF_COLLECTOR), greaterThan(0L));
        }
                for (ProfileResult fetchResult : fetchProfileResults) {
                // Count different types of fetch operations dynamically
    private static final String TOTAL_BUCKETS = "total_buckets";
                        assertCollectorResultWithConcurrentSearchEnabled(collectorResult, 2);
            assertThat(stringsBreakdown.get(REDUCE), equalTo(0L));
    private static final String STRING_FIELD = "string_field";
        SearchResponse response = client().prepareSearch("idx")
            Map<String, Long> termsBreakdown = termsAggResult.getTimeBreakdown();
            assertThat(termsAggResult.getTime(), greaterThan(0L));
        SearchResponse response = client().prepareSearch("idx")
        assertThat(profileResults, notNullValue());
                histogram("histo").field(NUMBER_FIELD)
            assertEquals(1, globalAggResult.getProfiledChildren().size());
            assertThat(maxBreakdown.get(REDUCE), equalTo(0L));
            assertThat(maxBreakdown.get(POST_COLLECTION), greaterThan(0L));
                assertThat(avgBreakdown.keySet(), equalTo(BREAKDOWN_KEYS));
                } else if (queryProfileShardResult.getQueryResults().get(0).getQueryName().equals("ConstantScoreQuery")) {
            assertThat(profileShardResult, notNullValue());
            assertThat(tagsAggResult.getQueryName(), equalTo(GlobalOrdinalsStringTermsAggregator.class.getSimpleName()));
                    }
        }
            )
                assertThat(termsBreakdown.keySet(), equalTo(BREAKDOWN_KEYS));
public class AggregationProfilerIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
            assertThat(avgBreakdown, notNullValue());
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
                }
 */
    }
                assertThat(breakdown.get(COLLECT), greaterThan(0L));
            builders.add(
import java.util.Map;
                assertThat(avgBreakdown.keySet(), equalTo(CONCURRENT_SEARCH_BREAKDOWN_KEYS));
                } else {
            assertThat(termsBreakdown, notNullValue());
                    assertTrue("LOAD_STORED_FIELDS timing should be present", breakdown.containsKey("load_stored_fields"));
            tagsAggResult = stringsAggResultSubAggregations.get("tags");
                    } else if (result.getQueryName().contains("top_hits_agg2")) {
        assertNotNull("Profile results should not be null", profileResults);
            assertThat(diversifyBreakdown.get(INITIALIZE), greaterThan(0L));
                    }
            }
            if (avgAggResult.getMaxSliceTime() != null) {
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
            assertThat(stringsBreakdown.get(BUILD_LEAF_COLLECTOR), greaterThan(0L));
            }
    }
        POST_COLLECTION,
            if (globalAggResult.getMaxSliceTime() != null) {
            } else {
            assertThat(breakdown, notNullValue());
import java.util.ArrayList;
                shardsWithDocuments++;
            assertThat(avgBreakdown.get(POST_COLLECTION), greaterThan(0L));
            }
 * specific language governing permissions and limitations
import org.opensearch.search.aggregations.BucketOrder;
                .stream()
                            .field(TAG_FIELD)
                            .subAggregation(max("max").field(NUMBER_FIELD))
            assertThat(maxAggResult, notNullValue());
            ProfileResult termsAggResult = histoAggResult.getProfiledChildren().get(0);
                assertTrue("Should have at least 1 top_hits_agg2 fetch operation", topHitsAgg2Count >= 1);
        );
                assertThat(histoAggResult, notNullValue());
                for (QueryProfileShardResult collectorResult : profileShardResult.getQueryProfileResults()) {
        assertAcked(
            if (diversifyAggResult.getMaxSliceTime() != null) {
            }
            assertRemapTermsDebugInfo(termsAggResult);
        BUILD_LEAF_COLLECTOR + "_count",
                // concurrent segment search enabled
            for (QueryProfileShardResult queryProfilerResult : queryProfilerResults) {
            assertThat(termsAggResult, notNullValue());
            .get();
                // concurrent segment search enabled
        assertThat(profileResults.size(), equalTo(getNumShards("idx").numPrimaries));
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
            } else {
            assertThat(aggProfileResultsList, notNullValue());
        "min_" + COLLECT + "_count",
            greaterThan(0)
                        }
        INITIALIZE,
                // concurrent segment search enabled
            .setQuery(QueryBuilders.matchAllQuery())
            assertThat(termsBreakdown.get(INITIALIZE), greaterThan(0L));
            tagsBreakdown = tagsAggResult.getTimeBreakdown();
            .get();
import static org.opensearch.search.aggregations.AggregationBuilders.max;
import java.util.Arrays;
    public void testNoProfile() {
            } else {
            }
            maxAggResult = tagsAggResultSubAggregations.get("max");
        assertThat(collectorResult.getCollectorResult().getReduceTime(), greaterThan(0L));
                    assertEquals("search_top_hits", queryProfileShardResult.getCollectorResult().getReason());
        POST_COLLECTION,
        "min_" + BUILD_LEAF_COLLECTOR,
    private static final String TAG_FIELD = "tag";
        }
                }
                // concurrent segment search enabled
                    assertCollectorResultWithConcurrentSearchEnabled(collectorResult, 2);
                    fail("unexpected profile shard result in the response");
            )
import org.opensearch.search.profile.query.QueryProfileShardResult;
            ProfileResult tagsAggResult = histoAggResultSubAggregations.get("tags");
                    assertCollectorResult(collectorResult, 0);
            assertThat(histoAggResult.getTime(), greaterThan(0L));
                }
import static org.opensearch.search.aggregations.AggregationBuilders.global;
    }
            assertThat(avgAggResult.getQueryName(), equalTo("AvgAggregator"));
            assertThat(tagsBreakdown.get(REDUCE), equalTo(0L));
            List<ProfileResult> aggProfileResultsList = aggProfileResults.getProfileResults();
                assertNotNull("Should have top_hits_agg1 fetch operation", topHitsFetch1);
            assertThat(maxBreakdown.get(COLLECT), greaterThan(0L));
                    .subAggregation(
                    .interval(1L)
    private static final String INITIALIZE = AggregationTimingType.INITIALIZE.toString();
            assertThat(avgAggResult, notNullValue());
        REDUCE + "_count",
                // concurrent segment search enabled
        assertThat((long) ((InternalAggregation) global).getProperty("_count"), equalTo((long) numDocs));
            assertThat(histoDebugInfo.keySet(), equalTo(Set.of(TOTAL_BUCKETS)));
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
 * this file be licensed under the Apache-2.0 license or a
            assertThat(tagsBreakdown, notNullValue());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            Map<String, Object> debug = histoAggResult.getDebugInfo();
 * GitHub history for details.
            assertThat(aggProfileResultsList, notNullValue());
            } else {
            maxBreakdown = maxAggResult.getTimeBreakdown();
                            .subAggregation(
            assertThat(tagsBreakdown.get(COLLECT), greaterThan(0L));
                assertThat(avgBreakdown.keySet(), equalTo(CONCURRENT_SEARCH_BREAKDOWN_KEYS));
                assertEquals("FetchSourcePhase", topHitsFetch2.getProfiledChildren().get(0).getQueryName());
                    .field(STRING_FIELD)
                        breakdown.containsKey("create_stored_fields_visitor")
                List<CollectorResult> children = collectorResult.getProfiledChildren();
            assertThat(profileShardResult, notNullValue());
            assertThat(tagsAggResult.getProfiledChildren().size(), equalTo(2));
    private static final String DEFERRED = "deferred_aggregators";
        assertThat((Stats) ((InternalAggregation) global).getProperty("value_stats"), sameInstance(stats));
            assertThat(avgBreakdown.get(BUILD_AGGREGATION), greaterThan(0L));
                    for (QueryProfileShardResult collectorResult : profileShardResult.getQueryProfileResults()) {
            assertThat(diversifyBreakdown.get(POST_COLLECTION), greaterThan(0L));
            assertEquals("global", globalAggResult.getLuceneDescription());
 *
                // concurrent segment search enabled
                assertThat(histoBreakdown.keySet(), equalTo(BREAKDOWN_KEYS));
                assertThat(breakdown.get(REDUCE), equalTo(0L));
        assertThat(collectorResult.getCollectorResult().getProfiledChildren().size(), equalTo(expectedChildrenCount));
        INITIALIZE + "_count",
            List<QueryProfileShardResult> queryProfilerResults = profileShardResult.getQueryProfileResults();
        for (int i = 0; i < numDocs; i++) {
                assertTrue("Should be top_hits aggregation fetch", topHitsFetch2.getQueryName().startsWith("fetch_top_hits_aggregation"));
        REDUCE + "_count",
                    .subAggregation(max("max").field(NUMBER_FIELD))
            assertThat(maxBreakdown.get(BUILD_LEAF_COLLECTOR), greaterThan(0L));
        assertThat(profileResults.size(), equalTo(0));
            assertThat(histoDebugInfo.keySet(), equalTo(Set.of(TOTAL_BUCKETS)));
                    assertTrue("GET_NEXT_READER timing should be present", breakdown.containsKey("get_next_reader"));
                            .field(STRING_FIELD, randomFrom(randomStrings))
    private static final String COLLECT = AggregationTimingType.COLLECT.toString();
                .collect(Collectors.toMap(ProfileResult::getLuceneDescription, s -> s));
        assertThat(collectorResult.getCollectorResult().getMaxSliceTime(), lessThanOrEqualTo(nodeTime));
            assertThat(histoBreakdown.get(COLLECT), greaterThan(0L));
        "max_" + BUILD_LEAF_COLLECTOR + "_count",
            assertThat(aggProfileResultsList.size(), equalTo(2));
                            )
            assertThat(avgBreakdown.get(BUILD_LEAF_COLLECTOR), greaterThan(0L));
                .indices()
            assertThat(maxBreakdown.get(INITIALIZE), greaterThan(0L));
            ProfileResult avgAggResult = tagsAggResultSubAggregations.get("avg");
 */
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
            }
                assertEquals(BREAKDOWN_KEYS, breakdown.keySet());
        "max_" + REDUCE,
                            )
                assertThat(histoAggResult.getProfiledChildren().size(), equalTo(0));
import static org.opensearch.search.aggregations.AggregationBuilders.stats;
                    assertCollectorResultWithConcurrentSearchEnabled(collectorResult, 2);
    }
            Map<String, Long> stringsBreakdown = stringsAggResult.getTimeBreakdown();
            .setProfile(true)
import static org.hamcrest.Matchers.greaterThan;
            if (avgAggResult.getMaxSliceTime() != null) {
            assertThat(histoDebugInfo, notNullValue());
                assertThat(termsBreakdown.keySet(), equalTo(BREAKDOWN_KEYS));
            .get();
            assertThat(maxAggResult, notNullValue());
                        assertCollectorResult(collectorResult, 2);
                for (QueryProfileShardResult collectorResult : profileShardResult.getQueryProfileResults()) {
            assertThat(diversifyAggResult, notNullValue());
                .stream()
        Map<String, ProfileShardResult> profileResults = response.getProfileResults();
            assertThat(avgBreakdown.get(COLLECT), greaterThan(0L));
        for (ProfileShardResult profileShardResult : profileResults.values()) {
            assertThat(avgBreakdown.get(INITIALIZE), greaterThan(0L));
        Map<String, ProfileShardResult> profileResults = response.getProfileResults();
                    )
            } else {
                assertThat(histoBreakdown.keySet(), equalTo(CONCURRENT_SEARCH_BREAKDOWN_KEYS));
        "avg_" + COLLECT + "_count"
        );
                Map<String, Long> breakdown = histoAggResult.getTimeBreakdown();
                    // concurrent segment search enabled
            assertThat(diversifyAggResult.getProfiledChildren().size(), equalTo(1));
        assertThat(collectorResult.getCollectorResult().getMinSliceTime(), equalTo(nodeTime));
            assertEquals(queryProfileShardResults.size(), 2);
            assertThat(avgAggResult.getLuceneDescription(), equalTo("avg"));
            }
            assertThat(maxAggResult.getQueryName(), equalTo("MaxAggregator"));
        String[] randomStrings = new String[randomIntBetween(2, 10)];
                assertTrue("Should be top_hits aggregation fetch", topHitsFetch1.getQueryName().startsWith("fetch_top_hits_aggregation"));
            ProfileResult diversifyAggResult = aggProfileResultsList.get(0);
            assertThat(termsBreakdown.get(REDUCE), equalTo(0L));
            assertThat(avgBreakdown.get(BUILD_AGGREGATION), greaterThan(0L));
            assertThat(histoBreakdown.get(BUILD_AGGREGATION), greaterThan(0L));
            avgAggResult = stringsAggResultSubAggregations.get("avg");
                assertThat(termsBreakdown.keySet(), equalTo(CONCURRENT_SEARCH_BREAKDOWN_KEYS));
 *
            Map<String, Long> histoBreakdown = histoAggResult.getTimeBreakdown();
 * the Apache License, Version 2.0 (the "License"); you may
            assertThat(tagsBreakdown.get(POST_COLLECTION), greaterThan(0L));
                int topHitsAgg2Count = 0;
    }
    }
    private static final String RESULT_STRAT = "result_strategy";
            assertThat(maxAggResult.getProfiledChildren().size(), equalTo(0));
            assertThat(maxAggResult.getTime(), greaterThan(0L));
    private static final String REASON_SEARCH_TOP_HITS = "search_top_hits";
                assertThat(avgBreakdown.keySet(), equalTo(CONCURRENT_SEARCH_BREAKDOWN_KEYS));
                    assertThat(breakdown.keySet(), equalTo(CONCURRENT_SEARCH_BREAKDOWN_KEYS));
            assertThat(collectorResult.getCollectorResult().getProfiledChildren().get(1).getReason(), equalTo(REASON_AGGREGATION));
        Map<String, ProfileShardResult> profileResults = response.getProfileResults();
            assertThat(histoBreakdown.get(REDUCE), equalTo(0L));
                    .setSource(
                assertNotNull(topHitsFetch2.getTimeBreakdown());
                assertThat(avgBreakdown.keySet(), equalTo(BREAKDOWN_KEYS));
        assertThat(global, IsNull.notNullValue());
                assertThat(tagsBreakdown.keySet(), equalTo(BREAKDOWN_KEYS));
                histogram("histo").field(NUMBER_FIELD)
                }
            assertThat(tagsBreakdown.get(BUILD_AGGREGATION), greaterThan(0L));
                            .subAggregation(max("max").field(NUMBER_FIELD))
                shardsWithCorrectProfile++;
            shardsWithDocuments,
            }
    private final int numDocs = 5;
            } else {
            assertThat(tagsBreakdown, notNullValue());
            assertThat(termsBreakdown.get(INITIALIZE), greaterThan(0L));
            .setProfile(true)
                diversifiedSampler("diversify").shardSize(10)
            assertThat(debug.keySet(), equalTo(Set.of(TOTAL_BUCKETS)));
        return 1;
    private static final Set<String> BREAKDOWN_KEYS = Set.of(
            if (maxAggResult.getMaxSliceTime() != null) {
            assertThat(avgBreakdown, notNullValue());
            assertThat(((Number) histoDebugInfo.get(TOTAL_BUCKETS)).longValue(), greaterThan(0L));
                assertThat(maxBreakdown.keySet(), equalTo(CONCURRENT_SEARCH_BREAKDOWN_KEYS));
        Stats stats = global.getAggregations().get("value_stats");
        Map<String, ProfileShardResult> profileResults = response.getProfileResults();
        assertThat(global.getName(), equalTo("global"));
                // concurrent segment search enabled
            .addAggregation(global("global").subAggregation(stats("value_stats").field(NUMBER_FIELD)))
        POST_COLLECTION + "_count",
            assertThat(avgAggResult.getTime(), greaterThan(0L));
            assertThat(avgAggResult, notNullValue());
            assertEquals("GlobalAggregator", globalAggResult.getQueryName());
            if (histoAggResult.getMaxSliceTime() != null) {
        }
            assertThat(diversifyAggResult.getQueryName(), equalTo(DiversifiedOrdinalsSamplerAggregator.class.getSimpleName()));
            assertThat(avgBreakdown.get(REDUCE), equalTo(0L));
        }
            shardsWithCorrectProfile
            assertThat(avgAggResult.getProfiledChildren().size(), equalTo(0));
            client().admin()
            assertRemapTermsDebugInfo(tagsAggResult);
            AggregationProfileShardResult aggProfileResults = profileShardResult.getAggregationProfileResults();
        assertThat(profileResults.size(), equalTo(getNumShards("idx").numPrimaries));
        "max_" + BUILD_AGGREGATION,
            if (histoAggResult.getMaxSliceTime() != null) {
            assertThat(maxBreakdown.get(INITIALIZE), greaterThan(0L));
import org.opensearch.search.profile.query.CollectorResult;
        assertThat(collectorResult.getCollectorResult().getAvgSliceTime(), equalTo(nodeTime));
import org.opensearch.search.aggregations.bucket.sampler.DiversifiedOrdinalsSamplerAggregator;
        BUILD_AGGREGATION + "_count",
            assertThat(histoAggResult.getProfiledChildren().size(), equalTo(1));
                assertThat(reason, equalTo("search_multi"));
            assertThat(maxAggResult, notNullValue());
    @Override
import org.opensearch.index.query.QueryBuilders;
                for (QueryProfileShardResult collectorResult : profileShardResult.getQueryProfileResults()) {
            assertThat(histoAggResult, notNullValue());
    private static final String POST_COLLECTION = AggregationTimingType.POST_COLLECTION.toString();
            assertThat(termsBreakdown.get(COLLECT), greaterThan(0L));
            AggregationProfileShardResult aggProfileResults = profileShardResult.getAggregationProfileResults();
        for (ProfileShardResult shardResult : profileResults.values()) {
    );
            assertThat(avgBreakdown.get(INITIALIZE), greaterThan(0L));
        assertThat(profileResults, notNullValue());
 * not use this file except in compliance with the License.
            assertThat(avgBreakdown.get(COLLECT), greaterThan(0L));
    private static final String BUILD_AGGREGATION = AggregationTimingType.BUILD_AGGREGATION.toString();
        indexRandom(true, false, builders);
            assertThat(avgAggResult.getDebugInfo(), equalTo(Map.of()));
        INITIALIZE + "_count",
            assertThat(maxAggResult.getDebugInfo(), equalTo(Map.of()));
            }
                    )
                }
    protected void setupSuiteScopeCluster() throws Exception {
                                    .subAggregation(max("max").field(NUMBER_FIELD))
import org.opensearch.search.aggregations.bucket.global.Global;
            assertThat(maxBreakdown.get(COLLECT), greaterThan(0L));
            }
            .addAggregation(histogram("histo_2").field(NUMBER_FIELD).interval(1L))
                assertThat(children.get(1).getName(), containsString("[histo_1, histo_2]"));
import org.opensearch.search.aggregations.InternalAggregation;
            assertThat(maxAggResult.getTime(), greaterThan(0L));
                                    .subAggregation(avg("avg").field(NUMBER_FIELD))
            assertThat(aggProfileResultsList, notNullValue());
            assertThat(stringsBreakdown.get(BUILD_AGGREGATION), greaterThan(0L));
import org.opensearch.common.settings.Settings;
    private static final String COLLECTION_STRAT = "collection_strategy";
            assertThat(avgAggResult.getProfiledChildren().size(), equalTo(0));
            assertThat(aggProfileResultsList.size(), equalTo(1));
            randomStrings[i] = randomAlphaOfLength(10);
                }
            assertThat(stringsBreakdown.get(COLLECT), greaterThan(0L));
        "max_" + BUILD_LEAF_COLLECTOR,
        SearchResponse response = client().prepareSearch("idx")
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
import static org.opensearch.search.aggregations.AggregationBuilders.diversifiedSampler;
            assertThat(maxBreakdown.get(POST_COLLECTION), greaterThan(0L));
        assertThat(termsAggResult.getDebugInfo(), hasEntry(RESULT_STRAT, "terms"));
            assertThat(diversifyAggResult.getLuceneDescription(), equalTo("diversify"));
            assertThat(maxBreakdown, notNullValue());
            assertThat(histoBreakdown, notNullValue());
            .addAggregation(topHits("top_hits_agg1").size(1))
            assertThat(profileShardResult, notNullValue());
            assertThat(avgAggResult, notNullValue());
            .addAggregation(
                    assertEquals(0, queryProfileShardResult.getCollectorResult().getProfiledChildren().size());
                CollectorResult collectorResult = queryProfilerResult.getCollectorResult();
            if (maxAggResult.getMaxSliceTime() != null) {
            assertThat(tagsAggResult, notNullValue());
 * software distributed under the License is distributed on an
            assertThat(histoBreakdown.get(BUILD_AGGREGATION), greaterThan(0L));
                    assertTrue(
            .setProfile(true)
            assertThat(histoBreakdown.get(BUILD_AGGREGATION), greaterThan(0L));
                    )
            assertThat(histoBreakdown.get(COLLECT), greaterThan(0L));
            assertThat(tagsAggResult.getTime(), greaterThan(0L));
            assertThat(((Number) histoDebugInfo.get(TOTAL_BUCKETS)).longValue(), greaterThan(0L));
            assertThat(histoBreakdown.get(INITIALIZE), greaterThan(0L));
        assertEquals(
                .stream()
                assertThat(histoBreakdown.keySet(), equalTo(CONCURRENT_SEARCH_BREAKDOWN_KEYS));
        "min_" + REDUCE,
            Map<String, Long> breakdown = globalAggResult.getTimeBreakdown();
                } else {
                assertNotNull("Should have top_hits_agg2 fetch operation", topHitsFetch2);
            assertThat(termsBreakdown.get(REDUCE), equalTo(0L));
                histogram("histo").field(NUMBER_FIELD)
 * Modifications Copyright OpenSearch Contributors. See
            }
                        terms("strings").field(STRING_FIELD)
                    )
            assertThat(stringsAggResult, notNullValue());
                        terms("tags").field(TAG_FIELD)
 * SPDX-License-Identifier: Apache-2.0
            assertThat(diversifyAggResult.getDebugInfo(), equalTo(Map.of(DEFERRED, List.of("max"))));
            assertThat(maxBreakdown.get(BUILD_AGGREGATION), greaterThan(0L));
            assertThat(profileShardResult, notNullValue());
        Map<String, ProfileShardResult> profileResults = response.getProfileResults();
            assertThat(termsAggResult.getLuceneDescription(), equalTo("terms"));
            assertThat(tagsAggResult.getLuceneDescription(), equalTo("tags"));
            assertThat(avgBreakdown, notNullValue());
            assertThat(avgBreakdown.get(COLLECT), greaterThan(0L));
            .addAggregation(topHits("top_hits_agg2").size(1).sort(SortBuilders.fieldSort(NUMBER_FIELD).order(SortOrder.DESC)))
                Map<String, Object> debug = histoAggResult.getDebugInfo();
                    assertEquals("aggregation_global", queryProfileShardResult.getCollectorResult().getReason());
            assertThat(maxAggResult.getProfiledChildren().size(), equalTo(0));
        assertSearchResponse(response);
            assertThat(maxAggResult.getQueryName(), equalTo("MaxAggregator"));
            Map<String, Long> breakdown = histoAggResult.getTimeBreakdown();
            AggregationProfileShardResult aggProfileResults = profileShardResult.getAggregationProfileResults();
                assertThat(tagsBreakdown.keySet(), equalTo(CONCURRENT_SEARCH_BREAKDOWN_KEYS));
    }
            assertThat(avgAggResult.getLuceneDescription(), equalTo("avg"));
            assertThat(diversifyBreakdown, notNullValue());
            assertThat(avgAggResult.getQueryName(), equalTo("AvgAggregator"));
            }
                .stream()
            assertThat(maxBreakdown, notNullValue());
                    .interval(1L)
            for (ProfileResult histoAggResult : aggProfileResultsList) {
            if (avgAggResult.getMaxSliceTime() != null) {
            .addAggregation(histogram("histo").field(NUMBER_FIELD).interval(1L))
            assertThat(stringsBreakdown.get(INITIALIZE), greaterThan(0L));
        assertSearchResponse(response);
                assertThat(maxBreakdown.keySet(), equalTo(CONCURRENT_SEARCH_BREAKDOWN_KEYS));
                assertThat(maxBreakdown.keySet(), equalTo(CONCURRENT_SEARCH_BREAKDOWN_KEYS));
            assertThat(diversifyBreakdown.get(COLLECT), greaterThan(0L));
 * Licensed to Elasticsearch under one or more contributor
            assertThat(maxBreakdown, notNullValue());
            assertThat(maxBreakdown.get(BUILD_LEAF_COLLECTOR), greaterThan(0L));
            }
                            topHitsFetch1 = result; // Keep first instance for validation
        BUILD_AGGREGATION,
                    assertCollectorResult(collectorResult, 2);
                                    .subAggregation(max("max").field(NUMBER_FIELD))
import static org.hamcrest.Matchers.is;
                assertTrue("Should have at least 3 total fetch operations", fetchProfileResults.size() >= 3);
            assertThat(globalAggResult, notNullValue());
            ProfileResult avgAggResult = termsAggResult.getProfiledChildren().get(0);
            assertThat(avgBreakdown.get(BUILD_AGGREGATION), greaterThan(0L));
                    assertCollectorResultWithConcurrentSearchEnabled(collectorResult, 2);
            Map<String, Object> histoDebugInfo = histoAggResult.getDebugInfo();
        INITIALIZE + "_start_time",
import static org.hamcrest.Matchers.sameInstance;
        for (ProfileShardResult profileShardResult : profileResults.values()) {
            Map<String, Object> histoDebugInfo = histoAggResult.getDebugInfo();
            FetchProfileShardResult fetchProfileResult = shardResult.getFetchProfileResult();
 */
                assertThat(histoAggResult.getLuceneDescription(), containsString("histo_"));
        assertThat(stats, IsNull.notNullValue());
            assertThat(tagsBreakdown.get(INITIALIZE), greaterThan(0L));
                assertThat(breakdown.keySet(), equalTo(CONCURRENT_SEARCH_BREAKDOWN_KEYS));
import java.util.Collection;
            assertThat(collectorResult.getCollectorResult().getProfiledChildren().get(0).getReason(), equalTo(REASON_SEARCH_TOP_HITS));
            assertThat(avgAggResult.getProfiledChildren().size(), equalTo(0));
            .get();
                            .order(BucketOrder.aggregation("avg", false))
            assertThat(maxAggResult.getTime(), greaterThan(0L));
                assertThat(breakdown.get(BUILD_AGGREGATION).longValue(), greaterThan(0L));
            assertThat(tagsAggResult.getQueryName(), equalTo(GlobalOrdinalsStringTermsAggregator.class.getSimpleName()));
        for (ProfileShardResult profileShardResult : profileResults.values()) {
        "avg_" + BUILD_LEAF_COLLECTOR + "_count",
                            .subAggregation(avg("avg").field(NUMBER_FIELD))
            assertThat(diversifyBreakdown.get(INITIALIZE), greaterThan(0L));
        "min_" + BUILD_LEAF_COLLECTOR + "_count",
            maxBreakdown = maxAggResult.getTimeBreakdown();
            assertThat(aggProfileResultsList, notNullValue());
                    assertThat(breakdown.keySet(), equalTo(BREAKDOWN_KEYS));
            assertThat(debug, notNullValue());
            tagsAggResultSubAggregations = tagsAggResult.getProfiledChildren()
        assertThat(collectorResult.getCollectorResult().getMinSliceTime(), lessThanOrEqualTo(nodeTime));
                    )
        BUILD_LEAF_COLLECTOR,
            } else {
                // concurrent segment search enabled
                assertThat(termsBreakdown.keySet(), equalTo(CONCURRENT_SEARCH_BREAKDOWN_KEYS));
            if (avgAggResult.getMaxSliceTime() != null) {
        assertThat(global.getAggregations().asList().isEmpty(), is(false));
    protected int numberOfShards() {
                // concurrent segment search enabled
                            .subAggregation(avg("avg").field(NUMBER_FIELD))
            }
                assertTrue("Should contain aggregation name", topHitsFetch2.getQueryName().contains("top_hits_agg2"));
            assertThat(maxBreakdown.get(BUILD_AGGREGATION), greaterThan(0L));
                assertThat(maxBreakdown.keySet(), equalTo(BREAKDOWN_KEYS));
            Map<String, Object> histoDebugInfo = histoAggResult.getDebugInfo();
 * Unless required by applicable law or agreed to in writing,
                assertThat(breakdown, notNullValue());
            assertThat(histoAggResult, notNullValue());
            .get();
            assertThat(avgBreakdown.get(REDUCE), equalTo(0L));
                assertThat(stringsBreakdown.keySet(), equalTo(BREAKDOWN_KEYS));
            assertThat(aggProfileResultsList.size(), equalTo(1));
            assertThat(histoAggResult.getTime(), greaterThan(0L));
            assertThat(tagsBreakdown.get(INITIALIZE), greaterThan(0L));
            .setProfile(true)
            assertThat(avgAggResult.getTime(), greaterThan(0L));
            assertThat(histoAggResult.getQueryName(), equalTo("NumericHistogramAggregator"));
            assertThat(maxBreakdown.get(BUILD_AGGREGATION), greaterThan(0L));
            assertThat(maxAggResult.getTime(), greaterThan(0L));
    public void testComplexProfile() {
                }
            assertThat(histoAggResult, notNullValue());
                        "CREATE_STORED_FIELDS_VISITOR timing should be present",
                assertThat(stringsBreakdown.keySet(), equalTo(CONCURRENT_SEARCH_BREAKDOWN_KEYS));
            assertThat(histoAggResult.getLuceneDescription(), equalTo("histo"));
        "min_" + COLLECT,
import static org.opensearch.search.aggregations.AggregationBuilders.avg;
            } else {
        assertFalse("Profile results should not be empty", profileResults.isEmpty());
            .get();
            assertRemapTermsDebugInfo(stringsAggResult);
                            .subAggregation(
            assertThat(maxBreakdown.get(BUILD_AGGREGATION), greaterThan(0L));
            assertThat(histoAggResult.getLuceneDescription(), equalTo("histo"));
        assertThat(profileResults, notNullValue());
            assertThat(profileShardResult, notNullValue());
            assertThat(avgAggResult.getDebugInfo(), equalTo(Map.of()));
            assertEquals(0, breakdown.get(REDUCE).intValue());
            if (histoAggResult.getMaxSliceTime() != null) {
    }
                    assertCollectorResult(collectorResult, 2);
            );
            }
                    .subAggregation(
            assertThat(diversifyBreakdown.get(COLLECT), greaterThan(0L));
                    assertCollectorResultWithConcurrentSearchEnabled(collectorResult, 2);
import org.hamcrest.core.IsNull;
        assertSearchResponse(response);
        for (int i = 0; i < randomStrings.length; i++) {
        createIndex("idx_unmapped");
                            .subAggregation(max("max").field(NUMBER_FIELD))
        assertSearchResponse(response);
        assertThat(profileResults.size(), equalTo(getNumShards("idx").numPrimaries));
                assertThat(tagsBreakdown.keySet(), equalTo(BREAKDOWN_KEYS));
            assertThat(histoAggResult, notNullValue());
                assertEquals("FetchSourcePhase", topHitsFetch1.getProfiledChildren().get(0).getQueryName());
            } else {
            } else {
            assertEquals(1, aggProfileResultsList.size());
                client().prepareIndex("idx")
            assertThat(histoBreakdown.get(BUILD_LEAF_COLLECTOR), greaterThan(0L));
    private static final String SEGMENTS_WITH_MULTI = "segments_with_multi_valued_ords";
    public void testSimpleProfile() {
    private void assertCollectorResult(QueryProfileShardResult collectorResult, int expectedChildrenCount) {
                        terms("tags").field(TAG_FIELD)
            assertThat(breakdown.get(BUILD_AGGREGATION).longValue(), greaterThan(0L));
            .addAggregation(histogram("histo_1").field(NUMBER_FIELD).interval(1L))
import org.opensearch.search.profile.ProfileResult;
                }
            assertThat(maxBreakdown.get(REDUCE), equalTo(0L));
            Map<String, Long> maxBreakdown = maxAggResult.getTimeBreakdown();
            assertThat(avgAggResult.getProfiledChildren().size(), equalTo(0));
    private void assertRemapTermsDebugInfo(ProfileResult termsAggResult) {
            assertThat(avgBreakdown.get(INITIALIZE), greaterThan(0L));
            assertThat(stringsAggResult.getTime(), greaterThan(0L));
                        topHitsAgg2Count++;
            assertThat(maxAggResult.getDebugInfo(), equalTo(Map.of()));
            assertThat(breakdown.get(BUILD_AGGREGATION).longValue(), greaterThan(0L));
                    .interval(1L)
        Map<String, ProfileShardResult> profileResults = response.getProfileResults();
    @Override
            assertThat(maxAggResult.getDebugInfo(), equalTo(Map.of()));
        BUILD_AGGREGATION + "_start_time",
        REDUCE,
            assertThat(aggProfileResultsList.size(), equalTo(1));
            assertThat(histoBreakdown.get(INITIALIZE), greaterThan(0L));
    }
        SearchResponse response = client().prepareSearch("idx")
                for (QueryProfileShardResult collectorResult : profileShardResult.getQueryProfileResults()) {
            assertThat(avgBreakdown.get(POST_COLLECTION), greaterThan(0L));
            assertThat(maxAggResult, notNullValue());
            assertThat(aggProfileResults, notNullValue());
            }
            assertThat(diversifyBreakdown.get(BUILD_LEAF_COLLECTOR), greaterThan(0L));
                    );
        }
            } else {
            "All shards with documents should have correct fetch profile structure",
        assertSearchResponse(response);
            .get();
            assertThat(diversifyBreakdown.get(POST_COLLECTION), greaterThan(0L));
    private static final String HAS_FILTER = "has_filter";
            assertThat(tagsAggResult.getTime(), greaterThan(0L));
        BUILD_LEAF_COLLECTOR + "_start_time",
            }
            } else {
        assertThat(profileResults, notNullValue());
                }
            assertThat(termsAggResult.getLuceneDescription(), equalTo("terms"));
                // Verify we have the expected aggregations (concurrent search may create multiple instances)
                String reason = collectorResult.getReason();
        );
import static org.hamcrest.Matchers.notNullValue;
            assertThat(tagsBreakdown.get(REDUCE), equalTo(0L));
            assertThat(termsBreakdown.get(BUILD_AGGREGATION), greaterThan(0L));
            assertThat(breakdown.get(INITIALIZE), greaterThan(0L));
                // concurrent segment search enabled
            ProfileResult maxAggResult = diversifyAggResult.getProfiledChildren().get(0);
            if (histoAggResult.getMaxSliceTime() != null) {
                assertTrue("Should have at least 1 top_hits_agg1 fetch operation", topHitsAgg1Count >= 1);
 * compatible open source license.
                }
        if (expectedChildrenCount == 2) {
        assertThat(profileResults.size(), equalTo(getNumShards("idx").numPrimaries));
            assertThat(diversifyBreakdown.get(REDUCE), equalTo(0L));
                assertThat(histoBreakdown.keySet(), equalTo(BREAKDOWN_KEYS));
        // TODO we only index single valued docs but the ordinals ends up with multi valued sometimes
            List<ProfileResult> aggProfileResultsList = aggProfileResults.getProfileResults();
            Map<String, Long> avgBreakdown = termsAggResult.getTimeBreakdown();
/*
                    assertEquals(0, queryProfileShardResult.getCollectorResult().getProfiledChildren().size());
import org.opensearch.search.sort.SortOrder;
                        mainFetchCount++;
            avgBreakdown = avgAggResult.getTimeBreakdown();
            assertThat(maxAggResult.getDebugInfo(), equalTo(Map.of()));
import static org.opensearch.search.aggregations.AggregationBuilders.topHits;
            assertThat(termsBreakdown, notNullValue());
            ProfileResult termsAggResult = histoAggResult.getProfiledChildren().get(0);
            assertThat(tagsAggResult, notNullValue());
            assertThat(tagsBreakdown.get(BUILD_LEAF_COLLECTOR), greaterThan(0L));
            assertThat(histoAggResult.getProfiledChildren().size(), equalTo(2));
        POST_COLLECTION + "_start_time",
            } else {
        assertSearchResponse(response);
        "avg_" + POST_COLLECTION,
        assertSearchResponse(response);
        assertThat(profileResults, notNullValue());
    }
    public void testMultiLevelProfile() {
                            .subAggregation(avg("avg").field(NUMBER_FIELD))
            )
        List<IndexRequestBuilder> builders = new ArrayList<>();
        );
                    assertTrue("LOAD_SOURCE timing should be present", breakdown.containsKey("load_source"));
                    assertCollectorResult(collectorResult, 2);
import static org.hamcrest.Matchers.lessThanOrEqualTo;
/*
                    .subAggregation(
            assertThat(maxAggResult.getProfiledChildren().size(), equalTo(0));
package org.opensearch.search.profile.aggregation;
                for (QueryProfileShardResult collectorResult : profileShardResult.getQueryProfileResults()) {
                }
            ProfileResult avgAggResult = termsAggResult.getProfiledChildren().get(0);
        assertThat(collectorResult.getCollectorResult().getReduceTime(), equalTo(0L));
        SearchResponse response = client().prepareSearch("idx")
    public static Collection<Object[]> parameters() {
            assertRemapTermsDebugInfo(termsAggResult);
            assertThat(aggProfileResultsList.size(), equalTo(1));
            assertThat(avgAggResult.getDebugInfo(), equalTo(Map.of()));
            assertThat(histoBreakdown, notNullValue());
                if (queryProfileShardResult.getQueryResults().get(0).getQueryName().equals("MatchAllDocsQuery")) {
        assertThat(profileResults, notNullValue());
            if (maxAggResult.getMaxSliceTime() != null) {
            assertThat(avgBreakdown.get(COLLECT), greaterThan(0L));
            }
            assertThat(collectorResult.getCollectorResult().getProfiledChildren().get(1).getReason(), equalTo(REASON_AGGREGATION));
            assertThat(maxBreakdown.get(BUILD_LEAF_COLLECTOR), greaterThan(0L));
        assertThat(collectorResult.getCollectorResult().getMaxSliceTime(), equalTo(nodeTime));
            Map<String, Long> tagsBreakdown = tagsAggResult.getTimeBreakdown();
            assertThat(avgAggResult.getQueryName(), equalTo("AvgAggregator"));
            assertThat(aggProfileResults, notNullValue());
            } else {
        int shardsWithCorrectProfile = 0;
            } else {
        INITIALIZE,
                        terms("terms").field(TAG_FIELD)
        }
            assertThat(aggProfileResults, notNullValue());
    private static final Set<String> CONCURRENT_SEARCH_BREAKDOWN_KEYS = Set.of(
                    .subAggregation(
                        if (topHitsFetch2 == null) {
        super(staticSettings);
        assertThat(stats.getName(), equalTo("value_stats"));
                assertEquals(queryProfileShardResult.getQueryResults().size(), 1);
    private static final String SEGMENTS_WITH_SINGLE = "segments_with_single_valued_ords";
                assertThat(maxBreakdown.keySet(), equalTo(BREAKDOWN_KEYS));
            assertThat(aggProfileResults, notNullValue());
        COLLECT,
            )
            assertThat(tagsBreakdown.get(BUILD_LEAF_COLLECTOR), greaterThan(0L));
            .get();
        POST_COLLECTION + "_count",
            assertThat(termsAggResult.getProfiledChildren().size(), equalTo(1));
        assertThat(profileResults.size(), equalTo(getNumShards("idx").numPrimaries));
                    }
                            .subAggregation(avg("avg").field(NUMBER_FIELD))
                    assertCollectorResultWithConcurrentSearchEnabled(collectorResult, 2);
            Map<String, Long> diversifyBreakdown = diversifyAggResult.getTimeBreakdown();
            assertThat(tagsBreakdown.get(POST_COLLECTION), greaterThan(0L));
                }
            } else {
                                    .subAggregation(avg("avg").field(NUMBER_FIELD))
            assertThat(avgBreakdown.get(BUILD_LEAF_COLLECTOR), greaterThan(0L));
            assertThat(avgBreakdown.get(REDUCE), equalTo(0L));
                assertThat(children.size(), equalTo(2));
        assertThat(profileResults, notNullValue());
                            .endObject()
            .get();
                    .interval(1L)
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertThat(termsAggResult.getQueryName(), equalTo(GlobalOrdinalsStringTermsAggregator.class.getSimpleName()));
        }
            assertThat(breakdown.get(COLLECT), greaterThan(0L));
import org.opensearch.search.profile.ProfileShardResult;
            assertThat(avgBreakdown.get(INITIALIZE), greaterThan(0L));
                for (QueryProfileShardResult collectorResult : profileShardResult.getQueryProfileResults()) {
                // concurrent segment search enabled
 * The OpenSearch Contributors require contributions made to
            assertThat(avgAggResult, notNullValue());
/*
            termsAggResult.getDebugInfo().toString(),
        }
            .setProfile(profileEnabled)
import java.util.stream.Collectors;
            assertThat(termsAggResult.getTime(), greaterThan(0L));
                }
        "avg_" + INITIALIZE,
            if (termsAggResult.getMaxSliceTime() != null) {
    public AggregationProfilerIT(Settings staticSettings) {
                        terms("strings").field(STRING_FIELD)
                assertThat(diversifyBreakdown.keySet(), equalTo(CONCURRENT_SEARCH_BREAKDOWN_KEYS));
            ProfileResult histoAggResult = aggProfileResultsList.get(0);
            AggregationProfileShardResult aggProfileResults = profileShardResult.getAggregationProfileResults();
                .collect(Collectors.toMap(ProfileResult::getLuceneDescription, s -> s));
        BUILD_AGGREGATION,
}
            AggregationProfileShardResult aggProfileResults = profileShardResult.getAggregationProfileResults();
                        jsonBuilder().startObject()
        if (expectedChildrenCount == 2) {
                assertThat(avgBreakdown.keySet(), equalTo(BREAKDOWN_KEYS));
                    assertTrue("BUILD_SUB_PHASE_PROCESSORS timing should be present", breakdown.containsKey("build_sub_phase_processors"));
                    )
                assertThat(maxBreakdown.keySet(), equalTo(BREAKDOWN_KEYS));
                            topHitsFetch2 = result; // Keep first instance for validation
            assertThat(avgBreakdown.get(BUILD_AGGREGATION), greaterThan(0L));
                // concurrent segment search enabled
        }
            assertThat(avgAggResult, notNullValue());
            assertThat(termsBreakdown.get(BUILD_AGGREGATION), greaterThan(0L));
            assertThat(diversifyBreakdown.get(BUILD_AGGREGATION), greaterThan(0L));
 * this work for additional information regarding copyright
        }
            .addAggregation(
            assertThat(diversifyAggResult.getTime(), greaterThan(0L));
        for (ProfileShardResult profileShardResult : profileResults.values()) {
                assertThat(histoBreakdown.keySet(), equalTo(BREAKDOWN_KEYS));
            } else {
                assertThat(avgBreakdown.keySet(), equalTo(BREAKDOWN_KEYS));
            assertThat(maxAggResult.getProfiledChildren().size(), equalTo(0));
            ProfileResult histoAggResult = aggProfileResultsList.get(0);
            assertThat(termsAggResult.getProfiledChildren().size(), equalTo(1));
                .collect(Collectors.toMap(ProfileResult::getLuceneDescription, s -> s));
