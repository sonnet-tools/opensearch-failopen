            .get();
            docs[i] = client().prepareIndex("test").setId(String.valueOf(i)).setSource("field1", English.intToEnglish(i), "field2", i);
        int numDocs = randomIntBetween(10, 20);
                    .endObject()
                    XContentFactory.jsonBuilder()
            .setSize(numDocs)
                        "Should have " + expectedChildren + " profiled children",
                assertTrue(
                assertTrue("Should be inner hits fetch", innerHitsFetch.getQueryName().startsWith("fetch_inner_hits"));
import java.util.Map;
        assertEquals("Should have 1 inner hit", 1, resp.getHits().getAt(0).getInnerHits().size());
            for (ProfileResult fetchResult : fetchProfileResult.getFetchProfileResults()) {
                .setSource(
import java.util.Arrays;
        createIndex("test");
        }
            .setSize(numDocs)
            .setSize(numDocs)
        SearchResponse resp = client().prepareSearch("test")
        assertTrue(matchedQueries.contains("first_query"));
        IndexRequestBuilder[] docs = new IndexRequestBuilder[numDocs];
 * this file be licensed under the Apache-2.0 license or a
        int numDocs = randomIntBetween(10, 20);
        SearchResponse resp = client().prepareSearch("test")
            .get();
        IndexRequestBuilder[] docs = new IndexRequestBuilder[numDocs];
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder;
        refresh();
import org.opensearch.action.index.IndexRequestBuilder;
                assertEquals("FetchSourcePhase", innerHitsFetch.getProfiledChildren().getFirst().getQueryName());
                    2,
            .setProfile(true)
        indexRandom(true, docs);
                    );
                assertEquals("fetch", mainFetch.getQueryName());
        QueryBuilder q = QueryBuilders.boolQuery()
        }
                    .endObject()
     * This test verifies that the fetch profiler returns reasonable results for a simple match_all query
                    assertTrue(
        ensureGreen();
            .addDocValueField("field2")
    public void testRootProfile() throws Exception {
            .setProfile(true)
        indexRandom(true, docs);
                    break;
        SearchResponse resp = client().prepareSearch("test")
        IndexRequestBuilder[] docs = new IndexRequestBuilder[numDocs];
        ensureGreen();
        assertTrue(resp.getHits().getAt(0).getPrimaryTerm() > 0L);
                        .startObject()
            List<ProfileResult> fetchProfileResults = fetchProfileResult.getFetchProfileResults();
        int shardsWithCorrectProfile = 0;
        createIndex("test");
            docs[i] = client().prepareIndex("test").setId(String.valueOf(i)).setSource("field1", English.intToEnglish(i));
        int shardsWithDocuments = 0;
                assertTrue("Main fetch should have children", !mainFetch.getProfiledChildren().isEmpty());
            .setVersion(true)
        SearchResponse resp = client().prepareSearch("test")
            .get();
        for (int i = 0; i < numDocs; i++) {
            }
                    .startObject("nested_field")
            .setProfile(true)
                    .startObject()
            .setExplain(true)
                        break;
        QueryBuilder q = QueryBuilders.matchAllQuery();
            assertFalse("Should have at least one fetch profile result", fetchProfileResults.isEmpty());
            .setQuery(QueryBuilders.matchAllQuery())
            .setSize(numDocs)
import org.apache.lucene.tests.util.English;
            .indices()
}
/*
                assertEquals(
        client().prepareIndex("test").setId("1").setSource("field1", "The quick brown fox jumps over the lazy dog").get();
        }
                    .startObject("field1")
package org.opensearch.search.profile.fetch;
                    breakdown.containsKey(FetchTimingType.BUILD_SUB_PHASE_PROCESSORS.toString())
        createIndex("test");
                assertEquals("Inner hits fetch should have 1 child (FetchSourcePhase)", 1, innerHitsFetch.getProfiledChildren().size());
                break;
public class FetchProfilerIT extends OpenSearchIntegTestCase {
        assertFetchPhase(resp, "FetchDocValuesPhase", 2);
            .setMapping(
        SearchResponse resp = client().prepareSearch("test")
                    .endObject()
                        .startArray("nested_field")
import org.opensearch.action.search.SearchType;
                    "CREATE_STORED_FIELDS_VISITOR timing should be present",
        int numDocs = randomIntBetween(10, 20);
    public void testDocValuesPhaseProfile() throws Exception {
                    assertTrue("LOAD_SOURCE timing should be present", breakdown.containsKey(FetchTimingType.LOAD_SOURCE.toString()));
                    breakdown.containsKey(FetchTimingType.CREATE_STORED_FIELDS_VISITOR.toString())
        client().admin()
            .setMapping(
            )
                    );
        indexRandom(true, docs);
            .seqNoAndPrimaryTerm(true)
    }
 * compatible open source license.
            .get();
            .setQuery(QueryBuilders.matchAllQuery())
            }
        int numDocs = randomIntBetween(100, 150);
        IndexRequestBuilder[] docs = new IndexRequestBuilder[numDocs];
                XContentFactory.jsonBuilder()
    }
        assertFetchPhase(resp, "MatchedQueriesPhase", 2);
                            breakdown.containsKey(FetchTimingType.PROCESS.toString())
    public void testSeqNoPrimaryTermPhaseProfile() throws Exception {
                        .endArray()
                    .endObject()
                    breakdown.containsKey(FetchTimingType.LOAD_STORED_FIELDS.toString())
        assertNotNull("Profile results should not be null", profileResults);
        SearchResponse resp = client().prepareSearch("test").setQuery(q).setProfile(true).get();
            .should(QueryBuilders.termQuery("field1", "fox").queryName("second_query"));
                XContentFactory.jsonBuilder()
        assertNotNull(resp.getHits().getAt(0).field("field2"));
            docs[i] = client().prepareIndex("test").setId(String.valueOf(i)).setSource("field1", English.intToEnglish(i), "field2", i);
                        "LOAD_STORED_FIELDS timing should be present",
                assertTrue("LOAD_SOURCE timing should be present", breakdown.containsKey(FetchTimingType.LOAD_SOURCE.toString()));
    public void testHighlightPhaseProfile() throws Exception {
            docs[i] = client().prepareIndex("test").setId(String.valueOf(i)).setSource("field1", English.intToEnglish(i), "field2", i);
                QueryBuilders.nestedQuery("nested_field", QueryBuilders.matchAllQuery(), org.apache.lucene.search.join.ScoreMode.None)
                    .endObject()
            assertNotNull("Fetch profile results should not be null", fetchProfileResults);
                        .field("nested_text", "nested value " + i)
                        .startObject()
        for (int i = 0; i < numDocs; i++) {
            .setProfile(true)
                shardsWithCorrectProfile++;
        assertFetchPhase(resp, "SeqNoPrimaryTermPhase", 2);
        ensureGreen("test");
        assertTrue(resp.getHits().getAt(0).getSeqNo() > -1L);
                    .endObject()
import org.opensearch.action.search.SearchResponse;
        SearchResponse resp = client().prepareSearch("test")
                        assertTrue(
        assertEquals(
                        "BUILD_SUB_PHASE_PROCESSORS timing should be present",
            .get();
        createIndex("test");
                        .endObject()
                    if (phaseName.equals(child.getQueryName())) {
import org.opensearch.search.sort.SortOrder;
                        fetchResult.getProfiledChildren().size()
        assertFalse("Should have inner hits", resp.getHits().getAt(0).getInnerHits().isEmpty());
        refresh();
                    .field("type", "integer")
                }
    }
                    fetchProfileResults.size()
                    Map<String, Long> breakdown = fetchResult.getTimeBreakdown();
            .get();
            .setQuery(q)
        boolean foundPhase = false;
        refresh();
import org.opensearch.search.profile.ProfileResult;
                    assertTrue(
            }
                    }
        assertFetchPhase(resp, "FetchScorePhase", 2);
     */
            docs[i] = client().prepareIndex("test").setId(String.valueOf(i)).setSource("field1", English.intToEnglish(i), "field2", i);
            .setQuery(QueryBuilders.matchAllQuery())
                        );
            .setSize(numDocs)
            .prepareCreate("test")
        Map<String, ProfileShardResult> profileResults = resp.getProfileResults();
                    assertEquals(
                        Map<String, Long> breakdown = child.getTimeBreakdown();
            assertNotNull("Fetch profile result should not be null", fetchProfileResult);
                    .field("type", "text")
            .setSearchType(SearchType.QUERY_THEN_FETCH)
        assertTrue("Should have at least one hit", resp.getHits().getHits().length > 0);
        assertFalse("Profile results should not be empty", profileResults.isEmpty());
        assertFetchPhase(resp, "FetchVersionPhase", 2);
            if (fetchProfileResult != null && !fetchProfileResult.getFetchProfileResults().isEmpty()) {
                    .startObject("properties")
            .get();
            .setProfile(true)
                    .startObject()
                );
                    assertTrue(
        assertFalse(profileResults.isEmpty());
                    assertTrue(
                assertNotNull("Time breakdown should not be null", breakdown);
                        "CREATE_STORED_FIELDS_VISITOR timing should be present",
            .get();
            .should(QueryBuilders.termQuery("field1", "quick").queryName("first_query"))
                );
    }
    }
        for (Map.Entry<String, ProfileShardResult> shardResult : profileResults.entrySet()) {
        IndexRequestBuilder[] docs = new IndexRequestBuilder[numDocs];
        createIndex("test");
            "All shards with documents should have correct fetch profile structure",
        for (ProfileShardResult shardResult : profileResults.values()) {
    }
                ProfileResult innerHitsFetch = fetchProfileResults.get(1);
            .get();
 * The OpenSearch Contributors require contributions made to
            .setProfile(true)
                            breakdown.containsKey(FetchTimingType.SET_NEXT_READER.toString())
        SearchResponse resp = client().prepareSearch("test")
        Map<String, ProfileShardResult> profileResults = resp.getProfileResults();
            shardsWithCorrectProfile
        SearchResponse resp = client().prepareSearch("test")
        }
        assertFetchPhase(resp, "FetchFieldsPhase", 2);
        assertNotNull(profileResults);
        }
                    .endObject()
            .prepareCreate("test")
                    "Every shard with documents should have 2 fetch operations (1 main + 1 inner hit)",
                for (ProfileResult child : fetchResult.getProfiledChildren()) {
        createIndex("test");
    public void testFetchScorePhaseProfile() throws Exception {
            for (ProfileResult fetchResult : fetchProfileResults) {
        client().prepareIndex("test").setId("1").setSource("field1", "The quick brown fox").get();
                    .endObject()
                        breakdown.containsKey(FetchTimingType.CREATE_STORED_FIELDS_VISITOR.toString())
        assertFalse("Profile response should not be an empty array", profileResults.isEmpty());
            .setQuery(QueryBuilders.matchAllQuery())
        int numDocs = randomIntBetween(10, 20);
import org.opensearch.index.query.QueryBuilders;
                    .field("type", "nested")
        QueryBuilder q = QueryBuilders.matchQuery("field1", "quick fox");
        client().admin()
        indexRandom(true, docs);
        for (int i = 0; i < numDocs; i++) {
                        .endObject()
import org.opensearch.test.OpenSearchIntegTestCase;
            .setQuery(QueryBuilders.matchQuery("field1", "quick"))
        indexRandom(true, docs);
    private void assertFetchPhase(SearchResponse resp, String phaseName, int expectedChildren) {
        assertNotNull(resp.getHits().getAt(0).getHighlightFields().get("field1"));
                        );
        IndexRequestBuilder[] docs = new IndexRequestBuilder[numDocs];
                    );
        assertFetchPhase(resp, "ExplainPhase", 2);
import org.opensearch.index.query.InnerHitBuilder;
    }
        List<String> matchedQueries = Arrays.asList(resp.getHits().getAt(0).getMatchedQueries());
                    .endObject()
    public void testMatchedQueriesPhaseProfile() throws Exception {
                    .field("store", true)
        int numDocs = randomIntBetween(10, 20);
                        breakdown.containsKey(FetchTimingType.LOAD_STORED_FIELDS.toString())
        assertEquals(1L, resp.getHits().getAt(0).getVersion());
            .addFetchField("field1")
            FetchProfileShardResult fetchProfileResult = shardResult.getValue().getFetchProfileResult();
                    .startObject("properties")
            .setProfile(true)
                );
        );
        indexRandom(true, docs);
            .setSearchType(SearchType.QUERY_THEN_FETCH)
        indexRandom(true, docs);
                        expectedChildren,
        client().prepareIndex("test").setId("1").setSource("field1", "The quick brown fox", "field2", 42).get();
                            phaseName + " should have NEXT_READER timing type",
                }
                    .startObject("nested_text")
        }
            if (foundPhase) {
        SearchResponse resp = client().prepareSearch("test").setQuery(q).setProfile(true).highlighter(highlighter).get();
            .indices()
 * SPDX-License-Identifier: Apache-2.0
        createIndex("test");
                        "GET_NEXT_READER timing should be present",
            docs[i] = client().prepareIndex("test")
                ProfileResult mainFetch = fetchProfileResults.getFirst();
            .setQuery(
                    .startObject("field2")
                for (ProfileResult fetchResult : fetchProfileResults) {
                        breakdown.containsKey(FetchTimingType.GET_NEXT_READER.toString())
        assertTrue("Should have at least one shard with documents", shardsWithDocuments > 0);
                Map<String, Long> breakdown = fetchResult.getTimeBreakdown();
            )
        for (int i = 0; i < numDocs; i++) {
        // Index many documents to ensure all shards have data
                );
            )
            .setTrackScores(true)
                }
                assertNotNull(mainFetch.getTimeBreakdown());
                    .field("type", "text")
        assertNotNull(profileResults);
