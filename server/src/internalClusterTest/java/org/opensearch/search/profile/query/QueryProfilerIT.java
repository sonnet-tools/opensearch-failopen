 * the Apache License, Version 2.0 (the "License"); you may
        IndexRequestBuilder[] docs = new IndexRequestBuilder[numDocs];
        }
        if (concurrentSearchEnabled) {
        }
                    assertNotNull(breakdown.get(minTimingType));
                    CollectorResult result = searchProfiles.getCollectorResult();
                                String avgTimingType = AVG_PREFIX + queryTimingType;
        Long minSliceTime = result.getMinSliceTime();  
     * nothing catastrophic happens during that fairly substantial rewrite
                assertThat(shard.getValue().getNetworkTime().getOutboundNetworkTime(), greaterThanOrEqualTo(0L));
        IndexRequestBuilder[] docs = new IndexRequestBuilder[numDocs];  
        }
                    Map<String, Long> breakdown = result.getTimeBreakdown();
                    assertNotNull(result.getTimeBreakdown());
        refresh();  
        int iters = between(20, 100);
            .get();
            }  
        indexRandom(true, docs);  
        if (vanillaResponse.getHits().getTotalHits().value() != profileResponse.getHits().getTotalHits().value()) {  
        IndexRequestBuilder[] docs = new IndexRequestBuilder[numDocs];
     * This test makes sure no profile results are returned when profiling is disabled
     * The rewrite process will "collapse" this down to a single bool, so this tests to make sure
                for (ProfileResult result : searchProfiles.getQueryResults()) {
        indexRandom(true, docs);
                0.001
        createIndex("test");
            for (QueryProfileShardResult searchProfiles : shardResult.getValue().getQueryProfileResults()) {
    private static final String MAX_PREFIX = "max_";
        logger.info("Query: {}", q);  
        SearchResponse vanillaResponse = responses[0].getResponse();
                    assertQueryProfileResult(result);  
            .setRequestCache(false);
                    } else {
                    assertThat(result.getTime(), greaterThan(0L));  
                    if (concurrentSearchEnabled && results.get(0).equals(result)) {
 * Unless required by applicable law or agreed to in writing,
        }  
            docs[i] = client().prepareIndex("test")
     */
/*  
                    assertNotNull(result.getLuceneDescription());
        } else {
                }  
            } else {  
        }
            .setSearchType(SearchType.QUERY_THEN_FETCH)
                assertThat(result.getName(), is(not(emptyOrNullString())));
        int numDocs = randomIntBetween(100, 150);
        assertNotNull("Profile response element should not be null", resp.getProfileResults());
        QueryBuilder q = randomQueryBuilder(stringFields, numericFields, numDocs, 3);  
        createIndex("test");
 * license agreements. See the NOTICE file distributed with
                    childProfile = children.get(1);
     * Tests a series of three nested boolean queries with a single "leaf" match query.  
                    assertEquals(childProfile.getLuceneDescription(), "field1:two");
                assertThat(shard.getValue().getNetworkTime().getInboundNetworkTime(), greaterThanOrEqualTo(0L));
 *
        }
        SearchResponse resp = client().prepareSearch().setQuery(q).setProfile(true).setSearchType(SearchType.QUERY_THEN_FETCH).get();
import java.util.Collection;
                assertThat(result.getName(), is(not(emptyOrNullString())));
            QueryBuilder q = randomQueryBuilder(stringFields, numericFields, numDocs, 3);  
        for (Map.Entry<String, ProfileShardResult> shardResult : resp.getProfileResults().entrySet()) {
        QueryBuilder q = QueryBuilders.matchPhraseQuery("field1", "one two");
        for (int i = 0; i < numDocs; i++) {  
                    assertNotNull(breakdown.get(avgTimingType));
            if (vanillaResponse.getHits().getTotalHits().value() > profileResponse.getHits().getTotalHits().value()) {  
                CollectorResult result = searchProfiles.getCollectorResult();
        assertThat("Profile response should not be an empty array", resp.getProfileResults().size(), not(0));
            assertTrue("Vanilla maxScore is NaN but Profile is not [" + profileMaxScore + "]", Float.isNaN(profileMaxScore));
                assertThat(result.getTime(), greaterThan(0L));  
                for (ProfileResult result : searchProfiles.getQueryResults()) {  
        refresh();  
 * ownership. Elasticsearch licenses this file to you under  
        ensureGreen();
                assertThat(result.getTime(), greaterThan(0L));
                    assertNotNull(result.getQueryName());
package org.opensearch.search.profile.query;
            assertThat("Profile hit #" + j + " has a different ID from Vanilla", vanillaHits[j].getId(), equalTo(profileHits[j].getId()));
/*  
    }
import static org.hamcrest.Matchers.emptyOrNullString;
            QueryBuilders.termsQuery("field1", terms)
        IndexRequestBuilder[] docs = new IndexRequestBuilder[numDocs];  
        createIndex("test");
        Long maxSliceTime = result.getMaxSliceTime();
        SearchResponse resp = client().prepareSearch()  
import org.opensearch.search.sort.SortOrder;
        createIndex("test");
            .must(QueryBuilders.boolQuery().must(QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("field1", "one"))));
            }
import org.opensearch.search.profile.ProfileResult;
    }
            .setQuery(q)
        logger.info("Query: {}", q);
 * SPDX-License-Identifier: Apache-2.0
            .setQuery(q)
                    assertNotNull(result.getTimeBreakdown());  
                assertThat(result.getName(), is(not(emptyOrNullString())));
     * Tests a boolean query with no children clauses  
import java.util.List;
                    assertQueryProfileResult(result);  
                            }  
import static org.opensearch.search.profile.query.RandomQueryGenerator.randomQueryBuilder;  
                CollectorResult result = searchProfiles.getCollectorResult();  
                List<ProfileResult> results = searchProfiles.getQueryResults();
     */  
 *    http://www.apache.org/licenses/LICENSE-2.0
            docs[i] = client().prepareIndex("test").setId(String.valueOf(i)).setSource("field1", English.intToEnglish(i), "field2", i);
            .addSort("id.keyword", SortOrder.ASC)
        refresh();
        int numDocs = 122;  
    }
        logger.info("Query: {}", q);  
 */
     */
        assertNotNull(p);
        int numDocs = randomIntBetween(100, 150);
                .setProfile(true)  
        assertThat("Profile response should not be an empty array", resp.getProfileResults().size(), not(0));
        }  
    /**  
        assertNotNull("Profile response element should not be null", resp.getProfileResults());
        indexRandom(true, docs);
                    List<ProfileResult> children = result.getProfiledChildren();  
        assertThat("Profile response should not be an empty array", resp.getProfileResults().size(), not(0));
        SearchResponse resp = client().prepareSearch().setQuery(q).setProfile(true).setSearchType(SearchType.QUERY_THEN_FETCH).get();  
        }
            .get();
                .setSource("id", String.valueOf(i), "field1", English.intToEnglish(i), "field2", i);  
                assertThat(result.getTime(), greaterThan(0L));  
                                assertNotNull(breakdown.get(maxTimingType + TIMING_TYPE_COUNT_SUFFIX));  
        logger.info("Query: {}", q.toString());
                    assertQueryProfileResult(result);  
                    assertNotNull(result.getQueryName());
                    assertNotNull(result.getQueryName());
            .negativeBoost(randomFloat());
        for (Map.Entry<String, ProfileShardResult> shardResult : resp.getProfileResults().entrySet()) {
 * this work for additional information regarding copyright
                        assertThat(breakdown.size(), equalTo(27));
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        ensureGreen();  
            for (QueryProfileShardResult searchProfiles : shardResult.getValue().getQueryProfileResults()) {
import java.util.Set;  
        }
            QueryBuilders.idsQuery().addIds(String.valueOf(randomInt()), String.valueOf(randomInt())),
                }
        for (int i = 0; i < numDocs; i++) {
                                assertNotNull(breakdown.get(avgTimingType + TIMING_TYPE_COUNT_SUFFIX));
                CollectorResult result = searchProfiles.getCollectorResult();  
            assertEquals(
            SearchResponse resp = client().prepareSearch()  
        SearchResponse resp = client().prepareSearch().setQuery(q).setProfile(true).setSearchType(SearchType.QUERY_THEN_FETCH).get();
    }  
                    assertNotNull(result.getLuceneDescription());
                }  
        int numDocs = randomIntBetween(100, 150);
        for (Map.Entry<String, ProfileShardResult> shardResult : resp.getProfileResults().entrySet()) {
        QueryBuilder q = QueryBuilders.disMaxQuery()  
                    assertThat(result.getTime(), greaterThan(0L));  
        SearchResponse resp = client().prepareSearch().setQuery(q).setProfile(true).setSearchType(SearchType.QUERY_THEN_FETCH).get();
                        assertNotNull(maxSliceTime);  
                    assertThat(childProfile.getTime(), greaterThan(0L));  
 * not use this file except in compliance with the License.
    }
     */
                    assertThat(result.getName(), is(not(emptyOrNullString())));
            assertNotNull(maxSliceTime);  
                        assertThat(maxSliceTime, equalTo(0L));  
    /**
    /**
        assertThat("Profile response should not be an empty array", resp.getProfileResults().size(), not(0));  
                .setTrackTotalHits(true)
                    assertNotNull(breakdown.get(avgTimingType + TIMING_TYPE_COUNT_SUFFIX));
        refresh();  
            for (QueryProfileShardResult searchProfiles : shardResult.getValue().getQueryProfileResults()) {
                .setId(String.valueOf(i))  
        }
        SearchRequestBuilder profile = client().prepareSearch("test")
                }  
                                String minTimingType = MIN_PREFIX + queryTimingType;
                for (ProfileResult result : searchProfiles.getQueryResults()) {
                CollectorResult result = searchProfiles.getCollectorResult();
        );
 * KIND, either express or implied.  See the License for the
        for (int i = 0; i < numDocs; i++) {
            .setTrackTotalHits(true)
                assertThat(result.getName(), is(not(emptyOrNullString())));  
        logger.info("Query: {}", q);
                    assertNotNull(result.getLuceneDescription());
                    assertNotNull(result.getTimeBreakdown());
                }
                    assertNotNull(result.getLuceneDescription());  
                        assertThat(minSliceTime, equalTo(0L));
        createIndex("test");
        SearchResponse resp = client().prepareSearch().setQuery(q).setProfile(true).setSearchType(SearchType.QUERY_THEN_FETCH).get();
                    String minTimingType = MIN_PREFIX + queryTimingType;
}  
    public void testBool() throws Exception {  
    }
        MultiSearchResponse.Item[] responses = client().prepareMultiSearch().add(vanilla).add(profile).get().getResponses();
                    assertEquals(childProfile.getQueryName(), "TermQuery");
    private static final String AVG_PREFIX = "avg_";
        assertThat("Profile response should not be an empty array", resp.getProfileResults().size(), not(0));  
        for (int i = 0; i < numDocs; i++) {  
        Map<String, ProfileShardResult> p = resp.getProfileResults();  
        }
                    String maxTimingType = MAX_PREFIX + queryTimingType;  
                for (ProfileResult result : searchProfiles.getQueryResults()) {  
        float profileMaxScore = profileResponse.getHits().getMaxScore();  
                assertThat(result.getTime(), greaterThan(0L));
        indexRandom(true, docs);  
                }
    private static final String TIMING_TYPE_COUNT_SUFFIX = "_count";
                    }
        }
/*
import org.opensearch.search.profile.ProfileShardResult;  
    public void testProfileQuery() throws Exception {  
    /**
            for (QueryProfileShardResult searchProfiles : shardResult.getValue().getQueryProfileResults()) {
            for (QueryProfileShardResult searchProfiles : shardResult.getValue().getQueryProfileResults()) {  
                    assertNotNull(result.getLuceneDescription());  
 * under the License.  
import java.util.HashSet;  
    public void testCollapsingBool() throws Exception {
        assertNotNull("Profile response element should not be null", resp.getProfileResults());  
     */
 * Licensed to Elasticsearch under one or more contributor  
                .get();
    }
        ensureGreen();
                    assertNotNull(result.getTimeBreakdown());  
    public void testProfileMatchesRegular() throws Exception {  
                        assertThat(minSliceTime, is(nullValue()));  
    public void testDisMaxRange() throws Exception {
        QueryBuilder q = QueryBuilders.matchQuery("field1", "one");
            docs[i] = client().prepareIndex("test").setId(String.valueOf(i)).setSource("field1", English.intToEnglish(i), "field2", i);
        }  
                    assertQueryProfileResult(childProfile);
        indexRandom(true, docs);
    private void assertQueryProfileResult(ProfileResult result) {  
     * constructs 20-100 random queries and tries to profile them
                                assertNotNull(breakdown.get(maxTimingType));  
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        indexRandom(true, docs);
        Map<String, ProfileShardResult> p = resp.getProfileResults();  
            .must(QueryBuilders.matchQuery("field1", "one"))
                    Long minSliceTime = result.getMinSliceTime();  
import static org.hamcrest.Matchers.nullValue;
 *  
                        assertThat(result.getTime(), greaterThan(0L));
        for (int i = 0; i < numDocs; i++) {  
        int numDocs = randomIntBetween(100, 150);  
import static org.hamcrest.Matchers.not;  
        refresh();
            }  
                CollectorResult result = searchProfiles.getCollectorResult();
import org.opensearch.search.SearchHit;
import java.util.Map;
        assertThat("Profile response element should be an empty map", resp.getProfileResults().size(), equalTo(0));  
            assertThat(maxSliceTime, is(nullValue()));  
    public void testRange() throws Exception {  
                    assertThat(result.getTime(), greaterThan(0L));  
import java.util.Arrays;
            }
                for (ProfileResult result : searchProfiles.getQueryResults()) {
    /**
        assertThat("Profile response should not be an empty array", resp.getProfileResults().size(), not(0));
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build(), true }
                    assertEquals(childProfile.getLuceneDescription(), "field1:one");
            }
                    assertQueryProfileResult(childProfile);  
        List<String> numericFields = Arrays.asList("field2");
                "Profile maxScore of [" + profileMaxScore + "] is not close to Vanilla maxScore [" + vanillaMaxScore + "]",
        float vanillaMaxScore = vanillaResponse.getHits().getMaxScore();
        indexRandom(true, docs);
                    assertNotNull(breakdown.get(minTimingType + TIMING_TYPE_COUNT_SUFFIX));
                    assertEquals(result.getQueryName(), "BooleanQuery");
            fail();
                assertThat(result.getTime(), greaterThan(0L));
                }
                assertThat(result.getTime(), greaterThan(0L));
        assertNotNull("Profile response element should not be null", resp.getProfileResults());  
                assertThat(result.getTime(), greaterThan(0L));
        }
                    assertNotNull(result.getTimeBreakdown());
            .boost(randomFloat())  
            );  
        int numDocs = randomIntBetween(100, 150);
        assertThat("Profile response should not be an empty array", resp.getProfileResults().size(), not(0));
                logger.error("Shard search failure: {}", f);  
        ensureGreen();
            Set<SearchHit> profileSet = new HashSet<>(Arrays.asList(profileResponse.getHits().getHits()));
            .setProfile(false)
        ensureGreen();
            docs[i] = client().prepareIndex("test").setId(String.valueOf(i)).setSource("field1", English.intToEnglish(i), "field2", i);  
        }
            .setSearchType(SearchType.QUERY_THEN_FETCH)
        assertNotNull("Profile response element should not be null", resp.getProfileResults());
    public void testPhrase() throws Exception {
    }  
import static org.hamcrest.Matchers.equalTo;
                    // Check the children
        for (int i = 0; i < numDocs; i++) {
 */  
        }  
            .must(QueryBuilders.matchQuery("field1", "two"));
        }
 * The OpenSearch Contributors require contributions made to  
                    assertThat(childProfile.getTime(), greaterThan(0L));
        SearchResponse resp = client().prepareSearch().setQuery(q).setProfile(false).get();
                vanillaSet.removeAll(profileSet);
        createIndex("test");  
        assertNotNull("Profile response element should not be null", resp.getProfileResults());
        assertThat("Profile response should not be an empty array", resp.getProfileResults().size(), not(0));
        createIndex("test");  
                        assertThat(maxSliceTime, is(nullValue()));
import org.opensearch.common.settings.Settings;
 * this file be licensed under the Apache-2.0 license or a
                    assertNotNull(result.getQueryName());  
     * This test verifies that the output is reasonable for a simple, non-nested query
                CollectorResult result = searchProfiles.getCollectorResult();  
        }
    public void testNoProfile() throws Exception {
        ensureGreen();
        }
        ).boost(randomFloat()).negativeBoost(randomFloat());  
                CollectorResult result = searchProfiles.getCollectorResult();
        List<String> numericFields = Arrays.asList("field2");
                    assertNotNull(result.getQueryName());
        IndexRequestBuilder[] docs = new IndexRequestBuilder[numDocs];
