/**  
    @Override  
import java.util.List;
        return usage;  
        return (1.0f * task.getTotalResourceUtilization(ResourceStats.CPU)) / task.getElapsedTime();
    @Override
import org.opensearch.wlm.WorkloadGroupTask;
    public static final int PROCESSOR_COUNT = Runtime.getRuntime().availableProcessors();
    public double calculateResourceUsage(List<WorkloadGroupTask> tasks) {
 *
        usage /= PROCESSOR_COUNT;
    // This value should be initialised at the start time of the process and be used throughout the codebase
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.wlm.tracker;
 */  
public class CpuUsageCalculator extends ResourceUsageCalculator {  
    public double calculateTaskResourceUsage(WorkloadGroupTask task) {
 */
        double usage = tasks.stream().mapToDouble(this::calculateTaskResourceUsage).sum();  
}
import org.opensearch.core.tasks.resourcetracker.ResourceStats;
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
    public static final CpuUsageCalculator INSTANCE = new CpuUsageCalculator();  
 * The OpenSearch Contributors require contributions made to  
    }  
 * class to help make cpu usage calculations for the workload group
/*  
    }
    private CpuUsageCalculator() {}
