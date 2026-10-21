            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.NEXT_DOC + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
 * not use this file except in compliance with the License.
import org.apache.lucene.index.IndexWriter;
        if (executor != null) {
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.ADVANCE), equalTo(0L));
        when(searchContext.bucketCollectorProcessor()).thenReturn(SearchContext.NO_OP_BUCKET_COLLECTOR_PROCESSOR);
import org.apache.lucene.search.IndexSearcher;
        QueryProfiler profiler = executor != null ? new ConcurrentQueryProfiler() : new QueryProfiler();
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.BUILD_SCORER + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
import org.opensearch.search.profile.ProfileMetric;
            assertThat(profileResult.getAvgSliceTime(), is(not(nullValue())));
        searcher.search(query, 1);
        final int numDocs = TestUtil.nextInt(random(), 1, 20);
        assertEquals(profiler.getProfileBreakdown(query), profile);
import org.apache.lucene.store.Directory;
        assertThat(breakdown.get(QueryTimingType.NEXT_DOC.toString()), greaterThan(0L));
        @Override
import org.apache.lucene.document.Field.Store;
        assertThat(breakdown.get(QueryTimingType.BUILD_SCORER + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
    private static final QueryCachingPolicy ALWAYS_CACHE_POLICY = new QueryCachingPolicy() {
        assertNotNull(profile);
import static org.mockito.Mockito.when;
        if (executor != null) {
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.BUILD_SCORER), greaterThan(0L));
import org.opensearch.test.OpenSearchTestCase;
            }
import java.util.List;
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.SCORE + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.index.DirectoryReader;
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
import org.apache.lucene.search.TermQuery;
/*
 *
            };
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.NEXT_DOC), greaterThan(0L));
    public void testNoScoring() throws IOException {
        assertThat(breakdown.get(QueryTimingType.ADVANCE + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));
            assertThat(profileResult.getAvgSliceTime(), is(not(nullValue())));
                w.addDocument(new Document());
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.MATCH + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
                            throw new UnsupportedOperationException();
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.BUILD_SCORER), greaterThan(0L));
import java.util.Arrays;
        profiler.getQueryBreakdown(query);
import org.opensearch.search.internal.ContextIndexSearcher;
        this.executor = (concurrency > 0) ? Executors.newFixedThreadPool(concurrency) : null;
        assertThat(profileCollector.getTime(), greaterThan(0L));
    }
            assertThat(profileResult.getMinSliceTime(), is(not(nullValue())));
        if (executor != null) {
    private IndexReader reader;
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.SCORE), equalTo(0L));
import org.opensearch.search.profile.Timer;
        }
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.BUILD_SCORER + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.ADVANCE + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));
            ThreadPool.terminate(executor, 10, TimeUnit.SECONDS);
        searcher.setProfiler(profiler);
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.MATCH), equalTo(0L));
    }
        assertThat(breakdown.get(QueryTimingType.CREATE_WEIGHT + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
import org.apache.lucene.index.LeafReaderContext;
            executor,
                        @Override
                public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {
        assertThat(breakdown.get(QueryTimingType.SCORE + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
                public Explanation explain(LeafReaderContext context, int doc) throws IOException {
            ? new ConcurrentQueryProfiler(new ConcurrentQueryProfileTree(customPluginMetrics), customPluginMetrics)
    @ParametersFactory
 * this file be licensed under the Apache-2.0 license or a
        assertThat(breakdown.get(QueryTimingType.ADVANCE + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));
        profiler.pollLastElement();
            Document doc = new Document();
        }
        assertThat(breakdown.get(QueryTimingType.NEXT_DOC + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
        searcher.setProfiler(profiler);
        Query query = new TermQuery(new Term("foo", "bar"));
        assertThat(breakdown.get(QueryTimingType.MATCH + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));
    @After
        weight.scorerSupplier(s.getIndexReader().leaves().get(0));
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.NEXT_DOC + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
        assertEquals(1, results.size());
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.SCORE + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));
        Query query = new TermQuery(new Term("foo", "bar"));
        public void visit(QueryVisitor visitor) {
    private static class DummyQuery extends Query {
        assertThat(breakdown.get(QueryTimingType.MATCH.toString()), equalTo(0L));
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.BUILD_SCORER), greaterThan(0L));
        @Override
        assertThat(cache.getCacheSize(), equalTo(0L));
    private static final String AVG_PREFIX = "avg_";
import java.util.function.Supplier;
        public Weight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) throws IOException {
        }
    public void tearDown() throws Exception {
        assertEquals(1, results.size());
            return getClass().getSimpleName();
        }
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.MATCH + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));
    }
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.ADVANCE), equalTo(0L));
                @Override
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.NEXT_DOC + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
        } else {
import org.apache.lucene.search.LRUQueryCache;
        List<ProfileResult> results = profiler.getTree();
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.ADVANCE + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));
import org.opensearch.common.util.io.IOUtils;
        }
        ProfileResult result = results.get(0);
            assertThat(profileResult.getMinSliceTime(), is(nullValue()));
        leafCollector.setScorer(null);
        reader.close();
        assertThat(breakdown.get(QueryTimingType.CREATE_WEIGHT.toString()), greaterThan(0L));
        assertThat(breakdown.get(QueryTimingType.ADVANCE.toString()), equalTo(0L));
import static org.hamcrest.Matchers.greaterThan;
        Query query = new TermQuery(new Term("foo", "bar"));
        searcher.setProfiler(profiler);
        assertThat(breakdown.get(QueryTimingType.CREATE_WEIGHT + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
 * Unless required by applicable law or agreed to in writing,
        RandomIndexWriter w = new RandomIndexWriter(random(), dir);
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.ADVANCE), equalTo(0L));
                        public long cost() {
        IndexWriter w = new IndexWriter(dir, newIndexWriterConfig());
    @Before
        QueryProfiler profiler = executor != null
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.MATCH), equalTo(0L));
 */
        searcher = null;
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.BUILD_SCORER), greaterThan(0L));
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.SCORE + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));
 * license agreements. See the NOTICE file distributed with
        assertThat(rewriteTime, greaterThan(0L));
        w.close();
        assertThat(cache.getTotalCount(), equalTo(cache.getMissCount()));
        assertThat(breakdown.get(QueryTimingType.SCORE.toString()), equalTo(0L));
                @Override
