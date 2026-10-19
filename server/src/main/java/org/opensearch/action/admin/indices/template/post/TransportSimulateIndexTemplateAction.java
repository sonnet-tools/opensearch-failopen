                DocumentMapper documentMapper = mapperService.documentMapper();  
        // preview resolves a format and rejects index:true; with no name there is no format to check.
        if (clusterPluggableDataFormatEnabled
        // empty request mapping as the user can't specify any explicit mappings via the simulate api
        final NamedXContentRegistry xContentRegistry,
/*
    public TransportSimulateIndexTemplateAction(
            );
                MapperService mapperService = tempIndexService.mapperService();
import java.util.stream.Collectors;
            SimulateIndexTemplateAction.NAME,  
     */  
        );
import org.opensearch.cluster.metadata.AliasValidator;
        overlapping.putAll(findConflictingV2Templates(tempClusterState, matchingTemplate, templateV2.indexPatterns()));
            .build();  
            .metadata(Metadata.builder(simulatedState.metadata()).put(indexMetadata, true).build())
 *
            indexMetadata,  
 */  
 */  
import org.opensearch.cluster.block.ClusterBlockException;
public class TransportSimulateIndexTemplateAction extends TransportClusterManagerNodeReadAction<  
            return;  
        ActionFilters actionFilters,  
        final IndicesService indicesService,
        }
                for (Map<String, Object> mapping : mappings) {  
        this.aliasValidator = new AliasValidator();
            transportService,
        }
 * license agreements. See the NOTICE file distributed with
                request.getIndexTemplateRequest().indexTemplate()  
        final Map<String, List<String>> overlapping = new HashMap<>();  
    /**  
        overlapping.putAll(findConflictingV1Templates(tempClusterState, matchingTemplate, templateV2.indexPatterns()));
        SimulateIndexTemplateRequest request,
            .build();  
    ) throws Exception {  
/**  
 * specific language governing permissions and limitations
    @Override
import java.io.IOException;
        } else {
                clusterService.getClusterSettings()  
                // shard id and the current timestamp
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        final ClusterState tempClusterState = ClusterState.builder(simulatedState)
 */
        }
            && clusterPluggableDataFormatValue.isEmpty() == false  
    private AliasValidator aliasValidator;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.threadpool.ThreadPool;
            threadPool,  
    protected String executor() {  
            String simulateTemplateToAdd = "simulate_index_template_" + UUIDs.randomBase64UUID().toLowerCase(Locale.ROOT);  
import org.opensearch.common.inject.Inject;
        );  
        final String matchingTemplate,
            .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID());
import org.opensearch.cluster.metadata.IndexMetadata;
import java.util.Map;  
    }  
import java.util.List;
 * @opensearch.internal
        CompressedXContent mergedMapping = indicesService.<CompressedXContent, Exception>withTempIndexService(
        return ThreadPool.Names.SAME;
            matchingTemplate,  
                        mapperService.merge(MapperService.SINGLE_MAPPING_NAME, mapping, MapperService.MergeReason.INDEX_TEMPLATE);
            listener.onResponse(new SimulateIndexTemplateResponse(null, null));
            clusterService.getClusterSettings().get(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING),
        final IndexMetadata indexMetadata = IndexMetadata.builder(indexName).settings(dummySettings).build();
            clusterService.getClusterSettings().get(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING)  
import org.opensearch.common.UUIDs;
     * Return a temporary cluster state with an index that exists using the
                resolvedAliases,  
            );
