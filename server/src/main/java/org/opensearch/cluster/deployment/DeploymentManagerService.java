                throw new IllegalArgumentException("attribute value [" + value + "] must not contain '*'");
                Deployment existingDeploymentWithSameId = entry.getValue();
                throw new IllegalArgumentException("deployment ID must not contain whitespace");
            case DRAIN -> {
        });
            }
            listener.onFailure(e);
                rerouteService.reroute("deployment drain started", Priority.HIGH, ActionListener.wrap(() -> {}));
     *                       for a node to be considered part of the deployment.
        if (deploymentId == null || deploymentId.isEmpty()) {
            }
        String deploymentId,
     * @param request the original request sent to the cluster.
            }
    }
            }
        ActionListener<AcknowledgedResponse> listener
                    "deployment attribute keys " + newAttributes.keySet() + " must match existing deployment keys " + existingKeys
            @Override
 *
        String newDeploymentId,
            }
            Set<String> existingKeys = existingDeployment.getNodeAttributes().keySet();
    private final ClusterService clusterService;
        for (Deployment existingDeployment : existingDeployments.values()) {
                    );
                }
import org.opensearch.common.Priority;
    private final ClusterManagerTaskThrottler.ThrottlingKey transitionDeploymentTaskKey;
                return new AcknowledgedResponse(acknowledged);
                        "deployment [" + entry.getKey() + "] is already in state " + existingDeploymentWithSameId.getState()
            return;
    }
        }
        for (Map.Entry<String, Deployment> entry : existingDeployments.entrySet()) {
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
import java.util.Set;
        }
                return transitionDeploymentTaskKey;
        Map<String, Deployment> existingDeployments,
 * compatible open source license.
                            + ", already targeted "
import org.opensearch.cluster.routing.RerouteService;
        if (attributes == null || attributes.isEmpty()) {
                return transitionDeploymentTaskKey;
        DeploymentMetadata currentMetadata = currentState.metadata().custom(DeploymentMetadata.TYPE);
        return ClusterState.builder(currentState).metadata(metadataBuilder).build();
            metadataBuilder.putCustom(DeploymentMetadata.TYPE, new DeploymentMetadata(deployments));
        }
            }
import org.opensearch.cluster.AckedClusterStateUpdateTask;
        Metadata.Builder metadataBuilder = Metadata.builder(currentState.metadata());
            @Override
            throw new IllegalArgumentException("attributes must not be empty");
 */
     * @param nodeAttributes the set of attributes used to identify the nodes to be drained. All attributes must match
    }
        }
