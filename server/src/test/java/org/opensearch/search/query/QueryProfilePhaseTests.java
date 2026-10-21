import org.apache.lucene.search.FilterLeafCollector;
            assertThat(collector.getProfiledChildren().get(0).getMaxSliceTime(), greaterThan(0L));
            assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
                assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));
                assertThat(query.getProfiledChildren(), hasSize(2));
        context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));
import org.apache.lucene.search.SortField;
        IndexReader reader = DirectoryReader.open(dir);
        };
import java.util.ArrayList;
        context.sort(new SortAndFormats(sort, new DocValueFormat[] { DocValueFormat.RAW }));
    }
        IndexShard indexShard = mock(IndexShard.class);
        final Sort indexSort = new Sort(new SortField("rank", SortField.Type.INT), new SortField("tiebreaker", SortField.Type.INT));
                if (collector.getName().contains("CollectorManager")) {
import org.apache.lucene.search.BooleanQuery;
            assertThat(collector.getAvgSliceTime(), greaterThan(0L));
            QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);
            assertThat(query.getTimeBreakdown().get("score_count"), equalTo(0L));
            }, (query) -> {
                assertThat(query.getProfiledChildren().get(0).getQueryName(), equalTo("SearchAfterSortedDocQuery"));
            });
                assertThat(query.getTimeBreakdown().get("avg_score"), greaterThan(0L));
                assertThat(query.getTimeBreakdown().get("max_score_count"), greaterThanOrEqualTo(4L));
            assertThat(collector.getTime(), greaterThan(0L));
                assertThat(query.getProfiledChildren().get(0).getTimeBreakdown().get("score"), greaterThanOrEqualTo(0L));
            }
            context.setSize(1);
            }
            assertThat(query.getTimeBreakdown().get("score"), equalTo(0L));
                if (collector.getName().contains("CollectorManager")) {
import org.apache.lucene.search.Weight;
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);
        ) {
            assertThat(query.getProfiledChildren().get(0).getTimeBreakdown().get("score_count"), equalTo(0L));
            assertThat(query.getProfiledChildren().get(0).getQueryName(), equalTo("TermQuery"));
        dir.close();
            assertThat(query.getTimeBreakdown().get("score_count"), equalTo(0L));
                assertThat(collector.getMaxSliceTime(), greaterThan(0L));
            QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);
                assertThat(query.getTimeBreakdown().get("score"), greaterThan(0L));
                assertThat(collector.getProfiledChildren(), hasSize(1));
            assertThat(query.getProfiledChildren().get(1).getTimeBreakdown().get("create_weight"), greaterThan(0L));
        dir.close();
            assertThat(query.getTimeBreakdown().get("score"), equalTo(0L));
        TestSearchContext context = new TestSearchContext(null, indexShard, newContextSearcher(reader, executor));
                assertThat(collector.getProfiledChildren().get(0).getMinSliceTime(), greaterThan(0L));
            assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));
                assertThat(collector.getProfiledChildren().get(0).getReason(), equalTo("search_top_hits"));
            assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));
        SearchContext context,
            assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo(1L));
        context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));
        };
import org.opensearch.search.internal.ContextIndexSearcher;
                int collected;
                assertThat(query.getProfiledChildren().get(1).getTimeBreakdown().get("create_weight_count"), equalTo(1L));
        }
            assertThat(query.getProfiledChildren(), empty());
            }
                assertThat(query.getTimeBreakdown().get("score"), equalTo(0L));
            if (collector.getName().contains("CollectorManager")) {
            // see: https://github.com/apache/lucene/pull/672
                    assertThat(avgScoreCount, greaterThanOrEqualTo(0L));
                if (collector.getName().contains("CollectorManager")) {
                assertThat(query.getTimeBreakdown().keySet(), not(empty()));
                assertThat(collector.getProfiledChildren().get(0).getAvgSliceTime(), greaterThan(0L));
                assertThat(query.getProfiledChildren(), hasSize(1));
            context.sort(searchSortAndFormat);
        assertEquals(context.queryResult().topDocs().topDocs.totalHits.relation(), TotalHits.Relation.EQUAL_TO);
            assertThat(collector.getMaxSliceTime(), greaterThan(0L));
        private final int size;
                    assertThat(minScoreCount, greaterThanOrEqualTo(0L));
            if (collector.getName().contains("CollectorManager")) {
            context.setSize(1);
            assertThat(collector.getProfiledChildren(), empty());
            assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));
                List<ProfileResult> children = query.getProfiledChildren().get(0).getProfiledChildren();
                assertThat(collector.getProfiledChildren().get(0).getMaxSliceTime(), greaterThan(0L));
        assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo((long) numDocs));
            context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));
                assertThat(collector.getMaxSliceTime(), greaterThan(0L));
        IndexWriterConfig iwc = newIndexWriterConfig();
            }
        context.setSize(1);
            assertThat(query.getTimeBreakdown().get("score_count"), greaterThanOrEqualTo(6L));
                assertThat(maxScore, greaterThanOrEqualTo(avgScore));
                assertThat(query.getTimeBreakdown().get("score_count"), greaterThan(0L));
        searchSortAndFormats.add(new SortAndFormats(indexSort, new DocValueFormat[] { DocValueFormat.RAW, DocValueFormat.RAW }));
        if (randomBoolean()) {
                assertThat(collector.getReduceTime(), greaterThan(0L));
            assertThat(query.getTimeBreakdown().keySet(), not(empty()));
            assertThat(collector.getMinSliceTime(), greaterThan(0L));
                assertThat(query.getProfiledChildren().get(0).getQueryName(), equalTo("TermQuery"));
        when(searchContext.indexShard()).thenReturn(indexShard);
            if (trackTotalHits == -1) {
        QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);
            if (collector.getName().contains("CollectorManager")) {
        context.sort(new SortAndFormats(sort, new DocValueFormat[] { DocValueFormat.RAW }));
                    assertThat(query.getTimeBreakdown().get("max_score"), greaterThan(0L));
            assertThat(collector.getReason(), equalTo("search_min_score"));
                long maxScoreCount = query.getTimeBreakdown().get("max_score_count");
import static org.mockito.Mockito.when;
                final OutputStream out = builder.getOutputStream();
            true,
                long maxScore = query.getTimeBreakdown().get("max_score");
        context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));
                }
            super(in);
            }
            w.addDocument(doc);
                    assertThat(collector.getProfiledChildren().get(0).getReduceTime(), greaterThan(0L));
            assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
                assertThat(collector.getProfiledChildren().get(0).getMaxSliceTime(), greaterThan(0L));
            doc.add(new NumericDocValuesField("rank", numDocs - i));
                assertThat(collector.getMaxSliceTime(), greaterThan(0L));
                    assertThat(collector.getProfiledChildren().get(0).getReduceTime(), greaterThan(0L));
import org.opensearch.search.profile.query.CollectorResult;
        IndexWriterConfig iwc = newIndexWriterConfig().setIndexSort(sort);
        for (SortAndFormats searchSortAndFormat : searchSortAndFormats) {
            assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));
            assertThat(collector.getAvgSliceTime(), greaterThan(0L));
                assertThat(children.get(0).getTimeBreakdown().get("score"), equalTo(0L));
            assertThat(query.getProfiledChildren().get(1).getQueryName(), equalTo("TermQuery"));
                assertThat(collector.getProfiledChildren().get(0).getSliceCount(), greaterThanOrEqualTo(1));
                assertThat(out, instanceOf(ByteArrayOutputStream.class));
        assertThat(queryProfileShardResult.getQueryResults(), hasSize(queries.size()));
            assertThat(query.getTimeBreakdown().keySet(), not(empty()));
import org.apache.lucene.index.DirectoryReader;
            }
    }
                assertThat(query.getTimeBreakdown().get("avg_score"), greaterThan(0L));
        w.close();
                    assertThat(avgScoreCount, greaterThanOrEqualTo(minScoreCount));
                assertThat(collector.getProfiledChildren().get(0).getAvgSliceTime(), greaterThan(0L));
        w.close();
        context.parsedQuery(
                    assertThat(maxScoreCount, greaterThanOrEqualTo(avgScoreCount));
            assertThat(query.getTimeBreakdown().keySet(), not(empty()));
                new BooleanQuery.Builder().add(new TermQuery(new Term("foo", "bar")), Occur.MUST)
                assertThat(collector.getProfiledChildren().get(0).getReason(), equalTo("search_top_hits"));
                    long avgScoreCount = query.getProfiledChildren().get(0).getTimeBreakdown().get("avg_score_count");
            assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));
            context.setSize(0);
            assertThat(query.getTimeBreakdown().get("score_count"), equalTo(0L));
        context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));
            assertThat(collector.getTime(), greaterThan(0L));
        assertProfileData(context, "SpanNearQuery", query -> {
            QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);
        }
import org.opensearch.search.profile.ProfileShardResult;
            }
                assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo(0L));
        assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(3));
        assertEquals(0, context.queryResult().topDocs().topDocs.totalHits.value());
        assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), greaterThanOrEqualTo(6L));
import java.io.IOException;
            w.addDocument(doc);
                assertThat(query.getQueryName(), equalTo("MatchAllDocsQuery"));
        return new ContextIndexSearcher(
                assertThat(query.getProfiledChildren().get(0).getTime(), greaterThan(0L));
        AssertingEarlyTerminationFilterCollector(Collector in, int size) {
                assertThat(avgScoreCount, equalTo(0L));
import org.opensearch.index.query.ParsedQuery;
            assertThat(collector.getMaxSliceTime(), greaterThan(0L));
            assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));
                    new TermQuery(new Term("foo", "bar")),
                assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
        context.setSize(10);
            ThreadPool.terminate(executor, 10, TimeUnit.SECONDS);
        Directory dir = newDirectory();
import org.apache.lucene.search.MatchNoDocsQuery;
                assertThat(avgScoreCount, equalTo(minScoreCount));
        w.close();
        // Always end up with uneven buckets so collapsing is predictable
            assertThat(collector.getMaxSliceTime(), greaterThan(0L));
                if (collector.getName().contains("CollectorManager")) {
            assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));
            assertThat(collector.getProfiledChildren(), hasSize(1));
                assertThat(collector.getProfiledChildren().get(0).getMinSliceTime(), greaterThan(0L));
                assertThat(minScore, equalTo(0L));
                }
 * this file be licensed under the Apache-2.0 license or a
            }
            assertThat(query.getQueryName(), equalTo("MatchNoDocsQuery"));
import org.opensearch.common.xcontent.json.JsonXContent;
            if (executor != null) {
                    .build()
            assertThat(query.getTimeBreakdown().keySet(), not(empty()));
                assertThat(query.getTimeBreakdown().get("avg_score"), greaterThan(0L));
import org.apache.lucene.search.FieldComparator;
                long maxScore = query.getTimeBreakdown().get("max_score");
            assertThat(collector.getReason(), equalTo("search_min_score"));
            }
                assertThat(maxScore, greaterThanOrEqualTo(1L));
            assertThat(query.getTimeBreakdown().get("score"), equalTo(0L));
        IndexWriterConfig iwc = newIndexWriterConfig(new StandardAnalyzer());
                        true,
            doc.add(new StringField("filter", "f1", Store.NO));
        when(indexShard.getSearchOperationListener()).thenReturn(searchOperationListener);
        TestSearchContext context = new TestSearchContext(null, indexShard, newEarlyTerminationContextSearcher(reader, 0, executor));
            assertTrue(context.queryResult().terminatedEarly());
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);
                assertThat(query.getTimeBreakdown().get("score_count"), equalTo(0L));
                assertThat(collector.getProfiledChildren().get(0).getSliceCount(), greaterThanOrEqualTo(1));
                    long maxScore = query.getProfiledChildren().get(0).getTimeBreakdown().get("max_score");
        IndexWriterConfig iwc = newIndexWriterConfig().setIndexSort(sort);
                assertThat(query.getTimeBreakdown().keySet(), not(empty()));
                assertThat(maxScore, equalTo(0L));
        );
