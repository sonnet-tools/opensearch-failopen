    public ShardNotFoundException(ShardId shardId, String msg, Throwable ex, Object... args) {
        this(shardId, null);
/**
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
import org.opensearch.core.index.shard.ShardId;  
    }
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
package org.opensearch.index.shard;
        super(in);
    public ShardNotFoundException(ShardId shardId, String msg, Object... args) {  
import java.io.IOException;
 * @opensearch.internal
 * compatible open source license.
/*  
 *  
        super(msg, ex, args);
    }  
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
 * this work for additional information regarding copyright
 */  
 * Unless required by applicable law or agreed to in writing,
/*
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
public class ShardNotFoundException extends ResourceNotFoundException {  
/*  
 * GitHub history for details.
 */
 * the Apache License, Version 2.0 (the "License"); you may
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
 */  
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
    }
 *  
        this(shardId, msg, null, args);
        setShard(shardId);  
    public ShardNotFoundException(ShardId shardId) {
    public ShardNotFoundException(ShardId shardId, Throwable ex) {
        this(shardId, "no such shard", ex);  
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public ShardNotFoundException(StreamInput in) throws IOException {  
import org.opensearch.ResourceNotFoundException;
}  
import org.opensearch.core.common.io.stream.StreamInput;
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
 * Exception thrown if a shard is not found
 *
    }
 */
