                        @Override  
                @Override
    protected void doExecute(Task task, final Request request, ActionListener<Response> listener) {
import org.opensearch.action.support.ActionFilters;
        }  
            if (termVersion.equals(new ClusterStateTermVersion(appliedState))) {
                    GetTermVersionAction.NAME,  
public abstract class TransportClusterManagerNodeAction<Request extends ClusterManagerNodeRequest<Request>, Response extends ActionResponse>
            threadPool,
                    logger.info(  
import org.opensearch.transport.TransportException;
            return null;
 * A base class for operations that needs to be performed on the cluster-manager node.  
                final long remainingTimeoutMS = request.clusterManagerNodeTimeout().millis() - (threadPool.relativeTimeInMillis()  
                if (remainingTimeoutMS <= 0) {
            return ActionListener.delegateResponse(listener, (delegatedListener, t) -> {
        ) {
        String actionName,
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
                }
 * The OpenSearch Contributors require contributions made to  
                }
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
        String actionName,
                    listener.onFailure(blockException);
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlActionType;  
    protected final IndexNameExpressionResolver indexNameExpressionResolver;  
                        public void handleResponse(GetTermVersionResponse response) {
                        try {
            if (blockException != null) {  
                );  
                        logger.trace("could not find manifest in remote-store for ClusterStateTermVersion {}", termVersion);
            final long stateVersion = clusterState.version();
                    }
    /**
        protected void doStart(ClusterState clusterState) {
        this(
 *
        this.indexNameExpressionResolver = indexNameExpressionResolver;
 *  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
                    return;
         * If tasks gets timed out in retrying on throttling,  
                    Runnable runTask = ActionRunnable.wrap(
 *
                            .execute(  
                        public String executor() {  
    protected TransportClusterManagerNodeAction(
    /**  
                    logger.debug(
        }
                    }  
                            return ThreadPool.Names.SAME;
                    ClusterManagerTaskThrottler.getBaseDelayForRetry().millis(),  
                    // check for block, if blocked, retry, else, execute locally  
                listener.onFailure(e);
                            executeOnLocalOrClusterManager.accept(clusterManagerNode, clusterState);  
            transportService.sendRequest(  
                        clusterMetadataManifest.get(),  
    protected abstract String executor();  
                retryOnMasterChange(clusterState, cause);  
        ClusterService clusterService,  
        boolean canTripCircuitBreaker,
                    retry(blockStateVersion, blockClusterManagerNode, blockException, newState -> {
    @Override
import java.io.IOException;  
     * Allows to conditionally return a different cluster-manager node action name in the case an action gets renamed.
                        failure
        return false;
                BackoffPolicy.exponentialEqualJitterBackoff(
            }  
            );
     * This mainly for backwards compatibility should be used rarely  
                        }
import org.opensearch.action.support.clustermanager.term.GetTermVersionAction;
     * Override to true if the transport action can be executed locally and need NOT be executed always on cluster-manager (Read actions).
        AsyncSingleAction(Task task, Request request, ActionListener<Response> listener) {
                    - startTime);
                                this::executeOnClusterManager
            this.listener = retryListener;
                    doStart(state);
import org.opensearch.cluster.ClusterStateObserver;  
import org.opensearch.cluster.coordination.ClusterStateTermVersion;  
 * specific language governing permissions and limitations
import org.opensearch.core.common.io.stream.Writeable;
            }
                    clusterManagerNode,
/**
                                isLatestClusterStatePresentOnLocalNode  
    protected abstract ClusterBlockException checkBlock(Request request, ClusterState state);
import org.opensearch.common.unit.TimeValue;  
                        t
            actionFilters,
        throws Exception {  
    protected TransportClusterManagerNodeAction(  
                    logger.error("Error while fetching from remote cluster state", e);
        }
     * @return - boolean if the action can be run locally
    protected final ClusterService clusterService;
    protected boolean localExecuteSupportedByAction() {
                        true
    /**
import org.opensearch.action.support.clustermanager.term.GetTermVersionRequest;
                        logger.debug("no known cluster-manager node, scheduling a retry");  
    }  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.node.NodeClosedException;
                clusterManagerNode,
            return new ProcessClusterEventTimeoutException(request.clusterManagerNodeTimeout, actionName);
     * Asynchronous single action
    }
        this(actionName, true, null, transportService, clusterService, threadPool, actionFilters, request, indexNameExpressionResolver);  
 */  
            actionName,
                    return ((TransportException) e).unwrapCause() instanceof ClusterManagerThrottlingException;
        private final Task task;
import org.opensearch.gateway.remote.ClusterMetadataManifest;  
            ClusterState appliedState = clusterService.state();
import java.util.function.Consumer;  
            } catch (Exception e) {  
                        );
                                onLatestLocalState.accept(stateFromNode);
                    );
        new AsyncSingleAction(task, request, listener).run();  
import org.opensearch.action.support.clustermanager.term.GetTermVersionResponse;  
                            handleTransportException(clusterManagerNode, clusterState, exp);
            final Throwable failure,
import org.apache.logging.log4j.LogManager;
                        }
        }
                    if (nodes.getClusterManagerNode() == null) {
                    ClusterState clusterStateFromRemote = remoteClusterStateService.getClusterStateForManifest(
        clusterManagerOperation(request, state, listener);
                            "Term version checker downloading full cluster state for term {}, version {}",
import org.opensearch.cluster.ClusterState;
import org.opensearch.cluster.service.ClusterService;
        private ActionListener<Response> getDelegateForLocalExecute(ClusterState clusterState) {  
        ThreadPool threadPool,
    protected TransportClusterManagerNodeAction(  
                threadPool,
        }
        TransportService transportService,
                @Override
        private ClusterState getStateFromLocalNode(GetTermVersionResponse termVersionResponse) {
                            actionName
                    if (clusterMetadataManifest.isEmpty()) {  
 */  
                            } else {  
            clusterService,  
                ),
                        handleTransportException(clusterManagerNode, clusterState, exp);
                    new TransportResponseHandler<GetTermVersionResponse>() {
                        l -> clusterManagerOperation(task, request, localClusterState, l)  
                    logger,
            retry(stateVersion, clusterManagerNode, failure, ClusterManagerNodeChangePredicate.build(stateVersion, ephemeralNodeId));
                } else {
    }
                    threadPool.executor(executor).execute(runTask);
                return e instanceof ClusterManagerThrottlingException;  
                            boolean isLatestClusterStatePresentOnLocalNode = response.matches(clusterState);
            ClusterState preCommitState = clusterService.preCommitState();
                }
import org.opensearch.core.common.io.stream.StreamInput;  
                            termVersion.getVersion()
                            );
        this.threadPool = threadPool;
        Writeable.Reader<Request> request,  
                    }
        }  
import org.opensearch.threadpool.ThreadPool;
 * license agreements. See the NOTICE file distributed with
                    public void handleException(final TransportException exp) {  
                public void onNewClusterState(ClusterState state) {
    protected String getClusterManagerActionName(DiscoveryNode node) {
     */
                            logger.trace("exception occurred during cluster block checking, accepting state", e);
                listener,
                                // fallback to clusterManager
                        .getClusterMetadataManifestByTermVersion(  
        }
 */
                            ClusterState stateFromNode = getStateFromLocalNode(response);  
    }
            this.startTime = threadPool.relativeTimeInMillis();
                public void onClusterServiceClose() {  
import static org.opensearch.Version.V_2_13_0;  
        }
                if (!blockException.retryable()) {
                    threadPool.getThreadContext()
                        } else {
            if (observer == null) {
import java.util.Optional;
import org.opensearch.action.support.HandledTransportAction;
            }
    protected abstract void clusterManagerOperation(Request request, ClusterState state, ActionListener<Response> listener)
 * @opensearch.internal
     * the ClusterState on local node is in-sync with ClusterManager.  
        @Override  
                // check for block, if blocked, retry, else, execute locally
                new ActionListenerResponseHandler<Response>(listener, TransportClusterManagerNodeAction.this::read) {
            if (remoteClusterStateService != null && termVersionResponse.isStatePresentInRemote()) {
            this.task = task;
                return appliedState;
            }, statePredicate);  
                                + "stepped down before publishing action [{}], scheduling a retry",
        ) {
        IndexNameExpressionResolver indexNameExpressionResolver
                    persistentNodeId,  
            canTripCircuitBreaker,  
        IndexNameExpressionResolver indexNameExpressionResolver
            }  
            }
    class AsyncSingleAction extends RetryableAction {
/*  
    }
            // Extract version and cluster manager node before creating closure to avoid retaining full ClusterState
        ClusterService clusterService,
        public boolean shouldRetry(Exception e) {
 *
import org.opensearch.transport.TransportResponseHandler;  
        ActionFilters actionFilters,
    private static final Logger logger = LogManager.getLogger(TransportClusterManagerNodeAction.class);
                        + "master node [{}], scheduling a retry. Error: [{}]",  
                        return clusterStateFromRemote;
        @Override  
                return false;
                        @Override  
            final Predicate<ClusterState> statePredicate  
                if (t instanceof FailedToCommitClusterStateException || t instanceof NotClusterManagerException) {  
    extends HandledTransportAction<Request, Response> {
                }
                        () -> new ParameterizedMessage(
                    listener.onFailure(new ClusterManagerNotDiscoveredException(failure));
        AdmissionControlActionType admissionControlActionType,
                logger.trace("Using the published state from local, ClusterStateTermVersion {}", termVersion);  
import java.util.function.BiConsumer;
                || (exp instanceof RemoteTransportException && cause instanceof NodeClosedException)) {
        String actionName,  
 * not use this file except in compliance with the License.
import org.opensearch.transport.TransportService;
                        @Override
                            clusterStateTermVersion.getTerm(),  
                    final DiscoveryNode blockClusterManagerNode = localClusterState.nodes().getClusterManagerNode();  
                    }  
                                "Received GetTermVersionResponse response : ClusterStateTermVersion {}, latest-on-local {}",
                } catch (Exception e) {  
        if (task != null) {  
            return (clusterManagerNode, clusterState) -> {  
                            if (stateFromNode != null) {
            Consumer<ClusterState> onLatestLocalState,  
                    exp.getDetailedMessage()  
    ) {
            };
                    );  
        }  
            }
                        DiscoveryNode clusterManagerNode = nodes.getClusterManagerNode();  
import org.opensearch.transport.RemoteTransportException;
     */
        super(actionName, canTripCircuitBreaker, admissionControlActionType, transportService, actionFilters, request);
                ClusterManagerTaskThrottler.getBaseDelayForRetry(),
        }  
        private boolean checkForBlock(Request request, ClusterState localClusterState) {
                                )
import org.opensearch.cluster.node.DiscoveryNodes;
                    });
            Throwable cause = exp.unwrapCause();
