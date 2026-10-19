import static org.opensearch.wlm.cancellation.WorkloadGroupTaskCancellationService.MIN_VALUE;
 * SPDX-License-Identifier: Apache-2.0
import java.util.Collections;
    /**  
 * Represents the highest resource consuming task first selection strategy.
        double accumulated = 0;  
     * The tasks are sorted based on the sorting condition and then selected until the accumulated resource usage reaches the limit.
        return Comparator.comparingDouble(task -> resourceType.getResourceUsageCalculator().calculateTaskResourceUsage(task));  
    public List<WorkloadGroupTask> selectTasksForCancellation(List<WorkloadGroupTask> tasks, double limit, ResourceType resourceType) {
    /**
 * compatible open source license.
    private Comparator<WorkloadGroupTask> sortingCondition(ResourceType resourceType) {
 * this file be licensed under the Apache-2.0 license or a
     * @param limit The limit on the accumulated resource usage
    public MaximumResourceTaskSelectionStrategy() {}
import java.util.List;
 * The OpenSearch Contributors require contributions made to  
     * @param tasks The list of tasks from which to select
 */
     *  
public class MaximumResourceTaskSelectionStrategy implements TaskSelectionStrategy {  
        List<WorkloadGroupTask> selectedTasks = new ArrayList<>();
                break;
     */
import org.opensearch.wlm.WorkloadGroupTask;
     */  
}
        }
     * @return The comparator  
     * @return The list of selected tasks
        if (limit < 0) {
     * @throws IllegalArgumentException If the limit is less than zero
import org.opensearch.wlm.ResourceType;
            throw new IllegalArgumentException("limit has to be greater than zero");  
     * Selects tasks for cancellation based on the provided limit and resource type.
    }  
/*  
 *
 */  
package org.opensearch.wlm.cancellation;
     * This is the default implementation since the most resource consuming tasks are the likely to regress the performance.  
     * from resiliency point of view it makes sense to cancel them first
     * Returns a comparator that defines the sorting condition for tasks.
        return selectedTasks;
        List<WorkloadGroupTask> sortedTasks = tasks.stream().sorted(sortingCondition(resourceType).reversed()).collect(Collectors.toList());  
    }
import java.util.Comparator;  
import java.util.ArrayList;
        }
            selectedTasks.add(task);
        if (limit < MIN_VALUE) {
            return Collections.emptyList();  
            }  
import java.util.stream.Collectors;
            if ((accumulated - limit) > MIN_VALUE) {
            accumulated += resourceType.getResourceUsageCalculator().calculateTaskResourceUsage(task);  
        for (WorkloadGroupTask task : sortedTasks) {
        }
     * @param resourceType The type of resource to consider  
/**  
     *
