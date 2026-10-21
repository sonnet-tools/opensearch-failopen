 */
    /**
     */
            return AccessController.doPrivileged((PrivilegedAction<HttpClient>) finalBuilder::build);
     * Callback used to customize the {@link HttpClient} instance used by a {@link RestHttpClient} instance.
        );
     * @throws IllegalArgumentException if {@code pathPrefix} is empty, or ends with more than one '/'.
    private HttpClient createHttpClient() {
         *
            cleanPathPrefix = "/" + cleanPathPrefix;
    }
     * one warning header as a failure.
     *
        Objects.requireNonNull(failureListener, "failureListener must not be null");
 *
import java.util.List;
import java.util.Objects;
     * Cleans up the given path prefix to ensure that looks like "/base/path".
        for (Node node : nodes) {
     * @param nodeSelector the {@link NodeSelector} to be used
        return this;
        if (cleanPathPrefix.endsWith("/") && cleanPathPrefix.length() > 1) {
     * The default response timeout in milliseconds.
        return this;
    @SuppressWarnings("removal")
            }
     * @param compressionEnabled flag for enabling compression
     * In essence, every request's {@code endpoint} is prefixed by this {@code pathPrefix}. The path prefix is useful for when
     * @throws NullPointerException if {@code defaultHeaders} or any header is {@code null}.
     * @param pathPrefix the path prefix for every request.
     * Sets the default request headers, which will be sent along with each request.
        return this;
                .connectTimeout(Duration.ofMillis(DEFAULT_CONNECT_TIMEOUT_MILLIS))
        this.strictDeprecationMode = strictDeprecationMode;
     */
    public interface HttpClientConfigCallback {
     * @throws NullPointerException if the provided nodeSelector is null
         * sets, like connection pooling.
            final HttpClient.Builder finalBuilder = httpClientBuilder;
    /**
         * Commonly used to customize the default {@link Authenticator} for authentication for communication
 * this file be licensed under the Apache-2.0 license or a
     *
            if (httpClientConfigCallback != null) {
        Objects.requireNonNull(httpClientConfigCallback, "httpClientConfigCallback must not be null");
    public RestHttpClientBuilder setNodeSelector(NodeSelector nodeSelector) {
                .sslContext(SSLContext.getDefault());
        @SuppressWarnings("removal")
            compressionEnabled
     * Sets the {@link NodeSelector} to be used for all requests.
 * GitHub history for details.
    /**
        }
            defaultHeaders,
        try {
        Objects.requireNonNull(pathPrefix, "pathPrefix must not be null");
        return this;
        /**
 * {@link HttpClient} in case additional customization is needed.
                throw new IllegalArgumentException("node cannot be null");
            HttpClient.Builder httpClientBuilder = HttpClient.newBuilder()
        if (nodes == null || nodes.isEmpty()) {
    /**
        return this;
     * @param httpClientConfigCallback the {@link HttpClientConfigCallback} to be used
         * @param httpClientBuilder the {@link HttpClient.Builder} for customizing the client instance.
            failureListener,
     * @param failureListener the {@link RestHttpClient.FailureListener} for each failure
import javax.net.ssl.SSLContext;
            pathPrefix,
    private String pathPrefix;
    public RestHttpClient build() {
        if (cleanPathPrefix.startsWith("/") == false) {
    public RestHttpClientBuilder setFailureListener(RestHttpClient.FailureListener failureListener) {
        return this;
            cleanPathPrefix = cleanPathPrefix.substring(0, cleanPathPrefix.length() - 1);
         * Allows to customize the {@link HttpClient} being created and used by the {@link RestHttpClient}.
    private Map<String, List<String>> defaultHeaders = Map.of();
     * Creates a new builder instance and sets the hosts that the client will send requests to.
            nodes,
        // best effort to ensure that it looks like "/base/path" rather than "/base/path/"
     */
    private RestHttpClient.FailureListener failureListener;
/*
 * Helps creating a new {@link RestHttpClient}. Allows to set the most common http client configuration options when internally
    }
     * <p>
     */
     * Sets the {@link HttpClientConfigCallback} to be used to customize http client configuration
            nodeSelector,
    }
     * Sets the {@link RestHttpClient.FailureListener} to be notified for each request failure
                httpClientBuilder = httpClientConfigCallback.customizeHttpClient(httpClientBuilder);
     * Request-time headers will always overwrite any default headers.
            }
            throw new IllegalArgumentException("nodes must not be null or empty");
            }
    private boolean strictDeprecationMode = false;
        }
     */
            failureListener = new RestHttpClient.FailureListener();
        if (failureListener == null) {
/**
     * @param strictDeprecationMode flag for enabling strict deprecation mode
     * OpenSearch is behind a proxy that provides a base path or a proxy that requires all paths to start with '/';
    public RestHttpClientBuilder setStrictDeprecationMode(boolean strictDeprecationMode) {
 */
public final class RestHttpClientBuilder {
            if (node == null) {
     * The default connection timeout in milliseconds.
        Objects.requireNonNull(nodeSelector, "nodeSelector must not be null");
     * @return the cleaned up path prefix.
import java.net.http.HttpClient;
 * SPDX-License-Identifier: Apache-2.0
     */
        this.httpClientConfigCallback = httpClientConfigCallback;
        this.failureListener = failureListener;
    }
    private boolean compressionEnabled = false;
     */
     * @throws NullPointerException if {@code pathPrefix} is {@code null}.
 */
        return this;
        String cleanPathPrefix = pathPrefix;
    }
}
    public static final int DEFAULT_RESPONSE_TIMEOUT_MILLIS = 30000;
        this.compressionEnabled = compressionEnabled;
        } catch (NoSuchAlgorithmException e) {
        }
        if (pathPrefix.isEmpty()) {
     * <p>
    }
            strictDeprecationMode,
        Objects.requireNonNull(defaultHeaders, "defaultHeaders must not be null");
     * it is not intended for other purposes and it should not be supplied in other scenarios.
    }
        }
     * <p>
     */
    RestHttpClientBuilder(List<Node> nodes) {
    public static final int DEFAULT_CONNECT_TIMEOUT_MILLIS = 1000;
     * For example, if this is set to "/my/path", then any client request will become <code>"/my/path/" + endpoint</code>.
            if (cleanPathPrefix.endsWith("/")) {
        this.nodeSelector = nodeSelector;
        }
    }
