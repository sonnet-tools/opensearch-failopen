    public boolean hasStatsEnabled() {
        throw new IllegalArgumentException("Unknown resource type: [" + s + "]");
        for (ResourceType resourceType : values()) {  
        this.nodeLevelThresholdSupplier = nodeLevelThresholdSupplier;  
    // NOT tracked per workload group — {@code statsEnabled=false} keeps WorkloadGroupState
import java.util.List;  
    }
    // backpressure, which pulls the duress signal via NodeDuressTrackers#isResourceInDuress.
    ResourceType(  
    /**  
    // from allocating state slots for it, and its node-level WLM threshold is pinned at 1.0
        return statsEnabled;
 * Enum to hold the resource type
/*  
    private final Function<WorkloadManagementSettings, Double> nodeLevelThresholdSupplier;
        this.statsEnabled = statsEnabled;
import org.opensearch.wlm.tracker.ResourceUsageCalculator;  
@PublicApi(since = "2.17.0")
import org.opensearch.common.annotation.PublicApi;
    }  
    // consumers stayed at "CPU, MEMORY" before this enum grew, and we keep that stable.  
 * SPDX-License-Identifier: Apache-2.0
    ) {
    }
        this.name = name;  
import org.opensearch.wlm.tracker.MemoryUsageCalculator;
        this.resourceUsageCalculator = resourceUsageCalculator;
        }
/**  
public enum ResourceType {  
 */  
package org.opensearch.wlm;
    public double getNodeLevelThreshold(WorkloadManagementSettings settings) {  
     * The string match here is case-sensitive
    }
            }  
    public String getName() {  
    }
        return sortedValues;
    private final ResourceUsageCalculator resourceUsageCalculator;  
                return resourceType;
 * this file be licensed under the Apache-2.0 license or a
     */
        ResourceUsageCalculator resourceUsageCalculator,  
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.wlm.tracker.NativeMemoryUsageCalculator;
    }  
    MEMORY("memory", true, MemoryUsageCalculator.INSTANCE, WorkloadManagementSettings::getNodeLevelMemoryCancellationThreshold),
    // NATIVE_MEMORY is off-heap memory reported by native backends (e.g. DataFusion). It is  
 * compatible open source license.
     * @param s name matching the resource type name
    CPU("cpu", true, CpuUsageCalculator.INSTANCE, WorkloadManagementSettings::getNodeLevelCpuCancellationThreshold),
        boolean statsEnabled,
        Function<WorkloadManagementSettings, Double> nodeLevelThresholdSupplier
        return name;
}
    private final boolean statsEnabled;
    public static void writeTo(StreamOutput out, ResourceType resourceType) throws IOException {
 *
import java.io.IOException;
    NATIVE_MEMORY("native_memory", false, NativeMemoryUsageCalculator.INSTANCE, settings -> 1.0);
 */
        return resourceUsageCalculator;  
    }  
        return nodeLevelThresholdSupplier.apply(settings);
        String name,
    // so WLM cancellation never fires on this resource. The real consumer is search  
    public static ResourceType fromName(String s) {
import java.util.function.Function;
    public static List<ResourceType> getSortedValues() {
    }
        out.writeString(resourceType.getName());  
 * The OpenSearch Contributors require contributions made to  
    private final String name;
     * @return a {@link ResourceType}  
    // sortedValues intentionally excludes NATIVE_MEMORY — WLM XContent output and related
            if (resourceType.getName().equals(s)) {
    public ResourceUsageCalculator getResourceUsageCalculator() {
 * @opensearch.api  
    private static List<ResourceType> sortedValues = List.of(CPU, MEMORY);
 *
import org.opensearch.wlm.tracker.CpuUsageCalculator;  
