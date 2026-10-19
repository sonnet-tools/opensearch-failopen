    private final Map<ResourceType, Double> resourceUsage;
import java.util.Map;
        return resourceUsage;
        this.resourceUsage = resourceUsage;
/**
     * Returns the list of active tasks.  
     *
     * Returns the resource usage data.  
 * has a 1:1 relation with a WorkloadGroup.  
     * @return The list of active tasks
    }  
/*  
        return activeTasks;
     */  
package org.opensearch.wlm;
    // activeTasks holds the list of active tasks for a WorkloadGroup at a point in time  
    public WorkloadGroupLevelResourceUsageView(Map<ResourceType, Double> resourceUsage, List<WorkloadGroupTask> activeTasks) {  
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
     * @return The map of resource usage data
 * Represents the point in time view of resource usage of a WorkloadGroup and
    private final List<WorkloadGroupTask> activeTasks;
 * The OpenSearch Contributors require contributions made to  
    // resourceUsage holds the resource usage data for a WorkloadGroup at a point in time
    public Map<ResourceType, Double> getResourceUsageData() {
    /**
        this.activeTasks = activeTasks;
    public List<WorkloadGroupTask> getActiveTasks() {
    /**
    }  
 */
    }  
 * this file be licensed under the Apache-2.0 license or a
     */  
     *
 * This class holds the resource usage data and the list of active tasks.
}
import java.util.List;
 */  
public class WorkloadGroupLevelResourceUsageView {  
 *