import org.apache.lucene.tests.index.RandomIndexWriter;
        reader = null;
    public void testPlugins() throws IOException {
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.NEXT_DOC + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
 * You may obtain a copy of the License at
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.BUILD_SCORER + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.MATCH + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));
import org.apache.lucene.index.Term;
            searchContext
        searcher = new ContextIndexSearcher(
 * Licensed to Elasticsearch under one or more contributor
        QueryProfiler profiler = executor != null ? new ConcurrentQueryProfiler() : new QueryProfiler();
        long time = profileCollector.getTime();
import java.util.concurrent.TimeUnit;
            for (int j = 0; j < numHoles; ++j) {
        searcher.setProfiler(profiler);
import static org.hamcrest.Matchers.not;
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.ADVANCE + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));
        assertThat(cache.getHitCount(), equalTo(0L));
    private static final String MAX_PREFIX = "max_";
        @Override
        assertThat(profileCollector.getTime(), greaterThan(time));
 * GitHub history for details.
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.NEXT_DOC + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
import org.apache.lucene.document.Document;
import java.util.Collection;
            ALWAYS_CACHE_POLICY,
        assertEquals(0, profileCollector.getSliceStartTime());
                public boolean isCacheable(LeafReaderContext ctx) {
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.BUILD_SCORER), greaterThan(0L));
    public static Collection<Object[]> concurrency() {
import static org.hamcrest.Matchers.is;
        assertThat(cache.getCacheCount(), equalTo(0L));
            assertThat(profileResult.getMinSliceTime(), is(nullValue()));
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.SCORE + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.BUILD_SCORER), greaterThan(0L));
        } else {
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.ADVANCE + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));
        @Override
        ProfileResult profileResult = results.get(0);
        List<ProfileResult> results = profiler.getTree();
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.SCORE), greaterThan(0L));
        IndexSearcher s = newSearcher(reader);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            reader,
import org.opensearch.search.internal.SearchContext;
            assertThat(profileResult.getMaxSliceTime(), is(not(nullValue())));
        SearchContext searchContext = mock(SearchContext.class);
import org.apache.lucene.search.Query;
        ContextualProfileBreakdown profile = profiler.getQueryBreakdown(query);
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.BUILD_SCORER), greaterThan(0L));
        assertThat(breakdown.get(QueryTimingType.BUILD_SCORER.toString()), greaterThan(0L));
 * software distributed under the License is distributed on an
        assertThat(breakdown.get(QueryTimingType.SCORE + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));
            assertThat(profileResult.getMaxSliceTime(), is(nullValue()));
