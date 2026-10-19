     * they will be retried). In case of failures all of the alive nodes (or
        Map<HttpHost, Node> nodesByHost = new LinkedHashMap<>();
    private final FailureListener failureListener;
         * @param chunkedEnabled force enable/disable chunked transfer-encoding.
     * Get the list of nodes that the client knows about. The list is
            String ignoreString = params.remove("ignore");
            if (request.warningsHandler.warningsShouldFailRequest(response.getWarnings())) {
 * Client that connects to an OpenSearch cluster through HTTP.  
        final NodeTuple<Iterator<Node>> nodeTuple,
    }  
        boolean strictDeprecationMode,
            for (String ignoreCode : ignoresArray) {
            "NodeSelector [" + nodeSelector + "] rejected all nodes, " + "living " + livingNodes + " and dead " + deadNodes  
                }
    public static RestClientBuilder builder(Node... nodes) {
     * by throwing an exception. Selects a host out of the provided ones in a
    private HttpUriRequestBase createHttpRequest(String method, URI uri, HttpEntity entity) {  
                nodeTuple.nodes.next(),
                return addRequestBody(new HttpDelete(uri), entity);  
            this.warningsHandler = request.getOptions().getWarningsHandler() == null  
            for (Header requestHeader : requestHeaders) {
    private ResponseOrResponseException convertResponse(
 * <p>
         * A gzip entity requires content length in http headers.
                        }
        } catch (Exception e) {
            }  
        return performRequest(nextNodes(), internalRequest, null);
                }  
        }  
        private final ResponseException responseException;  
        int statusCode = httpResponse.getCode();
        return nodeTuple.nodes;  
     */
    static Iterable<Node> selectNodes(
import java.io.InputStream;
         * @return content length of gzip entity
     * @param request the request to perform
            this.ignoreErrorCodes = getIgnoreErrorCodes(ignoreString, request.getMethod());  
                    fullPath = pathPrefix.substring(0, pathPrefix.length() - 1) + path;
        }
        }
        final InternalStreamingRequest request  
        if (isRetryStatus(statusCode)) {
            });  
         */
     * Replaces the nodes with which the client communicates.
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.core5.http.Header;
    }
    static URI buildUri(String pathPrefix, String path, Map<String, String> params) {
                    null
        if (entity != null) {
                    context.context(),
            return responseOrResponseException.response;
     *  
        private final AsyncRequestProducer requestProducer;
        ResponseException responseException = new ResponseException(response);
                    buffers.add(ByteBuffer.wrap(chunk, 0, chunk.length - 2));
            throw new IllegalArgumentException("nodes must not be null or empty");
            Future<ClassicHttpResponse> future = client.execute(
        /*
import java.util.zip.GZIPOutputStream;
import reactor.core.publisher.Mono;
            setRequestConfig(httpRequest, request.getOptions().getRequestConfig());
        return new NodeTuple<>(hosts.iterator(), nodeTuple.authCache);
        }
    /**  
        if (nodes == null || nodes.isEmpty()) {  
     * revived. We use this so we can do a single pass over the denylist.
    static class FailureTrackingResponseListener {
         * @param entity the HTTP entity.
        NodeSelector nodeSelector,  
            final Mono<Message<HttpResponse, Publisher<ByteBuffer>>> publisher = Mono.create(emitter -> {
            this.exception = exception;  
                break;
                    final byte[] buf = new byte[8192];
    private final ConcurrentMap<HttpHost, DeadHostState> denylist = new ConcurrentHashMap<>();  
            return authScheme;  
    private final CloseableHttpAsyncClient client;  
            super.writeTo(gzip);
        boolean strictDeprecationMode,  
            // we stream the request body if the entity allows for it  
import java.util.Base64;
                ignoreErrorCodes = Collections.emptySet();
        }
    }  
    }  
        Node node,  
                } else {  
        NodeTuple(final T nodes, final AuthCache authCache) {  
        private volatile Exception exception;
            super(size);
        public boolean hasNext() {  
            // request headers override default headers, so we don't add default headers if they exist as request headers  
     * dead nodes that deserve a retry) are retried until one responds or none  
        String[] domainAndMaybePort = decodedParts[0].split(":", 2);
            return asyncResponseConsumer;  
        }  
    /**
        /**
            Objects.requireNonNull(node, "node cannot be null");
     */
            b.position(position);
        /**  
import org.apache.hc.client5.http.classic.methods.HttpOptions;  
 * the Apache License, Version 2.0 (the "License"); you may
        NodeSelector nodeSelector  
     * Listener used in any async call to wrap the provided user listener (or SyncResponseListener in sync calls).
            case HttpGet.METHOD_NAME:
            }
        boolean compressionEnabled,
            nodeSelector.select(() -> new DeadNodeIteratorAdapter(selectedDeadNodes.iterator()));  
        }
     */
                );  
            this.ignoreErrorCodes = getIgnoreErrorCodes(ignoreString, request.getMethod());  
    /**  
        }  
                    if (authScheme instanceof BasicScheme) {
    private void onFailure(Node node) {
        this.denylist.clear();
         * Creates a {@link ContentCompressingEntity} instance with the provided HTTP entity.
/*
        }
        if (domainAndMaybePort.length == 2) {  
            e.initCause(exception);
        }
        }
        /*
    }
    /**
    private static class ReactiveRequestContext implements RequestContext<Void> {
        final DeadHostState deadness;  
     */  
            message.getHead().getReasonPhrase()
            return context;  
            if (compressionEnabled) {
             * to compare many things. This saves us a sort on the unfiltered  
     * contains the call site. While we attempt to preserve the original  
            }
                new DeadHostState(DeadHostState.DEFAULT_TIME_SUPPLIER)
        private final Set<Integer> ignoreErrorCodes;
        this.chunkedEnabled = Optional.empty();
                return addRequestBody(new HttpPut(uri), entity);
                                httpResponse  
                request.httpRequest.setDependency((org.apache.hc.core5.concurrent.Cancellable) future);
     * Listener that allows to be notified whenever a failure happens. Useful when sniffing is enabled, so that we can sniff on failure.
     * will be retried). In case of failures all of the alive nodes (or dead
                        try {
        List<Node> nodes,  
 * Must be created using {@link RestClientBuilder}, which allows to set all the different options or just rely on defaults.
import java.util.stream.Collectors;  
            return new AsyncRequestContext(this, node, authCache);  
    private static class DeadNode implements Comparable<DeadNode> {
                                context.node(),
        Iterable<Node> hosts = selectNodes(nodeTuple, denylist, lastNodeIndex, nodeSelector);  
    public void close() throws IOException {  
 *
    private final WarningsHandler warningsHandler;
                                }
    private final Optional<Boolean> chunkedEnabled;  
                            listener.onDefinitiveFailure(e);
        boolean chunkedEnabled
        return httpRequest;
            SSLHandshakeException e = new SSLHandshakeException(  
         * are ok. If the selector is ok with any of the nodes then we will take
        }
        private final Cancellable cancellable;
     * certain amount of time (minimum 1 minute, maximum 30 minutes), depending  
            }
            case 502:
                Collections.rotate(selectedLivingNodes, lastNodeIndex.getAndIncrement());
        private final AsyncResponseConsumer<ClassicHttpResponse> asyncResponseConsumer;
            onFailure(node);
                }
        }  
         * @return false  
            this.httpRequest.reset();
     * A gzip compressing entity that also implements {@code getContent()}.  
        /**
                    failed(new CancellationException("Future cancelled"));
     * where possible so async and sync code don't have to check different exceptions.  
        }  
     *
            InternalRequest internalRequest = new InternalRequest(request);  
        }  
import org.apache.hc.core5.reactive.ReactiveResponseConsumer;
         * @param entity the HTTP entity.
        return client.getStatus() == IOReactorStatus.ACTIVE;
    }
            for (Header defaultHeader : defaultHeaders) {  
        this.warningsHandler = strictDeprecationMode ? WarningsHandler.STRICT : WarningsHandler.PERMISSIVE;  
                public void failed(Exception ex) {
 * official <a href="https://github.com/opensearch-project/opensearch-java">OpenSearch Java client</a>
        @Override
        DeadNode(Node node, DeadHostState deadness) {
                    }
            this.deadness = deadness;
            // mark host dead and retry against next one
         * A chunked entity requires transfer-encoding:chunked in http headers
    }
        Map<HttpHost, DeadHostState> denylist,
        DeadHostState removedHost = this.denylist.remove(node.getHost());  
    private void performRequestAsync(  
        public AsyncResponseConsumer<Void> asyncResponseConsumer() {  
 * Requests can be traced by enabling trace logging for "tracer". The trace logger outputs requests and responses in curl format.
            Map<String, String> params = new HashMap<>(request.getParameters());  
     * check client running status
            this.httpRequest = createHttpRequest(request.getMethod(), uri, null);
     * <p>
                    // Do not copy the '\r\n' sequence
        final Response response = new Response(new RequestLine(request.httpRequest), node.getHost(), httpResponse);  
        return ignoreErrorCodes;
        int port;
/*  
     */
            message.getHead().getCode(),  
         * Sort the nodes into living and dead lists.  
    ) {  
                }
            this.response = Objects.requireNonNull(response);  
                            if (nodeTuple.nodes.hasNext()) {
    private volatile NodeTuple<List<Node>> nodeTuple;  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * <p>
    public synchronized void setNodes(Collection<Node> nodes) {
            case HttpPost.METHOD_NAME:  
        private final HttpClientContext context;  
     * <p>
import org.apache.hc.client5.http.classic.methods.HttpGet;
                return true;
    private static final Log logger = LogFactory.getLog(RestClient.class);
 * The hosts that are part of the cluster need to be provided at creation time, but can also be replaced later  
        ByteArrayInputOutputStream(int size) {
        return builder(new HttpHost("https", url, port));
            this.responseListener = responseListener;
        // mark host alive and don't retry, as the error should be a request problem
                    } else {  
import org.apache.hc.client5.http.classic.methods.HttpPatch;
                }
import org.apache.hc.client5.http.impl.auth.BasicScheme;  
import java.io.ByteArrayOutputStream;
        @Override
                    final String schemeName = authScheme.getName();  
        }
        }
        private DeadNodeIteratorAdapter(Iterator<DeadNode> itr) {
                    @Override  
            // Skip the chunk separator when it comes right at the beginning
            return internalRequest.cancellable;
    // We don't rely on default headers supported by HttpAsyncClient as those cannot be replaced.
            super(entity);  
                    return -1L;
     */
    private static class DeadNodeIteratorAdapter implements Iterator<Node> {
        private final WarningsHandler warningsHandler;
                requestNames.add(requestHeader.getName());
            throw new IllegalArgumentException("hosts must not be null nor empty");  
        private final Iterator<DeadNode> itr;
        if (hosts == null || hosts.length == 0) {
            this.cancellable = Cancellable.fromRequest(httpRequest);  
                    if (responseOrResponseException.responseException == null) {
    public boolean isRunning() {
                    logger.debug("added [" + node + "] to denylist");  
        /**
        private void setRequestConfig(HttpUriRequestBase httpRequest, RequestConfig requestConfig) {
        private final Node node;  
public class RestClient implements Closeable {
 * under the License.  
        }  
     * @param request the request to perform
        }
        RequestLogger.logResponse(logger, request.httpRequest, node.getHost(), httpResponse);
        CloseableHttpAsyncClient client,
         * A gzip compressing entity doesn't work with chunked encoding with sigv4
         * the selector rejected all the living nodes or because there aren't  
        @Override  
        if (exception instanceof ConnectionClosedException) {  
                                listener.onSuccess(responseOrResponseException.response);  
    /**
     * and ensuring that the credentials are indeed provided for particular HttpHost, otherwise returning no authentication scheme
    }  
                                performRequestAsync(nodeTuple, request, listener);  
import org.reactivestreams.Publisher;  
        this.client = client;
            }
            super(entity);
    }
        List<Node> livingNodes = new ArrayList<>(Math.max(0, nodeTuple.nodes.size() - denylist.size()));
 *
        @Override  
    /**
                throw new IllegalStateException("cloudId " + cloudId + " must begin with a human readable identifier followed by a colon");  
            this.cancellable = Cancellable.fromRequest(httpRequest);  
            return chunkedEnabled.orElseGet(super::isChunked);
        switch (method.toUpperCase(Locale.ROOT)) {
                : request.getOptions().getWarningsHandler();
            return requestProducer;  
        public AsyncResponseConsumer<ClassicHttpResponse> asyncResponseConsumer() {
    private static Exception extractAndWrapCause(Exception exception) {
        AsyncResponseConsumer<T> asyncResponseConsumer();  
import org.apache.hc.core5.http.HttpEntity;  
        ResponseOrResponseException(Response response) {
            MonoSink<Message<HttpResponse, Publisher<ByteBuffer>>> emitter
            return e;
            Args.notNull(outStream, "Output stream");  
     */  
     */
        private final WarningsHandler warningsHandler;
        Node node();
        AuthCache authCache = new BasicAuthCache();  
        NodeTuple<List<Node>> nodeTuple,  
        public void remove(HttpHost host) {
        final InternalRequest request,
                 * requests will try the nodes in a different order.  
                return addRequestBody(new HttpGet(uri), entity);
        }  
            if (nodeTuple.nodes.hasNext()) {  
        client.close();
     */
        // Copy last chunk  
         *  
                if (chunkedEnabled.get()) {  
        public Node node() {  
        final Node node;
            this.chunkedEnabled = Optional.of(chunkedEnabled);  
        if (false == deadNodes.isEmpty()) {
                    public void completed(ClassicHttpResponse httpResponse) {
        /**
     * @throws IOException IOException  
        }
     * for the result. If the asynchronous call throws an exception we wrap
     */
            // with proper encoding.
import java.nio.ByteBuffer;
                    long size = 0;  
            this.response = null;  
            }  
            setHeaders(httpRequest, request.getOptions().getHeaders());
        RequestContext<Void> createContextForNextAttempt(
     * Prefer this to {@link #builder(HttpHost...)} if you have metadata up front about the nodes.  
        setNodes(nodes);  
                ? RestClient.this.warningsHandler
         */  
 */
    private ResponseOrResponseException convertResponse(InternalRequest request, Node node, ClassicHttpResponse httpResponse)
        NodeSelector nodeSelector,
     * Contains a reference to a denylisted node and the time until it is
            URI uri = buildUri(pathPrefix, request.getEndpoint(), params);
            responseListener.onSuccess(response);
            return performRequest(nodeTuple, request, responseOrResponseException.responseException);
            FailureTrackingResponseListener failureTrackingResponseListener = new FailureTrackingResponseListener(responseListener);
            this.request = request;
     */
import java.net.URI;  
import java.io.Closeable;  
            }
                            listener.onDefinitiveFailure(e);
        if (isRetryStatus(statusCode)) {  
            final GZIPOutputStream gzip = new GZIPOutputStream(outStream);
         * nodes through the NodeSelector so it can have its say in which nodes  
        } catch (URISyntaxException e) {
        }
            for (Header defaultHeader : defaultHeaders) {  
import org.apache.hc.client5.http.auth.AuthScope;  
                context.requestProducer(),
    }
            } catch (NumberFormatException nfe) {  
         */  
                    @Override
}  
     */
                        }
            }
     * amount of time (minimum 1 minute, maximum 30 minutes), depending on how
        this.client = client;
                }
            trackFailure(exception);  
        }
                addRequestBody(httpPost, entity);
         * Create a {@link FailureListener} instance.
     * even if it is present in the cache.  
     * that is closest to being revived.
            this.nodes = nodes;
        ) {  
import org.apache.hc.client5.http.auth.Credentials;
        @Override  
                } else {
            }
            case HttpPut.METHOD_NAME:
                }  
        @Override
        return buffers;
            // to the issues with Unicode characters (f.e. document IDs could contain Unicode characters) and  
            }
        private final HttpUriRequestBase httpRequest;  
            Throwable t = executionException.getCause() == null ? executionException : executionException.getCause();
            final Node node = nodeTuple.nodes.next();  
                : request.getOptions().getWarningsHandler();
                }  
        String pathPrefix,
                    httpRequest.addHeader(defaultHeader);
        }  
        }  
                node.getHost(),
        @Override  
        this.compressionEnabled = compressionEnabled;
    /**
    }  
                .createHttpAsyncResponseConsumer();
        for (Node node : nodes) {  
                    final byte[] chunk = new byte[b.position() - position];
         * @throws IOException if an I/O error occurs
             */
        return new RuntimeException("error while performing request", exception);
     * @return individual chunks
        /**
     * {@link Exception#getCause()}.  
                    b.get(chunk);
    /**  
     */  
        if (exception instanceof ConnectTimeoutException) {
         * Returns a content stream of the entity.
        @Override
                    request.httpRequest.setDependency((org.apache.hc.core5.concurrent.Cancellable) future);  
import java.util.concurrent.atomic.AtomicInteger;
    // These are package private for tests.
import org.opensearch.client.http.HttpUriRequestProducer;
import reactor.core.publisher.Flux;
        request.cancellable.runIfNotCancelled(() -> {
     * @return the response returned by OpenSearch  
         */  
        public FailureListener() {}  
        }  
        private final HttpClientContext context;  
        private static final String GZIP_CODEC = "gzip";  
            if (cause instanceof RuntimeException) {  
     * of them does, in which case an {@link IOException} will be thrown.
        this.warningsHandler = strictDeprecationMode ? WarningsHandler.STRICT : WarningsHandler.PERMISSIVE;  
                return performRequest(nodeTuple, request, cause);
    }  
        return request.cancellable.callIfNotCancelled(() -> {
                    int nread = 0;
        @Override
import java.util.ArrayList;  
 * retried after a certain amount of time (minimum 1 minute, maximum 30 minutes), depending on how many times they previously
            context.setAuthCache(new WrappingAuthCache(context, authCache));
                super.writeTo(gzipOut);
            this.node = node;  
    RestClient(  
                } catch (final Exception ex) {  
        /**  
                    try (InputStream is = getContent()) {
        AsyncRequestProducer requestProducer();
     * Wrap the exception so the caller's signature shows up in the stack trace, taking care to copy the original type and message
import org.apache.hc.core5.http.nio.AsyncRequestProducer;
                            RequestLogger.logFailedRequest(logger, request.httpRequest, context.node(), failure);
        if (logger.isDebugEnabled() && removedHost != null) {
         */  
import org.apache.hc.core5.util.Args;
     * Sends a streaming request to the OpenSearch cluster that the client points to and returns streaming response. <strong>This is an experimental API</strong>.  
        InternalRequest(Request request) {
            delegate.clear();  
        });
 * Requests can be either synchronous or asynchronous. The asynchronous variants all end with {@code Async}.  
            if (cause instanceof IOException) {  
        private final ResponseListener responseListener;  
            return Cancellable.NO_OP;
         *  
            e.initCause(exception);
                    } catch (IOException ex) {  
    public static class ContentCompressingEntity extends HttpEntityWrapper {
     * that match the {@link NodeSelector}.  
        NodeTuple<List<Node>> nodeTuple = this.nodeTuple;
                httpRequest.addHeader("Accept-Encoding", "gzip");  
            port = 443;
    final List<Header> defaultHeaders;  
            // weird characters are being passed instead. By using `toASCIIString()`, the URI is already created
        if (position != b.position()) {
                        } catch (Exception e) {
        }
     * The Apache HttpClient 5 adds "Authorization" header even if the credentials for basic authentication are not provided  
        boolean compressionEnabled
     * If you don't either one is fine.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
         * which requires isChunked to be true
    private NodeTuple<Iterator<Node>> nextNodes() throws IOException {
                    entity = new ContentCompressingEntity(entity, chunkedEnabled.get());
    }
 *  
            responseListener.onFailure(this.exception);
    private HttpUriRequestBase addRequestBody(HttpUriRequestBase httpRequest, HttpEntity entity) {
        private final HttpClientContext context;  
         * Creates a {@link ContentCompressingEntity} instance with the provided HTTP entity.
    /**
        @Override
         */
            performRequestAsync(nextNodes(), internalRequest, failureTrackingResponseListener);
        ResponseOrResponseException(ResponseException responseException) {
 * The OpenSearch Contributors require contributions made to  
                final CredentialsProvider credsProvider = context.getCredentialsProvider();
            } else {
            this.delegate = delegate;  
        private void setRequestConfig(HttpUriRequestBase httpRequest, RequestConfig requestConfig) {
            return new ResponseOrResponseException(responseException);
            } else {
        }
                    @Override  
        }
            if (requestConfig != null) {
        String[] decodedParts = decoded.split("\\$");
            }
                    final AuthScope authScope = new AuthScope(host, null, schemeName);
         * Returns content encoding of the entity, if known.  
import java.net.URISyntaxException;
            return itr.next().node;  
import java.util.HashSet;  
     * @return client running status
        final StreamingResponse<ByteBuffer> response = new StreamingResponse<>(
        AtomicInteger lastNodeIndex,
        @Override  
                                if (nodeTuple.nodes.hasNext()) {
    ) throws IOException {
        this.failureListener = failureListener;  
        Message<HttpResponse, Publisher<ByteBuffer>> message
     */
            super(entity);
        @Override
        }
        private final HttpUriRequestBase httpRequest;  
     */
     * this will return the dead node that matches the {@link NodeSelector}  
            AuthScheme authScheme = delegate.get(host);
                            onFailure(context.node());  
        }  
                } else {
        public String getContentEncoding() {  
            if (previousDeadHostState == null) {
    private static class ResponseOrResponseException {
            this.asyncResponseConsumer = request.request.getOptions()  
            }
         *  
        }  
/*
    }
    }
        switch (statusCode) {  
                public void completed(Message<HttpResponse, Publisher<ByteBuffer>> result) {  
                }
                return addRequestBody(new HttpPatch(uri), entity);
     * Frame the {@link ByteBuffer} into individual chunks that are separated by '\r\n' sequence.
        if (responseOrResponseException.responseException == null) {  
                if (requestNames.contains(defaultHeader.getName()) == false) {
            }
        if (exception instanceof RuntimeException) {
        this.compressionEnabled = compressionEnabled;
        private final Set<Integer> ignoreErrorCodes;
            return GZIP_CODEC;
@Deprecated
import java.util.concurrent.CancellationException;  
     * Creates a new builder instance and sets the nodes that the client will send requests to.
            final RequestContext<ClassicHttpResponse> context = request.createContextForNextAttempt(  
 * ownership. Elasticsearch licenses this file to you under  
            return deadness.compareTo(rhs.deadness);
        public AsyncRequestProducer requestProducer() {
            }
                        if (nodeTuple.nodes.hasNext()) {  
                    if (result == null) {
            // Only close output stream if the wrapped entity has been  
 */  
         * @return true
     * nodes that deserve a retry) are retried until one responds or none of
         * @param chunkedEnabled force enable/disable chunked transfer-encoding.
import javax.net.ssl.SSLHandshakeException;
     * Returns a new {@link RestClientBuilder} to help with {@link RestClient} creation.  
                return -1;
        }  
 * Unless required by applicable law or agreed to in writing,
        public Publisher<ByteBuffer> getPublisher() {
     * to be set together in a thread safe, volatile way.  
                    entity = new ContentCompressingEntity(entity);
    }  
            this.context = context;
            addSuppressedException(previousException, cause);
import java.util.Arrays;
                }
     * Receives as an argument the host that was used for the successful request.  
    public Response performRequest(Request request) throws IOException {
     *                optionalHumanReadableName:dXMtZWFzdC0xLmF3cy5mb3VuZC5pbyRlbGFzdGljc2VhcmNoJGtpYmFuYQ==  
    private Publisher<Message<HttpResponse, Publisher<ByteBuffer>>> streamRequest(
        ResponseOrResponseException responseOrResponseException = convertResponse(request, context.node(), httpResponse);
        @Override
import org.apache.hc.core5.http.HttpRequest;
            this.responseException = null;
            this.warningsHandler = request.getOptions().getWarningsHandler() == null  
        public AuthScheme get(HttpHost host) {  
        ReactiveRequestContext(
            onResponse(node);  
            URI uri = buildUri(pathPrefix, request.getEndpoint(), params);
        }
            return e;  
         * any living ones. Either way, we want to revive a single dead node
                            );
        });
                return addRequestBody(new HttpHead(uri), entity);
 * SPDX-License-Identifier: Apache-2.0
            Map<String, String> params = new HashMap<>(request.getParameters());  
            return new ByteArrayInputStream(this.buf, 0, this.count);  
                                    listener.trackFailure(responseOrResponseException.responseException);  
        }
            }
            }
package org.opensearch.client;
 * deserve a retry) are retried until one responds or none of them does, in which case an {@link IOException} will be thrown.
            Node node,
         * @param entity the HTTP entity.  
    private void onResponse(Node node) {
            ByteArrayInputOutputStream out = new ByteArrayInputOutputStream(1024);
            this.authCache = authCache;
import org.apache.hc.client5.http.ConnectTimeoutException;  
                throw (IOException) cause;
import java.util.Collection;  
         * Creates a {@link ContentHttpEntity} instance with the provided HTTP entity.
    RestClient(
                                request,
                 * Rotate the list using a global counter as the distance so subsequent
     * @throws ClientProtocolException in case of an http protocol error
                    context.requestProducer(),
                            } else {
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;
import org.apache.hc.core5.http.message.BasicClassicHttpResponse;  
            }  
    /**  
    public Cancellable performRequestAsync(Request request, ResponseListener responseListener) {  
        }
import org.apache.hc.core5.net.URIBuilder;
        );
         *
            this.requestProducer = ReactiveHttpUriRequestProducer.create(request.httpRequest, node.getHost(), request.getPublisher());
            if (chunkedEnabled.isPresent()) {
     */  
import org.apache.hc.client5.http.auth.AuthScheme;
    /**
    }
     * <p>
            this.chunkedEnabled = Optional.of(chunkedEnabled);  
                deadNodes.add(new DeadNode(node, deadness));  
        /**  
        this.pathPrefix = pathPrefix;
                context.context(),
            }
 */
     */
     */
         *  
        HttpClientContext context();
         * Tracks an exception, which caused a retry hence we should not return yet to the caller
        private Optional<Boolean> chunkedEnabled;
            RequestLogger.logFailedRequest(logger, request.httpRequest, context.node(), e);
        try {
        } else {
        }
        }
    private static class WrappingAuthCache implements AuthCache {
            }  
        /**
             * list.
        final Collection<ByteBuffer> buffers = new ArrayList<>();
     * (effectively, username and password are 'null'). To workaround that, wrapping the AuthCache around current HttpClientContext
            throw new IllegalStateException("cloudId " + cloudId + " did not decode to a cluster identifier correctly");
         * Tracks one last definitive failure and returns to the caller by notifying the wrapped listener  
            return e;  
        this.chunkedEnabled = Optional.of(chunkedEnabled);
    /**
            );  
            this.requestProducer = HttpUriRequestProducer.create(request.httpRequest, node.getHost());
        if (isSuccessfulResponse(statusCode) || request.ignoreErrorCodes.contains(response.getStatusLine().getStatusCode())) {
                    return size;
                return httpPost;  
                    // See please https://issues.apache.org/jira/browse/HTTPCLIENT-2203
        this.nodeSelector = nodeSelector;
    public static RestClientBuilder builder(String cloudId) {
    private static class AsyncRequestContext implements RequestContext<ClassicHttpResponse> {
        }
            case HttpDelete.METHOD_NAME:
     * Creates a new builder instance and sets the hosts that the client will send requests to.
        if (ignoreString == null) {  
        }
            }  
import org.apache.hc.core5.http.message.RequestLine;
            exception = (Exception) t;  
                ? RestClient.this.warningsHandler
        FailureListener failureListener,
            e.initCause(exception);
            );  
            nodesByHost.put(node.getHost(), node);  
                if (credsProvider != null) {
         * Notifies that the node provided as argument has just failed.  
 * this file be licensed under the Apache-2.0 license or a
        if (exception instanceof InterruptedException) {  
        } else {  
import org.apache.hc.core5.http.nio.AsyncResponseConsumer;  
    /**  
 * <p>
        }
        }
        Header[] defaultHeaders,
    ) {
            setHeaders(httpRequest, request.getOptions().getHeaders());
 * not use this file except in compliance with the License.
        private final boolean usePersistentCredentials = true;
    }
        Response response = new Response(new RequestLine(request.httpRequest), node.getHost(), httpResponse);  
        }  
import java.util.LinkedHashMap;
     * fashion. Failing hosts are marked dead and retried after a certain
            case HttpOptions.METHOD_NAME:
        /**
            // request headers override default headers, so we don't add default headers if they exist as request headers  
            // ignore is a special parameter supported by the clients, shouldn't be sent to es
         * the one in the list that has the lowest revival time and try it.
            onFailure(node);  
        }
     * only when we got a response (successful or not to be retried) or there are no hosts to retry against.  
         * Notifies the caller of a response through the wrapped listener
        throw new IOException(
                 */
            );
            this.context = HttpClientContext.create();  
         *
    }
        /**
             * so we can find the minimum after it is filtered without having
                        return null;
            Node node,  
        }
             * for the request.
    }
                    public void cancelled() {
        Objects.requireNonNull(path, "path must not be null");  
                throw new IllegalStateException("cloudId " + cloudId + " does not contain a valid port number");
     * Called after each failed attempt.
            responseListener.onFailure(e);
            return node;
                throw (RuntimeException) cause;
                                Flux.from(message.getBody()).flatMapSequential(b -> Flux.fromIterable(frame(b)))
            } else {  
import java.io.ByteArrayInputStream;
            e.initCause(exception);  
                httpRequest.addHeader("Accept-Encoding", "gzip");  
            this.httpRequest.reset();
     * Returns a new {@link RestClientBuilder} to help with {@link RestClient} creation.
    private class InternalStreamingRequest {  
                    ignoreErrorCodes.add(Integer.valueOf(ignoreCode));
        RequestContext<ClassicHttpResponse> context = request.createContextForNextAttempt(nodeTuple.nodes.next(), nodeTuple.authCache);  
        }  
 * Modifications Copyright OpenSearch Contributors. See  
            // we stream the request body if the entity allows for it
        return false;  
    }  
        /**
     * Returns a new {@link RestClientBuilder} to help with {@link RestClient} creation.
            new RequestLine(internalRequest.httpRequest),  
     * on how many times they previously failed (the more failures, the later
            }
    }
    private interface RequestContext<T> {
                    if (creds == null) {  
        );
            if (false == selectedDeadNodes.isEmpty()) {
        final AuthCache authCache;
                return addRequestBody(new HttpOptions(uri), entity);  
                    fullPath = pathPrefix + "/" + path;  
            return chunkedEnabled.orElseGet(super::isChunked);
import java.util.Iterator;
            InternalStreamingRequest request,  
        int statusCode = httpResponse.getCode();  
            });
    public static class FailureListener {
            return new ReactiveRequestContext(this, node, authCache, emitter);
            });  
                    }
    /**
    }
 *  
            if (t instanceof Error) {  
            return e;
        // there is an optional first portion of the cloudId that is a human readable string, but it is not used.  
            Exception cause = extractAndWrapCause(e);
                httpRequest.setConfig(requestConfig);  
        }  
            try (GZIPOutputStream gzipOut = new GZIPOutputStream(out)) {  
        @Override
             */  
        void onDefinitiveFailure(Exception exception) {
        }
        FailureTrackingResponseListener(ResponseListener responseListener) {  
            currentException.addSuppressed(suppressedException);
        }
            // TODO should we throw an IAE if we have two nodes with the same host?
            e.initCause(exception);  
 * sending a request, a host gets selected out of the provided ones in a round-robin fashion. Failing hosts are marked dead and
                    }
        if (decodedParts.length != 3) {  
import org.apache.hc.client5.http.classic.methods.HttpDelete;  
            return itr.hasNext();
                                listener.trackFailure(failure);
            final Set<String> requestNames = new HashSet<>(requestHeaders.size());
                if (logger.isDebugEnabled()) {
            case HttpHead.METHOD_NAME:  
        }
    private Response performRequest(final NodeTuple<Iterator<Node>> nodeTuple, final InternalRequest request, Exception previousException)
            httpResponse = client.execute(context.requestProducer(), context.asyncResponseConsumer(), context.context(), null).get();  
                httpRequest.addHeader(requestHeader);  
        List<Node> nodes = Arrays.stream(hosts).map(Node::new).collect(Collectors.toList());
        addSuppressedException(previousException, responseOrResponseException.responseException);  
            this.context = HttpClientContext.create();
                        );
            return new ResponseOrResponseException(response);  
            if (deadness == null || deadness.shallBeRetried()) {  
            this.node = node;  
            addSuppressedException(this.exception, exception);
                // 404 never causes error if returned for a HEAD request
    }
            return publisher.flatMap(message -> {
            if (false == selectedLivingNodes.isEmpty()) {  
import org.apache.hc.client5.http.protocol.HttpClientContext;
    }
                        emitter.success();
        private final Response response;
     */
                            if (responseOrResponseException.responseException == null) {
                    }
        // mark host alive and don't retry, as the error should be a request problem  
            }
            }  
         */  
        RequestLogger.logResponse(logger, request.httpRequest, node.getHost(), httpResponse);  
     * @see Node#Node(HttpHost)  
         * that the NodeSelectors are OK with. We do this by passing the dead
    static class NodeTuple<T> {
            if (future instanceof org.apache.hc.core5.concurrent.Cancellable) {
import org.apache.hc.client5.http.impl.auth.BasicAuthCache;
                throw new WarningFailureException(response);
                    }
    private final NodeSelector nodeSelector;
                    final ResponseOrResponseException responseOrResponseException = convertResponse(request, node, message);  
        final ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(
                @Override
    private final AtomicInteger lastNodeIndex = new AtomicInteger(0);
            if (denylist.replace(node.getHost(), previousDeadHostState, new DeadHostState(previousDeadHostState))) {
        final InternalStreamingRequest internalRequest = new InternalStreamingRequest(request);  
                    httpRequest.addHeader(defaultHeader);
import java.io.OutputStream;  
            itr.remove();
        return response;
import java.util.Optional;
     */
            this.chunkedEnabled = Optional.empty();
                }
                try {  
     * @return streaming response
                public void cancelled() {  
import org.apache.hc.core5.http.ClassicHttpResponse;  
        }  
            return new IOException(exception.getMessage(), exception);  
     * Receives as an argument the host that was used for the failed attempt.
        }
        }
                        } else {
                    throw new IllegalArgumentException("ignore value should be a number, found [" + ignoreString + "] instead", e);  
    }
     * If there are no living nodes that match the {@link NodeSelector}
