    HttpUriRequestProducer(final HttpUriRequestBase request, final AsyncEntityProducer entityProducer) {
        Args.notNull(request, "Request");  
        if (entity != null) {
 */  
     * Get the produced {@link HttpUriRequestBase} instance
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.http.HttpHost;  
        request.setScheme(host.getSchemeName());
 * The OpenSearch Contributors require contributions made to  
    }  
import org.apache.hc.core5.http.nio.support.BasicRequestProducer;
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
    }
            entityProducer = new HttpEntityAsyncEntityProducer(entity);
    public HttpUriRequestBase getRequest() {
 *
    private final HttpUriRequestBase request;
    public static HttpUriRequestProducer create(final HttpUriRequestBase request, final HttpHost host) {
 * The producer of the {@link HttpUriRequestBase} instances associated with a particular {@link HttpHost}
 */  
import org.apache.hc.core5.net.URIAuthority;  
     */  
        }  
    /**  
        AsyncEntityProducer entityProducer = null;
public class HttpUriRequestProducer extends BasicRequestProducer {
/**
     * Create new request producer for {@link HttpUriRequestBase} instance and {@link HttpHost}  
        request.setAuthority(new URIAuthority(host));
        this.request = request;  
     * @param host {@link HttpHost} instance
     */
        final HttpEntity entity = request.getEntity();
import org.opensearch.client.nio.HttpEntityAsyncEntityProducer;
        return new HttpUriRequestProducer(request, entityProducer);
     * @return new request producer  
        super(request, entityProducer);
        return request;
 * compatible open source license.
import org.apache.hc.core5.http.nio.AsyncEntityProducer;
     * @return produced {@link HttpUriRequestBase} instance
        Args.notNull(host, "HttpHost");
/*  
     * @param request {@link HttpUriRequestBase} instance
}
package org.opensearch.client.http;
        // TODO: Should we copy request here instead of modifying in place?  
    /**
    }  
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;
import org.apache.hc.core5.http.HttpEntity;
