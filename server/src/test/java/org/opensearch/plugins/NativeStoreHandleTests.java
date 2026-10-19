        AtomicBoolean called = new AtomicBoolean(false);  
    public void testEmptyGetPointerReturnsNegativeOne() {
    }
}  
        expectThrows(IllegalStateException.class, () -> NativeStoreHandle.validatePointer(99999L, "test"));  
        expectThrows(IllegalArgumentException.class, () -> new NativeStoreHandle(-5L, ptr -> {}));  
        int before = NativeStoreHandle.liveHandleCount();  
        NativeStoreHandle handle = new NativeStoreHandle(900L, ptr -> {});  
        NativeStoreHandle h2 = new NativeStoreHandle(1200L, ptr -> {});
    }
        handle.close();
    }
    }  
        expectThrows(IllegalArgumentException.class, () -> new NativeStoreHandle(0L, ptr -> {}));
        NativeStoreHandle handle = new NativeStoreHandle(100L, ptr -> {});  
    public void testConstructorRejectsZeroPointer() {
        NativeStoreHandle.EMPTY.close();
        handle.close();
        long[] capturedPtr = new long[1];
/*  
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(handle.isLive());
    }  
        NativeStoreHandle handle = new NativeStoreHandle(400L, ptr -> {});
        NativeStoreHandle handle = new NativeStoreHandle(600L, ptr -> {});
        expectThrows(IllegalArgumentException.class, () -> new NativeStoreHandle(1300L, null));
        handle.close();  
        NativeStoreHandle h1 = new NativeStoreHandle(1100L, ptr -> {});
    }  
        h2.close();  
    public void testIsLiveReturnsFalseForEmpty() {  
    }
    }
        assertEquals(600L, handle.getPointer());  
    public void testEmptyCloseIsNoOp() {
        assertTrue(called.get());
    public void testValidatePointerThrowsForZero() {  
    public void testConstructorRejectsNegativePointer() {
        handle.close();
        handle.close();  
    public void testIsLiveReturnsFalseAfterClose() {  
        NativeStoreHandle.EMPTY.close();  
        handle.close();
        NativeStoreHandle handle = new NativeStoreHandle(500L, ptr -> {});
    }  
        assertTrue(NativeStoreHandle.isLivePointer(200L));
        assertEquals(-1L, NativeStoreHandle.EMPTY.getPointer());
        assertFalse(NativeStoreHandle.EMPTY.isLive());
import java.util.concurrent.atomic.AtomicBoolean;  
        handle.close();
        assertTrue(NativeStoreHandle.isLivePointer(100L));
        handle.close();
            capturedPtr[0] = ptr;  
    public void testCloseRemovesFromLivePointers() {
    }
    public void testConstructorRejectsNullDestroyer() {  
    public void testGetPointerReturnsValueWhenOpen() {
    }
    public void testDestroyerCalledWithCorrectPointer() {
        NativeStoreHandle handle = new NativeStoreHandle(800L, ptr -> {
            called.set(true);
    }
 *
package org.opensearch.plugins;
        h1.close();
        // Should not throw
public class NativeStoreHandleTests extends OpenSearchTestCase {  
        NativeStoreHandle.validatePointer(900L, "test");
import org.opensearch.test.OpenSearchTestCase;
        });
        expectThrows(IllegalArgumentException.class, () -> NativeStoreHandle.validatePointer(-1L, "test"));
    }  
    public void testValidatePointerThrowsForClosedHandle() {
import java.util.concurrent.atomic.AtomicInteger;
 * The OpenSearch Contributors require contributions made to  
        expectThrows(IllegalStateException.class, handle::getPointer);
        handle.close();
        expectThrows(IllegalArgumentException.class, () -> NativeStoreHandle.validatePointer(0L, "test"));
        NativeStoreHandle handle = new NativeStoreHandle(700L, ptr -> destroyCount.incrementAndGet());
        assertEquals(before + 2, NativeStoreHandle.liveHandleCount());  
 */  
    public void testValidatePointerThrowsForUnknownPointer() {
        assertEquals(800L, capturedPtr[0]);
        assertFalse(handle.isLive());  
    }  
    public void testIsLiveReturnsTrueWhenOpen() {  
        expectThrows(IllegalStateException.class, () -> NativeStoreHandle.validatePointer(1000L, "test"));
        handle.close();  
    }  
        assertEquals(before + 1, NativeStoreHandle.liveHandleCount());
 * SPDX-License-Identifier: Apache-2.0
    }
    public void testValidatePointerThrowsForNegative() {
    }
    public void testCreateRegistersInLivePointers() {
    }  
        NativeStoreHandle handle = new NativeStoreHandle(200L, ptr -> {});  
    public void testLiveHandleCount() {
    public void testGetPointerThrowsAfterClose() {
        assertEquals(before, NativeStoreHandle.liveHandleCount());
        handle.close();  
    public void testValidatePointerSucceedsForLiveHandle() {
    }
        NativeStoreHandle handle = new NativeStoreHandle(1000L, ptr -> {});  
 * compatible open source license.
    public void testCloseIsIdempotent() {
        NativeStoreHandle handle = new NativeStoreHandle(300L, ptr -> {});
        AtomicInteger destroyCount = new AtomicInteger(0);  
        assertEquals("Destroyer should only be called once", 1, destroyCount.get());
    }
        handle.close();
        assertFalse(NativeStoreHandle.isLivePointer(200L));  
