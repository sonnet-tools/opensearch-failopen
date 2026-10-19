 * specific language governing permissions and limitations
 *  
            }  
 * You may obtain a copy of the License at  
                tmpIndexShards.put(shard.getShardRouting().id(), lst);
        return indexShards.values().iterator();
 * List of Index Segments
    }
            if (lst == null) {  
 * the Apache License, Version 2.0 (the "License"); you may
        }
 * compatible open source license.
import java.util.List;  
 *
 * Licensed to Elasticsearch under one or more contributor  
/*  
 * The OpenSearch Contributors require contributions made to  
import java.util.Map;
 */  
@PublicApi(since = "1.0.0")
        return this.index;
 * under the License.  
package org.opensearch.action.admin.indices.segments;
import java.util.ArrayList;  
            );
}
/**  
            lst.add(shard);
 * Unless required by applicable law or agreed to in writing,
                lst = new ArrayList<>();
 *
 * this file be licensed under the Apache-2.0 license or a
 */
 * Modifications Copyright OpenSearch Contributors. See
 * not use this file except in compliance with the License.
        this.index = index;
/*  
    }
 * license agreements. See the NOTICE file distributed with
                new IndexShardSegments(entry.getValue().get(0).getShardRouting().shardId(), entry.getValue().toArray(new ShardSegments[0]))
 * KIND, either express or implied.  See the License for the
    }
     * A shard id to index shard segments map (note, index shard segments is the replication shard group that maps
 * SPDX-License-Identifier: Apache-2.0
    public Map<Integer, IndexShardSegments> getShards() {
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.annotation.PublicApi;
 * software distributed under the License is distributed on an
 */
    private final String index;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Map<Integer, List<ShardSegments>> tmpIndexShards = new HashMap<>();  
public class IndexSegments implements Iterable<IndexShardSegments> {  
 * @opensearch.api  
        for (Map.Entry<Integer, List<ShardSegments>> entry : tmpIndexShards.entrySet()) {
                entry.getKey(),  
 * GitHub history for details.
    private final Map<Integer, IndexShardSegments> indexShards;
import java.util.HashMap;
    IndexSegments(String index, ShardSegments[] shards) {  
        for (ShardSegments shard : shards) {
        return this.indexShards;  
    }  
     * to the shard id).  
     */
 * this work for additional information regarding copyright
/*
    public String getIndex() {  
            List<ShardSegments> lst = tmpIndexShards.get(shard.getShardRouting().id());
 */  
            indexShards.put(
    public Iterator<IndexShardSegments> iterator() {
 * ownership. Elasticsearch licenses this file to you under  
    /**
import java.util.Iterator;
        indexShards = new HashMap<>();  
        }  
 *
    @Override  
