    }
import org.opensearch.transport.TransportService;
                ResumeIngestionResponse response = new ResumeIngestionResponse(  
                "resume-ingestion",
    private ResolvedIndices.Local.Concrete resolveIndices(ClusterState state, ResumeIngestionRequest request) {  
    private static final Logger logger = LogManager.getLogger(TransportResumeIngestionAction.class);
import java.io.IOException;
import org.opensearch.core.index.Index;
                updateIngestionStateRequest,
        return new ResumeIngestionResponse(in);  
    }
import org.opensearch.core.common.io.stream.StreamInput;
    }
import org.opensearch.tasks.Task;  
        throw new UnsupportedOperationException("The task parameter is required");  
                stateUpdateListener
        return updateIngestionStateRequest;  
    }
    protected String executor() {  
                logger.debug("Error resuming ingestion", e);
import org.opensearch.action.support.ActionFilters;  
    protected ResumeIngestionResponse read(StreamInput in) throws IOException {
        this.ingestionStateService = ingestionStateService;
    ) {
 * SPDX-License-Identifier: Apache-2.0
        final ClusterState state,
import org.opensearch.action.admin.indices.streamingingestion.state.UpdateIngestionStateResponse;
import org.apache.logging.log4j.Logger;
    @Override
/*  
import org.opensearch.cluster.block.ClusterBlockLevel;  
    @Override  
                resumeIngestionRequest,
import org.opensearch.cluster.service.ClusterService;
            }
        ClusterService clusterService,  
            );  
        ThreadPool threadPool,
 * The OpenSearch Contributors require contributions made to  
    @Override  
        int[] shards = Arrays.stream(request.getResetSettings()).mapToInt(ResumeIngestionRequest.ResetSettings::getShard).toArray();
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
import org.opensearch.cluster.ClusterState;
        final ResumeIngestionRequest request,  
        }
    }
import org.opensearch.action.admin.indices.streamingingestion.IngestionStateShardFailure;  
        final ActionListener<ResumeIngestionResponse> listener
            transportService,  
                    shardsAcked,
    protected void doExecute(Task task, ResumeIngestionRequest request, ActionListener<ResumeIngestionResponse> listener) {
import org.opensearch.cluster.block.ClusterBlockException;
 *  
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;  
package org.opensearch.action.admin.indices.streamingingestion.resume;
        updateIngestionStateRequest.setResetSettings(request.getResetSettings());
    protected void clusterManagerOperation(
            public void onFailure(Exception e) {
        updateIngestionStateRequest.timeout(request.clusterManagerNodeTimeout());  
    }
            UpdateIngestionStateRequest resumeIngestionRequest = getIngestionResumeRequest(indices, request);
    ) throws Exception {  
            UpdateIngestionStateRequest shardPointerUpdateRequest = getShardPointerUpdateRequest(indices, request);
                boolean shardsAcked = updateIngestionStateResponse.isAcknowledged() && updateIngestionStateResponse.getFailedShards() == 0;
    protected void clusterManagerOperation(
 *
        updateIngestionStateRequest.timeout(request.clusterManagerNodeTimeout());
                listener.onFailure(e);  
            // resume ingestion
        TransportIndicesResolvingAction<ResumeIngestionRequest> {
    protected ClusterBlockException checkBlock(ResumeIngestionRequest request, ClusterState state) {
import org.opensearch.cluster.metadata.MetadataStreamingIngestionStateService;
        final Index[] concreteIndices = resolveIndices(state, request).concreteIndicesAsArray();
import org.opensearch.common.inject.Inject;
                concreteIndices,
        ActionFilters actionFilters,  
        updateIngestionStateRequest.setIngestionPaused(false);
            threadPool,
 * Transport action to resume ingestion.
        destructiveOperations.failDestructive(request.indices());
        DestructiveOperations destructiveOperations
            ResumeIngestionRequest::new,
    }
            ResumeIngestionAction.NAME,
        this.destructiveOperations = destructiveOperations;
            @Override  
                shardPointerUpdateRequest,  
import java.util.Arrays;
    public ResolvedIndices resolveIndices(ResumeIngestionRequest request) {
    private UpdateIngestionStateRequest getShardPointerUpdateRequest(String[] indices, ResumeIngestionRequest request) {
        TransportService transportService,
    private final DestructiveOperations destructiveOperations;
    @Override  
    }
        String[] indices = Arrays.stream(concreteIndices).map(Index::getName).toArray(String[]::new);
import org.apache.logging.log4j.LogManager;
        final Task task,
                    updateIngestionStateResponse.getShardFailureList(),  
    }
import org.opensearch.action.support.DestructiveOperations;
            indexNameExpressionResolver
import org.opensearch.cluster.metadata.ResolvedIndices;  
            }
            return;
        final ResumeIngestionRequest request,
/**
        );  
public class TransportResumeIngestionAction extends TransportClusterManagerNodeAction<ResumeIngestionRequest, ResumeIngestionResponse>  
        if (concreteIndices == null || concreteIndices.length == 0) {
                concreteIndices,  
 * compatible open source license.
        MetadataStreamingIngestionStateService ingestionStateService,
            );  
    private final MetadataStreamingIngestionStateService ingestionStateService;  
 * @opensearch.api
            clusterService,
                    updateIngestionStateResponse.getErrorMessage()
            ingestionStateService.updateIngestionPollerState(
            ingestionStateService.resetShardPointerAndResumeIngestion(  
    public TransportResumeIngestionAction(
 */  
                );
        return indexNameExpressionResolver.concreteResolvedIndices(state, request);
            UpdateIngestionStateRequest updateIngestionStateRequest = getIngestionResumeRequest(indices, request);  
        IndexNameExpressionResolver indexNameExpressionResolver,
        super.doExecute(task, request, listener);  
            .indicesBlockedException(ClusterBlockLevel.METADATA_WRITE, indexNameExpressionResolver.concreteIndexNames(state, request));  
    ) {  
                "resume-ingestion",
        } else {
import org.opensearch.threadpool.ThreadPool;
        return state.blocks()
            public void onResponse(UpdateIngestionStateResponse updateIngestionStateResponse) {
        super(
            @Override  
 */
            // reset consumer and resume ingestion  
import org.opensearch.core.action.ActionListener;  
    @Override
        final ClusterState state,  
                    true,
import org.opensearch.action.admin.indices.streamingingestion.state.UpdateIngestionStateRequest;
        UpdateIngestionStateRequest updateIngestionStateRequest = new UpdateIngestionStateRequest(indices, shards);  
    implements
import org.opensearch.action.support.TransportIndicesResolvingAction;
        };
        return ResolvedIndices.of(resolveIndices(clusterService.state(), request));  
        return updateIngestionStateRequest;
    }  
    }
        final ActionListener<ResumeIngestionResponse> listener
 * this file be licensed under the Apache-2.0 license or a
                listener.onResponse(response);  
        UpdateIngestionStateRequest updateIngestionStateRequest = new UpdateIngestionStateRequest(indices, new int[0]);
    @Inject  
        if (request.getResetSettings() != null && request.getResetSettings().length > 0) {
    private UpdateIngestionStateRequest getIngestionResumeRequest(String[] indices, ResumeIngestionRequest request) {
        return ThreadPool.Names.SAME;
            listener.onResponse(new ResumeIngestionResponse(true, false, new IngestionStateShardFailure[0], ""));  
    @Override  
                stateUpdateListener
    @Override
        }
        ActionListener<UpdateIngestionStateResponse> stateUpdateListener = new ActionListener<>() {
            actionFilters,  
}
