    public void testCreateWorkerNode() {
        WorkerNode worker2 = WorkerNode.createWorkerNode("7", "Worker7", "192.168.1.7");
/*  
 * Tests for {@link WorkerNode}
    }  
        WorkerNode worker = WorkerNode.createWorkerNode("1", "Worker1", "192.168.1.1");  
        assertEquals("192.168.1.1", worker.getIp());
    }
        assertEquals("1", worker.getId());
        assertNotEquals(worker, new Object());
/**  
        assertNotEquals(worker2, worker3);
import org.opensearch.test.OpenSearchTestCase;
        assertEquals("Worker1", worker.getName());  
        assertEquals(worker1.hashCode(), worker2.hashCode());  
        WorkerNode worker = WorkerNode.createWorkerNode("9", "Worker9", "192.168.1.9");  
 * SPDX-License-Identifier: Apache-2.0
    public void testHashCode() {
}  
 *
    }
        WorkerNode worker1 = WorkerNode.createWorkerNode("7", "Worker7", "192.168.1.7");  
        assertNotEquals(null, worker);
        assertNotNull(worker);
public class WorkerNodeTests extends OpenSearchTestCase {  
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
    }
        WorkerNode worker3 = WorkerNode.createWorkerNode("6", "Worker6", "192.168.1.6");
    public void testEquality() {
 */  
        assertNotEquals(worker1, worker3);
    }  
        WorkerNode worker1 = WorkerNode.createWorkerNode("5", "Worker5", "192.168.1.5");
package org.opensearch.task.commons.worker;
        WorkerNode worker = WorkerNode.createWorkerNode("8", "Worker8", "192.168.1.8");
        WorkerNode worker2 = WorkerNode.createWorkerNode("5", "Worker5", "192.168.1.5");  
 * The OpenSearch Contributors require contributions made to  
 */
    public void testNotEqualToDifferentClass() {
    public void testNotEqualToNull() {  
        assertEquals(worker1, worker2);  
