        }
import org.opensearch.search.aggregations.InternalAggregation;
                    IndexSearcher.getDefaultSimilarity(),
        CreateScorerOnceQuery(Query query) {
            assertTrue(retainedTimeout.shouldExit());
/*
        ContextIndexSearcher searcher = new ContextIndexSearcher(
            }
                when(searchContext.indexShard()).thenReturn(indexShard);
            Document doc = new Document();
                ContextIndexSearcher searcher = new ContextIndexSearcher(
 */
                IndexShard indexShard = mock(IndexShard.class);
                QuerySearchResult queryResult = new QuerySearchResult(contextId, null, null);
    }
            IndexSearcher.getDefaultQueryCachingPolicy(),
        @Override
            return reader;
            Document document = new Document();
            return sameClassAs(obj) && query.equals(((CreateScorerOnceQuery) obj).query);
import org.opensearch.common.CheckedConsumer;
        document.add(new StringField("field2", "value1", Field.Store.NO));
        // Searching a non-existing term will trigger a null scorer
                fail("docId [" + doc + "] should have been deleted");
        ) {
    }
            assertFalse(searcher.getTimeout().shouldExit());
            searcher.addQueryCancellation(() -> {});
                assertThat(scorer.score(), equalTo(3f));
        try (
            return true;
        protected StoredFieldsReader doGetSequentialStoredFieldsReader(StoredFieldsReader reader) {
            writer.commit();
            return new DocumentSubsetDirectoryReader(in, bitsetFilterCache, roleQuery);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        SparseFixedBitSet sparseFixedBitSet = new SparseFixedBitSet(leaf.reader().maxDoc());
                StreamSearchChannelListener listener = mock(StreamSearchChannelListener.class);
        @Override
            IndexWriter writer = new IndexWriter(directory, new IndexWriterConfig(new StandardAnalyzer()))
        doc.add(allowedField);
            }
                return 0;
                SearchContext searchContext = mock(SearchContext.class);
            assertSame(second, searcher.addQueryCancellation(second));
                public LeafReader wrap(LeafReader reader) {
            return numDocs;
        ThreadPool.terminate(tp, 10, java.util.concurrent.TimeUnit.SECONDS);
                // very slow, but necessary in order to be correct
                when(searchContext.getStreamChannelListener()).thenReturn(listener);
        });
            assertFalse(searcher.hasCancellations());
            searcher.removeQueryCancellation(equal);
            assertThat(context.reader(), instanceOf(SequentialStoredFieldsLeafReader.class));
import static org.hamcrest.Matchers.instanceOf;
            IndexWriter iw = new IndexWriter(
        directory.close();
                FetchSearchResult fetchResult = new FetchSearchResult(contextId, null);
            }
    public void testTimeoutShouldExitReturnsFalseWhenCancellationDoesNotThrow() throws Exception {
            public void onRemoval(ShardId shardId, Accountable accountable) {
        public Bits getLiveDocs() {
            assertFalse(searcher.hasCancellations());
            assertTrue(searcher.getTimeout().shouldExit());
            // Not delegated since we change the live docs
            Document doc = new Document();
import static org.mockito.ArgumentMatchers.any;
            return new CreateScorerOnceWeight(query.createWeight(searcher, scoreMode, boost));
                return roleQueryBits.cardinality();
            return in.getCoreCacheHelper();
            writer.addDocument(doc);
                ContextIndexSearcher searcher = new ContextIndexSearcher(
    }
        document = new Document();
    }
import java.io.UncheckedIOException;
        }
        assertEquals(5, slices[1].partitions.length);
        intersectScorerAndBitSet(weight.scorer(leaf), bitSet, leafCollector, () -> {});
                when(searchContext.fetchResult()).thenReturn(fetchResult);
        doTestContextIndexSearcher(true, true);
        };
                }
            assertSame(first, searcher.addQueryCancellation(first));
                );
                SearchContext searchContext = mock(SearchContext.class);
                    searchContext
            )
import org.opensearch.common.settings.Settings;
    public void testTimeoutShouldExitDoesNotCatchUnrelatedExceptions() throws Exception {
                    null,
    public void testCancellationCallbackEquality() throws Exception {
                return roleQueryBits;
        DocumentSubsetDirectoryReader(DirectoryReader in, BitsetFilterCache bitsetFilterCache, Query roleQuery) throws IOException {
            assertNotNull(lf.getSequentialStoredFieldsReader());
        while (tenum.next().utf8ToString().equals(value) == false) {
        iw.addDocument(document);
                    null,
                    reader,
        ) {
         * @param in specified base reader.
            });
                when(searchContext.indexShard()).thenReturn(indexShard);
        IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(NoMergePolicy.INSTANCE));
                when(indexShard.getSearchOperationListener()).thenReturn(mock(SearchOperationListener.class));
        iw.addDocument(document);
            assertFalse(timeout.shouldExit());
            public void collect(int doc, long bucket) throws IOException {
            IndexWriter writer = new IndexWriter(directory, new IndexWriterConfig(new StandardAnalyzer()))
            writer.addDocument(doc);
    }
            return null;
                );
    }
