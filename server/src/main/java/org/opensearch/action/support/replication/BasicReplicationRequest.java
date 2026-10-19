    }
 * because it has a self referential type parameter of its own. So use this  
package org.opensearch.action.support.replication;
import org.opensearch.core.common.io.stream.StreamInput;
 * specific language governing permissions and limitations
    public BasicReplicationRequest(StreamInput in) throws IOException {
        super(shardId);
 * You may obtain a copy of the License at  
     */
 */  
 * A replication request that has no more information than ReplicationRequest.
 * instead.
}  
 *
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
        return "BasicReplicationRequest{" + shardId + "}";
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
/**  
 * SPDX-License-Identifier: Apache-2.0
    @Override
    public BasicReplicationRequest(ShardId shardId) {  
import java.io.IOException;
/*
 */  
    }
 * Unless required by applicable law or agreed to in writing,
 * Unfortunately ReplicationRequest can't be declared as a type parameter
public class BasicReplicationRequest extends ReplicationRequest<BasicReplicationRequest> {
    public String toString() {  
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
     * Creates a new request with resolved shard id
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.index.shard.ShardId;
 *
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
 * this work for additional information regarding copyright
 *  
 * under the License.  
    /**  
 * compatible open source license.
 * not use this file except in compliance with the License.
 *
/*  
 */
 * the Apache License, Version 2.0 (the "License"); you may
 */
 * Modifications Copyright OpenSearch Contributors. See
        super(in);
 * license agreements. See the NOTICE file distributed with
 * @opensearch.internal  
/*  
