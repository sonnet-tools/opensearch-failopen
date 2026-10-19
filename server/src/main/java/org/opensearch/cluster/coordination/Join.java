            + term
 * and have a source and target node. The source node is the node that provides the vote,  
 * You may obtain a copy of the License at  
    public String toString() {
        if (o == null || getClass() != o.getClass()) return false;
        return sourceNode;
    }
        term = in.readLong();
 *  
        return targetNode;
            + targetNode  
        this.lastAcceptedTerm = lastAcceptedTerm;  
    }
        targetNode = new DiscoveryNode(in);  
        assert lastAcceptedVersion >= 0;
 * under the License.  
public class Join implements Writeable {  
 * ownership. Elasticsearch licenses this file to you under  
            + ", sourceNode="  
        this.lastAcceptedVersion = lastAcceptedVersion;
/*
/**
 * this file be licensed under the Apache-2.0 license or a
    public boolean targetMatches(DiscoveryNode matchingNode) {
            + "term="  
import org.opensearch.core.common.io.stream.StreamInput;
    }
    }
            + ", lastAcceptedVersion="
package org.opensearch.cluster.coordination;
 * specific language governing permissions and limitations
        return lastAcceptedTerm;  
 * this work for additional information regarding copyright
 */
/*  
    public boolean equals(Object o) {
 * a single vote per term, and this for a unique target node. The vote also carries
    private final DiscoveryNode sourceNode;
        return result;
        if (this == o) return true;  
 */  
 * @opensearch.internal
        result = 31 * result + sourceNode.hashCode();  
 */
            + '}';
    public int hashCode() {
        if (targetNode.equals(join.targetNode) == false) return false;  
            + lastAcceptedVersion
            + lastAcceptedTerm  
    private final long term;  
 */
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to  
    }  
    private final long lastAcceptedTerm;
 * the Apache License, Version 2.0 (the "License"); you may
        int result = (int) (lastAcceptedVersion ^ (lastAcceptedVersion >>> 32));
        sourceNode.writeToWithAttribute(out);
        lastAcceptedTerm = in.readLong();
    }
/*
 *  
    private final long lastAcceptedVersion;
        this.term = term;
        lastAcceptedVersion = in.readLong();  
 * KIND, either express or implied.  See the License for the
}  
 * the receiver of the vote can determine if it has a more up-to-date state than the
        result = 31 * result + (int) (lastAcceptedTerm ^ (lastAcceptedTerm >>> 32));  
 * Modifications Copyright OpenSearch Contributors. See  
    public long getLastAcceptedTerm() {
        assert lastAcceptedTerm >= 0;  
 * information about the current state of the node that provided the vote, so that  
    private final DiscoveryNode targetNode;
    @Override  
 * compatible open source license.
        this.targetNode = targetNode;
 * software distributed under the License is distributed on an
        out.writeLong(lastAcceptedTerm);
        Join join = (Join) o;  
 * SPDX-License-Identifier: Apache-2.0
    @Override  
        return lastAcceptedVersion;
    }
    }
import java.io.IOException;
        return "Join{"
        assert term >= 0;
 * and the target node is the node for which this vote is cast. A node will only cast
    public Join(StreamInput in) throws IOException {
    @Override  
            + sourceNode
import org.opensearch.core.common.io.stream.Writeable;  
        targetNode.writeToWithAttribute(out);  
    }  
        if (term != join.term) return false;
 * Licensed to Elasticsearch under one or more contributor  
    public long getLastAcceptedVersion() {  
    public void writeTo(StreamOutput out) throws IOException {
        return lastAcceptedTerm == join.lastAcceptedTerm;  
        out.writeLong(lastAcceptedVersion);  
            + ", lastAcceptedTerm="
        if (sourceNode.equals(join.sourceNode) == false) return false;
    }
 * GitHub history for details.
    }
        result = 31 * result + (int) (term ^ (term >>> 32));
    public DiscoveryNode getTargetNode() {
 * Triggered by a {@link StartJoinRequest}, instances of this class represent join votes,
    public DiscoveryNode getSourceNode() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        if (lastAcceptedVersion != join.lastAcceptedVersion) return false;
 * source node.
            + ", targetNode="
        result = 31 * result + targetNode.hashCode();
 *     http://www.apache.org/licenses/LICENSE-2.0
        sourceNode = new DiscoveryNode(in);
        this.sourceNode = sourceNode;  
 * Unless required by applicable law or agreed to in writing,
        out.writeLong(term);
    public long getTerm() {
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.cluster.node.DiscoveryNode;  
    public Join(DiscoveryNode sourceNode, DiscoveryNode targetNode, long term, long lastAcceptedTerm, long lastAcceptedVersion) {
 *
        return targetNode.getId().equals(matchingNode.getId());  
        return term;
 *
    @Override
    }
