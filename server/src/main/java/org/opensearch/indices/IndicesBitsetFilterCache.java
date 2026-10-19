import org.opensearch.index.IndexWarmer.TerminationHandle;
        // a no-op to invalidate.
            final CountDownLatch latch = new CountDownLatch(reader.leaves().size() * warmUp.size());
    static class BitsetWeigher implements ToLongBiFunction<BitsetCacheKey, Value> {
    @Override
import org.apache.lucene.util.BitSet;
            Value value = new Value(bitSet, shardId, listener);
        Property.NodeScope
     * @opensearch.internal
import org.opensearch.common.settings.Setting.Property;
        value.listener.onRemoval(value.shardId, value.bitset);
    @ExperimentalApi
 * all indices on the node, with a configurable size limit. Entries for a reader are invalidated
    public static final class Value {
    public static final class BitsetCacheKey {
                            if (parentObjectMapper != null && parentObjectMapper.nested().isNested()) {
import org.apache.lucene.search.Scorer;
     *
        public int hashCode() {
    private final ConcurrentMap<IndexReader.CacheKey, Set<BitsetCacheKey>> keysByReader = ConcurrentCollections.newConcurrentMap();
                        }
    public void close() {
                cache.invalidate(key);
            return this.query.equals(other.query);
            this.listener = Objects.requireNonNull(listener);
        } else {
    /**
        final ShardId shardId;
import org.opensearch.index.shard.ShardUtils;
     * registration would leave the entry with no cleanup path. A registered key whose entry was
                                warmUp.add(parentObjectMapper.nestedTypeFilter());
    }
                }
                        indexShard.shardBitsetFilterCache().onRemoval(accountable.ramBytesUsed());
                        indexShard.shardBitsetFilterCache().onCached(accountable.ramBytesUsed());
        return cache.computeIfAbsent(cacheKey, key -> {
                            indexShard.warmerService()
    }
            if (!(o instanceof QueryWrapperBitSetProducer other)) return false;
import org.apache.logging.log4j.message.ParameterizedMessage;
        @Override
        }).add(cacheKey);
     * eviction would race with a concurrent reload of the same key re-registering it, and a lost
 * @opensearch.api
    @Override
    public static final Setting<Boolean> INDEX_LOAD_RANDOM_ACCESS_FILTERS_EAGERLY_SETTING = Setting.boolSetting(
        }
                    hasNested = true;
        @Override
            final BitsetFilterCache.Listener listener = new BitsetFilterCache.Listener() {
import java.util.concurrent.ExecutionException;
                throw ExceptionsHelper.convertToOpenSearchException(e);
                                        filterToWarm,
import org.opensearch.common.lucene.search.Queries;
        }
        }
 * Node-level cache for {@link BitSet} based filters. Manages a single flat cache shared across
            long weight = (value.bitset != null) ? value.bitset.ramBytesUsed() : 0;
            DocumentMapper docMapper = mapperService.documentMapper();
    }
    }
import org.opensearch.common.cache.RemovalNotification;
                            final long start = System.nanoTime();
import org.apache.lucene.search.Weight;
                            }
        if (value == null || value.listener == null) {
        BitSetProducerWarmer(ThreadPool threadPool) {
import org.opensearch.core.common.unit.ByteSizeValue;
import org.opensearch.threadpool.ThreadPool;
        public IndexWarmer.TerminationHandle warmReader(final IndexShard indexShard, final OpenSearchDirectoryReader reader) {
                                        TimeValue.timeValueNanos(System.nanoTime() - start)
            return 31 * System.identityHashCode(readerCacheKey) + query.hashCode();
        public int hashCode() {
        }
        clear();
                            latch.countDown();
package org.opensearch.indices;
                            }
                        try {
        final IndexReaderContext topLevelContext = ReaderUtil.getTopLevelContext(context);
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
        }
        if (sizeInBytes > 0) {
import org.opensearch.index.mapper.ObjectMapper;
     * Cached value holding the bitset, shard identity, and the per-index listener for stats.
import java.util.concurrent.ConcurrentMap;
import org.opensearch.common.unit.TimeValue;
    private final Cache<BitsetCacheKey, Value> cache;
}
            return BitSet.of(s.iterator(), context.reader().maxDoc());
 * SPDX-License-Identifier: Apache-2.0
    public void onClose(IndexReader.CacheKey ownerCoreCacheKey) {
            }
                            getAndLoadIfNotPresent(filterToWarm, ctx, listener);
                                indexShard.warmerService()
/**
    BitSet getAndLoadIfNotPresent(final Query query, final LeafReaderContext context, final BitsetFilterCache.Listener listener)
                    if (shardId != null && accountable != null) {
     * evicted costs two references, is bounded by the reader's lifetime, and invalidating it on
            for (final LeafReaderContext ctx : reader.leaves()) {
import org.opensearch.common.util.concurrent.ConcurrentCollections;
        final IndexReader.CacheKey coreCacheReader = cacheHelper.getKey();
        Value(BitSet bitset, ShardId shardId, BitsetFilterCache.Listener listener) {
import java.util.concurrent.CountDownLatch;
import org.apache.lucene.search.join.BitSetProducer;
        final IndexSearcher searcher = new IndexSearcher(topLevelContext);
        cache.invalidateAll();
                    if (shardId != null && accountable != null) {
            throw new IllegalArgumentException("Reader " + context.reader() + " does not support caching");
        @Override
        return cache;
import java.util.function.ToLongBiFunction;
        final IndexReader.CacheKey readerCacheKey;
     * close is a no-op.
            if (hasNested) {
        }
import org.apache.lucene.index.FilterLeafReader;
    }
                                    .logger()
        CacheBuilder<BitsetCacheKey, Value> cacheBuilder = CacheBuilder.<BitsetCacheKey, Value>builder().removalListener(this);
        Scorer s = weight.scorer(context);
        }
import java.util.concurrent.Executor;
        RemovalListener<IndicesBitsetFilterCache.BitsetCacheKey, IndicesBitsetFilterCache.Value>,
 *
            }
                                        "warmed bitset for [{}], took [{}]",
        QueryWrapperBitSetProducer(Query query, BitsetFilterCache.Listener listener) {
     */
                    }
            if (this == o) return true;
    }
    }
     * exact keys when the reader closes. Keys are only removed on reader close: trimming on
        }
     * @opensearch.internal
        // sweep: a reader closes only once, and exact-key invalidation is O(#queries cached for
    }
    public static final Setting<ByteSizeValue> INDICES_BITSET_FILTER_CACHE_SIZE_SETTING = Setting.memorySizeSetting(
            return readerCacheKey == other.readerCacheKey && query.equals(other.query);
    public IndicesBitsetFilterCache(Settings settings) {
        final BitsetFilterCache.Listener listener;
                public void onRemoval(ShardId shardId, Accountable accountable) {
 * compatible open source license.
        }
    public void clear() {
import org.opensearch.common.cache.CacheBuilder;
        @Override
        // Invalidate the exact keys synchronously rather than deferring to a periodic cache
import org.apache.lucene.index.IndexReaderContext;
import org.opensearch.index.IndexWarmer;
import org.apache.lucene.search.IndexSearcher;
        "index.load_fixed_bitset_filters_eagerly",
        Value value = notification.getValue();
 *
            if (!indexShard.indexSettings().getValue(INDEX_LOAD_RANDOM_ACCESS_FILTERS_EAGERLY_SETTING)) {
import org.opensearch.core.index.shard.ShardId;
        throws ExecutionException {
        if (keys != null) {
import org.apache.lucene.index.ReaderUtil;
            this.query = Objects.requireNonNull(query);
        }
import java.io.Closeable;
    /**
    public Cache<BitsetCacheKey, Value> getCache() {
            this.executor = threadPool.executor(ThreadPool.Names.WARMER);
 * by exact key as soon as the reader closes.
import org.opensearch.common.settings.Settings;
        "indices.cache.bitset.size",
    @Override
                        } catch (Exception e) {
                            ObjectMapper parentObjectMapper = objectMapper.getParentObjectMapper(mapperService);
        if (cacheHelper == null) {
    final class BitSetProducerWarmer implements IndexWarmer.Listener {
import org.apache.lucene.index.LeafReaderContext;
            for (BitsetCacheKey key : keys) {
            return weight == 0 ? 1 : weight;
    @ExperimentalApi
            if (!(o instanceof BitsetCacheKey other)) return false;
import org.opensearch.index.mapper.DocumentMapper;
                        }
import org.apache.lucene.util.Accountable;
                        } finally {
        @Override
                                .warn(() -> new ParameterizedMessage("failed to load bitset for [{}]", filterToWarm), e);
            this.shardId = shardId;
import org.opensearch.common.cache.RemovalListener;
 * this file be licensed under the Apache-2.0 license or a
        final BitsetFilterCache.Listener listener;
                        if (objectMapper.nested().isNested()) {
public class IndicesBitsetFilterCache
    );
        }).bitset;
            listener.onCache(shardId, value.bitset);
    public static BitSet bitsetFromQuery(Query query, LeafReaderContext context) throws IOException {
        if (s == null) {
            cacheHelper.addClosedListener(this);
            }
            }
            return ConcurrentCollections.newConcurrentSet();
    public IndexWarmer.Listener createListener(ThreadPool threadPool) {
        public String toString() {
            this.readerCacheKey = Objects.requireNonNull(readerCacheKey);
 */
        Set<BitsetCacheKey> keys = keysByReader.remove(ownerCoreCacheKey);
    }
            boolean hasNested = false;
    }
                public void onCache(ShardId shardId, Accountable accountable) {
                for (final Query filterToWarm : warmUp) {
        final ShardId shardId = ShardUtils.extractShardId(context.reader());
                    });
                                .logger()
                                    .trace(
import org.opensearch.index.cache.bitset.BitsetFilterCache;
            return;
import org.opensearch.common.cache.Cache;
        final Weight weight = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1f);
        true,
    }
     */
import org.apache.lucene.search.Query;
                @Override
    /**
 */
                }
        searcher.setQueryCache(null);
    }
        Closeable {
            this.query = Objects.requireNonNull(query);
        final BitsetCacheKey cacheKey = new BitsetCacheKey(coreCacheReader, query);
import org.opensearch.index.mapper.MapperService;
    }
        final IndexReader.CacheHelper cacheHelper = FilterLeafReader.unwrap(context.reader()).getCoreCacheHelper();
        public BitsetCacheKey(IndexReader.CacheKey readerCacheKey, Query query) {
            }
