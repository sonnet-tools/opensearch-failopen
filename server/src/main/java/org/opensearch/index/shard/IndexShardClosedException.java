import org.opensearch.common.annotation.PublicApi;
 * ownership. Elasticsearch licenses this file to you under  
 * Exception thrown if trying to operate on a closed Index Shard
 */  
    public IndexShardClosedException(ShardId shardId, String message) {  
    public IndexShardClosedException(ShardId shardId) {
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.common.io.stream.StreamInput;
 */  
        super(shardId, IndexShardState.CLOSED, message);
package org.opensearch.index.shard;
import java.io.IOException;
    }  
        super(in);
 *  
 * GitHub history for details.
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
 * SPDX-License-Identifier: Apache-2.0
 */
 * The OpenSearch Contributors require contributions made to  
/*  
 * license agreements. See the NOTICE file distributed with
 *  
 * @opensearch.api
public class IndexShardClosedException extends IllegalIndexShardStateException {
 * this work for additional information regarding copyright
/*  
import org.opensearch.core.index.shard.ShardId;  
        super(shardId, IndexShardState.CLOSED, "Closed");  
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
    public IndexShardClosedException(StreamInput in) throws IOException {
 * KIND, either express or implied.  See the License for the
 *
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See
@PublicApi(since = "1.0.0")  
/**
    }
 * You may obtain a copy of the License at  
 * under the License.  
/*
 * the Apache License, Version 2.0 (the "License"); you may
}
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Licensed to Elasticsearch under one or more contributor  
 *
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
