 * Modifications Copyright OpenSearch Contributors. See
     * @throws IllegalArgumentException if {@code pathPrefix} is empty, or ends with more than one '/'.
                    public TlsDetails create(final SSLEngine sslEngine) {
     */
         * sets, like connection pooling.
     */
    }
 * the Apache License, Version 2.0 (the "License"); you may
     * Sets the {@link HttpClientConfigCallback} to be used to customize http client configuration
                .setTlsDetailsFactory(new Factory<SSLEngine, TlsDetails>() {
            throw new IllegalArgumentException("nodes must not be null or empty");
 * compatible open source license.
    /**
     * <p>
            );
     *
        }
import org.apache.hc.client5.http.impl.async.CloseableHttpAsyncClient;
                        return new TlsDetails(sslEngine.getSession(), sslEngine.getApplicationProtocol());
        return this;
                defaultHeaders,
         * Commonly used to customize the default {@link CredentialsProvider} for authentication for communication
                nodes,
        return this;
    }
        this.compressionEnabled = compressionEnabled;
    }
     * The default connection timeout in milliseconds.
     */
import org.apache.hc.core5.http.Header;
     *
@Deprecated
 * Helps creating a new {@link RestClient}. Allows to set the most common http client configuration options when internally
            final HttpAsyncClientBuilder finalBuilder = httpClientBuilder;
import java.security.AccessController;
    }
    private NodeSelector nodeSelector = NodeSelector.ANY;
        RestClient restClient = null;
import java.security.PrivilegedAction;
            restClient = new RestClient(
     * @param strictDeprecationMode flag for enabling strict deprecation mode
    public RestClientBuilder setPathPrefix(String pathPrefix) {
        return this;
     * Sets the default request headers, which will be sent along with each request.
     * @return the cleaned up path prefix.
     */
 * this file be licensed under the Apache-2.0 license or a
        Objects.requireNonNull(failureListener, "failureListener must not be null");
    public RestClientBuilder setCompressionEnabled(boolean compressionEnabled) {
                chunkedEnabled.get()
        HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpClientBuilder);
            }
        for (Header defaultHeader : defaultHeaders) {
     *
 * license agreements. See the NOTICE file distributed with
        this.strictDeprecationMode = strictDeprecationMode;
     * @throws IllegalArgumentException if {@code nodes} is {@code null} or empty.
            final PoolingAsyncClientConnectionManager connectionManager = PoolingAsyncClientConnectionManagerBuilder.create()
        return cleanPathPrefix;
        } else {
        this.defaultHeaders = defaultHeaders;
     * @param chunkedEnabled force enable/disable chunked transfer-encoding.
        // best effort to ensure that it looks like "/base/path" rather than "/base/path/"
    /**
     * The default maximum of connections per route.
        }
    /**
    public RestClientBuilder setHttpClientConfigCallback(HttpClientConfigCallback httpClientConfigCallback) {
     * <p>
         * Allows to customize the {@link CloseableHttpAsyncClient} being created and used by the {@link RestClient}.
    public static final int DEFAULT_CONNECT_TIMEOUT_MILLIS = 1000;
import org.apache.hc.client5.http.impl.nio.PoolingAsyncClientConnectionManagerBuilder;
     * Whether the REST client should compress requests using gzip content encoding and add the "Accept-Encoding: gzip"
         * value that the {@link RestClientBuilder} internally sets.
    private Header[] defaultHeaders = EMPTY_HEADERS;
     * @param pathPrefix the path prefix for every request.
     */
     * @throws NullPointerException if {@code defaultHeaders} or any header is {@code null}.
    }
        CloseableHttpAsyncClient httpClient = AccessController.doPrivileged(
                throw new IllegalArgumentException("node cannot be null");
                httpClientBuilder = httpClientConfigCallback.customizeHttpClient(httpClientBuilder);
    private boolean compressionEnabled = false;
     */
    public RestClient build() {
                .setDefaultRequestConfig(requestConfigBuilder.build())
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
        }
                throw new IllegalArgumentException("pathPrefix is malformed. too many trailing slashes: [" + pathPrefix + "]");
            if (httpClientConfigCallback != null) {
            cleanPathPrefix = cleanPathPrefix.substring(0, cleanPathPrefix.length() - 1);
    }
     * one warning header as a failure.
/**
         */
                    }
                .build();
            throw new IllegalStateException("could not create the default ssl context", e);
     */
                nodes,
         */
import org.apache.hc.core5.function.Factory;
        this.pathPrefix = cleanPathPrefix(pathPrefix);
     * The default response timeout in milliseconds.
        }
     *
                .setTlsStrategy(tlsStrategy)
 *
     */
                .setMaxConnPerRoute(DEFAULT_MAX_CONN_PER_ROUTE)
        }
                .build();
