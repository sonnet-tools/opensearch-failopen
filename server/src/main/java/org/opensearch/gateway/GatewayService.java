            resetRecoveredFlags();
                enforceRecoverAfterTime = false;  
import org.opensearch.cluster.service.ClusterService;
 * Unless required by applicable law or agreed to in writing,
        Property.NodeScope
        } else if (recoverAfterDataNodes != -1 && nodes.getDataNodes().size() < recoverAfterDataNodes) {  
        } else {  
    class GatewayRecoveryListener implements Gateway.GatewayStateRecoveredListener {  
        if (lifecycle.stoppedOrClosed()) {  
            });
        @Override  
import org.opensearch.common.settings.Settings;
 * Modifications Copyright OpenSearch Contributors. See
 *  
        }
        }  
        } else {
import org.opensearch.cluster.node.DiscoveryNodes;  
            final ClusterState newState = Function.<ClusterState>identity()
                }, recoverAfterTime, ThreadPool.Names.GENERIC);
 */
import org.opensearch.cluster.block.ClusterBlock;
        if (state.blocks().hasGlobalBlock(STATE_NOT_RECOVERED_BLOCK) == false) {
import org.opensearch.cluster.ClusterStateListener;  
    protected void doClose() {}
    private final int expectedDataNodes;  
        }
        }  
                .apply(currentState);
        -1,
    protected void doStart() {
                // no expected is set, honor the setting if they are there
                reason = "recover_after_time was set to [" + recoverAfterTime + "]";  
                enforceRecoverAfterTime = true;
                        resetRecoveredFlags();
 * software distributed under the License is distributed on an
    );  
                    return super.execute(ClusterStateUpdaters.recoverClusterBlocks(updatedState));  
        if (RECOVER_AFTER_TIME_SETTING.exists(settings)) {
    }
import org.opensearch.common.unit.TimeValue;
                        logger.warn("state recovery failed", e);  
    TimeValue recoverAfterTime() {
    class RecoverStateUpdateTask extends ClusterStateUpdateTask {
        public void onFailure(final String source, final Exception e) {  
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
        } else if (expectedDataNodes >= 0) {  
/*  
 *
        if (discovery instanceof Coordinator) {
                    enforceRecoverAfterTime = true;  
            recoveryRunnable = () -> clusterService.submitStateUpdateTask("local-gateway-elected-state", new RecoverStateUpdateTask());
import org.opensearch.cluster.block.ClusterBlockLevel;  
                    @Override
            recoveryRunnable = () -> gateway.performStateRecovery(new GatewayRecoveryListener());
        if (state.nodes().isLocalNodeElectedClusterManager() == false) {  
        false,  
    @Inject
                });  
        this.clusterService = clusterService;
    );  
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
    private final AllocationService allocationService;  
        // allow to control a delay of when indices will get created
        public void onFailure(final String msg) {  
            final Gateway gateway = new Gateway(settings, clusterService, listGatewayMetaState);
        }  
        }  
 */  
            logger.trace("successful state recovery, importing cluster state...");
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.settings.Setting;
 * The Gateway Service provider  
    }
                logger.info("delaying initial state recovery for [{}]. {}", recoverAfterTime, reason);
        }
        if (DiscoveryNode.isClusterManagerNode(clusterService.getSettings())) {
    static final TimeValue DEFAULT_RECOVER_AFTER_TIME_IF_EXPECTED_NODES_IS_SET = TimeValue.timeValueMinutes(5);
    @Override
        final DiscoveryNodes nodes = state.nodes();  
    public static final Setting<TimeValue> RECOVER_AFTER_TIME_SETTING = Setting.positiveTimeSetting(
                    @Override
            // not our job to recover
            return;  
                    }
    ) {  
 * GitHub history for details.
    private final ThreadPool threadPool;
            boolean enforceRecoverAfterTime;
            }  
        final Settings settings,  
    private final Runnable recoveryRunnable;
                }
