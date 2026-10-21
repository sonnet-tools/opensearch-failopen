        when(mapperService.fieldType(fieldNameLong)).thenReturn(fieldTypeLong);
        IndexReader reader = DirectoryReader.open(dir);
            @Override
    public void testMinScore() throws Exception {
            doc.add(new StringField("foo", "bar", Store.NO));
        Query query = new OpenSearchToParentBlockJoinQuery(new MatchAllDocsQuery(), producer, ScoreMode.Avg, "nested");
        final Sort longDateSort = new Sort(sortFieldLong, sortFieldDate);
        }
            QueryPhase.executeInternal(searchContext.withCleanQueryResult(), queryPhaseSearcher);
        );
        IndexReader reader = DirectoryReader.open(dir);
        Query tq = new TermQuery(new Term("foo", "bar"));
        final Sort dateSort = new Sort(sortFieldDate);
        assertEquals(context.queryResult().topDocs().topDocs.totalHits.relation(), TotalHits.Relation.EQUAL_TO);
    }
                    super.collect(doc);
                w.addDocument(doc);
    }
        context.parsedQuery(new ParsedQuery(new MatchAllDocsQuery()));
    public QueryPhaseTests(int concurrency, QueryPhaseSearcher queryPhaseSearcher) {
                    .add(new TermQuery(new Term("filter", "f1")), Occur.SHOULD)
            query = new BooleanQuery.Builder().add(
    }
                    1,
        for (int i = 0; i < numDocs; ++i) {
                assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo(7L));
import org.apache.lucene.search.FilterLeafCollector;
        Document doc = new Document();
        private int totalHits;
            QueryPhase.executeInternal(searchContext.withCleanQueryResult(), queryPhaseSearcher);
            if (randomBoolean()) {
        IndexWriterConfig iwc = newIndexWriterConfig(new StandardAnalyzer());
import static org.hamcrest.Matchers.equalTo;
        @Override
    }
        long initialRelativeCachedTime = threadPool.relativeTimeInMillis();
            doc.add(new NumericDocValuesField("user", i & 1));
        // Always end up with uneven buckets so collapsing is predictable
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs[0], instanceOf(FieldDoc.class));
        boolean checkCachedTimeChanged,
            ? newContextSearcher(reader, executor)
        public LeafCollector getLeafCollector(LeafReaderContext context) throws IOException {
        Directory dir = newDirectory();
        context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));
        assertEquals(2, context.queryResult().topDocs().topDocs.scoreDocs.length);
            w.addDocument(doc);
        assertThat(results.serviceTimeEWMA(), greaterThanOrEqualTo(0L));
        SearchShardTask task = new SearchShardTask(123L, "", "", "", null, Collections.emptyMap());
        }
            }
    }
        assertEquals(TotalHits.Relation.EQUAL_TO, context.queryResult().topDocs().topDocs.totalHits.relation());
            context.setSize(10);
        countTestCase(tq, reader, withDeletions, withDeletions);
            assertTrue(context.queryResult().terminatedEarly());
            when(searchContext.getTargetMaxSliceCount()).thenReturn(randomIntBetween(0, 2));
            QueryPhase.executeInternal(searchContext.withCleanQueryResult(), queryPhaseSearcher);
        TestSearchContext context = new TestSearchContext(null, indexShard, newContextSearcher(reader, executor));
import org.opensearch.test.TestSearchContext;
        private TestTotalHitCountCollectorManager(final Sort sort, final Integer teminateAfter) {
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);
        IndexWriterConfig iwc = newIndexWriterConfig();
            searchContext.setSize(10);
    }
            assertNull(context.queryResult().terminatedEarly());
                    .add(new TermQuery(new Term("filter", "f1")), Occur.SHOULD)
            searchContext.setTask(task);
            )
        long firstValue = randomLongBetween(-10000000L, 10000000L);
        when(mockedSearchContext.getRelativeTimeInMillis()).thenAnswer(invocation -> threadPool.relativeTimeInMillis());
import org.apache.lucene.queries.spans.SpanTermQuery;
import org.opensearch.search.internal.SearchContext;
                assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo(0L));
        closeShards(indexShard);
        assertEquals(countSearcher.count(query), context.queryResult().topDocs().topDocs.totalHits.value());
            }
        for (int i = 0; i < numDocs; i++) {
            }
        }
import static org.mockito.Mockito.when;
            QueryPhase.executeInternal(searchContext.withCleanQueryResult(), queryPhaseSearcher);
        IndexReader reader = DirectoryReader.open(dir);
        long dateValue = randomLongBetween(0, 3000000000000L);
 * this file be licensed under the Apache-2.0 license or a
        final IndexReader reader = DirectoryReader.open(dir);
    public void testIndexSortingEarlyTermination() throws Exception {
 * You may obtain a copy of the License at
        Query q = new SpanNearQuery.Builder("title", true).addClause(new SpanTermQuery(new Term("title", "foo")))
        QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
        }
            assertFalse(context.queryResult().terminatedEarly());
        }
            searchContext.setTask(task);
            context.parsedQuery(new ParsedQuery(new MatchAllDocsQuery()));
        context.setSize(2);
        {
    public void testMaxScoreQueryVisitor() {
            assertSortResults(searchContext.queryResult().topDocs().topDocs, (long) numDocs, false);
            final TopDocs topDocs = searchContext.queryResult().topDocs().topDocs;
import org.opensearch.threadpool.ThreadPool;
        countTestCase(matchAllCsq, reader, false, false);
            }
            } else {
            context.parsedPostFilter(new ParsedQuery(new MinDocQuery(1)));
            searchContext.parsedQuery(query);
                allOf(greaterThanOrEqualTo(1L), lessThanOrEqualTo((long) numDocs))
                doc.add(new StringField("foo", "baz", Store.NO));
 * The OpenSearch Contributors require contributions made to
            assertEquals(numDocs, totalHits.value());
        final String fieldNameLong = "long-field";
        SortAndFormats longDateSortAndFormats = new SortAndFormats(longDateSort, new DocValueFormat[] { DocValueFormat.RAW, dateFormat });
        for (int i = 0; i < numDocs; i++) {
        Query dvfeq_points = new FieldExistsQuery("latLonDVField");
import org.apache.lucene.search.Weight;
        scrollContext.lastEmittedDoc = null;
            return create(executor, null, teminateAfter);
        if (this.executor != null) {
            assertTrue(context.queryResult().terminatedEarly());
        {
import org.apache.lucene.search.ConstantScoreQuery;
        ) {
        Runnable queryTimeoutChecker = QueryPhase.createQueryTimeoutChecker(mockedSearchContext);
            searchContext.sort(longDateSortAndFormats);
        assertThat(context.queryResult().topDocs().topDocs, instanceOf(CollapseTopFieldDocs.class));
        context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));
import org.apache.lucene.search.TotalHitCountCollector;
        context.setSize(1);
import static org.hamcrest.Matchers.instanceOf;
            return create(executor, null, null);
        dir.close();
        assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo((long) numDocs));
        context.setSearcher(newContextSearcher(reader, executor));
        assertEquals(2, context.queryResult().topDocs().topDocs.scoreDocs.length);
        }
    public void testMinScoreDisablesCountOptimization() throws Exception {
            () -> createTimeoutCheckerThenWaitThenRun(timeCacheLifespan, timeCacheLifespan * 2 + timeTolerance, true, false)
    }
            final TestTotalHitCountCollectorManager manager = TestTotalHitCountCollectorManager.create(executor, sort);
        context.parsedQuery(new ParsedQuery(new MatchAllDocsQuery()));
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs[0], instanceOf(FieldDoc.class));
            if (trackTotalHits == -1) {
        context.setSize(10);
            assertThat(cur1, greaterThanOrEqualTo(prev1)); // test that docs are properly sorted on the first sort
        when(searchContext.shouldUseConcurrentSearch()).thenReturn(executor != null);
import org.apache.lucene.document.LongPoint;
        TestSearchContext context = new TestSearchContext(null, indexShard, newContextSearcher(reader, executor));
        context.trackScores(true);
        }
