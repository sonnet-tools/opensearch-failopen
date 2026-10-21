        ClusterInfo clusterInfo,
            ignoredShardToNodes = new HashMap<>();
     * Get discovery nodes in current routing
    public RoutingChangesObserver changes() {
     * @return routing nodes
    }
     * @param decision decision whether to allow/deny allocation
    }
     * {@link org.opensearch.cluster.routing.allocation.decider.AwarenessAllocationDecider}, which is consulted once
 *  @opensearch.api
        this.ignoreDisable = ignoreDisable;
    private final ClusterInfo clusterInfo;
        return clusterInfo;
     * the specified shard failed on that node, triggering the current round of allocation.  Since the shard
    }
    }
 * specific language governing permissions and limitations
        this.nodes = clusterState.nodes();
    }
    }
 * license agreements. See the NOTICE file distributed with
    private final SnapshotShardSizeInfo shardSizeInfo;
    /**
     * @param clusterState cluster state before rerouting
         */
    }
        }
        this.clusterInfo = clusterInfo;
         * debug mode is on, but YES decisions from a {@link Decision.Multi}
 * not use this file except in compliance with the License.
     */
     * @return true if the node id should be ignored in allocation decisions, false otherwise
    }
        if (ignoredShardToNodes == null) {
        }
    /**
        this.debugDecision = debug ? DebugMode.ON : DebugMode.OFF;
    private final RoutingNodes routingNodes;
    private final DiscoveryNodes nodes;
     * Returns updated {@link Metadata} based on the changes that were made to the routing nodes
 */
    public boolean routingNodesChanged() {
        return routingTable;
        return this.debugDecision;
     */
    private final Map<String, ClusterState.Custom> customs;
import static java.util.Collections.unmodifiableSet;
    }
        /**
    );
        return nodesChangedObserver.isChanged();
package org.opensearch.cluster.routing.allocation;
    private final IndexMetadataUpdater indexMetadataUpdater = new IndexMetadataUpdater();
    /**
     * Get {@link AllocationDeciders} used for allocation
    }
    }
    public RoutingNodes routingNodes() {
    /**
         * are not included.
    public boolean shouldIgnoreShardForNode(ShardId shardId, String nodeId) {
     * @return discovery nodes
    /**
        if (ignoredShardToNodes == null) {
    public void addIgnoreShardForNode(ShardId shardId, String nodeId) {
    public RoutingAllocation(
    public Set<String> awarenessAttributeValues(String attributeName, boolean searchOnly) {
    public enum DebugMode {
     * @param routingNodes Routing nodes in the current cluster
    ) {
import java.util.HashMap;
        AllocationDeciders deciders,
    public Decision decision(Decision decision, String deciderLabel, String reason, Object... params) {
    public DiscoveryNodes nodes() {
        this(deciders, routingNodes, clusterState, clusterInfo, shardSizeInfo, currentNanoTime, Settings.EMPTY);
        }
        indexMetadataUpdater,
            return emptySet();
     * @param deciderLabel a human readable label for the AllocationDecider
        return this.deciders;
     * @return Metadata of routing nodes
     * @param nodeId the node id to check against
        return clusterSettings;
     * per (shard, node) pair, so the result is memoized here. The memo is valid only for this allocation round: a new
    public boolean hasPendingAsyncFetch() {
         */
        this.shardSizeInfo = shardSizeInfo;
 * SPDX-License-Identifier: Apache-2.0
    public void ignoreDisable(boolean ignoreDisable) {
    public <T extends ClusterState.Custom> T custom(String key) {
     * @param clusterState cluster state before rerouting
     * Returns <code>true</code> iff the current allocation run has not processed all of the in-flight or available
            awarenessAttributeValues = new AwarenessAttributeValues(this);
        }
    public Set<String> getIgnoreNodes(ShardId shardId) {
         * debug mode is on
     * @param shardId the shard id to be allocated
     * Sets a flag that signals that current allocation run has not processed all of the in-flight or available shard or store fetches.
public class RoutingAllocation {
import org.opensearch.cluster.ClusterInfo;
        this.hasPendingAsyncFetch = true;
import org.opensearch.snapshots.RestoreService.RestoreInProgressUpdater;
import org.opensearch.cluster.metadata.Metadata;
        return currentNanoTime;
import org.opensearch.core.index.shard.ShardId;
import org.opensearch.common.settings.Settings;
        return restoreInProgressUpdater.applyChanges(restoreInProgress);
    private AwarenessAttributeValues awarenessAttributeValues = null;
    public ClusterInfo clusterInfo() {
     *
     */
        if (debugDecision()) {
        restoreInProgressUpdater
        return nodes;
        }
            return emptySet();
        Set<String> nodes = ignoredShardToNodes.get(shardId);
 * compatible open source license.
     */
     * Get metadata of routing nodes
    public void setDebugMode(DebugMode debug) {
    @PublicApi(since = "1.0.0")
import static java.util.Collections.emptySet;
        this.currentNanoTime = currentNanoTime;
    }
    public RestoreInProgress updateRestoreInfoWithRoutingChanges(RestoreInProgress restoreInProgress) {
     * Creates a new {@link RoutingAllocation}
     * Returns whether the given node id should be ignored from consideration when {@link AllocationDeciders}
    }
        return this.debugDecision != DebugMode.OFF;
    private final RoutingChangesObserver routingChangesObserver = new RoutingChangesObserver.DelegatingRoutingChangesObserver(
    public SnapshotShardSizeInfo snapshotShardSizeInfo() {
        AllocationDeciders deciders,
        return hasPendingAsyncFetch;
    }
    /**
         */
     * Returns the distinct values of the given awareness attribute across the nodes eligible to hold a shard of the
    }
        /**
     * This state is anti-viral and can be reset in on allocation run.
import org.opensearch.snapshots.SnapshotShardSizeInfo;
        this.metadata = clusterState.metadata();
        if (ignoredShardToNodes == null) {
    /**
        return indexMetadataUpdater.applyChanges(metadata, newRoutingTable, nodes());
    public Metadata metadata() {
    private Map<ShardId, Set<String>> ignoredShardToNodes = null;
    private final RoutingNodesChangedObserver nodesChangedObserver = new RoutingNodesChangedObserver();
    }
        ON,
     * @param reason a format string explanation of the decision
     */
 * under the License.
        /**
     * shard or store fetches. Otherwise <code>true</code>
        OFF,
        return shardSizeInfo;
 *  for the current routing state.
     */
        this.routingNodes = routingNodes;
     * @param routingNodes Routing nodes in the current cluster
    /**
    ) {
     * turned on
     *
    private DebugMode debugDecision = DebugMode.OFF;
     */
     * given type, with the cluster-level allocation exclude filters applied. Used by
    private final long currentNanoTime;
 * of shards and holds the {@link AllocationDeciders} which are responsible
    /**
        return routingChangesObserver;
    public void setHasPendingAsyncFetch() {
        this.clusterSettings = Settings.builder().put(nodeSettings).put(metadata.settings()).build();
    /** returns the nano time captured at the beginning of the allocation. used to make sure all time based decisions are aligned */
        this.routingTable = clusterState.routingTable();
        this.debugDecision = debug;
import org.opensearch.common.annotation.PublicApi;
        SnapshotShardSizeInfo shardSizeInfo,
        } else {
    }
    public boolean debugDecision() {
        RoutingNodes routingNodes,
     * Creates a new {@link RoutingAllocation}
     *
    public void debugDecision(boolean debug) {
    public RoutingAllocation(
 */
     *  @param deciders {@link AllocationDeciders} to used to make decisions for routing allocations
    private final AllocationDeciders deciders;
import org.opensearch.cluster.routing.ShardRouting;
        RoutingNodes routingNodes,
    }
        return nodes != null && nodes.contains(nodeId);
    /**
    }
 * this file be licensed under the Apache-2.0 license or a
 *
/*
 */
        ClusterState clusterState,
    public long getCurrentNanoTime() {
 */
     * Get routing table of current nodes
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        if (isMigratingToRemoteStore(metadata)) {
     */
        return this.ignoreDisable;
        if (awarenessAttributeValues == null) {
import java.util.Set;
     */
            return false;
 * this work for additional information regarding copyright
    private boolean ignoreDisable = false;
    public void removeAllocationId(ShardRouting shardRouting) {
     * {@link RoutingAllocation} is created per round, so it is discarded along with it and never needs invalidating.
     */
     * Remove the allocation id of the provided shard from the set of in-sync shard copies
        EXCLUDE_YES_DECISIONS
    }
     * just failed on that node, we don't want to try to reassign it there, if the node is still a part
     */
 * Unless required by applicable law or agreed to in writing,
     * @param nodeSettings node level settings to use as defaults for cluster scoped settings
    private final RestoreInProgressUpdater restoreInProgressUpdater = new RestoreInProgressUpdater();
 *     http://www.apache.org/licenses/LICENSE-2.0
@PublicApi(since = "1.0.0")
    /**
/**
        long currentNanoTime
    }
     */
    public Settings clusterSettings() {
     * @param currentNanoTime the nano time to use for all delay allocation calculation (typically {@link System#nanoTime()})
        return awarenessAttributeValues.get(attributeName, searchOnly);
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
        }
    /**
     * @param searchOnly    whether the shard is search-only, selecting search nodes rather than data nodes
    }
    /**
     * is deciding whether to allocate the specified shard id to that node.  The node will be ignored if
    private final Metadata metadata;
        this.customs = clusterState.customs();
     * Get current routing nodes
        SnapshotShardSizeInfo shardSizeInfo,
    }
            indexMetadataUpdater.setOngoingRemoteStoreMigration(true);
    /**
        Set<String> ignore = ignoredShardToNodes.get(shardId);
 *
/*
 *
     * Returns updated {@link RestoreInProgress} based on the changes that were made to the routing nodes
 * the Apache License, Version 2.0 (the "License"); you may
}
 * You may obtain a copy of the License at
    /**
        nodesChangedObserver,
    public AllocationDeciders deciders() {
import org.opensearch.cluster.node.DiscoveryNodes;
     */
import org.opensearch.cluster.routing.RoutingTable;
    }
     * @param currentNanoTime the nano time to use for all delay allocation calculation (typically {@link System#nanoTime()})
     * of the cluster.
    }
        this.deciders = deciders;
        return metadata;
 * KIND, either express or implied.  See the License for the
     * Returns true iff changes were made to the routing nodes
         * debug mode is off
import org.opensearch.cluster.routing.RoutingChangesObserver;
 * GitHub history for details.
        Settings nodeSettings
 * The OpenSearch Contributors require contributions made to
 * The {@link RoutingAllocation} keep the state of the current allocation
import java.util.HashSet;
    public DebugMode getDebugMode() {
     * @param params format string parameters
     */
    }
     * @return {@link AllocationDeciders} used for allocation
 * Licensed to Elasticsearch under one or more contributor
        ignoredShardToNodes.computeIfAbsent(shardId, k -> new HashSet<>()).add(nodeId);
        }
    /**
     */
     */
/*
import static org.opensearch.node.remotestore.RemoteStoreNodeService.isMigratingToRemoteStore;
        if (ignore == null) {
        return (T) customs.get(key);
    /**
        ClusterInfo clusterInfo,
 * software distributed under the License is distributed on an
    }
     * Debug mode.
     * @param attributeName the awareness attribute to collect values for
    public Map<String, ClusterState.Custom> getCustoms() {
    }
            return decision;
import org.opensearch.cluster.ClusterState;
    }
        return unmodifiableSet(new HashSet<>(ignore));
import org.opensearch.cluster.RestoreInProgress;
        return customs;
     * @return current routing table
     */
        return routingNodes;
     * @opensearch.api
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.cluster.routing.RoutingNodes;
     * Create a routing decision, including the reason if the debug flag is
 * ownership. Elasticsearch licenses this file to you under
    public boolean ignoreDisable() {
    private boolean hasPendingAsyncFetch = false;
import org.opensearch.cluster.routing.allocation.decider.Decision;
    private final RoutingTable routingTable;
     */
     *  @param deciders {@link AllocationDeciders} to used to make decisions for routing allocations
import java.util.Map;
 *
    }
            return Decision.single(decision.type(), deciderLabel, reason, params);
    }
        indexMetadataUpdater.removeAllocationId(shardRouting);
        ClusterState clusterState,
    /**
    public Metadata updateMetadataWithRoutingChanges(RoutingTable newRoutingTable) {
    /**
     */
     * Returns observer to use for changes made to the routing nodes
        long currentNanoTime,
    public RoutingTable routingTable() {
    }
    private final Settings clusterSettings;
     * Returns cluster scoped settings, including node-level defaults overridden by dynamic cluster-state settings.
