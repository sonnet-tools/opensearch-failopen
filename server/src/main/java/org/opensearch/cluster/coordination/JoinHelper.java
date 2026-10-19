    }  
                    // node version.
package org.opensearch.cluster.coordination;
                    node,
                        attempt.logNow();
        RerouteService rerouteService,  
            public String executor() {  
                    final JoinTaskExecutor.Task task = new JoinTaskExecutor.Task(key, "elect leader");  
            }
                });
     * An initial join accumulator.  
}
        };
                        final CoordinationMetadata coordinationMetadata = CoordinationMetadata.builder(currentState.coordinationMetadata())  
 * under the License.  
                () -> new ParameterizedMessage("failed to join {} with {}", destination, joinRequest),
                destination,
                try {
                        currentCache = new SerializedClusterStateCache(state.version());  
                return "JoinCallback{request=" + request + "}";  
     *
import org.opensearch.core.transport.TransportResponse.Empty;  
        );
                        lastFailedJoinAttempt.set(null);
                    @Override  
            BytesReference bytes  
    class CandidateJoinAccumulator implements JoinAccumulator {  
     * The callback interface.  
            @Override
    /**
            ThreadPool.Names.GENERIC,
                    ClusterStateTaskConfig.build(Priority.URGENT),  
                    + " with a different cluster uuid "  
        if (statusInfo.getStatus() == UNHEALTHY) {
    }  
                joinTaskExecutor = null;
            try {  
        public void close(Mode newMode) {  
import java.util.Collection;
import org.opensearch.threadpool.ThreadPool;
        private final DiscoveryNode destination;
                return null;
import org.opensearch.cluster.routing.RerouteService;
            );
            if (this.clusterStateVersion == null || !this.clusterStateVersion.equals(clusterStateVersion)) {  
 * GitHub history for details.
    }
        public void onFailure(String source, Exception e) {
    interface JoinAccumulator {
        }  
     * Cache for serialized cluster state with keys cluster state version and opensearch version
                final BytesTransportRequest request = new BytesTransportRequest(bytes, node.getVersion());
                prev.onFailure(new CoordinationStateRejectedException("received a newer join from " + sender));
            @Override  
     * @opensearch.internal
        );
    private volatile JoinTaskExecutor joinTaskExecutor;
                TransportRequestOptions.EMPTY,
                    pendingAsTasks.put(task, new JoinTaskListener(task, value));
        if (localState.metadata().clusterUUIDCommitted()
 * Helper utility class for joining the cluster
import java.util.HashMap;  
                );
            ThreadPool.Names.GENERIC,
                        onCompletion.run();  
                    @Override
            transportService.sendRequest(
import org.opensearch.cluster.service.ClusterManagerService;
        }
                    + ", rejecting"
 * Modifications Copyright OpenSearch Contributors. See  
        };
                joinRequest,
        Consumer<Boolean> nodeCommissioned,
                        } catch (IOException e) {  
            assert false : "unexpected join from " + sender + " during initialisation";
        }  
            }
                    + incomingState.metadata().clusterUUID()
    /**
            this.destination = destination;
            return;
                        currentState = ClusterState.builder(currentState).metadata(metadata).build();  
    private final TransportService transportService;
import java.util.Optional;
        );  
            }
        TimeValue.timeValueMillis(60000),  
import org.apache.logging.log4j.LogManager;
public class JoinHelper {  
            }
import org.apache.logging.log4j.Logger;
        );
import org.opensearch.core.common.bytes.BytesReference;
import java.util.Set;  
            }
/**
                exception
            }
        joinValidators.forEach(action -> action.accept(transportService.getLocalNode(), incomingState));
                    public void handleResponse(Empty response) {
        Collection<BiConsumer<DiscoveryNode, ClusterState>> joinValidators,
            @Override
        }  
                    return currentCache;  
        Setting.Property.NodeScope,
    // the timeout for Zen1 join attempts  
     * @opensearch.internal
            }
            public void handleResponse(Empty response) {
                joinRequestAccumulator.forEach((key, value) -> {
            joinCallback.onFailure(new CoordinationStateRejectedException("join target is a follower"));
            Long clusterStateVersion,  
     * @opensearch.internal
        private static SerializedClusterStateCache createNewCache(  
                    joinRequest
 * compatible open source license.
    public static final String START_JOIN_ACTION_NAME = "internal:cluster/coordination/start_join";
                    }
                        }  
/*  
        }
import java.util.Map;
                    public void handleException(TransportException exp) {
        @Override
            }  
            public Empty read(StreamInput in) {  
                    channel.sendResponse(Empty.INSTANCE);  
            + startJoinRequest.getSourceNode();  
                    } else if (currentState.nodes().isLocalNodeElectedClusterManager()) {
            private final long term = currentTermSupplier.getAsLong();
                    onFailure(e);
                } catch (Exception inner) {
        TimeValue.timeValueMillis(1),
                final DiscoveryNode destination = request.getSourceNode();
    public void sendValidateJoinRequest(DiscoveryNode node, ClusterState state, ActionListener<TransportResponse.Empty> listener) {  
                    }
    }
import java.util.function.Supplier;  
import org.opensearch.common.Priority;
            false,
 *  
        public String toString() {
    ) {  
        transportService.registerRequestHandler(
 * KIND, either express or implied.  See the License for the
        }
                        lastFailedJoinAttempt.set(attempt);  
                // it will later be rejected by Coordinator.publish(...) anyhow
                    new ActionListenerResponseHandler<>(listener, i -> Empty.INSTANCE, ThreadPool.Names.GENERIC)
            // CandidateJoinAccumulator is only closed when becoming leader or follower, otherwise it accumulates all joins received
                    }
    /**
                || cause instanceof FailedToCommitClusterStateException
            Throwable cause = e.unwrapCause();
                        BytesReference compressedStream;  
        sendJoinRequest(destination, term, optionalJoin, () -> {});
                    if (currentCache.containsStateForNodeVersion(state.version(), node.getVersion()) == false) {
            // regardless of term.
            return "CandidateJoinAccumulator{" + joinRequestAccumulator.keySet() + ", closed=" + closed + '}';
     * A candidate join accumulator.
                throws Exception {  
            @Override
            attempt.logWarnWithTimestamp();  
                joinTaskExecutor = joinTaskExecutorGenerator.get();
            assert closed == false : "CandidateJoinAccumulator closed";
    }
        }  
    public void sendStartJoinRequest(final StartJoinRequest startJoinRequest, final DiscoveryNode destination) {
                            + " > used: "
     */
import org.opensearch.transport.TransportResponseHandler;  
 *
        }  
