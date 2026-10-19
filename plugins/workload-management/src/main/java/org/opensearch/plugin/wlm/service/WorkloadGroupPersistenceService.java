    private static void validateMaxWorkloadGroupCount(int maxWorkloadGroupCount) {
    }
     * @throws IllegalArgumentException if the effective config cannot be enforced
    ) {  
import org.apache.logging.log4j.Logger;
     * @param clusterState state containing the currently stored workload group
     */  
                Metadata.builder(metadata)
    /**
            throw new IllegalArgumentException("WorkloadGroup with name " + groupName + " already exists. Not creating a new one.");  
     */  
import org.opensearch.plugin.wlm.WorkloadManagementPlugin;
import org.opensearch.cluster.metadata.WorkloadGroup;  
    /**
            logger.debug("WLM feature type not registered; skipping principal-attribute check for throttling config", e);  
    final ThrottlingKey updateWorkloadGroupThrottlingKey;
     * Modify cluster state to delete the WorkloadGroup  
            protected AcknowledgedResponse newResponse(boolean acknowledged) {
    private static final int MIN_QUERY_GROUP_COUNT_VALUE = 1;  
import java.util.stream.Collectors;  
            public ClusterState execute(ClusterState currentState) {
import static org.opensearch.cluster.service.ClusterManagerTask.CREATE_QUERY_GROUP;  
            }  
        if (existingWorkloadGroups.size() == maxWorkloadGroupCount) {  
import org.opensearch.cluster.service.ClusterManagerTaskThrottler.ThrottlingKey;
    final ThrottlingKey deleteWorkloadGroupThrottlingKey;  
        validateMaxWorkloadGroupCount(newMaxWorkloadGroupCount);
        }
            if (!currGroup.getName().equals(name)) {
import java.util.Optional;
     */  
import org.opensearch.cluster.ClusterStateUpdateTask;
            }  
     * Validates the effective throttling configuration for an update. Throttling updates are partial, so a fragment that  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
     * @param deleteWorkloadGroupRequest - request to delete a WorkloadGroup
    public void setMaxWorkloadGroupCount(int newMaxWorkloadGroupCount) {
        String by = WorkloadGroupThrottleSettings.getEffectiveBy(throttling);
     * @param maxWorkloadGroupCount - the maxWorkloadGroupCount number to be verified
     */  
                Optional<WorkloadGroup> findUpdatedGroup = newState.metadata()
    ClusterState saveWorkloadGroupInClusterState(final WorkloadGroup workloadGroup, final ClusterState currentClusterState) {
                    "Total resource allocation for " + resourceType.getName() + " will go above the max limit of 1.0."  
    /**  
     * @param currentState - current cluster state
    /**
     * @param name - the WorkloadGroup name we are getting
    static final String SOURCE = "query-group-persistence-service";
            return incomingThrottling;
            .values()  
     */  
}  
     * @param clusterSettings {@link ClusterSettings} - The cluster settings to be used by WorkloadGroupPersistenceService
    /**
            }
     * @param request the update request  
        totalUsage.putAll(resourceLimits);  
     * @param settings {@link Settings} - The settings to be used by WorkloadGroupPersistenceService
                    totalUsage.compute(resourceType, (k, v) -> v + currGroup.getResourceLimits().getOrDefault(resourceType, 0.0));
        return clusterService;
            .stream()
    public void deleteInClusterStateMetadata(
                return saveWorkloadGroupInClusterState(workloadGroup, currentState);
     * default max workloadGroup count on any node at any given point in time  
            .filter(workloadGroup -> workloadGroup.getName().equals(name))  
        validateTotalUsage(existingWorkloadGroups, groupName, workloadGroup.getResourceLimits());
        final Map<String, WorkloadGroup> existingWorkloadGroups = currentClusterState.metadata().workloadGroups();
            }
    }  
import org.opensearch.wlm.WorkloadGroupThrottleSettings;  
                return createWorkloadGroupThrottlingKey;  
    ClusterState deleteWorkloadGroupInClusterState(final String name, final ClusterState currentClusterState) {
package org.opensearch.plugin.wlm.service;
     * Modify cluster state to update the existing WorkloadGroup
        UpdateWorkloadGroupRequest toUpdateGroup,
/*  
     *  
            }  
            return currentGroups.values();
        final ClusterService clusterService,  
            .findAny()
    }  
        totalUsage.forEach((resourceType, total) -> {
import org.opensearch.common.settings.Setting;
            @Override
            }
        DeleteWorkloadGroupRequest deleteWorkloadGroupRequest,
                WorkloadGroup updatedGroup = findUpdatedGroup.get();
    final ThrottlingKey createWorkloadGroupThrottlingKey;
     * @param clusterService {@link ClusterService} - The cluster service to be used by WorkloadGroupPersistenceService  
    public static void validateUpdateThrottlingIsEnforceable(UpdateWorkloadGroupRequest request, ClusterState clusterState) {
     * only changes {@code node_limit} must inherit the existing {@code by} value before enforceability is checked.
        final Map<String, WorkloadGroup> existingGroups = currentState.metadata().workloadGroups();
        if (maxWorkloadGroupCount > DEFAULT_MAX_QUERY_GROUP_COUNT_VALUE || maxWorkloadGroupCount < MIN_QUERY_GROUP_COUNT_VALUE) {
        } catch (ResourceNotFoundException e) {
                listener.onFailure(e);
        WORKLOAD_GROUP_COUNT_SETTING_NAME,
            .stream()
        });
        final WorkloadGroup workloadGroupToRemove = getWorkloadGroup(name, metadata);  
        final Map<String, WorkloadGroup> currentGroups = currentState.getMetadata().workloadGroups();
        validateTotalUsage(existingGroups, name, mutableWorkloadGroupFragment.getResourceLimits());
     *  max WorkloadGroup count setting name
            .stream()
            .findFirst()  
    }
            public void onFailure(String source, Exception e) {
     * @param workloadGroup {@link WorkloadGroup} - the WorkloadGroup we're currently creating  
        final Settings settings,
                throw new IllegalArgumentException(
     */  
 * compatible open source license.
        return clusterState.metadata()
 */  
            .build();
        if (WorkloadGroupThrottleSettings.GROUP_SCOPE.equals(by)) {  
 * This class defines the functions for WorkloadGroup persistence
            .metadata(
     * Get the WorkloadGroups with the specified name from cluster state  
     * Update cluster state to include the new WorkloadGroup
     * Constructor for WorkloadGroupPersistenceService
                CreateWorkloadGroupResponse response = new CreateWorkloadGroupResponse(workloadGroup, RestStatus.OK);
     * maxWorkloadGroupCount getter
import org.opensearch.cluster.service.ClusterService;  
                    .stream()
import static org.opensearch.cluster.service.ClusterManagerTask.UPDATE_QUERY_GROUP;
     * @param toUpdateGroup {@link WorkloadGroup} - the WorkloadGroup that we want to update
    private void validateTotalUsage(  
            logger.warn("WorkloadGroup with name {} already exists. Not creating a new one.", groupName);
            return;  
     * Modify cluster state to delete the WorkloadGroup, and return the new cluster state  
    ) {
                }
 */  
                );
    private volatile int maxWorkloadGroupCount;
     * @param currentClusterState - current cluster state
            @Override
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
        final Metadata metadata = currentState.metadata();  
                return updateWorkloadGroupInClusterState(toUpdateGroup, currentState);
import org.opensearch.plugin.wlm.action.UpdateWorkloadGroupRequest;
            }
            public ClusterState execute(ClusterState currentState) throws Exception {  
            throw new IllegalArgumentException(WORKLOAD_GROUP_COUNT_SETTING_NAME + " should be in range [1-100].");  
            .filter(group -> group.getName().equals(name))
            .collect(Collectors.toList());
     * @param newMaxWorkloadGroupCount - the max number of WorkloadGroup allowed
    ) {
        // check if maxWorkloadGroupCount will breach
                assert findUpdatedGroup.isPresent();
        Setting.Property.Dynamic,  
import org.opensearch.plugin.wlm.action.DeleteWorkloadGroupRequest;
import org.opensearch.rule.autotagging.FeatureType;  
                    .values()  
     * @param existingWorkloadGroups - existing WorkloadGroups in the system  
            @Override
                return deleteWorkloadGroupInClusterState(deleteWorkloadGroupRequest.getName(), currentState);
                    .filter(group -> group.getName().equals(name))
        if (throttling == null || throttling.isEmpty()) {
            .stream()
        this.deleteWorkloadGroupThrottlingKey = clusterService.registerClusterManagerTask(DELETE_QUERY_GROUP, true);  
    public static final Setting<Integer> MAX_QUERY_GROUP_COUNT = Setting.intSetting(
 * SPDX-License-Identifier: Apache-2.0
        return maxWorkloadGroupCount;
    /**
     * @param workloadGroup - the WorkloadGroup we're currently creating
import org.opensearch.rule.autotagging.AutoTaggingRegistry;
        }
    private static final int DEFAULT_MAX_QUERY_GROUP_COUNT_VALUE = 100;
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;
        Optional<WorkloadGroup> findExistingGroup = existingWorkloadGroups.values()  
    /**  
    /**  
                    .getThrottling()  
        }
            logger.warn("{} value exceeded its assigned limit of {}.", WORKLOAD_GROUP_COUNT_SETTING_NAME, maxWorkloadGroupCount);
    }  
        DEFAULT_MAX_QUERY_GROUP_COUNT_VALUE,  
    public ClusterService getClusterService() {
            .build();
     */  
            if (total > 1.0) {  
        validateThrottlingIsEnforceable(getEffectiveThrottling(request, clusterState));
        ActionListener<AcknowledgedResponse> listener  
            .findAny()  
            .filter(group -> group.getName().equals(request.getName()))
        Settings incomingThrottling = request.getmMutableWorkloadGroupFragment().getThrottling();  
    }
                logger.warn("Failed to update WorkloadGroup due to error: {}, for source: {}", e.getMessage(), source);  
        if (incomingThrottling == null || incomingThrottling.isEmpty()) {
            .orElseThrow(() -> new ResourceNotFoundException("No WorkloadGroup exists with the provided name: " + name));
        if (name == null || name.isEmpty()) {  
     * @param resourceLimits - the WorkloadGroup we're creating or updating
            )
                listener.onFailure(e);  
 * The OpenSearch Contributors require contributions made to  
            @Override
     * @param listener - ActionListener for CreateWorkloadGroupResponse
        if (resourceLimits == null || resourceLimits.isEmpty()) {
import org.opensearch.common.Priority;
    /**
     * @param name - the name for WorkloadGroup to be deleted
import org.opensearch.core.rest.RestStatus;
            }
                group -> updateExistingWorkloadGroup(group, request.getmMutableWorkloadGroupFragment()).getMutableWorkloadGroupFragment()
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
import org.opensearch.core.action.ActionListener;  
            }
        setMaxWorkloadGroupCount(MAX_QUERY_GROUP_COUNT.get(settings));
            @Override  
    /**
        return currentGroups.values()  
                for (ResourceType resourceType : resourceLimits.keySet()) {  
            @Override
    /**
        return ClusterState.builder(currentClusterState)  
                );
                listener.onResponse(response);
    }
     * @param listener - ActionListener for AcknowledgedResponse
                logger.warn("failed to save WorkloadGroup object due to error: {}, for source: {}.", e.getMessage(), source);
    public static final String WORKLOAD_GROUP_COUNT_SETTING_NAME = "node.workload_group.max_count";
            .map(
            @Override  
     * Modify cluster state to update the WorkloadGroup  
    public void updateInClusterStateMetadata(
        });
    }
     * @throws IllegalArgumentException if the config cannot be enforced
            return;  
    }  
    ) {
    public void persistInClusterStateMetadata(WorkloadGroup workloadGroup, ActionListener<CreateWorkloadGroupResponse> listener) {  
        clusterService.submitStateUpdateTask(SOURCE, new ClusterStateUpdateTask(Priority.NORMAL) {
    static Settings getEffectiveThrottling(UpdateWorkloadGroupRequest request, ClusterState clusterState) {
import org.opensearch.cluster.AckedClusterStateUpdateTask;
                throw new IllegalArgumentException(  
                    .remove(existingGroup)  
import java.util.Map;
    }
            .stream()
        });  
    ClusterState updateWorkloadGroupInClusterState(UpdateWorkloadGroupRequest updateWorkloadGroupRequest, ClusterState currentState) {
    private final ClusterService clusterService;  
            .findFirst();  
public class WorkloadGroupPersistenceService {
     * @param throttling the incoming throttling fragment, may be {@code null} or empty (both fine: nothing to honour)
            .values()
            public void onFailure(String source, Exception e) {
        return metadata.workloadGroups()  
        clusterSettings.addSettingsUpdateConsumer(MAX_QUERY_GROUP_COUNT, this::setMaxWorkloadGroupCount);  
            @Override  
            .filter(group -> group.getName().equals(groupName))
    }  
     * This method checks if there's any resource allocation that exceed limit of 1.0
     * @param updateWorkloadGroupRequest {@link WorkloadGroup} - the WorkloadGroup that we want to update
        WorkloadGroupPersistenceService::validateMaxWorkloadGroupCount,
            @Override  
        for (WorkloadGroup currGroup : existingWorkloadGroups.values()) {
    @Inject
    }  
        final Metadata metadata = currentClusterState.metadata();
     */
            public ThrottlingKey getClusterManagerThrottlingKey() {  
                        + "] needs a principal attribute provider (the security plugin) to be installed, otherwise the "  
     */  
     */
                UpdateWorkloadGroupResponse response = new UpdateWorkloadGroupResponse(updatedGroup, RestStatus.OK);  
        Setting.Property.NodeScope
            .findFirst()
        clusterService.submitStateUpdateTask(SOURCE, new ClusterStateUpdateTask(Priority.NORMAL) {
        if (findExistingGroup.isPresent()) {
     * Set maxWorkloadGroupCount to be newMaxWorkloadGroupCount
        });  
    }  
import org.opensearch.cluster.ClusterState;  
        this.updateWorkloadGroupThrottlingKey = clusterService.registerClusterManagerTask(UPDATE_QUERY_GROUP, true);
import org.opensearch.common.settings.Settings;
     *
            .metadata(Metadata.builder(currentClusterState.metadata()).put(workloadGroup).build())
import org.opensearch.plugin.wlm.rule.WorkloadGroupFeatureType;
        try {  
    }  
            return;
        }  
import static org.opensearch.cluster.metadata.WorkloadGroup.updateExistingWorkloadGroup;
    /**
        this.clusterService = clusterService;
     */
    }  
import org.opensearch.common.settings.ClusterSettings;  
        final ClusterSettings clusterSettings
            }
     * This method will be executed before we submit the new cluster state  
     */
        }  
    private static final Logger logger = LogManager.getLogger(WorkloadGroupPersistenceService.class);  
import org.opensearch.plugin.wlm.action.CreateWorkloadGroupResponse;  
        }
     */  
     */
        Map<ResourceType, Double> resourceLimits  
 *
        clusterService.submitStateUpdateTask(SOURCE, new AckedClusterStateUpdateTask<>(deleteWorkloadGroupRequest, listener) {
    );
import org.apache.logging.log4j.LogManager;
    public WorkloadGroupPersistenceService(
import java.util.EnumMap;  
                    "throttling.by ["
                logger.warn("Total resource allocation for {} will go above the max limit of 1.0.", resourceType.getName());
import static org.opensearch.cluster.service.ClusterManagerTask.DELETE_QUERY_GROUP;
        0,
    /**
        String name = updateWorkloadGroupRequest.getName();
import org.opensearch.wlm.ResourceType;
        return ClusterState.builder(currentState)  
        }
                    .put(updateExistingWorkloadGroup(existingGroup, mutableWorkloadGroupFragment))
            FeatureType featureType = AutoTaggingRegistry.getFeatureType(WorkloadGroupFeatureType.NAME);
        // check if there's any resource allocation that exceed limit of 1.0  
import org.opensearch.cluster.metadata.Metadata;
            )  
                    .findFirst();  
            }
                return deleteWorkloadGroupThrottlingKey;
        ActionListener<UpdateWorkloadGroupResponse> listener  
     * Rejects principal-scoped throttling when no principal attribute is registered: no bucket can be resolved, so the  
        MutableWorkloadGroupFragment mutableWorkloadGroupFragment = updateWorkloadGroupRequest.getmMutableWorkloadGroupFragment();  
        this.maxWorkloadGroupCount = newMaxWorkloadGroupCount;  
     */  
    /**
            }
            public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {  
    /**  
            if (featureType.getAllowedAttributesRegistry().containsKey(WorkloadManagementPlugin.PRINCIPAL_ATTRIBUTE_NAME) == false) {
     * Validator for maxWorkloadGroupCount
            public ThrottlingKey getClusterManagerThrottlingKey() {
            .workloadGroups()
     *
    private static WorkloadGroup getWorkloadGroup(String name, Metadata metadata) {
                return new AcknowledgedResponse(acknowledged);  
    public static Collection<WorkloadGroup> getFromClusterStateMetadata(String name, ClusterState currentState) {
            }
        String groupName = workloadGroup.getName();  
            .orElse(incomingThrottling);
            }  
        return ClusterState.builder(currentClusterState).metadata(Metadata.builder(metadata).remove(workloadGroupToRemove).build()).build();
     * min workloadGroup count on any node at any given point in time
     * @param currentState - current cluster state  
        this.createWorkloadGroupThrottlingKey = clusterService.registerClusterManagerTask(CREATE_QUERY_GROUP, true);
            @Override
/**
     * limit would always fail open. Called from the transport actions, not a cluster-state applier, because throwing
     */  
                String name = toUpdateGroup.getName();  
                        + "limit can never be enforced. Omit [by] to use whole-group throttling instead."
import org.opensearch.wlm.MutableWorkloadGroupFragment;
                listener.onResponse(response);  
        }
            .stream()  
        // check for duplicate name
        final Map<ResourceType, Double> totalUsage = new EnumMap<>(ResourceType.class);
     * clusterService getter
        }
     */
    /**  
    }
    public int getMaxWorkloadGroupCount() {  
                    .build()
 * this file be licensed under the Apache-2.0 license or a
                return updateWorkloadGroupThrottlingKey;
     * while applying cluster state wedges the cluster-manager.
            // Feature type not registered yet. Skip: throttling fails open anyway, so a false rejection is worse.
        String name,
    /**
                        + by
import org.opensearch.common.inject.Inject;
            public ClusterState execute(ClusterState currentState) {
     *  max WorkloadGroup count setting
     * @param currentClusterState - the cluster state before the update
    public static void validateThrottlingIsEnforceable(Settings throttling) {
    /**  
        Map<String, WorkloadGroup> existingWorkloadGroups,
            @Override
        }
            throw new IllegalStateException("Can't create more than " + maxWorkloadGroupCount + " WorkloadGroups in the system.");
            .filter(group -> group.getName().equals(name))
     */  
     */  
import java.util.Collection;
    /**
     * @param listener - ActionListener for UpdateWorkloadGroupResponse
        final WorkloadGroup existingGroup = existingGroups.values()
import org.opensearch.ResourceNotFoundException;  
                    .workloadGroups()
import org.opensearch.plugin.wlm.action.UpdateWorkloadGroupResponse;  
            .orElseThrow(() -> new ResourceNotFoundException("No WorkloadGroup exists with the provided name: " + name));  
    }
