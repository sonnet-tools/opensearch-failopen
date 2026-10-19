 * SPDX-License-Identifier: Apache-2.0
    public void testTransient() {
        Map<String, Object> transientHeader = new HashMap<>();
    }
    }
 */  
 * this file be licensed under the Apache-2.0 license or a
    private final TaskThreadContextStatePropagator taskThreadContextStatePropagator = new TaskThreadContextStatePropagator();  
        assertEquals("t_1", transientPropagatedHeader.get(TASK_ID));
        Map<String, Object> transientPropagatedHeader = taskThreadContextStatePropagator.transients(transientHeader, true);  
        assertEquals("t_1", transientPropagatedHeader.get(TASK_ID));  
    public void testTransientForSystemContext() {  
        transientHeader.put(TASK_ID, "t_1");
        transientHeader.put(TASK_ID, "t_1");
package org.opensearch.tasks;
 *
public class TaskThreadContextStatePropagatorTests extends OpenSearchTestCase {
        Map<String, Object> transientHeader = new HashMap<>();  
import java.util.Map;
/*  
}  
import java.util.HashMap;  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.OpenSearchTestCase;
 * compatible open source license.
import static org.opensearch.tasks.TaskResourceTrackingService.TASK_ID;  
        Map<String, Object> transientPropagatedHeader = taskThreadContextStatePropagator.transients(transientHeader, false);
