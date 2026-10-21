                }
                                logger.debug(() -> new ParameterizedMessage("failed to perform [{}]", source), e);
    /**
        this.settings = settings;
                    return clusterUpdateSettingTaskKey;
                private volatile boolean changed = false;
                        currentState,
     */
        final ActionListener<ClusterUpdateSettingsResponse> listener
                    // to the components until the ClusterStateListener instances have been invoked, but are visible after
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.settings.SettingsException;
        );
    ) {
     * Verifies that while trying to change the compatibility mode, all nodes must have the same version.
            false,
            }
     * This invariant depends on cluster state (the stored scripts), so it cannot be expressed by a
        int effectiveMaxSize = SCRIPT_MAX_SIZE_IN_BYTES.get(effectiveSettings);
                        clusterSettings.upgradeSettings(request.transientSettings()),
                        reroute(true);
                }
                                );
     */
                    clusterState = checkAndFinalizeRemoteStoreMigration(isCompatibilityModeChanging, request, clusterState, logger);
                            public void onFailure(String source, Exception e) {
                    // Validate against the post-update state so the effective value is checked against the existing
 * @opensearch.internal
                    "Setting ["
                public ClusterState execute(final ClusterState currentState) {
        Settings settings = Settings.builder().put(request.persistentSettings()).put(request.transientSettings()).build();
                                        updateSettingsAcked,
    @Override
            throw new SettingsException(
                    );
                    validateScriptMaxSizeInBytes(request, clusterState);
            Settings settings = Settings.builder().put(request.transientSettings()).put(request.persistentSettings()).build();
 * SPDX-License-Identifier: Apache-2.0
        final ClusterUpdateSettingsRequest request,
    private final ClusterSettings clusterSettings;
            ClusterUpdateSettingsRequest::new,
        // Resolve the effective value the same way it is resolved at apply time: node settings (e.g. opensearch.yml)
            if (Metadata.SETTING_READ_ONLY_SETTING.exists(request.persistentSettings())
    }
                    }
 * Unless required by applicable law or agreed to in writing,
                    return new ClusterUpdateSettingsResponse(acknowledged, updater.getTransientUpdates(), updater.getPersistentUpdate());
    protected String executor() {
                    } else {
    ) {
                            @Override
 * not use this file except in compliance with the License.
        // since a reset can lower the effective limit below an already stored script.
    /**
                                logger.debug(
                                return new ClusterUpdateSettingsResponse(
    }
    ClusterUpdateSettingsResponse> {
                );
                }
/*
            // segments_only nodes never configure.
     */
        return new ClusterUpdateSettingsResponse(in);
                        return;
            return;
     * <p>
 * GitHub history for details.
                                return updateSettingsAcked;
                    // stored scripts before this state is published. This stateful invariant cannot be enforced by a
        IndexNameExpressionResolver indexNameExpressionResolver,
            transportService,
    private void validateAllNodesOfSameVersion(DiscoveryNodes discoveryNodes) {
import org.opensearch.cluster.service.ClusterService;
    private final AllocationService allocationService;
package org.opensearch.action.admin.cluster.settings;
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);
                            @Override
                throw new IllegalArgumentException(
        boolean allNodesRemoteStoreEnabled = discoveryNodes.getNodes()
    }
                public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
                                    new ClusterUpdateSettingsResponse(
 * this file be licensed under the Apache-2.0 license or a
                    return clusterState;
        // explicit reset-to-default — stored as a null-valued key, for which hasValue() is false — is still validated,
                @Override
            throw new SettingsException("can not change the compatibility mode when all the nodes in cluster are not of the same version");
import org.opensearch.common.settings.ClusterSettings;
            }
        clusterUpdateSettingTaskKey = clusterService.registerClusterManagerTask(CLUSTER_UPDATE_SETTINGS, true);
                        + CLUSTER_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey()
import org.opensearch.threadpool.ThreadPool;
     *
        if (request.transientSettings().keySet().contains(key) == false && request.persistentSettings().keySet().contains(key) == false) {
            if (RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING.get(
            || request.persistentSettings().hasValue(CLUSTER_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey())) {
 */
                        );
 *
import static org.opensearch.index.remote.RemoteStoreUtils.checkAndFinalizeRemoteStoreMigration;
            indexNameExpressionResolver
            threadPool,
                || Metadata.SETTING_READ_ONLY_SETTING.exists(request.transientSettings())
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;
        TransportService transportService,
                            }
        boolean allNodesDocrepEnabled = discoveryNodes.getNodes()
                                updater.getPersistentUpdate()
        }
            "cluster_update_settings",
import org.apache.logging.log4j.LogManager;
        this.allocationService = allocationService;
        super(
                                    "failed to preform reroute after cluster settings were updated - current node is no longer a cluster-manager"
                || Metadata.SETTING_READ_ONLY_ALLOW_DELETE_SETTING.exists(request.persistentSettings())) {
            // If default value (-1), no validation needed
     * Rejects a {@code script.max_size_in_bytes} update that would lower the limit below an already stored script.
            }
        final ClusterState state,
            ClusterUpdateSettingsAction.NAME,
                            }
        ThreadPool threadPool,
                                    updater.getPersistentUpdate()
                    // so we should *not* execute the reroute.
            .values()
                }
