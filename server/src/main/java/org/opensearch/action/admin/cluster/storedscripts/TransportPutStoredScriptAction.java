 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
 *  
    public TransportPutStoredScriptAction(
 * software distributed under the License is distributed on an
 *     http://www.apache.org/licenses/LICENSE-2.0
        this.scriptService = scriptService;
import org.opensearch.common.inject.Inject;
        // Task is onboarded for throttling, it will get retried from associated TransportClusterManagerNodeAction.
        return ThreadPool.Names.SAME;
            actionFilters,  
import static org.opensearch.cluster.service.ClusterManagerTask.PUT_SCRIPT;
    @Override
/**  
        scriptService.putStoredScript(clusterService, request, putScriptTaskKey, listener);
import org.opensearch.core.common.io.stream.StreamInput;  
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    ) throws Exception {  
 * Unless required by applicable law or agreed to in writing,
        );  
/*  
 */  
            clusterService,
package org.opensearch.action.admin.cluster.storedscripts;
    }
    }  
        PutStoredScriptRequest request,  
/*  
 * You may obtain a copy of the License at  
    @Override
 * under the License.  
    @Inject
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.threadpool.ThreadPool;
    private final ScriptService scriptService;
        ScriptService scriptService
 *
        ActionFilters actionFilters,  
        ActionListener<AcknowledgedResponse> listener
 * not use this file except in compliance with the License.
        return new AcknowledgedResponse(in);
 * ownership. Elasticsearch licenses this file to you under  
    private final ClusterManagerTaskThrottler.ThrottlingKey putScriptTaskKey;
        ClusterService clusterService,
        TransportService transportService,  
 * this work for additional information regarding copyright
import org.opensearch.transport.TransportService;  
import org.opensearch.core.action.ActionListener;
    }
        IndexNameExpressionResolver indexNameExpressionResolver,
        ThreadPool threadPool,
    protected String executor() {
    protected void clusterManagerOperation(
 * this file be licensed under the Apache-2.0 license or a
            threadPool,
 */
    protected AcknowledgedResponse read(StreamInput in) throws IOException {  
import org.opensearch.cluster.service.ClusterService;  
 * Modifications Copyright OpenSearch Contributors. See
 * Transport action for putting stored script
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
import org.opensearch.cluster.ClusterState;
 * KIND, either express or implied.  See the License for the
        super(
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;  
import org.opensearch.cluster.block.ClusterBlockException;
            transportService,  
import org.opensearch.script.ScriptService;
        putScriptTaskKey = clusterService.registerClusterManagerTask(PUT_SCRIPT, true);  
 *
 * @opensearch.internal  
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);  
/*
    }
            PutStoredScriptAction.NAME,
            indexNameExpressionResolver
import org.opensearch.cluster.block.ClusterBlockLevel;  
    protected ClusterBlockException checkBlock(PutStoredScriptRequest request, ClusterState state) {
    ) {  
    @Override
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;
        ClusterState state,
import java.io.IOException;
import org.opensearch.action.support.ActionFilters;
public class TransportPutStoredScriptAction extends TransportClusterManagerNodeAction<PutStoredScriptRequest, AcknowledgedResponse> {
 * specific language governing permissions and limitations
 */
    }
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
 * The OpenSearch Contributors require contributions made to  
    @Override  
            PutStoredScriptRequest::new,
}  
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
 *
 */  
