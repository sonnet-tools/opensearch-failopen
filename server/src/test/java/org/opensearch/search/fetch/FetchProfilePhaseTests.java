    private static class TimingAssertions {
            assertTrue("Count key should be present: " + countKey, breakdown.containsKey(countKey));
        try (IndexReader reader = DirectoryReader.open(dir)) {
            TopDocs topDocs = searcher.search(new MatchAllDocsQuery(), maxResults);
                for (ProfileResult child : standardFetchProfile.getProfiledChildren()) {  
                Map<String, ProfileResult> children = new HashMap<>();
        }
            ContextIndexSearcher searcher = new ContextIndexSearcher(  
                ProfileResult profile = executeFetchPhaseAndGetProfile(context, Collections.emptyList());  
import org.opensearch.search.fetch.subphase.FetchScorePhase;
                SearchHighlightContext highlight = hb.build(qsc);
        }  
import org.opensearch.search.fetch.subphase.FetchDocValuesContext;
            int[] docIds = indexDocumentsAndGetIds(dir, docs, 1);
        TimingAssertions assertBreakdownNotEmpty() {  
                assertTrue("Missing profile for HighlightPhase", children.containsKey("HighlightPhase"));
                List<FetchSubPhase> subPhases = Collections.singletonList(  
    }  
            int[] docIds = indexDocumentsAndGetIds(dir, docs, 2);
                ProfileResult profile = executeFetchPhaseAndGetProfile(context, subPhases);
        }
                ParsedQuery pq = new ParsedQuery(new MatchAllDocsQuery());
import org.opensearch.search.profile.fetch.FetchTimingType;
    private static class TestDocumentBuilder {
                List<FetchSubPhase> subPhases = Collections.singletonList(new ExplainPhase());  
                for (ProfileResult child : profile.getProfiledChildren()) {  
                }
            int[] docIds = indexDocumentsAndGetIds(dir, docs, 1);  
                    children = new HashMap<>();
                // Create a search context with doc values enabled
                    .build();
                    .withQueryShardContext(qsc)  
                Map<String, ProfileResult> children = new HashMap<>();
        }  
        private boolean enableExplain = false;
                    .withStoredFields("_source")  
                List<FetchSubPhase> subPhases = Collections.singletonList(new FetchDocValuesPhase());
            this.scriptFieldsContext = ctx;
import java.util.List;  
        SearchContextBuilder withFetchFields(FieldAndFormat... fields) {
    private IndexShard indexShard;
        }  
                when(context.fetchSourceContext()).thenReturn(FetchSourceContext.FETCH_SOURCE);
                }  
                List<FetchSubPhase> subPhases = Collections.singletonList(new FetchSourcePhase());  
    }
import java.util.HashSet;
            int[] docIds = indexDocumentsAndGetIds(dir, docs, 1);  
        try (Directory dir = newDirectory()) {
import org.opensearch.search.fetch.subphase.highlight.HighlightField;
            when(mapperService.hasNested()).thenReturn(false);
                }
                // Check that HighlightPhase is present and has timing information  
                ParsedQuery pq = new ParsedQuery(new MatchAllDocsQuery(), Map.of("test_query", new MatchAllDocsQuery()));
                StoredFieldsContext storedFieldsContext = StoredFieldsContext.fromList(storedFieldNames);  
                // Check that FetchSourcePhase is present and has timing information
                    .withParsedQuery(pq)
                    .assertTimingPresent(FetchTimingType.SET_NEXT_READER);
                    children.put(child.getQueryName(), child);
                QueryShardContext qsc = mock(QueryShardContext.class);
                fetchPhase.execute(topHitsContext2, "fetch_top_hits_aggregation[top_hits_agg2]");  
            return docIds;
                QueryShardContext qsc = mock(QueryShardContext.class);
                when(context.trackScores()).thenReturn(false);
                    .withParsedQuery(pq)
                for (ProfileResult child : profile.getProfiledChildren()) {
                        .assertTimingPresent(FetchTimingType.LOAD_STORED_FIELDS)
                    .assertTimingPresent(FetchTimingType.SET_NEXT_READER);
                documents.add(doc);  
                    actualTopHitsNames.add(topHitsName);  
    // Helper method to index documents and get their IDs  
            assertTrue("Timing key should be present: " + timingKey, breakdown.containsKey(timingKey));
            return this;  
                // Create the main search context  
            // Fetch result setup  
            this.storedFieldNames = Arrays.asList(fieldNames);
            when(context.docIdsToLoadSize()).thenReturn(docIds.length);
                ProfileResult standardFetchProfile = profileResults.get(0);  
                    .assertTimingPresent(FetchTimingType.BUILD_SUB_PHASE_PROCESSORS)  
            if (enableFetchScore) {  
            this.enableSourceLoading = true;
                new TimingAssertions(children.get("FetchScorePhase").getTimeBreakdown()).assertTimingPresent(FetchTimingType.PROCESS)
        private boolean enableVersion = false;  
            this.enableFetchFields = true;  
            List<Document> docs = new TestDocumentBuilder().addDocuments(1, true).build();  
        }
        }  
    public void setUp() throws Exception {
            List<Document> docs = new TestDocumentBuilder().addDocuments(1, true).build();  
                        "Profile name should start with 'fetch_top_hits_aggregation['",  
        try (Directory dir = newDirectory()) {
        }
                    new HighlightPhase(Collections.singletonMap("stub", new StubHighlighter()))
            when(context.getQueryShardContext()).thenReturn(queryShardContext);
                fetchPhase.execute(context);  
                for (ProfileResult child : profile.getProfiledChildren()) {  
                HighlightBuilder hb = new HighlightBuilder();
            when(mapperService.documentMapper()).thenReturn(documentMapper);
                // Verify the profile results  
                assertEquals(1, children.size());
                ProfileResult profile = executeFetchPhaseAndGetProfile(context, subPhases);
                        .assertTimingPresent(FetchTimingType.SET_NEXT_READER);
        SearchContextBuilder withDocValues(FieldAndFormat... fields) {
                    children.put(child.getQueryName(), child);
            List<Document> docs = new TestDocumentBuilder().addDocuments(1, true).build();
import org.apache.lucene.document.Document;
                    new TimingAssertions(children.get("FetchSourcePhase").getTimeBreakdown()).assertTimingPresent(FetchTimingType.PROCESS)
                // Only include the FetchFieldsPhase in the sub-phases list
        }
                    .withParsedQuery(pq)
            try (IndexReader reader = DirectoryReader.open(dir)) {  
import org.opensearch.search.fetch.subphase.FetchFieldsContext;  
                // Check that ExplainPhase is present and has timing information
                List<FetchSubPhase> subPhases = Collections.singletonList(new FetchFieldsPhase());
            }  
            return this;  
        private final List<Document> documents = new ArrayList<>();
        }  
import org.apache.lucene.tests.index.RandomIndexWriter;  
                new org.apache.lucene.search.TopDocs(new TotalHits(docIds.length, TotalHits.Relation.EQUAL_TO), scoreDocs),
        public HighlightField highlight(FieldHighlightContext fieldContext) {
                new TimingAssertions(children.get("FetchSourcePhase").getTimeBreakdown()).assertTimingPresent(FetchTimingType.PROCESS)
            SearchLookup searchLookup = mock(SearchLookup.class);  
import org.apache.lucene.search.MatchAllDocsQuery;
import java.nio.charset.StandardCharsets;  
            this.fetchFields = Arrays.asList(fields);
        }
                ParsedQuery pq = new ParsedQuery(new MatchAllDocsQuery(), Map.of("named", new MatchAllDocsQuery()));
        List<ProfileResult> profileResults = fetchProfiler.getTree();  
    }
                    .withParsedQuery(pq)
                new TimingAssertions(children.get("HighlightPhase").getTimeBreakdown()).assertTimingPresent(FetchTimingType.PROCESS)  
            this.enableExplain = true;
            List<Document> docs = new TestDocumentBuilder().addDocuments(1, true).build();
                FetchProfiler fetchProfiler = context.getProfilers().getFetchProfiler();
        private final Map<String, Long> breakdown;
                    children.put(child.getQueryName(), child);  
                assertEquals("Should have all expected inner hit names", expectedInnerHitNames, actualInnerHitNames);  
                // Verify the profile results