import org.opensearch.common.inject.Inject;
        // Only validate when the request actually touches the setting. keySet() (not hasValue()) is used so that an
                }
                                );
            .allMatch(discoveryNode -> discoveryNode.isRemoteStoreNode() == false);
 * compatible open source license.
        // would fall back to the default when the value is configured only in opensearch.yml.
    @Override
 * this work for additional information regarding copyright
     * also covers a reset-to-default that would lower the limit, not just an explicit smaller value.
    private final Settings settings;
 * The OpenSearch Contributors require contributions made to
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
            // remote backed. Keying off isRemoteStoreNode() would additionally demand a cluster state repository, which
                                listener.onResponse(
            .allMatch(discoveryNode -> discoveryNode.isRemoteStoreNode());
 *
    public TransportClusterUpdateSettingsAction(
                            // update settings was acknowledged
                        super.onAckTimeout();
    }
                                    updateSettingsAcked && acknowledged,
                private void reroute(final boolean updateSettingsAcked) {
                validateAllNodesOfSameType(clusterState.nodes());
import org.opensearch.script.ScriptService;
import org.opensearch.cluster.AckedClusterStateUpdateTask;
        return false;
        if (request.transientSettings().hasValue(CLUSTER_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey())
            }
                public void onAckTimeout() {
                        }
                                updateSettingsAcked,
    }
                                // we wait for the reroute ack only if the update settings was acknowledged
import org.opensearch.common.Priority;
            ) == RemoteStoreNodeService.CompatibilityMode.STRICT) {
    private static final Logger logger = LogManager.getLogger(TransportClusterUpdateSettingsAction.class);
                    // The reason the reroute needs to be send as separate update task, is that all the *cluster* settings are encapsulate
     * same type (all remote or all non-remote). If not, it throws SettingsException error
                // one of the settings above as the only setting in the request means - resetting the block!
    }
    private void validateAllNodesOfSameType(DiscoveryNodes discoveryNodes) {
            }
/*
                @Override
                .allMatch(discoveryNode -> discoveryNode.isRemoteSegmentStoreNode());
                .getNodes()
        }
            .stream()
 */
                        super.onAllNodesAcked(e);
        ClusterSettings clusterSettings,
                            )
                || Metadata.SETTING_READ_ONLY_ALLOW_DELETE_SETTING.exists(request.transientSettings())
                        "reroute_after_cluster_update_settings",
 * specific language governing permissions and limitations
            if (newValue == -1) {
    }
            .values()
     * @param request cluster settings update request, for settings to be updated and new values
