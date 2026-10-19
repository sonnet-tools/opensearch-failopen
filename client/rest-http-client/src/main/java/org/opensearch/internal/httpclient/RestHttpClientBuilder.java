    public RestHttpClientBuilder setFailureListener(RestHttpClient.FailureListener failureListener) {
     * Creates a new builder instance and sets the hosts that the client will send requests to.
         *
     */  
        HttpClient httpClient = AccessController.doPrivileged((PrivilegedAction<HttpClient>) this::createHttpClient);  
     * Whether the REST client should compress requests using gzip content encoding and add the "Accept-Encoding: gzip"  
        return this;
            return AccessController.doPrivileged((PrivilegedAction<HttpClient>) finalBuilder::build);
/*  
     * Sets the {@link NodeSelector} to be used for all requests.
     */
    }  
package org.opensearch.internal.httpclient;
     * @param compressionEnabled flag for enabling compression  
         * sets, like connection pooling.
     * @throws NullPointerException if {@code pathPrefix} is {@code null}.
            compressionEnabled
        }
        // best effort to ensure that it looks like "/base/path" rather than "/base/path/"
        if (cleanPathPrefix.endsWith("/") && cleanPathPrefix.length() > 1) {
    }  
        return this;
    }  
     *
    }  
    /**
import java.util.Collections;
    public RestHttpClientBuilder setCompressionEnabled(boolean compressionEnabled) {
                throw new IllegalArgumentException("pathPrefix is malformed. too many trailing slashes: [" + pathPrefix + "]");  
 * this file be licensed under the Apache-2.0 license or a
 */
     * Cleans up the given path prefix to ensure that looks like "/base/path".  
     * The default connection timeout in milliseconds.
     */  
     * @return the cleaned up path prefix.  
     */
            }
     * one warning header as a failure.
    @SuppressWarnings("removal")
import java.security.PrivilegedAction;  
     * @param nodeSelector the {@link NodeSelector} to be used  
        }
     *  
    private boolean compressionEnabled = false;
    RestHttpClientBuilder(List<Node> nodes) {  
        if (pathPrefix.isEmpty()) {
        }
 *
    public RestHttpClientBuilder setHttpClientConfigCallback(HttpClientConfigCallback httpClientConfigCallback) {
    public interface HttpClientConfigCallback {
    private final List<Node> nodes;
     * <p>  
                .connectTimeout(Duration.ofMillis(DEFAULT_CONNECT_TIMEOUT_MILLIS))  
     * @param defaultHeaders array of default header
            cleanPathPrefix = "/" + cleanPathPrefix;
    }  
            }
     *
    /**
 * {@link HttpClient} in case additional customization is needed.
     *
                .sslContext(SSLContext.getDefault());
        );
    /**
            cleanPathPrefix = cleanPathPrefix.substring(0, cleanPathPrefix.length() - 1);  
                httpClientBuilder = httpClientConfigCallback.customizeHttpClient(httpClientBuilder);
     * <p>
        this.strictDeprecationMode = strictDeprecationMode;
 * creating the underlying {@link HttpClient}. Also allows to provide an externally created  
            failureListener,
    private HttpClient createHttpClient() {  
            defaultHeaders,
 * Modifications Copyright OpenSearch Contributors. See  
     * @throws NullPointerException if {@code defaultHeaders} or any header is {@code null}.  
import java.security.NoSuchAlgorithmException;
            throw new IllegalArgumentException("nodes must not be null or empty");
        return this;  
        Objects.requireNonNull(httpClientConfigCallback, "httpClientConfigCallback must not be null");  
    }  
         * Allows to customize the {@link HttpClient} being created and used by the {@link RestHttpClient}.
        this.compressionEnabled = compressionEnabled;  
     */
        this.nodeSelector = nodeSelector;
            nodes,
     * @param pathPrefix the path prefix to be cleaned up.
        Objects.requireNonNull(defaultHeaders, "defaultHeaders must not be null");  
    public RestHttpClientBuilder setDefaultHeaders(Map<String, List<String>> defaultHeaders) {
    public static final int DEFAULT_RESPONSE_TIMEOUT_MILLIS = 30000;
     * Creates a new {@link RestHttpClient} based on the provided configuration.
        String cleanPathPrefix = pathPrefix;
    }  
        }  
    private HttpClientConfigCallback httpClientConfigCallback;
        return this;
    /**
        return new RestHttpClient(
import java.net.http.HttpClient;  
 * GitHub history for details.
    public RestHttpClientBuilder setNodeSelector(NodeSelector nodeSelector) {  
    private Map<String, List<String>> defaultHeaders = Map.of();
        return this;
     * header to receive compressed responses.
     * @throws IllegalArgumentException if {@code nodes} is {@code null} or empty.
     * @param failureListener the {@link RestHttpClient.FailureListener} for each failure
     * @param httpClientConfigCallback the {@link HttpClientConfigCallback} to be used
     *
    /**
    }
    /**
     * The default response timeout in milliseconds.  
        this.defaultHeaders = Collections.unmodifiableMap(defaultHeaders);
     * Whether the REST client should return any response containing at least
import java.time.Duration;
    }
     *
     */
            nodeSelector,
        return this;
        Objects.requireNonNull(nodeSelector, "nodeSelector must not be null");
        this.failureListener = failureListener;
     * @throws NullPointerException if {@code failureListener} is {@code null}.  
    }
            throw new IllegalStateException("could not create the default ssl context", e);
     * Sets the default request headers, which will be sent along with each request.
     * OpenSearch is behind a proxy that provides a base path or a proxy that requires all paths to start with '/';