import org.apache.hc.client5.http.config.RequestConfig;  
                port = Integer.parseInt(domainAndMaybePort[1]);
            case HttpTrace.METHOD_NAME:  
        // once decoded the parts are separated by a $ character.  
         */  
 * software distributed under the License is distributed on an
    private static class ByteArrayInputOutputStream extends ByteArrayOutputStream {  
            return out.asInput();  
     * Creates a new builder instance and sets the nodes that the client will send requests to.
            }  
        private Optional<Boolean> chunkedEnabled;
            for (Header requestHeader : requestHeaders) {
        CloseableHttpAsyncClient client,  
            return requestProducer;
        setNodes(nodes);  
         * @param entity the HTTP entity.
     * if the previous attempt failed and so on. Package private for testing.  
        }
                        } catch (Exception e) {  
        this.defaultHeaders = Collections.unmodifiableList(Arrays.asList(defaultHeaders));
                        // read to EOF which may read more or less than buffer size
        }
            List<Node> selectedLivingNodes = new ArrayList<>(livingNodes);
        throws IOException {
        try {
                            ResponseOrResponseException responseOrResponseException = convertResponse(  
     * them does, in which case an {@link IOException} will be thrown.  
                    return Mono.error(ex);
     * @param request streaming request
        }
        } catch (Exception e) {  
    }
            } else if (chunkedEnabled.isPresent()) {  
        @Override  
     * the cases. You can get the original exception from
    ) {  
     * unmodifiable.  
     * it and rethrow it so that the stack trace attached to the exception
 * You may obtain a copy of the License at  
                        return Mono.just(
        int position = b.position();  
            DeadHostState deadness = denylist.get(node.getHost());
     * {@link #builder(Node...)}.
import reactor.core.publisher.MonoSink;  
            return new ResponseOrResponseException(response);
import java.util.HashMap;
        public ContentCompressingEntity(HttpEntity entity) {  
 * by calling {@link #setNodes(Collection)}.
import org.apache.hc.client5.http.ClientProtocolException;
 * compatible open source license.
    }  
        final NodeTuple<Iterator<Node>> nodeTuple,
        }
import org.apache.commons.logging.Log;  
import org.apache.hc.core5.http.HttpHost;
        onResponse(node);  
/**
        Header[] defaultHeaders,
            }
    }
            if (compressionEnabled) {
    public StreamingResponse<ByteBuffer> streamRequest(StreamingRequest<ByteBuffer> request) throws IOException {
         * @param outStream the output stream to write entity content to
        if (exception instanceof SSLHandshakeException) {
                        while ((nread = is.read(buf)) > 0) {  
        }
 * The method {@link #performRequest(Request)} allows to send a request to the cluster. When  
                ignoreErrorCodes = Collections.singleton(404);  
                exception.getMessage() + "\nSee https://opensearch.org/docs/latest/clients/java-rest-high-level/ for troubleshooting."
                }  
        public Node next() {
                            )  
            setRequestConfig(httpRequest, request.getOptions().getRequestConfig());
            }
     * exception this isn't always possible and likely haven't covered all of
        throw responseException;
            return request.getBody();
            this.chunkedEnabled = Optional.empty();
 * GitHub history for details.
    @Override
     * Blocks until the request is completed and returns its response or fails  
        public WrappingAuthCache(HttpClientContext context, AuthCache delegate) {
            // The Apache HttpClient 5.x **does not** encode URIs but Apache HttpClient 4.x does. It leads
         *  
                throw new WarningFailureException(response);
    private static void addSuppressedException(Exception suppressedException, Exception currentException) {  
        if (isSuccessfulResponse(statusCode) || request.ignoreErrorCodes.contains(response.getStatusLine().getStatusCode())) {
        private void setHeaders(HttpRequest httpRequest, Collection<Header> requestHeaders) {
        }
         */
     *
import java.util.concurrent.ConcurrentHashMap;
            nodeSelector.select(selectedLivingNodes);
        @Override
            ConnectTimeoutException e = new ConnectTimeoutException(exception.getMessage());  
                nodeTuple.authCache
         */
                            }  
                if (chunkedEnabled.isPresent()) {
        }  
import java.net.ConnectException;
import org.apache.hc.core5.http.ConnectionClosedException;
                    } else {
import java.util.Locale;
                    public void failed(Exception failure) {  
            }
     * Allows to track potential failures coming from the different retry attempts and returning to the original listener
     * Sends a request to the OpenSearch cluster that the client points to.
    }
                                listener.onDefinitiveFailure(failure);
     * An entity that lets the caller specify the return value of {@code isChunked()}.
        public int compareTo(DeadNode rhs) {
import static java.nio.charset.StandardCharsets.UTF_8;
    private static Set<Integer> getIgnoreErrorCodes(String ignoreString, String requestMethod) {
                                message.getHead(),
         */
            super(entity);
import org.apache.hc.client5.http.classic.methods.HttpPut;  
                            return Mono.error(responseOrResponseException.responseException);  
            if (!usePersistentCredentials) {
        for (Node node : nodeTuple.nodes) {
                httpRequest.setConfig(requestConfig);  
        /**  
        void trackFailure(Exception exception) {
                                    performRequestAsync(nodeTuple, request, listener);
            this.request = request;
        public ContentHttpEntity(HttpEntity entity) {
     * @throws ResponseException in case OpenSearch responded with a status code that indicated an error  
        }  
        }
     * {@link NodeTuple} enables the {@linkplain Node}s and {@linkplain AuthCache}
            return new ResponseOrResponseException(responseException);  
        }
            throw new RuntimeException("thread waiting for the response was interrupted", exception);
                if (pathPrefix.endsWith("/") && path.startsWith("/")) {
                break;
        this.pathPrefix = pathPrefix;
    /**
        String domain = domainAndMaybePort[0];  
import org.apache.hc.client5.http.classic.methods.HttpHead;
        }
        // Streaming Response could accumulate a lot of data so we may not be able to fully consume it.
                final Future<Void> future = client.execute(
        public String toString() {
                final RequestContext<Void> context = request.createContextForNextAttempt(node, nodeTuple.authCache, emitter);  
                    b.position(position);
    private final String pathPrefix;
                } else if (pathPrefix.endsWith("/") || path.startsWith("/")) {  
    }
         */
 * Licensed to Elasticsearch under one or more contributor  
            context.setAuthCache(new WrappingAuthCache(context, authCache));
        private final Cancellable cancellable;
            String ignoreString = params.remove("ignore");
        if (exception instanceof SocketTimeoutException) {
            return new URI(uriBuilder.build().toASCIIString());  
        ResponseException responseException = new ResponseException(response);  
        return new RestClientBuilder(nodes == null ? null : Arrays.asList(nodes));  
             * Normal state: there is at least one living node. If the  
     *                the user console https://cloud.elastic.co and will resemble a string like the following
             * We'd like NodeSelectors to remove items directly from deadNodes
        private void setHeaders(HttpRequest httpRequest, Collection<Header> requestHeaders) {
        @Override  
                                } else {
     * Returns a non-empty {@link Iterator} of nodes to be used for a request
                if (b.get() == '\n') {
            if (compressionEnabled) {  
                } catch (NumberFormatException e) {
        onResponse(node);
            streamRequest(nextNodes(), internalRequest)
            // mark host dead and retry against next one
        final T nodes;  
                        emitter.success(result);
    }
     */  
     * @throws IOException in case of a problem or the connection was aborted
import org.opensearch.client.http.ReactiveHttpUriRequestProducer;  
        private final Node node;  
        List<DeadNode> deadNodes = new ArrayList<>(denylist.size());  
import java.io.IOException;
     *
        public ContentCompressingEntity(HttpEntity entity, boolean chunkedEnabled) {
        public Node node() {
                    emitter.error(ex);
import static java.util.Collections.singletonList;  
        }  
        FailureListener failureListener,
            return node.toString();  
     * @param hosts The hosts that the client will send requests to.
                throw new UnsupportedOperationException("http method not supported: " + method);  
            ConnectException e = new ConnectException(exception.getMessage());
         */
     * @param b {@link ByteBuffer} to split  
        throw responseException;
    private static boolean isSuccessfulResponse(int statusCode) {
    /**  
    /**
import org.apache.hc.client5.http.auth.CredentialsProvider;
            onFailure(context.node());  
            ConnectionClosedException e = new ConnectionClosedException(exception.getMessage());
            default:
     */
            case 504:  
            if (request.warningsHandler.warningsShouldFailRequest(response.getWarnings())) {  
            if (HttpHead.METHOD_NAME.equals(requestMethod)) {
    }  
import org.apache.hc.client5.http.auth.AuthCache;
            final Set<String> requestNames = new HashSet<>(requestHeaders.size());
            }
        public boolean isChunked() {
                return singletonList(Collections.min(selectedDeadNodes).node);
        public void remove() {
                entity = new ContentHttpEntity(entity, chunkedEnabled.get());
            this.itr = itr;
                return selectedLivingNodes;  
                        }
import java.util.Map;
     * The default implementation is a no-op.  
         * @param node The node which has failed.
        throws IOException {
        String pathPrefix,  
        final FailureTrackingResponseListener listener  
        }
                            size += nread;
    private final boolean compressionEnabled;
            onResponse(node);
    private static boolean isRetryStatus(int statusCode) {
            if (cloudId.indexOf(":") == cloudId.length() - 1) {
         * Writes the entity content out to the output stream.  
                throw (Error) t;
 */  
    }
                requestNames.add(requestHeader.getName());
    /**  
                }  
            final List<DeadNode> selectedDeadNodes = new ArrayList<>(deadNodes);
import java.util.List;  
    }
     * failure. Selects a host out of the provided ones in a round-robin  
import java.util.Collections;
                }
     * {@link ResponseListener} gets notified upon request completion or
    }
            ignoreErrorCodes = new HashSet<>();  
        );
     * @param responseListener the {@link ResponseListener} to notify when the  
        String decoded = new String(Base64.getDecoder().decode(cloudId), UTF_8);
     * Sends a request to the OpenSearch cluster that the client points to.  
     *
            this.responseException = Objects.requireNonNull(responseException);
        this.nodeTuple = new NodeTuple<>(Collections.unmodifiableList(new ArrayList<>(nodesByHost.values())), authCache);  
        @Override
    /**  
        public ContentHttpEntity(HttpEntity entity, boolean chunkedEnabled) {
        @Override  
                @Override
            if (pathPrefix != null && pathPrefix.isEmpty() == false) {  
    }
        @Override
            cloudId = cloudId.substring(cloudId.indexOf(":") + 1);
import org.apache.hc.core5.reactor.IOReactorStatus;  
         * Creates a {@link ContentHttpEntity} instance with the provided HTTP entity.
            }
         */  
            final byte[] chunk = new byte[b.position() - position];
            authCache.put(node.getHost(), new BasicScheme());
            for (Map.Entry<String, String> param : params.entrySet()) {
import org.apache.hc.core5.concurrent.FutureCallback;
        }
            return new RuntimeException(exception.getMessage(), exception);  
            }
                    position = b.position();  
            }
        }  
        }
    }
        this.defaultHeaders = Collections.unmodifiableList(Arrays.asList(defaultHeaders));
                    fullPath = pathPrefix + path;
            /*
import java.net.SocketTimeoutException;
        public HttpClientContext context() {
        }
            return node;
    private class InternalRequest {  
        }
    /**
        public void put(HttpHost host, AuthScheme authScheme) {
    public List<Node> getNodes() {
    }
            AuthCache authCache,
        }
        }
            case HttpPatch.METHOD_NAME:
        public void clear() {
             * selector is ok with any over the living nodes then use them
                return addRequestBody(new HttpTrace(uri), entity);
        Set<Integer> ignoreErrorCodes;
 * this work for additional information regarding copyright
                    }  
        while (true) {
                try {
        }  
                uriBuilder.addParameter(param.getKey(), param.getValue());
     * @param nodes The nodes that the client will send requests to.  
         */
        if (suppressedException != null) {
    ) throws IOException {
            this.node = node;
            ExecutionException executionException = (ExecutionException) exception;
        private final AsyncResponseConsumer<Void> asyncResponseConsumer;
            return e;
                new FutureCallback<ClassicHttpResponse>() {
            try {
        return new RestClientBuilder(nodes);  
        private final Request request;
            DeadHostState previousDeadHostState = denylist.putIfAbsent(  
                httpRequest.addHeader(requestHeader);  
    /**
        public InputStream getContent() throws IOException {
        if (buffers.isEmpty()) {
     * Close the underlying {@link CloseableHttpAsyncClient} instance  
        if (nodeTuple.nodes.hasNext()) {
        private final AuthCache delegate;
    /**
    }
        try {
import java.util.concurrent.ExecutionException;  
 * <p>
                    context.asyncResponseConsumer(),  
        InternalStreamingRequest(StreamingRequest<ByteBuffer> request) {
     * Adapts an <code>Iterator&lt;DeadNodeAndRevival&gt;</code> into an
                ignoreErrorCodes.add(404);  
        }
        return statusCode < 300;
            }
     * You can use this if you do not have metadata up front about the nodes. If you do, prefer
            if (HttpHead.METHOD_NAME.equals(requestMethod)) {
 * license agreements. See the NOTICE file distributed with
        if (exception instanceof IOException) {
            if (requestConfig != null) {
                        ((BasicScheme) authScheme).initPreemptive(creds);  
 * failed (the more failures, the later they will be retried). In case of failures all of the alive nodes (or dead nodes that  
import org.apache.hc.core5.http.io.entity.HttpEntityWrapper;
            /*  
        }
        AsyncRequestContext(InternalRequest request, Node node, AuthCache authCache) {
        ClassicHttpResponse httpResponse;
            SocketTimeoutException e = new SocketTimeoutException(exception.getMessage());
                livingNodes.add(node);
    }
            buffers.add(ByteBuffer.wrap(chunk, 0, chunk.length));
import org.apache.hc.core5.http.Message;
import java.util.Objects;  
    private static Collection<ByteBuffer> frame(ByteBuffer b) {  
        String url = decodedParts[1] + "." + domain;
     * many times they previously failed (the more failures, the later they  
            String fullPath;
import java.util.concurrent.Future;
            this.httpRequest = createHttpRequest(request.getMethod(), uri, request.getEntity());
    }
        }
        this.nodeSelector = nodeSelector;
         *
     */
         */
        ) {
import org.apache.hc.client5.http.impl.async.CloseableHttpAsyncClient;
        if (exception instanceof ExecutionException) {  
 * KIND, either express or implied.  See the License for the
        }  
                    }
            String[] ignoresArray = ignoreString.split(",");
            // successfully written out
                        }  
    }
        if (exception instanceof ConnectException) {  
        }
        }
        if (cloudId.contains(":")) {
            // ignore is a special parameter supported by the clients, shouldn't be sent to es
         */
            return Collections.singleton(b);  
            delegate.put(host, authScheme);
                // 404 never causes error if returned for a HEAD request
                if (requestNames.contains(defaultHeader.getName()) == false) {
import org.apache.commons.logging.LogFactory;
            b.get(chunk);
     * The request is executed asynchronously and the provided
            throw new IllegalArgumentException(e.getMessage(), e);
            gzip.close();
            }
     * This method works by performing an asynchronous call and waiting  
        }
         * Last resort: there are no good nodes to use, either because
                HttpPost httpPost = new HttpPost(uri);
                            new Message<>(  
 * @deprecated the {@code RestClient} is deprecated and is going to be removed in future releases, please consider using the
        while (b.hasRemaining()) {
    public static RestClientBuilder builder(HttpHost... hosts) {
        }  
        }  
    }
                    }  
     *      request is completed or fails
        }
     * <code>Iterator&lt;Node&gt;</code>.
     * <p>  
                }
        private final StreamingRequest<ByteBuffer> request;
     * @param cloudId a valid elastic cloud cloudId that will route to a cluster. The cloudId is located in
     */
        this.failureListener = failureListener;  
                fullPath = path;  
        @Override  
        }
        List<Node> nodes,
                @Override  
     */  
        public void onFailure(Node node) {}
                            }
            return asyncResponseConsumer;
        // they are respectively domain name and optional port, opensearch id, opensearch-dashboards id
                    logger.debug("updated [" + node + "] already in denylist");  
        }  
                .getHttpAsyncResponseConsumerFactory()
            logger.debug("removed [" + node + "] from denylist");
    ) throws IOException {
                context.asyncResponseConsumer(),  
            httpRequest.setEntity(entity);  
        }
                }
            if (authScheme != null) {  
import org.apache.hc.client5.http.classic.methods.HttpTrace;
                            return Mono.from(streamRequest(nodeTuple, request));
        public HttpClientContext context() {
                        size = -1L;
        /**  
    /**  
                        try {
    /**  
        void onSuccess(Response response) {
    /**
        private final AsyncRequestProducer requestProducer;
            URIBuilder uriBuilder = new URIBuilder(fullPath);  
        RequestContext<ClassicHttpResponse> createContextForNextAttempt(Node node, AuthCache authCache) {
                            } else {
                    final Credentials creds = credsProvider.getCredentials(authScope, context);
    }
    public static class ContentHttpEntity extends HttpEntityWrapper {  
     * @param nodes the new nodes to communicate with.  
        @Override
                /*
            } else {
            this.asyncResponseConsumer = new ReactiveResponseConsumer(new FutureCallback<Message<HttpResponse, Publisher<ByteBuffer>>>() {
                                    listener.onDefinitiveFailure(responseOrResponseException.responseException);  
                if (logger.isDebugEnabled()) {
            case 503:
     *
            if (b.get() == '\r' && b.hasRemaining() && b.position() > 1) {  
            );
                delegate.remove(host);  
        throw responseOrResponseException.responseException;
        public InputStream asInput() {
import java.util.Set;
            return context;
            throw new IllegalStateException("unexpected exception type: must be either RuntimeException or IOException", cause);  
        public AsyncRequestProducer requestProducer() {  
        if (false == livingNodes.isEmpty()) {
        failureListener.onFailure(node);
        public void writeTo(final OutputStream outStream) throws IOException {
     * A ByteArrayOutputStream that can be turned into an input stream without copying the underlying buffer.
import org.apache.hc.core5.http.HttpResponse;  
        /**
        public long getContentLength() {
     * @throws IOException if no nodes are available
     * Select nodes to try and sorts them so that the first one will be tried initially, then the following ones
     * Called after each successful request call.
                if (future instanceof org.apache.hc.core5.concurrent.Cancellable) {
        // domain name and optional port
        public boolean isChunked() {  
 * specific language governing permissions and limitations
        InternalRequest internalRequest = new InternalRequest(request);  
                        listener.onDefinitiveFailure(Cancellable.newCancellationException());
        InternalStreamingRequest request,
            AuthCache authCache,
            MonoSink<Message<HttpResponse, Publisher<ByteBuffer>>> emitter  
import java.util.concurrent.ConcurrentMap;
     * round-robin fashion. Failing hosts are marked dead and retried after a
        @Override
