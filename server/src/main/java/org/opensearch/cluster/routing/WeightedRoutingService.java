            public ClusterState execute(ClusterState currentState) {
    }
                    request.getWeightedRouting().weights().toString(),
        this.awarenessAttributes = AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.get(settings);
                );
        ClusterService clusterService,
    }
    }
        Settings settings,
                    Locale.ROOT,
                ensureNoVersionConflict(requestVersion, weightedRoutingMetadata);
                        logger.info("weights are same, not updating weighted routing weights [{}] in metadata", newWeightedRouting);
    public void verifyAwarenessAttribute(String attributeName) {
                    "There are too many discovered attribute values [%s] given zero weight [%d]. Maximum expected number of routing weights having zero weight is [%d]",
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                    "requested version is %s but cluster weighted routing metadata is at a " + "different version %s ",
        final ActionListener<ClusterStateUpdateResponse> listener
                        logger.info("updated weighted routing weights [{}] in metadata", newWeightedRouting);
                logger.error("failed to remove weighted routing metadata from cluster state", e);
import org.opensearch.cluster.decommission.DecommissionAttributeMetadata;
        }
                logger.info("building cluster state with weighted routing weights [{}]", newWeightedRouting);
        }
import org.opensearch.core.action.ActionListener;
        final ClusterDeleteWeightedRoutingRequest request,
            }
            @Override
    private volatile Map<String, List<String>> forcedAwarenessAttributes;
                logger.warn(() -> new ParameterizedMessage("failed to update cluster state for weighted routing weights [{}]", e));
        Set<String> allAwarenessValues;
                Metadata metadata = currentState.metadata();
        // discovered awareness values has weight zero
import java.util.Set;
import org.opensearch.cluster.ClusterState;
            public ClusterState execute(ClusterState currentState) {
        this.awarenessAttributes = awarenessAttributes;
    private static final Double DECOMMISSIONED_AWARENESS_VALUE_WEIGHT = 0.0;
        setForcedAwarenessAttributes(CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.get(settings));
                listener.onResponse(new ClusterDeleteWeightedRoutingResponse(true));
        ThreadPool threadPool,
            throw new UnsupportedWeightedRoutingStateException(
        // We have validations in place to check that not more than half of the values weights are set to 0 in the request object
    List<String> getAwarenessAttributes() {
        ClusterSettings clusterSettings
import org.opensearch.cluster.service.ClusterService;
    }
        this.clusterService = clusterService;
import org.opensearch.cluster.decommission.DecommissionStatus;
        final long requestVersion = request.getVersion();
            }
    private final ThreadPool threadPool;
                    allAwarenessValues.size() / 2
    private volatile List<String> awarenessAttributes;
                        String.format(
        }
            if (request.getWeightedRouting().weights().containsKey(awarenessValue) == false) {
        for (Map.Entry<String, Settings> entry : forceGroups.entrySet()) {
        if ((weightedRoutingMetadata == null && requestedVersion != WeightedRoutingMetadata.INITIAL_VERSION)
        }
            if (request.getWeightedRouting().weights().get(awarenessValue) == 0) {
    }
                        + "] is not set and it is part of forced awareness value or a routing node has this attribute."
            @Override
                        )
        for (String stringObjectCursor : nodesPerAttribute) {
        final ClusterPutWeightedRoutingRequest request,
import java.util.HashSet;
                if (weightedRoutingMetadata == null) {
    }
            );
            return;
        } else {
        // Adding this check again here on allAwarenessValues such that in no case we land up in a situation where more than half of
                null
        }
            );
                    weightedRoutingMetadata = new WeightedRoutingMetadata(newWeightedRouting, requestVersion + 1);
            throw validationException;
            }
            }
                ensureWeightsSetForAllDiscoveredAndForcedAwarenessValues(currentState, request);
        clusterService.submitStateUpdateTask("update_weighted_routing", new ClusterStateUpdateTask(Priority.URGENT) {
            // this is unexpected when a different attribute is requested for decommission and weight update is on another attribute
import org.opensearch.action.admin.cluster.shards.routing.weighted.delete.ClusterDeleteWeightedRoutingResponse;
                    weightedRoutingMetadata != null ? weightedRoutingMetadata.getVersion() : WeightedRoutingMetadata.INITIAL_VERSION
import org.apache.logging.log4j.Logger;
        });
        allAwarenessValues.forEach(awarenessValue -> {
                    "weight for ["
}
            allAwarenessValues = new HashSet<>(forcedAwarenessAttributes.get(attributeName));
                )
import java.util.HashMap;
                decommissionAttribute.attributeValue(),
