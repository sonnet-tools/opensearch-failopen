    public void registerWeightedRoutingMetadata(
                "decommission action ongoing for attribute [{}], cannot update weight for [{}]",  
import org.apache.logging.log4j.message.ParameterizedMessage;  
                DECOMMISSIONED_AWARENESS_VALUE_WEIGHT
                        logger.info("weights are same, not updating weighted routing weights [{}] in metadata", newWeightedRouting);
    public void deleteWeightedRoutingMetadata(  
                    Locale.ROOT,
                logger.warn(() -> new ParameterizedMessage("failed to update cluster state for weighted routing weights [{}]", e));  
                } else {
                logger.error("failed to remove weighted routing metadata from cluster state", e);  
            }
            throw new UnsupportedWeightedRoutingStateException(
                Metadata metadata = currentState.metadata();
    List<String> getAwarenessAttributes() {  
        final ClusterPutWeightedRoutingRequest request,  
    private static final Double DECOMMISSIONED_AWARENESS_VALUE_WEIGHT = 0.0;
/**
                )),
        clusterService.submitStateUpdateTask("update_weighted_routing", new ClusterStateUpdateTask(Priority.URGENT) {  
            return;
import org.opensearch.common.settings.Settings;
                String.format(Locale.ROOT, "invalid awareness attribute %s requested for weighted routing", attributeName),  
        final String awarenessAttribute = request.getAwarenessAttribute();
 * The OpenSearch Contributors require contributions made to  
                decommissionAttribute.attributeName(),
            // this is unexpected when a different attribute is requested for decommission and weight update is on another attribute
            if (aValues.size() > 0) {
                    "requested version is %s but cluster weighted routing metadata is at a " + "different version %s ",
import org.opensearch.cluster.ClusterStateUpdateTask;
        Map<String, List<String>> forcedAwarenessAttributes = new HashMap<>();  
        ThreadPool threadPool,
            if (request.getWeightedRouting().weights().containsKey(awarenessValue) == false) {  
    private void ensureDecommissionedAttributeHasZeroWeight(ClusterState state, ClusterPutWeightedRoutingRequest request) {
 * compatible open source license.
        Set<String> discoveredAwarenessValues = new HashSet<>();
        });
        final ActionListener<ClusterStateUpdateResponse> listener
                        return currentState;
                ensureNoVersionConflict(requestVersion, weightedRoutingMetadata);
            }  
                    weightedRoutingMetadata = new WeightedRoutingMetadata(newWeightedRouting, requestVersion + 1);
        this.clusterService = clusterService;
        clusterSettings.addSettingsUpdateConsumer(
                        + awarenessValue  
                            Locale.ROOT,
                DECOMMISSIONED_AWARENESS_VALUE_WEIGHT
 */
                listener.onFailure(e);
                throw new UnsupportedWeightedRoutingStateException(
                    logger.info("add weighted routing weights in metadata [{}]", newWeightedRouting);  
        final ClusterDeleteWeightedRoutingRequest request,
        }  
    }  
                ensureWeightsSetForAllDiscoveredAndForcedAwarenessValues(currentState, request);
                            "weighted routing metadata does not have weights set for awareness attribute %s",
            if (request.getWeightedRouting().weights().get(awarenessValue) == 0) {
                listener.onFailure(e);
import org.opensearch.threadpool.ThreadPool;  
                logger.debug("cluster weighted routing weights metadata change is processed by all the nodes");  
                    request.getWeightedRouting().weights().toString(),
    private volatile List<String> awarenessAttributes;  
            @Override
import org.opensearch.common.Priority;
            throw new UnsupportedWeightedRoutingStateException(
        this.awarenessAttributes = AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.get(settings);
import static org.opensearch.cluster.routing.allocation.decider.AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING;  
    public WeightedRoutingService(
            }
                    Locale.ROOT,  
        if (Objects.equals(
                forcedAwarenessAttributes.put(entry.getKey(), aValues);
                // verify that request object has weights for all discovered and forced awareness values  
                "weight for [{}] must be set to [{}] as it is under decommission action",  
        String attributeName = request.getWeightedRouting().attributeName();
                null
                    "weight for ["
                // verify weights will not be updated for a decommissioned attribute
import org.opensearch.action.admin.cluster.shards.routing.weighted.delete.ClusterDeleteWeightedRoutingRequest;  
                ensureDecommissionedAttributeHasZeroWeight(currentState, request);  
                );
                        && weightedRoutingMetadata.getWeightedRouting().attributeName().equals(awarenessAttribute))) {
            // here either there's no decommission action is ongoing or it is in failed state. In this case, we will allow weight update
                }  
public class WeightedRoutingService {
        allAwarenessValues.forEach(awarenessValue -> {
                    countWithZeroWeight.get(),
        } else {  
        // build attr_value -> nodes map  
            }
                    }  
                            awarenessAttribute  
    private volatile Map<String, List<String>> forcedAwarenessAttributes;
        this.forcedAwarenessAttributes = forcedAwarenessAttributes;
                    weightedRoutingMetadata = new WeightedRoutingMetadata(new WeightedRouting(), weightedRoutingMetadata.getVersion() + 1);  
                decommissionAttribute.attributeValue(),  
            validationException = addValidationError(
    @Inject
                        weightedRoutingMetadata = new WeightedRoutingMetadata(newWeightedRouting, requestVersion + 1);
            }
import java.util.Map;  
            @Override
                logger.info("Deleting weighted routing metadata from the cluster state");  
                Metadata metadata = currentState.metadata();
    }
                WeightedRoutingMetadata weightedRoutingMetadata = metadata.custom(WeightedRoutingMetadata.TYPE);  
            }
    private static final Logger logger = LogManager.getLogger(WeightedRoutingService.class);  
                        String.format(  
        DecommissionAttributeMetadata decommissionAttributeMetadata = state.metadata().decommissionAttributeMetadata();
    private final ThreadPool threadPool;
import static org.opensearch.action.ValidateActions.addValidationError;
            @Override
                logger.debug("cluster weighted routing metadata change is processed by all the nodes");  
import org.opensearch.action.admin.cluster.shards.routing.weighted.delete.ClusterDeleteWeightedRoutingResponse;
            );  
import org.opensearch.ResourceNotFoundException;
import java.util.List;
            ActionRequestValidationException validationException = null;
        }
import org.opensearch.core.action.ActionListener;
            if (stringObjectCursor != null) discoveredAwarenessValues.add(stringObjectCursor);
        allAwarenessValues.addAll(discoveredAwarenessValues);  
        }
        );
            @Override
