            clusterManagerTransportService,
 */
        internalCluster().setDisruptionScheme(disruption);
import org.opensearch.common.settings.Settings;  
        // Checking if the final cluster-state is updated.  
        final Set<String> nodes = new HashSet<>(internalCluster().startNodes(3));  
        logger.info("--> forcing a complete election again");  
            TransportService.class,  
    public void testElectClusterManagerWithLatestVersion() throws Exception {
 * license agreements. See the NOTICE file distributed with
        logger.info("Blocking Cluster Manager Commit Request on all nodes");
            .get();
import java.util.List;
            );
            clusterManagerNode
import org.opensearch.test.disruption.ServiceDisruptionScheme;
                }  
        Assert.assertTrue("RemoteState Repo is not set in RepositoryService", isRemoteStateRepoConfigured);
/*  
 */  
        logger.info("Stopping current Cluster Manager");  
        isolateAllNodes.stopDisrupting();  
    }  
import org.opensearch.transport.Transport;
            assertNotNull(repositoriesMetadata);  
        internalCluster().clearDisruptionScheme();
        // we had the new cluster-state published but not commited.
    }  
        client(randomFrom(nonPreferredNodes)).admin()
        // on the states associated with the commit requests we may have dropped
            NetworkDisruption.DISCONNECT
        logger.info("waiting for [{}] to be removed from cluster", nonClusterManagerNode);
}
        final String preferredClusterManagerName = internalCluster().getClusterManagerName();  
            );
        try {
            TransportService.class,
            remoteStateRepoName,  
            Repository remoteStateRepo = repositoriesService.repository(repoName);  
public class DiscoveryDisruptionIT extends AbstractDisruptionTestCase {
    }  
        );  
            .setSettings(
        final CountDownLatch countDownLatch = new CountDownLatch(2);  
        while (nonClusterManagerNode == null) {
 * ownership. Elasticsearch licenses this file to you under  
    }
        MockTransportService nonClusterManagerTransportService = (MockTransportService) internalCluster().getInstance(
            }
import org.opensearch.cluster.ClusterState;
            TransportService.class,
        logger.info("--> preferred cluster-manager is {}", preferredClusterManager);  
package org.opensearch.discovery;
        // We stop the current cluster-manager whose outbound paths were blocked. This is to force a new election onto nodes
/*  
 * specific language governing permissions and limitations
        );  
        startCluster(3);  
            TransportService targetTransportService = internalCluster().getInstance(TransportService.class, node);
import java.util.concurrent.CountDownLatch;
        logger.info("waiting for cluster to reform");  
        String clusterManagerNode = internalCluster().getClusterManagerName();
        }  
        // shutting down the nodes, to avoid the leakage check tripping  
import org.opensearch.cluster.metadata.RepositoryMetadata;
        } else {
        MockTransportService clusterManagerTransportService = (MockTransportService) internalCluster().getInstance(
        );
        final DiscoveryNode preferredClusterManager = internalCluster().clusterService(preferredClusterManagerName).localNode();
            Boolean isRemoteStateRepoConfigured = Boolean.FALSE;  
        }  
        String randomNode = nonClusterManagerNodes.get(Randomness.get().nextInt(nonClusterManagerNodes.size()));
        // nodes have a successful publish operation but failed commit operation. This will come into play once the new node joins  
            (connection, requestId, action, request, options) -> {  
        Assert.assertTrue("RemoteState Repo is not set in RepositoriesMetadata", isRemoteStateRepoConfigured);
 *  
            clusterManagerNode,
        assertBusy(() -> {  
        );  
                }
                Settings.builder().put(INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1).put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
        );
            if (nonClusterManagerNode.equals(clusterManagerNode)) {  
        for (String node : nodes) {
            // Asserting that the metadata is not present in the repository service.
            clusterManagerNode
                nonClusterManagerNode = null;
 * this file be licensed under the Apache-2.0 license or a
        if (state.metadata().hasIndex("test") == false) {  
        );  
        disruption.startDisrupting();  
                if (action.equals(PublicationTransportHandler.COMMIT_STATE_ACTION_NAME)) {
import org.opensearch.cluster.coordination.PublicationTransportHandler;
        List<String> nonClusterManagerNodes = Arrays.stream(internalCluster().getNodeNames())  
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING;
    public void testNodeNotReachableFromClusterManager() throws Exception {
            clusterManagerNode
        internalCluster().stopCurrentClusterManagerNode();  
        // don't wait for initial state, we want to add the disruption while the cluster is forming  
        logger.info("Stopping current Cluster Manager");
            }
        nonClusterManagerTransportService.addConnectBehavior(clusterManagerTransportService, Transport::openConnection);
            // Asserting that the metadata is present in the persisted cluster-state
 *
        String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();
            .filter(node -> !node.equals(clusterManagerNode))
            )  
        logger.info("blocking request from cluster-manager [{}] to [{}]", clusterManagerNode, nonClusterManagerNode);
                } else if (repo.name().equals(remoteRoutingTableRepoName)) {  
                    countDownLatch.countDown();
 * SPDX-License-Identifier: Apache-2.0
 * Tests for discovery during disruptions.
import org.junit.Assert;  
 * GitHub history for details.
import org.opensearch.transport.TransportService;
import org.opensearch.repositories.fs.ReloadableFsRepository;
                localTransportService,
        ensureStableCluster(6);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        isolatePreferredClusterManager.startDisrupting();
                connection.sendRequest(requestId, action, request, options);
            clusterManagerTransportService.addFailToSendNoConnectRule(  
            ClusterState state = registry.getPersistedState(PersistedStateRegistry.PersistedStateType.LOCAL).getLastAcceptedState();
        Assert.assertTrue("RemoteRoutingTable Repo is not set in RepositoryService", isRemoteRoutingTableRepoConfigured);
        String nonClusterManagerNode = null;  
                if (action.equals(JoinHelper.JOIN_ACTION_NAME)) {
            discoveryNodes.getLocalNode().getName()
     */  
 * compatible open source license.
        String nonClusterManagerNode = internalCluster().startDataOnlyNode();  
            clusterManagerNode
        ServiceDisruptionScheme isolateAllNodes = new NetworkDisruption(
    }  
        );
            if (repo.name().equals(remoteStateRepoName)) {
        TransportService clusterManagerTranspotService = internalCluster().getInstance(
import org.opensearch.test.OpenSearchIntegTestCase;
     * Adds an asymmetric break between a cluster-manager and one of the nodes and makes
                connection.sendRequest(requestId, action, request, options);
        );
            for (RepositoryMetadata repo : repositoriesMetadata.repositories()) {  
            if (Objects.nonNull(remoteStateRepo)) {
import org.opensearch.test.disruption.SlowClusterStateProcessing;
        // This is to allow the new node to have commit failures on the nodes in the send path itself. This will lead to the
        MockTransportService clusterManagerTransportService = (MockTransportService) internalCluster().getInstance(  
    private Boolean isRepoPresentInRepositoryService(RepositoriesService repositoriesService, String repoName) {
            }
        }  
        assertNoClusterManager(nonClusterManagerNode);  
        }
        for (String node : nodes) {
     * Tests the scenario where-in a cluster-state containing new repository meta-data as part of a node-join from a  
        return Boolean.FALSE;
            remoteRoutingTableRepoName,
     */
            assertNotNull(repositoriesMetadata.repositories());
            nonClusterManagerNode,  
        RepositoriesMetadata repositoriesMetadata = internalCluster().getInstance(ClusterService.class, randomNode)
     * the cluster reforms when healed.  
        });
            RepositoriesService repositoriesService = internalCluster().getInstance(RepositoriesService.class, randomNode);
            clusterManagerTransportService.addFailToSendNoConnectRule(
        internalCluster().setDisruptionScheme(isolatePreferredClusterManager);
                    isRemoteStateRepoConfigured = Boolean.TRUE;
            return Boolean.FALSE;
 * The OpenSearch Contributors require contributions made to  
            .state()
            TransportService.class,
            .prepareCreate("test")  
        SlowClusterStateProcessing disruption = new SlowClusterStateProcessing(random(), 0, 0, 1000, 2000);
        nonClusterManagerTransportService.addSendBehavior(
        Assert.assertTrue("RemoteRoutingTable Repo is not set in RepositoriesMetadata", isRemoteRoutingTableRepoConfigured);  
 * Unless required by applicable law or agreed to in writing,
     */  
            .collect(Collectors.toList());
import org.opensearch.cluster.node.DiscoveryNodes;  
        clusterManagerTransportService.clearAllRules();  
        } catch (RepositoryMissingException e) {
        } else {  
    }
            isRemoteRoutingTableRepoConfigured = isRepoPresentInRepositoryService(repositoriesService, remoteRoutingTableRepoName);
            ReloadableFsRepository.TYPE  
        Settings remotePublicationSettings = buildRemotePublicationNodeAttributes(
            Boolean isRemoteRoutingTableRepoConfigured = Boolean.FALSE;
        internalCluster().setDisruptionScheme(isolateAllNodes);
        TransportService localTransportService = internalCluster().getInstance(  
        ensureStableCluster(2);
        countDownLatch.await();
        }
        ensureStableCluster(6);
        final ServiceDisruptionScheme isolatePreferredClusterManager = isolateClusterManagerDisruption(NetworkDisruption.DISCONNECT);  
 *
            clusterManagerTransportService.addFailToSendNoConnectRule(
        // Checking if publish succeeded in the nodes before shutting down the blocked cluster-manager
            PersistedStateRegistry registry = internalCluster().getInstance(PersistedStateRegistry.class, randomNode);
        ensureStableCluster(3);
        final ClusterState state = client().admin().cluster().prepareState().get().getState();
import org.opensearch.cluster.metadata.RepositoriesMetadata;  
        // repositories validations are skipped because even though the cluster-state is updated in the persisted registry,  
                internalCluster().getInstance(TransportService.class, nonClusterManagerNode)
            );
 * Licensed to Elasticsearch under one or more contributor  
        });
        internalCluster().startNodes(3);
            ReloadableFsRepository.TYPE,
            String randomNode = nonClusterManagerNodes.get(Randomness.get().nextInt(nonClusterManagerNodes.size()));
    public void testElectClusterManagerRemotePublicationConfigurationNodeJoinCommitFails() throws Exception {
        // We expect that the repositories validations are skipped in this case and node-joins succeeds as expected. The
        logger.info(
        isRemoteStateRepoConfigured = isRepoPresentInRepositoryService(repositoriesService, remoteStateRepoName);
import org.opensearch.cluster.service.ClusterService;
import java.util.Set;  
            Assert.assertFalse(isRemoteStateRepoConfigured);
            new NetworkDisruption.IsolateAllNodes(nodes),  
            }  
        DiscoveryNodes discoveryNodes = internalCluster().getInstance(ClusterService.class, nonClusterManagerNode).state().nodes();
        }  
                PublicationTransportHandler.COMMIT_STATE_ACTION_NAME  
        }
    /**
        ensureStableCluster(3);
            assertNoClusterManager(node);  
            "blocking cluster state publishing from cluster-manager [{}] to non cluster-manager [{}]",
                isRemoteRoutingTableRepoConfigured = Boolean.TRUE;
        internalCluster().clearDisruptionScheme(false);  
                PublicationTransportHandler.PUBLISH_STATE_ACTION_NAME
        if (randomBoolean()) {
                    isRemoteRoutingTableRepoConfigured = Boolean.TRUE;
        String clusterManagerNode = internalCluster().getClusterManagerName();
     * repository-configured node fails on a commit stag and has a master switch. This would lead to master nodes
        isolateAllNodes.startDisrupting();
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        // Start a node with remote-publication repositories configured. This will lead to the active cluster-manager create
        // a new cluster-state event with the new node-join along with new repositories setup in the cluster meta-data.
                    throw new FailedToCommitClusterStateException("Blocking Commit");  
        RepositoriesService repositoriesService = internalCluster().getInstance(RepositoriesService.class, randomNode);
 * Modifications Copyright OpenSearch Contributors. See
        assertNoClusterManager(nonClusterManagerNode);
            fail("index 'test' was lost. current cluster state: " + state);
import org.opensearch.cluster.coordination.PersistedStateRegistry;
import java.util.stream.Collectors;
/*
        clusterManagerTransportService.clearOutboundRules(localTransportService);
    /**
        ensureStableCluster(2, clusterManagerNode);  
     * Test cluster join with issues in cluster state publishing *
import java.util.Objects;
            TransportService.class,
            .custom(RepositoriesMetadata.TYPE);
import org.opensearch.test.transport.MockTransportService;  
                isRemoteStateRepoConfigured = Boolean.TRUE;
import org.opensearch.cluster.coordination.JoinHelper;  
        logger.info("--> forcing a complete election to make sure \"preferred\" cluster-manager is elected");
        isolateAllNodes.startDisrupting();  
    public void testClusterJoinDespiteOfPublishingIssues() throws Exception {
    public void testClusterFormingWithASlowNode() {
 */  
            assertNoClusterManager(node);
        logger.info("healing partition and checking cluster reforms");
            );
            nonClusterManagerNode = randomFrom(internalCluster().getNodeNames());
        Boolean isRemoteRoutingTableRepoConfigured = Boolean.FALSE;
 */  
        ensureStableCluster(3);
        internalCluster().startDataOnlyNodes(1, remotePublicationSettings, Boolean.TRUE);  
        Boolean isRemoteStateRepoConfigured = Boolean.FALSE;  
            Assert.assertFalse(isRemoteRoutingTableRepoConfigured);  
        logger.info("blocking requests from non cluster-manager [{}] to cluster-manager [{}]", nonClusterManagerNode, clusterManagerNode);  
