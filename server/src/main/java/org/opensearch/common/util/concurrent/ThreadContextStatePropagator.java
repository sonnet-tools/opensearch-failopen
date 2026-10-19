     * @param isSystemContext if the propagation is for system context.
    /**  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
     * Returns the list of transient headers that needs to be propagated from current context to new thread context.
     */
     * @return the list of request headers that needs to be propagated from current context to request
        return headers(source);
/*  
     * Returns the list of transient headers that needs to be propagated from current context to new thread context.
     * @return the list of request headers that needs to be propagated from current context to request
     * @param source          current context headers  
 */
    /**
     *
/**
     * @param source          current context headers  
     *  
package org.opensearch.common.util.concurrent;
     */  
    @Deprecated(since = "2.12.0", forRemoval = true)  
    Map<String, String> headers(Map<String, Object> source);
 * thread to another (tasks, tracing context, etc).
    default Map<String, Object> transients(Map<String, Object> source, boolean isSystemContext) {
 */  
     * @return the list of transient headers that needs to be propagated from current context to new thread context  
    /**
        return transients(source);  
public interface ThreadContextStatePropagator {  
     *  
     * @param isSystemContext if the propagation is for system context.
 *
import java.util.Map;  
 *
 * The OpenSearch Contributors require contributions made to  
 * @opensearch.api  
     */  
    default Map<String, String> headers(Map<String, Object> source, boolean isSystemContext) {
     */
     *
     * @param source          current context transient headers
@PublicApi(since = "2.8.0")
     * Returns the list of request headers that needs to be propagated from current context to request.
 * compatible open source license.
     * Returns the list of request headers that needs to be propagated from current context to request.
    };
    Map<String, Object> transients(Map<String, Object> source);
     * @return the list of transient headers that needs to be propagated from current context to new thread context
     * @param source          current context transient headers
    @Deprecated(since = "2.12.0", forRemoval = true)
}
import org.opensearch.common.annotation.PublicApi;
    /**  
    }  
 * The propagator for {@link ThreadContext} that helps to carry-over the state from one  
