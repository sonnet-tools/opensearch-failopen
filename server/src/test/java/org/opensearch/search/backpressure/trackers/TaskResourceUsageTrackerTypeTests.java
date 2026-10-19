 * The OpenSearch Contributors require contributions made to  
public class TaskResourceUsageTrackerTypeTests extends OpenSearchTestCase {
 *
    }
            assertSame(type, TaskResourceUsageTrackerType.fromName(type.getName()));  
    }
        IllegalArgumentException ex = expectThrows(
 * {@code NATIVE_MEMORY_USAGE_TRACKER} entry round-trips through {@code fromName}.
 * this file be licensed under the Apache-2.0 license or a
        for (TaskResourceUsageTrackerType type : TaskResourceUsageTrackerType.values()) {
 * SPDX-License-Identifier: Apache-2.0
            IllegalArgumentException.class,  
/**  
        assertTrue(ex.getMessage().contains("not_a_real_tracker"));  
 */  
        }
            () -> TaskResourceUsageTrackerType.fromName("not_a_real_tracker")
 * compatible open source license.
    }  
    }
 */  
 * Unit tests for {@link TaskResourceUsageTrackerType} ensuring the new
        expectThrows(IllegalArgumentException.class, () -> TaskResourceUsageTrackerType.fromName("NATIVE_MEMORY_USAGE_TRACKER"));
/*  
package org.opensearch.search.backpressure.trackers;
    public void testNativeMemoryUsageTrackerName() {  
    public void testFromNameRoundTrip() {
        // Mirrors the strictness of ResourceType.fromName — uppercase is not accepted.
        );
        assertEquals("native_memory_usage_tracker", TaskResourceUsageTrackerType.NATIVE_MEMORY_USAGE_TRACKER.getName());
    public void testFromNameUnknownThrows() {
    public void testFromNameIsCaseSensitive() {  
}
import org.opensearch.test.OpenSearchTestCase;
