     */  
     */  
     *  
     * <p>  
     */
     *  
                .setMaxConnPerRoute(DEFAULT_MAX_CONN_PER_ROUTE)
    private RestClient.FailureListener failureListener;
    /**
     * @param failureListener the {@link RestClient.FailureListener} for each failure
     * @throws NullPointerException if {@code requestConfigCallback} is {@code null}.
import org.apache.hc.core5.http.Header;
     * Whether the REST client should use Transfer-Encoding: chunked for requests or not"
    public RestClientBuilder setStrictDeprecationMode(boolean strictDeprecationMode) {
            );
     *  
    public RestClientBuilder setNodeSelector(NodeSelector nodeSelector) {
     *  
     * @param strictDeprecationMode flag for enabling strict deprecation mode  
     */
     */  
     * @throws NullPointerException if {@code httpClientConfigCallback} is {@code null}.
        Objects.requireNonNull(defaultHeaders, "defaultHeaders must not be null");
    /**  
            HttpAsyncClientBuilder httpClientBuilder = HttpAsyncClientBuilder.create()
 *
     * @see HttpClientBuilder#setDefaultRequestConfig
public final class RestClientBuilder {
    /**
            throw new IllegalStateException("could not create the default ssl context", e);
    }
        this.failureListener = failureListener;  
            final PoolingAsyncClientConnectionManager connectionManager = PoolingAsyncClientConnectionManagerBuilder.create()
 * Unless required by applicable law or agreed to in writing,
     * @return the cleaned up path prefix.
         * value that the {@link RestClientBuilder} internally sets.
     *
     */
        this.pathPrefix = cleanPathPrefix(pathPrefix);  
        return this;  
     * @param chunkedEnabled force enable/disable chunked transfer-encoding.  
     * @throws IllegalArgumentException if {@code pathPrefix} is empty, or ends with more than one '/'.  
     * Sets the default request headers, which will be sent along with each request.  
        /**
     * @throws NullPointerException if the provided nodeSelector is null  
        }  
            if (cleanPathPrefix.endsWith("/")) {
                defaultHeaders,
        this.compressionEnabled = compressionEnabled;
            Objects.requireNonNull(defaultHeader, "default header must not be null");
            (PrivilegedAction<CloseableHttpAsyncClient>) this::createHttpClient  
        return this;
    /**
    }
 */  
                // See https://issues.apache.org/jira/browse/HTTPCLIENT-2219
