            public void onRemoval(ShardId shardId, Accountable accountable) {}  
        final AtomicInteger onRemoveCalls = new AtomicInteger();
        Directory dir = newDirectory();
    }
        });  
            public void onCache(ShardId shardId, Accountable accountable) {  
                if (writerReader != reader) {
 * Modifications Copyright OpenSearch Contributors. See
        } finally {  
        writer.commit();
    public void testSetNullListener() {
            public void onRemoval(ShardId shardId, Accountable accountable) {
        });
        }
import org.apache.lucene.search.MatchAllDocsQuery;  
        writer.commit();
            public void onCache(ShardId shardId, Accountable accountable) {}  
        assertThat(matchCount(filter, reader), equalTo(3));  
            @Override
            public void onRemoval(ShardId shardId, Accountable accountable) {}  
        assertEquals(1, onRemoveCalls.get());
/*  
        final AtomicInteger onCacheCalls = new AtomicInteger();  
        writer.addDocument(document);  
                    assertNotNull(shardId);
import org.apache.lucene.document.StringField;
                }  
            IOUtils.close(reader, dir);
 * SPDX-License-Identifier: Apache-2.0
    public void testNoOpDelegationMethods() throws IOException {
import org.apache.lucene.store.ByteBuffersDirectory;  
        BitsetFilterCache cache = new BitsetFilterCache(INDEX_SETTINGS, indicesCache, new BitsetFilterCache.Listener() {
    @Override
        IOUtils.close(reader, writer, dir);
        assertThat(matchCount(filter, reader), equalTo(3));  
            @Override  
        document = new Document();
        assertThat(indicesCache.getCache().count(), equalTo(1));
        // now cached
    @Override
        assertThat(matchCount(filter, reader), equalTo(3));  
        } catch (IllegalArgumentException ex) {
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
            for (LeafReaderContext ctx : reader.leaves()) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        // now cached
            @Override
    }
        reader = OpenSearchDirectoryReader.wrap(reader, new ShardId("test", "_na_", 0));
    public void tearDown() throws Exception {  
import org.opensearch.core.index.shard.ShardId;
            @Override
    }
 * GitHub history for details.
            new BitsetFilterCache(INDEX_SETTINGS, new IndicesBitsetFilterCache(Settings.EMPTY), null);  
        IndicesBitsetFilterCache indicesCache = new IndicesBitsetFilterCache(Settings.EMPTY);  
    }
        for (LeafReaderContext ctx : reader.leaves()) {
 * specific language governing permissions and limitations
        // These are all no-ops delegated to the node-level cache; just verify they don't throw.
            public void onRemoval(ShardId shardId, Accountable accountable) {}  
        DirectoryReader reader = DirectoryReader.open(writer);  
                } else {
        });
            @Override
    public void testListener() throws IOException {
            if (bitSet != null) {  
                    assertEquals("test", shardId.getIndexName());
        assertTrue(stats.get() > 0);  
        BitsetFilterCache cache = new BitsetFilterCache(INDEX_SETTINGS, indicesCache, new BitsetFilterCache.Listener() {
    public void testDeprecatedConstructorAndCreateListener() throws IOException {
 * The OpenSearch Contributors require contributions made to  
        reader.close();
        int count = 0;  
            @Override
        BitsetFilterCache cache = new BitsetFilterCache(INDEX_SETTINGS, new BitsetFilterCache.Listener() {  
 */
import org.apache.lucene.store.Directory;
    public void testRejectOtherIndex() throws IOException {
        // createListener returns null when indicesCache is null
        indicesCache.close();
        assertThat(matchCount(filter, reader), equalTo(1));
            @Override
        IndicesBitsetFilterCache indicesCache = new IndicesBitsetFilterCache(Settings.EMPTY);  
            @Override
 */  
        reader = DirectoryReader.open(writer);  
        try {
                    assertEquals("test", shardId.getIndexName());  
 *     http://www.apache.org/licenses/LICENSE-2.0
        document.add(new StringField("field", "value", Field.Store.NO));
        BitSetProducer filter = cache.getBitSetProducer(new TermQuery(new Term("field", "value")));
import org.apache.lucene.index.IndexReader;  
        IndexWriter writer = new IndexWriter(dir, newIndexWriterConfig());  
    public void setUp() throws Exception {  
        });
            public void onCache(ShardId shardId, Accountable accountable) {}  
            new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(new LogByteSizeMergePolicy())
        // getBitSetProducer throws when indicesCache is null
        reader.close();
 * not use this file except in compliance with the License.
            @Override
        writer.addDocument(document);
                } else {
    }  
    private ThreadPool threadPool;  
    public void testCreateListenerWithIndicesCache() throws IOException {
        BitSetProducer producer = cache.getBitSetProducer(new MatchAllDocsQuery());
import java.io.IOException;  
        BitsetFilterCache cache = new BitsetFilterCache(INDEX_SETTINGS, indicesCache, new BitsetFilterCache.Listener() {
        assertThat(indicesCache.getCache().count(), equalTo(0));  
        writer.addDocument(new Document());
            @Override
            }
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.index.LeafReaderContext;  
        });  
            new ByteBuffersDirectory(),  
        Document document = new Document();
            public void onCache(ShardId shardId, Accountable accountable) {}  
import org.apache.lucene.search.TermQuery;
    }  
