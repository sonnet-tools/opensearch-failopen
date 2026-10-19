        IndicesFieldDataCache nodeCache = new IndicesFieldDataCache(Settings.EMPTY, nodeListener, null, null);  
            try (
        ifd.loadGlobal(ir);  
        );
        }
        public void clear(String fieldName) {}  
        iw.close();  
                nodeOnRemoval.incrementAndGet();  
    }  
        // Testing PagedBytesIndexFieldData
        ifd.loadGlobal(ir);
        IndexWriter iw = new IndexWriter(dir, iwc);  
    // when the current resolved identity differs (i.e. shard has been reallocated). The node-level  
    }
/*
        };  
        iw.close();
        } finally {  
            Document doc = new Document();
        AtomicInteger perShardOnRemoval = new AtomicInteger();
                    }  
        }
                }  
            @Override
            doc.add(new SortedSetDocValuesField("field1", new BytesRef("v" + i)));  
            indexFieldDataCache,  
                doCallRealMethod().when(cacheSpy).keys();  
 *
                    if (values.next() instanceof LeafFieldData) {
 * You may obtain a copy of the License at  
        IndexFieldDataCache.Listener nodeListener = new IndexFieldDataCache.Listener() {
        SortedSetOrdinalsIndexFieldData sortedSetOrdinalsIndexFieldData = createSortedDV("field1", fieldDataCache);
import org.opensearch.test.OpenSearchTestCase;  
        ir.close();
            @Override
                Iterator<Accountable> values = cache.values().iterator();
import static org.hamcrest.Matchers.equalTo;  
        IndexWriterConfig iwc = new IndexWriterConfig(null);
            @Override
 * this work for additional information regarding copyright
    public void testListenerExceptionsAreSwallowedDuringCacheAndRemoval() throws Exception {
import static org.mockito.Mockito.doReturn;
    public void testCacheSkipsStalePerShardRemovalAfterReallocation() throws Exception {
        pagedBytesIndexFieldData.loadGlobal(new FieldMaskingReader("field2", ir));  
        nodeCache.getCache().invalidateAll();  
        sortedSetOrdinalsIndexFieldData.loadGlobal(ir);  
        IndexFieldDataCache.Listener accountingListener = new IndexFieldDataCache.Listener() {
import static org.mockito.Mockito.spy;  
        }, null, null);  
            @Override
                // therefore could not retry the missed entry on the next pass.
 */
public class FieldDataCacheTests extends OpenSearchTestCase {
        assertThat(fieldDataCache.cachedGlobally, equalTo(2));
 * Modifications Copyright OpenSearch Contributors. See
            iw.addDocument(doc);
 *     http://www.apache.org/licenses/LICENSE-2.0
                Iterator<IndicesFieldDataCache.Key> keys = cache.keys().iterator();  
                while (keys.hasNext() && values.hasNext()) {
        AtomicInteger currentIdentity = new AtomicInteger(4242);
        SortedSetOrdinalsIndexFieldData ifd = createSortedDV("field1", fieldCache);
            Document doc = new Document();
                assertEquals(1, cache.count());  
                assertFalse(keys.hasNext());
                        doc.add(new StringField("field", "value_" + segment + "_" + document, Field.Store.NO));
        GlobalOrdinalsIndexFieldData cachedGlobalOrdinals = null;  
        }, null, null);
        nodeCache.getCache().invalidateAll();
        public <FD extends LeafFieldData, IFD extends IndexFieldData<FD>> FD load(LeafReaderContext context, IFD indexFieldData)
        assertEquals(1, nodeOnRemoval.get());  
            iw.addDocument(doc);
        iw.close();
        IndexWriter iw = new IndexWriter(dir, iwc);  
        return retainedBytes;
        Directory dir = newDirectory();  
                cachedGlobalOrdinals = (GlobalOrdinalsIndexFieldData) value;  
        // 3-arg overload — no shardIdentityResolver supplied  
            doc.add(new SortedSetDocValuesField("field1", new BytesRef("v" + i)));  
        SortedSetOrdinalsIndexFieldData ifd = createSortedDV("field1", fieldCache);
import java.util.ArrayList;
                assertFalse(values.hasNext());  