import org.opensearch.indices.IndicesBitsetFilterCache;
    }
                IndexShard indexShard = mock(IndexShard.class);
            writer.addDocument(doc);
     */
            super(weight.getQuery());
            assertThat(bitSet, instanceOf(SparseFixedBitSet.class));
                ContextIndexSearcher searcher = new ContextIndexSearcher(
 * software distributed under the License is distributed on an
            return 31 * classHash() + query.hashCode();
            // add a document that matches foo:bar but will be deleted
            }
            new BoostQuery(new ConstantScoreQuery(new TermQuery(new Term("field2", "value1"))), 3f),
 * ownership. Elasticsearch licenses this file to you under
                    IndexSearcher.getDefaultSimilarity(),
    public void testTimeoutShouldExitReturnsTrueWhenTimeoutExceeded() throws Exception {
                // apply deletes when needed:
import org.opensearch.core.tasks.TaskCancelledException;
        }
    public void testContextIndexSearcherSparseNoDeletions() throws IOException {
        TermsEnum tenum = leaf.reader().terms(field).iterator();
import org.opensearch.common.util.io.IOUtils;
                when(mockAggregation1.getName()).thenReturn("sum_agg");
import org.apache.lucene.index.DirectoryReader;
                List<InternalAggregation> emptyBatch = Collections.emptyList();
import org.apache.lucene.index.TermsEnum;
    private static class CreateScorerOnceWeight extends Weight {
        SearchContext searchContext = mock(SearchContext.class);
            null,
        });
            assertArrayEquals(new int[] { 2, 3 }, calls);
        leafCollector = new LeafBucketCollector() {
        DirectoryReader reader = OpenSearchDirectoryReader.wrap(DirectoryReader.open(w), new ShardId(settings.getIndex(), 0));
        }
                ShardSearchContextId contextId = new ShardSearchContextId("test-session", 3L);
        document.add(new StringField("field1", "value3", Field.Store.NO));
import org.opensearch.search.aggregations.LeafBucketCollector;
        };
            doc.add(new StringField("field", "value", Field.Store.NO));
                    mock(ExecutorService.class),
            ScoreMode.COMPLETE,
                when(searchContext.indexShard()).thenReturn(indexShard);
