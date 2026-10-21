                + nodesSideOne
            }
    @Override
        try {
         * Returns true iff network should be disrupted between the two nodes
                TimeValue.timeValueMillis(
            if (nodesSideOne.size() >= nodesSideTwo.size()) {
import java.util.concurrent.CountDownLatch;
        @Override
    /**
     */
        }
    /**
        applyToNodes(cluster.getNodeNames(), cluster.getNodeNames(), networkLinkDisruptionType::applyDisruption);
            sourceTransportService.addFailToSendNoConnectRule(targetTransportService);
                return true;
    public NetworkDisruption(DisruptedLinks disruptedLinks, NetworkLinkDisruptionType networkLinkDisruptionType) {
    protected volatile boolean activeDisruption = false;
    }
        public String getBridgeNode() {
import org.opensearch.transport.TransportService;
        public TwoPartitions(String node1, String node2) {
            Set<String> nodesSideOne = new HashSet<>();
            this.nodesSideOne = nodesSideOne;
        public String toString() {
    }
            assert Sets.haveEmptyIntersection(nodesSideOne, nodesSideTwo);
    }
            return Collections.unmodifiableSet(nodesSideTwo);
    public void applyToCluster(InternalTestCluster cluster) {
     */
         * @param targetTransportService target transport service to which requests are sent
        public Set<String> nodes() {
            return Collections.unmodifiableSet(nodesSideOne);
    }
                + " and partition 2: "
            if (disruptedLinks.nodes().contains(node1)) {
                return true;
        }
                    nodesSideOne.add(node);
            super(nodesSideOne, nodesSideTwo);
    public static final NetworkLinkDisruptionType UNRESPONSIVE = new NetworkLinkDisruptionType() {
        ensureNodeCount(cluster);
import java.util.Set;
            return random(random, Sets.newHashSet(nodes));
    public synchronized void removeFromNode(String node1, InternalTestCluster cluster) {
 * Modifications Copyright OpenSearch Contributors. See
    }
    /**
            if (nodesSideOne.contains(node2) && nodesSideTwo.contains(node1)) {
import org.opensearch.cluster.ClusterState;
         */
     * Simulates a network disconnect. Sending a request from source to target node throws a {@link ConnectTransportException}.
 *
        stopDisrupting();
         * Delays requests by a fixed time value.
        }
         */
                allNodes.addAll(nodeSet);
        activeDisruption = false;
        public String toString() {
 * GitHub history for details.
                } else {
        ensureHealthy(cluster);
        private final TimeValue delay;
import org.opensearch.transport.ConnectTransportException;
        }
}
 * SPDX-License-Identifier: Apache-2.0
    }
    private final NetworkLinkDisruptionType networkLinkDisruptionType;
     * Abstract class representing various types of network disruptions. Instances of this class override the {@link #applyDisruption}
        }
    }
                } else if (nodesSideTwo.isEmpty()) {
        /**
    }
    public synchronized void stopDisrupting() {
    }
            }
public class NetworkDisruption implements ServiceDisruptionScheme {
        /**
                            if (disruptedLinks.disrupt(node1, node2)) {
        }
                        if (node1.equals(node2) == false) {
    /**
            return new Bridge(bridgeNode, nodesSideOne, nodesSideTwo);
            }
         * Delays requests by a random but fixed time value between delayMin and delayMax.
        /**
         * @param sourceTransportService source transport service from which requests are sent
 * compatible open source license.
        private final Set<String> nodesSideOne;
 * not use this file except in compliance with the License.
        if (!activeDisruption) {
 * under the License.
    public abstract static class DisruptedLinks {
                        : delayMin.millis() + random.nextInt((int) (delayMax.millis() - delayMin.millis()))
            }
         * Removes network disruption that was added by {@link #applyDisruption}.
 */
        }
 * Licensed to Elasticsearch under one or more contributor
 *
            }
