import org.opensearch.transport.BytesTransportRequest;
import org.opensearch.core.action.ActionListener;
 */
                // became cluster-manager again, and the new publication started before the previous one completed
            }
                    }
        }
                                node.getVersion(),
    }
            @Override
                        listener.onResponse(response);
    public static final String PUBLISH_STATE_ACTION_NAME = "internal:cluster/coordination/publish_state";
        protected final ClusterState newState;
        ) {
            try {
                    @Override
            @Override
                        logger.warn("unexpected error while deserializing an incoming cluster state", e);
            if (applyFullState == true) {
            incompatibleClusterStateDiffReceivedCount.get(),
            }
            (request, channel, task) -> handleApplyCommit.apply(request, this::updateLastSeen, transportCommitCallback(channel))
                    }
        });
                    () -> new ParameterizedMessage(
                return new RemotePublicationContext(clusterChangedEvent, persistedStateRegistry);
import org.opensearch.OpenSearchException;
            public void onFailure(Exception e) {
            if (destination.equals(discoveryNodes.getLocalNode())) {
                } catch (IOException e) {
            false,
import java.util.concurrent.atomic.AtomicLong;
    private boolean validateRemotePublicationConfiguredOnAllNodes(DiscoveryNodes discoveryNodes) {
    }
            }
        return true;
                    )
            } else if (manifest.getDiffManifest() == null) {
    private final TransportService transportService;
            previousState = clusterChangedEvent.previousState();
            assert transportService.getThreadPool().getThreadContext().isSystemContext();
        );
                stateRequestOptions,
                    lastSeen,
                logger.debug("sending remote cluster state to node: {}", destination.getName());
        Function<PublishRequest, PublishWithJoinResponse> handlePublishRequest,
 * Unless required by applicable law or agreed to in writing,
                COMMIT_STATE_ACTION_NAME,
            } else {
                request.getManifestFile()
 * this work for additional information regarding copyright
                return acceptRemoteStateOnLocalNode(request);
        }
                try {
        }
    ) {
            assert transportService.getThreadPool().getThreadContext().isSystemContext();
    private static final Logger logger = LogManager.getLogger(PublicationTransportHandler.class);
        if (isRemotePublicationEnabled == true) {
                        if (diff == null) {
                final BytesTransportRequest request = new BytesTransportRequest(bytes, destination.getVersion());
            assert publishRequest.getAcceptedState() == newState : "state got switched on us";
        protected final boolean sendFullVersion;
import org.opensearch.core.common.io.stream.StreamInput;
            newState = clusterChangedEvent.state();
            }
        try (StreamInput in = CompressedStreamUtils.decompressBytes(request, namedWriteableRegistry)) {
            BytesReference bytes = serializedStates.get(destination.getVersion());
                }
            sendFullVersion = previousState.getBlocks().disableStatePersistence();
 * @opensearch.internal
        }
        }
    private static BytesReference serializeDiffClusterState(Diff<ClusterState> diff, Version nodeVersion) throws IOException {
import org.opensearch.cluster.Diff;
            ApplyCommitRequest::new,
            logger.trace("sending cluster state over transport to node: {}", destination.getName());
            ThreadPool.Names.GENERIC,
                lastSeenClusterState.set(incomingState);
            DiscoveryNode destination,
            this.persistedStateRegistry = persistedStateRegistry;
                logger.warn(() -> new ParameterizedMessage("error sending remote cluster state to {}", destination), e);
        }
        boolean applyFullState = false;
            if (sendFullVersion || previousState.nodes().nodeExists(destination) == false) {
            }
            );
