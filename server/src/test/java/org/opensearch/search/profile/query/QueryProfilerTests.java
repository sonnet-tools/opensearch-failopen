        assertThat(breakdown.get(QueryTimingType.CREATE_WEIGHT.toString()), greaterThan(0L));
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
    public void testBasic() throws IOException {  
import org.apache.lucene.index.Term;
                            throw new UnsupportedOperationException();  
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (executor != null) {  
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.MATCH), equalTo(0L));
                }
import org.opensearch.search.profile.Timer;
        searcher.search(query, 1, Sort.INDEXORDER); // scores are not needed
        Map<String, Long> breakdown = profileResult.getTimeBreakdown();  
import org.junit.After;
    }
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.ADVANCE), equalTo(0L));
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.BUILD_SCORER + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));  
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.MATCH), equalTo(0L));
 *
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.SCORE + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));
            assertThat(profileResult.getAvgSliceTime(), is(nullValue()));  
    }
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.NEXT_DOC + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
        assertEquals(1, results.size());
import java.io.IOException;
        assertThat(breakdown.get(QueryTimingType.ADVANCE.toString()), equalTo(0L));  
        profiler.pollLastElement();  
        RandomIndexWriter w = new RandomIndexWriter(random(), dir);
import org.junit.Before;
import java.util.concurrent.Executors;
            assertThat(profileResult.getMaxSliceTime(), is(not(nullValue())));
    }
        assertThat(breakdown.get(QueryTimingType.ADVANCE + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.BUILD_SCORER + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
            : new QueryProfiler(new InternalQueryProfileTree(customPluginMetrics));
        Map<String, Long> breakdown = profileResult.getTimeBreakdown();  
 * You may obtain a copy of the License at  
        searcher.setProfiler(profiler);
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.ADVANCE), equalTo(0L));
        assertNotNull(profile);  
import org.apache.lucene.tests.index.RandomIndexWriter;
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.SCORE + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
        assertThat(breakdown.get(QueryTimingType.BUILD_SCORER + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));  
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.ADVANCE + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));
        Function<Query, Collection<Supplier<ProfileMetric>>> customPluginMetrics = (query) -> List.of(() -> new Timer("plugin_timer"));
import org.apache.lucene.index.IndexWriter;
        for (int i = 0; i < numDocs; ++i) {
 * software distributed under the License is distributed on an
    }  
import static org.mockito.Mockito.when;  
 * KIND, either express or implied.  See the License for the
 * under the License.  
        when(searchContext.indexShard()).thenReturn(indexShard);  
    public void testScorerSupplier() throws IOException {  
        ProfileResult profileResult = results.get(0);
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.SCORE), greaterThan(0L));
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.ADVANCE), equalTo(0L));  
    @After
    @Before  
        dir = null;
            reader,  
package org.opensearch.search.profile.query;
                @Override
 *  
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.SCORE), equalTo(0L));  
        long time = profileCollector.getTime();
import org.apache.lucene.search.ScorerSupplier;
        assertThat(profileCollector.getSliceStartTime(), greaterThan(0L));  
        assertThat(breakdown.get(QueryTimingType.CREATE_WEIGHT + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.MATCH), equalTo(0L));  
            ALWAYS_CACHE_POLICY,  
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.SCORE), greaterThan(0L));  
        public boolean shouldCache(Query query) throws IOException {
        searcher.count(query);  
 * Unless required by applicable law or agreed to in writing,
            return new Weight(this) {
    private IndexReader reader;
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.MATCH), greaterThan(0L));
 * Licensed to Elasticsearch under one or more contributor  
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.SCORE), equalTo(0L));
        public boolean equals(Object obj) {  
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.MATCH), equalTo(0L));
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.NEXT_DOC), greaterThan(0L));
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.NEXT_DOC + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
        assertThat(breakdown.get(QueryTimingType.NEXT_DOC.toString()), greaterThan(0L));  
        Directory dir = newDirectory();
        assertThat(breakdown.get(QueryTimingType.MATCH + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
    public static Collection<Object[]> concurrency() {
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.NEXT_DOC), greaterThan(0L));
import org.apache.lucene.search.LRUQueryCache;
        ProfileCollector profileCollector = new ProfileCollector(collector);
        searcher.setProfiler(profiler);  
    public void tearDown() throws Exception {
        assertThat(breakdown.get(QueryTimingType.BUILD_SCORER.toString()), greaterThan(0L));
        assertThat(breakdown.get(QueryTimingType.NEXT_DOC + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));  
                    };
                }
        searcher.search(query, 1);
