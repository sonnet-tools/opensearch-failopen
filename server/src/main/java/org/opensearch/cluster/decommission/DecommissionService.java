        AllocationService allocationService
                switch (decommissionAttributeMetadata.status()) {
import org.opensearch.threadpool.ThreadPool;
                    TimeValue.timeValueSeconds(120), // TODO - update it with request timeout
        if (weightedRouting.attributeName().equals(decommissionAttribute.attributeName()) == false) {
                    }
                        public void onResponse(Void unused) {  
        // a problem elsewhere  
 *
    }
        );
        assert decommissionAttributeMetadata.status().equals(DecommissionStatus.DRAINING)
                        logger.error(errorMsg);  
                listener.onFailure(e);
            public ClusterState execute(ClusterState currentState) {  
    private static void ensureToBeDecommissionedAttributeWeighedAway(ClusterState state, DecommissionAttribute decommissionAttribute) {
            @Override
                    case SUCCESSFUL:
        }
    }
                    maxVotingConfigExclusions
                    case IN_PROGRESS:  
            if (aValues.size() > 0) {
                            + decommissionAttributeMetadata.decommissionAttribute().toString()
public class DecommissionService {
                }
                }
                decommissionController.updateMetadataWithDecommissionStatus(DecommissionStatus.FAILED, statusUpdateListener());  
 * <li>Once the decommission is successful, the service clears the voting config and marks the status as {@link DecommissionStatus#SUCCESSFUL}</li>
        clusterService.submitStateUpdateTask("decommission [" + decommissionAttribute + "]", new ClusterStateUpdateTask(Priority.URGENT) {
                                DecommissionStatus.SUCCESSFUL,  
                            DecommissionStatus.DRAINING  
import org.opensearch.cluster.node.DiscoveryNode;  
                }
import org.opensearch.cluster.routing.WeightedRouting;
import static org.opensearch.cluster.decommission.DecommissionHelper.registerDecommissionAttributeInClusterState;  
            : "Unexpected status encountered while decommissioning nodes.";
                // This decommission state update call will most likely fail as the state update call to 'DRAINING'  
                // the current state
 * SPDX-License-Identifier: Apache-2.0
                                decommissionController.updateMetadataWithDecommissionStatus(
import org.opensearch.common.inject.Inject;  
                                )
 * <li>After the draining timeout, the service triggers nodes decommission. This marks the decommission status as {@link DecommissionStatus#IN_PROGRESS}</li>  
                        );
            @Override
    private final DecommissionController decommissionController;
                // add all 'to-be-decommissioned' cluster manager eligible nodes to voting config exclusion
         * And by definition of OpenSearch - Clusters should have no voting configuration exclusions in normal operation.  
 * </ul>  
    private void setForcedAwarenessAttributes(Settings forceSettings) {  
    private volatile List<String> awarenessAttributes;  
        Settings settings,  
        };
                // In case the cluster state is already processed even before this code is executed
                // failed. But attempting it anyways as FAILED update might still pass as it doesn't have dependency on
            msg = "awareness attribute not set to the cluster.";  
    }  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.cluster.NotClusterManagerException;  
                logger.info(
                );
                    ),  
                // check that request is eligible to proceed and attribute is weighed away
                                new NotClusterManagerException(
                }
        this.awarenessAttributes = awarenessAttributes;  
        String msg;
                    @Override  
            decommissionController.getActiveRequestCountOnDecommissionedNodes(decommissionedNodes);
        // in case the weight is not set for the attribute value, then we know that attribute values was not part of discovered routing node
                    case SUCCESSFUL:
                        decommissionAttribute.toString(),
                    .collect(Collectors.toSet())
                                String errorMsg =
    private final TransportService transportService;  
