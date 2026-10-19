                            @Override
     * Rejects a {@code script.max_size_in_bytes} update that would lower the limit below an already stored script.  
            "cluster_update_settings",
            .values()
        if (request.transientSettings().keySet().contains(key) == false && request.persistentSettings().keySet().contains(key) == false) {
                }
import org.opensearch.node.remotestore.RemoteStoreNodeService;
     * <p>
     * Runs various checks associated with changing cluster compatibility mode
import org.opensearch.cluster.node.DiscoveryNode;
            new AckedClusterStateUpdateTask<ClusterUpdateSettingsResponse>(Priority.IMMEDIATE, request, listener) {
 * this file be licensed under the Apache-2.0 license or a
        TransportService transportService,
 * GitHub history for details.
            // If default value (-1), no validation needed
                            public ClusterState execute(final ClusterState currentState) {
                || Metadata.SETTING_READ_ONLY_ALLOW_DELETE_SETTING.exists(request.persistentSettings())) {
import java.io.IOException;
 *
                protected ClusterUpdateSettingsResponse newResponse(boolean acknowledged) {  
            actionFilters,
                        new AckedClusterStateUpdateTask<ClusterUpdateSettingsResponse>(Priority.URGENT, request, listener) {
    }  
                public void onAllNodesAcked(@Nullable Exception e) {
import org.opensearch.core.action.ActionListener;  
                            }
                    // the first update task has been completed.
                        clusterSettings.upgradeSettings(request.transientSettings()),  
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
        clusterService.submitStateUpdateTask(  
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);  
import org.opensearch.common.Priority;
import org.apache.logging.log4j.message.ParameterizedMessage;  
                    // The reason the reroute needs to be send as separate update task, is that all the *cluster* settings are encapsulate
                    clusterService.submitStateUpdateTask(  
                    } else {
                @Override
                        listener.onResponse(
            .allMatch(discoveryNode -> discoveryNode.isRemoteStoreNode());
        if (RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING.exists(settings)) {
    ClusterUpdateSettingsRequest,
import org.opensearch.core.common.io.stream.StreamInput;
            }
                private volatile boolean changed = false;
 * Transport action for updating cluster settings  
            throw new SettingsException(  
import org.apache.logging.log4j.LogManager;
    @Override  
package org.opensearch.action.admin.cluster.settings;
                                logger.debug(() -> new ParameterizedMessage("failed to perform [{}]", source), e);
 * Unless required by applicable law or agreed to in writing,
        final ClusterState state,
                    }
        }  
        // explicit reset-to-default — stored as a null-valued key, for which hasValue() is false — is still validated,
 * @opensearch.internal
     * same type (all remote or all non-remote). If not, it throws SettingsException error
    private final ClusterManagerTaskThrottler.ThrottlingKey clusterUpdateSettingTaskKey;
            threadPool,
 * this work for additional information regarding copyright
                settings
        ThreadPool threadPool,
        // would fall back to the default when the value is configured only in opensearch.yml.  
    private final ClusterSettings clusterSettings;  
     * here rejects the update before it is published, instead of throwing while the state is applied (which was reachable
import org.opensearch.cluster.block.ClusterBlockException;  
                            new ClusterUpdateSettingsResponse(
                            }
        // Resolve the effective value the same way it is resolved at apply time: node settings (e.g. opensearch.yml)
    }
     * also covers a reset-to-default that would lower the limit, not just an explicit smaller value.  
                                listener.onResponse(
            }
                                return allocationService.reroute(currentState, "reroute after cluster update settings");  
            clusterService,  
     * @param discoveryNodes current discovery nodes in the cluster
                "can not switch to STRICT compatibility mode when the cluster contains both remote and non-remote nodes"
        IndexNameExpressionResolver indexNameExpressionResolver,
        Settings effectiveSettings = Settings.builder().put(settings).put(updatedState.metadata().settings()).build();
            indexNameExpressionResolver
                throw new IllegalArgumentException(
 */  
     * only at apply time and would destabilize the cluster-manager). Reading the effective value from the merged settings
    ) {
        if (allNodesDocrepEnabled == false && allNodesRemoteStoreEnabled == false) {
    }
        }  
                        logger
            // Check current state. Balancing primaries is a placement concern, so it only requires the segments to be
        if (request.transientSettings().hasValue(CLUSTER_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey())
 * ownership. Elasticsearch licenses this file to you under  
 *
                public void onAckTimeout() {
                        currentState,
                    // to the components until the ClusterStateListener instances have been invoked, but are visible after
                                // if the reroute fails we only log
            }
                }
                                    updater.getPersistentUpdate()
        }  
            false,
     *  
            if (RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING.get(  
                }
        super(
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;
    }
        clusterUpdateSettingTaskKey = clusterService.registerClusterManagerTask(CLUSTER_UPDATE_SETTINGS, true);
import org.opensearch.script.ScriptService;  
    protected ClusterUpdateSettingsResponse read(StreamInput in) throws IOException {
                    return clusterState;
                        super.onAckTimeout();  
                    clusterState = checkAndFinalizeRemoteStoreMigration(isCompatibilityModeChanging, request, clusterState, logger);
        return new ClusterUpdateSettingsResponse(in);
                        reroute(false);
    private void validateScriptMaxSizeInBytes(ClusterUpdateSettingsRequest request, ClusterState updatedState) {
                }  
                        reroute(true);
            if (newValue == -1) {  
                            // update settings was acknowledged  
import org.opensearch.cluster.ClusterState;
                                    updateSettingsAcked && acknowledged,  
                                    updater.getTransientUpdates(),
        ActionFilters actionFilters,  
                @Override
import org.opensearch.cluster.metadata.Metadata;  
        final ActionListener<ClusterUpdateSettingsResponse> listener  
import org.opensearch.cluster.node.DiscoveryNodes;
     * @param clusterState current state of cluster, for information on nodes
                                );
import org.opensearch.common.settings.ClusterSettings;  
            .stream()  
public class TransportClusterUpdateSettingsAction extends TransportClusterManagerNodeAction<
                validateAllNodesOfSameType(clusterState.nodes());  
            Settings settings = Settings.builder().put(request.transientSettings()).put(request.persistentSettings()).build();
                || Metadata.SETTING_READ_ONLY_ALLOW_DELETE_SETTING.exists(request.transientSettings())  
    /**
                        );
                .allMatch(discoveryNode -> discoveryNode.isRemoteSegmentStoreNode());
import org.opensearch.cluster.routing.allocation.AllocationService;  
                                listener.onFailure(new OpenSearchException("reroute after update settings failed", e));  
                );  
            ) == RemoteStoreNodeService.CompatibilityMode.STRICT) {
        this.settings = settings;
    @Override
        // overlaid with the post-update cluster settings. Reading metadata().settings() alone (cluster settings only)
                                        updater.getTransientUpdates(),
    @Override
            .values()
        }  
            if (Metadata.SETTING_READ_ONLY_SETTING.exists(request.persistentSettings())
                                updater.getTransientUpdates(),
 *  
            || request.persistentSettings().hasValue(CLUSTER_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey())) {
        final SettingsUpdater updater = new SettingsUpdater(clusterSettings);
        boolean allNodesDocrepEnabled = discoveryNodes.getNodes()  
                                logger.debug(
                @Override
import org.apache.logging.log4j.Logger;
                return;
import org.opensearch.action.support.ActionFilters;
            boolean allNodesRemoteSegmentStoreEnabled = currentState.nodes()
                private void reroute(final boolean updateSettingsAcked) {
            // only one setting  
                || Metadata.SETTING_READ_ONLY_SETTING.exists(request.transientSettings())
                            @Override  
        this.clusterSettings = clusterSettings;
        ClusterSettings clusterSettings,
 * compatible open source license.
        if (request.transientSettings().size() + request.persistentSettings().size() == 1) {
 *     http://www.apache.org/licenses/LICENSE-2.0
     * If not, it throws SettingsException error  
        // since a reset can lower the effective limit below an already stored script.
 * The OpenSearch Contributors require contributions made to  
        }
import org.opensearch.threadpool.ThreadPool;
 */
     * Verifies that while trying to switch to STRICT compatibility mode, all nodes must be of the
                    );  
                            public void onNoLongerClusterManager(String source) {
    }  
                                        updateSettingsAcked,
    private void validateAllNodesOfSameVersion(DiscoveryNodes discoveryNodes) {  
        );
import static org.opensearch.cluster.service.ClusterManagerTask.CLUSTER_UPDATE_SETTINGS;
            throw new SettingsException("can not change the compatibility mode when all the nodes in cluster are not of the same version");
                    changed = clusterState != currentState;  
            transportService,
                    // We're about to send a second update task, so we need to check if we're still the elected cluster-manager
                            }
                return null;  
        int effectiveMaxSize = SCRIPT_MAX_SIZE_IN_BYTES.get(effectiveSettings);
        String key = SCRIPT_MAX_SIZE_IN_BYTES.getKey();  
            return true;
    private void validateClusterTotalPrimaryShardsPerNodeSetting(ClusterState currentState, ClusterUpdateSettingsRequest request) {  
                            @Override
                                updateSettingsAcked,  
import org.opensearch.cluster.AckedClusterStateUpdateTask;
                    boolean isCompatibilityModeChanging = validateCompatibilityModeSettingRequest(request, state);  
 * not use this file except in compliance with the License.
                            )  
                    } else {
import static org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider.CLUSTER_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING;  
                                return updateSettingsAcked;
                public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
    }
        Settings settings = Settings.builder().put(request.persistentSettings()).put(request.transientSettings()).build();  
                @Override  
import static org.opensearch.script.ScriptService.SCRIPT_MAX_SIZE_IN_BYTES;  
                // one of the settings above as the only setting in the request means - resetting the block!
            validateAllNodesOfSameVersion(clusterState.nodes());
        return ThreadPool.Names.SAME;
                            // we return when the cluster reroute is acked or it times out but the acknowledged flag depends on whether the
        this.allocationService = allocationService;  
        // allow for dedicated changes to the metadata blocks, so we don't block those to allow to "re-enable" it
                            }
            .stream()
        Settings settings  
    }
                        "reroute_after_cluster_update_settings",
            .allMatch(discoveryNode -> discoveryNode.isRemoteStoreNode() == false);  
                                // now, reroute in case things that require it changed (e.g. number of replicas)