import org.opensearch.common.settings.Settings;
            assertThat(collector.getProfiledChildren().get(0).getMinSliceTime(), greaterThan(0L));
        });
                    randomFrom(Pruning.values())
            assertThat(collector.getProfiledChildren().get(0).getTime(), greaterThan(0L));
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs[0], instanceOf(FieldDoc.class));
                assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));
                assertThat(query.getTimeBreakdown().get("avg_score_count"), greaterThanOrEqualTo(1L));
            assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));
    public void testDisableTopScoreCollection() throws Exception {
                assertThat(collector.getReduceTime(), greaterThan(0L));
                assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));
        if (debug) {
                long minScore = query.getTimeBreakdown().get("min_score");
import org.apache.lucene.index.IndexWriterConfig;
                    assertThat(collector.getProfiledChildren().get(0).getReduceTime(), greaterThan(0L));
        Directory dir = newDirectory();
            Document doc = new Document();
                if (collector.getName().contains("CollectorManager")) {
            assertThat(collector.getMinSliceTime(), greaterThan(0L));
                    assertThat(query.getTimeBreakdown().get("avg_score_count"), greaterThan(0L));
                    assertThat(query.getTimeBreakdown().get("min_score_count"), greaterThan(0L));
                int cmp = comparator.compareValues(firstDoc.fields[i], lastDoc.fields[i]);
import org.opensearch.search.DocValueFormat;
                doc.add(new StringField("foo", "baz", Store.NO));
                assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));
                assertThat(collector.getProfiledChildren().get(0).getSliceCount(), greaterThanOrEqualTo(1));
                assertThat(query.getTimeBreakdown().get("avg_score_count"), greaterThanOrEqualTo(1L));
    public void testIndexSortingEarlyTermination() throws Exception {
            // IndexSearcher#rewrite optimizes by rewriting non-scoring queries to ConstantScoreQuery
            assertThat(query.getTimeBreakdown().get("score_count"), equalTo(0L));
        });
                assertThat(query.getTimeBreakdown().get("min_score_count"), greaterThanOrEqualTo(0L));
                    assertThat(maxScore, greaterThanOrEqualTo(avgScore));
        assertProfileData(context, "MatchAllDocsQuery", query -> {
                // see: https://github.com/apache/lucene/pull/672
                assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));
                assertThat(query.getTimeBreakdown().get("min_score_count"), equalTo(1L));
            context.setSize(0);
                assertThat(collector.getAvgSliceTime(), greaterThan(0L));