import org.apache.lucene.index.NoMergePolicy;
            int afterDocument = (int) randomLongBetween(0, 50);
        if (checkCachedTimeChanged) {
            Document doc = new Document();
        public TotalHitCountCollector newCollector() throws IOException {
import org.apache.lucene.search.join.ScoreMode;
        final Sort indexSort = new Sort(new SortField("rank", SortField.Type.INT), new SortField("tiebreaker", SortField.Type.INT));
        assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(1));
import org.apache.lucene.search.join.BitSetProducer;
        // need to run this test approximately at the start of cached time window
            searchContext.setTask(task);
                );
 * the Apache License, Version 2.0 (the "License"); you may
        assertFalse(Float.isNaN(context.queryResult().getMaxScore()));
            assertThat(fieldDoc.fields[0], anyOf(equalTo(1), equalTo(2)));
            when(searchContext.mapperService()).thenReturn(mapperService);
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs[0], instanceOf(FieldDoc.class));
                context.parsedQuery(new ParsedQuery(prefixQuery));
        w.close();
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(1));
                occur
            assertFalse(hasInfMaxScore(query));
            searchContext
        dir.close();
import org.opensearch.action.search.SearchShardTask;
        IndexShard indexShard = mock(IndexShard.class);
        };
                assertTrue(hasInfMaxScore(query));
                SearchShardTask task = mock(SearchShardTask.class);
        MapperService mapperService = mock(MapperService.class);
        Directory dir = newDirectory();
        scrollContext.maxScore = Float.NaN;
        final IndexReader reader = DirectoryReader.open(dir);
import org.apache.lucene.search.Collector;
            context.setSize(1);
            IndexSearcher.getDefaultQueryCachingPolicy(),
            context.queryCollectorManagers().put(TotalHitCountCollector.class, manager);
        reader.close();
        throws IOException {
        CollapseTopFieldDocs topDocs = (CollapseTopFieldDocs) context.queryResult().topDocs().topDocs;
            w.addDocument(doc);
            when(searchContext.mapperService()).thenReturn(mapperService);
        IndexReader reader = DirectoryReader.open(dir);
        createTimeoutCheckerThenWaitThenRun(timeCacheLifespan / 2, timeCacheLifespan / 2 + timeTolerance, false, true);
            // slices (as the unit of concurrency). To address that, we have to use the shared global state,
        w.close();
    public void testMaxScore() throws Exception {
            assertEquals(-1, scoreDoc.shardIndex);
            IndexSearcher.getDefaultSimilarity(),
            super(in);
import org.apache.lucene.search.Query;
            new NumberFieldType("user", NumberType.INTEGER, true, false, true, true, false, null, Collections.emptyMap())
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(1));
                }
            );
            Document doc = new Document();
import org.apache.lucene.document.StringField;
            assertThat(context.terminateAfter(), equalTo(0));
import static org.hamcrest.Matchers.anyOf;
        }
        reader.close();
        );
            assertEquals(1, context.queryResult().topDocs().topDocs.totalHits.value());
                assertThat(cmp, equalTo(1));
            context.setSearcher(newEarlyTerminationContextSearcher(reader, 10, executor));
        context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);
            this.teminateAfter = teminateAfter;
        assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo((long) numDocs));
        Directory dir = newDirectory();
        TestSearchContext context = new TestSearchContext(queryShardContext, indexShard, newContextSearcher(reader, executor));
import org.apache.lucene.search.IndexSearcher;
        assertThat(topDocs.collapseValues.length, equalTo(2));
            assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo(1L));
            .addClause(new SpanTermQuery(new Term("title", "bar")))
            searchContext.setTask(task);
        Directory dir = newDirectory();
            searchContext.parsedQuery(query);
        assertThat(context.queryResult().topDocs().topDocs, instanceOf(CollapseTopFieldDocs.class));
        Directory dir = newDirectory();
import org.apache.lucene.util.BytesRef;
    }
            final TestTotalHitCountCollectorManager manager = TestTotalHitCountCollectorManager.create(executor);
            when(searchContext.mapperService()).thenReturn(mapperService);
                doc.add(new StringField("foo", sb.toString(), Store.NO));
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(10));
        TestSearchContext context = new TestSearchContext(null, indexShard, searcher);
        assertEquals(1, context.queryResult().topDocs().topDocs.totalHits.value());
        reader.close();
import static org.mockito.Mockito.mock;
            }
        final Sort sort = new Sort(new SortField("rank", SortField.Type.INT));
                new BooleanQuery.Builder().add(new TermQuery(new Term("foo", "bar")), Occur.MUST)
import org.apache.lucene.index.IndexReader;
        }
        verifyNoMoreInteractions(mockedSearchContext);
        w.close();
            super(queryShardContext, indexShard, searcher);
import static org.mockito.Mockito.verifyNoMoreInteractions;
        IndexWriterConfig iwc = newIndexWriterConfig().setIndexSort(sort);
import org.opensearch.common.unit.TimeValue;
        final Sort sort = new Sort(new SortField("user", SortField.Type.INT));
            IndexShard indexShard,
        assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), greaterThanOrEqualTo(6L));
        {
    }
