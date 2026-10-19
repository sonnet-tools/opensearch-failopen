 * Licensed to Elasticsearch under one or more contributor  
        );
    }  
            CloneSnapshotAction.NAME,
 */
    @Override
    @Override
    }
            CloneSnapshotRequest::new,  
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
import org.opensearch.cluster.block.ClusterBlockLevel;  
package org.opensearch.action.admin.cluster.snapshots.clone;
 */
 */  
import org.opensearch.common.inject.Inject;  
    }
        IndexNameExpressionResolver indexNameExpressionResolver
 */  
 * software distributed under the License is distributed on an
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
        SnapshotsService snapshotsService,
 *  
    public TransportCloneSnapshotAction(
            actionFilters,
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_READ);
        super(  
import org.opensearch.threadpool.ThreadPool;
 * not use this file except in compliance with the License.
    protected void clusterManagerOperation(
            indexNameExpressionResolver
/**  
            clusterService,  
import org.opensearch.snapshots.SnapshotsService;  
 * ownership. Elasticsearch licenses this file to you under  
    ) {  
    protected String executor() {
    private final SnapshotsService snapshotsService;
    }
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See
public final class TransportCloneSnapshotAction extends TransportClusterManagerNodeAction<CloneSnapshotRequest, AcknowledgedResponse> {
        return new AcknowledgedResponse(in);
        ClusterService clusterService,  
        ActionFilters actionFilters,  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
    ) {
    @Inject  
        ClusterState state,
        TransportService transportService,
        // Cluster is not affected but we look up repositories in metadata  
/*  
        return ThreadPool.Names.SAME;
 * Transport action for the clone snapshot operation.
import org.opensearch.cluster.block.ClusterBlockException;
    @Override
    protected ClusterBlockException checkBlock(CloneSnapshotRequest request, ClusterState state) {
        ActionListener<AcknowledgedResponse> listener
 *
        snapshotsService.executeClone(request, ActionListener.map(listener, v -> new AcknowledgedResponse(true)));
            transportService,
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
}  
/*  
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;  
import org.opensearch.core.common.io.stream.StreamInput;
 * compatible open source license.
import java.io.IOException;
        ThreadPool threadPool,
    }
/*
 *
import org.opensearch.cluster.service.ClusterService;
    protected AcknowledgedResponse read(StreamInput in) throws IOException {  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
 * @opensearch.internal  
import org.opensearch.cluster.ClusterState;
import org.opensearch.action.support.ActionFilters;
    @Override  
        this.snapshotsService = snapshotsService;  
import org.opensearch.transport.TransportService;
import org.opensearch.core.action.ActionListener;
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
        CloneSnapshotRequest request,  
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
            threadPool,
 *     http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
 *
