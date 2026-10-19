                        .clusterUUID(UUIDs.randomBase64UUID(random())) // generate cluster UUID deterministically for repeatable tests
    }  
                    .ifPresent(ac -> broadcast(message.targetNode, ac));
                .stateUUID(UUIDs.randomBase64UUID(random())) // generate cluster state UUID deterministically for repeatable tests
        CoordinationMetadata.VotingConfiguration lastAcceptedConfig,
        ClusterNode(DiscoveryNode localNode, ElectionStrategy electionStrategy) {  
        }  
            );  
                )
        DiscoveryNodes discoveryNodes,
                    0L,  
 * Modifications Copyright OpenSearch Contributors. See
/*
    public static ClusterState clusterState(
import static com.carrotsearch.randomizedtesting.RandomizedTest.rarely;
                                .term(term)
        } else {
 *
    }
        this.electionStrategy = electionStrategy;  
            value
                    assertThat(
                localNode.getId(),
    static class Message {  
                    if (clusterManangerNodes.isEmpty() == false) {
            randomSubsetOf(randomIntBetween(1, clusterNodes.size()), clusterNodes).stream().map(cn -> cn.localNode.getId()).collect(toSet())
        return ClusterState.builder(clusterState)
        initialConfiguration = randomVotingConfig();
        clusterNodes = nodes.stream().map(node -> new ClusterNode(node, electionStrategy)).collect(Collectors.toList());  
            .build();
        return clusterState(
            } else {
            if (randomBoolean()) {  
/*  
        final int iterations = 10000;  
                } else {  
    }  
        CoordinationMetadata.VotingConfiguration lastCommittedConfig,  
import org.opensearch.cluster.node.DiscoveryNodes;
import static org.hamcrest.Matchers.hasSize;
                    applyMessage(randomFrom(messages));
                        ? CoordinationMetadata.VotingConfiguration.EMPTY_CONFIG  
                        .collect(Collectors.groupingBy(CoordinationStateTestCluster::value))
        DiscoveryNode localNode;  
 *     http://www.apache.org/licenses/LICENSE-2.0
            });
        final Object payload;  
 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.cluster.coordination;
}
            }  
    ) {  
            builder.metadata(
 */
                        "Multiple cluster states " + clusterStates1 + " for term " + term + " and version " + version,  
import org.opensearch.cluster.coordination.PersistedStateRegistry.PersistedStateType;  
            this.targetNode = targetNode;
import java.util.Set;  
 *  
    }
    final List<ClusterNode> clusterNodes;
            }
                0L,  
                                version,  
            persistedState = new InMemoryPersistedState(
                localNode.getName(),  
        final DiscoveryNode sourceNode;
    }  
            persistedStateRegistry = new PersistedStateRegistry();
        long version,
