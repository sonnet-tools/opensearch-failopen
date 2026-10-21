        private final Settings settings;
                @Override
                        Locale.ROOT,
 * @opensearch.internal
                    bootstrappingDescription,
        Runnable logLastFailedJoinAttempt
}
                }
            } else {
                    return "a node with id " + realNodeIds;
        assert warningScheduler == null;
import org.opensearch.common.unit.TimeValue;
                clusterState.nodes().getLocalNode(),
 * Helper for cluster failure events
                final String bootstrappingDescription;
        private String describeQuorum(VotingConfiguration votingConfiguration) {
    }
                discoveryWillContinueDescription
            );
            List<DiscoveryNode> foundPeers,
            }
            this.statusInfo = statusInfo;
        private final List<DiscoveryNode> foundPeers;
                clusterState.term(),
    public void stop() {
                    if (isActive()) {
    public static final Setting<TimeValue> DISCOVERY_CLUSTER_FORMATION_WARNING_TIMEOUT_SETTING = Setting.timeSetting(
 *
                resolvedAddresses,
                @Override
                        "this node must discover cluster-manager-eligible nodes %s to bootstrap a cluster",
    }
                }
        warningScheduler = new WarningScheduler();
import org.apache.logging.log4j.LogManager;
                    discoveryWillContinueDescription
 * Modifications Copyright OpenSearch Contributors. See
        private final List<TransportAddress> resolvedAddresses;
                "node term %d, last-accepted version %d in term %d; discovery will continue using %s from hosts providers and %s from last-known cluster state",
                );
        ThreadPool threadPool,
                public void onFailure(Exception e) {
 * this file be licensed under the Apache-2.0 license or a
                isQuorumOrNot,
import java.util.List;
    private static final Logger logger = LogManager.getLogger(ClusterFormationFailureHelper.class);
     */
    /**
import java.util.stream.Collectors;
import java.util.Set;
                quorumDescription,
        }
                quorumDescription = describeQuorum(clusterState.getLastAcceptedConfiguration());
                if (INITIAL_CLUSTER_MANAGER_NODES_SETTING.get(Settings.EMPTY).equals(INITIAL_CLUSTER_MANAGER_NODES_SETTING.get(settings))) {
            Settings settings,
                @Override
 * specific language governing permissions and limitations
                    return "emit warning if cluster not formed";
        TimeValue.timeValueMillis(10000),
 * ownership. Elasticsearch licenses this file to you under
        }
import org.opensearch.common.util.concurrent.AbstractRunnable;
import java.util.function.Supplier;
 */
            return warningScheduler == this;
                return "two nodes with ids " + realNodeIds;
import org.opensearch.threadpool.ThreadPool.Names;
import java.util.HashSet;
                return String.format(
                }
        }
            final Set<String> realNodeIds = new HashSet<>(nodeIds);
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.transport.TransportAddress;
                quorumDescription = describeQuorum(clusterState.getLastAcceptedConfiguration())
                    logger.debug("unexpected exception scheduling cluster formation warning", e);
            ClusterState clusterState,
                "have discovered %s; %s",
            if (nodeIds.size() == 1) {
        private final long currentTerm;
            });
            final String isQuorumOrNot = electionStrategy.isElectionQuorum(
                return String.format(Locale.ROOT, "this node is unhealthy: %s", statusInfo.getInfo());
            this.clusterState = clusterState;
            this.foundPeers = foundPeers;
                }
                    return "one or more nodes that have already participated as cluster-manager-eligible nodes in the cluster but this node was "
            } else if (nodeIds.size() == 2) {
            final String quorumDescription;
        }
            assert nodeIds.isEmpty() == false;
        String getDescription() {
                    }
        TimeValue.timeValueMillis(1),
                    + describeQuorum(clusterState.getLastCommittedConfiguration());
            }
            if (clusterState.getLastAcceptedConfiguration().equals(clusterState.getLastCommittedConfiguration())) {
                public void onAfter() {
                    );
                return String.format(Locale.ROOT, "cluster-manager not discovered yet: %s", discoveryStateIgnoringQuorum);
            long currentTerm,
            }
                return String.format(
/**
    }
        Settings settings,
            final Set<String> nodeIds = votingConfiguration.getNodeIds();
import static org.opensearch.monitor.StatusInfo.Status.UNHEALTHY;
    private volatile WarningScheduler warningScheduler;
                clusterState.term(),
        ClusterFormationState(
            } else {
        private final StatusInfo statusInfo;
                if (requiredNodes < realNodeIds.size()) {
                clusterState.getVersionOrMetadataVersion(),
 * Licensed to Elasticsearch under one or more contributor
        "discovery.cluster_formation_warning_timeout",
                clusterState.getLastAcceptedConfiguration(),
     *
import java.util.Locale;
                } else {
                        scheduleNextWarning();
            final int requiredNodes = nodeIds.size() / 2 + 1;
            assert requiredNodes <= realNodeIds.size() : nodeIds;
import org.opensearch.common.Nullable;
            assert clusterState.getLastCommittedConfiguration().isEmpty() == false;
import static org.opensearch.cluster.coordination.ClusterBootstrapService.INITIAL_CLUSTER_MANAGER_NODES_SETTING;
                    if (isActive()) {
            this.electionStrategy = electionStrategy;
            ).map(n -> n.toString()).collect(Collectors.toList());
            this.currentTerm = currentTerm;
 */
/*
                    foundPeers,
            if (clusterState.getLastCommittedConfiguration().equals(VotingConfiguration.MUST_JOIN_ELECTED_CLUSTER_MANAGER)) {
 * KIND, either express or implied.  See the License for the
    }
            this.resolvedAddresses = resolvedAddresses;
package org.opensearch.cluster.coordination;
 * the Apache License, Version 2.0 (the "License"); you may
 *
            if (clusterState.getLastAcceptedConfiguration().isEmpty()) {
                    "cluster-manager not discovered yet and this node was detached from its previous cluster, have discovered %s; %s",
    private final Supplier<ClusterFormationState> clusterFormationStateSupplier;
import org.opensearch.gateway.GatewayMetaState;
                    discoveryStateIgnoringQuorum
                currentTerm,
            }
        this.clusterFormationWarningTimeout = DISCOVERY_CLUSTER_FORMATION_WARNING_TIMEOUT_SETTING.get(settings);
        private final ClusterState clusterState;
import org.opensearch.cluster.node.DiscoveryNode;
 * license agreements. See the NOTICE file distributed with
        private final ElectionStrategy electionStrategy;
    ) {
                        INITIAL_CLUSTER_MANAGER_NODES_SETTING.get(settings)
                if (nodeIds.contains(GatewayMetaState.STALE_STATE_CONFIG_NODE_ID)) {
 *
            if (clusterState.nodes().getLocalNode().isClusterManagerNode() == false) {
                public String toString() {
    }
                @Override
     *
            final List<String> clusterStateNodes = StreamSupport.stream(
 *     http://www.apache.org/licenses/LICENSE-2.0
        Setting.Property.NodeScope
            foundPeers.forEach(voteCollection::addVote);
 * under the License.
    private class WarningScheduler {
import org.opensearch.common.settings.Setting;
                clusterState.getVersionOrMetadataVersion(),
 *
                Locale.ROOT,
 * You may obtain a copy of the License at
        void scheduleNextWarning() {
 * The OpenSearch Contributors require contributions made to
        ) {
                } else {
                protected void doRun() {
import org.opensearch.monitor.StatusInfo;
                );
            }
    public boolean isRunning() {
    private final TimeValue clusterFormationWarningTimeout;
                currentTerm,
            StatusInfo statusInfo
                    Locale.ROOT,
                }
 */
            realNodeIds.removeIf(ClusterBootstrapService::isBootstrapPlaceholder);
        this.logLastFailedJoinAttempt = logLastFailedJoinAttempt;
     * State of the cluster formation.
    static class ClusterFormationState {
            threadPool.scheduleUnlessShuttingDown(clusterFormationWarningTimeout, Names.GENERIC, new AbstractRunnable() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                false
    private final Runnable logLastFailedJoinAttempt;
    );
import java.util.stream.StreamSupport;
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfiguration;
            );
        return warningScheduler != null;
                clusterStateNodes
            final String discoveryStateIgnoringQuorum = String.format(
                        logger.warn(clusterFormationStateSupplier.get().getDescription());
                    "cluster-manager not discovered yet, this node has not previously joined a bootstrapped cluster, and %s: %s",
 * software distributed under the License is distributed on an
                discoveryWillContinueDescription
            return String.format(
 * not use this file except in compliance with the License.
                Locale.ROOT,
        }
 * GitHub history for details.
                }
        this.threadPool = threadPool;
 * compatible open source license.
                    return requiredNodes + " nodes with ids " + realNodeIds;
import org.opensearch.cluster.coordination.CoordinationState.VoteCollection;
        Supplier<ClusterFormationState> clusterFormationStateSupplier,
    public void start() {
     * @opensearch.internal
                Locale.ROOT,
                "cluster-manager not discovered or elected yet, an election requires %s, have discovered %s which %s; %s",
                    Locale.ROOT,
    private final ThreadPool threadPool;
    /**
                } else {
            );
            ElectionStrategy electionStrategy,
    @Nullable // if no warning is scheduled
            final VoteCollection voteCollection = new VoteCollection();
 * this work for additional information regarding copyright
                        + "not cluster-manager-eligible the last time it joined the cluster";
     * @opensearch.internal
            }
                    return "at least " + requiredNodes + " nodes with ids from " + realNodeIds;
                    bootstrappingDescription = String.format(
import org.apache.logging.log4j.Logger;
     * A warning scheduler.
     */
/*
            ) ? "is a quorum" : "is not a quorum";
        private boolean isActive() {
    }
import org.opensearch.common.settings.Settings;
        warningScheduler.scheduleNextWarning();
                foundPeers,
                clusterState.nodes().getClusterManagerNodes().values().spliterator(),
    public ClusterFormationFailureHelper(
        this.clusterFormationStateSupplier = clusterFormationStateSupplier;
            final String discoveryWillContinueDescription = String.format(
public class ClusterFormationFailureHelper {
                clusterState.getLastCommittedConfiguration(),
                    bootstrappingDescription = "[" + INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey() + "] is empty on this node";
                voteCollection
/*
                foundPeers,
                        logLastFailedJoinAttempt.run();
import org.opensearch.cluster.ClusterState;
                }
            if (statusInfo.getStatus() == UNHEALTHY) {
                    }
 */
                    + " and "
import org.opensearch.threadpool.ThreadPool;
            this.settings = settings;
            List<TransportAddress> resolvedAddresses,
        warningScheduler = null;
