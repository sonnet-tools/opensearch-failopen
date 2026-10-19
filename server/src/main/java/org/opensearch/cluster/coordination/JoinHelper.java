        @Override
        this.namedWriteableRegistry = namedWriteableRegistry;
                            .build();
                                exp.getCause().getMessage()
        return new JoinCallback() {
import org.opensearch.cluster.node.DiscoveryNode;
import java.util.HashMap;
                        onCompletion.run();
import java.util.function.Function;
    private final TransportService transportService;
    public static final String VALIDATE_COMPRESSED_JOIN_ACTION_NAME = JOIN_ACTION_NAME + "/validate_compressed";
                    @Override
import java.util.List;
                || cause instanceof FailedToCommitClusterStateException
        private final Long clusterStateVersion;
        this.joinTimeout = JOIN_TIMEOUT_SETTING.get(settings);
     * @opensearch.internal
import org.opensearch.transport.TransportService;
    }
        final ClusterState localState = currentStateSupplier.get();
        this.nodeCommissioned = nodeCommissioned;
     * A candidate join accumulator.
            this.clusterStateVersion = clusterStateVersion;
                // Joining node version is read when deserializing the cluster state
    private JoinCallback transportJoinCallback(TransportRequest request, TransportChannel channel) {
    /**
/*
    private final TimeValue joinTimeout; // only used for Zen1 joining
                // Stop processing the current cluster state update, as there's no point in continuing to compute it as
import org.opensearch.monitor.StatusInfo;
        transportService.registerRequestHandler(
    }
            ThreadPool.Names.GENERIC,
                } catch (IOException e) {
import org.opensearch.cluster.ClusterState;
        private final JoinTaskExecutor.Task task;
    private final Supplier<JoinTaskExecutor> joinTaskExecutorGenerator;
                    );
        public String toString() {
            public void handleException(TransportException exp) {
        if (attempt != null) {
        transportService.registerRequestHandler(
            final JoinTaskExecutor.Task task = new JoinTaskExecutor.Task(sender, "join existing leader");
            return serialisedClusterStateBySoftwareVersion.containsKey(softwareVersion);
                    ClusterStateTaskConfig.build(Priority.URGENT),
            public void onSuccess() {
        @Override
        }
            @Override
                    }
            this.joinCallback = joinCallback;
     * @opensearch.internal
        try (StreamInput input = CompressedStreamUtils.decompressBytes(request, namedWriteableRegistry)) {
    public static final String START_JOIN_ACTION_NAME = "internal:cluster/coordination/start_join";
import org.opensearch.core.transport.TransportResponse;
                        lastFailedJoinAttempt.set(null);
                    stateUpdateSource,
            attempt.logWarnWithTimestamp();
                    @Override
        void logWarnWithTimestamp() {
     */
            if (this.clusterStateVersion == null || !this.clusterStateVersion.equals(clusterStateVersion)) {
        }
import java.util.function.Supplier;
            ThreadPool.Names.GENERIC,
                    pendingAsTasks.put(task, new JoinTaskListener(task, value));
            }
import org.opensearch.transport.TransportChannel;
        public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
            if (cause instanceof CoordinationStateRejectedException
            }
        }
            START_JOIN_ACTION_NAME,
        } else {
     * @opensearch.internal
            }
        }
        public void onFailure(String source, Exception e) {
        }
                sendJoinRequest(destination, currentTermSupplier.getAsLong(), Optional.of(joinLeaderInTerm.apply(request)));
            joinCallback.onFailure(new CoordinationStateRejectedException("join target is a follower"));
                throws Exception {
                        onCompletion.run();
                    joinRequest
import org.opensearch.cluster.ClusterStateTaskConfig;
            }
import org.opensearch.core.common.bytes.BytesReference;
            return "FollowerJoinAccumulator";
        return pendingOutgoingJoins.isEmpty() == false;
