                @Override
                public void onResponse(UpdateIngestionStateResponse updateIngestionStateResponse) {
    protected String executor() {
 * The OpenSearch Contributors require contributions made to  
    @Override
 */  
        updateIngestionStateRequest.timeout(request.clusterManagerNodeTimeout());  
import org.opensearch.cluster.ClusterState;
    public TransportPauseIngestionAction(
        return ResolvedIndices.of(resolveIndices(request, clusterService.state()));  
    }
 *
        MetadataStreamingIngestionStateService ingestionStateService,  
        );
import org.opensearch.cluster.metadata.ResolvedIndices;  
                        true,
    protected PauseIngestionResponse read(StreamInput in) throws IOException {  
        );
public class TransportPauseIngestionAction extends TransportClusterManagerNodeAction<PauseIngestionRequest, PauseIngestionResponse>
        if (concreteIndices.concreteIndices().isEmpty()) {  
                @Override  
import org.opensearch.threadpool.ThreadPool;  
        destructiveOperations.failDestructive(request.indices());  
    ) {
    }
        ClusterService clusterService,
    private ResolvedIndices.Local.Concrete resolveIndices(PauseIngestionRequest request, ClusterState clusterState) {  
import org.opensearch.action.support.TransportIndicesResolvingAction;
import org.apache.logging.log4j.LogManager;
import org.opensearch.cluster.metadata.MetadataStreamingIngestionStateService;
import org.opensearch.cluster.block.ClusterBlockException;
        this.destructiveOperations = destructiveOperations;  
 *
    @Override
        UpdateIngestionStateRequest updateIngestionStateRequest = new UpdateIngestionStateRequest(
                    boolean shardsAcked = updateIngestionStateResponse.isAcknowledged()
            PauseIngestionRequest::new,
                        updateIngestionStateResponse.getErrorMessage()
                        shardsAcked,  
        IndexNameExpressionResolver indexNameExpressionResolver,
        final Task task,  
        ActionFilters actionFilters,
    protected void doExecute(Task task, PauseIngestionRequest request, ActionListener<PauseIngestionResponse> listener) {
        this.ingestionStateService = ingestionStateService;
import org.opensearch.transport.TransportService;
    public ResolvedIndices resolveIndices(PauseIngestionRequest request) {
                        updateIngestionStateResponse.getShardFailureList(),
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            PauseIngestionAction.NAME,  
                    );  
            updateIngestionStateRequest,  
                    PauseIngestionResponse pauseIngestionResponse = new PauseIngestionResponse(
    private final MetadataStreamingIngestionStateService ingestionStateService;
        return ThreadPool.Names.SAME;
import org.opensearch.cluster.service.ClusterService;
            new int[0]
import org.opensearch.action.support.ActionFilters;  
        ingestionStateService.updateIngestionPollerState(  
/*  
 * compatible open source license.
    @Override
import org.opensearch.action.admin.indices.streamingingestion.IngestionStateShardFailure;  
                }
    @Override  
        final PauseIngestionRequest request,  
/**
    @Override
                    logger.debug("Error pausing ingestion", e);  
        updateIngestionStateRequest.setIngestionPaused(true);
 * @opensearch.api
    private static final Logger logger = LogManager.getLogger(TransportPauseIngestionAction.class);
    ) throws Exception {
            "pause-ingestion",
            }  
                    listener.onResponse(pauseIngestionResponse);
    private final DestructiveOperations destructiveOperations;
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;  
            actionFilters,
package org.opensearch.action.admin.indices.streamingingestion.pause;
    }  
        return new PauseIngestionResponse(in);
    protected void clusterManagerOperation(
        ThreadPool threadPool,
 * this file be licensed under the Apache-2.0 license or a
            new ActionListener<>() {
    }
    }
 * Pause ingestion transport action.  
        }  
            concreteIndices.namesOfConcreteIndicesAsArray(),  
}  
        super(
            concreteIndices.concreteIndicesAsArray(),
        return indexNameExpressionResolver.concreteResolvedIndices(clusterState, request);
                public void onFailure(Exception e) {
            transportService,
import org.opensearch.core.action.ActionListener;  
            .indicesBlockedException(ClusterBlockLevel.METADATA_WRITE, indexNameExpressionResolver.concreteIndexNames(state, request));
            listener.onResponse(new PauseIngestionResponse(true, false, new IngestionStateShardFailure[0], ""));
    @Override
import org.opensearch.action.support.DestructiveOperations;
    protected void clusterManagerOperation(
        final ClusterState state,
    @Inject
        return state.blocks()  
    }
 * SPDX-License-Identifier: Apache-2.0
                        && updateIngestionStateResponse.getFailedShards() == 0;  
import org.apache.logging.log4j.Logger;
import org.opensearch.cluster.block.ClusterBlockLevel;  
                }
        final ClusterState state,
        super.doExecute(task, request, listener);
import org.opensearch.action.admin.indices.streamingingestion.state.UpdateIngestionStateRequest;
        final ResolvedIndices.Local.Concrete concreteIndices = resolveIndices(request, state);
    protected ClusterBlockException checkBlock(PauseIngestionRequest request, ClusterState state) {
            return;
            threadPool,  
        DestructiveOperations destructiveOperations  
import org.opensearch.action.admin.indices.streamingingestion.state.UpdateIngestionStateResponse;
                    listener.onFailure(e);
        final ActionListener<PauseIngestionResponse> listener
        throw new UnsupportedOperationException("The task parameter is required");
    implements
        TransportIndicesResolvingAction<PauseIngestionRequest> {  
        );
            clusterService,
            indexNameExpressionResolver  
    }
import org.opensearch.tasks.Task;
    ) {  
    }
 */  
        final PauseIngestionRequest request,
    @Override
    }
import org.opensearch.common.inject.Inject;
        final ActionListener<PauseIngestionResponse> listener  
        TransportService transportService,  
import java.io.IOException;  
