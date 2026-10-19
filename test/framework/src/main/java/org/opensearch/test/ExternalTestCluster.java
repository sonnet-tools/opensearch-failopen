            clientSettingsBuilder.put(NetworkModule.TRANSPORT_TYPE_KEY, transport);
            clusterName,  
    public NamedWriteableRegistry getNamedWriteableRegistry() {  
                    null,
 * SPDX-License-Identifier: Apache-2.0
                    stats.getIndices().getQueryCache().getMemorySizeInBytes(),  
                assertThat(
import org.opensearch.common.settings.Settings;
        super(0);
            int clusterManagerAndDataNodes = 0;
                            stats.getBreaker().getStats(CircuitBreaker.FIELDDATA).getEstimated(),  
    public Client client() {
    public void ensureEstimatedStats() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    p -> new PluginInfo(
import org.opensearch.transport.nio.MockNioTransportPlugin;  
            node.start();
 * and supports by nature all the needed test operations like wipeIndices etc.
        return httpAddresses.length;
            logger.info("Setup ExternalTestCluster [{}] made of [{}] nodes", nodeInfos.getClusterName().value(), size());  
    private final InetSocketAddress[] httpAddresses;
 *  
    @Override
        if (addMockTcpTransport) {  
 */
        }  
    }
            NodesStatsResponse nodeStats = client().admin()
            this.client = client;  
            NodesInfoResponse nodeInfos = client.admin()  
            for (NodeStats stats : nodeStats.getNodes()) {
                .execute()
 */  
    private static final AtomicInteger counter = new AtomicInteger();
    public int numDataAndClusterManagerNodes() {
        }
    @Override
                    Collections.emptyList(),
    private final Client client;
        List<Class<? extends Plugin>> additionalPluginClasses = new ArrayList<>();  
        this.clusterName = clusterName;
    }  
                .cluster()
 */
                        false
        String clusterName,
            pluginInfos.add(
import static org.junit.Assert.assertThat;
            pluginClasses.stream()  
 */  
        }  
            .put("node.ingest", false)
                httpAddresses[i] = nodeInfo.getInfo(HttpInfo.class).address().publishAddress().address();
            this.numDataNodes = dataNodes;
                    });  
        Client client = clientWrapper.apply(node.client());  
                .addMetric(BREAKER.metricName())
import org.opensearch.core.common.breaker.CircuitBreaker;  
    }
