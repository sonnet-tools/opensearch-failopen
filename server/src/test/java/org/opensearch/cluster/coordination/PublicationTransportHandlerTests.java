            () -> handler.handleIncomingRemotePublishRequest(remotePublishRequest)
        assertNotNull(e.getCause());
 * KIND, either express or implied.  See the License for the
        Function<PublishRequest, PublishWithJoinResponse> handlePublishRequest = p -> expectedPublishResponse;
            @Override
import org.opensearch.cluster.coordination.PublicationTransportHandler.RemotePublicationContext;
        return ClusterState.builder(ClusterState.EMPTY_STATE).version(version).metadata(newMetadata).nodes(nodes).build();
        PersistedStateStats remoteDiffDownloadStats = new PersistedStateStats("dummy_stats");
        doAnswer((i) -> {
            VERSION,
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            () -> handler.handleIncomingRemotePublishRequest(remotePublishRequest)
import org.opensearch.OpenSearchException;
        assertEquals(1, remoteClusterStateService.getDiffDownloadStats().getExtendedFields().get(INCOMING_PUBLICATION_FAILED_COUNT).get());
        );
        }).when(remoteClusterStateService).fullIncomingPublicationFailed();
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(remoteNode1).add(remoteNode2).localNodeId(remoteNode1.getId()).build();
    ) {
 * license agreements. See the NOTICE file distributed with
 */
        ClusterChangedEvent event = new ClusterChangedEvent(
                REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY,
            CLUSTER_UUID,
                };
            CLUSTER_NAME,
import org.opensearch.core.common.io.stream.StreamOutput;
        RemotePublishRequest remotePublishRequest = new RemotePublishRequest(
        assertNotNull(publicationContext2);
        RemoteClusterStateService remoteClusterStateService = mock(RemoteClusterStateService.class);
        RemotePublishRequest remotePublishRequest = new RemotePublishRequest(
                        fail("this diff shouldn't be applied");
            Version.CURRENT
            DiscoveryNodes.builder().add(localNode).add(otherNode).localNodeId(localNode.getId()).build(),
        ClusterState clusterState = buildClusterState(TERM, 11L);
                REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY,
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfiguration;
/*
            buildClusterState(TERM, VERSION)
        };
        Function<PublishRequest, PublishWithJoinResponse> handlePublishRequest = p -> expectedPublishResponse;
        RemotePublishRequest remotePublishRequest = new RemotePublishRequest(
import java.util.Collections;
    private ClusterState buildClusterStateWithRemoteNodes(long term, long version) {
 * SPDX-License-Identifier: Apache-2.0
        );
            TERM,
        // Remote publication disabled
        PublishWithJoinResponse expectedPublishResponse = new PublishWithJoinResponse(new PublishResponse(TERM, VERSION), Optional.empty());
        CoordinationMetadata.Builder coordMetadataBuilder = CoordinationMetadata.builder().term(term);
            secondNode,
 * not use this file except in compliance with the License.
            MANIFEST_FILE
        final PublicationTransportHandler handler = getPublicationTransportHandler(handlePublishRequest, remoteClusterStateService);
            ),
                "remote_state_repo",
        ).build();
        Function<PublishRequest, PublishWithJoinResponse> handlePublishRequest = p -> expectedPublishResponse;
            IllegalStateException.class,
        final PublicationTransportHandler handler = getPublicationTransportHandler(handlePublishRequest, remoteClusterStateService);
public class PublicationTransportHandlerTests extends OpenSearchTestCase {
        );
        PublishWithJoinResponse expectedPublishResponse = new PublishWithJoinResponse(new PublishResponse(TERM, VERSION), Optional.empty());
            IllegalStateException.class,
    private DiscoveryNode localNode;
        handler.setLastSeenClusterState(clusterState);
import java.util.Optional;
    public void setup() {
        verify(remoteClusterStateService, times(0)).fullIncomingPublicationFailed();
 * software distributed under the License is distributed on an
            "remoteNode",
import static org.hamcrest.Matchers.instanceOf;
        handler.setCurrentPublishRequestToSelf(publishRequest);
        RemotePublishRequest remotePublishRequest = new RemotePublishRequest(
        ClusterChangedEvent event1 = new ClusterChangedEvent(
            CLUSTER_UUID,
            remoteClusterStateService
            "remoteNode2",
            Version.CURRENT
            VERSION,
                REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY,
        assertThat(e.getMessage(), containsString("Publication failed as manifest was not found for"));
    private static final String LOCAL_NODE_ID = "localNode";
        PublicationContext publicationContext = handler.newPublicationContext(event1, false, new PersistedStateRegistry());
import org.opensearch.cluster.ClusterState;
            "source1",
        assertThat(e.getMessage(), containsString("publication to self failed"));
 * the Apache License, Version 2.0 (the "License"); you may
    private ClusterState buildClusterStateWithMixedNodes(long term, long version) {
        verifyNoMoreInteractions(remoteClusterStateService);
        handler.setCurrentPublishRequestToSelf(publishRequest);
        OpenSearchException e = expectThrows(
        assertThrows(NullPointerException.class, () -> handler.handleIncomingRemotePublishRequest(remotePublishRequest));
import org.opensearch.gateway.remote.ClusterMetadataManifest;
            public void onFailure(Exception e) {}
        IllegalStateException e = expectThrows(
import org.junit.Before;
import org.opensearch.cluster.metadata.Metadata;
        RemoteClusterStateService remoteClusterStateService = mock(RemoteClusterStateService.class);
            VERSION,
            NoopTracer.INSTANCE
            handlePublishRequest,
import org.opensearch.common.settings.Settings;
            remoteFullDownloadStats.getExtendedFields().put(INCOMING_PUBLICATION_FAILED_COUNT, new AtomicLong(1));
            public void onResponse(PublishWithJoinResponse publishWithJoinResponse) {}
        PublishRequest publishRequest = new PublishRequest(clusterState);
        );
import org.opensearch.gateway.GatewayMetaState.RemotePersistedState;
            buildClusterState(TERM, VERSION + 1),
        handler.setCurrentPublishRequestToSelf(publishRequest);
import static org.mockito.Mockito.mock;
        PublishWithJoinResponse expectedPublishResponse = new PublishWithJoinResponse(new PublishResponse(TERM, VERSION), Optional.empty());
    private static final long VERSION = 5;
    }
        assertThat(capturedRequests1.length, equalTo(1));
import static org.mockito.Mockito.doAnswer;
        Function<PublishRequest, PublishWithJoinResponse> handlePublishRequest = p -> expectedPublishResponse;
 * compatible open source license.
        );
        final PublicationTransportHandler handler = getPublicationTransportHandler(handlePublishRequest, remoteClusterStateService);
            CLUSTER_NAME,
            CLUSTER_UUID,
import java.util.concurrent.atomic.AtomicLong;
        return ClusterState.builder(ClusterState.EMPTY_STATE).version(version).metadata(newMetadata).nodes(nodes).build();
import java.util.Map;
        PublicationContext publicationContext3 = handler.newPublicationContext(event, true, persistedStateRegistry);
            VotingConfiguration.EMPTY_CONFIG,
        doAnswer((i) -> {
        RemotePersistedState remotePersistedState = mock(RemotePersistedState.class);
        deterministicTaskQueue = new DeterministicTaskQueue(
import org.opensearch.gateway.remote.RemoteDownloadStats;
 * under the License.
        verify(remoteClusterStateService, times(1)).diffIncomingPublicationFailed();
            CLUSTER_UUID,
        PublishRequest publishRequest = new PublishRequest(clusterState);
        );
        CoordinationMetadata.Builder coordMetadataBuilder = CoordinationMetadata.builder().term(term);
        );
    }
        PublishWithJoinResponse expectedPublishResponse = new PublishWithJoinResponse(new PublishResponse(TERM, VERSION), Optional.empty());
        );
import org.opensearch.cluster.node.DiscoveryNodes;
            VERSION,
    }
        capturingTransport = new CapturingTransport();
    public void testHandleIncomingRemotePublishRequestWhenNoLastSeenState() throws IOException {
import org.opensearch.cluster.Diff;
        PersistedStateStats remoteFullDownloadStats = new RemoteDownloadStats("dummy_full_stats");
            Version.CURRENT
            @Override
        transportService.acceptIncomingRequests();
import org.opensearch.common.settings.ClusterSettings;
    private CapturingTransport capturingTransport;
        IllegalStateException e = expectThrows(
import org.opensearch.Version;
 * this file be licensed under the Apache-2.0 license or a
        Metadata newMetadata = Metadata.builder().coordinationMetadata(coordMetadataBuilder.build()).build();
            "source3",
package org.opensearch.cluster.coordination;
import org.opensearch.test.transport.CapturingTransport;
        assertThat(e.getMessage(), containsString("publication to self failed"));
        RemoteClusterStateService remoteClusterStateService = mock(RemoteClusterStateService.class);
            DiscoveryNodeRole.BUILT_IN_ROLES,
        return handler;
    public void testHandleIncomingRemotePublishRequestWhenManifestNotFound() throws IOException {
            @Override
import org.opensearch.cluster.node.DiscoveryNodeRole;
            VERSION,
        final ClusterState clusterState = CoordinationStateTests.clusterState(
    private ClusterState buildClusterState(long term, long version) {
        PublishRequest publishRequest = new PublishRequest(clusterState);
        );
        CoordinationMetadata.Builder coordMetadataBuilder = CoordinationMetadata.builder().term(term);
            CLUSTER_UUID,
            clusterSettings,
            MANIFEST_FILE
        ClusterState clusterState = buildClusterState(TERM, VERSION);
                    public void writeTo(StreamOutput out) throws IOException {
            0L
        final DiscoveryNode otherNode = new DiscoveryNode("otherNode", buildNewFakeTransportAddress(), Version.CURRENT);
            Map.of(
                "remote_state_repo",
        );
        RemotePublishRequest remotePublishRequest = new RemotePublishRequest(
            buildClusterStateWithRemoteNodes(TERM, VERSION + 1),
        when(remotePersistedState.getLastUploadedManifestFile()).thenReturn("/path/to/manifest");
        PublishWithJoinResponse expectedPublishResponse = new PublishWithJoinResponse(new PublishResponse(TERM, VERSION), Optional.empty());
    public void testHandleIncomingRemotePublishRequestWhenNoCurrentPublishRequest() {
import org.opensearch.cluster.node.DiscoveryNode;
        assertThat(publishWithJoinResponse, is(expectedPublishResponse));
        secondNode = new DiscoveryNode("secondNode", buildNewFakeTransportAddress(), Version.CURRENT);
    }
        IllegalStateException e = expectThrows(
import static org.mockito.ArgumentMatchers.any;
        RemoteClusterStateService remoteClusterStateService
                return new Diff<ClusterState>() {
import static org.hamcrest.Matchers.is;
        DiscoveryNode remoteNode2 = new DiscoveryNode(
        ClusterState clusterState = buildClusterState(TERM, VERSION);
            Map.of(
                "remote_routing_repo"
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 */
        RemoteClusterStateService remoteClusterStateService = mock(RemoteClusterStateService.class);
 *
        assertThat(publicationContext, not(instanceOf(RemotePublicationContext.class)));
    private static final String CLUSTER_UUID = "test-cluster-UUID";
        PublishRequest publishRequest = new PublishRequest(clusterState);
            DiscoveryNodeRole.BUILT_IN_ROLES,
                        return part;
            Settings.EMPTY,
        assertThat(publicationContext3, instanceOf(RemotePublicationContext.class));
        );
        final PublicationTransportHandler handler = new PublicationTransportHandler(
        // Remote publication enabled and all nodes are remote enabled
        publicationContext3.sendClusterState(discoveryNode, listener);
            TERM,
            localNode,
        final PublicationTransportHandler handler = getPublicationTransportHandler(handlePublishRequest, remoteClusterStateService);
        PublishRequest publishRequest = new PublishRequest(clusterState);
        // Remote publication enabled but some nodes are remote enabled and some remote disabled
            ),
import static org.hamcrest.Matchers.containsString;
        assertThat(e.getCause().getMessage(), containsString("Simulated failure of diff serialization"));
    private static final String MANIFEST_FILE = "path/to/manifest";
        Function<PublishRequest, PublishWithJoinResponse> handlePublishRequest = p -> expectedPublishResponse;
            public Diff<ClusterState> diff(ClusterState previousState) {
        doAnswer((i) -> {
        RemoteClusterStateService remoteClusterStateService = mock(RemoteClusterStateService.class);
import org.opensearch.cluster.coordination.PersistedStateRegistry.PersistedStateType;
            () -> handler.handleIncomingRemotePublishRequest(remotePublishRequest)
        transportService.start();
        assertEquals(1, remoteClusterStateService.getDiffDownloadStats().getExtendedFields().get(INCOMING_PUBLICATION_FAILED_COUNT).get());
            secondNode,
            VERSION,
            secondNode,
            CLUSTER_NAME,
        ClusterState clusterState = mock(ClusterState.class);
                    }
        when(remoteClusterStateService.getClusterMetadataManifestByFileName(CLUSTER_UUID, MANIFEST_FILE)).thenReturn(null);
        Metadata newMetadata = Metadata.builder().coordinationMetadata(coordMetadataBuilder.build()).build();
            OpenSearchException.class,
import org.opensearch.core.action.ActionListener;
            localNode,
        };
        }).when(remoteClusterStateService).diffIncomingPublicationFailed();
            CLUSTER_NAME,
        ClusterChangedEvent event2 = new ClusterChangedEvent(
        RemoteClusterStateService remoteClusterStateService = mock(RemoteClusterStateService.class);
    }
        ClusterState clusterState = buildClusterState(TERM, VERSION);
        persistedStateRegistry.addPersistedState(PersistedStateType.REMOTE, remotePersistedState);
        when(clusterState.stateUUID()).thenReturn("state-uuid");
    public void testHandleIncomingRemotePublishRequestWhenTermMismatch() {
        ClusterState clusterState = buildClusterState(6L, VERSION);
            MANIFEST_FILE
                    }
        verify(remoteClusterStateService, times(0)).fullIncomingPublicationFailed();
        return ClusterState.builder(ClusterState.EMPTY_STATE).version(version).metadata(newMetadata).nodes(nodes).build();
        ClusterState clusterState = buildClusterState(TERM, VERSION);
        RemotePublishRequest remotePublishRequest = new RemotePublishRequest(
        when(remoteClusterStateService.getClusterMetadataManifestByFileName(CLUSTER_UUID, MANIFEST_FILE)).thenReturn(manifest);
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        );
            transportService,
import static org.hamcrest.Matchers.equalTo;
            buildClusterState(TERM, VERSION)
        PersistedStateStats remoteDiffDownloadStats = new RemoteDownloadStats("dummy_diff_stats");
        );
            random()
 * ownership. Elasticsearch licenses this file to you under
        assertThat(publicationContext2, not(instanceOf(RemotePublicationContext.class)));
            Collections.emptySet(),
            VotingConfiguration.EMPTY_CONFIG,
    public void testDownloadRemotePersistedFullStateFailedStats() throws IOException {
        );
            buildNewFakeTransportAddress(),
            buildClusterStateWithRemoteNodes(TERM, VERSION + 1),
        ActionListener<PublishWithJoinResponse> listener = new ActionListener<>() {
            remoteDiffDownloadStats.getExtendedFields().put(INCOMING_PUBLICATION_FAILED_COUNT, new AtomicLong(1));
        verify(remoteClusterStateService, times(0)).fullIncomingPublicationFailed();
            buildClusterState(TERM, VERSION)
        handler.setCurrentPublishRequestToSelf(publishRequest);
 * this work for additional information regarding copyright
        PublishWithJoinResponse expectedPublishResponse = new PublishWithJoinResponse(new PublishResponse(TERM, VERSION), Optional.empty());
 *
                    public ClusterState apply(ClusterState part) {
 * specific language governing permissions and limitations
        when(remoteClusterStateService.getFullDownloadStats()).thenReturn(remoteFullDownloadStats);
    private DiscoveryNode secondNode;
import static org.mockito.Mockito.when;
        final PublicationTransportHandler handler = getPublicationTransportHandler(handlePublishRequest, remoteClusterStateService);
        RemotePublishRequest remotePublishRequest = new RemotePublishRequest(
        );
        );
                REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY,
    }
        when(remoteClusterStateService.getDiffDownloadStats()).thenReturn(remoteDiffDownloadStats);
            localNode,
        RemoteClusterStateService remoteClusterStateService = mock(RemoteClusterStateService.class);
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(localNode).add(secondNode).localNodeId(LOCAL_NODE_ID).build();
            CLUSTER_UUID,
                "remote_routing_repo"
    public void testDiffSerializationFailure() {
                    @Override
import static org.opensearch.gateway.remote.RemoteDownloadStats.INCOMING_PUBLICATION_FAILED_COUNT;
        transportService = capturingTransport.createTransportService(
    }
    public void testRemotePublicationContext() throws Exception {
        RemoteClusterStateService remoteClusterStateService = mock(RemoteClusterStateService.class);
            buildNewFakeTransportAddress(),
            buildNewFakeTransportAddress(),
        assertThat(e.getCause(), instanceOf(IOException.class));
import static org.hamcrest.Matchers.not;
import org.opensearch.gateway.remote.RemoteClusterStateService;
            new ClusterStateDiffManifest.Builder().fromStateUUID("state-uuid").build()
        RemoteClusterStateService remoteClusterStateService = mock(RemoteClusterStateService.class);
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
        }).when(remoteClusterStateService).diffIncomingPublicationFailed();
    private DeterministicTaskQueue deterministicTaskQueue;
            }
        final ClusterState unserializableClusterState = new ClusterState(clusterState.version(), clusterState.stateUUID(), clusterState) {
 * You may obtain a copy of the License at
        PublishWithJoinResponse expectedPublishResponse = new PublishWithJoinResponse(new PublishResponse(TERM, VERSION), Optional.empty());
            CLUSTER_NAME,
            return null;
        assertThrows(IllegalStateException.class, () -> handler.handleIncomingRemotePublishRequest(remotePublishRequest));
                        throw new IOException("Simulated failure of diff serialization");
import org.mockito.Mockito;
 * Modifications Copyright OpenSearch Contributors. See
            writableRegistry(),
            buildClusterState(TERM, VERSION)
            "source3",
        CapturedRequest[] capturedRequests1 = capturingTransport.getCapturedRequestsAndClear();
            CLUSTER_NAME,
            secondNode,
            TERM,
            1L,
import org.opensearch.cluster.ClusterChangedEvent;
    }
        ClusterMetadataManifest metadataManifest = new ClusterMetadataManifest.Builder().diffManifest(
            deterministicTaskQueue.getThreadPool(),
        Function<PublishRequest, PublishWithJoinResponse> handlePublishRequest = p -> expectedPublishResponse;
            TERM,
        Function<PublishRequest, PublishWithJoinResponse> handlePublishRequest = p -> expectedPublishResponse;
            MANIFEST_FILE
        verify(remoteClusterStateService, times(1)).diffIncomingPublicationFailed();
            ),
        );
        assertThat(capturedRequest1.request, instanceOf(RemotePublishRequest.class));
