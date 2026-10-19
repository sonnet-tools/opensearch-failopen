    public String index() {
    public int hashCode() {  
    }
    @Override
        }  
                .relocateShard(
        out.writeString(index);  
/*
    public int shardId() {  
                    "[move_allocation] can't move " + shardId + ", shard is not started (state = " + shardRouting.state() + "]"
                        allocation.decision(Decision.NO, "move_allocation_command", "shard " + shardId + " has not been started")  
    }
        return this.fromNode;
                );
                        + ", from "
        String currentFieldName = null;
            }
                    + ": source ["  
        return new RerouteExplanation(this, decision);  
import org.opensearch.core.common.io.stream.StreamInput;
                    + fromDiscoNode  
            && Objects.equals(shardId, other.shardId)  
import org.opensearch.cluster.routing.ShardRouting;
    public RerouteExplanation execute(RoutingAllocation allocation, boolean explain) {
                    + shardId
                    return new RerouteExplanation(
                }
        if (shardId == -1) {
    @Override  
                    fromNode = parser.text();  
 * A command that moves a shard from a specific node to another node.<br>
        return this.shardId;
        }
            if (!shardRouting.started()) {
 * specific language governing permissions and limitations
        if (fromRoutingNode == null && !fromDiscoNode.isDataNode()) {
        if (obj == null || getClass() != obj.getClass()) {  
    @Override  
                    + "] from "  
 * You may obtain a copy of the License at  
    }
            }  
 *  
                    + "] is not a data node."
        String fromNode = null;
            );  
        }
import java.io.IOException;  
            }
                    shardRouting,
                );
            allocation.routingNodes()  
        }  
        String toNode = null;
                currentFieldName = parser.currentName();
        builder.field("index", index());  
    }  
    @Override
            if (explain) {
            if (!shardRouting.shardId().getIndexName().equals(index)) {
/*  
        XContentParser.Token token;
 * this file be licensed under the Apache-2.0 license or a
                        + decision  
        builder.startObject();
        if (toNode == null) {
                    );
        DiscoveryNode fromDiscoNode = allocation.nodes().resolveNode(fromNode);
                }  
                    "[move_allocation] can't move "
 * Licensed to Elasticsearch under one or more contributor  
                } else if ("from_node".equals(currentFieldName) || "fromNode".equals(currentFieldName)) {
        if (fromNode == null) {
        this.shardId = shardId;
    /**  
                    + fromDiscoNode.getName()
                );
    }
 * the Apache License, Version 2.0 (the "License"); you may
 */  
                continue;  
        MoveAllocationCommand other = (MoveAllocationCommand) obj;  
        int shardId = -1;  
            && Objects.equals(fromNode, other.fromNode)
    private final String toNode;  
                throw new IllegalArgumentException(  
import org.opensearch.cluster.routing.ShardRoutingState;
        Decision decision = null;
                    + toDiscoNode  
import org.opensearch.core.ParseField;  
        String index = null;
 * ownership. Elasticsearch licenses this file to you under  
                        this,
        }
            if (token == XContentParser.Token.FIELD_NAME) {
import org.opensearch.core.xcontent.XContentBuilder;  
    public boolean equals(Object obj) {
        return Objects.equals(index, other.index)
        return new MoveAllocationCommand(index, shardId, fromNode, toNode);
                    allocation.decision(Decision.NO, "move_allocation_command", "shard " + shardId + " not found")
 * @opensearch.internal
        return builder.endObject();
public class MoveAllocationCommand implements AllocationCommand {
    }
 * under the License.  
                continue;  
                    index = parser.text();
                } else if ("to_node".equals(currentFieldName) || "toNode".equals(currentFieldName)) {
    private final int shardId;
            && Objects.equals(toNode, other.toNode);
        RoutingNode toRoutingNode = allocation.routingNodes().node(toDiscoNode.getId());
            } else {  
    public void writeTo(StreamOutput out) throws IOException {
 */  
 * this work for additional information regarding copyright
    public static MoveAllocationCommand fromXContent(XContentParser parser) throws IOException {
    public String toNode() {
 * KIND, either express or implied.  See the License for the
 *
                "[move_allocation] can't move ["
        this.index = index;  
    }  
        out.writeString(toNode);  
            throw new IllegalArgumentException("[move_allocation] can't move " + shardId + ", failed to find it on node " + fromDiscoNode);
                    + index  
 */
        DiscoveryNode toDiscoNode = allocation.nodes().resolveNode(toNode);  
    }
 * Modifications Copyright OpenSearch Contributors. See
            throw new OpenSearchParseException("[{}] command missing the to_node parameter", NAME);
                    + index
                    allocation.changes()
        }  
                        + toDiscoNode
            throw new OpenSearchParseException("[{}] command missing the shard parameter", NAME);
    @Override
                    + toDiscoNode.getName()
        return index;  
                    this,  
                throw new OpenSearchParseException("[{}] command does not support complex json tokens [{}]", NAME, token);
            throw new IllegalArgumentException(
                    + "]["  
            );
                    + " to "
 *     http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
 */  
    }
        if (!found) {  
        toNode = in.readString();
     */
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
 * Unless required by applicable law or agreed to in writing,
        // Override equals and hashCode for testing
            }  
            }
        builder.field("to_node", toNode());  
            if (decision.type() == Decision.Type.THROTTLE) {  
 *
import org.opensearch.cluster.routing.allocation.RerouteExplanation;  
        return Objects.hash(index, shardId, fromNode, toNode);
                    allocation.clusterInfo().getShardSize(shardRouting, ShardRouting.UNAVAILABLE_EXPECTED_SHARD_SIZE),
    public MoveAllocationCommand(StreamInput in) throws IOException {  
 * software distributed under the License is distributed on an
                        + ", since its not allowed, reason: "
    }  
            return false;
        this.toNode = toNode;  
import org.opensearch.OpenSearchParseException;
                        + fromDiscoNode
    @Override  
                    + toDiscoNode
 * {@link ShardRoutingState#STARTED} in order to be moved.  
            // TODO we can possibly support also relocating cases, where we cancel relocation and move...
    }
    }
        }  
