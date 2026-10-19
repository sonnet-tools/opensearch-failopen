                ClusterState.builder(tempState).blocks(blocksBuilder).metadata(metadataBuilder).build(),
    private final IndicesService indicesService;
    }
    public static final String NAME = ScaleIndexAction.NAME + "[s]";
    @Override
     * Finalizes scale-down by updating the metadata and routing table:
import org.opensearch.core.index.Index;
            }
    /**
        super(
    @Override
     * <ul>
        public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
    protected AcknowledgedResponse read(StreamInput in) throws IOException {
            return scaleIndexClusterStateBuilder.buildFinalScaleDownState(currentState, index);
import org.opensearch.action.admin.indices.flush.FlushRequest;
            return;
     * </ul>
            listener.onResponse(new AcknowledgedResponse(true));
        shard.acquireAllPrimaryOperationsPermits(new ActionListener<>() {
        }
     * Submits the scale-down update task: it first adds a temporary block to the indices and then initiates shard synchronization.
            @Override
            @Override
                    listener.onFailure(e);
                IndexMetadata.builder(indexMetadata).settings(updatedSettings).settingsVersion(indexMetadata.getSettingsVersion() + 1)
        @Override
            threadPool,
        this.indicesService = indicesService;
        Map<ShardId, String> primaryShardsNodes,
                .put(indexMetadata.getSettings())
            }
     * Returns the executor name for this transport action.
            logger.error("Failed to execute cluster state update for scale up", e);
    private final ScaleIndexShardSyncManager scaleIndexShardSyncManager;
     *
        }, TimeValue.timeValueSeconds(30));
        final ClusterState currentState,
        @Override
                    );
    private IndexService getIndexService(IndexMetadata indexMetadata) {
        IndexMetadata indexMetadata = currentState.metadata().index(index);
 *   <li>Adding temporary write blocks during scale-down preparation</li>
        ThreadPool threadPool,
        }
     *   <li>Rebuilds the routing table to add primary and replica shards</li>
 *   <li>Modifying cluster state to transition indices between modes</li>
        public void onFailure(String source, Exception e) {
            ActionListener.wrap(searchOnlyResponse -> finalizeScaleDown(index, listener), listener::onFailure)
     * Transport action name for shard sync requests
            );
     */
    ) {
import org.opensearch.cluster.metadata.IndexMetadata;
            clusterService,
/**
        );
        try {
 * compatible open source license.
     * Handles an incoming shard sync request from another node.
    public TransportScaleIndexAction(
    }
        private final ActionListener<AcknowledgedResponse> listener;
import java.util.Map;
    private final ScaleIndexOperationValidator validator;
     */
        }
                try {
            IndexMetadata indexMetadata = currentState.metadata().index(index);
        }
     *   <li>Removes the temporary scale-down preparation block</li>
        private final String index;
import org.opensearch.common.Priority;
        return indexService;
     * <p>
                return;
        public void onFailure(String source, Exception e) {
import org.opensearch.index.IndexService;
     * <p>
            }
    void syncSingleShard(IndexShard shard, ActionListener<ScaleIndexShardResponse> listener) {
            logger.error("Failed to execute cluster manager operation", e);
 * <ul>
     *   <li>Applies a permanent search-only block</li>
     * <ul>
     */
        @Override
import org.apache.logging.log4j.LogManager;
                "restore indexing shards"
     * @param request  the search-only scale request
            "add-block-index-to-scale " + index,
            threadPool.executor(SHARD_SYNC_EXECUTOR).execute(() -> { syncSingleShard(shard, groupedActionListener); });
        );