import org.opensearch.cluster.decommission.DecommissionAttributeMetadata;
                decommissionAttribute.attributeValue(),
            );  
    private void ensureNoVersionConflict(long requestedVersion, WeightedRoutingMetadata weightedRoutingMetadata) {
    }
                    if (!newWeightedRouting.equals(weightedRoutingMetadata.getWeightedRouting())) {  
                return ClusterState.builder(currentState).metadata(mdBuilder).build();
import java.util.Objects;
            CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING,
                }
                } else {
        }
    }
/*  
    ) {
    ) {  
            }
import org.apache.logging.log4j.Logger;
        Map<String, Settings> forceGroups = forceSettings.getAsGroups();
                return ClusterState.builder(currentState).metadata(mdBuilder).build();
            DECOMMISSIONED_AWARENESS_VALUE_WEIGHT  
        }
        }
                logger.info("building cluster state with weighted routing weights deleted");  
                    allAwarenessValues.size() / 2  
            AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING,  
    private final ClusterService clusterService;
                    || (weightedRoutingMetadata != null
import java.util.Set;
                if (weightedRoutingMetadata == null) {
 * * Service responsible for updating cluster state metadata with weighted routing weights  
        }
                ensureNoVersionConflict(requestVersion, weightedRoutingMetadata);
                "weight for [{}] is not specified. Please specify its weight to [{}] as it is under decommission action",
                    throw new ResourceNotFoundException(
package org.opensearch.cluster.routing;
            public ClusterState execute(ClusterState currentState) {
        });  
        }  
            );  
            this::setForcedAwarenessAttributes  
                (String.format(
        if (countWithZeroWeight.get() > allAwarenessValues.size() / 2) {
            }  
    }  
        final long requestVersion = request.getVersion();
        WeightedRouting weightedRouting = request.getWeightedRouting();
    }
        clusterSettings.addSettingsUpdateConsumer(
        clusterService.submitStateUpdateTask("delete_weighted_routing", new ClusterStateUpdateTask(Priority.URGENT) {  
import org.opensearch.common.settings.ClusterSettings;  
        );
    }
import org.opensearch.action.ActionRequestValidationException;
        Set<String> allAwarenessValues;  
                Metadata.Builder mdBuilder = Metadata.builder(currentState.metadata());
        }  
            @Override
import org.opensearch.cluster.metadata.Metadata;  
        final ActionListener<ClusterDeleteWeightedRoutingResponse> listener
                WeightedRoutingMetadata weightedRoutingMetadata = metadata.custom(WeightedRoutingMetadata.TYPE);  
                validationException
            );
                mdBuilder.putCustom(WeightedRoutingMetadata.TYPE, weightedRoutingMetadata);
 */  
    ) {
        if ((weightedRoutingMetadata == null && requestedVersion != WeightedRoutingMetadata.INITIAL_VERSION)
        Settings settings,
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
        if (getAwarenessAttributes().contains(attributeName) == false) {  
 *
        if (decommissionAttributeMetadata == null || decommissionAttributeMetadata.status().equals(DecommissionStatus.FAILED)) {  
            allAwarenessValues = new HashSet<>();
                        + "] is not set and it is part of forced awareness value or a routing node has this attribute."
            }  
        }
            );
        this.threadPool = threadPool;  
    }
        final Set<String> nodesPerAttribute = state.getRoutingNodes().nodesPerAttributesCounts(attributeName);
