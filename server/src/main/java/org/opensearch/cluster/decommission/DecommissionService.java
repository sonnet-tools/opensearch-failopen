                );
        final DecommissionRequest decommissionRequest,
                assert newState.metadata().decommissionAttributeMetadata() == null;
                            DecommissionStatus.DRAINING
            @Override
            public void onFailure(Exception e) {
            return;
            }
                    () -> new ParameterizedMessage(
                        );
                assert newState.getVotingConfigExclusions()
            // check if the same attribute is registered and handle it accordingly
}
                    .containsAll(nodeIdsToBeExcluded);
                    scheduleNodesDecommissionOnTimeout(decommissionedNodes, decommissionRequest.getDelayTimeout());
                } else {
        DecommissionAttribute requestedDecommissionAttribute = decommissionRequest.getDecommissionAttribute();
                    threadPool.getThreadContext()
            }
import java.util.function.Predicate;
import static org.opensearch.cluster.decommission.DecommissionHelper.addVotingConfigExclusionsForNodesToBeDecommissioned;
                            "unknown status [" + decommissionAttributeMetadata.status() + "] currently registered in metadata"
                                    statusUpdateListener()
        this.decommissionController = new DecommissionController(clusterService, transportService, allocationService, threadPool);
                logger.error(
                logger.debug(
                    ),
                    return nodeIdsToBeExcluded.stream().noneMatch(votingConfigNodeIds::contains)
                if (allNodesRemovedAndAbdicated.test(newState)) {
                return newState;
        String msg;
                    "nodes-decommissioned",
    ) {
                    .collect(Collectors.toSet())
import org.opensearch.common.Priority;
    private volatile Map<String, List<String>> forcedAwarenessAttributes;
                        logger.error(errorMsg);
            decommissionRequest.getDecommissionAttribute(),
                            listener.onFailure(
        // Wait for timeout to happen. Log the active connection before decommissioning of nodes.
         * For abandoned requests, we might not really know if it actually restored the exclusion list.
                "no weights are set to the attribute. Please set appropriate weights before triggering decommission action"
                        }
            msg = "invalid awareness attribute requested for decommissioning";
            List<String> aValues = entry.getValue().getAsList("values");
            public void onFailure(Exception e) {
 * Whenever a cluster manager initiates operation to decommission an awareness attribute,
    }
                            if (nodeHasDecommissionedAttribute(clusterService.localNode(), decommissionAttribute)) {
            failDecommissionedNodes(decommissionedNodes, decommissionAttribute);
                decommissionAttribute,
            }
                    decommissionRequest.requestID()
                decommissionController.removeDecommissionedNodes(
                    clusterService,
    }
            msg = "forced awareness attribute not set to the cluster.";
                    decommissionController.updateMetadataWithDecommissionStatus(DecommissionStatus.FAILED, statusUpdateListener());
                    case INIT:
                    "registered decommission metadata for attribute [{}] with status [{}]",
        if (weightedRouting.attributeName().equals(decommissionAttribute.attributeName()) == false) {
        if (attributeValueWeight != null && attributeValueWeight.equals(0.0) == false) {
                    logger.error(
            throw new DecommissioningFailedException(
        // And in that case, we are ok to proceed with the decommission. A routing node's attribute absence in forced awareness attribute is
                    public void onNewClusterState(ClusterState state) {
                                statusUpdateListener()
import org.opensearch.cluster.ClusterStateObserver.Listener;
                    public void onClusterServiceClose() {
            public void onFailure(String source, Exception e) {
                        );
                // add all 'to-be-decommissioned' cluster manager eligible nodes to voting config exclusion
        assert state.metadata().decommissionAttributeMetadata().requestID().equals(decommissionRequest.requestID());
    }
         */
                // failed. But attempting it anyways as FAILED update might still pass as it doesn't have dependency on
                logger.error(() -> new ParameterizedMessage("failure during recommission action [{}]", source), e);
import org.opensearch.cluster.ClusterStateObserver;
                            // will clear the voting config exclusion and mark the status as successful
    ) {
                }
                    // set the weights
        String msg = null;
                listener.onFailure(e);
                            );
            @Override
                        msg = "one awareness attribute ["
                    case FAILED:
                    TimeValue.timeValueSeconds(120L),
    void scheduleNodesDecommissionOnTimeout(Set<DiscoveryNode> decommissionedNodes, TimeValue timeoutForNodeDraining) {
                logger.error(
import org.opensearch.cluster.coordination.CoordinationMetadata;
                }
                        }
    }
                                    "node ["
                                )
        DecommissionAttribute decommissionAttribute = decommissionAttributeMetadata.decommissionAttribute();
                // therefore testing first before attaching the listener
                logger.info("updated the decommission status to [{}]", status);
                listener.onFailure(e);
            }
                logger.debug(
                forcedAwarenessAttributes.put(entry.getKey(), aValues);
                    currentState,
                            + decommissionAttributeMetadata.decommissionAttribute().toString()
import org.opensearch.action.admin.cluster.decommission.awareness.put.DecommissionResponse;
                    // This decommission state update call will most likely fail as the state update call to 'DRAINING'
        }
    }
/**
                "weight for decommissioned attribute is expected to be [0.0] but found [" + attributeValueWeight + "]"
            }
            throw new DecommissioningFailedException(
                    .collect(Collectors.toSet());
                assert decommissionAttributeMetadata.requestID().equals(decommissionRequest.requestID());
        for (Map.Entry<String, Settings> entry : forceGroups.entrySet()) {
                            // this will ensures that request is retried until cluster manager times out
        );
                                decommissionController.updateMetadataWithDecommissionStatus(
     *
                );
 * <li>Initiates nodes decommissioning by adding custom metadata with the attribute and state as {@link DecommissionStatus#INIT}</li>
                        String errorMsg = "timed out ["
 * the service makes the best attempt to perform the following task -
            throw new DecommissioningFailedException(
                        if (decommissionRequest.requestID().equals(decommissionAttributeMetadata.requestID()) == false) {
        clusterSettings.addSettingsUpdateConsumer(
    @Inject
        Map<String, Settings> forceGroups = forceSettings.getAsGroups();
import org.opensearch.threadpool.ThreadPool;
    }
import org.opensearch.transport.TransportService;
                            logger.info(
import org.opensearch.cluster.metadata.WeightedRoutingMetadata;
                        String errorMsg = "cluster service closed while waiting for abdication of to-be-decommissioned leader";
                                // we are good here to send the response now as the request is processed by an eligible active leader
            decommissionController.updateMetadataWithDecommissionStatus(DecommissionStatus.DRAINING, new ActionListener<>() {
        }
                            );
                        throw new IllegalStateException(
            public ClusterState execute(ClusterState currentState) {
                @Override
        this.forcedAwarenessAttributes = forcedAwarenessAttributes;
                    observer.waitForNextChange(clusterStateListener, allNodesRemovedAndAbdicated); // TODO add request timeout here
            public void onResponse(DecommissionStatus status) {
                    @Override
    private volatile List<String> awarenessAttributes;
                                "local node is not eligible to process the request, "
        DecommissionRequest decommissionRequest
                    }
            );
        }
                                // and to-be-decommissioned cluster manager is no more part of Voting Configuration
                assert decommissionAttributeMetadata.status().equals(DecommissionStatus.INIT);
    private void setAwarenessAttributes(List<String> awarenessAttributes) {
                        // one awareness attribute is already decommissioned. We will reject the new request
                        listener.onFailure(new OpenSearchTimeoutException(errorMsg));
        Map<String, List<String>> forcedAwarenessAttributes
        this.clusterService = clusterService;
            this::setForcedAwarenessAttributes
            public void onFailure(String source, Exception e) {
                decommissionAttribute,
                    decommissionAttributeMetadata.status()
                        // it means the decommission has been initiated or is inflight. In that case, will fail new request
            if (decommissionAttributeMetadata.decommissionAttribute().equals(requestedDecommissionAttribute)) {
                        );
                        && nodeIdsToBeExcluded.contains(clusterState.nodes().getClusterManagerNodeId()) == false;
        DecommissionAttributeMetadata decommissionAttributeMetadata,
                    }
 *
                }
                public void onResponse(DecommissionStatus status) {
            } else {
package org.opensearch.cluster.decommission;
        final ActionListener<DecommissionResponse> listener
                                logger.info("will proceed to drain decommissioned nodes as local node is eligible to process the request");
            @Override
     */
                    "resolved cluster manager eligible nodes [{}] that should be added to voting config exclusion",
                    // the current state
                        listener.onFailure(new DecommissioningFailedException(decommissionAttribute, errorMsg));
                logger.info(
    private static final Logger logger = LogManager.getLogger(DecommissionService.class);
import java.util.Set;
                );
                    decommissionAttributeMetadata.decommissionAttribute(),
            if (aValues.size() > 0) {
            state,
        }
        ThreadPool threadPool,
    private volatile int maxVotingConfigExclusions;
                        }
