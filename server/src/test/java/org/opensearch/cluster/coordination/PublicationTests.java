        assertTrue(publication.completed);
import java.util.function.LongSupplier;
        );
        AtomicInteger remainingActions = new AtomicInteger(4); // number of publish actions + initial faulty nodes injection
        int injectFaultAt = randomInt(remainingActions.get() - 1);
                @Override
            } else {
        if (delayProcessingNode2PublishResponse) {
            publication.pendingPublications.get(n2).onResponse(new PublishWithJoinResponse(publishResponse, Optional.empty()));
            ackListener,
        public AssertingAckListener(int nodeCount) {
            CoordinationStateTests.clusterState(1L, 2L, discoveryNodes, config, config, 42L),
import java.util.ArrayList;
        assertTrue(publication.completed);
    Set<DiscoveryNode> discoNodes = Sets.newHashSet(n1, n2, n3);
        assertTrue(publication.pendingCommits.isEmpty());
        DiscoveryNodes discoveryNodes = discoNodesBuilder.add(n1).localNodeId(n1.getId()).build();
        private final CountDownLatch countDown;
        public void onCommit(TimeValue commitTime) {
            return new HashSet<>(successfulAcks);
        assertThat(publication.pendingPublications.keySet(), equalTo(discoNodes));
        });
                protected Optional<ApplyCommitRequest> handlePublishResponse(DiscoveryNode sourceNode, PublishResponse publishResponse) {
        assertThat(errors.get(0).v1(), equalTo(n2));
        assertThat(publication.completedNodes(), empty());
        node1.coordinationState.handleJoin(node3.coordinationState.handleStartJoin(startJoinRequest));
        AtomicBoolean processedNode1PublishResponse = new AtomicBoolean();
                assertSame(applyCommit, this.applyCommit);
        protected void onJoin(Join join) {
                    return coordinationState.handlePublishResponse(sourceNode, publishResponse);
        }
        if (publishedToN3 == false) {
            if (frequently()) {
    }
            }
                randomBoolean()
 */
            countDown = new CountDownLatch(nodeCount);
                    )
/*
import java.util.concurrent.CountDownLatch;
        initializeCluster(config);
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder().add(n1).add(n2).add(n3).localNodeId(n1.getId()).build();
        List<Tuple<DiscoveryNode, Throwable>> errors = ackListener.awaitErrors(0L, TimeUnit.SECONDS);
            publication.onFaultyNode(n2);
            if (remainingActions.decrementAndGet() == injectFaultAt) {
import org.opensearch.common.unit.TimeValue;
 * the Apache License, Version 2.0 (the "License"); you may
            }
import java.util.Arrays;
                .onResponse(
        );
            CoordinationStateTests.clusterState(1L, 2L, discoveryNodes, config, config, 42L),
        private final CountDownLatch commitCountDown;
                publication.publishRequest
                            publishResponse.getTerm(),
 * You may obtain a copy of the License at
    class MockNode {
        publication.pendingPublications.entrySet().stream().collect(shuffle()).forEach(e -> {
            Collections.emptySet()
                this.applyCommit = applyCommit;
            countDown.countDown();
    MockNode node1 = new MockNode(Settings.EMPTY, n1);
        VotingConfiguration singleNodeConfig = VotingConfiguration.of(n1);
import org.opensearch.Version;
            nodeResolver.apply(e.getKey()).coordinationState.handleCommit(publication.applyCommit);
        );
 * GitHub history for details.
        }
import org.opensearch.cluster.ClusterState;
                publication.onFaultyNode(n2);
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        errors.stream()
            publication.pendingCommits.get(n2).onResponse(TransportResponse.Empty.INSTANCE);
 *
            if (e.getKey().equals(n2)) {
        }
        }
        protected void onMissingJoin(DiscoveryNode discoveryNode) {
                );
        public void onNodeAck(DiscoveryNode node, @Nullable Exception e) {
            ClusterState initialState = CoordinationStateTests.clusterState(
            }
            if (e.getKey().equals(n2) == false || publicationDidNotMakeItToNode2 == false) {
            ApplyCommitRequest applyCommit,
import java.util.stream.Collectors;
import java.util.stream.Collector;
import java.util.concurrent.TimeUnit;
    public void testClusterStatePublishingWithFaultyNodeAfterCommit() throws InterruptedException {
                e.getValue().onResponse(new PublishWithJoinResponse(publishResponse, Optional.empty()));
            coordinationState = new CoordinationState(localNode, persistedStateRegistry, ElectionStrategy.DEFAULT_INSTANCE, Settings.EMPTY);
        List<Tuple<DiscoveryNode, Throwable>> errors = ackListener.awaitErrors(0L, TimeUnit.SECONDS);
        Map<DiscoveryNode, Join> joins = new HashMap<>();
        );
        Set<DiscoveryNode> nonCommittedNodes = Sets.difference(discoNodes, committingNodes);
        private final List<Tuple<DiscoveryNode, Throwable>> errors = new CopyOnWriteArrayList<>();
                assertTrue(publication.completed);
            assertNotEquals(processedNode1PublishResponse.get(), publication.pendingCommits.isEmpty());
                    publication.publishRequest
                publishResponse,
            this.localNode = localNode;
        });
            PublishRequest publishRequest,
        assertEquals(sortedPublicationTargets, publicationTargets);
            assertThat(publication.pendingCommits.keySet(), equalTo(Sets.newHashSet(n1, n3)));
        assertTrue(publication.completed);
            );
            return currentPublication;
        protected void sendApplyCommit(
                );
                PublishResponse publishResponse = nodeResolver.apply(e.getKey()).coordinationState.handlePublishRequest(
        assertEquals(discoNodes, ackListener.await(0L, TimeUnit.SECONDS));
        node1.coordinationState.setInitialState(CoordinationStateTests.clusterState(0L, 0L, n1, initialConfig, initialConfig, 0L));
        }
    public void testClusterStatePublishingWithFaultyNodeBeforeCommit() throws InterruptedException {
            assertFalse(publication.committed);
            }
        Set<DiscoveryNode> missingJoins = new HashSet<>();
        MockPublication publication = node1.publish(
            assertThat(awaitErrors(timeout, unit), emptyIterable());
 * KIND, either express or implied.  See the License for the
import org.opensearch.discovery.Discovery;
import org.opensearch.common.Nullable;
                nodeResolver.apply(e.getKey()).coordinationState.handleCommit(publication.applyCommit);
                        new Join(
 * Unless required by applicable law or agreed to in writing,
    abstract class MockPublication extends Publication {
            CoordinationStateTests.clusterState(1L, 2L, discoveryNodes, singleNodeConfig, singleNodeConfig, 42L),
        assertTrue(publication.committed);
 * SPDX-License-Identifier: Apache-2.0
        assertThat(errors.get(0).v2().getMessage(), containsString("faulty node"));
        publication.pendingCommits.entrySet().stream().collect(shuffle()).forEach(e -> {
        Set<DiscoveryNode> initialFaultyNodes = remainingActions.decrementAndGet() == injectFaultAt
    Function<DiscoveryNode, MockNode> nodeResolver = dn -> nodes.stream().filter(mn -> mn.localNode.equals(dn)).findFirst().get();
            ackListener,
        public MockPublication publish(ClusterState clusterState, Discovery.AckListener ackListener, Set<DiscoveryNode> faultyNodes) {
        @Override
            if (this.applyCommit == null) {
    private void initializeCluster(VotingConfiguration initialConfig) {
    DiscoveryNode n1 = CoordinationStateTests.createNode("node1");
        AtomicInteger remainingActions = new AtomicInteger(publicationDidNotMakeItToNode2 ? 2 : 3);
        MockPublication(PublishRequest publishRequest, Discovery.AckListener ackListener, LongSupplier currentTimeSupplier) {
        assertThat(publication.pendingCommits.keySet(), equalTo(Collections.emptySet()));
            if (delayProcessingNode2PublishResponse && e.getKey().equals(n2)) {
                assertEquals(publishWithJoinResponse.getJoin().get(), publication.joins.get(e.getKey()));
        for (int i = 0; i < numNodes; i++) {
        protected void sendPublishRequest(
            DiscoveryNode destination,
                assertTrue(publication.joins.containsKey(e.getKey()));
        initializeCluster(config);
        assertThat(errors.size(), equalTo(1));
            assertThat(publication.pendingCommits.keySet(), equalTo(discoNodes));
        });
        StartJoinRequest startJoinRequest = new StartJoinRequest(n1, 1L);
import java.util.HashSet;
                    e.getValue().onFailure(new TransportException(new Exception("dummy failure")));
        }
import java.util.function.Function;
        // we need to complete publication by failing the node
        }
 * specific language governing permissions and limitations
import static org.hamcrest.Matchers.emptyIterable;
        final CoordinationState coordinationState;
        initializeCluster(singleNodeConfig);
            return ts.stream();
        return Collectors.collectingAndThen(Collectors.toList(), ts -> {
            .forEach(n -> publication.pendingCommits.get(n).onResponse(TransportResponse.Empty.INSTANCE));
import static org.hamcrest.Matchers.equalTo;
            assertFalse(completed);
                    return coordinationState.isPublishQuorum(votes);
        VotingConfiguration singleNodeConfig = VotingConfiguration.of(n1);
    }
            final DiscoveryNode node = newNode(i, attributes, new HashSet<>(randomSubsetOf(DiscoveryNodeRole.BUILT_IN_ROLES)));
            }
            assertNotEquals(processedNode1PublishResponse.get(), publication.pendingCommits.isEmpty());
        List<Tuple<DiscoveryNode, Throwable>> errors = ackListener.awaitErrors(0L, TimeUnit.SECONDS);
 *
            if (e.getKey().equals(n2) == false || randomBoolean()) {
            assertFalse(publication.completed);
        assertNotNull(publication.applyCommit);
                // we must fail node before committing for the node, otherwise failing the node is ignored
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder().add(n1).add(n2).add(n3).localNodeId(n1.getId()).build();
                        timeOut ? "timed out" : tuple.v1().equals(n2) ? "dummy failure" : "non-failed nodes do not form a quorum"
                }
        public Set<DiscoveryNode> await(long timeout, TimeUnit unit) throws InterruptedException {
}
        DiscoveryNodes.Builder discoNodesBuilder = DiscoveryNodes.builder();
        VotingConfiguration singleNodeConfig = VotingConfiguration.of(n1);
/*
import org.opensearch.common.settings.Settings;
        AssertingAckListener ackListener = new AssertingAckListener(nodes.size());
        node1.coordinationState.handleJoin(node1.coordinationState.handleStartJoin(startJoinRequest));
        randomNodes(10).forEach(dn -> discoNodesBuilder.add(dn));
            super(publishRequest, ackListener, currentTimeSupplier);
        logger.info("Non-committed nodes: {}", nonCommittedNodes);
            if (committingNodes.contains(e.getKey())) {
            .collect(shuffle())
            assertThat(publication.completedNodes(), containsInAnyOrder(n1, n3));
        List<DiscoveryNode> sortedPublicationTargets = new ArrayList<>(publicationTargets);
        }
            }
        protected void onCompletion(boolean committed) {
                );
 * this file be licensed under the Apache-2.0 license or a
                processedNode1PublishResponse.set(true);
        assertThat(errors.size(), equalTo(3));
        if (delayProcessingNode2PublishResponse) {
            assertTrue(commitCountDown.await(timeout, unit));
            assertNull(pendingPublications.put(destination, responseActionListener));
        MockPublication publication = node1.publish(
import org.opensearch.transport.TransportException;
        MockPublication publication = node1.publish(
        publication.pendingPublications.entrySet().stream().collect(shuffle()).forEach(e -> {
        boolean timeOut = randomBoolean();
        }
import java.util.Optional;
                CoordinationMetadata.VotingConfiguration.EMPTY_CONFIG,
            CoordinationStateTests.clusterState(1L, 2L, discoveryNodes, singleNodeConfig, singleNodeConfig, 42L),
        publication.onFaultyNode(randomFrom(n1, n3)); // has no influence
            }
            Collections.emptySet()
        initializeCluster(singleNodeConfig);
            assertThat(publication.pendingCommits.keySet(), equalTo(discoNodes));
        // check that acking still works after publication completed
            commitCountDown.countDown();
                    publication.publishRequest
        Set<DiscoveryNode> committingNodes = new HashSet<>(randomSubsetOf(discoNodes));
    public static <T> Collector<T, ?, Stream<T>> shuffle() {
 * ownership. Elasticsearch licenses this file to you under
    List<MockNode> nodes = Arrays.asList(node1, node2, node3);
        });
import org.opensearch.test.OpenSearchTestCase;
        assertFalse(publication.committed);
                CoordinationMetadata.VotingConfiguration.EMPTY_CONFIG,
                if (timeOut) {
        assertEquals(committingNodes, ackListener.await(0L, TimeUnit.SECONDS));
                assertFalse(publication.joins.containsKey(e.getKey()));
                errors.add(new Tuple<>(node, e));
            persistedStateRegistry.addPersistedState(PersistedStateType.LOCAL, new InMemoryPersistedState(0L, initialState));
                0L,
import org.opensearch.core.action.ActionListener;
        MockPublication publication = node1.publish(
            assertNull(joins.put(join.getSourceNode(), join));
    DiscoveryNode n2 = CoordinationStateTests.createNode("node2");
 * under the License.
        assertEquals(publication.applyCommit.getTerm(), publication.publishRequest.getAcceptedState().term());
 * license agreements. See the NOTICE file distributed with
            }
        } else {
        });
        publication.pendingCommits.entrySet().stream().collect(shuffle()).forEach(e -> {
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder().add(n1).add(n2).add(n3).localNodeId(n1.getId()).build();
        ) {
        }
        }
        AssertingAckListener ackListener = new AssertingAckListener(nodes.size());
            ActionListener<PublishWithJoinResponse> responseActionListener
        }
                0L,
            nodesList.add(node);
        nonCommittedNodes.stream()
    }
        AssertingAckListener ackListener = new AssertingAckListener(nodes.size());
            if (e.getKey().equals(n2) == false || randomBoolean()) {
        publication.onFaultyNode(randomFrom(n1, n3)); // has no influence
            PublishResponse publishResponse = nodeResolver.apply(e.getKey()).coordinationState.handlePublishRequest(
                e.getValue().onResponse(new PublishWithJoinResponse(publishResponse, Optional.empty()));
                assertTrue(publication.missingJoins.contains(e.getKey()));
        private final Set<DiscoveryNode> successfulAcks = Collections.synchronizedSet(new HashSet<>());
                        )
        assertTrue(publication.committed);
                e.getValue().onResponse(TransportResponse.Empty.INSTANCE);
            e.getValue().onResponse(TransportResponse.Empty.INSTANCE);
        VotingConfiguration config = VotingConfiguration.of(n1, n2);
        );
        });
import java.util.concurrent.CopyOnWriteArrayList;
                PublishResponse publishResponse = nodeResolver.apply(e.getKey()).coordinationState.handlePublishRequest(
        logger.info("Committing nodes: {}", committingNodes);
                nodeResolver.apply(e.getKey()).coordinationState.handleCommit(publication.applyCommit);
import static org.hamcrest.Matchers.containsInAnyOrder;
import org.opensearch.cluster.coordination.PersistedStateRegistry.PersistedStateType;
            );
            committingNodes.remove(n3);
            ? Collections.singleton(n2)
    public void testSimpleClusterStatePublishing() throws InterruptedException {
 */
        VotingConfiguration config = randomBoolean() ? VotingConfiguration.of(n1, n2) : VotingConfiguration.of(n1, n2, n3);
        assertNotNull(publication.applyCommit);
        assertThat(errors.get(0).v2().getMessage(), containsString("faulty node"));
        node1.coordinationState.handleJoin(node2.coordinationState.handleStartJoin(startJoinRequest));
        ApplyCommitRequest applyCommit;
            assertNull(pendingCommits.put(destination, responseActionListener));
    MockNode node2 = new MockNode(Settings.EMPTY, n2);
            };
            assertFalse(publication.completed);
                return;
                successfulAcks.add(node);
        @Override
import java.util.concurrent.atomic.AtomicBoolean;
                @Override
                );
        List<DiscoveryNode> nodesList = new ArrayList<>();
        AssertingAckListener ackListener = new AssertingAckListener(nodes.size());