import org.opensearch.node.remotestore.RemoteStoreNodeService;
    private static final Logger logger = LogManager.getLogger(JoinHelper.class);
            StartJoinRequest::new,
        }
    }
        AllocationService allocationService,
            Names.GENERIC,
            this.clusterStateVersion = clusterStateVersion;
                    channel.sendResponse(e);
        public String toString() {
                return ThreadPool.Names.SAME;
                            + term
    public static final String JOIN_ACTION_NAME = "internal:cluster/coordination/join";
 */
                        FailedJoinAttempt attempt = new FailedJoinAttempt(destination, joinRequest, exp);
                    }
                            + "), there is a newer cluster-manager"
            if (prev != null) {
        final Tuple<DiscoveryNode, JoinRequest> dedupKey = Tuple.tuple(destination, joinRequest);
                });
 * ownership. Elasticsearch licenses this file to you under
}
            try {
            Throwable cause = e.unwrapCause();
                    node,
                final DiscoveryNode destination = request.getSourceNode();
import org.opensearch.cluster.ClusterStateTaskListener;
        final StatusInfo statusInfo = nodeHealthService.getHealth();
        public String toString() {
    /**
        private final DiscoveryNode destination;
    ) throws IOException {
import java.util.LinkedHashMap;
    }
    static class InitialJoinAccumulator implements JoinAccumulator {
                            throw new RuntimeException(e);
            rerouteService,
     * A leader join accumulator.
import org.opensearch.transport.TransportRequestOptions;
                return Level.DEBUG;
                () -> new ParameterizedMessage(
 * software distributed under the License is distributed on an
                            // mandatory as AtomicReference doesn't rethrow IOException.
 * GitHub history for details.
        void handleJoinRequest(DiscoveryNode sender, JoinCallback joinCallback);
    }
    private final NamedWriteableRegistry namedWriteableRegistry;
import org.opensearch.common.unit.TimeValue;
            logger.debug("dropping join request to [{}]: [{}]", destination, statusInfo.getInfo());
        private final Map<DiscoveryNode, JoinCallback> joinRequestAccumulator = new HashMap<>();
 * KIND, either express or implied.  See the License for the
                pendingAsTasks.put(JoinTaskExecutor.newBecomeClusterManagerTask(), (source, e) -> {});
     */
            this.exception = exception;
        @Override
        private final Map<Version, BytesReference> serialisedClusterStateBySoftwareVersion;
        TransportService transportService,
        }
 * Licensed to Elasticsearch under one or more contributor
    }
            );
            assert false : "unexpected join from " + sender + " during initialisation";
