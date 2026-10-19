import org.apache.lucene.search.BooleanQuery;  
            IndexSearcher.getDefaultQueryCachingPolicy(),
        context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));
                assertThat(query.getTimeBreakdown().get("avg_score_count"), greaterThan(0L));
                final Collector in = new AssertingEarlyTerminationFilterCollector(collector, size);
            });  
        assertProfileData(context, "ConstantScoreQuery", query -> {  
                }  
                long minScoreCount = query.getTimeBreakdown().get("min_score_count");
            if (collector.getName().contains("CollectorManager")) {
        scrollContext.maxScore = Float.NaN;  
                assertThat(collector.getProfiledChildren().get(0).getMinSliceTime(), greaterThan(0L));
            assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
            assertThat(collector.getTime(), greaterThan(0L));
            assertThat(collector.getTime(), greaterThan(0L));
        for (int i = 0; i < numDocs; ++i) {
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(7));
                assertThat(collector.getMaxSliceTime(), greaterThan(0L));
        assertEquals(TotalHits.Relation.EQUAL_TO, context.queryResult().topDocs().topDocs.totalHits.relation());
                assertThat(query.getProfiledChildren().get(1).getTimeBreakdown().get("create_weight_count"), equalTo(1L));
            assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));
import org.apache.lucene.search.Pruning;
                assertThat(children.get(1).getQueryName(), equalTo("TermQuery"));  
            for (int i = 0; i < searchSortAndFormat.sort.getSort().length; i++) {  
import org.opensearch.common.xcontent.json.JsonXContent;
        context.terminateAfter(7);
        Directory dir = newDirectory();  
    public static Collection<Object[]> concurrency() {
            if (executor != null) {
                    long maxScore = query.getProfiledChildren().get(1).getTimeBreakdown().get("max_score");  
                assertThat(maxScore, greaterThanOrEqualTo(1L));
            if (executor != null) {  
                    assertThat(collector.getProfiledChildren().get(0).getReduceTime(), greaterThan(0L));  
            if (collector.getName().contains("CollectorManager")) {
import org.opensearch.search.profile.ProfileShardResult;
            assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo(1L));
            Document doc = new Document();  
                assertThat(collector.getProfiledChildren(), hasSize(1));
            if (executor != null) {
            final LeafCollector in = super.getLeafCollector(context);  
            TestSearchContext context = new TestSearchContext(null, indexShard, newContextSearcher(reader, executor), scrollContext);
import java.util.Set;  
                    .add(new TermQuery(new Term("filter", "f1")), Occur.SHOULD)
                builder.endObject();  
        }
        context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));
            }
                    long avgScoreCount = query.getTimeBreakdown().get("avg_score_count");  
        assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo((long) numDocs));
        context.setSize(0);  
                assertThat(query.getTimeBreakdown().get("max_score_count"), greaterThanOrEqualTo(5L));
        throws IOException {  
 * SPDX-License-Identifier: Apache-2.0
                assertThat(avgScore, equalTo(minScore));  
        }, collector -> {
                assertThat(query.getProfiledChildren().get(1).getTimeBreakdown().get("score_count"), greaterThanOrEqualTo(0L));
        assertEquals(0, context.queryResult().topDocs().topDocs.totalHits.value());  
        assertFalse(Float.isNaN(context.queryResult().getMaxScore()));
            assertThat(collector.getProfiledChildren(), hasSize(1));
            }, collector -> {
            FieldDoc lastDoc = (FieldDoc) context.queryResult().topDocs().topDocs.scoreDocs[sizeMinus1];
                    assertThat(avgScore, greaterThanOrEqualTo(0L));  
                    long maxScoreCount = query.getTimeBreakdown().get("max_score_count");
                assertThat(maxScoreCount, equalTo(0L));
            assertThat(profileResult.getTime(), greaterThan(0L));  
                .build();
import org.apache.lucene.search.FilterCollector;
                assertThat(query.getTimeBreakdown().keySet(), not(empty()));
            doc.add(new StringField("foo", Integer.toString(i), Store.NO));
            w.addDocument(doc);  
            doc.add(new NumericDocValuesField("tiebreaker", i));
            assertThat(collector.getMinSliceTime(), greaterThan(0L));
                long avgScore = query.getTimeBreakdown().get("avg_score");  
            }  
import java.io.IOException;
import org.apache.lucene.queries.spans.SpanNearQuery;  
        }, collector -> {  
                long minScore = query.getTimeBreakdown().get("min_score");
        return Arrays.asList(
        context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));  
            w.addDocument(doc);
            doc.add(new StringField("foo", "bar", Store.NO));  
                assertThat(query.getTimeBreakdown().get("max_score"), greaterThan(0L));
                    assert collected <= size : "should not collect more than " + size + " doc per segment, got " + collected;  
            assertThat(query.getTimeBreakdown().keySet(), not(empty()));  
                assertThat(collector.getAvgSliceTime(), greaterThan(0L));
/*  
            if (trackTotalHits == -1) {
                assertThat(query.getTimeBreakdown().get("avg_score_count"), greaterThanOrEqualTo(5L));
import org.apache.lucene.search.IndexSearcher;  
        assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo((long) numDocs));
                assertThat(query.getTimeBreakdown().keySet(), not(empty()));  
            w.addDocument(doc);
                assertThat(collector.getReduceTime(), greaterThan(0L));
            }, collector -> {
import org.opensearch.index.mapper.TextSearchInfo;
                assertThat(query.getProfiledChildren().get(0).getTimeBreakdown().get("score_count"), equalTo(0L));
                assertThat(maxScore, greaterThanOrEqualTo(avgScore));
                assertThat(query.getTimeBreakdown().get("score"), greaterThan(0L));  
        when(indexShard.getSearchOperationListener()).thenReturn(searchOperationListener);  
    private final void assertProfileData(
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(1));
                assertThat(collector.getMinSliceTime(), greaterThan(0L));  
            }
import org.opensearch.search.collapse.CollapseBuilder;
                List<ProfileResult> children = query.getProfiledChildren().get(0).getProfiledChildren();  
                    .add(new TermQuery(new Term("filter", "f1")), Occur.SHOULD)
    }  
        dir.close();
            assertThat(collector.getReason(), equalTo("search_count"));
import org.opensearch.search.DocValueFormat;
                assertThat(query.getProfiledChildren().get(0).getTime(), greaterThan(0L));
            assertThat(fieldDoc.fields[0], anyOf(equalTo(1), equalTo(2)));
                if (collector.getName().contains("CollectorManager")) {  
                assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
        assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo((long) numDocs));
                    assertThat(collector.getReduceTime(), greaterThan(0L));
        for (int i = 0; i < numDocs; i++) {
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
                assertThat(query.getProfiledChildren().get(0).getTimeBreakdown().get("score"), equalTo(0L));  
        context.parsedQuery(new ParsedQuery(new MatchAllDocsQuery()));
            assertThat(query.getProfiledChildren().get(1).getQueryName(), equalTo("TermQuery"));
        {
                if (collector.getName().contains("CollectorManager")) {
        TestSearchContext context = new TestSearchContext(null, indexShard, newContextSearcher(reader, executor));  
                assertThat(collector.getProfiledChildren(), hasSize(1));  
        });
            }  
                logger.info(new String(((ByteArrayOutputStream) out).toByteArray(), StandardCharsets.UTF_8));  
        assertProfileData(context, collector -> {  
            }, (query) -> {
        context.sort(new SortAndFormats(sort, new DocValueFormat[] { DocValueFormat.RAW }));
                assertThat(collector.getProfiledChildren().get(0).getProfiledChildren().get(0).getAvgSliceTime(), greaterThan(0L));
        assertEquals(2, context.queryResult().topDocs().topDocs.scoreDocs.length);
                        true,
        IndexWriterConfig iwc = newIndexWriterConfig();
            }
        TestSearchContext context = new TestSearchContext(queryShardContext, indexShard, newContextSearcher(reader, executor));
import org.opensearch.common.settings.Settings;
            assertThat(query.getTimeBreakdown().get("score"), equalTo(0L));
            assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));
        assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), greaterThanOrEqualTo(6L));  
                }
        dir.close();
        Directory dir = newDirectory();  
import org.apache.lucene.search.FieldComparator;
            }  
                }
            assertThat(collector.getProfiledChildren(), empty());
            assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));  
                }  
                assertThat(collector.getAvgSliceTime(), greaterThan(0L));
                builder.flush();
                    assertThat(collector.getProfiledChildren().get(0).getReduceTime(), greaterThan(0L));
                assertThat(collector.getProfiledChildren().get(0).getMaxSliceTime(), greaterThan(0L));
                if (executor != null) {
        reader.close();
                assertThat(collector.getProfiledChildren().get(0).getReason(), equalTo("search_top_hits"));
        // Always end up with uneven buckets so collapsing is predictable
                assertThat(query.getTimeBreakdown().get("min_score_count"), equalTo(1L));
                assertThat(collector.getReduceTime(), greaterThan(0L));  
            assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));  
        // see: https://github.com/apache/lucene/pull/672
            QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);
            if (collector.getName().contains("CollectorManager")) {  
        assertEquals(2, context.queryResult().topDocs().topDocs.scoreDocs.length);
                assertThat(collector.getProfiledChildren().get(0).getSliceCount(), greaterThanOrEqualTo(1));
            QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);
 */  
        when(mockSourceMapper.enabled()).thenReturn(true);  
                assertThat(collector.getProfiledChildren().get(0).getMaxSliceTime(), greaterThan(0L));  
            );
                    new TermQuery(new Term("foo", "bar")),  
                    assertThat(query.getTimeBreakdown().get("min_score"), greaterThan(0L));
import static org.mockito.ArgumentMatchers.any;  
                assertThat(collector.getReason(), equalTo("search_terminate_after_count"));
            assertProfileData(context, "ConstantScoreQuery", query -> {
import org.opensearch.search.internal.ContextIndexSearcher;  
                );
                assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
            new ParsedQuery(
        // search sort is a prefix of the index sort  
                assertThat(minScore, equalTo(0L));  
        }, collector -> {  
            assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));  
            assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));
            assertThat(query.getTimeBreakdown().get("score"), greaterThan(0L));
            assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));  
                assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
                assertThat(query.getTimeBreakdown().get("avg_score_count"), greaterThanOrEqualTo(1L));
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);
                if (collector.getName().contains("CollectorManager")) {
                assertThat(query.getProfiledChildren().get(0).getQueryName(), equalTo("BooleanQuery"));
                long maxScore = query.getTimeBreakdown().get("max_score");
                assertThat(collector.getAvgSliceTime(), greaterThan(0L));
                assertThat(collector.getAvgSliceTime(), greaterThan(0L));
            assertThat(query.getProfiledChildren().get(0).getTimeBreakdown().get("score_count"), equalTo(0L));  
        IndexReader reader = DirectoryReader.open(dir);  
        IndexReader reader = DirectoryReader.open(dir);
    public void testTerminateAfterEarlyTermination() throws Exception {
                assertThat(query.getTimeBreakdown().keySet(), not(empty()));  
            @Override  
                if (cmp == 0) {
    public void testSourceFieldMatchQueryWithProfile() throws Exception {
            assertThat(collector.getMinSliceTime(), greaterThan(0L));
                assertThat(maxScore, greaterThanOrEqualTo(avgScore));
    public void testDisableTopScoreCollection() throws Exception {  
                assertThat(query.getTimeBreakdown().get("score"), greaterThan(0L));
            if (collector.getName().contains("CollectorManager")) {  
        }, collector -> {
        });
import org.apache.lucene.index.IndexWriterConfig;  
                assertThat(query.getTimeBreakdown().get("max_score_count"), greaterThanOrEqualTo(6L));
            assertThat(collector.getMaxSliceTime(), greaterThan(0L));  
        assertProfileData(context, Arrays.asList(query1), collector, false);
            }
            assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));
        w.close();
            searchContext  
            };
            assertThat(collector.getTime(), greaterThan(0L));  
        IndexWriterConfig iwc = newIndexWriterConfig().setIndexSort(indexSort);
