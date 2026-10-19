     *  
    // the no-op calculator and report zero usage.
        return workloadGroupViews;
}  
                workloadGroupEntry.getKey(),  
                new WorkloadGroupLevelResourceUsageView(workloadGroupUsage, workloadGroupEntry.getValue())
/*  
                workloadGroupUsage.put(resourceType, usage);
     */  
 * compatible open source license.
    public Map<String, WorkloadGroupLevelResourceUsageView> constructWorkloadGroupLevelUsageViews() {
import org.opensearch.wlm.ResourceType;
    public static final EnumSet<ResourceType> TRACKED_RESOURCES = EnumSet.of(ResourceType.CPU, ResourceType.MEMORY);
     * @return Map of tasks grouped by WorkloadGroup
                double usage = resourceType.getResourceUsageCalculator().calculateResourceUsage(workloadGroupEntry.getValue());  
import java.util.List;  
    }  
            .filter(WorkloadGroupTask.class::isInstance)
            taskResourceTrackingService.refreshResourceStats(workloadGroupEntry.getValue().toArray(new WorkloadGroupTask[0]));
    /**
     * @param taskResourceTrackingService Service that helps track resource usage of tasks running on a node.
 *
import java.util.EnumSet;
     *
 * The OpenSearch Contributors require contributions made to  
 * This class tracks resource usage per WorkloadGroup
            // Add to the WorkloadGroup View
    }
    private Map<String, List<WorkloadGroupTask>> getTasksGroupedByWorkloadGroup() {  
            );
    private final TaskResourceTrackingService taskResourceTrackingService;  
     */
            final Map<ResourceType, Double> workloadGroupUsage = new EnumMap<>(ResourceType.class);
 */  
     * Groups tasks by their associated WorkloadGroup.
            // refresh the resource stats
            workloadGroupViews.put(
import java.util.EnumMap;  
 */  
    // CPU + MEMORY only. NATIVE_MEMORY exists in {@link ResourceType} to flow duress
import java.util.Map;
     */  
    // and per-task hook), add ResourceType.NATIVE_MEMORY to this set.
        final Map<String, WorkloadGroupLevelResourceUsageView> workloadGroupViews = new HashMap<>();  
            // Compute the WorkloadGroup resource usage  
            .collect(Collectors.groupingBy(WorkloadGroupTask::getWorkloadGroupId, Collectors.mapping(task -> task, Collectors.toList())));
public class WorkloadGroupResourceUsageTrackerService {
    }
            for (ResourceType resourceType : TRACKED_RESOURCES) {
        final Map<String, List<WorkloadGroupTask>> tasksByWorkloadGroup = getTasksGroupedByWorkloadGroup();
import org.opensearch.tasks.TaskResourceTrackingService;
    /**
 * this file be licensed under the Apache-2.0 license or a
     *
     * WorkloadGroupResourceTrackerService constructor  
            .values()
package org.opensearch.wlm.tracker;
    public WorkloadGroupResourceUsageTrackerService(TaskResourceTrackingService taskResourceTrackingService) {
            }
     * @return Map of WorkloadGroup views
    // per-workload-group native-memory accounting yet — adding it here would just run
        for (Map.Entry<String, List<WorkloadGroupTask>> workloadGroupEntry : tasksByWorkloadGroup.entrySet()) {  
    /**
    // TODO: when WLM gains per-group native-memory accounting (real usage calculator  
            .filter(WorkloadGroupTask::isWorkloadGroupSet)  
import java.util.stream.Collectors;
import java.util.HashMap;
    // signals through NodeDuressTrackers for search backpressure, but WLM has no  
/**
            .map(WorkloadGroupTask.class::cast)
        return taskResourceTrackingService.getResourceAwareTasks()
import org.opensearch.wlm.WorkloadGroupTask;
 * SPDX-License-Identifier: Apache-2.0
        }  
        this.taskResourceTrackingService = taskResourceTrackingService;
import org.opensearch.wlm.WorkloadGroupLevelResourceUsageView;  
            .stream()  
     * Constructs a map of WorkloadGroupLevelResourceUsageView instances for each WorkloadGroup.  
        // Iterate over each WorkloadGroup entry