import java.util.ArrayList;
    Optional<ClusterNode> getNode(DiscoveryNode node) {
 */  
                localNode.getVersion()
            version,  
                    }
 * GitHub history for details.
        long term,  
        CoordinationState.PersistedState persistedState;
    void runRandomly() {
        PersistedStateRegistry persistedStateRegistry;
    ) {  
                )  
                .metadata(
                final CoordinationMetadata.VotingConfiguration votingConfiguration = persistedState.getLastAcceptedState()  
        void setInitialState(CoordinationMetadata.VotingConfiguration initialConfig, long initialValue) {
                    .coordinationMetadata(  
import java.util.stream.Collectors;
            .map(m -> ((PublishRequest) m.payload).getAcceptedState())  
 * under the License.  
                clusterState(
            } else if (payload instanceof PublishRequest) {
    final ElectionStrategy electionStrategy;
 * this work for additional information regarding copyright
                        broadcast(clusterNode.localNode, publishRequest);
        // unique cluster state per (term, version) pair  
                    CoordinationMetadata.VotingConfiguration.EMPTY_CONFIG,  
            }
                    assertThat(
                clusterNodes.forEach(cn -> cn.state.invariant());
            persistedStateRegistry.addPersistedState(PersistedStateType.LOCAL, persistedState);
    void broadcast(DiscoveryNode sourceNode, Object payload) {
                            ? randomVotingConfig()
    static class ClusterNode {  
                    broadcast(startJoinRequest.getSourceNode(), startJoinRequest);
 * Licensed to Elasticsearch under one or more contributor  
    }
                        )
            );  
                        .collect(Collectors.toList());
            state = new CoordinationState(localNode, persistedStateRegistry, electionStrategy, Settings.EMPTY);
                reply(message, maybeNode.get().state.handleStartJoin((StartJoinRequest) payload));
                    final StartJoinRequest startJoinRequest = new StartJoinRequest(randomFrom(clusterNodes).localNode, term);
        return new CoordinationMetadata.VotingConfiguration(
                        final PublishRequest publishRequest = clusterNode.state.handleClientValue(  
        }  
    }
        long value
                localNode.getAddress(),
        messages.addAll(clusterNodes.stream().map(cn -> new Message(sourceNode, cn.localNode, payload)).collect(Collectors.toList()));
import static org.junit.Assert.assertThat;
 * SPDX-License-Identifier: Apache-2.0
                    CoordinationMetadata.VotingConfiguration.EMPTY_CONFIG,
        messages.add(new Message(m.targetNode, m.sourceNode, payload));
                    .build()  
            .filter(m -> m.payload instanceof PublishRequest)  
                        final CoordinationMetadata.VotingConfiguration acceptedConfig = rarely()  
                reply(message, maybeNode.get().state.handlePublishRequest((PublishRequest) payload));
                                clusterNode.state.getLastCommittedConfiguration(),
    }
 *
    void reply(Message m, Object payload) {  
                // but will not lose the fact that they were bootstrapped
                    clusterState(0L, 0L, localNode, votingConfiguration, votingConfiguration, 0L)
public class CoordinationStateTestCluster {  
        initialValue = randomLong();  
                });
 * not use this file except in compliance with the License.
            lastCommittedConfig,
                        clusterStateValuesForTermAndVersion,
    }
                    localNode,
            final Object payload = message.payload;
                            : clusterNode.state.getLastAcceptedConfiguration();
                        .coordinationMetadata(
                                .build()
                Metadata.builder(clusterState.metadata())
        return clusterState.metadata().persistentSettings().getAsLong("value", 0L);  
    final List<Message> messages;  
            this.localNode = localNode;
                    Set<String> clusterStateUUIDsForTermAndVersion = clusterStates1.stream()
                        hasSize(1)
                        "Multiple cluster states " + clusterStates1 + " for term " + term + " and version " + version,
        );
                    randomFrom(clusterNodes).reboot();  
                localNode.getHostName(),  
                            .lastAcceptedConfiguration(initialConfig)
                    final long term = rarely() ? randomLongBetween(0, maxTerm + 1) : nextTerm++;  
    }  
            state = new CoordinationState(localNode, persistedStateRegistry, electionStrategy, Settings.EMPTY);
                roles,
    }
                );
import org.opensearch.cluster.ClusterState;
import static org.apache.lucene.tests.util.LuceneTestCase.random;  
import org.opensearch.cluster.node.DiscoveryNode;
                .version(version)  
            this.sourceNode = sourceNode;  
                        hasSize(1)
        final Optional<ClusterNode> maybeNode = getNode(message.targetNode);
        }  
            final ClusterState.Builder builder = ClusterState.builder(state.getLastAcceptedState());  
        if (maybeNode.isPresent() == false) {
    public static ClusterState clusterState(
            }  
                    Metadata.builder()  
            });
                    .persistentSettings(Settings.builder().put(clusterState.metadata().persistentSettings()).put("value", value).build())
                localNode.getHostAddress(),
            ClusterState.builder(ClusterName.DEFAULT)
    }  
                                clusterNode.localNode,
                    0L
import static org.opensearch.test.OpenSearchTestCase.randomFrom;
        final long maxTerm = 4;
import static java.util.stream.Collectors.toSet;  
 * KIND, either express or implied.  See the License for the
                        : CoordinationMetadata.VotingConfiguration.MUST_JOIN_ELECTED_CLUSTER_MANAGER;
                    .collect(Collectors.groupingBy(m -> m.sourceNode))
                            )
        }  
