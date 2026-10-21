import org.opensearch.cluster.metadata.WorkloadGroup;
    }
    private final TaskSelectionStrategy taskSelectionStrategy;
                        .setLastRecordedUsage(0.0)
        );
     *
                if (excessUsage > MIN_VALUE) {
        handleNodeDuress(isNodeInDuress, activeWorkloadGroups, deletedWorkloadGroups);
        Consumer<TaskCancellation> cancellationConsumer = cancellationLoggingConsumer;
        return workloadGroupState.getResourceState().get(resourceType).cancellations::inc;
 * compatible open source license.
            if (!isNodeInDuress.getAsBoolean()) {
import java.util.ArrayList;
    public static final double MIN_VALUE = 1e-9;
            v -> cancelTasks(ResiliencyMode.SOFT, activeWorkloadGroups)
 *
        List<Consumer<Void>> duressActions = List.of(
        return workloadGroupResourceUsageView.getResourceUsageData().get(resourceType);
import java.util.stream.Collectors;
import org.opensearch.wlm.tracker.WorkloadGroupResourceUsageTrackerService;
        return getAllCancellableTasks(
        WorkloadGroupResourceUsageTrackerService resourceUsageTrackerService,
            for (ResourceType resourceType : TRACKED_RESOURCES) {
     */
    ) {
    }
        return taskCancellations;
}
        // cancel tasks from WorkloadGroups that are in Enforced mode that are breaching their resource limits
 */
 * views, a set of active WorkloadGroups, and a task selection strategy. These components collectively facilitate the
                    resourceType -> getWorkloadGroupState(workloadGroup.get_id()).getResourceState()
                    );
                }
     * @return List of tasks that can be cancelled
        WorkloadGroupState workloadGroupState = getWorkloadGroupState(workloadGroupId);
            + workloadGroup.getResourceLimits().get(resourceType)
 * Manages the cancellation of tasks enforced by WorkloadGroup thresholds on resource usage criteria.
        this.workloadGroupStateAccessor = workloadGroupStateAccessor;
        assert workloadGroupId != null : "workloadGroupId should never be null at this point.";
            String,
        }
                "Task {} is eligible for cancellation for reason {}",
    private WorkloadGroupState getWorkloadGroupState(String workloadGroupId) {
 *
    // a map of WorkloadGroupId to its corresponding WorkloadGroupLevelResourceUsageView object
import org.opensearch.wlm.WlmMode;
            });
            }
     * @param workloadGroup instance
                        .get(resourceType)
     * Get all cancellable tasks from the given WorkloadGroups.
        final double currentUsage = getCurrentUsage(workloadGroup, resourceType);
                        taskSelectionStrategy.selectTasksForCancellation(getTasksFor(workloadGroup), excessUsage, resourceType)
 * implemented task selection strategy.</p>
        for (WorkloadGroup workloadGroup : currentDeletedWorkloadGroups) {
            + " breached the resource limit: ("
        return "WorkloadGroup ID : "
    private static final Logger log = LogManager.getLogger(WorkloadGroupTaskCancellationService.class);
                taskCancellations.addAll(
                taskCancellation.getTask().getId(),
    private void updateResourceUsageInWorkloadGroupState(Collection<WorkloadGroup> activeWorkloadGroups) {
    }
        cancelTasks(getAllCancellableTasks(resiliencyMode, workloadGroups));
            }
                cancellationLoggingConsumer.accept(taskCancellation);
import org.opensearch.wlm.ResourceType;
        workloadGroupLevelResourceUsageViews = resourceUsageTrackerService.constructWorkloadGroupLevelUsageViews();
import java.util.Map;
            + currentUsage
 * The OpenSearch Contributors require contributions made to
        if (workloadManagementSettings.getWlmMode() == WlmMode.ENABLED) {
     * normalises configured value with respect to node level cancellation thresholds
            });
        Collection<WorkloadGroup> deletedWorkloadGroups
    private void cancelTasks(List<TaskCancellation> cancellableTasks) {
        double nodeLevelCancellationThreshold = resourceType.getNodeLevelThreshold(workloadManagementSettings);
 * predefined resource usage limits and are therefore eligible for cancellation.
    }
     * @return List of tasks that can be cancelled
        Set<String> isSearchWorkloadRunning = new HashSet<>();
    private final WorkloadManagementSettings workloadManagementSettings;
    /**
        Collection<WorkloadGroup> activeWorkloadGroups,
        }
        for (WorkloadGroup workloadGroup : workloadGroups) {
    private List<WorkloadGroupTask> getTasksFor(WorkloadGroup workloadGroup) {
/*
import org.opensearch.wlm.WorkloadGroupsStateAccessor;
 * identification and cancellation of tasks that threaten to breach WorkloadGroup resource limits.</p>
            + resourceType.getName();
            final List<TaskCancellation.Reason> reasons = new ArrayList<>();
    ) {
     */
            log.warn(
        this.resourceUsageTrackerService = resourceUsageTrackerService;
 * <p>The cancellation process is initiated by evaluating the resource usage of each WorkloadGroup against its
                            .collect(Collectors.toList())
                TRACKED_RESOURCES.forEach(
        this.workloadManagementSettings = workloadManagementSettings;
                taskCancellation.cancel();
                deletedWorkloadGroups.remove(workloadGroup);
        cancellableTasks.forEach(cancellationConsumer);
    private final WorkloadGroupResourceUsageTrackerService resourceUsageTrackerService;
    private Runnable getResourceTypeOnCancelCallback(String workloadGroupId, ResourceType resourceType) {
    List<TaskCancellation> getAllCancellableTasks(ResiliencyMode resiliencyMode, Collection<WorkloadGroup> workloadGroups) {
        List<TaskCancellation> taskCancellations = new ArrayList<>();
import java.util.HashSet;
        // List of tasks to be executed in order if the node is in duress
    public void pruneDeletedWorkloadGroups(Collection<WorkloadGroup> deletedWorkloadGroups) {
                    selectedTasks.stream().map(task -> new TaskCancellation(task, reasons, onCancelCallbacks)).collect(Collectors.toList())
            + " > "
            isSearchWorkloadRunning.add(workloadGroupLevelResourceUsageViewEntry.getKey());
/**
            List<WorkloadGroupTask> selectedTasks = new ArrayList<>();
package org.opensearch.wlm.cancellation;
import org.apache.logging.log4j.LogManager;
            TRACKED_RESOURCES.forEach(resourceType -> {
            }
        final WorkloadGroupLevelResourceUsageView workloadGroupResourceUsageView = workloadGroupLevelResourceUsageViews.get(
import org.opensearch.tasks.TaskCancellation;
        BooleanSupplier isNodeInDuress,
     */
    /**
                final double currentUsage = workloadGroupLevelResourceUsageViewEntry.getValue().getResourceUsageData().get(resourceType);
 * SPDX-License-Identifier: Apache-2.0
        Consumer<TaskCancellation> cancellationLoggingConsumer = (taskCancellation -> {
    List<TaskCancellation> getAllCancellableTasks(Collection<WorkloadGroup> workloadGroups) {
     */
        }
        Collection<WorkloadGroup> deletedWorkloadGroups
            workloadGroup.get_id()
    private final WorkloadGroupsStateAccessor workloadGroupStateAccessor;
        return workloadGroup.getResourceLimits().get(resourceType) * nodeLevelCancellationThreshold;
            workloadGroups.stream()
                    selectedTasks.addAll(
    }
import java.util.function.BooleanSupplier;
                    onCancelCallbacks.add(this.getResourceTypeOnCancelCallback(workloadGroup.get_id(), resourceType));
        for (Map.Entry<
import java.util.List;
 *
        }
        Collection<WorkloadGroup> activeWorkloadGroups,
    public WorkloadGroupTaskCancellationService(
     *
        TaskSelectionStrategy taskSelectionStrategy,
        WorkloadGroupsStateAccessor workloadGroupStateAccessor
 * resource limits. Tasks that contribute to exceeding these limits are selected for cancellation based on the
    private double getNormalisedThreshold(WorkloadGroup workloadGroup, ResourceType resourceType) {
public class WorkloadGroupTaskCancellationService {
    }
    private double getExcessUsage(WorkloadGroup workloadGroup, ResourceType resourceType) {
    }
                .entrySet()) {
import org.opensearch.wlm.WorkloadGroupTask;
                taskCancellation.getReasonString()
                onCancelCallbacks.add(getWorkloadGroupState(workloadGroup.get_id()).totalCancellations::inc);
                    reasons.add(new TaskCancellation.Reason(generateReasonString(workloadGroup, resourceType), 1));
            || !workloadGroupLevelResourceUsageViews.containsKey(workloadGroup.get_id())) {
    private void handleNodeDuress(
 * @see ResourceType
    ) {
        }
import org.apache.logging.log4j.Logger;
    }
    }
 * This class utilizes a strategy pattern through {@link MaximumResourceTaskSelectionStrategy} to identify tasks that exceed
                    // Only add tasks not already added to avoid double cancellations
        if (workloadGroup.getResourceLimits().get(resourceType) == null
    Map<String, WorkloadGroupLevelResourceUsageView> workloadGroupLevelResourceUsageViews;
     * Removes the workloadGroups from deleted list if it doesn't have any tasks running
                            .filter(x -> selectedTasks.stream().noneMatch(y -> x.getId() != y.getId()))
 * this file be licensed under the Apache-2.0 license or a
        BooleanSupplier isNodeInDuress,
            + workloadGroup.get_id()
            }
            return 0;
        }
                    .calculateResourceUsage(selectedTasks);
 * @see WorkloadGroup
    }
 */
        updateResourceUsageInWorkloadGroupState(activeWorkloadGroups);
     * Get all cancellable tasks from the WorkloadGroups.
 *
        );
        final List<Runnable> onCancelCallbacks = new ArrayList<>();
            if (!isSearchWorkloadRunning.contains(workloadGroup.get_id())) {
        WorkloadManagementSettings workloadManagementSettings,
        });
                            .stream()
            duressAction.accept(null);
        );
                // We need to consider the already selected tasks since those tasks also consumed the resources
    /**
import java.util.function.Consumer;
    }
                .collect(Collectors.toList())
        return workloadGroupStateAccessor.getWorkloadGroupState(workloadGroupId);
        cancelTasks(getAllCancellableTasks(deletedWorkloadGroups));
import org.opensearch.wlm.stats.WorkloadGroupState;
 * <p>Instances of this class are configured with a map linking WorkloadGroup IDs to their corresponding resource usage
            if (!reasons.isEmpty()) {
            );
import org.opensearch.wlm.MutableWorkloadGroupFragment.ResiliencyMode;
    private double getCurrentUsage(WorkloadGroup workloadGroup, ResourceType resourceType) {
                );
            return;
        if (!isNodeInDuress.getAsBoolean()) {
    }
        // if the node is in duress, cancel tasks accordingly.
                );
        });
            WorkloadGroupState workloadGroupState = getWorkloadGroupState(workloadGroupLevelResourceUsageViewEntry.getKey());
            }
     */
        this.taskSelectionStrategy = taskSelectionStrategy;