import org.apache.lucene.tests.index.RandomIndexWriter;
        Directory dir = newDirectory();  
            assertTrue(context.queryResult().terminatedEarly());
                if (collector.getName().contains("CollectorManager")) {  
        w.close();
        context.parsedQuery(
        }  
                    assertThat(query.getTimeBreakdown().get("avg_score"), greaterThan(0L));
        context.trackScores(true);
            assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
                assertThat(collector.getProfiledChildren().get(0).getAvgSliceTime(), greaterThan(0L));
        }
                long minScoreCount = query.getTimeBreakdown().get("min_score_count");  
                assertThat(children.get(0).getTimeBreakdown().get("create_weight_count"), equalTo(1L));
                assertThat(query.getTimeBreakdown().get("score_count"), equalTo(0L));
                    long minScoreCount = query.getProfiledChildren().get(1).getTimeBreakdown().get("min_score_count");
        reader.close();
                assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
        context.sort(new SortAndFormats(new Sort(new SortField("other", SortField.Type.INT)), new DocValueFormat[] { DocValueFormat.RAW }));  
            assertThat(query.getProfiledChildren().get(0).getQueryName(), equalTo("TermQuery"));  
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(0));  
            assertThat(query.getProfiledChildren(), hasSize(2));
                    assertThat(maxScore, greaterThan(0L));
        }
        assertProfileData(context, "ConstantScoreQuery", query -> {
        QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);
            new Object[] { 5, new ConcurrentQueryPhaseSearcher() }
            }
        DocumentMapper mockDocumentMapper = mock(DocumentMapper.class);  
        final int numDocs = 2 * scaledRandomIntBetween(50, 450);
                assertThat(query.getTimeBreakdown().get("avg_score"), greaterThan(0L));  
    private void assertProfileData(SearchContext context, String type, Consumer<ProfileResult> query, Consumer<CollectorResult> collector)
            if (executor != null) {  
                        true,
                }  
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs[0], instanceOf(FieldDoc.class));
                assertThat(collector.getReduceTime(), greaterThan(0L));
                    assertThat(maxScoreCount, greaterThanOrEqualTo(avgScoreCount));
            assertThat(collector.getMaxSliceTime(), greaterThan(0L));  
            // IndexSearcher#rewrite optimizes by rewriting non-scoring queries to ConstantScoreQuery  
                assertThat(collector.getProfiledChildren().get(0).getSliceCount(), greaterThanOrEqualTo(1));  
            assertThat(collector.getMaxSliceTime(), greaterThan(0L));  
        });
                    assertThat(collector.getReduceTime(), greaterThan(0L));  
                assertThat(query.getTimeBreakdown().get("score_count"), equalTo(0L));  
                assertThat(query.getQueryName(), equalTo("TermQuery"));
            assertThat(query.getProfiledChildren().get(0).getTimeBreakdown().get("create_weight_count"), equalTo(1L));
                assertThat(query.getTimeBreakdown().get("score_count"), greaterThan(0L));
                assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));
import org.opensearch.lucene.queries.MinDocQuery;  
        QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);  
        assertEquals(context.queryResult().topDocs().topDocs.totalHits.relation(), TotalHits.Relation.EQUAL_TO);
        IndexWriterConfig iwc = newIndexWriterConfig().setIndexSort(sort);  
                assertThat(collector.getReduceTime(), greaterThan(0L));
            assertProfileData(context, "ConstantScoreQuery", query -> {
                assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));
                assertThat(collector.getProfiledChildren().get(0).getSliceCount(), greaterThanOrEqualTo(1));
            assertThat(collector.getTime(), greaterThan(0L));
            assertThat(query.getProfiledChildren().get(0).getTime(), greaterThan(0L));  
            });
                assertThat(collector.getReduceTime(), greaterThan(0L));
        assertThat(context.queryResult().getTotalHits().value(), equalTo((long) numDocs));
import java.util.ArrayList;
            });  
        when(leafSearchLookup.source()).thenReturn(new SourceLookup());
            assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));  
        context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));  
        w.close();  
                    assertThat(collector.getReduceTime(), greaterThan(0L));
        context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));
                assertThat(collector.getProfiledChildren().get(0).getMaxSliceTime(), greaterThan(0L));
            context.trackTotalHitsUpTo(trackTotalHits);
        }  
            if (randomBoolean()) {
                assertThat(query.getProfiledChildren().get(1).getTimeBreakdown().get("create_weight"), greaterThan(0L));
            });
            Document doc = new Document();
        QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);
            if (collector.getName().contains("CollectorManager")) {  
        // see: https://github.com/apache/lucene/pull/672
                assertThat(children.get(1).getTimeBreakdown().get("score_count"), equalTo(0L));
        SearchContext context,
            if (collector.getName().contains("CollectorManager")) {
                assertThat(query.getTimeBreakdown().get("score"), greaterThan(0L));
                assertThat(collector.getProfiledChildren(), hasSize(1));  
            assertThat(query.getTimeBreakdown().keySet(), not(empty()));
        QueryShardContext queryShardContext = mock(QueryShardContext.class);
                new BooleanQuery.Builder().add(new TermQuery(new Term("foo", "bar")), Occur.MUST)  
                assertThat(collector.getTime(), greaterThan(0L));
    }  
            }, collector -> {
            assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));
            assertTrue(context.queryResult().terminatedEarly());  
                }  
                }
        context.parsedQuery(new ParsedQuery(new MatchAllDocsQuery()));
        }, collector -> {  
        if (executor != null) {  
            w.addDocument(doc);
    @Override  
                assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));  
        dir.close();
                assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
            assertThat(collector.getMinSliceTime(), greaterThan(0L));
                    ++collected;
        assertThat(context.queryResult().topDocs().topDocs, instanceOf(CollapseTopFieldDocs.class));  
            assertThat(collector.getMaxSliceTime(), greaterThan(0L));  
import java.util.Collections;
        assertFalse(Float.isNaN(context.queryResult().getMaxScore()));  
            assertThat(collector.getMaxSliceTime(), greaterThan(0L));
        });  
                assertThat(minScore, greaterThan(0L));
            assertThat(query.getProfiledChildren(), hasSize(2));  
                break;
import java.util.function.Consumer;
                if (executor != null) {
            }  
import org.opensearch.index.query.ParsedQuery;  
                assertThat(collector.getReason(), equalTo("search_terminate_after_count"));  
                assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
import org.apache.lucene.analysis.standard.StandardAnalyzer;  
        return Settings.builder().put(super.threadPoolSettings()).put("thread_pool.search.min_queue_size", 10).build();  
            // see: https://github.com/apache/lucene/pull/672
                long minScore = query.getTimeBreakdown().get("min_score");  
        assertEquals(1, context.queryResult().topDocs().topDocs.scoreDocs.length);  
    }  
import java.util.Collection;  
        boolean debug
            int sizeMinus1 = context.queryResult().topDocs().topDocs.scoreDocs.length - 1;  
            doc.add(new NumericDocValuesField("rank", numDocs - i));
            if (randomBoolean()) {  
                if (collector.getName().contains("CollectorManager")) {
            assertThat(query.getTimeBreakdown().get("score"), equalTo(0L));
                assertThat(collector.getMaxSliceTime(), greaterThan(0L));  
                assertThat(query.getQueryName(), equalTo("MatchAllDocsQuery"));  
                assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));  
            context.parsedPostFilter(new ParsedQuery(new MinDocQuery(1)));
            assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
                    queryShardContext  
            });  
                    assertThat(collector.getProfiledChildren().get(0).getProfiledChildren().get(0).getReduceTime(), greaterThan(0L));
    ) throws IOException {  
            doc.add(new SortedDocValuesField("filter", newBytesRef("f1" + ((i > 0) ? " " + Integer.toString(i) : ""))));
        }  
            assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));  
                    assertThat(collector.getProfiledChildren().get(0).getReduceTime(), greaterThan(0L));
                if (collector.getName().contains("CollectorManager")) {  
                assertThat(collector.getReduceTime(), greaterThan(0L));  
import org.apache.lucene.search.MatchNoDocsQuery;  
            assertThat(collector.getMaxSliceTime(), greaterThan(0L));
            FieldDoc firstDoc = (FieldDoc) context.queryResult().topDocs().topDocs.scoreDocs[0];
            new Object[] { 0, QueryPhase.DEFAULT_QUERY_PHASE_SEARCHER },  
                }
            if (collector.getName().contains("CollectorManager")) {  
    }  
            }
            assertThat(collector.getAvgSliceTime(), greaterThan(0L));
    }
                assertThat(collector.getMinSliceTime(), greaterThan(0L));
                    assertThat(avgScore, greaterThanOrEqualTo(minScore));
                assertThat(minScore, greaterThan(0L));
                assertThat(query.getProfiledChildren().get(0).getTimeBreakdown().get("create_weight_count"), equalTo(1L));
import org.apache.lucene.store.Directory;
            assertThat(collector.getTime(), greaterThan(0L));
    private static ContextIndexSearcher newEarlyTerminationContextSearcher(IndexReader reader, int size, ExecutorService executor)
        ) {
        IndexShard indexShard = mock(IndexShard.class);  
        assertThat(context.queryResult().getTotalHits().value(), equalTo((long) numDocs));  
                assertThat(collector.getProfiledChildren().get(0).getAvgSliceTime(), greaterThan(0L));
                    assertThat(minScoreCount, greaterThanOrEqualTo(0L));  
            assertProfileData(context, "MatchAllDocsQuery", query -> {
    public void testCollapseQuerySearchResults() throws Exception {
        context.trackTotalHitsUpTo(5);
            }, (query) -> {
                long maxScoreCount = query.getTimeBreakdown().get("max_score_count");
                assertThat(collector.getReduceTime(), greaterThan(0L));
import java.util.concurrent.TimeUnit;  
                assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));
import org.opensearch.index.mapper.DocumentMapper;  
                assertThat(collector.getReduceTime(), greaterThan(0L));
    public void testMinScore() throws Exception {
            }, collector -> {
                assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));  
        }
            assertThat(query.getTimeBreakdown().get("score"), equalTo(0L));
    private void assertProfileData(
                    long avgScoreCount = query.getProfiledChildren().get(0).getTimeBreakdown().get("avg_score_count");
                assertThat(query.getTimeBreakdown().get("score_count"), equalTo(0L));  
            assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo(1L));  
            assertThat(collector.getProfiledChildren().get(0).getTime(), greaterThan(0L));  
        assertEquals(1, context.queryResult().topDocs().topDocs.scoreDocs.length);
        context.parsedQuery(new ParsedQuery(new MatchAllDocsQuery()));  
                doc.add(new TextField("title", "foo", Store.NO));
        for (int i = 0; i < 10; i++) {  
                assertThat(collector.getReason(), equalTo("search_terminate_after_count"));  
                assertThat(collector.getMinSliceTime(), greaterThan(0L));  
        Directory dir = newDirectory();
            } else {
            assertThat(collector.getProfiledChildren().get(0).getReason(), equalTo("search_count"));
            assertThat(query.getTimeBreakdown().get("score_count"), equalTo(0L));  
        TestSearchContext context = new TestSearchContext(null, indexShard, newContextSearcher(reader, executor));  
            assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));
            doc.add(new StringField("filter", "f1" + ((i > 0) ? " " + Integer.toString(i) : ""), Store.NO));
            }, (query) -> {
        scrollContext.totalHits = null;
            });
        // see: https://github.com/apache/lucene/pull/672  
        assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo((long) numDocs));
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);  
            context.setSize(0);
    ) throws IOException {  
                assertThat(query.getProfiledChildren().get(0).getTimeBreakdown().get("score_count"), equalTo(0L));
        assertNull(context.queryResult().terminatedEarly());
                assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));  
    }
                    i,  
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);
            try (final XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint()) {  
    }  
                assertThat(query.getProfiledChildren().get(0).getTimeBreakdown().get("create_weight_count"), equalTo(1L));
