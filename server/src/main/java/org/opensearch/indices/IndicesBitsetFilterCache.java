    public static final Setting<Boolean> INDEX_LOAD_RANDOM_ACCESS_FILTERS_EAGERLY_SETTING = Setting.boolSetting(
import org.apache.lucene.search.IndexSearcher;
        }
import org.opensearch.common.settings.Settings;
            };
 *
                            }  
            return "random_access(" + query + ")";
    }  
        }  
                                        filterToWarm,  
                        try {
                            final long start = System.nanoTime();
                            if (parentObjectMapper != null && parentObjectMapper.nested().isNested()) {
                return TerminationHandle.NO_WAIT;  
import org.opensearch.index.shard.IndexShard;  
    );  
                }
import org.opensearch.index.mapper.ObjectMapper;
 *
        // a no-op to invalidate.
import java.util.Set;
    }
            return 31 * getClass().hashCode() + query.hashCode();
        Set<BitsetCacheKey> keys = keysByReader.remove(ownerCoreCacheKey);
import java.util.concurrent.Executor;  
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;  
        // atomically) and record the key so onClose can invalidate it exactly. The caller holds  
    }
        keysByReader.computeIfAbsent(coreCacheReader, k -> {
import org.opensearch.common.cache.RemovalListener;
        }).bitset;
        }
