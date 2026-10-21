            }
 * this file be licensed under the Apache-2.0 license or a
        internalCluster().ensureAtLeastNumDataNodes(randomIntBetween(3, 5));
package org.opensearch.test.disruption;
    @Override
                private AtomicBoolean responded = new AtomicBoolean();
        internalCluster().clearDisruptionScheme();
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat(nodes.size(), greaterThanOrEqualTo(3));
        int numOfNodes = randomIntBetween(3, 5);
                    internalCluster().getInstance(TransportService.class, pair.v2())
                    return ClusterHealthResponse.readResponseFrom(in);
        }
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.threadpool.ThreadPool;
                }
        networkDisruption.startDisrupting();
        networkDisruption.startDisrupting();
 * specific language governing permissions and limitations
        }
        Tuple<Set<String>, Set<String>> sides = prepareDisruptedCluster();
     * Creates 3 to 5 mixed-node cluster and splits it into 2 parts.
    /**
        );
                latch
        assertTrue(disruptedPair.isPresent());
        .put(NodeConnectionsService.CLUSTER_NODE_RECONNECT_INTERVAL_SETTING.getKey(), "2s")
        latch.await(30, TimeUnit.SECONDS);
        int majority = nodes.size() / 2 + 1;
 * this work for additional information regarding copyright
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    private void sendRequest(TransportService source, TransportService target, CountDownLatch latch) {
import java.util.Set;
        int requests = randomIntBetween(1, 200);
 *
}
        // sends some requests to the majority side part
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
    }
            for (String nodeB : side2) {
 */
        internalCluster().setBootstrapClusterManagerNodeIndex(numOfNodes - 1);
        // since we have 3+ nodes, we are sure to find a disrupted pair, also for bridge disruptions.
        Set<String> side1 = new HashSet<>(randomSubsetOf(randomIntBetween(majority, nodes.size() - 1), nodes));
        NetworkDisruption networkDisruption = new NetworkDisruption(
            new ClusterHealthRequest(),
                @Override
 * Licensed to Elasticsearch under one or more contributor
 * SPDX-License-Identifier: Apache-2.0
        } else {
        );
                    internalCluster().getInstance(TransportService.class, pair.v1()),
 * Unless required by applicable law or agreed to in writing,
                @Override
    }
        CountDownLatch latch = new CountDownLatch(requests);
            sendRequest(
            disruptedLinks,
    }
import org.opensearch.test.disruption.NetworkDisruption.TwoPartitions;
        return disruptedPair.get();
import org.opensearch.test.InternalTestCluster;
import java.util.concurrent.CountDownLatch;
            disruptedLinks = TwoPartitions.random(random(), internalCluster().getNodeNames());
        assertEquals("All requests must respond, requests: " + requests, 0, latch.getCount());
