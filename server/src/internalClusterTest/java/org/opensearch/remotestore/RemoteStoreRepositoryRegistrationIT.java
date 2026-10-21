        expectThrows(IllegalStateException.class, () -> {
            NetworkDisruption.DISCONNECT
    public void testNodeJoinFailureWithDifferentRemoteStoreRepositoryAttributes() throws Exception {
        ensureStableCluster(3, nodesInOneSide.stream().findAny().get());
import java.util.HashSet;
    protected Collection<Class<? extends Plugin>> nodePlugins() {
 * The OpenSearch Contributors require contributions made to
        GetRepositoriesResponse repositoriesResponse = client().execute(GetRepositoriesAction.INSTANCE, request).actionGet();
    }
        ensureStableCluster(3);
            .get(0);
    public void testSystemRepositorySettingIsHiddenForGetRepositoriesRequest() throws IOException {
        networkDisruption.stopDisrupting();
        });
            null,
import java.util.stream.Stream;
 * this file be licensed under the Apache-2.0 license or a
     * This negative test case verifies that nodes with incompatible remote store configurations are rejected.
            new NetworkDisruption.TwoPartitions(nodesInOneSide, nodesInAnotherSide),
        expectThrows(Exception.class, () -> {
        internalCluster().startNode();
public class RemoteStoreRepositoryRegistrationIT extends RemoteStoreBaseIntegTestCase {
            );
    }
            .get(0);
                    .build()
    }
                @Override
        });