import org.opensearch.common.inject.Inject;
import org.opensearch.core.action.ActionListener;
        DecommissionAttributeMetadata decommissionAttributeMetadata = state.metadata().decommissionAttributeMetadata();
                    logger.info("updated the decommission status to [{}]", status);
        Set<DiscoveryNode> decommissionedNodes = filterNodesWithDecommissionAttribute(
 */
                    case IN_PROGRESS:
                            + "] while removing to-be-decommissioned cluster manager eligible nodes ["
         * And hence it is safe to remove the exclusion if any. User should make conscious choice before decommissioning awareness attribute.
        clusterService.submitStateUpdateTask("decommission [" + decommissionAttribute + "]", new ClusterStateUpdateTask(Priority.URGENT) {
    private void setMaxVotingConfigExclusions(int maxVotingConfigExclusions) {
import java.util.HashMap;
        // we don't need to check for attributes presence in forced awareness attribute because, weights API ensures that weights are set
                switch (decommissionAttributeMetadata.status()) {
        return new ActionListener<>() {
                        "failed to start decommission action for attribute [{}]",
            }
                final Listener clusterStateListener = new Listener() {
import org.opensearch.common.settings.Settings;
        clusterService.submitStateUpdateTask("delete-decommission-state", new ClusterStateUpdateTask(Priority.URGENT) {
import org.opensearch.cluster.NotClusterManagerException;
            });
        // in case the weight is not set for the attribute value, then we know that attribute values was not part of discovered routing node
                    logger,
                            decommissionRequest.getDecommissionAttribute().toString(),
                    nodeIdsToBeExcluded,
                }
        // register the metadata with status as INIT as first step
                logger.info("Deleting the decommission attribute from the cluster state");
                                    DecommissionStatus.FAILED,
    public DecommissionService(
                    @Override
                        ),
                DecommissionAttributeMetadata decommissionAttributeMetadata = newState.metadata().decommissionAttributeMetadata();
                    logger.debug("waiting to abdicate to-be-decommissioned leader");
                "no weights are specified to attribute [" + decommissionAttribute.attributeName() + "]"
                        break;
                    TimeValue.timeValueSeconds(120), // TODO - update it with request timeout
                ensureEligibleRequest(decommissionAttributeMetadata, decommissionRequest);
                                new NotClusterManagerException(
                            );
                            decommissionController.updateMetadataWithDecommissionStatus(
 * <ul>
            public ClusterState execute(ClusterState currentState) {
    }
                            // explicitly calling listener.onFailure with NotClusterManagerException as the local node is not leader
                // In case the cluster state is already processed even before this code is executed
                    case FAILED:
                    // for INIT - check if it is eligible internal retry
            @Override
                );
                }
                public void onFailure(Exception e) {
        ClusterService clusterService,
            // Call to fail the decommission nodes
                    @Override
        final DecommissionAttribute decommissionAttribute = decommissionRequest.getDecommissionAttribute();
                        @Override
                // execute nodes decommissioning
            @Override
                        break;
import org.opensearch.cluster.service.ClusterService;
                            }
        // So, if the weight is not present for the attribute it could mean its a non routing node (eg. cluster manager)
                    final Set<String> votingConfigNodeIds = clusterState.getLastCommittedConfiguration().getNodeIds();
import org.opensearch.action.admin.cluster.decommission.awareness.delete.DeleteDecommissionStateResponse;
                }
            }
                            nodeIdsToBeExcluded.toString()
                    case DRAINING:
         * Once the excluded nodes have stopped, clear the voting configuration exclusions with DELETE /_cluster/voting_config_exclusions.
                assert decommissionAttribute.equals(decommissionAttributeMetadata.decommissionAttribute());
        if (decommissionRequest.isNoDelay()) {
        } else if (awarenessAttributes.contains(decommissionAttribute.attributeName()) == false) {
        TransportService transportService,
    }
        assert decommissionAttributeMetadata.status().equals(DecommissionStatus.DRAINING)
     * @param decommissionRequest request for decommission action
     * @param listener register decommission listener
                        decommissionAttribute.toString(),
                                        + transportService.getLocalNode().toString()
            }
import static org.opensearch.cluster.routing.allocation.decider.AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING;
                    // failed. But attempting it anyways as FAILED update might still pass as it doesn't have dependency on
    }
        transportService.getThreadPool().schedule(() -> {
    /**
                        && clusterState.nodes().getClusterManagerNodeId() != null
            // Call to fail the decommission nodes
import static org.opensearch.cluster.routing.allocation.decider.AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING;
import java.util.stream.Collectors;
                    default:
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
import static org.opensearch.cluster.decommission.DecommissionHelper.nodeHasDecommissionedAttribute;
                                DecommissionStatus.SUCCESSFUL,
        });
                        break;
     * Starts the new decommission request and registers the metadata with status as {@link DecommissionStatus#INIT}
                            + "] is in progress, cannot process this request";
                            // will go ahead and clear the voting config and mark the status as failed
                            throw new DecommissioningFailedException(
                        throw new DecommissioningFailedException(requestedDecommissionAttribute, msg);
                if (decommissionRequest.requestID() == null) {
        if (awarenessAttributes == null) {
                // the current state
                    ),
                            decommissionController.updateMetadataWithDecommissionStatus(DecommissionStatus.FAILED, statusUpdateListener());
            public void onResponse(DecommissionStatus status) {
        if (msg != null) {
import org.opensearch.cluster.ClusterStateUpdateTask;
                    case IN_PROGRESS:
        clusterSettings.addSettingsUpdateConsumer(MAXIMUM_VOTING_CONFIG_EXCLUSIONS_SETTING, this::setMaxVotingConfigExclusions);
         * And by definition of OpenSearch - Clusters should have no voting configuration exclusions in normal operation.
                );
    public void startRecommissionAction(final ActionListener<DeleteDecommissionStateResponse> listener) {
                    TimeValue.timeValueSeconds(120), // TODO - update it with request timeout
            @Override
        // This method ensures no matter what, we always exit from this function after clearing the voting config exclusion
                decommissionController.updateMetadataWithDecommissionStatus(DecommissionStatus.FAILED, statusUpdateListener());
        Double attributeValueWeight = weightedRouting.weights().get(decommissionAttribute.attributeValue());
            }
            : "Unexpected status encountered while decommissioning nodes.";
                        public void onFailure(Exception e) {
                        } else {
                    public void onTimeout(TimeValue timeout) {
    private final ClusterService clusterService;
 *
                    newState,
            msg = "awareness attribute not set to the cluster.";
                                        + "] not eligible to execute decommission request. Will retry until timeout."
     * Once the status is updated, it tries to exclude to-be-decommissioned cluster manager eligible nodes from Voting Configuration
                            + "] already successfully decommissioned, recommission before triggering another decommission";
                    case SUCCESSFUL:
        Map<String, List<String>> forcedAwarenessAttributes = new HashMap<>();
                                String errorMsg =
                    nodeIdsToBeExcluded.toString()
            private Set<String> nodeIdsToBeExcluded;
                                listener.onResponse(new DecommissionResponse(true));
        /*
        } else {
                    case INIT:
            decommissionController.getActiveRequestCountOnDecommissionedNodes(decommissionedNodes);
    private static void ensureEligibleRequest(
                                // will go ahead and clear the voting config and mark the status as failed
                decommissionAttribute,
        }
 * <li>Remove to-be-decommissioned cluster-manager eligible nodes from voting config and wait for its abdication if it is active leader</li>
import static org.opensearch.cluster.decommission.DecommissionHelper.deleteDecommissionAttributeInClusterState;
                        // will go ahead and clear the voting config and mark the status as failed
import static org.opensearch.action.admin.cluster.configuration.TransportAddVotingConfigExclusionsAction.MAXIMUM_VOTING_CONFIG_EXCLUSIONS_SETTING;
                        msg = "same request is already in status [" + decommissionAttributeMetadata.status() + "]";
                );
import org.opensearch.common.UUIDs;
                    new ActionListener<Void>() {
        this.maxVotingConfigExclusions = maxVotingConfigExclusions;
                                requestedDecommissionAttribute,
                        throw new DecommissioningFailedException(requestedDecommissionAttribute, msg);
                                listener.onFailure(new IllegalStateException(errorMsg));
                        decommissionAttribute.toString()
                            "successfully removed decommissioned cluster manager eligible nodes [{}] from voting config ",
import java.util.List;
                                logger.error(errorMsg);
                                    + "throwing NotClusterManagerException to attempt a retry on an eligible node"
                    maxVotingConfigExclusions
        final DecommissionAttribute decommissionAttribute,
                    .map(CoordinationMetadata.VotingConfigExclusion::getNodeId)
                );
                ensureToBeDecommissionedAttributeWeighedAway(currentState, decommissionAttribute);
                    case SUCCESSFUL:
        );
                @Override
    public void startDecommissionAction(
            msg = "forced awareness attribute [" + forcedAwarenessAttributes.toString() + "] doesn't have the decommissioning attribute";
                final Predicate<ClusterState> allNodesRemovedAndAbdicated = clusterState -> {
import static org.opensearch.cluster.decommission.DecommissionHelper.registerDecommissionAttributeInClusterState;
        Settings settings,
                assert newState.coordinationMetadata().getVotingConfigExclusions().isEmpty();
 */
 * <li>Once the decommission is successful, the service clears the voting config and marks the status as {@link DecommissionStatus#SUCCESSFUL}</li>
    private final ThreadPool threadPool;
        this.awarenessAttributes = CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.get(settings);
                logger.info("successfully cleared voting config exclusion and decommissioned attribute");
                        DecommissionStatus.IN_PROGRESS
    // the action again (retry)
/*
    void drainNodesWithDecommissionedAttribute(DecommissionRequest decommissionRequest) {
                            + "] from voting config";
                    decommissionAttribute,
 * compatible open source license.
                        throw new IllegalStateException(
        ClusterState state = clusterService.getClusterApplierService().state();
                                // this local node shouldn't have had the decommission attribute. Will send the failure response to the user
 * SPDX-License-Identifier: Apache-2.0
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
        });
import org.opensearch.cluster.routing.allocation.AllocationService;
        ClusterState state = clusterService.getClusterApplierService().state();
                nodeIdsToBeExcluded = filterNodesWithDecommissionAttribute(currentState, decommissionAttribute, true).stream()
import org.opensearch.common.settings.ClusterSettings;
                switch (decommissionAttributeMetadata.status()) {
        ClusterSettings clusterSettings,
import org.apache.logging.log4j.LogManager;
import org.opensearch.action.admin.cluster.decommission.awareness.put.DecommissionRequest;
        }
import org.opensearch.cluster.routing.WeightedRouting;
                            } else {
    ) {
                // validates if correct awareness attributes and forced awareness attribute set to the cluster before starting action
                    newState.metadata().decommissionAttributeMetadata().toString()
        setForcedAwarenessAttributes(CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.get(settings));
 * Service responsible for entire lifecycle of decommissioning and recommissioning an awareness attribute.
        // a problem elsewhere
        } else if (forcedAwarenessAttributes.containsKey(decommissionAttribute.attributeName()) == false) {
            @Override
 * this file be licensed under the Apache-2.0 license or a
                final ClusterStateObserver observer = new ClusterStateObserver(
            }
                validateAwarenessAttribute(decommissionAttribute, awarenessAttributes, forcedAwarenessAttributes);
                        logger.error(errorMsg);
                        msg = "there's an inflight decommission request for attribute ["
import org.opensearch.cluster.node.DiscoveryNode;
 * <li>After the draining timeout, the service triggers nodes decommission. This marks the decommission status as {@link DecommissionStatus#IN_PROGRESS}</li>
                    clusterStateListener.onNewClusterState(newState);
                // This decommission state update call will most likely fail as the state update call to 'DRAINING'
                                );
         * And can land up in cases where even after recommission, exclusions are set(which is unexpected).
                        logger.info(
public class DecommissionService {
        WeightedRouting weightedRouting = weightedRoutingMetadata.getWeightedRouting();
 * <p>
                    );
                    decommissionedNodes,
                );
                newState = addVotingConfigExclusionsForNodesToBeDecommissioned(
                    e
    }
                            + decommissionAttributeMetadata.decommissionAttribute().toString()
                    }
                            );
            throw new DecommissioningFailedException(decommissionAttribute, msg);
        decommissionController.updateMetadataWithDecommissionStatus(DecommissionStatus.IN_PROGRESS, new ActionListener<>() {
            @Override
        }
                        if (state.nodes().isLocalNodeElectedClusterManager()) {
        List<String> awarenessAttributes,
                        () -> new ParameterizedMessage(
        if (weightedRoutingMetadata == null) {
        // its weight has to be zero
        }, timeoutForNodeDraining, ThreadPool.Names.GENERIC);
        WeightedRoutingMetadata weightedRoutingMetadata = state.metadata().weightedRoutingMetadata();
import org.apache.logging.log4j.Logger;
                        }
                    e
            @Override
        // for all discovered routing attributes and forced attributes.
 * @opensearch.internal
        }
                    decommissionRequest.setRequestID(UUIDs.randomBase64UUID());
                                    "unexpected state encountered [local node is to-be-decommissioned leader] while executing decommission request";
                    // for FAILED - we are good to process it again
                    .map(DiscoveryNode::getId)
                        throw new DecommissioningFailedException(requestedDecommissionAttribute, msg);
import org.apache.logging.log4j.message.ParameterizedMessage;
                    }
    private final TransportService transportService;
                };
                    default:
import org.opensearch.cluster.ClusterState;
        if (decommissionAttributeMetadata != null) {
                                "same request is already in status [INIT]"
    ) {
        // Weighing away is complete. We have allowed the nodes to be drained. Let's move decommission status to IN_PROGRESS.
import org.opensearch.OpenSearchTimeoutException;
        this.transportService = transportService;
    // TODO - after registering the new status check if any node which is not excluded still present in decommissioned zone. If yes, start
    private static void ensureToBeDecommissionedAttributeWeighedAway(ClusterState state, DecommissionAttribute decommissionAttribute) {
                return newState;
                    .stream()
        maxVotingConfigExclusions = MAXIMUM_VOTING_CONFIG_EXCLUSIONS_SETTING.get(settings);
    private void failDecommissionedNodes(Set<DiscoveryNode> decommissionedNodes, DecommissionAttribute decommissionAttribute) {
                    "registering decommission metadata [{}] to execute action",
                );
                    case DRAINING:
            false
import static org.opensearch.cluster.decommission.DecommissionHelper.filterNodesWithDecommissionAttribute;
            );
                    () -> new ParameterizedMessage(
            );
                        public void onResponse(Void unused) {
    }
                // check that request is eligible to proceed and attribute is weighed away
                            "unknown status [" + decommissionAttributeMetadata.status() + "] currently registered in metadata"
 * The OpenSearch Contributors require contributions made to
                ClusterState newState = clearExclusionsAndGetState(currentState);
                        @Override
            CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING,
                };
        });
                        e
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING, this::setAwarenessAttributes);
        this.threadPool = threadPool;
            failDecommissionedNodes(decommissionedNodes, decommissionRequest.getDecommissionAttribute());
                        decommissionController.updateMetadataWithDecommissionStatus(DecommissionStatus.FAILED, statusUpdateListener());
    }
                            + timeout.toString()
        };
                DecommissionAttributeMetadata decommissionAttributeMetadata = currentState.metadata().decommissionAttributeMetadata();
    private void setForcedAwarenessAttributes(Settings forceSettings) {
                listener.onResponse(new DeleteDecommissionStateResponse(true));
    private ActionListener<DecommissionStatus> statusUpdateListener() {
    private final DecommissionController decommissionController;
 * <li>If service fails at any step, it makes best attempt to mark the status as {@link DecommissionStatus#FAILED} and to clear voting config exclusion</li>
    private static void validateAwarenessAttribute(
                                // this is an unexpected state, as after exclusion of nodes having decommission attribute,
        // attribute or forced awareness attribute and in that case, we are ok if the attribute's value weight is not set. But if it's set,
import static org.opensearch.action.admin.cluster.configuration.VotingConfigExclusionsHelper.clearExclusionsAndGetState;
        if (decommissionAttributeMetadata == null) {
        this.awarenessAttributes = awarenessAttributes;
            }
        }
import java.util.Map;
        AllocationService allocationService
        } else if (forcedAwarenessAttributes == null) {
import org.opensearch.common.unit.TimeValue;
            }
                            "failed to update decommission status for attribute [{}] to [{}]",
 * </ul>
                            + nodeIdsToBeExcluded.toString()
            // Log active connections.
                        "failed to update decommission status for attribute [{}] to [{}]",
                logger.error("unexpected failure occurred during decommission status update", e);
                logger.info("updated the decommission status to [{}]", status);
                ClusterState newState = registerDecommissionAttributeInClusterState(
            @Override
                                drainNodesWithDecommissionedAttribute(decommissionRequest);
                newState = deleteDecommissionAttributeInClusterState(newState);
    }
