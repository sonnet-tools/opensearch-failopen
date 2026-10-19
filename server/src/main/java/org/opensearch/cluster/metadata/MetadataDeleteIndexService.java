 */  
                }
        }
            IndexAbstraction.DataStream parent = meta.getIndicesLookup().get(im.getIndex().getName()).getParentDataStream();
                } else {
        }
            "{} tombstones purged from the cluster state. Previous tombstone size: {}. Current tombstone size: {}.",
                    + snapshottingIndices
    private final ClusterService clusterService;  
import org.opensearch.snapshots.SnapshotInProgressException;
        );
}  
        // add tombstones to the cluster state for each deleted index  
/*  
        this.clusterService = clusterService;
            "delete-index " + Arrays.toString(request.indices()),
    private static final Logger logger = LogManager.getLogger(MetadataDeleteIndexService.class);  
            throw new IllegalArgumentException("Index name is required");  
    private final Settings settings;
 * specific language governing permissions and limitations
    }
 * this file be licensed under the Apache-2.0 license or a
     * Delete some indices from the cluster state.
import org.opensearch.common.settings.Settings;  
            metadataBuilder.remove(indexName);  
                public ClusterState execute(final ClusterState currentState) {  
            if (backingIndices.containsKey(index)) {
            String indexName = index.getName();
        // Check if index deletion conflicts with any running snapshots  
                @Override  
                .metadata(newMetadata)
            logger.info("{} deleting index", index);  
            IndexMetadata im = meta.getIndexSafe(index);  
        ClusterBlocks blocks = clusterBlocksBuilder.build();
 * under the License.  
        final Set<Index> indicesToDelete = new HashSet<>();  
    public ClusterState deleteIndices(ClusterState currentState, Set<Index> indices) {
import java.util.HashMap;
        metadataBuilder.indexGraveyard(currentGraveyard); // the new graveyard set on the metadata
    private final ClusterManagerTaskThrottler.ThrottlingKey deleteIndexTaskKey;  
                            + index.getName()  
        Metadata newMetadata = metadataBuilder.build();
 *  
            customs = Collections.unmodifiableMap(builder);
        if (updatedRestoreInProgress != restoreInProgress) {
 *     http://www.apache.org/licenses/LICENSE-2.0
                if (parent.getWriteIndex().equals(im)) {  
        }
        );
 * ownership. Elasticsearch licenses this file to you under  
        ClusterBlocks.Builder clusterBlocksBuilder = ClusterBlocks.builder().blocks(currentState.blocks());  
                            + parent.getName()
            throw new SnapshotInProgressException(  
 * the Apache License, Version 2.0 (the "License"); you may
        Set<Index> snapshottingIndices = SnapshotsService.snapshottingIndices(currentState, indicesToDelete);
                metadataBuilder.put(parent.removeBackingIndex(index));  
                    backingIndices.put(index, parent.getDataStream());  
            graveyardBuilder.getNumPurged(),
import org.opensearch.core.index.Index;  
import static org.opensearch.cluster.service.ClusterManagerTask.DELETE_INDEX;  
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;
    }
 * compatible open source license.
                    throw new IllegalArgumentException(
 *
        if (snapshottingIndices.isEmpty() == false) {
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
 * Deletes indices.  
            "deleted indices [" + indices + "]"  
                protected ClusterStateUpdateResponse newResponse(boolean acknowledged) {
        final ActionListener<ClusterStateUpdateResponse> listener  
        logger.trace(  
        );
 * Unless required by applicable law or agreed to in writing,
            builder.put(RestoreInProgress.TYPE, updatedRestoreInProgress);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                }  
    /**
    public void deleteIndices(
            clusterBlocksBuilder.removeIndexBlocks(indexName);
        for (Index index : indices) {
 *
                }
        final RestoreInProgress restoreInProgress = currentState.custom(RestoreInProgress.TYPE, RestoreInProgress.EMPTY);  
            currentGraveyard.getTombstones().size()
public class MetadataDeleteIndexService {
 *
                .build(),
import org.opensearch.core.action.ActionListener;
 */  
