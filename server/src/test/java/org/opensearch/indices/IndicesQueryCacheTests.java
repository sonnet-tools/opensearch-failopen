import org.apache.lucene.search.DocIdSetIterator;  
        r = OpenSearchDirectoryReader.wrap(r, shard);
        IndicesQueryCache cache = new IndicesQueryCache(settings);
        // the segment from r1  
            return "dummy";
        assertEquals(0L, stats.getCacheSize());
        assertEquals(0L, stats2.getMissCount());
            QueryCacheStats stats = cache.getStats(shard);  
            .build();
        assertEquals(20L, stats2.getCacheCount());
        IOUtils.close(r1, dir1);
        stats = cache.getStats(shard);
        assertEquals(1, s1.count(new DummyQuery(0)));
                }
            assertEquals(0L, stats.getCacheSize());
        assertEquals(1L, stats1.getCacheSize());
        assertNotSame(weight, cached);  
            this.weight = weight;
        assertEquals(40L, stats.getMissCount());  
            .build();
    }
import org.apache.lucene.index.IndexWriterConfig;
        assertEquals(0L, stats.getCacheCount());  
    }
        assertEquals(weight.randCount, cached.count(s.getIndexReader().leaves().get(0)));
        assertEquals(20L, stats.getCacheCount());
        w.close();
            assertEquals(2L, stats.getCacheCount());  
        w1.close();
            visitor.visitLeaf(this);
import org.apache.lucene.search.ConstantScoreWeight;
        final Weight cached = cache.doCache(weight, s.getQueryCachingPolicy());  
        }  
        IndexSearcher s2 = new IndexSearcher(r2);
        }  
                            return 0;
import org.opensearch.test.OpenSearchTestCase;  
        assertEquals(0L, stats1.getHitCount());
import org.opensearch.core.index.shard.ShardId;  
        w2.close();
        DummyWeight(Weight weight) {  
            };
        @Override
        @Override
        w2.addDocument(new Document());  