import org.opensearch.common.settings.Settings;
            true,
                    .put("node.attr.remote_store.segment.repository", REPOSITORY_NAME)
        OpenSearchIntegTestCase.putRepositoryRequestBuilder(
        networkDisruption.stopDisrupting();
     * This test verifies that nodes without proper remote store configuration are rejected.
        ensureStableCluster(6);
/*
import org.opensearch.cluster.metadata.RepositoryMetadata;
    public void testNodeRejoinFailureWithChangedRemoteStoreAttributes() throws Exception {
     * Test repository verification failure during node join.
import java.util.stream.Collectors;
        // This should fail because the remote store repository attributes don't match
        return Stream.concat(super.nodePlugins().stream(), Stream.of(MockTransportService.TestPlugin.class)).collect(Collectors.toList());
        createRepository(repositoryMetadata.name(), repositoryMetadata.type(), updatedSettings);
        internalCluster().clearDisruptionScheme();
        partition.startDisrupting();
import static org.opensearch.repositories.blobstore.BlobStoreRepository.SYSTEM_REPOSITORY_SETTING;
    @Override
        internalCluster().startNode();
        ensureStableCluster(1);
        ).get();
    }
import java.util.Set;
        ensureStableCluster(2);
        internalCluster().restartNode(clusterManagerNodeName);
import org.opensearch.test.transport.MockTransportService;
    }
                    .put("node.attr.remote_store.segment.repository", "different-repo")
            internalCluster().startNode(
        GetRepositoriesRequest request = new GetRepositoriesRequest(new String[] { REPOSITORY_NAME });
            .repositories()
import org.opensearch.test.disruption.NetworkDisruption;
import org.opensearch.test.OpenSearchIntegTestCase;
        ensureStableCluster(3, dataNode);
    public void testMultiNodeClusterRandomNodeRestart() throws Exception {
    }
                Settings.builder()
        NetworkDisruption networkDisruption = new NetworkDisruption(
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesRequest;
                    .put("node.attr.remote_store.translog.repository", REPOSITORY_NAME)
        ensureStableCluster(2);
            repositoryMetadata.type(),
    }
            .repositories()
    /**
    }
        internalCluster().setDisruptionScheme(partition);
import org.opensearch.plugins.Plugin;
        internalCluster().startClusterManagerOnlyNodes(3);
 *
                Settings.builder()
            internalCluster().startNode(
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.JSON));
            .prepareGetRepositories(REPOSITORY_NAME)
        internalCluster().startNode();
        internalCluster().clearDisruptionScheme();
        Settings.Builder updatedSettings = Settings.builder().put(repositoryMetadata.settings()).put("chunk_size", new ByteSizeValue(20));
        internalCluster().clearDisruptionScheme();
        String nodeToRestart = internalCluster().getNodeNames()[1];
        // Start initial cluster with specific remote store repository configuration
    }
        // Attempt to start a second node with different remote store attributes
        internalCluster().setDisruptionScheme(networkDisruption);
        );
            false
            client.admin().cluster(),
            );
        internalCluster().stopCurrentClusterManagerNode();
                    .put("node.attr.remote_store.repository." + REPOSITORY_NAME + ".type", "invalid_repo_type")
    public void testMultiNodeClusterActiveClusterManagerRecoverNetworkIsolation() {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesResponse;
import org.opensearch.core.common.unit.ByteSizeValue;
import org.opensearch.core.xcontent.ToXContent;
            .cluster()
                Settings.builder()
import org.opensearch.transport.client.Client;
        // The validation happens during node startup and throws IllegalStateException
        // This should fail because remote store attributes are required
    }
    public void testRepositoryVerificationFailureDuringNodeJoin() throws Exception {
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesAction;
        // Start cluster with 2 nodes
        expectThrows(IllegalStateException.class, () -> {
    public void testMultiNodeClusterActiveClusterManagerShutDown() throws Exception {
     * Test node join failure when missing required remote store attributes.
        ensureStableCluster(1);
    public void testMultiNodeClusterRepositoryRegistrationWithMultipleClusterManager() throws Exception {
        );
        final Client client = client(nodesInOneSide.iterator().next());
        ensureStableCluster(1);
import org.opensearch.core.xcontent.XContentBuilder;
            .get()
        ensureStableCluster(6);
     * Test node rejoin failure when node attributes are changed after initial join.
            .prepareGetRepositories(REPOSITORY_NAME)
            internalCluster().startNode(
    }
    /**
    /**
        ensureStableCluster(3, nodesInOneSide.stream().findAny().get());
        internalCluster().restartRandomDataNode();
    }
        // Attempt to add a node without remote store attributes
            repositoryMetadata.name(),
                    .build()
        updatedSettings.remove("system_repository");
        String dataNode = internalCluster().startNode();
}
        ensureStableCluster(4);
import java.util.Collection;
        String clusterManagerNodeName = internalCluster().getClusterManagerName();
        internalCluster().startClusterManagerOnlyNode();
        internalCluster().startNodes(3);
    }
    }
        });
    public void testNodeJoinFailureWithMissingRemoteStoreAttributes() throws Exception {
        // Attempt to start a node with invalid repository type - this should fail during repository validation
            new NetworkDisruption.TwoPartitions(nodesInOneSide, nodesInAnotherSide),
        internalCluster().startNode();
            ensureStableCluster(2);
        partition.stopDisrupting();
                        .put("node.attr.remote_store.segment.repository", "changed-segment-repo")
        Set<String> nodesInAnotherSide = internalCluster().startNodes(3).stream().collect(Collectors.toCollection(HashSet::new));
                    .build()
        Set<String> nodesInOneSide = internalCluster().startNodes(3).stream().collect(Collectors.toCollection(HashSet::new));
     */
        NetworkDisruption partition = isolateClusterManagerDisruption(NetworkDisruption.DISCONNECT);
 */
                    .put("node.attr.remote_store.translog.repository", "different-translog-repo")
                        .put("node.attr.remote_store.translog.repository", "changed-translog-repo")
     * due to invalid repository settings or missing repository type information.
        internalCluster().startNodes(2);
     */
                public Settings onNodeStopped(String nodeName) {
        // We use an invalid repository type that doesn't exist to trigger repository verification failure
        repositoriesResponse = GetRepositoriesResponse.fromXContent(createParser(xContentBuilder));
    public void testMultiNodeClusterRandomNodeRecoverNetworkIsolation() {
     */
    public void testSingleNodeClusterRepositoryRegistration() throws Exception {
        ensureStableCluster(3);
                    // Return different remote store attributes when restarting
                    // This will fail because it's missing the required repository type attributes
                }
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
    public void testNodeRestartPostNonRestrictedSettingsUpdate() throws Exception {
    public void testMultiNodeClusterRandomNodeRecoverNetworkIsolationPostNonRestrictedSettingsUpdate() {
import org.opensearch.test.InternalTestCluster.RestartCallback;
        RepositoryMetadata repositoryMetadata = client.admin()
        NetworkDisruption networkDisruption = new NetworkDisruption(
import org.opensearch.common.xcontent.XContentType;
        ensureStableCluster(6);
        networkDisruption.startDisrupting();
    /**
 * compatible open source license.
        networkDisruption.startDisrupting();
            updatedSettings,
     * This test verifies that a node cannot rejoin the cluster with different remote store attributes.
    }
        ensureStableCluster(1);
        expectThrows(IllegalStateException.class, () -> {
import org.opensearch.core.xcontent.MediaTypeRegistry;
                    return Settings.builder()
            internalCluster().restartNode(nodeToRestart, new RestartCallback() {
        internalCluster().startClusterManagerOnlyNodes(3);
        ensureStableCluster(1);
        });
            });
     * This test verifies that nodes fail to join when remote store repositories cannot be verified
                        .build();
        Set<String> nodesInAnotherSide = internalCluster().startNodes(3).stream().collect(Collectors.toCollection(HashSet::new));
        ensureStableCluster(1);
    }
            );
        RepositoryMetadata repositoryMetadata = client.admin()
     * Test node join failure when trying to join a cluster with different remote store repository attributes.
        XContentBuilder xContentBuilder = repositoriesResponse.toXContent(builder, ToXContent.EMPTY_PARAMS);
        internalCluster().startNodes(3);
        ensureStableCluster(6);
     */
            .get()
package org.opensearch.remotestore;
import java.io.IOException;
    public void testMultiNodeClusterActiveMClusterManagerRestart() throws Exception {
        internalCluster().startNodes(3);
        final Client client = client();
        ensureStableCluster(4);
                    .putNull("node.attr.remote_store.segment.repository")
        internalCluster().startNodes(3);
        internalCluster().setDisruptionScheme(networkDisruption);
        updatedSettings.remove("system_repository");
        Settings.Builder updatedSettings = Settings.builder().put(repositoryMetadata.settings()).put("chunk_size", new ByteSizeValue(20));
    public void testMultiNodeClusterRepositoryRegistration() throws Exception {
                    .putNull("node.attr.remote_store.translog.repository")
        internalCluster().startNodes(3);
        // Attempt to restart node with different remote store attributes should fail
        assertEquals(false, SYSTEM_REPOSITORY_SETTING.get(repositoriesResponse.repositories().get(0).settings()));
        ensureStableCluster(1);
            NetworkDisruption.DISCONNECT
        Set<String> nodesInOneSide = internalCluster().startNodes(3).stream().collect(Collectors.toCollection(HashSet::new));
        internalCluster().startNodes(3);
            .cluster()
        internalCluster().restartRandomDataNode();