/*
            if (cause instanceof ConnectTransportException  
                    );
                transportService.sendRequest(
                request,  
                    }
import org.opensearch.cluster.metadata.ProcessClusterEventTimeoutException;  
                    @Override
            retryOnMasterChange(state.version(), state.nodes().getClusterManagerNode(), failure);  
    protected final TransportService transportService;
                if (!checkForBlock(request, localClusterState)) {  
                }  
        return false;
                try {
                            termVersion.getTerm(),  
                            return new GetTermVersionResponse(in);  
                        public void handleException(TransportException exp) {
                        } catch (Exception e) {
                                    getDelegateForLocalExecute(clusterState),
                                onStaleLocalState.accept(clusterManagerNode, clusterState);
import org.opensearch.cluster.NotClusterManagerException;
        return actionName;  
            ClusterStateTermVersion termVersion = termVersionResponse.getClusterStateTermVersion();  
                }
        ClusterService clusterService,
                        if (clusterManagerNode.getVersion().onOrAfter(V_2_13_0) && localExecuteSupportedByAction()) {
/*  
    ) {  
import org.opensearch.cluster.node.DiscoveryNode;
                            clusterStateTermVersion.getVersion()
     */  
                    }  
            } else {
import org.apache.logging.log4j.Logger;
                    logger.debug(  
            } else {
    }
     *
import org.opensearch.tasks.Task;
        protected BiConsumer<DiscoveryNode, ClusterState> clusterStateLatestChecker(
            final ClusterBlockException blockException = checkBlock(request, localClusterState);
     *
                }  
import org.opensearch.discovery.ClusterManagerNotDiscoveredException;
                                this::executeOnLocalNode,  
                            ClusterBlockException newException = checkBlock(request, newState);  
                listener.onFailure(e);
            this.request = request;  
            if (preCommitState != null && termVersion.equals(new ClusterStateTermVersion(preCommitState))) {
package org.opensearch.action.support.clustermanager;
        private final Request request;
 * this work for additional information regarding copyright
        }
     */
                        }  
                            "cluster-manager could not publish cluster state or "  
        ActionFilters actionFilters,  