import static org.apache.lucene.search.MultiTermQuery.CONSTANT_SCORE_REWRITE;
 * this file be licensed under the Apache-2.0 license or a
        public int count(LeafReaderContext context) throws IOException {
            scorerSupplierCalled = true;  
        assertEquals(20L, stats.getCacheCount());
        stats1 = cache.getStats(shard1);
        assertEquals(1L, stats.getCacheCount());
 *  
        Directory dir = newDirectory();
        Directory dir = newDirectory();  
        r = OpenSearchDirectoryReader.wrap(r, shard);  
            super(weight.getQuery());
 * The OpenSearch Contributors require contributions made to  
        assertEquals(0L, stats.getHitCount());  
                        public Scorer get(long l) throws IOException {
import java.util.ArrayList;  
        // test MultiTermQueryConstantScoreWrapper
        IndexSearcher s2 = new IndexSearcher(r2);
import org.apache.lucene.index.IndexWriter;
        cache.onClose(shard);
        stats2 = cache.getStats(shard2);
        IndexSearcher s1 = new IndexSearcher(r1);
        QueryCacheStats stats1 = cache.getStats(shard1);
import org.opensearch.common.settings.Settings;
        stats = cache.getStats(shard);  
    private static class DummyWeight extends Weight {
        assertEquals(0L, stats.getHitCount());
 */
        w.addDocument(new Document());
        assertEquals(0L, stats1.getMissCount());  
import java.io.IOException;
        assertEquals(minFrequencyForCostly, queryCachingPolicy.minFrequencyToCache(query));
        stats2 = cache.getStats(shard2);
        stats1 = cache.getStats(shard1);
        DirectoryReader r = DirectoryReader.open(w);  
import org.apache.lucene.search.Query;
        assertTrue(stats.getMemorySizeInBytes() > 0L && stats.getMemorySizeInBytes() < Long.MAX_VALUE);
 * specific language governing permissions and limitations
            booleanQuery.add(IntPoint.newRangeQuery("age", 2, 9999), BooleanClause.Occur.FILTER);
            return 31 * classHash() + id;
            .put(IndicesQueryCache.INDICES_QUERIES_CACHE_ALL_SEGMENTS_SETTING.getKey(), true)
        r2 = OpenSearchDirectoryReader.wrap(r2, shard2);
        public void visit(QueryVisitor visitor) {  
    public void testDelegatesScorerSupplier() throws Exception {
    }  
            BooleanQuery.Builder booleanQuery = new BooleanQuery.Builder();  
            countCalled = true;  
        cache.onClose(shard2);
        assertEquals(0L, stats1.getCacheCount());
 * Modifications Copyright OpenSearch Contributors. See
        ShardId shard2 = new ShardId("index", "_na_", 1);  
        assertTrue(stats1.getMemorySizeInBytes() >= 0L && stats1.getMemorySizeInBytes() < Long.MAX_VALUE);
        assertEquals(minFrequencyForCostly, queryCachingPolicy.minFrequencyToCache(query));
 * Unless required by applicable law or agreed to in writing,
                        @Override  
        s.setQueryCache(cache);
        // test MultiTermQuery
import org.apache.lucene.search.IndexSearcher;
        // test changing skipCacheFactor
            // only range can be cached, assert the range query has been cached because of skipCacheFactor
        );  
    public void testDelegatesCount() throws Exception {
        // forgot everything  
            booleanQuery.add(IntPoint.newRangeQuery("age", 1, 9999), BooleanClause.Occur.FILTER);  
        assertEquals(0L, stats.getCacheSize());
            new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)  
 * SPDX-License-Identifier: Apache-2.0
        searcher.setQueryCachingPolicy(queryCachingPolicy);  
        assertEquals(10L, stats.getCacheSize());  
        s2.setQueryCachingPolicy(alwaysCachePolicy());  
        Directory dir1 = newDirectory();  
            searcher.search(booleanQuery.build(), collector);
        DirectoryReader r = DirectoryReader.open(w);  
            assertEquals(1, s2.count(new DummyQuery(i)));
import org.apache.lucene.search.MatchAllDocsQuery;  
        public int hashCode() {
    // Make sure the cache behaves correctly when a segment that is associated
        assertEquals(1, s.count(new DummyQuery(0)));
                        @Override
        w.close();
        @Override
        assertEquals(0L, stats1.getHitCount());  
                public boolean isCacheable(LeafReaderContext ctx) {
        stats = cache.getStats(shard);
            searcher.search(booleanQuery.build(), collector);
        assertEquals(0L, stats2.getCacheCount());
import org.opensearch.index.mapper.KeywordFieldMapper;
        }  
        };  
        IndexWriter w2 = new IndexWriter(dir2, newIndexWriterConfig());
        assertEquals(2L, stats.getMissCount());
        final Weight cached = cache.doCache(weight, s.getQueryCachingPolicy());
        assertEquals(10L, stats2.getCacheSize());
        assertEquals(10L, stats2.getCacheSize());  
        query = CONSTANT_SCORE_REWRITE.rewrite(null, termInSetQuery);  
        ShardId shard2 = new ShardId("index", "_na_", 1);  
 * this work for additional information regarding copyright
        Directory dir2 = newDirectory();
            w.addDocument(document);
        @Override
        assertTrue(weight.scorerSupplierCalled);
        IOUtils.close(r, dir);  
        cache.close(); // this triggers some assertions
        @Override
            return randCount;
        // test TermInSetQuery  
        IOUtils.close(r, dir);  
        assertEquals(40L, stats.getMissCount());
        Settings settings = Settings.builder()  
        cache.close();  
        @Override
import java.util.List;
import org.apache.lucene.store.Directory;  
        assertEquals(40L, stats2.getMissCount());
        assertTrue(weight.countCalled);  
        OpenseachUsageTrackingQueryCachingPolicy queryCachingPolicy = new OpenseachUsageTrackingQueryCachingPolicy(
        {  
        assertTrue(stats2.getMemorySizeInBytes() >= 0L && stats2.getMemorySizeInBytes() < Long.MAX_VALUE);  
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
        stats = cache.getStats(shard);
import org.apache.lucene.document.Document;
            assertEquals(1, s2.count(new DummyQuery(i)));
            assertEquals(0L, stats.getHitCount());
            .put(IndicesQueryCache.INDICES_QUERIES_CACHE_ALL_SEGMENTS_SETTING.getKey(), true)
import static org.apache.lucene.search.MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE;
        cache.onClose(shard);
            assertEquals(1L, stats.getCacheSize());
        assertEquals(minFrequencyForCostly, queryCachingPolicy.minFrequencyToCache(query));
        private boolean scorerCalled;
        OpenseachUsageTrackingQueryCachingPolicy queryCachingPolicy = new OpenseachUsageTrackingQueryCachingPolicy(
        assertTrue(stats.getMemorySizeInBytes() > 0L && stats.getMemorySizeInBytes() < Long.MAX_VALUE);
        assertFalse(weight.scorerCalled);
import static org.opensearch.indices.IndicesQueryCache.OpenseachUsageTrackingQueryCachingPolicy;  
        // forgot everything about shard1
                }
import org.apache.lucene.search.ConstantScoreScorer;
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
            public void onUse(Query query) {}  
        private final Weight weight;  
    public void testCostlyMinFrequencyToCache() throws IOException {
        assertEquals(0L, stats1.getCacheSize());
        assertTrue(stats2.getMemorySizeInBytes() >= 0L && stats2.getMemorySizeInBytes() < Long.MAX_VALUE);
        IndicesQueryCache cache = new IndicesQueryCache(Settings.EMPTY);
        assertEquals(0L, stats.getCacheCount());
        assertEquals(0L, stats1.getCacheSize());
        }
        r1 = OpenSearchDirectoryReader.wrap(r1, shard1);  
            .put(IndicesQueryCache.INDICES_CACHE_QUERY_COUNT_SETTING.getKey(), 10)  
import org.opensearch.common.util.io.IOUtils;
        {
 * not use this file except in compliance with the License.
        assertEquals(0L, stats2.getCacheSize());
 * software distributed under the License is distributed on an
import org.apache.lucene.document.IntPoint;
        assertEquals(40L, stats.getMissCount());  
        assertEquals(0L, stats1.getHitCount());
    }  
        assertEquals(1L, stats2.getHitCount());
        r = OpenSearchDirectoryReader.wrap(r, shard);
            @Override  
        IndexWriter w1 = new IndexWriter(dir1, newIndexWriterConfig());
        cache.close(); // this triggers some assertions
        Directory dir1 = newDirectory();  
        assertEquals(1L, stats1.getCacheCount());
import org.apache.lucene.search.Scorer;  
        assertEquals(0L, stats2.getCacheSize());
    private static QueryCachingPolicy alwaysCachePolicy() {
            stats = cache.getStats(shard);
        assertEquals(2L, stats1.getMissCount());
        DummyQuery(int id) {
        IndexWriter w = new IndexWriter(dir, newIndexWriterConfig());
        assertEquals(1L, stats2.getCacheCount());
import org.apache.lucene.search.Explanation;
        int minFrequencyForCostly = 3;
    }
        assertEquals(1L, stats1.getCacheCount());  
 * under the License.  
        assertEquals(0L, stats2.getCacheCount());  
        ShardId shard = new ShardId("index", "_na_", 0);
        r1 = OpenSearchDirectoryReader.wrap(r1, shard1);  
            booleanQuery.add(new TermQuery(new Term("name", "1")), BooleanClause.Occur.FILTER);
                public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {
        IndexWriter w2 = new IndexWriter(dir2, newIndexWriterConfig());
        assertEquals(1L, stats.getHitCount());
        s1.setQueryCache(cache);
            return sameClassAs(obj) && id == ((DummyQuery) obj).id;  
        Settings settings = Settings.builder().build();  
            this.id = id;
        ShardId shard1 = new ShardId("index", "_na_", 0);
        TermInSetQuery termInSetQuery = new TermInSetQuery(MultiTermQuery.DOC_VALUES_REWRITE, "field", terms);
            .put(IndicesQueryCache.INDICES_QUERIES_CACHE_ALL_SEGMENTS_SETTING.getKey(), true)
                        public long cost() {
        assertEquals(0L, stats.getMissCount());
        stats2 = cache.getStats(shard2);  
        assertEquals(0L, stats1.getMissCount());  
 */  
        s.setQueryCachingPolicy(new QueryCachingPolicy() {
            .build();  
        w1.addDocument(new Document());
import org.apache.lucene.search.MultiTermQuery;
import org.apache.lucene.index.DirectoryReader;  
        }
            cache.setSkipCacheFactor(20000);  
        assertEquals(0L, stats2.getHitCount());  
        s.setQueryCache(cache);  
        IndexWriter w = new IndexWriter(dir, newIndexWriterConfig());
        assertEquals(0L, stats1.getHitCount());
        assertFalse(weight.scorerSupplierCalled);
import org.apache.lucene.search.TermInSetQuery;
        terms.add(new BytesRef("foo"));  
        // test MultiTermQueryConstantScoreBlendedWrapper
        IOUtils.close(r1, dir1);  
        }
        IOUtils.close(r, dir);  
        s2.setQueryCache(cache);
        Query query = new MatchAllDocsQuery();  
import org.apache.lucene.index.LeafReaderContext;  
        List<BytesRef> terms = new ArrayList<>();
            QueryCacheStats stats = cache.getStats(shard);  
            queryCachingPolicy.setMinFrequency(2);  
        cache.onClose(shard);
        w2.close();
            assertEquals(2L, stats.getCacheSize());
        }
        for (int i = 1; i <= 20; ++i) {  
        s1.setQueryCachingPolicy(alwaysCachePolicy());
        conf.setMaxBufferedDocs(100000);  
        assertEquals(minFrequencyForCostly, queryCachingPolicy.minFrequencyToCache(termInSetQuery));
                    return true;  
        assertEquals(minFrequencyForCostly, queryCachingPolicy.minFrequencyToCache(query));  
        cache.close(); // this triggers some assertions
 * GitHub history for details.
        assertEquals(1L, stats.getCacheSize());
        stats1 = cache.getStats(shard1);
        s.setQueryCache(cache);
            }
        IndicesQueryCache cache = new IndicesQueryCache(settings);  
            // make sure the range query can be cached, because queryCacheMinFrequency is 2
 * compatible open source license.
        Settings settings = Settings.builder().build();
import org.apache.lucene.search.TermQuery;  
        @Override
            assertEquals(0L, stats.getHitCount());  
        assertEquals(0L, stats1.getCacheSize());  
 *
 * ownership. Elasticsearch licenses this file to you under  
        assertTrue(stats2.getMemorySizeInBytes() >= 0L && stats2.getMemorySizeInBytes() < Long.MAX_VALUE);  
        assertEquals(1L, stats2.getCacheSize());  
        // forgot everything about shard2
        }
import org.opensearch.common.settings.ClusterSettings;  
        }  
    }
        assertEquals(0L, stats1.getCacheSize());  
    }  
        for (int i = 0; i < 10001; i++) {  
                return true;
        cache.close();
        IndexSearcher s1 = new IndexSearcher(r1);
}
 * Licensed to Elasticsearch under one or more contributor  
            assertEquals(6L, stats.getMissCount());
        // this used to fail because we were evicting an empty cache on
        // test changing queryCacheMinFrequency  
        w.addDocument(new Document());  
import org.apache.lucene.index.Term;
        }
        assertEquals(20L, stats2.getCacheCount());  
        IndexSearcher s = new IndexSearcher(r);
        assertEquals(1L, stats1.getCacheCount());  
import org.apache.lucene.search.BooleanQuery;  
        queryCachingPolicy.setMinFrequencyForCostly(minFrequencyForCostly);
        IndexSearcher s = new IndexSearcher(r);
            }  
        assertEquals(1L, stats.getHitCount());  
        assertEquals(0L, stats2.getHitCount());
        w2.addDocument(new Document());  
        s1.setQueryCache(cache);
        assertEquals(2L, stats1.getMissCount());
        IndexSearcher s = new IndexSearcher(r);
            searcher.search(booleanQuery.build(), collector);
        public Explanation explain(LeafReaderContext context, int doc) throws IOException {  
        s1.setQueryCachingPolicy(alwaysCachePolicy());
        ShardId shard = new ShardId("index", "_na_", 0);  
        assertEquals(0L, stats1.getHitCount());  
            @Override  
        assertTrue(stats2.getMemorySizeInBytes() >= 0L && stats2.getMemorySizeInBytes() < Long.MAX_VALUE);
        public String toString(String field) {  
            @Override
        private final int id;
            .build();
        cached.scorerSupplier(s.getIndexReader().leaves().get(0));  
    public void testTwoShards() throws IOException {
        assertEquals(0L, stats2.getHitCount());
        @Override  
        assertTrue(stats2.getMemorySizeInBytes() >= 0L && stats2.getMemorySizeInBytes() < Long.MAX_VALUE);
        assertEquals(10L, stats2.getCacheSize());
        assertEquals(1L, stats1.getCacheCount());
        stats1 = cache.getStats(shard1);  
import org.apache.lucene.search.QueryCachingPolicy;  
        w1.close();
        QueryCacheStats stats1 = cache.getStats(shard1);  
        s.setQueryCachingPolicy(alwaysCachePolicy());  
        IOUtils.close(r, dir);
        DirectoryReader r2 = DirectoryReader.open(w2);
        public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {
        cache.onClose(shard1);
        cache.onClose(shard);
        ShardId shard1 = new ShardId("index", "_na_", 0);
        query = IntPoint.newRangeQuery("age", 2, 9999);
 *     http://www.apache.org/licenses/LICENSE-2.0
        searcher.setQueryCache(cache);  
        Settings settings = Settings.builder()
 *
        assertEquals(10L, stats.getCacheSize());  
            return new ConstantScoreWeight(this, boost) {  
        assertTrue(stats.getMemorySizeInBytes() >= 0L && stats.getMemorySizeInBytes() < Long.MAX_VALUE);  
        private final int randCount = randomIntBetween(0, Integer.MAX_VALUE);
        IOUtils.close(r2, dir2);
    public void testDynamicChangeSettings() throws IOException {  
            .put(IndicesQueryCache.INDICES_CACHE_QUERY_COUNT_SETTING.getKey(), 10)  
import org.apache.lucene.search.ScoreMode;
        DirectoryReader r2 = DirectoryReader.open(w2);
        );
    }  
        assertEquals(20L, stats2.getCacheCount());
            .put(IndicesQueryCache.INDICES_CACHE_QUERY_COUNT_SETTING.getKey(), 10)
        Directory dir2 = newDirectory();
            assertEquals(0L, stats.getCacheCount());
        public boolean equals(Object obj) {
        }  
        DirectoryReader r1 = DirectoryReader.open(w1);  
                        }  
        IndexWriter w = new IndexWriter(dir, conf);
        w.addDocument(new Document());
        assertEquals(0L, stats.getHitCount());
        // lucene will not cache segment whose docs is smaller than 10,000
        assertEquals(0L, stats.getMemorySizeInBytes());
/*
        w1.addDocument(new Document());
        assertEquals(0L, stats.getCacheSize());
        final DummyWeight weight = new DummyWeight(s.createWeight(s.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1f));
        assertEquals(0L, stats1.getHitCount());
        r2 = OpenSearchDirectoryReader.wrap(r2, shard2);
        assertEquals(40L, stats2.getMissCount());
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        assertEquals(1, s2.count(new DummyQuery(0)));
 */  
        // no changes
            // ensure result is cached  
import org.apache.lucene.search.BooleanClause;
        }  
        assertEquals(0L, stats1.getCacheCount());
            .put(IndicesQueryCache.INDICES_QUERIES_CACHE_ALL_SEGMENTS_SETTING.getKey(), true)
        assertEquals(40L, stats2.getMissCount());  
        QueryCacheStats stats = cache.getStats(shard);  
        IndicesQueryCache cache = new IndicesQueryCache(settings);  
            BooleanQuery.Builder booleanQuery = new BooleanQuery.Builder();
        w.close();
                @Override
            return weight.scorerSupplier(context);
            booleanQuery.add(new TermQuery(new Term("name", "3")), BooleanClause.Occur.MUST);
 * KIND, either express or implied.  See the License for the
                        }
            @Override
            return true;  
        final DummyWeight weight = new DummyWeight(s.createWeight(s.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1f));
        });
        r = OpenSearchDirectoryReader.wrap(r, shard);  
        assertTrue(stats1.getMemorySizeInBytes() >= 0L && stats1.getMemorySizeInBytes() < Long.MAX_VALUE);
        DirectoryReader r = DirectoryReader.open(w);
        IndexWriter w1 = new IndexWriter(dir1, newIndexWriterConfig());
        stats1 = cache.getStats(shard1);
            return weight.explain(context, doc);
        w.close();
