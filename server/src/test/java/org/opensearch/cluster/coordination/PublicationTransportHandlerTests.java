            buildNewFakeTransportAddress(),  
        verifyNoMoreInteractions(remoteClusterStateService);
        verify(remoteClusterStateService, times(1)).diffIncomingPublicationFailed();
    }
import org.opensearch.test.OpenSearchTestCase;  
import org.opensearch.Version;
 * GitHub history for details.
        assertThrows(IllegalStateException.class, () -> handler.handleIncomingRemotePublishRequest(remotePublishRequest));
        return handler;
        assertThat(capturedRequest1.request, instanceOf(RemotePublishRequest.class));
        assertThat(e.getMessage(), containsString("publication to self failed"));
        );  
        RemoteClusterStateService remoteClusterStateService  
        RemoteClusterStateService remoteClusterStateService = mock(RemoteClusterStateService.class);
        IllegalStateException e = expectThrows(  
        ClusterMetadataManifest manifest = ClusterMetadataManifest.builder().clusterTerm(TERM).stateVersion(VERSION).build();
import org.opensearch.gateway.remote.RemoteClusterStateService;
import org.opensearch.gateway.GatewayMetaState.RemotePersistedState;
            TERM,
 * license agreements. See the NOTICE file distributed with
            "remoteNode",
        DiscoveryNode discoveryNode = new DiscoveryNode("node1", buildNewFakeTransportAddress(), Version.CURRENT);
        final PublicationTransportHandler handler = getPublicationTransportHandler(handlePublishRequest, remoteClusterStateService);
 * software distributed under the License is distributed on an
    }  
            1L,
/*  
    }  
    public void testNewPublicationContext() {
            public Diff<ClusterState> diff(ClusterState previousState) {
    private PublicationTransportHandler getPublicationTransportHandler(
    }
            CLUSTER_UUID,
        Function<PublishRequest, PublishWithJoinResponse> handlePublishRequest = p -> expectedPublishResponse;
 */  
        Mockito.verifyNoInteractions(remoteClusterStateService);
        );
                        fail("this diff shouldn't be applied");  
            0L  
            MANIFEST_FILE
        ActionListener<PublishWithJoinResponse> listener = new ActionListener<>() {
        );
        return ClusterState.builder(ClusterState.EMPTY_STATE).version(version).metadata(newMetadata).nodes(nodes).build();
        RemoteClusterStateService remoteClusterStateService = mock(RemoteClusterStateService.class);  
            buildClusterState(TERM, VERSION)
        handler.setCurrentPublishRequestToSelf(publishRequest);
            MANIFEST_FILE  