/*
            assertThat(collector.getReason(), equalTo("search_top_hits"));
    }
                assertThat(collector.getProfiledChildren().get(0).getAvgSliceTime(), greaterThan(0L));
import org.apache.lucene.index.Term;
    }
        });
        final Sort sort = new Sort(new SortField("rank", SortField.Type.INT));
        Directory dir = newDirectory();
        });
import org.apache.lucene.document.StringField;
            assertThat(query.getProfiledChildren(), hasSize(2));
                if (collector.getName().contains("CollectorManager")) {
            assertThat(profileResult.getQueryName(), equalTo(type));
            assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));
                long minScore = query.getTimeBreakdown().get("min_score");
        QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);
        assertEquals(1, context.queryResult().topDocs().topDocs.scoreDocs.length);
                long maxScore = query.getTimeBreakdown().get("max_score");
                assertThat(query.getProfiledChildren().get(0).getTime(), greaterThan(0L));
                assertThat(collector.getMaxSliceTime(), greaterThan(0L));
        QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);
            executor,
    }
                assertThat(query.getProfiledChildren(), hasSize(2));
            if (executor != null) {
        }, collector -> {
                    assertThat(maxScore, greaterThanOrEqualTo(avgScore));
import org.opensearch.index.mapper.NumberFieldMapper.NumberFieldType;
                long minScoreCount = query.getTimeBreakdown().get("min_score_count");
                assertThat(maxScoreCount, greaterThan(0L));
    }
                assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));
                assertThat(avgScore, greaterThanOrEqualTo(1L));
            context.setSearcher(newEarlyTerminationContextSearcher(reader, 1, executor));
                    assertThat(maxScoreCount, greaterThanOrEqualTo(avgScoreCount));
                assertThat(query.getTimeBreakdown().get("avg_score"), greaterThan(0L));
                assertThat(query.getTimeBreakdown().get("score"), equalTo(0L));
            }
                assertThat(collector.getTime(), greaterThan(0L));
        IndexWriterConfig iwc = newIndexWriterConfig().setIndexSort(sort);
        Consumer<CollectorResult> collector,
                assertThat(collector.getProfiledChildren().get(0).getAvgSliceTime(), greaterThan(0L));
                assertThat(query.getTimeBreakdown().get("score_count"), equalTo(0L));
            assertTrue(context.queryResult().terminatedEarly());
import static org.hamcrest.CoreMatchers.nullValue;
        context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));
                assertThat(collector.getProfiledChildren(), hasSize(1));
                    assertThat(avgScore, greaterThanOrEqualTo(minScore));
                assertThat(children.get(0).getTimeBreakdown().get("create_weight"), greaterThan(0L));
                assertThat(collector.getReduceTime(), greaterThan(0L));
                assertThat(children.get(1).getTimeBreakdown().get("score_count"), equalTo(0L));
                assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));
                    assertThat(collector.getReduceTime(), greaterThan(0L));
                    long maxScore = query.getTimeBreakdown().get("max_score");
                assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));
                assertThat(collector.getProfiledChildren().get(0).getTime(), greaterThan(0L));
                }
import org.opensearch.action.search.SearchShardTask;
            doc.add(new NumericDocValuesField("user", i & 1));
            IndexSearcher.getDefaultQueryCachingPolicy(),
            assertThat(collector.getProfiledChildren(), empty());
            });
                    assertThat(collector.getProfiledChildren().get(0).getReduceTime(), greaterThan(0L));
            ScrollContext scrollContext = new ScrollContext();
            };
                assertThat(collector.getTime(), greaterThan(0L));
                assertThat(children.get(1).getTimeBreakdown().get("create_weight"), greaterThan(0L));
        for (int i = 0; i < numDocs; ++i) {
                assertThat(query.getProfiledChildren().get(1).getQueryName(), equalTo("TermQuery"));
}
        context.parsedQuery(new ParsedQuery(new MatchAllDocsQuery()));
        dir.close();
                }
            assertThat(collector.getProfiledChildren().get(0).getMinSliceTime(), greaterThan(0L));
import org.apache.lucene.queries.spans.SpanNearQuery;
        reader.close();
                assertThat(collector.getProfiledChildren().get(0).getMaxSliceTime(), greaterThan(0L));
                );
        Directory dir = newDirectory();
        IndexShard indexShard = mock(IndexShard.class);
                public void collect(int doc) throws IOException {
                builder.startObject();
                assertThat(query.getProfiledChildren().get(0).getTimeBreakdown().get("create_weight_count"), equalTo(1L));
            assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
            assertThat(collector.getMaxSliceTime(), greaterThan(0L));
            }, collector -> {
            }
            scrollContext.maxScore = Float.NaN;
            QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);
                assertThat(collector.getProfiledChildren().get(0).getMaxSliceTime(), greaterThan(0L));
import org.apache.lucene.search.grouping.CollapseTopFieldDocs;
                Collections.singletonMap(indexShard.shardId().toString(), result)
                assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
        assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo((long) numDocs));
                assertThat(avgScore, equalTo(0L));
            w.addDocument(doc);
                    assertThat(query.getTimeBreakdown().get("max_score"), greaterThan(0L));
    public void testTerminateAfterWithFilter() throws Exception {
            if (executor != null) {
                doc.add(new StringField("foo", "bar", Store.NO));
            assertThat(collector.getMinSliceTime(), greaterThan(0L));
            assertProfileData(context, "ConstantScoreQuery", query -> {
    @ParametersFactory
    public void testTerminateAfterEarlyTermination() throws Exception {
            new Object[] { 0, QueryPhase.DEFAULT_QUERY_PHASE_SEARCHER },
                if (collector.getName().contains("CollectorManager")) {
        // IndexSearcher#rewrite optimizes by rewriting non-scoring queries to ConstantScoreQuery
            assertThat(collector.getTime(), greaterThan(0L));
                assertThat(query.getTimeBreakdown().get("score_count"), equalTo(0L));
    public void testCollapseQuerySearchResults() throws Exception {
        return new ContextIndexSearcher(
            assertThat(collector.getAvgSliceTime(), greaterThan(0L));
            }, collector -> {
            assertThat(collector.getProfiledChildren().get(0).getMinSliceTime(), greaterThan(0L));
            context.parsedQuery(new ParsedQuery(bq));
                )
                logger.info(new String(((ByteArrayOutputStream) out).toByteArray(), StandardCharsets.UTF_8));
        }, collector -> {
                assertThat(query.getProfiledChildren().get(1).getQueryName(), equalTo("TermQuery"));
        Consumer<CollectorResult> collector,
        assertThat(context.getProfilers(), not(nullValue()));
package org.opensearch.search.query;
                assertThat(query.getTimeBreakdown().get("score"), greaterThan(0L));
            }
import java.util.Collections;
            QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);
import org.apache.lucene.search.Pruning;
                assertThat(query.getProfiledChildren().get(1).getTimeBreakdown().get("create_weight"), greaterThan(0L));
            assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
import org.opensearch.search.lookup.SearchLookup;
            }
                assertThat(collector.getProfiledChildren().get(0).getMinSliceTime(), greaterThan(0L));
                assertThat(collector.getProfiledChildren(), hasSize(1));
            assertThat(query.getTimeBreakdown().get("score_count"), greaterThanOrEqualTo(5L));
        dir.close();
                    assertThat(collector.getProfiledChildren().get(0).getReduceTime(), greaterThan(0L));
                assertThat(query.getTimeBreakdown().get("score_count"), greaterThanOrEqualTo(7L));
                assertThat(query.getTimeBreakdown().get("max_score"), greaterThan(0L));
        w.close();
        assertProfileData(context, "SourceFieldMatchQuery", query -> {
                assertThat(collector.getProfiledChildren().get(0).getSliceCount(), greaterThanOrEqualTo(1));
                assertThat(collector.getReduceTime(), greaterThan(0L));
    }
import org.opensearch.index.mapper.NumberFieldMapper.NumberType;
    }
        QueryShardContext queryShardContext = mock(QueryShardContext.class);
            }
                    long minScore = query.getProfiledChildren().get(0).getTimeBreakdown().get("min_score");
        assertProfileData(context, collector -> {
import static org.mockito.ArgumentMatchers.any;
            assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo(1L));
            assertThat(query.getTimeBreakdown().get("score"), equalTo(0L));
                assertThat(collector.getMinSliceTime(), greaterThan(0L));
        Directory dir = newDirectory();
        context.parsedQuery(new ParsedQuery(new MatchAllDocsQuery()));
                assertThat(query.getQueryName(), equalTo("TermQuery"));
            assertThat(fieldDoc.fields[0], anyOf(equalTo(1), equalTo(2)));
import org.opensearch.index.query.QueryShardContext;
            if (collector.getName().contains("CollectorManager")) {
            assertThat(context.queryResult().getTotalHits().value(), equalTo((long) numDocs));
            )
                if (executor != null) {
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(1));
            context.parsedQuery(new ParsedQuery(new MatchAllDocsQuery()));
                FieldComparator<Object> comparator = (FieldComparator<Object>) searchSortAndFormat.sort.getSort()[i].getComparator(
            new NumberFieldType("user", NumberType.INTEGER, true, false, true, true, false, null, Collections.emptyMap())
            assertThat(collector.getMinSliceTime(), greaterThan(0L));
                assertThat(collector.getReason(), equalTo("search_terminate_after_count"));
    public void tearDown() throws Exception {
            return new FilterLeafCollector(in) {
        context.setSize(3);
                assertThat(collector.getProfiledChildren(), empty());
                assertThat(collector.getAvgSliceTime(), greaterThan(0L));
            for (int i = 0; i < searchSortAndFormat.sort.getSort().length; i++) {
                assertThat(query.getTimeBreakdown().keySet(), not(empty()));
        List<SortAndFormats> searchSortAndFormats = new ArrayList<>();
                assertThat(collector.getTime(), greaterThan(0L));
        scrollContext.maxScore = Float.NaN;
                assertThat(collector.getProfiledChildren().get(0).getReason(), equalTo("search_terminate_after_count"));
            assertThat(collector.getTime(), greaterThan(0L));
                long avgScoreCount = query.getTimeBreakdown().get("avg_score_count");
            new ParsedQuery(
        context.sort(new SortAndFormats(sort, new DocValueFormat[] { DocValueFormat.RAW }));
        DocumentMapper mockDocumentMapper = mock(DocumentMapper.class);
        assertEquals(context.queryResult().topDocs().topDocs.totalHits.relation(), TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO);
        int size = randomIntBetween(2, 5);
    private final ExecutorService executor;
            // IndexSearcher#rewrite optimizes by rewriting non-scoring queries to ConstantScoreQuery
                assertThat(collector.getMaxSliceTime(), greaterThan(0L));
        TestSearchContext context = new TestSearchContext(queryShardContext, indexShard, newContextSearcher(reader, executor));
    private final QueryPhaseSearcher queryPhaseSearcher;
            assertThat(collector.getMinSliceTime(), greaterThan(0L));
                assertThat(maxScore, greaterThan(0L));
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);
        context.trackTotalHitsUpTo(5);
                    assertThat(query.getTimeBreakdown().get("max_score_count"), greaterThan(0L));
            assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));
                assertThat(collector.getReduceTime(), greaterThan(0L));
        assertEquals(numDocs / 2, context.queryResult().topDocs().topDocs.totalHits.value());
        when(searchContext.bucketCollectorProcessor()).thenReturn(SearchContext.NO_OP_BUCKET_COLLECTOR_PROCESSOR);
        }, (query) -> {
            new ParsedQuery(
                assertThat(collector.getReason(), equalTo("search_post_filter"));
                if (executor != null) {
            assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));
                    assertThat(query.getTimeBreakdown().get("avg_score"), greaterThan(0L));
    }
import org.apache.lucene.document.SortedDocValuesField;
                }
        when(leafSearchLookup.source()).thenReturn(new SourceLookup());
                @SuppressWarnings("unchecked")
                    .build()
        throws IOException {
        context.parsedQuery(new ParsedQuery(q));
            }
        final QueryProfileShardResult queryProfileShardResult = result.getQueryProfileResults().get(0);
            assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));
        assertThat(context.terminateAfter(), equalTo(0));
                    assert collected <= size : "should not collect more than " + size + " doc per segment, got " + collected;
                assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));
                assertThat(query.getTimeBreakdown().get("max_score"), greaterThan(0L));
            }
            assertThat(query.getProfiledChildren().get(0).getQueryName(), equalTo("TermQuery"));
                assertThat(query.getProfiledChildren().get(0).getTimeBreakdown().get("create_weight_count"), equalTo(1L));
        when(searchContext.bucketCollectorProcessor()).thenReturn(SearchContext.NO_OP_BUCKET_COLLECTOR_PROCESSOR);
        IndexReader reader = DirectoryReader.open(dir);
        assertProfileData(context, "ConstantScoreQuery", query -> {
                assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));
            doc.add(new StringField("foo", Integer.toString(i), Store.NO));
    private void assertProfileData(SearchContext context, String type, Consumer<ProfileResult> query, Consumer<CollectorResult> collector)
                assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));
            assertThat(query.getTimeBreakdown().get("score"), equalTo(0L));
                }
import org.opensearch.index.mapper.TextSearchInfo;
            assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo(numDocs - 1L));
            assertThat(collector.getReason(), equalTo("search_top_hits"));
            assertThat(collector.getMaxSliceTime(), greaterThan(0L));
            context.parsedQuery(new ParsedQuery(bq));
import org.opensearch.lucene.queries.MinDocQuery;
                assertThat(query.getTimeBreakdown().get("score_count"), greaterThan(0L));
                assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
        context.setSearcher(newContextSearcher(reader, executor));
        context.trackScores(true);
    }
            if (collector.getName().contains("CollectorManager")) {
            assertThat(collector.getMinSliceTime(), greaterThan(0L));
        w.close();
        for (int i = 0; i < numDocs; ++i) {
        assertEquals(topDocsContext.create(null).scoreMode(), org.apache.lucene.search.ScoreMode.TOP_DOCS);
                    long maxScore = query.getProfiledChildren().get(1).getTimeBreakdown().get("max_score");
                assertThat(collector.getReduceTime(), greaterThan(0L));
import org.apache.lucene.document.TextField;
        context.setSize(size);
                break;
        ScrollContext scrollContext = new ScrollContext();
            w.addDocument(doc);
                assertThat(query.getProfiledChildren().get(0).getTimeBreakdown().get("score_count"), equalTo(0L));
                }
        context.parsedQuery(
                assertThat(collector.getProfiledChildren().get(0).getReason(), equalTo("search_top_hits"));
                // rewritten as a ConstantScoreQuery wrapping the original BooleanQuery
                    long minScoreCount = query.getProfiledChildren().get(0).getTimeBreakdown().get("min_score_count");
            // see: https://github.com/apache/lucene/pull/672
        QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);
            if (randomBoolean()) {
                assertThat(collector.getAvgSliceTime(), greaterThan(0L));
            assertThat(collector.getReason(), equalTo("search_top_hits"));
        when(queryShardContext.index()).thenReturn(new Index("test_index", "uuid"));
        TestSearchContext context = new TestSearchContext(null, indexShard, newContextSearcher(reader, executor));
                long avgScore = query.getTimeBreakdown().get("avg_score");
        FieldDoc fieldDoc = (FieldDoc) context.queryResult().topDocs().topDocs.scoreDocs[0];
                assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
                long minScore = query.getTimeBreakdown().get("min_score");
            assertThat(collector.getAvgSliceTime(), greaterThan(0L));
            assertThat(query.getTimeBreakdown().keySet(), not(empty()));
                assertThat(query.getTimeBreakdown().get("score_count"), equalTo(0L));
            assertNull(context.queryResult().terminatedEarly());
import java.util.concurrent.TimeUnit;
    }
            QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);
            if (collector.getName().contains("CollectorManager")) {
                if (collector.getName().contains("CollectorManager")) {
        QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);
            assertThat(query.getProfiledChildren().get(1).getTime(), greaterThan(0L));
        reader.close();
import org.apache.lucene.search.Query;
import org.opensearch.search.collapse.CollapseBuilder;
            // see: https://github.com/apache/lucene/pull/672
                assertThat(collector.getProfiledChildren().get(0).getTime(), greaterThan(0L));
import static org.hamcrest.Matchers.anyOf;
        TestSearchContext context = new TestSearchContext(null, indexShard, newEarlyTerminationContextSearcher(reader, 0, executor));
                    assertThat(avgScore, greaterThanOrEqualTo(minScore));
            }
                    assertThat(minScoreCount, greaterThanOrEqualTo(0L));
        final Sort sort = new Sort(new SortField("rank", SortField.Type.INT));
                assertThat(collector.getProfiledChildren().get(0).getSliceCount(), greaterThanOrEqualTo(1));
                    assertThat(maxScore, greaterThanOrEqualTo(0L));
                assertThat(query.getTimeBreakdown().get("score_count"), equalTo(1L));
                    assertThat(avgScore, greaterThanOrEqualTo(minScore));
                assertThat(query.getTimeBreakdown().get("min_score"), greaterThanOrEqualTo(0L));
import org.opensearch.search.internal.ScrollContext;
        when(mockSourceMapper.enabled()).thenReturn(true);
                assertThat(collector.getMinSliceTime(), greaterThan(0L));
            assertThat(collector.getAvgSliceTime(), greaterThan(0L));
        Consumer<ProfileResult> query1,
                assertThat(collector.getProfiledChildren().get(0).getReduceTime(), greaterThan(0L));
            try (final XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint()) {
        IndexReader reader = DirectoryReader.open(dir);
            assertThat(collector.getMaxSliceTime(), greaterThan(0L));
            assertThat(collector.getMaxSliceTime(), greaterThan(0L));
    public QueryProfilePhaseTests(int concurrency, QueryPhaseSearcher queryPhaseSearcher) {
                assertThat(collector.getTime(), greaterThan(0L));
        }
        }, collector -> {
        QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);
                assertThat(collector.getProfiledChildren().get(0).getAvgSliceTime(), greaterThan(0L));
                assertThat(collector.getMinSliceTime(), greaterThan(0L));
                    i,
            assertThat(query.getProfiledChildren().get(0).getTimeBreakdown().get("create_weight"), greaterThan(0L));
        assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo((long) numDocs));
        final ProfileShardResult result = SearchProfileShardResults.buildShardResults(context.getProfilers(), null);
            assertThat(collector.getAvgSliceTime(), greaterThan(0L));
            assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo((long) numDocs));
                assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);
                assertThat(minScore, greaterThanOrEqualTo(1L));
                }
    public void testIndexSortScrollOptimization() throws Exception {
            }, (query) -> {
                if (collector.getName().contains("CollectorManager")) {
        }
                    assertThat(avgScore, greaterThanOrEqualTo(0L));
                long avgScore = query.getTimeBreakdown().get("avg_score");
                assertThat(collector.getProfiledChildren(), hasSize(1));
        final int numDocs = 2 * scaledRandomIntBetween(50, 450);
                assertThat(query.getTimeBreakdown().keySet(), not(empty()));
            assertThat(collector.getMaxSliceTime(), greaterThan(0L));
        final Sort sort = new Sort(new SortField("filter", SortField.Type.STRING));
            assertThat(collector.getTime(), greaterThan(0L));
        return Settings.builder().put(super.threadPoolSettings()).put("thread_pool.search.min_queue_size", 10).build();
import java.util.Arrays;
        for (int i = 0; i < numDocs; ++i) {
            assertThat(query.getTimeBreakdown().get("score_count"), greaterThanOrEqualTo(6L));
                assertThat(collector.getProfiledChildren().get(0).getMaxSliceTime(), greaterThan(0L));
        IndexReader reader = DirectoryReader.open(dir);
            assertProfileData(context, "BooleanQuery", query -> {
            assertThat(collector.getMaxSliceTime(), greaterThan(0L));
            assertThat(collector.getMaxSliceTime(), greaterThan(0L));
                if (cmp == 0) {
            );
                assertThat(collector.getTime(), greaterThan(0L));
                assertThat(collector.getProfiledChildren().get(0).getSliceCount(), greaterThanOrEqualTo(1));
            searchContext
            assertThat(query.getProfiledChildren().get(0).getTimeBreakdown().get("create_weight_count"), equalTo(1L));
            if (collector.getName().contains("CollectorManager")) {
        {
            .build();
                assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
        // IndexSearcher#rewrite optimizes by rewriting non-scoring queries to ConstantScoreQuery
            assertThat(collector.getMaxSliceTime(), greaterThan(0L));
            assertThat(collector.getMinSliceTime(), greaterThan(0L));
                    assertThat(query.getTimeBreakdown().get("max_score_count"), greaterThan(0L));
        assertThat(result.getQueryProfileResults(), hasSize(1));
        // see: https://github.com/apache/lucene/pull/672
                assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));
                assertThat(collector.getMaxSliceTime(), greaterThan(0L));
            assertThat(collector.getTime(), greaterThan(0L));
        }, collector -> {
        // search sort is a prefix of the index sort
        context.trackTotalHitsUpTo(5);
                assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));
        List<Consumer<ProfileResult>> queries,
            assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));
            assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
                if (collector.getName().contains("CollectorManager")) {
                assertThat(collector.getProfiledChildren().get(0).getMaxSliceTime(), greaterThan(0L));
            }, (query) -> {
                assertThat(collector.getMaxSliceTime(), greaterThan(0L));
                assertThat(query.getTimeBreakdown().get("score_count"), equalTo(0L));
                assertThat(query.getTimeBreakdown().get("score"), equalTo(0L));
        for (int i = 0; i < 10; i++) {
                assertThat(query.getTimeBreakdown().keySet(), not(empty()));
                assertThat(collector.getReduceTime(), greaterThan(0L));
                assertThat(query.getTimeBreakdown().keySet(), not(empty()));
                assertThat(maxScoreCount, equalTo(avgScoreCount));
                assertThat(query.getTimeBreakdown().keySet(), not(empty()));
        return Arrays.asList(
            assertThat(query.getTimeBreakdown().get("score"), greaterThan(0L));
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);
                assertThat(collector.getProfiledChildren().get(0).getAvgSliceTime(), greaterThan(0L));
                assertThat(query.getTimeBreakdown().get("score"), equalTo(0L));
                long avgScoreCount = query.getTimeBreakdown().get("avg_score_count");
            doc.add(new NumericDocValuesField("tiebreaker", i));
        QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);
    public Settings threadPoolSettings() {
                assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
            query.accept(profileResult);
        SearchContext searchContext = mock(SearchContext.class);
        context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));
                    assertThat(collector.getReduceTime(), greaterThan(0L));
                assertThat(collector.getReduceTime(), greaterThan(0L));
        for (int i = 0; i < numDocs; ++i) {
        final Sort sort = new Sort(new SortField("rank", SortField.Type.INT));
        context.sort(new SortAndFormats(new Sort(new SortField("other", SortField.Type.INT)), new DocValueFormat[] { DocValueFormat.RAW }));
                assertThat(collector.getMaxSliceTime(), greaterThan(0L));
        });
        final Sort sort = new Sort(new SortField("rank", SortField.Type.INT));
            assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));
        dir.close();
        }, collector -> {
            assertThat(collector.getAvgSliceTime(), greaterThan(0L));
            if (randomBoolean()) {
            }
                assertThat(collector.getMinSliceTime(), greaterThan(0L));
            assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));
                assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
        assertProfileData(context, "BooleanQuery", query -> {
import org.opensearch.index.shard.SearchOperationListener;
import org.apache.lucene.index.IndexReader;
        }
        }, (query) -> {
        reader.close();
                assertThat(collector.getProfiledChildren(), hasSize(1));
            IndexSearcher.getDefaultQueryCache(),
        assertThat(context.queryResult().topDocs().topDocs, instanceOf(CollapseTopFieldDocs.class));
            assertThat(collector.getProfiledChildren(), empty());
        if (executor != null) {
import org.apache.lucene.queries.spans.SpanTermQuery;
        for (int i = 0; i < numDocs; i++) {
        SearchOperationListener searchOperationListener = new SearchOperationListener() {
                assertThat(avgScoreCount, greaterThanOrEqualTo(minScoreCount));
                assertThat(query.getTimeBreakdown().get("avg_score_count"), equalTo(1L));
            assertThat(collector.getMinSliceTime(), greaterThan(0L));
                assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));
        IndexReader reader = DirectoryReader.open(dir);
                        Collections.emptyMap()
                assertThat(query.getTimeBreakdown().get("max_score_count"), equalTo(1L));
        Directory dir = newDirectory();
            assertThat(query.getProfiledChildren().get(1).getTimeBreakdown().get("create_weight_count"), equalTo(1L));
                assertThat(query.getTimeBreakdown().get("min_score"), greaterThanOrEqualTo(0L));
            if (collector.getName().contains("CollectorManager")) {
        assertProfileData(context, "ConstantScoreQuery", query -> {
            reader,
        });
            assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));
        }
        // see: https://github.com/apache/lucene/pull/672
        assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(1));
            assertThat(query.getTimeBreakdown().get("score"), equalTo(0L));
            }, collector -> {
                assertThat(query.getTimeBreakdown().get("score_count"), equalTo(0L));
            assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));
            assertThat(query.getTimeBreakdown().get("score"), greaterThan(0L));
        final IndexReader reader = DirectoryReader.open(dir);
                doc.add(new StringField("foo", "bar", Store.NO));
                assertThat(collector.getProfiledChildren().get(0).getTime(), greaterThan(0L));
        TestSearchContext context = new TestSearchContext(null, indexShard, newContextSearcher(reader, executor));
        // see: https://github.com/apache/lucene/pull/672
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(0));
                assertThat(children.get(1).getTimeBreakdown().get("score"), equalTo(0L));
                assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
            assertThat(query.getTimeBreakdown().keySet(), not(empty()));
        final Sort sort = new Sort(new SortField("user", SortField.Type.INT));
        SearchContext context,
                }
                assertThat(query.getTimeBreakdown().get("min_score_count"), greaterThanOrEqualTo(0L));
    private IndexShard indexShard;
            assertTrue(context.queryResult().terminatedEarly());
            assertThat(query.getQueryName(), equalTo("ConstantScoreQuery"));
        context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));
        public LeafCollector getLeafCollector(LeafReaderContext context) throws IOException {
        QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);
                assertThat(collector.getMinSliceTime(), greaterThan(0L));
        }
    }
                assertThat(collector.getTime(), greaterThan(0L));
            assertThat(query.getProfiledChildren().get(1).getTimeBreakdown().get("create_weight"), greaterThan(0L));
        assertThat(context.queryResult().topDocs().topDocs.scoreDocs[0], instanceOf(FieldDoc.class));
            }
import org.apache.lucene.search.TermQuery;
                }
        IndexReader reader = DirectoryReader.open(dir);
            assertThat(collector.getProfiledChildren().get(0).getAvgSliceTime(), greaterThan(0L));
        for (int trackTotalHits : new int[] { -1, 3, 75, 100 }) {
        }
                assertThat(collector.getTime(), greaterThan(0L));
        context.parsedQuery(new ParsedQuery(new MatchAllDocsQuery()));
            }, collector -> {
            assertThat(collector.getMaxSliceTime(), greaterThan(0L));
            w.addDocument(doc);
                    assertThat(minScoreCount, greaterThanOrEqualTo(0L));
                // IndexSearcher#rewrite optimizes by rewriting non-scoring queries to ConstantScoreQuery
            if (collector.getName().contains("CollectorManager")) {
                new SourceFieldMatchQuery(
            assertThat(collector.getTime(), greaterThan(0L));
            assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));
            }
            reader,
                assertThat(collector.getReason(), equalTo("search_top_hits"));
import org.apache.lucene.search.PhraseQuery;
            assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));
            QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);
                    assertThat(collector.getReduceTime(), greaterThan(0L));
            }
            assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));
    }
import org.opensearch.index.mapper.DocumentMapper;
import org.opensearch.index.query.SourceFieldMatchQuery;
                assertThat(query.getProfiledChildren().get(0).getTimeBreakdown().get("create_weight_count"), equalTo(1L));
import org.apache.lucene.document.Field.Store;
        {
        }
            queries.get(i).accept(queryProfileShardResult.getQueryResults().get(i));
                assertThat(collector.getProfiledChildren().get(0).getSliceCount(), greaterThanOrEqualTo(1));
            context.setSearcher(newEarlyTerminationContextSearcher(reader, 10, executor));
            assertProfileData(context, collector -> {
                }
        Document doc = new Document();
            assertNull(context.queryResult().terminatedEarly());
            assertThat(collector.getProfiledChildren(), empty());
        }
            assertThat(query.getTimeBreakdown().keySet(), not(empty()));
                long avgScore = query.getTimeBreakdown().get("avg_score");
                    .add(new TermQuery(new Term("filter", "f1")), Occur.SHOULD)
                    long maxScoreCount = query.getProfiledChildren().get(0).getTimeBreakdown().get("max_score_count");
        for (int i = 0; i < 10; i++) {
            scrollContext.lastEmittedDoc = null;
                assertThat(query.getTimeBreakdown().get("score"), greaterThan(0L));
            if (executor != null) {
            assertThat(query.getTimeBreakdown().keySet(), not(empty()));
            assertThat(collector.getTime(), greaterThan(0L));
                assertThat(query.getProfiledChildren().get(0).getTimeBreakdown().get("create_weight"), greaterThan(0L));
        context.setSize(10);
        context.parsedPostFilter(new ParsedQuery(new MatchNoDocsQuery()));
 * SPDX-License-Identifier: Apache-2.0
            assertThat(query.getProfiledChildren().get(1).getTimeBreakdown().get("create_weight"), greaterThan(0L));
                    long avgScore = query.getProfiledChildren().get(1).getTimeBreakdown().get("avg_score");
            assertThat(query.getProfiledChildren(), empty());
        }, collector -> {
        IndexReader reader = DirectoryReader.open(dir);
        final IndexReader reader = DirectoryReader.open(dir);
        super.setUp();
                assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(0));
    }
                assertThat(query.getProfiledChildren().get(0).getTimeBreakdown().get("create_weight_count"), equalTo(1L));
                assertThat(query.getTimeBreakdown().keySet(), not(empty()));
            assertThat(collector.getAvgSliceTime(), greaterThan(0L));
                    assertThat(collector.getProfiledChildren().get(0).getReduceTime(), greaterThan(0L));
    }
        Document doc = new Document();
            scrollContext.totalHits = null;
            assertThat(collector.getReason(), equalTo("search_top_hits"));
import org.opensearch.index.mapper.MatchOnlyTextFieldMapper;
        assertEquals(TotalHits.Relation.EQUAL_TO, context.queryResult().topDocs().topDocs.totalHits.relation());
            assertThat(query.getTimeBreakdown().get("score"), greaterThan(0L));
                assertThat(query.getTimeBreakdown().get("score"), equalTo(0L));
                doc.add(new StringField("foo", "baz", Store.NO));
            assertThat(collector.getMinSliceTime(), greaterThan(0L));
        }
            assertThat(query.getTimeBreakdown().get("score"), equalTo(0L));
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);
                assertThat(avgScoreCount, greaterThanOrEqualTo(minScoreCount));
                    assertThat(collector.getReduceTime(), greaterThan(0L));
                    long avgScore = query.getProfiledChildren().get(0).getTimeBreakdown().get("avg_score");
                long maxScore = query.getTimeBreakdown().get("max_score");
                assertThat(collector.getProfiledChildren().get(0).getReason(), equalTo("search_count"));
                assertThat(maxScore, greaterThanOrEqualTo(avgScore));
                assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
    @Override
            context.setSize(10);
            assertThat(query.getProfiledChildren().get(1).getTime(), greaterThan(0L));
        w.close();
                assertThat(minScoreCount, equalTo(0L));
    private void assertProfileData(SearchContext context, Consumer<CollectorResult> collector, Consumer<ProfileResult> query1)
    public static Collection<Object[]> concurrency() {
        }, collector -> {
                assertThat(query.getTimeBreakdown().keySet(), not(empty()));
        closeShards(indexShard);
                    long avgScoreCount = query.getProfiledChildren().get(1).getTimeBreakdown().get("avg_score_count");
            });
    }
            });
        IndexWriterConfig iwc = newIndexWriterConfig().setIndexSort(sort);
            assertThat(query.getTimeBreakdown().get("score"), greaterThan(0L));
        when(queryShardContext.lookup()).thenReturn(searchLookup);
            }
                    assertThat(avgScoreCount, greaterThanOrEqualTo(minScoreCount));
        reader.close();
                assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));
                assertThat(collector.getProfiledChildren().get(0).getTime(), greaterThan(0L));
import org.opensearch.search.lookup.LeafSearchLookup;
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);
                }
            context.setSize(1);
                assertThat(collector.getProfiledChildren().get(0).getReduceTime(), greaterThan(0L));
                assertThat(collector.getProfiledChildren().get(0).getTime(), greaterThan(0L));
                    assertThat(query.getTimeBreakdown().get("min_score"), greaterThan(0L));
            assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));
            if (collector.getName().contains("CollectorManager")) {
                assertThat(children, hasSize(2));
                assertThat(collector.getMinSliceTime(), greaterThan(0L));
            assertThat(collector.getProfiledChildren().get(0).getReason(), equalTo("search_count"));
                assertThat(query.getTimeBreakdown().keySet(), not(empty()));
                assertThat(maxScoreCount, greaterThan(0L));
                    assertThat(collector.getProfiledChildren().get(0).getReduceTime(), greaterThan(0L));
import java.util.concurrent.Executors;
import org.apache.lucene.search.Collector;
import org.apache.lucene.search.FieldDoc;
                assertThat(query.getTimeBreakdown().get("min_score"), greaterThan(0L));
                assertThat(collector.getMaxSliceTime(), greaterThan(0L));
        indexShard = newShard(true);
            assertThat(collector.getProfiledChildren().get(0).getReason(), equalTo("search_count"));
import static org.hamcrest.Matchers.empty;
        when(searchLookup.getLeafSearchLookup(any())).thenReturn(leafSearchLookup);
        }
import org.apache.lucene.tests.index.RandomIndexWriter;
        context.parsedQuery(new ParsedQuery(new MatchAllDocsQuery()));
        }
                        "user",
        assertThat(context.queryResult().getTotalHits().value(), equalTo((long) numDocs));
        assertThat(context.queryResult().topDocs().topDocs, instanceOf(CollapseTopFieldDocs.class));
                assertThat(query.getProfiledChildren().get(0).getTimeBreakdown().get("create_weight"), greaterThan(0L));
            context.parsedPostFilter(new ParsedQuery(new MinDocQuery(1)));
        TestSearchContext context = new TestSearchContext(null, indexShard, newContextSearcher(reader, executor));
    private static ContextIndexSearcher newContextSearcher(IndexReader reader, ExecutorService executor) throws IOException {
                }
                    assertThat(collector.getReduceTime(), greaterThan(0L));
            }, (query) -> {
                assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));
                assertThat(collector.getProfiledChildren().get(0).getProfiledChildren().get(0).getTime(), greaterThan(0L));
                assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));
                assertThat(collector.getProfiledChildren().get(0).getMinSliceTime(), greaterThan(0L));
                assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));
import static org.hamcrest.Matchers.hasSize;
        );
        {
        dir.close();
            assertThat(collector.getProfiledChildren().get(0).getMaxSliceTime(), greaterThan(0L));
            TestSearchContext context = new TestSearchContext(null, indexShard, newContextSearcher(reader, executor), scrollContext);
            assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
        assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), greaterThanOrEqualTo(6L));
                assertThat(collector.getAvgSliceTime(), greaterThan(0L));
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(1));
                assertThat(query.getTimeBreakdown().get("min_score_count"), greaterThanOrEqualTo(5L));
            assertThat(query.getProfiledChildren().get(0).getTimeBreakdown().get("create_weight"), greaterThan(0L));
import org.apache.lucene.search.LeafCollector;
                assertThat(query.getTimeBreakdown().get("score"), greaterThan(0L));
import org.apache.lucene.document.NumericDocValuesField;
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(7));
                assertThat(query.getTimeBreakdown().get("max_score_count"), greaterThan(0L));
                    assertThat(query.getTimeBreakdown().get("min_score_count"), greaterThan(0L));
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
                if (collector.getName().contains("CollectorManager")) {
                    assertThat(query.getTimeBreakdown().get("min_score"), greaterThan(0L));
            assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));
            // see: https://github.com/apache/lucene/pull/672
            assertThat(fieldDoc.fields[0], anyOf(equalTo(1), equalTo(2)));
        assertProfileData(context, "TermQuery", query -> {
                assertThat(collector.getMinSliceTime(), greaterThan(0L));
                if (collector.getName().contains("CollectorManager")) {
                assertThat(collector.getReduceTime(), greaterThan(0L));
            }, collector -> {
            assertThat(query.getProfiledChildren(), hasSize(2));
            assertThat(collector.getAvgSliceTime(), greaterThan(0L));
                if (collector.getName().contains("CollectorManager")) {
                assertThat(query.getProfiledChildren().get(0).getTimeBreakdown().get("score_count"), greaterThanOrEqualTo(0L));
                assertThat(collector.getTime(), greaterThan(0L));
import java.util.List;
                if (executor != null) {
import org.apache.lucene.search.MatchAllDocsQuery;
            doc.add(new StringField("foo", "bar", Store.NO));
            assertThat(query.getTimeBreakdown().get("score_count"), equalTo(0L));
                assertThat(collector.getProfiledChildren().get(0).getMaxSliceTime(), greaterThan(0L));
import static org.mockito.Mockito.mock;
                    super.collect(doc);
                long minScoreCount = query.getTimeBreakdown().get("min_score_count");
            new ParsedQuery(
            assertThat(collector.getMinSliceTime(), greaterThan(0L));
                assertThat(collector.getProfiledChildren().get(0).getMinSliceTime(), greaterThan(0L));
import org.apache.lucene.search.TotalHits;
                assertThat(query.getTimeBreakdown().get("score"), greaterThan(0L));
        });
        w.close();
            assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));
public class QueryProfilePhaseTests extends IndexShardTestCase {
 *
                assertThat(collector.getReason(), equalTo("search_terminate_after_count"));
                assertThat(collector.getProfiledChildren().get(0).getReason(), equalTo("search_top_hits"));
            assertNull(context.queryResult().terminatedEarly());
        context.setSize(1);
            } else {
            context.trackTotalHitsUpTo(SearchContext.TRACK_TOTAL_HITS_DISABLED);
                assertThat(collector.getAvgSliceTime(), greaterThan(0L));
                assertThat(collector.getProfiledChildren().get(0).getProfiledChildren().get(0).getReason(), equalTo("search_top_hits"));
                assertThat(collector.getReason(), equalTo("search_top_hits"));
        QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);
        // IndexSearcher#rewrite optimizes by rewriting non-scoring queries to ConstantScoreQuery
        });
            true,
                assertThat(maxScoreCount, greaterThanOrEqualTo(avgScoreCount));
            if (collector.getName().contains("CollectorManager")) {
import static org.hamcrest.CoreMatchers.not;
                assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));
                assertThat(collector.getAvgSliceTime(), greaterThan(0L));
    }
                assertThat(query.getProfiledChildren().get(1).getTime(), greaterThan(0L));
            // IndexSearcher#rewrite optimizes by rewriting non-scoring queries to ConstantScoreQuery
    private void assertProfileData(
        w.close();
            assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
        context.parsedQuery(new ParsedQuery(new MatchAllDocsQuery()));
            assertThat(collector.getMaxSliceTime(), greaterThan(0L));
        @Override
                assertThat(collector.getAvgSliceTime(), greaterThan(0L));
                    assertThat(avgScoreCount, greaterThanOrEqualTo(0L));
            assertThat(collector.getReason(), equalTo("search_count"));
        context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));
                    assertThat(collector.getReduceTime(), greaterThan(0L));
import org.opensearch.search.lookup.SourceLookup;
            assertThat(query.getTimeBreakdown().keySet(), not(empty()));
                assertThat(query.getTimeBreakdown().get("max_score"), greaterThan(0L));
                long minScore = query.getTimeBreakdown().get("min_score");
        QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);
                    assertThat(minScore, greaterThanOrEqualTo(0L));
                assertThat(maxScoreCount, greaterThanOrEqualTo(avgScoreCount));
                assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
        Directory dir = newDirectory();
            assertThat(query.getTimeBreakdown().get("score"), equalTo(0L));
        LeafSearchLookup leafSearchLookup = mock(LeafSearchLookup.class);
            doc.add(new StringField("foo", "bar", Store.NO));
            assertThat(collector.getTime(), greaterThan(0L));
            }
            assertThat(collector.getProfiledChildren(), empty());
                assertThat(query.getProfiledChildren().get(0).getTimeBreakdown().get("score_count"), equalTo(0L));
import java.util.function.Consumer;
                assertThat(query.getProfiledChildren().get(1).getTimeBreakdown().get("score"), greaterThanOrEqualTo(0L));
        SourceFieldMapper mockSourceMapper = mock(SourceFieldMapper.class);
            if (executor != null) {
        QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);
            }
            assertThat(collector.getProfiledChildren(), empty());
            int sizeMinus1 = context.queryResult().topDocs().topDocs.scoreDocs.length - 1;
    private static class AssertingEarlyTerminationFilterCollector extends FilterCollector {
                    assertThat(maxScore, greaterThanOrEqualTo(0L));
        boolean debug
            assertThat(collector.getAvgSliceTime(), greaterThan(0L));
            assertThat(query.getTimeBreakdown().keySet(), not(empty()));
            assertThat(query.getTimeBreakdown().get("score_count"), greaterThanOrEqualTo(6L));
            doc.add(new SortedDocValuesField("filter", newBytesRef("f1" + ((i > 0) ? " " + Integer.toString(i) : ""))));
                assertThat(collector.getReason(), equalTo("search_terminate_after_count"));
            this.size = size;
            assertThat(collector.getMaxSliceTime(), greaterThan(0L));
        topDocsContext = TopDocsCollectorContext.createTopDocsCollectorContext(context, false);
            assertThat(query.getProfiledChildren().get(0).getTimeBreakdown().get("create_weight"), greaterThan(0L));
                    assertThat(collector.getReduceTime(), greaterThan(0L));
            assertProfileData(context, "ConstantScoreQuery", query -> {
        w.close();
                assertThat(collector.getProfiledChildren().get(0).getProfiledChildren(), hasSize(1));
            });
        Directory dir = newDirectory();
    public void testMinScoreDisablesCountOptimization() throws Exception {
                assertThat(query.getTimeBreakdown().get("min_score"), greaterThan(0L));
                // see: https://github.com/apache/lucene/pull/672
    }
                assertThat(query.getTimeBreakdown().get("score"), equalTo(0L));
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);
                assertThat(query.getTimeBreakdown().keySet(), not(empty()));
        context.parsedQuery(new ParsedQuery(new MatchAllDocsQuery()));
                assertThat(avgScoreCount, greaterThan(0L));
                results.toXContent(builder, ToXContent.EMPTY_PARAMS);
        QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);
                assertThat(maxScore, equalTo(avgScore));
        context.sort(new SortAndFormats(sort, new DocValueFormat[] { DocValueFormat.RAW }));
                    long maxScoreCount = query.getTimeBreakdown().get("max_score_count");
            assertThat(collector.getProfiledChildren(), empty());
                assertThat(collector.getReason(), equalTo("search_post_filter"));
                    new MatchOnlyTextFieldMapper.MatchOnlyTextFieldType(
                assertThat(collector.getTime(), greaterThan(0L));
        Query q = new SpanNearQuery.Builder("title", true).addClause(new SpanTermQuery(new Term("title", "foo")))
                }
                assertThat(avgScore, greaterThanOrEqualTo(minScore));
                    assertThat(collector.getProfiledChildren().get(0).getReduceTime(), greaterThan(0L));
        QueryShardContext queryShardContext = mock(QueryShardContext.class);
        when(indexShard.getSearchOperationListener()).thenReturn(searchOperationListener);
        final int numDocs = 2 * scaledRandomIntBetween(600, 900) - 1;
        dir.close();
                assertThat(collector.getReason(), equalTo("search_top_hits"));
                assertThat(query.getTimeBreakdown().get("max_score_count"), greaterThanOrEqualTo(5L));
            IndexSearcher.getDefaultSimilarity(),
            assertThat(query.getTimeBreakdown().keySet(), not(empty()));
        assertProfileData(context, "ConstantScoreQuery", query -> {
        IndexWriterConfig iwc = newIndexWriterConfig().setIndexSort(sort);
                assertThat(collector.getProfiledChildren().get(0).getReason(), equalTo("search_count"));
        assertProfileData(context, "ConstantScoreQuery", query -> {
                assertThat(query.getProfiledChildren().get(0).getTimeBreakdown().get("score"), equalTo(0L));
            w.addDocument(doc);
                    assertThat(collector.getReduceTime(), greaterThan(0L));
            doc.clear();
            assertThat(collector.getReason(), equalTo("search_top_hits"));
import org.apache.lucene.document.Document;
        IndexReader reader = DirectoryReader.open(dir);
            assertThat(query.getTimeBreakdown().get("score_count"), equalTo(0L));
                assertThat(collector.getTime(), greaterThan(0L));
        context.parsedQuery(new ParsedQuery(new TermQuery(new Term("foo", "bar"))));
                    assertThat(maxScore, greaterThanOrEqualTo(avgScore));
        assertEquals(0, context.queryResult().topDocs().topDocs.totalHits.value());
                assertThat(query.getTimeBreakdown().get("score_count"), equalTo(0L));
            assertThat(collector.getProfiledChildren(), hasSize(1));
import java.util.Collection;
            // IndexSearcher#rewrite optimizes by rewriting non-scoring queries to ConstantScoreQuery
        scrollContext.lastEmittedDoc = null;
                builder.endObject();
                    assertThat(minScore, greaterThanOrEqualTo(0L));
                assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));
            assertThat(query.getProfiledChildren().get(1).getTimeBreakdown().get("create_weight_count"), equalTo(1L));
        });
            QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);
            });
            assertProfileData(context, "ConstantScoreQuery", query -> {
        Document doc = new Document();
                    assertThat(maxScoreCount, greaterThanOrEqualTo(0L));
                assertThat(query.getTimeBreakdown().get("avg_score_count"), greaterThan(0L));
                assertThat(query.getTimeBreakdown().keySet(), not(empty()));
        }, collector -> {
                    long minScoreCount = query.getProfiledChildren().get(1).getTimeBreakdown().get("min_score_count");
            assertThat(collector.getProfiledChildren().get(0).getMaxSliceTime(), greaterThan(0L));
                    long minScore = query.getProfiledChildren().get(1).getTimeBreakdown().get("min_score");
                    long minScoreCount = query.getTimeBreakdown().get("min_score_count");
            Document doc = new Document();
        TopDocsCollectorContext topDocsContext = TopDocsCollectorContext.createTopDocsCollectorContext(context, false);
        });
        assertProfileData(context, collector, (profileResult) -> {
                assertThat(query.getTimeBreakdown().keySet(), not(empty()));
                assertThat(query.getTimeBreakdown().get("max_score"), greaterThan(0L));
        reader.close();
        w.addDocument(doc);
            }, collector -> {
import static org.hamcrest.Matchers.greaterThan;
            if (executor != null) {
            if (randomBoolean()) {
                assertThat(query.getTimeBreakdown().keySet(), not(empty()));
                if (collector.getName().contains("CollectorManager")) {
            IndexSearcher.getDefaultQueryCache(),
 * The OpenSearch Contributors require contributions made to
        reader.close();
                super.search(partitions, weight, in);
        reader.close();
            assertThat(collector.getProfiledChildren(), empty());
            assertThat(query.getProfiledChildren().get(0).getTime(), greaterThan(0L));
            }, collector -> {
        context.trackScores(true);
            }
        when(queryShardContext.sourcePath("foo")).thenReturn(Set.of("bar"));
                assertThat(collector.getMinSliceTime(), greaterThan(0L));
        context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));
import org.apache.lucene.store.Directory;
                assertThat(collector.getProfiledChildren().get(0).getMinSliceTime(), greaterThan(0L));
import org.opensearch.core.xcontent.ToXContent;
        searchSortAndFormats.add(new SortAndFormats(new Sort(indexSort.getSort()[0]), new DocValueFormat[] { DocValueFormat.RAW }));
            assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
        assertThat(context.queryResult().topDocs().topDocs.scoreDocs[0].doc, greaterThanOrEqualTo(size));
 * compatible open source license.
import org.opensearch.core.xcontent.XContentBuilder;
        assertEquals(1, context.queryResult().topDocs().topDocs.totalHits.value());
        super.tearDown();
            assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));
        TestSearchContext context = new TestSearchContext(null, indexShard, newContextSearcher(reader, executor));
        reader.close();
                }
                assertThat(query.getProfiledChildren().get(0).getQueryName(), equalTo("BooleanQuery"));
        dir.close();
        IndexWriterConfig iwc = newIndexWriterConfig().setIndexSort(sort);
            assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));
                assertThat(collector.getProfiledChildren().get(0).getAvgSliceTime(), greaterThan(0L));
                assertThat(collector.getProfiledChildren().get(0).getTime(), greaterThan(0L));
        TestSearchContext context = new TestSearchContext(null, indexShard, newContextSearcher(reader, executor));
import org.opensearch.index.shard.IndexShardTestCase;
                .build();
        });
        final int numDocs = scaledRandomIntBetween(600, 900);
        context.setSize(1);
                assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo(7L));
        assertEquals(2, context.queryResult().topDocs().topDocs.scoreDocs.length);
                assertThat(collector.getReason(), equalTo("search_terminate_after_count"));
            assertProfileData(context, "ConstantScoreQuery", query -> {
            assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
            assertThat(collector.getProfiledChildren().get(0).getAvgSliceTime(), greaterThan(0L));
                @Override
                doc.add(new TextField("title", "foo", Store.NO));
            assertThat(collector.getMinSliceTime(), greaterThan(0L));
                assertThat(children.get(1).getTime(), greaterThan(0L));
        }
        }
    private static ContextIndexSearcher newEarlyTerminationContextSearcher(IndexReader reader, int size, ExecutorService executor)
                assertThat(query.getProfiledChildren().get(0).getTimeBreakdown().get("score"), equalTo(0L));
            }, collector -> {
            assertThat(query.getTimeBreakdown().keySet(), not(empty()));
                assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));
            assertThat(collector.getAvgSliceTime(), greaterThan(0L));
                assertThat(query.getTimeBreakdown().get("score_count"), equalTo(0L));
            w.addDocument(new Document());
                    assertThat(maxScore, greaterThan(0L));
            context.trackTotalHitsUpTo(trackTotalHits);
            if (collector.getName().contains("CollectorManager")) {
                if (collector.getName().contains("CollectorManager")) {
                }
                assertThat(query.getTimeBreakdown().get("score_count"), greaterThan(0L));
        }
                assertThat(minScore, greaterThan(0L));
            // IndexSearcher#rewrite optimizes by rewriting non-scoring queries to ConstantScoreQuery
            assertThat(query.getTimeBreakdown().get("score"), greaterThan(0L));
                assertThat(collector.getProfiledChildren(), hasSize(1));
            assertThat(collector.getProfiledChildren().get(0).getTime(), greaterThan(0L));
import org.opensearch.search.profile.SearchProfileShardResults;
            } else {
        assertProfileData(context, "ConstantScoreQuery", query -> {
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);
                long maxScoreCount = query.getTimeBreakdown().get("max_score_count");
            assertThat(collector.getProfiledChildren(), hasSize(0));
        }, collector -> {
        collector.accept(queryProfileShardResult.getCollectorResult());
                    ++collected;
            assertThat(collector.getReason(), equalTo("search_top_hits"));
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(1));
                }
import org.opensearch.search.profile.query.QueryProfileShardResult;
            w.addDocument(doc);
                assertThat(query.getProfiledChildren().get(1).getTimeBreakdown().get("create_weight_count"), equalTo(1L));
            if (i % 2 == 0) {
    public void testSourceFieldMatchQueryWithProfile() throws Exception {
                assertThat(avgScore, equalTo(minScore));
            });
                assertThat(collector.getProfiledChildren().get(0).getMinSliceTime(), greaterThan(0L));
        QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);
        // IndexSearcher#rewrite optimizes by rewriting non-scoring queries to ConstantScoreQuery
                long avgScoreCount = query.getTimeBreakdown().get("avg_score_count");
            FieldDoc lastDoc = (FieldDoc) context.queryResult().topDocs().topDocs.scoreDocs[sizeMinus1];
        assertThat(context.queryResult().getTotalHits().value(), equalTo((long) numDocs));
            assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
    public void testInOrderScrollOptimization() throws Exception {
        assertProfileData(context, "BooleanQuery", query -> {
                    assertThat(query.getTimeBreakdown().get("avg_score_count"), greaterThan(0L));
            assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo(1L));
        assertFalse(Float.isNaN(context.queryResult().getMaxScore()));
            assertThat(query.getProfiledChildren().get(0).getQueryName(), equalTo("TermQuery"));
                assertThat(query.getProfiledChildren().get(1).getTimeBreakdown().get("create_weight"), greaterThan(0L));
            assertEquals(1, context.queryResult().topDocs().topDocs.totalHits.value());
                assertThat(query.getQueryName(), equalTo("ConstantScoreQuery"));
            assertThat(collector.getAvgSliceTime(), greaterThan(0L));
                assertThat(collector.getTime(), greaterThan(0L));
                    assertThat(maxScoreCount, greaterThan(0L));
            }
                assertThat(avgScore, greaterThan(0L));
        );
                        true,
            assertTrue(context.queryResult().terminatedEarly());
            assertThat(query.getTimeBreakdown().keySet(), not(empty()));
        });
    }
                assertThat(avgScore, greaterThan(0L));
                assertThat(query.getQueryName(), equalTo("MinDocQuery"));
                assertThat(collector.getProfiledChildren(), empty());
            assertThat(collector.getProfiledChildren(), hasSize(1));
import org.apache.lucene.index.LeafReaderContext;
        throws IOException {
            });
                assertThat(query.getProfiledChildren(), hasSize(1));
        context.terminateAfter(1);
        for (int i = 0; i < numDocs; i++) {
                    assertThat(collector.getReduceTime(), greaterThan(0L));
        IndexWriterConfig iwc = newIndexWriterConfig().setIndexSort(indexSort);
                    assertThat(collector.getReduceTime(), greaterThan(0L));
                assertThat(children.get(1).getQueryName(), equalTo("TermQuery"));
        this.executor = (concurrency > 0) ? Executors.newFixedThreadPool(concurrency) : null;
        final int numDocs = scaledRandomIntBetween(600, 900);
                assertThat(collector.getMaxSliceTime(), greaterThan(0L));
        assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(3));
            assertThat(query.getTimeBreakdown().get("score_count"), equalTo(0L));
                assertThat(collector.getMinSliceTime(), greaterThan(0L));
            }
            assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo((long) numDocs));
            assertThat(context.terminateAfter(), equalTo(0));
            executor,
        }, collector -> {
            assertThat(collector.getProfiledChildren().get(0).getTime(), greaterThan(0L));
        );
                assertThat(maxScoreCount, equalTo(0L));
        assertThat(fieldDoc.fields[0], equalTo(1));
                assertThat(collector.getReduceTime(), greaterThan(0L));
        context.parsedQuery(
        assertEquals(1, context.queryResult().topDocs().topDocs.totalHits.value());
import java.util.concurrent.ExecutorService;
    ) throws IOException {
                    assertThat(collector.getProfiledChildren().get(0).getProfiledChildren().get(0).getReduceTime(), greaterThan(0L));
            assertThat(query.getProfiledChildren().get(1).getQueryName(), equalTo("TermQuery"));
                assertThat(query.getProfiledChildren().get(0).getQueryName(), equalTo("TermQuery"));
            new Object[] { 5, new ConcurrentQueryPhaseSearcher() }
        TestSearchContext context = new TestSearchContext(null, indexShard, newContextSearcher(reader, executor), scrollContext);
            assertThat(query.getProfiledChildren(), empty());
            assertThat(collector.getReason(), equalTo("search_top_hits"));
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs[0], instanceOf(FieldDoc.class));
        }, collector -> {
                assertThat(avgScoreCount, greaterThan(0L));
            assertThat(query.getTimeBreakdown().get("score_count"), equalTo(0L));
        assertProfileData(context, "ConstantScoreQuery", query -> {
                assertThat(collector.getMaxSliceTime(), greaterThan(0L));
        final IndexReader reader = DirectoryReader.open(dir);
                    assertThat(avgScore, greaterThanOrEqualTo(0L));
            assertThat(query.getTimeBreakdown().get("score_count"), greaterThan(0L));
            });
                    assertThat(minScore, greaterThanOrEqualTo(0L));
                assertThat(query.getProfiledChildren().get(1).getTime(), greaterThan(0L));
            doc.add(new NumericDocValuesField("rank", numDocs - i));
            assertThat(collector.getTime(), greaterThan(0L));
        });
                if (executor != null) {
        context.setSize(1);
        }, collector -> {
        assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo((long) numDocs));
        context.terminateAfter(7);
                assertThat(collector.getProfiledChildren(), empty());
        assertEquals(numDocs / 2, context.queryResult().topDocs().topDocs.totalHits.value());
        final Sort sort = new Sort(new SortField("rank", SortField.Type.INT));
                assertThat(query.getTimeBreakdown().get("avg_score_count"), greaterThanOrEqualTo(5L));
            assertThat(collector.getAvgSliceTime(), greaterThan(0L));
            context.parsedPostFilter(new ParsedQuery(new TermQuery(new Term("foo", Integer.toString(i)))));
                    assertThat(avgScore, greaterThanOrEqualTo(0L));
            assertProfileData(context, "MatchAllDocsQuery", query -> {
            assertThat(collector.getProfiledChildren().get(0).getAvgSliceTime(), greaterThan(0L));
        }, collector -> {
            assertThat(fieldDoc.fields[0], anyOf(equalTo(1), equalTo(2)));
            assertProfileData(context, "BooleanQuery", query -> {
                if (collector.getName().contains("CollectorManager")) {
import static org.hamcrest.Matchers.equalTo;
            assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
                final Collector in = new AssertingEarlyTerminationFilterCollector(collector, size);
                assertThat(collector.getProfiledChildren().get(0).getProfiledChildren().get(0).getMinSliceTime(), greaterThan(0L));
import java.io.OutputStream;
            if (collector.getName().contains("CollectorManager")) {
        for (int i = 0; i < 10; i++) {
        assertProfileData(context, "BooleanQuery", query -> {
                assertThat(collector.getProfiledChildren().get(0).getTime(), greaterThan(0L));
        Directory dir = newDirectory();
            assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
            assertThat(query.getProfiledChildren().get(0).getTimeBreakdown().get("score"), equalTo(0L));
import java.nio.charset.StandardCharsets;
            searchContext
        final int numDocs = scaledRandomIntBetween(600, 900);
        });
            assertThat(query.getTimeBreakdown().get("score_count"), equalTo(0L));
                assertThat(query.getTimeBreakdown().get("min_score_count"), greaterThanOrEqualTo(0L));
        IndexWriterConfig iwc = newIndexWriterConfig().setIndexSort(sort);
            assertNull(context.queryResult().terminatedEarly());
        Directory dir = newDirectory();
            assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
            assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));
    public void testMaxScore() throws Exception {
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs[0], instanceOf(FieldDoc.class));
        w.close();
            assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));
            if (collector.getName().contains("CollectorManager")) {
            assertThat(collector.getMaxSliceTime(), greaterThan(0L));
        QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);
            assertThat(collector.getReason(), equalTo("search_post_filter"));
                assertThat(collector.getMinSliceTime(), greaterThan(0L));
        }
        assertProfileData(context, Arrays.asList(query1, query2), collector, false);
                assertThat(collector.getAvgSliceTime(), greaterThan(0L));
                assertThat(collector.getProfiledChildren().get(0).getReduceTime(), greaterThan(0L));
    public void testPostFilterDisablesCountOptimization() throws Exception {
            assertThat(query.getProfiledChildren().get(0).getTimeBreakdown().get("create_weight_count"), equalTo(1L));
            }, collector -> {
            // see: https://github.com/apache/lucene/pull/672
                assertThat(children.get(0).getQueryName(), equalTo("TermQuery"));
            assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));
            assertThat(collector.getAvgSliceTime(), greaterThan(0L));
            QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);
                assertThat(collector.getReduceTime(), greaterThan(0L));
            assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo(1L));
            assertThat(context.terminateAfter(), equalTo(0));
        w.close();
                assertThat(cmp, equalTo(1));
        }
                assertThat(collector.getMaxSliceTime(), greaterThan(0L));
                assertThat(collector.getReduceTime(), greaterThan(0L));
        assertFalse(Float.isNaN(context.queryResult().getMaxScore()));
        SearchLookup searchLookup = mock(SearchLookup.class);
import org.apache.lucene.analysis.standard.StandardAnalyzer;
        QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(1));
                assertThat(children.get(0).getTime(), greaterThan(0L));
            assertProfileData(context, "ConstantScoreQuery", query -> {
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        {
                assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
                assertThat(query.getProfiledChildren().get(0).getTimeBreakdown().get("create_weight"), greaterThan(0L));
                assertThat(collector.getReason(), equalTo("search_terminate_after_count"));
        context.setSize(0);
                assertThat(collector.getMinSliceTime(), greaterThan(0L));
        SearchContext searchContext = mock(SearchContext.class);
                    assertThat(avgScoreCount, greaterThanOrEqualTo(minScoreCount));
            if (collector.getName().contains("CollectorManager")) {
    }
            assertThat(query.getProfiledChildren().get(0).getTime(), greaterThan(0L));
            Document doc = new Document();
        when(queryShardContext.documentMapper(any())).thenReturn(mockDocumentMapper);
        context.setSearcher(newEarlyTerminationContextSearcher(reader, size, executor));
            Document doc = new Document();
                assertThat(collector.getReason(), equalTo("search_terminate_after_count"));
        assertNull(context.queryResult().terminatedEarly());
import org.opensearch.core.index.Index;
                assertThat(collector.getProfiledChildren().get(0).getProfiledChildren().get(0).getAvgSliceTime(), greaterThan(0L));
                assertThat(query.getTimeBreakdown().get("score"), equalTo(0L));
            assertThat(query.getTimeBreakdown().get("score"), greaterThan(0L));
                assertThat(children.get(0).getTimeBreakdown().get("create_weight_count"), equalTo(1L));
            assertThat(collector.getTime(), greaterThan(0L));
        context.minimumScore(100);
                    queryShardContext
            });
                }
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(1));
                assertThat(collector.getProfiledChildren().get(0).getProfiledChildren().get(0).getSliceCount(), greaterThanOrEqualTo(1));
        final int numDocs = scaledRandomIntBetween(600, 900);
                assertThat(query.getTimeBreakdown().get("create_weight"), greaterThan(0L));
        assertProfileData(context, "TermQuery", query -> {
        assertEquals(1, context.queryResult().topDocs().topDocs.scoreDocs.length);
        }, collector -> {
                assertThat(collector.getProfiledChildren().get(0).getProfiledChildren().get(0).getMaxSliceTime(), greaterThan(0L));
                assertThat(maxScore, greaterThanOrEqualTo(avgScore));
                }
        dir.close();
 */
                new BooleanQuery.Builder().add(new TermQuery(new Term("foo", "bar")), Occur.MUST)
