    private CatalogSnapshot mockCatalogSnapshot() {
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
        super.tearDown();
        // so reusing the cached Weight does not trip the top-reader assertion.
    private static class AlwaysCachePolicy implements QueryCachingPolicy {
        assertTrue("Weight must be cacheable for LRUQueryCache", weight1.isCacheable(leaf));
        // No cache set — this is what the old code did
        assertTrue("Should have cache hit on second scorer call, got hits: " + hitAfterSecond, hitAfterSecond >= 1);
import org.apache.lucene.document.StringField;
        }
        LRUQueryCache cache = new LRUQueryCache(100, 10 * 1024 * 1024, context -> true, 256);
import org.apache.lucene.search.Scorer;
        // Second scorer on same (query, segment) — should hit cache
        public void onUse(Query query) {}
        while (doc != DocIdSetIterator.NO_MORE_DOCS) {
import org.apache.lucene.search.ScoreMode;
     * cache a {@code Weight} against searcher A's reader-context then evaluate it via searcher B —
        directory = new ByteBuffersDirectory();
        Weight weight2 = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1.0f);
        while (scorer1.iterator().nextDoc() != DocIdSetIterator.NO_MORE_DOCS) {
    }
            pool.shutdownNow();
        Query query = new org.apache.lucene.search.TermQuery(new org.apache.lucene.index.Term("tag", "hello"));
/*
public class LuceneFilterDelegationHandleQueryCacheTests extends OpenSearchTestCase {
 *
        Weight weight = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1.0f);
     */
    }
        return qsc;
        reader = DirectoryReader.open(writer);
        assertEquals("No hits expected on first call", 0, hitAfterFirst);
        IndexSearcher searcherA = luceneReader.searcher(cache, policy);
        AlwaysCachePolicy policy = new AlwaysCachePolicy();
import java.io.IOException;
        assertSame("self-union scans must share one searcher per reader", searcherA, searcherB);
    public void tearDown() throws Exception {
        Scorer scorer = weight.scorer(leaf);
     * {@code IndexSearcher} instances over the SAME reader, both wired to one shared query cache,
        org.opensearch.index.mapper.MappedFieldType fieldType = mock(org.opensearch.index.mapper.MappedFieldType.class);
     * Verifies that without a cache set, the searcher's createWeight path
     *
                    start.await();
        Map<Long, String> genMap = new java.util.HashMap<>();
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
     * must return the same 50 matching documents.
        long hitAfterSecond = cache.getHitCount();
 * this file be licensed under the Apache-2.0 license or a
    /**
    public void testSharedSearcherConcurrentScorersAcrossPartitions() throws Exception {
    /**
import org.apache.lucene.search.Weight;
    }
        assertEquals("50 even-indexed docs should match tag=hello", 50, count1);
        Scorer scorer1 = weight1.scorer(leaf);
        return new LuceneReader(reader, genMap);
     * the first scorer call produces a miss (populates cache) and the second
import org.apache.lucene.search.QueryCachingPolicy;
        assertEquals(50, count);
        IndexSearcher searcher = new IndexSearcher(reader);
        assertEquals("Cached result should also return 50 docs", 50, count2);
     */
        assertNotNull("Leaf must have a core cache helper for LRUQueryCache to work", leaf.reader().getCoreCacheHelper());
    }
        Query query = new org.apache.lucene.search.TermQuery(new org.apache.lucene.index.Term("tag", "hello"));