/*
        }
            && localState.metadata().clusterUUID().equals(incomingState.metadata().clusterUUID()) == false) {  
                final BytesReference bytes = serializedClusterStateCache.updateAndGet(currentCache -> {
                assert newMode == Mode.FOLLOWER : newMode;
                } catch (IOException e) {
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
    private final Supplier<JoinTaskExecutor> joinTaskExecutorGenerator;
import java.util.function.LongSupplier;
                        return Names.SAME;
 *     http://www.apache.org/licenses/LICENSE-2.0
    public void sendJoinRequest(DiscoveryNode destination, long term, Optional<Join> optionalJoin) {  
        Collection<BiConsumer<DiscoveryNode, ClusterState>> joinValidators,  
import org.opensearch.cluster.NotClusterManagerException;  
        assert destination.isClusterManagerNode() : "trying to join cluster-manager-ineligible " + destination;  
                                "local node is decommissioned [{}]. Will not be able to join the cluster",  
            transportService.sendRequest(
                clusterManagerService.submitStateUpdateTasks(  
            newMap.put(versionToSerialize, bytes);  
            this.joinCallback = joinCallback;  
            return Level.INFO;
        Supplier<ClusterState> currentStateSupplier,
        private final long timestamp;
            runJoinValidators(currentStateSupplier, incomingState, joinValidators);
                node,  
                            // mandatory as AtomicReference doesn't rethrow IOException.
                JOIN_ACTION_NAME,  
        this.joinTaskExecutorGenerator = () -> new JoinTaskExecutor(  
        }
                pendingAsTasks.put(JoinTaskExecutor.newBecomeClusterManagerTask(), (source, e) -> {});  
    }
    protected void handleCompressedValidateJoinRequest(
                new JoinTaskListener(task, joinCallback)
            this.task = task;
    public interface JoinCallback {
        private SerializedClusterStateCache(
                new ValidateJoinRequest(state),
     */
    private final ClusterManagerService clusterManagerService;  
                            + term
            ClusterState incomingState = ClusterState.readFrom(input, transportService.getLocalNode());
    JoinHelper(
            false,
import org.apache.logging.log4j.Level;  
                            + currentState.term()  
                            : "there should be at most one become cluster-manager task per election (= by term)";
                    }
        public Long getClusterStateVersion() {  
                    }  
        if (attempt != null) {
        this.transportService = transportService;  
                            throw new RuntimeException(e);
        @Override
                }  
            return "FollowerJoinAccumulator";  
            return "InitialJoinAccumulator";
                    + " than local cluster uuid "
        transportService.registerRequestHandler(  
            this.joinRequest = joinRequest;  
        void handleJoinRequest(DiscoveryNode sender, JoinCallback joinCallback);
        }
        }  
                    public String executor() {  
                new ActionListenerResponseHandler<>(listener, i -> Empty.INSTANCE, ThreadPool.Names.GENERIC)  
    private JoinCallback transportJoinCallback(TransportRequest request, TransportChannel channel) {  
     * @opensearch.internal
 * You may obtain a copy of the License at  
            }  
                new HashMap<>(serialisedClusterStateBySoftwareVersion)
                getLogLevel(exception),
                    logger.trace("encountered higher term {} than current {}, there is a newer cluster-manager", currentState.term(), term);  
    }  
                newMap.remove(newMap.keySet().iterator().next());
        });  
                // Joining node version is read when deserializing the cluster state
