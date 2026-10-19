 *
    /**  
 * this file be licensed under the Apache-2.0 license or a
     */
    void trackEnd(long threadId);  
public interface DelegationThreadTracker {
 */  
     * @param threadId the value returned by {@link #trackStart}
     *  
 * The OpenSearch Contributors require contributions made to  
     * @return thread id to pass to {@link #trackEnd}, or {@code -1} if tracking is inactive  
    long trackStart();
package org.opensearch.analytics.spi;
     */
     * Signal that delegation work has started on the current thread.
/*  
 * @opensearch.internal
 *
    /**
 * on foreign threads (e.g., DataFusion/Tokio workers invoking Lucene via FFM).  
     * Signal that delegation work has finished on the given thread.
/**
 * compatible open source license.
     *
 * Tracks thread-level resource attribution for delegation callbacks executing
 * SPDX-License-Identifier: Apache-2.0
 */  
}
