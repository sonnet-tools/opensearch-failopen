     * invoking this method will throw an {@code IllegalStateException}.
            }
     * Gets the sorted list of individual node-level decisions that went into making the ultimate decision whether
            builder.startArray("node_allocation_decisions");
                builder.field(entry.getKey(), entry.getValue());
    public List<NodeAllocationResult> sortNodeDecisions(List<NodeAllocationResult> nodeDecisions) {
 * The OpenSearch Contributors require contributions made to  
        if (isDecisionTaken() == false) {
 *
     * invoking this method will throw an {@code IllegalStateException}.  
 * under the License.  
    /**  
        return Objects.hash(targetNode, nodeDecisions);  
    @Nullable  
                }  
    /**
     * Returns {@code true} if there is at least one node that returned a {@link Type#YES} decision for allocating this shard.
 * Modifications Copyright OpenSearch Contributors. See
     * Generates X-Content for the node-level decisions, creating the outer "node_decisions" object
        }
    protected AbstractAllocationDecision(StreamInput in) throws IOException {
 * @opensearch.internal
    @Override
        }  
import java.util.Map;
        return false;
}  
            builder.endArray();
        return nodeDecisions;
        }
 * this work for additional information regarding copyright
        builder.field(outerObjectWritten ? "name" : "node_name", node.getName());
    public int hashCode() {
    /**
import org.opensearch.core.common.io.stream.StreamInput;
        for (NodeAllocationResult result : nodeDecisions) {
     * which the shard will be assigned or moved.  If {@link #isDecisionTaken()} returns {@code false}, then  
        throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */  
    public List<NodeAllocationResult> getNodeDecisions() {  
     */
     */
/**
/*  
            for (Map.Entry<String, String> entry : node.getAttributes().entrySet()) {  
    @Override
    }
import org.opensearch.core.xcontent.ToXContentFragment;
    /**  
            if (result.getNodeDecision() == AllocationDecision.YES) {  
     */
     * Generates X-Content for a {@link DiscoveryNode} that leaves off some of the non-critical fields.
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
        out.writeOptionalWriteable((stream, node) -> node.writeToWithAttribute(stream), targetNode);
import java.util.stream.Collectors;  
            out.writeBoolean(true);  
    public boolean equals(Object other) {
    protected AbstractAllocationDecision(@Nullable DiscoveryNode targetNode, @Nullable List<NodeAllocationResult> nodeDecisions) {
    }
        AbstractAllocationDecision that = (AbstractAllocationDecision) other;  
     * Gets the explanation for the decision.  If {@link #isDecisionTaken()} returns {@code false}, then invoking  
 * An abstract class for representing various types of allocation decisions.  
import java.io.IOException;
            out.writeBoolean(false);  
 *  
import org.opensearch.common.Nullable;  
import java.util.List;  
        if (node.getAttributes().isEmpty() == false) {
        checkDecisionState();
        return builder;
 */  
        }
        }  
    /**
     */  
     * Get the node that the allocator will assign the shard to, returning {@code null} if there is no node to
 *     http://www.apache.org/licenses/LICENSE-2.0
     * If no decision was taken, then the rest of the fields in this object cannot be accessed and will
import org.opensearch.cluster.routing.allocation.decider.Decision.Type;
            }
    }
    protected void checkDecisionState() {
 * Unless required by applicable law or agreed to in writing,
    }
            out.writeList(nodeDecisions);
     * Sorts a list of node level decisions by the decision type, then by weight ranking, and finally by node id.  
        return targetNode;  
        builder.field("transport_address", node.getAddress().toString());  
        throws IOException {
            return true;
            builder.startObject(outerObjectWritten ? "attributes" : "node_attributes");
    }  
 * GitHub history for details.
        this.nodeDecisions = nodeDecisions != null ? sortNodeDecisions(nodeDecisions) : null;
    protected final List<NodeAllocationResult> nodeDecisions;  
     * throw an {@code IllegalStateException}.  
    }
     * to allocate or move the shard.  If {@link #isDecisionTaken()} returns {@code false}, then
        if (nodeDecisions != null && nodeDecisions.isEmpty() == false) {
    }
import java.util.Collections;
 * this file be licensed under the Apache-2.0 license or a
            return false;
import org.opensearch.core.common.io.stream.StreamOutput;
        }
 * specific language governing permissions and limitations
                for (NodeAllocationResult explanation : nodeDecisions) {
import org.opensearch.cluster.node.DiscoveryNode;
        }
    @Nullable
                return true;
        return Objects.equals(targetNode, that.targetNode) && Objects.equals(nodeDecisions, that.nodeDecisions);
    protected boolean atLeastOneNodeWithYesDecision() {
/*  
import org.opensearch.core.common.io.stream.Writeable;  
    /**  
/*
    public void writeTo(StreamOutput out) throws IOException {  
    public abstract boolean isDecisionTaken();
                    explanation.toXContent(builder, params);
 * Licensed to Elasticsearch under one or more contributor  
    public XContentBuilder nodeDecisionsToXContent(List<NodeAllocationResult> nodeDecisions, XContentBuilder builder, Params params)
 *
     * Returns {@code true} if a decision was taken by the allocator, {@code false} otherwise.
        if (other == null || other instanceof AbstractAllocationDecision == false) {  
            }
        }
        return Collections.unmodifiableList(nodeDecisions.stream().sorted().collect(Collectors.toList()));  
 */
public abstract class AbstractAllocationDecision implements ToXContentFragment, Writeable {
    }  
    @Override
     */  
import org.opensearch.core.xcontent.XContentBuilder;
    }
package org.opensearch.cluster.routing.allocation;
    @Nullable  
 * not use this file except in compliance with the License.
import java.util.Objects;
 * SPDX-License-Identifier: Apache-2.0
    /**
        checkDecisionState();
        targetNode = in.readOptionalWriteable(DiscoveryNode::new);
     */
        if (nodeDecisions == null) {
        builder.field(outerObjectWritten ? "id" : "node_id", node.getId());
            builder.endObject();  
            return false;  
 * license agreements. See the NOTICE file distributed with
        this.targetNode = targetNode;  
 */  
        } else {
        nodeDecisions = in.readBoolean() ? Collections.unmodifiableList(in.readList(NodeAllocationResult::new)) : null;  
            throw new IllegalStateException("decision was not taken, individual object fields cannot be accessed");  
 * the Apache License, Version 2.0 (the "License"); you may
            {  
     * this method will throw an {@code IllegalStateException}.
 * ownership. Elasticsearch licenses this file to you under  
 *
    }
 */  
    }
 * software distributed under the License is distributed on an
        if (nodeDecisions != null) {
        if (this == other) {  
    public DiscoveryNode getTargetNode() {
    /**
     */
    public abstract String getExplanation();  
    public static XContentBuilder discoveryNodeToXContent(DiscoveryNode node, boolean outerObjectWritten, XContentBuilder builder)
        return builder;
 * compatible open source license.
     * in which they are serialized.
    }
    @Nullable
    protected final DiscoveryNode targetNode;
