            }  
import org.opensearch.core.index.shard.ShardId;
/*  
            CounterMetric total = perFieldTotals.get(fieldName);  
/*  
import java.util.Map;
    public void onCache(ShardId shardId, String fieldName, Accountable ramUsage) {
    }
import org.apache.lucene.util.Accountable;
 * SPDX-License-Identifier: Apache-2.0
            fieldTotals = new HashMap<>();
import java.util.concurrent.ConcurrentMap;  
 *  
 * Licensed to Elasticsearch under one or more contributor  
                }  
            CounterMetric prev = perFieldTotals.putIfAbsent(fieldName, total);  
 * Unless required by applicable law or agreed to in writing,
import java.util.HashMap;
 * On heap field data for shards  
 * compatible open source license.
        CounterMetric total = perFieldTotals.get(fieldName);  
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
            evictionsMetric.inc();
 *
 */  
            if (prev != null) {
        totalMetric.inc(ramUsage.ramBytesUsed());
    public FieldDataStats stats(String... fields) {
            if (total != null) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
        return new FieldDataStats.Builder().memorySize(totalMetric.count())  
 * this work for additional information regarding copyright
            total.inc(ramUsage.ramBytesUsed());
        }
            .evictions(evictionsMetric.count())
            for (Map.Entry<String, CounterMetric> entry : perFieldTotals.entrySet()) {  
    @Override
 * Modifications Copyright OpenSearch Contributors. See
        }
    }
            total.inc(ramUsage.ramBytesUsed());
        }
 * the Apache License, Version 2.0 (the "License"); you may
}  
            .build();  
import org.opensearch.common.regex.Regex;
    private final CounterMetric evictionsMetric = new CounterMetric();
    }
        }
 * specific language governing permissions and limitations
        if (sizeInBytes != -1) {  
import org.opensearch.common.FieldMemoryStats;
    public void onRemoval(ShardId shardId, String fieldName, boolean wasEvicted, long sizeInBytes) {
import org.opensearch.common.annotation.PublicApi;  
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
/**
 */
        Map<String, Long> fieldTotals = null;  
                prev.inc(ramUsage.ramBytesUsed());
            total = new CounterMetric();
/*
 * ownership. Elasticsearch licenses this file to you under  
 *
public class ShardFieldData implements IndexFieldDataCache.Listener {
 * KIND, either express or implied.  See the License for the
 */  
        } else {  
            }
        if (CollectionUtils.isEmpty(fields) == false) {
                if (Regex.simpleMatch(fields, entry.getKey())) {
import org.opensearch.common.util.concurrent.ConcurrentCollections;  
    private final ConcurrentMap<String, CounterMetric> perFieldTotals = ConcurrentCollections.newConcurrentMap();  
        if (total != null) {
package org.opensearch.index.fielddata;
import org.opensearch.core.common.util.CollectionUtils;
@PublicApi(since = "1.0.0")
 * GitHub history for details.
    private final CounterMetric totalMetric = new CounterMetric();
            totalMetric.dec(sizeInBytes);
 */  
 * under the License.  
        if (wasEvicted) {  
            .fieldMemoryStats(fieldTotals == null ? null : new FieldMemoryStats(fieldTotals))
import org.opensearch.common.metrics.CounterMetric;
                total.dec(sizeInBytes);
 * @opensearch.api
                    fieldTotals.put(entry.getKey(), entry.getValue().count());
    @Override  
            }  
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