import org.opensearch.common.settings.Settings;
                            public void onNoLongerClusterManager(String source) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 */
                    // For example the minimum_master_node could have been breached and we're no longer elected cluster-manager,
                    );
    @Inject
            // only one setting
                    ClusterState clusterState = updater.updateSettings(
                                // if the reroute fails we only log
        }
     * here rejects the update before it is published, instead of throwing while the state is applied (which was reachable
                                        updater.getTransientUpdates(),
        AllocationService allocationService,
                    }
                    super.onFailure(source, e);
 * Licensed to Elasticsearch under one or more contributor
     * Verifies that while trying to switch to STRICT compatibility mode, all nodes must be of the
                return;
                    } else {
                            // we return when the cluster reroute is acked or it times out but the acknowledged flag depends on whether the
            );
import org.opensearch.node.remotestore.RemoteStoreNodeService;
                            @Override
     * Runs various checks associated with changing cluster compatibility mode
import org.opensearch.transport.TransportService;
                        + "] can only be used with remote store enabled clusters"
 * under the License.
     * @return true if the incoming cluster settings update request is switching compatibility modes
                            @Override
                    // Setting.Validator; rejecting here avoids throwing at apply time.
        Settings effectiveSettings = Settings.builder().put(settings).put(updatedState.metadata().settings()).build();
import org.opensearch.cluster.node.DiscoveryNodes;
                @Override
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
                    // the first update task has been completed.
import org.opensearch.action.support.ActionFilters;
    public boolean validateCompatibilityModeSettingRequest(ClusterUpdateSettingsRequest request, ClusterState clusterState) {
     * @param discoveryNodes current discovery nodes in the cluster
                }
     * If not, it throws SettingsException error
 *
