        int count = 0;
    @Override
    }
        document = new Document();
        assertThat(matchCount(filter, reader), equalTo(1));
        DirectoryReader reader = DirectoryReader.open(writer);
        IOUtils.close(reader, writer, dir);
                    assertEquals("test", shardId.getIndexName());
            public void onRemoval(ShardId shardId, Accountable accountable) {}
import static org.hamcrest.Matchers.nullValue;
        assertThat(indicesCache.getCache().count(), equalTo(0));
        assertThat(indicesCache.getCache().count(), equalTo(3));
        // createListener returns non-null when indicesCache is present
        assertEquals(0, stats.get());
                }
            @Override
}
            public void onCache(ShardId shardId, Accountable accountable) {}
        // The deprecated 2-arg constructor sets indicesCache to null.
import org.apache.lucene.index.LeafReaderContext;
public class BitSetFilterCacheTests extends OpenSearchTestCase {
        Document doc = new Document();
/*
            public void onCache(ShardId shardId, Accountable accountable) {}
import org.apache.lucene.index.IndexWriter;
        cache.onRemoval(null);
        // now cached
 */
        reader.close();
        }
import org.apache.lucene.document.Document;
        });
import org.opensearch.common.settings.Settings;
            @Override
        for (LeafReaderContext ctx : reader.leaves()) {
            @Override
            }
        BitSet bitSet = BitsetFilterCache.bitsetFromQuery(new TermQuery(new Term("field", "value")), reader.leaves().get(0));
 * not use this file except in compliance with the License.
        writer.addDocument(document);
        IOUtils.close(reader, writer);
        document = new Document();
import org.apache.lucene.index.LogByteSizeMergePolicy;
    }
            }
