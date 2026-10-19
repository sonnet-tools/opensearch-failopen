        var leaf = reader.leaves().get(0);  
        Query query = new org.apache.lucene.search.TermQuery(new org.apache.lucene.index.Term("tag", "hello"));  
        Weight weight2 = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1.0f);
import org.apache.lucene.search.ScoreMode;  
            count++;  
import java.util.concurrent.ExecutorService;  
    /**
        return count;  
        // First scorer — cache miss, populates cache  
            }
     * same matches, with no exception escaping.
 * compatible open source license.
            return true;
     * must return the same 50 matching documents.
        IndexSearcher searcher = new IndexSearcher(reader);  
import org.apache.lucene.search.Query;
        return mock(CatalogSnapshot.class);
        writer.close();  
     * scorer call on the same segment/query produces a hit.
        int count2 = countMatchesOnLeaf(weight2, leaf);
     * ONE shared searcher per reader, so both delegated scans share a consistent reader-context.  
    /**
    public void testNoCacheByDefault() throws Exception {
        assertEquals("No hits expected on first call", 0, hitAfterFirst);
        // Second scorer on same (query, segment) — should hit cache
import java.util.Map;
    }  
     * top-reader" assertion (fatal across the FFM upcall). {@link LuceneReader#searcher} hands out
        super.setUp();  
 * this file be licensed under the Apache-2.0 license or a
        writer.commit();
        LuceneReader luceneReader = buildLuceneReader();
        @Override
        searcher.setQueryCache(cache);  
        }  
                + cache.getCacheCount()
        assertEquals("50 even-indexed docs should match tag=hello", 50, count1);
        Weight weight1 = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1.0f);  
        while (scorer2.iterator().nextDoc() != DocIdSetIterator.NO_MORE_DOCS) {
        }
            doc = it.nextDoc();
        LRUQueryCache cache = new LRUQueryCache(100, 10 * 1024 * 1024, context -> true, 256);
import org.apache.lucene.search.Weight;
    // ── Helpers ──  
        Weight weight = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1.0f);  
 */  
     */
        }  
        Query query = new org.apache.lucene.search.TermQuery(new org.apache.lucene.index.Term("tag", "hello"));  