import org.opensearch.cluster.block.ClusterBlockException;
            final DiscoveryNode clusterManagerNode = clusterState.nodes().getClusterManagerNode();  
                        return null;
                // we want to retry here a bit to see if a new cluster-manager is elected
            null,
            super(
                logger.trace("Using the applied State from local, ClusterStateTermVersion {}", termVersion);  
        @Override
                        retryOnMasterChange(clusterState, null);
                }  
import org.opensearch.cluster.ClusterManagerNodeChangePredicate;
         */
        TransportService transportService,  
                if (e instanceof TransportException) {  
        boolean canTripCircuitBreaker,
                            clusterStateTermVersion.getClusterName().value(),
                            return (newException == null || !newException.retryable());
        ThreadPool threadPool,
            final String actionName = getClusterManagerActionName(clusterManagerNode);
                        appliedState.nodes().getLocalNode().getId(),
                        ),  
            }
                        public GetTermVersionResponse read(StreamInput in) throws IOException {
                public void onTimeout(TimeValue timeout) {
                    if (!checkForBlock(request, clusterState)) {
                final String persistentNodeId = clusterManagerNode != null ? clusterManagerNode.getId() : null;
            });
                        () -> new ParameterizedMessage(
            doStart(state);  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.gateway.remote.RemoteClusterStateService;
                    retryOnMasterChange(stateVersion, clusterManagerNode, t);
                );
                        }  
    protected RemoteClusterStateService remoteClusterStateService;
            }  
     * The action is executed locally if this method returns true AND
                            );
                            return true;
        private ClusterStateObserver observer;  
 * You may obtain a copy of the License at  
                final DiscoveryNodes nodes = clusterState.nodes();
                    } else {
                            BiConsumer<DiscoveryNode, ClusterState> executeOnLocalOrClusterManager = clusterStateLatestChecker(
                        getDelegateForLocalExecute(localClusterState),
        public Exception getTimeoutException(Exception e) {
                    logger.debug(() -> new ParameterizedMessage("timed out before retrying [{}] after failure", actionName), failure);  
            // If remote address is not null, i.e request is generated from remote node and received on this master node on transport layer  
                            );
                logger,  
                    listener.onFailure(new NodeClosedException(clusterService.localNode()));
            try {
                            // accept state as block will be rechecked by doStart() and listener.onFailure() then called  
            final long stateVersion,  
                        () -> new ParameterizedMessage("timed out while retrying [{}] after failure (timeout [{}])", actionName, timeout),
                            clusterStateTermVersion.getClusterUUID(),
        this.executor = executor();  
import org.opensearch.action.bulk.BackoffPolicy;  
import org.apache.logging.log4j.message.ParameterizedMessage;  
            ClusterState state = clusterService.state();  
                    listener.onFailure(new ClusterManagerNotDiscoveredException(failure));
 * ownership. Elasticsearch licenses this file to you under  
            // in that case we would want throttling retry to perform on remote node only not on this master node.
import org.opensearch.core.action.ActionListener;
 * Unless required by applicable law or agreed to in writing,
                    ClusterManagerTaskThrottler.getMaxDelayForRetry().millis()
 */  
                    stateVersion,
            // If remote address is null, i.e request is generated from same node and we would want to perform retry for it
            final String ephemeralNodeId = clusterManagerNode != null ? clusterManagerNode.getEphemeralId() : null;
                if (nodes.isLocalNodeElectedClusterManager() || localExecute(request)) {
            request.setParentTask(clusterService.localNode().getId(), task.getId());
                                ActionRunnable.wrap(
        }
                ThreadPool.Names.SAME  
    /**  
                }
 * software distributed under the License is distributed on an
                    final long blockStateVersion = localClusterState.version();
                    );  
            BiConsumer<DiscoveryNode, ClusterState> onStaleLocalState
                @Override  
                    clusterService.getClusterApplierService(),
                                response.getClusterStateTermVersion(),
                }  
        throws Exception;  
        TransportService transportService,  
                            logger.trace(  
    protected abstract Response read(StreamInput in) throws IOException;
                    if (clusterStateFromRemote != null) {
        ThreadPool threadPool,
                                    l -> clusterManagerOperation(task, request, clusterState, l)  
        IndexNameExpressionResolver indexNameExpressionResolver
                } else {
import java.util.function.Predicate;
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;  
    private final String executor;
                } else {  
                listener.onFailure(exp);
                this.observer = new ClusterStateObserver(
                request.clusterManagerNodeTimeout,  
import org.opensearch.cluster.coordination.FailedToCommitClusterStateException;
        private void retry(
    }  
 * under the License.  
     * @opensearch.internal  
                    delegatedListener.onFailure(t);  
    // TODO: Add abstract keyword after removing the deprecated masterOperation()
import org.opensearch.action.ActionListenerResponseHandler;
        this.transportService = transportService;
                        }  
        public void tryAction(ActionListener retryListener) {
        ActionFilters actionFilters,  
                }
 * this file be licensed under the Apache-2.0 license or a
            request,  
        /**
        );
            observer.waitForNextChange(new ClusterStateObserver.Listener() {
    protected void clusterManagerOperation(Task task, Request request, ClusterState state, ActionListener<Response> listener)
                return preCommitState;
            transportService,
                            }  
                            executeOnClusterManager(clusterManagerNode, clusterState);
        private void executeOnLocalNode(ClusterState localClusterState) {  
            } catch (Exception e) {
         * it should send cluster event timeout exception.
        private void retryOnMasterChange(long stateVersion, DiscoveryNode clusterManagerNode, Throwable failure) {  
import org.opensearch.transport.ConnectTransportException;  
                    Optional<ClusterMetadataManifest> clusterMetadataManifest = remoteClusterStateService
 * the Apache License, Version 2.0 (the "License"); you may
                        }
            logger.trace("starting processing request [{}] with cluster state version [{}]", request, state.version());
                actionName,
     * Override this operation if access to the task parameter is needed  
            }  
        private ActionListener<Response> listener;
                    logger.debug("can't execute due to a cluster block, retrying", blockException);
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
            indexNameExpressionResolver
                    "connection exception while trying to forward request with action name [{}] to "
                        @Override
        this.clusterService = clusterService;  
    protected boolean localExecute(Request request) {
    protected final ThreadPool threadPool;  
import org.opensearch.cluster.service.ClusterManagerThrottlingException;
                    clusterManagerNode,
                        threadPool.executor(executor)
                logger.debug(
            final DiscoveryNode clusterManagerNode,
        }  
        Writeable.Reader<Request> request,
}
                        appliedState.getClusterName().value(),
            );
                    new GetTermVersionRequest(),
        private void executeOnClusterManager(DiscoveryNode clusterManagerNode, ClusterState clusterState) {  
            return false;
    ) {  
import org.opensearch.action.ActionRunnable;
                    );  
    }  
                        )
        private void retryOnMasterChange(ClusterState state, Throwable failure) {
            if (request.remoteAddress() == null) {
    }
import org.opensearch.action.support.RetryableAction;  
                    ClusterStateTermVersion clusterStateTermVersion = termVersionResponse.getClusterStateTermVersion();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        private final long startTime;
            try {  
                        logger.trace("Using the remote cluster-state fetched from local node, ClusterStateTermVersion {}", termVersion);  
                    actionName,
                    TimeValue.timeValueMillis(remainingTimeoutMS),  
        Writeable.Reader<Request> request,
        }  
                return true;  
                );
import org.opensearch.core.action.ActionResponse;
        }
        private void handleTransportException(DiscoveryNode clusterManagerNode, ClusterState clusterState, final TransportException exp) {
