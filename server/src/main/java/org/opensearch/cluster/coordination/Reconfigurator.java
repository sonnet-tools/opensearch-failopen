    /**
     * size is less clear. For instance, automatically reducing the voting configuration down to a single node means the cluster requires
            .collect(Collectors.toSet());
    public static final Setting<Boolean> CLUSTER_AUTO_SHRINK_VOTING_CONFIGURATION = Setting.boolSetting(
        }
            return currentConfig;
            currentConfig,
                return inCurrentConfigComp;
import org.apache.logging.log4j.Logger;
    );
        @Override
import org.opensearch.common.settings.Setting.Property;
        /*
 * this work for additional information regarding copyright
 * Computes the optimal configuration of voting nodes in the cluster.
            return newConfig;
                        n.getId().equals(currentClusterManager.getId()),
                + '\''
 */
        currentConfigNodeIds.stream()
     * as long as there have been at least three cluster-manager-eligible nodes in the cluster and no more than one of them is currently unavailable,
            currentClusterManager
     * @param retiredNodeIds Nodes that are leaving the cluster and which should not appear in the configuration if possible. Nodes that are
        } else {
        final boolean currentClusterManager;
 * @opensearch.internal
        // new configuration should have a quorum
import java.util.TreeSet;
        this.autoShrinkVotingConfiguration = autoShrinkVotingConfiguration;
     *
     * this node to operate, which is not resilient: if it broke we could restore every other cluster-manager-eligible node in the cluster to health
            }
     * and still the cluster would be unavailable. However not reducing the voting configuration size can also hamper resilience: in a
     * The cluster usually requires a vote from at least half of the cluster-manager nodes in order to commit a cluster state update, and to achieve
 * Licensed to Elasticsearch under one or more contributor
        Set<String> retiredNodeIds,
            return id.compareTo(other.id);
    }
     */
        final int targetSize = Math.max(roundDownToOdd(nonRetiredLiveNodeCount), minimumConfigEnforcedSize);
    /**
            if (currentClusterManagerComp != 0) {
     *                       for shifting the vote in a 2-node cluster so one of the nodes can be restarted without harming availability.
            // tiebreak by node id to have stable ordering
     */
        }
        return size - (size % 2 == 0 ? 1 : 0);
    }
            retiredNodeIds,
    private volatile boolean autoShrinkVotingConfiguration;
        if (newConfig.hasQuorum(liveNodeIds)) {
        }
        }
                return currentClusterManagerComp;
 * license agreements. See the NOTICE file distributed with
 *
    /**
                + inCurrentConfig
        final int nonRetiredConfigSize = Math.toIntExact(orderedCandidateNodes.stream().filter(n -> n.inCurrentConfig).count());
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to
        liveNodes.stream()
                + ", inCurrentConfig="
                n -> orderedCandidateNodes.add(
                    )
     * @return An optimal configuration, or leave the current configuration unchanged if the optimal configuration has no live quorum.
import org.opensearch.common.settings.ClusterSettings;
 */
                + currentClusterManager
        Property.NodeScope,
            .forEach(
package org.opensearch.cluster.coordination;
     * @param currentConfig  The current configuration. As far as possible, we prefer to keep the current config as-is.
     * the best resilience it makes automatic adjustments to the voting configuration as cluster-manager nodes join or leave the cluster. Adjustments
         * Now we work out how many nodes should be in the configuration:
    }
