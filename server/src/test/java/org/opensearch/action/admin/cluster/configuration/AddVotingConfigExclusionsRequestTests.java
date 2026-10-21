        assertThat(
import org.opensearch.cluster.node.DiscoveryNode;
            .build();
        );
            Strings.EMPTY_ARRAY,
        AddVotingConfigExclusionsRequest originalRequest = new AddVotingConfigExclusionsRequest(
        assertThat(
    }
            Strings.EMPTY_ARRAY,
        assertWarnings(AddVotingConfigExclusionsRequest.DEPRECATION_MESSAGE);
        );
        final DiscoveryNode otherNode1 = new DiscoveryNode(
import org.opensearch.cluster.ClusterState;
        );
            singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
        );
            new AddVotingConfigExclusionsRequest(
            singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
            makeRequestWithNodeDescriptions("other*").resolveVotingConfigExclusions(clusterState),
            .build();
            "local",
        final ClusterState clusterState = builder.build();
import org.opensearch.core.common.Strings;
            Version.CURRENT
            "nodeId",
                    new String[] { "local" },
                    new String[] { "nodeName" },
            Version.CURRENT
        final DiscoveryNode node2 = new DiscoveryNode(
import static java.util.Collections.singleton;
        + "One and only one of [node_name], [node_names] and [node_ids] has to be set";
            VotingConfigExclusion.MISSING_VALUE_MARKER
        assertThat(deserialized.getTimeout(), equalTo(originalRequest.getTimeout()));
        final VotingConfigExclusion node1Exclusion = new VotingConfigExclusion(node1);
                () -> new AddVotingConfigExclusionsRequest(
            buildNewFakeTransportAddress(),
 * this file be licensed under the Apache-2.0 license or a
            "nodeId2",
                    TimeValue.ZERO
        assertThat(
        final ClusterState clusterState = ClusterState.builder(new ClusterName("cluster")).nodes(new Builder().add(node)).build();
            originalRequest,
        assertThat(
                    TimeValue.ZERO
    public void testResolveAllNodeIdentifiersNullOrEmpty() {
            new String[] { "nodeId1", "nodeId2" },
            buildNewFakeTransportAddress(),
            Version.CURRENT
            Version.CURRENT
            ).getMessage(),
            "other1",
            Version.CURRENT
            "nodeId3",
            buildNewFakeTransportAddress(),
        );
            "nodeName1",
        );
            singleton(DiscoveryNodeRole.MASTER_ROLE),
 * not use this file except in compliance with the License.
                TimeValue.ZERO
            "nodeName1",
                () -> new AddVotingConfigExclusionsRequest(Strings.EMPTY_ARRAY, Strings.EMPTY_ARRAY, Strings.EMPTY_ARRAY, TimeValue.ZERO)
 * compatible open source license.
            "local",
        );
            expectThrows(
            singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
    }
        );
            Strings.EMPTY_ARRAY,
            new AddVotingConfigExclusionsRequest("nodeName1", "unresolvableNodeName").resolveVotingConfigExclusions(clusterState),
        );
                Strings.EMPTY_ARRAY,
        );
            "other1",
            ).getMessage(),
        assertThat(deserialized.getNodeDescriptions(), equalTo(originalRequest.getNodeDescriptions()));
        );
        final ClusterState.Builder builder = ClusterState.builder(new ClusterName("cluster"))
            Strings.EMPTY_ARRAY,
            makeRequestWithNodeDescriptions("_local").resolveVotingConfigExclusionsAndCheckMaximum(clusterState, 2, "setting.name"),
                    Strings.EMPTY_ARRAY,
        final VotingConfigExclusion node2Exclusion = new VotingConfigExclusion(node2);
            Version.CURRENT
    }
            expectThrows(
        assertThat(deserialized.getNodeIds(), equalTo(originalRequest.getNodeIds()));
            "nodeName3",
            emptyMap(),
            Metadata.builder().coordinationMetadata(CoordinationMetadata.builder().addVotingConfigExclusion(otherNode1Exclusion).build())
        assertThat(
            timeout
            "nodeId2",
        assertThat(
            equalTo(NODE_IDENTIFIERS_INCORRECTLY_SET_MSG)
            singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
package org.opensearch.action.admin.cluster.configuration;
        );
            expectThrows(
        assertThat(makeRequestWithNodeDescriptions("_local").resolveVotingConfigExclusions(clusterState), contains(localNodeExclusion));
 *
            emptyMap(),
                    "setting.name"
                )
    }
 * under the License.
                () -> makeRequestWithNodeDescriptions("_local").resolveVotingConfigExclusionsAndCheckMaximum(
            buildNewFakeTransportAddress(),
                    new String[] { "nodeName" },
        );
        assertThat(
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfigExclusion;
            expectThrows(
 */
        final DiscoveryNode localNode = new DiscoveryNode(
            "nodeName",
import org.opensearch.cluster.metadata.Metadata;
                IllegalArgumentException.class,
            singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
        );
            descriptions,
        final VotingConfigExclusion unresolvableVotingConfigExclusion = new VotingConfigExclusion(
        );
        );
    public void testResolveByNodeNames() {
import org.opensearch.cluster.node.DiscoveryNodeRole;
        );
                new String[] { "nodeId1", "nodeId2" },
 * license agreements. See the NOTICE file distributed with
            new AddVotingConfigExclusionsRequest(Strings.EMPTY_ARRAY, new String[] { "nodeId" }, Strings.EMPTY_ARRAY, TimeValue.ZERO)
        );
    public void testSerializationForNodeIdOrNodeName() throws IOException {
                IllegalArgumentException.class,
            emptyMap(),
        final VotingConfigExclusion otherNode1Exclusion = new VotingConfigExclusion(otherNode1);
        final VotingConfigExclusion localNodeExclusion = new VotingConfigExclusion(localNode);
 *    http://www.apache.org/licenses/LICENSE-2.0
        final VotingConfigExclusion otherNode1Exclusion = new VotingConfigExclusion(otherNode1);
        final ClusterState clusterState = ClusterState.builder(new ClusterName("cluster"))
        Metadata metadata = Metadata.builder()
                TimeValue.ZERO
                    TimeValue.ZERO
                )
        assertThat(deserialized.getNodeNames(), equalTo(originalRequest.getNodeNames()));
                    new String[] { "nodeName" },
            "nodeId2",
        final VotingConfigExclusion otherNode2Exclusion = new VotingConfigExclusion(otherNode2);
            buildNewFakeTransportAddress(),
        final DiscoveryNode node3 = new DiscoveryNode(
        final ClusterState clusterState = ClusterState.builder(new ClusterName("cluster"))
            equalTo(NODE_IDENTIFIERS_INCORRECTLY_SET_MSG)
        final DiscoveryNode localNode = new DiscoveryNode(
    // The following 3 tests assign nodes by description, id and name respectively.
        );
        );
            equalTo(NODE_IDENTIFIERS_INCORRECTLY_SET_MSG)
import org.opensearch.cluster.node.DiscoveryNodes.Builder;
            .coordinationMetadata(CoordinationMetadata.builder().addVotingConfigExclusion(existingVotingConfigExclusion).build())
        assertThat(new AddVotingConfigExclusionsRequest("nodeName").resolveVotingConfigExclusions(clusterState), contains(nodeExclusion));
        );
            buildNewFakeTransportAddress(),
            "local",
        final DiscoveryNode node3 = new DiscoveryNode(
            "nodeName3",
                () -> new AddVotingConfigExclusionsRequest(
 * Unless required by applicable law or agreed to in writing,
            contains(nodeExclusion)
            equalTo(
    private static AddVotingConfigExclusionsRequest makeRequestWithNodeDescriptions(String... nodeDescriptions) {
        );
        );
 * SPDX-License-Identifier: Apache-2.0
            singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
                    TimeValue.ZERO
        final DiscoveryNode localNode = new DiscoveryNode(
        assertWarnings(AddVotingConfigExclusionsRequest.DEPRECATION_MESSAGE);
        final ClusterState clusterState = ClusterState.builder(new ClusterName("cluster")).nodes(new Builder().add(node)).build();
        final DiscoveryNode node2 = new DiscoveryNode(
    }
            Version.CURRENT
            nodeDescriptions,
            "nodeId1",
                "add voting config exclusions request for [_local] would add [1] exclusions to the existing [1] which would "
            buildNewFakeTransportAddress(),
            "nodeId1",
        assertThat(deserialized.getNodeIds(), equalTo(originalRequest.getNodeIds()));
            ).resolveVotingConfigExclusions(clusterState),
            singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
            buildNewFakeTransportAddress(),
        final ClusterState clusterState = ClusterState.builder(new ClusterName("cluster"))
 * GitHub history for details.
        assertWarnings(AddVotingConfigExclusionsRequest.DEPRECATION_MESSAGE);
/*
        );
            buildNewFakeTransportAddress(),
        final AddVotingConfigExclusionsRequest deserialized = copyWriteable(
import static org.hamcrest.Matchers.containsInAnyOrder;
            emptyMap(),
                Strings.EMPTY_ARRAY,
        final VotingConfigExclusion node2Exclusion = new VotingConfigExclusion(node2);
            singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
    }
            buildNewFakeTransportAddress(),
            singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
                IllegalArgumentException.class,
            "nodeName2",
            emptyMap(),
    public void testResolveRemoveExistingVotingConfigExclusions() {
            buildNewFakeTransportAddress(),
            "nodeName1",
        final VotingConfigExclusion otherNode2Exclusion = new VotingConfigExclusion(otherNode2);
            Version.CURRENT
        final DiscoveryNode otherDataNode = new DiscoveryNode(
        );
            .nodes(new Builder().add(localNode).localNodeId(localNode.getId()))
            ).resolveVotingConfigExclusions(clusterState),
                Strings.EMPTY_ARRAY,
        assertThat(
            emptyMap(),
        final VotingConfigExclusion existingVotingConfigExclusion = new VotingConfigExclusion(node1);
        final DiscoveryNode node1 = new DiscoveryNode(
                )
            ).resolveVotingConfigExclusions(clusterState),
        );
        );
            emptyMap(),
        assertThat(deserialized.getNodeDescriptions(), equalTo(originalRequest.getNodeDescriptions()));
        final DiscoveryNode node2 = new DiscoveryNode(
 * software distributed under the License is distributed on an
        final DiscoveryNode node3 = new DiscoveryNode(
        );
}
            "data",
                IllegalArgumentException.class,
                    + "exceed the maximum of [1] set by [setting.name]"
            "unresolvableNodeId",
    public void testResolveMoreThanOneNodeIdentifiersSet() {
 */
                Strings.EMPTY_ARRAY,
        TimeValue timeout = TimeValue.timeValueMillis(between(0, 30000));
            emptyMap(),
            singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
            emptySet(),
        builder.metadata(
            Strings.EMPTY_ARRAY,
                new String[] { "nodeId1", "unresolvableNodeId" },
        final VotingConfigExclusion node2Exclusion = new VotingConfigExclusion(node2);
            contains(node2Exclusion)
 * the Apache License, Version 2.0 (the "License"); you may
            .nodes(new Builder().add(node1).add(node2).add(node3).localNodeId(node1.getId()))
            VotingConfigExclusion.MISSING_VALUE_MARKER,
    }
            emptyMap(),
                IllegalArgumentException.class,
                () -> makeRequestWithNodeDescriptions("not-a-node").resolveVotingConfigExclusions(clusterState)
        assertThat(makeRequestWithNodeDescriptions("_local").resolveVotingConfigExclusions(clusterState), contains(localNodeExclusion));
    public void testResolveByNodeDescriptionWithDeprecatedMasterRole() {
    }
            originalRequest,
        final AddVotingConfigExclusionsRequest originalRequest = new AddVotingConfigExclusionsRequest(
            equalTo(NODE_IDENTIFIERS_INCORRECTLY_SET_MSG)
    public void testResolve() {
                    Strings.EMPTY_ARRAY,
 * ownership. Elasticsearch licenses this file to you under
            buildNewFakeTransportAddress(),
            emptyMap(),
    public void testResolveAndCheckMaximum() {
            makeRequestWithNodeDescriptions("_all").resolveVotingConfigExclusions(clusterState),
            emptyMap(),
        );
        assertThat(deserialized.getNodeNames(), equalTo(originalRequest.getNodeNames()));
        final VotingConfigExclusion localNodeExclusion = new VotingConfigExclusion(localNode);
            Version.CURRENT
            ).getMessage(),
            .build();
            "nodeId1",
        assertThat(
            "nodeId3",
            singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
    }
            "unresolvableNodeName"
        );
 *
                Strings.EMPTY_ARRAY,
import java.io.IOException;
            .nodes(new Builder().add(node1).add(node2).add(node3).localNodeId(node1.getId()))
            contains(localNodeExclusion)
            ).getMessage(),
    public void testSerialization() throws IOException {
            emptyMap(),
                    clusterState,
                .resolveVotingConfigExclusions(clusterState),
        final VotingConfigExclusion nodeExclusion = new VotingConfigExclusion(node);
            buildNewFakeTransportAddress(),
            containsInAnyOrder(otherNode1Exclusion, otherNode2Exclusion)
            ).getMessage(),
    // Validate node with MASTER_ROLE can be resolved by resolveVotingConfigExclusions() like before.
            containsInAnyOrder(node1Exclusion, node2Exclusion)
            new AddVotingConfigExclusionsRequest("nodeName1", "nodeName2").resolveVotingConfigExclusions(clusterState),
            equalTo(NODE_IDENTIFIERS_INCORRECTLY_SET_MSG)
        );
        );
            Version.CURRENT
        assertThat(
        final VotingConfigExclusion localNodeExclusion = new VotingConfigExclusion(localNode);
                    new String[] { "nodeId" },
        );
            buildNewFakeTransportAddress(),
    public void testResolveByNodeIdWithDeprecatedMasterRole() {
        assertThat(
        AddVotingConfigExclusionsRequest deserialized = copyWriteable(
        final DiscoveryNode node1 = new DiscoveryNode(
                    1,
            )
        );
        assertThat(deserialized.getTimeout(), equalTo(originalRequest.getTimeout()));
            ).getMessage(),
        assertThat(deserialized.getTimeout(), equalTo(originalRequest.getTimeout()));
            "nodeName",
import static org.hamcrest.Matchers.equalTo;
                    new String[] { "local" },
        assertThat(
        deserialized = copyWriteable(originalRequest, writableRegistry(), AddVotingConfigExclusionsRequest::new);
            "nodeName3",
            emptyMap(),
        );
 * KIND, either express or implied.  See the License for the
            new AddVotingConfigExclusionsRequest(
            buildNewFakeTransportAddress(),
            .build();
    private static final String NODE_IDENTIFIERS_INCORRECTLY_SET_MSG = "Please set node identifiers correctly. "
        );
 * You may obtain a copy of the License at
import org.opensearch.cluster.coordination.CoordinationMetadata;
            "other1",
                () -> new AddVotingConfigExclusionsRequest(
            emptyMap(),
                new String[] { "nodeId1", "nodeId2" },
                    new String[] { "nodeId" },
            emptyMap(),
                    new String[] { "local" },
            "nodeName2",
            TimeValue.ZERO
        final DiscoveryNode otherNode2 = new DiscoveryNode(
                    Strings.EMPTY_ARRAY,
/*
            containsInAnyOrder(node1Exclusion, node2Exclusion)
 */
        );
    public void testResolveByNodeIds() {
            singleton(DiscoveryNodeRole.MASTER_ROLE),
            "other2",
            singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
            descriptions[i] = randomAlphaOfLength(10);
            Version.CURRENT
            expectThrows(
            buildNewFakeTransportAddress(),
            writableRegistry(),
            singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
        final ClusterState clusterState = ClusterState.builder(new ClusterName("cluster"))
        final DiscoveryNode node1 = new DiscoveryNode(
            .metadata(metadata)
        final VotingConfigExclusion nodeExclusion = new VotingConfigExclusion(node);
            AddVotingConfigExclusionsRequest::new
            buildNewFakeTransportAddress(),
        final DiscoveryNode otherNode2 = new DiscoveryNode(
            Version.CURRENT
        return new AddVotingConfigExclusionsRequest(
            emptyMap(),
/*
        }
            .build();
                    new String[] { "nodeId" },
        final VotingConfigExclusion node1Exclusion = new VotingConfigExclusion(node1);
import org.opensearch.test.OpenSearchTestCase;
                IllegalArgumentException.class,
                IllegalArgumentException.class,
            containsInAnyOrder(node1Exclusion, unresolvableVotingConfigExclusion)
        final VotingConfigExclusion unresolvableVotingConfigExclusion = new VotingConfigExclusion(
        originalRequest = new AddVotingConfigExclusionsRequest("nodeName1", "nodeName2");
        allowedWarnings(AddVotingConfigExclusionsRequest.DEPRECATION_MESSAGE);
            singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
                () -> new AddVotingConfigExclusionsRequest(
            AddVotingConfigExclusionsRequest::new
            Version.CURRENT
        assertThat(
import static java.util.Collections.emptyMap;
            TimeValue.timeValueSeconds(30)
            equalTo("add voting config exclusions request for [not-a-node] matched no cluster-manager-eligible nodes")
        );
            new AddVotingConfigExclusionsRequest(
        int descriptionCount = between(1, 5);
            emptyMap(),
        final DiscoveryNode node = new DiscoveryNode(
                Strings.EMPTY_ARRAY,
 *
import org.opensearch.Version;
 * specific language governing permissions and limitations
            buildNewFakeTransportAddress(),
            "nodeName2",
            "other2",
    }
            Version.CURRENT
import org.opensearch.common.unit.TimeValue;
            emptyMap(),
            "other2",
        String[] descriptions = new String[descriptionCount];
import static org.hamcrest.Matchers.contains;
            containsInAnyOrder(node1Exclusion, unresolvableVotingConfigExclusion)
        final DiscoveryNode otherNode1 = new DiscoveryNode(
import org.opensearch.cluster.ClusterName;
            expectThrows(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            "local",
                )
        assertThat(
 * this work for additional information regarding copyright
            emptyMap(),
            buildNewFakeTransportAddress(),
    }
    public void testResolveByNodeNameWithDeprecatedMasterRole() {
public class AddVotingConfigExclusionsRequestTests extends OpenSearchTestCase {
            ).getMessage(),
        final ClusterState clusterState = ClusterState.builder(new ClusterName("cluster"))
            "nodeId3",
            "local",
            "other2",
                TimeValue.ZERO
            singleton(DiscoveryNodeRole.MASTER_ROLE),
        );
            .nodes(new Builder().add(node1).add(node2).add(node3).localNodeId(node1.getId()))
            "other1",
            "nodeId",
            containsInAnyOrder(localNodeExclusion, otherNode1Exclusion, otherNode2Exclusion)
        );
 * The OpenSearch Contributors require contributions made to
        assertThat(
            expectThrows(
            singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
                )
    }
        );
            writableRegistry(),
            Version.CURRENT
            Version.CURRENT
        assertThat(
            "data",
            .nodes(new Builder().add(localNode).add(otherNode1).add(otherNode2).add(otherDataNode).localNodeId(localNode.getId()))
    }
        final DiscoveryNode node = new DiscoveryNode(
        for (int i = 0; i < descriptionCount; i++) {
        assertThat(deserialized.getNodeDescriptions(), equalTo(originalRequest.getNodeDescriptions()));
            "local",
import static java.util.Collections.emptySet;
    // As of 2.0, MASTER_ROLE is deprecated to promote inclusive language.
        );
 * Modifications Copyright OpenSearch Contributors. See
            Version.CURRENT
        );
            Version.CURRENT
 * Licensed to Elasticsearch under one or more contributor
            .build();
            .nodes(new Builder().add(localNode).add(otherNode1).add(otherNode2).localNodeId(localNode.getId()));
            Version.CURRENT
            Strings.EMPTY_ARRAY,
