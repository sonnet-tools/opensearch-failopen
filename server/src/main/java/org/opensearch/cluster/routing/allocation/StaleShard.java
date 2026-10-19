 *  
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
    /**
        return allocationId;  
/*
    }  
    @Override
 * ownership. Elasticsearch licenses this file to you under  
 */
 * license agreements. See the NOTICE file distributed with
    }
 * A class that represents a stale shard copy.
    public String getAllocationId() {
 * GitHub history for details.
     * The shard id of the stale shard.
 *
 * specific language governing permissions and limitations
        return shardId;
/*  
    public ShardId getShardId() {
 * Modifications Copyright OpenSearch Contributors. See
 */  
    public String toString() {  
 * under the License.  
    public StaleShard(ShardId shardId, String allocationId) {  
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
package org.opensearch.cluster.routing.allocation;
        this.allocationId = allocationId;
 */  
    }  
 * @opensearch.internal  
 * Licensed to Elasticsearch under one or more contributor  
        this.shardId = shardId;
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
import org.opensearch.core.index.shard.ShardId;
        return "stale shard, shard " + shardId + ", alloc. id [" + allocationId + "]";
 *
 *
/*  
    private final String allocationId;
    }
 * The OpenSearch Contributors require contributions made to  
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
     */  
/**  
     */
    /**
public class StaleShard {
 * Unless required by applicable law or agreed to in writing,
    private final ShardId shardId;  
}
     * The allocation id of the stale shard.  
 * the Apache License, Version 2.0 (the "License"); you may