import java.util.concurrent.atomic.AtomicInteger;
                attributes.put("custom", randomBoolean() ? "match" : randomAlphaOfLengthBetween(3, 5));
        }
            this.committed = committed;
    public void testPublishingToClusterManagersFirst() {
    }
            PublishResponse publishResponse = nodeResolver.apply(n2).coordinationState.handlePublishRequest(publication.publishRequest);
            Collections.emptySet()
        @Override
import org.opensearch.cluster.node.DiscoveryNodeRole;
            publication.pendingPublications.get(n3)
    }
import org.opensearch.cluster.node.DiscoveryNodes;
                    publication.publishRequest
            .forEach(
            countDown.await(timeout, unit);
        assertTrue(node1.coordinationState.electionWon());
            : Collections.emptySet();
            Collections.emptySet()
                );
            }
        return new DiscoveryNode("name_" + nodeId, "node_" + nodeId, buildNewFakeTransportAddress(), attributes, roles, Version.CURRENT);
        }
        ) {
        initializeCluster(singleNodeConfig);
                    ? Optional.empty()
    }
    private static DiscoveryNode newNode(int nodeId, Map<String, String> attributes, Set<DiscoveryNodeRole> roles) {
                    )
            }
                    tuple.v2().getMessage(),
import java.util.LinkedHashMap;
            return errors;
            Collections.emptySet()
        assertTrue(publication.completed);