import org.opensearch.gateway.remote.ClusterMetadataManifest;
    ) {
                    transportService.getLocalNode().getId()
                + "]";
    public class PublicationContext {
                );
        protected final DiscoveryNodes discoveryNodes;
    private final AtomicReference<PublishRequest> currentPublishRequestToSelf = new AtomicReference<>();
        this.currentPublishRequestToSelf.set(publishRequest);
                );
        public void sendClusterState(DiscoveryNode destination, ActionListener<PublishWithJoinResponse> listener) {
import org.opensearch.transport.TransportChannel;
            }
                };
    // the cluster-manager needs the original non-serialized state as the cluster state contains some volatile information that we
                final PublishWithJoinResponse response = acceptState(clusterState, manifest);
                if (lastSeen == null) {
            sendClusterState(destination, bytes, true, listener);
import org.opensearch.core.common.bytes.BytesReference;
                applyFullState = true;
 * the Apache License, Version 2.0 (the "License"); you may
                        currentPublishRequestToSelf.compareAndSet(publishRequest, null); // only clean-up our mess
                applyFullState = true;
            public void onResponse(Void aVoid) {
        protected final PersistedStateRegistry persistedStateRegistry;
                    transportService.getLocalNode().getId(),
                + destination.getVersion()
        if (publishRequest == null
            final ClusterState lastSeen = lastSeenClusterState.get();
            PUBLISH_REMOTE_STATE_ACTION_NAME,
                        if (serializedStates.containsKey(node.getVersion()) == false) {
                );
                // if all nodes are remote then create remote publication context
        }
                        }
                transportService.sendRequest(destination, PUBLISH_STATE_ACTION_NAME, request, stateRequestOptions, responseHandler);
    private PublishWithJoinResponse acceptState(ClusterState incomingState, ClusterMetadataManifest manifest) {
                    listener.onFailure(exp);
    }
                            diff = newState.diff(previousState);
                        throw e;
                    manifest,
        }
            } else if (manifest.getDiffManifest().getFromStateUUID().equals(lastSeen.stateUUID()) == false) {
import org.opensearch.gateway.GatewayMetaState.RemotePersistedState;
                // Close early to release resources used by the de-compression as early as possible
                sendFullClusterState(destination, listener);
import org.opensearch.cluster.node.DiscoveryNodes;
        transportService.registerRequestHandler(
                        return TransportResponse.Empty.INSTANCE;
                    logger.debug("failed to send response on commit", e);
    }
                    }
import org.opensearch.transport.TransportRequestOptions;
                    throw new IncompatibleClusterStateVersionException("have no local cluster state");
                listener.onFailure(e);
                try {
        this.remoteClusterStateService = remoteClusterStateService;
            fullClusterStateReceivedCount.get(),
                        manifest.getStateVersion(),
    }
                        request.bytes().length()
                    throw new OpenSearchException("failed to serialize cluster state for publishing to node {}", e, node);
                    }
            boolean retryWithFullClusterStateOnFailure,
import org.opensearch.Version;
                lastSeenClusterState.set(clusterState);
    }
                        // will send a diff
        private final Map<Version, BytesReference> serializedStates = new HashMap<>();
                    @Override
            final PublishRequest publishRequest = currentPublishRequestToSelf.get();