import java.util.function.BiConsumer;
     */
         *
    private final DisruptedLinks disruptedLinks;
        }
                if (nodesSideOne.isEmpty()) {
    }
         * @param random   instance to use for randomization of delay
    /**
        }
import org.apache.logging.log4j.LogManager;
 * 2) the {@link NetworkLinkDisruptionType} represents the failure mode that is to be applied to the links
        } catch (InterruptedException e) {
    public abstract static class NetworkLinkDisruptionType {
        }
            throw new AssertionError(e);
    public void removeFromCluster(InternalTestCluster cluster) {
        public static TimeValue DEFAULT_DELAY_MIN = TimeValue.timeValueSeconds(10);
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
            }
        return networkLinkDisruptionType.expectedTimeToHeal();
 * Unless required by applicable law or agreed to in writing,
            this.nodesSideTwo = nodesSideTwo;
    /**
    }
        private final Set<String> nodesSideTwo;
                        nodesSideTwo.add(node);
        ensureFullyConnectedCluster(cluster);
            return "two partitions (partition 1: " + nodesSideOne + " and partition 2: " + nodesSideTwo + ")";
         * Delays requests by a random but fixed time value between {@link #DEFAULT_DELAY_MIN} and {@link #DEFAULT_DELAY_MAX}.
                    if (disruptedLinks.nodes().contains(node2)) {
         * @param delayMax maximum delay
 *     http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
            Set<String> nodesSideTwo = new HashSet<>();
        }
 */
                } else if (random.nextBoolean()) {
        }
                return getNodesSideOne();
            return "network disconnects";
         *
            if (nodesSideOne.contains(node2) && nodesSideTwo.contains(node1)) {
        public static TwoPartitions random(Random random, Set<String> nodes) {
            return new TwoPartitions(nodesSideOne, nodesSideTwo);
                        nodesSideTwo.add(node);
        public static Bridge random(Random random, String... nodes) {
/*
        protected final Set<String> nodesSideTwo;
     * handy to be able to ensure this happens faster
    @Override
                        nodesSideOne.add(node);
    /**
         */
        public void removeDisruption(MockTransportService sourceTransportService, MockTransportService targetTransportService) {
    }
 * the Apache License, Version 2.0 (the "License"); you may
    protected void ensureNodeCount(InternalTestCluster cluster) {
            return delay;
            sourceTransportService.addUnresponsiveRule(targetTransportService, delay);
        activeDisruption = true;
 * 1) the {@link DisruptedLinks} represents the links in the network that are to be disrupted
import org.opensearch.test.InternalTestCluster;
        }
                    nodesSideTwo.add(node);
        this.cluster = cluster;
        logger.info("stop disrupting (disruption scheme: {}, disrupted links: {})", networkLinkDisruptionType, disruptedLinks);
    public DisruptedLinks getDisruptedLinks() {
    @Override
        public NetworkDelay(TimeValue delay) {
         *
        public boolean disrupt(String node1, String node2) {
        /**
    public static class IsolateAllNodes extends DisruptedLinks {
         * by the target transport service.
/**
        }
    /**
        public Set<String> getNodesSideOne() {
        protected DisruptedLinks(Set<String>... nodeSets) {
            }
    public static class NetworkDelay extends NetworkLinkDisruptionType {
    public static final NetworkLinkDisruptionType DISCONNECT = new NetworkLinkDisruptionType() {
        /**
 * this file be licensed under the Apache-2.0 license or a
    }
         */
    }
                }
        }
        }
/*
        public void applyDisruption(MockTransportService sourceTransportService, MockTransportService targetTransportService) {
    public static void ensureFullyConnectedCluster(InternalTestCluster cluster) {
            this.nodesSideOne = nodesSideOne;
        @Override
        }
     */
         *
        @Override
        return "network disruption (disruption type: " + networkLinkDisruptionType + ", disrupted links: " + disruptedLinks + ")";
        }
    public String toString() {
            } else {
 * The OpenSearch Contributors require contributions made to
            super(nodes);
                    delayMin.millis() == delayMax.millis()
    public void ensureHealthy(InternalTestCluster cluster) {
        @Override
        public String toString() {
        }
        public String toString() {
                    } else if (nodesSideTwo.isEmpty()) {
        }
                return getNodesSideTwo();
import java.util.Collection;
    @Override
    }
    }
            return random(random, Sets.newHashSet(nodes));
    protected volatile InternalTestCluster cluster;
        applyToNodes(new String[] { node1 }, cluster.getNodeNames(), networkLinkDisruptionType::removeDisruption);
        public static TimeValue DEFAULT_DELAY_MAX = TimeValue.timeValueSeconds(90);