/*
        // 4. Test a sort on date field + long field
        context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));
            Document doc = new Document();
            when(searchContext.getTargetMaxSliceCount()).thenThrow(IllegalStateException.class);
        private final Integer teminateAfter;
        // tests with trackTotalHits and terminateAfter
        SortAndFormats sortAndFormats = new SortAndFormats(sort, new DocValueFormat[] { DocValueFormat.RAW, DocValueFormat.RAW });
            w.close();
            context.setSize(1);
            context.setConcurrentSegmentSearchEnabled(true);
                assertFalse(hasInfMaxScore(query));
        assertThat(topDocs.collapseValues[0], equalTo(0L)); // user == 0
                new BooleanQuery.Builder().add(new TermQuery(new Term("foo", "bar")), Occur.MUST)
            for (int i = 0; i < searchSortAndFormat.sort.getSort().length; i++) {
        when(searchContext.bucketCollectorProcessor()).thenReturn(SearchContext.NO_OP_BUCKET_COLLECTOR_PROCESSOR);
        long longValue = firstValue;
            context.queryCollectorManagers().put(TotalHitCountCollector.class, manager);
        assertTrue(context.queryResult().topDocs().topDocs.totalHits.value() >= 5);
        // should not throw time exceed exception after timeCacheLifespan+timeTolerance because new cached time - init time < timeout
        }
    public void testCollapseQuerySearchResults() throws Exception {
    }
import org.apache.lucene.index.DirectoryReader;
 * software distributed under the License is distributed on an
            // much as HitsThresholdChecker does.
        context.parsedQuery(new ParsedQuery(new MatchAllDocsQuery()));
        Query dvfeqCsq = new ConstantScoreQuery(dvfeq);
        long sleepAfterCreation,
    public void tearDown() throws Exception {
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        assertThat(context.queryResult().topDocs().topDocs, instanceOf(CollapseTopFieldDocs.class));
        QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
            context.queryCollectorManagers().clear();
            doc.add(new NumericDocValuesField("user", i & 1));
            new Object[] { 0, QueryPhase.DEFAULT_QUERY_PHASE_SEARCHER },
import org.apache.lucene.document.TextField;
import java.util.Collections;
            doc.add(new StringField("foo", "bar", Store.NO));
 * Unless required by applicable law or agreed to in writing,
import java.util.concurrent.ExecutorService;
 * compatible open source license.
                new BooleanQuery.Builder().add(
                allOf(greaterThanOrEqualTo(1L), lessThanOrEqualTo((long) numDocs))
import static org.hamcrest.Matchers.greaterThan;
    ) throws Exception {
        assertThat(context.queryResult().topDocs().topDocs.scoreDocs[0], instanceOf(FieldDoc.class));
        SearchContext searchContext = mock(SearchContext.class);
            searchContext.setTask(task);
    public void testCountWithoutDeletions() throws Exception {
        assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo((long) numDocs));
            if (occur == Occur.MUST) {
        assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo((long) numDocs));
            context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));
                    allOf(greaterThanOrEqualTo(Math.min(trackTotalHits, 10L)), lessThanOrEqualTo((long) numDocs))
        Sort scoreSort = new Sort(new SortField(null, SortField.Type.SCORE), new SortField(null, SortField.Type.DOC));
    public void testMaxScoreWithSortOnScoreFirstly() throws Exception {
import org.apache.lucene.tests.index.RandomIndexWriter;
            QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
        final IndexReader reader = DirectoryReader.open(dir);
            searchContext.sort(dateSortAndFormats);
            QueryPhase.TimeExceededException.class,
            ? newContextSearcher(reader, executor)
        long timeToAlignTimeWithCachedTimeOffset = timeCacheLifespan - currentTimeDiffWithCachedTime + timeTolerance;
            searchContext.sort(dateLongSortAndFormats);
        Query tCsq = new ConstantScoreQuery(tq);
import org.apache.lucene.search.SortField;
    }
    private static ContextIndexSearcher newContextSearcher(IndexReader reader, ExecutorService executor) throws IOException {
 * license agreements. See the NOTICE file distributed with
    private IndexShard indexShard;
            doc.add(new NumericDocValuesField("rank", numDocs - i));
        long cur1, cur2;
                doc.add(new TextField("title", "foo bar", Store.NO));
        assertThat(context.queryResult().topDocs().topDocs, instanceOf(CollapseTopFieldDocs.class));
            assertEquals(TotalHits.Relation.EQUAL_TO, totalHits.relation());
            ).build();
    }
        topDocsContext = TopDocsCollectorContext.createTopDocsCollectorContext(context, false);
            w.addDocument(doc);
        when(indexShard.getSearchOperationListener()).thenReturn(searchOperationListener);
        SearchOperationListener searchOperationListener = new SearchOperationListener() {
import org.apache.lucene.index.LeafReaderContext;
        ParsedQuery query = new ParsedQuery(new MatchAllDocsQuery());
        context.sort(new SortAndFormats(sort, new DocValueFormat[] { DocValueFormat.RAW }));
                Document doc = new Document();
                context.queryResult().topDocs().topDocs.totalHits.value(),
            QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
        IndexWriterConfig iwc = newIndexWriterConfig().setIndexSort(sort);
        context.parsedQuery(new ParsedQuery(new TermQuery(new Term("foo", "bar"))));
    }
        return Arrays.asList(
            TestSearchContext searchContext = spy(new TestSearchContext(null, indexShard, newContextSearcher(reader, executor)));
        context.setSize(0);
import static org.mockito.Mockito.atLeastOnce;
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);
    }
import java.util.concurrent.TimeUnit;
            searchContext.setSize(10);
        }
        reader.close();
import org.opensearch.index.mapper.NumberFieldMapper.NumberType;
        createTimeoutCheckerThenWaitThenRun(timeCacheLifespan, timeCacheLifespan + timeTolerance, true, false);
            // concurrent collector. In this case, in general, the number of results are multiplied by the number of
        context.setSearcher(newEarlyTerminationContextSearcher(reader, size, executor));
            if (executor == null) {
        ContextIndexSearcher countSearcher = shouldCollectCount
        context.parsedQuery(
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);
                cur2 = (long) ((FieldDoc) scoreDoc).fields[1];
            when(searchContext.mapperService()).thenReturn(mapperService);
        when(mapperService.fieldType(fieldNameDate)).thenReturn(fieldTypeDate);
        assertThat(context.queryResult().topDocs().topDocs.scoreDocs[0].doc, greaterThanOrEqualTo(size));
        assertFalse(Float.isNaN(context.queryResult().getMaxScore()));
        countTestCase(false);
            doc.add(new LongPoint(fieldNameDate, dateValue));
    }
        this.executor = (concurrency > 0) ? Executors.newFixedThreadPool(concurrency) : null;
            super(sort);
            executor,
            context.trackTotalHitsUpTo(trackTotalHits);
        for (int i = 0; i < numDocs; i++) {
        context.terminateAfter(10);
            executor,
        Sort sort = new Sort(new SortField(null, SortField.Type.SCORE), new SortField(null, SortField.Type.DOC));
            );
            context.parsedQuery(new ParsedQuery(bq));
import org.apache.lucene.search.MatchAllDocsQuery;
                ).build(),
            doc.add(new StringField("filter", "f1" + ((i > 0) ? " " + Integer.toString(i) : ""), Store.NO));
        List<SortAndFormats> searchSortAndFormats = new ArrayList<>();
        countTestCase(dvfeq, reader, withDeletions, true);
            }
        IndexWriterConfig iwc = newIndexWriterConfig().setMergePolicy(NoMergePolicy.INSTANCE);
            }
        final int numDocs = 2 * scaledRandomIntBetween(600, 900) - 1;
            QueryPhase.executeInternal(searchContext.withCleanQueryResult(), queryPhaseSearcher);
 * under the License.
    private static class TestTotalHitCountCollectorManager extends TotalHitCountCollectorManager {
        final Sort dateLongSort = new Sort(sortFieldDate, sortFieldLong);
        context.parsedQuery(new ParsedQuery(new MatchAllDocsQuery()));
        for (int i = 0; i < numDocs; ++i) {
                    context.queryResult().topDocs().topDocs.totalHits.value(),
        // 2. Test a sort on long field + date field
import org.apache.lucene.search.TotalHits;
        QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
import org.opensearch.search.DocValueFormat;
        // enough docs to have a tree with several leaf nodes
        context.terminateAfter(1);
            }
        IndexShard indexShard = mock(IndexShard.class);
        for (int i = 0; i < 10; i++) {
        );
        for (int i = 0; i < numDocs; ++i) {
                    null,
        context.minimumScore(0.01f);
            w.addDocument(doc);
    }
        }
            searchContext.setTask(task);
            assertTrue(context.queryResult().terminatedEarly());
            TestSearchContext searchContext = spy(new TestSearchContext(null, indexShard, newContextSearcher(reader, executor)));
                StringBuilder sb = new StringBuilder();
            QueryShardContext queryShardContext,
            assertThat(manager.getTotalHits(), equalTo(1));
import org.apache.lucene.document.NumericDocValuesField;
        dir.close();
            when(searchContext.getTargetMaxSliceCount()).thenReturn(randomIntBetween(0, 2));
public class QueryPhaseTests extends IndexShardTestCase {
 * GitHub history for details.
        final Sort sort = new Sort(new SortField("rank", SortField.Type.INT));
        Document doc = new Document();
        static TestTotalHitCountCollectorManager create(final ExecutorService executor, final Sort sort) {
        if (withDeletions) {
        context.setSize(2);
import org.apache.lucene.search.FieldExistsQuery;
            searchContext.from(5);
        assertEquals(numDocs / 2, context.queryResult().topDocs().topDocs.totalHits.value());
 */
        assertThat(topDocs.collapseValues[0], equalTo(0L)); // user == 0
        for (Occur occur : Occur.values()) {
        when(searchContext.bucketCollectorProcessor()).thenReturn(SearchContext.NO_OP_BUCKET_COLLECTOR_PROCESSOR);
        assertEquals(context.queryResult().topDocs().topDocs.totalHits.relation(), TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO);
    private final ExecutorService executor;
        private final int size;
            doc.add(new NumericDocValuesField(fieldNameDate, dateValue));
        SortAndFormats dateLongSortAndFormats = new SortAndFormats(dateLongSort, new DocValueFormat[] { dateFormat, DocValueFormat.RAW });
        context.terminateAfter(7);
        }
                Occur.FILTER
        Directory dir = newDirectory();
import org.opensearch.index.query.QueryShardContext;
        QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
        );
            assertTrue(context.queryResult().terminatedEarly());
        }
            assertNull(context.queryResult().terminatedEarly());