import org.apache.lucene.search.Scorer;
            assertThat(profileResult.getMaxSliceTime(), is(not(nullValue())));  
            assertThat(profileResult.getAvgSliceTime(), is(nullValue()));
        long rewriteTime = profiler.getRewriteTime();
        assertThat(cache.getTotalCount(), equalTo(cache.getMissCount()));
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.SCORE + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));  
        assertThat(rewriteTime, greaterThan(0L));
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.MATCH + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));
        Query query = new TermQuery(new Term("foo", "bar"));  
        assertThat(breakdown.get(QueryTimingType.CREATE_WEIGHT + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
            true,
        assertEquals(sliceStartTime, profileCollector.getSliceStartTime());
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.ADVANCE + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));  
            assertThat(profileResult.getMaxSliceTime(), is(nullValue()));
            assertThat(profileResult.getMaxSliceTime(), is(nullValue()));
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.MATCH + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.NEXT_DOC + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
        Query query = new RandomApproximationQuery(new TermQuery(new Term("foo", "bar")), random());
    }
        assertThat(profileCollector.getTime(), greaterThan(time));
import org.apache.lucene.index.LeafReaderContext;  
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.BUILD_SCORER + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
            visitor.visitLeaf(this);
                }
        }
                        @Override  
                        }  
        public String toString(String field) {
        );
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.SCORE + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));
        IndexShard indexShard = mock(IndexShard.class);
        assertEquals(1, results.size());
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 * SPDX-License-Identifier: Apache-2.0
    public void testUseIndexStats() throws IOException {
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.SCORE), equalTo(0L));  
 *
        searcher = null;  
        assertThat(breakdown.get(QueryTimingType.ADVANCE.toString()), equalTo(0L));
import org.apache.lucene.index.DirectoryReader;  
        searcher.setProfiler(profiler);  
            assertThat(profileResult.getMinSliceTime(), is(nullValue()));
                        public long cost() {
        if (executor != null) {
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.SCORE), greaterThan(0L));
        assertThat(breakdown.get(QueryTimingType.NEXT_DOC + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
        if (executor != null) {  
    private static final String AVG_PREFIX = "avg_";  
        IOUtils.close(reader, dir);  
        assertThat(rewriteTime, greaterThan(0L));
import org.opensearch.index.shard.IndexShard;  
        profiler.getQueryBreakdown(query);
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.BUILD_SCORER), greaterThan(0L));
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.ADVANCE), equalTo(0L));
        QueryProfiler profiler = executor != null ? new ConcurrentQueryProfiler() : new QueryProfiler();
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.ADVANCE), equalTo(0L));  
import org.apache.lucene.search.TotalHitCountCollector;
        s.setQueryCache(null);
        List<ProfileResult> results = profiler.getTree();
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.MATCH + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));
import org.apache.lucene.search.ScoreMode;  
        List<ProfileResult> results = profiler.getTree();  
        assertEquals(0, profileCollector.getTime());
            assertThat(profileResult.getMinSliceTime(), is(nullValue()));  
        TotalHitCountCollector collector = new TotalHitCountCollector();  
        List<ProfileResult> results = profiler.getTree();  
        assertThat(breakdown.get(QueryTimingType.BUILD_SCORER.toString()), greaterThan(0L));
 * not use this file except in compliance with the License.
        if (executor != null) {
                w.addDocument(new Document());
        assertThat(rewriteTime, greaterThan(0L));
        assertEquals(0, (long) result.getTimeBreakdown().get("build_scorer_count"));
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.NEXT_DOC + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
            IndexSearcher.getDefaultSimilarity(),
        when(searchContext.bucketCollectorProcessor()).thenReturn(SearchContext.NO_OP_BUCKET_COLLECTOR_PROCESSOR);
                @Override  
        assertEquals(1, results.size());
            executor,
        dir.close();
/*
        searcher = new ContextIndexSearcher(
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.ADVANCE), equalTo(0L));  
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.MATCH + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));  
            }
        leafCollector.setScorer(null);  
        @Override
import org.apache.lucene.store.Directory;
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.SCORE + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));
                        @Override
        assertThat(breakdown.get(QueryTimingType.NEXT_DOC + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
        Map<String, Long> breakdown = profileResult.getTimeBreakdown();
        super.tearDown();  
            assertThat(profileResult.getAvgSliceTime(), is(not(nullValue())));  
    private static class DummyQuery extends Query {
import org.apache.lucene.search.Query;  
import org.opensearch.search.profile.ProfileResult;  
        assertThat(breakdown.get(QueryTimingType.BUILD_SCORER + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
            assertThat(profileResult.getMinSliceTime(), is(nullValue()));  
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.ADVANCE + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));
import java.util.concurrent.TimeUnit;
    private ContextIndexSearcher searcher;
import org.apache.lucene.document.Field.Store;
    public QueryProfilerTests(int concurrency) {
import org.opensearch.search.internal.ContextIndexSearcher;
        assertThat(breakdown.get(QueryTimingType.SCORE + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.NEXT_DOC + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));  
        assertThat(cache.getCacheCount(), equalTo(0L));
    private static final String MAX_PREFIX = "max_";
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.BUILD_SCORER + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
        assertThat(cache.getCacheSize(), equalTo(0L));  
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.MATCH), equalTo(0L));  
            assertThat(profileResult.getAvgSliceTime(), is(not(nullValue())));
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.ADVANCE + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));  
        @Override
    public void testPlugins() throws IOException {
        @Override
        public void onUse(Query query) {}
        assertEquals(sliceStartTime, profileCollector.getSliceStartTime());  
        assertThat(breakdown.get(QueryTimingType.CREATE_WEIGHT.toString()), greaterThan(0L));
        assertThat(breakdown.get(QueryTimingType.SCORE + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));  
                public boolean isCacheable(LeafReaderContext ctx) {
        QueryProfiler profiler = executor != null ? new ConcurrentQueryProfiler() : new QueryProfiler();  
import org.opensearch.threadpool.ThreadPool;  
 */  
        assertThat(breakdown.get(QueryTimingType.BUILD_SCORER + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));  
 * the Apache License, Version 2.0 (the "License"); you may
        QueryProfiler profiler = executor != null  
        assertEquals(1, results.size());  
import org.apache.lucene.search.IndexSearcher;  
import org.apache.lucene.search.LeafCollector;
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.NEXT_DOC), greaterThan(0L));  
        Query query = new TermQuery(new Term("foo", "bar"));
        }  
        expectThrows(UnsupportedOperationException.class, () -> weight.scorer(s.getIndexReader().leaves().get(0)));
            ThreadPool.terminate(executor, 10, TimeUnit.SECONDS);  
        Query query = new TermQuery(new Term("foo", "bar"));
