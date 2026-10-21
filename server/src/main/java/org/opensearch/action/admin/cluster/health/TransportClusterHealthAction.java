                pendingTaskTimeInQueue
 * under the License.
                            waitCount,
        int waitForCounter = 0;
            String awarenessAttribute = request.getAwarenessAttribute();
                    public ClusterState execute(ClusterState currentState) {
    }
                        boolean weighedAway = WeightedRoutingUtils.isWeighedAway(localNode.getId(), currentState);
                            request.waitForEvents()
            final TimeValue taskTimeout = TimeValue.timeValueMillis(Math.max(0, endTimeRelativeMillis - threadPool.relativeTimeInMillis()));
            return;
    private ClusterHealthResponse clusterHealth(
            response.setStatus(ClusterHealthStatus.RED);
                if (response.getUnassignedShards() == 0 && response.getInitializingShards() == 0) {
                Strings.EMPTY_ARRAY,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            );
 * the Apache License, Version 2.0 (the "License"); you may
                logger,
        final ClusterHealthRequest request,
                    waitForCounter++;
 * license agreements. See the NOTICE file distributed with
            return response;
                            waitCount,
        boolean valid = (readyCounter == waitFor);
                @Override
 *     http://www.apache.org/licenses/LICENSE-2.0
        ClusterState clusterState,
                    waitForCounter++;
    ) {
 * specific language governing permissions and limitations
                    }
        TimeValue pendingTaskTimeInQueue
                clusterState,
    }
    @Override
        if (request.waitForStatus() != null) {
                request.isApplyLevelAtTransportLayer()
            waitForCounter++;
        if (request.level().equals(ClusterHealthRequest.Level.AWARENESS_ATTRIBUTES)) {
        ZERO_TIMEOUT
        final ActionListener<ClusterHealthResponse> listener,
                        );
import org.opensearch.action.support.IndicesOptions;
                    return;
                    DiscoveryNode localNode = currentState.getNodes().getLocalNode();
    }
        } catch (IndexNotFoundException e) {
        ActionFilters actionFilters,
                    @Override
    @Override
                        executeHealth(
                    waitForCounter++;
                int expected = Integer.parseInt(request.waitForNodes().substring(3, request.waitForNodes().length() - 1));
        // consider this a timeout. However if timeoutState == TimeoutState.TIMED_OUT then we didn't process a valid state (perhaps we
        int numberOfInFlightFetch,
        if (CollectionUtils.isEmpty(request.indices()) == false) { // check that they actually exists in the meta data
 * ownership. Elasticsearch licenses this file to you under
        ClusterHealthResponse response = clusterHealth(
                    listener.onFailure(new ClusterManagerNotDiscoveredException("cluster-manager not discovered"));
                        listener.onFailure(new NotClusterManagerException("no longer cluster-manager. source: [" + source + "]"));
        if (logger.isTraceEnabled()) {
            waitCount++;
                            request,
        }
            clusterState,
    private static int getWaitCount(ClusterHealthRequest request) {
                public void onClusterServiceClose() {
        final ClusterState unusedState,
                if (response.getNumberOfNodes() < expected) {
                request,
import org.opensearch.core.common.io.stream.StreamInput;
        }
            listener.onResponse(getResponse(request, currentState, waitCount, TimeoutState.ZERO_TIMEOUT));
        );
                clusterState.version(),
        final ClusterState clusterState,
        final ClusterHealthRequest request,
        if (request.waitForNoInitializingShards()) {
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
 * software distributed under the License is distributed on an
        if (request.waitForNoRelocatingShards() && response.getRelocatingShards() == 0) {
            );
import org.opensearch.cluster.block.ClusterBlockException;
                clusterState.getClusterName().value(),
            }
            false,
    protected void clusterManagerOperation(
                    @Override
        assert valid || (timeoutState != TimeoutState.OK);
                        request.timeout(newTimeout);
import org.opensearch.cluster.LocalClusterUpdateTask;
public class TransportClusterHealthAction extends TransportClusterManagerNodeReadAction<ClusterHealthRequest, ClusterHealthResponse> {
                            return;
    protected String executor() {
            return;
            ClusterHealthResponse response = new ClusterHealthResponse(
                : "waitForActiveShards must not be DEFAULT on the request object, instead it should be NONE";
        final Predicate<ClusterState> validationPredicate = newState -> validateRequest(request, newState, waitCount);
import org.opensearch.cluster.ClusterStateObserver;
    public TransportClusterHealthAction(
    ) {
        if (request.waitForActiveShards().equals(ActiveShardCount.NONE) == false) {
                    listener.onResponse(getResponse(request, observer.setAndGetObservedState(), waitCount, TimeoutState.TIMED_OUT));
    }
                    }
        ClusterHealthRequest request,
                    listener.onFailure(new NodeClosedException(clusterService.localNode()));
        final int waitCount = getWaitCount(request);
            ActiveShardCount waitForActiveShards = request.waitForActiveShards();
        final int waitCount,
                            appliedState,
            } else if (request.waitForNodes().startsWith("<")) {
                            request,
                }
        final ClusterHealthRequest request,
        // If valid && timeoutState == TimeoutState.ZERO_TIMEOUT then we immediately found **and processed** a valid state, so we don't
        if (request.ensureNodeWeighedIn()
package org.opensearch.action.admin.cluster.health;
 * Licensed to Elasticsearch under one or more contributor
            waitForCounter++;
            clusterService.getClusterManagerService().getMaxTaskWaitTime()
            && discovery instanceof Coordinator
 * compatible open source license.
    }
        }
        return response;
    }
        final ClusterHealthResponse response,
    private enum TimeoutState {
            if (request.ensureNodeWeighedIn()) {
                }
    ) {
            ClusterHealthAction.NAME,
                if (response.getNumberOfNodes() > expected) {
                }
            };
import org.apache.logging.log4j.LogManager;
                    public ClusterTasksResult<LocalClusterUpdateTask> execute(ClusterState currentState) {
                    if (localNode.isDataNode()) {
    protected ClusterBlockException checkBlock(ClusterHealthRequest request, ClusterState state) {
            actionFilters,
                }
 * @opensearch.internal
        if (request.waitForNodes().isEmpty() == false) {
                waitCount,
        }
            clusterService.getClusterManagerService().numberOfPendingTasks(),
            concreteIndices = indexNameExpressionResolver.concreteIndexNames(clusterState, request);
        TransportService transportService,
            listener.onFailure(new NodeDecommissionedException("local node is decommissioned"));
                        );
                }
                if (response.getNumberOfNodes() >= expected) {
        );
                            observedState -> waitForEventsAndExecuteHealth(request, listener, waitCount, endTimeRelativeMillis)
}
            allocationService.getNumberOfInFlightFetches(),
        final IndexNameExpressionResolver indexNameExpressionResolver
            );
            && ((Coordinator) discovery).localNodeCommissioned() == false) {
        }
                            listener.onFailure(e);
        return ThreadPool.Names.SAME;
                if (clusterHealthResponse.hasDiscoveredClusterManager() == false) {
            waitCount++;
        }
    @Override
        if (validationPredicate.test(currentState)) {
    }
    protected ClusterHealthResponse read(StreamInput in) throws IOException {
        if (request.waitForStatus() != null && response.getStatus().value() <= request.waitForStatus().value()) {
                awarenessAttribute,
            return new ClusterHealthResponse(
                numberOfInFlightFetch,
        // this should be executing quickly no need to fork off
                    // TODO: make this check more generic, check for node role instead
            final ClusterStateObserver.Listener stateListener = new ClusterStateObserver.Listener() {
 *
        if (request.waitForActiveShards().equals(ActiveShardCount.NONE) == false) {
            assert waitForActiveShards.equals(ActiveShardCount.DEFAULT) == false
        }
        return false;
                if (response.getNumberOfNodes() <= expected) {
            }
                    @Override
 * not use this file except in compliance with the License.
        return new ClusterHealthResponse(in);
                }
import java.util.function.Predicate;
            clusterService.submitStateUpdateTask(
                waitForCounter++;
import org.opensearch.cluster.routing.WeightedRoutingUtils;
    }
    protected final void clusterManagerOperation(
            clusterService.getClusterManagerService().getMaxTaskWaitTime()
        final long endTimeRelativeMillis
                if (response.getNumberOfNodes() >= expected) {
 * this work for additional information regarding copyright
            request,
import org.opensearch.cluster.routing.NodeWeighedAwayException;
    private ClusterHealthResponse getResponse(
        if (request.timeout().millis() == 0) {
        if (request.waitForNoInitializingShards() && response.getInitializingShards() == 0) {
                            listener,
                if (response.getNumberOfNodes() <= expected) {
import org.opensearch.cluster.coordination.Coordinator;
/**
                        return taskTimeout;
        OK,
                } else {
                @Override
                }
import org.opensearch.core.action.ActionListener;
                        if (e instanceof ProcessClusterEventTimeoutException) {
                pendingTaskTimeInQueue
            threadPool,
            waitCount++;
                    waitForCounter++;
        logger.warn("attempt to execute a cluster health operation without a task");
 *
import org.opensearch.core.common.util.CollectionUtils;
import org.opensearch.cluster.ClusterStateUpdateTask;
/*
        String[] concreteIndices;
import java.io.IOException;
                        return unchanged();
        }
import org.opensearch.node.NodeClosedException;
        // failed on wait_for_events) so this does count as a timeout.
import org.opensearch.cluster.ClusterState;
        } else {
                clusterService.getClusterSettings(),
                }
                indexNameExpressionResolver.concreteIndexNames(clusterState, IndicesOptions.strictExpand(), request);
            } else if (request.waitForNodes().startsWith("gt(")) {
        final Consumer<ClusterState> onNewClusterStateAfterDelay
                    public void onNoLongerClusterManager(String source) {
            numberOfPendingTasks,
 */
            if (waitForActiveShards.equals(ActiveShardCount.ALL)) {
        if (request.local()) {
                    @Override
        ClusterHealthResponse response = clusterHealth(
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                int expected = Integer.parseInt(request.waitForNodes().substring(3, request.waitForNodes().length() - 1));
                        return currentState;
                int expected = Integer.parseInt(request.waitForNodes().substring(3, request.waitForNodes().length() - 1));
                request.level(),
        response.setTimedOut(valid == false || timeoutState == TimeoutState.TIMED_OUT);
        );
                if (response.getNumberOfNodes() < expected) {
        final int waitFor,
        this.discovery = discovery;
                        final long timeoutInMillis = Math.max(0, endTimeRelativeMillis - threadPool.relativeTimeInMillis());
                        assert newState.stateUUID().equals(appliedState.stateUUID()) : newState.stateUUID()
                int expected = Integer.parseInt(request.waitForNodes());
        ClusterState clusterState,
    }
        this.allocationService = allocationService;
            } else if (request.waitForNodes().startsWith("ge(")) {
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeReadAction;
                clusterState -> listener.onResponse(getResponse(request, clusterState, waitCount, TimeoutState.OK))
 */
import org.opensearch.action.support.ActiveShardCount;
            );
                int expected = Integer.parseInt(request.waitForNodes().substring(1));
        if (!request.waitForNodes().isEmpty()) {
        throw new UnsupportedOperationException("task parameter is required for this operation");
            pendingTaskTimeInQueue
import org.opensearch.cluster.NotClusterManagerException;
        ClusterService clusterService,
                threadPool.getThreadContext()
            waitCount++;
            clusterService.getClusterManagerService().numberOfPendingTasks(),
            waitCount++;
        return new ClusterHealthResponse(
    private boolean validateRequest(final ClusterHealthRequest request, ClusterState clusterState, final int waitCount) {
                    waitForCounter++;
 * KIND, either express or implied.  See the License for the
                        executeHealth(
                listener,
                }
                        } else {
import org.opensearch.transport.TransportService;
            listener.onResponse(clusterHealthResponse);
 * Transport action for obtaining Cluster Health
                        logger.trace(
    }
        }
                            logger.error(() -> new ParameterizedMessage("unexpected failure during [{}]", source), e);
            } else if (request.waitForNodes().startsWith(">")) {
                waitForCounter++;
            }
                    public void onFailure(String source, Exception e) {
                int expected = Integer.parseInt(request.waitForNodes().substring(2));
                }
                }
                            listener.onFailure(new NodeWeighedAwayException("local node is weighed away"));
            );
        final int waitCount,
                        final long timeoutInMillis = Math.max(0, endTimeRelativeMillis - threadPool.relativeTimeInMillis());
            clusterService.submitStateUpdateTask(
                        );
        IndexNameExpressionResolver indexNameExpressionResolver,
                null,
import org.opensearch.cluster.service.ClusterService;
        ActionListener<ClusterHealthResponse> listener
import org.opensearch.action.support.ActionFilters;
            numberOfInFlightFetch,
        super(
import org.apache.logging.log4j.Logger;
        if (request.waitForNoRelocatingShards()) {
        int numberOfPendingTasks,
import org.apache.logging.log4j.message.ParameterizedMessage;
                        logger.error(() -> new ParameterizedMessage("unexpected failure during [{}]", source), e);
                        }
                int expected = Integer.parseInt(request.waitForNodes().substring(2));
import org.opensearch.tasks.Task;
            clusterState,
                            + appliedState.stateUUID();
            request,
        return waitCount;
            waitForCounter++;
                            "stopped being cluster-manager while waiting for events with priority [{}]. retrying.",
                    waitForCounter++;
import org.opensearch.discovery.Discovery;
            // one of the specified indices is not there - treat it as RED.
                public void onTimeout(TimeValue timeout) {
        ThreadPool threadPool,
                }
                        // applier service has a different view of the cluster state from the one supplied here
                int expected = Integer.parseInt(request.waitForNodes().substring(1));
            executeHealth(
        }
            } else if (request.waitForNodes().startsWith("le(")) {
                clusterState,
        }
                // missing indices, wait a bit more...
                        request.timeout(newTimeout);
                            listener.onResponse(getResponse(request, clusterService.state(), waitCount, TimeoutState.TIMED_OUT));
import org.opensearch.core.common.Strings;
                    waitForCounter++;
                        if (weighedAway) {
                        final TimeValue newTimeout = TimeValue.timeValueMillis(timeoutInMillis);
        }
import org.opensearch.cluster.node.DiscoveryNode;
            allocationService.getNumberOfInFlightFetches(),
    @Inject
        ClusterState state,
                    @Override
 *
                public void onNewClusterState(ClusterState newState) {
        return null;
                response.setStatus(ClusterHealthStatus.RED); // no indices, make sure its RED
                            clusterService.state(),
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
                clusterService,
                    // if we are waiting for all shards to be active, then the num of unassigned and num of initializing shards must be 0
                int expected = Integer.parseInt(request.waitForNodes().substring(3, request.waitForNodes().length() - 1));
    ) {
        TimeoutState timeoutState
    }
        }
                }
    private void waitForEventsAndExecuteHealth(
            request,
        try {
        assert request.waitForEvents() != null;
                            listener,
        if (CollectionUtils.isEmpty(request.indices()) == false) {
            } else if (request.waitForNodes().startsWith("lt(")) {
                new ClusterStateUpdateTask(request.waitForEvents()) {
                    onNewClusterStateAfterDelay.accept(newState);
/*
            } else if (waitForActiveShards.enoughShardsActive(response.getActiveShards())) {
 * You may obtain a copy of the License at
                        final TimeValue newTimeout = TimeValue.timeValueMillis(timeoutInMillis);
    private void executeHealth(
 * SPDX-License-Identifier: Apache-2.0
            waitCount++;
            ClusterHealthResponse clusterHealthResponse = getResponse(request, currentState, waitCount, TimeoutState.OK);
import org.opensearch.discovery.ClusterManagerNotDiscoveredException;
                numberOfPendingTasks,
        return prepareResponse(request, response, clusterState, indexNameExpressionResolver) == waitCount;
                    public void onFailure(String source, Exception e) {
                    }
                        // we must use the state from the applier service, because if the state-not-recovered block is in place then the
        }
                    }
    }
                currentState,
import org.opensearch.cluster.metadata.ProcessClusterEventTimeoutException;
                clusterService.state(),
    private final Discovery discovery;
            );
                            observedState -> waitForEventsAndExecuteHealth(request, listener, waitCount, endTimeRelativeMillis)
        final ClusterHealthRequest request,
 *
                request,
                }
                numberOfInFlightFetch,
                        final ClusterState appliedState = clusterService.state();
 * Modifications Copyright OpenSearch Contributors. See
                numberOfPendingTasks,
                "cluster_health (wait_for_events [" + request.waitForEvents() + "])",
                        // which is triggered by passing a NotClusterManagerException
 * this file be licensed under the Apache-2.0 license or a
        );
            }
                    public TimeValue timeout() {
 * GitHub history for details.
            transportService,
                @Override
            concreteIndices = clusterState.getMetadata().getConcreteAllIndices();
import org.opensearch.common.unit.TimeValue;
import org.opensearch.cluster.decommission.NodeDecommissionedException;
    ) {
import java.util.function.Consumer;
 */
    }
                request,
            clusterService,
        final Task task,
 * Unless required by applicable law or agreed to in writing,
            } catch (IndexNotFoundException e) {
        AllocationService allocationService,
        } else {
        }
                    }
    private static final Logger logger = LogManager.getLogger(TransportClusterHealthAction.class);
    @Override
import org.opensearch.cluster.health.ClusterHealthStatus;
    @Override
        }
        final ActionListener<ClusterHealthResponse> listener,
        } else {
                }
    ) {
            clusterState.getClusterName().value(),
    static int prepareResponse(
                        }
    @Override
 * The OpenSearch Contributors require contributions made to
        final ClusterHealthRequest request,
                "Calculating health based on state version [{}] for health level [{}] and applyLevelAtTransportLayer set to [{}]",
                    waitForCounter++;
                }
            final ClusterStateObserver observer = new ClusterStateObserver(
            } else {
        int waitCount = 0;
    private final AllocationService allocationService;
                if (response.getNumberOfNodes() == expected) {
    ) throws Exception {
                    }
                    }
            logger.trace(
                    }
            } else if (request.waitForNodes().startsWith("<=")) {
        }
        TIMED_OUT,
        final ClusterState currentState,
                    }
            clusterState,
                    waitForCounter++;
            ClusterHealthRequest::new,
                    @Override
        }
import org.opensearch.common.inject.Inject;
        final ActionListener<ClusterHealthResponse> listener
                            + " vs "
        // we want users to be able to call this even when there are global blocks, just to check the health (are there blocks?)
        if (request.waitForEvents() != null) {
        return waitForCounter;
    ) {
                    @Override
                if (response.getNumberOfNodes() > expected) {
                // there are enough active shards to meet the requirements of the request
    protected boolean localExecuteSupportedByAction() {
        }
                clusterState.getClusterName().value(),
import org.opensearch.index.IndexNotFoundException;
                    waitForCounter++;
                        listener.onFailure(e);
            );
    }
/*
                    @Override
                "cluster_health (wait_for_events [" + request.waitForEvents() + "])",
                new LocalClusterUpdateTask(request.waitForEvents()) {
            concreteIndices,
            observer.waitForNextChange(stateListener, validationPredicate, request.timeout());
        Discovery discovery
            indexNameExpressionResolver
        int readyCounter = prepareResponse(request, response, clusterState, indexNameExpressionResolver);
                concreteIndices,
            waitForEventsAndExecuteHealth(request, listener, waitCount, threadPool.relativeTimeInMillis() + request.timeout().millis());
                        // TransportClusterManagerNodeAction implements the retry logic,
import org.opensearch.cluster.routing.allocation.AllocationService;
                        assert request.local() == true : "local node request false for request for local node weighed in";
    }
        }
            try {
 */
            if (request.waitForNodes().startsWith(">=")) {
        ClusterHealthRequest request,
