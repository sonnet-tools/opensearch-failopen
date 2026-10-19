         * @param shardId the shard id the bitset was cached for. This can be <code>null</code>
    @Override
     * A listener interface that is executed for each onCache / onRemoval event
        final BitSet bitset;
 * specific language governing permissions and limitations
 * GitHub history for details.
    public BitsetFilterCache(IndexSettings indexSettings, IndicesBitsetFilterCache indicesCache, Listener listener) {
import org.opensearch.common.cache.RemovalNotification;
 * software distributed under the License is distributed on an
    }  
        /**
    }
    }
        final ShardId shardId;
        }
        if (indicesCache != null) {
import org.apache.lucene.util.BitDocIdSet;  
         * Called for each cached bitset on the cache event.  
import org.opensearch.index.IndexWarmer;
 * compatible open source license.
    /**
 * license agreements. See the NOTICE file distributed with
import java.io.IOException;  
    }
        // Delegated to node-level cache
        logger.debug("clearing all bitsets because [{}]", reason);
    }
        }
    public BitsetFilterCache(IndexSettings indexSettings, Listener listener) {  
import org.opensearch.common.cache.Cache;  
 */  
        }
package org.opensearch.index.cache.bitset;
 * Unless required by applicable law or agreed to in writing,
 * This is a cache for {@link BitDocIdSet} based filters. Use this cache with care, only components
import org.apache.lucene.search.Query;  
    }  
 * Per-index view into the node-level {@link IndicesBitsetFilterCache}.  
        IndicesBitsetFilterCache.INDEX_LOAD_RANDOM_ACCESS_FILTERS_EAGERLY_SETTING;  
    @PublicApi(since = "1.0.0")  
        public Value(BitSet bitset, ShardId shardId) {
         */
        throw new IllegalStateException("IndicesBitsetFilterCache is not available");
 * ownership. Elasticsearch licenses this file to you under  
        // Per-index close is a no-op; entries are cleaned up by the node-level  
/*  
 */  
 * this work for additional information regarding copyright
        super(indexSettings);
    @Override  
    @Deprecated
 * {@link org.opensearch.index.cache.query.QueryCache} should be used instead.
         * @param accountable the bitsets ram representation
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     *  
 * Licensed to Elasticsearch under one or more contributor  
    @Deprecated
/*  
        this.indicesCache = indicesCache;  
    public void clear(String reason) {
 * KIND, either express or implied.  See the License for the
    private final Listener listener;  
import java.io.Closeable;
        Closeable {
         * @param shardId the shard id the bitset was cached for. This can be <code>null</code>
     * @deprecated Use {@link IndicesBitsetFilterCache#INDEX_LOAD_RANDOM_ACCESS_FILTERS_EAGERLY_SETTING} instead.
        /**  
    implements
     * @opensearch.api
         */  
    public static final class Value {
@PublicApi(since = "1.0.0")  
 * Modifications Copyright OpenSearch Contributors. See
 * that require a filter to be materialized as a {@link BitDocIdSet} and require that it should always  
     * @deprecated Use {@link #BitsetFilterCache(IndexSettings, IndicesBitsetFilterCache, Listener)} instead.  
     * @deprecated The warmer is now created by {@link IndicesBitsetFilterCache#createListener(ThreadPool)}.  
        IndexReader.ClosedListener,  
 * @opensearch.api
    }  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.threadpool.ThreadPool;  
import org.opensearch.common.settings.Setting;  
import org.apache.lucene.index.IndexReader;
    public static BitSet bitsetFromQuery(Query query, LeafReaderContext context) throws IOException {
     */  
     * Value for bitset filter cache  
    @PublicApi(since = "1.0.0")
        if (listener == null) {  
    }
    }
        void onRemoval(ShardId shardId, Accountable accountable);
    public BitSetProducer getBitSetProducer(Query query) {
    @Deprecated
    /**
     *
     */  
    }  
import org.opensearch.index.AbstractIndexComponent;
        }  
    @Override
            this.shardId = shardId;  
        RemovalListener<IndexReader.CacheKey, Cache<Query, BitsetFilterCache.Value>>,
        this(indexSettings, null, listener);
     */
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.index.LeafReaderContext;
 *
    /**
 * <p>
            this.bitset = bitset;
import org.opensearch.indices.IndicesBitsetFilterCache;
        void onCache(ShardId shardId, Accountable accountable);
     * @opensearch.internal
            return indicesCache.getBitSetProducer(query, listener);  
 *  
         * @param accountable the bitsets ram representation  
        return IndicesBitsetFilterCache.bitsetFromQuery(query, context);
 * the Apache License, Version 2.0 (the "License"); you may
        // Per-index clear is a no-op; entries are evicted by the node-level cache.  
/*
    private final IndicesBitsetFilterCache indicesCache;
 * under the License.  
 * You may obtain a copy of the License at  
    public interface Listener {
import org.opensearch.index.IndexSettings;  
import org.apache.lucene.search.join.BitSetProducer;
    public void onRemoval(RemovalNotification<IndexReader.CacheKey, Cache<Query, Value>> notification) {
        this.listener = listener;
    public void onClose(IndexReader.CacheKey ownerCoreCacheKey) {  
            throw new IllegalArgumentException("listener must not be null");
         * Called for each cached bitset on the removal event.
        return null;
     */
    /**
        if (indicesCache != null) {
 * not use this file except in compliance with the License.
 */
import org.apache.lucene.util.BitSet;
    public static final Setting<Boolean> INDEX_LOAD_RANDOM_ACCESS_FILTERS_EAGERLY_SETTING =
 * be around should use this cache, otherwise the
            return indicesCache.createListener(threadPool);
        // periodic stale-key purge after the index's readers close.
/**
import org.opensearch.core.index.shard.ShardId;
 *
        // Delegated to node-level cache
 * The OpenSearch Contributors require contributions made to  
 *  
}
 */
    public IndexWarmer.Listener createListener(ThreadPool threadPool) {  
import org.opensearch.common.cache.RemovalListener;
import org.opensearch.common.annotation.PublicApi;
    public void close() {
public final class BitsetFilterCache extends AbstractIndexComponent
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**
     */
import org.apache.lucene.util.Accountable;
