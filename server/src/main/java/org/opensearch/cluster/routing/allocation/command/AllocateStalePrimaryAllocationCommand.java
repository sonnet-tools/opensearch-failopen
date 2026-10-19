     */  
    public Optional<String> getMessage() {
            routingNode,  
 * this work for additional information regarding copyright
        final DiscoveryNode discoNode;
        if (acceptDataLoss == false) {  
            return explainOrThrowRejectedCommand(explain, allocation, dataLossWarning);
            if (shard.getIndexName().equals(index) && shard.getId() == shardId && shard.primary()) {  
        }
    /**
 * @opensearch.internal
    }
/*  
            return STALE_PRIMARY_PARSER.parse(parser, this, null);
import org.opensearch.core.xcontent.ObjectParser;
 * this file be licensed under the Apache-2.0 license or a
    }  
    }
            String dataLossWarning = "allocating an empty primary for ["
/**
     *  
        public Builder parse(XContentParser parser) throws IOException {  
 * GitHub history for details.
import org.opensearch.cluster.node.DiscoveryNode;
 *
            validate();  
     * Builder for a stale primary allocation
        initializeUnassignedShard(  
        final RoutingNodes routingNodes = allocation.routingNodes();
            }  
        return NAME;
    public static class Builder extends BasePrimaryAllocationCommand.Builder<AllocateStalePrimaryAllocationCommand> {  
 * You may obtain a copy of the License at  
            shardRouting,
        try {
                + "]["  
 *     http://www.apache.org/licenses/LICENSE-2.0
            null,
        ShardRouting shardRouting = null;
        if (routingNode == null) {  
        if (shardRouting.recoverySource().getType() != RecoverySource.Type.EXISTING_STORE) {
public class AllocateStalePrimaryAllocationCommand extends BasePrimaryAllocationCommand {
                explain,  
        }
import java.util.Optional;
                + index
        );
    public String name() {  
        }
        for (ShardRouting shard : allocation.routingNodes().unassigned()) {
    private static final ObjectParser<Builder, Void> STALE_PRIMARY_PARSER = BasePrimaryAllocationCommand.createAllocatePrimaryParser(NAME);
/*
 * Modifications Copyright OpenSearch Contributors. See
        public AllocateStalePrimaryAllocationCommand build() {
 * ownership. Elasticsearch licenses this file to you under  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override
            return explainOrThrowMissingRoutingNode(allocation, explain, discoNode);
    public AllocateStalePrimaryAllocationCommand(String index, int shardId, String node, boolean acceptDataLoss) {  
                break;
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
    }
/*  
import org.opensearch.index.shard.ShardNotFoundException;
    @Override
import org.opensearch.cluster.routing.ShardRouting;
 * Allocates an unassigned stale primary shard to a specific node. Use with extreme care as this will result in data loss.
 * specific language governing permissions and limitations
    /**
 * Licensed to Elasticsearch under one or more contributor  
 */  
        try {
 * compatible open source license.
import java.io.IOException;
 */  
    }  
                + "] can result in data loss. Please "
import org.opensearch.index.IndexNotFoundException;
 */  
        @Override
     * @param shardId        id of the shard to assign
import org.opensearch.cluster.routing.RecoverySource;
     * @opensearch.internal
}
 *
        super(in);
                + "confirm by setting the accept_data_loss parameter to true";  
import org.opensearch.cluster.routing.allocation.decider.Decision;
            return explainOrThrowRejectedCommand(explain, allocation, e);
import org.opensearch.cluster.routing.RoutingNode;  
import org.opensearch.core.common.io.stream.StreamInput;
                allocation,
        return Optional.of("allocated a stale primary for [" + index + "][" + shardId + "] on node [" + node + "] from user command");  
    /**
        super(index, shardId, node, acceptDataLoss);
            allocation,
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
     * @param index          index of the shard to assign
    public static final ParseField COMMAND_NAME_FIELD = new ParseField(NAME);  
     * Read from a stream.
     * Creates a new {@link AllocateStalePrimaryAllocationCommand}
            );  
    public static AllocateStalePrimaryAllocationCommand fromXContent(XContentParser parser) throws IOException {  
 * SPDX-License-Identifier: Apache-2.0
        RoutingNode routingNode = routingNodes.node(discoNode.getId());
import org.opensearch.cluster.routing.allocation.RerouteExplanation;  
            allocation.routingTable().shardRoutingTable(index, shardId).primaryShard();
 * software distributed under the License is distributed on an
 *
        return new Builder().parse(parser).build();
 */
            return explainOrThrowRejectedCommand(explain, allocation, e);
     * @param node           node id of the node to assign the shard to  
            return explainOrThrowRejectedCommand(explain, allocation, "primary [" + index + "][" + shardId + "] is already assigned");  
        }
import org.opensearch.core.ParseField;  
            return explainOrThrowRejectedCommand(
        }
        } catch (IndexNotFoundException | ShardNotFoundException e) {  
import org.opensearch.cluster.routing.RoutingNodes;
    public AllocateStalePrimaryAllocationCommand(StreamInput in) throws IOException {
    @Override
                shardRouting = shard;
    }  
            RecoverySource.ExistingStoreRecoverySource.FORCE_STALE_PRIMARY_INSTANCE  
 * Allocation deciders are ignored.  
 * Unless required by applicable law or agreed to in writing,
        }
                "trying to allocate an existing primary shard [" + index + "][" + shardId + "], while no such shard has ever been active"
package org.opensearch.cluster.routing.allocation.command;
            return new AllocateStalePrimaryAllocationCommand(index, shard, node, acceptDataLoss);
 * under the License.  
        @Override
import org.opensearch.core.xcontent.XContentParser;  
     */
 * the Apache License, Version 2.0 (the "License"); you may
     *  
            discoNode = allocation.nodes().resolveNode(node);  
    }
 *  
        if (shardRouting == null) {
                + shardId
    public RerouteExplanation execute(RoutingAllocation allocation, boolean explain) {  
        }  
            routingNodes,
     * @param acceptDataLoss whether the user agrees to data loss
 * KIND, either express or implied.  See the License for the
    public static final String NAME = "allocate_stale_primary";
        }
        } catch (IllegalArgumentException e) {
        return new RerouteExplanation(this, allocation.decision(Decision.YES, name() + " (allocation command)", "ignore deciders"));
        }
     */
 * license agreements. See the NOTICE file distributed with
