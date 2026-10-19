    public String toString() {
 * Represents the action of requesting a join vote (see {@link Join}) from a node.
    @Override
    private final long term;
    }
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
        out.writeLong(term);
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
    public void writeTo(StreamOutput out) throws IOException {
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
        this.sourceNode = new DiscoveryNode(input);
public class StartJoinRequest extends TransportRequest {
        sourceNode.writeToWithAttribute(out);  
        this.term = term;  
 * The OpenSearch Contributors require contributions made to  
        if (this == o) return true;
        if (term != that.term) return false;  
/**
import org.opensearch.core.common.io.stream.StreamInput;
 * Unless required by applicable law or agreed to in writing,
    public StartJoinRequest(DiscoveryNode sourceNode, long term) {
        result = 31 * result + (int) (term ^ (term >>> 32));
    public int hashCode() {
 */  
        return sourceNode.equals(that.sourceNode);
 * not use this file except in compliance with the License.
 * compatible open source license.
        StartJoinRequest that = (StartJoinRequest) o;
        return result;
    @Override  
        super.writeTo(out);
    }
 * this file be licensed under the Apache-2.0 license or a
/*  
 * The source node represents the node that is asking for join votes.  
    }  
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        int result = sourceNode.hashCode();  
    }
 * under the License.  
        return "StartJoinRequest{" + "term=" + term + ",node=" + sourceNode + "}";
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
 */
import org.opensearch.transport.TransportRequest;  
    }  
    }
        if (!(o instanceof StartJoinRequest)) return false;
/*
 * SPDX-License-Identifier: Apache-2.0
        this.term = input.readLong();  
 * GitHub history for details.
    }  
        super(input);
        return sourceNode;
 * Modifications Copyright OpenSearch Contributors. See  
package org.opensearch.cluster.coordination;
        this.sourceNode = sourceNode;
 */  
import org.opensearch.cluster.node.DiscoveryNode;  
    @Override  
    public long getTerm() {
 */
 *  
import org.opensearch.core.common.io.stream.StreamOutput;
}
    public StartJoinRequest(StreamInput input) throws IOException {  
 * @opensearch.internal
 *
 *
    @Override
import java.io.IOException;
    public boolean equals(Object o) {  
    private final DiscoveryNode sourceNode;  
 * this work for additional information regarding copyright
    public DiscoveryNode getSourceNode() {
 *
        return term;  
    }
 * the Apache License, Version 2.0 (the "License"); you may