import org.opensearch.search.fetch.subphase.highlight.FieldHighlightContext;
            try (IndexReader reader = DirectoryReader.open(dir)) {
        assertThat(profileResults, hasSize(greaterThanOrEqualTo(1)));
        @Override
            // Mock the sourceMapper  
        private List<FieldAndFormat> fetchFields = Collections.emptyList();
                    .build();  
            when(context.hasScriptFields()).thenReturn(enableScriptFields);
                doc.add(new StringField("id", String.valueOf(i), Field.Store.YES));
            List<Document> docs = new TestDocumentBuilder().addDocuments(1, true).build();  
                SearchContext context = new SearchContextBuilder(reader, docIds, indexShard).withSourceLoading()  // Enable source loading
                innerHits.addInnerHitDefinition(innerContext2);
                fetchPhase.execute(topHitsContext1, "fetch_top_hits_aggregation[top_hits_agg1]");
                    assertTrue(
            int[] docIds = indexDocumentsAndGetIds(dir, docs, 1);
                    .withQueryShardContext(qsc)
                    .build();  
                }
        SearchContextBuilder withScriptFields(ScriptFieldsContext ctx) {  
            // Search lookup setup
import org.opensearch.search.fetch.subphase.FetchFieldsPhase;
            when(context.parsedQuery()).thenReturn(parsedQuery);
                for (ProfileResult child : profile.getProfiledChildren()) {
import org.opensearch.search.query.QuerySearchResult;
                ProfileResult profile = executeFetchPhaseAndGetProfile(context, subPhases);
            return context;
                new TimingAssertions(children.get("FetchDocValuesPhase").getTimeBreakdown()).assertTimingPresent(FetchTimingType.PROCESS)
import org.opensearch.search.fetch.subphase.FetchDocValuesPhase;
                for (ProfileResult innerHitsFetchProfile : innerHitsProfiles) {  
                    String topHitsName = topHitsFetchProfile.getQueryName();  
                        .assertTimingPresent(FetchTimingType.CREATE_STORED_FIELDS_VISITOR)
            IndexSearcher searcher = new IndexSearcher(reader);  
                SearchContext context = new SearchContextBuilder(reader, docIds, indexShard).withSourceLoading()
                    String topHitsName = profileName.substring("fetch_top_hits_aggregation[".length(), profileName.length() - 1);
            this.docValueFields = Arrays.asList(fields);
                InnerHitsContext innerHits = new InnerHitsContext();  
        FetchPhase fetchPhase = new FetchPhase(subPhases);
            );
                topHitsContext2.size(1);
                    children.put(child.getQueryName(), child);
import org.apache.lucene.search.Query;
import org.apache.lucene.store.Directory;
                    String innerHitName = profileName.substring("fetch_inner_hits[".length(), profileName.length() - 1);
            List<Document> docs = new TestDocumentBuilder().addDocuments(1, true).build();  
                    Map<String, ProfileResult> children = new HashMap<>();
                List<FetchSubPhase> subPhases = Collections.singletonList(new FetchVersionPhase());  
            }  
        }  
            } else {
            try (IndexReader reader = DirectoryReader.open(dir)) {
                    assertTrue("Profile name should end with ']'", profileName.endsWith("]"));  
import org.opensearch.search.fetch.subphase.FetchSourcePhase;
            when(context.searcher()).thenReturn(searcher);  
                SubSearchContext topHitsContext1 = new SubSearchContext(mainContext);
    public void tearDown() throws Exception {
                }
        FetchProfiler fetchProfiler = context.getProfilers().getFetchProfiler();
                ProfileResult profile = executeFetchPhaseAndGetProfile(context, subPhases);  
                new TimingAssertions(children.get("ExplainPhase").getTimeBreakdown()).assertTimingPresent(FetchTimingType.PROCESS)
                    .withParsedQuery(pq)
                );
            try (IndexReader reader = DirectoryReader.open(dir)) {  
                topHitsContext3.docIdsToLoad(new int[] { docIds[2] }, 0, 1);
import org.opensearch.index.shard.IndexShard;
        }
    }
            return this;
                SubSearchContext topHitsContext2 = new SubSearchContext(mainContext);  
                    .build();
                new TimingAssertions(children.get("FetchFieldsPhase").getTimeBreakdown()).assertTimingPresent(FetchTimingType.PROCESS)  
                assertTrue("Missing profile for ExplainPhase", children.containsKey("ExplainPhase"));  
            int[] docIds = indexDocumentsAndGetIds(dir, docs, 1);
        }
                    .withStoredFields("_source")  
                QueryShardContext qsc = mock(QueryShardContext.class);  
            return this;
        @Override  
            this.enableStoredFields = true;
            int[] docIds = new int[Math.min(maxResults, topDocs.scoreDocs.length)];  
            TopDocsAndMaxScore topDocsAndMaxScore = new TopDocsAndMaxScore(
                // Check that SeqNoPrimaryTermPhase is present and has timing information
            String countKey = timingKey + "_count";
        }  
                SearchContext context = new SearchContextBuilder(reader, docIds, indexShard).withSourceLoading()
            }
                IndexSearcher.getDefaultQueryCachingPolicy(),
            }
                Map<String, ProfileResult> children = new HashMap<>();
            return this;
                    .withQueryShardContext(qsc)
                    String innerHitName = innerHitsFetchProfile.getQueryName();
                    .withSeqNoPrimaryTerm() // Enable sequence number and primary term  
        }
                    assertTrue("Top hits " + topHitsName + " should contain FetchSourcePhase", children.containsKey("FetchSourcePhase"));
