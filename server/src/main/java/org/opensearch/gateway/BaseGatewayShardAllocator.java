 * <p>
import java.util.Set;
            shardRouting.shardId().id()  
import org.opensearch.cluster.routing.allocation.AllocateUnassignedDecision;
            }  
     *
/*  
     * rejoin cancellation machinery only covers replicas.</li>
     * about whether or not the shard can be allocated by this allocator and if so, to which node it will be allocated.  
     * unassigned primary); whichever cluster-state task runs first wins and the other no-ops, since both are enabled
        ShardRouting shardRouting,  
        }
     * still empty and whose restore would lose the resize data, and a snapshot-restore target, which carries a  
     * @param unassignedAllocationHandler handles the allocation of the current shard  
        // allocation. Health stays RED while the restore hydrates (a hydrating primary cannot serve queries; see
     * never see. {@code FenceAutoRestore.tla} verifies the fenced trigger and refutes the unfenced one, so the
     * <p>
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * later in-sync reset ({@code IndexMetadataUpdater}) are atomic with the allocator's no-valid-copy proof - there  
        // on inconsistent metadata (e.g. auto_restore without fencing), never throw inside the reroute path. The KEYS
 *  
    /**
            return false;  
            // no decision was taken by this allocator
     * The auto-restore trigger (the allocation half of the remote store fence work): converts a primary this
        if (allocateUnassignedDecision.getAllocationDecision() == AllocationDecision.YES) {  
    protected final Logger logger = LogManager.getLogger(this.getClass());  
        RoutingAllocation allocation,
     * is typically still alive behind a partition and can still reach the object store. The fence's
 * The OpenSearch Contributors require contributions made to  
            if (shardRouting.recoverySource().getType() == RecoverySource.Type.SNAPSHOT) {
            shardRouting.getIndexName(),
 *
                allocation.changes()
        );  
    }
        ExistingShardsAllocator.UnassignedAllocationHandler unassignedAllocationHandler  
            // places it in this same allocation round  
        ExistingShardsAllocator.UnassignedAllocationHandler unassignedAllocationHandler
    ) {
 * the logic to determine to which nodes (if any) those shards are allocated.  
import org.opensearch.cluster.routing.allocation.ExistingShardsAllocator;  
import org.apache.logging.log4j.Logger;
 * shards to nodes based on shard copies that already exist in the cluster.  
        // flag on that reroute, which re-runs this decision.
            return;
     * @param allocation      the current routing state  
     * <li><b>Fencing required.</b> The trigger fires on the cluster manager's membership view; the departed primary
        ShardRouting shardRouting,  
     * strictly higher term, read the translog restore point after the seal, hydrate, replay.
            ShardRouting unassignedShard = iterator.next();
import org.opensearch.cluster.routing.UnassignedInfo;
 * KIND, either express or implied.  See the License for the
import org.opensearch.repositories.IndexId;
                executeDecision(unassignedShard, allocationDecision, allocation, iterator);  
        if (shardRouting.primary() == false || shardRouting.recoverySource().getType() != RecoverySource.Type.EXISTING_STORE) {
    /**
     * <li><b>Node-left delay expired.</b> The conversion waits out {@code index.unassigned.node_left.delayed_timeout}
    }  
     * @param allocation                  the allocation state container object
 */  
            // converted to a remote-store recovery; the shard stays unassigned and the shards allocator
    );
        }  
        if (shardRouting.unassignedInfo().isDelayed()) {  
 *
import org.opensearch.common.UUIDs;
     * <p>
 * Licensed to Elasticsearch under one or more contributor  
        if (decision.getAllocationStatus() != AllocationStatus.NO_VALID_SHARD_COPY) {
        ShardRouting shardRouting,
        }
 * Modifications Copyright OpenSearch Contributors. See
     *  
        }
     * is no second, racing restore task. The converted shard remains in the unassigned list; this allocator is no
        }  
     * blocked by policy - converting would abandon real data over a transient decider.</li>  
            "auto-restoring from remote store: no valid local copy on any live node [" + shardRouting.unassignedInfo().getMessage() + "]",  
            shardRouting.unassignedInfo().getUnassignedTimeInNanos(),  
