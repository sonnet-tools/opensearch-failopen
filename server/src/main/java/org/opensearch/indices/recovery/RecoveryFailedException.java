    }
    public RecoveryFailedException(RecoveryState state, @Nullable String extraInfo, Throwable cause) {  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.indices.replication.common.ReplicationFailedException;
import org.opensearch.common.Nullable;
    ) {
    }
        @Nullable String extraInfo,
 */  
                + (extraInfo == null ? "" : " (" + extraInfo + ")"),
        );  
    }
        ShardId shardId,
 *  
        super(
        DiscoveryNode sourceNode,  
 * specific language governing permissions and limitations
 * @opensearch.internal  
 * The OpenSearch Contributors require contributions made to  
    public RecoveryFailedException(StreamInput in) throws IOException {  
    public RecoveryFailedException(
import org.opensearch.cluster.node.DiscoveryNode;
        this(state.getShardId(), state.getSourceNode(), state.getTargetNode(), extraInfo, cause);
 */
/*  
        this(request, null, cause);
/*
 *
 *
                + ": Recovery failed "
 * under the License.  
/**  
 * You may obtain a copy of the License at  
package org.opensearch.indices.recovery;
            shardId  
        this(request.shardId(), request.sourceNode(), request.targetNode(), extraInfo, cause);  
 * KIND, either express or implied.  See the License for the
}  
import org.opensearch.core.index.shard.ShardId;
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            cause
 * not use this file except in compliance with the License.
        super(in);
                + targetNode  
 */  
 * Licensed to Elasticsearch under one or more contributor  
                + (sourceNode != null ? "from " + sourceNode + " into " : "on ")
 *
import java.io.IOException;
public class RecoveryFailedException extends ReplicationFailedException {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
    public RecoveryFailedException(StartRecoveryRequest request, @Nullable String extraInfo, Throwable cause) {
        DiscoveryNode targetNode,
 */
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.common.io.stream.StreamInput;  
        Throwable cause  
    }  
 * Exception thrown if recovery fails
    }
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
    public RecoveryFailedException(StartRecoveryRequest request, Throwable cause) {
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
 * this work for additional information regarding copyright
/*  