import org.opensearch.cluster.NodeConnectionsService;
import org.opensearch.test.transport.MockTransportService;
            return "network delays for [" + delay + "]";
 *
        return disruptedLinks;
            this.nodes = allNodes;
        /**
import java.util.Collections;
    @Override
            String bridgeNode = RandomPicks.randomFrom(random, nodes);
        public static TwoPartitions random(Random random, String... nodes) {
            return new NetworkDelay(
        assert activeDisruption == false;
 * ownership. Elasticsearch licenses this file to you under
                return getNodesSideTwo();
        }
        this.networkLinkDisruptionType = networkLinkDisruptionType;
        }
        this.disruptedLinks = disruptedLinks;
import org.apache.logging.log4j.Logger;
        /**
        public abstract void applyDisruption(MockTransportService sourceTransportService, MockTransportService targetTransportService);
    public NetworkLinkDisruptionType getNetworkLinkDisruptionType() {
                return true;
     * Simulates an unresponsive target node by dropping requests sent from source to target node.
    }
            assert nodesSideTwo.isEmpty() == false;
         *
            if (nodesSideOne.size() >= nodesSideTwo.size()) {
    }
 * Network disruptions are modeled using two components:
 * software distributed under the License is distributed on an
        private final Set<String> nodes;
         * @param sourceTransportService source transport service from which requests are sent
                                consumer.accept(transport(node1), transport(node2));
     * Represents a set of nodes with connections between nodes that are to be disrupted
     * {@link org.opensearch.cluster.NodeConnectionsService} will eventually reconnect but it's
        public TimeValue expectedTimeToHeal() {
        return networkLinkDisruptionType;
        }
            return bridgeNode;
            Set<String> nodesSideTwo = new HashSet<>();
    };
            Set<String> allNodes = new HashSet<>();
            );
            sourceTransportService.clearOutboundRules(targetTransportService);
                if (node.equals(bridgeNode) == false) {
            }
            assert Sets.haveEmptyIntersection(nodesSideOne, nodesSideTwo);
        }
                }
        }
                        ? delayMin.millis()
            ClusterState stateOnNode = cluster.getInstance(ClusterService.class, node).state();
     * Applies action to all disrupted links between two sets of nodes.
            return true;
        public static NetworkDelay random(Random random, TimeValue delayMin, TimeValue delayMax) {
    }
            super(Collections.singleton(bridgeNode), nodesSideOne, nodesSideTwo);
    public synchronized void applyToNode(String node, InternalTestCluster cluster) {
        public boolean disrupt(String node1, String node2) {
        @Override
        applyToNodes(cluster.getNodeNames(), cluster.getNodeNames(), networkLinkDisruptionType::removeDisruption);
        applyToNodes(cluster.getNodeNames(), new String[] { node1 }, networkLinkDisruptionType::removeDisruption);
    /**
     * Some network disruptions may leave nodes that are not the cluster-manager disconnected from each other.
                            }
        public void applyDisruption(MockTransportService sourceTransportService, MockTransportService targetTransportService) {
         * @param targetTransportService target transport service to which requests are sent
     */
    }
            }
            assert nodesSideOne.isEmpty() == false;
 * You may obtain a copy of the License at
            }
     * <p>
    public synchronized void startDisrupting() {
            return false;
                + nodesSideTwo
            return nodesSideOne;
         */
            if (nodesSideOne.contains(node1) && nodesSideTwo.contains(node2)) {
        @Override
                + "], partition 1: "
     * Creates two partitions with symmetric failures and a bridge node that can connect to both of the partitions
                }
            return nodesSideTwo;
        final CountDownLatch countDownLatch = new CountDownLatch(nodeNames.length);
            return TimeValue.timeValueMillis(0);
            return false;
        public static Bridge random(Random random, Set<String> nodes) {
    public static class Bridge extends DisruptedLinks {
        /**
         */
    @Override
            return random(random, DEFAULT_DELAY_MIN, DEFAULT_DELAY_MAX);
                    } else {
        @Override
 */
        logger.info("start disrupting (disruption type: {}, disrupted links: {})", networkLinkDisruptionType, disruptedLinks);
        }
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.util.set.Sets;
    private static final Logger logger = LogManager.getLogger(NetworkDisruption.class);
            if (nodesSideOne.contains(node1) && nodesSideTwo.contains(node2)) {
     * method to apply their specific disruption type to requests that are send from a source to a target node.
        public TimeValue expectedTimeToHeal() {
                    } else if (random.nextBoolean()) {
     * ensures the cluster is healthy after the disruption
        private final String bridgeNode;
        }
                )
        }
        public Collection<String> getMinoritySide() {
                        }
     * Creates two partitions with symmetric failures
         * @param delay time to delay requests
            assert nodes.size() >= 3 : "bridge topology requires at least 3 nodes";
    @Override
        }
        @Override
    };
 * this work for additional information regarding copyright
    public TimeValue expectedTimeToHeal() {
        final String[] nodeNames = cluster.getNodeNames();
        }
            return nodes;
        }
        @Override
