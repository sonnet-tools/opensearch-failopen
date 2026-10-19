        final DiscoveryNode otherDataNode = new DiscoveryNode(
            emptyMap(),  
 * SPDX-License-Identifier: Apache-2.0
            Version.CURRENT  
            Version.CURRENT
            Strings.EMPTY_ARRAY,
            contains(node2Exclusion)
        final ClusterState clusterState = ClusterState.builder(new ClusterName("cluster"))
        );
            "nodeName3",
            "nodeName3",
                Strings.EMPTY_ARRAY,  
                () -> new AddVotingConfigExclusionsRequest(
            makeRequestWithNodeDescriptions("_local").resolveVotingConfigExclusionsAndCheckMaximum(clusterState, 2, "setting.name"),  
        assertWarnings(AddVotingConfigExclusionsRequest.DEPRECATION_MESSAGE);
            "nodeId2",
        assertThat(
            buildNewFakeTransportAddress(),  
            containsInAnyOrder(node1Exclusion, unresolvableVotingConfigExclusion)
        );
            expectThrows(  
import org.opensearch.cluster.node.DiscoveryNode;  
            .build();  
            ).getMessage(),
        );  
            contains(nodeExclusion)
            "data",  
            new AddVotingConfigExclusionsRequest(
            buildNewFakeTransportAddress(),
                () -> makeRequestWithNodeDescriptions("not-a-node").resolveVotingConfigExclusions(clusterState)
        assertThat(deserialized.getNodeDescriptions(), equalTo(originalRequest.getNodeDescriptions()));
            "nodeId1",  
            Version.CURRENT
            expectThrows(
        final AddVotingConfigExclusionsRequest originalRequest = new AddVotingConfigExclusionsRequest(  
import org.opensearch.core.common.Strings;
    }  
            containsInAnyOrder(node1Exclusion, node2Exclusion)
            emptyMap(),
            singleton(DiscoveryNodeRole.MASTER_ROLE),  
            ).resolveVotingConfigExclusions(clusterState),  
        assertThat(
            .build();
            singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
        final ClusterState clusterState = ClusterState.builder(new ClusterName("cluster"))
                    Strings.EMPTY_ARRAY,
 * Licensed to Elasticsearch under one or more contributor  
                    TimeValue.ZERO
        assertThat(makeRequestWithNodeDescriptions("_local").resolveVotingConfigExclusions(clusterState), contains(localNodeExclusion));
            containsInAnyOrder(localNodeExclusion, otherNode1Exclusion, otherNode2Exclusion)
            singleton(DiscoveryNodeRole.MASTER_ROLE),
        );
            emptyMap(),
        assertThat(  
            singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
import org.opensearch.cluster.ClusterState;
            emptyMap(),
                )
            contains(localNodeExclusion)
            buildNewFakeTransportAddress(),  
            buildNewFakeTransportAddress(),  
            equalTo(NODE_IDENTIFIERS_INCORRECTLY_SET_MSG)
                Strings.EMPTY_ARRAY,
        );  
            .nodes(new Builder().add(node1).add(node2).add(node3).localNodeId(node1.getId()))  
        );  
 * license agreements. See the NOTICE file distributed with
            writableRegistry(),
        final DiscoveryNode node1 = new DiscoveryNode(
        assertThat(
            Version.CURRENT
            descriptions,
            buildNewFakeTransportAddress(),  
                    new String[] { "nodeName" },  
            .nodes(new Builder().add(node1).add(node2).add(node3).localNodeId(node1.getId()))  
            expectThrows(
            Strings.EMPTY_ARRAY,
        final DiscoveryNode otherNode2 = new DiscoveryNode(
                    new String[] { "nodeId" },  
 * under the License.  
                )
    }
        );  
        final DiscoveryNode localNode = new DiscoveryNode(
            Version.CURRENT  
            .build();
    // Validate node with MASTER_ROLE can be resolved by resolveVotingConfigExclusions() like before.  
            new AddVotingConfigExclusionsRequest(
        final ClusterState clusterState = ClusterState.builder(new ClusterName("cluster"))
            buildNewFakeTransportAddress(),
    public void testSerializationForNodeIdOrNodeName() throws IOException {
    // As of 2.0, MASTER_ROLE is deprecated to promote inclusive language.
            "nodeName1",
public class AddVotingConfigExclusionsRequestTests extends OpenSearchTestCase {
    }  
        Metadata metadata = Metadata.builder()  
        final DiscoveryNode otherNode2 = new DiscoveryNode(  
    }  
            .nodes(new Builder().add(node1).add(node2).add(node3).localNodeId(node1.getId()))  
    public void testResolveByNodeDescriptionWithDeprecatedMasterRole() {
 * ownership. Elasticsearch licenses this file to you under  
            VotingConfigExclusion.MISSING_VALUE_MARKER,
    }
        assertThat(
        final DiscoveryNode node2 = new DiscoveryNode(
                Strings.EMPTY_ARRAY,
            buildNewFakeTransportAddress(),
        );
            Version.CURRENT  
        );  
 * You may obtain a copy of the License at  
            new AddVotingConfigExclusionsRequest(
    }
        final DiscoveryNode node2 = new DiscoveryNode(
                IllegalArgumentException.class,
        );  
            Strings.EMPTY_ARRAY,  
    public void testResolveMoreThanOneNodeIdentifiersSet() {  
        deserialized = copyWriteable(originalRequest, writableRegistry(), AddVotingConfigExclusionsRequest::new);
            "unresolvableNodeName"
            "other2",  
            .nodes(new Builder().add(localNode).add(otherNode1).add(otherNode2).localNodeId(localNode.getId()));
        final VotingConfigExclusion nodeExclusion = new VotingConfigExclusion(node);  
    public void testResolveByNodeNames() {  
        );  
            singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
            AddVotingConfigExclusionsRequest::new
            Version.CURRENT
        assertThat(  
            "nodeId3",
                () -> makeRequestWithNodeDescriptions("_local").resolveVotingConfigExclusionsAndCheckMaximum(  
        for (int i = 0; i < descriptionCount; i++) {
            singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),  
import org.opensearch.test.OpenSearchTestCase;
                new String[] { "nodeId1", "nodeId2" },  
            TimeValue.ZERO  
                Strings.EMPTY_ARRAY,
        final VotingConfigExclusion localNodeExclusion = new VotingConfigExclusion(localNode);
                new String[] { "nodeId1", "unresolvableNodeId" },
            timeout
        assertThat(deserialized.getNodeNames(), equalTo(originalRequest.getNodeNames()));  
                IllegalArgumentException.class,  
                    new String[] { "nodeId" },
            "other1",
        );
import org.opensearch.Version;  
            buildNewFakeTransportAddress(),
            "nodeId2",
        );
        int descriptionCount = between(1, 5);  
                    + "exceed the maximum of [1] set by [setting.name]"
        final DiscoveryNode otherNode1 = new DiscoveryNode(  
                .resolveVotingConfigExclusions(clusterState),  
        assertThat(
                IllegalArgumentException.class,  
import static org.hamcrest.Matchers.contains;  
        );
            new AddVotingConfigExclusionsRequest("nodeName1", "nodeName2").resolveVotingConfigExclusions(clusterState),
            Version.CURRENT
        final ClusterState clusterState = ClusterState.builder(new ClusterName("cluster")).nodes(new Builder().add(node)).build();
 * The OpenSearch Contributors require contributions made to  
 *    http://www.apache.org/licenses/LICENSE-2.0
                () -> new AddVotingConfigExclusionsRequest(
        final VotingConfigExclusion node2Exclusion = new VotingConfigExclusion(node2);
        );  
                TimeValue.ZERO
            Version.CURRENT  
        return new AddVotingConfigExclusionsRequest(
        final ClusterState clusterState = ClusterState.builder(new ClusterName("cluster")).nodes(new Builder().add(node)).build();
            "other2",
        );
            equalTo("add voting config exclusions request for [not-a-node] matched no cluster-manager-eligible nodes")  
}
        String[] descriptions = new String[descriptionCount];
            "nodeId1",  
            "local",
                TimeValue.ZERO  
            new AddVotingConfigExclusionsRequest("nodeName1", "unresolvableNodeName").resolveVotingConfigExclusions(clusterState),  
            equalTo(NODE_IDENTIFIERS_INCORRECTLY_SET_MSG)
        );  
            "local",
            buildNewFakeTransportAddress(),  
 * this work for additional information regarding copyright
            "nodeName2",
            expectThrows(
        );  
        final VotingConfigExclusion otherNode2Exclusion = new VotingConfigExclusion(otherNode2);
            "nodeId3",  
        assertThat(deserialized.getNodeNames(), equalTo(originalRequest.getNodeNames()));
        );
        final DiscoveryNode otherNode1 = new DiscoveryNode(
        originalRequest = new AddVotingConfigExclusionsRequest("nodeName1", "nodeName2");
            writableRegistry(),
        );  
 * not use this file except in compliance with the License.
        );
            "nodeName1",
        allowedWarnings(AddVotingConfigExclusionsRequest.DEPRECATION_MESSAGE);  
        final DiscoveryNode node3 = new DiscoveryNode(  
            emptyMap(),  
            Version.CURRENT  
    }
            singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
            "nodeName1",
        );
        );
        final VotingConfigExclusion node1Exclusion = new VotingConfigExclusion(node1);  
            singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
            Version.CURRENT
        final VotingConfigExclusion node2Exclusion = new VotingConfigExclusion(node2);
            Strings.EMPTY_ARRAY,
        final VotingConfigExclusion nodeExclusion = new VotingConfigExclusion(node);
    public void testResolveByNodeIdWithDeprecatedMasterRole() {  
import static java.util.Collections.emptyMap;  
    }
            ).getMessage(),
        assertThat(deserialized.getNodeDescriptions(), equalTo(originalRequest.getNodeDescriptions()));
        final VotingConfigExclusion otherNode1Exclusion = new VotingConfigExclusion(otherNode1);
            "nodeId2",
            ).getMessage(),
            "nodeName2",  
        );
    }  
            equalTo(NODE_IDENTIFIERS_INCORRECTLY_SET_MSG)  
            containsInAnyOrder(otherNode1Exclusion, otherNode2Exclusion)
                    "setting.name"  
            emptyMap(),
            emptyMap(),  
        final DiscoveryNode node2 = new DiscoveryNode(  
        final VotingConfigExclusion node2Exclusion = new VotingConfigExclusion(node2);
            emptySet(),
            emptyMap(),
        final VotingConfigExclusion unresolvableVotingConfigExclusion = new VotingConfigExclusion(  
/*  
            buildNewFakeTransportAddress(),  
    public void testResolve() {
        final VotingConfigExclusion otherNode1Exclusion = new VotingConfigExclusion(otherNode1);
 *  
            "nodeId3",
        final ClusterState clusterState = ClusterState.builder(new ClusterName("cluster"))
            singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),  
 *
        assertWarnings(AddVotingConfigExclusionsRequest.DEPRECATION_MESSAGE);
        final ClusterState clusterState = builder.build();  
            buildNewFakeTransportAddress(),
        assertThat(deserialized.getNodeDescriptions(), equalTo(originalRequest.getNodeDescriptions()));
            Strings.EMPTY_ARRAY,  
            Version.CURRENT  
        assertThat(deserialized.getTimeout(), equalTo(originalRequest.getTimeout()));
            "nodeId",
    private static AddVotingConfigExclusionsRequest makeRequestWithNodeDescriptions(String... nodeDescriptions) {  
        builder.metadata(  
        final DiscoveryNode node = new DiscoveryNode(
        final DiscoveryNode node1 = new DiscoveryNode(
import org.opensearch.cluster.node.DiscoveryNodeRole;
                    TimeValue.ZERO
 * KIND, either express or implied.  See the License for the
        );
                () -> new AddVotingConfigExclusionsRequest(Strings.EMPTY_ARRAY, Strings.EMPTY_ARRAY, Strings.EMPTY_ARRAY, TimeValue.ZERO)  
        );
            .coordinationMetadata(CoordinationMetadata.builder().addVotingConfigExclusion(existingVotingConfigExclusion).build())
import java.io.IOException;
        );
        );
            "local",
            Metadata.builder().coordinationMetadata(CoordinationMetadata.builder().addVotingConfigExclusion(otherNode1Exclusion).build())
        final DiscoveryNode node1 = new DiscoveryNode(  
        AddVotingConfigExclusionsRequest originalRequest = new AddVotingConfigExclusionsRequest(
            expectThrows(
                    new String[] { "nodeId" },  
 * specific language governing permissions and limitations
                IllegalArgumentException.class,
        AddVotingConfigExclusionsRequest deserialized = copyWriteable(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            "other2",
    public void testResolveRemoveExistingVotingConfigExclusions() {
 * software distributed under the License is distributed on an
            emptyMap(),
        TimeValue timeout = TimeValue.timeValueMillis(between(0, 30000));
        final DiscoveryNode localNode = new DiscoveryNode(  
            emptyMap(),
            emptyMap(),  
            equalTo(NODE_IDENTIFIERS_INCORRECTLY_SET_MSG)
        assertThat(  
                )
 */
        assertThat(  
        assertThat(deserialized.getTimeout(), equalTo(originalRequest.getTimeout()));
import static org.hamcrest.Matchers.equalTo;
            buildNewFakeTransportAddress(),  
            emptyMap(),
        assertThat(
            originalRequest,  
                    Strings.EMPTY_ARRAY,
            Version.CURRENT  
/*
        );
        assertThat(
            containsInAnyOrder(node1Exclusion, node2Exclusion)
            emptyMap(),  
            VotingConfigExclusion.MISSING_VALUE_MARKER
            Version.CURRENT
            singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
            makeRequestWithNodeDescriptions("_all").resolveVotingConfigExclusions(clusterState),
    // The following 3 tests assign nodes by description, id and name respectively.
            ).getMessage(),
import org.opensearch.cluster.metadata.Metadata;
        final AddVotingConfigExclusionsRequest deserialized = copyWriteable(  
        final DiscoveryNode localNode = new DiscoveryNode(  
import org.opensearch.common.unit.TimeValue;  
 *
            containsInAnyOrder(node1Exclusion, unresolvableVotingConfigExclusion)
            "data",
 * Modifications Copyright OpenSearch Contributors. See  
            "local",  
        final VotingConfigExclusion localNodeExclusion = new VotingConfigExclusion(localNode);
            emptyMap(),  
                )  
                    TimeValue.ZERO  
            buildNewFakeTransportAddress(),
 * GitHub history for details.
        final ClusterState clusterState = ClusterState.builder(new ClusterName("cluster"))
        assertThat(  
            ).getMessage(),
            Version.CURRENT
            equalTo(NODE_IDENTIFIERS_INCORRECTLY_SET_MSG)
                new String[] { "nodeId1", "nodeId2" },  
                IllegalArgumentException.class,
        );
            )  
            .nodes(new Builder().add(localNode).localNodeId(localNode.getId()))
        final VotingConfigExclusion existingVotingConfigExclusion = new VotingConfigExclusion(node1);
            "nodeName3",
            new AddVotingConfigExclusionsRequest(Strings.EMPTY_ARRAY, new String[] { "nodeId" }, Strings.EMPTY_ARRAY, TimeValue.ZERO)
        final DiscoveryNode node3 = new DiscoveryNode(  
    public void testSerialization() throws IOException {
        );
                    Strings.EMPTY_ARRAY,
                    1,
                    new String[] { "nodeName" },
    public void testResolveByNodeIds() {  
    }
            emptyMap(),
import org.opensearch.cluster.coordination.CoordinationMetadata;  
 * Unless required by applicable law or agreed to in writing,
        );  
            singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
        final VotingConfigExclusion node1Exclusion = new VotingConfigExclusion(node1);  
                    new String[] { "local" },  
                Strings.EMPTY_ARRAY,
            singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),  
            buildNewFakeTransportAddress(),  
    }
            singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
        );  
            makeRequestWithNodeDescriptions("other*").resolveVotingConfigExclusions(clusterState),  
            singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
import org.opensearch.cluster.ClusterName;
            "other1",
                    new String[] { "nodeName" },
            "other1",
    public void testResolveByNodeNameWithDeprecatedMasterRole() {
package org.opensearch.action.admin.cluster.configuration;
            ).getMessage(),  
        );  
            "unresolvableNodeId",
            buildNewFakeTransportAddress(),  
        final VotingConfigExclusion otherNode2Exclusion = new VotingConfigExclusion(otherNode2);
import static java.util.Collections.singleton;
        );
            "local",
            emptyMap(),
                    new String[] { "local" },
            buildNewFakeTransportAddress(),
                "add voting config exclusions request for [_local] would add [1] exclusions to the existing [1] which would "
 * this file be licensed under the Apache-2.0 license or a
        final VotingConfigExclusion localNodeExclusion = new VotingConfigExclusion(localNode);
            "other2",
            emptyMap(),
            originalRequest,
            TimeValue.timeValueSeconds(30)
            new String[] { "nodeId1", "nodeId2" },
            ).resolveVotingConfigExclusions(clusterState),  
        final DiscoveryNode node = new DiscoveryNode(  
        );
            "nodeId",  
            emptyMap(),
            .build();
        assertThat(
        );  
            Version.CURRENT
                    new String[] { "local" },
        );
 */
                IllegalArgumentException.class,  
        assertThat(  
        );
 * compatible open source license.
        assertWarnings(AddVotingConfigExclusionsRequest.DEPRECATION_MESSAGE);
import static org.hamcrest.Matchers.containsInAnyOrder;
            "nodeName",
        assertThat(makeRequestWithNodeDescriptions("_local").resolveVotingConfigExclusions(clusterState), contains(localNodeExclusion));
            singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
            Version.CURRENT  
            singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
        assertThat(
            buildNewFakeTransportAddress(),
            emptyMap(),
            "local",
            buildNewFakeTransportAddress(),
import org.opensearch.cluster.node.DiscoveryNodes.Builder;
/*
            Strings.EMPTY_ARRAY,  
            "nodeId1",
            singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
        final DiscoveryNode node3 = new DiscoveryNode(
        assertThat(  
 * the Apache License, Version 2.0 (the "License"); you may
            "nodeName",
                IllegalArgumentException.class,
        assertThat(new AddVotingConfigExclusionsRequest("nodeName").resolveVotingConfigExclusions(clusterState), contains(nodeExclusion));  
            nodeDescriptions,
            ).resolveVotingConfigExclusions(clusterState),
            ).getMessage(),
            singleton(DiscoveryNodeRole.MASTER_ROLE),
            equalTo(  
        );
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfigExclusion;
            AddVotingConfigExclusionsRequest::new  
                TimeValue.ZERO
        assertThat(deserialized.getNodeIds(), equalTo(originalRequest.getNodeIds()));
        final ClusterState.Builder builder = ClusterState.builder(new ClusterName("cluster"))
            expectThrows(
    public void testResolveAllNodeIdentifiersNullOrEmpty() {
                Strings.EMPTY_ARRAY,
 */  
        final VotingConfigExclusion unresolvableVotingConfigExclusion = new VotingConfigExclusion(  
        );
            buildNewFakeTransportAddress(),
        }
            descriptions[i] = randomAlphaOfLength(10);  
    public void testResolveAndCheckMaximum() {
        );
        assertThat(deserialized.getNodeIds(), equalTo(originalRequest.getNodeIds()));  
    }  
                )  
    }
                    TimeValue.ZERO
                () -> new AddVotingConfigExclusionsRequest(  
        assertThat(deserialized.getTimeout(), equalTo(originalRequest.getTimeout()));  
    private static final String NODE_IDENTIFIERS_INCORRECTLY_SET_MSG = "Please set node identifiers correctly. "
            Version.CURRENT
            Version.CURRENT  
                    clusterState,
            .build();
import static java.util.Collections.emptySet;
            expectThrows(
                () -> new AddVotingConfigExclusionsRequest(
            "other1",  
            .nodes(new Builder().add(localNode).add(otherNode1).add(otherNode2).add(otherDataNode).localNodeId(localNode.getId()))  
        );  
        + "One and only one of [node_name], [node_names] and [node_ids] has to be set";  
            .build();
            .metadata(metadata)
            "nodeName2",  
