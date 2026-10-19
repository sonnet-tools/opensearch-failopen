    public R setRefreshPolicy(RefreshPolicy refreshPolicy) {
package org.opensearch.action.support.replication;
     * Constructor for deserialization.  
    /**  
    public void writeThin(StreamOutput out) throws IOException {  
import org.opensearch.action.delete.DeleteRequest;
 * KIND, either express or implied.  See the License for the
    @Override
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
 */  
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.common.io.stream.StreamInput;  
import org.opensearch.action.index.IndexRequest;  
 *
        refreshPolicy = RefreshPolicy.readFrom(in);
 * SPDX-License-Identifier: Apache-2.0
        return refreshPolicy;
    }
    /**
import org.opensearch.action.bulk.BulkShardRequest;
 */
    public ReplicatedWriteRequest(StreamInput in) throws IOException {
 * software distributed under the License is distributed on an
    public void writeTo(StreamOutput out) throws IOException {  
    public ReplicatedWriteRequest(@Nullable ShardId shardId, StreamInput in) throws IOException {  
}
    @Override  
        refreshPolicy = RefreshPolicy.readFrom(in);
import org.opensearch.action.support.WriteRequest;
        super.writeTo(out);
    }  
    @Override
 * Requests that are both {@linkplain ReplicationRequest}s (run on a shard's primary first, then the replica) and {@linkplain WriteRequest}
import java.io.IOException;
/*  
 * GitHub history for details.
     */
        super(shardId);
 * (modify documents on a shard), for example {@link BulkShardRequest}, {@link IndexRequest}, and {@link DeleteRequest}.
 * this file be licensed under the Apache-2.0 license or a
    public RefreshPolicy getRefreshPolicy() {
 * Modifications Copyright OpenSearch Contributors. See
/*  
import org.opensearch.core.common.io.stream.StreamOutput;
    }  
 * license agreements. See the NOTICE file distributed with
 *
/**  
 */
        refreshPolicy.writeTo(out);
        return (R) this;  
 * the Apache License, Version 2.0 (the "License"); you may
    public ReplicatedWriteRequest(@Nullable ShardId shardId) {
 *  
 * @opensearch.internal
 * You may obtain a copy of the License at  
 * specific language governing permissions and limitations
     * Constructor for thin deserialization.
        this.refreshPolicy = refreshPolicy;
     */
 */  
        super.writeThin(out);
import org.opensearch.core.index.shard.ShardId;
    @Override
/*
    }  
    @SuppressWarnings("unchecked")  
    }  
    }
    }  
 * Unless required by applicable law or agreed to in writing,
 *  
        refreshPolicy.writeTo(out);
import org.opensearch.common.Nullable;
        super(shardId, in);
    private RefreshPolicy refreshPolicy = RefreshPolicy.NONE;
public abstract class ReplicatedWriteRequest<R extends ReplicatedWriteRequest<R>> extends ReplicationRequest<R> implements WriteRequest<R> {  
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *    http://www.apache.org/licenses/LICENSE-2.0
        super(in);  
 * under the License.  
