     * @return HttpRequestInterceptor object.
/*  
import java.util.Optional;
     * @param request Reindex request.  
import org.opensearch.index.reindex.ReindexRequest;  
    /**
     * @param threadContext Current thread context.
import org.apache.hc.core5.http.HttpRequestInterceptor;
package org.opensearch.index.reindex.spi;
     */  
 */  
import org.opensearch.common.util.concurrent.ThreadContext;
 * Copyright OpenSearch Contributors.
    Optional<HttpRequestInterceptor> getRestInterceptor(ReindexRequest request, ThreadContext threadContext);
 * SPDX-License-Identifier: Apache-2.0
}
public interface ReindexRestInterceptorProvider {