import org.opensearch.search.internal.SearchContext;  
            // Stored fields configuration
        try (RandomIndexWriter w = new RandomIndexWriter(random(), dir, new IndexWriterConfig(new StandardAnalyzer()))) {
                    .assertTimingPresent(FetchTimingType.SET_NEXT_READER);
                when(context.storedFieldsContext()).thenReturn(null);  
                ParsedQuery pq = new ParsedQuery(new MatchAllDocsQuery());
            this.reader = reader;
                Map<String, ProfileResult> children = new HashMap<>();  
            return this;  
                    .build();  
                    actualInnerHitNames.add(innerHitName);
import org.apache.lucene.search.TotalHits;
        SearchContextBuilder(IndexReader reader, int[] docIds, IndexShard indexShard) {
                    .withStoredFields("_source")  
                    .build();
    public void testFetchScorePhaseProfiling() throws Exception {  
            for (int i = 0; i < docIds.length; i++) {
                topHitsContext2.docIdsToLoad(new int[] { docIds[1] }, 0, 1);
            this.enableFetchScore = true;
            when(context.seqNoAndPrimaryTerm()).thenReturn(enableSeqNoPrimaryTerm);
import org.opensearch.search.fetch.subphase.FieldAndFormat;  
                    new TimingAssertions(topHitsFetchProfile.getTimeBreakdown()).assertBreakdownNotEmpty()  
            if (enableSourceLoading) {  
            // Basic document loading configuration
            when(context.indexShard()).thenReturn(indexShard);
                    .assertTimingPresent(FetchTimingType.CREATE_STORED_FIELDS_VISITOR)  
                assertEquals(1, children.size());
        return profileResults.get(0);  
    }
                1.0f  
            MapperService mapperService = mock(MapperService.class);
            return documents;  
        super.tearDown();  
            List<Document> docs = new TestDocumentBuilder().addDocuments(3, true).build();
            when(searchLookup.source()).thenReturn(sourceLookup);
        }  
                context
                Sort sort = new Sort(SortField.FIELD_SCORE);
                // Should have 1 standard fetch profile + 3 inner hits fetch profiles = 4 total
 */  
        fetchPhase.execute(context);  
            // Basic query configuration
        try (Directory dir = newDirectory()) {
                    .withQueryShardContext(qsc)
                doc.add(new TextField("content", "test content " + i, Field.Store.YES));
                ParsedQuery pq = new ParsedQuery(new MatchAllDocsQuery());
            }
import org.apache.lucene.search.IndexSearcher;  
                    children.put(child.getQueryName(), child);
import org.apache.lucene.search.Sort;
            when(context.docIdsToLoad()).thenReturn(docIds);  
        private boolean enableDocValues = false;
            }  
        }
                    .assertTimingPresent(FetchTimingType.SET_NEXT_READER);  
                Document doc = new Document();  
                    .withQueryShardContext(qsc)
                SearchContext context = new SearchContextBuilder(reader, docIds, indexShard).withSourceLoading()
                // Create multiple inner hit contexts
                }
                // Create a search context with fetch fields enabled
                ProfileResult profile = executeFetchPhaseAndGetProfile(context, subPhases);
                // Create a search context with sequence number and primary term enabled
                // Check that MatchedQueriesPhase is present and has timing information
        }  
