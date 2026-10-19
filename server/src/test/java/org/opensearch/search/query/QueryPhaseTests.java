 */  
        assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo((long) numDocs));
            QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
        reader.close();
        indexShard = newShard(true);
            context.parsedQuery(new ParsedQuery(bq));
                assertFalse(hasInfMaxScore(query));
        }  
        }
        }
        // 3. Test a sort on date field
            assertThat(topValue, greaterThan(afterValue));
            // concurrent collector. In this case, in general, the number of results are multiplied by the number of
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(1));
            QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
            if (randomBoolean()) {
        Directory dir = newDirectory();
    }
        assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(1));  
        IndexReader reader = DirectoryReader.open(dir);  
        assertThat(context.queryResult().topDocs().topDocs, instanceOf(CollapseTopFieldDocs.class));  
            assertThat(manager.getTotalHits(), allOf(greaterThanOrEqualTo(1), lessThanOrEqualTo(numDocs)));  
        IndexReader reader = DirectoryReader.open(dir);  
            doc.add(new LongPoint(fieldNameLong, longValue));
        boolean checkCachedTimeHasNotChanged
    }
            QueryPhase.executeInternal(searchContext.withCleanQueryResult(), queryPhaseSearcher);
            w.addDocument(doc);
        final Sort indexSort = new Sort(new SortField("rank", SortField.Type.INT), new SortField("tiebreaker", SortField.Type.INT));
        Document doc = new Document();
            assertSortResults(searchContext.queryResult().topDocs().topDocs, (long) numDocs, true);
        context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));
        static TestTotalHitCountCollectorManager create(final ExecutorService executor, final Integer teminateAfter) {
            context.parsedQuery(new ParsedQuery(new MatchAllDocsQuery()));
            }  
import java.util.Collections;
        final int numDocs = 2 * scaledRandomIntBetween(50, 450);
        return Settings.builder().put(super.threadPoolSettings()).put("thread_pool.search.min_queue_size", 10).build();
        for (int trackTotalHits : new int[] { -1, 3, 75, 100 }) {
        for (int i = 0; i < numDocs; ++i) {  
        context.collapse(new CollapseBuilder("user").build(context.getQueryShardContext()));
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(0));  
                cur2 = (long) ((FieldDoc) scoreDoc).fields[1];
        ParsedQuery query = new ParsedQuery(new MatchAllDocsQuery());
    public void testMinScore() throws Exception {  
            ThreadPool.terminate(executor, 10, TimeUnit.SECONDS);  
        countTestCase(true);
                doc.add(new TextField("title", "foo", Store.NO));
        verify(mockedSearchContext, atLeastOnce()).getRelativeTimeInMillis();
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(10));  
    }
        }
        long currentTimeDiffWithCachedTime = TimeValue.nsecToMSec(System.nanoTime()) - threadPool.relativeTimeInMillis();  
            : newEarlyTerminationContextSearcher(reader, 0, executor);
                doc.add(new TextField("title", "foo bar", Store.NO));  
        assertThat(topDocs.collapseValues[0], equalTo(0L)); // user == 0
            return create(executor, sort, null);  
            FieldDoc lastDoc = (FieldDoc) context.queryResult().topDocs().topDocs.scoreDocs[sizeMinus1];  
        QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);  
            assertFalse(context.queryResult().terminatedEarly());
        for (ScoreDoc scoreDoc : context.queryResult().topDocs().topDocs.scoreDocs) {
            searchContext.sort(longDateSortAndFormats);  
        );  
            assertEquals(-1, scoreDoc.shardIndex);  
        Thread.sleep(timeToAlignTimeWithCachedTimeOffset);  
            if (occur == Occur.MUST) {  
        } else {
        context.setSize(10);
        @Override  
                occur
            assertEquals(-1, scoreDoc.shardIndex);  
        assertThat(context.queryResult().topDocs().topDocs, instanceOf(CollapseTopFieldDocs.class));
        // enough docs to have a tree with several leaf nodes  
            doc.add(new SortedDocValuesField("filter", newBytesRef("f1" + ((i > 0) ? " " + Integer.toString(i) : ""))));  
        for (int i = 0; i < numDocs; ++i) {  
            assertEquals(1, context.queryResult().topDocs().topDocs.totalHits.value());
                context.setTask(task);
            }
            }
        TestSearchContext context = new TestSearchContext(null, indexShard, newEarlyTerminationContextSearcher(reader, 0, executor));
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(1));
    private void createTimeoutCheckerThenWaitThenRun(
            QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
                assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo(7L));  
        when(mapperService.fieldType(fieldNameDate)).thenReturn(fieldTypeDate);
                    allOf(greaterThanOrEqualTo(Math.min(trackTotalHits, 10L)), lessThanOrEqualTo((long) numDocs))
            if (randomBoolean()) {
        QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
            BooleanQuery bq = new BooleanQuery.Builder().add(new TermQuery(new Term("foo", "bar")), Occur.SHOULD)
            // returning a ReduceableSearchResult modifies the QueryResult which is not expected
            }  
        QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);  
                int collected;
        when(mapperService.fieldType(fieldNameLong)).thenReturn(fieldTypeLong);
            }  
                SearchShardTask task = mock(SearchShardTask.class);
    }
        reader.close();
import static org.hamcrest.Matchers.allOf;
        w.close();
                allOf(greaterThanOrEqualTo(1L), lessThanOrEqualTo((long) numDocs))
                    newContextSearcher(reader, executor)
        // Always end up with uneven buckets so collapsing is predictable  
 * KIND, either express or implied.  See the License for the
        for (int i = 0; i < 10; i++) {
        BitSetProducer producer = context -> new FixedBitSet(1);  
import org.opensearch.common.unit.TimeValue;  
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
        Query tq = new TermQuery(new Term("foo", "bar"));  
        when(queryShardContext.fieldMapper("user")).thenReturn(  
            this.collector = collector;
            doc.add(new NumericDocValuesField("rank", numDocs - i));
            assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo((long) numDocs));
        context.collapse(new CollapseBuilder("user").build(context.getQueryShardContext()));  
import org.apache.lucene.search.SortField;  
        Directory dir = newDirectory();
            w.addDocument(doc);
        IndexShard indexShard = mock(IndexShard.class);
                    context.queryResult().topDocs().topDocs.totalHits.value(),
            if (i % 3500 == 0) writer.commit();  
        }  
        when(searchContext.shouldUseConcurrentSearch()).thenReturn(executor != null);
        assertThat(topDocs.collapseValues[0], equalTo(0L)); // user == 0
            return (collector == null) ? totalHits : collector.getTotalHits();  
            final TestTotalHitCountCollectorManager manager = TestTotalHitCountCollectorManager.create(executor, 1);  
        SortAndFormats sortAndFormats = new SortAndFormats(scoreSort, new DocValueFormat[] { DocValueFormat.RAW, DocValueFormat.RAW });  
        Query matchAllCsq = new ConstantScoreQuery(matchAll);
            }  
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(1));  
            scrollContext.maxScore = Float.NaN;  
        context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));
import org.apache.lucene.queries.spans.SpanTermQuery;
                }
        SortAndFormats dateSortAndFormats = new SortAndFormats(dateSort, new DocValueFormat[] { dateFormat });  
        context.setSize(0);
            assertThat(cur1, greaterThanOrEqualTo(prev1)); // test that docs are properly sorted on the first sort  
        context.setSize(0);
        if (withDeletions) {  
        context.trackScores(false);
        assertFalse(Float.isNaN(context.queryResult().getMaxScore()));
        IndexShard indexShard = mock(IndexShard.class);
        assertEquals(2, context.queryResult().topDocs().topDocs.scoreDocs.length);
            : newEarlyTerminationContextSearcher(reader, 0, executor);  
                assertFalse(hasInfMaxScore(query));
        Document doc = new Document();
        Query dvfeq_points = new FieldExistsQuery("latLonDVField");  
    public void testInOrderScrollOptimization() throws Exception {
        SearchShardTask task = new SearchShardTask(123L, "", "", "", null, Collections.emptyMap());  
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);  
            ).build();  
            assertThat(
            IndexShard indexShard,  
                occur
            searchContext.parsedQuery(query);
            executor,
        IndexReader reader = DirectoryReader.open(dir);
    }
            )
        w.close();
                    .build(),
    public void testMaxScoreWithSortOnScoreAndCollapsingResults() throws Exception {
        }
        IndexReader reader = DirectoryReader.open(dir);
            IndexSearcher.getDefaultSimilarity(),
    @Override
        assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo((long) numDocs));
        @Override  
