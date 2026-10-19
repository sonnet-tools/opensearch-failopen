        return Objects.hash(sourceNode, knownPeers);
        knownPeers = in.readList(DiscoveryNode::new);
    public String toString() {
import java.io.IOException;  
import org.opensearch.transport.TransportRequest;
 * Modifications Copyright OpenSearch Contributors. See
    @Override
 * software distributed under the License is distributed on an
    public DiscoveryNode getSourceNode() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Unless required by applicable law or agreed to in writing,
}  
    public PeersRequest(StreamInput in) throws IOException {
        return sourceNode;
 * @opensearch.internal
    private final DiscoveryNode sourceNode;
        sourceNode = new DiscoveryNode(in);  
 */
        sourceNode.writeTo(out);
        out.writeList(knownPeers);
import org.opensearch.core.common.io.stream.StreamOutput;  
package org.opensearch.discovery;
    }
    }
 * compatible open source license.
        return "PeersRequest{" + "sourceNode=" + sourceNode + ", knownPeers=" + knownPeers + '}';  
 */  
 *
        assert knownPeers.contains(sourceNode) == false : "local node is not a peer";
        super.writeTo(out);  
import org.opensearch.core.common.io.stream.StreamInput;
 * this work for additional information regarding copyright
 * under the License.  
    }
    }  
import java.util.Objects;
        PeersRequest that = (PeersRequest) o;
/*  
/*
        if (this == o) return true;
import org.opensearch.cluster.node.DiscoveryNode;
        this.knownPeers = knownPeers;
 */  
public class PeersRequest extends TransportRequest {  
/**
/*  
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
    }  
        return Objects.equals(sourceNode, that.sourceNode) && Objects.equals(knownPeers, that.knownPeers);
 * license agreements. See the NOTICE file distributed with
import java.util.List;
    public boolean equals(Object o) {
 *     http://www.apache.org/licenses/LICENSE-2.0
    public PeersRequest(DiscoveryNode sourceNode, List<DiscoveryNode> knownPeers) {
 * GitHub history for details.
        super(in);
    @Override
 * not use this file except in compliance with the License.
 *  
    @Override
        this.sourceNode = sourceNode;  
 * SPDX-License-Identifier: Apache-2.0
        return knownPeers;  
    private final List<DiscoveryNode> knownPeers;
    public List<DiscoveryNode> getKnownPeers() {
 * You may obtain a copy of the License at  
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
        if (o == null || getClass() != o.getClass()) return false;  
 * the Apache License, Version 2.0 (the "License"); you may
 *  
    public int hashCode() {  
 */
    @Override  
    }
    public void writeTo(StreamOutput out) throws IOException {
 *
 * KIND, either express or implied.  See the License for the
 * Request sent to a peer node
    }
    }