import org.opensearch.cluster.node.DiscoveryNode;
        );
            ThreadPool.Names.GENERIC,
        lastSeenClusterState.set(publishRequest.getAcceptedState());
                    @Override
            PUBLISH_STATE_ACTION_NAME,
                        listener.onFailure(e);
        this.handlePublishRequest = handlePublishRequest;
                    true
        } catch (Exception e) {
        return handlePublishRequest.apply(new PublishRequest(incomingState));
                    logger.debug("received diff for but don't have any local cluster state - requesting full state");
                );
                    } else {
                    public void handleResponse(PublishWithJoinResponse response) {
                    } catch (IncompatibleClusterStateVersionException e) {
import org.opensearch.core.transport.TransportResponse;
                        return ThreadPool.Names.GENERIC;
}
    private PublishWithJoinResponse handleIncomingPublishRequest(BytesTransportRequest request) throws IOException {
                        listener.onResponse(publishWithJoinResponse);
                        "Downloading diff cluster state for term {}, version {}, previousUUID {}, current UUID {}",
                logger.debug(
        void buildDiffAndSerializeStates() {
/*
    // -> no need to put a timeout on the options here, because we want the response to eventually be received
                    lastSeenClusterState.compareAndSet(lastSeen, incomingState);
                }
                new TransportResponseHandler<TransportResponse.Empty>() {
        if (transportService.getLocalNode().equals(incomingState.nodes().getClusterManagerNode())) {
            COMMIT_STATE_ACTION_NAME,
        public void sendApplyCommit(
                    stateRequestOptions,
import java.util.concurrent.atomic.AtomicReference;
            );
        });
                    publishRequest,
import org.opensearch.cluster.coordination.PersistedStateRegistry.PersistedStateType;
                    public void handleException(TransportException exp) {
        };
                // if publishing to self, use original request instead (see currentPublishRequestToSelf for explanation)
        // if the state is coming from the current node, use original request instead (see currentPublishRequestToSelf for explanation)
                + " of version ["
                    PUBLISH_REMOTE_STATE_ACTION_NAME,
        );
            if (applyFullState) {
        logger.trace(
                );
                    @Override
                    logger.debug(() -> new ParameterizedMessage("failed to send remote cluster state to {}", destination), exp);
                };
            if (in.readBoolean()) {
                )
        try {
                destination,
    void setLastSeenClusterState(ClusterState clusterState) {
 * ownership. Elasticsearch licenses this file to you under
        return publicationContext;
        @Override
import java.util.HashMap;
                }
    PublishWithJoinResponse handleIncomingRemotePublishRequest(RemotePublishRequest request) throws IOException, IllegalStateException {
    public static final String PUBLISH_REMOTE_STATE_ACTION_NAME = "internal:cluster/coordination/publish_remote_state";
    private final AtomicBoolean allNodesRemotePublicationEnabled = new AtomicBoolean();
            clusterState.writeTo(stream);
                    discoveryNodes.getLocalNode(),
            } else {
                        listener.onFailure(exp);
                        e
                    } catch (Exception e) {
import org.opensearch.cluster.IncompatibleClusterStateVersionException;
            );
                try {
            if (allNodesRemotePublicationEnabled.get() == true) {
 *
    private final Function<PublishRequest, PublishWithJoinResponse> handlePublishRequest;
    private final AtomicLong fullClusterStateReceivedCount = new AtomicLong();
                    }
                        manifest.getStateVersion(),
    }
        transportService.registerRequestHandler(
                logger.warn(() -> new ParameterizedMessage("error sending cluster state to {}", destination), e);
                        return ThreadPool.Names.GENERIC;
import org.opensearch.transport.TransportResponseHandler;
                            serializedDiffs.put(node.getVersion(), serializedDiff);
            }
                        sendFullClusterState(destination, listener);
                    manifest,
 * this file be licensed under the Apache-2.0 license or a
            assert bytes != null : "failed to find serialized diff for node "
                remoteClusterStateService.diffIncomingPublicationFailed();
            compatibleClusterStateDiffReceivedCount.get()
import org.apache.logging.log4j.LogManager;
     *
            if (bytes == null) {
        public void sendClusterState(final DiscoveryNode destination, final ActionListener<PublishWithJoinResponse> listener) {
 *
                    PublishWithJoinResponse>() {
    private PublishWithJoinResponse acceptRemoteStateOnLocalNode(RemotePublishRequest remotePublishRequest) {
            throw new IllegalStateException("publication to self failed for " + remotePublishRequest);
                }
            (request, channel, task) -> channel.sendResponse(handleIncomingRemotePublishRequest(request))
                    }
                responseActionListener = listener;
package org.opensearch.cluster.coordination;
        // therefore serializing it) if the diff-based publication fails.
                };
                        return new PublishWithJoinResponse(in);
        return publishWithJoinResponse;
        .withType(TransportRequestOptions.Type.STATE)
        this.namedWriteableRegistry = namedWriteableRegistry;
        if (manifest != null) {
                    remotePublishRequest,
        }
                };
        final PublishRequest publishRequest = currentPublishRequestToSelf.get();
        ClusterChangedEvent clusterChangedEvent,
    void setCurrentPublishRequestToSelf(PublishRequest publishRequest) {
                    serializedStates.put(destination.getVersion(), bytes);
            if (manifest == null) {
                final String manifestFileName = ((RemotePersistedState) persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE))
                // (which fails anyhow because of higher current term)
 *
        .build();
import org.apache.logging.log4j.Logger;
                    throw e;
                        listener.onResponse(response);
    public PublishClusterStateStats stats() {
     * serializing, and compressing the state can be done once and the results shared across publish requests. The
                logger.trace("sending cluster state diff for version [{}] to [{}]", newState.version(), destination);
            if (lastSeen == null) {
                        manifest.getDiffManifest().getFromStateUUID(),
 * license agreements. See the NOTICE file distributed with
                            diff = ClusterState.readDiffFrom(input, lastSeen.nodes().getLocalNode());
                        manifest.getStateUUID()
                    listener.onFailure(e);
                }
            }
    // package private for testing
        // straight away. This isn't watertight since we send diffs on a best-effort basis and may fall back to sending a full state (and
                        listener.onResponse(response);
        TriConsumer<ApplyCommitRequest, Consumer<ClusterState>, ActionListener<Void>> handleApplyCommit,
            final ActionListener<PublishWithJoinResponse> responseActionListener;
                                serializedDiff.length()
        return new PublishClusterStateStats(
            }
                    logger.warn("unexpected error while deserializing an incoming cluster state", e);
        );
            // if a node is non-remote then created local publication context
                final TransportResponseHandler<PublishWithJoinResponse> responseHandler = new TransportResponseHandler<
                } catch (IOException e) {
                    @Override
                        }
                    @Override
                sendClusterStateDiff(destination, listener);
                listener.onFailure(e);
                    )
                    }
            throw e;
            DiscoveryNode destination,
                    destination,
                    public PublishWithJoinResponse read(StreamInput in) throws IOException {
                    channel.sendResponse(e);
            }
        }
                                newState.version(),
        RemoteClusterStateService remoteClusterStateService
                }
/*
                assert previousRequest == null || previousRequest.getAcceptedState().term() < publishRequest.getAcceptedState().term();
    }
        private void sendFullClusterState(DiscoveryNode destination, ActionListener<PublishWithJoinResponse> listener) {
                    () -> new ParameterizedMessage(
                    public String executor() {
 * The OpenSearch Contributors require contributions made to
        // Build the serializations we expect to need now, early in the process, so that an error during serialization fails the publication
                        logger.debug(() -> new ParameterizedMessage("failed to send cluster state to {}", destination), exp);
                        manifest.getStateUUID()
                    public void onFailure(Exception e) {
                    logger.debug("failed to send response on commit", e);
    public PublicationContext newPublicationContext(
            ActionListener<PublishWithJoinResponse> listener
                transportService.sendRequest(
    private static BytesReference serializeFullClusterState(ClusterState clusterState, Version nodeVersion) throws IOException {
                () -> new ParameterizedMessage(
                    newState.getClusterName().value(),
                    logger.debug(
            nodeVersion,
                    e.addSuppressed(ie);
                        try (StreamInput input = in) {
            transportService.sendRequest(
import java.util.concurrent.atomic.AtomicBoolean;
                        incomingState.stateUUID(),
            DiscoveryNode destination,
                final PublishRequest previousRequest = currentPublishRequestToSelf.getAndSet(publishRequest);
            }
                    @Override
 * software distributed under the License is distributed on an
            false,
            false,
        PublicationContext(ClusterChangedEvent clusterChangedEvent, PersistedStateRegistry persistedStateRegistry) {
                    .getLastUploadedManifestFile();
                            final BytesReference serializedDiff = serializeDiffClusterState(diff, node.getVersion());
                    );
                logger.debug(() -> "Last cluster state not compatible with the diff");
import org.opensearch.cluster.ClusterChangedEvent;
                    public void handleResponse(TransportResponse.Empty response) {
            }
        public void sendPublishRequest(
            stream.writeBoolean(true);
                    }
                    return;
                        "Downloading full cluster state for term {}, version {}, stateUUID {}",
            ActionListener<PublishWithJoinResponse> listener
                responseActionListener = new ActionListener<PublishWithJoinResponse>() {
                        if (serializedDiffs.containsKey(node.getVersion()) == false) {
                try (StreamInput input = in) {
                logger.trace("sending full cluster state version [{}] to [{}]", newState.version(), destination);
                    } else {
            sendClusterState(destination, bytes, false, listener);
            }
     */
            false,
    public PublicationTransportHandler(
                            logger.trace(
        transportService.registerRequestHandler(
 * You may obtain a copy of the License at
                    incompatibleClusterStateDiffReceivedCount.incrementAndGet();
            ClusterState incomingState;
                } catch (Exception e) {
    }
                ClusterState clusterState = remoteClusterStateService.getClusterStateUsingDiff(
    // and not log an error if it arrives after the timeout
                final Consumer<TransportException> transportExceptionHandler = exp -> {
    public static final String COMMIT_STATE_ACTION_NAME = "internal:cluster/coordination/commit_state";
            if (publishRequest == null || publishRequest.getAcceptedState().stateUUID().equals(incomingState.stateUUID()) == false) {
                    @Override
                final RemotePublishRequest remotePublishRequest = new RemotePublishRequest(
                };
                    manifestFileName
 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
            "serialized full cluster state version [{}] for node version [{}] with size [{}]",
        }
                logger.debug(() -> "Diff cannot be applied as there is no last cluster state");
                    public void handleResponse(PublishWithJoinResponse response) {
 * Transport handler for publication
                    if (retryWithFullClusterStateOnFailure && exp.unwrapCause() instanceof IncompatibleClusterStateVersionException) {
import java.util.function.Consumer;
                        incomingState.version(),
                    }
        return CompressedStreamUtils.createCompressedStream(nodeVersion, stream -> {
            }
                    public void handleException(TransportException exp) {
import org.opensearch.transport.TransportException;
                    @Override
            } else {
            || publishRequest.getAcceptedState().version() != remotePublishRequest.version) {
        }
    // because it's mostly just debugging info that would unnecessarily blow up CS updates (I think there was one in
 * Licensed to Elasticsearch under one or more contributor
                    public void onResponse(PublishWithJoinResponse publishWithJoinResponse) {
                final Consumer<TransportException> transportExceptionHandler = exp -> {
        RemotePublicationContext(ClusterChangedEvent clusterChangedEvent, PersistedStateRegistry persistedStateRegistry) {
                    }
                    try {
    private ActionListener<Void> transportCommitCallback(TransportChannel channel) {
     * @opensearch.internal
    private final NamedWriteableRegistry namedWriteableRegistry;
                logger.debug(() -> "There is no diff in the manifest");
                        logger.debug("resending full cluster state to node {} reason {}", destination, exp.getDetailedMessage());
                fullClusterStateReceivedCount.incrementAndGet();
                    if (sendFullVersion || previousState.nodes().nodeExists(node) == false) {
                applyCommitRequest,
        NamedWriteableRegistry namedWriteableRegistry,
 * GitHub history for details.
            (request, channel, task) -> channel.sendResponse(handleIncomingPublishRequest(request))
    }
                ClusterState clusterState = remoteClusterStateService.getClusterStateForManifest(
        );
                        incompatibleClusterStateDiffReceivedCount.incrementAndGet();
                    @Override
                return response;
                lastSeenClusterState.compareAndSet(lastSeen, clusterState);
                    @Override
        lastSeenClusterState.set(clusterState);
            final BytesReference bytes = serializedDiffs.get(destination.getVersion());
            serializedState.length()
            Diff<ClusterState> diff = null;
        return new ActionListener<Void>() {
 * KIND, either express or implied.  See the License for the
            clusterState.version(),
            ClusterMetadataManifest manifest = remoteClusterStateService.getClusterMetadataManifestByFileName(
                        return ThreadPool.Names.GENERIC;
                    remotePublishRequest
                final TransportResponseHandler<PublishWithJoinResponse> responseHandler = new TransportResponseHandler<>() {
            }
                        }
                    @Override
                        () -> new ParameterizedMessage("failed to serialize cluster state before publishing it to node {}", destination),
                if (validateRemotePublicationConfiguredOnAllNodes(clusterChangedEvent.state().nodes()) == true) {
                final PublishWithJoinResponse response = acceptState(clusterState, manifest);
            }
                        final Diff<ClusterState> diff;
            ThreadPool.Names.GENERIC,
                        return new PublishWithJoinResponse(in);
     * {@code PublicationContext} implements this sharing.
            } catch (Exception e) {
public class PublicationTransportHandler {
 */
                    public String executor() {
            ActionListener<TransportResponse.Empty> listener
                } catch (IOException ie) {
 *
            if (transportService.getLocalNode().equals(request.getSourceNode())) {
     * An extension of {@code PublicationContext} to support remote cluster state publication
                            );
                    public PublishWithJoinResponse read(StreamInput in) throws IOException {
    }
                    return response;
                throw new IllegalStateException("Publication failed as manifest was not found for " + request);
                }
            } catch (Exception e) {
        final BytesReference serializedState = CompressedStreamUtils.createCompressedStream(nodeVersion, stream -> {
                try {
    /**
                    bytes = serializeFullClusterState(newState, destination.getVersion());
 */
        private void sendClusterState(
        this.transportService = transportService;
                    @Override
        return serializedState;
    // package private for testing
                    public void handleException(TransportException exp) {
                    newState.metadata().clusterUUID(),
     *
            for (DiscoveryNode node : discoveryNodes) {
     * @opensearch.internal
    // snapshot code).
                    }
        }
    }
    private final RemoteClusterStateService remoteClusterStateService;
                    }
                logger.debug("received full cluster state version [{}] with size [{}]", incomingState.version(), request.bytes().length());
        PersistedStateRegistry persistedStateRegistry
                    "Publication failure for current publish request : {} and remote publish request: {}",
                    channel.sendResponse(TransportResponse.Empty.INSTANCE);
            BytesReference bytes,
 * under the License.
                    logger.warn(
                return handlePublishRequest.apply(publishRequest);
    private final AtomicReference<ClusterState> lastSeenClusterState = new AtomicReference<>();
                } else {
        this.lastSeenClusterState.set(clusterState);
                        manifest.getClusterTerm(),
                    }
        }
                remoteClusterStateService.fullIncomingPublicationFailed();
            sendClusterState(destination, responseActionListener);
                        incomingState = diff.apply(lastSeen); // might throw IncompatibleClusterStateVersionException
 */
                    }
                    allNodesRemotePublicationEnabled.set(true);
import org.opensearch.common.TriConsumer;
                final ClusterState lastSeen = lastSeenClusterState.get();
 * not use this file except in compliance with the License.
                    incomingState = ClusterState.readFrom(input, transportService.getLocalNode());
        ) {
            logger.debug(
    }
                return response;
    }
     * Publishing a cluster state typically involves sending the same cluster state (or diff) to every node, so the work of diffing,
            BytesTransportRequest::new,
                        listener.onFailure(exp);
                    );
        boolean isRemotePublicationEnabled,
    private final AtomicLong compatibleClusterStateDiffReceivedCount = new AtomicLong();
        TransportService transportService,
            } else {
            if (node.isRemoteStatePublicationEnabled() == false) {
                return response;
    }
                logger.info(
        }
                    }
            } else {
            stream.writeBoolean(false);
                    compatibleClusterStateDiffReceivedCount.incrementAndGet();
    }
                return false;
    private final TransportRequestOptions stateRequestOptions = TransportRequestOptions.builder()
        private void sendClusterStateDiff(DiscoveryNode destination, ActionListener<PublishWithJoinResponse> listener) {
                // we might override an in-flight publication to self in case where we failed as cluster-manager and
                                "serialized cluster state diff for version [{}] in for node version [{}] with size [{}]",
 * specific language governing permissions and limitations
 *     http://www.apache.org/licenses/LICENSE-2.0
            PublishRequest publishRequest,
                        // Close stream early to release resources used by the de-compression as early as possible
                throw new IllegalStateException("publication to self failed for " + publishRequest);
            }
        }
import org.apache.logging.log4j.message.ParameterizedMessage;
            RemotePublishRequest::new,
                final PublishWithJoinResponse response = acceptState(incomingState, null);
        }
            false,
                    newState.term(),
            return handlePublishRequest.apply(new RemoteStatePublishRequest(incomingState, manifest));
                    final PublishWithJoinResponse response = acceptState(incomingState, null);
            if (allNodesRemotePublicationEnabled.get() == false) {
                    }
     */
                } catch (Exception e) {
        ) {
    // TODO: look into these and check how to get rid of them
    /**
                );
                        throw e;
/**
                        "received diff cluster state version [{}] with uuid [{}], diff size [{}]",
            } else {
                    request.getClusterName(),
                fullClusterStateReceivedCount.incrementAndGet();
        for (DiscoveryNode node : discoveryNodes.getNodes().values()) {
                        transportExceptionHandler.accept(exp);
 * SPDX-License-Identifier: Apache-2.0
            super(clusterChangedEvent, persistedStateRegistry);
/*
        PublishWithJoinResponse publishWithJoinResponse = handlePublishRequest.apply(publishRequest);
        private final Map<Version, BytesReference> serializedDiffs = new HashMap<>();
                    }
    // package private for testing
                    responseHandler
                        }
                    newState.getVersion(),
            try {
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.cluster.ClusterState;
                    public TransportResponse.Empty read(StreamInput in) {
                            serializedStates.put(node.getVersion(), serializeFullClusterState(newState, node.getVersion()));
    public class RemotePublicationContext extends PublicationContext {
                    public String executor() {
            || publishRequest.getAcceptedState().coordinationMetadata().term() != remotePublishRequest.term
                compatibleClusterStateDiffReceivedCount.incrementAndGet();
        final PublicationContext publicationContext = new PublicationContext(clusterChangedEvent, persistedStateRegistry);
            discoveryNodes = clusterChangedEvent.state().nodes();
                applyFullState = true;
import org.opensearch.gateway.remote.RemoteClusterStateService;
            diff.writeTo(stream);
            ApplyCommitRequest applyCommitRequest,
        protected final ClusterState previousState;
import java.util.Map;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                        manifest.getClusterTerm(),
import org.opensearch.transport.TransportService;
                + destination
            }
                        currentPublishRequestToSelf.compareAndSet(publishRequest, null); // only clean-up our mess
    // don't want to be replicated because it's not usable on another node (e.g. UnassignedInfo.unassignedTimeNanos) or
import java.io.IOException;
                    @Override
    private void updateLastSeen(final ClusterState clusterState) {
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            false,
                }
import java.util.function.Function;
                        transportExceptionHandler.accept(exp);
                request.getClusterUUID(),
    private final AtomicLong incompatibleClusterStateDiffReceivedCount = new AtomicLong();
            // TODO Make cluster state download non-blocking: https://github.com/opensearch-project/OpenSearch/issues/14102
        publicationContext.buildDiffAndSerializeStates();
