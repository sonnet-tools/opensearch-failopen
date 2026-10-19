        long seed = randomLong();
                    break;
            for (String name : cluster.getNodeNames()) {  
            cluster.stopRandomNode(InternalTestCluster.nameFilter(poorNode));
            nodeConfigurationSource,
    }  
import org.opensearch.discovery.SettingsBasedSeedHostsProvider;
            {  
    }  
        }
            assertEquals(key, right.get(key), left.get(key));  
 * not use this file except in compliance with the License.
            baseDir,
 * GitHub history for details.
        try {
            Files.createDirectories(testMarker);  
 *  
 */
            "",
 * specific language governing permissions and limitations
            plugins,
            nodePrefix,  
        );
            clusterSeed,
        List<DiscoveryNodeRole> roles = new ArrayList<>();
                    cluster.rollingRestart(InternalTestCluster.EMPTY_CALLBACK);  
    private static Collection<Class<? extends Plugin>> mockPlugins() {
    }  
                shardNodePaths.put(name, getNodePaths(cluster, name));  
            true,  
            "test",  
import static org.hamcrest.Matchers.equalTo;  
import java.util.List;
            Map<DiscoveryNodeRole, Set<String>> pathsPerRole = new HashMap<>();
        Path baseDir = createTempDir();
                    .build();
        } finally {  
import org.opensearch.cluster.node.DiscoveryNodeRole;
                    break;
                @Override
            nodeConfigurationSource,
            bootstrapClusterManagerNodeIndex = maxNumDataNodes == 0 ? -1 : randomIntBetween(0, maxNumDataNodes - 1);  
            Function.identity()
package org.opensearch.test.test;
        try {
                List<String> paths = Arrays.stream(getNodePaths(cluster, name)).map(Path::toString).collect(Collectors.toList());
    }
                }  
            // if we manage min cluster-manager nodes, we need to lock down the number of nodes
            }
                    .putList(SettingsBasedSeedHostsProvider.DISCOVERY_SEED_HOSTS_SETTING.getKey())  
        clusterUniqueSettings.add(Environment.PATH_REPO_SETTING.getKey());
        clusterUniqueSettings.add(Environment.PATH_HOME_SETTING.getKey());  
            assertArrayEquals(cluster0.getNodeNames(), cluster1.getNodeNames());
    }
            cluster.beforeTest(random());
        }  
        } else {
        );  
 * Unless required by applicable law or agreed to in writing,
        if (autoManageMinClusterManagerNodes) {
            nodePrefix,  
            }
                } else if (role == DiscoveryNodeRole.INGEST_ROLE) {
        cluster0.setBootstrapClusterManagerNodeIndex(bootstrapClusterManagerNodeIndex);  
            0,
            @Override
                    return null;
import static org.hamcrest.Matchers.not;
            "clustername",
        for (int i = 0; i < numNodes; i++) {
            IOUtils.close(cluster0, cluster1);  
            final int originalClusterManagerCount = cluster.numClusterManagerNodes();  
        );
            this.settings = settings;
            Collections.emptyList(),  
import java.util.Collections;
    public static class NodeAttrCheckPlugin extends Plugin {  
            );
                    .put(NetworkModule.TRANSPORT_TYPE_KEY, getTestTransportType())
            clusterName,
            @Override
        final int maxNumDataNodes;  
import static org.opensearch.discovery.DiscoveryModule.DISCOVERY_SEED_PROVIDERS_SETTING;  
                    .putList(DISCOVERY_SEED_PROVIDERS_SETTING.getKey(), "file")  
        try {
                    .putList(SettingsBasedSeedHostsProvider.DISCOVERY_SEED_HOSTS_SETTING.getKey())
                    .putList(DISCOVERY_SEED_PROVIDERS_SETTING.getKey(), "file")
            baseDir,
                    node = cluster.startDataOnlyNode();  
import java.util.Random;
            }
            Function.identity()  
            nodePrefix,
            clusterSeed,
        Path baseDir = createTempDir();  
            nodePrefix,
        long clusterSeed = randomLong();
            createTempDir(),  
 * The OpenSearch Contributors require contributions made to  
            }  
            final Settings poorNodeDataPathSettings = cluster.dataPathSettings(poorNode);
        long clusterSeed = randomLong();  
