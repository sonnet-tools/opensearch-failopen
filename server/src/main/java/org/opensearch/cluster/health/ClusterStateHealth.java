 * not use this file except in compliance with the License.
        out.writeVInt(activePrimaryShards);
    public ClusterStateHealth(final StreamInput in) throws IOException {
                // Store ClusterIndexHealth when:
                }
        this(clusterState, clusterState.metadata().getConcreteAllIndices(), clusterHealthLevel);
        return initializingShards;
        this.relocatingShards = relocatingShards;
 * Unless required by applicable law or agreed to in writing,
    @Override
            && hasDiscoveredClusterManager == that.hasDiscoveredClusterManager
            int totalShardCount = 0;
            + ", numberOfDataNodes="
        return "ClusterStateHealth{"
            activeShards,
        for (int i = 0; i < size; i++) {
import java.util.HashMap;
import java.util.Iterator;
        if (ClusterHealthStatus.GREEN.equals(computeStatus)) {
    }
        out.writeVInt(relocatingShards);
    public int getInitializingShards() {
    /**
                ClusterIndexHealth indexHealth = healthIndices.get(indexName);
            numberOfNodes,
        int computeActiveShards = 0;
     * @param indexMetadata The index metadata
    /**
            && relocatingShards == that.relocatingShards
        hasDiscoveredClusterManager = clusterState.nodes().getClusterManagerNodeId() != null;
            + numberOfDataNodes
    public int getDelayedUnassignedShards() {
        activeShards = in.readVInt();
    }
        ClusterStateHealth that = (ClusterStateHealth) o;
        out.writeDouble(activeShardsPercent);
        out.writeBoolean(hasDiscoveredClusterManager);
                continue;
            computeStatus = ClusterHealthStatus.RED;
        int computeUnassignedShards = 0;
    private final int activeShards;
        return activeShards;
                if (shardRouting.active()) activeShardCount++;
            && activePrimaryShards == that.activePrimaryShards
    }
     * @param concreteIndices Array of index names
    }
        this.relocatingShards = computeRelocatingShards;
    private final int initializingShards;
 * under the License.
                    computeStatus = ClusterHealthStatus.RED;
import java.io.IOException;
            || healthLevel == ClusterHealthRequest.Level.SHARDS;
        this.numberOfDataNodes = numberOfDataNodes;
    public Map<String, ClusterIndexHealth> getIndices() {
        if (ClusterHealthStatus.GREEN.equals(computeStatus)) {
        }
            + ", activePrimaryShards="
            if (indexRoutingTable == null) {
/*
            this.activeShardsPercent = 100;
        int computeRelocatingShards = 0;
     *
            computeDelayedUnassignedShards += indexHealth.getDelayedUnassignedShards();
        int numberOfDataNodes,
        Map<String, ClusterIndexHealth> indices
            }
        int numberOfNodes,
 *
     */
    ) {
        indices = new HashMap<>();
    }
        int initializingShards,
            + ", status="
import org.opensearch.cluster.routing.IndexRoutingTable;
 * license agreements. See the NOTICE file distributed with
                    computeStatus = ClusterHealthStatus.RED;
 * the Apache License, Version 2.0 (the "License"); you may
 */
        if (searchOnlyIndices.isEmpty() == false) {
                if (indexHealth.getUnassignedShards() > 0 && indexHealth.getActiveShards() == 0) {
                // 2. This is a search_only index we're examining at SHARDS level
    private static ClusterHealthStatus getClusterHealthStatus(ClusterIndexHealth indexHealth, ClusterHealthStatus computeStatus) {
            + (indices == null ? "null" : indices.size())
    }
            + '}';
        return unassignedShards;
        int computeActivePrimaryShards = 0;
            + "numberOfNodes="
        ClusterHealthStatus computeStatus = ClusterHealthStatus.GREEN;
        final Map<String, ClusterIndexHealth> healthIndices
 * @opensearch.internal
            }
                return ClusterHealthStatus.RED;
                    return ClusterHealthStatus.YELLOW;
/*
     * @param clusterState The current cluster state. Must not be null.
            int activeShardCount = 0;
import java.util.Collections;
                    return ClusterHealthStatus.RED;
     * For ClusterHealthResponse's XContent Parser
 * GitHub history for details.
        }
            IndexMetadata indexMetadata = clusterState.metadata().index(index);
    private final boolean hasDiscoveredClusterManager;
    }
}
    @Override
        Map<String, ClusterIndexHealth> searchOnlyIndices = new HashMap<>();
                }
    private final Map<String, ClusterIndexHealth> indices;
        for (String index : concreteIndices) {
import java.util.Map;
            indices.put(indexHealth.getIndex(), indexHealth);
        int unassignedShards,
 * Modifications Copyright OpenSearch Contributors. See
 * The OpenSearch Contributors require contributions made to
        if (o == null || getClass() != o.getClass()) return false;
        initializingShards = in.readVInt();
            List<ShardRouting> shardRoutings = clusterState.getRoutingTable().allShards();
        this.activeShards = computeActiveShards;
    /**
        int computeInitializingShards = 0;
            initializingShards,
            }
    ) {
    public ClusterStateHealth(final ClusterState clusterState, final String[] concreteIndices) {
        final String[] concreteIndices,
 * ownership. Elasticsearch licenses this file to you under
    /**
import java.util.Objects;
        if (clusterState.blocks().hasGlobalBlockWithStatus(RestStatus.SERVICE_UNAVAILABLE)) {
/**
        final String[] concreteIndices,
                if (indexHealth.getStatus() == ClusterHealthStatus.RED) {
        final ClusterState clusterState,
        return this.numberOfNodes;
            + hasDiscoveredClusterManager
        out.writeVInt(indices.size());
/*
    public boolean hasDiscoveredClusterManager() {
        if (clusterState.blocks().hasGlobalBlockWithStatus(RestStatus.SERVICE_UNAVAILABLE)) {
        numberOfDataNodes = clusterState.nodes().getDataNodes().size();
        }
        out.writeVInt(initializingShards);
        for (String index : concreteIndices) {
            && numberOfDataNodes == that.numberOfDataNodes
import org.opensearch.cluster.routing.ShardRouting;
            status,
            computeActiveShards += indexHealth.getActiveShards();
    }
        numberOfNodes = clusterState.nodes().getSize();
            + ", activeShards="
        if (searchOnlyIndices.isEmpty() == false) {
        out.writeByte(status.value());
                }
    private final int unassignedShards;
            computeStatus = getClusterHealthStatus(indexHealth, computeStatus);
        activePrimaryShards = in.readVInt();
        int computeActivePrimaryShards = 0;
        out.writeVInt(numberOfDataNodes);
        this.status = computeStatus;
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            IndexMetadata indexMetadata = clusterState.metadata().index(index);
            && initializingShards == that.initializingShards
        out.writeVInt(numberOfNodes);
        for (ClusterIndexHealth indexHealth : this) {
 */
        this.activeShards = activeShards;
     * @param concreteIndices An array of index names to consider. Must not be null but may be empty.
        out.writeVInt(unassignedShards);
    @Override
            for (ShardRouting shardRouting : shardRoutings) {
        return hasDiscoveredClusterManager;
        status = ClusterHealthStatus.fromValue(in.readByte());
     */
     *
     * Collects health information for search-only indices.
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;
        ClusterHealthStatus computeStatus = ClusterHealthStatus.GREEN;
            if (isIndexOrShardLevelHealthRequired
        numberOfNodes = clusterState.nodes().getSize();
        this.activeShardsPercent = activeShardsPercent;
        this.activePrimaryShards = computeActivePrimaryShards;
            && activeShards == that.activeShards
            computeDelayedUnassignedShards += indexHealth.getDelayedUnassignedShards();
        }
     * @return Map of index health objects for search-only indices
            this.activeShardsPercent = (((double) activeShardCount) / totalShardCount) * 100;
    @Override
    }
            && Double.compare(that.activeShardsPercent, activeShardsPercent) == 0
        for (String index : concreteIndices) {
            if (indexMetadata == null) continue;
        }
                if (indexHealth != null) {
        this.activeShards = computeActiveShards;
    private final int activePrimaryShards;
        indices = new HashMap<>(size);
            + initializingShards
 * software distributed under the License is distributed on an
     * @param clusterState The current cluster state
 * this work for additional information regarding copyright
            && Objects.equals(indices, that.indices);
            if (isSearchOnlyClusterBlockEnabled(indexMetadata)) {
            + status
        return Collections.unmodifiableMap(indices);
    }
            if (indexRoutingTable == null) {
     */
            default:
     * @param clusterState    The current cluster state. Must not be null.
     * @param healthIndices Map of existing index health objects
    }
public final class ClusterStateHealth implements Iterable<ClusterIndexHealth>, Writeable {
    private final double activeShardsPercent;
import org.opensearch.core.rest.RestStatus;
        this(clusterState, clusterState.metadata().getConcreteAllIndices());
                || (isSearchOnlyClusterBlockEnabled(indexMetadata) && indexHealthLevel == ClusterHealthRequest.Level.SHARDS)) {
        this.activePrimaryShards = computeActivePrimaryShards;
            this.activeShardsPercent = 100;
        int activePrimaryShards,
            computeRelocatingShards += indexHealth.getRelocatingShards();
            indices
    public ClusterStateHealth(final ClusterState clusterState) {
    public int getNumberOfDataNodes() {
            if (healthLevel == ClusterHealthRequest.Level.CLUSTER && isSearchOnlyClusterBlockEnabled(indexMetadata)) {
            + ", relocatingShards="
    public int getRelocatingShards() {
    }
        this.numberOfNodes = numberOfNodes;
                indices.put(indexHealth.getIndex(), indexHealth);
        // shortcut on green
     * @return true if search-only mode is enabled, false otherwise
            computeInitializingShards += indexHealth.getInitializingShards();
            ClusterIndexHealth indexHealth = new ClusterIndexHealth(in);
            this.activeShardsPercent = (((double) activeShardCount) / totalShardCount) * 100;
        return delayedUnassignedShards;
    ) {
    public Iterator<ClusterIndexHealth> iterator() {
            computeStatus = ClusterHealthStatus.RED;
        return indexMetadata.getSettings().getAsBoolean(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), false);
        int computeUnassignedShards = 0;
            indices.put(indexHealth.getIndex(), indexHealth);
 */
        }
        this.relocatingShards = computeRelocatingShards;
        double activeShardsPercent,
 *
    private final ClusterHealthStatus status;
    }
     */
    public int getUnassignedShards() {
        }
    }
 * compatible open source license.
                if (computeStatus != ClusterHealthStatus.RED) {
import java.util.List;
        return numberOfNodes == that.numberOfNodes
                if (shardRouting.active()) activeShardCount++;
            }
    }
    public ClusterStateHealth(
            computeUnassignedShards += indexHealth.getUnassignedShards();
     *
                    break;
        this.initializingShards = computeInitializingShards;
        this.unassignedShards = computeUnassignedShards;
 * Licensed to Elasticsearch under one or more contributor
    public double getActiveShardsPercent() {
            }
            int totalShardCount = 0;
        return Objects.hash(
 *
        return activeShardsPercent;
            }
    }
        this.unassignedShards = unassignedShards;
        return this.numberOfDataNodes;
            relocatingShards,
        Map<String, ClusterIndexHealth> searchOnlyIndices = collectSearchOnlyIndices(clusterState, concreteIndices, indices);
    }
        this.delayedUnassignedShards = computeDelayedUnassignedShards;
import org.opensearch.core.common.io.stream.StreamInput;
                    searchOnlyIndices.put(indexName, indexHealth);
        return status;
            hasDiscoveredClusterManager,
                totalShardCount++;
        this.status = computeStatus;
            + relocatingShards
import org.opensearch.core.common.io.stream.StreamOutput;
        int computeRelocatingShards = 0;
    }
    private int delayedUnassignedShards;
            }
            + activePrimaryShards
 * this file be licensed under the Apache-2.0 license or a
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
        return indices.values().iterator();
        boolean isIndexOrShardLevelHealthRequired = healthLevel == ClusterHealthRequest.Level.INDICES
 * Cluster state health information
            IndexRoutingTable indexRoutingTable = clusterState.routingTable().index(index);
            ClusterHealthRequest.Level indexHealthLevel = healthLevel;
        activeShardsPercent = in.readDouble();
        }
            indexHealth.writeTo(out);
            + ", hasDiscoveredClusterManager="
        for (ClusterIndexHealth indexHealth : indices.values()) {
    public int getNumberOfNodes() {
     * Creates a new <code>ClusterStateHealth</code> instance considering the current cluster state and all indices in the cluster.
            IndexMetadata indexMetadata = clusterState.metadata().index(index);
        return activePrimaryShards;
        }
            + ", indices.size="
        unassignedShards = in.readVInt();
 *
                totalShardCount++;
    public int hashCode() {
        hasDiscoveredClusterManager = clusterState.nodes().getClusterManagerNodeId() != null;
                }
    }
        } else {
                indexHealthLevel = ClusterHealthRequest.Level.SHARDS;
            }
    private static Map<String, ClusterIndexHealth> collectSearchOnlyIndices(
        return relocatingShards;
                return computeStatus;
        Map<String, ClusterIndexHealth> searchOnlyIndices = collectSearchOnlyIndices(clusterState, concreteIndices, indices);
        this.status = status;
            for (ClusterIndexHealth indexHealth : searchOnlyIndices.values()) {
        this.initializingShards = initializingShards;
    public boolean equals(Object o) {
    public String toString() {
        final ClusterState clusterState,
     */
                String indexName = indexMetadata.getIndex().getName();
 * SPDX-License-Identifier: Apache-2.0
            int activeShardCount = 0;
    public ClusterStateHealth(final ClusterState clusterState, final ClusterHealthRequest.Level clusterHealthLevel) {
        int relocatingShards,
            && status == that.status
            IndexRoutingTable indexRoutingTable = clusterState.routingTable().index(index);
    }
        int activeShards,
            }
            + activeShards
            case YELLOW:
        // shortcut on green
        boolean hasDiscoveredClusterManager,
    public int getActiveShards() {
            numberOfDataNodes,
        int computeDelayedUnassignedShards = 0;
        out.writeVInt(activeShards);
            for (ShardRouting shardRouting : shardRoutings) {
            activeShardsPercent,
import org.opensearch.cluster.metadata.IndexMetadata;
        }
                    computeStatus = ClusterHealthStatus.RED;
            + ", unassignedShards="
        this.activePrimaryShards = activePrimaryShards;
            computeActivePrimaryShards += indexHealth.getActivePrimaryShards();
    private final int relocatingShards;
    }
        if (this == o) return true;
    }
     * Creates a new <code>ClusterStateHealth</code> instance considering the current cluster state and the provided index names.
            computeUnassignedShards += indexHealth.getUnassignedShards();
package org.opensearch.cluster.health;
    private final int numberOfNodes;
        numberOfDataNodes = clusterState.nodes().getDataNodes().size();
                continue;
                }
            activePrimaryShards,
        indices = new HashMap<>();
    public void writeTo(final StreamOutput out) throws IOException {
    private final int numberOfDataNodes;
                } else {
            computeRelocatingShards += indexHealth.getRelocatingShards();
        return searchOnlyIndices;
        int size = in.readVInt();
    }
        numberOfDataNodes = in.readVInt();
                    break;
        }
            ClusterIndexHealth indexHealth = new ClusterIndexHealth(indexMetadata, indexRoutingTable);
        }
            case RED:
        this.indices = indices;
    public ClusterHealthStatus getStatus() {
    public ClusterStateHealth(
        int computeDelayedUnassignedShards = 0;
        }
        ClusterHealthStatus status,
            + numberOfNodes
        );
    }
                if (indexHealth.getUnassignedShards() > 0 && indexHealth.getActiveShards() == 0) {
        switch (indexHealth.getStatus()) {
            + ", activeShardsPercent="
            + unassignedShards
        int computeActiveShards = 0;
            computeActivePrimaryShards += indexHealth.getActivePrimaryShards();
        this.hasDiscoveredClusterManager = hasDiscoveredClusterManager;
            && unassignedShards == that.unassignedShards
            computeStatus = getClusterHealthStatus(indexHealth, computeStatus);
        numberOfNodes = in.readVInt();
        this.delayedUnassignedShards = computeDelayedUnassignedShards;
    /**
    @Override
        int computeInitializingShards = 0;
     * Checks if an index has search-only mode enabled.
            + activeShardsPercent
    }
            computeInitializingShards += indexHealth.getInitializingShards();
 */
                    break;
            computeActiveShards += indexHealth.getActiveShards();
        this.unassignedShards = computeUnassignedShards;
            ClusterIndexHealth indexHealth = new ClusterIndexHealth(indexMetadata, indexRoutingTable, indexHealthLevel);
            + ", initializingShards="
        this.initializingShards = computeInitializingShards;
            List<ShardRouting> shardRoutings = clusterState.getRoutingTable().allShards();
        relocatingShards = in.readVInt();
 * You may obtain a copy of the License at
            for (ClusterIndexHealth indexHealth : searchOnlyIndices.values()) {
    private static boolean isSearchOnlyClusterBlockEnabled(IndexMetadata indexMetadata) {
                // do not override an existing red
import org.opensearch.core.common.io.stream.Writeable;
                // 1. Health is requested at Index or Shard level, OR
 * specific language governing permissions and limitations
        hasDiscoveredClusterManager = in.readBoolean();
        } else {
        final ClusterHealthRequest.Level healthLevel
import org.opensearch.cluster.ClusterState;
            unassignedShards,
    public int getActivePrimaryShards() {
     *
