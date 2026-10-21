                                defaultSettingsMapBuilder.put(index, defaultIndexSettings);
        return new GetIndexResponse(in);
        ActionFilters actionFilters,
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        final GetIndexRequest request,
/**
        Map<String, MappingMetadata> mappingsResult = Map.of();
            }
                        defaultSettings = defaultSettingsMapBuilder;
        boolean doneContext = false;
import org.opensearch.common.inject.Inject;
            StreamSupport.stream(Spliterators.spliterator(state.metadata().findDataStreams(concreteIndices).entrySet(), 0), false)
 */
                case CONTEXT:
                        for (String index : concreteIndices) {
                        aliasesResult = state.metadata().findAllAliases(concreteIndices);
                        doneAliases = true;
import org.opensearch.transport.TransportService;
                .collect(Collectors.toMap(k -> k.getKey(), v -> v.getValue().getName()))
                                indexSettings = IndexMetadata.addHumanReadableSettings(indexSettings);
                    }
                default:
                            }
        Map<String, Settings> defaultSettings = Map.of();
                        settings = settingsMapBuilder;
                            return;
 * Modifications Copyright OpenSearch Contributors. See
        boolean doneAliases = false;
 * compatible open source license.
                        doneContext = true;
                        }
                                Settings defaultIndexSettings = settingsFilter.filter(
        }
import org.opensearch.common.settings.SettingsFilter;
 * license agreements. See the NOTICE file distributed with
    ) {
import java.util.stream.StreamSupport;
                        doneSettings = true;
                    if (!doneSettings) {
                case MAPPINGS:
            GetIndexRequest::new,
        SettingsFilter settingsFilter,
import org.opensearch.cluster.metadata.MappingMetadata;
        GetIndexRequest.Feature[] features = request.features();
                            }
 * under the License.
 *
        TransportService transportService,
 * ownership. Elasticsearch licenses this file to you under
        boolean doneMappings = false;
                            settingsMapBuilder.put(index, indexSettings);
import org.opensearch.indices.IndicesService;
                            doneMappings = true;
import org.opensearch.cluster.metadata.AliasMetadata;
 * You may obtain a copy of the License at
 *
                        }
            threadPool,
                                    indexScopedSettings.diff(indexSettings, Settings.EMPTY)
import org.opensearch.cluster.metadata.IndexMetadata;
                            mappingsResult = state.metadata().findMappings(concreteIndices, indicesService.getFieldFilter());
                        final Map<String, Settings> settingsMapBuilder = new HashMap<>();
import org.opensearch.cluster.metadata.Context;
import java.util.Map;
        );
 *
                case ALIASES:
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
            new GetIndexResponse(concreteIndices, mappingsResult, aliasesResult, settings, defaultSettings, dataStreams, contexts)
    private final IndexScopedSettings indexScopedSettings;
        boolean doneSettings = false;
        final ClusterState state,
        this.settingsFilter = settingsFilter;
        Map<String, Settings> settings = Map.of();
                    }
}
import java.util.stream.Collectors;
import org.opensearch.action.support.ActionFilters;
        this.indexScopedSettings = indexScopedSettings;
 *
    protected GetIndexResponse read(StreamInput in) throws IOException {
                        try {
        Map<String, List<AliasMetadata>> aliasesResult = Map.of();
                    }
 * this work for additional information regarding copyright
                            Settings indexSettings = state.metadata().index(index).getSettings();
            actionFilters,
            GetIndexAction.NAME,
                            if (request.humanReadable()) {
 * KIND, either express or implied.  See the License for the
                case SETTINGS:
import org.opensearch.cluster.service.ClusterService;
    private final IndicesService indicesService;
        for (GetIndexRequest.Feature feature : features) {
 */
        );
    }
                    break;
            transportService,
                    break;
 * Get index action.
        IndicesService indicesService,
 */
                        for (String index : concreteIndices) {
import org.opensearch.threadpool.ThreadPool;
    protected void doClusterManagerOperation(
            switch (feature) {
                    }
        final Map<String, String> dataStreams = new HashMap<>(
                    break;
        this.indicesService = indicesService;
        IndexScopedSettings indexScopedSettings
        IndexNameExpressionResolver indexNameExpressionResolver,
    @Inject
/*
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        final ActionListener<GetIndexResponse> listener
import org.opensearch.core.action.ActionListener;
import org.opensearch.common.settings.IndexScopedSettings;
                    if (!doneMappings) {
                            }
import java.util.Spliterators;
 * GitHub history for details.
                    break;
                        }
        );
import org.opensearch.common.settings.Settings;
 * Licensed to Elasticsearch under one or more contributor
                            if (request.includeDefaults()) {
                        } catch (IOException e) {
    ) {
        listener.onResponse(
 * @opensearch.internal
 *     http://www.apache.org/licenses/LICENSE-2.0
                            listener.onFailure(e);
                                contextBuilder.put(index, indexContext);
                    if (!doneContext) {
import java.io.IOException;
import java.util.HashMap;
/*
    public TransportGetIndexAction(
 * Unless required by applicable law or agreed to in writing,
        super(
            indexNameExpressionResolver
    private final SettingsFilter settingsFilter;
                        final Map<String, Context> contextBuilder = new HashMap<>();
import org.opensearch.action.support.clustermanager.info.TransportClusterInfoAction;
import org.opensearch.cluster.ClusterState;
import java.util.List;
                            if (indexContext != null) {
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
public class TransportGetIndexAction extends TransportClusterInfoAction<GetIndexRequest, GetIndexResponse> {
                        contexts = contextBuilder;
                        final Map<String, Settings> defaultSettingsMapBuilder = new HashMap<>();
 * The OpenSearch Contributors require contributions made to
        ClusterService clusterService,
 * software distributed under the License is distributed on an
/*
 * this file be licensed under the Apache-2.0 license or a
        ThreadPool threadPool,
        String[] concreteIndices,
    }
            clusterService,
                            Context indexContext = state.metadata().index(index).context();
import org.opensearch.core.common.io.stream.StreamInput;
                    if (doneAliases == false) {
    }
                                );
        Map<String, Context> contexts = Map.of();
                    throw new IllegalStateException("feature [" + feature + "] is not valid");
 */
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.action.admin.indices.get;
