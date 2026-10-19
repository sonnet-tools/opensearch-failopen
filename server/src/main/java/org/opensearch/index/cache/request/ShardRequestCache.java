    final CounterMetric evictionsMetric = new CounterMetric();
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at  
    }  
/*  
 * this work for additional information regarding copyright
        if (evicted) {
        if (value != null) {  
 */
            .hitCount(hitCount.count())
 *
 * Tracks the portion of the request cache in use for a particular shard.  
package org.opensearch.index.cache.request;
    public void onMiss() {
 * under the License.  
 * @opensearch.api
                dec,  
    // Functions used to increment size by passing in the size directly, Used now, as we use ICacheKey<Key> in the IndicesRequestCache..
        long dec = keyRamBytesUsed;
import org.apache.lucene.util.Accountable;  
    public void onRemoval(Accountable key, BytesReference value, boolean evicted) {
    // Old functions which increment size by passing in an Accountable. Functional but no longer used.  
import org.apache.logging.log4j.Logger;
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
        totalMetric.inc(key.ramBytesUsed() + value.ramBytesUsed());
            dec += value.ramBytesUsed();
    final CounterMetric hitCount = new CounterMetric();
 *
                    + "go negative. Current memory: {}. This is a bug.",
 */  
            .evictions(evictionsMetric.count())  
public final class ShardRequestCache {
        return new RequestCacheStats.Builder().memorySize(Math.max(0, totalMetric.count()))
        totalMetric.dec(dec);  
    public void onCached(Accountable key, BytesReference value) {
}
            totalMetric.inc(dec);
import org.opensearch.common.metrics.CounterMetric;
    }
    }
        totalMetric.inc(keyRamBytesUsed + value.ramBytesUsed());
 *  
        onRemoval(key.ramBytesUsed(), value, evicted);  
 * Modifications Copyright OpenSearch Contributors. See
/*  
    public RequestCacheStats stats() {
                "Ignoring the operation to deduct memory: {} from RequestStats memory_size metric as it will "
 * Unless required by applicable law or agreed to in writing,
/**
    }
 * software distributed under the License is distributed on an
        }
 * not use this file except in compliance with the License.
    public void onCached(long keyRamBytesUsed, BytesReference value) {  
        missCount.inc();
            logger.warn(  
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.annotation.PublicApi;
        }  
    public void onHit() {  
            .build();  
    }
            );
/*
import org.opensearch.core.common.bytes.BytesReference;  
    final CounterMetric totalMetric = new CounterMetric();  
    }  
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Licensed to Elasticsearch under one or more contributor  
 */  
 *
            .missCount(missCount.count())
 * compatible open source license.
    }
    private static final Logger logger = LogManager.getLogger(ShardRequestCache.class);
        }
 * KIND, either express or implied.  See the License for the
@PublicApi(since = "1.0.0")
        if (totalMetric.count() < 0) {
                totalMetric.count()
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void onRemoval(long keyRamBytesUsed, BytesReference value, boolean evicted) {
        hitCount.inc();
 * the Apache License, Version 2.0 (the "License"); you may
 */  
    final CounterMetric missCount = new CounterMetric();
import org.apache.logging.log4j.LogManager;
 * specific language governing permissions and limitations
            evictionsMetric.inc();  