import org.opensearch.common.Randomness;
                localTransportService,  
            .indices()
            TransportService.class,
import org.opensearch.repositories.Repository;
                return Boolean.TRUE;
 * this work for additional information regarding copyright
        nonClusterManagerTransportService.addFailToSendNoConnectRule(clusterManagerTranspotService);
                internalCluster().getInstance(TransportService.class, nonClusterManagerNode)  
            clusterManagerTransportService.addSendBehavior(targetTransportService, (connection, requestId, action, request, options) -> {  
        logger.info("waiting for [{}] to have no cluster-manager", nonClusterManagerNode);
            }  
import org.opensearch.test.disruption.NetworkDisruption;  
        );
        internalCluster().startClusterManagerOnlyNodes(3);
     * sure that the node is removed form the cluster, that the node start pinging and that
        internalCluster().stopRandomNodeNotCurrentClusterManager();
                    logger.info("--> preventing {} request", PublicationTransportHandler.COMMIT_STATE_ACTION_NAME);
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING;
                }
            "allowing requests from non cluster-manager [{}] to cluster-manager [{}], waiting for two join request",
 * software distributed under the License is distributed on an
            });  
 *    http://www.apache.org/licenses/LICENSE-2.0
            nonClusterManagerNode  
        internalCluster().startDataOnlyNodes(3);  
        final String remoteStateRepoName = "remote-state-repo";
        final Set<String> nonPreferredNodes = new HashSet<>(nodes);
        for (RepositoryMetadata repo : repositoriesMetadata.repositories()) {  
            clusterManagerTransportService.addUnresponsiveRule(
    /**  
        );
        nonClusterManagerNodes.forEach(node -> {
        internalCluster().setDisruptionScheme(isolateAllNodes);  
            RepositoriesMetadata repositoriesMetadata = state.metadata().custom(RepositoriesMetadata.TYPE);
            isRemoteStateRepoConfigured = isRepoPresentInRepositoryService(repositoriesService, remoteStateRepoName);
            discoveryNodes.getClusterManagerNode().getName()  
/**
        final String remoteRoutingTableRepoName = "routing-table-repo";  
        ensureStableCluster(3);
        isRemoteRoutingTableRepoConfigured = isRepoPresentInRepositoryService(repositoriesService, remoteRoutingTableRepoName);
        }  
            nonClusterManagerNode  
        // the repository service will not be updated as the commit attempt failed.
import org.opensearch.cluster.node.DiscoveryNode;
     * doing another round of node-joins with the new cluster-state as the previous attempt had a successful publish.
            .metadata()  
 * under the License.  
            assertTrue(isRemoteRoutingTableRepoConfigured);  
        if (randomBoolean()) {
        nonPreferredNodes.remove(preferredClusterManagerName);
        logger.info("applying disruption while cluster is forming ...");  
import org.opensearch.repositories.RepositoryMissingException;  
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
        );
            } else if (repo.name().equals(remoteRoutingTableRepoName)) {  
            assertTrue(isRemoteStateRepoConfigured);
import java.util.HashSet;  
import java.util.Arrays;
        logger.info(  
import org.opensearch.cluster.coordination.FailedToCommitClusterStateException;
                if (repo.name().equals(remoteStateRepoName)) {
        MockTransportService clusterManagerTransportService = (MockTransportService) internalCluster().getInstance(  
        nonClusterManagerTransportService.clearOutboundRules(localTransportService);
import org.opensearch.repositories.RepositoriesService;
        logger.info("Starting Node with remote publication settings");  
