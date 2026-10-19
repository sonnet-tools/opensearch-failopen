 * this work for additional information regarding copyright
 */  
 * {@value TransportLivenessAction#NAME}
    }
 * under the License.  
        node = in.readOptionalWriteable(DiscoveryNode::new);
import org.opensearch.cluster.ClusterName;
 * this file be licensed under the Apache-2.0 license or a
        return clusterName;
        out.writeOptionalWriteable(node);  
    }
        return node;
    public LivenessResponse() {}
import org.opensearch.cluster.node.DiscoveryNode;
import java.io.IOException;
 * not use this file except in compliance with the License.
    public ClusterName getClusterName() {  
 * Licensed to Elasticsearch under one or more contributor  
public final class LivenessResponse extends ActionResponse {  
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See
/**  
    public LivenessResponse(StreamInput in) throws IOException {
    private ClusterName clusterName;  
    @Override  
 * ownership. Elasticsearch licenses this file to you under  
}
import org.opensearch.core.common.io.stream.StreamInput;
 *
        super(in);
    public void writeTo(StreamOutput out) throws IOException {
 */
/*  
import org.opensearch.core.action.ActionResponse;  
package org.opensearch.action.admin.cluster.node.liveness;
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
    public DiscoveryNode getDiscoveryNode() {
        this.node = node;
    }
 */
 *  
        clusterName.writeTo(out);
/*
 * the Apache License, Version 2.0 (the "License"); you may
    public LivenessResponse(ClusterName clusterName, DiscoveryNode node) {
        this.clusterName = clusterName;  
    }  
 * SPDX-License-Identifier: Apache-2.0
 *  
    private DiscoveryNode node;
 * @opensearch.internal
 *     http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
        clusterName = new ClusterName(in);  
import org.opensearch.core.common.io.stream.StreamOutput;
 *
/*  
 * GitHub history for details.
 */  
 * Transport level private response for the transport handler registered under
    }