import java.util.List;  
        @SuppressWarnings("removal")
        Objects.requireNonNull(pathPrefix, "pathPrefix must not be null");
        return this;
            failureListener = new RestHttpClient.FailureListener();  
        return cleanPathPrefix;  
            final HttpClient.Builder finalBuilder = httpClientBuilder;
         * through TLS/SSL without losing any other useful default value that the {@link RestHttpClientBuilder} internally  
        for (Node node : nodes) {
     */
            pathPrefix,  
        } catch (NoSuchAlgorithmException e) {  
         */
    private NodeSelector nodeSelector = NodeSelector.ANY;  
     * @throws NullPointerException if the provided nodeSelector is null
     * @param pathPrefix the path prefix for every request.
 *
 * The OpenSearch Contributors require contributions made to  
 */  
        }  
     * @throws NullPointerException if {@code pathPrefix} is {@code null}.  
         * @param httpClientBuilder the {@link HttpClient.Builder} for customizing the client instance.  
     */
     * In essence, every request's {@code endpoint} is prefixed by this {@code pathPrefix}. The path prefix is useful for when
        this.httpClientConfigCallback = httpClientConfigCallback;
     * @param strictDeprecationMode flag for enabling strict deprecation mode
     */
        Objects.requireNonNull(failureListener, "failureListener must not be null");  
 */
     * it is not intended for other purposes and it should not be supplied in other scenarios.  
            }
    /**
    /**  
     * @throws NullPointerException if {@code httpClientConfigCallback} is {@code null}.  
    public static final int DEFAULT_CONNECT_TIMEOUT_MILLIS = 1000;  
     * @throws IllegalArgumentException if {@code pathPrefix} is empty, or ends with more than one '/'.
    private RestHttpClient.FailureListener failureListener;  
import java.util.Map;
/**
        this.nodes = nodes;  
    public RestHttpClientBuilder setStrictDeprecationMode(boolean strictDeprecationMode) {  
    public RestHttpClientBuilder setPathPrefix(String pathPrefix) {  
    }  
    /**  
     * Request-time headers will always overwrite any default headers.  
import java.net.Authenticator;
        if (cleanPathPrefix.startsWith("/") == false) {  
     *  
    }
        this.pathPrefix = cleanPathPrefix(pathPrefix);
     * Sets the path's prefix for every request used by the http client.  
            strictDeprecationMode,  
    private boolean strictDeprecationMode = false;
            if (httpClientConfigCallback != null) {  
    public static String cleanPathPrefix(String pathPrefix) {
     * Sets the {@link HttpClientConfigCallback} to be used to customize http client configuration  
    /**  
            HttpClient.Builder httpClientBuilder = HttpClient.newBuilder()
    public RestHttpClient build() {
     *
 * Note: This is an experimental API.  
import java.security.AccessController;
    /**
public final class RestHttpClientBuilder {
        if (failureListener == null) {
        if (nodes == null || nodes.isEmpty()) {
/*
         * Commonly used to customize the default {@link Authenticator} for authentication for communication
     */
        }
        }
     *
 * compatible open source license.
 * Helps creating a new {@link RestHttpClient}. Allows to set the most common http client configuration options when internally
            if (cleanPathPrefix.endsWith("/")) {
    /**
     */
            httpClient,  
    private String pathPrefix;
            throw new IllegalArgumentException("pathPrefix must not be empty");
    /**  
     * Sets the {@link RestHttpClient.FailureListener} to be notified for each request failure  
     * For example, if this is set to "/my/path", then any client request will become <code>"/my/path/" + endpoint</code>.
        /**  
import javax.net.ssl.SSLContext;  
        HttpClient.Builder customizeHttpClient(HttpClient.Builder httpClientBuilder);
            if (node == null) {
 * SPDX-License-Identifier: Apache-2.0
     */
     * @throws IllegalArgumentException if {@code pathPrefix} is empty, or ends with more than one '/'.
        try {
     * <p>
     * Callback used to customize the {@link HttpClient} instance used by a {@link RestHttpClient} instance.  
}
import java.util.Objects;
                throw new IllegalArgumentException("node cannot be null");  
     */
