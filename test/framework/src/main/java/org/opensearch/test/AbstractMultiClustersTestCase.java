        Set<String> clusterAliases() {
                MockTransportService.TestPlugin.class,
    static class ClusterGroup implements Closeable {
            @Override
        if (clusterGroup != null && reuseClusters()) {
                nodeConfigurationSource,
        });
 *     http://www.apache.org/licenses/LICENSE-2.0
    static NodeConfigurationSource nodeConfigurationSource(Settings nodeSettings, Collection<Class<? extends Plugin>> nodePlugins) {
            cluster.beforeTest(random());
        assertBusy(() -> {
                .stream()
                true,
    public static final String LOCAL_CLUSTER = RemoteClusterAware.LOCAL_CLUSTER_GROUP_KEY;
import org.opensearch.transport.client.Client;
 * You may obtain a copy of the License at
import java.util.HashMap;
    public final void startClusters() throws Exception {
/*
        }
import java.util.Map;
                numberOfNodes,
                mockPlugins,
import org.opensearch.common.util.io.IOUtils;
            }
            IOUtils.close(clusters.values());
                .stream()
import org.junit.AfterClass;
        stopClusters();
 * the Apache License, Version 2.0 (the "License"); you may
            public Settings nodeSettings(int nodeOrdinal) {
        builder.putList(DISCOVERY_SEED_PROVIDERS_SETTING.getKey(), "file");
import java.util.function.Function;
import org.opensearch.transport.TransportService;
                0,
        clusterGroup = new ClusterGroup(clusters);
    }
    }
    public static void stopClusters() throws IOException {
        for (String clusterAlias : clusterGroup.clusterAliases()) {
        }
            }
                .getInfos()
    }
    }
        Settings.Builder settings = Settings.builder();
            final String clusterName = clusterAlias.equals(LOCAL_CLUSTER) ? "main-cluster" : clusterAlias;
            settings.put("cluster.remote." + clusterAlias + ".seeds", seeds);
    protected boolean reuseClusters() {
                seedNodes.put(clusterAlias, selectedNodes);
        builder.putList(DISCOVERY_SEED_HOSTS_SETTING.getKey()); // empty list disables a port scan for other nodes
    }
        }
        for (Map.Entry<String, List<String>> entry : seedNodes.entrySet()) {
import java.io.Closeable;
    protected final Client client(String clusterAlias) {
    }
 * Licensed to Elasticsearch under one or more contributor
            for (TransportService transportService : cluster(LOCAL_CLUSTER).getInstances(TransportService.class)) {
 * GitHub history for details.
                MockHttpTransport.TestPlugin.class,
                .collect(Collectors.toList());
    }
                true,
import java.io.IOException;
            return;
        };
import org.junit.Before;
                createTempDir(),
 * SPDX-License-Identifier: Apache-2.0
        if (seedNodes.isEmpty()) {
        Settings.Builder settings = Settings.builder();
    }
            }
    public void assertAfterTest() throws Exception {
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
    protected final InternalTestCluster cluster(String clusterAlias) {
            final NodeConfigurationSource nodeConfigurationSource = nodeConfigurationSource(nodeSettings, nodePlugins);
    private static volatile ClusterGroup clusterGroup;
        final List<String> clusterAliases = new ArrayList<>(remoteClusterAlias());
 */
        }
        return randomSubsetOf(Arrays.asList("cluster-a", "cluster-b"));
        InternalTestCluster getCluster(String clusterAlias) {
    }
        IOUtils.close(clusterGroup);
                Function.identity()
        }
/*
        configureAndConnectsToRemoteClusters();
 */
            final InternalTestCluster cluster = new InternalTestCluster(
                final InternalTestCluster cluster = clusterGroup.getCluster(clusterAlias);
}
        private final Map<String, InternalTestCluster> clusters;
        return clusterGroup.getCluster(clusterAlias);
    protected Collection<String> remoteClusterAlias() {
 * Unless required by applicable law or agreed to in writing,
    }
        ClusterGroup(Map<String, InternalTestCluster> clusters) {
            assertThat(clusters, hasKey(clusterAlias));
        builder.put(NetworkModule.TRANSPORT_TYPE_KEY, getTestTransportType());
 * KIND, either express or implied.  See the License for the
import java.util.Collection;
    @AfterClass
        return Collections.unmodifiableMap(clusterGroup.clusters);
                settings.putNull("cluster.remote." + clusterAlias + ".seeds");
        final Map<String, InternalTestCluster> clusters = new HashMap<>();
        return client(LOCAL_CLUSTER);
    }
 * specific language governing permissions and limitations
    }
            return clusters.get(clusterAlias);
            final String clusterAlias = entry.getKey();
            clusters.put(clusterAlias, cluster);
        }
            List<RemoteConnectionInfo> remoteConnectionInfos = client().execute(RemoteInfoAction.INSTANCE, new RemoteInfoRequest())
                randomLong(),
        client().admin().cluster().prepareUpdateSettings().setPersistentSettings(settings).get();
 * under the License.
            @Override
        return cluster(clusterAlias).client();
import org.opensearch.transport.RemoteConnectionInfo;
import org.opensearch.action.admin.cluster.remote.RemoteInfoRequest;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;
            public Collection<Class<? extends Plugin>> nodePlugins() {
import org.opensearch.transport.RemoteClusterAware;
        client().admin().cluster().prepareUpdateSettings().setPersistentSettings(settings).get();
            }
        return new NodeConfigurationSource() {
 * compatible open source license.
    protected final Map<String, InternalTestCluster> clusters() {
        return true;
                .filter(RemoteConnectionInfo::isConnected)
        for (String clusterAlias : clusterAliases) {
import java.util.List;
                final String[] allNodes = cluster.getNodeNames();
            );
        }
        }
            }
        }
