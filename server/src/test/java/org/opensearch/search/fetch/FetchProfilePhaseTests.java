import org.apache.lucene.tests.index.RandomIndexWriter;
            when(context.docIdsToLoad()).thenReturn(docIds);
                hb.field(new HighlightBuilder.Field("content").highlighterType("stub"));
                FetchProfiler fetchProfiler = context.getProfilers().getFetchProfiler();
                    ProfileResult profile = profileResults.get(i);
import org.opensearch.search.profile.ProfileResult;
                assertEquals(1, children.size());
                assertTrue("Missing profile for FetchDocValuesPhase", children.containsKey("FetchDocValuesPhase"));
                    .withHighlight(highlight)
import org.opensearch.search.DocValueFormat;
            assertThat("Profile breakdown should not be empty", breakdown.size(), greaterThan(0));
                // Check that FetchDocValuesPhase is present and has timing information
        private boolean enableFetchFields = false;
        try (RandomIndexWriter w = new RandomIndexWriter(random(), dir, new IndexWriterConfig(new StandardAnalyzer()))) {
                // Check that ExplainPhase is present and has timing information
            return this;
            DocumentMapper documentMapper = mock(DocumentMapper.class);
            this.enableFetchScore = true;
                    .withQueryShardContext(qsc)
                new TimingAssertions(profile.getTimeBreakdown()).assertBreakdownNotEmpty()
                ? externalQueryShardContext
                // Create highlight builder with stub highlighter
        }
        private boolean enableFetchScore = false;
                InnerHitsContext innerHits = new InnerHitsContext();
            // Search lookup setup
                // Verify the profile results
                ProfileResult profile = executeFetchPhaseAndGetProfile(context, subPhases);
import java.util.Arrays;
                    assertTrue("Profile name should end with ']'", profileName.endsWith("]"));
                QueryShardContext qsc = mock(QueryShardContext.class);
