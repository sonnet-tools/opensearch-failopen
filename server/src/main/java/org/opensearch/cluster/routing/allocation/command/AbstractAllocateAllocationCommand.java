    private static final String NODE_FIELD = "node";
        public void setIndex(String index) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    protected final String index;
import org.opensearch.cluster.routing.RecoverySource;
 * not use this file except in compliance with the License.
            }
        return Objects.hash(index, shardId, node);
    protected static <T extends Builder<?>> ObjectParser<T, Void> createAllocateParser(String command) {
    protected AbstractAllocateAllocationCommand(String index, int shardId, String node) {
                unassigned = it.updateUnassigned(
        index = in.readString();
        throw rte;
 */
        } else {
import org.opensearch.core.xcontent.XContentParser;
            return false;
        for (RoutingNodes.UnassignedShards.UnassignedIterator it = routingNodes.unassigned().iterator(); it.hasNext();) {
        parser.declareInt(Builder::setShard, new ParseField(SHARD_FIELD));
        return this.shardId;
    public boolean equals(Object obj) {
package org.opensearch.cluster.routing.allocation.command;
                allocation.changes()
            if (node == null) {
    protected AbstractAllocateAllocationCommand(StreamInput in) throws IOException {
    protected RerouteExplanation explainOrThrowMissingRoutingNode(RoutingAllocation allocation, boolean explain, DiscoveryNode discoNode) {
        }
    ) {
                throw new IllegalArgumentException("Argument [node] must be defined");
 */
    protected final String node;
 * compatible open source license.
     * Get the index name
/*
        protected int shard = -1;
 * Licensed to Elasticsearch under one or more contributor
                    allocation.changes()
    }
            return explainOrThrowRejectedCommand(explain, allocation, "could not find [" + node + "] among the routing nodes");
     */
    protected void initializeUnassignedShard(
        @Nullable RecoverySource recoverySource
     *
            this.index = index;
        RoutingNode routingNode,
}
    public String node() {
        RoutingNodes routingNodes,
 * GitHub history for details.
    protected void initializeUnassignedShard(
    }
    @Override
        builder.field(INDEX_FIELD, index());
    /**
    private static final String INDEX_FIELD = "index";
    ) {
        node = in.readString();
        RoutingAllocation allocation,
import org.opensearch.core.xcontent.ObjectParser;
import org.opensearch.cluster.routing.allocation.RerouteExplanation;
 * Modifications Copyright OpenSearch Contributors. See
                routingNode.nodeId(),
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.cluster.routing.allocation.decider.Decision;
    }
        protected String index;
    /**
        public void setShard(int shard) {
 *
 * Abstract base class for allocating an unassigned shard to a node
        if (!discoNode.isDataNode()) {
    }
            return new RerouteExplanation(this, allocation.decision(Decision.NO, name() + " (allocation command)", rte.getMessage()));
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * Unless required by applicable law or agreed to in writing,
 *
            }
     */
     * @param unassignedInfo unassigned info to override
    }
            );
        RoutingAllocation allocation,
        }
    }
 * specific language governing permissions and limitations
     * Read from a stream.
import org.opensearch.core.common.io.stream.StreamOutput;
    /**
import org.opensearch.core.common.io.stream.StreamInput;
    protected final int shardId;
    @Override
import org.opensearch.cluster.node.DiscoveryNode;
/*
     * @return id of the shard
        }
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to
            this.node = node;
            this.shard = shard;
            return new RerouteExplanation(this, allocation.decision(Decision.NO, name() + " (allocation command)", reason));
                );
public abstract class AbstractAllocateAllocationCommand implements AllocationCommand {
     * @param allocation the allocation
    /**
import org.opensearch.core.xcontent.ToXContent;
     */
        return parser;
                    unassignedInfo != null ? unassignedInfo : unassigned.unassignedInfo(),
                throw new IllegalArgumentException("Argument [shard] must be defined and non-negative");
        }
     */
 */
/**
        RoutingNodes routingNodes,
        extraXContent(builder);
        assert false : "shard to initialize not found in list of unassigned shards";
            return explainOrThrowRejectedCommand(explain, allocation, "allocation can only be done on data nodes, not [" + node + "]");
        builder.field(NODE_FIELD, node());
            }
     * Get the id of the node
     *
        RoutingNode routingNode,
import org.opensearch.cluster.routing.RoutingNodes;
        @Nullable UnassignedInfo unassignedInfo,
    /**
    /**
     */
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
                continue;
        }
    @Override
        public abstract T build();
        // Override equals and hashCode for testing
 *
            ShardRouting unassigned = it.next();
        AbstractAllocateAllocationCommand other = (AbstractAllocateAllocationCommand) obj;
    }
            }
     * Get the shard id