import org.opensearch.core.index.shard.ShardId;  
        final RecoverySource.RemoteStoreRecoverySource recoverySource = new RecoverySource.RemoteStoreRecoverySource(
    ) {  
            if (unassignedShard.primary() == primary && shardIds.contains(unassignedShard.shardId())) {
 * not use this file except in compliance with the License.
     * @param logger          the logger
import org.opensearch.cluster.metadata.IndexMetadata;  
    }  
     * {@link #allocateUnassigned(ShardRouting, RoutingAllocation, ExistingShardsAllocator.UnassignedAllocationHandler)} to make decisions
            UUIDs.randomBase64UUID(),  
 * this work for additional information regarding copyright
import java.util.ArrayList;  
            return false;  
     * only while the primary is unassigned.  
        } else {
     * allocator has just proven unrecoverable from any live node's local store into a remote-store recovery, instead
        return true;  
            return false;
import org.opensearch.cluster.routing.allocation.decider.Decision;  
    ) {  
     * @return an {@link AllocateUnassignedDecision} with the final decision of whether to allocate and details of the decision
        // come from the Setting constants themselves, so a setting rename cannot silently detach this guard from the  
     * <li><b>{@code NO_VALID_SHARD_COPY} only.</b> {@code DECIDERS_NO} means valid copies exist and allocation is
     * <li><b>Index {@code OPEN} only.</b> A closed index acknowledges nothing and may be mid-in-place-snapshot-restore;
     * longer responsible for a {@code REMOTE_STORE}-source shard, so the balanced shards allocator places it later in
            return allocation.clusterInfo().getShardSize(shardRouting, ShardRouting.UNAVAILABLE_EXPECTED_SHARD_SIZE);
            shardRouting.unassignedInfo().getReason(),
 * the Apache License, Version 2.0 (the "License"); you may
    }
     * The operator's manual {@code _remotestore/_restore} performs the same mutation under a weaker guard (any
        // custom metadata by the directory factories, never from the recovery source's IndexId.
        AllocateUnassignedDecision decision,
        // A fresh UnassignedInfo with the original reason and a zero failure count: the conversion is not a failed
import org.opensearch.cluster.routing.ShardRouting;
     */
        }
     */
 * license agreements. See the NOTICE file distributed with
 *
     * Allocate an unassigned shard to nodes (if any) where valid copies of the shard already exist.  
            AllocationStatus.NO_ATTEMPT,  
        logger.info(  
 * SPDX-License-Identifier: Apache-2.0
 * Individual implementations of this class are responsible for providing
     * </ul>  
import org.opensearch.cluster.routing.RoutingNode;
     * It is up to the individual implementations of {@link #makeAllocationDecision(ShardRouting, RoutingAllocation, Logger)}
        if (allocateUnassignedDecision.isDecisionTaken() == false) {
        RoutingAllocation allocation,
    public void allocateUnassigned(
            null,
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
                }
    }
        for (RoutingNode node : allocation.routingNodes()) {
            results.add(new NodeAllocationResult(node.node(), null, decision));  
        Logger logger
        final Settings indexSettings = indexMetadata.getSettings();
     * Everything here happens inside the current cluster-state computation, so the recovery-source re-point and the
        }  
        if (indexMetadata.getState() != IndexMetadata.State.OPEN) {
     * of parking it at {@link AllocationStatus#NO_VALID_SHARD_COPY} (RED) to wait for a node that may never return.  
import org.opensearch.common.settings.Settings;
                    continue;  
                getExpectedShardSize(shardRouting, allocation),
            indexMetadata.getCreationVersion(),
        List<NodeAllocationResult> results = new ArrayList<>();  
                return ShardRouting.UNAVAILABLE_EXPECTED_SHARD_SIZE;
        // ClusterShardHealth#getInactivePrimaryHealth) and converges to GREEN without operator action.  
        // Honor the node-left grace window (index.unassigned.node_left.delayed_timeout): while the delay marker set
import org.opensearch.cluster.routing.UnassignedInfo.AllocationStatus;  
        // As on the manual restore path (RemoteStoreRestoreService), this IndexId is unrelated to snapshot restore,
            }
        unassignedAllocationHandler.updateUnassigned(unassignedInfo, recoverySource, allocation.changes());
}
 *    http://www.apache.org/licenses/LICENSE-2.0
     * Builds decisions for all nodes in the cluster, so that the explain API can provide information on
 * specific language governing permissions and limitations
        } else {
        RoutingNodes.UnassignedShards.UnassignedIterator iterator = allocation.routingNodes().unassigned().iterator();  
            || indexSettings.getAsBoolean(IndexMetadata.INDEX_REMOTE_STORE_AUTO_RESTORE_ENABLED_SETTING.getKey(), false) == false) {
import org.apache.logging.log4j.LogManager;
    protected void allocateUnassignedBatchOnTimeout(Set<ShardId> shardIds, RoutingAllocation allocation, boolean primary) {
     * <ul>
        final UnassignedInfo unassignedInfo = new UnassignedInfo(
            "[{}][{}] no valid shard copy on any live node; auto-restoring primary from remote store",
        return results;
     * @param shardRouting                the shard to allocate
        // this gate is the only protection, since a conversion cannot be reclaimed once made and the rejoined copy
    }  
    /**
            shardRouting.unassignedInfo().getFailedNodeIds()
 * @opensearch.internal
        executeDecision(shardRouting, allocateUnassignedDecision, allocation, unassignedAllocationHandler);
        }
                if (isResponsibleFor(unassignedShard) == false) {
        );
        }
        // so the ctor without a pathType is used: the remote path layout is resolved from the index's remote store  
            Decision decision = allocation.deciders().canAllocate(shard, node, allocation);
 */  
     * the same round. Recovery on the target then follows the fenced sequence that already ships: seal the fence at a  
            AllocateUnassignedDecision allocationDecision;  
        if (shardRouting.primary()) {
        if (indexSettings.getAsBoolean(IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.getKey(), false) == false  
/**
        }
        ShardRouting unassignedShard,
                return allocation.snapshotShardSizeInfo().getShardSize(shardRouting, ShardRouting.UNAVAILABLE_EXPECTED_SHARD_SIZE);  
    protected long getExpectedShardSize(ShardRouting shardRouting, RoutingAllocation allocation) {  
    protected abstract boolean isResponsibleFor(ShardRouting shardRouting);
 */  
import org.opensearch.cluster.routing.allocation.NodeAllocationResult;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.routing.RoutingNodes;  
        // settings the operator actually toggles.
            0,
        );
        while (iterator.hasNext()) {
            || indexSettings.getAsBoolean(IndexMetadata.INDEX_REMOTE_STORE_FENCING_ENABLED_SETTING.getKey(), false) == false
     */  
                allocateUnassignedDecision.getAllocationId(),  
/*  
        // at node-left is live, decline the conversion so a bouncing node can rejoin and reclaim its local copy.  
            shardRouting.unassignedInfo().getUnassignedTimeInMillis(),
 * You may obtain a copy of the License at  
        final IndexMetadata indexMetadata = allocation.metadata().getIndexSafe(shardRouting.index());  
package org.opensearch.gateway;
 * under the License.  
 * GitHub history for details.
        // Raw VALUE reads rather than Setting#get: get() re-runs the setting validators, and this guard must DECLINE
        if (shardIds.isEmpty()) {  
 * An abstract class that implements basic functionality for allocating
        final AllocateUnassignedDecision allocateUnassignedDecision = makeAllocationDecision(shardRouting, allocation, logger);
     * Make a decision on the allocation of an unassigned shard.  This method is used by
        RoutingAllocation allocation,  
     */
 * Unless required by applicable law or agreed to in writing,
    protected void executeDecision(
     * so a bouncing node can rejoin and recover its local copy - once converted there is no way back, since the  
    public abstract AllocateUnassignedDecision makeAllocationDecision(
     * to make decisions on assigning shards to nodes.
import org.opensearch.cluster.routing.RecoverySource;
 * software distributed under the License is distributed on an
                allocationDecision = AllocateUnassignedDecision.throttle(null);
        ExistingShardsAllocator.UnassignedAllocationHandler unassignedAllocationHandler
     * is what excludes a resize (shrink/split/clone) target mid-{@code LOCAL_SHARDS}-recovery, whose remote store is
            new IndexId(shardRouting.getIndexName(), indexMetadata.getIndexUUID(), IndexId.DEFAULT_SHARD_PATH_TYPE)
        // durable copy is the remote store), making primary-side cancellation feasible future work; until it exists,
     */
            );  
            return false;  
public abstract class BaseGatewayShardAllocator {
    private boolean maybeAutoRestoreFromRemoteStore(
        AllocateUnassignedDecision allocateUnassignedDecision,  
            false,
     * Is the allocator responsible for allocating the given {@link ShardRouting}?  
    /**  
 */
    protected static List<NodeAllocationResult> buildDecisionsForAllNodes(ShardRouting shard, RoutingAllocation allocation) {
        // reroute at expiry for any delayed unassigned shard, and AllocationService#removeDelayMarkers clears the
        } else if (maybeAutoRestoreFromRemoteStore(shardRouting, allocateUnassignedDecision, allocation, unassignedAllocationHandler)) {
     * its lifecycle operations own the shard.</li>  
        }
     * Eligibility is deliberately narrow, and each condition is load-bearing:  
        // WAS the only copy, so there was nothing to cancel in favor of. A remote-store hydration changes that (the  
        // cancelExistingRecoveryForBetterMatch) - primaries never did, because historically an initializing primary
            unassignedAllocationHandler.removeAndIgnore(allocateUnassignedDecision.getAllocationStatus(), allocation.changes());
     * {@code SNAPSHOT} source and its own retry semantics.</li>
/*
import java.util.List;
    /**  
     * allocation decisions for each node, while still waiting to allocate the shard (e.g. due to fetching shard data).  
        // is dropped as stale. No extra scheduling is needed here: DelayedAllocationService already schedules a  
     * strictly-greater-term takeover is the only thing that stops it acknowledging writes the restored copy will  
import org.opensearch.cluster.routing.allocation.AllocationDecision;
     * @param unassignedShard the unassigned shard to allocate
        // Today only replicas get the rejoin cancellation path (ReplicaShardAllocator#processExistingRecoveries ->
            return;  
                allocateUnassignedDecision.getTargetNode().getId(),
            unassignedAllocationHandler.initialize(
 * compatible open source license.
        RoutingAllocation allocation,
     * setting validator enforces the coupling and this check restates it defensively.</li>
            return false;
 * ownership. Elasticsearch licenses this file to you under  
            } else {
     * <li><b>{@code EXISTING_STORE} source only.</b> A shard that previously STARTED and owns a remote lineage. This