import org.opensearch.search.sort.SortAndFormats;
        final int numDocs = scaledRandomIntBetween(600, 900);  
            context.setSearcher(newEarlyTerminationContextSearcher(reader, 10, executor));  
                assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));  
        context.sort(new SortAndFormats(sort, new DocValueFormat[] { DocValueFormat.RAW }));  
    public void testMinScoreDisablesCountOptimization() throws Exception {  
import org.apache.lucene.queries.spans.SpanTermQuery;
        reader.close();
        int size = randomIntBetween(2, 5);  
                    assertThat(avgScore, greaterThanOrEqualTo(0L));
                assertThat(query.getProfiledChildren().get(1).getTimeBreakdown().get("create_weight_count"), equalTo(1L));  
        TestSearchContext context = new TestSearchContext(null, indexShard, newContextSearcher(reader, executor));
        final int numDocs = scaledRandomIntBetween(600, 900);  
        Consumer<CollectorResult> collector,
            }  
                    assertThat(avgScoreCount, greaterThanOrEqualTo(minScoreCount));
                assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
                assertThat(collector.getProfiledChildren(), hasSize(1));
            assertThat(query.getProfiledChildren().get(0).getTimeBreakdown().get("create_weight"), greaterThan(0L));
            assertThat(collector.getProfiledChildren(), hasSize(1));
        IndexWriterConfig iwc = newIndexWriterConfig().setIndexSort(sort);
            assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
            assertThat(query.getTimeBreakdown().get("score"), equalTo(0L));
        reader.close();
                assertThat(query.getTimeBreakdown().get("score_count"), equalTo(0L));
        }  
            if (collector.getName().contains("CollectorManager")) {  
        IndexReader reader = DirectoryReader.open(dir);
            assertThat(query.getProfiledChildren().get(0).getTimeBreakdown().get("create_weight_count"), equalTo(1L));
            assertThat(query.getProfiledChildren(), empty());
 *
        dir.close();
            ScrollContext scrollContext = new ScrollContext();  
            assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo((long) numDocs));  
            scrollContext.lastEmittedDoc = null;  
                assertThat(collector.getProfiledChildren().get(0).getReason(), equalTo("search_count"));
        }, collector -> {  
                assertThat(collector.getProfiledChildren().get(0).getProfiledChildren().get(0).getSliceCount(), greaterThanOrEqualTo(1));  
        w.close();
            assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));  
                    assertThat(collector.getProfiledChildren().get(0).getReduceTime(), greaterThan(0L));
        Document doc = new Document();
                assertThat(query.getTimeBreakdown().keySet(), not(empty()));
                assertThat(collector.getReason(), equalTo("search_post_filter"));
            context.setSize(1);
                    assertThat(avgScore, greaterThanOrEqualTo(minScore));
        assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(3));
                assertThat(collector.getProfiledChildren().get(0).getTime(), greaterThan(0L));  
            assertThat(collector.getProfiledChildren().get(0).getTime(), greaterThan(0L));
        for (int trackTotalHits : new int[] { -1, 3, 75, 100 }) {
                assertThat(query.getQueryName(), equalTo("MinDocQuery"));  
            assertProfileData(context, "ConstantScoreQuery", query -> {
                assertThat(query.getTimeBreakdown().keySet(), not(empty()));
            assertThat(collector.getTime(), greaterThan(0L));
                new SourceFieldMatchQuery(
import org.opensearch.index.shard.IndexShard;  
        QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);  
                if (collector.getName().contains("CollectorManager")) {  
            }
                assertThat(collector.getReason(), equalTo("search_terminate_after_count"));
        w.close();
            assertNull(context.queryResult().terminatedEarly());
                long avgScoreCount = query.getTimeBreakdown().get("avg_score_count");  
                        Collections.emptyMap()
                    assertThat(collector.getProfiledChildren().get(0).getReduceTime(), greaterThan(0L));  
                }
            assertThat(collector.getProfiledChildren(), empty());
        searchSortAndFormats.add(new SortAndFormats(indexSort, new DocValueFormat[] { DocValueFormat.RAW, DocValueFormat.RAW }));
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);  
            assertThat(query.getProfiledChildren().get(1).getQueryName(), equalTo("TermQuery"));  
                        TextSearchInfo.WHITESPACE_MATCH_ONLY,  
            assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
            assertThat(collector.getReason(), equalTo("search_count"));
                }
        context.parsedQuery(new ParsedQuery(new MatchAllDocsQuery()));
        Directory dir = newDirectory();  
            scrollContext.maxScore = Float.NaN;
            assertThat(collector.getAvgSliceTime(), greaterThan(0L));  
                long minScore = query.getTimeBreakdown().get("min_score");
        assertThat(queryProfileShardResult.getQueryResults(), hasSize(queries.size()));
                assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));  
                assertThat(collector.getProfiledChildren(), empty());
    }
                    long avgScore = query.getTimeBreakdown().get("avg_score");  
        });
            assertThat(query.getProfiledChildren(), hasSize(2));
                int collected;
                    assertThat(collector.getProfiledChildren().get(0).getReduceTime(), greaterThan(0L));
import org.opensearch.search.profile.query.QueryProfileShardResult;
                assertThat(collector.getProfiledChildren().get(0).getMinSliceTime(), greaterThan(0L));  
            assertThat(collector.getReason(), equalTo("search_top_hits"));  
    public Settings threadPoolSettings() {
            assertThat(query.getTimeBreakdown().keySet(), not(empty()));  
        TestSearchContext context = new TestSearchContext(null, indexShard, newContextSearcher(reader, executor));
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(1));  
                    new MatchOnlyTextFieldMapper.MatchOnlyTextFieldType(
            }  
                assertThat(collector.getMinSliceTime(), greaterThan(0L));  
        final Sort sort = new Sort(new SortField("rank", SortField.Type.INT));
            // see: https://github.com/apache/lucene/pull/672  
            scrollContext.totalHits = null;
                assertThat(avgScore, greaterThan(0L));  
                assertThat(query.getTimeBreakdown().keySet(), not(empty()));  
        {
            assertThat(query.getTimeBreakdown().get("score"), greaterThanOrEqualTo(1L));
            assertThat(collector.getReason(), equalTo("search_top_hits"));
            doc.add(new NumericDocValuesField("rank", random().nextInt()));  
        super.setUp();
            assertThat(collector.getProfiledChildren().get(0).getMinSliceTime(), greaterThan(0L));  
            assertThat(query.getTimeBreakdown().get("score"), greaterThan(0L));
                }  
            assertThat(collector.getTime(), greaterThan(0L));  
        }, collector -> {
            }
        assertThat(context.queryResult().topDocs().topDocs.scoreDocs[0], instanceOf(FieldDoc.class));
                assertThat(collector.getAvgSliceTime(), greaterThan(0L));  
import org.opensearch.index.shard.IndexShardTestCase;
            assertThat(collector.getReason(), equalTo("search_top_hits"));
            doc.add(new StringField("filter", "f1", Store.NO));  
        });
            doc.clear();
                assertThat(collector.getProfiledChildren().get(0).getAvgSliceTime(), greaterThan(0L));  
                assertThat(avgScoreCount, greaterThanOrEqualTo(minScoreCount));
        // see: https://github.com/apache/lucene/pull/672
                    .build()
            assertThat(query.getTimeBreakdown().keySet(), not(empty()));  
        collector.accept(queryProfileShardResult.getCollectorResult());
                assertThat(collector.getProfiledChildren().get(0).getReason(), equalTo("search_top_hits"));  
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs[0], instanceOf(FieldDoc.class));  
                assertThat(maxScore, greaterThan(0L));
                assertThat(query.getProfiledChildren().get(0).getTimeBreakdown().get("create_weight"), greaterThan(0L));  
                doc.add(new StringField("foo", "baz", Store.NO));
                assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));
                assertThat(query.getTimeBreakdown().get("score"), equalTo(0L));  
            reader,
            )  
        @Override
                assertThat(query.getTimeBreakdown().get("max_score_count"), equalTo(1L));  
 * The OpenSearch Contributors require contributions made to  
                FieldComparator<Object> comparator = (FieldComparator<Object>) searchSortAndFormat.sort.getSort()[i].getComparator(
        throws IOException {  
            assertThat(collector.getProfiledChildren().get(0).getAvgSliceTime(), greaterThan(0L));
import org.apache.lucene.document.Document;
                assertThat(avgScoreCount, greaterThan(0L));
            assertThat(query.getTimeBreakdown().keySet(), not(empty()));
            assertThat(collector.getAvgSliceTime(), greaterThan(0L));
            }
            context.setSize(1);
            assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
        closeShards(indexShard);  
            if (collector.getName().contains("CollectorManager")) {  
            assertThat(collector.getAvgSliceTime(), greaterThan(0L));
        when(queryShardContext.lookup()).thenReturn(searchLookup);  
            assertThat(collector.getReason(), equalTo("search_post_filter"));
        QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);
        );
                if (collector.getName().contains("CollectorManager")) {
                assertThat(query.getTimeBreakdown().get("avg_score_count"), greaterThanOrEqualTo(1L));  
        SourceFieldMapper mockSourceMapper = mock(SourceFieldMapper.class);
            assertTrue(context.queryResult().terminatedEarly());
            assertProfileData(context, collector -> {  
                    assertThat(maxScoreCount, greaterThanOrEqualTo(avgScoreCount));
import org.apache.lucene.document.NumericDocValuesField;  
            }
            assertThat(collector.getMaxSliceTime(), greaterThan(0L));
        return new ContextIndexSearcher(
            QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);
                }
                assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));  
                assertThat(collector.getProfiledChildren().get(0).getMinSliceTime(), greaterThan(0L));
                assertThat(query.getProfiledChildren().get(1).getTime(), greaterThan(0L));
            if (collector.getName().contains("CollectorManager")) {
                    assertThat(query.getTimeBreakdown().get("min_score"), greaterThan(0L));
                assertThat(query.getTimeBreakdown().get("score_count"), equalTo(0L));
        indexShard = newShard(true);  
            }
                assertThat(collector.getProfiledChildren().get(0).getTime(), greaterThan(0L));  
        reader.close();
                assertThat(minScoreCount, equalTo(0L));
            assertThat(query.getProfiledChildren(), empty());
            assertThat(collector.getAvgSliceTime(), greaterThan(0L));  
            assertThat(collector.getProfiledChildren(), empty());
import java.io.OutputStream;
        for (int i = 0; i < numDocs; ++i) {
        final int numDocs = scaledRandomIntBetween(600, 900);
        Directory dir = newDirectory();
        {
            QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);  
            assertThat(collector.getAvgSliceTime(), greaterThan(0L));  
            assertThat(collector.getMaxSliceTime(), greaterThan(0L));  
                    assertThat(avgScore, greaterThanOrEqualTo(0L));
                assertThat(collector.getReason(), equalTo("search_terminate_after_count"));
                assertThat(maxScore, greaterThan(0L));
            }  
        context.setSize(1);  
            });
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);
            }
            assertThat(collector.getMinSliceTime(), greaterThan(0L));  
                assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
                assertThat(query.getProfiledChildren(), hasSize(1));
    private void assertProfileData(SearchContext context, Consumer<CollectorResult> collector, Consumer<ProfileResult> query1)
            assertThat(collector.getProfiledChildren().get(0).getTime(), greaterThan(0L));  
