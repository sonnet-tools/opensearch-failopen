 * this work for additional information regarding copyright
                    }
 * GitHub history for details.
        if (validationPredicate.test(currentState)) {  
 * The OpenSearch Contributors require contributions made to  
                int expected = Integer.parseInt(request.waitForNodes().substring(2));
        throw new UnsupportedOperationException("task parameter is required for this operation");  
                request,
                        // which is triggered by passing a NotClusterManagerException
        } else {  
                @Override
                    @Override  
    }  
                            waitCount,
                        logger.trace(
            request,
                        } else {  
            } else {
        int readyCounter = prepareResponse(request, response, clusterState, indexNameExpressionResolver);
        }  
                int expected = Integer.parseInt(request.waitForNodes().substring(3, request.waitForNodes().length() - 1));
    @Override
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
        assert request.waitForEvents() != null;
/*
/*  
                }
import org.opensearch.index.IndexNotFoundException;
                    @Override
            try {
                if (response.getNumberOfNodes() < expected) {
            waitCount++;  
                if (response.getNumberOfNodes() <= expected) {
                        executeHealth(
/**  
                new ClusterStateUpdateTask(request.waitForEvents()) {
        // we want users to be able to call this even when there are global blocks, just to check the health (are there blocks?)
 * KIND, either express or implied.  See the License for the
            waitForCounter++;
                            observedState -> waitForEventsAndExecuteHealth(request, listener, waitCount, endTimeRelativeMillis)
        ActionFilters actionFilters,
        }
/*  
        final int waitFor,
        }
                int expected = Integer.parseInt(request.waitForNodes().substring(1));
            final ClusterStateObserver observer = new ClusterStateObserver(  
                clusterState.getClusterName().value(),
                        listener.onFailure(e);
                request,
                    // TODO: make this check more generic, check for node role instead
    }
        // If valid && timeoutState == TimeoutState.ZERO_TIMEOUT then we immediately found **and processed** a valid state, so we don't
                    @Override
 *
                            + appliedState.stateUUID();
                            request.waitForEvents()
 * Unless required by applicable law or agreed to in writing,
                        final long timeoutInMillis = Math.max(0, endTimeRelativeMillis - threadPool.relativeTimeInMillis());
        final ClusterHealthRequest request,
    @Override
            } catch (IndexNotFoundException e) {
        }  
        // this should be executing quickly no need to fork off
        } catch (IndexNotFoundException e) {
                public void onClusterServiceClose() {
        response.setTimedOut(valid == false || timeoutState == TimeoutState.TIMED_OUT);
            // one of the specified indices is not there - treat it as RED.  
        final ActionListener<ClusterHealthResponse> listener
 * ownership. Elasticsearch licenses this file to you under  
            );  
                clusterState,
    @Inject  
            waitCount++;  
    }
                    }
        );
                        if (weighedAway) {  
        if (logger.isTraceEnabled()) {
            assert waitForActiveShards.equals(ActiveShardCount.DEFAULT) == false  
        if (request.waitForStatus() != null && response.getStatus().value() <= request.waitForStatus().value()) {
                    @Override
        TimeValue pendingTaskTimeInQueue
                pendingTaskTimeInQueue
                concreteIndices,
                        logger.error(() -> new ParameterizedMessage("unexpected failure during [{}]", source), e);
                listener,
                if (response.getNumberOfNodes() == expected) {
        final int waitCount,
                : "waitForActiveShards must not be DEFAULT on the request object, instead it should be NONE";
        return ThreadPool.Names.SAME;  
        }
            allocationService.getNumberOfInFlightFetches(),
            concreteIndices = clusterState.getMetadata().getConcreteAllIndices();
        if (request.timeout().millis() == 0) {  
                clusterService.getClusterSettings(),  
            waitForCounter++;
                request.level(),
            listener.onResponse(clusterHealthResponse);
                            + " vs "
import java.util.function.Consumer;  
        }
                    waitForCounter++;
        }
        if (request.waitForNodes().isEmpty() == false) {
        assert valid || (timeoutState != TimeoutState.OK);
        ZERO_TIMEOUT
                "cluster_health (wait_for_events [" + request.waitForEvents() + "])",  
    @Override  
        TransportService transportService,
            );
                null,  
        Discovery discovery
import org.apache.logging.log4j.Logger;
        }
                        // TransportClusterManagerNodeAction implements the retry logic,  
            clusterState.getClusterName().value(),  
        if (request.waitForNoRelocatingShards()) {
 *
                    }
 *
            );  
                int expected = Integer.parseInt(request.waitForNodes().substring(1));
        final ClusterState currentState,  
                    public void onFailure(String source, Exception e) {  
        return waitForCounter;  
import org.opensearch.action.support.ActionFilters;
        ClusterState clusterState,  
            && discovery instanceof Coordinator
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    static int prepareResponse(  
        final ClusterState unusedState,
        ClusterHealthRequest request,
import org.opensearch.core.common.io.stream.StreamInput;
        if (request.level().equals(ClusterHealthRequest.Level.AWARENESS_ATTRIBUTES)) {
                    waitForCounter++;
 *     http://www.apache.org/licenses/LICENSE-2.0
        }  
import org.opensearch.cluster.decommission.NodeDecommissionedException;  
        final int waitCount,
                            request,
        }
                currentState,
            waitCount++;  
            ClusterHealthRequest::new,
            );
            }
 * this file be licensed under the Apache-2.0 license or a
    protected String executor() {
import org.apache.logging.log4j.LogManager;
            } else if (request.waitForNodes().startsWith("ge(")) {  
        final IndexNameExpressionResolver indexNameExpressionResolver
                if (response.getNumberOfNodes() >= expected) {
                        // we must use the state from the applier service, because if the state-not-recovered block is in place then the  
                        return currentState;
    protected ClusterBlockException checkBlock(ClusterHealthRequest request, ClusterState state) {  
 * Modifications Copyright OpenSearch Contributors. See
        return waitCount;
            }
        }  
import org.opensearch.action.support.IndicesOptions;  
    }
        }  
    protected ClusterHealthResponse read(StreamInput in) throws IOException {
        if (request.waitForNoInitializingShards() && response.getInitializingShards() == 0) {
                clusterState.getClusterName().value(),  
            } else if (request.waitForNodes().startsWith("le(")) {
                @Override  
                    waitForCounter++;  
            clusterState,  
            clusterService.getClusterManagerService().getMaxTaskWaitTime()  
        }
                    if (localNode.isDataNode()) {  
                    listener.onResponse(getResponse(request, observer.setAndGetObservedState(), waitCount, TimeoutState.TIMED_OUT));
    private final AllocationService allocationService;  
import org.opensearch.cluster.routing.allocation.AllocationService;
                    // if we are waiting for all shards to be active, then the num of unassigned and num of initializing shards must be 0
                    public TimeValue timeout() {
            allocationService.getNumberOfInFlightFetches(),
                            appliedState,
        if (request.local()) {  
 */
    private void executeHealth(
    }
            indexNameExpressionResolver  
                indexNameExpressionResolver.concreteIndexNames(clusterState, IndicesOptions.strictExpand(), request);
        return response;  
                "Calculating health based on state version [{}] for health level [{}] and applyLevelAtTransportLayer set to [{}]",  
    private void waitForEventsAndExecuteHealth(
        if (request.ensureNodeWeighedIn()
                    public void onFailure(String source, Exception e) {  
                            listener,
        if (request.waitForEvents() != null) {
                }  
                        // applier service has a different view of the cluster state from the one supplied here
                int expected = Integer.parseInt(request.waitForNodes().substring(3, request.waitForNodes().length() - 1));  
        return new ClusterHealthResponse(in);
        String[] concreteIndices;
                    waitForCounter++;  
            request,
                logger,
                public void onNewClusterState(ClusterState newState) {  
                pendingTaskTimeInQueue
                public void onTimeout(TimeValue timeout) {
import org.opensearch.common.unit.TimeValue;
            waitForCounter++;
                        final TimeValue newTimeout = TimeValue.timeValueMillis(timeoutInMillis);  
        // failed on wait_for_events) so this does count as a timeout.
            } else if (request.waitForNodes().startsWith("<")) {
 *  
 * compatible open source license.
                int expected = Integer.parseInt(request.waitForNodes().substring(3, request.waitForNodes().length() - 1));
 */  
import org.opensearch.tasks.Task;
            ClusterHealthResponse clusterHealthResponse = getResponse(request, currentState, waitCount, TimeoutState.OK);
                if (response.getNumberOfNodes() >= expected) {  
 * Transport action for obtaining Cluster Health
        if (request.waitForActiveShards().equals(ActiveShardCount.NONE) == false) {
                threadPool.getThreadContext()
            } else if (waitForActiveShards.enoughShardsActive(response.getActiveShards())) {
import org.opensearch.transport.TransportService;  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
                    waitForCounter++;
    private static int getWaitCount(ClusterHealthRequest request) {  
    protected final void clusterManagerOperation(  
        IndexNameExpressionResolver indexNameExpressionResolver,  
                }
        ActionListener<ClusterHealthResponse> listener  
                    public ClusterTasksResult<LocalClusterUpdateTask> execute(ClusterState currentState) {
        int numberOfPendingTasks,  
                    waitForCounter++;
    private static final Logger logger = LogManager.getLogger(TransportClusterHealthAction.class);
import org.opensearch.cluster.coordination.Coordinator;
    ) {  
            return new ClusterHealthResponse(
        ClusterState clusterState,
            clusterService.submitStateUpdateTask(
    }
                }
                }
                // there are enough active shards to meet the requirements of the request
        final int waitCount = getWaitCount(request);
                Strings.EMPTY_ARRAY,  
                        final long timeoutInMillis = Math.max(0, endTimeRelativeMillis - threadPool.relativeTimeInMillis());
        AllocationService allocationService,
        if (request.waitForNoInitializingShards()) {
                }
import org.opensearch.cluster.block.ClusterBlockException;
                    onNewClusterStateAfterDelay.accept(newState);
    }
                if (response.getNumberOfNodes() > expected) {
        }
    }  
            clusterService.submitStateUpdateTask(
import org.opensearch.cluster.ClusterStateObserver;  
    ) {  
                        request.timeout(newTimeout);
                            clusterService.state(),
            clusterService.getClusterManagerService().getMaxTaskWaitTime()
        return false;  
                }
        final ClusterHealthResponse response,
            );  
                }
            listener.onFailure(new NodeDecommissionedException("local node is decommissioned"));
    ) {
                        assert newState.stateUUID().equals(appliedState.stateUUID()) : newState.stateUUID()  
                            waitCount,  
        } else {
            observer.waitForNextChange(stateListener, validationPredicate, request.timeout());
                clusterState,
        final Consumer<ClusterState> onNewClusterStateAfterDelay  
            transportService,
        final long endTimeRelativeMillis  
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeReadAction;
                            return;
            clusterService.getClusterManagerService().numberOfPendingTasks(),
        return prepareResponse(request, response, clusterState, indexNameExpressionResolver) == waitCount;
 * You may obtain a copy of the License at  
            final TimeValue taskTimeout = TimeValue.timeValueMillis(Math.max(0, endTimeRelativeMillis - threadPool.relativeTimeInMillis()));
    ) {  
                        request.timeout(newTimeout);
                    @Override
        );  
                    listener.onFailure(new ClusterManagerNotDiscoveredException("cluster-manager not discovered"));
                }  
    protected void clusterManagerOperation(
                waitForCounter++;  
            if (request.waitForNodes().startsWith(">=")) {
                if (response.getNumberOfNodes() < expected) {  
        return null;
    private final Discovery discovery;
            pendingTaskTimeInQueue  
    public TransportClusterHealthAction(
        final Predicate<ClusterState> validationPredicate = newState -> validateRequest(request, newState, waitCount);
import org.opensearch.core.common.Strings;  
import org.opensearch.cluster.health.ClusterHealthStatus;
            );  
            concreteIndices,
    @Override  
                waitForCounter++;  
    private enum TimeoutState {
    }  
                        );  
import org.opensearch.cluster.LocalClusterUpdateTask;
            };
                        final TimeValue newTimeout = TimeValue.timeValueMillis(timeoutInMillis);  
    @Override
        ClusterHealthResponse response = clusterHealth(
import org.opensearch.cluster.routing.NodeWeighedAwayException;
                    waitForCounter++;
                }  
import org.opensearch.discovery.ClusterManagerNotDiscoveredException;  
        ClusterService clusterService,  
                }  
            numberOfPendingTasks,
            final ClusterStateObserver.Listener stateListener = new ClusterStateObserver.Listener() {
import org.opensearch.cluster.node.DiscoveryNode;
            request,
 * software distributed under the License is distributed on an
                clusterState.version(),
                        return taskTimeout;  
        final ClusterHealthRequest request,  
                @Override
                awarenessAttribute,
                waitCount,
                numberOfInFlightFetch,
        if (request.waitForActiveShards().equals(ActiveShardCount.NONE) == false) {
                    listener.onFailure(new NodeClosedException(clusterService.localNode()));  
    protected boolean localExecuteSupportedByAction() {
                    waitForCounter++;  
    }
                        executeHealth(  
 * specific language governing permissions and limitations
        int waitForCounter = 0;  
                    }  
import org.opensearch.cluster.NotClusterManagerException;  
        try {  
    ) {
import org.opensearch.cluster.service.ClusterService;
                    }  
        int waitCount = 0;
    @Override  
            } else if (request.waitForNodes().startsWith(">")) {  
 * not use this file except in compliance with the License.
    private ClusterHealthResponse clusterHealth(  
        ThreadPool threadPool,
            actionFilters,
            ClusterHealthAction.NAME,
            ClusterHealthResponse response = new ClusterHealthResponse(
                            listener,  
        }
package org.opensearch.action.admin.cluster.health;
            listener.onResponse(getResponse(request, currentState, waitCount, TimeoutState.ZERO_TIMEOUT));
                        }  
            } else if (request.waitForNodes().startsWith("<=")) {
        final ClusterHealthRequest request,
import org.opensearch.cluster.routing.WeightedRoutingUtils;  
 * @opensearch.internal  
                            observedState -> waitForEventsAndExecuteHealth(request, listener, waitCount, endTimeRelativeMillis)
            executeHealth(
            if (request.ensureNodeWeighedIn()) {
        final ActionListener<ClusterHealthResponse> listener,
                int expected = Integer.parseInt(request.waitForNodes().substring(3, request.waitForNodes().length() - 1));
                        if (e instanceof ProcessClusterEventTimeoutException) {
        ClusterHealthResponse response = clusterHealth(  
            String awarenessAttribute = request.getAwarenessAttribute();  
        OK,
    ) {
                numberOfPendingTasks,  
                        return unchanged();  
            return;
            waitCount++;  
                            "stopped being cluster-manager while waiting for events with priority [{}]. retrying.",  
            clusterState,  
                } else {  
                    DiscoveryNode localNode = currentState.getNodes().getLocalNode();
        boolean valid = (readyCounter == waitFor);  
            clusterService.getClusterManagerService().numberOfPendingTasks(),  
                }
import org.opensearch.cluster.ClusterStateUpdateTask;
                }  
                    public ClusterState execute(ClusterState currentState) {  
        // consider this a timeout. However if timeoutState == TimeoutState.TIMED_OUT then we didn't process a valid state (perhaps we  
                request.isApplyLevelAtTransportLayer()  
public class TransportClusterHealthAction extends TransportClusterManagerNodeReadAction<ClusterHealthRequest, ClusterHealthResponse> {
                "cluster_health (wait_for_events [" + request.waitForEvents() + "])",
        if (request.waitForStatus() != null) {
 * Licensed to Elasticsearch under one or more contributor  
        }  
            logger.trace(
                            listener.onFailure(e);
import org.opensearch.common.inject.Inject;  
    }  
    }
 * SPDX-License-Identifier: Apache-2.0
                if (response.getNumberOfNodes() <= expected) {  
                new LocalClusterUpdateTask(request.waitForEvents()) {  
            waitForEventsAndExecuteHealth(request, listener, waitCount, threadPool.relativeTimeInMillis() + request.timeout().millis());
 */
import org.opensearch.cluster.metadata.ProcessClusterEventTimeoutException;  
                request,
                            request,  
                clusterService.state(),  
                }
import java.io.IOException;
 * under the License.  
    }
                numberOfInFlightFetch,
        final ActionListener<ClusterHealthResponse> listener,
            } else if (request.waitForNodes().startsWith("lt(")) {  
        }  
                        final ClusterState appliedState = clusterService.state();
                clusterState -> listener.onResponse(getResponse(request, clusterState, waitCount, TimeoutState.OK))  
                numberOfPendingTasks,  
    ) {  
        }
            clusterService,
        final ClusterHealthRequest request,
                            logger.error(() -> new ParameterizedMessage("unexpected failure during [{}]", source), e);
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
import java.util.function.Predicate;
                        boolean weighedAway = WeightedRoutingUtils.isWeighedAway(localNode.getId(), currentState);
                }
            false,  
                if (clusterHealthResponse.hasDiscoveredClusterManager() == false) {  
                        );
        );
            response.setStatus(ClusterHealthStatus.RED);
            } else if (request.waitForNodes().startsWith("gt(")) {
        }
import org.opensearch.core.action.ActionListener;
                    return;
        if (!request.waitForNodes().isEmpty()) {  
                if (response.getNumberOfNodes() > expected) {
        logger.warn("attempt to execute a cluster health operation without a task");
    ) throws Exception {
import org.opensearch.node.NodeClosedException;  
                            listener.onResponse(getResponse(request, clusterService.state(), waitCount, TimeoutState.TIMED_OUT));
        final Task task,
        this.discovery = discovery;  
            );
                response.setStatus(ClusterHealthStatus.RED); // no indices, make sure its RED
        if (request.waitForNoRelocatingShards() && response.getRelocatingShards() == 0) {
                    }  
                        }  
                if (response.getUnassignedShards() == 0 && response.getInitializingShards() == 0) {  
        if (CollectionUtils.isEmpty(request.indices()) == false) { // check that they actually exists in the meta data
                int expected = Integer.parseInt(request.waitForNodes());  
        super(
            && ((Coordinator) discovery).localNodeCommissioned() == false) {  
import org.opensearch.discovery.Discovery;
            clusterState,
    private boolean validateRequest(final ClusterHealthRequest request, ClusterState clusterState, final int waitCount) {
                    @Override  
                int expected = Integer.parseInt(request.waitForNodes().substring(2));  
        return new ClusterHealthResponse(
                        assert request.local() == true : "local node request false for request for local node weighed in";
        final ClusterState clusterState,  
                    }
import org.opensearch.action.support.ActiveShardCount;
        } else {  
import org.opensearch.core.common.util.CollectionUtils;
        );
 * the Apache License, Version 2.0 (the "License"); you may
        }
            }  
                // missing indices, wait a bit more...  
                        listener.onFailure(new NotClusterManagerException("no longer cluster-manager. source: [" + source + "]"));
                    waitForCounter++;
        TimeoutState timeoutState
            waitCount++;  
                    waitForCounter++;
    private ClusterHealthResponse getResponse(
            numberOfInFlightFetch,
import org.opensearch.cluster.ClusterState;
        TIMED_OUT,  
        int numberOfInFlightFetch,
 */  
            return;
                            listener.onFailure(new NodeWeighedAwayException("local node is weighed away"));
import org.opensearch.threadpool.ThreadPool;
            }
        if (CollectionUtils.isEmpty(request.indices()) == false) {  
                    }
    }
                    public void onNoLongerClusterManager(String source) {
                    @Override  
            threadPool,  
            if (waitForActiveShards.equals(ActiveShardCount.ALL)) {
        this.allocationService = allocationService;
            waitCount++;  
                }
}
import org.apache.logging.log4j.message.ParameterizedMessage;  
        ClusterHealthRequest request,
            concreteIndices = indexNameExpressionResolver.concreteIndexNames(clusterState, request);
                clusterService,
            return response;
        ClusterState state,
            ActiveShardCount waitForActiveShards = request.waitForActiveShards();
                    }
                        );
    }
        final ClusterHealthRequest request,  
                    @Override