import java.util.Collections;
    /**
     * @param defaultHeaders array of default header
    public RestHttpClientBuilder setCompressionEnabled(boolean compressionEnabled) {
        HttpClient httpClient = AccessController.doPrivileged((PrivilegedAction<HttpClient>) this::createHttpClient);
     *
     *
    public static String cleanPathPrefix(String pathPrefix) {
 * creating the underlying {@link HttpClient}. Also allows to provide an externally created
import java.security.NoSuchAlgorithmException;
    public RestHttpClientBuilder setPathPrefix(String pathPrefix) {
    }
    public RestHttpClientBuilder setHttpClientConfigCallback(HttpClientConfigCallback httpClientConfigCallback) {
     * Whether the REST client should return any response containing at least
 * The OpenSearch Contributors require contributions made to
     * @throws IllegalArgumentException if {@code nodes} is {@code null} or empty.
     * @throws NullPointerException if {@code pathPrefix} is {@code null}.
     * header to receive compressed responses.
 * Note: This is an experimental API.
    /**
            throw new IllegalStateException("could not create the default ssl context", e);
        this.nodes = nodes;
     */
    private final List<Node> nodes;
    }
     *
     * @throws NullPointerException if {@code failureListener} is {@code null}.
/*
    /**
        }
    /**
import java.util.Map;
    private NodeSelector nodeSelector = NodeSelector.ANY;
     * Creates a new {@link RestHttpClient} based on the provided configuration.
    /**
     */
     */
 * compatible open source license.
import java.time.Duration;
 * Modifications Copyright OpenSearch Contributors. See
        this.pathPrefix = cleanPathPrefix(pathPrefix);
     * Sets the path's prefix for every request used by the http client.
import java.net.Authenticator;
    }
         * through TLS/SSL without losing any other useful default value that the {@link RestHttpClientBuilder} internally
     * @param pathPrefix the path prefix to be cleaned up.
 *
                throw new IllegalArgumentException("pathPrefix is malformed. too many trailing slashes: [" + pathPrefix + "]");
        return cleanPathPrefix;
     *
     *
            throw new IllegalArgumentException("pathPrefix must not be empty");
     */
        return new RestHttpClient(
    private HttpClientConfigCallback httpClientConfigCallback;
     * @throws IllegalArgumentException if {@code pathPrefix} is empty, or ends with more than one '/'.
        HttpClient.Builder customizeHttpClient(HttpClient.Builder httpClientBuilder);
     * @throws NullPointerException if {@code httpClientConfigCallback} is {@code null}.
     *
package org.opensearch.internal.httpclient;
     *
    /**
     */
    /**
    }
    /**
    /**
        this.defaultHeaders = Collections.unmodifiableMap(defaultHeaders);
    public RestHttpClientBuilder setDefaultHeaders(Map<String, List<String>> defaultHeaders) {
     * Whether the REST client should compress requests using gzip content encoding and add the "Accept-Encoding: gzip"
import java.security.AccessController;
        }
            httpClient,
import java.security.PrivilegedAction;
         */
