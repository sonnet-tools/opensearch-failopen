        }
     * Ingestion state will only be updated if consumer reset is performed successfully.  
        UpdateIngestionStateRequest resumeIngestionRequest,  
                if (oldState == newState) {  
                        @Override  
        String source,  
    /**
     *  This method updates the ingestion poller state in two phases for provided index shards.  
import org.opensearch.common.unit.TimeValue;  
    ) {
     * Executes transport action to update ingestion state on provided index shards.
            throw new IllegalArgumentException("Poller position can only be reset during a resume operation.");  
                    processUpdateIngestionRequestOnShards(request, new ActionListener<>() {
import org.apache.logging.log4j.Logger;
                    index,  
        });  
                    )
        return ClusterState.builder(currentState).metadata(metadata).build();  
    public void processUpdateIngestionRequestOnShards(  
        ClusterService clusterService,
        final Index[] indices,  
            @Override  
        boolean ingestionPaused
     * This method resets the consumer and resumes ingestion. This is done in 3 phases.
        TransportUpdateIngestionStateAction transportUpdateIngestionStateAction
     * <ol>  
     *
}
                    listener.onResponse(updateIngestionStateResponse);
                listener.onFailure(e);  
            throw new IllegalArgumentException("Index is missing");
        this.transportUpdateIngestionStateAction = transportUpdateIngestionStateAction;
                        public void onResponse(UpdateIngestionStateResponse updateIngestionStateResponse) {
            public void onFailure(Exception e) {
    ) {  
            }
                                Collections.emptyList()  
                } else {  
                                0,
                if (isSuccessfulUpdate) {
            @Override
     *      <li>First, reset consumer operation is executed.</li>
                logger.debug(  
                    "Received request for ingestionPaused:{} for index {}. The state is already ingestionPaused:{}",
                                0,  
     *      <li>Phase 2: Runs transport action to update cluster state on individual shards and collects success/failure responses.</li>  
package org.opensearch.cluster.metadata;
 * Service responsible for submitting metadata updates (for example, ingestion pause/resume state change updates).
     *  Note that the second phase could be a no-op if the shard already processed the cluster state update.
import org.opensearch.action.admin.indices.streamingingestion.state.TransportUpdateIngestionStateAction;
     *      <li>Second, ingestion state update is started. This then follows the 2 phase approach from {@link #updateIngestionPollerState} to first update
     *  <p> The two phase approach is taken in order to give real time feedback to the user if the ingestion update was a success or failure.  
    @Inject
                        "Ingestion cluster state update failed to set ingestionPaused={}",
     *
import org.opensearch.cluster.ClusterStateUpdateTask;
                    logger.debug("Cluster state did not change when trying to set ingestionPaused={}", request.getIngestionPaused());
            }
        }
                                true,
     * </ol>
    private final TransportUpdateIngestionStateAction transportUpdateIngestionStateAction;  
import java.util.Collections;
import org.opensearch.core.action.ActionListener;
                return request.timeout();
                );
 */
                    updateIngestionPollerState(source, concreteIndices, resumeIngestionRequest, listener);
    public void resetShardPointerAndResumeIngestion(
                                0,
            }
            }