import org.opensearch.action.admin.cluster.shards.routing.weighted.put.ClusterPutWeightedRoutingRequest;
import java.util.Objects;
                listener.onFailure(e);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.routing.allocation.decider.AwarenessAllocationDecider;
                "weight for [{}] must be set to [{}] as it is under decommission action",
                }
            validationException = addValidationError(
import static org.opensearch.cluster.routing.allocation.decider.AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING;
                    }
import org.opensearch.common.Priority;
        });
                // verify that request object has weights for all discovered and forced awareness values
        if (weightedRouting.attributeName().equals(decommissionAttribute.attributeName()) == false) {
            throw new UnsupportedWeightedRoutingStateException(
        final String awarenessAttribute = request.getAwarenessAttribute();
/**
import org.opensearch.ResourceNotFoundException;
            @Override
                if ((weightedRoutingMetadata != null && awarenessAttribute == null)
import org.opensearch.common.inject.Inject;
                    } else {
    ) {
            }
                decommissionAttribute.attributeValue(),
        final WeightedRouting newWeightedRouting = new WeightedRouting(request.getWeightedRouting());
        }
                mdBuilder.putCustom(WeightedRoutingMetadata.TYPE, weightedRoutingMetadata);
                ensureDecommissionedAttributeHasZeroWeight(currentState, request);
    private void ensureWeightsSetForAllDiscoveredAndForcedAwarenessValues(ClusterState state, ClusterPutWeightedRoutingRequest request) {
        );
import org.opensearch.cluster.decommission.DecommissionAttribute;
        final ActionListener<ClusterDeleteWeightedRoutingResponse> listener
                WeightedRoutingMetadata weightedRoutingMetadata = metadata.custom(WeightedRoutingMetadata.TYPE);
            // here either there's no decommission action is ongoing or it is in failed state. In this case, we will allow weight update
                logger.info("Deleting weighted routing metadata from the cluster state");
            public void onFailure(String source, Exception e) {
import java.util.Locale;
import java.util.Map;
public class WeightedRoutingService {
                logger.info("building cluster state with weighted routing weights deleted");
    public WeightedRoutingService(
                throw new UnsupportedWeightedRoutingStateException(
import org.opensearch.common.settings.Settings;
                validationException
        this.forcedAwarenessAttributes = forcedAwarenessAttributes;
            allAwarenessValues = new HashSet<>();
                        return currentState;
                DECOMMISSIONED_AWARENESS_VALUE_WEIGHT
            );
            weightedRouting.weights().get(decommissionAttribute.attributeValue()),
        if (Objects.equals(
            throw new UnsupportedWeightedRoutingStateException(
    private void ensureDecommissionedAttributeHasZeroWeight(ClusterState state, ClusterPutWeightedRoutingRequest request) {
                            "weighted routing metadata does not have weights set for awareness attribute %s",
import org.opensearch.action.admin.cluster.shards.routing.weighted.delete.ClusterDeleteWeightedRoutingRequest;
        String attributeName = request.getWeightedRouting().attributeName();
                    logger.info("add weighted routing weights in metadata [{}]", newWeightedRouting);
        Map<String, Settings> forceGroups = forceSettings.getAsGroups();
                String.format(Locale.ROOT, "invalid awareness attribute %s requested for weighted routing", attributeName),
    private static final Logger logger = LogManager.getLogger(WeightedRoutingService.class);
        if (countWithZeroWeight.get() > allAwarenessValues.size() / 2) {
        clusterService.submitStateUpdateTask("delete_weighted_routing", new ClusterStateUpdateTask(Priority.URGENT) {
 * The OpenSearch Contributors require contributions made to
        }
import java.util.concurrent.atomic.AtomicInteger;
import org.opensearch.cluster.ack.ClusterStateUpdateResponse;
import org.opensearch.cluster.ClusterStateUpdateTask;
                        weightedRoutingMetadata = new WeightedRoutingMetadata(newWeightedRouting, requestVersion + 1);
    ) {
            List<String> aValues = entry.getValue().getAsList("values");
        allAwarenessValues.addAll(discoveredAwarenessValues);
        });
                        && weightedRoutingMetadata.getWeightedRouting().attributeName().equals(awarenessAttribute))) {
                    throw new ResourceNotFoundException(
                // verify weights will not be updated for a decommissioned attribute
        if (forcedAwarenessAttributes.get(attributeName) == null) {
            @Override
        clusterSettings.addSettingsUpdateConsumer(
import org.opensearch.cluster.metadata.Metadata;
/*
        // build attr_value -> nodes map
        clusterSettings.addSettingsUpdateConsumer(
        WeightedRouting weightedRouting = request.getWeightedRouting();
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                    requestedVersion,
            public void onFailure(String source, Exception e) {
import static org.opensearch.action.ValidateActions.addValidationError;
            AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING,
        DecommissionAttribute decommissionAttribute = decommissionAttributeMetadata.decommissionAttribute();
    private void setAwarenessAttributes(List<String> awarenessAttributes) {
            // weight of an attribute undergoing decommission must be specified
        }
 *
            throw new UnsupportedWeightedRoutingStateException(
import java.util.List;
                String.format(
package org.opensearch.cluster.routing;
                "decommission action ongoing for attribute [{}], cannot update weight for [{}]",
        final long requestVersion = request.getVersion();
 * * Service responsible for updating cluster state metadata with weighted routing weights
    @Inject
 */
                            awarenessAttribute
                (String.format(
        );
            @Override
                    weightedRoutingMetadata = new WeightedRoutingMetadata(new WeightedRouting(), weightedRoutingMetadata.getVersion() + 1);
                    if (!newWeightedRouting.equals(weightedRoutingMetadata.getWeightedRouting())) {
                decommissionAttribute.attributeName(),
            this::setAwarenessAttributes
import org.opensearch.threadpool.ThreadPool;
                }
        final Set<String> nodesPerAttribute = state.getRoutingNodes().nodesPerAttributesCounts(attributeName);
            DECOMMISSIONED_AWARENESS_VALUE_WEIGHT
        return awarenessAttributes;
                weightedRouting.attributeName()
            CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING,
            }
                ensureNoVersionConflict(requestVersion, weightedRoutingMetadata);
    }
                    countWithZeroWeight.get(),
                } else {
            );
                listener.onFailure(e);
        if (getAwarenessAttributes().contains(attributeName) == false) {
            }
                countWithZeroWeight.addAndGet(1);
        ) == false) {
        }
