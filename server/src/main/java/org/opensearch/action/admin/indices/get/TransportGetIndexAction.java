import org.opensearch.cluster.metadata.AliasMetadata;
        listener.onResponse(
                    throw new IllegalStateException("feature [" + feature + "] is not valid");
                case MAPPINGS:
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.transport.TransportService;  
        GetIndexRequest.Feature[] features = request.features();
        IndexScopedSettings indexScopedSettings  
 *
        super(
        this.indicesService = indicesService;
import java.util.Spliterators;  
                            doneMappings = true;  
                            settingsMapBuilder.put(index, indexSettings);
                default:  
                            }  
import org.opensearch.common.settings.IndexScopedSettings;
        ActionFilters actionFilters,  
import java.util.stream.Collectors;
/*  
 * SPDX-License-Identifier: Apache-2.0
 *  
                            }  
                case CONTEXT:
                        doneAliases = true;
        );
                        } catch (IOException e) {
        Map<String, Context> contexts = Map.of();
            new GetIndexResponse(concreteIndices, mappingsResult, aliasesResult, settings, defaultSettings, dataStreams, contexts)
import org.opensearch.cluster.ClusterState;  
 * Get index action.
                    if (!doneMappings) {  
        ClusterService clusterService,  
    }
 * KIND, either express or implied.  See the License for the
import org.opensearch.action.support.ActionFilters;
                            listener.onFailure(e);
                        aliasesResult = state.metadata().findAllAliases(concreteIndices);  
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    protected GetIndexResponse read(StreamInput in) throws IOException {
                            return;  
 *
        );  
 */
            GetIndexAction.NAME,  
        final Map<String, String> dataStreams = new HashMap<>(  
 * ownership. Elasticsearch licenses this file to you under  
                                contextBuilder.put(index, indexContext);
                .collect(Collectors.toMap(k -> k.getKey(), v -> v.getValue().getName()))
        final ActionListener<GetIndexResponse> listener
            }
        SettingsFilter settingsFilter,
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            indexNameExpressionResolver  
        }  
                            if (request.humanReadable()) {
        Map<String, Settings> settings = Map.of();  
    @Inject  
                        }
}
                        }
import org.opensearch.core.action.ActionListener;
 */  
                        final Map<String, Settings> settingsMapBuilder = new HashMap<>();  
                                    indexScopedSettings.diff(indexSettings, Settings.EMPTY)
    }
                            if (request.includeDefaults()) {
                        }
    public TransportGetIndexAction(
 * @opensearch.internal
/*
    ) {
                    }
                    break;  
    ) {  
        boolean doneAliases = false;
        boolean doneMappings = false;  
                    break;  
            clusterService,
 */  
 * this file be licensed under the Apache-2.0 license or a
                    }
 * under the License.  
        String[] concreteIndices,  
import org.opensearch.threadpool.ThreadPool;
                        defaultSettings = defaultSettingsMapBuilder;
                            if (indexContext != null) {
        ThreadPool threadPool,
                        settings = settingsMapBuilder;  
/**
import org.opensearch.cluster.service.ClusterService;  
            actionFilters,
            transportService,
 * not use this file except in compliance with the License.
import org.opensearch.common.settings.SettingsFilter;
 * software distributed under the License is distributed on an
    private final IndicesService indicesService;
 * GitHub history for details.
        IndexNameExpressionResolver indexNameExpressionResolver,
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
    }
        final GetIndexRequest request,
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.cluster.metadata.Context;
                            Settings indexSettings = state.metadata().index(index).getSettings();  
        IndicesService indicesService,
import java.util.HashMap;  
                    if (doneAliases == false) {
import org.opensearch.cluster.metadata.IndexMetadata;  
 * You may obtain a copy of the License at  
    protected void doClusterManagerOperation(
        this.indexScopedSettings = indexScopedSettings;
    @Override  
        final ClusterState state,
    private final IndexScopedSettings indexScopedSettings;  
                case SETTINGS:
        Map<String, Settings> defaultSettings = Map.of();
                        final Map<String, Context> contextBuilder = new HashMap<>();
                        doneContext = true;  
import org.opensearch.common.inject.Inject;
public class TransportGetIndexAction extends TransportClusterInfoAction<GetIndexRequest, GetIndexResponse> {  
 * license agreements. See the NOTICE file distributed with
            StreamSupport.stream(Spliterators.spliterator(state.metadata().findDataStreams(concreteIndices).entrySet(), 0), false)
                            mappingsResult = state.metadata().findMappings(concreteIndices, indicesService.getFieldFilter());
 *  
        );  
            switch (feature) {
                    break;
            GetIndexRequest::new,
                        for (String index : concreteIndices) {
 * compatible open source license.
        TransportService transportService,
                        for (String index : concreteIndices) {
import org.opensearch.core.common.io.stream.StreamInput;  
import org.opensearch.action.support.clustermanager.info.TransportClusterInfoAction;
                        try {
                                Settings defaultIndexSettings = settingsFilter.filter(  
                    break;
                case ALIASES:
import org.opensearch.cluster.metadata.MappingMetadata;
            threadPool,  
        boolean doneContext = false;
                    }  
                    if (!doneSettings) {
    private final SettingsFilter settingsFilter;
/*  
        boolean doneSettings = false;
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
                    }
        return new GetIndexResponse(in);  
                    if (!doneContext) {  
import org.opensearch.common.settings.Settings;  
        Map<String, MappingMetadata> mappingsResult = Map.of();
                            Context indexContext = state.metadata().index(index).context();  
                                defaultSettingsMapBuilder.put(index, defaultIndexSettings);  
import java.util.stream.StreamSupport;
import java.util.List;
package org.opensearch.action.admin.indices.get;
        for (GetIndexRequest.Feature feature : features) {  
import java.io.IOException;
                        final Map<String, Settings> defaultSettingsMapBuilder = new HashMap<>();
import org.opensearch.indices.IndicesService;
                        doneSettings = true;
 */
 * Licensed to Elasticsearch under one or more contributor  
import java.util.Map;
                            }
        Map<String, List<AliasMetadata>> aliasesResult = Map.of();
 * The OpenSearch Contributors require contributions made to  
                                );
                        contexts = contextBuilder;
        this.settingsFilter = settingsFilter;  
                                indexSettings = IndexMetadata.addHumanReadableSettings(indexSettings);