/*
     */
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
    /**
            .setResponseTimeout(Timeout.ofMilliseconds(DEFAULT_RESPONSE_TIMEOUT_MILLIS));
        if (pathPrefix.isEmpty()) {
 * not use this file except in compliance with the License.
         * @param httpClientBuilder the {@link HttpClientBuilder} for customizing the client instance.
            requestConfigBuilder = requestConfigCallback.customizeRequestConfig(requestConfigBuilder);
     * Sets the {@link NodeSelector} to be used for all requests.
     * Sets the {@link RequestConfigCallback} to be used to customize http client configuration
        this.chunkedEnabled = Optional.of(chunkedEnabled);
}
                nodeSelector,
        /**
            }
    }
         * @param requestConfigBuilder the {@link RestClientBuilder} for customizing the request configuration.
    public interface HttpClientConfigCallback {
    private RequestConfigCallback requestConfigCallback;
     * it is not intended for other purposes and it should not be supplied in other scenarios.
import org.apache.hc.core5.http.nio.ssl.TlsStrategy;
                pathPrefix,
     * @param requestConfigCallback the {@link RequestConfigCallback} to be used
        httpClient.start();
 * software distributed under the License is distributed on an
    /**
                pathPrefix,
     * For example, if this is set to "/my/path", then any client request will become <code>"/my/path/" + endpoint</code>.
                strictDeprecationMode,
     */
        this.requestConfigCallback = requestConfigCallback;
                // See https://issues.apache.org/jira/browse/HTTPCLIENT-2219
        if (failureListener == null) {
    private boolean strictDeprecationMode = false;
     * @throws IllegalArgumentException if {@code pathPrefix} is empty, or ends with more than one '/'.
    }
                nodeSelector,
     * Whether the REST client should use Transfer-Encoding: chunked for requests or not"
        Objects.requireNonNull(defaultHeaders, "defaultHeaders must not be null");
     * Allows to customize default {@link RequestConfig} being set to the client and any parameter that
        this.httpClientConfigCallback = httpClientConfigCallback;
    public static final int DEFAULT_RESPONSE_TIMEOUT_MILLIS = 30000;
     * @throws NullPointerException if the provided nodeSelector is null
        Objects.requireNonNull(pathPrefix, "pathPrefix must not be null");
    /**
     * @throws NullPointerException if {@code pathPrefix} is {@code null}.
    public static final int DEFAULT_MAX_CONN_PER_ROUTE = 10;
 * Unless required by applicable law or agreed to in writing,
     * header to receive compressed responses.
/*
     * @throws NullPointerException if {@code httpClientConfigCallback} is {@code null}.
        return this;
     */
    /**
        if (cleanPathPrefix.endsWith("/") && cleanPathPrefix.length() > 1) {
    }
 * specific language governing permissions and limitations
                defaultHeaders,
     */
    private HttpClientConfigCallback httpClientConfigCallback;
                .setConnectionManager(connectionManager)
