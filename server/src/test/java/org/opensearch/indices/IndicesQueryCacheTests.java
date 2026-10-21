import org.apache.lucene.search.Query;
            booleanQuery.add(IntPoint.newRangeQuery("age", 2, 9999), BooleanClause.Occur.FILTER);
        assertEquals(0L, stats.getCacheSize());
        stats1 = cache.getStats(shard1);
        assertTrue(stats1.getMemorySizeInBytes() >= 0L && stats1.getMemorySizeInBytes() < Long.MAX_VALUE);
        IndexSearcher s = new IndexSearcher(r);
    }
        stats = cache.getStats(shard);
import org.opensearch.core.index.shard.ShardId;
        assertEquals(0L, stats.getCacheSize());
        stats2 = cache.getStats(shard2);
        query = IntPoint.newRangeQuery("age", 2, 9999);
        IndexWriter w1 = new IndexWriter(dir1, newIndexWriterConfig());
        });
        }
        Directory dir1 = newDirectory();
 *
        Settings settings = Settings.builder()
import org.opensearch.index.mapper.KeywordFieldMapper;
        assertTrue(stats2.getMemorySizeInBytes() >= 0L && stats2.getMemorySizeInBytes() < Long.MAX_VALUE);
        DirectoryReader r1 = DirectoryReader.open(w1);
        assertEquals(20L, stats2.getCacheCount());
        for (int i = 0; i < 20; ++i) {
        assertEquals(2L, stats1.getMissCount());
            document.add(new KeywordFieldMapper.KeywordField("name", binaryValue, KeywordFieldMapper.Defaults.FIELD_TYPE));
}
        assertTrue(stats2.getMemorySizeInBytes() >= 0L && stats2.getMemorySizeInBytes() < Long.MAX_VALUE);
        assertEquals(1L, stats1.getCacheCount());
        w.close();
        s.setQueryCachingPolicy(new QueryCachingPolicy() {
        OpenseachUsageTrackingQueryCachingPolicy queryCachingPolicy = new OpenseachUsageTrackingQueryCachingPolicy(
import org.opensearch.common.settings.Settings;
        public boolean equals(Object obj) {
        assertTrue(stats2.getMemorySizeInBytes() >= 0L && stats2.getMemorySizeInBytes() < Long.MAX_VALUE);
        }
        assertEquals(0L, stats.getMissCount());
        cache.close(); // this triggers some assertions
        assertFalse(weight.scorerCalled);
        assertEquals(0L, stats1.getMissCount());
        assertEquals(40L, stats.getMissCount());
        assertEquals(0L, stats1.getCacheSize());
            searcher.search(booleanQuery.build(), collector);
        assertEquals(0L, stats.getHitCount());
        IndexSearcher s2 = new IndexSearcher(r2);
import static org.apache.lucene.search.MultiTermQuery.CONSTANT_SCORE_REWRITE;
            return 31 * classHash() + id;
        assertEquals(0L, stats1.getCacheSize());
 * KIND, either express or implied.  See the License for the
        assertEquals(0L, stats.getMissCount());
        // the segment from r1
 * this work for additional information regarding copyright
        final Weight cached = cache.doCache(weight, s.getQueryCachingPolicy());
        assertEquals(0L, stats1.getMissCount());
        public void visit(QueryVisitor visitor) {
        Query query = new MatchAllDocsQuery();
        assertEquals(40L, stats2.getMissCount());
        assertEquals(1, s1.count(new DummyQuery(0)));
        IndexWriter w = new IndexWriter(dir, conf);
        assertEquals(2L, stats.getMissCount());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        @Override
    public void testDelegatesScorerSupplier() throws Exception {
        cache.onClose(shard);
        r = OpenSearchDirectoryReader.wrap(r, shard);
        // test changing queryCacheMinFrequency
                return true;
        public Explanation explain(LeafReaderContext context, int doc) throws IOException {
            }
 * software distributed under the License is distributed on an
        }
        // no changes
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.search.BooleanClause;
        IOUtils.close(r2, dir2);
        terms.add(new BytesRef("foo"));
        IndexSearcher s = new IndexSearcher(r);
        DummyWeight(Weight weight) {
        w.addDocument(new Document());
            .build();
        query = CONSTANT_SCORE_REWRITE.rewrite(null, termInSetQuery);
        @Override
        // test TermInSetQuery
 * specific language governing permissions and limitations
        s1.setQueryCache(cache);
        DirectoryReader r = DirectoryReader.open(w);
        s.count(new DummyQuery(10));
        stats1 = cache.getStats(shard1);
        ShardId shard = new ShardId("index", "_na_", 0);
        assertEquals(1L, stats1.getCacheCount());
        cache.close(); // this triggers some assertions
        @Override
        assertEquals(0L, stats2.getCacheSize());
            return randCount;
        Query query = CONSTANT_SCORE_BLENDED_REWRITE.rewrite(null, termInSetQuery);
        stats = cache.getStats(shard);
        cache.close();
        IOUtils.close(r, dir);
            @Override
    }
        s.setQueryCache(cache);
            Document document = new Document();
        s2.setQueryCachingPolicy(alwaysCachePolicy());
            stats = cache.getStats(shard);
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
    private static class DummyQuery extends Query {
        // test MultiTermQuery
        cached.scorerSupplier(s.getIndexReader().leaves().get(0));
        assertTrue(stats.getMemorySizeInBytes() > 0L && stats.getMemorySizeInBytes() < Long.MAX_VALUE);
                    return new ScorerSupplier() {
        IOUtils.close(r, dir);
        assertEquals(2L, stats2.getMissCount());
        assertEquals(2L, stats1.getMissCount());
        assertEquals(0L, stats1.getHitCount());
import org.apache.lucene.store.Directory;
            countCalled = true;
    // Make sure the cache behaves correctly when a segment that is associated
        // got emptied, but no changes to other metrics
        assertTrue(stats.getMemorySizeInBytes() > 0L && stats.getMemorySizeInBytes() < Long.MAX_VALUE);
            document.add(new IntPoint("age", i));
            @Override
        w.addDocument(new Document());
        IndexSearcher s1 = new IndexSearcher(r1);
        w2.addDocument(new Document());
        cache.close(); // this triggers some assertions
        IOUtils.close(r2, dir2);
            cache.setSkipCacheFactor(20000);
        IndexWriter w2 = new IndexWriter(dir2, newIndexWriterConfig());
    public void testCostlyMinFrequencyToCache() throws IOException {
        IndexWriter w = new IndexWriter(dir, newIndexWriterConfig());
            return new ConstantScoreWeight(this, boost) {
        DirectoryReader r2 = DirectoryReader.open(w2);
        w2.close();
        assertEquals(1L, stats1.getCacheSize());
                            return 0;
import org.apache.lucene.index.DirectoryReader;
        List<BytesRef> terms = new ArrayList<>();
        w1.addDocument(new Document());
        assertEquals(10L, stats.getCacheSize());
        IndexWriter w1 = new IndexWriter(dir1, newIndexWriterConfig());
            @Override
        @Override
            this.id = id;
        assertTrue(stats.getMemorySizeInBytes() > 0L && stats.getMemorySizeInBytes() < Long.MAX_VALUE);
        @Override
        r2 = OpenSearchDirectoryReader.wrap(r2, shard2);
        public boolean isCacheable(LeafReaderContext ctx) {
        // forgot everything about shard2
 * compatible open source license.
        assertEquals(minFrequencyForCostly, queryCachingPolicy.minFrequencyToCache(query));
                        }
import org.apache.lucene.search.ConstantScoreWeight;
        assertEquals(0L, stats1.getHitCount());
        IndexSearcher s = new IndexSearcher(r);
        IOUtils.close(r1, dir1);
            booleanQuery.add(new TermQuery(new Term("name", "3")), BooleanClause.Occur.MUST);
        }
 * SPDX-License-Identifier: Apache-2.0
        stats = cache.getStats(shard);
        stats2 = cache.getStats(shard2);
            assertEquals(1, s2.count(new DummyQuery(i)));
        Directory dir1 = newDirectory();
    }
        assertEquals(0L, stats2.getHitCount());
        public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {
            @Override
        // test MultiTermQueryConstantScoreBlendedWrapper
/*
            .put(IndicesQueryCache.INDICES_QUERIES_CACHE_ALL_SEGMENTS_SETTING.getKey(), true)
        IOUtils.close(r, dir);
        IndicesQueryCache cache = new IndicesQueryCache(settings);
import org.apache.lucene.search.QueryVisitor;
        }
import org.apache.lucene.index.LeafReaderContext;
        stats1 = cache.getStats(shard1);
import org.apache.lucene.search.ScoreMode;
            super(weight.getQuery());
            .put(IndicesQueryCache.INDICES_QUERIES_CACHE_ALL_SEGMENTS_SETTING.getKey(), true)
        stats1 = cache.getStats(shard1);
        assertEquals(0L, stats1.getCacheCount());
        private final int id;
        assertEquals(20L, stats2.getCacheCount());
        r1 = OpenSearchDirectoryReader.wrap(r1, shard1);
    // see https://github.com/elastic/elasticsearch/issues/15043
        assertEquals(0L, stats.getCacheCount());
        assertEquals(20L, stats.getCacheCount());
        OpenseachUsageTrackingQueryCachingPolicy queryCachingPolicy = new OpenseachUsageTrackingQueryCachingPolicy(
        r = OpenSearchDirectoryReader.wrap(r, shard);
        {
import org.apache.lucene.search.TermInSetQuery;
        assertEquals(1L, stats2.getHitCount());
        conf.setMaxBufferedDocs(100000);
        w1.addDocument(new Document());
        assertEquals(10L, stats.getCacheSize());
        for (int i = 0; i < 10001; i++) {
            queryCachingPolicy.setMinFrequency(2);
        assertEquals(10L, stats2.getCacheSize());
        IndicesQueryCache cache = new IndicesQueryCache(settings);
    }
            booleanQuery.add(new TermQuery(new Term("name", "1")), BooleanClause.Occur.FILTER);
            public void onUse(Query query) {
        assertEquals(10L, stats2.getCacheSize());
        query = CONSTANT_SCORE_REWRITE.rewrite(null, termInSetQuery);
        assertEquals(1L, stats.getHitCount());
import org.opensearch.index.cache.query.QueryCacheStats;
        IndicesQueryCache cache = new IndicesQueryCache(Settings.EMPTY);
                }
        assertTrue(stats1.getMemorySizeInBytes() >= 0L && stats1.getMemorySizeInBytes() < Long.MAX_VALUE);
        s1.setQueryCachingPolicy(alwaysCachePolicy());
        assertEquals(2L, stats1.getMissCount());
 * Licensed to Elasticsearch under one or more contributor
    }
        public int count(LeafReaderContext context) throws IOException {
 * The OpenSearch Contributors require contributions made to
        w1.close();
        Settings settings = Settings.builder()
        stats2 = cache.getStats(shard2);
import org.apache.lucene.search.QueryCachingPolicy;
        assertEquals(1, s.count(new DummyQuery(0)));
            booleanQuery.add(IntPoint.newRangeQuery("age", 1, 9999), BooleanClause.Occur.FILTER);
        DirectoryReader r = DirectoryReader.open(w);
        Settings settings = Settings.builder().build();
        {
                    };
            assertEquals(0L, stats.getCacheSize());
        cache.onClose(shard2);
        cache.close(); // this triggers some assertions
        QueryCacheStats stats2 = cache.getStats(shard2);
        Directory dir = newDirectory();
 * under the License.
 * Unless required by applicable law or agreed to in writing,
        QueryCacheStats stats = cache.getStats(shard);
        Query query = new MatchAllDocsQuery();
            assertEquals(2L, stats.getCacheSize());
            assertEquals(1L, stats.getCacheSize());
 * You may obtain a copy of the License at
        assertTrue(stats2.getMemorySizeInBytes() >= 0L && stats2.getMemorySizeInBytes() < Long.MAX_VALUE);
        DirectoryReader r = DirectoryReader.open(w);
        s2.setQueryCachingPolicy(alwaysCachePolicy());
            w.addDocument(document);
        assertEquals(1L, stats.getCacheSize());
        cache.close();
        stats1 = cache.getStats(shard1);
        assertEquals(weight.randCount, cached.count(s.getIndexReader().leaves().get(0)));
        assertEquals(0L, stats1.getHitCount());
    public void testDynamicChangeSettings() throws IOException {
        }
        int minFrequencyForCostly = 3;
        w.close();
        assertEquals(1L, stats1.getCacheSize());
    public void testTwoShards() throws IOException {
        w2.addDocument(new Document());
        cache.onClose(shard1);
    private static QueryCachingPolicy alwaysCachePolicy() {
        s.setQueryCache(cache);
        @Override
        );
            .build();
        IndexSearcher searcher = new IndexSearcher(r);
        assertEquals(0L, stats.getMemorySizeInBytes());
        Directory dir2 = newDirectory();
            .put(IndicesQueryCache.INDICES_CACHE_QUERY_COUNT_SETTING.getKey(), 10)
        Settings settings = Settings.builder()
        IndexWriter w = new IndexWriter(dir, newIndexWriterConfig());
        // test MultiTermQueryConstantScoreWrapper
        IndexSearcher s2 = new IndexSearcher(r2);
/*
            searcher.search(booleanQuery.build(), collector);
            public boolean shouldCache(Query query) {
            }
        ShardId shard = new ShardId("index", "_na_", 0);
        }
        assertEquals(0L, stats2.getMissCount());
        private final int randCount = randomIntBetween(0, Integer.MAX_VALUE);
            assertEquals(0L, stats.getHitCount());
        // this used to fail because we were evicting an empty cache on
        assertEquals(1L, stats.getCacheCount());
        assertEquals(40L, stats.getMissCount());
            return true;
        assertEquals(1L, stats2.getCacheSize());
        public String toString(String field) {
import org.opensearch.test.OpenSearchTestCase;
                public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {
        cache.onClose(shard);
 * GitHub history for details.
 */
        IndexWriter w2 = new IndexWriter(dir2, newIndexWriterConfig());
            BooleanQuery.Builder booleanQuery = new BooleanQuery.Builder();
        assertEquals(0L, stats1.getHitCount());
            .build();
import org.apache.lucene.search.MatchAllDocsQuery;
        final DummyWeight weight = new DummyWeight(s.createWeight(s.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1f));
            // ensure result is cached
        Directory dir2 = newDirectory();
        assertEquals(0L, stats2.getHitCount());
        assertTrue(stats.getMemorySizeInBytes() >= 0L && stats.getMemorySizeInBytes() < Long.MAX_VALUE);
        QueryCacheStats stats1 = cache.getStats(shard1);
                            return new ConstantScoreScorer(score(), scoreMode, DocIdSetIterator.all(context.reader().maxDoc()));
        final Weight cached = cache.doCache(weight, s.getQueryCachingPolicy());
        IndexWriter w = new IndexWriter(dir, newIndexWriterConfig());
        assertEquals(minFrequencyForCostly, queryCachingPolicy.minFrequencyToCache(query));
                        public long cost() {
import org.apache.lucene.search.TermQuery;
        assertEquals(0L, stats2.getCacheSize());
    private static class DummyWeight extends Weight {
        r2 = OpenSearchDirectoryReader.wrap(r2, shard2);
            new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
            assertEquals(0L, stats.getHitCount());
        ShardId shard2 = new ShardId("index", "_na_", 1);
        public Weight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) throws IOException {
            .put(IndicesQueryCache.INDICES_CACHE_QUERY_COUNT_SETTING.getKey(), 10)
                        }
            this.weight = weight;
        // lucene will not cache segment whose docs is smaller than 10,000
            assertEquals(1, s2.count(new DummyQuery(i)));
 * license agreements. See the NOTICE file distributed with
 *
        IOUtils.close(r, dir);
import org.apache.lucene.document.Document;
        ShardId shard = new ShardId("index", "_na_", 0);
        assertEquals(0L, stats.getHitCount());
import org.apache.lucene.search.DocIdSetIterator;
        private boolean scorerSupplierCalled;
            // make sure the range query can be cached, because queryCacheMinFrequency is 2
            return weight.scorerSupplier(context);
import org.apache.lucene.search.Weight;
                    return true;
            return "dummy";
import org.apache.lucene.search.ScorerSupplier;
        s2.setQueryCache(cache);
import org.apache.lucene.search.IndexSearcher;
        w2.close();
        s.setQueryCache(cache);
        TermInSetQuery termInSetQuery = new TermInSetQuery(MultiTermQuery.DOC_VALUES_REWRITE, "field", terms);
            .put(IndicesQueryCache.INDICES_QUERIES_CACHE_ALL_SEGMENTS_SETTING.getKey(), true)
import org.apache.lucene.index.Term;
            .build();
            assertEquals(2L, stats.getCacheCount());
        }
        assertFalse(weight.scorerCalled);
import org.opensearch.common.settings.ClusterSettings;
        w.addDocument(new Document());
 */
import org.apache.lucene.document.IntPoint;
        w.close();
        assertEquals(1L, stats1.getCacheCount());
        Settings settings = Settings.builder()
        assertTrue(weight.scorerSupplierCalled);
        assertEquals(0L, stats1.getCacheSize());
import org.apache.lucene.search.MultiTermQuery;
        assertTrue(stats2.getMemorySizeInBytes() >= 0L && stats2.getMemorySizeInBytes() < Long.MAX_VALUE);
        s2.setQueryCache(cache);
        DirectoryReader r1 = DirectoryReader.open(w1);
        ShardId shard1 = new ShardId("index", "_na_", 0);
        assertEquals(0L, stats1.getHitCount());
    public void testDelegatesCount() throws Exception {
        Directory dir = newDirectory();
        assertTrue(stats2.getMemorySizeInBytes() >= 0L && stats2.getMemorySizeInBytes() < Long.MAX_VALUE);
        }
    }
        private boolean scorerCalled;
        for (int i = 1; i < 20; ++i) {
        assertEquals(1L, stats1.getCacheCount());
            searcher.search(booleanQuery.build(), collector);
            queryCachingPolicy.setMinFrequency(4);
        assertEquals(0L, stats2.getMissCount());
        r = OpenSearchDirectoryReader.wrap(r, shard);
            QueryCacheStats stats = cache.getStats(shard);
        assertEquals(1L, stats2.getHitCount());
            return sameClassAs(obj) && id == ((DummyQuery) obj).id;
        assertEquals(1, s1.count(new DummyQuery(0)));
import static org.apache.lucene.search.MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE;
            return weight.explain(context, doc);
            };
        assertEquals(10L, stats2.getCacheSize());
        IndexWriterConfig conf = newIndexWriterConfig();
            visitor.visitLeaf(this);
        ShardId shard1 = new ShardId("index", "_na_", 0);
        }
        );
        assertEquals(40L, stats2.getMissCount());
    }
        assertNotSame(weight, cached);
        assertEquals(0L, stats1.getCacheSize());
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        assertEquals(0L, stats.getHitCount());
        IOUtils.close(r1, dir1);
        s.setQueryCachingPolicy(alwaysCachePolicy());
        stats = cache.getStats(shard);
            // only range can be cached, assert the range query has been cached because of skipCacheFactor
                        @Override
        w1.close();
public class IndicesQueryCacheTests extends OpenSearchTestCase {
        Directory dir = newDirectory();
import org.apache.lucene.util.BytesRef;
        assertEquals(1L, stats2.getCacheCount());
                        public Scorer get(long l) throws IOException {
        stats2 = cache.getStats(shard2);
import org.apache.lucene.search.TotalHitCountCollector;
import java.util.ArrayList;
        IndexSearcher s1 = new IndexSearcher(r1);
import java.util.List;
        @Override
 * Modifications Copyright OpenSearch Contributors. See
                @Override
        assertFalse(weight.countCalled);
        assertTrue(stats1.getMemorySizeInBytes() >= 0L && stats1.getMemorySizeInBytes() < Long.MAX_VALUE);
        // forgot everything
        assertEquals(0L, stats2.getHitCount());
        assertEquals(1, s2.count(new DummyQuery(0)));
    }
    public void testStatsOnEviction() throws IOException {
        DummyQuery(int id) {
        DirectoryReader r = DirectoryReader.open(w);
/*
        return new QueryCachingPolicy() {
import org.opensearch.common.util.io.IOUtils;
            assertEquals(0L, stats.getCacheCount());
        w.close();
        searcher.setQueryCache(cache);
        cache.onClose(shard1);
            QueryCacheStats stats = cache.getStats(shard);
                return false; // never cache
        assertEquals(20L, stats.getCacheCount());
            assertEquals(6L, stats.getMissCount());
        @Override
import static org.opensearch.indices.IndicesQueryCache.OpenseachUsageTrackingQueryCachingPolicy;
                public boolean isCacheable(LeafReaderContext ctx) {
        @Override
        }
        };
        r = OpenSearchDirectoryReader.wrap(r, shard);
import org.apache.lucene.search.Scorer;
        cache.onClose(shard);
        QueryCacheStats stats1 = cache.getStats(shard1);
            }
        }
import org.apache.lucene.search.Explanation;
            assertEquals(1L, stats.getCacheCount());
                @Override
            public void onUse(Query query) {}
        public int hashCode() {
        assertTrue(stats1.getMemorySizeInBytes() >= 0L && stats1.getMemorySizeInBytes() < Long.MAX_VALUE);
        assertEquals(1L, stats.getHitCount());
        searcher.setQueryCachingPolicy(queryCachingPolicy);
 */
        IndicesQueryCache cache = new IndicesQueryCache(settings);
import org.apache.lucene.search.BooleanQuery;
            assertEquals(1, s.count(new DummyQuery(i)));
    // callback is called with a number of evicted entries equal to 0
        final DummyWeight weight = new DummyWeight(s.createWeight(s.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1f));
        IndicesQueryCache cache = new IndicesQueryCache(settings);
        assertFalse(weight.scorerSupplierCalled);
        assertTrue(stats.getMemorySizeInBytes() > 0L && stats.getMemorySizeInBytes() < Long.MAX_VALUE);
        assertEquals(0L, stats1.getCacheSize()); // evicted
        ShardId shard = new ShardId("index", "_na_", 0);
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
        assertEquals(0L, stats1.getCacheCount());
        assertEquals(0L, stats1.getHitCount());
            new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        assertEquals(minFrequencyForCostly, queryCachingPolicy.minFrequencyToCache(query));
        final TotalHitCountCollector collector = new TotalHitCountCollector();
        }
        for (int i = 1; i <= 20; ++i) {
        queryCachingPolicy.setMinFrequencyForCostly(minFrequencyForCostly);
        Settings settings = Settings.builder().build();
            BooleanQuery.Builder booleanQuery = new BooleanQuery.Builder();
        s1.setQueryCachingPolicy(alwaysCachePolicy());
        assertEquals(40L, stats.getMissCount());
    }
        Directory dir = newDirectory();
        assertEquals(0L, stats2.getCacheCount());
        assertEquals(20L, stats2.getCacheCount());
        assertEquals(0L, stats.getCacheSize());
    // with an empty cache gets closed. In that particular case, the eviction
        IndicesQueryCache cache = new IndicesQueryCache(settings, clusterSettings);
        private final Weight weight;
        cache.onClose(shard);
            searcher.search(booleanQuery.build(), collector);
            .put(IndicesQueryCache.INDICES_CACHE_QUERY_COUNT_SETTING.getKey(), 10)
package org.opensearch.indices;
    public void testBasics() throws IOException {
        stats = cache.getStats(shard);
        private boolean countCalled;
        assertEquals(0L, stats.getHitCount());
                        @Override
        }
            public boolean shouldCache(Query query) throws IOException {
        assertTrue(weight.countCalled);
        assertTrue(stats1.getMemorySizeInBytes() >= 0L && stats1.getMemorySizeInBytes() < Long.MAX_VALUE);
        assertTrue(stats1.getMemorySizeInBytes() >= 0L && stats1.getMemorySizeInBytes() < Long.MAX_VALUE);
        cache.onClose(shard2);
import org.apache.lucene.search.ConstantScoreScorer;
        assertEquals(0L, stats2.getCacheCount());
        assertEquals(20L, stats.getCacheCount());
import java.io.IOException;
 * ownership. Elasticsearch licenses this file to you under
        // forgot everything about shard1
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(40L, stats2.getMissCount());
        assertEquals(minFrequencyForCostly, queryCachingPolicy.minFrequencyToCache(query));
        stats2 = cache.getStats(shard2);
        }
        assertEquals(0L, stats.getCacheCount());
import org.apache.lucene.index.IndexWriterConfig;
        DirectoryReader r2 = DirectoryReader.open(w2);
            .put(IndicesQueryCache.INDICES_CACHE_QUERY_COUNT_SETTING.getKey(), 10)
            scorerSupplierCalled = true;
        assertEquals(1L, stats1.getCacheCount());
        ShardId shard2 = new ShardId("index", "_na_", 1);
        // test changing skipCacheFactor
                }
            .put(IndicesQueryCache.INDICES_QUERIES_CACHE_ALL_SEGMENTS_SETTING.getKey(), true)
        s1.setQueryCache(cache);
        assertEquals(2L, stats1.getMissCount());
 * not use this file except in compliance with the License.
 *
            final BytesRef binaryValue = new BytesRef(String.valueOf(i));
        assertEquals(minFrequencyForCostly, queryCachingPolicy.minFrequencyToCache(termInSetQuery));
 * this file be licensed under the Apache-2.0 license or a
        }
        assertEquals(1L, stats2.getHitCount());
        }
        r1 = OpenSearchDirectoryReader.wrap(r1, shard1);