import org.opensearch.index.mapper.NumberFieldMapper.NumberType;  
            assertThat(query.getTimeBreakdown().keySet(), not(empty()));
            assertThat(collector.getMinSliceTime(), greaterThan(0L));
        QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);  
import java.util.Arrays;
        assertEquals(0, context.queryResult().topDocs().topDocs.totalHits.value());
                assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
                assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo(0L));  
        w.close();
            this.size = size;
            assertThat(profileResult.getQueryName(), equalTo(type));
        when(queryShardContext.documentMapper(any())).thenReturn(mockDocumentMapper);
            assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
            .addClause(new SpanTermQuery(new Term("title", "bar")))  
            assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));
            context.setSize(1);
                assertThat(query.getProfiledChildren(), hasSize(1));
        });  
        );
        };
        context.trackScores(true);  
                assertThat(collector.getTime(), greaterThan(0L));
            QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);
import org.opensearch.threadpool.ThreadPool;
                    ),
                assertThat(maxScore, equalTo(avgScore));
            assertThat(collector.getProfiledChildren(), empty());
            if (collector.getName().contains("CollectorManager")) {  
            assertThat(collector.getTime(), greaterThan(0L));
    }
import org.apache.lucene.search.grouping.CollapseTopFieldDocs;  
        Document doc = new Document();
                assertThat(collector.getMaxSliceTime(), greaterThan(0L));
        }
                assertThat(query.getProfiledChildren(), hasSize(2));  
                assertThat(collector.getProfiledChildren().get(0).getSliceCount(), greaterThanOrEqualTo(1));
import java.util.List;
        }, collector -> {  
                long avgScoreCount = query.getTimeBreakdown().get("avg_score_count");
            assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));
            assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));
            assertThat(query.getTimeBreakdown().get("score_count"), greaterThan(0L));  
    }  
            assertThat(query.getTimeBreakdown().get("score"), greaterThan(0L));
                }
        TestSearchContext context = new TestSearchContext(null, indexShard, newEarlyTerminationContextSearcher(reader, 0, executor));
                assertThat(collector.getTime(), greaterThan(0L));
            assertThat(context.terminateAfter(), equalTo(0));
            assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo(1L));
        context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));
            assertThat(collector.getReason(), equalTo("search_top_hits"));
        assertThat(context.queryResult().topDocs().topDocs.scoreDocs[0].doc, greaterThanOrEqualTo(size));
        final int numDocs = 2 * scaledRandomIntBetween(600, 900) - 1;  
        context.collapse(new CollapseBuilder("user").build(context.getQueryShardContext()));
                    assertThat(minScoreCount, greaterThanOrEqualTo(0L));
        assertProfileData(context, "TermQuery", query -> {
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);
        dir.close();
            assertThat(query.getProfiledChildren().get(0).getTimeBreakdown().get("create_weight"), greaterThan(0L));
                assertThat(collector.getReduceTime(), greaterThan(0L));  
package org.opensearch.search.query;
                assertThat(query.getTimeBreakdown().get("score_count"), equalTo(1L));  
            IndexSearcher.getDefaultQueryCache(),
        // IndexSearcher#rewrite optimizes by rewriting non-scoring queries to ConstantScoreQuery
    }  
                }
                doc.add(new TextField("title", "foo bar", Store.NO));  
            new ParsedQuery(
            assertThat(collector.getMinSliceTime(), greaterThan(0L));
                assertThat(collector.getReduceTime(), greaterThan(0L));
                // see: https://github.com/apache/lucene/pull/672  
            assertThat(collector.getAvgSliceTime(), greaterThan(0L));
        assertThat(context.getProfilers(), not(nullValue()));
                public void collect(int doc) throws IOException {
        w.addDocument(doc);  
            assertThat(collector.getTime(), greaterThan(0L));
                    assertThat(minScore, greaterThanOrEqualTo(0L));
                assertThat(maxScore, greaterThanOrEqualTo(avgScore));
            assertThat(collector.getProfiledChildren().get(0).getMaxSliceTime(), greaterThan(0L));
            QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);  
            IndexSearcher.getDefaultSimilarity(),
                assertThat(collector.getProfiledChildren().get(0).getAvgSliceTime(), greaterThan(0L));  
        // IndexSearcher#rewrite optimizes by rewriting non-scoring queries to ConstantScoreQuery
        reader.close();
        context.sort(new SortAndFormats(sort, new DocValueFormat[] { DocValueFormat.RAW }));
                assertThat(collector.getReason(), equalTo("search_top_hits"));  
                assertThat(children.get(1).getTimeBreakdown().get("score"), equalTo(0L));
        context.sort(new SortAndFormats(sort, new DocValueFormat[] { DocValueFormat.RAW }));
                assertThat(collector.getProfiledChildren().get(0).getAvgSliceTime(), greaterThan(0L));  
            }, collector -> {  
                    assertThat(collector.getProfiledChildren().get(0).getReduceTime(), greaterThan(0L));
            context.parsedPostFilter(new ParsedQuery(new TermQuery(new Term("foo", Integer.toString(i)))));  
                assertThat(collector.getProfiledChildren().get(0).getProfiledChildren().get(0).getMaxSliceTime(), greaterThan(0L));  
        }, collector -> {
                final OutputStream out = builder.getOutputStream();  
        Consumer<CollectorResult> collector,  
                assertThat(collector.getProfiledChildren().get(0).getProfiledChildren().get(0).getReason(), equalTo("search_top_hits"));
            assertThat(collector.getTime(), greaterThan(0L));
                }
        QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);
                    assertThat(query.getTimeBreakdown().get("avg_score"), greaterThan(0L));
        reader.close();
        TestSearchContext context = new TestSearchContext(null, indexShard, newContextSearcher(reader, executor), scrollContext);
                    assertThat(avgScoreCount, greaterThanOrEqualTo(0L));  
            assertThat(collector.getProfiledChildren(), hasSize(1));
                assertThat(maxScoreCount, greaterThanOrEqualTo(avgScoreCount));  
                assertThat(collector.getReason(), equalTo("search_terminate_after_count"));
            // see: https://github.com/apache/lucene/pull/672
                assertThat(avgScoreCount, greaterThan(0L));
    }
                    assertThat(maxScoreCount, greaterThan(0L));  
                assertThat(collector.getAvgSliceTime(), greaterThan(0L));
                assertThat(collector.getReduceTime(), greaterThan(0L));
                assertThat(collector.getProfiledChildren().get(0).getMinSliceTime(), greaterThan(0L));
                assertThat(query.getTimeBreakdown().keySet(), not(empty()));
    public void testPostFilterDisablesCountOptimization() throws Exception {  
                assertThat(collector.getProfiledChildren().get(0).getReason(), equalTo("search_top_hits"));
            assertThat(query.getTimeBreakdown().keySet(), not(empty()));
                assertThat(query.getQueryName(), equalTo("ConstantScoreQuery"));  
            assertThat(collector.getAvgSliceTime(), greaterThan(0L));
            assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
            if (collector.getName().contains("CollectorManager")) {
import org.opensearch.search.profile.ProfileResult;  
            // IndexSearcher#rewrite optimizes by rewriting non-scoring queries to ConstantScoreQuery  
        private final int size;  
                    assertThat(collector.getReduceTime(), greaterThan(0L));  
import org.opensearch.index.shard.SearchOperationListener;
                assertThat(collector.getReason(), equalTo("search_post_filter"));
    private final ExecutorService executor;  
            }, collector -> {
        IndexWriterConfig iwc = newIndexWriterConfig().setIndexSort(sort);  
        assertEquals(numDocs / 2, context.queryResult().topDocs().topDocs.totalHits.value());
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs[0], instanceOf(FieldDoc.class));
            assertThat(collector.getProfiledChildren().get(0).getSliceCount(), greaterThanOrEqualTo(1));
            assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));  
        }, (query) -> {  
                assertThat(avgScore, greaterThanOrEqualTo(minScore));
                if (collector.getName().contains("CollectorManager")) {
                assertThat(cmp, equalTo(1));
 * this file be licensed under the Apache-2.0 license or a
        context.setSize(1);  
            assertThat(query.getProfiledChildren().get(1).getTime(), greaterThan(0L));
            assertProfileData(context, "ConstantScoreQuery", query -> {
            assertThat(collector.getMaxSliceTime(), greaterThan(0L));  
            assertThat(query.getTimeBreakdown().get("score"), equalTo(0L));
            } else {
            doc.add(new StringField("foo", "bar", Store.NO));  
                assertThat(query.getTimeBreakdown().get("score"), equalTo(0L));
            assertTrue(context.queryResult().terminatedEarly());
            w.addDocument(doc);
        context.setSize(1);
        }
import org.opensearch.core.index.Index;  
        TopDocsCollectorContext topDocsContext = TopDocsCollectorContext.createTopDocsCollectorContext(context, false);  
            QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);  
                assertThat(collector.getProfiledChildren().get(0).getMinSliceTime(), greaterThan(0L));  
            if (collector.getName().contains("CollectorManager")) {  
        dir.close();
            if (collector.getName().contains("CollectorManager")) {
                    assertThat(maxScore, greaterThanOrEqualTo(avgScore));
            assertEquals(1, context.queryResult().topDocs().topDocs.totalHits.value());
        context.setSearcher(newContextSearcher(reader, executor));
                assertThat(query.getProfiledChildren().get(0).getTimeBreakdown().get("score"), equalTo(0L));
        Query q = new SpanNearQuery.Builder("title", true).addClause(new SpanTermQuery(new Term("title", "foo")))
            }, collector -> {
import java.util.concurrent.ExecutorService;
        };  
            assertThat(query.getProfiledChildren(), empty());  
            assertProfileData(context, collector -> {
                    assertThat(maxScoreCount, greaterThanOrEqualTo(0L));
            // IndexSearcher#rewrite optimizes by rewriting non-scoring queries to ConstantScoreQuery
            assertThat(query.getTimeBreakdown().get("score_count"), equalTo(0L));  
                }  
        Consumer<ProfileResult> query2
        TestSearchContext context = new TestSearchContext(queryShardContext, indexShard, newContextSearcher(reader, executor));  
                assertThat(collector.getProfiledChildren().get(0).getTime(), greaterThan(0L));  
                assertThat(collector.getTime(), greaterThan(0L));
                assertThat(collector.getMaxSliceTime(), greaterThan(0L));  
            assertThat(query.getTimeBreakdown().get("score_count"), equalTo(1L));
import org.opensearch.search.profile.SearchProfileShardResults;
                assertThat(query.getTimeBreakdown().get("score_count"), greaterThanOrEqualTo(7L));
        for (int i = 0; i < numDocs; i++) {  
                assertThat(query.getTimeBreakdown().get("max_score_count"), greaterThanOrEqualTo(4L));  
            // IndexSearcher#rewrite optimizes by rewriting non-scoring queries to ConstantScoreQuery
            assertTrue(context.queryResult().terminatedEarly());
import org.opensearch.action.search.SearchShardTask;  
            assertThat(collector.getMinSliceTime(), greaterThan(0L));
        w.addDocument(doc);  
        TestSearchContext context = new TestSearchContext(null, indexShard, newContextSearcher(reader, executor));
                    assertThat(maxScoreCount, greaterThanOrEqualTo(0L));
            assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));  
                assertThat(query.getTimeBreakdown().keySet(), not(empty()));  
        FieldDoc fieldDoc = (FieldDoc) context.queryResult().topDocs().topDocs.scoreDocs[0];
            Document doc = new Document();
        final Sort sort = new Sort(new SortField("rank", SortField.Type.INT));
        }
                    long minScoreCount = query.getTimeBreakdown().get("min_score_count");
    }
                }
        reader.close();
        dir.close();  
            )
                assertThat(collector.getAvgSliceTime(), greaterThan(0L));