import org.opensearch.search.sort.SortAndFormats;
import org.opensearch.search.internal.SubSearchContext;
                    .withParsedQuery(pq)
                    children.put(child.getQueryName(), child);
                    doc.add(new org.apache.lucene.document.StoredField("_source", sourceJson.getBytes(StandardCharsets.UTF_8)));
            return true;
                // Verify the profile results
    }
            SearchContext context = mock(SearchContext.class);
        SearchContextBuilder withVersion() {
        private boolean enableSourceLoading = false;
                // Create a parsed query with named queries for the MatchedQueriesPhase to extract
    public void testInnerHitsPhaseProfiling() throws Exception {
                // Verify the profile results
        }
                null,
                    .withStoredFields("_source")
                    children.put(child.getQueryName(), child);
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;
                    .withExplain() // Only enable explain
                when(context.innerHits()).thenReturn(innerHits);
            List<Document> docs = new TestDocumentBuilder().addDocuments(1, true).build();
            this.docValueFields = Arrays.asList(fields);
            int[] docIds = indexDocumentsAndGetIds(dir, docs, 3);
        private List<FieldAndFormat> fetchFields = Collections.emptyList();
                Map<String, ProfileResult> children = new HashMap<>();
                        .assertTimingPresent(FetchTimingType.CREATE_STORED_FIELDS_VISITOR)
                SearchHighlightContext highlight = hb.build(qsc);
 * compatible open source license.
                assertEquals(1, children.size());
                for (ProfileResult topHitsFetchProfile : profileResults) {
            FetchSearchResult fetchResult = new FetchSearchResult();
                ParsedQuery pq = new ParsedQuery(new MatchAllDocsQuery(), Map.of("test_query", new MatchAllDocsQuery()));
            this.indexShard = indexShard;
                    .build();
        try (Directory dir = newDirectory()) {
                when(context.scriptFields()).thenReturn(scriptFieldsContext);
                    .build();
    }
            if (enableSourceLoading) {
    public void testRootTiming() throws Exception {
import org.opensearch.search.fetch.subphase.FetchFieldsPhase;
                new TimingAssertions(children.get("SeqNoPrimaryTermPhase").getTimeBreakdown()).assertTimingPresent(FetchTimingType.PROCESS)
                topHitsContext3.docIdsToLoad(new int[] { docIds[2] }, 0, 1);
                FetchProfiler fetchProfiler = mainContext.getProfilers().getFetchProfiler();
        SearchContextBuilder withQueryShardContext(QueryShardContext qsc) {
        }
                assertTrue("Missing profile for MatchedQueriesPhase", children.containsKey("MatchedQueriesPhase"));
                    .build();
                SubSearchContext topHitsContext2 = new SubSearchContext(mainContext);
    public void testFetchSourcePhaseProfiling() throws Exception {
    }
        }
                // Verify the profile results
                ParsedQuery pq = new ParsedQuery(new MatchAllDocsQuery());
import org.opensearch.search.fetch.subphase.FetchDocValuesPhase;
            when(context.hasFetchSourceContext()).thenReturn(enableSourceLoading);
            int[] docIds = indexDocumentsAndGetIds(dir, docs, 1);
                    assertEquals("Inner hit " + innerHitName + " should have 1 sub-phase", 1, children.size());
                assertTrue("Missing profile for SeqNoPrimaryTermPhase", children.containsKey("SeqNoPrimaryTermPhase"));
                    .withParsedQuery(pq)
                when(context.docValuesContext()).thenReturn(new FetchDocValuesContext(docValueFields));
    public void tearDown() throws Exception {
        }
                List<FetchSubPhase> subPhases = Collections.singletonList(new FetchDocValuesPhase());
                ProfileResult profile = executeFetchPhaseAndGetProfile(context, subPhases);
                assertEquals(1, children.size());
    }
import org.opensearch.search.profile.fetch.FetchProfiler;
import org.opensearch.search.fetch.subphase.FieldAndFormat;
                assertTrue("Missing profile for HighlightPhase", children.containsKey("HighlightPhase"));
            when(context.docIdsToLoadSize()).thenReturn(docIds.length);
                ProfileResult profile = executeFetchPhaseAndGetProfile(context, Collections.emptyList());
        @Override
        private ParsedQuery parsedQuery = null;
            // Script fields configuration
            queryResult.topDocs(topDocsAndMaxScore, null);
import java.util.Map;
                topHitsContext3.size(1);
                    String innerHitName = profileName.substring("fetch_inner_hits[".length(), profileName.length() - 1);
    private IndexShard indexShard;
                    .withStoredFields("_source")
import java.io.IOException;
import org.apache.lucene.index.IndexWriterConfig;
                List<FetchSubPhase> subPhases = Collections.singletonList(new FetchScorePhase());
                    children = new HashMap<>();
public class FetchProfilePhaseTests extends IndexShardTestCase {
                ParsedQuery pq = new ParsedQuery(new MatchAllDocsQuery(), Map.of("named", new MatchAllDocsQuery()));
                    .withStoredFields("_source")
            }
import org.opensearch.search.query.QuerySearchResult;
                for (ProfileResult child : profile.getProfiledChildren()) {
            }
                List<FetchSubPhase> subPhases = Collections.singletonList(
            List<Document> docs = new TestDocumentBuilder().addDocuments(3, true).build();
                // Only include the MatchedQueriesPhase in the sub-phases list
import org.apache.lucene.analysis.standard.StandardAnalyzer;
    public void testTopHitsAggregationFetchProfiling() throws Exception {
                topHitsContext2.docIdsToLoad(new int[] { docIds[1] }, 0, 1);
            // Mock the sourceMapper
            assertTrue("Count key should be present: " + countKey, breakdown.containsKey(countKey));
            // Index searcher setup
        }
            when(context.parsedQuery()).thenReturn(parsedQuery);
    }
                // Only include the SeqNoPrimaryTermPhase in the sub-phases list
                SearchContext context = new SearchContextBuilder(reader, docIds, indexShard).withSourceLoading()
            when(context.docIdsToLoadFrom()).thenReturn(0);
        try (IndexReader reader = DirectoryReader.open(dir)) {
            this.externalQueryShardContext = qsc;
            return context;
                        .assertTimingPresent(FetchTimingType.SET_NEXT_READER);
            return this;
                    new TimingAssertions(children.get("FetchSourcePhase").getTimeBreakdown()).assertTimingPresent(FetchTimingType.PROCESS)
            when(context.queryResult()).thenReturn(queryResult);
                    .withParsedQuery(pq)
                    .withFetchScore() // Enable score fetching
import org.opensearch.search.fetch.subphase.highlight.HighlightField;
                    .withQueryShardContext(qsc)
        }
                // Create the main search context
                new TimingAssertions(children.get("HighlightPhase").getTimeBreakdown()).assertTimingPresent(FetchTimingType.PROCESS)
                new TimingAssertions(children.get("MatchedQueriesPhase").getTimeBreakdown()).assertTimingPresent(FetchTimingType.PROCESS)
        }
                    .assertTimingPresent(FetchTimingType.BUILD_SUB_PHASE_PROCESSORS)
            assertThat("Timing should be geq 1: " + timingKey, breakdown.get(timingKey), greaterThanOrEqualTo(1L));
            when(context.searcher()).thenReturn(searcher);
                QueryShardContext qsc = mock(QueryShardContext.class);
        }
                    .withQueryShardContext(qsc)
                when(context.storedFieldsContext()).thenReturn(storedFieldsContext);
import java.util.Collections;
                    .assertTimingPresent(FetchTimingType.SET_NEXT_READER);