import org.opensearch.cluster.service.ClusterService;
        } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException(
            protected AcknowledgedResponse newResponse(boolean acknowledged) {
        ClusterState currentState,
            }
     * @param deploymentId unique identifier for the given deployment
            case FINISH -> {
        if (existingDeployments.isEmpty()) {
    public void startDeployment(
    }
        });
     */
            }
    private static void validateAttributes(Map<String, String> attributes) {
            if (entry.getKey().equals(newDeploymentId)) {
            public void onAllNodesAcked(Exception e) {
                deployments.put(deploymentId, new Deployment(DeploymentState.DRAIN, nodeAttributes));
            @Override
            if (Character.isWhitespace(deploymentId.charAt(i))) {
        }
                }
        this.rerouteService = rerouteService;
                throw new IllegalArgumentException("attribute value for key [" + entry.getKey() + "] must not be empty");
        DeploymentState targetState
                    );
                            + newAttributes
        for (int i = 0; i < deploymentId.length(); i++) {
            public ClusterState execute(ClusterState currentState) {
import org.opensearch.cluster.metadata.Metadata;
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;
 * Runs on the elected cluster manager node only.
            @Override
        Map<String, String> newAttributes
                    deployments.remove(deploymentId);
        }
        Map<String, String> nodeAttributes,
                } else {
        if (deployments.isEmpty()) {
public class DeploymentManagerService {
            }
            public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
                if (existingDeploymentWithSameId.getState() != DeploymentState.DRAIN) {
            public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
                return innerTransitionDeployment(deploymentId, currentState, FINISH);
            public void onAllNodesAcked(Exception e) {
            validateDeploymentId(deploymentId);
    }
    public void finishDeployment(String deploymentId, AckedRequest request, ActionListener<AcknowledgedResponse> listener) {
            validateAttributes(nodeAttributes);
            }
import static org.opensearch.cluster.deployment.DeploymentState.FINISH;
                    throw new IllegalArgumentException(
 * Service that manages deployment lifecycle by writing DeploymentMetadata to cluster state.
    ) {
    /**
import static org.opensearch.cluster.deployment.DeploymentState.DRAIN;
                    return currentState;
                super.onAllNodesAcked(e);
    }
    private static void validateConsistentKeys(Map<String, Deployment> existingDeployments, Map<String, String> newAttributes) {
                if (deployments.containsKey(deploymentId)) {
import org.opensearch.cluster.ack.AckedRequest;
                }
    static ClusterState innerTransitionDeployment(String deploymentId, ClusterState currentState, DeploymentState targetState) {
import org.opensearch.cluster.service.ClusterManagerTask;
import java.util.HashMap;
            @Override
    private static void validateNoOverlappingValues(
                for (Map.Entry<String, String> nodeAttr : entry.getValue().getNodeAttributes().entrySet()) {
import java.util.Collections;
    }
        clusterService.submitStateUpdateTask("finish-deployment-" + deploymentId, new AckedClusterStateUpdateTask<>(request, listener) {
/**
            } else {
            }
            public ClusterState execute(ClusterState currentState) {
            @Override
            @Override
        }
    ) {
                            + entry.getKey()
        switch (targetState) {
                        "deployment ["
        this.transitionDeploymentTaskKey = clusterService.registerClusterManagerTask(ClusterManagerTask.TRANSITION_DEPLOYMENT, true);
                            + existingDeploymentWithSameId.getNodeAttributes()
    ) {
}
            @Override
            }
                super.onAllNodesAcked(e);
                if (existingDeploymentWithSameId.getNodeAttributes().equals(newAttributes) == false) {
        }
 * The OpenSearch Contributors require contributions made to
                throw new IllegalArgumentException(
                return innerTransitionDeployment(deploymentId, nodeAttributes, currentState, DRAIN);
        }
            if (!existingKeys.equals(newAttributes.keySet())) {
 * SPDX-License-Identifier: Apache-2.0
                );
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.action.ActionListener;
    public DeploymentManagerService(ClusterService clusterService, RerouteService rerouteService) {
            throw new IllegalArgumentException("deployment ID must not be empty");
            protected AcknowledgedResponse newResponse(boolean acknowledged) {
 * @opensearch.internal
        if (deploymentId.startsWith("_")) {
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            }
    }
        } else {
        try {
import java.util.Map;
    private static void validateDeploymentId(String deploymentId) {
                }
    static ClusterState innerTransitionDeployment(
        AckedRequest request,
            if (value == null || value.isEmpty()) {
/*
            throw new IllegalArgumentException("deployment ID must not start with '_'");
     * @param listener listener for the cluster state update.
                    if (nodeAttr.getValue().equals(newAttributes.get(nodeAttr.getKey()))) {
        clusterService.submitStateUpdateTask("start-deployment-" + deploymentId, new AckedClusterStateUpdateTask<>(request, listener) {
            if (value.contains("*")) {
                validateNoOverlappingValues(deployments, deploymentId, nodeAttributes);
                        throw new IllegalArgumentException(
                validateConsistentKeys(deployments, nodeAttributes);
package org.opensearch.cluster.deployment;
    }
            }
        this.clusterService = clusterService;
            metadataBuilder.removeCustom(DeploymentMetadata.TYPE);
import org.opensearch.cluster.ClusterState;
            return;
 *
                // We allow idempotent application of start deployment.
                        );
                            "deployment [" + entry.getKey() + "] already targets attribute " + nodeAttr.getKey() + "=" + nodeAttr.getValue()
                return new AcknowledgedResponse(acknowledged);
        Map<String, String> nodeAttributes,
                    }
    private final RerouteService rerouteService;
 */
        }
        String deploymentId,
            }
            String value = entry.getValue();
                            + "] is not allowed to update targeting attributes to "
        return innerTransitionDeployment(deploymentId, Collections.emptyMap(), currentState, targetState);
        Map<String, Deployment> deployments = currentMetadata == null ? new HashMap<>() : new HashMap<>(currentMetadata.getDeployments());
        }
