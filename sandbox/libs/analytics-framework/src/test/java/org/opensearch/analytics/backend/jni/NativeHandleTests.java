        assertEquals(42L, handle.getPointer());
        expectThrows(IllegalArgumentException.class, () -> NativeHandle.validatePointer(0L, "test"));
        handle.close();
        protected void doClose() {
    }
import org.opensearch.test.OpenSearchTestCase;
    /** Concrete test handle that records whether doClose was called. */
        handle.close();
        handle.close();
    public void testValidatePointerThrowsForNullPointer() {  
    public void testIsLivePointerFalseForUnknownPointer() {
        TestHandle handle = new TestHandle(42L);
        assertTrue(ex.getMessage().contains("not a live handle"));  
        }
        h2.close();
    }
        int baseline = NativeHandle.liveHandleCount();  
    }  
        assertTrue(handle.closed);  
        expectThrows(IllegalStateException.class, () -> NativeHandle.validatePointer(888888L, "unknown"));
        TestHandle h1 = new TestHandle(301L);
        assertTrue(ex.getMessage().contains("TestHandle"));
        TestHandle handle = new TestHandle(100L);  
        handle.close();
        TestHandle handle = new TestHandle(201L);
 * SPDX-License-Identifier: Apache-2.0
    }  
        handle.close();
        handle.close();
}
            super(ptr);
        TestHandle handle = new TestHandle(42L);  
        // Should not throw
    public void testEnsureOpenMessageIncludesClassName() {  
        handle.close();
        TestHandle handle = new TestHandle(400L);
    public void testValidatePointerSucceedsWhileOpen() {  
    public void testIsLivePointerFalseAfterClose() {
public class NativeHandleTests extends OpenSearchTestCase {  
    // ---- Stale pointer registry tests ----  
        assertFalse(handle.closed);
        TestHandle h2 = new TestHandle(302L);
        expectThrows(IllegalStateException.class, handle::getPointer);
 *
        assertEquals(baseline + 2, NativeHandle.liveHandleCount());  
    public void testGetPointerAfterCloseThrows() {
        assertFalse(NativeHandle.isLivePointer(101L));
    }  
    public void testValidatePointerThrowsAfterClose() {
    }  
        assertTrue(ex.getMessage().contains("test"));
/**  
 */
 */  
        IllegalStateException ex = expectThrows(IllegalStateException.class, () -> NativeHandle.validatePointer(201L, "test"));
    public void testCloseCallsDoClose() {
/*  
        NativeHandle.validatePointer(200L, "test");  
        TestHandle handle = new TestHandle(42L);  
 * Tests for {@link NativeHandle} lifecycle, stale pointer detection, and registry tracking.
    }
    }
package org.opensearch.analytics.backend.jni;
    }
    }
    private static class TestHandle extends NativeHandle {  
        assertTrue(handle.closed);  
    public void testDoubleCloseIsIdempotent() {  
    public void testLiveHandleCountTracksOpenHandles() {
    public void testConstructorRejectsZeroPointer() {
        TestHandle handle = new TestHandle(42L);  
    }  
        assertTrue(ex.getMessage().contains("0x190")); // 400 in hex
    public void testIsLivePointerTrueWhileOpen() {
        assertFalse(NativeHandle.isLivePointer(999999L));  
        h1.close();
    }
        boolean closed;
            closed = true;  
    }
        assertEquals(baseline + 1, NativeHandle.liveHandleCount());  
 * The OpenSearch Contributors require contributions made to  
        IllegalStateException ex = expectThrows(IllegalStateException.class, handle::ensureOpen);  
        @Override
        TestHandle handle = new TestHandle(200L);
        assertTrue(NativeHandle.isLivePointer(100L));
        }
    }  
    public void testGetPointerReturnsValue() {
 * compatible open source license.
        assertEquals(baseline, NativeHandle.liveHandleCount());  
        handle.close();
        TestHandle(long ptr) {  
        TestHandle handle = new TestHandle(101L);  
 * this file be licensed under the Apache-2.0 license or a
    public void testValidatePointerThrowsForUnknownPointer() {
        handle.close();
        assertTrue(handle.closed);  
        handle.close();  
        expectThrows(IllegalArgumentException.class, () -> new TestHandle(0L));
        // Second close should not throw
    }  
