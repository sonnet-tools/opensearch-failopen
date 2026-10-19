            clusterState,
        when(allocationService.adaptAutoExpandReplicas(any())).then(invocationOnMock -> invocationOnMock.getArguments()[0]);  
        );
                    TRANSLOG_REPO,
            .metadata(metadata)
            DiscoveryNodeRole.BUILT_IN_ROLES,
        indexMetadata = IndexMetadata.builder("test1")
            .build();
            for (RepositoryMetadata repositoryMetadata : repositoriesMetadata.repositories()) {  
            List.of(new JoinTaskExecutor.Task(joiningNode, "test"))
        );
            }
            }  
        final RepositoryMetadata clusterStateRepo = buildRepositoryMetadata(clusterManagerNode, CLUSTER_STATE_REPO);  
            randomAlphaOfLength(10),  
                    || e.getMessage()
                                + joiningNode  
            buildNewFakeTransportAddress(),
        when(allocationService.adaptAutoExpandReplicas(any())).then(invocationOnMock -> invocationOnMock.getArguments()[0]);
            .nodes(DiscoveryNodes.builder().add(existingNode).localNodeId(existingNode.getId()).build())  
        final DiscoveryNode clusterManagerNode = new DiscoveryNode(  
        final AllocationService allocationService = mock(AllocationService.class);
            .nodes(
                    SEGMENT_REPO,  
            {
        validateRepositoriesMetadata(resultAfterRemoteNodeJoin.resultingState, remoteStoreNode, clusterManagerNode);
        for (Map.Entry<String, String> nodeAttribute : existingNodeAttributes.entrySet()) {
            Version.CURRENT  
            DiscoveryNodeRole.BUILT_IN_ROLES,
            IllegalStateException.class,
            }
        };
                add(clusterStateRepo);
            .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "mixed")
            )  
    }  
            Collections.singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),  
            buildNewFakeTransportAddress(),
            .nodes(DiscoveryNodes.builder().add(existingNode).localNodeId(existingNode.getId()).build())
        );
    private ClusterState joinNodeToClusterWithViewMetadata(DiscoveryNode clusterManagerNode, DiscoveryNode joiningNode) throws Exception {
        );  
        assertTrue(taskResult1.isSuccess());
        assertTrue(taskResult.isSuccess());  
    }  
        ClusterState currentState = ClusterState.builder(ClusterName.DEFAULT)
 * license agreements. See the NOTICE file distributed with
            UUIDs.base64UUID(),
        ClusterState currentState = ClusterState.builder(result.resultingState).metadata(metadata).build();  
        final RerouteService rerouteService = (reason, priority, listener) -> listener.onResponse(null);  
            clusterState,
                } else if (repositoryMetadata.name().equals(translogRepositoryMetadata.name())) {  
            List.of(new JoinTaskExecutor.Task(decommissionedNode, "test"))  
                        )
                putIfAbsent(translogRepositorySettingsAttributeKeyPrefix + "bucket", "translog_bucket");
import org.opensearch.cluster.ClusterStateTaskExecutor;  
        );
            .numberOfShards(1)  
                                + currentState.getNodes().getNodes().values().stream().findFirst().get()
import static org.hamcrest.Matchers.equalTo;  
        final ClusterStateTaskExecutor.ClusterTasksResult<JoinTaskExecutor.Task> resultAfterRemoteNodeJoin = joinTaskExecutor.execute(
        assertThat(result.executionResults.entrySet(), hasSize(1));
            .build();
            }
    public void testJoinRemotePubClusterWithRemoteStoreNodes() {  
        DiscoveryNodes.Builder builder = DiscoveryNodes.builder();
        assertThat(result.executionResults.entrySet(), hasSize(1));  
            .nodes(DiscoveryNodes.builder().add(existingNode2).add(existingNode).localNodeId(existingNode.getId()).build())
        validateRepositoriesMetadata(resultAfterRemoteNodeJoin.resultingState, clusterManagerNode, remotePublicationNode);
            UUIDs.base64UUID(),
        };
            .nodes(DiscoveryNodes.builder().add(existingNode).localNodeId(existingNode.getId()).build())
            List.of(new JoinTaskExecutor.Task(joiningNode, "test"))  
                    || e.getMessage()  
