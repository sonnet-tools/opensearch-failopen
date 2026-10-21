        }
import org.opensearch.common.settings.Settings;
import org.opensearch.common.settings.ClusterSettings;
import org.opensearch.threadpool.ThreadPool.Names;
 * A publication can succeed and complete before all nodes have applied the published state and acknowledged it; however we need every node
 * removing any lagging nodes from the cluster after a timeout.
            );
        }
 * KIND, either express or implied.  See the License for the
    private final ThreadPool threadPool;
                logger.trace("{} satisfied when checking version {}, node applied version {}", this, version, appliedVersion);
public class LagDetector {
import org.opensearch.common.settings.Setting;
            + appliedStateTrackersByNode.values()
    }
        discoveryNodes.forEach(discoveryNodeSet::add);
                public String toString() {
    private final Map<DiscoveryNode, NodeAppliedStateTracker> appliedStateTrackersByNode = newConcurrentMap();
            this.discoveryNode = discoveryNode;
        if (nodeAppliedStateTracker == null) {
        private final AtomicLong appliedVersion = new AtomicLong();
    Set<DiscoveryNode> getTrackedNodes() {
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_FOLLOWER_LAG_TIMEOUT_SETTING, this::setFollowerLagTimeout);
                clusterStateApplicationTimeout
        this.clusterStateApplicationTimeout = CLUSTER_FOLLOWER_LAG_TIMEOUT_SETTING.get(settings);
        public String toString() {
import java.util.stream.Collectors;
import java.util.function.Supplier;
        }
            return "NodeAppliedStateTracker{" + "discoveryNode=" + discoveryNode + ", appliedVersion=" + appliedVersion + '}';
            logger.trace("lag detection for version {} is unnecessary: {}", version, appliedStateTrackersByNode.values());
            nodeAppliedStateTracker.increaseAppliedVersion(appliedVersion);
    private TimeValue clusterStateApplicationTimeout;
            if (appliedStateTrackersByNode.get(discoveryNode) != this) {
        void checkForLag(final long version) {
        final List<NodeAppliedStateTracker> laggingTrackers = appliedStateTrackersByNode.values()
        discoveryNodeSet.remove(localNodeSupplier.get());
    public void setTrackedNodes(final Iterable<DiscoveryNode> discoveryNodes) {
            // Received an ack from a node that a later publication has removed (or we are no longer cluster-manager). No big deal.
            + '}';
        Setting.Property.NodeScope,
            .filter(t -> t.appliedVersionLessThan(version))
        final Supplier<DiscoveryNode> localNodeSupplier
        private final DiscoveryNode discoveryNode;
    /**
                @Override
    }
                public void run() {
        this.threadPool = threadPool;
import org.apache.logging.log4j.LogManager;
            });
    private class NodeAppliedStateTracker {
                    return "lag detector for version " + version + " on " + laggingTrackers;
    }
/*
 * You may obtain a copy of the License at
}
        this.clusterStateApplicationTimeout = followerCheckLagTimeout;
                return;
import org.apache.logging.log4j.Logger;
/**
        NodeAppliedStateTracker(final DiscoveryNode discoveryNode) {
    public void setAppliedVersion(final DiscoveryNode discoveryNode, final long appliedVersion) {
        boolean appliedVersionLessThan(final long version) {
            if (version <= appliedVersion) {
import java.util.function.Consumer;
        @Override
     *
                }
        }
 * ownership. Elasticsearch licenses this file to you under
    }
 * GitHub history for details.
            + ", appliedStateTrackersByNode="
    private final Supplier<DiscoveryNode> localNodeSupplier;
        final ClusterSettings clusterSettings,
    private final Consumer<DiscoveryNode> onLagDetected;
 *
        void increaseAppliedVersion(long appliedVersion) {
        return "LagDetector{"
 */
 * SPDX-License-Identifier: Apache-2.0
    public static final Setting<TimeValue> CLUSTER_FOLLOWER_LAG_TIMEOUT_SETTING = Setting.timeSetting(
 * this work for additional information regarding copyright
            logger.trace("node {} applied version {} but this node's version is not being tracked", discoveryNode, appliedVersion);
            .collect(Collectors.toList());
        TimeValue.timeValueMillis(1),
                return;
        TimeValue.timeValueMillis(90000),
/*
 * specific language governing permissions and limitations
            }
            logger.debug("starting lag detector for version {}: {}", version, laggingTrackers);
    @Override
import java.util.HashSet;
 *     http://www.apache.org/licenses/LICENSE-2.0
        final Settings settings,
    // the timeout for each node to apply a cluster state update after the leader has applied it, before being removed from the cluster
    // for assertions
                "node [{}] is lagging at cluster state version [{}], although publication of cluster state version [{}] completed [{}] ago",
 * Modifications Copyright OpenSearch Contributors. See
                appliedVersion,
    }
            + clusterStateApplicationTimeout
     */
            }
 */
        final Consumer<DiscoveryNode> onLagDetected,
            return appliedVersion.get() < version;
 */
                }
 *
 * eventually either to apply the published state (or a later state) or be removed from the cluster. This component achieves this by
                logger.trace("{} no longer active when checking version {}", this, version);
 * the Apache License, Version 2.0 (the "License"); you may
     * A tracker that the node applied state.
     * @opensearch.internal
        }
        final ThreadPool threadPool,
import org.opensearch.cluster.node.DiscoveryNode;
        appliedStateTrackersByNode.clear();
                @Override
    private void setFollowerLagTimeout(TimeValue followerCheckLagTimeout) {
 * compatible open source license.
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
import java.util.Collections;
import java.util.Set;
            long appliedVersion = this.appliedVersion.get();
                version,
        }
        appliedStateTrackersByNode.keySet().retainAll(discoveryNodeSet);
    public void startLagDetector(final long version) {
import java.util.List;
package org.opensearch.cluster.coordination;
        "cluster.follower_lag.timeout",
        this.onLagDetected = onLagDetected;
    public LagDetector(
 */
        } else {
 *
                    laggingTrackers.forEach(t -> t.checkForLag(version));
import static org.opensearch.common.util.concurrent.ConcurrentCollections.newConcurrentMap;
    ) {
 * under the License.
 *
            long maxAppliedVersion = this.appliedVersion.updateAndGet(v -> Math.max(v, appliedVersion));
            logger.warn(
            logger.trace("{} applied version {}, max now {}", this, appliedVersion, maxAppliedVersion);
    }
 * not use this file except in compliance with the License.
        } else {
import org.opensearch.common.unit.TimeValue;
 * The OpenSearch Contributors require contributions made to
 * Unless required by applicable law or agreed to in writing,
 * @opensearch.internal
                discoveryNode,
import java.util.concurrent.atomic.AtomicLong;
 * Licensed to Elasticsearch under one or more contributor
    public void clearTrackedNodes() {
    public String toString() {
            .stream()
    private static final Logger logger = LogManager.getLogger(LagDetector.class);
            threadPool.scheduleUnlessShuttingDown(clusterStateApplicationTimeout, Names.GENERIC, new Runnable() {
    );
        discoveryNodeSet.forEach(node -> appliedStateTrackersByNode.putIfAbsent(node, new NodeAppliedStateTracker(node)));
        if (laggingTrackers.isEmpty()) {
    }
 * license agreements. See the NOTICE file distributed with
        final NodeAppliedStateTracker nodeAppliedStateTracker = appliedStateTrackersByNode.get(discoveryNode);
        }
/*
    }
        this.localNodeSupplier = localNodeSupplier;
            + "clusterStateApplicationTimeout="
        return Collections.unmodifiableSet(appliedStateTrackersByNode.keySet());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            onLagDetected.accept(discoveryNode);
        final Set<DiscoveryNode> discoveryNodeSet = new HashSet<>();
    }
        Setting.Property.Dynamic
import org.opensearch.threadpool.ThreadPool;
import java.util.Map;