import org.opensearch.index.fielddata.plain.PagedBytesIndexFieldData;  
        pagedBytesIndexFieldData.loadGlobal(ir);
        DirectoryReader ir = OpenSearchDirectoryReader.wrap(DirectoryReader.open(dir), new ShardId("idx", "_na_", 0));  
            public void onRemoval(ShardId shardId, String fieldName, boolean wasEvicted, long sizeInBytes) {
        iwc.setMergePolicy(NoMergePolicy.INSTANCE);
        // removal path should also tolerate throwing listeners
        assertEquals(1, perShardOnCache.get());
                // their fielddata through its segmentAfd references.
        IndexFieldDataCache.Listener throwingPerShard = new IndexFieldDataCache.Listener() {  
                        writer.addDocument(doc);
        @Override
            perShardListener,
        try (Directory directory = newDirectory()) {
                    }  
 * compatible open source license.
        IndexWriter iw = new IndexWriter(dir, iwc);  
            @Override
        ir.close();
import org.apache.lucene.index.LeafReaderContext;
    }
            }
        Index index = new Index("idx", "_na_");
        );
    // When listeners throw from onCache/onRemoval, the cache must swallow and log so other  
        DummyAccountingFieldDataCache fieldDataCache = new DummyAccountingFieldDataCache();  
                for (int segment = 0; segment < 2; segment++) {
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
            @Override  
            nodeCache.close();
        // but the node-level onRemoval still fires.
        Directory dir = newDirectory();  
import org.opensearch.common.settings.Settings;  
        }  
            if (i % 24 == 0) {
                assertEquals(3, cache.count());
            IndexWriterConfig config = new IndexWriterConfig(null).setMergePolicy(NoMergePolicy.INSTANCE);
            index,
 * GitHub history for details.
    // listeners and the load itself proceed normally.
            TextFieldMapper.Defaults.FIELDDATA_MIN_FREQUENCY,
            }  
            @Override  
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
                throw new RuntimeException("boom-cache-shard");  
                        Document doc = new Document();  
        @Override
        IndexOrdinalsFieldData consumer = cachedGlobalOrdinals.newConsumer(reader);  
 * this file be licensed under the Apache-2.0 license or a
import java.util.concurrent.atomic.AtomicLong;
        for (int i = 0; i < 2; i++) {
            fieldName,
    public void testCacheFiresPerShardRemovalWhenIdentityUnchanged() throws Exception {
                perShardOnRemoval.incrementAndGet();
            }  
        // load should succeed despite throwing onCache listeners
        // Two segments so loadGlobal goes through the cache path (single-segment is short-circuited).
            iw.addDocument(doc);
        IndexWriter iw = new IndexWriter(dir, iwc);  
            CoreValuesSourceType.BYTES,
        }
            }
import org.opensearch.index.fielddata.plain.SortedSetOrdinalsIndexFieldData;
        nodeCache.close();  
                break;
        IndexFieldDataCache fieldCache = nodeCache.buildIndexFieldDataCache(perShardListener, index, "field1", shardId -> 4242);
    public void testReaderCloseInvalidatesGlobalOrdinalsRetainingUnaccountedLeafData() throws Exception {
 * not use this file except in compliance with the License.
        };
