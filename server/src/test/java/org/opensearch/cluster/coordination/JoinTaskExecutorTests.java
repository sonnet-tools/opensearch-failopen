        final JoinTaskExecutor joinTaskExecutor = new JoinTaskExecutor(
        final ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
        Settings.builder().build();
            .metadata(Metadata.builder().putCustom(RepositoriesMetadata.TYPE, new RepositoriesMetadata(repositoriesMetadata)))
        assertTrue(taskResult.isSuccess());
        DiscoveryNode joiningNode = newDiscoveryNode(remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO));
            buildNewFakeTransportAddress(),
            UUIDs.base64UUID(),
import java.util.ArrayList;
            if (nodeAttribute.getKey() != REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY
            remotePublicationNodeAttributes(),
        settingsMap.entrySet().forEach(entry -> settings.put(entry.getKey(), entry.getValue()));
            UUIDs.base64UUID(),
            actualNode.getAddress(),
            REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,
            }
    @LockFeatureFlag(REMOTE_STORE_MIGRATION_EXPERIMENTAL)
            // we have to stick with the same major
            rerouteService,
        );
    }
 *
    private void validatePublicationRepositoryMetadata(ClusterState updatedState, DiscoveryNode existingNode) throws Exception {
        final DiscoveryNode existingNode = new DiscoveryNode(
                add(routingTableRepo);
        final JoinTaskExecutor joinTaskExecutor = new JoinTaskExecutor(
                        )
            DiscoveryNodeRole.BUILT_IN_ROLES,
    public void testUpdatesRepoPublicationNodeJoinRemoteCluster() throws Exception {
        );
            logger,
        }
            Settings.EMPTY,
        validateRepositoriesMetadata(resultAfterRemoteNodeJoin.resultingState, remoteStoreNode, clusterManagerNode);
            baseVersion
            .build();
        final ClusterStateTaskExecutor.TaskResult taskResult1 = resultAfterRemoteNodeJoin.executionResults.values().iterator().next();
            buildNewFakeTransportAddress(),
            }
        );
        final RepositoriesMetadata repositoriesMetadata = updatedState.metadata().custom(RepositoriesMetadata.TYPE);
        Metadata metadata = Metadata.builder().persistentSettings(mixedModeCompatibilitySettings).build();
        // DocRep node should be able to join a mixed mode
        final DiscoveryNode tooLowJoiningNode = new DiscoveryNode(
    public void testJoinFailedForDecommissionedNode() throws Exception {
            .settings(
                    .add(clusterManagerNode)
        final RemoteStoreNodeService remoteStoreNodeService = new RemoteStoreNodeService(
        final ClusterStateTaskExecutor.TaskResult taskResult = result.executionResults.values().iterator().next();
            Locale.getDefault(),
        // Node roles vary by version, and new roles are suppressed for BWC.
        final JoinTaskExecutor joinTaskExecutor = new JoinTaskExecutor(
            Version.CURRENT
        when(allocationService.adaptAutoExpandReplicas(any())).then(invocationOnMock -> invocationOnMock.getArguments()[0]);
            Version.CURRENT
        final JoinTaskExecutor joinTaskExecutor = new JoinTaskExecutor(
        assertThat(result.executionResults.entrySet(), hasSize(1));
            .localNodeId(currentNode2.getId())
            Version.CURRENT
        JoinTaskExecutor.ensureNodesCompatibility(joiningNode, currentState.getNodes(), currentState.metadata());
    }
import org.opensearch.cluster.routing.RerouteService;
    }
        }
                DiscoveryNodes.builder()
    @LockFeatureFlag(REMOTE_STORE_MIGRATION_EXPERIMENTAL)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            repoName
            );
            .metadata(Metadata.builder().putCustom(RepositoriesMetadata.TYPE, new RepositoriesMetadata(repositoriesMetadata)))
            .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "mixed")
            clusterState,
        DiscoveryNodes currentNodes = DiscoveryNodes.builder()
            remoteStoreNodeService
    }
            .nodes(DiscoveryNodes.builder().add(existingNode).localNodeId(existingNode.getId()).build())
        validatePublicationRepositoryMetadata(result.resultingState, clusterManagerNode);
                    .localNodeId(clusterManagerNode.getId())
        Map<String, String> existingNodeAttributes = remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO);
            null
            .put(MIGRATION_DIRECTION_SETTING.getKey(), RemoteStoreNodeService.Direction.REMOTE_STORE)
        final Version version = randomOpenSearchVersion(random());
        assertTrue(taskResult.isSuccess());
        Map<String, String> existingNodeAttributes = new HashMap<>();
import org.opensearch.cluster.metadata.IndexMetadata;
                remoteStoreNodeAttributes.put(nodeAttribute.getKey(), nodeAttribute.getValue());
        final DiscoveryNode existingNode = new DiscoveryNode(
    private DiscoveryNode newDiscoveryNode(Map<String, String> attributes) {
        assertThat(result.executionResults.entrySet(), hasSize(1));
        ClusterState currentState = ClusterState.builder(ClusterName.DEFAULT)
            randomAlphaOfLength(10),
            }
            new SetOnce<>(mock(RepositoriesService.class))::get,
        assertThat(resultAfterRemoteNodeJoin.executionResults.entrySet(), hasSize(1));
            DecommissionStatus.FAILED,
            remoteStoreNodeAttributes,
        };
        final DiscoveryNode existingNode = new DiscoveryNode(
            .numberOfShards(1)
    public void testJoinClusterWithNonRemoteStoreNodeJoiningNonRemoteStoreCluster() {
        Metadata metadata = Metadata.builder().decommissionAttributeMetadata(decommissionAttributeMetadata).build();
        final RepositoryMetadata routingTableRepo = buildRepositoryMetadata(clusterManagerNode, ROUTING_TABLE_REPO);
            new HashMap<>(),
    }
            .build();
        );
            DiscoveryNodeRole.BUILT_IN_ROLES,
            Settings.EMPTY,
    }
            DiscoveryNode joiningNode = newDiscoveryNode(remoteStoreNodeAttributes);
    }
        final RepositoryMetadata segmentRepositoryMetadata = buildRepositoryMetadata(remoteNode, SEGMENT_REPO);
        final DiscoveryNode joiningNode = new DiscoveryNode(
        );
        Map<String, String> attr = remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO);
        final RerouteService rerouteService = (reason, priority, listener) -> listener.onResponse(null);
        DiscoveryNode joiningNode = newDiscoveryNode(remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO));
                            "a remote store node ["
        metaBuilder.put(indexMetadata, false);
        return new HashMap<>() {
                put(REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY, translogRepoName);
            Version.CURRENT
            randomAlphaOfLength(10),
        );
