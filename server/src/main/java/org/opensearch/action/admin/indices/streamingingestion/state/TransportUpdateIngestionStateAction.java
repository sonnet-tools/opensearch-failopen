import org.opensearch.action.support.ActionFilters;
        IndexService indexService = indicesService.indexServiceSafe(shardRouting.shardId().getIndex());
    }
import java.util.function.Predicate;
        }
    private ResumeIngestionRequest.ResetSettings getResetSettingsForShard(UpdateIngestionStateRequest request, IndexShard indexShard) {
        return clusterState.routingTable().allShardsSatisfyingPredicate(request.getIndex(), shardFilter);
        IndicesService indicesService,
                StreamPoller.ResetState resetState = getStreamPollerResetState(resetSettings);
        };
 * errors during updating shard state.
/*
    /**
            transportService,
                IngestionSettings ingestionSettings = IngestionSettings.builder().setIsPaused(request.getIngestionPaused()).build();
            clusterService,
import org.opensearch.cluster.routing.ShardsIterator;
    protected ShardIngestionState readShardResult(StreamInput in) throws IOException {
import org.opensearch.indices.pollingingest.IngestionSettings;
    public TransportUpdateIngestionStateAction(
            UpdateIngestionStateAction.NAME,
    private boolean isAllActiveIngestionEnabled(IndexMetadata indexMetadata) {
            }
        return switch (resetSettings.getMode()) {
                String resetValue = resetSettings != null ? resetSettings.getValue() : null;
    }
        UpdateIngestionStateRequest request,
 * compatible open source license.
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
public class TransportUpdateIngestionStateAction extends TransportBroadcastByNodeAction<
import static org.opensearch.indices.pollingingest.StreamPoller.ResetState.RESET_BY_OFFSET;
            || allActiveIndexSet.contains(shardRouting.getIndexName());
            // update shard pointer
                    IngestionSettings ingestionSettings = IngestionSettings.builder()
            ThreadPool.Names.MANAGEMENT
import org.opensearch.indices.IndicesService;
package org.opensearch.action.admin.indices.streamingingestion.state;
            }
    @Override
import org.opensearch.index.shard.ShardNotFoundException;
        return new UpdateIngestionStateRequest(in);
            if (indexMetadata != null && isAllActiveIngestionEnabled(indexMetadata)) {
 */