import org.apache.lucene.document.TextField;
        TimingAssertions(Map<String, Long> breakdown) {
    private static class TimingAssertions {
            when(context.version()).thenReturn(enableVersion);
                        "Profile name should start with 'fetch_top_hits_aggregation['",
                    .withQueryShardContext(qsc)
                new TimingAssertions(children.get("FetchSourcePhase").getTimeBreakdown()).assertTimingPresent(FetchTimingType.PROCESS)
            List<Document> docs = new TestDocumentBuilder().addDocuments(1, true).build();
            ScoreDoc[] scoreDocs = new ScoreDoc[docIds.length];
            this.parsedQuery = pq;
                    .withParsedQuery(pq)
                    .withStoredFields("_source")
            if (highlightContext != null) {
        }
            }
import java.util.HashSet;
                // Verify the profile results
            try (IndexReader reader = DirectoryReader.open(dir)) {
            SearchLookup searchLookup = mock(SearchLookup.class);
                ProfileResult standardFetchProfile = profileResults.get(0);
                ProfileResult profile = executeFetchPhaseAndGetProfile(context, subPhases);
        }
        public boolean canHighlight(MappedFieldType fieldType) {
            if (enableDocValues) {
        try (Directory dir = newDirectory()) {
            );
                    .assertTimingPresent(FetchTimingType.SET_NEXT_READER);
            return this;
                when(context.trackScores()).thenReturn(true);
import static org.hamcrest.Matchers.hasSize;
                QueryShardContext qsc = mock(QueryShardContext.class);
            return this;
                        .assertTimingPresent(FetchTimingType.LOAD_STORED_FIELDS)
                    .withStoredFields("_source")
                fetchPhase.execute(topHitsContext2, "fetch_top_hits_aggregation[top_hits_agg2]");
                Map<String, ProfileResult> children = new HashMap<>();
                }
                ParsedQuery pq = new ParsedQuery(new MatchAllDocsQuery());
                    assertTrue("Profile name should start with 'fetch_inner_hits['", profileName.startsWith("fetch_inner_hits["));
                // Create a search context with sequence number and primary term enabled
                // Verify the profile results
                    children.put(child.getQueryName(), child);
        private QueryShardContext externalQueryShardContext = null;
                FetchPhase fetchPhase = new FetchPhase(subPhases);
    }
            if (enableFetchFields) {
import org.opensearch.search.fetch.subphase.SeqNoPrimaryTermPhase;
                // Check that FetchScorePhase is present and has timing information
    public void testHighlightPhaseProfiling() throws Exception {
                SearchContext context = new SearchContextBuilder(reader, docIds, indexShard).withSourceLoading()
                // Only include the FetchVersionPhase in the sub-phases list
                    String profileName = profile.getQueryName();
            when(documentMapper.sourceMapper()).thenReturn(sourceFieldMapper);
    }
                SearchContext context = new SearchContextBuilder(reader, docIds, indexShard).withSourceLoading()
                ParsedQuery pq = new ParsedQuery(new MatchAllDocsQuery());
                    for (ProfileResult child : topHitsFetchProfile.getProfiledChildren()) {
                List<FetchSubPhase> subPhases = Collections.singletonList(new FetchSourcePhase());
                    .withParsedQuery(pq)
import org.opensearch.search.fetch.subphase.highlight.HighlightPhase;
import org.opensearch.search.fetch.subphase.InnerHitsContext;
                if (includeSource) {
package org.opensearch.search.fetch;
                    .withParsedQuery(pq)
                // Only include the ExplainPhase in the sub-phases list
import org.apache.lucene.store.Directory;
                ProfileResult profile = executeFetchPhaseAndGetProfile(context, subPhases);
                        .assertTimingPresent(FetchTimingType.GET_NEXT_READER);
                    assertTrue("Top hits " + topHitsName + " should contain FetchSourcePhase", children.containsKey("FetchSourcePhase"));
                Map<String, ProfileResult> children = new HashMap<>();
            }
        FetchProfiler fetchProfiler = context.getProfilers().getFetchProfiler();
    public void setUp() throws Exception {
                assertTrue(children.containsKey("FetchSourcePhase"));
                        profileName.startsWith("fetch_top_hits_aggregation[")
                    .withParsedQuery(pq)
            } else {
                    .withStoredFields("_source")
                assertEquals(1, children.size());
            when(searchLookup.source()).thenReturn(sourceLookup);
import org.opensearch.search.fetch.subphase.ExplainPhase;
                doc.add(new TextField("content", "test content " + i, Field.Store.YES));
                StoredFieldsContext storedFieldsContext = StoredFieldsContext.fromList(storedFieldNames);
            return this;
                    children.put(child.getQueryName(), child);
            }
                SubSearchContext topHitsContext1 = new SubSearchContext(mainContext);
    }
            ContextIndexSearcher searcher = new ContextIndexSearcher(
        }
            }
                assertEquals("Should have all expected top hits names", expectedTopHitsNames, actualTopHitsNames);
        private boolean enableDocValues = false;
    }
                    .assertTimingPresent(FetchTimingType.LOAD_SOURCE)
import java.util.Set;
                    .assertTimingPresent(FetchTimingType.SET_NEXT_READER);
                when(context.fetchFieldsContext()).thenReturn(new FetchFieldsContext(fetchFields));
                // Create a search context with the parsed query containing named queries
        TimingAssertions assertTimingPresent(FetchTimingType timingType) {
            }
        }
            List<Document> docs = new TestDocumentBuilder().addDocuments(1, true).build();
 * SPDX-License-Identifier: Apache-2.0
            this.enableVersion = true;
                SortAndFormats sf = new SortAndFormats(sort, new DocValueFormat[] { DocValueFormat.RAW });
            assertTrue("Timing key should be present: " + timingKey, breakdown.containsKey(timingKey));
            TopDocs topDocs = new TopDocs(new TotalHits(1, TotalHits.Relation.EQUAL_TO), docs);
        private boolean enableScriptFields = false;
import org.opensearch.search.fetch.subphase.MatchedQueriesPhase;
                    );
            when(context.query()).thenReturn(query);
