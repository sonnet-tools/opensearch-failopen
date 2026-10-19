 */  
import org.opensearch.cluster.block.ClusterBlockLevel;
import org.opensearch.snapshots.RestoreService;
        if (blockException != null) {  
 */
import org.opensearch.cluster.ClusterState;  
    public TransportRestoreSnapshotAction(
        final ActionListener<RestoreSnapshotResponse> listener
package org.opensearch.action.admin.cluster.snapshots.restore;
 * GitHub history for details.
 * You may obtain a copy of the License at  
                    restoreCompletionResponse,
        );  
 * the Apache License, Version 2.0 (the "License"); you may
/**
 * KIND, either express or implied.  See the License for the
import org.opensearch.cluster.block.ClusterBlockException;
            if (restoreCompletionResponse.getRestoreInfo() == null && request.waitForCompletion()) {
        return state.blocks().globalBlockedException(ClusterBlockLevel.WRITE);  
import org.opensearch.threadpool.ThreadPool;  
        TransportService transportService,  
        return ThreadPool.Names.GENERIC;
            actionFilters,  
        restoreService.restoreSnapshot(request, ActionListener.delegateFailure(listener, (delegatedListener, restoreCompletionResponse) -> {
import org.opensearch.core.action.ActionListener;  
                delegatedListener.onResponse(new RestoreSnapshotResponse(restoreCompletionResponse.getRestoreInfo()));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            threadPool,
/*  
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
 * under the License.  
        // so we need to check for METADATA_WRITE and WRITE blocks
        super(
}
        }));  
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
/*
                );
 * SPDX-License-Identifier: Apache-2.0
                RestoreClusterStateListener.createAndRegisterListener(  
        this.restoreService = restoreService;
        final RestoreSnapshotRequest request,  
        ActionFilters actionFilters,
 * Unless required by applicable law or agreed to in writing,
 *
            return blockException;
import org.opensearch.common.inject.Inject;
            RestoreSnapshotRequest::new,
 * ownership. Elasticsearch licenses this file to you under  
            } else {  
            indexNameExpressionResolver
                    clusterService,
        final ClusterState state,
                    RestoreSnapshotResponse::new
            clusterService,
    @Override
        // Restoring a snapshot might change the global state and create/change an index,  
            }
 *
    @Override
    }
        // which would block the request from getting an error response because of the ongoing task
        RestoreService restoreService,  
import org.opensearch.core.common.io.stream.StreamInput;
 * compatible open source license.
    ) {  
 * specific language governing permissions and limitations
    }
            transportService,  
public class TransportRestoreSnapshotAction extends TransportClusterManagerNodeAction<RestoreSnapshotRequest, RestoreSnapshotResponse> {
    }  
 * Transport action for restore snapshot operation  
import java.io.IOException;  
 * Licensed to Elasticsearch under one or more contributor  
    ) {  
    private final RestoreService restoreService;
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See
    }
    @Inject
 * this file be licensed under the Apache-2.0 license or a
 */  
import org.opensearch.transport.TransportService;
        ClusterBlockException blockException = state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);
 *
    }
        }
    protected String executor() {
    protected void clusterManagerOperation(
        IndexNameExpressionResolver indexNameExpressionResolver
    @Override
            RestoreSnapshotAction.NAME,
        return new RestoreSnapshotResponse(in);
    @Override
        ClusterService clusterService,
import org.opensearch.cluster.service.ClusterService;
        // Using the generic instead of the snapshot threadpool here as the snapshot threadpool might be blocked on long running tasks  
 * software distributed under the License is distributed on an
 * this work for additional information regarding copyright
 *  
/*  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
 * @opensearch.internal
 */  
    protected ClusterBlockException checkBlock(RestoreSnapshotRequest request, ClusterState state) {
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.action.support.ActionFilters;
                    delegatedListener,  
        ThreadPool threadPool,
    protected RestoreSnapshotResponse read(StreamInput in) throws IOException {  
