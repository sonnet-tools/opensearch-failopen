            case 502:
import java.util.Collections;
            addSuppressedException(previousException, cause);
    }  
            e.initCause(exception);
     * Receives as an argument the host that was used for the failed attempt.
        }
            responseListener.onFailure(this.exception);  
                throw (IOException) cause;  
     * Returns a non-empty {@link Iterator} of nodes to be used for a request
            case 504:  
            }).collect(Collectors.joining("&"));
    }  
                    fullPath = pathPrefix.substring(0, pathPrefix.length() - 1) + path;  
                }  
 * Requests can be either synchronous or asynchronous. The asynchronous variants all end with {@code Async}.
                deadNodes.add(new DeadNode(node, deadness));
    /**  
    }
    public void close() throws IOException {
            nodesByHost.put(node.getHost(), node);  
            );
                            } else {
        Node node = nodes.next();
     * You can use this if you do not have metadata up front about the nodes. If you do, prefer
         */
                return singletonList(Collections.min(selectedDeadNodes).node);
    private static Set<Integer> getIgnoreErrorCodes(String ignoreString, String requestMethod) {
    public StreamingResponse streamRequest(StreamingRequest request) throws IOException {
     */  
        }
                context.requestProducer(),
        int statusCode = httpResponse.statusCode();
    }
        /**
        }  
    /**
        if (exception instanceof IOException) {
        private void setHeaders(HttpRequest.Builder httpRequest, Map<String, List<String>> requestHeaders) {
import java.net.http.HttpResponse.BodyHandler;  
    /**
            SocketTimeoutException e = new SocketTimeoutException(exception.getMessage());  
                context.asyncResponseConsumer()  
        this.denylist.clear();  
                throw new IllegalStateException("cloudId " + cloudId + " must begin with a human readable identifier followed by a colon");
        public void onFailure(Node node) {}  
                }
    }  
            }  
    private interface RequestContext<T> {
        }
     * for the result. If the asynchronous call throws an exception we wrap  
        List<DeadNode> deadNodes = new ArrayList<>(denylist.size());
        @Override  
        Map<String, List<String>> defaultHeaders,
        } catch (Exception e) {  
                fullPath = path;
        );  
            this.httpRequest = node -> {  
     * @param cloudId a valid elastic cloud cloudId that will route to a cluster. The cloudId is located in
        @Override
    }  
 * The OpenSearch Contributors require contributions made to  
                : request.options().getWarningsHandler();
            ClosedChannelException e = new ClosedChannelException();
     * will be retried). In case of failures all of the alive nodes (or dead
             */
            HttpTimeoutException e = new HttpTimeoutException(exception.getMessage());
        }  
        String decoded = new String(Base64.getDecoder().decode(cloudId), UTF_8);  
     */  
            return e;
        return request.cancellable.callIfNotCancelled(() -> {
        InternalStreamingRequest request,
         * Tracks an exception, which caused a retry hence we should not return yet to the caller
    private class InternalStreamingRequest {  
         */  
            onResponse(node);  
        String url = decodedParts[1] + "." + domain;
        @Override  
            DeadHostState previousDeadHostState = denylist.putIfAbsent(
            this.exception = exception;
        }
    }
 * this file be licensed under the Apache-2.0 license or a
            final List<DeadNode> selectedDeadNodes = new ArrayList<>(deadNodes);
import java.io.IOException;
import java.net.http.HttpResponse.BodyHandlers;
            return node.toString();  
            return responseOrResponseException.response;  
        boolean compressionEnabled
                httpRequest.header("Accept-Encoding", "gzip");
            .method(
import java.util.function.Function;
                    } catch (Exception e) {  
            for (Map.Entry<String, List<String>> requestHeader : requestHeaders.entrySet()) {
            final RequestContext<Flow.Publisher<List<ByteBuffer>>> context = request.createContextForNextAttempt(node);  
import java.util.concurrent.CompletableFuture;  
        int statusCode = httpResponse.statusCode();  
        }
                    if (responseOrResponseException.responseException == null) {
        /**
            return deadness.compareTo(rhs.deadness);
        }  
 * The method {@link #performRequest(Request)} allows to send a request to the cluster. When
                ? RestHttpClient.this.warningsHandler
        AsyncRequestContext(InternalRequest request, Node node) {  
        return hosts.iterator();  
        if (ignoreString == null) {  
            // mark host dead and retry against next one
            }
    private final AtomicInteger lastNodeIndex = new AtomicInteger(0);  
        }
            try {
                        }
        if (exception instanceof HttpTimeoutException) {
     * revived. We use this so we can do a single pass over the denylist.
            // ignore is a special parameter supported by the clients, shouldn't be sent to es  
import org.apache.commons.logging.Log;
    }
    /**  
                    }
        }  
import java.nio.charset.StandardCharsets;
            nodeSelector.select(() -> new DeadNodeIteratorAdapter(selectedDeadNodes.iterator()));
        if (exception instanceof ClosedChannelException) {  
 * Requests can be traced by enabling trace logging for "tracer". The trace logger outputs requests and responses in curl format.
                node.getHost(),  
        if (nodes.hasNext()) {  
     */
     */
                    uri,
                URI uri = buildUri(pathPrefix, request.endpoint(), params);
        client.close();
    private static boolean isRetryStatus(int statusCode) {
                break;
                    uri,
        onResponse(node);  
     *                the user console https://cloud.elastic.co and will resemble a string like the following  
     * failure. Selects a host out of the provided ones in a round-robin  
            return publisher;  
    }
        if (suppressedException != null) {
            }
        InternalStreamingRequest(StreamingRequest request) {  
                throw (RuntimeException) cause;  
            // we stream the request body if the entity allows for it
                port = Integer.parseInt(domainAndMaybePort[1]);  
     * Sends a streaming request to the OpenSearch cluster that the client points to and returns streaming response. <strong>This is an experimental API</strong>.
import static java.util.Collections.singletonList;
import java.net.http.HttpTimeoutException;
        }
        }
            cloudId = cloudId.substring(cloudId.indexOf(":") + 1);  
                            }
         * any living ones. Either way, we want to revive a single dead node  
import java.util.Iterator;
            return internalRequest.cancellable;
        }  
         * the selector rejected all the living nodes or because there aren't
                    request.options().getTimeout(),
                                listener.trackFailure(responseOrResponseException.responseException);  
            List<Node> selectedLivingNodes = new ArrayList<>(livingNodes);  
                    logger.debug("added [" + node + "] to denylist");
import java.net.URLEncoder;  
        public int compareTo(DeadNode rhs) {
            throw new IllegalArgumentException("nodes must not be null or empty");
        FailureListener failureListener,
            return node;
            String newQuery = uri.getQuery();
     * @throws IOException if no nodes are available
     * them does, in which case an {@link IOException} will be thrown.  
            if (request.warningsHandler.warningsShouldFailRequest(response.warnings())) {
            "NodeSelector [" + nodeSelector + "] rejected all nodes, " + "living " + livingNodes + " and dead " + deadNodes
        if (domainAndMaybePort.length == 2) {
            port = 443;
    ) {
    }  
     * @throws ResponseException in case OpenSearch responded with a status code that indicated an error
            throw new RuntimeException("thread waiting for the response was interrupted", exception);
import static java.nio.charset.StandardCharsets.UTF_8;
            return requestProducer;  
            };  
                    return e.getKey();  
            onFailure(node);
                URI uri = buildUri(pathPrefix, request.endpoint(), params);
import java.util.List;
        for (Node node : nodes) {  
                // 404 never causes error if returned for a HEAD request
            ConnectException e = new ConnectException(exception.getMessage());  
             * We'd like NodeSelectors to remove items directly from deadNodes  
            return new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), newQuery, uri.getFragment());
        }
                (body == null) ? BodyPublishers.noBody()  
            nodeSelector.select(selectedLivingNodes);
     * many times they previously failed (the more failures, the later they  
                }  
    private final FailureListener failureListener;
     * that is closest to being revived.  
        ResponseOrResponseException(Response response) {
            return new ResponseOrResponseException(response);
                 */  
import reactor.core.publisher.Mono;
                        }
     * contains the call site. While we attempt to preserve the original
        final DeadHostState deadness;  
             * list.  
            return itr.next().node;  
        Node node();
            );  
    @Override
                    request.body(),  
            }
     * {@link Exception#getCause()}.
        throw responseException;
        private final BodyHandler<Flow.Publisher<List<ByteBuffer>>> asyncResponseConsumer;  
            responseListener.onSuccess(response);
        Set<Integer> ignoreErrorCodes;
         * that the NodeSelectors are OK with. We do this by passing the dead
            this.asyncResponseConsumer = BodyHandlers.fromSubscriber(new AsyncResponseProducer(), AsyncResponseProducer::getResult);  
            final Mono<HttpResponse<Flow.Publisher<List<ByteBuffer>>>> publisher = Mono.fromCompletionStage(future).flatMap(response -> {
        Node node,  
 * Client that connects to an OpenSearch cluster through HTTP.
public class RestHttpClient implements Closeable {
                } catch (final Exception ex) {
    }
            if (newQuery == null) {
            };  
            this.httpRequest = node -> {  
            String ignoreString = params.remove("ignore");  
import java.util.HashMap;  
        }
            if (deadness == null || deadness.shallBeRetried()) {
    }
        } catch (URISyntaxException e) {  
    /**
     * unmodifiable.
    }
        }  
 *
        RequestContext<Flow.Publisher<List<ByteBuffer>>> createContextForNextAttempt(Node node) {
                                performRequestAsync(nodes, request, listener);
        // there is an optional first portion of the cloudId that is a human readable string, but it is not used.
     * round-robin fashion. Failing hosts are marked dead and retried after a
                requestNames.add(requestHeader.getKey());
            this.node = node;  
                            if (nodes.hasNext()) {
     * exception this isn't always possible and likely haven't covered all of  
                    final ResponseOrResponseException responseOrResponseException = convertResponse(request, node, response);  
    /**  
            );
            logger.debug("removed [" + node + "] from denylist");
         * Last resort: there are no good nodes to use, either because
     */
            Map<String, String> params = new HashMap<>(request.parameters());
                if (logger.isDebugEnabled()) {
            if ("HEAD".equalsIgnoreCase(requestMethod)) {
import java.util.ArrayList;
        }
        AtomicInteger lastNodeIndex,
import java.util.concurrent.Future;  
                } else {  
     * Allows to track potential failures coming from the different retry attempts and returning to the original listener
        // mark host alive and don't retry, as the error should be a request problem
     * Replaces the nodes with which the client communicates.
        if (isRetryStatus(statusCode)) {
                    try {  
            this.itr = itr;
    }
            }  
            return new ResponseOrResponseException(responseException);  
            }
        this.nodeSelector = nodeSelector;
    private HttpRequest.Builder createStreamingHttpRequest(
        }
        private DeadNodeIteratorAdapter(Iterator<DeadNode> itr) {
        @Override  
        // Streaming Response could accumulate a lot of data so we may not be able to fully consume it.
        Objects.requireNonNull(path, "path must not be null");
        return request.cancellable.callIfNotCancelled(() -> {
         * nodes through the NodeSelector so it can have its say in which nodes
        // domain name and optional port
     */
 * <p>
        public void remove() {
                    compressionEnabled
    public static RestHttpClientBuilder builder(Node... nodes) {  
     * the cases. You can get the original exception from
    public Cancellable performRequestAsync(Request request, ResponseListener responseListener) {  
    public synchronized void setNodes(Collection<Node> nodes) {  
import java.nio.channels.ClosedChannelException;
     * that match the {@link NodeSelector}.
            final Set<String> requestNames = new HashSet<>(requestHeaders.size());  
        HttpClient client,  
        @Override
            // request headers override default headers, so we don't add default headers if they exist as request headers
     * Listener used in any async call to wrap the provided user listener (or SyncResponseListener in sync calls).  
        }
    }
                    request.method(),
                method,  
     * Creates a new builder instance and sets the hosts that the client will send requests to.
        } else {
            return e;  
            throw new IllegalArgumentException(e.getMessage(), e);
import java.net.http.HttpRequest.BodyPublishers;
        // once decoded the parts are separated by a $ character.
            DeadHostState deadness = denylist.get(node.getHost());
     * @throws IOException IOException
                new DeadHostState(DeadHostState.DEFAULT_TIME_SUPPLIER)
                                performRequestAsync(nodes, request, listener);
        }
            if (pathPrefix != null && pathPrefix.isEmpty() == false) {
        throw responseException;
        this.nodes = Collections.unmodifiableList(new ArrayList<>(nodesByHost.values()));
            return asyncResponseConsumer;
     * Blocks until the request is completed and returns its response or fails
import java.util.Map;
        private void setCancellable(Future<?> f) {  
            e.initCause(exception);  
                // 404 never causes error if returned for a HEAD request
        private final BodyHandler<List<ByteBuffer>> asyncResponseConsumer;
        /**  
        this.defaultHeaders = Collections.unmodifiableMap(defaultHeaders);
        @Override
            return new ResponseOrResponseException(responseException);
        // mark host alive and don't retry, as the error should be a request problem  
            this.responseException = Objects.requireNonNull(responseException);
import java.net.ConnectException;
        String[] domainAndMaybePort = decodedParts[0].split(":", 2);  
     *  
            Objects.requireNonNull(node, "node cannot be null");
     * Called after each failed attempt.  
        DeadNode(Node node, DeadHostState deadness) {
     */
        Map<HttpHost, DeadHostState> denylist,  
        }
        String domain = domainAndMaybePort[0];
                    fullPath = pathPrefix + path;
        }
        throws IOException {  
            onFailure(context.node());
     * @see Node#Node(HttpHost)
     *                optionalHumanReadableName:dXMtZWFzdC0xLmF3cy5mb3VuZC5pbyRlbGFzdGljc2VhcmNoJGtpYmFuYQ==
import java.util.concurrent.CancellationException;
                requestHeader.getValue().forEach(v -> httpRequest.header(requestHeader.getKey(), v));
import java.util.concurrent.ConcurrentHashMap;
                    if (failure instanceof CancellationException) {
        int port;
        private volatile Exception exception;  
        }  
            }
        private final Response response;
                        Exception cause = failure;
        return nodes;
            return e;  
            if (denylist.replace(node.getHost(), previousDeadHostState, new DeadHostState(previousDeadHostState))) {  
        try {
            // request headers override default headers, so we don't add default headers if they exist as request headers
         */
     */
            return new StreamingResponse(new RequestLine(request.httpRequest.apply(node)), streamRequest(node, nodes, request));
        public BodyHandler<Flow.Publisher<List<ByteBuffer>>> asyncResponseConsumer() {
     *  
     * @return client running status
            trackFailure(exception);
                method,
    ) throws IOException {  
                }  
            // mark host dead and retry against next one
     * @param hosts The hosts that the client will send requests to.  
    /**
        if (exception instanceof ExecutionException || exception instanceof CompletionException) {  
        private final HttpRequest requestProducer;  
     * @return the response returned by OpenSearch
        private final Iterator<DeadNode> itr;
                        JdkFlowAdapter.publisherToFlowPublisher(
                newQuery += "&" + additionalQuery;
         * Notifies the caller of a response through the wrapped listener
                 * Rotate the list using a global counter as the distance so subsequent
        final FailureTrackingResponseListener listener  
        private final ResponseListener responseListener;
    }
     * <p>  
     * Receives as an argument the host that was used for the successful request.
            onResponse(node);
        }  
                            }
        }
        final Iterator<Node> nodes,
            RequestLogger.logFailedRequest(logger, request.httpRequest, context.node(), e);
    }
        return HttpRequest.newBuilder()
    }
    private ResponseOrResponseException convertResponse(InternalRequest request, Node node, HttpResponse<List<ByteBuffer>> httpResponse)
     * Returns a new {@link RestHttpClientBuilder} to help with {@link RestHttpClient} creation.
                        if (failure instanceof CompletionException && failure.getCause() instanceof Exception ce) {
            this.warningsHandler = request.options().getWarningsHandler() == null
        List<Node> nodes,
        FailureTrackingResponseListener(ResponseListener responseListener) {
        URI uri,
        }
                    } else {  
            if (false == selectedDeadNodes.isEmpty()) {  
            this.asyncResponseConsumer = BodyHandlers.ofPublisher();  
        if (responseOrResponseException.responseException == null) {
     * If you don't either one is fine.
            }  
        }  
        Map<HttpHost, Node> nodesByHost = new LinkedHashMap<>();
     */
        }
                    : compressed == false ? BodyPublishers.fromPublisher(JdkFlowAdapter.publisherToFlowPublisher(body))
        @Override  
    private Publisher<HttpResponse<Flow.Publisher<List<ByteBuffer>>>> streamRequest(  
        final InternalRequest request,
        this.warningsHandler = strictDeprecationMode ? WarningsHandler.STRICT : WarningsHandler.PERMISSIVE;
                 * requests will try the nodes in a different order.
            }
        final Node node,
            throw new IllegalStateException("unexpected exception type: must be either RuntimeException or IOException", cause);
     * Adapts an <code>Iterator&lt;DeadNodeAndRevival&gt;</code> into an
        public Node node() {  
                }  
        public String toString() {
        RequestContext<List<ByteBuffer>> createContextForNextAttempt(Node node) {
                } catch (NumberFormatException e) {
        List<Node> nodes = Arrays.stream(hosts).map(Node::new).collect(Collectors.toList());  
                return builder.build();
    private Iterator<Node> nextNodes() throws IOException {  
                exception.getMessage() + "\nSee https://opensearch.org/docs/latest/clients/java-rest-high-level/ for troubleshooting."  
        try {
            );
            return itr.hasNext();
            onFailure(node);  
                if (logger.isDebugEnabled()) {
            itr.remove();
                            return Mono.error(responseOrResponseException.responseException);
        public HttpRequest requestProducer() {
    /**  
                    throw new IllegalArgumentException("ignore value should be a number, found [" + ignoreString + "] instead", e);  
    /**  
     * certain amount of time (minimum 1 minute, maximum 30 minutes), depending
        }
                return performRequest(nodes, request, cause);  
        if (nodes == null || nodes.isEmpty()) {
            }
        ResponseException responseException = new ResponseException(response);
        return new RestHttpClientBuilder(nodes);
        final InternalStreamingRequest request  
        throws IOException {  
                            cause = ce;  
        while (true) {
        ResponseOrResponseException responseOrResponseException = convertResponse(request, context.node(), httpResponse);
        });
        boolean strictDeprecationMode,  
            String[] ignoresArray = ignoreString.split(",");
                            listener.onSuccess(responseOrResponseException.response);  
        }
    /**  
        public HttpRequest requestProducer() {
                ignoreErrorCodes = Collections.emptySet();
        ResponseException responseException = new ResponseException(response);  
                }  
        List<Node> livingNodes = new ArrayList<>(Math.max(0, nodes.size() - denylist.size()));
         *  
            String ignoreString = params.remove("ignore");
                    node,  
        return ignoreErrorCodes;
     * on how many times they previously failed (the more failures, the later  
        try {
        return new RestHttpClientBuilder(nodes == null ? null : Arrays.asList(nodes));
        Node node,  
        final HttpRequest httpRequest = request.httpRequest.apply(node);
            if (compressionEnabled) {
    }
            currentException.addSuppressed(suppressedException);
            }  
                        } else {  
        private final Node node;
        }  
    private static class AsyncRequestContext implements RequestContext<List<ByteBuffer>> {
import java.net.http.HttpRequest;
    }
    private static class ReactiveRequestContext implements RequestContext<Flow.Publisher<List<ByteBuffer>>> {  
                final HttpRequest.Builder builder = createHttpRequest(
                    node,  
    /**
     * only when we got a response (successful or not to be retried) or there are no hosts to retry against.
     * If there are no living nodes that match the {@link NodeSelector}
     * Prefer this to {@link #builder(HttpHost...)} if you have metadata up front about the nodes.
                    request.options().getTimeout(),
                if (httpResponse != null) {
                        if (responseOrResponseException.responseException == null) {
        void trackFailure(Exception exception) {  
                    request.method(),
        ResponseOrResponseException(ResponseException responseException) {
             * for the request.
 * compatible open source license.
                        } catch (Exception e) {
        NodeSelector nodeSelector,
        // they are respectively domain name and optional port, opensearch id, opensearch-dashboards id
        void onDefinitiveFailure(Exception exception) {
        private final WarningsHandler warningsHandler;  
 */  
            future.whenComplete((httpResponse, throwable) -> {
 * retried after a certain amount of time (minimum 1 minute, maximum 30 minutes), depending on how many times they previously
                );  
                        listener.onDefinitiveFailure(Cancellable.newCancellationException());
        if (false == livingNodes.isEmpty()) {  
                setHeaders(builder, request.options().getHeaders());
            FailureTrackingResponseListener failureTrackingResponseListener = new FailureTrackingResponseListener(responseListener);
            return new ReactiveRequestContext(this, node);  
                } else if (pathPrefix.endsWith("/") || path.startsWith("/")) {
            } else {
import java.util.stream.Collectors;  
     * @param responseListener the {@link ResponseListener} to notify when the  
            this.warningsHandler = request.options().getWarningsHandler() == null
                httpRequest.header("Accept-Encoding", "gzip");  
     * @throws IOException in case of a problem or the connection was aborted  
                        listener.onDefinitiveFailure(e);
        }  
                }  
         * Create a {@link FailureListener} instance.  
            return Cancellable.NO_OP;
    private final boolean compressionEnabled;  
        if (exception instanceof InterruptedException) {  
        final InternalStreamingRequest internalRequest = new InternalStreamingRequest(request);
     *      request is completed or fails
import java.net.URISyntaxException;
                context.asyncResponseConsumer()  
     * <p>
        }  
                    : BodyPublishers.fromPublisher(JdkFlowAdapter.publisherToFlowPublisher(Flux.from(body).map(BodyUtils::compress)))
     * Sends a request to the OpenSearch cluster that the client points to.
            final CompletableFuture<HttpResponse<Flow.Publisher<List<ByteBuffer>>>> future = client.sendAsync(
        String[] decodedParts = decoded.split("\\$");  
    public static RestHttpClientBuilder builder(HttpHost... hosts) {
                context.requestProducer(),
                throw new WarningFailureException(response);
    }  
            for (String ignoreCode : ignoresArray) {
                } else if (throwable instanceof Exception failure) {  
        boolean compressed  
            if (cause instanceof IOException) {
        final HttpRequest httpRequest = request.httpRequest.apply(node);
        }
        if (isRetryStatus(statusCode)) {  
        public FailureListener() {}
        if (isSuccessfulResponse(statusCode) || request.ignoreErrorCodes.contains(response.statusLine().statusCode())) {
             * to compare many things. This saves us a sort on the unfiltered
            .timeout(timeout)  
     * @param nodes the new nodes to communicate with.
            } else {
        }
            final Node node = nodes.next();  
        RequestLogger.logStreamingResponse(logger, request.httpRequest.apply(node), node.getHost(), httpResponse);
import org.reactivestreams.Publisher;
     * <code>Iterator&lt;Node&gt;</code>.
            }
        private final WarningsHandler warningsHandler;
    }
            throw new IllegalArgumentException("hosts must not be null nor empty");
        InternalRequest(Request request) {
    private StreamingResponse streamRequest(final Iterator<Node> nodes, final InternalStreamingRequest request) throws IOException {
import java.util.Objects;  
            }  
            return e;
        private final Function<Node, HttpRequest> httpRequest;
    private final NodeSelector nodeSelector;  
         */  
                        }
                    logger.debug("updated [" + node + "] already in denylist");
        if (hosts == null || hosts.length == 0) {  
/*  
        private volatile Cancellable cancellable = Cancellable.fromFuture(new CompletableFuture<>());
                                listener.onDefinitiveFailure(responseOrResponseException.responseException);  
    private static class DeadNodeIteratorAdapter implements Iterator<Node> {
        } else {
     */  
            return e;
    }
     * This method works by performing an asynchronous call and waiting
            CompletableFuture<HttpResponse<List<ByteBuffer>>> future = client.sendAsync(
        Duration timeout,
        private final Set<Integer> ignoreErrorCodes;
                    }
        private final Function<Node, HttpRequest> httpRequest;  
     * Close the underlying {@link HttpClient} instance
        if (false == deadNodes.isEmpty()) {  
        InternalRequest internalRequest = new InternalRequest(request);
        }  
        }
     * check client running status  
                newQuery = additionalQuery;  
            this.requestProducer = request.httpRequest.apply(node);
    }
            request.setCancellable(future);
     * Creates a new builder instance and sets the nodes that the client will send requests to.  
    }
            responseListener.onFailure(e);
        ReactiveRequestContext(InternalStreamingRequest request, Node node) {
     * @param request the request to perform
                throw new WarningFailureException(response);
        private final Node node;
                return true;
                }
        }  
                    return Mono.error(ex);
    public static RestHttpClientBuilder builder(String cloudId) {  
        }
            this.ignoreErrorCodes = getIgnoreErrorCodes(ignoreString, request.method());
        }  
        }  
        }  
    static class FailureTrackingResponseListener {
    final Map<String, List<String>> defaultHeaders;
            if (cloudId.indexOf(":") == cloudId.length() - 1) {  
        this.failureListener = failureListener;
                if (e.getValue() == null) {
        /*  
     * {@link ResponseListener} gets notified upon request completion or
        client.shutdownNow();  
     * Wrap the exception so the caller's signature shows up in the stack trace, taking care to copy the original type and message
     */
            throw new IllegalStateException("cloudId " + cloudId + " did not decode to a cluster identifier correctly");
        String method,
        private volatile Cancellable cancellable = Cancellable.fromFuture(new CompletableFuture<>());
                : request.options().getWarningsHandler();  
         * are ok. If the selector is ok with any of the nodes then we will take  
     * it and rethrow it so that the stack trace attached to the exception
import org.apache.commons.logging.LogFactory;
        private final Set<Integer> ignoreErrorCodes;
     * Select nodes to try and sorts them so that the first one will be tried initially, then the following ones
        this.compressionEnabled = compressionEnabled;  
    ) {
            e.initCause(exception);
         * Sort the nodes into living and dead lists.
import java.net.SocketTimeoutException;  
        onResponse(node);
                    defaultHeader.getValue().forEach(v -> httpRequest.header(defaultHeader.getKey(), v));
        if (decodedParts.length != 3) {
    }
                ignoreErrorCodes = Collections.singleton(404);  
            final URI uri = URI.create(fullPath);
    private static class ResponseOrResponseException {
    private ResponseOrResponseException convertResponse(
        if (exception instanceof RuntimeException) {
     *
        @Override
    }
        String method,
     * amount of time (minimum 1 minute, maximum 30 minutes), depending on how
     */
            return new RuntimeException(exception.getMessage(), exception);
                    : BodyPublishers.fromPublisher(  
import reactor.adapter.JdkFlowAdapter;  
            .uri(URI.create(node.getHost().toString()).resolve(uri))  
        private void setCancellable(Future<?> f) {
                    ignoreErrorCodes.add(Integer.valueOf(ignoreCode));
     * @param request streaming request  
                try {
        this.client = client;  
        }  
        failureListener.onFailure(node);
     */  
         * Notifies that the node provided as argument has just failed.
    private static class DeadNode implements Comparable<DeadNode> {
import java.util.concurrent.atomic.AtomicInteger;
            }
            .uri(URI.create(node.getHost().toString()).resolve(uri))
    }
            SSLHandshakeException e = new SSLHandshakeException(
        });
 * Must be created using {@link RestHttpClientBuilder}, which allows to set all the different options or just rely on defaults.
            exception = (Exception) t;
                Collections.rotate(selectedLivingNodes, lastNodeIndex.getAndIncrement());
                            } else {
import java.net.http.HttpResponse;
            /*
import java.util.Base64;  
        final Iterator<Node> nodes,
                if (requestNames.contains(defaultHeader.getKey()) == false) {  
            cancellable = Cancellable.fromFuture(f);
        }
 * by calling {@link #setNodes(Collection)}.  
            .timeout(timeout)
    }  
                            return Mono.from(streamRequest(nodes.next(), nodes, request));
            this.response = Objects.requireNonNull(response);  
            }
        return new RuntimeException("error while performing request", exception);
     * where possible so async and sync code don't have to check different exceptions.  
import java.util.concurrent.Flow;
        }
     */
    }
        void onSuccess(Response response) {  
    public Response performRequest(Request request) throws IOException {  
     */  
            this.node = node;  
                            onFailure(context.node());
                httpRequest.header("Content-Encoding", "gzip");
import reactor.core.publisher.Flux;
            // TODO should we throw an IAE if we have two nodes with the same host?
            final String additionalQuery = params.entrySet().stream().map(e -> {
        return statusCode < 300;
                throw new IllegalStateException("cloudId " + cloudId + " does not contain a valid port number");
            return new ResponseOrResponseException(response);  
        this.pathPrefix = pathPrefix;  
    ) throws IOException {
    private static final Log logger = LogFactory.getLog(RestHttpClient.class);
            if (request.warningsHandler.warningsShouldFailRequest(response.warnings())) {  
import java.util.Arrays;
                requestHeader.getValue().forEach(v -> httpRequest.header(requestHeader.getKey(), v));  
            this.responseException = null;
                HttpRequest.Builder builder = createStreamingHttpRequest(
 */
        }
                return selectedLivingNodes;
    private void performRequestAsync(  
     * {@link #builder(Node...)}.  
            }
             */
            case 503:
            if (compressionEnabled) {
        if (exception instanceof ConnectException) {
    private Response performRequest(final Iterator<Node> nodes, final InternalRequest request, Exception previousException)
         * the one in the list that has the lowest revival time and try it.
    static Iterable<Node> selectNodes(
        }  
/**
    }
            if (cause instanceof RuntimeException) {
        /**
        HttpResponse<Flow.Publisher<List<ByteBuffer>>> httpResponse
    RestHttpClient(
            }  
            }  
    }  
 *
     * @param nodes The nodes that the client will send requests to.
    private final ConcurrentMap<HttpHost, DeadHostState> denylist = new ConcurrentHashMap<>();
                    } else {  
        return builder(new HttpHost("https", url, port));  
     * The default implementation is a no-op.
import java.util.LinkedHashMap;  
            // ignore is a special parameter supported by the clients, shouldn't be sent to es
            cancellable = Cancellable.fromFuture(f);
 * failed (the more failures, the later they will be retried). In case of failures all of the alive nodes (or dead nodes that
    private volatile List<Node> nodes;
                requestNames.add(requestHeader.getKey());  
    /**  
            performRequestAsync(nextNodes(), internalRequest, failureTrackingResponseListener);
    private static void addSuppressedException(Exception suppressedException, Exception currentException) {  
        }
         */
        HttpRequest requestProducer();
        private final HttpRequest requestProducer;
        }
            if ("HEAD".equalsIgnoreCase(requestMethod)) {
     * dead nodes that deserve a retry) are retried until one responds or none
        String pathPrefix,  
        HttpResponse<List<ByteBuffer>> httpResponse;  
 * <p>
        /**  
        public Node node() {  
            }
    }
                ignoreErrorCodes.add(404);  
import java.net.URI;
     * The request is executed asynchronously and the provided
                if (requestNames.contains(defaultHeader.getKey()) == false) {
        public Node next() {
                        }
                if (pathPrefix.endsWith("/") && path.startsWith("/")) {
            String fullPath;  
import java.util.concurrent.ExecutionException;
     * <p>
                                listener.onDefinitiveFailure(cause);  
        BodyPublisher body,
            request.setCancellable(future);  
            } else {  
             * selector is ok with any over the living nodes then use them  
    private void onFailure(Node node) {  
                            listener.onDefinitiveFailure(e);  
            return new AsyncRequestContext(this, node);  
            final Set<String> requestNames = new HashSet<>(requestHeaders.size());  
    }
                }
            } else {
                    defaultHeader.getValue().forEach(v -> httpRequest.header(defaultHeader.getKey(), v));
            if (false == selectedLivingNodes.isEmpty()) {
                        return Mono.just(response);
            });
                return builder.build();
import java.util.Collection;
 * deserve a retry) are retried until one responds or none of them does, in which case an {@link IOException} will be thrown.  
        }  
        URI uri,  
                        ResponseOrResponseException responseOrResponseException = convertResponse(request, context.node(), httpResponse);
package org.opensearch.internal.httpclient;
            }
                        if (nodes.hasNext()) {
            }
    private static Exception extractAndWrapCause(Exception exception) {
    private static boolean isSuccessfulResponse(int statusCode) {
        Node node,
        @Override
 * <p>  
        public boolean hasNext() {  
}  
            }
     * @param request the request to perform
        NodeSelector nodeSelector
                break;
     */  
     * of them does, in which case an {@link IOException} will be thrown.  
        RequestLogger.logResponse(logger, httpRequest, node.getHost(), httpResponse);  
        switch (statusCode) {  
            return node;
    /**
import java.util.Set;
 * sending a request, a host gets selected out of the provided ones in a round-robin fashion. Failing hosts are marked dead and  
            addSuppressedException(this.exception, exception);
     */  
        RequestContext<List<ByteBuffer>> context = request.createContextForNextAttempt(node);
                );  
    static URI buildUri(String pathPrefix, String path, Map<String, String> params) {  
        request.cancellable.runIfNotCancelled(() -> {
            .method(
             * Normal state: there is at least one living node. If the
        throw new IOException(
            return asyncResponseConsumer;
    public boolean isRunning() {  
        return client.isTerminated() == false;
            this.ignoreErrorCodes = getIgnoreErrorCodes(ignoreString, request.method());
     * Get the list of nodes that the client knows about. The list is
                (body == null) ? BodyPublishers.noBody()
     */  
        if (exception instanceof SocketTimeoutException) {
 * <p>  
            }
import javax.net.ssl.SSLHandshakeException;
                try {  
        }
        } catch (Exception e) {  
        @Override
     * nodes that deserve a retry) are retried until one responds or none of
        }
            return requestProducer;  
        for (Node node : nodes) {  
        }
        /*
    }
    /**  
        if (isSuccessfulResponse(statusCode) || request.ignoreErrorCodes.contains(response.statusLine().statusCode())) {
                    fullPath = pathPrefix + "/" + path;
 * The hosts that are part of the cluster need to be provided at creation time, but can also be replaced later
        }
         * @param node The node which has failed.
        setNodes(nodes);
    /**  
         */
        BodyHandler<T> asyncResponseConsumer();  
    /**
                        )  
import java.net.http.HttpRequest.BodyPublisher;  
    private HttpRequest.Builder createHttpRequest(  
     * by throwing an exception. Selects a host out of the provided ones in a  
     * if the previous attempt failed and so on. Package private for testing.
            httpResponse = client.send(context.requestProducer(), context.asyncResponseConsumer());
            Map<String, String> params = new HashMap<>(request.parameters());
                httpRequest.header("Content-Encoding", "gzip");  
        }  
                        } else {
    ) {  
        addSuppressedException(previousException, responseOrResponseException.responseException);
        }  
            this.requestProducer = request.httpRequest.apply(node);
                ? RestHttpClient.this.warningsHandler  
                throw (Error) t;  
            e.initCause(exception);
import java.time.Duration;  
        DeadHostState removedHost = this.denylist.remove(node.getHost());
    private final HttpClient client;  
            this.deadness = deadness;
            );
            return performRequest(nodes, request, responseOrResponseException.responseException);
            Throwable t = exception.getCause() == null ? exception : exception.getCause();
     *
    /**
 * SPDX-License-Identifier: Apache-2.0
        @Override
        if (exception instanceof SSLHandshakeException) {
                /*  
                setHeaders(builder, request.options().getHeaders());
        throw responseOrResponseException.responseException;  
            } catch (NumberFormatException nfe) {
 * Note: This is an experimental API.  
     *  
import java.net.http.HttpClient;
        List<Node> nodes,
    private class InternalRequest {
                            if (nodes.hasNext()) {
                    compressionEnabled
            return new IOException(exception.getMessage(), exception);
     * fashion. Failing hosts are marked dead and retried after a certain
            InternalRequest internalRequest = new InternalRequest(request);  
            if (previousDeadHostState == null) {  
            if (nodes.hasNext()) {
    }
        }
        }
    private final WarningsHandler warningsHandler;
            this.node = node;
        Response response = Response.from(new RequestLine(httpRequest), node.getHost(), httpResponse);  
     * Returns a new {@link RestHttpClientBuilder} to help with {@link RestHttpClient} creation.
                        try {
            this.responseListener = responseListener;  
        return false;  
        private void setHeaders(HttpRequest.Builder httpRequest, Map<String, List<String>> requestHeaders) {
    private void onResponse(Node node) {
     * Listener that allows to be notified whenever a failure happens. Useful when sniffing is enabled, so that we can sniff on failure.
        return HttpRequest.newBuilder()
            for (Map.Entry<String, List<String>> requestHeader : requestHeaders.entrySet()) {
            ignoreErrorCodes = new HashSet<>();  
     * Creates a new builder instance and sets the nodes that the client will send requests to.  
        });
                            JdkFlowAdapter.flowPublisherToFlux(body).buffer().map(BodyUtils::compress).flatMap(Flux::fromIterable)
     * Sends a request to the OpenSearch cluster that the client points to.  
     * Returns a new {@link RestHttpClientBuilder} to help with {@link RestHttpClient} creation.
                            RequestLogger.logFailedRequest(logger, request.httpRequest, context.node(), failure);  
    public List<Node> getNodes() {
    }
        return streamRequest(nextNodes(), internalRequest);  
        Publisher<ByteBuffer> body,  
        final Response response = Response.fromStreaming(new RequestLine(httpRequest), node.getHost(), httpResponse);  
     * @return streaming response
     * Contains a reference to a denylisted node and the time until it is
import java.util.concurrent.CompletionException;
        if (logger.isDebugEnabled() && removedHost != null) {  
    /**
                    : compressed == false ? body
        public BodyHandler<List<ByteBuffer>> asyncResponseConsumer() {
         * Tracks one last definitive failure and returns to the caller by notifying the wrapped listener
            e.initCause(exception);
    ) throws IOException {
     * this will return the dead node that matches the {@link NodeSelector}
    /**
    public static class FailureListener {
            if (t instanceof Error) {
     */  
            );
            }
    }
        List<Node> nodes = this.nodes;
import java.io.Closeable;  
                    request.entity(),  
import java.util.concurrent.ConcurrentMap;  
            Exception cause = extractAndWrapCause(e);  
    }
            });
     * <p>  
    ) {
         */
        Duration timeout,
                    )
                                listener.trackFailure(failure);  
             * so we can find the minimum after it is filtered without having
                    return e.getKey() + "=" + URLEncoder.encode(e.getValue(), StandardCharsets.UTF_8);
            /*
     *
    private final String pathPrefix;
            final RequestContext<List<ByteBuffer>> context = request.createContextForNextAttempt(nodes.next());  
                livingNodes.add(node);  
            for (Map.Entry<String, List<String>> defaultHeader : defaultHeaders.entrySet()) {  
        return performRequest(nextNodes(), internalRequest, null);
import java.nio.ByteBuffer;  
     * Called after each successful request call.
        final Node node;
                    }  
        boolean compressed
import java.util.HashSet;
        }
     * they will be retried). In case of failures all of the alive nodes (or
            for (Map.Entry<String, List<String>> defaultHeader : defaultHeaders.entrySet()) {
            this.response = null;  
        private final ResponseException responseException;  
        Iterable<Node> hosts = selectNodes(nodes, denylist, lastNodeIndex, nodeSelector);
        if (cloudId.contains(":")) {
                } else {
        }
        }
