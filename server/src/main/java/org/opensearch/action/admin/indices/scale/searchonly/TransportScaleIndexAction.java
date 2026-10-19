     * <ul>
            ScaleIndexRequest::new,
            metadataBuilder.put(
            }
     *   <li>Initiates shard synchronization after the block is applied</li>
import org.opensearch.cluster.routing.allocation.AllocationService;
            );
                submitScaleUpTask(index, state, listener);
        if (indexService == null) {  
     *
            }
     * This task:
    }
    }  
            ThreadPool.Names.SAME,
    @Override  
        }
    public TransportScaleIndexAction(
     * @param actionFilters               filters for action requests
     */  
import org.opensearch.common.settings.Settings;  
        ActionListener<AcknowledgedResponse> listener  
        ChannelActionListener<ScaleIndexNodeResponse, ScaleIndexNodeRequest> listener = new ChannelActionListener<>(
    protected String executor() {
     * This task:
        private final String index;
            blocksBuilder.removeIndexBlockWithId(index, INDEX_SEARCH_ONLY_BLOCK_ID);
    }
            @Override
            "add-block-index-to-scale " + index,
     * @param request  the search-only scale request
    @Override  
            public void onFailure(Exception e) {  
            this.listener = listener;
                        new ScaleIndexShardResponse(shard.shardId(), shard.isSyncNeeded(), shard.translogStats().getUncommittedOperations())
     * @param listener the listener to notify with the operation result
    void handleShardSyncRequest(ScaleIndexNodeRequest request, TransportChannel channel) {
    private IndexService getIndexService(IndexMetadata indexMetadata) {
                    );
import java.util.List;
 * <ul>
        public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
 * atomicity and consistency throughout the transition.
            }  
        }
            logger.error("Failed to execute cluster state update for scale up", e);
    }
        private final ActionListener<AcknowledgedResponse> listener;
        IndexMetadata indexMetadata = state.metadata().index(request.getIndex());
            IndexMetadata indexMetadata = tempState.metadata().index(index);  
        }
     *   <li>Removes the temporary scale-down preparation block</li>
    @Inject  
            this.listener = listener;  
        }, TimeValue.timeValueSeconds(30));  
    /**  
        }
        }
     * Submits the scale-up update task that rebuilds the routing table and updates index metadata.
    /**
            } catch (Exception e) {  
    /**  
            throw new IllegalStateException("Index " + request.getIndex() + " not found");  
import org.opensearch.transport.TransportService;
        @Override
 * this file be licensed under the Apache-2.0 license or a
     * <p>
                listener.onResponse(new AcknowledgedResponse(true));
        ActionFilters actionFilters,
    }
import org.opensearch.cluster.block.ClusterBlockException;  
        super(
            IndexMetadata indexMetadata = currentState.metadata().index(index);
        return state.blocks()  
     * Deserializes the response from stream.  
            );
            }
    private final ScaleIndexShardSyncManager scaleIndexShardSyncManager;
    /**
        this.indicesService = indicesService;
    private final AllocationService allocationService;
                proceedWithScaleDown(index, primaryShardsNodes, listener);  
            public void onResponse(Collection<ScaleIndexShardResponse> shardResponses) {
        IndexService indexService = indicesService.indexService(indexMetadata.getIndex());
import org.opensearch.threadpool.ThreadPool;  
     *  
        );
        return ThreadPool.Names.MANAGEMENT;
        private final String index;  
        }  
import java.util.Map;
    private final IndicesService indicesService;  
        ) {
        @Override
            logger.error("Failed to execute cluster manager operation", e);
        if (indexMetadata == null) {
            threadPool.executor(SHARD_SYNC_EXECUTOR).execute(() -> { syncSingleShard(shard, groupedActionListener); });
        private final String index;
            IndexShard shard = indexService.getShardOrNull(shardId.id());  
    ) {
 *   <li>Adding temporary write blocks during scale-down preparation</li>
            listener.onFailure(e);  
        IndexService indexService = getIndexService(indexMetadata);  
     *   <li>Validates that the index meets prerequisites for scaling down</li>  
        ScaleUpClusterStateUpdateTask(String index, ActionListener<AcknowledgedResponse> listener) {
            listener.onFailure(e);
            index,  
        );  
            throw new IllegalStateException("IndexService not found for index " + indexMetadata.getIndex().getName());
            listener.onFailure(e);
        }  
                indexNameExpressionResolver.concreteIndexNames(state, request.indicesOptions(), request.getIndex())  
            ClusterState tempState = ClusterState.builder(currentState).routingTable(newRoutingTable).build();  
            (request, channel, task) -> handleShardSyncRequest(request, channel)  
    /**
        Collection<ScaleIndexNodeResponse> responses,
        ClusterService clusterService,  
     *   <li>Removes the search-only block</li>
            Settings updatedSettings = Settings.builder()
     *  
            Map<Index, ClusterBlock> blockedIndices,  
            if (request.isScaleDown()) {
            listener.onResponse(new AcknowledgedResponse(true));  
            actionFilters,  
            }  
        public void onFailure(String source, Exception e) {
        AllocationService allocationService,
                return currentState;
    protected AcknowledgedResponse read(StreamInput in) throws IOException {
            primaryShardsNodes,
    }
    }
        }, shardIds.size());  
     * @throws IOException if an I/O error occurs
    /**
 * <p>  
 *   <li>Validating prerequisites for scale operations</li>  
import org.apache.logging.log4j.Logger;
            super(Priority.URGENT);  
import org.opensearch.cluster.metadata.IndexMetadata;  
            this.index = index;
     */
    }
     * <p>  
        this.validator = new ScaleIndexOperationValidator();
     */  
    private void submitScaleUpTask(  
     * Returns the executor name for this transport action.
 * </ul>
     * Handles the search-only request on the cluster manager node.  
    @Override
    private class ScaleUpClusterStateUpdateTask extends ClusterStateUpdateTask {  
            threadPool,
    }
import org.opensearch.action.support.GroupedActionListener;  
import org.opensearch.core.common.io.stream.StreamInput;  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
    }
                groupedActionListener.onFailure(new IllegalStateException("Attempting to scale down a replica shard"));
        scaleIndexShardSyncManager.sendShardSyncRequests(
            public void onFailure(Exception e) {  
                listener.onFailure(e);
            return;
            Metadata.Builder metadataBuilder = Metadata.builder(tempState.metadata());  
            this.index = index;
    }  
        ClusterState state = clusterService.state();
        public void onFailure(String source, Exception e) {
    /**
    private void finalizeScaleDown(String index, ActionListener<AcknowledgedResponse> listener) {  
    }
    protected void clusterManagerOperation(ScaleIndexRequest request, ClusterState state, ActionListener<AcknowledgedResponse> listener) {
     * </ul>
 * compatible open source license.
 * This class coordinates the entire process of scaling indices up or down between normal  
 */  
    private void handleShardSyncResponses(  
    /**
 * The OpenSearch Contributors require contributions made to  
    ) {
            logger.error("Failed to process cluster state update for scale down", e);  
        final String index,
        final ActionListener<AcknowledgedResponse> listener  
    public static final String NAME = ScaleIndexAction.NAME + "[s]";
        return new AcknowledgedResponse(in);
     */
    /**
import org.opensearch.cluster.metadata.Metadata;
     */  
                    shard.waitForRemoteStoreSync();
     *   <li>Triggers routing table updates to allocate the new shards</li>  
     * Cluster state update task for scaling up an index from search-only mode to normal operation.
            "sync_shard",  
        String index,
            logger.error("Failed to finalize scale-down operation", e);
            this.index = index;
/*  
    @Override  
        private final ActionListener<AcknowledgedResponse> listener;  
            indexNameExpressionResolver
     */
     * @return the executor name
import java.util.HashMap;  
                submitScaleDownTask(index, listener);
 *   <li>Coordinating shard synchronization across nodes</li>
    private final ScaleIndexOperationValidator validator;  
            try {  
 *   <li>Modifying cluster state to transition indices between modes</li>  
import org.opensearch.common.inject.Inject;
     * </ul>
    }  
                ClusterBlockLevel.METADATA_WRITE,
     * @param clusterService              the cluster service for accessing cluster state
        if (!validator.validateScalePrerequisites(indexMetadata, index, listener, false)) {  
        IndicesService indicesService
            clusterService,
import org.opensearch.action.support.ActionFilters;
        );  
/**  
        }  
            ClusterBlocks.Builder blocksBuilder = ClusterBlocks.builder().blocks(tempState.blocks());
            this.blockedIndices = blockedIndices;
     * removes the temporary block and adds a permanent search-only block.
    ) {  
        ThreadPool threadPool,
        final Map<Index, ClusterBlock> blockedIndices = new HashMap<>();
     *   <li>Updates the routing table to remove non-search-only shards</li>
     * <p>  
     * <ul>
    }
            String index = request.getIndex();  
 * Transport action implementation for search-only scale operations.
     * Handles an incoming shard sync request from another node.
            ScaleIndexAction.NAME,
import org.opensearch.cluster.ClusterStateUpdateTask;
            return scaleIndexClusterStateBuilder.buildFinalScaleDownState(currentState, index);
            ActionListener.wrap(searchOnlyResponse -> finalizeScaleDown(index, listener), listener::onFailure)
            }
            ActionListener.wrap(responses -> handleShardSyncResponses(responses, index, listener), listener::onFailure)
                try {
    private void submitScaleDownTask(final String index, final ActionListener<AcknowledgedResponse> listener) {  
     *   <li>Updates index metadata to mark it as search-only</li>
     */
            ActionListener<AcknowledgedResponse> listener
        }  
    private final ThreadPool threadPool;
import org.opensearch.common.lease.Releasable;
            listener.onFailure(e);
     */
                    shard.flush(new FlushRequest().force(true).waitIfOngoing(true));
        public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
import org.opensearch.index.IndexService;  
import org.opensearch.common.unit.TimeValue;
        );
        for (ShardId shardId : shardIds) {
        IndexNameExpressionResolver indexNameExpressionResolver,  
        this.threadPool = threadPool;  
    /**
        }
        clusterService.submitStateUpdateTask("finalize-scale-down", new FinalizeScaleDownTask(index, listener));
            IndexMetadata indexMetadata = newState.metadata().index(index);  
import org.opensearch.cluster.block.ClusterBlocks;
     * Cluster state update task for adding a temporary block during the initial phase of scaling down.
    protected ClusterBlockException checkBlock(ScaleIndexRequest request, ClusterState state) {
        public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {  
     *   <li>Rebuilds the routing table to add primary and replica shards</li>  
     * @return the deserialized response  
        @Override
     *   <li>Applies a permanent search-only block</li>  
public class TransportScaleIndexAction extends TransportClusterManagerNodeAction<ScaleIndexRequest, AcknowledgedResponse> {
import org.opensearch.index.shard.IndexShard;
        }  
                }
                logger.info("Performing final sync and flush for shard {}", shard.shardId());
    private static final Logger logger = LogManager.getLogger(TransportScaleIndexAction.class);  
        @Override
     * @param threadPool                  the thread pool for executing operations  
                .put(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), false)  
}  
            @Override
            if (shard == null || shard.routingEntry().primary() == false) {
     */
        );
                } catch (IOException e) {  
        clusterService.submitStateUpdateTask(  
    }
        scaleIndexShardSyncManager.validateNodeResponses(
     *   <li>Adds a temporary write block to prevent new operations during scaling</li>
                ClusterState.builder(tempState).blocks(blocksBuilder).metadata(metadataBuilder).build(),
                break;  
        @Override  
    class FinalizeScaleDownTask extends ClusterStateUpdateTask {
        this.allocationService = allocationService;
import org.opensearch.cluster.block.ClusterBlockLevel;
     * @param indicesService              service for accessing index shards
import org.opensearch.cluster.block.ClusterBlock;
        public ClusterState execute(final ClusterState currentState) {
        String index,
        try {
            transportService,  
        return indexService;  
                Map<ShardId, String> primaryShardsNodes = scaleIndexShardSyncManager.getPrimaryShardAssignments(indexMetadata, newState);
            }
            super(Priority.URGENT);  
 *
            channel,
    public static final String SHARD_SYNC_EXECUTOR = ThreadPool.Names.MANAGEMENT;  
     */
import org.opensearch.action.support.ChannelActionListener;
     * @param allocationService           service for shard allocation decisions  
            @Override  
            responses,  
     */
     * @param transportService            the transport service for network communication
    private final ScaleIndexClusterStateBuilder scaleIndexClusterStateBuilder;
            @Override
     * based on the request parameters, and submits the appropriate cluster state update task.  
 * SPDX-License-Identifier: Apache-2.0
     * @param state    the current cluster state  
     * Cluster state update task for finalizing a scale-down operation.  
        public void onFailure(String source, Exception e) {  
            ScaleIndexNodeRequest::new,
                IndexMetadata.builder(indexMetadata).settings(updatedSettings).settingsVersion(indexMetadata.getSettingsVersion() + 1)  
                .put(indexMetadata.getSettings())
     * <p>
     * Finalizes scale-down by updating the metadata and routing table:  
import org.opensearch.core.index.Index;
            return allocationService.reroute(  
 */  
import org.opensearch.indices.IndicesService;
        GroupedActionListener<ScaleIndexShardResponse> groupedActionListener = new GroupedActionListener<>(new ActionListener<>() {
            }
            new AddBlockClusterStateUpdateTask(index, blockedIndices, listener)
package org.opensearch.action.admin.indices.scale.searchonly;
                listener.onFailure(e);
    }
                    listener.onResponse(  
            .indicesBlockedException(
import org.opensearch.core.action.ActionListener;
        IndexMetadata indexMetadata = currentState.metadata().index(index);
        }
                return scaleIndexClusterStateBuilder.buildScaleDownState(currentState, index, blockedIndices);
import org.opensearch.transport.TransportChannel;
                    listener.onFailure(e);
        }  
     */
        private final Map<Index, ClusterBlock> blockedIndices;
        }
                .build();
            public void onResponse(Releasable releasable) {  
        syncShards(indexService, request.getShardIds(), listener);
            );  
     */
    private void syncShards(IndexService indexService, List<ShardId> shardIds, ActionListener<ScaleIndexNodeResponse> listener) {  
        shard.acquireAllPrimaryOperationsPermits(new ActionListener<>() {
        clusterService.submitStateUpdateTask("scale-up-index", new ScaleUpClusterStateUpdateTask(index, listener));
 * The scale operation is implemented as a series of cluster state update tasks to ensure
            RoutingTable newRoutingTable = scaleIndexClusterStateBuilder.buildScaleUpRoutingTable(currentState, index);
        this.scaleIndexClusterStateBuilder = new ScaleIndexClusterStateBuilder();
                return;  
    /**
        public ClusterState execute(ClusterState currentState) {  
            if (oldState == newState) {
import org.apache.logging.log4j.LogManager;
        FinalizeScaleDownTask(String index, ActionListener<AcknowledgedResponse> listener) {
        public ClusterState execute(ClusterState currentState) {
import org.opensearch.cluster.ClusterState;  
        }
        this.scaleIndexShardSyncManager = new ScaleIndexShardSyncManager(clusterService, transportService, NAME);  
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.core.index.shard.ShardId;
        private final ActionListener<AcknowledgedResponse> listener;
import org.opensearch.common.Priority;  
            } else {  
                    shard.sync();  
import org.opensearch.cluster.routing.RoutingTable;  
     * @param in the stream input
    }  
        final ClusterState currentState,
        }
    void syncSingleShard(IndexShard shard, ActionListener<ScaleIndexShardResponse> listener) {  
import java.io.IOException;
     *
import java.util.Collection;
            if (indexMetadata != null) {
        @Override  
     * Constructs a new TransportSearchOnlyAction.
                validator.validateScalePrerequisites(indexMetadata, index, listener, true);
            request
        @Override
        transportService.registerRequestHandler(
    class AddBlockClusterStateUpdateTask extends ClusterStateUpdateTask {
     * This task:
     * @param indexNameExpressionResolver resolver for index names and expressions
    /**
     * Sends shard sync requests to each node that holds a primary shard.
        Map<ShardId, String> primaryShardsNodes,
    private void proceedWithScaleDown(  
     * <ul>  
     * This method determines whether to execute a scale-up or scale-down operation
                "restore indexing shards"
        ActionListener<AcknowledgedResponse> listener  
        }
        } catch (Exception e) {  
        @Override  
     * </ul>  
    /**  
            NAME,  
            String index,
        TransportService transportService,
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
            this.listener = listener;  
     * Transport action name for shard sync requests
        AddBlockClusterStateUpdateTask(
 *   <li>Handling synchronization requests from other nodes</li>
    ) {
 * and search-only modes. It manages the multistep process including:
            }
 * <p>
            listener.onResponse(new AcknowledgedResponse(true));
        );  
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_SEARCH_ONLY_BLOCK_ID;
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
     *   <li>Updates index settings to disable search-only mode</li>
                listener.onResponse(new ScaleIndexNodeResponse(clusterService.localNode(), shardResponses.stream().toList()));
        @Override  
     * Submits the scale-down update task: it first adds a temporary block to the indices and then initiates shard synchronization.
import org.opensearch.action.admin.indices.flush.FlushRequest;  