import org.opensearch.cluster.metadata.Metadata;  
            buildNewFakeTransportAddress(),
            .nodes(DiscoveryNodes.builder().add(existingNode).localNodeId(existingNode.getId()).build())  
            IllegalStateException.class,
            Version.CURRENT  
            .nodes(  
        JoinTaskExecutor.ensureNodesCompatibility(joiningNode, currentState.getNodes(), currentState.metadata());
            buildNewFakeTransportAddress(),  
        Exception e = assertThrows(  
        assertTrue(taskResult.isSuccess());
            buildNewFakeTransportAddress(),
        assertEquals(  
            attr,
        );
            buildNewFakeTransportAddress(),
        );  
        Settings.builder().build();  
    public void testJoinFailedForDecommissionedNode() throws Exception {
        final AllocationService allocationService = mock(AllocationService.class);
                    .add(clusterManagerNode)
import java.util.Map;
        when(allocationService.adaptAutoExpandReplicas(any())).then(invocationOnMock -> invocationOnMock.getArguments()[0]);
                DiscoveryNodes.builder()
        DiscoveryNode goodRemoteNode = newDiscoveryNode(remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO));  
            DiscoveryNodeRole.BUILT_IN_ROLES,
        );  
            UUIDs.base64UUID(),
            || repositoriesMetadata.repositories().size() == 3
                put(REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY, clusterStateRepo);  
            .metadata(Metadata.builder().putCustom(RepositoriesMetadata.TYPE, new RepositoriesMetadata(repositoriesMetadata)))  
            } else {
        final RemoteStoreNodeService remoteStoreNodeService = new RemoteStoreNodeService(  
            () -> JoinTaskExecutor.ensureNodesCompatibility(joiningNode1, currentNodes, metadata)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final DiscoveryNode existingNode = new DiscoveryNode(  
        final Settings settings = Settings.builder()  
            .put(MIGRATION_DIRECTION_SETTING.getKey(), RemoteStoreNodeService.Direction.REMOTE_STORE)
            DiscoveryNodeRole.BUILT_IN_ROLES,  
                    .localNodeId(clusterManagerNode.getId())
        );
            .nodes(DiscoveryNodes.builder().add(existingNode).localNodeId(existingNode.getId()).build())  
        assertEquals(reason, exception.getMessage());
        String clusterStateRepositorySettingsAttributeKeyPrefix = String.format(
        assertTrue(taskResult.isSuccess());  
    public void testUpdatesClusterStateWithMultiplePublicationNodeJoin() throws Exception {
            UUIDs.base64UUID(),  
        );
        final RepositoryMetadata segmentRepositoryMetadata = buildRepositoryMetadata(clusterManagerNode, SEGMENT_REPO);
        final ClusterState result = joinNodeToClusterWithViewMetadata(clusterManagerNode, joiningNode);
            .build();  
        final View view = new View("logs", "all logs", 1L, 1L, Set.of(new View.Target("logs-*")));
            UUIDs.base64UUID(),
            Settings.EMPTY,
import static org.opensearch.test.VersionUtils.randomVersionBetween;
            UUIDs.base64UUID(),
            logger,
            Locale.ROOT,
            currentState,
        assertTrue(taskResult.isSuccess());
        DiscoveryNode joiningNode = newDiscoveryNode(attr);
                validateAttributes(remoteStoreNodeAttributes, currentState, existingNode);
        } else {
        DiscoveryNode discoveryNode = newDiscoveryNode(Collections.singletonMap("zone", "zone-1"));
            || repositoriesMetadata.repositories().size() == 4) {  
            rerouteService,
            UUIDs.base64UUID(),
                                + "] is trying to join a remote store cluster with incompatible node attributes in comparison with existing node ["
                putIfAbsent(routingTableRepositorySettingsAttributeKeyPrefix + "base_path", "/state/path");
            DiscoveryNodeRole.BUILT_IN_ROLES,  
            if (nodeAttribute.getKey() != REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY
import static org.opensearch.test.VersionUtils.maxCompatibleVersion;
        JoinTaskExecutor.ensureNodesCompatibility(joiningNode, currentState.getNodes(), currentState.metadata());  
            joiningNode1.getVersion(),
            buildNewFakeTransportAddress(),
            clusterManagerClusterState,
            DiscoveryNodeRole.BUILT_IN_ROLES,
        DiscoveryNode joiningNode = newDiscoveryNode(remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO));
    }
            .build();
            DecommissionStatus.SUCCESSFUL  
        DiscoveryNode remoteNode = newDiscoveryNode(remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO));
        final RepositoriesMetadata repositoriesMetadata = updatedState.metadata().custom(RepositoriesMetadata.TYPE);
    public void testUpdatesClusterStateWithMultiNodeCluster() throws Exception {  
        final DiscoveryNode clusterManagerNode = new DiscoveryNode(UUIDs.base64UUID(), buildNewFakeTransportAddress(), Version.CURRENT);  
    public void testAllTypesNodeJoiningRemoteStoreClusterMixedMode() {  
            )
    }  
                && nodeAttribute.getKey() != REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY
 * software distributed under the License is distributed on an
            DiscoveryNodeRole.BUILT_IN_ROLES,
            Version oldMajor = minNodeVersion.minimumCompatibilityVersion();
    }  
        final RerouteService rerouteService = (reason, priority, listener) -> listener.onResponse(null);
        final ClusterStateTaskExecutor.TaskResult taskResult = result.executionResults.values().iterator().next();
                settings(VersionUtils.randomVersionBetween(random(), Version.CURRENT.minimumIndexCompatibilityVersion(), Version.CURRENT))  
                validateAttributes(remoteStoreNodeAttributes, currentState, existingNode);  
                DiscoveryNodes.builder()
            List.of(new JoinTaskExecutor.Task(clusterManagerNode, "elect leader"))  
        Metadata.Builder metaBuilder = Metadata.builder();
        });
        assertFalse(taskResult.isSuccess());
        Map<String, String> existingNodeAttributes = remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO);  
            allocationService,
            .nodes(DiscoveryNodes.builder().add(existingNode).localNodeId(existingNode.getId()).build())
        final RepositoryMetadata translogRepositoryMetadata = buildRepositoryMetadata(clusterManagerNode, TRANSLOG_REPO);  
            remoteStoreNodeAttributes,
    }
            assertTrue(
        validateRepositoryMetadata(result.resultingState, clusterManagerNode, 2);
            DiscoveryNodeRole.BUILT_IN_ROLES,
                put(segmentRepositorySettingsAttributeKeyPrefix + "base_path", "/segment/path");
        when(allocationService.adaptAutoExpandReplicas(any())).then(invocationOnMock -> invocationOnMock.getArguments()[0]);
 * under the License.  
                    .localNodeId(clusterManagerNode.getId())  
            DiscoveryNodeRole.BUILT_IN_ROLES,
import org.opensearch.cluster.routing.RerouteService;
    }  
        final RepositoryMetadata routingTableRepo = buildRepositoryMetadata(clusterManagerNode, ROUTING_TABLE_REPO);
        return result.resultingState;
        final JoinTaskExecutor joinTaskExecutor = new JoinTaskExecutor(
            .stream()  
        final RerouteService rerouteService = (reason, priority, listener) -> listener.onResponse(null);
import org.opensearch.common.settings.Settings;  
        } else {
            .build();
        final DiscoveryNode joiningNode = new DiscoveryNode(  
            UUIDs.base64UUID(),
    }  
            Exception e = assertThrows(
        ClusterState currentState = ClusterState.builder(ClusterName.DEFAULT)
        final AllocationService allocationService = mock(AllocationService.class);
import static org.opensearch.node.remotestore.RemoteStoreNodeService.MIGRATION_DIRECTION_SETTING;
        final ClusterStateTaskExecutor.TaskResult taskResult = result.executionResults.values().iterator().next();
        );
    private static final String COMMON_REPO = "remote-repo";
            );  
                    .localNodeId(clusterManagerNode.getId())  
            .build();  
            } else if (REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY.equals(nodeAttribute.getKey())) {
                    .localNodeId(docrepNode.getId())  
        Metadata metadata = Metadata.builder().decommissionAttributeMetadata(decommissionAttributeMetadata).build();
            .build();
    @LockFeatureFlag(REMOTE_STORE_MIGRATION_EXPERIMENTAL)
        );
    }
            randomAlphaOfLength(10)
            UUIDs.base64UUID(),  
        return remoteStoreNodeAttributes(segmentRepoName, translogRepoName, CLUSTER_STATE_REPO);
            remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO),
            logger,
                        .equals(
            Version.CURRENT
    private static final String CLUSTER_STATE_REPO = "cluster-state-repo";  
        final Version version = randomOpenSearchVersion(random());  
            )
        final DiscoveryNode clusterManagerNode = new DiscoveryNode(
        when(remoteStoreNodeService.updateRepositoriesMetadata(any(), any())).thenReturn(new RepositoriesMetadata(Collections.emptyList()));
        final JoinTaskExecutor joinTaskExecutor = new JoinTaskExecutor(
            final RepositoryMetadata translogRepositoryMetadata = buildRepositoryMetadata(existingNode, TRANSLOG_REPO);
        Metadata metadata = Metadata.builder().decommissionAttributeMetadata(decommissionAttributeMetadata).build();
            REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,  
        DiscoveryNode joiningNode1 = new DiscoveryNode(  
import org.opensearch.cluster.metadata.View;  
        final ClusterStateTaskExecutor.ClusterTasksResult<JoinTaskExecutor.Task> result = joinTaskExecutor.execute(  
                                + "] is trying to join a remote store cluster with incompatible node attributes in comparison with existing node ["
import static org.hamcrest.Matchers.hasSize;
 * compatible open source license.
            .build();
            remotePublicationNodeAttributes(),
        );
            Locale.getDefault(),
        final RemoteStoreNodeService remoteStoreNodeService = new RemoteStoreNodeService(
                putAll(remoteStateNodeAttributes(clusterStateRepo));
import static org.opensearch.test.VersionUtils.randomOpenSearchVersion;
            .nodes(DiscoveryNodes.builder().add(existingNode).localNodeId(existingNode.getId()).build())
            Version.CURRENT
                            "a remote store node ["  
        final DiscoveryNode existingNode = new DiscoveryNode(UUIDs.base64UUID(), buildNewFakeTransportAddress(), Version.CURRENT);
            rerouteService,  
        DiscoveryNode joiningNode = newDiscoveryNode(remoteStateNodeAttributes(CLUSTER_STATE_REPO));
        validatePublicationRepositoryMetadata(result.resultingState, clusterManagerNode);
            Version.CURRENT
        when(repositoriesService.repository(any())).thenThrow(RepositoryMissingException.class);
            Settings.EMPTY,  
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX;
        Settings.builder().build();
            UUIDs.base64UUID(),  
            buildNewFakeTransportAddress(),  
                + joiningNode  
        Metadata metadata = Metadata.builder().persistentSettings(settings).build();  
 */  
        final DiscoveryNode clusterManagerNode = new DiscoveryNode(
    public void testPreventJoinRemotePublicationClusterWithIncompatibleAttributes() {
        assertThrows(
        );
        when(allocationService.adaptAutoExpandReplicas(any())).then(invocationOnMock -> invocationOnMock.getArguments()[0]);
        ClusterState currentState = ClusterState.builder(ClusterName.DEFAULT)  
            }  
        );
            IllegalStateException.class,  
        final DiscoveryNode existingNode = new DiscoveryNode(
        final Version minGoodVersion;  
            decommissionAttribute,
        throws Exception {  
    }  
        Settings.builder().build();
        assertThat(joinTaskOfClusterManager.isBecomeClusterManagerTask(), is(true));
    }
                put(REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY, segmentRepoName);
        DecommissionAttribute decommissionAttribute = new DecommissionAttribute("zone", "zone1");
        Map<String, String> nodeAttributes = node.getAttributes();  
            remoteStoreNodeAttributes,
            DiscoveryNodeRole.BUILT_IN_ROLES,
        ClusterState currentState = ClusterState.builder(ClusterName.DEFAULT)  
            DiscoveryNodeRole.BUILT_IN_ROLES,
            Version.CURRENT
            allocationService,  
            Version.CURRENT  
        JoinTaskExecutor.ensureNodesCompatibility(goodRemoteNode, currentState.getNodes(), currentState.metadata());
                    .add(clusterManagerNode)  
        return new HashMap<>() {
        DecommissionAttributeMetadata decommissionAttributeMetadata = new DecommissionAttributeMetadata(
        List<RepositoryMetadata> repositoriesMetadata = new ArrayList<>() {  
            currentNodes.getMaxNodeVersion()
import org.opensearch.cluster.decommission.DecommissionStatus;  
        final ClusterStateTaskExecutor.ClusterTasksResult<JoinTaskExecutor.Task> result = joinTaskExecutor.execute(
            Version.CURRENT
    public void testJoinClusterWithDifferentDecommission() {  
        );
        final DiscoveryNode clusterManagerNode = new DiscoveryNode(
            Version.CURRENT
            Version.CURRENT  
        final ClusterStateTaskExecutor.TaskResult taskResult1 = resultAfterRemoteNodeJoin.executionResults.values().iterator().next();
                remoteStoreNodeAttributes.put(nodeAttribute.getKey(), nodeAttribute.getValue() + "-new");
            .build();  
        ClusterState currentState = ClusterState.builder(ClusterName.DEFAULT)
        // joining node of the same version as the current nodes  
        assertEquals(4, repositoriesMetadata.repositories().size());  
        Map<String, String> remoteStoreNodeAttributes = remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO);
                assertTrue(translogRepositoryMetadata.equalsIgnoreGenerations(repositoryMetadata));
                    .clusterManagerNodeId(clusterManagerNode.getId())
            clusterState,
                    CLUSTER_STATE_REPO + "new"
        // incompatible node should not be able to join a mixed mode  
        );
        return new RepositoryMetadata(name, type, settings.build());  
    public void testPreventJoinClusterWithRemoteStoreNodeJoiningNonRemoteStoreCluster() {
            remoteStoreNodeAttributes,
        );
        ClusterState currentState = ClusterState.builder(ClusterName.DEFAULT)
                    .clusterManagerNodeId(clusterManagerNode.getId())
    private Map<String, String> remoteStoreNodeAttributes(String segmentRepoName, String translogRepoName, String clusterStateRepo) {
    private void validateRepositoriesMetadata(ClusterState updatedState, DiscoveryNode remoteNode, DiscoveryNode publicationNode)
        final DiscoveryNode existingNode = new DiscoveryNode(
            UUIDs.base64UUID(),  
            () -> JoinTaskExecutor.ensureNodesCompatibility(joiningNode, currentState.getNodes(), currentState.metadata())
            .nodes(DiscoveryNodes.builder().add(existingNode).localNodeId(existingNode.getId()).build())  
            DiscoveryNodeRole.BUILT_IN_ROLES,
            if (repositoryMetadata.name().equals(clusterStateRepoMetadata.name())) {  
        );
            DiscoveryNode joiningNode = newDiscoveryNode(remoteStoreNodeAttributes);  
            "remote migration : a node [%s] of higher version [%s] is not allowed to join a cluster with maximum version [%s]",
        newNodeAttributes.putAll(remoteRoutingTableAttributes(ROUTING_TABLE_REPO));
            randomAlphaOfLength(10),
            new SetOnce<>(mock(RepositoriesService.class))::get,
            .nodes(  
    public void testRemoteRoutingTableNodeJoinRepoPresentInJoiningNode() {  
                    .add(clusterManagerNode)  
    /**
            IllegalStateException.class,  
        if (repositoriesMetadata.repositories().size() == 2
 * SPDX-License-Identifier: Apache-2.0
                Map<String, String> remoteStoreNodeAttributes = remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO + "new");
        final RerouteService rerouteService = (reason, priority, listener) -> listener.onResponse(null);
            buildNewFakeTransportAddress(),
        DiscoveryNode joiningNode = newDiscoveryNode(remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO));
        ClusterState currentState = ClusterState.builder(ClusterName.DEFAULT)
        );
            Settings.EMPTY,
            DiscoveryNodeRole.BUILT_IN_ROLES,
            DiscoveryNodeRole.BUILT_IN_ROLES,  
            buildNewFakeTransportAddress(),
    public void testJoinClusterWithNonRemoteStoreNodeJoining() {
        final ClusterStateTaskExecutor.TaskResult taskResult = result.executionResults.values().iterator().next();  
            .build();
        ClusterState currentState = ClusterState.builder(ClusterName.DEFAULT)  
            .numberOfReplicas(1)  
        final ClusterStateTaskExecutor.TaskResult taskResult = result.executionResults.values().iterator().next();
        expectThrows(NodeDecommissionedException.class, () -> JoinTaskExecutor.ensureNodeCommissioned(discoveryNode, metadata));  
            UUIDs.base64UUID(),
            Collections.singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
import org.opensearch.repositories.RepositoryMissingException;  
                add(routingTableRepo);
            rerouteService,  
        final Version maxNodeVersion = nodes.getMaxNodeVersion();
        final ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
                        .equals(
            allocationService,  
            Version.CURRENT
    public void testPreventJoinClusterWithRemoteStateNodeJoiningRemoteStoreCluster() {
        assertThat(result.executionResults.entrySet(), hasSize(1));
        DecommissionAttributeMetadata decommissionAttributeMetadata = new DecommissionAttributeMetadata(  
    }  
            newNodeAttributes,
        JoinTaskExecutor.ensureNodeCommissioned(discoveryNode, metadata);
        assertTrue(taskResult.isSuccess());
 *
                    .add(clusterManagerNode)
    public void testJoinRemoteStoreClusterWithRemotePublicationNodeInMixedMode() {
            Collections.singletonMap("zone", "zone1"),  
    }
        assertThat(result.resultingState.getNodes().get(actualNode.getId()).getRoles(), equalTo(actualNode.getRoles()));
        Map<String, String> map = remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO);  
    public void testPreventJoinClusterWithRemoteStoreNodeJoiningRemoteStateCluster() {
    @SuppressWarnings("removal")
            actualNode.getVersion()  
        ClusterState currentState = ClusterState.builder(ClusterName.DEFAULT)
                add(translogRepositoryMetadata);
        DiscoveryNode joiningNode = newDiscoveryNode(remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO));  
        if (randomBoolean()) {
        Metadata metadata = Metadata.builder().persistentSettings(settings).build();
import org.opensearch.node.remotestore.RemoteStoreNodeService;
            Version.CURRENT  
        final RerouteService rerouteService = (reason, priority, listener) -> listener.onResponse(null);  
        assertThat(result.executionResults.entrySet(), hasSize(1));
            Version.CURRENT  
        Map<String, String> attr = remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO);  
    }
import org.opensearch.cluster.routing.allocation.AllocationService;  
            .settings(
        ClusterState currentState = ClusterState.builder(ClusterName.DEFAULT)
        );
            remoteStoreNodeAttributes,  
            allocationService,  
            List.of(new JoinTaskExecutor.Task(joiningNode, "test"))
    public void testUpdatesRepoRemoteNodeJoinPublicationCluster() throws Exception {
        validatePublicationRepositoryMetadata(result.resultingState, clusterManagerNode);
 * GitHub history for details.
            buildNewFakeTransportAddress(),  
                    .clusterManagerNodeId(clusterManagerNode.getId())
            "a remote store node ["
        );  
        validateRepositoryMetadata(result.resultingState, clusterManagerNode, 3);  
            Version.CURRENT  
        }
            new SetOnce<>(mock(RepositoriesService.class))::get,
        );  
        JoinTaskExecutor.ensureNodesCompatibility(joiningNode, currentState.getNodes(), currentState.metadata());
            Collections.singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
                DiscoveryNodes.builder()
            DiscoveryNodeRole.BUILT_IN_ROLES,
            UUIDs.base64UUID(),
    private Map<String, String> remotePublicationNodeAttributes() {  
            {
                    .add(clusterManagerNode)
    }
            rerouteService,
    }
            .nodes(DiscoveryNodes.builder().add(existingNode).localNodeId(existingNode.getId()).build())  
                assertTrue(clusterStateRepositoryMetadata.equalsIgnoreGenerations(repositoryMetadata));  
            .numberOfReplicas(1)  
                    .clusterManagerNodeId(clusterManagerNode.getId())
    }
        final JoinTaskExecutor joinTaskExecutor = new JoinTaskExecutor(
        );
            UUIDs.base64UUID(),
            .metadata(Metadata.builder().putCustom(ViewMetadata.TYPE, new ViewMetadata(Map.of("logs", view))))  
            Version.CURRENT  
        final RepositoryMetadata clusterStateRepoMetadata = buildRepositoryMetadata(existingNode, CLUSTER_STATE_REPO);  
            UUIDs.base64UUID(),
            DecommissionStatus.FAILED,
import java.util.List;  
            buildNewFakeTransportAddress(),  
        ClusterState currentState = ClusterState.builder(ClusterName.DEFAULT)
    public void testDropsViewMetadataOnceAllNodesAreUpgraded() throws Exception {  
    }
        when(allocationService.adaptAutoExpandReplicas(any())).then(invocationOnMock -> invocationOnMock.getArguments()[0]);  
        DiscoveryNode joiningNode = newDiscoveryNode(remoteStateNodeAttributes(CLUSTER_STATE_REPO));  
            .build();  
        );
            rerouteService,
            UUIDs.base64UUID(),  
        JoinTaskExecutor.Task joinTaskOfClusterManager = JoinTaskExecutor.newBecomeClusterManagerTask();  
            UUIDs.base64UUID(),  
        Map<String, String> remoteStoreNodeAttributes = remotePublicationNodeAttributes();  
            () -> JoinTaskExecutor.ensureNodesCompatibility(joiningNode, currentState.getNodes(), currentState.metadata())  
import org.opensearch.cluster.ClusterState;
            final RepositoryMetadata segmentRepositoryMetadata = buildRepositoryMetadata(existingNode, SEGMENT_REPO);
            }
        Settings mixedModeCompatibilitySettings = Settings.builder()
import static org.opensearch.node.remotestore.RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING;
        );
            new SetOnce<>(mock(RepositoriesService.class))::get,
        final JoinTaskExecutor joinTaskExecutor = new JoinTaskExecutor(
        builder.add(new DiscoveryNode(UUIDs.base64UUID(), buildNewFakeTransportAddress(), version));
        final RepositoryMetadata translogRepositoryMetadata = buildRepositoryMetadata(remoteNode, TRANSLOG_REPO);
            Version.CURRENT
    }  
                assertTrue(segmentRepositoryMetadata.equalsIgnoreGenerations(repositoryMetadata));
        // Node roles vary by version, and new roles are suppressed for BWC.
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY;
import java.util.Locale;
            buildNewFakeTransportAddress(),  
            () -> JoinTaskExecutor.ensureNodesCompatibility(joiningNode, currentState.getNodes(), currentState.metadata())
            Version.CURRENT
package org.opensearch.cluster.coordination;
 * not use this file except in compliance with the License.
        Metadata metadata = Metadata.builder().decommissionAttributeMetadata(decommissionAttributeMetadata).build();
    public void testUpdatesRepoPublicationNodeJoinRemoteCluster() throws Exception {  
        newNodeAttributes.putAll(remoteStateNodeAttributes(CLUSTER_STATE_REPO));
            }  
            remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO),
            .localNodeId(currentNode2.getId())
            UUIDs.base64UUID(),
            buildNewFakeTransportAddress(),
    }  
        assertTrue(taskResult.isSuccess());  
            buildNewFakeTransportAddress(),  
            DiscoveryNodeRole.BUILT_IN_ROLES,
        assertTrue(taskResult1.isSuccess());  
        final ClusterStateTaskExecutor.ClusterTasksResult<JoinTaskExecutor.Task> result = joinTaskExecutor.execute(
            Version.CURRENT
        final RepositoriesMetadata repositoriesMetadata = updatedState.metadata().custom(RepositoriesMetadata.TYPE);
            new HashMap<>(),
        ClusterState currentState = ClusterState.builder(ClusterName.DEFAULT)  
            Settings.EMPTY,
            randomAlphaOfLength(10),
        return new DiscoveryNode(
            .nodes(  
/*  
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY;
import org.opensearch.cluster.ClusterName;
 * this work for additional information regarding copyright
            buildNewFakeTransportAddress(),
        return new HashMap<>() {  
            allocationService,
    public void testPreventJoinClusterWithRemoteStoreNodeWithDifferentNameAttributesJoiningRemoteStoreCluster() {
        ClusterState currentState = ClusterState.builder(ClusterName.DEFAULT)
        Map<String, String> remoteStoreNodeAttributes = remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO);
            remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO),
            clusterStateRepo
            .nodes(DiscoveryNodes.builder().add(existingNode).localNodeId(existingNode.getId()).build())
        };  
            e.getMessage(),
            .nodes(DiscoveryNodes.builder().add(joiningNode).build())  
            .build();
            .metadata(metadata)
            attr,
 * specific language governing permissions and limitations
                DiscoveryNodes.builder()
            Version.CURRENT
            Version.CURRENT
            )
            remoteStoreNodeAttributes,  
import java.util.stream.Collectors;
            .build();
        );
            logger,  
        attr.putAll(remoteRoutingTableAttributes(ROUTING_TABLE_REPO));
            Settings.EMPTY,  
            .build();
    public void testRemoteRoutingTableNodeJoinRepoPresentInBothNode() {
            )  
        final RemoteStoreNodeService remoteStoreNodeService = new RemoteStoreNodeService(
    public void testRemoteRoutingTableNodeJoinRepoPresentInExistingNode() {  
 * Licensed to Elasticsearch under one or more contributor  
        );  
            REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,
        );
        final ClusterStateTaskExecutor.ClusterTasksResult<JoinTaskExecutor.Task> result = joinTaskExecutor.execute(  
            .nodes(DiscoveryNodes.builder().add(joiningNode).build())
                    final RepositoryMetadata clusterStateRepoMetadata = buildRepositoryMetadata(existingNode, CLUSTER_STATE_REPO);  
    public void testJoinRemotePublicationClusterWithNonRemoteNodes() {
        metaBuilder.put(indexMetadata, false);
        IndexMetadata indexMetadata = IndexMetadata.builder("test")
        ClusterState currentState = ClusterState.builder(ClusterName.DEFAULT)
            allocationService,  
            remoteStoreNodeService  
        for (RepositoryMetadata repositoryMetadata : repositoriesMetadata.repositories()) {  
        JoinTaskExecutor.ensureNodesCompatibility(joiningNode, currentState.getNodes(), currentState.metadata());
            )
public class JoinTaskExecutorTests extends OpenSearchTestCase {
            } else if (REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY.equals(nodeAttribute.getKey())) {
            .nodes(  
        final RerouteService rerouteService = (reason, priority, listener) -> listener.onResponse(null);
        final JoinTaskExecutor joinTaskExecutor = new JoinTaskExecutor(  
                + existingNode  
        Metadata metadata = Metadata.EMPTY_METADATA;
        DecommissionStatus decommissionStatus = randomFrom(  
                putIfAbsent(routingTableRepositorySettingsAttributeKeyPrefix + "bucket", "state_bucket");  
    }
                    .add(docrepNode)
    }  
            buildNewFakeTransportAddress(),
    }
            remoteStoreNodeAttributes,  
        DiscoveryNode joiningNode = newDiscoveryNode(Collections.emptyMap());  
            Settings.EMPTY,  
        DecommissionAttribute decommissionAttribute = new DecommissionAttribute("zone", "zone-1");
        );
        JoinTaskExecutor.ensureNodeCommissioned(discoveryNode, metadata);
            {
                putIfAbsent(clusterStateRepositoryTypeAttributeKey, "s3");
                    .clusterManagerNodeId(clusterManagerNode.getId())
            .build();
        for (RepositoryMetadata repositoryMetadata : repositoriesMetadata.repositories()) {
            DecommissionStatus.IN_PROGRESS,
 *  
        );  
            () -> JoinTaskExecutor.ensureNodesCompatibility(badRemoteNode, currentState.getNodes(), currentState.metadata())
        final DiscoveryNode tooLowJoiningNode = new DiscoveryNode(  
        final RemoteStoreNodeService remoteStoreNodeService = new RemoteStoreNodeService(new SetOnce<>(repositoriesService)::get, null);  
            logger,
            buildNewFakeTransportAddress(),
            .numberOfShards(1)
        final RemoteStoreNodeService remoteStoreNodeService = new RemoteStoreNodeService(  
            .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "mixed")
        Map<String, String> existingNodeAttributes = remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO);
    }
            rerouteService,  
                validateAttributes(remoteStoreNodeAttributes, currentState, existingNode);  
                assertTrue(repositoryMetadata.equalsIgnoreGenerations(routingTableRepositoryMetadata));
        Metadata.Builder metaBuilder = Metadata.builder();
                put(REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY, translogRepoName);  
            DiscoveryNodeRole.BUILT_IN_ROLES,  
            null
        Map<String, String> attr = remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO);
        final DiscoveryNode existingNode = new DiscoveryNode(UUIDs.base64UUID(), buildNewFakeTransportAddress(), Version.CURRENT);
            DecommissionStatus.DRAINING  
        DiscoveryNode joiningNode = newDiscoveryNode(remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO));  
            UUIDs.base64UUID(),
    public void testSuccess() {
            Version.CURRENT
                assertTrue(routingTableRepoMetadata.equalsIgnoreGenerations(repositoryMetadata));  
            .build();  
            allocationService,
            remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO),
        );
    public void testJoinClusterWithNoDecommission() {
                    .add(clusterManagerNode)
            repoName
        JoinTaskExecutor.ensureNodesCompatibility(joiningNode, currentState.getNodes(), currentState.metadata());
            DiscoveryNodeRole.BUILT_IN_ROLES,
        when(allocationService.adaptAutoExpandReplicas(any())).then(invocationOnMock -> invocationOnMock.getArguments()[0]);
        DiscoveryNode joiningNode = newDiscoveryNode(attr);
            .add(currentNode2)
            .numberOfShards(1)
            buildNewFakeTransportAddress(),
            allocationService,
            Locale.getDefault(),
        ClusterState currentState = ClusterState.builder(ClusterName.DEFAULT)
            UUIDs.base64UUID(),
        Map<String, String> attr = remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO);  
        final AllocationService allocationService = mock(AllocationService.class);  
    }  
                    .localNodeId(clusterManagerNode.getId())  
        }
            .build();  
                () -> JoinTaskExecutor.ensureNodesCompatibility(joiningNode, currentState.getNodes(), currentState.metadata())  
        DiscoveryNode joiningNode2 = new DiscoveryNode(
        return new HashMap<>() {
            logger,
        ClusterState currentState = ClusterState.builder(ClusterName.DEFAULT)  
            List.of(new JoinTaskExecutor.Task(clusterManagerNode, "elect leader"))
    }
            DiscoveryNodeRole.BUILT_IN_ROLES,  
        final ClusterStateTaskExecutor.ClusterTasksResult<JoinTaskExecutor.Task> result = joinTaskExecutor.execute(
        String settingsAttributeKeyPrefix = String.format(Locale.getDefault(), REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX, name);  
            actualNode.getAttributes(),
            .put(MIGRATION_DIRECTION_SETTING.getKey(), RemoteStoreNodeService.Direction.REMOTE_STORE)
     */
        Metadata metadata = metaBuilder.build();
        assertTrue(repositoriesMetadata.repositories().size() == 2);
        Metadata metadata = Metadata.builder().persistentSettings(settings).build();
        ClusterState currentState = ClusterState.builder(ClusterName.DEFAULT)  
        Metadata.Builder metaBuilder = Metadata.builder();  
                    .add(clusterManagerNode)
            Version.CURRENT
            }  
        final ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
                DiscoveryNodes.builder()
                put(REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY, repoName);
        String clusterStateRepositoryTypeAttributeKey = String.format(
            null
            existingNodeAttributes,  
import static org.hamcrest.Matchers.is;
    }
        Settings.builder().build();
        settingsMap.entrySet().forEach(entry -> settings.put(entry.getKey(), entry.getValue()));
            .build();
    }  
            Version.CURRENT  
            List.of(new JoinTaskExecutor.Task(joiningNode, "test"))
        );  
    public void testRemoteRoutingTableRepoAbsentNodeJoin() {  
        final Version justGood = randomVersionBetween(random(), minGoodVersion, maxCompatibleVersion(minNodeVersion));
                IllegalStateException.class,
            DiscoveryNodeRole.BUILT_IN_ROLES,
            .nodes(
            DiscoveryNodeRole.BUILT_IN_ROLES,
        Map<String, String> existingNodeAttributes = remoteStateNodeAttributes(CLUSTER_STATE_REPO);
            .nodes(  
        Settings.builder().build();
        Exception e = assertThrows(
            Version.CURRENT
    public void testJoinClusterWithRemoteStoreNodeJoiningRemoteStoreCluster() {  
            .build();
            if (REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY.equals(nodeAttribute.getKey())) {
import java.util.HashMap;
        final ClusterStateTaskExecutor.TaskResult taskResult = result.executionResults.values().iterator().next();
            {  
            buildNewFakeTransportAddress(),  
            remoteStoreNodeAttributes.put(nodeAttribute.getKey(), null);
                put(segmentRepositorySettingsAttributeKeyPrefix + "bucket", "segment_bucket");
                    .localNodeId(clusterManagerNode.getId())  
        );
            .put(MIGRATION_DIRECTION_SETTING.getKey(), RemoteStoreNodeService.Direction.REMOTE_STORE)
            () -> JoinTaskExecutor.ensureNodesCompatibility(joiningNode, currentState.getNodes(), currentState.metadata())  
            IllegalStateException.class,
            existingNodeAttributes,
    }  
        );
    public void testIsBecomeClusterManagerTask() {
            Version.CURRENT
            UUIDs.base64UUID(),
            minGoodVersion = minNodeVersion;  
            .nodes(DiscoveryNodes.builder().add(existingNode2).add(existingNode).localNodeId(existingNode.getId()).build())
        DiscoveryNode joiningNode = newDiscoveryNode(Collections.emptyMap());  
        final ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
            UUIDs.base64UUID(),
            randomAlphaOfLength(10),
        expectThrows(  
                putIfAbsent(clusterStateRepositorySettingsAttributeKeyPrefix + "base_path", "/state/path");  
            UUIDs.base64UUID(),
        JoinTaskExecutor.ensureIndexCompatibility(Version.CURRENT, metadata);
        );  
            DecommissionStatus.SUCCESSFUL,
        assertThat(result.executionResults.entrySet(), hasSize(1));  
        assertTrue(e.getMessage().equals("a remote store node [" + joiningNode + "] is trying to join a non remote " + "store cluster"));
        final DiscoveryNode existingNode = new DiscoveryNode(  
    }
    public void testUpdatesNodeWithNewRoles() throws Exception {
            {  
            null
            randomAlphaOfLength(10),
            .localNodeId(currentNode1.getId())  
        final ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
    }
            remoteStoreNodeService  
        DecommissionAttribute decommissionAttribute = new DecommissionAttribute("zone", "zone-1");
            IllegalStateException.class,
            .metadata(Metadata.builder().putCustom(RepositoriesMetadata.TYPE, new RepositoriesMetadata(repositoriesMetadata)))
            new SetOnce<>(mock(RepositoriesService.class))::get,  
/*
    }
        String reason = String.format(  
    public void testPreventJoinClusterWithRemoteStoreNodeWithPartialAttributesJoiningRemoteStoreCluster() {
        Version higherVersion = versions.get(versions.size() - 1);  
        final RerouteService rerouteService = (reason, priority, listener) -> listener.onResponse(null);
            REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,
            } else if (repositoryMetadata.name().equals(routingTableRepoMetadata.name())) {
                                + joiningNode
    @SuppressWarnings("removal")  
        final AllocationService allocationService = mock(AllocationService.class);
        };  
        }  
            DiscoveryNodeRole.BUILT_IN_ROLES,
            existingNodeAttributes,
        assertThat(result.executionResults.entrySet(), hasSize(1));
            .nodes(DiscoveryNodes.builder().add(existingNode).localNodeId(existingNode.getId()).build())
import org.opensearch.repositories.RepositoriesService;
                e.getMessage().equals("joining node [" + joiningNode + "] doesn't have the node attribute [" + nodeAttribute.getKey() + "]")  
            .build();
            UUIDs.base64UUID(),
            higherVersion  
        assertThat(result.executionResults.entrySet(), hasSize(1));  
        final JoinTaskExecutor joinTaskExecutor = new JoinTaskExecutor(
            );
        final AllocationService allocationService = mock(AllocationService.class);
            remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO),
        final Version minNodeVersion = nodes.getMinNodeVersion();
            .build();
    public void testUpdatesClusterStateWithSingleNodeClusterAndSameRepository() throws Exception {  
            Version.CURRENT
                assertTrue(clusterStateRepoMetadata.equalsIgnoreGenerations(repositoryMetadata));
            .build();
        }  
            REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,
        existingNodeAttributes.putAll(remoteStateNodeAttributes(CLUSTER_STATE_REPO));
            buildNewFakeTransportAddress(),
            rerouteService,
    public void testUpdatesClusterStateWithMultiNodeClusterAndSameRepository() throws Exception {  
            .collect(Collectors.toMap(key -> key.replace(settingsAttributeKeyPrefix, ""), key -> node.getAttributes().get(key)));
import org.opensearch.common.UUIDs;
        );  
        final ClusterStateTaskExecutor.ClusterTasksResult<JoinTaskExecutor.Task> result = joinTaskExecutor.execute(  
        );
        final Settings settings = Settings.builder()  
        final RemoteStoreNodeService remoteStoreNodeService = mock(RemoteStoreNodeService.class);
            .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "mixed")
                add(segmentRepositoryMetadata);  
        assertTrue(taskResult.isSuccess());
    }
        final IllegalStateException exception = expectThrows(
            } else if (repositoryMetadata.name().equals(clusterStateRepositoryMetadata.name())) {
 * KIND, either express or implied.  See the License for the
        final DiscoveryNode clusterManagerNode = new DiscoveryNode(UUIDs.base64UUID(), buildNewFakeTransportAddress(), Version.V_3_10_0);
            )  
        );  
        newNodeAttributes.putAll(remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO));  
        DiscoveryNode discoveryNode = newDiscoveryNode(Collections.singletonMap("zone", "zone-1"));
        final DiscoveryNode existingNode2 = new DiscoveryNode(
            decommissionAttribute,  
    private static final String TRANSLOG_REPO = "translog-repo";
            joiningNode1,  
        );
            UUIDs.base64UUID(),
        );
        final Settings settings = Settings.builder()
            )
            .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "mixed")  
        );
import org.opensearch.cluster.metadata.RepositoriesMetadata;
                put(segmentRepositoryTypeAttributeKey, "s3");  
        final RepositoryMetadata segmentRepositoryMetadata = buildRepositoryMetadata(clusterManagerNode, COMMON_REPO);
import static org.mockito.Mockito.mock;
            Settings.EMPTY,
                IllegalStateException.class,
            .build();
        assertEquals("a remote store node [" + joiningNode + "] is trying to join a non remote store cluster", e.getMessage());
            List.of(new JoinTaskExecutor.Task(clusterManagerNode, "elect leader"))
        final DiscoveryNode existingNode = new DiscoveryNode(
        if (maxNodeVersion.compareMajor(minNodeVersion) == 0) {
        JoinTaskExecutor.ensureNodesCompatibility(joiningNode, currentState.getNodes(), currentState.metadata());
            remoteStoreNodeService
            .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "mixed")
        }
                    .add(clusterManagerNode)  
            clusterState,
                    .add(clusterManagerNode)
        );
            List.of(new JoinTaskExecutor.Task(actualNode, "test"))
            remoteStoreNodeAttributes.put(nodeAttribute.getKey(), nodeAttribute.getValue());
    public void testKeepsViewMetadataWhileOlderNodesRemain() throws Exception {
import org.opensearch.cluster.node.DiscoveryNodes;
            .add(currentNode1)
        final ClusterStateTaskExecutor.ClusterTasksResult<JoinTaskExecutor.Task> result = joinTaskExecutor.execute(
        final RepositoryMetadata clusterStateRepositoryMetadata = buildRepositoryMetadata(remoteNode, CLUSTER_STATE_REPO);  
            .build();  
        JoinTaskExecutor.ensureNodesCompatibility(joiningNode, currentState.getNodes(), currentState.metadata());  
            .put(MIGRATION_DIRECTION_SETTING.getKey(), RemoteStoreNodeService.Direction.REMOTE_STORE)
                + "comparison with existing node ["
        final DiscoveryNode existingNode2 = new DiscoveryNode(
                JoinTaskExecutor.ensureNodesCompatibility(tooLowJoiningNode, nodes, metadata);
            }
            .settings(settings(Version.fromString("5.8.0")))
        DiscoveryNode discoveryNode = newDiscoveryNode(Collections.singletonMap("zone", "zone-2"));  
 * ownership. Elasticsearch licenses this file to you under  
        );  
        ClusterState currentState = ClusterState.builder(ClusterName.DEFAULT)  
        final ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
            assertTrue(repositoryMetadata.equalsIgnoreGenerations(repositoriesMetadata.repositories().get(0)));  
    }
            List.of(new JoinTaskExecutor.Task(joiningNode, "test"))
            DiscoveryNodeRole.BUILT_IN_ROLES,
        }
        DiscoveryNode currentNode2 = new DiscoveryNode(UUIDs.base64UUID(), buildNewFakeTransportAddress(), baseVersion);  
            rerouteService,
            .nodes(  
            remoteStoreNodeService
            Version.CURRENT  
        );  
        );
                () -> JoinTaskExecutor.ensureNodesCompatibility(joiningNode, currentState.getNodes(), currentState.metadata())
            )  
        DiscoveryNodes nodes = builder.build();  
        when(allocationService.adaptAutoExpandReplicas(any())).then(invocationOnMock -> invocationOnMock.getArguments()[0]);  
            DiscoveryNodeRole.BUILT_IN_ROLES,  
        );
            segmentRepoName
            rerouteService,  
        final Settings settings = Settings.builder()  
import org.opensearch.Version;  
        Settings.Builder settings = Settings.builder();
                            "a remote store node ["
            .put(MIGRATION_DIRECTION_SETTING.getKey(), RemoteStoreNodeService.Direction.REMOTE_STORE)
        final ClusterStateTaskExecutor.TaskResult taskResult = result.executionResults.values().iterator().next();
            buildNewFakeTransportAddress(),  
            .metadata(Metadata.builder().putCustom(RepositoriesMetadata.TYPE, new RepositoriesMetadata(repositoriesMetadata)))
        // compatible remote node should not be able to join a mixed mode having a remote node
            Version.CURRENT  
        Settings.builder().build();
        Metadata.Builder metaBuilder = Metadata.builder();
            .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "mixed")  
            DiscoveryNodeRole.BUILT_IN_ROLES,
    @SuppressWarnings("removal")
        DiscoveryNode joiningNode = newDiscoveryNode(remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO));
                );  
        final JoinTaskExecutor joinTaskExecutor = new JoinTaskExecutor(
        final DiscoveryNode existingNode = new DiscoveryNode(
    public void testRemoteStoreNodeJoiningNonRemoteStoreClusterMixedMode() {
        DiscoveryNode badRemoteNode = newDiscoveryNode(remoteStoreNodeAttributes(TRANSLOG_REPO, TRANSLOG_REPO));
        DiscoveryNode discoveryNode = newDiscoveryNode(Collections.singletonMap("zone", "zone-2"));
            .numberOfReplicas(1)  
        );  
    }
                    .localNodeId(clusterManagerNode.getId())
    private static final String SEGMENT_REPO = "segment-repo";  
            new SetOnce<>(mock(RepositoriesService.class))::get,  
        );
    public void testUpdatesClusterStateWithSingleNodeCluster() throws Exception {  
        final RerouteService rerouteService = (reason, priority, listener) -> listener.onResponse(null);  
            DiscoveryNodeRole.BUILT_IN_ROLES,
            Locale.getDefault(),
import org.opensearch.test.OpenSearchTestCase;
            .build();
        DiscoveryNode joiningNode = newDiscoveryNode(remotePublicationNodeAttributes());
        );  
            .nodes(DiscoveryNodes.builder().add(existingNode).localNodeId(existingNode.getId()).build())
import org.opensearch.test.VersionUtils;  
            )
}
            remoteStoreNodeService  
    }
            .build();  
        Map<String, String> remoteStoreNodeAttributes = remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO);  
        Version baseVersion = versions.get(versions.size() - 2);
        );
            remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO),
        final ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)  
 */
        // In this case we must properly process its join to ensure that the roles are correct.
        );  
                    .add(clusterManagerNode)
    }
            UUIDs.base64UUID(),
        RepositoriesService repositoriesService = mock(RepositoriesService.class);
        ClusterState currentState = ClusterState.builder(ClusterName.DEFAULT)
                    .localNodeId(clusterManagerNode.getId())  
            IllegalStateException.class,  
        when(allocationService.adaptAutoExpandReplicas(any())).then(invocationOnMock -> invocationOnMock.getArguments()[0]);  
            if (repositoryMetadata.name().equals(segmentRepositoryMetadata.name())) {
    public void testJoinClusterWithNonRemoteStoreNodeJoiningNonRemoteStoreCluster() {  
            UUIDs.base64UUID(),  
        Metadata metadata = Metadata.builder().persistentSettings(mixedModeCompatibilitySettings).build();  
        final DiscoveryNode existingNode = new DiscoveryNode(UUIDs.base64UUID(), buildNewFakeTransportAddress(), Version.CURRENT);  
import org.opensearch.cluster.metadata.RepositoryMetadata;
        // joining node of a higher version than the current nodes
            currentState,
        Exception e = assertThrows(
            rerouteService,
        List<Version> versions = allOpenSearchVersions();  
            clusterState,
        );  
        );
                + "] is trying to join a remote store cluster with incompatible node attributes in "
            .settings(settings(Version.CURRENT))
            Version minCompatVersion = maxNodeVersion.minimumCompatibilityVersion();
    public void testJoinClusterWithRemoteStateNodeJoiningRemoteStateCluster() {  
        final RemoteStoreNodeService remoteStoreNodeService = new RemoteStoreNodeService(
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY;  
            remoteStoreNodeAttributes.put(nodeAttribute.getKey(), nodeAttribute.getValue());
        );
            } else if (repositoryMetadata.name().equals(routingTableRepositoryMetadata.name())) {
            remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO),
            DecommissionStatus.IN_PROGRESS,
            () -> JoinTaskExecutor.ensureNodesCompatibility(joiningNode, currentState.getNodes(), currentState.metadata())
 *
        final DiscoveryNode joiningNode = new DiscoveryNode(
        final ClusterStateTaskExecutor.ClusterTasksResult<JoinTaskExecutor.Task> result = joinTaskExecutor.execute(  
        Map<String, String> attr = remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO);
            Settings.EMPTY,
            .build();
        final ClusterStateTaskExecutor.TaskResult taskResult = result.executionResults.values().iterator().next();
        } else if (repositoriesMetadata.repositories().size() == 1) {
    private static final String ROUTING_TABLE_REPO = "routing-table-repo";
            .build();
        final RepositoriesMetadata repositoriesMetadata = updatedState.metadata().custom(RepositoriesMetadata.TYPE);
            .nodes(
            logger,
        DecommissionAttribute decommissionAttribute = new DecommissionAttribute("zone", "zone-1");
        final DiscoveryNode remotePublicationNode = new DiscoveryNode(
        );  
        Map<String, String> existingNodeAttributes = remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO);  
            Locale.getDefault(),
            List.of(new JoinTaskExecutor.Task(clusterManagerNode, "elect leader"))
        assertTrue(taskResult.isSuccess());  
        );
        assertThrows(
    private Map<String, String> remoteStoreNodeAttributes(String segmentRepoName, String translogRepoName) {
            buildNewFakeTransportAddress(),  
            .build();  
            )
        );
        Exception e = assertThrows(
        final DiscoveryNode clusterManagerNode = new DiscoveryNode(  
            .nodes(DiscoveryNodes.builder().add(existingNode).localNodeId(existingNode.getId()).build())  
        );
            UUIDs.base64UUID(),
        DiscoveryNode joiningNode = newDiscoveryNode(attr);
            buildNewFakeTransportAddress(),  
    }
            randomAlphaOfLength(10)  
            }
            DiscoveryNodeRole.BUILT_IN_ROLES,
        final ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)  
            .build();  
            )
            new HashSet<>(randomSubsetOf(actualNode.getRoles())),
        for (Map.Entry<String, String> nodeAttribute : existingNodeAttributes.entrySet()) {  
            actualNode.getHostAddress(),
        assert versions.size() >= 2 : "test requires at least two open search versions";
        String translogRepositoryTypeAttributeKey = String.format(
                        )
                putIfAbsent(translogRepositoryTypeAttributeKey, "s3");
            rerouteService,
        DiscoveryNode currentNode1 = new DiscoveryNode(UUIDs.base64UUID(), buildNewFakeTransportAddress(), baseVersion);
     * Validate isBecomeClusterManagerTask() can identify "become cluster manager task" properly  
        IndexMetadata indexMetadata = IndexMetadata.builder("test")  
        DecommissionAttributeMetadata decommissionAttributeMetadata = new DecommissionAttributeMetadata(  
            buildNewFakeTransportAddress(),  
            null
        final ClusterState result = joinNodeToClusterWithViewMetadata(clusterManagerNode, joiningNode);
import org.opensearch.cluster.node.DiscoveryNodeRole;  
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT;  
            .nodes(DiscoveryNodes.builder().add(remoteStoreNode).add(nonRemoteStoreNode).localNodeId(remoteStoreNode.getId()).build())  
            .metadata(Metadata.builder().decommissionAttributeMetadata(decommissionAttributeMetadata))  
        );
                    assertTrue(segmentRepositoryMetadata.equalsIgnoreGenerations(repositoryMetadata));
        Map<String, String> remoteStoreNodeAttributes = remotePublicationNodeAttributes();
                    .add(clusterManagerNode)
    }  
        final DiscoveryNode actualNode = new DiscoveryNode(UUIDs.base64UUID(), buildNewFakeTransportAddress(), Version.CURRENT);
import java.util.Collections;  
            buildNewFakeTransportAddress(),  
            remoteStoreNodeService
        final JoinTaskExecutor joinTaskExecutor = new JoinTaskExecutor(
    }
        final DiscoveryNode joiningNode = new DiscoveryNode(
    public void testRemoteRoutingTableNodeJoinNodeWithRemoteAndRoutingRepoDifference() {
    }
        String segmentRepositoryTypeAttributeKey = String.format(  
        attr.putAll(remoteRoutingTableAttributes(ROUTING_TABLE_REPO));
            buildNewFakeTransportAddress(),
            Version.CURRENT  
        DecommissionStatus decommissionStatus = randomFrom(  
            DiscoveryNodeRole.BUILT_IN_ROLES,
        String type = nodeAttributes.get(String.format(Locale.getDefault(), REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT, name));
 * The OpenSearch Contributors require contributions made to  
        assertThat(resultAfterRemoteNodeJoin.executionResults.entrySet(), hasSize(1));
    }
            buildNewFakeTransportAddress(),  
        Map<String, String> attr = remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO);
    private void validateRepositoryMetadata(ClusterState updatedState, DiscoveryNode existingNode, int expectedRepositories)
        String translogRepositorySettingsAttributeKeyPrefix = String.format(  
        String routingTableRepositorySettingsAttributeKeyPrefix = String.format(
        );  
        final RemoteStoreNodeService remoteStoreNodeService = new RemoteStoreNodeService(
            Settings.EMPTY,
            .build();
            buildNewFakeTransportAddress(),
        List<RepositoryMetadata> repositoriesMetadata = new ArrayList<>();
        assertTrue(e.getMessage().equals("a non remote store node [" + joiningNode + "] is trying to join a remote " + "store cluster"));
            allocationService,  
                    .clusterManagerNodeId(clusterManagerNode.getId())  
        DiscoveryNode joiningNode = newDiscoveryNode(Collections.emptyMap());  
        );
                    .localNodeId(clusterManagerNode.getId())
        final ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
        final DiscoveryNode existingNode = new DiscoveryNode(
            () -> JoinTaskExecutor.ensureNodesCompatibility(joiningNode, currentState.getNodes(), currentState.metadata())  
            List.of(new JoinTaskExecutor.Task(remoteStoreNode, "test"))  
            Locale.getDefault(),  
        builder.add(new DiscoveryNode(UUIDs.base64UUID(), buildNewFakeTransportAddress(), randomCompatibleVersion(random(), version)));
            UUIDs.base64UUID(),
            DiscoveryNodeRole.BUILT_IN_ROLES,  
import org.opensearch.common.SetOnce;
        );  
        if (minNodeVersion.before(Version.V_3_0_0)) {
        final DiscoveryNode nonRemoteStoreNode = new DiscoveryNode(
            .numberOfShards(1)
        JoinTaskExecutor.ensureNodesCompatibility(docrepNode2, currentState.getNodes(), currentState.metadata());  
            logger,
import org.opensearch.cluster.metadata.ViewMetadata;
            actualNode.getName(),
import static org.mockito.Mockito.any;  
        final DiscoveryNode decommissionedNode = new DiscoveryNode(  
            );  
                DiscoveryNodes.builder()
        final DiscoveryNode existingNode = new DiscoveryNode(
        ClusterState currentState = ClusterState.builder(ClusterName.DEFAULT)
                    assertTrue(translogRepositoryMetadata.equalsIgnoreGenerations(repositoryMetadata));
        ClusterState currentState = ClusterState.builder(ClusterName.DEFAULT)
        expectThrows(IllegalStateException.class, () -> JoinTaskExecutor.ensureIndexCompatibility(Version.CURRENT, metadata));
    private void validateAttributes(Map<String, String> remoteStoreNodeAttributes, ClusterState currentState, DiscoveryNode existingNode) {  
                    .add(remoteNode)
                    .localNodeId(remoteNode.getId())
    }  
        );
        );
            expectThrows(IllegalStateException.class, () -> JoinTaskExecutor.ensureMajorVersionBarrier(oldMajor, minNodeVersion));  
                    .clusterManagerNodeId(clusterManagerNode.getId())
            } else if (repositoryMetadata.name().equals(translogRepositoryMetadata.name())) {  
        when(remoteStoreNodeService.updateRepositoriesMetadata(any(), any())).thenReturn(new RepositoriesMetadata(Collections.emptyList()));
            buildNewFakeTransportAddress(),
            );
            buildNewFakeTransportAddress(),
            logger,
        assertTrue(taskResult.getFailure() instanceof NodeDecommissionedException);
            REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,  
                } else if (repositoriesMetadata.repositories().size() == 3) {
        final DiscoveryNode existingNode = new DiscoveryNode(
        Map<String, String> settingsMap = node.getAttributes()
            )
            Version.CURRENT  
            remoteStoreNodeService
    public void testRemoteRoutingTableNodeJoinNodeWithRemoteAndRoutingRepoDifferenceMixedMode() {  
    }
            clusterState,
                putIfAbsent(routingTableRepositoryTypeAttributeKey, "s3");
        Map<String, String> newNodeAttributes = new HashMap<>();  
        final RemoteStoreNodeService remoteStoreNodeService = mock(RemoteStoreNodeService.class);
        );  
        IndexMetadata indexMetadata = IndexMetadata.builder("test")  
            buildNewFakeTransportAddress(),
            UUIDs.base64UUID(),
                                + currentState.getNodes().getNodes().values().stream().findFirst().get()  
    private RepositoryMetadata buildRepositoryMetadata(DiscoveryNode node, String name) {
        final RerouteService rerouteService = (reason, priority, listener) -> listener.onResponse(null);
            .build();
    public void testJoinClusterWithDecommissionFailed() {  
            .metadata(metadata)
            DecommissionStatus.SUCCESSFUL,
        existingNodeAttributes.putAll(remoteRoutingTableAttributes(ROUTING_TABLE_REPO));  
 * Unless required by applicable law or agreed to in writing,
            .build();
        when(allocationService.adaptAutoExpandReplicas(any())).then(invocationOnMock -> invocationOnMock.getArguments()[0]);
    }  
        // This means we can receive a join from a node that's already in the cluster but with a different set of roles:  
                add(segmentRepositoryMetadata);
                e.getMessage().equals("joining node [" + joiningNode + "] doesn't have the node attribute [" + nodeAttribute.getKey() + "]")
                    .clusterManagerNodeId(clusterManagerNode.getId())
        final DiscoveryNode existingNode = new DiscoveryNode(
        }
            UUIDs.base64UUID(),
        final AllocationService allocationService = mock(AllocationService.class);  
                DiscoveryNodes.builder()  
        JoinTaskExecutor.ensureNodesCompatibility(joiningNode, currentState.getNodes(), currentState.metadata());  
        } else {  
        validateRepositoryMetadata(result.resultingState, clusterManagerNode, 2);  
        final JoinTaskExecutor joinTaskExecutor = new JoinTaskExecutor(
            .build();
            buildNewFakeTransportAddress(),
            Locale.getDefault(),
                    .localNodeId(clusterManagerNode.getId())  
        final DiscoveryNode clusterManagerNode = new DiscoveryNode(
        final Settings settings = Settings.builder()
            JoinTaskExecutor.ensureNodesCompatibility(justGoodJoiningNode, nodes, metadata);
import org.opensearch.cluster.decommission.DecommissionAttributeMetadata;
    }
        ClusterState currentState = ClusterState.builder(ClusterName.DEFAULT)
        final DiscoveryNode docrepNode = new DiscoveryNode(UUIDs.base64UUID(), buildNewFakeTransportAddress(), Version.CURRENT);
        final DiscoveryNode existingNode = new DiscoveryNode(
        final ClusterStateTaskExecutor.ClusterTasksResult<JoinTaskExecutor.Task> result = joinTaskExecutor.execute(
        assertThat(result.executionResults.entrySet(), hasSize(1));
        };  
            DecommissionStatus.INIT,
            clusterState,  
 * Modifications Copyright OpenSearch Contributors. See  
        JoinTaskExecutor.ensureNodeCommissioned(discoveryNode, metadata);  
            .filter(key -> key.startsWith(settingsAttributeKeyPrefix))
            UUIDs.base64UUID(),
            buildNewFakeTransportAddress(),  
            .build();
        );
        final RepositoryMetadata routingTableRepoMetadata = buildRepositoryMetadata(existingNode, ROUTING_TABLE_REPO);
            REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,
        final AllocationService allocationService = mock(AllocationService.class);
        );  
            .build();
    public void testPreventJoinClusterWithDecommission() {  
 * You may obtain a copy of the License at  
        // the node didn't change roles, but the cluster state came via an older cluster-manager.
                    .localNodeId(clusterManagerNode.getId())
    private DiscoveryNode newDiscoveryNode(Map<String, String> attributes) {
        assertThat(resultAfterRemoteNodeJoin.executionResults.entrySet(), hasSize(1));
            buildNewFakeTransportAddress(),  
        final DiscoveryNode joiningNode = new DiscoveryNode(UUIDs.base64UUID(), buildNewFakeTransportAddress(), Version.V_3_9_0);  
        final DiscoveryNode justGoodJoiningNode = new DiscoveryNode(UUIDs.base64UUID(), buildNewFakeTransportAddress(), justGood);  
                    .localNodeId(clusterManagerNode.getId())
            Locale.getDefault(),  
        final ClusterStateTaskExecutor.ClusterTasksResult<JoinTaskExecutor.Task> resultAfterRemoteNodeJoin = joinTaskExecutor.execute(  
import org.opensearch.cluster.decommission.DecommissionAttribute;
            // we have to stick with the same major
        assertTrue(repositoriesMetadata.repositories().size() == expectedRepositories);  
        final JoinTaskExecutor joinTaskExecutor = new JoinTaskExecutor(
            .build();
            Settings.EMPTY,  
                }
            DiscoveryNode joiningNode = newDiscoveryNode(remoteStoreNodeAttributes);
            actualNode.getHostName(),
        DiscoveryNode joiningNode = newDiscoveryNode(remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO));  
        final AllocationService allocationService = mock(AllocationService.class);
        );
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY;
            new SetOnce<>(mock(RepositoriesService.class))::get,  
        DiscoveryNode joiningNode = newDiscoveryNode(new HashMap<>());
        final DiscoveryNode clusterManagerNode = new DiscoveryNode(UUIDs.base64UUID(), buildNewFakeTransportAddress(), Version.V_3_10_0);
        attr.putAll(remoteRoutingTableAttributes(ROUTING_TABLE_REPO));  
            .nodes(DiscoveryNodes.builder().add(existingNode).localNodeId(existingNode.getId()).build())  
        );  
    }
        JoinTaskExecutor.ensureNodesCompatibility(joiningNode, currentState.getNodes(), currentState.metadata());
import static org.mockito.Mockito.when;
                settings(VersionUtils.randomVersionBetween(random(), Version.CURRENT.minimumIndexCompatibilityVersion(), Version.CURRENT))
        );
            remotePublicationNodeAttributes(),
            remotePublicationNodeAttributes(),
            remoteStoreNodeService  
import org.opensearch.cluster.node.DiscoveryNode;
        );
            .nodes(DiscoveryNodes.builder().add(existingNode).localNodeId(existingNode.getId()).build())  
            existingNodeAttributes,
            JoinTaskExecutor.ensureNodesCompatibility(justGoodJoiningNode, nodes, metadata, minNodeVersion, maxNodeVersion);
        validateRepositoryMetadata(result.resultingState, clusterManagerNode, 3);  
                DiscoveryNodes.builder()
        assertTrue(result.executionResults.values().iterator().next().isSuccess());
            Version.CURRENT  
            remotePublicationNodeAttributes(),  
        );
                                + "]"  
            UUIDs.base64UUID(),
        );
            () -> JoinTaskExecutor.ensureIndexCompatibility(VersionUtils.getPreviousVersion(Version.CURRENT), metadata)
    public void testNodeJoinInMixedMode() {
            )
        DiscoveryNode joiningNode = newDiscoveryNode(remotePublicationNodeAttributes());
            .build();
        final Settings settings = Settings.builder()
                    .clusterManagerNodeId(clusterManagerNode.getId())
            .build();
        final ClusterStateTaskExecutor.TaskResult taskResult = result.executionResults.values().iterator().next();  
            baseVersion
            List.of(new JoinTaskExecutor.Task(remotePublicationNode, "test"))
        }
            remoteStoreNodeService  
        final DiscoveryNode bwcNode = new DiscoveryNode(  
            UUIDs.base64UUID(),  
        );
            REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,
            Version.CURRENT  
        assertNotNull(result.metadata().custom(ViewMetadata.TYPE));
        assertFalse(result.resultingState.getNodes().nodeExists(decommissionedNodeID));  
                + "]"
            .settings(  
            randomAlphaOfLength(10)
            allocationService,
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        final RerouteService rerouteService = (reason, priority, listener) -> listener.onResponse(null);
                Map<String, String> remoteStoreNodeAttributes = remoteStoreNodeAttributes(SEGMENT_REPO + "new", TRANSLOG_REPO);
                DiscoveryNodes.builder()
        }  
import org.opensearch.cluster.metadata.IndexMetadata;
            decommissionAttribute,
        );
            logger,
            actualNode.getAddress(),  
        String decommissionedNodeID = decommissionedNode.getId();
    public void testJoinRemotePublicationCluster() {
        Settings.builder().build();
            Version.CURRENT  
import java.util.Set;  
        final DiscoveryNode joiningNode = new DiscoveryNode(
        );
    }
            decommissionStatus,
            .put(MIGRATION_DIRECTION_SETTING.getKey(), RemoteStoreNodeService.Direction.REMOTE_STORE)  
        Map<String, String> remoteStoreNodeAttributes = remoteStoreNodeAttributes(COMMON_REPO, COMMON_REPO);
            remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO),
        );
            .numberOfReplicas(1)
            remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO),
        assertNull(result.metadata().custom(ViewMetadata.TYPE));  
            Version.CURRENT
            remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO),
        final DiscoveryNode joiningNode = new DiscoveryNode(UUIDs.base64UUID(), buildNewFakeTransportAddress(), Version.V_3_10_0);
                DiscoveryNodes.builder()
            .metadata(metadata)
        );
