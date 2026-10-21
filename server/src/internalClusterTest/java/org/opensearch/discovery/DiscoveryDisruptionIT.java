        Assert.assertTrue("RemoteRoutingTable Repo is not set in RepositoryService", isRemoteRoutingTableRepoConfigured);
        Boolean isRemoteStateRepoConfigured = Boolean.FALSE;
            assertNotNull(repositoriesMetadata.repositories());
/**
        // the repository service will not be updated as the commit attempt failed.
            );
import java.util.Set;
        MockTransportService clusterManagerTransportService = (MockTransportService) internalCluster().getInstance(
        nonClusterManagerTransportService.clearOutboundRules(localTransportService);
            (connection, requestId, action, request, options) -> {
        );
        logger.info(
                if (action.equals(PublicationTransportHandler.COMMIT_STATE_ACTION_NAME)) {
 * You may obtain a copy of the License at
            return Boolean.FALSE;
        MockTransportService nonClusterManagerTransportService = (MockTransportService) internalCluster().getInstance(
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.coordination.JoinHelper;
            // Asserting that the metadata is present in the persisted cluster-state
        // a new cluster-state event with the new node-join along with new repositories setup in the cluster meta-data.
    public void testClusterJoinDespiteOfPublishingIssues() throws Exception {
     * Test cluster join with issues in cluster state publishing *
            discoveryNodes.getClusterManagerNode().getName()
        );
        // don't wait for initial state, we want to add the disruption while the cluster is forming
        });
        internalCluster().setDisruptionScheme(isolateAllNodes);
        // we had the new cluster-state published but not commited.
            nonClusterManagerNode
        isRemoteRoutingTableRepoConfigured = isRepoPresentInRepositoryService(repositoriesService, remoteRoutingTableRepoName);
import java.util.concurrent.CountDownLatch;
            clusterManagerTransportService,
import java.util.HashSet;
        // We stop the current cluster-manager whose outbound paths were blocked. This is to force a new election onto nodes
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
}
        logger.info("Blocking Cluster Manager Commit Request on all nodes");
        String clusterManagerNode = internalCluster().getClusterManagerName();
                isRemoteStateRepoConfigured = Boolean.TRUE;
        String nonClusterManagerNode = internalCluster().startDataOnlyNode();
        DiscoveryNodes discoveryNodes = internalCluster().getInstance(ClusterService.class, nonClusterManagerNode).state().nodes();
 * The OpenSearch Contributors require contributions made to
    }
        assertBusy(() -> {
import org.opensearch.cluster.coordination.PublicationTransportHandler;
import org.opensearch.cluster.metadata.RepositoriesMetadata;
            isRemoteRoutingTableRepoConfigured = isRepoPresentInRepositoryService(repositoriesService, remoteRoutingTableRepoName);
        );
            .metadata()
import org.opensearch.common.Randomness;
                    countDownLatch.countDown();
                localTransportService,
        );
        logger.info("waiting for [{}] to be removed from cluster", nonClusterManagerNode);
     * doing another round of node-joins with the new cluster-state as the previous attempt had a successful publish.
 * KIND, either express or implied.  See the License for the
            );
import org.opensearch.test.OpenSearchIntegTestCase;
            assertNoClusterManager(node);
 * GitHub history for details.
        );
        Boolean isRemoteRoutingTableRepoConfigured = Boolean.FALSE;
/*
            new NetworkDisruption.IsolateAllNodes(nodes),
    }
        client(randomFrom(nonPreferredNodes)).admin()
        if (randomBoolean()) {
     * sure that the node is removed form the cluster, that the node start pinging and that
            Boolean isRemoteStateRepoConfigured = Boolean.FALSE;
            Boolean isRemoteRoutingTableRepoConfigured = Boolean.FALSE;
                PublicationTransportHandler.PUBLISH_STATE_ACTION_NAME
import org.opensearch.test.transport.MockTransportService;
        final CountDownLatch countDownLatch = new CountDownLatch(2);
                    isRemoteRoutingTableRepoConfigured = Boolean.TRUE;
import org.opensearch.cluster.coordination.PersistedStateRegistry;
        }
 * ownership. Elasticsearch licenses this file to you under
        }
            RepositoriesService repositoriesService = internalCluster().getInstance(RepositoriesService.class, randomNode);
 * Tests for discovery during disruptions.
                } else if (repo.name().equals(remoteRoutingTableRepoName)) {
                    isRemoteStateRepoConfigured = Boolean.TRUE;
     * Tests the scenario where-in a cluster-state containing new repository meta-data as part of a node-join from a
            nonClusterManagerNode = randomFrom(internalCluster().getNodeNames());
import org.opensearch.cluster.metadata.RepositoryMetadata;
        for (String node : nodes) {
import org.opensearch.cluster.ClusterState;
        logger.info("applying disruption while cluster is forming ...");
 */
            isRemoteStateRepoConfigured = isRepoPresentInRepositoryService(repositoriesService, remoteStateRepoName);
        try {
            }
        // Start a node with remote-publication repositories configured. This will lead to the active cluster-manager create
        logger.info("blocking request from cluster-manager [{}] to [{}]", clusterManagerNode, nonClusterManagerNode);
        // nodes have a successful publish operation but failed commit operation. This will come into play once the new node joins
        } catch (RepositoryMissingException e) {
            Assert.assertFalse(isRemoteStateRepoConfigured);
        clusterManagerTransportService.clearOutboundRules(localTransportService);
        assertNoClusterManager(nonClusterManagerNode);
            fail("index 'test' was lost. current cluster state: " + state);
 * SPDX-License-Identifier: Apache-2.0
        return Boolean.FALSE;
            }
        logger.info("--> forcing a complete election to make sure \"preferred\" cluster-manager is elected");
            ReloadableFsRepository.TYPE,
                connection.sendRequest(requestId, action, request, options);
            clusterManagerNode,
            .get();
        );
        TransportService localTransportService = internalCluster().getInstance(
        logger.info("blocking requests from non cluster-manager [{}] to cluster-manager [{}]", nonClusterManagerNode, clusterManagerNode);
                }
            )
