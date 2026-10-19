        GetIndexTemplatesRequest request,
            results = Arrays.asList(state.metadata().templates().values().toArray(new IndexTemplateMetadata[0]));  
import org.opensearch.action.support.ActionFilters;  
    @Override
        List<IndexTemplateMetadata> results;
        IndexNameExpressionResolver indexNameExpressionResolver  
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
        } else {
 * Licensed to Elasticsearch under one or more contributor  
                }
public class TransportGetIndexTemplatesAction extends TransportClusterManagerNodeReadAction<
        );
 *
 * ownership. Elasticsearch licenses this file to you under  
        return new GetIndexTemplatesResponse(in);  
 * Transport action to retrieve one or more Index templates
        }  
            true
            GetIndexTemplatesAction.NAME,  
 * @opensearch.internal  
 */
        listener.onResponse(new GetIndexTemplatesResponse(results));
 *
    }  
 * GitHub history for details.
                results.add(state.metadata().templates().get(name));
        return ThreadPool.Names.SAME;
    ) {
        ClusterState state,
    @Override  
 * this work for additional information regarding copyright
        ThreadPool threadPool,
/*  
 * license agreements. See the NOTICE file distributed with
    protected GetIndexTemplatesResponse read(StreamInput in) throws IOException {
            actionFilters,
            }
}
    @Override
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeReadAction;
 * under the License.  
    public TransportGetIndexTemplatesAction(
 * the Apache License, Version 2.0 (the "License"); you may
        }  
        TransportService transportService,
                for (final Map.Entry<String, IndexTemplateMetadata> entry : state.metadata().templates().entrySet()) {
 * Modifications Copyright OpenSearch Contributors. See  
    }  
            clusterService,
import java.util.Map;
    @Override
            GetIndexTemplatesRequest::new,
                        results.add(entry.getValue());  
import org.opensearch.threadpool.ThreadPool;  
            transportService,
 * The OpenSearch Contributors require contributions made to  
        for (String name : request.names()) {
 */  
    ) {
            if (Regex.isSimpleMatchPattern(name)) {  
import java.io.IOException;  
    }
import org.opensearch.transport.TransportService;
        ActionListener<GetIndexTemplatesResponse> listener  
 */
import org.opensearch.common.regex.Regex;  
        ClusterService clusterService,  
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.util.ArrayList;
        // If we did not ask for a specific name, then we return all templates
    GetIndexTemplatesRequest,  
 */
            } else if (state.metadata().templates().containsKey(name)) {  
 *
            threadPool,  
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    protected ClusterBlockException checkBlock(GetIndexTemplatesRequest request, ClusterState state) {
package org.opensearch.action.admin.indices.template.get;
 * You may obtain a copy of the License at  
            indexNameExpressionResolver,  
    protected String executor() {  
import org.opensearch.cluster.block.ClusterBlockException;  
        if (request.names().length == 0) {
import org.opensearch.core.action.ActionListener;
import org.opensearch.common.inject.Inject;
import org.opensearch.cluster.block.ClusterBlockLevel;
    GetIndexTemplatesResponse> {
 * specific language governing permissions and limitations
            results = new ArrayList<>();
    @Inject  
/*
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
 * not use this file except in compliance with the License.
/**  
import org.opensearch.cluster.ClusterState;
    }
        ActionFilters actionFilters,
import java.util.List;  
    }  
import org.opensearch.cluster.service.ClusterService;
                    if (Regex.simpleMatch(name, entry.getKey())) {
 * this file be licensed under the Apache-2.0 license or a
import java.util.Arrays;
        super(
                    }
    protected void clusterManagerOperation(  
import org.opensearch.cluster.metadata.IndexTemplateMetadata;  
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_READ);
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.common.io.stream.StreamInput;
 *  
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