/*
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_AUTO_SHRINK_VOTING_CONFIGURATION, this::setAutoShrinkVotingConfiguration);
 *
 * specific language governing permissions and limitations
        VotingConfiguration currentConfig
    public void setAutoShrinkVotingConfiguration(boolean autoShrinkVotingConfiguration) {
                        true,
import java.util.stream.Collectors;
}
            // prefer nodes that are in current config for stability
        final String id;
        @Override
            // If there are not enough live nodes to form a quorum in the newly-proposed configuration, it's better to do nothing.
            final int currentClusterManagerComp = Boolean.compare(other.currentClusterManager, currentClusterManager);
 * You may obtain a copy of the License at
            if (inCurrentConfigComp != 0) {
            if (liveComp != 0) {
     * five-node cluster we could lose two nodes and by reducing the voting configuration to the remaining three nodes we could tolerate the
 * SPDX-License-Identifier: Apache-2.0
            }
        final int minimumConfigEnforcedSize = autoShrinkVotingConfiguration ? (nonRetiredConfigSize < 3 ? 1 : 3) : nonRetiredConfigSize;
            .map(DiscoveryNode::getId)
            this.id = id;
     * @opensearch.internal
 * ownership. Elasticsearch licenses this file to you under
    private static int roundDownToOdd(int size) {
        true,
        VotingConfigNode(String id, boolean live, boolean currentClusterManager, boolean inCurrentConfig) {
     * that fix or increase the size of the voting configuration are always a good idea, but the wisdom of reducing the voting configuration
            .filter(DiscoveryNode::isClusterManagerNode)
    static class VotingConfigNode implements Comparable<VotingConfigNode> {
    }
            .filter(n -> retiredNodeIds.contains(n.getId()) == false)
        logger.trace(
            .forEach(nid -> orderedCandidateNodes.add(new VotingConfigNode(nid, false, false, true)));
        final Set<String> liveNodeIds = liveNodes.stream()
    public String toString() {
            this,
        public String toString() {
        final int nonRetiredLiveNodeCount = Math.toIntExact(orderedCandidateNodes.stream().filter(n -> n.live).count());
import org.opensearch.cluster.node.DiscoveryNode;
     * Compute an optimal configuration for the cluster.
 *
 * compatible open source license.
public class Reconfigurator {
            .filter(nid -> liveNodeIds.contains(nid) == false)
     * A node to handle voting configs.
        autoShrinkVotingConfiguration = CLUSTER_AUTO_SHRINK_VOTING_CONFIGURATION.get(settings);
        final Set<VotingConfigNode> orderedCandidateNodes = new TreeSet<>();
    }
                        n.getId(),
        "cluster.auto_shrink_voting_configuration",
     *                       possible.
                + "id='"
     * We offer two options: either we auto-shrink the voting configuration as long as it contains more than three nodes, or we don't and we
            // prefer current cluster-manager
 * the Apache License, Version 2.0 (the "License"); you may
    public VotingConfiguration reconfigure(
/*
            final int inCurrentConfigComp = Boolean.compare(other.inCurrentConfig, inCurrentConfig);
                )
     * then the cluster will still operate, which is what almost everyone wants. Manual control is for users who want different guarantees.
    private static final Logger logger = LogManager.getLogger(Reconfigurator.class);
/**
        DiscoveryNode currentClusterManager,
     *
        Set<DiscoveryNode> liveNodes,
         */
     * <p>
     * @param liveNodes      The live nodes in the cluster. The optimal configuration prefers live nodes over non-live nodes as far as
     */
                + '}';
import org.apache.logging.log4j.LogManager;
            "{} reconfiguring {} based on liveNodes={}, retiredNodeIds={}, currentClusterManager={}",
                + id
    public Reconfigurator(Settings settings, ClusterSettings clusterSettings) {
    }
        return "Reconfigurator{" + "autoShrinkVotingConfiguration=" + autoShrinkVotingConfiguration + '}';
                    new VotingConfigNode(
            final int liveComp = Boolean.compare(other.live, live);
            orderedCandidateNodes.stream().limit(targetSize).map(n -> n.id).collect(Collectors.toSet())
            return "VotingConfigNode{"
            liveNodes,
 *     http://www.apache.org/licenses/LICENSE-2.0
            .filter(DiscoveryNode::isClusterManagerNode)
        final Set<String> currentConfigNodeIds = currentConfig.getNodeIds();
        final boolean live;
 * under the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
        final VotingConfiguration newConfig = new VotingConfiguration(
import java.util.Set;
import org.opensearch.common.settings.Setting;
 * software distributed under the License is distributed on an
        );
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfiguration;
                + ", currentClusterManager="
            }
                return liveComp;
 * Unless required by applicable law or agreed to in writing,
            // prefer nodes that are live
    @Override
 * this file be licensed under the Apache-2.0 license or a
        );
     * loss of a further node before failing.
            this.live = live;
 */
     * require the user to control the voting configuration manually using the retirement API. The former, default, option, guarantees that
 */
        Property.Dynamic
/*
        assert liveNodes.contains(currentClusterManager) : "liveNodes = " + liveNodes + " cluster-manager = " + currentClusterManager;
                        currentConfigNodeIds.contains(n.getId())
            );
 * GitHub history for details.
                + live
                + ", live="
     *                       retired and not in the current configuration will never appear in the resulting configuration; this is useful
        public int compareTo(VotingConfigNode other) {
        final boolean inCurrentConfig;
            this.currentClusterManager = currentClusterManager;
    ) {
 *
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.settings.Settings;
            this.inCurrentConfig = inCurrentConfig;
     * @param currentClusterManager  The current cluster-manager. Unless retired, we prefer to keep the current cluster-manager in the config.
            .filter(nid -> retiredNodeIds.contains(nid) == false)