import org.opensearch.common.settings.Setting;
    /**
    public static final class SerializedClusterStateCache {  
     * A leader join accumulator.
            public String toString() {
                }
                    // This will not be null as we reference to the new cache created which contains the serialized cluster state for the
     *  
                    inner.addSuppressed(e);
                    @Override
    /**
import org.opensearch.transport.TransportRequest;
            JoinRequest::new,
 * this file be licensed under the Apache-2.0 license or a
            }
            false,  
            this.serialisedClusterStateBySoftwareVersion = Collections.emptyMap();
            this.exception = exception;
        private boolean containsStateForNodeVersion(Long clusterStateVersion, Version softwareVersion) {
    }
    private final Set<Tuple<DiscoveryNode, JoinRequest>> pendingOutgoingJoins = Collections.synchronizedSet(new HashSet<>());
     *  
        transportService.registerRequestHandler(  
                    TimeValue.timeValueMillis(TimeValue.nsecToMSec(System.nanoTime() - timestamp)),  
        final ClusterState localState = currentStateSupplier.get();
                        onCompletion.run();
        ClusterManagerService clusterManagerService,
        } else {
        this.clusterManagerService = clusterManagerService;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            JoinCallback prev = joinRequestAccumulator.put(sender, joinCallback);
                VALIDATE_JOIN_ACTION_NAME,
        public void handleJoinRequest(DiscoveryNode sender, JoinCallback joinCallback) {  
 */
