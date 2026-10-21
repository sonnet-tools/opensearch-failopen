        iwc.setMergePolicy(NoMergePolicy.INSTANCE);
                assertEquals(3, cache.count());
        );
            shardId -> currentIdentity.get()
            ) {
            CoreValuesSourceType.BYTES,
import org.apache.lucene.util.BytesRef;
        IndexWriter iw = new IndexWriter(dir, iwc);
    // The cache captures shardIdentity at load time and skips the per-shard listener's onRemoval
        nodeCache.close();
        }
            }
        IndexFieldDataCache fieldCache = nodeCache.buildIndexFieldDataCache(
                assertTrue(retainedLeafBytes > 1);
        DirectoryReader ir = OpenSearchDirectoryReader.wrap(DirectoryReader.open(dir), new ShardId("_index", "_na_", 0));
                nodeOnCache.incrementAndGet();
                cachedGlobalOrdinals = (GlobalOrdinalsIndexFieldData) value;
            IndexWriterConfig config = new IndexWriterConfig(null).setMergePolicy(NoMergePolicy.INSTANCE);
        for (int i = 1; i <= numDocs; i++) {
        for (int i = 0; i < 2; i++) {
        IndexWriterConfig iwc = new IndexWriterConfig(null);
import org.apache.lucene.document.SortedSetDocValuesField;
import org.opensearch.test.FieldMaskingReader;
        assertEquals(1, perShardOnCache.get());
                Iterator<Accountable> values = cache.values().iterator();
        AtomicInteger perShardOnRemoval = new AtomicInteger();
        IndexWriterConfig iwc = new IndexWriterConfig(null);
                        leafKeys.add(key);
        assertEquals(1, nodeOnRemoval.get());
 * this work for additional information regarding copyright
                doReturn(Collections.<IndicesFieldDataCache.Key>emptyList()).when(cacheSpy).keys();
    public void testCacheFiresPerShardRemovalWhenIdentityUnchanged() throws Exception {
        iwc.setMergePolicy(NoMergePolicy.INSTANCE);
            @Override
        IndicesFieldDataCache nodeCache = new IndicesFieldDataCache(Settings.EMPTY, throwingNode, null, null);
            }
            public void onRemoval(ShardId shardId, String fieldName, boolean wasEvicted, long sizeInBytes) {
import org.apache.lucene.util.Accountable;
        iwc.setMergePolicy(NoMergePolicy.INSTANCE);
        nodeCache.close();
import static org.hamcrest.Matchers.equalTo;
        currentIdentity.set(9999);
        public void clear(String fieldName) {}
        IndexWriterConfig iwc = new IndexWriterConfig(null);
    private class DummyAccountingFieldDataCache implements IndexFieldDataCache {
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
    }
            iw.addDocument(doc);
                while (keys.hasNext() && values.hasNext()) {
                throw new RuntimeException("boom-cache-shard");
            retainedBytes += consumer.load(context).ramBytesUsed();
            public void onRemoval(ShardId shardId, String fieldName, boolean wasEvicted, long sizeInBytes) {
        AtomicInteger perShardOnRemoval = new AtomicInteger();
            iw.commit();
        ir.close();
            @Override
        IndexWriter iw = new IndexWriter(dir, iwc);
import org.opensearch.index.fielddata.plain.AbstractLeafOrdinalsFieldData;
                PagedBytesIndexFieldData fieldData = createPagedBytes("field", fieldCache);
        IndexFieldDataCache fieldCache = nodeCache.buildIndexFieldDataCache(throwingPerShard, index, "field1", shardId -> 1);
            }
import org.apache.lucene.index.DirectoryReader;
                perShardOnRemoval.incrementAndGet();
            }
    }
        ir.close();
        iw.close();
                    }
                        writer.addDocument(doc);
        for (LeafReaderContext context : reader.leaves()) {
            public void onRemoval(ShardId shardId, String fieldName, boolean wasEvicted, long sizeInBytes) {
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
import org.apache.lucene.document.StringField;
        assertEquals(1, perShardOnRemoval.get());
        Directory dir = newDirectory();
            index,
import java.util.Collections;
        iw.close();
            @Override
        }
                assertEquals(0, cache.count());
            }
        ir.close();
    // listener must still fire so node-wide accounting (e.g. circuit breaker) stays consistent.
import org.apache.lucene.document.Field;
                cache.setMaximumWeight(maximumWeight);
        Directory dir = newDirectory();
    public void testReaderCloseInvalidatesGlobalOrdinalsRetainingUnaccountedLeafData() throws Exception {
                throw new RuntimeException("boom-removal-shard");
        pagedBytesIndexFieldData.loadGlobal(ir);
                doCallRealMethod().when(cacheSpy).keys();
        AtomicInteger perShardOnRemoval = new AtomicInteger();
import org.apache.lucene.index.LeafReaderContext;
        dir.close();
        pagedBytesIndexFieldData.loadGlobal(new FieldMaskingReader("field2", ir));
        return new SortedSetOrdinalsIndexFieldData(
        SortedSetOrdinalsIndexFieldData ifd = createSortedDV("field1", fieldCache);
        assertThat(fieldDataCache.cachedGlobally, equalTo(1));
    // The 3-arg buildIndexFieldDataCache overload uses a default resolver that returns
        ifd.loadGlobal(ir);
import org.apache.lucene.store.Directory;
            public void onCache(ShardId shardId, String fieldName, Accountable ramUsage) {
        };
        long retainedBytes = 0;
package org.opensearch.index.fielddata;
    public void testThreeArgBuildUsesNoShardIdentitySentinel() throws Exception {
            }
                assertEquals(1, cache.count());
        };
    private static long retainedLeafBytes(Cache<IndicesFieldDataCache.Key, Accountable> cache, DirectoryReader reader) throws Exception {
            try (
            }
                long maximumWeight = globalBytes + retainedLeafBytes / 2;
                    for (int document = 0; document < 128; document++) {
                // Exact-key reader-close invalidation removes the retaining entry without needing
 * specific language governing permissions and limitations
        iwc.setMergePolicy(NoMergePolicy.INSTANCE);
 * not use this file except in compliance with the License.
        iw.close();
        nodeCache.getCache().invalidateAll();
                fieldData.loadGlobal(reader);
        IndexWriterConfig iwc = new IndexWriterConfig(null);
        Index index = new Index("idx", "_na_");
        IndicesFieldDataCache nodeCache = new IndicesFieldDataCache(Settings.EMPTY, new IndexFieldDataCache.Listener() {
        }
                // Simulate Cache.keys() omitting this entry during its one reader-close cleanup
        DirectoryReader ir = OpenSearchDirectoryReader.wrap(DirectoryReader.open(dir), new ShardId("idx", "_na_", 0));
        IndexOrdinalsFieldData consumer = cachedGlobalOrdinals.newConsumer(reader);
                nodeCacheSpy.clear();
        // Testing PagedBytesIndexFieldData
        public <FD extends LeafFieldData, IFD extends IndexFieldData<FD>> FD load(LeafReaderContext context, IFD indexFieldData)
                cache.refresh();
            return indexFieldData.loadDirect(context);
        DirectoryReader ir = OpenSearchDirectoryReader.wrap(DirectoryReader.open(dir), new ShardId("idx", "_na_", 0));
            @Override
        Index index = new Index("idx", "_na_");
                    IndicesFieldDataCache.Key key = keys.next();
            public void onRemoval(ShardId shardId, String fieldName, boolean wasEvicted, long sizeInBytes) {
import org.apache.lucene.document.Document;
 */
/*
            }
            TextFieldMapper.Defaults.FIELDDATA_MAX_FREQUENCY,
                DirectoryReader reader = OpenSearchDirectoryReader.wrap(DirectoryReader.open(directory), new ShardId("index", "_na_", 0))
    private SortedSetOrdinalsIndexFieldData createSortedDV(String fieldName, IndexFieldDataCache indexFieldDataCache) {
 * GitHub history for details.
            CoreValuesSourceType.BYTES,
        // entry's captured identity (4242) no longer matches → per-shard onRemoval is skipped,
            doc.add(new StringField("field2", String.valueOf(i), Field.Store.NO));
            }
            new NoneCircuitBreakerService(),
        AtomicInteger nodeOnCache = new AtomicInteger();
                }
            @Override
        assertThat(fieldDataCache.cachedGlobally, equalTo(2));
                // therefore could not retry the missed entry on the next pass.
            }
            Document doc = new Document();
            try (IndexWriter writer = new IndexWriter(directory, config)) {
                accountedBytes.addAndGet(ramUsage.ramBytesUsed());
            AbstractLeafOrdinalsFieldData.DEFAULT_SCRIPT_FUNCTION
public class FieldDataCacheTests extends OpenSearchTestCase {
        AtomicInteger perShardOnCache = new AtomicInteger();
 * ownership. Elasticsearch licenses this file to you under
        IndexFieldDataCache.Listener perShardListener = new IndexFieldDataCache.Listener() {
        }
            doc.add(new SortedSetDocValuesField("field1", new BytesRef("v" + i)));
import org.opensearch.index.fielddata.plain.PagedBytesIndexFieldData;
                nodeOnRemoval.incrementAndGet();
                // size pressure or a successful cache scan.
        // 3-arg overload — no shardIdentityResolver supplied
import org.apache.lucene.index.NoMergePolicy;
        @Override
            iw.commit();
        IndexFieldDataCache.Listener perShardListener = new IndexFieldDataCache.Listener() {
                throw new RuntimeException("boom-cache-node");
            fieldName,
        nodeCache.getCache().invalidateAll();
                perShardOnRemoval.incrementAndGet();
/*
        for (int i = 0; i < 2; i++) {
            Document doc = new Document();
        public void clear() {}
        IndexFieldDataCache.Listener throwingNode = new IndexFieldDataCache.Listener() {
    // NO_SHARD_IDENTITY, which means the staleness check always allows per-shard listeners through.
        nodeCache.getCache().invalidateAll();
        sortedSetOrdinalsIndexFieldData.loadGlobal(new FieldMaskingReader("field1", ir));
            public void onCache(ShardId shardId, String fieldName, Accountable ramUsage) {
                doReturn(cacheSpy).when(nodeCacheSpy).getCache();
        // Simulate shard reallocation: the resolver now returns a different identity. The cached
        SortedSetOrdinalsIndexFieldData sortedSetOrdinalsIndexFieldData = createSortedDV("field1", fieldDataCache);
            cachedGlobally++;
 * KIND, either express or implied.  See the License for the
        Directory dir = newDirectory();
        iwc.setMergePolicy(NoMergePolicy.INSTANCE);
 *
        };
        };
    }
                IndexFieldDataCache fieldCache = nodeCache.buildIndexFieldDataCache(new IndexFieldDataCache.Listener() {
        // Without identity tracking, every removal reaches the per-shard listener.
                assertEquals(cache.weight(), accountedBytes.get());
            }
    public void testCacheSkipsStalePerShardRemovalAfterReallocation() throws Exception {
        }
        private int cachedGlobally = 0;
        DirectoryReader ir = OpenSearchDirectoryReader.wrap(DirectoryReader.open(dir), new ShardId("idx", "_na_", 0));
        assertEquals(1, perShardOnRemoval.get());
            nodeCache.close();
    // fires as normal.
        };
        ir.close();
        IndexWriterConfig iwc = new IndexWriterConfig(null);
        iw.close();
        }
        ir.close();
        return retainedBytes;
        IndexFieldDataCache fieldCache = nodeCache.buildIndexFieldDataCache(perShardListener, index, "field1");
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.index.IndexWriterConfig;
        @Override
        Index index = new Index("idx", "_na_");
        nodeCache.close();
        IndicesFieldDataCache nodeCache = new IndicesFieldDataCache(Settings.EMPTY, accountingListener, null, null);
                if (wasEvicted) {
import static org.mockito.Mockito.doReturn;
                assertFalse(keys.hasNext());
    public void testListenerExceptionsAreSwallowedDuringCacheAndRemoval() throws Exception {
            iw.addDocument(doc);
                assertEquals(globalBytes, accountedBytes.get());
    // listeners and the load itself proceed normally.
        );
import org.opensearch.core.index.Index;
 * SPDX-License-Identifier: Apache-2.0
        IndicesFieldDataCache nodeCache = new IndicesFieldDataCache(Settings.EMPTY, nodeListener, null, null);
                }, new Index("index", "_na_"), "field");
        // removal path should also tolerate throwing listeners
            indexFieldDataCache,
        }
        dir.close();
        for (int i = 0; i < 2; i++) {
import static org.mockito.Mockito.spy;
import org.opensearch.indices.fielddata.cache.IndicesFieldDataCache;
                // Two leaf entries and one global-ordinals entry are initially accounted.
/*
        assertThat(fieldDataCache.cachedGlobally, equalTo(2));
                assertEquals(1, cache.count());
                // their fielddata through its segmentAfd references.
                throw new RuntimeException("boom-removal-node");
                        Document doc = new Document();
        Cache<IndicesFieldDataCache.Key, Accountable> cache = nodeCache.getCache();
        IndexFieldDataCache.Listener accountingListener = new IndexFieldDataCache.Listener() {
        ifd.loadGlobal(ir);
        GlobalOrdinalsIndexFieldData cachedGlobalOrdinals = null;
        SortedSetOrdinalsIndexFieldData ifd = createSortedDV("field1", fieldCache);
            iw.addDocument(doc);
            @Override
import java.util.List;
        assertEquals(1, nodeOnCache.get());
            public void onCache(ShardId shardId, String fieldName, Accountable ramUsage) {
        return new PagedBytesIndexFieldData(
            throws Exception {
                }
import static org.mockito.Mockito.doCallRealMethod;
    }
                long retainedLeafBytes = retainedLeafBytes(cache, reader);
        dir.close();
            }
    }
                Iterator<IndicesFieldDataCache.Key> keys = cache.keys().iterator();
            doc.add(new SortedSetDocValuesField("field1", new BytesRef(String.valueOf(i))));
            @Override
            public void onCache(ShardId shardId, String fieldName, Accountable ramUsage) {
        DummyAccountingFieldDataCache fieldDataCache = new DummyAccountingFieldDataCache();
 */
        IndexWriter iw = new IndexWriter(dir, iwc);
                perShardOnCache.incrementAndGet();
import org.opensearch.core.index.shard.ShardId;
}
            Document doc = new Document();
import java.util.concurrent.atomic.AtomicInteger;
                    sizeEvictions.incrementAndGet();
            TextFieldMapper.Defaults.FIELDDATA_MIN_SEGMENT_SIZE
    // when the current resolved identity differs (i.e. shard has been reallocated). The node-level
 * under the License.
        public <FD extends LeafFieldData, IFD extends IndexFieldData.Global<FD>> IFD load(DirectoryReader indexReader, IFD indexFieldData)
        }
            public void onRemoval(ShardId shardId, String fieldName, boolean wasEvicted, long sizeInBytes) {
                perShardOnRemoval.incrementAndGet();
    }
            }
                assertEquals(0, sizeEvictions.get());
            if (value instanceof GlobalOrdinalsIndexFieldData) {
        // load should succeed despite throwing onCache listeners
                assertEquals(2, leafKeys.size());
        AtomicInteger nodeOnRemoval = new AtomicInteger();
                assertEquals(0, accountedBytes.get());
                    }
        }, null, null);
                IndicesFieldDataCache nodeCacheSpy = spy(nodeCache);
            indexFieldDataCache,
        IndicesFieldDataCache nodeCache = new IndicesFieldDataCache(Settings.EMPTY, new IndexFieldDataCache.Listener() {
            }
        nodeCache.getCache().invalidateAll();
        iw.close();
        IndexWriter iw = new IndexWriter(dir, iwc);
                    writer.commit();
            @Override
        }
import java.util.Iterator;
import org.opensearch.index.fielddata.plain.SortedSetOrdinalsIndexFieldData;
    private PagedBytesIndexFieldData createPagedBytes(String fieldName, IndexFieldDataCache indexFieldDataCache) {
            Document doc = new Document();
            Document doc = new Document();
 *
import java.util.ArrayList;
        ifd.loadGlobal(ir);
        try (Directory directory = newDirectory()) {
        };
            iw.commit();
import org.opensearch.common.settings.Settings;
    }
            @Override
                for (int segment = 0; segment < 2; segment++) {
import org.opensearch.test.OpenSearchTestCase;
        for (int i = 0; i < 2; i++) {
    }
        sortedSetOrdinalsIndexFieldData.loadGlobal(ir);
        IndexWriter iw = new IndexWriter(dir, iwc);
            perShardListener,
            }
            "field1",
        Directory dir = newDirectory();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            public void onRemoval(ShardId shardId, String fieldName, boolean wasEvicted, long sizeInBytes) {
 * the Apache License, Version 2.0 (the "License"); you may
        assertNotNull(cachedGlobalOrdinals);
        IndexFieldDataCache.Listener throwingPerShard = new IndexFieldDataCache.Listener() {
                Cache<IndicesFieldDataCache.Key, Accountable> cacheSpy = spy(cache);
            public void onCache(ShardId shardId, String fieldName, Accountable ramUsage) {
            fieldName,
                reader.close();
import org.opensearch.index.mapper.TextFieldMapper;
        for (Accountable value : cache.values()) {
        DirectoryReader ir = OpenSearchDirectoryReader.wrap(DirectoryReader.open(dir), new ShardId("idx", "_na_", 0));
        Directory dir = newDirectory();
        // Two segments so loadGlobal goes through the cache path (single-segment is short-circuited).
import org.opensearch.index.fielddata.ordinals.GlobalOrdinalsIndexFieldData;
    // When listeners throw from onCache/onRemoval, the cache must swallow and log so other
        AtomicInteger sizeEvictions = new AtomicInteger();
                // The cache and its listener now account only for the global ordinal map.
            @Override
 * Unless required by applicable law or agreed to in writing,
                iw.commit();
        Index index = new Index("idx", "_na_");
import java.util.concurrent.atomic.AtomicLong;
            }
        IndexFieldDataCache.Listener perShardListener = new IndexFieldDataCache.Listener() {
                // pass. The old implementation consumed the close marker before this scan and
 *
                assertFalse(values.hasNext());
                assertTrue(globalBytes + retainedLeafBytes > maximumWeight);
                long globalBytes = cache.weight();
        IndexFieldDataCache fieldCache = nodeCache.buildIndexFieldDataCache(perShardListener, index, "field1", shardId -> 4242);
        // Testing SortedSetOrdinalsIndexFieldData:
        dir.close();
        SortedSetOrdinalsIndexFieldData ifd = createSortedDV("field1", fieldCache);
            doc.add(new SortedSetDocValuesField("field1", new BytesRef("v" + i)));
        AtomicLong accountedBytes = new AtomicLong();
        SortedSetOrdinalsIndexFieldData ifd = createSortedDV("field1", fieldCache);
        AtomicInteger currentIdentity = new AtomicInteger(4242);
            public void onRemoval(ShardId shardId, String fieldName, boolean wasEvicted, long sizeInBytes) {
            iw.addDocument(doc);
                break;
 * Licensed to Elasticsearch under one or more contributor
        } finally {
    public void testLoadGlobal_neverCacheIfFieldIsMissing() throws Exception {
            @Override
            if (i % 24 == 0) {
    // When the resolved identity matches the captured identity, the per-shard listener's onRemoval
 * software distributed under the License is distributed on an
        };
                        doc.add(new StringField("field", "value_" + segment + "_" + document, Field.Store.NO));
 * Modifications Copyright OpenSearch Contributors. See
 * The OpenSearch Contributors require contributions made to
        long numDocs = scaledRandomIntBetween(32, 128);
                }
        assertEquals(0, perShardOnRemoval.get());
                // Despite the leaf entries being gone, the cached global entry can still serve
                nodeCacheSpy.clear();
import org.opensearch.common.cache.Cache;
            new NoneCircuitBreakerService(),
            return (IFD) indexFieldData.loadGlobalDirect(indexReader);
            doc.add(new SortedSetDocValuesField("field1", new BytesRef("v" + i)));
            @Override
            iw.addDocument(doc);
 *     http://www.apache.org/licenses/LICENSE-2.0
            doc.add(new SortedSetDocValuesField("field1", new BytesRef("v" + i)));
                    if (values.next() instanceof LeafFieldData) {
 */
        IndexFieldDataCache.Listener nodeListener = new IndexFieldDataCache.Listener() {
        @Override
            TextFieldMapper.Defaults.FIELDDATA_MIN_FREQUENCY,
            iw.commit();
                List<IndicesFieldDataCache.Key> leafKeys = new ArrayList<>();
 * You may obtain a copy of the License at
 * compatible open source license.
        assertThat(fieldDataCache.cachedGlobally, equalTo(1));
        nodeCache.close();
        }
    }
                accountedBytes.addAndGet(-sizeInBytes);
        ifd.loadGlobal(ir);
                assertEquals(0, sizeEvictions.get());
        // but the node-level onRemoval still fires.
        dir.close();
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
        @Override
        PagedBytesIndexFieldData pagedBytesIndexFieldData = createPagedBytes("field2", fieldDataCache);
            throws Exception {
        );
 * this file be licensed under the Apache-2.0 license or a
    }
import org.apache.lucene.index.IndexWriter;
        }, null, null);
                leafKeys.forEach(cache::invalidate);
