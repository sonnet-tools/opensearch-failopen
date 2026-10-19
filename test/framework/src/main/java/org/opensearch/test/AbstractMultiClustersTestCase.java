        }
            }  
            @Override  
        final Settings.Builder builder = Settings.builder();
            cluster.wipe(Collections.emptySet());  
        client().admin().cluster().prepareUpdateSettings().setPersistentSettings(settings).get();
                Function.identity()  
                MockNioTransportPlugin.class
    protected void configureAndConnectsToRemoteClusters() throws Exception {  
import org.opensearch.common.network.NetworkModule;  
            final long totalConnections = seedNodes.values().stream().map(List::size).count();  
            public Path nodeConfigPath(int nodeOrdinal) {
            assertThat(remoteConnectionInfos, hasSize(Math.toIntExact(totalConnections)));
        return new NodeConfigurationSource() {
        assertBusy(() -> {
        if (clusterGroup != null && reuseClusters()) {  
                final String[] allNodes = cluster.getNodeNames();
import java.io.IOException;  
                numberOfNodes,
                .filter(RemoteConnectionInfo::isConnected)
 * The OpenSearch Contributors require contributions made to  
            }
        for (String clusterAlias : clusterAliases) {
                nodeConfigurationSource,
    static class ClusterGroup implements Closeable {
import java.util.Set;  
        Settings.Builder settings = Settings.builder();
            final int numberOfNodes = randomIntBetween(1, 3);  
        return randomSubsetOf(Arrays.asList("cluster-a", "cluster-b"));
        assertBusy(() -> {
        Settings.Builder settings = Settings.builder();  
                clusterName + "-",
import org.opensearch.transport.TransportService;
        }  
            }
                0,  
    protected Collection<String> remoteClusterAlias() {  
            if (clusterAlias.equals(LOCAL_CLUSTER) == false) {  
import java.util.Arrays;  
    }
import static org.opensearch.discovery.SettingsBasedSeedHostsProvider.DISCOVERY_SEED_HOSTS_SETTING;
        builder.putList(DISCOVERY_SEED_PROVIDERS_SETTING.getKey(), "file");  
    private static volatile ClusterGroup clusterGroup;
    protected final InternalTestCluster cluster(String clusterAlias) {
            IOUtils.close(clusters.values());
        }
/*  
                return builder.build();
 * compatible open source license.
                createTempDir(),
 *
 * license agreements. See the NOTICE file distributed with
                .map(node -> cluster(clusterAlias).getInstance(TransportService.class, node).boundAddress().publishAddress().toString())  
            assertThat(clusters, hasKey(clusterAlias));
        for (InternalTestCluster cluster : clusters().values()) {
 * GitHub history for details.
    protected final Map<String, InternalTestCluster> clusters() {
        final List<String> clusterAliases = new ArrayList<>(remoteClusterAlias());
    }  
import static org.hamcrest.Matchers.hasKey;
import org.opensearch.common.util.io.IOUtils;
}  
        return client(LOCAL_CLUSTER);  
/*  
import java.util.Collections;
        configureAndConnectsToRemoteClusters();  
        stopClusters();  
        public void close() throws IOException {
            final String clusterAlias = entry.getKey();  
        }  
            }
    public final void startClusters() throws Exception {
        ClusterGroup(Map<String, InternalTestCluster> clusters) {
        InternalTestCluster getCluster(String clusterAlias) {  
package org.opensearch.test;
    protected boolean reuseClusters() {  
import java.util.List;
import org.opensearch.transport.RemoteClusterAware;
import org.opensearch.transport.client.Client;
    @Before
            final String seeds = entry.getValue()
            return;
        });  
        @Override  
import org.opensearch.common.settings.Settings;
            final InternalTestCluster cluster = new InternalTestCluster(  
    }
                return null;  
    }
                mockPlugins,
                randomLong(),
 * You may obtain a copy of the License at  
 *  
        return Collections.emptyList();
        clusterGroup = null;
import org.opensearch.action.admin.cluster.remote.RemoteInfoAction;
import java.util.HashMap;  
        return clusterGroup.getCluster(clusterAlias);
                true,  
            cluster.beforeTest(random());
                return nodePlugins;
    }
    }
                MockTransportService.TestPlugin.class,  
        }  
            cluster.assertAfterTest();
                settings.putNull("cluster.remote." + clusterAlias + ".seeds");
        final Map<String, InternalTestCluster> clusters = new HashMap<>();
            public Settings nodeSettings(int nodeOrdinal) {  
    }  
        }  
import java.util.ArrayList;
                clusterName,
    }  
import org.opensearch.transport.RemoteConnectionInfo;  
            }
                assertThat(transportService.getRemoteClusterService().getRegisteredRemoteClusterNames(), empty());
import java.io.Closeable;
import org.opensearch.action.admin.cluster.remote.RemoteInfoRequest;
    protected void disconnectFromRemoteClusters() throws Exception {
                .collect(Collectors.joining(","));
        Set<String> clusterAliases() {
        }  
        return true;
            return clusters.keySet();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
import static org.hamcrest.Matchers.empty;  
    }
    @After  
        for (String clusterAlias : clusterAliases) {
import org.opensearch.transport.nio.MockNioTransportPlugin;  
            }
import java.util.Collection;
                .collect(Collectors.toList());
                .getInfos()
        return cluster(clusterAlias).client();
    public void assertAfterTest() throws Exception {
        }
            final NodeConfigurationSource nodeConfigurationSource = nodeConfigurationSource(nodeSettings, nodePlugins);
            @Override
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.plugins.Plugin;  
import static org.hamcrest.Matchers.hasSize;
        };
 * Modifications Copyright OpenSearch Contributors. See
import org.junit.Before;  
            @Override
            final List<Class<? extends Plugin>> mockPlugins = Arrays.asList(
 * KIND, either express or implied.  See the License for the
                seedNodes.put(clusterAlias, selectedNodes);
            return clusters.get(clusterAlias);
                .stream()  
        builder.putList(DISCOVERY_SEED_HOSTS_SETTING.getKey()); // empty list disables a port scan for other nodes
import java.util.stream.Collectors;
 *     http://www.apache.org/licenses/LICENSE-2.0
import static org.opensearch.discovery.DiscoveryModule.DISCOVERY_SEED_PROVIDERS_SETTING;
        });
        for (String clusterAlias : clusterGroup.clusterAliases()) {
 *
    }  
                true,
            final Collection<Class<? extends Plugin>> nodePlugins = nodePlugins(clusterAlias);  
            settings.put("cluster.remote." + clusterAlias + ".seeds", seeds);
        }  
            final Settings nodeSettings = Settings.EMPTY;
        }
            for (TransportService transportService : cluster(LOCAL_CLUSTER).getInstances(TransportService.class)) {  
    protected final Client client(String clusterAlias) {  
    protected Collection<Class<? extends Plugin>> nodePlugins(String clusterAlias) {
        clusterAliases.add(LOCAL_CLUSTER);  
 * not use this file except in compliance with the License.
        if (seedNodes.isEmpty()) {
    }
                final List<String> selectedNodes = randomSubsetOf(randomIntBetween(1, Math.min(3, allNodes.length)), allNodes);  
    }
                .stream()
            public Collection<Class<? extends Plugin>> nodePlugins() {
        Map<String, List<String>> seedNodes = new HashMap<>();
 * this file be licensed under the Apache-2.0 license or a
        return Collections.unmodifiableMap(clusterGroup.clusters);  
        }
        builder.put(nodeSettings);
        builder.put(NetworkModule.TRANSPORT_TYPE_KEY, getTestTransportType());
import org.junit.After;
    protected final Client client() {
 */  
 * ownership. Elasticsearch licenses this file to you under  
        IOUtils.close(clusterGroup);
 */  
            final String clusterName = clusterAlias.equals(LOCAL_CLUSTER) ? "main-cluster" : clusterAlias;
    static NodeConfigurationSource nodeConfigurationSource(Settings nodeSettings, Collection<Class<? extends Plugin>> nodePlugins) {  
import java.util.function.Function;
                MockHttpTransport.TestPlugin.class,
import java.util.Map;
 * this work for additional information regarding copyright
            if (clusterAlias.equals(LOCAL_CLUSTER) == false) {  
        clusterGroup = new ClusterGroup(clusters);
import org.opensearch.test.transport.MockTransportService;
            this.clusters = Collections.unmodifiableMap(clusters);  
            );
 */
            List<RemoteConnectionInfo> remoteConnectionInfos = client().execute(RemoteInfoAction.INSTANCE, new RemoteInfoRequest())  
import java.nio.file.Path;
 * software distributed under the License is distributed on an
        final Set<String> clusterAliases = clusterGroup.clusterAliases();
        client().admin().cluster().prepareUpdateSettings().setPersistentSettings(settings).get();
    }  
 * Unless required by applicable law or agreed to in writing,
import org.junit.AfterClass;
    public static final String LOCAL_CLUSTER = RemoteClusterAware.LOCAL_CLUSTER_GROUP_KEY;
        for (Map.Entry<String, List<String>> entry : seedNodes.entrySet()) {
                final InternalTestCluster cluster = clusterGroup.getCluster(clusterAlias);
 * under the License.  
            return;
            clusters.put(clusterAlias, cluster);  
 * the Apache License, Version 2.0 (the "License"); you may
/*
public abstract class AbstractMultiClustersTestCase extends OpenSearchTestCase {
            );
                numberOfNodes,  
        private final Map<String, InternalTestCluster> clusters;  
                .actionGet()
    public static void stopClusters() throws IOException {  
    @AfterClass
    }