public class ContextIndexSearcherTests extends OpenSearchTestCase {
        doTestContextIndexSearcher(true, false);
                        if (liveDocs.get(doc)) {
        assertEquals(3, slices[0].partitions.length);
            }
                DocIdSetIterator it = new BitSetIterator(roleQueryBits, 0L); // we don't use the cost
                    IndexSearcher.getDefaultQueryCachingPolicy(),
        document.add(new StringField("field1", "value4", Field.Store.NO));
        }
                    searchContext
                        }
    public void testContextIndexSearcherSparseWithDeletions() throws IOException {
            doc.add(new StringField("field", "value", Field.Store.NO));
            doc.add(new StringField("field", "value", Field.Store.NO));
import org.opensearch.common.lucene.index.SequentialStoredFieldsLeafReader;
            assertEquals(ExitableLeafReader.class, lrc.reader().getClass());
                    IndexSearcher.getDefaultSimilarity(),
        try (
    }
            final Directory directory = newDirectory();
        @Override
        leafCollector = new LeafBucketCollector() {
        Directory dir = newDirectory();
            public void collect(int doc, long bucket) throws IOException {
        ) {
            try (DirectoryReader reader = DirectoryReader.open(directory)) {
                IndexShard indexShard = mock(IndexShard.class);
 * The OpenSearch Contributors require contributions made to
 */
        int expectedSliceCount = 4;
import org.apache.lucene.index.LeafReaderContext;
        public boolean isCacheable(LeafReaderContext ctx) {
import org.opensearch.action.support.StreamSearchChannelListener;
                ShardSearchContextId contextId = new ShardSearchContextId("test-session", 1L);
        IndexSearcher.LeafSlice[] slices = MaxTargetSliceSupplier.getSlicesWholeSegments(leaves, expectedSliceCount);
            searchContext
                StreamSearchChannelListener listener = mock(StreamSearchChannelListener.class);
        }
            document.add(new StringField("field2", "value1", Field.Store.NO));
            public void setScorer(Scorable scorer) throws IOException {
                );
        expectedSliceCount = 2;
import org.apache.lucene.document.IntPoint;
            searcher.close();
                    IndexSearcher.getDefaultQueryCache(),
                    true,
        }
            Directory directory = newDirectory();
                when(searchContext.getTargetMaxSliceCount()).thenReturn(4);
        assertEquals(10, totalPartitions);
            Directory directory = newDirectory();
        for (IndexSearcher.LeafSlice slice : slices) {
import org.apache.lucene.document.Field;
    }
import static org.opensearch.search.internal.IndexReaderUtils.getLeaves;
        when(searchContext.bucketCollectorProcessor()).thenReturn(SearchContext.NO_OP_BUCKET_COLLECTOR_PROCESSOR);
import org.opensearch.search.query.QuerySearchResult;
        StringField fooField = new StringField("foo", "bar", Field.Store.NO);
            assertFalse(timeout.shouldExit());
        PostingsEnum penum = tenum.postings(null);
                        return new DocumentSubsetReader(reader, bitsetFilterCache, roleQuery);
                when(searchContext.queryResult()).thenReturn(queryResult);
import org.apache.lucene.search.DocIdSetIterator;
        final Directory directory = newDirectory();
 * Unless required by applicable law or agreed to in writing,
import static org.mockito.Mockito.when;
        StringField allowedField = new StringField("allowed", "yes", Field.Store.NO);
            assertTrue("shouldExit should return true on TaskCancelledException", searcher.getTimeout().shouldExit());
        bitSet = new CombinedBitSet(query(leaf, "field1", "value4"), leaf.reader().getLiveDocs());
import org.apache.lucene.index.IndexWriter;
        Document document = new Document();
        Query roleQuery = new TermQuery(new Term("allowed", "yes"));
                // Call sendBatch
 * the Apache License, Version 2.0 (the "License"); you may
            searcher.removeQueryCancellation(first);
import org.apache.lucene.search.LeafCollector;
    private static class CreateScorerOnceQuery extends Query {
            try (DirectoryReader directoryReader = DirectoryReader.open(directory);) {
                    null,
                SearchContext searchContext = mock(SearchContext.class);
import org.apache.lucene.search.QueryVisitor;
        private final Query query;
    }
                ShardSearchContextId contextId = new ShardSearchContextId("test-session", 2L);
import org.apache.lucene.search.TermQuery;
        }
        DirectoryReader directoryReader = DirectoryReader.open(directory);
        bitSet = new CombinedBitSet(query(leaf, "field1", "value3"), leaf.reader().getLiveDocs());
        private final Weight weight;
            @Override
    public void testSendBatchWithSingleAggregation() throws Exception {
    }
        document = new Document();
            filteredReader,
            return in.getReaderCacheHelper();
                @Override
        assertEquals(2, slices[3].partitions.length);
        @Override
                    directoryReader,
        public CacheHelper getReaderCacheHelper() {
            assertTrue(searcher.hasCancellations());
                when(searchContext.queryResult()).thenReturn(queryResult);
import java.util.IdentityHashMap;
                QuerySearchResult queryResult = new QuerySearchResult(contextId, null, null);
            if (query != queryRewritten) {
            assertThat(bitSet, instanceOf(FixedBitSet.class));
        }
            writer.commit();
        private static int computeNumDocs(LeafReader reader, BitSet roleQueryBits) {
        assertEquals(0, searcher.count(new TermQuery(new Term("non_existing_field", "non_existing_value"))));
    /**
        // Assert wrapping
        public void visit(QueryVisitor visitor) {
            doc.add(new StringField("field", "value", Field.Store.NO));
import org.apache.lucene.search.BoostQuery;
            }
        private final BitSet roleQueryBits;
import static org.opensearch.search.internal.ExitableDirectoryReader.ExitablePointValues;
            int[] calls = new int[2];
        searcher.addQueryCancellation(() -> {});
            for (int i = 0; i < 1000; ++i) {
        document.add(new StringField("field1", "value2", Field.Store.NO));
        document.add(new StringField("field2", "value1", Field.Store.NO));
        TopDocs topDocs = searcher.search(new BoostQuery(new ConstantScoreQuery(new TermQuery(new Term("foo", "bar"))), 3f), 1);
        Weight weight = searcher.createWeight(
         */
                // Call sendBatch
                    } catch (Exception e) {
import org.opensearch.index.IndexSettings;
    }
        CombinedBitSet bitSet = new CombinedBitSet(query(leaf, "field1", "value1"), leaf.reader().getLiveDocs());
        IndexSearcher searcher = new IndexSearcher(directoryReader);
            searcher.removeQueryCancellation(null);
            IndexSearcher.getDefaultQueryCache(),
    public void testGetSlicesWithNonNullExecutorButCSDisabled() throws Exception {
                w.addDocument(doc);
    private SparseFixedBitSet query(LeafReaderContext leaf, String field, String value) throws IOException {
import org.apache.lucene.document.StringField;
            }
            public void collect(int doc, long bucket) throws IOException {
            searcher.removeQueryCancellation(second);
import java.util.List;
            }
        @Override
                    true,
                // 4 slices will be created with 3 leaves in first&last slices and 2 leaves in other slices
        withContextIndexSearcher(searcher -> {
import org.opensearch.test.IndexSettingsModule;
            this.query = query;
 * GitHub history for details.
            public void onCache(ShardId shardId, Accountable accountable) {
import org.apache.lucene.util.BitSet;
            assertArrayEquals(new int[] { 2, 3 }, calls);
                    reader,
            IndexWriter writer = new IndexWriter(directory, new IndexWriterConfig(new StandardAnalyzer()))
                    IndexSearcher.getDefaultQueryCachingPolicy(),
            Scorable scorer;
        LeafReaderContext leaf = directoryReader.leaves().get(0);
 * this file be licensed under the Apache-2.0 license or a
                searcher = new ContextIndexSearcher(
        }
                new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(NoMergePolicy.INSTANCE)
                    IndexSearcher.getDefaultQueryCache(),
        LeafCollector leafCollector = new LeafBucketCollector() {
        }
}
     * Helper that creates a {@link ContextIndexSearcher} backed by a single-doc index and a mocked
        document.add(new StringField("field1", "value1", Field.Store.NO));
        IOUtils.close(reader, w, dir, indicesCache);
                assertEquals(3, slices[1].partitions.length);
                    null,
                // Verify that the listener was called with the correct result
        for (LeafReaderContext lrc : searcher.getIndexReader().leaves()) {
    private static class DocumentSubsetReader extends SequentialStoredFieldsLeafReader {
            }
            searcher.removeQueryCancellation(cancellation);
                    throw new UncheckedIOException(e);
                assertEquals(3, slices[0].partitions.length);
            searcher.addQueryCancellation(() -> { throw new TaskCancelledException("cancelled"); });
                assertThat(doc, equalTo(0));
        @Override
        @Override
            QueryTimeout timeout = searcher.getTimeout();
        Document doc = new Document();
                InternalAggregation mockAggregation1 = mock(InternalSum.class);
                List<InternalAggregation> batch = Collections.singletonList(mockAggregation);
        iw.close();
                when(searchContext.getStreamChannelListener()).thenReturn(listener);
        withContextIndexSearcher(searcher -> {
        // make sure scorers are created only once, see #1725
                    IndexSearcher.getDefaultQueryCache(),
import static org.hamcrest.Matchers.equalTo;
                when(searchContext.bucketCollectorProcessor()).thenReturn(SearchContext.NO_OP_BUCKET_COLLECTOR_PROCESSOR);
                    }
    }
        }
        final List<LeafReaderContext> leaves = getLeaves(10);
                // Create multiple mock internal aggregations
        BitsetFilterCache cache = new BitsetFilterCache(settings, indicesCache, listener);
            expectThrows(NullPointerException.class, () -> searcher.getTimeout().shouldExit());
                );
                // Verify that the listener was called with the correct result
                InternalAggregation mockAggregation = mock(InternalSum.class);
import static org.mockito.Mockito.mock;
        for (LeafReaderContext lrc : searcher.getIndexReader().leaves()) {
            assertFalse("shouldExit should return false after cancellation is removed", searcher.getTimeout().shouldExit());
import org.apache.lucene.search.MatchAllDocsQuery;
    }
                when(mockAggregation.getName()).thenReturn("test_sum");
        }
                when(searchContext.indexShard()).thenReturn(indexShard);
        @Override
        public CacheHelper getCoreCacheHelper() {
                QuerySearchResult queryResult = new QuerySearchResult(contextId, null, null);
            assertArrayEquals(new int[] { 1, 2 }, calls);
        };
                SearchContext searchContext = mock(SearchContext.class);
    public void doTestContextIndexSearcher(boolean sparse, boolean deletions) throws IOException {
                // Create a mock internal aggregation
import org.opensearch.search.fetch.FetchSearchResult;
                List<InternalAggregation> batch = List.of(mockAggregation1, mockAggregation2, mockAggregation3);
    }
 * SPDX-License-Identifier: Apache-2.0
        });
        };
            } else if (actualLiveDocs == null) {
            QueryTimeout retainedTimeout = searcher.getTimeout();
    public void testIntersectScorerAndRoleBits() throws Exception {
            QueryTimeout timeout = searcher.getTimeout();
            iw.addDocument(document);
        document = new Document();
import org.opensearch.threadpool.TestThreadPool;
                when(searchContext.shouldUseConcurrentSearch()).thenReturn(true);
            iw.commit();
            assertTrue("shouldExit should return true on TimeExceededException", searcher.getTimeout().shouldExit());
            Document doc = new Document();
                        throw ExceptionsHelper.convertToOpenSearchException(e);
import org.apache.lucene.search.Weight;
            @Override
                when(indexShard.getSearchOperationListener()).thenReturn(mock(SearchOperationListener.class));
        doTestContextIndexSearcher(false, true);
import org.apache.lucene.util.BitSetIterator;
                verify(listener).onStreamResponse(any(QueryFetchSearchResult.class), eq(false));
            searcher.addQueryCancellation(first);
                    }
            searcher.addQueryCancellation(first);
                when(searchContext.bucketCollectorProcessor()).thenReturn(SearchContext.NO_OP_BUCKET_COLLECTOR_PROCESSOR);
 *
 * compatible open source license.
import java.io.IOException;
        iw.commit();
        }
                IndexShard indexShard = mock(IndexShard.class);
 * not use this file except in compliance with the License.
            assertFalse(searcher.hasCancellations());
                    reader,
            super(in, new SubReaderWrapper() {
            searcher.removeQueryCancellation(first); // Removing an absent callback is harmless.
import org.apache.lucene.index.NoMergePolicy;
import org.apache.lucene.search.ScoreMode;
        }
        when(indexShard.getSearchOperationListener()).thenReturn(searchOperationListener);
        @Override
    }
                    directoryReader,
        ) {
        leafCollector = new LeafBucketCollector() {
                assertEquals(2, slices[2].partitions.length);
import org.opensearch.index.shard.IndexShard;
            return super.rewrite(searcher);
        iw.addDocument(document);
        }
import org.opensearch.ExceptionsHelper;
        @Override
                FetchSearchResult fetchResult = new FetchSearchResult(contextId, null);
        when(searchContext.indexShard()).thenReturn(indexShard);
                public void run() {
            }
            searcher.removeQueryCancellation(first);
        public Explanation explain(LeafReaderContext context, int doc) throws IOException {
        ) {
        }
            this.numDocs = computeNumDocs(in, roleQueryBits);
import org.apache.lucene.util.Accountable;
        intersectScorerAndBitSet(weight.scorer(leaf), bitSet, leafCollector, () -> {});
                }