import org.apache.lucene.index.FilterLeafReader;
import org.opensearch.common.unit.TimeValue;
    }  
            for (BitsetCacheKey key : keys) {
    @Override
    public void onRemoval(RemovalNotification<BitsetCacheKey, Value> notification) {  
 */  
                                .logger()  
        }
    final class QueryWrapperBitSetProducer implements BitSetProducer {  
 */  
        public BitSet getBitSet(LeafReaderContext context) throws IOException {
                    }
            } catch (ExecutionException e) {
            Value value = new Value(bitSet, shardId, listener);
                }  
     * registration would leave the entry with no cleanup path. A registered key whose entry was
        }
                public void onCache(ShardId shardId, Accountable accountable) {
    }
        throws ExecutionException {
                    executor.execute(() -> {  
    public BitSetProducer getBitSetProducer(Query query, BitsetFilterCache.Listener listener) {
    static class BitsetWeigher implements ToLongBiFunction<BitsetCacheKey, Value> {
                            indexShard.warmerService()
        }
import org.opensearch.index.cache.bitset.BitsetFilterCache;
            final MapperService mapperService = indexShard.mapperService();
                    if (shardId != null && accountable != null) {  
        public BitsetCacheKey(IndexReader.CacheKey readerCacheKey, Query query) {
            // Build a listener that routes stats to the correct shard.
     * exact keys when the reader closes. Keys are only removed on reader close: trimming on
    public IndexWarmer.Listener createListener(ThreadPool threadPool) {
            return ConcurrentCollections.newConcurrentSet();
    public IndicesBitsetFilterCache(Settings settings) {
        Value value = notification.getValue();
                            ObjectMapper parentObjectMapper = objectMapper.getParentObjectMapper(mapperService);  
                    });
        }
            }  
                                    );
        final Weight weight = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1f);
        CacheBuilder<BitsetCacheKey, Value> cacheBuilder = CacheBuilder.<BitsetCacheKey, Value>builder().removalListener(this);  
            return () -> latch.await();
        public long applyAsLong(BitsetCacheKey key, Value value) {  
    public Cache<BitsetCacheKey, Value> getCache() {
                        if (objectMapper.nested().isNested()) {
import org.apache.lucene.index.IndexReader;  
        public String toString() {
        final ShardId shardId;  
import org.opensearch.index.IndexWarmer.TerminationHandle;
                                    .trace(
import java.util.concurrent.ExecutionException;
        RemovalListener<IndicesBitsetFilterCache.BitsetCacheKey, IndicesBitsetFilterCache.Value>,
            this.query = Objects.requireNonNull(query);  
                                warmUp.add(parentObjectMapper.nestedTypeFilter());
        }  
            try {
            final BitSet bitSet = bitsetFromQuery(query, context);
        }
        this.cache = cacheBuilder.build();
import org.opensearch.common.cache.Cache;
import org.apache.lucene.search.Weight;
        Closeable {  
    public void onClose(IndexReader.CacheKey ownerCoreCacheKey) {  
            final Set<Query> warmUp = new HashSet<>();
    }
import org.opensearch.common.lucene.search.Queries;
                return getAndLoadIfNotPresent(query, context, listener);  
                            getAndLoadIfNotPresent(filterToWarm, ctx, listener);  
        @Override  
            this.bitset = bitset;
import org.apache.lucene.util.Accountable;
        }
        // Register the closed listener at most once per reader (the mapping function runs
            long weight = (value.bitset != null) ? value.bitset.ramBytesUsed() : 0;
    public static final class BitsetCacheKey {  
        public IndexWarmer.TerminationHandle warmReader(final IndexShard indexShard, final OpenSearchDirectoryReader reader) {
        BitSetProducerWarmer(ThreadPool threadPool) {
     * @opensearch.internal  
                                indexShard.warmerService()
import org.opensearch.common.cache.CacheBuilder;  
            if (!(o instanceof BitsetCacheKey other)) return false;  
        // sweep: a reader closes only once, and exact-key invalidation is O(#queries cached for
                        }
import org.apache.logging.log4j.message.ParameterizedMessage;
        "index.load_fixed_bitset_filters_eagerly",  
                    }
    implements  
    }
import org.apache.lucene.search.Scorer;
        }).add(cacheKey);
import org.opensearch.core.index.shard.ShardId;
        }
        return cache;  
        if (cacheHelper == null) {
     */
     * Composite key combining a reader segment key with a query.
        Value(BitSet bitset, ShardId shardId, BitsetFilterCache.Listener listener) {  
            this.listener = Objects.requireNonNull(listener);  
    public void clear() {  
            final CountDownLatch latch = new CountDownLatch(reader.leaves().size() * warmUp.size());  
            throw new IllegalArgumentException("Reader " + context.reader() + " does not support caching");
        public boolean equals(Object o) {  
    public void close() {
}  
            if (!indexShard.indexSettings().getValue(INDEX_LOAD_RANDOM_ACCESS_FILTERS_EAGERLY_SETTING)) {
        cache.invalidateAll();
                public void onRemoval(ShardId shardId, Accountable accountable) {
        @Override  
import org.apache.lucene.index.LeafReaderContext;
            return null;
            if (this == o) return true;
            }  
    final class BitSetProducerWarmer implements IndexWarmer.Listener {
import org.opensearch.index.IndexWarmer;  
import org.opensearch.index.shard.ShardUtils;
import java.io.IOException;
public class IndicesBitsetFilterCache
        }  
        private final Executor executor;  
import org.opensearch.core.common.unit.ByteSizeValue;
        public boolean equals(Object o) {
import org.opensearch.common.annotation.ExperimentalApi;
import org.apache.lucene.search.ScoreMode;  
        if (keys != null) {  
        QueryWrapperBitSetProducer(Query query, BitsetFilterCache.Listener listener) {
        Scorer s = weight.scorer(context);
        // the reader), so there is no need to batch it. A key whose entry was already evicted is  
                @Override  
import java.util.concurrent.ConcurrentMap;  
    }
    /**
        final IndexReader.CacheKey coreCacheReader = cacheHelper.getKey();
            if (hasNested) {  
        if (s == null) {  
    );  
                                    .logger()  
     */
        @Override  
            listener.onCache(shardId, value.bitset);  
 * The OpenSearch Contributors require contributions made to  
        @Override
        value.listener.onRemoval(value.shardId, value.bitset);
                        indexShard.shardBitsetFilterCache().onRemoval(accountable.ramBytesUsed());
                        }
        final ShardId shardId = ShardUtils.extractShardId(context.reader());
import org.opensearch.common.settings.Setting;
        Property.NodeScope
import org.opensearch.common.cache.RemovalNotification;
            boolean hasNested = false;  
            if (docMapper != null) {
        return new BitSetProducerWarmer(threadPool);  
                            latch.countDown();  
        final Query query;
 * SPDX-License-Identifier: Apache-2.0
            }
                }  
/*  
    @ExperimentalApi  
                        } catch (Exception e) {
import org.opensearch.index.mapper.DocumentMapper;  
import org.opensearch.threadpool.ThreadPool;
        }  
        final IndexReader.CacheHelper cacheHelper = FilterLeafReader.unwrap(context.reader()).getCoreCacheHelper();  
                                        "warmed bitset for [{}], took [{}]",
            cacheBuilder.setMaximumWeight(sizeInBytes).weigher(new BitsetWeigher());
            cacheHelper.addClosedListener(this);  
        }  
        if (sizeInBytes > 0) {
    public static final Setting<ByteSizeValue> INDICES_BITSET_FILTER_CACHE_SIZE_SETTING = Setting.memorySizeSetting(
        searcher.setQueryCache(null);  
import org.opensearch.common.util.concurrent.ConcurrentCollections;  
import java.util.HashSet;  
import java.util.concurrent.CountDownLatch;
            return;  
        final BitsetCacheKey cacheKey = new BitsetCacheKey(coreCacheReader, query);
                cache.invalidate(key);
 * this file be licensed under the Apache-2.0 license or a
     * evicted costs two references, is bounded by the reader's lifetime, and invalidating it on
            if (!(o instanceof QueryWrapperBitSetProducer other)) return false;
                    hasNested = true;  
import org.opensearch.ExceptionsHelper;  
            this.executor = threadPool.executor(ThreadPool.Names.WARMER);  
import java.io.Closeable;
            this.query = Objects.requireNonNull(query);
import org.opensearch.common.settings.Setting.Property;  
                    }
            return 31 * System.identityHashCode(readerCacheKey) + query.hashCode();  
        IndexReader.ClosedListener,
        @Override
        final Query query;
            return readerCacheKey == other.readerCacheKey && query.equals(other.query);
        public int hashCode() {
    @Override
                if (docMapper.hasNestedObjects()) {
@ExperimentalApi
        "5%",
 * Node-level cache for {@link BitSet} based filters. Manages a single flat cache shared across
     * @opensearch.internal
 * all indices on the node, with a configurable size limit. Entries for a reader are invalidated
                @Override
import org.apache.lucene.search.join.BitSetProducer;  
    }  
 * @opensearch.api
    }
     *
                }  
            return BitSet.of(s.iterator(), context.reader().maxDoc());  
    @Override
            DocumentMapper docMapper = mapperService.documentMapper();  
            final BitsetFilterCache.Listener listener = new BitsetFilterCache.Listener() {
        long sizeInBytes = INDICES_BITSET_FILTER_CACHE_SIZE_SETTING.get(settings).getBytes();
import java.util.function.ToLongBiFunction;
            }
        if (value == null || value.listener == null) {
import org.opensearch.index.mapper.MapperService;
        final IndexSearcher searcher = new IndexSearcher(topLevelContext);
                for (final Query filterToWarm : warmUp) {
                    for (ObjectMapper objectMapper : docMapper.objectMappers().values()) {
        clear();  
            this.shardId = shardId;
    /**  
    }  
        final BitsetFilterCache.Listener listener;
                                .warn(() -> new ParameterizedMessage("failed to load bitset for [{}]", filterToWarm), e);
    /**  
                warmUp.add(Queries.newNonNestedFilter());
     */
import org.apache.lucene.search.Query;
                        indexShard.shardBitsetFilterCache().onCached(accountable.ramBytesUsed());  
        // Invalidate the exact keys synchronously rather than deferring to a periodic cache
    public static final class Value {
        final BitSet bitset;
    }  
        public int hashCode() {  
                        } finally {
            }
                                        TimeValue.timeValueNanos(System.nanoTime() - start)
        "indices.cache.bitset.size",  
        }
    }
        final IndexReaderContext topLevelContext = ReaderUtil.getTopLevelContext(context);
            return this.query.equals(other.query);
        @Override
        final BitsetFilterCache.Listener listener;
     * Cached value holding the bitset, shard identity, and the per-index listener for stats.
import org.apache.lucene.util.BitSet;
        Property.IndexScope
 * by exact key as soon as the reader closes.  
        final IndexReader.CacheKey readerCacheKey;
 * compatible open source license.
        return new QueryWrapperBitSetProducer(query, listener);
    private final ConcurrentMap<IndexReader.CacheKey, Set<BitsetCacheKey>> keysByReader = ConcurrentCollections.newConcurrentMap();
package org.opensearch.indices;
    private final Cache<BitsetCacheKey, Value> cache;
        keysByReader.clear();
import org.apache.lucene.index.IndexReaderContext;
            return weight == 0 ? 1 : weight;
            this.readerCacheKey = Objects.requireNonNull(readerCacheKey);
            this.listener = listener;  
     *  
import java.util.Objects;
                    if (shardId != null && accountable != null) {
                            if (indexShard.warmerService().logger().isTraceEnabled()) {
        @Override  
                            }  
import org.apache.lucene.index.ReaderUtil;  
            }
    }
        // the reader open, so onClose cannot fire before the key is recorded.
        return cache.computeIfAbsent(cacheKey, key -> {  
                throw ExceptionsHelper.convertToOpenSearchException(e);
/**  
            return value;
     * Every key cached for a reader, so {@link #onClose(IndexReader.CacheKey)} can invalidate the
     * close is a no-op.  
            for (final LeafReaderContext ctx : reader.leaves()) {
        }  
        @Override
    public static BitSet bitsetFromQuery(Query query, LeafReaderContext context) throws IOException {  
    }
        }
     * eviction would race with a concurrent reload of the same key re-registering it, and a lost  
    @ExperimentalApi
        true,
    BitSet getAndLoadIfNotPresent(final Query query, final LeafReaderContext context, final BitsetFilterCache.Listener listener)
        } else {