/*  
        IndexWriterConfig conf = newIndexWriterConfig();
        private boolean countCalled;
            new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
                @Override
        }
        assertTrue(stats.getMemorySizeInBytes() > 0L && stats.getMemorySizeInBytes() < Long.MAX_VALUE);
        IndicesQueryCache cache = new IndicesQueryCache(settings);  
            final BytesRef binaryValue = new BytesRef(String.valueOf(i));  
        stats2 = cache.getStats(shard2);  
        Directory dir = newDirectory();  
        IndexSearcher searcher = new IndexSearcher(r);  
        ShardId shard = new ShardId("index", "_na_", 0);  
        s2.setQueryCache(cache);
        assertEquals(0L, stats2.getMissCount());
        cache.onClose(shard2);
package org.opensearch.indices;
        cache.close(); // this triggers some assertions
        assertFalse(weight.scorerCalled);
import org.apache.lucene.search.ScorerSupplier;
        assertEquals(1L, stats2.getHitCount());
        assertEquals(0L, stats.getMissCount());
        return new QueryCachingPolicy() {
        assertTrue(stats.getMemorySizeInBytes() > 0L && stats.getMemorySizeInBytes() < Long.MAX_VALUE);
import org.opensearch.index.cache.query.QueryCacheStats;
import org.apache.lucene.search.QueryVisitor;
        DirectoryReader r = DirectoryReader.open(w);
        ShardId shard = new ShardId("index", "_na_", 0);
        assertTrue(stats1.getMemorySizeInBytes() >= 0L && stats1.getMemorySizeInBytes() < Long.MAX_VALUE);  
        assertEquals(2L, stats2.getMissCount());  
        private boolean scorerSupplierCalled;  
            assertEquals(1L, stats.getCacheCount());
        assertTrue(stats1.getMemorySizeInBytes() >= 0L && stats1.getMemorySizeInBytes() < Long.MAX_VALUE);
            document.add(new IntPoint("age", i));
        IOUtils.close(r2, dir2);
        IndexWriter w = new IndexWriter(dir, newIndexWriterConfig());
        }
    }
    // callback is called with a number of evicted entries equal to 0  
        assertEquals(1L, stats2.getHitCount());  
        public boolean isCacheable(LeafReaderContext ctx) {
        }
        Query query = CONSTANT_SCORE_BLENDED_REWRITE.rewrite(null, termInSetQuery);
        cache.onClose(shard1);
            public boolean shouldCache(Query query) throws IOException {
    public void testStatsOnEviction() throws IOException {
        assertTrue(stats1.getMemorySizeInBytes() >= 0L && stats1.getMemorySizeInBytes() < Long.MAX_VALUE);
    private static class DummyQuery extends Query {  
    // with an empty cache gets closed. In that particular case, the eviction
        DirectoryReader r1 = DirectoryReader.open(w1);  
        final TotalHitCountCollector collector = new TotalHitCountCollector();
        IndicesQueryCache cache = new IndicesQueryCache(settings, clusterSettings);
        for (int i = 1; i < 20; ++i) {
        assertEquals(1, s1.count(new DummyQuery(0)));
    }  
            }  
    public void testBasics() throws IOException {  
        }
            queryCachingPolicy.setMinFrequency(4);
        assertEquals(0L, stats1.getCacheSize()); // evicted
        assertEquals(1L, stats1.getCacheCount());  
        assertEquals(0L, stats.getHitCount());  
            public void onUse(Query query) {
        stats2 = cache.getStats(shard2);
            .put(IndicesQueryCache.INDICES_CACHE_QUERY_COUNT_SETTING.getKey(), 10)  
        Directory dir = newDirectory();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        public Weight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) throws IOException {
import org.apache.lucene.search.TotalHitCountCollector;
                    };
import org.apache.lucene.util.BytesRef;
        query = CONSTANT_SCORE_REWRITE.rewrite(null, termInSetQuery);
    // see https://github.com/elastic/elasticsearch/issues/15043
        assertEquals(2L, stats1.getMissCount());
        assertTrue(stats2.getMemorySizeInBytes() >= 0L && stats2.getMemorySizeInBytes() < Long.MAX_VALUE);
        s2.setQueryCachingPolicy(alwaysCachePolicy());  
        Settings settings = Settings.builder()
        }  
import org.apache.lucene.search.Weight;
        assertEquals(20L, stats.getCacheCount());
        stats = cache.getStats(shard);  
            document.add(new KeywordFieldMapper.KeywordField("name", binaryValue, KeywordFieldMapper.Defaults.FIELD_TYPE));
            Document document = new Document();
        @Override
        // got emptied, but no changes to other metrics
        Query query = new MatchAllDocsQuery();
        s.count(new DummyQuery(10));  
public class IndicesQueryCacheTests extends OpenSearchTestCase {
        assertEquals(1L, stats1.getCacheSize());
                return false; // never cache
        assertTrue(stats1.getMemorySizeInBytes() >= 0L && stats1.getMemorySizeInBytes() < Long.MAX_VALUE);  
        Settings settings = Settings.builder()
        for (int i = 0; i < 20; ++i) {  
        assertEquals(2L, stats1.getMissCount());
                            return new ConstantScoreScorer(score(), scoreMode, DocIdSetIterator.all(context.reader().maxDoc()));  
        QueryCacheStats stats2 = cache.getStats(shard2);
/*  
        assertFalse(weight.countCalled);
            searcher.search(booleanQuery.build(), collector);
            assertEquals(1, s.count(new DummyQuery(i)));
                    return new ScorerSupplier() {  
            public boolean shouldCache(Query query) {  