import org.apache.lucene.search.IndexSearcher;
        assertEquals(expectedSliceCount, slices.length);
            assertArrayEquals(new int[] { 1, 1 }, calls);
            IndexSearcher.getDefaultSimilarity(),
        public Weight createWeight(IndexSearcher searcher, org.apache.lucene.search.ScoreMode scoreMode, float boost) throws IOException {
import org.apache.lucene.search.ConstantScoreQuery;
 * Licensed to Elasticsearch under one or more contributor
        }
        intersectScorerAndBitSet(weight.scorer(leaf), bitSet, leafCollector, () -> {});
                }
        }
            }
            assertEquals(ExitablePointValues.class, lrc.reader().getPointValues("point").getClass());
import org.apache.lucene.index.PostingsEnum;
                verify(listener).onStreamResponse(any(QueryFetchSearchResult.class), eq(false));
            this.weight = weight;
                searcher.sendBatch(emptyBatch);
            }
        iw.deleteDocuments(new Term("field1", "value3"));
            record Cancellation(int id) implements Runnable {
    private void withContextIndexSearcher(CheckedConsumer<ContextIndexSearcher, Exception> test) throws Exception {
import org.opensearch.lucene.util.CombinedBitSet;
        /**
        if (deletions) {
    }
import org.opensearch.search.query.QueryPhase;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
    public void testContextIndexSearcherDenseWithDeletions() throws IOException {
                    searchContext
                when(searchContext.bucketCollectorProcessor()).thenReturn(SearchContext.NO_OP_BUCKET_COLLECTOR_PROCESSOR);
        @Override
                try {
        IndexWriter w = new IndexWriter(dir, newIndexWriterConfig(null));
import org.apache.lucene.index.LeafReader;
        }
        withContextIndexSearcher(searcher -> {
 * You may obtain a copy of the License at
                // slow
import org.apache.lucene.index.IndexWriterConfig;
        assertEquals(1, searcher.count(new TermQuery(new Term("foo", "bar"))));
     * the other active, without requiring a particular callback execution order.
                when(searchContext.getStreamChannelListener()).thenReturn(listener);
        );
        withContextIndexSearcher(searcher -> {
        try (
        if (sparse) {
    }
        IntPoint pointField = new IntPoint("point", 1, 2);
        });
            }
 */
                // Case 1: Verify getSlices returns not null when concurrent segment search is disabled
         * <p>Construct a FilterLeafReader based on the specified base reader.
/*
import org.opensearch.index.shard.SearchOperationListener;
import org.apache.lucene.codecs.StoredFieldsReader;
        assertEquals(1, topDocs.scoreDocs.length);
        };
        }
        });
                directory,
            writer.commit();
    public void testMultipleCancellationCallbacks() throws Exception {
        sparseFixedBitSet.or(penum);
            if (roleQueryBits == null) {
                searcher.sendBatch(batch);
        }
                    true,
        private final BitsetFilterCache bitsetFilterCache;
            assertFalse("shouldExit should return false when cancellation does not throw", searcher.getTimeout().shouldExit());
            @Override
        }
import org.apache.lucene.search.Query;
    public void testTimeoutShouldExitReturnsTrueWhenTaskCancelled() throws Exception {
import org.opensearch.search.aggregations.metrics.InternalSum;
        assertEquals(5, slices[0].partitions.length);
                    searchContext
        };
                return new CombinedBitSet(roleQueryBits, actualLiveDocs);
            assertFalse(timeout.shouldExit());
    public void testClosingSearcherClearsCancellationCallbacks() throws Exception {
        assertEquals(ExitableDirectoryReader.class, searcher.getIndexReader().getClass());
        });
            Document doc = new Document();
                this.scorer = scorer;
        );
        DocumentSubsetDirectoryReader filteredReader = new DocumentSubsetDirectoryReader(reader, cache, roleQuery);
        int totalPartitions = 0;
            writer.addDocument(doc);
        try (
         *
                );
    }
        directoryReader.close();
                    IndexSearcher.getDefaultSimilarity(),
        withContextIndexSearcher(searcher -> {
                    IndexSearcher.getDefaultSimilarity(),
        @Override
                ContextIndexSearcher searcher = new ContextIndexSearcher(
            w.forceMerge(1);
            return query.toString(field);
                StreamSearchChannelListener listener = mock(StreamSearchChannelListener.class);
            Runnable second = () -> calls[1]++;
        doc.add(deleteField);
                    IndexSearcher.getDefaultQueryCache(),
                when(searchContext.fetchResult()).thenReturn(fetchResult);
import static org.opensearch.search.internal.ContextIndexSearcher.intersectScorerAndBitSet;
        assertEquals(1, searcher.count(new CreateScorerOnceQuery(new MatchAllDocsQuery())));
                return new Bits.MatchNoBits(in.maxDoc());
    public void testTimeoutIsSetOnSearcher() throws Exception {
            assertTrue("shouldExit should return true while cancellation is active", searcher.getTimeout().shouldExit());
            } else if (liveDocs == null) {
                    return numDocs;
                    IndexSearcher.getDefaultQueryCache(),
        public boolean equals(Object obj) {
                // Call sendBatch with empty batch
        final List<LeafReaderContext> leaves = getLeaves(10);
                ContextIndexSearcher searcher = new ContextIndexSearcher(
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.search.Explanation;
import org.apache.lucene.store.Directory;
            Directory directory = newDirectory();
    public void testSendBatchWithMultipleAggregations() throws Exception {
        allowedField.setStringValue("no");
            assertFalse(retainedTimeout.shouldExit());
            }
 * specific language governing permissions and limitations
import org.apache.lucene.util.FixedBitSet;
        if (sparse) {
    public void testSendBatchWithEmptyBatch() throws Exception {
                // Verify that the listener was called even with empty batch
            } else {
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.test.OpenSearchTestCase;
import java.util.concurrent.ExecutorService;
        private final int numDocs;
                assertThat(doc, equalTo(1));
            this.roleQueryBits = bitsetFilterCache.getBitSetProducer(roleQuery).getBitSet(in.getContext());
        document.add(new StringField("field2", "value1", Field.Store.NO));
            1f
            @Override
 * under the License.
import org.apache.lucene.util.Bits;
            return weight.explain(context, doc);
     * Timeout and task-cancellation checks can coexist. Removing and re-adding one callback must leave
                FetchSearchResult fetchResult = new FetchSearchResult(contextId, null);
            assertFalse("shouldExit should return false when no cancellations are registered", searcher.getTimeout().shouldExit());
                // Case 2: Verify the slice count when custom max slice computation is used
            @Override
        protected DirectoryReader doWrapDirectoryReader(DirectoryReader in) throws IOException {
                return new CreateScorerOnceQuery(queryRewritten);
            public void collect(int doc, long bucket) throws IOException {
        public Query rewrite(IndexSearcher searcher) throws IOException {
            SequentialStoredFieldsLeafReader lf = (SequentialStoredFieldsLeafReader) context.reader();
            true,
            @Override
     * automatically.
                } catch (IOException e) {
import org.opensearch.core.index.shard.ShardId;
                assertThat(doc, equalTo(3));
    }
                IndexShard indexShard = mock(IndexShard.class);
    /**
        });
            try (DirectoryReader reader = DirectoryReader.open(directory)) {
        w.addDocument(doc);
import org.apache.lucene.search.TopDocs;
        doTestContextIndexSearcher(false, false);
                @Override
            Runnable first = new Cancellation(1);
        @Override
import org.apache.lucene.index.FilterDirectoryReader;
import org.apache.lucene.util.SparseFixedBitSet;
                InternalAggregation mockAggregation2 = mock(InternalSum.class);
        public ScorerSupplier scorerSupplier(LeafReaderContext leafReaderContext) throws IOException {
            w.addDocument(doc);
            assertNotEquals(ExitablePointValues.class, lrc.reader().getPointValues("point").getClass());
            visitor.visitLeaf(this);
    public void testSlicesWithMaxTargetSliceSupplier() throws Exception {
            } else {
import static org.opensearch.search.internal.ExitableDirectoryReader.ExitableTerms;
                when(mockAggregation3.getName()).thenReturn("avg_agg");
        assertEquals(3, slices[1].partitions.length);
    private static class DocumentSubsetDirectoryReader extends FilterDirectoryReader {
        DocumentSubsetReader(LeafReader in, BitsetFilterCache bitsetFilterCache, Query roleQuery) throws IOException {
        @Override
            assertTrue(searcher.hasCancellations());
        return sparseFixedBitSet;
                    for (int doc = it.nextDoc(); doc != DocIdSetIterator.NO_MORE_DOCS; doc = it.nextDoc()) {
            assertFalse(timeout.shouldExit());
import org.opensearch.index.cache.bitset.BitsetFilterCache;
        SearchOperationListener searchOperationListener = new SearchOperationListener() {
            deleteField.setStringValue("yes");
        public int hashCode() {
        private final Query roleQuery;
        public int numDocs() {
                assertEquals(expectedSliceCount, slices.length);
            IndexWriter writer = new IndexWriter(directory, new IndexWriterConfig(new StandardAnalyzer()))
        doc.add(fooField);
    /** Equal callbacks must be rejected as duplicates and removable through an equal instance. */
                SearchContext searchContext = mock(SearchContext.class);
        BitSet bitSet = cache.getBitSetProducer(roleQuery).getBitSet(reader.leaves().get(0));
            final Bits actualLiveDocs = in.getLiveDocs();
    }
        assertEquals(1, topDocs.totalHits.value());
                    true,
        IndexShard indexShard = mock(IndexShard.class);
            searcher.addQueryCancellation(() -> {});
/*
                when(indexShard.getSearchOperationListener()).thenReturn(mock(SearchOperationListener.class));
        slices = MaxTargetSliceSupplier.getSlicesWholeSegments(leaves, expectedSliceCount);
    }
            Directory directory = newDirectory();
            assertNotNull("setTimeout should have been called with MutableQueryTimeout", timeout);
        });
        }
        public CacheHelper getReaderCacheHelper() {
                    true,
            super(in);
            }
        IndicesBitsetFilterCache indicesCache = new IndicesBitsetFilterCache(Settings.EMPTY);
                    true,
        StringField deleteField = new StringField("delete", "no", Field.Store.NO);
        doc.add(pointField);
                searcher.sendBatch(batch);
                InternalAggregation mockAggregation3 = mock(InternalSum.class);
    }
        bitSet = new CombinedBitSet(query(leaf, "field1", "value2"), leaf.reader().getLiveDocs());
            assertNotSame(first, equal);
            Runnable first = () -> calls[0]++;
            final Bits liveDocs = reader.getLiveDocs();
        intersectScorerAndBitSet(weight.scorer(leaf), bitSet, leafCollector, () -> {});
            searcher.addQueryCancellation(() -> { throw new NullPointerException("unrelated"); });
         * <p>Note that base reader is closed if this FilterLeafReader is closed.</p>
                    searchContext
            return weight.scorerSupplier(leafReaderContext);
import org.apache.lucene.search.Scorable;
 *
            totalPartitions += slice.partitions.length;
        }
        withContextIndexSearcher(searcher -> {
        w.deleteDocuments(new Term("delete", "yes"));
            expectThrows(IllegalArgumentException.class, () -> searcher.addQueryCancellation(equal));
        }
            searcher.addQueryCancellation(() -> { throw new QueryPhase.TimeExceededException(); });
            }
                assertEquals(2, slices[3].partitions.length);
        BitsetFilterCache.Listener listener = new BitsetFilterCache.Listener() {
        withContextIndexSearcher(searcher -> {
        CreateScorerOnceWeight(Weight weight) {
        assertEquals(3f, topDocs.scoreDocs[0].score, 0);
    }
                );
                    IndexSearcher.getDefaultQueryCachingPolicy(),
        }
import org.apache.lucene.document.Document;
import static org.mockito.Mockito.verify;
            searcher.addQueryCancellation(() -> { throw new TaskCancelledException("cancelled"); });
import static org.opensearch.search.internal.ExitableDirectoryReader.ExitableLeafReader;
            }
 *
                when(searchContext.fetchResult()).thenReturn(fetchResult);
            this.bitsetFilterCache = bitsetFilterCache;
                verify(listener).onStreamResponse(any(QueryFetchSearchResult.class), eq(false));
package org.opensearch.search.internal;
    }
                when(searchContext.queryResult()).thenReturn(queryResult);
        }
            try (DirectoryReader reader = DirectoryReader.open(directory)) {
        assertEquals(expectedSliceCount, slices.length);
     * {@link SearchContext}, then passes it to the provided consumer. All resources are closed
        ThreadPool tp = new TestThreadPool("test");
     */
                when(searchContext.shouldUseConcurrentSearch()).thenReturn(false);
        iw.addDocument(document);
 * license agreements. See the NOTICE file distributed with
            assertEquals(ExitableTerms.class, lrc.reader().terms("foo").getClass());
        }
            writer.commit();
            try (DirectoryReader reader = DirectoryReader.open(directory)) {
        });
                when(searchContext.bucketCollectorProcessor()).thenReturn(SearchContext.NO_OP_BUCKET_COLLECTOR_PROCESSOR);