import static org.mockito.Mockito.verifyNoMoreInteractions;
        final PublicationTransportHandler handler = getPublicationTransportHandler(p -> null, null);
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY;
            localNode,
        clusterState = buildClusterState(TERM, VERSION);
 */
        assertThat(publishWithJoinResponse, is(expectedPublishResponse));
        PublishWithJoinResponse expectedPublishResponse = new PublishWithJoinResponse(new PublishResponse(TERM, VERSION), Optional.empty());
        when(remoteClusterStateService.getClusterStateForManifest(CLUSTER_NAME, manifest, LOCAL_NODE_ID, true)).thenReturn(
        Function<PublishRequest, PublishWithJoinResponse> handlePublishRequest,
        handler.setCurrentPublishRequestToSelf(publishRequest);
        handler.setCurrentPublishRequestToSelf(publishRequest);
            TERM,
        PublishWithJoinResponse expectedPublishResponse = new PublishWithJoinResponse(new PublishResponse(TERM, VERSION), Optional.empty());
    }
        DiscoveryNode discoveryNode = new DiscoveryNode("node1", buildNewFakeTransportAddress(), Version.CURRENT);
    public void testHandleIncomingRemotePublishRequestForLocalNode() throws IOException {
            TERM,
            (pu, uc, l) -> {},
 * Unless required by applicable law or agreed to in writing,
 * GitHub history for details.
        Function<PublishRequest, PublishWithJoinResponse> handlePublishRequest = p -> expectedPublishResponse;
                REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY,
        assertNotNull(publicationContext);
        );
    public void testHandleIncomingRemotePublishRequestWhenVersionMismatch() {
    private static final long TERM = 5;
    }
                REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY,
 *     http://www.apache.org/licenses/LICENSE-2.0
            return null;
        PublicationContext publicationContext3 = handler.newPublicationContext(event3, true, new PersistedStateRegistry());
            IllegalStateException.class,
        Metadata newMetadata = Metadata.builder().coordinationMetadata(coordMetadataBuilder.build()).build();
            "remoteNode1",
        IllegalStateException e = expectThrows(
                    @Override
        PublishRequest publishRequest = new PublishRequest(clusterState);
                "remote_state_repo",
            remoteDiffDownloadStats.getExtendedFields().put(INCOMING_PUBLICATION_FAILED_COUNT, new AtomicLong(1));
            buildClusterStateWithMixedNodes(TERM, VERSION + 1),
        PublishRequest publishRequest = new PublishRequest(clusterState);
        localNode = new DiscoveryNode(LOCAL_NODE_ID, buildNewFakeTransportAddress(), Version.CURRENT);
        PublishWithJoinResponse expectedPublishResponse = new PublishWithJoinResponse(new PublishResponse(TERM, VERSION), Optional.empty());
        Function<PublishRequest, PublishWithJoinResponse> handlePublishRequest = p -> expectedPublishResponse;
        );
    public void testNewPublicationContext() {
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY;
        when(remoteClusterStateService.getDiffDownloadStats()).thenReturn(remoteDiffDownloadStats);
import static org.mockito.Mockito.verify;
        );
    @Before
    }
            MANIFEST_FILE
            2L,
        );
    }
