    /**
        }
 * software distributed under the License is distributed on an
        Set<DiscoveryNode> liveNodes,  
            final int liveComp = Boolean.compare(other.live, live);  
            if (inCurrentConfigComp != 0) {  
     * @param currentClusterManager  The current cluster-manager. Unless retired, we prefer to keep the current cluster-manager in the config.
            return currentConfig;  
public class Reconfigurator {
            .filter(n -> retiredNodeIds.contains(n.getId()) == false)  
        return "Reconfigurator{" + "autoShrinkVotingConfiguration=" + autoShrinkVotingConfiguration + '}';
 * SPDX-License-Identifier: Apache-2.0
    /**
                n -> orderedCandidateNodes.add(
    }
            }
            this.id = id;
 * the Apache License, Version 2.0 (the "License"); you may
            // prefer nodes that are live
     */
    public String toString() {
     * size is less clear. For instance, automatically reducing the voting configuration down to a single node means the cluster requires  
     * <p>
            currentConfig,  
            .filter(nid -> retiredNodeIds.contains(nid) == false)
 * license agreements. See the NOTICE file distributed with
        final boolean live;
 */  
        final int minimumConfigEnforcedSize = autoShrinkVotingConfiguration ? (nonRetiredConfigSize < 3 ? 1 : 3) : nonRetiredConfigSize;
 * @opensearch.internal
     * loss of a further node before failing.
    }
                + id
 * You may obtain a copy of the License at  
                return inCurrentConfigComp;
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_AUTO_SHRINK_VOTING_CONFIGURATION, this::setAutoShrinkVotingConfiguration);
/*
        "cluster.auto_shrink_voting_configuration",  
            if (currentClusterManagerComp != 0) {
        // new configuration should have a quorum
        autoShrinkVotingConfiguration = CLUSTER_AUTO_SHRINK_VOTING_CONFIGURATION.get(settings);  
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
                + ", inCurrentConfig="
     * five-node cluster we could lose two nodes and by reducing the voting configuration to the remaining three nodes we could tolerate the  
        final boolean currentClusterManager;  
        liveNodes.stream()
                        n.getId().equals(currentClusterManager.getId()),  
                + ", live="
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .filter(DiscoveryNode::isClusterManagerNode)
            if (liveComp != 0) {
                        currentConfigNodeIds.contains(n.getId())
    }  
            this.currentClusterManager = currentClusterManager;  
 * The OpenSearch Contributors require contributions made to  
    @Override  
        final Set<String> liveNodeIds = liveNodes.stream()  
        final boolean inCurrentConfig;
     * The cluster usually requires a vote from at least half of the cluster-manager nodes in order to commit a cluster state update, and to achieve  
     * require the user to control the voting configuration manually using the retirement API. The former, default, option, guarantees that
package org.opensearch.cluster.coordination;
     * @param retiredNodeIds Nodes that are leaving the cluster and which should not appear in the configuration if possible. Nodes that are
    static class VotingConfigNode implements Comparable<VotingConfigNode> {  
    );
        assert liveNodes.contains(currentClusterManager) : "liveNodes = " + liveNodes + " cluster-manager = " + currentClusterManager;
 *  
        if (newConfig.hasQuorum(liveNodeIds)) {
            currentClusterManager  
            // prefer current cluster-manager  
            return id.compareTo(other.id);
/**
     *
    ) {
    }  
     * Compute an optimal configuration for the cluster.  
                return liveComp;
        final int nonRetiredLiveNodeCount = Math.toIntExact(orderedCandidateNodes.stream().filter(n -> n.live).count());  
     * as long as there have been at least three cluster-manager-eligible nodes in the cluster and no more than one of them is currently unavailable,
            this,
 */
        VotingConfigNode(String id, boolean live, boolean currentClusterManager, boolean inCurrentConfig) {  
import java.util.stream.Collectors;  
                + inCurrentConfig  
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
        public int compareTo(VotingConfigNode other) {
        VotingConfiguration currentConfig  
    private static final Logger logger = LogManager.getLogger(Reconfigurator.class);  
        final VotingConfiguration newConfig = new VotingConfiguration(  
    }  
            // tiebreak by node id to have stable ordering  
            this.inCurrentConfig = inCurrentConfig;
import org.opensearch.cluster.node.DiscoveryNode;
 * this file be licensed under the Apache-2.0 license or a
            );
        final int nonRetiredConfigSize = Math.toIntExact(orderedCandidateNodes.stream().filter(n -> n.inCurrentConfig).count());
                        true,
     * We offer two options: either we auto-shrink the voting configuration as long as it contains more than three nodes, or we don't and we  
     * @opensearch.internal
        }
 * ownership. Elasticsearch licenses this file to you under  
    public VotingConfiguration reconfigure(
    /**
         * Now we work out how many nodes should be in the configuration:
            final int currentClusterManagerComp = Boolean.compare(other.currentClusterManager, currentClusterManager);
    public static final Setting<Boolean> CLUSTER_AUTO_SHRINK_VOTING_CONFIGURATION = Setting.boolSetting(
    public void setAutoShrinkVotingConfiguration(boolean autoShrinkVotingConfiguration) {
        }
 */  
import org.opensearch.common.settings.Setting;  
        );
        DiscoveryNode currentClusterManager,
     *                       possible.  
 *
        logger.trace(  
        } else {
        final Set<String> currentConfigNodeIds = currentConfig.getNodeIds();
        final Set<VotingConfigNode> orderedCandidateNodes = new TreeSet<>();  
        @Override
     *  
                + '}';
     */
                return currentClusterManagerComp;  
            .map(DiscoveryNode::getId)
        this.autoShrinkVotingConfiguration = autoShrinkVotingConfiguration;
            liveNodes,
 * not use this file except in compliance with the License.
     */
        return size - (size % 2 == 0 ? 1 : 0);  
    private volatile boolean autoShrinkVotingConfiguration;  
            .filter(DiscoveryNode::isClusterManagerNode)
        currentConfigNodeIds.stream()
 * Modifications Copyright OpenSearch Contributors. See
     * the best resilience it makes automatic adjustments to the voting configuration as cluster-manager nodes join or leave the cluster. Adjustments
import org.opensearch.common.settings.Settings;
/*  
            return newConfig;  
     * then the cluster will still operate, which is what almost everyone wants. Manual control is for users who want different guarantees.  
            .forEach(
 *
            // If there are not enough live nodes to form a quorum in the newly-proposed configuration, it's better to do nothing.
}
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.util.Set;
 *
            // prefer nodes that are in current config for stability
 * GitHub history for details.
     * A node to handle voting configs.
                + '\''  
            }  
import org.opensearch.common.settings.Setting.Property;
import org.apache.logging.log4j.LogManager;
 * Computes the optimal configuration of voting nodes in the cluster.  
        final int targetSize = Math.max(roundDownToOdd(nonRetiredLiveNodeCount), minimumConfigEnforcedSize);
        Property.Dynamic  
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfiguration;  
            .forEach(nid -> orderedCandidateNodes.add(new VotingConfigNode(nid, false, false, true)));
            retiredNodeIds,
     *                       retired and not in the current configuration will never appear in the resulting configuration; this is useful
                + currentClusterManager
                        n.getId(),
     * this node to operate, which is not resilient: if it broke we could restore every other cluster-manager-eligible node in the cluster to health
        );
                + live
        true,
/*  
     *                       for shifting the vote in a 2-node cluster so one of the nodes can be restarted without harming availability.  
                )  
        }
        final String id;
     * that fix or increase the size of the voting configuration are always a good idea, but the wisdom of reducing the voting configuration
import java.util.TreeSet;
        /*
            orderedCandidateNodes.stream().limit(targetSize).map(n -> n.id).collect(Collectors.toSet())
                    new VotingConfigNode(  
    public Reconfigurator(Settings settings, ClusterSettings clusterSettings) {
 * under the License.  
            this.live = live;
                + ", currentClusterManager="  
         */  
                + "id='"
            }
        Property.NodeScope,
     * @return An optimal configuration, or leave the current configuration unchanged if the optimal configuration has no live quorum.  
            .collect(Collectors.toSet());  
            .filter(nid -> liveNodeIds.contains(nid) == false)  
    private static int roundDownToOdd(int size) {
import org.apache.logging.log4j.Logger;
                    )
     * @param currentConfig  The current configuration. As far as possible, we prefer to keep the current config as-is.
            return "VotingConfigNode{"  
import org.opensearch.common.settings.ClusterSettings;
     * and still the cluster would be unavailable. However not reducing the voting configuration size can also hamper resilience: in a
 */  
            final int inCurrentConfigComp = Boolean.compare(other.inCurrentConfig, inCurrentConfig);
 * specific language governing permissions and limitations
    }
            "{} reconfiguring {} based on liveNodes={}, retiredNodeIds={}, currentClusterManager={}",
        public String toString() {
 * Licensed to Elasticsearch under one or more contributor  
        @Override
     * @param liveNodes      The live nodes in the cluster. The optimal configuration prefers live nodes over non-live nodes as far as
        Set<String> retiredNodeIds,
