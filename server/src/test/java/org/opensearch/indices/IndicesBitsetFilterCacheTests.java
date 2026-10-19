            );
        try (IndicesBitsetFilterCache cache = new IndicesBitsetFilterCache(settings)) {  
            cache.getBitSetProducer(new TermQuery(new Term("field", "val1")), trackingListener).getBitSet(reader.leaves().get(1));
            // Reader close invalidates its entries synchronously.
                Document doc = new Document();  
            BitSetProducer producer = cache.getBitSetProducer(query, NO_OP_LISTENER);
import org.apache.lucene.index.LeafReaderContext;  
            cache.getBitSetProducer(new TermQuery(new Term("field", "val2")), NO_OP_LISTENER).getBitSet(reader2.leaves().get(0));
import org.opensearch.core.index.shard.ShardId;
package org.opensearch.indices;
            writer1.addDocument(doc1);
            // load path while the reader is still open.  
                producer.getBitSet(leaf);  
            reader3.close();
                new ByteBuffersDirectory(),  
            doc.add(new StringField("field", "value", Field.Store.NO));  
        }  
            DirectoryReader reader1 = OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer1), new ShardId("index1", "_na_", 0));
            DirectoryReader reader = DirectoryReader.open(writer);  
     * keys on eviction: an eviction racing a reload of the same key could unregister the key the  
                    removedBytes.addAndGet(accountable.ramBytesUsed());  
import org.apache.lucene.search.Query;  
            // Evict the entry (as size-based eviction would), then reload it through the real
import org.apache.lucene.index.LogByteSizeMergePolicy;
            reader.close();  
import static org.hamcrest.Matchers.greaterThan;  
            // Create two separate "indices" (different ShardIds, different writers).
            cache.getCache().invalidate(new IndicesBitsetFilterCache.BitsetCacheKey(readerKey, query));
        }  
            writer.commit();  
        long singleEntryBytes;
            reader.close();
        Settings settings = Settings.builder().put("indices.cache.bitset.size", cacheSizeBytes + "b").build();
            Document doc1 = new Document();  
            reader = OpenSearchDirectoryReader.wrap(reader, new ShardId("test", "_na_", 0));
            writer1.close();  
            writer1.addDocument(doc1);
            IndexWriter writer2 = new IndexWriter(
 * SPDX-License-Identifier: Apache-2.0
            doc2.add(new StringField("field", "val2", Field.Store.NO));
            @Override  
            for (int i = 0; i < 3; i++) {
            cache.getBitSetProducer(new TermQuery(new Term("field", "val1")), NO_OP_LISTENER).getBitSet(reader1.leaves().get(0));
                new ByteBuffersDirectory(),
                new ByteBuffersDirectory(),  
            writer2.close();  
            writer.commit();
        }
import org.apache.lucene.index.IndexWriter;
    }  
            writer.close();  
                new ByteBuffersDirectory(),
            assertThat(cache.getCache().count(), equalTo(1));  
            assertThat(cache.getCache().count(), equalTo(1));
            // 3 segments, cache 3 different queries — one per segment.
            writer2.addDocument(doc2);
 * this file be licensed under the Apache-2.0 license or a
            Document doc = new Document();
            );
    }
            reader2.close();  
            assertThat(cache.getCache().count(), equalTo(0));  
            doc1.add(new StringField("field", "val1", Field.Store.NO));
                writer.addDocument(doc);
    public void testEntriesInvalidatedOnReaderClose() throws Exception {
            producer.getBitSet(reader.leaves().get(0));  
 */  
    };
            public void onCache(ShardId shardId, Accountable accountable) {}
        try (IndicesBitsetFilterCache cache = new IndicesBitsetFilterCache(Settings.EMPTY)) {  
            reader.close();  
    }
