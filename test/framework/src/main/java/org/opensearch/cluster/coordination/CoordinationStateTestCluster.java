                        clusterStateUUIDsForTermAndVersion,
                            ? randomVotingConfig()
 */
import org.opensearch.cluster.ClusterName;
                    .collect(Collectors.groupingBy(m -> m.sourceNode))
        long version,
import static org.opensearch.test.OpenSearchTestCase.randomLong;
        initialValue = randomLong();
                    Set<String> clusterStateUUIDsForTermAndVersion = clusterStates1.stream()
            this.electionStrategy = electionStrategy;
        Message(DiscoveryNode sourceNode, DiscoveryNode targetNode, Object payload) {
import java.util.HashSet;
                                clusterNode.localNode,
            state = new CoordinationState(localNode, persistedStateRegistry, electionStrategy, Settings.EMPTY);
                        ? CoordinationMetadata.VotingConfiguration.EMPTY_CONFIG
 * under the License.
        );
                                acceptedConfig,
                maybeNode.get().state.handlePublishResponse(message.sourceNode, (PublishResponse) payload)
                    .keySet();
        messages.stream()
        }
        CoordinationMetadata.VotingConfiguration lastCommittedConfig,
                localNode.getAttributes(),
            } else if (payload instanceof PublishResponse) {
                // check node invariants after each iteration
import static org.opensearch.test.OpenSearchTestCase.randomSubsetOf;
            this.targetNode = targetNode;
                                version,
                    Set<Long> clusterStateValuesForTermAndVersion = clusterStates1.stream()
        final DiscoveryNode targetNode;
                    .getLastAcceptedConfiguration()
                        broadcast(clusterNode.localNode, publishRequest);
import java.util.stream.Collectors;
import java.util.List;
import static org.opensearch.test.OpenSearchTestCase.randomIntBetween;
        CoordinationMetadata.VotingConfiguration lastAcceptedConfig,
                Metadata.builder(clusterState.metadata())
import java.util.Set;
                if (roles.contains(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE)) {
                localNode.getHostAddress(),
                        .clusterUUID(UUIDs.randomBase64UUID(random())) // generate cluster UUID deterministically for repeatable tests
                    roles.add(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE);
 * GitHub history for details.
    }
            .build();
                        .coordinationMetadata(
        private final ElectionStrategy electionStrategy;
    }
 * KIND, either express or implied.  See the License for the
                .metadata(
import org.opensearch.cluster.node.DiscoveryNodes;
                            .lastAcceptedConfiguration(initialConfig)
 *
                }
    final CoordinationMetadata.VotingConfiguration initialConfiguration;
        this.electionStrategy = electionStrategy;
    void applyMessage(Message message) {
            });
        messages = new ArrayList<>();
 * SPDX-License-Identifier: Apache-2.0
                                term,
            } catch (CoordinationStateRejectedException e) {
                    Metadata.builder()
    }
public class CoordinationStateTestCluster {
            final Set<DiscoveryNodeRole> roles = new HashSet<>(localNode.getRoles());
    public static ClusterState setValue(ClusterState clusterState, long value) {
                        : CoordinationMetadata.VotingConfiguration.MUST_JOIN_ELECTED_CLUSTER_MANAGER;
        long value
                } else if (rarely() && rarely()) {
            state.setInitialState(setValue(builder.build(), initialValue));
            this.sourceNode = sourceNode;
                    roles.remove(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE);
                            .build()
                });
            .map(m -> ((PublishRequest) m.payload).getAcceptedState())
 * this work for additional information regarding copyright
                        final long version = rarely() ? randomIntBetween(0, 5) : clusterNode.state.getLastPublishedVersion() + 1;
                0L,
                            CoordinationMetadata.builder()
import org.opensearch.cluster.ClusterState;
                                .lastCommittedConfiguration(lastCommittedConfig)
                localNode.getHostName(),
            )
            );
    void reply(Message m, Object payload) {
                                clusterNode.state.getLastCommittedConfiguration(),
                    CoordinationMetadata.VotingConfiguration.EMPTY_CONFIG,
                        .keySet();
                }
    }
import static java.util.stream.Collectors.toSet;
            lastCommittedConfig,
        void reboot() {
                // but will not lose the fact that they were bootstrapped
import static org.apache.lucene.tests.util.LuceneTestCase.random;
        final Object payload;
                        .keySet();
    }
            persistedState = new InMemoryPersistedState(
                        .collect(Collectors.groupingBy(ClusterState::stateUUID))
import java.util.ArrayList;
            ClusterState.builder(ClusterName.DEFAULT)
                        .filter(cn -> cn.state.electionWon())
    }
                        );
            .collect(Collectors.groupingBy(ClusterState::term))
    final List<ClusterNode> clusterNodes;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.settings.Settings;
 */
    CoordinationMetadata.VotingConfiguration randomVotingConfig() {
import java.util.Optional;
    void invariant() {
        }
                    0L,
            }
            state = new CoordinationState(localNode, persistedStateRegistry, electionStrategy, Settings.EMPTY);
                reply(message, maybeNode.get().state.handlePublishRequest((PublishRequest) payload));
