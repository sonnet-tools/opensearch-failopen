        final ClusterMetadataManifest manifest = ClusterMetadataManifest.builder()
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);  
        assertFalse(applyCommit.isPresent());  
        assertThat(persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE).getLastAcceptedState(), equalTo(clusterState));
    }  
        cs1.setInitialState(state1);  
        Join badJoin = new Join(
        final TransportAddress address = buildNewFakeTransportAddress();
    public void testHandleClientValueWithConfigurationChangeButNoJoinQuorum() {  
    private DiscoveryNode node1;
    }
        ClusterState state2 = clusterState(startJoinRequest1.getTerm(), 2L, node1, initialConfig, initialConfig, 42L);
                        .coordinationMetadata(CoordinationMetadata.builder(state1.coordinationMetadata()).term(newTerm).build())  
        );  
        if (randomBoolean()) {
        assertFalse(cs1.handleJoin(join));  
        PublishRequest publishRequest = coordinationState.handleClientValue(state2);  
        return settings;
import java.util.stream.IntStream;
            expectThrows(  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
        );
            containsString("not greater than current term")
    public void testHandleClientValueWhenElectionNotWon() {
        coordinationState.handleStartJoin(startJoinRequest);  
            startJoinRequest1.getTerm(),
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);  
            lastCommittedConfig,  
        cs1.setInitialState(state1);
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node1, randomLongBetween(1, 5));  
    }
        assertFalse(voteCollection.containsVoteFor(node3));
            newConfig,  
        );
        assertThat(
        assertTrue(cs1.electionWon());
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
        );  
        assertTrue(cs1.handleJoin(v1));
    public void testHandlePublishResponseWhenSteppedDownAsLeader() {
            expectThrows(  
            .nodeId(randomAlphaOfLength(10))
                .add(localNode)
            ClusterState.builder(ClusterName.DEFAULT)  
        StartJoinRequest startJoinRequest = new StartJoinRequest(nodeWithPub, newTerm);  
        assertTrue(cs1.handleJoin(v1));
    }
                    Metadata.builder()
            containsString("higher than current last accepted term")  
        Join v3 = cs3.handleStartJoin(startJoinRequest1);
            )
    }
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node2, randomLongBetween(1, 5));
        assertTrue(cs1.handleJoin(v1));
                .build(),
        long value  
                () -> cs1.handleCommit(new ApplyCommitRequest(node1, startJoinRequest1.getTerm(), 2L))  
            node1,
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node1, randomLongBetween(1, 5));
            randomNonNegativeLong(),  
        final PersistedStateRegistry persistedStateRegistry = persistedStateRegistry();
        VotingConfiguration newConfig = VotingConfiguration.of(node2);
        ClusterState state1 = clusterState(  
        ClusterState state2 = clusterState(startJoinRequest1.getTerm(), randomLongBetween(2, 10), node1, initialConfig, initialConfig, 42L);  
    }
        VotingConfiguration configNode2 = VotingConfiguration.of(node2);  
            expectThrows(CoordinationStateRejectedException.class, () -> cs1.handleClientValue(state3)).getMessage(),
        assertEquals(state2.version(), publishResponse.getVersion());  
        Optional<ApplyCommitRequest> applyCommit = cs1.handlePublishResponse(node2, publishResponse);
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);  
        StartJoinRequest startJoinRequest = new StartJoinRequest(node1, randomLongBetween(1, 5));
            13L  
        );  
    public void testHandleClientValueWithIllegalCommittedConfigurationChange() {
            0L,  
import java.io.IOException;
        assertTrue(cs1.electionWon());  
    public void testJoinDoesNotWinElectionWhenOnlyLastAcceptedConfigQuorum() {  
        PublishRequest publishRequest = cs1.handleClientValue(state2);
 * Modifications Copyright OpenSearch Contributors. See  
    public void testJoinWithSameAcceptedTermButHigherVersion() {
 * Unless required by applicable law or agreed to in writing,
        nodeWithPub = createNode(  
        VotingConfiguration initialConfig = VotingConfiguration.of(node1, nodeWithPub);
    public void testHandleClientValue() {
            expectThrows(CoordinationStateRejectedException.class, () -> cs1.handlePublishRequest(new PublishRequest(state3))).getMessage(),
        verifyNoInteractions(remoteClusterStateService);
            persistedStateRegistry,  
            expectThrows(CoordinationStateRejectedException.class, () -> cs1.handleJoin(badJoin)).getMessage(),
        assumeTrue("test only works with assertions enabled", Assertions.ENABLED);
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
 */  
        ClusterState state1 = clusterState(
        StartJoinRequest startJoinRequest2 = new StartJoinRequest(node2, randomLongBetween(startJoinRequest1.getTerm() + 1, 10));
                    Metadata.builder(state1.metadata())
        assertThat(publishResponse.getVersion(), equalTo(state2.version()));  
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node1, randomLongBetween(1, 5));
            randomLongBetween(0, startJoinRequest1.getTerm() - 1),
        );  
        cs1.handleStartJoin(startJoinRequest1);  
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);  
        VotingConfiguration configNode2 = VotingConfiguration.of(node2);
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
            new RemoteClusterStateManifestInfo(manifest, "path/to/manifest")
            .codecVersion(1)  
        assertTrue(cs1.electionWon());
        coordinationState.handlePublishRequest(new PublishRequest(publishRequest.getAcceptedState()));  
        );
        coordinationState.handlePreCommit();  
        ApplyCommitRequest applyCommitRequest = new ApplyCommitRequest(node2, state2.term(), state2.version());
        ClusterState state1 = clusterState(0L, 0L, node1, configNode1, configNode1, 42L);  
        RemoteClusterStateService remoteClusterStateService = mock(RemoteClusterStateService.class);
        assertTrue(cs1.handleJoin(v1));  
        Join join = new Join(node1, node1, v1.getTerm(), randomLongBetween(0, state2.term() - 1), randomLongBetween(0, 20));
        persistedStateRegistry.addPersistedState(  
        ClusterState state2 = clusterState(startJoinRequest1.getTerm(), 2L, node1, initialConfig, initialConfig, 7L);
                .add(nodeWithPub)
            node1,  
        ClusterState state2 = clusterState(startJoinRequest1.getTerm(), randomLongBetween(2, 10), node1, initialConfig, initialConfig, 42L);  
        );
import org.opensearch.common.UUIDs;
        final PersistedStateRegistry persistedStateRegistry = persistedStateRegistry();
            startJoinRequest.getTerm(),
        assertTrue(persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE).getLastAcceptedManifest().isCommitted());
        cs1.setInitialState(state1);
        assertThat(
        assertTrue(coordinationState.handleJoin(v2));
    private CoordinationState cs1;  
        assertThat(  
        );  
import static org.mockito.Mockito.mock;
        DiscoveryNodes discoveryNodes,  
        assertTrue(state1.getLastCommittedConfiguration().hasQuorum(Collections.singleton(node1.getId())));
        );
        assertTrue(cs1.electionWon());
    }  
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX;
    public void testJoinWithBadCurrentTerm() {
            Map.of(
            assertTrue(cs1.handleJoin(v1));  
    }  
 * under the License.  
                        )  
        StartJoinRequest startJoinRequest2 = new StartJoinRequest(
            id,
    public void testHandlePublishResponseWithCommit() {
import static org.opensearch.gateway.remote.RemoteClusterStateService.REMOTE_PUBLICATION_SETTING_KEY;  
                        .build()
        assertTrue(
            0L,
            expectThrows(AssertionError.class, () -> cs1.handleClientValue(state2)).getMessage(),
        assertTrue(cs1.electionWon());
    private CoordinationState cs2;
                .localNodeId(nodeWithPub.getId())
        long newTerm = randomLongBetween(1, 10);
            remotePublicationSettings()  
import java.util.Collections;  
import java.util.stream.Collectors;
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node1, randomLongBetween(1, 5));
        StartJoinRequest startJoinRequest = new StartJoinRequest(node1, randomLongBetween(1, 5));  
                .build(),
import org.opensearch.core.common.transport.TransportAddress;
        assertTrue(cs1.handleJoin(join));  
        ClusterState state1 = clusterState(startJoinRequest1.getTerm(), randomLongBetween(2, 10), node1, initialConfig, initialConfig, 42L);
        assertThat(  
        long version,
        assertTrue(cs1.electionWon());
        assertThat(  
        long value  
                () -> cs1.handlePublishResponse(randomFrom(node1, node2, node3), publishResponse)  
        Mockito.verify(remoteClusterStateService, Mockito.times(1)).writeFullMetadata(clusterState, previousClusterUUID);
        ClusterState state2 = clusterState(startJoinRequest1.getTerm(), 2L, node1, initialConfig, newConfig1, 42L);  
        cs1.setInitialState(state1);
        coordinationState.handleStartJoin(startJoinRequest);  
        Join v1 = cs1.handleStartJoin(startJoinRequest2);
        cs1.handlePublishRequest(publishRequest);  
            initialConfig,
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(randomFrom(node1, node2), randomLongBetween(1, 5));
            DiscoveryNodes.builder()
            attributes,
            term,
            0L,  
        final CoordinationState coordinationState = createCoordinationState(persistedStateRegistrySpy, node1, Settings.EMPTY);
        return clusterState(  
        Join v1 = cs1.handleStartJoin(startJoinRequest2);  
        ClusterState state2 = clusterState(term, 2L, node1, initialConfig, initialConfig, 42L);  
        voteCollection.addVote(node2);  
    public void testJoinDoesNotWinElectionWhenOnlyCommittedConfigQuorum() {
        assertTrue(cs1.electionWon());
        assertTrue(cs1.handleJoin(v1));
        coordinationState.handlePrePublish(clusterState);
        verifyNoInteractions(spyRPS);  
        Join badJoin = new Join(randomFrom(node1, node2), node1, v1.getTerm(), state2.term(), randomLongBetween(state2.version() + 1, 30));
                new DiscoveryNode("cluster-manager-ineligible", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT)
        assertTrue(coordinationState.handleJoin(v1));
            0L,
        VotingConfiguration newConfig = VotingConfiguration.of(node2);  
        assertFalse(applyCommit.isPresent());  
        coordinationState.setInitialState(state1);
            expectThrows(CoordinationStateRejectedException.class, () -> cs1.handleStartJoin(startJoinRequest3)).getMessage(),  
        assertThat(v1.getTerm(), equalTo(startJoinRequest1.getTerm()));
        return ClusterState.builder(clusterState)  
            new RemotePersistedState(remoteClusterStateService, previousClusterUUID)
    public void testSafety() {
        PublishRequest publishRequest = cs1.handleClientValue(state2);  
        );
        assertTrue(cs1.electionWon());  
        cs1.setInitialState(state1);
        return createNode(id, Collections.emptyMap());
            .previousClusterUUID(randomAlphaOfLength(10))
        );  
        coordinationState.handleCommit(applyCommitRequest);  
        assertThat(clusterStateCaptor.getValue().version(), equalTo(committedClusterState.version()));
    }
            43L
        final PersistedStateRegistry persistedStateRegistry = persistedStateRegistry();
        assertTrue(cs1.electionWon());  
import static java.util.Collections.emptyMap;
        );  
    }  
        Join v2 = cs2.handleStartJoin(startJoinRequest1);
        return new CoordinationState(localNode, persistedStateRegistry, ElectionStrategy.DEFAULT_INSTANCE, settings);  
        cs1.handlePublishRequest(publishRequest);
        assertTrue(cs1.handleJoin(v1));  
        VotingConfiguration newConfig = VotingConfiguration.of(node2);
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node1, randomLongBetween(1, 5));  
        assertTrue(cs1.electionWon());
        Optional<ApplyCommitRequest> applyCommit = cs1.handlePublishResponse(node1, publishResponse);
            42L  
            2L,
                        .clusterUUID(UUIDs.randomBase64UUID(random())) // generate cluster UUID deterministically for repeatable tests
                .localNodeId(nodeWithPub.getId())
        coordinationState.setInitialState(state1);
            .stateUUID(randomAlphaOfLength(10))  
        StartJoinRequest startJoinRequest2 = new StartJoinRequest(node1, randomLongBetween(startJoinRequest1.getTerm() + 1, 10));
        assertTrue(state1.getLastAcceptedConfiguration().hasQuorum(Collections.singleton(node1.getId())));
        assertTrue(cs1.handleJoin(v2));
        final PersistedStateRegistry persistedStateRegistrySpy = spy(persistedStateRegistry);
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);  
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
            IntStream.range(0, randomIntBetween(1, 5))  