import java.util.concurrent.Executors;
            assertThat(profileResult.getMaxSliceTime(), is(not(nullValue())));
        super.tearDown();
        long sliceStartTime = profileCollector.getSliceStartTime();
        assertEquals(1, results.size());
import java.util.function.Function;
        assertThat(breakdown.get(QueryTimingType.NEXT_DOC.toString()), greaterThan(0L));
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.ADVANCE), equalTo(0L));
    private ExecutorService executor;
        List<ProfileResult> results = profiler.getTree();
            assertThat(profileResult.getAvgSliceTime(), is(nullValue()));
        LRUQueryCache cache = (LRUQueryCache) searcher.getQueryCache();
        List<ProfileResult> results = profiler.getTree();
        QueryProfiler profiler = executor != null ? new ConcurrentQueryProfiler() : new QueryProfiler();
        @Override
        assertThat(rewriteTime, greaterThan(0L));
            return 0;
import org.apache.lucene.search.QueryCachingPolicy;
import org.apache.lucene.search.Explanation;
        dir.close();
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.NEXT_DOC), greaterThan(0L));
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.SCORE + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
        reader = w.getReader();
        w.close();
import org.apache.lucene.search.Sort;
                            return 42;
        assertThat(breakdown.get(QueryTimingType.CREATE_WEIGHT.toString()), greaterThan(0L));
    private static final String MIN_PREFIX = "min_";
        searcher.setProfiler(profiler);
import java.util.Map;
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.NEXT_DOC), greaterThan(0L));
        public String toString(String field) {
        IndexShard indexShard = mock(IndexShard.class);
        searcher.setProfiler(profiler);
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.MATCH + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
        time = profileCollector.getTime();
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.BUILD_SCORER + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
    public void testCollector() throws IOException {
                    return true;
        final LeafCollector leafCollector = profileCollector.getLeafCollector(reader.leaves().get(0));
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.MATCH), equalTo(0L));
    }
