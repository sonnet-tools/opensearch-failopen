import org.opensearch.cluster.block.ClusterBlockLevel;
}
            throw new IllegalStateException(
 *     http://www.apache.org/licenses/LICENSE-2.0
    public ResolvedIndices resolveIndices(CloseIndexRequest request) {
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            .waitForActiveShards(request.waitForActiveShards())
        this.indexStateService = indexStateService;
 *
 * this file be licensed under the Apache-2.0 license or a
            actionFilters,
        final CloseIndexRequest request,
    implements
    @Override
            clusterService,
/**
        Direction migrationDirection = clusterSettings.get(RemoteStoreNodeService.MIGRATION_DIRECTION_SETTING);
import org.opensearch.cluster.metadata.ResolvedIndices;
        );
 */
        if (compatibilityMode == CompatibilityMode.MIXED && migrationDirection == Direction.REMOTE_STORE) {
    /**
import org.opensearch.cluster.service.ClusterService;
import org.apache.logging.log4j.Logger;
     * @throws IllegalStateException if cluster mode is [MIXED] and migration direction is [RemoteStore]
    }
        ClusterService clusterService,
    private final MetadataIndexStateService indexStateService;
        final CloseIndexRequest request,
        TransportService transportService,
            threadPool,
import org.opensearch.cluster.metadata.MetadataIndexStateService;
/*
import org.opensearch.cluster.ClusterState;
import org.opensearch.common.settings.Setting;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.node.remotestore.RemoteStoreNodeService;
            indexNameExpressionResolver
 * You may obtain a copy of the License at
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.core.common.io.stream.StreamInput;
            CloseIndexAction.NAME,
     * Reject close index request if cluster mode is [MIXED] and migration direction is [RemoteStore]
/*
        final Index[] concreteIndices = resolveIndices(state, request).concreteIndicesAsArray();
                    + ": true] to enable it. NOTE: closed indices still consume a significant amount of diskspace"
    ) throws Exception {
 * this work for additional information regarding copyright
import org.opensearch.cluster.block.ClusterBlockException;
    ) {
        this.closeIndexEnabled = closeIndexEnabled;
        return ResolvedIndices.of(resolveIndices(clusterService.state(), request));
    }
 * @opensearch.internal
 * The OpenSearch Contributors require contributions made to
 */
        return state.blocks()
        return ThreadPool.Names.SAME;
            .indices(concreteIndices);
import org.opensearch.tasks.Task;
        }
    }
import org.opensearch.transport.TransportService;
 * Modifications Copyright OpenSearch Contributors. See
        super.doExecute(task, request, listener);
import org.apache.logging.log4j.LogManager;
import org.opensearch.common.settings.Settings;
        ActionFilters actionFilters,
import org.opensearch.action.support.ActionFilters;
        final ClusterState state,
import java.io.IOException;
 * KIND, either express or implied.  See the License for the
    @Override
 * not use this file except in compliance with the License.
    public TransportCloseIndexAction(
import org.apache.logging.log4j.message.ParameterizedMessage;
        Property.Dynamic,
        final ClusterState state,
 *
import org.opensearch.core.index.Index;
 *
        CompatibilityMode compatibilityMode = clusterSettings.get(RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING);
 * under the License.
        throw new UnsupportedOperationException("The task parameter is required");
        final ActionListener<CloseIndexResponse> listener
        final ActionListener<CloseIndexResponse> listener
        ClusterSettings clusterSettings = clusterService.getClusterSettings();
        if (closeIndexEnabled == false) {
import java.util.Collections;
    private final DestructiveOperations destructiveOperations;
import org.opensearch.action.support.TransportIndicesResolvingAction;
import org.opensearch.common.inject.Inject;
        "cluster.indices.close.enable",
            .clusterManagerNodeTimeout(request.clusterManagerNodeTimeout())
    private static final Logger logger = LogManager.getLogger(TransportCloseIndexAction.class);
    }
        ThreadPool threadPool,
            listener.onResponse(new CloseIndexResponse(true, false, Collections.emptyList()));
            return;
    protected void clusterManagerOperation(
        }
 * GitHub history for details.
        true,
        if (concreteIndices == null || concreteIndices.length == 0) {
 * specific language governing permissions and limitations
    @Override
 * compatible open source license.
import org.opensearch.common.settings.Setting.Property;
 *
        MetadataIndexStateService indexStateService,
            );
    private void setCloseIndexEnabled(boolean closeIndexEnabled) {
                    + CLUSTER_INDICES_CLOSE_ENABLE_SETTING.getKey()
    protected void doExecute(Task task, CloseIndexRequest request, ActionListener<CloseIndexResponse> listener) {
        DestructiveOperations destructiveOperations
        return new CloseIndexResponse(in);
    private void validateRemoteMigration() {
    protected ClusterBlockException checkBlock(CloseIndexRequest request, ClusterState state) {
            CloseIndexRequest::new,
    protected CloseIndexResponse read(StreamInput in) throws IOException {
    protected void clusterManagerOperation(
            throw new IllegalStateException("Cannot close index while remote migration is ongoing");
        }));
    }
import org.opensearch.action.support.DestructiveOperations;
            request.timeout()
    }
    }
            logger.debug(() -> new ParameterizedMessage("failed to close indices [{}]", (Object) concreteIndices), t);
    @Inject
    }
        }
        ClusterSettings clusterSettings,
    ) {
        return indexNameExpressionResolver.concreteResolvedIndices(state, request);
        indexStateService.closeIndices(closeRequest, ActionListener.delegateResponse(listener, (delegatedListener, t) -> {
/*
    @Override
        this.destructiveOperations = destructiveOperations;
        this.closeIndexEnabled = CLUSTER_INDICES_CLOSE_ENABLE_SETTING.get(settings);
    }
                "closing indices is disabled - set ["
        destructiveOperations.failDestructive(request.indices());
     */
import org.opensearch.common.settings.ClusterSettings;
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * Unless required by applicable law or agreed to in writing,
    @Override
 * Close index action
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_INDICES_CLOSE_ENABLE_SETTING, this::setCloseIndexEnabled);
 * the Apache License, Version 2.0 (the "License"); you may
        // no need to use a thread pool, we go async right away
        final CloseIndexClusterStateUpdateRequest closeRequest = new CloseIndexClusterStateUpdateRequest(task.getId()).ackTimeout(
package org.opensearch.action.admin.indices.close;
        IndexNameExpressionResolver indexNameExpressionResolver,
        Settings settings,
            transportService,
public class TransportCloseIndexAction extends TransportClusterManagerNodeAction<CloseIndexRequest, CloseIndexResponse>
        )
import org.opensearch.node.remotestore.RemoteStoreNodeService.CompatibilityMode;
import org.opensearch.core.action.ActionListener;
    }
        Property.NodeScope
    protected String executor() {
    @Override
import org.opensearch.threadpool.ThreadPool;
 * Licensed to Elasticsearch under one or more contributor
    }
        TransportIndicesResolvingAction<CloseIndexRequest> {
    public static final Setting<Boolean> CLUSTER_INDICES_CLOSE_ENABLE_SETTING = Setting.boolSetting(
    private ResolvedIndices.Local.Concrete resolveIndices(ClusterState state, CloseIndexRequest request) {
        final Task task,
 * license agreements. See the NOTICE file distributed with
            delegatedListener.onFailure(t);
import org.opensearch.node.remotestore.RemoteStoreNodeService.Direction;
        super(
    );
 * software distributed under the License is distributed on an
    @Override
 */
            .indicesBlockedException(ClusterBlockLevel.METADATA_WRITE, indexNameExpressionResolver.concreteIndexNames(state, request));
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
    private volatile boolean closeIndexEnabled;
        validateRemoteMigration();