import org.apache.lucene.search.ScoreDoc;
        {
                doc.add(new StringField("foo", "bar", Store.NO));
        context.sort(new SortAndFormats(sort, new DocValueFormat[] { DocValueFormat.RAW }));
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);
        long prev1 = Long.MIN_VALUE;
        super.setUp();
            doc.add(new StringField("foo", "bar", Store.NO));
        assertThat(context.queryResult().getTotalHits().value(), equalTo((long) numDocs));
            new ParsedQuery(
    }
                int cmp = comparator.compareValues(firstDoc.fields[i], lastDoc.fields[i]);
        final Sort sort = new Sort(new SortField("user", SortField.Type.INT));
        QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
        for (int trackTotalHits : new int[] { -1, 3, 76, 100 }) {
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(1));
            context.parsedPostFilter(null);
        {
    }
            for (int i = 0; i < 10; i++) {
        countTestCase(bq, reader, true, true);
            doc.clear();
        context.parsedQuery(new ParsedQuery(query));
            FieldDoc lastDoc = (FieldDoc) context.queryResult().topDocs().topDocs.scoreDocs[sizeMinus1];
            context.setSize(10);
        assertFalse(Float.isNaN(context.queryResult().getMaxScore()));
        context.terminateAfter(1);
        {
        context.setSize(0);
        context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));
        context.parsedPostFilter(new ParsedQuery(new MatchNoDocsQuery()));
        reader.close();
        reader.close();
            searchContext
                assertFalse(hasInfMaxScore(query));
            Document doc = new Document();
        if (topDocs.totalHits.relation() == TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO) {
        }
    public void testCountWithDeletions() throws Exception {
                final Collector in = new AssertingEarlyTerminationFilterCollector(collector, size);
        this.queryPhaseSearcher = queryPhaseSearcher;
        IndexReader reader = DirectoryReader.open(dir);
        context.parsedQuery(
            }
        when(queryShardContext.fieldMapper("user")).thenReturn(
            TestSearchContext searchContext = spy(new TestSearchContext(null, indexShard, newContextSearcher(reader, executor)));
            return (result) -> {};
        context.parsedQuery(
        for (int i = 0; i < 10; i++) {
            QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
        dir.close();
        topDocs = (CollapseTopFieldDocs) context.queryResult().topDocs().topDocs;
            context.queryCollectorManagers().put(TotalHitCountCollector.class, manager);
import static org.mockito.Mockito.verify;
        dir.close();
        } else {
import org.opensearch.index.mapper.DateFieldMapper;
        QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
import java.util.Collection;
                new BooleanQuery.Builder().add(new SpanTermQuery(new Term("field", "foo")), occur)
            query = new BooleanQuery.Builder().add(
        assertThat(context.terminateAfter(), equalTo(0));
 * SPDX-License-Identifier: Apache-2.0
        } else {
 *    http://www.apache.org/licenses/LICENSE-2.0
            } else {
            Document doc = new Document();
            context.trackTotalHitsUpTo(SearchContext.TRACK_TOTAL_HITS_DISABLED);
        static TestTotalHitCountCollectorManager create(final ExecutorService executor, final Sort sort, final Integer teminateAfter) {
    }
            };
            assertSortResults(searchContext.queryResult().topDocs().topDocs, (long) numDocs, true);
        context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));
                context.queryResult().topDocs().topDocs.totalHits.value(),
import org.opensearch.search.internal.ScrollContext;
import org.opensearch.search.sort.SortAndFormats;
        dir.close();
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir, newIndexWriterConfig())) {
            searchContext.sort(longSortAndFormats);
import org.apache.lucene.search.grouping.CollapseTopFieldDocs;
        BooleanQuery bq = new BooleanQuery.Builder().add(matchAll, Occur.SHOULD).add(tq, Occur.MUST).build();
        TestSearchContext context = new TestSearchContext(null, indexShard, newContextSearcher(reader, executor));
            return create(executor, sort, null);
            context.setSize(0);
import org.apache.lucene.search.BooleanQuery;
    private static class AssertingEarlyTerminationFilterCollector extends FilterCollector {
import java.util.Arrays;
            assertEquals(-1, scoreDoc.shardIndex);
            query = new BooleanQuery.Builder().add(
        private TestTotalHitCountCollectorManager(final TotalHitCountCollector collector, final Sort sort) {
import org.apache.lucene.search.FieldComparator;
        }
        IndexReader reader = DirectoryReader.open(dir);
        static TestTotalHitCountCollectorManager create(final ExecutorService executor, final Integer teminateAfter) {
            searchContext.parsedQuery(query);
        assertFalse(Float.isNaN(context.queryResult().getMaxScore()));
        final int numDocs = scaledRandomIntBetween(600, 900);
        }
        }
import static org.mockito.Mockito.times;
        final int numDocs = scaledRandomIntBetween(600, 900);
        MappedFieldType fieldTypeLong = new NumberFieldMapper.NumberFieldType(fieldNameLong, NumberFieldMapper.NumberType.LONG);
        SearchContext searchContext = mock(SearchContext.class);
 * Modifications Copyright OpenSearch Contributors. See
            cur1 = (long) ((FieldDoc) scoreDoc).fields[0];
        w.close();
import org.opensearch.search.collapse.CollapseBuilder;
            context.queryCollectorManagers().put(TotalHitCountCollector.class, manager);
                .build();
import java.util.List;
        };
        DocValueFormat dateFormat = fieldTypeDate.docValueFormat(null, null);
        IndexReader reader = DirectoryReader.open(dir);
        // 1. Test a sort on long field
                    assertThat(cur2, greaterThanOrEqualTo(prev2)); // test that docs are properly sorted on the secondary sort
        assertTrue(Float.isNaN(context.queryResult().getMaxScore()));
        {
        final int numDocs = scaledRandomIntBetween(600, 900);
        assertThat(topDocs.collapseValues[1], equalTo(1L)); // user == 1
        when(searchContext.shouldUseConcurrentSearch()).thenReturn(executor != null);
        assertEquals(topDocsContext.create(null).scoreMode(), org.apache.lucene.search.ScoreMode.COMPLETE);
            doc.add(new LongPoint(fieldNameLong, longValue));
        long timeCacheLifespan = ThreadPool.ESTIMATED_TIME_INTERVAL_SETTING.get(Settings.EMPTY).millis();
            if (teminateAfter != null) {
        Query dvOnlyfeq = new FieldExistsQuery("docValuesOnlyField");
        long timeTolerance = timeCacheLifespan / 20;
    private void countTestCase(Query query, IndexReader reader, boolean shouldCollectSearch, boolean shouldCollectCount) throws Exception {
                allOf(greaterThanOrEqualTo(1L), lessThanOrEqualTo((long) numDocs))
            assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo((long) numDocs));
        }
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(1));
            IndexSearcher.getDefaultQueryCache(),
        query = new OpenSearchToParentBlockJoinQuery(new MatchAllDocsQuery(), producer, ScoreMode.None, "nested");
            assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo((long) numDocs));
                    .build()
        assertEquals(2, context.queryResult().topDocs().topDocs.scoreDocs.length);
            assertTrue(context.queryResult().terminatedEarly());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            reader,
        assertThat(topDocs.collapseValues[0], equalTo(0L)); // user == 0
        context.trackTotalHitsUpTo(5);
            assertNull(context.queryResult().terminatedEarly());
            if (randomBoolean()) {
        QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
            // including total hits collector
import org.opensearch.index.shard.SearchOperationListener;
    }
        w.close();
        assertFalse(Float.isNaN(context.queryResult().getMaxScore()));
            protected void search(LeafReaderContextPartition[] partitions, Weight weight, Collector collector) throws IOException {
            context.queryCollectorManagers().clear();
            w.forceMerge(randomIntBetween(1, 10));
            w.flush();
        @Override
        dir.close();
            final LeafCollector in = super.getLeafCollector(context);
            assertTrue(context.queryResult().terminatedEarly());
        }
            w.addDocument(doc);
        QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
        assertThat(context.queryResult().topDocs().topDocs.scoreDocs[0].score, equalTo(context.queryResult().getMaxScore()));
            BooleanQuery bq = new BooleanQuery.Builder().add(new TermQuery(new Term("foo", "bar")), Occur.SHOULD)
            searchContext.setSize(10);
