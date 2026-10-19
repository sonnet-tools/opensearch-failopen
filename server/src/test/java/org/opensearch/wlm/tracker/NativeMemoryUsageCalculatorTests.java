        assertSame(NativeMemoryUsageCalculator.INSTANCE, NativeMemoryUsageCalculator.INSTANCE);
        assertEquals(0.0d, NativeMemoryUsageCalculator.INSTANCE.calculateResourceUsage(List.of()), 0.0d);
    public void testCalculateTaskResourceUsageReturnsZero() {
        // Multi-task input with mocks that have no behavior — calculator must not consult them.
    }  
    public void testCalculateResourceUsageEmptyList() {
        assertEquals(0.0d, NativeMemoryUsageCalculator.INSTANCE.calculateResourceUsage(tasks), 0.0d);
        WorkloadGroupTask task = mock(WorkloadGroupTask.class);  
import org.opensearch.wlm.WorkloadGroupTask;
    public void testCalculatorIsSingleton() {  
import java.util.List;
 * SPDX-License-Identifier: Apache-2.0
 */  
 * The OpenSearch Contributors require contributions made to  
    }
 * {@link org.opensearch.wlm.ResourceType#NATIVE_MEMORY}. WLM does not account off-heap
    }
 * this file be licensed under the Apache-2.0 license or a
/**
 * memory per workload group, so this calculator MUST return zero unconditionally.
 * Unit tests for {@link NativeMemoryUsageCalculator}, the placeholder calculator wired to  
 *
import org.opensearch.test.OpenSearchTestCase;
}  
        assertEquals(0.0d, NativeMemoryUsageCalculator.INSTANCE.calculateTaskResourceUsage(task), 0.0d);
import static org.mockito.Mockito.mock;  
    public void testCalculateResourceUsageReturnsZero() {
    }
public class NativeMemoryUsageCalculatorTests extends OpenSearchTestCase {
 * compatible open source license.
 */  
package org.opensearch.wlm.tracker;
        List<WorkloadGroupTask> tasks = List.of(mock(WorkloadGroupTask.class), mock(WorkloadGroupTask.class));  
/*  