import org.opensearch.search.profile.ProfileResult;
        public boolean canHighlight(MappedFieldType fieldType) {
            org.opensearch.index.mapper.SourceFieldMapper sourceFieldMapper = mock(org.opensearch.index.mapper.SourceFieldMapper.class);
import org.opensearch.search.fetch.subphase.MatchedQueriesPhase;
                    .withParsedQuery(pq)
                    assertEquals("Inner hit " + innerHitName + " should have 1 sub-phase", 1, children.size());
 * this file be licensed under the Apache-2.0 license or a
                when(context.fetchFieldsContext()).thenReturn(null);  
                SearchContext context = new SearchContextBuilder(reader, docIds, indexShard).withSourceLoading()  
        }
            try (IndexReader reader = DirectoryReader.open(dir)) {
                ParsedQuery pq = new ParsedQuery(new MatchAllDocsQuery());
public class FetchProfilePhaseTests extends IndexShardTestCase {
                when(context.docValuesContext()).thenReturn(null);  
import java.util.ArrayList;
import org.opensearch.index.query.QueryShardContext;
                }
                QueryShardContext qsc = mock(QueryShardContext.class);  
                when(context.docValuesContext()).thenReturn(new FetchDocValuesContext(docValueFields));
                    .assertTimingPresent(FetchTimingType.GET_NEXT_READER);
            return this;
            // Index searcher setup
            this.highlightContext = hc;
                List<ProfileResult> profileResults = fetchProfiler.getTree();  
        }
                new TimingAssertions(children.get("FetchVersionPhase").getTimeBreakdown()).assertTimingPresent(FetchTimingType.PROCESS)
                    .withStoredFields("_source")
        SearchContextBuilder withSourceLoading() {
                QueryShardContext qsc = mock(QueryShardContext.class);
import org.apache.lucene.index.DirectoryReader;  
                List<FetchSubPhase> subPhases = Collections.singletonList(new MatchedQueriesPhase());  
                }
import org.apache.lucene.document.StringField;
                QueryShardContext qsc = mock(QueryShardContext.class);  
            }
            if (enableScriptFields) {
        SearchContextBuilder withFetchScore() {  
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;
package org.opensearch.search.fetch;
            return this;  
            when(queryShardContext.newFetchLookup()).thenReturn(searchLookup);  
            return new TopDocsAndMaxScore(topDocs, 1.0f);
                    .assertTimingPresent(FetchTimingType.SET_NEXT_READER);
    public void testFetchVersionPhaseProfiling() throws Exception {  
                assertTrue("Missing profile for FetchFieldsPhase", children.containsKey("FetchFieldsPhase"));
            }  
            }
        }
