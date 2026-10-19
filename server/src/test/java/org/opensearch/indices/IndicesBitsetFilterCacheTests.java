     * Verifies that the cache size setting is registered, so it can be set in opensearch.yml.
            @Override
            doc1.add(new StringField("field", "val1", Field.Store.NO));
        try (IndicesBitsetFilterCache probeCache = new IndicesBitsetFilterCache(Settings.EMPTY)) {
            writer2.close();
            writer.commit();
     * once the total weight exceeds the configured limit.
            );
        try (IndicesBitsetFilterCache probeCache = new IndicesBitsetFilterCache(Settings.EMPTY)) {
            DirectoryReader reader = DirectoryReader.open(writer);
    }
        new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS).validate(settings, true);
            assertThat(cache.getCache().count(), equalTo(0));
        }
            IndexWriter writer = new IndexWriter(
            }
        }
                new ByteBuffersDirectory(),
            IndexReader.CacheKey readerKey = reader.leaves().get(0).reader().getCoreCacheHelper().getKey();
        try (IndicesBitsetFilterCache cache = new IndicesBitsetFilterCache(settings)) {
        }
                new ByteBuffersDirectory(),
            cache.getBitSetProducer(new TermQuery(new Term("field", "val0")), trackingListener).getBitSet(reader.leaves().get(0));
            assertThat(cache.getCache().count(), equalTo(3));
    }
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.index.IndexWriter;
     */
            Document doc = new Document();
            writer1.commit();
            writer.addDocument(doc);
            cache.getBitSetProducer(new TermQuery(new Term("field", "val2")), NO_OP_LISTENER).getBitSet(reader2.leaves().get(0));
                new ByteBuffersDirectory(),
            IndexWriter writer = new IndexWriter(
            doc.add(new StringField("field", "value", Field.Store.NO));
    /**
            // Simulate index1 close: close its reader.
            // Evict the entry (as size-based eviction would), then reload it through the real
            writer2.addDocument(doc2);
            writer2.commit();
    /**
            writer1.close();
                LeafReaderContext leaf = reader.leaves().get(i);
            cache.getBitSetProducer(new TermQuery(new Term("field", "val2")), NO_OP_LISTENER).getBitSet(reader2.leaves().get(0));
            writer.close();
            Document doc = new Document();
            writer1.addDocument(doc1);
            writer1.close();
 */
                new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(new LogByteSizeMergePolicy())
            DirectoryReader reader1 = OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer1), new ShardId("index1", "_na_", 0));
            DirectoryReader reader2 = OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer2), new ShardId("index2", "_na_", 0));
                new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(new LogByteSizeMergePolicy())
    }
    /**
    public void testReaderCloseInvalidatesEntryReloadedAfterEviction() throws Exception {
import org.apache.lucene.document.Document;
            // Close writer first so no references remain, then close reader.
            IndexWriter writer2 = new IndexWriter(
            Document doc1 = new Document();
    public void testCacheSizeSettingIsRegistered() {
            );
            IndexWriter writer = new IndexWriter(
            doc3.add(new StringField("field", "val3", Field.Store.NO));
                Document doc = new Document();
            writer2.commit();
        try (IndicesBitsetFilterCache cache = new IndicesBitsetFilterCache(Settings.EMPTY)) {
            DirectoryReader reader = DirectoryReader.open(writer);
        long cacheSizeBytes = singleEntryBytes;
import org.opensearch.common.settings.Settings;
            writer2.close();
            reader1.close();
            reader2.close();
            Document doc1 = new Document();
import org.apache.lucene.index.IndexReader;
            doc2.add(new StringField("field", "val2", Field.Store.NO));
            writer2.addDocument(doc2);
                new ByteBuffersDirectory(),
                new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(new LogByteSizeMergePolicy())
            writer.commit();
        // Probe for single entry size.
     * reload just re-cached, leaving the reloaded entry with no cleanup path when the reader
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
            assertThat(cache.getCache().weight(), lessThanOrEqualTo(cacheSizeBytes));
            writer2.addDocument(doc2);
                new ByteBuffersDirectory(),
import org.opensearch.core.index.shard.ShardId;
                doc.add(new StringField("field", "val" + i, Field.Store.NO));
     * Verifies that closing one segment's reader invalidates every query cached for that segment,
        @Override
                new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(new LogByteSizeMergePolicy())
            }
     * Verifies that entries from multiple indices share the same cache and the size limit applies globally.
                BitSetProducer producer = cache.getBitSetProducer(new TermQuery(new Term("field", "val" + i)), NO_OP_LISTENER);
        final AtomicLong removedBytes = new AtomicLong();
            writer.commit();
            writer2.close();
import org.apache.lucene.document.StringField;
                new ByteBuffersDirectory(),
            probeCache.getBitSetProducer(new TermQuery(new Term("field", "value")), NO_OP_LISTENER).getBitSet(reader.leaves().get(0));
import org.opensearch.common.settings.ClusterSettings;
                writer.addDocument(doc);
    }
            assertThat(probeCache.getCache().count(), equalTo(1));
import java.util.concurrent.atomic.AtomicLong;
            cache.getBitSetProducer(new TermQuery(new Term("field", "val1")), NO_OP_LISTENER).getBitSet(reader1.leaves().get(0));
            singleEntryBytes = probeCache.getCache().weight();
            assertThat(cache.getCache().count(), equalTo(1));
 * compatible open source license.
    public void testReaderCloseInvalidatesAllQueriesForItsSegments() throws Exception {
        // Cache fits only 1 entry.
            reader.close();
            writer.commit();
            writer.close();
     * Verifies that when the cache size setting is configured, the cache evicts entries
        long cacheSizeBytes = singleEntryBytes * 2;
            assertThat(cache.getCache().count(), lessThanOrEqualTo(2));
            );
            reader2.close();
     */
    }
            // load path while the reader is still open.
            Document doc = new Document();
            DirectoryReader reader2 = OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer2), new ShardId("index2", "_na_", 0));
     * synchronously and by exact key, while entries for still-open segments are untouched.
            );
    public void testEntriesInvalidatedOnReaderClose() throws Exception {
            Document doc1 = new Document();
            writer3.addDocument(doc3);
            for (int i = 0; i < 2; i++) {
            DirectoryReader reader = DirectoryReader.open(writer);
        // First, figure out how large a single bitset entry is by caching one.
        public void onRemoval(ShardId shardId, Accountable accountable) {}
            reader.close();
}
    public void testCacheSizeLimitIsHonored() throws Exception {
import org.apache.lucene.index.IndexWriterConfig;
     * keys on eviction: an eviction racing a reload of the same key could unregister the key the
            // Create two separate "indices" with their own writers.
            );
            Document doc2 = new Document();
            // Create an index with 3 separate segments (3 commits), each with one doc matching a different query.
            // Cache first entry.
                doc.add(new StringField("field", "val" + i, Field.Store.NO));
            reader.close();
            cache.getBitSetProducer(new TermQuery(new Term("field", "val1")), trackingListener).getBitSet(reader.leaves().get(1));
            producer.getBitSet(reader.leaves().get(0));
            assertThat(cache.getCache().count(), equalTo(1));
            assertThat(cache.getCache().weight(), lessThanOrEqualTo(cacheSizeBytes));
            doc.add(new StringField("field", "value", Field.Store.NO));
        try (IndicesBitsetFilterCache cache = new IndicesBitsetFilterCache(settings)) {
            IndexWriter writer = new IndexWriter(
                new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(new LogByteSizeMergePolicy())
        }
            assertThat(cache.getCache().count(), equalTo(0));
                new ByteBuffersDirectory(),
                new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(new LogByteSizeMergePolicy())
     * closes.
        try (IndicesBitsetFilterCache cache = new IndicesBitsetFilterCache(Settings.EMPTY)) {
            Query query = new TermQuery(new Term("field", "value"));
            cache.getBitSetProducer(new TermQuery(new Term("field", "val1")), NO_OP_LISTENER).getBitSet(reader1.leaves().get(0));
            reader1.close();
        }
import org.apache.lucene.store.ByteBuffersDirectory;
            DirectoryReader reader = DirectoryReader.open(writer);
                writer.commit();
     * Verifies that an entry evicted and then reloaded while its reader is open is still
        };
    /**
            doc2.add(new StringField("field", "val2", Field.Store.NO));
                new ByteBuffersDirectory(),
            doc1.add(new StringField("field", "val1", Field.Store.NO));
import org.apache.lucene.util.Accountable;
            }
        Settings settings = Settings.builder().put("indices.cache.bitset.size", cacheSizeBytes + "b").build();
            DirectoryReader reader3 = OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer3), new ShardId("index3", "_na_", 0));
                new ByteBuffersDirectory(),
        public void onCache(ShardId shardId, Accountable accountable) {}
            doc.add(new StringField("field", "value", Field.Store.NO));
                writer.addDocument(doc);
            DirectoryReader reader = DirectoryReader.open(writer);
            producer.getBitSet(reader.leaves().get(0));
            assertThat(reader.leaves().size(), equalTo(2));
            assertThat(singleEntryBytes, greaterThan(0L));
            );
import org.apache.lucene.document.Field;
            IndexWriter writer2 = new IndexWriter(
            assertThat(removedBytes.get(), greaterThan(0L));
            DirectoryReader reader2 = OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer2), new ShardId("index2", "_na_", 0));
            IndexWriter writer1 = new IndexWriter(
import static org.hamcrest.Matchers.lessThanOrEqualTo;
            reader3.close();
                new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(new LogByteSizeMergePolicy())
            writer.close();
            // Reader close invalidates its entries synchronously.
            BitSetProducer producer = cache.getBitSetProducer(query, NO_OP_LISTENER);
            probeCache.getBitSetProducer(new TermQuery(new Term("field", "value")), NO_OP_LISTENER).getBitSet(reader.leaves().get(0));
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.LeafReaderContext;
            reader.close();
            writer.close();
            // Cache second entry — should evict the first since limit is 1 entry.
    }
                new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(new LogByteSizeMergePolicy())
            assertThat(cache.getCache().count(), equalTo(0));
            writer.close();
            public void onCache(ShardId shardId, Accountable accountable) {}
            IndexWriter writer = new IndexWriter(
            reader = OpenSearchDirectoryReader.wrap(reader, new ShardId("test", "_na_", 0));
            );
                    removedBytes.addAndGet(accountable.ramBytesUsed());
        // Cache fits 2 entries total across all indices.
        @Override
    private static final BitsetFilterCache.Listener NO_OP_LISTENER = new BitsetFilterCache.Listener() {
            // 3 segments, cache 3 different queries — one per segment.
            assertThat(cache.getCache().count(), equalTo(1));
            public void onRemoval(ShardId shardId, Accountable accountable) {
import org.apache.lucene.search.Query;
        }
            doc.add(new StringField("field", "value", Field.Store.NO));
            assertThat(cache.getCache().count(), equalTo(1));
     */
                new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(new LogByteSizeMergePolicy())
            Document doc2 = new Document();
        Settings settings = Settings.builder().put("indices.cache.bitset.size", "15%").build();
            Document doc3 = new Document();
     * Verifies that entries from a closed reader are invalidated as soon as the reader closes.
                if (accountable != null) {
            reader = OpenSearchDirectoryReader.wrap(reader, new ShardId("probe", "_na_", 0));
                new ByteBuffersDirectory(),
            reader = OpenSearchDirectoryReader.wrap(reader, new ShardId("test", "_na_", 0));
            assertThat(cache.getCache().count(), equalTo(1));
    }
            // Each segment has exactly 1 leaf.
            assertThat(cache.getCache().count(), equalTo(1));
            );
     */
            DirectoryReader reader1 = OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer1), new ShardId("index1", "_na_", 0));
