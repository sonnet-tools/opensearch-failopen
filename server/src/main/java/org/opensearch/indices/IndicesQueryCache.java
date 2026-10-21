        // It's ok to not protect these callbacks by a lock since it is
        QueryCacheStats info = stats.get(shard);
            skipCacheFactor
                + ", ramBytedUsed="
            final long additionalRamBytesUsed = Math.round(weight * sharedRamBytesUsed);
        }
        protected void onHit(Object readerCoreKey, Query filter) {
import org.apache.lucene.search.Query;
import org.apache.lucene.search.BooleanQuery;
        }
                    .missCount(0)
            this.stats = stats;
            this.minFrequency = minFrequency;
                }
        protected void onQueryCache(Query filter, long ramBytesUsed) {
import org.opensearch.common.settings.ClusterSettings;
        } else {
        return new CachingWeightWrapper(in);
package org.opensearch.indices;
    /**
            // was already empty when the close listener was called
        }
        // We wrap the weight to track the readers it sees and map them with
        volatile long cacheSize;
        final ShardId shardId;
            }
        volatile long missCount;
            shardStats.ramBytesUsed += ramBytesUsed;
        }
        if (stats == null) {
        final Stats stats;
import org.apache.lucene.search.MultiTermQuery;
import java.io.IOException;
    }
        volatile long cacheCount;
                stats = new Stats(shardId);
            if (clusterSettings != null) {
            shardStats.missCount += 1;
            return "{stats=" + stats + " ,count=" + count + "}";
        @Override
        private boolean isCostly(Query query) {
    }
        public String toString() {
 */
        final Set<Object> coreCacheKeys = shardKeyMap.getCoreKeysForIndex(index);
    }
                // listener is called before the listener of the cache which
        10,
    public static final Setting<Integer> INDICES_CACHE_QUERY_COUNT_SETTING = Setting.intSetting(
import org.apache.lucene.search.LRUQueryCache;
                .cacheCount(cacheCount)
                    .hitCount(0)
    }
        }
    private boolean empty(Stats stats) {
                new QueryCacheStats.Builder().ramBytesUsed(sharedRamBytesUsed).hitCount(0).missCount(0).cacheCount(0).cacheSize(0).build()
                }
 * specific language governing permissions and limitations
            final ShardId shardId = shardKeyMap.getShardId(coreKey);
            StatsAndCount statsAndCount = stats2.get(readerCoreKey);
                    stats2.remove(readerCoreKey);
    @Override
                + ", missCount="
        }
        @Override
        "10%",
                    .cacheCount(0)
                totalSize += s.getCacheSize();
        @Override
import java.util.concurrent.ConcurrentHashMap;
            if (shardId == null) {
                stats2.put(readerCoreKey, statsAndCount);
 * GitHub history for details.
import java.util.IdentityHashMap;
            return true;
        volatile long ramBytesUsed;
     * Statistics for the indices query cache
        1,
public class IndicesQueryCache implements QueryCache, Closeable {
import java.io.Closeable;
            super.onQueryCache(filter, ramBytesUsed);
    private static class StatsAndCount {
                clusterSettings.addSettingsUpdateConsumer(INDICES_QUERIES_CACHE_SKIP_CACHE_FACTOR, this::setSkipCacheFactor);
    }
        1,
                // We can't use ShardCoreKeyMap here because its core closed
            clusterSettings.addSettingsUpdateConsumer(INDICES_QUERY_CACHE_MIN_FREQUENCY, this::setMinFrequency);
            return new QueryCacheStats.Builder().ramBytesUsed(ramBytesUsed)
                .cacheSize(cacheSize)
        public void setMinFrequencyForCostly(int minFrequencyForCostly) {
        Property.NodeScope
        public int count(LeafReaderContext context) throws IOException {
 * license agreements. See the NOTICE file distributed with
            }
        @Override
    private final LRUQueryCache cache;
            cache.clearCoreCacheKey(coreKey);
            cache = new OpenSearchLRUQueryCache(count, size.getBytes(), context -> true, 1f);
                + missCount
        }
 */
        }
            }
        private Stats getOrCreateStats(Object coreKey) {
 *
                + ", cacheCount="
import org.opensearch.common.lucene.ShardCoreKeyMap;
        "indices.queries.cache.size",
    }
 * under the License.
                + ramBytesUsed
                shardStats.ramBytesUsed -= sumRamBytesUsed;
            final Stats shardStats = getStats(readerCoreKey);
        protected void onDocIdSetCache(Object readerCoreKey, long ramBytesUsed) {
 * KIND, either express or implied.  See the License for the
     * Statistics and Counts
    // Compatible for public api
        }
            }
        @Override
        public OpenseachUsageTrackingQueryCachingPolicy(ClusterSettings clusterSettings) {
        "indices.queries.cache.skip_cache_factor",
        sharedRamBytesUsed = 0;
            return stats;
            // onDocIdSetEviction might sometimes be called with a number
            return in.explain(context, doc);
            cache.setSkipCacheFactor(skipCacheFactor);
            return query instanceof MultiTermQuery
        "indices.queries.cache.min_frequency",
        protected int minFrequencyToCache(Query query) {
        public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {
        );
                + "}";
        }
        10_000,
 * SPDX-License-Identifier: Apache-2.0
        while (weight instanceof CachingWeightWrapper cachingWeightWrapper) {
        @Override
            if (statsAndCount == null) {
    private final Map<ShardId, Stats> shardStats = new ConcurrentHashMap<>();
        }
    // dynamic change the min frequency cache threshold for query
        }
     * @opensearch.internal
    }
        // This cache stores two things: filters, and doc id sets. Calling
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
        if (info == null) {
import org.apache.lucene.search.QueryCache;
    private class CachingWeightWrapper extends Weight {
    );
        }
            sharedRamBytesUsed = 0;
