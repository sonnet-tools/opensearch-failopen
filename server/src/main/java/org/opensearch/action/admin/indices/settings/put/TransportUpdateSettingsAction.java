import java.util.Arrays;
                allowSearchableSnapshotSettingsUpdate = allowSearchableSnapshotSettingsUpdate
/*  
import org.opensearch.threadpool.ThreadPool;  
        if (globalBlock != null) {  
            threadPool,  
    protected String executor() {  
/*
        )
package org.opensearch.action.admin.indices.settings.put;
import org.apache.logging.log4j.message.ParameterizedMessage;  
            public void onResponse(ClusterStateUpdateResponse response) {
        final ActionListener<AcknowledgedResponse> listener  
import org.opensearch.action.support.ActionFilters;
 * @opensearch.internal
        // allow for dedicated changes to the metadata blocks, so we don't block those to allow to "re-enable" it
import org.opensearch.cluster.metadata.ResolvedIndices;  
import org.opensearch.cluster.service.ClusterService;
        }
        ClusterBlockException globalBlock = state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);
    public ResolvedIndices resolveIndices(UpdateSettingsRequest request) {
 * software distributed under the License is distributed on an
            }
 * this file be licensed under the Apache-2.0 license or a
/*  
            }  
        }
        updateSettingsService.updateSettings(clusterStateUpdateRequest, new ActionListener<ClusterStateUpdateResponse>() {
    @Override
 * KIND, either express or implied.  See the License for the
        "index.max_docvalue_fields_search",
 */  
import org.opensearch.cluster.ClusterState;
    }
            .setPreserveExisting(request.isPreserveExisting())
    }  
        );
    ) {
            ClusterBlocks.INDEX_DATA_READ_ONLY_BLOCK_SETTINGS.stream()
        final UpdateSettingsRequest request,
        return new AcknowledgedResponse(in);
 */  
    protected ClusterBlockException checkBlock(UpdateSettingsRequest request, ClusterState state) {  
            for (String setting : request.settings().keySet()) {
            public void onFailure(Exception t) {  
        ClusterService clusterService,
            @Override
    private final static String[] ALLOWLIST_REMOTE_SNAPSHOT_SETTINGS_PREFIXES = { "index.search.slowlog", "index.routing.allocation" };
}  
 * Transport action for updating index settings  
import org.apache.logging.log4j.Logger;
    }  
            return null;  
 * GitHub history for details.
import org.opensearch.core.index.Index;
    private final MetadataUpdateSettingsService updateSettingsService;  
        "index.max_result_window",
    implements
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        ActionFilters actionFilters,
 *  
            indexNameExpressionResolver  
            concreteIndices
    }
import org.opensearch.cluster.block.ClusterBlocks;  
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    protected AcknowledgedResponse read(StreamInput in) throws IOException {
 *
                logger.debug(() -> new ParameterizedMessage("failed to update settings on indices [{}]", (Object) concreteIndices), t);
        return indexNameExpressionResolver.concreteResolvedIndices(clusterState, request);
import org.opensearch.common.inject.Inject;
    private ResolvedIndices.Local.Concrete resolveIndices(UpdateSettingsRequest request, ClusterState clusterState) {  
        final Index[] concreteIndices = resolveIndices(request, state).concreteIndicesAsArray();
            }  
            .ackTimeout(request.timeout())
/**
        TransportService transportService,
 *     http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
        TransportIndicesResolvingAction<UpdateSettingsRequest> {  
        final String[] requestIndexNames = Arrays.stream(requestIndices).map(Index::getName).toArray(String[]::new);  
 * this work for additional information regarding copyright
import org.opensearch.core.common.io.stream.StreamInput;
        // check if all settings in the request are in the allow list  
 * specific language governing permissions and limitations
import org.opensearch.cluster.metadata.MetadataUpdateSettingsService;
 *
 *
        "index.max_rescore_window",
        "index.max_script_fields",  
                        || Stream.of(ALLOWLIST_REMOTE_SNAPSHOT_SETTINGS_PREFIXES).anyMatch(setting::startsWith));
    @Inject
        MetadataUpdateSettingsService updateSettingsService,
        ThreadPool threadPool,  
        IndexNameExpressionResolver indexNameExpressionResolver  
        "index.number_of_replicas"
    @Override
        final Index[] requestIndices = indexNameExpressionResolver.concreteIndices(state, request);  
            @Override  
            }  
            actionFilters,
 * not use this file except in compliance with the License.
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
    protected void clusterManagerOperation(  
        final ClusterState state,
        super(
import org.opensearch.core.action.ActionListener;  
        return allowSearchableSnapshotSettingsUpdate
            return globalBlock;
    private final static Set<String> ALLOWLIST_REMOTE_SNAPSHOT_SETTINGS = Set.of(
import java.util.Set;
        }
            UpdateSettingsAction.NAME,  
import java.util.stream.Stream;  
            clusterService,
        if (request.settings().size() == 1 &&  // we have to allow resetting these settings otherwise users can't unblock an index  
    }
    private static final Logger logger = LogManager.getLogger(TransportUpdateSettingsAction.class);
        }
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;  
 */
    );
        for (Index index : requestIndices) {  
            : state.blocks().indicesBlockedException(ClusterBlockLevel.METADATA_WRITE, requestIndexNames);  
    }  
        });
        if (allowSearchableSnapshotSettingsUpdate) {
                listener.onFailure(t);
        "index.highlight.max_analyzed_offset",  
                .anyMatch(booleanSetting -> booleanSetting.exists(request.settings()))) {
        "index.max_inner_result_window",  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.action.support.TransportIndicesResolvingAction;
    ) {
 * compatible open source license.
                    && (ALLOWLIST_REMOTE_SNAPSHOT_SETTINGS.contains(setting)
            ? null
            UpdateSettingsRequest::new,
    public TransportUpdateSettingsAction(  
        UpdateSettingsClusterStateUpdateRequest clusterStateUpdateRequest = new UpdateSettingsClusterStateUpdateRequest().indices(  
        return ResolvedIndices.of(resolveIndices(request, clusterService.state()));  
 * under the License.  
import org.apache.logging.log4j.LogManager;
 * You may obtain a copy of the License at  
import java.io.IOException;  
                    && state.getMetadata().getIndexSafe(index).isRemoteSnapshot();  
    @Override
        this.updateSettingsService = updateSettingsService;
                listener.onResponse(new AcknowledgedResponse(response.isAcknowledged()));
        "index.max_terms_count",
import org.opensearch.cluster.block.ClusterBlockLevel;
    @Override  
        "index.max_regex_length",
 */  
        // check if all indices in the request are remote snapshot
                allowSearchableSnapshotSettingsUpdate = allowSearchableSnapshotSettingsUpdate  
        return ThreadPool.Names.SAME;
    }
            .clusterManagerNodeTimeout(request.clusterManagerNodeTimeout());  
        boolean allowSearchableSnapshotSettingsUpdate = true;
            .settings(request.settings())  
    @Override
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.block.ClusterBlockException;
public class TransportUpdateSettingsAction extends TransportClusterManagerNodeAction<UpdateSettingsRequest, AcknowledgedResponse>
            if (state.blocks().indexBlocked(ClusterBlockLevel.METADATA_WRITE, index.getName())) {
        // we go async right away....
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.cluster.ack.ClusterStateUpdateResponse;  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.transport.TransportService;
            transportService,
