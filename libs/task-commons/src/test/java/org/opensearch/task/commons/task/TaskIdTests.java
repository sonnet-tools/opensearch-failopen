 * SPDX-License-Identifier: Apache-2.0
        TaskId taskId1 = new TaskId("789");
        TaskId taskId1 = new TaskId("456");  
        TaskId taskId2 = new TaskId("987");  
    public void testEqualsWithDifferentId() {
    public void testEqualsWithSameId() {
public class TaskIdTests extends OpenSearchTestCase {  
        assertNotEquals(taskId1.hashCode(), taskId3.hashCode());
        assertEquals(taskId1, taskId2);
    }
    public void testEqualsWithNull() {
    public void testConstructorAndGetValue() {
        TaskId taskId3 = new TaskId("4567");
        TaskId taskId = new TaskId("def");
        assertEquals("123", taskId.getValue());
 * this file be licensed under the Apache-2.0 license or a
        assertNotEquals(null, taskId);  
        TaskId taskId2 = new TaskId("456");
    public void testEqualsWithDifferentClass() {  
        assertNotEquals(taskId, new Object());
 * compatible open source license.
}
        assertEquals(taskId1.hashCode(), taskId2.hashCode());
 */
        TaskId taskId1 = new TaskId("456");
    }  
        assertNotEquals(taskId1, taskId2);
 * Tests for {@link TaskId}
package org.opensearch.task.commons.task;
 *
import org.opensearch.test.OpenSearchTestCase;
    public void testHashCode() {
/**  
    }
 * The OpenSearch Contributors require contributions made to  
    }  
        TaskId taskId = new TaskId("abc");
    }
 */  
        TaskId taskId = new TaskId("123");  
    }
/*  
        TaskId taskId2 = new TaskId("456");  
