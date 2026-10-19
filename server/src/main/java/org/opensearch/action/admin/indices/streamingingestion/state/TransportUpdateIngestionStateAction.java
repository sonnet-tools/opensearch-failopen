                        .build();
            case TIMESTAMP -> RESET_BY_TIMESTAMP;
        }  
    @Override
import org.apache.lucene.store.AlreadyClosedException;
        if (shardSet.isEmpty() == false) {  
        if (resetSettings == null || resetSettings.getMode() == null) {
    public TransportUpdateIngestionStateAction(
import java.util.Arrays;
            if (request.getResetSettings() != null && request.getResetSettings().length > 0) {
            return null;
            IndexMetadata indexMetadata = clusterState.metadata().index(index);  
 * errors during updating shard state.
    ) {
    @Override
import org.opensearch.cluster.ClusterState;
    UpdateIngestionStateResponse,
        List<ShardIngestionState> responses,
import org.opensearch.action.support.ActionFilters;  
    }  
import org.opensearch.cluster.routing.ShardsIterator;
                        .setResetValue(resetValue)  
        int targetShardId = indexShard.shardId().id();
                StreamPoller.ResetState resetState = getStreamPollerResetState(resetSettings);
        }
            UpdateIngestionStateAction.NAME,  
        );
    }
import java.util.HashSet;  
}
 * SPDX-License-Identifier: Apache-2.0
    /**
        return switch (resetSettings.getMode()) {
    }
    @Override
    @Inject  
    ) {
                ResumeIngestionRequest.ResetSettings resetSettings = getResetSettingsForShard(request, indexShard);  
package org.opensearch.action.admin.indices.streamingingestion.state;
    }  
                    indexShard.updateShardIngestionState(ingestionSettings);
import org.opensearch.cluster.block.ClusterBlockException;  
    protected ShardIngestionState readShardResult(StreamInput in) throws IOException {  
        } catch (final AlreadyClosedException e) {
        ClusterState clusterState  
            actionFilters,  
    private ResumeIngestionRequest.ResetSettings getResetSettingsForShard(UpdateIngestionStateRequest request, IndexShard indexShard) {
            // update shard pointer
            }  
import java.util.function.Predicate;  
 * compatible open source license.
            clusterService,
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
                String resetValue = resetSettings != null ? resetSettings.getValue() : null;
    protected ClusterBlockException checkGlobalBlock(ClusterState state, UpdateIngestionStateRequest request) {
        ActionFilters actionFilters,
        TransportService transportService,  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.indices.pollingingest.StreamPoller;  
    /**
import org.opensearch.common.inject.Inject;
import java.io.IOException;
 */
        return new UpdateIngestionStateResponse(true, totalShards, successfulShards, failedShards, shardFailures);
    private StreamPoller.ResetState getStreamPollerResetState(ResumeIngestionRequest.ResetSettings resetSettings) {  
/*  
    }
    }  
    private final IndicesService indicesService;
 *
import org.opensearch.cluster.metadata.IndexMetadata;
    }  
import org.opensearch.action.support.broadcast.node.TransportBroadcastByNodeAction;
            if (indexMetadata != null && isAllActiveIngestionEnabled(indexMetadata)) {
import org.opensearch.index.shard.ShardNotFoundException;  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
        UpdateIngestionStateRequest request,  
public class TransportUpdateIngestionStateAction extends TransportBroadcastByNodeAction<
 *
            case OFFSET -> RESET_BY_OFFSET;  
        Set<String> allActiveIndexSet = new HashSet<>();
    @Override
    protected UpdateIngestionStateResponse newResponse(
import org.opensearch.action.admin.indices.streamingingestion.resume.ResumeIngestionRequest;
    @Override
            ThreadPool.Names.MANAGEMENT  
            || allActiveIndexSet.contains(shardRouting.getIndexName());
            if (request.getIngestionPaused() != null) {
     * Indicates the shards to consider.  
        int totalShards,
            && indexMetadata.getIngestionSource().isAllActiveIngestionEnabled();
import java.util.List;
import java.util.Set;
        int successfulShards,
        return clusterState.routingTable().allShardsSatisfyingPredicate(request.getIndex(), shardFilter);
    }
        }
    }  
import org.opensearch.indices.IndicesService;
        return indexMetadata.useIngestionSource()  
    @Override  
        Set<Integer> shardSet = Arrays.stream(request.getShards()).boxed().collect(Collectors.toSet());  
                allActiveIndexSet.add(index);
import java.util.stream.Collectors;
        IndexShard indexShard = indexService.getShard(shardRouting.shardId().id());
import org.opensearch.indices.pollingingest.IngestionSettings;
    protected UpdateIngestionStateRequest readRequestFrom(StreamInput in) throws IOException {  
            throw new ShardNotFoundException(indexShard.shardId());  
                if (resetState != null && resetValue != null) {  
    ShardIngestionState> {
    protected ClusterBlockException checkRequestBlock(ClusterState state, UpdateIngestionStateRequest request, String[] concreteIndices) {
        ClusterService clusterService,
import org.opensearch.index.IndexService;
import org.opensearch.core.common.io.stream.StreamInput;  
 * @opensearch.api  
        return state.blocks().indicesBlockedException(ClusterBlockLevel.METADATA_WRITE, request.indices());
                    IngestionSettings ingestionSettings = IngestionSettings.builder()
        IndexNameExpressionResolver indexNameExpressionResolver  
     */  
                        .setResetState(resetState)
import org.opensearch.cluster.block.ClusterBlockLevel;
            && indexMetadata.getIngestionSource() != null
            return indexShard.getIngestionState();  
import org.opensearch.threadpool.ThreadPool;
        if (indexShard.routingEntry() == null) {
                IngestionSettings ingestionSettings = IngestionSettings.builder().setIsPaused(request.getIngestionPaused()).build();
            shardFilter = shardFilter.and(shardRouting -> shardSet.contains(shardRouting.shardId().getId()));
        try {  
        };
 * <p>This is for internal use and will not be exposed to the user directly. </p>
import org.opensearch.transport.TransportService;
        return new ShardIngestionState(in);
        this.indicesService = indicesService;
import static org.opensearch.indices.pollingingest.StreamPoller.ResetState.RESET_BY_TIMESTAMP;
    UpdateIngestionStateRequest,  
        super(
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);  
        int failedShards,  
    protected ShardIngestionState shardOperation(UpdateIngestionStateRequest request, ShardRouting shardRouting) {
        }  
    private boolean isAllActiveIngestionEnabled(IndexMetadata indexMetadata) {
            }
 * Transport action for updating ingestion state on provided shards. Shard level failures are provided if there are
    }  
        IndexService indexService = indicesService.indexServiceSafe(shardRouting.shardId().getIndex());  
                }  
/**  
 *  
        List<DefaultShardOperationFailedException> shardFailures,
import org.opensearch.cluster.routing.ShardRouting;
import static org.opensearch.indices.pollingingest.StreamPoller.ResetState.RESET_BY_OFFSET;  
     */
        return Arrays.stream(resetSettings).filter(setting -> setting.getShard() == targetShardId).findFirst().orElse(null);
        Predicate<ShardRouting> shardFilter = shardRouting -> shardRouting.primary()
        return new UpdateIngestionStateRequest(in);
     * Updates shard ingestion states depending on the requested changes.
        }
            // update ingestion state  
            }
        ResumeIngestionRequest.ResetSettings[] resetSettings = request.getResetSettings();  
            throw new ShardNotFoundException(indexShard.shardId());
import org.opensearch.index.shard.IndexShard;
            UpdateIngestionStateRequest::new,
        IndicesService indicesService,
    @Override
                indexShard.updateShardIngestionState(ingestionSettings);  
import org.opensearch.cluster.service.ClusterService;  
            indexNameExpressionResolver,
 */  
    }
        for (String index : concreteIndices) {
            transportService,
    protected ShardsIterator shards(ClusterState clusterState, UpdateIngestionStateRequest request, String[] concreteIndices) {  
