            return new CreateScorerOnceWeight(query.createWeight(searcher, scoreMode, boost));  
        ThreadPool.terminate(tp, 10, java.util.concurrent.TimeUnit.SECONDS);  
        CreateScorerOnceQuery(Query query) {
                // Call sendBatch  
        Document document = new Document();  
        });  
            QueryTimeout timeout = searcher.getTimeout();
            Directory directory = newDirectory();
        DirectoryReader reader = OpenSearchDirectoryReader.wrap(DirectoryReader.open(w), new ShardId(settings.getIndex(), 0));  
                @Override
/*
        @Override
        @Override  
                when(searchContext.getStreamChannelListener()).thenReturn(listener);  
            1f
        ) {
import org.apache.lucene.index.TermsEnum;
            writer.addDocument(doc);
    }
    public void testTimeoutShouldExitReturnsTrueWhenTaskCancelled() throws Exception {
            writer.commit();  
            @Override
        document.add(new StringField("field1", "value2", Field.Store.NO));  
        }  
        }
        @Override
            return in.getReaderCacheHelper();  
import org.apache.lucene.codecs.StoredFieldsReader;
                assertEquals(expectedSliceCount, slices.length);  
    private static class DocumentSubsetReader extends SequentialStoredFieldsLeafReader {
                searcher = new ContextIndexSearcher(  
    }
    }
import org.opensearch.core.index.shard.ShardId;
            QueryTimeout timeout = searcher.getTimeout();  
     * Helper that creates a {@link ContextIndexSearcher} backed by a single-doc index and a mocked
            doc.add(new StringField("field", "value", Field.Store.NO));  
            writer.addDocument(doc);
        @Override
import org.opensearch.ExceptionsHelper;
import org.apache.lucene.search.Scorable;  
        @Override
                InternalAggregation mockAggregation3 = mock(InternalSum.class);
import static org.mockito.Mockito.mock;  
    }
            QueryTimeout retainedTimeout = searcher.getTimeout();  
        IndexShard indexShard = mock(IndexShard.class);  
import org.opensearch.action.support.StreamSearchChannelListener;
        searcher.addQueryCancellation(() -> {});
                // 4 slices will be created with 3 leaves in first&last slices and 2 leaves in other slices
            Document document = new Document();  
import org.apache.lucene.index.PostingsEnum;
        /**
                    true,
        document.add(new StringField("field1", "value1", Field.Store.NO));
                assertThat(doc, equalTo(0));
import org.opensearch.core.tasks.TaskCancelledException;  
import static org.opensearch.search.internal.IndexReaderUtils.getLeaves;
                StreamSearchChannelListener listener = mock(StreamSearchChannelListener.class);
            Runnable second = () -> calls[1]++;  
        public String toString(String field) {  
        intersectScorerAndBitSet(weight.scorer(leaf), bitSet, leafCollector, () -> {});  
import org.apache.lucene.util.Accountable;
            return weight.explain(context, doc);
            } else if (liveDocs == null) {
 */  
                QuerySearchResult queryResult = new QuerySearchResult(contextId, null, null);
            assertTrue("shouldExit should return true while cancellation is active", searcher.getTimeout().shouldExit());  
                    IndexSearcher.getDefaultQueryCachingPolicy(),  
        @Override
            return query.toString(field);
                    throw new UncheckedIOException(e);
import org.opensearch.index.shard.SearchOperationListener;
            assertThat(context.reader(), instanceOf(SequentialStoredFieldsLeafReader.class));
            Document doc = new Document();  
        ) {
    }
                );  
            }
import java.io.UncheckedIOException;
        BitsetFilterCache cache = new BitsetFilterCache(settings, indicesCache, listener);  
            this.numDocs = computeNumDocs(in, roleQueryBits);
            }
        doTestContextIndexSearcher(true, false);
            super(weight.getQuery());
                    IndexSearcher.getDefaultQueryCachingPolicy(),
            iw.addDocument(document);  
     */
        w.addDocument(doc);
import java.util.concurrent.ExecutorService;
        }
            doc.add(new StringField("field", "value", Field.Store.NO));
         */
        DirectoryReader directoryReader = DirectoryReader.open(directory);
        assertEquals(0, searcher.count(new TermQuery(new Term("non_existing_field", "non_existing_value"))));
            searcher.addQueryCancellation(() -> { throw new TaskCancelledException("cancelled"); });  
                // Create a mock internal aggregation  
import org.opensearch.search.query.QuerySearchResult;
                IndexShard indexShard = mock(IndexShard.class);
    }
                when(mockAggregation.getName()).thenReturn("test_sum");
        assertEquals(ExitableDirectoryReader.class, searcher.getIndexReader().getClass());
                // Create multiple mock internal aggregations  
                );
        }
            searchContext
        final Directory directory = newDirectory();  
            assertFalse("shouldExit should return false when cancellation does not throw", searcher.getTimeout().shouldExit());
        iw.addDocument(document);
        when(searchContext.indexShard()).thenReturn(indexShard);
