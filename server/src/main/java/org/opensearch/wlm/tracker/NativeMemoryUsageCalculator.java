 * live usage is reported by native backends (e.g. DataFusion) via the search backpressure  
 * The OpenSearch Contributors require contributions made to  
import java.util.List;  
 * SPDX-License-Identifier: Apache-2.0
 *
    }  
 * {@code NativeMemoryUsageTracker}. The enum entry exists so {@link
    @Override  
 * compatible open source license.
    public double calculateTaskResourceUsage(WorkloadGroupTask task) {  
 * Placeholder {@link ResourceUsageCalculator} for {@link org.opensearch.wlm.ResourceType#NATIVE_MEMORY}.  
    public static final NativeMemoryUsageCalculator INSTANCE = new NativeMemoryUsageCalculator();
 * simply returns zero for any task or task list so WLM surfaces that accidentally iterate it
 * org.opensearch.search.backpressure.trackers.NodeDuressTrackers} can route native-memory
 * <p>Workload Management does not account native (off-heap) memory per workload group — that
 */  
}  
    private NativeMemoryUsageCalculator() {}
/*  
package org.opensearch.wlm.tracker;
 */  
    @Override
        return 0.0;
    }
 *
import org.opensearch.wlm.WorkloadGroupTask;
 * behave as "no usage".
    public double calculateResourceUsage(List<WorkloadGroupTask> tasks) {
 * this file be licensed under the Apache-2.0 license or a
/**
        return 0.0;
public final class NativeMemoryUsageCalculator extends ResourceUsageCalculator {
 * duress through the same {@code ResourceType} keyed map as CPU and heap; this calculator  