import org.opensearch.search.internal.ContextIndexSearcher;
            assertThat("Count should be non-negative: " + countKey, breakdown.get(countKey), greaterThanOrEqualTo(0L));
                QueryShardContext qsc = mock(QueryShardContext.class);
                        .assertTimingPresent(FetchTimingType.LOAD_STORED_FIELDS)
    }
        }
                    .withParsedQuery(pq)
                // Verify the profile results
        }
                // Create multiple SubSearchContext instances to simulate top hits aggregations
        public TopDocsAndMaxScore topDocs(SearchHit hit) {
import org.apache.lucene.document.Document;
                    .build();
            return this;
                Map<String, ProfileResult> children = new HashMap<>();
                    new HighlightPhase(Collections.singletonMap("stub", new StubHighlighter()))
                for (ProfileResult child : profile.getProfiledChildren()) {
import org.opensearch.search.fetch.subphase.FetchDocValuesContext;
            return this;
                );
                reader,
    private ProfileResult executeFetchPhaseAndGetProfile(SearchContext context, List<FetchSubPhase> subPhases) throws IOException {
        private final Map<String, Long> breakdown;
                SearchContext mainContext = new SearchContextBuilder(reader, docIds, indexShard).withSourceLoading()
                    .build();
                }
                    assertTrue(
                assertEquals(1, children.size());
        indexShard = newShard(true);
                List<FetchSubPhase> subPhases = Collections.singletonList(new MatchedQueriesPhase());
        SearchContextBuilder withQuery(Query query) {
            List<Document> docs = new TestDocumentBuilder().addDocuments(1, true).build();
        private boolean enableSeqNoPrimaryTerm = false;
            return null;
import org.opensearch.search.lookup.SourceLookup;
            return this;
    }
                    new TimingAssertions(children.get("FetchSourcePhase").getTimeBreakdown()).assertTimingPresent(FetchTimingType.PROCESS)
                HighlightBuilder hb = new HighlightBuilder();
            // Basic document loading configuration
                        .assertTimingPresent(FetchTimingType.BUILD_SUB_PHASE_PROCESSORS)
            }
import static org.mockito.Mockito.when;
                ParsedQuery pq = new ParsedQuery(new MatchAllDocsQuery());
        private final int[] docIds;
                assertEquals(1, children.size());
        private List<String> storedFieldNames = Collections.emptyList();
                QueryShardContext qsc = mock(QueryShardContext.class);
            this.scriptFieldsContext = ctx;
            }
                }
import org.opensearch.index.mapper.DocumentMapper;
    // Helper method to execute fetch phase and get profile results
        SearchContextBuilder withFetchFields(FieldAndFormat... fields) {
        super.tearDown();
                SearchContext context = new SearchContextBuilder(reader, docIds, indexShard).withSourceLoading()
                : mock(QueryShardContext.class);
                    children.put(child.getQueryName(), child);
                    .withSeqNoPrimaryTerm() // Enable sequence number and primary term
                    .build();
            this.fetchFields = Arrays.asList(fields);
                // Check that FetchSourcePhase is present and has timing information
        try (Directory dir = newDirectory()) {
                    Map<String, ProfileResult> children = new HashMap<>();
        @Override
        }
        }
        }
                ProfileResult profile = executeFetchPhaseAndGetProfile(context, subPhases);
                SearchContext context = new SearchContextBuilder(reader, docIds, indexShard).withSourceLoading()
            // Basic query configuration
import org.opensearch.search.fetch.subphase.ScriptFieldsContext;
        SearchContext build() throws IOException {
                fetchPhase.execute(topHitsContext3, "fetch_top_hits_aggregation[top_hits_agg3]");
                    assertEquals("Top hits " + topHitsName + " should have 1 sub-phase", 1, children.size());
                // Check that FetchFieldsPhase is present and has timing information
                documents.add(doc);
                    for (ProfileResult child : innerHitsFetchProfile.getProfiledChildren()) {
import static org.hamcrest.Matchers.greaterThan;
        }
                assertTrue("Missing profile for FetchFieldsPhase", children.containsKey("FetchFieldsPhase"));
                when(context.trackScores()).thenReturn(false);
                // Create a search context with score tracking enabled
                new TimingAssertions(children.get("FetchScorePhase").getTimeBreakdown()).assertTimingPresent(FetchTimingType.PROCESS)
                    String sourceJson = "{\"id\":" + i + ",\"content\":\"test content " + i + "\"}";
import org.apache.lucene.document.StringField;
                    innerHitsProfiles.add(profile);
            this.enableSeqNoPrimaryTerm = true;
                    }
                        children.put(child.getQueryName(), child);
                // Only include the FetchSourcePhase in the sub-phases list
        @Override
                InnerHitsContext.InnerHitSubContext innerContext3 = new DummyInnerHitSubContext("inner3", context);
import org.apache.lucene.index.IndexReader;
                innerHits.addInnerHitDefinition(innerContext3);
            return this;
            String startTimeKey = timingKey + "_start_time";
                fetchPhase.execute(topHitsContext1, "fetch_top_hits_aggregation[top_hits_agg1]");
        private final List<Document> documents = new ArrayList<>();
 */
                List<FetchSubPhase> subPhases = Collections.singletonList(new SeqNoPrimaryTermPhase());
        try (Directory dir = newDirectory()) {
                List<FetchSubPhase> subPhases = Collections.singletonList(new FetchFieldsPhase());
    // Helper method to index documents and get their IDs
            // Query result setup
                FetchPhase fetchPhase = new FetchPhase(subPhases);
            when(sourceFieldMapper.enabled()).thenReturn(true);
                    .assertTimingPresent(FetchTimingType.SET_NEXT_READER);
        }
            try (IndexReader reader = DirectoryReader.open(dir)) {
                InnerHitsContext.InnerHitSubContext innerContext2 = new DummyInnerHitSubContext("inner2", context);
                    .withStoredFields("_source")
                    .assertTimingPresent(FetchTimingType.SET_NEXT_READER);
    }
            this.breakdown = breakdown;
                }
            String timingKey = timingType.toString();
            int[] docIds = indexDocumentsAndGetIds(dir, docs, 1);
                    .assertTimingPresent(FetchTimingType.LOAD_STORED_FIELDS)
                ParsedQuery pq = new ParsedQuery(new MatchAllDocsQuery());
    public void testFetchVersionPhaseProfiling() throws Exception {
import org.apache.lucene.search.TopDocs;
                    .withParsedQuery(pq)
        }