import org.opensearch.index.mapper.SourceFieldMapper;
                if (collector.getName().contains("CollectorManager")) {
        assertTrue(context.queryResult().topDocs().topDocs.totalHits.value() >= 5);
                    ),
        assertProfileData(context, Arrays.asList(query1), collector, false);
                assertThat(avgScore, greaterThanOrEqualTo(minScore));
        assertEquals(2, context.queryResult().topDocs().topDocs.scoreDocs.length);
                doc.add(new TextField("title", "foo bar", Store.NO));
        assertFalse(Float.isNaN(context.queryResult().getMaxScore()));
        SearchOperationListener searchOperationListener = new SearchOperationListener() {
        reader.close();
                assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
        this.queryPhaseSearcher = queryPhaseSearcher;
import org.apache.lucene.search.Sort;
        );
            assertNull(context.queryResult().terminatedEarly());
                assertThat(children.get(1).getTimeBreakdown().get("create_weight_count"), equalTo(1L));
            assertProfileData(context, collector -> {
            if (executor != null) {
            assertThat(query.getProfiledChildren().get(0).getTimeBreakdown().get("create_weight_count"), equalTo(1L));
            assertThat(query.getTimeBreakdown().get("score"), equalTo(0L));
            assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));
                    new PhraseQuery("foo", "bar", "baz"),
        context.minimumScore(0.01f);
    public void testMinScore() throws Exception {
            assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
            assertThat(query.getTimeBreakdown().keySet(), not(empty()));
            QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(1));
                assertThat(query.getProfiledChildren().get(0).getTimeBreakdown().get("create_weight"), greaterThan(0L));
        throws IOException {
            if (collector.getName().contains("CollectorManager")) {
        final int numDocs = scaledRandomIntBetween(600, 900);
                assertThat(collector.getProfiledChildren(), empty());
            });
            }
            assertTrue(context.queryResult().terminatedEarly());
