package org.opensearch.wlm.tracker;
 * compatible open source license.
    }
/*  
    public double calculateResourceUsage(List<WorkloadGroupTask> tasks) {
    public static final long HEAP_SIZE_BYTES = JvmStats.jvmStats().getMem().getHeapMax().getBytes();
    @Override  
 * class to help make memory usage calculations for the workload group
 *
 */  
 */  
import org.opensearch.core.tasks.resourcetracker.ResourceStats;
    @Override
    public static final MemoryUsageCalculator INSTANCE = new MemoryUsageCalculator();  
import java.util.List;
 * SPDX-License-Identifier: Apache-2.0
}
    }  
        return (1.0f * task.getTotalResourceUtilization(ResourceStats.MEMORY)) / HEAP_SIZE_BYTES;
public class MemoryUsageCalculator extends ResourceUsageCalculator {
    private MemoryUsageCalculator() {}
/**
import org.opensearch.wlm.WorkloadGroupTask;  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.monitor.jvm.JvmStats;
 * this file be licensed under the Apache-2.0 license or a
    public double calculateTaskResourceUsage(WorkloadGroupTask task) {
        return tasks.stream().mapToDouble(this::calculateTaskResourceUsage).sum();  
