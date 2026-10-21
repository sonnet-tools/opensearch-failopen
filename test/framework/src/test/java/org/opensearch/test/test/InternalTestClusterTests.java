            minNumDataNodes,
        Set<String> keys1 = right.keySet();
            randomIntBetween(0, (int) roles.stream().filter(role -> role.equals(clusterManagerRole)).count() - 1)
                    cluster.startNode();
            mockPlugins(),
 *
        int maxNumDataNodes = randomIntBetween(minNumDataNodes, 10);
package org.opensearch.test.test;
                    node = cluster.startDataOnlyNode();
        cluster0.setBootstrapClusterManagerNodeIndex(bootstrapClusterManagerNodeIndex);
            final String newNode1 = cluster.startNode();
            assertFileExists(stableTestMarker); // but leaving the structure of existing, reused nodes
                }
            final String stableNode = randomFrom(cluster.getNodeNames());
        assertThat(
        Set<String> keys0 = left.keySet();
 * compatible open source license.
            2,
            Map<DiscoveryNodeRole, Set<String>> result = new HashMap<>();
                    result.computeIfAbsent(DiscoveryNodeRole.INGEST_ROLE, k -> new HashSet<>()).addAll(paths);
            nodeConfigurationSource,
            assertFileExists(testMarker); // starting a node should re-use data folders and not clean it
            }
                    node = cluster.startCoordinatingOnlyNode(Settings.EMPTY);
            for (String name : cluster.getNodeNames()) {
            final Path newDataPath = getNodePaths(cluster, newNode2)[0];
    public void testDataFolderAssignmentAndCleaning() throws IOException, InterruptedException {
        NodeConfigurationSource nodeConfigurationSource = new NodeConfigurationSource() {
            autoManageMinClusterManagerNodes,
        }
import org.opensearch.cluster.service.ClusterService;
 * GitHub history for details.
                if (node.isClusterManagerNode()) {
 * Unless required by applicable law or agreed to in writing,
            clusterManagerNodes = randomBoolean();
            }
        String nodePrefix = "test";
            0,
                assertTrue(iterator1.hasNext());
                for (Path path : getNodePaths(cluster, node)) {
            bootstrapClusterManagerNodeIndex = maxNumDataNodes == 0 ? -1 : randomIntBetween(0, maxNumDataNodes - 1);
            mockPlugins(),
            final Map<String, Path[]> shardNodePaths = new HashMap<>();
            randomBoolean(),
        final int numNodes = 5;
            keys0.size(),
 * software distributed under the License is distributed on an
        );
            @Override
import java.util.Set;
        // we need one stable node
                assertSettings(client.settings(), other.settings(), false);
            cluster.close();
            return nodeEnvironment.nodeDataPaths();
            cluster.close();
            maxNumDataNodes,
                    .putList(DISCOVERY_SEED_PROVIDERS_SETTING.getKey(), "file")
            return Settings.builder().put("node.attr.dummy", true).build();
            Function.identity()
            0,
        Path baseDir = createTempDir();
            },
 */
            baseDir,
        InternalTestCluster cluster = new InternalTestCluster(
            baseDir,
        }
                    .put(NetworkModule.TRANSPORT_TYPE_KEY, getTestTransportType());
            final String newNode3 = cluster.startNode(poorNodeDataPathSettings);
            nodeConfigurationSource,
        // It is added in 2.0, along with the introduction of CLUSTER_MANAGER_ROLE, aims to test the 2 roles have the same effect.
        );
            for (int i = 0; i < numNodes; i++) {
        final boolean clusterManagerNodes;
        String nodePrefix = "foobar";
        );
import org.opensearch.test.MockHttpTransport;
 *
            @Override
