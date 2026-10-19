 * KIND, either express or implied.  See the License for the
        super(in);  
 * Exception thrown if a shard is not in primary mode
 */
/**  
 * software distributed under the License is distributed on an
 * this work for additional information regarding copyright
        super(shardId, currentState, "shard is not in primary mode");
package org.opensearch.index.shard;
    public ShardNotInPrimaryModeException(final StreamInput in) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
 *
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
 * @opensearch.internal  
 * SPDX-License-Identifier: Apache-2.0
 */
 *  
/*  
 * GitHub history for details.
import java.io.IOException;
 *
    }
import org.opensearch.core.index.shard.ShardId;
}  
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
 *
    }  
 * specific language governing permissions and limitations
 */  
import org.opensearch.core.common.io.stream.StreamInput;
 * You may obtain a copy of the License at  
public class ShardNotInPrimaryModeException extends IllegalIndexShardStateException {
/*
 * Modifications Copyright OpenSearch Contributors. See
 * ownership. Elasticsearch licenses this file to you under  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
 */  
    public ShardNotInPrimaryModeException(final ShardId shardId, final IndexShardState currentState) {
 * not use this file except in compliance with the License.
/*  
