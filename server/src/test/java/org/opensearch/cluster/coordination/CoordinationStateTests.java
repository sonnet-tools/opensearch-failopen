        );
            .clusterUUID(state2.metadata().clusterUUID())
        StartJoinRequest startJoinRequest2 = new StartJoinRequest(node2, randomLongBetween(startJoinRequest1.getTerm() + 1, 10));
    }
            containsString("does not match current version")
            0L,
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
        assertTrue(voteCollection.isEmpty());
        assertFalse(voteCollection.isEmpty());
        assertTrue(cs1.handleJoin(join));
    public void testJoinDoesNotWinElectionWhenOnlyLastAcceptedConfigQuorum() {
        PublishResponse publishResponse = cs1.handlePublishRequest(publishRequest);
        cs1 = createCoordinationState(psr1, node1, Settings.EMPTY);
            initialConfig,
        assertThat(v1.getLastAcceptedTerm(), equalTo(initialStateNode1.term()));
        coordinationState.handlePublishRequest(new PublishRequest(publishRequest.getAcceptedState()));
        Join v1 = cs1.handleStartJoin(startJoinRequest1);
        cs1.setInitialState(state1);
        assertFalse(voteCollection.containsVoteFor(node2));
        PublishResponse publishResponse = cs1.handlePublishRequest(publishRequest);
        cs1.handlePublishRequest(new PublishRequest(state2));
            containsString("only allow reconfiguration if joinVotes have quorum for new config")
            0L,
            containsString("does not match current term")
            startJoinRequest1.getTerm(),
        assertTrue(cs1.electionWon());
        Join v1 = cs1.handleStartJoin(startJoinRequest1);
            new RemotePersistedState(remoteClusterStateService, state1.metadata().clusterUUID())
    public void testHandleCommitWithBadLastAcceptedTerm() {
            : randomLongBetween(0, startJoinRequest1.getTerm() - 1);
            7L
        );
        assumeTrue("test only works with assertions enabled", Assertions.ENABLED);
        assertTrue(cs1.handleJoin(v1));
            DiscoveryNodes.builder()
        final PersistedStateRegistry persistedStateRegistrySpy = spy(persistedStateRegistry);
        };
        DiscoveryNodes discoveryNodes,
            42L
        );
            42L
        assertTrue(cs1.handleJoin(v1));
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node1, randomLongBetween(1, 5));
        cs2 = createCoordinationState(createPersistedStateRegistry(initialStateNode2), node2, Settings.EMPTY);
        DiscoveryNode localNode,
        VotingConfiguration configNode1 = VotingConfiguration.of(node1);
}
        final PersistedStateRegistry persistedStateRegistry = persistedStateRegistry();
            DiscoveryNodes.builder()
        assertThat(v1.getTargetNode(), equalTo(startJoinRequest1.getSourceNode()));
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
        Join v1 = cs1.handleStartJoin(startJoinRequest);
        assertTrue(voteCollection.isQuorum(VotingConfiguration.of(node1, node2)));
            initialConfig,
 * compatible open source license.
        VotingConfiguration newConfig = VotingConfiguration.of(node2);
    public void setupNodes() {
 * the Apache License, Version 2.0 (the "License"); you may
        VotingConfiguration newConfig = VotingConfiguration.of(node2);
        if (randomBoolean()) {
        cs1.handlePublishRequest(new PublishRequest(state2));
            2L,
                CoordinationStateRejectedException.class,
import org.opensearch.core.common.transport.TransportAddress;
        assertTrue(applyCommit.isPresent());
        );
    }
        assertTrue(cs1.handleJoin(v1));
            expectThrows(CoordinationStateRejectedException.class, () -> cs1.handleCommit(new ApplyCommitRequest(node1, term, 2L)))
        );
            2L,
        cs1.handlePublishRequest(new PublishRequest(state2));
        assertTrue(cs1.handleJoin(v2));
        coordinationState.handlePreCommit();
        VotingConfiguration configNode1 = VotingConfiguration.of(node1);
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
                .localNodeId(nodeWithPub.getId())
    public void testJoinWithHigherAcceptedTerm() {
        assertThat(
            remotePublicationSettings()
    }
        initialStateNode2 = clusterState(0L, 0L, node2, VotingConfiguration.EMPTY_CONFIG, VotingConfiguration.EMPTY_CONFIG, 42L);
    }
    }
    }
        Join v1 = cs1.handleStartJoin(startJoinRequest1);
            randomNonNegativeLong()
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
                CoordinationStateRejectedException.class,
        Join join = new Join(node2, node1, v1.getTerm(), randomLongBetween(0, state2.term()), randomLongBetween(0, state2.version()));
            containsString("not greater than current term")
        cs1.setInitialState(state1);
                .localNodeId(nodeWithPub.getId())
        assertEquals(manifest, persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE).getLastAcceptedManifest());
import org.opensearch.gateway.remote.ClusterMetadataManifest;
    }
        assertThat(
            assertTrue(cs1.electionWon());
        assertThat(cs1.getLastAcceptedState(), equalTo(state2));
        assertTrue(cs1.handleJoin(v1));
        cs1.handleClientValue(state2);
    public void testJoinWithWrongTarget() {
        assertTrue(coordinationState.handleJoin(v2));
        assertTrue(cs1.handleJoin(v1));
        Join v1 = cs1.handleStartJoin(startJoinRequest1);
            expectThrows(
        Join v1 = cs1.handleStartJoin(startJoinRequest1);
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
import static org.opensearch.gateway.remote.RemoteClusterStateService.REMOTE_PUBLICATION_SETTING_KEY;
    }
    private CoordinationState cs2;
                        )
            13L
            PersistedStateType.REMOTE,
    private PersistedState ps1;
import static org.mockito.Mockito.spy;
        assertTrue(cs1.handleJoin(v2));
            PersistedStateType.REMOTE,
 * GitHub history for details.
    public void testHandlePublishRequestWithTermHigherThanLastAcceptedTerm() {
        final PersistedStateRegistry persistedStateRegistry = persistedStateRegistry();
import java.io.IOException;
        final CoordinationState coordinationState = createCoordinationState(
        cs1.handlePublishRequest(new PublishRequest(state3));
        StartJoinRequest startJoinRequest2 = new StartJoinRequest(node2, randomLongBetween(startJoinRequest1.getTerm() + 1, 10));
                .build(),
            .stateUUID(randomAlphaOfLength(10))
                        .coordinationMetadata(CoordinationMetadata.builder(state1.coordinationMetadata()).term(newTerm).build())
        cs1.setInitialState(state1);
        cs1.handleStartJoin(startJoinRequest1);
            43L
        Join v1 = cs1.handleStartJoin(startJoinRequest1);
            new RemotePersistedState(remoteClusterStateService, state1.metadata().clusterUUID())
        assertTrue(voteCollection.containsVoteFor(node1));
                        .coordinationMetadata(CoordinationMetadata.builder(state1.coordinationMetadata()).term(newTerm).build())
            .codecVersion(1)
    ) {
        Join v2 = cs2.handleStartJoin(startJoinRequest1);
        Join v1 = cs1.handleStartJoin(startJoinRequest2);
        Join v1 = cs1.handleStartJoin(startJoinRequest1);
        Join v2 = coordinationState.handleStartJoin(startJoinRequest);
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
        DiscoveryNode localNode,
        }
        assertThat(
            )
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node2, randomLongBetween(1, 5));
        );
        assertNull(persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE).getLastAcceptedState());
    public static ClusterState clusterStateWithClusterManager(
    }
