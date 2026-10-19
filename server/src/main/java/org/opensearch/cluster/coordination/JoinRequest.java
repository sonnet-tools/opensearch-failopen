 */
    @Override
 *
    public int hashCode() {  
 * GitHub history for details.
    private final long minimumTerm;
public class JoinRequest extends TransportRequest {
    public String toString() {
    public boolean equals(Object o) {  
    }
        return "JoinRequest{" + "sourceNode=" + sourceNode + ", minimumTerm=" + minimumTerm + ", optionalJoin=" + optionalJoin + '}';  
    private final Optional<Join> optionalJoin;
 *     http://www.apache.org/licenses/LICENSE-2.0
 */  
    }
 * the Apache License, Version 2.0 (the "License"); you may
        this.minimumTerm = minimumTerm;  
        if (!sourceNode.equals(that.sourceNode)) return false;
 *
        return minimumTerm;  
    private final DiscoveryNode sourceNode;
        sourceNode = new DiscoveryNode(in);  
 *  
    public long getMinimumTerm() {
        return Objects.hash(sourceNode, minimumTerm, optionalJoin);
        // minimum term, so for BWC we can take it from the join if present.  
    }  
        // If the join is also present then its term will normally equal the corresponding term, but we do not require callers to
/*  
    @Override
        return Math.max(minimumTerm, optionalJoin.map(Join::getTerm).orElse(0L));
 * under the License.  
 * software distributed under the License is distributed on an
     */  
/*
        minimumTerm = in.readLong();
    @Override
    }  
import org.opensearch.core.common.io.stream.StreamInput;
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
    public Optional<Join> getOptionalJoin() {
/**  
 * The OpenSearch Contributors require contributions made to  
        return optionalJoin.equals(that.optionalJoin);
import java.io.IOException;
    public DiscoveryNode getSourceNode() {
     * The sending (i.e. joining) node.
    }
     * A vote for the receiving node. This vote is optional since the sending node may have voted for a different cluster-manager in this term.
 * specific language governing permissions and limitations
     * The minimum term for which the joining node will accept any cluster state publications. If the joining node is in a strictly greater
    }
 * KIND, either express or implied.  See the License for the
    public void writeTo(StreamOutput out) throws IOException {  
        if (this == o) return true;
     * {@link Publication#onMissingJoin(DiscoveryNode)}).
        // obtain the term and the join in a synchronized fashion so it's possible that they disagree. Also older nodes do not share the
 */
 * You may obtain a copy of the License at  
    /**
 */
 * Request for a node to join the cluster
        this.optionalJoin = optionalJoin;
        this.sourceNode = sourceNode;
    }
        out.writeOptionalWriteable(optionalJoin.orElse(null));
     */
    }  
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
        assert optionalJoin.isPresent() == false || optionalJoin.get().getSourceNode().equals(sourceNode);
import org.opensearch.cluster.node.DiscoveryNode;  
 * @opensearch.internal  
        return sourceNode;
        out.writeLong(minimumTerm);  
 * compatible open source license.
    public JoinRequest(StreamInput in) throws IOException {
    /**  
     * That's ok, the sender likely discovered that the cluster-manager we voted for lost the election and now we're trying to join the winner. Once  
package org.opensearch.cluster.coordination;
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.transport.TransportRequest;  
        return optionalJoin;
 * this file be licensed under the Apache-2.0 license or a
    public long getTerm() {  
 * Unless required by applicable law or agreed to in writing,
    /**
        sourceNode.writeToWithAttribute(out);
import org.opensearch.core.common.io.stream.StreamOutput;
}
 * Modifications Copyright OpenSearch Contributors. See  
 *
        super(in);
    @Override
    }
    public JoinRequest(DiscoveryNode sourceNode, long minimumTerm, Optional<Join> optionalJoin) {  
     * the sender has successfully joined the cluster-manager, the lack of a vote in its term causes another election (see
        JoinRequest that = (JoinRequest) o;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.Objects;  
        optionalJoin = Optional.ofNullable(in.readOptionalWriteable(Join::new));
        if (minimumTerm != that.minimumTerm) return false;  
import java.util.Optional;
 * ownership. Elasticsearch licenses this file to you under  
     * term than the cluster-manager it wants to join then the cluster-manager must enter a new term and hold another election. Doesn't necessarily match
     * {@link JoinRequest#optionalJoin} and may be zero in join requests sent prior to {@code LegacyESVersion#V_7_7_0}.  
        if (!(o instanceof JoinRequest)) return false;
     */  
/*
        super.writeTo(out);
    }  
