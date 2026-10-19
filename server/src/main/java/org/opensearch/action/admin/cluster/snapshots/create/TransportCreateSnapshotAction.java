        TransportService transportService,  
 * this file be licensed under the Apache-2.0 license or a
    protected CreateSnapshotResponse read(StreamInput in) throws IOException {  
import org.opensearch.cluster.service.ClusterService;
        this.snapshotsService = snapshotsService;
import org.opensearch.cluster.ClusterState;  
    @Inject
import org.opensearch.core.action.ActionListener;  
 * @opensearch.internal  
 * Unless required by applicable law or agreed to in writing,
            snapshotsService.createSnapshot(request, ActionListener.map(listener, snapshot -> new CreateSnapshotResponse()));  
 * software distributed under the License is distributed on an
        } else if (isSnapshotV2) {  
import org.opensearch.cluster.block.ClusterBlockLevel;
 */
 *
 * Transport action for create snapshot operation
            indexNameExpressionResolver  
import java.io.IOException;
 * license agreements. See the NOTICE file distributed with
 */  
 */
    protected ClusterBlockException checkBlock(CreateSnapshotRequest request, ClusterState state) {
            CreateSnapshotAction.NAME,  
            threadPool,  
    }
 * GitHub history for details.
        ThreadPool threadPool,
        IndexNameExpressionResolver indexNameExpressionResolver  
    protected void clusterManagerOperation(  
        } else {
    }
 * compatible open source license.
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See
import static org.opensearch.repositories.blobstore.BlobStoreRepository.SHALLOW_SNAPSHOT_V2;
import org.opensearch.snapshots.SnapshotsService;
            snapshotsService.executeSnapshot(request, ActionListener.map(listener, CreateSnapshotResponse::new));
    @Override
 * this work for additional information regarding copyright
import org.opensearch.transport.TransportService;  
import org.opensearch.cluster.block.ClusterBlockException;
            actionFilters,
    private final SnapshotsService snapshotsService;  
import org.opensearch.threadpool.ThreadPool;
 * the Apache License, Version 2.0 (the "License"); you may
    ) {
    @Override
/*
        ClusterState state,
    ) {
/*  
    public TransportCreateSnapshotAction(
        return null;
        if (request.waitForCompletion()) {
 *
        final CreateSnapshotRequest request,
import org.opensearch.repositories.Repository;  
/*  
import org.opensearch.common.inject.Inject;
 * You may obtain a copy of the License at  
            CreateSnapshotRequest::new,
import org.opensearch.core.common.io.stream.StreamInput;
    @Override  
        return new CreateSnapshotResponse(in);
        ClusterService clusterService,
}  
        }
 * SPDX-License-Identifier: Apache-2.0
    }
 */  
import org.opensearch.action.support.ActionFilters;
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.repositories.RepositoriesService;
    private final RepositoriesService repositoriesService;
 * specific language governing permissions and limitations
        final ActionListener<CreateSnapshotResponse> listener  
 *  
        // We only check metadata block, as we want to snapshot closed indices (which have a read block)  
        if (clusterBlockException != null) {
 * ownership. Elasticsearch licenses this file to you under  
            transportService,
 *
 * The OpenSearch Contributors require contributions made to  
        RepositoriesService repositoriesService,
    @Override
        Repository repository = repositoriesService.repository(request.repository());
    }  
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
            clusterService,
            return clusterBlockException;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.action.admin.cluster.snapshots.create;
        ClusterBlockException clusterBlockException = state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_READ);
    }  
 * KIND, either express or implied.  See the License for the
/**  
        ActionFilters actionFilters,
public class TransportCreateSnapshotAction extends TransportClusterManagerNodeAction<CreateSnapshotRequest, CreateSnapshotResponse> {
            snapshotsService.executeSnapshot(request, ActionListener.map(listener, snapshot -> new CreateSnapshotResponse()));
        boolean isSnapshotV2 = SHALLOW_SNAPSHOT_V2.get(repository.getMetadata().settings());  
        );
        this.repositoriesService = repositoriesService;  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
        super(
 * under the License.  
    protected String executor() {
        return ThreadPool.Names.SAME;
        SnapshotsService snapshotsService,  
        }