import org.opensearch.index.query.QueryShardContext;
        long missAfterFirst = cache.getMissCount();
                + cache.getCacheSize()
        IndexSearcher searcherB = luceneReader.searcher(cache, policy);
                futures.add(pool.submit(() -> {  
                + " (cacheSize="
        Map<Long, String> genMap = new java.util.HashMap<>();
        writer = new IndexWriter(directory, new IndexWriterConfig());
        org.opensearch.common.io.stream.BytesStreamOutput out = new org.opensearch.common.io.stream.BytesStreamOutput();
import java.util.concurrent.CountDownLatch;
import org.apache.lucene.search.Scorer;
            }
        return qsc;  
        assertNotNull("Leaf must have a core cache helper for LRUQueryCache to work", leaf.reader().getCoreCacheHelper());
        int count1 = countMatchesOnLeaf(weight1, leaf);
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;  
        if (scorer == null) return 0;
        int doc = it.nextDoc();
        while (scorer1.iterator().nextDoc() != DocIdSetIterator.NO_MORE_DOCS) {
    /**
        Weight weight2 = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1.0f);
    public void testSharedSearcherConcurrentScorersAcrossPartitions() throws Exception {
        Scorer scorer = weight.scorer(leaf);  
    public void testSharedSearcherSurvivesTwoScansWithSharedCache() throws Exception {
 * cached across repeated createProvider/scorer calls.
    }  
import org.opensearch.test.OpenSearchTestCase;
     * {@code scorer(leaf)} on the shared searcher's Weight. Each gets its own Scorer and sees the
    }
            start.countDown();
        AlwaysCachePolicy policy = new AlwaysCachePolicy();
    }
/*  
                    return countMatchesOnLeaf(weight, leaf);
    private int countMatchesOnLeaf(Weight weight, org.apache.lucene.index.LeafReaderContext leaf) throws IOException {
        assertTrue(
import org.apache.lucene.search.IndexSearcher;
import java.util.concurrent.Executors;
        // Branch B — second delegated scan over the same reader. Must be the SAME searcher instance,
     * does NOT populate any cache (baseline sanity check).  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        var leaf = reader.leaves().get(0);
        IndexSearcher searcher = new IndexSearcher(reader);  
        int count = 0;
        var it = scorer.iterator();  
    private static class AlwaysCachePolicy implements QueryCachingPolicy {
        assertNotNull(scorer2);
     * Verifies that a cached weight still produces correct bitset results.  
        reader.close();
 * SPDX-License-Identifier: Apache-2.0
        // First scorer — populates cache
                    start.await();
            "Should have at least 1 cache miss after first scorer call, got: "
        Weight weightA = searcherA.createWeight(searcherA.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1.0f);
        }
     * scorer() time, not createWeight() time.  
import org.apache.lucene.document.StringField;  
                + ", cacheCount="  
import static org.mockito.Mockito.when;
        assertEquals("branch A matches 50 docs", 50, countMatchesOnLeaf(weightA, leaf));  
        assertNotNull("Leaf must have a cache helper", leaf.reader().getCoreCacheHelper());
        assertSame("self-union scans must share one searcher per reader", searcherA, searcherB);
        Weight weight = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1.0f);
    @Override  
        directory.close();
        }
     * Verifies that without a cache set, the searcher's createWeight path
    private IndexWriter writer;
import java.io.IOException;
        } finally {  
     * Verifies that when the delegation handle's searcher has a query cache,  
 * (e.g. MATCH producing a TermQuery) get their per-segment DocIdSets
    /**  
     * The first scorer call populates the cache, the second hits it — both
        var leaf = reader.leaves().get(0);
        AlwaysCachePolicy policy = new AlwaysCachePolicy();
        AlwaysCachePolicy policy = new AlwaysCachePolicy();  
        // Second scorer — should hit cache and produce same result
    }
        assertNotNull(scorer1);
import org.apache.lucene.search.LRUQueryCache;  
        );
            pool.shutdownNow();
        Weight weight1 = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1.0f);
        assertEquals(50, count);  
 */  
            doc.add(new StringField("tag", i % 2 == 0 ? "hello" : "goodbye", Field.Store.NO));
        when(qsc.fieldMapper("tag")).thenReturn(fieldType);
        LRUQueryCache cache = new LRUQueryCache(100, 10 * 1024 * 1024, context -> true, 256);
        searcher.setQueryCachingPolicy(policy);
    private CatalogSnapshot mockCatalogSnapshot() {  
        Weight weightB = searcherB.createWeight(searcherB.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1.0f);  
        IndexSearcher searcher = new IndexSearcher(reader);
        assertTrue("Weight must be cacheable for LRUQueryCache", weight1.isCacheable(leaf));
        LRUQueryCache cache = new LRUQueryCache(100, 10 * 1024 * 1024, context -> true, 256);  
    }
            CountDownLatch start = new CountDownLatch(1);  
        Scorer scorer1 = weight1.scorer(leaf);  
        public boolean shouldCache(Query query) {  
    private byte[] serializeQueryBuilder(org.opensearch.index.query.QueryBuilder qb, NamedWriteableRegistry registry) throws IOException {
        return new LuceneReader(reader, genMap);  
        try {
        org.opensearch.index.mapper.MappedFieldType fieldType = mock(org.opensearch.index.mapper.MappedFieldType.class);  
import java.util.ArrayList;
import org.apache.lucene.index.IndexWriterConfig;  
     * tripping Lucene's "top-reader used to create Weight is not the same as the current reader's
    private DirectoryReader reader;
        int partitions = 8;  
        assertEquals("Miss count should not increase on cache hit", missAfterFirst, cache.getMissCount());
            return new org.apache.lucene.search.TermQuery(new org.apache.lucene.index.Term("tag", value.toString()));  
 * {@link LuceneFilterDelegationHandle} so that delegated queries  
    private LuceneReader buildLuceneReader() {  
     *  
        QueryShardContext qsc = mock(QueryShardContext.class);  
        IndexSearcher searcher = buildLuceneReader().searcher(cache, policy);
            for (int p = 0; p < partitions; p++) {
                assertEquals("each concurrent partition must see all 50 matches", 50, (int) f.get());
        long hitAfterFirst = cache.getHitCount();  
        assertTrue("Cache miss expected on first call", cache.getMissCount() >= 1);  
            Document doc = new Document();
            org.apache.lucene.index.SegmentReader sr = (org.apache.lucene.index.SegmentReader) leaf.reader();  
        }
     * <p>Uses the exact same flow as the real delegation path: createWeight →
    }  
        // Branch A — populates the shared cache against the shared searcher's reader-context.  
import org.apache.lucene.search.DocIdSetIterator;
        IndexSearcher searcherA = luceneReader.searcher(cache, policy);
import static org.mockito.Mockito.mock;
        Query query = new org.apache.lucene.search.TermQuery(new org.apache.lucene.index.Term("tag", "hello"));
import java.util.concurrent.Future;
        Query query = new org.apache.lucene.search.TermQuery(new org.apache.lucene.index.Term("tag", "hello"));  
import org.apache.lucene.document.Document;
 * Verifies that the node-level query cache is wired into
        assertTrue("Cache hit expected on second call", cache.getHitCount() > hitBefore);
        LRUQueryCache cache = new LRUQueryCache(100, 10 * 1024 * 1024, context -> true, 256);  
    public void testCachedWeightProducesCorrectResults() throws Exception {
        assertTrue("second scan should hit the shared cache", cache.getHitCount() >= 1);
import org.apache.lucene.document.Field;
     */  
import org.apache.lucene.index.IndexWriter;
    private QueryShardContext mockQueryShardContext(IndexSearcher searcher) {
        assertEquals("Cached result should also return 50 docs", 50, count2);  
                }));  
public class LuceneFilterDelegationHandleQueryCacheTests extends OpenSearchTestCase {
     */
        // No cache set — this is what the old code did
        searcher.setQueryCachingPolicy(policy);
                + missAfterFirst  
     * Multi-partition safety: DataFusion fans a scan across partitions that concurrently call  
    @Override
        return org.opensearch.core.common.bytes.BytesReference.toBytes(out.bytes());
            missAfterFirst >= 1  
        AlwaysCachePolicy policy = new AlwaysCachePolicy();  
    }  
        out.writeNamedWriteable(qb);  
     * cache a {@code Weight} against searcher A's reader-context then evaluate it via searcher B —  
import java.util.List;  
    }
        long hitAfterSecond = cache.getHitCount();
        super.tearDown();
    private Directory directory;  
        ExecutorService pool = Executors.newFixedThreadPool(partitions);
    /**
        assertEquals("branch B (cache hit) matches the same 50 docs", 50, countMatchesOnLeaf(weightB, leaf));
            Object value = invocation.getArgument(0);
    }  
/**
import org.apache.lucene.store.Directory;
 *
        when(qsc.searcher()).thenReturn(searcher);
     * {@code IndexSearcher} instances over the SAME reader, both wired to one shared query cache,
        Query query = new org.apache.lucene.search.TermQuery(new org.apache.lucene.index.Term("tag", "hello"));
     * scorer(leaf) → iterate. The LRUQueryCache counts hits/misses at
import org.apache.lucene.search.QueryCachingPolicy;
        while (doc != DocIdSetIterator.NO_MORE_DOCS) {
    public void tearDown() throws Exception {
}
        }
     * the first scorer call produces a miss (populates cache) and the second
        int count = countMatchesOnLeaf(weight, reader.leaves().get(0));
        });
            writer.addDocument(doc);  
        for (int i = 0; i < 100; i++) {  
    }
        // so reusing the cached Weight does not trip the top-reader assertion.  
        public void onUse(Query query) {}  
        assertTrue("Should have cache hit on second scorer call, got hits: " + hitAfterSecond, hitAfterSecond >= 1);  
    public void setUp() throws Exception {
    public void testDelegationHandleCacheMissAndHit() throws Exception {
     * Regression for the self-union (multisearch / append) node crash: two separate
        for (var leaf : reader.leaves()) {
        when(fieldType.termQuery(org.mockito.ArgumentMatchers.any(), org.mockito.ArgumentMatchers.any())).thenAnswer(invocation -> {
        long hitBefore = cache.getHitCount();  
            for (Future<Integer> f : futures) {  
     */
        reader = DirectoryReader.open(writer);  
            List<Future<Integer>> futures = new ArrayList<>();
        var leaf = reader.leaves().get(0);
package org.opensearch.be.lucene;
    }
                + ")",
import org.apache.lucene.store.ByteBuffersDirectory;  
    }
import org.apache.lucene.index.DirectoryReader;
            genMap.put(1L, sr.getSegmentInfo().info.name);
        searcher.setQueryCache(cache);
     */  
 * The OpenSearch Contributors require contributions made to  
        @Override
        Scorer scorer2 = weight2.scorer(leaf);  
        directory = new ByteBuffersDirectory();