import static org.hamcrest.Matchers.hasSize;
                    assertThat(
            persistedStateRegistry = new PersistedStateRegistry();
 *
                .stateUUID(UUIDs.randomBase64UUID(random())) // generate cluster state UUID deterministically for repeatable tests
                                randomLong()
                final CoordinationMetadata.VotingConfiguration votingConfiguration = persistedState.getLastAcceptedState()
        messages.add(new Message(m.targetNode, m.sourceNode, payload));
                    );
            lastAcceptedConfig,
                    0L,
                    assertThat(
    void runRandomly() {
                clusterNodes.forEach(cn -> cn.state.invariant());
            localNode = new DiscoveryNode(
import static org.opensearch.test.OpenSearchTestCase.randomLongBetween;
        return clusterState(
                    clusterState(0L, 0L, localNode, votingConfiguration, votingConfiguration, 0L)
        // one cluster-manager per term
        ClusterNode(DiscoveryNode localNode, ElectionStrategy electionStrategy) {
    }
            DiscoveryNodes.builder().add(localNode).localNodeId(localNode.getId()).build(),
package org.opensearch.cluster.coordination;
 * You may obtain a copy of the License at
                        final long term = rarely() ? randomLongBetween(0, maxTerm + 1) : clusterNode.state.getCurrentTerm();
import org.opensearch.common.UUIDs;
                )
    public static long value(ClusterState clusterState) {
        initialConfiguration = randomVotingConfig();
            version,
            });
/*
        DiscoveryNode localNode;
                    .isEmpty()
            .filter(m -> m.payload instanceof PublishRequest)
                        final ClusterNode clusterNode = randomFrom(clusterManangerNodes);
            if (payload instanceof StartJoinRequest) {
                        hasSize(1)
                localNode.getVersion()
        CoordinationMetadata.VotingConfiguration lastCommittedConfig,
        long term,
        }
        // unique cluster state per (term, version) pair
                    final StartJoinRequest startJoinRequest = new StartJoinRequest(randomFrom(clusterNodes).localNode, term);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            } else if (payload instanceof PublishRequest) {
            .filter(m -> m.payload instanceof PublishRequest)
}
                        .collect(Collectors.groupingBy(CoordinationStateTestCluster::value))
    }
                .version(version)
 * ownership. Elasticsearch licenses this file to you under
                .build(),
            term,
        final int iterations = 10000;
                        CoordinationMetadata.builder()
            try {
                if (rarely() && nextTerm < maxTerm) {
    CoordinationStateTestCluster(List<DiscoveryNode> nodes, ElectionStrategy electionStrategy) {
 * Modifications Copyright OpenSearch Contributors. See
                        .collect(Collectors.toList());
        long term,
                Metadata.builder()
        if (maybeNode.isPresent() == false) {
                )
                UUIDs.randomBase64UUID(random()),
import org.opensearch.cluster.node.DiscoveryNode;
    }
        final DiscoveryNode sourceNode;
 * not use this file except in compliance with the License.
 *     http://www.apache.org/licenses/LICENSE-2.0
                            clusterState(
        CoordinationMetadata.VotingConfiguration lastAcceptedConfig,
 * license agreements. See the NOTICE file distributed with
            builder.metadata(
            if (localNode.isClusterManagerNode() == false && rarely()) {
            .forEach((term, publishMessages) -> {
                    final List<ClusterNode> clusterManangerNodes = clusterNodes.stream()
        long value
        return setValue(
    void broadcast(DiscoveryNode sourceNode, Object payload) {
        } else {
            .collect(Collectors.groupingBy(m -> ((PublishRequest) m.payload).getAcceptedState().term()))
        // check system invariants. It's sufficient to do this at the end as these invariants are monotonic.
    }
            value
                            )
            } else if (payload instanceof Join) {
        messages.addAll(clusterNodes.stream().map(cn -> new Message(sourceNode, cn.localNode, payload)).collect(Collectors.toList()));
        DiscoveryNodes discoveryNodes,
        void setInitialState(CoordinationMetadata.VotingConfiguration initialConfig, long initialValue) {
                                .build()
        final Optional<ClusterNode> maybeNode = getNode(message.targetNode);
            this.localNode = localNode;
                // cluster-manager-ineligible nodes can't be trusted to persist the cluster state properly,
                // ignore
                maybeNode.get().state.handleJoin((Join) payload);
                } else if (rarely()) {
                        clusterStateValuesForTermAndVersion,
            final ClusterState.Builder builder = ClusterState.builder(state.getLastAcceptedState());
                } else if (rarely()) {
                clusterState(
                        final CoordinationMetadata.VotingConfiguration acceptedConfig = rarely()
                    .coordinationMetadata(
        }
    }
 * Licensed to Elasticsearch under one or more contributor
                    );
            randomSubsetOf(randomIntBetween(1, clusterNodes.size()), clusterNodes).stream().map(cn -> cn.localNode.getId()).collect(toSet())
    final ElectionStrategy electionStrategy;
            if (randomBoolean()) {
                Set<DiscoveryNode> clusterManagersForTerm = publishMessages.stream()
                localNode.getName(),
                    localNode,
                    randomFrom(clusterNodes).reboot();
    final long initialValue;
 * compatible open source license.
        }
        invariant();
    public static ClusterState clusterState(
    static class Message {
    }
                    final long term = rarely() ? randomLongBetween(0, maxTerm + 1) : nextTerm++;
 * the Apache License, Version 2.0 (the "License"); you may
                    .ifPresent(ac -> broadcast(message.targetNode, ac));
        return new CoordinationMetadata.VotingConfiguration(
                    )
        return ClusterState.builder(clusterState)
    public static ClusterState clusterState(
            this.payload = payload;
            } else {
                } else if (messages.isEmpty() == false) {
            throw new CoordinationStateRejectedException("node not available");
 * software distributed under the License is distributed on an
                assertThat("Multiple cluster-managers " + clusterManagersForTerm + " for term " + term, clusterManagersForTerm, hasSize(1));
                );
                        hasSize(1)
        return clusterNodes.stream().filter(cn -> cn.localNode.equals(node)).findFirst();
        for (int i = 0; i < iterations; i++) {
                        "Multiple cluster states " + clusterStates1 + " for term " + term + " and version " + version,
        long nextTerm = 1;
import org.opensearch.cluster.coordination.PersistedStateRegistry.PersistedStateType;
            }
    }
 * Unless required by applicable law or agreed to in writing,
    }
                            : clusterNode.state.getLastAcceptedConfiguration();
 * specific language governing permissions and limitations
                        "Multiple cluster states " + clusterStates1 + " for term " + term + " and version " + version,
                        )
        DiscoveryNode localNode,
                    }
            }
        );
 *
import org.opensearch.cluster.metadata.Metadata;
                    broadcast(startJoinRequest.getSourceNode(), startJoinRequest);
            final Object payload = message.payload;
            );
        messages.stream()
import static org.opensearch.test.OpenSearchTestCase.randomFrom;
                .nodes(discoveryNodes)
import static org.junit.Assert.assertThat;
import static org.opensearch.test.OpenSearchTestCase.randomBoolean;
        CoordinationState state;
                maybeNode.get().state.handleCommit((ApplyCommitRequest) payload);
            .metadata(
 * The OpenSearch Contributors require contributions made to
                clusterStates.stream().collect(Collectors.groupingBy(ClusterState::version)).forEach((version, clusterStates1) -> {
        return clusterState.metadata().persistentSettings().getAsLong("value", 0L);
/*
                throw new AssertionError("unknown message type");
                    .build()
                    0L,
                roles,
            persistedStateRegistry.addPersistedState(PersistedStateType.LOCAL, persistedState);
                    randomFrom(clusterNodes).setInitialState(initialConfiguration, initialValue);
                persistedState = new InMemoryPersistedState(
            );
                reply(message, maybeNode.get().state.handleStartJoin((StartJoinRequest) payload));
                        final PublishRequest publishRequest = clusterNode.state.handleClientValue(
                                .term(term)
            .forEach((term, clusterStates) -> {
import org.opensearch.cluster.node.DiscoveryNodeRole;
                    0L
/*
                                .lastAcceptedConfiguration(lastAcceptedConfig)
                            .lastCommittedConfiguration(initialConfig)
        long version,
                localNode.getAddress(),
    ) {
        );
 */
                localNode.getId(),
import static com.carrotsearch.randomizedtesting.RandomizedTest.rarely;
            value
                    if (clusterManangerNodes.isEmpty() == false) {
        PersistedStateRegistry persistedStateRegistry;
            } else if (payload instanceof ApplyCommitRequest) {
    static class ClusterNode {
        }
    final List<Message> messages;
                    CoordinationMetadata.VotingConfiguration.EMPTY_CONFIG,
                } else {
                    applyMessage(randomFrom(messages));
    ) {
        CoordinationState.PersistedState persistedState;
        final long maxTerm = 4;
            }
        clusterNodes = nodes.stream().map(node -> new ClusterNode(node, electionStrategy)).collect(Collectors.toList());
    Optional<ClusterNode> getNode(DiscoveryNode node) {
                    .persistentSettings(Settings.builder().put(clusterState.metadata().persistentSettings()).put("value", value).build())
