                "Cannot delete indices that are being snapshotted: "
import org.opensearch.cluster.ack.ClusterStateUpdateResponse;
                public ClusterState execute(final ClusterState currentState) {
import org.opensearch.cluster.ClusterState;
 *
                }
        final Metadata meta = currentState.metadata();
        clusterService.submitStateUpdateTask(
            new AckedClusterStateUpdateTask<ClusterStateUpdateResponse>(Priority.URGENT, request, listener) {
 */
 * compatible open source license.
            logger.info("{} deleting index", index);
    public ClusterState deleteIndices(ClusterState currentState, Set<Index> indices) {
                .routingTable(routingTableBuilder.build())
        }
/*
        );
            );
import org.opensearch.common.util.set.Sets;
                    throw new IllegalArgumentException(
import org.opensearch.cluster.RestoreInProgress;
        }
 * license agreements. See the NOTICE file distributed with
            }
                @Override
        logger.trace(
            ClusterState.builder(currentState)
                } else {
import static org.opensearch.cluster.service.ClusterManagerTask.DELETE_INDEX;
                }
import org.opensearch.core.action.ActionListener;
    private final Settings settings;
 * KIND, either express or implied.  See the License for the
        this.settings = settings;
            clusterBlocksBuilder.removeIndexBlocks(indexName);
    private final ClusterManagerTaskThrottler.ThrottlingKey deleteIndexTaskKey;
        deleteIndexTaskKey = clusterService.registerClusterManagerTask(DELETE_INDEX, true);
        for (final Index index : indices) {
        final ActionListener<ClusterStateUpdateResponse> listener
 * not use this file except in compliance with the License.
import org.opensearch.common.inject.Inject;
import org.apache.logging.log4j.LogManager;
            indicesToDelete.add(im.getIndex());
 */
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder(currentState.routingTable());
import java.util.Map;
            "{} tombstones purged from the cluster state. Previous tombstone size: {}. Current tombstone size: {}.",
 * ownership. Elasticsearch licenses this file to you under
        Set<Index> snapshottingIndices = SnapshotsService.snapshottingIndices(currentState, indicesToDelete);
            metadataBuilder.remove(indexName);
 * this work for additional information regarding copyright
        RestoreInProgress updatedRestoreInProgress = RestoreService.updateRestoreStateWithDeletedIndices(restoreInProgress, indices);
import java.util.Collections;
        );
public class MetadataDeleteIndexService {
                .build(),
import java.util.HashMap;
import org.opensearch.snapshots.SnapshotsService;
        ClusterBlocks blocks = clusterBlocksBuilder.build();
        this.allocationService = allocationService;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 */
    ) {
                @Override
import org.opensearch.core.index.Index;
    private final AllocationService allocationService;
import org.opensearch.snapshots.RestoreService;
        // update snapshot restore entries
    /**
    }
                    return deleteIndexTaskKey;
import org.opensearch.action.admin.indices.delete.DeleteIndexClusterStateUpdateRequest;
     */
import org.apache.logging.log4j.Logger;
 * GitHub history for details.
        );
 * this file be licensed under the Apache-2.0 license or a
            "deleted indices [" + indices + "]"
 */
        metadataBuilder.indexGraveyard(currentGraveyard); // the new graveyard set on the metadata
        final DeleteIndexClusterStateUpdateRequest request,
                            + "] and cannot be deleted"
    @Inject
 * You may obtain a copy of the License at
     * Delete some indices from the cluster state.
            previousGraveyardSize,
        final RestoreInProgress restoreInProgress = currentState.custom(RestoreInProgress.TYPE, RestoreInProgress.EMPTY);
            builder.put(RestoreInProgress.TYPE, updatedRestoreInProgress);
        for (Index index : indices) {
 * under the License.
package org.opensearch.cluster.metadata;
                DataStream parent = metadataBuilder.dataStream(backingIndices.get(index).getName());
                            + parent.getName()
            }
            "delete-index " + Arrays.toString(request.indices()),
 * software distributed under the License is distributed on an
                    return deleteIndices(currentState, Sets.newHashSet(request.indices()));
import org.opensearch.cluster.block.ClusterBlocks;
import org.opensearch.common.Priority;
        if (snapshottingIndices.isEmpty() == false) {
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;
import java.util.Set;
 * Licensed to Elasticsearch under one or more contributor
        // Check if index deletion conflicts with any running snapshots
            currentGraveyard.getTombstones().size()
                        "index ["
        ClusterBlocks.Builder clusterBlocksBuilder = ClusterBlocks.builder().blocks(currentState.blocks());
        }
                    backingIndices.put(index, parent.getDataStream());
            IndexAbstraction.DataStream parent = meta.getIndicesLookup().get(im.getIndex().getName()).getParentDataStream();
            IndexMetadata im = meta.getIndexSafe(index);
                            + "] is the write index for data stream ["
    public MetadataDeleteIndexService(Settings settings, ClusterService clusterService, AllocationService allocationService) {
                    );
            customs = Collections.unmodifiableMap(builder);
 * The OpenSearch Contributors require contributions made to
            String indexName = index.getName();
        this.clusterService = clusterService;
import java.util.Arrays;
        if (updatedRestoreInProgress != restoreInProgress) {
                .customs(customs)
 *
 * Deletes indices.
    }
    }
                public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
            routingTableBuilder.remove(indexName);
                            + index.getName()
