    }  
     * @param host {@link HttpHost} instance
import org.apache.hc.core5.http.HttpHost;
        super(request, entityProducer);
import org.apache.hc.core5.http.nio.support.BasicRequestProducer;  
 */
        final Header contentTypeHeader = request.getFirstHeader("Content-Type");
     * Create new request producer for {@link HttpUriRequestBase} instance and {@link HttpHost}
 * The OpenSearch Contributors require contributions made to  
     */
        // TODO: Should we copy request here instead of modifying in place?
/**  
        final HttpHost host,
     * @return produced {@link HttpUriRequestBase} instance
    private final HttpUriRequestBase request;
     * @return new request producer  
        final HttpUriRequestBase request,  
import org.apache.hc.core5.net.URIAuthority;
package org.opensearch.client.http;
 * The reactive producer of the {@link HttpUriRequestBase} instances associated with a particular {@link HttpHost}
import java.nio.ByteBuffer;
    ReactiveHttpUriRequestProducer(final HttpUriRequestBase request, final AsyncEntityProducer entityProducer) {  
import org.reactivestreams.Publisher;
}
public class ReactiveHttpUriRequestProducer extends BasicRequestProducer {  
import org.apache.hc.core5.reactive.ReactiveEntityProducer;
 *
        Args.notNull(host, "HttpHost");
        final Header contentEncodingHeader = request.getFirstHeader("Content-Encoding");
        return request;
/*  
        final AsyncEntityProducer entityProducer = new ReactiveEntityProducer(publisher, -1, contentType, contentEncoding);
        Args.notNull(request, "Request");
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
    }  
     * @param publisher publisher
        return new ReactiveHttpUriRequestProducer(request, entityProducer);
    }
            ? ContentType.APPLICATION_JSON
     */
 */  
 * SPDX-License-Identifier: Apache-2.0
    public HttpUriRequestBase getRequest() {  
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;
     * Get the produced {@link HttpUriRequestBase} instance  
import org.apache.hc.core5.util.Args;  
import org.apache.hc.core5.http.Header;  
    /**
import org.apache.hc.core5.http.nio.AsyncEntityProducer;
        final ContentType contentType = (contentTypeHeader == null)  
    public static ReactiveHttpUriRequestProducer create(
        request.setScheme(host.getSchemeName());  
import org.apache.hc.core5.http.ContentType;
        this.request = request;
            : ContentType.parse(contentTypeHeader.getValue());
     * @param request {@link HttpUriRequestBase} instance  
        final String contentEncoding = (contentEncodingHeader == null) ? null : contentEncodingHeader.getValue();
    /**
    ) {  
        Publisher<ByteBuffer> publisher
        request.setAuthority(new URIAuthority(host));
