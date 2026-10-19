    @Inject  
    private final RepositoriesService repositoriesService;
 */
            transportService,
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.threadpool.ThreadPool;
            actionFilters,
import org.opensearch.cluster.block.ClusterBlockLevel;  
    }
                (delegatedListener, unregisterRepositoryResponse) -> delegatedListener.onResponse(
 *
package org.opensearch.action.admin.cluster.repositories.delete;
import org.opensearch.common.inject.Inject;  
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
    ) {
        final DeleteRepositoryRequest request,
}
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);  
    @Override  
/*  
        super(  
        ClusterState state,  
            ActionListener.delegateFailure(
import org.opensearch.action.support.ActionFilters;
                    new AcknowledgedResponse(unregisterRepositoryResponse.isAcknowledged())
 */
import org.opensearch.core.action.ActionListener;
 * under the License.  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        IndexNameExpressionResolver indexNameExpressionResolver
/*
 * license agreements. See the NOTICE file distributed with
    @Override
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
    public TransportDeleteRepositoryAction(
 * SPDX-License-Identifier: Apache-2.0
import java.io.IOException;
 *
 *
 * You may obtain a copy of the License at  
import org.opensearch.transport.TransportService;
        TransportService transportService,
 * ownership. Elasticsearch licenses this file to you under  
 * this work for additional information regarding copyright
    protected AcknowledgedResponse read(StreamInput in) throws IOException {  
        ThreadPool threadPool,
            request,
        final ActionListener<AcknowledgedResponse> listener
        this.repositoriesService = repositoriesService;  
 */  
    }  
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;  
        RepositoriesService repositoriesService,
        ClusterService clusterService,  
import org.opensearch.cluster.block.ClusterBlockException;
/**  
            DeleteRepositoryAction.NAME,
 * Licensed to Elasticsearch under one or more contributor  
            )
    protected String executor() {
        return ThreadPool.Names.SAME;
            threadPool,
    ) {
        ActionFilters actionFilters,  
        );
    }
 * specific language governing permissions and limitations
                listener,  
import org.opensearch.cluster.ClusterState;
/*  
        repositoriesService.unregisterRepository(  
import org.opensearch.repositories.RepositoriesService;  
 * not use this file except in compliance with the License.
    @Override
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
 * @opensearch.internal  
            clusterService,  
import org.opensearch.cluster.service.ClusterService;
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.common.io.stream.StreamInput;
            DeleteRepositoryRequest::new,  
    }  
    @Override  
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *     http://www.apache.org/licenses/LICENSE-2.0
        return new AcknowledgedResponse(in);
            indexNameExpressionResolver
 * GitHub history for details.
 * software distributed under the License is distributed on an
 *  
    protected ClusterBlockException checkBlock(DeleteRepositoryRequest request, ClusterState state) {
 */  
        );
public class TransportDeleteRepositoryAction extends TransportClusterManagerNodeAction<DeleteRepositoryRequest, AcknowledgedResponse> {
                )  
    protected void clusterManagerOperation(
    }
 * Transport action for unregister repository operation