import org.apache.lucene.document.Document;
            assertThat(cache.getCache().count(), equalTo(1));  
            assertThat(cache.getCache().weight(), lessThanOrEqualTo(cacheSizeBytes));
            writer.commit();
    /**
            // Cache one entry from each "index".  
            writer.close();
            IndexWriter writer = new IndexWriter(  
        assertTrue(ClusterSettings.BUILT_IN_CLUSTER_SETTINGS.contains(IndicesBitsetFilterCache.INDICES_BITSET_FILTER_CACHE_SIZE_SETTING));
            writer.addDocument(doc);  
            assertThat(removedBytes.get(), greaterThan(0L));  
            assertThat(cache.getCache().count(), equalTo(1));
}
                doc.add(new StringField("field", "val" + i, Field.Store.NO));  
    /**
            }
        try (IndicesBitsetFilterCache cache = new IndicesBitsetFilterCache(settings)) {  
            writer1.commit();  
            DirectoryReader reader1 = OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer1), new ShardId("index1", "_na_", 0));
     */
                if (accountable != null) {
                new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(new LogByteSizeMergePolicy())
     * Verifies that when the cache size setting is configured, the cache evicts entries
        // Cache fits only 1 entry.  
            writer3.commit();  
            writer1.close();  
            // Cache second entry — should evict the first since limit is 1 entry.  
            Document doc = new Document();
                writer.addDocument(doc);
    public void testReaderCloseInvalidatesEntryReloadedAfterEviction() throws Exception {
            IndexWriter writer = new IndexWriter(
        long singleEntryBytes;  
    }
        long cacheSizeBytes = singleEntryBytes * 2;  
        };  
    public void testCacheSizeLimitIsHonored() throws Exception {
     */  
        // Cache fits 2 entries total across all indices.
    /**
            assertThat(reader.leaves().size(), equalTo(2));
            for (int i = 0; i < 2; i++) {
     * only that index's entries are removed while other indices' entries remain.  
import org.apache.lucene.document.StringField;
    public void testReaderCloseInvalidatesAllQueriesForItsSegments() throws Exception {  
            assertThat(cache.getCache().count(), equalTo(3));  
            writer1.close();  
        long cacheSizeBytes = singleEntryBytes * 2;  
                writer.commit();
        new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS).validate(settings, true);
            for (int i = 0; i < 3; i++) {  
                new ByteBuffersDirectory(),  
            producer.getBitSet(reader.leaves().get(0));
            writer.close();  
     * Verifies that the cache size setting is registered, so it can be set in opensearch.yml.
        try (IndicesBitsetFilterCache probeCache = new IndicesBitsetFilterCache(Settings.EMPTY)) {  
            writer2.commit();  
            writer2.close();
            assertThat(cache.getCache().count(), lessThanOrEqualTo(2));  
        }  
        @Override  
            Document doc = new Document();
            IndexWriter writer = new IndexWriter(
        }
            assertThat(cache.getCache().count(), equalTo(0));
            assertThat(cache.getCache().count(), equalTo(0));
            // Cache one entry from each index.
            cache.getBitSetProducer(new TermQuery(new Term("field", "val0")), trackingListener).getBitSet(reader.leaves().get(0));
            producer.getBitSet(reader.leaves().get(0));
     * Verifies that entries from a closed reader are invalidated as soon as the reader closes.
        try (IndicesBitsetFilterCache cache = new IndicesBitsetFilterCache(settings)) {
            );  
                new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(new LogByteSizeMergePolicy())
            Document doc2 = new Document();  
            IndexWriter writer = new IndexWriter(
            IndexWriter writer1 = new IndexWriter(
            // 3 entries inserted but only 2 fit — global eviction should have kicked in.
            reader1.close();
        }  
        Settings settings = Settings.builder().put("indices.cache.bitset.size", "15%").build();  
            reader.close();
            writer.commit();
            // Cache first entry.
            reader = OpenSearchDirectoryReader.wrap(reader, new ShardId("test", "_na_", 0));  
     * reload just re-cached, leaving the reloaded entry with no cleanup path when the reader
            }
            public void onRemoval(ShardId shardId, Accountable accountable) {
            assertThat(cache.getCache().count(), equalTo(1));
            doc.add(new StringField("field", "value", Field.Store.NO));
            IndexWriter writer1 = new IndexWriter(
 * The OpenSearch Contributors require contributions made to  
        public void onCache(ShardId shardId, Accountable accountable) {}
            }
    public void testCacheSizeSettingIsRegistered() {
        try (IndicesBitsetFilterCache probeCache = new IndicesBitsetFilterCache(Settings.EMPTY)) {
     * Verifies that the onRemoval listener is called when entries are evicted due to size limit.
            doc2.add(new StringField("field", "val2", Field.Store.NO));
     */  
            );
            IndexWriter writer = new IndexWriter(  
                doc.add(new StringField("field", "val" + i, Field.Store.NO));
            doc3.add(new StringField("field", "val3", Field.Store.NO));
import org.opensearch.index.cache.bitset.BitsetFilterCache;  
                new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(new LogByteSizeMergePolicy())
            IndexWriter writer = new IndexWriter(  
            // Close writer first so no references remain, then close reader.
            // Create two separate "indices" with their own writers.
            singleEntryBytes = probeCache.getCache().weight();
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.index.IndexWriterConfig;
 * compatible open source license.
            DirectoryReader reader2 = OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer2), new ShardId("index2", "_na_", 0));  
        BitsetFilterCache.Listener trackingListener = new BitsetFilterCache.Listener() {
            reader = OpenSearchDirectoryReader.wrap(reader, new ShardId("probe", "_na_", 0));  
            reader.close();
            DirectoryReader reader = DirectoryReader.open(writer);
            reader = OpenSearchDirectoryReader.wrap(reader, new ShardId("test", "_na_", 0));
            // Each segment has exactly 1 leaf.  
    public void testEvictionTriggersOnRemovalListener() throws Exception {
     * synchronously and by exact key, while entries for still-open segments are untouched.
            cache.getBitSetProducer(new TermQuery(new Term("field", "other")), NO_OP_LISTENER).getBitSet(reader1.leaves().get(0));
            );
            doc1.add(new StringField("field", "val1", Field.Store.NO));
            writer2.addDocument(doc2);
            assertThat(cache.getCache().weight(), lessThanOrEqualTo(cacheSizeBytes));  
                new ByteBuffersDirectory(),  
    }
     * Verifies that an entry evicted and then reloaded while its reader is open is still
            writer1.commit();  
        final AtomicLong removedBytes = new AtomicLong();
            IndexWriter writer2 = new IndexWriter(
            assertThat(singleEntryBytes, greaterThan(0L));
                }
            );  
                BitSetProducer producer = cache.getBitSetProducer(new TermQuery(new Term("field", "val" + i)), NO_OP_LISTENER);
            writer.addDocument(doc);
            cache.getBitSetProducer(new TermQuery(new Term("field", "val1")), NO_OP_LISTENER).getBitSet(reader1.leaves().get(0));  
     */  
        Settings settings = Settings.builder().put("indices.cache.bitset.size", cacheSizeBytes + "b").build();
            IndexWriter writer1 = new IndexWriter(
                writer.commit();  
            cache.getBitSetProducer(new TermQuery(new Term("field", "val1")), NO_OP_LISTENER).getBitSet(reader1.leaves().get(0));  
            // Simulate index1 close: close its reader.
            DirectoryReader reader2 = OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer2), new ShardId("index2", "_na_", 0));  
    }
        // Probe for single entry size.
                new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(new LogByteSizeMergePolicy())
            writer2.close();
     * invalidated when the reader closes. Guards the per-reader key registry against unregistering