import org.opensearch.gateway.remote.ClusterMetadataManifest;  
    private static final String CLUSTER_UUID = "test-cluster-UUID";  
        RemoteClusterStateService remoteClusterStateService = mock(RemoteClusterStateService.class);
        assertThat(e.getMessage(), containsString("publication to self failed"));
        final PublicationTransportHandler handler = new PublicationTransportHandler(
 *     http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
        RemotePublishRequest remotePublishRequest = new RemotePublishRequest(
import java.io.IOException;  
import static org.mockito.Mockito.verify;  
            localNode,
            x -> localNode,
    private DiscoveryNode localNode;  
        PublishRequest publishRequest = new PublishRequest(clusterState);
            TERM,  
import static org.hamcrest.Matchers.equalTo;
import static org.opensearch.gateway.remote.RemoteDownloadStats.INCOMING_PUBLICATION_FAILED_COUNT;  
        RemoteClusterStateService remoteClusterStateService = mock(RemoteClusterStateService.class);  
            OpenSearchException.class,
            CLUSTER_NAME,
        );  
import static org.hamcrest.Matchers.not;
            MANIFEST_FILE  
            () -> handler.handleIncomingRemotePublishRequest(remotePublishRequest)
            IllegalStateException.class,
        );
    private CapturingTransport capturingTransport;  
        PublishWithJoinResponse expectedPublishResponse = new PublishWithJoinResponse(new PublishResponse(TERM, VERSION), Optional.empty());
        PublicationContext publicationContext3 = handler.newPublicationContext(event, true, persistedStateRegistry);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            localNode,
    private DeterministicTaskQueue deterministicTaskQueue;
            "source3",  
        doAnswer((i) -> {
    private ClusterState buildClusterStateWithMixedNodes(long term, long version) {  
import org.opensearch.test.transport.CapturingTransport.CapturedRequest;
        verify(remoteClusterStateService, times(0)).fullIncomingPublicationFailed();  
        CapturedRequest[] capturedRequests1 = capturingTransport.getCapturedRequestsAndClear();
import org.opensearch.cluster.node.DiscoveryNode;
                    @Override
import org.opensearch.cluster.coordination.PersistedStateRegistry.PersistedStateType;  
        PublicationContext publicationContext = handler.newPublicationContext(event1, false, new PersistedStateRegistry());
        handler.setLastSeenClusterState(clusterState);
            remoteFullDownloadStats.getExtendedFields().put(INCOMING_PUBLICATION_FAILED_COUNT, new AtomicLong(1));
 * this work for additional information regarding copyright
import org.junit.Before;
                REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY,
            @Override
            "remoteNode1",
                REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY,
        final PublicationTransportHandler handler = getPublicationTransportHandler(handlePublishRequest, remoteClusterStateService);
        );  
            Version.CURRENT
        PublishWithJoinResponse expectedPublishResponse = new PublishWithJoinResponse(new PublishResponse(TERM, VERSION), Optional.empty());  
        );
        DiscoveryNode remoteNode = new DiscoveryNode(  
        ClusterMetadataManifest metadataManifest = new ClusterMetadataManifest.Builder().diffManifest(
        // Remote publication enabled and all nodes are remote enabled
        RemotePublishRequest remotePublishRequest = new RemotePublishRequest(
import org.opensearch.cluster.node.DiscoveryNodeRole;
                "remote_routing_repo"
        transportService.acceptIncomingRequests();
import org.opensearch.cluster.coordination.PublicationTransportHandler.RemotePublicationContext;
            CLUSTER_UUID,  
        Mockito.verify(remoteClusterStateService, times(1)).getClusterMetadataManifestByFileName(Mockito.any(), Mockito.any());
        PublishRequest publishRequest = new PublishRequest(clusterState);
        CoordinationMetadata.Builder coordMetadataBuilder = CoordinationMetadata.builder().term(term);  
                    public void writeTo(StreamOutput out) throws IOException {
    }
        clusterState = buildClusterState(TERM, VERSION);  
        assertThat(e.getCause().getMessage(), containsString("Simulated failure of diff serialization"));  
            }  
import java.util.function.Function;
                    public ClusterState apply(ClusterState part) {
        assertNotNull(publicationContext);  
        );  
        handler.setCurrentPublishRequestToSelf(publishRequest);
            buildClusterStateWithMixedNodes(TERM, VERSION + 1),  
        return ClusterState.builder(ClusterState.EMPTY_STATE).version(version).metadata(newMetadata).nodes(nodes).build();  
            NoopTracer.INSTANCE
            VERSION,
 *
 *
            MANIFEST_FILE
import org.opensearch.cluster.ClusterChangedEvent;
            IllegalStateException.class,
        Function<PublishRequest, PublishWithJoinResponse> handlePublishRequest = p -> expectedPublishResponse;
            VERSION,
        persistedStateRegistry.addPersistedState(PersistedStateType.REMOTE, remotePersistedState);
                    }
            Map.of(
            writableRegistry(),
import java.util.Optional;  
    public void testRemotePublicationContext() throws Exception {  
    }
            buildClusterState(TERM, VERSION)
            DiscoveryNodes.builder().add(localNode).add(otherNode).localNodeId(localNode.getId()).build(),  
        when(clusterState.nodes()).thenReturn(mock(DiscoveryNodes.class));
            CLUSTER_NAME,
import static org.mockito.Mockito.mock;
            CLUSTER_UUID,  
 */
        PublishRequest publishRequest = new PublishRequest(clusterState);
        RemotePublishRequest remotePublishRequest = new RemotePublishRequest(
        RemotePublishRequest remotePublishRequest = new RemotePublishRequest(  
            CLUSTER_NAME,
        doAnswer((i) -> {
 * KIND, either express or implied.  See the License for the
    public void testHandleIncomingRemotePublishRequestWhenTermMismatch() {
        final PublicationTransportHandler handler = getPublicationTransportHandler(p -> null, null);  
 * The OpenSearch Contributors require contributions made to  
            MANIFEST_FILE
            localNode,
        Function<PublishRequest, PublishWithJoinResponse> handlePublishRequest = p -> expectedPublishResponse;
        verify(remoteClusterStateService, times(1)).diffIncomingPublicationFailed();  
        assertThat(publicationContext, not(instanceOf(RemotePublicationContext.class)));
        final PublicationTransportHandler handler = getPublicationTransportHandler(handlePublishRequest, remoteClusterStateService);
            return null;
    public void testHandleIncomingRemotePublishRequestWhenManifestNotFound() throws IOException {  
            CLUSTER_NAME,
        final PublicationTransportHandler handler = getPublicationTransportHandler(handlePublishRequest, remoteClusterStateService);  
            "source3",
        verifyNoMoreInteractions(remoteClusterStateService);
        );
        ClusterState clusterState = mock(ClusterState.class);  
            Version.CURRENT
 */
import org.mockito.Mockito;
        Metadata newMetadata = Metadata.builder().coordinationMetadata(coordMetadataBuilder.build()).build();  
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY;
import java.util.Collections;
            @Override
        RemotePublishRequest remotePublishRequest = new RemotePublishRequest(  
            VotingConfiguration.EMPTY_CONFIG,
import org.opensearch.telemetry.tracing.noop.NoopTracer;
import org.opensearch.cluster.coordination.PublicationTransportHandler.PublicationContext;
            IllegalStateException.class,
import org.opensearch.core.common.io.stream.StreamOutput;
        PublishWithJoinResponse publishWithJoinResponse = handler.handleIncomingRemotePublishRequest(remotePublishRequest);  
        when(remoteClusterStateService.getDiffDownloadStats()).thenReturn(remoteDiffDownloadStats);
            remoteDiffDownloadStats.getExtendedFields().put(INCOMING_PUBLICATION_FAILED_COUNT, new AtomicLong(1));
    }
        PersistedStateStats remoteDiffDownloadStats = new PersistedStateStats("dummy_stats");
        when(remoteClusterStateService.getClusterMetadataManifestByFileName(CLUSTER_UUID, MANIFEST_FILE)).thenReturn(null);
import static org.mockito.Mockito.when;
        assertEquals(1, remoteClusterStateService.getDiffDownloadStats().getExtendedFields().get(INCOMING_PUBLICATION_FAILED_COUNT).get());
        }).when(remoteClusterStateService).fullIncomingPublicationFailed();  
 * You may obtain a copy of the License at  
import org.opensearch.cluster.metadata.Metadata;  
        handler.setCurrentPublishRequestToSelf(publishRequest);
            TERM,
        when(remoteClusterStateService.getClusterMetadataManifestByFileName(CLUSTER_UUID, MANIFEST_FILE)).thenReturn(manifest);
            CLUSTER_UUID,
        );
    private static final String LOCAL_NODE_ID = "localNode";
            CLUSTER_UUID,  
        capturingTransport = new CapturingTransport();
            buildClusterStateWithRemoteNodes(TERM, VERSION + 1),
    }  
        );
        RemotePublishRequest remotePublishRequest = new RemotePublishRequest(
        Metadata newMetadata = Metadata.builder().coordinationMetadata(coordMetadataBuilder.build()).build();
            clusterSettings,
            VERSION,
        );  
        final PublicationTransportHandler handler = getPublicationTransportHandler(handlePublishRequest, remoteClusterStateService);  
            "source2",
 * Licensed to Elasticsearch under one or more contributor  
        CapturedRequest capturedRequest1 = capturedRequests1[0];  
import org.opensearch.transport.TransportService;  
        assertThat(e.getCause(), instanceOf(IOException.class));
            DiscoveryNodeRole.BUILT_IN_ROLES,  
            public void onResponse(PublishWithJoinResponse publishWithJoinResponse) {}  
import org.opensearch.gateway.remote.ClusterStateDiffManifest;
        final DiscoveryNode otherNode = new DiscoveryNode("otherNode", buildNewFakeTransportAddress(), Version.CURRENT);
                "remote_routing_repo"
        return ClusterState.builder(ClusterState.EMPTY_STATE).version(version).metadata(newMetadata).nodes(nodes).build();
            VERSION,
        );  
        handler.setCurrentPublishRequestToSelf(publishRequest);
        assertThat(e.getMessage(), containsString("Publication failed as manifest was not found for"));
        ClusterChangedEvent event3 = new ClusterChangedEvent(
            Settings.EMPTY,
            return null;
    private DiscoveryNode secondNode;
            secondNode,
        );
            Settings.builder().put(Node.NODE_NAME_SETTING.getKey(), "test").build(),
        handler.setCurrentPublishRequestToSelf(publishRequest);
 * under the License.  
            ),  
    }  
        Function<PublishRequest, PublishWithJoinResponse> handlePublishRequest = p -> expectedPublishResponse;
        );
 *  
            transportService,  
            () -> handler.newPublicationContext(new ClusterChangedEvent("test", unserializableClusterState, clusterState), false, null)
