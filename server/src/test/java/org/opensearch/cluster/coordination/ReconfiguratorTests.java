        // explicitly set to "true"  
            reconfigurator.reconfigure(threeNodes, retired("d"), randomFrom(threeNodes), initialConfig),
        check(nodes("a", "b", "c"), conf("a", "b", "e"), true, conf("a", "b", "c"));
        final String[] allNodes = new String[] { "a", "b", "c", "d", "e", "f", "g" };
            final List<String> expectedQuorum = randomSubsetOf(quorumSize, liveNodes);
        check(nodes("a", "b", "c"), retired("a"), conf("a"), false, conf("b"));  
 * license agreements. See the NOTICE file distributed with
        // Since there are 2 non-retired live nodes we round down to 1 and just use the one that's already in the config.
 *  
import org.junit.Before;
        final int quorumSize = Math.max(liveNodes.length / 2 + 1, initialVotingNodes.length < 3 ? 1 : 2);
 * software distributed under the License is distributed on an
            randomFrom(liveNodesSet),
        // Only two non-retired nodes in the config, so new config does not shrink below 2  
    }  
        final VotingConfiguration finalConfig = reconfigurator.reconfigure(
import java.util.Set;
        final Reconfigurator reconfigurator = makeReconfigurator(settingsBuilder.build());
            assertFalse(description + " without a live quorum", finalConfig.hasQuorum(Arrays.asList(liveNodes)));  
                liveNodes,  
        assertThat(reconfigurator.reconfigure(twoNodes, retired(), randomFrom(twoNodes), initialConfig), sameInstance(initialConfig)); // no
            Settings.builder().put(CLUSTER_AUTO_SHRINK_VOTING_CONFIGURATION.getKey(), false).build()
        final VotingConfiguration adaptedConfig = reconfigurator.reconfigure(liveNodes, retired, clusterManager, config);
        // The config has at least three non-retired nodes so does not shrink below 3  
        check(nodes("a", "b", "c", "f"), retired("c", "e", "f", "g"), conf("a", "c", "d", "e"), false, conf("a", "b"));
        check(liveNodes, retired(), config, autoShrinkVotingConfiguration, expectedConfig);
        check(nodes("a", "b"), conf("a", "b"), false, conf("a", "b"));
                clusterManager,
import java.util.stream.Collectors;
    }
    private Set<DiscoveryNode> nodes(String... nodes) {
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    }
public class ReconfiguratorTests extends OpenSearchTestCase {  
        check(nodes("a", "b", "c", "d", "e"), conf("a", "b", "c"), false, conf("a", "b", "c", "d", "e"));
 * specific language governing permissions and limitations
        check(nodes("a", "b", "c"), conf("a", "b", "c", "d", "e"), false, conf("a", "b", "c", "d", "e"));  
        check(nodes("a", "b", "c"), retired("a"), conf("a"), true, conf("b"));
        final Set<DiscoveryNode> liveNodesSet = nodes(liveNodes);
    private Set<String> retired(String... nodes) {
import org.opensearch.common.settings.ClusterSettings;
        // default is "true"
        }  
import static org.opensearch.cluster.coordination.Reconfigurator.CLUSTER_AUTO_SHRINK_VOTING_CONFIGURATION;
        check(nodes("a", "b", "c", "d"), conf("a", "b", "c"), true, conf("a", "b", "c"));  
        VotingConfiguration config,
import java.util.Comparator;
        Set<String> retired,  
        check(nodes("a", "b", "c", "d"), conf("a", "b", "c"), false, conf("a", "b", "c"));  
            IllegalArgumentException.class,
        expectThrows(
 * under the License.  
        final VotingConfiguration finalConfig = reconfigurator.reconfigure(
 * this file be licensed under the Apache-2.0 license or a
            emptySet(),
    public void resetPortCounterBeforeTest() {  
        boolean autoShrinkVotingConfiguration,  
        check(nodes("a", "b", "c"), retired("a"), conf("a", "b", "c"), true, conf("b"));
        check(nodes("a", "b", "c"), retired("a"), conf("a", "b", "c"), false, conf("b", "c"));
        assertThat(
            equalTo(conf("a", "b", "c", "e"))  
 *
    ) {
        );  
            initialConfig  
import static java.util.Collections.emptySet;
        final Set<DiscoveryNode> liveNodesSet = nodes(liveNodes);  
    }
        final String[] initialVotingNodes = new String[randomIntBetween(1, allNodes.length)];  
        VotingConfiguration expectedConfig
        check(nodes("a", "b", "c", "d", "e"), conf("a", "b", "c"), true, conf("a", "b", "c", "d", "e"));
        check(nodes("a", "b", "c", "d", "e"), conf("a", "f", "g"), false, conf("a", "b", "c", "d", "e"));
            randomFrom(liveNodesSet),
        if (quorumSize > liveNodes.length) {
            final List<String> expectedQuorum = randomSubsetOf(quorumSize, liveNodes);
    private Reconfigurator makeReconfigurator(Settings settings) {
    private VotingConfiguration conf(String... nodes) {
        } else {
            equalTo(conf("a", "b", "c", "d", "e"))
 * Unless required by applicable law or agreed to in writing,
            new ParameterizedMessage(
        check(nodes("a", "b"), conf("a", "c"), true, conf("a"));  
        check(nodes("a", "b", "c"), conf("a", "b", "e"), false, conf("a", "b", "c"));
        check(nodes("a", "b"), conf("a"), true, conf("a"));
            assertFalse(description + " without a live quorum", finalConfig.hasQuorum(Arrays.asList(liveNodes)));
 * not use this file except in compliance with the License.
import static org.hamcrest.Matchers.equalTo;  
 * GitHub history for details.
import org.opensearch.Version;
        Set<DiscoveryNode> threeNodes = nodes("a", "b", "c");  
        // update to "false"
        if (quorumSize > liveNodes.length) {
        check(nodes("a", "b", "c", "f"), retired("c", "e", "f", "g"), conf("a", "c", "d", "e"), true, conf("a"));
    }
        check(nodes("a", "b", "c", "d"), conf("a", "b", "e"), true, conf("a", "b", "c"));  
        assertThat(reconfigurator.reconfigure(twoNodes, retired(), randomFrom(twoNodes), initialConfig), equalTo(conf("a", "b", "c")));  
        check(nodes("a", "b", "c"), conf("a", "b", "c"), true, conf("a", "b", "c"));
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfiguration;  
        }
 */
        check(nodes("a", "b"), retired("a"), conf("a"), true, conf("b"));  
        check(nodes("a", "b", "c", "d"), conf("a", "b", "c", "d", "e"), true, conf("a", "b", "c"));
        check(nodes("a", "b", "c", "d"), conf("a", "b", "e"), false, conf("a", "b", "c"));  
            settingsBuilder.put(CLUSTER_AUTO_SHRINK_VOTING_CONFIGURATION.getKey(), true);
        final String[] liveNodes = new String[randomIntBetween(1, allNodes.length)];  
}  
        check(nodes("e", "a", "b", "c"), retired(), "e", conf("a", "b", "c", "d", "e"), true, conf("a", "b", "e"));  
        Set<DiscoveryNode> twoNodes = nodes("a", "b");
        final DiscoveryNode clusterManager = liveNodes.stream().filter(n -> n.getId().equals(clusterManagerId)).findFirst().get();
                "[liveNodes={}, retired={}, clusterManager={}, config={}, autoShrinkVotingConfiguration={}]",
    }
        );
                retired,
        check(nodes("a", "b", "c"), conf("a", "b", "c"), false, conf("a", "b", "c"));
        );  
                config,  
        VotingConfiguration expectedConfig  
import java.util.HashSet;
        }  
        check(nodes("a", "b"), conf("a", "b", "e"), false, conf("a", "b", "e"));
 *
        check(nodes("a", "b", "c"), conf("a"), true, conf("a", "b", "c"));  
        VotingConfiguration config,
        }  
 */  
        } else {  
        check(nodes("a", "b"), conf("a", "b"), true, conf("a"));
    private void check(
        Set<DiscoveryNode> liveNodes,  
            initialConfig
 * the Apache License, Version 2.0 (the "License"); you may
    public void testReconfigurationExamples() {
    }  
    private void check(
        VotingConfiguration expectedConfig
 */  
        check(nodes("a", "b"), conf("a", "c"), false, conf("a", "b"));  
        check(nodes("a", "b", "c", "f"), retired("c", "e", "f", "g"), conf("a", "c", "d", "e", "h"), true, conf("a", "b", "d"));
        final int quorumSize = Math.max(liveNodes.length, initialVotingNodes.length) / 2 + 1;  
        );
        final Set<DiscoveryNode> liveNodes = new HashSet<>();  
    ) {
    @Before
/*
 * The OpenSearch Contributors require contributions made to  
    ) {
import org.opensearch.test.OpenSearchTestCase;  
        final String description = "reconfigure " + liveNodesSet + " from " + initialConfig + " yielded " + finalConfig;
        // Retiring a single node shifts the votes elsewhere if possible.
        check(nodes("a", "b"), conf("b"), true, conf("a"));
        check(liveNodes, retired, clusterManager.getId(), config, autoShrinkVotingConfiguration, expectedConfig);
        clusterSettings.applySettings(Settings.builder().put(CLUSTER_AUTO_SHRINK_VOTING_CONFIGURATION.getKey(), "false").build());  
        return Arrays.stream(nodes).collect(Collectors.toSet());
import org.opensearch.cluster.node.DiscoveryNode;
        final VotingConfiguration initialConfig = conf(initialVotingNodes);
        resetPortCounter();
            ).getFormattedMessage(),
        final String[] liveNodes = new String[randomIntBetween(1, allNodes.length)];  
                autoShrinkVotingConfiguration
        assertThat(  
import java.util.Arrays;  
        // Retiring a node from a three-node cluster drops down to a one-node configuration  
        // Three non-retired nodes in the config, so new config does not shrink below 3
        if (randomBoolean()) {
import java.util.List;  
                                                                                                                                       // quorum
 *     http://www.apache.org/licenses/LICENSE-2.0
        final String[] initialVotingNodes = new String[randomIntBetween(1, allNodes.length)];  
        check(nodes("a", "b", "c"), conf("a", "b", "c", "d", "e"), true, conf("a", "b", "c"));
        String clusterManagerId,
        check(nodes("a", "b", "c"), conf("a", "b"), false, conf("a", "b", "c"));
        assertEquals(  
        check(nodes("a"), conf("a"), true, conf("a"));  
        final Reconfigurator reconfigurator = new Reconfigurator(Settings.EMPTY, clusterSettings);
    }  
            () -> clusterSettings.applySettings(Settings.builder().put(CLUSTER_AUTO_SHRINK_VOTING_CONFIGURATION.getKey(), "blah").build())  
        randomSubsetOf(initialVotingNodes.length, allNodes).toArray(initialVotingNodes);
 * You may obtain a copy of the License at  
        check(nodes("a", "b", "c", "f"), retired("c", "e", "f", "g"), conf("a", "c", "d", "e", "h"), false, conf("a", "b", "d"));  
            emptySet(),  
        final Builder settingsBuilder = Settings.builder();  
import static org.hamcrest.Matchers.sameInstance;
        final Reconfigurator reconfigurator = makeReconfigurator(  
        );
import org.opensearch.common.settings.Settings;  
        boolean autoShrinkVotingConfiguration,  
        VotingConfiguration config,
        final Reconfigurator reconfigurator = makeReconfigurator(  
        randomSubsetOf(liveNodes.length, allNodes).toArray(liveNodes);
            liveNodesSet,  
        for (String id : nodes) {
 * Licensed to Elasticsearch under one or more contributor  
        check(nodes("a", "b"), conf("a", "b", "e"), false, conf("a", "b", "e"));
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.settings.Settings.Builder;
    public void testAutoShrinking() {  
        );
        check(nodes("a", "b"), conf("a"), false, conf("a"));
            reconfigurator.reconfigure(threeNodes, retired(), randomFrom(threeNodes), initialConfig),
    }  
        final String[] allNodes = new String[] { "a", "b", "c", "d", "e", "f", "g" };
        randomSubsetOf(liveNodes.length, allNodes).toArray(liveNodes);
    private void check(
        check(nodes("a"), conf("a"), false, conf("a"));  
            assertTrue(description + " with quorum[" + quorumSize + "] of " + expectedQuorum, finalConfig.hasQuorum(expectedQuorum));
            liveNodesSet,
        check(nodes("a", "b"), retired("a"), conf("a"), false, conf("b"));
 * SPDX-License-Identifier: Apache-2.0
        return new Reconfigurator(settings, new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS));  
            expectedConfig,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        // 7 nodes, one for each combination of live/retired/current. Ideally we want the config to be the non-retired live nodes.  
        check(nodes("a", "b", "c"), conf("a"), false, conf("a", "b", "c"));  
    }
        check(nodes("a", "b", "c", "d", "e"), conf("a", "f", "g"), true, conf("a", "b", "c", "d", "e"));
import org.opensearch.common.util.set.Sets;
        Set<DiscoveryNode> liveNodes,  
    public void testManualShrinking() {  
            liveNodes.add(new DiscoveryNode(id, buildNewFakeTransportAddress(), Version.CURRENT));
    }
package org.opensearch.cluster.coordination;
        return liveNodes;
            adaptedConfig
        randomSubsetOf(initialVotingNodes.length, allNodes).toArray(initialVotingNodes);
        check(nodes("a", "b", "c"), conf("a", "b"), true, conf("a", "b", "c"));
 * ownership. Elasticsearch licenses this file to you under  
        Set<String> retired,
 * KIND, either express or implied.  See the License for the
        final VotingConfiguration initialConfig = conf(initialVotingNodes);  
        final VotingConfiguration initialConfig = conf("a", "b", "c", "d", "e");  
        boolean autoShrinkVotingConfiguration,
        check(nodes("a", "b", "c", "d"), conf("a", "b", "c", "d", "e"), false, conf("a", "b", "c", "d", "e"));
        final String description = "reconfigure " + liveNodesSet + " from " + initialConfig + " yielded " + finalConfig;  
/*  
        clusterSettings.applySettings(Settings.builder().put(CLUSTER_AUTO_SHRINK_VOTING_CONFIGURATION.getKey(), "true").build());
 * this work for additional information regarding copyright
        );
        );
        check(nodes("a", "b"), conf("a", "b", "e"), true, conf("a", "b", "e"));
import org.apache.logging.log4j.message.ParameterizedMessage;
            Settings.builder().put(CLUSTER_AUTO_SHRINK_VOTING_CONFIGURATION.getKey(), autoShrinkVotingConfiguration).build()
            assertTrue(description + " with quorum[" + quorumSize + "] of " + expectedQuorum, finalConfig.hasQuorum(expectedQuorum));  
    public void testDynamicSetting() {  
    }
        assertThat(reconfigurator.reconfigure(twoNodes, retired(), randomFrom(twoNodes), initialConfig), equalTo(conf("a", "b", "c")));
/*  
        final DiscoveryNode clusterManager = liveNodes.stream().sorted(Comparator.comparing(DiscoveryNode::getId)).findFirst().get();  
        Set<DiscoveryNode> liveNodes,
        return new VotingConfiguration(Sets.newHashSet(nodes));