@ExperimentalApi
        }
    }
            // Build a listener that routes stats to the correct shard.
        // the reader open, so onClose cannot fire before the key is recorded.
        long sizeInBytes = INDICES_BITSET_FILTER_CACHE_SIZE_SETTING.get(settings).getBytes();
import java.io.IOException;
import org.opensearch.common.settings.Setting;
                warmUp.add(Queries.newNonNestedFilter());
        return new BitSetProducerWarmer(threadPool);
        @Override
            this.listener = listener;
                }
            final BitSet bitSet = bitsetFromQuery(query, context);
                    }
 * The OpenSearch Contributors require contributions made to
            };
import org.apache.lucene.index.IndexReader;
        // atomically) and record the key so onClose can invalidate it exactly. The caller holds
        @Override
            return "random_access(" + query + ")";
/*
            return value;
        final BitSet bitset;
                                    );
                return TerminationHandle.NO_WAIT;
            return null;
    implements
                    executor.execute(() -> {
        Property.IndexScope
    );
        final Query query;
            } catch (ExecutionException e) {
import org.opensearch.index.shard.IndexShard;
        public boolean equals(Object o) {
            cacheBuilder.setMaximumWeight(sizeInBytes).weigher(new BitsetWeigher());
        keysByReader.clear();
        "5%",
import java.util.Set;
import java.util.HashSet;
        private final Executor executor;
                    }
     */
     *
        public long applyAsLong(BitsetCacheKey key, Value value) {
            if (docMapper != null) {
        }
            this.bitset = bitset;
            final Set<Query> warmUp = new HashSet<>();
    final class QueryWrapperBitSetProducer implements BitSetProducer {
import java.util.Objects;
        return new QueryWrapperBitSetProducer(query, listener);
     * Composite key combining a reader segment key with a query.
        public boolean equals(Object o) {
import org.opensearch.ExceptionsHelper;
        }
                            if (indexShard.warmerService().logger().isTraceEnabled()) {
        keysByReader.computeIfAbsent(coreCacheReader, k -> {
        }
        @Override
     * Every key cached for a reader, so {@link #onClose(IndexReader.CacheKey)} can invalidate the
            try {
        // the reader), so there is no need to batch it. A key whose entry was already evicted is
        public BitSet getBitSet(LeafReaderContext context) throws IOException {
        }
            return 31 * getClass().hashCode() + query.hashCode();
    }
    public void onRemoval(RemovalNotification<BitsetCacheKey, Value> notification) {
            return () -> latch.await();
        }
                }
                return getAndLoadIfNotPresent(query, context, listener);
                    for (ObjectMapper objectMapper : docMapper.objectMappers().values()) {
        IndexReader.ClosedListener,
                if (docMapper.hasNestedObjects()) {
            }
            final MapperService mapperService = indexShard.mapperService();
import org.apache.lucene.search.ScoreMode;
        final Query query;
    public BitSetProducer getBitSetProducer(Query query, BitsetFilterCache.Listener listener) {
                @Override
        this.cache = cacheBuilder.build();
        }
import org.opensearch.common.annotation.ExperimentalApi;
        // Register the closed listener at most once per reader (the mapping function runs
