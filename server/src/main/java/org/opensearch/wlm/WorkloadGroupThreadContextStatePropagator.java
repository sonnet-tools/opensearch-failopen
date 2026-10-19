        }
 * compatible open source license.
    @Override  
/*  
/**
    }  
import java.util.List;
import org.opensearch.common.util.concurrent.ThreadContextStatePropagator;
    @Override  
 */  
        }
    public Map<String, String> headers(Map<String, Object> source) {
            transientHeaders.compute(headerName, (k, v) -> source.get(headerName));  
    /**
    /**
import java.util.Map;
     * @return map of header and their values to be propagated across nodes
        for (String headerName : PROPAGATED_HEADERS) {
 * The OpenSearch Contributors require contributions made to  
     * @param source current context transient headers  
        final Map<String, Object> transientHeaders = new HashMap<>();  
import java.util.HashMap;  
        final Map<String, String> propagatedHeaders = new HashMap<>();  
     * @param source current context headers  
        return propagatedHeaders;
     */
    @SuppressWarnings("removal")
 *
    }  
 */  
        return transientHeaders;
}
            propagatedHeaders.compute(headerName, (k, v) -> (String) source.get(headerName));  
package org.opensearch.wlm;
    @SuppressWarnings("removal")
    public static List<String> PROPAGATED_HEADERS = List.of(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER);  
 * This class is used to propagate WorkloadGroup related headers to request and nodes
        for (String headerName : PROPAGATED_HEADERS) {
 * this file be licensed under the Apache-2.0 license or a
    public Map<String, Object> transients(Map<String, Object> source) {
     */
 * SPDX-License-Identifier: Apache-2.0
     * @return the map of header and their values to be propagated across request threadContexts
public class WorkloadGroupThreadContextStatePropagator implements ThreadContextStatePropagator {
