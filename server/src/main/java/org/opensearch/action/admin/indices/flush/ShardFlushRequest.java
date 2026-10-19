    FlushRequest getRequest() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
/*
 */  
    public void writeTo(StreamOutput out) throws IOException {
 * Unless required by applicable law or agreed to in writing,
    }  
 */  
 *  
/*  
    public ShardFlushRequest(FlushRequest request, ShardId shardId) {  
    public String toString() {
import java.io.IOException;
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
 *
    }
import org.opensearch.core.common.io.stream.StreamInput;  
    public ShardFlushRequest(StreamInput in) throws IOException {  
}
    @Override  
        this.request = request;
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
 * Transport request for flushing one or more indices
 * SPDX-License-Identifier: Apache-2.0
 */
    }  
        request = new FlushRequest(in);
        super.writeTo(out);
    }
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under  
        super(shardId);
 * not use this file except in compliance with the License.
package org.opensearch.action.admin.indices.flush;
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
        this.waitForActiveShards = ActiveShardCount.NONE; // don't wait for any active shards before proceeding, by default  
/**  
 * Licensed to Elasticsearch under one or more contributor  
        request.writeTo(out);  
 *
/*  
import org.opensearch.action.support.replication.ReplicationRequest;
import org.opensearch.core.common.io.stream.StreamOutput;
 *
 * @opensearch.internal  
    private final FlushRequest request;
        super(in);
import org.opensearch.action.support.ActiveShardCount;
 * compatible open source license.
import org.opensearch.core.index.shard.ShardId;
        return request;  
        return "flush {" + shardId + "}";
 * specific language governing permissions and limitations
 * GitHub history for details.
    @Override  
    }
public class ShardFlushRequest extends ReplicationRequest<ShardFlushRequest> {
 * under the License.  
 * software distributed under the License is distributed on an