import org.opensearch.cluster.decommission.DecommissionStatus;
            randomAlphaOfLength(10),
        ClusterState currentState = ClusterState.builder(ClusterName.DEFAULT)
            Version.CURRENT
            remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO),
    public void testPreventJoinClusterWithUnsupportedNodeVersions() {
            .keySet()
            rerouteService,
            repoName
            .put(MIGRATION_DIRECTION_SETTING.getKey(), RemoteStoreNodeService.Direction.REMOTE_STORE)
        );
        );
            .numberOfShards(1)
            rerouteService,
            .stream()
                    SEGMENT_REPO,
                    .add(clusterManagerNode)
            .nodes(DiscoveryNodes.builder().add(existingNode).localNodeId(existingNode.getId()).build())
        DecommissionAttribute decommissionAttribute = new DecommissionAttribute("zone", "zone1");
    private void validateAttributes(Map<String, String> remoteStoreNodeAttributes, ClusterState currentState, DiscoveryNode existingNode) {
    }
    }
            clusterStateRepo
        when(remoteStoreNodeService.updateRepositoriesMetadata(any(), any())).thenReturn(new RepositoriesMetadata(Collections.emptyList()));
            randomAlphaOfLength(10),
            .build();
        List<RepositoryMetadata> repositoriesMetadata = new ArrayList<>() {
            .build();
                putIfAbsent(translogRepositoryTypeAttributeKey, "s3");
            () -> JoinTaskExecutor.ensureNodesCompatibility(joiningNode, currentState.getNodes(), currentState.metadata())
                    .localNodeId(clusterManagerNode.getId())
        final ClusterState result = joinNodeToClusterWithViewMetadata(clusterManagerNode, joiningNode);
            joiningNode1.getVersion(),
    }
        validateRepositoryMetadata(result.resultingState, clusterManagerNode, 2);
        final ClusterStateTaskExecutor.TaskResult taskResult = result.executionResults.values().iterator().next();
            UUIDs.base64UUID(),
            .build();
            } else if (REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY.equals(nodeAttribute.getKey())) {
            segmentRepoName
        attr.putAll(remoteRoutingTableAttributes(ROUTING_TABLE_REPO));
            DiscoveryNodeRole.BUILT_IN_ROLES,
                DiscoveryNodes.builder()
            buildNewFakeTransportAddress(),
            buildNewFakeTransportAddress(),
            UUIDs.base64UUID(),
        );
                    .localNodeId(clusterManagerNode.getId())
            Version.CURRENT
            Version.CURRENT
            remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO),
            buildNewFakeTransportAddress(),
    public void testRemoteRoutingTableNodeJoinNodeWithRemoteAndRoutingRepoDifferenceMixedMode() {
                } else if (repositoriesMetadata.repositories().size() == 3) {
import java.util.stream.Collectors;
        final AllocationService allocationService = mock(AllocationService.class);
        assertEquals("a remote store node [" + joiningNode + "] is trying to join a non remote store cluster", e.getMessage());
    }
    }
        final RerouteService rerouteService = (reason, priority, listener) -> listener.onResponse(null);
        DecommissionStatus decommissionStatus = randomFrom(
            existingNodeAttributes,
        final Settings settings = Settings.builder()
        for (RepositoryMetadata repositoryMetadata : repositoriesMetadata.repositories()) {
        final DiscoveryNode existingNode = new DiscoveryNode(UUIDs.base64UUID(), buildNewFakeTransportAddress(), Version.CURRENT);
                putIfAbsent(clusterStateRepositoryTypeAttributeKey, "s3");
    }
        );
    public void testJoinRemotePubClusterWithRemoteStoreNodes() {
        final ClusterStateTaskExecutor.TaskResult taskResult = result.executionResults.values().iterator().next();
 * Modifications Copyright OpenSearch Contributors. See
                putIfAbsent(translogRepositorySettingsAttributeKeyPrefix + "base_path", "/translog/path");
        expectThrows(IllegalStateException.class, () -> {
        );
        DecommissionAttribute decommissionAttribute = new DecommissionAttribute("zone", "zone-1");
                    || e.getMessage()
            rerouteService,
            .build();
            existingNodeAttributes,
            remoteStoreNodeAttributes,
            attr,
            () -> JoinTaskExecutor.ensureIndexCompatibility(VersionUtils.getPreviousVersion(Version.CURRENT), metadata)
        };
            .nodes(
        DiscoveryNode joiningNode = newDiscoveryNode(newNodeAttributes);
                    .clusterManagerNodeId(clusterManagerNode.getId())
        validateRepositoryMetadata(result.resultingState, clusterManagerNode, 3);
            UUIDs.base64UUID(),
            .nodes(DiscoveryNodes.builder().add(existingNode).localNodeId(existingNode.getId()).build())
            UUIDs.base64UUID(),
import org.opensearch.repositories.RepositoriesService;
        final RemoteStoreNodeService remoteStoreNodeService = new RemoteStoreNodeService(
        final RepositoryMetadata routingTableRepositoryMetadata = buildRepositoryMetadata(publicationNode, ROUTING_TABLE_REPO);
        assertTrue(repositoriesMetadata.repositories().size() == expectedRepositories);
            attr,
            DiscoveryNodeRole.BUILT_IN_ROLES,
    private static final String ROUTING_TABLE_REPO = "routing-table-repo";
import static org.hamcrest.Matchers.is;
        final JoinTaskExecutor joinTaskExecutor = new JoinTaskExecutor(
        ClusterState currentState = ClusterState.builder(ClusterName.DEFAULT)
            Version.CURRENT
 * KIND, either express or implied.  See the License for the
            UUIDs.base64UUID(),
            Exception e = assertThrows(
            throw new Exception("Stack overflow example: checkedExceptionThrower");
                    .add(clusterManagerNode)
import static org.mockito.Mockito.mock;
            buildNewFakeTransportAddress(),
        );
        );
            Settings.EMPTY,
            Version.fromString("6.7.0")
            .add(currentNode2)
            UUIDs.base64UUID(),
        final ClusterStateTaskExecutor.ClusterTasksResult<JoinTaskExecutor.Task> result = joinTaskExecutor.execute(
                validateAttributes(remoteStoreNodeAttributes, currentState, existingNode);
    }
        DiscoveryNode remoteNode = newDiscoveryNode(remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO));
            existingNodeAttributes,
            .put(MIGRATION_DIRECTION_SETTING.getKey(), RemoteStoreNodeService.Direction.REMOTE_STORE)
    }
package org.opensearch.cluster.coordination;
            DecommissionStatus.SUCCESSFUL,
            List.of(new JoinTaskExecutor.Task(remotePublicationNode, "test"))
        final DiscoveryNode existingNode = new DiscoveryNode(
        Settings mixedModeCompatibilitySettings = Settings.builder()
        final DiscoveryNode existingNode = new DiscoveryNode(
        );
            null
import java.util.Locale;
        assertEquals("a remote store node [" + joiningNode + "] is trying to join a non remote store cluster", e.getMessage());
            )
        ClusterState currentState = ClusterState.builder(ClusterName.DEFAULT)
            .nodes(DiscoveryNodes.builder().add(joiningNode).build())
        };
        );
            remoteStoreNodeAttributes.put(nodeAttribute.getKey(), null);
    public void testUpdatesClusterStateWithMultiNodeClusterAndSameRepository() throws Exception {
        };
        final DiscoveryNode existingNode2 = new DiscoveryNode(
            remoteStoreNodeAttributes.put(nodeAttribute.getKey(), null);
        );
            final RepositoryMetadata segmentRepositoryMetadata = buildRepositoryMetadata(existingNode, SEGMENT_REPO);
            clusterState,
            DiscoveryNodeRole.BUILT_IN_ROLES,
            minGoodVersion = minCompatVersion.before(allVersions().get(0)) ? allVersions().get(0) : minCompatVersion;
            randomAlphaOfLength(10)
        final AllocationService allocationService = mock(AllocationService.class);
        assertEquals(reason, exception.getMessage());
    }
            DiscoveryNodeRole.BUILT_IN_ROLES,
            JoinTaskExecutor.ensureNodesCompatibility(justGoodJoiningNode, nodes, metadata);
        attr.putAll(remoteRoutingTableAttributes(ROUTING_TABLE_REPO));
            remoteStoreNodeAttributes.put(nodeAttribute.getKey(), nodeAttribute.getValue());
                    .add(clusterManagerNode)
        String reason = String.format(
        );
            Settings.EMPTY,
        validatePublicationRepositoryMetadata(result.resultingState, clusterManagerNode);
 * You may obtain a copy of the License at
        final RerouteService rerouteService = (reason, priority, listener) -> listener.onResponse(null);
            List.of(new JoinTaskExecutor.Task(joiningNode, "test"))
        DiscoveryNode joiningNode = newDiscoveryNode(attr);
        Metadata metadata = Metadata.builder().decommissionAttributeMetadata(decommissionAttributeMetadata).build();
                put(REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY, clusterStateRepo);
        );
        }
            logger,
            logger,
                    .clusterManagerNodeId(clusterManagerNode.getId())
            UUIDs.base64UUID(),
        JoinTaskExecutor.ensureNodesCompatibility(docrepNode2, currentState.getNodes(), currentState.metadata());
    public void testPreventJoinClusterWithRemoteStoreNodeWithPartialAttributesJoiningRemoteStoreCluster() {
        final RemoteStoreNodeService remoteStoreNodeService = new RemoteStoreNodeService(new SetOnce<>(repositoriesService)::get, null);
            Version.CURRENT
    public void testJoinClusterWithRemoteStoreNodeJoining() {
            actualNode.getVersion()
        );
 * under the License.
        validateRepositoryMetadata(result.resultingState, clusterManagerNode, 2);
                validateAttributes(remoteStoreNodeAttributes, currentState, existingNode);
        final DiscoveryNode existingNode = new DiscoveryNode(
    private ClusterState joinNodeToClusterWithViewMetadata(DiscoveryNode clusterManagerNode, DiscoveryNode joiningNode) throws Exception {
        final ClusterStateTaskExecutor.TaskResult taskResult = result.executionResults.values().iterator().next();
            .build();
    private Map<String, String> remotePublicationNodeAttributes() {
        DiscoveryNodes.Builder builder = DiscoveryNodes.builder();
        final RerouteService rerouteService = (reason, priority, listener) -> listener.onResponse(null);
        };
            .build();
        DecommissionStatus decommissionStatus = randomFrom(
        final DiscoveryNode clusterManagerNode = new DiscoveryNode(UUIDs.base64UUID(), buildNewFakeTransportAddress(), Version.V_3_10_0);
        );
            currentState,
        );
    }
            .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "mixed")
        assertTrue(taskResult.isSuccess());
        DiscoveryNode joiningNode = newDiscoveryNode(new HashMap<>());
            UUIDs.base64UUID(),
            .nodes(DiscoveryNodes.builder().add(existingNode).localNodeId(existingNode.getId()).build())
        final DiscoveryNode joiningNode = new DiscoveryNode(UUIDs.base64UUID(), buildNewFakeTransportAddress(), Version.V_3_9_0);
        attr.putAll(remoteRoutingTableAttributes(ROUTING_TABLE_REPO));
            UUIDs.base64UUID(),
                DiscoveryNodes.builder()
        DiscoveryNode joiningNode = newDiscoveryNode(remoteStateNodeAttributes(CLUSTER_STATE_REPO));
            .build();
        final DiscoveryNode clusterManagerNode = new DiscoveryNode(UUIDs.base64UUID(), buildNewFakeTransportAddress(), Version.V_3_10_0);
            buildNewFakeTransportAddress(),
    public void testPreventJoinClusterWithRemoteStoreNodeJoiningNonRemoteStoreCluster() {
        Exception e = assertThrows(
            Collections.singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
            Version.CURRENT
        DecommissionAttribute decommissionAttribute = new DecommissionAttribute("zone", "zone-1");
        Map<String, String> remoteStoreNodeAttributes = remotePublicationNodeAttributes();
        String translogRepositoryTypeAttributeKey = String.format(
import org.opensearch.test.VersionUtils;
                add(translogRepositoryMetadata);
            List.of(new JoinTaskExecutor.Task(joiningNode, "test"))
            remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO),
        );
            DiscoveryNodeRole.BUILT_IN_ROLES,
        final ClusterStateTaskExecutor.TaskResult taskResult = result.executionResults.values().iterator().next();
            DiscoveryNodeRole.BUILT_IN_ROLES,
            DiscoveryNodeRole.BUILT_IN_ROLES,
        DiscoveryNode joiningNode = newDiscoveryNode(remotePublicationNodeAttributes());
            new HashSet<>(randomSubsetOf(actualNode.getRoles())),
            remoteStoreNodeAttributes,
            .metadata(Metadata.builder().putCustom(ViewMetadata.TYPE, new ViewMetadata(Map.of("logs", view))))
            decommissionAttribute,
    }
            clusterStateRepo
    public void testUpdatesClusterStateWithMultiNodeCluster() throws Exception {
        final JoinTaskExecutor joinTaskExecutor = new JoinTaskExecutor(
import static org.mockito.Mockito.when;
    }
        final AllocationService allocationService = mock(AllocationService.class);
        );
        );
                DiscoveryNodes.builder()
            .build();
            decommissionAttribute,
            .numberOfReplicas(1)
        );
