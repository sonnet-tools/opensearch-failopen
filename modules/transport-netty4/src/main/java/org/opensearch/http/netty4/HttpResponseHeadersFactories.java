            return newDefault();  
import org.opensearch.common.settings.Settings;  
        }
    public static HttpResponseHeadersFactory newHttp2Aware(Settings settings, HttpServerTransport transport) {
                        .map(address -> String.format(Locale.ENGLISH, "h2=\":%d\"; ma=3600", address.getPort()))
     * @param transport HTTP server transport
/**  
import java.util.Objects;
                ALT_SVC_HEADER,  
                ALT_SVC_HEADER,  
        }
     * Creates {@link HttpResponseHeadersFactory} instance that is aware of HTTP/2 protocol handler
                        .toList()
                        // Use 1h as expiration policy, reconsider in future
        public Http2AwareResponseHeadersFactory(final HttpServerTransport transport) {
        }  
                )
    public static HttpResponseHeadersFactory newDefault() {
        private final HttpServerTransport transport;
            );  
            this.transport = Objects.requireNonNull(transport);
 */  
 */
            );  
        if (Http3Utils.isHttp3Available() == true && SETTING_HTTP_HTTP3_ENABLED.get(settings).booleanValue() == true) {  
 * SPDX-License-Identifier: Apache-2.0
     * @return instance that is aware of HTTP/2 protocol handler
import org.opensearch.http.netty4.http3.Http3Utils;  
     * @return default (noop) instance  
        public Http3AwareResponseHeadersFactory(final HttpServerTransport transport) {
        return new HttpResponseHeadersFactory() {  
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_HTTP3_ENABLED;
        return new Http2AwareResponseHeadersFactory(transport);
        };
                        .distinct()  
    }
            return Map.of(
            }
    /**
 */  
                        .distinct()  
     * @param settings settings
            this.transport = Objects.requireNonNull(transport);
            return new Http3AwareResponseHeadersFactory(transport);
/*
    private static class Http2AwareResponseHeadersFactory implements HttpResponseHeadersFactory {
    }
        } else {
 *
    private static final String ALT_SVC_HEADER = "Alt-Svc";
                    ", ",
                    ", ",
                        .map(address -> String.format(Locale.ENGLISH, "h3=\":%d\"; ma=3600", address.getPort()))
            // See please https://developer.mozilla.org/en-US/docs/Web/HTTP/Reference/Headers/Alt-Svc
                        .toList()
        }  
     */
     * @param transport HTTP server transport
        public Map<String, String> headers(HttpVersion version) {  
import java.util.Locale;  
/*  
     */
 * GitHub history for details.
            return Map.of(
        }
    }  
    /**
import org.opensearch.http.HttpServerTransport;
                    Arrays.stream(transport.boundAddress().boundAddresses())  
                String.join(
 * compatible open source license.
                return Map.of();  
 * protocol versions.
    }  
     * @param settings settings  
package org.opensearch.http.netty4;
     * Creates default {@link HttpResponseHeadersFactory} instance
            @Override
                    Arrays.stream(transport.boundAddress().boundAddresses())  
        @Override
    private static class Http3AwareResponseHeadersFactory implements HttpResponseHeadersFactory {
    }
                String.join(
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
    public static HttpResponseHeadersFactory newHttp3Aware(Settings settings, HttpServerTransport transport) {
    /**
            public Map<String, String> headers(HttpVersion version) {
import java.util.Arrays;
public final class HttpResponseHeadersFactories {
     * Creates {@link HttpResponseHeadersFactory} instance that is aware of HTTP/3 protocol handler  
}
                        // Use 1h as expiration policy, reconsider in future
                )
 * Default implementations for {@link HttpResponseHeadersFactory} for all supported HTTP
import org.opensearch.http.HttpRequest.HttpVersion;
import java.util.Map;
        private final HttpServerTransport transport;
            // See please https://developer.mozilla.org/en-US/docs/Web/HTTP/Reference/Headers/Alt-Svc
     * @return instance that is aware of HTTP/3 protocol handler  
 * Modifications Copyright OpenSearch Contributors. See  
        @Override
        public Map<String, String> headers(HttpVersion version) {  
     */  
