 *
        @Override
            if (cache == null) {
    @Override
                    return s;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public static final String FIELDDATA_CACHE_KEY = "index.fielddata.cache";
import java.io.IOException;
 *    http://www.apache.org/licenses/LICENSE-2.0
                    throw new IllegalArgumentException("cache type not supported [" + cacheType + "] for field [" + fieldName + "]");
import org.opensearch.index.mapper.MappedFieldType;
        final String fieldName = fieldType.name();
                    "Exception occurred while clearing index field data cache for index: {}, exception: {}",
        }
     * set listeners.
    private final Map<String, IndexFieldDataCache> fieldDataCaches = new HashMap<>();
    ) {
        if (shardIdentityResolver == null) {
                logger.warn(
            }
                default:
        MappedFieldType fieldType,
 * specific language governing permissions and limitations
                this.clear();
    }
                );
    public <IFD extends IndexFieldData<?>> IFD getForField(
        this.shardIdentityResolver = shardIdentityResolver;
 * KIND, either express or implied.  See the License for the
            throw new IllegalArgumentException("shardIdentityResolver must not be null");
    public synchronized void clear() {
    private volatile IndexFieldDataCache.Listener listener = DEFAULT_NOOP_LISTENER;
 * ownership. Elasticsearch licenses this file to you under
        super(indexSettings);
 * Service for field data (cacheing, etc)
 * Modifications Copyright OpenSearch Contributors. See
                    indexSettings.getIndex().getName(),
            throw new IllegalStateException("can't set listener more than once");
 * under the License.
     * @throws IllegalStateException if the listener is set more than once
    private final CircuitBreakerService circuitBreakerService;
        indicesFieldDataCache.clear(index());
 * this file be licensed under the Apache-2.0 license or a
    }
    /**
import org.opensearch.search.lookup.SearchLookup;
        },
 * compatible open source license.
        IndexFieldData.Builder builder = fieldType.fielddataBuilder(fullyQualifiedIndexName, searchLookup);
        fieldDataCaches.clear();
            cache = fieldDataCaches.get(fieldName);
        }
            switch (s) {
 * Licensed to Elasticsearch under one or more contributor
import java.io.Closeable;
        }
     * Sets the resolver that returns the current shard's {@code System.identityHashCode}
        this.listener = listener;
        public void onRemoval(ShardId shardId, String fieldName, boolean wasEvicted, long sizeInBytes) {}
        IndicesFieldDataCache indicesFieldDataCache,
import org.opensearch.core.index.shard.ShardId;
import java.util.HashMap;
        fieldDataCaches.remove(fieldName);
        threadPool.executor(ThreadPool.Names.GENERIC).execute(() -> {
     * Returns fielddata for the provided field type, given the provided fully qualified index name, while also making
 */
 * the Apache License, Version 2.0 (the "License"); you may
 */
 *
 * You may obtain a copy of the License at
    private final ThreadPool threadPool;
 * not use this file except in compliance with the License.
     * a {@link SearchLookup} supplier available that is required for runtime fields.
    public void close() throws IOException {
     */
    }
                    cache = new IndexFieldDataCache.None();
 * software distributed under the License is distributed on an
    @SuppressWarnings("unchecked")
import org.opensearch.indices.fielddata.cache.IndicesFieldDataCache;
import org.opensearch.common.settings.Setting;
     * (or 0 if none) for a given {@link ShardId}. Captured at cache-load time and used to
        this.circuitBreakerService = circuitBreakerService;
    }
        return (IFD) builder.build(cache, circuitBreakerService);
import org.opensearch.indices.fielddata.cache.IndicesFieldDataCache.Key;
    }
import org.opensearch.index.AbstractIndexComponent;
    }
 * The OpenSearch Contributors require contributions made to
                    ex
        // Clear the field data cache for this index in an async manner
        (s) -> FIELDDATA_CACHE_VALUE_NODE,
 * @opensearch.internal
        });
        indicesFieldDataCache.clear(index(), fieldName);
        this.mapperService = mapperService;
    public void setListener(IndexFieldDataCache.Listener listener) {
        }
        Property.IndexScope
     * skip stale decrements after shard reallocation.
    private final IndicesFieldDataCache indicesFieldDataCache;
 * this work for additional information regarding copyright
import org.opensearch.index.IndexSettings;
 */
    ) {
    public synchronized void clearField(final String fieldName) {
    };
                if (FIELDDATA_CACHE_VALUE_NODE.equals(cacheType)) {
        this.threadPool = threadPool;
import java.util.function.ToIntFunction;
        if (listener == null) {
                    throw new IllegalArgumentException("failed to parse [" + s + "] must be one of [node,none]");
    /**
    /**
        FIELDDATA_CACHE_KEY,
     */
    public IndexFieldDataService(
            } catch (Exception ex) {
    );
import org.opensearch.threadpool.ThreadPool;
        synchronized (this) {
/*
            }
        if (this.listener != DEFAULT_NOOP_LISTENER) {
                fieldDataCaches.put(fieldName, cache);
import org.opensearch.index.mapper.MapperService;
        this.indicesFieldDataCache = indicesFieldDataCache;
            }
 *
/*
            try {
package org.opensearch.index.fielddata;
        public void onCache(ShardId shardId, String fieldName, Accountable ramUsage) {}
        MapperService mapperService,
    private final MapperService mapperService;
import java.util.Map;
    public static final Setting<String> INDEX_FIELDDATA_CACHE_KEY = new Setting<>(
import java.util.function.Supplier;
                } else {
        ThreadPool threadPool
     * Sets a {@link org.opensearch.index.fielddata.IndexFieldDataCache.Listener} passed to each {@link IndexFieldData}
    public static final String FIELDDATA_CACHE_VALUE_NODE = "node";
                }
    public void setShardIdentityResolver(ToIntFunction<ShardId> shardIdentityResolver) {
import org.opensearch.common.settings.Setting.Property;
}
/*
 * Unless required by applicable law or agreed to in writing,
/**
        Supplier<SearchLookup> searchLookup
            throw new IllegalArgumentException("listener must not be null");
 */
 * license agreements. See the NOTICE file distributed with
    private volatile ToIntFunction<ShardId> shardIdentityResolver = shardId -> Key.NO_SHARD_IDENTITY;
    }
import org.opensearch.core.indices.breaker.CircuitBreakerService;
        IndexFieldDataCache cache;
        // Since IndexFieldDataCache implementation is now tied to a single node-level IndicesFieldDataCache, it's safe to clear using that
        @Override
                case "node":
        (s) -> {
        // IndicesFieldDataCache.
 *
                case "none":
    // the below map needs to be modified under a lock
                String cacheType = indexSettings.getValue(INDEX_FIELDDATA_CACHE_KEY);
        String fullyQualifiedIndexName,
 * SPDX-License-Identifier: Apache-2.0
                } else if ("none".equals(cacheType)) {
                    cache = indicesFieldDataCache.buildIndexFieldDataCache(listener, index(), fieldName, shardIdentityResolver);
     */
    private static final IndexFieldDataCache.Listener DEFAULT_NOOP_LISTENER = new IndexFieldDataCache.Listener() {
        CircuitBreakerService circuitBreakerService,
public class IndexFieldDataService extends AbstractIndexComponent implements Closeable {
        IndexSettings indexSettings,
 * GitHub history for details.
     * creation to capture onCache and onRemoval events. Setting a listener on this method will override any previously
import org.apache.lucene.util.Accountable;