import org.opensearch.common.UUIDs;
            Version.CURRENT
        DiscoveryNode goodRemoteNode = newDiscoveryNode(remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO));
            IllegalStateException.class,
        }
        Map<String, String> existingNodeAttributes = remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO);
            remotePublicationNodeAttributes(),
        DiscoveryNodes nodes = builder.build();
        JoinTaskExecutor.ensureNodesCompatibility(joiningNode2, currentNodes, metadata);
            assertTrue(repositoryMetadata.equalsIgnoreGenerations(repositoriesMetadata.repositories().get(0)));
            REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,
            )
            null
            remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO),
            REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,
                e.getMessage().equals("joining node [" + joiningNode + "] doesn't have the node attribute [" + nodeAttribute.getKey() + "]")
        final ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
    public void testJoinClusterWithDifferentDecommission() {
            IllegalStateException.class,
        final ClusterStateTaskExecutor.ClusterTasksResult<JoinTaskExecutor.Task> result = joinTaskExecutor.execute(
            newNodeAttributes,
                    .build()
            {
                putIfAbsent(routingTableRepositoryTypeAttributeKey, "s3");
            rerouteService,
                if (repositoryMetadata.name().equals(segmentRepositoryMetadata.name())) {
    public void testPreventJoinClusterWithUnsupportedIndices() {
    }
            clusterState,
            final RepositoryMetadata translogRepositoryMetadata = buildRepositoryMetadata(existingNode, TRANSLOG_REPO);
        final AllocationService allocationService = mock(AllocationService.class);
        assertFalse(taskResult.isSuccess());
            .nodes(DiscoveryNodes.builder().add(existingNode).localNodeId(existingNode.getId()).build())
            remoteStoreNodeAttributes,
            existingNodeAttributes,
        );
        final Version minNodeVersion = nodes.getMinNodeVersion();
        };
        final ClusterStateTaskExecutor.ClusterTasksResult<JoinTaskExecutor.Task> result = joinTaskExecutor.execute(
        final DiscoveryNode existingNode = new DiscoveryNode(UUIDs.base64UUID(), buildNewFakeTransportAddress(), Version.CURRENT);
            .nodes(DiscoveryNodes.builder().add(existingNode2).add(existingNode).localNodeId(existingNode.getId()).build())
    public void testPreventJoinClusterWithRemoteStateNodeJoiningRemoteStoreCluster() {
        Settings.builder().build();
            buildNewFakeTransportAddress(),
        if (randomBoolean()) {
    public void testPreventJoinRemotePublicationClusterWithIncompatibleAttributes() {
        String translogRepositorySettingsAttributeKeyPrefix = String.format(
        String clusterStateRepositorySettingsAttributeKeyPrefix = String.format(
        final RepositoryMetadata clusterStateRepo = buildRepositoryMetadata(clusterManagerNode, CLUSTER_STATE_REPO);
        DiscoveryNode discoveryNode = newDiscoveryNode(Collections.singletonMap("zone", "zone-2"));
}
            allocationService,
        );
            .metadata(Metadata.builder().decommissionAttributeMetadata(decommissionAttributeMetadata))
        final RerouteService rerouteService = (reason, priority, listener) -> listener.onResponse(null);
            buildNewFakeTransportAddress(),
        );
        assertThrows(
        String decommissionedNodeID = decommissionedNode.getId();
            Version.CURRENT
        }
    @LockFeatureFlag(REMOTE_STORE_MIGRATION_EXPERIMENTAL)
        );
        );
    }
            new SetOnce<>(mock(RepositoriesService.class))::get,
        expectThrows(NodeDecommissionedException.class, () -> JoinTaskExecutor.ensureNodeCommissioned(discoveryNode, metadata));
        IndexMetadata indexMetadata = IndexMetadata.builder("test")
            UUIDs.base64UUID(),
        Map<String, String> remoteStoreNodeAttributes = remotePublicationNodeAttributes();
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY;
            DiscoveryNodeRole.BUILT_IN_ROLES,
        );
    }
