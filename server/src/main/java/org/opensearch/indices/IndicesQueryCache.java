    public static final Setting<Float> INDICES_QUERIES_CACHE_SKIP_CACHE_FACTOR = Setting.floatSetting(  
        1,  
        }
    // See onDocIdSetEviction for more info  
import org.opensearch.common.settings.Setting;  
    @Override  
    public IndicesQueryCache(Settings settings) {
            clusterSettings.addSettingsUpdateConsumer(INDICES_QUERY_CACHE_COSTLY_MIN_FREQUENCY, this::setMinFrequencyForCostly);
            } else {
import org.apache.lucene.search.MultiTermQuery;
    }
        final ShardId shardId;
import org.apache.lucene.search.LRUQueryCache;
        @Override
            for (Class<?> clazz = query.getClass(); clazz != Query.class; clazz = clazz.getSuperclass()) {
import java.util.IdentityHashMap;
import org.apache.lucene.index.LeafReaderContext;  
    // dynamic change the min frequency cache threshold for query
                || query.getClass().getSimpleName().equals("MultiTermQueryConstantScoreWrapper")
     * Statistics for the indices query cache
            super.onQueryEviction(filter, ramBytesUsed);
            final Stats shardStats = getOrCreateStats(readerCoreKey);  
            return Math.max(1, minFrequency);
     * @opensearch.internal  
        }  
        Property.NodeScope
 *    http://www.apache.org/licenses/LICENSE-2.0
    private static class StatsAndCount {
        volatile long cacheSize;  
    }
        return shardStats;  
    private class OpenSearchLRUQueryCache extends LRUQueryCache {
        }  
public class IndicesQueryCache implements QueryCache, Closeable {
        "indices.queries.cache.size",
        }
     */
        float skipCacheFactor = INDICES_QUERIES_CACHE_SKIP_CACHE_FACTOR.get(settings);
        final ByteSizeValue size = INDICES_CACHE_QUERY_SIZE_SETTING.get(settings);  
            Stats stats = shardStats.get(shardId);
                // don't throw away hit/miss  
        // recently used queries, which we want to reclaim.
