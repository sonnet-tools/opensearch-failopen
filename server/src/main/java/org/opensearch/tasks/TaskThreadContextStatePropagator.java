import java.util.Map;
        return transients;
            transients.put(TASK_ID, source.get(TASK_ID));
 * The OpenSearch Contributors require contributions made to  
    @Override
 */  
 * SPDX-License-Identifier: Apache-2.0
    }
        return Collections.emptyMap();
    @SuppressWarnings("removal")  
    }
        return transients(source);
    @Override
        return headers(source);  
package org.opensearch.tasks;
    public Map<String, Object> transients(Map<String, Object> source, boolean isSystemContext) {  
 * this file be licensed under the Apache-2.0 license or a
    }
    }  
    public Map<String, Object> transients(Map<String, Object> source) {
 * compatible open source license.
import java.util.Collections;  
/*  
 *
import org.opensearch.common.util.concurrent.ThreadContextStatePropagator;
import java.util.HashMap;
 */
public class TaskThreadContextStatePropagator implements ThreadContextStatePropagator {  
}
        }  
    public Map<String, String> headers(Map<String, Object> source, boolean isSystemContext) {
    @SuppressWarnings("removal")
    @Override
    @Override
/**  
        final Map<String, Object> transients = new HashMap<>();
 * Propagates TASK_ID across thread contexts
        if (source.containsKey(TASK_ID)) {
    public Map<String, String> headers(Map<String, Object> source) {  
import static org.opensearch.tasks.TaskResourceTrackingService.TASK_ID;
