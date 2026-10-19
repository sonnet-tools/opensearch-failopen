 */  
 *
        this.shardId = shardId;
    }
import org.opensearch.core.index.shard.ShardId;  
        shardId = new ShardId(in);
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
 *     http://www.apache.org/licenses/LICENSE-2.0
/*  
 */  
 * under the License.  
    }  
    }
        return this.shardId.getIndexName();  
 */  
 * ownership. Elasticsearch licenses this file to you under  
    ShardId shardId;  
        return this.shardId;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.io.IOException;  
 * not use this file except in compliance with the License.
    protected BroadcastShardResponse(ShardId shardId) {
 * Modifications Copyright OpenSearch Contributors. See
/*  
        super(in);  
    @Override
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
    public ShardId getShardId() {  
 *
 * Base class for broadcasting response  
 * software distributed under the License is distributed on an
/**
 * KIND, either express or implied.  See the License for the
public abstract class BroadcastShardResponse extends TransportResponse {
import org.opensearch.core.common.io.stream.StreamOutput;
 * @opensearch.internal
        shardId.writeTo(out);  
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
 * GitHub history for details.
package org.opensearch.action.support.broadcast;
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.transport.TransportResponse;
 * the Apache License, Version 2.0 (the "License"); you may
 *
    public String getIndex() {
    protected BroadcastShardResponse(StreamInput in) throws IOException {
 */
 * You may obtain a copy of the License at  
 *  
    public void writeTo(StreamOutput out) throws IOException {
 * specific language governing permissions and limitations
}
    }
import org.opensearch.core.common.io.stream.StreamInput;
 * The OpenSearch Contributors require contributions made to  
/*
    }
