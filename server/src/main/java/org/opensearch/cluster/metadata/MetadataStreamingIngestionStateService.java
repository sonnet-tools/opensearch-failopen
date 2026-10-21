                    listener.onResponse(new UpdateIngestionStateResponse(false, 0, 0, 0, Collections.emptyList()));
 */
                }
                logger.debug("Pause/resume request will be ignored for index {} as streaming ingestion is not enabled", index);
                        }
            }
    }
        if (request.getResetSettings() != null && request.getResetSettings().length > 0 && request.getIngestionPaused() != false) {
                );
import org.opensearch.action.admin.indices.streamingingestion.state.TransportUpdateIngestionStateAction;
            @Override
            if (indexMetadata.getIngestionStatus().isPaused() != ingestionPaused) {
    public void updateIngestionPollerState(
        this.clusterService = clusterService;
     * This method resets the consumer and resumes ingestion. This is done in 3 phases.
            @Override
        String source,
    }
        ActionListener<UpdateIngestionStateResponse> listener
                    logger.debug("Cluster state did not change when trying to set ingestionPaused={}", request.getIngestionPaused());
     *      <li>Phase 2: Runs transport action to update cluster state on individual shards and collects success/failure responses.</li>
                    index,
}
                }
                    )
        UpdateIngestionStateRequest shardPointerUpdateRequest,
                            );
    }
                        @Override
                            listener.onResponse(updateIngestionStateResponse);
        Index[] concreteIndices,
        }
            throw new IllegalArgumentException("Ingestion poller target state is missing");
                    new OpenSearchException(
        }
            @Override
                                0,
            @Override
 * The OpenSearch Contributors require contributions made to
            @Override
        final ClusterState currentState,
            throw new IllegalArgumentException("Index is missing");
                                0,
    ) {
            }
            }
    /**
     *  </ul>
     *      <li>Second, ingestion state update is started. This then follows the 2 phase approach from {@link #updateIngestionPollerState} to first update
        transportUpdateIngestionStateAction.execute(shardPointerUpdateRequest, new ActionListener<>() {
        UpdateIngestionStateRequest request,
     *  Note that the second phase could be a no-op if the shard already processed the cluster state update.
        String source,
            }
                if (oldState == newState) {
    private final TransportUpdateIngestionStateAction transportUpdateIngestionStateAction;
            public TimeValue timeout() {
            }
                if (isSuccessfulUpdate) {
                listener.onFailure(e);
                listener.onFailure(
                return getUpdatedIngestionPausedClusterState(concreteIndices, currentState, request.getIngestionPaused());
    private static final Logger logger = LogManager.getLogger(MetadataStreamingIngestionStateService.class);
                    && updateIngestionStateResponse.getFailedShards() == 0;
                    ingestionPaused
/*
     *      <li>First, reset consumer operation is executed.</li>
                    ingestionPaused,
                    updateIngestionPollerState(source, concreteIndices, resumeIngestionRequest, listener);
    public void processUpdateIngestionRequestOnShards(
                    "Received request for ingestionPaused:{} for index {}. The state is already ingestionPaused:{}",
import org.apache.logging.log4j.Logger;
import org.opensearch.OpenSearchException;
        for (Index index : indices) {
     *      <li>Phase 1: Publishes cluster state update to pause/resume ingestion. This phase finishes once the update is acknowledged</li>
    @Inject
                            response.setErrorMessage("Error encountered while verifying ingestion poller state: " + e.getMessage());
                        "Ingestion cluster state update failed to set ingestionPaused={}",
     * Updates ingestionPaused value in provided cluster state.
        if (concreteIndices == null || concreteIndices.length == 0) {
            public ClusterState execute(ClusterState currentState) {
        final Index[] indices,
                final IndexMetadata.Builder updatedMetadata = IndexMetadata.builder(indexMetadata).ingestionStatus(updatedIngestionStatus);
     * </ol>
        }
 * this file be licensed under the Apache-2.0 license or a
        }
                    listener.onResponse(updateIngestionStateResponse);
package org.opensearch.cluster.metadata;
            if (indexMetadata.useIngestionSource() == false) {
            }
 * compatible open source license.
                        request.getIngestionPaused(),
    public void resetShardPointerAndResumeIngestion(
            public void onFailure(String source, Exception e) {
            throw new IllegalArgumentException("Poller position can only be reset during a resume operation.");
        if (concreteIndices == null || concreteIndices.length == 0) {
    }
            public void clusterStateProcessed(final String source, final ClusterState oldState, final ClusterState newState) {
    /**
                IngestionStatus updatedIngestionStatus = new IngestionStatus(ingestionPaused);
                    });
                                true,
                logger.debug("Error resetting consumer pointers", e);
                        public void onResponse(UpdateIngestionStateResponse updateIngestionStateResponse) {
                        @Override
                    processUpdateIngestionRequestOnShards(request, new ActionListener<>() {
                logger.debug(
        TransportUpdateIngestionStateAction transportUpdateIngestionStateAction
/**
    public MetadataStreamingIngestionStateService(
                return request.timeout();
        boolean ingestionPaused
    ) {
import org.opensearch.action.admin.indices.streamingingestion.state.UpdateIngestionStateRequest;
                        }
    }
                boolean isSuccessfulUpdate = updateIngestionStateResponse.isAcknowledged()
import org.opensearch.core.index.Index;
public class MetadataStreamingIngestionStateService {
import org.opensearch.cluster.ClusterState;
            } else {
                            UpdateIngestionStateResponse response = new UpdateIngestionStateResponse(
                            listener.onResponse(response);
        UpdateIngestionStateRequest updateIngestionStateRequest,
            public void onResponse(UpdateIngestionStateResponse updateIngestionStateResponse) {
    private ClusterState getUpdatedIngestionPausedClusterState(
        ActionListener<UpdateIngestionStateResponse> listener
        return ClusterState.builder(currentState).metadata(metadata).build();
 * Service responsible for submitting metadata updates (for example, ingestion pause/resume state change updates).
        });
            @Override
import org.opensearch.core.action.ActionListener;
        if (request.getIngestionPaused() == null) {
                metadata.put(updatedMetadata);
import org.opensearch.common.Priority;
                                0,
     */
 */
        Index[] concreteIndices,
    ) {
import org.opensearch.common.unit.TimeValue;
        UpdateIngestionStateRequest resumeIngestionRequest,
                );