import org.apache.logging.log4j.message.ParameterizedMessage;
                Metadata metadata = currentState.metadata();
import org.opensearch.common.settings.ClusterSettings;
        Set<String> discoveredAwarenessValues = new HashSet<>();
 */
                DECOMMISSIONED_AWARENESS_VALUE_WEIGHT
    private void setForcedAwarenessAttributes(Settings forceSettings) {
                    Locale.ROOT,
            this::setForcedAwarenessAttributes
    }
        }
    }
        this.threadPool = threadPool;
    public void registerWeightedRoutingMetadata(
    private void ensureNoVersionConflict(long requestedVersion, WeightedRoutingMetadata weightedRoutingMetadata) {
import org.apache.logging.log4j.LogManager;
                )),
            );
                Metadata.Builder mdBuilder = Metadata.builder(currentState.metadata());
                logger.debug("cluster weighted routing weights metadata change is processed by all the nodes");
            throw addValidationError(
    ) {
        DecommissionAttributeMetadata decommissionAttributeMetadata = state.metadata().decommissionAttributeMetadata();
        if (decommissionAttributeMetadata == null || decommissionAttributeMetadata.status().equals(DecommissionStatus.FAILED)) {
            if (stringObjectCursor != null) discoveredAwarenessValues.add(stringObjectCursor);
    public void deleteWeightedRoutingMetadata(
            ActionRequestValidationException validationException = null;
                return ClusterState.builder(currentState).metadata(mdBuilder).build();
            || (weightedRoutingMetadata != null && requestedVersion != weightedRoutingMetadata.getVersion())) {
                Metadata.Builder mdBuilder = Metadata.builder(currentState.metadata());
            if (aValues.size() > 0) {
                    || (weightedRoutingMetadata != null
                forcedAwarenessAttributes.put(entry.getKey(), aValues);
 * this file be licensed under the Apache-2.0 license or a
            );
            @Override
import org.opensearch.cluster.metadata.WeightedRoutingMetadata;
                        + awarenessValue
                } else {
        AtomicInteger countWithZeroWeight = new AtomicInteger();
                    );
        if (weightedRouting.weights().containsKey(decommissionAttribute.attributeValue()) == false) {
    private final ClusterService clusterService;
            }
                WeightedRoutingMetadata weightedRoutingMetadata = metadata.custom(WeightedRoutingMetadata.TYPE);
import org.opensearch.action.ActionRequestValidationException;
    }
        Map<String, List<String>> forcedAwarenessAttributes = new HashMap<>();
 * compatible open source license.
                listener.onResponse(new ClusterStateUpdateResponse(true));
                logger.debug("cluster weighted routing metadata change is processed by all the nodes");
            }
                            Locale.ROOT,
                return ClusterState.builder(currentState).metadata(mdBuilder).build();
                mdBuilder.putCustom(WeightedRoutingMetadata.TYPE, weightedRoutingMetadata);
                "weight for [{}] is not specified. Please specify its weight to [{}] as it is under decommission action",