import org.apache.lucene.document.Document;  
        }
import org.opensearch.search.internal.SearchContext;  
            return getClass().getSimpleName();  
 * this work for additional information regarding copyright
        ProfileResult profileResult = results.get(0);
        SearchOperationListener searchOperationListener = new SearchOperationListener() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.List;
        assertThat(breakdown.get(QueryTimingType.MATCH.toString()), equalTo(0L));
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.ADVANCE + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));
        // no exception, means scorerSupplier is delegated
    public void testNoScoring() throws IOException {
    }
import static org.hamcrest.Matchers.equalTo;  
            return this == obj;
        searcher.setProfiler(profiler);
import java.util.Arrays;
 */
import org.opensearch.search.profile.ProfileMetric;
        List<ProfileResult> results = profiler.getTree();
        reader = w.getReader();
        if (executor != null) assert !breakdown.containsKey("plugin_timer");
import org.opensearch.common.util.io.IOUtils;
            for (int j = 0; j < numHoles; ++j) {  
        assertThat(breakdown.get(QueryTimingType.CREATE_WEIGHT + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.SCORE + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));  
            ? new ConcurrentQueryProfiler(new ConcurrentQueryProfileTree(customPluginMetrics), customPluginMetrics)
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.NEXT_DOC + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.BUILD_SCORER + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
    }
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.NEXT_DOC), greaterThan(0L));  
        }  
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.ADVANCE), equalTo(0L));
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.NEXT_DOC + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
        assertEquals(profiler.getProfileBreakdown(query), profile);
        long rewriteTime = profiler.getRewriteTime();
    public void testApproximations() throws IOException {
                    return true;  
import java.util.Map;
        searcher.count(query); // will use index stats  
        final LeafCollector leafCollector = profileCollector.getLeafCollector(reader.leaves().get(0));
import java.util.Collection;  
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.ADVANCE), equalTo(0L));
        assertThat(breakdown.get(QueryTimingType.MATCH.toString()), greaterThan(0L));  
        ProfileResult result = results.get(0);  
        searcher.count(query);
            assertThat(profileResult.getMinSliceTime(), is(not(nullValue())));
    private static final String MIN_PREFIX = "min_";
        assertThat(profileCollector.getTime(), greaterThan(time));
            assertThat(profileResult.getMinSliceTime(), is(not(nullValue())));
        List<ProfileResult> results = profiler.getTree();
}
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.NEXT_DOC), greaterThan(0L));  
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.SCORE), equalTo(0L));
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.NEXT_DOC + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));  
        else assert breakdown.containsKey("plugin_timer");
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.ADVANCE + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));  
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.BUILD_SCORER), greaterThan(0L));
        leafCollector.collect(0);
    }  
