public final class ExternalTestCluster extends TestCluster {
                    clusterManagerAndDataNodes++;
                // ExternalTestCluster does not check the request breaker,
 */
import java.util.ArrayList;
                .addMetrics(SETTINGS.metricName(), HTTP.metricName())
            clientWrapper,
 *
            this.numDataNodes = dataNodes;
            clientSettingsBuilder.put(NetworkModule.TRANSPORT_TYPE_KEY, transport);
                .map(
                        Collections.emptyList(),
        return Collections.singleton(client);
                additionalPluginClasses.add(MockNioTransportPlugin.class);
                .setIndices(true)
 */
import org.opensearch.plugins.Plugin;
                    });
 *
    @Override
 * this file be licensed under the Apache-2.0 license or a
    }
                    clusterManagerAndDataNodes++;
            );
        pluginInfos = new ArrayList<>(pluginInfos);
    private final int numDataNodes;
            }
import static org.junit.Assert.assertThat;
import static org.opensearch.test.OpenSearchTestCase.assertBusy;
            this.node = node;
    }
            additionalSettings,
                        "1.8",
            pluginClasses.stream()
 * not use this file except in compliance with the License.
                // because checking it requires a network request, which in
                e.addSuppressed(e1);
        node.close();
 *
                .clear()
import org.opensearch.OpenSearchException;
                if (DiscoveryNode.isDataNode(nodeInfo.getSettings())) {
    }
import java.util.concurrent.atomic.AtomicInteger;
 * External cluster to run the tests against.
    @Override