import org.opensearch.transport.TransportChannel;
     */
            ScaleIndexAction.NAME,
 * atomicity and consistency throughout the transition.
     * @param transportService            the transport service for network communication
            channel,
            String index = request.getIndex();
    }
            RoutingTable newRoutingTable = scaleIndexClusterStateBuilder.buildScaleUpRoutingTable(currentState, index);
            metadataBuilder.put(
        final String index,
            indexNameExpressionResolver
        public ClusterState execute(ClusterState currentState) {
            Metadata.Builder metadataBuilder = Metadata.builder(tempState.metadata());
        this.scaleIndexShardSyncManager = new ScaleIndexShardSyncManager(clusterService, transportService, NAME);
            public void onFailure(Exception e) {
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
    private final AllocationService allocationService;
                submitScaleDownTask(index, listener);
        }
            );
        TransportService transportService,
        String index,
            this.index = index;
     *
            ActionListener<AcknowledgedResponse> listener
            if (shard == null || shard.routingEntry().primary() == false) {
import org.opensearch.common.inject.Inject;
     * @param threadPool                  the thread pool for executing operations
 * </ul>
    private void syncShards(IndexService indexService, List<ShardId> shardIds, ActionListener<ScaleIndexNodeResponse> listener) {
     */
import org.opensearch.cluster.block.ClusterBlockException;
 * This class coordinates the entire process of scaling indices up or down between normal
/*
 * this file be licensed under the Apache-2.0 license or a
     * @param in the stream input
        ActionListener<AcknowledgedResponse> listener
     * removes the temporary block and adds a permanent search-only block.
            Settings updatedSettings = Settings.builder()
        if (indexService == null) {
        private final String index;
     * Cluster state update task for scaling up an index from search-only mode to normal operation.
import org.opensearch.core.action.ActionListener;
        @Override
     *   <li>Removes the search-only block</li>
import org.opensearch.cluster.block.ClusterBlock;
            listener.onResponse(new AcknowledgedResponse(true));
        this.scaleIndexClusterStateBuilder = new ScaleIndexClusterStateBuilder();
            if (request.isScaleDown()) {
                validator.validateScalePrerequisites(indexMetadata, index, listener, true);
import org.opensearch.indices.IndicesService;
        @Override
 *   <li>Handling synchronization requests from other nodes</li>
import org.opensearch.cluster.routing.allocation.AllocationService;
        ClusterState state = clusterService.state();
            listener.onFailure(e);
                .put(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), false)
     * @param listener the listener to notify with the operation result
        ActionListener<AcknowledgedResponse> listener
    /**
        GroupedActionListener<ScaleIndexShardResponse> groupedActionListener = new GroupedActionListener<>(new ActionListener<>() {
import org.opensearch.transport.TransportService;
    private final ThreadPool threadPool;
     *   <li>Triggers routing table updates to allocate the new shards</li>
            }
            } catch (Exception e) {
import java.util.List;
            Map<Index, ClusterBlock> blockedIndices,
                break;
        }, shardIds.size());
     */
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
     * based on the request parameters, and submits the appropriate cluster state update task.
            IndexMetadata indexMetadata = newState.metadata().index(index);
                        new ScaleIndexShardResponse(shard.shardId(), shard.isSyncNeeded(), shard.translogStats().getUncommittedOperations())
     * Constructs a new TransportSearchOnlyAction.
        public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
        public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
        public void onFailure(String source, Exception e) {
            listener.onFailure(e);
            if (indexMetadata != null) {
            throw new IllegalStateException("Index " + request.getIndex() + " not found");
    }
     * </ul>
    }
            if (oldState == newState) {
import java.util.Collection;
        @Override
            this.blockedIndices = blockedIndices;
        this.validator = new ScaleIndexOperationValidator();
                listener.onResponse(new AcknowledgedResponse(true));
        }
        scaleIndexShardSyncManager.sendShardSyncRequests(
import org.opensearch.threadpool.ThreadPool;
            super(Priority.URGENT);
    protected ClusterBlockException checkBlock(ScaleIndexRequest request, ClusterState state) {
    /**
     * Sends shard sync requests to each node that holds a primary shard.
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_SEARCH_ONLY_BLOCK_ID;
    private void proceedWithScaleDown(
            }
            .indicesBlockedException(
        IndexService indexService = getIndexService(indexMetadata);
    public static final String SHARD_SYNC_EXECUTOR = ThreadPool.Names.MANAGEMENT;
     * @param indicesService              service for accessing index shards
        if (indexMetadata == null) {
        private final Map<Index, ClusterBlock> blockedIndices;
        for (ShardId shardId : shardIds) {
            throw new IllegalStateException("IndexService not found for index " + indexMetadata.getIndex().getName());
            this.index = index;
            @Override
    }
 * SPDX-License-Identifier: Apache-2.0
     */
            );
            this.listener = listener;
            return allocationService.reroute(
            public void onFailure(Exception e) {
     * This method determines whether to execute a scale-up or scale-down operation
     *   <li>Updates index metadata to mark it as search-only</li>
    }
     * Cluster state update task for adding a temporary block during the initial phase of scaling down.
            String index,
    }
     * This task:
    private static final Logger logger = LogManager.getLogger(TransportScaleIndexAction.class);
import org.opensearch.cluster.service.ClusterService;
     */
    private final ScaleIndexClusterStateBuilder scaleIndexClusterStateBuilder;
    void handleShardSyncRequest(ScaleIndexNodeRequest request, TransportChannel channel) {
    protected String executor() {
 * <p>
package org.opensearch.action.admin.indices.scale.searchonly;
        );
     * @param state    the current cluster state
        scaleIndexShardSyncManager.validateNodeResponses(
    class FinalizeScaleDownTask extends ClusterStateUpdateTask {
    /**
            }
                    shard.sync();
    @Override
                } catch (IOException e) {
                    shard.waitForRemoteStoreSync();
            this.listener = listener;
}
        }
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
    }
            index,
        }
     */
     * This task:
            listener.onFailure(e);
            this.listener = listener;
        }
    @Override
import org.opensearch.index.shard.IndexShard;
            NAME,
    }
    class AddBlockClusterStateUpdateTask extends ClusterStateUpdateTask {
            ActionListener.wrap(responses -> handleShardSyncResponses(responses, index, listener), listener::onFailure)
            ScaleIndexNodeRequest::new,
                Map<ShardId, String> primaryShardsNodes = scaleIndexShardSyncManager.getPrimaryShardAssignments(indexMetadata, newState);
            request
 * and search-only modes. It manages the multistep process including:
                indexNameExpressionResolver.concreteIndexNames(state, request.indicesOptions(), request.getIndex())
            IndexMetadata indexMetadata = tempState.metadata().index(index);
            responses,
                listener.onFailure(e);
            public void onResponse(Releasable releasable) {
    private void submitScaleDownTask(final String index, final ActionListener<AcknowledgedResponse> listener) {
        }
    }
            public void onResponse(Collection<ScaleIndexShardResponse> shardResponses) {
    }
            ClusterState tempState = ClusterState.builder(currentState).routingTable(newRoutingTable).build();
     * @param allocationService           service for shard allocation decisions
        this.allocationService = allocationService;
                groupedActionListener.onFailure(new IllegalStateException("Attempting to scale down a replica shard"));
     * @param actionFilters               filters for action requests
        ChannelActionListener<ScaleIndexNodeResponse, ScaleIndexNodeRequest> listener = new ChannelActionListener<>(
    private void submitScaleUpTask(
        }
import org.opensearch.core.index.shard.ShardId;
     * This task:
        final ActionListener<AcknowledgedResponse> listener
        AddBlockClusterStateUpdateTask(
import org.opensearch.action.support.GroupedActionListener;
                return scaleIndexClusterStateBuilder.buildScaleDownState(currentState, index, blockedIndices);
 * <p>
     * @return the deserialized response
        return ThreadPool.Names.MANAGEMENT;
    }
 * Transport action implementation for search-only scale operations.
            this.index = index;
    @Inject
        } catch (Exception e) {
        }
    }
 *   <li>Validating prerequisites for scale operations</li>
     */
            primaryShardsNodes,
            ScaleIndexRequest::new,
            try {
            } else {
        clusterService.submitStateUpdateTask(
            (request, channel, task) -> handleShardSyncRequest(request, channel)
import java.util.HashMap;
                proceedWithScaleDown(index, primaryShardsNodes, listener);
    /**
        clusterService.submitStateUpdateTask("finalize-scale-down", new FinalizeScaleDownTask(index, listener));
import org.opensearch.cluster.ClusterState;
import org.opensearch.action.support.ChannelActionListener;
     *   <li>Initiates shard synchronization after the block is applied</li>
    /**
        );
        this.threadPool = threadPool;
import org.apache.logging.log4j.Logger;
        );
            listener.onFailure(e);
            @Override
     * <ul>
     * @throws IOException if an I/O error occurs
        private final ActionListener<AcknowledgedResponse> listener;
     * <p>
            logger.error("Failed to process cluster state update for scale down", e);
import org.opensearch.cluster.block.ClusterBlocks;
 * The scale operation is implemented as a series of cluster state update tasks to ensure
import org.opensearch.common.settings.Settings;
                .build();
    /**
        public ClusterState execute(final ClusterState currentState) {
        @Override
     * Handles the search-only request on the cluster manager node.
                listener.onResponse(new ScaleIndexNodeResponse(clusterService.localNode(), shardResponses.stream().toList()));
    private void handleShardSyncResponses(
                    listener.onResponse(
        }
import org.opensearch.core.common.io.stream.StreamInput;
 *   <li>Coordinating shard synchronization across nodes</li>
            actionFilters,
            new AddBlockClusterStateUpdateTask(index, blockedIndices, listener)
            }
        private final ActionListener<AcknowledgedResponse> listener;
        }
    /**
    private class ScaleUpClusterStateUpdateTask extends ClusterStateUpdateTask {
    /**
        }
     * Cluster state update task for finalizing a scale-down operation.
                submitScaleUpTask(index, state, listener);
        private final String index;
    /**
    }
            blocksBuilder.removeIndexBlockWithId(index, INDEX_SEARCH_ONLY_BLOCK_ID);
     *
 */
     *   <li>Validates that the index meets prerequisites for scaling down</li>
     * Deserializes the response from stream.
        transportService.registerRequestHandler(
        IndexNameExpressionResolver indexNameExpressionResolver,
public class TransportScaleIndexAction extends TransportClusterManagerNodeAction<ScaleIndexRequest, AcknowledgedResponse> {
    private void finalizeScaleDown(String index, ActionListener<AcknowledgedResponse> listener) {
 *
     * @param clusterService              the cluster service for accessing cluster state
 */
     * @param indexNameExpressionResolver resolver for index names and expressions
        }
    /**
        AllocationService allocationService,
        ) {
        }
import org.opensearch.cluster.metadata.Metadata;
     * @return the executor name
                return currentState;
     *   <li>Updates index settings to disable search-only mode</li>
import org.opensearch.action.support.ActionFilters;
     * Submits the scale-up update task that rebuilds the routing table and updates index metadata.
            transportService,
            "sync_shard",
    }
            ThreadPool.Names.SAME,
        @Override
     * <p>
            ClusterBlocks.Builder blocksBuilder = ClusterBlocks.builder().blocks(tempState.blocks());
        if (!validator.validateScalePrerequisites(indexMetadata, index, listener, false)) {
     */
import org.opensearch.common.unit.TimeValue;
     */
        clusterService.submitStateUpdateTask("scale-up-index", new ScaleUpClusterStateUpdateTask(index, listener));
     *   <li>Adds a temporary write block to prevent new operations during scaling</li>
import org.opensearch.cluster.ClusterStateUpdateTask;
        public ClusterState execute(ClusterState currentState) {
    /**
    ) {
        return new AcknowledgedResponse(in);
        );
                ClusterBlockLevel.METADATA_WRITE,
    ) {
import java.io.IOException;
                    shard.flush(new FlushRequest().force(true).waitIfOngoing(true));
        @Override
        return state.blocks()
     */
        Collection<ScaleIndexNodeResponse> responses,
            IndexShard shard = indexService.getShardOrNull(shardId.id());
import org.opensearch.common.lease.Releasable;
        ScaleUpClusterStateUpdateTask(String index, ActionListener<AcknowledgedResponse> listener) {
 * The OpenSearch Contributors require contributions made to
        syncShards(indexService, request.getShardIds(), listener);
                }
     *   <li>Updates the routing table to remove non-search-only shards</li>
                listener.onFailure(e);
        IndicesService indicesService
    protected void clusterManagerOperation(ScaleIndexRequest request, ClusterState state, ActionListener<AcknowledgedResponse> listener) {
import org.opensearch.cluster.routing.RoutingTable;
    ) {
                logger.info("Performing final sync and flush for shard {}", shard.shardId());
        IndexMetadata indexMetadata = state.metadata().index(request.getIndex());
        String index,
     *
        ClusterService clusterService,
        IndexService indexService = indicesService.indexService(indexMetadata.getIndex());
            }
            super(Priority.URGENT);
            logger.error("Failed to finalize scale-down operation", e);
     * </ul>
    /**
        final Map<Index, ClusterBlock> blockedIndices = new HashMap<>();
        FinalizeScaleDownTask(String index, ActionListener<AcknowledgedResponse> listener) {
            }
        ActionFilters actionFilters,
import org.opensearch.cluster.block.ClusterBlockLevel;
    }
