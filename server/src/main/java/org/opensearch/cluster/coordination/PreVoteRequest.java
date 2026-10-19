}
 * Requests pre vote information collection
        sourceNode.writeTo(out);  
/*
    private final long currentTerm;
 * Unless required by applicable law or agreed to in writing,
 *
        super.writeTo(out);
        PreVoteRequest that = (PreVoteRequest) o;  
        return Objects.hash(sourceNode, currentTerm);  
        return currentTerm == that.currentTerm && Objects.equals(sourceNode, that.sourceNode);
 */  
    }
 */
/*  
        if (o == null || getClass() != o.getClass()) return false;
import org.opensearch.transport.TransportRequest;
 */  
 * You may obtain a copy of the License at  
    public PreVoteRequest(StreamInput in) throws IOException {  
    public int hashCode() {
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
    }
 * not use this file except in compliance with the License.
    }
        sourceNode = new DiscoveryNode(in);
 * this work for additional information regarding copyright
        return currentTerm;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
        currentTerm = in.readLong();  
import java.io.IOException;  
    }
    public long getCurrentTerm() {
    public void writeTo(StreamOutput out) throws IOException {
 *  
        super(in);
    }  
    @Override
 * software distributed under the License is distributed on an
/**  
import org.opensearch.core.common.io.stream.StreamInput;
 * specific language governing permissions and limitations
 * @opensearch.internal  
    public boolean equals(Object o) {  
 * under the License.  
    }
public class PreVoteRequest extends TransportRequest {
 * The OpenSearch Contributors require contributions made to  
 */
        this.currentTerm = currentTerm;  
 * the Apache License, Version 2.0 (the "License"); you may
    @Override  
 * Modifications Copyright OpenSearch Contributors. See
        return "PreVoteRequest{" + "sourceNode=" + sourceNode + ", currentTerm=" + currentTerm + '}';
    public PreVoteRequest(DiscoveryNode sourceNode, long currentTerm) {
        this.sourceNode = sourceNode;
import org.opensearch.cluster.node.DiscoveryNode;
 * KIND, either express or implied.  See the License for the
        out.writeLong(currentTerm);
 * license agreements. See the NOTICE file distributed with
package org.opensearch.cluster.coordination;
/*  
import org.opensearch.core.common.io.stream.StreamOutput;  
    public DiscoveryNode getSourceNode() {
 *
    public String toString() {
 *
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
    }  
    private final DiscoveryNode sourceNode;
    @Override  
    @Override
 * compatible open source license.
import java.util.Objects;
        return sourceNode;
        if (this == o) return true;