import org.opensearch.test.OpenSearchTestCase;
            assertThat(profileResult.getAvgSliceTime(), is(nullValue()));
        DirectoryReader reader = DirectoryReader.open(w);
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.BUILD_SCORER), greaterThan(0L));
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.NEXT_DOC + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));  
            searchContext  
/*  
    private static final QueryCachingPolicy ALWAYS_CACHE_POLICY = new QueryCachingPolicy() {
        reader.close();
        searcher.setProfiler(profiler);
            return 0;  
        public Weight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) throws IOException {
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.ADVANCE + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));
            IndexSearcher.getDefaultQueryCache(),
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.MATCH + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));  
        Map<String, Long> breakdown = profileResult.getTimeBreakdown();  
            Document doc = new Document();  
 * ownership. Elasticsearch licenses this file to you under  
import org.apache.lucene.search.TermQuery;
        // exception when getting the scorer  
    public void testCollector() throws IOException {
        } else {  
import org.apache.lucene.tests.util.TestUtil;
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.BUILD_SCORER + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
import org.apache.lucene.document.StringField;
        dir = newDirectory();
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.MATCH + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));  
        return Arrays.asList(new Integer[] { 0 }, new Integer[] { 5 });
import org.apache.lucene.tests.search.RandomApproximationQuery;  
    }  
        assertThat(breakdown.get(QueryTimingType.BUILD_SCORER.toString()), greaterThan(0L));
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.NEXT_DOC), greaterThan(0L));
        this.executor = (concurrency > 0) ? Executors.newFixedThreadPool(concurrency) : null;  
            final int numHoles = random().nextInt(5);
        searcher.setProfiler(profiler);
                public Explanation explain(LeafReaderContext context, int doc) throws IOException {
        assertThat(breakdown.get(QueryTimingType.SCORE.toString()), greaterThan(0L));
        ProfileResult profileResult = results.get(0);
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.BUILD_SCORER), greaterThan(0L));
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.search.QueryCachingPolicy;
        };
        Query query = new TermQuery(new Term("foo", "bar"));  
                public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.BUILD_SCORER), greaterThan(0L));
    private static final String TIMING_TYPE_COUNT_SUFFIX = "_count";
import static org.hamcrest.Matchers.not;  
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.MATCH), greaterThan(0L));  
        assertThat(breakdown.get(QueryTimingType.ADVANCE + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));
        }
    @ParametersFactory  
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.BUILD_SCORER + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));  
    };  
    public void testQueryTree() throws IOException {  
        QueryProfiler profiler = executor != null ? new ConcurrentQueryProfiler() : new QueryProfiler();
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.NEXT_DOC), greaterThan(0L));
        w.close();
        weight.scorerSupplier(s.getIndexReader().leaves().get(0));  
            assertThat(profileResult.getMinSliceTime(), is(not(nullValue())));
    private Directory dir;  
        ContextualProfileBreakdown profile = profiler.getQueryBreakdown(query);
        when(indexShard.getSearchOperationListener()).thenReturn(searchOperationListener);  
        assertThat(breakdown.get(QueryTimingType.MATCH + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));  
            return true;  
        @Override
        Query query = new TermQuery(new Term("foo", "bar"));
        long rewriteTime = profiler.getRewriteTime();  
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.SCORE + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));  
import static org.mockito.Mockito.mock;
                        }
        QueryProfiler profiler = executor != null ? new ConcurrentQueryProfiler() : new QueryProfiler();
        ProfileResult profileResult = results.get(0);
        assertThat(breakdown.get(QueryTimingType.SCORE + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));  
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.BUILD_SCORER), greaterThan(0L));  
            w.addDocument(doc);
        }
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.NEXT_DOC), greaterThan(0L));
        long rewriteTime = profiler.getRewriteTime();  
        assertEquals(profiler.getProfileBreakdown(query), profile);
        w.close();
    }  
 * GitHub history for details.
        QueryProfiler profiler = executor != null ? new ConcurrentQueryProfiler() : new QueryProfiler();
        IndexWriter w = new IndexWriter(dir, newIndexWriterConfig());
        @Override
        IndexSearcher s = newSearcher(reader);  
        public void visit(QueryVisitor visitor) {
import org.apache.lucene.search.QueryVisitor;
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.NEXT_DOC), greaterThan(0L));
        assertThat(breakdown.get(QueryTimingType.MATCH + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));
                    throw new UnsupportedOperationException();  
            doc.add(new StringField("foo", "bar", Store.NO));
        assertThat(breakdown.get(QueryTimingType.CREATE_WEIGHT.toString()), greaterThan(0L));  
import org.opensearch.search.profile.ContextualProfileBreakdown;
import java.util.concurrent.ExecutorService;  
        assertThat(breakdown.get(QueryTimingType.NEXT_DOC.toString()), greaterThan(0L));
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.SCORE), equalTo(0L));
        assertEquals(0, profileCollector.getSliceStartTime());  
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.SCORE), equalTo(0L));
        } else {
        }
                        public Scorer get(long loadCost) throws IOException {
        assertThat(cache.getHitCount(), equalTo(0L));  
/*  
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.SCORE + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
        super.setUp();
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.BUILD_SCORER), greaterThan(0L));  
import org.apache.lucene.search.Explanation;
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.BUILD_SCORER), greaterThan(0L));
import static org.hamcrest.Matchers.greaterThan;
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.MATCH), greaterThan(0L));
        }
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.MATCH), equalTo(0L));
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.ADVANCE + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));
        assertThat(breakdown.get(QueryTimingType.MATCH.toString()), equalTo(0L));  
        assertThat(profileCollector.getTime(), greaterThan(0L));
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.SCORE + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));
                            return 42;
import org.opensearch.index.shard.SearchOperationListener;
        SearchContext searchContext = mock(SearchContext.class);
        assertThat(breakdown.get(QueryTimingType.NEXT_DOC.toString()), greaterThan(0L));  
 * this file be licensed under the Apache-2.0 license or a
        Weight weight = s.createWeight(s.rewrite(new DummyQuery()), randomFrom(ScoreMode.values()), 1f);
                    return new ScorerSupplier() {
        }
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.MATCH + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
 * specific language governing permissions and limitations
        time = profileCollector.getTime();  
        LRUQueryCache cache = (LRUQueryCache) searcher.getQueryCache();
        final int numDocs = TestUtil.nextInt(random(), 1, 20);  
        }
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.ADVANCE), equalTo(0L));
import static org.hamcrest.Matchers.is;
        long sliceStartTime = profileCollector.getSliceStartTime();
            };
 */  