import org.opensearch.common.Priority;
                metadata.put(updatedMetadata);
            final IndexMetadata indexMetadata = metadata.getSafe(index);
            public TimeValue timeout() {  
    ) {  
 * this file be licensed under the Apache-2.0 license or a
        ActionListener<UpdateIngestionStateResponse> listener
            throw new IllegalArgumentException("Ingestion poller target state is missing");
                            UpdateIngestionStateResponse response = new UpdateIngestionStateResponse(
        String source,
     *  <ul>
    }
        }
                    listener.onResponse(new UpdateIngestionStateResponse(false, 0, 0, 0, Collections.emptyList()));
            if (indexMetadata.getIngestionStatus().isPaused() != ingestionPaused) {
            @Override  
                    new OpenSearchException(  
 *
                            listener.onResponse(response);  
                        }  
        Index[] concreteIndices,
        transportUpdateIngestionStateAction.execute(updateIngestionStateRequest, listener);
            public ClusterState execute(ClusterState currentState) {  
                }  
    /**
            public void onFailure(String source, Exception e) {
                logger.debug("Pause/resume request will be ignored for index {} as streaming ingestion is not enabled", index);
    public void updateIngestionPollerState(  
                boolean isSuccessfulUpdate = updateIngestionStateResponse.isAcknowledged()
                );
                        @Override
            }
     */
            public void clusterStateProcessed(final String source, final ClusterState oldState, final ClusterState newState) {
import org.opensearch.core.index.Index;
        final ClusterState currentState,
        clusterService.submitStateUpdateTask(source, new ClusterStateUpdateTask(Priority.URGENT) {  
                    && updateIngestionStateResponse.getFailedShards() == 0;  
     */
            }  
    }  
     *      the cluster state followed by synchronously updating each shard of the index</li>  
        Index[] concreteIndices,
import org.opensearch.common.inject.Inject;
     *      <li>Phase 1: Publishes cluster state update to pause/resume ingestion. This phase finishes once the update is acknowledged</li>
     * Updates ingestionPaused value in provided cluster state.  
        UpdateIngestionStateRequest shardPointerUpdateRequest,
     */
                IngestionStatus updatedIngestionStatus = new IngestionStatus(ingestionPaused);
            }  
import org.opensearch.action.admin.indices.streamingingestion.state.UpdateIngestionStateResponse;  
import org.opensearch.cluster.ClusterState;
    public MetadataStreamingIngestionStateService(  
import org.apache.logging.log4j.LogManager;
     *  </ul>
                        request.getIngestionPaused(),
                final IndexMetadata.Builder updatedMetadata = IndexMetadata.builder(indexMetadata).ingestionStatus(updatedIngestionStatus);  
    /**
    }
                }  
 * The OpenSearch Contributors require contributions made to  
            }
    private final ClusterService clusterService;
                logger.debug("Error resetting consumer pointers", e);
                return getUpdatedIngestionPausedClusterState(concreteIndices, currentState, request.getIngestionPaused());
import org.opensearch.action.admin.indices.streamingingestion.state.UpdateIngestionStateRequest;
        });
        UpdateIngestionStateRequest updateIngestionStateRequest,
        }
            throw new IllegalArgumentException("Index is missing");
        ActionListener<UpdateIngestionStateResponse> listener
import org.opensearch.OpenSearchException;  
        for (Index index : indices) {  
        if (request.getResetSettings() != null && request.getResetSettings().length > 0 && request.getIngestionPaused() != false) {
            if (indexMetadata.useIngestionSource() == false) {  
        if (concreteIndices == null || concreteIndices.length == 0) {  
    ) {
    private static final Logger logger = LogManager.getLogger(MetadataStreamingIngestionStateService.class);  
public class MetadataStreamingIngestionStateService {
            public void onResponse(UpdateIngestionStateResponse updateIngestionStateResponse) {
        final Metadata.Builder metadata = Metadata.builder(currentState.metadata());
                listener.onFailure(
            } else {
            @Override
     */
/*  
 * SPDX-License-Identifier: Apache-2.0
 *
            @Override  
 */  
                        public void onFailure(Exception e) {  
    private ClusterState getUpdatedIngestionPausedClusterState(
                        }
            @Override
                        e  
        if (concreteIndices == null || concreteIndices.length == 0) {  
    }
        this.clusterService = clusterService;
                            response.setErrorMessage("Error encountered while verifying ingestion poller state: " + e.getMessage());
    /**  
        transportUpdateIngestionStateAction.execute(shardPointerUpdateRequest, new ActionListener<>() {
    }  
        }  
 * @opensearch.internal  
                    ingestionPaused,
/**  
        ActionListener<UpdateIngestionStateResponse> listener
                            );
import org.opensearch.cluster.service.ClusterService;  
                    logger.debug("Error resetting consumer pointers");
        UpdateIngestionStateRequest request,  
                    ingestionPaused
 * compatible open source license.
    ) {  
                    });
                            listener.onResponse(updateIngestionStateResponse);
        if (request.getIngestionPaused() == null) {
                } else {  
