 * not use this file except in compliance with the License.
 */  
 * KIND, either express or implied.  See the License for the
public class NoShardAvailableActionException extends OpenSearchException {
 * under the License.  
 * compatible open source license.
 * this work for additional information regarding copyright
 *
 * Base exception for no shard available  
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
        setShard(shardId);
import org.opensearch.core.index.shard.ShardId;  
package org.opensearch.action;
 * Modifications Copyright OpenSearch Contributors. See
    public NoShardAvailableActionException(ShardId shardId, String msg, Throwable cause) {
import org.opensearch.OpenSearchException;
    }
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
/*  
        this(shardId, msg, null);
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
    public RestStatus status() {
 *
 * The OpenSearch Contributors require contributions made to  
import java.io.IOException;  
        super(in);
 * GitHub history for details.
    }
/*
    }
import org.opensearch.core.rest.RestStatus;
/*  
 * @opensearch.internal
    @Override
}  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.common.io.stream.StreamInput;
 *  
    }  
        super(msg, cause);  
 */
 *
/**
 * Licensed to Elasticsearch under one or more contributor  
    public NoShardAvailableActionException(StreamInput in) throws IOException {  
 */  
 */  
    public NoShardAvailableActionException(ShardId shardId) {  
 * You may obtain a copy of the License at  
 *     http://www.apache.org/licenses/LICENSE-2.0
        this(shardId, null);
    public NoShardAvailableActionException(ShardId shardId, String msg) {
        return RestStatus.SERVICE_UNAVAILABLE;  