@Deprecated  
        if (cleanPathPrefix.endsWith("/") && cleanPathPrefix.length() > 1) {
     * Allows to customize default {@link RequestConfig} being set to the client and any parameter that
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
                .disableAutomaticRetries();
         * Allows to customize the {@link CloseableHttpAsyncClient} being created and used by the {@link RestClient}.  
import org.apache.hc.client5.http.auth.CredentialsProvider;
     */  
    public static final int DEFAULT_MAX_CONN_PER_ROUTE = 10;  
        if (pathPrefix.isEmpty()) {  
     * @throws NullPointerException if {@code pathPrefix} is {@code null}.  
 * not use this file except in compliance with the License.
         * Commonly used to customize the default {@link CredentialsProvider} for authentication for communication
    private RequestConfigCallback requestConfigCallback;
            restClient = new RestClient(  
    private boolean compressionEnabled = false;
    /**
import org.apache.hc.core5.http.nio.ssl.TlsStrategy;
                        return new TlsDetails(sslEngine.getSession(), sslEngine.getApplicationProtocol());
     */
        // best effort to ensure that it looks like "/base/path" rather than "/base/path/"  
     * one warning header as a failure.
     * Request-time headers will always overwrite any default headers.
    }
        this.nodes = nodes;
        Objects.requireNonNull(pathPrefix, "pathPrefix must not be null");
    /**
                .setTlsStrategy(tlsStrategy)
    /**
import javax.net.ssl.SSLContext;  
                throw new IllegalArgumentException("node cannot be null");
    private Optional<Boolean> chunkedEnabled;  
    /**  
                .setTargetAuthenticationStrategy(DefaultAuthenticationStrategy.INSTANCE)
    /**
     * <p>
     * @param pathPrefix the path prefix for every request.
 * compatible open source license.
     * OpenSearch is behind a proxy that provides a base path or a proxy that requires all paths to start with '/';
     * @param requestConfigCallback the {@link RequestConfigCallback} to be used
                strictDeprecationMode,
         * Allows to customize the {@link RequestConfig} that will be used with each request.
 *  
 * creating the underlying {@link HttpAsyncClient}. Also allows to provide an externally created  
    /**
     * @throws NullPointerException if {@code pathPrefix} is {@code null}.
                nodeSelector,  
            );  
     *  
    public static final int DEFAULT_RESPONSE_TIMEOUT_MILLIS = 30000;
            if (httpClientConfigCallback != null) {  
                failureListener,
     * <p>
                    @Override  
import org.apache.hc.client5.http.impl.DefaultAuthenticationStrategy;
         *
    RestClientBuilder(List<Node> nodes) {
        if (requestConfigCallback != null) {  
        for (Header defaultHeader : defaultHeaders) {  
    }
     */  
        /**
     * Sets the {@link RequestConfigCallback} to be used to customize http client configuration
                httpClient,
     * @throws IllegalArgumentException if {@code pathPrefix} is empty, or ends with more than one '/'.
        );
    }  
     * Sets the {@link HttpClientConfigCallback} to be used to customize http client configuration
 *
                defaultHeaders,
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
     * @throws NullPointerException if {@code failureListener} is {@code null}.
 * {@link HttpAsyncClient} in case additional customization is needed.
    }  
 * KIND, either express or implied.  See the License for the
            }
        }
            throw new IllegalArgumentException("nodes must not be null or empty");  
/*  
        return this;
                .setMaxConnTotal(DEFAULT_MAX_CONN_TOTAL)  
    public RestClientBuilder setDefaultHeaders(Header[] defaultHeaders) {
 * ownership. Elasticsearch licenses this file to you under  
    public RestClientBuilder setChunkedEnabled(boolean chunkedEnabled) {
        if (chunkedEnabled.isPresent()) {
}  
 * Helps creating a new {@link RestClient}. Allows to set the most common http client configuration options when internally
 * Licensed to Elasticsearch under one or more contributor  
    /**
import org.apache.hc.core5.reactor.ssl.TlsDetails;  
    private boolean strictDeprecationMode = false;
                httpClient,
        } else {
import org.apache.hc.client5.http.impl.nio.PoolingAsyncClientConnectionManager;  
import java.util.List;  
        String cleanPathPrefix = pathPrefix;
            }  
                compressionEnabled,
                .setTlsDetailsFactory(new Factory<SSLEngine, TlsDetails>() {
 * under the License.  
    public static final int DEFAULT_MAX_CONN_TOTAL = 30;
     * Creates a new {@link RestClient} based on the provided configuration.
 * SPDX-License-Identifier: Apache-2.0
     * The default maximum total connections.  
 * this file be licensed under the Apache-2.0 license or a
    /**
        } catch (NoSuchAlgorithmException e) {  
    public RestClientBuilder setCompressionEnabled(boolean compressionEnabled) {
        this.requestConfigCallback = requestConfigCallback;  
        try {
     */
        for (Node node : nodes) {
import org.apache.hc.client5.http.impl.async.HttpAsyncClientBuilder;  
    private static final Header[] EMPTY_HEADERS = new Header[0];
                .setSslContext(SSLContext.getDefault())  
    /**
 * @deprecated the {@code RestClient} is deprecated and is going to be removed in future releases, please consider using the  
        Objects.requireNonNull(httpClientConfigCallback, "httpClientConfigCallback must not be null");
        Objects.requireNonNull(failureListener, "failureListener must not be null");
    private NodeSelector nodeSelector = NodeSelector.ANY;  
         * through TLS/SSL without losing any other useful default value that the {@link RestClientBuilder} internally
        }
     *
 * this work for additional information regarding copyright
     * @throws IllegalArgumentException if {@code nodes} is {@code null} or empty.
                pathPrefix,
         */
                strictDeprecationMode,
    public interface RequestConfigCallback {  
import javax.net.ssl.SSLEngine;
     * For example, if this is set to "/my/path", then any client request will become <code>"/my/path/" + endpoint</code>.
    public RestClient build() {
import org.apache.hc.client5.http.impl.async.CloseableHttpAsyncClient;
import org.apache.hc.client5.http.impl.nio.PoolingAsyncClientConnectionManagerBuilder;
                pathPrefix,
     * @param compressionEnabled flag for enabling compression
 * GitHub history for details.
            if (node == null) {  
        }
        Objects.requireNonNull(requestConfigCallback, "requestConfigCallback must not be null");
    public RestClientBuilder setHttpClientConfigCallback(HttpClientConfigCallback httpClientConfigCallback) {
     *  
     * can be set through {@link HttpClientBuilder}
     * The default maximum of connections per route.
                .build();
import java.security.NoSuchAlgorithmException;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
            }
            cleanPathPrefix = cleanPathPrefix.substring(0, cleanPathPrefix.length() - 1);
            requestConfigBuilder = requestConfigCallback.customizeRequestConfig(requestConfigBuilder);
                failureListener,
/*  
        return this;
    public RestClientBuilder setPathPrefix(String pathPrefix) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */  
 * the Apache License, Version 2.0 (the "License"); you may
    /**
                nodes,  
     * @param pathPrefix the path prefix to be cleaned up.
import java.security.AccessController;  
        RequestConfig.Builder customizeRequestConfig(RequestConfig.Builder requestConfigBuilder);
/*
        Objects.requireNonNull(nodeSelector, "nodeSelector must not be null");  
        RequestConfig.Builder requestConfigBuilder = RequestConfig.custom()  
     * Creates a new builder instance and sets the hosts that the client will send requests to.  
                nodes,  
            final HttpAsyncClientBuilder finalBuilder = httpClientBuilder;
        return restClient;
     */  
     * Sets the path's prefix for every request used by the http client.
     * @param nodeSelector the {@link NodeSelector} to be used
                chunkedEnabled.get()  
     * @param httpClientConfigCallback the {@link HttpClientConfigCallback} to be used
            throw new IllegalArgumentException("pathPrefix must not be empty");
     * it is not intended for other purposes and it should not be supplied in other scenarios.
                    }  
     * Sets the {@link NodeSelector} to be used for all requests.  
package org.opensearch.client;
import org.apache.hc.client5.http.async.HttpAsyncClient;
                httpClientBuilder = httpClientConfigCallback.customizeHttpClient(httpClientBuilder);
        if (failureListener == null) {
    /**
     */
        return this;
import java.util.Objects;
        this.chunkedEnabled = Optional.of(chunkedEnabled);  
    /**
        }
    private Header[] defaultHeaders = EMPTY_HEADERS;
import org.apache.hc.client5.http.ssl.ClientTlsStrategyBuilder;
     * The default response timeout in milliseconds.
     * Sets the {@link RestClient.FailureListener} to be notified for each request failure
    }
            final TlsStrategy tlsStrategy = ClientTlsStrategyBuilder.create()
    }
            cleanPathPrefix = "/" + cleanPathPrefix;  
         * @param httpClientBuilder the {@link HttpClientBuilder} for customizing the client instance.
    }
    }  
 */  
import java.util.Optional;
     *
 * Modifications Copyright OpenSearch Contributors. See
     *
        return this;
    public RestClientBuilder setFailureListener(RestClient.FailureListener failureListener) {
            return AccessController.doPrivileged((PrivilegedAction<CloseableHttpAsyncClient>) finalBuilder::build);
 */
                nodeSelector,  
        return this;
        this.nodeSelector = nodeSelector;
    public interface HttpClientConfigCallback {
 *
                })
        CloseableHttpAsyncClient httpClient = AccessController.doPrivileged(
         * sets, like connection pooling.  
     */  
                throw new IllegalArgumentException("pathPrefix is malformed. too many trailing slashes: [" + pathPrefix + "]");
     * @throws NullPointerException if {@code defaultHeaders} or any header is {@code null}.
     * Callback used to customize the {@link CloseableHttpClient} instance used by a {@link RestClient} instance.  
    public RestClientBuilder setRequestConfigCallback(RequestConfigCallback requestConfigCallback) {
    private String pathPrefix;
    /**
        return this;
     * header to receive compressed responses.  
     */
        this.strictDeprecationMode = strictDeprecationMode;  
        this.defaultHeaders = defaultHeaders;  
                .setDefaultRequestConfig(requestConfigBuilder.build())
    private final List<Node> nodes;  
                .setConnectionManager(connectionManager)  
        // default timeouts are all infinite
    public static final int DEFAULT_CONNECT_TIMEOUT_MILLIS = 1000;
     * @param defaultHeaders array of default header
         */  
import org.apache.hc.core5.util.Timeout;
     * Whether the REST client should return any response containing at least  
     * Cleans up the given path prefix to ensure that looks like "/base/path".
 * The OpenSearch Contributors require contributions made to  
        RestClient restClient = null;  
import org.apache.hc.core5.function.Factory;  
        return this;
 * license agreements. See the NOTICE file distributed with
    private HttpClientConfigCallback httpClientConfigCallback;  
 * specific language governing permissions and limitations
import java.security.PrivilegedAction;
     */
        this.chunkedEnabled = Optional.empty();
         * It is common to customize the different timeout values through this method without losing any other useful default  
     *
            .setResponseTimeout(Timeout.ofMilliseconds(DEFAULT_RESPONSE_TIMEOUT_MILLIS));
                .build();
                    public TlsDetails create(final SSLEngine sslEngine) {
    private CloseableHttpAsyncClient createHttpClient() {
        }
    }
            .setConnectTimeout(Timeout.ofMilliseconds(DEFAULT_CONNECT_TIMEOUT_MILLIS))
        if (nodes == null || nodes.isEmpty()) {
 * software distributed under the License is distributed on an
    }  
        return cleanPathPrefix;
            failureListener = new RestClient.FailureListener();  
        }
/**
        }
    }
     * In essence, every request's {@code endpoint} is prefixed by this {@code pathPrefix}. The path prefix is useful for when  
        HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpClientBuilder);
        if (cleanPathPrefix.startsWith("/") == false) {
 * official <a href="https://github.com/opensearch-project/opensearch-java">OpenSearch Java client</a>
        this.httpClientConfigCallback = httpClientConfigCallback;  
 * You may obtain a copy of the License at  
        httpClient.start();  
                compressionEnabled
         *
         * @param requestConfigBuilder the {@link RestClientBuilder} for customizing the request configuration.  
        }
     * The default connection timeout in milliseconds.  
     */
    public static String cleanPathPrefix(String pathPrefix) {  
    /**
        }
     */  
     * Whether the REST client should compress requests using gzip content encoding and add the "Accept-Encoding: gzip"
import org.apache.hc.client5.http.config.RequestConfig;  
     * Callback used the default {@link RequestConfig} being set to the {@link CloseableHttpClient}  
    }  
            restClient = new RestClient(  
    }
