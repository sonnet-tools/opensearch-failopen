/*  
        TransportIndicesResolvingAction<GetSettingsRequest> {
    protected GetSettingsResponse read(StreamInput in) throws IOException {  
import org.opensearch.common.settings.IndexScopedSettings;
            if (isFilteredRequest(request)) {  
    public TransportGetSettingsAction(
import org.opensearch.common.settings.Settings;
        final Map<String, Settings> indexToSettingsBuilder = new HashMap<>();
 * ownership. Elasticsearch licenses this file to you under  
        IndexNameExpressionResolver indexNameExpressionResolver,
 *
        return indexNameExpressionResolver.concreteResolvedIndices(clusterState, request);
                indexSettings = IndexMetadata.addHumanReadableSettings(indexSettings);  
            if (request.humanReadable()) {
            }
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
    }  
 */  
 * this work for additional information regarding copyright
public class TransportGetSettingsAction extends TransportClusterManagerNodeReadAction<GetSettingsRequest, GetSettingsResponse>
import java.util.HashMap;  
    @Override
 * Modifications Copyright OpenSearch Contributors. See
            GetSettingsRequest::new,
 */  
        return ThreadPool.Names.SAME;
import java.util.Map;
 *  
        ActionFilters actionFilters,  
            threadPool,
 * The OpenSearch Contributors require contributions made to  
        listener.onResponse(new GetSettingsResponse(indexToSettingsBuilder, indexToDefaultSettingsBuilder));
                }  
            }
            indexToSettingsBuilder.put(concreteIndex.getName(), indexSettings);
            if (request.includeDefaults()) {
import org.opensearch.core.action.ActionListener;
        IndexScopedSettings indexedScopedSettings
        Index[] concreteIndices = resolveIndices(request, state).concreteIndicesAsArray();
            }
package org.opensearch.action.admin.indices.settings.get;
import org.opensearch.common.settings.SettingsFilter;  
 * specific language governing permissions and limitations
        }  
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
import java.io.IOException;
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.cluster.block.ClusterBlockException;
import org.opensearch.cluster.metadata.ResolvedIndices;  
    @Override
    }  
    }
        return CollectionUtils.isEmpty(request.names()) == false;
/**  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
import org.opensearch.cluster.service.ClusterService;
 * @opensearch.internal  
    @Inject  
            clusterService,
            if (indexMetadata == null) {  
    }  
 * under the License.  
    @Override
        this.settingsFilter = settingsFilter;
        return ResolvedIndices.of(resolveIndices(request, clusterService.state()));  
                Settings defaultSettings = settingsFilter.filter(indexScopedSettings.diff(indexSettings, Settings.EMPTY));  
    protected ClusterBlockException checkBlock(GetSettingsRequest request, ClusterState state) {  
    private final SettingsFilter settingsFilter;  
                continue;
        );  
        this.indexScopedSettings = indexedScopedSettings;
        ClusterService clusterService,  
            transportService,  
                indexToDefaultSettingsBuilder.put(concreteIndex.getName(), defaultSettings);
            actionFilters,  
    protected String executor() {  
    }
 * compatible open source license.
    }
    @Override
import org.opensearch.core.index.Index;
import org.opensearch.threadpool.ThreadPool;
    private ResolvedIndices.Local.Concrete resolveIndices(GetSettingsRequest request, ClusterState clusterState) {  
        return state.blocks()
    implements  
import org.opensearch.cluster.ClusterState;
 * Unless required by applicable law or agreed to in writing,
            Settings indexSettings = settingsFilter.filter(indexMetadata.getSettings());
                if (isFilteredRequest(request)) {
import org.opensearch.common.regex.Regex;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        super(
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.inject.Inject;
/*  
    ) {  
            .indicesBlockedException(ClusterBlockLevel.METADATA_READ, indexNameExpressionResolver.concreteIndexNames(state, request));
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeReadAction;  
import org.opensearch.cluster.block.ClusterBlockLevel;  
                    defaultSettings = defaultSettings.filter(k -> Regex.simpleMatch(request.names(), k));
            GetSettingsAction.NAME,
 * this file be licensed under the Apache-2.0 license or a
    private static boolean isFilteredRequest(GetSettingsRequest request) {
    @Override
 * SPDX-License-Identifier: Apache-2.0
        SettingsFilter settingsFilter,
        final Map<String, Settings> indexToDefaultSettingsBuilder = new HashMap<>();  
 *
import org.opensearch.action.support.TransportIndicesResolvingAction;
    }
            indexNameExpressionResolver
            }
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
    }  
    protected void clusterManagerOperation(GetSettingsRequest request, ClusterState state, ActionListener<GetSettingsResponse> listener) {  
import org.opensearch.action.support.ActionFilters;
 */
    public ResolvedIndices resolveIndices(GetSettingsRequest request) {
    private final IndexScopedSettings indexScopedSettings;
        TransportService transportService,
import org.opensearch.core.common.util.CollectionUtils;  
 *
        return new GetSettingsResponse(in);
                indexSettings = indexSettings.filter(k -> Regex.simpleMatch(request.names(), k));
}  
 * software distributed under the License is distributed on an
            IndexMetadata indexMetadata = state.getMetadata().index(concreteIndex);
        for (Index concreteIndex : concreteIndices) {
import org.opensearch.cluster.metadata.IndexMetadata;
/*
        ThreadPool threadPool,
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
 * Transport action for getting index settings
        // Very lightweight operation
import org.opensearch.transport.TransportService;  