import static org.hamcrest.Matchers.greaterThan;
                assertThat(minScore, greaterThanOrEqualTo(1L));
                assertThat(collector.getProfiledChildren().get(0).getTime(), greaterThan(0L));  
                assertThat(query.getTimeBreakdown().get("score"), equalTo(0L));
                assertThat(collector.getTime(), greaterThan(0L));  
                assertThat(collector.getProfiledChildren().get(0).getTime(), greaterThan(0L));
        // IndexSearcher#rewrite optimizes by rewriting non-scoring queries to ConstantScoreQuery
                int cmp = comparator.compareValues(firstDoc.fields[i], lastDoc.fields[i]);  
            assertThat(query.getProfiledChildren().get(0).getTimeBreakdown().get("create_weight_count"), equalTo(1L));
            assertThat(collector.getProfiledChildren().get(0).getAvgSliceTime(), greaterThan(0L));  
            assertThat(query.getProfiledChildren().get(1).getTimeBreakdown().get("create_weight"), greaterThan(0L));  
import org.apache.lucene.document.SortedDocValuesField;
                }  
            assertThat(query.getTimeBreakdown().keySet(), not(empty()));
                assertThat(collector.getProfiledChildren(), hasSize(1));
                assertThat(query.getTimeBreakdown().keySet(), not(empty()));
                doc.add(new StringField("foo", "baz", Store.NO));
            Document doc = new Document();
                assertThat(collector.getReason(), equalTo("search_top_hits"));  
                assertThat(query.getTimeBreakdown().get("score_count"), equalTo(0L));
                    assertThat(collector.getReduceTime(), greaterThan(0L));
                assertThat(children.get(0).getTimeBreakdown().get("score_count"), equalTo(0L));
        IndexWriterConfig iwc = newIndexWriterConfig().setIndexSort(sort);  
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);
                assertThat(collector.getMinSliceTime(), greaterThan(0L));
        QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);
            assertThat(collector.getAvgSliceTime(), greaterThan(0L));
                assertThat(collector.getProfiledChildren().get(0).getTime(), greaterThan(0L));
        IndexShard indexShard = mock(IndexShard.class);
            assertThat(collector.getAvgSliceTime(), greaterThan(0L));
                assertThat(avgScore, greaterThanOrEqualTo(1L));  
            assertThat(query.getProfiledChildren().get(1).getTime(), greaterThan(0L));
                assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));
            assertThat(query.getTimeBreakdown().keySet(), not(empty()));  
                    assertThat(avgScoreCount, greaterThanOrEqualTo(minScoreCount));  
                    long avgScore = query.getProfiledChildren().get(0).getTimeBreakdown().get("avg_score");
            assertThat(collector.getProfiledChildren(), hasSize(0));
            if (executor != null) {  
        });
                assertThat(collector.getProfiledChildren(), empty());  
import static org.hamcrest.Matchers.hasSize;
        SearchOperationListener searchOperationListener = new SearchOperationListener() {
            }  
            if (executor != null) {
        this.executor = (concurrency > 0) ? Executors.newFixedThreadPool(concurrency) : null;  
            assertThat(fieldDoc.fields[0], anyOf(equalTo(1), equalTo(2)));
                assertThat(collector.getReason(), equalTo("search_top_hits"));  
                assertThat(collector.getAvgSliceTime(), greaterThan(0L));
            assertThat(query.getProfiledChildren().get(1).getTimeBreakdown().get("create_weight_count"), equalTo(1L));
            assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));  
            context.sort(searchSortAndFormat);
    }  
        }
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);
                assertThat(collector.getProfiledChildren().get(0).getProfiledChildren(), hasSize(1));  
                }
                    long avgScoreCount = query.getProfiledChildren().get(1).getTimeBreakdown().get("avg_score_count");
        });  
            }  
            assertThat(query.getTimeBreakdown().get("score"), equalTo(0L));
                assertThat(collector.getTime(), greaterThan(0L));
                assertThat(children, hasSize(2));
        dir.close();  
            assertThat(collector.getMinSliceTime(), greaterThan(0L));
                assertThat(collector.getProfiledChildren().get(0).getMaxSliceTime(), greaterThan(0L));  
        for (int i = 0; i < numDocs; ++i) {
                }  
                }  
        dir.close();  
            context.parsedQuery(new ParsedQuery(bq));
            assertProfileData(context, "MatchAllDocsQuery", query -> {
            if (randomBoolean()) {
            BooleanQuery bq = new BooleanQuery.Builder().add(new TermQuery(new Term("foo", "bar")), Occur.SHOULD)  
            assertThat(collector.getProfiledChildren(), empty());  
            assertThat(query.getTimeBreakdown().get("score_count"), equalTo(0L));  
            assertNull(context.queryResult().terminatedEarly());  
import org.opensearch.core.xcontent.XContentBuilder;
                assertThat(collector.getProfiledChildren(), empty());  
        });
import org.apache.lucene.search.TotalHits;
        }, collector -> {  
                assertThat(query.getTimeBreakdown().get("min_score"), greaterThan(0L));
            assertThat(context.queryResult().getTotalHits().value(), equalTo((long) numDocs));
    }
        final Sort indexSort = new Sort(new SortField("rank", SortField.Type.INT), new SortField("tiebreaker", SortField.Type.INT));  
            reader,  
import org.opensearch.index.mapper.NumberFieldMapper.NumberFieldType;
                assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));
        List<Consumer<ProfileResult>> queries,  
            assertThat(collector.getProfiledChildren(), empty());
        );
            assertThat(collector.getAvgSliceTime(), greaterThan(0L));
            IndexSearcher.getDefaultSimilarity(),
        assertEquals(1, context.queryResult().topDocs().topDocs.totalHits.value());
import java.io.ByteArrayOutputStream;  
                assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));  
        assertEquals(1, context.queryResult().topDocs().topDocs.totalHits.value());  
                // see: https://github.com/apache/lucene/pull/672
        });
        ScrollContext scrollContext = new ScrollContext();
        w.close();
import org.opensearch.test.TestSearchContext;  
        AssertingEarlyTerminationFilterCollector(Collector in, int size) {
        assertProfileData(context, "SpanNearQuery", query -> {  
        assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(3));
                    assertThat(minScore, greaterThanOrEqualTo(0L));  
                super.search(partitions, weight, in);  
                assertThat(collector.getProfiledChildren().get(0).getSliceCount(), greaterThanOrEqualTo(1));  
            QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);
import org.apache.lucene.search.FieldDoc;  
        }
            }
                assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));  
        }
            assertThat(query.getProfiledChildren().get(1).getTimeBreakdown().get("create_weight_count"), equalTo(1L));
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);  
        QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);  
    }  
                long minScore = query.getTimeBreakdown().get("min_score");
        reader.close();
                    long maxScoreCount = query.getProfiledChildren().get(1).getTimeBreakdown().get("max_score_count");  
            }
                assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
                assertThat(query.getTimeBreakdown().get("score"), equalTo(0L));
            if (collector.getName().contains("CollectorManager")) {
            context.setSize(0);
import static org.hamcrest.Matchers.anyOf;
import org.apache.lucene.search.Sort;
import org.opensearch.index.query.QueryShardContext;
                    assertThat(query.getTimeBreakdown().get("min_score_count"), greaterThan(0L));
                assertThat(query.getProfiledChildren().get(1).getTime(), greaterThan(0L));  
        final Sort sort = new Sort(new SortField("rank", SortField.Type.INT));
            doc.add(new NumericDocValuesField("rank", numDocs - i));  
            context.parsedQuery(new ParsedQuery(bq));  
                assertThat(query.getTimeBreakdown().get("score_count"), equalTo(0L));
        // IndexSearcher#rewrite optimizes by rewriting non-scoring queries to ConstantScoreQuery
                assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));
        };
                    assertThat(collector.getReduceTime(), greaterThan(0L));  
                    assertThat(maxScore, greaterThanOrEqualTo(avgScore));  
            super(in);  
        assertThat(fieldDoc.fields[0], equalTo(1));  
            assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));  
                assertThat(query.getTimeBreakdown().get("min_score"), greaterThanOrEqualTo(0L));  
        context.terminateAfter(1);  
            assertThat(query.getTimeBreakdown().keySet(), not(empty()));  
            new NumberFieldType("user", NumberType.INTEGER, true, false, true, true, false, null, Collections.emptyMap())  
        if (debug) {
            assertThat(query.getProfiledChildren().get(1).getTimeBreakdown().get("create_weight"), greaterThan(0L));
                assertThat(collector.getProfiledChildren(), hasSize(1));
                assertThat(query.getProfiledChildren().get(0).getTime(), greaterThan(0L));
        }
                assertThat(query.getProfiledChildren().get(1).getTimeBreakdown().get("create_weight"), greaterThan(0L));
                long maxScore = query.getTimeBreakdown().get("max_score");
                assertThat(query.getTimeBreakdown().keySet(), not(empty()));  
            // see: https://github.com/apache/lucene/pull/672
        when(searchContext.bucketCollectorProcessor()).thenReturn(SearchContext.NO_OP_BUCKET_COLLECTOR_PROCESSOR);
                assertThat(query.getTimeBreakdown().get("min_score_count"), greaterThanOrEqualTo(0L));
            IndexSearcher.getDefaultQueryCachingPolicy(),  
                    new PhraseQuery("foo", "bar", "baz"),
                assertThat(collector.getProfiledChildren().get(0).getReason(), equalTo("search_count"));
            }, (query) -> {  
                assertThat(query.getTimeBreakdown().keySet(), not(empty()));  
        dir.close();
        assertProfileData(context, "ConstantScoreQuery", query -> {  
                assertThat(collector.getMaxSliceTime(), greaterThan(0L));
            assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));
            assertThat(query.getProfiledChildren().get(0).getTime(), greaterThan(0L));
                assertThat(query.getTimeBreakdown().get("max_score"), greaterThan(0L));
    @ParametersFactory  
            });  
            assertThat(collector.getMaxSliceTime(), greaterThan(0L));
                assertThat(collector.getMinSliceTime(), greaterThan(0L));
                    assertThat(avgScoreCount, greaterThanOrEqualTo(minScoreCount));
                assertThat(query.getTimeBreakdown().get("score"), equalTo(0L));
    public void testIndexSortScrollOptimization() throws Exception {
            assertThat(collector.getProfiledChildren().get(0).getAvgSliceTime(), greaterThan(0L));  
        List<SortAndFormats> searchSortAndFormats = new ArrayList<>();
        context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));
            });
        TestSearchContext context = new TestSearchContext(null, indexShard, newEarlyTerminationContextSearcher(reader, 0, executor));
            assertThat(collector.getReason(), equalTo("search_top_hits"));
        }
                assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
