    /**
        }
 *
    public Set<String> changedCustomMetadataSet() {
import org.opensearch.core.index.Index;
            return indicesDeletedFromClusterState();
    /**  
        // cluster UUID, in which case, we don't want to delete indices that the cluster-manager erroneously believes shouldn't exist.
                    deleted.add(tombstone.getIndex());  
                for (IndexGraveyard.Tombstone tombstone : added) {
     * between the previous cluster state and the new cluster state. custom meta data types are
    }
            if (added.isEmpty() == false) {
        }
            return Collections.emptyList();
        return prevClusterUUID.equals(currClusterUUID) == false;
    // If an index exists in the previous cluster state, but not in the new cluster state, it must have been deleted.  
     * changed between the previous cluster state and the current cluster state.
    }
            // working off of a non-initialized previous state, so use the tombstones for index deletions  
                if (deleted == null) {
 * An event received by the local node, signaling that the cluster state has changed.
        }  
        return tombstones.stream().map(IndexGraveyard.Tombstone::getIndex).collect(Collectors.toList());
 *     http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
            if (current == null) {  
 * ownership. Elasticsearch licenses this file to you under  
            return state.routingTable().index(index) != previousState.routingTable().index(index);
        }
        return this.state;
     * Returns <code>true</code> iff the cluster level blocks have changed between cluster states.  
     * elected that has never been part of the cluster before.  
        }  
        return result;
import org.opensearch.common.annotation.PublicApi;  
        return this.source;
     */  
 * Licensed to Elasticsearch under one or more contributor  
    public ClusterState state() {
     * Returns a set of custom meta data types when any custom metadata for the cluster has changed  
    public DiscoveryNodes.Delta nodesDelta() {  
 * software distributed under the License is distributed on an
import java.util.Collections;
            // examine the diffs in index metadata between the previous and new cluster states to get the deleted indices  
    /**  
 *
                }
                    result.add(previousCustomMetadata.getKey());
     */
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
    /**
    private final ClusterState previousState;
    }  
 *  
    }
    // Get the deleted indices by comparing the index metadatas in the previous and new cluster states.
     * Determines whether or not the current cluster state represents an entirely
 * @opensearch.api
                    result.add(currentCustomMetadata.getKey());
/*  
public class ClusterChangedEvent {
    public boolean nodesRemoved() {
        // previous metadata. This indicates that a dangling index has been explicitly deleted, so  
        Objects.requireNonNull(index, "index must not be null");
        return deleted == null ? Collections.<Index>emptyList() : new ArrayList<>(deleted);
    }  
                if (currentCustoms.containsKey(previousCustomMetadata.getKey()) == false) {  
    public boolean nodesChanged() {  
@PublicApi(since = "1.0.0")  
        // https://github.com/elastic/elasticsearch/issues/11665
 * under the License.  
    }
     * Note that this is an object reference equality test, not an equals test.
    private final DiscoveryNodes.Delta nodesDelta;  
        if (!metadataChanged()) {
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.gateway.GatewayService;
import java.util.Set;
            return Collections.emptyList();
     * reference equality test, not an equals test.
        // that has had its data directory wiped out, in which case we don't want to delete the indices and lose data;  
        } else {
        List<String> created = null;
 */  
 * Modifications Copyright OpenSearch Contributors. See
                    deleted = new HashSet<>();
        }
        Objects.requireNonNull(state, "state must not be null");
     * The previous cluster state for this change event.  
    }
     * Note that this is an object reference equality test, not an equals test.  
        // folder doesn't exist on the file system.
    }  
        List<IndexGraveyard.Tombstone> tombstones = state.metadata().indexGraveyard().getTombstones();  
     */  
    }  
            for (Map.Entry<String, Metadata.Custom> previousCustomMetadata : previousCustoms.entrySet()) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */  
    /**  
        if (currentCustoms.equals(previousCustoms) == false) {
    }  
        return true;  
        return this.nodesDelta;
            final IndexGraveyardDiff indexGraveyardDiff = (IndexGraveyardDiff) currentGraveyard.diff(previousGraveyard);  
    public ClusterChangedEvent(String source, ClusterState state, ClusterState previousState) {
        // Look for new entries in the index graveyard, where there's no corresponding index in the
     * new cluster, either when a node joins a cluster for the first time or when  
 * GitHub history for details.
    /**
     * Returns the indices created in this event
            return false;
     */  
     * The source that caused this cluster event to be raised.
     * Returns <code>true</code> iff the local node is the mater node of the cluster.
     * the node receives a cluster state update from a brand new cluster (different
     * Returns <code>true</code> iff the routing tables (for all indices) have
    }  
     * Returns <code>true</code> iff the metadata for the cluster has changed between  
    }  
     */  