import java.util.concurrent.TimeUnit;
            new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(new LogByteSizeMergePolicy())
        expectThrows(IllegalStateException.class, () -> cache.getBitSetProducer(new MatchAllDocsQuery()));
        IndicesBitsetFilterCache indicesCache = new IndicesBitsetFilterCache(Settings.EMPTY);
 * The OpenSearch Contributors require contributions made to
            final BitSet bitSet = producer.getBitSet(ctx);
                count += bitSet.cardinality();
    public void testBitsetFromQuery() throws IOException {
        final IndexReader reader = OpenSearchDirectoryReader.wrap(writerReader, new ShardId("test", "_na_", 0));
        BitsetFilterCache cache = new BitsetFilterCache(INDEX_SETTINGS, indicesCache, new BitsetFilterCache.Listener() {
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.test.OpenSearchTestCase;
        BitSetProducer filter = cache.getBitSetProducer(new TermQuery(new Term("field", "value")));
            @Override
import org.opensearch.indices.IndicesBitsetFilterCache;
package org.opensearch.index.cache.bitset;
import org.apache.lucene.search.join.BitSetProducer;
 * specific language governing permissions and limitations
        cache.close();
import org.apache.lucene.search.TermQuery;
        writer.addDocument(document);
        reader = OpenSearchDirectoryReader.wrap(reader, new ShardId("test", "_na_", 0));
        Document document = new Document();
            new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(new LogByteSizeMergePolicy())
        reader = OpenSearchDirectoryReader.wrap(reader, new ShardId("test", "_na_", 0));
 */
                    assertNull(shardId);
    public void tearDown() throws Exception {
 * Licensed to Elasticsearch under one or more contributor
                } else {
import org.apache.lucene.analysis.standard.StandardAnalyzer;
        // This test verifies the producer works for any index.
        super.tearDown();
        IndexWriter writer = new IndexWriter(
    }
                onRemoveCalls.incrementAndGet();
 *
        indicesCache.close();
        IndexWriter writer = new IndexWriter(dir, newIndexWriterConfig());
                    assertNotNull(shardId);
        try {
        assertEquals(1, onRemoveCalls.get());
        indicesCache.close();
            public void onCache(ShardId shardId, Accountable accountable) {}
import org.opensearch.core.index.shard.ShardId;
        });
        threadPool = new TestThreadPool("bitset_filter_cache_test");
        assertThat(cache.createListener(threadPool), nullValue());
import static org.hamcrest.Matchers.notNullValue;
        cache.clear("test");
        writer.commit();
        BitsetFilterCache cache = new BitsetFilterCache(INDEX_SETTINGS, indicesCache, new BitsetFilterCache.Listener() {
        assertEquals(1, onCacheCalls.get());
        document.add(new StringField("field", "value", Field.Store.NO));
        writer.forceMerge(1);
        document.add(new StringField("field", "value", Field.Store.NO));
        writer.commit();
    public void testCreateListenerWithIndicesCache() throws IOException {
import org.apache.lucene.util.BitSet;
    public void testSetNullListener() {
        reader.close();
        ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS);
/*
        writer.commit();
            }
    }
        writer.addDocument(new Document());
import org.apache.lucene.util.Accountable;
 * this work for additional information regarding copyright
import org.apache.lucene.document.Field;
    }
    }
        final AtomicInteger onRemoveCalls = new AtomicInteger();
            @Override
    private static int matchCount(BitSetProducer producer, IndexReader reader) throws IOException {
        assertNotNull(bitSet);
/*
        final AtomicInteger onCacheCalls = new AtomicInteger();
        assertEquals(1, bitSet.cardinality());
        doc.add(new StringField("field", "value", Field.Store.NO));
        assertThat(matchCount(filter, reader), equalTo(3));
        assertNull(emptyBitSet);
        IndicesBitsetFilterCache indicesCache = new IndicesBitsetFilterCache(Settings.EMPTY);
        // These are all no-ops delegated to the node-level cache; just verify they don't throw.
                    assertNotNull(shardId);
            public void onRemoval(ShardId shardId, Accountable accountable) {}
        writer.commit();
 *
                if (writerReader != reader) {
        // Matching query returns non-null bitset
            public void onRemoval(ShardId shardId, Accountable accountable) {}
        IndexWriter writer = new IndexWriter(dir, newIndexWriterConfig());
        BitSetProducer filter = cache.getBitSetProducer(new TermQuery(new Term("field", "value")));
        BitsetFilterCache cache = new BitsetFilterCache(INDEX_SETTINGS, indicesCache, new BitsetFilterCache.Listener() {
            new ByteBuffersDirectory(),
    @Override
    public void testListener() throws IOException {
        assertThat(indicesCache.getCache().count(), equalTo(1));
        super.setUp();
            new BitsetFilterCache(INDEX_SETTINGS, new IndicesBitsetFilterCache(Settings.EMPTY), null);
        BitsetFilterCache cache = new BitsetFilterCache(INDEX_SETTINGS, new BitsetFilterCache.Listener() {
        reader = DirectoryReader.open(writer);
        });
            @Override
    }
        IndicesBitsetFilterCache indicesCache = new IndicesBitsetFilterCache(Settings.EMPTY);
import java.util.concurrent.atomic.AtomicLong;
 * this file be licensed under the Apache-2.0 license or a
        writer.close();
    }
        assertEquals(0, onRemoveCalls.get());
        BitsetFilterCache cache = new BitsetFilterCache(INDEX_SETTINGS, indicesCache, new BitsetFilterCache.Listener() {
            @Override
 * under the License.
        assertThat(matchCount(filter, reader), equalTo(3));
            public void onCache(ShardId shardId, Accountable accountable) {}
                stats.addAndGet(-accountable.ramBytesUsed());
        Document document = new Document();
                stats.addAndGet(accountable.ramBytesUsed());
        Directory dir = newDirectory();
        );
        indicesCache.close();
                }
            }
        IndicesBitsetFilterCache indicesCache = new IndicesBitsetFilterCache(Settings.EMPTY);
        assertTrue(stats.get() > 0);
    public void testDeprecatedConstructorAndCreateListener() throws IOException {
        // Non-matching query returns null bitset
 * SPDX-License-Identifier: Apache-2.0
        assertThat(cache.createListener(threadPool), notNullValue());
                    assertEquals(0, shardId.id());
            public void onRemoval(ShardId shardId, Accountable accountable) {}
        });
        assertThat(matchCount(filter, reader), equalTo(3));
        });
        Directory dir = newDirectory();
        // getBitSetProducer throws when indicesCache is null
        final DirectoryReader writerReader = DirectoryReader.open(writer);
        DirectoryReader reader = DirectoryReader.open(writer);
 * KIND, either express or implied.  See the License for the
    private static final IndexSettings INDEX_SETTINGS = IndexSettingsModule.newIndexSettings("test", Settings.EMPTY);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.apache.lucene.index.DirectoryReader;
        DirectoryReader reader = DirectoryReader.open(writer);
 * software distributed under the License is distributed on an
        indicesCache.close();
    public void testInvalidateEntries() throws Exception {
        writer.close();
        return count;
                producer.getBitSet(ctx);
        writer.addDocument(doc);
        }
            if (bitSet != null) {
            IOUtils.close(reader, dir);
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
                    assertNull(shardId);
            public void onRemoval(ShardId shardId, Accountable accountable) {}
import org.apache.lucene.index.IndexReader;
 * Modifications Copyright OpenSearch Contributors. See
 *
            public void onCache(ShardId shardId, Accountable accountable) {}
        document.add(new StringField("field", "value", Field.Store.NO));
        final AtomicLong stats = new AtomicLong();
    public void testRejectOtherIndex() throws IOException {
        );
 * GitHub history for details.
    public void testNoOpDelegationMethods() throws IOException {
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.document.StringField;
        // createListener returns null when indicesCache is null
            @Override
        try {
        });
        BitsetFilterCache cache = new BitsetFilterCache(INDEX_SETTINGS, indicesCache, new BitsetFilterCache.Listener() {
        writer.commit();
    }
        }
        cache.close();
            fail("listener can't be null");
        writer.addDocument(document);
        BitSet emptyBitSet = BitsetFilterCache.bitsetFromQuery(new TermQuery(new Term("field", "missing")), reader.leaves().get(0));
        // There are 3 segments, each with 1 query = 3 entries in the flat cache
            assertEquals("listener must not be null", ex.getMessage());
        document.add(new StringField("field", "value", Field.Store.NO));
import org.apache.lucene.store.ByteBuffersDirectory;
                } else {
import java.util.concurrent.atomic.AtomicInteger;
import org.opensearch.threadpool.TestThreadPool;
import org.opensearch.index.IndexSettings;
 * compatible open source license.
 * You may obtain a copy of the License at
 * license agreements. See the NOTICE file distributed with
        indicesCache.close();
    }
    public void setUp() throws Exception {
            public void onRemoval(ShardId shardId, Accountable accountable) {
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;
        IndexWriter writer = new IndexWriter(
            @Override
import java.io.IOException;
                    assertEquals(0, shardId.id());
        } finally {
    }
import org.opensearch.threadpool.ThreadPool;
            @Override
        cache.onClose(null);
            @Override
                    assertEquals("test", shardId.getIndexName());
 */
        // The node-level cache doesn't validate index identity — it just caches.
        writer.addDocument(document);
import org.apache.lucene.search.MatchAllDocsQuery;
import org.opensearch.test.IndexSettingsModule;
 * Unless required by applicable law or agreed to in writing,
            for (LeafReaderContext ctx : reader.leaves()) {
            new ByteBuffersDirectory(),
        assertThat(matchCount(filter, reader), equalTo(3));
        // Old 3 segments were closed (their entries invalidated on reader close), new merged segment cached = 1
            @Override
        // now cached
                onCacheCalls.incrementAndGet();
        reader = OpenSearchDirectoryReader.wrap(reader, new ShardId("test2", "_na_", 0));
        BitSetProducer producer = cache.getBitSetProducer(new MatchAllDocsQuery());
 * ownership. Elasticsearch licenses this file to you under
                if (writerReader != reader) {
        IndicesBitsetFilterCache indicesCache = new IndicesBitsetFilterCache(Settings.EMPTY);
        } catch (IllegalArgumentException ex) {
            public void onCache(ShardId shardId, Accountable accountable) {
import org.opensearch.common.util.io.IOUtils;
 *     http://www.apache.org/licenses/LICENSE-2.0
    private ThreadPool threadPool;
import static org.hamcrest.Matchers.equalTo;
        cache.close();
