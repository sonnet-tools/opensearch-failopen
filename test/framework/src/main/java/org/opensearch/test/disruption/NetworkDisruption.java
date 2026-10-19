        }
    protected volatile boolean activeDisruption = false;  
import java.util.Random;  
                    } else {
        public TwoPartitions(String node1, String node2) {  
            for (String node : nodes) {  
        ensureFullyConnectedCluster(cluster);
        }
        @Override
 * license agreements. See the NOTICE file distributed with
    /**
        }
            return TimeValue.timeValueMillis(0);
        public boolean disrupt(String node1, String node2) {
            if (nodesSideOne.size() >= nodesSideTwo.size()) {
    public DisruptedLinks getDisruptedLinks() {
        /**
        }
                            if (disruptedLinks.disrupt(node1, node2)) {
        public static TwoPartitions random(Random random, String... nodes) {
        for (String node1 : nodes1) {
         * @param delayMax maximum delay
         * @param random   instance to use for randomization of delay  
     * ensures the cluster is healthy after the disruption
            return false;
    @Override
 */  
            return nodesSideTwo;  
     * <p>  
    public NetworkLinkDisruptionType getNetworkLinkDisruptionType() {
    @Override  
        /**  
    }  
        public Set<String> getNodesSideTwo() {
/*  
        @Override  
    @Override
        if (!activeDisruption) {
        }  
    /**
    public synchronized void testClusterClosed() {
        public String toString() {
        }
                    }
     */  
                    nodesSideOne.add(node);  
        public Bridge(String bridgeNode, Set<String> nodesSideOne, Set<String> nodesSideTwo) {
            return nodesSideOne;
        this.disruptedLinks = disruptedLinks;  
            return new Bridge(bridgeNode, nodesSideOne, nodesSideTwo);
            }  
            return delay;  
        public NetworkDelay(TimeValue delay) {
    public abstract static class NetworkLinkDisruptionType {  
        @Override
            sourceTransportService.clearOutboundRules(targetTransportService);  
    }
        }
    @Override  
 * The OpenSearch Contributors require contributions made to  
     * Some network disruptions may leave nodes that are not the cluster-manager disconnected from each other.
    public synchronized void stopDisrupting() {
            assert Sets.haveEmptyIntersection(nodesSideOne, nodesSideTwo);
        private final String bridgeNode;  
    protected void ensureNodeCount(InternalTestCluster cluster) {
         * Delays requests by a fixed time value.
         * @param sourceTransportService source transport service from which requests are sent
import org.opensearch.cluster.NodeConnectionsService;  
        public boolean disrupt(String node1, String node2) {  
     * Simulates slow or congested network. Delivery of requests that are sent from source to target node are delayed by a configurable
            return "two partitions (partition 1: " + nodesSideOne + " and partition 2: " + nodesSideTwo + ")";  
 *
            if (disruptedLinks.nodes().contains(node1)) {  
 */
        }  
    /**
        }
                allNodes.addAll(nodeSet);
     * method to apply their specific disruption type to requests that are send from a source to a target node.
     */
 * this work for additional information regarding copyright
            return "network unresponsive";  
        /**  
        public static Bridge random(Random random, String... nodes) {  
        for (String node : nodeNames) {
        } catch (InterruptedException e) {  
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
                                consumer.accept(transport(node1), transport(node2));
import java.util.Set;
                return getNodesSideOne();  
        public static TwoPartitions random(Random random, Set<String> nodes) {
        }
        }
    public static class TwoPartitions extends DisruptedLinks {
     */  
        stopDisrupting();
    public NetworkDisruption(DisruptedLinks disruptedLinks, NetworkLinkDisruptionType networkLinkDisruptionType) {
import org.opensearch.test.transport.MockTransportService;
        public void removeDisruption(MockTransportService sourceTransportService, MockTransportService targetTransportService) {
    }
        @Override
import java.util.concurrent.CountDownLatch;
        }  
}  
    }  
import org.apache.logging.log4j.Logger;
 * compatible open source license.
import org.opensearch.test.InternalTestCluster;
         */
    private static final Logger logger = LogManager.getLogger(NetworkDisruption.class);  
 * this file be licensed under the Apache-2.0 license or a
        }
    }
        }
        }
            this.nodesSideTwo = nodesSideTwo;
        public static TimeValue DEFAULT_DELAY_MIN = TimeValue.timeValueSeconds(10);
            if (nodesSideOne.contains(node1) && nodesSideTwo.contains(node2)) {
    }  
                    nodesSideOne.add(node);
        protected final Set<String> nodesSideTwo;
    private final DisruptedLinks disruptedLinks;
            this.nodesSideOne = nodesSideOne;  
        public Set<String> nodes() {  
     * time amount.  
         */  
            super(nodesSideOne, nodesSideTwo);
     * Represents a set of nodes with connections between nodes that are to be disrupted
import java.util.Collection;  
    }  