import org.opensearch.threadpool.ThreadPool;
import org.apache.lucene.index.QueryTimeout;
        w.addDocument(doc);
            assertFalse(searcher.hasCancellations());
        IndexSettings settings = IndexSettingsModule.newIndexSettings("_index", Settings.EMPTY);
        }
                when(searchContext.indexShard()).thenReturn(indexShard);
                    reader,
            if (roleQueryBits == null) {
        withContextIndexSearcher(searcher -> {
        withContextIndexSearcher(searcher -> {
    public void testContextIndexSearcherDenseNoDeletions() throws IOException {
            Query queryRewritten = query.rewrite(searcher);
        document.add(new StringField("field2", "value1", Field.Store.NO));
                    null,
    }
 * this work for additional information regarding copyright
    }
        try (
        public String toString(String field) {
        }
            @Override
import org.apache.lucene.search.ScorerSupplier;
        for (LeafReaderContext context : searcher.getIndexReader().leaves()) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        withContextIndexSearcher(searcher -> {
                            numDocs++;
                when(mockAggregation2.getName()).thenReturn("count_agg");
        @Override
        }
import java.util.Collections;
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
            document.add(new StringField("field1", "value1", Field.Store.NO));
    public void testTimeoutShouldExitReturnsFalseWhenNoCancellations() throws Exception {
                    IndexSearcher.getDefaultQueryCachingPolicy(),
                assertEquals(1, searcher.getSlices().length);
        private final Set<Object> seenLeaves = Collections.newSetFromMap(new IdentityHashMap<>());
        assertEquals(2, slices[2].partitions.length);
        });
        } else {
        }
import org.apache.lucene.index.Term;
                    searchContext
        @Override
    /** The cancellation object may outlive its search context; closing the searcher must deactivate all its callbacks. */
import java.util.Set;
                    IndexSearcher.getDefaultQueryCachingPolicy(),
        }
                    IndexSearcher.getDefaultQueryCache(),
                    IndexSearcher.getDefaultQueryCachingPolicy(),
                int expectedSliceCount = 4;
                    throw new TaskCancelledException("cancelled");
                int numDocs = 0;
            Runnable equal = new Cancellation(1);
                    try {
            Runnable cancellation = searcher.addQueryCancellation(() -> { throw new QueryPhase.TimeExceededException(); });
                when(searchContext.bucketCollectorProcessor()).thenReturn(SearchContext.NO_OP_BUCKET_COLLECTOR_PROCESSOR);
    public void testTimeoutShouldExitReflectsRemoval() throws Exception {
import org.opensearch.search.fetch.QueryFetchSearchResult;
import static org.mockito.ArgumentMatchers.eq;
            this.roleQuery = roleQuery;
            assertNotEquals(ExitableTerms.class, lrc.reader().terms("foo").getClass());
                test.accept(searcher);
            deleteField.setStringValue("no");
                IndexSearcher.LeafSlice[] slices = searcher.slices(leaves);
                    IndexSearcher.getDefaultSimilarity(),
