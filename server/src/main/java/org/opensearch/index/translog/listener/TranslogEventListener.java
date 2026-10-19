    /**
    default void onAfterTranslogSync() {}
}
/**
    /**
     * Invoked after translog sync operations  
 * compatible open source license.
 *  
     */
 * @opensearch.internal
 * The listener that gets fired on events related to {@link org.opensearch.index.translog.TranslogManager}
     * @param reason the failure reason
     * @param ex the failure exception
public interface TranslogEventListener {  
    /**  
 * this file be licensed under the Apache-2.0 license or a
    default void onAfterTranslogRecovery() {}
    TranslogEventListener NOOP_TRANSLOG_EVENT_LISTENER = new TranslogEventListener() {
/*  
     * Invoked after recovering operations from translog
package org.opensearch.index.translog.listener;
 */
     * Invoked when translog operations run into any other failure  
    };  
     */
 * The OpenSearch Contributors require contributions made to  
     */  
 * SPDX-License-Identifier: Apache-2.0
    /**
     * Invoked before recovering operations from translog
    default void onBeginTranslogRecovery() {}  
     */  
    default void onFailure(String reason, Exception ex) {}
 */  
 *
