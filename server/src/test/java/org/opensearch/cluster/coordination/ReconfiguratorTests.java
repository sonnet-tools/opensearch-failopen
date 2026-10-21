    }
            randomFrom(liveNodesSet),
    ) {
 * not use this file except in compliance with the License.
import org.opensearch.Version;
        // Retiring a node from a three-node cluster drops down to a one-node configuration
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfiguration;
        check(nodes("a", "b", "c", "d", "e"), conf("a", "f", "g"), false, conf("a", "b", "c", "d", "e"));
        check(nodes("a", "b", "c"), conf("a", "b"), true, conf("a", "b", "c"));
        final String[] allNodes = new String[] { "a", "b", "c", "d", "e", "f", "g" };
            liveNodesSet,
        VotingConfiguration config,
    }
        Set<String> retired,
            IllegalArgumentException.class,
 * license agreements. See the NOTICE file distributed with
        final Set<DiscoveryNode> liveNodesSet = nodes(liveNodes);
        final String[] liveNodes = new String[randomIntBetween(1, allNodes.length)];
        return new Reconfigurator(settings, new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS));
        check(nodes("a", "b"), conf("a"), true, conf("a"));
        final Reconfigurator reconfigurator = new Reconfigurator(Settings.EMPTY, clusterSettings);
        final String[] initialVotingNodes = new String[randomIntBetween(1, allNodes.length)];
        check(nodes("a", "b", "c"), conf("a", "b", "c"), true, conf("a", "b", "c"));
        check(nodes("a", "b"), conf("b"), true, conf("a"));
 * software distributed under the License is distributed on an
        final DiscoveryNode clusterManager = liveNodes.stream().filter(n -> n.getId().equals(clusterManagerId)).findFirst().get();
        check(nodes("a", "b", "c"), conf("a", "b"), false, conf("a", "b", "c"));
            equalTo(conf("a", "b", "c", "e"))
            liveNodes.add(new DiscoveryNode(id, buildNewFakeTransportAddress(), Version.CURRENT));
 * this file be licensed under the Apache-2.0 license or a
        final VotingConfiguration initialConfig = conf(initialVotingNodes);
        check(nodes("a", "b"), conf("a", "b"), false, conf("a", "b"));
    private void check(
import java.util.stream.Collectors;
        // Only two non-retired nodes in the config, so new config does not shrink below 2
        boolean autoShrinkVotingConfiguration,
import java.util.HashSet;
        boolean autoShrinkVotingConfiguration,
        check(nodes("a", "b"), conf("a"), false, conf("a"));
 */
import org.opensearch.common.settings.Settings.Builder;
        return new VotingConfiguration(Sets.newHashSet(nodes));
import static org.hamcrest.Matchers.equalTo;
                                                                                                                                       // quorum
        final String[] liveNodes = new String[randomIntBetween(1, allNodes.length)];
        check(nodes("a", "b"), conf("a", "c"), true, conf("a"));
    }
        } else {
    private void check(
        check(nodes("a", "b"), retired("a"), conf("a"), false, conf("b"));
        } else {
            liveNodesSet,
        // 7 nodes, one for each combination of live/retired/current. Ideally we want the config to be the non-retired live nodes.
 * Unless required by applicable law or agreed to in writing,
        check(nodes("a", "b", "c", "f"), retired("c", "e", "f", "g"), conf("a", "c", "d", "e", "h"), false, conf("a", "b", "d"));
        randomSubsetOf(initialVotingNodes.length, allNodes).toArray(initialVotingNodes);
        // Three non-retired nodes in the config, so new config does not shrink below 3
        check(nodes("a", "b", "c", "f"), retired("c", "e", "f", "g"), conf("a", "c", "d", "e"), false, conf("a", "b"));
import org.opensearch.test.OpenSearchTestCase;
            final List<String> expectedQuorum = randomSubsetOf(quorumSize, liveNodes);
        final int quorumSize = Math.max(liveNodes.length / 2 + 1, initialVotingNodes.length < 3 ? 1 : 2);
                config,
        check(nodes("a", "b", "c", "d", "e"), conf("a", "b", "c"), true, conf("a", "b", "c", "d", "e"));
    }
        expectThrows(
            new ParameterizedMessage(
            final List<String> expectedQuorum = randomSubsetOf(quorumSize, liveNodes);
            ).getFormattedMessage(),
import static org.hamcrest.Matchers.sameInstance;
        // explicitly set to "true"
        final VotingConfiguration initialConfig = conf(initialVotingNodes);
        check(nodes("a", "b", "c"), conf("a", "b", "c", "d", "e"), false, conf("a", "b", "c", "d", "e"));
public class ReconfiguratorTests extends OpenSearchTestCase {
        check(nodes("a", "b", "c"), conf("a", "b", "e"), false, conf("a", "b", "c"));
                autoShrinkVotingConfiguration
        final VotingConfiguration adaptedConfig = reconfigurator.reconfigure(liveNodes, retired, clusterManager, config);
        assertThat(
        check(nodes("a", "b", "c"), retired("a"), conf("a", "b", "c"), false, conf("b", "c"));
 *
import org.opensearch.common.util.set.Sets;
 * KIND, either express or implied.  See the License for the
import java.util.Arrays;
        Set<DiscoveryNode> liveNodes,
/*
import java.util.List;
        final Builder settingsBuilder = Settings.builder();
 * specific language governing permissions and limitations
        final int quorumSize = Math.max(liveNodes.length, initialVotingNodes.length) / 2 + 1;
        check(nodes("a", "b", "c"), retired("a"), conf("a"), true, conf("b"));
 * Modifications Copyright OpenSearch Contributors. See
                retired,
        check(nodes("a", "b"), conf("a", "b"), true, conf("a"));
        final Reconfigurator reconfigurator = makeReconfigurator(
    ) {
        Set<DiscoveryNode> threeNodes = nodes("a", "b", "c");
            initialConfig
import java.util.Set;
    ) {
        // Since there are 2 non-retired live nodes we round down to 1 and just use the one that's already in the config.
 * compatible open source license.
        check(nodes("a", "b"), retired("a"), conf("a"), true, conf("b"));
        boolean autoShrinkVotingConfiguration,
        VotingConfiguration expectedConfig
}
        check(nodes("a", "b", "c"), conf("a", "b", "e"), true, conf("a", "b", "c"));
    }
        clusterSettings.applySettings(Settings.builder().put(CLUSTER_AUTO_SHRINK_VOTING_CONFIGURATION.getKey(), "true").build());
        check(nodes("a"), conf("a"), false, conf("a"));
        }
            initialConfig
 * SPDX-License-Identifier: Apache-2.0
        check(nodes("a", "b", "c", "d", "e"), conf("a", "b", "c"), false, conf("a", "b", "c", "d", "e"));
 * The OpenSearch Contributors require contributions made to
            expectedConfig,
        randomSubsetOf(liveNodes.length, allNodes).toArray(liveNodes);
        check(liveNodes, retired, clusterManager.getId(), config, autoShrinkVotingConfiguration, expectedConfig);
        );
import org.opensearch.cluster.node.DiscoveryNode;
        check(nodes("a", "b", "c"), conf("a"), false, conf("a", "b", "c"));
import org.junit.Before;
        check(nodes("a", "b"), conf("a", "b", "e"), false, conf("a", "b", "e"));
        final String description = "reconfigure " + liveNodesSet + " from " + initialConfig + " yielded " + finalConfig;
 */
    @Before
        for (String id : nodes) {
        assertThat(
    private Set<DiscoveryNode> nodes(String... nodes) {
            assertFalse(description + " without a live quorum", finalConfig.hasQuorum(Arrays.asList(liveNodes)));
import org.opensearch.common.settings.ClusterSettings;
            equalTo(conf("a", "b", "c", "d", "e"))
 * GitHub history for details.
    private void check(
        }
    public void testAutoShrinking() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                liveNodes,
        assertEquals(
    private Reconfigurator makeReconfigurator(Settings settings) {
 */
        check(nodes("a", "b", "c"), conf("a", "b", "c"), false, conf("a", "b", "c"));
        // Retiring a single node shifts the votes elsewhere if possible.
 *
        check(nodes("a", "b"), conf("a", "b", "e"), false, conf("a", "b", "e"));
        if (quorumSize > liveNodes.length) {
        final Reconfigurator reconfigurator = makeReconfigurator(
    private Set<String> retired(String... nodes) {
        return Arrays.stream(nodes).collect(Collectors.toSet());
        check(liveNodes, retired(), config, autoShrinkVotingConfiguration, expectedConfig);
        assertThat(reconfigurator.reconfigure(twoNodes, retired(), randomFrom(twoNodes), initialConfig), equalTo(conf("a", "b", "c")));
            reconfigurator.reconfigure(threeNodes, retired("d"), randomFrom(threeNodes), initialConfig),
        check(nodes("a", "b", "c", "d"), conf("a", "b", "c"), false, conf("a", "b", "c"));
import static org.opensearch.cluster.coordination.Reconfigurator.CLUSTER_AUTO_SHRINK_VOTING_CONFIGURATION;
        VotingConfiguration expectedConfig
        if (randomBoolean()) {
        VotingConfiguration expectedConfig
            assertFalse(description + " without a live quorum", finalConfig.hasQuorum(Arrays.asList(liveNodes)));
        final DiscoveryNode clusterManager = liveNodes.stream().sorted(Comparator.comparing(DiscoveryNode::getId)).findFirst().get();
        check(nodes("a", "b", "c", "d"), conf("a", "b", "c"), true, conf("a", "b", "c"));
                clusterManager,
    }
            () -> clusterSettings.applySettings(Settings.builder().put(CLUSTER_AUTO_SHRINK_VOTING_CONFIGURATION.getKey(), "blah").build())
    public void testReconfigurationExamples() {
        final String[] allNodes = new String[] { "a", "b", "c", "d", "e", "f", "g" };
            randomFrom(liveNodesSet),
                "[liveNodes={}, retired={}, clusterManager={}, config={}, autoShrinkVotingConfiguration={}]",
/*
        if (quorumSize > liveNodes.length) {
        final String[] initialVotingNodes = new String[randomIntBetween(1, allNodes.length)];
        );
        );
 * You may obtain a copy of the License at
        final VotingConfiguration finalConfig = reconfigurator.reconfigure(
            Settings.builder().put(CLUSTER_AUTO_SHRINK_VOTING_CONFIGURATION.getKey(), false).build()
        check(nodes("a", "b", "c", "f"), retired("c", "e", "f", "g"), conf("a", "c", "d", "e", "h"), true, conf("a", "b", "d"));
        final Reconfigurator reconfigurator = makeReconfigurator(settingsBuilder.build());
            settingsBuilder.put(CLUSTER_AUTO_SHRINK_VOTING_CONFIGURATION.getKey(), true);
 *
        check(nodes("a", "b", "c"), retired("a"), conf("a", "b", "c"), true, conf("b"));
    public void testDynamicSetting() {
        assertThat(reconfigurator.reconfigure(twoNodes, retired(), randomFrom(twoNodes), initialConfig), equalTo(conf("a", "b", "c")));
        );
    }
        final Set<DiscoveryNode> liveNodes = new HashSet<>();
        VotingConfiguration config,
        check(nodes("a", "b", "c", "d"), conf("a", "b", "c", "d", "e"), true, conf("a", "b", "c"));
 *     http://www.apache.org/licenses/LICENSE-2.0
        check(nodes("a", "b", "c"), conf("a", "b", "c", "d", "e"), true, conf("a", "b", "c"));
    }
        Set<DiscoveryNode> liveNodes,
    public void testManualShrinking() {
            reconfigurator.reconfigure(threeNodes, retired(), randomFrom(threeNodes), initialConfig),
        resetPortCounter();
        String clusterManagerId,
        check(nodes("a", "b"), conf("a", "c"), false, conf("a", "b"));
import static java.util.Collections.emptySet;
        Set<DiscoveryNode> twoNodes = nodes("a", "b");
        clusterSettings.applySettings(Settings.builder().put(CLUSTER_AUTO_SHRINK_VOTING_CONFIGURATION.getKey(), "false").build());
            assertTrue(description + " with quorum[" + quorumSize + "] of " + expectedQuorum, finalConfig.hasQuorum(expectedQuorum));
            adaptedConfig
        check(nodes("a", "b", "c", "d"), conf("a", "b", "c", "d", "e"), false, conf("a", "b", "c", "d", "e"));
            emptySet(),
        );
        // update to "false"
        final Set<DiscoveryNode> liveNodesSet = nodes(liveNodes);
        check(nodes("e", "a", "b", "c"), retired(), "e", conf("a", "b", "c", "d", "e"), true, conf("a", "b", "e"));
 * ownership. Elasticsearch licenses this file to you under
    private VotingConfiguration conf(String... nodes) {
        check(nodes("a", "b", "c"), retired("a"), conf("a"), false, conf("b"));
        // The config has at least three non-retired nodes so does not shrink below 3
            emptySet(),
 * the Apache License, Version 2.0 (the "License"); you may
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        final VotingConfiguration finalConfig = reconfigurator.reconfigure(
        Set<String> retired,
        check(nodes("a", "b", "c", "f"), retired("c", "e", "f", "g"), conf("a", "c", "d", "e"), true, conf("a"));
        check(nodes("a", "b", "c", "d", "e"), conf("a", "f", "g"), true, conf("a", "b", "c", "d", "e"));
import org.apache.logging.log4j.message.ParameterizedMessage;
        VotingConfiguration config,
        }
        );
        assertThat(reconfigurator.reconfigure(twoNodes, retired(), randomFrom(twoNodes), initialConfig), sameInstance(initialConfig)); // no
import java.util.Comparator;
        Set<DiscoveryNode> liveNodes,
 * under the License.
 * Licensed to Elasticsearch under one or more contributor
        randomSubsetOf(initialVotingNodes.length, allNodes).toArray(initialVotingNodes);
            Settings.builder().put(CLUSTER_AUTO_SHRINK_VOTING_CONFIGURATION.getKey(), autoShrinkVotingConfiguration).build()
        );
        return liveNodes;
        final String description = "reconfigure " + liveNodesSet + " from " + initialConfig + " yielded " + finalConfig;
    public void resetPortCounterBeforeTest() {
    }
    }
        // default is "true"
        randomSubsetOf(liveNodes.length, allNodes).toArray(liveNodes);
        check(nodes("a"), conf("a"), true, conf("a"));
            assertTrue(description + " with quorum[" + quorumSize + "] of " + expectedQuorum, finalConfig.hasQuorum(expectedQuorum));
        check(nodes("a", "b"), conf("a", "b", "e"), true, conf("a", "b", "e"));
        );
    }
import org.opensearch.common.settings.Settings;
        check(nodes("a", "b", "c", "d"), conf("a", "b", "e"), false, conf("a", "b", "c"));
package org.opensearch.cluster.coordination;
    }
 * this work for additional information regarding copyright
        check(nodes("a", "b", "c", "d"), conf("a", "b", "e"), true, conf("a", "b", "c"));
/*
        final VotingConfiguration initialConfig = conf("a", "b", "c", "d", "e");
        }
        check(nodes("a", "b", "c"), conf("a"), true, conf("a", "b", "c"));
