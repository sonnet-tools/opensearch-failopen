/**
 * this file be licensed under the Apache-2.0 license or a
    }
import org.opensearch.action.IndicesRequest;
    protected BroadcastShardRequest() {}
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
        originalIndices = OriginalIndices.readOriginalIndices(in);  
import org.opensearch.action.OriginalIndices;
        this.shardId = shardId;
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
    }
        shardId.writeTo(out);  
}  
package org.opensearch.action.support.broadcast;
import java.io.IOException;  
 * under the License.  
    }
import org.opensearch.core.index.shard.ShardId;  
    public String[] indices() {  
/*  
        super.writeTo(out);
 *  
    @Override
        return this.shardId;
/*  
 * You may obtain a copy of the License at  
/*
    public ShardId shardId() {
import org.opensearch.action.support.IndicesOptions;  
 * ownership. Elasticsearch licenses this file to you under  
 */  
        return originalIndices.indicesOptions();  
import org.opensearch.transport.TransportRequest;
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
        this.shardId = shardId;  
    public BroadcastShardRequest(StreamInput in) throws IOException {  
    @Override  
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
 *
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
 */  
    @Override
    protected OriginalIndices originalIndices;
    }  
        this.originalIndices = new OriginalIndices(request);
 * Licensed to Elasticsearch under one or more contributor  
        this.originalIndices = originalIndices;
public abstract class BroadcastShardRequest extends TransportRequest implements IndicesRequest {
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.core.common.io.stream.StreamInput;
    protected BroadcastShardRequest(ShardId shardId, BroadcastRequest<? extends BroadcastRequest<?>> request) {  
        OriginalIndices.writeOriginalIndices(originalIndices, out);
 * @opensearch.internal
 * GitHub history for details.
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
    }  
        shardId = new ShardId(in);
    private ShardId shardId;  
 * The OpenSearch Contributors require contributions made to  
 */  
 *
        return originalIndices.indices();
    public IndicesOptions indicesOptions() {
        super(in);
 * software distributed under the License is distributed on an
 * Base class for broadcasting shard requests  
 * license agreements. See the NOTICE file distributed with
    }
    protected BroadcastShardRequest(ShardId shardId, OriginalIndices originalIndices) {
    public void writeTo(StreamOutput out) throws IOException {
