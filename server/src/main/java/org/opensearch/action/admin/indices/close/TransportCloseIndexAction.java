    }
import java.io.IOException;  
    protected String executor() {
        Property.NodeScope  
 * The OpenSearch Contributors require contributions made to  
    @Override
        "cluster.indices.close.enable",  
            clusterService,  
    protected void clusterManagerOperation(  
 * Licensed to Elasticsearch under one or more contributor  
            .clusterManagerNodeTimeout(request.clusterManagerNodeTimeout())  
 * this work for additional information regarding copyright
import org.opensearch.action.support.TransportIndicesResolvingAction;  
        this.indexStateService = indexStateService;  
 * license agreements. See the NOTICE file distributed with
    /**  
        CompatibilityMode compatibilityMode = clusterSettings.get(RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING);  
        Property.Dynamic,
 * under the License.  
import org.apache.logging.log4j.LogManager;
 * Close index action
 *
    @Override
        ClusterService clusterService,
 * not use this file except in compliance with the License.
    }
        final Index[] concreteIndices = resolveIndices(state, request).concreteIndicesAsArray();  
import org.opensearch.common.settings.Setting.Property;  
import org.opensearch.common.settings.Settings;
        TransportIndicesResolvingAction<CloseIndexRequest> {
            delegatedListener.onFailure(t);
        final ActionListener<CloseIndexResponse> listener
        ClusterSettings clusterSettings = clusterService.getClusterSettings();
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
            throw new IllegalStateException(
    private volatile boolean closeIndexEnabled;
            CloseIndexRequest::new,  
    }  
        }
    public ResolvedIndices resolveIndices(CloseIndexRequest request) {
        // no need to use a thread pool, we go async right away  
    ) {
    private ResolvedIndices.Local.Concrete resolveIndices(ClusterState state, CloseIndexRequest request) {  
            .waitForActiveShards(request.waitForActiveShards())
    protected ClusterBlockException checkBlock(CloseIndexRequest request, ClusterState state) {  
        }));  
        this.closeIndexEnabled = CLUSTER_INDICES_CLOSE_ENABLE_SETTING.get(settings);
import org.opensearch.cluster.metadata.ResolvedIndices;
import org.opensearch.action.support.ActionFilters;
            listener.onResponse(new CloseIndexResponse(true, false, Collections.emptyList()));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final CloseIndexClusterStateUpdateRequest closeRequest = new CloseIndexClusterStateUpdateRequest(task.getId()).ackTimeout(  
                    + CLUSTER_INDICES_CLOSE_ENABLE_SETTING.getKey()  
        final ClusterState state,
import org.opensearch.action.support.DestructiveOperations;
        super(  
            indexNameExpressionResolver
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
 *  
     * Reject close index request if cluster mode is [MIXED] and migration direction is [RemoteStore]
    private final DestructiveOperations destructiveOperations;  
import org.opensearch.transport.TransportService;
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_INDICES_CLOSE_ENABLE_SETTING, this::setCloseIndexEnabled);  
    }  
import org.apache.logging.log4j.Logger;
        super.doExecute(task, request, listener);
        TransportService transportService,  
        return indexNameExpressionResolver.concreteResolvedIndices(state, request);
    protected void doExecute(Task task, CloseIndexRequest request, ActionListener<CloseIndexResponse> listener) {
        DestructiveOperations destructiveOperations
    private void setCloseIndexEnabled(boolean closeIndexEnabled) {  
 * the Apache License, Version 2.0 (the "License"); you may
        }  
import java.util.Collections;
 * SPDX-License-Identifier: Apache-2.0
        this.destructiveOperations = destructiveOperations;
            threadPool,
    @Inject  
        )
 * Modifications Copyright OpenSearch Contributors. See
        if (concreteIndices == null || concreteIndices.length == 0) {
    );
            );
    public TransportCloseIndexAction(
    }
        Settings settings,
import org.opensearch.core.index.Index;
 * specific language governing permissions and limitations
    }  
    }
import org.opensearch.cluster.service.ClusterService;
public class TransportCloseIndexAction extends TransportClusterManagerNodeAction<CloseIndexRequest, CloseIndexResponse>
        ActionFilters actionFilters,
 */  
import org.opensearch.tasks.Task;
        final CloseIndexRequest request,
        MetadataIndexStateService indexStateService,  
    }
import org.opensearch.cluster.ClusterState;
import org.opensearch.node.remotestore.RemoteStoreNodeService;
    public static final Setting<Boolean> CLUSTER_INDICES_CLOSE_ENABLE_SETTING = Setting.boolSetting(
            return;  
    protected void clusterManagerOperation(  
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
            .indices(concreteIndices);
            transportService,
    @Override
    private void validateRemoteMigration() {
     */  
        return state.blocks()
 */  
            actionFilters,
    }
import org.opensearch.cluster.metadata.MetadataIndexStateService;  
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
     * @throws IllegalStateException if cluster mode is [MIXED] and migration direction is [RemoteStore]
    ) {
 * @opensearch.internal  
 * GitHub history for details.
 *
/*  
    }
}  
 * software distributed under the License is distributed on an
        return new CloseIndexResponse(in);  
        ClusterSettings clusterSettings,
import org.opensearch.node.remotestore.RemoteStoreNodeService.Direction;
        true,
import org.opensearch.node.remotestore.RemoteStoreNodeService.CompatibilityMode;  
        return ResolvedIndices.of(resolveIndices(clusterService.state(), request));  
            .indicesBlockedException(ClusterBlockLevel.METADATA_WRITE, indexNameExpressionResolver.concreteIndexNames(state, request));
        indexStateService.closeIndices(closeRequest, ActionListener.delegateResponse(listener, (delegatedListener, t) -> {  
        final ActionListener<CloseIndexResponse> listener  
            request.timeout()
        destructiveOperations.failDestructive(request.indices());
        }
package org.opensearch.action.admin.indices.close;
        IndexNameExpressionResolver indexNameExpressionResolver,  
        final Task task,
    ) throws Exception {
                    + ": true] to enable it. NOTE: closed indices still consume a significant amount of diskspace"
 * You may obtain a copy of the License at  
import org.opensearch.common.settings.Setting;
 * ownership. Elasticsearch licenses this file to you under  
    @Override  
 */
import org.opensearch.common.settings.ClusterSettings;
        return ThreadPool.Names.SAME;
    @Override
        );
/**  
/*
/*  
        Direction migrationDirection = clusterSettings.get(RemoteStoreNodeService.MIGRATION_DIRECTION_SETTING);
        if (compatibilityMode == CompatibilityMode.MIXED && migrationDirection == Direction.REMOTE_STORE) {
    }
import org.opensearch.core.action.ActionListener;
    implements  
        validateRemoteMigration();
 *
import org.opensearch.threadpool.ThreadPool;  
            CloseIndexAction.NAME,
                "closing indices is disabled - set ["
            throw new IllegalStateException("Cannot close index while remote migration is ongoing");  
import org.opensearch.common.inject.Inject;  
    private final MetadataIndexStateService indexStateService;
    protected CloseIndexResponse read(StreamInput in) throws IOException {
import org.apache.logging.log4j.message.ParameterizedMessage;  
        throw new UnsupportedOperationException("The task parameter is required");
import org.opensearch.cluster.block.ClusterBlockException;  
import org.opensearch.core.common.io.stream.StreamInput;  
import org.opensearch.cluster.block.ClusterBlockLevel;
    private static final Logger logger = LogManager.getLogger(TransportCloseIndexAction.class);  
    @Override
        if (closeIndexEnabled == false) {  
        final ClusterState state,  
 * this file be licensed under the Apache-2.0 license or a
            logger.debug(() -> new ParameterizedMessage("failed to close indices [{}]", (Object) concreteIndices), t);
        ThreadPool threadPool,
        this.closeIndexEnabled = closeIndexEnabled;
 * KIND, either express or implied.  See the License for the
        final CloseIndexRequest request,
    @Override
