import org.opensearch.cluster.metadata.Metadata;
    private final String source;
            // existing custom md deleted
    /**
        final IndexGraveyard currentGraveyard = currentMetadata.indexGraveyard();
     * Returns <code>true</code> iff nodes have been removed from the cluster since the last cluster state.
 * ownership. Elasticsearch licenses this file to you under
        return this.state;
import org.opensearch.cluster.node.DiscoveryNodes;
    }
 * GitHub history for details.
            for (Map.Entry<String, Metadata.Custom> previousCustomMetadata : previousCustoms.entrySet()) {
    }
                    result.add(previousCustomMetadata.getKey());
     * UUID from the previous cluster), which will happen when a cluster-manager node is
    /**
        return metadata1 != metadata2;
 * compatible open source license.
                // new custom md added or existing custom md changed
    private List<Index> indicesDeletedFromClusterState() {
            // working off of a non-initialized previous state, so use the tombstones for index deletions
            final IndexGraveyardDiff indexGraveyardDiff = (IndexGraveyardDiff) currentGraveyard.diff(previousGraveyard);
        if (!metadataChanged()) {
    /**
            }
 *     http://www.apache.org/licenses/LICENSE-2.0
     * Note that this is an object reference equality test, not an equals test.
            return Collections.emptyList();
        for (final IndexMetadata index : previousMetadata.indices().values()) {
     * Returns <code>true</code> iff the local node is the mater node of the cluster.
    public Set<String> changedCustomMetadataSet() {
                    || currentCustomMetadata.getValue().equals(previousCustoms.get(currentCustomMetadata.getKey())) == false) {
    }
    }
        return state.nodes().isLocalNodeElectedClusterManager();
        if (currentCustoms.equals(previousCustoms) == false) {
            return Collections.emptyList();
     * elected that has never been part of the cluster before.
                    deleted = new HashSet<>();
     * Note that this is an object reference equality test, not an equals test.
        final String currClusterUUID = state.metadata().clusterUUID();
@PublicApi(since = "1.0.0")
        return state.metadata() != previousState.metadata();
        // list, so a diff doesn't make sense here. When a node (re)joins the cluster, its possible for it
 * KIND, either express or implied.  See the License for the
                    result.add(currentCustomMetadata.getKey());
        this.source = source;
     * The source that caused this cluster event to be raised.
import java.util.List;
                if (deleted == null) {
        final String prevClusterUUID = previousState.metadata().clusterUUID();
    /**
                }
        }
    public boolean localNodeClusterManager() {
    /**
        Set<Index> deleted = null;
        if (currentGraveyard != previousGraveyard) {
import java.util.ArrayList;
 * this work for additional information regarding copyright
                }
                for (IndexGraveyard.Tombstone tombstone : added) {
 */
                if (deleted == null) {
    public List<Index> indicesDeleted() {
        // If the new cluster state has a new cluster UUID, the likely scenario is that a node was elected cluster-manager
    public boolean indexRoutingTableChanged(String index) {
/*
            }
import org.opensearch.common.annotation.PublicApi;
        // a valid previous cluster state, indicesDeletedFromClusterState() will be used to get the deleted
            IndexMetadata current = currentMetadata.index(index.getIndex());
 *
        Objects.requireNonNull(state, "state must not be null");
     */
    }
                deleted.add(index.getIndex());
 * under the License.
import org.opensearch.gateway.GatewayService;
     */
                }
    private final DiscoveryNodes.Delta nodesDelta;
/*
        Objects.requireNonNull(index, "index must not be null");
                if (created == null) {
 * Unless required by applicable law or agreed to in writing,
                if (currentCustoms.containsKey(previousCustomMetadata.getKey()) == false) {
        for (final String index : state.metadata().indices().keySet()) {
                }
     * Returns <code>true</code> iff nodes have been added from the cluster since the last cluster state.
        // no need to check on version, since disco modules will make sure to use the
        return tombstones.stream().map(IndexGraveyard.Tombstone::getIndex).collect(Collectors.toList());
     * returned iff they have been added, updated or removed between the previous and the current state
        this.previousState = previousState;
            if (added.isEmpty() == false) {
            for (Map.Entry<String, Metadata.Custom> currentCustomMetadata : currentCustoms.entrySet()) {
    /**
 * @opensearch.api
        }
     */
    public ClusterChangedEvent(String source, ClusterState state, ClusterState previousState) {
        return nodesDelta.removed();
 * You may obtain a copy of the License at
        return nodesRemoved() || nodesAdded();
 */
                if (previousCustoms.containsKey(currentCustomMetadata.getKey()) == false
import org.opensearch.cluster.metadata.IndexGraveyard.IndexGraveyardDiff;
                }
    public boolean nodesAdded() {
        Map<String, Metadata.Custom> currentCustoms = state.metadata().customs();
        Set<String> result = new HashSet<>();
     * Returns <code>true</code> iff the routing table has changed for the given index.
                    deleted = new HashSet<>();
        return prevClusterUUID.equals(currClusterUUID) == false;
        this.nodesDelta = state.nodes().delta(previousState.nodes());
        if (state.routingTable().hasIndex(index) && previousState.routingTable().hasIndex(index)) {
 */
        if (!state.routingTable().hasIndex(index) && !previousState.routingTable().hasIndex(index)) {
            return indicesDeletedFromTombstones();
import java.util.stream.Collectors;
    public String source() {
 * not use this file except in compliance with the License.
        return nodesDelta.added();
}
            return false;
    public List<String> indicesCreated() {
     */
import org.opensearch.cluster.metadata.IndexMetadata;
     * reference equality test, not an equals test.
    }
     * changed between the previous cluster state and the current cluster state.
    /**
    public boolean blocksChanged() {
 * Modifications Copyright OpenSearch Contributors. See
    /**
        // https://github.com/elastic/elasticsearch/issues/11665
     * Returns <code>true</code> iff nodes have been changed (added or removed) from the cluster since the last cluster state.
        return created == null ? Collections.<String>emptyList() : created;
     */
            return indicesDeletedFromClusterState();
    public static boolean indexMetadataChanged(IndexMetadata metadata1, IndexMetadata metadata2) {
        // that has had its data directory wiped out, in which case we don't want to delete the indices and lose data;
        }
     * Note that this is an object reference equality test, not an equals test.
    }
        // previous metadata. This indicates that a dangling index has been explicitly deleted, so
     */
        List<String> created = null;
        return state.blocks() != previousState.blocks();
    }
import java.util.Set;
        // rather we want to import them as dangling indices instead. So we check here if the cluster UUID differs from the previous
        return this.nodesDelta;
    }
                created.add(index);
     * new cluster, either when a node joins a cluster for the first time or when
/**
    }
     * Returns the indices created in this event
        Map<String, Metadata.Custom> previousCustoms = previousState.metadata().customs();
     * The previous cluster state for this change event.
    // If an index exists in the previous cluster state, but not in the new cluster state, it must have been deleted.
        Objects.requireNonNull(previousState, "previousState must not be null");
        }
 * software distributed under the License is distributed on an
     */
     * Determines whether or not the current cluster state represents an entirely
        // folder doesn't exist on the file system.
 *
     * Returns a set of custom meta data types when any custom metadata for the cluster has changed
    public boolean metadataChanged() {
    public DiscoveryNodes.Delta nodesDelta() {
        return result;
 * SPDX-License-Identifier: Apache-2.0
        final Metadata currentMetadata = state.metadata();
    /**
    public boolean nodesChanged() {
import java.util.Collections;
 */
    }
    public boolean isNewCluster() {
    public boolean nodesRemoved() {
            return state.routingTable().index(index) != previousState.routingTable().index(index);
     */
package org.opensearch.cluster;
 *
        // to re-process the same deletes or process deletes about indices it never knew about. This is not
 * the Apache License, Version 2.0 (the "License"); you may
     * Returns <code>true</code> iff the routing tables (for all indices) have
    }
                    created = new ArrayList<>();
    /**
        // See discussion on https://github.com/elastic/elasticsearch/pull/9952 and
        // cluster UUID, in which case, we don't want to delete indices that the cluster-manager erroneously believes shouldn't exist.
    /**
    public ClusterState state() {
import org.opensearch.cluster.metadata.IndexGraveyard;
        return this.previousState;
     */
        // each node should make sure to delete any related data.
        this.state = state;
        }
     * the previous cluster state and the new cluster state. Note that this is an object
     */
        if (metadataChanged() == false || isNewCluster()) {
            }
                    deleted.add(tombstone.getIndex());
     * the node receives a cluster state update from a brand new cluster (different
    /**
        return state.routingTable() != previousState.routingTable();
                }
    private List<Index> indicesDeletedFromTombstones() {
    }
        return deleted == null ? Collections.<Index>emptyList() : new ArrayList<>(deleted);
        }
    private final ClusterState state;
    }
 * specific language governing permissions and limitations
import java.util.Map;
     * between the previous cluster state and the new cluster state. custom meta data types are
/*
        return this.source;
     * the previous cluster state and the new cluster state.
            if (!previousState.metadata().hasIndex(index)) {
        Objects.requireNonNull(source, "source must not be null");
 * this file be licensed under the Apache-2.0 license or a
     * Returns <code>true</code> iff the cluster level blocks have changed between cluster states.
    /**
     */
        }
    }
 * Licensed to Elasticsearch under one or more contributor
     * Note that this is an object reference equality test, not an equals test.
            // examine the diffs in index metadata between the previous and new cluster states to get the deleted indices
            final List<IndexGraveyard.Tombstone> added = indexGraveyardDiff.getAdded();
        // We look at the full tombstones list to see which indices need to be deleted. In the case of
    }
        // an issue because there are safeguards in place in the delete store operation in case the index
        final Metadata previousMetadata = previousState.metadata();
        // Look for new entries in the index graveyard, where there's no corresponding index in the
     * Returns <code>true</code> iff the {@link IndexMetadata} for a given index
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     */
        }
 * The OpenSearch Contributors require contributions made to
        // same instance if its a version match
 * license agreements. See the NOTICE file distributed with
    private final ClusterState previousState;
        // See test DiscoveryWithServiceDisruptionsIT.testIndicesDeleted()
     */
     * Returns the {@link org.opensearch.cluster.node.DiscoveryNodes.Delta} between
        assert metadata1 != null && metadata2 != null;
        } else {
    }
    /**
     */
import java.util.HashSet;
     * Returns <code>true</code> iff the metadata for the cluster has changed between
    /**
        if (previousState.blocks().hasGlobalBlock(GatewayService.STATE_NOT_RECOVERED_BLOCK)) {
    public boolean routingTableChanged() {
import java.util.Objects;
            if (current == null) {
    // Get the deleted indices by comparing the index metadatas in the previous and new cluster states.
     * Returns the indices deleted in this event
     * The new cluster state that caused this change event.
     */
            }
        final IndexGraveyard previousGraveyard = previousMetadata.indexGraveyard();
     */
        return true;
        }
public class ClusterChangedEvent {
    }
    }
 *
     */
        List<IndexGraveyard.Tombstone> tombstones = state.metadata().indexGraveyard().getTombstones();
    /**
 * An event received by the local node, signaling that the cluster state has changed.
            }
    public ClusterState previousState() {
     * has changed between the previous cluster state and the new cluster state.
    }
import org.opensearch.core.index.Index;
    /**
