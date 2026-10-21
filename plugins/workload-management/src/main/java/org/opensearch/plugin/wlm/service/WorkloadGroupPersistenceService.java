     *
import org.opensearch.cluster.ClusterStateUpdateTask;
        return clusterService;
            public void onFailure(String source, Exception e) {
            }
     * @param name - the name for WorkloadGroup to be deleted
            .build();
     * Modify cluster state to update the WorkloadGroup
     */
                );
            @Override
    public static void validateThrottlingIsEnforceable(Settings throttling) {
     * @param workloadGroup - the WorkloadGroup we're currently creating
package org.opensearch.plugin.wlm.service;
    ) {
    ) {
    private final ClusterService clusterService;
     * @param listener - ActionListener for CreateWorkloadGroupResponse
        WorkloadGroupPersistenceService::validateMaxWorkloadGroupCount,
public class WorkloadGroupPersistenceService {
import static org.opensearch.cluster.service.ClusterManagerTask.UPDATE_QUERY_GROUP;
                return saveWorkloadGroupInClusterState(workloadGroup, currentState);
                group -> updateExistingWorkloadGroup(group, request.getmMutableWorkloadGroupFragment()).getMutableWorkloadGroupFragment()
     */
                    "throttling.by ["
    }
     */
     */
     * @param existingWorkloadGroups - existing WorkloadGroups in the system
 * this file be licensed under the Apache-2.0 license or a
/**
        final WorkloadGroup workloadGroupToRemove = getWorkloadGroup(name, metadata);
import java.util.stream.Collectors;
                    totalUsage.compute(resourceType, (k, v) -> v + currGroup.getResourceLimits().getOrDefault(resourceType, 0.0));
    /**
    /**
        });
        String name,
        return ClusterState.builder(currentClusterState).metadata(Metadata.builder(metadata).remove(workloadGroupToRemove).build()).build();
     * This method will be executed before we submit the new cluster state
        if (incomingThrottling == null || incomingThrottling.isEmpty()) {
            @Override
        String by = WorkloadGroupThrottleSettings.getEffectiveBy(throttling);
                logger.warn("Failed to update WorkloadGroup due to error: {}, for source: {}", e.getMessage(), source);
     * @param currentState - current cluster state
            .findFirst();
            return;
import org.opensearch.plugin.wlm.rule.WorkloadGroupFeatureType;
    }
            @Override
import org.opensearch.cluster.service.ClusterManagerTaskThrottler.ThrottlingKey;
import org.opensearch.core.rest.RestStatus;
        Settings incomingThrottling = request.getmMutableWorkloadGroupFragment().getThrottling();
                throw new IllegalArgumentException(
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
import org.opensearch.rule.autotagging.FeatureType;
     * Update cluster state to include the new WorkloadGroup
    }
                UpdateWorkloadGroupResponse response = new UpdateWorkloadGroupResponse(updatedGroup, RestStatus.OK);
        if (existingWorkloadGroups.size() == maxWorkloadGroupCount) {
    /**
        String name = updateWorkloadGroupRequest.getName();
            .stream()
     */
                    .stream()
            }
     * This method checks if there's any resource allocation that exceed limit of 1.0
    /**
 * compatible open source license.
            public void onFailure(String source, Exception e) {
        clusterService.submitStateUpdateTask(SOURCE, new ClusterStateUpdateTask(Priority.NORMAL) {
            .orElseThrow(() -> new ResourceNotFoundException("No WorkloadGroup exists with the provided name: " + name));
            .values()
            .workloadGroups()
                    .getThrottling()
import static org.opensearch.cluster.metadata.WorkloadGroup.updateExistingWorkloadGroup;
    private volatile int maxWorkloadGroupCount;
                listener.onFailure(e);
                    .values()
        }
            .stream()
                );
    }
        Setting.Property.Dynamic,
            }
            }
            logger.warn("{} value exceeded its assigned limit of {}.", WORKLOAD_GROUP_COUNT_SETTING_NAME, maxWorkloadGroupCount);
        this.clusterService = clusterService;
            }
    }
        clusterService.submitStateUpdateTask(SOURCE, new ClusterStateUpdateTask(Priority.NORMAL) {
 */
                    .workloadGroups()
                    "Total resource allocation for " + resourceType.getName() + " will go above the max limit of 1.0."
    }
            public ClusterState execute(ClusterState currentState) {
    /**
     * @param settings {@link Settings} - The settings to be used by WorkloadGroupPersistenceService
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        totalUsage.forEach((resourceType, total) -> {
                return new AcknowledgedResponse(acknowledged);
     */
            .findFirst()
     */
        this.deleteWorkloadGroupThrottlingKey = clusterService.registerClusterManagerTask(DELETE_QUERY_GROUP, true);
import org.opensearch.plugin.wlm.action.CreateWorkloadGroupResponse;
        final Metadata metadata = currentClusterState.metadata();
        ActionListener<AcknowledgedResponse> listener
    /**
     * @param throttling the incoming throttling fragment, may be {@code null} or empty (both fine: nothing to honour)
        }
    final ThrottlingKey createWorkloadGroupThrottlingKey;
 * SPDX-License-Identifier: Apache-2.0
                return deleteWorkloadGroupInClusterState(deleteWorkloadGroupRequest.getName(), currentState);
import org.opensearch.common.settings.ClusterSettings;
    public int getMaxWorkloadGroupCount() {
     * @param workloadGroup {@link WorkloadGroup} - the WorkloadGroup we're currently creating
    }
     */
    @Inject
            .collect(Collectors.toList());
     */
     * Modify cluster state to update the existing WorkloadGroup
            .findAny()
     * only changes {@code node_limit} must inherit the existing {@code by} value before enforceability is checked.
    public void deleteInClusterStateMetadata(
        0,
            .findFirst()
        Map<ResourceType, Double> resourceLimits
     * @param currentClusterState - current cluster state
            .orElse(incomingThrottling);
import org.opensearch.common.inject.Inject;
        final Map<String, WorkloadGroup> currentGroups = currentState.getMetadata().workloadGroups();
            protected AcknowledgedResponse newResponse(boolean acknowledged) {
    }
    /**
            @Override
            logger.warn("WorkloadGroup with name {} already exists. Not creating a new one.", groupName);
        final Map<String, WorkloadGroup> existingGroups = currentState.metadata().workloadGroups();
    final ThrottlingKey deleteWorkloadGroupThrottlingKey;
     * @param currentState - current cluster state
     * Constructor for WorkloadGroupPersistenceService
import static org.opensearch.cluster.service.ClusterManagerTask.DELETE_QUERY_GROUP;
     * Validator for maxWorkloadGroupCount
            public ThrottlingKey getClusterManagerThrottlingKey() {
            }
        try {
     * @param updateWorkloadGroupRequest {@link WorkloadGroup} - the WorkloadGroup that we want to update
     * Modify cluster state to delete the WorkloadGroup, and return the new cluster state
        final WorkloadGroup existingGroup = existingGroups.values()
                    .put(updateExistingWorkloadGroup(existingGroup, mutableWorkloadGroupFragment))
import java.util.Optional;
            if (featureType.getAllowedAttributesRegistry().containsKey(WorkloadManagementPlugin.PRINCIPAL_ATTRIBUTE_NAME) == false) {
    public void persistInClusterStateMetadata(WorkloadGroup workloadGroup, ActionListener<CreateWorkloadGroupResponse> listener) {
    static final String SOURCE = "query-group-persistence-service";
import org.opensearch.plugin.wlm.action.UpdateWorkloadGroupRequest;
        WORKLOAD_GROUP_COUNT_SETTING_NAME,
        if (throttling == null || throttling.isEmpty()) {
     *  max WorkloadGroup count setting name
     */
import org.opensearch.common.Priority;
     * @param clusterSettings {@link ClusterSettings} - The cluster settings to be used by WorkloadGroupPersistenceService
            .build();
        final Metadata metadata = currentState.metadata();
        }
            if (total > 1.0) {
            .filter(workloadGroup -> workloadGroup.getName().equals(name))
     * Get the WorkloadGroups with the specified name from cluster state
import org.opensearch.plugin.wlm.WorkloadManagementPlugin;
    public void setMaxWorkloadGroupCount(int newMaxWorkloadGroupCount) {
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
        Setting.Property.NodeScope
            .filter(group -> group.getName().equals(name))
            @Override
            return;
import org.opensearch.common.settings.Setting;
                return deleteWorkloadGroupThrottlingKey;
        final Settings settings,
    /**
            return incomingThrottling;
 * This class defines the functions for WorkloadGroup persistence
     */
                assert findUpdatedGroup.isPresent();
import org.opensearch.wlm.MutableWorkloadGroupFragment;
        DeleteWorkloadGroupRequest deleteWorkloadGroupRequest,
                return updateWorkloadGroupThrottlingKey;
     * @param maxWorkloadGroupCount - the maxWorkloadGroupCount number to be verified
            public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
                        + by
            }
                    .remove(existingGroup)
        return currentGroups.values()
            throw new IllegalArgumentException(WORKLOAD_GROUP_COUNT_SETTING_NAME + " should be in range [1-100].");
            throw new IllegalArgumentException("WorkloadGroup with name " + groupName + " already exists. Not creating a new one.");
     * Rejects principal-scoped throttling when no principal attribute is registered: no bucket can be resolved, so the
    }
    }
            .findAny()
        final ClusterService clusterService,
        validateTotalUsage(existingWorkloadGroups, groupName, workloadGroup.getResourceLimits());
    ) {
        });
