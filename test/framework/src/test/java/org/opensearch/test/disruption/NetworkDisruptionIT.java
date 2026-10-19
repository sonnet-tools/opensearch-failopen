        CountDownLatch latch = new CountDownLatch(requests);  
 *
     * so that cluster-manager could be elected on this side.  
        // sends some requests to the majority side part  
import org.opensearch.test.transport.MockTransportService;
    }  
                public void handleResponse(TransportResponse response) {
import org.opensearch.core.transport.TransportResponse;
                @Override
            sendRequest(
import java.util.Collection;  
                    internalCluster().getInstance(TransportService.class, pair.v2())
        internalCluster().setDisruptionScheme(networkDisruption);
            );  
                internalCluster().getInstance(TransportService.class),
                @Override  
        assertThat(side2.size(), greaterThanOrEqualTo(1));
        internalCluster().clearDisruptionScheme();
            disruptedLinks = NetworkDisruption.Bridge.random(random(), internalCluster().getNodeNames());  
                @Override  
        Set<String> side2 = sides.v2();
 * not use this file except in compliance with the License.
import org.opensearch.action.admin.cluster.health.ClusterHealthAction;
                )
            .map(
            disruptedLinks = TwoPartitions.random(random(), internalCluster().getNodeNames());
            randomFrom(NetworkDisruption.UNRESPONSIVE, NetworkDisruption.DISCONNECT, NetworkDisruption.NetworkDelay.random(random()))
            latch.await(500, TimeUnit.MILLISECONDS) && networkDisruption.getNetworkLinkDisruptionType() != NetworkDisruption.DISCONNECT  
        internalCluster().setBootstrapClusterManagerNodeIndex(numOfNodes - 1);
            target.getLocalNode(),  
                pair -> Tuple.tuple(
        NetworkDisruption networkDisruption = new NetworkDisruption(  
    private Tuple<TransportService, TransportService> findDisruptedPair(NetworkDisruption.DisruptedLinks disruptedLinks) {
        for (int i = 0; i < requests - 1; ++i) {
        networkDisruption.startDisrupting();  
    private static final Settings DISRUPTION_TUNED_SETTINGS = Settings.builder()
            for (String nodeB : side2) {
import org.opensearch.plugins.Plugin;  
        Set<String> side1 = new HashSet<>(randomSubsetOf(randomIntBetween(majority, nodes.size() - 1), nodes));  
 * specific language governing permissions and limitations
 * compatible open source license.
    /**  
        // give a bit of time to send something under disruption.
/*  
        internalCluster().setBootstrapClusterManagerNodeIndex(0);  
 * under the License.  
        Set<String> nodes = new HashSet<>(internalCluster().startNodes(numOfNodes, DISRUPTION_TUNED_SETTINGS));
                @Override  
 *  
        return disruptedPair.get();
                    internalCluster().getInstance(TransportService.class, pair.v1()),  
                public TransportResponse read(StreamInput in) throws IOException {  
            new ClusterHealthRequest(),
        internalCluster().clearDisruptionScheme();
            }
import org.opensearch.transport.TransportException;  
 * SPDX-License-Identifier: Apache-2.0
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0, autoManageMasterNodes = false)
        Tuple<Set<String>, Set<String>> sides = prepareDisruptedCluster();
/*  
                internalCluster().getInstance(TransportService.class),  
 * Licensed to Elasticsearch under one or more contributor  
        return Arrays.asList(MockTransportService.TestPlugin.class);
    private Tuple<Set<String>, Set<String>> prepareDisruptedCluster() {
        return Tuple.tuple(side1, side2);  
        } else {
                TransportService serviceB = internalCluster().getInstance(TransportService.class, nodeB);
        internalCluster().ensureAtLeastNumDataNodes(randomIntBetween(3, 5));
import org.opensearch.threadpool.ThreadPool;
/*
        assertTrue(disruptedPair.isPresent());  
        NetworkDisruption networkDisruption = new NetworkDisruption(new TwoPartitions(side1, side2), NetworkDisruption.DISCONNECT);
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;
            .stream()
            ClusterHealthAction.NAME,
    public void testNetworkPartitionRemovalRestoresConnections() throws Exception {
    protected Collection<Class<? extends Plugin>> nodePlugins() {
import org.opensearch.transport.TransportService;
 * software distributed under the License is distributed on an
}  
        latch.await(30, TimeUnit.SECONDS);
    }
        // check all connections are restored  
                    assertTrue(responded.compareAndSet(false, true));
                // TODO assertBusy should not be here, see https://github.com/elastic/elasticsearch/issues/38348
        networkDisruption.startDisrupting();
import org.opensearch.transport.TransportResponseHandler;
    }
        int requests = randomIntBetween(1, 200);
        .build();
                    assertTrue(nodeB + " is not connected to " + nodeA, serviceB.nodeConnected(serviceA.getLocalNode()));
        assertThat(nodes.size(), greaterThanOrEqualTo(3));
 * You may obtain a copy of the License at  
                    return ClusterHealthResponse.readResponseFrom(in);
 * license agreements. See the NOTICE file distributed with
        Set<String> side1 = sides.v1();  
import java.util.Set;  
    public void testTransportRespondsEventually() throws InterruptedException {
        Tuple<Set<String>, Set<String>> sides = prepareDisruptedCluster();
import java.util.concurrent.TimeUnit;
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
    public void testClearDisruptionSchemeWhenNodeIsDown() throws IOException {  
        }
 * the Apache License, Version 2.0 (the "License"); you may
                latch
            }  
            .findFirst();
 * GitHub history for details.
import java.util.Arrays;
                }
                assertBusy(() -> {  
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(randomFrom(sides.v2())));  
                public void handleException(TransportException exp) {
    private void sendRequest(TransportService source, TransportService target, CountDownLatch latch) {
                    assertTrue(responded.compareAndSet(false, true));
public class NetworkDisruptionIT extends OpenSearchIntegTestCase {
        int numOfNodes = randomIntBetween(3, 5);  
        assertEquals("All requests must respond, requests: " + requests, 0, latch.getCount());
                }  
        internalCluster().setDisruptionScheme(networkDisruption);  
        Tuple<TransportService, TransportService> disruptedPair = findDisruptedPair(disruptedLinks);
                    latch.countDown();  
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;  
import java.util.HashSet;
                public String executor() {
        if (randomBoolean()) {  
import java.util.concurrent.atomic.AtomicBoolean;  
        Set<String> side2 = new HashSet<>(nodes);
                    return ThreadPool.Names.SAME;
                }
    }
        Optional<Tuple<TransportService, TransportService>> disruptedPair = disruptedLinks.nodes()  
        assertThat(side1.size(), greaterThanOrEqualTo(majority));
 */  
    }  
        );  
            .filter(pair -> disruptedLinks.disrupt(pair.v1(), pair.v2()))  
import org.opensearch.test.InternalTestCluster;
package org.opensearch.test.disruption;
                }
                });  
    }  
        source.sendRequest(
import java.io.IOException;
        );
        for (String nodeA : side1) {
            disruptedLinks,
        .put(NodeConnectionsService.CLUSTER_NODE_RECONNECT_INTERVAL_SETTING.getKey(), "2s")  
        // since we have 3+ nodes, we are sure to find a disrupted pair, also for bridge disruptions.
        ensureGreen();  
                private AtomicBoolean responded = new AtomicBoolean();
        int majority = nodes.size() / 2 + 1;
import org.opensearch.cluster.NodeConnectionsService;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.common.io.stream.StreamInput;
 * Modifications Copyright OpenSearch Contributors. See
                    assertTrue(nodeA + " is not connected to " + nodeB, serviceA.nodeConnected(serviceB.getLocalNode()));
            )  
        client(randomFrom(side1)).admin().cluster().prepareNodesInfo().get();
 */  
        assertFalse(
        networkDisruption.stopDisrupting();
import java.util.concurrent.CountDownLatch;
        );
import java.util.Optional;
                TransportService serviceA = internalCluster().getInstance(TransportService.class, nodeA);  
    }
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.OpenSearchIntegTestCase;
 * Unless required by applicable law or agreed to in writing,
     */
        final NetworkDisruption.DisruptedLinks disruptedLinks;
     * The first part is guaranteed to have at least the majority of the nodes,
 * this work for additional information regarding copyright
     * Creates 3 to 5 mixed-node cluster and splits it into 2 parts.
            new TransportResponseHandler<TransportResponse>() {  
            .flatMap(n1 -> disruptedLinks.nodes().stream().map(n2 -> Tuple.tuple(n1, n2)))
import org.opensearch.test.disruption.NetworkDisruption.TwoPartitions;  
 * KIND, either express or implied.  See the License for the
    @Override  
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import org.opensearch.common.settings.Settings;  
 *
 */
        sendRequest(disruptedPair.v1(), disruptedPair.v2(), latch);
        side2.removeAll(side1);  
                    latch.countDown();  
 *     http://www.apache.org/licenses/LICENSE-2.0
        // send a request that is guaranteed disrupted.  
        }
import org.opensearch.common.collect.Tuple;