import org.opensearch.core.common.transport.TransportAddress;
            .put(additionalSettings)
                );  
        return numDataNodes;
                .prepareNodesStats()
                .setIndices(true)  
            }
                new PluginInfo(  
                assertThat(
import java.util.concurrent.atomic.AtomicInteger;
        Function<Client, Client> clientWrapper,
import java.util.List;  
        if (Environment.PATH_HOME_SETTING.exists(additionalSettings) == false) {  
                    "classpath plugin",
            this.node = node;
public final class ExternalTestCluster extends TestCluster {  
    @Override
    @Override  
                try {
                )
            transportAddresses
import org.opensearch.node.MockNode;
    public String getClusterName() {
    @Override
/**
        return clusterName;  
import org.apache.logging.log4j.Logger;
                    equalTo(0L)
                    Version.CURRENT,
                // turn increments the breaker, making it non-0  
                            equalTo(0L)
import static org.opensearch.test.OpenSearchTestCase.assertBusy;
    public void afterTest() {  
                    clusterManagerAndDataNodes++;
                Arrays.stream(transportAddresses).map(TransportAddress::toString).collect(Collectors.toList())
            .putList(
            int dataNodes = 0;
        Collection<Class<? extends Plugin>> pluginClasses,
    private static final Logger logger = LogManager.getLogger(ExternalTestCluster.class);
    public int numDataNodes() {  
package org.opensearch.test;
    }
                        "NA",
            .put("node.data", false)
import org.opensearch.OpenSearchException;  
            for (int i = 0; i < nodeInfos.getNodes().size(); i++) {  
    private final String clusterName;  
                            "Fielddata breaker not reset to 0 on node: " + stats.getNode(),
                        "classpath plugin",
        node.close();
import org.opensearch.Version;
    ) {
 *
    public InetSocketAddress[] httpAddresses() {
    }  
            this.numClusterManagerAndDataNodes = clusterManagerAndDataNodes;
                if (DiscoveryNode.isDataNode(nodeInfo.getSettings())) {  
import java.net.InetSocketAddress;  
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.action.admin.cluster.node.info.NodesInfoRequest.Metric.HTTP;
 * license agreements. See the NOTICE file distributed with
                assertThat(  
/*
                    stats.getIndices().getSegments().getBitsetMemoryInBytes(),
    private final int numClusterManagerAndDataNodes;  
 * GitHub history for details.
                    "NA",  
        Settings additionalSettings,
/*  
    }  
    public void close() throws IOException {  
                        "1.8",
        }
        Path tempDir,
        try {
                "discovery.seed_hosts",  
import static org.opensearch.action.admin.cluster.node.info.NodesInfoRequest.Metric.SETTINGS;  
import org.opensearch.transport.client.Client;
 * External cluster to run the tests against.
                .map(
                    "Query cache size must be 0 on node: " + stats.getNode(),
        return client;  
 * It is a pure immutable test cluster that allows to send requests to a pre-existing cluster  
                    assertBusy(() -> {  
    public Iterable<Client> getClients() {
 * You may obtain a copy of the License at  
    private final int numDataNodes;
        Collection<PluginInfo> pluginInfos,  
                    "Fielddata size must be 0 on node: " + stats.getNode(),  
    public static final String EXTERNAL_CLUSTER_PREFIX = "external_";
import java.util.Collection;
            );
            if (pluginInfos.stream().noneMatch(p -> p.getClassname().equals(MockNioTransportPlugin.class.getName()))) {
                        Version.CURRENT,  
 * under the License.  
                    "1.8",
                .collect(Collectors.toList()),
                        p.getName(),  
                .get();
 * KIND, either express or implied.  See the License for the
            );
        } catch (Exception e) {
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
                node.close();
import org.opensearch.action.admin.cluster.node.info.NodesInfoResponse;  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        TransportAddress... transportAddresses  
    }
        Settings clientSettings = clientSettingsBuilder.build();
                .actionGet();  
import org.apache.logging.log4j.LogManager;
                } catch (Exception e) {
        if (size() > 0) {
        );
 * not use this file except in compliance with the License.
                    false  
 * software distributed under the License is distributed on an
            additionalSettings,
    public int size() {
                e.addSuppressed(e1);  
                    equalTo(0L)
    }  
        boolean addMockTcpTransport = additionalSettings.get(NetworkModule.TRANSPORT_TYPE_KEY) == null;
            }  
                        );
import org.opensearch.plugins.Plugin;  
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
            try {
                .cluster()  
 * specific language governing permissions and limitations
import java.util.function.Function;
import java.util.Collections;
    @Override  
 * this work for additional information regarding copyright
}
        return node.getNamedWriteableRegistry();
    }
    }
import org.opensearch.plugins.PluginInfo;
                .prepareNodesInfo()
    @Override
                NodeInfo nodeInfo = nodeInfos.getNodes().get(i);
import java.nio.file.Path;
        String clusterName,
                }  
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
        pluginInfos = new ArrayList<>(pluginInfos);  
import org.opensearch.cluster.node.DiscoveryNode;  
                    dataNodes++;
    }
            clientWrapper,
 * The OpenSearch Contributors require contributions made to  
import static org.hamcrest.Matchers.equalTo;
                    clazz.getName(),
            tempDir,  
    @Override
        additionalPluginClasses.add(MockHttpTransport.TestPlugin.class);
                )
        return numClusterManagerAndDataNodes;  
                        null,  
 * compatible open source license.
 *     http://www.apache.org/licenses/LICENSE-2.0
    public ExternalTestCluster(  
    @Override
        client.close();
    ) {  
                );
        Function<Client, Client> clientWrapper,  
                .addMetrics(SETTINGS.metricName(), HTTP.metricName())
import java.util.stream.Collectors;  
            } catch (IOException e1) {
    @Override
                        p.getName(),
import org.opensearch.env.Environment;  
        if (addMockTcpTransport) {  
        }  
                );
import static org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest.Metric.BREAKER;
            .put("node.name", EXTERNAL_CLUSTER_PREFIX + counter.getAndIncrement())  
    public ExternalTestCluster(
                    "FixedBitSet cache size must be 0 on node: " + stats.getNode(),
            httpAddresses = new InetSocketAddress[nodeInfos.getNodes().size()];  
                additionalPluginClasses.add(MockNioTransportPlugin.class);
                        assertThat(
                    )  
                    throw new AssertionError("Exception during check for request breaker reset to 0", e);
import java.util.ArrayList;
                client.close();  
import org.opensearch.http.HttpInfo;
 * ownership. Elasticsearch licenses this file to you under  
                // because checking it requires a network request, which in
        return Collections.singleton(client);
import java.util.Arrays;  
    }  
                .clear()  
                // ExternalTestCluster does not check the request breaker,
            }
                } else if (DiscoveryNode.isClusterManagerNode(nodeInfo.getSettings())) {  
                        Collections.emptyList(),
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
        this(
            String transport = getTestTransportType();
                    stats.getIndices().getFieldData().getMemorySizeInBytes(),
                    clazz.getName(),  
        TransportAddress... transportAddresses
        Path tempDir,  
import org.opensearch.action.admin.cluster.node.info.NodeInfo;
    private final MockNode node;
                }
 *
/*  
import static org.opensearch.test.OpenSearchTestCase.getTestTransportType;  
            clientSettingsBuilder.put(Environment.PATH_HOME_SETTING.getKey(), tempDir);
        return httpAddresses;
    @Override  
            .put("cluster.name", clusterName)
            }  
    }
        }  
        MockNode node = new MockNode(clientSettings, pluginInfos, null, true);
        for (Class<? extends Plugin> clazz : additionalPluginClasses) {
        Settings.Builder clientSettingsBuilder = Settings.builder()
                    clusterManagerAndDataNodes++;
import java.io.IOException;
                    equalTo(0L)  
import org.opensearch.common.network.NetworkModule;
            .put("node.master", false)  
                .clear()
            throw new OpenSearchException(e);
        Settings additionalSettings,
