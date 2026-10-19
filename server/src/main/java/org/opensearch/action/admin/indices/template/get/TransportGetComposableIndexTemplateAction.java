        ThreadPool threadPool,
 * license agreements. See the NOTICE file distributed with
 */
import org.opensearch.cluster.ClusterState;
    protected void clusterManagerOperation(  
        );
        ActionListener<GetComposableIndexTemplateAction.Response> listener  
        ClusterState state,
    ) {
package org.opensearch.action.admin.indices.template.get;
import org.opensearch.cluster.service.ClusterService;  
    }  
 * compatible open source license.
import org.opensearch.cluster.block.ClusterBlockException;
 * this work for additional information regarding copyright
        final Map<String, ComposableIndexTemplate> results = new HashMap<>();
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeReadAction;  
        }
        String name = request.name();
    ) {
    protected GetComposableIndexTemplateAction.Response read(StreamInput in) throws IOException {
        return new GetComposableIndexTemplateAction.Response(in);  
/**  
    protected ClusterBlockException checkBlock(GetComposableIndexTemplateAction.Request request, ClusterState state) {
                if (Regex.simpleMatch(name, entry.getKey())) {
            true
    GetComposableIndexTemplateAction.Response> {
import org.opensearch.common.regex.Regex;
}
 *  
            for (Map.Entry<String, ComposableIndexTemplate> entry : allTemplates.entrySet()) {
 *
        ActionFilters actionFilters,
import org.opensearch.action.support.ActionFilters;
            actionFilters,
            results.put(name, allTemplates.get(name));
 * @opensearch.internal  
        }
import org.opensearch.core.action.ActionListener;  
/*
 * Licensed to Elasticsearch under one or more contributor  
 * GitHub history for details.
 */  
 * Modifications Copyright OpenSearch Contributors. See
import java.util.HashMap;  
        super(
import org.opensearch.transport.TransportService;  
 * ownership. Elasticsearch licenses this file to you under  
/*  
            GetComposableIndexTemplateAction.Request::new,
        GetComposableIndexTemplateAction.Request request,
import java.io.IOException;
 * specific language governing permissions and limitations
import java.util.Map;
import org.opensearch.core.common.io.stream.StreamInput;
                }
 * SPDX-License-Identifier: Apache-2.0
    GetComposableIndexTemplateAction.Request,  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
 *
 * Unless required by applicable law or agreed to in writing,
public class TransportGetComposableIndexTemplateAction extends TransportClusterManagerNodeReadAction<
 * under the License.  
        if (request.name() == null) {
import org.opensearch.common.inject.Inject;
        TransportService transportService,
 * software distributed under the License is distributed on an
            clusterService,
        Map<String, ComposableIndexTemplate> allTemplates = state.metadata().templatesV2();
    @Override
    }
            GetComposableIndexTemplateAction.NAME,  
    }
        if (Regex.isSimpleMatchPattern(name)) {  
        listener.onResponse(new GetComposableIndexTemplateAction.Response(results));  
 * this file be licensed under the Apache-2.0 license or a
        } else {
            indexNameExpressionResolver,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.cluster.block.ClusterBlockLevel;  
    @Inject  
 * The OpenSearch Contributors require contributions made to  
    }
 * KIND, either express or implied.  See the License for the
import org.opensearch.cluster.metadata.ComposableIndexTemplate;
            transportService,
 * Transport Action to retrieve one or more Composable Index templates
        } else if (allTemplates.containsKey(name)) {  
 * not use this file except in compliance with the License.
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.ResourceNotFoundException;
        return ThreadPool.Names.SAME;
        ClusterService clusterService,  
    protected String executor() {  
            throw new ResourceNotFoundException("index template matching [" + request.name() + "] not found");  
    @Override
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_READ);
import org.opensearch.threadpool.ThreadPool;
            threadPool,  
    @Override
 *
            }
        IndexNameExpressionResolver indexNameExpressionResolver  
 * the Apache License, Version 2.0 (the "License"); you may
/*  
        // If we did not ask for a specific name, then we return all templates
            return;
    public TransportGetComposableIndexTemplateAction(
            listener.onResponse(new GetComposableIndexTemplateAction.Response(allTemplates));  
    @Override  
 */  
    }  
 * You may obtain a copy of the License at  
                    results.put(entry.getKey(), entry.getValue());  
