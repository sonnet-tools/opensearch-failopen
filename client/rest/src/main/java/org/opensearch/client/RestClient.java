 * failed (the more failures, the later they will be retried). In case of failures all of the alive nodes (or dead nodes that
                public void failed(Exception ex) {
            this.asyncResponseConsumer = new ReactiveResponseConsumer(new FutureCallback<Message<HttpResponse, Publisher<ByteBuffer>>>() {
        final InternalRequest request,
    private void onFailure(Node node) {
            /*
            currentException.addSuppressed(suppressedException);
            for (Map.Entry<String, String> param : params.entrySet()) {
        while (true) {
    }
    }
     * and ensuring that the credentials are indeed provided for particular HttpHost, otherwise returning no authentication scheme
        this.warningsHandler = strictDeprecationMode ? WarningsHandler.STRICT : WarningsHandler.PERMISSIVE;
            onResponse(node);
        public long getContentLength() {
        }
            port = 443;
            streamRequest(nextNodes(), internalRequest)
     * {@link #builder(Node...)}.
    /**
        public void remove() {
            return node;
                return addRequestBody(new HttpPut(uri), entity);
     * Creates a new builder instance and sets the hosts that the client will send requests to.
     * @param b {@link ByteBuffer} to split
        return ignoreErrorCodes;
        public boolean isChunked() {
import java.net.ConnectException;
    /**
        }
            setHeaders(httpRequest, request.getOptions().getHeaders());
import reactor.core.publisher.Flux;
import java.util.Collections;
    public static RestClientBuilder builder(HttpHost... hosts) {
        // Streaming Response could accumulate a lot of data so we may not be able to fully consume it.
            } else {
                    if (creds == null) {
                 */
import reactor.core.publisher.Mono;
                break;
        if (ignoreString == null) {
            case 503:
    private final AtomicInteger lastNodeIndex = new AtomicInteger(0);
            } else {
    public StreamingResponse<ByteBuffer> streamRequest(StreamingRequest<ByteBuffer> request) throws IOException {
    private static class WrappingAuthCache implements AuthCache {
    private final NodeSelector nodeSelector;
            return GZIP_CODEC;
        }
            super(size);
        }
import org.apache.hc.client5.http.auth.AuthScheme;
        }
 */
     */
     * unmodifiable.
    private final ConcurrentMap<HttpHost, DeadHostState> denylist = new ConcurrentHashMap<>();
                    context.requestProducer(),
    }
     * exception this isn't always possible and likely haven't covered all of
 * The hosts that are part of the cluster need to be provided at creation time, but can also be replaced later
         *
    }
        private void setHeaders(HttpRequest httpRequest, Collection<Header> requestHeaders) {
     * Replaces the nodes with which the client communicates.
        }
        this.failureListener = failureListener;
        }
import java.util.Set;
    }
import java.io.OutputStream;
                            listener.onDefinitiveFailure(e);
import org.apache.hc.client5.http.classic.methods.HttpPost;
        if (false == livingNodes.isEmpty()) {
            super(entity);
        client.close();
    /**
         */
                    position = b.position();
        ResponseException responseException = new ResponseException(response);
        }
import org.apache.hc.client5.http.auth.AuthCache;
     * Get the list of nodes that the client knows about. The list is
                                    listener.onDefinitiveFailure(responseOrResponseException.responseException);
        }
            // The Apache HttpClient 5.x **does not** encode URIs but Apache HttpClient 4.x does. It leads
            // ignore is a special parameter supported by the clients, shouldn't be sent to es
                        ((BasicScheme) authScheme).initPreemptive(creds);
            this.ignoreErrorCodes = getIgnoreErrorCodes(ignoreString, request.getMethod());
        this.chunkedEnabled = Optional.empty();
        while (b.hasRemaining()) {
 *
import org.apache.hc.core5.util.Args;
                    buffers.add(ByteBuffer.wrap(chunk, 0, chunk.length - 2));
        }
        @Override
        }
        AsyncRequestProducer requestProducer();
            }
                @Override
     * them does, in which case an {@link IOException} will be thrown.
     * only when we got a response (successful or not to be retried) or there are no hosts to retry against.
        public void put(HttpHost host, AuthScheme authScheme) {
            onFailure(node);
        this.client = client;
        Map<HttpHost, DeadHostState> denylist,
    /**
import org.apache.hc.client5.http.impl.auth.BasicAuthCache;
    final List<Header> defaultHeaders;
            delegate.clear();
                /*
        ) {
                    b.get(chunk);
        String[] decodedParts = decoded.split("\\$");
            setHeaders(httpRequest, request.getOptions().getHeaders());
import java.util.ArrayList;
            }
 * this file be licensed under the Apache-2.0 license or a
        }
         */
        private final HttpUriRequestBase httpRequest;
        Set<Integer> ignoreErrorCodes;
    ) throws IOException {
            this.exception = exception;
            } else {
import org.apache.hc.core5.http.io.entity.HttpEntityWrapper;
     */
         * A gzip compressing entity doesn't work with chunked encoding with sigv4
                ? RestClient.this.warningsHandler
                ? RestClient.this.warningsHandler
            }
                                message.getHead(),
                    entity = new ContentCompressingEntity(entity);
                    final byte[] buf = new byte[8192];
            onFailure(context.node());
            List<Node> selectedLivingNodes = new ArrayList<>(livingNodes);
        InternalRequest(Request request) {
        this.failureListener = failureListener;
            // Only close output stream if the wrapped entity has been
                if (requestNames.contains(defaultHeader.getName()) == false) {
                delegate.remove(host);
                httpRequest.addHeader(requestHeader);
    }
    private void performRequestAsync(
                            RequestLogger.logFailedRequest(logger, request.httpRequest, context.node(), failure);
         * @param node The node which has failed.
import java.io.ByteArrayInputStream;
                    if (responseOrResponseException.responseException == null) {
    }
                    httpRequest.addHeader(defaultHeader);
            return new ResponseOrResponseException(responseException);
     *
            URI uri = buildUri(pathPrefix, request.getEndpoint(), params);
            if (nodeTuple.nodes.hasNext()) {
import java.net.URI;
        @Override
        private final Iterator<DeadNode> itr;
     * The default implementation is a no-op.
        throws IOException {
            if (cause instanceof IOException) {
 * SPDX-License-Identifier: Apache-2.0
     */
        public WrappingAuthCache(HttpClientContext context, AuthCache delegate) {
            /*
     * certain amount of time (minimum 1 minute, maximum 30 minutes), depending
         * @param outStream the output stream to write entity content to
         */
import java.util.HashMap;
                }
package org.opensearch.client;
            InternalStreamingRequest request,
            this.nodes = nodes;
            this.httpRequest = createHttpRequest(request.getMethod(), uri, null);
     */
                : request.getOptions().getWarningsHandler();
            this.node = node;
     * Listener used in any async call to wrap the provided user listener (or SyncResponseListener in sync calls).
            this.itr = itr;
                        size = -1L;
            RequestLogger.logFailedRequest(logger, request.httpRequest, context.node(), e);
        }
            return out.asInput();
         * Create a {@link FailureListener} instance.
        private final HttpClientContext context;
     */
        }
            if (false == selectedDeadNodes.isEmpty()) {
            });
     * @see Node#Node(HttpHost)
            default:
import org.apache.hc.core5.concurrent.FutureCallback;
         * Sort the nodes into living and dead lists.
            Node node,
            }
            URIBuilder uriBuilder = new URIBuilder(fullPath);
     * @param nodes the new nodes to communicate with.
 * <p>
        if (logger.isDebugEnabled() && removedHost != null) {
     * (effectively, username and password are 'null'). To workaround that, wrapping the AuthCache around current HttpClientContext
        }
             * for the request.
        private final AsyncResponseConsumer<ClassicHttpResponse> asyncResponseConsumer;
                    fullPath = pathPrefix + path;
        AtomicInteger lastNodeIndex,
     * contains the call site. While we attempt to preserve the original
                } else {
    private static class DeadNodeIteratorAdapter implements Iterator<Node> {
        @Override
            }
                );
        if (hosts == null || hosts.length == 0) {
        Node node,
            this.response = Objects.requireNonNull(response);
            context.setAuthCache(new WrappingAuthCache(context, authCache));
        Node node();
 *
    private volatile NodeTuple<List<Node>> nodeTuple;
            Node node,
    }
                        } catch (Exception e) {
        RequestLogger.logResponse(logger, request.httpRequest, node.getHost(), httpResponse);
        }
     * nodes that deserve a retry) are retried until one responds or none of
    /**
            } else {
            }
        public FailureListener() {}
        @Override
     * Adapts an <code>Iterator&lt;DeadNodeAndRevival&gt;</code> into an
         * Creates a {@link ContentHttpEntity} instance with the provided HTTP entity.
        private final HttpClientContext context;
                }
        if (cloudId.contains(":")) {
    /**
            }
 * <p>
                                httpResponse
     *
                return addRequestBody(new HttpGet(uri), entity);
        }
    private HttpUriRequestBase createHttpRequest(String method, URI uri, HttpEntity entity) {
    private static final Log logger = LogFactory.getLog(RestClient.class);
import org.apache.hc.core5.http.Message;
            }
            // ignore is a special parameter supported by the clients, shouldn't be sent to es
            responseListener.onFailure(this.exception);
        }
             * We'd like NodeSelectors to remove items directly from deadNodes
            ExecutionException executionException = (ExecutionException) exception;
     * Listener that allows to be notified whenever a failure happens. Useful when sniffing is enabled, so that we can sniff on failure.
         */
            }
 * ownership. Elasticsearch licenses this file to you under
                    null
     * Sends a request to the OpenSearch cluster that the client points to.
        }
        );
        NodeTuple(final T nodes, final AuthCache authCache) {
            return new RuntimeException(exception.getMessage(), exception);
import org.apache.hc.client5.http.classic.methods.HttpHead;
         */
     */
    }
        }
            this.ignoreErrorCodes = getIgnoreErrorCodes(ignoreString, request.getMethod());
            this.chunkedEnabled = Optional.empty();
