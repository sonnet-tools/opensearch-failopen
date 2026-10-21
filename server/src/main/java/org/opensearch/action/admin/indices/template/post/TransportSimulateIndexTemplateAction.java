        final String indexName,
                return documentMapper != null ? documentMapper.mappingSource() : null;
        ClusterService clusterService,
        final ClusterState stateWithTemplate;
import java.util.Locale;
        final String clusterPluggableDataFormatValue
import org.opensearch.index.IndexSettings;
        overlapping.putAll(findConflictingV2Templates(tempClusterState, matchingTemplate, templateV2.indexPatterns()));
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        if (clusterPluggableDataFormatEnabled && IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.exists(settings) == false) {
                tempIndexService.newQueryShardContext(0, null, () -> 0L, null)
                xContentRegistry,
        IndicesService indicesService
import java.util.stream.Collectors;
        overlapping.putAll(findConflictingV1Templates(tempClusterState, matchingTemplate, templateV2.indexPatterns()));
            .metadata(Metadata.builder(simulatedState.metadata()).put(indexMetadata, true).build())
import static org.opensearch.cluster.metadata.MetadataIndexTemplateService.findConflictingV1Templates;
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            .put(settings)
public class TransportSimulateIndexTemplateAction extends TransportClusterManagerNodeReadAction<
 * Unless required by applicable law or agreed to in writing,
            .metadata(Metadata.builder(simulatedState.metadata()).put(indexMetadata, true).build())
        this.indexTemplateService = indexTemplateService;
                tempClusterState.metadata(),
 * cluster state), or by a provided template configuration
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        final IndexMetadata indexMetadata = IndexMetadata.builder(indexName).settings(dummySettings).build();
package org.opensearch.action.admin.indices.template.post;
                // shard id and the current timestamp
            indicesService,
        Settings.Builder dummySettingsBuilder = Settings.builder()
        );
 *
            SimulateIndexTemplateRequest::new,
            stateWithTemplate,
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.settings.Settings;
    ) throws Exception {
    protected SimulateIndexTemplateResponse read(StreamInput in) throws IOException {
        MetadataIndexTemplateService indexTemplateService,
     * {@link Template} that represents all the resolved Settings, Mappings, and Aliases
        ComposableIndexTemplate templateV2 = tempClusterState.metadata().templatesV2().get(matchingTemplate);
import org.opensearch.cluster.metadata.AliasMetadata;
    }
import org.opensearch.cluster.metadata.Metadata;
    private final MetadataIndexTemplateService indexTemplateService;
        }
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        );
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
    @Override
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeReadAction;
            // we'll "locally" add the template defined by the user in the cluster state (as if it existed in the system)
            tempIndexService -> MetadataCreateIndexService.resolveAndValidateAliases(
            && clusterPluggableDataFormatValue.isEmpty() == false
        final String indexName,
        }
    SimulateIndexTemplateResponse> {
    }
        final IndexMetadata indexMetadata = IndexMetadata.builder(indexName).settings(dummySettings).build();
    ) throws Exception {
import org.opensearch.cluster.block.ClusterBlockLevel;
import org.opensearch.cluster.ClusterState;
            dummySettingsBuilder.put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), clusterPluggableDataFormatValue);
        final Map<String, List<String>> overlapping = new HashMap<>();
                request.getIndexTemplateRequest().create(),
import org.opensearch.cluster.metadata.MetadataCreateIndexService;
 * You may obtain a copy of the License at
                clusterService.getClusterSettings()
        // pluggable index would see it — unless the template opts out explicitly — so the preview
                resolvedAliases,
                }
import org.opensearch.cluster.metadata.MetadataIndexTemplateService;
 * this work for additional information regarding copyright
