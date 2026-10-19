        // -1 disables decay (pages retained indefinitely)  
        NativeAllocatorConfig.setDirtyDecayMs(30000);  
import org.opensearch.test.OpenSearchTestCase;
    public void testSetMuzzyDecayMsSucceeds() {  
        NativeAllocatorConfig.setDirtyDecayMs(-1);
        NativeAllocatorConfig.setDirtyDecayMs(5000);
 *
    public void testDisableDecayWithNegativeOne() {
        NativeAllocatorConfig.setMuzzyDecayMs(30000);
        // Should not throw — applies to all jemalloc arenas  
    }  
public class NativeAllocatorConfigTests extends OpenSearchTestCase {  
}
 * Tests that the native jemalloc decay setters work at runtime.
 * this file be licensed under the Apache-2.0 license or a
/**  
        NativeAllocatorConfig.setDirtyDecayMs(30000);
        // Restore default
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
 */
    public void testSetDirtyDecayMsSucceeds() {
        NativeAllocatorConfig.setMuzzyDecayMs(10000);
    }
    }  
 */  
package org.opensearch.nativebridge.spi;
/*  
