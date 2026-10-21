        this.defaultHeaders = Collections.unmodifiableMap(defaultHeaders);
            if (t instanceof Error) {
        }
package org.opensearch.internal.httpclient;
 * sending a request, a host gets selected out of the provided ones in a round-robin fashion. Failing hosts are marked dead and
        private DeadNodeIteratorAdapter(Iterator<DeadNode> itr) {
     */
import java.net.URISyntaxException;
            for (Map.Entry<String, List<String>> requestHeader : requestHeaders.entrySet()) {
        }
         *
        } catch (Exception e) {
            onFailure(node);
     * Called after each failed attempt.
            return itr.next().node;
     * exception this isn't always possible and likely haven't covered all of
        // once decoded the parts are separated by a $ character.
        List<Node> nodes = Arrays.stream(hosts).map(Node::new).collect(Collectors.toList());
            e.initCause(exception);
        return HttpRequest.newBuilder()
        }
 * compatible open source license.
                if (logger.isDebugEnabled()) {
                URI uri = buildUri(pathPrefix, request.endpoint(), params);
    private void onFailure(Node node) {
     * <p>
        }
        HttpResponse<List<ByteBuffer>> httpResponse;
                newQuery += "&" + additionalQuery;
        this.warningsHandler = strictDeprecationMode ? WarningsHandler.STRICT : WarningsHandler.PERMISSIVE;
                /*
    private final ConcurrentMap<HttpHost, DeadHostState> denylist = new ConcurrentHashMap<>();
        return streamRequest(nextNodes(), internalRequest);
        public Node node() {
        if (isRetryStatus(statusCode)) {
        return new RestHttpClientBuilder(nodes);
            return responseOrResponseException.response;
                    return e.getKey() + "=" + URLEncoder.encode(e.getValue(), StandardCharsets.UTF_8);
     * @param request streaming request
            }
        });
        }
            .uri(URI.create(node.getHost().toString()).resolve(uri))
        /**
     * revived. We use this so we can do a single pass over the denylist.
    RestHttpClient(
    private final FailureListener failureListener;
                node.getHost(),
        List<DeadNode> deadNodes = new ArrayList<>(denylist.size());
                    final ResponseOrResponseException responseOrResponseException = convertResponse(request, node, response);
                }
        if (cloudId.contains(":")) {
    }
        }
                    } catch (Exception e) {
            // ignore is a special parameter supported by the clients, shouldn't be sent to es
                URI uri = buildUri(pathPrefix, request.endpoint(), params);
            Objects.requireNonNull(node, "node cannot be null");
            return e;
     * Get the list of nodes that the client knows about. The list is
        if (ignoreString == null) {
            throw new IllegalArgumentException("hosts must not be null nor empty");
    private static class AsyncRequestContext implements RequestContext<List<ByteBuffer>> {
    private volatile List<Node> nodes;
        }
import java.util.concurrent.ExecutionException;
                        if (responseOrResponseException.responseException == null) {
            return e;
    }
                }
    }
        }
            if (cause instanceof RuntimeException) {
            InternalRequest internalRequest = new InternalRequest(request);
        final Iterator<Node> nodes,
        }
 * retried after a certain amount of time (minimum 1 minute, maximum 30 minutes), depending on how many times they previously
                }
                context.asyncResponseConsumer()
     * {@link Exception#getCause()}.
         * Create a {@link FailureListener} instance.
        this.nodeSelector = nodeSelector;
            }
        }
        return ignoreErrorCodes;
    private HttpRequest.Builder createStreamingHttpRequest(
            cloudId = cloudId.substring(cloudId.indexOf(":") + 1);
                ignoreErrorCodes.add(404);
     * Replaces the nodes with which the client communicates.
     *
                    logger.debug("added [" + node + "] to denylist");
                newQuery = additionalQuery;
        FailureTrackingResponseListener(ResponseListener responseListener) {
                requestHeader.getValue().forEach(v -> httpRequest.header(requestHeader.getKey(), v));
         * the selector rejected all the living nodes or because there aren't
    }
        private void setHeaders(HttpRequest.Builder httpRequest, Map<String, List<String>> requestHeaders) {
        Set<Integer> ignoreErrorCodes;
import java.net.http.HttpResponse.BodyHandlers;
        /*
import java.net.URLEncoder;
    }
 *
     *                the user console https://cloud.elastic.co and will resemble a string like the following
        }
            }
        private final WarningsHandler warningsHandler;
import org.apache.commons.logging.LogFactory;
        }
        /**
     * Contains a reference to a denylisted node and the time until it is
            throw new RuntimeException("thread waiting for the response was interrupted", exception);
                throw new IllegalStateException("cloudId " + cloudId + " does not contain a valid port number");
        if (exception instanceof RuntimeException) {
     */
                return true;
             * list.
                }
     */
    private static class DeadNodeIteratorAdapter implements Iterator<Node> {
    private void performRequestAsync(
    }
        boolean compressed
            return new StreamingResponse(new RequestLine(request.httpRequest.apply(node)), streamRequest(node, nodes, request));
            if (request.warningsHandler.warningsShouldFailRequest(response.warnings())) {
                return builder.build();
            for (Map.Entry<String, List<String>> defaultHeader : defaultHeaders.entrySet()) {
    private class InternalRequest {
        this.pathPrefix = pathPrefix;
        ResponseException responseException = new ResponseException(response);
                throw new WarningFailureException(response);
        HttpResponse<Flow.Publisher<List<ByteBuffer>>> httpResponse
        List<Node> nodes,
            this.responseException = Objects.requireNonNull(responseException);
     */
        @Override
            future.whenComplete((httpResponse, throwable) -> {
import java.util.Base64;
}
                }
     * You can use this if you do not have metadata up front about the nodes. If you do, prefer
     * Creates a new builder instance and sets the nodes that the client will send requests to.
        onResponse(node);
     * that match the {@link NodeSelector}.
            throw new IllegalStateException("cloudId " + cloudId + " did not decode to a cluster identifier correctly");
                httpRequest.header("Accept-Encoding", "gzip");
        return new RestHttpClientBuilder(nodes == null ? null : Arrays.asList(nodes));
     * unmodifiable.
    /**
        }
             * Normal state: there is at least one living node. If the
            this.ignoreErrorCodes = getIgnoreErrorCodes(ignoreString, request.method());
import org.apache.commons.logging.Log;
        @Override
            if (cause instanceof IOException) {
        final InternalRequest request,
        RequestContext<List<ByteBuffer>> context = request.createContextForNextAttempt(node);
import java.util.concurrent.Flow;
     */
        }
             * selector is ok with any over the living nodes then use them
     * Receives as an argument the host that was used for the successful request.
                httpRequest.header("Content-Encoding", "gzip");
        if (exception instanceof SocketTimeoutException) {
     * failure. Selects a host out of the provided ones in a round-robin
            throw new IllegalArgumentException(e.getMessage(), e);
 * deserve a retry) are retried until one responds or none of them does, in which case an {@link IOException} will be thrown.
                        if (nodes.hasNext()) {
    }
        if (isRetryStatus(statusCode)) {
     * @param request the request to perform
                        )
        }
import java.util.ArrayList;
     * If you don't either one is fine.
            case 502:
     * <p>
            return new RuntimeException(exception.getMessage(), exception);
            .timeout(timeout)
     * Creates a new builder instance and sets the nodes that the client will send requests to.
                 * requests will try the nodes in a different order.
                            onFailure(context.node());
                        }
        Map<String, List<String>> defaultHeaders,
    }
     * <code>Iterator&lt;Node&gt;</code>.
            return new ResponseOrResponseException(responseException);
        Node node = nodes.next();
            httpResponse = client.send(context.requestProducer(), context.asyncResponseConsumer());
            exception = (Exception) t;
            return e;
