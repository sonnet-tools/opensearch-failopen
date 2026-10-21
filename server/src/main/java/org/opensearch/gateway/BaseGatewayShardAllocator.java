        ShardRouting shardRouting,
import org.opensearch.common.settings.Settings;
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
 * the logic to determine to which nodes (if any) those shards are allocated.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * SPDX-License-Identifier: Apache-2.0
    protected abstract boolean isResponsibleFor(ShardRouting shardRouting);
import org.opensearch.cluster.routing.allocation.NodeAllocationResult;
                allocationDecision = AllocateUnassignedDecision.throttle(null);
        if (indexSettings.getAsBoolean(IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.getKey(), false) == false
        }
import java.util.Set;
     * @param allocation      the current routing state
        }
import org.opensearch.repositories.IndexId;
     * Allocate an unassigned shard to nodes (if any) where valid copies of the shard already exist.
/*
     */
     * strictly higher term, read the translog restore point after the seal, hydrate, replay.
/*
            0,
            ShardRouting unassignedShard = iterator.next();
 * shards to nodes based on shard copies that already exist in the cluster.
            unassignedAllocationHandler.initialize(
     * <li><b>Node-left delay expired.</b> The conversion waits out {@code index.unassigned.node_left.delayed_timeout}
 * software distributed under the License is distributed on an
        final AllocateUnassignedDecision allocateUnassignedDecision = makeAllocationDecision(shardRouting, allocation, logger);
                getExpectedShardSize(shardRouting, allocation),
        final UnassignedInfo unassignedInfo = new UnassignedInfo(
                    continue;
        // settings the operator actually toggles.
            return false;
     * is no second, racing restore task. The converted shard remains in the unassigned list; this allocator is no
 * GitHub history for details.
     * Builds decisions for all nodes in the cluster, so that the explain API can provide information on
        if (allocateUnassignedDecision.isDecisionTaken() == false) {
        if (shardIds.isEmpty()) {
            "[{}][{}] no valid shard copy on any live node; auto-restoring primary from remote store",
 * not use this file except in compliance with the License.
        unassignedAllocationHandler.updateUnassigned(unassignedInfo, recoverySource, allocation.changes());
    }
     * its lifecycle operations own the shard.</li>
     * unassigned primary); whichever cluster-state task runs first wins and the other no-ops, since both are enabled
     *
            unassignedAllocationHandler.removeAndIgnore(allocateUnassignedDecision.getAllocationStatus(), allocation.changes());
     * The auto-restore trigger (the allocation half of the remote store fence work): converts a primary this
     * <li><b>Index {@code OPEN} only.</b> A closed index acknowledges nothing and may be mid-in-place-snapshot-restore;
    protected void executeDecision(
     * allocation decisions for each node, while still waiting to allocate the shard (e.g. due to fetching shard data).
            if (unassignedShard.primary() == primary && shardIds.contains(unassignedShard.shardId())) {
     * <li><b>Fencing required.</b> The trigger fires on the cluster manager's membership view; the departed primary
            Decision decision = allocation.deciders().canAllocate(shard, node, allocation);
     */
            "auto-restoring from remote store: no valid local copy on any live node [" + shardRouting.unassignedInfo().getMessage() + "]",
        // cancelExistingRecoveryForBetterMatch) - primaries never did, because historically an initializing primary
     * rejoin cancellation machinery only covers replicas.</li>
     * only while the primary is unassigned.
        RoutingAllocation allocation,
 * Individual implementations of this class are responsible for providing
     * is what excludes a resize (shrink/split/clone) target mid-{@code LOCAL_SHARDS}-recovery, whose remote store is
