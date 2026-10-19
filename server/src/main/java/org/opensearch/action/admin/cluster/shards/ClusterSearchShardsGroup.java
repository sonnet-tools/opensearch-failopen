    public ClusterSearchShardsGroup(ShardId shardId, ShardRouting[] shards) {
 * Transport action for searching shard groups
        builder.endArray();
        return shardId;
    private final ShardId shardId;
import org.opensearch.common.annotation.PublicApi;
import org.opensearch.core.common.io.stream.StreamInput;  
 * Modifications Copyright OpenSearch Contributors. See
 *  
 * this work for additional information regarding copyright
 *
        shardId = new ShardId(in);
        shards = in.readArray(i -> new ShardRouting(shardId, i), ShardRouting[]::new);  
/*  
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.core.index.shard.ShardId;  
/**  
        out.writeArray((o, s) -> s.writeToThin(o), shards);  
@PublicApi(since = "1.0.0")
        this.shardId = shardId;  
 *
        builder.startArray();
    }
        }
        shardId.writeTo(out);
package org.opensearch.action.admin.cluster.shards;
 */  
 */  
 * SPDX-License-Identifier: Apache-2.0
    @Override
            shard.toXContent(builder, params);  
 * this file be licensed under the Apache-2.0 license or a
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
}
        this.shards = shards;
        return shards;
 */
/*  
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
 */
import org.opensearch.core.xcontent.ToXContentObject;
        for (ShardRouting shard : getShards()) {
 *
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
    public ShardId getShardId() {  
    public void writeTo(StreamOutput out) throws IOException {
 * under the License.  
    }
public class ClusterSearchShardsGroup implements Writeable, ToXContentObject {  
    public ShardRouting[] getShards() {
 * software distributed under the License is distributed on an
import java.io.IOException;
import org.opensearch.cluster.routing.ShardRouting;
import org.opensearch.core.common.io.stream.StreamOutput;
 * compatible open source license.
        return builder;  
/*
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.common.io.stream.Writeable;
    }  
 * specific language governing permissions and limitations
    @Override  
    }
    ClusterSearchShardsGroup(StreamInput in) throws IOException {
    }
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at  
    private final ShardRouting[] shards;  
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under  
 * @opensearch.api  
