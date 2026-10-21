            clusterService.submitStateUpdateTask("local-gateway-elected-state", new RecoverStateUpdateTask() {
        if (enforceRecoverAfterTime && recoverAfterTime != null) {
        if (RECOVER_AFTER_TIME_SETTING.exists(settings)) {
 * this work for additional information regarding copyright
 */
        scheduledRecovery.set(false);
    }
            if (recoveryInProgress.compareAndSet(false, true)) {
        if (state.blocks().hasGlobalBlock(STATE_NOT_RECOVERED_BLOCK) == false) {
        }
                // one of the expected is set, see if all of them meet the need, and ignore the timeout in this case
        if (state.nodes().isLocalNodeElectedClusterManager() == false) {
        this.expectedDataNodes = EXPECTED_DATA_NODES_SETTING.get(settings);
import org.opensearch.cluster.block.ClusterBlockLevel;
        @Override
                reason = "";
        // allow to control a delay of when indices will get created
import org.opensearch.cluster.ClusterState;
            final Gateway gateway = new Gateway(settings, clusterService, listGatewayMetaState);
import org.opensearch.cluster.block.ClusterBlock;
import org.opensearch.cluster.routing.allocation.AllocationService;
import org.opensearch.cluster.node.DiscoveryNodes;
        public void onSuccess(final ClusterState recoveredState) {
        }
                    }
 */
 * not use this file except in compliance with the License.
    @Inject
        }
        "gateway.recover_after_data_nodes",
/*
        }
            if (currentState.blocks().hasGlobalBlock(STATE_NOT_RECOVERED_BLOCK) == false) {
        } else {
                    public void onFailure(final Exception e) {
            // reset flag even though state recovery completed, to ensure that if we subsequently become leader again based on a
        } else if (expectedDataNodes >= 0) {
                    reason = "expecting [" + expectedDataNodes + "] data nodes, but only have [" + nodes.getDataNodes().size() + "]";
        }
 * Licensed to Elasticsearch under one or more contributor
                public ClusterState execute(final ClusterState currentState) {
 * specific language governing permissions and limitations
import org.apache.logging.log4j.LogManager;
                threadPool.schedule(new AbstractRunnable() {
    public static final Setting<Integer> EXPECTED_DATA_NODES_SETTING = Setting.intSetting(
                    public void onFailure(Exception e) {
 * SPDX-License-Identifier: Apache-2.0
                        logger.warn("delayed state recovery failed", e);
    }
                logger.info("delaying initial state recovery for [{}]. {}", recoverAfterTime, reason);
            }
                    @Override
import org.opensearch.cluster.ClusterStateListener;
                nodes.getDataNodes().size(),
            resetRecoveredFlags();
            }
        } else {
            resetRecoveredFlags();
        }
        }
    protected void doStop() {
        "gateway.recover_after_time",
        @Override
        } else if (recoverAfterDataNodes != -1 && nodes.getDataNodes().size() < recoverAfterDataNodes) {
 *
                .andThen(ClusterStateUpdaters::updateRoutingTable)
    private final AllocationService allocationService;
                // no expected is set, honor the setting if they are there
        public void onFailure(final String msg) {
    private static final Logger logger = LogManager.getLogger(GatewayService.class);
    }
        public void onFailure(final String source, final Exception e) {
import java.util.concurrent.atomic.AtomicBoolean;
 * GitHub history for details.
            } else {
            return allocationService.reroute(newState, "state recovered");
        true,
    public static final Setting<Integer> RECOVER_AFTER_DATA_NODES_SETTING = Setting.intSetting(
            performStateRecovery(enforceRecoverAfterTime, reason);
package org.opensearch.gateway;
                    }
                    @Override
/**
                            recoveryRunnable.run();
        final DiscoveryNodes nodes = state.nodes();
    TimeValue recoverAfterTime() {
    }
public class GatewayService extends AbstractLifecycleComponent implements ClusterStateListener {
        Property.NodeScope
import org.opensearch.cluster.coordination.Coordinator;
                }
        return recoverAfterTime;
    static final TimeValue DEFAULT_RECOVER_AFTER_TIME_IF_EXPECTED_NODES_IS_SET = TimeValue.timeValueMinutes(5);
                    enforceRecoverAfterTime = true;
            clusterService.addListener(this);
        @Override
            recoveryRunnable = () -> gateway.performStateRecovery(new GatewayRecoveryListener());
        @Override
            // not-recovered state, that we again do another state recovery.
                enforceRecoverAfterTime = true;
 *
    private final ClusterService clusterService;
        true,
                reason = "recover_after_time was set to [" + recoverAfterTime + "]";
                    }
 * license agreements. See the NOTICE file distributed with
    private void resetRecoveredFlags() {
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.discovery.Discovery;
}
    // used for testing
        ClusterBlockLevel.ALL
 * ownership. Elasticsearch licenses this file to you under
                }
            logger.debug("stepped down as cluster-manager before recovering state [{}]", source);
import org.opensearch.common.settings.Setting.Property;
            return;
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
        Property.NodeScope
                    }
import org.opensearch.common.settings.Settings;
    public static final ClusterBlock STATE_NOT_RECOVERED_BLOCK = new ClusterBlock(
    protected void doClose() {}
        final ThreadPool threadPool,
            }
                }, recoverAfterTime, ThreadPool.Names.GENERIC);
    );
            }
import org.opensearch.cluster.service.ClusterService;
        -1,
            });
    class GatewayRecoveryListener implements Gateway.GatewayStateRecoveredListener {
                if (nodes.getDataNodes().size() < expectedDataNodes) { // does not meet the expected...
        } else {
                    protected void doRun() {
                        logger.warn("state recovery failed", e);
            logger.info(() -> new ParameterizedMessage("unexpected failure during [{}]", source), e);
            recoverAfterTime = RECOVER_AFTER_TIME_SETTING.get(settings);
    }
                "not recovering from gateway, nodes_size (data) [{}] < recover_after_data_nodes [{}]",
 *
        final ClusterService clusterService,
                        }
    }
    private final Runnable recoveryRunnable;
        final AllocationService allocationService,
        RestStatus.SERVICE_UNAVAILABLE,
import java.util.function.Function;
        public void clusterStateProcessed(final String source, final ClusterState oldState, final ClusterState newState) {
    private final int recoverAfterDataNodes;
        -1,
        this.recoverAfterDataNodes = RECOVER_AFTER_DATA_NODES_SETTING.get(settings);
            logger.debug(
                enforceRecoverAfterTime = false;
 * @opensearch.internal
        if (lifecycle.stoppedOrClosed()) {
    public void clusterChanged(final ClusterChangedEvent event) {
                });
        }
    @Override
    private final TimeValue recoverAfterTime;
            final ClusterState newState = Function.<ClusterState>identity()
    private final AtomicBoolean scheduledRecovery = new AtomicBoolean();
        "gateway.expected_data_nodes",
 * compatible open source license.
 *
            logger.info("state recovery failed: {}", msg);
    }
    private final ThreadPool threadPool;
import org.opensearch.common.util.concurrent.AbstractRunnable;
        final Discovery discovery
        1,
                @Override
            recoverAfterTime = null;
 * Modifications Copyright OpenSearch Contributors. See
        this.clusterService = clusterService;
import org.opensearch.common.settings.Setting;
                    protected void doRun() {
        @Override
        this.allocationService = allocationService;
    class RecoverStateUpdateTask extends ClusterStateUpdateTask {
            resetRecoveredFlags();
 * The OpenSearch Contributors require contributions made to
import org.opensearch.cluster.ClusterStateUpdateTask;
/*
    private void performStateRecovery(final boolean enforceRecoverAfterTime, final String reason) {
            recoveryRunnable = () -> clusterService.submitStateUpdateTask("local-gateway-elected-state", new RecoverStateUpdateTask());
                        logger.debug("performing state recovery...");
 */
 * under the License.
        "state not recovered / initialized",
        TimeValue.timeValueMillis(0),
        final Settings settings,
            logger.info("recovered [{}] indices into cluster_state", newState.metadata().indices().size());
    @Override
            boolean enforceRecoverAfterTime;
        -1,
    );
 */
                            logger.info("recover_after_time [{}] elapsed. performing state recovery...", recoverAfterTime);
 *    http://www.apache.org/licenses/LICENSE-2.0
                        if (recoveryInProgress.compareAndSet(false, true)) {
        }
            // already recovered
        }
                logger.debug("cluster is already recovered");
                        resetRecoveredFlags();
            logger.trace("successful state recovery, importing cluster state...");
 * software distributed under the License is distributed on an
            return;
        public void onNoLongerClusterManager(String source) {
import org.opensearch.threadpool.ThreadPool;
        final TransportNodesListGatewayMetaState listGatewayMetaState,
        @Override
        public ClusterState execute(final ClusterState currentState) {
        if (DiscoveryNode.isClusterManagerNode(clusterService.getSettings())) {
            logger.debug("not recovering from gateway, no cluster-manager elected yet");
 * this file be licensed under the Apache-2.0 license or a
            // not our job to recover
 * You may obtain a copy of the License at
    private final int expectedDataNodes;
                    @Override
        if (state.nodes().getClusterManagerNodeId() == null) {
    );
        }
 * the Apache License, Version 2.0 (the "License"); you may
            if (scheduledRecovery.compareAndSet(false, true)) {
                return currentState;
/*
        } else {
 * The Gateway Service provider
        false,
            recoverAfterTime = DEFAULT_RECOVER_AFTER_TIME_IF_EXPECTED_NODES_IS_SET;
    }
import org.opensearch.common.inject.Inject;
    );
        }
            if (expectedDataNodes == -1) {
    ) {
import org.apache.logging.log4j.message.ParameterizedMessage;
                        recoveryRunnable.run();
    @Override
                recoverAfterDataNodes
                    final ClusterState updatedState = ClusterStateUpdaters.mixCurrentStateAndRecoveredState(currentState, recoveredState);
    @Override
    }
    public GatewayService(
            return;
import org.apache.logging.log4j.Logger;
    public static final Setting<TimeValue> RECOVER_AFTER_TIME_SETTING = Setting.positiveTimeSetting(
        this.threadPool = threadPool;
                    @Override
                threadPool.generic().execute(new AbstractRunnable() {
        if (discovery instanceof Coordinator) {
                .apply(currentState);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                        resetRecoveredFlags();
            resetRecoveredFlags();
            String reason;
        final ClusterState state = event.state();
        Property.NodeScope
 * Unless required by applicable law or agreed to in writing,
            );
 * KIND, either express or implied.  See the License for the
        }
                .andThen(ClusterStateUpdaters::removeStateNotRecoveredBlock)
        clusterService.removeListener(this);
        }
            // use post applied so that the state will be visible to the background recovery thread we spawn in performStateRecovery
        recoveryInProgress.set(false);
        -1,
                    return super.execute(ClusterStateUpdaters.recoverClusterBlocks(updatedState));
import org.opensearch.core.rest.RestStatus;
import org.opensearch.common.unit.TimeValue;
    private final AtomicBoolean recoveryInProgress = new AtomicBoolean();
    protected void doStart() {
import org.opensearch.cluster.ClusterChangedEvent;
