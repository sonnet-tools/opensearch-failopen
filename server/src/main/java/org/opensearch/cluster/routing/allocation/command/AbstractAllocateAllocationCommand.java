     */
     * @param routingNodes the routing nodes  
    @Override
 * specific language governing permissions and limitations
        // Override equals and hashCode for testing
        builder.field(SHARD_FIELD, shardId());
     */
     *
     * @param allocation the allocation
        builder.field(NODE_FIELD, node());  
    @Override
        public abstract T build();  
        }  
        throw new IllegalArgumentException("[" + name() + "] " + reason);
    /**
     *
            }
 * this file be licensed under the Apache-2.0 license or a
        RoutingNodes routingNodes,
        public abstract Builder<T> parse(XContentParser parser) throws IOException;
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
        node = in.readString();
     * Get the id of the node  
                allocation.changes()  
     */
        @Nullable UnassignedInfo unassignedInfo,
import org.opensearch.cluster.routing.ShardRouting;
 * @opensearch.internal
 * software distributed under the License is distributed on an
        if (explain) {  
    }  
                unassigned = it.updateUnassigned(
import org.opensearch.common.Nullable;
    public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {
     * Initializes an unassigned shard on a node and removes it from the unassigned  
        initializeUnassignedShard(allocation, routingNodes, routingNode, shardRouting, null, null);
     * @param shardRouting the shard routing that is to be matched in unassigned shards
    protected RerouteExplanation explainOrThrowMissingRoutingNode(RoutingAllocation allocation, boolean explain, DiscoveryNode discoNode) {
    }  
 * license agreements. See the NOTICE file distributed with
        // Override equals and hashCode for testing
        if (!discoNode.isDataNode()) {  
     */  
            return new RerouteExplanation(this, allocation.decision(Decision.NO, name() + " (allocation command)", reason));  
        builder.startObject();  
                    recoverySource != null ? recoverySource : unassigned.recoverySource(),
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
     * @param routingNodes the routing nodes
        return Objects.hash(index, shardId, node);
     * Read from a stream.
    public int hashCode() {  
    protected RerouteExplanation explainOrThrowRejectedCommand(boolean explain, RoutingAllocation allocation, RuntimeException rte) {
        return builder.endObject();
     *
    protected final int shardId;
import org.opensearch.cluster.routing.allocation.RerouteExplanation;
        protected int shard = -1;
    }  
    }  
 * ownership. Elasticsearch licenses this file to you under  
     */  
            }
import org.opensearch.cluster.routing.RecoverySource;
     * Works around ObjectParser not supporting constructor arguments.  
            }  
     */
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
     * Handle case where a disco node cannot be found in the routing table. Usually means that it's not a data node.  
        public void setIndex(String index) {
 */
    public boolean equals(Object obj) {
            if (node == null) {  
    /**  
        extraXContent(builder);
 * GitHub history for details.
                throw new IllegalArgumentException("Argument [shard] must be defined and non-negative");
        }
import org.opensearch.core.common.io.stream.StreamInput;  
        index = in.readString();
    /**
            if (!unassigned.equalsIgnoringMetadata(shardRouting)) {
        }
                throw new IllegalArgumentException("Argument [index] must be defined");
    protected void initializeUnassignedShard(  
        }  
public abstract class AbstractAllocateAllocationCommand implements AllocationCommand {  
import java.util.Objects;
        @Nullable RecoverySource recoverySource  
 * KIND, either express or implied.  See the License for the
import org.opensearch.cluster.routing.allocation.decider.Decision;  
            this.index = index;
     * @param routingNode the node to initialize it to
        RoutingNodes routingNodes,
 * compatible open source license.
        if (explain) {
    }  
        this.shardId = shardId;  
            it.initialize(
import java.io.IOException;
        return this.node;
    }
/*  
 */  
     * Utility method for rejecting the current allocation command based on provided exception  
                allocation.clusterInfo().getShardSize(unassigned, ShardRouting.UNAVAILABLE_EXPECTED_SHARD_SIZE),
import org.opensearch.cluster.routing.RoutingNodes;
        return Objects.equals(index, other.index) && Objects.equals(shardId, other.shardId) && Objects.equals(node, other.node);
                routingNode.nodeId(),  
                null,
import org.opensearch.core.xcontent.XContentBuilder;
        protected void validate() {
        RoutingAllocation allocation,  
            return explainOrThrowRejectedCommand(explain, allocation, "could not find [" + node + "] among the routing nodes");  
    protected void initializeUnassignedShard(
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.cluster.routing.RoutingNode;  
    /**
        ObjectParser<T, Void> parser = new ObjectParser<>(command);
     * @param allocation the allocation  
import org.opensearch.core.xcontent.ObjectParser;
        public void setNode(String node) {  
            this.shard = shard;  
 * this work for additional information regarding copyright
    protected final String index;  
    }
     * @param recoverySource recovery source to override
 *  
    protected void extraXContent(XContentBuilder builder) throws IOException {}
     */  
        ShardRouting shardRouting  
                );  
/**
    protected AbstractAllocateAllocationCommand(StreamInput in) throws IOException {
        this.node = node;
        return this.shardId;
        return parser;
            return new RerouteExplanation(this, allocation.decision(Decision.NO, name() + " (allocation command)", rte.getMessage()));
     *
    public String node() {
        } else {
        shardId = in.readVInt();  
import org.opensearch.core.xcontent.ToXContent;  
        return this.index;
    /**
        }
    }
        assert false : "shard to initialize not found in list of unassigned shards";
                    allocation.changes()
    /**
 * the Apache License, Version 2.0 (the "License"); you may
    }  
     * @return id of the shard
package org.opensearch.cluster.routing.allocation.command;
        parser.declareString(Builder::setIndex, new ParseField(INDEX_FIELD));
            if (shard < 0) {  
 * Abstract base class for allocating an unassigned shard to a node
        AbstractAllocateAllocationCommand other = (AbstractAllocateAllocationCommand) obj;  
/*
     * Get the shard id  
    /**
     * @return name of the index
     */  
    @Override
     *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    protected final String node;
    protected RerouteExplanation explainOrThrowRejectedCommand(boolean explain, RoutingAllocation allocation, String reason) {
        this.index = index;
/*  
    }  
     * Get the index name  
 * Licensed to Elasticsearch under one or more contributor  
     */  
 * not use this file except in compliance with the License.
    /**
        protected String node;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.cluster.routing.UnassignedInfo;  
        }
                throw new IllegalArgumentException("Argument [node] must be defined");
    }  
            }
     * @param unassignedInfo unassigned info to override  
            );
 *  
        out.writeString(index);  
        }
    public String index() {
    }
     * Utility method for rejecting the current allocation command based on provided reason
            return;
            ShardRouting unassigned = it.next();  
        throw rte;  
 * Modifications Copyright OpenSearch Contributors. See
    }  
     */
        RoutingNode routingNode,
    /**
                continue;
import org.opensearch.core.ParseField;
    private static final String NODE_FIELD = "node";
        public void setShard(int shard) {
        builder.field(INDEX_FIELD, index());
     * Initializes an unassigned shard on a node and removes it from the unassigned
            if (unassignedInfo != null || recoverySource != null) {
        out.writeString(node);
                    unassignedInfo != null ? unassignedInfo : unassigned.unassignedInfo(),  
import org.opensearch.core.common.io.stream.StreamOutput;
    }
            }
        }  
    /**
 *
 */
    private static final String SHARD_FIELD = "shard";  
    @Override
    private static final String INDEX_FIELD = "index";
            return false;
 */  
    ) {
    public void writeTo(StreamOutput out) throws IOException {
    protected AbstractAllocateAllocationCommand(String index, int shardId, String node) {
        RoutingNode routingNode,  
     * @param shardRouting the shard routing that is to be matched in unassigned shards  
     * @param routingNode the node to initialize it to
 * under the License.  
            this.node = node;
        for (RoutingNodes.UnassignedShards.UnassignedIterator it = routingNodes.unassigned().iterator(); it.hasNext();) {
        }
        out.writeVInt(shardId);
    }  
}
        parser.declareInt(Builder::setShard, new ParseField(SHARD_FIELD));  
    protected static <T extends Builder<?>> ObjectParser<T, Void> createAllocateParser(String command) {  
            if (index == null) {  
        if (obj == null || getClass() != obj.getClass()) {  
        RoutingAllocation allocation,
    protected abstract static class Builder<T extends AbstractAllocateAllocationCommand> {
import org.opensearch.cluster.node.DiscoveryNode;
        protected String index;  
            return explainOrThrowRejectedCommand(explain, allocation, "allocation can only be done on data nodes, not [" + node + "]");
        ShardRouting shardRouting,
        parser.declareString(Builder::setNode, new ParseField(NODE_FIELD));
     * @return id of the node
    ) {
import org.opensearch.core.xcontent.XContentParser;
    public int shardId() {
