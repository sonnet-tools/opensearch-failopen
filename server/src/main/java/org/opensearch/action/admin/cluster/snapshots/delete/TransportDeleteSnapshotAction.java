 * The OpenSearch Contributors require contributions made to  
        );
        return ThreadPool.Names.SAME;
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
import org.opensearch.common.inject.Inject;  
 * software distributed under the License is distributed on an
 */  
 */
 * under the License.  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
    @Override  
import java.io.IOException;
            indexNameExpressionResolver  
import org.opensearch.core.common.io.stream.StreamInput;
/*
 * @opensearch.internal  
    private final SnapshotsService snapshotsService;  
    }
    protected void clusterManagerOperation(
            actionFilters,
 *
            DeleteSnapshotAction.NAME,  
    }
            DeleteSnapshotRequest::new,
    }
        final ActionListener<AcknowledgedResponse> listener
 * the Apache License, Version 2.0 (the "License"); you may
 *     http://www.apache.org/licenses/LICENSE-2.0
    protected AcknowledgedResponse read(StreamInput in) throws IOException {
 * KIND, either express or implied.  See the License for the
    @Inject
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.cluster.block.ClusterBlockLevel;  
 * license agreements. See the NOTICE file distributed with
        this.snapshotsService = snapshotsService;
        super(
    public TransportDeleteSnapshotAction(  
import org.opensearch.core.action.ActionListener;
 * SPDX-License-Identifier: Apache-2.0
    @Override
import org.opensearch.cluster.block.ClusterBlockException;
/**  
    protected String executor() {  
/*  
        ThreadPool threadPool,  
    }
import org.opensearch.action.support.ActionFilters;
        snapshotsService.deleteSnapshots(request, ActionListener.map(listener, v -> new AcknowledgedResponse(true)));  
        ClusterState state,  
import org.opensearch.transport.TransportService;
 * Transport action for delete snapshot operation
            clusterService,
 * Modifications Copyright OpenSearch Contributors. See
public class TransportDeleteSnapshotAction extends TransportClusterManagerNodeAction<DeleteSnapshotRequest, AcknowledgedResponse> {
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;  
        ActionFilters actionFilters,
 */
        final DeleteSnapshotRequest request,
    }  
/*  
import org.opensearch.threadpool.ThreadPool;
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
        ClusterService clusterService,
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_READ);  
package org.opensearch.action.admin.cluster.snapshots.delete;
}
 */  
 * You may obtain a copy of the License at  
    @Override  
        IndexNameExpressionResolver indexNameExpressionResolver  
 * GitHub history for details.
    protected ClusterBlockException checkBlock(DeleteSnapshotRequest request, ClusterState state) {
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
 * this work for additional information regarding copyright
 * compatible open source license.
            transportService,
    ) {
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.snapshots.SnapshotsService;  
 *  
    ) {
            threadPool,  
        return new AcknowledgedResponse(in);  
        // Cluster is not affected but we look up repositories in metadata
        TransportService transportService,
import org.opensearch.cluster.ClusterState;
 *
 *
        SnapshotsService snapshotsService,