import org.opensearch.search.DocValueFormat;
        }
                        .assertTimingPresent(FetchTimingType.LOAD_SOURCE)
                    .build();
            }  
        private Query query = new MatchAllDocsQuery();
    }  
        private QueryShardContext externalQueryShardContext = null;
 * SPDX-License-Identifier: Apache-2.0
                // Verify the profile results
                : mock(QueryShardContext.class);
            int[] docIds = indexDocumentsAndGetIds(dir, docs, 3);  
            ScoreDoc[] docs = new ScoreDoc[] { new ScoreDoc(hit.docId(), 1.0f) };
        private ScriptFieldsContext scriptFieldsContext = null;  
        DummyInnerHitSubContext(String name, SearchContext context) {
        TimingAssertions assertTimingPresent(FetchTimingType timingType) {
        SearchContextBuilder withHighlight(SearchHighlightContext hc) {  
                    assertTrue("Inner hit " + innerHitName + " should contain FetchSourcePhase", children.containsKey("FetchSourcePhase"));  
            List<Document> docs = new TestDocumentBuilder().addDocuments(1, true).build();  
                    .withFetchScore() // Enable score fetching
import org.opensearch.search.fetch.subphase.FetchVersionPhase;
import org.apache.lucene.search.SortField;
                IndexSearcher.getDefaultQueryCache(),  
                // Verify the profile results
import org.apache.lucene.analysis.standard.StandardAnalyzer;
                assertThat(profileResults, hasSize(3));  
                    assertTrue("Profile name should start with 'fetch_inner_hits['", profileName.startsWith("fetch_inner_hits["));
    // Helper method to execute fetch phase and get profile results  
            this.docIds = docIds;  
            queryResult.topDocs(topDocsAndMaxScore, null);
                when(context.storedFieldsContext()).thenReturn(storedFieldsContext);
                    .build();
                List<ProfileResult> innerHitsProfiles = new ArrayList<>();
            return this;
    private static class DummyInnerHitSubContext extends InnerHitsContext.InnerHitSubContext {
                assertEquals(1, children.size());
                    .withStoredFields("_source")
    private static class StubHighlighter implements Highlighter {  
            return this;
                for (ProfileResult profile : profileResults) {
                topHitsContext1.size(1);
    public void testSeqNoPrimaryTermPhaseProfiling() throws Exception {
                InnerHitsContext.InnerHitSubContext innerContext3 = new DummyInnerHitSubContext("inner3", context);
            this.query = query;
            when(context.getProfilers()).thenReturn(profilers);  
                QueryShardContext qsc = mock(QueryShardContext.class);
                // Only include the FetchVersionPhase in the sub-phases list
    }
            return this;  
            when(context.explain()).thenReturn(enableExplain);
import static org.hamcrest.Matchers.greaterThan;
                // Check that FetchVersionPhase is present and has timing information
            }  
                assertTrue("Missing profile for FetchVersionPhase", children.containsKey("FetchVersionPhase"));  
            when(context.sourceRequested()).thenReturn(enableSourceLoading);
                    children.put(child.getQueryName(), child);
            if (enableFetchFields) {  
    }
                    String profileName = profile.getQueryName();  
        private final IndexReader reader;
            int[] docIds = indexDocumentsAndGetIds(dir, docs, 1);
        indexShard = newShard(true);
            when(documentMapper.sourceMapper()).thenReturn(sourceFieldMapper);  
                innerHits.addInnerHitDefinition(innerContext3);  
            return this;
                // Verify the standard fetch profile (first result)
                // Only include the SeqNoPrimaryTermPhase in the sub-phases list  
            return null;  
                    .assertTimingPresent(FetchTimingType.SET_NEXT_READER);
            }  
        }  
                assertEquals(1, children.size());  
            );
                assertTrue("Missing profile for FetchDocValuesPhase", children.containsKey("FetchDocValuesPhase"));
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder;  
import org.opensearch.search.lookup.SearchLookup;
                QueryShardContext qsc = mock(QueryShardContext.class);  
        private boolean enableStoredFields = false;  
import org.apache.lucene.index.IndexWriterConfig;
                        .assertTimingPresent(FetchTimingType.GET_NEXT_READER);
                SearchContext context = new SearchContextBuilder(reader, docIds, indexShard).withSourceLoading()
import org.opensearch.index.mapper.MappedFieldType;
import org.opensearch.core.common.text.Text;
            }
                    .withParsedQuery(pq)  
                assertTrue("Missing profile for SeqNoPrimaryTermPhase", children.containsKey("SeqNoPrimaryTermPhase"));
        public TopDocsAndMaxScore topDocs(SearchHit hit) {
import org.apache.lucene.document.Field;  
                ProfileResult profile = executeFetchPhaseAndGetProfile(context, subPhases);
    public void testFetchFieldsPhaseProfiling() throws Exception {
                // Verify the profile results
    @Override
        }
                assertEquals(1, children.size());
        }
    }
                ParsedQuery pq = new ParsedQuery(new MatchAllDocsQuery());
                fetchPhase.execute(topHitsContext3, "fetch_top_hits_aggregation[top_hits_agg3]");
            return this;
            when(sourceFieldMapper.enabled()).thenReturn(true);
                    .assertTimingPresent(FetchTimingType.SET_NEXT_READER);
                Set<String> expectedInnerHitNames = Set.of("inner1", "inner2", "inner3");
            // Mapper service setup  
            if (highlightContext != null) {  
                FetchPhase fetchPhase = new FetchPhase(subPhases);  
            this.parsedQuery = pq;  
            return this;
        }
import static org.mockito.Mockito.when;
                    .withParsedQuery(pq)
        try (Directory dir = newDirectory()) {
                // Create a search context with score tracking enabled  
import org.apache.lucene.search.TopDocs;  
    }
                Map<String, ProfileResult> children = new HashMap<>();
                SearchContext mainContext = new SearchContextBuilder(reader, docIds, indexShard).withSourceLoading()
    }
                    String profileName = profile.getQueryName();
                    .assertTimingPresent(FetchTimingType.LOAD_SOURCE)
            this.enableSeqNoPrimaryTerm = true;
            List<Document> docs = new TestDocumentBuilder().addDocuments(3, true).build();