import static org.mockito.Mockito.times;
import org.opensearch.test.OpenSearchTestCase;
        Mockito.verify(remoteClusterStateService, times(1)).getClusterMetadataManifestByFileName(Mockito.any(), Mockito.any());
        );
        when(remoteClusterStateService.getClusterMetadataManifestByFileName(any(), any())).thenReturn(metadataManifest);
            IllegalStateException.class,
import java.util.function.Function;
import java.io.IOException;
        final PublicationTransportHandler handler = getPublicationTransportHandler(handlePublishRequest, remoteClusterStateService);
            TERM,
        when(clusterState.nodes()).thenReturn(mock(DiscoveryNodes.class));
            MANIFEST_FILE
}
        ClusterChangedEvent event3 = new ClusterChangedEvent(
            return null;
        final PublicationTransportHandler handler = getPublicationTransportHandler(handlePublishRequest, remoteClusterStateService);
import org.opensearch.node.Node;
    private TransportService transportService;
            CLUSTER_NAME,
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(localNode).add(remoteNode).localNodeId(LOCAL_NODE_ID).build();
        Mockito.verify(remoteClusterStateService, times(1)).getClusterMetadataManifestByFileName(Mockito.any(), Mockito.any());
 * Licensed to Elasticsearch under one or more contributor
        );
        CapturedRequest capturedRequest1 = capturedRequests1[0];
    public void testDownloadRemotePersistedDiffStateFailedStats() throws IOException {
import org.opensearch.gateway.remote.ClusterStateDiffManifest;
        PublishWithJoinResponse publishWithJoinResponse = handler.handleIncomingRemotePublishRequest(remotePublishRequest);
        );
        assertThat(e.getMessage(), containsString("publication to self failed"));
            buildClusterState(TERM, VERSION)
            CLUSTER_UUID,
    }
        verifyNoMoreInteractions(remoteClusterStateService);
        PublishWithJoinResponse publishWithJoinResponse = handler.handleIncomingRemotePublishRequest(remotePublishRequest);
 *
    }
        verify(remoteClusterStateService, times(1)).diffIncomingPublicationFailed();
