 * SPDX-License-Identifier: Apache-2.0
        assertTrue(votingConfigExclusions.contains(otherNode1Exclusion));  
import org.opensearch.core.common.Strings;
                            .build()
        localNodeExclusion = new CoordinationMetadata.VotingConfigExclusion(localNode);
    }
            Strings.EMPTY_ARRAY,
                        CoordinationMetadata.builder()
 * The OpenSearch Contributors require contributions made to  
                    .add(otherDataNode)  
            otherNode2
        assertTrue(updatedState.coordinationMetadata().getVotingConfigExclusions().contains(localNodeExclusion));  
    private static ClusterState initialClusterState;  
            new String[] { "other1", "other2" },  
import org.opensearch.cluster.ClusterName;
            Strings.EMPTY_ARRAY,
/*  
 * this file be licensed under the Apache-2.0 license or a
        otherNode1 = makeDiscoveryNode("other1");  
    public void testAddExclusionAndGetState() {
            )  
package org.opensearch.action.admin.cluster.configuration;
import org.junit.BeforeClass;  
            )  
        assertTrue(updatedState.coordinationMetadata().getVotingConfigExclusions().contains(localNodeExclusion));
            initialClusterState,
        localNode = makeDiscoveryNode("local");
        assertEquals(1, votingConfigExclusions.size());
    public void testClearExclusionAndGetState() {
            .nodes(
    }
        );  
import org.opensearch.cluster.node.DiscoveryNode;  
            Strings.EMPTY_ARRAY,  
        initialClusterState = ClusterState.builder(new ClusterName("cluster"))
    public void testResolveVotingConfigExclusionFailsWhenLimitExceeded() {  
        assertTrue(updatedState.coordinationMetadata().getVotingConfigExclusions().isEmpty());
 *
            Version.CURRENT
    }  
import org.opensearch.cluster.coordination.CoordinationMetadata;
    private static DiscoveryNode makeDiscoveryNode(String name) {
import java.util.Set;
import org.opensearch.cluster.metadata.Metadata;
import static org.opensearch.action.admin.cluster.configuration.VotingConfigExclusionsHelper.clearExclusionsAndGetState;
        updatedState = clearExclusionsAndGetState(updatedState);
import org.opensearch.Version;
 */  
        assertEquals(1, updatedState.coordinationMetadata().getVotingConfigExclusions().size());
        AddVotingConfigExclusionsRequest request = new AddVotingConfigExclusionsRequest(
        Set<CoordinationMetadata.VotingConfigExclusion> votingConfigExclusions = resolveVotingConfigExclusionsAndCheckMaximum(  
            Strings.EMPTY_ARRAY,
    private static CoordinationMetadata.VotingConfigExclusion localNodeExclusion, otherNode1Exclusion, otherNode2Exclusion;
import org.opensearch.common.unit.TimeValue;  
        );
            localNode,  
        );  
        AddVotingConfigExclusionsRequest request = new AddVotingConfigExclusionsRequest(  
}
    }
    }  
        );
            buildNewFakeTransportAddress(),
                            .lastAcceptedConfiguration(allNodesConfig)
        ClusterState updatedState = addExclusionAndGetState(initialClusterState, Set.of(localNodeExclusion), 2);  
            request,
                    .add(otherNode1)
                    .add(otherNode2)
        expectThrows(IllegalArgumentException.class, () -> resolveVotingConfigExclusionsAndCheckMaximum(request, initialClusterState, 1));
import static org.opensearch.action.admin.cluster.configuration.VotingConfigExclusionsHelper.resolveVotingConfigExclusionsAndCheckMaximum;  
            singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
                Metadata.builder()
        ClusterState updatedState = addExclusionAndGetState(initialClusterState, Set.of(localNodeExclusion), 2);
import org.opensearch.cluster.ClusterState;  
public class VotingConfigExclusionsHelperTests extends OpenSearchTestCase {
    private static DiscoveryNode localNode, otherNode1, otherNode2, otherDataNode;
        otherDataNode = new DiscoveryNode("data", "data", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
                new DiscoveryNodes.Builder().add(localNode)  
            name,
            emptyMap(),  
        otherNode2 = makeDiscoveryNode("other2");
    public void testResolveVotingConfigExclusions() {
        final CoordinationMetadata.VotingConfiguration allNodesConfig = CoordinationMetadata.VotingConfiguration.of(
import static java.util.Collections.singleton;  
import org.opensearch.cluster.node.DiscoveryNodeRole;
 * compatible open source license.
            new String[] { "other1" },
                    )
import org.opensearch.cluster.node.DiscoveryNodes;
        otherNode1Exclusion = new CoordinationMetadata.VotingConfigExclusion(otherNode1);
            .build();
        return new DiscoveryNode(
                    .localNodeId(localNode.getId())
                            .lastCommittedConfiguration(allNodesConfig)  
    }
                    .clusterManagerNodeId(localNode.getId())
                    .coordinationMetadata(  
    public static void createBaseClusterState() {  
import static org.opensearch.action.admin.cluster.configuration.VotingConfigExclusionsHelper.addExclusionAndGetState;
import org.opensearch.test.OpenSearchTestCase;
        otherNode2Exclusion = new CoordinationMetadata.VotingConfigExclusion(otherNode2);  
            TimeValue.timeValueSeconds(30)
        );  
import static java.util.Collections.emptySet;
            .metadata(
import static java.util.Collections.emptyMap;
            10  
            otherNode1,
    @BeforeClass
            name,  
            TimeValue.timeValueSeconds(30)