import java.util.List;
            context.setSize(0);
        context.trackTotalHitsUpTo(5);
        when(mockedSearchContext.getRelativeTimeInMillis()).thenAnswer(invocation -> threadPool.relativeTimeInMillis());
        countTestCase(false);  
 * under the License.  
        }  
        Query matchAll = new MatchAllDocsQuery();
    private void countTestCase(boolean withDeletions) throws Exception {
            w.flush();  
        final Sort dateLongSort = new Sort(sortFieldDate, sortFieldLong);  
        }  
import org.opensearch.index.query.QueryShardContext;  
        dir.close();
                    null,
        scrollContext.lastEmittedDoc = null;
            TestSearchContext context = new TestSearchContext(null, indexShard, newContextSearcher(reader, executor), scrollContext);  
        IndexReader reader = DirectoryReader.open(dir);
        reader.close();
            new Object[] { 5, new ConcurrentQueryPhaseSearcher() }  
                }  
            w.forceMerge(randomIntBetween(1, 10));
            context.setSearcher(newEarlyTerminationContextSearcher(reader, 1, executor));  
        }
        }  
        private TestTotalHitCountCollectorManager(final TotalHitCountCollector collector, final Sort sort) {
            }
                context.queryResult().topDocs().topDocs.totalHits.value(),  
    public void testCollapseQuerySearchResults() throws Exception {  
        assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo((long) numDocs));
import static org.hamcrest.Matchers.greaterThan;
        }
        long cur1, cur2;
import org.opensearch.index.mapper.DateFieldMapper;
        final boolean rescore = QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
        if (randomBoolean()) {  
            QueryPhase.executeInternal(searchContext, queryPhaseSearcher);
        return new ContextIndexSearcher(
        assertThat(topDocs.collapseValues[0], equalTo(0L)); // user == 0
            return create(executor, null, null);
            assertThat(fieldDoc.fields[0], anyOf(equalTo(1), equalTo(2)));  
            Document doc = new Document();
        }
            int afterDocument = (int) randomLongBetween(0, 50);  
import java.util.concurrent.Executors;
import static org.mockito.Mockito.atLeastOnce;
        when(indexShard.getSearchOperationListener()).thenReturn(searchOperationListener);
        {
        assertThat(context.queryResult().topDocs().topDocs.scoreDocs[0], instanceOf(FieldDoc.class));
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(0));
        }
            doc.add(new StringField("foo", "bar", Store.NO));
import static org.opensearch.search.query.TopDocsCollectorContext.hasInfMaxScore;
            assertThat(fieldDoc.fields[0], anyOf(equalTo(1), equalTo(2)));  
            assertTrue(context.queryResult().terminatedEarly());
import org.apache.lucene.search.FilterLeafCollector;
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs[0], instanceOf(FieldDoc.class));
        IndexWriterConfig iwc = newIndexWriterConfig().setIndexSort(sort);  
    }
        context.sort(new SortAndFormats(new Sort(new SortField("other", SortField.Type.INT)), new DocValueFormat[] { DocValueFormat.RAW }));
        }
        assertTrue(context.queryResult().topDocs().topDocs.totalHits.value() >= 5);  
            ? newContextSearcher(reader, executor)
            cur1 = (long) ((FieldDoc) scoreDoc).fields[0];
                when(task.isCancelled()).thenReturn(true);  
        TestSearchContext context = new TestSearchContext(queryShardContext, indexShard, newContextSearcher(reader, executor));
        reader.close();
        w.close();
            assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo(1L));
        assertThat(context.queryResult().topDocs().topDocs, instanceOf(CollapseTopFieldDocs.class));
        Query dvfeqCsq = new ConstantScoreQuery(dvfeq);
        final Sort sort = new Sort(new SortField("rank", SortField.Type.INT));
        context.trackScores(false);  
            assertThat(context.queryResult().getTotalHits().value(), equalTo((long) numDocs));
        }
import org.apache.lucene.search.join.ScoreMode;
import org.opensearch.common.settings.Settings;
        for (int i = 0; i < numDocs; ++i) {  
                PrefixQuery prefixQuery = new PrefixQuery(new Term("foo", "a"), MultiTermQuery.SCORING_BOOLEAN_REWRITE);  
            searchContext
        context.sort(sortAndFormats);
            context.sort(searchSortAndFormat);
        this.executor = (concurrency > 0) ? Executors.newFixedThreadPool(concurrency) : null;
            assertEquals(initialRelativeCachedTime, threadPool.relativeTimeInMillis());
                ).build(),
            w.addDocument(new Document());  
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);
            assertTrue(context.queryResult().terminatedEarly());  
        Directory dir = newDirectory();
        }  
        Directory dir = newDirectory();
import org.opensearch.index.shard.IndexShard;
        SearchContext searchContext = mock(SearchContext.class);
        SortAndFormats longDateSortAndFormats = new SortAndFormats(longDateSort, new DocValueFormat[] { DocValueFormat.RAW, dateFormat });
import org.apache.lucene.document.StringField;  
        assertFalse(Float.isNaN(context.queryResult().getMaxScore()));
import org.apache.lucene.search.grouping.CollapseTopFieldDocs;  
        context.setSize(1);
            assertThat(topDocs.totalHits.value(), lessThanOrEqualTo(expectedNumDocs));  
    }
        );
            TestSearchContext searchContext = spy(new TestSearchContext(null, indexShard, newContextSearcher(reader, executor)));
            // TotalHitCountCollector is used in this case as part of Weight#count() optimization
        long sleepAfterCreation,  
        assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo((long) numDocs));
            Document doc = new Document();
            if (i % 2 == 0) {
        assertThat(
        assertEquals(topDocsContext.create(null).scoreMode(), org.apache.lucene.search.ScoreMode.COMPLETE);
                TestSearchContext context = new TestSearchContextWithRewriteAndCancellation(
        {  
                .add(new TermQuery(new Term("foo", "baz")), Occur.SHOULD)
 * The OpenSearch Contributors require contributions made to  
        assertThat(context.queryResult().topDocs().topDocs.scoreDocs[0].score, equalTo(context.queryResult().getMaxScore()));  
    public void testQueryCapturesThreadPoolStats() throws Exception {
        {
            assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo((long) numDocs));
        QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
            w.addDocument(doc);
            searchContext.setTask(task);
        context.trackScores(false);
        // should not throw time exceed exception after timeout < timeCacheLifespan when cached time didn't change
        context.trackScores(false);
        assertEquals(2, context.queryResult().topDocs().topDocs.scoreDocs.length);
        }  
        final Sort sort = new Sort(new SortField("rank", SortField.Type.INT));
        context.trackScores(true);  
        assertNull(context.queryResult().terminatedEarly());
        {
        context.setSize(0);  
            final TotalHits totalHits = topDocs.totalHits;
            assertSortResults(searchContext.queryResult().topDocs().topDocs, (long) numDocs, true);
        return new ContextIndexSearcher(
                context.queryResult().topDocs().topDocs.totalHits.value(),
        assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), greaterThanOrEqualTo(6L));
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);
        {
        assertThat(topDocs.collapseValues[1], equalTo(1L)); // user == 1  
        if (checkCachedTimeChanged) {
        static TestTotalHitCountCollectorManager create(final ExecutorService executor, final Sort sort, final Integer teminateAfter) {  
        assertTrue(Float.isNaN(context.queryResult().getMaxScore()));
            totalHits = collectors.stream().mapToInt(TotalHitCountCollector::getTotalHits).sum();  
        IndexWriterConfig iwc = newIndexWriterConfig().setIndexSort(sort);
            this.collector = null;
        QuerySearchResult results = context.queryResult();
        }  
                super.search(partitions, weight, in);
        IndexReader reader = DirectoryReader.open(dir);
import static org.mockito.ArgumentMatchers.eq;  
                allOf(greaterThanOrEqualTo(1L), lessThanOrEqualTo((long) numDocs))  
                doc.add(new LatLonDocValuesField("latLonDVField", 1.0, 1.0));  
            final TestTotalHitCountCollectorManager manager = TestTotalHitCountCollectorManager.create(executor, 1);
        }
            doc.add(new NumericDocValuesField(fieldNameDate, dateValue));
            assertEquals(numDocs, totalHits.value());
        super.setUp();
                totalHits = Math.min(totalHits, teminateAfter);
        QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(7));
        ScrollContext scrollContext = new ScrollContext();
                doc.add(new StringField("foo", "bar", Store.NO));  
        };
    }  
        topDocs = (CollapseTopFieldDocs) context.queryResult().topDocs().topDocs;  
import static org.hamcrest.Matchers.instanceOf;
            }  
        QueryShardContext queryShardContext = mock(QueryShardContext.class);  
    public void testMaxScore() throws Exception {
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);
        assertFalse(Float.isNaN(context.queryResult().getMaxScore()));
        reader.close();  
        }
        reader.close();
        w.close();
        TestSearchContext context = new TestSearchContext(null, indexShard, newContextSearcher(reader, executor));
        public ReduceableSearchResult reduce(Collection<TotalHitCountCollector> collectors) throws IOException {
        assertThat(results.nodeQueueSize(), greaterThanOrEqualTo(0));  
            int sizeMinus1 = context.queryResult().topDocs().topDocs.scoreDocs.length - 1;
        reader.close();  
        if (executor != null) {
 * software distributed under the License is distributed on an
            context.queryCollectorManagers().put(TotalHitCountCollector.class, manager);
        QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
        }  
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
        assertThat(topDocs.collapseValues[1], equalTo(1L)); // user == 1  
            if (randomBoolean()) {
        MapperService mapperService = mock(MapperService.class);  
        context.parsedQuery(
import org.apache.lucene.search.MultiTermQuery;  
        QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
import static org.mockito.Mockito.when;
import org.opensearch.index.shard.IndexShardTestCase;  
        assertThat(topDocs.collapseValues.length, equalTo(2));
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(1));
import org.apache.lucene.search.BooleanClause.Occur;
        static TestTotalHitCountCollectorManager create(final ExecutorService executor, final Sort sort) {
        countTestCase(bq, reader, true, true);
        context.trackTotalHitsUpTo(5);  
    }
            searchContext.from(5);  
        }  
        w.close();
        IndexWriterConfig iwc = newIndexWriterConfig().setIndexSort(sort);
        final int numDocs = scaledRandomIntBetween(600, 900);
import java.util.concurrent.TimeUnit;
            assertThat(context.terminateAfter(), equalTo(0));  
        context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));  
        // should not throw time exceed exception after timeCacheLifespan+timeTolerance because new cached time - init time < timeout
            doc.add(new NumericDocValuesField("user", i & 1));
            searchContext.setTask(task);
        final IndexReader reader = DirectoryReader.open(dir);
        assertThat(context.terminateAfter(), equalTo(0));  
