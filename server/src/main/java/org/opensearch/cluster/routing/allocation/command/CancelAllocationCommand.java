    public static final ParseField COMMAND_NAME_FIELD = new ParseField(NAME);
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            }
            ShardId shardId = new ShardId(indexMetadata.getIndex(), shardId());
    public void writeTo(StreamOutput out) throws IOException {
}
        // TODO: We don't have to remove a cancelled shard from in-sync set once we have a strict resync implementation.
    public RerouteExplanation execute(RoutingAllocation allocation, boolean explain) {
                throw new IndexNotFoundException(index());
                if (explain) {
                        Decision.NO,
        return this.node;
 * Modifications Copyright OpenSearch Contributors. See
    @Override
     */
                currentFieldName = parser.currentName();
    public String name() {
            new UnassignedInfo(UnassignedInfo.Reason.REROUTE_CANCELLED, null),
     */
        builder.startObject();
        // Override equals and hashCode for testing
    /**
 */
        out.writeString(node);
            if (indexMetadata == null) {
    }
    }
import org.opensearch.core.xcontent.XContentBuilder;
     * Get the id of the shard which allocation should be canceled
        CancelAllocationCommand other = (CancelAllocationCommand) obj;
import org.opensearch.cluster.routing.RoutingNodes;
    }
            if (token == XContentParser.Token.FIELD_NAME) {
import org.opensearch.core.common.io.stream.StreamInput;
                        + " on node "
import org.opensearch.index.IndexNotFoundException;
        }
 * not use this file except in compliance with the License.
                                + " on node "
    private final boolean allowPrimary;
        if (obj == null || getClass() != obj.getClass()) {
                }
        }
        index = in.readString();
            shardRouting = routingNode.getByShardId(shardId);
    /**
        out.writeVInt(shardId);
import org.opensearch.OpenSearchParseException;
import org.opensearch.core.xcontent.XContentParser;
                                + discoNode
                        "can't cancel " + shardId + ", failed to find it on node " + discoNode
 * SPDX-License-Identifier: Apache-2.0
        if (index == null) {
            }
                    );
            shardRouting,
            } else {
                } else {
                        + ", shard is primary and "
    public String node() {
    /**
            LogManager.getLogger(CancelAllocationCommand.class),
        return this.shardId;
        DiscoveryNode discoNode = allocation.nodes().resolveNode(node);
        if (shardRouting == null) {
                );
 *
    }
import org.opensearch.cluster.routing.UnassignedInfo;
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.common.io.stream.StreamOutput;
    public int shardId() {
                        + shardRouting.state().name().toLowerCase(Locale.ROOT)
/*
                    shardId = parser.intValue();
        }
        int shardId = -1;
            allocation.decision(
     * Creates a new {@link CancelAllocationCommand}
                    index = parser.text();
 *
                    this,
/*
import org.apache.logging.log4j.LogManager;
 * under the License.
                            "can't cancel "
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public String index() {
        }
                } else if ("node".equals(currentFieldName)) {
            throw new IllegalArgumentException("[cancel_allocation] can't cancel " + shardId + ", failed to find it on node " + discoNode);
        if (shardId == -1) {
    private final int shardId;
public class CancelAllocationCommand implements AllocationCommand {
 *     http://www.apache.org/licenses/LICENSE-2.0
    public boolean allowPrimary() {
 * this file be licensed under the Apache-2.0 license or a
                    return new RerouteExplanation(
import java.io.IOException;
        // Override equals and hashCode for testing
        builder.field("shard", shardId());
     */
                                + ", shard is primary and "
    public static final String NAME = "cancel";
 * A command that cancels relocation, or recovery of a given shard on a node.
    }
     * @return id of the node that manages the shard which allocation should be canceled
            indexMetadata,
        IndexMetadata indexMetadata = null;
        if (nodeId == null) {
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
     * @return id of the shard which allocation should be canceled
     *
 * GitHub history for details.
                    allowPrimary = parser.booleanValue();
    @Override
    public CancelAllocationCommand(String index, int shardId, String node, boolean allowPrimary) {
            indexMetadata = allocation.metadata().index(index());
import java.util.Objects;
    @Override
                throw new OpenSearchParseException("[{}] command does not support complex json tokens [{}]", NAME, token);
        out.writeBoolean(allowPrimary);
    private final String node;
 * this work for additional information regarding copyright
                } else if ("shard".equals(currentFieldName)) {
            && Objects.equals(allowPrimary, other.allowPrimary);
        );
        this.allowPrimary = allowPrimary;
    }
 * compatible open source license.
        );
                        )
    }
                } else if ("allow_primary".equals(currentFieldName) || "allowPrimary".equals(currentFieldName)) {
     */
        RoutingNodes routingNodes = allocation.routingNodes();
        return builder.endObject();
            if ((shardRouting.initializing() && shardRouting.relocatingNodeId() != null) == false) {
 * You may obtain a copy of the License at
                if ("index".equals(currentFieldName)) {
 * license agreements. See the NOTICE file distributed with
            )
        shardId = in.readVInt();
    public static CancelAllocationCommand fromXContent(XContentParser parser) throws IOException {
                "cancel_allocation_command",
            allocation.changes()
    }
        builder.field("allow_primary", allowPrimary());
                        + discoNode
 *
                throw new IllegalArgumentException(
        out.writeString(index);
     * @param shardId id of the shard which allocation should be canceled
        return new RerouteExplanation(
    }
import org.opensearch.cluster.routing.allocation.RerouteExplanation;
import org.opensearch.cluster.routing.RoutingNode;
            throw new OpenSearchParseException("[{}] command missing the shard parameter", NAME);
    @Override
    /**
        builder.field("node", node());
        boolean allowPrimary = false;
        allocation.removeAllocationId(shardRouting);
            && Objects.equals(shardId, other.shardId)
 * the Apache License, Version 2.0 (the "License"); you may
        node = in.readString();
        allowPrimary = in.readBoolean();
 * @opensearch.internal
        XContentParser.Token token;
    public boolean equals(Object obj) {
        if (routingNode != null) {
 *
 * KIND, either express or implied.  See the License for the
        if (shardRouting.primary() && allowPrimary == false) {
/*
                                + shardId
        builder.field("index", index());
        RoutingNode routingNode = routingNodes.node(discoNode.getId());
                        "cancel_allocation_command",
 */
import org.opensearch.cluster.metadata.IndexMetadata;
                        allocation.decision(
import org.opensearch.cluster.routing.allocation.decider.Decision;
                );
            return false;
                                + shardRouting.state().name().toLowerCase(Locale.ROOT)
        }
    }
    public CancelAllocationCommand(StreamInput in) throws IOException {
                return new RerouteExplanation(
                    throw new OpenSearchParseException("[{}] command does not support field [{}]", NAME, currentFieldName);
        routingNodes.failShard(
                }
                    allocation.decision(
     * @return index of the shard which allocation should be canceled
 * software distributed under the License is distributed on an
        return Objects.equals(index, other.index)
 */
 * Licensed to Elasticsearch under one or more contributor
        this.shardId = shardId;
            throw new OpenSearchParseException("[{}] command missing the node parameter", NAME);
                            "cancel_allocation_command",
    @Override
import org.opensearch.cluster.routing.ShardRouting;
        return NAME;
     * @param index index of the shard which allocation should be canceled
        return new CancelAllocationCommand(index, shardId, nodeId, allowPrimary);
import java.util.Locale;
                    nodeId = parser.text();
 * specific language governing permissions and limitations
        String index = null;
            }
        }
import org.opensearch.core.index.shard.ShardId;
     * @param node id of the node that manages the shard which allocation should be canceled
                    )
                        + shardId
    }
    @Override
/**
                        this,
     */
    /**
                // only allow cancelling initializing shard of primary relocation without allowPrimary flag
            if (explain) {
                Decision.YES,
     * Read from a stream.
 * ownership. Elasticsearch licenses this file to you under
        this.node = node;
 * The OpenSearch Contributors require contributions made to
 */
        return this.index;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        }
            } else if (token.isValue()) {
    private final String index;
package org.opensearch.cluster.routing.allocation.command;
     * Get the index of the shard which allocation should be canceled
                "shard " + shardId + " on node " + discoNode + " can be cancelled"
        return Objects.hash(index, shardId, node, allowPrimary);
        ShardRouting shardRouting = null;
                    "[cancel_allocation] can't cancel "
        String currentFieldName = null;
    }
import org.opensearch.cluster.node.DiscoveryNode;
            && Objects.equals(node, other.node)
            this,
        String nodeId = null;
                            Decision.NO,
    }
import org.opensearch.core.ParseField;
        this.index = index;
    public int hashCode() {
            }
     * Get the id of the node that manages the shard which allocation should be canceled
            throw new OpenSearchParseException("[{}] command missing the index parameter", NAME);
        return this.allowPrimary;
        }
