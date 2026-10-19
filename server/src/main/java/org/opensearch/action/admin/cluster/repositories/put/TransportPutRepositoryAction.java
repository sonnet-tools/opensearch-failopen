        TransportService transportService,
 * software distributed under the License is distributed on an
import org.opensearch.cluster.block.ClusterBlockLevel;  
    ) {
        ClusterState state,  
    @Override
 * this file be licensed under the Apache-2.0 license or a
/*  
/**  
import org.opensearch.cluster.ClusterState;
 */  
    public TransportPutRepositoryAction(
    }  
 * under the License.  
        repositoriesService.registerOrUpdateRepository(  
            transportService,
    @Inject  
        final PutRepositoryRequest request,
        ThreadPool threadPool,
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;  
        RepositoriesService repositoriesService,
 *
import org.opensearch.core.common.io.stream.StreamInput;
 *     http://www.apache.org/licenses/LICENSE-2.0
    protected AcknowledgedResponse read(StreamInput in) throws IOException {  
    ) {
 * license agreements. See the NOTICE file distributed with
    @Override  
 * Licensed to Elasticsearch under one or more contributor  
            PutRepositoryAction.NAME,
 * Unless required by applicable law or agreed to in writing,
        ActionFilters actionFilters,  
            PutRepositoryRequest::new,  
            actionFilters,
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
 */
 * SPDX-License-Identifier: Apache-2.0
    }
        super(  
 * Modifications Copyright OpenSearch Contributors. See
 */
 * the Apache License, Version 2.0 (the "License"); you may
}
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
            request,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return new AcknowledgedResponse(in);
            ActionListener.delegateFailure(
/*  
package org.opensearch.action.admin.cluster.repositories.put;
    }
            )
import org.opensearch.transport.TransportService;
    @Override  
            threadPool,
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
import org.opensearch.cluster.block.ClusterBlockException;
    }
 * KIND, either express or implied.  See the License for the
        );
    private final RepositoriesService repositoriesService;
            indexNameExpressionResolver
import org.opensearch.threadpool.ThreadPool;
 * You may obtain a copy of the License at  
    protected ClusterBlockException checkBlock(PutRepositoryRequest request, ClusterState state) {
    }
        final ActionListener<AcknowledgedResponse> listener
public class TransportPutRepositoryAction extends TransportClusterManagerNodeAction<PutRepositoryRequest, AcknowledgedResponse> {
import org.opensearch.common.inject.Inject;  
/*
                listener,  
            clusterService,  
import org.opensearch.repositories.RepositoriesService;  
        ClusterService clusterService,  
import org.opensearch.action.support.ActionFilters;
        return ThreadPool.Names.SAME;
 *  
import java.io.IOException;
        IndexNameExpressionResolver indexNameExpressionResolver
 * Transport action for register repository operation
    @Override
    protected void clusterManagerOperation(
 */  
 *
        );  
    protected String executor() {
                (delegatedListener, response) -> delegatedListener.onResponse(new AcknowledgedResponse(response.isAcknowledged()))
 * compatible open source license.
 * this work for additional information regarding copyright
import org.opensearch.core.action.ActionListener;
 * GitHub history for details.
        this.repositoriesService = repositoriesService;  
 * @opensearch.internal  
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);  
 * not use this file except in compliance with the License.
 *