import java.io.IOException;  
    public void testDisableTopScoreCollection() throws Exception {  
                    sb.append('a');
import org.opensearch.search.internal.ScrollContext;  
        final Sort dateSort = new Sort(sortFieldDate);
                    .build()  
                    indexShard,  
            TestSearchContext searchContext = spy(new TestSearchContext(null, indexShard, newContextSearcher(reader, executor)));
            context.queryCollectorManagers().put(TotalHitCountCollector.class, manager);
            assertNull(context.queryResult().terminatedEarly());  
                assertThat(totalHits, greaterThanOrEqualTo(teminateAfter));  
import java.util.Arrays;
        long timeCacheLifespan = ThreadPool.ESTIMATED_TIME_INTERVAL_SETTING.get(Settings.EMPTY).millis();
            context.parsedPostFilter(null);
            IndexSearcher.getDefaultQueryCache(),
                assertFalse(hasInfMaxScore(query));  
        context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));
            QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
            long afterValue = firstValue + afterDocument;
        assertEquals(numDocs / 2, context.queryResult().topDocs().topDocs.totalHits.value());
        IndexWriterConfig iwc = newIndexWriterConfig().setIndexSort(sort);
                doc.add(new StringField("foo", "baz", Store.NO));
            searchContext.sort(dateLongSortAndFormats);  
    }
        assertFalse(rescore);
            Document doc = new Document();  
        IndexWriterConfig iwc = newIndexWriterConfig().setIndexSort(sort);
        context.setSize(1);  
            searchContext.sort(longSortAndFormats);
            when(searchContext.mapperService()).thenReturn(mapperService);
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
        );
            final TestTotalHitCountCollectorManager manager = TestTotalHitCountCollectorManager.create(executor);
        }
                FieldComparator<Object> comparator = (FieldComparator<Object>) searchSortAndFormat.sort.getSort()[i].getComparator(
        when(searchContext.indexShard()).thenReturn(indexShard);  
import org.opensearch.index.mapper.NumberFieldMapper.NumberType;
    }
        @Override  
            when(searchContext.mapperService()).thenReturn(mapperService);
            TestSearchContext searchContext = spy(new TestSearchContext(null, indexShard, newContextSearcher(reader, executor)));
                    .add(new TermQuery(new Term("filter", "f1")), Occur.SHOULD)
            when(searchContext.getTargetMaxSliceCount()).thenReturn(randomIntBetween(0, 2));
        final int numDocs = 3500 * 5;
        dir.close();
        }  
        final int numDocs = 2 * scaledRandomIntBetween(600, 900) - 1;
            }
        TestSearchContext context = new TestSearchContext(queryShardContext, indexShard, newContextSearcher(reader, executor));
            searchContext.parsedQuery(query);
            return true;
        }  
                final Collector in = new AssertingEarlyTerminationFilterCollector(collector, size);
    public void testTerminateAfterWithFilter() throws Exception {  
import org.apache.lucene.search.BooleanQuery;  
    }  
        QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