import org.opensearch.search.sort.SortAndFormats;  
                when(context.sort()).thenReturn(sf);  
    }  
            int[] docIds = indexDocumentsAndGetIds(dir, docs, 1);
        TimingAssertions(Map<String, Long> breakdown) {
}
import org.opensearch.index.mapper.MapperService;
            } else {
                // Verify the profile results
        SearchContextBuilder withVersion() {
                assertEquals(1, children.size());
                InnerHitsContext.InnerHitSubContext innerContext1 = new DummyInnerHitSubContext("inner1", context);
            }  
import org.opensearch.search.internal.SubSearchContext;
                null,  
        private boolean enableScriptFields = false;
            SourceLookup sourceLookup = new SourceLookup();
                for (ProfileResult child : profile.getProfiledChildren()) {
                Map<String, ProfileResult> children = new HashMap<>();  
                assertTrue("Missing profile for MatchedQueriesPhase", children.containsKey("MatchedQueriesPhase"));  
                }  
            for (int i = 0; i < count; i++) {
        }
            super(name, context);  
import org.opensearch.search.fetch.subphase.SeqNoPrimaryTermPhase;
                // Only include the FetchSourcePhase in the sub-phases list
            }
                }  
        try (Directory dir = newDirectory()) {
import org.opensearch.search.fetch.subphase.FetchSourceContext;  
import java.io.IOException;
                }
                SearchContext context = new SearchContextBuilder(reader, docIds, indexShard).withSourceLoading()
                    new TimingAssertions(children.get("FetchSourcePhase").getTimeBreakdown()).assertTimingPresent(FetchTimingType.PROCESS)
            }
                // Create a search context with only source loading enabled
                new TimingAssertions(children.get("FetchSourcePhase").getTimeBreakdown()).assertTimingPresent(FetchTimingType.PROCESS)
        private boolean enableSeqNoPrimaryTerm = false;
    public void testExplainPhaseProfiling() throws Exception {  
                    .withQueryShardContext(qsc)  
                    innerHitsProfiles.add(profile);  
                    .withQueryShardContext(qsc)  
                    children.put(child.getQueryName(), child);  
                FetchPhase fetchPhase = new FetchPhase(subPhases);
            try (IndexReader reader = DirectoryReader.open(dir)) {  
    }
        private boolean enableSourceLoading = false;
                List<FetchSubPhase> subPhases = Collections.singletonList(new SeqNoPrimaryTermPhase());
    private int[] indexDocumentsAndGetIds(Directory dir, List<Document> docs, int maxResults) throws IOException {
                    children.put(child.getQueryName(), child);
                ProfileResult profile = executeFetchPhaseAndGetProfile(context, subPhases);
        SearchContextBuilder withParsedQuery(ParsedQuery pq) {
    }
                ProfileResult profile = executeFetchPhaseAndGetProfile(context, subPhases);  
                // Only include the ExplainPhase in the sub-phases list
import org.opensearch.search.SearchHit;
            List<Document> docs = new TestDocumentBuilder().addDocuments(1, true).build();
    public void testMatchedQueriesPhaseProfiling() throws Exception {
            try (IndexReader reader = DirectoryReader.open(dir)) {
    }
                IndexSearcher.getDefaultSimilarity(),
                    .assertTimingPresent(FetchTimingType.SET_NEXT_READER);
                    }
            return true;
                hb.field(new HighlightBuilder.Field("content").highlighterType("stub"));  
                        .assertTimingPresent(FetchTimingType.GET_NEXT_READER);  
                if (includeSource) {
        SearchContextBuilder withExplain() {  
import org.opensearch.search.fetch.subphase.ScriptFieldsContext;  
            when(context.query()).thenReturn(query);  
                w.addDocument(doc);
                // Verify the profile results
import static org.mockito.Mockito.mock;
            when(context.fetchResult()).thenReturn(fetchResult);
                        .assertTimingPresent(FetchTimingType.LOAD_SOURCE)  
                for (ProfileResult child : profile.getProfiledChildren()) {  
        SearchContextBuilder withStoredFields(String... fieldNames) {  
import org.opensearch.index.shard.IndexShardTestCase;  
                Map<String, ProfileResult> children = new HashMap<>();
                    );
            TopDocs topDocs = new TopDocs(new TotalHits(1, TotalHits.Relation.EQUAL_TO), docs);  
                    children.put(child.getQueryName(), child);
    public void testHighlightPhaseProfiling() throws Exception {
                ParsedQuery pq = new ParsedQuery(new MatchAllDocsQuery());
        SearchContextBuilder withQuery(Query query) {
                assertThat(profileResults, hasSize(4));  
    }
                    .withParsedQuery(pq)
                List<FetchSubPhase> subPhases = Collections.singletonList(new FetchScorePhase());  
                // Create highlight builder with stub highlighter
                assertEquals("Should have all expected top hits names", expectedTopHitsNames, actualTopHitsNames);  
        }  
                for (int i = 1; i < profileResults.size(); i++) {  
                reader,
                List<FetchSubPhase> subPhases = Collections.singletonList(new FetchSourcePhase());  
import org.opensearch.index.query.ParsedQuery;  
 * compatible open source license.
                innerHits.addInnerHitDefinition(innerContext1);
                    .withQueryShardContext(qsc)
        private ParsedQuery parsedQuery = null;
            List<Document> docs = new TestDocumentBuilder().addDocuments(1, true).build();
            for (Document doc : docs) {  
            try (IndexReader reader = DirectoryReader.open(dir)) {  
            try (IndexReader reader = DirectoryReader.open(dir)) {
        }
            // Query result setup
                ParsedQuery pq = new ParsedQuery(new MatchAllDocsQuery());
    private static class SearchContextBuilder {  
                // Create a search context with the parsed query containing named queries
                        .assertTimingPresent(FetchTimingType.SET_NEXT_READER);  
                ParsedQuery pq = new ParsedQuery(new MatchAllDocsQuery());  
                assertEquals(1, children.size());
                    .build();  
                    assertEquals("Top hits " + topHitsName + " should have 1 sub-phase", 1, children.size());
                List<ProfileResult> profileResults = fetchProfiler.getTree();
                    .build();
        }
                assertTrue("Missing profile for FetchSourcePhase", children.containsKey("FetchSourcePhase"));  
            String startTimeKey = timingKey + "_start_time";
            DocumentMapper documentMapper = mock(DocumentMapper.class);  
import org.opensearch.search.fetch.subphase.InnerHitsContext;
                assertTrue("Missing profile for FetchScorePhase", children.containsKey("FetchScorePhase"));  
                        .assertTimingPresent(FetchTimingType.LOAD_STORED_FIELDS)  
                ParsedQuery pq = new ParsedQuery(new MatchAllDocsQuery());
                // Check that FetchDocValuesPhase is present and has timing information
                    .assertTimingPresent(FetchTimingType.SET_NEXT_READER);  
        try (Directory dir = newDirectory()) {
                Map<String, ProfileResult> children = new HashMap<>();
import java.util.Set;
                        children.put(child.getQueryName(), child);
                when(context.scriptFields()).thenReturn(scriptFieldsContext);
            } else {
                    .build();  
                when(context.highlight()).thenReturn(null);  
                    String sourceJson = "{\"id\":" + i + ",\"content\":\"test content " + i + "\"}";
                when(context.trackScores()).thenReturn(true);
        private final IndexShard indexShard;  
            int[] docIds = indexDocumentsAndGetIds(dir, docs, 1);
            QueryShardContext queryShardContext = externalQueryShardContext != null  
    }  
        }  
                for (ProfileResult child : profile.getProfiledChildren()) {  
            this.enableDocValues = true;  
                ProfileResult profile = executeFetchPhaseAndGetProfile(context, subPhases);
                    .withParsedQuery(pq)
            ScoreDoc[] scoreDocs = new ScoreDoc[docIds.length];  
                assertEquals(1, children.size());
import org.apache.lucene.search.ScoreDoc;  
    }
    }
        }  
                }
        SearchContextBuilder withQueryShardContext(QueryShardContext qsc) {
                    new TimingAssertions(innerHitsFetchProfile.getTimeBreakdown()).assertBreakdownNotEmpty()
            this.indexShard = indexShard;
                Set<String> expectedTopHitsNames = Set.of("top_hits_agg1", "top_hits_agg2", "top_hits_agg3");
            assertThat("Timing should be geq 1: " + timingKey, breakdown.get(timingKey), greaterThanOrEqualTo(1L));
        SearchContextBuilder withSeqNoPrimaryTerm() {
            when(context.docIdsToLoadFrom()).thenReturn(0);
                FetchProfiler fetchProfiler = mainContext.getProfilers().getFetchProfiler();  
        super.setUp();  
            if (enableDocValues) {  
                topHitsContext1.docIdsToLoad(new int[] { docIds[0] }, 0, 1);  
                // Only include the HighlightPhase in the sub-phases list with the stub highlighter
                topHitsContext3.size(1);  
                    .withHighlight(highlight)
        private List<FieldAndFormat> docValueFields = Collections.emptyList();
        }
                QueryShardContext qsc = mock(QueryShardContext.class);
            }
    public void testFetchDocValuesPhaseProfiling() throws Exception {
                when(context.highlight()).thenReturn(highlightContext);
            when(documentMapper.typeText()).thenReturn(new Text("_doc"));
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
                true,
            String timingKey = timingType.toString();  
            if (enableStoredFields && !storedFieldNames.isEmpty()) {
            }
                    .withParsedQuery(pq)
    // Simple highlighter
            when(context.mapperService()).thenReturn(mapperService);  
                QueryShardContext qsc = mock(QueryShardContext.class);
            Profilers profilers = new Profilers(searcher, false);
                new TimingAssertions(children.get("MatchedQueriesPhase").getTimeBreakdown()).assertTimingPresent(FetchTimingType.PROCESS)
                    .withQueryShardContext(qsc)  
        try (Directory dir = newDirectory()) {
                    .withFetchFields(new FieldAndFormat("content", null))  // Enable fetch fields for the content field
                SortAndFormats sf = new SortAndFormats(sort, new DocValueFormat[] { DocValueFormat.RAW });
                    .withStoredFields("_source")
                    .assertTimingPresent(FetchTimingType.SET_NEXT_READER);  
    public void testRootTiming() throws Exception {
                for (ProfileResult child : profile.getProfiledChildren()) {
                    doc.add(new org.apache.lucene.document.StoredField("_source", sourceJson.getBytes(StandardCharsets.UTF_8)));  
                ? externalQueryShardContext
            this.breakdown = breakdown;
import org.opensearch.search.fetch.subphase.highlight.HighlightPhase;
        closeShards(indexShard);
            return this;  
            int[] docIds = indexDocumentsAndGetIds(dir, docs, 1);  
            this.enableScriptFields = true;
                // Only include the FetchDocValuesPhase in the sub-phases list  
    private ProfileResult executeFetchPhaseAndGetProfile(SearchContext context, List<FetchSubPhase> subPhases) throws IOException {
                when(context.innerHits()).thenReturn(innerHits);
                // Check that FetchFieldsPhase is present and has timing information  
        List<Document> build() {
        try (Directory dir = newDirectory()) {  
import java.util.Map;
        try (Directory dir = newDirectory()) {
        try (Directory dir = newDirectory()) {  
                    .withStoredFields("_source")
                        profileName.startsWith("fetch_top_hits_aggregation[")
                        .assertTimingPresent(FetchTimingType.CREATE_STORED_FIELDS_VISITOR)
import org.opensearch.search.fetch.subphase.highlight.SearchHighlightContext;
                for (ProfileResult topHitsFetchProfile : profileResults) {
                Set<String> actualTopHitsNames = new HashSet<>();  
                    }
            return this;
            for (int i = 0; i < docIds.length; i++) {
        private boolean enableFetchFields = false;
            // Profiling setup
                    for (ProfileResult child : innerHitsFetchProfile.getProfiledChildren()) {  
                        .assertTimingPresent(FetchTimingType.BUILD_SUB_PHASE_PROCESSORS)
                // Verify the profile results
        }
                QueryShardContext qsc = mock(QueryShardContext.class);
import org.opensearch.search.fetch.subphase.highlight.Highlighter;  
            this.enableVersion = true;  
                new TimingAssertions(children.get("SeqNoPrimaryTermPhase").getTimeBreakdown()).assertTimingPresent(FetchTimingType.PROCESS)
                }
                assertTrue(children.containsKey("FetchSourcePhase"));  
                    .withStoredFields("_source")
                scoreDocs[i] = new ScoreDoc(docIds[i], 1.0f);
            // Source loading configuration  
import org.opensearch.search.lookup.SourceLookup;  
                SearchContext context = new SearchContextBuilder(reader, docIds, indexShard).withSourceLoading()
                InnerHitsContext.InnerHitSubContext innerContext2 = new DummyInnerHitSubContext("inner2", context);  
import static org.hamcrest.Matchers.hasSize;  
                }
                Set<String> actualInnerHitNames = new HashSet<>();  
                    .withStoredFields("_source")
 * The OpenSearch Contributors require contributions made to  
    public void testInnerHitsPhaseProfiling() throws Exception {
            when(context.hasFetchSourceContext()).thenReturn(enableSourceLoading);
            int[] docIds = indexDocumentsAndGetIds(dir, docs, 1);
                    .withQueryShardContext(qsc)  
    // Minimal inner hit sub context  
                    children.put(child.getQueryName(), child);
                for (ProfileResult child : profile.getProfiledChildren()) {  
                    ProfileResult profile = profileResults.get(i);
                    .withDocValues(new FieldAndFormat("id", null))  // Enable doc values for the id field  
        try (Directory dir = newDirectory()) {  
                Map<String, ProfileResult> children = new HashMap<>();
import org.opensearch.search.fetch.subphase.ExplainPhase;  
                SearchContext context = new SearchContextBuilder(reader, docIds, indexShard).withSourceLoading()
        TestDocumentBuilder addDocuments(int count, boolean includeSource) {
            // Script fields configuration
        }  
        private final int[] docIds;
            SearchContext context = mock(SearchContext.class);
            }
                SearchContext context = new SearchContextBuilder(reader, docIds, indexShard).withSourceLoading()
        private boolean enableFetchScore = false;
                docIds[i] = topDocs.scoreDocs[i].doc;
                    .withExplain() // Only enable explain
                assertEquals("Should have 3 inner hits profiles", 3, innerHitsProfiles.size());
                    assertTrue("Profile name should end with ']'", profileName.endsWith("]"));
        }
                // Only include the FetchScorePhase in the sub-phases list
                    .withStoredFields("_source")  
            try (IndexReader reader = DirectoryReader.open(dir)) {
                // Verify the profile results  
import java.util.Arrays;
        @Override  
            List<Document> docs = new TestDocumentBuilder().addDocuments(1, true).build();
                // Create a search context with highlighting enabled  
        private SearchHighlightContext highlightContext = null;
import org.opensearch.search.internal.ContextIndexSearcher;
        SearchContext build() throws IOException {
            } else {
                    .withVersion() // Enable version
            } else {
                        children.put(child.getQueryName(), child);  
                }
import org.apache.lucene.document.TextField;
    public void testFetchSourcePhaseProfiling() throws Exception {
                new TimingAssertions(profile.getTimeBreakdown()).assertBreakdownNotEmpty()
                when(context.fetchFieldsContext()).thenReturn(new FetchFieldsContext(fetchFields));
/*  
                    for (ProfileResult child : topHitsFetchProfile.getProfiledChildren()) {
                    .build();  
            }
        }  
import org.opensearch.search.profile.Profilers;
            when(context.isCancelled()).thenReturn(false);
                        .assertTimingPresent(FetchTimingType.BUILD_SUB_PHASE_PROCESSORS)
                Map<String, ProfileResult> children = new HashMap<>();
import java.util.HashMap;
            this.externalQueryShardContext = qsc;  
                    .withQueryShardContext(qsc)  
                // Create a search context with version enabled  
        private List<String> storedFieldNames = Collections.emptyList();
                SubSearchContext topHitsContext3 = new SubSearchContext(mainContext);
            assertThat("Profile breakdown should not be empty", breakdown.size(), greaterThan(0));
import org.apache.lucene.index.IndexReader;
 *
                // Create a parsed query with named queries for the MatchedQueriesPhase to extract
            try (IndexReader reader = DirectoryReader.open(dir)) {
                // Check that FetchScorePhase is present and has timing information
                    .withStoredFields("_source")
            assertThat("Count should be non-negative: " + countKey, breakdown.get(countKey), greaterThanOrEqualTo(0L));
            FetchSearchResult fetchResult = new FetchSearchResult();
            try (IndexReader reader = DirectoryReader.open(dir)) {  
            }
            when(context.queryResult()).thenReturn(queryResult);  
import java.util.Collections;  
                    .withStoredFields("_source")  
                assertEquals(1, children.size());  
    }
                assertEquals(1, children.size());
                // Create a search context with only explain enabled  
            QuerySearchResult queryResult = new QuerySearchResult();
            }
                // Create multiple SubSearchContext instances to simulate top hits aggregations
                when(context.sort()).thenReturn(null);  
        try (Directory dir = newDirectory()) {
                assertFalse(children.containsKey("InnerHitsPhase"));
                List<FetchSubPhase> subPhases = Collections.singletonList(new FetchSourcePhase());
import org.opensearch.search.profile.fetch.FetchProfiler;  
            }
    }  
import org.opensearch.index.mapper.DocumentMapper;  
            when(context.version()).thenReturn(enableVersion);  
                // Only include the MatchedQueriesPhase in the sub-phases list
                SearchContext context = new SearchContextBuilder(reader, docIds, indexShard).withSourceLoading()
    @Override
    public void testTopHitsAggregationFetchProfiling() throws Exception {  
                    .assertTimingPresent(FetchTimingType.LOAD_STORED_FIELDS)
