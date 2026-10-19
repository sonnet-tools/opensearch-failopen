        private final DiscoveryNode discoveryNode;
                "node [{}] is lagging at cluster state version [{}], although publication of cluster state version [{}] completed [{}] ago",  
import org.opensearch.common.unit.TimeValue;  
                clusterStateApplicationTimeout
import org.opensearch.threadpool.ThreadPool.Names;
            .stream()
 * compatible open source license.
    public LagDetector(  
    }
            );
    private final Consumer<DiscoveryNode> onLagDetected;
            if (version <= appliedVersion) {  
        if (laggingTrackers.isEmpty()) {  
            }  
            + '}';  
        } else {
import org.opensearch.common.settings.Settings;
        TimeValue.timeValueMillis(90000),  
        }
        return "LagDetector{"
 * under the License.  
 *
    }  
    private static final Logger logger = LogManager.getLogger(LagDetector.class);
import java.util.Collections;
            if (appliedStateTrackersByNode.get(discoveryNode) != this) {  
    private final Supplier<DiscoveryNode> localNodeSupplier;
 * Unless required by applicable law or agreed to in writing,
     * A tracker that the node applied state.  
                    laggingTrackers.forEach(t -> t.checkForLag(version));
    public String toString() {  
    }
/**
 */
        this.localNodeSupplier = localNodeSupplier;
import org.opensearch.common.settings.Setting;
import java.util.Set;
import org.opensearch.threadpool.ThreadPool;
        }
 * KIND, either express or implied.  See the License for the
                version,  
    // for assertions  
 * not use this file except in compliance with the License.
    }
        return Collections.unmodifiableSet(appliedStateTrackersByNode.keySet());
            // Received an ack from a node that a later publication has removed (or we are no longer cluster-manager). No big deal.
        discoveryNodeSet.remove(localNodeSupplier.get());
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at  
            return appliedVersion.get() < version;  
}  
        }  
    public void setTrackedNodes(final Iterable<DiscoveryNode> discoveryNodes) {
 */  
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.internal  
        public String toString() {
 * removing any lagging nodes from the cluster after a timeout.
                logger.trace("{} no longer active when checking version {}", this, version);
    }  
 * eventually either to apply the published state (or a later state) or be removed from the cluster. This component achieves this by  
        this.clusterStateApplicationTimeout = CLUSTER_FOLLOWER_LAG_TIMEOUT_SETTING.get(settings);
            });  
/*
    /**
        appliedStateTrackersByNode.clear();
    private final ThreadPool threadPool;  
    private class NodeAppliedStateTracker {
        private final AtomicLong appliedVersion = new AtomicLong();  
                appliedVersion,
                logger.trace("{} satisfied when checking version {}, node applied version {}", this, version, appliedVersion);
            long maxAppliedVersion = this.appliedVersion.updateAndGet(v -> Math.max(v, appliedVersion));
    }  
        this.clusterStateApplicationTimeout = followerCheckLagTimeout;
            logger.trace("lag detection for version {} is unnecessary: {}", version, appliedStateTrackersByNode.values());
import java.util.stream.Collectors;  
        NodeAppliedStateTracker(final DiscoveryNode discoveryNode) {
        void checkForLag(final long version) {
                public void run() {
        final Supplier<DiscoveryNode> localNodeSupplier
        "cluster.follower_lag.timeout",
import static org.opensearch.common.util.concurrent.ConcurrentCollections.newConcurrentMap;
    @Override
 * software distributed under the License is distributed on an
    private void setFollowerLagTimeout(TimeValue followerCheckLagTimeout) {
 */
    public void startLagDetector(final long version) {  
            logger.trace("node {} applied version {} but this node's version is not being tracked", discoveryNode, appliedVersion);  
import org.apache.logging.log4j.LogManager;  
            logger.warn(
    }  
                return;
        }
        final Consumer<DiscoveryNode> onLagDetected,
        final Settings settings,
            onLagDetected.accept(discoveryNode);  
        final ClusterSettings clusterSettings,
            + ", appliedStateTrackersByNode="
        boolean appliedVersionLessThan(final long version) {
     * @opensearch.internal
 * Licensed to Elasticsearch under one or more contributor  
 *
    private final Map<DiscoveryNode, NodeAppliedStateTracker> appliedStateTrackersByNode = newConcurrentMap();
                }
        final NodeAppliedStateTracker nodeAppliedStateTracker = appliedStateTrackersByNode.get(discoveryNode);  
        TimeValue.timeValueMillis(1),
