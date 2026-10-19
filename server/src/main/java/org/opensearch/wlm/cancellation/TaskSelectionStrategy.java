 * SPDX-License-Identifier: Apache-2.0
 */
 *
 */  
/*  
    List<WorkloadGroupTask> selectTasksForCancellation(List<WorkloadGroupTask> tasks, double limit, ResourceType resourceType);
    /**
     * @return list of tasks  
     * @param limit min cumulative resource usage sum of selected tasks
/**  
     * @param resourceType
public interface TaskSelectionStrategy {  
     * Determines how the tasks are selected from the list of given tasks based on resource type
import org.opensearch.wlm.WorkloadGroupTask;
 * compatible open source license.
     * @param tasks to select from  
 * This interface exposes a method which implementations can use
     */
import org.opensearch.wlm.ResourceType;
}  
import java.util.List;
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.wlm.cancellation;
