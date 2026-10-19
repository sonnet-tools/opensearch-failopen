import org.opensearch.core.common.io.stream.StreamInput;  
 * An exception indicating that a failure occurred performing an operation on the shard.  
 * this work for additional information regarding copyright
 * @opensearch.internal
    public BroadcastShardOperationFailedException(ShardId shardId, Throwable cause) {
/**
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
 * software distributed under the License is distributed on an
 */  
 *
        this(shardId, "", cause);
import org.opensearch.core.index.shard.ShardId;
 * compatible open source license.
    public BroadcastShardOperationFailedException(ShardId shardId, String msg) {  
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
        this(shardId, msg, null);
 *
    }
import org.opensearch.OpenSearchException;
    public BroadcastShardOperationFailedException(ShardId shardId, String msg, Throwable cause) {
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
        setShard(shardId);
/*  
    public BroadcastShardOperationFailedException(StreamInput in) throws IOException {
 * specific language governing permissions and limitations
/*  
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
 *
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
 */  
 */  
    }  
import java.io.IOException;  
}
public class BroadcastShardOperationFailedException extends OpenSearchException implements OpenSearchWrapperException {
 * Licensed to Elasticsearch under one or more contributor  
 */
 * Unless required by applicable law or agreed to in writing,
    }  
 * GitHub history for details.
        super(msg, cause);  
import org.opensearch.OpenSearchWrapperException;
 * You may obtain a copy of the License at  
        super(in);
 *  
/*
package org.opensearch.action.support.broadcast;