import java.util.concurrent.atomic.AtomicInteger;  
                    } else {  
            List<String> aValues = entry.getValue().getAsList("values");  
import java.util.HashSet;  
            throw new UnsupportedWeightedRoutingStateException(
import java.util.HashMap;
    private void ensureWeightsSetForAllDiscoveredAndForcedAwarenessValues(ClusterState state, ClusterPutWeightedRoutingRequest request) {
                mdBuilder.putCustom(WeightedRoutingMetadata.TYPE, weightedRoutingMetadata);
                if ((weightedRoutingMetadata != null && awarenessAttribute == null)  
        AtomicInteger countWithZeroWeight = new AtomicInteger();
        return awarenessAttributes;
    private void setForcedAwarenessAttributes(Settings forceSettings) {
        setForcedAwarenessAttributes(CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.get(settings));  
        this.awarenessAttributes = awarenessAttributes;
            throw validationException;  
            @Override
        ClusterSettings clusterSettings  
 * SPDX-License-Identifier: Apache-2.0
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
import org.opensearch.cluster.decommission.DecommissionStatus;
            );
                weightedRouting.attributeName()
                        )
    }  
            throw addValidationError(  
        // discovered awareness values has weight zero
            allAwarenessValues = new HashSet<>(forcedAwarenessAttributes.get(attributeName));
                logger.info("building cluster state with weighted routing weights [{}]", newWeightedRouting);  
        // We have validations in place to check that not more than half of the values weights are set to 0 in the request object
import org.opensearch.cluster.service.ClusterService;  
        if (weightedRouting.attributeName().equals(decommissionAttribute.attributeName()) == false) {  
                Metadata.Builder mdBuilder = Metadata.builder(currentState.metadata());
        ) == false) {
                    "There are too many discovered attribute values [%s] given zero weight [%d]. Maximum expected number of routing weights having zero weight is [%d]",  
 * this file be licensed under the Apache-2.0 license or a
        if (forcedAwarenessAttributes.get(attributeName) == null) {
            public void onFailure(String source, Exception e) {
import org.opensearch.cluster.metadata.WeightedRoutingMetadata;
import org.opensearch.action.admin.cluster.shards.routing.weighted.put.ClusterPutWeightedRoutingRequest;
                )
            throw new UnsupportedWeightedRoutingStateException(
            // weight of an attribute undergoing decommission must be specified  
    }
import org.opensearch.cluster.ack.ClusterStateUpdateResponse;
        if (weightedRouting.weights().containsKey(decommissionAttribute.attributeValue()) == false) {
                    weightedRoutingMetadata != null ? weightedRoutingMetadata.getVersion() : WeightedRoutingMetadata.INITIAL_VERSION  
import org.opensearch.cluster.decommission.DecommissionAttribute;  
            || (weightedRoutingMetadata != null && requestedVersion != weightedRoutingMetadata.getVersion())) {  
import org.opensearch.cluster.routing.allocation.decider.AwarenessAllocationDecider;
        DecommissionAttribute decommissionAttribute = decommissionAttributeMetadata.decommissionAttribute();
import java.util.Locale;
            public void onFailure(String source, Exception e) {
                    );
        for (Map.Entry<String, Settings> entry : forceGroups.entrySet()) {
import org.apache.logging.log4j.LogManager;
        for (String stringObjectCursor : nodesPerAttribute) {  
            weightedRouting.weights().get(decommissionAttribute.attributeValue()),
            public ClusterState execute(ClusterState currentState) {
                countWithZeroWeight.addAndGet(1);
    public void verifyAwarenessAttribute(String attributeName) {
import org.opensearch.common.inject.Inject;
}
                        logger.info("updated weighted routing weights [{}] in metadata", newWeightedRouting);
        // Adding this check again here on allAwarenessValues such that in no case we land up in a situation where more than half of  
            this::setAwarenessAttributes
        ClusterService clusterService,  
                listener.onResponse(new ClusterStateUpdateResponse(true));
        });  
        final WeightedRouting newWeightedRouting = new WeightedRouting(request.getWeightedRouting());  
        final long requestVersion = request.getVersion();
import org.opensearch.cluster.ClusterState;  
                    requestedVersion,
                listener.onResponse(new ClusterDeleteWeightedRoutingResponse(true));
    private void setAwarenessAttributes(List<String> awarenessAttributes) {
                String.format(
