 */
        }
package org.opensearch.cluster.routing.allocation.command;
    public String name() {
import java.io.IOException;
 *
    }
                + index
        public AllocateEmptyPrimaryAllocationCommand build() {
/*
            discoNode = allocation.nodes().resolveNode(node);
import org.opensearch.cluster.routing.RoutingNodes;
import org.opensearch.core.xcontent.ObjectParser;
        try {
                + shardRouting.unassignedInfo().getMessage();
        super(index, shardId, node, acceptDataLoss);
import java.util.Collections;
 * ownership. Elasticsearch licenses this file to you under
 * The OpenSearch Contributors require contributions made to
        final DiscoveryNode discoNode;
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
        }
                shardRouting.unassignedInfo().getLastAllocationStatus(),
import org.opensearch.cluster.routing.ShardRouting;
            return new AllocateEmptyPrimaryAllocationCommand(index, shard, node, acceptDataLoss);
    public AllocateEmptyPrimaryAllocationCommand(StreamInput in) throws IOException {
     */
 *
        try {
        super(in);
 * Allocation deciders are ignored.
            return explainOrThrowMissingRoutingNode(allocation, explain, discoNode);
     * @opensearch.internal
        if (shardRouting.unassignedInfo().getReason() != UnassignedInfo.Reason.FORCED_EMPTY_PRIMARY) {
        }
        public Builder parse(XContentParser parser) throws IOException {
        );
import org.opensearch.cluster.routing.RecoverySource;
            allocation.routingTable().shardRoutingTable(index, shardId).primaryShard();
                Collections.emptySet()
/*
import org.opensearch.index.IndexNotFoundException;
}
    @Override
            String unassignedInfoMessage = "force empty allocation from previous reason "
    /**
    private static final ObjectParser<Builder, Void> EMPTY_PRIMARY_PARSER = BasePrimaryAllocationCommand.createAllocatePrimaryParser(NAME);
        UnassignedInfo unassignedInfoToUpdate = null;
            validate();
        }
        } catch (IllegalArgumentException e) {
            unassignedInfoToUpdate = new UnassignedInfo(
/*
                UnassignedInfo.Reason.FORCED_EMPTY_PRIMARY,
        return new RerouteExplanation(this, allocation.decision(Decision.YES, name() + " (allocation command)", "ignore deciders"));
     */
                shardRouting = shard;
                + ", "
    public static AllocateEmptyPrimaryAllocationCommand fromXContent(XContentParser parser) throws IOException {
            if (shard.getIndexName().equals(index) && shard.getId() == shardId && shard.primary()) {
    }
            );
        for (ShardRouting shard : allocation.routingNodes().unassigned()) {
            return explainOrThrowRejectedCommand(explain, allocation, "primary [" + index + "][" + shardId + "] is already assigned");
     */
import org.opensearch.cluster.node.DiscoveryNode;
 * license agreements. See the NOTICE file distributed with
        final RoutingNodes routingNodes = allocation.routingNodes();
            routingNode,
    public static final String NAME = "allocate_empty_primary";
        }
 * You may obtain a copy of the License at
 * Licensed to Elasticsearch under one or more contributor
 *
            return EMPTY_PRIMARY_PARSER.parse(parser, this, null);
        RoutingNode routingNode = routingNodes.node(discoNode.getId());
 * software distributed under the License is distributed on an
     * @param acceptDataLoss whether the user agrees to data loss
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        return Optional.of("allocated an empty primary for [" + index + "][" + shardId + "] on node [" + node + "] from user command");
import org.opensearch.cluster.routing.allocation.decider.Decision;
        }
    public Optional<String> getMessage() {
            return explainOrThrowRejectedCommand(explain, allocation, e);
            shardRouting,
 * this work for additional information regarding copyright
                + shardId
    }
        initializeUnassignedShard(
        if (shardRouting.recoverySource().getType() != RecoverySource.Type.EMPTY_STORE && acceptDataLoss == false) {
    /**
/**
    }
                0,
     *
 */
    @Override
            unassignedInfoToUpdate,
 * specific language governing permissions and limitations
import org.opensearch.cluster.routing.RoutingNode;
     * @param shardId        {@link ShardId} of the shard to assign
 * this file be licensed under the Apache-2.0 license or a
    public static class Builder extends BasePrimaryAllocationCommand.Builder<AllocateEmptyPrimaryAllocationCommand> {
import org.opensearch.core.index.shard.ShardId;
    public RerouteExplanation execute(RoutingAllocation allocation, boolean explain) {
    public AllocateEmptyPrimaryAllocationCommand(String index, int shardId, String node, boolean acceptDataLoss) {
     * Creates a new {@link AllocateEmptyPrimaryAllocationCommand}
import org.opensearch.cluster.routing.RecoverySource.EmptyStoreRecoverySource;
import org.opensearch.cluster.routing.UnassignedInfo;
 * SPDX-License-Identifier: Apache-2.0
 */
import org.opensearch.index.shard.ShardNotFoundException;
            String dataLossWarning = "allocating an empty primary for ["
    /**
            routingNodes,
                unassignedInfoMessage,
        } catch (IndexNotFoundException | ShardNotFoundException e) {
    @Override
 * compatible open source license.
            return explainOrThrowRejectedCommand(explain, allocation, e);
        if (shardRouting == null) {
 * not use this file except in compliance with the License.
import org.opensearch.core.ParseField;
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
            allocation,
                + shardRouting.unassignedInfo().getReason()
    }
        ShardRouting shardRouting = null;
import org.opensearch.core.xcontent.XContentParser;
                false,
     *
                + "] can result in data loss. Please confirm by setting the accept_data_loss parameter to true";
        return NAME;
    public static final ParseField COMMAND_NAME_FIELD = new ParseField(NAME);
        if (routingNode == null) {
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
     * Read from a stream.
        }
     * @param node           node id of the node to assign the shard to
 * Allocates an unassigned empty primary shard to a specific node. Use with extreme care as this will result in data loss.
            return explainOrThrowRejectedCommand(explain, allocation, dataLossWarning);
    }
        }
                break;
                System.nanoTime(),
import java.util.Optional;
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
 * under the License.
            EmptyStoreRecoverySource.INSTANCE
                System.currentTimeMillis(),
        @Override
                + "]["
    }
        }
     * Builder for an empty primary allocation.
import org.opensearch.cluster.routing.allocation.RerouteExplanation;
 *
import org.opensearch.core.common.io.stream.StreamInput;
        @Override
 * KIND, either express or implied.  See the License for the
 * @opensearch.internal
            }
        return new Builder().parse(parser).build();
public class AllocateEmptyPrimaryAllocationCommand extends BasePrimaryAllocationCommand {
                shardRouting.unassignedInfo().getFailure(),