import org.opensearch.threadpool.ThreadPool;
        }
                long minScoreCount = query.getTimeBreakdown().get("min_score_count");
import org.opensearch.search.sort.SortAndFormats;
                assertThat(query.getTimeBreakdown().get("max_score_count"), greaterThanOrEqualTo(6L));
                assertThat(query.getTimeBreakdown().get("score_count"), equalTo(0L));
                    long maxScoreCount = query.getProfiledChildren().get(1).getTimeBreakdown().get("max_score_count");
            assertThat(collector.getMinSliceTime(), greaterThan(0L));
            assertThat(collector.getProfiledChildren().get(0).getSliceCount(), greaterThanOrEqualTo(1));
                assertThat(minScore, greaterThan(0L));
        reader.close();
                assertThat(collector.getAvgSliceTime(), greaterThan(0L));
        });
                    long avgScore = query.getTimeBreakdown().get("avg_score");
                assertThat(collector.getProfiledChildren().get(0).getReason(), equalTo("search_top_hits"));
    @Override
import org.apache.lucene.search.FilterCollector;
                    continue;
            assertThat(collector.getTime(), greaterThan(0L));
                }
        );
        }
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);
                assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));
        reader.close();
        w.addDocument(doc);
                    .add(new TermQuery(new Term("filter", "f1")), Occur.SHOULD)
                assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));
            assertThat(query.getTimeBreakdown().get("score"), greaterThanOrEqualTo(1L));
            assertThat(query.getTimeBreakdown().get("score_count"), equalTo(1L));
                assertThat(query.getProfiledChildren().get(0).getTime(), greaterThan(0L));
                assertThat(collector.getProfiledChildren().get(0).getAvgSliceTime(), greaterThan(0L));
            assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));
            }
            Document doc = new Document();
                    assertThat(collector.getReduceTime(), greaterThan(0L));
                if (collector.getName().contains("CollectorManager")) {
                    assertThat(collector.getReduceTime(), greaterThan(0L));
                assertThat(minScoreCount, greaterThan(0L));
                if (collector.getName().contains("CollectorManager")) {
            QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);
            // see: https://github.com/apache/lucene/pull/672
        w.close();
                assertThat(avgScore, greaterThanOrEqualTo(minScore));
            assertThat(query.getTimeBreakdown().get("score_count"), greaterThanOrEqualTo(6L));
import org.opensearch.search.internal.SearchContext;
            assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));
            final SearchProfileShardResults results = new SearchProfileShardResults(
    private final void assertProfileData(
        for (int i = 0; i < queries.size(); ++i) {
                if (executor != null) {
                assertThat(query.getTimeBreakdown().get("score"), equalTo(0L));
            assertProfileData(context, "MatchAllDocsQuery", query -> {
                }
        {
            assertThat(query.getTimeBreakdown().keySet(), not(empty()));
import java.io.ByteArrayOutputStream;
        reader.close();
            protected void search(LeafReaderContextPartition[] partitions, Weight weight, Collector collector) throws IOException {
        }
            assertThat(collector.getProfiledChildren().get(0).getSliceCount(), greaterThanOrEqualTo(1));
            }
                }
        Consumer<ProfileResult> query2
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(1));
            assertThat(collector.getReason(), equalTo("search_top_hits"));
                    long avgScoreCount = query.getTimeBreakdown().get("avg_score_count");
                }
                assertThat(collector.getAvgSliceTime(), greaterThan(0L));
    }
            assertThat(query.getProfiledChildren().get(0).getTimeBreakdown().get("create_weight_count"), equalTo(1L));
        context.trackTotalHitsUpTo(5);
            assertThat(collector.getProfiledChildren(), empty());
                assertThat(minScoreCount, greaterThan(0L));
        scrollContext.totalHits = null;
                assertThat(query.getTimeBreakdown().get("score"), equalTo(0L));
import org.apache.lucene.search.IndexSearcher;
        assertEquals(topDocsContext.create(null).scoreMode(), org.apache.lucene.search.ScoreMode.COMPLETE);
                    assertThat(query.getTimeBreakdown().get("avg_score"), greaterThan(0L));
        context.terminateAfter(1);
        dir.close();
                    assertThat(maxScoreCount, greaterThanOrEqualTo(0L));
            assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo(1L));
            Document doc = new Document();
                .add(new TermQuery(new Term("foo", "baz")), Occur.SHOULD)
                assertThat(collector.getProfiledChildren().get(0).getMaxSliceTime(), greaterThan(0L));
            assertThat(collector.getMinSliceTime(), greaterThan(0L));
    }
                assertThat(collector.getAvgSliceTime(), greaterThan(0L));
            }
            assertThat(query.getProfiledChildren(), hasSize(2));
            // IndexSearcher#rewrite optimizes by rewriting non-scoring queries to ConstantScoreQuery
            final LeafCollector in = super.getLeafCollector(context);
                    assertThat(maxScoreCount, greaterThanOrEqualTo(avgScoreCount));
    public void setUp() throws Exception {
                assertThat(collector.getReason(), equalTo("search_top_hits"));
                }
                assertThat(collector.getSliceCount(), greaterThanOrEqualTo(1));
        context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));
            IndexSearcher.getDefaultSimilarity(),
                assertThat(collector.getReduceTime(), greaterThan(0L));
            if (randomBoolean()) {
        dir.close();
    }
        context.setSize(2);
        });
                assertThat(collector.getProfiledChildren(), hasSize(1));
        }