import org.opensearch.cluster.ClusterStateUpdateTask;
    private final ClusterService clusterService;
     * Ingestion state will only be updated if consumer reset is performed successfully.
            }
            }
 * @opensearch.internal
 * SPDX-License-Identifier: Apache-2.0
     *  <ul>
        this.transportUpdateIngestionStateAction = transportUpdateIngestionStateAction;
import org.apache.logging.log4j.LogManager;
        ActionListener<UpdateIngestionStateResponse> listener
     *      the cluster state followed by synchronously updating each shard of the index</li>
    ) {
            final IndexMetadata indexMetadata = metadata.getSafe(index);
            throw new IllegalArgumentException("Index is missing");
        transportUpdateIngestionStateAction.execute(updateIngestionStateRequest, listener);
import org.opensearch.action.admin.indices.streamingingestion.state.UpdateIngestionStateResponse;
    /**
     *
                        public void onFailure(Exception e) {
                } else {
        final Metadata.Builder metadata = Metadata.builder(currentState.metadata());
        clusterService.submitStateUpdateTask(source, new ClusterStateUpdateTask(Priority.URGENT) {
    ) {
        }
            public void onFailure(Exception e) {
     */
import java.util.Collections;
                    logger.debug("Error resetting consumer pointers");
 *
     *  <p> The two phase approach is taken in order to give real time feedback to the user if the ingestion update was a success or failure.
     *
    /**
import org.opensearch.cluster.service.ClusterService;
     * <ol>
     */
                } else {
import org.opensearch.common.inject.Inject;
                        e
     */
                                Collections.emptyList()
        });
     * Executes transport action to update ingestion state on provided index shards.
     *  This method updates the ingestion poller state in two phases for provided index shards.
        ClusterService clusterService,
 *