import org.opensearch.common.settings.Settings;
            singleEntryBytes = probeCache.getCache().weight();
                new ByteBuffersDirectory(),  
                new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(new LogByteSizeMergePolicy())
 *
                new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(new LogByteSizeMergePolicy())
        try (IndicesBitsetFilterCache cache = new IndicesBitsetFilterCache(Settings.EMPTY)) {
            DirectoryReader reader2 = OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer2), new ShardId("index2", "_na_", 0));  
            @Override  
            DirectoryReader reader = DirectoryReader.open(writer);
     * closes.
            );
            Document doc3 = new Document();  
import static org.hamcrest.Matchers.lessThanOrEqualTo;
            writer2.commit();  
            assertThat(cache.getCache().count(), equalTo(1));  
     * once the total weight exceeds the configured limit.  
                new ByteBuffersDirectory(),
            IndexReader.CacheKey readerKey = reader.leaves().get(0).reader().getCoreCacheHelper().getKey();
            }  
            BitSetProducer producer = probeCache.getBitSetProducer(new TermQuery(new Term("field", "value")), NO_OP_LISTENER);  
            reader = OpenSearchDirectoryReader.wrap(reader, new ShardId("probe", "_na_", 0));
        }
        }
import org.apache.lucene.document.Field;  
            writer.close();
                new ByteBuffersDirectory(),
            Document doc = new Document();
            writer3.close();