public class QueryPhaseTests extends IndexShardTestCase {  
        assertThat(topDocs.collapseValues.length, equalTo(2));
                if (cur1 == prev1) {  
        }  
import org.apache.lucene.index.NoMergePolicy;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.search.Sort;
        assertThat(fieldDoc.fields[0], equalTo(1));  
        // should throw time exceed exception for sure after timeCacheLifespan*2+timeTolerance (next's next cached time is available)
                expectThrows(TaskCancelledException.class, () -> new QueryPhase().preProcess(context));
    }
            assertSortResults(searchContext.queryResult().topDocs().topDocs, (long) numDocs, false);  
        when(searchContext.bucketCollectorProcessor()).thenReturn(SearchContext.NO_OP_BUCKET_COLLECTOR_PROCESSOR);  
        context.setSize(10);
                );  
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(0));
        TopDocsCollectorContext topDocsContext = TopDocsCollectorContext.createTopDocsCollectorContext(context, false);  
            assertThat(fieldDoc.fields[0], anyOf(equalTo(1), equalTo(2)));  
        } else {
                    new OpenSearchToParentBlockJoinQuery(new MatchAllDocsQuery(), producer, ScoreMode.Avg, "nested"),
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);  
        // need to run this test approximately at the start of cached time window
        assertThat(topDocs.collapseValues[1], equalTo(1L)); // user == 1
 * not use this file except in compliance with the License.
            ((FieldDoc) context.queryResult().topDocs().topDocs.scoreDocs[0]).fields[0],
            }  
        for (int i = 0; i < numDocs; ++i) {
        context.trackTotalHitsUpTo(5);
import org.opensearch.index.search.OpenSearchToParentBlockJoinQuery;
    }
            final TestTotalHitCountCollectorManager manager = TestTotalHitCountCollectorManager.create(executor);
        when(searchContext.bucketCollectorProcessor()).thenReturn(SearchContext.NO_OP_BUCKET_COLLECTOR_PROCESSOR);
        for (ScoreDoc scoreDoc : context.queryResult().topDocs().topDocs.scoreDocs) {
        IndexReader reader = DirectoryReader.open(dir);  
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(1));
            } else {  
import org.apache.lucene.search.TermQuery;
        IndexReader reader = DirectoryReader.open(dir);  
        final int numDocs = scaledRandomIntBetween(600, 900);
            QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
        final IndexReader reader = w.getReader();  
        verifyNoMoreInteractions(mockedSearchContext);
            } else {
 *
            if (teminateAfter != null) {
        {
 * SPDX-License-Identifier: Apache-2.0
        reader.close();
            ContextIndexSearcher searcher
                );
        }
            searchContext.parsedQuery(query);
        final int numDocs = scaledRandomIntBetween(10, 20);
        SortAndFormats sortAndFormats = new SortAndFormats(sort, new DocValueFormat[] { DocValueFormat.RAW, DocValueFormat.RAW });  
        if (topDocs.totalHits.relation() == TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO) {
import org.apache.lucene.document.SortedDocValuesField;
            final TopDocs topDocs = searchContext.queryResult().topDocs().topDocs;  
        static TestTotalHitCountCollectorManager create(final ExecutorService executor) {  
        countTestCase(dvfeq_points, reader, withDeletions, true);
import org.opensearch.search.sort.SortAndFormats;
 * specific language governing permissions and limitations
        long initialRelativeCachedTime = threadPool.relativeTimeInMillis();
        dir.close();
                return new TestTotalHitCountCollectorManager(sort, teminateAfter);
        }
                    .build()  
        assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(3));
 * ownership. Elasticsearch licenses this file to you under  
            @Override
                    Pruning.NONE
        final Sort sort = new Sort(new SortField("rank", SortField.Type.INT));  
            searchContext.setTask(task);  
        for (ScoreDoc scoreDoc : context.queryResult().topDocs().topDocs.scoreDocs) {
                .build();  
    private static class TestSearchContextWithRewriteAndCancellation extends TestSearchContext {
import org.apache.lucene.search.TopDocs;
        reader.close();
        verify(mockedSearchContext, times(1)).timeout();
            when(searchContext.getTargetMaxSliceCount()).thenThrow(IllegalStateException.class);  
import static org.mockito.Mockito.times;
            } else {
        context.sort(new SortAndFormats(sort, new DocValueFormat[] { DocValueFormat.RAW }));
/*  
            return (collector == null) ? super.newCollector() : collector;
        long prev2 = Long.MIN_VALUE;  
import org.opensearch.core.tasks.TaskCancelledException;
        }
        Directory dir = newDirectory();
            super(sort);  
            Document doc = new Document();  
        dir.close();
            when(searchContext.mapperService()).thenReturn(mapperService);
        IndexWriterConfig iwc = newIndexWriterConfig(new StandardAnalyzer());
            }  
            if (occur == Occur.MUST) {
        final Sort sort = new Sort(new SortField("user", SortField.Type.INT));
        context.setSize(2);  
        );
            context.setSize(1);  
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(1));  
import org.apache.lucene.queries.spans.SpanNearQuery;  
        context.setSize(2);
        IndexWriterConfig iwc = newIndexWriterConfig();  
        }
import org.apache.lucene.search.join.BitSetProducer;
                @Override  
            assertTrue(context.queryResult().terminatedEarly());
        assertFalse(Float.isNaN(context.queryResult().getMaxScore()));
            true,  
        createTimeoutCheckerThenWaitThenRun(timeCacheLifespan / 2, timeCacheLifespan / 2 + timeTolerance, false, true);  
        IndexWriterConfig iwc = newIndexWriterConfig().setIndexSort(sort);  
            context.setSize(10);  
        return Arrays.asList(
        countTestCase(tCsq, reader, withDeletions, withDeletions);  
        IndexReader reader = DirectoryReader.open(dir);
        context.setSize(1);
import org.opensearch.search.DocValueFormat;  
            context.setSize(10);  
        }
    }
        for (int i = 0; i < numDocs; i++) {  
                occur
            QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);  
        w.close();
        final SortField sortFieldLong = new SortField(fieldNameLong, SortField.Type.LONG);
        assertEquals(2, context.queryResult().topDocs().topDocs.scoreDocs.length);
        {
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs[0], instanceOf(FieldDoc.class));
        context.parsedQuery(new ParsedQuery(new TermQuery(new Term("foo", "bar"))));
            QueryShardContext queryShardContext,
            equalTo(context.queryResult().getMaxScore())  
        TestSearchContext context = new TestSearchContext(null, indexShard, newContextSearcher(reader, executor), scrollContext);
    public static Collection<Object[]> concurrency() {  
            assertThat(manager.getTotalHits(), equalTo(1));
        assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), greaterThanOrEqualTo(6L));
        topDocs = (CollapseTopFieldDocs) context.queryResult().topDocs().topDocs;
        }  
import org.apache.lucene.search.FieldComparator;  
        dir.close();  
            QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);  
        private final TotalHitCountCollector collector;  
import org.apache.lucene.tests.index.RandomIndexWriter;
        assertFalse(Float.isNaN(context.queryResult().getMaxScore()));  
        Sort sort = new Sort(new SortField(null, SortField.Type.SCORE), new SortField(null, SortField.Type.DOC));
        when(indexShard.getSearchOperationListener()).thenReturn(searchOperationListener);  
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);  
            super(sort);  
        assertThrows(  
                assertThat(cmp, equalTo(1));
            TestSearchContext searchContext = spy(new TestSearchContext(null, indexShard, newContextSearcher(reader, executor)));
                    new OpenSearchToParentBlockJoinQuery(new MatchAllDocsQuery(), producer, ScoreMode.Avg, "nested"),  
                doc.add(new StringField("foo", "bar", Store.NO));
        // 1. Test a sort on long field
        } else {
            context.setSize(1);  
        for (int i = 1; i <= numDocs; ++i) {
            doc.add(new StringField("foo", "bar", Store.NO));
        SearchContext mockedSearchContext = mock(SearchContext.class);  
            QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
            context.queryCollectorManagers().clear();
        }
        final IndexReader reader = DirectoryReader.open(dir);  
            context.trackTotalHitsUpTo(trackTotalHits);
            QueryPhase.executeInternal(searchContext, queryPhaseSearcher);
    public void testCancellationDuringPreprocess() throws IOException {  
        writer.close();
 *    http://www.apache.org/licenses/LICENSE-2.0
        BooleanQuery bq = new BooleanQuery.Builder().add(matchAll, Occur.SHOULD).add(tq, Occur.MUST).build();
            () -> createTimeoutCheckerThenWaitThenRun(timeCacheLifespan, timeCacheLifespan * 2 + timeTolerance, true, false)
        Document doc = new Document();  
                    .build()  
    public void testIndexSortingEarlyTermination() throws Exception {
            new ParsedQuery(  
            // including total hits collector  
            context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));
        }
                searcher().rewrite(query());  
        );
            assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo((long) numDocs));
            assertThat(context.queryResult().getTotalHits().value(), equalTo((long) numDocs));
                    .add(new TermQuery(new Term("filter", "f1")), Occur.SHOULD)
        assertEquals(1, context.queryResult().topDocs().topDocs.totalHits.value());
            } else {  
            context.queryCollectorManagers().clear();
            when(searchContext.mapperService()).thenReturn(mapperService);  
    private void countTestCase(Query query, IndexReader reader, boolean shouldCollectSearch, boolean shouldCollectCount) throws Exception {
        assertThat(context.queryResult().getTotalHits().value(), equalTo((long) numDocs));  
        SortAndFormats dateLongSortAndFormats = new SortAndFormats(dateLongSort, new DocValueFormat[] { dateFormat, DocValueFormat.RAW });
            if (executor == null) {
        dir.close();  
            query = new BooleanQuery.Builder().add(
import org.apache.lucene.index.Term;
        context.terminateAfter(numDocs);
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);
        SearchOperationListener searchOperationListener = new SearchOperationListener() {
        final int numDocs = scaledRandomIntBetween(600, 900);
        final int numDocs = scaledRandomIntBetween(600, 900);
                assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo(0L));
        private TestSearchContextWithRewriteAndCancellation(
            }  
        assertEquals(topDocsContext.create(null).scoreMode(), org.apache.lucene.search.ScoreMode.TOP_DOCS);  
        reader.close();
            return new FilterLeafCollector(in) {  
        assertEquals(1, context.queryResult().topDocs().topDocs.scoreDocs.length);  
import org.apache.lucene.document.SortedSetDocValuesField;
                    ++collected;  
        TestSearchContext context = new TestSearchContext(null, indexShard, newContextSearcher(reader, executor));  
                assertTrue(hasInfMaxScore(query));
                    .add(new TermQuery(new Term("filter", "f1")), Occur.SHOULD)
    }  
                    occur
            if (isDoubleSort) {
 * You may obtain a copy of the License at  
            executor,
        }  
            } catch (IOException e) {
            };  
        }  
import org.apache.lucene.index.IndexWriterConfig;
            if (withDeletions && (rarely() || i == 0)) {
        when(mockedSearchContext.getRelativeTimeInMillis(eq(false))).thenCallRealMethod();  
        w.close();
            when(searchContext.mapperService()).thenReturn(mapperService);
        {  
        dir.close();
        }
        assertThat(context.queryResult().topDocs().topDocs, instanceOf(CollapseTopFieldDocs.class));
        // 5. Test that sort optimization is run when from > 0 and size = 0
        for (int trackTotalHits : new int[] { -1, 3, 76, 100 }) {  
            searchContext.setSize(10);  
            ScrollContext scrollContext = new ScrollContext();
import org.apache.lucene.search.MatchNoDocsQuery;
            this.teminateAfter = null;
        assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo((long) numDocs));  
        }  
    @ParametersFactory
            this.size = size;  
            w.addDocument(doc);
        IndexWriterConfig iwc = newIndexWriterConfig().setIndexSort(indexSort);  
                Document doc = new Document();
                doc.add(new SortedSetDocValuesField("foo", new BytesRef("bar")));
        w.close();  
            prev1 = cur1;
            );
        assertEquals(countSearcher.count(query), context.queryResult().topDocs().topDocs.totalHits.value());
        context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));  
            searchContext.setSize(10);
        w.addDocument(doc);
        context.parsedQuery(new ParsedQuery(new MatchAllDocsQuery()));
        for (int i = 0; i < numDocs; i++) {
                for (int j = 0; j < i; j++) {  
            doc.add(new StringField("foo", Integer.toString(i), Store.NO));
                new BooleanQuery.Builder().add(new TermQuery(new Term("foo", "bar")), Occur.MUST)
        for (int i = 0; i < numDocs; i++) {
            QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
        assertThat(topDocs.collapseValues[0], equalTo(0L)); // user == 0
        Query dvfeq = new FieldExistsQuery("foo");
    public void tearDown() throws Exception {  
        }
                context.queryResult().topDocs().topDocs.totalHits.value(),
 * Modifications Copyright OpenSearch Contributors. See
            assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo(1L));
            QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);  
    private static class TestTotalHitCountCollectorManager extends TotalHitCountCollectorManager {
        context.parsedQuery(new ParsedQuery(new MatchAllDocsQuery()));
            doc.add(new NumericDocValuesField("user", i & 1));  
    }  
            searchContext.setSize(0);
        QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);  
            assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo(1L));
            if (randomBoolean()) {
            assertTrue(context.queryResult().terminatedEarly());
import org.apache.lucene.util.BytesRef;
        for (SortAndFormats searchSortAndFormat : searchSortAndFormats) {
            doc.add(new NumericDocValuesField("tiebreaker", i));  
            assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo(numDocs - 1L));  
    private static class AssertingEarlyTerminationFilterCollector extends FilterCollector {
import org.apache.lucene.search.MatchAllDocsQuery;
        assertEquals(context.queryResult().topDocs().topDocs.totalHits.relation(), TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO);
        Directory dir = newDirectory();
        context.setSearcher(newContextSearcher(reader, executor));
        dir.close();
                public void collect(int doc) throws IOException {
        private TestTotalHitCountCollectorManager(final Sort sort, final Integer teminateAfter) {
        context.sort(sortAndFormats);
            writer.addDocument(doc);  
        dir.close();  
        reader.close();
        if (executor != null) {  
            // slices (as the unit of concurrency). To address that, we have to use the shared global state,
import org.apache.lucene.search.ScoreDoc;
            context.setSize(0);
import java.util.concurrent.ExecutorService;  
        w.close();  
            searchContext  
                assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo(0L));
import org.apache.lucene.document.NumericDocValuesField;  
            context.trackTotalHitsUpTo(SearchContext.TRACK_TOTAL_HITS_DISABLED);
        long timeTolerance = timeCacheLifespan / 20;  
    // assert score docs are in order and their number is as expected  
        sortFieldDate.setMissingValue(Long.MAX_VALUE);
        public TotalHitCountCollector newCollector() throws IOException {  
            longValue++;
                new OpenSearchToParentBlockJoinQuery(new MatchAllDocsQuery(), producer, ScoreMode.Avg, "nested"),  
            when(searchContext.mapperService()).thenReturn(mapperService);
    private final ExecutorService executor;
            // https://issues.apache.org/jira/browse/LUCENE-10620 can produce a total hit count >= terminated_after, because
            true,
            QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);  
            context.setSize(1);  
            w.deleteDocuments(new Term("delete", "yes"));
        QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
import org.opensearch.search.collapse.CollapseBuilder;
        IndexWriter writer = new IndexWriter(dir, new IndexWriterConfig(null));  
            );  
        sortFieldLong.setMissingValue(Long.MAX_VALUE);
 * license agreements. See the NOTICE file distributed with
        final IndexReader reader = DirectoryReader.open(dir);  
        assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(3));  
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs[0], instanceOf(FieldDoc.class));  
        QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);  
            context.trackTotalHitsUpTo(trackTotalHits);  
        scrollContext.totalHits = null;
        countTestCase(dvfeqCsq, reader, withDeletions, true);  
            when(searchContext.getTargetMaxSliceCount()).thenReturn(randomIntBetween(0, 2));  
        );
        assertEquals(2, context.queryResult().topDocs().topDocs.scoreDocs.length);  
import org.opensearch.index.mapper.MappedFieldType;  
        }
        Directory dir = newDirectory();
        context.minimumScore(100);
                break;
        final String fieldNameLong = "long-field";
        final String fieldNameDate = "date-field";  
                doc.add(new StringField("foo", "bar", Store.NO));
        context.sort(new SortAndFormats(sort, new DocValueFormat[] { DocValueFormat.RAW }));
        context.terminateAfter(7);  
        }
        context.parsedQuery(
            assertTrue(context.queryResult().terminatedEarly());
        Directory dir = newDirectory();
        }
import static org.mockito.Mockito.verifyNoMoreInteractions;  
            }
        assertThat(topDocs.collapseValues[1], equalTo(1L)); // user == 1  
            // The concurrent search terminates the collection when the number of hits is reached by each  
            try {
            Document doc = new Document();  
        AssertingEarlyTerminationFilterCollector(Collector in, int size) {
            searchContext.setSize(10);  
        ContextIndexSearcher searcher = shouldCollectSearch  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        countTestCase(matchAll, reader, false, false);  
        private int totalHits;
        long timeToAlignTimeWithCachedTimeOffset = timeCacheLifespan - currentTimeDiffWithCachedTime + timeTolerance;
            assertTrue(context.queryResult().terminatedEarly());  
        countTestCase(dvfeq, reader, withDeletions, true);
import org.apache.lucene.document.Document;
        for (int i = 0; i < numDocs; i++) {  
            context.parsedPostFilter(new ParsedQuery(new TermQuery(new Term("foo", Integer.toString(i)))));  
        long timeout,
            assertTrue(context.queryResult().terminatedEarly());
                );
        QueryShardContext queryShardContext = mock(QueryShardContext.class);
        };
import org.opensearch.lucene.queries.MinDocQuery;
            TestSearchContext searchContext = spy(new TestSearchContext(null, indexShard, newContextSearcher(reader, executor)));
        }
                if (cmp == 0) {
            QueryPhase.executeInternal(searchContext.withCleanQueryResult(), queryPhaseSearcher);
            if (occur == Occur.MUST) {
import org.apache.lucene.document.TextField;
import static org.hamcrest.Matchers.anyOf;  
    }
    }
        }
                doc.add(new LatLonPoint("latLonDVField", 1.0, 1.0));
 *
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(1));
        assertTrue(Float.isNaN(context.queryResult().getMaxScore()));
        w.close();  
                return new TestTotalHitCountCollectorManager(new TotalHitCountCollector(), sort);
/*  
            w.close();
            super(in);
        dir.close();
        assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo((long) numDocs));
                    assertThat(cur2, greaterThanOrEqualTo(prev2)); // test that docs are properly sorted on the secondary sort
    public void testCountWithoutDeletions() throws Exception {
            when(searchContext.getTargetMaxSliceCount()).thenThrow(IllegalStateException.class);
    }
            IndexSearcher.getDefaultQueryCachingPolicy(),
        long timeTolerance = timeCacheLifespan / 20;
        context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));  
                assertThat(manager.getTotalHits(), allOf(greaterThanOrEqualTo(Math.min(trackTotalHits, 10)), lessThanOrEqualTo(numDocs)));
        context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));
        assertFalse(hasInfMaxScore(query));
import org.opensearch.index.mapper.NumberFieldMapper.NumberFieldType;  
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs[0], instanceOf(FieldDoc.class));
        final int numDocs = scaledRandomIntBetween(600, 900);
            doc.add(new LongPoint(fieldNameDate, dateValue));
        ContextIndexSearcher countSearcher = shouldCollectCount
            doc.add(new NumericDocValuesField(fieldNameLong, longValue));
        }
        assertThat(topDocs.collapseValues[0], equalTo(0L)); // user == 0  
            QueryPhase.executeInternal(searchContext.withCleanQueryResult(), queryPhaseSearcher);
        }  
    }
            if (trackTotalHits == -1) {  
            }  
                ).build(),
        {  
        {
    }  
            scrollContext.lastEmittedDoc = null;
    private IndexShard indexShard;
import org.opensearch.action.search.SearchShardTask;
        countTestCase(dvOnlyfeq, reader, true, true);
            ).build();
            try (IndexReader reader = DirectoryReader.open(dir)) {  
        }
            // this collector should not participate in reduce as it is added for test purposes to capture the totalHits count  
        TestSearchContext context = new TestSearchContext(null, indexShard, newContextSearcher(reader, executor));  
        assertThat(results.serviceTimeEWMA(), greaterThanOrEqualTo(0L));
 */  
            doc.clear();
                }
            } else {  
        }  
        assertThat(context.queryResult().topDocs().topDocs.scoreDocs[0].doc, greaterThanOrEqualTo(size));
        FieldDoc fieldDoc = (FieldDoc) context.queryResult().topDocs().topDocs.scoreDocs[0];
                doc.add(new SortedSetDocValuesField("foo", new BytesRef("baz")));
        }  
        context.sort(new SortAndFormats(sort, new DocValueFormat[] { DocValueFormat.RAW }));
        TestSearchContext context = new TestSearchContext(null, indexShard, newContextSearcher(reader, executor));
 * Licensed to Elasticsearch under one or more contributor  
        reader.close();
                Occur.FILTER  
        for (int i = 0; i < 10; i++) {  
    }
    public void testIndexSortScrollOptimization() throws Exception {  
            searchContext.parsedQuery(query);
        context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));
        IndexReader reader = DirectoryReader.open(dir);
            dateValue++;