import org.opensearch.cluster.node.DiscoveryNode;
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
        coordinationState.handlePrePublish(clusterState2);
                .clusterManagerNodeId(clusterManagerNode.getId())
        node3 = createNode("node3");
        // check that another join does not mess with lastPublishedVersion
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node1, randomLongBetween(1, 5));
        ClusterState state3 = clusterState(startJoinRequest1.getTerm(), 3L, node1, initialConfig, newConfig1, 42L);
            ).getMessage(),
            : randomLongBetween(0, startJoinRequest1.getTerm() - 1);
            voteCollection.addVote(
                    .build()
        );
                () -> cs1.handleCommit(new ApplyCommitRequest(node1, startJoinRequest1.getTerm(), randomLongBetween(3, 10)))
            containsString("higher than current last accepted version")
            lastCommittedConfig,
        );
        assertTrue(coordinationState.electionWon());
        ClusterState state2 = clusterState(startJoinRequest1.getTerm(), randomLongBetween(2, 20), node1, initialConfig, initialConfig, 42L);
        assertEquals(cs1.getLastPublishedVersion(), 0L);
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node1, randomLongBetween(1, 5));
    public void testJoinWithSameAcceptedTermButHigherVersion() {
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node1, randomLongBetween(1, 5));
        });
            containsString("does not match current term")
        VotingConfiguration configNode2 = VotingConfiguration.of(node2);
        );
        );
        );
        assertThat(
        assertFalse(cs1.electionWon());
        assertNull(persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE).getLastAcceptedManifest());
            .opensearchVersion(Version.CURRENT)
            expectThrows(CoordinationStateRejectedException.class, () -> cs1.handleJoin(badJoin)).getMessage(),
        Settings settings
            assertTrue(cs1.electionWon());
            DiscoveryNodeRole.BUILT_IN_ROLES,
            initialConfig,
                                .term(term)
        assertTrue(cs1.electionWon());
            DiscoveryNodes.builder()
        final CoordinationState coordinationState = createCoordinationState(
            assertTrue(cs1.handleJoin(v1));
            persistedStateRegistry,
import org.opensearch.gateway.remote.RemoteClusterStateService;
        return clusterState(
        final CoordinationState coordinationState = createCoordinationState(
    }
        Settings settings = Settings.builder()
            expectThrows(CoordinationStateRejectedException.class, () -> cs1.handleClientValue(state2)).getMessage(),
            expectThrows(
        assertTrue(state1.getLastAcceptedConfiguration().hasQuorum(Collections.singleton(node1.getId())));
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
        assertEquals(cs1.getLastPublishedVersion(), cs1.getLastAcceptedVersion());
import org.opensearch.core.Assertions;
                )
        assertTrue(cs1.handleJoin(v1));
            PersistedStateType.REMOTE,
            randomFrom(node1, node2),
import org.mockito.ArgumentCaptor;
    }
        PublishRequest publishRequest = cs1.handleClientValue(state2);
            42L
            node1,
        Join v1 = cs1.handleStartJoin(startJoinRequest1);
        assertTrue(cs1.handleJoin(v3));
        ClusterState initialStateNode3 = clusterState(
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node1, randomLongBetween(1, 5));
        cs2.handlePublishRequest(new PublishRequest(state2));
        Optional<ApplyCommitRequest> applyCommit = cs1.handlePublishResponse(node2, publishResponse);
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node1, randomLongBetween(1, 5));
    public void testHandleCommitOnFollowerNodeWhenRemotePublicationEnabled() {
            containsString("lower or equal to current version")
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
    private DiscoveryNode node3;
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(randomFrom(node1, node2), randomLongBetween(1, 5));
            new RemoteClusterStateManifestInfo(manifest, "path/to/manifest")
            assertTrue(cs1.handleJoin(v1));
            .put("node.attr." + REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY, randomRepoName)
        Mockito.verify(persistedStateRegistrySpy, Mockito.times(0)).getPersistedState(PersistedStateType.REMOTE);
                .add(localNode)
        Join v2 = coordinationState.handleStartJoin(startJoinRequest);
        final RemoteClusterStateService remoteClusterStateService = Mockito.mock(RemoteClusterStateService.class);
        assertTrue(cs1.containsJoinVoteFor(node1));
        VotingConfiguration configNode2 = VotingConfiguration.of(node2);
        assertTrue(cs1.electionWon());
                .metadata(
            CoordinationState.VoteCollection voteCollection1 = new CoordinationState.VoteCollection();
            randomLongBetween(state2.term() + 1, 30),
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node2, randomLongBetween(1, 5));
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node1, randomLongBetween(1, 5));
        assertThat(
                Metadata.builder(clusterState.metadata())
                .add(node1)
            containsString("election not won")
                REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY,
            containsString("election not won")
            .stateVersion(state2.version())
        coordinationState.setInitialState(state1);
        coordinationState.handleStartJoin(startJoinRequest);
        cs1.handleStartJoin(startJoinRequest1);
import static org.mockito.ArgumentMatchers.any;
 */
        assertThat(clusterStateCaptor.getValue().metadata().indices(), equalTo(committedClusterState.metadata().indices()));
        coordinationState.setInitialState(state1);
                .clusterManagerNodeId(node1.getId())
        assertFalse(cs1.handleJoin(join));
/*
        assertThat(persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE).getLastAcceptedState(), equalTo(clusterState));
        when(remoteClusterStateService.writeFullMetadata(clusterState, previousClusterUUID)).thenReturn(
            containsString("higher than current last accepted term")
        final PersistedStateRegistry persistedStateRegistry = persistedStateRegistry();
    private ClusterState initialStateNode2;
                    Metadata.builder()
            ? randomLongBetween(startJoinRequest1.getTerm() + 1, 10)
        );
            containsString("does not match current term")
    public void testJoinWithSameLastAcceptedTermButLowerOrSameVersionWinsElection() {
            )
        Join v1 = cs1.handleStartJoin(startJoinRequest1);
        assertTrue(cs1.electionWon());
        cs3 = createCoordinationState(createPersistedStateRegistry(initialStateNode3), node3, Settings.EMPTY);
        verifyNoInteractions(spyRPS);
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node1, randomLongBetween(1, 5));
        VotingConfiguration newConfig = VotingConfiguration.of(node2);
        // cluster manager is node1 and node2 is a follower node
    private ClusterState initialStateNode1;
            nodeWithPub,
        );
        assertEquals(cs1.getLastPublishedVersion(), 0L);
        ClusterState state2 = clusterState(startJoinRequest1.getTerm(), 0L, node1, initialConfig, initialConfig, 42L);
    private static Settings remotePublicationSettings() {
        assertTrue(cs1.handleJoin(v2));
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
    // scenario when handling a publish request from a cluster-manager that we already received a newer state from
            address.getAddress(),
            expectThrows(CoordinationStateRejectedException.class, () -> cs1.setInitialState(state1)).getMessage(),
        assertTrue(cs1.handleJoin(v1));
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
 * SPDX-License-Identifier: Apache-2.0
        long term,
import org.opensearch.common.settings.Settings;
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
        verify(remoteClusterStateService, times(1)).markLastStateAsCommitted(clusterStateCaptor.capture(), any(), eq(false));
        ClusterState state2 = clusterState(startJoinRequest1.getTerm(), randomLongBetween(2, 10), node1, initialConfig, initialConfig, 42L);
            nodeWithPub,
        );
        assertFalse(voteCollection.isQuorum(VotingConfiguration.of(node3)));
            Version.CURRENT
        assertThat(
            initialConfig,
            node3,
            ClusterState.builder(state1)
        StartJoinRequest startJoinRequest = new StartJoinRequest(nodeWithPub, newTerm);
        cs1.handlePublishRequest(new PublishRequest(state2));
import org.opensearch.cluster.coordination.CoordinationState.PersistedState;
                            CoordinationMetadata.builder()
                REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY,
import org.opensearch.cluster.ClusterName;
            .opensearchVersion(Version.CURRENT)
                    Metadata.builder(state1.metadata())
        Join v1 = cs1.handleStartJoin(startJoinRequest1);
            equalTo(committedClusterState.coordinationMetadata().term())
            initialConfig,
        );
            randomFrom(node1, node2),
    }
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
            randomRepoName
        );
        assertTrue(cs1.handleJoin(v1));
            initialConfig,
        );
        return new DiscoveryNode(
    public void testJoinWithBadCurrentTerm() {
    }
        assertTrue(cs1.handleJoin(v1));
        StartJoinRequest startJoinRequest2 = new StartJoinRequest(
            nodeWithPub,
        cs1.setInitialState(state1);
        VotingConfiguration lastCommittedConfig,
                .build(),
        cs1.handlePublishResponse(node1, publishResponse);
 * You may obtain a copy of the License at
            .indices(Collections.emptyList())
                .add(node1)
            lastCommittedConfig,
        return setValue(
        PublishResponse publishResponse = cs1.handlePublishRequest(new PublishRequest(state2));
    public void testHandleCommitWithBadCurrentTerm() {
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
        Join v1 = cs1.handleStartJoin(startJoinRequest1);
        final VotingConfiguration initialConfig = VotingConfiguration.of(node1);
        PublishResponse publishResponse = cs2.handlePublishRequest(publishRequest);
        persistedStateRegistry.addPersistedState(PersistedStateType.LOCAL, new InMemoryPersistedState(0L, initialStateNode2));
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
            .clusterTerm(0L)
    private DiscoveryNode node1;
            expectThrows(CoordinationStateRejectedException.class, () -> cs1.handleStartJoin(startJoinRequest3)).getMessage(),
            .globalMetadataFileName(randomAlphaOfLength(10))
    public void testHandleClientValueWhenElectionNotWon() {
        StartJoinRequest startJoinRequest = new StartJoinRequest(nodeWithPub, newTerm);
            v1.getTerm(),
import static org.mockito.ArgumentMatchers.eq;
            copy.addVote(createNode(randomAlphaOfLength(10)));
        final ClusterState clusterState = clusterStateWithClusterManager(0L, 0L, node1, node1, initialConfig, initialConfig, 42L);
        persistedStateRegistry.addPersistedState(PersistedStateType.LOCAL, ps1);
        coordinationState.handleCommit(applyCommitRequest);
        assertTrue(state1.getLastAcceptedConfiguration().hasQuorum(Collections.singleton(node1.getId())));
import org.opensearch.cluster.metadata.Metadata;
        cs1.setInitialState(state1);
        ClusterState state2 = clusterState(startJoinRequest1.getTerm(), 2L, node1, initialConfig, initialConfig, 42L);
        ArgumentCaptor<ClusterState> clusterStateCaptor = ArgumentCaptor.forClass(ClusterState.class);
        assertNull(persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE).getLastAcceptedState());
        cs1.setInitialState(state1);
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node1, randomLongBetween(3, 5));
        );
 *
        assertThat(cs1.getCurrentTerm(), equalTo(startJoinRequest1.getTerm()));
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
            node1,
        );
        VotingConfiguration newConfig1 = VotingConfiguration.of(node2);
        );
        );
        );
        assertFalse(cs1.handleJoin(join));
            node1,
        assertEquals(cs1.getLastPublishedVersion(), 0L);
            7L
        Join v1 = cs1.handleStartJoin(startJoinRequest1);
        assertTrue(cs1.containsJoin(v1));
        when(remoteClusterStateService.markLastStateAsCommitted(any(), any(), eq(false))).thenReturn(
        assertFalse(cs1.handleJoin(join));
        StartJoinRequest startJoinRequest = new StartJoinRequest(node1, randomLongBetween(1, 5));
import java.util.Locale;
        assertFalse(cs1.handleJoin(join));
            .globalMetadataFileName(randomAlphaOfLength(10))
            value
        assertThat(expectThrows(AssertionError.class, () -> cs1.handleJoin(v1)).getMessage(), containsString("wrong node"));
                .add(nodeWithPub)
            initialConfig,
            .stateVersion(state2.version())
 * ownership. Elasticsearch licenses this file to you under
        Join join = new Join(node1, node1, v1.getTerm(), randomLongBetween(0, state2.term() - 1), randomLongBetween(0, 20));
        );
        Join v1 = cs1.handleStartJoin(startJoinRequest1);
        PublishResponse publishResponse = cs1.handlePublishRequest(publishRequest);
            expectThrows(CoordinationStateRejectedException.class, () -> cs1.handleJoin(v1)).getMessage(),
        cs1.setInitialState(state1);
                .add(node1)
        PersistedStateRegistry persistedStateRegistry,
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node1, randomLongBetween(1, 5));
        assertThat(v1.getSourceNode(), equalTo(node1));
        VotingConfiguration lastCommittedConfig,
        cs1.setInitialState(state1);
                    .persistentSettings(Settings.builder().put(clusterState.metadata().persistentSettings()).put("value", value).build())
        ClusterState state2 = clusterState(startJoinRequest1.getTerm(), 2L, node1, initialConfig, initialConfig, 7L);
        assertFalse(cs1.handleJoin(join));
        cs1.setInitialState(state1);
        assertThat(v1.getLastAcceptedVersion(), equalTo(initialStateNode1.version()));
        StartJoinRequest startJoinRequest2 = new StartJoinRequest(node2, randomLongBetween(startJoinRequest1.getTerm() + 1, 10));
    public static ClusterState setValue(ClusterState clusterState, long value) {
        assertTrue(state1.getLastAcceptedConfiguration().hasQuorum(Collections.singleton(node1.getId())));
    public void testHandlePublishResponseWithBadTerm() {
    }
        Join v1 = cs1.handleStartJoin(startJoinRequest1);
    public void testHandlePublishResponseWhenSteppedDownAsLeader() {
        assertEquals(state2.term(), publishResponse.getTerm());
        ClusterState state1 = clusterState(startJoinRequest1.getTerm(), randomLongBetween(2, 10), node1, initialConfig, initialConfig, 42L);
        assertTrue(cs1.handleJoin(v1));
        );
                .add(nodeWithPub)
        String stateRepoSettingsAttributeKeyPrefix = String.format(
            .build();
        long newTerm = randomLongBetween(1, 10);
        ClusterState state1 = clusterState(0L, 0L, node1, configNode1, configNode1, 42L);
                .add(nodeWithPub)
        );
            .previousClusterUUID(randomAlphaOfLength(10))
        );
        Join v1 = cs1.handleStartJoin(startJoinRequest1);
import static org.hamcrest.Matchers.nullValue;
        );
        assertTrue(cs1.electionWon());
        assertTrue(cs1.containsJoinVoteFor(node1));
        PublishRequest publishRequest = cs1.handleClientValue(state2);
        );
            .clusterTerm(1L)
            .stateUUID(randomAlphaOfLength(10))
        assertThat(applyCommit.get().getTerm(), equalTo(state2.term()));
        ClusterState state2 = clusterState(startJoinRequest1.getTerm(), 2L, node1, configNode1, configNode2, 42L);
    public void testSetInitialState() {
        }
        assertTrue(cs1.handleJoin(v1));
        coordinationState.handleStartJoin(startJoinRequest);
            ElectionStrategy.DEFAULT_INSTANCE
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
        cs1.handlePublishRequest(publishRequest);
        persistedStateRegistry.addPersistedState(
        assertFalse(cs1.containsJoinVoteFor(node2));
    }
            initialConfig,
        assertTrue(persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE).getLastAcceptedManifest().isCommitted());
        // cluster manager is node1 and nodeWithPub is a follower node
        ClusterState state2 = clusterState(startJoinRequest1.getTerm(), 2L, node1, initialConfig, initialConfig, 42L);
        assertTrue(voteCollection.isQuorum(VotingConfiguration.of(node1)));
            expectThrows(CoordinationStateRejectedException.class, () -> cs1.handleClientValue(state2)).getMessage(),
            containsString("only allow reconfiguration while not already reconfiguring")
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
        ClusterState state2 = clusterState(startJoinRequest1.getTerm(), randomLongBetween(2, 20), node1, initialConfig, initialConfig, 42L);
        final ClusterMetadataManifest manifest = ClusterMetadataManifest.builder()
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
        assertFalse(voteCollection.containsVoteFor(node3));
    }
                new DiscoveryNode("cluster-manager-ineligible", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT)
        assertFalse(applyCommit.isPresent());
        final RemoteClusterStateService remoteClusterStateService = Mockito.mock(RemoteClusterStateService.class);
package org.opensearch.cluster.coordination;
        PublishRequest publishRequest = coordinationState.handleClientValue(state2);
            version,
            persistedStateRegistry,
            new RemoteClusterStateManifestInfo(manifest, "path/to/manifest")
            .put(RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), true)
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
        long term,
import org.junit.Before;
        ClusterState state1 = clusterState(
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
        persistedStateRegistry.addPersistedState(
        );
    public void testHandleClientValueWithBadTerm() {
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
            lastAcceptedConfig,
        ClusterState state2 = clusterState(startJoinRequest1.getTerm(), randomLongBetween(1, 10), node1, initialConfig, initialConfig, 13L);
            containsString("does not match current term")
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
 * Licensed to Elasticsearch under one or more contributor
    }
    }
        final ClusterState clusterState2 = clusterState(0L, 1L, node1, initialConfig, initialConfig, 42L);
        coordinationState.handlePrePublish(clusterState);
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
        long value
                .add(nodeWithPub)
            return copy;
        assertTrue(cs1.handleJoin(v2));
    }
        cs1 = createCoordinationState(psr1, node1, Settings.EMPTY);
        Join badJoin = new Join(
    public void testHandleClientValue() {
            .nodeId(node1.getId())
        ClusterState state2 = setValue(
            containsString("cannot start publishing next value before accepting previous one")
        cs1.setInitialState(state1);
        assertTrue(cs1.electionWon());
        ClusterState state2 = clusterState(startJoinRequest1.getTerm(), 2L, node1, initialConfig, newConfig, 7L);
            DiscoveryNodes.builder().add(localNode).localNodeId(localNode.getId()).build(),
/*
        );
        VotingConfiguration newConfig = VotingConfiguration.of(node2);
                .nodes(discoveryNodes)
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node1, randomLongBetween(1, 5));
            .nodeId(node1.getId())
        assertTrue(voteCollection.isEmpty());
            new RemotePersistedState(remoteClusterStateService, previousClusterUUID)
        assertTrue(state1.getLastCommittedConfiguration().hasQuorum(Collections.singleton(node1.getId())));
            containsString("not greater than current term")
        if (randomBoolean()) {
            ClusterState.builder(ClusterName.DEFAULT)
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
        );
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
            expectThrows(CoordinationStateRejectedException.class, () -> cs1.handlePublishRequest(new PublishRequest(state2))).getMessage(),
        cs2.handleStartJoin(startJoinRequest2);
        ClusterState state2 = setValue(
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node2, randomLongBetween(1, 5));
            ).getMessage(),
        cs1.handlePublishRequest(publishRequest);
        assertTrue(cs1.containsJoin(v2));
        cs1.setInitialState(state1);
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node1, randomLongBetween(1, 5));
            PersistedStateType.REMOTE,
        assertThat(
        assertTrue(cs1.handleJoin(join));
        ClusterState state1 = clusterState(0L, 0L, node1, configNode1, configNode2, 42L);
                        .build()
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
            persistedStateRegistry,
        ClusterState state2 = clusterState(startJoinRequest1.getTerm(), randomLongBetween(2, 10), node1, initialConfig, initialConfig, 42L);
        assertFalse(
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node1, randomLongBetween(1, 5));
    public void testHandlePublishRequestWithBadTerm() {
 * software distributed under the License is distributed on an
    }
    public void testHandlePrePublishAndCommitWhenRemoteStateDisabled() {
        cs1.handleStartJoin(startJoinRequest2);
        Join join = new Join(node1, node1, v1.getTerm(), state2.term(), randomLongBetween(0, state2.version()));
            .clusterUUIDCommitted(true)
        PublishRequest publishRequest = cs1.handleClientValue(state2);
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY;
            randomLongBetween(0, startJoinRequest1.getTerm())
            persistedStateRegistry,
                () -> cs1.handlePublishResponse(randomFrom(node1, node2, node3), publishResponse)
        assertTrue(cs1.handleJoin(v1));
        assertEquals(state2.version(), publishResponse.getVersion());
        assertTrue(cs1.handleJoin(v1));
            .indices(Collections.emptyList())
    }
            randomLongBetween(0, startJoinRequest1.getTerm() - 1),
import org.opensearch.gateway.remote.model.RemoteClusterStateManifestInfo;
            ).getMessage(),
import static org.mockito.Mockito.verifyNoInteractions;
    public void testHandleCommitWithBadVersion() {
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
                    Metadata.builder(state1.metadata())
        assertTrue(cs1.handleJoin(join));
            address,
                .stateUUID(UUIDs.randomBase64UUID(random())) // generate cluster state UUID deterministically for repeatable tests
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT;
        PublishResponse publishResponse = cs1.handlePublishRequest(new PublishRequest(state2));
        node1 = createNode("node1");
        coordinationState.handlePublishRequest(new RemoteStatePublishRequest(publishRequest.getAcceptedState(), manifest));
            DiscoveryNodes.builder()
        assertFalse(cs1.electionWon());
        assertFalse(applyCommit.isPresent());
        ClusterState state2 = clusterState(startJoinRequest1.getTerm(), randomLongBetween(2, 10), node1, initialConfig, initialConfig, 42L);
            .build();
            containsString("ignored join as term has not been incremented yet after reboot")
        ClusterState state1 = clusterState(0L, 0L, node1, configNode2, configNode1, 42L);
            VotingConfiguration.EMPTY_CONFIG,
import org.opensearch.cluster.node.DiscoveryNodes;
            .clusterUUIDCommitted(true)
        Join v1 = cs1.handleStartJoin(startJoinRequest);
        StartJoinRequest startJoinRequest2 = new StartJoinRequest(node2, randomLongBetween(startJoinRequest1.getTerm() + 1, 10));
 */
                .add(node1)
                .build(),
import org.opensearch.cluster.coordination.PersistedStateRegistry.PersistedStateType;
import org.opensearch.test.OpenSearchTestCase;
        Join v2 = cs2.handleStartJoin(startJoinRequest1);
    }
        assertThat(
        psr1.addPersistedState(PersistedStateType.LOCAL, ps1);
        assertTrue(applyCommit.isPresent());
        );
        assertTrue(coordinationState.electionWon());
            .committed(false)
            .clusterUUID(randomAlphaOfLength(10))
        assertTrue(cs1.handleJoin(v1));
                .metadata(
    }
            value
        long newTerm = randomLongBetween(1, 10);
        assertThat(cs1.getCurrentTerm(), equalTo(0L));
        persistedStateRegistry.addPersistedState(PersistedStateType.LOCAL, new InMemoryPersistedState(0L, initialStateNode2));
        Join v1 = cs1.handleStartJoin(startJoinRequest2);
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
        PublishRequest publishRequest = cs1.handleClientValue(state2);
        ClusterState state3 = clusterState(
        final ClusterMetadataManifest manifest = ClusterMetadataManifest.builder()
            equalTo(committedClusterState.metadata().clusterUUIDCommitted())
            containsString("lower or equal to last published version")
        long term = randomBoolean()
        voteCollection.addVote(node1);
    private DiscoveryNode nodeWithPub;
        expectThrows(CoordinationStateRejectedException.class, () -> cs1.handleStartJoin(startJoinRequest2));
            expectThrows(CoordinationStateRejectedException.class, () -> cs1.handleClientValue(state2)).getMessage(),
        VotingConfiguration configNode1 = VotingConfiguration.of(node1);
        PublishRequest publishRequest = cs1.handleClientValue(state2);
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
        coordinationState.handlePrePublish(clusterState);
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
                .clusterManagerNodeId(node1.getId())
        assertThat(clusterStateCaptor.getValue().version(), equalTo(committedClusterState.version()));
import org.opensearch.test.EqualsHashCodeTestUtils;
        assertThat(
    }
        assertEquals(coordinationState.getLastCommittedConfiguration(), newConfig);
    }
    }
        assertTrue(cs1.electionWon());
    }
    public void testHandleClientValueDuringOngoingPublication() {
            randomNonNegativeLong(),
        ApplyCommitRequest applyCommitRequest = new ApplyCommitRequest(node2, state2.term(), state2.version());
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node2, randomLongBetween(1, 5));
        );
        cs1.setInitialState(state1);
            DiscoveryNodes.builder()
        Optional<ApplyCommitRequest> applyCommit = cs1.handlePublishResponse(node2, publishResponse);
                .localNodeId(nodeWithPub.getId())
        assertThat(publishRequest.getAcceptedState(), equalTo(state2));
            node1,
        Join v1 = cs1.handleStartJoin(startJoinRequest2);
        assertThat(
        assertFalse(cs1.containsJoinVoteFor(node2));
        VotingConfiguration newConfig = VotingConfiguration.of(node1, nodeWithPub, node3);
        String stateRepoTypeAttributeKey = String.format(
        assertTrue(cs1.electionWon());
            startJoinRequest.getTerm(),
    public void testHandlePrePublishAndCommitWhenRemoteStateEnabled() throws IOException {
            UUIDs.randomBase64UUID(random()), // generated deterministically for repeatable tests
                CoordinationStateRejectedException.class,
        assertTrue(cs1.handleJoin(v1));
    public void testStartJoinAfterBootstrap() {
        verifyNoInteractions(remoteClusterStateService);
            nodeWithPub,
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node1, randomLongBetween(1, 5));
            .indices(Collections.emptyList())
            .stateVersion(0L)
 * this file be licensed under the Apache-2.0 license or a
        persistedStateRegistry.addPersistedState(PersistedStateType.LOCAL, new InMemoryPersistedState(0L, initialStateNode2));
        long value
            .put(stateRepoSettingsAttributeKeyPrefix + "location", "randomRepoPath")
    }
            DiscoveryNodes.builder()
        );
        cs1.handleStartJoin(startJoinRequest1);
        assertTrue(cs1.electionWon());
        assertTrue(cs1.electionWon());
        cs1.handleStartJoin(startJoinRequest1);
        assertThat(
 *
            expectThrows(
        Join v1 = cs1.handleStartJoin(startJoinRequest1);
            remotePublicationSettings()
            "node.attr." + REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,
            value
            .nodeId(randomAlphaOfLength(10))
        final PersistedStateRegistry persistedStateRegistry = persistedStateRegistry();
        VotingConfiguration newConfig1 = VotingConfiguration.of(node2);
        final CoordinationState coordinationState = createCoordinationState(persistedStateRegistrySpy, node1, Settings.EMPTY);
        ClusterState state2 = clusterState(startJoinRequest1.getTerm(), 2L, node1, initialConfig, newConfig, 42L);
        );
            containsString("does not match current version")
                                .build()
        final CoordinationState coordinationState = createCoordinationState(
                () -> cs1.handlePublishResponse(randomFrom(node1, node2, node3), new PublishResponse(term, publishResponse.getVersion()))
            }
        PublishRequest publishRequest = cs1.handleClientValue(state2);
        Join v1 = cs1.handleStartJoin(startJoinRequest1);
        assertThat(value(cs1.getLastAcceptedState()), equalTo(13L));
            containsString("does not match current term")
        cs1.setInitialState(state1);
            initialConfig,
    }
        if (randomBoolean()) {
        Join v1 = cs1.handleStartJoin(startJoinRequest1);
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
        cs1.handlePublishRequest(publishRequest);
    }
        Join v1 = cs1.handleStartJoin(startJoinRequest1);
        assertThat(v1.getTargetNode(), equalTo(startJoinRequest1.getSourceNode()));
        ClusterState state2 = clusterState(startJoinRequest1.getTerm(), 2L, node1, newConfig, newConfig, 42L);
    }
            "nodeWithPub",
        assertThat(v1.getSourceNode(), equalTo(node1));
                                .lastAcceptedConfiguration(lastAcceptedConfig)
        cs1.handlePublishRequest(new PublishRequest(state2));
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
    public void testStartJoinBeforeBootstrap() {
            .committed(false)
        );
            .metadata(
            expectThrows(CoordinationStateRejectedException.class, () -> cs1.handleClientValue(state3)).getMessage(),
        assertTrue(cs1.handleJoin(v2));
            assertTrue(cs1.electionWon());
        assertThat(cs1.getLastPublishedVersion(), equalTo(state2.version()));
        cs1.setInitialState(state1);
        cs1.setInitialState(state1);
        persistedStateRegistry.addPersistedState(
            expectThrows(
            0L,
            id,
        ClusterState state2 = clusterState(startJoinRequest1.getTerm(), 2L, node1, initialConfig, initialConfig, 7L);
        StartJoinRequest startJoinRequest = new StartJoinRequest(nodeWithPub, newTerm);
        );
        Join badJoin = new Join(
    }
        verifyNoInteractions(remoteClusterStateService);
            return voteCollection1;
        cs1.setInitialState(state1);
        VotingConfiguration newConfig = VotingConfiguration.of(node1, nodeWithPub, node3);
        PublishRequest publishRequest = coordinationState.handleClientValue(state2);
        cs1.setInitialState(state1);
                .clusterManagerNodeId(node1.getId())
    private static PersistedStateRegistry createPersistedStateRegistry(ClusterState clusterState) {
    public void testHandleCommitOnFollowerNodeWhenRemotePublicationEnabledWithNullRemotePersistedState() {
        return ClusterState.builder(clusterState)
                CoordinationStateRejectedException.class,
                .localNodeId(localNode.getId())
            clusterStateCaptor.getValue().metadata().clusterUUIDCommitted(),
            0L,
        ClusterState state2 = clusterState(startJoinRequest1.getTerm(), 2L, node1, initialConfig, newConfig1, 42L);
        long term = randomBoolean()
    }
    }
            randomLongBetween(0, state2.version()),
        assertTrue(cs1.handleJoin(v1));
            remotePublicationSettings()
 * not use this file except in compliance with the License.
        ).runRandomly();
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node1, randomLongBetween(1, 5));
        assertFalse(cs1.containsJoin(v2));
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
        long newTerm = randomLongBetween(1, 10);
        assertThat(
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node1, randomLongBetween(1, 5));
            .codecVersion(1)
        StartJoinRequest startJoinRequest2 = new StartJoinRequest(
    }
        verifyNoInteractions(remoteClusterStateService);
        ClusterState state2 = clusterState(startJoinRequest1.getTerm(), randomLongBetween(2, 20), node1, initialConfig, initialConfig, 42L);
        persistedStateRegistry.addPersistedState(
    public void testHandleClientValueWithConfigurationChangeButNoJoinQuorum() {
                .add(nodeWithPub)
        final PersistedStateRegistry persistedStateRegistry = new PersistedStateRegistry();
            )
        assertThat(
        cs1.handleStartJoin(startJoinRequest1);
            0L,
            0L,
public class CoordinationStateTests extends OpenSearchTestCase {
 * Modifications Copyright OpenSearch Contributors. See
        StartJoinRequest startJoinRequest2 = new StartJoinRequest(node1, randomLongBetween(startJoinRequest1.getTerm() + 1, 10));
            expectThrows(CoordinationStateRejectedException.class, () -> cs1.handleClientValue(state1)).getMessage(),
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
            randomFrom(node1, node2),
                CoordinationStateRejectedException.class,
            43L
        assertThat(persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE), nullValue());
        final CoordinationState.VoteCollection voteCollection = new CoordinationState.VoteCollection();
        long value
                .version(randomLongBetween(1, 10))
import java.util.Map;
        DiscoveryNode localNode,
            for (DiscoveryNode node : vc.nodes()) {
            expectThrows(CoordinationStateRejectedException.class, () -> cs1.handlePublishRequest(new PublishRequest(state3))).getMessage(),
        cs1.setInitialState(state1);
            .previousClusterUUID(randomAlphaOfLength(10))
            persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE).getLastAcceptedState().metadata().clusterUUIDCommitted()
        );
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node2, randomLongBetween(1, 5));
        final PersistedStateRegistry persistedStateRegistry = persistedStateRegistry();
        ClusterState state2 = clusterState(
            IntStream.range(0, randomIntBetween(1, 5))
        assumeTrue("test only works with assertions enabled", Assertions.ENABLED);
        assertTrue(cs1.electionWon());
        persistedStateRegistry.addPersistedState(
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
                        .build()
        Join v1 = cs1.handleStartJoin(startJoinRequest1);
        ClusterState state1 = clusterState(0L, 0L, node1, configNode1, configNode1, 42L);
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY;
        assertThat(v1.getLastAcceptedTerm(), equalTo(state1.term()));
            .clusterUUID(state2.metadata().clusterUUID())
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
            new RemotePersistedState(remoteClusterStateService, state1.metadata().clusterUUID())
        StartJoinRequest startJoinRequest = new StartJoinRequest(node1, randomLongBetween(1, 5));
        );
            0L,
        assertTrue(state1.getLastCommittedConfiguration().hasQuorum(Collections.singleton(node1.getId())));
    }
        RemoteClusterStateService remoteClusterStateService = mock(RemoteClusterStateService.class);
        cs1.setInitialState(state1);
        );
    public void testJoinBeforeBootstrap() {
            42L
                .build(),
        cs1.handleClientValue(state3);
            "",
                .build(),
        assertEquals(state2.term(), publishResponse.getTerm());
    public void testHandleClientValueWithIllegalCommittedConfigurationChange() {
    public void testJoinDoesNotWinElection() {
                .localNodeId(nodeWithPub.getId())
        StartJoinRequest startJoinRequest2 = new StartJoinRequest(node1, randomLongBetween(startJoinRequest1.getTerm() + 1, 10));
        assertTrue(cs1.electionWon());
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
        assertTrue(cs1.electionWon());
            .globalMetadataFileName(randomAlphaOfLength(10))
    }
        ClusterState state2 = clusterState(startJoinRequest1.getTerm(), 2L, node1, initialConfig, newConfig, 42L);
        );
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
        Join v1 = cs1.handleStartJoin(startJoinRequest1);
            0L,
    }
            ? randomLongBetween(startJoinRequest1.getTerm() + 1, 10)
        ClusterState state2 = clusterState(
        ClusterState state2 = clusterState(term, 2L, node1, initialConfig, initialConfig, 42L);
        VotingConfiguration lastAcceptedConfig,
            attributes,
        );
        assertThat(
    public void testVoteCollection() {
        cs1.setInitialState(state1);
            Locale.getDefault(),
        assertThat(cs1.getLastPublishedVersion(), equalTo(state2.version()));
            expectThrows(CoordinationStateRejectedException.class, () -> cs1.handleStartJoin(startJoinRequest2)).getMessage(),
                .build(),
            initialConfig,
        cs2.handleStartJoin(startJoinRequest1);
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
        initialStateNode1 = clusterState(0L, 0L, node1, VotingConfiguration.EMPTY_CONFIG, VotingConfiguration.EMPTY_CONFIG, 42L);
    }
    }
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
        assertTrue(voteCollection.containsVoteFor(node1));
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
        assertFalse(cs1.electionWon());
        VotingConfiguration configNode1 = VotingConfiguration.of(node1);
    }
            new RemotePersistedState(remoteClusterStateService, state1.metadata().clusterUUID())
