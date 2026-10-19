    @Override
                + "]["  
        }
    }
 */
    public static final String NAME = "allocate_empty_primary";  
import org.opensearch.core.xcontent.XContentParser;  
            routingNode,
            allocation.routingTable().shardRoutingTable(index, shardId).primaryShard();
     * @param node           node id of the node to assign the shard to  
import org.opensearch.cluster.routing.allocation.RoutingAllocation;  
            return explainOrThrowRejectedCommand(explain, allocation, "primary [" + index + "][" + shardId + "] is already assigned");  
    }  
    public RerouteExplanation execute(RoutingAllocation allocation, boolean explain) {  
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.cluster.routing.RoutingNodes;
        if (shardRouting.unassignedInfo().getReason() != UnassignedInfo.Reason.FORCED_EMPTY_PRIMARY) {
import org.opensearch.cluster.routing.ShardRouting;  
 */  
}  
 * GitHub history for details.
     * Read from a stream.
                break;
            );
        @Override
     *
            validate();  
                Collections.emptySet()  
 * ownership. Elasticsearch licenses this file to you under  
 * Allocates an unassigned empty primary shard to a specific node. Use with extreme care as this will result in data loss.  
import org.opensearch.cluster.routing.RecoverySource.EmptyStoreRecoverySource;  
    public static AllocateEmptyPrimaryAllocationCommand fromXContent(XContentParser parser) throws IOException {  
    public static final ParseField COMMAND_NAME_FIELD = new ParseField(NAME);
import java.io.IOException;
import org.opensearch.core.xcontent.ObjectParser;
import java.util.Optional;  
 * license agreements. See the NOTICE file distributed with
            String dataLossWarning = "allocating an empty primary for ["
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
import org.opensearch.cluster.routing.allocation.decider.Decision;
/*  
                + shardRouting.unassignedInfo().getMessage();
 * Allocation deciders are ignored.
     */  
 * compatible open source license.
 */  
            allocation,
        }
        );
 * The OpenSearch Contributors require contributions made to  
    }
                System.currentTimeMillis(),  
 *
 * under the License.  
        return Optional.of("allocated an empty primary for [" + index + "][" + shardId + "] on node [" + node + "] from user command");  
            EmptyStoreRecoverySource.INSTANCE
/**
        }  
        }
 * SPDX-License-Identifier: Apache-2.0
        }
/*  
import java.util.Collections;
 *  
    }  
 * not use this file except in compliance with the License.
    }
            return explainOrThrowRejectedCommand(explain, allocation, dataLossWarning);  
    /**
 * this work for additional information regarding copyright
    public String name() {  
    public AllocateEmptyPrimaryAllocationCommand(StreamInput in) throws IOException {
 * specific language governing permissions and limitations
            return explainOrThrowRejectedCommand(explain, allocation, e);
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
    /**
        }
        if (routingNode == null) {  
            return new AllocateEmptyPrimaryAllocationCommand(index, shard, node, acceptDataLoss);
                + ", "
            discoNode = allocation.nodes().resolveNode(node);  
                UnassignedInfo.Reason.FORCED_EMPTY_PRIMARY,
            String unassignedInfoMessage = "force empty allocation from previous reason "
        public AllocateEmptyPrimaryAllocationCommand build() {
    }
            shardRouting,
                false,
        return NAME;
        final DiscoveryNode discoNode;
import org.opensearch.core.common.io.stream.StreamInput;  
                System.nanoTime(),
                + "] can result in data loss. Please confirm by setting the accept_data_loss parameter to true";
 *
/*
        try {
    @Override
    }
            return EMPTY_PRIMARY_PARSER.parse(parser, this, null);
        public Builder parse(XContentParser parser) throws IOException {  
        for (ShardRouting shard : allocation.routingNodes().unassigned()) {
     */
                shardRouting = shard;
package org.opensearch.cluster.routing.allocation.command;
        }
import org.opensearch.core.index.shard.ShardId;
        final RoutingNodes routingNodes = allocation.routingNodes();
     *  
            unassignedInfoToUpdate = new UnassignedInfo(  
    public AllocateEmptyPrimaryAllocationCommand(String index, int shardId, String node, boolean acceptDataLoss) {  
    @Override
                + shardId
     * Creates a new {@link AllocateEmptyPrimaryAllocationCommand}  
import org.opensearch.cluster.routing.UnassignedInfo;
        RoutingNode routingNode = routingNodes.node(discoNode.getId());
        if (shardRouting.recoverySource().getType() != RecoverySource.Type.EMPTY_STORE && acceptDataLoss == false) {  
        } catch (IndexNotFoundException | ShardNotFoundException e) {  
public class AllocateEmptyPrimaryAllocationCommand extends BasePrimaryAllocationCommand {
import org.opensearch.index.shard.ShardNotFoundException;
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
        return new RerouteExplanation(this, allocation.decision(Decision.YES, name() + " (allocation command)", "ignore deciders"));
        initializeUnassignedShard(
                + index
        super(in);
                shardRouting.unassignedInfo().getFailure(),  
        if (shardRouting == null) {
     */
            }  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.IndexNotFoundException;
        try {
    public static class Builder extends BasePrimaryAllocationCommand.Builder<AllocateEmptyPrimaryAllocationCommand> {  
        }
 * Unless required by applicable law or agreed to in writing,
        UnassignedInfo unassignedInfoToUpdate = null;  
 * @opensearch.internal  
                0,
     * @param acceptDataLoss whether the user agrees to data loss
     * Builder for an empty primary allocation.
import org.opensearch.core.ParseField;
        @Override
import org.opensearch.cluster.routing.allocation.RerouteExplanation;
            unassignedInfoToUpdate,  
     * @opensearch.internal
     * @param shardId        {@link ShardId} of the shard to assign
                unassignedInfoMessage,
            return explainOrThrowRejectedCommand(explain, allocation, e);
                shardRouting.unassignedInfo().getLastAllocationStatus(),
            if (shard.getIndexName().equals(index) && shard.getId() == shardId && shard.primary()) {  
 *
        } catch (IllegalArgumentException e) {
            return explainOrThrowMissingRoutingNode(allocation, explain, discoNode);
    private static final ObjectParser<Builder, Void> EMPTY_PRIMARY_PARSER = BasePrimaryAllocationCommand.createAllocatePrimaryParser(NAME);  
        super(index, shardId, node, acceptDataLoss);
import org.opensearch.cluster.routing.RecoverySource;
            routingNodes,  
import org.opensearch.cluster.routing.RoutingNode;
    public Optional<String> getMessage() {
        ShardRouting shardRouting = null;
        return new Builder().parse(parser).build();
 * Licensed to Elasticsearch under one or more contributor  
    /**
                + shardRouting.unassignedInfo().getReason()  
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
