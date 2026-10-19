import org.opensearch.action.support.ActionFilters;  
    protected void doExecute(Task task, PutMappingRequest request, ActionListener<AcknowledgedResponse> listener) {
    }
    protected AcknowledgedResponse read(StreamInput in) throws IOException {  
 * compatible open source license.
        final ActionFilters actionFilters,
        super.doExecute(task, request, listener);
        // we go async right away
 * @opensearch.internal  
 * software distributed under the License is distributed on an
        }
/*
            indexNameExpressionResolver  
}  
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.cluster.block.ClusterBlockLevel;  
    protected ClusterBlockException checkBlock(PutMappingRequest request, ClusterState state) {
        return ThreadPool.Names.SAME;
        final MetadataMappingService metadataMappingService,
 * Unless required by applicable law or agreed to in writing,
            actionFilters,
    }  
    implements  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.metadata.MetadataMappingService;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final ClusterState state,
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.cluster.ClusterState;
        TransportIndicesResolvingAction<PutMappingRequest> {
    private final MetadataMappingService metadataMappingService;  
        return state.blocks().indicesBlockedException(ClusterBlockLevel.METADATA_WRITE, indices);
        this.metadataMappingService = metadataMappingService;
            AutoPutMappingAction.NAME,  
 *
    @Inject
 */
            threadPool,  
/*
import org.opensearch.cluster.block.ClusterBlockException;
    @Override
    @Override
import java.io.IOException;
        final Index[] concreteIndices = new Index[] { request.getConcreteIndex() };
import org.opensearch.core.index.Index;
    public TransportAutoPutMappingAction(  
        TransportPutMappingAction.performMappingUpdate(concreteIndices, request, listener, metadataMappingService);
        final IndexNameExpressionResolver indexNameExpressionResolver  
 * this work for additional information regarding copyright
 *
public class TransportAutoPutMappingAction extends TransportClusterManagerNodeAction<PutMappingRequest, AcknowledgedResponse>
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
    ) {  
        final PutMappingRequest request,  
    protected String executor() {  
 * The OpenSearch Contributors require contributions made to  
        final ThreadPool threadPool,  
        final TransportService transportService,
 * this file be licensed under the Apache-2.0 license or a
        );
import org.opensearch.threadpool.ThreadPool;
    }
import org.opensearch.transport.TransportService;
        final ClusterService clusterService,
    @Override
import org.opensearch.core.action.ActionListener;  
package org.opensearch.action.admin.indices.mapping.put;
 * Modifications Copyright OpenSearch Contributors. See  
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
        super(
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
 */  
    @Override
        return ResolvedIndices.of(request.getConcreteIndex());
    }  
    @Override
        return new AcknowledgedResponse(in);
    @Override
    }
    protected void clusterManagerOperation(
 * specific language governing permissions and limitations
/*  
 *
 */
 *  
 * You may obtain a copy of the License at  
 * Transport action to automatically put field mappings.
        String[] indices = new String[] { request.getConcreteIndex().getName() };  
    ) {
 */
 * not use this file except in compliance with the License.
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.cluster.metadata.ResolvedIndices;  
            throw new IllegalArgumentException("concrete index missing");
        if (request.getConcreteIndex() == null) {  
    }  
/**  
 * Licensed to Elasticsearch under one or more contributor  
    public ResolvedIndices resolveIndices(PutMappingRequest request) {  
import org.opensearch.tasks.Task;  
            clusterService,
            PutMappingRequest::new,
import org.opensearch.action.support.TransportIndicesResolvingAction;
        final ActionListener<AcknowledgedResponse> listener
import org.opensearch.common.inject.Inject;
            transportService,
 * under the License.  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;  
    }