import org.opensearch.common.settings.SettingsException;
     */
            // segments_only nodes never configure.  
                .values()  
        }
/*  
     * Verifies that while trying to change the compatibility mode, all nodes must have the same version.
                    // Setting.Validator; rejecting here avoids throwing at apply time.  
    @Inject  
        AllocationService allocationService,
                                    )
import org.opensearch.common.inject.Inject;
            ClusterUpdateSettingsRequest::new,  
    /**
}
                }
            }
        return false;
            int newValue = CLUSTER_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.get(settings);  
                    );  
    }
    ClusterUpdateSettingsResponse> {  
                }
                                return new ClusterUpdateSettingsResponse(
                                updater.getPersistentUpdate()
    protected void clusterManagerOperation(  
                        + "] can only be used with remote store enabled clusters"
                                );
                        }
                    validateClusterTotalPrimaryShardsPerNodeSetting(currentState, request);
                            }  
                        super.onAllNodesAcked(e);  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        boolean allNodesRemoteStoreEnabled = discoveryNodes.getNodes()
        final ClusterUpdateSettingsRequest request,
     * {@link org.opensearch.common.settings.Setting.Validator}. Validating the effective value in the post-update state  
                public void onFailure(String source, Exception e) {
import org.opensearch.cluster.service.ClusterService;
                            public boolean mustAck(DiscoveryNode discoveryNode) {
    ) {
            return;
import org.opensearch.common.Nullable;  
            );
 * KIND, either express or implied.  See the License for the
                            @Override  
                            protected ClusterUpdateSettingsResponse newResponse(boolean acknowledged) {
                    // stored scripts before this state is published. This stateful invariant cannot be enforced by a
    public boolean validateCompatibilityModeSettingRequest(ClusterUpdateSettingsRequest request, ClusterState clusterState) {
                    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                .getNodes()
    public TransportClusterUpdateSettingsAction(
    protected ClusterBlockException checkBlock(ClusterUpdateSettingsRequest request, ClusterState state) {  
     * @param request cluster settings update request, for settings to be updated and new values
    /**  
        // Task is onboarded for throttling, it will get retried from associated TransportClusterManagerNodeAction.
import org.opensearch.cluster.block.ClusterBlockLevel;
            if (!allNodesRemoteSegmentStoreEnabled) {
 *
    protected String executor() {
                    // so we should *not* execute the reroute.
                @Override  
                                    "failed to preform reroute after cluster settings were updated - current node is no longer a cluster-manager"  
                    // in the components (e.g. FilterAllocationDecider), so the changes made by the first call aren't visible  
                    return new ClusterUpdateSettingsResponse(acknowledged, updater.getTransientUpdates(), updater.getPersistentUpdate());
            ClusterUpdateSettingsAction.NAME,  
     */
     * This invariant depends on cluster state (the stored scripts), so it cannot be expressed by a
