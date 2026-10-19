        return nodes;
     * turned on  
    public enum DebugMode {  
        ClusterInfo clusterInfo,
     *  @param deciders {@link AllocationDeciders} to used to make decisions for routing allocations  
    }
        return awarenessAttributeValues.get(attributeName, searchOnly);
     * @param nodeSettings node level settings to use as defaults for cluster scoped settings
        if (ignoredShardToNodes == null) {
     * Sets a flag that signals that current allocation run has not processed all of the in-flight or available shard or store fetches.
    }
        this.ignoreDisable = ignoreDisable;  
    }
        return clusterSettings;
import org.opensearch.cluster.ClusterInfo;
import org.opensearch.cluster.routing.RoutingTable;
     * per (shard, node) pair, so the result is memoized here. The memo is valid only for this allocation round: a new  
        this.routingNodes = routingNodes;
    public void setHasPendingAsyncFetch() {
    private final ClusterInfo clusterInfo;  
    }
    /**
    ) {  
    public Metadata updateMetadataWithRoutingChanges(RoutingTable newRoutingTable) {
    public Map<String, ClusterState.Custom> getCustoms() {
     *
            return emptySet();  
            return decision;
    /**  
     * @param attributeName the awareness attribute to collect values for  
 * license agreements. See the NOTICE file distributed with
        }  
import static java.util.Collections.unmodifiableSet;  
import org.opensearch.cluster.metadata.Metadata;
    /**
 */