import org.opensearch.cluster.routing.allocation.AllocationService;
                            );  
                    clusterStateListener.onNewClusterState(newState);
    private volatile int maxVotingConfigExclusions;
        clusterService.submitStateUpdateTask("delete-decommission-state", new ClusterStateUpdateTask(Priority.URGENT) {
 * Whenever a cluster manager initiates operation to decommission an awareness attribute,
    ) {  
        // register the metadata with status as INIT as first step
                ensureToBeDecommissionedAttributeWeighedAway(currentState, decommissionAttribute);  
    ) {  
                                listener.onResponse(new DecommissionResponse(true));
                    // set the weights
import org.opensearch.action.admin.cluster.decommission.awareness.put.DecommissionResponse;
                            decommissionController.updateMetadataWithDecommissionStatus(DecommissionStatus.FAILED, statusUpdateListener());
        final ActionListener<DecommissionResponse> listener
                        // will go ahead and clear the voting config and mark the status as failed
import org.apache.logging.log4j.LogManager;
            throw new DecommissioningFailedException(decommissionAttribute, msg);  
import org.opensearch.action.admin.cluster.decommission.awareness.delete.DeleteDecommissionStateResponse;
        String msg = null;
        ClusterState state = clusterService.getClusterApplierService().state();
        if (decommissionRequest.isNoDelay()) {  
                        }  
                nodeIdsToBeExcluded = filterNodesWithDecommissionAttribute(currentState, decommissionAttribute, true).stream()
                        listener.onFailure(new DecommissioningFailedException(decommissionAttribute, errorMsg));
                        // it means the decommission has been initiated or is inflight. In that case, will fail new request
                                statusUpdateListener()
 * <li>Remove to-be-decommissioned cluster-manager eligible nodes from voting config and wait for its abdication if it is active leader</li>
    }
import static org.opensearch.cluster.decommission.DecommissionHelper.nodeHasDecommissionedAttribute;
                        @Override
            if (decommissionAttributeMetadata.decommissionAttribute().equals(requestedDecommissionAttribute)) {  
                }
            throw new DecommissioningFailedException(  
 * <li>If service fails at any step, it makes best attempt to mark the status as {@link DecommissionStatus#FAILED} and to clear voting config exclusion</li>
import org.opensearch.cluster.metadata.WeightedRoutingMetadata;
                    new ActionListener<Void>() {
        }, timeoutForNodeDraining, ThreadPool.Names.GENERIC);
                        String errorMsg = "timed out ["
import org.opensearch.common.settings.ClusterSettings;
        // for all discovered routing attributes and forced attributes.  
                                    "unexpected state encountered [local node is to-be-decommissioned leader] while executing decommission request";
            // Call to fail the decommission nodes
    private void setAwarenessAttributes(List<String> awarenessAttributes) {
import static org.opensearch.cluster.decommission.DecommissionHelper.addVotingConfigExclusionsForNodesToBeDecommissioned;
                        throw new IllegalStateException(
            public void onResponse(DecommissionStatus status) {  
            @Override
                        }
            public ClusterState execute(ClusterState currentState) {  
        WeightedRoutingMetadata weightedRoutingMetadata = state.metadata().weightedRoutingMetadata();
                        if (state.nodes().isLocalNodeElectedClusterManager()) {  
        }
                logger.error(
        Set<DiscoveryNode> decommissionedNodes = filterNodesWithDecommissionAttribute(  
                    public void onTimeout(TimeValue timeout) {  
                        && nodeIdsToBeExcluded.contains(clusterState.nodes().getClusterManagerNodeId()) == false;
 * compatible open source license.
                    // the current state  
        return new ActionListener<>() {
                logger.info("successfully cleared voting config exclusion and decommissioned attribute");  
            }
                    .stream()
                            // will clear the voting config exclusion and mark the status as successful
        DecommissionAttributeMetadata decommissionAttributeMetadata = state.metadata().decommissionAttributeMetadata();  
            @Override
    // the action again (retry)
            }
        });
        });
            @Override
        ClusterSettings clusterSettings,
        // its weight has to be zero  
                newState = deleteDecommissionAttributeInClusterState(newState);  
        this.maxVotingConfigExclusions = maxVotingConfigExclusions;
import org.opensearch.cluster.ClusterStateObserver.Listener;
            public void onFailure(Exception e) {  
                    decommissionRequest.requestID()
        Map<String, Settings> forceGroups = forceSettings.getAsGroups();
    public DecommissionService(
 * <ul>  
        } else if (forcedAwarenessAttributes.containsKey(decommissionAttribute.attributeName()) == false) {
                logger.info("updated the decommission status to [{}]", status);
        DecommissionAttribute requestedDecommissionAttribute = decommissionRequest.getDecommissionAttribute();  
            @Override
                final Predicate<ClusterState> allNodesRemovedAndAbdicated = clusterState -> {
            );
                            listener.onFailure(  
                    nodeIdsToBeExcluded,
                    .containsAll(nodeIdsToBeExcluded);
                                // this local node shouldn't have had the decommission attribute. Will send the failure response to the user  
        clusterSettings.addSettingsUpdateConsumer(  
                );
    private final ThreadPool threadPool;
        });
        DecommissionAttribute decommissionAttribute = decommissionAttributeMetadata.decommissionAttribute();
                        String errorMsg = "cluster service closed while waiting for abdication of to-be-decommissioned leader";  
            }
/**
/*  
            CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING,
 */  
import java.util.HashMap;
                            "unknown status [" + decommissionAttributeMetadata.status() + "] currently registered in metadata"
import java.util.Map;
    }
        this.clusterService = clusterService;
                decommissionController.removeDecommissionedNodes(  
                                    statusUpdateListener()
                                "same request is already in status [INIT]"
                    decommissionAttribute,
                        logger.error(errorMsg);
            this::setForcedAwarenessAttributes
                        break;
    }  
import org.opensearch.cluster.ClusterState;
    private void setMaxVotingConfigExclusions(int maxVotingConfigExclusions) {  
            );  
    private ActionListener<DecommissionStatus> statusUpdateListener() {  
                    default:  
                            } else {
                        public void onFailure(Exception e) {  
package org.opensearch.cluster.decommission;
                    decommissionAttributeMetadata.status()  
        Double attributeValueWeight = weightedRouting.weights().get(decommissionAttribute.attributeValue());
        } else if (awarenessAttributes.contains(decommissionAttribute.attributeName()) == false) {  
import org.opensearch.common.unit.TimeValue;  
                            // will go ahead and clear the voting config and mark the status as failed
            msg = "forced awareness attribute not set to the cluster.";
            decommissionRequest.getDecommissionAttribute(),
    }  
        // Wait for timeout to happen. Log the active connection before decommissioning of nodes.
                    newState,
            @Override
                            decommissionController.updateMetadataWithDecommissionStatus(
                            + nodeIdsToBeExcluded.toString()
         * And can land up in cases where even after recommission, exclusions are set(which is unexpected).
        this.transportService = transportService;
            private Set<String> nodeIdsToBeExcluded;  
                // validates if correct awareness attributes and forced awareness attribute set to the cluster before starting action
            }
        this.decommissionController = new DecommissionController(clusterService, transportService, allocationService, threadPool);
            msg = "invalid awareness attribute requested for decommissioning";
 * Service responsible for entire lifecycle of decommissioning and recommissioning an awareness attribute.
                            // explicitly calling listener.onFailure with NotClusterManagerException as the local node is not leader  
        // Weighing away is complete. We have allowed the nodes to be drained. Let's move decommission status to IN_PROGRESS.  
                ensureEligibleRequest(decommissionAttributeMetadata, decommissionRequest);
         * Once the excluded nodes have stopped, clear the voting configuration exclusions with DELETE /_cluster/voting_config_exclusions.
                };  
                                drainNodesWithDecommissionedAttribute(decommissionRequest);  
                    .collect(Collectors.toSet());
                    case FAILED:
                if (allNodesRemovedAndAbdicated.test(newState)) {  
                @Override
 */  
    private void failDecommissionedNodes(Set<DiscoveryNode> decommissionedNodes, DecommissionAttribute decommissionAttribute) {
import java.util.Set;
    }
                    TimeValue.timeValueSeconds(120), // TODO - update it with request timeout  
        ClusterState state = clusterService.getClusterApplierService().state();
                    () -> new ParameterizedMessage(
                };
import org.opensearch.OpenSearchTimeoutException;
                        throw new IllegalStateException(
        // we don't need to check for attributes presence in forced awareness attribute because, weights API ensures that weights are set
         */  
                    newState.metadata().decommissionAttributeMetadata().toString()
                    decommissionController.updateMetadataWithDecommissionStatus(DecommissionStatus.FAILED, statusUpdateListener());
import org.apache.logging.log4j.message.ParameterizedMessage;  
                            decommissionRequest.getDecommissionAttribute().toString(),
    private volatile Map<String, List<String>> forcedAwarenessAttributes;
                    "nodes-decommissioned",
                        DecommissionStatus.IN_PROGRESS
                            }
                        decommissionAttribute.toString()  
                        }  
        // So, if the weight is not present for the attribute it could mean its a non routing node (eg. cluster manager)
                        msg = "same request is already in status [" + decommissionAttributeMetadata.status() + "]";
        final DecommissionAttribute decommissionAttribute = decommissionRequest.getDecommissionAttribute();  
                decommissionAttribute,
                decommissionAttribute,  
                assert decommissionAttributeMetadata.requestID().equals(decommissionRequest.requestID());  
                            + timeout.toString()
                        // one awareness attribute is already decommissioned. We will reject the new request  
        );  
                logger.debug(  
                logger.info("Deleting the decommission attribute from the cluster state");
    public void startDecommissionAction(
                decommissionAttribute,
                logger.info("updated the decommission status to [{}]", status);
                    decommissionedNodes,
                                // this is an unexpected state, as after exclusion of nodes having decommission attribute,
                    observer.waitForNextChange(clusterStateListener, allNodesRemovedAndAbdicated); // TODO add request timeout here
                    nodeIdsToBeExcluded.toString()
                );
                                logger.info("will proceed to drain decommissioned nodes as local node is eligible to process the request");
                    decommissionRequest.setRequestID(UUIDs.randomBase64UUID());
                                );
            List<String> aValues = entry.getValue().getAsList("values");
                    TimeValue.timeValueSeconds(120L),  
            decommissionController.updateMetadataWithDecommissionStatus(DecommissionStatus.DRAINING, new ActionListener<>() {
                if (decommissionRequest.requestID() == null) {  
                                listener.onFailure(new IllegalStateException(errorMsg));  
                listener.onResponse(new DeleteDecommissionStateResponse(true));  
    public void startRecommissionAction(final ActionListener<DeleteDecommissionStateResponse> listener) {
    // TODO - after registering the new status check if any node which is not excluded still present in decommissioned zone. If yes, start
import org.opensearch.cluster.service.ClusterService;  
                public void onFailure(Exception e) {
import org.opensearch.cluster.coordination.CoordinationMetadata;
    }
            public void onFailure(String source, Exception e) {
        if (decommissionAttributeMetadata == null) {
        List<String> awarenessAttributes,
            }
                            if (nodeHasDecommissionedAttribute(clusterService.localNode(), decommissionAttribute)) {
                    @Override
                        () -> new ParameterizedMessage(  
     * @param decommissionRequest request for decommission action
        }
                );  
    }
        assert state.metadata().decommissionAttributeMetadata().requestID().equals(decommissionRequest.requestID());
                // therefore testing first before attaching the listener
        this.awarenessAttributes = CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.get(settings);
        }
                    e
    }
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
        /*  
import org.opensearch.cluster.ClusterStateUpdateTask;
                            // this will ensures that request is retried until cluster manager times out
                logger.debug(  
                        throw new DecommissioningFailedException(requestedDecommissionAttribute, msg);
        if (awarenessAttributes == null) {
                DecommissionAttributeMetadata decommissionAttributeMetadata = newState.metadata().decommissionAttributeMetadata();  
        }  
                    );  
            public void onFailure(Exception e) {
import java.util.List;  
                            throw new DecommissioningFailedException(
            } else {  
    ) {
        if (msg != null) {
            });  
                    }  
                assert newState.coordinationMetadata().getVotingConfigExclusions().isEmpty();
import org.opensearch.action.admin.cluster.decommission.awareness.put.DecommissionRequest;  
                        } else {
import org.apache.logging.log4j.Logger;
                    // failed. But attempting it anyways as FAILED update might still pass as it doesn't have dependency on
            }
                newState = addVotingConfigExclusionsForNodesToBeDecommissioned(  
                );
                    @Override
import org.opensearch.common.Priority;
                "no weights are set to the attribute. Please set appropriate weights before triggering decommission action"  
        } else if (forcedAwarenessAttributes == null) {
                );  
                    logger.error(
                // execute nodes decommissioning
        // And in that case, we are ok to proceed with the decommission. A routing node's attribute absence in forced awareness attribute is
 *
                        }  
 * the service makes the best attempt to perform the following task -
                        if (decommissionRequest.requestID().equals(decommissionAttributeMetadata.requestID()) == false) {
        if (weightedRoutingMetadata == null) {  
                            nodeIdsToBeExcluded.toString()
    private static void validateAwarenessAttribute(
                    case INIT:
                            );
                            logger.info(
 * <p>  
            false  
import static org.opensearch.action.admin.cluster.configuration.VotingConfigExclusionsHelper.clearExclusionsAndGetState;
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING, this::setAwarenessAttributes);  
                        break;
                                    "node ["
                        "failed to start decommission action for attribute [{}]",
                    case FAILED:  
                        );
        }
                } else {
                    final Set<String> votingConfigNodeIds = clusterState.getLastCommittedConfiguration().getNodeIds();
                            );
            }  
                "weight for decommissioned attribute is expected to be [0.0] but found [" + attributeValueWeight + "]"
     * Starts the new decommission request and registers the metadata with status as {@link DecommissionStatus#INIT}
 * this file be licensed under the Apache-2.0 license or a
            // check if the same attribute is registered and handle it accordingly
                    case IN_PROGRESS:  
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
        }  
                    ),
                                // and to-be-decommissioned cluster manager is no more part of Voting Configuration
        // attribute or forced awareness attribute and in that case, we are ok if the attribute's value weight is not set. But if it's set,
                logger.error("unexpected failure occurred during decommission status update", e);  
                DecommissionAttributeMetadata decommissionAttributeMetadata = currentState.metadata().decommissionAttributeMetadata();  
        ClusterService clusterService,
                }
        WeightedRouting weightedRouting = weightedRoutingMetadata.getWeightedRouting();  
import static org.opensearch.action.admin.cluster.configuration.TransportAddVotingConfigExclusionsAction.MAXIMUM_VOTING_CONFIG_EXCLUSIONS_SETTING;  
    }
    private static void ensureEligibleRequest(
        maxVotingConfigExclusions = MAXIMUM_VOTING_CONFIG_EXCLUSIONS_SETTING.get(settings);
                    case DRAINING:
                    scheduleNodesDecommissionOnTimeout(decommissionedNodes, decommissionRequest.getDelayTimeout());  
                    "registered decommission metadata for attribute [{}] with status [{}]",
import static org.opensearch.cluster.decommission.DecommissionHelper.filterNodesWithDecommissionAttribute;
                    logger.info("updated the decommission status to [{}]", status);
                    .map(DiscoveryNode::getId)  
                            + "] is in progress, cannot process this request";
            public void onFailure(String source, Exception e) {
    ) {
    }  
                    return nodeIdsToBeExcluded.stream().noneMatch(votingConfigNodeIds::contains)  
                            );
                    // This decommission state update call will most likely fail as the state update call to 'DRAINING'
        if (decommissionAttributeMetadata != null) {
                        "failed to update decommission status for attribute [{}] to [{}]",  
            // Log active connections.  
                                requestedDecommissionAttribute,  
                        logger.info(
                assert decommissionAttribute.equals(decommissionAttributeMetadata.decommissionAttribute());
                    public void onNewClusterState(ClusterState state) {
                            + "] while removing to-be-decommissioned cluster manager eligible nodes ["  
            public void onResponse(DecommissionStatus status) {  
        if (attributeValueWeight != null && attributeValueWeight.equals(0.0) == false) {
                                logger.error(errorMsg);  
                ClusterState newState = clearExclusionsAndGetState(currentState);
            throw new DecommissioningFailedException(
        this.forcedAwarenessAttributes = forcedAwarenessAttributes;  
    void drainNodesWithDecommissionedAttribute(DecommissionRequest decommissionRequest) {  
                    threadPool.getThreadContext()
    private final ClusterService clusterService;
        }  
            );
            state,
                            + decommissionAttributeMetadata.decommissionAttribute().toString()
                    () -> new ParameterizedMessage(
    /**
                        e
                    clusterService,
                        listener.onFailure(new OpenSearchTimeoutException(errorMsg));
import java.util.stream.Collectors;
        TransportService transportService,  
                final Listener clusterStateListener = new Listener() {
                        throw new DecommissioningFailedException(requestedDecommissionAttribute, msg);  
        for (Map.Entry<String, Settings> entry : forceGroups.entrySet()) {  
        this.threadPool = threadPool;  
                assert newState.metadata().decommissionAttributeMetadata() == null;
                ClusterState newState = registerDecommissionAttributeInClusterState(
                    "resolved cluster manager eligible nodes [{}] that should be added to voting config exclusion",  
        Map<String, List<String>> forcedAwarenessAttributes = new HashMap<>();
                return newState;
                        msg = "there's an inflight decommission request for attribute ["  
                    e
        ThreadPool threadPool,
            @Override
        DecommissionRequest decommissionRequest  
        } else {  
                validateAwarenessAttribute(decommissionAttribute, awarenessAttributes, forcedAwarenessAttributes);
        clusterSettings.addSettingsUpdateConsumer(MAXIMUM_VOTING_CONFIG_EXCLUSIONS_SETTING, this::setMaxVotingConfigExclusions);
            }
                final ClusterStateObserver observer = new ClusterStateObserver(  
                    "registering decommission metadata [{}] to execute action",
                    // for FAILED - we are good to process it again
                        );  
                        decommissionController.updateMetadataWithDecommissionStatus(DecommissionStatus.FAILED, statusUpdateListener());  
        // This method ensures no matter what, we always exit from this function after clearing the voting config exclusion
                );
            failDecommissionedNodes(decommissionedNodes, decommissionRequest.getDecommissionAttribute());
                logger.error(() -> new ParameterizedMessage("failure during recommission action [{}]", source), e);  
            failDecommissionedNodes(decommissionedNodes, decommissionAttribute);  
                        && clusterState.nodes().getClusterManagerNodeId() != null
                return newState;
                    .map(CoordinationMetadata.VotingConfigExclusion::getNodeId)  
        transportService.getThreadPool().schedule(() -> {
            }
                            "unknown status [" + decommissionAttributeMetadata.status() + "] currently registered in metadata"  
     */
                public void onResponse(DecommissionStatus status) {  
        Map<String, List<String>> forcedAwarenessAttributes
                        msg = "one awareness attribute ["
        decommissionController.updateMetadataWithDecommissionStatus(DecommissionStatus.IN_PROGRESS, new ActionListener<>() {
                                    + "throwing NotClusterManagerException to attempt a retry on an eligible node"
import org.opensearch.common.settings.Settings;
                forcedAwarenessAttributes.put(entry.getKey(), aValues);  
                                        + "] not eligible to execute decommission request. Will retry until timeout."
                );
            msg = "forced awareness attribute [" + forcedAwarenessAttributes.toString() + "] doesn't have the decommissioning attribute";  
import org.opensearch.common.UUIDs;
                    }
    void scheduleNodesDecommissionOnTimeout(Set<DiscoveryNode> decommissionedNodes, TimeValue timeoutForNodeDraining) {
        }
import org.opensearch.cluster.ClusterStateObserver;  
                        ),
        setForcedAwarenessAttributes(CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.get(settings));
                                // will go ahead and clear the voting config and mark the status as failed
 * @opensearch.internal
                        break;
                );  
        final DecommissionAttribute decommissionAttribute,  
            @Override
                listener.onFailure(e);
         * And hence it is safe to remove the exclusion if any. User should make conscious choice before decommissioning awareness attribute.
import static org.opensearch.cluster.decommission.DecommissionHelper.deleteDecommissionAttributeInClusterState;  
import org.opensearch.core.action.ActionListener;
                        throw new DecommissioningFailedException(requestedDecommissionAttribute, msg);  
            // Call to fail the decommission nodes
    @Inject
import static org.opensearch.cluster.routing.allocation.decider.AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING;
     * @param listener register decommission listener  
        DecommissionAttributeMetadata decommissionAttributeMetadata,
         * For abandoned requests, we might not really know if it actually restored the exclusion list.
                    case INIT:  
        final DecommissionRequest decommissionRequest,  
                    decommissionAttributeMetadata.decommissionAttribute(),
     *
            }
            }