import static org.mockito.Mockito.times;
            return null;  
import static org.mockito.ArgumentMatchers.any;
            VERSION,  
        final PublicationTransportHandler handler = getPublicationTransportHandler(handlePublishRequest, remoteClusterStateService);  
        PublishWithJoinResponse expectedPublishResponse = new PublishWithJoinResponse(new PublishResponse(TERM, VERSION), Optional.empty());
import org.opensearch.gateway.remote.RemoteDownloadStats;  
 * this file be licensed under the Apache-2.0 license or a
        Function<PublishRequest, PublishWithJoinResponse> handlePublishRequest = p -> expectedPublishResponse;
            DiscoveryNodeRole.BUILT_IN_ROLES,
        verify(remoteClusterStateService, times(1)).diffIncomingPublicationFailed();  
    public void testHandleIncomingRemotePublishRequestWhenNoCurrentPublishRequest() {  
/*
            secondNode,  
                REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY,
    public void testHandleIncomingRemotePublishRequestForLocalNode() throws IOException {
        Function<PublishRequest, PublishWithJoinResponse> handlePublishRequest = p -> expectedPublishResponse;
        PublishWithJoinResponse expectedPublishResponse = new PublishWithJoinResponse(new PublishResponse(TERM, VERSION), Optional.empty());  
                "remote_state_repo",
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(localNode).add(remoteNode).localNodeId(LOCAL_NODE_ID).build();  
            () -> handler.handleIncomingRemotePublishRequest(remotePublishRequest)
import static org.mockito.Mockito.doAnswer;  
            buildClusterState(TERM, VERSION)
    private ClusterState buildClusterStateWithRemoteNodes(long term, long version) {
        verify(remoteClusterStateService, times(0)).fullIncomingPublicationFailed();
        when(remoteClusterStateService.getClusterStateForManifest(CLUSTER_NAME, manifest, LOCAL_NODE_ID, true)).thenReturn(  
            VotingConfiguration.EMPTY_CONFIG,
            buildClusterState(TERM, VERSION + 1),
            buildClusterState(TERM, VERSION)
        PublicationContext publicationContext2 = handler.newPublicationContext(event2, true, new PersistedStateRegistry());  
import java.util.Map;
        RemoteClusterStateService remoteClusterStateService = mock(RemoteClusterStateService.class);
        handler.setCurrentPublishRequestToSelf(publishRequest);
            remoteClusterStateService
        deterministicTaskQueue = new DeterministicTaskQueue(
        PublishWithJoinResponse expectedPublishResponse = new PublishWithJoinResponse(new PublishResponse(TERM, VERSION), Optional.empty());
 * the Apache License, Version 2.0 (the "License"); you may
            CLUSTER_NAME,  
            CLUSTER_NAME,
        );  
    private ClusterState buildClusterState(long term, long version) {
    public void testDiffSerializationFailure() {
                    }
            @Override
    private static final long VERSION = 5;
        verifyNoMoreInteractions(remoteClusterStateService);
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(localNode).add(secondNode).localNodeId(LOCAL_NODE_ID).build();
        final PublicationTransportHandler handler = getPublicationTransportHandler(handlePublishRequest, remoteClusterStateService);
 * not use this file except in compliance with the License.
        Function<PublishRequest, PublishWithJoinResponse> handlePublishRequest = p -> expectedPublishResponse;
        publicationContext3.sendClusterState(discoveryNode, listener);  
            IllegalStateException.class,
                return new Diff<ClusterState>() {  
            VERSION,
                REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY,
        ClusterChangedEvent event1 = new ClusterChangedEvent(  
        OpenSearchException e = expectThrows(  
}
        PublishWithJoinResponse expectedPublishResponse = new PublishWithJoinResponse(new PublishResponse(TERM, VERSION), Optional.empty());  
        RemoteClusterStateService remoteClusterStateService = mock(RemoteClusterStateService.class);
            CLUSTER_UUID,
        transportService.start();  
                "remote_routing_repo"
        RemoteClusterStateService remoteClusterStateService = mock(RemoteClusterStateService.class);
        assertThat(publicationContext2, not(instanceOf(RemotePublicationContext.class)));
        ClusterState clusterState = buildClusterState(TERM, VERSION);  
            TERM,  
            MANIFEST_FILE
        PublishWithJoinResponse expectedPublishResponse = new PublishWithJoinResponse(new PublishResponse(TERM, VERSION), Optional.empty());
public class PublicationTransportHandlerTests extends OpenSearchTestCase {
        handler.setCurrentPublishRequestToSelf(publishRequest);
        PersistedStateStats remoteDiffDownloadStats = new RemoteDownloadStats("dummy_diff_stats");
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,  
        PublishWithJoinResponse expectedPublishResponse = new PublishWithJoinResponse(new PublishResponse(TERM, VERSION), Optional.empty());
        );  
    }
        ClusterState clusterState = buildClusterState(TERM, VERSION);  
        ClusterState clusterState = buildClusterState(TERM, 11L);  
    }  
        PublicationContext publicationContext3 = handler.newPublicationContext(event3, true, new PersistedStateRegistry());
        );
    public void testDownloadRemotePersistedDiffStateFailedStats() throws IOException {  
        Mockito.verify(remoteClusterStateService, times(1)).getClusterMetadataManifestByFileName(Mockito.any(), Mockito.any());
        ClusterState clusterState = buildClusterState(6L, VERSION);  
        PublishWithJoinResponse expectedPublishResponse = new PublishWithJoinResponse(new PublishResponse(TERM, VERSION), Optional.empty());
        transportService = capturingTransport.createTransportService(  
            VERSION,
            TERM,  
            () -> handler.handleIncomingRemotePublishRequest(remotePublishRequest)
                "remote_state_repo",  
        when(remoteClusterStateService.getFullDownloadStats()).thenReturn(remoteFullDownloadStats);  
            secondNode,
                        throw new IOException("Simulated failure of diff serialization");  
        Function<PublishRequest, PublishWithJoinResponse> handlePublishRequest = p -> expectedPublishResponse;
        RemoteClusterStateService remoteClusterStateService = mock(RemoteClusterStateService.class);
            () -> handler.handleIncomingRemotePublishRequest(remotePublishRequest)
            CLUSTER_NAME,
        RemotePublishRequest remotePublishRequest = new RemotePublishRequest(
        assertEquals(1, remoteClusterStateService.getDiffDownloadStats().getExtendedFields().get(INCOMING_PUBLICATION_FAILED_COUNT).get());
        IllegalStateException e = expectThrows(  
            Collections.emptySet(),  
        RemoteClusterStateService remoteClusterStateService = mock(RemoteClusterStateService.class);  
    }
            localNode,
import org.opensearch.node.Node;
    }
            buildNewFakeTransportAddress(),
    public void testDownloadRemotePersistedFullStateFailedStats() throws IOException {
        PublishRequest publishRequest = new PublishRequest(clusterState);
        when(remoteClusterStateService.getClusterMetadataManifestByFileName(any(), any())).thenReturn(metadataManifest);
 * ownership. Elasticsearch licenses this file to you under  
        RemotePublishRequest remotePublishRequest = new RemotePublishRequest(
        IllegalStateException e = expectThrows(  
        Function<PublishRequest, PublishWithJoinResponse> handlePublishRequest = p -> expectedPublishResponse;  
        );
        );
        DiscoveryNode remoteNode2 = new DiscoveryNode(
        );
        assertNotNull(publicationContext3);
        ClusterChangedEvent event = new ClusterChangedEvent(
/*
    @Before
        verify(remoteClusterStateService, times(0)).fullIncomingPublicationFailed();
            ),  
        final ClusterState unserializableClusterState = new ClusterState(clusterState.version(), clusterState.stateUUID(), clusterState) {  
        }).when(remoteClusterStateService).diffIncomingPublicationFailed();
        CoordinationMetadata.Builder coordMetadataBuilder = CoordinationMetadata.builder().term(term);
        localNode = new DiscoveryNode(LOCAL_NODE_ID, buildNewFakeTransportAddress(), Version.CURRENT);  
            VERSION,  
                "remote_state_repo",  
import org.opensearch.common.settings.ClusterSettings;
        secondNode = new DiscoveryNode("secondNode", buildNewFakeTransportAddress(), Version.CURRENT);
import static org.hamcrest.Matchers.containsString;  
        Function<PublishRequest, PublishWithJoinResponse> handlePublishRequest = p -> expectedPublishResponse;
        PersistedStateRegistry persistedStateRegistry = new PersistedStateRegistry();
        // Remote publication enabled but some nodes are remote enabled and some remote disabled  
        assertThat(publishWithJoinResponse, is(expectedPublishResponse));
        assertThat(capturedRequests1.length, equalTo(1));
        PublishWithJoinResponse expectedPublishResponse = new PublishWithJoinResponse(new PublishResponse(TERM, VERSION), Optional.empty());
        PublishWithJoinResponse publishWithJoinResponse = handler.handleIncomingRemotePublishRequest(remotePublishRequest);  
            secondNode,
            "remoteNode2",
            buildClusterState(TERM, VERSION)  
        PublishRequest publishRequest = new PublishRequest(clusterState);
        final PublicationTransportHandler handler = getPublicationTransportHandler(handlePublishRequest, remoteClusterStateService);  
        assertThat(publishWithJoinResponse, is(expectedPublishResponse));
import java.util.concurrent.atomic.AtomicLong;
    private static final String MANIFEST_FILE = "path/to/manifest";
    }
    public void testHandleIncomingRemotePublishRequestWhenVersionMismatch() {
 * compatible open source license.
            Map.of(
            TERM,
        assertNotNull(e.getCause());
            Version.CURRENT
            TERM,  
            CLUSTER_UUID,  
import static org.hamcrest.Matchers.instanceOf;
import org.opensearch.cluster.ClusterState;  
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(remoteNode1).add(remoteNode2).localNodeId(remoteNode1.getId()).build();
 * Modifications Copyright OpenSearch Contributors. See  
                        return part;
        );
        assertNotNull(publicationContext2);
            random()  
        when(clusterState.stateUUID()).thenReturn("state-uuid");  
        assertThat(publicationContext3, instanceOf(RemotePublicationContext.class));  
import org.opensearch.test.transport.CapturingTransport;
package org.opensearch.cluster.coordination;
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        ClusterState clusterState = buildClusterState(TERM, VERSION);  
            MANIFEST_FILE
        );
    public void testHandleIncomingRemotePublishRequestWhenNoLastSeenState() throws IOException {
            buildClusterStateWithRemoteNodes(TERM, VERSION + 1),  
        final PublicationTransportHandler handler = getPublicationTransportHandler(handlePublishRequest, remoteClusterStateService);  
        PublishRequest publishRequest = new PublishRequest(clusterState);
        doAnswer((i) -> {  
        Metadata newMetadata = Metadata.builder().coordinationMetadata(coordMetadataBuilder.build()).build();
            2L,
    private TransportService transportService;
        IllegalStateException e = expectThrows(  
                REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY,
import org.opensearch.common.settings.Settings;
            buildNewFakeTransportAddress(),  
        when(remoteClusterStateService.getDiffDownloadStats()).thenReturn(remoteDiffDownloadStats);  
import static org.hamcrest.Matchers.is;  
        PersistedStateStats remoteFullDownloadStats = new RemoteDownloadStats("dummy_full_stats");
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY;
            CLUSTER_NAME,
            TERM,  
            ),
        };
        final PublicationTransportHandler handler = getPublicationTransportHandler(handlePublishRequest, remoteClusterStateService);  
            (pu, uc, l) -> {},  
        );  
    private static final String CLUSTER_NAME = "test-cluster";
            remoteDiffDownloadStats.getExtendedFields().put(INCOMING_PUBLICATION_FAILED_COUNT, new AtomicLong(1));  
            CLUSTER_UUID,  
            MANIFEST_FILE
        ClusterState clusterState = buildClusterState(TERM, VERSION);  
import org.opensearch.core.action.ActionListener;  
import static org.mockito.Mockito.verifyNoMoreInteractions;
        CoordinationMetadata.Builder coordMetadataBuilder = CoordinationMetadata.builder().term(term);
            new ClusterStateDiffManifest.Builder().fromStateUUID("state-uuid").build()  
                REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY,  
    public void setup() {  
            DiscoveryNodeRole.BUILT_IN_ROLES,
import org.opensearch.cluster.Diff;
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfiguration;
        DiscoveryNode remoteNode1 = new DiscoveryNode(
        ClusterChangedEvent event2 = new ClusterChangedEvent(
        when(remotePersistedState.getLastUploadedManifestFile()).thenReturn("/path/to/manifest");  
        };
                    @Override
                };
    private static final long TERM = 5;  
    }  
            public void onFailure(Exception e) {}  
    }
        RemoteClusterStateService remoteClusterStateService = mock(RemoteClusterStateService.class);  
        RemotePersistedState remotePersistedState = mock(RemotePersistedState.class);
        Function<PublishRequest, PublishWithJoinResponse> handlePublishRequest,
    ) {
        assertEquals(0, remoteClusterStateService.getFullDownloadStats().getExtendedFields().get(INCOMING_PUBLICATION_FAILED_COUNT).get());  
import org.opensearch.cluster.node.DiscoveryNodes;  
            deterministicTaskQueue.getThreadPool(),
        }).when(remoteClusterStateService).diffIncomingPublicationFailed();
            handlePublishRequest,
        assertThrows(NullPointerException.class, () -> handler.handleIncomingRemotePublishRequest(remotePublishRequest));
            Map.of(  
        PublishRequest publishRequest = new PublishRequest(clusterState);
import org.opensearch.OpenSearchException;  
            "source1",
        assertThat(e.getMessage(), containsString("publication to self failed"));
        );
        ).build();
        // Remote publication disabled
 * Unless required by applicable law or agreed to in writing,
        final ClusterState clusterState = CoordinationStateTests.clusterState(  