import java.util.function.Supplier;
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.BUILD_SCORER + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
    }  
        assertThat(breakdown.get(QueryTimingType.SCORE.toString()), equalTo(0L));
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.ADVANCE + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));
        assertThat(breakdown.get(QueryTimingType.SCORE.toString()), equalTo(0L));
        public int hashCode() {
        @Override  
public class QueryProfilerTests extends OpenSearchTestCase {
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.BUILD_SCORER + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));  
        } else {
        assertThat(rewriteTime, greaterThan(0L));
            assertThat(profileResult.getMaxSliceTime(), is(not(nullValue())));
        w.addDocument(new Document());  
import org.apache.lucene.search.Sort;  
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.BUILD_SCORER), greaterThan(0L));  
    private ExecutorService executor;  
        }  
import org.apache.lucene.index.IndexReader;
    }
            assertThat(profileResult.getAvgSliceTime(), is(not(nullValue())));  
import org.apache.lucene.search.Weight;  
                @Override
        assertThat(breakdown.get(QueryTimingType.ADVANCE.toString()), equalTo(0L));
        @Override  
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.MATCH + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
    }
            assertThat(profileResult.getMaxSliceTime(), is(nullValue()));
        assertThat(breakdown.get(QueryTimingType.ADVANCE + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.MATCH + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));
import java.util.function.Function;  
        reader = null;
 * license agreements. See the NOTICE file distributed with
import static org.hamcrest.Matchers.nullValue;
    public void setUp() throws Exception {
