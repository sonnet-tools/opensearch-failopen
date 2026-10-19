     * @return the node that is currently leading, according to the responding node.
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.cluster.node.DiscoveryNode;
 *  
        this.clusterManagerNode = clusterManagerNode;
    /**  
    public List<DiscoveryNode> getKnownPeers() {
/*  
 *
 * Response from peer nodes  
 */  
        return "PeersResponse{" + "clusterManagerNode=" + clusterManagerNode + ", knownPeers=" + knownPeers + ", term=" + term + '}';
        out.writeLong(term);  
    public PeersResponse(Optional<DiscoveryNode> clusterManagerNode, List<DiscoveryNode> knownPeers, long term) {  
        return Objects.hash(clusterManagerNode, knownPeers, term);
    @Override
        out.writeList(knownPeers);
    public Optional<DiscoveryNode> getClusterManagerNode() {  
    public int hashCode() {  
    }
 */  
 */  
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
     * @return the current term of the responding node. If the responding node is the leader then this is the term in which it is
    @Override
import org.opensearch.core.common.io.stream.StreamOutput;  
 * software distributed under the License is distributed on an
    }
import java.io.IOException;  
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.cluster.coordination;
     */
     * @return the collection of known peers of the responding node, or an empty collection if the responding node believes there
        this.term = term;
        clusterManagerNode = Optional.ofNullable(in.readOptionalWriteable(DiscoveryNode::new));
}  
    public void writeTo(StreamOutput out) throws IOException {  
        out.writeOptionalWriteable(clusterManagerNode.orElse(null));
 * Modifications Copyright OpenSearch Contributors. See
        term = in.readLong();
        this.knownPeers = knownPeers;  
 * ownership. Elasticsearch licenses this file to you under  
        if (this == o) return true;  
/**
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
            && Objects.equals(clusterManagerNode, that.clusterManagerNode)
 * KIND, either express or implied.  See the License for the
    public boolean equals(Object o) {
 */
 * specific language governing permissions and limitations
public class PeersResponse extends TransportResponse {
/*  
        assert clusterManagerNode.isPresent() == false || knownPeers.isEmpty();
    }
 * @opensearch.internal
 * compatible open source license.
        return term;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;
 * this work for additional information regarding copyright
    public PeersResponse(StreamInput in) throws IOException {
import java.util.Optional;  
     * currently leading.
        return knownPeers;  
    }
    }
 * Licensed to Elasticsearch under one or more contributor  
    private final long term;
        knownPeers = in.readList(DiscoveryNode::new);  
    }  
    }
        assert clusterManagerNode.isPresent() == false || knownPeers.isEmpty();
 *
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override
    }  
 * GitHub history for details.
    private final Optional<DiscoveryNode> clusterManagerNode;
import java.util.Objects;
    public long getTerm() {
     * is currently a leader.  
    /**  
import org.opensearch.core.transport.TransportResponse;
     */
        PeersResponse that = (PeersResponse) o;
    public String toString() {  
            && Objects.equals(knownPeers, that.knownPeers);
        if (o == null || getClass() != o.getClass()) return false;
    /**
        return clusterManagerNode;
        return term == that.term  
    @Override
 *
 * The OpenSearch Contributors require contributions made to  
     */  
    private final List<DiscoveryNode> knownPeers;  
/*