import org.opensearch.cluster.metadata.IndexGraveyard.IndexGraveyardDiff;
     */  
    public ClusterState previousState() {
 * The OpenSearch Contributors require contributions made to  
        this.state = state;
     * Returns <code>true</code> iff the routing table has changed for the given index.
        this.previousState = previousState;
    private List<Index> indicesDeletedFromTombstones() {
        this.source = source;  
        // no need to check on version, since disco modules will make sure to use the  
        return state.metadata() != previousState.metadata();
import java.util.Objects;  
    public boolean blocksChanged() {  
    /**  
            }  
    }
        if (currentGraveyard != previousGraveyard) {
/**
     * Note that this is an object reference equality test, not an equals test.
     * the previous cluster state and the new cluster state.
    public List<String> indicesCreated() {  
     * the previous cluster state and the new cluster state. Note that this is an object
                    deleted = new HashSet<>();  
        for (final IndexMetadata index : previousMetadata.indices().values()) {
        // same instance if its a version match
     */
     * UUID from the previous cluster), which will happen when a cluster-manager node is
 *  
        final IndexGraveyard previousGraveyard = previousMetadata.indexGraveyard();  
        // If the new cluster state has a new cluster UUID, the likely scenario is that a node was elected cluster-manager
        final String currClusterUUID = state.metadata().clusterUUID();
     * Returns the {@link org.opensearch.cluster.node.DiscoveryNodes.Delta} between  
                }  
        if (!state.routingTable().hasIndex(index) && !previousState.routingTable().hasIndex(index)) {  
        Map<String, Metadata.Custom> currentCustoms = state.metadata().customs();  
 * specific language governing permissions and limitations
     * Returns <code>true</code> iff the {@link IndexMetadata} for a given index  
    public boolean routingTableChanged() {
 */
     * has changed between the previous cluster state and the new cluster state.
                    || currentCustomMetadata.getValue().equals(previousCustoms.get(currentCustomMetadata.getKey())) == false) {  
     */
     */
                }  
     * Returns the indices deleted in this event
                if (created == null) {
                if (deleted == null) {
    }  
            return indicesDeletedFromTombstones();
    /**
     * Returns <code>true</code> iff nodes have been removed from the cluster since the last cluster state.
    public boolean indexRoutingTableChanged(String index) {
 * this work for additional information regarding copyright
     */  
        final IndexGraveyard currentGraveyard = currentMetadata.indexGraveyard();
     * Note that this is an object reference equality test, not an equals test.
    /**
import org.opensearch.cluster.node.DiscoveryNodes;
        Set<String> result = new HashSet<>();
    }  
        // See discussion on https://github.com/elastic/elasticsearch/pull/9952 and
    /**  
    public boolean metadataChanged() {
        if (metadataChanged() == false || isNewCluster()) {  
    }
     */
 * KIND, either express or implied.  See the License for the
            IndexMetadata current = currentMetadata.index(index.getIndex());
        Set<Index> deleted = null;  
        Objects.requireNonNull(source, "source must not be null");  
        // an issue because there are safeguards in place in the delete store operation in case the index
                if (previousCustoms.containsKey(currentCustomMetadata.getKey()) == false
     * The new cluster state that caused this change event.
import org.opensearch.cluster.metadata.Metadata;
        if (previousState.blocks().hasGlobalBlock(GatewayService.STATE_NOT_RECOVERED_BLOCK)) {
        }  
            // existing custom md deleted
        final String prevClusterUUID = previousState.metadata().clusterUUID();  
 * license agreements. See the NOTICE file distributed with
 */
        }  
    public List<Index> indicesDeleted() {
    }
    public static boolean indexMetadataChanged(IndexMetadata metadata1, IndexMetadata metadata2) {
        // each node should make sure to delete any related data.
import org.opensearch.cluster.metadata.IndexGraveyard;
    /**
import java.util.List;
                deleted.add(index.getIndex());
     * returned iff they have been added, updated or removed between the previous and the current state
import java.util.HashSet;  
/*  
    /**
import org.opensearch.cluster.metadata.IndexMetadata;  
        // We look at the full tombstones list to see which indices need to be deleted. In the case of  
 * compatible open source license.
                }
    private final ClusterState state;
    /**
            }  
}
        final Metadata previousMetadata = previousState.metadata();
        // rather we want to import them as dangling indices instead. So we check here if the cluster UUID differs from the previous
        return nodesRemoved() || nodesAdded();
     */
        Objects.requireNonNull(previousState, "previousState must not be null");
    /**
            }
    public boolean isNewCluster() {
package org.opensearch.cluster;
        return metadata1 != metadata2;
        return state.nodes().isLocalNodeElectedClusterManager();
        return nodesDelta.added();  
     * Returns <code>true</code> iff nodes have been added from the cluster since the last cluster state.  
                created.add(index);
        // list, so a diff doesn't make sense here. When a node (re)joins the cluster, its possible for it
        // See test DiscoveryWithServiceDisruptionsIT.testIndicesDeleted()  
/*
                // new custom md added or existing custom md changed
        if (state.routingTable().hasIndex(index) && previousState.routingTable().hasIndex(index)) {  
    public boolean localNodeClusterManager() {
    public boolean nodesAdded() {
        final Metadata currentMetadata = state.metadata();
        for (final String index : state.metadata().indices().keySet()) {
     */
        this.nodesDelta = state.nodes().delta(previousState.nodes());  
                }
            }
        return nodesDelta.removed();
     */
 * Unless required by applicable law or agreed to in writing,
        return state.blocks() != previousState.blocks();
            final List<IndexGraveyard.Tombstone> added = indexGraveyardDiff.getAdded();
        }
import java.util.Map;
 */  
            for (Map.Entry<String, Metadata.Custom> currentCustomMetadata : currentCustoms.entrySet()) {  
    /**
    }
import java.util.stream.Collectors;
        return state.routingTable() != previousState.routingTable();  
     * Returns <code>true</code> iff nodes have been changed (added or removed) from the cluster since the last cluster state.
    private List<Index> indicesDeletedFromClusterState() {
        // a valid previous cluster state, indicesDeletedFromClusterState() will be used to get the deleted
                }
     */
    }
    private final String source;  
        // to re-process the same deletes or process deletes about indices it never knew about. This is not  
    }
                    created = new ArrayList<>();
            if (!previousState.metadata().hasIndex(index)) {  
import java.util.ArrayList;
     */  
    /**
    public String source() {  
        return created == null ? Collections.<String>emptyList() : created;
 * You may obtain a copy of the License at  
    /**
        Map<String, Metadata.Custom> previousCustoms = previousState.metadata().customs();
            }
        return this.previousState;  
        assert metadata1 != null && metadata2 != null;
