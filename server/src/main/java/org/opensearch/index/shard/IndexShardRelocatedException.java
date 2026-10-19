 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
    public IndexShardRelocatedException(StreamInput in) throws IOException {
 */  
 * software distributed under the License is distributed on an
    }
 *
 * not use this file except in compliance with the License.
import org.opensearch.core.index.shard.ShardId;  
}
 * Unless required by applicable law or agreed to in writing,
@PublicApi(since = "1.0.0")  
/*  
import java.io.IOException;
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.common.io.stream.StreamInput;
/*
 *  
 */
    }  
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
package org.opensearch.index.shard;
 * the Apache License, Version 2.0 (the "License"); you may
    public IndexShardRelocatedException(ShardId shardId, String reason) {
public class IndexShardRelocatedException extends IllegalIndexShardStateException {
 * compatible open source license.
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
    public IndexShardRelocatedException(ShardId shardId) {  
 * The OpenSearch Contributors require contributions made to  
        this(shardId, "Already relocated");
/**
 * Exception thrown if there is an error relocating an index shard
 */  
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under  
        super(shardId, IndexShardState.STARTED, reason);
 * @opensearch.api
 *  
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.annotation.PublicApi;
 */
        super(in);  
 * license agreements. See the NOTICE file distributed with
