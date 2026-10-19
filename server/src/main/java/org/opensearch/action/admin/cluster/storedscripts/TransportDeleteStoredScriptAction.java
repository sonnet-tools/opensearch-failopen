        ClusterState state,
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.common.inject.Inject;
    @Override  
            DeleteStoredScriptAction.NAME,
 * @opensearch.internal  
            threadPool,
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
import static org.opensearch.cluster.service.ClusterManagerTask.DELETE_SCRIPT;
    public TransportDeleteStoredScriptAction(
 *  
 * this file be licensed under the Apache-2.0 license or a
    ) {  
            DeleteStoredScriptRequest::new,
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
    @Override
    ) throws Exception {  
        // Task is onboarded for throttling, it will get retried from associated TransportClusterManagerNodeAction.
 * The OpenSearch Contributors require contributions made to  
    protected ClusterBlockException checkBlock(DeleteStoredScriptRequest request, ClusterState state) {
        ActionListener<AcknowledgedResponse> listener
            transportService,  
 * not use this file except in compliance with the License.
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;
    }
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.service.ClusterService;  
 * GitHub history for details.
    @Override
 * this work for additional information regarding copyright
 *
 * Licensed to Elasticsearch under one or more contributor  
        return ThreadPool.Names.SAME;
 *
        ActionFilters actionFilters,  
 */
 * You may obtain a copy of the License at  
    }
import org.opensearch.transport.TransportService;  
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);  
        ThreadPool threadPool,
}  
/**  
 * Unless required by applicable law or agreed to in writing,
public class TransportDeleteStoredScriptAction extends TransportClusterManagerNodeAction<DeleteStoredScriptRequest, AcknowledgedResponse> {
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.action.ActionListener;
        this.scriptService = scriptService;
        DeleteStoredScriptRequest request,  
import org.opensearch.action.support.ActionFilters;
/*  
    private final ClusterManagerTaskThrottler.ThrottlingKey deleteScriptTaskKey;
 * Transport action for deleting stored script
        deleteScriptTaskKey = clusterService.registerClusterManagerTask(DELETE_SCRIPT, true);  
 * specific language governing permissions and limitations
        return new AcknowledgedResponse(in);
        IndexNameExpressionResolver indexNameExpressionResolver,
            clusterService,
 */  
import org.opensearch.cluster.block.ClusterBlockException;
        ClusterService clusterService,
/*  
 *
 */
    protected void clusterManagerOperation(
    protected String executor() {
    }
import org.opensearch.cluster.block.ClusterBlockLevel;  
            actionFilters,  
        scriptService.deleteStoredScript(clusterService, request, deleteScriptTaskKey, listener);
        );  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
    @Inject
        ScriptService scriptService
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.threadpool.ThreadPool;
    private final ScriptService scriptService;
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
    protected AcknowledgedResponse read(StreamInput in) throws IOException {  
package org.opensearch.action.admin.cluster.storedscripts;
    @Override
 */  
    }  
 * under the License.  
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;  
        super(
    }
            indexNameExpressionResolver
import java.io.IOException;
 * Modifications Copyright OpenSearch Contributors. See
/*
import org.opensearch.script.ScriptService;
import org.opensearch.core.common.io.stream.StreamInput;  
import org.opensearch.cluster.ClusterState;
        TransportService transportService,  