import static org.hamcrest.CoreMatchers.nullValue;
            assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));  
        context.setSize(1);  
                assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
            assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo(1L));
            assertThat(collector.getTime(), greaterThan(0L));
                results.toXContent(builder, ToXContent.EMPTY_PARAMS);
            assertThat(query.getQueryName(), equalTo("MatchNoDocsQuery"));  
                    long maxScore = query.getProfiledChildren().get(0).getTimeBreakdown().get("max_score");
        assertEquals(context.queryResult().topDocs().topDocs.totalHits.relation(), TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO);  
        for (SortAndFormats searchSortAndFormat : searchSortAndFormats) {
                assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));
import org.opensearch.index.mapper.SourceFieldMapper;
                if (collector.getName().contains("CollectorManager")) {
                assertThat(collector.getReason(), equalTo("search_top_hits"));
            if (executor != null) {
                if (collector.getName().contains("CollectorManager")) {
                assertThat(query.getProfiledChildren().get(0).getTimeBreakdown().get("create_weight_count"), equalTo(1L));
                if (executor != null) {
            assertThat(query.getProfiledChildren().get(0).getQueryName(), equalTo("TermQuery"));
            assertThat(query.getProfiledChildren().get(0).getTimeBreakdown().get("create_weight"), greaterThan(0L));
                    assertThat(maxScoreCount, greaterThanOrEqualTo(avgScoreCount));  
                    assertThat(maxScore, greaterThanOrEqualTo(0L));  
            assertThat(query.getProfiledChildren().get(1).getTimeBreakdown().get("create_weight_count"), equalTo(1L));  
            assertThat(query.getTimeBreakdown().get("score_count"), equalTo(0L));
            assertThat(fieldDoc.fields[0], anyOf(equalTo(1), equalTo(2)));
        when(indexShard.getSearchOperationListener()).thenReturn(searchOperationListener);
                assertThat(collector.getProfiledChildren().get(0).getProfiledChildren().get(0).getMinSliceTime(), greaterThan(0L));
        for (int i = 0; i < numDocs; i++) {
            assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));
        reader.close();
            if (i % 2 == 0) {
        }, collector -> {
        QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);
import org.apache.lucene.search.MatchAllDocsQuery;
        IndexWriterConfig iwc = newIndexWriterConfig().setIndexSort(sort);
                assertThat(query.getProfiledChildren().get(0).getQueryName(), equalTo("TermQuery"));
public class QueryProfilePhaseTests extends IndexShardTestCase {
                assertThat(query.getProfiledChildren(), hasSize(2));  
                assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));
                    assertThat(collector.getReduceTime(), greaterThan(0L));
        }  
import static org.mockito.Mockito.mock;
            }
        context.setSize(2);
    }
                assertThat(query.getTimeBreakdown().get("score"), equalTo(0L));
            assertThat(collector.getProfiledChildren(), empty());  
import static org.mockito.Mockito.when;
                assertThat(query.getTimeBreakdown().get("avg_score"), greaterThan(0L));
import org.apache.lucene.search.Query;  
            if (executor != null) {  
            assertThat(collector.getProfiledChildren().get(0).getMaxSliceTime(), greaterThan(0L));
            assertThat(query.getTimeBreakdown().get("score"), greaterThan(0L));
import org.opensearch.search.internal.SearchContext;
import java.nio.charset.StandardCharsets;  
import static org.hamcrest.Matchers.empty;  
        QueryShardContext queryShardContext = mock(QueryShardContext.class);
            assertThat(query.getTimeBreakdown().get("score_count"), equalTo(0L));
                if (collector.getName().contains("CollectorManager")) {  
        public LeafCollector getLeafCollector(LeafReaderContext context) throws IOException {
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(1));  
            assertThat(collector.getReason(), equalTo("search_top_hits"));
            }
        assertProfileData(context, "TermQuery", query -> {
                if (executor != null) {
                assertThat(collector.getMaxSliceTime(), greaterThan(0L));  
                assertThat(collector.getTime(), greaterThan(0L));
            assertThat(collector.getMaxSliceTime(), greaterThan(0L));  
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(1));
                assertThat(avgScore, greaterThanOrEqualTo(minScore));
        assertProfileData(context, Arrays.asList(query1, query2), collector, false);
    private final QueryPhaseSearcher queryPhaseSearcher;
                assertThat(minScoreCount, greaterThan(0L));
import org.opensearch.search.internal.ScrollContext;
                assertThat(avgScoreCount, greaterThanOrEqualTo(minScoreCount));
                }
            assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));
        });
                assertThat(collector.getMaxSliceTime(), greaterThan(0L));  
            assertProfileData(context, "BooleanQuery", query -> {
            assertThat(query.getTimeBreakdown().get("score_count"), greaterThanOrEqualTo(6L));
        throws IOException {  
    @Override
        if (randomBoolean()) {
        }, collector -> {  
import static org.hamcrest.CoreMatchers.not;  
                    assertThat(collector.getReduceTime(), greaterThan(0L));
                assertThat(avgScore, greaterThanOrEqualTo(minScore));
            assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
        assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), greaterThanOrEqualTo(6L));
        Directory dir = newDirectory();  
        }, (query) -> {
        }
import org.opensearch.core.xcontent.ToXContent;
                    continue;
    }
            assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo(1L));
                assertThat(collector.getProfiledChildren(), empty());  
            w.forceMerge(randomIntBetween(1, 10));
                    long minScore = query.getProfiledChildren().get(0).getTimeBreakdown().get("min_score");  
            assertThat(collector.getMinSliceTime(), greaterThan(0L));
            if (randomBoolean()) {  
                assertThat(maxScore, equalTo(0L));
        context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));  
        assertProfileData(context, "ConstantScoreQuery", query -> {  
            Document doc = new Document();
        context.setSize(10);  
                assertThat(collector.getProfiledChildren(), hasSize(1));
        Directory dir = newDirectory();
                assertThat(collector.getProfiledChildren().get(0).getAvgSliceTime(), greaterThan(0L));
        when(queryShardContext.fieldMapper("user")).thenReturn(
                Collections.singletonMap(indexShard.shardId().toString(), result)  
                    assertThat(collector.getProfiledChildren().get(0).getReduceTime(), greaterThan(0L));
            assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));  
        context.parsedQuery(new ParsedQuery(q));  
                if (collector.getName().contains("CollectorManager")) {
                    assertThat(avgScoreCount, greaterThanOrEqualTo(0L));
                assertThat(query.getTimeBreakdown().get("score_count"), equalTo(0L));  
        QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);
import org.opensearch.index.mapper.MatchOnlyTextFieldMapper;
        this.queryPhaseSearcher = queryPhaseSearcher;
            assertThat(collector.getMinSliceTime(), greaterThan(0L));
            assertThat(query.getProfiledChildren().get(0).getQueryName(), equalTo("TermQuery"));
                assertThat(collector.getProfiledChildren().get(0).getSliceCount(), greaterThanOrEqualTo(1));
        when(mockDocumentMapper.sourceMapper()).thenReturn(mockSourceMapper);
                long avgScoreCount = query.getTimeBreakdown().get("avg_score_count");  
        w.close();  
                assertThat(query.getTimeBreakdown().get("min_score"), greaterThan(0L));  
            // IndexSearcher#rewrite optimizes by rewriting non-scoring queries to ConstantScoreQuery  
        SearchOperationListener searchOperationListener = new SearchOperationListener() {
        assertProfileData(context, "BooleanQuery", query -> {
            searchContext
        SearchContext searchContext = mock(SearchContext.class);
        context.minimumScore(100);
        context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));
                assertThat(collector.getProfiledChildren().get(0).getMaxSliceTime(), greaterThan(0L));
            )  
                    assertThat(query.getTimeBreakdown().get("avg_score_count"), greaterThan(0L));
                assertThat(collector.getProfiledChildren().get(0).getMinSliceTime(), greaterThan(0L));
            assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));
                // IndexSearcher#rewrite optimizes by rewriting non-scoring queries to ConstantScoreQuery
            if (collector.getName().contains("CollectorManager")) {
import java.util.concurrent.Executors;
                doc.add(new StringField("foo", "bar", Store.NO));
                if (collector.getName().contains("CollectorManager")) {
                    assertThat(avgScore, greaterThanOrEqualTo(minScore));  
        }, collector -> {  
            w.addDocument(doc);
            context.setSearcher(newEarlyTerminationContextSearcher(reader, 1, executor));
            assertProfileData(context, "ConstantScoreQuery", query -> {  
                assertThat(out, instanceOf(ByteArrayOutputStream.class));
                assertThat(collector.getMaxSliceTime(), greaterThan(0L));
                }
            assertThat(query.getProfiledChildren().get(0).getTimeBreakdown().get("create_weight_count"), equalTo(1L));  
            });
                assertThat(avgScoreCount, equalTo(0L));  
            final SearchProfileShardResults results = new SearchProfileShardResults(
        }, collector -> {
        IndexReader reader = DirectoryReader.open(dir);  
                assertThat(collector.getProfiledChildren().get(0).getAvgSliceTime(), greaterThan(0L));  
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);
                    long minScore = query.getProfiledChildren().get(1).getTimeBreakdown().get("min_score");
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);
                long avgScore = query.getTimeBreakdown().get("avg_score");  
            }  
            assertThat(collector.getProfiledChildren(), empty());
                if (collector.getName().contains("CollectorManager")) {
            }, collector -> {  
                assertThat(collector.getProfiledChildren().get(0).getReduceTime(), greaterThan(0L));
        Directory dir = newDirectory();
            assertThat(query.getTimeBreakdown().keySet(), not(empty()));
        }
        context.setSize(10);
        {
        w.close();  
                assertThat(query.getTimeBreakdown().get("score_count"), greaterThan(0L));
            assertThat(collector.getProfiledChildren().get(0).getSliceCount(), greaterThanOrEqualTo(1));
        context.parsedQuery(new ParsedQuery(new TermQuery(new Term("foo", "bar"))));  
                assertThat(query.getProfiledChildren().get(0).getTime(), greaterThan(0L));  
import org.opensearch.index.query.SourceFieldMatchQuery;
                assertThat(collector.getTime(), greaterThan(0L));
    private IndexShard indexShard;
            assertThat(query.getTimeBreakdown().keySet(), not(empty()));
                }  
import org.apache.lucene.search.BooleanClause.Occur;
            assertThat(collector.getAvgSliceTime(), greaterThan(0L));
        assertFalse(Float.isNaN(context.queryResult().getMaxScore()));
                assertThat(query.getTimeBreakdown().get("avg_score_count"), equalTo(1L));
                assertThat(collector.getProfiledChildren().get(0).getMaxSliceTime(), greaterThan(0L));
            assertThat(collector.getReason(), equalTo("search_min_score"));
        context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));
        when(searchContext.indexShard()).thenReturn(indexShard);
                if (collector.getName().contains("CollectorManager")) {
            assertThat(query.getTimeBreakdown().get("score"), equalTo(0L));
        Consumer<ProfileResult> query1,
    public QueryProfilePhaseTests(int concurrency, QueryPhaseSearcher queryPhaseSearcher) {
            // see: https://github.com/apache/lucene/pull/672
                long maxScore = query.getTimeBreakdown().get("max_score");
                }  
        context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));  
                assertThat(collector.getMaxSliceTime(), greaterThan(0L));
        context.parsedQuery(
                assertThat(minScoreCount, greaterThan(0L));
        topDocsContext = TopDocsCollectorContext.createTopDocsCollectorContext(context, false);
import org.apache.lucene.document.TextField;  
            // see: https://github.com/apache/lucene/pull/672  
        );  
    public void tearDown() throws Exception {
        assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo((long) numDocs));
                    randomFrom(Pruning.values())
        when(searchContext.indexShard()).thenReturn(indexShard);  
            assertThat(collector.getMaxSliceTime(), greaterThan(0L));  
                    long minScore = query.getTimeBreakdown().get("min_score");
            assertThat(query.getTimeBreakdown().get("score_count"), greaterThanOrEqualTo(6L));
                assertThat(collector.getMinSliceTime(), greaterThan(0L));
            assertThat(query.getTimeBreakdown().get("score"), greaterThan(0L));
                assertThat(children.get(1).getTimeBreakdown().get("create_weight"), greaterThan(0L));
            assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo((long) numDocs));
        assertThat(result.getQueryProfileResults(), hasSize(1));