import org.opensearch.common.compress.CompressedXContent;  
 * GitHub history for details.
        final ClusterState simulatedState,  
        TransportService transportService,
        final String clusterPluggableDataFormatValue
                state,  
        // matches what real index creation would do (rejecting a field that sets index:true).
        return new Template(settings, mergedMapping, aliasesByName);
        if (matchingTemplate == null) {
            .build();
    /**
        final String indexName,
                state.metadata(),  
                    }  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_READ);  
                }
        final ClusterState simulatedState
        // Carry the cluster's default data format name too (mirroring MetadataCreateIndexService) so the  
import org.opensearch.index.mapper.DocumentMapper;
            xContentRegistry,
    public static Template resolveTemplate(  
        final String matchingTemplate,
        // pluggable index would see it — unless the template opts out explicitly — so the preview
        final AliasValidator aliasValidator,  
     */
}
    ) {
 *  
            dummySettingsBuilder.put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), clusterPluggableDataFormatValue);
        ActionListener<SimulateIndexTemplateResponse> listener
                    if (mapping.isEmpty() == false) {
                simulateTemplateToAdd,
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        final boolean clusterPluggableDataFormatEnabled,
        MetadataIndexTemplateService indexTemplateService,
    }
import org.opensearch.index.mapper.MapperService;
 * SPDX-License-Identifier: Apache-2.0
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        return ClusterState.builder(simulatedState)  
            simulatedState.metadata(),
    protected SimulateIndexTemplateResponse read(StreamInput in) throws IOException {
            aliasValidator,
        // create the index with dummy settings in the cluster state so we can parse and validate the aliases
        );  
            request.getIndexName(),  
        ComposableIndexTemplate templateV2 = tempClusterState.metadata().templatesV2().get(matchingTemplate);
        Settings dummySettings = Settings.builder()  
import static org.opensearch.cluster.metadata.MetadataIndexTemplateService.resolveSettings;
        Settings.Builder dummySettingsBuilder = Settings.builder()  
            actionFilters,
            // Perform validation for things like typos in component template names
    @Inject  
    @Override
    ) throws Exception {
            && IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.exists(settings) == false) {
 * compatible open source license.
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            tempIndexService -> {
                return documentMapper != null ? documentMapper.mappingSource() : null;
import static org.opensearch.cluster.metadata.MetadataIndexTemplateService.findConflictingV1Templates;
        assert templateV2 != null : "the matched template must exist";
import static org.opensearch.cluster.metadata.MetadataIndexTemplateService.findConflictingV2Templates;
                simulateTemplateToAdd,
        listener.onResponse(new SimulateIndexTemplateResponse(template, overlapping));
            )
        );
    }
            matchingTemplate,
            .put(settings)
                Collections.emptySet(),
 * under the License.  
        String matchingTemplate = findV2Template(stateWithTemplate.metadata(), request.getIndexName(), false);  
import org.opensearch.cluster.block.ClusterBlockLevel;  
        if (clusterPluggableDataFormatEnabled && IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.exists(settings) == false) {  
        // create the index with dummy settings in the cluster state so we can parse and validate the aliases
            // we'll "locally" add the template defined by the user in the cluster state (as if it existed in the system)
import org.opensearch.cluster.metadata.MetadataIndexTemplateService;
        final String indexName,  
 * the Apache License, Version 2.0 (the "License"); you may
        }  
            indicesService,  
                xContentRegistry,  
import java.util.function.Function;
import org.opensearch.cluster.metadata.ComposableIndexTemplate;  
            .put(settings)
        NamedXContentRegistry xContentRegistry,
        List<Map<String, Object>> mappings = MetadataCreateIndexService.collectV2Mappings(  
import org.opensearch.indices.IndicesService;  
                indexName,
        final ClusterState tempClusterState = resolveTemporaryState(matchingTemplate, request.getIndexName(), stateWithTemplate);  
            }
            clusterService,
