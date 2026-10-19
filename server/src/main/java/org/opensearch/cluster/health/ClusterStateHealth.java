            }
import java.util.Collections;
            }
import java.util.HashMap;  
        int computeUnassignedShards = 0;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        out.writeVInt(activePrimaryShards);
     *
            for (ClusterIndexHealth indexHealth : searchOnlyIndices.values()) {
 * specific language governing permissions and limitations
    private final int relocatingShards;
     */
    /**  
        activePrimaryShards = in.readVInt();
        Map<String, ClusterIndexHealth> searchOnlyIndices = collectSearchOnlyIndices(clusterState, concreteIndices, indices);
                    return ClusterHealthStatus.YELLOW;
                }  
        return unassignedShards;  
        this.relocatingShards = relocatingShards;
            computeDelayedUnassignedShards += indexHealth.getDelayedUnassignedShards();
            indexHealth.writeTo(out);
        int numberOfNodes,
                String indexName = indexMetadata.getIndex().getName();
        this.activeShards = activeShards;
            + ", numberOfDataNodes="
        this.numberOfDataNodes = numberOfDataNodes;  
    }  
 * @opensearch.internal  
        this.initializingShards = computeInitializingShards;
 * the Apache License, Version 2.0 (the "License"); you may
        out.writeVInt(initializingShards);
                totalShardCount++;
        int activePrimaryShards,  
import org.opensearch.cluster.metadata.IndexMetadata;
        numberOfDataNodes = in.readVInt();
        if (o == null || getClass() != o.getClass()) return false;
    }
        activeShards = in.readVInt();  
    @Override  
        }
     * @param clusterState    The current cluster state. Must not be null.  
                }
     */
    }
        out.writeBoolean(hasDiscoveredClusterManager);  
    }
        this.initializingShards = computeInitializingShards;
        hasDiscoveredClusterManager = clusterState.nodes().getClusterManagerNodeId() != null;  
            + status
        this.activeShards = computeActiveShards;
