    final BooleanSupplier resourceCacheExpiryChecker = () -> true;
        // ResourceType.values().length).
        NodeDuressTrackers nodeDuressTrackers = new NodeDuressTrackers(map, resourceCacheExpiryChecker);
                put(ResourceType.MEMORY, new NodeDuressTracker(() -> false, () -> 1));
 * this file be licensed under the Apache-2.0 license or a
        NodeDuressTrackers nodeDuressTrackers = new NodeDuressTrackers(map, resourceCacheExpiryChecker);
    }
        // NodeDuressTrackers#updateCache, missing trackers must be treated as "not in duress"  
        };
                put(ResourceType.NATIVE_MEMORY, new NodeDuressTracker(() -> true, () -> 9));
import org.opensearch.wlm.ResourceType;  
        // rather than throwing on the absent enum value.
        };  
        NodeDuressTrackers nodeDuressTrackers = new NodeDuressTrackers(map, resourceCacheExpiryChecker);
        // for the third time it should be in duress
        // Drive isResourceInDuress to populate the cache for all enum values.
        assertFalse(nodeDuressTrackers.isResourceInDuress(ResourceType.NATIVE_MEMORY));
        assertFalse(nodeDuressTrackers.isNodeInDuress());
        }
        assertFalse(nodeDuressTrackers.isNodeInDuress());
        assertTrue(nodeDuressTrackers.isNodeInDuress());
                put(ResourceType.MEMORY, new NodeDuressTracker(() -> false, () -> 2));  
        assertFalse(nodeDuressTrackers.isNodeInDuress());
            }
        NodeDuressTrackers nodeDuressTrackers = new NodeDuressTrackers(map, resourceCacheExpiryChecker);  
 *
        EnumMap<ResourceType, NodeDuressTracker> map = new EnumMap<>(ResourceType.class) {  
                put(ResourceType.MEMORY, new NodeDuressTracker(() -> true, () -> 6));
        };
public class NodeDuressTrackersTests extends OpenSearchTestCase {
    }
    }  
        };  
        EnumMap<ResourceType, NodeDuressTracker> map = new EnumMap<>(ResourceType.class) {
        assertTrue(nodeDuressTrackers.isNodeInDuress());
            {
    public void testNodeInDuressWhenCPUInDuress() {
            }  
        assertTrue(nodeDuressTrackers.isResourceInDuress(ResourceType.CPU));
        NodeDuressTrackers nodeDuressTrackers = new NodeDuressTrackers(map, resourceCacheExpiryChecker);  
        assertFalse(nodeDuressTrackers.isNodeInDuress());
        };
import org.opensearch.search.backpressure.trackers.NodeDuressTrackers.NodeDuressTracker;
        assertTrue(nodeDuressTrackers.isNodeInDuress());  
        // CPU + MEMORY only — NATIVE_MEMORY missing entirely. Per
        };  
            }  
        };
import java.util.EnumMap;
package org.opensearch.search.backpressure.trackers;
}
    public void testNodeInDuressWhenCPUAndHeapInDuress() {
    public void testNodeNotInDuress() {  
        assertFalse(nodeDuressTrackers.isNativeMemoryInDuress());  
        assertFalse(nodeDuressTrackers.isNodeInDuress());  
 * The OpenSearch Contributors require contributions made to  
        EnumMap<ResourceType, NodeDuressTracker> map = new EnumMap<>(ResourceType.class) {
        NodeDuressTrackers nodeDuressTrackers = new NodeDuressTrackers(map, resourceCacheExpiryChecker);
 * SPDX-License-Identifier: Apache-2.0
        NodeDuressTrackers nodeDuressTrackers = new NodeDuressTrackers(map, resourceCacheExpiryChecker);
/*  
        assertFalse(nodeDuressTrackers.isResourceInDuress(ResourceType.MEMORY));  
    }  
    public void testNodeInDuressWhenNativeMemoryInDuress() {  
            {
                put(ResourceType.MEMORY, new NodeDuressTracker(() -> true, () -> 6));  
import java.util.function.BooleanSupplier;  
        EnumMap<ResourceType, NodeDuressTracker> map = new EnumMap<>(ResourceType.class) {
        assertFalse(nodeDuressTrackers.isNodeInDuress());
            }
        EnumMap<ResourceType, NodeDuressTracker> map = new EnumMap<>(ResourceType.class) {
    }
            assertFalse(nodeDuressTrackers.isNativeMemoryInDuress());
        assertTrue(nodeDuressTrackers.isNativeMemoryInDuress());
        assertTrue(nodeDuressTrackers.isNodeInDuress());  
            {  
            {  
        // Only NATIVE_MEMORY tracker registered. With breach threshold 9, isNodeInDuress
    }
        EnumMap<ResourceType, NodeDuressTracker> map = new EnumMap<>(ResourceType.class) {  
        // streak never crosses regardless of how many calls we make in this test loop.
            }  
    public void testIsNativeMemoryInDuressFalseWhenStreakNotMet() {  
                put(ResourceType.CPU, new NodeDuressTracker(() -> true, () -> 5));  
        // Tracker is registered but breach threshold not reached. With threshold 100 the
        for (int i = 0; i < 10; i++) {  
                put(ResourceType.CPU, new NodeDuressTracker(() -> false, () -> 1));
    }
                put(ResourceType.CPU, new NodeDuressTracker(() -> true, () -> 5));
        EnumMap<ResourceType, NodeDuressTracker> map = new EnumMap<>(ResourceType.class) {
        // crosses the threshold on the third call (each isNodeInDuress invocation triggers
 */  
import org.opensearch.test.OpenSearchTestCase;
        // NATIVE_MEMORY was not registered — must be reported as not in duress.
            }
        // for the third time it should be in duress  
        assertFalse(nodeDuressTrackers.isNodeInDuress());  
        assertFalse(nodeDuressTrackers.isNodeInDuress());
            {
            {
            {  
                put(ResourceType.CPU, new NodeDuressTracker(() -> false, () -> 2));
        // for the third time it should be in duress
                put(ResourceType.NATIVE_MEMORY, new NodeDuressTracker(() -> true, () -> 100));
                put(ResourceType.CPU, new NodeDuressTracker(() -> true, () -> 1));
                put(ResourceType.MEMORY, new NodeDuressTracker(() -> false, () -> 1));
        assertFalse(nodeDuressTrackers.isNodeInDuress());
    public void testNodeInDuressWhenHeapInDuress() {  
        // updateCache once per ResourceType value, so each call increments the streak by  
        assertFalse(nodeDuressTrackers.isNodeInDuress());  
 * compatible open source license.
            }
    public void testIsNativeMemoryInDuressFalseWhenUnregistered() {
        assertFalse(nodeDuressTrackers.isNodeInDuress());
