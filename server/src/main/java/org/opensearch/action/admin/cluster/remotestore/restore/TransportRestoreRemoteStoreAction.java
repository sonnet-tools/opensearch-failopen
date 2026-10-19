        ClusterBlockException blockException = state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);  
        // Restoring a remote store might change the global state and create/change an index,
                delegatedListener.onResponse(new RestoreRemoteStoreResponse(restoreCompletionResponse.getRestoreInfo()));
    @Override
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreClusterStateListener;
        ActionFilters actionFilters,
                    delegatedListener,
        this.restoreService = restoreService;
        ThreadPool threadPool,
package org.opensearch.action.admin.cluster.remotestore.restore;
        super(
    @Override
import org.opensearch.threadpool.ThreadPool;
        }));
            actionFilters,  
    ) {  
}  
 */  
            transportService,  
        final ActionListener<RestoreRemoteStoreResponse> listener  
import org.opensearch.common.inject.Inject;  
    RestoreRemoteStoreResponse> {
 * SPDX-License-Identifier: Apache-2.0
        final RestoreRemoteStoreRequest request,
/*  
            RestoreRemoteStoreAction.NAME,
            indexNameExpressionResolver
        return state.blocks().globalBlockedException(ClusterBlockLevel.WRITE);
        return new RestoreRemoteStoreResponse(in);
    RestoreRemoteStoreRequest,  
            RestoreRemoteStoreRequest::new,
                RestoreClusterStateListener.createAndRegisterListener(
/**  
    protected RestoreRemoteStoreResponse read(StreamInput in) throws IOException {
        RemoteStoreRestoreService restoreService,  
        IndexNameExpressionResolver indexNameExpressionResolver
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
import org.opensearch.cluster.block.ClusterBlockLevel;  
    }  
import org.opensearch.action.support.ActionFilters;
            if (restoreCompletionResponse.getRestoreInfo() == null && request.waitForCompletion()) {  
        }  
            return blockException;
 *
            }  
 * Transport action for restore remote store operation
import java.io.IOException;
    }
        return ThreadPool.Names.GENERIC;  
    protected ClusterBlockException checkBlock(RestoreRemoteStoreRequest request, ClusterState state) {  
 */
            threadPool,
    private final RemoteStoreRestoreService restoreService;
import org.opensearch.cluster.block.ClusterBlockException;
    @Override
                    RestoreRemoteStoreResponse::new
    @Inject
            } else {
import org.opensearch.transport.TransportService;
import org.opensearch.core.action.ActionListener;
        // so we need to check for METADATA_WRITE and WRITE blocks
                    restoreCompletionResponse,  
            clusterService,
    ) {
import org.opensearch.core.common.io.stream.StreamInput;
        TransportService transportService,  
                );  
 *
 * this file be licensed under the Apache-2.0 license or a
    protected String executor() {
import org.opensearch.cluster.service.ClusterService;
    public TransportRestoreRemoteStoreAction(
                    clusterService,
    protected void clusterManagerOperation(  
        if (blockException != null) {
        ClusterService clusterService,
 * compatible open source license.
import org.opensearch.index.recovery.RemoteStoreRestoreService;  
    }
public final class TransportRestoreRemoteStoreAction extends TransportClusterManagerNodeAction<
    @Override  
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;  
    }  
import org.opensearch.cluster.ClusterState;
        );  
 * The OpenSearch Contributors require contributions made to  
        final ClusterState state,
 * @opensearch.internal  
    }
        restoreService.restore(request, ActionListener.delegateFailure(listener, (delegatedListener, restoreCompletionResponse) -> {