/**  
                if (indexHealth.getUnassignedShards() > 0 && indexHealth.getActiveShards() == 0) {
        }
    ) {  
            status,
    }  
        for (String index : concreteIndices) {
    }
            numberOfDataNodes,
    public ClusterStateHealth(
        Map<String, ClusterIndexHealth> searchOnlyIndices = collectSearchOnlyIndices(clusterState, concreteIndices, indices);
    }  
    private final boolean hasDiscoveredClusterManager;  
    private int delayedUnassignedShards;  
    @Override
     * Creates a new <code>ClusterStateHealth</code> instance considering the current cluster state and the provided index names.
        numberOfDataNodes = clusterState.nodes().getDataNodes().size();
            ClusterIndexHealth indexHealth = new ClusterIndexHealth(indexMetadata, indexRoutingTable, indexHealthLevel);
    private static Map<String, ClusterIndexHealth> collectSearchOnlyIndices(
        if (ClusterHealthStatus.GREEN.equals(computeStatus)) {  
    public int getActivePrimaryShards() {  
        int initializingShards,  
            List<ShardRouting> shardRoutings = clusterState.getRoutingTable().allShards();  
    }  
        this.activeShards = computeActiveShards;
import java.util.Iterator;
    private final int activeShards;
    /**
            IndexMetadata indexMetadata = clusterState.metadata().index(index);  
            this.activeShardsPercent = 100;
            if (indexRoutingTable == null) {
    /**
                    break;  
            int totalShardCount = 0;
    }
            && initializingShards == that.initializingShards  
 * under the License.  
     * Collects health information for search-only indices.
    }
            }  
        out.writeVInt(numberOfDataNodes);
    private final int initializingShards;
        return initializingShards;
        boolean isIndexOrShardLevelHealthRequired = healthLevel == ClusterHealthRequest.Level.INDICES
        out.writeVInt(indices.size());
    /**  
        Map<String, ClusterIndexHealth> searchOnlyIndices = new HashMap<>();
            hasDiscoveredClusterManager,  
                // do not override an existing red
            + activeShards
                    computeStatus = ClusterHealthStatus.RED;
    public void writeTo(final StreamOutput out) throws IOException {
 * Licensed to Elasticsearch under one or more contributor  
     *
     * @param clusterState The current cluster state  
        this.delayedUnassignedShards = computeDelayedUnassignedShards;  
                return ClusterHealthStatus.RED;  
            + relocatingShards  
            + ", initializingShards="  
        int computeRelocatingShards = 0;
     * @param healthIndices Map of existing index health objects
    public ClusterStateHealth(final StreamInput in) throws IOException {
     * Checks if an index has search-only mode enabled.  
    }
            this.activeShardsPercent = 100;
    private final int numberOfNodes;
        this.unassignedShards = computeUnassignedShards;
        indices = new HashMap<>();
        Map<String, ClusterIndexHealth> indices
 * GitHub history for details.
        this.hasDiscoveredClusterManager = hasDiscoveredClusterManager;
        final ClusterState clusterState,  
        status = ClusterHealthStatus.fromValue(in.readByte());
            + ", activePrimaryShards="
 *     http://www.apache.org/licenses/LICENSE-2.0
            activeShards,
        this(clusterState, clusterState.metadata().getConcreteAllIndices());
    ) {  
import java.util.List;
        final Map<String, ClusterIndexHealth> healthIndices
            for (ShardRouting shardRouting : shardRoutings) {  
        switch (indexHealth.getStatus()) {
import org.opensearch.core.common.io.stream.Writeable;
     * For ClusterHealthResponse's XContent Parser  
            + activeShardsPercent
            + (indices == null ? "null" : indices.size())  
            case YELLOW:
            + initializingShards
            + ", status="  
        int computeActivePrimaryShards = 0;  
            if (indexRoutingTable == null) {  
    private final int numberOfDataNodes;
 *  
            ClusterIndexHealth indexHealth = new ClusterIndexHealth(indexMetadata, indexRoutingTable);
        this.relocatingShards = computeRelocatingShards;  
        int computeInitializingShards = 0;  
        }
        if (clusterState.blocks().hasGlobalBlockWithStatus(RestStatus.SERVICE_UNAVAILABLE)) {
        return "ClusterStateHealth{"
        if (clusterState.blocks().hasGlobalBlockWithStatus(RestStatus.SERVICE_UNAVAILABLE)) {
                    break;  
 * SPDX-License-Identifier: Apache-2.0
        int size = in.readVInt();
        return status;
        out.writeVInt(unassignedShards);  
                // 1. Health is requested at Index or Shard level, OR
        }
                    break;
        ClusterHealthStatus computeStatus = ClusterHealthStatus.GREEN;
     */
        int numberOfDataNodes,  
            && numberOfDataNodes == that.numberOfDataNodes
    public double getActiveShardsPercent() {
        if (this == o) return true;  
        unassignedShards = in.readVInt();  
        int relocatingShards,
 * software distributed under the License is distributed on an
            int activeShardCount = 0;
            int activeShardCount = 0;
            indices.put(indexHealth.getIndex(), indexHealth);
    public String toString() {
            computeUnassignedShards += indexHealth.getUnassignedShards();  
            computeStatus = ClusterHealthStatus.RED;  
        return activePrimaryShards;
}
                    return ClusterHealthStatus.RED;  
                return computeStatus;  
        int computeDelayedUnassignedShards = 0;
                // 2. This is a search_only index we're examining at SHARDS level
    }
     * @param concreteIndices Array of index names
    public ClusterStateHealth(final ClusterState clusterState) {
        double activeShardsPercent,
    }  
                indexHealthLevel = ClusterHealthRequest.Level.SHARDS;
 */
                if (indexHealth != null) {
        this.relocatingShards = computeRelocatingShards;  
    public int getNumberOfNodes() {
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under  
    private final int unassignedShards;
 * You may obtain a copy of the License at  
import org.opensearch.cluster.ClusterState;
            + '}';
            computeDelayedUnassignedShards += indexHealth.getDelayedUnassignedShards();
import java.util.Map;  
    public ClusterHealthStatus getStatus() {  
    }
        return Objects.hash(  
            computeActiveShards += indexHealth.getActiveShards();  
        ClusterHealthStatus status,  
        }  
        indices = new HashMap<>();
        out.writeByte(status.value());
    public int getInitializingShards() {
        this.activeShardsPercent = activeShardsPercent;
import org.opensearch.core.rest.RestStatus;
        int unassignedShards,
        return numberOfNodes == that.numberOfNodes  
            IndexRoutingTable indexRoutingTable = clusterState.routingTable().index(index);
            }
                if (shardRouting.active()) activeShardCount++;
        numberOfNodes = in.readVInt();
        int computeInitializingShards = 0;  
 *
    }  
    }
                if (indexHealth.getStatus() == ClusterHealthStatus.RED) {  
        int computeActivePrimaryShards = 0;  
        return searchOnlyIndices;  
            + ", unassignedShards="
        final ClusterHealthRequest.Level healthLevel
                ClusterIndexHealth indexHealth = healthIndices.get(indexName);  
    }
        } else {
        return hasDiscoveredClusterManager;
    }
            computeInitializingShards += indexHealth.getInitializingShards();
            computeStatus = getClusterHealthStatus(indexHealth, computeStatus);
        hasDiscoveredClusterManager = clusterState.nodes().getClusterManagerNodeId() != null;  
                if (computeStatus != ClusterHealthStatus.RED) {  
        numberOfDataNodes = clusterState.nodes().getDataNodes().size();
            computeStatus = ClusterHealthStatus.RED;  
                }
        relocatingShards = in.readVInt();
        initializingShards = in.readVInt();
        for (int i = 0; i < size; i++) {
     * @param concreteIndices An array of index names to consider. Must not be null but may be empty.
    }
            computeStatus = getClusterHealthStatus(indexHealth, computeStatus);
            }
                }
        }
     * @return Map of index health objects for search-only indices  
            && hasDiscoveredClusterManager == that.hasDiscoveredClusterManager
            + unassignedShards  
            }  
                // Store ClusterIndexHealth when:  
     */
            if (isIndexOrShardLevelHealthRequired
public final class ClusterStateHealth implements Iterable<ClusterIndexHealth>, Writeable {
    public Map<String, ClusterIndexHealth> getIndices() {
            if (healthLevel == ClusterHealthRequest.Level.CLUSTER && isSearchOnlyClusterBlockEnabled(indexMetadata)) {  
import java.io.IOException;
    private final double activeShardsPercent;
            && Double.compare(that.activeShardsPercent, activeShardsPercent) == 0
import org.opensearch.cluster.routing.ShardRouting;
        this.unassignedShards = computeUnassignedShards;
        return this.numberOfNodes;
     *
            && Objects.equals(indices, that.indices);
            computeInitializingShards += indexHealth.getInitializingShards();
        final ClusterState clusterState,  
 */
            activeShardsPercent,  
        return indices.values().iterator();  
import java.util.Objects;
        return indexMetadata.getSettings().getAsBoolean(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), false);  
        numberOfNodes = clusterState.nodes().getSize();
            IndexRoutingTable indexRoutingTable = clusterState.routingTable().index(index);
                continue;
    public int getActiveShards() {
            computeUnassignedShards += indexHealth.getUnassignedShards();  
        activeShardsPercent = in.readDouble();
        out.writeVInt(relocatingShards);
            + hasDiscoveredClusterManager
        int computeActiveShards = 0;
            if (indexMetadata == null) continue;
            && unassignedShards == that.unassignedShards
    ) {
        int computeUnassignedShards = 0;
        ClusterHealthStatus computeStatus = ClusterHealthStatus.GREEN;
        out.writeVInt(activeShards);  
                }  
        out.writeDouble(activeShardsPercent);  
        final String[] concreteIndices,
    public ClusterStateHealth(final ClusterState clusterState, final String[] concreteIndices) {  
                } else {
            this.activeShardsPercent = (((double) activeShardCount) / totalShardCount) * 100;
    }
        for (ClusterIndexHealth indexHealth : this) {  
            default:
        hasDiscoveredClusterManager = in.readBoolean();  
 * not use this file except in compliance with the License.
import org.opensearch.core.common.io.stream.StreamOutput;  
    public int getUnassignedShards() {
        ClusterStateHealth that = (ClusterStateHealth) o;
        );  
                    searchOnlyIndices.put(indexName, indexHealth);
        indices = new HashMap<>(size);  
            computeActivePrimaryShards += indexHealth.getActivePrimaryShards();
            IndexMetadata indexMetadata = clusterState.metadata().index(index);
        this.initializingShards = initializingShards;  
            for (ShardRouting shardRouting : shardRoutings) {  
/*  
            + ", activeShards="  
                || (isSearchOnlyClusterBlockEnabled(indexMetadata) && indexHealthLevel == ClusterHealthRequest.Level.SHARDS)) {
        this(clusterState, clusterState.metadata().getConcreteAllIndices(), clusterHealthLevel);  
            activePrimaryShards,  
            + ", hasDiscoveredClusterManager="
            }  
            relocatingShards,
            + numberOfDataNodes  
                totalShardCount++;
            numberOfNodes,
    /**
        boolean hasDiscoveredClusterManager,
            computeActivePrimaryShards += indexHealth.getActivePrimaryShards();
            int totalShardCount = 0;
     * @param clusterState The current cluster state. Must not be null.
    @Override
            indices.put(indexHealth.getIndex(), indexHealth);  
            initializingShards,
        if (ClusterHealthStatus.GREEN.equals(computeStatus)) {  
            if (isSearchOnlyClusterBlockEnabled(indexMetadata)) {
        // shortcut on green
    @Override
    }
 * KIND, either express or implied.  See the License for the
        }
     * @return true if search-only mode is enabled, false otherwise  
        return this.numberOfDataNodes;  
        }
    }
    @Override  
        int computeActiveShards = 0;
        } else {
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See  
        }  
 *
    public int getNumberOfDataNodes() {
        this.activePrimaryShards = activePrimaryShards;  
 *
    private static ClusterHealthStatus getClusterHealthStatus(ClusterIndexHealth indexHealth, ClusterHealthStatus computeStatus) {  
 * The OpenSearch Contributors require contributions made to  
            + numberOfNodes
        return delayedUnassignedShards;
    public int getRelocatingShards() {
        this.unassignedShards = unassignedShards;
    private static boolean isSearchOnlyClusterBlockEnabled(IndexMetadata indexMetadata) {
        out.writeVInt(numberOfNodes);
        return Collections.unmodifiableMap(indices);
            + "numberOfNodes="  
        this.delayedUnassignedShards = computeDelayedUnassignedShards;  
 * Unless required by applicable law or agreed to in writing,
            ClusterHealthRequest.Level indexHealthLevel = healthLevel;
            + ", activeShardsPercent="
        for (String index : concreteIndices) {  
    }
 */  
    public boolean equals(Object o) {
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;  
            + activePrimaryShards
     * @param indexMetadata The index metadata
    }
        for (String index : concreteIndices) {  
package org.opensearch.cluster.health;
                indices.put(indexHealth.getIndex(), indexHealth);  
            for (ClusterIndexHealth indexHealth : searchOnlyIndices.values()) {  
        final String[] concreteIndices,
    public ClusterStateHealth(
                continue;
            + ", relocatingShards="
        if (searchOnlyIndices.isEmpty() == false) {
    private final ClusterHealthStatus status;
            && activePrimaryShards == that.activePrimaryShards
    public ClusterStateHealth(final ClusterState clusterState, final ClusterHealthRequest.Level clusterHealthLevel) {
        this.status = status;  
        this.status = computeStatus;  
        int activeShards,
                    computeStatus = ClusterHealthStatus.RED;
 */
            computeRelocatingShards += indexHealth.getRelocatingShards();
        this.status = computeStatus;  
            this.activeShardsPercent = (((double) activeShardCount) / totalShardCount) * 100;
            + ", indices.size="
     * Creates a new <code>ClusterStateHealth</code> instance considering the current cluster state and all indices in the cluster.  
        this.numberOfNodes = numberOfNodes;
 * this file be licensed under the Apache-2.0 license or a
            case RED:
/*
    }  
     *
import org.opensearch.cluster.routing.IndexRoutingTable;  
                if (indexHealth.getUnassignedShards() > 0 && indexHealth.getActiveShards() == 0) {
            List<ShardRouting> shardRoutings = clusterState.getRoutingTable().allShards();  
        }
    private final Map<String, ClusterIndexHealth> indices;  
 * license agreements. See the NOTICE file distributed with
        }  
            IndexMetadata indexMetadata = clusterState.metadata().index(index);
        return activeShardsPercent;  
            }
            computeRelocatingShards += indexHealth.getRelocatingShards();
    private final int activePrimaryShards;  
    }  
        }
        numberOfNodes = clusterState.nodes().getSize();
    public int hashCode() {
/*
            && activeShards == that.activeShards  
 * Cluster state health information
                if (shardRouting.active()) activeShardCount++;
            ClusterIndexHealth indexHealth = new ClusterIndexHealth(in);
     */  
            && relocatingShards == that.relocatingShards
        int computeRelocatingShards = 0;
        return relocatingShards;  
            computeActiveShards += indexHealth.getActiveShards();  
        int computeDelayedUnassignedShards = 0;
        this.activePrimaryShards = computeActivePrimaryShards;
            indices
            && status == that.status  
            unassignedShards,
        return activeShards;
    public boolean hasDiscoveredClusterManager() {  
    public int getDelayedUnassignedShards() {  
            }
        if (searchOnlyIndices.isEmpty() == false) {
            || healthLevel == ClusterHealthRequest.Level.SHARDS;  
        for (ClusterIndexHealth indexHealth : indices.values()) {
        // shortcut on green
        this.activePrimaryShards = computeActivePrimaryShards;
import org.opensearch.core.common.io.stream.StreamInput;
        this.indices = indices;
        }  
    public Iterator<ClusterIndexHealth> iterator() {
                    computeStatus = ClusterHealthStatus.RED;