import org.apache.lucene.index.DirectoryReader;
                new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(new LogByteSizeMergePolicy())
                LeafReaderContext leaf = reader.leaves().get(i);
            Document doc1 = new Document();  
/*  
            // Create an index with 3 separate segments (3 commits), each with one doc matching a different query.
    /**
        try (IndicesBitsetFilterCache cache = new IndicesBitsetFilterCache(Settings.EMPTY)) {
    /**  
        // Now create a cache with a size limit that fits exactly 2 entries.
                new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(new LogByteSizeMergePolicy())  
        }
            writer2.addDocument(doc2);
                new ByteBuffersDirectory(),
                new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(new LogByteSizeMergePolicy())
            reader.close();
            probeCache.getBitSetProducer(new TermQuery(new Term("field", "value")), NO_OP_LISTENER).getBitSet(reader.leaves().get(0));
                new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(new LogByteSizeMergePolicy())
            DirectoryReader reader = DirectoryReader.open(writer);
            probeCache.getBitSetProducer(new TermQuery(new Term("field", "value")), NO_OP_LISTENER).getBitSet(reader.leaves().get(0));
            writer.addDocument(doc);
            assertThat(reader.leaves().size(), equalTo(3));
            );
        @Override  
            writer.commit();
import static org.hamcrest.Matchers.equalTo;
                new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(new LogByteSizeMergePolicy())
            );
            cache.getBitSetProducer(new TermQuery(new Term("field", "val3")), NO_OP_LISTENER).getBitSet(reader3.leaves().get(0));  
     * Verifies that entries from multiple indices share the same cache and the size limit applies globally.
    public void testMultipleIndicesShareCacheWithGlobalSizeLimit() throws Exception {  
            cache.getBitSetProducer(new TermQuery(new Term("field", "value")), NO_OP_LISTENER).getBitSet(reader.leaves().get(0));
            DirectoryReader reader3 = OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer3), new ShardId("index3", "_na_", 0));
            reader.close();
            Query query = new TermQuery(new Term("field", "value"));
public class IndicesBitsetFilterCacheTests extends OpenSearchTestCase {  
            Document doc2 = new Document();  
            writer1.commit();  
    /**
import org.apache.lucene.search.join.BitSetProducer;
            assertThat(removedBytes.get(), equalTo(0L));
            cache.getBitSetProducer(new TermQuery(new Term("field", "val2")), NO_OP_LISTENER).getBitSet(reader2.leaves().get(0));
            doc1.add(new StringField("field", "val1", Field.Store.NO));
import org.opensearch.test.OpenSearchTestCase;
                Document doc = new Document();
            DirectoryReader reader = DirectoryReader.open(writer);  
            reader2.close();
                new ByteBuffersDirectory(),  
            doc2.add(new StringField("field", "val2", Field.Store.NO));
     */
     */
            assertThat(cache.getCache().count(), equalTo(1));
     */  
            // Only index1's entry is removed; index2's entry remains.
            writer.addDocument(doc);
            reader1.close();
            assertThat(cache.getCache().count(), equalTo(2));
            assertThat(cache.getCache().count(), lessThanOrEqualTo(2));
    /**  
        // First, figure out how large a single bitset entry is by caching one.  
import org.apache.lucene.store.ByteBuffersDirectory;  
    private static final BitsetFilterCache.Listener NO_OP_LISTENER = new BitsetFilterCache.Listener() {
    public void testIndexCloseOnlyRemovesItsOwnEntries() throws Exception {
import org.opensearch.common.settings.ClusterSettings;  
import org.apache.lucene.index.Term;
            Document doc1 = new Document();  
            Document doc2 = new Document();  
                new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(new LogByteSizeMergePolicy())
            // Two distinct queries cached against reader1's segment, one against reader2's.
            writer.addDocument(doc);  
            reader1.close();  
                new ByteBuffersDirectory(),  
            );
        try (IndicesBitsetFilterCache probeCache = new IndicesBitsetFilterCache(Settings.EMPTY)) {
            );  
    }
        try (IndicesBitsetFilterCache cache = new IndicesBitsetFilterCache(Settings.EMPTY)) {
                new ByteBuffersDirectory(),  
            writer.close();
            doc.add(new StringField("field", "value", Field.Store.NO));
            assertThat(cache.getCache().count(), equalTo(0));
            assertThat(cache.getCache().count(), equalTo(0));
            writer1.addDocument(doc1);
            writer3.addDocument(doc3);
            );
            assertThat(probeCache.getCache().count(), equalTo(1));  
     */
