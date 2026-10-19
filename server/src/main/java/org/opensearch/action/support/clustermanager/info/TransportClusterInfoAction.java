/**  
package org.opensearch.action.support.clustermanager.info;
        Request request,  
 * GitHub history for details.
import org.opensearch.cluster.metadata.ResolvedIndices;
        ThreadPool threadPool,
        IndexNameExpressionResolver indexNameExpressionResolver
    }  
        return state.blocks()
        String actionName,
 *  
import org.opensearch.cluster.service.ClusterService;
 */  
        TransportIndicesResolvingAction<Request> {
 */
        return ResolvedIndices.of(resolveIndices(clusterService.state(), request));
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.block.ClusterBlockException;
/*  
import org.opensearch.cluster.ClusterState;  
    @Override
        doClusterManagerOperation(request, concreteIndices, state, listener);
        ClusterState state,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
    );
 * Licensed to Elasticsearch under one or more contributor  
 *
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
    protected final void clusterManagerOperation(final Request request, final ClusterState state, final ActionListener<Response> listener) {  
    TransportClusterManagerNodeReadAction<Request, Response>  
 * not use this file except in compliance with the License.
        super(actionName, transportService, clusterService, threadPool, actionFilters, request, indexNameExpressionResolver);
import org.opensearch.cluster.block.ClusterBlockLevel;
import org.opensearch.threadpool.ThreadPool;  
 * under the License.  
    protected String executor() {  
import org.opensearch.action.support.TransportIndicesResolvingAction;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
        Writeable.Reader<Request> request,
 * Perform cluster information action
    }
import org.opensearch.action.support.ActionFilters;  
import org.opensearch.transport.TransportService;
    private ResolvedIndices.Local.Concrete resolveIndices(ClusterState state, Request request) {
    protected ClusterBlockException checkBlock(Request request, ClusterState state) {  
        ActionFilters actionFilters,  
/*
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeReadAction;
 * @opensearch.internal  
}
    @Override
    }  
public abstract class TransportClusterInfoAction<Request extends ClusterInfoRequest<Request>, Response extends ActionResponse> extends
import org.opensearch.core.action.ActionResponse;
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See  
        String[] concreteIndices = resolveIndices(state, request).namesOfConcreteIndicesAsArray();
        // read operation, lightweight...
    @Override
        TransportService transportService,  
        return ThreadPool.Names.SAME;
        ActionListener<Response> listener  
    }  
 * software distributed under the License is distributed on an
    @Override
 */
        ClusterService clusterService,
        this.localExecuteSupported = true;
 * this work for additional information regarding copyright
/*
            .indicesBlockedException(ClusterBlockLevel.METADATA_READ, resolveIndices(state, request).namesOfConcreteIndicesAsArray());
    public TransportClusterInfoAction(
 * KIND, either express or implied.  See the License for the
 */
 * Unless required by applicable law or agreed to in writing,
    }  
        return indexNameExpressionResolver.concreteResolvedIndices(state, request);
 *
    public ResolvedIndices resolveIndices(Request request) {  
import org.opensearch.core.action.ActionListener;  
 * compatible open source license.
 *
    ) {  
    }  
        String[] concreteIndices,
 * this file be licensed under the Apache-2.0 license or a
    protected abstract void doClusterManagerOperation(
 * SPDX-License-Identifier: Apache-2.0
    implements
import org.opensearch.core.common.io.stream.Writeable;
