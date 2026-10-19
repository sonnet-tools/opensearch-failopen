     * @param method GET, POST, etc.  
        final String errorMessage;
                    return;  
     * @param path Path to handle (e.g., "/_forcemerge")  
                channel.sendResponse(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            throw new AssertionError(e);
            handleUnsupportedHttpMethod(uri, null, channel, getValidHandlerMethodSet(rawPath), e);
        @Override
        @Override
        final Set<RestRequest.Method> validMethodSet = getValidHandlerMethodSet(rawPath);
            {
     * @param handler The handler to actually execute
        UnaryOperator<RestHandler> handlerWrapper,
     * controller.registerWithDeprecatedHandler(POST, "/{index}/_forcemerge", this,  
        try {  
    /**  
        return circuitBreakerService.getBreaker(CircuitBreaker.IN_FLIGHT_REQUESTS);
            final MethodHandlers methodHandlers = allHandlers.next();  
            channel.sendResponse(new BytesRestResponse(INTERNAL_SERVER_ERROR, BytesRestResponse.TEXT_CONTENT_TYPE, BytesArray.EMPTY));  
     * {@code handler}.  
        @Override  
        RestRequest.Method deprecatedMethod,  
        } catch (final IllegalArgumentException e) {
                releaseRequestBytes();
            bytesRestResponse.addHeader("Allow", Strings.collectionToDelimitedString(validMethodSet, ","));
     * @param method GET, POST, etc.
                inner.addSuppressed(e);
                msg.append(", allowed: ").append(validMethodSet);
            return delegate.detailedErrorStackTraceEnabled();  
        @Override
    private static CircuitBreaker inFlightRequestsBreaker(CircuitBreakerService circuitBreakerService) {
     * @param method GET, POST, etc.
        public boolean isWritable() {  
    }
        }
                }
     * <p>
        if (contentTypeHeader == null) {  
import reactor.core.publisher.Mono;  
import org.opensearch.http.HttpTransportSettings;
            if (mediaType == null) {
            this.contentLength = contentLength;
     * method. A 405 HTTP response code is returned, and the response 'Allow'
                    // Nothing reached the client, so the failure response must still be allowed through this channel.  
     * with {@code deprecatedMethod} and {@code deprecatedPath}. Expected usage:
        @Override
        public XContentBuilder newBuilder() throws IOException {  
                            + request.getHttpRequest().method()
                if (accepted == false) {
            }
                requestParamsRef.clear();
    private Set<RestRequest.Method> getValidHandlerMethodSet(String rawPath) {
     * Get the valid set of HTTP methods for a REST request.  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
 * @opensearch.api
            }
            this.delegate = delegate;  
        }  
    /**  
            this.circuitBreakerService = circuitBreakerService;
                    sendContentTypeErrorMessage(request.getAllHeaderValues("Content-Type"), responseChannel);
    }  
        final int contentLength = request.content().length();
import java.util.HashMap;
    public Iterator<MethodHandlers> getAllHandlers() {  
     * 10.4.6 - 405 Method Not Allowed</a>).
        private final int contentLength;
    /**
        registerHandlerNoWrap(  
     *
import org.opensearch.transport.client.node.NodeClient;  
    private static final class ResourceHandlingHttpChannel implements RestChannel {
    ) {
        final String rawPath = request.rawPath();  
        }
            // Between retrieving the correct path, we need to reset the parameters,
    private boolean handleNoHandlerFound(String rawPath, RestRequest.Method method, String uri, RestChannel channel) {  
    private void registerHandlerNoWrap(RestRequest.Method method, String path, RestHandler maybeWrappedHandler) {
        try (InputStream stream = RestController.class.getResourceAsStream("/config/favicon.ico")) {
        while (allHandlers.hasNext()) {
            }
        public boolean isReadable() {
            return delegate.newErrorBuilder();  
 */  
                    route.getPath(),
            } else {
    private final PathTrie<RestMethodHandlers> handlers = new PathTrie<>(RestUtils.REST_DECODER);
            return delegate.detailedErrorsEnabled();
                msg.append("] and method [").append(method).append("]");  
        RestRequest.Method method,  
import java.util.Optional;
     * Registers a REST handler to be executed when the provided {@code method} and {@code path} match the request, or when provided  
        // If request has not been handled, fallback to a bad request error.
import org.opensearch.common.logging.DeprecationLogger;
                try {  
    private final UnaryOperator<RestHandler> handlerWrapper;
                    BytesRestResponse.createSimpleErrorResponse(
            );
                    threadContext.putHeader(name, String.join(",", distinctHeaderValues));
                    }
        channel.sendResponse(BytesRestResponse.createSimpleErrorResponse(channel, NOT_ACCEPTABLE, errorMessage));  
                    return;
        registerHandlerNoWrap(method, path, handlerWrapper.apply(handler));
        registerHandler(method, path, new DeprecationRestHandler(handler, deprecationMessage, deprecationLogger));
                } else {
                requestParamsRef.putAll(originalParams);
        @Override
        for (final RestHeaderDefinition restHeader : headersToCopy) {
     */
            return;  
                            + request.getHttpRequest().uri()  
        /** Guards the in-flight-requests breaker release, which must happen exactly once. */
    private final Set<RestHeaderDefinition> headersToCopy;
        private final RestChannel delegate;  
     * - Options</a>).
        final RestChannel channel,
                        "The engine does not support HTTP streaming, unable to serve uri ["
        if (channel.detailedErrorStackTraceEnabled() && channel.detailedErrorsEnabled() == false) {
            this.delegate = delegate;  
            while (allHandlers.hasNext()) {
                handler = null;  
                } else {  
        @Override
            channel.sendResponse(bytesRestResponse);
        handleBadRequest(uri, requestMethod, channel);  
import org.opensearch.common.util.io.Streams;  
 *  
     * Returns an iterator over registered REST method handlers.  
    }
        this.client = client;
            if (responseSent.compareAndSet(false, true) == false) {
        // e.g., [POST /_optimize] is deprecated! Use [POST /_forcemerge] instead.  
        return Optional.empty();
        private final int contentLength;
    }
                route -> registerWithDeprecatedHandler(
        this.circuitBreakerService = circuitBreakerService;
            } else {
        }
                handleUnsupportedHttpMethod(uri, method, channel, validMethodSet, null);  
            if (handler.canTripCircuitBreaker()) {
        /** Guards the response handoff. Claimed atomically and reset if the delegate rejects the response. */
                    dispatchRequest(request, channel, handler);  
        // We always obtain a fresh breaker to reflect changes to the breaker configuration.  
            logger.warn("failed to send bad request response", e);  
            Streams.copy(stream, out);
                return true;
 * compatible open source license.
            if (cause != null) {
                if (mediaType == null) {
        } catch (final IOException e) {
import org.opensearch.core.xcontent.MediaType;
                    prepareResponse(response.status(), Map.of("Content-Type", List.of(response.contentType())));  
        }  
                    if (Task.X_REQUEST_ID.equals(restHeader.getName())) {  
        }
            try {
            }
import org.apache.logging.log4j.LogManager;
            boolean accepted = false;
            }
     * header includes a list of valid HTTP methods for the endpoint (see  
            }  
            return delegate.detailedErrorsEnabled();
            }
                e.addSuppressed(cause);  
     */
 *    http://www.apache.org/licenses/LICENSE-2.0
        @Override
        // we use rawPath since we don't want to decode it while processing the path resolution  
        public BytesStreamOutput bytesOutput() {
            if (handler.supportsStreaming()) {
    }
        try {
        } catch (Exception e) {  
import static org.opensearch.core.rest.RestStatus.METHOD_NOT_ALLOWED;
        @Override  
            } finally {
     * @param deprecatedPath <em>Deprecated</em> path to handle (e.g., "/_optimize")  
    /** Rest headers that are copied to internal requests made during a rest request. */
            } else {
            } else {
import static org.opensearch.cluster.metadata.IndexNameExpressionResolver.SYSTEM_INDEX_ACCESS_CONTROL_HEADER_KEY;
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestController.class);  
    public void dispatchBadRequest(final RestChannel channel, final ThreadContext threadContext, final Throwable cause) {
                            "multiple values for single-valued header [" + name + "]."
        public void sendChunk(HttpChunk chunk) {  
            channel.sendResponse(  
            // TODO: Count requests double in the circuit breaker if they need copying?
        public XContentBuilder newBuilder(MediaType mediaType, MediaType responseContentType, boolean useFiltering) throws IOException {  
            if (cause == null) {
 * Modifications Copyright OpenSearch Contributors. See
                Mono.from(this).ignoreElement().then(Mono.just(response)).subscribe(delegate::sendResponse);  
 *
        String path,
            delegate.prepareResponse(status, headers);  
    private void handleOptionsRequest(RestChannel channel, Set<RestRequest.Method> validMethodSet) {  
            return delegate.newBuilder(mediaType, responseContentType, useFiltering);
 */
        channel.sendResponse(bytesRestResponse);
        }
     * replacing the deprecated REST handler ({@code deprecatedMethod} with {@code deprecatedPath}) that is using the <em>same</em>
 * this file be licensed under the Apache-2.0 license or a
            }
        // Loop through all possible handlers, attempting to dispatch the request
                        channel,  
                final RestHandler handler;  
            return delegate.newBuilder(mediaType, useFiltering);
        }
     * @return {@link Iterator} of {@link MethodHandlers}
                inFlightRequestsBreaker(circuitBreakerService).addWithoutBreaking(contentLength);
            );  
     *
                sendContentTypeErrorMessage(request.getAllHeaderValues("Content-Type"), channel);  
public class RestController implements HttpServerTransport.Dispatcher {  
import java.io.ByteArrayOutputStream;  
            }
     * and a specific message.  
            (mHandlers, newMHandler) -> mHandlers.addMethods(maybeWrappedHandler, method)  
        String deprecatedPath
            + "] is deprecated! Use ["
    }
import org.opensearch.http.HttpChunk;
        @Override
        }
            requestMethod = request.method();
                // Not using the error message directly from 'exception.getMessage()' to avoid unescaped HTML special characters,
        @Override
                if (validMethodSet.contains(method) == false) {  
        }
                // different HTTP method than the one supplied - return a 405 Method
            final List<String> headerValues = request.getAllHeaderValues(name);  
    private volatile int requestIdMaxLength = HttpTransportSettings.SETTING_HTTP_REQUEST_ID_MAX_LENGTH.getDefault(Settings.EMPTY);  
 * Licensed to Elasticsearch under one or more contributor  
            }
                    responseSent.set(false);
     */
 * ownership. Elasticsearch licenses this file to you under  
    protected void registerHandler(RestRequest.Method method, String path, RestHandler handler) {
            };
                handedOff = true;  
     * <pre><code>
import java.util.Map;  
/**
    @Override  
        RestHandler handler,
        return methodHandlers.iterator();  
 * license agreements. See the NOTICE file distributed with
        Set<RestHeaderDefinition> headersToCopy,  
            usageService.addRestHandler(baseRestHandler);  
            path,
        }  
            new RestMethodHandlers(path, maybeWrappedHandler, method),
                    // Validate input URI to filter out HTML special characters in the error message,
        }  
        handlers.retrieveAll().forEachRemaining(methodHandlers::add);
import org.opensearch.core.common.breaker.CircuitBreaker;  
        @Override  
            builder.endObject();  
                inFlightRequestsBreaker(circuitBreakerService).addEstimateBytesAndMaybeBreak(contentLength, "<http_request>");  
        @Override  
            }  
            + deprecatedMethod.name()
        restHandler.routes().forEach(route -> registerHandler(route.getMethod(), route.getPath(), restHandler));  
                inFlightRequestsBreaker(circuitBreakerService).addWithoutBreaking(-contentLength);
    }
     * @param path Path to handle (e.g., "/{index}/{type}/_bulk")  
        registerHandler(method, path, handler);
    }
                    responseChannel = new StreamHandlingHttpChannel(streamingRestChannel, circuitBreakerService, contentLength);
                    handler = handlers.getHandler(requestMethod);
        Iterator<RestMethodHandlers> allHandlers = getAllRestMethodHandlers(null, rawPath);
        }
 * this work for additional information regarding copyright
     * </code></pre>
 * software distributed under the License is distributed on an
    }
            return delegate.detailedErrorStackTraceEnabled();  
                request.ensureSafeBuffers();  
            + " "
            Iterator<RestMethodHandlers> allHandlers = getAllRestMethodHandlers(request.params(), rawPath);
 * under the License.  
import java.util.concurrent.atomic.AtomicBoolean;  
            final Map<String, String> originalParams = new HashMap<>(requestParamsRef);
            if (released.compareAndSet(false, true)) {
        @Override
        // When we have an OPTIONS HTTP request and no valid handlers, simply send OK by default (with the Access Control Origin header
     * @param deprecationMessage The message to log and send as a header in the response  
                if (handlers == null) {
            channel.sendResponse(new BytesRestResponse(BAD_REQUEST, builder));
    private static final String OPENSEARCH_PRODUCT_ORIGIN_HTTP_HEADER = "X-opensearch-product-origin";
        }
import java.util.Set;
            // Resolves the HTTP method and fails if the method is invalid
import static org.opensearch.core.rest.RestStatus.INTERNAL_SERVER_ERROR;
    private void handleUnsupportedHttpMethod(
            BytesRestResponse bytesRestResponse = BytesRestResponse.createSimpleErrorResponse(channel, METHOD_NOT_ALLOWED, msg.toString());  
import org.apache.logging.log4j.message.ParameterizedMessage;  
    }
        this.requestIdMaxLength = maxLength;
        @Override  
                // to move away from direct access to system indices, and thus deprecation warnings should not be emitted.
                // If an alternative handler for an explicit path is registered to a  
                    return Optional.empty();
                e = new OpenSearchException(cause);
                final Set<RestRequest.Method> validMethodSet = getValidHandlerMethodSet(rawPath);
            }  
                    route.getDeprecatedPath()
        @Override
        CircuitBreakerService circuitBreakerService,  
                    handler = null;  
            builder.startObject();
                        )  
     */
    ) {
                }  
            paramsSupplier = () -> {
        }  
import java.util.function.UnaryOperator;
        }
        if (requestParamsRef == null) {
            }
import org.opensearch.common.xcontent.XContentType;
     * Registers a REST handler with the controller. The REST handler declares the {@code method}
        handlers.insertOrUpdate(  
     * @param handler The handler to actually execute
        } catch (final IOException e) {
     * Handle requests to a valid REST endpoint using an unsupported HTTP
        );
                    if (handleNoHandlerFound(rawPath, requestMethod, uri, channel)) {
     * The registered REST handler ({@code method} with {@code path}) is a normal REST handler that is not deprecated and it is
            }  
        this.handlerWrapper = handlerWrapper;  
     * // remove deprecation in next major release  
            if (methodHandlers != null) {
        ResourceHandlingHttpChannel(RestChannel delegate, CircuitBreakerService circuitBreakerService, int contentLength) {
        List<MethodHandlers> methodHandlers = new ArrayList<>();
    public void registerHandler(final RestHandler restHandler) {
                    );
     * Registers a REST handler to be executed when the provided {@code method} and {@code path} match the request.
                e = new OpenSearchException("unknown cause");  
            }  
 * the Apache License, Version 2.0 (the "License"); you may
                handler = handlers.getHandler(method);
        public XContentBuilder newErrorBuilder() throws IOException {
                bytesRestResponse.addHeader("Allow", Strings.collectionToDelimitedString(validMethodSet, ","));
                // over so we need to populate those **before** that, if possible.
                handleOptionsRequest(channel, validMethodSet);
    /**
        final String deprecationMessage = "["
        }
                } else {  
                final List<String> distinctHeaderValues = headerValues.stream().distinct().collect(Collectors.toList());
        public boolean detailedErrorStackTraceEnabled() {
        private final AtomicBoolean subscribed = new AtomicBoolean();  
                }
import org.opensearch.OpenSearchException;
        public XContentBuilder newBuilder(MediaType mediaType, MediaType responseContentType, boolean useFiltering) throws IOException {  
                    // Validate request-id header if present
 * specific language governing permissions and limitations
            }
        if (contentLength > 0) {
                e = exception;
                    builder.field("error", "invalid uri has been requested");  
    public void dispatchRequest(RestRequest request, RestChannel channel, ThreadContext threadContext) {  
        );
        final Supplier<Map<String, String>> paramsSupplier;
                        "Content-Type [" + mediaType + "] does not support stream parsing. Use JSON or SMILE instead"
            this.contentLength = contentLength;
        @Override
     * Deprecated REST handlers without a direct replacement should be deprecated directly using {@link #registerAsDeprecatedHandler}
import org.opensearch.core.common.bytes.BytesReference;
        restHandler.replacedRoutes()  
            if (exception == null) {
                } else {
        final String uri = request.uri();
        }  
            + method.name()  
                }
                    responseSent.set(false);  
    public void setRequestIdMaxLength(int maxLength) {
        RestChannel responseChannel = channel;  
        private final AtomicBoolean responseSent = new AtomicBoolean();
        private final AtomicBoolean released = new AtomicBoolean();  
                inFlightRequestsBreaker(circuitBreakerService).addWithoutBreaking(-contentLength);
        }
                if (handedOff == false) {
import org.opensearch.common.path.PathTrie;
    }  
        private void releaseRequestBytes() {  
        NodeClient client,
import java.util.Iterator;
                    )  
            }
    Iterator<RestMethodHandlers> getAllRestMethodHandlers(@Nullable Map<String, String> requestParamsRef, String rawPath) {  
        this.headersToCopy = headersToCopy;  
                // The OPENSEARCH_PRODUCT_ORIGIN_HTTP_HEADER indicates that the request is coming from an OpenSearch product with a plan  
     *
     */
                );
        @Override
        this.usageService = usageService;
import java.io.InputStream;
            if (headerValues != null && headerValues.isEmpty() == false) {
 *
        if (validMethodSet.isEmpty() == false) {
                if (channel instanceof StreamingRestChannel streamingRestChannel) {
        private final AtomicBoolean responseSent = new AtomicBoolean();  
        return handlers.retrieveAll(rawPath, paramsSupplier);  
                channel.sendResponse(new BytesRestResponse(channel, e));
                validMethods.addAll(methodHandlers.getValidMethods());
        }
        return validMethods;
                // Not Allowed error.
                msg.append("Incorrect HTTP method for uri [").append(uri);
        }
            if (responseSent.compareAndSet(false, true) == false) {
            } else {  
        private final CircuitBreakerService circuitBreakerService;
            + path
        public boolean detailedErrorStackTraceEnabled() {
    }  
                accepted = true;  
    }  
 */  
            return delegate.bytesOutput();  
            "/favicon.ico",
import java.util.HashSet;  
                // in case false-positive cross site scripting vulnerability is detected by common security scanners.  
        @Override
                    );
    }
        // which gets automatically added).  
            try {  
        public void sendResponse(RestResponse response) {
                if (restHeader.isMultiValueAllowed() == false && distinctHeaderValues.size() > 1) {  
        try {
                }  
                // if we could reserve bytes for the request we need to send the response also over this channel  
    ) {
import org.opensearch.common.util.RequestUtils;
                    uri = new URI(uri).getPath();  
            final RestMethodHandlers handlers = allHandlers.next();
    private static final class StreamHandlingHttpChannel implements StreamingRestChannel {
    public Optional<RestHandler> dispatchHandler(String uri, String rawPath, RestRequest.Method method, Map<String, String> params) {
    private static final BytesReference FAVICON_RESPONSE;
     */  
        @Override  
        public void subscribe(Subscriber<? super HttpChunk> subscriber) {
 * SPDX-License-Identifier: Apache-2.0
    protected void registerWithDeprecatedHandler(
                            channel,  
        }
        }
                return Optional.of(handler);
        }
            if (validMethodSet.isEmpty() == false) {
        }  
                }
     * response code is returned, and the response 'Allow' header includes a
import static org.opensearch.rest.BytesRestResponse.TEXT_CONTENT_TYPE;
            }  
        final RestRequest.Method requestMethod;
            + "] instead.";  
                return;
        /** Guards the in-flight-requests breaker release, which must happen exactly once. */  
import org.apache.logging.log4j.Logger;
    private final CircuitBreakerService circuitBreakerService;
            channel.sendResponse(new BytesRestResponse(INTERNAL_SERVER_ERROR, BytesRestResponse.TEXT_CONTENT_TYPE, BytesArray.EMPTY));
        Set<RestRequest.Method> validMethods = new HashSet<>();  
        } catch (IOException e) {  
    private void handleBadRequest(String uri, RestRequest.Method method, RestChannel channel) throws IOException {
 * not use this file except in compliance with the License.
 *  
     * Handle HTTP OPTIONS requests to a valid REST endpoint. A 200 HTTP  
            } finally {
        if (validMethodSet.contains(method) == false) {  
                }
     * Registers a REST handler to be executed when one of the provided methods and path match the request.
    }  
            channel.sendResponse(new BytesRestResponse(channel, BAD_REQUEST, e));  
import org.opensearch.common.Nullable;
        BytesRestResponse bytesRestResponse = new BytesRestResponse(OK, TEXT_CONTENT_TYPE, BytesArray.EMPTY);
    /**
                            + "]"  
        // Get the map of matching handlers for a request, for the full set of HTTP methods.
     * @param handler The handler to actually execute
            } else if (cause instanceof Exception exception) {
    private final NodeClient client;  
    }  
        try {  
     * <a href="https://tools.ietf.org/html/rfc2616#section-9.2">HTTP/1.1 - 9.2  
        }  
                logger.error(() -> new ParameterizedMessage("failed to send failure response for uri [{}]", request.uri()), inner);
/*
     *                                          POST, "/{index}/_optimize", deprecationLogger);
     */
                return;
        StreamHandlingHttpChannel(StreamingRestChannel delegate, CircuitBreakerService circuitBreakerService, int contentLength) {
            }  
import org.opensearch.usage.UsageService;
import java.net.URI;  
     * list of valid HTTP methods for the endpoint (see
import static org.opensearch.core.rest.RestStatus.OK;
    }
            try {  
        if (handlerWrapper == null) {
        public XContentBuilder newBuilder() throws IOException {  
                            BAD_REQUEST,
    /**
        public RestRequest request() {
import static org.opensearch.core.rest.RestStatus.BAD_REQUEST;  
                        RequestUtils.validateRequestId(distinctHeaderValues.getFirst(), requestIdMaxLength);
                throw new IllegalStateException("A response was already sent on this channel");  
                // This header is intended for internal use only.
            return delegate.newBuilder();
            final RestHandler handler;  
            if (handler.allowsUnsafeBuffers() == false) {
        }
            return;  
        public boolean detailedErrorsEnabled() {  
                delegate.sendResponse(response);
                    route.getMethod(),  
        public boolean detailedErrorsEnabled() {  
        final MediaType mediaType = request.getMediaType();  
            this.circuitBreakerService = circuitBreakerService;
        private void releaseRequestBytes() {  
            if (method == RestRequest.Method.OPTIONS) {
            return delegate.request();
 * Unless required by applicable law or agreed to in writing,
    }
     *                                          POST, "/_optimize", deprecationLogger);
            handler.handleRequest(request, responseChannel, client);  
import org.opensearch.common.settings.Settings;  
     * Handle a requests with no candidate handlers (return a 400 Bad Request
            return delegate.newBuilder();
                        BytesRestResponse.createSimpleErrorResponse(
                        return;  
            }
            if (released.compareAndSet(false, true)) {
        @Override
    /**
    }
        public XContentBuilder newBuilder(@Nullable MediaType mediaType, boolean useFiltering) throws IOException {
                            + "] and method ["
                responseChannel = new ResourceHandlingHttpChannel(channel, circuitBreakerService, contentLength);
            if (handler == null) {
        }  
        }  
            if (validMethodSet.isEmpty() == false) {  
                    throw new IllegalStateException(
    private static final Logger logger = LogManager.getLogger(RestController.class);
import org.opensearch.core.common.Strings;
                    restHandler,
    protected void registerAsDeprecatedHandler(RestRequest.Method method, String path, RestHandler handler, String deprecationMessage) {
 */
            if (handlers == null) {
        }
                    builder.field("error", "no handler found for uri [" + uri + "] and method [" + method + "]");
            .forEach(route -> registerAsDeprecatedHandler(route.getMethod(), route.getPath(), restHandler, route.getDeprecationMessage()));
        } else {
                final RestMethodHandlers handlers = allHandlers.next();
            responseChannel.sendResponse(new BytesRestResponse(responseChannel, e));
    }  
            tryAllHandlers(request, channel, threadContext);
                return true;  
            boolean handedOff = false;
        }
     * <p>  
                        RestStatus.NOT_ACCEPTABLE,
        registerAsDeprecatedHandler(deprecatedMethod, deprecatedPath, handler, deprecationMessage);  
     * <a href="https://tools.ietf.org/html/rfc2616#section-10.4.6">HTTP/1.1 -
            }
            return delegate.isReadable();
            }  
            }  
            return delegate.isWritable();
    private void dispatchRequest(RestRequest request, RestChannel channel, RestHandler handler) throws Exception {
    /**
            return delegate.request();
            .forEach(
        @Nullable RestRequest.Method method,  
import java.io.IOException;
            errorMessage = "Content-Type header [" + Strings.collectionToCommaDelimitedString(contentTypeHeader) + "] is not supported";  
        public RestRequest request() {
                // The handler may support streaming but not the engine, in this case we fail with the bad request  
/*  
            paramsSupplier = () -> null;  
     * @param deprecatedMethod GET, POST, etc.
import static org.opensearch.core.rest.RestStatus.NOT_ACCEPTABLE;  
     */
     * controller.registerWithDeprecatedHandler(POST, "/_forcemerge", this,
        }
        public BytesStreamOutput bytesOutput() {
        restHandler.deprecatedRoutes()
            // Loop through all possible handlers, attempting to dispatch the request  
            RestRequest.Method.GET,
import org.reactivestreams.Subscriber;
        return false;
import org.opensearch.http.HttpServerTransport;  
        UsageService usageService
                // PathTrie modifies the request, so reset the params between each iteration  
     * @param path Path to handle (e.g., "/{index}/{type}/_bulk")
                    route.getDeprecatedMethod(),  
        }
import java.util.List;
import java.util.ArrayList;
                } catch (Exception e) {
                    }
        }
            delegate.sendChunk(chunk);
        }
        }
            }
    }