import org.apache.lucene.index.Term;
            longValue++;
    }
                if (cmp == 0) {
            context.parsedPostFilter(new ParsedQuery(new TermQuery(new Term("foo", Integer.toString(i)))));
        IndexWriterConfig iwc = newIndexWriterConfig();
        Thread.sleep(timeToAlignTimeWithCachedTimeOffset);
        final Sort longSort = new Sort(sortFieldLong);
        reader.close();
            searchContext.parsedQuery(query);
import org.apache.lucene.document.LatLonDocValuesField;
            context.setSize(1);
                doc.add(new StringField("delete", "yes", Store.NO));
                }
        context.setSize(10);
        for (ScoreDoc scoreDoc : context.queryResult().topDocs().topDocs.scoreDocs) {
        context.sort(sortAndFormats);
        assertFalse(Float.isNaN(context.queryResult().getMaxScore()));
        verify(mockedSearchContext, times(1)).getRelativeTimeInMillis(eq(false));
import org.opensearch.core.tasks.TaskCancelledException;
            Document doc = new Document();
            assertThat(
        IndexWriterConfig iwc = newIndexWriterConfig().setIndexSort(sort);
        {
        for (int i = 0; i < numDocs; ++i) {
        public boolean lowLevelCancellation() {
            when(searchContext.getTargetMaxSliceCount()).thenThrow(IllegalStateException.class);
import org.apache.lucene.search.PrefixQuery;
        final int numDocs = 2 * scaledRandomIntBetween(50, 450);
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.search.MultiTermQuery;
            w.addDocument(doc);
    }
        {
        reader.close();
                    .build()
    public void testMaxScoreWithSortOnScoreAndCollapsingResults() throws Exception {
            ).build();
        TestSearchContext context = new TestSearchContext(null, indexShard, newContextSearcher(reader, executor));
        dir.close();
        int size = randomIntBetween(2, 5);
        Directory dir = newDirectory();
                    .build(),
        }
                assertThat(totalHits, greaterThanOrEqualTo(teminateAfter));
            assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo((long) numDocs));
    }
            writer.addDocument(doc);
            prev1 = cur1;
        IndexReader reader = DirectoryReader.open(dir);
        }
        for (int i = 1; i <= numDocs; ++i) {
                context.queryResult().topDocs().topDocs.totalHits.value(),
 *
            FieldDoc after = new FieldDoc(afterDocument, Float.NaN, new Long[] { afterValue });
        // field with doc-values but not indexed will need to collect
        }
        assertEquals(2, context.queryResult().topDocs().topDocs.scoreDocs.length);
}
        long currentTimeDiffWithCachedTime = TimeValue.nsecToMSec(System.nanoTime()) - threadPool.relativeTimeInMillis();
        dir.close();
        super.tearDown();
            QueryPhase.executeInternal(searchContext, queryPhaseSearcher);
            w.addDocument(doc);
            QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
            }
            this.size = size;
import static org.hamcrest.Matchers.allOf;
                new OpenSearchToParentBlockJoinQuery(new MatchAllDocsQuery(), producer, ScoreMode.Avg, "nested"),
            return true;
        assertThrows(
            );
        final Sort sort = new Sort(new SortField("rank", SortField.Type.INT));
            doc.add(new NumericDocValuesField("rank", random().nextInt()));
                assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo(0L));
            QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
                occur
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(1));
            assertThat(manager.getTotalHits(), equalTo(numDocs));
                    ++collected;
        );
        context.collapse(new CollapseBuilder("user").build(context.getQueryShardContext()));
        final String fieldNameDate = "date-field";
import org.apache.lucene.search.FieldDoc;
        IndexWriterConfig iwc = newIndexWriterConfig().setIndexSort(sort);
        context.trackScores(false);
        scrollContext.totalHits = null;
        return new ContextIndexSearcher(
        when(mockedSearchContext.timeout()).thenReturn(TimeValue.timeValueMillis(timeout));
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);
        assertEquals(0, context.queryResult().topDocs().topDocs.totalHits.value());
        reader.close();
        assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo((long) numDocs));
            scrollContext.maxScore = Float.NaN;
            assertTrue(context.queryResult().terminatedEarly());
        Document doc = new Document();
        QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
        }
                expectThrows(TaskCancelledException.class, () -> new QueryPhase().preProcess(context));
        dir.close();
                    occur
        Thread.sleep(sleepAfterCreation);
        for (int trackTotalHits : new int[] { -1, 3, 75, 100 }) {
            QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
        Directory dir = newDirectory();
        // 7. Test that sort optimization works with search after
        }
        SortAndFormats dateSortAndFormats = new SortAndFormats(dateSort, new DocValueFormat[] { dateFormat });
        final int numDocs = 2 * scaledRandomIntBetween(600, 900) - 1;
            assertThat(manager.getTotalHits(), allOf(greaterThanOrEqualTo(1), lessThanOrEqualTo(numDocs)));
import java.util.ArrayList;
import org.apache.lucene.search.TermQuery;
            TestSearchContext searchContext = spy(new TestSearchContext(null, indexShard, newContextSearcher(reader, executor)));
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs[0], instanceOf(FieldDoc.class));
        QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
            searchContext.setSize(10);
        TestSearchContext context = new TestSearchContext(null, indexShard, newContextSearcher(reader, executor));
            assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo(numDocs - 1L));
                doc.add(new SortedSetDocValuesField("foo", new BytesRef("bar")));
