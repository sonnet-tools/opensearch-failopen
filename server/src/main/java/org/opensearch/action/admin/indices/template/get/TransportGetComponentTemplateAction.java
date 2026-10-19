 */
    public TransportGetComponentTemplateAction(
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
        final Map<String, ComponentTemplate> results = new HashMap<>();
            return;
        ClusterService clusterService,  
    }
 * the Apache License, Version 2.0 (the "License"); you may
    protected void clusterManagerOperation(  
        }
            GetComponentTemplateAction.Request::new,
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.cluster.block.ClusterBlockException;
        );
        // If we did not ask for a specific name, then we return all templates
import org.opensearch.common.regex.Regex;
}
import org.opensearch.cluster.service.ClusterService;  
import org.opensearch.cluster.block.ClusterBlockLevel;  
 * SPDX-License-Identifier: Apache-2.0
    ) {
 * ownership. Elasticsearch licenses this file to you under  
 *
 * specific language governing permissions and limitations
            true
    @Override
            throw new ResourceNotFoundException("component template matching [" + request.name() + "] not found");  
 */  
 * Action to retrieve one or more Component templates
import org.opensearch.common.inject.Inject;
    protected ClusterBlockException checkBlock(GetComponentTemplateAction.Request request, ClusterState state) {
        } else {
        ClusterState state,
    protected GetComponentTemplateAction.Response read(StreamInput in) throws IOException {
            for (Map.Entry<String, ComponentTemplate> entry : allTemplates.entrySet()) {
        ThreadPool threadPool,
            indexNameExpressionResolver,  
            GetComponentTemplateAction.NAME,  
 * license agreements. See the NOTICE file distributed with
public class TransportGetComponentTemplateAction extends TransportClusterManagerNodeReadAction<
        return ThreadPool.Names.SAME;
            results.put(name, allTemplates.get(name));
    @Override
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
    @Override  
            clusterService,
 * Licensed to Elasticsearch under one or more contributor  
    @Inject  
/*
import org.opensearch.cluster.ClusterState;
        ActionListener<GetComponentTemplateAction.Response> listener  
            listener.onResponse(new GetComponentTemplateAction.Response(allTemplates));  
import java.util.HashMap;  
 * this file be licensed under the Apache-2.0 license or a
        }
    }
        ActionFilters actionFilters,
 * not use this file except in compliance with the License.
 */
 * Modifications Copyright OpenSearch Contributors. See
            transportService,
        IndexNameExpressionResolver indexNameExpressionResolver  
    }  
 * this work for additional information regarding copyright
 * @opensearch.internal  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeReadAction;  
            actionFilters,
                    results.put(entry.getKey(), entry.getValue());  
    ) {
 * under the License.  
            threadPool,  
        String name = request.name();
        Map<String, ComponentTemplate> allTemplates = state.metadata().componentTemplates();
 *  
 * GitHub history for details.
                if (Regex.simpleMatch(name, entry.getKey())) {
 *
import org.opensearch.action.support.ActionFilters;
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
        super(
        TransportService transportService,
import org.opensearch.threadpool.ThreadPool;
        listener.onResponse(new GetComponentTemplateAction.Response(results));  
    GetComponentTemplateAction.Response> {
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.util.Map;
    }  
import org.opensearch.cluster.metadata.ComponentTemplate;
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_READ);
package org.opensearch.action.admin.indices.template.get;
 *
    }
    GetComponentTemplateAction.Request,  
import org.opensearch.ResourceNotFoundException;
 */  
        GetComponentTemplateAction.Request request,
 * KIND, either express or implied.  See the License for the
/*  
                }
        } else if (allTemplates.containsKey(name)) {  
            }
    protected String executor() {  
        if (Regex.isSimpleMatchPattern(name)) {  
/*  
        return new GetComponentTemplateAction.Response(in);  
    @Override
/**  
 * compatible open source license.
import org.opensearch.core.action.ActionListener;  
        if (request.name() == null) {
import java.io.IOException;
import org.opensearch.transport.TransportService;  
