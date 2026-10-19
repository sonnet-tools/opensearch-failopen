                return response;
            transportService.sendRequest(
                };
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
    // package private for testing  
            );
 *
                )
                    }
                    .getLastUploadedManifestFile();
                    throw new IncompatibleClusterStateVersionException("have no local cluster state");  
    private final AtomicLong incompatibleClusterStateDiffReceivedCount = new AtomicLong();
            // if a node is non-remote then created local publication context
import org.apache.logging.log4j.message.ParameterizedMessage;
                    public void handleException(TransportException exp) {
                } catch (IOException ie) {
                    public String executor() {  
                        }  
                applyFullState = true;
                    }  
            if (transportService.getLocalNode().equals(request.getSourceNode())) {
                );
        publicationContext.buildDiffAndSerializeStates();
        }
        logger.trace(
    }  
                    public void onResponse(PublishWithJoinResponse publishWithJoinResponse) {
            PUBLISH_STATE_ACTION_NAME,
                    @Override
                try (StreamInput input = in) {
                        e  
            throw e;
                return new RemotePublicationContext(clusterChangedEvent, persistedStateRegistry);
        ) {  
                );
                        "Downloading diff cluster state for term {}, version {}, previousUUID {}, current UUID {}",
            || publishRequest.getAcceptedState().coordinationMetadata().term() != remotePublishRequest.term  
                    "Publication failure for current publish request : {} and remote publish request: {}",
            public void onResponse(Void aVoid) {
                try {  
        for (DiscoveryNode node : discoveryNodes.getNodes().values()) {  
                    return response;
                        return new PublishWithJoinResponse(in);
                final PublishWithJoinResponse response = acceptState(clusterState, manifest);  
        return handlePublishRequest.apply(new PublishRequest(incomingState));  
                    @Override
            stream.writeBoolean(false);  
                return acceptRemoteStateOnLocalNode(request);  
                    }
                + destination.getVersion()
            PublishRequest publishRequest,
 * GitHub history for details.
                    logger.debug("failed to send response on commit", e);  
            assert transportService.getThreadPool().getThreadContext().isSystemContext();  
                    logger.debug(
            ClusterMetadataManifest manifest = remoteClusterStateService.getClusterMetadataManifestByFileName(  
                        manifest.getStateVersion(),
                    incomingState = ClusterState.readFrom(input, transportService.getLocalNode());  
            ActionListener<TransportResponse.Empty> listener
                    transportService.getLocalNode().getId(),
                    final PublishWithJoinResponse response = acceptState(incomingState, null);
            final BytesReference bytes = serializedDiffs.get(destination.getVersion());
import org.opensearch.gateway.remote.ClusterMetadataManifest;
            }  
    PublishWithJoinResponse handleIncomingRemotePublishRequest(RemotePublishRequest request) throws IOException, IllegalStateException {
            } catch (Exception e) {
                    @Override
                remoteClusterStateService.fullIncomingPublicationFailed();  
                // we might override an in-flight publication to self in case where we failed as cluster-manager and
            final ActionListener<PublishWithJoinResponse> responseActionListener;
        if (manifest != null) {  
                final PublishRequest previousRequest = currentPublishRequestToSelf.getAndSet(publishRequest);
            if (allNodesRemotePublicationEnabled.get() == true) {  
            incompatibleClusterStateDiffReceivedCount.get(),
    }
        }
            }
                final PublishWithJoinResponse response = acceptState(clusterState, manifest);
        final BytesReference serializedState = CompressedStreamUtils.createCompressedStream(nodeVersion, stream -> {  
                    newState.getVersion(),  
            );  
        }
                destination,
                fullClusterStateReceivedCount.incrementAndGet();
        }
            ApplyCommitRequest applyCommitRequest,  
                    );
        });
    }
                    newState.metadata().clusterUUID(),
                        logger.debug(() -> new ParameterizedMessage("failed to send cluster state to {}", destination), exp);
        NamedWriteableRegistry namedWriteableRegistry,
                logger.trace("sending full cluster state version [{}] to [{}]", newState.version(), destination);
    }
            false,
        private void sendClusterState(
                    () -> new ParameterizedMessage(  
    }
    public static final String PUBLISH_STATE_ACTION_NAME = "internal:cluster/coordination/publish_state";
                final TransportResponseHandler<PublishWithJoinResponse> responseHandler = new TransportResponseHandler<>() {  
            Diff<ClusterState> diff = null;
    private final Function<PublishRequest, PublishWithJoinResponse> handlePublishRequest;
            ThreadPool.Names.GENERIC,
                    public void handleException(TransportException exp) {
                    }
                        listener.onFailure(exp);  
            || publishRequest.getAcceptedState().version() != remotePublishRequest.version) {
                return handlePublishRequest.apply(publishRequest);  
            }
                        // will send a diff  
                );  
    // don't want to be replicated because it's not usable on another node (e.g. UnassignedInfo.unassignedTimeNanos) or
                        incomingState.version(),
    private void updateLastSeen(final ClusterState clusterState) {  
        // if the state is coming from the current node, use original request instead (see currentPublishRequestToSelf for explanation)  
 */  
        .withType(TransportRequestOptions.Type.STATE)
                final String manifestFileName = ((RemotePersistedState) persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE))
    }
        }
                    serializedStates.put(destination.getVersion(), bytes);
        );
            ThreadPool.Names.GENERIC,
    private static final Logger logger = LogManager.getLogger(PublicationTransportHandler.class);  
                        manifest.getStateUUID()
                    @Override  
                + "]";  
                    @Override  
