    private final RepositoriesService repositoriesService;
public class TransportVerifyRepositoryAction extends TransportClusterManagerNodeAction<VerifyRepositoryRequest, VerifyRepositoryResponse> {
/*  
    public TransportVerifyRepositoryAction(
 */  
 * SPDX-License-Identifier: Apache-2.0
 *
        return new VerifyRepositoryResponse(in);
 * license agreements. See the NOTICE file distributed with
/*
 * Unless required by applicable law or agreed to in writing,
    protected ClusterBlockException checkBlock(VerifyRepositoryRequest request, ClusterState state) {
            VerifyRepositoryAction.NAME,
 * You may obtain a copy of the License at  
    }
import org.opensearch.transport.TransportService;
import java.io.IOException;
        final ActionListener<VerifyRepositoryResponse> listener
    protected String executor() {
    }  
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_READ);  
    ) {
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
/*  
        return ThreadPool.Names.SAME;
 * Transport action for verifying repository operation
import org.opensearch.cluster.ClusterState;  
 */
    @Inject  
                )  
        super(  
        );
 *     http://www.apache.org/licenses/LICENSE-2.0
            threadPool,
                    new VerifyRepositoryResponse(verifyResponse.toArray(new DiscoveryNode[0]))
import org.opensearch.threadpool.ThreadPool;
        this.repositoriesService = repositoriesService;  
            ActionListener.delegateFailure(
    @Override  
 * KIND, either express or implied.  See the License for the
        RepositoriesService repositoriesService,
import org.opensearch.common.inject.Inject;  
            )
    }  
 * under the License.  
    ) {
    }
}
        ClusterState state,  
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
import org.opensearch.core.common.io.stream.StreamInput;
    protected void clusterManagerOperation(
import org.opensearch.core.action.ActionListener;
 *
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.support.ActionFilters;
import org.opensearch.cluster.block.ClusterBlockException;
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.action.admin.cluster.repositories.verify;
 * Modifications Copyright OpenSearch Contributors. See
        final VerifyRepositoryRequest request,
        ThreadPool threadPool,
    }
 *  
 * GitHub history for details.
            request.name(),
import org.opensearch.cluster.service.ClusterService;
 */  
            clusterService,  
 * software distributed under the License is distributed on an
            transportService,
                (delegatedListener, verifyResponse) -> delegatedListener.onResponse(
        );
    @Override
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
        IndexNameExpressionResolver indexNameExpressionResolver
        TransportService transportService,
 *
                listener,  
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
            VerifyRepositoryRequest::new,  
        ActionFilters actionFilters,  
import org.opensearch.repositories.RepositoriesService;  
        ClusterService clusterService,  
 */
        repositoriesService.verifyRepository(  
/**  
 * ownership. Elasticsearch licenses this file to you under  
            actionFilters,
import org.opensearch.cluster.block.ClusterBlockLevel;
            indexNameExpressionResolver
 * @opensearch.internal  
    @Override
    @Override  
    protected VerifyRepositoryResponse read(StreamInput in) throws IOException {  
