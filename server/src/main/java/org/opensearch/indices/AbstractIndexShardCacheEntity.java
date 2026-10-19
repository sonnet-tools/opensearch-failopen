            innerKeyRamBytesUsed = key.key.ramBytesUsed();
}  
        long innerKeyRamBytesUsed = 0;  
    public final void onRemoval(RemovalNotification<ICacheKey<IndicesRequestCache.Key>, BytesReference> notification) {  
import org.opensearch.core.common.bytes.BytesReference;
    @Override
        stats().onHit();  
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.cache.RemovalNotification;
            notification.getRemovalReason() == RemovalReason.EVICTED
 * the Apache License, Version 2.0 (the "License"); you may
/*
    }
    }  
 */  
/*  
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
 * @opensearch.internal
    public final void onHit() {
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/**
        stats().onMiss();
 * specific language governing permissions and limitations
 *
        if (key.key != null) {
     * Get the {@linkplain ShardRequestCache} used to track cache statistics.
        stats().onRemoval(
    private long getRamBytesUsedInKey(ICacheKey<IndicesRequestCache.Key> key) {
package org.opensearch.indices;
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.cache.ICacheKey;
    @Override  
        }  
 */
    }
 * license agreements. See the NOTICE file distributed with
            getRamBytesUsedInKey(notification.getKey()),
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
        );
        return key.ramBytesUsed(innerKeyRamBytesUsed);
     */
import org.opensearch.common.cache.RemovalReason;  
        stats().onCached(getRamBytesUsedInKey(key), value);
    public final void onMiss() {
    @Override
/*  
    }
 * Abstract base class for the an {@link IndexShard} level {@linkplain IndicesRequestCache.CacheEntity}.  
 * Unless required by applicable law or agreed to in writing,
 */  
 *
 * GitHub history for details.
import org.opensearch.index.cache.request.ShardRequestCache;
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
    public final void onCached(ICacheKey<IndicesRequestCache.Key> key, BytesReference value) {  
    /**  
import org.opensearch.index.shard.IndexShard;  
 *  
abstract class AbstractIndexShardCacheEntity implements IndicesRequestCache.CacheEntity {
    protected abstract ShardRequestCache stats();  
    }  
 * The OpenSearch Contributors require contributions made to  
 *
 */  
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
            notification.getValue(),  
 * under the License.  