import java.nio.file.Path;
 */
            .put("node.master", false)
        boolean addMockTcpTransport = additionalSettings.get(NetworkModule.TRANSPORT_TYPE_KEY) == null;
                } catch (Exception e) {
            for (int i = 0; i < nodeInfos.getNodes().size(); i++) {
        List<Class<? extends Plugin>> additionalPluginClasses = new ArrayList<>();
                assertThat(
                "discovery.seed_hosts",
    }
                        assertThat(
import static org.hamcrest.Matchers.equalTo;
            .put(additionalSettings)
        return numClusterManagerAndDataNodes;
import java.util.stream.Collectors;
    public ExternalTestCluster(
        }
                .prepareNodesInfo()
            httpAddresses = new InetSocketAddress[nodeInfos.getNodes().size()];
                    null,
                    throw new AssertionError("Exception during check for request breaker reset to 0", e);
 * software distributed under the License is distributed on an
                    p -> new PluginInfo(
                    Version.CURRENT,
                    clazz.getName(),
                    Collections.emptyList(),
                    dataNodes++;
import org.opensearch.Version;
import java.util.Collections;
import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
        additionalPluginClasses.add(MockHttpTransport.TestPlugin.class);
    }
        Settings additionalSettings,
                try {
            for (NodeStats stats : nodeStats.getNodes()) {
                // turn increments the breaker, making it non-0
        Settings clientSettings = clientSettingsBuilder.build();
    }
            .put("node.ingest", false)
        Collection<PluginInfo> pluginInfos,
                )
    }
import org.opensearch.http.HttpInfo;
import org.opensearch.core.common.breaker.CircuitBreaker;
                        "NA",
import java.util.Collection;
 * You may obtain a copy of the License at
import static org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest.Metric.BREAKER;
 * Unless required by applicable law or agreed to in writing,
    public ExternalTestCluster(
    @Override
                .execute()
    }
import static org.opensearch.action.admin.cluster.node.info.NodesInfoRequest.Metric.SETTINGS;
                        p.getName(),
        return client;
 * SPDX-License-Identifier: Apache-2.0
                NodeInfo nodeInfo = nodeInfos.getNodes().get(i);
        if (addMockTcpTransport) {
        String clusterName,
                );
            tempDir,
            this.client = client;
        String clusterName,
        if (Environment.PATH_HOME_SETTING.exists(additionalSettings) == false) {
                    equalTo(0L)
/**
/*
        return httpAddresses.length;
                    stats.getIndices().getFieldData().getMemorySizeInBytes(),
        if (addMockTcpTransport) {
                );
import java.net.InetSocketAddress;
import org.opensearch.transport.nio.MockNioTransportPlugin;
 * ownership. Elasticsearch licenses this file to you under
        }
                .clear()
    public int numDataNodes() {
        }
                            "Fielddata breaker not reset to 0 on node: " + stats.getNode(),
            }
            .putList(
                    stats.getIndices().getQueryCache().getMemorySizeInBytes(),
                .cluster()
 * the Apache License, Version 2.0 (the "License"); you may
                .actionGet();
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
import org.opensearch.common.network.NetworkModule;
                .addMetric(BREAKER.metricName())
        TransportAddress... transportAddresses
                    stats.getIndices().getSegments().getBitsetMemoryInBytes(),
            }
    @Override
                node.close();
        try {
 * under the License.
                assertThat(
        Path tempDir,
import org.opensearch.plugins.PluginInfo;
                    "1.8",
        }
import org.opensearch.env.Environment;
                    "NA",
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor
 * compatible open source license.
        MockNode node = new MockNode(clientSettings, pluginInfos, null, true);
                        );
 * It is a pure immutable test cluster that allows to send requests to a pre-existing cluster
            int dataNodes = 0;
    @Override
import org.opensearch.action.admin.cluster.node.info.NodesInfoResponse;
        return numDataNodes;
    @Override
                            equalTo(0L)
                httpAddresses[i] = nodeInfo.getInfo(HttpInfo.class).address().publishAddress().address();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * license agreements. See the NOTICE file distributed with
                    assertBusy(() -> {
            if (pluginInfos.stream().noneMatch(p -> p.getClassname().equals(MockNioTransportPlugin.class.getName()))) {
                );
            int clusterManagerAndDataNodes = 0;
    public void ensureEstimatedStats() {
                } else if (DiscoveryNode.isClusterManagerNode(nodeInfo.getSettings())) {
            NodesInfoResponse nodeInfos = client.admin()
                .collect(Collectors.toList()),
    @Override
import java.util.List;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
 * and supports by nature all the needed test operations like wipeIndices etc.
import static org.opensearch.test.OpenSearchTestCase.getTestTransportType;
            NodesStatsResponse nodeStats = client().admin()
            } catch (IOException e1) {
 * GitHub history for details.
        Client client = clientWrapper.apply(node.client());
            clusterName,
                .get();
 */
        return clusterName;
    private final InetSocketAddress[] httpAddresses;
    public void close() throws IOException {
import org.opensearch.node.MockNode;
            );
    }
        client.close();
            try {
        this(
import java.util.function.Function;
    }
    public NamedWriteableRegistry getNamedWriteableRegistry() {
        }
    public InetSocketAddress[] httpAddresses() {
            this.numClusterManagerAndDataNodes = clusterManagerAndDataNodes;
                        null,
            .put("node.name", EXTERNAL_CLUSTER_PREFIX + counter.getAndIncrement())
                    equalTo(0L)
/*
        this.clusterName = clusterName;
            pluginInfos.add(
        Path tempDir,
    @Override
    private final MockNode node;
import static org.opensearch.action.admin.cluster.node.info.NodesInfoRequest.Metric.HTTP;
 * The OpenSearch Contributors require contributions made to
import org.apache.logging.log4j.Logger;
                        Version.CURRENT,
        super(0);
            .put("node.data", false)
    }
        return httpAddresses;
    ) {
            node.start();
                    "Query cache size must be 0 on node: " + stats.getNode(),
            logger.info("Setup ExternalTestCluster [{}] made of [{}] nodes", nodeInfos.getClusterName().value(), size());
import org.opensearch.common.settings.Settings;
    @Override
                    clazz.getName(),
        }
                new PluginInfo(
                            stats.getBreaker().getStats(CircuitBreaker.FIELDDATA).getEstimated(),
    public int numDataAndClusterManagerNodes() {
package org.opensearch.test;
        Settings.Builder clientSettingsBuilder = Settings.builder()
import org.opensearch.transport.client.Client;
        } catch (Exception e) {
    }
                    equalTo(0L)
                    "classpath plugin",
        Collection<Class<? extends Plugin>> pluginClasses,
            .put("cluster.name", clusterName)
            transportAddresses
        );
                }
    public Client client() {
    private final String clusterName;
                    )
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
            String transport = getTestTransportType();
            }
            clientSettingsBuilder.put(Environment.PATH_HOME_SETTING.getKey(), tempDir);
        return node.getNamedWriteableRegistry();
import org.opensearch.cluster.node.DiscoveryNode;
        for (Class<? extends Plugin> clazz : additionalPluginClasses) {
        Settings additionalSettings,
    @Override
    public Iterable<Client> getClients() {
                    "FixedBitSet cache size must be 0 on node: " + stats.getNode(),
import org.opensearch.action.admin.cluster.node.info.NodeInfo;
                        p.getName(),
        TransportAddress... transportAddresses
    @Override
/*
        if (size() > 0) {
                    "Fielddata size must be 0 on node: " + stats.getNode(),
                assertThat(
import org.opensearch.core.common.transport.TransportAddress;
                .prepareNodesStats()
 * specific language governing permissions and limitations
    public String getClusterName() {
                Arrays.stream(transportAddresses).map(TransportAddress::toString).collect(Collectors.toList())
        Function<Client, Client> clientWrapper,
                }
 * this work for additional information regarding copyright
    public void afterTest() {
                        "classpath plugin",
    }
    public static final String EXTERNAL_CLUSTER_PREFIX = "external_";
    public int size() {
                        false
        Function<Client, Client> clientWrapper,
 * KIND, either express or implied.  See the License for the
    ) {
}
                .cluster()
                )
    private static final Logger logger = LogManager.getLogger(ExternalTestCluster.class);
    private static final AtomicInteger counter = new AtomicInteger();
    private final Client client;
            throw new OpenSearchException(e);
                    false
    private final int numClusterManagerAndDataNodes;
                client.close();
import java.io.IOException;
