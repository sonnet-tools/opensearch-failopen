import java.io.Closeable;  
    private static final IndexFieldDataCache.Listener DEFAULT_NOOP_LISTENER = new IndexFieldDataCache.Listener() {
            cache = fieldDataCaches.get(fieldName);
    private volatile IndexFieldDataCache.Listener listener = DEFAULT_NOOP_LISTENER;  
public class IndexFieldDataService extends AbstractIndexComponent implements Closeable {  
        if (this.listener != DEFAULT_NOOP_LISTENER) {
    }  
        (s) -> FIELDDATA_CACHE_VALUE_NODE,
/*  
import org.opensearch.index.AbstractIndexComponent;  
import org.opensearch.search.lookup.SearchLookup;  
    public void setListener(IndexFieldDataCache.Listener listener) {
     * a {@link SearchLookup} supplier available that is required for runtime fields.
    /**
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.index.IndexSettings;
        this.indicesFieldDataCache = indicesFieldDataCache;
/*  
}
                if (FIELDDATA_CACHE_VALUE_NODE.equals(cacheType)) {
    public synchronized void clear() {
                }
 * GitHub history for details.
 */  
 * this file be licensed under the Apache-2.0 license or a
        ThreadPool threadPool
            try {  
/**
import java.io.IOException;
        });  
import java.util.HashMap;
            }
        this.mapperService = mapperService;
        }
                this.clear();
     * (or 0 if none) for a given {@link ShardId}. Captured at cache-load time and used to
        CircuitBreakerService circuitBreakerService,  
    /**
    private final CircuitBreakerService circuitBreakerService;
    private volatile ToIntFunction<ShardId> shardIdentityResolver = shardId -> Key.NO_SHARD_IDENTITY;
    @Override
 * software distributed under the License is distributed on an
        Supplier<SearchLookup> searchLookup
import java.util.function.Supplier;
    public void setShardIdentityResolver(ToIntFunction<ShardId> shardIdentityResolver) {
import org.opensearch.threadpool.ThreadPool;
        Property.IndexScope  
 *    http://www.apache.org/licenses/LICENSE-2.0
        String fullyQualifiedIndexName,  
 *  
     * Sets the resolver that returns the current shard's {@code System.identityHashCode}  
package org.opensearch.index.fielddata;
import org.opensearch.indices.fielddata.cache.IndicesFieldDataCache;
 *
    public void close() throws IOException {  
    private final ThreadPool threadPool;  
    public synchronized void clearField(final String fieldName) {  
 * compatible open source license.
                case "node":
/*
        indicesFieldDataCache.clear(index());
    }
    /**
            } catch (Exception ex) {
            throw new IllegalStateException("can't set listener more than once");  
    ) {  
     * Sets a {@link org.opensearch.index.fielddata.IndexFieldDataCache.Listener} passed to each {@link IndexFieldData}
                } else if ("none".equals(cacheType)) {
                    return s;
    };
 *
        IndexSettings indexSettings,
        indicesFieldDataCache.clear(index(), fieldName);
        this.listener = listener;
 */
                    indexSettings.getIndex().getName(),
                String cacheType = indexSettings.getValue(INDEX_FIELDDATA_CACHE_KEY);
                    ex  
        public void onRemoval(ShardId shardId, String fieldName, boolean wasEvicted, long sizeInBytes) {}
            throw new IllegalArgumentException("shardIdentityResolver must not be null");  
import org.opensearch.index.mapper.MappedFieldType;
import org.opensearch.core.index.shard.ShardId;
        this.threadPool = threadPool;
                    "Exception occurred while clearing index field data cache for index: {}, exception: {}",
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at  
     */  
     * @throws IllegalStateException if the listener is set more than once
        threadPool.executor(ThreadPool.Names.GENERIC).execute(() -> {
import org.opensearch.common.settings.Setting;
     */
        // IndicesFieldDataCache.
 * under the License.  
                logger.warn(  
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
    }
                    cache = indicesFieldDataCache.buildIndexFieldDataCache(listener, index(), fieldName, shardIdentityResolver);  
     * Returns fielddata for the provided field type, given the provided fully qualified index name, while also making  
    public static final String FIELDDATA_CACHE_VALUE_NODE = "node";
    }  
    public static final String FIELDDATA_CACHE_KEY = "index.fielddata.cache";
    }  
            }
                    throw new IllegalArgumentException("failed to parse [" + s + "] must be one of [node,none]");  
 *  
 * Service for field data (cacheing, etc)
        @Override  
        IndexFieldDataCache cache;  
 * SPDX-License-Identifier: Apache-2.0
    private final MapperService mapperService;
                    throw new IllegalArgumentException("cache type not supported [" + cacheType + "] for field [" + fieldName + "]");
 * ownership. Elasticsearch licenses this file to you under  
        FIELDDATA_CACHE_KEY,
    );
        super(indexSettings);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.indices.fielddata.cache.IndicesFieldDataCache.Key;
    public IndexFieldDataService(  
            if (cache == null) {  
        },
import java.util.Map;  
import org.opensearch.common.settings.Setting.Property;  
            throw new IllegalArgumentException("listener must not be null");  
        // Clear the field data cache for this index in an async manner
            switch (s) {
 */
    private final Map<String, IndexFieldDataCache> fieldDataCaches = new HashMap<>();  
        IndexFieldData.Builder builder = fieldType.fielddataBuilder(fullyQualifiedIndexName, searchLookup);
import org.apache.lucene.util.Accountable;
    private final IndicesFieldDataCache indicesFieldDataCache;
                default:
            }
                    cache = new IndexFieldDataCache.None();
    // the below map needs to be modified under a lock
    public <IFD extends IndexFieldData<?>> IFD getForField(
        }
 * @opensearch.internal
        this.shardIdentityResolver = shardIdentityResolver;
        @Override  
 * this work for additional information regarding copyright
     * skip stale decrements after shard reallocation.
        return (IFD) builder.build(cache, circuitBreakerService);
                } else {  
     * creation to capture onCache and onRemoval events. Setting a listener on this method will override any previously  
        MappedFieldType fieldType,
        (s) -> {  
        if (shardIdentityResolver == null) {
import org.opensearch.index.mapper.MapperService;  
        synchronized (this) {
        fieldDataCaches.remove(fieldName);
                case "none":  
        }
        MapperService mapperService,
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.indices.breaker.CircuitBreakerService;
                );
        IndicesFieldDataCache indicesFieldDataCache,
        final String fieldName = fieldType.name();  
    }  
 * license agreements. See the NOTICE file distributed with
        this.circuitBreakerService = circuitBreakerService;  
     */  
    ) {
        public void onCache(ShardId shardId, String fieldName, Accountable ramUsage) {}
        // Since IndexFieldDataCache implementation is now tied to a single node-level IndicesFieldDataCache, it's safe to clear using that  
     * set listeners.
    public static final Setting<String> INDEX_FIELDDATA_CACHE_KEY = new Setting<>(  
import java.util.function.ToIntFunction;
        if (listener == null) {
    }
 * Licensed to Elasticsearch under one or more contributor  
    @SuppressWarnings("unchecked")  
 * The OpenSearch Contributors require contributions made to  
        }
                fieldDataCaches.put(fieldName, cache);  
 */  
        fieldDataCaches.clear();  