import java.net.http.HttpRequest;
 * Note: This is an experimental API.
        }
            DeadHostState previousDeadHostState = denylist.putIfAbsent(
     */
        throw responseException;
 * <p>
            FailureTrackingResponseListener failureTrackingResponseListener = new FailureTrackingResponseListener(responseListener);
                                listener.trackFailure(responseOrResponseException.responseException);
        boolean compressionEnabled
        Node node,
                throw new IllegalStateException("cloudId " + cloudId + " must begin with a human readable identifier followed by a colon");
        RequestContext<Flow.Publisher<List<ByteBuffer>>> createContextForNextAttempt(Node node) {
        Publisher<ByteBuffer> body,
    public synchronized void setNodes(Collection<Node> nodes) {
        }
     * check client running status
     * they will be retried). In case of failures all of the alive nodes (or
                    try {
        Objects.requireNonNull(path, "path must not be null");
     * will be retried). In case of failures all of the alive nodes (or dead
import reactor.adapter.JdkFlowAdapter;
                    : compressed == false ? body
    }
            this.node = node;
     * amount of time (minimum 1 minute, maximum 30 minutes), depending on how
     * Sends a request to the OpenSearch cluster that the client points to.
    }
    }
    private HttpRequest.Builder createHttpRequest(
     */
        InternalRequest internalRequest = new InternalRequest(request);
            return requestProducer;
            for (Map.Entry<String, List<String>> defaultHeader : defaultHeaders.entrySet()) {
        Node node();
        /**
     *
 * by calling {@link #setNodes(Collection)}.
        request.cancellable.runIfNotCancelled(() -> {
            if (request.warningsHandler.warningsShouldFailRequest(response.warnings())) {
     * Adapts an <code>Iterator&lt;DeadNodeAndRevival&gt;</code> into an
             * so we can find the minimum after it is filtered without having
            .uri(URI.create(node.getHost().toString()).resolve(uri))
            if (denylist.replace(node.getHost(), previousDeadHostState, new DeadHostState(previousDeadHostState))) {
    public static RestHttpClientBuilder builder(Node... nodes) {
                                listener.trackFailure(failure);
    }
import java.net.http.HttpRequest.BodyPublishers;
 *
        ReactiveRequestContext(InternalStreamingRequest request, Node node) {
        void onSuccess(Response response) {
                    request.body(),
        public int compareTo(DeadNode rhs) {
        if (decodedParts.length != 3) {
            HttpTimeoutException e = new HttpTimeoutException(exception.getMessage());
     * @see Node#Node(HttpHost)
            }
            SocketTimeoutException e = new SocketTimeoutException(exception.getMessage());
            if (false == selectedLivingNodes.isEmpty()) {
                if (httpResponse != null) {
import java.util.concurrent.ConcurrentMap;
import java.util.Collection;
            .method(
            /*
     * nodes that deserve a retry) are retried until one responds or none of
            if (deadness == null || deadness.shallBeRetried()) {
        }
                            cause = ce;
 * <p>
        @Override
            );
            return deadness.compareTo(rhs.deadness);
        String method,
                                performRequestAsync(nodes, request, listener);
        return false;
import java.time.Duration;
            // TODO should we throw an IAE if we have two nodes with the same host?
        return performRequest(nextNodes(), internalRequest, null);
                    request.options().getTimeout(),
    private interface RequestContext<T> {
            }
    }
import java.nio.channels.ClosedChannelException;
    static Iterable<Node> selectNodes(
        }
        @Override
     * it and rethrow it so that the stack trace attached to the exception
                (body == null) ? BodyPublishers.noBody()
    private final HttpClient client;
     * this will return the dead node that matches the {@link NodeSelector}
         * nodes through the NodeSelector so it can have its say in which nodes
                    } else {
                            } else {
        }
     * Receives as an argument the host that was used for the failed attempt.
            for (Map.Entry<String, List<String>> requestHeader : requestHeaders.entrySet()) {
            Map<String, String> params = new HashMap<>(request.parameters());
                    compressionEnabled
        public Node next() {
    ) {
             */
    private Publisher<HttpResponse<Flow.Publisher<List<ByteBuffer>>>> streamRequest(
        }
            );
                    defaultHeader.getValue().forEach(v -> httpRequest.header(defaultHeader.getKey(), v));
        }
     */
            this.node = node;
    }
        private final Function<Node, HttpRequest> httpRequest;
        public Node node() {
                    return Mono.error(ex);
    /**
        final Node node;
            this.warningsHandler = request.options().getWarningsHandler() == null
        Response response = Response.from(new RequestLine(httpRequest), node.getHost(), httpResponse);
    private static Exception extractAndWrapCause(Exception exception) {
        /**
        RequestLogger.logResponse(logger, httpRequest, node.getHost(), httpResponse);
                httpRequest.header("Content-Encoding", "gzip");
            ignoreErrorCodes = new HashSet<>();
        FailureListener failureListener,
     */
     * certain amount of time (minimum 1 minute, maximum 30 minutes), depending
                            if (nodes.hasNext()) {
                requestHeader.getValue().forEach(v -> httpRequest.header(requestHeader.getKey(), v));
    }
import static java.nio.charset.StandardCharsets.UTF_8;
     * where possible so async and sync code don't have to check different exceptions.
import java.util.Map;
            this.warningsHandler = request.options().getWarningsHandler() == null
                                performRequestAsync(nodes, request, listener);
                            } else {
import java.util.Objects;
     * This method works by performing an asynchronous call and waiting
        );
     * @param nodes the new nodes to communicate with.
         */
                } catch (NumberFormatException e) {
            this.responseListener = responseListener;
            if (pathPrefix != null && pathPrefix.isEmpty() == false) {
            for (String ignoreCode : ignoresArray) {
         * Sort the nodes into living and dead lists.
            this.responseException = null;
        RequestLogger.logStreamingResponse(logger, request.httpRequest.apply(node), node.getHost(), httpResponse);
        } else {
            ClosedChannelException e = new ClosedChannelException();
     *                optionalHumanReadableName:dXMtZWFzdC0xLmF3cy5mb3VuZC5pbyRlbGFzdGljc2VhcmNoJGtpYmFuYQ==
                    logger.debug("updated [" + node + "] already in denylist");
        ResponseOrResponseException(Response response) {
        // there is an optional first portion of the cloudId that is a human readable string, but it is not used.
    private Iterator<Node> nextNodes() throws IOException {
                    request.method(),
import java.util.concurrent.CompletionException;
     */
            cancellable = Cancellable.fromFuture(f);
    private Response performRequest(final Iterator<Node> nodes, final InternalRequest request, Exception previousException)
                final HttpRequest.Builder builder = createHttpRequest(
                            RequestLogger.logFailedRequest(logger, request.httpRequest, context.node(), failure);
    public StreamingResponse streamRequest(StreamingRequest request) throws IOException {
        private final Node node;
import java.util.Collections;
                ignoreErrorCodes = Collections.singleton(404);
    public List<Node> getNodes() {
            nodesByHost.put(node.getHost(), node);
    final Map<String, List<String>> defaultHeaders;
        String method,
             * to compare many things. This saves us a sort on the unfiltered
        }
                setHeaders(builder, request.options().getHeaders());
                }
            if (previousDeadHostState == null) {
     * the cases. You can get the original exception from
                            return Mono.error(responseOrResponseException.responseException);
                }
        client.shutdownNow();
    private static Set<Integer> getIgnoreErrorCodes(String ignoreString, String requestMethod) {
/*
                context.requestProducer(),
     * Sends a streaming request to the OpenSearch cluster that the client points to and returns streaming response. <strong>This is an experimental API</strong>.
import java.net.http.HttpClient;
     * fashion. Failing hosts are marked dead and retried after a certain
        String[] domainAndMaybePort = decodedParts[0].split(":", 2);
                HttpRequest.Builder builder = createStreamingHttpRequest(
        }
        throw responseOrResponseException.responseException;
        }
        final HttpRequest httpRequest = request.httpRequest.apply(node);
    private ResponseOrResponseException convertResponse(InternalRequest request, Node node, HttpResponse<List<ByteBuffer>> httpResponse)
            String[] ignoresArray = ignoreString.split(",");
            if ("HEAD".equalsIgnoreCase(requestMethod)) {
        for (Node node : nodes) {
                            JdkFlowAdapter.flowPublisherToFlux(body).buffer().map(BodyUtils::compress).flatMap(Flux::fromIterable)
        if (false == livingNodes.isEmpty()) {
        BodyHandler<T> asyncResponseConsumer();
            }
     * The default implementation is a no-op.
        // domain name and optional port
     */
        Duration timeout,
 * failed (the more failures, the later they will be retried). In case of failures all of the alive nodes (or dead nodes that
            DeadHostState deadness = denylist.get(node.getHost());
             * We'd like NodeSelectors to remove items directly from deadNodes
                        }
    }
     * @throws ResponseException in case OpenSearch responded with a status code that indicated an error
            return new ResponseOrResponseException(response);
            itr.remove();
         * Notifies the caller of a response through the wrapped listener
        // mark host alive and don't retry, as the error should be a request problem
            );
        try {
            }
        private void setHeaders(HttpRequest.Builder httpRequest, Map<String, List<String>> requestHeaders) {
     * Listener used in any async call to wrap the provided user listener (or SyncResponseListener in sync calls).
        List<Node> nodes = this.nodes;
        InternalRequest(Request request) {
        final InternalStreamingRequest internalRequest = new InternalStreamingRequest(request);
            };
     *
                    throw new IllegalArgumentException("ignore value should be a number, found [" + ignoreString + "] instead", e);
            onResponse(node);
        void onDefinitiveFailure(Exception exception) {
            nodeSelector.select(() -> new DeadNodeIteratorAdapter(selectedDeadNodes.iterator()));
            return asyncResponseConsumer;
                            if (nodes.hasNext()) {
        public String toString() {
            throw new IllegalArgumentException("nodes must not be null or empty");
    public boolean isRunning() {
        }
                );
        private final Set<Integer> ignoreErrorCodes;
import java.util.HashMap;
    private void onResponse(Node node) {
                setHeaders(builder, request.options().getHeaders());
                    } else {
    /**
        if (exception instanceof HttpTimeoutException) {
    /**
        if (isSuccessfulResponse(statusCode) || request.ignoreErrorCodes.contains(response.statusLine().statusCode())) {
     * for the result. If the asynchronous call throws an exception we wrap
        }
            return internalRequest.cancellable;
                    }
        DeadHostState removedHost = this.denylist.remove(node.getHost());
    ) {
        RequestContext<List<ByteBuffer>> createContextForNextAttempt(Node node) {
        HttpClient client,
        }
        if (exception instanceof IOException) {
import java.nio.ByteBuffer;
    /**
                } else if (throwable instanceof Exception failure) {
                new DeadHostState(DeadHostState.DEFAULT_TIME_SUPPLIER)
     * Listener that allows to be notified whenever a failure happens. Useful when sniffing is enabled, so that we can sniff on failure.
import java.util.concurrent.atomic.AtomicInteger;
 * The hosts that are part of the cluster need to be provided at creation time, but can also be replaced later
import java.net.SocketTimeoutException;
                        JdkFlowAdapter.publisherToFlowPublisher(
            }
        public HttpRequest requestProducer() {
                exception.getMessage() + "\nSee https://opensearch.org/docs/latest/clients/java-rest-high-level/ for troubleshooting."
            if (compressionEnabled) {
            this.exception = exception;
                    node,
    /**
    }
        InternalStreamingRequest(StreamingRequest request) {
     * @param responseListener the {@link ResponseListener} to notify when the
        failureListener.onFailure(node);
            this.asyncResponseConsumer = BodyHandlers.fromSubscriber(new AsyncResponseProducer(), AsyncResponseProducer::getResult);
    public static class FailureListener {
            return itr.hasNext();
            "NodeSelector [" + nodeSelector + "] rejected all nodes, " + "living " + livingNodes + " and dead " + deadNodes
    }
                break;
     *
        AtomicInteger lastNodeIndex,
         */
        int port;
            return new ReactiveRequestContext(this, node);
                throw (RuntimeException) cause;
        this.client = client;
            // ignore is a special parameter supported by the clients, shouldn't be sent to es
        // Streaming Response could accumulate a lot of data so we may not be able to fully consume it.
     * @throws IOException IOException
                try {
        if (false == deadNodes.isEmpty()) {
            .method(
import java.util.LinkedHashMap;
        setNodes(nodes);
        if (exception instanceof ExecutionException || exception instanceof CompletionException) {
                        ResponseOrResponseException responseOrResponseException = convertResponse(request, context.node(), httpResponse);
         * Notifies that the node provided as argument has just failed.
            }
        this.nodes = Collections.unmodifiableList(new ArrayList<>(nodesByHost.values()));
import java.util.concurrent.CompletableFuture;
    ) {
        this.compressionEnabled = compressionEnabled;
            return node.toString();
        onResponse(node);
        }
        final Response response = Response.fromStreaming(new RequestLine(httpRequest), node.getHost(), httpResponse);
    ) throws IOException {
        }
        NodeSelector nodeSelector,
import java.net.URI;
            String newQuery = uri.getQuery();
     * @param hosts The hosts that the client will send requests to.
        }
    private class InternalStreamingRequest {
        // mark host alive and don't retry, as the error should be a request problem
            addSuppressedException(this.exception, exception);
        for (Node node : nodes) {
 * Must be created using {@link RestHttpClientBuilder}, which allows to set all the different options or just rely on defaults.
    public void close() throws IOException {
            }
        private final Set<Integer> ignoreErrorCodes;
         */
     * Close the underlying {@link HttpClient} instance
        } catch (URISyntaxException e) {
        }
                    if (responseOrResponseException.responseException == null) {
        /*
     * If there are no living nodes that match the {@link NodeSelector}
        }
    /**
                        try {
        if (nodes.hasNext()) {
    }
            this.response = Objects.requireNonNull(response);
                throw new WarningFailureException(response);
                : request.options().getWarningsHandler();
                return performRequest(nodes, request, cause);
 * this file be licensed under the Apache-2.0 license or a
            SSLHandshakeException e = new SSLHandshakeException(
        InternalStreamingRequest request,
     * Called after each successful request call.
            this.response = null;
        public void onFailure(Node node) {}
        private final ResponseListener responseListener;
                } else {
                }
        public HttpRequest requestProducer() {
        private final Response response;
        private final BodyHandler<List<ByteBuffer>> asyncResponseConsumer;
        private final HttpRequest requestProducer;
    /**
        // they are respectively domain name and optional port, opensearch id, opensearch-dashboards id
     */
    static URI buildUri(String pathPrefix, String path, Map<String, String> params) {
    }
    /**
import java.io.Closeable;
        try {
        BodyPublisher body,
import reactor.core.publisher.Mono;
            cancellable = Cancellable.fromFuture(f);
                    fullPath = pathPrefix.substring(0, pathPrefix.length() - 1) + path;
     * Wrap the exception so the caller's signature shows up in the stack trace, taking care to copy the original type and message
     * Returns a non-empty {@link Iterator} of nodes to be used for a request
        }
        if (exception instanceof SSLHandshakeException) {
     * The request is executed asynchronously and the provided
            onFailure(node);
    public static RestHttpClientBuilder builder(HttpHost... hosts) {
            // mark host dead and retry against next one
import java.util.stream.Collectors;
            responseListener.onFailure(this.exception);
            final List<DeadNode> selectedDeadNodes = new ArrayList<>(deadNodes);
            onResponse(node);
         * any living ones. Either way, we want to revive a single dead node
    }
    private static final Log logger = LogFactory.getLog(RestHttpClient.class);
        }
        }
    private static class ResponseOrResponseException {
        if (exception instanceof ClosedChannelException) {
            if (cloudId.indexOf(":") == cloudId.length() - 1) {
            // we stream the request body if the entity allows for it
            );
        }
                        } else {
        List<Node> nodes,
        Map<HttpHost, Node> nodesByHost = new LinkedHashMap<>();
        final DeadHostState deadness;
            }
            if (compressionEnabled) {
     * @return streaming response
                return builder.build();
     * Returns a new {@link RestHttpClientBuilder} to help with {@link RestHttpClient} creation.
     */
        void trackFailure(Exception exception) {
public class RestHttpClient implements Closeable {
        private final WarningsHandler warningsHandler;
        }
            }
            });
            case 504:
        }
        @Override
        }
                    fullPath = pathPrefix + "/" + path;
                } catch (final Exception ex) {
                if (logger.isDebugEnabled()) {
     * Sends a request to the OpenSearch cluster that the client points to.
            return performRequest(nodes, request, responseOrResponseException.responseException);
         * that the NodeSelectors are OK with. We do this by passing the dead
    private static class ReactiveRequestContext implements RequestContext<Flow.Publisher<List<ByteBuffer>>> {
     * of them does, in which case an {@link IOException} will be thrown.
        if (exception instanceof InterruptedException) {
        URI uri,
            // request headers override default headers, so we don't add default headers if they exist as request headers
import java.net.http.HttpResponse;
    /**
    }
            responseListener.onFailure(e);
        }
                    defaultHeader.getValue().forEach(v -> httpRequest.header(defaultHeader.getKey(), v));
                        } else {
        if (logger.isDebugEnabled() && removedHost != null) {
                fullPath = path;
                    request.method(),
            this.node = node;
import java.net.http.HttpResponse.BodyHandler;
         * are ok. If the selector is ok with any of the nodes then we will take
import java.util.Set;
            final RequestContext<List<ByteBuffer>> context = request.createContextForNextAttempt(nodes.next());
            } else {
            final URI uri = URI.create(fullPath);
        /**
        return nodes;
            }
                    compressionEnabled
 * Client that connects to an OpenSearch cluster through HTTP.
            throw new IllegalStateException("unexpected exception type: must be either RuntimeException or IOException", cause);
        }
            }
        DeadNode(Node node, DeadHostState deadness) {
        }
     * {@link ResponseListener} gets notified upon request completion or
     * Allows to track potential failures coming from the different retry attempts and returning to the original listener
            return new AsyncRequestContext(this, node);
 * <p>
            String ignoreString = params.remove("ignore");
        switch (statusCode) {
            currentException.addSuppressed(suppressedException);
        throw new IOException(
            return requestProducer;
        }
             */
    }
                : request.options().getWarningsHandler();
    private static boolean isSuccessfulResponse(int statusCode) {
            /*
     * by throwing an exception. Selects a host out of the provided ones in a
                httpRequest.header("Accept-Encoding", "gzip");
        }
     * @param request the request to perform
    }
    private final WarningsHandler warningsHandler;
                    }
            return asyncResponseConsumer;
 * <p>
     *
            // request headers override default headers, so we don't add default headers if they exist as request headers
import java.util.Iterator;
            trackFailure(exception);
    @Override
import java.util.function.Function;
     * dead nodes that deserve a retry) are retried until one responds or none
        private final BodyHandler<Flow.Publisher<List<ByteBuffer>>> asyncResponseConsumer;
                 */
     */
     * if the previous attempt failed and so on. Package private for testing.
        private void setCancellable(Future<?> f) {
            );
     * @throws IOException if no nodes are available
    private static void addSuppressedException(Exception suppressedException, Exception currentException) {
    }
                method,
 * The method {@link #performRequest(Request)} allows to send a request to the cluster. When
        }
        public void remove() {
                return singletonList(Collections.min(selectedDeadNodes).node);
            this.ignoreErrorCodes = getIgnoreErrorCodes(ignoreString, request.method());
import reactor.core.publisher.Flux;
     * {@link #builder(Node...)}.
 * Requests can be either synchronous or asynchronous. The asynchronous variants all end with {@code Async}.
            final Set<String> requestNames = new HashSet<>(requestHeaders.size());
                ? RestHttpClient.this.warningsHandler
            };
         */
        final InternalStreamingRequest request
                throw (IOException) cause;
 */
                requestNames.add(requestHeader.getKey());
        if (suppressedException != null) {
 * Requests can be traced by enabling trace logging for "tracer". The trace logger outputs requests and responses in curl format.
                break;
import java.util.Arrays;
                    : BodyPublishers.fromPublisher(
     * Returns a new {@link RestHttpClientBuilder} to help with {@link RestHttpClient} creation.
        private volatile Cancellable cancellable = Cancellable.fromFuture(new CompletableFuture<>());
                // 404 never causes error if returned for a HEAD request
    public Cancellable performRequestAsync(Request request, ResponseListener responseListener) {
                            }
        @Override
        Map<HttpHost, DeadHostState> denylist,
        final FailureTrackingResponseListener listener
        if (exception instanceof ConnectException) {
                            }
            this.requestProducer = request.httpRequest.apply(node);
    public static RestHttpClientBuilder builder(String cloudId) {
            return new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), newQuery, uri.getFragment());
        return new RuntimeException("error while performing request", exception);
                    if (failure instanceof CancellationException) {
        if (responseOrResponseException.responseException == null) {
            e.initCause(exception);
            performRequestAsync(nextNodes(), internalRequest, failureTrackingResponseListener);
            // mark host dead and retry against next one
    ) {
            e.initCause(exception);
            final CompletableFuture<HttpResponse<Flow.Publisher<List<ByteBuffer>>>> future = client.sendAsync(
            } else {
                    uri,
         */
            onFailure(context.node());
        private final Node node;
            try {
                // 404 never causes error if returned for a HEAD request
        public FailureListener() {}
    public Response performRequest(Request request) throws IOException {
            return publisher;
            this.itr = itr;
import java.net.ConnectException;
            }
            e.initCause(exception);
            request.setCancellable(future);
        final Node node,
                port = Integer.parseInt(domainAndMaybePort[1]);
                ? RestHttpClient.this.warningsHandler
         */
                        Exception cause = failure;
        private volatile Exception exception;
                    request.entity(),
        Node node,
            request.setCancellable(future);
                method,
        return hosts.iterator();
                    uri,
        public BodyHandler<Flow.Publisher<List<ByteBuffer>>> asyncResponseConsumer() {
                 * Rotate the list using a global counter as the distance so subsequent
                throw (Error) t;
        }
        }
        if (hosts == null || hosts.length == 0) {
 * The OpenSearch Contributors require contributions made to
            logger.debug("removed [" + node + "] from denylist");
        AsyncRequestContext(InternalRequest request, Node node) {
        HttpRequest requestProducer();
                );
/**
import org.reactivestreams.Publisher;
        throws IOException {
            Map<String, String> params = new HashMap<>(request.parameters());
        if (domainAndMaybePort.length == 2) {
        final HttpRequest httpRequest = request.httpRequest.apply(node);
     * @return client running status
                    )
import java.nio.charset.StandardCharsets;
     * <p>
        }
        throws IOException {
        });
     * on how many times they previously failed (the more failures, the later
        Iterable<Node> hosts = selectNodes(nodes, denylist, lastNodeIndex, nodeSelector);
                        }
    /**
            }
            }
import java.net.http.HttpTimeoutException;
        if (isSuccessfulResponse(statusCode) || request.ignoreErrorCodes.contains(response.statusLine().statusCode())) {
        return request.cancellable.callIfNotCancelled(() -> {
    ) throws IOException {
        }
                    ignoreErrorCodes.add(Integer.valueOf(ignoreCode));
     * Select nodes to try and sorts them so that the first one will be tried initially, then the following ones
            List<Node> selectedLivingNodes = new ArrayList<>(livingNodes);
        List<Node> livingNodes = new ArrayList<>(Math.max(0, nodes.size() - denylist.size()));
import static java.util.Collections.singletonList;
                    : BodyPublishers.fromPublisher(JdkFlowAdapter.publisherToFlowPublisher(Flux.from(body).map(BodyUtils::compress)))
    /**
     * Prefer this to {@link #builder(HttpHost...)} if you have metadata up front about the nodes.
        String url = decodedParts[1] + "." + domain;
        if (nodes == null || nodes.isEmpty()) {
            this.httpRequest = node -> {
        Duration timeout,
                    : compressed == false ? BodyPublishers.fromPublisher(JdkFlowAdapter.publisherToFlowPublisher(body))
            .timeout(timeout)
    /**
     * Blocks until the request is completed and returns its response or fails
            if (false == selectedDeadNodes.isEmpty()) {
         * Last resort: there are no good nodes to use, either because
            }
         * @param node The node which has failed.
        client.close();
        URI uri,
        public boolean hasNext() {
                requestNames.add(requestHeader.getKey());
        int statusCode = httpResponse.statusCode();
                } else if (pathPrefix.endsWith("/") || path.startsWith("/")) {
                    fullPath = pathPrefix + path;
        private void setCancellable(Future<?> f) {
                if (e.getValue() == null) {
        @Override
            } catch (NumberFormatException nfe) {
        String[] decodedParts = decoded.split("\\$");
        }
                                listener.onDefinitiveFailure(responseOrResponseException.responseException);
        }
import java.util.HashSet;
        }
            this.asyncResponseConsumer = BodyHandlers.ofPublisher();
            final RequestContext<Flow.Publisher<List<ByteBuffer>>> context = request.createContextForNextAttempt(node);
            Exception cause = extractAndWrapCause(e);
import java.util.List;
                ignoreErrorCodes = Collections.emptySet();
            String ignoreString = params.remove("ignore");
            );
    /**
    static class FailureTrackingResponseListener {
            }
            final Mono<HttpResponse<Flow.Publisher<List<ByteBuffer>>>> publisher = Mono.fromCompletionStage(future).flatMap(response -> {
        @Override
    private StreamingResponse streamRequest(final Iterator<Node> nodes, final InternalStreamingRequest request) throws IOException {
            }
            } else {
        boolean compressed
     * @return the response returned by OpenSearch
         * Tracks one last definitive failure and returns to the caller by notifying the wrapped listener
    private static boolean isRetryStatus(int statusCode) {
        }
            RequestLogger.logFailedRequest(logger, request.httpRequest, context.node(), e);
        }
    /**
     */
    }
                if (pathPrefix.endsWith("/") && path.startsWith("/")) {
            return new ResponseOrResponseException(response);
        } catch (Exception e) {
    }
    ) throws IOException {
         */
        while (true) {
        public BodyHandler<List<ByteBuffer>> asyncResponseConsumer() {
                            listener.onSuccess(responseOrResponseException.response);
        String decoded = new String(Base64.getDecoder().decode(cloudId), UTF_8);
        ResponseException responseException = new ResponseException(response);
                        } catch (Exception e) {
            } else {
        int statusCode = httpResponse.statusCode();
     * @throws IOException in case of a problem or the connection was aborted
            return new ResponseOrResponseException(responseException);
        }
    }
     * @param cloudId a valid elastic cloud cloudId that will route to a cluster. The cloudId is located in
    /**
        return request.cancellable.callIfNotCancelled(() -> {
    /**
                Collections.rotate(selectedLivingNodes, lastNodeIndex.getAndIncrement());
                (body == null) ? BodyPublishers.noBody()
        addSuppressedException(previousException, responseOrResponseException.responseException);
            responseListener.onSuccess(response);
        private final HttpRequest requestProducer;
            e.initCause(exception);
            if (newQuery == null) {
        this.failureListener = failureListener;
     * @param nodes The nodes that the client will send requests to.
            if ("HEAD".equalsIgnoreCase(requestMethod)) {
        NodeSelector nodeSelector
     * contains the call site. While we attempt to preserve the original
import java.util.concurrent.ConcurrentHashMap;
    }
    }
        });
            return e;
    }
            return e;
    }
        throw responseException;
                } else {
    /**
        String domain = domainAndMaybePort[0];
     */
            return new IOException(exception.getMessage(), exception);
    private final String pathPrefix;
            final String additionalQuery = params.entrySet().stream().map(e -> {
        private volatile Cancellable cancellable = Cancellable.fromFuture(new CompletableFuture<>());
            }
    }
                        if (failure instanceof CompletionException && failure.getCause() instanceof Exception ce) {
                if (requestNames.contains(defaultHeader.getKey()) == false) {
        Node node,
        }
        return client.isTerminated() == false;
import java.net.http.HttpRequest.BodyPublisher;
        ResponseOrResponseException(ResponseException responseException) {
    private final AtomicInteger lastNodeIndex = new AtomicInteger(0);
            if (nodes.hasNext()) {
             * for the request.
     * Creates a new builder instance and sets the hosts that the client will send requests to.
     */
            ConnectException e = new ConnectException(exception.getMessage());
    private final boolean compressionEnabled;
        return HttpRequest.newBuilder()
            });
                livingNodes.add(node);
         * the one in the list that has the lowest revival time and try it.
        }
import java.io.IOException;
            final Node node = nodes.next();
            Throwable t = exception.getCause() == null ? exception : exception.getCause();
            }
                context.asyncResponseConsumer()
            case 503:
        boolean strictDeprecationMode,
     * only when we got a response (successful or not to be retried) or there are no hosts to retry against.
                    return e.getKey();
     * round-robin fashion. Failing hosts are marked dead and retried after a
                                listener.onDefinitiveFailure(cause);
                        }
            }).collect(Collectors.joining("&"));
        private final Function<Node, HttpRequest> httpRequest;
                deadNodes.add(new DeadNode(node, deadness));
        private final Iterator<DeadNode> itr;
                }
                    request.options().getTimeout(),
    }
         * Tracks an exception, which caused a retry hence we should not return yet to the caller
            this.deadness = deadness;
     *
     * many times they previously failed (the more failures, the later they
 */
        } else {
    }
            CompletableFuture<HttpResponse<List<ByteBuffer>>> future = client.sendAsync(
            return Cancellable.NO_OP;
        }
                if (requestNames.contains(defaultHeader.getKey()) == false) {
                context.requestProducer(),
     *      request is completed or fails
                    node,
 * SPDX-License-Identifier: Apache-2.0
                        return Mono.just(response);
                        listener.onDefinitiveFailure(Cancellable.newCancellationException());
        return statusCode < 300;
            return node;
     * that is closest to being revived.
        @Override
            this.httpRequest = node -> {
    }
     * them does, in which case an {@link IOException} will be thrown.
import javax.net.ssl.SSLHandshakeException;
    }
            String fullPath;
            this.requestProducer = request.httpRequest.apply(node);
        String pathPrefix,
     */
        @Override
            final Set<String> requestNames = new HashSet<>(requestHeaders.size());
                    }
        @Override
import java.util.concurrent.Future;
     * <p>
    private ResponseOrResponseException convertResponse(
                            return Mono.from(streamRequest(nodes.next(), nodes, request));
    /**
        this.denylist.clear();
     */
        private final ResponseException responseException;
        ResponseOrResponseException responseOrResponseException = convertResponse(request, context.node(), httpResponse);
                        listener.onDefinitiveFailure(e);
            port = 443;
                try {
        final Iterator<Node> nodes,
                            listener.onDefinitiveFailure(e);
            addSuppressedException(previousException, cause);
    }
import java.util.concurrent.CancellationException;
            }
            nodeSelector.select(selectedLivingNodes);
        }
    private final NodeSelector nodeSelector;
    }
    private static class DeadNode implements Comparable<DeadNode> {
        return builder(new HttpHost("https", url, port));
            return node;
        }
                return selectedLivingNodes;
        try {
     * Returns a new {@link RestHttpClientBuilder} to help with {@link RestHttpClient} creation.
            }