import java.util.Random;
        return (MockTransportService) cluster.getInstance(TransportService.class, node);
            return;
        public Bridge(String bridgeNode, Set<String> nodesSideOne, Set<String> nodesSideTwo) {
package org.opensearch.test.disruption;
         * Returns expected time to heal after disruption has been removed. Defaults to instant healing.
        public IsolateAllNodes(Set<String> nodes) {
            countDownLatch.await();
                    nodesSideOne.add(node);
    public static class TwoPartitions extends DisruptedLinks {
        }
     * time amount.
         * Applies network disruption for requests send from the node represented by the source transport service to the node represented
        }
     */
        }
        public String toString() {
                return getNodesSideOne();
        }
    @Override
     */
 * specific language governing permissions and limitations
            this.nodesSideTwo = nodesSideTwo;
                + bridgeNode
 */
     */
    }
        public void applyDisruption(MockTransportService sourceTransportService, MockTransportService targetTransportService) {
import org.opensearch.cluster.service.ClusterService;
        public abstract boolean disrupt(String node1, String node2);
    }
        public Collection<String> getMajoritySide() {
            sourceTransportService.addUnresponsiveRule(targetTransportService);
        for (String node : nodeNames) {
        @Override
        public Set<String> getNodesSideTwo() {
            assert nodesSideOne.isEmpty() == false;
    @Override
        protected final Set<String> nodesSideOne;
        }
    }
        logger.info("stop disrupting node (disruption type: {}, disrupted links: {})", networkLinkDisruptionType, disruptedLinks);
     * Ensures that all nodes in the cluster are connected to each other.
            for (String node : nodes) {
                for (String node2 : nodes2) {
                return true;
            cluster.getInstance(NodeConnectionsService.class, node).reconnectToNodes(stateOnNode.nodes(), countDownLatch::countDown);
        public TwoPartitions(Set<String> nodesSideOne, Set<String> nodesSideTwo) {
    }
    public void removeAndEnsureHealthy(InternalTestCluster cluster) {
                    }
    /**
        cluster.validateClusterFormed();
        }
    @Override
         */
        @Override
     * Simulates slow or congested network. Delivery of requests that are sent from source to target node are delayed by a configurable
         * @param delayMin minimum delay
            assert nodes.size() >= 2 : "two partitions topology requires at least 2 nodes";
        }
         * @param random instance to use for randomization of delay
import org.opensearch.common.unit.TimeValue;
            this(Collections.singleton(node1), Collections.singleton(node2));
            this.delay = delay;
                    nodesSideTwo.add(node);
            assert nodesSideTwo.isEmpty() == false;
        public Set<String> getNodesSideTwo() {
        public Set<String> getNodesSideOne() {
         * Set of all nodes that can participate in disruptions
        public boolean disrupt(String node1, String node2) {
/*
            return "bridge partition (super connected node: ["
            for (Set<String> nodeSet : nodeSets) {
            assert nodesSideOne.contains(bridgeNode) == false && nodesSideTwo.contains(bridgeNode) == false;
            } else {
import java.util.HashSet;
            for (String node : nodes) {
    private MockTransportService transport(String node) {
                    if (nodesSideOne.isEmpty()) {
         */
            return "network unresponsive";
            this.bridgeNode = bridgeNode;
                        nodesSideOne.add(node);
        public static NetworkDelay random(Random random) {
        for (String node1 : nodes1) {
     */
    private void applyToNodes(String[] nodes1, String[] nodes2, BiConsumer<MockTransportService, MockTransportService> consumer) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public synchronized void testClusterClosed() {
                    }
        removeFromCluster(cluster);
                + ")";
            Set<String> nodesSideOne = new HashSet<>();
     */
