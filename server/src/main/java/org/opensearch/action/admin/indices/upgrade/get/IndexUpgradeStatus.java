            if (lst == null) {  
            }  
            upgradeBytes += indexShardUpgradeStatus.getToUpgradeBytes();
    }
import java.util.Map;
            lst.add(shard);
        for (Map.Entry<Integer, List<ShardUpgradeStatus>> entry : tmpIndexShards.entrySet()) {
        for (IndexShardUpgradeStatus indexShardUpgradeStatus : indexShards.values()) {  
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
            );
    public String getIndex() {  
 * Licensed to Elasticsearch under one or more contributor  
    private final String index;
/*  
    public Iterator<IndexShardUpgradeStatus> iterator() {
        long upgradeBytesAncient = 0;
        return this.index;
            indexShards.put(
                entry.getKey(),  
        for (IndexShardUpgradeStatus indexShardUpgradeStatus : indexShards.values()) {
    private final Map<Integer, IndexShardUpgradeStatus> indexShards;
        long totalBytes = 0;  
import org.opensearch.common.annotation.PublicApi;
    public long getTotalBytes() {
 * @opensearch.api  
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
                tmpIndexShards.put(shard.getShardRouting().id(), lst);
        for (IndexShardUpgradeStatus indexShardUpgradeStatus : indexShards.values()) {
 * not use this file except in compliance with the License.
        }  
     * A shard id to index shard upgrade status map (note, index shard upgrade status is the replication shard group that maps
public class IndexUpgradeStatus implements Iterable<IndexShardUpgradeStatus> {  
            List<ShardUpgradeStatus> lst = tmpIndexShards.get(shard.getShardRouting().id());
        for (ShardUpgradeStatus shard : shards) {
 * GitHub history for details.
        long upgradeBytes = 0;
        indexShards = new HashMap<>();  
     */
                    entry.getValue().toArray(new ShardUpgradeStatus[0])  
 * under the License.  
 * ownership. Elasticsearch licenses this file to you under  
import java.util.HashMap;
                    entry.getValue().get(0).getShardRouting().shardId(),
    public long getToUpgradeBytes() {
 * compatible open source license.
        return upgradeBytesAncient;
 * the Apache License, Version 2.0 (the "License"); you may
        this.index = index;
    }
        return upgradeBytes;  
 * Status for an Index Upgrade
 * Unless required by applicable law or agreed to in writing,
        return totalBytes;
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
 *
/*
            totalBytes += indexShardUpgradeStatus.getTotalBytes();
import java.util.Iterator;
        Map<Integer, List<ShardUpgradeStatus>> tmpIndexShards = new HashMap<>();  
 */
@PublicApi(since = "1.0.0")
    public long getToUpgradeBytesAncient() {  
    public Map<Integer, IndexShardUpgradeStatus> getShards() {
 * SPDX-License-Identifier: Apache-2.0
 */  
    @Override  
import java.util.ArrayList;  
    }  
 *
                lst = new ArrayList<>();
    /**
        }  
                new IndexShardUpgradeStatus(
    }
 * You may obtain a copy of the License at  
import java.util.List;  
        }
            upgradeBytesAncient += indexShardUpgradeStatus.getToUpgradeBytesAncient();  
        return this.indexShards;  
                )
    }
        }
}
/**  
    }
package org.opensearch.action.admin.indices.upgrade.get;
 *  
        return indexShards.values().iterator();
     * to the shard id).  
    IndexUpgradeStatus(String index, ShardUpgradeStatus[] shards) {  
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
 */  
/*  
    }  
 * this file be licensed under the Apache-2.0 license or a
        }