import org.opensearch.common.settings.Settings;
                } else {
            numClientNodes,
            assertFileExists(testMarker); // starting a node should re-use data folders and not clean it  
            maxNumDataNodes,  
                return null;  
            0,
            final Path testMarker = dataPath.resolve("testMarker");
    /**
            cluster.fullRestart();  
            for (String name : cluster.getNodeNames()) {
                continue;  
            maxNumDataNodes,
            assertThat(getNodePaths(cluster, newNode1)[0], not(dataPath));
    public void testInitializiationIsConsistent() {
            mockPlugins(),
                Set<String> rolePaths = pathsPerRole.computeIfAbsent(role, k -> new HashSet<>());  
            @Override
            assertFileExists(stableTestMarker); // but leaving the structure of existing, reused nodes
                }
                public Path nodeConfigPath(int nodeOrdinal) {  
            public Path nodeConfigPath(int nodeOrdinal) {  
            maxNumDataNodes,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            clusterName,
            baseDir,
            randomLong(),
            clusterName1,  
 * software distributed under the License is distributed on an
            2,
            numClientNodes,  
            }
        boolean clusterManagerNodes = randomBoolean();
            }
 *
import org.opensearch.plugins.Plugin;  
            Map<DiscoveryNodeRole, Set<String>> result = new HashMap<>();
            nodeConfigurationSource,  
import org.apache.lucene.tests.util.LuceneTestCase;  
            cluster1.afterTest();
import org.opensearch.transport.client.Client;
            clusterManagerNodes = randomBoolean();  
        };  
        }
        String nodePrefix = randomRealisticUnicodeOfCodepointLengthBetween(1, 10);
/*
            Function.identity()
                case 2:
 */  
                }  
            public Settings nodeSettings(int nodeOrdinal) {
import org.opensearch.test.MockHttpTransport;
 *
            minNumDataNodes,
 * this file be licensed under the Apache-2.0 license or a
        } finally {
import java.util.function.Function;  
                cluster0.beforeTest(random);
        clusterUniqueSettings.add(Environment.PATH_SHARED_DATA_SETTING.getKey());  
        InternalTestCluster cluster0 = new InternalTestCluster(
            }
        clusterUniqueSettings.add(Environment.PATH_DATA_SETTING.getKey());
            assertFileExists(stableTestMarker); // but leaving the structure of existing, reused nodes
            Function.identity()
            cluster.validateClusterFormed();
            assertFileExists(testMarker); // stopping a node half way shouldn't clean data
        };  
            {
                    node = cluster.startCoordinatingOnlyNode(Settings.EMPTY);
                    return Settings.builder()  
                    cluster.startNode();  
            assertThat(stableDataPath, not(dataPath));
/**  
        );  
        } finally {  
                }
            }  
                        .build();
                : randomFrom(clusterManagerRole, DiscoveryNodeRole.DATA_ROLE, DiscoveryNodeRole.INGEST_ROLE);
            cluster.close();
                return Settings.builder()  
        clusterUniqueSettings.add(Environment.PATH_LOGS_SETTING.getKey());
        };
        Set<String> keys1 = right.keySet();
            clusterManagerNodes,
            return nodeEnvironment.nodeDataPaths();
            nodeConfigurationSource,
import java.util.HashSet;  
        NodeConfigurationSource nodeConfigurationSource = new NodeConfigurationSource() {  
    public void testDataFolderAssignmentAndCleaning() throws IOException, InterruptedException {
 * the Apache License, Version 2.0 (the "License"); you may
        );
            cluster.close();
                ? clusterManagerRole  // last node and still no cluster-manager
            bootstrapClusterManagerNodeIndex = -1;  
            }
        final boolean autoManageMinClusterManagerNodes = randomBoolean();
            Collections.emptyList(),
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFileExists;
        InternalTestCluster cluster = new InternalTestCluster(
                    cluster.stopRandomDataNode();
        public Settings additionalSettings() {  
            return Settings.builder().put("node.attr.dummy", true).build();
import java.util.HashMap;
                }
                    assertTrue(rolePaths.add(path.toString()));
        Settings defaultSettings1 = cluster1.getDefaultSettings();  
                    break;
                return Settings.builder()
 * under the License.  
            minNumDataNodes,
            new NodeConfigurationSource() {
            true,  
            minNumDataNodes = randomIntBetween(0, 3);
            switch (randomInt(2)) {  
        private final Settings settings;
 * Modifications Copyright OpenSearch Contributors. See  
        final int maxNumDataNodes = 2;  
        }
        final Path baseDir = createTempDir();  
        assertThat(cluster0.numDataNodes(), equalTo(cluster1.numDataNodes()));
        NodeConfigurationSource nodeConfigurationSource = new NodeConfigurationSource() {  
        final int numClientNodes = randomIntBetween(0, 2);
                () -> randomFrom(cluster.getNodeNames())
     */
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFileNotExists;
            final DiscoveryNodeRole role = i == numNodes - 1 && roles.contains(clusterManagerRole) == false  
            clusterSeed,
                DiscoveryNode node = cluster.getInstance(ClusterService.class, name).localNode();
        boolean clusterManagerNodes = randomBoolean();  
                final DiscoveryNodeRole role = roles.get(i);
@LuceneTestCase.SuppressFileSystems("ExtrasFS") // doesn't work with potential multi data path from test cluster yet
 * KIND, either express or implied.  See the License for the
            false,
            randomIntBetween(0, (int) roles.stream().filter(role -> role.equals(clusterManagerRole)).count() - 1)
            assertThat(result.size(), equalTo(pathsPerRole.size()));  
                return null;
        }
            cluster.close();