import java.util.HashSet;
        );
            Version.fromString("6.7.0")  
        );
    }  
        );
 *     http://www.apache.org/licenses/LICENSE-2.0
            final RepositoryMetadata repositoryMetadata = buildRepositoryMetadata(existingNode, COMMON_REPO);
            Locale.getDefault(),  
        Map<String, String> remoteStoreNodeAttributes = remoteStoreNodeAttributes(COMMON_REPO, COMMON_REPO);
    public void testPreventJoinClusterWithNewerIndices() {  
            DiscoveryNodeRole.BUILT_IN_ROLES,
            clusterState,  
    private void validatePublicationRepositoryMetadata(ClusterState updatedState, DiscoveryNode existingNode) throws Exception {  
            Version.CURRENT
            Exception e = assertThrows(  
        metaBuilder.put(indexMetadata, false);
                if (repositoryMetadata.name().equals(segmentRepositoryMetadata.name())) {
        List<RepositoryMetadata> repositoriesMetadata = new ArrayList<>() {
            REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,
    }
        final DiscoveryNode existingNode = new DiscoveryNode(  
            remoteStoreNodeAttributes.put(nodeAttribute.getKey(), null);
        JoinTaskExecutor.ensureNodesCompatibility(joiningNode, currentState.getNodes(), currentState.metadata());
            .nodes(  
        Exception e = assertThrows(  
            assertTrue(
    }
        );
        DiscoveryNode joiningNode = newDiscoveryNode(attr);
                DiscoveryNodes.builder()
    }
                validateAttributes(remoteStoreNodeAttributes, currentState, existingNode);
import org.opensearch.cluster.decommission.NodeDecommissionedException;
        final DiscoveryNode existingNode = new DiscoveryNode(
            repoName  
        );  
        final DiscoveryNode remoteStoreNode = new DiscoveryNode(
        Metadata metadata = metaBuilder.build();  
        );
        ClusterState currentState = ClusterState.builder(result.resultingState).metadata(metadata).build();
        }
        final DiscoveryNode existingNode = new DiscoveryNode(
        Map<String, String> existingNodeAttributes = remotePublicationNodeAttributes();
        DiscoveryNode docrepNode2 = new DiscoveryNode(UUIDs.base64UUID(), buildNewFakeTransportAddress(), Version.CURRENT);
        // DocRep node should be able to join a mixed mode
        DecommissionAttributeMetadata decommissionAttributeMetadata = new DecommissionAttributeMetadata(
    }
        );  
                    assertTrue(clusterStateRepoMetadata.equalsIgnoreGenerations(repositoryMetadata));
            actualNode.getEphemeralId(),  
        final ClusterStateTaskExecutor.ClusterTasksResult<JoinTaskExecutor.Task> result = joinTaskExecutor.execute(  
            IllegalStateException.class,
            .build();  
    @LockFeatureFlag(REMOTE_STORE_MIGRATION_EXPERIMENTAL)  
        );
            clusterState,  
        for (Map.Entry<String, String> nodeAttribute : existingNodeAttributes.entrySet()) {  
            .nodes(
            DiscoveryNodeRole.BUILT_IN_ROLES,
            actualNode.getId(),
                putIfAbsent(translogRepositorySettingsAttributeKeyPrefix + "base_path", "/translog/path");  
            .build();
            DiscoveryNodeRole.BUILT_IN_ROLES,
        assertThat(result.executionResults.entrySet(), hasSize(1));
        Map<String, String> existingNodeAttributes = new HashMap<>();
        final RerouteService rerouteService = (reason, priority, listener) -> listener.onResponse(null);
        );  
            randomAlphaOfLength(10)  
            decommissionAttribute,  
            buildNewFakeTransportAddress(),  
            DiscoveryNodeRole.BUILT_IN_ROLES,  
import static org.opensearch.test.VersionUtils.randomCompatibleVersion;  
            }
            Settings.EMPTY,
            .build();
            .build();
        newNodeAttributes.putAll(remoteRoutingTableAttributes(ROUTING_TABLE_REPO));
                    .build()  
        );  
    }
        );
                && nodeAttribute.getKey() != REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY) {  
        DiscoveryNode joiningNode = newDiscoveryNode(newNodeAttributes);
            }
        final DiscoveryNode existingNode = new DiscoveryNode(  
import static org.opensearch.test.VersionUtils.allOpenSearchVersions;  
            randomAlphaOfLength(10),  
        Metadata metadata = Metadata.builder().persistentSettings(settings).build();
            null
                    .add(bwcNode)
            remoteStoreNodeService  
            .nodes(DiscoveryNodes.builder().add(existingNode).localNodeId(existingNode.getId()).build())  
                                + "]"
            IllegalStateException.class,
    public void testJoinClusterWithRemoteStoreNodeJoining() {
        );
            allocationService,  
        DiscoveryNodes currentNodes = DiscoveryNodes.builder()
        );  