import org.opensearch.cluster.ClusterState;
        this.metadata = clusterState.metadata();
    }  
    }  
    }  
    public <T extends ClusterState.Custom> T custom(String key) {  
        restoreInProgressUpdater
        return routingTable;  
     * @return discovery nodes
        if (ignore == null) {
        return routingChangesObserver;
     * Returns <code>true</code> iff the current allocation run has not processed all of the in-flight or available  
     * shard or store fetches. Otherwise <code>true</code>
}  
        RoutingNodes routingNodes,
         */  
 * Unless required by applicable law or agreed to in writing,
        return unmodifiableSet(new HashSet<>(ignore));
    private final AllocationDeciders deciders;
    public Decision decision(Decision decision, String deciderLabel, String reason, Object... params) {  
import org.opensearch.common.annotation.PublicApi;  
     * Returns the distinct values of the given awareness attribute across the nodes eligible to hold a shard of the  
        /**
 *
            ignoredShardToNodes = new HashMap<>();  
     */
import java.util.HashMap;  
     * Get {@link AllocationDeciders} used for allocation  
    public DebugMode getDebugMode() {
        ClusterState clusterState,
        /**  
 * the Apache License, Version 2.0 (the "License"); you may
    /**
     * just failed on that node, we don't want to try to reassign it there, if the node is still a part  
    /**
        EXCLUDE_YES_DECISIONS
 * software distributed under the License is distributed on an
        if (awarenessAttributeValues == null) {
        indexMetadataUpdater,  
     */  
     */
    }  
    /**  
        ignoredShardToNodes.computeIfAbsent(shardId, k -> new HashSet<>()).add(nodeId);
     * the specified shard failed on that node, triggering the current round of allocation.  Since the shard
     * @return true if the node id should be ignored in allocation decisions, false otherwise
     * @param nodeId the node id to check against
    public void debugDecision(boolean debug) {
    public Set<String> getIgnoreNodes(ShardId shardId) {  
        return this.deciders;
 * compatible open source license.
        this.debugDecision = debug;
         */  
        }
     */  
    public void setDebugMode(DebugMode debug) {
    public void removeAllocationId(ShardRouting shardRouting) {
 *  
 *  for the current routing state.  
    private final RestoreInProgressUpdater restoreInProgressUpdater = new RestoreInProgressUpdater();  
    public void addIgnoreShardForNode(ShardId shardId, String nodeId) {
    public AllocationDeciders deciders() {  
        AllocationDeciders deciders,
 *
    }
     * @param currentNanoTime the nano time to use for all delay allocation calculation (typically {@link System#nanoTime()})  
     * @param currentNanoTime the nano time to use for all delay allocation calculation (typically {@link System#nanoTime()})  
    public boolean hasPendingAsyncFetch() {  
import org.opensearch.cluster.RestoreInProgress;  
     * @return routing nodes
     * Remove the allocation id of the provided shard from the set of in-sync shard copies  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * of the cluster.
    private final long currentNanoTime;
        }
        return this.debugDecision != DebugMode.OFF;
     */
import org.opensearch.cluster.node.DiscoveryNodes;
        /**
     * Returns whether the given node id should be ignored from consideration when {@link AllocationDeciders}  
            indexMetadataUpdater.setOngoingRemoteStoreMigration(true);
    /** returns the nano time captured at the beginning of the allocation. used to make sure all time based decisions are aligned */  
            awarenessAttributeValues = new AwarenessAttributeValues(this);
    public DiscoveryNodes nodes() {  
    ) {
    public boolean ignoreDisable() {  
 *  @opensearch.api
    }
    public RoutingAllocation(
     * Get routing table of current nodes
         * debug mode is off
 * GitHub history for details.
        this.shardSizeInfo = shardSizeInfo;
     * @return current routing table  
        ON,
        this.hasPendingAsyncFetch = true;  
    private final RoutingTable routingTable;  
            return false;  
     * Returns updated {@link RestoreInProgress} based on the changes that were made to the routing nodes  
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
    }  
    }
        } else {  
    public boolean debugDecision() {  
import org.opensearch.common.settings.Settings;
    /**
     * @param clusterState cluster state before rerouting
     */
/*  
        indexMetadataUpdater.removeAllocationId(shardRouting);  
     * @param params format string parameters
        return nodesChangedObserver.isChanged();
     */  
        return (T) customs.get(key);
     * Returns cluster scoped settings, including node-level defaults overridden by dynamic cluster-state settings.
     * Returns true iff changes were made to the routing nodes
     * This state is anti-viral and can be reset in on allocation run.  
     */
        long currentNanoTime
     */
     * Get current routing nodes
     *
    /**  
import org.opensearch.cluster.routing.RoutingNodes;
 * SPDX-License-Identifier: Apache-2.0
        return routingNodes;
    }
     * Get discovery nodes in current routing  
    private final Metadata metadata;
import org.opensearch.cluster.routing.RoutingChangesObserver;  
    private boolean hasPendingAsyncFetch = false;  
    /**
    public boolean shouldIgnoreShardForNode(ShardId shardId, String nodeId) {
        return restoreInProgressUpdater.applyChanges(restoreInProgress);  
     */
     * Create a routing decision, including the reason if the debug flag is
 */  
     * @param decision decision whether to allow/deny allocation
     */
     * {@link RoutingAllocation} is created per round, so it is discarded along with it and never needs invalidating.
     * given type, with the cluster-level allocation exclude filters applied. Used by
    }  
        this.deciders = deciders;  
    private final Settings clusterSettings;
        SnapshotShardSizeInfo shardSizeInfo,
     * @return {@link AllocationDeciders} used for allocation
     * @param searchOnly    whether the shard is search-only, selecting search nodes rather than data nodes
    public ClusterInfo clusterInfo() {
 */  
    /**
    private boolean ignoreDisable = false;
        SnapshotShardSizeInfo shardSizeInfo,
 * The {@link RoutingAllocation} keep the state of the current allocation
        return hasPendingAsyncFetch;
    );
    public RoutingTable routingTable() {
 * KIND, either express or implied.  See the License for the
import java.util.Map;
    public Settings clusterSettings() {
         * are not included.
         * debug mode is on, but YES decisions from a {@link Decision.Multi}
        AllocationDeciders deciders,  
        if (debugDecision()) {
        Set<String> ignore = ignoredShardToNodes.get(shardId);
        this.debugDecision = debug ? DebugMode.ON : DebugMode.OFF;  
     */
 * You may obtain a copy of the License at  
    /**  
     *
     * Returns observer to use for changes made to the routing nodes
 * not use this file except in compliance with the License.
import java.util.HashSet;
        Set<String> nodes = ignoredShardToNodes.get(shardId);
     * @param routingNodes Routing nodes in the current cluster
        this.routingTable = clusterState.routingTable();
     */
    }
    /**
         * debug mode is on  
     */
    }  
        OFF,
    public Set<String> awarenessAttributeValues(String attributeName, boolean searchOnly) {  
    }
        RoutingNodes routingNodes,
    public RoutingChangesObserver changes() {  
import org.opensearch.snapshots.SnapshotShardSizeInfo;
    private final IndexMetadataUpdater indexMetadataUpdater = new IndexMetadataUpdater();
package org.opensearch.cluster.routing.allocation;
 *
 * Modifications Copyright OpenSearch Contributors. See
        nodesChangedObserver,
     * Debug mode.
 * Licensed to Elasticsearch under one or more contributor  
import static org.opensearch.node.remotestore.RemoteStoreNodeService.isMigratingToRemoteStore;
        ClusterState clusterState,  
     * @param routingNodes Routing nodes in the current cluster
        }
    private AwarenessAttributeValues awarenessAttributeValues = null;  
    }
        if (ignoredShardToNodes == null) {
    }
    public RoutingNodes routingNodes() {
import static java.util.Collections.emptySet;
 * ownership. Elasticsearch licenses this file to you under  
    private final DiscoveryNodes nodes;
    /**
     * @return Metadata of routing nodes
    }
    }  
    }  
 */  
    /**
    private Map<ShardId, Set<String>> ignoredShardToNodes = null;
        this.clusterSettings = Settings.builder().put(nodeSettings).put(metadata.settings()).build();  
    /**
     * Creates a new {@link RoutingAllocation}
     * Creates a new {@link RoutingAllocation}
/**  
    public long getCurrentNanoTime() {
/*  
    /**
 *     http://www.apache.org/licenses/LICENSE-2.0
        return metadata;
        Settings nodeSettings
    /**
    public boolean routingNodesChanged() {  
    }  
 * of shards and holds the {@link AllocationDeciders} which are responsible
import org.opensearch.cluster.routing.allocation.decider.Decision;
/*
        this.nodes = clusterState.nodes();
        }  
    private final RoutingChangesObserver routingChangesObserver = new RoutingChangesObserver.DelegatingRoutingChangesObserver(
    /**
    public RestoreInProgress updateRestoreInfoWithRoutingChanges(RestoreInProgress restoreInProgress) {
        return customs;
         */
    }
    }
     * @param reason a format string explanation of the decision  
    public SnapshotShardSizeInfo snapshotShardSizeInfo() {
    }  
        }
        long currentNanoTime,  
    /**
        }  
    private final RoutingNodes routingNodes;  
    }
     * @param shardId the shard id to be allocated  
@PublicApi(since = "1.0.0")
     * Get metadata of routing nodes  
     * @opensearch.api  
     */  
        this.currentNanoTime = currentNanoTime;  
    public void ignoreDisable(boolean ignoreDisable) {
    }
import org.opensearch.core.index.shard.ShardId;
     * @param deciderLabel a human readable label for the AllocationDecider
        return indexMetadataUpdater.applyChanges(metadata, newRoutingTable, nodes());
     */
        this(deciders, routingNodes, clusterState, clusterInfo, shardSizeInfo, currentNanoTime, Settings.EMPTY);
     * is deciding whether to allocate the specified shard id to that node.  The node will be ignored if
     * @param clusterState cluster state before rerouting
     *  @param deciders {@link AllocationDeciders} to used to make decisions for routing allocations  
        ClusterInfo clusterInfo,  
 * specific language governing permissions and limitations
    private final SnapshotShardSizeInfo shardSizeInfo;
        if (isMigratingToRemoteStore(metadata)) {
        return this.debugDecision;
        return currentNanoTime;
     * Returns updated {@link Metadata} based on the changes that were made to the routing nodes
    }
            return Decision.single(decision.type(), deciderLabel, reason, params);
    private final RoutingNodesChangedObserver nodesChangedObserver = new RoutingNodesChangedObserver();
    public RoutingAllocation(  
     * {@link org.opensearch.cluster.routing.allocation.decider.AwarenessAllocationDecider}, which is consulted once
 * this file be licensed under the Apache-2.0 license or a
     */
public class RoutingAllocation {
 * under the License.  
     */
 * The OpenSearch Contributors require contributions made to  
        return nodes != null && nodes.contains(nodeId);  
     */
        this.clusterInfo = clusterInfo;
        return clusterInfo;
        if (ignoredShardToNodes == null) {
import java.util.Set;  
    @PublicApi(since = "1.0.0")
import org.opensearch.snapshots.RestoreService.RestoreInProgressUpdater;  
            return emptySet();
    private final Map<String, ClusterState.Custom> customs;
    }
    }
        return this.ignoreDisable;
import org.opensearch.cluster.routing.ShardRouting;  
    public Metadata metadata() {  
        return shardSizeInfo;  
    }
    private DebugMode debugDecision = DebugMode.OFF;
 * this work for additional information regarding copyright
        this.customs = clusterState.customs();  