import java.util.Optional;
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
import org.opensearch.cluster.ClusterState;
        StartJoinRequest startJoinRequest = new StartJoinRequest(nodeWithPub, newTerm);
        }
            "node.attr." + REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,
        String randomRepoName = "randomRepoName";
                )
        assertTrue(cs1.electionWon());
        cs1.setInitialState(state1);
        cs1.setInitialState(state1);
 * license agreements. See the NOTICE file distributed with
        persistedStateRegistry.addPersistedState(PersistedStateType.LOCAL, ps1);
        assertThat(
        VotingConfiguration lastAcceptedConfig,
        assertThat(applyCommit.get().getVersion(), equalTo(state2.version()));
import org.mockito.Mockito;
        PublishRequest publishRequest = cs1.handleClientValue(state2);
        );
        new CoordinationStateTestCluster(
        cs1.setInitialState(state1);
        assertThat(applyCommit.get().getSourceNode(), equalTo(node1));
        );
        persistedStateRegistry.addPersistedState(PersistedStateType.LOCAL, new InMemoryPersistedState(0L, initialStateNode2));
    public static ClusterState clusterState(
            initialConfig,
    public static CoordinationState createCoordinationState(
            .codecVersion(1)
        assertThat(v1.getTerm(), equalTo(startJoinRequest1.getTerm()));
import org.opensearch.gateway.GatewayMetaState.RemotePersistedState;
        assertThat(v1.getTerm(), equalTo(startJoinRequest1.getTerm()));
        PublishRequest publishRequest = cs1.handleClientValue(state2);
    public void testJoinWithNoStartJoinAfterReboot() {
        VotingConfiguration lastCommittedConfig,
        assertThat(clusterStateCaptor.getValue().stateUUID(), equalTo(committedClusterState.stateUUID()));
                        .clusterUUID(UUIDs.randomBase64UUID(random())) // generate cluster UUID deterministically for repeatable tests
        assertTrue(cs1.handleJoin(v1));
            assertTrue(cs1.handleJoin(v1));
        Join v1 = cs1.handleStartJoin(startJoinRequest1);
            .stateUUID(randomAlphaOfLength(10))
        return Settings.builder().put(remoteStateSettings()).put(REMOTE_PUBLICATION_SETTING_KEY, true).build();
        long newTerm = randomLongBetween(1, 10);
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
        assertThat(cs1.getLastCommittedConfiguration(), equalTo(initialConfig));
        final VotingConfiguration initialConfig = VotingConfiguration.of(node1);
 * The OpenSearch Contributors require contributions made to
        cs1.setInitialState(state1);
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
        assertNull(persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE).getLastAcceptedManifest());
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
        );
            containsString("this node has not received its initial configuration yet")
            .build();
    public void testHandlePublishResponseWithoutCommit() {
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
        ClusterState state3 = clusterState(startJoinRequest1.getTerm(), 3L, node1, initialConfig, newConfig2, 42L);
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node1, randomLongBetween(1, 5));
        assertTrue(cs1.handleJoin(v2));
        ClusterState state2 = clusterState(startJoinRequest1.getTerm(), 2L, node1, initialConfig, initialConfig, 42L);
        PublishRequest publishRequest = cs1.handleClientValue(state2);
            startJoinRequest1.getTerm(),
        assertThat(
        );
import java.util.Collections;
import static java.util.Collections.emptySet;
    }
        final ClusterState clusterState = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
    }
        assertTrue(cs1.handleJoin(v2));
            .build();
        final ClusterMetadataManifest manifest = ClusterMetadataManifest.builder()
    public void testHandlePublishResponseWithoutCommitedConfigQuorum() {
            .clusterTerm(1L)
        );
    }
        );
        cs2.handlePublishRequest(new PublishRequest(state1));
        Join v1 = cs1.handleStartJoin(startJoinRequest1);