import org.opensearch.index.shard.IndexShard;
        TestSearchContext context = new TestSearchContext(queryShardContext, indexShard, newContextSearcher(reader, executor));
            assertThat(collector.getProfiledChildren().get(0).getSliceCount(), greaterThanOrEqualTo(1));
        IndexWriterConfig iwc = newIndexWriterConfig();
                if (collector.getName().contains("CollectorManager")) {
        Document doc = new Document();
    ) throws IOException {
            });
            )
        Directory dir = newDirectory();
            assertThat(collector.getReason(), equalTo("search_top_hits"));
            BooleanQuery bq = new BooleanQuery.Builder().add(new TermQuery(new Term("foo", "bar")), Occur.SHOULD)
                        TextSearchInfo.WHITESPACE_MATCH_ONLY,
            IndexSearcher.getDefaultQueryCachingPolicy(),
                assertThat(collector.getAvgSliceTime(), greaterThan(0L));
        context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));
    @Override
            assertThat(query.getProfiledChildren().get(0).getTime(), greaterThan(0L));
            doc.add(new NumericDocValuesField("rank", random().nextInt()));
                    assertThat(avgScoreCount, greaterThanOrEqualTo(0L));
            assertThat(query.getProfiledChildren().get(0).getTimeBreakdown().get("create_weight"), greaterThan(0L));
            FieldDoc firstDoc = (FieldDoc) context.queryResult().topDocs().topDocs.scoreDocs[0];
            assertThat(collector.getReason(), equalTo("search_top_hits"));
            assertThat(collector.getTime(), greaterThan(0L));
            doc.add(new StringField("foo", "bar", Store.NO));
        when(mockDocumentMapper.sourceMapper()).thenReturn(mockSourceMapper);
        context.trackTotalHitsUpTo(3);
        IndexReader reader = DirectoryReader.open(dir);
            assertThat(collector.getMinSliceTime(), greaterThan(0L));