import static org.opensearch.search.query.TopDocsCollectorContext.hasInfMaxScore;
        context.trackScores(false);
    private final QueryPhaseSearcher queryPhaseSearcher;
        }
        }
        }
        return Settings.builder().put(super.threadPoolSettings()).put("thread_pool.search.min_queue_size", 10).build();
            ContextIndexSearcher searcher
            } else {
            assertThat(context.queryResult().getTotalHits().value(), equalTo((long) numDocs));
        AssertingEarlyTerminationFilterCollector(Collector in, int size) {
        }
        assertThat(topDocs.collapseValues.length, equalTo(2));
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);
        final int numDocs = 3500 * 5;
    }
                doc.add(new StringField("foo", "baz", Store.NO));
            QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
                ).build(),
            return new FilterLeafCollector(in) {
                prev2 = cur2;
                doc.add(new SortedSetDocValuesField("docValuesOnlyField", new BytesRef("bar")));
 *
            }
        w.addDocument(doc);
                super.search(partitions, weight, in);
        reader.close();
        IndexWriterConfig iwc = newIndexWriterConfig().setIndexSort(sort);
        context.sort(new SortAndFormats(new Sort(new SortField("other", SortField.Type.INT)), new DocValueFormat[] { DocValueFormat.RAW }));
        assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo((long) numDocs));
            }
        IndexReader reader = DirectoryReader.open(dir);
        assertEquals(1, context.queryResult().topDocs().topDocs.scoreDocs.length);
            final TestTotalHitCountCollectorManager manager = TestTotalHitCountCollectorManager.create(executor, 1);
                doc.add(new LatLonDocValuesField("latLonDVField", 1.0, 1.0));
        verify(mockedSearchContext, atLeastOnce()).getRelativeTimeInMillis();
            true,
        final int numDocs = scaledRandomIntBetween(600, 900);
        assertThat(topDocs.collapseValues[1], equalTo(1L)); // user == 1
            doc.add(new NumericDocValuesField(fieldNameLong, longValue));
            TestSearchContext searchContext = spy(new TestSearchContext(null, indexShard, newContextSearcher(reader, executor)));
                doc.add(new StringField("foo", "bar", Store.NO));
        }
        context.trackScores(false);
                    occur
        }
    }
        TestSearchContext context = new TestSearchContext(null, indexShard, newContextSearcher(reader, executor));
                occur
            new NumberFieldType("user", NumberType.INTEGER, true, false, true, false, false, null, Collections.emptyMap())
    public void testTerminateAfterEarlyTermination() throws Exception {
        if (executor != null) {
            QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
            totalHits = collectors.stream().mapToInt(TotalHitCountCollector::getTotalHits).sum();
        assertThat(context.queryResult().topDocs().topDocs, instanceOf(CollapseTopFieldDocs.class));
        for (ScoreDoc scoreDoc : context.queryResult().topDocs().topDocs.scoreDocs) {
        // search sort is a prefix of the index sort
                PrefixQuery prefixQuery = new PrefixQuery(new Term("foo", "a"), MultiTermQuery.SCORING_BOOLEAN_REWRITE);
        assertEquals(1, context.queryResult().topDocs().topDocs.scoreDocs.length);
    public void testQueryCapturesThreadPoolStats() throws Exception {
        }
    public void testEnhanceSortOnNumeric() throws Exception {
            assertThat(fieldDoc.fields[0], anyOf(equalTo(1), equalTo(2)));
        assertThat(topDocs.collapseValues[0], equalTo(0L)); // user == 0
        dir.close();
            context.setSize(1);
                doc.add(new SortedSetDocValuesField("foo", new BytesRef("baz")));
        assertTrue(Float.isNaN(context.queryResult().getMaxScore()));
            assertEquals(-1, scoreDoc.shardIndex);
        for (ScoreDoc scoreDoc : context.queryResult().topDocs().topDocs.scoreDocs) {
        );
 */
        assertThat(topDocs.collapseValues[0], equalTo(0L)); // user == 0
                .add(new TermQuery(new Term("foo", "baz")), Occur.SHOULD)
            doc.add(new StringField("foo", "bar", Store.NO));
        Query dvfeq = new FieldExistsQuery("foo");
            IndexSearcher.getDefaultQueryCachingPolicy(),
            // The concurrent search terminates the collection when the number of hits is reached by each
            ).build();
            equalTo(context.queryResult().getMaxScore())
            this.teminateAfter = null;
                    assert collected <= size : "should not collect more than " + size + " doc per segment, got " + collected;
        QueryShardContext queryShardContext = mock(QueryShardContext.class);
        Directory dir = newDirectory();
        TestSearchContext context = new TestSearchContext(null, indexShard, newEarlyTerminationContextSearcher(reader, 0, executor));
        QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
            QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
                totalHits = Math.min(totalHits, teminateAfter);
import org.apache.lucene.document.LatLonPoint;
    }
import org.apache.lucene.document.Document;
        SortAndFormats sortAndFormats = new SortAndFormats(scoreSort, new DocValueFormat[] { DocValueFormat.RAW, DocValueFormat.RAW });
            dateValue++;
        return new ContextIndexSearcher(
                    newContextSearcher(reader, executor)
            assertThat(fieldDoc.fields[0], anyOf(equalTo(1), equalTo(2)));
        writer.close();
            assertSortResults(searchContext.queryResult().topDocs().topDocs, (long) numDocs, true);
        assertThat(topDocs.collapseValues.length, equalTo(2));
            // returning a ReduceableSearchResult modifies the QueryResult which is not expected
        assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(3));
        w.close();
    public void testTerminateAfterWithFilter() throws Exception {
        w.close();
 *
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);
        private final TotalHitCountCollector collector;
            // this collector should not participate in reduce as it is added for test purposes to capture the totalHits count
        context.parsedQuery(new ParsedQuery(new MatchAllDocsQuery()));
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);
import org.apache.lucene.store.Directory;
            searchContext.sort(longSortAndFormats);
            w.addDocument(doc);
            assertNotEquals(initialRelativeCachedTime, threadPool.relativeTimeInMillis());
        IndexWriterConfig iwc = newIndexWriterConfig().setIndexSort(indexSort);
        final int numDocs = scaledRandomIntBetween(600, 900);
                assertThat(
            long topValue = (long) ((FieldDoc) topDocs.scoreDocs[0]).fields[0];
import org.apache.lucene.search.FilterCollector;
        dir.close();
        } else {
            FieldDoc firstDoc = (FieldDoc) context.queryResult().topDocs().topDocs.scoreDocs[0];
                searcher().rewrite(query());
            QueryPhase.executeInternal(searchContext, queryPhaseSearcher);
            context.sort(searchSortAndFormat);
                @SuppressWarnings("unchecked")
    @Override
    private static ContextIndexSearcher newEarlyTerminationContextSearcher(IndexReader reader, int size, ExecutorService executor)
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);
        countTestCase(true);
            QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
        sortFieldLong.setMissingValue(Long.MAX_VALUE);
        Query matchAll = new MatchAllDocsQuery();
            context.setSearcher(newEarlyTerminationContextSearcher(reader, 1, executor));
        {
            } else {
            TestSearchContext searchContext = spy(new TestSearchContext(null, indexShard, newContextSearcher(reader, executor)));
        countTestCase(dvOnlyfeq, reader, true, true);
import org.opensearch.index.mapper.NumberFieldMapper.NumberFieldType;
import java.io.IOException;
        }
import org.apache.lucene.document.SortedSetDocValuesField;
import org.opensearch.index.mapper.MappedFieldType;
        }
import org.opensearch.common.settings.Settings;
            assertThat(
            assertThat(context.terminateAfter(), equalTo(0));
        ) {
            searchContext.parsedQuery(query);
    }
        queryTimeoutChecker.run();
import org.apache.lucene.queries.spans.SpanNearQuery;
    public void testDisableTopScoreCollection() throws Exception {
        FieldDoc fieldDoc = (FieldDoc) context.queryResult().topDocs().topDocs.scoreDocs[0];
    private void assertSortResults(TopDocs topDocs, long expectedNumDocs, boolean isDoubleSort) {
            )
            assertThat(context.queryResult().getTotalHits().value(), equalTo((long) numDocs));
    public void testInOrderScrollOptimization() throws Exception {
        assertThat(fieldDoc.fields[0], equalTo(1));
        // make sure next time slot become available
        IndexReader reader = DirectoryReader.open(dir);
        @Override
            }
 */
        context.trackTotalHitsUpTo(5);
                return new TestTotalHitCountCollectorManager(sort, teminateAfter);
            Document doc = new Document();
        assertThat(topDocs.collapseValues[1], equalTo(1L)); // user == 1
                assertTrue(hasInfMaxScore(query));
                doc.add(new LatLonPoint("latLonDVField", 1.0, 1.0));
            try (IndexReader reader = DirectoryReader.open(dir)) {
    }
            TestSearchContext context = new TestSearchContext(null, indexShard, newContextSearcher(reader, executor), scrollContext);
        for (SortAndFormats searchSortAndFormat : searchSortAndFormats) {
        topDocs = (CollapseTopFieldDocs) context.queryResult().topDocs().topDocs;
            assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo((long) numDocs));
                if (cur1 == prev1) {
    }
            doc.add(new StringField("filter", "f1" + ((i > 0) ? " " + i : ""), Store.NO));
            assertSortResults(searchContext.queryResult().topDocs().topDocs, (long) numDocs, false);
            assertThat(topValue, greaterThan(afterValue));
        ContextIndexSearcher searcher = shouldCollectSearch
        context.trackTotalHitsUpTo(5);
            assertThat(topDocs.totalHits.value(), lessThanOrEqualTo(expectedNumDocs));
        for (int i = 0; i < numDocs; i++) {
                new BooleanQuery.Builder().add(
            final TotalHits totalHits = topDocs.totalHits;
            // https://issues.apache.org/jira/browse/LUCENE-10620 can produce a total hit count >= terminated_after, because
        final IndexReader reader = w.getReader();
            try {
            context.setSize(0);
            this.collector = null;
import org.opensearch.index.shard.IndexShard;
        context.sort(new SortAndFormats(sort, new DocValueFormat[] { DocValueFormat.RAW }));
        Query matchAllCsq = new ConstantScoreQuery(matchAll);
            searchContext.sort(longSortAndFormats);
        ScrollContext scrollContext = new ScrollContext();
            if (executor == null) {
import static org.mockito.Mockito.spy;
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);
        assertThat(context.queryResult().topDocs().topDocs.scoreDocs[0].score, equalTo(context.queryResult().getMaxScore()));
        assertThat(topDocs.collapseValues.length, equalTo(2));
    public static Collection<Object[]> concurrency() {
        assertEquals(1, context.queryResult().topDocs().topDocs.totalHits.value());
            if (occur == Occur.MUST) {
        }
        context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));
        IndexWriterConfig iwc = newIndexWriterConfig().setIndexSort(sort);
        context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));
        context.minimumScore(100);
            IndexSearcher.getDefaultSimilarity(),
        }
            assertEquals(initialRelativeCachedTime, threadPool.relativeTimeInMillis());
            new ParsedQuery(
        {
        w.close();
    public void testPostFilterDisablesCountOptimization() throws Exception {
        // Always end up with uneven buckets so collapsing is predictable
        }
    // assert score docs are in order and their number is as expected
        final SortField sortFieldLong = new SortField(fieldNameLong, SortField.Type.LONG);
        if (executor != null) {
            }
            final TestTotalHitCountCollectorManager manager = TestTotalHitCountCollectorManager.create(executor, 1);
        w.close();
        Directory dir = newDirectory();
        context.trackTotalHitsUpTo(5);
            context.parsedQuery(new ParsedQuery(bq));
            Document doc = new Document();
            } else {
        long timeout,
        long prev2 = Long.MIN_VALUE;
        }
            if (trackTotalHits == -1) {
            reader,
        Document doc = new Document();
            when(searchContext.mapperService()).thenReturn(mapperService);
            doc.add(new StringField("foo", "bar", Store.NO));
        QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
        }
        }
            w.addDocument(new Document());
        }
        }
    public void setUp() throws Exception {
        context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));
            return (collector == null) ? super.newCollector() : collector;
                    sb.append('a');