import org.opensearch.cluster.routing.allocation.AllocationService;  
import java.util.function.BiConsumer;
                try {
 * license agreements. See the NOTICE file distributed with
        }
        @Override
 * ownership. Elasticsearch licenses this file to you under  
     */
        @Override
    }
        }
                || cause instanceof NotClusterManagerException) {
        RemoteStoreNodeService remoteStoreNodeService,  
import org.opensearch.common.settings.Settings;
                listener.onFailure(e);
            assert closed == false : "CandidateJoinAccumulator closed";
                    logger.warn("failed to send back failure on join request", inner);  
        } else {
        if (pendingOutgoingJoins.add(dedupKey)) {
                    .forEach(joinCallback -> joinCallback.onFailure(new CoordinationStateRejectedException("became follower")));
            } catch (Exception e) {  
    static class InitialJoinAccumulator implements JoinAccumulator {
            VALIDATE_JOIN_ACTION_NAME,
                final Map<JoinTaskExecutor.Task, ClusterStateTaskListener> pendingAsTasks = new LinkedHashMap<>();
 */  
        public String toString() {
            StartJoinRequest::new,
                        final Metadata metadata = Metadata.builder(currentState.metadata())  
    }
                            nodeCommissioned.accept(false);  
 */
import org.opensearch.transport.TransportService;
        }  
                return false;  
        AllocationService allocationService,  
            if (newMode == Mode.LEADER) {  
            (request, channel, task) -> joinHandler.accept(request, transportJoinCallback(request, channel))  
     *  
     *
        FailedJoinAttempt(DiscoveryNode destination, JoinRequest joinRequest, TransportException exception) {
        @Override
                // in a higher term already
                        return SerializedClusterStateCache.createNewCache(currentCache, node.getVersion(), compressedStream);
 * @opensearch.internal
            if (newMap.size() == MAX_VERSIONS_SIZE) {  
    }
                    joinTaskExecutor
    static class JoinTaskListener implements ClusterStateTaskListener {  
            } else {  
        this.nodeCommissioned = nodeCommissioned;  
        static Level getLogLevel(TransportException e) {
        public String toString() {  
        private final Long clusterStateVersion;
                            .coordinationMetadata(coordinationMetadata)
    private final NodeHealthService nodeHealthService;
            return serialisedClusterStateBySoftwareVersion.containsKey(softwareVersion);
            settings,
            if (cause instanceof CoordinationStateRejectedException  
        this.joinTimeout = JOIN_TIMEOUT_SETTING.get(settings);
            return clusterStateVersion;
     */  
            JOIN_ACTION_NAME,
                // The current state that ClusterManagerService uses might have been updated by a (different) cluster-manager
import org.opensearch.core.action.ActionListener;
                    public Empty read(StreamInput in) {
            }
            }
        }  
            this.clusterStateVersion = clusterStateVersion;  
                        FailedJoinAttempt attempt = new FailedJoinAttempt(destination, joinRequest, exp);
            public ClusterTasksResult<JoinTaskExecutor.Task> execute(ClusterState currentState, List<JoinTaskExecutor.Task> joiningTasks)
            remoteStoreNodeService
            );  
        }
    }
                        try {
                task,
    ) throws IOException {
        NodeHealthService nodeHealthService,
            );
            );
                pendingAsTasks.put(JoinTaskExecutor.newFinishElectionTask(), (source, e) -> {});
        }
 *
        default void close(Mode newMode) {}
                return super.execute(currentState, joiningTasks);
import org.opensearch.transport.TransportRequestOptions;
        }
                    + localState.metadata().clusterUUID()  
                ClusterStateTaskConfig.build(Priority.URGENT),
        void logNow() {
    ) {
                logger.warn("error sending cluster state to {}", node);
        this.namedWriteableRegistry = namedWriteableRegistry;
import org.opensearch.transport.RemoteTransportException;
        private final TransportException exception;
            logger.debug("already attempting to join {} with request {}, not sending request", destination, joinRequest);  
        private final JoinRequest joinRequest;  
                        }
            closed = true;
                    }