import org.opensearch.OpenSearchException;
import org.opensearch.transport.TransportService;
import org.opensearch.common.settings.Settings;
                                        updater.getPersistentUpdate()  
 * Modifications Copyright OpenSearch Contributors. See
                    if (!clusterService.state().nodes().isLocalNodeElectedClusterManager()) {
 * software distributed under the License is distributed on an
/*
        ScriptService.validateMaxSizeInBytes(effectiveMaxSize, updatedState);  
                    super.onFailure(source, e);  
     * @return true if the incoming cluster settings update request is switching compatibility modes  
            // remote backed. Keying off isRemoteStoreNode() would additionally demand a cluster state repository, which
                .stream()
 * specific language governing permissions and limitations
                    "Setting ["  
                            public void onFailure(String source, Exception e) {  
                                // we wait for the reroute ack only if the update settings was acknowledged  
        if (discoveryNodes.getMaxNodeVersion().equals(discoveryNodes.getMinNodeVersion()) == false) {
                    if (changed) {  
                    logger.debug(() -> new ParameterizedMessage("failed to perform [{}]", source), e);
                        return;
    private final Settings settings;
                    return clusterUpdateSettingTaskKey;
/**
                    }
     */
            }  
                @Override  
    private static final Logger logger = LogManager.getLogger(TransportClusterUpdateSettingsAction.class);
                    // Validate against the post-update state so the effective value is checked against the existing
        ClusterService clusterService,  
     */
 */  
                    validateScriptMaxSizeInBytes(request, clusterState);
    private void validateAllNodesOfSameType(DiscoveryNodes discoveryNodes) {
                    // For example the minimum_master_node could have been breached and we're no longer elected cluster-manager,  
 * under the License.  
import static org.opensearch.index.remote.RemoteStoreUtils.checkAndFinalizeRemoteStoreMigration;
    }
    @Override  
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;  
        // Only validate when the request actually touches the setting. keySet() (not hasValue()) is used so that an  
    /**
                    ClusterState clusterState = updater.updateSettings(
                                    new ClusterUpdateSettingsResponse(  
                                );  
                    if (changed) {  
 */  
                public ClusterState execute(final ClusterState currentState) {
                        + CLUSTER_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey()
    }  
 * You may obtain a copy of the License at  
     * @param discoveryNodes current discovery nodes in the cluster  
 * the Apache License, Version 2.0 (the "License"); you may
    private final AllocationService allocationService;
/*  
        );
                        clusterSettings.upgradeSettings(request.persistentSettings()),
                            @Override
                        logger.debug("Skipping reroute after cluster update settings, because node is no longer cluster-manager");  
                }
 * Licensed to Elasticsearch under one or more contributor  