import org.apache.lucene.util.Bits;
import org.opensearch.test.OpenSearchTestCase;  
        public Bits getLiveDocs() {
                // apply deletes when needed:
            return true;
    public void testSendBatchWithEmptyBatch() throws Exception {  
            assertTrue(searcher.hasCancellations());  
            deleteField.setStringValue("yes");
        IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(NoMergePolicy.INSTANCE));
                return new Bits.MatchNoBits(in.maxDoc());
        }
        try (
        IndicesBitsetFilterCache indicesCache = new IndicesBitsetFilterCache(Settings.EMPTY);
                ContextIndexSearcher searcher = new ContextIndexSearcher(
        IndexSearcher searcher = new IndexSearcher(directoryReader);  
        intersectScorerAndBitSet(weight.scorer(leaf), bitSet, leafCollector, () -> {});  
            Document doc = new Document();  
import org.apache.lucene.search.BoostQuery;  
        );
            }  
                IndexSearcher.LeafSlice[] slices = searcher.slices(leaves);  
        private final int numDocs;  
                    null,
        SearchContext searchContext = mock(SearchContext.class);
 * this work for additional information regarding copyright
            assertSame(second, searcher.addQueryCancellation(second));
                @Override
        protected StoredFieldsReader doGetSequentialStoredFieldsReader(StoredFieldsReader reader) {
    }
                    searchContext
            }
        ) {
import org.apache.lucene.search.DocIdSetIterator;
        assertEquals(3, slices[1].partitions.length);
 * KIND, either express or implied.  See the License for the
    }
                    IndexSearcher.getDefaultQueryCache(),
            Document doc = new Document();  
import org.opensearch.search.aggregations.metrics.InternalSum;  
        }
        // Assert wrapping  
        SearchOperationListener searchOperationListener = new SearchOperationListener() {
        IndexWriter w = new IndexWriter(dir, newIndexWriterConfig(null));  
        w.addDocument(doc);  
                verify(listener).onStreamResponse(any(QueryFetchSearchResult.class), eq(false));
    public void testContextIndexSearcherDenseWithDeletions() throws IOException {  
import org.opensearch.threadpool.TestThreadPool;
                return new CreateScorerOnceQuery(queryRewritten);
                    null,
        for (LeafReaderContext lrc : searcher.getIndexReader().leaves()) {
import java.io.IOException;
                when(searchContext.indexShard()).thenReturn(indexShard);
            public void collect(int doc, long bucket) throws IOException {
                when(searchContext.indexShard()).thenReturn(indexShard);
        });
    }
                // slow
        });
        public CacheHelper getCoreCacheHelper() {  
            }
        IOUtils.close(reader, w, dir, indicesCache);
        sparseFixedBitSet.or(penum);  
        allowedField.setStringValue("no");
            Runnable first = () -> calls[0]++;
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.search.MatchAllDocsQuery;  
            IndexWriter writer = new IndexWriter(directory, new IndexWriterConfig(new StandardAnalyzer()))  
        private final BitsetFilterCache bitsetFilterCache;
        IntPoint pointField = new IntPoint("point", 1, 2);
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
        assertEquals(expectedSliceCount, slices.length);
    public void testTimeoutIsSetOnSearcher() throws Exception {
            if (roleQueryBits == null) {
                ContextIndexSearcher searcher = new ContextIndexSearcher(
            // add a document that matches foo:bar but will be deleted  
            null,  
 * software distributed under the License is distributed on an
                when(searchContext.indexShard()).thenReturn(indexShard);
        }  
            }
        }
import org.opensearch.search.query.QueryPhase;  
        }
            searcher.addQueryCancellation(first);
        leafCollector = new LeafBucketCollector() {  
            expectThrows(NullPointerException.class, () -> searcher.getTimeout().shouldExit());
        withContextIndexSearcher(searcher -> {  
            }
                SearchContext searchContext = mock(SearchContext.class);  
 * compatible open source license.
    }
            expectThrows(IllegalArgumentException.class, () -> searcher.addQueryCancellation(equal));
                    IndexSearcher.getDefaultQueryCachingPolicy(),
        expectedSliceCount = 2;
        StringField allowedField = new StringField("allowed", "yes", Field.Store.NO);
import org.opensearch.common.lucene.index.SequentialStoredFieldsLeafReader;
            try (DirectoryReader reader = DirectoryReader.open(directory)) {
    }  
            return 31 * classHash() + query.hashCode();
import org.apache.lucene.util.SparseFixedBitSet;  
        }