import static org.hamcrest.Matchers.equalTo;
            context.setSize(1);
    private final QueryPhaseSearcher queryPhaseSearcher;  
            w.addDocument(doc);
import static org.hamcrest.Matchers.lessThanOrEqualTo;
            assertTrue(context.queryResult().terminatedEarly());
        }
            new NumberFieldType("user", NumberType.INTEGER, true, false, true, false, false, null, Collections.emptyMap())
        assertEquals(TotalHits.Relation.EQUAL_TO, context.queryResult().topDocs().topDocs.totalHits.relation());
            FieldDoc after = new FieldDoc(afterDocument, Float.NaN, new Long[] { afterValue });
            if (trackTotalHits == -1) {  
            query = new BooleanQuery.Builder().add(
        }
import org.apache.lucene.search.TotalHits;
import org.apache.lucene.index.IndexReader;  
            assertThat(fieldDoc.fields[0], anyOf(equalTo(1), equalTo(2)));
            searchContext.setTask(task);  
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);
    @Override  
        QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
 * GitHub history for details.
    public void testQueryTimeoutChecker() throws Exception {
            Document doc = new Document();
        // search sort is a prefix of the index sort
        context.trackTotalHitsUpTo(3);
                new BooleanQuery.Builder().add(new SpanTermQuery(new Term("field", "foo")), occur)
        context.parsedQuery(new ParsedQuery(new MatchAllDocsQuery()));  
        context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));
                assertThat(  
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);  
    }  
        countTestCase(matchAllCsq, reader, false, false);
        Directory dir = newDirectory();
        IndexWriterConfig iwc = newIndexWriterConfig().setMergePolicy(NoMergePolicy.INSTANCE);  
        ) {  
            } else {
        Directory dir = newDirectory();
import org.apache.lucene.search.FilterCollector;  
        context.terminateAfter(10);
        assertEquals(1, context.queryResult().topDocs().topDocs.scoreDocs.length);  
        query = new OpenSearchToParentBlockJoinQuery(new MatchAllDocsQuery(), producer, ScoreMode.None, "nested");
        Directory dir = newDirectory();
                new BooleanQuery.Builder().add(
            doc.add(new StringField("filter", "f1" + ((i > 0) ? " " + Integer.toString(i) : ""), Store.NO));
                assertTrue(hasInfMaxScore(query));
            new ParsedQuery(  
        long timeCacheLifespan = ThreadPool.ESTIMATED_TIME_INTERVAL_SETTING.get(Settings.EMPTY).millis();
        Query tCsq = new ConstantScoreQuery(tq);
        w.close();  
        TestSearchContext context = new TestSearchContext(null, indexShard, newContextSearcher(reader, executor));  
            doc.add(new StringField("foo", "bar", Store.NO));
            QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
            .addClause(new SpanTermQuery(new Term("title", "bar")))  
        TestSearchContext context = new TestSearchContext(null, indexShard, newContextSearcher(reader, executor));  
 * Unless required by applicable law or agreed to in writing,
            doc.add(new StringField("filter", "f1", Store.NO));
            assertEquals(-1, scoreDoc.shardIndex);  
        Directory dir = newDirectory();
            doc.add(new StringField("filter", "f1" + ((i > 0) ? " " + i : ""), Store.NO));  
            QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);  
    public void testPostFilterDisablesCountOptimization() throws Exception {
            assertTrue(context.queryResult().terminatedEarly());
            if (executor == null) {
        context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));
            new Object[] { 0, QueryPhase.DEFAULT_QUERY_PHASE_SEARCHER },
        assertThat(context.queryResult().topDocs().topDocs, instanceOf(CollapseTopFieldDocs.class));
    }  
        dir.close();  
    public void testMaxScoreQueryVisitor() {
            // Do not expect an exact match when terminate_after is used in conjunction to size = 0 as an optimization introduced by  
        countTestCase(tq, reader, withDeletions, withDeletions);
                    assert collected <= size : "should not collect more than " + size + " doc per segment, got " + collected;
            }
            assertThat(manager.getTotalHits(), lessThanOrEqualTo(numDocs));
    }