/*
            null
import java.util.ArrayList;
            existingNodeAttributes,
            existingNodeAttributes,
            newNodeAttributes,
            .metadata(Metadata.builder().putCustom(RepositoriesMetadata.TYPE, new RepositoriesMetadata(repositoriesMetadata)))
        final DiscoveryNode existingNode = new DiscoveryNode(
            .build();  
        final DiscoveryNode existingNode = new DiscoveryNode(
        String routingTableRepositoryTypeAttributeKey = String.format(  
import static org.opensearch.test.VersionUtils.allVersions;
                    .clusterManagerNodeId(clusterManagerNode.getId())
        final ClusterState clusterManagerClusterState = ClusterState.builder(ClusterName.DEFAULT)
            {
        Map<String, String> remoteStoreNodeAttributes = remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO);
        DiscoveryNode joiningNode = newDiscoveryNode(remoteStoreNodeAttributes);
                Map<String, String> remoteStoreNodeAttributes = remoteStoreNodeAttributes(
            .nodes(DiscoveryNodes.builder().add(existingNode).localNodeId(existingNode.getId()).build())  
            .build();
            remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO),
                putIfAbsent(clusterStateRepositorySettingsAttributeKeyPrefix + "bucket", "state_bucket");
        JoinTaskExecutor.ensureNodesCompatibility(joiningNode, currentState.getNodes(), currentState.metadata());  
                    .clusterManagerNodeId(clusterManagerNode.getId())  
        Metadata metadata = Metadata.builder().persistentSettings(settings).build();
        );
        );
 * the Apache License, Version 2.0 (the "License"); you may
    private Map<String, String> remoteRoutingTableAttributes(String repoName) {
                remoteStoreNodeAttributes.put(nodeAttribute.getKey(), nodeAttribute.getValue());  
            .build();
    @LockFeatureFlag(REMOTE_STORE_MIGRATION_EXPERIMENTAL)
        final ClusterStateTaskExecutor.TaskResult taskResult1 = resultAfterRemoteNodeJoin.executionResults.values().iterator().next();  
            buildNewFakeTransportAddress(),
        throws Exception {  
            DiscoveryNodeRole.BUILT_IN_ROLES,
        String segmentRepositorySettingsAttributeKeyPrefix = String.format(
            if (randomBoolean()) {  
        final DiscoveryNode remoteStoreNode = new DiscoveryNode(
        return existingNodeAttributes;
    public void testUpdatesClusterStateWithRepositoryMetadataNotInSync() throws Exception {
        );  
            existingNodeAttributes,
            remotePublicationNodeAttributes(),
        Map<String, String> existingNodeAttributes = remoteStateNodeAttributes(CLUSTER_STATE_REPO);
        assertEquals("a remote store node [" + joiningNode + "] is trying to join a non remote store cluster", e.getMessage());  
        expectThrows(IllegalStateException.class, () -> {
    }  
import static org.opensearch.common.util.FeatureFlags.REMOTE_STORE_MIGRATION_EXPERIMENTAL;  
        ClusterState currentState = ClusterState.builder(ClusterName.DEFAULT)
            buildNewFakeTransportAddress(),
            DiscoveryNodeRole.BUILT_IN_ROLES,
        final DiscoveryNode clusterManagerNode = new DiscoveryNode(  
            .nodes(DiscoveryNodes.builder().add(existingNode).localNodeId(existingNode.getId()).build())
            translogRepoName  
            DiscoveryNodeRole.BUILT_IN_ROLES,  
        ClusterState currentState = ClusterState.builder(ClusterName.DEFAULT)
        final ClusterStateTaskExecutor.ClusterTasksResult<JoinTaskExecutor.Task> result = joinTaskExecutor.execute(
        final DiscoveryNode clusterManagerNode = new DiscoveryNode(  
        Metadata metadata = metaBuilder.build();  
        final RemoteStoreNodeService remoteStoreNodeService = mock(RemoteStoreNodeService.class);  
            attr,  
        final DiscoveryNode existingNode = new DiscoveryNode(
        settings.put(BlobStoreRepository.SYSTEM_REPOSITORY_SETTING.getKey(), true);
        JoinTaskExecutor.ensureNodesCompatibility(joiningNode, currentState.getNodes(), currentState.metadata());
            .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), RemoteStoreNodeService.CompatibilityMode.MIXED)  
        );
        JoinTaskExecutor.ensureIndexCompatibility(Version.CURRENT, metadata);
        assertEquals("a non remote store node [" + joiningNode + "] is trying to join a remote store cluster", e.getMessage());
    @LockFeatureFlag(REMOTE_STORE_MIGRATION_EXPERIMENTAL)
            logger,
    }
            new SetOnce<>(mock(RepositoriesService.class))::get,  
        JoinTaskExecutor.ensureNodesCompatibility(joiningNode, currentState.getNodes(), currentState.metadata());  
        JoinTaskExecutor.ensureNodesCompatibility(joiningNode2, currentNodes, metadata);  
        Map<String, String> existingNodeAttributes = remoteStoreNodeAttributes(SEGMENT_REPO, TRANSLOG_REPO);  
            remoteStoreNodeAttributes,  
        validatePublicationRepositoryMetadata(result.resultingState, clusterManagerNode);
    private Map<String, String> remoteStateNodeAttributes(String clusterStateRepo) {
        );
            .build();  
            remoteStoreNodeAttributes,  
            () -> JoinTaskExecutor.ensureNodesCompatibility(joiningNode, currentState.getNodes(), currentState.metadata())
            buildNewFakeTransportAddress(),
        );
    }  
    public void testPreventJoinClusterWithRemoteStoreNodeWithDifferentAttributesJoiningRemoteStoreCluster() {
 * this file be licensed under the Apache-2.0 license or a
            .nodes(DiscoveryNodes.builder().add(existingNode).localNodeId(existingNode.getId()).build())  
        attr.putAll(remoteRoutingTableAttributes(ROUTING_TABLE_REPO));
    }
    public void testPreventJoinClusterWithUnsupportedIndices() {  
        JoinTaskExecutor.ensureNodesCompatibility(joiningNode, currentState.getNodes(), currentState.metadata());  
        metaBuilder.put(indexMetadata, false);  
        final ClusterStateTaskExecutor.TaskResult taskResult = result.executionResults.values().iterator().next();
            Version.CURRENT
        Metadata metadata = metaBuilder.build();  
            .keySet()
            attr,  
        metaBuilder.put(indexMetadata, false);
        when(allocationService.adaptAutoExpandReplicas(any())).then(invocationOnMock -> invocationOnMock.getArguments()[0]);  
            minGoodVersion = minCompatVersion.before(allVersions().get(0)) ? allVersions().get(0) : minCompatVersion;  
            UUIDs.base64UUID(),  
            DiscoveryNodeRole.BUILT_IN_ROLES,  
        for (Map.Entry<String, String> nodeAttribute : existingNodeAttributes.entrySet()) {  
            clusterState,
            segmentRepoName  
            remoteStoreNodeService
        attr.putAll(remoteRoutingTableAttributes(ROUTING_TABLE_REPO));
        };
            translogRepoName
        final AllocationService allocationService = mock(AllocationService.class);  
            Version.CURRENT  
            attributes,  
            clusterStateRepo
 */
        final JoinTaskExecutor joinTaskExecutor = new JoinTaskExecutor(
        ClusterState currentState = ClusterState.builder(ClusterName.DEFAULT)
        List<RepositoryMetadata> repositoriesMetadata = new ArrayList<>() {
            logger,
        Exception e = assertThrows(
            IllegalStateException.class,  
        final RemoteStoreNodeService remoteStoreNodeService = new RemoteStoreNodeService(
            .nodes(
            buildNewFakeTransportAddress(),  
        Metadata metadata = Metadata.builder().persistentSettings(settings).build();
        final AllocationService allocationService = mock(AllocationService.class);
        final RepositoryMetadata segmentRepositoryMetadata = buildRepositoryMetadata(remoteNode, SEGMENT_REPO);
            Version.CURRENT
        );
    public void testPreventJoinClusterWithUnsupportedNodeVersions() {
            UUIDs.base64UUID(),  
        final ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)  
            null  
            throw new Exception("Stack overflow example: checkedExceptionThrower");
        final DiscoveryNode clusterManagerNode = new DiscoveryNode(UUIDs.base64UUID(), buildNewFakeTransportAddress(), Version.CURRENT);  
        newNodeAttributes.putAll(remoteStateNodeAttributes(CLUSTER_STATE_REPO));
            decommissionStatus,
    }  
        DiscoveryNode joiningNode = newDiscoveryNode(map);
                DiscoveryNodes.builder()  
            UUIDs.base64UUID(),
    public void testPreventJoinClusterWithNonRemoteStoreNodeJoiningRemoteStoreCluster() {  
            .build();  
        Map<String, String> newNodeAttributes = new HashMap<>();  
        final RepositoryMetadata routingTableRepositoryMetadata = buildRepositoryMetadata(publicationNode, ROUTING_TABLE_REPO);
                JoinTaskExecutor.ensureNodesCompatibility(tooLowJoiningNode, nodes, metadata, minNodeVersion, maxNodeVersion);  
            buildNewFakeTransportAddress(),  
        final ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
            UUIDs.base64UUID(),
