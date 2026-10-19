    }
    }
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    }
        networkDisruption.startDisrupting();  
import static org.opensearch.repositories.blobstore.BlobStoreRepository.SYSTEM_REPOSITORY_SETTING;
        Settings.Builder updatedSettings = Settings.builder().put(repositoryMetadata.settings()).put("chunk_size", new ByteSizeValue(20));
            .cluster()
 *
    public void testMultiNodeClusterActiveClusterManagerRecoverNetworkIsolation() {
        internalCluster().startNode();
        ensureStableCluster(2);  
        assertEquals(false, SYSTEM_REPOSITORY_SETTING.get(repositoriesResponse.repositories().get(0).settings()));
 */  
        ensureStableCluster(3, nodesInOneSide.stream().findAny().get());
        // The validation happens during node startup and throws IllegalStateException
        GetRepositoriesRequest request = new GetRepositoriesRequest(new String[] { REPOSITORY_NAME });  
                        .put("node.attr.remote_store.translog.repository", "changed-translog-repo")
    }  
            );  
/*  
     * This negative test case verifies that nodes with incompatible remote store configurations are rejected.
        internalCluster().stopCurrentClusterManagerNode();
        ensureStableCluster(1);
        NetworkDisruption networkDisruption = new NetworkDisruption(  
        ensureStableCluster(1);  
    }  
                Settings.builder()
    public void testMultiNodeClusterActiveClusterManagerShutDown() throws Exception {  
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesAction;
        internalCluster().startNodes(3);
                        .build();  
    public void testMultiNodeClusterRandomNodeRecoverNetworkIsolation() {
        // Start initial cluster with specific remote store repository configuration
import java.util.HashSet;
     */
    public void testNodeRestartPostNonRestrictedSettingsUpdate() throws Exception {
    public void testNodeJoinFailureWithDifferentRemoteStoreRepositoryAttributes() throws Exception {  
        });  
                    .putNull("node.attr.remote_store.segment.repository")  
     * due to invalid repository settings or missing repository type information.  
        partition.stopDisrupting();
        NetworkDisruption networkDisruption = new NetworkDisruption(
        Set<String> nodesInOneSide = internalCluster().startNodes(3).stream().collect(Collectors.toCollection(HashSet::new));
                Settings.builder()  
        ensureStableCluster(6);  
        internalCluster().startClusterManagerOnlyNode();  
        expectThrows(IllegalStateException.class, () -> {  
    }
import org.opensearch.common.settings.Settings;
    /**  
    public void testMultiNodeClusterRandomNodeRestart() throws Exception {
            .prepareGetRepositories(REPOSITORY_NAME)
    public void testMultiNodeClusterRandomNodeRecoverNetworkIsolationPostNonRestrictedSettingsUpdate() {
        Set<String> nodesInAnotherSide = internalCluster().startNodes(3).stream().collect(Collectors.toCollection(HashSet::new));
        });
import org.opensearch.core.xcontent.XContentBuilder;
    }
import org.opensearch.cluster.metadata.RepositoryMetadata;
        // Attempt to restart node with different remote store attributes should fail
                    .put("node.attr.remote_store.segment.repository", "different-repo")
        internalCluster().clearDisruptionScheme();
     * This test verifies that nodes without proper remote store configuration are rejected.
     * Test node join failure when missing required remote store attributes.  
        internalCluster().restartRandomDataNode();  
        ensureStableCluster(4);  
        });  
                    .put("node.attr.remote_store.translog.repository", REPOSITORY_NAME)  
import org.opensearch.core.xcontent.ToXContent;  
}  
        final Client client = client(nodesInOneSide.iterator().next());
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesRequest;
                Settings.builder()
    }  
            });
        internalCluster().clearDisruptionScheme();
    public void testNodeJoinFailureWithMissingRemoteStoreAttributes() throws Exception {  
        String clusterManagerNodeName = internalCluster().getClusterManagerName();
            .get(0);
            internalCluster().startNode(
        Settings.Builder updatedSettings = Settings.builder().put(repositoryMetadata.settings()).put("chunk_size", new ByteSizeValue(20));  
                @Override
import org.opensearch.core.common.unit.ByteSizeValue;
        ensureStableCluster(1);  
        expectThrows(IllegalStateException.class, () -> {
            .get(0);  
        createRepository(repositoryMetadata.name(), repositoryMetadata.type(), updatedSettings);
    }  
        internalCluster().clearDisruptionScheme();
    }
        internalCluster().startNodes(3);
        expectThrows(Exception.class, () -> {
        updatedSettings.remove("system_repository");
        // Start cluster with 2 nodes
        internalCluster().startNode();
    }
        internalCluster().setDisruptionScheme(networkDisruption);
        ensureStableCluster(1);
        });
        return Stream.concat(super.nodePlugins().stream(), Stream.of(MockTransportService.TestPlugin.class)).collect(Collectors.toList());
import org.opensearch.test.OpenSearchIntegTestCase;
            .get()
            false  
        ensureStableCluster(3);
                    return Settings.builder()  
        // This should fail because remote store attributes are required
        internalCluster().startNodes(3);  
 * compatible open source license.
            internalCluster().restartNode(nodeToRestart, new RestartCallback() {
 * this file be licensed under the Apache-2.0 license or a
            );  
                    .put("node.attr.remote_store.segment.repository", REPOSITORY_NAME)
        final Client client = client();  
        internalCluster().restartNode(clusterManagerNodeName);  
    public void testMultiNodeClusterRepositoryRegistrationWithMultipleClusterManager() throws Exception {
        );
import java.util.Collection;
import java.io.IOException;  
    /**
     */
        RepositoryMetadata repositoryMetadata = client.admin()
        internalCluster().startNodes(2);
import org.opensearch.test.disruption.NetworkDisruption;
        internalCluster().setDisruptionScheme(partition);  
     * Test node rejoin failure when node attributes are changed after initial join.  
        RepositoryMetadata repositoryMetadata = client.admin()  
    }  
    public void testMultiNodeClusterRepositoryRegistration() throws Exception {  
        internalCluster().startNodes(3);
        ensureStableCluster(1);  
        String dataNode = internalCluster().startNode();  
        Set<String> nodesInAnotherSide = internalCluster().startNodes(3).stream().collect(Collectors.toCollection(HashSet::new));  
     */
        internalCluster().startNodes(3);
            null,
        internalCluster().restartRandomDataNode();  
        ensureStableCluster(6);
                    // This will fail because it's missing the required repository type attributes
import org.opensearch.plugins.Plugin;
                    .build()
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesResponse;  
                    .build()
import org.opensearch.core.xcontent.MediaTypeRegistry;
        networkDisruption.startDisrupting();
        internalCluster().setDisruptionScheme(networkDisruption);
    public void testRepositoryVerificationFailureDuringNodeJoin() throws Exception {
        ensureStableCluster(4);
        OpenSearchIntegTestCase.putRepositoryRequestBuilder(
        XContentBuilder xContentBuilder = repositoriesResponse.toXContent(builder, ToXContent.EMPTY_PARAMS);  
            internalCluster().startNode(
    @Override  
            .prepareGetRepositories(REPOSITORY_NAME)  
    }  
            NetworkDisruption.DISCONNECT  
            ensureStableCluster(2);
                    .put("node.attr.remote_store.translog.repository", "different-translog-repo")
                }
    public void testMultiNodeClusterActiveMClusterManagerRestart() throws Exception {  
            updatedSettings,
                    .put("node.attr.remote_store.repository." + REPOSITORY_NAME + ".type", "invalid_repo_type")
import java.util.Set;  
    }
    /**
            repositoryMetadata.type(),
            );
        networkDisruption.stopDisrupting();
        ensureStableCluster(3, nodesInOneSide.stream().findAny().get());  
import org.opensearch.test.InternalTestCluster.RestartCallback;  
            new NetworkDisruption.TwoPartitions(nodesInOneSide, nodesInAnotherSide),
        repositoriesResponse = GetRepositoriesResponse.fromXContent(createParser(xContentBuilder));
        GetRepositoriesResponse repositoriesResponse = client().execute(GetRepositoriesAction.INSTANCE, request).actionGet();
 * SPDX-License-Identifier: Apache-2.0
    public void testSystemRepositorySettingIsHiddenForGetRepositoriesRequest() throws IOException {
        // Attempt to add a node without remote store attributes
        internalCluster().startClusterManagerOnlyNodes(3);
        // We use an invalid repository type that doesn't exist to trigger repository verification failure
        partition.startDisrupting();
     * Test node join failure when trying to join a cluster with different remote store repository attributes.  
        internalCluster().startNodes(3);
            .repositories()
     */
     * Test repository verification failure during node join.
            NetworkDisruption.DISCONNECT
        expectThrows(IllegalStateException.class, () -> {  
                public Settings onNodeStopped(String nodeName) {  
package org.opensearch.remotestore;
        updatedSettings.remove("system_repository");
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
        // Attempt to start a node with invalid repository type - this should fail during repository validation  
import java.util.stream.Stream;
        ensureStableCluster(6);
        networkDisruption.stopDisrupting();  
    public void testNodeRejoinFailureWithChangedRemoteStoreAttributes() throws Exception {  
            repositoryMetadata.name(),
            new NetworkDisruption.TwoPartitions(nodesInOneSide, nodesInAnotherSide),
import org.opensearch.transport.client.Client;
        NetworkDisruption partition = isolateClusterManagerDisruption(NetworkDisruption.DISCONNECT);
     * This test verifies that nodes fail to join when remote store repositories cannot be verified
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.JSON));
                    // Return different remote store attributes when restarting
        ensureStableCluster(1);
        ensureStableCluster(1);
            true,  
        ensureStableCluster(3, dataNode);  
     * This test verifies that a node cannot rejoin the cluster with different remote store attributes.
        Set<String> nodesInOneSide = internalCluster().startNodes(3).stream().collect(Collectors.toCollection(HashSet::new));  
        ensureStableCluster(6);
public class RemoteStoreRepositoryRegistrationIT extends RemoteStoreBaseIntegTestCase {
import org.opensearch.test.transport.MockTransportService;  
        internalCluster().startNode();  
        internalCluster().startNode();  
            client.admin().cluster(),  
    /**
            .get()  
        internalCluster().startClusterManagerOnlyNodes(3);
import org.opensearch.common.xcontent.XContentType;  
            internalCluster().startNode(  
            .repositories()
    public void testSingleNodeClusterRepositoryRegistration() throws Exception {
        ensureStableCluster(2);  
        );  
        ).get();
        String nodeToRestart = internalCluster().getNodeNames()[1];
                    .build()  
                        .put("node.attr.remote_store.segment.repository", "changed-segment-repo")
        // Attempt to start a second node with different remote store attributes
    }
import java.util.stream.Collectors;
 * The OpenSearch Contributors require contributions made to  
            .cluster()
        // This should fail because the remote store repository attributes don't match  
    }  
                    .putNull("node.attr.remote_store.translog.repository")
        ensureStableCluster(3);