package org.opensearch.discovery;
    /**
        nonPreferredNodes.remove(preferredClusterManagerName);
            clusterManagerNode
 * specific language governing permissions and limitations
        clusterManagerTransportService.clearAllRules();
            );
        Assert.assertTrue("RemoteState Repo is not set in RepositoriesMetadata", isRemoteStateRepoConfigured);
            .collect(Collectors.toList());
        isolatePreferredClusterManager.startDisrupting();
        for (RepositoryMetadata repo : repositoriesMetadata.repositories()) {
 */
        nonClusterManagerNodes.forEach(node -> {
        MockTransportService clusterManagerTransportService = (MockTransportService) internalCluster().getInstance(
 */
            }
        Assert.assertTrue("RemoteState Repo is not set in RepositoryService", isRemoteStateRepoConfigured);
        ensureStableCluster(3);
        ensureStableCluster(6);
        String nonClusterManagerNode = null;
     */
        );
    }
        logger.info("Starting Node with remote publication settings");
     */
                    throw new FailedToCommitClusterStateException("Blocking Commit");
                }
import java.util.stream.Collectors;
        final ClusterState state = client().admin().cluster().prepareState().get().getState();
            if (nonClusterManagerNode.equals(clusterManagerNode)) {
        // Checking if publish succeeded in the nodes before shutting down the blocked cluster-manager
            ClusterState state = registry.getPersistedState(PersistedStateRegistry.PersistedStateType.LOCAL).getLastAcceptedState();
        startCluster(3);
     * repository-configured node fails on a commit stag and has a master switch. This would lead to master nodes
        // This is to allow the new node to have commit failures on the nodes in the send path itself. This will lead to the
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
        final Set<String> nodes = new HashSet<>(internalCluster().startNodes(3));
    }
import java.util.List;
            assertNotNull(repositoriesMetadata);
 * Unless required by applicable law or agreed to in writing,
        );
        String randomNode = nonClusterManagerNodes.get(Randomness.get().nextInt(nonClusterManagerNodes.size()));
        }
        ensureStableCluster(2, clusterManagerNode);
        List<String> nonClusterManagerNodes = Arrays.stream(internalCluster().getNodeNames())
        internalCluster().setDisruptionScheme(disruption);
        logger.info("Stopping current Cluster Manager");
                return Boolean.TRUE;
        SlowClusterStateProcessing disruption = new SlowClusterStateProcessing(random(), 0, 0, 1000, 2000);
        );
        internalCluster().startNodes(3);
        } else {
import org.opensearch.cluster.node.DiscoveryNode;
            "blocking cluster state publishing from cluster-manager [{}] to non cluster-manager [{}]",
        isolateAllNodes.stopDisrupting();
                }
            .state()
            TransportService.class,
 * this file be licensed under the Apache-2.0 license or a
            }
            .filter(node -> !node.equals(clusterManagerNode))
