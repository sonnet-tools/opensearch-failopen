     *
     * @param discoveryExtensionNode The extension node to which to send actions
        return this.discoveryExtensionNode.getId() + ":" + SEND_TO_EXTENSION_ACTION;
                );
            emptyList(),
        final RestExecuteOnExtensionResponse restExecuteOnExtensionResponse = new RestExecuteOnExtensionResponse(
        TransportService transportService,
            } catch (IndexOutOfBoundsException | IllegalArgumentException e) {
import static java.util.Collections.unmodifiableList;
import java.util.concurrent.TimeoutException;
    private static final Set<String> allowList = Set.of("Content-Type");
                        if (!trimmed.isEmpty()) {
        } catch (Exception ex) {
            public String executor() {
            public RestExecuteOnExtensionResponse read(StreamInput in) throws IOException {
 * The OpenSearch Contributors require contributions made to
                    path,
        this.pathPrefix = "/_extensions/_" + restActionsRequest.getUniqueId();
 * compatible open source license.
import org.apache.logging.log4j.LogManager;
                path = pathPrefix + restAction.substring(delim).trim();
    public List<Route> routes() {
 */
                    httpVersion
                inProgressFuture.completeExceptionally(exp);
package org.opensearch.extensions.rest;
 * @opensearch.experimental
        RegisterRestActionsRequest restActionsRequest,
import java.nio.charset.StandardCharsets;
            false
                return channel -> channel.sendResponse(
    private static final String SEND_TO_EXTENSION_ACTION = "send_to_extension_action";
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
import org.opensearch.transport.TransportResponseHandler;
            }
        );
                // comma-separated action names
                restExecuteOnExtensionResponse.setContent(response.getContent());
    private final List<DeprecatedRoute> deprecatedRoutes;
                    method,
                restExecuteOnExtensionResponseHandler
        return this.deprecatedRoutes;
                ExtensionsManager.REQUEST_REST_EXECUTE_ON_EXTENSION_ACTION,
        }
        // Initialize response. Values will be changed in the handler.
        // TODO: Modify {@link NamedRoute} to support deprecated route registration
    public String getName() {
/**
import static java.util.Collections.emptyMap;
                throw new RuntimeException(e.getCause());
                // On failure the original request params and content aren't consumed
 * SPDX-License-Identifier: Apache-2.0
            // TODO Find a better way to parse these to avoid code-smells
    public List<DeprecatedRoute> deprecatedRoutes() {
        final TransportResponseHandler<RestExecuteOnExtensionResponse> restExecuteOnExtensionResponseHandler = new TransportResponseHandler<
        MediaType contentType = request.getMediaType();
                    contentType,
            NamedRoute nr = new NamedRoute.Builder().method(method).path(path).uniqueName(name).legacyActionNames(actionNames).build();
        });
        } catch (CompletionException e) {
        try {
    public RestSendToExtensionAction(
            Throwable cause = e.getCause();
            logger.info("Registering: " + method + " " + path + " with deprecation message " + message);
        return filteredHeaders;
import org.opensearch.rest.RestRequest.Method;
    private static final Logger logger = LogManager.getLogger(RestSendToExtensionAction.class);
            TokenManager tokenManager = identityService.getTokenManager();
            restExecuteOnExtensionResponse.getContent()
    private final TransportService transportService;
            }
        Map<String, List<String>> filteredHeaders = headers.entrySet()
import java.io.IOException;
        Map<String, String> params = request.params();
import org.opensearch.rest.NamedRoute;
 * An action that forwards REST requests to an extension
            } else {
        }
        Map<String, List<String>> headers = request.getHeaders();
                method = RestRequest.Method.valueOf(parts[0].trim());
            }
import org.opensearch.extensions.ExtensionsManager;
        IdentityService identityService
            } catch (IndexOutOfBoundsException | IllegalArgumentException e) {
                    request.content();
        BytesReference content = request.content();
            }
            .filter(e -> !denyList.contains(e.getKey()))
 */
 * this file be licensed under the Apache-2.0 license or a
        return this.routes;
                        String trimmed = action.trim();
            restExecuteOnExtensionResponse.getContentType(),
    @Override
        List<String> deprecatedActions = restActionsRequest.getDeprecatedRestActions();
                if (parts.length > 3) {
            logger.info("Registering: " + method + " " + path + " " + name);
     * @param transportService The OpenSearch transport service
                throw (Error) e.getCause();
import org.opensearch.core.rest.RestStatus;
import org.apache.logging.log4j.Logger;
import java.util.Set;
public class RestSendToExtensionAction extends BaseRestHandler {
        DiscoveryExtensionNode discoveryExtensionNode,
            emptyMap(),
        List<DeprecatedRoute> restActionsAsDeprecatedRoutes = new ArrayList<>();
            message.getBytes(StandardCharsets.UTF_8),
                restExecuteOnExtensionResponse.setContentType(response.getContentType());
        }
        DynamicActionRegistry dynamicActionRegistry,
     */
        this.discoveryExtensionNode = discoveryExtensionNode;
        RestRequest.Method method;
    ) {
import java.util.concurrent.CompletionException;
import org.opensearch.identity.IdentityService;
                new ExtensionRestRequest(
            Set<String> actionNames = new HashSet<>();
     * @param restActionsRequest A request encapsulating a list of Strings with the API methods and paths.
import java.util.HashSet;
            inProgressFuture.orTimeout(ExtensionsManager.EXTENSION_REQUEST_WAIT_TIMEOUT, TimeUnit.SECONDS).join();
            public void handleResponse(RestExecuteOnExtensionResponse response) {
        BytesRestResponse restResponse = new BytesRestResponse(
}
        return channel -> channel.sendResponse(restResponse);
            // Will be replaced with ExtensionTokenProcessor and PrincipalIdentifierToken classes from feature/identity
            restExecuteOnExtensionResponse.getStatus(),
            RestExecuteOnExtensionResponse>() {
                logger.debug("REST request failed", exp);
            try {
    private final IdentityService identityService;
import java.util.Map;
                // Consume parameters and content
            Map<String, List<String>> filteredHeaders = filterHeaders(headers, allowList, denyList);
        HttpRequest.HttpVersion httpVersion = httpRequest.protocolVersion();
    private final String pathPrefix;
        String path = request.path();
            @Override
        HttpRequest httpRequest = request.getHttpRequest();
                // DO NOT INCLUDE HEADERS WITH SECURITY OR PRIVACY INFORMATION
import org.opensearch.transport.TransportService;
        if (path.startsWith(pathPrefix)) {
import java.util.ArrayList;
                logger.info("Received response from extension: {}", response.getStatus());
            .filter(e -> allowList.contains(e.getKey()))
 *
            );
import org.opensearch.common.annotation.ExperimentalApi;
    public Map<String, List<String>> filterHeaders(Map<String, List<String>> headers, Set<String> allowList, Set<String> denyList) {
            path = path.substring(pathPrefix.length());
    @Override
    }
    @Override
            restActionsAsRoutes.add(nr);
                // which gives misleading error messages, so we just consume them here
        );
                inProgressFuture.complete(response);
            String restAction = deprecatedActions.get(i);
                // SEE https://github.com/opensearch-project/OpenSearch/issues/4429
    }
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
                response.getConsumedParams().stream().forEach(p -> request.param(p));
import org.opensearch.extensions.DiscoveryExtensionNode;
                        }
            }
            Subject subject = this.identityService.getCurrentSubject();
            }
import java.util.stream.Collectors;
        final CompletableFuture<RestExecuteOnExtensionResponse> inProgressFuture = new CompletableFuture<>();
                    filteredHeaders,
            restActionsAsDeprecatedRoutes.add(new DeprecatedRoute(method, path, message));
            // All extension routes being registered must have a unique name associated with them
            } else if (e.getCause() instanceof Error) {
import org.opensearch.transport.client.node.NodeClient;
        // Iterate in pairs of route / deprecation message
        List<Route> restActionsAsRoutes = new ArrayList<>();
        Method method = request.method();
        String message = "Forwarding the request " + method + " " + path + " to " + discoveryExtensionNode;
     * Instantiates this object using a {@link RegisterRestActionsRequest} to populate the routes.
                ),
                }
            .stream()
        // No constructor that includes headers so we roll our own
                throw new IllegalArgumentException(restAction + " does not begin with a valid REST method");
        this.identityService = identityService;
 *
                    }
                    uri,
    private final List<Route> routes;
        for (int i = 0; i < deprecatedActions.size() - 1; i += 2) {
import java.util.List;
            transportService.sendRequest(
                throw (RuntimeException) e.getCause();
import org.opensearch.action.ActionModule.DynamicActionRegistry;
                restExecuteOnExtensionResponse.setStatus(response.getStatus());
            dynamicActionRegistry.registerDynamicRoute(nr, this);
    /**
        String path;
                return ThreadPool.Names.GENERIC;
            String message = deprecatedActions.get(i + 1);
                    String[] actions = parts[3].split(",");
            @Override
            BytesRestResponse.TEXT_CONTENT_TYPE,
        };
                    for (String action : actions) {
import org.opensearch.identity.tokens.TokenManager;
            }
            @Override
import org.opensearch.threadpool.ThreadPool;
                return new RestExecuteOnExtensionResponse(in);
        restExecuteOnExtensionResponse.getHeaders().entrySet().stream().forEach(e -> {
            @Override
        for (String restAction : restActionsRequest.getRestActions()) {
import org.opensearch.rest.BytesRestResponse;
            }
import org.opensearch.core.xcontent.MediaType;
            public void handleException(TransportException exp) {
import org.opensearch.identity.tokens.OnBehalfOfClaims;
                    tokenManager.issueOnBehalfOfToken(subject, claims).asAuthHeaderValue(),
    }
            OnBehalfOfClaims claims = new OnBehalfOfClaims(discoveryExtensionNode.getId(), subject.getPrincipal().getName());
                }
            RestStatus.INTERNAL_SERVER_ERROR,
import java.util.concurrent.CompletableFuture;
            e.getValue().stream().forEach(v -> restResponse.addHeader(e.getKey(), v));
    }
            if (e.getCause() instanceof RuntimeException) {
            return channel -> channel.sendResponse(new BytesRestResponse(RestStatus.INTERNAL_SERVER_ERROR, ex.getMessage()));
                throw new IllegalArgumentException("REST action must contain at least a REST method, a route and a unique name");
                path = pathPrefix + parts[1].trim();
import org.opensearch.transport.TransportException;
                restExecuteOnExtensionResponse.setHeaders(response.getHeaders());
            try {
                discoveryExtensionNode,
                request.params().keySet().stream().forEach(p -> request.param(p));
            }
                throw new IllegalArgumentException(restAction + " does not begin with a valid REST method");
            int delim = restAction.indexOf(' ');
        this.transportService = transportService;
                request.content();
        String uri = httpRequest.uri();
                if (response.isContentConsumed()) {
import java.util.concurrent.TimeUnit;
            if (cause instanceof TimeoutException) {
import org.opensearch.identity.Subject;
        logger.info(message);
            if (parts.length < 3) {
    private static final Set<String> denyList = Set.of("Authorization", "Proxy-Authorization");
            String[] parts = restAction.split(" ");
                name = parts[2].trim();
import org.opensearch.core.common.bytes.BytesReference;
import static java.util.Collections.emptyList;
import org.opensearch.rest.RestRequest;
                method = RestRequest.Method.valueOf(restAction.substring(0, delim));
        }
@ExperimentalApi
import org.opensearch.rest.BaseRestHandler;
            logger.info("Failed to send REST Actions to extension " + discoveryExtensionNode.getName(), ex);
                    params,
/*
    }
    @Override
import org.opensearch.core.common.io.stream.StreamInput;
            String name;
import org.opensearch.http.HttpRequest;
                    new BytesRestResponse(RestStatus.REQUEST_TIMEOUT, "No response from extension to request.")
        this.deprecatedRoutes = unmodifiableList(restActionsAsDeprecatedRoutes);
        this.routes = unmodifiableList(restActionsAsRoutes);
    private final DiscoveryExtensionNode discoveryExtensionNode;
                    content,
                            actionNames.add(trimmed);