import org.apache.logging.log4j.message.ParameterizedMessage;  
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
        "gateway.recover_after_time",
        @Override
            }  
            return;
    // used for testing
                    protected void doRun() {
        if (state.nodes().getClusterManagerNodeId() == null) {
        public ClusterState execute(final ClusterState currentState) {
        public void onNoLongerClusterManager(String source) {  
 * SPDX-License-Identifier: Apache-2.0
                @Override  
            logger.info("state recovery failed: {}", msg);
 * KIND, either express or implied.  See the License for the
                }
 * compatible open source license.
    }
        true,
        final AllocationService allocationService,
        ClusterBlockLevel.ALL
/*  
import org.opensearch.cluster.node.DiscoveryNode;
        scheduledRecovery.set(false);
        }
import org.opensearch.core.rest.RestStatus;
        public void onSuccess(final ClusterState recoveredState) {  
/**
        this.threadPool = threadPool;  
    private void resetRecoveredFlags() {
    }  
        }  
                recoverAfterDataNodes
import java.util.function.Function;  
                threadPool.schedule(new AbstractRunnable() {  
 * license agreements. See the NOTICE file distributed with
    public static final Setting<Integer> RECOVER_AFTER_DATA_NODES_SETTING = Setting.intSetting(  
        }
                "not recovering from gateway, nodes_size (data) [{}] < recover_after_data_nodes [{}]",
                .andThen(ClusterStateUpdaters::removeStateNotRecoveredBlock)  
    protected void doStop() {  
            recoverAfterTime = null;  
                .andThen(ClusterStateUpdaters::updateRoutingTable)
        }  
            }
        TimeValue.timeValueMillis(0),  
/*
import org.opensearch.common.inject.Inject;  
        @Override
        -1,  
            if (expectedDataNodes == -1) {  
    public GatewayService(
        this.recoverAfterDataNodes = RECOVER_AFTER_DATA_NODES_SETTING.get(settings);
            // not-recovered state, that we again do another state recovery.
            clusterService.submitStateUpdateTask("local-gateway-elected-state", new RecoverStateUpdateTask() {
import org.opensearch.cluster.ClusterState;
            );
 */  
 * @opensearch.internal
                        resetRecoveredFlags();
        this.expectedDataNodes = EXPECTED_DATA_NODES_SETTING.get(settings);
            clusterService.addListener(this);
                public ClusterState execute(final ClusterState currentState) {
 * ownership. Elasticsearch licenses this file to you under  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            logger.debug("stepped down as cluster-manager before recovering state [{}]", source);
 * this work for additional information regarding copyright
}  
    private final int recoverAfterDataNodes;
        final Discovery discovery
                logger.debug("cluster is already recovered");  
                    public void onFailure(Exception e) {
        "gateway.recover_after_data_nodes",
            // already recovered
        @Override  
            recoverAfterTime = DEFAULT_RECOVER_AFTER_TIME_IF_EXPECTED_NODES_IS_SET;
    }
            logger.info(() -> new ParameterizedMessage("unexpected failure during [{}]", source), e);
            recoverAfterTime = RECOVER_AFTER_TIME_SETTING.get(settings);
        final TransportNodesListGatewayMetaState listGatewayMetaState,
 *
        }  
        }
                        logger.warn("delayed state recovery failed", e);  
        } else {
import org.apache.logging.log4j.Logger;
                    @Override
        -1,  
 *
import org.apache.logging.log4j.LogManager;
        final ClusterState state = event.state();
                return currentState;
            performStateRecovery(enforceRecoverAfterTime, reason);
            } else {
    private void performStateRecovery(final boolean enforceRecoverAfterTime, final String reason) {
        Property.NodeScope
        "gateway.expected_data_nodes",
import org.opensearch.cluster.ClusterChangedEvent;
        public void clusterStateProcessed(final String source, final ClusterState oldState, final ClusterState newState) {
    }
            }
            logger.info("recovered [{}] indices into cluster_state", newState.metadata().indices().size());
    private final ClusterService clusterService;
        final ClusterService clusterService,
 * this file be licensed under the Apache-2.0 license or a
        this.allocationService = allocationService;
                            recoveryRunnable.run();
    );
                    reason = "expecting [" + expectedDataNodes + "] data nodes, but only have [" + nodes.getDataNodes().size() + "]";
                // one of the expected is set, see if all of them meet the need, and ignore the timeout in this case
            if (currentState.blocks().hasGlobalBlock(STATE_NOT_RECOVERED_BLOCK) == false) {
        return recoverAfterTime;  
    public static final ClusterBlock STATE_NOT_RECOVERED_BLOCK = new ClusterBlock(
            String reason;
            // use post applied so that the state will be visible to the background recovery thread we spawn in performStateRecovery  
                        logger.debug("performing state recovery...");  
                        if (recoveryInProgress.compareAndSet(false, true)) {  
    @Override
                    protected void doRun() {
 * not use this file except in compliance with the License.
    private static final Logger logger = LogManager.getLogger(GatewayService.class);
        recoveryInProgress.set(false);  
                        recoveryRunnable.run();
        clusterService.removeListener(this);
                    }
import org.opensearch.discovery.Discovery;
import org.opensearch.common.util.concurrent.AbstractRunnable;  
        "state not recovered / initialized",  
                    @Override
 * Licensed to Elasticsearch under one or more contributor  
            return allocationService.reroute(newState, "state recovered");  
import org.opensearch.cluster.ClusterStateUpdateTask;
                    }
                    public void onFailure(final Exception e) {
        }
    public void clusterChanged(final ClusterChangedEvent event) {
import org.opensearch.cluster.coordination.Coordinator;
    private final AtomicBoolean scheduledRecovery = new AtomicBoolean();
            resetRecoveredFlags();
        true,
 */  
            resetRecoveredFlags();
                reason = "";
            return;
                            logger.info("recover_after_time [{}] elapsed. performing state recovery...", recoverAfterTime);
            logger.debug("not recovering from gateway, no cluster-manager elected yet");
    public static final Setting<Integer> EXPECTED_DATA_NODES_SETTING = Setting.intSetting(
                threadPool.generic().execute(new AbstractRunnable() {  
            if (scheduledRecovery.compareAndSet(false, true)) {
                nodes.getDataNodes().size(),  
    private final TimeValue recoverAfterTime;
        if (enforceRecoverAfterTime && recoverAfterTime != null) {  
        Property.NodeScope
 * You may obtain a copy of the License at  
    @Override  
 * under the License.  
    }  
            // reset flag even though state recovery completed, to ensure that if we subsequently become leader again based on a  
import org.opensearch.cluster.routing.allocation.AllocationService;
        -1,
        final ThreadPool threadPool,  
    private final AtomicBoolean recoveryInProgress = new AtomicBoolean();
import java.util.concurrent.atomic.AtomicBoolean;
        } else {  
                    }
            logger.debug(
    );
import org.opensearch.common.settings.Setting.Property;  
                        }  
public class GatewayService extends AbstractLifecycleComponent implements ClusterStateListener {
                if (nodes.getDataNodes().size() < expectedDataNodes) { // does not meet the expected...
        RestStatus.SERVICE_UNAVAILABLE,
import org.opensearch.threadpool.ThreadPool;  
    }
        @Override
            resetRecoveredFlags();
                    final ClusterState updatedState = ClusterStateUpdaters.mixCurrentStateAndRecoveredState(currentState, recoveredState);
        1,
            if (recoveryInProgress.compareAndSet(false, true)) {
package org.opensearch.gateway;
        @Override