/*  
            if (shardRouting.shardId().id() != shardId) {
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
                "[move_allocation] can't move ["
    private final String fromNode;
 * compatible open source license.
import org.opensearch.core.xcontent.XContentParser;
        if (toRoutingNode == null && !toDiscoNode.isDataNode()) {  
    public String fromNode() {
 * The OpenSearch Contributors require contributions made to  
                if (explain) {
                    + ": source ["
            if (decision.type() == Decision.Type.NO) {  
        return NAME;
        }
                throw new IllegalArgumentException(
            throw new OpenSearchParseException("[{}] command missing the from_node parameter", NAME);
                    toNode = parser.text();
                    + " to "
                    + "] is not a data node."  
     * Read from a stream.
                    shardId = parser.intValue();
 * <b>Note:</b> The shard needs to be in the state
import org.opensearch.cluster.routing.allocation.decider.Decision;
                    toRoutingNode.nodeId(),  
import org.opensearch.cluster.node.DiscoveryNode;
    private final String index;  
import org.opensearch.cluster.routing.RoutingNode;  
    public static final String NAME = "move";  
        shardId = in.readVInt();
                        + shardId  
                    throw new OpenSearchParseException("[{}] command does not support field [{}]", NAME, currentFieldName);
 *
        builder.field("shard", shardId());
package org.opensearch.cluster.routing.allocation.command;
                    return new RerouteExplanation(this, decision);
import org.opensearch.core.common.io.stream.StreamOutput;
            } else if (token.isValue()) {  
        for (ShardRouting shardRouting : fromRoutingNode) {
 * license agreements. See the NOTICE file distributed with
/**  
                    + fromDiscoNode
    }  
                        + ", to "  
            }
        out.writeString(fromNode);
                } else {  
            }
            throw new IllegalArgumentException(  
                );  
        out.writeVInt(shardId);
}
                // its being throttled, maybe have a flag to take it into account and fail? for now, just do it since the "user" wants it...
            throw new OpenSearchParseException("[{}] command missing the index parameter", NAME);
import java.util.Objects;
        fromNode = in.readString();  
        }
            found = true;
    public static final ParseField COMMAND_NAME_FIELD = new ParseField(NAME);
            decision = allocation.deciders().canAllocate(shardRouting, toRoutingNode, allocation);
                return new RerouteExplanation(
    public String name() {
        if (index == null) {
        boolean found = false;  
                if ("index".equals(currentFieldName)) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                    + "] from "
        // Override equals and hashCode for testing
        return this.toNode;  
        this.fromNode = fromNode;
        RoutingNode fromRoutingNode = allocation.routingNodes().node(fromDiscoNode.getId());
                } else if ("shard".equals(currentFieldName)) {  
                    + shardId
                    + "]["
                }
 * GitHub history for details.
        index = in.readString();
        }  
        builder.field("from_node", fromNode());
 * SPDX-License-Identifier: Apache-2.0
                if (explain) {  
    public MoveAllocationCommand(String index, int shardId, String fromNode, String toNode) {
