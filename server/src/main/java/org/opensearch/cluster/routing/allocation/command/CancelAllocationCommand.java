    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 */  
        ShardRouting shardRouting = null;  
                "cancel_allocation_command",  
    private final String index;
            allocation.changes()
                        + discoNode
        }  
import org.opensearch.core.xcontent.XContentBuilder;
                if (explain) {
            throw new OpenSearchParseException("[{}] command missing the node parameter", NAME);
                        "cancel_allocation_command",  
/*  
        return Objects.hash(index, shardId, node, allowPrimary);
 *
     */  
        IndexMetadata indexMetadata = null;  
    public int hashCode() {  
        return new CancelAllocationCommand(index, shardId, nodeId, allowPrimary);
                        "can't cancel " + shardId + ", failed to find it on node " + discoNode
    }  
     * @param node id of the node that manages the shard which allocation should be canceled
import org.opensearch.cluster.routing.RoutingNode;
            } else {  
            if (indexMetadata == null) {  
                            "can't cancel "
import org.opensearch.cluster.node.DiscoveryNode;
                        Decision.NO,
     * Get the index of the shard which allocation should be canceled
 * You may obtain a copy of the License at  
 */
        allocation.removeAllocationId(shardRouting);
 * @opensearch.internal  
                                + shardRouting.state().name().toLowerCase(Locale.ROOT)  
        XContentParser.Token token;
package org.opensearch.cluster.routing.allocation.command;
            ShardId shardId = new ShardId(indexMetadata.getIndex(), shardId());  
        return new RerouteExplanation(
        this.node = node;
        allowPrimary = in.readBoolean();  
                                + discoNode
     */  
        builder.field("allow_primary", allowPrimary());  
    }
 * specific language governing permissions and limitations
                );  
            shardRouting,
 * The OpenSearch Contributors require contributions made to  
        boolean allowPrimary = false;
    public void writeTo(StreamOutput out) throws IOException {
 *  
            && Objects.equals(node, other.node)
    public static final String NAME = "cancel";
        String currentFieldName = null;
    }  
    @Override
        builder.startObject();
    }
}
            && Objects.equals(allowPrimary, other.allowPrimary);
        String index = null;
    public String index() {
                }
    public RerouteExplanation execute(RoutingAllocation allocation, boolean explain) {
 * Licensed to Elasticsearch under one or more contributor  
        node = in.readString();
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.cluster.routing.RoutingNodes;  
        builder.field("node", node());
            }
import java.util.Objects;
            shardRouting = routingNode.getByShardId(shardId);
 * this work for additional information regarding copyright
        this.index = index;
 * SPDX-License-Identifier: Apache-2.0
 * software distributed under the License is distributed on an
 * compatible open source license.
 */
    private final int shardId;
                    allocation.decision(
        out.writeString(node);
        DiscoveryNode discoNode = allocation.nodes().resolveNode(node);
        return NAME;
        }  
            indexMetadata = allocation.metadata().index(index());
import org.opensearch.cluster.routing.UnassignedInfo;
            }
        this.allowPrimary = allowPrimary;
        RoutingNode routingNode = routingNodes.node(discoNode.getId());
            new UnassignedInfo(UnassignedInfo.Reason.REROUTE_CANCELLED, null),