import org.apache.lucene.search.FieldDoc;
            )
            context.queryCollectorManagers().put(TotalHitCountCollector.class, manager);  
        assertEquals(1, context.queryResult().topDocs().topDocs.scoreDocs.length);  
            doc.add(new StringField("foo", "bar", Store.NO));  
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(1));
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        assertThat(topDocs.collapseValues.length, equalTo(2));
        }  
            query = new BooleanQuery.Builder().add(
            );
            assertSortResults(searchContext.queryResult().topDocs().topDocs, (long) numDocs, false);
                doc.add(new StringField("delete", "yes", Store.NO));
        context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));  
        Directory dir = newDirectory();  
            assertNull(context.queryResult().terminatedEarly());
        QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
                int cmp = comparator.compareValues(firstDoc.fields[i], lastDoc.fields[i]);  
            }
        // make sure next time slot become available
            searchContext.parsedQuery(query);
    public void testCountWithDeletions() throws Exception {  
                    super.collect(doc);
        w.close();
        for (int i = 0; i < numDocs; ++i) {
            context.parsedQuery(new ParsedQuery(bq));
        // tests with trackTotalHits and terminateAfter  
            }  
        Query dvOnlyfeq = new FieldExistsQuery("docValuesOnlyField");  
        Thread.sleep(sleepAfterCreation);  
        assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), greaterThanOrEqualTo(6L));
            assertEquals(TotalHits.Relation.EQUAL_TO, totalHits.relation());  
        final Sort sort = new Sort(new SortField("filter", SortField.Type.STRING));  
        context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));  
        QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
        context.trackScores(true);
        CollapseTopFieldDocs topDocs = (CollapseTopFieldDocs) context.queryResult().topDocs().topDocs;
        assertTrue(hasInfMaxScore(query));
            context.setSearcher(newEarlyTerminationContextSearcher(reader, 10, executor));
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);  
            }  
        final Sort longSort = new Sort(sortFieldLong);  
        MappedFieldType fieldTypeLong = new NumberFieldMapper.NumberFieldType(fieldNameLong, NumberFieldMapper.NumberType.LONG);
}  
        QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);  
        verify(mockedSearchContext, times(1)).getRelativeTimeInMillis(eq(false));  
            searchContext.setSize(0);
            w.addDocument(doc);