import java.util.List;
        assertNotNull("Response should include explanations", resp.getHits().getAt(0).getExplanation());
        for (int i = 0; i < numDocs; i++) {
    /**
        for (int i = 0; i < numDocs; i++) {
    public void testInnerHitsPhaseProfile() throws Exception {
                    "LOAD_STORED_FIELDS timing should be present",
        IndexRequestBuilder[] docs = new IndexRequestBuilder[numDocs];
        ensureGreen("test");
                        assertTrue(
                if (foundPhase) {
            shardsWithDocuments,
        HighlightBuilder highlighter = new HighlightBuilder().field("field1");
            }
            assertNotNull(fetchProfileResult);
    }
        }
                    );
            .setSize(numDocs)
                .setId(String.valueOf(i))
        int numDocs = randomIntBetween(100, 150);
                    .startObject("properties")
            .addSort("field2", SortOrder.ASC) // Sort by a field other than _score
    }
        }
        assertTrue(matchedQueries.contains("second_query"));
                assertTrue("GET_NEXT_READER timing should be present", breakdown.containsKey(FetchTimingType.GET_NEXT_READER.toString()));
        assertNotNull(resp.getHits().getAt(0).field("field1"));
        for (int i = 0; i < numDocs; i++) {
                    "BUILD_SUB_PHASE_PROCESSORS timing should be present",
            FetchProfileShardResult fetchProfileResult = shardResult.getFetchProfileResult();
                assertNotNull(innerHitsFetch.getTimeBreakdown());
        for (ProfileShardResult shardResult : profileResults.values()) {
        assertFetchPhase(resp, "FetchSourcePhase", 1);
    }
            .setProfile(true)
                            phaseName + " should have PROCESS timing type",
        assertTrue(phaseName + " should be present in the profile", foundPhase);
            docs[i] = client().prepareIndex("test").setId(String.valueOf(i)).setSource("field1", English.intToEnglish(i));
    public void testExplainProfile() throws Exception {
                        foundPhase = true;
            .get();
                    .innerHit(new InnerHitBuilder().setName("inner_hits_1"))
                List<ProfileResult> fetchProfileResults = fetchProfileResult.getFetchProfileResults();
                shardsWithDocuments++;
        assertTrue(resp.getHits().getAt(0).getScore() > 0.0f);
import org.opensearch.index.query.QueryBuilder;
        createIndex("test");
                    );
                assertTrue(
        }
        assertFetchPhase(resp, "HighlightPhase", 2);
        Map<String, ProfileShardResult> profileResults = resp.getProfileResults();
                assertTrue(
            FetchProfileShardResult fetchProfileResult = shardResult.getFetchProfileResult();
                );
import org.opensearch.common.xcontent.XContentFactory;
    }
        }
                        breakdown.containsKey(FetchTimingType.BUILD_SUB_PHASE_PROCESSORS.toString())
 *
    public void testVersionPhaseProfile() throws Exception {
            .setQuery(QueryBuilders.matchAllQuery())
    public void testFieldsPhaseProfile() throws Exception {
 */
import org.opensearch.search.profile.ProfileShardResult;
