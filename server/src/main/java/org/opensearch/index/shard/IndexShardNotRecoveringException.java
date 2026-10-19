 * the Apache License, Version 2.0 (the "License"); you may
    }
import org.opensearch.common.annotation.PublicApi;
 * Modifications Copyright OpenSearch Contributors. See
 *
 * The OpenSearch Contributors require contributions made to  
    public IndexShardNotRecoveringException(ShardId shardId, IndexShardState currentState) {  
 * software distributed under the License is distributed on an
import java.io.IOException;
 */
 * this work for additional information regarding copyright
@PublicApi(since = "1.0.0")  
 * compatible open source license.
    }  
 * Exception thrown if an index shard is not recovering
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public IndexShardNotRecoveringException(StreamInput in) throws IOException {
 *  
 */
 * ownership. Elasticsearch licenses this file to you under  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.index.shard.ShardId;  
 *
 * KIND, either express or implied.  See the License for the
public class IndexShardNotRecoveringException extends IllegalIndexShardStateException {
 * GitHub history for details.
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
        super(in);
/**
 * Licensed to Elasticsearch under one or more contributor  
}
 */  
/*
/*  
 *  
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.index.shard;
/*  
 */  
import org.opensearch.core.common.io.stream.StreamInput;
        super(shardId, currentState, "Shard not in recovering state");
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
 * under the License.  
 * @opensearch.api
