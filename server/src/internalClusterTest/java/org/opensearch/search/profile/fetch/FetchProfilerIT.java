                assertTrue(
        client().prepareIndex("test").setId("1").setSource("field1", "The quick brown fox").get();
                        "LOAD_STORED_FIELDS timing should be present",
        }
                        "CREATE_STORED_FIELDS_VISITOR timing should be present",
                Map<String, Long> breakdown = fetchResult.getTimeBreakdown();
                    .endObject()
                assertTrue("Should be inner hits fetch", innerHitsFetch.getQueryName().startsWith("fetch_inner_hits"));  
            .get();
        createIndex("test");  
import org.opensearch.search.profile.ProfileResult;
    public void testExplainProfile() throws Exception {
        for (ProfileShardResult shardResult : profileResults.values()) {  
 * The OpenSearch Contributors require contributions made to  
                        );  
    public void testRootProfile() throws Exception {  
                }  
            .get();
                            phaseName + " should have NEXT_READER timing type",
                    .field("type", "text")  
 * this file be licensed under the Apache-2.0 license or a
        }
                assertNotNull(mainFetch.getTimeBreakdown());
                shardsWithCorrectProfile++;
            .prepareCreate("test")
                QueryBuilders.nestedQuery("nested_field", QueryBuilders.matchAllQuery(), org.apache.lucene.search.join.ScoreMode.None)
                    .endObject()
                assertEquals("fetch", mainFetch.getQueryName());
                        "GET_NEXT_READER timing should be present",
                    .endObject()  