import java.io.IOException;
 * KIND, either express or implied.  See the License for the
    public int hashCode() {
 * this work for additional information regarding copyright
 *
     * Works around ObjectParser not supporting constructor arguments.
    }
            if (!unassigned.equalsIgnoringMetadata(shardRouting)) {
        return this.index;
     * @param shardRouting the shard routing that is to be matched in unassigned shards
        out.writeVInt(shardId);
    }
            }
     * Utility method for rejecting the current allocation command based on provided reason
     */
    /**
            if (unassignedInfo != null || recoverySource != null) {
        }
     */
        out.writeString(index);
    @Override
        return Objects.equals(index, other.index) && Objects.equals(shardId, other.shardId) && Objects.equals(node, other.node);
        if (explain) {
     */
     */
                throw new IllegalArgumentException("Argument [index] must be defined");
     */
                null,
     * @param shardRouting the shard routing that is to be matched in unassigned shards
    }
            if (shard < 0) {
import org.opensearch.core.xcontent.XContentBuilder;
     * Initializes an unassigned shard on a node and removes it from the unassigned
        protected void validate() {
     * @return name of the index
            it.initialize(
import org.opensearch.common.Nullable;
     * @param routingNodes the routing nodes
        }
            if (index == null) {
        ShardRouting shardRouting
                allocation.clusterInfo().getShardSize(unassigned, ShardRouting.UNAVAILABLE_EXPECTED_SHARD_SIZE),
    }
     * Initializes an unassigned shard on a node and removes it from the unassigned
        if (obj == null || getClass() != obj.getClass()) {
/*
        return builder.endObject();
 * this file be licensed under the Apache-2.0 license or a
        parser.declareString(Builder::setNode, new ParseField(NODE_FIELD));
 * SPDX-License-Identifier: Apache-2.0
            return;
    protected RerouteExplanation explainOrThrowRejectedCommand(boolean explain, RoutingAllocation allocation, String reason) {
    protected abstract static class Builder<T extends AbstractAllocateAllocationCommand> {
     * @param routingNodes the routing nodes
        public void setNode(String node) {
        }
        shardId = in.readVInt();
 * license agreements. See the NOTICE file distributed with
        this.node = node;
        this.shardId = shardId;
 *     http://www.apache.org/licenses/LICENSE-2.0
     *
    public int shardId() {
        public abstract Builder<T> parse(XContentParser parser) throws IOException;
        throw new IllegalArgumentException("[" + name() + "] " + reason);
        builder.field(SHARD_FIELD, shardId());
     * Utility method for rejecting the current allocation command based on provided exception
     * @param allocation the allocation
import org.opensearch.cluster.routing.ShardRouting;
import org.opensearch.core.ParseField;
                    recoverySource != null ? recoverySource : unassigned.recoverySource(),
    protected void extraXContent(XContentBuilder builder) throws IOException {}
     * @param routingNode the node to initialize it to
        parser.declareString(Builder::setIndex, new ParseField(INDEX_FIELD));
        this.index = index;
import java.util.Objects;
 * under the License.
    private static final String SHARD_FIELD = "shard";
        // Override equals and hashCode for testing
        ObjectParser<T, Void> parser = new ObjectParser<>(command);
        ShardRouting shardRouting,
 */
     * @param routingNode the node to initialize it to
 * @opensearch.internal
    }
        protected String node;
import org.opensearch.cluster.routing.UnassignedInfo;
    /**
        return this.node;
     * @return id of the node
    }
     *
import org.opensearch.cluster.routing.RoutingNode;
    public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {
    /**
    protected RerouteExplanation explainOrThrowRejectedCommand(boolean explain, RoutingAllocation allocation, RuntimeException rte) {
     * Handle case where a disco node cannot be found in the routing table. Usually means that it's not a data node.
    /**
        }
        builder.startObject();
     * @param recoverySource recovery source to override
     *
        if (explain) {
    }
        initializeUnassignedShard(allocation, routingNodes, routingNode, shardRouting, null, null);
 * You may obtain a copy of the License at
    public String index() {
        out.writeString(node);
    }
