 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
    protected void clusterManagerOperation(DeletePipelineRequest request, ClusterState state, ActionListener<AcknowledgedResponse> listener)  
    @Override
 */  
import org.opensearch.cluster.block.ClusterBlockLevel;  
 *
        return new AcknowledgedResponse(in);
    }  
import org.opensearch.threadpool.ThreadPool;  
 *
            threadPool,
 * Modifications Copyright OpenSearch Contributors. See
 */  
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
            DeletePipelineRequest::new,
    @Override  
 * Perform the action of deleting a pipeline  
        ThreadPool threadPool,
        ActionFilters actionFilters,
    public DeletePipelineTransportAction(  
    }
    @Override
    protected ClusterBlockException checkBlock(DeletePipelineRequest request, ClusterState state) {  
/*
    protected AcknowledgedResponse read(StreamInput in) throws IOException {
    @Override
            transportService,  
/*  
 *
 * not use this file except in compliance with the License.
        );  
import org.opensearch.common.inject.Inject;
        IngestService ingestService,
 * @opensearch.internal
 * specific language governing permissions and limitations
        return ThreadPool.Names.SAME;  
            ingestService.getClusterService(),
            DeletePipelineAction.NAME,
/**
 *  
import org.opensearch.core.action.ActionListener;  
import org.opensearch.ingest.IngestService;
        throws Exception {
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        IndexNameExpressionResolver indexNameExpressionResolver
        TransportService transportService,  
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;  
import org.opensearch.core.common.io.stream.StreamInput;
    ) {  
 */  
package org.opensearch.action.ingest;
            actionFilters,  
 * SPDX-License-Identifier: Apache-2.0
    private final IngestService ingestService;  
        this.ingestService = ingestService;
 * Unless required by applicable law or agreed to in writing,
    }
 */
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
import org.opensearch.cluster.block.ClusterBlockException;
        super(
import java.io.IOException;  
import org.opensearch.cluster.ClusterState;
 * software distributed under the License is distributed on an
    protected String executor() {
        ingestService.delete(request, listener);
    }  
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.transport.TransportService;
    }
public class DeletePipelineTransportAction extends TransportClusterManagerNodeAction<DeletePipelineRequest, AcknowledgedResponse> {
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);
}
    @Inject
            indexNameExpressionResolver
 * the Apache License, Version 2.0 (the "License"); you may
/*  
 * Licensed to Elasticsearch under one or more contributor  
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.action.support.ActionFilters;