import org.apache.lucene.util.FixedBitSet;
        IndexSettings settings = IndexSettingsModule.newIndexSettings("_index", Settings.EMPTY);  
        iw.addDocument(document);
        BitsetFilterCache.Listener listener = new BitsetFilterCache.Listener() {
            writer.commit();  
                verify(listener).onStreamResponse(any(QueryFetchSearchResult.class), eq(false));  
        if (deletions) {
                assertEquals(2, slices[3].partitions.length);
                IndexShard indexShard = mock(IndexShard.class);
    public void testTimeoutShouldExitDoesNotCatchUnrelatedExceptions() throws Exception {
                FetchSearchResult fetchResult = new FetchSearchResult(contextId, null);  
        // Searching a non-existing term will trigger a null scorer
                searcher.sendBatch(batch);
import org.apache.lucene.util.BitSetIterator;  
                when(searchContext.indexShard()).thenReturn(indexShard);
import org.apache.lucene.index.DirectoryReader;
                    mock(ExecutorService.class),  
                StreamSearchChannelListener listener = mock(StreamSearchChannelListener.class);
            return weight.scorerSupplier(leafReaderContext);  
                public void run() {
            assertArrayEquals(new int[] { 1, 1 }, calls);
        @Override
import org.apache.lucene.util.BitSet;
        ContextIndexSearcher searcher = new ContextIndexSearcher(  
        CreateScorerOnceWeight(Weight weight) {  
        if (sparse) {  
                when(indexShard.getSearchOperationListener()).thenReturn(mock(SearchOperationListener.class));
                fail("docId [" + doc + "] should have been deleted");  
                when(indexShard.getSearchOperationListener()).thenReturn(mock(SearchOperationListener.class));
                    searchContext  
            assertEquals(ExitableLeafReader.class, lrc.reader().getClass());  
import org.opensearch.common.CheckedConsumer;  
        DocumentSubsetReader(LeafReader in, BitsetFilterCache bitsetFilterCache, Query roleQuery) throws IOException {
import org.apache.lucene.search.QueryVisitor;
                List<InternalAggregation> batch = Collections.singletonList(mockAggregation);
            Document doc = new Document();
        @Override
                    IndexSearcher.getDefaultSimilarity(),
        w.deleteDocuments(new Term("delete", "yes"));
        @Override
            writer.addDocument(doc);
         * <p>Construct a FilterLeafReader based on the specified base reader.  
            try (DirectoryReader reader = DirectoryReader.open(directory)) {
        SparseFixedBitSet sparseFixedBitSet = new SparseFixedBitSet(leaf.reader().maxDoc());
        int totalPartitions = 0;
                        if (liveDocs.get(doc)) {
import org.opensearch.search.aggregations.InternalAggregation;
    public void testContextIndexSearcherDenseNoDeletions() throws IOException {
            this.query = query;
import org.apache.lucene.document.IntPoint;
                    return numDocs;
        @Override
    }
            assertTrue("shouldExit should return true on TimeExceededException", searcher.getTimeout().shouldExit());  
            IndexWriter writer = new IndexWriter(directory, new IndexWriterConfig(new StandardAnalyzer()))  
                    IndexSearcher.getDefaultQueryCachingPolicy(),  
                    true,
            Runnable first = new Cancellation(1);  
                    IndexSearcher.getDefaultSimilarity(),  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
                );
        ) {
            }
    public void testSlicesWithMaxTargetSliceSupplier() throws Exception {  
            deleteField.setStringValue("no");  
            assertThat(bitSet, instanceOf(SparseFixedBitSet.class));
        }
        if (sparse) {
            assertFalse(searcher.hasCancellations());
        TopDocs topDocs = searcher.search(new BoostQuery(new ConstantScoreQuery(new TermQuery(new Term("foo", "bar"))), 3f), 1);  
                    IndexSearcher.getDefaultQueryCache(),
import org.opensearch.indices.IndicesBitsetFilterCache;
                ContextIndexSearcher searcher = new ContextIndexSearcher(
        });
                SearchContext searchContext = mock(SearchContext.class);
        doTestContextIndexSearcher(false, false);
     * {@link SearchContext}, then passes it to the provided consumer. All resources are closed  
            if (roleQueryBits == null) {  
                    searchContext  
            document.add(new StringField("field2", "value1", Field.Store.NO));
            writer.commit();  
import org.apache.lucene.document.Document;  
            assertTrue(searcher.hasCancellations());
                QuerySearchResult queryResult = new QuerySearchResult(contextId, null, null);
        bitSet = new CombinedBitSet(query(leaf, "field1", "value2"), leaf.reader().getLiveDocs());
import org.apache.lucene.search.Weight;
        document.add(new StringField("field2", "value1", Field.Store.NO));
import org.opensearch.common.util.io.IOUtils;
        bitSet = new CombinedBitSet(query(leaf, "field1", "value3"), leaf.reader().getLiveDocs());
            super(in);  
    public void testClosingSearcherClearsCancellationCallbacks() throws Exception {
    private void withContextIndexSearcher(CheckedConsumer<ContextIndexSearcher, Exception> test) throws Exception {  
        public boolean isCacheable(LeafReaderContext ctx) {
        ThreadPool tp = new TestThreadPool("test");
                    IndexSearcher.getDefaultQueryCachingPolicy(),  
import static org.opensearch.search.internal.ExitableDirectoryReader.ExitableTerms;  
            IndexSearcher.getDefaultSimilarity(),
                when(searchContext.queryResult()).thenReturn(queryResult);
                    searchContext  
                ContextIndexSearcher searcher = new ContextIndexSearcher(
            @Override
        }
            iw.commit();
        @Override
import org.apache.lucene.search.Explanation;  
 * SPDX-License-Identifier: Apache-2.0
        });  
                // Verify that the listener was called with the correct result  
 * The OpenSearch Contributors require contributions made to  
     */
        DocumentSubsetDirectoryReader filteredReader = new DocumentSubsetDirectoryReader(reader, cache, roleQuery);  
            filteredReader,
    /** Equal callbacks must be rejected as duplicates and removable through an equal instance. */  
            Directory directory = newDirectory();
        Document doc = new Document();
        withContextIndexSearcher(searcher -> {
            if (query != queryRewritten) {
     * the other active, without requiring a particular callback execution order.  
 *  
                    IndexSearcher.getDefaultQueryCache(),
            final Bits actualLiveDocs = in.getLiveDocs();
                    searchContext
            for (int i = 0; i < 1000; ++i) {
import java.util.List;
        Weight weight = searcher.createWeight(
                        return new DocumentSubsetReader(reader, bitsetFilterCache, roleQuery);
        }  
            // Not delegated since we change the live docs  
        }
            assertFalse(retainedTimeout.shouldExit());  
 * GitHub history for details.
            assertArrayEquals(new int[] { 2, 3 }, calls);  
import org.opensearch.search.fetch.FetchSearchResult;
    public void testSendBatchWithSingleAggregation() throws Exception {  
                int expectedSliceCount = 4;
            searcher.removeQueryCancellation(first);  
        }  
            assertEquals(ExitableTerms.class, lrc.reader().terms("foo").getClass());  
    public void testTimeoutShouldExitReturnsTrueWhenTimeoutExceeded() throws Exception {  
        private final Set<Object> seenLeaves = Collections.newSetFromMap(new IdentityHashMap<>());
    }  
            totalPartitions += slice.partitions.length;
import org.apache.lucene.search.ScorerSupplier;
                IndexShard indexShard = mock(IndexShard.class);
        for (LeafReaderContext lrc : searcher.getIndexReader().leaves()) {
        withContextIndexSearcher(searcher -> {  
            assertTrue(searcher.getTimeout().shouldExit());
            searcher.removeQueryCancellation(second);
import org.apache.lucene.index.IndexWriterConfig;
                when(searchContext.bucketCollectorProcessor()).thenReturn(SearchContext.NO_OP_BUCKET_COLLECTOR_PROCESSOR);  
            assertFalse(searcher.hasCancellations());  
        ) {
        private static int computeNumDocs(LeafReader reader, BitSet roleQueryBits) {  
        );
                int numDocs = 0;  
        };
            searcher.addQueryCancellation(() -> { throw new QueryPhase.TimeExceededException(); });
import static org.opensearch.search.internal.ExitableDirectoryReader.ExitableLeafReader;
                        throw ExceptionsHelper.convertToOpenSearchException(e);  
            searcher.removeQueryCancellation(equal);  
                // very slow, but necessary in order to be correct
        };
        assertEquals(3f, topDocs.scoreDocs[0].score, 0);  
import org.apache.lucene.index.FilterDirectoryReader;
import org.opensearch.common.settings.Settings;  
            this.weight = weight;
                    IndexSearcher.getDefaultQueryCache(),
            public void setScorer(Scorable scorer) throws IOException {
                FetchSearchResult fetchResult = new FetchSearchResult(contextId, null);  
        assertEquals(1, topDocs.scoreDocs.length);
        };
        directory.close();  
        iw.addDocument(document);  
        withContextIndexSearcher(searcher -> {
        doc.add(fooField);
        directoryReader.close();
    }  
    public void doTestContextIndexSearcher(boolean sparse, boolean deletions) throws IOException {
            assertSame(first, searcher.addQueryCancellation(first));  
import static org.mockito.ArgumentMatchers.eq;
                }
     * automatically.
            }
                    IndexSearcher.getDefaultQueryCachingPolicy(),  
                    reader,  
            }
                assertThat(doc, equalTo(1));  
            document.add(new StringField("field1", "value1", Field.Store.NO));
                return 0;  
            visitor.visitLeaf(this);  
    /**
                assertEquals(1, searcher.getSlices().length);  
            assertFalse(searcher.hasCancellations());
        public Explanation explain(LeafReaderContext context, int doc) throws IOException {  
        public Weight createWeight(IndexSearcher searcher, org.apache.lucene.search.ScoreMode scoreMode, float boost) throws IOException {
            public void collect(int doc, long bucket) throws IOException {
    public void testMultipleCancellationCallbacks() throws Exception {
            true,
                // Call sendBatch  
        });
            searcher.close();
                when(searchContext.getTargetMaxSliceCount()).thenReturn(4);
    }  
                when(searchContext.bucketCollectorProcessor()).thenReturn(SearchContext.NO_OP_BUCKET_COLLECTOR_PROCESSOR);  
        bitSet = new CombinedBitSet(query(leaf, "field1", "value4"), leaf.reader().getLiveDocs());
        @Override  
        protected DirectoryReader doWrapDirectoryReader(DirectoryReader in) throws IOException {  
import org.apache.lucene.index.LeafReader;
                w.addDocument(doc);  
            @Override  
        try (
        withContextIndexSearcher(searcher -> {  
package org.opensearch.search.internal;
        }  
                new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(NoMergePolicy.INSTANCE)  
            }
                SearchContext searchContext = mock(SearchContext.class);  
 *
                    throw new TaskCancelledException("cancelled");  
        public int hashCode() {  
        }  
            assertFalse(timeout.shouldExit());
import org.apache.lucene.search.Query;
        Query roleQuery = new TermQuery(new Term("allowed", "yes"));
        public int numDocs() {
         * <p>Note that base reader is closed if this FilterLeafReader is closed.</p>
        iw.deleteDocuments(new Term("field1", "value3"));  
import static org.mockito.Mockito.verify;
        final List<LeafReaderContext> leaves = getLeaves(10);
                }
        });  
            writer.addDocument(doc);
            IndexSearcher.getDefaultQueryCache(),  
        assertEquals(5, slices[0].partitions.length);
        withContextIndexSearcher(searcher -> {
        };
import org.apache.lucene.document.Field;
            SequentialStoredFieldsLeafReader lf = (SequentialStoredFieldsLeafReader) context.reader();  
            });  
                return roleQueryBits.cardinality();  
                    }
                InternalAggregation mockAggregation2 = mock(InternalSum.class);
            } else {
 * You may obtain a copy of the License at  
        }  
                }
        public CacheHelper getReaderCacheHelper() {
            return reader;  
                when(mockAggregation2.getName()).thenReturn("count_agg");
import static org.hamcrest.Matchers.instanceOf;  
                List<InternalAggregation> emptyBatch = Collections.emptyList();  
                ShardSearchContextId contextId = new ShardSearchContextId("test-session", 2L);
            }
                    null,
                test.accept(searcher);
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.test.IndexSettingsModule;
 * Licensed to Elasticsearch under one or more contributor  
    }
        StringField deleteField = new StringField("delete", "no", Field.Store.NO);  
        iw.addDocument(document);  
        IndexSearcher.LeafSlice[] slices = MaxTargetSliceSupplier.getSlicesWholeSegments(leaves, expectedSliceCount);  
                assertThat(scorer.score(), equalTo(3f));  
        withContextIndexSearcher(searcher -> {  
import org.apache.lucene.index.LeafReaderContext;  
        while (tenum.next().utf8ToString().equals(value) == false) {  
    public void testContextIndexSearcherSparseWithDeletions() throws IOException {
import java.util.IdentityHashMap;
        doTestContextIndexSearcher(true, true);  
        }
        when(searchContext.bucketCollectorProcessor()).thenReturn(SearchContext.NO_OP_BUCKET_COLLECTOR_PROCESSOR);
                when(searchContext.shouldUseConcurrentSearch()).thenReturn(false);
        DocumentSubsetDirectoryReader(DirectoryReader in, BitsetFilterCache bitsetFilterCache, Query roleQuery) throws IOException {
                when(searchContext.fetchResult()).thenReturn(fetchResult);
            Scorable scorer;
        when(indexShard.getSearchOperationListener()).thenReturn(searchOperationListener);
            }
            } else {
            final Bits liveDocs = reader.getLiveDocs();
    private SparseFixedBitSet query(LeafReaderContext leaf, String field, String value) throws IOException {  
                QuerySearchResult queryResult = new QuerySearchResult(contextId, null, null);
        assertEquals(3, slices[0].partitions.length);  
    /** The cancellation object may outlive its search context; closing the searcher must deactivate all its callbacks. */  
    public void testGetSlicesWithNonNullExecutorButCSDisabled() throws Exception {  
    }
        }
                } catch (IOException e) {  
     * Timeout and task-cancellation checks can coexist. Removing and re-adding one callback must leave
        private final Query roleQuery;  
        BitSet bitSet = cache.getBitSetProducer(roleQuery).getBitSet(reader.leaves().get(0));
 *
import static org.opensearch.search.internal.ContextIndexSearcher.intersectScorerAndBitSet;  
import static org.hamcrest.Matchers.equalTo;
        document = new Document();
        }
        public Query rewrite(IndexSearcher searcher) throws IOException {
                // Case 2: Verify the slice count when custom max slice computation is used
            searcher.addQueryCancellation(() -> { throw new TaskCancelledException("cancelled"); });
        });  
import java.util.Set;  
 * ownership. Elasticsearch licenses this file to you under  
        private final Query query;
            new BoostQuery(new ConstantScoreQuery(new TermQuery(new Term("field2", "value1"))), 3f),
            searcher.addQueryCancellation(first);  
            searcher.addQueryCancellation(() -> { throw new NullPointerException("unrelated"); });
                    IndexSearcher.getDefaultSimilarity(),
        assertEquals(5, slices[1].partitions.length);  
                    reader,  
            assertFalse("shouldExit should return false when no cancellations are registered", searcher.getTimeout().shouldExit());
                searcher.sendBatch(emptyBatch);  
                when(searchContext.bucketCollectorProcessor()).thenReturn(SearchContext.NO_OP_BUCKET_COLLECTOR_PROCESSOR);  
                );
                assertEquals(2, slices[2].partitions.length);  
            searcher.removeQueryCancellation(null);
            searcher.removeQueryCancellation(cancellation);
            assertTrue("shouldExit should return true on TaskCancelledException", searcher.getTimeout().shouldExit());
        };  
import org.opensearch.search.fetch.QueryFetchSearchResult;
                SearchContext searchContext = mock(SearchContext.class);  
        LeafCollector leafCollector = new LeafBucketCollector() {
        assertEquals(10, totalPartitions);
        assertEquals(1, topDocs.totalHits.value());
                when(searchContext.bucketCollectorProcessor()).thenReturn(SearchContext.NO_OP_BUCKET_COLLECTOR_PROCESSOR);
import org.apache.lucene.search.ConstantScoreQuery;
            public void collect(int doc, long bucket) throws IOException {
        }
                public LeafReader wrap(LeafReader reader) {
        assertEquals(2, slices[2].partitions.length);
        }
        private final BitSet roleQueryBits;
    }
            w.addDocument(doc);
            @Override
        doc.add(allowedField);  
                ShardSearchContextId contextId = new ShardSearchContextId("test-session", 3L);
            assertFalse(searcher.getTimeout().shouldExit());
        public CacheHelper getReaderCacheHelper() {
        assertEquals(1, searcher.count(new CreateScorerOnceQuery(new MatchAllDocsQuery())));
        TermsEnum tenum = leaf.reader().terms(field).iterator();
import org.apache.lucene.analysis.standard.StandardAnalyzer;
 * not use this file except in compliance with the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
            Runnable equal = new Cancellation(1);
            assertFalse(timeout.shouldExit());  
            IndexWriter iw = new IndexWriter(
            this.bitsetFilterCache = bitsetFilterCache;
            assertThat(bitSet, instanceOf(FixedBitSet.class));  
            assertFalse(timeout.shouldExit());
        final List<LeafReaderContext> leaves = getLeaves(10);
        }
                when(mockAggregation1.getName()).thenReturn("sum_agg");
            assertFalse(timeout.shouldExit());
        intersectScorerAndBitSet(weight.scorer(leaf), bitSet, leafCollector, () -> {});  
                    true,
                FetchSearchResult fetchResult = new FetchSearchResult(contextId, null);  
    public void testTimeoutShouldExitReturnsFalseWhenCancellationDoesNotThrow() throws Exception {
            searcher.removeQueryCancellation(first); // Removing an absent callback is harmless.
        iw.commit();
            assertArrayEquals(new int[] { 2, 3 }, calls);
                assertThat(doc, equalTo(3));  
    }
        return sparseFixedBitSet;
        intersectScorerAndBitSet(weight.scorer(leaf), bitSet, leafCollector, () -> {});  
            doc.add(new StringField("field", "value", Field.Store.NO));
    }
                return roleQueryBits;  
import org.opensearch.threadpool.ThreadPool;
    }
            Query queryRewritten = query.rewrite(searcher);  
                        }  
            }  
                );
                            numDocs++;
                // Call sendBatch with empty batch
            }
            assertFalse(searcher.hasCancellations());
            doc.add(new StringField("field", "value", Field.Store.NO));
            }
import java.util.Collections;  
 * under the License.  
            IndexWriter writer = new IndexWriter(directory, new IndexWriterConfig(new StandardAnalyzer()))  
            assertNotNull(lf.getSequentialStoredFieldsReader());
            return sameClassAs(obj) && query.equals(((CreateScorerOnceQuery) obj).query);
                    true,
        }  
import org.apache.lucene.search.TermQuery;  
 */  
                directory,
                // Case 1: Verify getSlices returns not null when concurrent segment search is disabled
            searcher.removeQueryCancellation(first);
        withContextIndexSearcher(searcher -> {
            final Directory directory = newDirectory();  
import org.opensearch.lucene.util.CombinedBitSet;  
        for (IndexSearcher.LeafSlice slice : slices) {  
                when(searchContext.bucketCollectorProcessor()).thenReturn(SearchContext.NO_OP_BUCKET_COLLECTOR_PROCESSOR);  
        @Override
            )
                verify(listener).onStreamResponse(any(QueryFetchSearchResult.class), eq(false));
                    IndexSearcher.getDefaultSimilarity(),
            return null;
                    IndexSearcher.getDefaultQueryCache(),
                    directoryReader,  
        leafCollector = new LeafBucketCollector() {  
    /**
import org.apache.lucene.search.LeafCollector;
        }
        public ScorerSupplier scorerSupplier(LeafReaderContext leafReaderContext) throws IOException {
                searcher.sendBatch(batch);
public class ContextIndexSearcherTests extends OpenSearchTestCase {
import org.apache.lucene.store.Directory;  
            Directory directory = newDirectory();
            }
                );
            ScoreMode.COMPLETE,  
/*  
                IndexShard indexShard = mock(IndexShard.class);
            assertArrayEquals(new int[] { 1, 2 }, calls);
        }
    public void testTimeoutShouldExitReflectsRemoval() throws Exception {  
        assertEquals(2, slices[3].partitions.length);  
                DocIdSetIterator it = new BitSetIterator(roleQueryBits, 0L); // we don't use the cost
                // Verify that the listener was called with the correct result  
    private static class CreateScorerOnceWeight extends Weight {
                when(searchContext.shouldUseConcurrentSearch()).thenReturn(true);  
        Directory dir = newDirectory();
                this.scorer = scorer;  
            assertEquals(ExitablePointValues.class, lrc.reader().getPointValues("point").getClass());
                    try {  
            writer.commit();
        } else {
    private static class DocumentSubsetDirectoryReader extends FilterDirectoryReader {
        LeafReaderContext leaf = directoryReader.leaves().get(0);
                when(searchContext.getStreamChannelListener()).thenReturn(listener);  
                    IndexSearcher.getDefaultSimilarity(),
        }
        try (
        try (
                ContextIndexSearcher searcher = new ContextIndexSearcher(
            Runnable cancellation = searcher.addQueryCancellation(() -> { throw new QueryPhase.TimeExceededException(); });
                    null,
                    true,
            return in.getCoreCacheHelper();
            @Override
        }
            assertFalse("shouldExit should return false after cancellation is removed", searcher.getTimeout().shouldExit());  
    public void testIntersectScorerAndRoleBits() throws Exception {
            record Cancellation(int id) implements Runnable {  
import static org.opensearch.search.internal.ExitableDirectoryReader.ExitablePointValues;
                    } catch (Exception e) {
        document = new Document();
import static org.mockito.Mockito.when;
                when(searchContext.queryResult()).thenReturn(queryResult);
                    for (int doc = it.nextDoc(); doc != DocIdSetIterator.NO_MORE_DOCS; doc = it.nextDoc()) {  
                    directoryReader,
            assertNotEquals(ExitableTerms.class, lrc.reader().terms("foo").getClass());
            IndexSearcher.getDefaultQueryCachingPolicy(),
    }
        int expectedSliceCount = 4;
                assertEquals(3, slices[1].partitions.length);
                List<InternalAggregation> batch = List.of(mockAggregation1, mockAggregation2, mockAggregation3);
 * Unless required by applicable law or agreed to in writing,
            try (DirectoryReader reader = DirectoryReader.open(directory)) {
import org.opensearch.index.IndexSettings;
import org.apache.lucene.search.ScoreMode;
                SearchContext searchContext = mock(SearchContext.class);  
            assertNotEquals(ExitablePointValues.class, lrc.reader().getPointValues("point").getClass());
        slices = MaxTargetSliceSupplier.getSlicesWholeSegments(leaves, expectedSliceCount);  
            return numDocs;  
                when(searchContext.fetchResult()).thenReturn(fetchResult);
        }  
        leafCollector = new LeafBucketCollector() {  
        document.add(new StringField("field1", "value3", Field.Store.NO));
                    reader,  
            int[] calls = new int[2];
                ShardSearchContextId contextId = new ShardSearchContextId("test-session", 1L);
        });
        }  
        assertEquals(1, searcher.count(new TermQuery(new Term("foo", "bar"))));
        };
            super(in, new SubReaderWrapper() {  
                when(searchContext.fetchResult()).thenReturn(fetchResult);
            } else if (actualLiveDocs == null) {
import org.apache.lucene.document.StringField;  
        public void visit(QueryVisitor visitor) {
import org.apache.lucene.search.TopDocs;
            searcher.addQueryCancellation(() -> {});
            Directory directory = newDirectory();
 */
import org.apache.lucene.index.Term;
import static org.mockito.ArgumentMatchers.any;
            @Override
            IndexWriter writer = new IndexWriter(directory, new IndexWriterConfig(new StandardAnalyzer()))  
         * @param in specified base reader.  
        assertEquals(expectedSliceCount, slices.length);
        document.add(new StringField("field2", "value1", Field.Store.NO));  
        // make sure scorers are created only once, see #1725  
            public void onRemoval(ShardId shardId, Accountable accountable) {
        }  
        doc.add(deleteField);
                when(mockAggregation3.getName()).thenReturn("avg_agg");
        document.add(new StringField("field1", "value4", Field.Store.NO));
        document.add(new StringField("field2", "value1", Field.Store.NO));
        private final Weight weight;  
                    IndexSearcher.getDefaultSimilarity(),
        PostingsEnum penum = tenum.postings(null);
import org.apache.lucene.index.IndexWriter;  
        @Override
    }
import org.opensearch.index.shard.IndexShard;  
                    searchContext  
            return new DocumentSubsetDirectoryReader(in, bitsetFilterCache, roleQuery);
        withContextIndexSearcher(searcher -> {
    private static class CreateScorerOnceQuery extends Query {  
import org.opensearch.search.aggregations.LeafBucketCollector;
                when(searchContext.indexShard()).thenReturn(indexShard);
                IndexShard indexShard = mock(IndexShard.class);  
        }
            this.roleQueryBits = bitsetFilterCache.getBitSetProducer(roleQuery).getBitSet(in.getContext());
    public void testContextIndexSearcherSparseNoDeletions() throws IOException {  
            public void collect(int doc, long bucket) throws IOException {
        for (LeafReaderContext context : searcher.getIndexReader().leaves()) {
                when(indexShard.getSearchOperationListener()).thenReturn(mock(SearchOperationListener.class));
                    IndexSearcher.getDefaultQueryCache(),  
            assertNotNull("setTimeout should have been called with MutableQueryTimeout", timeout);
        document = new Document();  
    }
                // Verify that the listener was called even with empty batch
    public void testCancellationCallbackEquality() throws Exception {
            @Override
        CombinedBitSet bitSet = new CombinedBitSet(query(leaf, "field1", "value1"), leaf.reader().getLiveDocs());  
 * this file be licensed under the Apache-2.0 license or a
                StreamSearchChannelListener listener = mock(StreamSearchChannelListener.class);
        @Override  
        doTestContextIndexSearcher(false, true);
            searcher.addQueryCancellation(() -> {});
}
import org.apache.lucene.index.NoMergePolicy;
            try (DirectoryReader directoryReader = DirectoryReader.open(directory);) {
         *
import org.apache.lucene.search.IndexSearcher;
            return super.rewrite(searcher);
        document.add(new StringField("field2", "value1", Field.Store.NO));
        @Override
        try (
/*  
                when(searchContext.getStreamChannelListener()).thenReturn(listener);  
        iw.close();
                    reader,
        StringField fooField = new StringField("foo", "bar", Field.Store.NO);
            assertTrue(retainedTimeout.shouldExit());  
import org.apache.lucene.index.QueryTimeout;  
                    null,
            w.forceMerge(1);
                InternalAggregation mockAggregation1 = mock(InternalSum.class);
                    true,  
                try {
            assertNotSame(first, equal);
                    }
    }
                assertEquals(3, slices[0].partitions.length);
                InternalAggregation mockAggregation = mock(InternalSum.class);
    public void testSendBatchWithMultipleAggregations() throws Exception {  
import org.opensearch.index.cache.bitset.BitsetFilterCache;
        }  
                return new CombinedBitSet(roleQueryBits, actualLiveDocs);  
        });
            try (DirectoryReader reader = DirectoryReader.open(directory)) {
 * Modifications Copyright OpenSearch Contributors. See
                when(searchContext.queryResult()).thenReturn(queryResult);
        doc.add(pointField);  
    public void testTimeoutShouldExitReturnsFalseWhenNoCancellations() throws Exception {
            public void onCache(ShardId shardId, Accountable accountable) {  
        withContextIndexSearcher(searcher -> {
    }  
            this.roleQuery = roleQuery;
        public boolean equals(Object obj) {
 * specific language governing permissions and limitations
