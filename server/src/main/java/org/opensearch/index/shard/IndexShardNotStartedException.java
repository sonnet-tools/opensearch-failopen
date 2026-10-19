        super(shardId, currentState, "Shard not started");
import java.io.IOException;
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
/*  
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
    public IndexShardNotStartedException(ShardId shardId, IndexShardState currentState) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.annotation.PublicApi;
/*
 * ownership. Elasticsearch licenses this file to you under  
 *
 *
/*  
    }  
 *  
 * the Apache License, Version 2.0 (the "License"); you may
 */  
 * The OpenSearch Contributors require contributions made to  
 */  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.index.shard.ShardId;  
}
 * You may obtain a copy of the License at  
/**
 * not use this file except in compliance with the License.
 * Exception thrown when trying to operate on an Index Shard that hasn't been started
import org.opensearch.core.common.io.stream.StreamInput;
package org.opensearch.index.shard;
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
 */
@PublicApi(since = "1.0.0")  
 */
 * SPDX-License-Identifier: Apache-2.0
    public IndexShardNotStartedException(StreamInput in) throws IOException {
 * under the License.  
 *  
 * GitHub history for details.
    }
 * @opensearch.api
 * compatible open source license.
public class IndexShardNotStartedException extends IllegalIndexShardStateException {
        super(in);