import org.opensearch.index.query.QueryBuilders;
                    assertTrue(
        indexRandom(true, docs);  
        for (int i = 0; i < numDocs; i++) {  
                    breakdown.containsKey(FetchTimingType.CREATE_STORED_FIELDS_VISITOR.toString())  
            docs[i] = client().prepareIndex("test").setId(String.valueOf(i)).setSource("field1", English.intToEnglish(i), "field2", i);
/*  
            assertFalse("Should have at least one fetch profile result", fetchProfileResults.isEmpty());
            docs[i] = client().prepareIndex("test")
                );
            .setSearchType(SearchType.QUERY_THEN_FETCH)
    public void testFetchScorePhaseProfile() throws Exception {
            .setQuery(  
                        .endObject()  
    }  
    }
        assertFalse(profileResults.isEmpty());
                        .field("nested_text", "nested value " + i)  
                    "CREATE_STORED_FIELDS_VISITOR timing should be present",
            .get();
                        break;  
        createIndex("test");
            .setSize(numDocs)  
        SearchResponse resp = client().prepareSearch("test")  
                .setId(String.valueOf(i))  
        SearchResponse resp = client().prepareSearch("test")
            }  
        }
import org.opensearch.search.sort.SortOrder;  
            .get();
        ensureGreen();  
            .indices()
 * compatible open source license.
        Map<String, ProfileShardResult> profileResults = resp.getProfileResults();  
        for (int i = 0; i < numDocs; i++) {
    }  
        SearchResponse resp = client().prepareSearch("test")  
            )  
                    .field("type", "text")
        for (int i = 0; i < numDocs; i++) {
            .addSort("field2", SortOrder.ASC) // Sort by a field other than _score
            .should(QueryBuilders.termQuery("field1", "quick").queryName("first_query"))  
        }
import java.util.Map;
            .setProfile(true)
                List<ProfileResult> fetchProfileResults = fetchProfileResult.getFetchProfileResults();
        indexRandom(true, docs);
            .setMapping(
        IndexRequestBuilder[] docs = new IndexRequestBuilder[numDocs];
                        .startObject()
                assertTrue("LOAD_SOURCE timing should be present", breakdown.containsKey(FetchTimingType.LOAD_SOURCE.toString()));
        SearchResponse resp = client().prepareSearch("test")
            if (foundPhase) {
                    .startObject()  
        assertTrue(matchedQueries.contains("first_query"));  
                    assertTrue(  
            shardsWithCorrectProfile
                    breakdown.containsKey(FetchTimingType.BUILD_SUB_PHASE_PROCESSORS.toString())
        assertNotNull(profileResults);
        assertNotNull("Profile results should not be null", profileResults);  
                        );
            .setProfile(true)
     * This test verifies that the fetch profiler returns reasonable results for a simple match_all query
                    .endObject()
        indexRandom(true, docs);  
                    .field("store", true)
        client().admin()
                    .startObject("field2")
                );
            .setSize(numDocs)
                assertEquals(  
                        Map<String, Long> breakdown = child.getTimeBreakdown();
        assertNotNull(resp.getHits().getAt(0).getHighlightFields().get("field1"));  
    public void testDocValuesPhaseProfile() throws Exception {
                for (ProfileResult child : fetchResult.getProfiledChildren()) {
                    .startObject("properties")
        refresh();
                    .startObject()
            .setSize(numDocs)
            assertNotNull(fetchProfileResult);
package org.opensearch.search.profile.fetch;
                    fetchProfileResults.size()  
        indexRandom(true, docs);
        ensureGreen();
                }
                            phaseName + " should have PROCESS timing type",
    private void assertFetchPhase(SearchResponse resp, String phaseName, int expectedChildren) {
        assertFetchPhase(resp, "MatchedQueriesPhase", 2);
        QueryBuilder q = QueryBuilders.boolQuery()
        ensureGreen("test");
                    2,
            .setMapping(
            for (ProfileResult fetchResult : fetchProfileResults) {  
                    .startObject("field1")  
            FetchProfileShardResult fetchProfileResult = shardResult.getFetchProfileResult();  
    }
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder;  
import org.opensearch.test.OpenSearchIntegTestCase;
    }
                for (ProfileResult fetchResult : fetchProfileResults) {
                        breakdown.containsKey(FetchTimingType.BUILD_SUB_PHASE_PROCESSORS.toString())
        IndexRequestBuilder[] docs = new IndexRequestBuilder[numDocs];
        assertTrue("Should have at least one hit", resp.getHits().getHits().length > 0);
        assertEquals(1L, resp.getHits().getAt(0).getVersion());
            .get();
            .setProfile(true)
                        assertTrue(
        int numDocs = randomIntBetween(100, 150);  
        int numDocs = randomIntBetween(10, 20);  
                    "LOAD_STORED_FIELDS timing should be present",
                    );
                    assertTrue(
        for (int i = 0; i < numDocs; i++) {
            assertNotNull("Fetch profile results should not be null", fetchProfileResults);  
        HighlightBuilder highlighter = new HighlightBuilder().field("field1");
                assertTrue(
        IndexRequestBuilder[] docs = new IndexRequestBuilder[numDocs];  
        QueryBuilder q = QueryBuilders.matchAllQuery();  
        assertFalse("Profile results should not be empty", profileResults.isEmpty());
            )  
        assertNotNull(profileResults);
            }  
import org.opensearch.common.xcontent.XContentFactory;
            .setProfile(true)
                        expectedChildren,
                        breakdown.containsKey(FetchTimingType.LOAD_STORED_FIELDS.toString())  
        SearchResponse resp = client().prepareSearch("test")
                        .endObject()
        indexRandom(true, docs);  
        assertFalse("Should have inner hits", resp.getHits().getAt(0).getInnerHits().isEmpty());
            }  
 *
            .setProfile(true)
                XContentFactory.jsonBuilder()
            .setTrackScores(true)  
                    .endObject()
        assertFalse("Profile response should not be an empty array", profileResults.isEmpty());
        assertTrue(phaseName + " should be present in the profile", foundPhase);
                    assertTrue(
        IndexRequestBuilder[] docs = new IndexRequestBuilder[numDocs];
        int numDocs = randomIntBetween(10, 20);
                    XContentFactory.jsonBuilder()
        assertNotNull("Response should include explanations", resp.getHits().getAt(0).getExplanation());
                    .endObject()
            .setSize(numDocs)  
        boolean foundPhase = false;
        createIndex("test");  
                        foundPhase = true;
            .setProfile(true)  
    public void testVersionPhaseProfile() throws Exception {
        assertEquals(
            .setSize(numDocs)
            .addDocValueField("field2")
                assertEquals("Inner hits fetch should have 1 child (FetchSourcePhase)", 1, innerHitsFetch.getProfiledChildren().size());
import java.util.List;
public class FetchProfilerIT extends OpenSearchIntegTestCase {
            List<ProfileResult> fetchProfileResults = fetchProfileResult.getFetchProfileResults();
import java.util.Arrays;  
        SearchResponse resp = client().prepareSearch("test")
    public void testMatchedQueriesPhaseProfile() throws Exception {  
                assertTrue("GET_NEXT_READER timing should be present", breakdown.containsKey(FetchTimingType.GET_NEXT_READER.toString()));  
            .setSearchType(SearchType.QUERY_THEN_FETCH)  
                assertNotNull("Time breakdown should not be null", breakdown);
            .addFetchField("field1")
        assertEquals("Should have 1 inner hit", 1, resp.getHits().getAt(0).getInnerHits().size());  
            "All shards with documents should have correct fetch profile structure",
        client().prepareIndex("test").setId("1").setSource("field1", "The quick brown fox", "field2", 42).get();  
            .indices()  
            .get();
        // Index many documents to ensure all shards have data
                assertEquals("FetchSourcePhase", innerHitsFetch.getProfiledChildren().getFirst().getQueryName());  
import org.opensearch.action.index.IndexRequestBuilder;
    /**  
        int numDocs = randomIntBetween(10, 20);
}
            docs[i] = client().prepareIndex("test").setId(String.valueOf(i)).setSource("field1", English.intToEnglish(i), "field2", i);
            .setExplain(true)
            .setQuery(QueryBuilders.matchAllQuery())  
                );
                            breakdown.containsKey(FetchTimingType.PROCESS.toString())
        SearchResponse resp = client().prepareSearch("test")
                    .startObject("nested_text")
        assertTrue(resp.getHits().getAt(0).getPrimaryTerm() > 0L);
                    "BUILD_SUB_PHASE_PROCESSORS timing should be present",  
            .setProfile(true)
    public void testHighlightPhaseProfile() throws Exception {
                    .innerHit(new InnerHitBuilder().setName("inner_hits_1"))
                if (foundPhase) {  
            .should(QueryBuilders.termQuery("field1", "fox").queryName("second_query"));
                    .endObject()
    }  
                            breakdown.containsKey(FetchTimingType.SET_NEXT_READER.toString())  
        ensureGreen("test");
                        breakdown.containsKey(FetchTimingType.CREATE_STORED_FIELDS_VISITOR.toString())  
        assertFetchPhase(resp, "FetchVersionPhase", 2);  
                    Map<String, Long> breakdown = fetchResult.getTimeBreakdown();  
        createIndex("test");
                    );
                    );  
                assertTrue(
                }
        assertFetchPhase(resp, "FetchScorePhase", 2);  
    }
            .get();
        IndexRequestBuilder[] docs = new IndexRequestBuilder[numDocs];
        int numDocs = randomIntBetween(100, 150);
        assertNotNull(resp.getHits().getAt(0).field("field2"));  
                    "Every shard with documents should have 2 fetch operations (1 main + 1 inner hit)",
                    assertEquals(
        for (int i = 0; i < numDocs; i++) {
            .seqNoAndPrimaryTerm(true)  
import org.apache.lucene.tests.util.English;
        Map<String, ProfileShardResult> profileResults = resp.getProfileResults();
                );
            for (ProfileResult fetchResult : fetchProfileResult.getFetchProfileResults()) {  
                ProfileResult innerHitsFetch = fetchProfileResults.get(1);
     */
    public void testFieldsPhaseProfile() throws Exception {
        refresh();
            .prepareCreate("test")  
        indexRandom(true, docs);
        assertTrue("Should have at least one shard with documents", shardsWithDocuments > 0);  
                        .endArray()
import org.opensearch.action.search.SearchType;
                        .startObject()  
                    .startObject("properties")
        assertNotNull(resp.getHits().getAt(0).field("field1"));  
            .setQuery(QueryBuilders.matchAllQuery())
        SearchResponse resp = client().prepareSearch("test")
        createIndex("test");
                    );  
        }  
    public void testSeqNoPrimaryTermPhaseProfile() throws Exception {  
        createIndex("test");  
            FetchProfileShardResult fetchProfileResult = shardResult.getFetchProfileResult();
        }
        IndexRequestBuilder[] docs = new IndexRequestBuilder[numDocs];  
            docs[i] = client().prepareIndex("test").setId(String.valueOf(i)).setSource("field1", English.intToEnglish(i), "field2", i);
        assertFetchPhase(resp, "FetchDocValuesPhase", 2);
        SearchResponse resp = client().prepareSearch("test").setQuery(q).setProfile(true).get();  
import org.opensearch.search.profile.ProfileShardResult;
                assertNotNull(innerHitsFetch.getTimeBreakdown());
                ProfileResult mainFetch = fetchProfileResults.getFirst();  
                );
            if (fetchProfileResult != null && !fetchProfileResult.getFetchProfileResults().isEmpty()) {
    public void testInnerHitsPhaseProfile() throws Exception {  
        assertTrue(matchedQueries.contains("second_query"));
        createIndex("test");
            .setSize(numDocs)  
                        fetchResult.getProfiledChildren().size()
            .get();  
        for (Map.Entry<String, ProfileShardResult> shardResult : profileResults.entrySet()) {
        assertFetchPhase(resp, "HighlightPhase", 2);
        );
        assertFetchPhase(resp, "FetchSourcePhase", 1);
            .setQuery(QueryBuilders.matchAllQuery())  
                        assertTrue(  
            shardsWithDocuments,  
        int shardsWithCorrectProfile = 0;
            }  
                    breakdown.containsKey(FetchTimingType.LOAD_STORED_FIELDS.toString())  
                shardsWithDocuments++;  
    }
        assertFetchPhase(resp, "ExplainPhase", 2);
        IndexRequestBuilder[] docs = new IndexRequestBuilder[numDocs];  
        int numDocs = randomIntBetween(10, 20);
    }
        client().admin()
        }
            docs[i] = client().prepareIndex("test").setId(String.valueOf(i)).setSource("field1", English.intToEnglish(i));  
                    }
        assertTrue(resp.getHits().getAt(0).getSeqNo() > -1L);
        assertFetchPhase(resp, "SeqNoPrimaryTermPhase", 2);  
                XContentFactory.jsonBuilder()  
                    if (phaseName.equals(child.getQueryName())) {
                        "Should have " + expectedChildren + " profiled children",  
            .setQuery(q)  
        for (int i = 0; i < numDocs; i++) {
        int shardsWithDocuments = 0;  
                        breakdown.containsKey(FetchTimingType.GET_NEXT_READER.toString())
        QueryBuilder q = QueryBuilders.matchQuery("field1", "quick fox");
            assertNotNull("Fetch profile result should not be null", fetchProfileResult);  
                    assertTrue("LOAD_SOURCE timing should be present", breakdown.containsKey(FetchTimingType.LOAD_SOURCE.toString()));
        }
            .setVersion(true)
        SearchResponse resp = client().prepareSearch("test").setQuery(q).setProfile(true).highlighter(highlighter).get();
                .setSource(
            .setQuery(QueryBuilders.matchQuery("field1", "quick"))
            FetchProfileShardResult fetchProfileResult = shardResult.getValue().getFetchProfileResult();
            .setProfile(true)
        indexRandom(true, docs);  
 */  
        refresh();  
        }  
import org.opensearch.index.query.InnerHitBuilder;  
                    .startObject("nested_field")
        Map<String, ProfileShardResult> profileResults = resp.getProfileResults();  
                    .endObject()  
            docs[i] = client().prepareIndex("test").setId(String.valueOf(i)).setSource("field1", English.intToEnglish(i), "field2", i);  
                    .startObject("properties")
            )  
            .setQuery(QueryBuilders.matchAllQuery())
 * SPDX-License-Identifier: Apache-2.0
                    .field("type", "integer")
                    );
import org.opensearch.index.query.QueryBuilder;
                        .startArray("nested_field")
                assertTrue("Main fetch should have children", !mainFetch.getProfiledChildren().isEmpty());  
        for (ProfileShardResult shardResult : profileResults.values()) {
            docs[i] = client().prepareIndex("test").setId(String.valueOf(i)).setSource("field1", English.intToEnglish(i));
        int numDocs = randomIntBetween(10, 20);
        assertTrue(resp.getHits().getAt(0).getScore() > 0.0f);
                    .endObject()  
            .get();
                        "BUILD_SUB_PHASE_PROCESSORS timing should be present",  
        }
        List<String> matchedQueries = Arrays.asList(resp.getHits().getAt(0).getMatchedQueries());
                break;
            .get();
import org.opensearch.action.search.SearchResponse;  
    }  
        assertFetchPhase(resp, "FetchFieldsPhase", 2);
        createIndex("test");
            .setQuery(QueryBuilders.matchAllQuery())  
                    .field("type", "nested")  
        for (int i = 0; i < numDocs; i++) {  
                    break;
    }  
        client().prepareIndex("test").setId("1").setSource("field1", "The quick brown fox jumps over the lazy dog").get();