import org.apache.lucene.index.LeafReaderContext;
                    assertThat(collector.getReduceTime(), greaterThan(0L));  
        final Sort sort = new Sort(new SortField("rank", SortField.Type.INT));
            assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));  
                assertThat(collector.getAvgSliceTime(), greaterThan(0L));
            .build();
        return new ContextIndexSearcher(  
                assertThat(query.getProfiledChildren().get(0).getTimeBreakdown().get("create_weight"), greaterThan(0L));  
                assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));  
        assertThat(context.terminateAfter(), equalTo(0));  
        context.trackTotalHitsUpTo(5);
                )
            }
                    assertThat(query.getTimeBreakdown().get("max_score"), greaterThan(0L));  
        reader.close();  
        scrollContext.lastEmittedDoc = null;
                assertThat(collector.getProfiledChildren().get(0).getTime(), greaterThan(0L));
            assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
            new ParsedQuery(
    public void testInOrderScrollOptimization() throws Exception {
                .add(new TermQuery(new Term("foo", "baz")), Occur.SHOULD)
            ThreadPool.terminate(executor, 10, TimeUnit.SECONDS);
                new BooleanQuery.Builder().add(new TermQuery(new Term("foo", "bar")), Occur.MUST)  
        IndexReader reader = DirectoryReader.open(dir);
                }
        context.setSearcher(newEarlyTerminationContextSearcher(reader, size, executor));  
            // IndexSearcher#rewrite optimizes by rewriting non-scoring queries to ConstantScoreQuery
        when(queryShardContext.index()).thenReturn(new Index("test_index", "uuid"));  
            assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));  
                    long maxScore = query.getTimeBreakdown().get("max_score");
        IndexReader reader = DirectoryReader.open(dir);  
            assertThat(query.getTimeBreakdown().keySet(), not(empty()));  
            assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));
            assertThat(collector.getAvgSliceTime(), greaterThan(0L));
                assertThat(collector.getMinSliceTime(), greaterThan(0L));
import org.opensearch.search.profile.query.CollectorResult;  
                assertThat(collector.getProfiledChildren().get(0).getMaxSliceTime(), greaterThan(0L));
                    .build()
            }, collector -> {  
            assertThat(collector.getMinSliceTime(), greaterThan(0L));
                assertThat(collector.getMinSliceTime(), greaterThan(0L));
                assertThat(collector.getProfiledChildren().get(0).getSliceCount(), greaterThanOrEqualTo(1));
            assertThat(collector.getReason(), equalTo("search_top_hits"));  
            assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
            assertThat(collector.getProfiledChildren(), empty());  
            assertThat(collector.getTime(), greaterThan(0L));
            assertThat(query.getTimeBreakdown().get("score_count"), equalTo(0L));  
                assertThat(query.getProfiledChildren().get(0).getTimeBreakdown().get("score_count"), greaterThanOrEqualTo(0L));  
            assertThat(collector.getProfiledChildren().get(0).getSliceCount(), greaterThanOrEqualTo(1));
        }
        );
                assertThat(query.getTimeBreakdown().get("score"), greaterThan(0L));  
        assertEquals(topDocsContext.create(null).scoreMode(), org.apache.lucene.search.ScoreMode.TOP_DOCS);
            assertThat(query.getTimeBreakdown().get("score"), equalTo(0L));
    public void setUp() throws Exception {
                long avgScore = query.getTimeBreakdown().get("avg_score");
            }
                assertThat(collector.getProfiledChildren().get(0).getReason(), equalTo("search_terminate_after_count"));  
                    assertThat(avgScoreCount, greaterThanOrEqualTo(0L));
        context.setSize(size);
                assertThat(collector.getMaxSliceTime(), greaterThan(0L));
                assertThat(collector.getProfiledChildren().get(0).getSliceCount(), greaterThanOrEqualTo(1));
            assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
            assertThat(query.getProfiledChildren().get(1).getQueryName(), equalTo("TermQuery"));
                    assertThat(maxScore, greaterThanOrEqualTo(0L));
            true,
        });
        SearchContext searchContext = mock(SearchContext.class);
                assertThat(collector.getTime(), greaterThan(0L));
                assertThat(collector.getProfiledChildren().get(0).getMinSliceTime(), greaterThan(0L));
                    assertThat(collector.getReduceTime(), greaterThan(0L));
        SearchContext context,
                    long avgScore = query.getProfiledChildren().get(1).getTimeBreakdown().get("avg_score");
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(1));  
            assertThat(collector.getReason(), equalTo("search_top_hits"));
                if (collector.getName().contains("CollectorManager")) {
                    assertThat(collector.getReduceTime(), greaterThan(0L));
                assertThat(query.getTimeBreakdown().get("min_score"), greaterThanOrEqualTo(0L));
        Directory dir = newDirectory();
import org.apache.lucene.document.Field.Store;
        IndexReader reader = DirectoryReader.open(dir);  
                assertThat(collector.getProfiledChildren().get(0).getAvgSliceTime(), greaterThan(0L));
        context.terminateAfter(1);  
        super.tearDown();
import org.apache.lucene.index.IndexReader;
            });
import static org.hamcrest.Matchers.instanceOf;
            queries.get(i).accept(queryProfileShardResult.getQueryResults().get(i));
        SearchLookup searchLookup = mock(SearchLookup.class);
            assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));
import org.apache.lucene.search.Weight;
        final Sort sort = new Sort(new SortField("user", SortField.Type.INT));
                @Override
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(1));  
                    assertThat(query.getTimeBreakdown().get("max_score_count"), greaterThan(0L));  
                assertThat(collector.getAvgSliceTime(), greaterThan(0L));  
        context.parsedQuery(new ParsedQuery(new MatchAllDocsQuery()));
                long maxScoreCount = query.getTimeBreakdown().get("max_score_count");
                assertThat(maxScoreCount, greaterThan(0L));  
            context.setSize(10);
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(0));
            Document doc = new Document();
        context.trackTotalHitsUpTo(5);
            assertThat(query.getProfiledChildren().get(0).getTimeBreakdown().get("create_weight"), greaterThan(0L));  
                assertThat(collector.getProfiledChildren().get(0).getReason(), equalTo("search_top_hits"));
        final int numDocs = scaledRandomIntBetween(600, 900);
            assertThat(collector.getMaxSliceTime(), greaterThan(0L));  
    }
            doc.add(new StringField("foo", "bar", Store.NO));
            assertThat(query.getTimeBreakdown().keySet(), not(empty()));
                assertThat(query.getProfiledChildren().get(0).getQueryName(), equalTo("SearchAfterSortedDocQuery"));
                assertThat(collector.getAvgSliceTime(), greaterThan(0L));  
                assertThat(collector.getTime(), greaterThan(0L));  
            QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);  
        context.trackTotalHitsUpTo(5);  
            assertProfileData(context, "BooleanQuery", query -> {
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);  
                assertThat(query.getTimeBreakdown().get("avg_score"), greaterThan(0L));
                assertThat(children.get(0).getTimeBreakdown().get("score"), equalTo(0L));  
        for (int i = 0; i < numDocs; ++i) {
                assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));  
                // rewritten as a ConstantScoreQuery wrapping the original BooleanQuery
                assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo(7L));
                    assertThat(collector.getReduceTime(), greaterThan(0L));  
            if (collector.getName().contains("CollectorManager")) {  
                assertThat(children.get(0).getQueryName(), equalTo("TermQuery"));
                    assertThat(minScoreCount, greaterThanOrEqualTo(0L));
            return new FilterLeafCollector(in) {
            assertThat(query.getTimeBreakdown().get("score_count"), greaterThanOrEqualTo(6L));
                assertThat(query.getTimeBreakdown().get("min_score_count"), greaterThanOrEqualTo(0L));
        QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);
            }
 * compatible open source license.
                assertThat(query.getTimeBreakdown().get("max_score_count"), greaterThan(0L));
            assertThat(collector.getMinSliceTime(), greaterThan(0L));
            assertThat(collector.getTime(), greaterThan(0L));
        searchSortAndFormats.add(new SortAndFormats(new Sort(indexSort.getSort()[0]), new DocValueFormat[] { DocValueFormat.RAW }));
            }  
        context.minimumScore(0.01f);
                    assertThat(maxScore, greaterThanOrEqualTo(avgScore));
                long maxScoreCount = query.getTimeBreakdown().get("max_score_count");
            assertThat(collector.getProfiledChildren(), empty());
    }  
                assertThat(maxScoreCount, greaterThan(0L));  
                assertThat(query.getProfiledChildren().get(0).getTimeBreakdown().get("create_weight_count"), equalTo(1L));
            w.addDocument(new Document());  
            assertThat(query.getProfiledChildren().get(1).getTimeBreakdown().get("create_weight"), greaterThan(0L));
        assertFalse(Float.isNaN(context.queryResult().getMaxScore()));  
        assertEquals(topDocsContext.create(null).scoreMode(), org.apache.lucene.search.ScoreMode.COMPLETE);
        dir.close();
                assertThat(query.getTimeBreakdown().get("score"), equalTo(0L));  
            assertThat(collector.getReason(), equalTo("search_top_hits"));  
        for (int i = 0; i < queries.size(); ++i) {  
                assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));
                assertThat(query.getProfiledChildren().get(0).getTimeBreakdown().get("create_weight"), greaterThan(0L));
                assertThat(collector.getReduceTime(), greaterThan(0L));
        final Sort sort = new Sort(new SortField("filter", SortField.Type.STRING));
        IndexReader reader = DirectoryReader.open(dir);  
            context.trackTotalHitsUpTo(SearchContext.TRACK_TOTAL_HITS_DISABLED);  
                assertThat(query.getProfiledChildren().get(1).getQueryName(), equalTo("TermQuery"));
                assertThat(collector.getAvgSliceTime(), greaterThan(0L));
                @SuppressWarnings("unchecked")
            assertThat(query.getTimeBreakdown().get("score_count"), equalTo(0L));  
                assertThat(query.getProfiledChildren().get(0).getTimeBreakdown().get("score"), greaterThanOrEqualTo(0L));
            assertThat(collector.getProfiledChildren().get(0).getMaxSliceTime(), greaterThan(0L));
            assertThat(context.queryResult().getTotalHits().value(), equalTo((long) numDocs));
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        IndexWriterConfig iwc = newIndexWriterConfig();
            assertThat(query.getQueryName(), equalTo("ConstantScoreQuery"));  
            assertThat(query.getTimeBreakdown().keySet(), not(empty()));
            assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
            }  
        context.trackTotalHitsUpTo(3);
            assertThat(query.getProfiledChildren().get(1).getTime(), greaterThan(0L));  
                assertThat(avgScore, greaterThan(0L));  
            QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);
                assertThat(collector.getReduceTime(), greaterThan(0L));
import org.apache.lucene.search.LeafCollector;
            assertTrue(context.queryResult().terminatedEarly());
        assertTrue(context.queryResult().topDocs().topDocs.totalHits.value() >= 5);
            assertThat(collector.getTime(), greaterThan(0L));
            IndexSearcher.getDefaultQueryCache(),  
            assertThat(query.getTimeBreakdown().get("score"), greaterThan(0L));  
            assertThat(query.getTimeBreakdown().get("score"), equalTo(0L));  