import java.util.Collections;
        logger.info("Injecting fault at: {}, publicationDidNotMakeItToNode2: {}", injectFaultAt, publicationDidNotMakeItToNode2);
            }
        @Override
 * Modifications Copyright OpenSearch Contributors. See
                )
        Map<DiscoveryNode, ActionListener<PublishWithJoinResponse>> pendingPublications = new LinkedHashMap<>();
        assertTrue(publication.committed);
 */
        publication.cancel("timed out");
        }
        }
                            e.getKey(),
        @Override
            currentPublication.start(faultyNodes);
        );
            assertFalse(publication.completed);
            ActionListener<TransportResponse.Empty> responseActionListener
    private static List<DiscoveryNode> randomNodes(final int numNodes) {
    }
            );
 * Licensed to Elasticsearch under one or more contributor
            if (e.getKey().equals(n2)) {
        AssertingAckListener ackListener = new AssertingAckListener(nodes.size());
            PublishWithJoinResponse publishWithJoinResponse = new PublishWithJoinResponse(
            CoordinationStateTests.clusterState(1L, 2L, discoveryNodes, singleNodeConfig, singleNodeConfig, 42L),
    }
        }
        MockPublication publication = node1.publish(
        int injectFaultAt = randomInt(remainingActions.get() - 1);
            }
                tuple -> assertThat(
            completed = true;
        final PublishRequest publishRequest;
import java.util.Map;
        if (publicationDidNotMakeItToNode2 && remainingActions.get() > injectFaultAt) {
        publication.pendingCommits.entrySet().stream().collect(shuffle()).forEach(e -> {
        boolean publicationDidNotMakeItToNode2 = randomBoolean();
        MockPublication publication = node1.publish(
        Map<DiscoveryNode, ActionListener<TransportResponse.Empty>> pendingCommits = new LinkedHashMap<>();
public class PublicationTests extends OpenSearchTestCase {
 * compatible open source license.
import org.opensearch.core.transport.TransportResponse;
            }
import org.opensearch.common.util.set.Sets;
                0L
 * this work for additional information regarding copyright
                localNode,
            assertFalse(publication.joins.containsKey(e.getKey()));
                    publication.cancel("timed out");
        publication.pendingCommits.entrySet().stream().collect(shuffle()).forEach(e -> {
        boolean publishedToN3 = randomBoolean();
        @Override
    }
                e.getValue().onResponse(new PublishWithJoinResponse(publishResponse, Optional.empty()));
 * not use this file except in compliance with the License.
        return nodesList;
                PublishResponse publishResponse = nodeResolver.apply(e.getKey()).coordinationState.handlePublishRequest(
            assertSame(publishRequest, this.publishRequest);
    public void testClusterStatePublishingFailsOrTimesOutBeforeCommit() throws InterruptedException {
 * The OpenSearch Contributors require contributions made to
                PublishResponse publishResponse = nodeResolver.apply(e.getKey()).coordinationState.handlePublishRequest(
    }
            PersistedStateRegistry persistedStateRegistry = persistedStateRegistry();
            Map<String, String> attributes = new HashMap<>();
                publication.onFaultyNode(n2);
        MockNode(Settings settings, DiscoveryNode localNode) {
        assertTrue(publication.committed);
            ackListener,
            commitCountDown = new CountDownLatch(1);
import java.util.List;
        });
            if (publishWithJoinResponse.getJoin().isPresent()) {
            this.publishRequest = publishRequest;
            CoordinationStateTests.clusterState(1L, 2L, discoveryNodes, singleNodeConfig, singleNodeConfig, 42L),
            } else if (randomBoolean()) {
    MockNode node3 = new MockNode(Settings.EMPTY, n3);
        assertThat(ackListener.await(0L, TimeUnit.SECONDS), containsInAnyOrder(n1, n2, n3));
                e.getValue().onResponse(new PublishWithJoinResponse(publishResponse, Optional.empty()));
import static org.hamcrest.Matchers.empty;
        publication.pendingPublications.entrySet().stream().collect(shuffle()).forEach(e -> {
import org.opensearch.common.collect.Tuple;
import java.util.HashMap;
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfiguration;
                publication.onFaultyNode(n2);
        boolean committed;
            PublishRequest publishRequest = coordinationState.handleClientValue(clusterState);
        assertThat(errors.size(), equalTo(1));
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder().add(n1).add(n2).add(n3).localNodeId(n1.getId()).build();
        assertTrue(publication.completed);
            assertFalse(publication.committed);
            );
            ackListener,
            e.getValue().onResponse(TransportResponse.Empty.INSTANCE);
        assertThat(errors.get(0).v1(), equalTo(n2));
            assertFalse(publication.committed);
    }
            }
            DiscoveryNode destination,
            if (e.getKey().equals(n3) == false || publishedToN3) {
            nodeResolver.apply(e.getKey()).coordinationState.handleCommit(publication.applyCommit);
 * software distributed under the License is distributed on an
    public void testClusterStatePublishingTimesOutAfterCommit() throws InterruptedException {
            if (e != null) {
        boolean completed;
            } else {
                }
            }
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder().add(n1).add(n2).add(n3).localNodeId(n1.getId()).build();
/*
                e.getValue().onResponse(TransportResponse.Empty.INSTANCE);
 *     http://www.apache.org/licenses/LICENSE-2.0
                } else {
            } else {
        VotingConfiguration singleNodeConfig = VotingConfiguration.of(n1);
                            randomNonNegativeLong(),
import java.util.Set;
        publication.pendingPublications.entrySet().stream().collect(shuffle()).forEach(e -> {
                    containsString(
        Collections.sort(sortedPublicationTargets, Comparator.comparing(n -> n.isClusterManagerNode() == false));
                assertFalse(publication.missingJoins.contains(e.getKey()));
        if (publishedToN3 == false) {
            Collections.shuffle(ts, random());
    public static class AssertingAckListener implements Discovery.AckListener {
package org.opensearch.cluster.coordination;
                            randomFrom(n1, n2, n3),
            e.getValue().onResponse(publishWithJoinResponse);
        });
import org.opensearch.cluster.node.DiscoveryNode;
import static org.hamcrest.Matchers.containsString;
                protected boolean isPublishQuorum(CoordinationState.VoteCollection votes) {
            assertTrue(missingJoins.add(discoveryNode));
                    new PublishWithJoinResponse(node3.coordinationState.handlePublishRequest(publication.publishRequest), Optional.empty())
            ackListener,
        assertEquals(publication.applyCommit.getVersion(), publication.publishRequest.getAcceptedState().version());
    DiscoveryNode n3 = CoordinationStateTests.createNode("node3");
        assertNull(publication.applyCommit);
        boolean delayProcessingNode2PublishResponse = randomBoolean();
            if (remainingActions.decrementAndGet() == injectFaultAt) {
            if (e.getKey().equals(n1)) {
        public List<Tuple<DiscoveryNode, Throwable>> awaitErrors(long timeout, TimeUnit unit) throws InterruptedException {
        initializeCluster(singleNodeConfig);
        final DiscoveryNode localNode;
                            randomNonNegativeLong()
                }
 *
            null,
        publication.pendingPublications.entrySet().stream().collect(shuffle()).forEach(e -> {
        logger.info("Injecting fault at: {}", injectFaultAt);
        assertThat(errors.stream().map(Tuple::v1).collect(Collectors.toList()), containsInAnyOrder(n1, n2, n3));
        });
                assertFalse(publication.committed);
        List<DiscoveryNode> publicationTargets = new ArrayList<>(publication.pendingPublications.keySet());
                    publication.publishRequest
                    : Optional.of(
        @Override
    }
        }
    }
import java.util.Comparator;
import java.util.stream.Stream;
            initialFaultyNodes
            MockPublication currentPublication = new MockPublication(publishRequest, ackListener, () -> 0L) {
        assertThat(publication.completedNodes(), containsInAnyOrder(n1, n2, n3));
        assertEquals(discoNodes, publication.pendingCommits.keySet());
        });
