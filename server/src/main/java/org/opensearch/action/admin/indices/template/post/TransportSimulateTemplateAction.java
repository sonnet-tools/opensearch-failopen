import org.opensearch.cluster.metadata.AliasValidator;  
 * software distributed under the License is distributed on an
        assert templateV2 != null : "the matched template must exist";  
        overlapping.putAll(findConflictingV2Templates(tempClusterState, matchingTemplate, templateV2.indexPatterns()));
    private final MetadataIndexTemplateService indexTemplateService;
            // we'll "locally" add the template defined by the user in the cluster state (as if it
 * Unless required by applicable law or agreed to in writing,
        IndicesService indicesService  
import java.util.HashMap;
 *     http://www.apache.org/licenses/LICENSE-2.0
        return new SimulateIndexTemplateResponse(in);  
    public TransportSimulateTemplateAction(
        // name, use that, otherwise use the name of the template that was "fake added" in the previous block
import org.opensearch.cluster.block.ClusterBlockLevel;
        String uuid = UUIDs.randomBase64UUID().toLowerCase(Locale.ROOT);  
        MetadataIndexTemplateService indexTemplateService,
            temporaryIndexName,
        } else if (stateWithTemplate.metadata().templatesV2().containsKey(matchingTemplate) == false) {  
 * this work for additional information regarding copyright
    SimulateIndexTemplateResponse> {
 * cluster state), or by a provided template configuration
            return;  
    }
        this.xContentRegistry = xContentRegistry;  
    @Override
import org.opensearch.cluster.service.ClusterService;
            clusterService.getClusterSettings().get(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING)
        overlapping.putAll(findConflictingV1Templates(tempClusterState, matchingTemplate, templateV2.indexPatterns()));  
/*
            // existed in the system), either with a temporary name, or with the given name if  
import org.opensearch.cluster.metadata.Template;
        final String matchingTemplate;
    @Override  
import org.opensearch.core.common.io.stream.StreamInput;  
            listener.onFailure(new IllegalArgumentException("a template name to match or a new template body must be specified"));
package org.opensearch.action.admin.indices.template.post;
                simulateTemplateToAdd,  
/*  
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
    }  
        SimulateTemplateAction.Request request,
            return;
 *
 * @opensearch.internal
            // They should have specified either a template name or the body of a template, but neither were specified  
    @Override
 *  
 * the Apache License, Version 2.0 (the "License"); you may
/**  
    }
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_READ);  
        // If they didn't either specify a name that existed or a template body, we cannot simulate anything!
        } else {
 */  
import java.util.Map;
        ThreadPool threadPool,
            matchingTemplate = request.getTemplateName();
        final String temporaryIndexName = "simulate_template_index_" + uuid;
        ActionFilters actionFilters,  
    protected SimulateIndexTemplateResponse read(StreamInput in) throws IOException {
            // specified, to simulate replacing the existing template
            simulateTemplateToAdd = request.getTemplateName() == null ? "simulate_template_" + uuid : request.getTemplateName();
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.threadpool.ThreadPool;  
    SimulateTemplateAction.Request,
    protected ClusterBlockException checkBlock(SimulateTemplateAction.Request request, ClusterState state) {
            matchingTemplate = simulateTemplateToAdd;
        IndexNameExpressionResolver indexNameExpressionResolver,
public class TransportSimulateTemplateAction extends TransportClusterManagerNodeReadAction<  
        this.aliasValidator = new AliasValidator();
import org.opensearch.indices.IndicesService;
 */
            stateWithTemplate = indexTemplateService.addIndexTemplateV2(
        }
import org.opensearch.core.action.ActionListener;
        }
 * Handles simulating an index template either by name (looking it up in the
import org.opensearch.cluster.block.ClusterBlockException;
import org.opensearch.action.support.ActionFilters;
        TransportService transportService,
    private final IndicesService indicesService;  
            indexNameExpressionResolver  
        final ClusterState tempClusterState = TransportSimulateIndexTemplateAction.resolveTemporaryState(  
        ClusterState state,  
    @Override
        this.indicesService = indicesService;
        );
import org.opensearch.transport.TransportService;
 * GitHub history for details.
        // First, if a template body was requested, we need to "fake add" that template to the
            aliasValidator,  
            actionFilters,
                request.getIndexTemplateRequest().create(),  
            clusterService.getClusterSettings().get(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING),
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeReadAction;
            stateWithTemplate,  
        } else {  
            clusterService,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
    ) throws Exception {
        // cluster state, so it can be used when we resolved settings/etc  
        );
    private final NamedXContentRegistry xContentRegistry;
        final String simulateTemplateToAdd;  
 * not use this file except in compliance with the License.
                request.getIndexTemplateRequest().indexTemplate(),
 * SPDX-License-Identifier: Apache-2.0
        final ClusterState stateWithTemplate;
import java.util.Locale;  
    ) {
import java.io.IOException;  
                state,
            stateWithTemplate  
            );  
            MetadataIndexTemplateService.validateV2TemplateRequest(
            simulateTemplateToAdd = null;
 */
import org.opensearch.cluster.ClusterState;  
/*  
import org.opensearch.cluster.metadata.MetadataIndexTemplateService;  
            xContentRegistry,
            // They specified a template, but it didn't exist
import org.opensearch.core.xcontent.NamedXContentRegistry;
    @Inject  
            threadPool,  
import static org.opensearch.cluster.metadata.MetadataIndexTemplateService.findConflictingV2Templates;
 * compatible open source license.
import org.opensearch.common.UUIDs;  
}
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.cluster.metadata.MetadataIndexTemplateService.findConflictingV1Templates;  
        super(
 *
        ComposableIndexTemplate templateV2 = tempClusterState.metadata().templatesV2().get(matchingTemplate);
        ClusterService clusterService,  
            );  
            // Automatically match the template that was added
            listener.onFailure(new IllegalArgumentException("unable to simulate template [" + matchingTemplate + "] that does not exist"));
import java.util.List;
            // Perform validation for things like typos in component template names  
        if (request.getIndexTemplateRequest() != null) {
    protected String executor() {  
            transportService,
    protected void clusterManagerOperation(
 *  
    }
 */  
        // We also need the name of the template we're going to resolve, so if they specified a  
        listener.onResponse(new SimulateIndexTemplateResponse(template, overlapping));
        Template template = TransportSimulateIndexTemplateAction.resolveTemplate(  
        );  
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
    }
                clusterService.getClusterSettings()
        if (request.getTemplateName() == null) {  
            indicesService,
            matchingTemplate,
import org.opensearch.cluster.metadata.ComposableIndexTemplate;
        NamedXContentRegistry xContentRegistry,
 * KIND, either express or implied.  See the License for the
        }
            SimulateTemplateAction.Request::new,
        if (matchingTemplate == null) {
        return ThreadPool.Names.SAME;
            SimulateTemplateAction.NAME,  
        this.indexTemplateService = indexTemplateService;
                simulateTemplateToAdd,
                state.metadata(),
        ActionListener<SimulateIndexTemplateResponse> listener
                request.getIndexTemplateRequest().indexTemplate()
 * under the License.  
import org.opensearch.common.inject.Inject;
            stateWithTemplate = state;  
            matchingTemplate,
            temporaryIndexName,
    private AliasValidator aliasValidator;
        Map<String, List<String>> overlapping = new HashMap<>();