import org.opensearch.common.UUIDs;
        // come from the Setting constants themselves, so a setting rename cannot silently detach this guard from the
            // no decision was taken by this allocator
                if (isResponsibleFor(unassignedShard) == false) {
 *
     */
     * about whether or not the shard can be allocated by this allocator and if so, to which node it will be allocated.
    /**
    public abstract AllocateUnassignedDecision makeAllocationDecision(
        if (shardRouting.unassignedInfo().isDelayed()) {
        } else {
    ) {
 */
        RoutingAllocation allocation,
 * the Apache License, Version 2.0 (the "License"); you may
        // custom metadata by the directory factories, never from the recovery source's IndexId.
/*
    );
 */
     * never see. {@code FenceAutoRestore.tla} verifies the fenced trigger and refutes the unfenced one, so the
        while (iterator.hasNext()) {
        // on inconsistent metadata (e.g. auto_restore without fencing), never throw inside the reroute path. The KEYS
     * @param allocation                  the allocation state container object
        } else if (maybeAutoRestoreFromRemoteStore(shardRouting, allocateUnassignedDecision, allocation, unassignedAllocationHandler)) {
        // flag on that reroute, which re-runs this decision.
 * specific language governing permissions and limitations
    /**
     * {@code SNAPSHOT} source and its own retry semantics.</li>
            results.add(new NodeAllocationResult(node.node(), null, decision));
 * this work for additional information regarding copyright
        List<NodeAllocationResult> results = new ArrayList<>();
    /**
                return ShardRouting.UNAVAILABLE_EXPECTED_SHARD_SIZE;
import org.apache.logging.log4j.Logger;
 * An abstract class that implements basic functionality for allocating
    private boolean maybeAutoRestoreFromRemoteStore(
            } else {
            return false;
        return true;
        if (indexMetadata.getState() != IndexMetadata.State.OPEN) {
     * @param unassignedShard the unassigned shard to allocate
import org.opensearch.cluster.routing.ShardRouting;
        }
import org.opensearch.cluster.routing.allocation.AllocateUnassignedDecision;
import org.opensearch.cluster.routing.allocation.decider.Decision;
import org.opensearch.cluster.routing.UnassignedInfo;
                allocateUnassignedDecision.getAllocationId(),
import java.util.ArrayList;
     * </ul>
     * @param logger          the logger
            shardRouting.getIndexName(),
     * @param unassignedAllocationHandler handles the allocation of the current shard
        );
import org.opensearch.cluster.routing.allocation.ExistingShardsAllocator;
/**
        // ClusterShardHealth#getInactivePrimaryHealth) and converges to GREEN without operator action.
 *
        );
        }
import org.opensearch.cluster.routing.RoutingNodes;
     * is typically still alive behind a partition and can still reach the object store. The fence's
        // this gate is the only protection, since a conversion cannot be reclaimed once made and the rejoined copy
}
import org.opensearch.cluster.routing.RecoverySource;
        RoutingAllocation allocation,
            AllocateUnassignedDecision allocationDecision;
     * @param shardRouting                the shard to allocate
 */
        AllocateUnassignedDecision decision,
        if (shardRouting.primary() == false || shardRouting.recoverySource().getType() != RecoverySource.Type.EXISTING_STORE) {
     * <p>
        // WAS the only copy, so there was nothing to cancel in favor of. A remote-store hydration changes that (the
     * so a bouncing node can rejoin and recover its local copy - once converted there is no way back, since the
     * <p>
        if (decision.getAllocationStatus() != AllocationStatus.NO_VALID_SHARD_COPY) {
    }
        ExistingShardsAllocator.UnassignedAllocationHandler unassignedAllocationHandler
            );
                }
        // allocation. Health stays RED while the restore hydrates (a hydrating primary cannot serve queries; see
            || indexSettings.getAsBoolean(IndexMetadata.INDEX_REMOTE_STORE_FENCING_ENABLED_SETTING.getKey(), false) == false
 * You may obtain a copy of the License at
     * {@link #allocateUnassigned(ShardRouting, RoutingAllocation, ExistingShardsAllocator.UnassignedAllocationHandler)} to make decisions
    /**
                return allocation.snapshotShardSizeInfo().getShardSize(shardRouting, ShardRouting.UNAVAILABLE_EXPECTED_SHARD_SIZE);
    public void allocateUnassigned(
            shardRouting.shardId().id()
            // places it in this same allocation round
        RoutingNodes.UnassignedShards.UnassignedIterator iterator = allocation.routingNodes().unassigned().iterator();
     * @return an {@link AllocateUnassignedDecision} with the final decision of whether to allocate and details of the decision
                executeDecision(unassignedShard, allocationDecision, allocation, iterator);
        }
            UUIDs.randomBase64UUID(),
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.cluster.routing.UnassignedInfo.AllocationStatus;
        final IndexMetadata indexMetadata = allocation.metadata().getIndexSafe(shardRouting.index());
 */
            new IndexId(shardRouting.getIndexName(), indexMetadata.getIndexUUID(), IndexId.DEFAULT_SHARD_PATH_TYPE)
    protected final Logger logger = LogManager.getLogger(this.getClass());
        ExistingShardsAllocator.UnassignedAllocationHandler unassignedAllocationHandler
            }
 * <p>
     * allocator has just proven unrecoverable from any live node's local store into a remote-store recovery, instead
 * @opensearch.internal
     * Is the allocator responsible for allocating the given {@link ShardRouting}?
        return results;
            return false;
            return false;
 *
     * <ul>
     * strictly-greater-term takeover is the only thing that stops it acknowledging writes the restored copy will
    protected long getExpectedShardSize(ShardRouting shardRouting, RoutingAllocation allocation) {
     * blocked by policy - converting would abandon real data over a transient decider.</li>
        ShardRouting shardRouting,
import org.opensearch.core.index.shard.ShardId;
        }
        // at node-left is live, decline the conversion so a bouncing node can rejoin and reclaim its local copy.
            return;
            false,
                allocateUnassignedDecision.getTargetNode().getId(),
        AllocateUnassignedDecision allocateUnassignedDecision,
        RoutingAllocation allocation,
        }
            }
    }
        // Today only replicas get the rejoin cancellation path (ReplicaShardAllocator#processExistingRecoveries ->
     */
     * of parking it at {@link AllocationStatus#NO_VALID_SHARD_COPY} (RED) to wait for a node that may never return.
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.cluster.routing.allocation.AllocationDecision;
 * Licensed to Elasticsearch under one or more contributor
        // is dropped as stale. No extra scheduling is needed here: DelayedAllocationService already schedules a
            || indexSettings.getAsBoolean(IndexMetadata.INDEX_REMOTE_STORE_AUTO_RESTORE_ENABLED_SETTING.getKey(), false) == false) {
    }
        // Raw VALUE reads rather than Setting#get: get() re-runs the setting validators, and this guard must DECLINE
     */
            return;
     *
        ExistingShardsAllocator.UnassignedAllocationHandler unassignedAllocationHandler
            // converted to a remote-store recovery; the shard stays unassigned and the shards allocator
    protected void allocateUnassignedBatchOnTimeout(Set<ShardId> shardIds, RoutingAllocation allocation, boolean primary) {
    ) {
            shardRouting.unassignedInfo().getFailedNodeIds()
        if (allocateUnassignedDecision.getAllocationDecision() == AllocationDecision.YES) {
import org.apache.logging.log4j.LogManager;
            null,
import org.opensearch.cluster.metadata.IndexMetadata;
 * ownership. Elasticsearch licenses this file to you under
import java.util.List;
        for (RoutingNode node : allocation.routingNodes()) {
    }
     * The operator's manual {@code _remotestore/_restore} performs the same mutation under a weaker guard (any
            shardRouting.unassignedInfo().getUnassignedTimeInMillis(),
        ShardRouting unassignedShard,
    /**
public abstract class BaseGatewayShardAllocator {
            AllocationStatus.NO_ATTEMPT,
        final Settings indexSettings = indexMetadata.getSettings();
 * compatible open source license.
     * longer responsible for a {@code REMOTE_STORE}-source shard, so the balanced shards allocator places it later in
 * The OpenSearch Contributors require contributions made to
            indexMetadata.getCreationVersion(),
        // A fresh UnassignedInfo with the original reason and a zero failure count: the conversion is not a failed
            shardRouting.unassignedInfo().getUnassignedTimeInNanos(),
        // durable copy is the remote store), making primary-side cancellation feasible future work; until it exists,
     * still empty and whose restore would lose the resize data, and a snapshot-restore target, which carries a
        }
     * Everything here happens inside the current cluster-state computation, so the recovery-source re-point and the
        // reroute at expiry for any delayed unassigned shard, and AllocationService#removeDelayMarkers clears the
     * later in-sync reset ({@code IndexMetadataUpdater}) are atomic with the allocator's no-valid-copy proof - there
     * It is up to the individual implementations of {@link #makeAllocationDecision(ShardRouting, RoutingAllocation, Logger)}
        );
        // As on the manual restore path (RemoteStoreRestoreService), this IndexId is unrelated to snapshot restore,
package org.opensearch.gateway;
 * under the License.
 * Modifications Copyright OpenSearch Contributors. See
        if (shardRouting.primary()) {
     * <li><b>{@code EXISTING_STORE} source only.</b> A shard that previously STARTED and owns a remote lineage. This
        } else {
    }
    ) {
import org.opensearch.cluster.routing.RoutingNode;
     * the same round. Recovery on the target then follows the fenced sequence that already ships: seal the fence at a
     * Eligibility is deliberately narrow, and each condition is load-bearing:
        }
        }
        // Honor the node-left grace window (index.unassigned.node_left.delayed_timeout): while the delay marker set
        ShardRouting shardRouting,
    protected static List<NodeAllocationResult> buildDecisionsForAllNodes(ShardRouting shard, RoutingAllocation allocation) {
 *
     * Make a decision on the allocation of an unassigned shard.  This method is used by
            if (shardRouting.recoverySource().getType() == RecoverySource.Type.SNAPSHOT) {
        final RecoverySource.RemoteStoreRecoverySource recoverySource = new RecoverySource.RemoteStoreRecoverySource(
        Logger logger
 * KIND, either express or implied.  See the License for the
        logger.info(
            return allocation.clusterInfo().getShardSize(shardRouting, ShardRouting.UNAVAILABLE_EXPECTED_SHARD_SIZE);
            return false;
     * setting validator enforces the coupling and this check restates it defensively.</li>
                allocation.changes()
 * license agreements. See the NOTICE file distributed with
        executeDecision(shardRouting, allocateUnassignedDecision, allocation, unassignedAllocationHandler);
        }
     * <li><b>{@code NO_VALID_SHARD_COPY} only.</b> {@code DECIDERS_NO} means valid copies exist and allocation is
     * to make decisions on assigning shards to nodes.
            shardRouting.unassignedInfo().getReason(),
        // so the ctor without a pathType is used: the remote path layout is resolved from the index's remote store