import static org.mockito.Mockito.verifyNoInteractions;
    private ClusterState initialStateNode1;  
            new RemoteClusterStateManifestInfo(manifest, "path/to/manifest")
        );
        VotingConfiguration lastAcceptedConfig,
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
            randomRepoName
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node1, randomLongBetween(3, 5));  
 * KIND, either express or implied.  See the License for the
    public void testSetInitialStateWhenAlreadySet() {
        final CoordinationState coordinationState = createCoordinationState(
    }
    }
            .indices(Collections.emptyList())
        verify(remoteClusterStateService, times(1)).markLastStateAsCommitted(clusterStateCaptor.capture(), any(), eq(false));  
        assertTrue(state1.getLastAcceptedConfiguration().hasQuorum(Collections.singleton(node1.getId())));
        ClusterState state2 = clusterState(startJoinRequest1.getTerm(), 2L, node1, initialConfig, newConfig, 7L);
            "node.attr." + REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,
    public void testVoteCollection() {
import static org.hamcrest.Matchers.equalTo;  
        PublishResponse publishResponse = cs1.handlePublishRequest(new PublishRequest(state2));
            DiscoveryNodes.builder()  
        assertThat(
        Join v1 = cs1.handleStartJoin(startJoinRequest1);  
            lastAcceptedConfig,
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
        cs1.handlePublishResponse(node1, publishResponse);
        );  
        assertThat(persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE), nullValue());
        final ClusterState clusterState2 = clusterState(0L, 1L, node1, initialConfig, initialConfig, 42L);
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node1, randomLongBetween(1, 5));
            expectThrows(CoordinationStateRejectedException.class, () -> cs1.handleStartJoin(startJoinRequest2)).getMessage(),
            .committed(false)
import org.mockito.ArgumentCaptor;
    }
            randomNonNegativeLong()
            containsString("does not match current version")
            0L,
        Join v1 = cs1.handleStartJoin(startJoinRequest1);
        ClusterState state2 = clusterState(startJoinRequest1.getTerm(), 2L, node1, initialConfig, newConfig, 42L);  
                                .term(term)
    }
        );
        StartJoinRequest startJoinRequest2 = new StartJoinRequest(node2, randomLongBetween(startJoinRequest1.getTerm() + 1, 10));  
    }
import org.opensearch.gateway.remote.ClusterMetadataManifest;  
import org.opensearch.core.Assertions;  
        assertTrue(cs1.containsJoin(v2));
        assertThat(
            expectThrows(CoordinationStateRejectedException.class, () -> cs1.handleClientValue(state2)).getMessage(),
        cs3 = createCoordinationState(createPersistedStateRegistry(initialStateNode3), node3, Settings.EMPTY);  
        PublishResponse publishResponse = cs1.handlePublishRequest(new PublishRequest(state2));
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node2, randomLongBetween(1, 5));
        ClusterState state1 = clusterState(0L, 0L, node1, configNode1, configNode1, 42L);  
        assertNull(persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE).getLastAcceptedManifest());
        // cluster manager is node1 and nodeWithPub is a follower node
 *
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
        assertTrue(cs1.handleJoin(v1));  
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
        );
        );  
            initialConfig,
 * compatible open source license.
        ClusterState state3 = clusterState(startJoinRequest1.getTerm(), 3L, node1, initialConfig, newConfig2, 42L);
            0L,
        assertTrue(cs1.handleJoin(join));
        final ClusterState clusterState = clusterStateWithClusterManager(0L, 0L, node1, node1, initialConfig, initialConfig, 42L);
    }  
            containsString("does not match current term")
        cs1.handleStartJoin(startJoinRequest1);
    }
                    .build()
            ClusterState.builder(state1)  