import org.apache.lucene.search.PrefixQuery;
    public QueryPhaseTests(int concurrency, QueryPhaseSearcher queryPhaseSearcher) {
            ).build();
        for (int i = 0; i < 10; i++) {
        context.parsedQuery(new ParsedQuery(new MatchAllDocsQuery()));
        assertThat(topDocs.collapseValues.length, equalTo(2));  
        if (this.executor != null) {  
import org.apache.lucene.util.FixedBitSet;  
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);  
            QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);  
 * compatible open source license.
        queryTimeoutChecker.run();
            this.teminateAfter = teminateAfter;
        assertEquals(numDocs / 2, context.queryResult().topDocs().topDocs.totalHits.value());  
            assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo(1L));  
            assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo((long) numDocs));
        SortAndFormats longSortAndFormats = new SortAndFormats(longSort, new DocValueFormat[] { DocValueFormat.RAW });
        if (checkCachedTimeHasNotChanged) {
        reader.close();
import org.apache.lucene.search.Weight;
        context.terminateAfter(1);  
import org.apache.lucene.index.LeafReaderContext;  
            searchContext.setSize(10);  
        reader.close();  
        assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo((long) numDocs));  
        List<SortAndFormats> searchSortAndFormats = new ArrayList<>();  
            Document doc = new Document();
        {  
        QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
            searchContext.sort(longSortAndFormats);
import org.apache.lucene.document.LatLonPoint;
            Document doc = new Document();
        context.parsedQuery(new ParsedQuery(query));
        SearchContext searchContext = mock(SearchContext.class);  
                new BooleanQuery.Builder().add(
    private static ContextIndexSearcher newEarlyTerminationContextSearcher(IndexReader reader, int size, ExecutorService executor)
    }
        final SortField sortFieldDate = new SortField(fieldNameDate, SortField.Type.LONG);  
        long dateValue = randomLongBetween(0, 3000000000000L);  
            context.parsedPostFilter(new ParsedQuery(new MinDocQuery(1)));  
    public void testTerminateAfterEarlyTermination() throws Exception {  
        context.trackTotalHitsUpTo(5);
        assertEquals(0, context.queryResult().topDocs().topDocs.totalHits.value());
                doc.add(new StringField("foo", "baz", Store.NO));
        assertThat(topDocs.collapseValues.length, equalTo(2));
        public boolean lowLevelCancellation() {
            context.queryCollectorManagers().put(TotalHitCountCollector.class, manager);
            searchContext.sort(longSortAndFormats);  
            assertNull(context.queryResult().terminatedEarly());  
import org.opensearch.search.internal.SearchContext;
            query = new BooleanQuery.Builder().add(  
        boolean checkCachedTimeChanged,
            }
            assertSortResults(topDocs, (long) numDocs, false);  
    private void assertSortResults(TopDocs topDocs, long expectedNumDocs, boolean isDoubleSort) {
            for (int i = 0; i < searchSortAndFormat.sort.getSort().length; i++) {  
        assertEquals(1, context.queryResult().topDocs().topDocs.totalHits.value());  
            return (result) -> {};
    private static ContextIndexSearcher newContextSearcher(IndexReader reader, ExecutorService executor) throws IOException {  
                doc.add(new SortedSetDocValuesField("docValuesOnlyField", new BytesRef("bar")));
            final TestTotalHitCountCollectorManager manager = TestTotalHitCountCollectorManager.create(executor, sort);  
        QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);  
                doc.add(new StringField("foo", "baz", Store.NO));
    }
 *  
            // much as HitsThresholdChecker does.  
/*
        assertEquals(2, context.queryResult().topDocs().topDocs.scoreDocs.length);
    public void testMinScoreDisablesCountOptimization() throws Exception {  
        // 6. Test that sort optimization works with from = 0 and size= 0  
        context.terminateAfter(1);
        @Override
            long topValue = (long) ((FieldDoc) topDocs.scoreDocs[0]).fields[0];
        );  
            doc.add(new NumericDocValuesField("rank", random().nextInt()));
        context.setSize(3);
            w.addDocument(doc);
            TestSearchContext searchContext = spy(new TestSearchContext(null, indexShard, newContextSearcher(reader, executor)));
            QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
            context.setConcurrentSegmentSearchEnabled(true);
import org.apache.lucene.search.IndexSearcher;
        DocValueFormat dateFormat = fieldTypeDate.docValueFormat(null, null);
        ) {
import org.opensearch.index.query.ParsedQuery;
                    1,  
        assertEquals(context.queryResult().topDocs().topDocs.totalHits.relation(), TotalHits.Relation.EQUAL_TO);
            assertThat(
import java.util.ArrayList;
        context.parsedPostFilter(new ParsedQuery(new MatchNoDocsQuery()));
                    continue;
        final Sort sort = new Sort(new SortField("rank", SortField.Type.INT));
        super.tearDown();
        IndexReader reader = DirectoryReader.open(dir);
import org.apache.lucene.search.ConstantScoreQuery;
        {
                allOf(greaterThanOrEqualTo(1L), lessThanOrEqualTo((long) numDocs))
    ) throws Exception {  
            IndexSearcher.getDefaultQueryCache(),
                @SuppressWarnings("unchecked")
        final int numDocs = scaledRandomIntBetween(600, 900);
        topDocsContext = TopDocsCollectorContext.createTopDocsCollectorContext(context, false);
        long longValue = firstValue;
        IndexWriterConfig iwc = newIndexWriterConfig();
    }
    @Override
            new ParsedQuery(  
        final Sort sort = new Sort(new SortField("rank", SortField.Type.INT));
    public Settings threadPoolSettings() {
 * this file be licensed under the Apache-2.0 license or a
                }
        context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));  
        public LeafCollector getLeafCollector(LeafReaderContext context) throws IOException {
        if (executor != null) {
            QueryPhase.TimeExceededException.class,
        IndexWriterConfig iwc = newIndexWriterConfig().setIndexSort(sort);  
        }
            searchContext.setSize(10);  
    }
            searchContext.setTask(task);
            assertEquals(topDocs.totalHits.value(), expectedNumDocs);
            }
import org.opensearch.index.mapper.NumberFieldMapper;
import org.apache.lucene.search.LeafCollector;  
            reader,  
            searchContext.setTask(task);
        IndexWriterConfig iwc = newIndexWriterConfig();
        );
            scrollContext.totalHits = null;
    }
        }
        when(mockedSearchContext.timeout()).thenReturn(TimeValue.timeValueMillis(timeout));
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(0));
        when(queryShardContext.fieldMapper("user")).thenReturn(
        {  
        searchSortAndFormats.add(new SortAndFormats(indexSort, new DocValueFormat[] { DocValueFormat.RAW, DocValueFormat.RAW }));
    public void testMaxScoreWithSortOnScoreFirstly() throws Exception {  
        searchSortAndFormats.add(new SortAndFormats(new Sort(indexSort.getSort()[0]), new DocValueFormat[] { DocValueFormat.RAW }));  
        dir.close();  
        long firstValue = randomLongBetween(-10000000L, 10000000L);
        scrollContext.maxScore = Float.NaN;  
        final int numDocs = scaledRandomIntBetween(600, 900);
        private final Integer teminateAfter;
        CollapseTopFieldDocs topDocs = (CollapseTopFieldDocs) context.queryResult().topDocs().topDocs;  
            searchContext.sort(dateSortAndFormats);  
        }  
            FieldDoc firstDoc = (FieldDoc) context.queryResult().topDocs().topDocs.scoreDocs[0];
            assertThat(context.terminateAfter(), equalTo(0));  
            ? newContextSearcher(reader, executor)
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);
                new BooleanQuery.Builder().add(new TermQuery(new Term("foo", "bar")), Occur.MUST)
        assertEquals(0, context.queryResult().topDocs().topDocs.totalHits.value());
        }
import org.apache.lucene.store.Directory;  
            doc.add(new StringField("foo", "bar", Store.NO));
            if (randomBoolean()) {  
        context.parsedQuery(new ParsedQuery(new MatchAllDocsQuery()));
        for (Occur occur : Occur.values()) {
            assertSortResults(searchContext.queryResult().topDocs().topDocs, (long) numDocs, false);
            assertThat(  
        {
            .build();
                new BooleanQuery.Builder().add(new TermQuery(new Term("foo", "bar")), Occur.MUST)
                assertTrue(hasInfMaxScore(query));
        IndexWriterConfig iwc = newIndexWriterConfig();
        throws IOException {
        createTimeoutCheckerThenWaitThenRun(timeCacheLifespan / 4, timeCacheLifespan / 2 + timeTolerance, false, true);
        int size = randomIntBetween(2, 5);  
        TestSearchContext context = new TestSearchContext(null, indexShard, newEarlyTerminationContextSearcher(reader, 0, executor));  
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);
        public void preProcess(boolean rewrite) {
        context.parsedQuery(new ParsedQuery(new TermQuery(new Term("foo", "bar"))));
        context.setSize(size);
        for (int i = 0; i < numDocs; i++) {  
import org.apache.lucene.search.FieldExistsQuery;
            for (int i = 0; i < 10; i++) {  
            assertNotEquals(initialRelativeCachedTime, threadPool.relativeTimeInMillis());
    }
            Document doc = new Document();  
            protected void search(LeafReaderContextPartition[] partitions, Weight weight, Collector collector) throws IOException {  
        SearchOperationListener searchOperationListener = new SearchOperationListener() {  
        reader.close();  
import org.opensearch.index.mapper.MapperService;
            final LeafCollector in = super.getLeafCollector(context);
        final Sort longDateSort = new Sort(sortFieldLong, sortFieldDate);
import org.apache.lucene.search.TotalHitCountCollector;  
            searchContext.sort(longSortAndFormats);  
            ).build();  
        dir.close();  
        TestSearchContext context = new TestSearchContext(null, indexShard, newContextSearcher(reader, executor));
                    .add(new OpenSearchToParentBlockJoinQuery(new MatchAllDocsQuery(), producer, ScoreMode.Avg, "nested"), occur)  
        for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
        context.parsedQuery(new ParsedQuery(q));  
import org.apache.lucene.document.LongPoint;
            context.setSize(0);  
            assertThat(manager.getTotalHits(), equalTo(numDocs));
import static org.mockito.Mockito.spy;  
        }
        }
        w.addDocument(doc);  
        assertThat(topDocs.collapseValues[1], equalTo(1L)); // user == 1
        public int getTotalHits() {
import org.apache.lucene.index.DirectoryReader;
        when(searchContext.shouldUseConcurrentSearch()).thenReturn(executor != null);
                prev2 = cur2;  
        context.setTask(new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()));
            super(queryShardContext, indexShard, searcher);  
        }
        assertThat(context.queryResult().topDocs().topDocs.totalHits.value(), equalTo((long) numDocs));  
        context.trackTotalHitsUpTo(5);
            QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
        assertThat(context.queryResult().topDocs().topDocs.scoreDocs[0].score, equalTo(context.queryResult().getMaxScore()));  
        TestSearchContext context = new TestSearchContext(null, indexShard, newContextSearcher(reader, executor));
import org.apache.lucene.search.Pruning;
    }  
        @Override
            assertFalse(hasInfMaxScore(query));
import org.opensearch.test.TestSearchContext;  
        topDocs = (CollapseTopFieldDocs) context.queryResult().topDocs().topDocs;  
            }  
        dir.close();
        context.parsedQuery(new ParsedQuery(new MatchAllDocsQuery()));
import org.opensearch.index.shard.SearchOperationListener;
                w.addDocument(doc);
                context.parsedQuery(new ParsedQuery(prefixQuery));
                doc.add(new StringField("foo", sb.toString(), Store.NO));  
        }  
                    occur  
        context.minimumScore(0.01f);  
        Query q = new SpanNearQuery.Builder("title", true).addClause(new SpanTermQuery(new Term("title", "foo")))
    }
    public void testEnhanceSortOnNumeric() throws Exception {
        context.setSize(1);
        MappedFieldType fieldTypeDate = new DateFieldMapper.DateFieldType(fieldNameDate);
import org.apache.lucene.document.Field.Store;
        QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);  
        }
            w.addDocument(doc);
        Directory dir = newDirectory();  
        context.sort(new SortAndFormats(sort, new DocValueFormat[] { DocValueFormat.RAW }));  
            } else {
        assertFalse(Float.isNaN(context.queryResult().getMaxScore()));
import org.opensearch.threadpool.ThreadPool;
        Runnable queryTimeoutChecker = QueryPhase.createQueryTimeoutChecker(mockedSearchContext);
        createTimeoutCheckerThenWaitThenRun(timeCacheLifespan, timeCacheLifespan + timeTolerance, true, false);  
        Query query = new OpenSearchToParentBlockJoinQuery(new MatchAllDocsQuery(), producer, ScoreMode.Avg, "nested");
        // Always end up with uneven buckets so collapsing is predictable
        // 7. Test that sort optimization works with search after
import org.apache.lucene.search.Collector;
import org.apache.lucene.analysis.standard.StandardAnalyzer;  
            Document doc = new Document();
        w.close();  
            w.addDocument(new Document());
        QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
            QueryPhase.executeInternal(searchContext.withCleanQueryResult(), queryPhaseSearcher);
            searchContext.searchAfter(after);  
        assertThat(context.queryResult().getTotalHits().value(), equalTo((long) numDocs));
package org.opensearch.search.query;
            }
        dir.close();  
        closeShards(indexShard);
        Document doc = new Document();
        w.close();
        };
import java.util.Collection;  
            searchContext.setTask(task);
            w.addDocument(doc);  
            assertNull(context.queryResult().terminatedEarly());
            searchContext.parsedQuery(query);
            return create(executor, null, teminateAfter);
            // When searching concurrently, each executors short-circuits when "size" is reached,
        w.close();  
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir, newIndexWriterConfig())) {
        Directory dir = newDirectory();
        long prev1 = Long.MIN_VALUE;
        TestSearchContext context = new TestSearchContext(null, indexShard, searcher);  
            when(searchContext.mapperService()).thenReturn(mapperService);
                fail("IOException shouldn't be thrown");
            assertNull(context.queryResult().terminatedEarly());
import org.opensearch.search.internal.ContextIndexSearcher;
        {  
        assertEquals(1, context.queryResult().topDocs().topDocs.scoreDocs.length);  
            )
                StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numDocs; ++i) {
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);
        final Sort sort = new Sort(new SortField("user", SortField.Type.INT));  
            if (randomBoolean()) {
        }
            IndexSearcher.getDefaultSimilarity(),  
        );
        when(searchContext.indexShard()).thenReturn(indexShard);
            assertThat(context.queryResult().topDocs().topDocs.scoreDocs.length, equalTo(1));  
            context.queryCollectorManagers().put(TotalHitCountCollector.class, manager);
            QueryPhase.executeInternal(searchContext.withCleanQueryResult(), queryPhaseSearcher);
        assertFalse(Float.isNaN(context.queryResult().getMaxScore()));
        final IndexReader reader = DirectoryReader.open(dir);
        dir.close();  
            w.addDocument(doc);
    public void setUp() throws Exception {  
        // 2. Test a sort on long field + date field
            IndexSearcher.getDefaultQueryCachingPolicy(),  
            assertNull(context.queryResult().terminatedEarly());  
            TestSearchContext searchContext = spy(new TestSearchContext(null, indexShard, newContextSearcher(reader, executor)));
            searchContext.parsedQuery(query);
import org.apache.lucene.document.LatLonDocValuesField;  
        final int numDocs = 2 * scaledRandomIntBetween(600, 900) - 1;
        context.setSearcher(newEarlyTerminationContextSearcher(reader, size, executor));  
        RandomIndexWriter w = new RandomIndexWriter(random(), dir, iwc);
            reader,
        w.addDocument(doc);  
        context.parsedQuery(
        private final int size;
 */
        // field with doc-values but not indexed will need to collect
        reader.close();  
            QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
        // 4. Test a sort on date field + long field
        IndexWriterConfig iwc = newIndexWriterConfig().setIndexSort(sort);
            new NumberFieldType("user", NumberType.INTEGER, true, false, true, true, false, null, Collections.emptyMap())
        Sort scoreSort = new Sort(new SortField(null, SortField.Type.SCORE), new SortField(null, SortField.Type.DOC));
            doc.add(new NumericDocValuesField("rank", numDocs - i));
        QueryPhase.executeInternal(context.withCleanQueryResult(), queryPhaseSearcher);
        Directory dir = newDirectory();
import org.apache.lucene.search.Query;  
        this.queryPhaseSearcher = queryPhaseSearcher;  
        context.parsedQuery(new ParsedQuery(new MatchAllDocsQuery()));