import org.opensearch.core.xcontent.XContentBuilder;
        /** Guards the response handoff. Claimed atomically and reset if subscription setup rejects the response. */
                    // in case false-positive cross site scripting vulnerability is detected by common security scanners.
        assert (handler instanceof DeprecationRestHandler) == false;  
            if (handler.supportsContentStream() && mediaType != MediaTypeRegistry.JSON && mediaType != XContentType.SMILE) {  
            if (handler.allowSystemIndexAccessByDefault() == false && request.header(OPENSEARCH_PRODUCT_ORIGIN_HTTP_HEADER) == null) {
     */  
import org.opensearch.tasks.Task;
        }  
                // observable here. Handing the response to the subscription is the strongest signal available.
/*  
    public RestController(
                if (subscribed.get() == false) {
                // Check if subscribe() is already called, the headers and status are going to be sent  
    private void tryAllHandlers(final RestRequest request, final RestChannel channel, final ThreadContext threadContext) throws Exception {  
     * and {@code path} combinations.  
                throw new IllegalStateException("A response was already sent on this channel");  
        public void prepareResponse(RestStatus status, Map<String, List<String>> headers) {
        } else {
                    return;
        final Iterator<RestMethodHandlers> allHandlers = getAllRestMethodHandlers(params, rawPath);  
 * KIND, either express or implied.  See the License for the
        private final StreamingRestChannel delegate;
import org.opensearch.common.util.concurrent.ThreadContext;
 * GitHub history for details.
                return requestParamsRef;  
        // so we can handle things like:
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();  
        }
            handlerWrapper = h -> h; // passthrough if no wrapper set  
        final Set<RestRequest.Method> validMethodSet,
                client.threadPool().getThreadContext().putHeader(SYSTEM_INDEX_ACCESS_CONTROL_HEADER_KEY, Boolean.FALSE.toString());  
            // otherwise parameters are parsed out of the URI that aren't actually handled.  
            + " "  
        }
        // we consume the error_trace parameter first to ensure that it is always consumed
                if (handler == null) {
    }  
        public XContentBuilder newBuilder(@Nullable MediaType mediaType, boolean useFiltering) throws IOException {
                // The delegate is invoked from the subscription above rather than inline, so a later failure is not
        }
import java.util.function.Supplier;
        public void sendResponse(RestResponse response) {
            return delegate.bytesOutput();  
import org.opensearch.core.common.bytes.BytesArray;
                    channel.sendResponse(
 * The OpenSearch Contributors require contributions made to  
        private final AtomicBoolean released = new AtomicBoolean();
        }
                msg.append("Unexpected HTTP method");
            (request, channel, clnt) -> channel.sendResponse(new BytesRestResponse(RestStatus.OK, "image/x-icon", FAVICON_RESPONSE))  
        public XContentBuilder newErrorBuilder() throws IOException {
        while (allHandlers.hasNext()) {
        } catch (Exception e) {
    @Override
     * error).  
    }
            return delegate.newBuilder(mediaType, useFiltering);
                )
            } catch (Exception inner) {  
    @Override
        @Nullable final IllegalArgumentException exception  
import java.util.stream.Collectors;  
    }  
 * You may obtain a copy of the License at  
            + deprecatedPath
            subscribed.set(true);
            final Exception e;
        }
            } else {  
    static {
        @Override  
        String uri,
                BytesRestResponse.createSimpleErrorResponse(channel, BAD_REQUEST, "error traces in responses are disabled.")
        try (XContentBuilder builder = channel.newErrorBuilder()) {  
                }
            }
                releaseRequestBytes();
import org.opensearch.common.io.stream.BytesStreamOutput;  
            final StringBuilder msg = new StringBuilder();  
        // my_index/my_type/http%3A%2F%2Fwww.google.com
                }
            final String name = restHeader.getName();
        private final CircuitBreakerService circuitBreakerService;  
            FAVICON_RESPONSE = new BytesArray(out.toByteArray());
            }  
            errorMessage = "Content-Type header is missing";
            logger.warn("failed to send bad request response", e);
import org.opensearch.core.rest.RestStatus;
        @Override  
import org.opensearch.core.indices.breaker.CircuitBreakerService;  
        }  
package org.opensearch.rest;
            if (validMethodSet.isEmpty() == false) {
}  
    private void sendContentTypeErrorMessage(@Nullable List<String> contentTypeHeader, RestChannel channel) throws IOException {
        if (handler instanceof BaseRestHandler baseRestHandler) {
    private final UsageService usageService;  
                }
            return delegate.newErrorBuilder();  
            delegate.subscribe(subscriber);  
        // error_trace cannot be used when we disable detailed errors  
        }
 * OpenSearch REST controller
        }
            return delegate.newBuilder(mediaType, responseContentType, useFiltering);
    /**  