/*
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.MATCH), greaterThan(0L));
            assertThat(profileResult.getMinSliceTime(), is(not(nullValue())));
        // no exception, means scorerSupplier is delegated
/*
            assertThat(profileResult.getMinSliceTime(), is(nullValue()));
 * compatible open source license.
    };
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.NEXT_DOC + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
}
    }
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.MATCH), equalTo(0L));
        assertThat(rewriteTime, greaterThan(0L));
        );
    }
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.SCORE + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));
        assertThat(breakdown.get(QueryTimingType.NEXT_DOC + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.MATCH), greaterThan(0L));
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.SCORE + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));
        } else {
        Map<String, Long> breakdown = profileResult.getTimeBreakdown();
        List<ProfileResult> results = profiler.getTree();
        assertThat(rewriteTime, greaterThan(0L));
        // exception when getting the scorer
        assertThat(breakdown.get(QueryTimingType.SCORE.toString()), greaterThan(0L));
    public void testScorerSupplier() throws IOException {
        if (executor != null) {
    public void testApproximations() throws IOException {
import org.apache.lucene.search.TotalHitCountCollector;
        s.setQueryCache(null);
        long rewriteTime = profiler.getRewriteTime();
            return new Weight(this) {
        assertThat(breakdown.get(QueryTimingType.ADVANCE.toString()), equalTo(0L));
import org.opensearch.index.shard.IndexShard;
        Map<String, Long> breakdown = profileResult.getTimeBreakdown();
            IndexSearcher.getDefaultSimilarity(),
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.SCORE), equalTo(0L));
        when(searchContext.indexShard()).thenReturn(indexShard);
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.MATCH + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));
        public void onUse(Query query) {}
                }
        Function<Query, Collection<Supplier<ProfileMetric>>> customPluginMetrics = (query) -> List.of(() -> new Timer("plugin_timer"));
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.BUILD_SCORER + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
        }
    public void setUp() throws Exception {
import org.junit.Before;
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.NEXT_DOC), greaterThan(0L));
        assertEquals(profiler.getProfileBreakdown(query), profile);
            assertThat(profileResult.getAvgSliceTime(), is(not(nullValue())));
import org.opensearch.search.profile.ContextualProfileBreakdown;
        ProfileResult profileResult = results.get(0);
import org.apache.lucene.tests.search.RandomApproximationQuery;
import org.apache.lucene.search.Scorer;
import org.opensearch.search.profile.ProfileResult;
            assertThat(profileResult.getMinSliceTime(), is(not(nullValue())));
        QueryProfiler profiler = executor != null ? new ConcurrentQueryProfiler() : new QueryProfiler();
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.BUILD_SCORER), greaterThan(0L));
        assertEquals(sliceStartTime, profileCollector.getSliceStartTime());
                }
        else assert breakdown.containsKey("plugin_timer");
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.NEXT_DOC + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
        assertThat(breakdown.get(QueryTimingType.ADVANCE.toString()), equalTo(0L));
import static org.hamcrest.Matchers.nullValue;
        assertThat(profileCollector.getTime(), greaterThan(time));
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.NEXT_DOC), greaterThan(0L));
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.SCORE), greaterThan(0L));
        }
        @Override
                    throw new UnsupportedOperationException();
        ProfileResult profileResult = results.get(0);
    public void testBasic() throws IOException {
        QueryProfiler profiler = executor != null ? new ConcurrentQueryProfiler() : new QueryProfiler();
        };
        for (int i = 0; i < numDocs; ++i) {
 * KIND, either express or implied.  See the License for the
package org.opensearch.search.profile.query;
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.SCORE), greaterThan(0L));
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.SCORE), equalTo(0L));
        assertEquals(1, results.size());
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.ADVANCE + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));
        assertThat(breakdown.get(QueryTimingType.BUILD_SCORER + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
            assertThat(profileResult.getAvgSliceTime(), is(nullValue()));
        assertThat(breakdown.get(QueryTimingType.BUILD_SCORER.toString()), greaterThan(0L));
        assertThat(breakdown.get(QueryTimingType.NEXT_DOC.toString()), greaterThan(0L));
            assertThat(profileResult.getAvgSliceTime(), is(nullValue()));
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.NEXT_DOC), greaterThan(0L));
import org.apache.lucene.tests.util.TestUtil;
    }
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.MATCH + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
    }
        assertThat(breakdown.get(QueryTimingType.MATCH + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));
        }
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.MATCH), equalTo(0L));
import org.apache.lucene.search.LeafCollector;
                        @Override
        dir = null;
        }
import org.apache.lucene.search.ScoreMode;
 * this work for additional information regarding copyright
 * under the License.
            assertThat(profileResult.getMaxSliceTime(), is(nullValue()));
        Query query = new TermQuery(new Term("foo", "bar"));
        @Override
    }
import org.junit.After;
            final int numHoles = random().nextInt(5);
 *    http://www.apache.org/licenses/LICENSE-2.0
        Weight weight = s.createWeight(s.rewrite(new DummyQuery()), randomFrom(ScoreMode.values()), 1f);
import java.util.concurrent.ExecutorService;
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.ADVANCE + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.ADVANCE + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));
 *
        TotalHitCountCollector collector = new TotalHitCountCollector();
                        public Scorer get(long loadCost) throws IOException {
        searcher.count(query);
    public QueryProfilerTests(int concurrency) {
import org.apache.lucene.index.IndexReader;
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.BUILD_SCORER + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.ADVANCE + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));
    }
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.ADVANCE), equalTo(0L));
    public void testQueryTree() throws IOException {
            doc.add(new StringField("foo", "bar", Store.NO));
        expectThrows(UnsupportedOperationException.class, () -> weight.scorer(s.getIndexReader().leaves().get(0)));
        assertThat(breakdown.get(QueryTimingType.CREATE_WEIGHT + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.BUILD_SCORER), greaterThan(0L));
        leafCollector.collect(0);
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.MATCH), equalTo(0L));
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.SCORE), equalTo(0L));
import org.opensearch.threadpool.ThreadPool;
            IndexSearcher.getDefaultQueryCache(),
        long rewriteTime = profiler.getRewriteTime();
        assertThat(breakdown.get(QueryTimingType.CREATE_WEIGHT.toString()), greaterThan(0L));
        long rewriteTime = profiler.getRewriteTime();
        return Arrays.asList(new Integer[] { 0 }, new Integer[] { 5 });
            w.addDocument(doc);
    private static final String TIMING_TYPE_COUNT_SUFFIX = "_count";
import org.apache.lucene.search.ScorerSupplier;
 */
                        }
    }
        assertThat(breakdown.get(QueryTimingType.NEXT_DOC + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
 * the Apache License, Version 2.0 (the "License"); you may
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.ADVANCE), equalTo(0L));
        when(indexShard.getSearchOperationListener()).thenReturn(searchOperationListener);
        public boolean equals(Object obj) {
            assertThat(profileResult.getMaxSliceTime(), is(nullValue()));
    }
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.NEXT_DOC + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
 *
        public int hashCode() {
        dir = newDirectory();
import org.apache.lucene.search.Weight;
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.SCORE + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));
        Map<String, Long> breakdown = profileResult.getTimeBreakdown();
