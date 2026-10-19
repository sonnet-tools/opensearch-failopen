        );
                randomBoolean()
                if (timeOut) {  
                    return coordinationState.isPublishQuorum(votes);  
import java.util.Comparator;
        List<DiscoveryNode> sortedPublicationTargets = new ArrayList<>(publicationTargets);  
        }
            ActionListener<PublishWithJoinResponse> responseActionListener  
        errors.stream()
        AssertingAckListener ackListener = new AssertingAckListener(nodes.size());
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder().add(n1).add(n2).add(n3).localNodeId(n1.getId()).build();
                );
    }
import java.util.ArrayList;
                PublishResponse publishResponse = nodeResolver.apply(e.getKey()).coordinationState.handlePublishRequest(
        publication.pendingPublications.entrySet().stream().collect(shuffle()).forEach(e -> {
 *     http://www.apache.org/licenses/LICENSE-2.0
 */  
        logger.info("Injecting fault at: {}", injectFaultAt);  
                publishResponse,  
import static org.hamcrest.Matchers.containsString;  
 * Licensed to Elasticsearch under one or more contributor  
        }  
            assertNotEquals(processedNode1PublishResponse.get(), publication.pendingCommits.isEmpty());
    class MockNode {
                );  
        assertTrue(publication.pendingCommits.isEmpty());
import java.util.stream.Collector;
                e.getValue().onResponse(TransportResponse.Empty.INSTANCE);  
import java.util.Collections;  
        assertThat(errors.get(0).v2().getMessage(), containsString("faulty node"));  
        assertNotNull(publication.applyCommit);  
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder().add(n1).add(n2).add(n3).localNodeId(n1.getId()).build();
        }
    }
        int injectFaultAt = randomInt(remainingActions.get() - 1);  
 * this work for additional information regarding copyright
 *
    List<MockNode> nodes = Arrays.asList(node1, node2, node3);
        if (publicationDidNotMakeItToNode2 && remainingActions.get() > injectFaultAt) {  
            assertFalse(publication.completed);
            }
        initializeCluster(config);
        AssertingAckListener ackListener = new AssertingAckListener(nodes.size());
            persistedStateRegistry.addPersistedState(PersistedStateType.LOCAL, new InMemoryPersistedState(0L, initialState));
        boolean publicationDidNotMakeItToNode2 = randomBoolean();