import org.opensearch.search.profile.Profilers;
                List<FetchSubPhase> subPhases = Collections.singletonList(new FetchVersionPhase());
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
                Sort sort = new Sort(SortField.FIELD_SCORE);
            Profilers profilers = new Profilers(searcher, false);
                    .withStoredFields("_source")
                    .withParsedQuery(pq)
            }
        TestDocumentBuilder addDocuments(int count, boolean includeSource) {
        }
            }
                    .withQueryShardContext(qsc)
import org.opensearch.index.shard.IndexShard;
                List<ProfileResult> profileResults = fetchProfiler.getTree();
            }
            List<Document> docs = new TestDocumentBuilder().addDocuments(1, true).build();
                    new TimingAssertions(innerHitsFetchProfile.getTimeBreakdown()).assertBreakdownNotEmpty()
                QueryShardContext qsc = mock(QueryShardContext.class);
        private Query query = new MatchAllDocsQuery();
            return docIds;
                ParsedQuery pq = new ParsedQuery(new MatchAllDocsQuery());
    public void testFetchDocValuesPhaseProfiling() throws Exception {
                    .withQueryShardContext(qsc)
        List<ProfileResult> profileResults = fetchProfiler.getTree();
            try (IndexReader reader = DirectoryReader.open(dir)) {
                        .assertTimingPresent(FetchTimingType.SET_NEXT_READER);
            when(queryShardContext.newFetchLookup()).thenReturn(searchLookup);
            );
            TopDocsAndMaxScore topDocsAndMaxScore = new TopDocsAndMaxScore(
                List<FetchSubPhase> subPhases = Collections.singletonList(new FetchSourcePhase());
            return documents;
            when(context.getProfilers()).thenReturn(profilers);
                    children.put(child.getQueryName(), child);
                assertFalse(children.containsKey("InnerHitsPhase"));
            }
            }
                ProfileResult profile = executeFetchPhaseAndGetProfile(context, subPhases);
                    children.put(child.getQueryName(), child);
                QueryShardContext qsc = mock(QueryShardContext.class);
    @Override
                    children.put(child.getQueryName(), child);
            return this;
import org.opensearch.search.fetch.subphase.FetchFieldsContext;
                    .assertTimingPresent(FetchTimingType.SET_NEXT_READER);
            return this;
                Map<String, ProfileResult> children = new HashMap<>();
    public void testFetchScorePhaseProfiling() throws Exception {
                IndexSearcher.getDefaultSimilarity(),
            when(context.mapperService()).thenReturn(mapperService);
            try (IndexReader reader = DirectoryReader.open(dir)) {
        }
        }
                for (ProfileResult child : profile.getProfiledChildren()) {
        }
import org.opensearch.index.query.ParsedQuery;
        assertThat(profileResults, hasSize(greaterThanOrEqualTo(1)));
                ParsedQuery pq = new ParsedQuery(new MatchAllDocsQuery());