import org.opensearch.transport.TransportService;
            VERSION,
        ClusterMetadataManifest manifest = ClusterMetadataManifest.builder().clusterTerm(TERM).stateVersion(VERSION).build();
            () -> handler.handleIncomingRemotePublishRequest(remotePublishRequest)
 * The OpenSearch Contributors require contributions made to
        assertEquals(0, remoteClusterStateService.getFullDownloadStats().getExtendedFields().get(INCOMING_PUBLICATION_FAILED_COUNT).get());
                "remote_routing_repo"
        Function<PublishRequest, PublishWithJoinResponse> handlePublishRequest = p -> expectedPublishResponse;
            CLUSTER_NAME,
        PublicationContext publicationContext2 = handler.newPublicationContext(event2, true, new PersistedStateRegistry());
            Map.of(
    }
        final PublicationTransportHandler handler = getPublicationTransportHandler(handlePublishRequest, remoteClusterStateService);
            x -> localNode,
    private PublicationTransportHandler getPublicationTransportHandler(
            MANIFEST_FILE
        DiscoveryNode remoteNode1 = new DiscoveryNode(
            Settings.builder().put(Node.NODE_NAME_SETTING.getKey(), "test").build(),
import org.opensearch.cluster.coordination.PublicationTransportHandler.PublicationContext;
        handler.setCurrentPublishRequestToSelf(publishRequest);
        RemoteClusterStateService remoteClusterStateService = mock(RemoteClusterStateService.class);
            () -> handler.newPublicationContext(new ClusterChangedEvent("test", unserializableClusterState, clusterState), false, null)
    }
        final PublicationTransportHandler handler = getPublicationTransportHandler(handlePublishRequest, remoteClusterStateService);
        Mockito.verifyNoInteractions(remoteClusterStateService);
/*
        PersistedStateRegistry persistedStateRegistry = new PersistedStateRegistry();
            CLUSTER_UUID,
        DiscoveryNode remoteNode = new DiscoveryNode(
import org.opensearch.test.transport.CapturingTransport.CapturedRequest;
    private static final String CLUSTER_NAME = "test-cluster";
            DiscoveryNodeRole.BUILT_IN_ROLES,
            MANIFEST_FILE
/*
        RemotePublishRequest remotePublishRequest = new RemotePublishRequest(
        );
            TERM,
            VERSION,
            "source2",
        final PublicationTransportHandler handler = getPublicationTransportHandler(handlePublishRequest, remoteClusterStateService);
        verifyNoMoreInteractions(remoteClusterStateService);
        assertNotNull(publicationContext3);