import java.util.function.Function;
    /**
                    break;
            numClientNodes,
                ? clusterManagerRole  // last node and still no cluster-manager
            numClientNodes,
                cluster1.beforeTest(random);
        } finally {
            clusterManagerNodes,
@LuceneTestCase.SuppressFileSystems("ExtrasFS") // doesn't work with potential multi data path from test cluster yet
import static org.hamcrest.Matchers.not;
                cluster0.beforeTest(random);
                        .putList(SettingsBasedSeedHostsProvider.DISCOVERY_SEED_HOSTS_SETTING.getKey())
            autoManageMinClusterManagerNodes,
 * configuration given the same seed / input.
        assertSettings(defaultSettings0, defaultSettings1, checkClusterUniqueSettings);
            minNumDataNodes,
    private Path[] getNodePaths(InternalTestCluster cluster, String name) {
        int numClientNodes = randomIntBetween(0, 10);
            createTempDir(),
                public Path nodeConfigPath(int nodeOrdinal) {
                    .putList(SettingsBasedSeedHostsProvider.DISCOVERY_SEED_HOSTS_SETTING.getKey())
        @Override
import org.opensearch.discovery.DiscoveryModule;
                    cluster.rollingRestart(InternalTestCluster.EMPTY_CALLBACK);
            "--> left:\n" + left.toDelimitedString('\n') + "\n-->right:\n" + right.toDelimitedString('\n'),
    public void testDifferentRolesMaintainPathOnRestart() throws Exception {
            Function.identity()
     * base settings.
        NodeConfigurationSource nodeConfigurationSource = new NodeConfigurationSource() {
                    throw new IllegalStateException("get your story straight");
    public static void assertSettings(Settings left, Settings right, boolean checkClusterUniqueSettings) {
                        .putList(DISCOVERY_SEED_PROVIDERS_SETTING.getKey(), "file")
            minNumDataNodes,
                } else if (role == DiscoveryNodeRole.DATA_ROLE) {
    /**
            2,
 */
            maxNumDataNodes,
            cluster.beforeTest(random());
        }
    }
        String clusterName = randomRealisticUnicodeOfCodepointLengthBetween(1, 10);
                        .build();
            }
                Client other = iterator1.next();
            minNumDataNodes = randomIntBetween(0, 4);
            for (String name : cluster.getNodeNames()) {
            0,
            clusterSeed,
        NodeConfigurationSource nodeConfigurationSource = NodeConfigurationSource.EMPTY;
                List<String> paths = Arrays.stream(getNodePaths(cluster, name)).map(Path::toString).collect(Collectors.toList());
            plugins,
                case 2:
        }
                }
        long clusterSeed = randomLong();
            numClientNodes,
                public Settings nodeSettings(int nodeOrdinal) {
 * Licensed to Elasticsearch under one or more contributor
                    break;
 */
import org.opensearch.cluster.node.DiscoveryNodeRole;
        Path baseDir = createTempDir();
        long clusterSeed = randomLong();
    }
            @Override
        clusterUniqueSettings.add(Environment.PATH_LOGS_SETTING.getKey());
            );
import org.opensearch.test.InternalTestCluster;
     */
        private final Settings settings;
    public void testTwoNodeCluster() throws Exception {
    }