import org.opensearch.common.settings.Settings;
        final PersistedStateRegistry persistedStateRegistry = persistedStateRegistry();
    public void testHandleCommitWithBadVersion() {  
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
    }
                )
        assertThat(v1.getLastAcceptedVersion(), equalTo(initialStateNode1.version()));  
            DiscoveryNodes.builder()  
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
 */
                .localNodeId(nodeWithPub.getId())  
        PublishResponse publishResponse = cs1.handlePublishRequest(publishRequest);
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node1, randomLongBetween(1, 5));  
        cs2.handleStartJoin(startJoinRequest1);  
                .build(),
        RemoteClusterStateService remoteClusterStateService = mock(RemoteClusterStateService.class);
            randomLongBetween(state2.term() + 1, 30),
                .version(randomLongBetween(1, 10))  
        assertThat(clusterStateCaptor.getValue().metadata().indices(), equalTo(committedClusterState.metadata().indices()));
        long newTerm = randomLongBetween(1, 10);  
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node1, randomLongBetween(1, 5));
            initialConfig,  
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node2, randomLongBetween(1, 5));  
        final CoordinationState coordinationState = createCoordinationState(  
        final RemoteClusterStateService remoteClusterStateService = Mockito.mock(RemoteClusterStateService.class);
                .add(node1)
        initialStateNode1 = clusterState(0L, 0L, node1, VotingConfiguration.EMPTY_CONFIG, VotingConfiguration.EMPTY_CONFIG, 42L);
        long version,
        assertThat(
            initialConfig,
    public void testHandlePublishResponseWithoutCommitedConfigQuorum() {  
    }
        );  
        );  
        cs1.setInitialState(state1);
            copy.addVote(createNode(randomAlphaOfLength(10)));
        persistedStateRegistry.addPersistedState(
    }
        assertFalse(  
    }
            assertTrue(cs1.handleJoin(v1));  
            .build();
            42L  
            43L
            containsString("does not match current term")
        assertTrue(cs1.handleJoin(v2));
        persistedStateRegistry.addPersistedState(PersistedStateType.LOCAL, new InMemoryPersistedState(0L, initialStateNode2));  
                .clusterManagerNodeId(node1.getId())
                () -> cs1.handleCommit(new ApplyCommitRequest(node1, startJoinRequest1.getTerm(), randomLongBetween(3, 10)))
        );  
        ArgumentCaptor<ClusterState> clusterStateCaptor = ArgumentCaptor.forClass(ClusterState.class);
        assertTrue(cs1.handleJoin(v2));
    }
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
                .version(version)
                .mapToObj(i -> new DiscoveryNode("node_" + i, buildNewFakeTransportAddress(), Version.CURRENT))
            persistedStateRegistry,
    public void testHandlePublishRequest() {
            .nodeId(node1.getId())
    ) {
        final ClusterMetadataManifest manifest = ClusterMetadataManifest.builder()
        // check that another join does not mess with lastPublishedVersion
        cs1.handleClientValue(state2);
        Join v1 = cs1.handleStartJoin(startJoinRequest1);
        cs1.handlePublishRequest(new PublishRequest(state3));
        persistedStateRegistry.addPersistedState(PersistedStateType.LOCAL, new InMemoryPersistedState(0L, initialStateNode2));  
        assertThat(
            .previousClusterUUID(randomAlphaOfLength(10))  
/*  
        assertEquals(cs1.getLastPublishedVersion(), 0L);  
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node1, randomLongBetween(1, 5));
 *  
        ClusterState state2 = clusterState(
        assertEquals(cs1.getLastPublishedVersion(), cs1.getLastAcceptedVersion());
            value
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT;  
        VotingConfiguration lastCommittedConfig,
        Join v1 = cs1.handleStartJoin(startJoinRequest1);  
        assertEquals(state2.version(), publishResponse.getVersion());
        cs1.setInitialState(state1);  
                () -> cs1.handlePublishResponse(randomFrom(node1, node2, node3), new PublishResponse(term, publishResponse.getVersion()))
            PersistedStateType.REMOTE,
        cs2.handleStartJoin(startJoinRequest2);  
            )  
        DiscoveryNode clusterManagerNode,
    }  
import org.opensearch.repositories.fs.FsRepository;  
            ? randomLongBetween(startJoinRequest1.getTerm() + 1, 10)
                .add(nodeWithPub)
        assertTrue(cs1.handleJoin(v1));
        ClusterState state2 = clusterState(startJoinRequest1.getTerm(), randomLongBetween(2, 20), node1, initialConfig, initialConfig, 42L);
                .build(),  
            initialConfig,  
        PublishRequest publishRequest = cs1.handleClientValue(state2);
                .build(),
            .codecVersion(1)  
            node1,
        final CoordinationState.VoteCollection voteCollection = new CoordinationState.VoteCollection();  
        assertThat(applyCommit.get().getTerm(), equalTo(state2.term()));
            term,  
            lastAcceptedConfig,
        );
        cs1.handleStartJoin(startJoinRequest2);
    public void testHandleClientValueWithDifferentReconfigurationWhileAlreadyReconfiguring() {
        );  
            initialConfig,
            .globalMetadataFileName(randomAlphaOfLength(10))
        final ClusterMetadataManifest manifest = ClusterMetadataManifest.builder()  
        long value
                .clusterManagerNodeId(node1.getId())  
            .stateVersion(state2.version())  
        assertThat(
        assertThat(clusterStateCaptor.getValue().stateUUID(), equalTo(committedClusterState.stateUUID()));  
            expectThrows(CoordinationStateRejectedException.class, () -> cs1.handlePublishRequest(new PublishRequest(state2))).getMessage(),
                .add(node1)
            .globalMetadataFileName(randomAlphaOfLength(10))
        ClusterState initialStateNode3 = clusterState(  
        cs1.setInitialState(state1);  
        assertFalse(cs1.handleJoin(join));
        assertThat(
        Join v1 = cs1.handleStartJoin(startJoinRequest1);  
            voteCollection.addVote(
        );
        Join v1 = cs1.handleStartJoin(startJoinRequest1);  
        );  
        coordinationState.setInitialState(state1);
                        .coordinationMetadata(  
        assertTrue(cs1.handleJoin(v1));  
        Mockito.verify(persistedStateRegistrySpy, Mockito.times(0)).getPersistedState(PersistedStateType.REMOTE);
        assertThat(  
    }  
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
        cs1.setInitialState(state1);
        assertTrue(cs1.handleJoin(join));
        cs1 = createCoordinationState(psr1, node1, Settings.EMPTY);
        );
            7L
                .version(randomLongBetween(1, 10))  
            newConfig,
        voteCollection.addVote(node1);
        );  
            expectThrows(CoordinationStateRejectedException.class, () -> cs1.handleJoin(v1)).getMessage(),
        initialStateNode2 = clusterState(0L, 0L, node2, VotingConfiguration.EMPTY_CONFIG, VotingConfiguration.EMPTY_CONFIG, 42L);
    }
                .build(),  
        assertTrue(cs1.containsJoinVoteFor(node1));  
        assertThat(value(cs1.getLastAcceptedState()), equalTo(13L));
        cs1.setInitialState(state1);
        ClusterState state2 = clusterState(startJoinRequest1.getTerm(), randomLongBetween(2, 20), node1, initialConfig, initialConfig, 42L);
            initialConfig,
        );
        long term,
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node2, randomLongBetween(1, 5));
            containsString("election not won")  
import static org.hamcrest.Matchers.containsString;
        Join join = cs1.handleStartJoin(startJoinRequest);
            remotePublicationSettings()
        ClusterState state2 = clusterState(startJoinRequest1.getTerm(), 2L, node1, initialConfig, initialConfig, 42L);
            ElectionStrategy.DEFAULT_INSTANCE  
            .clusterUUID(randomAlphaOfLength(10))
    }
        cs1.setInitialState(state1);
        return setValue(
    }
                    .persistentSettings(Settings.builder().put(clusterState.metadata().persistentSettings()).put("value", value).build())  
        assertEquals(cs1.getLastPublishedVersion(), 0L);
        assertTrue(voteCollection.isQuorum(VotingConfiguration.of(node1)));
        assertTrue(coordinationState.electionWon());  
        );
        assertThat(cs1.getCurrentTerm(), equalTo(startJoinRequest1.getTerm()));
            DiscoveryNodes.builder()
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
    public void testJoinWithLowerLastAcceptedTermWinsElection() {
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(applyCommit.get().getSourceNode(), equalTo(node1));  
        if (randomBoolean()) {
        assertThat(  
        );
        ClusterState state2 = clusterState(startJoinRequest1.getTerm(), 2L, node1, initialConfig, initialConfig, 7L);
        cs1.handleStartJoin(startJoinRequest1);  
        Join v1 = cs1.handleStartJoin(startJoinRequest1);
        if (randomBoolean()) {
            "node.attr." + REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,
    public void testHandlePrePublishAndCommitWhenRemoteStateEnabled() throws IOException {
        }
        verifyNoInteractions(remoteClusterStateService);
        String randomRepoName = "randomRepoName";
        assertTrue(cs1.electionWon());
        StartJoinRequest startJoinRequest2 = new StartJoinRequest(  
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);  
            persistedStateRegistry,
        persistedStateRegistry.addPersistedState(PersistedStateType.LOCAL, new InMemoryPersistedState(0L, clusterState));  
        assertThat(cs1.getLastAcceptedState(), equalTo(state2));
            node3,  
        assertTrue(cs1.handleJoin(v3));  
        Join v2 = cs2.handleStartJoin(startJoinRequest1);  
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node1, randomLongBetween(1, 5));
            .opensearchVersion(Version.CURRENT)
            new RemotePersistedState(remoteClusterStateService, state1.metadata().clusterUUID())  
            DiscoveryNodes.builder()
            .clusterUUIDCommitted(true)
        ClusterState state3 = clusterState(startJoinRequest1.getTerm(), 3L, node1, initialConfig, newConfig1, 42L);  
    public void testStartJoinBeforeBootstrap() {
        VotingConfiguration initialConfig = VotingConfiguration.of(node1, nodeWithPub);  
        assertTrue(cs1.electionWon());
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
        VotingConfiguration configNode1 = VotingConfiguration.of(node1);
            startJoinRequest1.getTerm(),  
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node1, randomLongBetween(1, 5));  
        StartJoinRequest startJoinRequest = new StartJoinRequest(nodeWithPub, newTerm);
        assertFalse(cs1.containsJoinVoteFor(node2));
    public void testSetInitialState() {
            .build();
            new RemotePersistedState(remoteClusterStateService, state1.metadata().clusterUUID())  
        PublishResponse publishResponse = cs1.handlePublishRequest(publishRequest);
            : randomLongBetween(0, startJoinRequest1.getTerm() - 1);
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfiguration;  
        coordinationState.handlePublishRequest(new RemoteStatePublishRequest(publishRequest.getAcceptedState(), manifest));
    public void testRemotePersistedStateResetsForPublicationEnabledAfterLocalPublication() {  
        ApplyCommitRequest applyCommitRequest = new ApplyCommitRequest(node2, state2.term(), state2.version());  
        VotingConfiguration configNode2 = VotingConfiguration.of(node2);
        final VotingConfiguration initialConfig = VotingConfiguration.of(node1);
            cs1.setInitialState(state1);
            2L,
                CoordinationStateRejectedException.class,
        assertThat(v1.getSourceNode(), equalTo(node1));  
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
    private DiscoveryNode node3;  
            CoordinationState.VoteCollection copy = copyFunction.copy(vc);
        StartJoinRequest startJoinRequest2 = new StartJoinRequest(node2, randomLongBetween(startJoinRequest1.getTerm() + 1, 10));  
        PublishResponse publishResponse = coordinationState.handlePublishRequest(new RemoteStatePublishRequest(state2, manifest));
        assertTrue(cs1.electionWon());  
            expectThrows(
        assertThat(publishResponse.getTerm(), equalTo(state2.term()));
import org.opensearch.gateway.remote.model.RemoteClusterStateManifestInfo;
        VotingConfiguration newConfig = VotingConfiguration.of(node1, nodeWithPub, node3);
    private static PersistedStateRegistry createPersistedStateRegistry(ClusterState clusterState) {
        DiscoveryNode localNode,  
        assertTrue(cs1.handleJoin(v1));  
        Join v1 = cs1.handleStartJoin(startJoinRequest1);
        assertFalse(cs1.electionWon());
    private PersistedState ps1;  
    public void testHandleClientValueDuringOngoingPublication() {
            42L
        ClusterState state2 = clusterState(startJoinRequest1.getTerm(), randomLongBetween(2, 20), node1, initialConfig, initialConfig, 42L);  
        assertEquals(cs1.getLastPublishedVersion(), cs1.getLastAcceptedVersion());
        ClusterState state2 = clusterState(  
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);  
            DiscoveryNodes.builder().add(localNode).localNodeId(localNode.getId()).build(),
        );
import java.util.Locale;
            return copy;  
        assertTrue(cs1.handleJoin(v2));
            .indices(Collections.emptyList())
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
            containsString("does not match current term")  
 * specific language governing permissions and limitations
            containsString("higher than current last accepted version")
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
            node1,
        cs1.setInitialState(state1);  
        Join v1 = cs1.handleStartJoin(startJoinRequest1);
        assertThat(cs1.getCurrentTerm(), equalTo(0L));
            .clusterUUIDCommitted(true)
            VotingConfiguration.EMPTY_CONFIG,
        cs1.handlePublishResponse(node1, publishResponse);
        );
    public void testHandlePublishRequestWithSameTermButOlderOrSameVersion() {
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
            : randomLongBetween(0, startJoinRequest1.getTerm() - 1);  
        Join v1 = cs1.handleStartJoin(startJoinRequest2);
        );  
        ClusterState state2 = clusterState(startJoinRequest1.getTerm(), 2L, node1, newConfig, newConfig, 42L);
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(randomFrom(node1, node2), randomLongBetween(1, 5));  
            Version.CURRENT  
        });
        assertFalse(cs1.handleJoin(join));  
        assertThat(
                Metadata.builder(clusterState.metadata())
        long term,
        Join v1 = cs1.handleStartJoin(startJoinRequest1);
                .getMessage(),
        assertThat(v1.getTargetNode(), equalTo(startJoinRequest1.getSourceNode()));
        assertThat(
        );
        VotingConfiguration lastCommittedConfig,
            expectThrows(CoordinationStateRejectedException.class, () -> cs1.handleClientValue(state1)).getMessage(),
        assertTrue(cs1.handleJoin(v1));
    public static DiscoveryNode createNode(String id) {  
        assertThat(
        assertEquals(state2.term(), publishResponse.getTerm());
        assertTrue(cs1.containsJoinVoteFor(node1));
            initialConfig,
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node1, randomLongBetween(1, 5));
        PublishRequest publishRequest = cs1.handleClientValue(state2);  
        assertEquals(cs1.getLastPublishedVersion(), 0L);
            42L
        assertFalse(applyCommit.isPresent());  
            .put(RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), true)  
                .clusterManagerNodeId(node1.getId())
            randomNonNegativeLong()
        PublishResponse publishResponse = cs1.handlePublishRequest(publishRequest);  
                )
import java.util.Map;
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node1, randomLongBetween(1, 5));
            ).getMessage(),
            42L  
        assertNull(persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE).getLastAcceptedState());
    // scenario when handling a publish request from a fresh cluster-manager
        coordinationState.handleCommit(applyCommitRequest);
        }
    }
        cs1.setInitialState(state1);  
        assertTrue(state1.getLastCommittedConfiguration().hasQuorum(Collections.singleton(node1.getId())));
 *
            randomLongBetween(state2.getVersion() + 1, 20),
        assertTrue(coordinationState.handleJoin(v1));
        Join v1 = cs1.handleStartJoin(startJoinRequest1);
        Join v1 = cs1.handleStartJoin(startJoinRequest1);  
            new RemotePersistedState(remoteClusterStateService, state1.metadata().clusterUUID())
        assertTrue(cs1.handleJoin(v1));
            "nodeWithPub",
        assertThat(cs1.getLastCommittedConfiguration(), equalTo(newConfig));  
import org.mockito.Mockito;
            address.getAddress(),
        assertTrue(cs1.handleJoin(v2));
                            CoordinationMetadata.builder()
        );
        assertEquals(state2, persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE).getLastAcceptedState());
    public static DiscoveryNode createNode(String id, Map<String, String> attributes) {
            .build();  
            CoordinationState.VoteCollection voteCollection1 = new CoordinationState.VoteCollection();  
        cs1.setInitialState(state1);
        assertThat(  
        Join v1 = cs1.handleStartJoin(startJoinRequest1);  
        coordinationState.handlePrePublish(clusterState);  
        return clusterState.metadata().persistentSettings().getAsLong("value", 0L);
        Join v2 = coordinationState.handleStartJoin(startJoinRequest);
            expectThrows(CoordinationStateRejectedException.class, () -> cs1.handleClientValue(state3)).getMessage(),  
            randomLongBetween(0, startJoinRequest1.getTerm())
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node2, randomLongBetween(1, 5));
        );  
    }  
    public void setupNodes() {
        return clusterState(
        assertTrue(cs1.handleJoin(v1));  
    }  
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node2, randomLongBetween(1, 5));  
        Join v2 = cs2.handleStartJoin(startJoinRequest1);
                .localNodeId(nodeWithPub.getId())
        cs1.setInitialState(state1);  
            containsString("this node has not received its initial configuration yet")
            .build();
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);  
    }
        ClusterState state1 = clusterState(
    }  
        node1 = createNode("node1");  
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
    public void testHandlePrePublishAndCommitWhenRemoteStateDisabled() {
        cs1.setInitialState(state1);  
        assertTrue(cs1.handleJoin(v1));
        return Settings.builder().put(remoteStateSettings()).put(REMOTE_PUBLICATION_SETTING_KEY, true).build();  
 *     http://www.apache.org/licenses/LICENSE-2.0
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
            ).getMessage(),
        cs1.handleClientValue(state3);
        assertTrue(applyCommit.isPresent());  
            initialConfig,
        new CoordinationStateTestCluster(
        assertThat(v1.getLastAcceptedTerm(), equalTo(state1.term()));
        StartJoinRequest startJoinRequest2 = new StartJoinRequest(node2, randomLongBetween(startJoinRequest1.getTerm() + 1, 10));
 */
        cs1.handlePublishRequest(new PublishRequest(state2));
    public void testHandleClientValueWithBadTerm() {
        );  
    public void testHandlePublishResponseWithoutCommit() {  
        );
        EqualsHashCodeTestUtils.CopyFunction<CoordinationState.VoteCollection> copyFunction = vc -> {
        };
    public void testHandleCommitWithBadLastAcceptedTerm() {
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);  
                .metadata(
        assertTrue(cs1.handleJoin(v1));  
import org.opensearch.cluster.ClusterName;
        Join v1 = cs1.handleStartJoin(startJoinRequest1);
        ClusterState state3 = clusterState(
        coordinationState.setInitialState(state1);
    private CoordinationState cs3;
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node1, randomLongBetween(1, 5));
    }
                ""  
import java.util.Optional;  
        assertTrue(voteCollection.containsVoteFor(node1));
            remotePublicationSettings()  
    }
        Join v1 = cs1.handleStartJoin(startJoinRequest1);
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);  
    public void testHandleCommit() {
                () -> cs1.handlePublishResponse(randomFrom(node1, node2, node3), publishResponse)
                .localNodeId(nodeWithPub.getId())
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);  
import static org.mockito.Mockito.verify;
            expectThrows(CoordinationStateRejectedException.class, () -> cs1.setInitialState(state1)).getMessage(),
        verifyNoInteractions(remoteClusterStateService);
        assertThat(publishRequest.getAcceptedState(), equalTo(state2));
            DiscoveryNodeRole.BUILT_IN_ROLES,
        assertFalse(voteCollection.isEmpty());
