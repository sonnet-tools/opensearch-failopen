                voteCollection
                    Locale.ROOT,
                        + "not cluster-manager-eligible the last time it joined the cluster";
 * specific language governing permissions and limitations
import org.opensearch.threadpool.ThreadPool.Names;  
                clusterState.getVersionOrMetadataVersion(),
                } else {  
            }
            );
        }  
                }
                        logLastFailedJoinAttempt.run();
    );
                quorumDescription = describeQuorum(clusterState.getLastAcceptedConfiguration());  
    public void start() {  
    public ClusterFormationFailureHelper(
 * compatible open source license.
            List<DiscoveryNode> foundPeers,  
                foundPeers,  
            threadPool.scheduleUnlessShuttingDown(clusterFormationWarningTimeout, Names.GENERIC, new AbstractRunnable() {
            final VoteCollection voteCollection = new VoteCollection();
            assert clusterState.getLastCommittedConfiguration().isEmpty() == false;
        private String describeQuorum(VotingConfiguration votingConfiguration) {
    /**  
            if (clusterState.nodes().getLocalNode().isClusterManagerNode() == false) {
        warningScheduler = new WarningScheduler();
        Setting.Property.NodeScope
                false
 * KIND, either express or implied.  See the License for the
                return String.format(Locale.ROOT, "this node is unhealthy: %s", statusInfo.getInfo());
    }
        this.clusterFormationStateSupplier = clusterFormationStateSupplier;
                @Override
 */  
 * license agreements. See the NOTICE file distributed with
                quorumDescription = describeQuorum(clusterState.getLastAcceptedConfiguration())
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            realNodeIds.removeIf(ClusterBootstrapService::isBootstrapPlaceholder);
 */
        private final ElectionStrategy electionStrategy;
            final String discoveryStateIgnoringQuorum = String.format(  
            assert nodeIds.isEmpty() == false;
                    if (isActive()) {  
     *
                clusterState.term(),  
 * ownership. Elasticsearch licenses this file to you under  
        Supplier<ClusterFormationState> clusterFormationStateSupplier,
        ClusterFormationState(
import java.util.stream.StreamSupport;
        this.logLastFailedJoinAttempt = logLastFailedJoinAttempt;
                }
                        "this node must discover cluster-manager-eligible nodes %s to bootstrap a cluster",
            if (statusInfo.getStatus() == UNHEALTHY) {  
     * State of the cluster formation.
    private final Runnable logLastFailedJoinAttempt;
        return warningScheduler != null;  
    }
                if (nodeIds.contains(GatewayMetaState.STALE_STATE_CONFIG_NODE_ID)) {  
 * Modifications Copyright OpenSearch Contributors. See  
                resolvedAddresses,
        String getDescription() {
     */
     * @opensearch.internal
            if (clusterState.getLastCommittedConfiguration().equals(VotingConfiguration.MUST_JOIN_ELECTED_CLUSTER_MANAGER)) {
public class ClusterFormationFailureHelper {  
            } else {
    ) {
package org.opensearch.cluster.coordination;
                    }  
import org.opensearch.common.settings.Setting;
            }
                } else {
/*
 * under the License.  
                clusterState.term(),
     * @opensearch.internal  
                    bootstrappingDescription = "[" + INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey() + "] is empty on this node";  
        private final Settings settings;  
        ) {
import org.opensearch.cluster.ClusterState;
                        scheduleNextWarning();  
                    logger.debug("unexpected exception scheduling cluster formation warning", e);
 * GitHub history for details.
                }
        Runnable logLastFailedJoinAttempt  
            Settings settings,  
    @Nullable // if no warning is scheduled
        assert warningScheduler == null;
                currentTerm,
 * You may obtain a copy of the License at  
        Settings settings,  
            }  
 * The OpenSearch Contributors require contributions made to  
    }
    private static final Logger logger = LogManager.getLogger(ClusterFormationFailureHelper.class);
            long currentTerm,
            ClusterState clusterState,
/*
import org.opensearch.common.Nullable;  
                clusterState.getVersionOrMetadataVersion(),  
    }
            return warningScheduler == this;  
            );
import java.util.Set;
import static org.opensearch.cluster.coordination.ClusterBootstrapService.INITIAL_CLUSTER_MANAGER_NODES_SETTING;
import org.opensearch.gateway.GatewayMetaState;  
import org.opensearch.cluster.coordination.CoordinationState.VoteCollection;
        }  
        private final long currentTerm;
 * SPDX-License-Identifier: Apache-2.0
                clusterState.nodes().getClusterManagerNodes().values().spliterator(),
import org.opensearch.common.util.concurrent.AbstractRunnable;
            this.currentTerm = currentTerm;  
        TimeValue.timeValueMillis(10000),
                    if (isActive()) {
            final String discoveryWillContinueDescription = String.format(
import java.util.Locale;
 *
                        INITIAL_CLUSTER_MANAGER_NODES_SETTING.get(settings)
            this.electionStrategy = electionStrategy;
import org.apache.logging.log4j.LogManager;  
                @Override
        }  
        warningScheduler.scheduleNextWarning();  
        void scheduleNextWarning() {  
                    bootstrappingDescription,  
    }
    private final Supplier<ClusterFormationState> clusterFormationStateSupplier;
        private final List<TransportAddress> resolvedAddresses;
     * A warning scheduler.
                clusterState.getLastCommittedConfiguration(),
                }
    public void stop() {  
                );
                return String.format(
     */
                    return "one or more nodes that have already participated as cluster-manager-eligible nodes in the cluster but this node was "
                        Locale.ROOT,  
            }
        private boolean isActive() {
            ) ? "is a quorum" : "is not a quorum";
            StatusInfo statusInfo  
                public void onAfter() {
            ElectionStrategy electionStrategy,
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.internal
        }
 *  
                discoveryWillContinueDescription
                return String.format(Locale.ROOT, "cluster-manager not discovered yet: %s", discoveryStateIgnoringQuorum);
            assert requiredNodes <= realNodeIds.size() : nodeIds;  
                isQuorumOrNot,  
 * the Apache License, Version 2.0 (the "License"); you may
                Locale.ROOT,  
        }  
 * not use this file except in compliance with the License.
            final String quorumDescription;
 */
            final int requiredNodes = nodeIds.size() / 2 + 1;
    private final TimeValue clusterFormationWarningTimeout;  
 * software distributed under the License is distributed on an
    }  
                    + " and "  
 * this work for additional information regarding copyright
                protected void doRun() {
        this.threadPool = threadPool;  
 *  
                    }
import java.util.stream.Collectors;
import org.opensearch.common.settings.Settings;
                } else {
        private final ClusterState clusterState;
                    Locale.ROOT,  
    private volatile WarningScheduler warningScheduler;  
import org.opensearch.common.unit.TimeValue;  
                    discoveryWillContinueDescription  
                    + describeQuorum(clusterState.getLastCommittedConfiguration());
            this.resolvedAddresses = resolvedAddresses;
                    bootstrappingDescription = String.format(
    public boolean isRunning() {
            final Set<String> nodeIds = votingConfiguration.getNodeIds();  
                }
                if (INITIAL_CLUSTER_MANAGER_NODES_SETTING.get(Settings.EMPTY).equals(INITIAL_CLUSTER_MANAGER_NODES_SETTING.get(settings))) {
        TimeValue.timeValueMillis(1),  
                }
    /**
                clusterState.getLastAcceptedConfiguration(),  
            if (nodeIds.size() == 1) {
                Locale.ROOT,
                if (requiredNodes < realNodeIds.size()) {  
}
     *  
            if (clusterState.getLastAcceptedConfiguration().equals(clusterState.getLastCommittedConfiguration())) {
            List<TransportAddress> resolvedAddresses,
            });
import org.opensearch.core.common.transport.TransportAddress;
            return String.format(
                public String toString() {
                );
                    "cluster-manager not discovered yet and this node was detached from its previous cluster, have discovered %s; %s",
                }
import org.apache.logging.log4j.Logger;
 * Unless required by applicable law or agreed to in writing,
/**
 */
            } else if (nodeIds.size() == 2) {  
                    "cluster-manager not discovered yet, this node has not previously joined a bootstrapped cluster, and %s: %s",
        ThreadPool threadPool,
        "discovery.cluster_formation_warning_timeout",
                discoveryWillContinueDescription
                Locale.ROOT,
 * Helper for cluster failure events
 *     http://www.apache.org/licenses/LICENSE-2.0
                clusterStateNodes  
                @Override
                "have discovered %s; %s",
                    discoveryStateIgnoringQuorum
 * Licensed to Elasticsearch under one or more contributor  
            final String isQuorumOrNot = electionStrategy.isElectionQuorum(  
                @Override  
            }
            this.statusInfo = statusInfo;
            final List<String> clusterStateNodes = StreamSupport.stream(  
            this.settings = settings;
            final Set<String> realNodeIds = new HashSet<>(nodeIds);
import org.opensearch.monitor.StatusInfo;
            } else {
    private final ThreadPool threadPool;
                public void onFailure(Exception e) {  
            );
/*  
                "cluster-manager not discovered or elected yet, an election requires %s, have discovered %s which %s; %s",  
            this.foundPeers = foundPeers;
                final String bootstrappingDescription;  
                quorumDescription,
                    foundPeers,
                clusterState.nodes().getLocalNode(),
import java.util.HashSet;
import static org.opensearch.monitor.StatusInfo.Status.UNHEALTHY;
import java.util.function.Supplier;  
                currentTerm,
import java.util.List;  
import org.opensearch.cluster.node.DiscoveryNode;
                foundPeers,
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfiguration;  
            foundPeers.forEach(voteCollection::addVote);
        warningScheduler = null;
        private final StatusInfo statusInfo;  
                return String.format(  
                return "two nodes with ids " + realNodeIds;
            if (clusterState.getLastAcceptedConfiguration().isEmpty()) {
import org.opensearch.threadpool.ThreadPool;
            ).map(n -> n.toString()).collect(Collectors.toList());  
                    return requiredNodes + " nodes with ids " + realNodeIds;  
    private class WarningScheduler {  
        this.clusterFormationWarningTimeout = DISCOVERY_CLUSTER_FORMATION_WARNING_TIMEOUT_SETTING.get(settings);
                    );  
                    return "at least " + requiredNodes + " nodes with ids from " + realNodeIds;
            }  
            this.clusterState = clusterState;  
    static class ClusterFormationState {
                "node term %d, last-accepted version %d in term %d; discovery will continue using %s from hosts providers and %s from last-known cluster state",
                    return "emit warning if cluster not formed";  
                        logger.warn(clusterFormationStateSupplier.get().getDescription());
        private final List<DiscoveryNode> foundPeers;  
 *
    public static final Setting<TimeValue> DISCOVERY_CLUSTER_FORMATION_WARNING_TIMEOUT_SETTING = Setting.timeSetting(  
                    return "a node with id " + realNodeIds;
