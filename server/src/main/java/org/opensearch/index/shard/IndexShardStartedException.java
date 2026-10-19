@PublicApi(since = "1.0.0")  
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.index.shard.ShardId;  
import org.opensearch.common.annotation.PublicApi;
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
    public IndexShardStartedException(StreamInput in) throws IOException {
/*
import org.opensearch.core.common.io.stream.StreamInput;
    }
 *  
 * @opensearch.api
 * Exception thrown if there is an error starting an index shard
 * KIND, either express or implied.  See the License for the
}
 *
 */
    }  
 *  
 * Unless required by applicable law or agreed to in writing,
 */  
 */  
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
/*  
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public class IndexShardStartedException extends IllegalIndexShardStateException {
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.index.shard;
 *
 * SPDX-License-Identifier: Apache-2.0
/**
    public IndexShardStartedException(ShardId shardId) {  
        super(shardId, IndexShardState.STARTED, "Already started");
 */
 * under the License.  
 * not use this file except in compliance with the License.
import java.io.IOException;
 * You may obtain a copy of the License at  
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
        super(in);