import org.apache.lucene.search.SortField;
                builder.startObject();
                if (collector.getName().contains("CollectorManager")) {  
            assertThat(collector.getMinSliceTime(), greaterThan(0L));
            executor,
        });  
                assertThat(collector.getReduceTime(), greaterThan(0L));
        final IndexReader reader = DirectoryReader.open(dir);  
        assertProfileData(context, "BooleanQuery", query -> {  
        when(searchLookup.getLeafSearchLookup(any())).thenReturn(leafSearchLookup);
                assertThat(collector.getProfiledChildren().get(0).getProfiledChildren().get(0).getTime(), greaterThan(0L));
                    assertThat(query.getTimeBreakdown().get("max_score_count"), greaterThan(0L));  
        );
            }
            executor,  
        LeafSearchLookup leafSearchLookup = mock(LeafSearchLookup.class);  
            assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
        assertProfileData(context, collector, (profileResult) -> {
        Directory dir = newDirectory();  
                assertThat(children.get(0).getTime(), greaterThan(0L));  
        final int numDocs = scaledRandomIntBetween(600, 900);  
                assertThat(query.getTimeBreakdown().get("min_score_count"), greaterThanOrEqualTo(5L));  
                assertThat(collector.getProfiledChildren().get(0).getReduceTime(), greaterThan(0L));
            assertNull(context.queryResult().terminatedEarly());
import org.opensearch.search.lookup.LeafSearchLookup;  
        assertProfileData(context, "ConstantScoreQuery", query -> {
                    assertThat(query.getTimeBreakdown().get("avg_score_count"), greaterThan(0L));
        context.parsedPostFilter(new ParsedQuery(new MatchNoDocsQuery()));  
import org.apache.lucene.search.TermQuery;  
        w.close();  
import org.apache.lucene.search.Collector;
                assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));
                assertThat(collector.getReduceTime(), greaterThan(0L));
            QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);  
                assertThat(query.getProfiledChildren().get(0).getQueryName(), equalTo("TermQuery"));
        final ProfileShardResult result = SearchProfileShardResults.buildShardResults(context.getProfilers(), null);  
        assertProfileData(context, "ConstantScoreQuery", query -> {
            if (collector.getName().contains("CollectorManager")) {
            assertThat(collector.getMinSliceTime(), greaterThan(0L));  
                assertThat(query.getTimeBreakdown().get("score_count"), greaterThan(0L));
                long avgScore = query.getTimeBreakdown().get("avg_score");  
                long minScoreCount = query.getTimeBreakdown().get("min_score_count");
                assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));  
            assertThat(collector.getProfiledChildren().get(0).getMinSliceTime(), greaterThan(0L));
            assertThat(collector.getReason(), equalTo("search_top_hits"));
                    assertThat(query.getTimeBreakdown().get("min_score_count"), greaterThan(0L));
                assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));
                assertThat(query.getTimeBreakdown().get("score"), greaterThan(0L));
        reader.close();
            assertThat(collector.getMinSliceTime(), greaterThan(0L));  
            assertNull(context.queryResult().terminatedEarly());
                assertThat(collector.getProfiledChildren(), hasSize(1));
            assertThat(collector.getMaxSliceTime(), greaterThan(0L));
        QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);
                assertThat(collector.getProfiledChildren().get(0).getMaxSliceTime(), greaterThan(0L));
                assertThat(maxScoreCount, greaterThanOrEqualTo(avgScoreCount));  
                        "user",  
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.document.StringField;
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(1));  
            doc.add(new NumericDocValuesField("user", i & 1));
                assertThat(query.getTimeBreakdown().get("min_score_count"), greaterThanOrEqualTo(0L));  
        context.parsedQuery(  
            assertProfileData(context, "ConstantScoreQuery", query -> {
                if (collector.getName().contains("CollectorManager")) {
            assertThat(collector.getProfiledChildren().get(0).getMinSliceTime(), greaterThan(0L));
                assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));
                assertThat(query.getTimeBreakdown().get("score_count"), equalTo(0L));
                assertThat(collector.getTime(), greaterThan(0L));  
    public void testIndexSortingEarlyTermination() throws Exception {
            assertThat(query.getTimeBreakdown().get("score_count"), equalTo(0L));
        assertEquals(numDocs / 2, context.queryResult().topDocs().topDocs.totalHits.value());  
                assertThat(avgScore, equalTo(0L));
                }  
            assertThat(query.getTimeBreakdown().get("score_count"), equalTo(0L));  
                assertThat(query.getProfiledChildren().get(0).getTimeBreakdown().get("create_weight"), greaterThan(0L));  
                assertThat(query.getProfiledChildren().get(1).getQueryName(), equalTo("TermQuery"));  
                long maxScore = query.getTimeBreakdown().get("max_score");
    public void testTerminateAfterWithFilter() throws Exception {  
                assertThat(collector.getProfiledChildren().get(0).getReason(), equalTo("search_top_hits"));
import org.apache.lucene.index.Term;
        when(queryShardContext.sourcePath("foo")).thenReturn(Set.of("bar"));
            assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo(numDocs - 1L));
            assertThat(collector.getProfiledChildren(), empty());
                    super.collect(doc);
        });
            protected void search(LeafReaderContextPartition[] partitions, Weight weight, Collector collector) throws IOException {
            assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));  
        final IndexReader reader = DirectoryReader.open(dir);
        w.close();
                    long maxScoreCount = query.getProfiledChildren().get(0).getTimeBreakdown().get("max_score_count");
                assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));
        Document doc = new Document();
        dir.close();  
        for (int i = 0; i < 10; i++) {
            true,
        assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(1));  
    @Override  
            }
import org.apache.lucene.search.PhraseQuery;
            context.parsedQuery(new ParsedQuery(new MatchAllDocsQuery()));
            context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));  
        Document doc = new Document();
            }, collector -> {
                assertThat(children.get(1).getTimeBreakdown().get("create_weight_count"), equalTo(1L));  
    }
        assertProfileData(context, "MatchAllDocsQuery", query -> {
    private static class AssertingEarlyTerminationFilterCollector extends FilterCollector {
        final QueryProfileShardResult queryProfileShardResult = result.getQueryProfileResults().get(0);  
        final Sort sort = new Sort(new SortField("rank", SortField.Type.INT));
    private static ContextIndexSearcher newContextSearcher(IndexReader reader, ExecutorService executor) throws IOException {
                if (collector.getName().contains("CollectorManager")) {
    }  
                    assertThat(query.getTimeBreakdown().get("max_score"), greaterThan(0L));  
        assertProfileData(context, "BooleanQuery", query -> {
        for (int i = 0; i < 10; i++) {  
            assertThat(collector.getAvgSliceTime(), greaterThan(0L));
                assertThat(query.getTimeBreakdown().get("score"), equalTo(0L));
        Directory dir = newDirectory();
                assertThat(avgScoreCount, equalTo(minScoreCount));
            query.accept(profileResult);
        TestSearchContext context = new TestSearchContext(null, indexShard, newContextSearcher(reader, executor));
import static org.hamcrest.Matchers.equalTo;
                assertThat(collector.getMinSliceTime(), greaterThan(0L));
    public void testMaxScore() throws Exception {  
                assertThat(collector.getTime(), greaterThan(0L));
        when(searchContext.bucketCollectorProcessor()).thenReturn(SearchContext.NO_OP_BUCKET_COLLECTOR_PROCESSOR);
        {
    }
            context.parsedPostFilter(null);
import org.opensearch.search.lookup.SourceLookup;
        IndexWriterConfig iwc = newIndexWriterConfig().setIndexSort(sort);
            assertThat(query.getTimeBreakdown().keySet(), not(empty()));
                if (collector.getName().contains("CollectorManager")) {  
            QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);  
            assertThat(query.getTimeBreakdown().get("score_count"), greaterThanOrEqualTo(5L));  
        assertThat(context.queryResult().topDocs().topDocs, instanceOf(CollapseTopFieldDocs.class));  
            assertThat(context.terminateAfter(), equalTo(0));
                assertThat(query.getProfiledChildren().get(0).getTime(), greaterThan(0L));  
}
                assertThat(collector.getMinSliceTime(), greaterThan(0L));  
                assertThat(query.getTimeBreakdown().get("max_score"), greaterThan(0L));
        assertProfileData(context, "SourceFieldMatchQuery", query -> {  
            assertThat(query.getProfiledChildren().get(0).getTime(), greaterThan(0L));
import org.opensearch.search.lookup.SearchLookup;
        }  
            assertThat(collector.getTime(), greaterThan(0L));  
                assertThat(collector.getProfiledChildren().get(0).getReduceTime(), greaterThan(0L));  
        context.parsedQuery(new ParsedQuery(new MatchAllDocsQuery()));
                assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));
                assertThat(children.get(0).getTimeBreakdown().get("create_weight"), greaterThan(0L));
            assertThat(query.getTimeBreakdown().get("score_count"), greaterThanOrEqualTo(6L));
        w.close();
                assertThat(query.getTimeBreakdown().keySet(), not(empty()));
                assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));
        }
                doc.add(new StringField("foo", "bar", Store.NO));
                assertThat(query.getProfiledChildren().get(1).getTimeBreakdown().get("score"), greaterThanOrEqualTo(0L));  
                assertThat(query.getTimeBreakdown().get("avg_score"), greaterThan(0L));
            }  
        w.addDocument(doc);  
                assertThat(query.getTimeBreakdown().keySet(), not(empty()));
                assertThat(children.get(1).getTime(), greaterThan(0L));
            assertThat(collector.getProfiledChildren().get(0).getReason(), equalTo("search_top_hits"));  
            assertThat(collector.getMaxSliceTime(), greaterThan(0L));
        QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);
            assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));  
                assertThat(collector.getMinSliceTime(), greaterThan(0L));  
            assertThat(collector.getReason(), equalTo("search_min_score"));
            assertNull(context.queryResult().terminatedEarly());
            assertThat(query.getProfiledChildren().get(0).getTimeBreakdown().get("score"), equalTo(0L));
        }
                assertThat(collector.getMaxSliceTime(), greaterThan(0L));
                assertThat(query.getTimeBreakdown().get("max_score"), greaterThan(0L));  
                assertThat(collector.getMaxSliceTime(), greaterThan(0L));
            assertThat(collector.getAvgSliceTime(), greaterThan(0L));
            }
            });
            assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));
        QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);
                assertThat(collector.getProfiledChildren().get(0).getTime(), greaterThan(0L));
            assertThat(collector.getProfiledChildren().get(0).getReason(), equalTo("search_count"));
    }  
                assertThat(collector.getProfiledChildren().get(0).getMinSliceTime(), greaterThan(0L));
        IndexWriterConfig iwc = newIndexWriterConfig(new StandardAnalyzer());
                assertThat(maxScoreCount, equalTo(avgScoreCount));
        IndexWriterConfig iwc = newIndexWriterConfig().setIndexSort(sort);  
                assertThat(query.getTimeBreakdown().get("score"), equalTo(0L));
                    assertThat(minScore, greaterThanOrEqualTo(0L));
            w.addDocument(doc);
                if (executor != null) {  
                    long minScoreCount = query.getProfiledChildren().get(0).getTimeBreakdown().get("min_score_count");  
                assertThat(query.getTimeBreakdown().keySet(), not(empty()));
                }
        });
        final IndexReader reader = DirectoryReader.open(dir);  
import org.apache.lucene.search.FilterLeafCollector;
        IndexReader reader = DirectoryReader.open(dir);
        context.setSize(3);
        IndexWriterConfig iwc = newIndexWriterConfig();
