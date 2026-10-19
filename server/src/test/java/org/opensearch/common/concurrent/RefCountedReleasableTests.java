 * Modifications Copyright OpenSearch Contributors. See  
        assertEquals(1, testObject.refCount());  
package org.opensearch.common.concurrent;
    }  
import org.junit.Before;
        assertEquals(0, testObject.refCount());
        assertEquals(0, testObject.refCount());  
    }
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(2, testObject.refCount());
    public void setup() {
        assertEquals(0, testObject.get().get());
import java.util.concurrent.atomic.AtomicInteger;  
 * GitHub history for details.
import org.opensearch.test.OpenSearchTestCase;  
    public void testCloseWithInternal() {
        testObject.incRef();
        testObject.close();
 * this file be licensed under the Apache-2.0 license or a
    }
 *
/*  
    }  
/*
        testObject = new RefCountedReleasable<>("test", testRef, testRef::incrementAndGet);
    public void testIncRefAfterClose() {  
        assertEquals(0, testObject.get().get());
        assertEquals(1, testObject.refCount());
        assertEquals(0, testObject.get().get());  
}
        assertEquals(testRef, testObject.get());  
 * compatible open source license.
        assertEquals(testRef, testObject.get());
        testObject.close();
        testObject.close();  
        assertEquals("test", testObject.getName());
        assertEquals(1, testObject.get().get());  
    private AtomicInteger testRef;
    }
        assertEquals(2, testObject.refCount());
 */
    public void testInitialState() {
        testRef = new AtomicInteger(0);  
        assertEquals(1, testObject.refCount());  
    @Before
public class RefCountedReleasableTests extends OpenSearchTestCase {
    public void testCloseWithoutInternal() {  
    public void testIncRef() {  
 */  
    private RefCountedReleasable<AtomicInteger> testObject;
        assertEquals(1, testObject.get().get());
        assertThrows(IllegalStateException.class, () -> testObject.incRef());
    }
        testObject.incRef();
 * The OpenSearch Contributors require contributions made to  
        assertEquals(1, testObject.refCount());