import org.apache.lucene.analysis.standard.StandardAnalyzer;
            Document doc = new Document();  
            singleEntryBytes = probeCache.getCache().weight();  
            DirectoryReader reader1 = OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer1), new ShardId("index1", "_na_", 0));
            writer.close();
import java.util.concurrent.atomic.AtomicLong;  
    /**
            reader = OpenSearchDirectoryReader.wrap(reader, new ShardId("probe", "_na_", 0));
import org.apache.lucene.index.IndexReader;  
            DirectoryReader reader = DirectoryReader.open(writer);
        long singleEntryBytes;
    }
            reader2.close();
                new ByteBuffersDirectory(),  
     * Verifies that when one index's readers are closed (simulating index close),
            );
        Settings settings = Settings.builder().put("indices.cache.bitset.size", cacheSizeBytes + "b").build();
            doc.add(new StringField("field", "value", Field.Store.NO));
            // The LRU eviction should have kicked in.
                new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(new LogByteSizeMergePolicy())
import org.apache.lucene.util.Accountable;
            DirectoryReader reader = DirectoryReader.open(writer);  
        public void onRemoval(ShardId shardId, Accountable accountable) {}
        long cacheSizeBytes = singleEntryBytes;
            IndexWriter writer = new IndexWriter(  
            IndexWriter writer2 = new IndexWriter(
            writer.close();  
            IndexWriter writer3 = new IndexWriter(
            cache.getBitSetProducer(new TermQuery(new Term("field", "val2")), NO_OP_LISTENER).getBitSet(reader2.leaves().get(0));
            // We inserted 3 entries but the cache can only hold 2.  
     * Verifies that closing one segment's reader invalidates every query cached for that segment,  
        }  
            writer2.commit();  
            doc.add(new StringField("field", "value", Field.Store.NO));  
        // Probe for single entry size.
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
            );  
                new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(new LogByteSizeMergePolicy())