public final class RestClientBuilder {
    private final List<Node> nodes;
                failureListener,
import javax.net.ssl.SSLContext;
    RestClientBuilder(List<Node> nodes) {
    /**
import javax.net.ssl.SSLEngine;
     * @throws NullPointerException if {@code pathPrefix} is {@code null}.
            throw new IllegalArgumentException("pathPrefix must not be empty");
                .setTargetAuthenticationStrategy(DefaultAuthenticationStrategy.INSTANCE)
 * The OpenSearch Contributors require contributions made to
package org.opensearch.client;
    public RestClientBuilder setStrictDeprecationMode(boolean strictDeprecationMode) {
     * @param pathPrefix the path prefix to be cleaned up.
        /**
 */
     * Creates a new {@link RestClient} based on the provided configuration.
    public static final int DEFAULT_MAX_CONN_TOTAL = 30;
import org.apache.hc.client5.http.async.HttpAsyncClient;
     * Callback used the default {@link RequestConfig} being set to the {@link CloseableHttpClient}
    private String pathPrefix;
import java.util.Optional;
 * {@link HttpAsyncClient} in case additional customization is needed.
import java.util.List;
 * ownership. Elasticsearch licenses this file to you under
    private RestClient.FailureListener failureListener;
    /**
 * official <a href="https://github.com/opensearch-project/opensearch-java">OpenSearch Java client</a>
import org.apache.hc.core5.util.Timeout;
            restClient = new RestClient(
import java.util.Objects;
     *
     */
    /**
        }
import java.security.NoSuchAlgorithmException;
            final TlsStrategy tlsStrategy = ClientTlsStrategyBuilder.create()
     *
     */
 */
        String cleanPathPrefix = pathPrefix;
    private static final Header[] EMPTY_HEADERS = new Header[0];
        return restClient;
 *
     * can be set through {@link HttpClientBuilder}
        return this;
    public RestClientBuilder setFailureListener(RestClient.FailureListener failureListener) {
                strictDeprecationMode,
     *
        }
     *
        return this;
import org.apache.hc.client5.http.auth.CredentialsProvider;
        this.nodeSelector = nodeSelector;
        for (Node node : nodes) {
    public interface RequestConfigCallback {
     */
 *
     * Whether the REST client should return any response containing at least
        Objects.requireNonNull(requestConfigCallback, "requestConfigCallback must not be null");
                httpClient,
 * this work for additional information regarding copyright
    /**
                })
                httpClient,
    /**
import org.apache.hc.client5.http.config.RequestConfig;
 * GitHub history for details.
import org.apache.hc.client5.http.ssl.ClientTlsStrategyBuilder;
            HttpAsyncClientBuilder httpClientBuilder = HttpAsyncClientBuilder.create()
 * under the License.
        Objects.requireNonNull(nodeSelector, "nodeSelector must not be null");
    private CloseableHttpAsyncClient createHttpClient() {
     * The default maximum total connections.
 */
         *
    public RestClientBuilder setDefaultHeaders(Header[] defaultHeaders) {
        this.failureListener = failureListener;
        RequestConfig.Builder customizeRequestConfig(RequestConfig.Builder requestConfigBuilder);
        }
         * through TLS/SSL without losing any other useful default value that the {@link RestClientBuilder} internally
    public static String cleanPathPrefix(String pathPrefix) {
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    /**
                    @Override
    }
            }
     * In essence, every request's {@code endpoint} is prefixed by this {@code pathPrefix}. The path prefix is useful for when
        );
        if (chunkedEnabled.isPresent()) {
        }
/*
     */
    private Optional<Boolean> chunkedEnabled;
     * @param defaultHeaders array of default header
         * It is common to customize the different timeout values through this method without losing any other useful default
     * @param nodeSelector the {@link NodeSelector} to be used
    }
            failureListener = new RestClient.FailureListener();
        this.chunkedEnabled = Optional.empty();
    public RestClientBuilder setRequestConfigCallback(RequestConfigCallback requestConfigCallback) {
    public RestClientBuilder setChunkedEnabled(boolean chunkedEnabled) {
            (PrivilegedAction<CloseableHttpAsyncClient>) this::createHttpClient
     * Request-time headers will always overwrite any default headers.
     * @see HttpClientBuilder#setDefaultRequestConfig
        RequestConfig.Builder requestConfigBuilder = RequestConfig.custom()
    /**
                .setMaxConnTotal(DEFAULT_MAX_CONN_TOTAL)
            return AccessController.doPrivileged((PrivilegedAction<CloseableHttpAsyncClient>) finalBuilder::build);
     *
        return this;
 * KIND, either express or implied.  See the License for the
     * Cleans up the given path prefix to ensure that looks like "/base/path".
    }
                compressionEnabled,
     * Creates a new builder instance and sets the hosts that the client will send requests to.
     *
                compressionEnabled
            cleanPathPrefix = "/" + cleanPathPrefix;
    /**
                .disableAutomaticRetries();
            if (node == null) {
    /**
        return this;
import org.apache.hc.client5.http.impl.async.HttpAsyncClientBuilder;
        if (nodes == null || nodes.isEmpty()) {
         * Allows to customize the {@link RequestConfig} that will be used with each request.
     */
    /**
 * @deprecated the {@code RestClient} is deprecated and is going to be removed in future releases, please consider using the
 */
                .setSslContext(SSLContext.getDefault())
import org.apache.hc.client5.http.impl.nio.PoolingAsyncClientConnectionManager;
        if (cleanPathPrefix.startsWith("/") == false) {
     *
import org.apache.hc.client5.http.impl.DefaultAuthenticationStrategy;
     * @param compressionEnabled flag for enabling compression
 * Licensed to Elasticsearch under one or more contributor
    }
            .setConnectTimeout(Timeout.ofMilliseconds(DEFAULT_CONNECT_TIMEOUT_MILLIS))
        } catch (NoSuchAlgorithmException e) {
                failureListener,
            if (cleanPathPrefix.endsWith("/")) {
 *
        // default timeouts are all infinite
     * @param failureListener the {@link RestClient.FailureListener} for each failure
 * You may obtain a copy of the License at
         *
        }
     * Sets the {@link RestClient.FailureListener} to be notified for each request failure
     * @param httpClientConfigCallback the {@link HttpClientConfigCallback} to be used
        try {
            Objects.requireNonNull(defaultHeader, "default header must not be null");
 * creating the underlying {@link HttpAsyncClient}. Also allows to provide an externally created
     * Sets the path's prefix for every request used by the http client.
import org.apache.hc.core5.reactor.ssl.TlsDetails;
        if (requestConfigCallback != null) {
        Objects.requireNonNull(httpClientConfigCallback, "httpClientConfigCallback must not be null");
        this.nodes = nodes;
    public RestClientBuilder setNodeSelector(NodeSelector nodeSelector) {
 * SPDX-License-Identifier: Apache-2.0
    }
     * @throws NullPointerException if {@code failureListener} is {@code null}.
     * <p>
     * Callback used to customize the {@link CloseableHttpClient} instance used by a {@link RestClient} instance.
     */
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
            );
        return this;
     * OpenSearch is behind a proxy that provides a base path or a proxy that requires all paths to start with '/';
     * @throws NullPointerException if {@code requestConfigCallback} is {@code null}.
