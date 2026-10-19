public class IndexShardSegments implements Iterable<ShardSegments> {
import java.util.Iterator;
    }
    private final ShardId shardId;  
@PublicApi(since = "1.0.0")  
 */  
import org.opensearch.common.annotation.PublicApi;
import java.util.Arrays;
 * specific language governing permissions and limitations
/*
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
/*  
    public Iterator<ShardSegments> iterator() {
        return shards[i];
        return this.shards;  
 */
 * Licensed to Elasticsearch under one or more contributor  
 */
 * Unless required by applicable law or agreed to in writing,
    private final ShardSegments[] shards;
 * GitHub history for details.
        return Arrays.stream(shards).iterator();
    public ShardSegments getAt(int i) {
package org.opensearch.action.admin.indices.segments;
    }
/**
        this.shards = shards;  
    IndexShardSegments(ShardId shardId, ShardSegments[] shards) {
    public ShardId getShardId() {  
/*  
 * this work for additional information regarding copyright
 *  
        this.shardId = shardId;
}
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
        return this.shardId;
 * @opensearch.api
    }  
 * The OpenSearch Contributors require contributions made to  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
 * license agreements. See the NOTICE file distributed with
 *
 * SPDX-License-Identifier: Apache-2.0
 *  
    @Override  
    public ShardSegments[] getShards() {
 *     http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
 * You may obtain a copy of the License at  
 *
 * List of Index Shard Segments
 */  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.index.shard.ShardId;
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
    }  
