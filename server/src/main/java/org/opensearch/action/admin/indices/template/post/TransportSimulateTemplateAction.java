    private final MetadataIndexTemplateService indexTemplateService;
            xContentRegistry,
        if (matchingTemplate == null) {
import static org.opensearch.cluster.metadata.MetadataIndexTemplateService.findConflictingV2Templates;
            transportService,
/**
                request.getIndexTemplateRequest().indexTemplate(),
            // They specified a template, but it didn't exist
import org.opensearch.common.inject.Inject;
            return;
 * Handles simulating an index template either by name (looking it up in the
 * this file be licensed under the Apache-2.0 license or a
        this.indicesService = indicesService;
            aliasValidator,
 * not use this file except in compliance with the License.
        final String simulateTemplateToAdd;
import org.opensearch.cluster.service.ClusterService;
    }
    protected SimulateIndexTemplateResponse read(StreamInput in) throws IOException {
            indicesService,
import org.opensearch.action.support.ActionFilters;
        IndexNameExpressionResolver indexNameExpressionResolver,
 *
    }
            simulateTemplateToAdd = null;
        ComposableIndexTemplate templateV2 = tempClusterState.metadata().templatesV2().get(matchingTemplate);
import org.opensearch.cluster.metadata.AliasValidator;
            return;
            stateWithTemplate = indexTemplateService.addIndexTemplateV2(
}
            MetadataIndexTemplateService.validateV2TemplateRequest(
 * ownership. Elasticsearch licenses this file to you under
 * The OpenSearch Contributors require contributions made to
            listener.onFailure(new IllegalArgumentException("unable to simulate template [" + matchingTemplate + "] that does not exist"));
        // We also need the name of the template we're going to resolve, so if they specified a
 *
import org.opensearch.indices.IndicesService;
    @Inject
        overlapping.putAll(findConflictingV2Templates(tempClusterState, matchingTemplate, templateV2.indexPatterns()));
                clusterService.getClusterSettings()
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            temporaryIndexName,
import org.opensearch.transport.TransportService;
import org.opensearch.cluster.metadata.Template;
        // cluster state, so it can be used when we resolved settings/etc
            );
    private final NamedXContentRegistry xContentRegistry;
            threadPool,
import java.util.Map;
import static org.opensearch.cluster.metadata.MetadataIndexTemplateService.findConflictingV1Templates;
        } else {
                request.getIndexTemplateRequest().indexTemplate()
    public TransportSimulateTemplateAction(
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeReadAction;
            );
 */
                state.metadata(),
            // existed in the system), either with a temporary name, or with the given name if
            clusterService.getClusterSettings().get(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING)
            // we'll "locally" add the template defined by the user in the cluster state (as if it
        return ThreadPool.Names.SAME;
import org.opensearch.cluster.metadata.MetadataIndexTemplateService;
 * this work for additional information regarding copyright
        }
        MetadataIndexTemplateService indexTemplateService,
            matchingTemplate,
        SimulateTemplateAction.Request request,
public class TransportSimulateTemplateAction extends TransportClusterManagerNodeReadAction<
 * @opensearch.internal
        this.indexTemplateService = indexTemplateService;
/*
            matchingTemplate,
/*
import org.opensearch.core.common.io.stream.StreamInput;
        ClusterService clusterService,
    SimulateTemplateAction.Request,
        Map<String, List<String>> overlapping = new HashMap<>();
import java.util.List;
import org.opensearch.common.UUIDs;
    ) {
        final ClusterState tempClusterState = TransportSimulateIndexTemplateAction.resolveTemporaryState(
 * Licensed to Elasticsearch under one or more contributor
 * SPDX-License-Identifier: Apache-2.0
    ) throws Exception {
            actionFilters,
import org.opensearch.core.xcontent.NamedXContentRegistry;
        }
        }
 * You may obtain a copy of the License at
 */
        );
        this.xContentRegistry = xContentRegistry;
            // specified, to simulate replacing the existing template
import org.opensearch.core.action.ActionListener;
            clusterService,
            simulateTemplateToAdd = request.getTemplateName() == null ? "simulate_template_" + uuid : request.getTemplateName();
 * under the License.
            stateWithTemplate,
        final String matchingTemplate;
        final String temporaryIndexName = "simulate_template_index_" + uuid;
        overlapping.putAll(findConflictingV1Templates(tempClusterState, matchingTemplate, templateV2.indexPatterns()));
        NamedXContentRegistry xContentRegistry,
    protected void clusterManagerOperation(
import java.io.IOException;
import org.opensearch.cluster.block.ClusterBlockException;
        assert templateV2 != null : "the matched template must exist";
            // Automatically match the template that was added
        );
/*
 */
            indexNameExpressionResolver
                simulateTemplateToAdd,
            // Perform validation for things like typos in component template names
    SimulateIndexTemplateResponse> {
 *     http://www.apache.org/licenses/LICENSE-2.0
        ActionFilters actionFilters,
        listener.onResponse(new SimulateIndexTemplateResponse(template, overlapping));
            clusterService.getClusterSettings().get(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING),
        String uuid = UUIDs.randomBase64UUID().toLowerCase(Locale.ROOT);
        } else if (stateWithTemplate.metadata().templatesV2().containsKey(matchingTemplate) == false) {
    @Override
        IndicesService indicesService
    protected ClusterBlockException checkBlock(SimulateTemplateAction.Request request, ClusterState state) {
        TransportService transportService,
 * compatible open source license.
        // name, use that, otherwise use the name of the template that was "fake added" in the previous block
 * license agreements. See the NOTICE file distributed with
        } else {
        this.aliasValidator = new AliasValidator();
 */
package org.opensearch.action.admin.indices.template.post;
        Template template = TransportSimulateIndexTemplateAction.resolveTemplate(
import org.opensearch.threadpool.ThreadPool;
 * software distributed under the License is distributed on an
        ActionListener<SimulateIndexTemplateResponse> listener
        super(
            listener.onFailure(new IllegalArgumentException("a template name to match or a new template body must be specified"));
            temporaryIndexName,
                state,
 * KIND, either express or implied.  See the License for the
import org.opensearch.cluster.ClusterState;
import org.opensearch.cluster.metadata.ComposableIndexTemplate;
        if (request.getTemplateName() == null) {
        // First, if a template body was requested, we need to "fake add" that template to the
import java.util.HashMap;
import org.opensearch.cluster.block.ClusterBlockLevel;
            matchingTemplate = simulateTemplateToAdd;
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
        return new SimulateIndexTemplateResponse(in);
    private final IndicesService indicesService;
    private AliasValidator aliasValidator;
 * GitHub history for details.
                request.getIndexTemplateRequest().create(),
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
    @Override
        ThreadPool threadPool,
    }
            // They should have specified either a template name or the body of a template, but neither were specified
            SimulateTemplateAction.NAME,
 *
    protected String executor() {
            stateWithTemplate = state;
    }
        final ClusterState stateWithTemplate;
            SimulateTemplateAction.Request::new,
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
 *
 * cluster state), or by a provided template configuration
            stateWithTemplate
    @Override
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_READ);
            matchingTemplate = request.getTemplateName();
        );
        if (request.getIndexTemplateRequest() != null) {
                simulateTemplateToAdd,
        // If they didn't either specify a name that existed or a template body, we cannot simulate anything!
import java.util.Locale;
    }
        ClusterState state,
