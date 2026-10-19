/*  
/*  
@PublicApi(since = "1.0.0")  
    public void onRemoval(long sizeInBytes) {
    public void onCached(long sizeInBytes) {  
import org.opensearch.core.index.shard.ShardId;  
import org.opensearch.common.metrics.CounterMetric;
 * Licensed to Elasticsearch under one or more contributor  
 *
 * software distributed under the License is distributed on an
    }
public class ShardBitsetFilterCache extends AbstractIndexShardComponent {
    }
 * not use this file except in compliance with the License.
        return totalMetric.count();  
 */  
 */
    public ShardBitsetFilterCache(ShardId shardId, IndexSettings indexSettings) {
    private final CounterMetric totalMetric = new CounterMetric();  
 * GitHub history for details.
 *  
import org.opensearch.index.shard.AbstractIndexShardComponent;
/**
 * this work for additional information regarding copyright
        totalMetric.dec(sizeInBytes);
    }
 * the Apache License, Version 2.0 (the "License"); you may
}  
 * The OpenSearch Contributors require contributions made to  
        super(shardId, indexSettings);  
    }  
 * KIND, either express or implied.  See the License for the
/*
 * ownership. Elasticsearch licenses this file to you under  
 * Bitset Filter Cache for shards
package org.opensearch.index.cache.bitset;
 * You may obtain a copy of the License at  
import org.opensearch.index.IndexSettings;
        totalMetric.inc(sizeInBytes);
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.annotation.PublicApi;
 * under the License.  
 *
 * @opensearch.api
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
 *  
 * Unless required by applicable law or agreed to in writing,
    public long getMemorySizeInBytes() {
 */
 * compatible open source license.
 */  