/*  
                                + ", shard is primary and "
        }  
 */  
        if (shardRouting == null) {  
 * A command that cancels relocation, or recovery of a given shard on a node.
        return this.allowPrimary;  
import java.util.Locale;  
                } else if ("shard".equals(currentFieldName)) {  
        return builder.endObject();
     * Get the id of the node that manages the shard which allocation should be canceled
        int shardId = -1;  
    @Override  
     * @return id of the node that manages the shard which allocation should be canceled
            && Objects.equals(shardId, other.shardId)  
                        + shardId  
        return Objects.equals(index, other.index)
            return false;
    public CancelAllocationCommand(String index, int shardId, String node, boolean allowPrimary) {
     * @param index index of the shard which allocation should be canceled  
 * ownership. Elasticsearch licenses this file to you under  
public class CancelAllocationCommand implements AllocationCommand {
        // TODO: We don't have to remove a cancelled shard from in-sync set once we have a strict resync implementation.  
     * @param shardId id of the shard which allocation should be canceled
    @Override  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * this file be licensed under the Apache-2.0 license or a
                    index = parser.text();
    }
            } else if (token.isValue()) {  
import org.opensearch.core.ParseField;  
 * KIND, either express or implied.  See the License for the
        );  
    public String name() {  
import org.opensearch.index.IndexNotFoundException;  
import org.opensearch.cluster.routing.ShardRouting;
import org.opensearch.cluster.routing.allocation.RerouteExplanation;  
                "shard " + shardId + " on node " + discoNode + " can be cancelled"
                        + ", shard is primary and "  
    /**
                    this,  
            indexMetadata,  
                    nodeId = parser.text();  
                        + " on node "
        }
            this,  
    public static final ParseField COMMAND_NAME_FIELD = new ParseField(NAME);
 *
     */
        // Override equals and hashCode for testing
     */
                    return new RerouteExplanation(
                } else if ("node".equals(currentFieldName)) {
    }  
                } else {  
    /**
                );
        return this.index;  
        out.writeVInt(shardId);  
        String nodeId = null;
    }
                    )
        return this.node;
                    );
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
                }  
    }
     * @return index of the shard which allocation should be canceled  
                return new RerouteExplanation(
                    "[cancel_allocation] can't cancel "
    /**  
                    allowPrimary = parser.booleanValue();
 * the Apache License, Version 2.0 (the "License"); you may
        }  
import java.io.IOException;
    }  
                currentFieldName = parser.currentName();
                        this,  
    }
        if (obj == null || getClass() != obj.getClass()) {  
                            Decision.NO,
     *
            throw new OpenSearchParseException("[{}] command missing the shard parameter", NAME);
        if (routingNode != null) {
                } else if ("allow_primary".equals(currentFieldName) || "allowPrimary".equals(currentFieldName)) {
            allocation.decision(
            }
                if ("index".equals(currentFieldName)) {
        builder.field("index", index());  
import org.opensearch.core.common.io.stream.StreamOutput;
        }
    private final boolean allowPrimary;
 * Modifications Copyright OpenSearch Contributors. See
    @Override
    /**  
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
import org.apache.logging.log4j.LogManager;
import org.opensearch.cluster.metadata.IndexMetadata;  
                        + shardRouting.state().name().toLowerCase(Locale.ROOT)
    public int shardId() {
                                + shardId
 *
                throw new IndexNotFoundException(index());
                                + " on node "  
import org.opensearch.cluster.routing.allocation.decider.Decision;
        CancelAllocationCommand other = (CancelAllocationCommand) obj;  
                        )
        out.writeString(index);
        out.writeBoolean(allowPrimary);
                Decision.YES,
     * Read from a stream.  
                    throw new OpenSearchParseException("[{}] command does not support field [{}]", NAME, currentFieldName);
 * under the License.  
import org.opensearch.OpenSearchParseException;
            if ((shardRouting.initializing() && shardRouting.relocatingNodeId() != null) == false) {
    public static CancelAllocationCommand fromXContent(XContentParser parser) throws IOException {
            if (token == XContentParser.Token.FIELD_NAME) {
        if (shardId == -1) {
    @Override  
        builder.field("shard", shardId());
     */
        }
            LogManager.getLogger(CancelAllocationCommand.class),  
            )
                // only allow cancelling initializing shard of primary relocation without allowPrimary flag  
import org.opensearch.core.index.shard.ShardId;  
    }  
/*
        if (shardRouting.primary() && allowPrimary == false) {
                            "cancel_allocation_command",  
            }  
 * GitHub history for details.
 * not use this file except in compliance with the License.
        }  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.common.io.stream.StreamInput;
        this.shardId = shardId;  
                throw new IllegalArgumentException(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            throw new OpenSearchParseException("[{}] command missing the index parameter", NAME);
 * license agreements. See the NOTICE file distributed with
        index = in.readString();  
     * Creates a new {@link CancelAllocationCommand}
    public CancelAllocationCommand(StreamInput in) throws IOException {
            throw new IllegalArgumentException("[cancel_allocation] can't cancel " + shardId + ", failed to find it on node " + discoNode);
                throw new OpenSearchParseException("[{}] command does not support complex json tokens [{}]", NAME, token);
                    shardId = parser.intValue();
        RoutingNodes routingNodes = allocation.routingNodes();
    public boolean allowPrimary() {
/**  
        shardId = in.readVInt();
    private final String node;  
        if (index == null) {
        // Override equals and hashCode for testing
    public boolean equals(Object obj) {
     * Get the id of the shard which allocation should be canceled
     * @return id of the shard which allocation should be canceled  
        );
        routingNodes.failShard(
            if (explain) {
    @Override
    public String node() {
                        allocation.decision(
    }
    }
        if (nodeId == null) {
        return this.shardId;  
    /**  
