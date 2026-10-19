        // NATIVE_MEMORY because the calculator is a no-op and the duress signal is consumed  
        assertEquals(2, WorkloadGroupResourceUsageTrackerService.TRACKED_RESOURCES.size());  
 * The OpenSearch Contributors require contributions made to  
    public void testTrackedResourcesExcludesNativeMemory() {
 */  
 * SPDX-License-Identifier: Apache-2.0
        // Per the explicit comment on TRACKED_RESOURCES — WLM intentionally does not iterate
        assertFalse(WorkloadGroupResourceUsageTrackerService.TRACKED_RESOURCES.contains(ResourceType.NATIVE_MEMORY));
 * set. After NATIVE_MEMORY was added to {@link ResourceType} for search-backpressure duress  
    }
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(WorkloadGroupResourceUsageTrackerService.TRACKED_RESOURCES.contains(ResourceType.CPU));  
 * routing, this set MUST stay restricted to CPU + MEMORY so per-group accounting is unchanged.
import org.opensearch.wlm.ResourceType;
package org.opensearch.wlm.tracker;
public class WorkloadGroupResourceUsageTrackerServiceTests extends OpenSearchTestCase {  
    public void testTrackedResourcesContainsCpuAndMemory() {
        assertTrue(WorkloadGroupResourceUsageTrackerService.TRACKED_RESOURCES.contains(ResourceType.MEMORY));
/*  
    }  
 *
/**
import org.opensearch.test.OpenSearchTestCase;
 * compatible open source license.
    }
 * Unit tests for {@link WorkloadGroupResourceUsageTrackerService}'s {@code TRACKED_RESOURCES}
}
        // by SearchBackpressureService instead.
 */
    public void testTrackedResourcesHasExactlyTwoEntries() {
