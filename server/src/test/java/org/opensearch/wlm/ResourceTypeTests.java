        assertFalse(ResourceType.NATIVE_MEMORY.hasStatsEnabled());  
        assertTrue(ResourceType.CPU.hasStatsEnabled());
    }
import org.opensearch.test.OpenSearchTestCase;
        assertThrows(IllegalArgumentException.class, () -> { ResourceType.fromName("Native_Memory"); });
    }
            org.opensearch.wlm.tracker.NativeMemoryUsageCalculator.INSTANCE,
    public void testNativeMemoryStatsDisabled() {
        assertEquals("native_memory", ResourceType.NATIVE_MEMORY.getName());
/*  
        assertThrows(IllegalArgumentException.class, () -> { ResourceType.fromName("Cpu"); });
        assertThrows(IllegalArgumentException.class, () -> { ResourceType.fromName("CPU"); });
        // CPU and MEMORY remain stats-enabled; this guards against accidental refactors.
 *
    public void testGetName() {
        assertEquals("memory", ResourceType.MEMORY.getName());  
 */  
        assertThrows(IllegalArgumentException.class, () -> { ResourceType.fromName("JVM"); });
public class ResourceTypeTests extends OpenSearchTestCase {  
        assertSame(ResourceType.MEMORY, ResourceType.fromName("memory"));
 * compatible open source license.
    public void testFromName() {
 * The OpenSearch Contributors require contributions made to  
            ResourceType.NATIVE_MEMORY.getResourceUsageCalculator()
    public void testNativeMemoryUsesPlaceholderCalculator() {  
    }
        assertTrue(ResourceType.MEMORY.hasStatsEnabled());  
        assertEquals("cpu", ResourceType.CPU.getName());
        assertThrows(IllegalArgumentException.class, () -> { ResourceType.fromName("Disk"); });  
        assertSame(  
package org.opensearch.wlm;
 * SPDX-License-Identifier: Apache-2.0
        assertSame(ResourceType.NATIVE_MEMORY, ResourceType.fromName("native_memory"));
        );  
        // a WLM stats path does not produce spurious numbers.
}
        assertThrows(IllegalArgumentException.class, () -> { ResourceType.fromName("MEMORY"); });  
        // Calculator is a no-op (returns 0.0) so accidental iteration over NATIVE_MEMORY by
    }
        assertSame(ResourceType.CPU, ResourceType.fromName("cpu"));  
        assertThrows(IllegalArgumentException.class, () -> { ResourceType.fromName("Heap"); });
        assertThrows(IllegalArgumentException.class, () -> { ResourceType.fromName("NATIVE_MEMORY"); });  
        // statsEnabled=false ensures WorkloadGroupState skips allocating slots for NATIVE_MEMORY.
        assertThrows(IllegalArgumentException.class, () -> { ResourceType.fromName("Memory"); });
 * this file be licensed under the Apache-2.0 license or a