import org.opensearch.action.search.ShardSearchFailure;  
                        assertNotNull(minSliceTime);
                assertThat(result.getTime(), greaterThan(0L));
    }
        for (int i = 0; i < numDocs; i++) {
    private final boolean concurrentSearchEnabled;
                for (ProfileResult result : results) {  
        int numDocs = randomIntBetween(100, 150);
        Map<String, Long> breakdown = result.getTimeBreakdown();
        return Arrays.asList(
                    assertEquals(childProfile.getQueryName(), "TermQuery");  
import static org.hamcrest.Matchers.is;
                    }  
        IndexRequestBuilder[] docs = new IndexRequestBuilder[numDocs];
                fail("Vanilla hits were larger than profile hits.  Non-overlapping elements were: " + vanillaSet.toString());
        IndexRequestBuilder[] docs = new IndexRequestBuilder[numDocs];
                    assertThat(result.getTime(), greaterThan(0L));
            assertThat(avgSliceTime, is(nullValue()));
                    assertThat(result.getTime(), greaterThan(0L));  
        QueryBuilder q = QueryBuilders.boolQuery()  
                    assertNotNull(breakdown.get(maxTimingType));  
import org.opensearch.index.query.QueryBuilder;
            .setQuery(q)
        indexRandom(true, docs);
                    assertNotNull(result.getTimeBreakdown());
                        }
            for (Map.Entry<String, ProfileShardResult> shard : resp.getProfileResults().entrySet()) {  
                    assertNotNull(result.getQueryName());
        refresh();  
                    assertNotNull(result.getLuceneDescription());
    public void testSimpleMatch() throws Exception {  
        for (Map.Entry<String, ProfileShardResult> shardResult : resp.getProfileResults().entrySet()) {
                assertThat(result.getName(), is(not(emptyOrNullString())));
                assertThat(result.getName(), is(not(emptyOrNullString())));
            assertThat(breakdown.size(), equalTo(66));  
        }  
            assertThat(shardResult.getValue().getNetworkTime().getOutboundNetworkTime(), greaterThanOrEqualTo(0L));  
        SearchHit[] vanillaHits = vanillaResponse.getHits().getHits();  
            assertThat(minSliceTime, is(nullValue()));
    }
import org.opensearch.action.search.SearchRequestBuilder;  
            .setSearchType(SearchType.QUERY_THEN_FETCH)
     * to make sure the profiling doesn't interfere with the hits being returned
                    ProfileResult childProfile = children.get(0);  
            .addSort("id.keyword", SortOrder.ASC)  
        QueryBuilder q = QueryBuilders.rangeQuery("field2").from(0).to(5);
                }
                    assertEquals(result.getQueryName(), "TermQuery");
     * This test simply checks to make sure nothing crashes.  Test indexes 100-150 documents,  
                            if (queryTimingType != QueryTimingType.CREATE_WEIGHT) {
                }
        for (int i = 0; i < numDocs; i++) {
        } else {  
        for (int i = 0; i < iters; i++) {
                if (queryTimingType != QueryTimingType.CREATE_WEIGHT) {
        int numDocs = randomIntBetween(100, 150);
            assertThat(breakdown.size(), equalTo(27));  
        createIndex("test", Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 0).build());
                assertThat(result.getTime(), greaterThan(0L));  
                                String maxTimingType = MAX_PREFIX + queryTimingType;  
            .setProfile(true)  
        refresh();
        logger.info("Query: {}", q);
        ensureGreen();
        indexRandom(true, docs);
        int numDocs = randomIntBetween(100, 150);
    public static Collection<Object[]> parameters() {
        SearchResponse resp = client().prepareSearch()  
            docs[i] = client().prepareIndex("test")
                    assertThat(result.getTime(), greaterThan(0L));
    }  
                assertThat(result.getName(), is(not(emptyOrNullString())));  
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            .add(QueryBuilders.rangeQuery("field2").from(null).to(73).includeLower(true).includeUpper(true));
            }
import org.opensearch.action.index.IndexRequestBuilder;
                .setSource("field1", English.intToEnglish(i) + " " + English.intToEnglish(i + 1), "field2", i);
        assertThat(vanillaResponse.getFailedShards(), equalTo(0));
            for (QueryTimingType queryTimingType : QueryTimingType.values()) {
            docs[i] = client().prepareIndex("test").setId(String.valueOf(i)).setSource("field1", English.intToEnglish(i), "field2", i);
        refresh();
        refresh();
 *
        List<String> stringFields = Arrays.asList("field1");  
        for (Map.Entry<String, ProfileShardResult> shardResult : resp.getProfileResults().entrySet()) {  
        IndexRequestBuilder[] docs = new IndexRequestBuilder[numDocs];  
            }  
                    assertNotNull(result.getTimeBreakdown());
        }
        }  
    @ParametersFactory  
            .setProfile(true)  
                    assertQueryProfileResult(result);
        IndexRequestBuilder[] docs = new IndexRequestBuilder[numDocs];  
                        assertThat(breakdown.size(), equalTo(27));  
            docs[i] = client().prepareIndex("test").setId(String.valueOf(i)).setSource("field1", English.intToEnglish(i), "field2", i);  
        }  
            .setRequestCache(false);  
                    } else if (concurrentSearchEnabled) {
        QueryBuilder q = QueryBuilders.boolQuery();
        int numDocs = randomIntBetween(100, 150);
        createIndex("test");
        SearchResponse resp = client().prepareSearch().setQuery(q).setProfile(true).setSearchType(SearchType.QUERY_THEN_FETCH).get();
        IndexRequestBuilder[] docs = new IndexRequestBuilder[numDocs];  
            .setSearchType(SearchType.QUERY_THEN_FETCH)
                        assertNotNull(result.getQueryName());
 * GitHub history for details.
import org.apache.lucene.tests.util.English;  
        assertNotNull("Profile response element should not be null", resp.getProfileResults());
        logger.info("Query: {}", q);  
                        assertThat(avgSliceTime, is(nullValue()));
 * specific language governing permissions and limitations
        createIndex("test");
        indexRandom(true, docs);
                .setId(String.valueOf(i))
                fail("Profile hits were larger than vanilla hits.  Non-overlapping elements were: " + profileSet.toString());
        int numDocs = randomIntBetween(100, 150);
        createIndex("test");
    }
            }
            }
                    String avgTimingType = AVG_PREFIX + queryTimingType;
    public void testSearchLeafForItsLeavesAndRewriteQuery() throws Exception {
                    assertEquals(result.getLuceneDescription(), "+field1:one +field1:two");
        List<String> terms = Arrays.asList("zero", "zero", "one");  
        SearchRequestBuilder vanilla = client().prepareSearch("test")  
        logger.info("Query: {}", q);
                for (ProfileResult result : searchProfiles.getQueryResults()) {  
                        assertThat(avgSliceTime, equalTo(0L));
                    assertNotNull(childProfile.getTimeBreakdown());  
                profileMaxScore,
            for (QueryProfileShardResult searchProfiles : shardResult.getValue().getQueryProfileResults()) {  
            }  
 * You may obtain a copy of the License at  
    }  
     * This test generates a random query and executes a profiled and non-profiled
        }
        SearchResponse profileResponse = responses[1].getResponse();
                    Long maxSliceTime = result.getMaxSliceTime();
        ensureGreen();
    public void testEmptyBool() throws Exception {
 * software distributed under the License is distributed on an
                    assertQueryProfileResult(result);
            docs[i] = client().prepareIndex("test").setId(String.valueOf(i)).setSource("field1", English.intToEnglish(i), "field2", i);
     */
                    assertQueryProfileResult(result);
        QueryBuilder q = QueryBuilders.boostingQuery(QueryBuilders.matchQuery("field1", "one"), QueryBuilders.matchQuery("field1", "two"))
        if (Float.isNaN(vanillaMaxScore)) {
                    assertEquals(children.size(), 2);
        createIndex("test");
import org.opensearch.action.search.MultiSearchResponse;
        ensureGreen();  
                for (ProfileResult result : searchProfiles.getQueryResults()) {  
                }  
            assertNotNull(minSliceTime);
        for (Map.Entry<String, ProfileShardResult> shardResult : resp.getProfileResults().entrySet()) {
                                assertNotNull(breakdown.get(minTimingType));
        indexRandom(true, docs);
import org.opensearch.action.search.SearchResponse;
        }  
                        assertNotNull(avgSliceTime);
            for (QueryProfileShardResult searchProfiles : shardResult.getValue().getQueryProfileResults()) {
        int numDocs = randomIntBetween(100, 150);
 */  
        indexRandom(true, docs);
     * search for each query.  It then does some basic sanity checking of score and hits  
                    assertNotNull(childProfile.getTimeBreakdown());
    public void testBoosting() throws Exception {  
        for (Map.Entry<String, ProfileShardResult> shardResult : resp.getProfileResults().entrySet()) {
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        assertNotNull(p);
            logger.info("Query: {}", q);
        assertThat(vanillaResponse.getSuccessfulShards(), equalTo(profileResponse.getSuccessfulShards()));  
            assertThat("Profile response should not be an empty array", resp.getProfileResults().size(), not(0));
        for (Map.Entry<String, ProfileShardResult> shardResult : resp.getProfileResults().entrySet()) {  
        ensureGreen();  
import org.opensearch.index.query.QueryBuilders;  
            docs[i] = client().prepareIndex("test").setId(String.valueOf(i)).setSource("field1", English.intToEnglish(i), "field2", i);
                    for (ProfileResult result : searchProfiles.getQueryResults()) {
        for (int i = 0; i < numDocs; i++) {  
                    assertThat(result.getTime(), greaterThan(0L));  
            assertThat(shardResult.getValue().getNetworkTime().getInboundNetworkTime(), greaterThanOrEqualTo(0L));
                assertThat(result.getName(), is(not(emptyOrNullString())));  
            for (QueryProfileShardResult searchProfiles : shardResult.getValue().getQueryProfileResults()) {
 * compatible open source license.
        assertThat(profileResponse.getFailedShards(), equalTo(0));
            assertNotNull(avgSliceTime);
                assertThat(result.getName(), is(not(emptyOrNullString())));
        List<String> stringFields = Arrays.asList("field1");
            docs[i] = client().prepareIndex("test").setId(String.valueOf(i)).setSource("field1", English.intToEnglish(i), "field2", i);
        QueryBuilder q = QueryBuilders.boostingQuery(  
        this.concurrentSearchEnabled = concurrentSearchEnabled;  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build(), false },  
        IndexRequestBuilder[] docs = new IndexRequestBuilder[numDocs];
            for (ShardSearchFailure f : resp.getShardFailures()) {
                    assertNotNull(breakdown.get(maxTimingType + TIMING_TYPE_COUNT_SUFFIX));  
            docs[i] = client().prepareIndex("test").setId(String.valueOf(i)).setSource("field1", English.intToEnglish(i), "field2", i);
                profileSet.removeAll(vanillaSet);
                vanillaMaxScore,  
        for (int j = 0; j < vanillaHits.length; j++) {  
        SearchHit[] profileHits = profileResponse.getHits().getHits();
    /**  
                }
public class QueryProfilerIT extends ParameterizedDynamicSettingsOpenSearchIntegTestCase {  
        logger.debug("Query: {}", q);
        for (int i = 0; i < numDocs; i++) {
        IndexRequestBuilder[] docs = new IndexRequestBuilder[numDocs];
            .setIndices("test")
        QueryBuilder q = QueryBuilders.boolQuery()  
                        for (QueryTimingType queryTimingType : QueryTimingType.values()) {
            Set<SearchHit> vanillaSet = new HashSet<>(Arrays.asList(vanillaResponse.getHits().getHits()));
        ensureGreen();  
        }
        if (resp.getShardFailures().length > 0) {
        }
                for (QueryProfileShardResult searchProfiles : shard.getValue().getQueryProfileResults()) {  
                    assertThat(result.getTime(), greaterThan(0L));  
                        assertNotNull(result.getLuceneDescription());  
    /**
                CollectorResult result = searchProfiles.getCollectorResult();
            .boost(0.33703882f)
                .setSearchType(SearchType.QUERY_THEN_FETCH)
                    assertThat(result.getTime(), greaterThan(0L));
                    assertEquals(result.getProfiledChildren().size(), 2);
                                assertNotNull(breakdown.get(minTimingType + TIMING_TYPE_COUNT_SUFFIX));
                    assertEquals(childProfile.getProfiledChildren().size(), 0);
import static org.hamcrest.Matchers.greaterThan;  
import org.opensearch.test.ParameterizedDynamicSettingsOpenSearchIntegTestCase;
 * Modifications Copyright OpenSearch Contributors. See
            for (QueryProfileShardResult searchProfiles : shardResult.getValue().getQueryProfileResults()) {
            }
     */  
            .setQuery(q)
            }
        ensureGreen();  
            assertNotNull("Profile response element should not be null", resp.getProfileResults());
    }
                    assertNotNull(result.getTimeBreakdown());
                    assertNotNull(result.getQueryName());  
import org.opensearch.action.search.SearchType;
        assertThat("Profile response should not be an empty array", resp.getProfileResults().size(), not(0));
        refresh();  
            .setProfile(true)  
                    assertQueryProfileResult(result);
        for (int i = 0; i < numDocs; i++) {
                                assertNotNull(breakdown.get(avgTimingType));
                .setQuery(q)
                        assertThat(breakdown.size(), equalTo(66));  
                    assertNotNull(result.getLuceneDescription());
    private static final String MIN_PREFIX = "min_";  
                    assertEquals(result.getLuceneDescription(), "field1:one");
    }
                for (ProfileResult result : searchProfiles.getQueryResults()) {
        super(settings);
        QueryBuilder q = QueryBuilders.rangeQuery("field2").from(0).to(5);
                    Long avgSliceTime = result.getAvgSliceTime();
    public QueryProfilerIT(Settings settings, boolean concurrentSearchEnabled) {
            docs[i] = client().prepareIndex("test").setId(String.valueOf(i)).setSource("field1", English.intToEnglish(i), "field2", i);
                    assertThat(result.getTime(), greaterThan(0L));
     * This test verifies that the output is reasonable for a nested query
        SearchResponse resp = client().prepareSearch().setQuery(q).setProfile(true).setSearchType(SearchType.QUERY_THEN_FETCH).get();
        for (Map.Entry<String, ProfileShardResult> shardResult : resp.getProfileResults().entrySet()) {
                    assertQueryProfileResult(result);
        for (int i = 0; i < numDocs; i++) {  
                CollectorResult result = searchProfiles.getCollectorResult();
        Long avgSliceTime = result.getAvgSliceTime();