import org.apache.lucene.store.Directory;
                assertTrue(globalBytes + retainedLeafBytes > maximumWeight);
        Directory dir = newDirectory();
            new NoneCircuitBreakerService(),  
 * SPDX-License-Identifier: Apache-2.0
            iw.addDocument(doc);  
        AtomicInteger perShardOnCache = new AtomicInteger();
        Index index = new Index("idx", "_na_");
        IndexFieldDataCache.Listener perShardListener = new IndexFieldDataCache.Listener() {
            return (IFD) indexFieldData.loadGlobalDirect(indexReader);
        for (int i = 0; i < 2; i++) {
        AtomicInteger nodeOnRemoval = new AtomicInteger();  
            @Override
                assertEquals(0, cache.count());
        }  
                    for (int document = 0; document < 128; document++) {
import org.opensearch.index.mapper.TextFieldMapper;
            }
        iw.close();
        return new SortedSetOrdinalsIndexFieldData(
                accountedBytes.addAndGet(ramUsage.ramBytesUsed());
        IndexFieldDataCache.Listener perShardListener = new IndexFieldDataCache.Listener() {
        iwc.setMergePolicy(NoMergePolicy.INSTANCE);
/*  
        for (int i = 0; i < 2; i++) {  
                throw new RuntimeException("boom-removal-node");  
    // NO_SHARD_IDENTITY, which means the staleness check always allows per-shard listeners through.
    public void testLoadGlobal_neverCacheIfFieldIsMissing() throws Exception {
        IndexWriterConfig iwc = new IndexWriterConfig(null);
import org.opensearch.common.cache.Cache;
            }
        dir.close();
                        leafKeys.add(key);
        PagedBytesIndexFieldData pagedBytesIndexFieldData = createPagedBytes("field2", fieldDataCache);  
        ir.close();  
        );
        }  
/*  
            iw.commit();
import org.apache.lucene.document.Field;
                    IndicesFieldDataCache.Key key = keys.next();  
        Index index = new Index("idx", "_na_");
            CoreValuesSourceType.BYTES,
                assertEquals(0, accountedBytes.get());  
            }
        dir.close();
                nodeCacheSpy.clear();
        assertThat(fieldDataCache.cachedGlobally, equalTo(1));  
 */  
            @Override
        SortedSetOrdinalsIndexFieldData ifd = createSortedDV("field1", fieldCache);  
            iw.commit();  
        sortedSetOrdinalsIndexFieldData.loadGlobal(new FieldMaskingReader("field1", ir));
        };
import org.opensearch.index.fielddata.ordinals.GlobalOrdinalsIndexFieldData;
            indexFieldDataCache,  
        Directory dir = newDirectory();  
        // Simulate shard reallocation: the resolver now returns a different identity. The cached  
 * Licensed to Elasticsearch under one or more contributor  
        };
import org.apache.lucene.document.SortedSetDocValuesField;  
            @Override
import java.util.Collections;  
                assertEquals(0, sizeEvictions.get());
import org.apache.lucene.util.BytesRef;  
                fieldData.loadGlobal(reader);
import java.util.List;
                throw new RuntimeException("boom-removal-shard");
            public void onRemoval(ShardId shardId, String fieldName, boolean wasEvicted, long sizeInBytes) {
        iwc.setMergePolicy(NoMergePolicy.INSTANCE);
    // listener must still fire so node-wide accounting (e.g. circuit breaker) stays consistent.
 * KIND, either express or implied.  See the License for the
        public <FD extends LeafFieldData, IFD extends IndexFieldData.Global<FD>> IFD load(DirectoryReader indexReader, IFD indexFieldData)
                assertEquals(2, leafKeys.size());
        nodeCache.close();  
            @Override
            throws Exception {  
            doc.add(new SortedSetDocValuesField("field1", new BytesRef("v" + i)));
                // Simulate Cache.keys() omitting this entry during its one reader-close cleanup  
                leafKeys.forEach(cache::invalidate);
import java.util.Iterator;
            shardId -> currentIdentity.get()
 */  
        DirectoryReader ir = OpenSearchDirectoryReader.wrap(DirectoryReader.open(dir), new ShardId("idx", "_na_", 0));
            }
                perShardOnRemoval.incrementAndGet();
        for (LeafReaderContext context : reader.leaves()) {
        AtomicInteger nodeOnCache = new AtomicInteger();
import org.opensearch.index.fielddata.plain.AbstractLeafOrdinalsFieldData;
        IndexFieldDataCache fieldCache = nodeCache.buildIndexFieldDataCache(  
 * license agreements. See the NOTICE file distributed with
            }
            AbstractLeafOrdinalsFieldData.DEFAULT_SCRIPT_FUNCTION
        AtomicInteger perShardOnRemoval = new AtomicInteger();  
    private SortedSetOrdinalsIndexFieldData createSortedDV(String fieldName, IndexFieldDataCache indexFieldDataCache) {
        long numDocs = scaledRandomIntBetween(32, 128);
        dir.close();
            iw.addDocument(doc);
        IndexWriterConfig iwc = new IndexWriterConfig(null);
        nodeCache.getCache().invalidateAll();
        Cache<IndicesFieldDataCache.Key, Accountable> cache = nodeCache.getCache();
        IndicesFieldDataCache nodeCache = new IndicesFieldDataCache(Settings.EMPTY, throwingNode, null, null);  
                }
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.index.shard.ShardId;
            doc.add(new SortedSetDocValuesField("field1", new BytesRef(String.valueOf(i))));
    // fires as normal.  
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;  
            public void onCache(ShardId shardId, String fieldName, Accountable ramUsage) {
        nodeCache.close();  
        IndicesFieldDataCache nodeCache = new IndicesFieldDataCache(Settings.EMPTY, new IndexFieldDataCache.Listener() {
            public void onRemoval(ShardId shardId, String fieldName, boolean wasEvicted, long sizeInBytes) {
        ir.close();  
        IndexFieldDataCache fieldCache = nodeCache.buildIndexFieldDataCache(perShardListener, index, "field1");
        @Override
        IndexWriter iw = new IndexWriter(dir, iwc);
        private int cachedGlobally = 0;
        return new PagedBytesIndexFieldData(  
                // Two leaf entries and one global-ordinals entry are initially accounted.
    private class DummyAccountingFieldDataCache implements IndexFieldDataCache {  
                // Despite the leaf entries being gone, the cached global entry can still serve  
                throw new RuntimeException("boom-cache-node");
        ir.close();
        for (int i = 0; i < 2; i++) {
        @Override
    }
            cachedGlobally++;
import org.apache.lucene.index.IndexWriterConfig;
}  
            TextFieldMapper.Defaults.FIELDDATA_MAX_FREQUENCY,  
        for (int i = 1; i <= numDocs; i++) {  
    private static long retainedLeafBytes(Cache<IndicesFieldDataCache.Key, Accountable> cache, DirectoryReader reader) throws Exception {
        assertNotNull(cachedGlobalOrdinals);
                IndexFieldDataCache fieldCache = nodeCache.buildIndexFieldDataCache(new IndexFieldDataCache.Listener() {
        iwc.setMergePolicy(NoMergePolicy.INSTANCE);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                nodeOnCache.incrementAndGet();
                cache.setMaximumWeight(maximumWeight);
                assertEquals(cache.weight(), accountedBytes.get());  
        IndexWriterConfig iwc = new IndexWriterConfig(null);
            public void onRemoval(ShardId shardId, String fieldName, boolean wasEvicted, long sizeInBytes) {
    }  
import org.apache.lucene.index.DirectoryReader;
        AtomicInteger sizeEvictions = new AtomicInteger();  
        long retainedBytes = 0;
        assertEquals(1, perShardOnRemoval.get());
            Document doc = new Document();
                accountedBytes.addAndGet(-sizeInBytes);  
        IndexWriterConfig iwc = new IndexWriterConfig(null);  
                long maximumWeight = globalBytes + retainedLeafBytes / 2;
            Document doc = new Document();
                perShardOnCache.incrementAndGet();  
            if (value instanceof GlobalOrdinalsIndexFieldData) {
        AtomicInteger perShardOnRemoval = new AtomicInteger();
                    writer.commit();
            }  
 * under the License.  
                nodeCacheSpy.clear();
                // Exact-key reader-close invalidation removes the retaining entry without needing  
        dir.close();
                if (wasEvicted) {
                iw.commit();  
                List<IndicesFieldDataCache.Key> leafKeys = new ArrayList<>();
        DirectoryReader ir = OpenSearchDirectoryReader.wrap(DirectoryReader.open(dir), new ShardId("idx", "_na_", 0));
                doReturn(Collections.<IndicesFieldDataCache.Key>emptyList()).when(cacheSpy).keys();  
        }
                DirectoryReader reader = OpenSearchDirectoryReader.wrap(DirectoryReader.open(directory), new ShardId("index", "_na_", 0))  
        }
                doReturn(cacheSpy).when(nodeCacheSpy).getCache();
            public void onCache(ShardId shardId, String fieldName, Accountable ramUsage) {  
    }  
            }  
        IndicesFieldDataCache nodeCache = new IndicesFieldDataCache(Settings.EMPTY, new IndexFieldDataCache.Listener() {  
import static org.mockito.Mockito.doCallRealMethod;
                // The cache and its listener now account only for the global ordinal map.
                reader.close();
        };
        currentIdentity.set(9999);  
                assertTrue(retainedLeafBytes > 1);  
        IndexFieldDataCache.Listener perShardListener = new IndexFieldDataCache.Listener() {  
            @Override  
import org.opensearch.indices.fielddata.cache.IndicesFieldDataCache;  
        // Testing SortedSetOrdinalsIndexFieldData:
        assertEquals(1, perShardOnRemoval.get());
        assertThat(fieldDataCache.cachedGlobally, equalTo(2));
                assertEquals(1, cache.count());
    // The cache captures shardIdentity at load time and skips the per-shard listener's onRemoval
        // Without identity tracking, every removal reaches the per-shard listener.
 * The OpenSearch Contributors require contributions made to  
            public void onRemoval(ShardId shardId, String fieldName, boolean wasEvicted, long sizeInBytes) {
            TextFieldMapper.Defaults.FIELDDATA_MIN_SEGMENT_SIZE
import java.util.concurrent.atomic.AtomicInteger;  
package org.opensearch.index.fielddata;
        dir.close();
    private PagedBytesIndexFieldData createPagedBytes(String fieldName, IndexFieldDataCache indexFieldDataCache) {
        assertThat(fieldDataCache.cachedGlobally, equalTo(1));
            }
import org.apache.lucene.document.Document;
                cache.refresh();
                PagedBytesIndexFieldData fieldData = createPagedBytes("field", fieldCache);
        // entry's captured identity (4242) no longer matches → per-shard onRemoval is skipped,
                IndicesFieldDataCache nodeCacheSpy = spy(nodeCache);  
    // When the resolved identity matches the captured identity, the per-shard listener's onRemoval
        public void clear() {}  
import org.apache.lucene.index.IndexWriter;  
            }
        Index index = new Index("idx", "_na_");
        DirectoryReader ir = OpenSearchDirectoryReader.wrap(DirectoryReader.open(dir), new ShardId("_index", "_na_", 0));
                assertEquals(0, sizeEvictions.get());
                    sizeEvictions.incrementAndGet();
 *  
        ifd.loadGlobal(ir);
import org.apache.lucene.document.StringField;
            Document doc = new Document();  
    }
 * Unless required by applicable law or agreed to in writing,
            fieldName,
                // size pressure or a successful cache scan.
        IndexFieldDataCache fieldCache = nodeCache.buildIndexFieldDataCache(throwingPerShard, index, "field1", shardId -> 1);
            public void onCache(ShardId shardId, String fieldName, Accountable ramUsage) {  
            iw.commit();
        IndexFieldDataCache.Listener throwingNode = new IndexFieldDataCache.Listener() {
                Cache<IndicesFieldDataCache.Key, Accountable> cacheSpy = spy(cache);
        Directory dir = newDirectory();  
 * software distributed under the License is distributed on an
            retainedBytes += consumer.load(context).ramBytesUsed();  
            throws Exception {  
    }  
 * the Apache License, Version 2.0 (the "License"); you may
            ) {
                }
        };
        SortedSetOrdinalsIndexFieldData ifd = createSortedDV("field1", fieldCache);
        }  
    public void testThreeArgBuildUsesNoShardIdentitySentinel() throws Exception {
            try (IndexWriter writer = new IndexWriter(directory, config)) {  
        iwc.setMergePolicy(NoMergePolicy.INSTANCE);
        assertEquals(1, nodeOnCache.get());  
        nodeCache.getCache().invalidateAll();
        AtomicLong accountedBytes = new AtomicLong();
    // The 3-arg buildIndexFieldDataCache overload uses a default resolver that returns  
            public void onRemoval(ShardId shardId, String fieldName, boolean wasEvicted, long sizeInBytes) {
            }
            public void onCache(ShardId shardId, String fieldName, Accountable ramUsage) {
            doc.add(new SortedSetDocValuesField("field1", new BytesRef("v" + i)));
        IndicesFieldDataCache nodeCache = new IndicesFieldDataCache(Settings.EMPTY, accountingListener, null, null);
import org.apache.lucene.util.Accountable;
            "field1",  
            return indexFieldData.loadDirect(context);
        };
import org.opensearch.test.FieldMaskingReader;
                long globalBytes = cache.weight();  
                long retainedLeafBytes = retainedLeafBytes(cache, reader);
import org.opensearch.core.index.Index;
        ifd.loadGlobal(ir);
            }
import org.apache.lucene.index.NoMergePolicy;  
            public void onRemoval(ShardId shardId, String fieldName, boolean wasEvicted, long sizeInBytes) {  
                assertEquals(globalBytes, accountedBytes.get());
        DirectoryReader ir = OpenSearchDirectoryReader.wrap(DirectoryReader.open(dir), new ShardId("idx", "_na_", 0));
        }
    }  
 * specific language governing permissions and limitations
        iw.close();  
            }
            iw.commit();
            new NoneCircuitBreakerService(),
        nodeCache.close();
                }, new Index("index", "_na_"), "field");  
 *
            doc.add(new StringField("field2", String.valueOf(i), Field.Store.NO));  
            public void onCache(ShardId shardId, String fieldName, Accountable ramUsage) {  
        for (Accountable value : cache.values()) {
        assertEquals(0, perShardOnRemoval.get());
                // pass. The old implementation consumed the close marker before this scan and
    }
                perShardOnRemoval.incrementAndGet();
