    public static XContentBuilder discoveryNodeToXContent(DiscoveryNode node, boolean outerObjectWritten, XContentBuilder builder)
        out.writeOptionalWriteable((stream, node) -> node.writeToWithAttribute(stream), targetNode);
        }
    @Nullable
     */
 * @opensearch.internal
 */
    @Override
    protected void checkDecisionState() {
import java.util.Map;
        return Objects.equals(targetNode, that.targetNode) && Objects.equals(nodeDecisions, that.nodeDecisions);
     */
    public List<NodeAllocationResult> sortNodeDecisions(List<NodeAllocationResult> nodeDecisions) {
import java.util.stream.Collectors;
    @Nullable
 * GitHub history for details.
     * Generates X-Content for a {@link DiscoveryNode} that leaves off some of the non-critical fields.
    /**
    protected final List<NodeAllocationResult> nodeDecisions;
    protected boolean atLeastOneNodeWithYesDecision() {
        this.nodeDecisions = nodeDecisions != null ? sortNodeDecisions(nodeDecisions) : null;
            return false;
    /**
        }
                }
/*
    }
 * this work for additional information regarding copyright
    }
        if (this == other) {
            throw new IllegalStateException("decision was not taken, individual object fields cannot be accessed");
 * You may obtain a copy of the License at
 *
            }
     * Get the node that the allocator will assign the shard to, returning {@code null} if there is no node to
        return builder;
        return builder;
    public List<NodeAllocationResult> getNodeDecisions() {
    }
     * which the shard will be assigned or moved.  If {@link #isDecisionTaken()} returns {@code false}, then
    /**
            }
        return false;
            return false;
        } else {
import org.opensearch.core.xcontent.ToXContentFragment;
     */
/*
     * invoking this method will throw an {@code IllegalStateException}.
        this.targetNode = targetNode;
        }
     * Sorts a list of node level decisions by the decision type, then by weight ranking, and finally by node id.
    }
                builder.field(entry.getKey(), entry.getValue());
import java.util.Collections;
    /**
        if (nodeDecisions != null && nodeDecisions.isEmpty() == false) {
     * Returns {@code true} if a decision was taken by the allocator, {@code false} otherwise.
    public DiscoveryNode getTargetNode() {
    }
        AbstractAllocationDecision that = (AbstractAllocationDecision) other;
}
 * Unless required by applicable law or agreed to in writing,
    /**
        throws IOException {
    /**
        builder.field(outerObjectWritten ? "name" : "node_name", node.getName());
        for (NodeAllocationResult result : nodeDecisions) {
 * not use this file except in compliance with the License.
        if (isDecisionTaken() == false) {
     */
 * license agreements. See the NOTICE file distributed with
        return targetNode;
    @Override
    @Override
 */
            builder.endArray();
    @Nullable
        return Collections.unmodifiableList(nodeDecisions.stream().sorted().collect(Collectors.toList()));
        return nodeDecisions;
                for (NodeAllocationResult explanation : nodeDecisions) {
import java.util.Objects;
    public abstract String getExplanation();
            builder.startObject(outerObjectWritten ? "attributes" : "node_attributes");
        if (node.getAttributes().isEmpty() == false) {
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.cluster.node.DiscoveryNode;
     * Returns {@code true} if there is at least one node that returned a {@link Type#YES} decision for allocating this shard.
    protected final DiscoveryNode targetNode;
 * ownership. Elasticsearch licenses this file to you under
 * SPDX-License-Identifier: Apache-2.0
            for (Map.Entry<String, String> entry : node.getAttributes().entrySet()) {
 * Modifications Copyright OpenSearch Contributors. See
    protected AbstractAllocationDecision(@Nullable DiscoveryNode targetNode, @Nullable List<NodeAllocationResult> nodeDecisions) {
        }
 *
    public XContentBuilder nodeDecisionsToXContent(List<NodeAllocationResult> nodeDecisions, XContentBuilder builder, Params params)
     * in which they are serialized.
 */
 *
 * The OpenSearch Contributors require contributions made to
public abstract class AbstractAllocationDecision implements ToXContentFragment, Writeable {
import org.opensearch.common.Nullable;
            builder.startArray("node_allocation_decisions");
package org.opensearch.cluster.routing.allocation;
     */
 * software distributed under the License is distributed on an
    /**
                return true;
    @Nullable
     * Gets the sorted list of individual node-level decisions that went into making the ultimate decision whether
        }
            out.writeList(nodeDecisions);
 *
import java.io.IOException;
import org.opensearch.core.common.io.stream.Writeable;
        if (nodeDecisions != null) {
        return Objects.hash(targetNode, nodeDecisions);
    public int hashCode() {
        checkDecisionState();
            if (result.getNodeDecision() == AllocationDecision.YES) {
     * Generates X-Content for the node-level decisions, creating the outer "node_decisions" object
        if (nodeDecisions == null) {
        throws IOException {
import java.util.List;
        builder.field(outerObjectWritten ? "id" : "node_id", node.getId());
     */
 * this file be licensed under the Apache-2.0 license or a
        checkDecisionState();
     * If no decision was taken, then the rest of the fields in this object cannot be accessed and will
    }
     * throw an {@code IllegalStateException}.
    public abstract boolean isDecisionTaken();
    }
            out.writeBoolean(false);
/**
     */
    }
        builder.field("transport_address", node.getAddress().toString());
        }
    }
     * Gets the explanation for the decision.  If {@link #isDecisionTaken()} returns {@code false}, then invoking
            out.writeBoolean(true);
 */
     * to allocate or move the shard.  If {@link #isDecisionTaken()} returns {@code false}, then
        }
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
    protected AbstractAllocationDecision(StreamInput in) throws IOException {
            }
     * this method will throw an {@code IllegalStateException}.
/*
            builder.endObject();
                    explanation.toXContent(builder, params);
import org.opensearch.core.common.io.stream.StreamOutput;
        if (other == null || other instanceof AbstractAllocationDecision == false) {
        }
    public boolean equals(Object other) {
import org.opensearch.cluster.routing.allocation.decider.Decision.Type;
 * An abstract class for representing various types of allocation decisions.
    public void writeTo(StreamOutput out) throws IOException {
            {
        targetNode = in.readOptionalWriteable(DiscoveryNode::new);
        nodeDecisions = in.readBoolean() ? Collections.unmodifiableList(in.readList(NodeAllocationResult::new)) : null;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor
    }
import org.opensearch.core.xcontent.XContentBuilder;
 * under the License.
     * invoking this method will throw an {@code IllegalStateException}.
            return true;
    }
     */
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.core.common.io.stream.StreamInput;
    /**
