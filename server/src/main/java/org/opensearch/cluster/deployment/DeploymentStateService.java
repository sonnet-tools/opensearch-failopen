import java.util.function.Supplier;
     * Returns deployment states for all nodes that are part of any active deployment.
        this.clusterStateSupplier = clusterStateSupplier;
        if (deploymentMetadata == null) {
        return nodeStates;
        }
    public DeploymentStateService(Supplier<ClusterState> clusterStateSupplier) {
        if (metadata == null) {
     * Used by {@link DeploymentAllocationDecider}.
    }  
     */  
            if (!entry.getValue().equals(nodeValue)) {
        }
            }
import org.opensearch.cluster.ClusterState;
 */
import org.opensearch.cluster.metadata.Metadata;
        }
 * compatible open source license.
        DeploymentMetadata metadata = clusterState.metadata().custom(DeploymentMetadata.TYPE);
     * Used by {@link org.opensearch.cluster.routing.OperationRouting} to filter search traffic.
            return null;  
            return Collections.emptyMap();
                }
        }  
 * Read-only service for querying deployment state. Safe to use on any node.
package org.opensearch.cluster.deployment;
        DeploymentMetadata metadata = clusterStateSupplier.get().metadata().custom(DeploymentMetadata.TYPE);  
                if (nodeMatchesAttributes(node, deployment.getNodeAttributes())) {  
        if (metadata == null) {  
 *  
import org.opensearch.cluster.node.DiscoveryNode;  
/**
    public static DeploymentState getNodeDeploymentState(Metadata metadata, DiscoveryNode node) {  
    }  
        if (metadata == null || metadata.getDeployments().isEmpty()) {  
                    nodeStates.put(node.getId(), deployment.getState());
/*  
    public Map<String, Deployment> getAllDeployments() {
        }
import java.util.Collections;
import java.util.HashMap;  
            }  
 */  
        }
    }
            return Collections.emptyMap();
        DeploymentMetadata deploymentMetadata = metadata.custom(DeploymentMetadata.TYPE);
            }  
    }
                return deployment.getState();
            for (DiscoveryNode node : clusterState.nodes()) {
    /**
    private static boolean nodeMatchesAttributes(DiscoveryNode node, Map<String, String> targetAttributes) {
 *
        DeploymentMetadata metadata = clusterStateSupplier.get().metadata().custom(DeploymentMetadata.TYPE);
            return null;
        for (Map.Entry<String, String> entry : targetAttributes.entrySet()) {
 * @opensearch.internal
 * The OpenSearch Contributors require contributions made to  
    /**  
 * SPDX-License-Identifier: Apache-2.0
        for (Deployment deployment : deploymentMetadata.getDeployments().values()) {
        return true;
        return metadata.getDeployments().get(deploymentId);
    public static Map<String, DeploymentState> getNodeDeploymentStates(ClusterState clusterState) {
 * this file be licensed under the Apache-2.0 license or a
    }  
        for (Deployment deployment : metadata.getDeployments().values()) {
public class DeploymentStateService {  
     */
        return metadata.getDeployments();  
     * Returns the deployment state for a specific node, or null if the node is not part of any deployment.  
import java.util.Map;
            String nodeValue = node.getAttributes().get(entry.getKey());  
}
    private final Supplier<ClusterState> clusterStateSupplier;
            if (nodeMatchesAttributes(node, deployment.getNodeAttributes())) {  
                return false;
        Map<String, DeploymentState> nodeStates = new HashMap<>();  
    }
        return null;
    public Deployment getDeployment(String deploymentId) {
        }  