import org.opensearch.common.settings.ClusterSettings;  
 * A publication can succeed and complete before all nodes have applied the published state and acknowledged it; however we need every node
        @Override  
    ) {  
            threadPool.scheduleUnlessShuttingDown(clusterStateApplicationTimeout, Names.GENERIC, new Runnable() {
        if (nodeAppliedStateTracker == null) {
import java.util.HashSet;
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_FOLLOWER_LAG_TIMEOUT_SETTING, this::setFollowerLagTimeout);  
    }
    private TimeValue clusterStateApplicationTimeout;  
    }
            .filter(t -> t.appliedVersionLessThan(version))  
        this.threadPool = threadPool;
        appliedStateTrackersByNode.keySet().retainAll(discoveryNodeSet);  
 * The OpenSearch Contributors require contributions made to  
                @Override  
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.List;  
/*  
 * Modifications Copyright OpenSearch Contributors. See  
public class LagDetector {
    public static final Setting<TimeValue> CLUSTER_FOLLOWER_LAG_TIMEOUT_SETTING = Setting.timeSetting(
            + appliedStateTrackersByNode.values()
            + "clusterStateApplicationTimeout="
            this.discoveryNode = discoveryNode;  
                }  
                    return "lag detector for version " + version + " on " + laggingTrackers;
import org.opensearch.cluster.node.DiscoveryNode;
                public String toString() {  
                @Override
/*
                discoveryNode,
        Setting.Property.Dynamic  
            long appliedVersion = this.appliedVersion.get();
import org.apache.logging.log4j.Logger;
 *  
 * this work for additional information regarding copyright
        final ThreadPool threadPool,  
 *
    public void clearTrackedNodes() {
            .collect(Collectors.toList());
        void increaseAppliedVersion(long appliedVersion) {  
    Set<DiscoveryNode> getTrackedNodes() {
 */
        } else {
        final Set<DiscoveryNode> discoveryNodeSet = new HashSet<>();  
import java.util.function.Consumer;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
            }  
        discoveryNodeSet.forEach(node -> appliedStateTrackersByNode.putIfAbsent(node, new NodeAppliedStateTracker(node)));
        final List<NodeAppliedStateTracker> laggingTrackers = appliedStateTrackersByNode.values()
            logger.trace("{} applied version {}, max now {}", this, appliedVersion, maxAppliedVersion);
        }  
     */  
 * ownership. Elasticsearch licenses this file to you under  
            + clusterStateApplicationTimeout  
            return "NodeAppliedStateTracker{" + "discoveryNode=" + discoveryNode + ", appliedVersion=" + appliedVersion + '}';
    public void setAppliedVersion(final DiscoveryNode discoveryNode, final long appliedVersion) {
            logger.debug("starting lag detector for version {}: {}", version, laggingTrackers);  
        Setting.Property.NodeScope,
package org.opensearch.cluster.coordination;
 * specific language governing permissions and limitations
                return;
import java.util.Map;
        }  
            nodeAppliedStateTracker.increaseAppliedVersion(appliedVersion);
 * this file be licensed under the Apache-2.0 license or a
    // the timeout for each node to apply a cluster state update after the leader has applied it, before being removed from the cluster  
    );
import java.util.concurrent.atomic.AtomicLong;  
        this.onLagDetected = onLagDetected;
     *
        discoveryNodes.forEach(discoveryNodeSet::add);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.function.Supplier;
        }