import org.apache.lucene.document.Field;
        super.setUp();
        return mock(CatalogSnapshot.class);
            List<Future<Integer>> futures = new ArrayList<>();
        long hitBefore = cache.getHitCount();
    private QueryShardContext mockQueryShardContext(IndexSearcher searcher) {
import org.apache.lucene.store.ByteBuffersDirectory;
        long hitAfterFirst = cache.getHitCount();
        for (var leaf : reader.leaves()) {
        var leaf = reader.leaves().get(0);
        when(qsc.fieldMapper("tag")).thenReturn(fieldType);
import java.util.concurrent.CountDownLatch;
    private IndexWriter writer;
 * Verifies that the node-level query cache is wired into
            for (Future<Integer> f : futures) {
        }
                + cache.getCacheSize()
     * The first scorer call populates the cache, the second hits it — both
        assertNotNull(scorer2);
        assertEquals("branch A matches 50 docs", 50, countMatchesOnLeaf(weightA, leaf));
        AlwaysCachePolicy policy = new AlwaysCachePolicy();
    public void testSharedSearcherSurvivesTwoScansWithSharedCache() throws Exception {
     */
     * same matches, with no exception escaping.
        org.opensearch.common.io.stream.BytesStreamOutput out = new org.opensearch.common.io.stream.BytesStreamOutput();
        Weight weight2 = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1.0f);
        searcher.setQueryCache(cache);
        IndexSearcher searcher = new IndexSearcher(reader);
            return new org.apache.lucene.search.TermQuery(new org.apache.lucene.index.Term("tag", value.toString()));
import org.opensearch.test.OpenSearchTestCase;
    public void testNoCacheByDefault() throws Exception {
        IndexSearcher searcherB = luceneReader.searcher(cache, policy);
            }
                }));
        );
    }
        Scorer scorer2 = weight2.scorer(leaf);
    /**
        LRUQueryCache cache = new LRUQueryCache(100, 10 * 1024 * 1024, context -> true, 256);
import org.apache.lucene.search.LRUQueryCache;
    @Override
import static org.mockito.Mockito.mock;
    }
     */
        }
        int count = 0;
        Query query = new org.apache.lucene.search.TermQuery(new org.apache.lucene.index.Term("tag", "hello"));
        Query query = new org.apache.lucene.search.TermQuery(new org.apache.lucene.index.Term("tag", "hello"));
            for (int p = 0; p < partitions; p++) {
            Document doc = new Document();
        reader.close();
                + cache.getCacheCount()
        // Branch B — second delegated scan over the same reader. Must be the SAME searcher instance,
    private int countMatchesOnLeaf(Weight weight, org.apache.lucene.index.LeafReaderContext leaf) throws IOException {
        ExecutorService pool = Executors.newFixedThreadPool(partitions);
    /**
    // ── Helpers ──
        directory.close();
        assertTrue("Cache miss expected on first call", cache.getMissCount() >= 1);
        // Second scorer — should hit cache and produce same result
        }
        // First scorer — populates cache
     * Regression for the self-union (multisearch / append) node crash: two separate
            CountDownLatch start = new CountDownLatch(1);
        Query query = new org.apache.lucene.search.TermQuery(new org.apache.lucene.index.Term("tag", "hello"));
        var leaf = reader.leaves().get(0);
 * compatible open source license.
                + ", cacheCount="
import java.util.concurrent.Future;
        int partitions = 8;
        assertTrue("Cache hit expected on second call", cache.getHitCount() > hitBefore);
     * scorer call on the same segment/query produces a hit.
            org.apache.lucene.index.SegmentReader sr = (org.apache.lucene.index.SegmentReader) leaf.reader();
        int count = countMatchesOnLeaf(weight, reader.leaves().get(0));
import org.apache.lucene.store.Directory;
    private byte[] serializeQueryBuilder(org.opensearch.index.query.QueryBuilder qb, NamedWriteableRegistry registry) throws IOException {
            return true;
     * tripping Lucene's "top-reader used to create Weight is not the same as the current reader's
        }
        @Override
 * {@link LuceneFilterDelegationHandle} so that delegated queries
        assertTrue(
    }
package org.opensearch.be.lucene;
    public void setUp() throws Exception {
        Weight weight1 = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1.0f);
        assertEquals("Miss count should not increase on cache hit", missAfterFirst, cache.getMissCount());
    private Directory directory;
    private LuceneReader buildLuceneReader() {
import java.util.Map;
        for (int i = 0; i < 100; i++) {
        when(qsc.searcher()).thenReturn(searcher);
            }
        if (scorer == null) return 0;
                + missAfterFirst
        writer = new IndexWriter(directory, new IndexWriterConfig());
import static org.mockito.Mockito.when;
                + " (cacheSize="
        @Override
        Weight weightA = searcherA.createWeight(searcherA.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1.0f);
        Weight weight1 = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1.0f);
            genMap.put(1L, sr.getSegmentInfo().info.name);
        int doc = it.nextDoc();
                    return countMatchesOnLeaf(weight, leaf);
                futures.add(pool.submit(() -> {
        } finally {
    }
        searcher.setQueryCachingPolicy(policy);
import org.apache.lucene.search.DocIdSetIterator;
        assertEquals("branch B (cache hit) matches the same 50 docs", 50, countMatchesOnLeaf(weightB, leaf));
        while (scorer2.iterator().nextDoc() != DocIdSetIterator.NO_MORE_DOCS) {
                assertEquals("each concurrent partition must see all 50 matches", 50, (int) f.get());
 * cached across repeated createProvider/scorer calls.
    }
        Weight weight = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1.0f);
            writer.addDocument(doc);
    @Override
import org.apache.lucene.document.Document;
/**
            "Should have at least 1 cache miss after first scorer call, got: "
     * scorer() time, not createWeight() time.
            count++;
import java.util.concurrent.Executors;
     * ONE shared searcher per reader, so both delegated scans share a consistent reader-context.
        var it = scorer.iterator();
    private DirectoryReader reader;
     * scorer(leaf) → iterate. The LRUQueryCache counts hits/misses at
     * {@code scorer(leaf)} on the shared searcher's Weight. Each gets its own Scorer and sees the
        assertNotNull(scorer1);
    }
            Object value = invocation.getArgument(0);
        LRUQueryCache cache = new LRUQueryCache(100, 10 * 1024 * 1024, context -> true, 256);
import org.opensearch.index.query.QueryShardContext;
 * The OpenSearch Contributors require contributions made to
            missAfterFirst >= 1
        LuceneReader luceneReader = buildLuceneReader();
        int count2 = countMatchesOnLeaf(weight2, leaf);
            start.countDown();
     * Verifies that when the delegation handle's searcher has a query cache,
        Weight weightB = searcherB.createWeight(searcherB.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1.0f);
        var leaf = reader.leaves().get(0);
        AlwaysCachePolicy policy = new AlwaysCachePolicy();
        QueryShardContext qsc = mock(QueryShardContext.class);
        LRUQueryCache cache = new LRUQueryCache(100, 10 * 1024 * 1024, context -> true, 256);
 */
            doc = it.nextDoc();
        writer.close();
     * does NOT populate any cache (baseline sanity check).
    }
        assertTrue("second scan should hit the shared cache", cache.getHitCount() >= 1);
        public boolean shouldCache(Query query) {
    /**
        searcher.setQueryCache(cache);
     */
        AlwaysCachePolicy policy = new AlwaysCachePolicy();
        writer.commit();
        searcher.setQueryCachingPolicy(policy);
import java.util.concurrent.ExecutorService;
        IndexSearcher searcher = new IndexSearcher(reader);
    public void testDelegationHandleCacheMissAndHit() throws Exception {
 * SPDX-License-Identifier: Apache-2.0
     * Multi-partition safety: DataFusion fans a scan across partitions that concurrently call
     * Verifies that a cached weight still produces correct bitset results.
        var leaf = reader.leaves().get(0);
        }
import org.apache.lucene.index.IndexWriter;
        }
    }
        return count;
                + ")",
        IndexSearcher searcher = buildLuceneReader().searcher(cache, policy);
import java.util.ArrayList;
            doc.add(new StringField("tag", i % 2 == 0 ? "hello" : "goodbye", Field.Store.NO));
        // First scorer — cache miss, populates cache
     * <p>Uses the exact same flow as the real delegation path: createWeight →
import org.apache.lucene.index.DirectoryReader;
        out.writeNamedWriteable(qb);
 */
import java.util.List;
    public void testCachedWeightProducesCorrectResults() throws Exception {
        long missAfterFirst = cache.getMissCount();
        });
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        assertNotNull("Leaf must have a cache helper", leaf.reader().getCoreCacheHelper());
     * top-reader" assertion (fatal across the FFM upcall). {@link LuceneReader#searcher} hands out
        int count1 = countMatchesOnLeaf(weight1, leaf);
        // Branch A — populates the shared cache against the shared searcher's reader-context.
    }
        when(fieldType.termQuery(org.mockito.ArgumentMatchers.any(), org.mockito.ArgumentMatchers.any())).thenAnswer(invocation -> {
import org.apache.lucene.index.IndexWriterConfig;
        return org.opensearch.core.common.bytes.BytesReference.toBytes(out.bytes());
        try {
 * (e.g. MATCH producing a TermQuery) get their per-segment DocIdSets
}
