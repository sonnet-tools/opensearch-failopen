    }
        assertEquals(1, filteredNodes.size());  
 *
import org.opensearch.cluster.metadata.Metadata;
                Metadata.builder()
    private static DiscoveryNode makeDiscoveryNode(String name, String zone) {
        node1 = makeDiscoveryNode("node1", "zone1");
        filteredNodes = filterNodesWithDecommissionAttribute(initialClusterState, decommissionAttribute, false);
        DecommissionAttribute decommissionAttribute = new DecommissionAttribute("zone", "zone1");
        assertTrue(nodeCommissioned(node2, metadata));
/*  
        );  
        );  
                    .localNodeId(node1.getId())
            name,
        dataNode = new DiscoveryNode(
        );
            Version.CURRENT
        DecommissionAttribute decommissionAttribute = new DecommissionAttribute("zone", "zone2");  
            Version.CURRENT
 * this file be licensed under the Apache-2.0 license or a
        DecommissionAttribute decommissionAttribute = new DecommissionAttribute("zone", "zone1");  
                    .coordinationMetadata(  
            singletonMap("zone", zone),  
package org.opensearch.cluster.decommission;
            decommissionAttribute,  
import org.opensearch.Version;
    }  
 * The OpenSearch Contributors require contributions made to  
        assertEquals(decommissionAttribute, updatedState.metadata().decommissionAttributeMetadata().decommissionAttribute());  
            name,  
        assertTrue(nodeCommissioned(node2, metadata));
import org.opensearch.cluster.coordination.CoordinationMetadata;
        assertNull(updatedState.metadata().decommissionAttributeMetadata());
        assertTrue(nodeCommissioned(node1, metadata));
    private static ClusterState initialClusterState;  
import static org.opensearch.cluster.decommission.DecommissionHelper.deleteDecommissionAttributeInClusterState;
    }  
            nodeIdToBeExcluded,  
                    )
                    .add(node3)
        ClusterState updatedState = registerDecommissionAttributeInClusterState(
            10
        metadata = Metadata.builder().putCustom(DecommissionAttributeMetadata.TYPE, decommissionAttributeMetadata).build();  
        );
            .nodes(
        assertTrue(nodeCommissioned(node1, metadata));
import org.junit.BeforeClass;
        CoordinationMetadata.VotingConfigExclusion v1 = new CoordinationMetadata.VotingConfigExclusion(node2);
 */  
import static org.opensearch.cluster.decommission.DecommissionHelper.filterNodesWithDecommissionAttribute;
 * compatible open source license.
            DecommissionStatus.DRAINING,
            .metadata(
            randomAlphaOfLength(10)
        DecommissionAttributeMetadata decommissionAttributeMetadata = new DecommissionAttributeMetadata(
        assertTrue(filteredNodes.contains(dataNode));  
            initialClusterState,
                            .build()
import static org.opensearch.cluster.decommission.DecommissionHelper.addVotingConfigExclusionsForNodesToBeDecommissioned;  
            )  
                    .add(dataNode)  
                            .lastCommittedConfiguration(allNodesConfig)  
        node3 = makeDiscoveryNode("node3", "zone3");  
            singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
            buildNewFakeTransportAddress(),
        DecommissionStatus commissionStatus = randomFrom(DecommissionStatus.FAILED, DecommissionStatus.INIT);
            DecommissionStatus.IN_PROGRESS,
    }
import org.opensearch.test.OpenSearchTestCase;
        assertTrue(
    public void testFilterNodes() {
        initialClusterState = ClusterState.builder(new ClusterName("cluster"))
    public void testNodeCommissioned() {
    public void testRegisterAndDeleteDecommissionAttributeInClusterState() {
import org.opensearch.cluster.node.DiscoveryNodes;
    }
                    .clusterManagerNodeId(node1.getId())
import org.opensearch.common.unit.TimeValue;  
        node2 = makeDiscoveryNode("node2", "zone2");
        Metadata metadata = Metadata.builder().putCustom(DecommissionAttributeMetadata.TYPE, decommissionAttributeMetadata).build();
import static java.util.Collections.singletonMap;
            .build();
                            .lastAcceptedConfiguration(allNodesConfig)
}
    public void testAddVotingConfigExclusionsForNodesToBeDecommissioned() {
    }  
        assertEquals(2, filteredNodes.size());
        assertEquals(1, updatedState.coordinationMetadata().getVotingConfigExclusions().size());
import org.opensearch.cluster.node.DiscoveryNodeRole;
import static org.opensearch.cluster.decommission.DecommissionHelper.registerDecommissionAttributeInClusterState;
            buildNewFakeTransportAddress(),
            singletonMap("zone", "zone1"),
    public static void createBaseClusterState() {  
            decommissionStatus,
            updatedState.coordinationMetadata().getVotingConfigExclusions().contains(new CoordinationMetadata.VotingConfigExclusion(node2))  
        );  
            "data",  
            initialClusterState,
            DecommissionStatus.SUCCESSFUL  
                new DiscoveryNodes.Builder().add(node1)  
        ClusterState updatedState = addVotingConfigExclusionsForNodesToBeDecommissioned(
        assertTrue(filteredNodes.contains(node1));
        );
        return new DiscoveryNode(
import static java.util.Collections.singleton;
import org.opensearch.cluster.ClusterName;
            "data",
import static org.opensearch.cluster.decommission.DecommissionHelper.nodeCommissioned;  
    @BeforeClass
            emptySet(),  
        Set<String> nodeIdToBeExcluded = Set.of("node2");  
        metadata = Metadata.builder().removeCustom(DecommissionAttributeMetadata.TYPE).build();  
 * SPDX-License-Identifier: Apache-2.0
        assertTrue(nodeCommissioned(node2, metadata));
            )  
import org.opensearch.cluster.node.DiscoveryNode;  
        decommissionAttributeMetadata = new DecommissionAttributeMetadata(decommissionAttribute, commissionStatus, randomAlphaOfLength(10));
                    .add(node2)
    private static DiscoveryNode node1, node2, node3, dataNode;
public class DecommissionHelperTests extends OpenSearchTestCase {  
        assertFalse(nodeCommissioned(node1, metadata));  
            randomAlphaOfLength(10)
        assertTrue(filteredNodes.contains(node1));
import java.util.Set;
        DecommissionStatus decommissionStatus = randomFrom(  
        Set<DiscoveryNode> filteredNodes = filterNodesWithDecommissionAttribute(initialClusterState, decommissionAttribute, true);
        final CoordinationMetadata.VotingConfiguration allNodesConfig = CoordinationMetadata.VotingConfiguration.of(node1, node2, node3);  
        updatedState = deleteDecommissionAttributeInClusterState(updatedState);
            TimeValue.timeValueMinutes(1),
import static java.util.Collections.emptySet;  
import org.opensearch.cluster.ClusterState;  
                        CoordinationMetadata.builder()
            decommissionAttribute,  
        );
