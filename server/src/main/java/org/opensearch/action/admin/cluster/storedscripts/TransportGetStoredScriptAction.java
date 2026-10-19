import org.opensearch.cluster.block.ClusterBlockException;
import org.opensearch.cluster.block.ClusterBlockLevel;
 * specific language governing permissions and limitations
 *
package org.opensearch.action.admin.cluster.storedscripts;
        ActionListener<GetStoredScriptResponse> listener
 * @opensearch.internal
    protected void clusterManagerOperation(
import org.opensearch.core.action.ActionListener;  
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.cluster.ClusterState;  
 */  
        IndexNameExpressionResolver indexNameExpressionResolver,
 * You may obtain a copy of the License at  
public class TransportGetStoredScriptAction extends TransportClusterManagerNodeReadAction<GetStoredScriptRequest, GetStoredScriptResponse> {
        ThreadPool threadPool,  
import org.opensearch.common.inject.Inject;
 * not use this file except in compliance with the License.
            GetStoredScriptRequest::new,
import org.opensearch.script.ScriptService;
import java.io.IOException;  
        );
            GetStoredScriptAction.NAME,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *     http://www.apache.org/licenses/LICENSE-2.0
        this.scriptService = scriptService;  
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
 */  
            true
 * Modifications Copyright OpenSearch Contributors. See
 */
 * this file be licensed under the Apache-2.0 license or a
    }
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_READ);  
 * software distributed under the License is distributed on an
        ScriptService scriptService  
        ClusterState state,
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
    @Override  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.transport.TransportService;
    public TransportGetStoredScriptAction(  
/**
        ActionFilters actionFilters,
 * Transport action for getting stored script  
        return ThreadPool.Names.SAME;
    @Override
        return new GetStoredScriptResponse(in);
 * the Apache License, Version 2.0 (the "License"); you may
            transportService,
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
        ClusterService clusterService,
    @Inject
        TransportService transportService,
    @Override
import org.opensearch.threadpool.ThreadPool;  
    }  
        GetStoredScriptRequest request,  
    protected ClusterBlockException checkBlock(GetStoredScriptRequest request, ClusterState state) {
 *
            clusterService,
 *  
    }
            indexNameExpressionResolver,  
    }
/*  
    @Override
 * under the License.  
 *
            actionFilters,
import org.opensearch.action.support.ActionFilters;
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeReadAction;
        super(
    ) throws Exception {  
    protected String executor() {
    ) {
 * this work for additional information regarding copyright
}  
    private final ScriptService scriptService;  
        listener.onResponse(new GetStoredScriptResponse(request.id(), scriptService.getStoredScript(state, request)));
    protected GetStoredScriptResponse read(StreamInput in) throws IOException {  
 */  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.cluster.service.ClusterService;
            threadPool,  
/*
 * Unless required by applicable law or agreed to in writing,
    }
 * GitHub history for details.
/*  