import org.opensearch.common.Nullable;
                            public ClusterState execute(final ClusterState currentState) {
    }
        // allow for dedicated changes to the metadata blocks, so we don't block those to allow to "re-enable" it
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.action.ActionListener;
public class TransportClusterUpdateSettingsAction extends TransportClusterManagerNodeAction<
        if (allNodesDocrepEnabled == false && allNodesRemoteStoreEnabled == false) {
                        logger
    private final ClusterManagerTaskThrottler.ThrottlingKey clusterUpdateSettingTaskKey;
                @Override
                "can not switch to STRICT compatibility mode when the cluster contains both remote and non-remote nodes"
                                updater.getTransientUpdates(),
            new AckedClusterStateUpdateTask<ClusterUpdateSettingsResponse>(Priority.IMMEDIATE, request, listener) {
                                return allocationService.reroute(currentState, "reroute after cluster update settings");
                            }
                                    updater.getTransientUpdates(),
                                // now, reroute in case things that require it changed (e.g. number of replicas)
                    // in the components (e.g. FilterAllocationDecider), so the changes made by the first call aren't visible
                            new ClusterUpdateSettingsResponse(
        }
     */
                    clusterService.submitStateUpdateTask(
 * license agreements. See the NOTICE file distributed with
        if (discoveryNodes.getMaxNodeVersion().equals(discoveryNodes.getMinNodeVersion()) == false) {
        ClusterService clusterService,
        );
import org.opensearch.cluster.block.ClusterBlockLevel;
        clusterService.submitStateUpdateTask(
        ActionFilters actionFilters,
     * @param discoveryNodes current discovery nodes in the cluster
                            public boolean mustAck(DiscoveryNode discoveryNode) {
    protected void clusterManagerOperation(
        this.clusterSettings = clusterSettings;
import java.io.IOException;
 *     http://www.apache.org/licenses/LICENSE-2.0
                        reroute(false);
import static org.opensearch.cluster.service.ClusterManagerTask.CLUSTER_UPDATE_SETTINGS;
import org.apache.logging.log4j.message.ParameterizedMessage;
    ClusterUpdateSettingsRequest,
    /**
 * software distributed under the License is distributed on an
        // Task is onboarded for throttling, it will get retried from associated TransportClusterManagerNodeAction.
            .stream()
                    if (changed) {
import static org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider.CLUSTER_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING;
                            }
                public void onFailure(String source, Exception e) {
}
    }
                public void onAllNodesAcked(@Nullable Exception e) {
        // overlaid with the post-update cluster settings. Reading metadata().settings() alone (cluster settings only)
                                    )
        }
        Settings settings
import org.opensearch.cluster.node.DiscoveryNode;
    /**
                        listener.onResponse(
     * {@link org.opensearch.common.settings.Setting.Validator}. Validating the effective value in the post-update state
                            @Override
/*
import org.opensearch.OpenSearchException;
        String key = SCRIPT_MAX_SIZE_IN_BYTES.getKey();
                protected ClusterUpdateSettingsResponse newResponse(boolean acknowledged) {
    private void validateClusterTotalPrimaryShardsPerNodeSetting(ClusterState currentState, ClusterUpdateSettingsRequest request) {
     * only at apply time and would destabilize the cluster-manager). Reading the effective value from the merged settings
                }
                    boolean isCompatibilityModeChanging = validateCompatibilityModeSettingRequest(request, state);
                        clusterSettings.upgradeSettings(request.persistentSettings()),
                @Override
        final SettingsUpdater updater = new SettingsUpdater(clusterSettings);
                        logger.debug("Skipping reroute after cluster update settings, because node is no longer cluster-manager");
                    if (changed) {
import org.opensearch.cluster.ClusterState;
                return null;
        }
            // Check current state. Balancing primaries is a placement concern, so it only requires the segments to be
    }
                    validateClusterTotalPrimaryShardsPerNodeSetting(currentState, request);
import org.opensearch.cluster.block.ClusterBlockException;
    @Override
import static org.opensearch.script.ScriptService.SCRIPT_MAX_SIZE_IN_BYTES;
    protected ClusterUpdateSettingsResponse read(StreamInput in) throws IOException {
 */
                                        updater.getPersistentUpdate()
            boolean allNodesRemoteSegmentStoreEnabled = currentState.nodes()
import org.opensearch.cluster.metadata.Metadata;
        ScriptService.validateMaxSizeInBytes(effectiveMaxSize, updatedState);
                    changed = clusterState != currentState;
            clusterService,
 * Transport action for updating cluster settings
        return ThreadPool.Names.SAME;
import org.opensearch.cluster.routing.allocation.AllocationService;
            if (!allNodesRemoteSegmentStoreEnabled) {
                                listener.onFailure(new OpenSearchException("reroute after update settings failed", e));
    @Override
import org.apache.logging.log4j.Logger;
 *
                            protected ClusterUpdateSettingsResponse newResponse(boolean acknowledged) {
                    if (!clusterService.state().nodes().isLocalNodeElectedClusterManager()) {
                settings
                .values()
            actionFilters,
 * ownership. Elasticsearch licenses this file to you under
/**
                            }
import org.opensearch.core.common.io.stream.StreamInput;
                @Override
     * @param clusterState current state of cluster, for information on nodes
                        new AckedClusterStateUpdateTask<ClusterUpdateSettingsResponse>(Priority.URGENT, request, listener) {
                    // We're about to send a second update task, so we need to check if we're still the elected cluster-manager
 * Modifications Copyright OpenSearch Contributors. See
    protected ClusterBlockException checkBlock(ClusterUpdateSettingsRequest request, ClusterState state) {
        if (request.transientSettings().size() + request.persistentSettings().size() == 1) {
                    }
                                );
 * You may obtain a copy of the License at
            return true;
            int newValue = CLUSTER_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.get(settings);
    private void validateScriptMaxSizeInBytes(ClusterUpdateSettingsRequest request, ClusterState updatedState) {
                    logger.debug(() -> new ParameterizedMessage("failed to perform [{}]", source), e);
                .stream()
            validateAllNodesOfSameVersion(clusterState.nodes());
        if (RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING.exists(settings)) {
