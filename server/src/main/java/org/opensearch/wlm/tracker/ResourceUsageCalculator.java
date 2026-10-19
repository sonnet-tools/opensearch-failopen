 */
 *
     * calculates the current resource usage for the workload group  
    public abstract double calculateTaskResourceUsage(WorkloadGroupTask task);
}  
package org.opensearch.wlm.tracker;
 */  
import org.opensearch.wlm.WorkloadGroupTask;
/*  
import java.util.List;
    /**
    public abstract double calculateResourceUsage(List<WorkloadGroupTask> tasks);
     * @param task         WorkloadGroupTask
 * compatible open source license.
     * @param tasks        list of tasks in the workload group
     * @return task level resource usage  
 * The OpenSearch Contributors require contributions made to  
     * calculates the task level resource usage
 * SPDX-License-Identifier: Apache-2.0
@PublicApi(since = "2.18.0")  
public abstract class ResourceUsageCalculator {
import org.opensearch.common.annotation.PublicApi;
    /**  
     */  
     *
     */
/**  
 * This class is used to track workload group level resource usage
 * this file be licensed under the Apache-2.0 license or a