/*
import org.opensearch.Version;
    private CoordinationState cs1;
        );
        return clusterState.metadata().persistentSettings().getAsLong("value", 0L);
        ClusterState state1 = clusterState(
        assertThat(
 *
        );
        VotingConfiguration lastAcceptedConfig,
    }
        assertTrue(cs1.electionWon());
        Optional<ApplyCommitRequest> applyCommit = cs1.handlePublishResponse(node1, publishResponse);
 * under the License.
 *     http://www.apache.org/licenses/LICENSE-2.0
            .build();
            .metadata(Metadata.builder(clusterState.metadata()).clusterUUIDCommitted(true).build())
        VotingConfiguration initialConfig = VotingConfiguration.of(node1, nodeWithPub);
            0L,
                () -> cs1.handlePublishResponse(randomFrom(node1, node2, node3), publishResponse)
        final CoordinationState coordinationState = createCoordinationState(persistedStateRegistry, node1, remoteStateSettings());
        Optional<ApplyCommitRequest> applyCommit = cs1.handlePublishResponse(node2, publishResponse);
    ) {
            Locale.getDefault(),
                .clusterManagerNodeId(node1.getId())
                .metadata(
                .add(node1)
        ClusterState state2 = clusterState(startJoinRequest1.getTerm(), randomLongBetween(2, 20), node1, initialConfig, initialConfig, 42L);
    public void testHandlePublishRequest() {
        PublishResponse publishResponse = cs1.handlePublishRequest(new PublishRequest(state2));
 * KIND, either express or implied.  See the License for the
    }
        assertThat(
        );
        assertTrue(coordinationState.handleJoin(v2));
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node1, randomLongBetween(1, 5));
    @Before
            randomLongBetween(state2.getVersion() + 1, 20),
    public void testSafety() {
                .build(),
        cs1.handlePublishResponse(node1, publishResponse);
            .previousClusterUUID(randomAlphaOfLength(10))
        assertTrue(cs1.electionWon());
        cs1.setInitialState(state1);
        Join v2 = cs2.handleStartJoin(startJoinRequest1);
        PublishResponse publishResponse = coordinationState.handlePublishRequest(new RemoteStatePublishRequest(state2, manifest));
        VotingConfiguration initialConfig = VotingConfiguration.of(node1, nodeWithPub);
        }
            term,
        cs1.handleStartJoin(startJoinRequest1);
                .build(),
    }
        assertThat(publishResponse.getVersion(), equalTo(state2.version()));
        assertEquals(state2.version(), publishResponse.getVersion());
        Join v1 = cs1.handleStartJoin(startJoinRequest2);
        assertTrue(cs1.handleJoin(join));
        StartJoinRequest startJoinRequest3 = new StartJoinRequest(randomFrom(node1, node2), startJoinRequest1.getTerm());
        final String previousClusterUUID = "prev-cluster-uuid";
import java.util.stream.IntStream;
import static org.hamcrest.Matchers.containsString;
        ClusterState state3 = clusterState(startJoinRequest1.getTerm(), 3L, node1, initialConfig, initialConfig, 42L);
        Join v2 = cs2.handleStartJoin(startJoinRequest1);
        );
    public void testJoinWithLowerLastAcceptedTermWinsElection() {
                .localNodeId(nodeWithPub.getId())
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node1, randomLongBetween(1, 5));
            containsString("does not match last accepted term")
        voteCollection.addVote(node2);
                        .coordinationMetadata(
        Join v1 = cs1.handleStartJoin(startJoinRequest1);
        coordinationState.setInitialState(state1);
            ).getMessage(),
import static org.mockito.Mockito.when;
        psr1 = persistedStateRegistry();
        PublishRequest publishRequest = cs1.handleClientValue(state2);
    private CoordinationState cs3;
                .build(),
    }
import org.opensearch.cluster.node.DiscoveryNodeRole;
    public void testHandlePublishResponseWithoutPublishConfigQuorum() {
        Optional<ApplyCommitRequest> applyCommit = cs1.handlePublishResponse(node1, publishResponse);
        assertTrue(cs1.electionWon());
        return persistedStateRegistry;
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
        final TransportAddress address = buildNewFakeTransportAddress();
        ApplyCommitRequest applyCommitRequest = new ApplyCommitRequest(node2, state2.term(), state2.version());
    }
            VotingConfiguration.EMPTY_CONFIG,
        Mockito.verify(persistedStateRegistrySpy, Mockito.times(0)).getPersistedState(PersistedStateType.REMOTE);
        long version,
            lastAcceptedConfig,
        ClusterState state3 = clusterState(
        Join v2 = cs2.handleStartJoin(startJoinRequest1);
            randomLongBetween(0, startJoinRequest1.getTerm())
            ClusterState.builder(state1)
        ClusterState state2 = clusterState(startJoinRequest2.getTerm(), randomLongBetween(0, 20), node1, initialConfig, initialConfig, 42L);
    }
        ClusterState committedClusterState = ClusterState.builder(clusterState)
        Join v2 = cs2.handleStartJoin(startJoinRequest1);
            42L
        assertThat(persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE), nullValue());
        assertThat(v1.getLastAcceptedVersion(), equalTo(state1.version()));
        Join join = cs1.handleStartJoin(startJoinRequest);
                .build(),
            expectThrows(CoordinationStateRejectedException.class, () -> cs1.handleJoin(badJoin)).getMessage(),
        ClusterState state2 = clusterState(startJoinRequest1.getTerm(), 2L, node1, configNode1, configNode2, 42L);
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX;
                .add(node1)
            CoordinationState.VoteCollection copy = copyFunction.copy(vc);
        );
            expectThrows(CoordinationStateRejectedException.class, () -> cs1.handleJoin(v1)).getMessage(),
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
        cs1.setInitialState(state1);
        ClusterState state2 = clusterState(startJoinRequest1.getTerm(), 2L, node1, initialConfig, newConfig1, 42L);
    private PersistedStateRegistry psr1;
        cs1.setInitialState(state1);
        assertThat(
        cs1.setInitialState(state1);
        Join join = cs1.handleStartJoin(startJoinRequest);
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node2, randomLongBetween(1, 5));
        long version,
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node1, randomLongBetween(1, 5));
        assertThat(
            .build();
        long version,
        );
            expectThrows(CoordinationStateRejectedException.class, () -> cs1.handleJoin(badJoin)).getMessage(),
        assertThat(
        assertThat(cs1.getLastCommittedConfiguration(), equalTo(newConfig));
            term,
            randomNonNegativeLong()
            randomFrom(node1, node2),
    private static Settings remoteStateSettings() {
        RemoteClusterStateService remoteClusterStateService = mock(RemoteClusterStateService.class);
        assertTrue(cs1.electionWon());
            ? randomLongBetween(startJoinRequest1.getTerm() + 1, 10)
        final PersistedStateRegistry persistedStateRegistry = persistedStateRegistry();
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
        ClusterState state2 = clusterState(startJoinRequest1.getTerm(), 2L, node1, initialConfig, initialConfig, 42L);
        cs1.setInitialState(state1);
        PublishResponse publishResponse = coordinationState.handlePublishRequest(new PublishRequest(state2));
                "",
    }
            newConfig,
        Join v1 = cs1.handleStartJoin(startJoinRequest2);
        assertFalse(voteCollection.containsVoteFor(node3));
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
    }
        assertTrue(voteCollection.containsVoteFor(node2));
        assertTrue(cs1.handleJoin(v1));
        assertTrue(cs1.containsJoin(join));
        PublishResponse publishResponse = cs1.handlePublishRequest(publishRequest);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        PersistedState spyRPS = spy(persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE));
        );
            remotePublicationSettings()
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
        return clusterState(
        );
 * Unless required by applicable law or agreed to in writing,
    public void testHandleClientValueWithSameReconfigurationWhileAlreadyReconfiguring() {
        assertThat(
            initialConfig,
    }
    public void testHandlePublishResponseWithCommit() {
    ) {
        coordinationState.setInitialState(state1);
            ? randomLongBetween(startJoinRequest1.getTerm() + 1, 10)
    // scenario when handling a publish request from a fresh cluster-manager
            cs1.setInitialState(state1);
                .add(clusterManagerNode)
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node1, randomLongBetween(1, 5));
            DiscoveryNodes.builder()
                () -> cs1.handleCommit(new ApplyCommitRequest(node1, startJoinRequest1.getTerm(), 2L))
        verifyNoInteractions(remoteClusterStateService);
        ClusterState state2 = clusterState(term, 2L, node1, initialConfig, initialConfig, 42L);
            initialConfig,
    }
import org.opensearch.repositories.fs.FsRepository;
        ClusterState state1 = clusterState(
        assertTrue(state1.getLastCommittedConfiguration().hasQuorum(Collections.singleton(node1.getId())));
        cs1.setInitialState(state1);
            randomRepoName
    }
        Join v2 = cs2.handleStartJoin(startJoinRequest1);
        PublishResponse publishResponse = cs1.handlePublishRequest(publishRequest);
        assertTrue(cs1.handleJoin(v1));
 */
                                .lastCommittedConfiguration(lastCommittedConfig)
        Join v3 = cs3.handleStartJoin(startJoinRequest1);
 * specific language governing permissions and limitations
        StartJoinRequest startJoinRequest2 = new StartJoinRequest(node2, randomLongBetween(startJoinRequest1.getTerm() + 1, 10));
        );
    public void testHandlePublishResponseWithVersionMismatch() {
    public static ClusterState clusterState(
                voteCollection1.addVote(node);
                .add(nodeWithPub)
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
        if (randomBoolean()) {
        assertThat(
        assertThat(
import static org.mockito.Mockito.verify;
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node1, randomLongBetween(1, 5));
        VotingConfiguration configNode2 = VotingConfiguration.of(node2);
        assertThat(cs1.getCurrentTerm(), equalTo(startJoinRequest1.getTerm()));
            PersistedStateType.REMOTE,
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node1, randomLongBetween(1, 5));
        coordinationState.handlePreCommit();
                .clusterManagerNodeId(node1.getId())
import org.opensearch.common.UUIDs;
    public void testJoinDoesNotWinElectionWhenOnlyCommittedConfigQuorum() {
import static org.mockito.Mockito.mock;
        return settings;
            newConfig,
            0L,
        Mockito.verify(remoteClusterStateService, Mockito.times(1)).writeFullMetadata(clusterState, previousClusterUUID);
        ClusterState state1 = clusterState(
        nodeWithPub = createNode(
            expectThrows(CoordinationStateRejectedException.class, () -> cs1.handleClientValue(state3)).getMessage(),
    public void testHandlePublishRequestOnFollowerWhenRemotePublicationEnabled() {
    public static long value(ClusterState clusterState) {
    public void testHandleClientValueWithDifferentReconfigurationWhileAlreadyReconfiguring() {
            .opensearchVersion(Version.CURRENT)
                .version(version)
                .version(randomLongBetween(1, 10))
import static org.hamcrest.Matchers.equalTo;
    }
    public static DiscoveryNode createNode(String id) {
                )
        coordinationState.handleCommit(applyCommitRequest);
        return new CoordinationState(localNode, persistedStateRegistry, ElectionStrategy.DEFAULT_INSTANCE, settings);
        assertThat(
        assertTrue(cs1.electionWon());
            initialConfig,
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
        assertFalse(applyCommit.isPresent());
    public void testSetInitialStateWhenAlreadySet() {
    public static DiscoveryNode createNode(String id, Map<String, String> attributes) {
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
        return createNode(id, Collections.emptyMap());
    public void testHandleClientValueWithOldVersion() {
                .collect(Collectors.toList()),
        );
        PublishResponse publishResponse = cs1.handlePublishRequest(publishRequest);
import static java.util.Collections.emptyMap;
        assertTrue(coordinationState.handleJoin(v1));
        assertThat(persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE), nullValue());
    ) {
            .put(stateRepoTypeAttributeKey, FsRepository.TYPE)
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node1, randomLongBetween(1, 5));
            : randomLongBetween(0, startJoinRequest1.getTerm() - 1);
        Join v1 = cs1.handleStartJoin(startJoinRequest1);
            Map.of(
                .clusterManagerNodeId(node1.getId())
            expectThrows(
    }
        assertThat(clusterStateCaptor.getValue().metadata().clusterUUID(), equalTo(committedClusterState.metadata().clusterUUID()));
        long term = randomBoolean()
        assertTrue(coordinationState.handleJoin(v1));
        assertEquals(state2, persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE).getLastAcceptedState());
                .getMessage(),
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
            : randomLongBetween(0, startJoinRequest1.getTerm() - 1);
        Join v1 = cs1.handleStartJoin(startJoinRequest1);
            version,
        final RemoteClusterStateService remoteClusterStateService = Mockito.mock(RemoteClusterStateService.class);
        assertThat(cs1.getLastAcceptedState(), equalTo(state1));
        );
        assertTrue(cs1.electionWon());
        assertTrue(
        assertEquals(cs1.getLastPublishedVersion(), cs1.getLastAcceptedVersion());
            .committed(false)
            containsString("last committed configuration should not change")
        assertThat(publishResponse.getTerm(), equalTo(state2.term()));
            startJoinRequest.getTerm(),
    public void testHandleCommit() {
 * this work for additional information regarding copyright
            ).getMessage(),
            clusterStateCaptor.getValue().coordinationMetadata().term(),
        node2 = createNode("node2");
    public void testHandlePublishRequestWithSameTermButOlderOrSameVersion() {
        assertTrue(cs1.electionWon());
    }
        ps1 = new InMemoryPersistedState(0L, initialStateNode1);
    }
        DiscoveryNode clusterManagerNode,
        cs1.setInitialState(state1);
        EqualsHashCodeTestUtils.CopyFunction<CoordinationState.VoteCollection> copyFunction = vc -> {
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(randomFrom(node1, node2), randomLongBetween(1, 5));
        VotingConfiguration configNode2 = VotingConfiguration.of(node2);
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node2, randomLongBetween(1, 5));
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfiguration;
            .clusterUUIDCommitted(true)
        long term,
        Join badJoin = new Join(randomFrom(node1, node2), node1, v1.getTerm(), state2.term(), randomLongBetween(state2.version() + 1, 30));
    private DiscoveryNode node2;
    public void testRemotePersistedStateResetsForPublicationEnabledAfterLocalPublication() {
import static org.mockito.Mockito.times;
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
        cs1.handleCommit(applyCommit.get());
            42L
            containsString("initial state already set")
        cs1.setInitialState(state1);
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node1, randomLongBetween(1, 5));
        Join v1 = cs1.handleStartJoin(startJoinRequest1);
        long term = randomBoolean()
        persistedStateRegistry.addPersistedState(PersistedStateType.LOCAL, new InMemoryPersistedState(0L, clusterState));
        ClusterState state2 = clusterState(startJoinRequest1.getTerm(), randomLongBetween(2, 20), node1, initialConfig, initialConfig, 42L);
        PublishRequest publishRequest = cs1.handleClientValue(state2);
        EqualsHashCodeTestUtils.checkEqualsAndHashCode(voteCollection, copyFunction, vc -> {
        cs1.handlePublishRequest(new PublishRequest(state2));
            expectThrows(AssertionError.class, () -> cs1.handleClientValue(state2)).getMessage(),
import java.util.stream.Collectors;
        VotingConfiguration newConfig2 = VotingConfiguration.of(node3);
                .localNodeId(nodeWithPub.getId())
        assertTrue(cs1.handleJoin(join));
        cs1.setInitialState(state1);
        Mockito.verify(persistedStateRegistrySpy, Mockito.times(0)).getPersistedState(PersistedStateType.REMOTE);
        );
                ""
            address.address().getHostString(),
                .mapToObj(i -> new DiscoveryNode("node_" + i, buildNewFakeTransportAddress(), Version.CURRENT))