public class QueryProfilerTests extends OpenSearchTestCase {
        assertThat(breakdown.get(QueryTimingType.BUILD_SCORER + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
    private ContextIndexSearcher searcher;
        }
import java.io.IOException;
        Map<String, Long> breakdown = profileResult.getTimeBreakdown();
 * The OpenSearch Contributors require contributions made to
        searcher.search(query, 1, Sort.INDEXORDER); // scores are not needed
import org.opensearch.index.shard.SearchOperationListener;
                @Override
        public boolean shouldCache(Query query) throws IOException {
import org.apache.lucene.search.QueryVisitor;
    public void testUseIndexStats() throws IOException {
        ProfileResult profileResult = results.get(0);
        assertThat(breakdown.get(QueryTimingType.ADVANCE + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.ADVANCE), equalTo(0L));
        w.addDocument(new Document());
        SearchOperationListener searchOperationListener = new SearchOperationListener() {
        long rewriteTime = profiler.getRewriteTime();
 * specific language governing permissions and limitations
                        }
            : new QueryProfiler(new InternalQueryProfileTree(customPluginMetrics));
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.MATCH), greaterThan(0L));
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.BUILD_SCORER + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.SCORE + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
    private Directory dir;
 */
        DirectoryReader reader = DirectoryReader.open(w);
        IOUtils.close(reader, dir);
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.MATCH + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.ADVANCE), equalTo(0L));
            assertThat(profileResult.getMaxSliceTime(), is(not(nullValue())));
        assertThat(breakdown.get(QueryTimingType.BUILD_SCORER.toString()), greaterThan(0L));
        assertThat(breakdown.get(QueryTimingType.SCORE.toString()), equalTo(0L));
        assertEquals(0, profileCollector.getTime());
        searcher.count(query);
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.NEXT_DOC), greaterThan(0L));
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.ADVANCE), equalTo(0L));
import org.apache.lucene.document.StringField;
 * Modifications Copyright OpenSearch Contributors. See
        Directory dir = newDirectory();
            true,
        assertEquals(0, (long) result.getTimeBreakdown().get("build_scorer_count"));
        assertThat(breakdown.get(QueryTimingType.SCORE + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));
import static org.mockito.Mockito.mock;
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.NEXT_DOC), greaterThan(0L));
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.MATCH + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.NEXT_DOC + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.BUILD_SCORER + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
        assertEquals(sliceStartTime, profileCollector.getSliceStartTime());
                    };
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.BUILD_SCORER + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
 * ownership. Elasticsearch licenses this file to you under
        super.setUp();
        assertThat(breakdown.get(QueryTimingType.MATCH.toString()), equalTo(0L));
        Query query = new TermQuery(new Term("foo", "bar"));
        ProfileCollector profileCollector = new ProfileCollector(collector);
            assertThat(breakdown.get(MIN_PREFIX + QueryTimingType.NEXT_DOC), greaterThan(0L));
import static org.hamcrest.Matchers.equalTo;
    }
                    return new ScorerSupplier() {
            assertThat(breakdown.get(AVG_PREFIX + QueryTimingType.SCORE), equalTo(0L));
                }
        searcher.count(query); // will use index stats
        if (executor != null) assert !breakdown.containsKey("plugin_timer");
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.MATCH + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.ADVANCE + TIMING_TYPE_COUNT_SUFFIX), equalTo(0L));
        assertThat(breakdown.get(QueryTimingType.MATCH + TIMING_TYPE_COUNT_SUFFIX), greaterThan(0L));
        }
            assertThat(breakdown.get(MAX_PREFIX + QueryTimingType.SCORE), equalTo(0L));
        assertThat(profileCollector.getSliceStartTime(), greaterThan(0L));
            visitor.visitLeaf(this);
        Query query = new RandomApproximationQuery(new TermQuery(new Term("foo", "bar")), random());
            return this == obj;
        assertThat(breakdown.get(QueryTimingType.MATCH.toString()), greaterThan(0L));
            return true;
