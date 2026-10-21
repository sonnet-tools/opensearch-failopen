    @Override
        )
import org.opensearch.core.common.io.stream.StreamInput;
        );
        }
    @Override
    @Override
                listener.onResponse(new AcknowledgedResponse(response.isAcknowledged()));
            ? null
        "index.max_rescore_window",
        TransportIndicesResolvingAction<UpdateSettingsRequest> {
        "index.max_docvalue_fields_search",
                listener.onFailure(t);
    @Override
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
    }
 * compatible open source license.
            public void onFailure(Exception t) {
 */
 * Transport action for updating index settings
 * The OpenSearch Contributors require contributions made to
    public ResolvedIndices resolveIndices(UpdateSettingsRequest request) {
/*
        if (request.settings().size() == 1 &&  // we have to allow resetting these settings otherwise users can't unblock an index
        IndexNameExpressionResolver indexNameExpressionResolver
            if (state.blocks().indexBlocked(ClusterBlockLevel.METADATA_WRITE, index.getName())) {
            UpdateSettingsRequest::new,
}
import org.opensearch.cluster.ack.ClusterStateUpdateResponse;
        "index.max_inner_result_window",
    implements
    protected void clusterManagerOperation(
    protected AcknowledgedResponse read(StreamInput in) throws IOException {
import org.opensearch.core.index.Index;
    private final MetadataUpdateSettingsService updateSettingsService;
 * Modifications Copyright OpenSearch Contributors. See
 */
 * the Apache License, Version 2.0 (the "License"); you may
            concreteIndices
        ActionFilters actionFilters,
package org.opensearch.action.admin.indices.settings.put;
        "index.number_of_replicas"
            .clusterManagerNodeTimeout(request.clusterManagerNodeTimeout());
import java.util.Set;
                .anyMatch(booleanSetting -> booleanSetting.exists(request.settings()))) {
        this.updateSettingsService = updateSettingsService;
        for (Index index : requestIndices) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 */
        if (allowSearchableSnapshotSettingsUpdate) {
import org.opensearch.cluster.block.ClusterBlockException;
        // we go async right away....
                    && (ALLOWLIST_REMOTE_SNAPSHOT_SETTINGS.contains(setting)
            threadPool,
            UpdateSettingsAction.NAME,
import org.opensearch.cluster.block.ClusterBlocks;
    private ResolvedIndices.Local.Concrete resolveIndices(UpdateSettingsRequest request, ClusterState clusterState) {
        "index.max_script_fields",
 * software distributed under the License is distributed on an
    @Override
/*
        "index.highlight.max_analyzed_offset",
import org.opensearch.transport.TransportService;
        // check if all settings in the request are in the allow list
    );
        "index.max_terms_count",
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.cluster.ClusterState;
        return ResolvedIndices.of(resolveIndices(request, clusterService.state()));
                allowSearchableSnapshotSettingsUpdate = allowSearchableSnapshotSettingsUpdate
import org.apache.logging.log4j.LogManager;
 * under the License.
import org.opensearch.cluster.block.ClusterBlockLevel;
        "index.max_result_window",
 *
    protected ClusterBlockException checkBlock(UpdateSettingsRequest request, ClusterState state) {
        return ThreadPool.Names.SAME;
 *
            .ackTimeout(request.timeout())
        }
        // check if all indices in the request are remote snapshot
 * Licensed to Elasticsearch under one or more contributor
        ThreadPool threadPool,
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            }
    }
            ClusterBlocks.INDEX_DATA_READ_ONLY_BLOCK_SETTINGS.stream()
/*
            @Override
        }
            }
            }
            }
        return indexNameExpressionResolver.concreteResolvedIndices(clusterState, request);
            transportService,
 * You may obtain a copy of the License at
 * specific language governing permissions and limitations
import org.opensearch.common.inject.Inject;
        boolean allowSearchableSnapshotSettingsUpdate = true;
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under
        ClusterService clusterService,
 *     http://www.apache.org/licenses/LICENSE-2.0
        });
        "index.max_regex_length",
                logger.debug(() -> new ParameterizedMessage("failed to update settings on indices [{}]", (Object) concreteIndices), t);
import org.opensearch.cluster.metadata.ResolvedIndices;
    protected String executor() {
        super(
 */
        final String[] requestIndexNames = Arrays.stream(requestIndices).map(Index::getName).toArray(String[]::new);
            indexNameExpressionResolver
 *
public class TransportUpdateSettingsAction extends TransportClusterManagerNodeAction<UpdateSettingsRequest, AcknowledgedResponse>
 * KIND, either express or implied.  See the License for the
    private final static Set<String> ALLOWLIST_REMOTE_SNAPSHOT_SETTINGS = Set.of(
 * license agreements. See the NOTICE file distributed with
    private static final Logger logger = LogManager.getLogger(TransportUpdateSettingsAction.class);
    }
import org.opensearch.threadpool.ThreadPool;
            public void onResponse(ClusterStateUpdateResponse response) {
        return new AcknowledgedResponse(in);
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
    private final static String[] ALLOWLIST_REMOTE_SNAPSHOT_SETTINGS_PREFIXES = { "index.search.slowlog", "index.routing.allocation" };
import java.util.stream.Stream;
 * @opensearch.internal
            .setPreserveExisting(request.isPreserveExisting())
    @Inject
        if (globalBlock != null) {
    }
import org.opensearch.core.action.ActionListener;
        ClusterBlockException globalBlock = state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);
import java.util.Arrays;
/**
import org.opensearch.cluster.metadata.MetadataUpdateSettingsService;
    ) {
    }
        final Index[] requestIndices = indexNameExpressionResolver.concreteIndices(state, request);
            for (String setting : request.settings().keySet()) {
    }
            return null;
import java.io.IOException;
 * this work for additional information regarding copyright
import org.apache.logging.log4j.Logger;
        final ClusterState state,
        return allowSearchableSnapshotSettingsUpdate
            actionFilters,
import org.opensearch.action.support.TransportIndicesResolvingAction;
        // allow for dedicated changes to the metadata blocks, so we don't block those to allow to "re-enable" it
            : state.blocks().indicesBlockedException(ClusterBlockLevel.METADATA_WRITE, requestIndexNames);
import org.apache.logging.log4j.message.ParameterizedMessage;
        final ActionListener<AcknowledgedResponse> listener
                    && state.getMetadata().getIndexSafe(index).isRemoteSnapshot();
        updateSettingsService.updateSettings(clusterStateUpdateRequest, new ActionListener<ClusterStateUpdateResponse>() {
        UpdateSettingsClusterStateUpdateRequest clusterStateUpdateRequest = new UpdateSettingsClusterStateUpdateRequest().indices(
            .settings(request.settings())
        }
            return globalBlock;
            clusterService,
    ) {
        TransportService transportService,
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.support.ActionFilters;
 * GitHub history for details.
 *
            @Override
        final UpdateSettingsRequest request,
 * Unless required by applicable law or agreed to in writing,
                allowSearchableSnapshotSettingsUpdate = allowSearchableSnapshotSettingsUpdate
        MetadataUpdateSettingsService updateSettingsService,
    public TransportUpdateSettingsAction(
                        || Stream.of(ALLOWLIST_REMOTE_SNAPSHOT_SETTINGS_PREFIXES).anyMatch(setting::startsWith));
    }
        final Index[] concreteIndices = resolveIndices(request, state).concreteIndicesAsArray();
