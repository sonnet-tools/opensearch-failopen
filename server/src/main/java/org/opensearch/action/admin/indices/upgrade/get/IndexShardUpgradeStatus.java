    }  
        }
public class IndexShardUpgradeStatus implements Iterable<ShardUpgradeStatus> {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        long upgradeBytes = 0;
    }
import java.util.Iterator;
    }
import java.util.Arrays;
 * the Apache License, Version 2.0 (the "License"); you may
        for (ShardUpgradeStatus indexShardUpgradeStatus : shards) {  
 * Modifications Copyright OpenSearch Contributors. See
 *
    public ShardUpgradeStatus[] getShards() {
        this.shards = shards;  
    private final ShardId shardId;  
 * Unless required by applicable law or agreed to in writing,
/*  
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
 */  
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
    }  
 * GitHub history for details.
    IndexShardUpgradeStatus(ShardId shardId, ShardUpgradeStatus[] shards) {
 * @opensearch.api
 *     http://www.apache.org/licenses/LICENSE-2.0
/**
            upgradeBytesAncient += indexShardUpgradeStatus.getToUpgradeBytesAncient();  
 * Licensed to Elasticsearch under one or more contributor  
        return upgradeBytesAncient;
        return this.shardId;
/*  
        return shards[i];
 * KIND, either express or implied.  See the License for the
 */
            upgradeBytes += indexShardUpgradeStatus.getToUpgradeBytes();
 */
        long totalBytes = 0;  
    public ShardUpgradeStatus getAt(int i) {
    }
 * ownership. Elasticsearch licenses this file to you under  
    public long getTotalBytes() {
    @Override  
@PublicApi(since = "1.0.0")  
        for (ShardUpgradeStatus indexShardUpgradeStatus : shards) {
    }
 * license agreements. See the NOTICE file distributed with
    public Iterator<ShardUpgradeStatus> iterator() {
    }  
        }  
package org.opensearch.action.admin.indices.upgrade.get;
 * SPDX-License-Identifier: Apache-2.0
 *  
 * Status for an Index Shard Upgrade
    private final ShardUpgradeStatus[] shards;
        long upgradeBytesAncient = 0;
        for (ShardUpgradeStatus indexShardUpgradeStatus : shards) {
            totalBytes += indexShardUpgradeStatus.getTotalBytes();
 *
}
        return totalBytes;
 * under the License.  
 */  
import org.opensearch.core.index.shard.ShardId;
 * compatible open source license.
 *  
 * The OpenSearch Contributors require contributions made to  
        return this.shards;  
        this.shardId = shardId;
    public long getToUpgradeBytes() {
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
    }
        return Arrays.stream(shards).iterator();
        return upgradeBytes;  
import org.opensearch.common.annotation.PublicApi;
    public long getToUpgradeBytesAncient() {  
    public ShardId getShardId() {  
        }
/*
