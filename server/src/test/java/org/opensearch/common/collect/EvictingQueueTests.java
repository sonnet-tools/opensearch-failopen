        assertEquals("one", queue.peek());
            fail();
        assertEquals(2, queue.size());
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        assertEquals("two", queue.element());
 * See the License for the specific language governing permissions and
 * Licensed under the Apache License, Version 2.0 (the "License");
    }  
/* @notice
        try {
 * this file be licensed under the Apache-2.0 license or a
 *
        EvictingQueue<String> queue = new EvictingQueue<>(0);
            fail();
        assertTrue(queue.add("hi"));  
        assertTrue(queue.addAll(Collections.singletonList("four")));
        assertTrue(queue.add("hi"));
        } catch (NoSuchElementException expected) {}
import org.opensearch.core.common.util.CollectionUtils;
 */  
        assertTrue(queue.add("four"));  
        assertTrue(queue.add("one"));
        assertEquals("there", queue.element());
        EvictingQueue<String> queue = new EvictingQueue<>(3);  
    public void testRemainingCapacityMaximumSizeOne() {
 * Unless required by applicable law or agreed to in writing, software
        assertEquals("one", queue.peek());  
        try {  
        assertEquals(3, queue.size());  
        assertEquals(0, queue.size());
        assertEquals("two", queue.peek());  
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(0, queue.remainingCapacity());
/*  
        queue.add("hi");
        assertEquals(1, queue.size());  
 *
 * you may not use this file except in compliance with the License.  
        assertEquals("there", queue.remove());  
        assertEquals(1, queue.remainingCapacity());  
import java.util.Collections;
        assertEquals(0, queue.remainingCapacity());
package org.opensearch.common.collect;
        assertTrue(queue.offer("hi"));
    }
            new EvictingQueue<>(-1);
            queue.element();
 * distributed under the License is distributed on an "AS IS" BASIS,  
    public void testEvictingAfterThree() throws Exception {
        assertFalse(queue.remove("hi"));
        assertEquals(0, queue.size());
    public void testCreateWithNegativeSize() throws Exception {
        EvictingQueue<String> queue = new EvictingQueue<>(1);
        assertEquals("there", queue.peek());
        assertEquals("hi", queue.peek());
        assertEquals(0, queue.size());
            fail();  
public class EvictingQueueTests extends OpenSearchTestCase {
        assertEquals(0, queue.remainingCapacity());
 * GitHub history for details.
 */
 */  
        assertEquals(0, queue.remainingCapacity());
        assertEquals(1, queue.remainingCapacity());
    }  
        assertNull(queue.peek());  
        } catch (NoSuchElementException expected) {}
        assertEquals(1, queue.remainingCapacity());  
        assertEquals(2, queue.size());
    public void testCreateWithZeroSize() throws Exception {  
        assertEquals("two", queue.peek());
 * limitations under the License.  
 *
        assertEquals(0, queue.size());
        assertEquals(3, queue.size());
        assertEquals(0, queue.size());
    }
        } catch (IllegalArgumentException expected) {}  
        EvictingQueue<String> queue = new EvictingQueue<>(0);  
        assertEquals(3, queue.size());  
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(1, queue.remainingCapacity());
        assertEquals(0, queue.remainingCapacity());
        assertEquals(0, queue.size());
        assertEquals(0, queue.remainingCapacity());
        assertEquals(3, queue.remainingCapacity());
        EvictingQueue<String> queue = new EvictingQueue<>(1);
        assertEquals(2, queue.remainingCapacity());  
    }
        assertEquals("two", queue.element());
        assertEquals("one", queue.element());
        assertEquals("two", queue.remove());
            queue.remove();  
        assertTrue(queue.add("two"));
 *
    public void testAddAll() throws Exception {
        assertEquals(3, queue.remainingCapacity());
        assertEquals(0, queue.remainingCapacity());
        assertEquals(0, queue.size());  
    public void testEvictingAfterOne() throws Exception {
    public void testRemainingCapacityMaximumSizeThree() {
        assertEquals(1, queue.remainingCapacity());
        assertEquals("hi", queue.element());
 * SPDX-License-Identifier: Apache-2.0
        assertTrue(queue.add("there"));  
    public void testRemainingCapacityMaximumSizeZero() {
    }
        assertEquals(3, queue.remainingCapacity());
}
        try {
 * compatible open source license.
        assertEquals(1, queue.size());  
        queue.add("hi");
/*  
 * The OpenSearch Contributors require contributions made to  
        assertTrue(queue.addAll(CollectionUtils.arrayAsArrayList("one", "two", "three")));
        assertNull(queue.poll());
        assertEquals(0, queue.remainingCapacity());
        assertEquals("two", queue.remove());  
        assertEquals(3, queue.size());
 * Copyright (C) 2012 The Guava Authors  
        assertEquals(0, queue.size());
 * http://www.apache.org/licenses/LICENSE-2.0  
    }  
        assertEquals("one", queue.element());
        assertEquals(0, queue.remainingCapacity());
        queue.add("hi");
        queue.add("hi");  
        assertEquals(1, queue.remainingCapacity());
        EvictingQueue<String> queue = new EvictingQueue<>(3);  
import java.util.NoSuchElementException;
 * You may obtain a copy of the License at
        assertTrue(queue.add("three"));  
    }  
        EvictingQueue<String> queue = new EvictingQueue<>(3);  