package org.opensearch.search.query;
            QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
        context.parsedQuery(new ParsedQuery(new MatchAllDocsQuery()));
            }
        dir.close();
        }
            ScrollContext scrollContext = new ScrollContext();
        context.parsedQuery(new ParsedQuery(new TermQuery(new Term("foo", "bar"))));
        final SortField sortFieldDate = new SortField(fieldNameDate, SortField.Type.LONG);
        for (int i = 0; i < 10; i++) {
        SearchOperationListener searchOperationListener = new SearchOperationListener() {
            )
            }
            this.collector = collector;
 * Licensed to Elasticsearch under one or more contributor
            doc.add(new StringField("filter", "f1", Store.NO));
                FieldComparator<Object> comparator = (FieldComparator<Object>) searchSortAndFormat.sort.getSort()[i].getComparator(
            .build();
        TopDocsCollectorContext topDocsContext = TopDocsCollectorContext.createTopDocsCollectorContext(context, false);
        IndexWriterConfig iwc = newIndexWriterConfig();
        reader.close();
        assertEquals(1, context.queryResult().topDocs().topDocs.scoreDocs.length);
        static TestTotalHitCountCollectorManager create(final ExecutorService executor) {
        final Sort sort = new Sort(new SortField("filter", SortField.Type.STRING));
        long timeTolerance = timeCacheLifespan / 20;
import org.apache.lucene.search.Pruning;
        context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));
        if (checkCachedTimeHasNotChanged) {
    private void countTestCase(boolean withDeletions) throws Exception {
        }
            w.addDocument(doc);
            context.trackTotalHitsUpTo(trackTotalHits);
            searchContext.searchAfter(after);
        context.setSize(3);
                    new OpenSearchToParentBlockJoinQuery(new MatchAllDocsQuery(), producer, ScoreMode.Avg, "nested"),
    @ParametersFactory
        context.sort(new SortAndFormats(sort, new DocValueFormat[] { DocValueFormat.RAW }));
        context.sort(sortAndFormats);
        TestSearchContext context = new TestSearchContext(queryShardContext, indexShard, newContextSearcher(reader, executor));
import org.apache.lucene.document.Field.Store;
                new BooleanQuery.Builder().add(new TermQuery(new Term("foo", "bar")), Occur.MUST)
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(1));
            QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
            doc.add(new StringField("foo", Integer.toString(i), Store.NO));
        w.addDocument(doc);
            scrollContext.totalHits = null;
            assertNull(context.queryResult().terminatedEarly());
        long timeCacheLifespan = ThreadPool.ESTIMATED_TIME_INTERVAL_SETTING.get(Settings.EMPTY).millis();
        reader.close();
                public void collect(int doc) throws IOException {
            assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo(1L));
        Directory dir = newDirectory();
        IndexWriterConfig iwc = newIndexWriterConfig().setIndexSort(sort);
 * specific language governing permissions and limitations
                doc.add(new StringField("foo", "baz", Store.NO));
            w.addDocument(doc);
            } else {
            assertEquals(topDocs.totalHits.value(), expectedNumDocs);
                @Override
            QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
        }
        }
            searchContext.sort(longSortAndFormats);
        IndexReader reader = DirectoryReader.open(dir);
        Directory dir = newDirectory();
            assertSortResults(searchContext.queryResult().topDocs().topDocs, (long) numDocs, false);
        assertThat(topDocs.collapseValues[1], equalTo(1L)); // user == 1
                    indexShard,
                assertTrue(hasInfMaxScore(query));
            }
        QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
        context.trackScores(true);
            QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
        indexShard = newShard(true);
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(1));
            if (randomBoolean()) {
            searchContext.setSize(0);
import static org.mockito.ArgumentMatchers.eq;
        context.parsedQuery(new ParsedQuery(new MatchAllDocsQuery()));
            assertNull(context.queryResult().terminatedEarly());
            ).build();
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(7));
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(0));
        assertEquals(2, context.queryResult().topDocs().topDocs.scoreDocs.length);
        {
        assertEquals(topDocsContext.create(null).scoreMode(), org.apache.lucene.search.ScoreMode.TOP_DOCS);
    }
        context.setSize(0);
            super(sort);
            ThreadPool.terminate(executor, 10, TimeUnit.SECONDS);
        SearchContext mockedSearchContext = mock(SearchContext.class);
    public void testQueryTimeoutChecker() throws Exception {
/*
import org.opensearch.lucene.queries.MinDocQuery;
        countTestCase(dvfeq_points, reader, withDeletions, true);
            if (randomBoolean()) {
            query = new BooleanQuery.Builder().add(
        assertThat(topDocs.collapseValues[1], equalTo(1L)); // user == 1
            context.queryCollectorManagers().put(TotalHitCountCollector.class, manager);
        // 3. Test a sort on date field
        assertThat(
        IndexWriterConfig iwc = newIndexWriterConfig();
        QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
        }
            int sizeMinus1 = context.queryResult().topDocs().topDocs.scoreDocs.length - 1;
        assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo((long) numDocs));
            if (randomBoolean()) {
    public void testCancellationDuringPreprocess() throws IOException {
        }
        when(indexShard.getSearchOperationListener()).thenReturn(searchOperationListener);
            }
            } catch (IOException e) {
        countTestCase(dvfeqCsq, reader, withDeletions, true);
        assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), greaterThanOrEqualTo(6L));
        SortAndFormats longSortAndFormats = new SortAndFormats(longSort, new DocValueFormat[] { DocValueFormat.RAW });
        for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
            searchContext.setTask(task);
        final boolean rescore = QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
        for (int i = 0; i < numDocs; ++i) {
        private TestSearchContextWithRewriteAndCancellation(
import org.opensearch.index.mapper.MapperService;
import org.apache.lucene.search.TopDocs;
    }
        reader.close();
        context.setSize(1);
        assertFalse(hasInfMaxScore(query));
import org.opensearch.index.mapper.NumberFieldMapper;
        verify(mockedSearchContext, times(1)).timeout();
        BitSetProducer producer = context -> new FixedBitSet(1);
        QuerySearchResult results = context.queryResult();
        assertEquals(1, context.queryResult().topDocs().topDocs.scoreDocs.length);
        w.close();
        QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
        assertThat(results.nodeQueueSize(), greaterThanOrEqualTo(0));
        QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
        );
                fail("IOException shouldn't be thrown");
        TestSearchContext context = new TestSearchContext(null, indexShard, newContextSearcher(reader, executor));
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(0));
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            new ParsedQuery(
            assertSortResults(topDocs, (long) numDocs, false);
        QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
        searchSortAndFormats.add(new SortAndFormats(new Sort(indexSort.getSort()[0]), new DocValueFormat[] { DocValueFormat.RAW }));
            w.addDocument(new Document());
            ((FieldDoc) context.queryResult().topDocs().topDocs.scoreDocs[0]).fields[0],
                doc.add(new TextField("title", "foo", Store.NO));
        assertFalse(rescore);
        final int numDocs = scaledRandomIntBetween(600, 900);
    }
        assertThat(context.queryResult().getTotalHits().value(), equalTo((long) numDocs));
            assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo(1L));
        final IndexReader reader = DirectoryReader.open(dir);
        {
        {
            TestSearchContext searchContext = spy(new TestSearchContext(null, indexShard, newContextSearcher(reader, executor)));
        context.setSize(1);
        w.close();
        // 6. Test that sort optimization works with from = 0 and size= 0
        IndexWriterConfig iwc = newIndexWriterConfig().setIndexSort(sort);
                context.setTask(task);
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);
        searchSortAndFormats.add(new SortAndFormats(indexSort, new DocValueFormat[] { DocValueFormat.RAW, DocValueFormat.RAW }));
                int collected;
        when(mockedSearchContext.getRelativeTimeInMillis(eq(false))).thenCallRealMethod();
            IndexSearcher.getDefaultQueryCache(),
        }
            searchContext.setSize(0);
            long afterValue = firstValue + afterDocument;
            assertThat(manager.getTotalHits(), lessThanOrEqualTo(numDocs));
            }
        context.trackScores(false);
                    .add(new OpenSearchToParentBlockJoinQuery(new MatchAllDocsQuery(), producer, ScoreMode.Avg, "nested"), occur)
            true,
        }
            } else {
            searchContext.parsedQuery(query);
        countTestCase(tCsq, reader, withDeletions, withDeletions);
        reader.close();
import org.apache.lucene.search.MatchNoDocsQuery;
            : newEarlyTerminationContextSearcher(reader, 0, executor);
                );
        reader.close();
        reader.close();
            searchContext.parsedQuery(query);
        context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));
        // 5. Test that sort optimization is run when from > 0 and size = 0
        when(searchContext.indexShard()).thenReturn(indexShard);
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(1));
        Directory dir = newDirectory();
    }
import org.apache.lucene.document.SortedDocValuesField;
            // When searching concurrently, each executors short-circuits when "size" is reached,
        // should not throw time exceed exception after timeout < timeCacheLifespan when cached time didn't change
        }
        dir.close();
            if (withDeletions && (rarely() || i == 0)) {
            }
        context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));
        Directory dir = newDirectory();
        public ReduceableSearchResult reduce(Collection<TotalHitCountCollector> collectors) throws IOException {
                    Pruning.NONE
            assertThat(fieldDoc.fields[0], anyOf(equalTo(1), equalTo(2)));
        );
        assertFalse(Float.isNaN(context.queryResult().getMaxScore()));
        }
                    .build()
        assertNull(context.queryResult().terminatedEarly());
            final TestTotalHitCountCollectorManager manager = TestTotalHitCountCollectorManager.create(executor);
import org.opensearch.search.internal.ContextIndexSearcher;
        );
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);
            assertTrue(context.queryResult().terminatedEarly());
            QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
import org.apache.lucene.search.LeafCollector;
        createTimeoutCheckerThenWaitThenRun(timeCacheLifespan / 4, timeCacheLifespan / 2 + timeTolerance, false, true);
            doc.add(new NumericDocValuesField("tiebreaker", i));
            }
        context.terminateAfter(numDocs);
            new Object[] { 5, new ConcurrentQueryPhaseSearcher() }
            when(searchContext.mapperService()).thenReturn(mapperService);
import org.apache.lucene.index.IndexWriterConfig;
        context.collapse(new CollapseBuilder("user").build(context.getQueryShardContext()));
                    .add(new TermQuery(new Term("filter", "f1")), Occur.SHOULD)
import org.opensearch.index.shard.IndexShardTestCase;
            doc.add(new NumericDocValuesField("rank", numDocs - i));
 * KIND, either express or implied.  See the License for the
    private static class TestSearchContextWithRewriteAndCancellation extends TestSearchContext {
        };
 * ownership. Elasticsearch licenses this file to you under
        final Sort sort = new Sort(new SortField("rank", SortField.Type.INT));
import org.apache.lucene.search.Sort;
        QueryShardContext queryShardContext = mock(QueryShardContext.class);
        dir.close();
        IndexWriter writer = new IndexWriter(dir, new IndexWriterConfig(null));
                for (int j = 0; j < i; j++) {
        TestSearchContext context = new TestSearchContext(null, indexShard, newContextSearcher(reader, executor), scrollContext);
        context.parsedQuery(new ParsedQuery(q));
        assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo((long) numDocs));
                return new TestTotalHitCountCollectorManager(new TotalHitCountCollector(), sort);
        CollapseTopFieldDocs topDocs = (CollapseTopFieldDocs) context.queryResult().topDocs().topDocs;
        }
                TestSearchContext context = new TestSearchContextWithRewriteAndCancellation(
        QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
        @Override
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(0));
                }
        dir.close();
            if (i % 2 == 0) {
        QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
        when(queryShardContext.fieldMapper("user")).thenReturn(
            QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(1));
        }
        context.trackTotalHitsUpTo(5);
            Document doc = new Document();
            QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
        assertEquals(numDocs / 2, context.queryResult().topDocs().topDocs.totalHits.value());
        w.addDocument(doc);
        context.trackTotalHitsUpTo(3);
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);
        topDocs = (CollapseTopFieldDocs) context.queryResult().topDocs().topDocs;
        public int getTotalHits() {
        context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));
        countTestCase(matchAll, reader, false, false);
            assertNull(context.queryResult().terminatedEarly());
        w.close();
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);
import java.util.concurrent.Executors;
import org.apache.lucene.search.BooleanClause.Occur;
    private void createTimeoutCheckerThenWaitThenRun(
        TestSearchContext context = new TestSearchContext(null, indexShard, newEarlyTerminationContextSearcher(reader, 0, executor));
            if (randomBoolean()) {
        // should throw time exceed exception for sure after timeCacheLifespan*2+timeTolerance (next's next cached time is available)
            searchContext.setSize(10);
        for (int i = 0; i < numDocs; ++i) {
        }
        }
            assertTrue(context.queryResult().terminatedEarly());
                assertThat(manager.getTotalHits(), allOf(greaterThanOrEqualTo(Math.min(trackTotalHits, 10)), lessThanOrEqualTo(numDocs)));
    @Override
            : newEarlyTerminationContextSearcher(reader, 0, executor);
                doc.add(new StringField("foo", "bar", Store.NO));
        final int numDocs = scaledRandomIntBetween(10, 20);
/*
            if (isDoubleSort) {
            if (i % 3500 == 0) writer.commit();
        context.setSize(size);
        for (int i = 0; i < numDocs; i++) {
        if (executor != null) {
            w.deleteDocuments(new Term("delete", "yes"));
            doc.add(new SortedDocValuesField("filter", newBytesRef("f1" + ((i > 0) ? " " + Integer.toString(i) : ""))));
        MappedFieldType fieldTypeDate = new DateFieldMapper.DateFieldType(fieldNameDate);
        sortFieldDate.setMissingValue(Long.MAX_VALUE);
        boolean checkCachedTimeHasNotChanged
        w.close();
            // TotalHitCountCollector is used in this case as part of Weight#count() optimization
                    new OpenSearchToParentBlockJoinQuery(new MatchAllDocsQuery(), producer, ScoreMode.Avg, "nested"),
            assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo(1L));
        Directory dir = newDirectory();
                assertFalse(hasInfMaxScore(query));
            // Do not expect an exact match when terminate_after is used in conjunction to size = 0 as an optimization introduced by
            scrollContext.lastEmittedDoc = null;
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(0));
        assertTrue(hasInfMaxScore(query));
        @Override
        final int numDocs = scaledRandomIntBetween(600, 900);
        assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(3));
    }
        {
                when(task.isCancelled()).thenReturn(true);
    @Override
            }
            context.setSize(0);
        }
    public Settings threadPoolSettings() {
 * this work for additional information regarding copyright
        public void preProcess(boolean rewrite) {
                }
        when(searchContext.indexShard()).thenReturn(indexShard);
import org.opensearch.index.query.ParsedQuery;
                break;
        assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), greaterThanOrEqualTo(6L));
                    continue;
        w.close();
                );
import org.apache.lucene.util.FixedBitSet;
        }
            if (occur == Occur.MUST) {
import org.opensearch.index.search.OpenSearchToParentBlockJoinQuery;
import org.apache.lucene.index.IndexWriter;
        }
        w.close();
            assertThat(
        Directory dir = newDirectory();
            when(searchContext.mapperService()).thenReturn(mapperService);
 * not use this file except in compliance with the License.
        context.setSize(1);
        }
        }
        final Sort sort = new Sort(new SortField("rank", SortField.Type.INT));
            Document doc = new Document();
        assertThat(topDocs.collapseValues.length, equalTo(2));
        QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
        if (randomBoolean()) {
    public void testIndexSortScrollOptimization() throws Exception {
        TestSearchContext context = new TestSearchContext(null, indexShard, newContextSearcher(reader, executor));
            return (collector == null) ? totalHits : collector.getTotalHits();
        }
        assertEquals(0, context.queryResult().topDocs().topDocs.totalHits.value());