import org.opensearch.OpenSearchException;  
            // TODO Make cluster state download non-blocking: https://github.com/opensearch-project/OpenSearch/issues/14102
                // if all nodes are remote then create remote publication context
                sendFullClusterState(destination, listener);
            PUBLISH_REMOTE_STATE_ACTION_NAME,
                    listener.onFailure(exp);
            assert publishRequest.getAcceptedState() == newState : "state got switched on us";
                compatibleClusterStateDiffReceivedCount.incrementAndGet();
    ) {  
import org.opensearch.cluster.node.DiscoveryNode;
                logger.debug(() -> "There is no diff in the manifest");  
                        manifest.getClusterTerm(),
    public class PublicationContext {  
            }  
                        transportExceptionHandler.accept(exp);
import org.apache.logging.log4j.Logger;
                    }
                }
                    @Override
            clusterState.writeTo(stream);
 * not use this file except in compliance with the License.
            if (manifest == null) {
            }  
import org.opensearch.threadpool.ThreadPool;  
            @Override
                    } else {
                                serializedDiff.length()
                    public PublishWithJoinResponse read(StreamInput in) throws IOException {
                        logger.debug("resending full cluster state to node {} reason {}", destination, exp.getDetailedMessage());
 *  
                    }
                    }
    private final TransportRequestOptions stateRequestOptions = TransportRequestOptions.builder()
            false,  
                    }
            if (allNodesRemotePublicationEnabled.get() == false) {
                }
                    }  
                try {  
     * @opensearch.internal
 */
            ClusterState incomingState;
    public static final String COMMIT_STATE_ACTION_NAME = "internal:cluster/coordination/commit_state";
            } else {
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
                    true
    private static BytesReference serializeFullClusterState(ClusterState clusterState, Version nodeVersion) throws IOException {
                final Consumer<TransportException> transportExceptionHandler = exp -> {
                    @Override
            public void onFailure(Exception e) {
        );
    private final AtomicLong compatibleClusterStateDiffReceivedCount = new AtomicLong();  
            if (bytes == null) {
     * Publishing a cluster state typically involves sending the same cluster state (or diff) to every node, so the work of diffing,  
        transportService.registerRequestHandler(  
    private PublishWithJoinResponse acceptRemoteStateOnLocalNode(RemotePublishRequest remotePublishRequest) {  
 * Modifications Copyright OpenSearch Contributors. See  
    ) {
            } else {
    private ActionListener<Void> transportCommitCallback(TransportChannel channel) {
    private final RemoteClusterStateService remoteClusterStateService;
    void setCurrentPublishRequestToSelf(PublishRequest publishRequest) {
        transportService.registerRequestHandler(  
            for (DiscoveryNode node : discoveryNodes) {
 * You may obtain a copy of the License at  
        }
    }
 * the Apache License, Version 2.0 (the "License"); you may
            sendFullVersion = previousState.getBlocks().disableStatePersistence();
/*
                logger.trace("sending cluster state diff for version [{}] to [{}]", newState.version(), destination);
        private void sendClusterStateDiff(DiscoveryNode destination, ActionListener<PublishWithJoinResponse> listener) {  
 * Unless required by applicable law or agreed to in writing,
                    lastSeenClusterState.compareAndSet(lastSeen, incomingState);  
                    logger.warn(
import org.opensearch.cluster.Diff;
 * this work for additional information regarding copyright
                    }
                    public TransportResponse.Empty read(StreamInput in) {  
                logger.warn(() -> new ParameterizedMessage("error sending cluster state to {}", destination), e);
     */
                        }
    private final AtomicReference<ClusterState> lastSeenClusterState = new AtomicReference<>();
            if (applyFullState) {
            stream.writeBoolean(true);
            assert transportService.getThreadPool().getThreadContext().isSystemContext();  
                        "received diff cluster state version [{}] with uuid [{}], diff size [{}]",  
                transportService.sendRequest(
    // snapshot code).  
     * {@code PublicationContext} implements this sharing.
                    responseHandler  
        } catch (Exception e) {
        this.handlePublishRequest = handlePublishRequest;  
            ApplyCommitRequest::new,
            (request, channel, task) -> channel.sendResponse(handleIncomingRemotePublishRequest(request))  
        }
                responseActionListener = listener;
                );
            false,  
                    @Override
                );  
                logger.debug(() -> "Last cluster state not compatible with the diff");  
                    PUBLISH_REMOTE_STATE_ACTION_NAME,  
        protected final ClusterState previousState;
        );  
                    manifest,
            ActionListener<PublishWithJoinResponse> listener
                    logger.warn("unexpected error while deserializing an incoming cluster state", e);
 * SPDX-License-Identifier: Apache-2.0
        private final Map<Version, BytesReference> serializedDiffs = new HashMap<>();
                    public void handleException(TransportException exp) {
import java.io.IOException;
                            logger.trace(
                    logger.debug(() -> new ParameterizedMessage("failed to send remote cluster state to {}", destination), exp);  
import java.util.function.Function;  
    // because it's mostly just debugging info that would unnecessarily blow up CS updates (I think there was one in
        try (StreamInput in = CompressedStreamUtils.decompressBytes(request, namedWriteableRegistry)) {
                }
                    listener.onFailure(e);
        return new PublishClusterStateStats(
                    @Override  
/*
                }
 * Licensed to Elasticsearch under one or more contributor  
        protected final boolean sendFullVersion;
            this.persistedStateRegistry = persistedStateRegistry;  
        }
                applyFullState = true;
package org.opensearch.cluster.coordination;
            BytesReference bytes = serializedStates.get(destination.getVersion());
        PublishWithJoinResponse publishWithJoinResponse = handlePublishRequest.apply(publishRequest);
import java.util.concurrent.atomic.AtomicBoolean;
                        listener.onFailure(e);
import org.opensearch.gateway.GatewayMetaState.RemotePersistedState;  
    private final NamedWriteableRegistry namedWriteableRegistry;
import org.opensearch.transport.BytesTransportRequest;
            previousState = clusterChangedEvent.previousState();
        }
                            final BytesReference serializedDiff = serializeDiffClusterState(diff, node.getVersion());
                    public void onFailure(Exception e) {
                    if (retryWithFullClusterStateOnFailure && exp.unwrapCause() instanceof IncompatibleClusterStateVersionException) {
            if (node.isRemoteStatePublicationEnabled() == false) {
 * compatible open source license.
            } else {
                    public PublishWithJoinResponse read(StreamInput in) throws IOException {  
                    throw new OpenSearchException("failed to serialize cluster state for publishing to node {}", e, node);
                } catch (Exception e) {  
            newState = clusterChangedEvent.state();  
                    newState.getClusterName().value(),
                    allNodesRemotePublicationEnabled.set(true);  
        return new ActionListener<Void>() {
                            diff = ClusterState.readDiffFrom(input, lastSeen.nodes().getLocalNode());  
        }
                        listener.onResponse(publishWithJoinResponse);
        if (transportService.getLocalNode().equals(incomingState.nodes().getClusterManagerNode())) {
            DiscoveryNode destination,
import org.opensearch.cluster.node.DiscoveryNodes;
            }
                        listener.onFailure(exp);
            "serialized full cluster state version [{}] for node version [{}] with size [{}]",
                        incomingState.stateUUID(),
                    }  
    private final AtomicReference<PublishRequest> currentPublishRequestToSelf = new AtomicReference<>();
                    manifest,  
}  
        TransportService transportService,
                    channel.sendResponse(e);
            }
        public void sendApplyCommit(
                final BytesTransportRequest request = new BytesTransportRequest(bytes, destination.getVersion());
            final PublishRequest publishRequest = currentPublishRequestToSelf.get();
        }
                            );  
            }
                listener.onFailure(e);
import java.util.concurrent.atomic.AtomicLong;  
                throw new IllegalStateException("publication to self failed for " + publishRequest);
            } else if (manifest.getDiffManifest() == null) {
            BytesReference bytes,  
                        return new PublishWithJoinResponse(in);
import java.util.function.Consumer;
                    @Override
 * Transport handler for publication  
            DiscoveryNode destination,
            if (lastSeen == null) {
                try {  
    private static BytesReference serializeDiffClusterState(Diff<ClusterState> diff, Version nodeVersion) throws IOException {
    public PublishClusterStateStats stats() {
                lastSeenClusterState.set(incomingState);
 * The OpenSearch Contributors require contributions made to  
                };  
                        "Downloading full cluster state for term {}, version {}, stateUUID {}",
                applyFullState = true;
                    remotePublishRequest,
    public PublicationContext newPublicationContext(
            }  
            sendClusterState(destination, bytes, false, listener);  
                        manifest.getStateUUID()  
                    remotePublishRequest  
                        return ThreadPool.Names.GENERIC;
                // became cluster-manager again, and the new publication started before the previous one completed  
                    lastSeen,
                        listener.onResponse(response);
            } else {  
                            serializedDiffs.put(node.getVersion(), serializedDiff);  
            boolean retryWithFullClusterStateOnFailure,
            false,
 * software distributed under the License is distributed on an
        };
import org.opensearch.common.TriConsumer;  
            ActionListener<PublishWithJoinResponse> listener  
                                node.getVersion(),
                        incompatibleClusterStateDiffReceivedCount.incrementAndGet();
                        throw e;
 * specific language governing permissions and limitations
        this.remoteClusterStateService = remoteClusterStateService;
                        currentPublishRequestToSelf.compareAndSet(publishRequest, null); // only clean-up our mess  
                final TransportResponseHandler<PublishWithJoinResponse> responseHandler = new TransportResponseHandler<  
            try {
                ClusterState clusterState = remoteClusterStateService.getClusterStateUsingDiff(  
            } else if (manifest.getDiffManifest().getFromStateUUID().equals(lastSeen.stateUUID()) == false) {
                logger.info(
            }
        this.transportService = transportService;
        ClusterChangedEvent clusterChangedEvent,
            BytesTransportRequest::new,
                    @Override
                    return;  
                        }
            final ClusterState lastSeen = lastSeenClusterState.get();
import org.opensearch.Version;
            ThreadPool.Names.GENERIC,
                lastSeenClusterState.compareAndSet(lastSeen, clusterState);
                        currentPublishRequestToSelf.compareAndSet(publishRequest, null); // only clean-up our mess  
                sendClusterStateDiff(destination, listener);
                request.getManifestFile()
                responseActionListener = new ActionListener<PublishWithJoinResponse>() {  
        private void sendFullClusterState(DiscoveryNode destination, ActionListener<PublishWithJoinResponse> listener) {  
            nodeVersion,
                    )
    private boolean validateRemotePublicationConfiguredOnAllNodes(DiscoveryNodes discoveryNodes) {
        lastSeenClusterState.set(publishRequest.getAcceptedState());  
        Function<PublishRequest, PublishWithJoinResponse> handlePublishRequest,  
                    );
    // -> no need to put a timeout on the options here, because we want the response to eventually be received
                throw new IllegalStateException("Publication failed as manifest was not found for " + request);
        void buildDiffAndSerializeStates() {  
    public PublicationTransportHandler(  
    private final TransportService transportService;  
            RemotePublishRequest::new,
                    public void handleResponse(PublishWithJoinResponse response) {
    }  
            logger.trace("sending cluster state over transport to node: {}", destination.getName());
                    channel.sendResponse(TransportResponse.Empty.INSTANCE);
import org.opensearch.cluster.ClusterChangedEvent;
        }  
                }
                    stateRequestOptions,
            false,
        RemotePublicationContext(ClusterChangedEvent clusterChangedEvent, PersistedStateRegistry persistedStateRegistry) {
        return true;  
            super(clusterChangedEvent, persistedStateRegistry);  
     * @opensearch.internal
                    e.addSuppressed(ie);  
                        // Close stream early to release resources used by the de-compression as early as possible
                        return ThreadPool.Names.GENERIC;
                    transportService.getLocalNode().getId()  
            }  
     */
            @Override
                        }
                    () -> new ParameterizedMessage(
                // Close early to release resources used by the de-compression as early as possible
import org.opensearch.cluster.IncompatibleClusterStateVersionException;
            if (sendFullVersion || previousState.nodes().nodeExists(destination) == false) {  
        lastSeenClusterState.set(clusterState);
            if (destination.equals(discoveryNodes.getLocalNode())) {
                    newState.term(),
        boolean isRemotePublicationEnabled,  
        protected final ClusterState newState;  
                };
                        manifest.getStateVersion(),  
import org.opensearch.transport.TransportRequestOptions;
        // therefore serializing it) if the diff-based publication fails.  
    }
                    }
            diff.writeTo(stream);
                    request.getClusterName(),
                // if publishing to self, use original request instead (see currentPublishRequestToSelf for explanation)  
    public class RemotePublicationContext extends PublicationContext {  
            serializedState.length()
        RemoteClusterStateService remoteClusterStateService
                        final Diff<ClusterState> diff;  
import org.opensearch.gateway.remote.RemoteClusterStateService;
                // (which fails anyhow because of higher current term)
                    try {
/*  
                    }  
                        throw e;
                        sendFullClusterState(destination, listener);  
                    }
        }
                new TransportResponseHandler<TransportResponse.Empty>() {  
        });  
                listener.onFailure(e);
                    }  
                if (validateRemotePublicationConfiguredOnAllNodes(clusterChangedEvent.state().nodes()) == true) {
                    } else {
import org.opensearch.transport.TransportResponseHandler;
    // and not log an error if it arrives after the timeout  
        .build();  
import org.opensearch.core.action.ActionListener;
        boolean applyFullState = false;  
                    destination,
import org.opensearch.cluster.coordination.PersistedStateRegistry.PersistedStateType;  
                    public void handleResponse(TransportResponse.Empty response) {
        final PublishRequest publishRequest = currentPublishRequestToSelf.get();
        try {
/**
                if (lastSeen == null) {  
                logger.debug("sending remote cluster state to node: {}", destination.getName());  
import org.opensearch.cluster.ClusterState;  
        );  
            sendClusterState(destination, bytes, true, listener);
public class PublicationTransportHandler {
                        listener.onResponse(response);  
                    }
        TriConsumer<ApplyCommitRequest, Consumer<ClusterState>, ActionListener<Void>> handleApplyCommit,
        private final Map<Version, BytesReference> serializedStates = new HashMap<>();  
     *  
            if (applyFullState == true) {
    public static final String PUBLISH_REMOTE_STATE_ACTION_NAME = "internal:cluster/coordination/publish_remote_state";  
            throw new IllegalStateException("publication to self failed for " + remotePublishRequest);  
 *
    }
        protected final DiscoveryNodes discoveryNodes;
            return handlePublishRequest.apply(new RemoteStatePublishRequest(incomingState, manifest));
import org.opensearch.transport.TransportChannel;
            }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
            (request, channel, task) -> channel.sendResponse(handleIncomingPublishRequest(request))  
            false,  
            );
import java.util.Map;
    private final AtomicBoolean allNodesRemotePublicationEnabled = new AtomicBoolean();
                request.getClusterUUID(),
                ClusterState clusterState = remoteClusterStateService.getClusterStateForManifest(
                }  
    /**
 */
 * @opensearch.internal
                } catch (IOException e) {
        PublicationContext(ClusterChangedEvent clusterChangedEvent, PersistedStateRegistry persistedStateRegistry) {
    /**
        }
                    @Override
                return response;  
                            serializedStates.put(node.getVersion(), serializeFullClusterState(newState, node.getVersion()));  
                applyCommitRequest,
        }
                    logger.debug("received diff for but don't have any local cluster state - requesting full state");
 */  
        public void sendClusterState(DiscoveryNode destination, ActionListener<PublishWithJoinResponse> listener) {
                logger.debug(  
                        () -> new ParameterizedMessage("failed to serialize cluster state before publishing it to node {}", destination),
     *  
    // package private for testing
                            diff = newState.diff(previousState);
import org.opensearch.core.common.bytes.BytesReference;
                } catch (Exception e) {
import org.opensearch.core.transport.TransportResponse;
                + " of version ["
import org.opensearch.transport.TransportService;  
    }  
        return CompressedStreamUtils.createCompressedStream(nodeVersion, stream -> {
    }  
    }
import java.util.concurrent.atomic.AtomicReference;
        }
        }
    private PublishWithJoinResponse acceptState(ClusterState incomingState, ClusterMetadataManifest manifest) {
                COMMIT_STATE_ACTION_NAME,  
        this.currentPublishRequestToSelf.set(publishRequest);  
            discoveryNodes = clusterChangedEvent.state().nodes();
            COMMIT_STATE_ACTION_NAME,
            assert bytes != null : "failed to find serialized diff for node "
            if (in.readBoolean()) {  
                        request.bytes().length()  
            }  
                    } catch (Exception e) {  
    // the cluster-manager needs the original non-serialized state as the cluster state contains some volatile information that we  
                stateRequestOptions,
                    logger.debug("failed to send response on commit", e);
                + destination  
        transportService.registerRequestHandler(  
                    @Override
                        logger.warn("unexpected error while deserializing an incoming cluster state", e);
                try {  
        PersistedStateRegistry persistedStateRegistry
                        listener.onResponse(response);  
                        return TransportResponse.Empty.INSTANCE;
        return publishWithJoinResponse;
                final RemotePublishRequest remotePublishRequest = new RemotePublishRequest(  
            try {
    void setLastSeenClusterState(ClusterState clusterState) {
                };
import org.opensearch.transport.TransportException;  
                } catch (IOException e) {  
     * serializing, and compressing the state can be done once and the results shared across publish requests. The
     * An extension of {@code PublicationContext} to support remote cluster state publication
    // package private for testing
                logger.debug(() -> "Diff cannot be applied as there is no last cluster state");  
        final PublicationContext publicationContext = new PublicationContext(clusterChangedEvent, persistedStateRegistry);
                    incompatibleClusterStateDiffReceivedCount.incrementAndGet();
                        transportExceptionHandler.accept(exp);  
                lastSeenClusterState.set(clusterState);  
                        try (StreamInput input = in) {
    }
        // straight away. This isn't watertight since we send diffs on a best-effort basis and may fall back to sending a full state (and
    private final AtomicLong fullClusterStateReceivedCount = new AtomicLong();
                return response;
                                "serialized cluster state diff for version [{}] in for node version [{}] with size [{}]",
                        incomingState = diff.apply(lastSeen); // might throw IncompatibleClusterStateVersionException
 *
                }
                    if (sendFullVersion || previousState.nodes().nodeExists(node) == false) {
                logger.debug("received full cluster state version [{}] with size [{}]", incomingState.version(), request.bytes().length());  
            } else {
                    PublishWithJoinResponse>() {
                                newState.version(),  
            if (publishRequest == null || publishRequest.getAcceptedState().stateUUID().equals(incomingState.stateUUID()) == false) {  
            (request, channel, task) -> handleApplyCommit.apply(request, this::updateLastSeen, transportCommitCallback(channel))  
                );
                logger.warn(() -> new ParameterizedMessage("error sending remote cluster state to {}", destination), e);  
                    throw e;  
            }
            compatibleClusterStateDiffReceivedCount.get()
                    public void handleResponse(PublishWithJoinResponse response) {  
        public void sendClusterState(final DiscoveryNode destination, final ActionListener<PublishWithJoinResponse> listener) {
            clusterState.version(),  
        return serializedState;
                final Consumer<TransportException> transportExceptionHandler = exp -> {  
 * license agreements. See the NOTICE file distributed with
        if (publishRequest == null
                };  
            DiscoveryNode destination,
            } else {
                }
        ) {
                    publishRequest,
            fullClusterStateReceivedCount.get(),  
                    compatibleClusterStateDiffReceivedCount.incrementAndGet();
                final PublishWithJoinResponse response = acceptState(incomingState, null);
 * KIND, either express or implied.  See the License for the
                        manifest.getClusterTerm(),  
import java.util.HashMap;  
        @Override  
        return publicationContext;
            }  
            }
                    )
                () -> new ParameterizedMessage(  
                } else {
                        if (diff == null) {
        ) {
 * this file be licensed under the Apache-2.0 license or a
                assert previousRequest == null || previousRequest.getAcceptedState().term() < publishRequest.getAcceptedState().term();
    // TODO: look into these and check how to get rid of them
                transportService.sendRequest(destination, PUBLISH_STATE_ACTION_NAME, request, stateRequestOptions, responseHandler);
                return false;  
    }
        if (isRemotePublicationEnabled == true) {  
                    manifestFileName  
            }  
                fullClusterStateReceivedCount.incrementAndGet();
                    public String executor() {
        // Build the serializations we expect to need now, early in the process, so that an error during serialization fails the publication
        protected final PersistedStateRegistry persistedStateRegistry;
                final ClusterState lastSeen = lastSeenClusterState.get();
            logger.debug(
        );
            } catch (Exception e) {  
import org.apache.logging.log4j.LogManager;  
                        if (serializedDiffs.containsKey(node.getVersion()) == false) {
                    } catch (IncompatibleClusterStateVersionException e) {  
                    }
                        manifest.getDiffManifest().getFromStateUUID(),
        public void sendPublishRequest(  
                remoteClusterStateService.diffIncomingPublicationFailed();
        this.namedWriteableRegistry = namedWriteableRegistry;
                        return ThreadPool.Names.GENERIC;
                    bytes = serializeFullClusterState(newState, destination.getVersion());
        this.lastSeenClusterState.set(clusterState);
                    public String executor() {  
                        if (serializedStates.containsKey(node.getVersion()) == false) {
                    @Override  
    private PublishWithJoinResponse handleIncomingPublishRequest(BytesTransportRequest request) throws IOException {  
                    discoveryNodes.getLocalNode(),
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.common.io.stream.StreamInput;
            }  
            sendClusterState(destination, responseActionListener);