/*
            .build();
            ? randomLongBetween(startJoinRequest1.getTerm() + 1, 10)
        assertTrue(cs1.handleJoin(v1));
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);  
        cs1.setInitialState(state1);
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
        ClusterState state2 = clusterState(startJoinRequest1.getTerm(), randomLongBetween(2, 10), node1, initialConfig, initialConfig, 42L);
        cs1.handlePublishRequest(new PublishRequest(state2));  
                .add(node1)  
            .clusterTerm(1L)
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
    public void testHandlePublishRequestWithBadTerm() {
    @Before
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
        when(remoteClusterStateService.writeFullMetadata(clusterState, previousClusterUUID)).thenReturn(  
        PublishRequest publishRequest = cs1.handleClientValue(state2);
                .nodes(discoveryNodes)
        assertThat(persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE), nullValue());
        Join v1 = cs1.handleStartJoin(startJoinRequest1);
        );
            Locale.getDefault(),
        assertTrue(applyCommit.isPresent());
import org.opensearch.gateway.remote.RemoteClusterStateService;
                voteCollection1.addVote(node);
    public void testHandleCommitOnFollowerNodeWhenRemotePublicationEnabled() {  
            "",
        long term,
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);  
            randomFrom(node1, node2),
    public void testJoinWithHigherAcceptedTerm() {  
            ).getMessage(),  
        persistedStateRegistry.addPersistedState(
                    Metadata.builder(state1.metadata())
        assertThat(persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE), nullValue());
    // scenario when handling a publish request from a cluster-manager that we already received a newer state from
            .previousClusterUUID(randomAlphaOfLength(10))  
        psr1 = persistedStateRegistry();
        assertThat(cs1.getCurrentTerm(), equalTo(startJoinRequest1.getTerm()));  
        assertFalse(cs1.containsJoin(v2));  
        cs1.setInitialState(state1);
                                .lastAcceptedConfiguration(lastAcceptedConfig)
            0L,  
        cs1.setInitialState(state1);
import static org.mockito.Mockito.times;  
import org.opensearch.cluster.node.DiscoveryNodes;  
            containsString("does not match last accepted term")
        );
        Join join = cs1.handleStartJoin(startJoinRequest);
        assertFalse(voteCollection.containsVoteFor(node3));  
        cs1.handleCommit(applyCommit.get());
        ClusterState state1 = clusterState(0L, 0L, node1, configNode2, configNode1, 42L);  
    private DiscoveryNode nodeWithPub;
        cs1 = createCoordinationState(psr1, node1, Settings.EMPTY);
        ClusterState state2 = clusterState(startJoinRequest1.getTerm(), 2L, node1, initialConfig, newConfig1, 42L);
        cs1.setInitialState(state1);  
        assertTrue(cs1.electionWon());  
            initialConfig,
            .clusterTerm(0L)
        EqualsHashCodeTestUtils.checkEqualsAndHashCode(voteCollection, copyFunction, vc -> {  
        assertTrue(voteCollection.containsVoteFor(node1));  
        cs1.handlePublishRequest(new PublishRequest(state2));
        cs1.setInitialState(state1);  
        assertTrue(cs1.handleJoin(v1));
    }
            }  
    }
        ps1 = new InMemoryPersistedState(0L, initialStateNode1);  
        assertTrue(cs1.electionWon());
        final RemoteClusterStateService remoteClusterStateService = Mockito.mock(RemoteClusterStateService.class);
        assertTrue(voteCollection.isEmpty());
        );
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node1, randomLongBetween(1, 5));
            UUIDs.randomBase64UUID(random()), // generated deterministically for repeatable tests  
        Join v2 = cs2.handleStartJoin(startJoinRequest1);
    public static ClusterState clusterState(  
import static org.mockito.ArgumentMatchers.any;
        PublishResponse publishResponse = cs1.handlePublishRequest(publishRequest);  
        Join v1 = cs1.handleStartJoin(startJoinRequest1);  
                .add(clusterManagerNode)
                .clusterManagerNodeId(node1.getId())  
            DiscoveryNodes.builder()  
        Join join = new Join(node1, node1, v1.getTerm(), state2.term(), randomLongBetween(0, state2.version()));  
        assertThat(cs1.getLastCommittedConfiguration(), equalTo(initialConfig));
}
import org.opensearch.cluster.metadata.Metadata;  
            value
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
 * not use this file except in compliance with the License.
    public void testJoinWithWrongTarget() {  
import org.opensearch.gateway.GatewayMetaState.RemotePersistedState;
            containsString("last committed configuration should not change")
        assertThat(expectThrows(AssertionError.class, () -> cs1.handleJoin(v1)).getMessage(), containsString("wrong node"));
        final RemoteClusterStateService remoteClusterStateService = Mockito.mock(RemoteClusterStateService.class);  
        assertEquals(state2.term(), publishResponse.getTerm());  
        persistedStateRegistry.addPersistedState(PersistedStateType.LOCAL, ps1);  
        persistedStateRegistry.addPersistedState(  
    }
    private static Settings remotePublicationSettings() {
        VotingConfiguration lastAcceptedConfig,
                .add(node1)
import static org.mockito.ArgumentMatchers.eq;  
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
                .add(nodeWithPub)  
            )
        assertThat(cs1.getLastAcceptedState(), equalTo(state1));
            return voteCollection1;
import org.opensearch.test.OpenSearchTestCase;
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node1, randomLongBetween(1, 5));  
        assertThat(
    }  
    }
        assertEquals(coordinationState.getLastCommittedConfiguration(), newConfig);  
            .metadata(Metadata.builder(clusterState.metadata()).clusterUUIDCommitted(true).build())  
        assertThat(v1.getLastAcceptedTerm(), equalTo(initialStateNode1.term()));
import static org.hamcrest.Matchers.nullValue;
        );  
            containsString("does not match current version")
        assertFalse(cs1.handleJoin(join));  
        assertTrue(cs1.electionWon());
            remotePublicationSettings()  
            .clusterUUID(state2.metadata().clusterUUID())
        );
            containsString("does not match current term")  
        cs2.handlePublishRequest(new PublishRequest(state1));
    public void testHandleClientValueWithSameReconfigurationWhileAlreadyReconfiguring() {  
        long term = randomBoolean()
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node1, randomLongBetween(1, 5));  
        assertThat(
import org.junit.Before;  
        final ClusterState clusterState = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
        assertThat(  
        verifyNoInteractions(remoteClusterStateService);
        );
    public void testJoinWithNoStartJoinAfterReboot() {
        assertTrue(coordinationState.electionWon());
        cs1.setInitialState(state1);
        assertThat(
        String stateRepoSettingsAttributeKeyPrefix = String.format(
        );
                                .lastCommittedConfiguration(lastCommittedConfig)  
                .build(),  
            randomRepoName  
        VotingConfiguration newConfig = VotingConfiguration.of(node2);  
 * You may obtain a copy of the License at  
            containsString("lower or equal to last published version")  
        persistedStateRegistry.addPersistedState(PersistedStateType.LOCAL, new InMemoryPersistedState(0L, initialStateNode2));  
                .clusterManagerNodeId(node1.getId())
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY;
        assertThat(
            containsString("ignored join as term has not been incremented yet after reboot")
        ClusterState state2 = clusterState(startJoinRequest1.getTerm(), 2L, node1, configNode1, configNode2, 42L);
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node1, randomLongBetween(1, 5));  
        cs2 = createCoordinationState(createPersistedStateRegistry(initialStateNode2), node2, Settings.EMPTY);
        assertThat(v1.getLastAcceptedVersion(), equalTo(state1.version()));
package org.opensearch.cluster.coordination;
        Join v1 = cs1.handleStartJoin(startJoinRequest);
        node2 = createNode("node2");
        PublishResponse publishResponse = coordinationState.handlePublishRequest(new PublishRequest(state2));
            0L,
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
        cs1.setInitialState(state1);
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
        long newTerm = randomLongBetween(1, 10);  
        );
        );
        Join v1 = cs1.handleStartJoin(startJoinRequest1);
        return persistedStateRegistry;
    public void testHandlePublishResponseWithoutPublishConfigQuorum() {  
    }
        ClusterState state3 = clusterState(startJoinRequest1.getTerm(), 3L, node1, initialConfig, initialConfig, 42L);
            lastCommittedConfig,  
        Join v1 = cs1.handleStartJoin(startJoinRequest2);
            expectThrows(CoordinationStateRejectedException.class, () -> cs1.handleCommit(new ApplyCommitRequest(node1, term, 2L)))
        Settings settings = Settings.builder()
        PublishRequest publishRequest = cs1.handleClientValue(state2);
        ClusterState state2 = clusterState(startJoinRequest1.getTerm(), randomLongBetween(1, 10), node1, initialConfig, initialConfig, 13L);  
    public void testHandlePublishResponseWithBadTerm() {  
            equalTo(committedClusterState.metadata().clusterUUIDCommitted())
 * software distributed under the License is distributed on an
        );
        PublishRequest publishRequest = cs1.handleClientValue(state2);
    public void testJoinWithSameLastAcceptedTermButLowerOrSameVersionWinsElection() {  
    public static long value(ClusterState clusterState) {  
    private static Settings remoteStateSettings() {
        assertFalse(voteCollection.containsVoteFor(node2));
        assertTrue(cs1.electionWon());
        Join v1 = cs1.handleStartJoin(startJoinRequest1);
            containsString("only allow reconfiguration while not already reconfiguring")
        cs1.setInitialState(state1);  
/*
                .clusterManagerNodeId(node1.getId())
            .build();
        VotingConfiguration newConfig2 = VotingConfiguration.of(node3);
            expectThrows(
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node1, randomLongBetween(1, 5));  
            expectThrows(CoordinationStateRejectedException.class, () -> cs1.handleClientValue(state2)).getMessage(),  
        );  
        assertTrue(cs1.handleJoin(join));
        assertTrue(state1.getLastCommittedConfiguration().hasQuorum(Collections.singleton(node1.getId())));
            assertTrue(cs1.handleJoin(v1));  
 * GitHub history for details.
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);  
        assertFalse(cs1.electionWon());  
    public void testHandlePublishResponseWithVersionMismatch() {
        String stateRepoTypeAttributeKey = String.format(  
        ClusterState state1 = clusterState(0L, 0L, node1, configNode1, configNode2, 42L);
        Optional<ApplyCommitRequest> applyCommit = cs1.handlePublishResponse(node2, publishResponse);
    public void testHandlePublishRequestWithTermHigherThanLastAcceptedTerm() {
        VotingConfiguration newConfig1 = VotingConfiguration.of(node2);
            for (DiscoveryNode node : vc.nodes()) {
            clusterStateCaptor.getValue().coordinationMetadata().term(),
import static java.util.Collections.emptySet;
                REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY,
            expectThrows(CoordinationStateRejectedException.class, () -> cs1.handleClientValue(state2)).getMessage(),
import org.opensearch.cluster.node.DiscoveryNode;
            equalTo(committedClusterState.coordinationMetadata().term())  
        Optional<ApplyCommitRequest> applyCommit = cs1.handlePublishResponse(node1, publishResponse);
        VotingConfiguration lastAcceptedConfig,  
            .indices(Collections.emptyList())
        // cluster manager is node1 and node2 is a follower node
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
        final PersistedStateRegistry persistedStateRegistry = persistedStateRegistry();
        cs1.setInitialState(state1);
        PublishRequest publishRequest = cs1.handleClientValue(state2);  
 * SPDX-License-Identifier: Apache-2.0
        cs1.handleStartJoin(startJoinRequest1);
        final VotingConfiguration initialConfig = VotingConfiguration.of(node1);  
            v1.getTerm(),  
            0L,
        assertFalse(cs1.electionWon());
    public void testHandleCommitWithBadCurrentTerm() {  
            startJoinRequest.getTerm(),  
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
            initialConfig,  
    public static ClusterState clusterState(  
 * license agreements. See the NOTICE file distributed with
        Join v2 = cs2.handleStartJoin(startJoinRequest1);
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);  
        Join v1 = cs1.handleStartJoin(startJoinRequest1);
        Join v1 = cs1.handleStartJoin(startJoinRequest1);
            .clusterUUID(state2.metadata().clusterUUID())  
                CoordinationStateRejectedException.class,  
            nodeWithPub,
        assertTrue(cs1.containsJoin(join));  
    }
        assertTrue(cs1.handleJoin(v1));
                .collect(Collectors.toList()),
            ? randomLongBetween(startJoinRequest1.getTerm() + 1, 10)  
        ClusterState state2 = clusterState(startJoinRequest1.getTerm(), randomLongBetween(2, 20), node1, initialConfig, initialConfig, 42L);
        return new DiscoveryNode(  
        assertThat(clusterStateCaptor.getValue().metadata().clusterUUID(), equalTo(committedClusterState.metadata().clusterUUID()));
            containsString("only allow reconfiguration if joinVotes have quorum for new config")
public class CoordinationStateTests extends OpenSearchTestCase {
    public static ClusterState setValue(ClusterState clusterState, long value) {
        node3 = createNode("node3");
        cs1.setInitialState(state1);
        assertThat(  
            nodeWithPub,
            PersistedStateType.REMOTE,
            .committed(false)
        StartJoinRequest startJoinRequest3 = new StartJoinRequest(randomFrom(node1, node2), startJoinRequest1.getTerm());
        assertThat(  
            expectThrows(CoordinationStateRejectedException.class, () -> cs1.handleJoin(badJoin)).getMessage(),
        assertTrue(coordinationState.handleJoin(v2));  
                .add(nodeWithPub)  
    public static CoordinationState createCoordinationState(
        );  
    private DiscoveryNode node2;
            ).getMessage(),  
        PublishResponse publishResponse = cs1.handlePublishRequest(new PublishRequest(state2));  
        assertNull(persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE).getLastAcceptedManifest());
        assertTrue(voteCollection.isEmpty());
        );
            ).getMessage(),
        StartJoinRequest startJoinRequest2 = new StartJoinRequest(node2, randomLongBetween(startJoinRequest1.getTerm() + 1, 10));  
 * this file be licensed under the Apache-2.0 license or a
            persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE).getLastAcceptedState().metadata().clusterUUIDCommitted()  
        assertTrue(cs1.electionWon());
        PublishRequest publishRequest = coordinationState.handleClientValue(state2);
        assertFalse(cs1.handleJoin(join));
                .localNodeId(nodeWithPub.getId())
        Join v1 = cs1.handleStartJoin(startJoinRequest1);  
            .stateUUID(randomAlphaOfLength(10))
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node1, randomLongBetween(1, 5));  
            randomFrom(node1, node2),  
        StartJoinRequest startJoinRequest = new StartJoinRequest(nodeWithPub, newTerm);
        long version,
        ClusterState state2 = clusterState(startJoinRequest1.getTerm(), 2L, node1, configNode1, configNode2, 42L);
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);  
            assertTrue(cs1.electionWon());
            .stateVersion(state2.version())
            .opensearchVersion(Version.CURRENT)  
        assertThat(v1.getTerm(), equalTo(startJoinRequest1.getTerm()));  
        DiscoveryNode localNode,  
            .metadata(
                .add(node1)
        PublishResponse publishResponse = cs1.handlePublishRequest(publishRequest);  
            ? randomLongBetween(startJoinRequest1.getTerm() + 1, 10)
                REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY,  
        );
        final CoordinationState coordinationState = createCoordinationState(  
        long term = randomBoolean()
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node1, randomLongBetween(1, 5));  
                .metadata(
        VotingConfiguration configNode1 = VotingConfiguration.of(node1);
        ClusterState state2 = clusterState(startJoinRequest1.getTerm(), randomLongBetween(2, 20), node1, initialConfig, initialConfig, 42L);
            .put("node.attr." + REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY, randomRepoName)  
        Join join = new Join(node2, node1, v1.getTerm(), randomLongBetween(0, state2.term()), randomLongBetween(0, state2.version()));  
        cs1.setInitialState(state1);  
        Join v2 = cs2.handleStartJoin(startJoinRequest1);  
    }
        assertTrue(cs1.electionWon());
        ClusterState state2 = setValue(
import static org.mockito.Mockito.spy;
        ).runRandomly();
            version,
 * ownership. Elasticsearch licenses this file to you under  
            PersistedStateType.REMOTE,
        assertFalse(cs1.containsJoinVoteFor(node2));
        when(remoteClusterStateService.markLastStateAsCommitted(any(), any(), eq(false))).thenReturn(
        PersistedState spyRPS = spy(persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE));
                .build(),
    ) {
    private ClusterState initialStateNode2;
        cs1.setInitialState(state1);
        assertTrue(cs1.electionWon());
                        .coordinationMetadata(CoordinationMetadata.builder(state1.coordinationMetadata()).term(newTerm).build())  
        );
        Mockito.verify(persistedStateRegistrySpy, Mockito.times(0)).getPersistedState(PersistedStateType.REMOTE);  
        );
import org.opensearch.cluster.node.DiscoveryNodeRole;
        );
        }
    public void testJoinBeforeBootstrap() {
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);  
    ) {
            7L
                                .build()
        VotingConfiguration configNode2 = VotingConfiguration.of(node2);
                "",
            Locale.getDefault(),  
        VotingConfiguration newConfig1 = VotingConfiguration.of(node2);  
import org.opensearch.test.EqualsHashCodeTestUtils;
        expectThrows(CoordinationStateRejectedException.class, () -> cs1.handleStartJoin(startJoinRequest2));
        cs1.setInitialState(state1);
            randomLongBetween(0, startJoinRequest1.getTerm())
        ClusterState state2 = clusterState(startJoinRequest1.getTerm(), 2L, node1, initialConfig, newConfig, 42L);
        PublishRequest publishRequest = cs1.handleClientValue(state2);  
        assertThat(v1.getSourceNode(), equalTo(node1));
            clusterStateCaptor.getValue().metadata().clusterUUIDCommitted(),
        Mockito.verify(persistedStateRegistrySpy, Mockito.times(0)).getPersistedState(PersistedStateType.REMOTE);
        ClusterState state2 = clusterState(startJoinRequest1.getTerm(), 0L, node1, initialConfig, initialConfig, 42L);  
        ClusterState state2 = clusterState(startJoinRequest2.getTerm(), randomLongBetween(0, 20), node1, initialConfig, initialConfig, 42L);
        long term = randomBoolean()  
        cs1.setInitialState(state1);  
                        .build()
        Join v2 = coordinationState.handleStartJoin(startJoinRequest);  
    }
        Join badJoin = new Join(  
        cs1.handlePublishRequest(new PublishRequest(state2));
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);  
        DiscoveryNode localNode,  
        ClusterState state1 = clusterState(
            .committed(false)
            ClusterState.builder(state1)  
        final PersistedStateRegistry persistedStateRegistry = new PersistedStateRegistry();
        StartJoinRequest startJoinRequest = new StartJoinRequest(nodeWithPub, newTerm);
    }
            PersistedStateType.REMOTE,
            address.address().getHostString(),
            .put(stateRepoSettingsAttributeKeyPrefix + "location", "randomRepoPath")
        cs1.handlePublishRequest(new PublishRequest(state2));
            nodeWithPub,
            initialConfig,
        PersistedStateRegistry persistedStateRegistry,
    }
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node1, randomLongBetween(1, 5));
        VotingConfiguration newConfig = VotingConfiguration.of(node1, nodeWithPub, node3);
            nodeWithPub,
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
    }
        Join v1 = cs1.handleStartJoin(startJoinRequest);  
    }
        cs1.setInitialState(state1);  
            new RemotePersistedState(remoteClusterStateService, state1.metadata().clusterUUID())  
        VotingConfiguration configNode1 = VotingConfiguration.of(node1);
        assertThat(cs1.getLastPublishedVersion(), equalTo(state2.version()));  
    }
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node2, randomLongBetween(1, 5));
 * the Apache License, Version 2.0 (the "License"); you may
            PersistedStateType.REMOTE,
                )
        assertNull(persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE).getLastAcceptedState());  
    public void testJoinDoesNotWinElection() {  
            .put(stateRepoTypeAttributeKey, FsRepository.TYPE)
            42L  
import org.opensearch.cluster.coordination.CoordinationState.PersistedState;
        PublishRequest publishRequest = cs1.handleClientValue(state2);  
                CoordinationStateRejectedException.class,
        ClusterState state3 = clusterState(  
            .stateVersion(0L)  
        cs1.handlePublishRequest(publishRequest);
import static org.mockito.Mockito.when;  
            version,
        final CoordinationState coordinationState = createCoordinationState(  
        final CoordinationState coordinationState = createCoordinationState(persistedStateRegistry, node1, remoteStateSettings());
        );  
        );  
    public void testHandleCommitOnFollowerNodeWhenRemotePublicationEnabledWithNullRemotePersistedState() {
            .clusterUUIDCommitted(true)  
        Join v1 = cs1.handleStartJoin(startJoinRequest1);
            .stateUUID(randomAlphaOfLength(10))
    ) {
import org.opensearch.cluster.ClusterState;
            : randomLongBetween(0, startJoinRequest1.getTerm() - 1);
        assertThat(  
    }
            .codecVersion(1)
            .opensearchVersion(Version.CURRENT)  
    }
        assertTrue(voteCollection.isQuorum(VotingConfiguration.of(node1, node2)));
        Join v1 = cs1.handleStartJoin(startJoinRequest2);
 * The OpenSearch Contributors require contributions made to  
        }  
            0L,
            containsString("cannot start publishing next value before accepting previous one")
        cs2.handlePublishRequest(new PublishRequest(state2));
            address,  
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node1, randomLongBetween(1, 5));
            randomLongBetween(0, state2.version()),
            VotingConfiguration.EMPTY_CONFIG,
        assertTrue(state1.getLastAcceptedConfiguration().hasQuorum(Collections.singleton(node1.getId())));
        if (randomBoolean()) {
        long term = randomBoolean()  
    private PersistedStateRegistry psr1;
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
                .metadata(  
        ClusterState state2 = clusterState(startJoinRequest1.getTerm(), 2L, node1, initialConfig, initialConfig, 42L);
        persistedStateRegistry.addPersistedState(PersistedStateType.LOCAL, new InMemoryPersistedState(0L, initialStateNode2));
        ClusterState state2 = clusterState(term, 2L, node1, initialConfig, initialConfig, 42L);
        ClusterState state2 = setValue(
                .build(),
            assertTrue(cs1.electionWon());
        VotingConfiguration lastCommittedConfig,
        Join v1 = cs1.handleStartJoin(startJoinRequest1);
                .localNodeId(localNode.getId())  
            .globalMetadataFileName(randomAlphaOfLength(10))  
        cs1.handleStartJoin(startJoinRequest1);  
            initialConfig,
                .add(node1)
        assertTrue(cs1.handleJoin(v2));
            .clusterTerm(1L)
        assertTrue(voteCollection.containsVoteFor(node2));
        );
        coordinationState.handlePreCommit();
            expectThrows(CoordinationStateRejectedException.class, () -> cs1.handleJoin(v1)).getMessage(),  
        PublishResponse publishResponse = cs2.handlePublishRequest(publishRequest);
            randomFrom(node1, node2),
        assertTrue(cs1.containsJoin(v1));
                .clusterManagerNodeId(clusterManagerNode.getId())
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
    }
                .add(nodeWithPub)  
        PublishRequest publishRequest = cs1.handleClientValue(state2);
    }  
                .stateUUID(UUIDs.randomBase64UUID(random())) // generate cluster state UUID deterministically for repeatable tests
        PublishResponse publishResponse = cs1.handlePublishRequest(publishRequest);
            containsString("initial state already set")  
        ClusterState state2 = clusterState(startJoinRequest1.getTerm(), 2L, node1, initialConfig, initialConfig, 42L);
        cs1.handleStartJoin(startJoinRequest1);
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);  
 * this work for additional information regarding copyright
            assertTrue(cs1.electionWon());
    }
    }
        assertFalse(voteCollection.isQuorum(VotingConfiguration.of(node3)));  
        assertTrue(cs1.handleJoin(v2));  
        VotingConfiguration configNode1 = VotingConfiguration.of(node1);
        assertThat(cs1.getLastPublishedVersion(), equalTo(state2.version()));
            initialConfig,
    public void testHandleClientValueWithOldVersion() {  
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);  
    }
        StartJoinRequest startJoinRequest2 = new StartJoinRequest(node1, randomLongBetween(startJoinRequest1.getTerm() + 1, 10));
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);  
            containsString("lower or equal to current version")  
        );
            expectThrows(
import org.opensearch.Version;  
            expectThrows(CoordinationStateRejectedException.class, () -> cs1.handleJoin(badJoin)).getMessage(),  
        Join v2 = cs2.handleStartJoin(startJoinRequest1);  
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY;
        persistedStateRegistry.addPersistedState(PersistedStateType.LOCAL, ps1);
import org.opensearch.cluster.coordination.PersistedStateRegistry.PersistedStateType;
        ClusterState state1 = clusterState(0L, 0L, node1, initialConfig, initialConfig, 42L);
    }  
        assertThat(applyCommit.get().getVersion(), equalTo(state2.version()));
            value
        Join v1 = cs1.handleStartJoin(startJoinRequest1);
    }
        Join v1 = cs1.handleStartJoin(startJoinRequest1);
                .add(nodeWithPub)
        cs1.setInitialState(state1);
            containsString("does not match current term")  
        ClusterState committedClusterState = ClusterState.builder(clusterState)
                CoordinationStateRejectedException.class,
        cs1.handlePublishRequest(new PublishRequest(state2));
            randomFrom(node1, node2),  
        Join v1 = cs1.handleStartJoin(startJoinRequest1);
            .nodeId(node1.getId())
                CoordinationStateRejectedException.class,
        final PersistedStateRegistry persistedStateRegistry = persistedStateRegistry();
        coordinationState.handlePrePublish(clusterState2);  
                .build(),  
            containsString("not greater than current term")
            containsString("election not won")
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
            DiscoveryNodes.builder()
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);
        );
        Settings settings
        assertThat(v1.getTargetNode(), equalTo(startJoinRequest1.getSourceNode()));
        assumeTrue("test only works with assertions enabled", Assertions.ENABLED);
        assertEquals(manifest, persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE).getLastAcceptedManifest());  
        assertTrue(cs1.handleJoin(v1));  
    }
            : randomLongBetween(0, startJoinRequest1.getTerm() - 1);
    public void testHandlePublishRequestOnFollowerWhenRemotePublicationEnabled() {  
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);  
        final String previousClusterUUID = "prev-cluster-uuid";  
        assertTrue(cs1.electionWon());
    public static ClusterState clusterStateWithClusterManager(  
        Optional<ApplyCommitRequest> applyCommit = cs1.handlePublishResponse(node2, publishResponse);
        persistedStateRegistry.addPersistedState(
        long newTerm = randomLongBetween(1, 10);  
            persistedStateRegistry,
        VotingConfiguration initialConfig = VotingConfiguration.of(node1);  
        assertTrue(cs1.handleJoin(join));  
        cs1.setInitialState(state1);
        psr1.addPersistedState(PersistedStateType.LOCAL, ps1);
    public void testStartJoinAfterBootstrap() {
        StartJoinRequest startJoinRequest1 = new StartJoinRequest(node1, randomLongBetween(1, 5));