import static org.opensearch.wlm.tracker.WorkloadGroupResourceUsageTrackerService.TRACKED_RESOURCES;
    private void cancelTasksFromDeletedWorkloadGroups(Collection<WorkloadGroup> deletedWorkloadGroups) {
import java.util.Collection;
        List<WorkloadGroup> currentDeletedWorkloadGroups = new ArrayList<>(deletedWorkloadGroups);
        }
            cancellationConsumer = (taskCancellation -> {
     * Cancel tasks based on the implemented strategy.
    }
    private void cancelTasks(ResiliencyMode resiliencyMode, Collection<WorkloadGroup> workloadGroups) {
        return workloadGroupLevelResourceUsageViews.get(workloadGroup.get_id()).getActiveTasks();
            if (workloadGroupLevelResourceUsageViews.get(workloadGroup.get_id()).getActiveTasks().isEmpty()) {
        activeWorkloadGroups.forEach(workloadGroup -> {
                double excessUsage = getExcessUsage(workloadGroup, resourceType) - resourceType.getResourceUsageCalculator()
    }
            WorkloadGroupLevelResourceUsageView> workloadGroupLevelResourceUsageViewEntry : workloadGroupLevelResourceUsageViews
                workloadGroupState.getResourceState().get(resourceType).setLastRecordedUsage(currentUsage);
                break;
        for (Consumer<Void> duressAction : duressActions) {
 * @see MaximumResourceTaskSelectionStrategy
        cancelTasks(ResiliencyMode.ENFORCED, activeWorkloadGroups);
    }
import org.opensearch.wlm.WorkloadManagementSettings;
            v -> cancelTasksFromDeletedWorkloadGroups(deletedWorkloadGroups),
    private String generateReasonString(WorkloadGroup workloadGroup, ResourceType resourceType) {
import org.opensearch.wlm.WorkloadGroupLevelResourceUsageView;
    }
    }
     * @return normalised value with respect to node level cancellation thresholds
    public void cancelTasks(
import java.util.Set;
    /**
    /**
                .filter(workloadGroup -> workloadGroup.getResiliencyMode() == resiliencyMode)
        return getCurrentUsage(workloadGroup, resourceType) - getNormalisedThreshold(workloadGroup, resourceType);
            + ") for resource type : "
