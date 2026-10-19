import org.opensearch.threadpool.ThreadPool;
                    GetTermVersionAction.NAME,
                            ClusterBlockException newException = checkBlock(request, newState);
                    retry(blockStateVersion, blockClusterManagerNode, blockException, newState -> {
import org.opensearch.action.support.HandledTransportAction;
                );
                    threadPool.getThreadContext()
        this.executor = executor();
                this.observer = new ClusterStateObserver(
                                this::executeOnClusterManager
import org.opensearch.tasks.Task;
 * specific language governing permissions and limitations
                    logger.error("Error while fetching from remote cluster state", e);
            ClusterState preCommitState = clusterService.preCommitState();
                                this::executeOnLocalNode,
                clusterManagerNode,
                            );
            actionName,
                    @Override
        @Override
        ThreadPool threadPool,
        this.indexNameExpressionResolver = indexNameExpressionResolver;
    protected final ThreadPool threadPool;
                    clusterService.getClusterApplierService(),
import org.apache.logging.log4j.message.ParameterizedMessage;
        IndexNameExpressionResolver indexNameExpressionResolver
                            termVersion.getVersion()
                final long remainingTimeoutMS = request.clusterManagerNodeTimeout().millis() - (threadPool.relativeTimeInMillis()
            final DiscoveryNode clusterManagerNode,
                    listener.onFailure(new ClusterManagerNotDiscoveredException(failure));
                    logger,
        String actionName,
import org.opensearch.action.ActionListenerResponseHandler;
import org.opensearch.cluster.coordination.FailedToCommitClusterStateException;
                        }
                                isLatestClusterStatePresentOnLocalNode
                } else {
                        } else {
    protected void clusterManagerOperation(Task task, Request request, ClusterState state, ActionListener<Response> listener)
        }
        }
                    logger.debug(
                new ActionListenerResponseHandler<Response>(listener, TransportClusterManagerNodeAction.this::read) {
                    } else {
        AdmissionControlActionType admissionControlActionType,
                            return ThreadPool.Names.SAME;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            final Throwable failure,
            canTripCircuitBreaker,
                } else {
                            "Term version checker downloading full cluster state for term {}, version {}",
                    );
                                ActionRunnable.wrap(
                        }
                try {
                        () -> new ParameterizedMessage("timed out while retrying [{}] after failure (timeout [{}])", actionName, timeout),
                            // accept state as block will be rechecked by doStart() and listener.onFailure() then called
import org.opensearch.cluster.ClusterStateObserver;
                                    l -> clusterManagerOperation(task, request, clusterState, l)
        protected BiConsumer<DiscoveryNode, ClusterState> clusterStateLatestChecker(
            }
                );
        this.transportService = transportService;
         * it should send cluster event timeout exception.
            logger.trace("starting processing request [{}] with cluster state version [{}]", request, state.version());
                    Optional<ClusterMetadataManifest> clusterMetadataManifest = remoteClusterStateService
            final ClusterBlockException blockException = checkBlock(request, localClusterState);
        }
                    }
                        () -> new ParameterizedMessage(
                        }
                            ClusterState stateFromNode = getStateFromLocalNode(response);
                            termVersion.getTerm(),
                        }
            request,
                        clusterMetadataManifest.get(),
                }
                @Override
                        .getClusterMetadataManifestByTermVersion(
    }
        }
                        @Override
    class AsyncSingleAction extends RetryableAction {
                threadPool,
        boolean canTripCircuitBreaker,
         */
    protected abstract ClusterBlockException checkBlock(Request request, ClusterState state);
            if (cause instanceof ConnectTransportException
public abstract class TransportClusterManagerNodeAction<Request extends ClusterManagerNodeRequest<Request>, Response extends ActionResponse>
                    ClusterState clusterStateFromRemote = remoteClusterStateService.getClusterStateForManifest(
        String actionName,
                    );
                                    getDelegateForLocalExecute(clusterState),
                                onStaleLocalState.accept(clusterManagerNode, clusterState);
                        appliedState.nodes().getLocalNode().getId(),
                        appliedState.getClusterName().value(),
                }
                    delegatedListener.onFailure(t);
                    );
                        public void handleException(TransportException exp) {
     * @return - boolean if the action can be run locally
                    clusterManagerNode,
    protected boolean localExecute(Request request) {
                        @Override
                if (!blockException.retryable()) {
     * Asynchronous single action
        private ActionListener<Response> listener;
                // check for block, if blocked, retry, else, execute locally
        private void handleTransportException(DiscoveryNode clusterManagerNode, ClusterState clusterState, final TransportException exp) {
                                + "stepped down before publishing action [{}], scheduling a retry",
    protected void doExecute(Task task, final Request request, ActionListener<Response> listener) {
                            return new GetTermVersionResponse(in);
                    }
            }
                return true;
import org.opensearch.gateway.remote.ClusterMetadataManifest;
            }
 */
                    ClusterStateTermVersion clusterStateTermVersion = termVersionResponse.getClusterStateTermVersion();
                }
                        @Override
        return false;
                                )
                    logger.debug(
        AsyncSingleAction(Task task, Request request, ActionListener<Response> listener) {
        boolean canTripCircuitBreaker,
                    }
                        t
import org.apache.logging.log4j.Logger;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.transport.TransportResponseHandler;
 * software distributed under the License is distributed on an
        protected void doStart(ClusterState clusterState) {
            actionFilters,
                        l -> clusterManagerOperation(task, request, localClusterState, l)
 * You may obtain a copy of the License at
        ) {
    /**
        /**
                            if (stateFromNode != null) {
                    if (clusterStateFromRemote != null) {
        TransportService transportService,
                        + "master node [{}], scheduling a retry. Error: [{}]",
            // in that case we would want throttling retry to perform on remote node only not on this master node.
    extends HandledTransportAction<Request, Response> {
                            );
                        try {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        TransportService transportService,
                            return true;
            Throwable cause = exp.unwrapCause();
                            clusterStateTermVersion.getClusterName().value(),
/*
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;
        private void executeOnLocalNode(ClusterState localClusterState) {
                ),
            Consumer<ClusterState> onLatestLocalState,
                        return null;
            try {
            );
import java.io.IOException;
                }
                    new TransportResponseHandler<GetTermVersionResponse>() {
    @Override
        if (task != null) {
                    ClusterManagerTaskThrottler.getBaseDelayForRetry().millis(),
     * Allows to conditionally return a different cluster-manager node action name in the case an action gets renamed.
        private void retryOnMasterChange(ClusterState state, Throwable failure) {
            indexNameExpressionResolver
                            boolean isLatestClusterStatePresentOnLocalNode = response.matches(clusterState);
                return e instanceof ClusterManagerThrottlingException;
 *
                            } else {
                public void onNewClusterState(ClusterState state) {
import org.opensearch.action.support.clustermanager.term.GetTermVersionRequest;
            return false;
            }
    protected abstract Response read(StreamInput in) throws IOException;
                    return;
                    logger.debug("can't execute due to a cluster block, retrying", blockException);
                            clusterStateTermVersion.getClusterUUID(),
 * under the License.
        );
import static org.opensearch.Version.V_2_13_0;
        }
            // If remote address is null, i.e request is generated from same node and we would want to perform retry for it
        ) {
            final long stateVersion = clusterState.version();
        this.clusterService = clusterService;
                public void onClusterServiceClose() {
        ActionFilters actionFilters,
                            .execute(
 * not use this file except in compliance with the License.
                            clusterStateTermVersion.getVersion()
import java.util.Optional;
            }
    protected final IndexNameExpressionResolver indexNameExpressionResolver;
                            }
                    }
                        return clusterStateFromRemote;
            return ActionListener.delegateResponse(listener, (delegatedListener, t) -> {
import org.opensearch.cluster.ClusterManagerNodeChangePredicate;
        }
    }
        Writeable.Reader<Request> request,
                                // fallback to clusterManager
        ActionFilters actionFilters,
        }
        }
        public Exception getTimeoutException(Exception e) {
            transportService,
        ThreadPool threadPool,
            // If remote address is not null, i.e request is generated from remote node and received on this master node on transport layer
                    listener.onFailure(blockException);
            return new ProcessClusterEventTimeoutException(request.clusterManagerNodeTimeout, actionName);
            } catch (Exception e) {
     */
                            logger.trace("exception occurred during cluster block checking, accepting state", e);
        }
import org.opensearch.common.unit.TimeValue;
 * Licensed to Elasticsearch under one or more contributor
 * @opensearch.internal
        throws Exception;
        String actionName,
            this.startTime = threadPool.relativeTimeInMillis();
import org.opensearch.transport.ConnectTransportException;
                if (!checkForBlock(request, localClusterState)) {
import java.util.function.Predicate;
            } else {
                            clusterStateTermVersion.getTerm(),
        ClusterService clusterService,
        super(actionName, canTripCircuitBreaker, admissionControlActionType, transportService, actionFilters, request);
                                onLatestLocalState.accept(stateFromNode);
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
                // we want to retry here a bit to see if a new cluster-manager is elected
                            return (newException == null || !newException.retryable());
                    if (clusterMetadataManifest.isEmpty()) {
                            BiConsumer<DiscoveryNode, ClusterState> executeOnLocalOrClusterManager = clusterStateLatestChecker(
    // TODO: Add abstract keyword after removing the deprecated masterOperation()
/*
import org.opensearch.action.support.clustermanager.term.GetTermVersionResponse;
            return null;
    ) {
                        logger.trace("could not find manifest in remote-store for ClusterStateTermVersion {}", termVersion);
            return (clusterManagerNode, clusterState) -> {
                logger.trace("Using the published state from local, ClusterStateTermVersion {}", termVersion);
                }
 * KIND, either express or implied.  See the License for the
                listener.onFailure(exp);
        }
                return preCommitState;
                            actionName
        Writeable.Reader<Request> request,
                @Override
 *
 * ownership. Elasticsearch licenses this file to you under
                    // check for block, if blocked, retry, else, execute locally
 * compatible open source license.
import java.util.function.BiConsumer;
            } catch (Exception e) {
import org.opensearch.cluster.coordination.ClusterStateTermVersion;
     * @opensearch.internal
            this.task = task;
import org.opensearch.action.support.clustermanager.term.GetTermVersionAction;
                || (exp instanceof RemoteTransportException && cause instanceof NodeClosedException)) {
                        failure
                return false;
                if (nodes.isLocalNodeElectedClusterManager() || localExecute(request)) {
            null,
                    });
            threadPool,
        throws Exception {
                    final long blockStateVersion = localClusterState.version();
     * the ClusterState on local node is in-sync with ClusterManager.
                    ClusterManagerTaskThrottler.getMaxDelayForRetry().millis()
     */
 */
            } else {
                request,
    private final String executor;
     *
        Writeable.Reader<Request> request,
                    new GetTermVersionRequest(),
import org.opensearch.cluster.ClusterState;
        new AsyncSingleAction(task, request, listener).run();
    /**
import org.apache.logging.log4j.LogManager;
            retryOnMasterChange(state.version(), state.nodes().getClusterManagerNode(), failure);
 * the Apache License, Version 2.0 (the "License"); you may
                ThreadPool.Names.SAME
        ThreadPool threadPool,
                                "Received GetTermVersionResponse response : ClusterStateTermVersion {}, latest-on-local {}",
            transportService.sendRequest(
 * Unless required by applicable law or agreed to in writing,
                logger.debug(
                if (t instanceof FailedToCommitClusterStateException || t instanceof NotClusterManagerException) {
    }
                        handleTransportException(clusterManagerNode, clusterState, exp);
            if (request.remoteAddress() == null) {
                    listener.onFailure(new NodeClosedException(clusterService.localNode()));
                            );
    }
            try {
            retry(stateVersion, clusterManagerNode, failure, ClusterManagerNodeChangePredicate.build(stateVersion, ephemeralNodeId));
                }
                        } catch (Exception e) {
            doStart(state);
                if (remainingTimeoutMS <= 0) {
                    );
                    TimeValue.timeValueMillis(remainingTimeoutMS),
                            handleTransportException(clusterManagerNode, clusterState, exp);
                    exp.getDetailedMessage()
                @Override
                    logger.debug(() -> new ParameterizedMessage("timed out before retrying [{}] after failure", actionName), failure);
/**
        }
import org.opensearch.discovery.ClusterManagerNotDiscoveredException;
import org.opensearch.action.bulk.BackoffPolicy;
            if (observer == null) {
package org.opensearch.action.support.clustermanager;
 * The OpenSearch Contributors require contributions made to
    ) {
import org.opensearch.cluster.node.DiscoveryNode;
                if (e instanceof TransportException) {
                return appliedState;
                );
    private static final Logger logger = LogManager.getLogger(TransportClusterManagerNodeAction.class);
        clusterManagerOperation(request, state, listener);
            // Extract version and cluster manager node before creating closure to avoid retaining full ClusterState
                        public void handleResponse(GetTermVersionResponse response) {
            });
        ClusterService clusterService,
                        );
        ClusterService clusterService,
import org.opensearch.core.action.ActionListener;
        @Override
        IndexNameExpressionResolver indexNameExpressionResolver
        TransportService transportService,
                    if (nodes.getClusterManagerNode() == null) {
 * license agreements. See the NOTICE file distributed with
                }
    protected RemoteClusterStateService remoteClusterStateService;
                        retryOnMasterChange(clusterState, null);
     * Override this operation if access to the task parameter is needed
    /**
                ClusterManagerTaskThrottler.getBaseDelayForRetry(),
        private ClusterStateObserver observer;
        this.threadPool = threadPool;
        }
import org.opensearch.cluster.service.ClusterManagerThrottlingException;
                        logger.trace("Using the remote cluster-state fetched from local node, ClusterStateTermVersion {}", termVersion);
    protected TransportClusterManagerNodeAction(
                listener,
 */
        }
            final String ephemeralNodeId = clusterManagerNode != null ? clusterManagerNode.getEphemeralId() : null;
            final DiscoveryNode clusterManagerNode = clusterState.nodes().getClusterManagerNode();
         * If tasks gets timed out in retrying on throttling,
    }
     * Override to true if the transport action can be executed locally and need NOT be executed always on cluster-manager (Read actions).
        private ActionListener<Response> getDelegateForLocalExecute(ClusterState clusterState) {
                }
            observer.waitForNextChange(new ClusterStateObserver.Listener() {
                        threadPool.executor(executor)
        return false;
 * A base class for operations that needs to be performed on the cluster-manager node.
                        () -> new ParameterizedMessage(
            );
                            executeOnLocalOrClusterManager.accept(clusterManagerNode, clusterState);
    /**
        this(
                        )
    }
                retryOnMasterChange(clusterState, cause);
                transportService.sendRequest(
                    logger.info(
            request.setParentTask(clusterService.localNode().getId(), task.getId());
            if (termVersion.equals(new ClusterStateTermVersion(appliedState))) {
    protected abstract String executor();
                        if (clusterManagerNode.getVersion().onOrAfter(V_2_13_0) && localExecuteSupportedByAction()) {
     * This mainly for backwards compatibility should be used rarely
    protected abstract void clusterManagerOperation(Request request, ClusterState state, ActionListener<Response> listener)
     */
                    if (!checkForBlock(request, clusterState)) {
    protected TransportClusterManagerNodeAction(
        private ClusterState getStateFromLocalNode(GetTermVersionResponse termVersionResponse) {
 *     http://www.apache.org/licenses/LICENSE-2.0
            final String actionName = getClusterManagerActionName(clusterManagerNode);
import org.opensearch.cluster.NotClusterManagerException;
            this.request = request;
import org.opensearch.action.support.ActionFilters;
    protected boolean localExecuteSupportedByAction() {
                            executeOnClusterManager(clusterManagerNode, clusterState);
                listener.onFailure(e);
            super(
 *
/*
import org.opensearch.cluster.node.DiscoveryNodes;
            }
                    doStart(state);
                        DiscoveryNode clusterManagerNode = nodes.getClusterManagerNode();
                actionName,
        }
 *
            if (remoteClusterStateService != null && termVersionResponse.isStatePresentInRemote()) {
                    final DiscoveryNode blockClusterManagerNode = localClusterState.nodes().getClusterManagerNode();
            this.listener = retryListener;
    }
                final String persistentNodeId = clusterManagerNode != null ? clusterManagerNode.getId() : null;
                }
import java.util.function.Consumer;
 */
        private final Request request;
    protected String getClusterManagerActionName(DiscoveryNode node) {
                final DiscoveryNodes nodes = clusterState.nodes();
            ClusterState state = clusterService.state();
                    }
            if (blockException != null) {
                    clusterManagerNode,
                    listener.onFailure(new ClusterManagerNotDiscoveredException(failure));
            }
                        public GetTermVersionResponse read(StreamInput in) throws IOException {
                        true
            ClusterStateTermVersion termVersion = termVersionResponse.getClusterStateTermVersion();
    ) {
        this(actionName, true, null, transportService, clusterService, threadPool, actionFilters, request, indexNameExpressionResolver);
import org.opensearch.action.ActionRunnable;
                    actionName,
 * this work for additional information regarding copyright
                public void onTimeout(TimeValue timeout) {
import org.opensearch.action.support.RetryableAction;
                        logger.debug("no known cluster-manager node, scheduling a retry");
                }
                listener.onFailure(e);
     *
                        ),
                    stateVersion,
                            "cluster-manager could not publish cluster state or "
        }
import org.opensearch.cluster.block.ClusterBlockException;
        }
        public boolean shouldRetry(Exception e) {
    protected TransportClusterManagerNodeAction(
                } catch (Exception e) {
            }
                logger,
import org.opensearch.transport.TransportService;
            final long stateVersion,
                }
import org.opensearch.core.common.io.stream.StreamInput;
        return actionName;
}
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlActionType;
                request.clusterManagerNodeTimeout,
        private void retry(
        private void executeOnClusterManager(DiscoveryNode clusterManagerNode, ClusterState clusterState) {
     */
import org.opensearch.gateway.remote.RemoteClusterStateService;
            if (preCommitState != null && termVersion.equals(new ClusterStateTermVersion(preCommitState))) {
                        }
                            logger.trace(
     * The action is executed locally if this method returns true AND
            }
                        @Override
            BiConsumer<DiscoveryNode, ClusterState> onStaleLocalState
import org.opensearch.node.NodeClosedException;
            };
                    threadPool.executor(executor).execute(runTask);
            ClusterState appliedState = clusterService.state();
                        }
                logger.trace("Using the applied State from local, ClusterStateTermVersion {}", termVersion);
    protected final TransportService transportService;
        IndexNameExpressionResolver indexNameExpressionResolver
                    public void handleException(final TransportException exp) {
        private boolean checkForBlock(Request request, ClusterState localClusterState) {
import org.opensearch.cluster.metadata.ProcessClusterEventTimeoutException;
import org.opensearch.transport.TransportException;
                    - startTime);
    protected final ClusterService clusterService;
        @Override
        private final long startTime;
import org.opensearch.core.common.io.stream.Writeable;
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.transport.RemoteTransportException;
        ActionFilters actionFilters,
import org.opensearch.core.action.ActionResponse;
import org.opensearch.cluster.service.ClusterService;
        private void retryOnMasterChange(long stateVersion, DiscoveryNode clusterManagerNode, Throwable failure) {
                    "connection exception while trying to forward request with action name [{}] to "
    }
            }, statePredicate);
                        public String executor() {
        public void tryAction(ActionListener retryListener) {
                    );
            final Predicate<ClusterState> statePredicate
                    retryOnMasterChange(stateVersion, clusterManagerNode, t);
    }
                    }
                    persistentNodeId,
        private final Task task;
                } else {
                        getDelegateForLocalExecute(localClusterState),
                    Runnable runTask = ActionRunnable.wrap(
            clusterService,
                    return ((TransportException) e).unwrapCause() instanceof ClusterManagerThrottlingException;
                BackoffPolicy.exponentialEqualJitterBackoff(
                                response.getClusterStateTermVersion(),
