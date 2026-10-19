import org.opensearch.core.xcontent.MediaType;
        final CompletableFuture<RestExecuteOnExtensionResponse> inProgressFuture = new CompletableFuture<>();  
    @Override
        Map<String, List<String>> headers = request.getHeaders();
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));  
import org.opensearch.extensions.ExtensionsManager;
        // Initialize response. Values will be changed in the handler.  
        String path;  
        });
    @Override  
    public List<Route> routes() {
        HttpRequest httpRequest = request.getHttpRequest();  
                // SEE https://github.com/opensearch-project/OpenSearch/issues/4429  
                }  
import org.opensearch.rest.NamedRoute;  
                );
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
                if (parts.length > 3) {
        if (path.startsWith(pathPrefix)) {
                return new RestExecuteOnExtensionResponse(in);  
                return channel -> channel.sendResponse(  
                discoveryExtensionNode,  
    }
                    method,
                restExecuteOnExtensionResponse.setContent(response.getContent());
            Set<String> actionNames = new HashSet<>();
        }
            Map<String, List<String>> filteredHeaders = filterHeaders(headers, allowList, denyList);
import org.opensearch.extensions.DiscoveryExtensionNode;  
import org.opensearch.rest.BytesRestResponse;
            public RestExecuteOnExtensionResponse read(StreamInput in) throws IOException {
                restExecuteOnExtensionResponse.setStatus(response.getStatus());  
                throw new RuntimeException(e.getCause());  
            }  
            Throwable cause = e.getCause();
            }  
        IdentityService identityService
        BytesRestResponse restResponse = new BytesRestResponse(  
            if (parts.length < 3) {
    public RestSendToExtensionAction(  
 * The OpenSearch Contributors require contributions made to  
    private final DiscoveryExtensionNode discoveryExtensionNode;
                restExecuteOnExtensionResponseHandler  
            .stream()  
            public String executor() {
        return this.discoveryExtensionNode.getId() + ":" + SEND_TO_EXTENSION_ACTION;  
        Map<String, String> params = request.params();
    public String getName() {
import org.opensearch.core.rest.RestStatus;
                    tokenManager.issueOnBehalfOfToken(subject, claims).asAuthHeaderValue(),  
                throw new IllegalArgumentException(restAction + " does not begin with a valid REST method");
import org.opensearch.core.common.bytes.BytesReference;
            .filter(e -> allowList.contains(e.getKey()))
            OnBehalfOfClaims claims = new OnBehalfOfClaims(discoveryExtensionNode.getId(), subject.getPrincipal().getName());  
import org.opensearch.core.common.io.stream.StreamInput;  
import org.opensearch.http.HttpRequest;
        Method method = request.method();
        BytesReference content = request.content();
    private final List<DeprecatedRoute> deprecatedRoutes;
                    }
                    filteredHeaders,  
            emptyMap(),
                if (response.isContentConsumed()) {  
            String name;
            }
            dynamicActionRegistry.registerDynamicRoute(nr, this);  
import java.util.concurrent.CompletionException;
 * this file be licensed under the Apache-2.0 license or a
     * Instantiates this object using a {@link RegisterRestActionsRequest} to populate the routes.  
import org.opensearch.rest.RestRequest.Method;
                throw new IllegalArgumentException(restAction + " does not begin with a valid REST method");
            @Override  
import java.util.List;
import static java.util.Collections.emptyList;
        } catch (CompletionException e) {  
import static java.util.Collections.unmodifiableList;  
            try {
            String[] parts = restAction.split(" ");  
import java.util.concurrent.TimeUnit;  
import org.opensearch.common.annotation.ExperimentalApi;
    private static final Logger logger = LogManager.getLogger(RestSendToExtensionAction.class);
            restActionsAsRoutes.add(nr);
        HttpRequest.HttpVersion httpVersion = httpRequest.protocolVersion();
            String restAction = deprecatedActions.get(i);  
    private final TransportService transportService;
                    String[] actions = parts[3].split(",");
        this.identityService = identityService;
import org.opensearch.transport.TransportResponseHandler;
                        if (!trimmed.isEmpty()) {
import org.opensearch.transport.TransportService;  
import java.util.HashSet;  
            false
            RestExecuteOnExtensionResponse>() {
        restExecuteOnExtensionResponse.getHeaders().entrySet().stream().forEach(e -> {  
            String message = deprecatedActions.get(i + 1);
    @Override
 *
/*  
        final TransportResponseHandler<RestExecuteOnExtensionResponse> restExecuteOnExtensionResponseHandler = new TransportResponseHandler<
        this.transportService = transportService;  
    private final IdentityService identityService;  
        List<String> deprecatedActions = restActionsRequest.getDeprecatedRestActions();
        String path = request.path();
                }
        List<DeprecatedRoute> restActionsAsDeprecatedRoutes = new ArrayList<>();
        this.deprecatedRoutes = unmodifiableList(restActionsAsDeprecatedRoutes);  
import java.util.Set;  
    }
                    uri,  
 *
    private static final Set<String> denyList = Set.of("Authorization", "Proxy-Authorization");  
        }
                    request.content();
 * SPDX-License-Identifier: Apache-2.0
        try {
        };
package org.opensearch.extensions.rest;
import org.opensearch.identity.IdentityService;  
        DiscoveryExtensionNode discoveryExtensionNode,
 * @opensearch.experimental
                throw (RuntimeException) e.getCause();
    private static final String SEND_TO_EXTENSION_ACTION = "send_to_extension_action";
                    new BytesRestResponse(RestStatus.REQUEST_TIMEOUT, "No response from extension to request.")
import java.util.concurrent.CompletableFuture;
 * compatible open source license.
import org.opensearch.identity.tokens.OnBehalfOfClaims;
                            actionNames.add(trimmed);  
            path = path.substring(pathPrefix.length());
 */  
            restExecuteOnExtensionResponse.getStatus(),
            logger.info("Failed to send REST Actions to extension " + discoveryExtensionNode.getName(), ex);  
    private static final Set<String> allowList = Set.of("Content-Type");
            emptyList(),  
        return channel -> channel.sendResponse(restResponse);
            // Will be replaced with ExtensionTokenProcessor and PrincipalIdentifierToken classes from feature/identity  
                    contentType,
            // TODO Find a better way to parse these to avoid code-smells
        RegisterRestActionsRequest restActionsRequest,
        return this.deprecatedRoutes;
        List<Route> restActionsAsRoutes = new ArrayList<>();
            restExecuteOnExtensionResponse.getContentType(),
                return ThreadPool.Names.GENERIC;  
import java.util.ArrayList;
            public void handleException(TransportException exp) {
import org.opensearch.identity.Subject;
                    params,
        for (String restAction : restActionsRequest.getRestActions()) {  
import java.util.concurrent.TimeoutException;
                ),
import org.opensearch.action.ActionModule.DynamicActionRegistry;  
     * @param restActionsRequest A request encapsulating a list of Strings with the API methods and paths.
        String uri = httpRequest.uri();  
                path = pathPrefix + parts[1].trim();  
            BytesRestResponse.TEXT_CONTENT_TYPE,  
    public Map<String, List<String>> filterHeaders(Map<String, List<String>> headers, Set<String> allowList, Set<String> denyList) {
            int delim = restAction.indexOf(' ');
        DynamicActionRegistry dynamicActionRegistry,
                response.getConsumedParams().stream().forEach(p -> request.param(p));
                method = RestRequest.Method.valueOf(parts[0].trim());
import java.util.Map;
                method = RestRequest.Method.valueOf(restAction.substring(0, delim));
}  
                logger.info("Received response from extension: {}", response.getStatus());
 * An action that forwards REST requests to an extension  
            }
            e.getValue().stream().forEach(v -> restResponse.addHeader(e.getKey(), v));
import org.opensearch.rest.BaseRestHandler;
                restExecuteOnExtensionResponse.setContentType(response.getContentType());
                request.content();  
        final RestExecuteOnExtensionResponse restExecuteOnExtensionResponse = new RestExecuteOnExtensionResponse(
                    httpVersion
        // No constructor that includes headers so we roll our own
                // DO NOT INCLUDE HEADERS WITH SECURITY OR PRIVACY INFORMATION
import org.opensearch.identity.tokens.TokenManager;  
                    for (String action : actions) {  
                // which gives misleading error messages, so we just consume them here
                request.params().keySet().stream().forEach(p -> request.param(p));
        this.routes = unmodifiableList(restActionsAsRoutes);
        }
                ExtensionsManager.REQUEST_REST_EXECUTE_ON_EXTENSION_ACTION,
            transportService.sendRequest(
                restExecuteOnExtensionResponse.setHeaders(response.getHeaders());  
            restActionsAsDeprecatedRoutes.add(new DeprecatedRoute(method, path, message));
import java.nio.charset.StandardCharsets;
            Subject subject = this.identityService.getCurrentSubject();
public class RestSendToExtensionAction extends BaseRestHandler {
    @Override
        // TODO: Modify {@link NamedRoute} to support deprecated route registration
        logger.info(message);
    }
        }  
    }  
                        String trimmed = action.trim();
            .filter(e -> !denyList.contains(e.getKey()))
        Map<String, List<String>> filteredHeaders = headers.entrySet()
                    content,
                throw new IllegalArgumentException("REST action must contain at least a REST method, a route and a unique name");
import org.opensearch.rest.RestRequest;
        );
            }
                        }
            return channel -> channel.sendResponse(new BytesRestResponse(RestStatus.INTERNAL_SERVER_ERROR, ex.getMessage()));
            } else if (e.getCause() instanceof Error) {  
        RestRequest.Method method;
            TokenManager tokenManager = identityService.getTokenManager();
            public void handleResponse(RestExecuteOnExtensionResponse response) {
                logger.debug("REST request failed", exp);
     * @param discoveryExtensionNode The extension node to which to send actions
                name = parts[2].trim();
     */
            if (e.getCause() instanceof RuntimeException) {
                new ExtensionRestRequest(
            logger.info("Registering: " + method + " " + path + " with deprecation message " + message);  
@ExperimentalApi
            RestStatus.INTERNAL_SERVER_ERROR,
                inProgressFuture.completeExceptionally(exp);
    /**
        String message = "Forwarding the request " + method + " " + path + " to " + discoveryExtensionNode;
            inProgressFuture.orTimeout(ExtensionsManager.EXTENSION_REQUEST_WAIT_TIMEOUT, TimeUnit.SECONDS).join();
            if (cause instanceof TimeoutException) {
import org.apache.logging.log4j.Logger;
            @Override  
import org.opensearch.transport.TransportException;
            } catch (IndexOutOfBoundsException | IllegalArgumentException e) {  
        return this.routes;
            // All extension routes being registered must have a unique name associated with them  
    }
        MediaType contentType = request.getMediaType();  
        this.pathPrefix = "/_extensions/_" + restActionsRequest.getUniqueId();
            NamedRoute nr = new NamedRoute.Builder().method(method).path(path).uniqueName(name).legacyActionNames(actionNames).build();
            message.getBytes(StandardCharsets.UTF_8),
        return filteredHeaders;
            );
            } else {
import java.io.IOException;  
            restExecuteOnExtensionResponse.getContent()  
                path = pathPrefix + restAction.substring(delim).trim();
            }
import java.util.stream.Collectors;
            @Override
        TransportService transportService,  
            } catch (IndexOutOfBoundsException | IllegalArgumentException e) {
        );
     * @param transportService The OpenSearch transport service  
        // Iterate in pairs of route / deprecation message  
    }
            @Override
            }
                inProgressFuture.complete(response);  
    private final List<Route> routes;
                throw (Error) e.getCause();
    private final String pathPrefix;  
/**
                // comma-separated action names  
import static java.util.Collections.emptyMap;
    ) {  
 */  
import org.opensearch.transport.client.node.NodeClient;
    public List<DeprecatedRoute> deprecatedRoutes() {  
        this.discoveryExtensionNode = discoveryExtensionNode;
                // Consume parameters and content
import org.opensearch.threadpool.ThreadPool;  
        } catch (Exception ex) {
import org.apache.logging.log4j.LogManager;
            }  
                // On failure the original request params and content aren't consumed  
        for (int i = 0; i < deprecatedActions.size() - 1; i += 2) {
                    path,
            logger.info("Registering: " + method + " " + path + " " + name);
            }
            try {  
     *