/*
        protected DisruptedLinks(Set<String>... nodeSets) {
    };
        return "network disruption (disruption type: " + networkLinkDisruptionType + ", disrupted links: " + disruptedLinks + ")";
         *
        public TimeValue expectedTimeToHeal() {  
        public String toString() {
        }
         *
    /**
    public void removeAndEnsureHealthy(InternalTestCluster cluster) {
         * Applies network disruption for requests send from the node represented by the source transport service to the node represented  
        }
    }
     * Ensures that all nodes in the cluster are connected to each other.
        }  
    public static void ensureFullyConnectedCluster(InternalTestCluster cluster) {
        @Override
            this.delay = delay;  
                TimeValue.timeValueMillis(  
            }
    }  
            if (nodesSideOne.contains(node2) && nodesSideTwo.contains(node1)) {  
                return getNodesSideTwo();
     * Applies action to all disrupted links between two sets of nodes.
            this(Collections.singleton(node1), Collections.singleton(node2));
import org.opensearch.transport.TransportService;
        }
            return "network delays for [" + delay + "]";
        protected final Set<String> nodesSideOne;  
     */  
        }
 * not use this file except in compliance with the License.
            assert nodesSideTwo.isEmpty() == false;
    }
        ensureNodeCount(cluster);  
            if (nodesSideOne.size() >= nodesSideTwo.size()) {  
        public abstract boolean disrupt(String node1, String node2);
 * Unless required by applicable law or agreed to in writing,
        try {
            }
        }
                    delayMin.millis() == delayMax.millis()
            }
    /**
    public void removeFromCluster(InternalTestCluster cluster) {  
                            }  
            countDownLatch.await();
    public TimeValue expectedTimeToHeal() {  
                        nodesSideTwo.add(node);
        public String toString() {  
    }  
        return networkLinkDisruptionType.expectedTimeToHeal();
            return nodes;
        }
 * Network disruptions are modeled using two components:  
                } else if (random.nextBoolean()) {
        activeDisruption = false;
     * Abstract class representing various types of network disruptions. Instances of this class override the {@link #applyDisruption}  
    @Override
    public static final NetworkLinkDisruptionType UNRESPONSIVE = new NetworkLinkDisruptionType() {
            super(Collections.singleton(bridgeNode), nodesSideOne, nodesSideTwo);
        applyToNodes(cluster.getNodeNames(), new String[] { node1 }, networkLinkDisruptionType::removeDisruption);  
            return "network disconnects";  
            Set<String> nodesSideOne = new HashSet<>();
         */  
         */
    public void applyToCluster(InternalTestCluster cluster) {
                } else if (nodesSideTwo.isEmpty()) {  
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * {@link org.opensearch.cluster.NodeConnectionsService} will eventually reconnect but it's
            Set<String> allNodes = new HashSet<>();
    private void applyToNodes(String[] nodes1, String[] nodes2, BiConsumer<MockTransportService, MockTransportService> consumer) {
                } else {
            throw new AssertionError(e);
    public static class NetworkDelay extends NetworkLinkDisruptionType {
    /**
                }  
            for (Set<String> nodeSet : nodeSets) {  
 * specific language governing permissions and limitations
            return Collections.unmodifiableSet(nodesSideOne);
    public synchronized void removeFromNode(String node1, InternalTestCluster cluster) {  
import org.apache.logging.log4j.LogManager;  
 * GitHub history for details.
    }  
            ClusterState stateOnNode = cluster.getInstance(ClusterService.class, node).state();  
            return true;
     * Creates two partitions with symmetric failures
        @Override
            }
         *
 * under the License.  
        cluster.validateClusterFormed();  
    protected volatile InternalTestCluster cluster;
            Set<String> nodesSideTwo = new HashSet<>();
                + nodesSideOne
         * Delays requests by a random but fixed time value between {@link #DEFAULT_DELAY_MIN} and {@link #DEFAULT_DELAY_MAX}.
            assert nodes.size() >= 3 : "bridge topology requires at least 3 nodes";
        @Override
                        }
    @Override
import java.util.function.BiConsumer;  
    }
            if (nodesSideOne.contains(node2) && nodesSideTwo.contains(node1)) {
    public void ensureHealthy(InternalTestCluster cluster) {
                    } else if (nodesSideTwo.isEmpty()) {
                        ? delayMin.millis()
                return true;
 * 2) the {@link NetworkLinkDisruptionType} represents the failure mode that is to be applied to the links
    /**  
         * Returns true iff network should be disrupted between the two nodes
                    }
        return networkLinkDisruptionType;  
            assert Sets.haveEmptyIntersection(nodesSideOne, nodesSideTwo);
        public static Bridge random(Random random, Set<String> nodes) {
        logger.info("stop disrupting node (disruption type: {}, disrupted links: {})", networkLinkDisruptionType, disruptedLinks);
    /**
                return true;
                        nodesSideOne.add(node);  
                return getNodesSideTwo();
            } else {  
        }
     * Simulates an unresponsive target node by dropping requests sent from source to target node.
     */
    }
        final CountDownLatch countDownLatch = new CountDownLatch(nodeNames.length);
        this.networkLinkDisruptionType = networkLinkDisruptionType;
            }
        public abstract void applyDisruption(MockTransportService sourceTransportService, MockTransportService targetTransportService);  
        return disruptedLinks;
    }  
            super(nodes);
    public static class Bridge extends DisruptedLinks {
    }
     * Creates two partitions with symmetric failures and a bridge node that can connect to both of the partitions