import java.util.Iterator;
            if (clusterUniqueSettings.contains(key) && checkClusterUniqueSettings == false) {
            @Override
    public static void assertClusters(InternalTestCluster cluster0, InternalTestCluster cluster1, boolean checkClusterUniqueSettings) {
                    .put(DiscoveryModule.DISCOVERY_SEED_PROVIDERS_SETTING.getKey(), "file")
            final Path testMarker = dataPath.resolve("testMarker");
        final NodeEnvironment nodeEnvironment = cluster.getInstance(NodeEnvironment.class, name);
        for (int i = 0; i < numNodes; i++) {
            cluster.beforeTest(random());
     * Plugin that adds a simple node attribute as setting and checks if that node attribute is not already defined.
                return null;
            Files.createDirectories(testMarker);
        int minNumDataNodes = randomIntBetween(0, 9);
            @Override
            new NodeConfigurationSource() {
            clusterSeed,
            final String newNode2 = cluster.startNode();
                    .putList(SettingsBasedSeedHostsProvider.DISCOVERY_SEED_HOSTS_SETTING.getKey())
            clusterName1,
            "clustername",
            Function.identity()
            String poorNode = randomValueOtherThanMany(
            clusterManagerNodes,
            }
        // TODO: Remove this line, and replace 'clusterManagerRole' with CLUSTER_MANAGER_ROLE, after MASTER_ROLE is removed.
                return null;
            roles.add(role);
    public void testInitializiationIsConsistent() {
        final boolean autoManageMinClusterManagerNodes = randomBoolean();
            Collections.emptyList(),
        try {
import org.opensearch.test.OpenSearchTestCase;
                    .build();
                } else if (node.isDataNode()) {
        try {
            cluster.fullRestart();
            // if we manage min cluster-manager nodes, we need to lock down the number of nodes
 * specific language governing permissions and limitations
import java.util.Collections;
            assertFileNotExists(newTestMarker); // the cluster should be reset for a new test, cleaning up the extra path we made
        );
    static {
                    .put(NetworkModule.TRANSPORT_TYPE_KEY, getTestTransportType())
                    .putList(SettingsBasedSeedHostsProvider.DISCOVERY_SEED_HOSTS_SETTING.getKey())
                    cluster.stopRandomDataNode();
            clusterManagerNodes = false;
        boolean clusterManagerNodes = randomBoolean();
                    assert clusterManagerNodes == false;
            clusterSeed,
            baseDir,
 * The OpenSearch Contributors require contributions made to
            maxNumDataNodes = randomIntBetween(minNumDataNodes, 4);
                    .put(NetworkModule.TRANSPORT_TYPE_KEY, getTestTransportType())
                Random random = new Random(seed);
 *
            assertTrue("key [" + key + "] is missing in " + keys1, keys1.contains(key));
                shardNodePaths.put(name, getNodePaths(cluster, name));
            cluster.beforeTest(random());
            final int originalClusterManagerCount = cluster.numClusterManagerNodes();
            assertFileExists(stableTestMarker); // but leaving the structure of existing, reused nodes
    }
                    .build();
            minNumDataNodes = randomIntBetween(0, 3);
 * Basic test that ensure that the internal cluster reproduces the same
 * SPDX-License-Identifier: Apache-2.0
            Iterator<Client> iterator1 = cluster1.getClients().iterator();
import java.util.Random;
            public Settings nodeSettings(int nodeOrdinal) {
            this.settings = settings;
        boolean clusterManagerNodes = randomBoolean();
                @Override
     * a set of settings that are expected to have different values between clusters, even they have been initialized with the same
import java.util.ArrayList;
            {
import java.util.HashSet;
        InternalTestCluster cluster0 = new InternalTestCluster(
import java.util.stream.Collectors;
        assertClusters(cluster0, cluster1, true);
            assertEquals(key, right.get(key), left.get(key));
        NodeConfigurationSource nodeConfigurationSource = new NodeConfigurationSource() {
            final DiscoveryNodeRole role = i == numNodes - 1 && roles.contains(clusterManagerRole) == false
            }
            baseDir,
                return Settings.builder()
            nodePrefix,
        Settings defaultSettings0 = cluster0.getDefaultSettings();
            nodeConfigurationSource,
        clusterUniqueSettings.add(Environment.PATH_HOME_SETTING.getKey());
                case 0:
            assertThat(newDataPath, not(dataPath));
/*
            Function.identity()
        InternalTestCluster cluster1 = new InternalTestCluster(
        for (String key : keys0) {
            }
        InternalTestCluster cluster0 = new InternalTestCluster(
import java.util.HashMap;
/*
import java.util.Arrays;
            Map<DiscoveryNodeRole, Set<String>> pathsPerRole = new HashMap<>();
            clusterSeed,
        final int numClientNodes = randomIntBetween(0, 2);
                    break;
            }
        };
            numClientNodes,
            for (String name : cluster.getNodeNames()) {
        return Arrays.asList(getTestTransportPlugin(), MockHttpTransport.TestPlugin.class);
            maxNumDataNodes,
            public Settings nodeSettings(int nodeOrdinal) {
                assertThat("path are not the same for " + role, result.get(role), equalTo(pathsPerRole.get(role)));
                    return null;
                fail("dummy setting already exists");
        final int maxNumDataNodes = 2;
                final String node;
            IOUtils.close(cluster0, cluster1);
            }
            clusterManagerNodes,
            clusterManagerNodes,
            assertFileNotExists(testMarker); // a new unknown node used this path, it should be cleaned
        } finally {
            randomBoolean(),
            cluster0.afterTest();
                    result.computeIfAbsent(DiscoveryNodeRole.DATA_ROLE, k -> new HashSet<>()).addAll(paths);
        final int numClientNodes = randomIntBetween(0, 2);
                Random random = new Random(seed);
    }
                    assert minNumDataNodes == maxNumDataNodes;
            }
            }
    }
            nodePrefix,
            for (DiscoveryNodeRole role : result.keySet()) {
        try {
 * this work for additional information regarding copyright
                    cluster.fullRestart();
            public Path nodeConfigPath(int nodeOrdinal) {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFileExists;
        );
import org.opensearch.common.network.NetworkModule;
            }
            equalTo(keys1.size())
    private static Collection<Class<? extends Plugin>> mockPlugins() {
        if (nodeEnvironment.hasNodeFile()) {
            if (settings.get("node.attr.dummy") != null) {
        } finally {
            minNumDataNodes,
            mockPlugins(),
        };
            "",
        final Path baseDir = createTempDir();
                continue;
            }
            assertThat(stableDataPath, not(dataPath));
            for (Client client : cluster0.getClients()) {
            final Path stableDataPath = getNodePaths(cluster, stableNode)[0];
            randomLong(),
            true,
            Function.identity()
            final Path newTestMarker = newDataPath.resolve("newTestMarker");
            {
        DiscoveryNodeRole clusterManagerRole = randomFrom(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE, DiscoveryNodeRole.MASTER_ROLE);
                DiscoveryNode node = cluster.getInstance(ClusterService.class, name).localNode();
        } finally {
    public static class NodeAttrCheckPlugin extends Plugin {
            assertThat(getNodePaths(cluster, newNode3)[0], equalTo(dataPath));
        } else {
            return new Path[0];
import java.nio.file.Path;
import java.util.Collection;
                }
            final Path stableTestMarker = stableDataPath.resolve("stableTestMarker");
    }
        public Settings additionalSettings() {
     */
import org.opensearch.test.NodeConfigurationSource;
            switch (randomInt(2)) {
            nodePrefix,
    }
        } else {
        Settings defaultSettings1 = cluster1.getDefaultSettings();
                if (role == clusterManagerRole) {
            cluster.beforeTest(random());
import java.util.List;
            nodeConfigurationSource,
import static org.hamcrest.Matchers.equalTo;
            bootstrapClusterManagerNodeIndex = -1;
            public Settings nodeSettings(int nodeOrdinal) {
        };
            @Override
                return settings.build();
/**
            }
import org.opensearch.plugins.Plugin;
                assertThat("data paths for " + name + " changed", getNodePaths(cluster, name), equalTo(shardNodePaths.get(name)));
    }
                        .put(NetworkModule.TRANSPORT_TYPE_KEY, getTestTransportType())
            assertFileExists(testMarker); // stopping a node half way shouldn't clean data
        final int maxNumDataNodes;
                        .put(DiscoverySettings.INITIAL_STATE_TIMEOUT_SETTING.getKey(), 0)
            false,
        long clusterSeed = randomLong();
            nodePrefix,
     * Allows to check that the full-cluster restart logic does not copy over plugin-derived settings.
import org.opensearch.common.util.io.IOUtils;
        long seed = randomLong();
            false,
                Set<String> rolePaths = pathsPerRole.computeIfAbsent(role, k -> new HashSet<>());
        );
        }
        );
import java.util.Map;
            nodePrefix,
        List<Class<? extends Plugin>> plugins = new ArrayList<>(mockPlugins());
import java.io.IOException;
            cluster1.afterTest();
 * You may obtain a copy of the License at
            public Path nodeConfigPath(int nodeOrdinal) {
            false,
            }
                final Settings.Builder settings = Settings.builder()
        cluster.setBootstrapClusterManagerNodeIndex(
    }
 * ownership. Elasticsearch licenses this file to you under
            randomLong(),
            Collections.emptyList(),
        final String clusterName1 = "shared1";
            assertThat(getNodePaths(cluster, newNode1)[0], not(dataPath));
            }
import org.opensearch.transport.client.Client;
 * license agreements. See the NOTICE file distributed with
        String nodePrefix = "test";
                assertThat("data paths for " + name + " changed", getNodePaths(cluster, name), equalTo(shardNodePaths.get(name)));
 * not use this file except in compliance with the License.
        cluster1.setBootstrapClusterManagerNodeIndex(bootstrapClusterManagerNodeIndex);
            clusterName,
/*
        );
        assertThat(cluster0.numDataNodes(), equalTo(cluster1.numDataNodes()));
                return null;
            clusterManagerNodes,
}
                case 1:
    }
        List<DiscoveryNodeRole> roles = new ArrayList<>();
import org.opensearch.env.Environment;
        try {
import org.opensearch.env.NodeEnvironment;
                }
            Files.createDirectories(newTestMarker);
            maxNumDataNodes = minNumDataNodes;
        Path baseDir = createTempDir();
 * the Apache License, Version 2.0 (the "License"); you may
                } else {
import org.opensearch.cluster.node.DiscoveryNode;
                    assertTrue(rolePaths.add(path.toString()));
        clusterUniqueSettings.add(Environment.PATH_DATA_SETTING.getKey());
            mockPlugins(),
            cluster.close();
 * Modifications Copyright OpenSearch Contributors. See
        }
            final Settings poorNodeDataPathSettings = cluster.dataPathSettings(poorNode);
    public void testBeforeTest() throws Exception {
            }
 * under the License.
            assertArrayEquals(cluster0.getNodeNames(), cluster1.getNodeNames());
                }
 */
                return Settings.builder()
        cluster.beforeTest(random());
            minNumDataNodes,
            assertThat(result.size(), equalTo(pathsPerRole.size()));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            "test",
            baseDir,
                : randomFrom(clusterManagerRole, DiscoveryNodeRole.DATA_ROLE, DiscoveryNodeRole.INGEST_ROLE);
        InternalTestCluster cluster = new InternalTestCluster(
            clusterName,
            Function.identity()
        assertClusters(cluster0, cluster1, false);
import org.opensearch.discovery.SettingsBasedSeedHostsProvider;
        }
        );
            "clustername",
import static org.opensearch.discovery.DiscoveryModule.DISCOVERY_SEED_PROVIDERS_SETTING;
                () -> randomFrom(cluster.getNodeNames())
        InternalTestCluster cluster1 = new InternalTestCluster(
            maxNumDataNodes,
import org.opensearch.node.Node.DiscoverySettings;
                    return Settings.builder()
        public NodeAttrCheckPlugin(Settings settings) {
            Path dataPath = getNodePaths(cluster, poorNode)[0];
                }
import org.opensearch.common.settings.Settings;
            Function.identity()
        final int minNumDataNodes;
 * KIND, either express or implied.  See the License for the
                n -> originalClusterManagerCount == 1 && n.equals(cluster.getClusterManagerName()),
                    node = cluster.startClusterManagerOnlyNode();
                } else {
        final int bootstrapClusterManagerNodeIndex;
            cluster.validateClusterFormed();
            nodeConfigurationSource,
                @Override
        }
            for (String name : cluster.getNodeNames()) {
        clusterUniqueSettings.add(Environment.PATH_SHARED_DATA_SETTING.getKey());
                } else if (role == DiscoveryNodeRole.INGEST_ROLE) {
        InternalTestCluster cluster = new InternalTestCluster(
                    result.computeIfAbsent(clusterManagerRole, k -> new HashSet<>()).addAll(paths);
            cluster.stopRandomNode(InternalTestCluster.nameFilter(poorNode));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFileNotExists;
            maxNumDataNodes,
            0,
        }
            "test",
            public Path nodeConfigPath(int nodeOrdinal) {
            createTempDir(),
            }
            clusterSeed,
                if (autoManageMinClusterManagerNodes == false) {
                    .putList(DISCOVERY_SEED_PROVIDERS_SETTING.getKey(), "file")
            Files.createDirectories(stableTestMarker);
        String nodePrefix = randomRealisticUnicodeOfCodepointLengthBetween(1, 10);
        if (autoManageMinClusterManagerNodes) {
            numClientNodes,
import org.apache.lucene.tests.util.LuceneTestCase;
            }
            nodeConfigurationSource,
    static final Set<String> clusterUniqueSettings = new HashSet<>();
public class InternalTestClusterTests extends OpenSearchTestCase {
 *     http://www.apache.org/licenses/LICENSE-2.0
                final DiscoveryNodeRole role = roles.get(i);
        plugins.add(NodeAttrCheckPlugin.class);
 * this file be licensed under the Apache-2.0 license or a
import java.nio.file.Files;
        }
        clusterUniqueSettings.add(Environment.PATH_REPO_SETTING.getKey());
            nodePrefix,
            true,
        final int minNumDataNodes = 2;
