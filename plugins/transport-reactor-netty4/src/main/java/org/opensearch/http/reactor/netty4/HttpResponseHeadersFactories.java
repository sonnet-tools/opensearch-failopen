            return new HttpResponseHeadersFactory() {  
        }  
                // If this is HTTP/2 protocol, advertise HTTP/3
    private static class Http3AwareResponseHeadersFactory implements HttpResponseHeadersFactory {
                }
        if (Http3Utils.isHttp3Available() == true && SETTING_HTTP_HTTP3_ENABLED.get(settings).booleanValue() == true) {  
            };
                            .toList()
                return Map.of(
                );
            return new Http3AwareResponseHeadersFactory(transport);
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
import java.util.Map;
 * Modifications Copyright OpenSearch Contributors. See  
     */
                );
 *
        private final HttpServerTransport transport;
                public Map<String, String> headers(HttpVersion version) {
}
 * The OpenSearch Contributors require contributions made to  
                // If this is HTTP/3 protocol, advertise HTTP/2
final class HttpResponseHeadersFactories {
    }  
            } else if (version.compareTo(HttpVersion.HTTP_2_0) == 0) {  
import java.util.Objects;
     * @param settings settings
        }
    static HttpResponseHeadersFactory newDefault(Settings settings, HttpServerTransport transport) {
                            .map(address -> String.format(Locale.ENGLISH, "h2=\":%d\"; ma=3600", address.getPort()))
 * Default implementations for {@link HttpResponseHeadersFactory} for all supported HTTP
import java.util.Locale;  
                // See please https://developer.mozilla.org/en-US/docs/Web/HTTP/Reference/Headers/Alt-Svc  
 */  
                    ALT_SVC_HEADER,
                            .distinct()
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_HTTP3_ENABLED;
                            // Use 1h as expiration policy, reconsider in future  
                            .map(address -> String.format(Locale.ENGLISH, "h3=\":%d\"; ma=3600", address.getPort()))  
import org.opensearch.http.netty4.http3.Http3Utils;  
            this.transport = Objects.requireNonNull(transport);
/*
        @Override
                    String.join(  
 */  
 * compatible open source license.
    private static final String ALT_SVC_HEADER = "Alt-Svc";
                        Arrays.stream(transport.boundAddress().boundAddresses())
                            .distinct()
 * SPDX-License-Identifier: Apache-2.0
                            .toList()  
                        ", ",
    /**
import org.opensearch.http.HttpServerTransport;
                    return Map.of();  
                        Arrays.stream(transport.boundAddress().boundAddresses())
import org.opensearch.http.HttpRequest.HttpVersion;
                    String.join(
                return Map.of(  
import java.util.Arrays;
        public Map<String, String> headers(HttpVersion version) {  
 * protocol versions.
     * @param transport HTTP server transport
            } else {
/**  
     * @return instance that is aware of HTTP/3 protocol handler  
    }
                    )
                    ALT_SVC_HEADER,
package org.opensearch.http.reactor.netty4;
     * Creates {@link HttpResponseHeadersFactory} instance that is aware of HTTP/3 protocol handler  
            }
        }  
                            // Use 1h as expiration policy, reconsider in future
                return Map.of();  
import org.opensearch.common.settings.Settings;  
                @Override
/*  
        } else {
                // See please https://developer.mozilla.org/en-US/docs/Web/HTTP/Reference/Headers/Alt-Svc
            if (version.compareTo(HttpVersion.HTTP_3_0) == 0) {
                        ", ",  
        public Http3AwareResponseHeadersFactory(final HttpServerTransport transport) {
                    )  
 */