import org.opensearch.test.TestSearchContext;
        assertFalse(Float.isNaN(context.queryResult().getMaxScore()));
        Directory dir = newDirectory();
                assertThat(maxScore, greaterThan(0L));
            if (executor != null) {
                if (collector.getName().contains("CollectorManager")) {
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);
            assertThat(query.getProfiledChildren().get(1).getTime(), greaterThan(0L));
import java.util.Set;
import static org.hamcrest.Matchers.instanceOf;
            assertThat(collector.getAvgSliceTime(), greaterThan(0L));
            }
        };
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);
                long avgScore = query.getTimeBreakdown().get("avg_score");
            }
import org.opensearch.search.profile.ProfileResult;
        }
                assertThat(collector.getProfiledChildren().get(0).getTime(), greaterThan(0L));
        context.trackTotalHitsUpTo(5);
        for (int i = 0; i < numDocs; i++) {
import org.apache.lucene.search.BooleanClause.Occur;
                assertThat(collector.getTime(), greaterThan(0L));
        context.collapse(new CollapseBuilder("user").build(context.getQueryShardContext()));
            if (collector.getName().contains("CollectorManager")) {
                }
        when(searchContext.indexShard()).thenReturn(indexShard);
                assertThat(collector.getProfiledChildren().get(0).getMinSliceTime(), greaterThan(0L));
                assertThat(children.get(0).getTimeBreakdown().get("score_count"), equalTo(0L));
            assertThat(query.getProfiledChildren().get(1).getTimeBreakdown().get("create_weight_count"), equalTo(1L));
            assertThat(collector.getTime(), greaterThan(0L));
                assertThat(query.getProfiledChildren().get(0).getTime(), greaterThan(0L));
                builder.flush();
    }
            assertThat(query.getProfiledChildren().get(1).getQueryName(), equalTo("TermQuery"));
                long maxScoreCount = query.getTimeBreakdown().get("max_score_count");
            assertThat(collector.getProfiledChildren(), empty());
                }
                assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
            assertTrue(context.queryResult().terminatedEarly());
            if (collector.getName().contains("CollectorManager")) {
            assertThat(collector.getReason(), equalTo("search_count"));
            assertThat(query.getTimeBreakdown().keySet(), not(empty()));
            assertThat(context.queryResult().getTotalHits().value(), equalTo((long) numDocs));
                assertThat(collector.getProfiledChildren().get(0).getSliceCount(), greaterThanOrEqualTo(1));
                assertThat(collector.getReduceTime(), greaterThan(0L));
        IndexWriterConfig iwc = newIndexWriterConfig();
            assertThat(profileResult.getTime(), greaterThan(0L));
            assertThat(query.getTimeBreakdown().get("create_weight_count"), equalTo(1L));
            )
            assertThat(collector.getTime(), greaterThan(0L));
        dir.close();
        // see: https://github.com/apache/lucene/pull/672
            }
            .addClause(new SpanTermQuery(new Term("title", "bar")))
            QueryPhase.executeInternal(context.withCleanQueryResult().withProfilers(), queryPhaseSearcher);
            }
                assertThat(collector.getReduceTime(), greaterThan(0L));
        assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo((long) numDocs));
            w.forceMerge(randomIntBetween(1, 10));
            @Override
            assertThat(collector.getProfiledChildren().get(0).getReason(), equalTo("search_top_hits"));
                }
            assertThat(collector.getMinSliceTime(), greaterThan(0L));
            context.parsedPostFilter(null);
            doc.add(new StringField("filter", "f1" + ((i > 0) ? " " + Integer.toString(i) : ""), Store.NO));
                assertThat(collector.getProfiledChildren(), hasSize(1));
        when(queryShardContext.fieldMapper("user")).thenReturn(
                }
                assertThat(query.getProfiledChildren().get(1).getTimeBreakdown().get("score_count"), greaterThanOrEqualTo(0L));
                assertThat(collector.getMinSliceTime(), greaterThan(0L));
                    long minScore = query.getTimeBreakdown().get("min_score");
            }, collector -> {
            assertThat(collector.getProfiledChildren(), empty());
        w.addDocument(doc);
            assertProfileData(context, "ConstantScoreQuery", query -> {