import static org.hamcrest.Matchers.hasSize;
        final DiscoveryNode remoteStoreNode = new DiscoveryNode(
                    .add(clusterManagerNode)
            .nodes(
            .nodes(DiscoveryNodes.builder().add(existingNode).localNodeId(existingNode.getId()).build())
/*
        DiscoveryNode joiningNode2 = new DiscoveryNode(
            Version.CURRENT
                    .clusterManagerNodeId(clusterManagerNode.getId())
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY;
import java.util.HashSet;
    public void testRemoteRoutingTableNodeJoinRepoPresentInExistingNode() {
        ClusterState currentState = ClusterState.builder(ClusterName.DEFAULT)
        final Settings settings = Settings.builder()
        final ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
        final Settings settings = Settings.builder()
            buildNewFakeTransportAddress(),
                    .clusterManagerNodeId(clusterManagerNode.getId())
                putIfAbsent(routingTableRepositorySettingsAttributeKeyPrefix + "bucket", "state_bucket");
        } else {
        Metadata metadata = Metadata.builder().persistentSettings(settings).build();
            buildNewFakeTransportAddress(),
        for (Map.Entry<String, String> nodeAttribute : existingNodeAttributes.entrySet()) {
        assertEquals(4, repositoriesMetadata.repositories().size());
        final AllocationService allocationService = mock(AllocationService.class);
            if (randomBoolean()) {
            )
            || repositoriesMetadata.repositories().size() == 3
    public void testJoinClusterWithNoDecommission() {
            )
            .nodes(
            logger,
        );
            IllegalStateException.class,
            logger,
        );
            allocationService,
        final JoinTaskExecutor joinTaskExecutor = new JoinTaskExecutor(
        ClusterState currentState = ClusterState.builder(ClusterName.DEFAULT)
            .collect(Collectors.toMap(key -> key.replace(settingsAttributeKeyPrefix, ""), key -> node.getAttributes().get(key)));
            } else if (REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY.equals(nodeAttribute.getKey())) {
        final ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
                IllegalStateException.class,
            }
        );
        assertThat(joinTaskOfClusterManager.isBecomeClusterManagerTask(), is(true));
            DiscoveryNode joiningNode = newDiscoveryNode(remoteStoreNodeAttributes);
        );
        Metadata metadata = metaBuilder.build();
        JoinTaskExecutor.ensureNodesCompatibility(joiningNode, currentState.getNodes(), currentState.metadata());
        DiscoveryNode joiningNode = newDiscoveryNode(remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO));
            Version.CURRENT
            REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,
        // This means we can receive a join from a node that's already in the cluster but with a different set of roles:
            IllegalStateException.class,
            existingNodeAttributes,
        metaBuilder.put(indexMetadata, false);
    }
        DecommissionAttributeMetadata decommissionAttributeMetadata = new DecommissionAttributeMetadata(
            .build();
            () -> JoinTaskExecutor.ensureNodesCompatibility(badRemoteNode, currentState.getNodes(), currentState.metadata())
        ClusterState currentState = ClusterState.builder(ClusterName.DEFAULT)
            remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO),
    public void testIsBecomeClusterManagerTask() {
        final DiscoveryNode existingNode = new DiscoveryNode(
        when(allocationService.adaptAutoExpandReplicas(any())).then(invocationOnMock -> invocationOnMock.getArguments()[0]);
        final DiscoveryNode existingNode = new DiscoveryNode(
            }
    public void testPreventJoinClusterWithRemoteStoreNodeWithDifferentNameAttributesJoiningRemoteStoreCluster() {
        attr.putAll(remoteRoutingTableAttributes(ROUTING_TABLE_REPO));
            remoteStoreNodeAttributes.put(nodeAttribute.getKey(), nodeAttribute.getValue());
            remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO),
            REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,
            UUIDs.base64UUID(),
        final ClusterStateTaskExecutor.ClusterTasksResult<JoinTaskExecutor.Task> resultAfterRemoteNodeJoin = joinTaskExecutor.execute(
        // joining node of a higher version than the current nodes
    }
        final ClusterStateTaskExecutor.ClusterTasksResult<JoinTaskExecutor.Task> result = joinTaskExecutor.execute(
        String settingsAttributeKeyPrefix = String.format(Locale.getDefault(), REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX, name);
                    .clusterManagerNodeId(clusterManagerNode.getId())
        final DiscoveryNode clusterManagerNode = new DiscoveryNode(UUIDs.base64UUID(), buildNewFakeTransportAddress(), Version.CURRENT);
import org.opensearch.cluster.node.DiscoveryNodeRole;
        final RemoteStoreNodeService remoteStoreNodeService = new RemoteStoreNodeService(
        String routingTableRepositoryTypeAttributeKey = String.format(
        assertThat(result.resultingState.getNodes().get(actualNode.getId()).getRoles(), equalTo(actualNode.getRoles()));
            final RepositoryMetadata repositoryMetadata = buildRepositoryMetadata(existingNode, COMMON_REPO);
import static org.opensearch.common.util.FeatureFlags.REMOTE_STORE_MIGRATION_EXPERIMENTAL;
                    CLUSTER_STATE_REPO + "new"
            DecommissionStatus.DRAINING
import static org.opensearch.test.VersionUtils.maxCompatibleVersion;
        final DiscoveryNode joiningNode = new DiscoveryNode(
            .nodes(DiscoveryNodes.builder().add(existingNode).localNodeId(existingNode.getId()).build())
            .build();
            IllegalStateException.class,
    }
            .build();
                    .add(clusterManagerNode)
        );
        return new HashMap<>() {
            buildNewFakeTransportAddress(),
        DiscoveryNode joiningNode = newDiscoveryNode(remoteStateNodeAttributes(CLUSTER_STATE_REPO));
            .build();
        when(allocationService.adaptAutoExpandReplicas(any())).then(invocationOnMock -> invocationOnMock.getArguments()[0]);
            .build();
        Metadata metadata = Metadata.builder().persistentSettings(settings).build();
                    final RepositoryMetadata clusterStateRepoMetadata = buildRepositoryMetadata(existingNode, CLUSTER_STATE_REPO);
        String clusterStateRepositoryTypeAttributeKey = String.format(
    }
            DiscoveryNodeRole.BUILT_IN_ROLES,
        JoinTaskExecutor.ensureNodesCompatibility(joiningNode, currentState.getNodes(), currentState.metadata());
            Version.CURRENT
        );
            .build();
    public void testRemoteStoreNodeJoiningNonRemoteStoreClusterMixedMode() {
        ClusterState currentState = ClusterState.builder(ClusterName.DEFAULT)
            .nodes(DiscoveryNodes.builder().add(existingNode).localNodeId(existingNode.getId()).build())
import org.opensearch.cluster.ClusterName;
        when(allocationService.adaptAutoExpandReplicas(any())).then(invocationOnMock -> invocationOnMock.getArguments()[0]);
        }
        );
        );
            .build();
    public void testRemoteRoutingTableRepoAbsentNodeJoin() {
        final RepositoryMetadata clusterStateRepoMetadata = buildRepositoryMetadata(existingNode, CLUSTER_STATE_REPO);
            for (RepositoryMetadata repositoryMetadata : repositoriesMetadata.repositories()) {
        assertTrue(taskResult.isSuccess());
    }
    }
        String segmentRepositoryTypeAttributeKey = String.format(
            remotePublicationNodeAttributes(),
            buildNewFakeTransportAddress(),
    public void testRemoteRoutingTableNodeJoinRepoPresentInJoiningNode() {
        Metadata.Builder metaBuilder = Metadata.builder();
            .build();
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.cluster.ClusterStateTaskExecutor;
import org.opensearch.cluster.decommission.NodeDecommissionedException;
                    .add(clusterManagerNode)
            .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), RemoteStoreNodeService.CompatibilityMode.MIXED)
        );
        Settings.Builder settings = Settings.builder();
        );
            buildNewFakeTransportAddress(),
            translogRepoName
            logger,
            Settings.EMPTY,
            DecommissionStatus.SUCCESSFUL,
        // In this case we must properly process its join to ensure that the roles are correct.
        final RepositoriesMetadata repositoriesMetadata = updatedState.metadata().custom(RepositoriesMetadata.TYPE);
     * Validate isBecomeClusterManagerTask() can identify "become cluster manager task" properly
        when(allocationService.adaptAutoExpandReplicas(any())).then(invocationOnMock -> invocationOnMock.getArguments()[0]);
        JoinTaskExecutor.ensureNodesCompatibility(joiningNode, currentState.getNodes(), currentState.metadata());
        Settings.builder().build();
    public void testUpdatesNodeWithNewRoles() throws Exception {
            buildNewFakeTransportAddress(),
            clusterState,
            logger,
        JoinTaskExecutor.ensureNodesCompatibility(joiningNode, currentState.getNodes(), currentState.metadata());
        final RepositoryMetadata translogRepositoryMetadata = buildRepositoryMetadata(remoteNode, TRANSLOG_REPO);
            .build();
import org.opensearch.cluster.metadata.View;
    }
            .filter(key -> key.startsWith(settingsAttributeKeyPrefix))
            Locale.getDefault(),
    }
    public void testPreventJoinClusterWithNonRemoteStoreNodeJoiningRemoteStoreCluster() {
            .build();
        expectThrows(
        final AllocationService allocationService = mock(AllocationService.class);
            Version.CURRENT
            () -> JoinTaskExecutor.ensureNodesCompatibility(joiningNode, currentState.getNodes(), currentState.metadata())
            Version.CURRENT
        Metadata metadata = Metadata.EMPTY_METADATA;
        Metadata metadata = Metadata.builder().persistentSettings(settings).build();
        Version higherVersion = versions.get(versions.size() - 1);
        final Settings settings = Settings.builder()
                assertTrue(segmentRepositoryMetadata.equalsIgnoreGenerations(repositoryMetadata));
        DiscoveryNode joiningNode = newDiscoveryNode(remoteStoreNodeAttributes);
import org.opensearch.node.remotestore.RemoteStoreNodeService;
            buildNewFakeTransportAddress(),
        );
                    .localNodeId(docrepNode.getId())
        assertTrue(e.getMessage().equals("a remote store node [" + joiningNode + "] is trying to join a non remote " + "store cluster"));
                    TRANSLOG_REPO,
        List<RepositoryMetadata> repositoriesMetadata = new ArrayList<>() {
            Settings.EMPTY,
                    .localNodeId(clusterManagerNode.getId())
            )
        assertEquals("a non remote store node [" + joiningNode + "] is trying to join a remote store cluster", e.getMessage());
            DiscoveryNodeRole.BUILT_IN_ROLES,
            .settings(settings(Version.fromString("5.8.0")))
        when(allocationService.adaptAutoExpandReplicas(any())).then(invocationOnMock -> invocationOnMock.getArguments()[0]);
            decommissionAttribute,
            IllegalStateException.class,
        );
                DiscoveryNodes.builder()
            rerouteService,
            List.of(new JoinTaskExecutor.Task(clusterManagerNode, "elect leader"))
        DiscoveryNode joiningNode1 = new DiscoveryNode(
    public void testSuccess() {
    private RepositoryMetadata buildRepositoryMetadata(DiscoveryNode node, String name) {
        String type = nodeAttributes.get(String.format(Locale.getDefault(), REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT, name));
        final RerouteService rerouteService = (reason, priority, listener) -> listener.onResponse(null);
            UUIDs.base64UUID(),
            DiscoveryNodeRole.BUILT_IN_ROLES,
        ClusterState currentState = ClusterState.builder(ClusterName.DEFAULT)
            DiscoveryNodeRole.BUILT_IN_ROLES,
            UUIDs.base64UUID(),
            )
            Version.CURRENT
        throws Exception {
        final ClusterStateTaskExecutor.ClusterTasksResult<JoinTaskExecutor.Task> resultAfterRemoteNodeJoin = joinTaskExecutor.execute(
            }
                    .add(clusterManagerNode)
 * not use this file except in compliance with the License.
            Settings.EMPTY,
                    .clusterManagerNodeId(clusterManagerNode.getId())
            DiscoveryNodeRole.BUILT_IN_ROLES,
            "remote migration : a node [%s] of higher version [%s] is not allowed to join a cluster with maximum version [%s]",
        assertThat(result.executionResults.entrySet(), hasSize(1));
            remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO),
        return new HashMap<>() {
            .build();
        Version baseVersion = versions.get(versions.size() - 2);
            .nodes(DiscoveryNodes.builder().add(existingNode).localNodeId(existingNode.getId()).build())
            UUIDs.base64UUID(),
import java.util.HashMap;
        final DiscoveryNode joiningNode = new DiscoveryNode(
            DiscoveryNodeRole.BUILT_IN_ROLES,
            actualNode.getHostName(),
        );
import static org.hamcrest.Matchers.equalTo;
            }
                put(segmentRepositorySettingsAttributeKeyPrefix + "bucket", "segment_bucket");
            buildNewFakeTransportAddress(),
            .nodes(DiscoveryNodes.builder().add(joiningNode).build())
            buildNewFakeTransportAddress(),
        final RepositoryMetadata translogRepositoryMetadata = buildRepositoryMetadata(clusterManagerNode, TRANSLOG_REPO);
    public void testPreventJoinClusterWithNewerIndices() {
        Map<String, String> existingNodeAttributes = remoteStateNodeAttributes(CLUSTER_STATE_REPO);
        JoinTaskExecutor.ensureNodesCompatibility(joiningNode, currentState.getNodes(), currentState.metadata());
        final ClusterStateTaskExecutor.TaskResult taskResult = result.executionResults.values().iterator().next();
        final DiscoveryNode existingNode = new DiscoveryNode(
                    assertTrue(clusterStateRepoMetadata.equalsIgnoreGenerations(repositoryMetadata));
    }
            buildNewFakeTransportAddress(),
                remoteStoreNodeAttributes.put(nodeAttribute.getKey(), nodeAttribute.getValue() + "-new");
                assertTrue(repositoryMetadata.equalsIgnoreGenerations(routingTableRepositoryMetadata));
        when(allocationService.adaptAutoExpandReplicas(any())).then(invocationOnMock -> invocationOnMock.getArguments()[0]);
        DecommissionAttributeMetadata decommissionAttributeMetadata = new DecommissionAttributeMetadata(
            decommissionStatus,
            Version.CURRENT
            logger,
                                + joiningNode
                                + currentState.getNodes().getNodes().values().stream().findFirst().get()
            .numberOfReplicas(1)
            .build();
            null
        final Settings settings = Settings.builder()
    private static final String SEGMENT_REPO = "segment-repo";
        );
                assertTrue(translogRepositoryMetadata.equalsIgnoreGenerations(repositoryMetadata));
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY;
        final RemoteStoreNodeService remoteStoreNodeService = new RemoteStoreNodeService(
            UUIDs.base64UUID(),
            JoinTaskExecutor.ensureNodesCompatibility(justGoodJoiningNode, nodes, metadata, minNodeVersion, maxNodeVersion);
    private static final String TRANSLOG_REPO = "translog-repo";
            allocationService,
            Settings.EMPTY,
        final ClusterStateTaskExecutor.TaskResult taskResult = result.executionResults.values().iterator().next();
                } else if (repositoryMetadata.name().equals(translogRepositoryMetadata.name())) {
            .nodes(DiscoveryNodes.builder().add(existingNode).localNodeId(existingNode.getId()).build())
            allocationService,
        );
            )
            }
        existingNodeAttributes.putAll(remoteStateNodeAttributes(CLUSTER_STATE_REPO));
        final RepositoryMetadata segmentRepositoryMetadata = buildRepositoryMetadata(clusterManagerNode, COMMON_REPO);
        Map<String, String> newNodeAttributes = new HashMap<>();
 * this file be licensed under the Apache-2.0 license or a
        );
            .put(MIGRATION_DIRECTION_SETTING.getKey(), RemoteStoreNodeService.Direction.REMOTE_STORE)
        newNodeAttributes.putAll(remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO));
        ClusterState currentState = ClusterState.builder(result.resultingState).metadata(metadata).build();
        final ClusterState result = joinNodeToClusterWithViewMetadata(clusterManagerNode, joiningNode);
        );
        final JoinTaskExecutor joinTaskExecutor = new JoinTaskExecutor(
            buildNewFakeTransportAddress(),
        Metadata metadata = metaBuilder.build();
        final RerouteService rerouteService = (reason, priority, listener) -> listener.onResponse(null);
                    .clusterManagerNodeId(clusterManagerNode.getId())
            DiscoveryNodeRole.BUILT_IN_ROLES,
        validatePublicationRepositoryMetadata(result.resultingState, clusterManagerNode);
    }
    private Map<String, String> remoteRoutingTableAttributes(String repoName) {
        }
    }
            DiscoveryNodeRole.BUILT_IN_ROLES,
    private void validateRepositoryMetadata(ClusterState updatedState, DiscoveryNode existingNode, int expectedRepositories)
            }
            .build();
    public void testUpdatesRepoRemoteNodeJoinPublicationCluster() throws Exception {
            .nodes(DiscoveryNodes.builder().add(existingNode).localNodeId(existingNode.getId()).build())
            {
        return new RepositoryMetadata(name, type, settings.build());
            remoteStoreNodeService
            e.getMessage(),
        final DiscoveryNode clusterManagerNode = new DiscoveryNode(
            .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "mixed")
        assertTrue(result.executionResults.values().iterator().next().isSuccess());
    }
        final RerouteService rerouteService = (reason, priority, listener) -> listener.onResponse(null);
            logger,
                    .localNodeId(clusterManagerNode.getId())
        final DiscoveryNode justGoodJoiningNode = new DiscoveryNode(UUIDs.base64UUID(), buildNewFakeTransportAddress(), justGood);
        final DiscoveryNode existingNode = new DiscoveryNode(
            .add(currentNode1)
            existingNodeAttributes,
            Locale.getDefault(),
        final DiscoveryNode clusterManagerNode = new DiscoveryNode(UUIDs.base64UUID(), buildNewFakeTransportAddress(), Version.CURRENT);
        when(repositoriesService.repository(any())).thenThrow(RepositoryMissingException.class);
        );
        ClusterState currentState = ClusterState.builder(ClusterName.DEFAULT)
    }
        DiscoveryNode joiningNode = newDiscoveryNode(map);
        } else {
        assertNotNull(result.metadata().custom(ViewMetadata.TYPE));
    private Map<String, String> remoteStateNodeAttributes(String clusterStateRepo) {
        JoinTaskExecutor.ensureIndexCompatibility(Version.CURRENT, metadata);
        ClusterState currentState = ClusterState.builder(ClusterName.DEFAULT)
    }
            DecommissionStatus.INIT,
    @SuppressWarnings("removal")
            )
                add(segmentRepositoryMetadata);
            allocationService,
    }
    }
        final RemoteStoreNodeService remoteStoreNodeService = new RemoteStoreNodeService(
        String segmentRepositorySettingsAttributeKeyPrefix = String.format(
        final AllocationService allocationService = mock(AllocationService.class);
        builder.add(new DiscoveryNode(UUIDs.base64UUID(), buildNewFakeTransportAddress(), randomCompatibleVersion(random(), version)));
                    .add(clusterManagerNode)
            new SetOnce<>(mock(RepositoriesService.class))::get,
                settings(VersionUtils.randomVersionBetween(random(), Version.CURRENT.minimumIndexCompatibilityVersion(), Version.CURRENT))
            .build();
 * ownership. Elasticsearch licenses this file to you under
                                + "]"
            DiscoveryNodeRole.BUILT_IN_ROLES,
                () -> JoinTaskExecutor.ensureNodesCompatibility(joiningNode, currentState.getNodes(), currentState.metadata())
            allocationService,
        final DiscoveryNode bwcNode = new DiscoveryNode(
                    .localNodeId(clusterManagerNode.getId())
            DecommissionStatus.IN_PROGRESS,
        final DiscoveryNode clusterManagerNode = new DiscoveryNode(
            .numberOfShards(1)
            Version.CURRENT
            Collections.singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
    }
        Metadata.Builder metaBuilder = Metadata.builder();
 * license agreements. See the NOTICE file distributed with
            .put(MIGRATION_DIRECTION_SETTING.getKey(), RemoteStoreNodeService.Direction.REMOTE_STORE)
            List.of(new JoinTaskExecutor.Task(clusterManagerNode, "elect leader"))
                                + "] is trying to join a remote store cluster with incompatible node attributes in comparison with existing node ["
            buildNewFakeTransportAddress(),
        final ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
        final JoinTaskExecutor joinTaskExecutor = new JoinTaskExecutor(
    }
            )
    public void testJoinClusterWithNonRemoteStoreNodeJoining() {
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY;
import org.opensearch.Version;
            Version.CURRENT
            Settings.EMPTY,
        Map<String, String> existingNodeAttributes = remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO);
            remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO),
        assertTrue(taskResult.isSuccess());
            .settings(settings(Version.CURRENT))
        DiscoveryNode currentNode2 = new DiscoveryNode(UUIDs.base64UUID(), buildNewFakeTransportAddress(), baseVersion);
        final DiscoveryNode docrepNode = new DiscoveryNode(UUIDs.base64UUID(), buildNewFakeTransportAddress(), Version.CURRENT);
            buildNewFakeTransportAddress(),
            attr,
            List.of(new JoinTaskExecutor.Task(joiningNode, "test"))
            existingNodeAttributes,
import org.opensearch.cluster.metadata.Metadata;
        DiscoveryNode joiningNode = newDiscoveryNode(remotePublicationNodeAttributes());
        );
    }
        assertTrue(e.getMessage().equals("a non remote store node [" + joiningNode + "] is trying to join a remote " + "store cluster"));
        final DiscoveryNode clusterManagerNode = new DiscoveryNode(
        expectThrows(IllegalStateException.class, () -> JoinTaskExecutor.ensureIndexCompatibility(Version.CURRENT, metadata));
                putIfAbsent(routingTableRepositorySettingsAttributeKeyPrefix + "base_path", "/state/path");
            UUIDs.base64UUID(),
            remoteStoreNodeService
            .nodes(DiscoveryNodes.builder().add(existingNode).localNodeId(existingNode.getId()).build())
            } else if (repositoryMetadata.name().equals(routingTableRepositoryMetadata.name())) {
            "a remote store node ["
            Version.CURRENT
            remotePublicationNodeAttributes(),
        final DiscoveryNode clusterManagerNode = new DiscoveryNode(
        );
            .put(MIGRATION_DIRECTION_SETTING.getKey(), RemoteStoreNodeService.Direction.REMOTE_STORE)
            Settings.EMPTY,
        DiscoveryNode currentNode1 = new DiscoveryNode(UUIDs.base64UUID(), buildNewFakeTransportAddress(), baseVersion);
        );
            );
            clusterManagerClusterState,
        final DiscoveryNode remoteStoreNode = new DiscoveryNode(
            .build();
        Metadata metadata = Metadata.builder().persistentSettings(settings).build();
        final RemoteStoreNodeService remoteStoreNodeService = mock(RemoteStoreNodeService.class);
            null
            } else if (repositoryMetadata.name().equals(translogRepositoryMetadata.name())) {
            UUIDs.base64UUID(),
                validateAttributes(remoteStoreNodeAttributes, currentState, existingNode);
                + "]"
        builder.add(new DiscoveryNode(UUIDs.base64UUID(), buildNewFakeTransportAddress(), version));
            remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO),
            .settings(
    }
    public void testPreventJoinClusterWithRemoteStoreNodeJoiningRemoteStateCluster() {
    }
        DiscoveryNode joiningNode = newDiscoveryNode(attr);
        );
        );
            () -> JoinTaskExecutor.ensureNodesCompatibility(joiningNode, currentState.getNodes(), currentState.metadata())
import static org.opensearch.node.remotestore.RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING;
        Metadata.Builder metaBuilder = Metadata.builder();
            DiscoveryNodeRole.BUILT_IN_ROLES,
        assertFalse(result.resultingState.getNodes().nodeExists(decommissionedNodeID));
                put(segmentRepositoryTypeAttributeKey, "s3");
        final DiscoveryNode clusterManagerNode = new DiscoveryNode(
        assertTrue(taskResult.isSuccess());
            .nodes(
            assertTrue(
            Version.CURRENT
        // joining node of the same version as the current nodes
        ClusterState currentState = ClusterState.builder(ClusterName.DEFAULT)
        } else if (repositoriesMetadata.repositories().size() == 1) {
            DiscoveryNodeRole.BUILT_IN_ROLES,
        assert versions.size() >= 2 : "test requires at least two open search versions";
        when(allocationService.adaptAutoExpandReplicas(any())).then(invocationOnMock -> invocationOnMock.getArguments()[0]);
            segmentRepoName
                putIfAbsent(clusterStateRepositorySettingsAttributeKeyPrefix + "bucket", "state_bucket");
        DiscoveryNode joiningNode = newDiscoveryNode(Collections.emptyMap());
            translogRepoName
        );
    public void testJoinRemotePublicationCluster() {
        );
        ClusterState currentState = ClusterState.builder(ClusterName.DEFAULT)
        Exception e = assertThrows(
        final ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
            new SetOnce<>(mock(RepositoriesService.class))::get,
            buildNewFakeTransportAddress(),
            );
            DiscoveryNodeRole.BUILT_IN_ROLES,
        JoinTaskExecutor.Task joinTaskOfClusterManager = JoinTaskExecutor.newBecomeClusterManagerTask();
        Map<String, String> nodeAttributes = node.getAttributes();
            remotePublicationNodeAttributes(),
                DiscoveryNodes.builder()
            buildNewFakeTransportAddress(),
        Metadata metadata = metaBuilder.build();
        );
        );
            .nodes(
        when(allocationService.adaptAutoExpandReplicas(any())).then(invocationOnMock -> invocationOnMock.getArguments()[0]);
import org.opensearch.cluster.decommission.DecommissionAttribute;
                () -> JoinTaskExecutor.ensureNodesCompatibility(joiningNode, currentState.getNodes(), currentState.metadata())
            }
            logger,
                DiscoveryNodes.builder()
            .nodes(DiscoveryNodes.builder().add(existingNode).localNodeId(existingNode.getId()).build())
        attr.putAll(remoteRoutingTableAttributes(ROUTING_TABLE_REPO));
            Version.CURRENT
            .build();
            UUIDs.base64UUID(),
            Version minCompatVersion = maxNodeVersion.minimumCompatibilityVersion();
            .nodes(DiscoveryNodes.builder().add(existingNode).localNodeId(existingNode.getId()).build())
            DiscoveryNodeRole.BUILT_IN_ROLES,
    }
            UUIDs.base64UUID(),
            currentNodes.getMaxNodeVersion()
            {
            buildNewFakeTransportAddress(),
        );
        );
        final View view = new View("logs", "all logs", 1L, 1L, Set.of(new View.Target("logs-*")));
    public void testNodeJoinInMixedMode() {
            remoteStoreNodeAttributes,
        Settings.builder().build();
        );
        final ClusterStateTaskExecutor.TaskResult taskResult = result.executionResults.values().iterator().next();
public class JoinTaskExecutorTests extends OpenSearchTestCase {
            actualNode.getHostAddress(),
        );
        return remoteStoreNodeAttributes(segmentRepoName, translogRepoName, CLUSTER_STATE_REPO);
            .build();
        JoinTaskExecutor.ensureNodeCommissioned(discoveryNode, metadata);
            UUIDs.base64UUID(),
            DiscoveryNodeRole.BUILT_IN_ROLES,
        final IllegalStateException exception = expectThrows(
            DiscoveryNodeRole.BUILT_IN_ROLES,
        String routingTableRepositorySettingsAttributeKeyPrefix = String.format(
        DecommissionAttribute decommissionAttribute = new DecommissionAttribute("zone", "zone-1");
        Exception e = assertThrows(
            Collections.singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
            Locale.ROOT,
        assertTrue(taskResult.isSuccess());
    public void testAllTypesNodeJoiningRemoteStoreClusterMixedMode() {
        assertThrows(
                        )
            allocationService,
        final RemoteStoreNodeService remoteStoreNodeService = mock(RemoteStoreNodeService.class);
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX;
        final AllocationService allocationService = mock(AllocationService.class);
            .nodes(DiscoveryNodes.builder().add(existingNode).localNodeId(existingNode.getId()).build())
            Version.CURRENT
            remoteStoreNodeAttributes,
        Settings.builder().build();
        );
            logger,
            .nodes(
        Metadata.Builder metaBuilder = Metadata.builder();
        Settings.builder().build();
        final ClusterStateTaskExecutor.ClusterTasksResult<JoinTaskExecutor.Task> result = joinTaskExecutor.execute(
        Map<String, String> map = remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO);
        assertNull(result.metadata().custom(ViewMetadata.TYPE));
    public void testPreventJoinClusterWithRemoteStoreNodeWithDifferentAttributesJoiningRemoteStoreCluster() {
        List<RepositoryMetadata> repositoriesMetadata = new ArrayList<>();
        Map<String, String> newNodeAttributes = new HashMap<>();
            UUIDs.base64UUID(),
                            "a remote store node ["
import org.opensearch.cluster.metadata.RepositoriesMetadata;
        List<RepositoryMetadata> repositoriesMetadata = new ArrayList<>() {
        final AllocationService allocationService = mock(AllocationService.class);
            )
            remoteStoreNodeService
            )
            UUIDs.base64UUID(),
            UUIDs.base64UUID(),
            Locale.getDefault(),
        JoinTaskExecutor.ensureNodeCommissioned(discoveryNode, metadata);
        );
            DiscoveryNodeRole.BUILT_IN_ROLES,
            Version.CURRENT
            Locale.getDefault(),
        final RepositoryMetadata clusterStateRepositoryMetadata = buildRepositoryMetadata(remoteNode, CLUSTER_STATE_REPO);
            clusterState,
import static org.mockito.Mockito.any;
        final Version maxNodeVersion = nodes.getMaxNodeVersion();
 * specific language governing permissions and limitations
            minGoodVersion = minNodeVersion;
    }
import org.opensearch.cluster.metadata.RepositoryMetadata;
import org.opensearch.cluster.routing.allocation.AllocationService;
        newNodeAttributes.putAll(remoteStateNodeAttributes(CLUSTER_STATE_REPO));
    }
            .build();
                put(REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY, repoName);
            buildNewFakeTransportAddress(),
        for (Map.Entry<String, String> nodeAttribute : existingNodeAttributes.entrySet()) {
                );
            UUIDs.base64UUID(),
        assertThat(result.executionResults.entrySet(), hasSize(1));
            remoteStoreNodeService
        final DiscoveryNode existingNode = new DiscoveryNode(
            Version.CURRENT
        final DiscoveryNode clusterManagerNode = new DiscoveryNode(
        IndexMetadata indexMetadata = IndexMetadata.builder("test")
            null
            Locale.getDefault(),
            clusterState,
                    .add(clusterManagerNode)
import static org.opensearch.test.VersionUtils.allVersions;
            () -> JoinTaskExecutor.ensureNodesCompatibility(joiningNode, currentState.getNodes(), currentState.metadata())
        final DiscoveryNode clusterManagerNode = new DiscoveryNode(
            .build();
    public void testPreventJoinClusterWithDecommission() {
        final AllocationService allocationService = mock(AllocationService.class);
        final DiscoveryNode remotePublicationNode = new DiscoveryNode(
        ClusterState currentState = ClusterState.builder(ClusterName.DEFAULT)
        validateRepositoriesMetadata(resultAfterRemoteNodeJoin.resultingState, clusterManagerNode, remotePublicationNode);
        final DiscoveryNode existingNode = new DiscoveryNode(
 *     http://www.apache.org/licenses/LICENSE-2.0
                add(clusterStateRepo);
            buildNewFakeTransportAddress(),
            actualNode.getEphemeralId(),
        final DiscoveryNode existingNode = new DiscoveryNode(
            .localNodeId(currentNode1.getId())
        for (Map.Entry<String, String> nodeAttribute : existingNodeAttributes.entrySet()) {
        final DiscoveryNode existingNode = new DiscoveryNode(
        final ClusterStateTaskExecutor.ClusterTasksResult<JoinTaskExecutor.Task> result = joinTaskExecutor.execute(
        existingNodeAttributes.putAll(remoteRoutingTableAttributes(ROUTING_TABLE_REPO));
 * SPDX-License-Identifier: Apache-2.0
        Map<String, String> existingNodeAttributes = remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO);
            Version.CURRENT
            UUIDs.base64UUID(),
        DiscoveryNode joiningNode = newDiscoveryNode(remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO));
            Version.CURRENT
        Map<String, String> remoteStoreNodeAttributes = remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO);
            buildNewFakeTransportAddress(),
        assertThat(result.executionResults.entrySet(), hasSize(1));
        Exception e = assertThrows(
        );
                    .localNodeId(clusterManagerNode.getId())
        DiscoveryNode joiningNode = newDiscoveryNode(attr);
            currentState,
                + "] is trying to join a remote store cluster with incompatible node attributes in "
import static org.opensearch.test.VersionUtils.randomOpenSearchVersion;
        return result.resultingState;
                    .clusterManagerNodeId(clusterManagerNode.getId())
        );
            List.of(new JoinTaskExecutor.Task(joiningNode, "test"))
            remoteStoreNodeService
            DiscoveryNodeRole.BUILT_IN_ROLES,
        }
        );
            .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "mixed")
    }
    public void testUpdatesClusterStateWithRepositoryMetadataNotInSync() throws Exception {
            .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "mixed")
            DiscoveryNodeRole.BUILT_IN_ROLES,
            () -> JoinTaskExecutor.ensureNodesCompatibility(joiningNode, currentState.getNodes(), currentState.metadata())
                putIfAbsent(clusterStateRepositorySettingsAttributeKeyPrefix + "base_path", "/state/path");
            actualNode.getName(),
            null
        for (Map.Entry<String, String> nodeAttribute : existingNodeAttributes.entrySet()) {
            .metadata(Metadata.builder().putCustom(RepositoriesMetadata.TYPE, new RepositoriesMetadata(repositoriesMetadata)))
        final RerouteService rerouteService = (reason, priority, listener) -> listener.onResponse(null);
        ClusterState currentState = ClusterState.builder(ClusterName.DEFAULT)
        assertTrue(taskResult.isSuccess());
        JoinTaskExecutor.ensureNodeCommissioned(discoveryNode, metadata);
            IllegalStateException.class,
            decommissionStatus,
import org.opensearch.repositories.RepositoryMissingException;
        ClusterState currentState = ClusterState.builder(ClusterName.DEFAULT)
            .build();
        assertThat(resultAfterRemoteNodeJoin.executionResults.entrySet(), hasSize(1));
        ClusterState currentState = ClusterState.builder(ClusterName.DEFAULT)
        final AllocationService allocationService = mock(AllocationService.class);
                    assertTrue(translogRepositoryMetadata.equalsIgnoreGenerations(repositoryMetadata));
        JoinTaskExecutor.ensureIndexCompatibility(Version.CURRENT, metadata);
            .build();
                    .clusterManagerNodeId(clusterManagerNode.getId())
                Map<String, String> remoteStoreNodeAttributes = remoteStoreNodeAttributes(SEGMENT_REPO + "new", TRANSLOG_REPO);
        settings.put(BlobStoreRepository.SYSTEM_REPOSITORY_SETTING.getKey(), true);
        );
        Metadata metadata = Metadata.builder().persistentSettings(settings).build();
        final ClusterStateTaskExecutor.ClusterTasksResult<JoinTaskExecutor.Task> result = joinTaskExecutor.execute(
            buildNewFakeTransportAddress(),
 * software distributed under the License is distributed on an
                    .localNodeId(clusterManagerNode.getId())
        final RemoteStoreNodeService remoteStoreNodeService = new RemoteStoreNodeService(
                    .localNodeId(clusterManagerNode.getId())
            attr,
            .nodes(DiscoveryNodes.builder().add(existingNode).localNodeId(existingNode.getId()).build())
import static org.opensearch.test.VersionUtils.randomVersionBetween;
        throws Exception {
            Version.CURRENT
            .build();
            .build();
            .build();
        JoinTaskExecutor.ensureNodesCompatibility(joiningNode, currentState.getNodes(), currentState.metadata());
                DiscoveryNodes.builder()
import java.util.Collections;
            )
        List<Version> versions = allOpenSearchVersions();
import static org.opensearch.test.VersionUtils.allOpenSearchVersions;
            )
            DiscoveryNodeRole.BUILT_IN_ROLES,
        final ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
                validateAttributes(remoteStoreNodeAttributes, currentState, existingNode);
        final DiscoveryNode existingNode = new DiscoveryNode(
            allocationService,
                    .add(docrepNode)
/*
        when(allocationService.adaptAutoExpandReplicas(any())).then(invocationOnMock -> invocationOnMock.getArguments()[0]);
    public void testRemoteRoutingTableNodeJoinNodeWithRemoteAndRoutingRepoDifference() {
            DiscoveryNodeRole.BUILT_IN_ROLES,
        Map<String, String> remoteStoreNodeAttributes = remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO);
            Settings.EMPTY,
        final ClusterStateTaskExecutor.ClusterTasksResult<JoinTaskExecutor.Task> result = joinTaskExecutor.execute(
        );
        final DiscoveryNode existingNode = new DiscoveryNode(
import org.opensearch.cluster.decommission.DecommissionAttributeMetadata;
        Map<String, String> attr = remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO);
            buildNewFakeTransportAddress(),
            .numberOfShards(1)
            buildNewFakeTransportAddress(),
        final DiscoveryNode existingNode = new DiscoveryNode(
        );
     */
        final Settings settings = Settings.builder()
        JoinTaskExecutor.ensureNodesCompatibility(goodRemoteNode, currentState.getNodes(), currentState.metadata());
                    .clusterManagerNodeId(clusterManagerNode.getId())
            remoteStoreNodeService
            .build();
            () -> JoinTaskExecutor.ensureNodesCompatibility(joiningNode1, currentNodes, metadata)
        Map<String, String> attr = remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO);
        );
        return new DiscoveryNode(
            .build();
                JoinTaskExecutor.ensureNodesCompatibility(tooLowJoiningNode, nodes, metadata);
        );
    }
 * GitHub history for details.
            .numberOfReplicas(1)
            buildNewFakeTransportAddress(),
            rerouteService,
 * compatible open source license.
