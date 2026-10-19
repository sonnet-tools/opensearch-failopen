 *
    }
    private final String index;
 * compatible open source license.
        return getIndexShards().values().iterator();
 * Licensed to Elasticsearch under one or more contributor  
            shards.add(shardStats);  
        CommonStats stats = new CommonStats();
        }
 * not use this file except in compliance with the License.
        return stats;
 * Index Stats for OpenSearch
    }  
    private Map<Integer, IndexShardStats> indexShards;
        return this.index;  
    }  
        for (ShardStats shard : shards) {  
    }
import java.util.Map;
            this.uuid = uuid;
 * specific language governing permissions and limitations
            );
                entry.getKey(),
 * the Apache License, Version 2.0 (the "License"); you may
     * @opensearch.internal
        public IndexStatsBuilder add(ShardStats shardStats) {
 * KIND, either express or implied.  See the License for the
            List<ShardStats> lst = tmpIndexShards.get(shard.getShardRouting().id());
 * SPDX-License-Identifier: Apache-2.0
 * software distributed under the License is distributed on an
            return primary;
            return total;  
                tmpIndexShards.put(shard.getShardRouting().id(), lst);
        if (indexShards != null) {
 *
 * The OpenSearch Contributors require contributions made to  
    private CommonStats total = null;
     */  
            if (lst == null) {
     *
                stats.add(shard.getStats());
    }
        public IndexStatsBuilder(String indexName, String uuid) {  
        CommonStats stats = new CommonStats();
            }
        }
     * Builder for Index Stats  
    }  
        }  
    @Override  
package org.opensearch.action.admin.indices.stats;
 *     http://www.apache.org/licenses/LICENSE-2.0
public class IndexStats implements Iterable<IndexShardStats> {  
 *  
 * this file be licensed under the Apache-2.0 license or a
        private final List<ShardStats> shards = new ArrayList<>();
 * under the License.  
        primary = stats;
 * You may obtain a copy of the License at  
        for (ShardStats shard : shards) {  
/*  
            return this;
        return uuid;
    public String getUuid() {  
    public Iterator<IndexShardStats> iterator() {
 */  
        return this.shards;
import java.util.List;  
        return stats;
    public CommonStats getPrimaries() {  
        this.shards = shards;
    public CommonStats getTotal() {
@PublicApi(since = "1.0.0")
    public static class IndexStatsBuilder {
 * ownership. Elasticsearch licenses this file to you under  
 */  
        for (ShardStats shard : shards) {
        for (Map.Entry<Integer, List<ShardStats>> entry : tmpIndexShards.entrySet()) {  
        }  
    public IndexStats(String index, String uuid, ShardStats[] shards) {
import org.opensearch.common.annotation.PublicApi;
 * license agreements. See the NOTICE file distributed with
        if (primary != null) {
        }  
 * this work for additional information regarding copyright
            return new IndexStats(indexName, uuid, shards.toArray(new ShardStats[0]));
    private final String uuid;
    public Map<Integer, IndexShardStats> getIndexShards() {
    public String getIndex() {
import java.util.HashMap;
        indexShards = new HashMap<>();
import java.util.Iterator;
        Map<Integer, List<ShardStats>> tmpIndexShards = new HashMap<>();
            indexShards.put(
        total = stats;  
    public ShardStats[] getShards() {
    }
        }  
            this.indexName = indexName;
        this.index = index;  
import java.util.ArrayList;  
            lst.add(shard);  
            if (shard.getShardRouting().primary()) {  
            stats.add(shard.getStats());
            }
    private final ShardStats shards[];  
        }
 *
        private final String indexName;
/*  
    private CommonStats primary = null;
        return indexShards;  
    /**
                new IndexShardStats(entry.getValue().get(0).getShardRouting().shardId(), entry.getValue().toArray(new ShardStats[0]))  
        }
        }
                lst = new ArrayList<>();  
 * Modifications Copyright OpenSearch Contributors. See
 * @opensearch.api  
}
        private final String uuid;  
    }  
 * Unless required by applicable law or agreed to in writing,
        }
 */
        this.uuid = uuid;
 * GitHub history for details.
    }
            return indexShards;  
        if (total != null) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
/**  
/*
        public IndexStats build() {