/*
            }
 * software distributed under the License is distributed on an
        internalCluster().setDisruptionScheme(networkDisruption);
        assertThat(side1.size(), greaterThanOrEqualTo(majority));
                }
import org.opensearch.test.OpenSearchIntegTestCase;
                @Override
        Optional<Tuple<TransportService, TransportService>> disruptedPair = disruptedLinks.nodes()
        Set<String> side2 = sides.v2();
        internalCluster().setBootstrapClusterManagerNodeIndex(0);
 * GitHub history for details.
        return Tuple.tuple(side1, side2);
import org.opensearch.common.settings.Settings;
        ensureGreen();
    private static final Settings DISRUPTION_TUNED_SETTINGS = Settings.builder()
            );
            randomFrom(NetworkDisruption.UNRESPONSIVE, NetworkDisruption.DISCONNECT, NetworkDisruption.NetworkDelay.random(random()))
        networkDisruption.stopDisrupting();
                internalCluster().getInstance(TransportService.class),
 * under the License.
import java.util.Arrays;
 * the Apache License, Version 2.0 (the "License"); you may
            ClusterHealthAction.NAME,
            latch.await(500, TimeUnit.MILLISECONDS) && networkDisruption.getNetworkLinkDisruptionType() != NetworkDisruption.DISCONNECT
                TransportService serviceA = internalCluster().getInstance(TransportService.class, nodeA);
                internalCluster().getInstance(TransportService.class),
    }
                });
        .build();
import java.util.Collection;
public class NetworkDisruptionIT extends OpenSearchIntegTestCase {
        // give a bit of time to send something under disruption.
                pair -> Tuple.tuple(
import org.opensearch.transport.TransportException;
    }
                    latch.countDown();
                public TransportResponse read(StreamInput in) throws IOException {
        NetworkDisruption networkDisruption = new NetworkDisruption(new TwoPartitions(side1, side2), NetworkDisruption.DISCONNECT);
        final NetworkDisruption.DisruptedLinks disruptedLinks;
import java.util.concurrent.TimeUnit;
            .findFirst();
                TransportService serviceB = internalCluster().getInstance(TransportService.class, nodeB);
import org.opensearch.cluster.NodeConnectionsService;
        }
        Tuple<Set<String>, Set<String>> sides = prepareDisruptedCluster();
/*
        // check all connections are restored
import org.opensearch.core.common.io.stream.StreamInput;
        Set<String> nodes = new HashSet<>(internalCluster().startNodes(numOfNodes, DISRUPTION_TUNED_SETTINGS));
        client(randomFrom(side1)).admin().cluster().prepareNodesInfo().get();
            target.getLocalNode(),
import java.util.Optional;
import org.opensearch.action.admin.cluster.health.ClusterHealthAction;
 * The OpenSearch Contributors require contributions made to
                assertBusy(() -> {
        assertThat(side2.size(), greaterThanOrEqualTo(1));
import java.util.concurrent.atomic.AtomicBoolean;
            )
        Tuple<TransportService, TransportService> disruptedPair = findDisruptedPair(disruptedLinks);
        side2.removeAll(side1);
import org.opensearch.transport.TransportResponseHandler;
 * not use this file except in compliance with the License.
                public void handleResponse(TransportResponse response) {
                @Override
import org.opensearch.core.transport.TransportResponse;
                }
    }
 * license agreements. See the NOTICE file distributed with
                public String executor() {
        assertFalse(
/*
                    latch.countDown();
                )
            .filter(pair -> disruptedLinks.disrupt(pair.v1(), pair.v2()))
     * The first part is guaranteed to have at least the majority of the nodes,
import org.opensearch.plugins.Plugin;
        source.sendRequest(
        for (String nodeA : side1) {
            .flatMap(n1 -> disruptedLinks.nodes().stream().map(n2 -> Tuple.tuple(n1, n2)))
            .map(
        internalCluster().clearDisruptionScheme();
                // TODO assertBusy should not be here, see https://github.com/elastic/elasticsearch/issues/38348
        Set<String> side1 = sides.v1();
                }
                    assertTrue(nodeA + " is not connected to " + nodeB, serviceA.nodeConnected(serviceB.getLocalNode()));
 * ownership. Elasticsearch licenses this file to you under
    public void testNetworkPartitionRemovalRestoresConnections() throws Exception {
        );
 * Modifications Copyright OpenSearch Contributors. See
        for (int i = 0; i < requests - 1; ++i) {
     * so that cluster-manager could be elected on this side.
            new TransportResponseHandler<TransportResponse>() {
     */
 *
    private Tuple<TransportService, TransportService> findDisruptedPair(NetworkDisruption.DisruptedLinks disruptedLinks) {
    public void testTransportRespondsEventually() throws InterruptedException {
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import java.util.HashSet;
    public void testClearDisruptionSchemeWhenNodeIsDown() throws IOException {
import java.io.IOException;
 * KIND, either express or implied.  See the License for the
            .stream()
            disruptedLinks = NetworkDisruption.Bridge.random(random(), internalCluster().getNodeNames());
        internalCluster().setDisruptionScheme(networkDisruption);
    private Tuple<Set<String>, Set<String>> prepareDisruptedCluster() {
        return Arrays.asList(MockTransportService.TestPlugin.class);
                public void handleException(TransportException exp) {
import org.opensearch.test.transport.MockTransportService;
                    assertTrue(responded.compareAndSet(false, true));
 * You may obtain a copy of the License at
 */
 * compatible open source license.
import org.opensearch.transport.TransportService;
 */
                    assertTrue(responded.compareAndSet(false, true));
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;
import org.opensearch.common.collect.Tuple;
        if (randomBoolean()) {
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(randomFrom(sides.v2())));
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0, autoManageMasterNodes = false)
                    assertTrue(nodeB + " is not connected to " + nodeA, serviceB.nodeConnected(serviceA.getLocalNode()));
        sendRequest(disruptedPair.v1(), disruptedPair.v2(), latch);
        // send a request that is guaranteed disrupted.
        Set<String> side2 = new HashSet<>(nodes);
                    return ThreadPool.Names.SAME;
