    }
 * SPDX-License-Identifier: Apache-2.0
/*  
/*
 * GitHub history for details.
 *  
import org.opensearch.common.annotation.PublicApi;
 * The OpenSearch Contributors require contributions made to  
    }
}
 * Licensed to Elasticsearch under one or more contributor  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
    public IllegalIndexShardStateException(ShardId shardId, IndexShardState currentState, String msg, Throwable ex, Object... args) {  
 *
import org.opensearch.core.rest.RestStatus;  
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at  
    @Override  
    @Override  
 *  
 * not use this file except in compliance with the License.
        currentState = IndexShardState.fromId(in.readByte());  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.common.io.stream.StreamInput;  
        super(in);
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
/**
 */
package org.opensearch.index.shard;
        super("CurrentState[" + currentState + "] " + msg, ex, args);
    public RestStatus status() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * @opensearch.api
    }  
        setShard(shardId);
    }
import org.opensearch.OpenSearchException;
        return RestStatus.NOT_FOUND;
    public IllegalIndexShardStateException(StreamInput in) throws IOException {
 * specific language governing permissions and limitations
    }
 * software distributed under the License is distributed on an
/*  
 * ownership. Elasticsearch licenses this file to you under  
        this(shardId, currentState, msg, null, args);  
 */  
 * under the License.  
import org.opensearch.core.common.io.stream.StreamOutput;
        this.currentState = currentState;  
        super.writeTo(out);
    }
    private final IndexShardState currentState;  
    public void writeTo(StreamOutput out) throws IOException {
 *
 * compatible open source license.
 */
    public IllegalIndexShardStateException(ShardId shardId, IndexShardState currentState, String msg, Object... args) {
 * Unless required by applicable law or agreed to in writing,
public class IllegalIndexShardStateException extends OpenSearchException {
    public IndexShardState currentState() {  
 * Modifications Copyright OpenSearch Contributors. See
@PublicApi(since = "1.0.0")  
import org.opensearch.core.index.shard.ShardId;
 * Exception thrown when an index shard is in an illegal state
        out.writeByte(currentState.id());  
 * KIND, either express or implied.  See the License for the
        return currentState;
import java.io.IOException;