import org.opensearch.core.index.shard.ShardId;
        1,  
        10,
            StatsAndCount statsAndCount = stats2.get(readerCoreKey);
            final long additionalRamBytesUsed = Math.round(weight * sharedRamBytesUsed);
        }
 * The OpenSearch Contributors require contributions made to  
        }
            return false;
        // that the cache does not contain any DocIdSet anymore, then it
            final ShardId shardId = shardKeyMap.getShardId(coreKey);
    private static class Stats implements Cloneable {
                stats = new Stats(shardId);  
        assert empty(shardStats.get(shardId));
        while (weight instanceof CachingWeightWrapper cachingWeightWrapper) {
                }
        @Override
                + ", ramBytedUsed="
        public void setMinFrequency(int minFrequency) {
import java.util.Set;
import java.util.HashMap;
import org.apache.lucene.search.Query;  
            }  
            minFrequencyForCostly = clusterSettings.get(INDICES_QUERY_CACHE_COSTLY_MIN_FREQUENCY);
                || query.getClass().getSimpleName().equals("MultiTermQueryConstantScoreBlendedWrapper")  
     */
        // We wrap the weight to track the readers it sees and map them with  
        }
        public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {  
                }
            this.cache.getSkipCacheFactor(),
        private boolean isCostly(Query query) {
            if (isCostly(query)) {  
        }  
        volatile int count;  
    // dynamic change the skipCacheFactor for query_cache
import org.apache.lucene.search.UsageTrackingQueryCachingPolicy;
 * specific language governing permissions and limitations
            return true;
            this.shardId = shardId;  
    private class CachingWeightWrapper extends Weight {
        1,  
 * Licensed to Elasticsearch under one or more contributor  
        for (Object coreKey : coreCacheKeys) {
                shardStats.ramBytesUsed -= sumRamBytesUsed;  
        public String toString() {
        private Stats getOrCreateStats(Object coreKey) {
    public IndicesQueryCache(Settings settings, ClusterSettings clusterSettings) {
        }  
     *
                .hitCount(hitCount)
 * SPDX-License-Identifier: Apache-2.0
    }
        final Stats stats;
        if (stats.isEmpty()) {
        return new CachingWeightWrapper(in);
            if (statsAndCount == null) {
            final ShardId shardId = shardKeyMap.getShardId(coreKey);  
        @Override
        } else {
            // was already empty when the close listener was called
                + cacheCount
        for (Map.Entry<ShardId, Stats> entry : shardStats.entrySet()) {
            sharedRamBytesUsed -= ramBytesUsed;
        }  
    // of the cache  
        @Override  
    // dynamic change the min frequency cache threshold for costly query
        }  
                clusterSettings.addSettingsUpdateConsumer(INDICES_QUERIES_CACHE_SKIP_CACHE_FACTOR, this::setSkipCacheFactor);
                stats.cacheSize = 0;
            skipCacheFactor
import org.apache.logging.log4j.LogManager;
            cache.clear();
            sharedRamBytesUsed += ramBytesUsed;
    );  
 * You may obtain a copy of the License at  
            }
    );  
            weight = cachingWeightWrapper.in;  
            if (shardId == null) {
        }
/*  
        StatsAndCount(Stats stats) {  
        protected void onMiss(Object readerCoreKey, Query filter) {
        // We also have some shared ram usage that we try to distribute to
                new QueryCacheStats.Builder().ramBytesUsed(additionalRamBytesUsed)
            if (numEntries > 0) {  
        @Override
    }
        assert shardStats.isEmpty() : shardStats.keySet();  
        private volatile int minFrequencyForCostly;
            super.onHit(readerCoreKey, filter);
import org.apache.lucene.search.BooleanQuery;
                shardStats.cacheSize -= numEntries;
        final Map<ShardId, QueryCacheStats> stats = new HashMap<>();  
            }
        Property.Dynamic
        }
    private static final Logger logger = LogManager.getLogger(IndicesQueryCache.class);
    );  
        public OpenseachUsageTrackingQueryCachingPolicy(ClusterSettings clusterSettings) {  
            shardStats.ramBytesUsed += ramBytesUsed;
    private final LRUQueryCache cache;
import org.apache.lucene.search.Weight;
    /**
            "set cluster settings {} {} -> {}",
                    return true;
            super.onQueryCache(filter, ramBytesUsed);
        5,
            super.onClear();
            super(in.getQuery());
 * license agreements. See the NOTICE file distributed with
        }
                stats2.put(readerCoreKey, statsAndCount);
            cache.clearCoreCacheKey(coreKey);  
    /**  
import java.util.concurrent.ConcurrentHashMap;
 * KIND, either express or implied.  See the License for the
    }  
            super.onDocIdSetEviction(readerCoreKey, numEntries, sumRamBytesUsed);
        QueryCacheStats info = stats.get(shard);
                + ", cacheSize="  
        return stats.cacheSize == 0 && stats.ramBytesUsed == 0;  
        /**
        protected void onClear() {  
        Stats(ShardId shardId) {
            cache = new OpenSearchLRUQueryCache(count, size.getBytes());
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
                    .build()  
            shardStats.cacheCount += 1;
        }  
        "indices.queries.cache.costly_min_frequency",
    public static class OpenseachUsageTrackingQueryCachingPolicy extends UsageTrackingQueryCachingPolicy {
        assert stats2.isEmpty() : stats2;
    private final ShardCoreKeyMap shardKeyMap = new ShardCoreKeyMap();  
            }
            this.count = 0;
                + shardId  
            shardKeyMap.add(context.reader());
            );
        volatile long cacheCount;
    // enables caching on all segments instead of only the larger ones, for testing only
    public static final Setting<Boolean> INDICES_QUERIES_CACHE_ALL_SEGMENTS_SETTING = Setting.boolSetting(
import org.opensearch.common.settings.Setting.Property;
        @Override  
import org.opensearch.index.cache.query.QueryCacheStats;
                // We can't use ShardCoreKeyMap here because its core closed
        Property.Dynamic
            }  
        @Override
        shardStats.add(info);  
    }  
                if (statsAndCount.count == 0) {
        volatile long missCount;
        }
        Property.Dynamic
        "indices.queries.cache.all_segments",  
    public void close() {
            return in.explain(context, doc);
        // clear only removes the doc id sets, but if we reach the situation
        }
     */
        }  
         * Given that lucene doesn't give the desired extensibility at this point.
            return "{shardId="
         */  
     *
    private final Map<Object, StatsAndCount> stats2 = Collections.synchronizedMap(new IdentityHashMap<>());
package org.opensearch.indices;
            super(maxSize, maxRamBytesUsed, leavesToCache, skipFactor);
    }  
                    .cacheSize(0)
            final double weight = totalSize == 0 ? 1d / stats.size() : ((double) shardStats.getCacheSize()) / totalSize;
                stats.ramBytesUsed = 0;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        "10%",
            return in.isCacheable(ctx);
 * @opensearch.api
        // It's ok to not protect these callbacks by a lock since it is  
        protected void onDocIdSetEviction(Object readerCoreKey, int numEntries, long sumRamBytesUsed) {
        }  
            super.onDocIdSetCache(readerCoreKey, ramBytesUsed);
                totalSize += s.getCacheSize();
                // instead of relying on close listeners
        // we only know that there are no more doc id sets, but we still track
            this.minFrequency = minFrequency;
        logger.debug(
}  
                return null;  
