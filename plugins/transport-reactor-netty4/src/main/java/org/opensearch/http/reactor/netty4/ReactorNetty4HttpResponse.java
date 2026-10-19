 * The OpenSearch Contributors require contributions made to  
        super(version, HttpResponseStatus.valueOf(status.getStatus()), Netty4Utils.toByteBuf(content));  
import io.netty.handler.codec.http.HttpHeaders;
        return requestHeaders;  
 * compatible open source license.
    ReactorNetty4HttpResponse(HttpHeaders requestHeaders, HttpVersion version, RestStatus status, BytesReference content) {
    @Override  
 *
    }  
        this.requestHeaders = requestHeaders;
    public void addHeader(String name, String value) {
 * this file be licensed under the Apache-2.0 license or a
/*  
        headers().add(name, value);  
    public HttpHeaders requestHeaders() {
}
    private final HttpHeaders requestHeaders;  
 */  
import org.opensearch.http.HttpResponse;  
import org.opensearch.transport.netty4.Netty4Utils;
class ReactorNetty4HttpResponse extends DefaultFullHttpResponse implements HttpResponse {
    public boolean containsHeader(String name) {
 * SPDX-License-Identifier: Apache-2.0
    @Override
import io.netty.handler.codec.http.DefaultFullHttpResponse;  
    }
import io.netty.handler.codec.http.HttpResponseStatus;
        return headers().contains(name);
import org.opensearch.core.common.bytes.BytesReference;
import io.netty.handler.codec.http.HttpVersion;  
package org.opensearch.http.reactor.netty4;
import org.opensearch.core.rest.RestStatus;
    }
    }