public class BitSetFilterCacheTests extends OpenSearchTestCase {  
 * You may obtain a copy of the License at  
        );  
        reader = OpenSearchDirectoryReader.wrap(reader, new ShardId("test", "_na_", 0));
        threadPool = new TestThreadPool("bitset_filter_cache_test");
        assertThat(cache.createListener(threadPool), nullValue());  
 * ownership. Elasticsearch licenses this file to you under  
        cache.close();
        });  
        cache.clear("test");
        assertThat(matchCount(filter, reader), equalTo(3));  
import java.util.concurrent.atomic.AtomicInteger;
        writer.commit();  
        expectThrows(IllegalStateException.class, () -> cache.getBitSetProducer(new MatchAllDocsQuery()));  
import org.apache.lucene.index.DirectoryReader;
/*  
import org.opensearch.threadpool.TestThreadPool;  
        writer.commit();
        IOUtils.close(reader, writer);  
        super.tearDown();
            public void onCache(ShardId shardId, Accountable accountable) {}
                stats.addAndGet(-accountable.ramBytesUsed());  
        BitsetFilterCache cache = new BitsetFilterCache(INDEX_SETTINGS, indicesCache, new BitsetFilterCache.Listener() {  
    private static final IndexSettings INDEX_SETTINGS = IndexSettingsModule.newIndexSettings("test", Settings.EMPTY);
        Document document = new Document();  
        assertThat(indicesCache.getCache().count(), equalTo(3));
        // Matching query returns non-null bitset
        writer.addDocument(document);  
import org.opensearch.test.OpenSearchTestCase;
                }
 *  
    }
 *
        );
        // This test verifies the producer works for any index.
    }  
        cache.onRemoval(null);
        }  
        BitSet bitSet = BitsetFilterCache.bitsetFromQuery(new TermQuery(new Term("field", "value")), reader.leaves().get(0));
        BitSetProducer filter = cache.getBitSetProducer(new TermQuery(new Term("field", "value")));
package org.opensearch.index.cache.bitset;
        IndicesBitsetFilterCache indicesCache = new IndicesBitsetFilterCache(Settings.EMPTY);  
                onCacheCalls.incrementAndGet();
        BitsetFilterCache cache = new BitsetFilterCache(INDEX_SETTINGS, indicesCache, new BitsetFilterCache.Listener() {
                    assertEquals(0, shardId.id());
    }
        // The node-level cache doesn't validate index identity — it just caches.  
        assertNotNull(bitSet);  
        // The deprecated 2-arg constructor sets indicesCache to null.
            fail("listener can't be null");
            }
        writer.addDocument(document);
        doc.add(new StringField("field", "value", Field.Store.NO));
import org.opensearch.index.IndexSettings;
                    assertEquals(0, shardId.id());  
import org.opensearch.indices.IndicesBitsetFilterCache;  
        IndexWriter writer = new IndexWriter(
        assertEquals(0, stats.get());
        writer.forceMerge(1);
        assertEquals(1, bitSet.cardinality());
            @Override
import org.apache.lucene.search.join.BitSetProducer;
 */  
        writer.commit();
        writer.close();
    }  
        writer.addDocument(doc);  
        DirectoryReader reader = DirectoryReader.open(writer);  
 * Unless required by applicable law or agreed to in writing,
                    assertNull(shardId);