import org.opensearch.core.common.unit.ByteSizeValue;
    // This is a hack for the fact that the close listener for the
         * Given that lucene doesn't give the desired extensibility at this point.
    public static class OpenseachUsageTrackingQueryCachingPolicy extends UsageTrackingQueryCachingPolicy {
import java.util.HashMap;
    private volatile long sharedRamBytesUsed;
                // triggers this eviction. So instead we use use stats2 that
    public Weight doCache(Weight weight, QueryCachingPolicy policy) {
 * The query cache for indices
            shardStats.cacheSize += 1;
            INDICES_QUERIES_CACHE_SKIP_CACHE_FACTOR.getKey(),
                .hitCount(hitCount)
    public IndicesQueryCache(Settings settings, ClusterSettings clusterSettings) {
            );
        assert empty(shardStats.get(shardId));
        StatsAndCount(Stats stats) {
        if (INDICES_QUERIES_CACHE_ALL_SEGMENTS_SETTING.get(settings)) {
                // instead of relying on close listeners
                    return true;
import org.apache.logging.log4j.LogManager;
            super.onDocIdSetCache(readerCoreKey, ramBytesUsed);
         * Same to Lucene's UsageTrackingQueryCachingPolicy.isCostly, it's not public in Lucene.
            }
    }
                + cacheCount
        this(settings, null);
        }
        // proportionally to their number of cache entries of each shard
        protected void onMiss(Object readerCoreKey, Query filter) {
        private volatile int minFrequency;
                new QueryCacheStats.Builder().ramBytesUsed(additionalRamBytesUsed)
import java.util.Map;
import org.apache.lucene.search.UsageTrackingQueryCachingPolicy;
            final ShardId shardId = shardKeyMap.getShardId(coreKey);
        final Weight in = cache.doCache(weight, policy);
            sharedRamBytesUsed += ramBytesUsed;
    public static final Setting<ByteSizeValue> INDICES_CACHE_QUERY_SIZE_SETTING = Setting.memorySizeSetting(
    private final Map<Object, StatsAndCount> stats2 = Collections.synchronizedMap(new IdentityHashMap<>());
            return in.isCacheable(ctx);
 * Modifications Copyright OpenSearch Contributors. See
                || isPointQuery(query);
     *
            cache.clear();
import org.apache.lucene.search.ScorerSupplier;
    private static class Stats implements Cloneable {
    }
        protected void onClear() {
    );
        }
    public IndicesQueryCache(Settings settings) {
                statsAndCount = new StatsAndCount(shardStats);
        Property.NodeScope,
        if (cache.getCacheSize() == 0) {
        @Override
            super.onMiss(readerCoreKey, filter);
        "indices.queries.cache.count",
                shardStats.cacheSize -= numEntries;
        }
        cache.setSkipCacheFactor(skipCacheFactor);
            return shardStats.get(shardId);
        assert shardKeyMap.size() == 0 : shardKeyMap.size();
            shardKeyMap.add(context.reader());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
@PublicApi(since = "1.0.0")
 * Licensed to Elasticsearch under one or more contributor
        private boolean isPointQuery(Query query) {
        shardStats.add(info);
    }
            int minFrequency = this.minFrequency;
            long totalSize = 0;
            super(maxSize, maxRamBytesUsed);
        // the shards they belong to
        volatile long hitCount;
        Property.NodeScope,
            super(maxSize, maxRamBytesUsed, leavesToCache, skipFactor);
        Property.Dynamic
        @Override
/*
            super.onHit(readerCoreKey, filter);
            for (Class<?> clazz = query.getClass(); clazz != Query.class; clazz = clazz.getSuperclass()) {
            return false;
            this.in = in;
    );
        shardStats.remove(shardId);
            stats2.clear();
            if (numEntries > 0) {
        float skipCacheFactor = INDICES_QUERIES_CACHE_SKIP_CACHE_FACTOR.get(settings);
        public void setMinFrequency(int minFrequency) {
/*
import org.apache.lucene.search.Explanation;
 *    http://www.apache.org/licenses/LICENSE-2.0
        QueryCacheStats toQueryCacheStats() {
    );
    private static final Logger logger = LogManager.getLogger(IndicesQueryCache.class);
    // of the cache
        assert stats2.isEmpty() : stats2;
        protected void onQueryEviction(Query filter, long ramBytesUsed) {
            shardKeyMap.add(context.reader());
        // clear only removes the doc id sets, but if we reach the situation
        }
    }
        Property.Dynamic
    // dynamic change the skipCacheFactor for query_cache
            return in.scorerSupplier(context);
        return stats.cacheSize == 0 && stats.ramBytesUsed == 0;
            minFrequencyForCostly = clusterSettings.get(INDICES_QUERY_CACHE_COSTLY_MIN_FREQUENCY);
        for (Object coreKey : coreCacheKeys) {
            super.onQueryEviction(filter, ramBytesUsed);
        @Override
            super.onDocIdSetEviction(readerCoreKey, numEntries, sumRamBytesUsed);
        // recently used queries, which we want to reclaim.
        }
        // we only know that there are no more doc id sets, but we still track
                + hitCount
        // done in LRUQueryCache
            this.count = 0;
            shardStats.cacheCount += 1;
        }
        final Map<ShardId, QueryCacheStats> stats = new HashMap<>();
        assert shardStats.isEmpty() : shardStats.keySet();
        }
        private final Weight in;
            shardStats.hitCount += 1;
    public void close() {
        }
import org.apache.lucene.search.QueryCachingPolicy;
        }
    @Override
        protected CachingWeightWrapper(Weight in) {
        // probably means that the user wanted to remove everything.
            statsAndCount.count += 1;
 *
        Property.NodeScope
    /**
            final Stats shardStats = getOrCreateStats(readerCoreKey);
 *
        // that the cache does not contain any DocIdSet anymore, then it
                logger.warn("clusterSettings is null, so {} is not dynamic", INDICES_QUERIES_CACHE_SKIP_CACHE_FACTOR.getKey());
        final int count = INDICES_CACHE_QUERY_COUNT_SETTING.get(settings);
    public void clearIndex(String index) {
 * not use this file except in compliance with the License.
        Stats(ShardId shardId) {
            stats.put(entry.getKey(), entry.getValue().toQueryCacheStats());
        false,
        1,
}
    /** Get usage statistics for the given shard. */
         */
            shardStats.add(
        // Same to Lucene's UsageTrackingQueryCachingPolicy.isPointQuery
     */
        "indices.queries.cache.all_segments",
import org.apache.lucene.search.Weight;
            this.minFrequencyForCostly = minFrequencyForCostly;
            super(in.getQuery());
    // enables caching on all segments instead of only the larger ones, for testing only
        OpenSearchLRUQueryCache(int maxSize, long maxRamBytesUsed, Predicate<LeafReaderContext> leavesToCache, float skipFactor) {
        OpenSearchLRUQueryCache(int maxSize, long maxRamBytesUsed) {
        }
 * You may obtain a copy of the License at
    /** Clear all entries that belong to the given index. */
            cache = new OpenSearchLRUQueryCache(count, size.getBytes());
            }
        @Override
import org.opensearch.common.annotation.PublicApi;
import org.apache.lucene.index.LeafReaderContext;
        volatile int count;
        Property.Dynamic
    public void onClose(ShardId shardId) {
        @Override
 */
    private final ShardCoreKeyMap shardKeyMap = new ShardCoreKeyMap();
    public void setSkipCacheFactor(float skipCacheFactor) {
import org.opensearch.index.cache.query.QueryCacheStats;
                statsAndCount.count -= numEntries;
                --minFrequency;
            final Stats shardStats = getOrCreateStats(readerCoreKey);
                    .build()
        cache.clear();
        QueryCacheStats shardStats = new QueryCacheStats();
    public static final Setting<Float> INDICES_QUERIES_CACHE_SKIP_CACHE_FACTOR = Setting.floatSetting(
 * The OpenSearch Contributors require contributions made to
            // of entries equal to zero if the cache for the given segment
/*
                || query.getClass().getSimpleName().equals("MultiTermQueryConstantScoreBlendedWrapper")
            for (Stats stats : shardStats.values()) {
            Stats stats = shardStats.get(shardId);
        @Override
                + ", cacheSize="
        }
                if (statsAndCount.count == 0) {
 */
     * Custom caching policy for Opensearch.
        // We also have some shared ram usage that we try to distribute to
        Property.NodeScope,
        return shardStats;
                stats.cacheSize = 0;
    /**
    public static final Setting<Integer> INDICES_QUERY_CACHE_MIN_FREQUENCY = Setting.intSetting(
            } else {
            return "{shardId="
            sharedRamBytesUsed -= ramBytesUsed;
                    .cacheSize(0)
        }
        @Override
                return null;
        1,
 * compatible open source license.
        /**
     */
                + ", hitCount="
                final Stats shardStats = statsAndCount.stats;
        final ByteSizeValue size = INDICES_CACHE_QUERY_SIZE_SETTING.get(settings);
                if (simpleName.startsWith("Point") && simpleName.endsWith("Query")) {
    // dynamic change the min frequency cache threshold for costly query
        } else {
        }
import org.opensearch.core.index.shard.ShardId;
        if (stats.isEmpty()) {
            clusterSettings.addSettingsUpdateConsumer(INDICES_QUERY_CACHE_COSTLY_MIN_FREQUENCY, this::setMinFrequencyForCostly);
            if (stats == null) {
            weight = cachingWeightWrapper.in;
        }
                final String simpleName = clazz.getSimpleName();
            }
            this.cache.getSkipCacheFactor(),
     */
    }
    // ShardCoreKeyMap will be called before onDocIdSetEviction
                // don't throw away hit/miss
            if (isCostly(query)) {
        public Explanation explain(LeafReaderContext context, int doc) throws IOException {
                // we only evict when nothing is cached anymore on the segment
    );
    }
        }
import org.apache.lucene.search.DisjunctionMaxQuery;
    private class OpenSearchLRUQueryCache extends LRUQueryCache {
            );
            for (QueryCacheStats s : stats.values()) {
            }
        }
 *
        2,
import org.opensearch.common.settings.Setting;
                stats.ramBytesUsed = 0;
import java.util.function.Predicate;
import org.opensearch.common.settings.Setting.Property;
            if (query instanceof BooleanQuery || query instanceof DisjunctionMaxQuery) {
        }
 * @opensearch.api
    );
        logger.debug("using [node] query cache with size [{}] max filter count [{}] skipCacheFactor [{}]", size, count, skipCacheFactor);
                shardStats.put(shardId, stats);
            super.onClear();
        @Override
            final double weight = totalSize == 0 ? 1d / stats.size() : ((double) shardStats.getCacheSize()) / totalSize;
        Property.NodeScope
        public String toString() {
    public static final Setting<Integer> INDICES_QUERY_CACHE_COSTLY_MIN_FREQUENCY = Setting.intSetting(
    public QueryCacheStats getStats(ShardId shard) {
            return in.count(context);
        private volatile int minFrequencyForCostly;
            "set cluster settings {} {} -> {}",
    // mostly a way to prevent queries from being the main source of memory usage
            minFrequency = clusterSettings.get(INDICES_QUERY_CACHE_MIN_FREQUENCY);
    // See onDocIdSetEviction for more info
        }
         * Also, we can extend it if needed.
        for (Map.Entry<ShardId, Stats> entry : shardStats.entrySet()) {
                final StatsAndCount statsAndCount = stats2.get(readerCoreKey);
            shardStats.add(
            this.shardId = shardId;
        }
        private Stats getStats(Object coreKey) {
        }
                + cacheSize
import org.apache.logging.log4j.Logger;
                + shardId
     * @opensearch.internal
    }
            return Math.max(1, minFrequency);
    public static final Setting<Boolean> INDICES_QUERIES_CACHE_ALL_SEGMENTS_SETTING = Setting.boolSetting(
        "indices.queries.cache.costly_min_frequency",
        protected void onDocIdSetEviction(Object readerCoreKey, int numEntries, long sumRamBytesUsed) {
        public boolean isCacheable(LeafReaderContext ctx) {
                return minFrequencyForCostly;
        5,
 * software distributed under the License is distributed on an
                || query.getClass().getSimpleName().equals("MultiTermQueryConstantScoreWrapper")
                .build();
        }
        logger.debug(
 * Unless required by applicable law or agreed to in writing,
import java.util.Collections;
            }
            }
 * ownership. Elasticsearch licenses this file to you under
            shardKeyMap.add(context.reader());
        // This cache stores two things: filters, and doc id sets. At this time
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Set;
        }
/**
     *
                .missCount(missCount)
import org.opensearch.common.settings.Settings;
            info = new QueryCacheStats();