import org.apache.hc.client5.http.protocol.HttpClientContext;
        }
            SocketTimeoutException e = new SocketTimeoutException(exception.getMessage());
     */
        // once decoded the parts are separated by a $ character.
    static Iterable<Node> selectNodes(
                    return size;
        onResponse(node);
                }
         *
         * @param entity the HTTP entity.
                    ignoreErrorCodes.add(Integer.valueOf(ignoreCode));
        }
        return statusCode < 300;
        public AsyncResponseConsumer<ClassicHttpResponse> asyncResponseConsumer() {
            this.asyncResponseConsumer = request.request.getOptions()
        NodeTuple<List<Node>> nodeTuple = this.nodeTuple;
            String ignoreString = params.remove("ignore");
            Args.notNull(outStream, "Output stream");
     * {@link ResponseListener} gets notified upon request completion or
                            if (nodeTuple.nodes.hasNext()) {
                break;
             * selector is ok with any over the living nodes then use them
            this.httpRequest = createHttpRequest(request.getMethod(), uri, request.getEntity());
            setRequestConfig(httpRequest, request.getOptions().getRequestConfig());
                            listener.onDefinitiveFailure(e);
        String url = decodedParts[1] + "." + domain;
     * Allows to track potential failures coming from the different retry attempts and returning to the original listener
        Message<HttpResponse, Publisher<ByteBuffer>> message
        int statusCode = httpResponse.getCode();
            this.response = null;
                    } catch (IOException ex) {
     * many times they previously failed (the more failures, the later they
        Iterable<Node> hosts = selectNodes(nodeTuple, denylist, lastNodeIndex, nodeSelector);
                ignoreErrorCodes = Collections.emptySet();
    public Response performRequest(Request request) throws IOException {
                    return Mono.error(ex);
 */
         * any living ones. Either way, we want to revive a single dead node
                            );
        this.nodeTuple = new NodeTuple<>(Collections.unmodifiableList(new ArrayList<>(nodesByHost.values())), authCache);
                    public void completed(ClassicHttpResponse httpResponse) {
        AsyncRequestContext(InternalRequest request, Node node, AuthCache authCache) {
            // Skip the chunk separator when it comes right at the beginning
     * @return the response returned by OpenSearch
 * compatible open source license.
    }
        setNodes(nodes);
     * to be set together in a thread safe, volatile way.
import java.util.Base64;
                try {
        public String toString() {
                }
         * Creates a {@link ContentCompressingEntity} instance with the provided HTTP entity.
import org.apache.hc.core5.http.HttpHost;
     * If there are no living nodes that match the {@link NodeSelector}
import org.apache.hc.core5.http.Header;
 * the Apache License, Version 2.0 (the "License"); you may
                requestNames.add(requestHeader.getName());
        }
     * @param request streaming request
     * Receives as an argument the host that was used for the failed attempt.
import java.util.LinkedHashMap;
                        return Mono.just(
    }
        /**
     * for the result. If the asynchronous call throws an exception we wrap
         * @return false
    private final String pathPrefix;
    }
            super(entity);
 * Requests can be traced by enabling trace logging for "tracer". The trace logger outputs requests and responses in curl format.
                            return Mono.from(streamRequest(nodeTuple, request));
    /**
        /**
             */
 */
            return new AsyncRequestContext(this, node, authCache);
import java.util.concurrent.CancellationException;
import org.apache.hc.client5.http.auth.Credentials;
@Deprecated
        final T nodes;
            return e;
                        }
    private static Set<Integer> getIgnoreErrorCodes(String ignoreString, String requestMethod) {
        /**
import org.apache.hc.core5.http.HttpResponse;
        return new NodeTuple<>(hosts.iterator(), nodeTuple.authCache);
        CloseableHttpAsyncClient client,
        if (position != b.position()) {
                    }
            if (compressionEnabled) {
import org.apache.hc.core5.http.ConnectionClosedException;
     *
        List<Node> nodes,
        private final WarningsHandler warningsHandler;
                            )
    ) throws IOException {
            return itr.next().node;
                if (chunkedEnabled.isPresent()) {
     *
        }
        if (exception instanceof SocketTimeoutException) {
            this.chunkedEnabled = Optional.of(chunkedEnabled);
    public boolean isRunning() {
        String pathPrefix,
    private final boolean compressionEnabled;
     * Frame the {@link ByteBuffer} into individual chunks that are separated by '\r\n' sequence.
        void onSuccess(Response response) {
            return node.toString();
            }
            final Set<String> requestNames = new HashSet<>(requestHeaders.size());
            }
            e.initCause(exception);
 * sending a request, a host gets selected out of the provided ones in a round-robin fashion. Failing hosts are marked dead and
            // we stream the request body if the entity allows for it
        @Override
        }
         */
        private final ResponseException responseException;
            // TODO should we throw an IAE if we have two nodes with the same host?
            }
import org.opensearch.client.http.HttpUriRequestProducer;
        public boolean hasNext() {
    public synchronized void setNodes(Collection<Node> nodes) {
        public AsyncRequestProducer requestProducer() {
        }
import org.apache.hc.core5.reactor.IOReactorStatus;
        public InputStream asInput() {
        private final Cancellable cancellable;
    }
        @Override
     * Sends a request to the OpenSearch cluster that the client points to.
                } catch (final Exception ex) {
                                Flux.from(message.getBody()).flatMapSequential(b -> Flux.fromIterable(frame(b)))
        }
            new RequestLine(internalRequest.httpRequest),
        public Node node() {
    }
        ) {
        failureListener.onFailure(node);
        public ContentCompressingEntity(HttpEntity entity) {
     * <p>
        }
        private final WarningsHandler warningsHandler;
        return buffers;
            }
            this.chunkedEnabled = Optional.of(chunkedEnabled);
            this.warningsHandler = request.getOptions().getWarningsHandler() == null
            if (!usePersistentCredentials) {
        return client.getStatus() == IOReactorStatus.ACTIVE;
     * Receives as an argument the host that was used for the successful request.
         * @param entity the HTTP entity.
        }
                            onFailure(context.node());
        return performRequest(nextNodes(), internalRequest, null);
    }
     * {@link Exception#getCause()}.
    private ResponseOrResponseException convertResponse(InternalRequest request, Node node, ClassicHttpResponse httpResponse)
            );
                    @Override
        final Node node;
                        emitter.success();
        if (false == deadNodes.isEmpty()) {
                .getHttpAsyncResponseConsumerFactory()
import java.nio.ByteBuffer;
            b.get(chunk);
            onFailure(node);
            }
            return new ResponseOrResponseException(response);
    }
import java.util.Objects;
import java.util.concurrent.ConcurrentMap;
        if (nodes == null || nodes.isEmpty()) {
            this.request = request;
         * Creates a {@link ContentCompressingEntity} instance with the provided HTTP entity.
        }
        private final Node node;
     * Select nodes to try and sorts them so that the first one will be tried initially, then the following ones
                        try {
            return e;
             */
        /**
             * Normal state: there is at least one living node. If the
        throws IOException {
        }
            case HttpPut.METHOD_NAME:
                ignoreErrorCodes.add(404);
            e.initCause(exception);
            this.request = request;
        NodeSelector nodeSelector,
        /**
 *    http://www.apache.org/licenses/LICENSE-2.0
        @Override
                    logger.debug("updated [" + node + "] already in denylist");
         * are ok. If the selector is ok with any of the nodes then we will take
import org.apache.hc.client5.http.classic.methods.HttpOptions;
     */
         */
        FailureTrackingResponseListener(ResponseListener responseListener) {
                if (pathPrefix.endsWith("/") && path.startsWith("/")) {
            gzip.close();
        return new RuntimeException("error while performing request", exception);
            this.warningsHandler = request.getOptions().getWarningsHandler() == null
            if (authScheme != null) {
            }
                                }
                    request.httpRequest.setDependency((org.apache.hc.core5.concurrent.Cancellable) future);
                entity = new ContentHttpEntity(entity, chunkedEnabled.get());
            super(entity);
            e.initCause(exception);
     * @param nodes The nodes that the client will send requests to.
                new DeadHostState(DeadHostState.DEFAULT_TIME_SUPPLIER)
            ByteArrayInputOutputStream out = new ByteArrayInputOutputStream(1024);
/*
import java.util.Map;
         * which requires isChunked to be true
            if (compressionEnabled) {
     * Creates a new builder instance and sets the nodes that the client will send requests to.
    private HttpUriRequestBase addRequestBody(HttpUriRequestBase httpRequest, HttpEntity entity) {
            ConnectTimeoutException e = new ConnectTimeoutException(exception.getMessage());
        }
        try {
 * You may obtain a copy of the License at
            setRequestConfig(httpRequest, request.getOptions().getRequestConfig());
        return new RestClientBuilder(nodes);
         *
            if (cause instanceof RuntimeException) {
                    int nread = 0;
            // with proper encoding.
            case HttpDelete.METHOD_NAME:
                        );
     * Blocks until the request is completed and returns its response or fails
        throw responseException;
     */
        public ContentHttpEntity(HttpEntity entity) {
                    }
    }
        public ContentCompressingEntity(HttpEntity entity, boolean chunkedEnabled) {
        }
        final NodeTuple<Iterator<Node>> nodeTuple,
                                performRequestAsync(nodeTuple, request, listener);
    private Response performRequest(final NodeTuple<Iterator<Node>> nodeTuple, final InternalRequest request, Exception previousException)
        throw responseException;
                port = Integer.parseInt(domainAndMaybePort[1]);
                } else {
import static java.util.Collections.singletonList;
            for (Header defaultHeader : defaultHeaders) {
            if (deadness == null || deadness.shallBeRetried()) {
                }
                                if (nodeTuple.nodes.hasNext()) {
     * on how many times they previously failed (the more failures, the later
            final Node node = nodeTuple.nodes.next();
                            size += nread;
            }
                context.context(),
            return e;
import org.apache.commons.logging.LogFactory;
        }
 * Modifications Copyright OpenSearch Contributors. See
            final GZIPOutputStream gzip = new GZIPOutputStream(outStream);
/*
    }
        if (domainAndMaybePort.length == 2) {
                @Override
     * that is closest to being revived.
                }
 * by calling {@link #setNodes(Collection)}.
                    fullPath = pathPrefix + "/" + path;
        try {
        private void setRequestConfig(HttpUriRequestBase httpRequest, RequestConfig requestConfig) {
        }
             * list.
    public static class FailureListener {
        @Override
        }
             * so we can find the minimum after it is filtered without having
         * the one in the list that has the lowest revival time and try it.
                throw (RuntimeException) cause;
            throw new IllegalStateException("cloudId " + cloudId + " did not decode to a cluster identifier correctly");
        }
        private final Request request;
     */
        }
     * @param cloudId a valid elastic cloud cloudId that will route to a cluster. The cloudId is located in
            );
        @Override
        private final HttpClientContext context;
        if (exception instanceof RuntimeException) {
     * <p>
import java.util.Optional;
        throw new IOException(
                    if (result == null) {
        switch (statusCode) {
                request.httpRequest.setDependency((org.apache.hc.core5.concurrent.Cancellable) future);
            // mark host dead and retry against next one
        final Collection<ByteBuffer> buffers = new ArrayList<>();
                throw (Error) t;
     */
import java.util.List;
            );
     * @return client running status
        CloseableHttpAsyncClient client,
            ConnectionClosedException e = new ConnectionClosedException(exception.getMessage());
 * Must be created using {@link RestClientBuilder}, which allows to set all the different options or just rely on defaults.
        int port;
        if (exception instanceof ConnectionClosedException) {
    // These are package private for tests.
        this.compressionEnabled = compressionEnabled;
    /**
        /**
    ) {
                    }
            if (pathPrefix != null && pathPrefix.isEmpty() == false) {
            return node;
        ResponseException responseException = new ResponseException(response);
            nodesByHost.put(node.getHost(), node);
     * You can use this if you do not have metadata up front about the nodes. If you do, prefer
            Throwable t = executionException.getCause() == null ? executionException : executionException.getCause();
     * Called after each successful request call.
    private static void addSuppressedException(Exception suppressedException, Exception currentException) {
     */
     * of them does, in which case an {@link IOException} will be thrown.
import org.apache.hc.client5.http.impl.async.CloseableHttpAsyncClient;
        return request.cancellable.callIfNotCancelled(() -> {
            this.cancellable = Cancellable.fromRequest(httpRequest);
            return context;
            // successfully written out
            Objects.requireNonNull(node, "node cannot be null");
            onResponse(node);
 * Requests can be either synchronous or asynchronous. The asynchronous variants all end with {@code Async}.
     */
        @Override
            if (cloudId.indexOf(":") == cloudId.length() - 1) {
        if (isSuccessfulResponse(statusCode) || request.ignoreErrorCodes.contains(response.getStatusLine().getStatusCode())) {
        public void clear() {
        private final StreamingRequest<ByteBuffer> request;
                return singletonList(Collections.min(selectedDeadNodes).node);
    public static RestClientBuilder builder(Node... nodes) {
                    httpRequest.addHeader(defaultHeader);
            });
            return Cancellable.NO_OP;
            return chunkedEnabled.orElseGet(super::isChunked);
        int statusCode = httpResponse.getCode();
import java.util.stream.Collectors;
                            if (responseOrResponseException.responseException == null) {
    static class NodeTuple<T> {
                if (logger.isDebugEnabled()) {
        private volatile Exception exception;
            return Collections.singleton(b);
         * Notifies that the node provided as argument has just failed.
            MonoSink<Message<HttpResponse, Publisher<ByteBuffer>>> emitter
        private final Set<Integer> ignoreErrorCodes;
            if (request.warningsHandler.warningsShouldFailRequest(response.getWarnings())) {
                throw new IllegalStateException("cloudId " + cloudId + " must begin with a human readable identifier followed by a colon");
 * The method {@link #performRequest(Request)} allows to send a request to the cluster. When
        public AsyncRequestProducer requestProducer() {
        private final AsyncRequestProducer requestProducer;
     */
    public static class ContentCompressingEntity extends HttpEntityWrapper {
                }
        }
                    try (InputStream is = getContent()) {
                try {
                                    performRequestAsync(nodeTuple, request, listener);
        try {
    /**
    RestClient(
import static java.nio.charset.StandardCharsets.UTF_8;
            responseListener.onFailure(e);
 * not use this file except in compliance with the License.
                throw new IllegalStateException("cloudId " + cloudId + " does not contain a valid port number");
    }
        public Node node() {
    }
            return requestProducer;
        }
    }
     * Wrap the exception so the caller's signature shows up in the stack trace, taking care to copy the original type and message
    }
            }
        private final Node node;
     * @param request the request to perform
                }
        final StreamingResponse<ByteBuffer> response = new StreamingResponse<>(
            Map<String, String> params = new HashMap<>(request.getParameters());
     *      request is completed or fails
        private void setHeaders(HttpRequest httpRequest, Collection<Header> requestHeaders) {
            "NodeSelector [" + nodeSelector + "] rejected all nodes, " + "living " + livingNodes + " and dead " + deadNodes
import org.apache.hc.core5.http.message.RequestLine;
         *
        @Override
    /**
import org.apache.commons.logging.Log;
                new FutureCallback<ClassicHttpResponse>() {
        @Override
            super(entity);
                    // Do not copy the '\r\n' sequence
     * failure. Selects a host out of the provided ones in a round-robin
        FailureListener failureListener,
        }
         * Creates a {@link ContentHttpEntity} instance with the provided HTTP entity.
            this.responseException = null;
    }
        // there is an optional first portion of the cloudId that is a human readable string, but it is not used.
                                listener.onDefinitiveFailure(failure);
        boolean compressionEnabled
            this.httpRequest.reset();
        }
     */
        onResponse(node);
    }
            return itr.hasNext();
            Map<String, String> params = new HashMap<>(request.getParameters());
     * this will return the dead node that matches the {@link NodeSelector}
    // We don't rely on default headers supported by HttpAsyncClient as those cannot be replaced.
                    throw new IllegalArgumentException("ignore value should be a number, found [" + ignoreString + "] instead", e);
                    public void cancelled() {
                return addRequestBody(new HttpPatch(uri), entity);
         */
        }
         * Notifies the caller of a response through the wrapped listener
            }
        private Optional<Boolean> chunkedEnabled;
            if (b.get() == '\r' && b.hasRemaining() && b.position() > 1) {
            super.writeTo(gzip);
        public String getContentEncoding() {
                Collections.rotate(selectedLivingNodes, lastNodeIndex.getAndIncrement());
    }
        @Override
     * amount of time (minimum 1 minute, maximum 30 minutes), depending on how
            this.context = context;
        }
    private Publisher<Message<HttpResponse, Publisher<ByteBuffer>>> streamRequest(
     * even if it is present in the cache.
        String domain = domainAndMaybePort[0];
         * Returns content encoding of the entity, if known.
        );
        // domain name and optional port
     * Prefer this to {@link #builder(HttpHost...)} if you have metadata up front about the nodes.
         */
import java.io.ByteArrayOutputStream;
         */
        }
                throw (IOException) cause;
            this.node = node;
        }
        this.chunkedEnabled = Optional.of(chunkedEnabled);
            String[] ignoresArray = ignoreString.split(",");
                    }
                @Override
        });
 * under the License.
                        while ((nread = is.read(buf)) > 0) {
        this.defaultHeaders = Collections.unmodifiableList(Arrays.asList(defaultHeaders));
        for (Node node : nodes) {
        private final AsyncResponseConsumer<Void> asyncResponseConsumer;
        if (decodedParts.length != 3) {
                return performRequest(nodeTuple, request, cause);
                return addRequestBody(new HttpTrace(uri), entity);
import java.net.SocketTimeoutException;
            if (compressionEnabled) {
    /**
        }
        private DeadNodeIteratorAdapter(Iterator<DeadNode> itr) {
                    } else {
     */
            DeadHostState previousDeadHostState = denylist.putIfAbsent(
 *
 * deserve a retry) are retried until one responds or none of them does, in which case an {@link IOException} will be thrown.
    private final Optional<Boolean> chunkedEnabled;
        private final HttpUriRequestBase httpRequest;
        }
        );
            String fullPath;
            // mark host dead and retry against next one
     * An entity that lets the caller specify the return value of {@code isChunked()}.
        DeadHostState removedHost = this.denylist.remove(node.getHost());
        }
import java.net.URISyntaxException;
                            return Mono.error(responseOrResponseException.responseException);
     * dead nodes that deserve a retry) are retried until one responds or none
            buffers.add(ByteBuffer.wrap(chunk, 0, chunk.length));
import org.apache.hc.core5.http.ClassicHttpResponse;
            }
                }
        final AuthCache authCache;
    private NodeTuple<Iterator<Node>> nextNodes() throws IOException {
        String decoded = new String(Base64.getDecoder().decode(cloudId), UTF_8);
        }
             * to compare many things. This saves us a sort on the unfiltered
}
    /**
                    emitter.error(ex);
 * software distributed under the License is distributed on an
        return false;
            this.context = HttpClientContext.create();
 * <p>
        setNodes(nodes);
/**
     * it and rethrow it so that the stack trace attached to the exception
        }
        } catch (Exception e) {
import org.apache.hc.core5.net.URIBuilder;
                    b.position(position);
                super.writeTo(gzipOut);
         * @param chunkedEnabled force enable/disable chunked transfer-encoding.
                throw new UnsupportedOperationException("http method not supported: " + method);
        public void remove(HttpHost host) {
            if (requestConfig != null) {
                ignoreErrorCodes = Collections.singleton(404);
        ReactiveRequestContext(
    private final CloseableHttpAsyncClient client;
        return new RestClientBuilder(nodes == null ? null : Arrays.asList(nodes));
                exception.getMessage() + "\nSee https://opensearch.org/docs/latest/clients/java-rest-high-level/ for troubleshooting."
     * they will be retried). In case of failures all of the alive nodes (or
        final InternalStreamingRequest internalRequest = new InternalStreamingRequest(request);
import org.apache.hc.core5.http.HttpEntity;
     * @throws IOException in case of a problem or the connection was aborted
     * @param hosts The hosts that the client will send requests to.
        boolean strictDeprecationMode,
import org.reactivestreams.Publisher;
        return httpRequest;
            }
     * A gzip compressing entity that also implements {@code getContent()}.
                 * requests will try the nodes in a different order.
            DeadHostState deadness = denylist.get(node.getHost());
    /**
        List<DeadNode> deadNodes = new ArrayList<>(denylist.size());
                    @Override
            }
        } catch (URISyntaxException e) {
        AsyncResponseConsumer<T> asyncResponseConsumer();
     *
            return deadness.compareTo(rhs.deadness);
import org.apache.hc.client5.http.impl.auth.BasicScheme;
        ClassicHttpResponse httpResponse;
            return new ByteArrayInputStream(this.buf, 0, this.count);
            responseListener.onSuccess(response);
     * @param request the request to perform
        if (exception instanceof SSLHandshakeException) {
    /**
                httpRequest.setConfig(requestConfig);
            final List<DeadNode> selectedDeadNodes = new ArrayList<>(deadNodes);
            this.delegate = delegate;
     * Contains a reference to a denylisted node and the time until it is
            throw new IllegalStateException("unexpected exception type: must be either RuntimeException or IOException", cause);
     * Returns a new {@link RestClientBuilder} to help with {@link RestClient} creation.
            cloudId = cloudId.substring(cloudId.indexOf(":") + 1);
            String ignoreString = params.remove("ignore");
     * This method works by performing an asynchronous call and waiting
                node.getHost(),
            nodeSelector.select(selectedLivingNodes);
                        }
                return -1;
        RequestContext<ClassicHttpResponse> context = request.createContextForNextAttempt(nodeTuple.nodes.next(), nodeTuple.authCache);
                                } else {
            performRequestAsync(nextNodes(), internalRequest, failureTrackingResponseListener);
    private final WarningsHandler warningsHandler;
        private final ResponseListener responseListener;
        @Override
            throw new IllegalArgumentException("hosts must not be null nor empty");
            httpRequest.setEntity(entity);
        ResponseOrResponseException(ResponseException responseException) {
         */
        }
            );
         *
        }
            return asyncResponseConsumer;
        public ContentHttpEntity(HttpEntity entity, boolean chunkedEnabled) {
                return true;
                    final Credentials creds = credsProvider.getCredentials(authScope, context);
    private static class AsyncRequestContext implements RequestContext<ClassicHttpResponse> {
        } else {
                        try {
                                context.node(),
     *
                // 404 never causes error if returned for a HEAD request
import java.util.Locale;
                            }
            case HttpPost.METHOD_NAME:
    private ResponseOrResponseException convertResponse(
 * Licensed to Elasticsearch under one or more contributor
                throw new WarningFailureException(response);
     * The Apache HttpClient 5 adds "Authorization" header even if the credentials for basic authentication are not provided
            URI uri = buildUri(pathPrefix, request.getEndpoint(), params);
        public InputStream getContent() throws IOException {
        /**
        AuthCache authCache = new BasicAuthCache();
        private static final String GZIP_CODEC = "gzip";
import java.io.IOException;
    public void close() throws IOException {
 * official <a href="https://github.com/opensearch-project/opensearch-java">OpenSearch Java client</a>
                : request.getOptions().getWarningsHandler();
        throw responseOrResponseException.responseException;
        /**
                uriBuilder.addParameter(param.getKey(), param.getValue());
        if (isSuccessfulResponse(statusCode) || request.ignoreErrorCodes.contains(response.getStatusLine().getStatusCode())) {
import javax.net.ssl.SSLHandshakeException;
 * specific language governing permissions and limitations
    }
            }
import java.util.Arrays;
        request.cancellable.runIfNotCancelled(() -> {
                if (future instanceof org.apache.hc.core5.concurrent.Cancellable) {
import org.apache.hc.core5.reactive.ReactiveResponseConsumer;
                        emitter.success(result);
 * this work for additional information regarding copyright
        if (buffers.isEmpty()) {
                                    listener.trackFailure(responseOrResponseException.responseException);
    public static class ContentHttpEntity extends HttpEntityWrapper {
                return addRequestBody(new HttpOptions(uri), entity);
                        // read to EOF which may read more or less than buffer size
            // request headers override default headers, so we don't add default headers if they exist as request headers
            delegate.put(host, authScheme);
                } else {
                httpRequest.addHeader("Accept-Encoding", "gzip");
        public void onFailure(Node node) {}
                }
        /**
import org.apache.hc.client5.http.classic.methods.HttpGet;
        boolean chunkedEnabled
        private final AuthCache delegate;
        List<Node> nodes,
        }
        public HttpClientContext context() {
        this.denylist.clear();
    }
     * <p>
            final RequestContext<ClassicHttpResponse> context = request.createContextForNextAttempt(
     */
            }
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                return addRequestBody(new HttpHead(uri), entity);
        } else {
            addSuppressedException(this.exception, exception);
        Objects.requireNonNull(path, "path must not be null");
                    if (authScheme instanceof BasicScheme) {
        if (responseOrResponseException.responseException == null) {
    static URI buildUri(String pathPrefix, String path, Map<String, String> params) {
        if (exception instanceof ExecutionException) {
 * Client that connects to an OpenSearch cluster through HTTP.
                    context.context(),
            b.position(position);
        // mark host alive and don't retry, as the error should be a request problem
        ByteArrayInputOutputStream(int size) {
            MonoSink<Message<HttpResponse, Publisher<ByteBuffer>>> emitter
                    }
     * check client running status
     */
 * <p>
                deadNodes.add(new DeadNode(node, deadness));
     * the cases. You can get the original exception from
        if (entity != null) {
            if (HttpHead.METHOD_NAME.equals(requestMethod)) {
                if (logger.isDebugEnabled()) {
            throw new IllegalArgumentException(e.getMessage(), e);
            }
        Header[] defaultHeaders,
        @Override
                context.requestProducer(),
     */
        private final boolean usePersistentCredentials = true;
    }
            itr.remove();
                context.asyncResponseConsumer(),
         * that the NodeSelectors are OK with. We do this by passing the dead
        if (exception instanceof InterruptedException) {
            if (t instanceof Error) {
                    final byte[] chunk = new byte[b.position() - position];
        }
        @Override
            if (requestConfig != null) {
                            }
        this.warningsHandler = strictDeprecationMode ? WarningsHandler.STRICT : WarningsHandler.PERMISSIVE;
        }
                    entity = new ContentCompressingEntity(entity, chunkedEnabled.get());
        switch (method.toUpperCase(Locale.ROOT)) {
                    @Override
    private class InternalStreamingRequest {
                 * Rotate the list using a global counter as the distance so subsequent
            ignoreErrorCodes = new HashSet<>();
    static class FailureTrackingResponseListener {
        /*
         * @param entity the HTTP entity.
        }
            for (Header defaultHeader : defaultHeaders) {
                    }
            e.initCause(exception);
            } catch (NumberFormatException nfe) {
     * @throws IOException IOException
     * <code>Iterator&lt;Node&gt;</code>.
    /**
                        } else {
    /**
            case 504:
    private final FailureListener failureListener;
 * retried after a certain amount of time (minimum 1 minute, maximum 30 minutes), depending on how many times they previously
            this.requestProducer = ReactiveHttpUriRequestProducer.create(request.httpRequest, node.getHost(), request.getPublisher());
     * @throws IOException if no nodes are available
            AuthCache authCache,
        }
            }
            Exception cause = extractAndWrapCause(e);
        }
        @Override
    }
        }
    private static class DeadNode implements Comparable<DeadNode> {
                }
                    public void failed(Exception failure) {
         */
     * Returns a non-empty {@link Iterator} of nodes to be used for a request
                    } else {
     * will be retried). In case of failures all of the alive nodes (or dead
                }
        private void setRequestConfig(HttpUriRequestBase httpRequest, RequestConfig requestConfig) {
        }
            }
        /**
        InternalRequest internalRequest = new InternalRequest(request);
     * If you don't either one is fine.
        return builder(new HttpHost("https", url, port));
     * fashion. Failing hosts are marked dead and retried after a certain
            if (denylist.replace(node.getHost(), previousDeadHostState, new DeadHostState(previousDeadHostState))) {
            AuthCache authCache,
                    context.asyncResponseConsumer(),
            return new IOException(exception.getMessage(), exception);
        });
            for (Header requestHeader : requestHeaders) {
        } catch (Exception e) {
import java.util.Collection;
 * KIND, either express or implied.  See the License for the
        RequestContext<Void> createContextForNextAttempt(
        InternalStreamingRequest(StreamingRequest<ByteBuffer> request) {
            for (Header requestHeader : requestHeaders) {
            try (GZIPOutputStream gzipOut = new GZIPOutputStream(out)) {
    }
        this.compressionEnabled = compressionEnabled;
                                request,
        @Override
            }
     * Sends a streaming request to the OpenSearch cluster that the client points to and returns streaming response. <strong>This is an experimental API</strong>.
            InternalRequest internalRequest = new InternalRequest(request);
            e.initCause(exception);
         * @return content length of gzip entity
 * The OpenSearch Contributors require contributions made to
                            } else {
        String pathPrefix,
                        return null;
                    }
                    // See please https://issues.apache.org/jira/browse/HTTPCLIENT-2203
            if (chunkedEnabled.isPresent()) {
        public AuthScheme get(HttpHost host) {
    /**
        RequestLogger.logResponse(logger, request.httpRequest, node.getHost(), httpResponse);
        final Response response = new Response(new RequestLine(request.httpRequest), node.getHost(), httpResponse);
        Map<HttpHost, Node> nodesByHost = new LinkedHashMap<>();
    private void onResponse(Node node) {
         *
    }
     * The request is executed asynchronously and the provided
        addSuppressedException(previousException, responseOrResponseException.responseException);
                requestNames.add(requestHeader.getName());
     *                the user console https://cloud.elastic.co and will resemble a string like the following
        private final AsyncRequestProducer requestProducer;
            this.authCache = authCache;
            final Mono<Message<HttpResponse, Publisher<ByteBuffer>>> publisher = Mono.create(emitter -> {
     * where possible so async and sync code don't have to check different exceptions.
     * Called after each failed attempt.
         */
        }
            this.requestProducer = HttpUriRequestProducer.create(request.httpRequest, node.getHost());
        private final Response response;
        }
            case HttpTrace.METHOD_NAME:
                httpRequest.addHeader(requestHeader);
                        }
     * Returns a new {@link RestClientBuilder} to help with {@link RestClient} creation.
import org.apache.hc.core5.http.nio.AsyncRequestProducer;
        }
            this.chunkedEnabled = Optional.empty();
        List<Node> livingNodes = new ArrayList<>(Math.max(0, nodeTuple.nodes.size() - denylist.size()));
import org.apache.hc.client5.http.ClientProtocolException;
        }
    private static Collection<ByteBuffer> frame(ByteBuffer b) {
            }
            }
            FailureTrackingResponseListener failureTrackingResponseListener = new FailureTrackingResponseListener(responseListener);
        // they are respectively domain name and optional port, opensearch id, opensearch-dashboards id
            return requestProducer;
    }
        FailureListener failureListener,
            }
    /**
                        }
        public void writeTo(final OutputStream outStream) throws IOException {
                }
        List<Node> nodes = Arrays.stream(hosts).map(Node::new).collect(Collectors.toList());
            Future<ClassicHttpResponse> future = client.execute(
                final Future<Void> future = client.execute(
         * Tracks an exception, which caused a retry hence we should not return yet to the caller
        this.nodeSelector = nodeSelector;
            // we stream the request body if the entity allows for it
            try {
            AuthScheme authScheme = delegate.get(host);
            return new ReactiveRequestContext(this, node, authCache, emitter);
    /**
        for (Node node : nodeTuple.nodes) {
     * {@link NodeTuple} enables the {@linkplain Node}s and {@linkplain AuthCache}
        @Override
            exception = (Exception) t;
    private static boolean isSuccessfulResponse(int statusCode) {
     * that match the {@link NodeSelector}.
            return publisher.flatMap(message -> {
            return e;
            }
            case HttpOptions.METHOD_NAME:
                }
            throw new IllegalArgumentException("nodes must not be null or empty");
     */
    @Override
        private final Set<Integer> ignoreErrorCodes;
                    return -1L;
    }
        }
                final CredentialsProvider credsProvider = context.getCredentialsProvider();
    }
            case 502:
import java.util.HashSet;
import org.apache.hc.client5.http.ConnectTimeoutException;
        Response response = new Response(new RequestLine(request.httpRequest), node.getHost(), httpResponse);
    private static class ByteArrayInputOutputStream extends ByteArrayOutputStream {
         * Writes the entity content out to the output stream.
         * Last resort: there are no good nodes to use, either because
import org.apache.hc.core5.http.nio.AsyncResponseConsumer;
     * by throwing an exception. Selects a host out of the provided ones in a
                return selectedLivingNodes;
     * Returns a new {@link RestClientBuilder} to help with {@link RestClient} creation.
        ResponseOrResponseException responseOrResponseException = convertResponse(request, context.node(), httpResponse);
    }
                public void completed(Message<HttpResponse, Publisher<ByteBuffer>> result) {
        /**
        this.nodeSelector = nodeSelector;
import org.apache.hc.core5.http.HttpRequest;
        return response;
        @Override
                }
            case HttpGet.METHOD_NAME:
import org.apache.hc.client5.http.config.RequestConfig;
        }
        this.pathPrefix = pathPrefix;
        int position = b.position();
    }
    ) throws IOException {
            case HttpPatch.METHOD_NAME:
            message.getHead().getCode(),
     * @return individual chunks
     * @param responseListener the {@link ResponseListener} to notify when the
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;
    /**
                fullPath = path;
            addSuppressedException(previousException, cause);
                                listener.trackFailure(failure);
        private final Cancellable cancellable;
        final InternalStreamingRequest request
        }
    public static RestClientBuilder builder(String cloudId) {
                    long size = 0;
    }
            return new ResponseOrResponseException(responseException);
    }
        this.defaultHeaders = Collections.unmodifiableList(Arrays.asList(defaultHeaders));
                public void cancelled() {
         * @param entity the HTTP entity.
import java.util.zip.GZIPOutputStream;
                } else if (pathPrefix.endsWith("/") || path.startsWith("/")) {
         * A gzip entity requires content length in http headers.
                        if (nodeTuple.nodes.hasNext()) {
            this.responseListener = responseListener;
import java.util.Iterator;
                if (requestNames.contains(defaultHeader.getName()) == false) {
import org.apache.hc.client5.http.classic.methods.HttpPatch;
            return responseOrResponseException.response;
        }
        if (suppressedException != null) {
                httpRequest.addHeader("Accept-Encoding", "gzip");
            return chunkedEnabled.orElseGet(super::isChunked);
                .createHttpAsyncResponseConsumer();
            if (future instanceof org.apache.hc.core5.concurrent.Cancellable) {
            message.getHead().getReasonPhrase()
        public AsyncResponseConsumer<Void> asyncResponseConsumer() {
        this.client = client;
        @Override
            return performRequest(nodeTuple, request, responseOrResponseException.responseException);
    }
            return e;
        /**
        HttpClientContext context();
            // to the issues with Unicode characters (f.e. document IDs could contain Unicode characters) and
            if (false == selectedLivingNodes.isEmpty()) {
                                listener.onSuccess(responseOrResponseException.response);
         * @param chunkedEnabled force enable/disable chunked transfer-encoding.
                HttpPost httpPost = new HttpPost(uri);
/*
import org.opensearch.client.http.ReactiveHttpUriRequestProducer;
                            ResponseOrResponseException responseOrResponseException = convertResponse(
        DeadNode(Node node, DeadHostState deadness) {
        }
        }
 * @deprecated the {@code RestClient} is deprecated and is going to be removed in future releases, please consider using the
import org.apache.hc.core5.http.message.BasicClassicHttpResponse;
    private class InternalRequest {
    /**
     * <p>
     * Creates a new builder instance and sets the nodes that the client will send requests to.
import java.io.InputStream;
        }
        final ClassicHttpResponse httpResponse = new BasicClassicHttpResponse(
    private static Exception extractAndWrapCause(Exception exception) {
        Header[] defaultHeaders,
    }
     */
        if (nodeTuple.nodes.hasNext()) {
     * @return streaming response
        public Node next() {
                    fullPath = pathPrefix.substring(0, pathPrefix.length() - 1) + path;
    }
    /**
            return asyncResponseConsumer;
import java.util.concurrent.ExecutionException;
            authCache.put(node.getHost(), new BasicScheme());
        if (exception instanceof IOException) {
        /*
        NodeTuple<List<Node>> nodeTuple,
     *                optionalHumanReadableName:dXMtZWFzdC0xLmF3cy5mb3VuZC5pbyRlbGFzdGljc2VhcmNoJGtpYmFuYQ==
import org.apache.hc.client5.http.classic.methods.HttpDelete;
        /**
                } catch (NumberFormatException e) {
                            } else {
        @Override
        public boolean isChunked() {
                addRequestBody(httpPost, entity);
        }
            for (String ignoreCode : ignoresArray) {
    }
            return internalRequest.cancellable;
            }
 *
         * @return true
         * Returns a content stream of the entity.
                nodeTuple.nodes.next(),
            ConnectException e = new ConnectException(exception.getMessage());
            this.context = HttpClientContext.create();
    private static boolean isRetryStatus(int statusCode) {
        NodeSelector nodeSelector
    /**
    ) {
            final byte[] chunk = new byte[b.position() - position];
            context.setAuthCache(new WrappingAuthCache(context, authCache));
     */
        /**
     * Close the underlying {@link CloseableHttpAsyncClient} instance
                    logger.debug("added [" + node + "] to denylist");
        ResponseOrResponseException(Response response) {
        RequestContext<ClassicHttpResponse> createContextForNextAttempt(Node node, AuthCache authCache) {
        this.pathPrefix = pathPrefix;
import org.apache.hc.client5.http.auth.CredentialsProvider;
         */
    }
        boolean strictDeprecationMode,
                final RequestContext<Void> context = request.createContextForNextAttempt(node, nodeTuple.authCache, emitter);
        }
        if (exception instanceof ConnectTimeoutException) {
    RestClient(
        final DeadHostState deadness;
        NodeSelector nodeSelector,
        }
        final NodeTuple<Iterator<Node>> nodeTuple,
            throw new RuntimeException("thread waiting for the response was interrupted", exception);
        // mark host alive and don't retry, as the error should be a request problem
        // Copy last chunk
        /**
                    failed(new CancellationException("Future cancelled"));
import java.io.Closeable;
            });
                        } catch (Exception e) {
            return authScheme;
import org.apache.hc.client5.http.classic.methods.HttpTrace;
            this.node = node;
                    }
    }
 */
                return addRequestBody(new HttpDelete(uri), entity);
    /**
                throw new WarningFailureException(response);
            this.responseException = Objects.requireNonNull(responseException);
        if (isRetryStatus(statusCode)) {
         * A chunked entity requires transfer-encoding:chunked in http headers
                    final ResponseOrResponseException responseOrResponseException = convertResponse(request, node, message);
import org.apache.hc.client5.http.auth.AuthScope;
            }
                return httpPost;
        final FailureTrackingResponseListener listener
        }
        }
                if (b.get() == '\n') {
        }
         *
            return new URI(uriBuilder.build().toASCIIString());
            logger.debug("removed [" + node + "] from denylist");
        }
     */
                    final AuthScope authScope = new AuthScope(host, null, schemeName);
import java.util.concurrent.atomic.AtomicInteger;
        String[] domainAndMaybePort = decodedParts[0].split(":", 2);
            if (HttpHead.METHOD_NAME.equals(requestMethod)) {
        }
import org.apache.hc.client5.http.classic.methods.HttpPut;
 * GitHub history for details.
                    final String schemeName = authScheme.getName();
        void trackFailure(Exception exception) {
         */
            SSLHandshakeException e = new SSLHandshakeException(
        boolean compressionEnabled,
    private interface RequestContext<T> {
    public List<Node> getNodes() {
            if (previousDeadHostState == null) {
     */
     * @throws ClientProtocolException in case of an http protocol error
        private Optional<Boolean> chunkedEnabled;
         *
         * @throws IOException if an I/O error occurs
                nodeTuple.authCache
        }
                            new Message<>(
                livingNodes.add(node);
    /**
public class RestClient implements Closeable {
            if (request.warningsHandler.warningsShouldFailRequest(response.getWarnings())) {
 * license agreements. See the NOTICE file distributed with
         * Tracks one last definitive failure and returns to the caller by notifying the wrapped listener
import reactor.core.publisher.MonoSink;
                // 404 never causes error if returned for a HEAD request
import java.util.concurrent.ConcurrentHashMap;
        public Publisher<ByteBuffer> getPublisher() {
        }
     * revived. We use this so we can do a single pass over the denylist.
        if (exception instanceof ConnectException) {
         */
     * if the previous attempt failed and so on. Package private for testing.
        @Override
     * A ByteArrayOutputStream that can be turned into an input stream without copying the underlying buffer.
        }
            this.deadness = deadness;
    private static class ResponseOrResponseException {
        public HttpClientContext context() {
            nodeSelector.select(() -> new DeadNodeIteratorAdapter(selectedDeadNodes.iterator()));
                }
import java.util.concurrent.Future;
                        listener.onDefinitiveFailure(Cancellable.newCancellationException());
    ) {
     * @throws ResponseException in case OpenSearch responded with a status code that indicated an error
                if (credsProvider != null) {
        void onDefinitiveFailure(Exception exception) {
            case HttpHead.METHOD_NAME:
    }
            return context;
                if (chunkedEnabled.get()) {
            return new ResponseOrResponseException(response);
            return request.getBody();
    private static class ReactiveRequestContext implements RequestContext<Void> {
 * Unless required by applicable law or agreed to in writing,
        public int compareTo(DeadNode rhs) {
     * round-robin fashion. Failing hosts are marked dead and retried after a
    public Cancellable performRequestAsync(Request request, ResponseListener responseListener) {
         */
            // weird characters are being passed instead. By using `toASCIIString()`, the URI is already created
         * the selector rejected all the living nodes or because there aren't
        }
            this.httpRequest.reset();
                httpRequest.setConfig(requestConfig);
        InternalStreamingRequest request,
        }
            httpResponse = client.execute(context.requestProducer(), context.asyncResponseConsumer(), context.context(), null).get();
            trackFailure(exception);
        return nodeTuple.nodes;
        if (isRetryStatus(statusCode)) {
        }
         * nodes through the NodeSelector so it can have its say in which nodes
            this.cancellable = Cancellable.fromRequest(httpRequest);
        }
            } else if (chunkedEnabled.isPresent()) {
            final Set<String> requestNames = new HashSet<>(requestHeaders.size());
            // request headers override default headers, so we don't add default headers if they exist as request headers
