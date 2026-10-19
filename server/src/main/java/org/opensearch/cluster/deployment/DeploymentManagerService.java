            metadataBuilder.removeCustom(DeploymentMetadata.TYPE);
        return innerTransitionDeployment(deploymentId, Collections.emptyMap(), currentState, targetState);
import java.util.Map;  
     * @param request the original request sent to the cluster.
     *                       for a node to be considered part of the deployment.  
        }
            @Override
            throw new IllegalArgumentException("attributes must not be empty");
        if (deployments.isEmpty()) {
        if (deploymentId == null || deploymentId.isEmpty()) {
            }
    static ClusterState innerTransitionDeployment(
                    deployments.remove(deploymentId);  
    }  
                        throw new IllegalArgumentException(
        for (Map.Entry<String, Deployment> entry : existingDeployments.entrySet()) {  
            }
            return;
import org.opensearch.cluster.service.ClusterService;  
            listener.onFailure(e);
        DeploymentState targetState
            public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
            }
            public ClusterState execute(ClusterState currentState) {  
                validateNoOverlappingValues(deployments, deploymentId, nodeAttributes);
                validateConsistentKeys(deployments, nodeAttributes);  
    }
            }  
                }  
    }
 * Runs on the elected cluster manager node only.
        ClusterState currentState,
    private static void validateDeploymentId(String deploymentId) {  
            case DRAIN -> {
        this.rerouteService = rerouteService;
                throw new IllegalArgumentException("deployment ID must not contain whitespace");  
            validateDeploymentId(deploymentId);
            throw new IllegalArgumentException("deployment ID must not be empty");
                if (existingDeploymentWithSameId.getNodeAttributes().equals(newAttributes) == false) {  
            }  
            return;  
            if (!existingKeys.equals(newAttributes.keySet())) {
                throw new IllegalArgumentException(  
                    throw new IllegalArgumentException(
                    "deployment attribute keys " + newAttributes.keySet() + " must match existing deployment keys " + existingKeys
            if (entry.getKey().equals(newDeploymentId)) {
        try {
    static ClusterState innerTransitionDeployment(String deploymentId, ClusterState currentState, DeploymentState targetState) {  
            }  
        }
                rerouteService.reroute("deployment drain started", Priority.HIGH, ActionListener.wrap(() -> {}));
        for (int i = 0; i < deploymentId.length(); i++) {
        Map<String, String> nodeAttributes,  
                if (existingDeploymentWithSameId.getState() != DeploymentState.DRAIN) {
            @Override
            validateAttributes(nodeAttributes);  
        AckedRequest request,
    public void startDeployment(
        });  
import org.opensearch.cluster.routing.RerouteService;  
        switch (targetState) {
        } catch (IllegalArgumentException e) {
import java.util.HashMap;
            @Override
        Map<String, Deployment> deployments = currentMetadata == null ? new HashMap<>() : new HashMap<>(currentMetadata.getDeployments());
    public DeploymentManagerService(ClusterService clusterService, RerouteService rerouteService) {  
                } else {
                            + existingDeploymentWithSameId.getNodeAttributes()
        clusterService.submitStateUpdateTask("start-deployment-" + deploymentId, new AckedClusterStateUpdateTask<>(request, listener) {  
                }  
            throw new IllegalArgumentException("deployment ID must not start with '_'");
        return ClusterState.builder(currentState).metadata(metadataBuilder).build();  
            public void onAllNodesAcked(Exception e) {  
public class DeploymentManagerService {  
                            + ", already targeted "  
        String deploymentId,
                            "deployment [" + entry.getKey() + "] already targets attribute " + nodeAttr.getKey() + "=" + nodeAttr.getValue()
            }
            }
import static org.opensearch.cluster.deployment.DeploymentState.DRAIN;  
                return new AcknowledgedResponse(acknowledged);
        }
        ActionListener<AcknowledgedResponse> listener
            @Override  
    private static void validateAttributes(Map<String, String> attributes) {
        }
            public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
    /**  
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;
        for (Deployment existingDeployment : existingDeployments.values()) {  
     * @param listener listener for the cluster state update.
            @Override
 */
                    if (nodeAttr.getValue().equals(newAttributes.get(nodeAttr.getKey()))) {  
     * @param deploymentId unique identifier for the given deployment
        }
                deployments.put(deploymentId, new Deployment(DeploymentState.DRAIN, nodeAttributes));
    }
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.ack.AckedRequest;
                        "deployment ["
    }
    ) {
        Map<String, String> nodeAttributes,  
        }
                            + "] is not allowed to update targeting attributes to "
                    }
                        );  
            }
        this.clusterService = clusterService;
    private final RerouteService rerouteService;  
        Map<String, Deployment> existingDeployments,
            @Override
            if (Character.isWhitespace(deploymentId.charAt(i))) {
        clusterService.submitStateUpdateTask("finish-deployment-" + deploymentId, new AckedClusterStateUpdateTask<>(request, listener) {
                return transitionDeploymentTaskKey;
    }  
 *
            case FINISH -> {
        }
        for (Map.Entry<String, String> entry : attributes.entrySet()) {  
                            + entry.getKey()  
package org.opensearch.cluster.deployment;
    private final ClusterService clusterService;
import org.opensearch.common.Priority;
            }  
    public void finishDeployment(String deploymentId, AckedRequest request, ActionListener<AcknowledgedResponse> listener) {  
                );
            @Override
import org.opensearch.cluster.AckedClusterStateUpdateTask;
    private final ClusterManagerTaskThrottler.ThrottlingKey transitionDeploymentTaskKey;
                throw new IllegalArgumentException("attribute value for key [" + entry.getKey() + "] must not be empty");  
    }
                return new AcknowledgedResponse(acknowledged);
                }
                    );
        }
import org.opensearch.core.action.ActionListener;
        } else {  
        this.transitionDeploymentTaskKey = clusterService.registerClusterManagerTask(ClusterManagerTask.TRANSITION_DEPLOYMENT, true);  
            if (value == null || value.isEmpty()) {
            String value = entry.getValue();
        }  
            }
        }
     * @param nodeAttributes the set of attributes used to identify the nodes to be drained. All attributes must match
        DeploymentMetadata currentMetadata = currentState.metadata().custom(DeploymentMetadata.TYPE);
            public ClusterState execute(ClusterState currentState) {
    }
                return transitionDeploymentTaskKey;  
    private static void validateConsistentKeys(Map<String, Deployment> existingDeployments, Map<String, String> newAttributes) {
                            + newAttributes
        });  
        }  
                for (Map.Entry<String, String> nodeAttr : entry.getValue().getNodeAttributes().entrySet()) {
        String newDeploymentId,  
                    throw new IllegalArgumentException(
                    return currentState;
            Set<String> existingKeys = existingDeployment.getNodeAttributes().keySet();
        Map<String, String> newAttributes
                throw new IllegalArgumentException("attribute value [" + value + "] must not contain '*'");  
/*  
            protected AcknowledgedResponse newResponse(boolean acknowledged) {
import org.opensearch.cluster.ClusterState;  
    ) {  
            metadataBuilder.putCustom(DeploymentMetadata.TYPE, new DeploymentMetadata(deployments));
 * compatible open source license.
    }
import java.util.Set;
 * @opensearch.internal
                }
/**  
                return innerTransitionDeployment(deploymentId, nodeAttributes, currentState, DRAIN);  
            @Override  
        if (deploymentId.startsWith("_")) {
import org.opensearch.cluster.metadata.Metadata;
        String deploymentId,
 * Service that manages deployment lifecycle by writing DeploymentMetadata to cluster state.
 * SPDX-License-Identifier: Apache-2.0
import java.util.Collections;
            } else {
            }
import static org.opensearch.cluster.deployment.DeploymentState.FINISH;
                if (deployments.containsKey(deploymentId)) {
     */  
        if (attributes == null || attributes.isEmpty()) {  
            protected AcknowledgedResponse newResponse(boolean acknowledged) {  
 */  
}  
                // We allow idempotent application of start deployment.
        Metadata.Builder metadataBuilder = Metadata.builder(currentState.metadata());  
                super.onAllNodesAcked(e);  
            }  
                        "deployment [" + entry.getKey() + "] is already in state " + existingDeploymentWithSameId.getState()  
            public void onAllNodesAcked(Exception e) {
    ) {  
 * The OpenSearch Contributors require contributions made to  
                Deployment existingDeploymentWithSameId = entry.getValue();  
                return innerTransitionDeployment(deploymentId, currentState, FINISH);
        if (existingDeployments.isEmpty()) {  
            }
            }
                    );
 *  
            if (value.contains("*")) {
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
import org.opensearch.cluster.service.ClusterManagerTask;
    private static void validateNoOverlappingValues(
                super.onAllNodesAcked(e);
