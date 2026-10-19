                Set<String> ids = new HashSet<>();
    public void testAll() {
        int numNodes = randomIntBetween(1, 10);
        discoBuilder.add(
            .filter(n -> n.isClusterManagerNode() == false)
        assertThat(discoveryNodes.resolveNodes("_all"), arrayContainingInAnyOrder(allNodes));
        );
            .toArray(String[]::new);
                expectedNodeIdsSet.addAll(nodeSelector.matchingNodeIds(discoveryNodes));
            )
            )
    public void testResolveNodeByIdOrName() {
    }
        expectThrows(AssertionError.class, () -> discoveryNodes.resolveNodes(Collections.singletonList(null).toArray(new String[0])));
    public void testClusterManagersFirst() {
                new HashSet<>(randomSubsetOf(DiscoveryNodeRole.BUILT_IN_ROLES)),
        DiscoveryNode node = randomFrom(nodes);
        final String clusterManagerAId = clusterManagerA == null ? null : clusterManagerA.getId();
        };
        final DiscoveryNodes nodes02Local = DiscoveryNodes.builder(nodes012).localNodeId(discoveryNodes.get(1).getId()).build();
            expectedNodeIdsSet.add(nodeId);
        }
        for (int i = 0; i < numNodes; i++) {
                nodes.getNodes().values().iterator().forEachRemaining(node -> {
        NodeSelector(String selector) {
        assertThat(discoveryNodes.resolveNodes("_all", "master:false"), arrayContainingInAnyOrder(nonClusterManagerNodes));
        final String[] allNodes = StreamSupport.stream(discoveryNodes.spliterator(), false)
                Map<String, String> attrs = new HashMap<>(node.getAttributes());
        }
        for (DiscoveryNode node : nodesList) {
            NodeSelector nodeSelector = randomFrom(NodeSelector.values());
                return ids;
            expectedNodeIdsSet.add(discoveryNode.getId());
            .toArray(String[]::new);
            nodeSelectors.add(discoveryNode.getName());
        for (DiscoveryNode node : randomSubsetOf(nodesA)) {
        final DiscoveryNodes nodes012 = DiscoveryNodes.builder(nodes01).add(discoveryNodes.get(2)).build();
        logger.info("nodes A: {}", discoNodesA);
    private enum NodeSelector {
        },
                    }
        assertEquals(sortedNodes, returnedNodes);
    }
                attrs.put("new", "new");
                "added {" + discoveryNodes.get(1) + "," + discoveryNodes.get(2) + "}",
                "removed {" + discoveryNodes.get(2) + "," + discoveryNodes.get(1) + "}"
            .map(DiscoveryNode::getId)
            oneOf(
    // Validate using the deprecated 'master' role in the node filter can get correct result.
        assertThat(discoveryNodes.resolveNodes("coordinating_only:true"), arrayContainingInAnyOrder(coordinatorOnlyNodes));
                Version.fromString("1.1.0")
        assertThat(discoveryNodes.resolveNodes(new String[0]), arrayContainingInAnyOrder(allNodes));
                "node_" + 1,
        },
                    if (node.getRoles().stream().anyMatch(role -> role.roleName().equals("custom_role"))) {
import java.util.Collections;
            .toArray(String[]::new);
        assertEquals(Version.fromString("6.3.0"), build.getMaxNodeVersion());
            assertThat(delta.newClusterManagerNode(), nullValue());
        final String[] nonClusterManagerNodes = StreamSupport.stream(discoveryNodes.getNodes().values().spliterator(), false)
        discoBuilder.localNodeId(randomFrom(nodesList).getId());
        for (int i = 0; i < numNodeIds; i++) {
            nodesB.add(node);
        assertEquals(new HashSet<>(returnedNodes), new HashSet<>(inputNodes));
 *
        String[] nodeIds = discoveryNodes.getNodes().keySet().toArray(new String[0]);
        private final String selector;
    }
                Collections.emptyMap(),
            assertThat(matchingNodeIds.size(), equalTo(1));
                "node_" + 2,
        assertThat(nodes01.delta(nodes0).shortSummary(), equalTo("added {" + discoveryNodes.get(1) + "}"));
        assertThat(delta.removedNodes().size(), equalTo(removedNodes.size()));
            Set<String> matchingNodeIds(DiscoveryNodes nodes) {
        }
    }
                    node.getName(),
 * under the License.
            .filter(n -> n.isDataNode() == false && n.isIngestNode() == false && n.isClusterManagerNode() == false)
        if (clusterManagerB == null) {
                return ids;
            .sorted(Map.Entry.comparingByKey())
                Version.fromString("6.3.0")
        discoveryNodes.writeVerifiableTo(checksumOut);
            }
        for (int i = 0; i < numSelectors; i++) {
            }
                nodes.getCoordinatingOnlyNodes().keySet().iterator().forEachRemaining(ids::add);
        final DiscoveryNodes discoNodesB = builderB.build();
import java.util.stream.StreamSupport;
 * Licensed to Elasticsearch under one or more contributor
 *
        DiscoveryNodes result = DiscoveryNodes.readFrom(in, discoveryNodes.getLocalNode());
            Set<String> matchingNodeIds(DiscoveryNodes nodes) {
        },
                        ids.add(node.getId());
        nodesB.stream().forEach(builderB::add);
        final DiscoveryNodes.Builder discoBuilder = DiscoveryNodes.builder();
        CUSTOM_ROLE("custom_role:true") {
        final DiscoveryNodes discoveryNodes = buildDiscoveryNodes();
        removedNodes.removeAll(nodesB);
        final String clusterManagerBId = clusterManagerB == null ? null : clusterManagerB.getId();
                return ids;
            }
            @Override
        inputNodes.forEach(discoBuilder::add);
        List<DiscoveryNode> nodesList = randomNodes(numNodes);
            nodeSelectors.add(nodeId);
            .map(DiscoveryNode::getId)
package org.opensearch.cluster.node;
                    node.getRoles(),
        }
    }
import java.util.List;
        final DiscoveryNodes discoveryNodes = buildDiscoveryNodes();
import org.opensearch.common.settings.Setting;
                "removed {" + discoveryNodes.get(1) + "," + discoveryNodes.get(2) + "}",
                Set<String> ids = new HashSet<>();
            if (nodeSelectors.add(nodeSelector.selector)) {
        }
                "added {" + discoveryNodes.get(2) + "," + discoveryNodes.get(1) + "}"
        assertThat(discoveryNodes.resolveNodes(), arrayContainingInAnyOrder(allNodes));
        assertThat(delta.addedNodes().size(), equalTo(newNodes.size()));
                new HashSet<>(randomSubsetOf(DiscoveryNodeRole.BUILT_IN_ROLES)),
                roles.add(new DiscoveryNodeRole("custom_role", "cr") {
        DiscoveryNodes discoveryNodes = buildDiscoveryNodes();
                buildNewFakeTransportAddress(),
        },
import org.opensearch.core.common.io.stream.BufferedChecksumStreamOutput;
            .filter(n -> n.isClusterManagerNode() || n.isDataNode() || n.isIngestNode())
        if (Objects.equals(clusterManagerAId, clusterManagerBId)) {
            .toArray(String[]::new);
        final DiscoveryNodes nodes01Local = DiscoveryNodes.builder(nodes01).localNodeId(discoveryNodes.get(1).getId()).build();
            }
 * KIND, either express or implied.  See the License for the
    public void testDeprecatedMasterNodeFilter() {
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
            .toArray(String[]::new);
        );
                });
        int numSelectors = randomIntBetween(1, 5);
        discoBuilder.add(
        ELECTED_MASTER("_master") {
            Map<String, String> attributes = new HashMap<>();
        DiscoveryNodes build = discoBuilder.build();
            new DiscoveryNode(
        final DiscoveryNodes.Builder discoveryNodesBuilder = DiscoveryNodes.builder()
        assertThat(delta.removedNodes(), containsInAnyOrder(removedNodes.stream().collect(Collectors.toList()).toArray()));
}
            .filter(n -> n.isClusterManagerNode() == true)
            String nodeId = randomFrom(nodeIds);
            @Override
        discoBuilder.add(
                    node.getVersion()
        );
        DiscoveryNode resolvedNode = discoveryNodes.resolveNode(randomBoolean() ? node.getId() : node.getName());
        assertThat(discoveryNodes.resolveNodes("_all", "cluster_manager:false"), arrayContainingInAnyOrder(nonClusterManagerNodes));
import java.util.concurrent.atomic.AtomicInteger;
        BytesStreamOutput out = new BytesStreamOutput();
        Collections.sort(sortedNodes, Comparator.comparing(n -> n.isClusterManagerNode() == false));
        // if assertions are enabled (should be the case for tests, but not in production), resolving null throws
                "name_" + 1,
            Set<String> matchingNodeIds(DiscoveryNodes nodes) {
 */
            )
                "node_" + 3,
        assertThat(
        LOCAL("_local") {
        assertThat(
        final String[] coordinatorOnlyNodes = StreamSupport.stream(discoveryNodes.getNodes().values().spliterator(), false)
/*
        assertThat(discoveryNodes.resolveNodes("_all", "coordinating_only:false"), arrayContainingInAnyOrder(nonCoordinatorOnlyNodes));
        assertThat(nodes01Local.delta(nodes0).shortSummary(), equalTo(""));
            }
                buildNewFakeTransportAddress(),
        Set<String> matchingNodeIds = nodeSelector.matchingNodeIds(discoveryNodes);
        assertThat(
        },
 * ownership. Elasticsearch licenses this file to you under
            @Override
        final List<DiscoveryNode> sortedNodes = new ArrayList<>(returnedNodes);
        DiscoveryNode clusterManagerB = randomBoolean() ? null : RandomPicks.randomFrom(random(), nodesB);
        nodesA.stream().forEach(builderA::add);
import static org.hamcrest.Matchers.nullValue;
        Set<DiscoveryNode> newNodes = new HashSet<>(nodesB);
        );
            }
                final TransportAddress nodeAddress = node.getAddress();
        if (clusterManagerA == null) {
 * The OpenSearch Contributors require contributions made to
            DiscoveryNode discoveryNode = randomFrom(nodes);
        final List<DiscoveryNode> inputNodes = randomNodes(10);
import java.util.Comparator;
                new HashSet<>(randomSubsetOf(DiscoveryNodeRole.BUILT_IN_ROLES)),
        assertThat(
    public void testWriteVerifiableTo() throws IOException {
 */
            )
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(discoveryNodes.resolveNodes("master:true"), arrayContainingInAnyOrder(clusterManagerNodes));
                "removed {" + discoveryNodes.get(1) + "," + discoveryNodes.get(2) + "}",
 * You may obtain a copy of the License at
 * Unless required by applicable law or agreed to in writing,
        final DiscoveryNodes discoNodesA = builderA.build();
public class DiscoveryNodesTests extends OpenSearchTestCase {
                    public Setting<Boolean> legacySetting() {
                assertThat(e.getMessage(), containsString("where expected to be resolved to a single node"));
        }
        assertThat(resolvedNode.getId(), equalTo(node.getId()));
                // change an attribute
        }
            arrayContainingInAnyOrder(coordinatorOnlyNodes)
        int numNodeNames = randomIntBetween(0, 3);
        StreamInput in = out.bytes().streamInput();
import static org.hamcrest.CoreMatchers.equalTo;
        }
        } else {
        INGEST(DiscoveryNodeRole.INGEST_ROLE.roleName() + ":true") {
            Set<String> matchingNodeIds(DiscoveryNodes nodes) {
        assertThat(delta.added(), equalTo(newNodes.isEmpty() == false));
import java.util.Objects;
            assertThat(delta.newClusterManagerNode().getId(), equalTo(clusterManagerBId));
        final String[] nonCoordinatorOnlyNodes = StreamSupport.stream(discoveryNodes.getNodes().values().spliterator(), false)
                "name_" + 3,
                    node.getId(),
        String[] expectedNodesIds = expectedNodeIdsSet.toArray(new String[0]);
        DiscoveryNode[] nodes = discoveryNodes.getNodes().values().toArray(new DiscoveryNode[0]);
            nodes012.delta(nodes0).shortSummary(),
        int numNodeIds = randomIntBetween(0, 3);
        nodesB.addAll(randomNodes(1 + randomInt(5)));
    }
        DATA(DiscoveryNodeRole.DATA_ROLE.roleName() + ":true") {
        final String[] nonClusterManagerNodes = StreamSupport.stream(discoveryNodes.getNodes().values().spliterator(), false)
        expectThrows(AssertionError.class, () -> discoveryNodes.resolveNodes("someNode", null, "someOtherNode"));
        discoBuilder.localNodeId("name_1");
    }
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
            @Override
                nodes.getNodes().values().iterator().forEachRemaining(node -> {
            nodesList.add(node);
        Set<DiscoveryNode> nodesB = new HashSet<>();
            }
                nodes.getDataNodes().keySet().iterator().forEachRemaining(ids::add);
        return discoBuilder.build();
        COORDINATING_ONLY(DiscoveryNode.COORDINATING_ONLY + ":true") {
                assertThat(e.getMessage(), equalTo("failed to resolve [" + nodeSelector.selector + "], no matching nodes"));
        } catch (IllegalArgumentException e) {
        }
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
        NodeSelector nodeSelector = randomFrom(NodeSelector.values());
import java.io.IOException;
        Set<DiscoveryNode> nodesA = new HashSet<>();
            DiscoveryNode resolvedNode = discoveryNodes.resolveNode(nodeSelector.selector);
        DiscoveryNodes.Builder builderB = DiscoveryNodes.builder();
        MASTER_ELIGIBLE(DiscoveryNodeRole.MASTER_ROLE.roleName() + ":true") {
                Collections.emptyMap(),
            } else if (matchingNodeIds.size() > 1) {
        logger.info("nodes B: {}", discoNodesB);
        String[] resolvedNodesIds = discoveryNodes.resolveNodes(nodeSelectors.toArray(new String[0]));
            )
                Set<String> ids = new HashSet<>();
            new DiscoveryNode(
            .toArray(String[]::new);
    public void testResolveNodeByAttribute() {
        DiscoveryNodes.Builder discoBuilder = DiscoveryNodes.builder();
            .map(DiscoveryNode::getId)
            Set<String> matchingNodeIds(DiscoveryNodes nodes) {
            }
import java.util.Arrays;
        } else {
            }
                    nodeAddress.address().getHostString(),
        assertThat(discoveryNodes.resolveNodes("cluster_manager:false", "_all"), arrayContainingInAnyOrder(allNodes));
                Set<String> ids = new HashSet<>();
                return Collections.singleton(nodes.getClusterManagerNodeId());
            new DiscoveryNode(
    }
 * Modifications Copyright OpenSearch Contributors. See
        builderB.localNodeId(RandomPicks.randomFrom(random(), nodesB).getId());
                Set<String> ids = new HashSet<>();
        discoveryNodes.getNodes()
        );
        try {
            .map(DiscoveryNode::getId)
 * not use this file except in compliance with the License.
        }
        Set<DiscoveryNode> removedNodes = new HashSet<>(nodesA);
    }
        builderB.clusterManagerNodeId(clusterManagerBId);
            this.selector = selector;
        );
        Arrays.sort(resolvedNodesIds);
        DiscoveryNodes.Delta delta = discoNodesB.delta(discoNodesA);
import java.util.Set;
import org.opensearch.core.common.transport.TransportAddress;
import static org.hamcrest.Matchers.oneOf;
                buildNewFakeTransportAddress(),
    private static List<DiscoveryNode> randomNodes(final int numNodes) {
        final String[] clusterManagerNodes = StreamSupport.stream(discoveryNodes.getNodes().values().spliterator(), false)
                return ids;
        final DiscoveryNodes discoveryNodes = buildDiscoveryNodes();
            .forEachOrdered(entry -> discoveryNodesBuilder.add(entry.getValue()));
            if (matchingNodeIds.size() == 0) {
        // TODO: Remove this element after removing DiscoveryNodeRole.MASTER_ROLE
/*
                return ids;
                Set<String> ids = new HashSet<>();
                return ids;
                    }
 * this file be licensed under the Apache-2.0 license or a
            if (frequently()) {
                    nodeAddress,
        assertThat(discoveryNodes.resolveNodes("master:false", "_all"), arrayContainingInAnyOrder(allNodes));
        assertEquals(result, discoveryNodes);
        discoBuilder.clusterManagerNodeId("name_2");
        List<DiscoveryNode> nodesList = new ArrayList<>();
        );
    }
        CLUSTER_MANAGER_ELIGIBLE(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE.roleName() + ":true") {
 * this work for additional information regarding copyright
                        ids.add(node.getId());
    private static AtomicInteger idGenerator = new AtomicInteger();
        for (int i = 0; i < numNodeNames; i++) {
                Set<String> ids = new HashSet<>();
        assertThat(discoveryNodes.resolveNodes("cluster_manager:true"), arrayContainingInAnyOrder(clusterManagerNodes));
                nodes.getIngestNodes().keySet().iterator().forEachRemaining(ids::add);
    }
        BufferedChecksumStreamOutput checksumOut2 = new BufferedChecksumStreamOutput(out2);
                "removed {" + discoveryNodes.get(2) + "," + discoveryNodes.get(1) + "}"
        DiscoveryNodes discoveryNodes = buildDiscoveryNodes();
        assertThat(nodes0.delta(nodes01Local).shortSummary(), equalTo("removed {" + discoveryNodes.get(1) + "}"));
            Set<String> matchingNodeIds(DiscoveryNodes nodes) {
        builderA.clusterManagerNodeId(clusterManagerAId);
import org.opensearch.test.OpenSearchTestCase;
            discoveryNodes.resolveNodes("_all", "data:false", "ingest:false", "cluster_manager:false"),
            .map(DiscoveryNode::getId)
import java.util.ArrayList;
        abstract Set<String> matchingNodeIds(DiscoveryNodes nodes);
        discoveryNodesBuilder.build().writeVerifiableTo(checksumOut2);
            @Override
        DiscoveryNode clusterManagerA = randomBoolean() ? null : RandomPicks.randomFrom(random(), nodesA);
            if (randomBoolean()) {
 * specific language governing permissions and limitations
            .map(DiscoveryNode::getId)
                    }
    private static DiscoveryNodes buildDiscoveryNodes() {
            Set<String> matchingNodeIds(DiscoveryNodes nodes) {
            .stream()
        final DiscoveryNodes discoveryNodes = buildDiscoveryNodes();
    }
                attributes.put("custom", randomBoolean() ? "match" : randomAlphaOfLengthBetween(3, 5));
        assertThat(delta.addedNodes(), containsInAnyOrder(newNodes.stream().collect(Collectors.toList()).toArray()));
                    node.getEphemeralId(),
            @Override
        },
 */
    }
import java.util.Map;
            nodes0.delta(nodes02Local).shortSummary(),
            assertTrue(delta.clusterManagerNodeChanged());
                nodes.getClusterManagerNodes().keySet().iterator().forEachRemaining(ids::add);
    }
            @Override
            discoBuilder = discoBuilder.add(node);
        newNodes.removeAll(nodesA);
        builderA.localNodeId(RandomPicks.randomFrom(random(), nodesA).getId());
            assertThat(delta.previousClusterManagerNode(), nullValue());
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat(nodes02Local.delta(nodes0).shortSummary(), equalTo("added {" + discoveryNodes.get(2) + "}"));
                    nodeAddress.getAddress(),
        BytesStreamOutput out2 = new BytesStreamOutput();
                    if ("value".equals(node.getAttributes().get("attr"))) {
                Collections.emptyMap(),
import static org.hamcrest.Matchers.containsInAnyOrder;
        },
            } else {
            }
    public void testResolveNodesNull() {
    public void testCoordinatorOnlyNodes() {
                return ids;
        discoBuilder.clusterManagerNodeId(randomFrom(nodesList).getId());
                "name_" + 2,
        BufferedChecksumStreamOutput checksumOut = new BufferedChecksumStreamOutput(out);
        DiscoveryNodes discoveryNodes = buildDiscoveryNodes();
        final DiscoveryNodes nodes0 = DiscoveryNodes.builder().add(discoveryNodes.get(0)).build();
            }
            }
                nodes.getClusterManagerNodes().keySet().iterator().forEachRemaining(ids::add);
        } else {
 * license agreements. See the NOTICE file distributed with
import static org.hamcrest.CoreMatchers.containsString;
        CUSTOM_ATTRIBUTE("attr:value") {
        DiscoveryNodes.Builder builderA = DiscoveryNodes.builder();
import java.util.HashSet;
                return Collections.singleton(nodes.getLocalNodeId());
            oneOf(
    public void testMaxMinNodeVersion() {
        return new DiscoveryNode("name_" + nodeId, "node_" + nodeId, buildNewFakeTransportAddress(), attributes, roles, Version.CURRENT);
            .entrySet()
                    @Override
 *
        final List<DiscoveryNode> returnedNodes = discoBuilder.build().clusterManagersFirstStream().collect(Collectors.toList());
            @Override
 * GitHub history for details.
    }
import org.opensearch.common.io.stream.BytesStreamOutput;
            nodes0.delta(nodes012).shortSummary(),
            assertThat(resolvedNode.getId(), equalTo(matchingNodeIds.iterator().next()));
        final List<DiscoveryNode> discoveryNodes = randomNodes(3);
    public void testDeltaListsMultipleNodes() {
import org.opensearch.Version;
            assertFalse(delta.clusterManagerNodeChanged());
        assertEquals(checksumOut.getChecksum(), checksumOut2.getChecksum());
            .filter(n -> n.isClusterManagerNode() == false)
                node = new DiscoveryNode(
    }
 * compatible open source license.
import java.util.stream.Collectors;
            .map(DiscoveryNode::getId)
            }
        nodesA.addAll(randomNodes(1 + randomInt(10)));
        DiscoveryNodes.Builder discoBuilder = DiscoveryNodes.builder();
            final Set<DiscoveryNodeRole> roles = new HashSet<>(randomSubsetOf(DiscoveryNodeRole.BUILT_IN_ROLES));
        }
                fail("resolveNode shouldn't have failed for [" + nodeSelector.selector + "]");
        assertEquals(Version.fromString("1.1.0"), build.getMinNodeVersion());
        assertEquals(returnedNodes.size(), inputNodes.size());
        expectThrows(AssertionError.class, () -> discoveryNodes.resolveNodes(null, "someNode"));
                });
    private static DiscoveryNode newNode(int nodeId, Map<String, String> attributes, Set<DiscoveryNodeRole> roles) {
import org.opensearch.core.common.io.stream.StreamInput;
    public void testResolveNodesIds() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                });
        Set<String> expectedNodeIdsSet = new HashSet<>();
        final DiscoveryNodes nodes01 = DiscoveryNodes.builder(nodes0).add(discoveryNodes.get(1)).build();
            )
            oneOf(
            assertThat(delta.previousClusterManagerNode().getId(), equalTo(clusterManagerAId));
            .toArray(String[]::new);
                    attrs,
        DiscoveryNode[] nodes = discoveryNodes.getNodes().values().toArray(new DiscoveryNode[0]);
        },
        assertThat(nodes0.delta(nodes01).shortSummary(), equalTo("removed {" + discoveryNodes.get(1) + "}"));
    public void testDeltas() {
        final String[] allNodes = StreamSupport.stream(discoveryNodes.spliterator(), false)
import java.util.HashMap;
        Set<String> nodeSelectors = new HashSet<>();
            Set<String> matchingNodeIds(DiscoveryNodes nodes) {
            }
                Version.fromString("5.1.0")
        Arrays.sort(expectedNodesIds);
                );
                        return null;
            Set<String> matchingNodeIds(DiscoveryNodes nodes) {
            @Override
        return nodesList;
/*
        assertThat(resolvedNodesIds, equalTo(expectedNodesIds));
            if (frequently()) {
            .clusterManagerNodeId(discoveryNodes.getClusterManagerNodeId());
        assertThat(delta.removed(), equalTo(removedNodes.isEmpty() == false));
        DiscoveryNodes discoveryNodes = buildDiscoveryNodes();
            final DiscoveryNode node = newNode(idGenerator.getAndIncrement(), attributes, roles);