import java.nio.file.Path;  
            for (DiscoveryNodeRole role : result.keySet()) {
    public void testDifferentRolesMaintainPathOnRestart() throws Exception {
            randomBoolean(),
            final String newNode3 = cluster.startNode(poorNodeDataPathSettings);  
            minNumDataNodes,  
                final Settings.Builder settings = Settings.builder()  
            numClientNodes,
                if (autoManageMinClusterManagerNodes == false) {
    public static void assertClusters(InternalTestCluster cluster0, InternalTestCluster cluster1, boolean checkClusterUniqueSettings) {
                        .putList(DISCOVERY_SEED_PROVIDERS_SETTING.getKey(), "file")  
        List<Class<? extends Plugin>> plugins = new ArrayList<>(mockPlugins());  
        cluster1.setBootstrapClusterManagerNodeIndex(bootstrapClusterManagerNodeIndex);
            maxNumDataNodes,
        );
 * license agreements. See the NOTICE file distributed with
                case 0:
            0,
                    .put(DiscoveryModule.DISCOVERY_SEED_PROVIDERS_SETTING.getKey(), "file")
     * Allows to check that the full-cluster restart logic does not copy over plugin-derived settings.
        final int minNumDataNodes;
                } else if (node.isDataNode()) {
        int numClientNodes = randomIntBetween(0, 10);  
        assertClusters(cluster0, cluster1, false);  
            Files.createDirectories(newTestMarker);
        int maxNumDataNodes = randomIntBetween(minNumDataNodes, 10);  
                    .build();
import org.opensearch.node.Node.DiscoverySettings;
            final Path stableDataPath = getNodePaths(cluster, stableNode)[0];
                Client other = iterator1.next();  
        public NodeAttrCheckPlugin(Settings settings) {
            nodePrefix,  
        }
import org.opensearch.cluster.service.ClusterService;  
 * Licensed to Elasticsearch under one or more contributor  
        final int numNodes = 5;
    static final Set<String> clusterUniqueSettings = new HashSet<>();  
/*
    }  
        InternalTestCluster cluster = new InternalTestCluster(  
import java.nio.file.Files;
        String nodePrefix = "foobar";
        final int numClientNodes = randomIntBetween(0, 2);
        String nodePrefix = "test";
import java.util.Set;
import java.util.Arrays;
    public static void assertSettings(Settings left, Settings right, boolean checkClusterUniqueSettings) {
        if (nodeEnvironment.hasNodeFile()) {
    private Path[] getNodePaths(InternalTestCluster cluster, String name) {
        DiscoveryNodeRole clusterManagerRole = randomFrom(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE, DiscoveryNodeRole.MASTER_ROLE);  
            final String stableNode = randomFrom(cluster.getNodeNames());
            final Map<String, Path[]> shardNodePaths = new HashMap<>();
            randomBoolean(),
        String nodePrefix = "test";  
                assertSettings(client.settings(), other.settings(), false);
            clusterSeed,  
            keys0.size(),
            Iterator<Client> iterator1 = cluster1.getClients().iterator();  
import java.util.ArrayList;
import org.opensearch.common.util.io.IOUtils;  
            cluster0.afterTest();  
            final Path stableTestMarker = stableDataPath.resolve("stableTestMarker");  
            clusterManagerNodes,
        InternalTestCluster cluster0 = new InternalTestCluster(
        String clusterName = randomRealisticUnicodeOfCodepointLengthBetween(1, 10);
                if (role == clusterManagerRole) {  
        int minNumDataNodes = randomIntBetween(0, 9);
            clusterManagerNodes,
        Set<String> keys0 = left.keySet();  
            Files.createDirectories(stableTestMarker);
                    assert clusterManagerNodes == false;  
        }
import org.opensearch.common.network.NetworkModule;
            nodeConfigurationSource,  
import org.opensearch.test.NodeConfigurationSource;  
                n -> originalClusterManagerCount == 1 && n.equals(cluster.getClusterManagerName()),  
        final boolean clusterManagerNodes;
            autoManageMinClusterManagerNodes,
import java.util.stream.Collectors;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.test.InternalTestCluster;
            @Override
import java.util.Collection;  
    }
            roles.add(role);  
        final int minNumDataNodes = 2;
            minNumDataNodes,
            "--> left:\n" + left.toDelimitedString('\n') + "\n-->right:\n" + right.toDelimitedString('\n'),  
            public Settings nodeSettings(int nodeOrdinal) {  
    /**
                    .put(NetworkModule.TRANSPORT_TYPE_KEY, getTestTransportType());  
            for (String name : cluster.getNodeNames()) {  
 * this work for additional information regarding copyright
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
                } else {  
                @Override
        cluster.beforeTest(random());  
        // TODO: Remove this line, and replace 'clusterManagerRole' with CLUSTER_MANAGER_ROLE, after MASTER_ROLE is removed.
    }  
                    result.computeIfAbsent(DiscoveryNodeRole.INGEST_ROLE, k -> new HashSet<>()).addAll(paths);
        // It is added in 2.0, along with the introduction of CLUSTER_MANAGER_ROLE, aims to test the 2 roles have the same effect.
            },  
            numClientNodes,
     * a set of settings that are expected to have different values between clusters, even they have been initialized with the same  
            0,  
            cluster.beforeTest(random());
        cluster.setBootstrapClusterManagerNodeIndex(  
                }  
            public Path nodeConfigPath(int nodeOrdinal) {
import org.opensearch.cluster.node.DiscoveryNode;
                public Settings nodeSettings(int nodeOrdinal) {
        InternalTestCluster cluster = new InternalTestCluster(
public class InternalTestClusterTests extends OpenSearchTestCase {
            final Path newTestMarker = newDataPath.resolve("newTestMarker");  
                Random random = new Random(seed);
            }
        }  
                    assert minNumDataNodes == maxNumDataNodes;
        Path baseDir = createTempDir();
                return settings.build();
        );
            cluster.beforeTest(random());
import java.util.Iterator;
        // we need one stable node
            assertThat(getNodePaths(cluster, newNode3)[0], equalTo(dataPath));
            clusterManagerNodes = false;
 * Basic test that ensure that the internal cluster reproduces the same
        for (String key : keys0) {
            }
            minNumDataNodes = randomIntBetween(0, 4);  
            }
    }  
            clusterManagerNodes,
                        .putList(SettingsBasedSeedHostsProvider.DISCOVERY_SEED_HOSTS_SETTING.getKey())
                for (Path path : getNodePaths(cluster, node)) {
    }
            }
            String poorNode = randomValueOtherThanMany(
/*  
import org.opensearch.env.NodeEnvironment;
            autoManageMinClusterManagerNodes,  
            if (settings.get("node.attr.dummy") != null) {
    static {
            final String newNode2 = cluster.startNode();
            createTempDir(),
                        .put(DiscoverySettings.INITIAL_STATE_TIMEOUT_SETTING.getKey(), 0)
            assertTrue("key [" + key + "] is missing in " + keys1, keys1.contains(key));
            return new Path[0];
            }  
            cluster.beforeTest(random());
 * configuration given the same seed / input.
     * base settings.
                    cluster.fullRestart();  
                    result.computeIfAbsent(clusterManagerRole, k -> new HashSet<>()).addAll(paths);
                    throw new IllegalStateException("get your story straight");
        try {
                    .put(NetworkModule.TRANSPORT_TYPE_KEY, getTestTransportType())
            "clustername",  
                return null;
            false,  
            clusterSeed,  
        return Arrays.asList(getTestTransportPlugin(), MockHttpTransport.TestPlugin.class);
import org.opensearch.discovery.DiscoveryModule;
 * compatible open source license.
            assertFileNotExists(newTestMarker); // the cluster should be reset for a new test, cleaning up the extra path we made  
                assertTrue(iterator1.hasNext());
        @Override
                cluster1.beforeTest(random);  
                fail("dummy setting already exists");
                case 1:
        final String clusterName1 = "shared1";
}
            baseDir,
            }  
        InternalTestCluster cluster1 = new InternalTestCluster(  
        long clusterSeed = randomLong();  
        InternalTestCluster cluster1 = new InternalTestCluster(
            Function.identity()
            assertFileNotExists(testMarker); // a new unknown node used this path, it should be cleaned
    }  
            for (String name : cluster.getNodeNames()) {  
        plugins.add(NodeAttrCheckPlugin.class);
import java.util.Map;  
                assertThat("path are not the same for " + role, result.get(role), equalTo(pathsPerRole.get(role)));
        assertThat(
        } finally {
            mockPlugins(),  
     */
                final String node;
            numClientNodes,
            maxNumDataNodes = minNumDataNodes;
                Random random = new Random(seed);
import java.io.IOException;
 * ownership. Elasticsearch licenses this file to you under  
                    .putList(SettingsBasedSeedHostsProvider.DISCOVERY_SEED_HOSTS_SETTING.getKey())
                assertThat("data paths for " + name + " changed", getNodePaths(cluster, name), equalTo(shardNodePaths.get(name)));
import org.opensearch.env.Environment;  
    public void testTwoNodeCluster() throws Exception {  
                assertThat("data paths for " + name + " changed", getNodePaths(cluster, name), equalTo(shardNodePaths.get(name)));
        final NodeEnvironment nodeEnvironment = cluster.getInstance(NodeEnvironment.class, name);  
        } else {  
        }
                    node = cluster.startClusterManagerOnlyNode();
                } else if (role == DiscoveryNodeRole.DATA_ROLE) {
            }
            if (clusterUniqueSettings.contains(key) && checkClusterUniqueSettings == false) {
        assertClusters(cluster0, cluster1, true);
 */  
            false,
            for (Client client : cluster0.getClients()) {
        assertSettings(defaultSettings0, defaultSettings1, checkClusterUniqueSettings);
            Function.identity()
            maxNumDataNodes = randomIntBetween(minNumDataNodes, 4);
            Function.identity()
            mockPlugins(),  
            }  
            minNumDataNodes,  
        }
        NodeConfigurationSource nodeConfigurationSource = NodeConfigurationSource.EMPTY;
            @Override
            nodeConfigurationSource,
            for (int i = 0; i < numNodes; i++) {  
            randomLong(),  
            maxNumDataNodes,
        Settings defaultSettings0 = cluster0.getDefaultSettings();
            final Path newDataPath = getNodePaths(cluster, newNode2)[0];
                        .put(NetworkModule.TRANSPORT_TYPE_KEY, getTestTransportType())
        );  
            assertThat(newDataPath, not(dataPath));
            baseDir,  
        NodeConfigurationSource nodeConfigurationSource = new NodeConfigurationSource() {
            mockPlugins(),
            "test",
    public void testBeforeTest() throws Exception {
            @Override
 * You may obtain a copy of the License at  
                    result.computeIfAbsent(DiscoveryNodeRole.DATA_ROLE, k -> new HashSet<>()).addAll(paths);  
            clusterManagerNodes,  
            public Settings nodeSettings(int nodeOrdinal) {
     * Plugin that adds a simple node attribute as setting and checks if that node attribute is not already defined.  
            2,
                if (node.isClusterManagerNode()) {  
            nodePrefix,
            equalTo(keys1.size())
            final String newNode1 = cluster.startNode();
        final int bootstrapClusterManagerNodeIndex;
            }
import org.opensearch.test.OpenSearchTestCase;
            public Path nodeConfigPath(int nodeOrdinal) {  
            Path dataPath = getNodePaths(cluster, poorNode)[0];  
        );  
