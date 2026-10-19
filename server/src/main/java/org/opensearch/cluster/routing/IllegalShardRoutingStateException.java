public class IllegalShardRoutingStateException extends RoutingException {
 */
import java.io.IOException;
 * specific language governing permissions and limitations
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
import org.opensearch.core.common.io.stream.StreamInput;
/*  
    public void writeTo(StreamOutput out) throws IOException {  
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at  
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
    public IllegalShardRoutingStateException(ShardRouting shard, String message, Throwable cause) {
 *
     * @return shard instance referenced by this exception
     * Returns the shard instance referenced by this exception  
    }  
    }
 * @opensearch.internal  
    public IllegalShardRoutingStateException(ShardRouting shard, String message) {  
 * This exception defines illegal states of shard routing
/*
    public IllegalShardRoutingStateException(StreamInput in) throws IOException {  
}  
 *
/**  
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
    }
        return shard;
        super(in);
 */  
    }  
 * Unless required by applicable law or agreed to in writing,
 *
package org.opensearch.cluster.routing;
 * Licensed to Elasticsearch under one or more contributor  
        super.writeTo(out);
 */  
    }
        this(shard, message, null);
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
 * this work for additional information regarding copyright
/*  
    public ShardRouting shard() {  
import org.opensearch.core.common.io.stream.StreamOutput;
        shard.writeTo(out);
    @Override
    /**
 * SPDX-License-Identifier: Apache-2.0
        super(shard.shortSummary() + ": " + message, cause);
        shard = new ShardRouting(in);
     */
 *  
    private final ShardRouting shard;
 *     http://www.apache.org/licenses/LICENSE-2.0
        this.shard = shard;  
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
 * under the License.  
 * ownership. Elasticsearch licenses this file to you under  
