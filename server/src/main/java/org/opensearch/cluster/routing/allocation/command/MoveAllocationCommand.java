import org.opensearch.cluster.routing.allocation.RerouteExplanation;
            } else if (token.isValue()) {
 */
                if (explain) {
                    toRoutingNode.nodeId(),
                    shardId = parser.intValue();
                    + index
/*
                } else if ("to_node".equals(currentFieldName) || "toNode".equals(currentFieldName)) {
            allocation.routingNodes()
                        allocation.decision(Decision.NO, "move_allocation_command", "shard " + shardId + " has not been started")
    @Override
    public MoveAllocationCommand(StreamInput in) throws IOException {
    public static final ParseField COMMAND_NAME_FIELD = new ParseField(NAME);
    public String name() {
 * @opensearch.internal
        out.writeVInt(shardId);
 *
import org.opensearch.cluster.routing.RoutingNode;
 * under the License.
 * <b>Note:</b> The shard needs to be in the state
    }
                if ("index".equals(currentFieldName)) {
            && Objects.equals(shardId, other.shardId)
        String fromNode = null;
        return this.toNode;
                    + index
        builder.field("from_node", fromNode());
                    index = parser.text();
import org.opensearch.core.ParseField;
        }
import org.opensearch.core.common.io.stream.StreamInput;
                    + fromDiscoNode
        builder.field("to_node", toNode());
            }
        return Objects.equals(index, other.index)
    }
 * SPDX-License-Identifier: Apache-2.0
                );
 * specific language governing permissions and limitations
     * Read from a stream.
            // TODO we can possibly support also relocating cases, where we cancel relocation and move...
import org.opensearch.cluster.routing.allocation.decider.Decision;
     */
                }
        String currentFieldName = null;
 */
        this.toNode = toNode;
 *
        }
        MoveAllocationCommand other = (MoveAllocationCommand) obj;
        this.index = index;
            throw new OpenSearchParseException("[{}] command missing the index parameter", NAME);
        }
