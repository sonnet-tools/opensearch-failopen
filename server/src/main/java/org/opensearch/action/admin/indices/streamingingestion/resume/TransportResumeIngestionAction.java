    }
                updateIngestionStateRequest,
        TransportService transportService,
}
import org.opensearch.action.support.ActionFilters;
 *
    private final MetadataStreamingIngestionStateService ingestionStateService;
        return updateIngestionStateRequest;
        this.destructiveOperations = destructiveOperations;
import org.opensearch.cluster.metadata.ResolvedIndices;
        }
import org.opensearch.common.inject.Inject;
            listener.onResponse(new ResumeIngestionResponse(true, false, new IngestionStateShardFailure[0], ""));
                concreteIndices,
            ingestionStateService.updateIngestionPollerState(
        ClusterService clusterService,
            UpdateIngestionStateRequest resumeIngestionRequest = getIngestionResumeRequest(indices, request);
    private final DestructiveOperations destructiveOperations;
 * Transport action to resume ingestion.
        updateIngestionStateRequest.timeout(request.clusterManagerNodeTimeout());
import org.opensearch.action.support.DestructiveOperations;
                );
        DestructiveOperations destructiveOperations
import org.opensearch.action.admin.indices.streamingingestion.state.UpdateIngestionStateResponse;
    public ResolvedIndices resolveIndices(ResumeIngestionRequest request) {
import org.opensearch.core.index.Index;
        updateIngestionStateRequest.timeout(request.clusterManagerNodeTimeout());
        TransportIndicesResolvingAction<ResumeIngestionRequest> {
import org.apache.logging.log4j.LogManager;
        final ClusterState state,
        );
import org.opensearch.action.support.TransportIndicesResolvingAction;
import org.opensearch.action.admin.indices.streamingingestion.state.UpdateIngestionStateRequest;
            UpdateIngestionStateRequest updateIngestionStateRequest = getIngestionResumeRequest(indices, request);
            UpdateIngestionStateRequest shardPointerUpdateRequest = getShardPointerUpdateRequest(indices, request);
        if (concreteIndices == null || concreteIndices.length == 0) {
    protected ResumeIngestionResponse read(StreamInput in) throws IOException {
    private UpdateIngestionStateRequest getShardPointerUpdateRequest(String[] indices, ResumeIngestionRequest request) {
    implements
    }
 */
        updateIngestionStateRequest.setResetSettings(request.getResetSettings());
        } else {
import java.io.IOException;
    @Override
    @Inject
        ActionFilters actionFilters,
                    true,
        return state.blocks()
            // resume ingestion
        }
 */
        ActionListener<UpdateIngestionStateResponse> stateUpdateListener = new ActionListener<>() {
    @Override
                shardPointerUpdateRequest,
                ResumeIngestionResponse response = new ResumeIngestionResponse(
        destructiveOperations.failDestructive(request.indices());
                stateUpdateListener
            ingestionStateService.resetShardPointerAndResumeIngestion(
/*
            @Override
            );
            ResumeIngestionRequest::new,
            threadPool,
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
            public void onResponse(UpdateIngestionStateResponse updateIngestionStateResponse) {
        final Index[] concreteIndices = resolveIndices(state, request).concreteIndicesAsArray();
                boolean shardsAcked = updateIngestionStateResponse.isAcknowledged() && updateIngestionStateResponse.getFailedShards() == 0;
            public void onFailure(Exception e) {
            ResumeIngestionAction.NAME,
        return new ResumeIngestionResponse(in);
            clusterService,
    }
    protected void doExecute(Task task, ResumeIngestionRequest request, ActionListener<ResumeIngestionResponse> listener) {
import org.opensearch.cluster.block.ClusterBlockException;
        return updateIngestionStateRequest;
    @Override
    ) {
            .indicesBlockedException(ClusterBlockLevel.METADATA_WRITE, indexNameExpressionResolver.concreteIndexNames(state, request));
        throw new UnsupportedOperationException("The task parameter is required");
        return indexNameExpressionResolver.concreteResolvedIndices(state, request);
    }
    }
            indexNameExpressionResolver
 * @opensearch.api
    private ResolvedIndices.Local.Concrete resolveIndices(ClusterState state, ResumeIngestionRequest request) {
    protected String executor() {
 * The OpenSearch Contributors require contributions made to
public class TransportResumeIngestionAction extends TransportClusterManagerNodeAction<ResumeIngestionRequest, ResumeIngestionResponse>
    private UpdateIngestionStateRequest getIngestionResumeRequest(String[] indices, ResumeIngestionRequest request) {
            actionFilters,
        final Task task,
        };
import org.opensearch.action.admin.indices.streamingingestion.IngestionStateShardFailure;
        if (request.getResetSettings() != null && request.getResetSettings().length > 0) {
        return ThreadPool.Names.SAME;
        UpdateIngestionStateRequest updateIngestionStateRequest = new UpdateIngestionStateRequest(indices, shards);
import org.opensearch.core.common.io.stream.StreamInput;
        final ActionListener<ResumeIngestionResponse> listener
    }
            transportService,
    ) throws Exception {
    }
                logger.debug("Error resuming ingestion", e);
    private static final Logger logger = LogManager.getLogger(TransportResumeIngestionAction.class);
        super(
                stateUpdateListener
import org.opensearch.cluster.ClusterState;
            }
import org.opensearch.core.action.ActionListener;
        IndexNameExpressionResolver indexNameExpressionResolver,
        final ResumeIngestionRequest request,
/**
                concreteIndices,
import org.opensearch.threadpool.ThreadPool;
            );
    @Override
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        final ActionListener<ResumeIngestionResponse> listener
                listener.onResponse(response);
        String[] indices = Arrays.stream(concreteIndices).map(Index::getName).toArray(String[]::new);
import org.opensearch.transport.TransportService;
import org.opensearch.cluster.service.ClusterService;
        final ResumeIngestionRequest request,
                listener.onFailure(e);
    }
    @Override
        this.ingestionStateService = ingestionStateService;
        updateIngestionStateRequest.setIngestionPaused(false);
                "resume-ingestion",
            return;
            }
import org.opensearch.cluster.block.ClusterBlockLevel;
        int[] shards = Arrays.stream(request.getResetSettings()).mapToInt(ResumeIngestionRequest.ResetSettings::getShard).toArray();
    @Override
    protected void clusterManagerOperation(
            @Override
    ) {
    }
    protected void clusterManagerOperation(
        UpdateIngestionStateRequest updateIngestionStateRequest = new UpdateIngestionStateRequest(indices, new int[0]);
        final ClusterState state,
    @Override
                    updateIngestionStateResponse.getErrorMessage()
 * compatible open source license.
            // reset consumer and resume ingestion
        MetadataStreamingIngestionStateService ingestionStateService,
 * this file be licensed under the Apache-2.0 license or a
        super.doExecute(task, request, listener);
    }
                "resume-ingestion",
    protected ClusterBlockException checkBlock(ResumeIngestionRequest request, ClusterState state) {
import org.apache.logging.log4j.Logger;
                    updateIngestionStateResponse.getShardFailureList(),
    public TransportResumeIngestionAction(
import org.opensearch.tasks.Task;
                    shardsAcked,
import java.util.Arrays;
    }
        ThreadPool threadPool,
package org.opensearch.action.admin.indices.streamingingestion.resume;
 *
        return ResolvedIndices.of(resolveIndices(clusterService.state(), request));
import org.opensearch.cluster.metadata.MetadataStreamingIngestionStateService;
 * SPDX-License-Identifier: Apache-2.0
                resumeIngestionRequest,
