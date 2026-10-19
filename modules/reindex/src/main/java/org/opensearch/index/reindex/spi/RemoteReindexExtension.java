 * SPDX-License-Identifier: Apache-2.0
    /**
    ReindexRestInterceptorProvider getInterceptorProvider();  
     */  
}
    /**
     * @return ActionListener wrapper implementation.
public interface RemoteReindexExtension {
 */  
     * Get a wrapper of ActionListener which is can used to perform any action based on  
     * @return ReindexRestInterceptorProvider implementation.
 * This interface provides an extension point for {@link ReindexModulePlugin}.
    ActionListener<BulkByScrollResponse> getRemoteReindexActionListener(
    );
import org.opensearch.core.action.ActionListener;
/*  
 * on the response. The ActionListener listens to the success and failure events on every reindex request
     * the success/failure of the remote reindex call.
import org.opensearch.index.reindex.ReindexRequest;
package org.opensearch.index.reindex.spi;
        ActionListener<BulkByScrollResponse> listener,
 * and can be used to take any actions based on the success or failure.
import org.opensearch.index.reindex.BulkByScrollResponse;
/**  
 * The Rest interceptor can be used to pre-process any reindex request and perform any action  
     * Get an InterceptorProvider.  
     */
 * This interface can be implemented to provide a custom Rest interceptor and {@link ActionListener}
 */  
 * Copyright OpenSearch Contributors.
import org.opensearch.index.reindex.ReindexModulePlugin;  
        ReindexRequest reindexRequest  