import static org.opensearch.discovery.DiscoveryModule.DISCOVERY_SEED_PROVIDERS_SETTING;
            final int numberOfNodes = randomIntBetween(1, 3);
        clusterGroup = null;
 */
 * not use this file except in compliance with the License.
            cluster.assertAfterTest();
package org.opensearch.test;
import java.util.Set;
    @After
        }
                return null;
import org.opensearch.plugins.Plugin;
 * Modifications Copyright OpenSearch Contributors. See
        builder.put(nodeSettings);
                return builder.build();
            public Path nodeConfigPath(int nodeOrdinal) {
import org.junit.After;
            assertThat(remoteConnectionInfos, hasSize(Math.toIntExact(totalConnections)));
    @Before
    protected Collection<Class<? extends Plugin>> nodePlugins(String clusterAlias) {
            @Override
    protected final Client client() {
        Map<String, List<String>> seedNodes = new HashMap<>();
                assertThat(transportService.getRemoteClusterService().getRegisteredRemoteClusterNames(), empty());
        clusterAliases.add(LOCAL_CLUSTER);
                numberOfNodes,
        }
import org.opensearch.test.transport.MockTransportService;
 *
            final long totalConnections = seedNodes.values().stream().map(List::size).count();
        final Settings.Builder builder = Settings.builder();
                .map(node -> cluster(clusterAlias).getInstance(TransportService.class, node).boundAddress().publishAddress().toString())
            if (clusterAlias.equals(LOCAL_CLUSTER) == false) {
            final Collection<Class<? extends Plugin>> nodePlugins = nodePlugins(clusterAlias);
import java.util.ArrayList;
                .actionGet()
public abstract class AbstractMultiClustersTestCase extends OpenSearchTestCase {
import org.opensearch.transport.nio.MockNioTransportPlugin;
            return;
            cluster.wipe(Collections.emptySet());
            );
    }
    protected void configureAndConnectsToRemoteClusters() throws Exception {
            final Settings nodeSettings = Settings.EMPTY;
 *
    protected void disconnectFromRemoteClusters() throws Exception {
                clusterName,
                .collect(Collectors.joining(","));
import java.nio.file.Path;
                final List<String> selectedNodes = randomSubsetOf(randomIntBetween(1, Math.min(3, allNodes.length)), allNodes);
 * software distributed under the License is distributed on an
import static org.hamcrest.Matchers.hasKey;
        @Override
    }
            final List<Class<? extends Plugin>> mockPlugins = Arrays.asList(
        assertBusy(() -> {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import static org.opensearch.discovery.SettingsBasedSeedHostsProvider.DISCOVERY_SEED_HOSTS_SETTING;
            return clusters.keySet();
import java.util.Arrays;
        for (String clusterAlias : clusterAliases) {
import java.util.stream.Collectors;
import java.util.Collections;
/*
        public void close() throws IOException {
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to
        for (InternalTestCluster cluster : clusters().values()) {
import org.opensearch.action.admin.cluster.remote.RemoteInfoAction;
 *
                clusterName + "-",
import org.opensearch.common.settings.Settings;
        final Set<String> clusterAliases = clusterGroup.clusterAliases();
            final String seeds = entry.getValue()
import org.opensearch.common.network.NetworkModule;
                return nodePlugins;
            this.clusters = Collections.unmodifiableMap(clusters);
            if (clusterAlias.equals(LOCAL_CLUSTER) == false) {
        return Collections.emptyList();
                MockNioTransportPlugin.class
        });
            }