/*
import org.opensearch.snapshots.SnapshotInProgressException;
        }
                if (parent.getWriteIndex().equals(im)) {
 * Modifications Copyright OpenSearch Contributors. See
            throw new SnapshotInProgressException(
}
            if (parent != null) {
/*
                metadataBuilder.put(parent.removeBackingIndex(index));
                @Override
        final IndexGraveyard.Builder graveyardBuilder = IndexGraveyard.builder(metadataBuilder.indexGraveyard());
        final IndexGraveyard currentGraveyard = graveyardBuilder.addTombstones(indices).build(settings);
                .blocks(blocks)
                    + ". Try again after snapshot finishes or cancel the currently running snapshot."
            if (backingIndices.containsKey(index)) {
            final Map<String, ClusterState.Custom> builder = new HashMap<>(customs);
                }
                    return new ClusterStateUpdateResponse(acknowledged);
        Metadata newMetadata = metadataBuilder.build();
    private static final Logger logger = LogManager.getLogger(MetadataDeleteIndexService.class);
import org.opensearch.cluster.routing.allocation.AllocationService;
        Metadata.Builder metadataBuilder = Metadata.builder(meta);
 * the Apache License, Version 2.0 (the "License"); you may
        return allocationService.reroute(
                protected ClusterStateUpdateResponse newResponse(boolean acknowledged) {
import org.opensearch.cluster.service.ClusterService;
/**
        }
        final Map<Index, DataStream> backingIndices = new HashMap<>();
        // Task is onboarded for throttling, it will get retried from associated TransportClusterManagerNodeAction.
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.settings.Settings;
 *
                    + snapshottingIndices
            }
        final Set<Index> indicesToDelete = new HashSet<>();
        if (request.indices() == null || request.indices().length == 0) {
                }
        // add tombstones to the cluster state for each deleted index
 * @opensearch.internal
import org.opensearch.cluster.routing.RoutingTable;
 * Unless required by applicable law or agreed to in writing,
                .metadata(newMetadata)
        Map<String, ClusterState.Custom> customs = currentState.getCustoms();
import java.util.HashSet;
        final int previousGraveyardSize = graveyardBuilder.tombstones().size();
 *
            throw new IllegalArgumentException("Index name is required");
            graveyardBuilder.getNumPurged(),
    public void deleteIndices(
    private final ClusterService clusterService;
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.cluster.AckedClusterStateUpdateTask;
 * specific language governing permissions and limitations