import org.apache.logging.log4j.message.ParameterizedMessage;  
                );
 */
        public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {  
                            );
            }
                            compressedStream = CompressedStreamUtils.createCompressedStream(node.getVersion(), state::writeTo);
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.threadpool.ThreadPool.Names;
import org.opensearch.transport.TransportChannel;
import org.opensearch.cluster.coordination.Coordinator.Mode;
                } else if (currentState.nodes().getClusterManagerNodeId() == null
import org.opensearch.action.ActionListenerResponseHandler;
                joinTaskExecutor,  
            rerouteService,
                return ThreadPool.Names.SAME;
        @Override
        public void handleJoinRequest(DiscoveryNode sender, JoinCallback joinCallback) {  
        TransportService transportService,
import java.util.function.Consumer;  
            );
        Collection<BiConsumer<DiscoveryNode, ClusterState>> joinValidators
        }
        transportService.registerRequestHandler(
        @Override
import org.opensearch.cluster.ClusterState;  
    static class FailedJoinAttempt {
                        logger.info(() -> new ParameterizedMessage("failed to join {} with {}", destination, joinRequest), exp);  
        try (StreamInput input = CompressedStreamUtils.decompressBytes(request, namedWriteableRegistry)) {  
    }
                channel.sendResponse(Empty.INSTANCE);  
import java.util.concurrent.atomic.AtomicReference;
            joinCallback.onFailure(new CoordinationStateRejectedException("join target is not initialised yet"));
        @Override
                joinRequestAccumulator.values()  
     */  
                transportService.sendRequest(  
                            .build();
        }  
                }).getStateForNodeVersion(state.version(), node.getVersion());  
 * this work for additional information regarding copyright
        Setting.Property.Deprecated  
import java.util.List;  
                                exp.getCause().getMessage()
import static org.opensearch.monitor.StatusInfo.Status.UNHEALTHY;
        ) {
        private final JoinTaskExecutor.Task task;
                "node-join",  
import java.util.LinkedHashMap;
        }