import java.util.Set;
        assertTrue(taskResult1.isSuccess());
            REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,
            UUIDs.base64UUID(),
            DiscoveryNodeRole.BUILT_IN_ROLES,
        final DiscoveryNode joiningNode = new DiscoveryNode(UUIDs.base64UUID(), buildNewFakeTransportAddress(), Version.V_3_10_0);
        }
            buildNewFakeTransportAddress(),
        DiscoveryNode discoveryNode = newDiscoveryNode(Collections.singletonMap("zone", "zone-1"));
        assertTrue(taskResult.getFailure() instanceof NodeDecommissionedException);
import java.util.Map;
    public void testJoinRemoteStoreClusterWithRemotePublicationNodeInMixedMode() {
                        .equals(
        final RemoteStoreNodeService remoteStoreNodeService = new RemoteStoreNodeService(
        );
                assertTrue(clusterStateRepositoryMetadata.equalsIgnoreGenerations(repositoryMetadata));
import org.opensearch.common.settings.Settings;
        );
            rerouteService,
        );
            new SetOnce<>(mock(RepositoriesService.class))::get,
            DiscoveryNodeRole.BUILT_IN_ROLES,
            () -> JoinTaskExecutor.ensureNodesCompatibility(joiningNode, currentState.getNodes(), currentState.metadata())
        assertThat(result.executionResults.entrySet(), hasSize(1));
                                + joiningNode
        JoinTaskExecutor.ensureNodesCompatibility(joiningNode, currentState.getNodes(), currentState.metadata());
                                + "] is trying to join a remote store cluster with incompatible node attributes in comparison with existing node ["
            .build();
        );
        );
        final JoinTaskExecutor joinTaskExecutor = new JoinTaskExecutor(
        Settings.builder().build();
        Map<String, String> attr = remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO);
        JoinTaskExecutor.ensureNodesCompatibility(joiningNode, currentState.getNodes(), currentState.metadata());
        ClusterState currentState = ClusterState.builder(ClusterName.DEFAULT)
    }
        final ClusterState clusterManagerClusterState = ClusterState.builder(ClusterName.DEFAULT)
        Exception e = assertThrows(
            Version oldMajor = minNodeVersion.minimumCompatibilityVersion();
 * Licensed to Elasticsearch under one or more contributor
            UUIDs.base64UUID(),
    public void testDropsViewMetadataOnceAllNodesAreUpgraded() throws Exception {
        Metadata metadata = Metadata.builder().persistentSettings(settings).build();
        final DiscoveryNode actualNode = new DiscoveryNode(UUIDs.base64UUID(), buildNewFakeTransportAddress(), Version.CURRENT);
            buildNewFakeTransportAddress(),
            List.of(new JoinTaskExecutor.Task(decommissionedNode, "test"))
            assertTrue(
                putAll(remoteStateNodeAttributes(clusterStateRepo));
        final ClusterStateTaskExecutor.TaskResult taskResult1 = resultAfterRemoteNodeJoin.executionResults.values().iterator().next();
            .nodes(
        );
            DiscoveryNodeRole.BUILT_IN_ROLES,
        Exception e = assertThrows(
        final RerouteService rerouteService = (reason, priority, listener) -> listener.onResponse(null);
        );
    private Map<String, String> remoteStoreNodeAttributes(String segmentRepoName, String translogRepoName, String clusterStateRepo) {
            List.of(new JoinTaskExecutor.Task(joiningNode, "test"))
            randomAlphaOfLength(10)
            rerouteService,
            List.of(new JoinTaskExecutor.Task(actualNode, "test"))
import java.util.List;
        newNodeAttributes.putAll(remoteRoutingTableAttributes(ROUTING_TABLE_REPO));
            Collections.singletonMap("zone", "zone1"),
            if (repositoryMetadata.name().equals(clusterStateRepoMetadata.name())) {
            {
        if (minNodeVersion.before(Version.V_3_0_0)) {
        } else {
            if (REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY.equals(nodeAttribute.getKey())) {
                && nodeAttribute.getKey() != REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY) {
    }
            UUIDs.base64UUID(),
 */
    }
        RepositoriesService repositoriesService = mock(RepositoriesService.class);
            .build();
        final RepositoryMetadata segmentRepositoryMetadata = buildRepositoryMetadata(clusterManagerNode, SEGMENT_REPO);
        ClusterState currentState = ClusterState.builder(ClusterName.DEFAULT)
        assertThat(result.executionResults.entrySet(), hasSize(1));
                put(segmentRepositorySettingsAttributeKeyPrefix + "base_path", "/segment/path");
        ClusterState currentState = ClusterState.builder(ClusterName.DEFAULT)
        DiscoveryNode joiningNode = newDiscoveryNode(Collections.emptyMap());
                Map<String, String> remoteStoreNodeAttributes = remoteStoreNodeAttributes(
            remoteStoreNodeService
        Map<String, String> remoteStoreNodeAttributes = remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO);
        );
    public void testUpdatesClusterStateWithSingleNodeCluster() throws Exception {
    @LockFeatureFlag(REMOTE_STORE_MIGRATION_EXPERIMENTAL)
            .build();
            joiningNode1,
        );
            } else {
 */
                DiscoveryNodes.builder()
                DiscoveryNodes.builder()
                IllegalStateException.class,
                assertTrue(routingTableRepoMetadata.equalsIgnoreGenerations(repositoryMetadata));
        JoinTaskExecutor.ensureNodesCompatibility(joiningNode, currentState.getNodes(), currentState.metadata());
            {
                + existingNode
        Map<String, String> attr = remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO);
        metaBuilder.put(indexMetadata, false);
            DiscoveryNodeRole.BUILT_IN_ROLES,
            remoteStoreNodeService
            .nodes(
            .build();
                add(segmentRepositoryMetadata);
        ClusterState currentState = ClusterState.builder(ClusterName.DEFAULT)
    /**
    public void testJoinClusterWithDecommissionFailed() {
            buildNewFakeTransportAddress(),
            actualNode.getId(),
        Map<String, String> existingNodeAttributes = remotePublicationNodeAttributes();
    public void testKeepsViewMetadataWhileOlderNodesRemain() throws Exception {
            expectThrows(IllegalStateException.class, () -> JoinTaskExecutor.ensureMajorVersionBarrier(oldMajor, minNodeVersion));
        final Version justGood = randomVersionBetween(random(), minGoodVersion, maxCompatibleVersion(minNodeVersion));
    public void testJoinRemotePublicationClusterWithNonRemoteNodes() {
            UUIDs.base64UUID(),
            allocationService,
        ClusterState currentState = ClusterState.builder(ClusterName.DEFAULT)
                put(REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY, segmentRepoName);
    }
 * Unless required by applicable law or agreed to in writing,
        final ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
    }
        final Version minGoodVersion;
                    .localNodeId(clusterManagerNode.getId())
        Metadata metadata = metaBuilder.build();
        final DiscoveryNode existingNode2 = new DiscoveryNode(
        final DiscoveryNode existingNode = new DiscoveryNode(
        assertThat(result.executionResults.entrySet(), hasSize(1));
        DiscoveryNode discoveryNode = newDiscoveryNode(Collections.singletonMap("zone", "zone-1"));
            .build();
        for (RepositoryMetadata repositoryMetadata : repositoriesMetadata.repositories()) {
            .nodes(
        DiscoveryNode joiningNode = newDiscoveryNode(Collections.emptyMap());
            .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "mixed")
        when(allocationService.adaptAutoExpandReplicas(any())).then(invocationOnMock -> invocationOnMock.getArguments()[0]);
            randomAlphaOfLength(10),
        });
    public void testUpdatesClusterStateWithMultiplePublicationNodeJoin() throws Exception {
                                + "]"
            Version.CURRENT
                Map<String, String> remoteStoreNodeAttributes = remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO + "new");
            {
        DiscoveryNode joiningNode = newDiscoveryNode(remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO));
        assertTrue(repositoriesMetadata.repositories().size() == 2);
        );
            Version.CURRENT
            buildNewFakeTransportAddress(),
            randomAlphaOfLength(10),
            List.of(new JoinTaskExecutor.Task(clusterManagerNode, "elect leader"))
            UUIDs.base64UUID(),
import org.opensearch.test.OpenSearchTestCase;
            remoteStoreNodeService
        );
        final ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
            IllegalStateException.class,
                    || e.getMessage()
            );
                + joiningNode
                }
            .nodes(DiscoveryNodes.builder().add(existingNode).localNodeId(existingNode.getId()).build())
            || repositoriesMetadata.repositories().size() == 4) {
                    .add(remoteNode)
            Version.CURRENT
            DecommissionStatus.IN_PROGRESS,
            Version.CURRENT
            buildNewFakeTransportAddress(),
        );
        );
        ClusterState currentState = ClusterState.builder(ClusterName.DEFAULT)
            .nodes(
        Map<String, String> remoteStoreNodeAttributes = remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO);
        // incompatible node should not be able to join a mixed mode
            .nodes(DiscoveryNodes.builder().add(existingNode).localNodeId(existingNode.getId()).build())
        );
                + "comparison with existing node ["
            } else if (repositoryMetadata.name().equals(routingTableRepoMetadata.name())) {
            UUIDs.base64UUID(),
            attributes,
import static org.opensearch.test.VersionUtils.randomCompatibleVersion;
        final DiscoveryNode nonRemoteStoreNode = new DiscoveryNode(
 * The OpenSearch Contributors require contributions made to
        ClusterState currentState = ClusterState.builder(result.resultingState).metadata(metadata).build();
            .build();
            .build();
        if (maxNodeVersion.compareMajor(minNodeVersion) == 0) {
            REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,
        assertTrue(taskResult1.isSuccess());
import org.opensearch.cluster.node.DiscoveryNodes;
        final ClusterStateTaskExecutor.TaskResult taskResult = result.executionResults.values().iterator().next();
            buildNewFakeTransportAddress(),
            .metadata(metadata)
            Locale.getDefault(),
        );
            remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO),
            DiscoveryNodeRole.BUILT_IN_ROLES,
            actualNode.getAttributes(),
        DecommissionAttributeMetadata decommissionAttributeMetadata = new DecommissionAttributeMetadata(
            higherVersion
            Version.CURRENT
        final ClusterStateTaskExecutor.ClusterTasksResult<JoinTaskExecutor.Task> result = joinTaskExecutor.execute(
            DiscoveryNodeRole.BUILT_IN_ROLES,
    @SuppressWarnings("removal")
                    .add(clusterManagerNode)
    private static final String COMMON_REPO = "remote-repo";
                putIfAbsent(translogRepositorySettingsAttributeKeyPrefix + "bucket", "translog_bucket");
        final RemoteStoreNodeService remoteStoreNodeService = mock(RemoteStoreNodeService.class);
                e.getMessage().equals("joining node [" + joiningNode + "] doesn't have the node attribute [" + nodeAttribute.getKey() + "]")
            .nodes(
        newNodeAttributes.putAll(remoteStateNodeAttributes(CLUSTER_STATE_REPO));
            .build();
    }
            clusterState,
            new SetOnce<>(mock(RepositoriesService.class))::get,
            )
            randomAlphaOfLength(10)
        final ClusterStateTaskExecutor.ClusterTasksResult<JoinTaskExecutor.Task> result = joinTaskExecutor.execute(
        );
        metaBuilder.put(indexMetadata, false);
        Map<String, String> settingsMap = node.getAttributes()
        Map<String, String> remoteStoreNodeAttributes = remoteStoreNodeAttributes(COMMON_REPO, COMMON_REPO);
        Map<String, String> existingNodeAttributes = remoteStateNodeAttributes(CLUSTER_STATE_REPO);
    @SuppressWarnings("removal")
        }
            List.of(new JoinTaskExecutor.Task(remoteStoreNode, "test"))
            .nodes(DiscoveryNodes.builder().add(existingNode).localNodeId(existingNode.getId()).build())
    }
import org.opensearch.cluster.ClusterState;
        );
 */
            .build();
        DiscoveryNode joiningNode = newDiscoveryNode(attr);
    private void validateRepositoriesMetadata(ClusterState updatedState, DiscoveryNode remoteNode, DiscoveryNode publicationNode)
                && nodeAttribute.getKey() != REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY
                        .equals(
        );
            Exception e = assertThrows(
            .build();
        final JoinTaskExecutor joinTaskExecutor = new JoinTaskExecutor(
            UUIDs.base64UUID(),
            remoteStoreNodeAttributes,
            } else if (repositoryMetadata.name().equals(clusterStateRepositoryMetadata.name())) {
    public void testUpdatesClusterStateWithSingleNodeClusterAndSameRepository() throws Exception {
            Version.CURRENT
                    .add(bwcNode)
        final DiscoveryNode decommissionedNode = new DiscoveryNode(
            REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,
            randomAlphaOfLength(10)
            decommissionAttribute,
                                + currentState.getNodes().getNodes().values().stream().findFirst().get()
            buildNewFakeTransportAddress(),
    }
        );
        final RepositoryMetadata routingTableRepoMetadata = buildRepositoryMetadata(existingNode, ROUTING_TABLE_REPO);
            buildNewFakeTransportAddress(),
        indexMetadata = IndexMetadata.builder("test1")
        Map<String, String> remoteStoreNodeAttributes = remoteStoreNodeAttributes(COMMON_REPO, COMMON_REPO);
        IndexMetadata indexMetadata = IndexMetadata.builder("test")
    public void testJoinClusterWithRemoteStoreNodeJoiningRemoteStoreCluster() {
            Version.CURRENT
import static org.opensearch.node.remotestore.RemoteStoreNodeService.MIGRATION_DIRECTION_SETTING;
 *
        JoinTaskExecutor.ensureNodesCompatibility(joiningNode, currentState.getNodes(), currentState.metadata());
            DiscoveryNodeRole.BUILT_IN_ROLES,
            clusterState,
                DiscoveryNodes.builder()
                assertTrue(clusterStateRepoMetadata.equalsIgnoreGenerations(repositoryMetadata));
        );
        return existingNodeAttributes;
            .metadata(metadata)
                    assertTrue(segmentRepositoryMetadata.equalsIgnoreGenerations(repositoryMetadata));
            UUIDs.base64UUID(),
        when(remoteStoreNodeService.updateRepositoriesMetadata(any(), any())).thenReturn(new RepositoriesMetadata(Collections.emptyList()));
            .build();
import org.opensearch.cluster.node.DiscoveryNode;
        final DiscoveryNode existingNode = new DiscoveryNode(UUIDs.base64UUID(), buildNewFakeTransportAddress(), Version.CURRENT);
            rerouteService,
    public void testRemoteRoutingTableNodeJoinRepoPresentInBothNode() {
        assertThat(result.executionResults.entrySet(), hasSize(1));
        DiscoveryNode docrepNode2 = new DiscoveryNode(UUIDs.base64UUID(), buildNewFakeTransportAddress(), Version.CURRENT);
                    .localNodeId(remoteNode.getId())
            new SetOnce<>(mock(RepositoriesService.class))::get,
        validateRepositoryMetadata(result.resultingState, clusterManagerNode, 3);
                DiscoveryNodes.builder()
        );
            }
        final RerouteService rerouteService = (reason, priority, listener) -> listener.onResponse(null);
import org.opensearch.repositories.blobstore.BlobStoreRepository;
                settings(VersionUtils.randomVersionBetween(random(), Version.CURRENT.minimumIndexCompatibilityVersion(), Version.CURRENT))
            .nodes(DiscoveryNodes.builder().add(existingNode2).add(existingNode).localNodeId(existingNode.getId()).build())
            IllegalStateException.class,
                JoinTaskExecutor.ensureNodesCompatibility(tooLowJoiningNode, nodes, metadata, minNodeVersion, maxNodeVersion);
            clusterState,
        DecommissionAttributeMetadata decommissionAttributeMetadata = new DecommissionAttributeMetadata(
        assertEquals(
            remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO),
        );
            buildNewFakeTransportAddress(),
        final ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
        Metadata metadata = Metadata.builder().decommissionAttributeMetadata(decommissionAttributeMetadata).build();
    public void testJoinClusterWithRemoteStateNodeJoiningRemoteStateCluster() {
            () -> JoinTaskExecutor.ensureNodesCompatibility(joiningNode, currentState.getNodes(), currentState.metadata())
        JoinTaskExecutor.ensureNodesCompatibility(joiningNode, currentState.getNodes(), currentState.metadata());
import org.opensearch.cluster.metadata.ViewMetadata;
        final DiscoveryNode clusterManagerNode = new DiscoveryNode(
            UUIDs.base64UUID(),
            }
        );
        );
/*
        if (repositoriesMetadata.repositories().size() == 2
            UUIDs.base64UUID(),
            UUIDs.base64UUID(),
            DecommissionStatus.SUCCESSFUL
            .nodes(DiscoveryNodes.builder().add(remoteStoreNode).add(nonRemoteStoreNode).localNodeId(remoteStoreNode.getId()).build())
        final DiscoveryNode joiningNode = new DiscoveryNode(
            clusterState,
    }
        );
            .metadata(metadata)
    }
        );
        );
            .numberOfReplicas(1)
                    .clusterManagerNodeId(clusterManagerNode.getId())
            Locale.getDefault(),
            List.of(new JoinTaskExecutor.Task(clusterManagerNode, "elect leader"))
    }
            rerouteService,
            .metadata(metadata)
        DiscoveryNode badRemoteNode = newDiscoveryNode(remoteStoreNodeAttributes(TRANSLOG_REPO, TRANSLOG_REPO));
            .nodes(
        final ClusterStateTaskExecutor.ClusterTasksResult<JoinTaskExecutor.Task> result = joinTaskExecutor.execute(
    private Map<String, String> remoteStoreNodeAttributes(String segmentRepoName, String translogRepoName) {
        DiscoveryNode discoveryNode = newDiscoveryNode(Collections.singletonMap("zone", "zone-2"));
        newNodeAttributes.putAll(remoteRoutingTableAttributes(ROUTING_TABLE_REPO));
        final RepositoriesMetadata repositoriesMetadata = updatedState.metadata().custom(RepositoriesMetadata.TYPE);
        DiscoveryNode joiningNode = newDiscoveryNode(remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO));
        ClusterState currentState = ClusterState.builder(ClusterName.DEFAULT)
            IllegalStateException.class,
            remoteStoreNodeService
            newNodeAttributes,
 * this work for additional information regarding copyright
            remoteStoreNodeAttributes,
        ClusterState currentState = ClusterState.builder(ClusterName.DEFAULT)
        JoinTaskExecutor.ensureNodesCompatibility(joiningNode, currentState.getNodes(), currentState.metadata());
        JoinTaskExecutor.ensureNodesCompatibility(joiningNode, currentState.getNodes(), currentState.metadata());
            .build();
        // the node didn't change roles, but the cluster state came via an older cluster-manager.
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT;
 *
            if (repositoryMetadata.name().equals(segmentRepositoryMetadata.name())) {
            Version.CURRENT
    private static final String CLUSTER_STATE_REPO = "cluster-state-repo";
            .metadata(Metadata.builder().putCustom(RepositoriesMetadata.TYPE, new RepositoriesMetadata(repositoriesMetadata)))
            allocationService,
        // compatible remote node should not be able to join a mixed mode having a remote node
import org.opensearch.common.SetOnce;
            allocationService,
                    .localNodeId(clusterManagerNode.getId())
