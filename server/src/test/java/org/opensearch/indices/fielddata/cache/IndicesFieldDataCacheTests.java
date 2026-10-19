 * compatible open source license.
            public void onRemoval(ShardId shardId, String fieldName, boolean wasEvicted, long sizeInBytes) {
import org.opensearch.index.fielddata.IndexFieldDataCache;
                }  
            try (DirectoryReader reader = DirectoryReader.open(writer)) {
        }
     * skipped entry is never revisited and leaks. The promotion is triggered deterministically from
import org.apache.lucene.index.IndexReader;  
package org.opensearch.indices.fielddata.cache;
                fdCache.clear();
                Key tailTargetKey = new Key(targetField1, readerKey, null);
     * cleaner runs. This test fails if the sweep iterates the live {@code Cache#keys()} LRU view and  
import org.apache.lucene.document.Document;
            try (DirectoryReader reader = DirectoryReader.open(writer)) {
            }
                fdCache.getCache().put(new Key(targetField2, readerKey, null), value);
 *
public class IndicesFieldDataCacheTests extends OpenSearchTestCase {  
    /**
import org.opensearch.test.OpenSearchTestCase;
        final IndicesFieldDataCache fdCache = new IndicesFieldDataCache(Settings.EMPTY, new IndexFieldDataCache.Listener() {
                Index target = new Index("target", "target-uuid");
import java.util.concurrent.atomic.AtomicBoolean;  
        try (Directory directory = newDirectory(); IndexWriter writer = new IndexWriter(directory, newIndexWriterConfig())) {  
                // behind the sweep's cursor.
        final AtomicReference<Runnable> onFirstRemoval = new AtomicReference<>();
        final AtomicBoolean hasThrownException = new AtomicBoolean();  
                Accountable value = () -> 10;
                Index other = new Index("other", "other-uuid");
     * change, index close): an entry marked for cleanup is silently skipped when a concurrent cache
                fdCache.clear(target);
        };
    private IndexFieldCache buildIndexFieldCache(IndicesFieldDataCache fdCache, Index index, String fieldName) {
                Key headTargetKey = new Key(targetField2, readerKey, null);  
     * Reproduces the fielddata leak from the clear-index path (clear-cache API, fielddata settings  
                IndexFieldCache targetField2 = buildIndexFieldCache(fdCache, target, "f2");  
        }, index, fieldName);
import org.apache.lucene.store.Directory;
     * hit promotes it to the head of the LRU list after the sweep's cursor has already passed the
                assertEquals(1, fdCache.getCache().count());
                onFirstRemoval.set(() -> fdCache.getCache().get(tailTargetKey));
/*  
                    assertEquals(other, key.indexCache.index);  
import org.apache.lucene.index.DirectoryReader;
                    hook.run();
            writer.addDocument(new Document());
import org.opensearch.indices.fielddata.cache.IndicesFieldDataCache.Key;  
                for (Key key : fdCache.getCache().keysSnapshot()) {
                IndexReader.CacheKey readerKey = reader.leaves().get(0).reader().getCoreCacheHelper().getKey();  
     */
            writer.addDocument(new Document());
            fdCache.close();
            @Override
                assertEquals(1, fdCache.getCache().count());
import java.util.concurrent.atomic.AtomicReference;
    private IndicesFieldDataCache newFieldDataCache(AtomicReference<Runnable> onFirstRemoval) {
import org.opensearch.common.settings.Settings;
            @Override  
        }
    }  
                IndexFieldCache targetField2 = buildIndexFieldCache(fdCache, target, "f2");
                // not-yet-visited target entry, relinking it at the head of the LRU list  
                super.invalidateKey(key);
        return (IndexFieldCache) fdCache.buildIndexFieldDataCache(new IndexFieldDataCache.Listener() {  
            }
        try (Directory directory = newDirectory(); IndexWriter writer = new IndexWriter(directory, newIndexWriterConfig())) {  
                assertTrue(hasThrownException.get());  
                // While the sweep removes its first entry, a concurrent search hits the
                }
import org.opensearch.core.index.Index;
}  
            fdCache.close();
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.index.IndexWriter;
        } finally {  
                fdCache.getCache().put(new Key(targetField1, readerKey, null), value);  
    }  
                Key fillerKey = new Key(otherField, readerKey, null);
    }
                IndexFieldCache targetField1 = buildIndexFieldCache(fdCache, target, "f1");
import org.opensearch.core.index.shard.ShardId;  
import org.apache.lucene.util.Accountable;  
                if (hasThrownException.compareAndSet(false, true)) {
                }
                    throw new UnsupportedOperationException("uh oh!");  
        final IndicesFieldDataCache fdCache = newFieldDataCache(onFirstRemoval);
 * SPDX-License-Identifier: Apache-2.0
                IndexReader.CacheKey readerKey = reader.leaves().get(0).reader().getCoreCacheHelper().getKey();  
 * this file be licensed under the Apache-2.0 license or a
     * the removal listener of the first swept entry, mimicking a search touching the cache while the
                fdCache.getCache().put(headTargetKey, value);  
     * passes with the point-in-time {@code Cache#keysSnapshot()}.
        }, null, null) {
                fdCache.clear(target);  
        }, null, null);
                Index target = new Index("target", "target-uuid");
                IndexFieldCache targetField1 = buildIndexFieldCache(fdCache, target, "f1");  
        } finally {  
                fdCache.getCache().put(fillerKey, value);
                IndexFieldCache otherField = buildIndexFieldCache(fdCache, other, "f1");
            void invalidateKey(Key key) {
import org.opensearch.indices.fielddata.cache.IndicesFieldDataCache.IndexFieldCache;
                // LRU order after insertion, head to tail: headTargetKey, fillerKey, tailTargetKey  
            }  
    }  
 */  
    public void testExceptionWhileRemovingKeyDoesNotAbortSweep() throws Exception {
                fdCache.getCache().put(tailTargetKey, value);
                fdCache.clear();
                Accountable value = () -> 10;
            }
        return new IndicesFieldDataCache(Settings.EMPTY, new IndexFieldDataCache.Listener() {  
                Runnable hook = onFirstRemoval.getAndSet(null);  
     * head. Because {@link IndicesFieldDataCache#clear()} consumes the marks before scanning, the  
    public void testClearIndexIsNotDefeatedByLruPromotionMidSweep() throws Exception {  
                if (hook != null) {
