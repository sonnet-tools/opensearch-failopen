            new DiscoveryNode(
                nodes.getDataNodes().keySet().iterator().forEachRemaining(ids::add);
        List<DiscoveryNode> nodesList = randomNodes(numNodes);  
    // Validate using the deprecated 'master' role in the node filter can get correct result.  
            .toArray(String[]::new);
            .map(DiscoveryNode::getId)  
            @Override  
        assertThat(discoveryNodes.resolveNodes("_all"), arrayContainingInAnyOrder(allNodes));
            .filter(n -> n.isClusterManagerNode() == true)  
    }
        DiscoveryNodes discoveryNodes = buildDiscoveryNodes();  
                expectedNodeIdsSet.addAll(nodeSelector.matchingNodeIds(discoveryNodes));  
        DiscoveryNodes discoveryNodes = buildDiscoveryNodes();  
 * specific language governing permissions and limitations
/*  
 */  
import java.util.concurrent.atomic.AtomicInteger;
        if (Objects.equals(clusterManagerAId, clusterManagerBId)) {
        final DiscoveryNodes discoNodesB = builderB.build();  
        final DiscoveryNodes discoveryNodes = buildDiscoveryNodes();
        assertEquals(result, discoveryNodes);
 * Unless required by applicable law or agreed to in writing,
        assertThat(  
            }
            .entrySet()  
                });  
        discoBuilder.add(
            assertThat(delta.previousClusterManagerNode(), nullValue());
        newNodes.removeAll(nodesA);  
        // if assertions are enabled (should be the case for tests, but not in production), resolving null throws
            }
        final DiscoveryNodes nodes0 = DiscoveryNodes.builder().add(discoveryNodes.get(0)).build();
 *     http://www.apache.org/licenses/LICENSE-2.0
        int numNodes = randomIntBetween(1, 10);
        final DiscoveryNodes nodes01Local = DiscoveryNodes.builder(nodes01).localNodeId(discoveryNodes.get(1).getId()).build();
        assertEquals(Version.fromString("6.3.0"), build.getMaxNodeVersion());
    public void testDeltas() {  
        discoBuilder.clusterManagerNodeId(randomFrom(nodesList).getId());
                "node_" + 2,
    public void testResolveNodesIds() {  
                Collections.emptyMap(),
        if (clusterManagerA == null) {  
                Version.fromString("6.3.0")  
        discoBuilder.add(
        assertThat(nodes0.delta(nodes01).shortSummary(), equalTo("removed {" + discoveryNodes.get(1) + "}"));
            )  
        Set<DiscoveryNode> nodesA = new HashSet<>();
        final String clusterManagerBId = clusterManagerB == null ? null : clusterManagerB.getId();
        } catch (IllegalArgumentException e) {  
                "name_" + 3,
            Set<String> matchingNodeIds(DiscoveryNodes nodes) {  
                    nodeAddress.getAddress(),
        final String[] nonClusterManagerNodes = StreamSupport.stream(discoveryNodes.getNodes().values().spliterator(), false)  
        discoveryNodes.writeVerifiableTo(checksumOut);
        for (int i = 0; i < numNodeNames; i++) {  
import org.opensearch.Version;  
                    }
        BufferedChecksumStreamOutput checksumOut = new BufferedChecksumStreamOutput(out);  
        assertThat(  
                return ids;
/*
        StreamInput in = out.bytes().streamInput();
            }
            .forEachOrdered(entry -> discoveryNodesBuilder.add(entry.getValue()));  
            arrayContainingInAnyOrder(coordinatorOnlyNodes)
        builderB.localNodeId(RandomPicks.randomFrom(random(), nodesB).getId());  
            @Override
            if (randomBoolean()) {  
    }
        assertThat(delta.removedNodes().size(), equalTo(removedNodes.size()));  
        assertThat(discoveryNodes.resolveNodes("master:true"), arrayContainingInAnyOrder(clusterManagerNodes));
        CUSTOM_ROLE("custom_role:true") {
        for (DiscoveryNode node : nodesList) {
        assertEquals(returnedNodes.size(), inputNodes.size());  
        final List<DiscoveryNode> returnedNodes = discoBuilder.build().clusterManagersFirstStream().collect(Collectors.toList());
                    node.getRoles(),
        );
    private static List<DiscoveryNode> randomNodes(final int numNodes) {  
                    node.getId(),
 * license agreements. See the NOTICE file distributed with
        assertEquals(new HashSet<>(returnedNodes), new HashSet<>(inputNodes));
        nodesB.stream().forEach(builderB::add);  
        BufferedChecksumStreamOutput checksumOut2 = new BufferedChecksumStreamOutput(out2);
            nodeSelectors.add(discoveryNode.getName());
                final TransportAddress nodeAddress = node.getAddress();
import java.util.HashMap;
import java.util.stream.Collectors;
                "added {" + discoveryNodes.get(2) + "," + discoveryNodes.get(1) + "}"
        for (int i = 0; i < numNodes; i++) {
            assertFalse(delta.clusterManagerNodeChanged());  
        DiscoveryNode clusterManagerB = randomBoolean() ? null : RandomPicks.randomFrom(random(), nodesB);  
                Collections.emptyMap(),  
                    public Setting<Boolean> legacySetting() {  
        DiscoveryNodes.Builder discoBuilder = DiscoveryNodes.builder();
        final String[] nonCoordinatorOnlyNodes = StreamSupport.stream(discoveryNodes.getNodes().values().spliterator(), false)
            )
                    }
            .map(DiscoveryNode::getId)
 * You may obtain a copy of the License at  
                    nodeAddress,
            @Override
        assertThat(delta.removedNodes(), containsInAnyOrder(removedNodes.stream().collect(Collectors.toList()).toArray()));
    }
 * this file be licensed under the Apache-2.0 license or a
 * under the License.  
        try {
            Set<String> matchingNodeIds(DiscoveryNodes nodes) {
        CLUSTER_MANAGER_ELIGIBLE(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE.roleName() + ":true") {
        int numNodeIds = randomIntBetween(0, 3);  
            Map<String, String> attributes = new HashMap<>();  
        assertThat(nodes0.delta(nodes01Local).shortSummary(), equalTo("removed {" + discoveryNodes.get(1) + "}"));
            nodesList.add(node);
                    if (node.getRoles().stream().anyMatch(role -> role.roleName().equals("custom_role"))) {  
        final DiscoveryNodes discoveryNodes = buildDiscoveryNodes();  
                "node_" + 1,
        assertThat(discoveryNodes.resolveNodes("_all", "cluster_manager:false"), arrayContainingInAnyOrder(nonClusterManagerNodes));
                Set<String> ids = new HashSet<>();
            Set<String> matchingNodeIds(DiscoveryNodes nodes) {  
                return ids;
            }  
                return ids;
                Set<String> ids = new HashSet<>();
                    attrs,  
        DiscoveryNodes result = DiscoveryNodes.readFrom(in, discoveryNodes.getLocalNode());  
        expectThrows(AssertionError.class, () -> discoveryNodes.resolveNodes(null, "someNode"));
        final String[] allNodes = StreamSupport.stream(discoveryNodes.spliterator(), false)
            } else if (matchingNodeIds.size() > 1) {  
        DiscoveryNode clusterManagerA = randomBoolean() ? null : RandomPicks.randomFrom(random(), nodesA);
import java.io.IOException;
        final DiscoveryNodes.Builder discoBuilder = DiscoveryNodes.builder();  
    }  
                return ids;
                Version.fromString("5.1.0")
            }  
                        ids.add(node.getId());
        logger.info("nodes B: {}", discoNodesB);
    public void testWriteVerifiableTo() throws IOException {  
                return ids;  
        );
        assertThat(delta.added(), equalTo(newNodes.isEmpty() == false));
        assertEquals(Version.fromString("1.1.0"), build.getMinNodeVersion());
            Set<String> matchingNodeIds(DiscoveryNodes nodes) {
import java.util.List;  
        }
        DiscoveryNodes discoveryNodes = buildDiscoveryNodes();
    }
        );
        LOCAL("_local") {
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
            Set<String> matchingNodeIds(DiscoveryNodes nodes) {
                    if ("value".equals(node.getAttributes().get("attr"))) {  
            oneOf(
import java.util.stream.StreamSupport;  
        for (int i = 0; i < numNodeIds; i++) {
        String[] resolvedNodesIds = discoveryNodes.resolveNodes(nodeSelectors.toArray(new String[0]));  
        Set<String> nodeSelectors = new HashSet<>();
                return ids;
import static org.hamcrest.Matchers.oneOf;
        );  
        builderA.localNodeId(RandomPicks.randomFrom(random(), nodesA).getId());  
                "name_" + 1,  
        Set<String> matchingNodeIds = nodeSelector.matchingNodeIds(discoveryNodes);
        }  
            discoBuilder = discoBuilder.add(node);
        },
            @Override  
        nodesB.addAll(randomNodes(1 + randomInt(5)));
 * SPDX-License-Identifier: Apache-2.0
                nodes.getClusterManagerNodes().keySet().iterator().forEachRemaining(ids::add);  
        INGEST(DiscoveryNodeRole.INGEST_ROLE.roleName() + ":true") {  
                Set<String> ids = new HashSet<>();
        };  
            Set<String> matchingNodeIds(DiscoveryNodes nodes) {
            .toArray(String[]::new);
        assertThat(resolvedNodesIds, equalTo(expectedNodesIds));
            .stream()
            assertThat(delta.newClusterManagerNode().getId(), equalTo(clusterManagerBId));
            }  
            .toArray(String[]::new);  
    }
            oneOf(
 *
            .toArray(String[]::new);
            nodes0.delta(nodes02Local).shortSummary(),
        DiscoveryNodes build = discoBuilder.build();  
        final DiscoveryNodes discoNodesA = builderA.build();
    }
        discoBuilder.localNodeId(randomFrom(nodesList).getId());
        },
import java.util.Objects;
            }  
/*  
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
            assertThat(delta.previousClusterManagerNode().getId(), equalTo(clusterManagerAId));  
            }
        assertEquals(sortedNodes, returnedNodes);
        expectThrows(AssertionError.class, () -> discoveryNodes.resolveNodes("someNode", null, "someOtherNode"));
                nodes.getNodes().values().iterator().forEachRemaining(node -> {
        builderA.clusterManagerNodeId(clusterManagerAId);
        Collections.sort(sortedNodes, Comparator.comparing(n -> n.isClusterManagerNode() == false));  
                assertThat(e.getMessage(), containsString("where expected to be resolved to a single node"));
    }
        COORDINATING_ONLY(DiscoveryNode.COORDINATING_ONLY + ":true") {
        return nodesList;  
        abstract Set<String> matchingNodeIds(DiscoveryNodes nodes);
            String nodeId = randomFrom(nodeIds);  
            new DiscoveryNode(  
                Set<String> ids = new HashSet<>();
        assertThat(delta.removed(), equalTo(removedNodes.isEmpty() == false));
                // change an attribute
        for (int i = 0; i < numSelectors; i++) {  
        String[] expectedNodesIds = expectedNodeIdsSet.toArray(new String[0]);
            .filter(n -> n.isClusterManagerNode() || n.isDataNode() || n.isIngestNode())  
 * Licensed to Elasticsearch under one or more contributor  
                    node.getName(),  
            }
            if (nodeSelectors.add(nodeSelector.selector)) {
        }
        },
 * GitHub history for details.
                nodes.getClusterManagerNodes().keySet().iterator().forEachRemaining(ids::add);
        } else {
            @Override
        }  
        assertThat(discoveryNodes.resolveNodes("master:false", "_all"), arrayContainingInAnyOrder(allNodes));  
            final DiscoveryNode node = newNode(idGenerator.getAndIncrement(), attributes, roles);  
        Set<DiscoveryNode> nodesB = new HashSet<>();  
        assertThat(nodes01.delta(nodes0).shortSummary(), equalTo("added {" + discoveryNodes.get(1) + "}"));
                return ids;
        },
        NodeSelector(String selector) {
                "removed {" + discoveryNodes.get(2) + "," + discoveryNodes.get(1) + "}"
            Set<String> matchingNodeIds(DiscoveryNodes nodes) {
        logger.info("nodes A: {}", discoNodesA);
            .filter(n -> n.isClusterManagerNode() == false)
            nodes0.delta(nodes012).shortSummary(),
import java.util.Arrays;
                attributes.put("custom", randomBoolean() ? "match" : randomAlphaOfLengthBetween(3, 5));
import org.opensearch.common.settings.Setting;
        ELECTED_MASTER("_master") {
            .filter(n -> n.isClusterManagerNode() == false)
            expectedNodeIdsSet.add(nodeId);
        final DiscoveryNodes nodes02Local = DiscoveryNodes.builder(nodes012).localNodeId(discoveryNodes.get(1).getId()).build();  
        }  
                });  
        NodeSelector nodeSelector = randomFrom(NodeSelector.values());  
                return Collections.singleton(nodes.getLocalNodeId());
                    node.getVersion()
import static org.hamcrest.Matchers.nullValue;  
            assertTrue(delta.clusterManagerNodeChanged());
                    }
import org.opensearch.test.OpenSearchTestCase;  
        DiscoveryNodes.Builder discoBuilder = DiscoveryNodes.builder();  
                "node_" + 3,  
            if (matchingNodeIds.size() == 0) {
            .map(DiscoveryNode::getId)
        expectThrows(AssertionError.class, () -> discoveryNodes.resolveNodes(Collections.singletonList(null).toArray(new String[0])));  
                    node.getEphemeralId(),
public class DiscoveryNodesTests extends OpenSearchTestCase {  
        },  
            .map(DiscoveryNode::getId)
import static org.hamcrest.Matchers.containsInAnyOrder;
        }  
        );  
    public void testResolveNodeByIdOrName() {
        BytesStreamOutput out = new BytesStreamOutput();
            assertThat(resolvedNode.getId(), equalTo(matchingNodeIds.iterator().next()));
        final DiscoveryNodes discoveryNodes = buildDiscoveryNodes();
                assertThat(e.getMessage(), equalTo("failed to resolve [" + nodeSelector.selector + "], no matching nodes"));
                    nodeAddress.address().getHostString(),  
        assertThat(discoveryNodes.resolveNodes("cluster_manager:false", "_all"), arrayContainingInAnyOrder(allNodes));  
                buildNewFakeTransportAddress(),
            final Set<DiscoveryNodeRole> roles = new HashSet<>(randomSubsetOf(DiscoveryNodeRole.BUILT_IN_ROLES));
        },
        nodesA.addAll(randomNodes(1 + randomInt(10)));
        final List<DiscoveryNode> inputNodes = randomNodes(10);
        DiscoveryNode node = randomFrom(nodes);
            )
        }
    public void testResolveNodeByAttribute() {
        },  
            this.selector = selector;
            .toArray(String[]::new);
import org.opensearch.core.common.io.stream.StreamInput;
            }
        assertThat(discoveryNodes.resolveNodes("coordinating_only:true"), arrayContainingInAnyOrder(coordinatorOnlyNodes));
                attrs.put("new", "new");  
                nodes.getNodes().values().iterator().forEachRemaining(node -> {
        assertThat(
            )
            )
        assertThat(discoveryNodes.resolveNodes(), arrayContainingInAnyOrder(allNodes));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
    }  
        if (clusterManagerB == null) {
import java.util.Set;  
            .toArray(String[]::new);  
        assertThat(discoveryNodes.resolveNodes("cluster_manager:true"), arrayContainingInAnyOrder(clusterManagerNodes));  
            .map(DiscoveryNode::getId)  
                "added {" + discoveryNodes.get(1) + "," + discoveryNodes.get(2) + "}",  
        }
        final List<DiscoveryNode> sortedNodes = new ArrayList<>(returnedNodes);
        // TODO: Remove this element after removing DiscoveryNodeRole.MASTER_ROLE
            discoveryNodes.resolveNodes("_all", "data:false", "ingest:false", "cluster_manager:false"),  
    public void testResolveNodesNull() {
            .sorted(Map.Entry.comparingByKey())
            nodes012.delta(nodes0).shortSummary(),
        final DiscoveryNodes nodes012 = DiscoveryNodes.builder(nodes01).add(discoveryNodes.get(2)).build();  
        final DiscoveryNodes discoveryNodes = buildDiscoveryNodes();
                Version.fromString("1.1.0")
            nodesB.add(node);
        DATA(DiscoveryNodeRole.DATA_ROLE.roleName() + ":true") {
    public void testDeltaListsMultipleNodes() {
            oneOf(
        final DiscoveryNodes.Builder discoveryNodesBuilder = DiscoveryNodes.builder()  
            expectedNodeIdsSet.add(discoveryNode.getId());  
 *  
        final String[] nonClusterManagerNodes = StreamSupport.stream(discoveryNodes.getNodes().values().spliterator(), false)
        DiscoveryNode resolvedNode = discoveryNodes.resolveNode(randomBoolean() ? node.getId() : node.getName());  
        for (DiscoveryNode node : randomSubsetOf(nodesA)) {
        inputNodes.forEach(discoBuilder::add);
        );  
            @Override
    }  
            )
                fail("resolveNode shouldn't have failed for [" + nodeSelector.selector + "]");  
import static org.hamcrest.CoreMatchers.equalTo;  
        assertThat(discoveryNodes.resolveNodes(new String[0]), arrayContainingInAnyOrder(allNodes));  
}
            }
        Set<String> expectedNodeIdsSet = new HashSet<>();
            assertThat(delta.newClusterManagerNode(), nullValue());  
        Arrays.sort(resolvedNodesIds);
                Set<String> ids = new HashSet<>();
    }
            nodeSelectors.add(nodeId);
        List<DiscoveryNode> nodesList = new ArrayList<>();
import java.util.Comparator;  
                "name_" + 2,
        Set<DiscoveryNode> removedNodes = new HashSet<>(nodesA);
        assertThat(delta.addedNodes(), containsInAnyOrder(newNodes.stream().collect(Collectors.toList()).toArray()));
        assertThat(delta.addedNodes().size(), equalTo(newNodes.size()));  
            .toArray(String[]::new);  
        },  
    }  
            .map(DiscoveryNode::getId)
 * not use this file except in compliance with the License.
                new HashSet<>(randomSubsetOf(DiscoveryNodeRole.BUILT_IN_ROLES)),
        int numNodeNames = randomIntBetween(0, 3);
package org.opensearch.cluster.node;
        assertThat(nodes01Local.delta(nodes0).shortSummary(), equalTo(""));
import static org.hamcrest.CoreMatchers.containsString;
        final DiscoveryNodes nodes01 = DiscoveryNodes.builder(nodes0).add(discoveryNodes.get(1)).build();
        DiscoveryNode[] nodes = discoveryNodes.getNodes().values().toArray(new DiscoveryNode[0]);
        builderB.clusterManagerNodeId(clusterManagerBId);
import org.opensearch.common.io.stream.BytesStreamOutput;
            NodeSelector nodeSelector = randomFrom(NodeSelector.values());
 * KIND, either express or implied.  See the License for the
                roles.add(new DiscoveryNodeRole("custom_role", "cr") {  
            }
                nodes.getCoordinatingOnlyNodes().keySet().iterator().forEachRemaining(ids::add);  
 */
import org.opensearch.core.common.io.stream.BufferedChecksumStreamOutput;  
                new HashSet<>(randomSubsetOf(DiscoveryNodeRole.BUILT_IN_ROLES)),
                "removed {" + discoveryNodes.get(2) + "," + discoveryNodes.get(1) + "}"
                return Collections.singleton(nodes.getClusterManagerNodeId());
    private static DiscoveryNodes buildDiscoveryNodes() {  
            DiscoveryNode resolvedNode = discoveryNodes.resolveNode(nodeSelector.selector);  
 * The OpenSearch Contributors require contributions made to  
        discoveryNodesBuilder.build().writeVerifiableTo(checksumOut2);  
                node = new DiscoveryNode(
    }
            assertThat(matchingNodeIds.size(), equalTo(1));
        } else {
        final String clusterManagerAId = clusterManagerA == null ? null : clusterManagerA.getId();
        assertThat(discoveryNodes.resolveNodes("_all", "master:false"), arrayContainingInAnyOrder(nonClusterManagerNodes));
                "removed {" + discoveryNodes.get(1) + "," + discoveryNodes.get(2) + "}",  
                Set<String> ids = new HashSet<>();  
                "removed {" + discoveryNodes.get(1) + "," + discoveryNodes.get(2) + "}",  
        MASTER_ELIGIBLE(DiscoveryNodeRole.MASTER_ROLE.roleName() + ":true") {  
    }
        BytesStreamOutput out2 = new BytesStreamOutput();
                nodes.getIngestNodes().keySet().iterator().forEachRemaining(ids::add);
 * the Apache License, Version 2.0 (the "License"); you may
            @Override  
                        ids.add(node.getId());
            }  
        CUSTOM_ATTRIBUTE("attr:value") {
        }  
                Collections.emptyMap(),
    }
        final String[] clusterManagerNodes = StreamSupport.stream(discoveryNodes.getNodes().values().spliterator(), false)
        }  
            DiscoveryNode discoveryNode = randomFrom(nodes);
        DiscoveryNodes discoveryNodes = buildDiscoveryNodes();
        assertEquals(checksumOut.getChecksum(), checksumOut2.getChecksum());
        final String[] allNodes = StreamSupport.stream(discoveryNodes.spliterator(), false)
        assertThat(resolvedNode.getId(), equalTo(node.getId()));
        DiscoveryNodes.Delta delta = discoNodesB.delta(discoNodesA);
            Set<String> matchingNodeIds(DiscoveryNodes nodes) {
        assertThat(  
            new DiscoveryNode(
        discoveryNodes.getNodes()
 */  
                Map<String, String> attrs = new HashMap<>(node.getAttributes());
import java.util.ArrayList;  
                buildNewFakeTransportAddress(),  
        String[] nodeIds = discoveryNodes.getNodes().keySet().toArray(new String[0]);
 * this work for additional information regarding copyright
                });
        private final String selector;
    public void testClusterManagersFirst() {
    private static AtomicInteger idGenerator = new AtomicInteger();
        return discoBuilder.build();  
    public void testCoordinatorOnlyNodes() {  
        DiscoveryNodes.Builder builderA = DiscoveryNodes.builder();
        DiscoveryNodes.Builder builderB = DiscoveryNodes.builder();
        assertThat(discoveryNodes.resolveNodes("_all", "coordinating_only:false"), arrayContainingInAnyOrder(nonCoordinatorOnlyNodes));  
        assertThat(nodes02Local.delta(nodes0).shortSummary(), equalTo("added {" + discoveryNodes.get(2) + "}"));  
        Set<DiscoveryNode> newNodes = new HashSet<>(nodesB);
            if (frequently()) {
        nodesA.stream().forEach(builderA::add);  
        discoBuilder.clusterManagerNodeId("name_2");
import java.util.Collections;
        final List<DiscoveryNode> discoveryNodes = randomNodes(3);
 *
import org.opensearch.core.common.transport.TransportAddress;
        int numSelectors = randomIntBetween(1, 5);  
                        return null;
        discoBuilder.localNodeId("name_1");
        );  
            Set<String> matchingNodeIds(DiscoveryNodes nodes) {  
        }
        final String[] coordinatorOnlyNodes = StreamSupport.stream(discoveryNodes.getNodes().values().spliterator(), false)  
    private static DiscoveryNode newNode(int nodeId, Map<String, String> attributes, Set<DiscoveryNodeRole> roles) {  
    private enum NodeSelector {
    }
    public void testDeprecatedMasterNodeFilter() {
            } else {
            if (frequently()) {
            }
import java.util.HashSet;
        removedNodes.removeAll(nodesB);  
                );  
 * software distributed under the License is distributed on an
                new HashSet<>(randomSubsetOf(DiscoveryNodeRole.BUILT_IN_ROLES)),  
                Set<String> ids = new HashSet<>();  
            @Override
            @Override  
                    @Override
        discoBuilder.add(  
 * Modifications Copyright OpenSearch Contributors. See
    public void testAll() {
                buildNewFakeTransportAddress(),
        } else {
            .clusterManagerNodeId(discoveryNodes.getClusterManagerNodeId());
            .filter(n -> n.isDataNode() == false && n.isIngestNode() == false && n.isClusterManagerNode() == false)
        DiscoveryNode[] nodes = discoveryNodes.getNodes().values().toArray(new DiscoveryNode[0]);
import java.util.Map;
    public void testMaxMinNodeVersion() {
            .map(DiscoveryNode::getId)
        Arrays.sort(expectedNodesIds);  
 * compatible open source license.
        return new DiscoveryNode("name_" + nodeId, "node_" + nodeId, buildNewFakeTransportAddress(), attributes, roles, Version.CURRENT);