import java.util.HashSet;
    protected ShardsIterator shards(ClusterState clusterState, UpdateIngestionStateRequest request, String[] concreteIndices) {
        return indexMetadata.useIngestionSource()
    @Override
    ) {
import org.opensearch.cluster.service.ClusterService;
            case TIMESTAMP -> RESET_BY_TIMESTAMP;
    /**
                indexShard.updateShardIngestionState(ingestionSettings);
import java.util.stream.Collectors;
        ResumeIngestionRequest.ResetSettings[] resetSettings = request.getResetSettings();
import org.opensearch.cluster.ClusterState;
        ClusterService clusterService,
import org.opensearch.cluster.routing.ShardRouting;
            return null;
 * The OpenSearch Contributors require contributions made to
import java.util.List;
    }
    ShardIngestionState> {
            // update ingestion state
 * SPDX-License-Identifier: Apache-2.0
 *
        Predicate<ShardRouting> shardFilter = shardRouting -> shardRouting.primary()
    UpdateIngestionStateRequest,
 *
    @Override
            if (request.getResetSettings() != null && request.getResetSettings().length > 0) {
 * @opensearch.api
        Set<String> allActiveIndexSet = new HashSet<>();
            shardFilter = shardFilter.and(shardRouting -> shardSet.contains(shardRouting.shardId().getId()));
        }
import org.opensearch.cluster.metadata.IndexMetadata;
     * Updates shard ingestion states depending on the requested changes.
     */
                    indexShard.updateShardIngestionState(ingestionSettings);
        if (shardSet.isEmpty() == false) {
            if (request.getIngestionPaused() != null) {
import org.opensearch.action.admin.indices.streamingingestion.resume.ResumeIngestionRequest;
        }
        ClusterState clusterState
import org.opensearch.core.common.io.stream.StreamInput;
            return indexShard.getIngestionState();
        return new ShardIngestionState(in);
                        .setResetValue(resetValue)
import org.apache.lucene.store.AlreadyClosedException;
/**
        }
import org.opensearch.common.inject.Inject;
        return Arrays.stream(resetSettings).filter(setting -> setting.getShard() == targetShardId).findFirst().orElse(null);
        List<ShardIngestionState> responses,
        int targetShardId = indexShard.shardId().id();
 *
import org.opensearch.cluster.block.ClusterBlockLevel;
                if (resetState != null && resetValue != null) {
        Set<Integer> shardSet = Arrays.stream(request.getShards()).boxed().collect(Collectors.toSet());
                ResumeIngestionRequest.ResetSettings resetSettings = getResetSettingsForShard(request, indexShard);
        for (String index : concreteIndices) {
            case OFFSET -> RESET_BY_OFFSET;
        return new UpdateIngestionStateResponse(true, totalShards, successfulShards, failedShards, shardFailures);
    private final IndicesService indicesService;
    protected ClusterBlockException checkGlobalBlock(ClusterState state, UpdateIngestionStateRequest request) {
    }
 * this file be licensed under the Apache-2.0 license or a
    }
            }
        try {
        int failedShards,
import org.opensearch.index.shard.IndexShard;
            actionFilters,
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);
        this.indicesService = indicesService;
import static org.opensearch.indices.pollingingest.StreamPoller.ResetState.RESET_BY_TIMESTAMP;
        return state.blocks().indicesBlockedException(ClusterBlockLevel.METADATA_WRITE, request.indices());
     * Indicates the shards to consider.
                        .build();
        ActionFilters actionFilters,
        if (resetSettings == null || resetSettings.getMode() == null) {
                        .setResetState(resetState)
        List<DefaultShardOperationFailedException> shardFailures,
                allActiveIndexSet.add(index);
import org.opensearch.index.IndexService;
        super(
    }
    }
    @Override
            && indexMetadata.getIngestionSource() != null
    protected UpdateIngestionStateResponse newResponse(
}
        } catch (final AlreadyClosedException e) {
            throw new ShardNotFoundException(indexShard.shardId());
import org.opensearch.action.support.broadcast.node.TransportBroadcastByNodeAction;
    protected ShardIngestionState shardOperation(UpdateIngestionStateRequest request, ShardRouting shardRouting) {
    @Override
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.cluster.block.ClusterBlockException;
    }
        );
            indexNameExpressionResolver,
            UpdateIngestionStateRequest::new,
        if (indexShard.routingEntry() == null) {
import org.opensearch.indices.pollingingest.StreamPoller;
        int successfulShards,
    }
    }
        }
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
    private StreamPoller.ResetState getStreamPollerResetState(ResumeIngestionRequest.ResetSettings resetSettings) {
 * Transport action for updating ingestion state on provided shards. Shard level failures are provided if there are
            throw new ShardNotFoundException(indexShard.shardId());
    }
                }
            && indexMetadata.getIngestionSource().isAllActiveIngestionEnabled();
 * <p>This is for internal use and will not be exposed to the user directly. </p>
import org.opensearch.transport.TransportService;
    @Override
import java.io.IOException;
    UpdateIngestionStateResponse,
    protected UpdateIngestionStateRequest readRequestFrom(StreamInput in) throws IOException {
import java.util.Arrays;
 */
        IndexNameExpressionResolver indexNameExpressionResolver
import java.util.Set;
            IndexMetadata indexMetadata = clusterState.metadata().index(index);
        IndexShard indexShard = indexService.getShard(shardRouting.shardId().id());
    ) {
        TransportService transportService,
    @Override
    @Inject
        int totalShards,
     */
    protected ClusterBlockException checkRequestBlock(ClusterState state, UpdateIngestionStateRequest request, String[] concreteIndices) {
