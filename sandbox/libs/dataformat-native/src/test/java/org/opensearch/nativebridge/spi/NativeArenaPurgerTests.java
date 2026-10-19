    }
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
    public void testPurgeOnlyFiresAboveThreshold() throws Exception {  
        NativeArenaPurger.init(0, INTERVAL_MS);
        assertBusy(() -> {
    @Override
 * compatible open source license.
        NativeArenaPurger.setCheckIntervalMs(0);
    @Override
    }
        assertBusy(() -> {  
    public void setUp() throws Exception {
public class NativeArenaPurgerTests extends OpenSearchTestCase {  
import org.opensearch.test.OpenSearchTestCase;  
            long countBefore = NativeArenaPurger.getPurgeCount();
            Thread.sleep(INTERVAL_MS * 3);
    public void tearDown() throws Exception {
package org.opensearch.nativebridge.spi;
        NativeArenaPurger.setCheckIntervalMs(0);  
        super.tearDown();
        NativeArenaPurger.setThresholdBytes(Long.MAX_VALUE);
 * this file be licensed under the Apache-2.0 license or a
 */  
        });  
/*  
}
        super.setUp();  
 */
 * SPDX-License-Identifier: Apache-2.0
    public void testPurgeDisabledWhenIntervalIsZero() throws Exception {
            long countBefore = NativeArenaPurger.getPurgeCount();  
    }
            assertEquals("Purge should not fire when below threshold", countBefore, NativeArenaPurger.getPurgeCount());
 *
    }
        long countBefore = NativeArenaPurger.getPurgeCount();
 * The OpenSearch Contributors require contributions made to  
 * Unit tests for {@link NativeArenaPurger} Rust-backed periodic purge.  
 * The Rust purge thread is a native OS thread managed outside JVM lifecycle,
    private static final long INTERVAL_MS = 50;
            Thread.sleep(INTERVAL_MS * 3);
            assertEquals("No purges should fire when interval=0", countBefore, NativeArenaPurger.getPurgeCount());  
    public void testPurgeFiresPeriodically() throws Exception {
    }
        });
 * so thread leak detection is disabled for this suite.  
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
/**
        assertBusy(() -> assertTrue("Purge should have fired at least once", NativeArenaPurger.getPurgeCount() > countBefore));  
 * These tests verify the FFI wiring and scheduling behavior.