import java.util.Collection;
                } else if (currentState.nodes().getClusterManagerNodeId() == null
import org.opensearch.monitor.NodeHealthService;
        private final JoinRequest joinRequest;
                    } else if (currentState.nodes().isLocalNodeElectedClusterManager()) {
            joinCallback.onSuccess();
    static class FollowerJoinAccumulator implements JoinAccumulator {
            @Override
     */
                            .coordinationMetadata(coordinationMetadata)
import org.opensearch.common.settings.Settings;
                joinRequest,
                channel.sendResponse(Empty.INSTANCE);
            }
                    logger.warn("failed to send back failure on join request", inner);
/*
        private SerializedClusterStateCache(
                    }
                        assert currentState.term() < term
        Function<StartJoinRequest, Join> joinLeaderInTerm,
import org.opensearch.threadpool.ThreadPool;
     *
                        attempt.logNow();
                channel.sendResponse(Empty.INSTANCE);
        Supplier<ClusterState> currentStateSupplier,
     */
                    VALIDATE_COMPRESSED_JOIN_ACTION_NAME,
 * Modifications Copyright OpenSearch Contributors. See
                || cause instanceof NotClusterManagerException) {
        "cluster.join.timeout",
 * SPDX-License-Identifier: Apache-2.0
                final Map<JoinTaskExecutor.Task, ClusterStateTaskListener> pendingAsTasks = new LinkedHashMap<>();
        private final long timestamp;
            logger.debug("already attempting to join {} with request {}, not sending request", destination, joinRequest);
        if (pendingOutgoingJoins.add(dedupKey)) {
                    + incomingState.metadata().clusterUUID()
                assert newMode == Mode.FOLLOWER : newMode;
    void logLastFailedJoinAttempt() {
import org.apache.logging.log4j.Logger;
            ValidateJoinRequest::new,
                    joinTaskExecutor
            (request, channel, task) -> joinHandler.accept(request, transportJoinCallback(request, channel))
            logger.warn(
            @Override
                        }
            settings,
            logger.log(
 * this file be licensed under the Apache-2.0 license or a
    private final AtomicReference<FailedJoinAttempt> lastFailedJoinAttempt = new AtomicReference<>();
            this.serialisedClusterStateBySoftwareVersion = Collections.unmodifiableMap(
    /**
                prev.onFailure(new CoordinationStateRejectedException("received a newer join from " + sender));
        this.transportService = transportService;
                return Empty.INSTANCE;
                        logger.info(() -> new ParameterizedMessage("failed to join {} with {}", destination, joinRequest), exp);
                    pendingAsTasks,
        boolean closed;
            return new SerializedClusterStateCache(serializedClusterStateCache.clusterStateVersion, newMap);
            // CandidateJoinAccumulator is only closed when becoming leader or follower, otherwise it accumulates all joins received
import org.opensearch.transport.BytesTransportRequest;
        ) {
        private boolean containsStateForNodeVersion(Long clusterStateVersion, Version softwareVersion) {
                    destination,
            remoteStoreNodeService
                    }
            false,
                ClusterStateTaskConfig.build(Priority.URGENT),
        private static final int MAX_VERSIONS_SIZE = 2;
                            .term(term)
    JoinHelper(
                    .forEach(joinCallback -> joinCallback.onFailure(new CoordinationStateRejectedException("became follower")));
     * The callback interface.
                }
     * Listener for the join task
        Collection<BiConsumer<DiscoveryNode, ClusterState>> joinValidators,
                        BytesReference compressedStream;
                    // node version.
                new ValidateJoinRequest(state),
        RemoteStoreNodeService remoteStoreNodeService,
            logger.debug("attempting to join {} with {}", destination, joinRequest);
import org.opensearch.core.transport.TransportResponse.Empty;
        }
     * @opensearch.internal
        Consumer<Boolean> nodeCommissioned,
                    throw new NotClusterManagerException(
    private volatile JoinTaskExecutor joinTaskExecutor;
            && localState.metadata().clusterUUID().equals(incomingState.metadata().clusterUUID()) == false) {
                JOIN_ACTION_NAME,
                joinRequestAccumulator.forEach((key, value) -> {
    );
            }
            return Level.INFO;
            }
        public void handleJoinRequest(DiscoveryNode sender, JoinCallback joinCallback) {
import static org.opensearch.monitor.StatusInfo.Status.UNHEALTHY;
    ) {
    class CandidateJoinAccumulator implements JoinAccumulator {
 *
        ) {
            @Override
            JOIN_ACTION_NAME,
        sendJoinRequest(destination, term, optionalJoin, () -> {});
     * @opensearch.internal
        }
                            );
            return "CandidateJoinAccumulator{" + joinRequestAccumulator.keySet() + ", closed=" + closed + '}';
 * license agreements. See the NOTICE file distributed with
        public Long getClusterStateVersion() {
                return "JoinCallback{request=" + request + "}";
import org.opensearch.Version;
                            logger.info(
    static class FailedJoinAttempt {
                final BytesReference bytes = serializedClusterStateCache.updateAndGet(currentCache -> {
            logger,
            }
                "node-join",
    private final Set<Tuple<DiscoveryNode, JoinRequest>> pendingOutgoingJoins = Collections.synchronizedSet(new HashSet<>());
        Setting.Property.NodeScope,
import java.util.Map;
                task,
        Settings settings,
                runJoinValidators(currentStateSupplier, request.getState(), joinValidators);
        }
    private final AtomicReference<SerializedClusterStateCache> serializedClusterStateCache = new AtomicReference<>();
 */
                        pendingOutgoingJoins.remove(dedupKey);
        }
        @Override
                newMap.remove(newMap.keySet().iterator().next());
import org.opensearch.core.action.ActionListener;
        this.joinTaskExecutorGenerator = () -> new JoinTaskExecutor(
            }
        BiConsumer<JoinRequest, JoinCallback> joinHandler,
     *
        BytesTransportRequest request
                            nodeCommissioned.accept(false);
                "join validation on cluster state"
    protected void handleCompressedValidateJoinRequest(
import org.opensearch.common.Priority;
        public void handleJoinRequest(DiscoveryNode sender, JoinCallback joinCallback) {
            public ClusterTasksResult<JoinTaskExecutor.Task> execute(ClusterState currentState, List<JoinTaskExecutor.Task> joiningTasks)
                listener.onFailure(e);
 * The OpenSearch Contributors require contributions made to
        NamedWriteableRegistry namedWriteableRegistry
                    + " with a different cluster uuid "
 * Unless required by applicable law or agreed to in writing,
                return super.execute(currentState, joiningTasks);
        }
                TransportRequestOptions.EMPTY,
                    final JoinTaskExecutor.Task task = new JoinTaskExecutor.Task(key, "elect leader");
package org.opensearch.cluster.coordination;
                    new ActionListenerResponseHandler<>(listener, i -> Empty.INSTANCE, ThreadPool.Names.GENERIC)
 * Helper utility class for joining the cluster
                    && joiningTasks.stream().anyMatch(Task::isBecomeClusterManagerTask)) {
        @Override
                () -> new ParameterizedMessage("failed to join {} with {}", destination, joinRequest),
                        } catch (IOException e) {
                new ActionListenerResponseHandler<>(listener, i -> Empty.INSTANCE, ThreadPool.Names.GENERIC)
                            .build();
            assert joinTaskExecutor != null;
                final String stateUpdateSource = "elected-as-cluster-manager ([" + pendingAsTasks.size() + "] nodes joined)";
            allocationService,
    public void sendJoinRequest(DiscoveryNode destination, long term, Optional<Join> optionalJoin, Runnable onCompletion) {
        if (statusInfo.getStatus() == UNHEALTHY) {
        }
    interface JoinAccumulator {
    }
            lastFailedJoinAttempt.compareAndSet(attempt, null);
                new HashMap<>(serialisedClusterStateBySoftwareVersion)
                        final CoordinationMetadata coordinationMetadata = CoordinationMetadata.builder(currentState.coordinationMetadata())
                getLogLevel(exception),
                joinTaskExecutor = joinTaskExecutorGenerator.get();
        public void close(Mode newMode) {
            VALIDATE_JOIN_ACTION_NAME,
            SerializedClusterStateCache serializedClusterStateCache,
            }
import java.util.concurrent.atomic.AtomicReference;
                            compressedStream = CompressedStreamUtils.createCompressedStream(node.getVersion(), state::writeTo);
            ClusterState incomingState = ClusterState.readFrom(input, transportService.getLocalNode());
                        return Names.SAME;
                    inner.addSuppressed(e);
            if (this.clusterStateVersion == null || !this.clusterStateVersion.equals(clusterStateVersion)) {
            }
        };
        private BytesReference getStateForNodeVersion(Long clusterStateVersion, Version softwareVersion) {
    // package-private for testing
    // the timeout for Zen1 join attempts
        }
        };
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            }
            clusterManagerService.submitStateUpdateTask(
            public Empty read(StreamInput in) {
    private final Consumer<Boolean> nodeCommissioned;
            );
            false,
    boolean isJoinPending() {
        @Override
        }
            }
            return;
        TimeValue.timeValueMillis(60000),
    /**
        @Override
                    channel.sendResponse(Empty.INSTANCE);
/*
            public String executor() {
        public SerializedClusterStateCache(Long clusterStateVersion) {
            false,
                        lastFailedJoinAttempt.set(attempt);
            Long clusterStateVersion,
            transportService.sendRequest(
        ) {
    }
    }
        Supplier<ClusterState> currentStateSupplier,
     * An initial join accumulator.
/**
            public void handleResponse(Empty response) {
        private final JoinCallback joinCallback;
        });
            joinCallback.onFailure(new CoordinationStateRejectedException("join target is not initialised yet"));
            );
import java.util.function.Consumer;
            );
                        }
            BytesTransportRequest::new,
                    }
 * not use this file except in compliance with the License.
    /**
import java.util.Collections;
    public void sendJoinRequest(DiscoveryNode destination, long term, Optional<Join> optionalJoin) {
                    "last failed join attempt was {} ago, failed to join {} with {}",
import java.io.IOException;
                        if (exp instanceof RemoteTransportException && (exp.getCause() instanceof NodeDecommissionedException)) {
    }
        );
                exception
            this.serialisedClusterStateBySoftwareVersion = Collections.emptyMap();
                    onFailure(e);
                    + localState.metadata().clusterUUID()
            @Override
 * the Apache License, Version 2.0 (the "License"); you may
     */
     */
                );
    /**
        );
                }
import org.opensearch.cluster.metadata.Metadata;
                try {
import org.opensearch.cluster.routing.RerouteService;
        }
                exception
            }
            );
            this.timestamp = System.nanoTime();
                joinRequestAccumulator.values()
        public void handleJoinRequest(DiscoveryNode sender, JoinCallback joinCallback) {
                handleCompressedValidateJoinRequest(currentStateSupplier, joinValidators, request);
                final BytesTransportRequest request = new BytesTransportRequest(bytes, node.getVersion());
                }).getStateForNodeVersion(state.version(), node.getVersion());
import org.apache.logging.log4j.LogManager;
import org.opensearch.transport.RemoteTransportException;
            } else {
                logger.debug(new ParameterizedMessage("failure in response to {} from {}", startJoinRequest, destination), exp);
import java.util.Set;
    public void sendValidateJoinRequest(DiscoveryNode node, ClusterState state, ActionListener<TransportResponse.Empty> listener) {
        private static SerializedClusterStateCache createNewCache(
        Collection<BiConsumer<DiscoveryNode, ClusterState>> joinValidators,
import org.opensearch.core.common.io.stream.StreamInput;
 * compatible open source license.
    }
                    request,
        }
                pendingAsTasks.put(JoinTaskExecutor.newFinishElectionTask(), (source, e) -> {});
    private final ClusterManagerService clusterManagerService;
     * @opensearch.internal
import org.opensearch.threadpool.ThreadPool.Names;
                    if (currentCache.containsStateForNodeVersion(state.version(), node.getVersion()) == false) {
                                "local node is decommissioned [{}]. Will not be able to join the cluster",
     * A follower join accumulator.
                    public String executor() {
     *
        public String toString() {
import org.opensearch.cluster.service.ClusterManagerService;
        Setting.Property.Deprecated
        );
                        nodeCommissioned.accept(true);
     *
            }
            );
            this.destination = destination;
            return "JoinTaskListener{task=" + task + "}";
                destination,
 *
            transportService.sendRequest(
        Collection<BiConsumer<DiscoveryNode, ClusterState>> joinValidators
        public String toString() {
        this.nodeHealthService = nodeHealthService;
    public static final Setting<TimeValue> JOIN_TIMEOUT_SETTING = Setting.timeSetting(
            @Override
     * A failed join attempt.
        }
    class LeaderJoinAccumulator implements JoinAccumulator {
        );
                new JoinTaskListener(task, joinCallback)
import java.util.function.BiConsumer;
                }
                    }
                            + currentState.term()
import org.opensearch.action.ActionListenerResponseHandler;
     *
    }
            this.task = task;
        }
        }
            closed = true;
            runJoinValidators(currentStateSupplier, incomingState, joinValidators);
        final JoinRequest joinRequest = new JoinRequest(transportService.getLocalNode(), term, optionalJoin);
                            + " > used: "
                    logger.trace("encountered higher term {} than current {}, there is a newer cluster-manager", currentState.term(), term);
        transportService.registerRequestHandler(
                    TimeValue.timeValueMillis(TimeValue.nsecToMSec(System.nanoTime() - timestamp)),
     *
            );
    /**
        this.clusterManagerService = clusterManagerService;
                    if (currentCache == null || state.version() != currentCache.getClusterStateVersion()) {
     * @opensearch.internal
        }
        }
                    // This will not be null as we reference to the new cache created which contains the serialized cluster state for the
            ThreadPool.Names.GENERIC,
                joinTaskExecutor = null;
        Supplier<ClusterState> currentStateSupplier,
import org.opensearch.transport.TransportRequest;
                    + " than local cluster uuid "
                    @Override
    private void runJoinValidators(
import org.opensearch.transport.TransportResponseHandler;
                clusterManagerService.submitStateUpdateTasks(
    ) {
            Map<Version, BytesReference> serialisedClusterStateBySoftwareVersion
        void logNow() {
        } else {
        }
        @Override
     */
 *
                transportService.sendRequest(
                    public Empty read(StreamInput in) {
    }
            return clusterStateVersion;
import java.util.HashSet;
        assert startJoinRequest.getSourceNode().isClusterManagerNode() : "sending start-join request for cluster-manager-ineligible "
            assert closed == false : "CandidateJoinAccumulator closed";
        }
        if (localState.metadata().clusterUUIDCommitted()
import org.opensearch.common.settings.Setting;
                new TransportResponseHandler<Empty>() {
            return serialisedClusterStateBySoftwareVersion.get(softwareVersion);
                logger.debug("successful response to {} from {}", startJoinRequest, destination);
        private final TransportException exception;
    private final NodeHealthService nodeHealthService;
                    return currentCache;
        }
            JoinCallback prev = joinRequestAccumulator.put(sender, joinCallback);
            return "InitialJoinAccumulator";
                // it will later be rejected by Coordinator.publish(...) anyhow
            Version versionToSerialize,
 * this work for additional information regarding copyright
 */
        static Level getLogLevel(TransportException e) {
            @Override
                ),
                        pendingOutgoingJoins.remove(dedupKey);
     *
 * under the License.
    public void sendStartJoinRequest(final StartJoinRequest startJoinRequest, final DiscoveryNode destination) {
        @Override
 */
                channel.sendResponse(Empty.INSTANCE);
public class JoinHelper {
            private final long term = currentTermSupplier.getAsLong();
import org.opensearch.cluster.routing.allocation.AllocationService;
                } catch (Exception inner) {
import org.opensearch.transport.TransportException;
        default void close(Mode newMode) {}
                    public void handleException(TransportException exp) {
 *
            public void onFailure(Exception e) {
     */
            (request, channel, task) -> {
                        return Empty.INSTANCE;
                        currentState = ClusterState.builder(currentState).metadata(metadata).build();
        @Override
    }
 * specific language governing permissions and limitations
            Map<Version, BytesReference> newMap = new HashMap<>(serializedClusterStateCache.serialisedClusterStateBySoftwareVersion);
import org.opensearch.cluster.decommission.NodeDecommissionedException;
            false,
            newMap.put(versionToSerialize, bytes);
        assert destination.isClusterManagerNode() : "trying to join cluster-manager-ineligible " + destination;
                        "Higher term encountered (current: "
                    }
        public void handleJoinRequest(DiscoveryNode sender, JoinCallback joinCallback) {
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            (request, channel, task) -> {
import org.apache.logging.log4j.Level;
        }
            }
                // in a higher term already
                return null;
            @Override
        }
            BytesReference bytes
        JoinTaskListener(JoinTaskExecutor.Task task, JoinCallback joinCallback) {
        LongSupplier currentTermSupplier,
 *     http://www.apache.org/licenses/LICENSE-2.0
        transportService.sendRequest(destination, START_JOIN_ACTION_NAME, startJoinRequest, new TransportResponseHandler<Empty>() {
            joinCallback.onFailure(e);
import java.util.Optional;
            }
            } catch (Exception e) {
        FailedJoinAttempt attempt = lastFailedJoinAttempt.get();
                node,
    }
            JoinRequest::new,
                logger.warn("error sending cluster state to {}", node);
    /**
            throw new CoordinationStateRejectedException(
        TimeValue.timeValueMillis(1),
                VALIDATE_JOIN_ACTION_NAME,
                        final Metadata metadata = Metadata.builder(currentState.metadata())
import java.util.function.LongSupplier;
        @Override
                return false;
            return "LeaderJoinAccumulator";
            }
    }
                    public void handleResponse(Empty response) {
        void onSuccess();
            assert closed == false : "CandidateJoinAccumulator closed";
                        logger.debug("successfully joined {} with {}", destination, joinRequest);
    public interface JoinCallback {
                if (currentState.term() > term) {
    public static final class SerializedClusterStateCache {
import org.apache.logging.log4j.message.ParameterizedMessage;
        RerouteService rerouteService,
 * @opensearch.internal
                    @Override
            if (newMap.size() == MAX_VERSIONS_SIZE) {
                        assert currentState.term() == term : "term should be stable for the same cluster-manager";
     * Cache for serialized cluster state with keys cluster state version and opensearch version
        FailedJoinAttempt(DiscoveryNode destination, JoinRequest joinRequest, TransportException exception) {
 * You may obtain a copy of the License at
            VALIDATE_COMPRESSED_JOIN_ACTION_NAME,
            this.joinRequest = joinRequest;
        joinValidators.forEach(action -> action.accept(transportService.getLocalNode(), incomingState));
        ClusterState incomingState,
                            : "there should be at most one become cluster-manager task per election (= by term)";
    public static final String VALIDATE_JOIN_ACTION_NAME = "internal:cluster/coordination/join/validate";
                        currentCache = new SerializedClusterStateCache(state.version());
                // The current state that ClusterManagerService uses might have been updated by a (different) cluster-manager
     * @opensearch.internal
                joinTaskExecutor,
                    + ", rejecting"
                        return SerializedClusterStateCache.createNewCache(currentCache, node.getVersion(), compressedStream);
                try {
import org.opensearch.cluster.NotClusterManagerException;
                );
     *
    }
                        try {
import org.opensearch.common.collect.Tuple;
        }
        transportService.registerRequestHandler(
import org.opensearch.cluster.coordination.Coordinator.Mode;
    static class JoinTaskListener implements ClusterStateTaskListener {
        ClusterManagerService clusterManagerService,
        if (node.getVersion().before(Version.V_2_9_0)) {
        NodeHealthService nodeHealthService,
        @Override
            // regardless of term.
            + startJoinRequest.getSourceNode();
        void onFailure(Exception e);
    }
            if (newMode == Mode.LEADER) {
            public String toString() {
    }
        }
            (request, channel, task) -> {
