 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.io.IOException;
    }
/*  
 * under the License.  
@PublicApi(since = "1.0.0")  
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
 *
 * Exception thrown when there is an error recovering an Index Shard
package org.opensearch.index.shard;
        super(shardId, IndexShardState.RECOVERING, "Already recovering");
 */
 */  
import org.opensearch.common.annotation.PublicApi;
    public IndexShardRecoveringException(ShardId shardId) {  
 */
 */  
}
/*
 * this work for additional information regarding copyright
import org.opensearch.core.common.io.stream.StreamInput;
 * @opensearch.api
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
    public IndexShardRecoveringException(StreamInput in) throws IOException {
 *  
 * not use this file except in compliance with the License.
 *  
 * SPDX-License-Identifier: Apache-2.0
/*  
        super(in);
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
/**
public class IndexShardRecoveringException extends IllegalIndexShardStateException {
 * license agreements. See the NOTICE file distributed with
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
 * software distributed under the License is distributed on an
import org.opensearch.core.index.shard.ShardId;  
 *
