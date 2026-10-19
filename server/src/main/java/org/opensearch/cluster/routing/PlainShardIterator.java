    public PlainShardIterator(ShardId shardId, List<ShardRouting> shards) {
    }  
     */  
    public int hashCode() {
    public int compareTo(ShardIterator o) {
 * ownership. Elasticsearch licenses this file to you under  
 *
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
    /**  
    public boolean equals(Object o) {  
 *     http://www.apache.org/licenses/LICENSE-2.0
/*
 *
        super(shards);
 * @opensearch.internal  
    @Override
     *  
 *  
    }
public class PlainShardIterator extends PlainShardsIterator implements ShardIterator {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return this.shardId;
        this.shardId = shardId;  
 * KIND, either express or implied.  See the License for the
 * The {@link PlainShardIterator} is a {@link ShardsIterator} which iterates all  
    }
     * this the a given <code>shardId</code>.
     * Creates a {@link PlainShardIterator} instance that iterates over a subset of the given shards
    private final ShardId shardId;
/*  
        ShardIterator that = (ShardIterator) o;  
    @Override  
 * compatible open source license.
    }  
        return shardId.equals(that.shardId());
 * Licensed to Elasticsearch under one or more contributor  
 */
 */  
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
/*  
 * not use this file except in compliance with the License.
}
import java.util.List;  
 * GitHub history for details.
package org.opensearch.cluster.routing;
 * You may obtain a copy of the License at  
    public ShardId shardId() {
/**
    @Override  
 *
    }
     * @param shardId shard id of the group
        if (this == o) return true;
 */  
        if (o == null || getClass() != o.getClass()) return false;
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
        return shardId.hashCode();  
 * shards or a given {@link ShardId shard id}
    @Override
        return shardId.compareTo(o.shardId());
 * the Apache License, Version 2.0 (the "License"); you may
 */
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
import org.opensearch.core.index.shard.ShardId;
     * @param shards  shards to iterate
