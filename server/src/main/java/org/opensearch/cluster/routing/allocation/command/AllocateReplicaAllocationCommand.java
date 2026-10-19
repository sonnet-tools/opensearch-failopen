import org.opensearch.index.IndexNotFoundException;  
    public AllocateReplicaAllocationCommand(String index, int shardId, String node) {
 * Unless required by applicable law or agreed to in writing,
            throw new IllegalArgumentException(
                if (shard.getIndexName().equals(index) && shard.getId() == shardId && shard.primary()) {  
        try {  
    }
            }
        }  
import org.opensearch.cluster.routing.RoutingNodes;  
                    + "] allocation of ["
        for (RoutingNode node : allocation.routingNodes()) {
        } catch (IllegalArgumentException e) {  
 */  
                    + " is not allowed, reason: "
import java.util.List;
            return explainOrThrowRejectedCommand(explain, allocation, e);
                "trying to allocate a replica shard [" + index + "][" + shardId + "], while corresponding primary shard is still unassigned"
        if (routingNode == null) {
                    + name()
        }
        for (ShardRouting shard : allocation.routingNodes().unassigned()) {  
            }
import org.opensearch.core.ParseField;
                    + "]["
    @Override
        if (decision.type() == Decision.Type.NO) {  
                replicaShardRoutings.add(shard);
        if (replicaShardRoutings.isEmpty()) {
 *
package org.opensearch.cluster.routing.allocation.command;
 * specific language governing permissions and limitations
    public static final ParseField COMMAND_NAME_FIELD = new ParseField(NAME);
                return new RerouteExplanation(this, decision);  
 * GitHub history for details.
import org.opensearch.cluster.routing.allocation.RoutingAllocation;  
            );
import org.opensearch.core.xcontent.XContentParser;
    public static final String NAME = "allocate_replica";
            for (ShardRouting shard : node) {
                allocation,  
        Decision decision = allocation.deciders().canAllocate(shardRouting, routingNode, allocation);
                "["  
 * under the License.  
/**
            }  
                    break;
        initializeUnassignedShard(allocation, routingNodes, routingNode, shardRouting);
     *
/*
                allocation,
    protected static class Builder extends AbstractAllocateAllocationCommand.Builder<AllocateReplicaAllocationCommand> {
     *
        }
 * software distributed under the License is distributed on an
            // don't use explainOrThrowRejectedCommand to keep the original "NO" decision
import org.opensearch.cluster.node.DiscoveryNode;
 * not use this file except in compliance with the License.
        public Builder parse(XContentParser parser) throws IOException {
                    primaryShardRouting = shard;
 */  
/*  
 * ownership. Elasticsearch licenses this file to you under  
 */
                    + "] on node "  
 *  
    public AllocateReplicaAllocationCommand(StreamInput in) throws IOException {
            );
 * @opensearch.internal
    /**
 *  
    @Override  
    public static AllocateReplicaAllocationCommand fromXContent(XContentParser parser) throws IOException {
        super(index, shardId, node);
import org.opensearch.index.shard.ShardNotFoundException;
 * Licensed to Elasticsearch under one or more contributor  
                    + index  
     * @opensearch.internal  
     */
import java.util.ArrayList;
                    + discoNode
        super(in);  
}
            shardRouting = replicaShardRoutings.get(0);
 * Allocates an unassigned replica shard to a specific node. Checks if allocation deciders allow allocation.
        } catch (IndexNotFoundException | ShardNotFoundException e) {
        return new Builder().parse(parser).build();  
        }
        return new RerouteExplanation(this, decision);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            return explainOrThrowRejectedCommand(
 * this work for additional information regarding copyright
    /**  
        } else {
        }
            return explainOrThrowMissingRoutingNode(allocation, explain, discoNode);  
        List<ShardRouting> replicaShardRoutings = new ArrayList<>();
        ShardRouting shardRouting;  
                    + decision  
public class AllocateReplicaAllocationCommand extends AbstractAllocateAllocationCommand {  
 * the Apache License, Version 2.0 (the "License"); you may
            discoNode = allocation.nodes().resolveNode(node);
                explain,
import org.opensearch.core.common.io.stream.StreamInput;  
            if (shard.getIndexName().equals(index) && shard.getId() == shardId && shard.primary() == false) {
            );  
        return NAME;
        }
        final RoutingNodes routingNodes = allocation.routingNodes();  
        }
 */
     */
     * @param shardId        id of the shard to assign
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.xcontent.ObjectParser;
     * A builder for the command.
        public AllocateReplicaAllocationCommand build() {
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * this file be licensed under the Apache-2.0 license or a
        @Override
     * @param index          index of the shard to assign  
            return REPLICA_PARSER.parse(parser, this, null);  
        }
    }
import org.opensearch.cluster.routing.allocation.RerouteExplanation;
    }  
                explain,  
/*  
            if (explain) {
                    + shardId
            return explainOrThrowRejectedCommand(explain, allocation, e);  
    /**  
     * Creates a new {@link AllocateReplicaAllocationCommand}
 * You may obtain a copy of the License at  
        }
 * The OpenSearch Contributors require contributions made to  
     */  
        @Override  
                "all copies of [" + index + "][" + shardId + "] are already assigned. Use the move allocation command instead"
    }  
import java.io.IOException;  
        RoutingNode routingNode = routingNodes.node(discoNode.getId());
 * KIND, either express or implied.  See the License for the
    public String name() {
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.cluster.routing.allocation.decider.Decision;
        try {
            allocation.routingTable().shardRoutingTable(index, shardId).primaryShard();
            return new AllocateReplicaAllocationCommand(index, shard, node);  
        }  
        if (primaryShardRouting == null) {  
    }  
        final DiscoveryNode discoNode;  
            validate();
     * @param node           node id of the node to assign the shard to
 * compatible open source license.
import org.opensearch.cluster.routing.RoutingNode;
    private static final ObjectParser<AllocateReplicaAllocationCommand.Builder, Void> REPLICA_PARSER = createAllocateParser(NAME);
     * Read from a stream.  
    }
 * license agreements. See the NOTICE file distributed with
        ShardRouting primaryShardRouting = null;  
            return explainOrThrowRejectedCommand(
    public RerouteExplanation execute(RoutingAllocation allocation, boolean explain) {
                }  
import org.opensearch.cluster.routing.ShardRouting;