import org.opensearch.transport.BytesTransportRequest;  
            @Override
    }  
            Names.GENERIC,
            return "LeaderJoinAccumulator";
     *
            return "JoinTaskListener{task=" + task + "}";  
        "cluster.join.timeout",
 * Licensed to Elasticsearch under one or more contributor  
        private BytesReference getStateForNodeVersion(Long clusterStateVersion, Version softwareVersion) {
import org.opensearch.cluster.ClusterStateTaskConfig;
     */
                    pendingAsTasks,
        }
            this.timestamp = System.nanoTime();
    void logLastFailedJoinAttempt() {  
 * specific language governing permissions and limitations
        @Override
import org.opensearch.Version;
        }  
                runJoinValidators(currentStateSupplier, request.getState(), joinValidators);  
        }
     * A follower join accumulator.  
     */  
        final StatusInfo statusInfo = nodeHealthService.getHealth();
        public SerializedClusterStateCache(Long clusterStateVersion) {  
    public static final String VALIDATE_COMPRESSED_JOIN_ACTION_NAME = JOIN_ACTION_NAME + "/validate_compressed";  
        ) {  
 * SPDX-License-Identifier: Apache-2.0
            throw new CoordinationStateRejectedException(
        JoinTaskListener(JoinTaskExecutor.Task task, JoinCallback joinCallback) {
    private final AtomicReference<FailedJoinAttempt> lastFailedJoinAttempt = new AtomicReference<>();  
        FailedJoinAttempt attempt = lastFailedJoinAttempt.get();
     *  
    private static final Logger logger = LogManager.getLogger(JoinHelper.class);
    public static final Setting<TimeValue> JOIN_TIMEOUT_SETTING = Setting.timeSetting(
                        nodeCommissioned.accept(true);
import java.io.IOException;  
                handleCompressedValidateJoinRequest(currentStateSupplier, joinValidators, request);
 * software distributed under the License is distributed on an
        assert startJoinRequest.getSourceNode().isClusterManagerNode() : "sending start-join request for cluster-manager-ineligible "
 * not use this file except in compliance with the License.
import org.opensearch.node.remotestore.RemoteStoreNodeService;  
                    VALIDATE_COMPRESSED_JOIN_ACTION_NAME,
                            + "), there is a newer cluster-manager"  
                        "Higher term encountered (current: "
    }  
            );
    }  
                    }  
                            .build();
            final JoinTaskExecutor.Task task = new JoinTaskExecutor.Task(sender, "join existing leader");  
    class LeaderJoinAccumulator implements JoinAccumulator {  
     * @opensearch.internal
        public void handleJoinRequest(DiscoveryNode sender, JoinCallback joinCallback) {
        LongSupplier currentTermSupplier,
            @Override
            ValidateJoinRequest::new,
        Supplier<ClusterState> currentStateSupplier,
import org.opensearch.cluster.metadata.Metadata;  
            VALIDATE_COMPRESSED_JOIN_ACTION_NAME,  
        @Override
        private final Map<DiscoveryNode, JoinCallback> joinRequestAccumulator = new HashMap<>();
     * Listener for the join task
            clusterManagerService.submitStateUpdateTask(
            }
        @Override  
     * @opensearch.internal
        public void handleJoinRequest(DiscoveryNode sender, JoinCallback joinCallback) {  
        @Override
    }
                    @Override  
                () -> new ParameterizedMessage(
                            .term(term)
        return new JoinCallback() {
            lastFailedJoinAttempt.compareAndSet(attempt, null);
                channel.sendResponse(Empty.INSTANCE);
        }  
            START_JOIN_ACTION_NAME,
        boolean closed;  
    /**
            if (prev != null) {  
        private final JoinCallback joinCallback;
                sendJoinRequest(destination, currentTermSupplier.getAsLong(), Optional.of(joinLeaderInTerm.apply(request)));
        return pendingOutgoingJoins.isEmpty() == false;  
        private final Map<Version, BytesReference> serialisedClusterStateBySoftwareVersion;  
/*
import org.opensearch.monitor.NodeHealthService;
 *  
            Map<Version, BytesReference> serialisedClusterStateBySoftwareVersion
import java.util.function.Function;
                logger.debug("successful response to {} from {}", startJoinRequest, destination);  
        transportService.sendRequest(destination, START_JOIN_ACTION_NAME, startJoinRequest, new TransportResponseHandler<Empty>() {
        }
                    throw new NotClusterManagerException(
            logger.debug("attempting to join {} with {}", destination, joinRequest);  
import org.opensearch.cluster.decommission.NodeDecommissionedException;
                if (currentState.term() > term) {
        Settings settings,
        Function<StartJoinRequest, Join> joinLeaderInTerm,
                        assert currentState.term() == term : "term should be stable for the same cluster-manager";
    /**
import org.opensearch.core.transport.TransportResponse;
        BiConsumer<JoinRequest, JoinCallback> joinHandler,  
    static class FollowerJoinAccumulator implements JoinAccumulator {
        }
            this.serialisedClusterStateBySoftwareVersion = Collections.unmodifiableMap(
            joinCallback.onFailure(e);
            @Override  
                }  
            joinCallback.onSuccess();
        }  
            Version versionToSerialize,
            false,  
        final JoinRequest joinRequest = new JoinRequest(transportService.getLocalNode(), term, optionalJoin);  
            logger.warn(  
            (request, channel, task) -> {
 * The OpenSearch Contributors require contributions made to  
        Supplier<ClusterState> currentStateSupplier,  
            logger.log(  
                final String stateUpdateSource = "elected-as-cluster-manager ([" + pendingAsTasks.size() + "] nodes joined)";
        NamedWriteableRegistry namedWriteableRegistry  
                        pendingOutgoingJoins.remove(dedupKey);
                    && joiningTasks.stream().anyMatch(Task::isBecomeClusterManagerTask)) {  
            logger,  
                        if (exp instanceof RemoteTransportException && (exp.getCause() instanceof NodeDecommissionedException)) {
                    if (currentCache == null || state.version() != currentCache.getClusterStateVersion()) {
            ThreadPool.Names.GENERIC,  
import java.util.Collections;
                        assert currentState.term() < term
                        return Empty.INSTANCE;  
        ClusterState incomingState,
            SerializedClusterStateCache serializedClusterStateCache,
            );
        BytesTransportRequest request
        void onFailure(Exception e);
import org.opensearch.common.unit.TimeValue;  
    }
                ),  
                logger.debug(new ParameterizedMessage("failure in response to {} from {}", startJoinRequest, destination), exp);
     * @opensearch.internal
import org.opensearch.cluster.ClusterStateTaskListener;
            }
            public void handleException(TransportException exp) {
                channel.sendResponse(Empty.INSTANCE);
            this.clusterStateVersion = clusterStateVersion;
                        pendingOutgoingJoins.remove(dedupKey);
            BytesTransportRequest::new,
                new TransportResponseHandler<Empty>() {  
    private final AtomicReference<SerializedClusterStateCache> serializedClusterStateCache = new AtomicReference<>();
                    stateUpdateSource,
    );
        final Tuple<DiscoveryNode, JoinRequest> dedupKey = Tuple.tuple(destination, joinRequest);
    boolean isJoinPending() {
                    "last failed join attempt was {} ago, failed to join {} with {}",
            return new SerializedClusterStateCache(serializedClusterStateCache.clusterStateVersion, newMap);
                            logger.info(
                    request,  
    private void runJoinValidators(
    public static final String VALIDATE_JOIN_ACTION_NAME = "internal:cluster/coordination/join/validate";
     *  
     * A failed join attempt.
        ) {
            }  
            (request, channel, task) -> {  
            Map<Version, BytesReference> newMap = new HashMap<>(serializedClusterStateCache.serialisedClusterStateBySoftwareVersion);
    public void sendJoinRequest(DiscoveryNode destination, long term, Optional<Join> optionalJoin, Runnable onCompletion) {
        void onSuccess();
import org.opensearch.monitor.StatusInfo;
                    channel.sendResponse(e);  
    public static final String JOIN_ACTION_NAME = "internal:cluster/coordination/join";
        public String toString() {  
    // package-private for testing  
import org.opensearch.cluster.node.DiscoveryNode;
            (request, channel, task) -> {  
                return Level.DEBUG;  
                // Stop processing the current cluster state update, as there's no point in continuing to compute it as  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.collect.Tuple;  
    private final Consumer<Boolean> nodeCommissioned;  
     * @opensearch.internal
            logger.debug("dropping join request to [{}]: [{}]", destination, statusInfo.getInfo());  
            public void onFailure(Exception e) {
    }  
            allocationService,
            }
    private final TimeValue joinTimeout; // only used for Zen1 joining
            return serialisedClusterStateBySoftwareVersion.get(softwareVersion);  
            }
import org.opensearch.transport.TransportException;  
            assert joinTaskExecutor != null;
        if (node.getVersion().before(Version.V_2_9_0)) {
        void logWarnWithTimestamp() {
                return Empty.INSTANCE;
                exception  
    private final NamedWriteableRegistry namedWriteableRegistry;
        private static final int MAX_VERSIONS_SIZE = 2;
        this.nodeHealthService = nodeHealthService;
import org.opensearch.core.common.io.stream.StreamInput;
                        logger.debug("successfully joined {} with {}", destination, joinRequest);  
     */
        public String toString() {  
                "join validation on cluster state"
                    );
import java.util.HashSet;
                    destination,
            if (this.clusterStateVersion == null || !this.clusterStateVersion.equals(clusterStateVersion)) {
    /**
            @Override  
            public void onSuccess() {
