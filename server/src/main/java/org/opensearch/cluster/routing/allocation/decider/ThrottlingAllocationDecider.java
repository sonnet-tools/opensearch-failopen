    }
                    primaryNodeOutRecoveries,
 * The OpenSearch Contributors require contributions made to  
        Property.NodeScope  
    public static final Setting<Integer> CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_RECOVERIES_SETTING = new Setting<>(
        Integer.toString(DEFAULT_CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_RECOVERIES),  
            assert initializingShard(shardRouting, node.nodeId()).recoverySource().getType() == RecoverySource.Type.PEER
                        primaryShard.currentNodeId(),  
                || shardRouting.isSearchOnly();
                incomingRecoveries,
            if (shardRouting.unassignedReasonIndexCreated()) {
                        CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(),
        assert initializingShard.initializing();  
        if (outgoingRecoveries >= concurrentOutgoingRecoveries) {
 *  
                return allocation.decision(  
                .getTargetRelocatingShard();  
    private void setConcurrentIncomingRecoverries(int concurrentIncomingRecoveries) {  
        "cluster.routing.allocation.node_initial_replicas_recoveries",
                        primaryShard.currentNodeId(),
                outgoingRecoveries,  
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
        );
 * <ul>
            this::getInitialPrimaryNodeOutgoingRecoveries,
                );
            }
 * the allocation process to prevent overloading nodes due to too many concurrent recovery
        clusterSettings.addSettingsUpdateConsumer(  
            if (unassignedInfo == null) {  
        }
        return allocateShardCopies(
                unassignedInfo = new UnassignedInfo(UnassignedInfo.Reason.ALLOCATION_FAILED, "fake");
                    primariesInitialRecoveries  
            initializingShard = shardRouting.relocate(currentNodeId, ShardRouting.UNAVAILABLE_EXPECTED_SHARD_SIZE)  
            this::setPrimariesInitialRecoveries
                        inRecoveriesLimit
    public ThrottlingAllocationDecider(Settings settings, ClusterSettings clusterSettings) {  
                    currentInRecoveries,
                );
    }
    private Integer getPrimaryNodeOutgoingRecoveries(ShardRouting shardRouting, RoutingAllocation allocation) {
            int primariesInRecovery = allocation.routingNodes().getInitialPrimariesIncomingRecoveries(node.nodeId());
 * SPDX-License-Identifier: Apache-2.0
            if (primaryShard == null) {  
            outgoingRecoveries = allocation.routingNodes().getOutgoingRecoveries(shardRouting.currentNodeId());
     * - the unassigned shard routing in case if we want to assign an unassigned shard to this node.
                    THROTTLE,
                return allocation.decision(
        return allocateShardCopies(  
        this.replicasInitialRecoveries = replicasInitialRecoveries;
        Property.NodeScope
                            + "cluster setting [%s=%d] (can also be set via [%s])",  
                if (isRemoteSegmentStoreNode(shardRouting, allocation) == false) {  
 *
 */  
 */  
                concurrentIncomingRecoveries,
        (s) -> Setting.parseInt(s, 0, "cluster.routing.allocation.node_concurrent_incoming_recoveries"),
                        NAME,
        assert shardRouting.unassignedReasonIndexCreated() && !shardRouting.primary();
 */
        if (shardRouting.primary() && shardRouting.unassigned()) {  
            replicasInitialRecoveries
                }
                            + "cluster setting [%s=%d]",
        0,  
    public static final int DEFAULT_CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_RECOVERIES = 2;
            this::getPrimaryNodeOutgoingRecoveries,
    }
            this::setConcurrentOutgoingRecoverries
    private static boolean isRemoteSegmentStoreNode(ShardRouting shardRouting, RoutingAllocation allocation) {
            // count *just the primaries* currently doing recovery on the node and check against primariesInitialRecoveries  
        this.concurrentOutgoingRecoveries = concurrentOutgoingRecoveries;
        Property.Dynamic,
                concurrentOutgoingRecoveries  
            return allocation.decision(
     */
                concurrentIncomingRecoveries
        } else {
            // primary is unassigned, means we are going to do recovery from store, snapshot or local shards
            this::setReplicasInitialRecoveries
                "below shard recovery limit of incoming: [%d < %d]",  
            // search for corresponding recovery source (= primary shard) and check number of outgoing recoveries on that node
                incomingRecoveries,  
     * This method returns the corresponding initializing shard that would be allocated to this node.
    }
import org.opensearch.common.settings.ClusterSettings;
                    "below shard recovery limit of outgoing: [%d < %d] incoming: [%d < %d]",  
    }
 * node. The default is {@code 4}</li>
                        CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_RECOVERIES_SETTING.getKey()
            }  
        } else if (shardRouting.relocating()) {  
                        THROTTLE,
                        primaryNodeOutRecoveries,
                    inRecoveriesLimit
        int outgoingRecoveries = 0;  
                );
    private ShardRouting initializingShard(ShardRouting shardRouting, String currentNodeId) {  
                    "reached the limit of incoming shard recoveries [%d], cluster setting [%s=%d] (can also be set via [%s])",
 * recovery operations per node.</li>
    private Integer getInitialPrimaryNodeOutgoingRecoveries(ShardRouting shardRouting, RoutingAllocation allocation) {
        logger.debug(
                    YES,  
                    NAME,
                    );  
                // TODO: Should index creation not be throttled for primary shards?
            this::setConcurrentIncomingRecoverries  
            );
    private volatile int replicasInitialRecoveries;
    }  
        (s) -> Setting.parseInt(s, 0, "cluster.routing.allocation.node_concurrent_outgoing_recoveries"),
    }
    private Decision allocateNonInitialShardCopies(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {  
                return allocation.decision(
            if (primariesInRecovery >= primariesInitialRecoveries) {
                        CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_OUTGOING_RECOVERIES_SETTING.getKey(),  
    public Decision canMoveAway(ShardRouting shardRouting, RoutingAllocation allocation) {
    private Decision allocateInitialShardCopies(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {  
 * specific language governing permissions and limitations
        replicasInitialRecoveries = CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.get(settings);
                // throw an error as the primary it will use for recovery is not active.
                THROTTLE,  
        (s) -> Setting.parseInt(s, 0, "cluster.routing.allocation.node_concurrent_recoveries"),
import static org.opensearch.cluster.routing.allocation.decider.Decision.THROTTLE;  
                CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_INCOMING_RECOVERIES_SETTING.getKey(),
                    NAME,  
     * - the started shard routing in case if we want to check if we can relocate to this node.
            CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_PRIMARIES_RECOVERIES_SETTING,
            primariesInitialRecoveries,
        primariesInitialRecoveries = CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_PRIMARIES_RECOVERIES_SETTING.get(settings);
    }
        Property.NodeScope
                THROTTLE,  
    private volatile int concurrentOutgoingRecoveries;  
 * restricts the number of initial primary shard recovery operations on a single  
                .initialize(currentNodeId, null, ShardRouting.UNAVAILABLE_EXPECTED_SHARD_SIZE);
 * the cluster. It exposes two settings via the cluster update API that allow
    public static final Setting<Integer> CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING = Setting.intSetting(  
            int primaryNodeOutRecoveries = primaryNodeOutRecoveriesFunc.apply(shardRouting, allocation);  
 * Modifications Copyright OpenSearch Contributors. See
            ShardRouting primaryShard = allocation.routingNodes().activePrimary(shardRouting.shardId());
                outgoingRecoveries = allocation.routingNodes().getOutgoingRecoveries(primaryShard.currentNodeId());
    );
import java.util.function.BiFunction;
        int currentInRecoveries,  
                    "reached the limit of incoming shard recoveries [%d], cluster setting [%s=%d]",
        }  
 * GitHub history for details.
        Property.NodeScope  
        );  
 * @opensearch.internal
            // Peer recovery  
                return allocation.decision(Decision.NO, NAME, "primary shard for this replica is not yet active");
 * Unless required by applicable law or agreed to in writing,
                }
            }
        }
 * ownership. Elasticsearch licenses this file to you under  
            // if this is a search shard that recovers from remote store, ignore outgoing recovery limits.  
        } else {
        assert !shardRouting.unassignedReasonIndexCreated();
            allocation,
                    CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(),  
                    "Remote based search replica below incoming recovery limit: [%d < %d]",
 * <li>{@code cluster.routing.allocation.node_concurrent_recoveries} -
        } else if (shardRouting.initializing()) {
        } else {
            return allocation.decision(
import static org.opensearch.cluster.routing.allocation.decider.Decision.YES;
 * You may obtain a copy of the License at  
                    NAME,  
        concurrentIncomingRecoveries = CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_INCOMING_RECOVERIES_SETTING.get(settings);  
        );  
 *  
            node
        );
        CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_RECOVERIES_SETTING,
                return allocateNonInitialShardCopies(shardRouting, node, allocation);
        RoutingNode candidateNode
 * KIND, either express or implied.  See the License for the
            shardRouting,
 * If one of the above thresholds is exceeded per node this allocation decider
                return allocation.decision(YES, NAME, "below primary recovery limit of [%d]", primariesInitialRecoveries);  
import org.opensearch.cluster.routing.RoutingNode;
                        outRecoveriesLimit,
    public Decision canAllocateAnyShardToNode(RoutingNode node, RoutingAllocation allocation) {
            allocation,
        Property.Dynamic,
                .relocate(currentNodeId, ShardRouting.UNAVAILABLE_EXPECTED_SHARD_SIZE)
                    inRecoveriesLimit
package org.opensearch.cluster.routing.allocation.decider;
                        "reached the limit of outgoing shard recoveries [%d] on the node [%s] which holds the primary, "
 * <li>{@code cluster.routing.allocation.node_initial_primaries_recoveries} -
            replicasInitialRecoveries,  
        "cluster.routing.allocation.node_concurrent_incoming_recoveries",
            initializingShard = shardRouting.moveToUnassigned(unassignedInfo)
    }  
            "using node_concurrent_outgoing_recoveries [{}], node_concurrent_incoming_recoveries [{}], "  
     * <p>  
        int currentInRecoveries = allocation.routingNodes().getInitialIncomingRecoveries(node.nodeId());
                return allocation.decision(  
 * processes.
                NAME,
        DEFAULT_CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_RECOVERIES,
     * - the initializing shard routing if we want to assign the initializing shard to this node instead  
}  
        Property.Dynamic,
            initializingShard = shardRouting.initialize(currentNodeId, null, ShardRouting.UNAVAILABLE_EXPECTED_SHARD_SIZE);  
    );  
                        primaryNodeOutRecoveries,
            node
            concurrentIncomingRecoveries,  
    }
            return allocation.decision(  
public class ThrottlingAllocationDecider extends AllocationDecider {  
    );
                    CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_RECOVERIES_SETTING.getKey()
                    return allocation.decision(
            false,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                "too many incoming shards are currently recovering [%d], limit: [%d] cluster setting [%s=%d]",
/*  
            }  
                    inRecoveriesLimit
        return allocation.routingNodes().getInitialOutgoingRecoveries(primaryShard.currentNodeId());  
 * {@link ThrottlingAllocationDecider} controls the recovery process per node in
                concurrentIncomingRecoveries  
                NAME,
     * The shard routing passed to {@link #canAllocate(ShardRouting, RoutingNode, RoutingAllocation)} is not the initializing shard to this  
                } else {
        Property.NodeScope
    public static final Setting<Integer> CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_PRIMARIES_RECOVERIES_SETTING = Setting.intSetting(
                    NAME,
        CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_RECOVERIES_SETTING,  
        }
                    THROTTLE,
        "cluster.routing.allocation.node_concurrent_recoveries",
import org.opensearch.common.settings.Setting;  
 * compatible open source license.
        }  
import org.apache.logging.log4j.LogManager;
        ShardRouting primaryShard = allocation.routingNodes().activePrimary(shardRouting.shardId());
                return allocateInitialShardCopies(shardRouting, node, allocation);
                    return allocation.decision(  
    public static final Setting<Integer> CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_OUTGOING_RECOVERIES_SETTING = new Setting<>(
    public static final Setting<Integer> CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_INCOMING_RECOVERIES_SETTING = new Setting<>(
        "cluster.routing.allocation.node_concurrent_outgoing_recoveries",  
        return allocation.nodes().getNodes().get(shardRouting.currentNodeId()).isRemoteSegmentStoreNode();
        concurrentOutgoingRecoveries = CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_OUTGOING_RECOVERIES_SETTING.get(settings);
                    primariesInRecovery,
/*
 * software distributed under the License is distributed on an
    ) {  
            }
            CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING,
    }
                    inRecoveriesLimit,
            );  
            } else {
        "cluster.routing.allocation.node_initial_primaries_recoveries",  
                    CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_INCOMING_RECOVERIES_SETTING.getKey(),  
 * under the License.  
            }
                    YES,
        0,
                assert shardRouting.isSearchOnly();  
        clusterSettings.addSettingsUpdateConsumer(  
            if (isInitialShardCopies) {  
                outgoingRecoveries,
        return initializingShard;
        Property.Dynamic,  
        ShardRouting primaryShard = allocation.routingNodes().activePrimary(shardRouting.shardId());  
        int outRecoveriesLimit,  
                concurrentOutgoingRecoveries,
    public static final int DEFAULT_CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_RECOVERIES = 4;
import org.opensearch.cluster.routing.RecoverySource;  
            true,
    private void setReplicasInitialRecoveries(int replicasInitialRecoveries) {  
 * default is {@code 2}. Please note that this limit excludes the initial primaries
            } else {  
            } else {
    private volatile int primariesInitialRecoveries;
                        THROTTLE,  
        ShardRouting shardRouting,
    private void setPrimariesInitialRecoveries(int primariesInitialRecoveries) {
        BiFunction<ShardRouting, RoutingAllocation, Integer> primaryNodeOutRecoveriesFunc,
        RoutingAllocation allocation,
            assert shardRouting.started();
        boolean isInitialShardCopies,
            initializingShard = shardRouting.cancelRelocation()
            CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_INCOMING_RECOVERIES_SETTING,
            if (shardRouting.isSearchOnly() && candidateNode.node().isRemoteSegmentStoreNode()) {
 */
        int currentInRecoveries = allocation.routingNodes().getIncomingRecoveries(node.nodeId());  
                "too many outgoing shards are currently recovering [%d], limit: [%d] cluster setting [%s=%d]",
                CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_OUTGOING_RECOVERIES_SETTING.getKey(),
    }
                        NAME,
 * this file be licensed under the Apache-2.0 license or a
    }  
                    "reached the limit of ongoing initial primary recoveries [%d], cluster setting [%s=%d]",  
    private Decision allocateShardCopies(  
    private static final Logger logger = LogManager.getLogger(ThrottlingAllocationDecider.class);
 * will return {@link Decision#THROTTLE} as a hit to upstream logic to throttle  
            CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_OUTGOING_RECOVERIES_SETTING,  
                + "node_initial_primaries_recoveries [{}], node_initial_replicas_recoveries [{}]",
        DEFAULT_CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_RECOVERIES,
import org.opensearch.cluster.routing.ShardRouting;
            if (primaryShard != null) {  
    private volatile int concurrentIncomingRecoveries;
    }
                .getTargetRelocatingShard();
        } else {
        Property.Dynamic,  
        int incomingRecoveries = allocation.routingNodes().getIncomingRecoveries(node.nodeId());  
            assert initializingShard(shardRouting, node.nodeId()).recoverySource().getType() != RecoverySource.Type.PEER;
                    );  
            ShardRouting primaryShard = allocation.routingNodes().activePrimary(shardRouting.shardId());
     * node but:
/*  
    @Override
            } else {  
        final ShardRouting initializingShard;
                // check if the moving away search replica is using remote store, if not
                    THROTTLE,
     * - the relocating shard routing if we want to relocate to this node now instead.
                concurrentOutgoingRecoveries
        clusterSettings.addSettingsUpdateConsumer(
                if (isInitialShardCopies) {
            concurrentIncomingRecoveries,  
 * changes in real-time:  
        return allocation.routingNodes().getOutgoingRecoveries(primaryShard.currentNodeId());
 * </ul>  
        } else {
            UnassignedInfo unassignedInfo = shardRouting.unassignedInfo();
            }  
        this.primariesInitialRecoveries = primariesInitialRecoveries;  
                return allocation.decision(
 * <p>
        );  
        if (currentInRecoveries >= inRecoveriesLimit) {
                "below shard recovery limit of outgoing: [%d < %d]",  
                YES,
                    currentInRecoveries,  
            shardRouting,  
 * license agreements. See the NOTICE file distributed with
            if (primaryNodeOutRecoveries >= outRecoveriesLimit) {
                // unassigned shards must have unassignedInfo (initializing shards might not)
                );
/**  
import org.opensearch.common.settings.Setting.Property;
    /**
        if (!shardRouting.primary()) {
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
            replicasInitialRecoveries,
                    CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_PRIMARIES_RECOVERIES_SETTING.getKey(),
                YES,
 * not use this file except in compliance with the License.
            } else {
                    outRecoveriesLimit,
    }
            return allocation.decision(  
    );
                        "reached the limit of outgoing shard recoveries [%d] on the node [%s] which holds the primary, "  
import org.opensearch.common.settings.Settings;
 *
        this.concurrentIncomingRecoveries = concurrentIncomingRecoveries;
            currentInRecoveries,
    public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
        } else {
import org.apache.logging.log4j.Logger;
 * restricts the number of total concurrent shards initializing on a single node. The  
    private void setConcurrentOutgoingRecoverries(int concurrentOutgoingRecoveries) {
        // Allocating a shard to this node will increase the incoming recoveries
    );
            currentInRecoveries,  
        );  
        clusterSettings.addSettingsUpdateConsumer(
            concurrentOutgoingRecoveries,
                    NAME,
        if (incomingRecoveries >= concurrentIncomingRecoveries) {
        }
            concurrentOutgoingRecoveries,
                    return allocation.decision(Decision.NO, NAME, "primary shard for this replica is not yet active");
        );
 * this work for additional information regarding copyright
                    currentInRecoveries,  
 * Licensed to Elasticsearch under one or more contributor  
            }  
        if (shardRouting.unassigned()) {
                NAME,
                NAME,
                );  
import org.opensearch.cluster.routing.UnassignedInfo;  
                    currentInRecoveries,
        int inRecoveriesLimit,
 *     http://www.apache.org/licenses/LICENSE-2.0
            );
            );  
    public static final String NAME = "throttling";  
    @Override