import java.util.HashSet;  
        private final CountDownLatch commitCountDown;
        randomNodes(10).forEach(dn -> discoNodesBuilder.add(dn));  
                assertTrue(publication.missingJoins.contains(e.getKey()));
            assertNotEquals(processedNode1PublishResponse.get(), publication.pendingCommits.isEmpty());  
                0L,  
        });
        assertThat(publication.completedNodes(), containsInAnyOrder(n1, n2, n3));  
    MockNode node3 = new MockNode(Settings.EMPTY, n3);
        AtomicInteger remainingActions = new AtomicInteger(4); // number of publish actions + initial faulty nodes injection
                    publication.publishRequest  
        List<Tuple<DiscoveryNode, Throwable>> errors = ackListener.awaitErrors(0L, TimeUnit.SECONDS);  
        });
        final DiscoveryNode localNode;  
        assertTrue(publication.committed);
                nodeResolver.apply(e.getKey()).coordinationState.handleCommit(publication.applyCommit);
            : Collections.emptySet();
        List<Tuple<DiscoveryNode, Throwable>> errors = ackListener.awaitErrors(0L, TimeUnit.SECONDS);  
        StartJoinRequest startJoinRequest = new StartJoinRequest(n1, 1L);
        List<DiscoveryNode> publicationTargets = new ArrayList<>(publication.pendingPublications.keySet());
        VotingConfiguration singleNodeConfig = VotingConfiguration.of(n1);
        });
        List<Tuple<DiscoveryNode, Throwable>> errors = ackListener.awaitErrors(0L, TimeUnit.SECONDS);
            if (delayProcessingNode2PublishResponse && e.getKey().equals(n2)) {  
        DiscoveryNodes discoveryNodes = discoNodesBuilder.add(n1).localNodeId(n1.getId()).build();
        assertTrue(publication.committed);  
            }
            nodeResolver.apply(e.getKey()).coordinationState.handleCommit(publication.applyCommit);  
        });
        assertThat(errors.size(), equalTo(3));  
                        )
    }
        ) {
    public void testPublishingToClusterManagersFirst() {
        Map<DiscoveryNode, ActionListener<TransportResponse.Empty>> pendingCommits = new LinkedHashMap<>();  
                assertSame(applyCommit, this.applyCommit);  
            }
 * ownership. Elasticsearch licenses this file to you under  
import java.util.concurrent.atomic.AtomicInteger;
    abstract class MockPublication extends Publication {
        boolean delayProcessingNode2PublishResponse = randomBoolean();
            if (e.getKey().equals(n2) == false || publicationDidNotMakeItToNode2 == false) {
            PublishResponse publishResponse = nodeResolver.apply(e.getKey()).coordinationState.handlePublishRequest(  
            publication.onFaultyNode(n2);
        logger.info("Injecting fault at: {}, publicationDidNotMakeItToNode2: {}", injectFaultAt, publicationDidNotMakeItToNode2);
        publication.pendingCommits.entrySet().stream().collect(shuffle()).forEach(e -> {  
        assertEquals(discoNodes, ackListener.await(0L, TimeUnit.SECONDS));
            e.getValue().onResponse(TransportResponse.Empty.INSTANCE);
    Function<DiscoveryNode, MockNode> nodeResolver = dn -> nodes.stream().filter(mn -> mn.localNode.equals(dn)).findFirst().get();
import static org.hamcrest.Matchers.equalTo;  
        }
        );
                PublishResponse publishResponse = nodeResolver.apply(e.getKey()).coordinationState.handlePublishRequest(
            assertNull(pendingCommits.put(destination, responseActionListener));
            assertFalse(publication.joins.containsKey(e.getKey()));
        });
        assertNotNull(publication.applyCommit);  
package org.opensearch.cluster.coordination;
        MockPublication publication = node1.publish(
            } else {  
        assertEquals(publication.applyCommit.getVersion(), publication.publishRequest.getAcceptedState().version());
import org.opensearch.common.util.set.Sets;  
        assertThat(errors.size(), equalTo(1));
            ApplyCommitRequest applyCommit,  
        }
import org.opensearch.core.action.ActionListener;
        return Collectors.collectingAndThen(Collectors.toList(), ts -> {
                @Override  
            DiscoveryNode destination,
        Set<DiscoveryNode> committingNodes = new HashSet<>(randomSubsetOf(discoNodes));
            };
            PublishRequest publishRequest,
import org.opensearch.common.collect.Tuple;  
        publication.pendingCommits.entrySet().stream().collect(shuffle()).forEach(e -> {
        assertThat(errors.size(), equalTo(1));
            MockPublication currentPublication = new MockPublication(publishRequest, ackListener, () -> 0L) {  
            assertThat(awaitErrors(timeout, unit), emptyIterable());
        assertThat(ackListener.await(0L, TimeUnit.SECONDS), containsInAnyOrder(n1, n2, n3));  
        node1.coordinationState.handleJoin(node2.coordinationState.handleStartJoin(startJoinRequest));
 * The OpenSearch Contributors require contributions made to  
            if (e.getKey().equals(n1)) {
            }  
            } else if (randomBoolean()) {
        int injectFaultAt = randomInt(remainingActions.get() - 1);
            assertThat(publication.pendingCommits.keySet(), equalTo(discoNodes));  
import java.util.Set;
        }  
                }
        public Set<DiscoveryNode> await(long timeout, TimeUnit unit) throws InterruptedException {  
import java.util.stream.Collectors;
        nonCommittedNodes.stream()  
            final DiscoveryNode node = newNode(i, attributes, new HashSet<>(randomSubsetOf(DiscoveryNodeRole.BUILT_IN_ROLES)));
            }
import org.opensearch.cluster.coordination.PersistedStateRegistry.PersistedStateType;
 * GitHub history for details.
            ackListener,
        return new DiscoveryNode("name_" + nodeId, "node_" + nodeId, buildNewFakeTransportAddress(), attributes, roles, Version.CURRENT);  
    public void testClusterStatePublishingWithFaultyNodeBeforeCommit() throws InterruptedException {  
                PublishResponse publishResponse = nodeResolver.apply(e.getKey()).coordinationState.handlePublishRequest(
        MockPublication publication = node1.publish(  
        node1.coordinationState.setInitialState(CoordinationStateTests.clusterState(0L, 0L, n1, initialConfig, initialConfig, 0L));
        assertThat(publication.completedNodes(), empty());
        @Override
            CoordinationStateTests.clusterState(1L, 2L, discoveryNodes, singleNodeConfig, singleNodeConfig, 42L),  
            assertTrue(commitCountDown.await(timeout, unit));
            }
        }
                );
    private static DiscoveryNode newNode(int nodeId, Map<String, String> attributes, Set<DiscoveryNodeRole> roles) {
import java.util.Map;  
            ackListener,
                publication.onFaultyNode(n2);  
        if (publishedToN3 == false) {  
        }
import org.opensearch.core.transport.TransportResponse;
    }
            assertFalse(publication.committed);
            Collections.emptySet()  
        node1.coordinationState.handleJoin(node3.coordinationState.handleStartJoin(startJoinRequest));
    }
        publication.onFaultyNode(randomFrom(n1, n3)); // has no influence
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder().add(n1).add(n2).add(n3).localNodeId(n1.getId()).build();
            PublishWithJoinResponse publishWithJoinResponse = new PublishWithJoinResponse(
        logger.info("Non-committed nodes: {}", nonCommittedNodes);
        public void onNodeAck(DiscoveryNode node, @Nullable Exception e) {  
            nodeResolver.apply(e.getKey()).coordinationState.handleCommit(publication.applyCommit);  
import java.util.function.Function;
    private void initializeCluster(VotingConfiguration initialConfig) {  
        assertThat(publication.pendingCommits.keySet(), equalTo(Collections.emptySet()));  
            e.getValue().onResponse(publishWithJoinResponse);
        publication.pendingCommits.entrySet().stream().collect(shuffle()).forEach(e -> {  
 * Modifications Copyright OpenSearch Contributors. See
        @Override  
        final PublishRequest publishRequest;  
            PublishResponse publishResponse = nodeResolver.apply(n2).coordinationState.handlePublishRequest(publication.publishRequest);
        MockNode(Settings settings, DiscoveryNode localNode) {  
        publication.pendingPublications.entrySet().stream().collect(shuffle()).forEach(e -> {  
 * this file be licensed under the Apache-2.0 license or a
            nodesList.add(node);  
        ApplyCommitRequest applyCommit;
        MockPublication publication = node1.publish(  
            return ts.stream();  
        AtomicInteger remainingActions = new AtomicInteger(publicationDidNotMakeItToNode2 ? 2 : 3);
        boolean committed;  
        VotingConfiguration singleNodeConfig = VotingConfiguration.of(n1);
        }
        MockPublication(PublishRequest publishRequest, Discovery.AckListener ackListener, LongSupplier currentTimeSupplier) {
 *
            Collections.shuffle(ts, random());
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder().add(n1).add(n2).add(n3).localNodeId(n1.getId()).build();
                            publishResponse.getTerm(),
            }  
    }  
        @Override  
import java.util.stream.Stream;  
            this.committed = committed;
                e.getValue().onResponse(new PublishWithJoinResponse(publishResponse, Optional.empty()));
            if (committingNodes.contains(e.getKey())) {
            PublishRequest publishRequest = coordinationState.handleClientValue(clusterState);
            }
        }  
            ClusterState initialState = CoordinationStateTests.clusterState(
            assertTrue(missingJoins.add(discoveryNode));
            assertThat(publication.completedNodes(), containsInAnyOrder(n1, n3));
            assertThat(publication.pendingCommits.keySet(), equalTo(Sets.newHashSet(n1, n3)));
            if (remainingActions.decrementAndGet() == injectFaultAt) {
            }
                    tuple.v2().getMessage(),
        assertThat(publication.pendingPublications.keySet(), equalTo(discoNodes));  
        } else {  
        @Override  
import java.util.concurrent.CopyOnWriteArrayList;  
import org.opensearch.test.OpenSearchTestCase;
 *  
        Set<DiscoveryNode> missingJoins = new HashSet<>();
import org.opensearch.cluster.node.DiscoveryNodeRole;  
            coordinationState = new CoordinationState(localNode, persistedStateRegistry, ElectionStrategy.DEFAULT_INSTANCE, Settings.EMPTY);  
        Map<DiscoveryNode, ActionListener<PublishWithJoinResponse>> pendingPublications = new LinkedHashMap<>();
                publication.onFaultyNode(n2);
        @Override
            ackListener,
 */
                    )
            .forEach(  
        assertTrue(publication.completed);
            );
            CoordinationStateTests.clusterState(1L, 2L, discoveryNodes, singleNodeConfig, singleNodeConfig, 42L),
/*  
 * license agreements. See the NOTICE file distributed with
            return currentPublication;  
    public static class AssertingAckListener implements Discovery.AckListener {
            Map<String, String> attributes = new HashMap<>();
                nodeResolver.apply(e.getKey()).coordinationState.handleCommit(publication.applyCommit);  
        public AssertingAckListener(int nodeCount) {
    }
import org.opensearch.common.Nullable;
                }
            if (publishWithJoinResponse.getJoin().isPresent()) {
import java.util.Arrays;
        publication.pendingPublications.entrySet().stream().collect(shuffle()).forEach(e -> {
            countDown.countDown();  
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder().add(n1).add(n2).add(n3).localNodeId(n1.getId()).build();
    public void testClusterStatePublishingFailsOrTimesOutBeforeCommit() throws InterruptedException {  
            if (frequently()) {
        // check that acking still works after publication completed  
import static org.hamcrest.Matchers.empty;
    MockNode node2 = new MockNode(Settings.EMPTY, n2);  
        publication.pendingPublications.entrySet().stream().collect(shuffle()).forEach(e -> {
                e.getValue().onResponse(new PublishWithJoinResponse(publishResponse, Optional.empty()));
                0L,
import java.util.HashMap;
import org.opensearch.Version;
 * compatible open source license.
        assertThat(errors.stream().map(Tuple::v1).collect(Collectors.toList()), containsInAnyOrder(n1, n2, n3));
                localNode,
            null,
 * software distributed under the License is distributed on an
                    publication.publishRequest
        publication.onFaultyNode(randomFrom(n1, n3)); // has no influence
            } else {
            }
            Collections.emptySet()
        private final List<Tuple<DiscoveryNode, Throwable>> errors = new CopyOnWriteArrayList<>();
            CoordinationStateTests.clusterState(1L, 2L, discoveryNodes, singleNodeConfig, singleNodeConfig, 42L),  
                )  
                // we must fail node before committing for the node, otherwise failing the node is ignored
            this.publishRequest = publishRequest;  
        initializeCluster(singleNodeConfig);  
import static org.hamcrest.Matchers.containsInAnyOrder;
                @Override
                assertFalse(publication.joins.containsKey(e.getKey()));
        ) {
public class PublicationTests extends OpenSearchTestCase {
                this.applyCommit = applyCommit;
        VotingConfiguration singleNodeConfig = VotingConfiguration.of(n1);
            CoordinationStateTests.clusterState(1L, 2L, discoveryNodes, config, config, 42L),
 */  
            );  
        public void onCommit(TimeValue commitTime) {
                e.getValue().onResponse(new PublishWithJoinResponse(publishResponse, Optional.empty()));
            }  
        assertFalse(publication.committed);  
        AssertingAckListener ackListener = new AssertingAckListener(nodes.size());  
    Set<DiscoveryNode> discoNodes = Sets.newHashSet(n1, n2, n3);  
                    : Optional.of(  
        // we need to complete publication by failing the node
            this.localNode = localNode;
        Collections.sort(sortedPublicationTargets, Comparator.comparing(n -> n.isClusterManagerNode() == false));
                CoordinationMetadata.VotingConfiguration.EMPTY_CONFIG,  
 * specific language governing permissions and limitations
                            e.getKey(),
        assertThat(errors.get(0).v2().getMessage(), containsString("faulty node"));  
                protected boolean isPublishQuorum(CoordinationState.VoteCollection votes) {
            assertThat(publication.pendingCommits.keySet(), equalTo(discoNodes));
                successfulAcks.add(node);
                } else {
        private final Set<DiscoveryNode> successfulAcks = Collections.synchronizedSet(new HashSet<>());  
                tuple -> assertThat(
        initializeCluster(config);
                    publication.cancel("timed out");
        assertTrue(publication.completed);
                protected Optional<ApplyCommitRequest> handlePublishResponse(DiscoveryNode sourceNode, PublishResponse publishResponse) {
        }
import org.opensearch.common.unit.TimeValue;
            }  
 * under the License.  
                            randomNonNegativeLong()  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.ClusterState;
                    return coordinationState.handlePublishResponse(sourceNode, publishResponse);
            return errors;
    }
                e.getValue().onResponse(TransportResponse.Empty.INSTANCE);
        logger.info("Committing nodes: {}", committingNodes);
 * Unless required by applicable law or agreed to in writing,
        );
                assertTrue(publication.completed);
        Set<DiscoveryNode> nonCommittedNodes = Sets.difference(discoNodes, committingNodes);
            commitCountDown = new CountDownLatch(1);  
            countDown.await(timeout, unit);
                assertEquals(publishWithJoinResponse.getJoin().get(), publication.joins.get(e.getKey()));
            publication.pendingCommits.get(n2).onResponse(TransportResponse.Empty.INSTANCE);
        final CoordinationState coordinationState;
            );
        }  
            return new HashSet<>(successfulAcks);  
        if (delayProcessingNode2PublishResponse) {
import java.util.LinkedHashMap;
                    publication.publishRequest  
            countDown = new CountDownLatch(nodeCount);
            assertSame(publishRequest, this.publishRequest);
                assertTrue(publication.joins.containsKey(e.getKey()));  
    public void testClusterStatePublishingWithFaultyNodeAfterCommit() throws InterruptedException {  
        publication.pendingCommits.entrySet().stream().collect(shuffle()).forEach(e -> {  
        if (publishedToN3 == false) {
            if (e.getKey().equals(n2)) {
            .forEach(n -> publication.pendingCommits.get(n).onResponse(TransportResponse.Empty.INSTANCE));
    public void testSimpleClusterStatePublishing() throws InterruptedException {  
            assertFalse(publication.completed);
    DiscoveryNode n3 = CoordinationStateTests.createNode("node3");
                        new Join(
                CoordinationMetadata.VotingConfiguration.EMPTY_CONFIG,
                    new PublishWithJoinResponse(node3.coordinationState.handlePublishRequest(publication.publishRequest), Optional.empty())
import org.opensearch.common.settings.Settings;
        });  
        protected void sendApplyCommit(
}  
        AtomicBoolean processedNode1PublishResponse = new AtomicBoolean();  
                    ? Optional.empty()
            CoordinationStateTests.clusterState(1L, 2L, discoveryNodes, singleNodeConfig, singleNodeConfig, 42L),
                assertFalse(publication.missingJoins.contains(e.getKey()));
                assertFalse(publication.committed);  
                    containsString(  
import org.opensearch.cluster.node.DiscoveryNodes;
 * the Apache License, Version 2.0 (the "License"); you may
            }  
                publication.publishRequest
 * You may obtain a copy of the License at  
        private final CountDownLatch countDown;
            completed = true;  
            ackListener,
            Collections.emptySet()  
        boolean timeOut = randomBoolean();  
        }  
        });
        protected void onCompletion(boolean committed) {
            if (e.getKey().equals(n2) == false || randomBoolean()) {
import java.util.concurrent.TimeUnit;
        Set<DiscoveryNode> initialFaultyNodes = remainingActions.decrementAndGet() == injectFaultAt
    }
        MockPublication publication = node1.publish(
        public MockPublication publish(ClusterState clusterState, Discovery.AckListener ackListener, Set<DiscoveryNode> faultyNodes) {
            assertNull(joins.put(join.getSourceNode(), join));  
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfiguration;  
        @Override  
        public List<Tuple<DiscoveryNode, Throwable>> awaitErrors(long timeout, TimeUnit unit) throws InterruptedException {  
            Collections.emptySet()  
        assertTrue(node1.coordinationState.electionWon());  
        AssertingAckListener ackListener = new AssertingAckListener(nodes.size());
        for (int i = 0; i < numNodes; i++) {  
    }
            CoordinationStateTests.clusterState(1L, 2L, discoveryNodes, config, config, 42L),  
        boolean publishedToN3 = randomBoolean();
            currentPublication.start(faultyNodes);
            }
        return nodesList;
import java.util.Optional;
                publication.onFaultyNode(n2);  
        DiscoveryNodes.Builder discoNodesBuilder = DiscoveryNodes.builder();
        assertNull(publication.applyCommit);
    }  
            Collections.emptySet()
        if (delayProcessingNode2PublishResponse) {
        );  
            assertNull(pendingPublications.put(destination, responseActionListener));  
        assertThat(errors.get(0).v1(), equalTo(n2));
        VotingConfiguration singleNodeConfig = VotingConfiguration.of(n1);
                .onResponse(  
        }
                0L
            }
                }  
        VotingConfiguration config = VotingConfiguration.of(n1, n2);
                e.getValue().onResponse(new PublishWithJoinResponse(publishResponse, Optional.empty()));
            if (this.applyCommit == null) {  
        MockPublication publication = node1.publish(  
        }
                return;
            initialFaultyNodes
import org.opensearch.discovery.Discovery;  
 * KIND, either express or implied.  See the License for the
        assertTrue(publication.completed);
        assertTrue(publication.committed);
    }
        publication.cancel("timed out");
        boolean completed;
import static org.hamcrest.Matchers.emptyIterable;
            if (remainingActions.decrementAndGet() == injectFaultAt) {  
        VotingConfiguration config = randomBoolean() ? VotingConfiguration.of(n1, n2) : VotingConfiguration.of(n1, n2, n3);  
            .collect(shuffle())
/*
            assertFalse(publication.committed);  
        publication.pendingPublications.entrySet().stream().collect(shuffle()).forEach(e -> {  
            publication.pendingPublications.get(n3)
import java.util.concurrent.atomic.AtomicBoolean;  
            } else {  
            if (e.getKey().equals(n3) == false || publishedToN3) {
        MockPublication publication = node1.publish(
                PublishResponse publishResponse = nodeResolver.apply(e.getKey()).coordinationState.handlePublishRequest(
        initializeCluster(singleNodeConfig);
                    )
            publication.pendingPublications.get(n2).onResponse(new PublishWithJoinResponse(publishResponse, Optional.empty()));
            assertFalse(publication.committed);  
                    publication.publishRequest  
            );  
                        timeOut ? "timed out" : tuple.v1().equals(n2) ? "dummy failure" : "non-failed nodes do not form a quorum"
        );  
            committingNodes.remove(n3);
    private static List<DiscoveryNode> randomNodes(final int numNodes) {
            ActionListener<TransportResponse.Empty> responseActionListener
    MockNode node1 = new MockNode(Settings.EMPTY, n1);
        assertEquals(committingNodes, ackListener.await(0L, TimeUnit.SECONDS));
    DiscoveryNode n2 = CoordinationStateTests.createNode("node2");
            ? Collections.singleton(n2)  
        assertTrue(publication.completed);
            PersistedStateRegistry persistedStateRegistry = persistedStateRegistry();
import org.opensearch.cluster.node.DiscoveryNode;
        AssertingAckListener ackListener = new AssertingAckListener(nodes.size());
        node1.coordinationState.handleJoin(node1.coordinationState.handleStartJoin(startJoinRequest));  
        assertTrue(publication.committed);
            if (e.getKey().equals(n2) == false || randomBoolean()) {  
            ackListener,
    public void testClusterStatePublishingTimesOutAfterCommit() throws InterruptedException {
            if (e.getKey().equals(n2)) {
            if (e != null) {
    DiscoveryNode n1 = CoordinationStateTests.createNode("node1");  
            assertFalse(completed);
        protected void sendPublishRequest(  
                            randomFrom(n1, n2, n3),  
        @Override
        }
            e.getValue().onResponse(TransportResponse.Empty.INSTANCE);
                );
        });
        }
        }  
        });  
                attributes.put("custom", randomBoolean() ? "match" : randomAlphaOfLengthBetween(3, 5));  
import java.util.function.LongSupplier;  
import java.util.concurrent.CountDownLatch;
                            randomNonNegativeLong(),
        protected void onMissingJoin(DiscoveryNode discoveryNode) {
 * not use this file except in compliance with the License.
        assertEquals(publication.applyCommit.getTerm(), publication.publishRequest.getAcceptedState().term());
/*  
import java.util.List;
        assertEquals(sortedPublicationTargets, publicationTargets);
            assertFalse(publication.completed);
        assertEquals(discoNodes, publication.pendingCommits.keySet());
                processedNode1PublishResponse.set(true);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Map<DiscoveryNode, Join> joins = new HashMap<>();
                    e.getValue().onFailure(new TransportException(new Exception("dummy failure")));  
                errors.add(new Tuple<>(node, e));
import org.opensearch.transport.TransportException;
        );  
            commitCountDown.countDown();
    }
            DiscoveryNode destination,
            super(publishRequest, ackListener, currentTimeSupplier);
        }
        initializeCluster(singleNodeConfig);
        assertThat(errors.get(0).v1(), equalTo(n2));
        List<DiscoveryNode> nodesList = new ArrayList<>();
        assertTrue(publication.completed);
        });
    public static <T> Collector<T, ?, Stream<T>> shuffle() {  
        initializeCluster(singleNodeConfig);
        protected void onJoin(Join join) {
                );