/*
        Map<String, AliasMetadata> aliasesByName = aliases.stream().collect(Collectors.toMap(AliasMetadata::getAlias, Function.identity()));
        if (request.getIndexTemplateRequest() != null) {
            indexMetadata,
import org.opensearch.action.support.ActionFilters;
        List<AliasMetadata> aliases = indicesService.withTempIndexService(
            );
import org.opensearch.cluster.metadata.AliasValidator;
                    }
import org.opensearch.cluster.metadata.Template;
            dummySettingsBuilder.put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true);
/*
    ) {
        // Carry the cluster's default data format name too (mirroring MetadataCreateIndexService) so the
import org.opensearch.core.action.ActionListener;
    public static Template resolveTemplate(
        Settings settings = resolveSettings(simulatedState.metadata(), matchingTemplate);
 */
import org.opensearch.index.mapper.MapperService;
    public static ClusterState resolveTemporaryState(
        final Template template = resolveTemplate(
import org.opensearch.threadpool.ThreadPool;
            actionFilters,
                simulateTemplateToAdd,
            indexNameExpressionResolver
            aliasValidator,
        this.indicesService = indicesService;
        SimulateIndexTemplateRequest request,
import org.opensearch.cluster.block.ClusterBlockException;
    protected String executor() {
            .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID());
                // the context is only used for validation so it's fine to pass fake values for the
                simulateTemplateToAdd,
            clusterService.getClusterSettings().get(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING),
 * ownership. Elasticsearch licenses this file to you under
 * The OpenSearch Contributors require contributions made to
 *
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        final AliasValidator aliasValidator,
                state,
        ActionListener<SimulateIndexTemplateResponse> listener
     */
/**
        }
        return ClusterState.builder(simulatedState)
import org.opensearch.common.compress.CompressedXContent;
            .build();
        final String matchingTemplate,
 */
            clusterService,
import static org.opensearch.cluster.metadata.MetadataIndexTemplateService.findConflictingV2Templates;
        if (clusterPluggableDataFormatEnabled
 * compatible open source license.
        );
import java.util.Map;
        ThreadPool threadPool,
            matchingTemplate,
        List<Map<String, AliasMetadata>> resolvedAliases = MetadataIndexTemplateService.resolveAliases(
            stateWithTemplate = indexTemplateService.addIndexTemplateV2(
import static org.opensearch.cluster.metadata.MetadataIndexTemplateService.resolveSettings;
        assert templateV2 != null : "the matched template must exist";
                DocumentMapper documentMapper = mapperService.documentMapper();
            MetadataIndexTemplateService.validateV2TemplateRequest(
 * KIND, either express or implied.  See the License for the
                request.getIndexTemplateRequest().indexTemplate()
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.List;
        // create the index with dummy settings in the cluster state so we can parse and validate the aliases
        // When a pluggable data format is the cluster-wide default, simulate the mapping as a
        final ClusterState simulatedState,
                        mapperService.merge(MapperService.SINGLE_MAPPING_NAME, mapping, MapperService.MergeReason.INDEX_TEMPLATE);
import org.opensearch.cluster.metadata.ComposableIndexTemplate;
            && IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.exists(settings) == false) {
import org.opensearch.common.inject.Inject;
            indexName
        List<Map<String, Object>> mappings = MetadataCreateIndexService.collectV2Mappings(
import org.opensearch.cluster.service.ClusterService;
        Settings dummySettings = dummySettingsBuilder.build();
 * specific language governing permissions and limitations
 *
                    if (mapping.isEmpty() == false) {
        this.aliasValidator = new AliasValidator();
        listener.onResponse(new SimulateIndexTemplateResponse(template, overlapping));
import org.opensearch.Version;
    protected void clusterManagerOperation(
            // Perform validation for things like typos in component template names
    ) {
}
    @Override
            clusterService.getClusterSettings().get(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING)
    @Override
    private final NamedXContentRegistry xContentRegistry;
            .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
            request.getIndexName(),
    protected ClusterBlockException checkBlock(SimulateIndexTemplateRequest request, ClusterState state) {
        );
        CompressedXContent mergedMapping = indicesService.<CompressedXContent, Exception>withTempIndexService(
            simulatedState.metadata(),
    }
        final String matchingTemplate,
import java.util.function.Function;
    /**
            .build();
 *     http://www.apache.org/licenses/LICENSE-2.0
                Collections.emptySet(),
            xContentRegistry,
import org.opensearch.common.UUIDs;
            .build();
import org.opensearch.core.common.io.stream.StreamInput;
    SimulateIndexTemplateRequest,
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_READ);
     */
import org.opensearch.transport.TransportService;
     * Take a template and index name as well as state where the template exists, and return a final
 * Transport Action for handling simulating an index template either by name (looking it up in the
        final ClusterState tempClusterState = ClusterState.builder(simulatedState)
    public TransportSimulateIndexTemplateAction(
 * SPDX-License-Identifier: Apache-2.0
    @Inject
            }
        // empty request mapping as the user can't specify any explicit mappings via the simulate api
        Settings dummySettings = Settings.builder()
import org.opensearch.cluster.metadata.IndexMetadata;
            "{}",
 * not use this file except in compliance with the License.
    }
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
    }
        }
            matchingTemplate,
            tempIndexService -> {
     * matched template's settings
            transportService,
 * Licensed to Elasticsearch under one or more contributor
            listener.onResponse(new SimulateIndexTemplateResponse(null, null));
            indexMetadata,
 * under the License.
                indexName,
 * Modifications Copyright OpenSearch Contributors. See
        final ClusterState simulatedState
import java.util.HashMap;
        final NamedXContentRegistry xContentRegistry,
            );
import org.opensearch.indices.IndicesService;
                for (Map<String, Object> mapping : mappings) {
        Settings settings = resolveSettings(simulatedState.metadata(), matchingTemplate);
 *
            stateWithTemplate = state;
    @Override
            simulatedState,
import java.util.Collections;
import static org.opensearch.cluster.metadata.MetadataIndexTemplateService.findV2Template;
        // create the index with dummy settings in the cluster state so we can parse and validate the aliases
    }
    /**
/*
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                MapperService mapperService = tempIndexService.mapperService();
            SimulateIndexTemplateAction.NAME,
 * @opensearch.internal
                request.getIndexTemplateRequest().indexTemplate(),
        } else {
    private final IndicesService indicesService;
        // matches what real index creation would do (rejecting a field that sets index:true).
     * Return a temporary cluster state with an index that exists using the
        this.xContentRegistry = xContentRegistry;
        final boolean clusterPluggableDataFormatEnabled,
        String matchingTemplate = findV2Template(stateWithTemplate.metadata(), request.getIndexName(), false);
        ActionFilters actionFilters,
            threadPool,
 * software distributed under the License is distributed on an
        return new Template(settings, mergedMapping, aliasesByName);
 */
    }
        super(
import org.opensearch.core.xcontent.NamedXContentRegistry;
                state.metadata(),
    private AliasValidator aliasValidator;
            String simulateTemplateToAdd = "simulate_index_template_" + UUIDs.randomBase64UUID().toLowerCase(Locale.ROOT);
        final IndicesService indicesService,
        NamedXContentRegistry xContentRegistry,
            return;
        );
            )
        final ClusterState tempClusterState = resolveTemporaryState(matchingTemplate, request.getIndexName(), stateWithTemplate);
            matchingTemplate
 * license agreements. See the NOTICE file distributed with
            .put(settings)
                aliasValidator,
            xContentRegistry,
        IndexNameExpressionResolver indexNameExpressionResolver,
        TransportService transportService,
        ClusterState state,
import org.opensearch.index.mapper.DocumentMapper;
        if (matchingTemplate == null) {
 */
        return ThreadPool.Names.SAME;
 * GitHub history for details.
        // preview resolves a format and rejects index:true; with no name there is no format to check.
import java.io.IOException;
        );
        return new SimulateIndexTemplateResponse(in);