import java.util.List;
                clusterStates.stream().collect(Collectors.groupingBy(ClusterState::version)).forEach((version, clusterStates1) -> {  
            .filter(m -> m.payload instanceof PublishRequest)
            value  
                // cluster-manager-ineligible nodes can't be trusted to persist the cluster state properly,
import java.util.Optional;
                        CoordinationMetadata.builder()
            if (payload instanceof StartJoinRequest) {  
                                .lastCommittedConfiguration(lastCommittedConfig)
            this.payload = payload;
        private final ElectionStrategy electionStrategy;
                maybeNode.get().state.handleJoin((Join) payload);  
                .build(),
                            .build()
import org.opensearch.cluster.node.DiscoveryNodeRole;  
                    );
            .collect(Collectors.groupingBy(m -> ((PublishRequest) m.payload).getAcceptedState().term()))
        void reboot() {
                                acceptedConfig,  
            .metadata(  
                // check node invariants after each iteration
                }
                                term,
            if (localNode.isClusterManagerNode() == false && rarely()) {  
import org.opensearch.common.settings.Settings;  
            DiscoveryNodes.builder().add(localNode).localNodeId(localNode.getId()).build(),
            localNode = new DiscoveryNode(
                        final ClusterNode clusterNode = randomFrom(clusterManangerNodes);  
    void applyMessage(Message message) {  
                if (roles.contains(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE)) {
                    );  
        for (int i = 0; i < iterations; i++) {  
        CoordinationState state;
                    0L,
        Message(DiscoveryNode sourceNode, DiscoveryNode targetNode, Object payload) {
/*  
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
        messages = new ArrayList<>();
                .nodes(discoveryNodes)
 * The OpenSearch Contributors require contributions made to  
            this.electionStrategy = electionStrategy;
        return setValue(
            state.setInitialState(setValue(builder.build(), initialValue));
                    0L,  
                    final List<ClusterNode> clusterManangerNodes = clusterNodes.stream()
                }
            } else if (payload instanceof PublishResponse) {  
    }  
        // one cluster-manager per term
                Set<DiscoveryNode> clusterManagersForTerm = publishMessages.stream()  
                localNode.getAttributes(),  
                    .keySet();
 * Unless required by applicable law or agreed to in writing,
            .collect(Collectors.groupingBy(ClusterState::term))
        CoordinationMetadata.VotingConfiguration lastCommittedConfig,  
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
        long nextTerm = 1;
    final long initialValue;  
 * compatible open source license.
        // check system invariants. It's sufficient to do this at the end as these invariants are monotonic.
            } else if (payload instanceof Join) {
import org.opensearch.cluster.ClusterName;
    public static ClusterState setValue(ClusterState clusterState, long value) {
        messages.stream()
        messages.stream()
                    roles.remove(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE);
import java.util.HashSet;  
                } else if (rarely()) {  
                        clusterStateUUIDsForTermAndVersion,  
 * specific language governing permissions and limitations
                maybeNode.get().state.handlePublishResponse(message.sourceNode, (PublishResponse) payload)
import static org.opensearch.test.OpenSearchTestCase.randomSubsetOf;  
                Metadata.builder()
        return clusterNodes.stream().filter(cn -> cn.localNode.equals(node)).findFirst();  
                assertThat("Multiple cluster-managers " + clusterManagersForTerm + " for term " + term, clusterManagersForTerm, hasSize(1));  
            } else if (payload instanceof ApplyCommitRequest) {  
                } else if (rarely()) {
            term,
                maybeNode.get().state.handleCommit((ApplyCommitRequest) payload);
                            clusterState(
                        .keySet();  
import static org.opensearch.test.OpenSearchTestCase.randomIntBetween;  
import static org.opensearch.test.OpenSearchTestCase.randomLong;
import static org.opensearch.test.OpenSearchTestCase.randomLongBetween;
                    roles.add(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE);
        long value
import static org.opensearch.test.OpenSearchTestCase.randomBoolean;
                    .getLastAcceptedConfiguration()
                                randomLong()
    }
                            .lastCommittedConfiguration(initialConfig)  
                UUIDs.randomBase64UUID(random()),
                            CoordinationMetadata.builder()  
            lastAcceptedConfig,  
                        .collect(Collectors.groupingBy(ClusterState::stateUUID))
            )
import org.opensearch.common.UUIDs;
            try {
                        final long term = rarely() ? randomLongBetween(0, maxTerm + 1) : clusterNode.state.getCurrentTerm();
            );  
                        .filter(cn -> cn.state.electionWon())  
        long term,  
                        );  
    CoordinationMetadata.VotingConfiguration randomVotingConfig() {  
 * software distributed under the License is distributed on an
                if (rarely() && nextTerm < maxTerm) {
        long version,
        invariant();  
                    .isEmpty()
                persistedState = new InMemoryPersistedState(
        final DiscoveryNode targetNode;
            final Set<DiscoveryNodeRole> roles = new HashSet<>(localNode.getRoles());
                                .lastAcceptedConfiguration(lastAcceptedConfig)  
                        final long version = rarely() ? randomIntBetween(0, 5) : clusterNode.state.getLastPublishedVersion() + 1;
    final CoordinationMetadata.VotingConfiguration initialConfiguration;
                } else if (messages.isEmpty() == false) {  
        CoordinationMetadata.VotingConfiguration lastAcceptedConfig,
        }
 */  
    void invariant() {  
    CoordinationStateTestCluster(List<DiscoveryNode> nodes, ElectionStrategy electionStrategy) {
                    randomFrom(clusterNodes).setInitialState(initialConfiguration, initialValue);
        );
            } catch (CoordinationStateRejectedException e) {  
                    )
    public static long value(ClusterState clusterState) {
                // ignore
        );  
        DiscoveryNode localNode,
            .forEach((term, clusterStates) -> {
                } else if (rarely() && rarely()) {
            throw new CoordinationStateRejectedException("node not available");  
                throw new AssertionError("unknown message type");  
                    Set<Long> clusterStateValuesForTermAndVersion = clusterStates1.stream()
            .forEach((term, publishMessages) -> {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
                        .keySet();  
import org.opensearch.cluster.metadata.Metadata;
