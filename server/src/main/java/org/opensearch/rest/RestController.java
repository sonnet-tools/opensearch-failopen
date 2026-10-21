        private void releaseRequestBytes() {
            return delegate.request();
import org.opensearch.core.xcontent.MediaType;
    /**
            return delegate.newBuilder();
    private void handleBadRequest(String uri, RestRequest.Method method, RestChannel channel) throws IOException {
/**
                e = new OpenSearchException("unknown cause");
        /** Guards the in-flight-requests breaker release, which must happen exactly once. */
        final Set<RestRequest.Method> validMethodSet,
            } else {
    }
        );
     * @param deprecatedPath <em>Deprecated</em> path to handle (e.g., "/_optimize")
    }
        public BytesStreamOutput bytesOutput() {
        }
     * <a href="https://tools.ietf.org/html/rfc2616#section-9.2">HTTP/1.1 - 9.2
                    dispatchRequest(request, channel, handler);
 * GitHub history for details.
        private void releaseRequestBytes() {
     */
            return delegate.detailedErrorStackTraceEnabled();
                final RestMethodHandlers handlers = allHandlers.next();
                    }
    private void handleOptionsRequest(RestChannel channel, Set<RestRequest.Method> validMethodSet) {
                inFlightRequestsBreaker(circuitBreakerService).addWithoutBreaking(-contentLength);
    public RestController(
        handlers.insertOrUpdate(
        @Override
 *
        } catch (final IOException e) {
    protected void registerWithDeprecatedHandler(
                // observable here. Handing the response to the subscription is the strongest signal available.
 * You may obtain a copy of the License at
            }
                    return Optional.empty();
     */
        final Set<RestRequest.Method> validMethodSet = getValidHandlerMethodSet(rawPath);
                final RestHandler handler;
    @Override
            this.contentLength = contentLength;
import java.net.URI;
                route -> registerWithDeprecatedHandler(
                try {
                    sendContentTypeErrorMessage(request.getAllHeaderValues("Content-Type"), responseChannel);
        if (requestParamsRef == null) {
        Iterator<RestMethodHandlers> allHandlers = getAllRestMethodHandlers(null, rawPath);
                inFlightRequestsBreaker(circuitBreakerService).addWithoutBreaking(-contentLength);
    }
            }
                if (mediaType == null) {
                e = new OpenSearchException(cause);
            FAVICON_RESPONSE = new BytesArray(out.toByteArray());
            } else {
        // we use rawPath since we don't want to decode it while processing the path resolution
        } else {
                if (channel instanceof StreamingRestChannel streamingRestChannel) {
     *
            }
        private final int contentLength;
        return false;
            return;
import org.opensearch.core.common.bytes.BytesReference;
            if (handler.allowSystemIndexAccessByDefault() == false && request.header(OPENSEARCH_PRODUCT_ORIGIN_HTTP_HEADER) == null) {
                responseChannel = new ResourceHandlingHttpChannel(channel, circuitBreakerService, contentLength);
                    return;
    ) {
                channel.sendResponse(
                // This header is intended for internal use only.
            new RestMethodHandlers(path, maybeWrappedHandler, method),
        @Override
            );
        final String errorMessage;
                channel.sendResponse(new BytesRestResponse(channel, e));
 * specific language governing permissions and limitations
                handler = handlers.getHandler(method);
import org.opensearch.core.common.breaker.CircuitBreaker;
 * OpenSearch REST controller
import static org.opensearch.core.rest.RestStatus.INTERNAL_SERVER_ERROR;
    /**
    }
            }
        }
     * method. A 405 HTTP response code is returned, and the response 'Allow'
        return methodHandlers.iterator();
import java.util.Map;
    }
            + "] is deprecated! Use ["
 * The OpenSearch Contributors require contributions made to
        if (channel.detailedErrorStackTraceEnabled() && channel.detailedErrorsEnabled() == false) {
     * - Options</a>).
    protected void registerAsDeprecatedHandler(RestRequest.Method method, String path, RestHandler handler, String deprecationMessage) {
            + deprecatedMethod.name()
import org.opensearch.http.HttpChunk;
    ) {
    /**
        // error_trace cannot be used when we disable detailed errors
                        return;
            return delegate.detailedErrorsEnabled();
                if (handler == null) {
 * @opensearch.api
        // We always obtain a fresh breaker to reflect changes to the breaker configuration.
     */
        }
import org.opensearch.common.util.RequestUtils;
        this.client = client;
 * software distributed under the License is distributed on an
                    // Nothing reached the client, so the failure response must still be allowed through this channel.
        public void sendChunk(HttpChunk chunk) {
import static org.opensearch.core.rest.RestStatus.OK;
 * not use this file except in compliance with the License.
        // so we can handle things like:
}
        return validMethods;
import static org.opensearch.core.rest.RestStatus.NOT_ACCEPTABLE;
        public XContentBuilder newBuilder(@Nullable MediaType mediaType, boolean useFiltering) throws IOException {
        private final AtomicBoolean subscribed = new AtomicBoolean();
        }
        public boolean detailedErrorsEnabled() {
import org.opensearch.common.Nullable;
            this.circuitBreakerService = circuitBreakerService;
        @Override
import java.util.List;
        /** Guards the response handoff. Claimed atomically and reset if the delegate rejects the response. */
        } catch (Exception e) {
            }
                }
import java.util.HashSet;
     */
        channel.sendResponse(BytesRestResponse.createSimpleErrorResponse(channel, NOT_ACCEPTABLE, errorMessage));
    /** Rest headers that are copied to internal requests made during a rest request. */
        /** Guards the in-flight-requests breaker release, which must happen exactly once. */
     * Handle HTTP OPTIONS requests to a valid REST endpoint. A 200 HTTP
     * @param path Path to handle (e.g., "/_forcemerge")
        public XContentBuilder newErrorBuilder() throws IOException {
                } else {
        }
    }
                msg.append(", allowed: ").append(validMethodSet);
                return requestParamsRef;
        try {
                if (accepted == false) {
    }
                } else {
            // Loop through all possible handlers, attempting to dispatch the request
import java.util.function.Supplier;
    /**
                            + "] and method ["
    public void dispatchRequest(RestRequest request, RestChannel channel, ThreadContext threadContext) {
            if (handler.supportsStreaming()) {
            tryAllHandlers(request, channel, threadContext);
                e = exception;
                // The delegate is invoked from the subscription above rather than inline, so a later failure is not
            }
    private static CircuitBreaker inFlightRequestsBreaker(CircuitBreakerService circuitBreakerService) {
package org.opensearch.rest;
            return delegate.bytesOutput();
            } else {
                delegate.sendResponse(response);
                }
    }
                    );
        @Override
        RestRequest.Method method,
        if (handler instanceof BaseRestHandler baseRestHandler) {
                return true;
 */
import java.util.ArrayList;
            final RestMethodHandlers handlers = allHandlers.next();
        }
            }
                inner.addSuppressed(e);
    private final PathTrie<RestMethodHandlers> handlers = new PathTrie<>(RestUtils.REST_DECODER);
import java.util.concurrent.atomic.AtomicBoolean;
        @Override
            channel.sendResponse(new BytesRestResponse(BAD_REQUEST, builder));
            final String name = restHeader.getName();
            return delegate.bytesOutput();
        if (handlerWrapper == null) {
                msg.append("] and method [").append(method).append("]");
        }
    }
import org.opensearch.core.xcontent.MediaTypeRegistry;
        if (contentLength > 0) {
     * Registers a REST handler to be executed when one of the provided methods and path match the request.
            BytesRestResponse bytesRestResponse = BytesRestResponse.createSimpleErrorResponse(channel, METHOD_NOT_ALLOWED, msg.toString());
                handedOff = true;
 *
            if (cause != null) {
    }
            logger.warn("failed to send bad request response", e);
            }
        }
        /** Guards the response handoff. Claimed atomically and reset if subscription setup rejects the response. */
                } else {
     */
        @Override
     * @param deprecatedMethod GET, POST, etc.
                    // in case false-positive cross site scripting vulnerability is detected by common security scanners.
        private final AtomicBoolean responseSent = new AtomicBoolean();
            return delegate.newBuilder(mediaType, useFiltering);
        this.handlerWrapper = handlerWrapper;
    private void registerHandlerNoWrap(RestRequest.Method method, String path, RestHandler maybeWrappedHandler) {
     * and a specific message.
                return true;
            usageService.addRestHandler(baseRestHandler);
    private Set<RestRequest.Method> getValidHandlerMethodSet(String rawPath) {
                            BAD_REQUEST,
/*
        public RestRequest request() {
        @Override
     *                                          POST, "/{index}/_optimize", deprecationLogger);
            responseChannel.sendResponse(new BytesRestResponse(responseChannel, e));
                if (handlers == null) {
import java.io.ByteArrayOutputStream;
        @Override
            if (handler == null) {
        }
     */
import static org.opensearch.core.rest.RestStatus.BAD_REQUEST;
            throw new AssertionError(e);
    private void dispatchRequest(RestRequest request, RestChannel channel, RestHandler handler) throws Exception {
    }
    /**
        }
        public BytesStreamOutput bytesOutput() {
        final String rawPath = request.rawPath();
                Mono.from(this).ignoreElement().then(Mono.just(response)).subscribe(delegate::sendResponse);
            }
        public XContentBuilder newBuilder() throws IOException {
import org.opensearch.core.indices.breaker.CircuitBreakerService;
        }
    }
import org.opensearch.core.rest.RestStatus;
    private volatile int requestIdMaxLength = HttpTransportSettings.SETTING_HTTP_REQUEST_ID_MAX_LENGTH.getDefault(Settings.EMPTY);
        }
 */
        } else {
            delegate.prepareResponse(status, headers);
import reactor.core.publisher.Mono;
import org.opensearch.core.common.Strings;
                // to move away from direct access to system indices, and thus deprecation warnings should not be emitted.
        }
            }
        handlers.retrieveAll().forEachRemaining(methodHandlers::add);
    static {
    /**
import org.opensearch.OpenSearchException;
                            channel,
            errorMessage = "Content-Type header is missing";
            .forEach(route -> registerAsDeprecatedHandler(route.getMethod(), route.getPath(), restHandler, route.getDeprecationMessage()));
                // Check if subscribe() is already called, the headers and status are going to be sent
import org.opensearch.usage.UsageService;
        BytesRestResponse bytesRestResponse = new BytesRestResponse(OK, TEXT_CONTENT_TYPE, BytesArray.EMPTY);
            if (validMethodSet.isEmpty() == false) {
            + " "
        try (InputStream stream = RestController.class.getResourceAsStream("/config/favicon.ico")) {
                    responseChannel = new StreamHandlingHttpChannel(streamingRestChannel, circuitBreakerService, contentLength);
        @Override
                    throw new IllegalStateException(
            if (handler.allowsUnsafeBuffers() == false) {
    @Override
            + " "
            channel.sendResponse(bytesRestResponse);
                    route.getMethod(),
        for (final RestHeaderDefinition restHeader : headersToCopy) {
                    uri = new URI(uri).getPath();
            if (validMethodSet.isEmpty() == false) {
        }
 * ownership. Elasticsearch licenses this file to you under
                    handler = handlers.getHandler(requestMethod);
     */
        }
        ResourceHandlingHttpChannel(RestChannel delegate, CircuitBreakerService circuitBreakerService, int contentLength) {
                    builder.field("error", "no handler found for uri [" + uri + "] and method [" + method + "]");
                    handler = null;
            boolean handedOff = false;
        public boolean isReadable() {
                if (subscribed.get() == false) {
            } finally {
        handleBadRequest(uri, requestMethod, channel);
                        BytesRestResponse.createSimpleErrorResponse(
     * replacing the deprecated REST handler ({@code deprecatedMethod} with {@code deprecatedPath}) that is using the <em>same</em>
        @Override
                requestParamsRef.putAll(originalParams);
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestController.class);
                    threadContext.putHeader(name, String.join(",", distinctHeaderValues));
        // which gets automatically added).
            try {
                // if we could reserve bytes for the request we need to send the response also over this channel
    }
        @Override
        return circuitBreakerService.getBreaker(CircuitBreaker.IN_FLIGHT_REQUESTS);
            .forEach(
    private void handleUnsupportedHttpMethod(
        }
    private void sendContentTypeErrorMessage(@Nullable List<String> contentTypeHeader, RestChannel channel) throws IOException {
                    route.getPath(),
        channel.sendResponse(bytesRestResponse);
    public void setRequestIdMaxLength(int maxLength) {
        // When we have an OPTIONS HTTP request and no valid handlers, simply send OK by default (with the Access Control Origin header
                // Not Allowed error.
                }
    /**
     * Deprecated REST handlers without a direct replacement should be deprecated directly using {@link #registerAsDeprecatedHandler}
        @Override
            try {
                final Set<RestRequest.Method> validMethodSet = getValidHandlerMethodSet(rawPath);
     *
                handleUnsupportedHttpMethod(uri, method, channel, validMethodSet, null);
        }
        }
import org.opensearch.transport.client.node.NodeClient;
    private final Set<RestHeaderDefinition> headersToCopy;
        }
     * Get the valid set of HTTP methods for a REST request.
        registerHandlerNoWrap(method, path, handlerWrapper.apply(handler));
import org.apache.logging.log4j.Logger;
        public XContentBuilder newBuilder() throws IOException {
     * <pre><code>
        }
            // otherwise parameters are parsed out of the URI that aren't actually handled.
            if (headerValues != null && headerValues.isEmpty() == false) {
            }
        restHandler.replacedRoutes()
        final int contentLength = request.content().length();
                // If an alternative handler for an explicit path is registered to a
                        "The engine does not support HTTP streaming, unable to serve uri ["
import java.io.IOException;
                // Not using the error message directly from 'exception.getMessage()' to avoid unescaped HTML special characters,
        try {
            while (allHandlers.hasNext()) {
    private boolean handleNoHandlerFound(String rawPath, RestRequest.Method method, String uri, RestChannel channel) {
        List<MethodHandlers> methodHandlers = new ArrayList<>();
            if (methodHandlers != null) {
                    return;
            RestRequest.Method.GET,
                } catch (Exception e) {
            + "] instead.";
            return delegate.isReadable();
public class RestController implements HttpServerTransport.Dispatcher {
            } else if (cause instanceof Exception exception) {
                    channel.sendResponse(
            }
     * Returns an iterator over registered REST method handlers.
        try {
        RestRequest.Method deprecatedMethod,
        RestChannel responseChannel = channel;
                inFlightRequestsBreaker(circuitBreakerService).addEstimateBytesAndMaybeBreak(contentLength, "<http_request>");
            this.contentLength = contentLength;
            logger.warn("failed to send bad request response", e);
                    )
                handler = null;
        restHandler.routes().forEach(route -> registerHandler(route.getMethod(), route.getPath(), restHandler));
            } catch (Exception inner) {
        }
            errorMessage = "Content-Type header [" + Strings.collectionToCommaDelimitedString(contentTypeHeader) + "] is not supported";
        }
 * KIND, either express or implied.  See the License for the
    private void tryAllHandlers(final RestRequest request, final RestChannel channel, final ThreadContext threadContext) throws Exception {
                final List<String> distinctHeaderValues = headerValues.stream().distinct().collect(Collectors.toList());
        @Override
        public void sendResponse(RestResponse response) {
     * and {@code path} combinations.
            return delegate.detailedErrorStackTraceEnabled();
        @Override
            if (mediaType == null) {
            + path
                return;
        public boolean detailedErrorStackTraceEnabled() {
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.http.HttpTransportSettings;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    }
        }
 * this file be licensed under the Apache-2.0 license or a
        RestHandler handler,
            final Exception e;
     * Handle a requests with no candidate handlers (return a 400 Bad Request
        final Supplier<Map<String, String>> paramsSupplier;
            try {
     * with {@code deprecatedMethod} and {@code deprecatedPath}. Expected usage:
            bytesRestResponse.addHeader("Allow", Strings.collectionToDelimitedString(validMethodSet, ","));
            channel.sendResponse(new BytesRestResponse(INTERNAL_SERVER_ERROR, BytesRestResponse.TEXT_CONTENT_TYPE, BytesArray.EMPTY));
import org.opensearch.common.path.PathTrie;
        }
        // e.g., [POST /_optimize] is deprecated! Use [POST /_forcemerge] instead.
        Set<RestRequest.Method> validMethods = new HashSet<>();
        @Override
                bytesRestResponse.addHeader("Allow", Strings.collectionToDelimitedString(validMethodSet, ","));
                logger.error(() -> new ParameterizedMessage("failed to send failure response for uri [{}]", request.uri()), inner);
        final MediaType mediaType = request.getMediaType();
     * {@code handler}.
     * @return {@link Iterator} of {@link MethodHandlers}
            path,
            final MethodHandlers methodHandlers = allHandlers.next();
            if (validMethodSet.isEmpty() == false) {
            (request, channel, clnt) -> channel.sendResponse(new BytesRestResponse(RestStatus.OK, "image/x-icon", FAVICON_RESPONSE))
 * license agreements. See the NOTICE file distributed with
            return delegate.newBuilder(mediaType, responseContentType, useFiltering);
import org.reactivestreams.Subscriber;
                requestParamsRef.clear();
        return Optional.empty();
        public boolean isWritable() {
    /**
     * error).
import java.util.Set;
            handlerWrapper = h -> h; // passthrough if no wrapper set
/*
                            "multiple values for single-valued header [" + name + "]."
import static org.opensearch.cluster.metadata.IndexNameExpressionResolver.SYSTEM_INDEX_ACCESS_CONTROL_HEADER_KEY;
import org.opensearch.common.logging.DeprecationLogger;
     * The registered REST handler ({@code method} with {@code path}) is a normal REST handler that is not deprecated and it is
            channel.sendResponse(new BytesRestResponse(INTERNAL_SERVER_ERROR, BytesRestResponse.TEXT_CONTENT_TYPE, BytesArray.EMPTY));
     * Handle requests to a valid REST endpoint using an unsupported HTTP
            return delegate.newBuilder();
        try {
        private final int contentLength;
            return delegate.newBuilder(mediaType, useFiltering);
                )
        public void prepareResponse(RestStatus status, Map<String, List<String>> headers) {
        }
        private final StreamingRestChannel delegate;
        // Get the map of matching handlers for a request, for the full set of HTTP methods.
            }
                }
        String deprecatedPath
            return delegate.detailedErrorsEnabled();
    private final UsageService usageService;
import static org.opensearch.core.rest.RestStatus.METHOD_NOT_ALLOWED;
            + deprecatedPath
        final Iterator<RestMethodHandlers> allHandlers = getAllRestMethodHandlers(params, rawPath);
            final RestHandler handler;
     * response code is returned, and the response 'Allow' header includes a
        }
 * compatible open source license.
            this.delegate = delegate;
            );
        }
                        channel,
        registerHandler(method, path, handler);
                        )
            this.delegate = delegate;
        private final AtomicBoolean released = new AtomicBoolean();
     * @param deprecationMessage The message to log and send as a header in the response
    }
            if (responseSent.compareAndSet(false, true) == false) {
        private final RestChannel delegate;
        @Override
        StreamHandlingHttpChannel(StreamingRestChannel delegate, CircuitBreakerService circuitBreakerService, int contentLength) {
                if (handedOff == false) {
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
     * list of valid HTTP methods for the endpoint (see
     * @param handler The handler to actually execute
            paramsSupplier = () -> {
            return delegate.isWritable();
            }
                );
        }
     * 10.4.6 - 405 Method Not Allowed</a>).
        assert (handler instanceof DeprecationRestHandler) == false;
 */
        while (allHandlers.hasNext()) {
                client.threadPool().getThreadContext().putHeader(SYSTEM_INDEX_ACCESS_CONTROL_HEADER_KEY, Boolean.FALSE.toString());
            return delegate.request();
 * the Apache License, Version 2.0 (the "License"); you may
                    route.getDeprecatedMethod(),
                    responseSent.set(false);
            final Map<String, String> originalParams = new HashMap<>(requestParamsRef);
        if (contentTypeHeader == null) {
        try (XContentBuilder builder = channel.newErrorBuilder()) {
        // Loop through all possible handlers, attempting to dispatch the request
        final RestRequest.Method requestMethod;
/*
        @Override
        }
 * Unless required by applicable law or agreed to in writing,
        public void sendResponse(RestResponse response) {
            channel.sendResponse(new BytesRestResponse(channel, BAD_REQUEST, e));
                }
    }
        public XContentBuilder newBuilder(MediaType mediaType, MediaType responseContentType, boolean useFiltering) throws IOException {
        Set<RestHeaderDefinition> headersToCopy,
                    responseSent.set(false);
        }
            return delegate.newBuilder(mediaType, responseContentType, useFiltering);
            boolean accepted = false;
        // If request has not been handled, fallback to a bad request error.
     *                                          POST, "/_optimize", deprecationLogger);
        registerHandler(method, path, new DeprecationRestHandler(handler, deprecationMessage, deprecationLogger));
                } else {
import org.opensearch.common.util.io.Streams;
                // The handler may support streaming but not the engine, in this case we fail with the bad request
                return Optional.of(handler);
                sendContentTypeErrorMessage(request.getAllHeaderValues("Content-Type"), channel);
        NodeClient client,
        CircuitBreakerService circuitBreakerService,
                    if (Task.X_REQUEST_ID.equals(restHeader.getName())) {
            }
            + method.name()
    private static final BytesReference FAVICON_RESPONSE;
        }
            if (released.compareAndSet(false, true)) {
     * <p>
                releaseRequestBytes();
        public XContentBuilder newBuilder(@Nullable MediaType mediaType, boolean useFiltering) throws IOException {
                    // Validate input URI to filter out HTML special characters in the error message,
        }
import org.opensearch.common.xcontent.XContentType;
        registerHandlerNoWrap(
import org.opensearch.http.HttpServerTransport;
    private final UnaryOperator<RestHandler> handlerWrapper;
                throw new IllegalStateException("A response was already sent on this channel");
            builder.endObject();
            return;
        } catch (Exception e) {
        registerAsDeprecatedHandler(deprecatedMethod, deprecatedPath, handler, deprecationMessage);
                e.addSuppressed(cause);
                }
     */
     *
            handleUnsupportedHttpMethod(uri, null, channel, getValidHandlerMethodSet(rawPath), e);
                inFlightRequestsBreaker(circuitBreakerService).addWithoutBreaking(contentLength);
 * under the License.
            // TODO: Count requests double in the circuit breaker if they need copying?
            }
                }
            if (exception == null) {
        private final CircuitBreakerService circuitBreakerService;
     * @param method GET, POST, etc.
            }
        } catch (final IllegalArgumentException e) {
            if (handler.canTripCircuitBreaker()) {
        String uri,
                if (validMethodSet.contains(method) == false) {
        if (validMethodSet.isEmpty() == false) {
    public void registerHandler(final RestHandler restHandler) {
        }
        private final AtomicBoolean responseSent = new AtomicBoolean();
        @Override
            Streams.copy(stream, out);
    public Optional<RestHandler> dispatchHandler(String uri, String rawPath, RestRequest.Method method, Map<String, String> params) {
            }
    private static final Logger logger = LogManager.getLogger(RestController.class);
            paramsSupplier = () -> null;
            if (handler.supportsContentStream() && mediaType != MediaTypeRegistry.JSON && mediaType != XContentType.SMILE) {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
        public boolean detailedErrorsEnabled() {
     * Registers a REST handler with the controller. The REST handler declares the {@code method}
import org.apache.logging.log4j.LogManager;
     * @param path Path to handle (e.g., "/{index}/{type}/_bulk")
    }
import org.opensearch.tasks.Task;
        final RestChannel channel,
        }
                request.ensureSafeBuffers();
            if (handlers == null) {
        private final CircuitBreakerService circuitBreakerService;
            } finally {
    private final CircuitBreakerService circuitBreakerService;
                // The OPENSEARCH_PRODUCT_ORIGIN_HTTP_HEADER indicates that the request is coming from an OpenSearch product with a plan
        private final AtomicBoolean released = new AtomicBoolean();
            // Resolves the HTTP method and fails if the method is invalid
import java.util.stream.Collectors;
    private static final class StreamHandlingHttpChannel implements StreamingRestChannel {
            };
                        RestStatus.NOT_ACCEPTABLE,
                    builder.field("error", "invalid uri has been requested");
            }
    /**
        }
        UnaryOperator<RestHandler> handlerWrapper,
    protected void registerHandler(RestRequest.Method method, String path, RestHandler handler) {
 * this work for additional information regarding copyright
        UsageService usageService
            {
import java.util.HashMap;
        // my_index/my_type/http%3A%2F%2Fwww.google.com
            if (method == RestRequest.Method.OPTIONS) {
     * @param handler The handler to actually execute
        String path,
     * @param method GET, POST, etc.
        @Override
                // different HTTP method than the one supplied - return a 405 Method
            Iterator<RestMethodHandlers> allHandlers = getAllRestMethodHandlers(request.params(), rawPath);
                    // Validate request-id header if present
    }
                }
                handleOptionsRequest(channel, validMethodSet);
import org.opensearch.common.util.concurrent.ThreadContext;
                    BytesRestResponse.createSimpleErrorResponse(
     */
        public boolean detailedErrorStackTraceEnabled() {
        } catch (IOException e) {
    }
            }
 * Modifications Copyright OpenSearch Contributors. See
            final StringBuilder msg = new StringBuilder();
                releaseRequestBytes();
                // in case false-positive cross site scripting vulnerability is detected by common security scanners.
        public XContentBuilder newBuilder(MediaType mediaType, MediaType responseContentType, boolean useFiltering) throws IOException {
        while (allHandlers.hasNext()) {
        }
    Iterator<RestMethodHandlers> getAllRestMethodHandlers(@Nullable Map<String, String> requestParamsRef, String rawPath) {
import org.opensearch.common.settings.Settings;
                accepted = true;
        this.circuitBreakerService = circuitBreakerService;
            if (released.compareAndSet(false, true)) {
            this.circuitBreakerService = circuitBreakerService;
        }
            "/favicon.ico",
     * <a href="https://tools.ietf.org/html/rfc2616#section-10.4.6">HTTP/1.1 -
        return handlers.retrieveAll(rawPath, paramsSupplier);
        @Override
        }
        public XContentBuilder newErrorBuilder() throws IOException {
        final String deprecationMessage = "["
    public Iterator<MethodHandlers> getAllHandlers() {
    private final NodeClient client;
        this.usageService = usageService;
            return delegate.newErrorBuilder();
     * controller.registerWithDeprecatedHandler(POST, "/{index}/_forcemerge", this,
        public RestRequest request() {
                    route.getDeprecatedPath()
     * Registers a REST handler to be executed when the provided {@code method} and {@code path} match the request, or when provided
                    return;
        @Override
                BytesRestResponse.createSimpleErrorResponse(channel, BAD_REQUEST, "error traces in responses are disabled.")
            (mHandlers, newMHandler) -> mHandlers.addMethods(maybeWrappedHandler, method)
     * controller.registerWithDeprecatedHandler(POST, "/_forcemerge", this,
            }
        );
    }
            // Between retrieving the correct path, we need to reset the parameters,
            requestMethod = request.method();
                // PathTrie modifies the request, so reset the params between each iteration
                    restHandler,
        } catch (final IOException e) {
 *
            } else {
                msg.append("Incorrect HTTP method for uri [").append(uri);
        }
        @Override
            builder.startObject();
import java.io.InputStream;
     * header includes a list of valid HTTP methods for the endpoint (see
            }
        }
     * // remove deprecation in next major release
    ) {
            delegate.sendChunk(chunk);
            }
            subscribed.set(true);
    @Override
                            + "]"
            handler.handleRequest(request, responseChannel, client);
 *
 */
     * @param method GET, POST, etc.
     * @param path Path to handle (e.g., "/{index}/{type}/_bulk")
import org.apache.logging.log4j.message.ParameterizedMessage;
                msg.append("Unexpected HTTP method");
                throw new IllegalStateException("A response was already sent on this channel");
        }
        }
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.core.common.bytes.BytesArray;
    }
            }
    public void dispatchBadRequest(final RestChannel channel, final ThreadContext threadContext, final Throwable cause) {
        }
     * </code></pre>
import java.util.Optional;
                            + request.getHttpRequest().uri()
                if (restHeader.isMultiValueAllowed() == false && distinctHeaderValues.size() > 1) {
                validMethods.addAll(methodHandlers.getValidMethods());
        @Nullable final IllegalArgumentException exception
            channel.sendResponse(
            return delegate.newErrorBuilder();
import java.util.Iterator;
                            + request.getHttpRequest().method()
import static org.opensearch.rest.BytesRestResponse.TEXT_CONTENT_TYPE;
            }
        public void subscribe(Subscriber<? super HttpChunk> subscriber) {
        }
    private static final String OPENSEARCH_PRODUCT_ORIGIN_HTTP_HEADER = "X-opensearch-product-origin";
                        "Content-Type [" + mediaType + "] does not support stream parsing. Use JSON or SMILE instead"
        this.requestIdMaxLength = maxLength;
    }
            } else {
                }
            if (cause == null) {
     * @param handler The handler to actually execute
                }
            final List<String> headerValues = request.getAllHeaderValues(name);
        final String uri = request.uri();
        @Override
        this.headersToCopy = headersToCopy;
                        RequestUtils.validateRequestId(distinctHeaderValues.getFirst(), requestIdMaxLength);
        @Nullable RestRequest.Method method,
     * Registers a REST handler to be executed when the provided {@code method} and {@code path} match the request.
import java.util.function.UnaryOperator;
            if (responseSent.compareAndSet(false, true) == false) {
    }
                    prepareResponse(response.status(), Map.of("Content-Type", List.of(response.contentType())));
        }
        if (validMethodSet.contains(method) == false) {
        try {
            delegate.subscribe(subscriber);
            }
                    if (handleNoHandlerFound(rawPath, requestMethod, uri, channel)) {
import org.opensearch.common.io.stream.BytesStreamOutput;
        // we consume the error_trace parameter first to ensure that it is always consumed
    private static final class ResourceHandlingHttpChannel implements RestChannel {
     * <p>
                return;
                // over so we need to populate those **before** that, if possible.
            } else {
        restHandler.deprecatedRoutes()
 * SPDX-License-Identifier: Apache-2.0
                    );
    }