import java.util.Collections;
                    if (nodesSideOne.isEmpty()) {
        private final Set<String> nodesSideOne;
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
            return "bridge partition (super connected node: ["
    private MockTransportService transport(String node) {
     */  
        public static NetworkDelay random(Random random) {
    };
        activeDisruption = true;  
        /**
     */  
    public static final NetworkLinkDisruptionType DISCONNECT = new NetworkLinkDisruptionType() {  
 * the Apache License, Version 2.0 (the "License"); you may
 */  
        public String toString() {
    @Override  
         */
package org.opensearch.test.disruption;
        logger.info("stop disrupting (disruption scheme: {}, disrupted links: {})", networkLinkDisruptionType, disruptedLinks);
        }
                    nodesSideTwo.add(node);
import org.opensearch.common.util.set.Sets;  
            sourceTransportService.addFailToSendNoConnectRule(targetTransportService);
        logger.info("start disrupting (disruption type: {}, disrupted links: {})", networkLinkDisruptionType, disruptedLinks);
        /**  
            }
 */  
import org.opensearch.cluster.service.ClusterService;
        this.cluster = cluster;
    }  
            return false;  
        public TwoPartitions(Set<String> nodesSideOne, Set<String> nodesSideTwo) {
    private final NetworkLinkDisruptionType networkLinkDisruptionType;  
    public abstract static class DisruptedLinks {
         *
/**
    }
        public TimeValue expectedTimeToHeal() {
            if (nodesSideOne.contains(node1) && nodesSideTwo.contains(node2)) {  
    public static class IsolateAllNodes extends DisruptedLinks {
        }  
        }
import java.util.HashSet;
            this.nodes = allNodes;  
        }  
                for (String node2 : nodes2) {
import org.opensearch.transport.ConnectTransportException;  
    }
        }
 *  
                        nodesSideOne.add(node);
    }
            Set<String> nodesSideOne = new HashSet<>();
        }  
     * Simulates a network disconnect. Sending a request from source to target node throws a {@link ConnectTransportException}.
        }
                        nodesSideTwo.add(node);  
         * @param targetTransportService target transport service to which requests are sent
            this.bridgeNode = bridgeNode;  
    }
        return (MockTransportService) cluster.getInstance(TransportService.class, node);
        public String getBridgeNode() {  
 *
        public Collection<String> getMajoritySide() {  
            );
                return true;
                if (nodesSideOne.isEmpty()) {
        /**  
     * handy to be able to ensure this happens faster  
        applyToNodes(cluster.getNodeNames(), cluster.getNodeNames(), networkLinkDisruptionType::applyDisruption);
         * Set of all nodes that can participate in disruptions
 * 1) the {@link DisruptedLinks} represents the links in the network that are to be disrupted
        applyToNodes(cluster.getNodeNames(), cluster.getNodeNames(), networkLinkDisruptionType::removeDisruption);  
         * Removes network disruption that was added by {@link #applyDisruption}.  
                if (node.equals(bridgeNode) == false) {
                }  
        public Set<String> getNodesSideOne() {
         */
            return new TwoPartitions(nodesSideOne, nodesSideTwo);
        }
    @Override
            } else {
        public void applyDisruption(MockTransportService sourceTransportService, MockTransportService targetTransportService) {  
        public boolean disrupt(String node1, String node2) {  
     */  
            sourceTransportService.addUnresponsiveRule(targetTransportService);
                        : delayMin.millis() + random.nextInt((int) (delayMax.millis() - delayMin.millis()))  
        public void applyDisruption(MockTransportService sourceTransportService, MockTransportService targetTransportService) {  
        applyToNodes(new String[] { node1 }, cluster.getNodeNames(), networkLinkDisruptionType::removeDisruption);
                    if (disruptedLinks.nodes().contains(node2)) {
                    } else if (random.nextBoolean()) {  
            return random(random, Sets.newHashSet(nodes));
        public String toString() {
         * Returns expected time to heal after disruption has been removed. Defaults to instant healing.
            sourceTransportService.addUnresponsiveRule(targetTransportService, delay);
/*  
    @Override
        assert activeDisruption == false;
         * Delays requests by a random but fixed time value between delayMin and delayMax.
         * @param delayMin minimum delay
                )
         * @param sourceTransportService source transport service from which requests are sent  
            return new NetworkDelay(
            return random(random, DEFAULT_DELAY_MIN, DEFAULT_DELAY_MAX);  
        private final TimeValue delay;
         */
 * ownership. Elasticsearch licenses this file to you under  
            assert nodesSideTwo.isEmpty() == false;  
        @Override
import org.opensearch.cluster.ClusterState;
            return bridgeNode;
            }  
        public Set<String> getNodesSideOne() {
        }
        /**  
            return Collections.unmodifiableSet(nodesSideTwo);  
            }  
         *
    /**
public class NetworkDisruption implements ServiceDisruptionScheme {
            this.nodesSideTwo = nodesSideTwo;
         * @param delay time to delay requests  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
            for (String node : nodes) {  
    }
            assert nodesSideOne.contains(bridgeNode) == false && nodesSideTwo.contains(bridgeNode) == false;  
        @Override
        /**
        }
         * @param targetTransportService target transport service to which requests are sent  
        public void applyDisruption(MockTransportService sourceTransportService, MockTransportService targetTransportService) {  
     */
            this.nodesSideOne = nodesSideOne;
        final String[] nodeNames = cluster.getNodeNames();  
                + "], partition 1: "  
            assert nodesSideOne.isEmpty() == false;
 * KIND, either express or implied.  See the License for the
        }  
     */
                + nodesSideTwo  
        }
                + " and partition 2: "
            }
    public String toString() {  
        public Collection<String> getMinoritySide() {
                    nodesSideTwo.add(node);
        public static NetworkDelay random(Random random, TimeValue delayMin, TimeValue delayMax) {
            return random(random, Sets.newHashSet(nodes));
    /**
        public static TimeValue DEFAULT_DELAY_MAX = TimeValue.timeValueSeconds(90);
                + bridgeNode
        ensureHealthy(cluster);
            Set<String> nodesSideTwo = new HashSet<>();
        }
            cluster.getInstance(NodeConnectionsService.class, node).reconnectToNodes(stateOnNode.nodes(), countDownLatch::countDown);
    }
    }
                + ")";
            return;  
    @Override  
        private final Set<String> nodes;
         * by the target transport service.
                        if (node1.equals(node2) == false) {  
            assert nodes.size() >= 2 : "two partitions topology requires at least 2 nodes";  
        removeFromCluster(cluster);  
         */
        public Set<String> getNodesSideTwo() {
    public synchronized void applyToNode(String node, InternalTestCluster cluster) {
        @Override
            assert nodesSideOne.isEmpty() == false;  
                return getNodesSideOne();
                return true;
        }
        }
            String bridgeNode = RandomPicks.randomFrom(random, nodes);  
import org.opensearch.common.unit.TimeValue;
         * @param random instance to use for randomization of delay  
                }
        public IsolateAllNodes(Set<String> nodes) {
    public synchronized void startDisrupting() {  
        @Override
        private final Set<String> nodesSideTwo;