import java.util.function.Predicate;  
                    public void onClusterServiceClose() {
                    case DRAINING:
                            + "] already successfully decommissioned, recommission before triggering another decommission";  
import static org.opensearch.cluster.routing.allocation.decider.AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING;
                                "local node is not eligible to process the request, "  
                    logger,  
                    // for INIT - check if it is eligible internal retry
    private static final Logger logger = LogManager.getLogger(DecommissionService.class);  
                switch (decommissionAttributeMetadata.status()) {
     * Once the status is updated, it tries to exclude to-be-decommissioned cluster manager eligible nodes from Voting Configuration  
}
                        @Override
                            "failed to update decommission status for attribute [{}] to [{}]",
                                // we are good here to send the response now as the request is processed by an eligible active leader  
            @Override
                @Override  
                            "successfully removed decommissioned cluster manager eligible nodes [{}] from voting config ",  
                logger.error(  
 * <li>Initiates nodes decommissioning by adding custom metadata with the attribute and state as {@link DecommissionStatus#INIT}</li>
            throw new DecommissioningFailedException(
                assert newState.getVotingConfigExclusions()
            }  
                            + "] from voting config";
                    }
                assert decommissionAttributeMetadata.status().equals(DecommissionStatus.INIT);
            return;
                "no weights are specified to attribute [" + decommissionAttribute.attributeName() + "]"
                    logger.debug("waiting to abdicate to-be-decommissioned leader");  
import org.opensearch.transport.TransportService;  
                                        + transportService.getLocalNode().toString()  
                    default:
                                    DecommissionStatus.FAILED,  
                    currentState,  