import static org.hamcrest.Matchers.nullValue;
        indicesCache.close();
import java.util.concurrent.atomic.AtomicLong;  
        try {
        // There are 3 segments, each with 1 query = 3 entries in the flat cache
                producer.getBitSet(ctx);
            }
            public void onCache(ShardId shardId, Accountable accountable) {}
/*
import org.apache.lucene.util.BitSet;  
import org.apache.lucene.document.Field;  
        IndexWriter writer = new IndexWriter(dir, newIndexWriterConfig());
    }  
        cache.close();  
        IndexWriter writer = new IndexWriter(  
                    assertNull(shardId);  
        assertEquals(0, onRemoveCalls.get());
 * compatible open source license.
        final AtomicLong stats = new AtomicLong();
        BitSet emptyBitSet = BitsetFilterCache.bitsetFromQuery(new TermQuery(new Term("field", "missing")), reader.leaves().get(0));
        DirectoryReader reader = DirectoryReader.open(writer);
import org.opensearch.test.IndexSettingsModule;
import static org.hamcrest.Matchers.notNullValue;  
                if (writerReader != reader) {  
        document.add(new StringField("field", "value", Field.Store.NO));  
        document.add(new StringField("field", "value", Field.Store.NO));
 * KIND, either express or implied.  See the License for the
import org.opensearch.threadpool.ThreadPool;
        Directory dir = newDirectory();  
}
    public void testBitsetFromQuery() throws IOException {
import org.apache.lucene.document.Document;
        // createListener returns non-null when indicesCache is present  
 * license agreements. See the NOTICE file distributed with
        indicesCache.close();
            public void onRemoval(ShardId shardId, Accountable accountable) {}
    private static int matchCount(BitSetProducer producer, IndexReader reader) throws IOException {
import org.apache.lucene.index.IndexWriterConfig;
import org.opensearch.common.util.io.IOUtils;  
        cache.onClose(null);  
import org.opensearch.common.settings.Settings;
        final IndexReader reader = OpenSearchDirectoryReader.wrap(writerReader, new ShardId("test", "_na_", 0));  
            public void onRemoval(ShardId shardId, Accountable accountable) {}
            @Override
        super.setUp();
import java.util.concurrent.TimeUnit;
        ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS);
import org.apache.lucene.index.Term;
import org.apache.lucene.util.Accountable;
            }
        IndicesBitsetFilterCache indicesCache = new IndicesBitsetFilterCache(Settings.EMPTY);
 * under the License.  
                onRemoveCalls.incrementAndGet();
        return count;
        document = new Document();
                count += bitSet.cardinality();
        }
                stats.addAndGet(accountable.ramBytesUsed());
            new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(new LogByteSizeMergePolicy())
        assertThat(cache.createListener(threadPool), notNullValue());
        Document doc = new Document();
        assertEquals(1, onCacheCalls.get());
                    assertNotNull(shardId);
 * this work for additional information regarding copyright
 *
            assertEquals("listener must not be null", ex.getMessage());  
        reader = OpenSearchDirectoryReader.wrap(reader, new ShardId("test2", "_na_", 0));
            new ByteBuffersDirectory(),
        indicesCache.close();
import org.apache.lucene.analysis.standard.StandardAnalyzer;
 * software distributed under the License is distributed on an
        IndicesBitsetFilterCache indicesCache = new IndicesBitsetFilterCache(Settings.EMPTY);  
        // Non-matching query returns null bitset  
    public void testInvalidateEntries() throws Exception {
import static org.hamcrest.Matchers.equalTo;
 * this file be licensed under the Apache-2.0 license or a
        // Old 3 segments were closed (their entries invalidated on reader close), new merged segment cached = 1
        assertNull(emptyBitSet);
        document.add(new StringField("field", "value", Field.Store.NO));
 * Licensed to Elasticsearch under one or more contributor  
            final BitSet bitSet = producer.getBitSet(ctx);
import org.apache.lucene.index.LogByteSizeMergePolicy;
        indicesCache.close();
import org.apache.lucene.index.IndexWriter;
        cache.close();  
        writer.close();
        final DirectoryReader writerReader = DirectoryReader.open(writer);