import org.apache.lucene.search.IndexSearcher;
            return this;
                ParsedQuery pq = new ParsedQuery(new MatchAllDocsQuery());
                Map<String, ProfileResult> children = new HashMap<>();
                }
                when(context.highlight()).thenReturn(highlightContext);
                    .withQueryShardContext(qsc)
            TopDocs topDocs = searcher.search(new MatchAllDocsQuery(), maxResults);
                topHitsContext1.docIdsToLoad(new int[] { docIds[0] }, 0, 1);
        private final IndexShard indexShard;
                List<FetchSubPhase> subPhases = Collections.singletonList(new FetchSourcePhase());
 * The OpenSearch Contributors require contributions made to
    public void testFetchFieldsPhaseProfiling() throws Exception {
    public void testMatchedQueriesPhaseProfiling() throws Exception {
    private static class DummyInnerHitSubContext extends InnerHitsContext.InnerHitSubContext {
import org.apache.lucene.index.DirectoryReader;
                SearchContext context = new SearchContextBuilder(reader, docIds, indexShard).withSourceLoading()
                    .assertTimingPresent(FetchTimingType.GET_NEXT_READER);
        SearchContextBuilder withHighlight(SearchHighlightContext hc) {
                for (ProfileResult profile : profileResults) {
                for (ProfileResult child : profile.getProfiledChildren()) {
            if (enableFetchScore) {
        private boolean enableExplain = false;
                for (ProfileResult child : profile.getProfiledChildren()) {
import org.opensearch.search.fetch.subphase.highlight.SearchHighlightContext;
                // Only include the HighlightPhase in the sub-phases list with the stub highlighter
                    .withStoredFields("_source")
                }
                    .withStoredFields("_source")
            // Stored fields configuration
                // Check that SeqNoPrimaryTermPhase is present and has timing information
                    String topHitsName = profileName.substring("fetch_top_hits_aggregation[".length(), profileName.length() - 1);
                when(context.sort()).thenReturn(sf);
                }
                for (ProfileResult innerHitsFetchProfile : innerHitsProfiles) {
            } else {
import java.util.ArrayList;
                    .assertTimingPresent(FetchTimingType.SET_NEXT_READER);
                assertTrue("Missing profile for FetchSourcePhase", children.containsKey("FetchSourcePhase"));
                    .withQueryShardContext(qsc)
            int[] docIds = indexDocumentsAndGetIds(dir, docs, 1);
            try (IndexReader reader = DirectoryReader.open(dir)) {
        TimingAssertions assertBreakdownNotEmpty() {
                docIds[i] = topDocs.scoreDocs[i].doc;
                }
import static org.mockito.Mockito.mock;
            return this;
                ProfileResult profile = executeFetchPhaseAndGetProfile(context, subPhases);
            ScoreDoc[] docs = new ScoreDoc[] { new ScoreDoc(hit.docId(), 1.0f) };
            QueryShardContext queryShardContext = externalQueryShardContext != null
        SearchContextBuilder withExplain() {
                // Check that FetchVersionPhase is present and has timing information
            for (Document doc : docs) {
            try (IndexReader reader = DirectoryReader.open(dir)) {
                topHitsContext1.size(1);
                assertThat(profileResults, hasSize(4));
            when(context.sourceRequested()).thenReturn(enableSourceLoading);
    private static class SearchContextBuilder {
        }
        DummyInnerHitSubContext(String name, SearchContext context) {
        FetchPhase fetchPhase = new FetchPhase(subPhases);
}
                assertTrue("Missing profile for FetchScorePhase", children.containsKey("FetchScorePhase"));
import org.opensearch.index.query.QueryShardContext;
    // Simple highlighter
        SearchContextBuilder withSourceLoading() {
            // Mapper service setup
                SearchContext context = new SearchContextBuilder(reader, docIds, indexShard).withSourceLoading()
        }
                for (ProfileResult child : profile.getProfiledChildren()) {
                doc.add(new StringField("id", String.valueOf(i), Field.Store.YES));
            this.enableStoredFields = true;
    public void testExplainPhaseProfiling() throws Exception {
    }
                    String innerHitName = innerHitsFetchProfile.getQueryName();
                new TimingAssertions(children.get("FetchSourcePhase").getTimeBreakdown()).assertTimingPresent(FetchTimingType.PROCESS)
            when(context.getQueryShardContext()).thenReturn(queryShardContext);
                when(context.storedFieldsContext()).thenReturn(null);
            List<Document> docs = new TestDocumentBuilder().addDocuments(1, true).build();
                ProfileResult profile = executeFetchPhaseAndGetProfile(context, subPhases);
            // Profiling setup
        private final IndexReader reader;
            try (IndexReader reader = DirectoryReader.open(dir)) {
                    .assertTimingPresent(FetchTimingType.SET_NEXT_READER);
                Map<String, ProfileResult> children = new HashMap<>();
            for (int i = 0; i < docIds.length; i++) {
                IndexSearcher.getDefaultQueryCache(),
                // Only include the FetchDocValuesPhase in the sub-phases list
                // Create a search context with only source loading enabled
                topHitsContext2.size(1);
                    .withDocValues(new FieldAndFormat("id", null))  // Enable doc values for the id field
                when(context.sort()).thenReturn(null);
                when(context.fetchFieldsContext()).thenReturn(null);
import org.apache.lucene.search.MatchAllDocsQuery;
                ParsedQuery pq = new ParsedQuery(new MatchAllDocsQuery());
                assertEquals(1, children.size());
        SearchContextBuilder withScriptFields(ScriptFieldsContext ctx) {
            when(context.seqNoAndPrimaryTerm()).thenReturn(enableSeqNoPrimaryTerm);
                assertEquals(1, children.size());
        try (Directory dir = newDirectory()) {
                    String topHitsName = topHitsFetchProfile.getQueryName();
            }
                assertTrue("Missing profile for FetchVersionPhase", children.containsKey("FetchVersionPhase"));
        try (Directory dir = newDirectory()) {
                    .withQueryShardContext(qsc)
            this.enableSourceLoading = true;
        super.setUp();
        private SearchHighlightContext highlightContext = null;
                IndexSearcher.getDefaultQueryCachingPolicy(),
                    .withStoredFields("_source")
                Map<String, ProfileResult> children = new HashMap<>();
import org.apache.lucene.search.ScoreDoc;
        public HighlightField highlight(FieldHighlightContext fieldContext) {
    }
                Set<String> actualInnerHitNames = new HashSet<>();
                assertEquals("Should have all expected inner hit names", expectedInnerHitNames, actualInnerHitNames);
                List<ProfileResult> innerHitsProfiles = new ArrayList<>();
        private boolean enableVersion = false;
            when(mapperService.hasNested()).thenReturn(false);
                new org.apache.lucene.search.TopDocs(new TotalHits(docIds.length, TotalHits.Relation.EQUAL_TO), scoreDocs),
                    assertTrue("Profile name should end with ']'", profileName.endsWith("]"));
            when(context.hasScriptFields()).thenReturn(enableScriptFields);
                }
                }
        SearchContextBuilder withSeqNoPrimaryTerm() {
                    String profileName = profile.getQueryName();
            }
        }
        fetchPhase.execute(context);
import org.opensearch.search.fetch.subphase.FetchVersionPhase;
            }
            return new TopDocsAndMaxScore(topDocs, 1.0f);
        }
                }
        try (Directory dir = newDirectory()) {
            List<Document> docs = new TestDocumentBuilder().addDocuments(1, true).build();
import org.opensearch.search.SearchHit;
            when(context.indexShard()).thenReturn(indexShard);
                Set<String> expectedTopHitsNames = Set.of("top_hits_agg1", "top_hits_agg2", "top_hits_agg3");
                // Should have 1 standard fetch profile + 3 inner hits fetch profiles = 4 total
                        .assertTimingPresent(FetchTimingType.LOAD_SOURCE)
            for (int i = 0; i < count; i++) {
        SearchContextBuilder(IndexReader reader, int[] docIds, IndexShard indexShard) {
    public void testSeqNoPrimaryTermPhaseProfiling() throws Exception {
                    .withFetchFields(new FieldAndFormat("content", null))  // Enable fetch fields for the content field
        SearchContextBuilder withDocValues(FieldAndFormat... fields) {
                Map<String, ProfileResult> children = new HashMap<>();
        }
    }
                    children.put(child.getQueryName(), child);
            List<Document> docs = new TestDocumentBuilder().addDocuments(1, true).build();
            super(name, context);
        SearchContextBuilder withFetchScore() {
            when(context.fetchResult()).thenReturn(fetchResult);
                assertThat(profileResults, hasSize(3));
            this.enableDocValues = true;
            when(mapperService.documentMapper()).thenReturn(documentMapper);
                        children.put(child.getQueryName(), child);
                    children.put(child.getQueryName(), child);
            try (IndexReader reader = DirectoryReader.open(dir)) {
 * this file be licensed under the Apache-2.0 license or a
                        .assertTimingPresent(FetchTimingType.BUILD_SUB_PHASE_PROCESSORS)
        try (Directory dir = newDirectory()) {
            MapperService mapperService = mock(MapperService.class);
                SearchContext context = new SearchContextBuilder(reader, docIds, indexShard).withSourceLoading()
                SearchContext context = new SearchContextBuilder(reader, docIds, indexShard).withSourceLoading()  // Enable source loading
                    .build();
                    actualTopHitsNames.add(topHitsName);
    @Override
        return profileResults.get(0);
import org.apache.lucene.search.SortField;
                Set<String> expectedInnerHitNames = Set.of("inner1", "inner2", "inner3");
            // Fetch result setup
import org.apache.lucene.search.Query;
import java.nio.charset.StandardCharsets;
        SearchContextBuilder withParsedQuery(ParsedQuery pq) {
                scoreDocs[i] = new ScoreDoc(docIds[i], 1.0f);
    }
import java.util.HashMap;
import org.opensearch.search.fetch.subphase.FetchSourceContext;
            this.reader = reader;
import org.opensearch.search.fetch.subphase.highlight.Highlighter;
            List<Document> docs = new TestDocumentBuilder().addDocuments(3, true).build();
                QueryShardContext qsc = mock(QueryShardContext.class);
                    .assertTimingPresent(FetchTimingType.SET_NEXT_READER);
                    .withQueryShardContext(qsc)
            try (IndexReader reader = DirectoryReader.open(dir)) {
            this.query = query;
    }
                for (ProfileResult child : profile.getProfiledChildren()) {
                // Create multiple inner hit contexts
import org.apache.lucene.document.Field;
            when(documentMapper.typeText()).thenReturn(new Text("_doc"));
            when(context.isCancelled()).thenReturn(false);
    }
        try (Directory dir = newDirectory()) {
                    .build();
            for (int i = 0; i < docIds.length; i++) {
                Set<String> actualTopHitsNames = new HashSet<>();
            return this;
            }
                        .assertTimingPresent(FetchTimingType.LOAD_SOURCE)
                innerHits.addInnerHitDefinition(innerContext1);
                // Create a search context with only explain enabled
                // Create a search context with doc values enabled
                    .build();
                // Create a search context with highlighting enabled
import org.opensearch.index.mapper.MapperService;
                // Verify the profile results
import org.apache.lucene.search.TotalHits;
        }
                SearchContext context = new SearchContextBuilder(reader, docIds, indexShard).withSourceLoading()
                assertTrue("Missing profile for ExplainPhase", children.containsKey("ExplainPhase"));
                QueryShardContext qsc = mock(QueryShardContext.class);
        closeShards(indexShard);
            this.enableFetchFields = true;
                }
            IndexSearcher searcher = new IndexSearcher(reader);
                }
                    .build();
    private static class TestDocumentBuilder {
import org.opensearch.search.fetch.subphase.highlight.FieldHighlightContext;
        }
                ProfileResult profile = executeFetchPhaseAndGetProfile(context, subPhases);
                Document doc = new Document();
                assertEquals(1, children.size());
                1.0f
            }
            int[] docIds = indexDocumentsAndGetIds(dir, docs, 1);
                    .withStoredFields("_source")
    private static class StubHighlighter implements Highlighter {
        try (Directory dir = newDirectory()) {
import org.opensearch.search.fetch.subphase.FetchScorePhase;
    }
        List<Document> build() {
        }
import org.opensearch.search.fetch.subphase.FetchSourcePhase;
            int[] docIds = indexDocumentsAndGetIds(dir, docs, 1);
                // Check that MatchedQueriesPhase is present and has timing information
import org.opensearch.core.common.text.Text;
                // Create a search context with version enabled
            } else {
                when(context.highlight()).thenReturn(null);
        }
                innerHits.addInnerHitDefinition(innerContext2);
            String countKey = timingKey + "_count";
        }
            this.enableScriptFields = true;
    }
        private List<FieldAndFormat> docValueFields = Collections.emptyList();
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder;
                    .assertTimingPresent(FetchTimingType.SET_NEXT_READER);
                InnerHitsContext.InnerHitSubContext innerContext1 = new DummyInnerHitSubContext("inner1", context);
        try (Directory dir = newDirectory()) {
        }
            }
            return this;
            int[] docIds = indexDocumentsAndGetIds(dir, docs, 1);
            int[] docIds = indexDocumentsAndGetIds(dir, docs, 2);
    }
            List<Document> docs = new TestDocumentBuilder().addDocuments(1, true).build();
                // Only include the FetchScorePhase in the sub-phases list
                new TimingAssertions(children.get("FetchDocValuesPhase").getTimeBreakdown()).assertTimingPresent(FetchTimingType.PROCESS)
                    assertTrue("Inner hit " + innerHitName + " should contain FetchSourcePhase", children.containsKey("FetchSourcePhase"));
            SourceLookup sourceLookup = new SourceLookup();
            int[] docIds = new int[Math.min(maxResults, topDocs.scoreDocs.length)];
            int[] docIds = indexDocumentsAndGetIds(dir, docs, 1);
                // Only include the FetchFieldsPhase in the sub-phases list
                // Verify the profile results
            try (IndexReader reader = DirectoryReader.open(dir)) {
                w.addDocument(doc);
        private ScriptFieldsContext scriptFieldsContext = null;
            }
            this.storedFieldNames = Arrays.asList(fieldNames);
        SearchContextBuilder withStoredFields(String... fieldNames) {
            when(context.explain()).thenReturn(enableExplain);
                Map<String, ProfileResult> children = new HashMap<>();
            this.docIds = docIds;
                    .build();
                }
    // Minimal inner hit sub context
import org.opensearch.search.internal.SearchContext;
                    .withQueryShardContext(qsc)
import java.util.List;
            try (IndexReader reader = DirectoryReader.open(dir)) {
    private int[] indexDocumentsAndGetIds(Directory dir, List<Document> docs, int maxResults) throws IOException {
                new TimingAssertions(children.get("FetchFieldsPhase").getTimeBreakdown()).assertTimingPresent(FetchTimingType.PROCESS)
                List<ProfileResult> profileResults = fetchProfiler.getTree();
            if (enableScriptFields) {
                when(context.fetchSourceContext()).thenReturn(FetchSourceContext.FETCH_SOURCE);
            QuerySearchResult queryResult = new QuerySearchResult();
            return this;
            int[] docIds = indexDocumentsAndGetIds(dir, docs, 1);
                    new TimingAssertions(topHitsFetchProfile.getTimeBreakdown()).assertBreakdownNotEmpty()
            int[] docIds = indexDocumentsAndGetIds(dir, docs, 1);
            int[] docIds = indexDocumentsAndGetIds(dir, docs, 1);
            if (enableStoredFields && !storedFieldNames.isEmpty()) {
                assertEquals(1, children.size());
            org.opensearch.index.mapper.SourceFieldMapper sourceFieldMapper = mock(org.opensearch.index.mapper.SourceFieldMapper.class);
                SubSearchContext topHitsContext3 = new SubSearchContext(mainContext);
                // Check that HighlightPhase is present and has timing information
                context
        }
                // Verify the standard fetch profile (first result)
import org.apache.lucene.search.Sort;
                for (ProfileResult child : standardFetchProfile.getProfiledChildren()) {
            } else {
            List<Document> docs = new TestDocumentBuilder().addDocuments(1, true).build();
                new TimingAssertions(children.get("FetchVersionPhase").getTimeBreakdown()).assertTimingPresent(FetchTimingType.PROCESS)
                fetchPhase.execute(context);
import org.opensearch.index.mapper.MappedFieldType;
        }
            // Source loading configuration
                    .assertTimingPresent(FetchTimingType.CREATE_STORED_FIELDS_VISITOR)
                assertEquals("Should have 3 inner hits profiles", 3, innerHitsProfiles.size());
                    .build();
            }
        try (Directory dir = newDirectory()) {
                        .assertTimingPresent(FetchTimingType.GET_NEXT_READER);
                for (ProfileResult child : profile.getProfiledChildren()) {
import org.opensearch.search.profile.fetch.FetchTimingType;
                    actualInnerHitNames.add(innerHitName);
                    .withParsedQuery(pq)
 *
                for (int i = 1; i < profileResults.size(); i++) {
                SearchContext context = new SearchContextBuilder(reader, docIds, indexShard).withSourceLoading()
                    .withVersion() // Enable version
                for (ProfileResult child : profile.getProfiledChildren()) {
import org.opensearch.index.shard.IndexShardTestCase;
            this.enableExplain = true;
                // Create a search context with fetch fields enabled
            this.highlightContext = hc;
                }
                    }
import org.opensearch.search.lookup.SearchLookup;
                List<FetchSubPhase> subPhases = Collections.singletonList(new ExplainPhase());
                        .assertTimingPresent(FetchTimingType.CREATE_STORED_FIELDS_VISITOR)
            } else {
                new TimingAssertions(children.get("ExplainPhase").getTimeBreakdown()).assertTimingPresent(FetchTimingType.PROCESS)
                when(context.docValuesContext()).thenReturn(null);
                QueryShardContext qsc = mock(QueryShardContext.class);
                QueryShardContext qsc = mock(QueryShardContext.class);
            try (IndexReader reader = DirectoryReader.open(dir)) {
/*
            }
        private boolean enableStoredFields = false;
                true,