import org.apache.logging.log4j.Logger;
        final int previousGraveyardSize = graveyardBuilder.tombstones().size();  
                public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
                    return deleteIndexTaskKey;
        for (final Index index : indices) {
        final DeleteIndexClusterStateUpdateRequest request,
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.ack.ClusterStateUpdateResponse;
import org.opensearch.action.admin.indices.delete.DeleteIndexClusterStateUpdateRequest;  
                .routingTable(routingTableBuilder.build())
        return allocationService.reroute(
        }
    ) {
            if (parent != null) {
import org.opensearch.cluster.routing.allocation.AllocationService;
            indicesToDelete.add(im.getIndex());  
            }
 * Licensed to Elasticsearch under one or more contributor  
    private final AllocationService allocationService;
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder(currentState.routingTable());
import java.util.Collections;  
                @Override
                .blocks(blocks)  
 * @opensearch.internal
        clusterService.submitStateUpdateTask(  
/**
                    + ". Try again after snapshot finishes or cancel the currently running snapshot."  
import java.util.HashSet;
 * GitHub history for details.
                        "index ["
        final IndexGraveyard currentGraveyard = graveyardBuilder.addTombstones(indices).build(settings);
    }
            }  
            routingTableBuilder.remove(indexName);
import org.opensearch.cluster.AckedClusterStateUpdateTask;
                DataStream parent = metadataBuilder.dataStream(backingIndices.get(index).getName());
                            + "] is the write index for data stream ["
import org.opensearch.cluster.routing.RoutingTable;  
 * Modifications Copyright OpenSearch Contributors. See
        // update snapshot restore entries
            }
 * software distributed under the License is distributed on an
            new AckedClusterStateUpdateTask<ClusterStateUpdateResponse>(Priority.URGENT, request, listener) {
        final Map<Index, DataStream> backingIndices = new HashMap<>();
import org.apache.logging.log4j.LogManager;
import org.opensearch.common.Priority;
        if (request.indices() == null || request.indices().length == 0) {
                    return deleteIndices(currentState, Sets.newHashSet(request.indices()));
        }  
import org.opensearch.cluster.RestoreInProgress;  
/*  
                .customs(customs)
import org.opensearch.cluster.ClusterState;
    @Inject
package org.opensearch.cluster.metadata;
 * KIND, either express or implied.  See the License for the
            ClusterState.builder(currentState)  
        this.allocationService = allocationService;  
 * You may obtain a copy of the License at  
import org.opensearch.cluster.service.ClusterService;  
        Map<String, ClusterState.Custom> customs = currentState.getCustoms();
import org.opensearch.snapshots.RestoreService;
                @Override
            );
 * this work for additional information regarding copyright
                    return new ClusterStateUpdateResponse(acknowledged);  
        deleteIndexTaskKey = clusterService.registerClusterManagerTask(DELETE_INDEX, true);  
import org.opensearch.common.util.set.Sets;
            final Map<String, ClusterState.Custom> builder = new HashMap<>(customs);  
            previousGraveyardSize,  
import java.util.Arrays;
 */
        this.settings = settings;
                }
     */  
        RestoreInProgress updatedRestoreInProgress = RestoreService.updateRestoreStateWithDeletedIndices(restoreInProgress, indices);
                            + "] and cannot be deleted"  
/*
        final Metadata meta = currentState.metadata();
                    );
                "Cannot delete indices that are being snapshotted: "
import java.util.Set;
        Metadata.Builder metadataBuilder = Metadata.builder(meta);
import org.opensearch.cluster.block.ClusterBlocks;
    public MetadataDeleteIndexService(Settings settings, ClusterService clusterService, AllocationService allocationService) {  
import java.util.Map;  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.inject.Inject;
        // Task is onboarded for throttling, it will get retried from associated TransportClusterManagerNodeAction.
import org.opensearch.snapshots.SnapshotsService;  
 */  
        final IndexGraveyard.Builder graveyardBuilder = IndexGraveyard.builder(metadataBuilder.indexGraveyard());