import org.opensearch.repositories.RepositoriesService;
import org.opensearch.test.disruption.ServiceDisruptionScheme;
    }
    public void testElectClusterManagerRemotePublicationConfigurationNodeJoinCommitFails() throws Exception {
            clusterManagerNode
        nonClusterManagerTransportService.addConnectBehavior(clusterManagerTransportService, Transport::openConnection);
            TransportService.class,
        logger.info(
/*
        isRemoteStateRepoConfigured = isRepoPresentInRepositoryService(repositoriesService, remoteStateRepoName);
        }
 * not use this file except in compliance with the License.
        if (state.metadata().hasIndex("test") == false) {
        );
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING;
            remoteRoutingTableRepoName,
            TransportService.class,
            if (Objects.nonNull(remoteStateRepo)) {
 * Licensed to Elasticsearch under one or more contributor
        TransportService clusterManagerTranspotService = internalCluster().getInstance(
                internalCluster().getInstance(TransportService.class, nonClusterManagerNode)
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING;
        ServiceDisruptionScheme isolateAllNodes = new NetworkDisruption(
 * the Apache License, Version 2.0 (the "License"); you may
            clusterManagerTransportService.addFailToSendNoConnectRule(
                if (action.equals(JoinHelper.JOIN_ACTION_NAME)) {
        RepositoriesService repositoriesService = internalCluster().getInstance(RepositoriesService.class, randomNode);
                connection.sendRequest(requestId, action, request, options);
            Repository remoteStateRepo = repositoriesService.repository(repoName);
            discoveryNodes.getLocalNode().getName()
    public void testNodeNotReachableFromClusterManager() throws Exception {
            );
            .prepareCreate("test")
        isolateAllNodes.startDisrupting();
        String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();
    public void testElectClusterManagerWithLatestVersion() throws Exception {
        final String preferredClusterManagerName = internalCluster().getClusterManagerName();
        logger.info("--> forcing a complete election again");
 */
            clusterManagerTransportService.addSendBehavior(targetTransportService, (connection, requestId, action, request, options) -> {
 *
        ensureStableCluster(3);
        logger.info("--> preferred cluster-manager is {}", preferredClusterManager);
            clusterManagerTransportService.addUnresponsiveRule(
                Settings.builder().put(INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1).put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
import org.opensearch.common.settings.Settings;
 *
import org.opensearch.repositories.fs.ReloadableFsRepository;
        final Set<String> nonPreferredNodes = new HashSet<>(nodes);
     * the cluster reforms when healed.
        logger.info("waiting for [{}] to have no cluster-manager", nonClusterManagerNode);
/*
        ensureStableCluster(2);
        nonClusterManagerTransportService.addSendBehavior(
        internalCluster().clearDisruptionScheme();
        ensureStableCluster(3);
        // We expect that the repositories validations are skipped in this case and node-joins succeeds as expected. The
 *
        });
        internalCluster().startDataOnlyNodes(1, remotePublicationSettings, Boolean.TRUE);
            "allowing requests from non cluster-manager [{}] to cluster-manager [{}], waiting for two join request",
        // on the states associated with the commit requests we may have dropped
            TransportService.class,
            Assert.assertFalse(isRemoteRoutingTableRepoConfigured);
        }
                    logger.info("--> preventing {} request", PublicationTransportHandler.COMMIT_STATE_ACTION_NAME);
            .setSettings(
                internalCluster().getInstance(TransportService.class, nonClusterManagerNode)
        for (String node : nodes) {
                PublicationTransportHandler.COMMIT_STATE_ACTION_NAME
        Settings remotePublicationSettings = buildRemotePublicationNodeAttributes(
                localTransportService,
        countDownLatch.await();
    /**
            nonClusterManagerNode
        ensureStableCluster(6);
        ensureStableCluster(3);
        internalCluster().startClusterManagerOnlyNodes(3);
            assertTrue(isRemoteStateRepoConfigured);
            ReloadableFsRepository.TYPE
            clusterManagerTransportService.addFailToSendNoConnectRule(
        logger.info("healing partition and checking cluster reforms");
            // Asserting that the metadata is not present in the repository service.
            clusterManagerNode
        );
        final DiscoveryNode preferredClusterManager = internalCluster().clusterService(preferredClusterManagerName).localNode();
        logger.info("Stopping current Cluster Manager");
        // shutting down the nodes, to avoid the leakage check tripping
        internalCluster().setDisruptionScheme(isolatePreferredClusterManager);
     */
            assertTrue(isRemoteRoutingTableRepoConfigured);
            RepositoriesMetadata repositoriesMetadata = state.metadata().custom(RepositoriesMetadata.TYPE);
    /**
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
            });
            }
import org.opensearch.cluster.node.DiscoveryNodes;
        internalCluster().clearDisruptionScheme(false);
        isolateAllNodes.startDisrupting();
        logger.info("waiting for cluster to reform");
            nonClusterManagerNode,
 * software distributed under the License is distributed on an
import org.opensearch.repositories.Repository;
import org.opensearch.transport.Transport;
     * Adds an asymmetric break between a cluster-manager and one of the nodes and makes
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
        final String remoteRoutingTableRepoName = "routing-table-repo";
        String clusterManagerNode = internalCluster().getClusterManagerName();
    public void testClusterFormingWithASlowNode() {
            clusterManagerNode
            NetworkDisruption.DISCONNECT
 * under the License.
        final ServiceDisruptionScheme isolatePreferredClusterManager = isolateClusterManagerDisruption(NetworkDisruption.DISCONNECT);
        MockTransportService clusterManagerTransportService = (MockTransportService) internalCluster().getInstance(
        }
            TransportService.class,
        nonClusterManagerTransportService.addFailToSendNoConnectRule(clusterManagerTranspotService);
        if (randomBoolean()) {
        } else {
import org.junit.Assert;
            remoteStateRepoName,
    }
            PersistedStateRegistry registry = internalCluster().getInstance(PersistedStateRegistry.class, randomNode);
            TransportService.class,
        internalCluster().stopCurrentClusterManagerNode();
            assertNoClusterManager(node);
import org.opensearch.test.disruption.SlowClusterStateProcessing;
import org.opensearch.transport.TransportService;
        internalCluster().startDataOnlyNodes(3);
        internalCluster().setDisruptionScheme(isolateAllNodes);
        // repositories validations are skipped because even though the cluster-state is updated in the persisted registry,
            .indices()
import org.opensearch.repositories.RepositoryMissingException;
            TransportService targetTransportService = internalCluster().getInstance(TransportService.class, node);
                isRemoteRoutingTableRepoConfigured = Boolean.TRUE;
                nonClusterManagerNode = null;
            } else if (repo.name().equals(remoteRoutingTableRepoName)) {
        disruption.startDisrupting();
                if (repo.name().equals(remoteStateRepoName)) {
        // Checking if the final cluster-state is updated.
import java.util.Arrays;
        final String remoteStateRepoName = "remote-state-repo";
    private Boolean isRepoPresentInRepositoryService(RepositoriesService repositoriesService, String repoName) {
            clusterManagerTransportService.addFailToSendNoConnectRule(
            String randomNode = nonClusterManagerNodes.get(Randomness.get().nextInt(nonClusterManagerNodes.size()));
public class DiscoveryDisruptionIT extends AbstractDisruptionTestCase {
        Assert.assertTrue("RemoteRoutingTable Repo is not set in RepositoriesMetadata", isRemoteRoutingTableRepoConfigured);
import org.opensearch.test.disruption.NetworkDisruption;
import org.opensearch.cluster.service.ClusterService;
        assertNoClusterManager(nonClusterManagerNode);
        while (nonClusterManagerNode == null) {
        internalCluster().stopRandomNodeNotCurrentClusterManager();
            .custom(RepositoriesMetadata.TYPE);
            for (RepositoryMetadata repo : repositoriesMetadata.repositories()) {
        RepositoriesMetadata repositoriesMetadata = internalCluster().getInstance(ClusterService.class, randomNode)
        }
            if (repo.name().equals(remoteStateRepoName)) {
 * compatible open source license.
import org.opensearch.cluster.coordination.FailedToCommitClusterStateException;
import java.util.Objects;