import org.opensearch.test.OpenSearchTestCase;
            writer.addDocument(doc);
                new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(new LogByteSizeMergePolicy())
        try (IndicesBitsetFilterCache cache = new IndicesBitsetFilterCache(Settings.EMPTY)) {
 * The OpenSearch Contributors require contributions made to
            assertThat(cache.getCache().count(), equalTo(0));
        long singleEntryBytes;
            // The LRU eviction should have kicked in.
            Document doc = new Document();
            reader.close();
        }
        try (IndicesBitsetFilterCache probeCache = new IndicesBitsetFilterCache(Settings.EMPTY)) {
            );
        // Probe for single entry size.
     * invalidated when the reader closes. Guards the per-reader key registry against unregistering
     */
            reader1.close();
            IndexWriter writer = new IndexWriter(
 *
            assertThat(cache.getCache().count(), equalTo(2));
            reader = OpenSearchDirectoryReader.wrap(reader, new ShardId("test", "_na_", 0));
            reader.close();
        // Now create a cache with a size limit that fits exactly 2 entries.
            writer1.commit();
            // Cache one entry from each "index".
            // 3 entries inserted but only 2 fit — global eviction should have kicked in.
    /**
            BitSetProducer producer = probeCache.getBitSetProducer(new TermQuery(new Term("field", "value")), NO_OP_LISTENER);
                }
    public void testIndexCloseOnlyRemovesItsOwnEntries() throws Exception {
    /**
            assertThat(cache.getCache().count(), lessThanOrEqualTo(2));
            for (int i = 0; i < 3; i++) {
        try (IndicesBitsetFilterCache cache = new IndicesBitsetFilterCache(settings)) {
                new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(new LogByteSizeMergePolicy())
            doc.add(new StringField("field", "value", Field.Store.NO));
            writer.close();
            assertThat(cache.getCache().count(), equalTo(1));
        assertTrue(ClusterSettings.BUILT_IN_CLUSTER_SETTINGS.contains(IndicesBitsetFilterCache.INDICES_BITSET_FILTER_CACHE_SIZE_SETTING));
     * Verifies that when one index's readers are closed (simulating index close),
            writer.addDocument(doc);
            // Create two separate "indices" (different ShardIds, different writers).
                new ByteBuffersDirectory(),
            writer1.close();
            writer.close();
 * this file be licensed under the Apache-2.0 license or a
            singleEntryBytes = probeCache.getCache().weight();
            reader = OpenSearchDirectoryReader.wrap(reader, new ShardId("probe", "_na_", 0));
        Settings settings = Settings.builder().put("indices.cache.bitset.size", cacheSizeBytes + "b").build();
            cache.getBitSetProducer(new TermQuery(new Term("field", "val2")), NO_OP_LISTENER).getBitSet(reader2.leaves().get(0));
    };
            );
                new ByteBuffersDirectory(),
                new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(new LogByteSizeMergePolicy())
            doc1.add(new StringField("field", "val1", Field.Store.NO));
public class IndicesBitsetFilterCacheTests extends OpenSearchTestCase {
            assertThat(removedBytes.get(), equalTo(0L));
            writer.commit();
                new ByteBuffersDirectory(),
            cache.getCache().invalidate(new IndicesBitsetFilterCache.BitsetCacheKey(readerKey, query));
     */
            writer3.close();
            for (int i = 0; i < 3; i++) {
        long singleEntryBytes;
            Document doc = new Document();
            doc2.add(new StringField("field", "val2", Field.Store.NO));
            DirectoryReader reader = DirectoryReader.open(writer);
            assertThat(reader.leaves().size(), equalTo(3));
            Document doc2 = new Document();
import org.opensearch.index.cache.bitset.BitsetFilterCache;
                Document doc = new Document();
        long singleEntryBytes;
    public void testEvictionTriggersOnRemovalListener() throws Exception {
            cache.getBitSetProducer(new TermQuery(new Term("field", "other")), NO_OP_LISTENER).getBitSet(reader1.leaves().get(0));
            writer2.commit();
            DirectoryReader reader1 = OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer1), new ShardId("index1", "_na_", 0));
            cache.getBitSetProducer(new TermQuery(new Term("field", "value")), NO_OP_LISTENER).getBitSet(reader.leaves().get(0));
import org.apache.lucene.search.join.BitSetProducer;
                new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(new LogByteSizeMergePolicy())
import org.apache.lucene.index.LogByteSizeMergePolicy;
import org.apache.lucene.search.TermQuery;
    }
            // Only index1's entry is removed; index2's entry remains.
            );
    /**
                new ByteBuffersDirectory(),
    /**
     */
            singleEntryBytes = probeCache.getCache().weight();
            cache.getBitSetProducer(new TermQuery(new Term("field", "val3")), NO_OP_LISTENER).getBitSet(reader3.leaves().get(0));
     */
     * only that index's entries are removed while other indices' entries remain.
            // We inserted 3 entries but the cache can only hold 2.
            }
            @Override
            writer1.addDocument(doc1);
        BitsetFilterCache.Listener trackingListener = new BitsetFilterCache.Listener() {
            writer.addDocument(doc);
            writer.addDocument(doc);
            IndexWriter writer1 = new IndexWriter(
     * Verifies that the onRemoval listener is called when entries are evicted due to size limit.
        }
            writer1.commit();
import org.apache.lucene.analysis.standard.StandardAnalyzer;
            producer.getBitSet(reader.leaves().get(0));
        }
        Settings settings = Settings.builder().put("indices.cache.bitset.size", cacheSizeBytes + "b").build();
            IndexWriter writer3 = new IndexWriter(
            );
            reader.close();
            // Two distinct queries cached against reader1's segment, one against reader2's.
/*
        }
        try (IndicesBitsetFilterCache cache = new IndicesBitsetFilterCache(Settings.EMPTY)) {
            cache.getBitSetProducer(new TermQuery(new Term("field", "val1")), NO_OP_LISTENER).getBitSet(reader1.leaves().get(0));
            assertThat(cache.getCache().count(), equalTo(0));
            writer1.addDocument(doc1);
import org.apache.lucene.index.Term;
            reader2.close();
            // Cache one entry from each index.
            );
                new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(new LogByteSizeMergePolicy())
            );
            IndexWriter writer = new IndexWriter(
            IndexWriter writer1 = new IndexWriter(
            writer3.commit();
            reader = OpenSearchDirectoryReader.wrap(reader, new ShardId("probe", "_na_", 0));
    public void testMultipleIndicesShareCacheWithGlobalSizeLimit() throws Exception {
        long cacheSizeBytes = singleEntryBytes * 2;
            DirectoryReader reader = DirectoryReader.open(writer);
            IndexWriter writer2 = new IndexWriter(
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
package org.opensearch.indices;
                writer.commit();
                producer.getBitSet(leaf);
