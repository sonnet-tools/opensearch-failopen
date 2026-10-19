 * KIND, either express or implied.  See the License for the
                assertThat(shard.getValue().getNetworkTime().getInboundNetworkTime(), greaterThanOrEqualTo(0L));
import org.opensearch.index.query.QueryBuilders;
                    assertNotNull(result.getQueryName());
        assertThat(profileResponse.getFailedShards(), equalTo(0));
    @ParametersFactory
        QueryBuilder q = QueryBuilders.matchQuery("field1", "one");
 *
                        assertNotNull(result.getLuceneDescription());
import java.util.Map;
                    String avgTimingType = AVG_PREFIX + queryTimingType;
        logger.info("Query: {}", q);
                    String maxTimingType = MAX_PREFIX + queryTimingType;
        Long minSliceTime = result.getMinSliceTime();
/*
    public QueryProfilerIT(Settings settings, boolean concurrentSearchEnabled) {
        SearchRequestBuilder profile = client().prepareSearch("test")
     * The rewrite process will "collapse" this down to a single bool, so this tests to make sure
    }
        if (Float.isNaN(vanillaMaxScore)) {
                    assertThat(result.getTime(), greaterThan(0L));
        if (resp.getShardFailures().length > 0) {
                    assertNotNull(result.getQueryName());
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
                    assertThat(result.getTime(), greaterThan(0L));
        int numDocs = randomIntBetween(100, 150);
        ensureGreen();
        ensureGreen();
                CollectorResult result = searchProfiles.getCollectorResult();
        }
            assertThat(breakdown.size(), equalTo(27));
                assertThat(result.getTime(), greaterThan(0L));
            for (QueryProfileShardResult searchProfiles : shardResult.getValue().getQueryProfileResults()) {
        for (Map.Entry<String, ProfileShardResult> shardResult : resp.getProfileResults().entrySet()) {
                    assertNotNull(result.getLuceneDescription());
        }
    public void testBoosting() throws Exception {
        );
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build(), true }
                    childProfile = children.get(1);
                    assertNotNull(breakdown.get(maxTimingType + TIMING_TYPE_COUNT_SUFFIX));
        }
    public void testDisMaxRange() throws Exception {
                CollectorResult result = searchProfiles.getCollectorResult();
        }
    }
                }
        indexRandom(true, docs);
    /**
 * this work for additional information regarding copyright
    public void testCollapsingBool() throws Exception {
                    assertNotNull(result.getTimeBreakdown());
import org.opensearch.common.settings.Settings;
            docs[i] = client().prepareIndex("test")
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.search.profile.query.RandomQueryGenerator.randomQueryBuilder;
                        assertNotNull(minSliceTime);
import org.opensearch.action.search.SearchType;
            for (QueryProfileShardResult searchProfiles : shardResult.getValue().getQueryProfileResults()) {
    private static final String AVG_PREFIX = "avg_";
        for (Map.Entry<String, ProfileShardResult> shardResult : resp.getProfileResults().entrySet()) {
            SearchResponse resp = client().prepareSearch()
    private static final String MAX_PREFIX = "max_";
        createIndex("test");
     * This test makes sure no profile results are returned when profiling is disabled
        IndexRequestBuilder[] docs = new IndexRequestBuilder[numDocs];
                    assertNotNull(result.getLuceneDescription());
        assertThat(vanillaResponse.getFailedShards(), equalTo(0));
                CollectorResult result = searchProfiles.getCollectorResult();
        ensureGreen();
        }
        for (int i = 0; i < numDocs; i++) {
                }
        SearchResponse resp = client().prepareSearch().setQuery(q).setProfile(true).setSearchType(SearchType.QUERY_THEN_FETCH).get();
            .must(QueryBuilders.matchQuery("field1", "one"))
                    Long avgSliceTime = result.getAvgSliceTime();
                for (QueryProfileShardResult searchProfiles : shard.getValue().getQueryProfileResults()) {
        assertThat("Profile response should not be an empty array", resp.getProfileResults().size(), not(0));
        assertNotNull(p);
 * this file be licensed under the Apache-2.0 license or a
                                String maxTimingType = MAX_PREFIX + queryTimingType;
        }
        assertNotNull("Profile response element should not be null", resp.getProfileResults());
        createIndex("test");
        this.concurrentSearchEnabled = concurrentSearchEnabled;
    public static Collection<Object[]> parameters() {
                assertThat(result.getName(), is(not(emptyOrNullString())));
                        assertThat(avgSliceTime, is(nullValue()));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                                assertNotNull(breakdown.get(maxTimingType + TIMING_TYPE_COUNT_SUFFIX));
        SearchResponse resp = client().prepareSearch().setQuery(q).setProfile(true).setSearchType(SearchType.QUERY_THEN_FETCH).get();
            .setSearchType(SearchType.QUERY_THEN_FETCH)
    public void testPhrase() throws Exception {
                    assertThat(result.getTime(), greaterThan(0L));
            }
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build(), false },
                for (ProfileResult result : searchProfiles.getQueryResults()) {
            logger.info("Query: {}", q);
import static org.hamcrest.Matchers.greaterThan;
        }
                    assertEquals(children.size(), 2);
        ensureGreen();
    }
 * Unless required by applicable law or agreed to in writing,
        }
        int numDocs = randomIntBetween(100, 150);
        assertThat("Profile response should not be an empty array", resp.getProfileResults().size(), not(0));
        assertThat("Profile response should not be an empty array", resp.getProfileResults().size(), not(0));
import static org.hamcrest.Matchers.not;
    private void assertQueryProfileResult(ProfileResult result) {
            .boost(randomFloat())
     */
                        for (QueryTimingType queryTimingType : QueryTimingType.values()) {
 * software distributed under the License is distributed on an
import java.util.Collection;
        for (Map.Entry<String, ProfileShardResult> shardResult : resp.getProfileResults().entrySet()) {
        ensureGreen();
        IndexRequestBuilder[] docs = new IndexRequestBuilder[numDocs];
                CollectorResult result = searchProfiles.getCollectorResult();
            }
                    assertNotNull(result.getTimeBreakdown());
    public void testProfileMatchesRegular() throws Exception {
        }
            assertThat(shardResult.getValue().getNetworkTime().getOutboundNetworkTime(), greaterThanOrEqualTo(0L));
                        }
                    assertEquals(result.getProfiledChildren().size(), 2);
                    assertThat(result.getTime(), greaterThan(0L));
                logger.error("Shard search failure: {}", f);
                CollectorResult result = searchProfiles.getCollectorResult();
        QueryBuilder q = QueryBuilders.boolQuery()
    public void testRange() throws Exception {
            docs[i] = client().prepareIndex("test").setId(String.valueOf(i)).setSource("field1", English.intToEnglish(i), "field2", i);
                CollectorResult result = searchProfiles.getCollectorResult();
                    ProfileResult childProfile = children.get(0);
import org.apache.lucene.tests.util.English;
                    assertNotNull(result.getQueryName());
        ensureGreen();
 * Modifications Copyright OpenSearch Contributors. See
        }
        }
            assertEquals(
                    assertNotNull(childProfile.getTimeBreakdown());
            assertThat("Profile hit #" + j + " has a different ID from Vanilla", vanillaHits[j].getId(), equalTo(profileHits[j].getId()));
        for (int i = 0; i < iters; i++) {
                CollectorResult result = searchProfiles.getCollectorResult();
                    } else if (concurrentSearchEnabled) {
                }
        for (int i = 0; i < numDocs; i++) {
            for (QueryTimingType queryTimingType : QueryTimingType.values()) {
        for (Map.Entry<String, ProfileShardResult> shardResult : resp.getProfileResults().entrySet()) {
                    assertEquals(childProfile.getQueryName(), "TermQuery");
            Set<SearchHit> profileSet = new HashSet<>(Arrays.asList(profileResponse.getHits().getHits()));
        QueryBuilder q = randomQueryBuilder(stringFields, numericFields, numDocs, 3);
                profileMaxScore,
        } else {
        SearchResponse resp = client().prepareSearch()
            assertThat(shardResult.getValue().getNetworkTime().getInboundNetworkTime(), greaterThanOrEqualTo(0L));
                    assertNotNull(result.getQueryName());
            assertThat(minSliceTime, is(nullValue()));
                        assertThat(maxSliceTime, is(nullValue()));
                    assertThat(result.getName(), is(not(emptyOrNullString())));
                }
                assertThat(result.getName(), is(not(emptyOrNullString())));
                            if (queryTimingType != QueryTimingType.CREATE_WEIGHT) {
        }
            for (ShardSearchFailure f : resp.getShardFailures()) {
                    assertQueryProfileResult(result);
        QueryBuilder q = QueryBuilders.disMaxQuery()
     */
    }
            QueryBuilders.termsQuery("field1", terms)
                assertThat(result.getName(), is(not(emptyOrNullString())));
    }
     * nothing catastrophic happens during that fairly substantial rewrite
                        assertThat(breakdown.size(), equalTo(66));
                if (queryTimingType != QueryTimingType.CREATE_WEIGHT) {
        if (concurrentSearchEnabled) {
 * GitHub history for details.
    private static final String TIMING_TYPE_COUNT_SUFFIX = "_count";
        ensureGreen();
        logger.info("Query: {}", q);
                }
                    assertNotNull(result.getTimeBreakdown());
                    assertQueryProfileResult(result);
            }
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        assertNotNull("Profile response element should not be null", resp.getProfileResults());
            docs[i] = client().prepareIndex("test").setId(String.valueOf(i)).setSource("field1", English.intToEnglish(i), "field2", i);
                                assertNotNull(breakdown.get(maxTimingType));
                    assertNotNull(result.getTimeBreakdown());
                }
            .setProfile(true)
                        assertThat(result.getTime(), greaterThan(0L));
        assertThat("Profile response element should be an empty map", resp.getProfileResults().size(), equalTo(0));
        createIndex("test");
                fail("Vanilla hits were larger than profile hits.  Non-overlapping elements were: " + vanillaSet.toString());
        ensureGreen();
        indexRandom(true, docs);
        for (int j = 0; j < vanillaHits.length; j++) {
                    Long minSliceTime = result.getMinSliceTime();
                CollectorResult result = searchProfiles.getCollectorResult();
                    assertEquals(childProfile.getProfiledChildren().size(), 0);
import org.opensearch.search.profile.ProfileShardResult;
                    Long maxSliceTime = result.getMaxSliceTime();
                    assertThat(result.getTime(), greaterThan(0L));
                    assertEquals(childProfile.getLuceneDescription(), "field1:two");
            assertNotNull(avgSliceTime);
     * to make sure the profiling doesn't interfere with the hits being returned
                    assertEquals(childProfile.getQueryName(), "TermQuery");
        refresh();
            docs[i] = client().prepareIndex("test").setId(String.valueOf(i)).setSource("field1", English.intToEnglish(i), "field2", i);
                for (ProfileResult result : searchProfiles.getQueryResults()) {
        for (Map.Entry<String, ProfileShardResult> shardResult : resp.getProfileResults().entrySet()) {
            .setSearchType(SearchType.QUERY_THEN_FETCH)
        int numDocs = randomIntBetween(100, 150);
        }
        SearchResponse resp = client().prepareSearch().setQuery(q).setProfile(false).get();
            .setSearchType(SearchType.QUERY_THEN_FETCH)
        assertNotNull("Profile response element should not be null", resp.getProfileResults());
                    assertQueryProfileResult(result);
                .setProfile(true)
        logger.info("Query: {}", q);
                    assertNotNull(result.getQueryName());
        for (Map.Entry<String, ProfileShardResult> shardResult : resp.getProfileResults().entrySet()) {
        Map<String, ProfileShardResult> p = resp.getProfileResults();
            docs[i] = client().prepareIndex("test").setId(String.valueOf(i)).setSource("field1", English.intToEnglish(i), "field2", i);
        assertNotNull("Profile response element should not be null", resp.getProfileResults());
 */
                    } else {
                assertThat(result.getTime(), greaterThan(0L));
 * Licensed to Elasticsearch under one or more contributor
                for (ProfileResult result : searchProfiles.getQueryResults()) {
import java.util.Arrays;
        ensureGreen();
     * Tests a series of three nested boolean queries with a single "leaf" match query.
                    assertNotNull(result.getLuceneDescription());
                for (ProfileResult result : searchProfiles.getQueryResults()) {
            assertNotNull(maxSliceTime);
        assertNotNull("Profile response element should not be null", resp.getProfileResults());
        IndexRequestBuilder[] docs = new IndexRequestBuilder[numDocs];
            .addSort("id.keyword", SortOrder.ASC)
            }
        createIndex("test");
    public void testProfileQuery() throws Exception {
                for (ProfileResult result : results) {
                    assertEquals(result.getQueryName(), "TermQuery");
            assertThat(avgSliceTime, is(nullValue()));
                    assertThat(result.getTime(), greaterThan(0L));
        List<String> stringFields = Arrays.asList("field1");
        for (int i = 0; i < numDocs; i++) {
        refresh();
     */
 * compatible open source license.
        int numDocs = randomIntBetween(100, 150);
                                String minTimingType = MIN_PREFIX + queryTimingType;
            .negativeBoost(randomFloat());
        refresh();
    public void testBool() throws Exception {
                    assertThat(result.getTime(), greaterThan(0L));
import org.opensearch.search.profile.ProfileResult;
            .setQuery(q)
        indexRandom(true, docs);
     * constructs 20-100 random queries and tries to profile them
        indexRandom(true, docs);
                assertThat(result.getName(), is(not(emptyOrNullString())));
        int numDocs = randomIntBetween(100, 150);
        IndexRequestBuilder[] docs = new IndexRequestBuilder[numDocs];
                assertThat(result.getTime(), greaterThan(0L));
 * You may obtain a copy of the License at
            .setProfile(true)
            }
        refresh();
        List<String> stringFields = Arrays.asList("field1");
public class QueryProfilerIT extends ParameterizedDynamicSettingsOpenSearchIntegTestCase {
     * This test generates a random query and executes a profiled and non-profiled
        SearchResponse resp = client().prepareSearch().setQuery(q).setProfile(true).setSearchType(SearchType.QUERY_THEN_FETCH).get();
                assertThat(shard.getValue().getNetworkTime().getOutboundNetworkTime(), greaterThanOrEqualTo(0L));
        logger.info("Query: {}", q);
                    assertQueryProfileResult(childProfile);
        ensureGreen();
                profileSet.removeAll(vanillaSet);
        int numDocs = randomIntBetween(100, 150);
    /**
                assertThat(result.getTime(), greaterThan(0L));
        SearchResponse resp = client().prepareSearch().setQuery(q).setProfile(true).setSearchType(SearchType.QUERY_THEN_FETCH).get();
                        assertNotNull(avgSliceTime);
import static org.hamcrest.Matchers.emptyOrNullString;
    private final boolean concurrentSearchEnabled;
            .addSort("id.keyword", SortOrder.ASC)
            }
                        assertThat(minSliceTime, is(nullValue()));
            .get();
    }
        assertThat("Profile response should not be an empty array", resp.getProfileResults().size(), not(0));
            }
import java.util.List;
        QueryBuilder q = QueryBuilders.boostingQuery(
                    assertNotNull(breakdown.get(minTimingType));
        SearchResponse resp = client().prepareSearch().setQuery(q).setProfile(true).setSearchType(SearchType.QUERY_THEN_FETCH).get();
        float profileMaxScore = profileResponse.getHits().getMaxScore();
import static org.hamcrest.Matchers.nullValue;
import org.opensearch.search.sort.SortOrder;
                vanillaMaxScore,
    }
        Long maxSliceTime = result.getMaxSliceTime();
        for (int i = 0; i < numDocs; i++) {
            .setIndices("test")
     * Tests a boolean query with no children clauses
 * under the License.
        SearchResponse profileResponse = responses[1].getResponse();
                    assertNotNull(result.getTimeBreakdown());
        for (int i = 0; i < numDocs; i++) {
            QueryBuilder q = randomQueryBuilder(stringFields, numericFields, numDocs, 3);
            }
        ensureGreen();
 */
        ensureGreen();
        assertNotNull("Profile response element should not be null", resp.getProfileResults());
                    assertEquals(result.getLuceneDescription(), "+field1:one +field1:two");
            assertNotNull("Profile response element should not be null", resp.getProfileResults());
    public void testNoProfile() throws Exception {
        for (int i = 0; i < numDocs; i++) {
/*
            }
                assertThat(result.getTime(), greaterThan(0L));
                        assertNotNull(result.getQueryName());
            docs[i] = client().prepareIndex("test").setId(String.valueOf(i)).setSource("field1", English.intToEnglish(i), "field2", i);
            .get();
                    assertNotNull(breakdown.get(minTimingType + TIMING_TYPE_COUNT_SUFFIX));
        indexRandom(true, docs);
    }
                        assertThat(maxSliceTime, equalTo(0L));
        createIndex("test");
                assertThat(result.getName(), is(not(emptyOrNullString())));
    /**
            for (QueryProfileShardResult searchProfiles : shardResult.getValue().getQueryProfileResults()) {
            assertThat(breakdown.size(), equalTo(66));
                    assertQueryProfileResult(result);
        createIndex("test");
                    assertNotNull(childProfile.getTimeBreakdown());
        for (Map.Entry<String, ProfileShardResult> shardResult : resp.getProfileResults().entrySet()) {
        indexRandom(true, docs);
import org.opensearch.action.index.IndexRequestBuilder;
                    assertQueryProfileResult(result);
import org.opensearch.index.query.QueryBuilder;
        Map<String, ProfileShardResult> p = resp.getProfileResults();
                assertThat(result.getName(), is(not(emptyOrNullString())));
            for (QueryProfileShardResult searchProfiles : shardResult.getValue().getQueryProfileResults()) {
        QueryBuilder q = QueryBuilders.boolQuery();
                    assertQueryProfileResult(result);
        logger.info("Query: {}", q);
        refresh();
     */
                    assertNotNull(result.getTimeBreakdown());
        }
        }
        super(settings);
        Map<String, Long> breakdown = result.getTimeBreakdown();
        SearchResponse vanillaResponse = responses[0].getResponse();
        float vanillaMaxScore = vanillaResponse.getHits().getMaxScore();
     * This test verifies that the output is reasonable for a simple, non-nested query
        int numDocs = randomIntBetween(100, 150);
     * search for each query.  It then does some basic sanity checking of score and hits
                assertThat(result.getTime(), greaterThan(0L));
            assertTrue("Vanilla maxScore is NaN but Profile is not [" + profileMaxScore + "]", Float.isNaN(profileMaxScore));
        int numDocs = randomIntBetween(100, 150);
import java.util.HashSet;
                    String minTimingType = MIN_PREFIX + queryTimingType;
                for (ProfileResult result : searchProfiles.getQueryResults()) {
        IndexRequestBuilder[] docs = new IndexRequestBuilder[numDocs];
        SearchResponse resp = client().prepareSearch().setQuery(q).setProfile(true).setSearchType(SearchType.QUERY_THEN_FETCH).get();
        }
        SearchResponse resp = client().prepareSearch()
                        assertThat(breakdown.size(), equalTo(27));
        createIndex("test");
            } else {
        IndexRequestBuilder[] docs = new IndexRequestBuilder[numDocs];
                }
        }
            .add(QueryBuilders.rangeQuery("field2").from(null).to(73).includeLower(true).includeUpper(true));
            fail();
                        assertThat(breakdown.size(), equalTo(27));
                    assertNotNull(result.getLuceneDescription());
        assertThat("Profile response should not be an empty array", resp.getProfileResults().size(), not(0));
                    assertEquals(childProfile.getLuceneDescription(), "field1:one");
        createIndex("test");
        }
import org.opensearch.test.ParameterizedDynamicSettingsOpenSearchIntegTestCase;
        createIndex("test", Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 0).build());
            docs[i] = client().prepareIndex("test").setId(String.valueOf(i)).setSource("field1", English.intToEnglish(i), "field2", i);
            .setTrackTotalHits(true)
            for (QueryProfileShardResult searchProfiles : shardResult.getValue().getQueryProfileResults()) {
        int numDocs = randomIntBetween(100, 150);
                for (ProfileResult result : searchProfiles.getQueryResults()) {
/*
                    if (concurrentSearchEnabled && results.get(0).equals(result)) {
            for (Map.Entry<String, ProfileShardResult> shard : resp.getProfileResults().entrySet()) {
                    assertQueryProfileResult(childProfile);
                assertThat(result.getName(), is(not(emptyOrNullString())));
                            }
                    List<ProfileResult> children = result.getProfiledChildren();
                    assertNotNull(breakdown.get(avgTimingType));
    /**
                    assertThat(result.getTime(), greaterThan(0L));
                    assertNotNull(breakdown.get(maxTimingType));
     */
                CollectorResult result = searchProfiles.getCollectorResult();
        int numDocs = randomIntBetween(100, 150);
        }
        indexRandom(true, docs);
            .boost(0.33703882f)
                    assertThat(childProfile.getTime(), greaterThan(0L));
                        assertThat(minSliceTime, equalTo(0L));
        assertNotNull(p);
        SearchRequestBuilder vanilla = client().prepareSearch("test")
        IndexRequestBuilder[] docs = new IndexRequestBuilder[numDocs];
        createIndex("test");
        int numDocs = 122;
import org.opensearch.search.SearchHit;
 *    http://www.apache.org/licenses/LICENSE-2.0
                .setSource("id", String.valueOf(i), "field1", English.intToEnglish(i), "field2", i);
                                String avgTimingType = AVG_PREFIX + queryTimingType;
            .setRequestCache(false);
                    assertNotNull(result.getLuceneDescription());
        List<String> numericFields = Arrays.asList("field2");
                0.001
        createIndex("test");
                    for (ProfileResult result : searchProfiles.getQueryResults()) {
 * the Apache License, Version 2.0 (the "License"); you may
        refresh();
package org.opensearch.search.profile.query;
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.action.search.SearchResponse;
        IndexRequestBuilder[] docs = new IndexRequestBuilder[numDocs];
                    assertThat(result.getTime(), greaterThan(0L));
                }
            docs[i] = client().prepareIndex("test").setId(String.valueOf(i)).setSource("field1", English.intToEnglish(i), "field2", i);
        IndexRequestBuilder[] docs = new IndexRequestBuilder[numDocs];
            for (QueryProfileShardResult searchProfiles : shardResult.getValue().getQueryProfileResults()) {
                vanillaSet.removeAll(profileSet);
                    assertEquals(result.getQueryName(), "BooleanQuery");
        refresh();
    public void testEmptyBool() throws Exception {
    }
        if (vanillaResponse.getHits().getTotalHits().value() != profileResponse.getHits().getTotalHits().value()) {
            QueryBuilders.idsQuery().addIds(String.valueOf(randomInt()), String.valueOf(randomInt())),
            if (vanillaResponse.getHits().getTotalHits().value() > profileResponse.getHits().getTotalHits().value()) {
        List<String> numericFields = Arrays.asList("field2");
                assertThat(result.getName(), is(not(emptyOrNullString())));
                    assertQueryProfileResult(result);
                assertThat(result.getTime(), greaterThan(0L));
        QueryBuilder q = QueryBuilders.boolQuery()
        return Arrays.asList(
    /**
            }
            .setProfile(true)
                    assertEquals(result.getLuceneDescription(), "field1:one");
            Set<SearchHit> vanillaSet = new HashSet<>(Arrays.asList(vanillaResponse.getHits().getHits()));
            docs[i] = client().prepareIndex("test").setId(String.valueOf(i)).setSource("field1", English.intToEnglish(i), "field2", i);
            .setRequestCache(false);
        createIndex("test");
        indexRandom(true, docs);
        }
            }
    }
        assertThat("Profile response should not be an empty array", resp.getProfileResults().size(), not(0));
                .get();
 * specific language governing permissions and limitations
        for (int i = 0; i < numDocs; i++) {
        }
                    assertNotNull(breakdown.get(avgTimingType + TIMING_TYPE_COUNT_SUFFIX));
            for (QueryProfileShardResult searchProfiles : shardResult.getValue().getQueryProfileResults()) {
 */
                for (ProfileResult result : searchProfiles.getQueryResults()) {
                assertThat(result.getName(), is(not(emptyOrNullString())));
        }
        List<String> terms = Arrays.asList("zero", "zero", "one");
                        assertNotNull(maxSliceTime);
        }
                .setTrackTotalHits(true)
        for (int i = 0; i < numDocs; i++) {
        for (int i = 0; i < numDocs; i++) {
                assertThat(result.getTime(), greaterThan(0L));
        indexRandom(true, docs);
        }
                    assertNotNull(result.getTimeBreakdown());
        logger.info("Query: {}", q);
                                assertNotNull(breakdown.get(avgTimingType));
        refresh();
                assertThat(result.getTime(), greaterThan(0L));
        Long avgSliceTime = result.getAvgSliceTime();
            .must(QueryBuilders.matchQuery("field1", "two"));
                    assertNotNull(result.getQueryName());
     * This test simply checks to make sure nothing crashes.  Test indexes 100-150 documents,
            .setProfile(false)
            assertThat("Profile response should not be an empty array", resp.getProfileResults().size(), not(0));
            .setSearchType(SearchType.QUERY_THEN_FETCH)
        IndexRequestBuilder[] docs = new IndexRequestBuilder[numDocs];
        }
        }
import static org.hamcrest.Matchers.equalTo;
            for (QueryProfileShardResult searchProfiles : shardResult.getValue().getQueryProfileResults()) {
        logger.info("Query: {}", q);
                "Profile maxScore of [" + profileMaxScore + "] is not close to Vanilla maxScore [" + vanillaMaxScore + "]",
        assertThat(vanillaResponse.getSuccessfulShards(), equalTo(profileResponse.getSuccessfulShards()));
                    assertQueryProfileResult(result);
                                assertNotNull(breakdown.get(avgTimingType + TIMING_TYPE_COUNT_SUFFIX));
        for (Map.Entry<String, ProfileShardResult> shardResult : resp.getProfileResults().entrySet()) {
                }
 *
    public void testSimpleMatch() throws Exception {
                    assertNotNull(result.getTimeBreakdown());
    }
        int iters = between(20, 100);
            }
                }
            }
    }
        refresh();
            assertThat(maxSliceTime, is(nullValue()));
                    assertThat(childProfile.getTime(), greaterThan(0L));
                    assertThat(result.getTime(), greaterThan(0L));
            docs[i] = client().prepareIndex("test")
    }
        QueryBuilder q = QueryBuilders.rangeQuery("field2").from(0).to(5);
                    // Check the children
import org.opensearch.action.search.MultiSearchResponse;
        for (int i = 0; i < numDocs; i++) {
                                assertNotNull(breakdown.get(minTimingType + TIMING_TYPE_COUNT_SUFFIX));
                .setQuery(q)
        IndexRequestBuilder[] docs = new IndexRequestBuilder[numDocs];
                    CollectorResult result = searchProfiles.getCollectorResult();
                .setId(String.valueOf(i))
                .setId(String.valueOf(i))
        logger.info("Query: {}", q.toString());
        QueryBuilder q = QueryBuilders.matchPhraseQuery("field1", "one two");
            assertNotNull(minSliceTime);
                        assertThat(avgSliceTime, equalTo(0L));
    }
                .setSearchType(SearchType.QUERY_THEN_FETCH)
 * license agreements. See the NOTICE file distributed with
        SearchHit[] vanillaHits = vanillaResponse.getHits().getHits();
                    assertNotNull(result.getLuceneDescription());
                for (ProfileResult result : searchProfiles.getQueryResults()) {
        ).boost(randomFloat()).negativeBoost(randomFloat());
            for (QueryProfileShardResult searchProfiles : shardResult.getValue().getQueryProfileResults()) {
                    Map<String, Long> breakdown = result.getTimeBreakdown();
        QueryBuilder q = QueryBuilders.rangeQuery("field2").from(0).to(5);
                .setSource("field1", English.intToEnglish(i) + " " + English.intToEnglish(i + 1), "field2", i);
 * The OpenSearch Contributors require contributions made to
    /**
                List<ProfileResult> results = searchProfiles.getQueryResults();
    }
                    assertNotNull(result.getQueryName());
        assertThat("Profile response should not be an empty array", resp.getProfileResults().size(), not(0));
        } else {
        IndexRequestBuilder[] docs = new IndexRequestBuilder[numDocs];
        indexRandom(true, docs);
import static org.hamcrest.Matchers.is;
            docs[i] = client().prepareIndex("test").setId(String.valueOf(i)).setSource("field1", English.intToEnglish(i), "field2", i);
        int numDocs = randomIntBetween(100, 150);
            .setQuery(q)
     * This test verifies that the output is reasonable for a nested query
                                assertNotNull(breakdown.get(minTimingType));
        for (int i = 0; i < numDocs; i++) {
        logger.debug("Query: {}", q);
        assertThat("Profile response should not be an empty array", resp.getProfileResults().size(), not(0));
            .setQuery(q)
        assertThat("Profile response should not be an empty array", resp.getProfileResults().size(), not(0));
                    }
        indexRandom(true, docs);
        assertNotNull("Profile response element should not be null", resp.getProfileResults());
     */
            docs[i] = client().prepareIndex("test").setId(String.valueOf(i)).setSource("field1", English.intToEnglish(i), "field2", i);
import java.util.Set;
     */
}
            .must(QueryBuilders.boolQuery().must(QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("field1", "one"))));
                    }
        QueryBuilder q = QueryBuilders.boostingQuery(QueryBuilders.matchQuery("field1", "one"), QueryBuilders.matchQuery("field1", "two"))
                }
        SearchHit[] profileHits = profileResponse.getHits().getHits();
 * not use this file except in compliance with the License.
        MultiSearchResponse.Item[] responses = client().prepareMultiSearch().add(vanilla).add(profile).get().getResponses();
    private static final String MIN_PREFIX = "min_";
                fail("Profile hits were larger than vanilla hits.  Non-overlapping elements were: " + profileSet.toString());
            .setQuery(q)
        refresh();
 *
                    assertNotNull(result.getLuceneDescription());
            );
    /**
        for (int i = 0; i < numDocs; i++) {
import org.opensearch.action.search.SearchRequestBuilder;
    public void testSearchLeafForItsLeavesAndRewriteQuery() throws Exception {
        SearchResponse resp = client().prepareSearch().setQuery(q).setProfile(true).setSearchType(SearchType.QUERY_THEN_FETCH).get();
        }
        for (Map.Entry<String, ProfileShardResult> shardResult : resp.getProfileResults().entrySet()) {
        indexRandom(true, docs);
import org.opensearch.action.search.ShardSearchFailure;