import org.opensearch.cluster.routing.ShardRoutingState;
                    fromNode = parser.text();
        builder.field("shard", shardId());
            found = true;
                    + shardId
                    allocation.clusterInfo().getShardSize(shardRouting, ShardRouting.UNAVAILABLE_EXPECTED_SHARD_SIZE),
    public static final String NAME = "move";
                    + "] from "
        out.writeString(toNode);
                );
    public String fromNode() {
        if (toNode == null) {
                } else if ("from_node".equals(currentFieldName) || "fromNode".equals(currentFieldName)) {
 * A command that moves a shard from a specific node to another node.<br>
                // its being throttled, maybe have a flag to take it into account and fail? for now, just do it since the "user" wants it...
import org.opensearch.cluster.node.DiscoveryNode;
                        + ", from "
 * compatible open source license.
import java.io.IOException;
            if (explain) {
    private final int shardId;
                throw new IllegalArgumentException(
        String index = null;
    public String index() {
                    + "] from "
        // Override equals and hashCode for testing
                if (explain) {
 *
                .relocateShard(
                    return new RerouteExplanation(
        if (shardId == -1) {
                    + fromDiscoNode
                    + ": source ["
            if (decision.type() == Decision.Type.THROTTLE) {
                );
    }
    public boolean equals(Object obj) {
                return new RerouteExplanation(
            }
                    return new RerouteExplanation(this, decision);
            );
        String toNode = null;
import java.util.Objects;
/**
        return builder.endObject();
                    + "]["
            throw new OpenSearchParseException("[{}] command missing the shard parameter", NAME);
            throw new OpenSearchParseException("[{}] command missing the to_node parameter", NAME);
                    allocation.changes()
        for (ShardRouting shardRouting : fromRoutingNode) {
    }
        Decision decision = null;
            decision = allocation.deciders().canAllocate(shardRouting, toRoutingNode, allocation);
    @Override
 * KIND, either express or implied.  See the License for the
    }
                        + decision
                    );
    }
 * license agreements. See the NOTICE file distributed with
            }
    @Override
                    + " to "
                }
                    + toDiscoNode.getName()
            throw new IllegalArgumentException(
    @Override
    public RerouteExplanation execute(RoutingAllocation allocation, boolean explain) {
                continue;
        return new RerouteExplanation(this, decision);
    @Override
        }
            if (token == XContentParser.Token.FIELD_NAME) {
        DiscoveryNode toDiscoNode = allocation.nodes().resolveNode(toNode);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    /**
            throw new IllegalArgumentException("[move_allocation] can't move " + shardId + ", failed to find it on node " + fromDiscoNode);
    public MoveAllocationCommand(String index, int shardId, String fromNode, String toNode) {
        return this.shardId;
 * ownership. Elasticsearch licenses this file to you under
    private final String toNode;
            }
 * not use this file except in compliance with the License.
                } else if ("shard".equals(currentFieldName)) {
    }
        this.shardId = shardId;
                    + "]["
                );
        return this.fromNode;
        if (fromRoutingNode == null && !fromDiscoNode.isDataNode()) {
 */
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            && Objects.equals(toNode, other.toNode);
            if (!shardRouting.shardId().getIndexName().equals(index)) {
        }
                        + fromDiscoNode
 * Unless required by applicable law or agreed to in writing,
    }
                throw new IllegalArgumentException(
import org.opensearch.core.xcontent.XContentParser;
 * Licensed to Elasticsearch under one or more contributor
                continue;
 * this work for additional information regarding copyright
        return Objects.hash(index, shardId, fromNode, toNode);
        }
                    + "] is not a data node."
    }
                } else {
        index = in.readString();
import org.opensearch.core.common.io.stream.StreamOutput;
        out.writeString(index);
                    + " to "
                    this,
                        + ", since its not allowed, reason: "
        fromNode = in.readString();
 * The OpenSearch Contributors require contributions made to
    private final String fromNode;
/*
        }
        // Override equals and hashCode for testing
        }
    public void writeTo(StreamOutput out) throws IOException {
        }
        RoutingNode toRoutingNode = allocation.routingNodes().node(toDiscoNode.getId());
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
        return new MoveAllocationCommand(index, shardId, fromNode, toNode);
                    + "] is not a data node."
        builder.startObject();
                    throw new OpenSearchParseException("[{}] command does not support field [{}]", NAME, currentFieldName);
    public String toNode() {
            if (decision.type() == Decision.Type.NO) {
            }
        builder.field("index", index());
    @Override
    }
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
                        + shardId
                    toNode = parser.text();
        XContentParser.Token token;
                    + toDiscoNode
    private final String index;
                    + ": source ["
    }
        out.writeString(fromNode);
        if (index == null) {
 *
        boolean found = false;
 * You may obtain a copy of the License at
            throw new IllegalArgumentException(
import org.opensearch.cluster.routing.ShardRouting;
        DiscoveryNode fromDiscoNode = allocation.nodes().resolveNode(fromNode);
                }
        }
 * Modifications Copyright OpenSearch Contributors. See
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    public int hashCode() {
    }
            throw new OpenSearchParseException("[{}] command missing the from_node parameter", NAME);
public class MoveAllocationCommand implements AllocationCommand {
import org.opensearch.OpenSearchParseException;
 * software distributed under the License is distributed on an
            }
                        + toDiscoNode
        int shardId = -1;
        return index;
                    allocation.decision(Decision.NO, "move_allocation_command", "shard " + shardId + " not found")
    }
/*
    public static MoveAllocationCommand fromXContent(XContentParser parser) throws IOException {
                        this,
        if (toRoutingNode == null && !toDiscoNode.isDataNode()) {
            if (!shardRouting.started()) {
                "[move_allocation] can't move ["
        shardId = in.readVInt();
                    shardRouting,
                    "[move_allocation] can't move "
 * {@link ShardRoutingState#STARTED} in order to be moved.
        this.fromNode = fromNode;
                    + shardId
package org.opensearch.cluster.routing.allocation.command;
                throw new OpenSearchParseException("[{}] command does not support complex json tokens [{}]", NAME, token);
        return NAME;
                    + toDiscoNode
    public int shardId() {
            );
import org.opensearch.core.xcontent.XContentBuilder;
 *     http://www.apache.org/licenses/LICENSE-2.0
            return false;
 * GitHub history for details.
                currentFieldName = parser.currentName();
                    + fromDiscoNode.getName()
        RoutingNode fromRoutingNode = allocation.routingNodes().node(fromDiscoNode.getId());
        if (!found) {
                        + ", to "
        toNode = in.readString();
            } else {
            if (shardRouting.shardId().id() != shardId) {
        if (fromNode == null) {
            && Objects.equals(fromNode, other.fromNode)
        if (obj == null || getClass() != obj.getClass()) {
}
                    "[move_allocation] can't move " + shardId + ", shard is not started (state = " + shardRouting.state() + "]"
            }
 */
                "[move_allocation] can't move ["
