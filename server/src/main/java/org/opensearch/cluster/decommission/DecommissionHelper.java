                if (nodeHasDecommissionedAttribute(discoveryNode, decommissionAttribute)  
                    && (status.equals(DecommissionStatus.IN_PROGRESS)
import static org.opensearch.action.admin.cluster.configuration.VotingConfigExclusionsHelper.addExclusionAndGetState;
     */
     * @return true or false based on whether node has decommissioned attribute
        );
            .build();
        if (decommissionAttributeMetadata != null) {
/*  
        Metadata metadata = currentState.metadata();
            DecommissionStatus status = decommissionAttributeMetadata.status();
package org.opensearch.cluster.decommission;
        DecommissionAttribute decommissionAttribute,  
        String nodeAttributeValue = discoveryNode.getAttributes().get(decommissionAttribute.attributeName());
        return true;
    static Set<DiscoveryNode> filterNodesWithDecommissionAttribute(
    public static boolean nodeHasDecommissionedAttribute(DiscoveryNode discoveryNode, DecommissionAttribute decommissionAttribute) {  
                }
    }  
    ) {  
 * SPDX-License-Identifier: Apache-2.0
            Strings.EMPTY_ARRAY,  
        return ClusterState.builder(currentState).metadata(mdBuilder).build();
        return nodesWithDecommissionAttribute;
            }  
            nodeIdsToBeExcluded.toArray(String[]::new),
            if (nodeHasDecommissionedAttribute(node, decommissionAttribute)) {
        DecommissionAttribute decommissionAttribute,
        ClusterState currentState,  
            decommissionActionTimeout  
    static ClusterState registerDecommissionAttributeInClusterState(
            currentState,
import static org.opensearch.action.admin.cluster.configuration.VotingConfigExclusionsHelper.resolveVotingConfigExclusionsAndCheckMaximum;
     * Utility method to check if the node has decommissioned attribute  
import java.util.Iterator;
        return nodeAttributeValue != null && nodeAttributeValue.equals(decommissionAttribute.attributeValue());
                    return false;
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfigExclusion;  
        return ClusterState.builder(currentState)
            : clusterState.nodes().getNodes().values().iterator();  
 *  
        }
/**
 * The OpenSearch Contributors require contributions made to  
        Iterator<DiscoveryNode> nodesIter = onlyClusterManagerNodes
            DecommissionAttribute decommissionAttribute = decommissionAttributeMetadata.decommissionAttribute();  
        );  
    }  
     * @param discoveryNode node to check on
        Metadata.Builder mdBuilder = Metadata.builder(metadata);  
            final DiscoveryNode node = nodesIter.next();  
     * @param discoveryNode node to check on
import java.util.HashSet;  
     */
import org.opensearch.action.admin.cluster.configuration.AddVotingConfigExclusionsRequest;
 * this file be licensed under the Apache-2.0 license or a
        }
public class DecommissionHelper {  
    }  
            maxVotingConfigExclusions
        ClusterState currentState,  
        while (nodesIter.hasNext()) {
     * @param metadata metadata present current which will be used to check the commissioning status of the node  
import java.util.Set;
    }  
            request,  
import org.opensearch.common.unit.TimeValue;  
                        || status.equals(DecommissionStatus.DRAINING))) {  
     *
 */
 * @opensearch.internal
        Set<VotingConfigExclusion> resolvedExclusion = resolveVotingConfigExclusionsAndCheckMaximum(
        final int maxVotingConfigExclusions  
        return addExclusionAndGetState(currentState, resolvedExclusion, maxVotingConfigExclusions);
    static ClusterState deleteDecommissionAttributeInClusterState(ClusterState currentState) {
        Set<DiscoveryNode> nodesWithDecommissionAttribute = new HashSet<>();  
 * Static helper utilities to execute decommission
        Set<String> nodeIdsToBeExcluded,
        mdBuilder.removeCustom(DecommissionAttributeMetadata.TYPE);
     * @return if the node is commissioned or not
            if (decommissionAttribute != null && status != null) {
        TimeValue decommissionActionTimeout,
                        || status.equals(DecommissionStatus.SUCCESSFUL)
    static ClusterState addVotingConfigExclusionsForNodesToBeDecommissioned(
    /**
import org.opensearch.cluster.node.DiscoveryNode;
     * @param decommissionAttribute attribute to be checked with  
import org.opensearch.core.common.Strings;
import org.opensearch.cluster.metadata.Metadata;
        ClusterState clusterState,
    }
        DecommissionAttributeMetadata decommissionAttributeMetadata = new DecommissionAttributeMetadata(decommissionAttribute, requestID);
                nodesWithDecommissionAttribute.add(node);
        String requestID
            .metadata(Metadata.builder(currentState.metadata()).decommissionAttributeMetadata(decommissionAttributeMetadata))  
 */  
 *
    /**
        AddVotingConfigExclusionsRequest request = new AddVotingConfigExclusionsRequest(
            }  
     *
import org.opensearch.cluster.ClusterState;
        DecommissionAttributeMetadata decommissionAttributeMetadata = metadata.decommissionAttributeMetadata();
            Strings.EMPTY_ARRAY,
    ) {
     * Utility method to check if the node is commissioned or not  
            ? clusterState.nodes().getClusterManagerNodes().values().iterator()
    public static boolean nodeCommissioned(DiscoveryNode discoveryNode, Metadata metadata) {  
        boolean onlyClusterManagerNodes
}
    }
    ) {
 * compatible open source license.