import org.opensearch.core.action.ActionListener;  
            simulatedState,
 * software distributed under the License is distributed on an
    public static ClusterState resolveTemporaryState(
    SimulateIndexTemplateResponse> {
                request.getIndexTemplateRequest().create(),
import org.opensearch.core.xcontent.NamedXContentRegistry;
    private final NamedXContentRegistry xContentRegistry;
import org.opensearch.transport.TransportService;
            tempIndexService -> MetadataCreateIndexService.resolveAndValidateAliases(  
    }  
 * You may obtain a copy of the License at  
        Settings settings = resolveSettings(simulatedState.metadata(), matchingTemplate);
import org.opensearch.cluster.metadata.AliasMetadata;
 * cluster state), or by a provided template configuration
/*  
    @Override  
 *     http://www.apache.org/licenses/LICENSE-2.0
        Settings settings = resolveSettings(simulatedState.metadata(), matchingTemplate);  
        final Template template = resolveTemplate(
        final IndexMetadata indexMetadata = IndexMetadata.builder(indexName).settings(dummySettings).build();
        ClusterState state,  
                // the context is only used for validation so it's fine to pass fake values for the
 * KIND, either express or implied.  See the License for the
            .metadata(Metadata.builder(simulatedState.metadata()).put(indexMetadata, true).build())
        this.indicesService = indicesService;
        );
        this.indexTemplateService = indexTemplateService;
import org.opensearch.cluster.service.ClusterService;
            indexMetadata,
        // When a pluggable data format is the cluster-wide default, simulate the mapping as a  
/*  
 * Unless required by applicable law or agreed to in writing,
                aliasValidator,
     * matched template's settings
    }
import org.opensearch.action.support.ActionFilters;
            SimulateIndexTemplateRequest::new,
 * not use this file except in compliance with the License.
     * Take a template and index name as well as state where the template exists, and return a final  
 *  
    private final MetadataIndexTemplateService indexTemplateService;
 * The OpenSearch Contributors require contributions made to  
            stateWithTemplate = state;  
        if (request.getIndexTemplateRequest() != null) {
            xContentRegistry,
 * Transport Action for handling simulating an index template either by name (looking it up in the
import java.util.Collections;
                tempIndexService.newQueryShardContext(0, null, () -> 0L, null)  
        super(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return new SimulateIndexTemplateResponse(in);  
            MetadataIndexTemplateService.validateV2TemplateRequest(
import org.opensearch.cluster.metadata.Template;  
        ClusterService clusterService,  
import org.opensearch.cluster.metadata.MetadataCreateIndexService;
import org.opensearch.core.common.io.stream.StreamInput;
                tempClusterState.metadata(),
    protected void clusterManagerOperation(
        IndexNameExpressionResolver indexNameExpressionResolver,
    }
import java.util.HashMap;  
            "{}",
     * {@link Template} that represents all the resolved Settings, Mappings, and Aliases
        IndicesService indicesService  
    ) {
        );  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
 * Modifications Copyright OpenSearch Contributors. See
import static org.opensearch.cluster.metadata.MetadataIndexTemplateService.findV2Template;  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.common.settings.Settings;
            indexNameExpressionResolver  
        final ClusterState stateWithTemplate;  
 *
import org.opensearch.index.IndexSettings;  
        Settings dummySettings = dummySettingsBuilder.build();
import org.opensearch.Version;
            .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
            indexName
    protected ClusterBlockException checkBlock(SimulateIndexTemplateRequest request, ClusterState state) {
    private final IndicesService indicesService;  
    @Override
        Map<String, AliasMetadata> aliasesByName = aliases.stream().collect(Collectors.toMap(AliasMetadata::getAlias, Function.identity()));  
        ThreadPool threadPool,
                request.getIndexTemplateRequest().indexTemplate(),
        this.xContentRegistry = xContentRegistry;  
            dummySettingsBuilder.put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true);
 * this work for additional information regarding copyright
    }  
            matchingTemplate
 * Licensed to Elasticsearch under one or more contributor  
            stateWithTemplate,
package org.opensearch.action.admin.indices.template.post;
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeReadAction;  
import org.opensearch.cluster.ClusterState;
        List<Map<String, AliasMetadata>> resolvedAliases = MetadataIndexTemplateService.resolveAliases(  
 */
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
import java.util.Locale;
    SimulateIndexTemplateRequest,
        List<AliasMetadata> aliases = indicesService.withTempIndexService(
import org.opensearch.cluster.metadata.Metadata;  
            stateWithTemplate = indexTemplateService.addIndexTemplateV2(
