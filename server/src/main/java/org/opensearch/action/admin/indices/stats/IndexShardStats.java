    public ShardStats[] getShards() {
 *
 * You may obtain a copy of the License at  
 * the Apache License, Version 2.0 (the "License"); you may
public class IndexShardStats implements Iterable<ShardStats>, Writeable {
            }
        out.writeArray(shards);
 * license agreements. See the NOTICE file distributed with
        return Arrays.stream(shards).iterator();
        }
import java.util.Iterator;  
 * compatible open source license.
        return stats;
        return shards;
 */  
        if (total != null) {
 * under the License.  
@PublicApi(since = "1.0.0")
    }
            if (shard.getShardRouting().primary()) {  
        this.shards = shards;  
    private CommonStats total = null;
        CommonStats stats = new CommonStats();
 * Modifications Copyright OpenSearch Contributors. See
/*  
        shards = in.readArray(ShardStats::new, ShardStats[]::new);
    }  
/*
            return primary;
import org.opensearch.core.common.io.stream.Writeable;
 *     http://www.apache.org/licenses/LICENSE-2.0
        }  
 * GitHub history for details.
 */  
 * IndexShardStats for OpenSearch  
    public ShardId getShardId() {  
    }
 * not use this file except in compliance with the License.
/*  
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
    }  
    public CommonStats getTotal() {
 * software distributed under the License is distributed on an
        return stats;
        for (ShardStats shard : shards) {
        }  
import org.opensearch.core.common.io.stream.StreamInput;
package org.opensearch.action.admin.indices.stats;
        for (ShardStats shard : shards) {  
import org.opensearch.common.annotation.PublicApi;
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
            stats.add(shard.getStats());
 * @opensearch.api
import java.io.IOException;
/**
        shardId.writeTo(out);
    }
    public IndexShardStats(StreamInput in) throws IOException {
    }
 * ownership. Elasticsearch licenses this file to you under  
        return this.shardId;
import org.opensearch.core.index.shard.ShardId;
 * this work for additional information regarding copyright
 *  
    }
    private CommonStats primary = null;
 *
    @Override
 * this file be licensed under the Apache-2.0 license or a
 *
    @Override  
}
        return shards[position];  
        total = stats;  
    private final ShardId shardId;
import org.opensearch.core.common.io.stream.StreamOutput;  
    }  
        if (primary != null) {
    public ShardStats getAt(int position) {
 * specific language governing permissions and limitations
            return total;  
                stats.add(shard.getStats());
        }
    public Iterator<ShardStats> iterator() {
        primary = stats;
        shardId = new ShardId(in);  
import java.util.Arrays;
    private final ShardStats[] shards;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        CommonStats stats = new CommonStats();
 */  
        this.shardId = shardId;
    public void writeTo(StreamOutput out) throws IOException {  
 */
    public CommonStats getPrimary() {  
    }  
    public IndexShardStats(ShardId shardId, ShardStats[] shards) {
 * SPDX-License-Identifier: Apache-2.0