import org.opensearch.common.settings.Settings;
        // check if maxWorkloadGroupCount will breach
            @Override
    /**
import org.opensearch.ResourceNotFoundException;
 */
            @Override
        });
                        + "] needs a principal attribute provider (the security plugin) to be installed, otherwise the "
                Optional<WorkloadGroup> findUpdatedGroup = newState.metadata()
            }
                logger.warn("failed to save WorkloadGroup object due to error: {}, for source: {}.", e.getMessage(), source);
            .stream()
            }
            )
            .metadata(
     * @throws IllegalArgumentException if the config cannot be enforced
     */
        // check for duplicate name
     * min workloadGroup count on any node at any given point in time
            return;
            // Feature type not registered yet. Skip: throttling fails open anyway, so a false rejection is worse.
    private static final int DEFAULT_MAX_QUERY_GROUP_COUNT_VALUE = 100;
     */
import org.opensearch.cluster.metadata.WorkloadGroup;
     * Validates the effective throttling configuration for an update. Throttling updates are partial, so a fragment that
    ClusterState deleteWorkloadGroupInClusterState(final String name, final ClusterState currentClusterState) {
import org.opensearch.cluster.ClusterState;
import org.opensearch.core.action.ActionListener;
        validateMaxWorkloadGroupCount(newMaxWorkloadGroupCount);
    public WorkloadGroupPersistenceService(
    }
    private void validateTotalUsage(
        ActionListener<UpdateWorkloadGroupResponse> listener
     * while applying cluster state wedges the cluster-manager.
     * limit would always fail open. Called from the transport actions, not a cluster-state applier, because throwing
     * @param clusterState state containing the currently stored workload group
        }
            FeatureType featureType = AutoTaggingRegistry.getFeatureType(WorkloadGroupFeatureType.NAME);
     *
                    .build()
    }
        if (resourceLimits == null || resourceLimits.isEmpty()) {
            @Override
        }
            .filter(group -> group.getName().equals(request.getName()))
                listener.onFailure(e);
                    .findFirst();
            if (!currGroup.getName().equals(name)) {
        return clusterState.metadata()
/*
        return metadata.workloadGroups()
        validateThrottlingIsEnforceable(getEffectiveThrottling(request, clusterState));
                return createWorkloadGroupThrottlingKey;
                listener.onResponse(response);
     * @param resourceLimits - the WorkloadGroup we're creating or updating
        });
                logger.warn("Total resource allocation for {} will go above the max limit of 1.0.", resourceType.getName());
     * @param toUpdateGroup {@link WorkloadGroup} - the WorkloadGroup that we want to update
        }
            return currentGroups.values();
    /**
        if (name == null || name.isEmpty()) {
import java.util.Collection;
            .metadata(Metadata.builder(currentClusterState.metadata()).put(workloadGroup).build())
     * Set maxWorkloadGroupCount to be newMaxWorkloadGroupCount
    public ClusterService getClusterService() {
        for (WorkloadGroup currGroup : existingWorkloadGroups.values()) {
                return updateWorkloadGroupInClusterState(toUpdateGroup, currentState);
    private static void validateMaxWorkloadGroupCount(int maxWorkloadGroupCount) {
                Metadata.builder(metadata)
    ClusterState saveWorkloadGroupInClusterState(final WorkloadGroup workloadGroup, final ClusterState currentClusterState) {
import org.opensearch.wlm.WorkloadGroupThrottleSettings;
        this.updateWorkloadGroupThrottlingKey = clusterService.registerClusterManagerTask(UPDATE_QUERY_GROUP, true);
        } catch (ResourceNotFoundException e) {
     * @param clusterService {@link ClusterService} - The cluster service to be used by WorkloadGroupPersistenceService
        Optional<WorkloadGroup> findExistingGroup = existingWorkloadGroups.values()
}
        this.maxWorkloadGroupCount = newMaxWorkloadGroupCount;
            @Override
        }
            .stream()
 * The OpenSearch Contributors require contributions made to
        if (maxWorkloadGroupCount > DEFAULT_MAX_QUERY_GROUP_COUNT_VALUE || maxWorkloadGroupCount < MIN_QUERY_GROUP_COUNT_VALUE) {
        validateTotalUsage(existingGroups, name, mutableWorkloadGroupFragment.getResourceLimits());
import org.opensearch.rule.autotagging.AutoTaggingRegistry;
            }
     * clusterService getter
            .stream()
    }
                listener.onResponse(response);
        return ClusterState.builder(currentState)
            public ClusterState execute(ClusterState currentState) {
    private static final Logger logger = LogManager.getLogger(WorkloadGroupPersistenceService.class);
import java.util.Map;
     * @param listener - ActionListener for UpdateWorkloadGroupResponse
        this.createWorkloadGroupThrottlingKey = clusterService.registerClusterManagerTask(CREATE_QUERY_GROUP, true);
    /**
        final ClusterSettings clusterSettings
    ) {
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;
            public ClusterState execute(ClusterState currentState) throws Exception {
            public ThrottlingKey getClusterManagerThrottlingKey() {
     * maxWorkloadGroupCount getter
     * @param currentClusterState - the cluster state before the update
import java.util.EnumMap;
    public static final String WORKLOAD_GROUP_COUNT_SETTING_NAME = "node.workload_group.max_count";
    public static final Setting<Integer> MAX_QUERY_GROUP_COUNT = Setting.intSetting(
     * @param newMaxWorkloadGroupCount - the max number of WorkloadGroup allowed
            }
            }
    static Settings getEffectiveThrottling(UpdateWorkloadGroupRequest request, ClusterState clusterState) {
import static org.opensearch.cluster.service.ClusterManagerTask.CREATE_QUERY_GROUP;
            }
     * default max workloadGroup count on any node at any given point in time
                WorkloadGroup updatedGroup = findUpdatedGroup.get();
        // check if there's any resource allocation that exceed limit of 1.0
import org.apache.logging.log4j.Logger;
     */
     * Modify cluster state to delete the WorkloadGroup
    public static Collection<WorkloadGroup> getFromClusterStateMetadata(String name, ClusterState currentState) {
     */
        setMaxWorkloadGroupCount(MAX_QUERY_GROUP_COUNT.get(settings));
     */
    /**
                }
import org.opensearch.cluster.metadata.Metadata;
    );
    final ThrottlingKey updateWorkloadGroupThrottlingKey;
        }
import org.opensearch.cluster.service.ClusterService;
    }
    }
     * @param deleteWorkloadGroupRequest - request to delete a WorkloadGroup
                throw new IllegalArgumentException(
     *  max WorkloadGroup count setting
     * @param request the update request
            .filter(group -> group.getName().equals(groupName))
            @Override
            .orElseThrow(() -> new ResourceNotFoundException("No WorkloadGroup exists with the provided name: " + name));
        final Map<ResourceType, Double> totalUsage = new EnumMap<>(ResourceType.class);
        if (findExistingGroup.isPresent()) {
                CreateWorkloadGroupResponse response = new CreateWorkloadGroupResponse(workloadGroup, RestStatus.OK);
    /**
     *
 *
        String groupName = workloadGroup.getName();
        clusterService.submitStateUpdateTask(SOURCE, new AckedClusterStateUpdateTask<>(deleteWorkloadGroupRequest, listener) {
                String name = toUpdateGroup.getName();
    public void updateInClusterStateMetadata(
    /**
            logger.debug("WLM feature type not registered; skipping principal-attribute check for throttling config", e);
            }
                for (ResourceType resourceType : resourceLimits.keySet()) {
    private static final int MIN_QUERY_GROUP_COUNT_VALUE = 1;
     * @throws IllegalArgumentException if the effective config cannot be enforced
        UpdateWorkloadGroupRequest toUpdateGroup,
        final Map<String, WorkloadGroup> existingWorkloadGroups = currentClusterState.metadata().workloadGroups();
    private static WorkloadGroup getWorkloadGroup(String name, Metadata metadata) {
    /**
     * @param listener - ActionListener for AcknowledgedResponse
        clusterSettings.addSettingsUpdateConsumer(MAX_QUERY_GROUP_COUNT, this::setMaxWorkloadGroupCount);
        if (WorkloadGroupThrottleSettings.GROUP_SCOPE.equals(by)) {
     */
            .values()
    }
     */
        return ClusterState.builder(currentClusterState)
     * @param name - the WorkloadGroup name we are getting
    public static void validateUpdateThrottlingIsEnforceable(UpdateWorkloadGroupRequest request, ClusterState clusterState) {
import org.opensearch.plugin.wlm.action.DeleteWorkloadGroupRequest;
        DEFAULT_MAX_QUERY_GROUP_COUNT_VALUE,
                    .filter(group -> group.getName().equals(name))
    /**
        totalUsage.putAll(resourceLimits);
import org.opensearch.plugin.wlm.action.UpdateWorkloadGroupResponse;
                        + "limit can never be enforced. Omit [by] to use whole-group throttling instead."
    /**
    }
            .stream()
    /**
            throw new IllegalStateException("Can't create more than " + maxWorkloadGroupCount + " WorkloadGroups in the system.");
        }
        }
    ClusterState updateWorkloadGroupInClusterState(UpdateWorkloadGroupRequest updateWorkloadGroupRequest, ClusterState currentState) {
import org.opensearch.cluster.AckedClusterStateUpdateTask;
            )
import org.opensearch.wlm.ResourceType;
            .map(
        MutableWorkloadGroupFragment mutableWorkloadGroupFragment = updateWorkloadGroupRequest.getmMutableWorkloadGroupFragment();
            .filter(group -> group.getName().equals(name))
     */
        return maxWorkloadGroupCount;
import org.apache.logging.log4j.LogManager;
            @Override
        Map<String, WorkloadGroup> existingWorkloadGroups,
    /**