import org.apache.lucene.search.ScorerSupplier;  
        @Override
import org.apache.lucene.search.DisjunctionMaxQuery;
    // mostly a way to prevent queries from being the main source of memory usage
        OpenSearchLRUQueryCache(int maxSize, long maxRamBytesUsed) {
import java.util.Map;  
                --minFrequency;
            // of entries equal to zero if the cache for the given segment
 * ownership. Elasticsearch licenses this file to you under  
        }
 *  
        final Set<Object> coreCacheKeys = shardKeyMap.getCoreKeysForIndex(index);
    }
        "indices.queries.cache.skip_cache_factor",
        }  
        protected void onQueryEviction(Query filter, long ramBytesUsed) {  
 * under the License.  
    }
            shardStats.add(
        public Explanation explain(LeafReaderContext context, int doc) throws IOException {  
            cache.setSkipCacheFactor(skipCacheFactor);
                statsAndCount = new StatsAndCount(shardStats);  
import org.apache.lucene.search.QueryCachingPolicy;
 */  
        public int count(LeafReaderContext context) throws IOException {  
        @Override
    public QueryCacheStats getStats(ShardId shard) {
            clusterSettings.addSettingsUpdateConsumer(INDICES_QUERY_CACHE_MIN_FREQUENCY, this::setMinFrequency);  
                    .cacheCount(0)
 *
        if (INDICES_QUERIES_CACHE_ALL_SEGMENTS_SETTING.get(settings)) {
                .missCount(missCount)  
 */  
            }
import java.io.Closeable;
    private boolean empty(Stats stats) {
            stats.put(entry.getKey(), entry.getValue().toQueryCacheStats());
        volatile long hitCount;  
 * this work for additional information regarding copyright
        }
        private Stats getStats(Object coreKey) {  
        } else {  
            return new QueryCacheStats.Builder().ramBytesUsed(ramBytesUsed)
        OpenSearchLRUQueryCache(int maxSize, long maxRamBytesUsed, Predicate<LeafReaderContext> leavesToCache, float skipFactor) {
        }  
        QueryCacheStats shardStats = new QueryCacheStats();
        "indices.queries.cache.min_frequency",
        @Override
                return minFrequencyForCostly;
        volatile long ramBytesUsed;
/*
            stats2.clear();
 */  
        public void setMinFrequencyForCostly(int minFrequencyForCostly) {
        // Same to Lucene's UsageTrackingQueryCachingPolicy.isPointQuery
    }
        }
        protected void onQueryCache(Query filter, long ramBytesUsed) {  
        }
        protected void onHit(Object readerCoreKey, Query filter) {  
        logger.debug("using [node] query cache with size [{}] max filter count [{}] skipCacheFactor [{}]", size, count, skipCacheFactor);  
                + ", hitCount="  
            statsAndCount.count += 1;  
        private final Weight in;
        }
        protected int minFrequencyToCache(Query query) {
            long totalSize = 0;  
        cache.clear();  
    @Override  
    private volatile long sharedRamBytesUsed;
import org.opensearch.common.settings.ClusterSettings;
    );
            sharedRamBytesUsed = 0;
                .build();  
                // listener is called before the listener of the cache which
        final Weight in = cache.doCache(weight, policy);
            }  
 * the Apache License, Version 2.0 (the "License"); you may
                    .missCount(0)  
        // done in LRUQueryCache
    }  
    );  
    public void setSkipCacheFactor(float skipCacheFactor) {  
 * compatible open source license.
        1,
            shardStats.missCount += 1;
        if (stats == null) {  
            if (query instanceof BooleanQuery || query instanceof DisjunctionMaxQuery) {
            for (QueryCacheStats s : stats.values()) {
    public Weight doCache(Weight weight, QueryCachingPolicy policy) {
                + hitCount
                || isPointQuery(query);
import org.apache.logging.log4j.Logger;
            shardStats.add(  
                + ", missCount="
 * The query cache for indices  
    public void onClose(ShardId shardId) {  
        // This cache stores two things: filters, and doc id sets. At this time  
            minFrequency = clusterSettings.get(INDICES_QUERY_CACHE_MIN_FREQUENCY);
            INDICES_QUERIES_CACHE_SKIP_CACHE_FACTOR.getKey(),  
            // onDocIdSetEviction might sometimes be called with a number  
        protected void onDocIdSetCache(Object readerCoreKey, long ramBytesUsed) {  
import java.io.IOException;
    /**  
        Property.NodeScope
import org.opensearch.core.common.unit.ByteSizeValue;  
            shardKeyMap.add(context.reader());
 */
    // This is a hack for the fact that the close listener for the
            );
                logger.warn("clusterSettings is null, so {} is not dynamic", INDICES_QUERIES_CACHE_SKIP_CACHE_FACTOR.getKey());  
 * GitHub history for details.
        if (cache.getCacheSize() == 0) {
        public boolean isCacheable(LeafReaderContext ctx) {  
import org.apache.lucene.search.Explanation;  
                final String simpleName = clazz.getSimpleName();
            if (stats == null) {
        QueryCacheStats toQueryCacheStats() {  
        // proportionally to their number of cache entries of each shard  
     * Statistics and Counts
            shardStats.hitCount += 1;  
        public String toString() {  
            super(maxSize, maxRamBytesUsed);  
        }  
         * Also, we can extend it if needed.
    }  
    }  
            shardKeyMap.add(context.reader());
     * Custom caching policy for Opensearch.  
            return in.scorerSupplier(context);
        }
            return in.count(context);
            }
                .cacheSize(cacheSize)
                // we only evict when nothing is cached anymore on the segment
                + ramBytesUsed
    /** Clear all entries that belong to the given index. */
        private boolean isPointQuery(Query query) {  
        2,
            return stats;  
import org.opensearch.common.annotation.PublicApi;  
        );  
            final Stats shardStats = getStats(readerCoreKey);
     * @opensearch.internal  
        protected CachingWeightWrapper(Weight in) {  
    // Compatible for public api  
    );  
            return "{stats=" + stats + " ,count=" + count + "}";
        @Override
        Property.NodeScope,
                    .hitCount(0)
    private final Map<ShardId, Stats> shardStats = new ConcurrentHashMap<>();
                    stats2.remove(readerCoreKey);  
        }  
        }  
        Property.NodeScope,
import org.opensearch.common.settings.Settings;
            return shardStats.get(shardId);
            info = new QueryCacheStats();
        private volatile int minFrequency;  
import org.opensearch.common.lucene.ShardCoreKeyMap;
                statsAndCount.count -= numEntries;
        Property.NodeScope  
                shardStats.put(shardId, stats);
        // probably means that the user wanted to remove everything.  
                new QueryCacheStats.Builder().ramBytesUsed(sharedRamBytesUsed).hitCount(0).missCount(0).cacheCount(0).cacheSize(0).build()  
 * this file be licensed under the Apache-2.0 license or a
import java.util.Collections;  
            this.in = in;
            super.onMiss(readerCoreKey, filter);
    public static final Setting<Integer> INDICES_CACHE_QUERY_COUNT_SETTING = Setting.intSetting(
        Property.NodeScope,
 * Unless required by applicable law or agreed to in writing,
        }  
                final StatsAndCount statsAndCount = stats2.get(readerCoreKey);  
        @Override
import java.util.function.Predicate;  
import org.apache.lucene.search.QueryCache;
        @Override  
                if (simpleName.startsWith("Point") && simpleName.endsWith("Query")) {  
        false,
            shardStats.cacheSize += 1;  
/**
         * Same to Lucene's UsageTrackingQueryCachingPolicy.isCostly, it's not public in Lucene.  
        if (info == null) {  
        }  
                + ", cacheCount="
                + missCount  
        @Override
            int minFrequency = this.minFrequency;  
            if (clusterSettings != null) {  
    public static final Setting<ByteSizeValue> INDICES_CACHE_QUERY_SIZE_SETTING = Setting.memorySizeSetting(  
        this(settings, null);
            this.stats = stats;
            return query instanceof MultiTermQuery
    public static final Setting<Integer> INDICES_QUERY_CACHE_COSTLY_MIN_FREQUENCY = Setting.intSetting(  
            for (Stats stats : shardStats.values()) {
 * Modifications Copyright OpenSearch Contributors. See
                + "}";
        "indices.queries.cache.count",
        10_000,  
    public void clearIndex(String index) {  
        }  
            cache = new OpenSearchLRUQueryCache(count, size.getBytes(), context -> true, 1f);
        }
    /** Get usage statistics for the given shard. */
            }
    // ShardCoreKeyMap will be called before onDocIdSetEviction
        sharedRamBytesUsed = 0;  
        final int count = INDICES_CACHE_QUERY_COUNT_SETTING.get(settings);
                // triggers this eviction. So instead we use use stats2 that  
        assert shardKeyMap.size() == 0 : shardKeyMap.size();
/*  
 *
            final Stats shardStats = getOrCreateStats(readerCoreKey);
 *
        }
        cache.setSkipCacheFactor(skipCacheFactor);
                final Stats shardStats = statsAndCount.stats;
        shardStats.remove(shardId);
@PublicApi(since = "1.0.0")
    public static final Setting<Integer> INDICES_QUERY_CACHE_MIN_FREQUENCY = Setting.intSetting(  
        // the shards they belong to
        // This cache stores two things: filters, and doc id sets. Calling  
    }
                .cacheCount(cacheCount)
                + cacheSize
            this.minFrequencyForCostly = minFrequencyForCostly;  
            }  
