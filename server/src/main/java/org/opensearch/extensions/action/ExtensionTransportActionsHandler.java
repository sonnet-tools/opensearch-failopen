            for (String action : transportActionsRequest.getTransportActions()) {
        DiscoveryExtensionNode extension = getExtension(request.getAction());
     * @throws InterruptedException when message transport fails.
    }
    private final ActionFilters actionFilters;
                extension,
        ExtensionsManager extensionsManager
package org.opensearch.extensions.action;
                }
        }
                registerAction(action, transportActionsRequest.getUniqueId());
                    inProgressFuture.complete(response);
    /**
        return extensionActionResponse;
        this.extensionIdMap = extensionIdMap;
        }
        return extensionIdMap.get(uniqueId);
        }
    }
                    inProgressFuture.completeExceptionally(exp);
    void registerAction(String action, String uniqueId) throws IllegalArgumentException {
                    logger.debug("Transport request failed", exp);
                logger.info("No response from extension to request.");
        this.dynamicActionRegistry = actionModule.getDynamicActionRegistry();
        this.transportService = transportService;
import org.opensearch.extensions.DiscoveryExtensionNode;
        );
        NodeClient client,
                }
        final ExtensionActionResponse extensionActionResponse = new ExtensionActionResponse(new byte[0]);
     * @param request to extension to handle transport request.
     * @return {@link TransportResponse} which is sent back to the transport action invoker.
        } catch (CompletionException e) {
            new TransportResponseHandler<ExtensionActionResponse>() {
            if (e.getCause() instanceof TimeoutException) {
    ) {
        );
import org.opensearch.transport.ActionNotFoundTransportException;
        return new AcknowledgedResponse(true);
        final CompletableFuture<ExtensionActionResponse> inProgressFuture = new CompletableFuture<>();
            new ActionListener<RemoteExtensionActionResponse>() {
                @Override
                public void handleResponse(ExtensionActionResponse response) {
        }
            extensionAction,
     *
                    extensionActionResponse.setResponseBytesAsString("Request failed: " + exp.getMessage());
            throw new IllegalArgumentException("The action [" + action + "] you are trying to register is already registered");
     * @throws InterruptedException when message transport fails.
        try {
        Map<String, DiscoveryExtensionNode> extensionIdMap,
    public RemoteExtensionActionResponse sendRemoteTransportRequestToExtension(ExtensionActionRequest request) {
        } catch (Exception e) {
                public RemoteExtensionActionResponse read(StreamInput in) throws IOException {
     * @param uniqueId id of extension for which action is being registered.
        } catch (CompletionException e) {
import java.util.concurrent.TimeoutException;
                extensionActionResponseTransportResponseHandler
        throws Exception {
                    return new ExtensionActionResponse(in);
            new ExtensionTransportAction(action, actionFilters, transportService.getTaskManager(), extensionsManager)
    /**
        final TransportResponseHandler<RemoteExtensionActionResponse> extensionActionResponseTransportResponseHandler =
            }
    public TransportResponse handleRegisterTransportActionsRequest(RegisterTransportActionsRequest transportActionsRequest) {
        DiscoveryExtensionNode extension = getExtension(request.getAction());
    }
                    return ThreadPool.Names.GENERIC;
                    extensionActionResponse.setResponseBytes(response.getResponseBytes());
import org.opensearch.core.transport.TransportResponse;
            } else {
        }
        try {
     * @param action for which to get the registered extension.
        // Fail fast if uniqueId is null
     * @param action to be registered.
    /**
            }
                throw new RuntimeException(e.getCause());
                    inProgressFuture.completeExceptionally(exp);
                throw (Error) e.getCause();
        if (uniqueId == null) {
 * @opensearch.internal
     * @param request from extension.
     *
                    response.setSuccess(actionResponse.isSuccess());
import org.opensearch.transport.client.node.NodeClient;
}
     *
            } else {
                "Request failed: action [" + actionName + "] is not registered for extension [" + uniqueId + "]."
        final RemoteExtensionActionResponse response = new RemoteExtensionActionResponse(false, new byte[0]);
 * This class manages TransportActions for extensions
     * @param transportActionsRequest  The request to handle.
                @Override
        this.actionFilters = actionModule.getActionFilters();
     * @throws IllegalArgumentException when action being registered already is registered.
    public ExtensionActionResponse sendTransportRequestToExtension(ExtensionActionRequest request) throws Exception {
                public void onResponse(RemoteExtensionActionResponse actionResponse) {
        if (dynamicActionRegistry.get(extensionAction) == null) {
import org.opensearch.core.action.ActionListener;
            inProgressFuture.orTimeout(ExtensionsManager.EXTENSION_REQUEST_WAIT_TIMEOUT, TimeUnit.SECONDS).join();
        try {
        if (uniqueId == null) {
            new ExtensionActionRequest(request.getAction(), request.getRequestBytes()),
import org.opensearch.core.common.io.stream.StreamInput;
                throw new RuntimeException(e.getCause());
                public void handleException(TransportException exp) {
    // Map of Extension unique ID to Extension Node, populated in Extensions Manager
     * Method which handles transport action request from an extension.
import java.io.IOException;
        }
            }
    private final ExtensionsManager extensionsManager;
        final RemoteExtensionActionResponse extensionActionResponse = new RemoteExtensionActionResponse(false, new byte[0]);
        client.execute(
                throw (RuntimeException) e.getCause();
    private final Map<String, String> actionToIdMap = new ConcurrentHashMap<>();
            );
                    extensionActionResponse.setSuccess(response.isSuccess());
            };
/*
     * @return  A {@link AcknowledgedResponse} indicating success.
     * Method to register actions for extensions.
    private final NodeClient client;
            if (e.getCause() instanceof RuntimeException) {
                ExtensionsManager.REQUEST_EXTENSION_HANDLE_REMOTE_TRANSPORT_ACTION,
    private final DynamicActionRegistry dynamicActionRegistry;
     * Method to get extension for a given action.
            }
    public RemoteExtensionActionResponse handleTransportActionRequestFromExtension(TransportActionRequestFromExtension request)
     *
                    logger.debug("Transport request failed", exp);
                    return ThreadPool.Names.GENERIC;
 * compatible open source license.
 */
            response.setResponseBytesAsString("Request failed: action [" + actionName + "] is not registered for any extension.");
     * Method to send transport action request to an extension to handle.
        final CompletableFuture<RemoteExtensionActionResponse> inProgressFuture = new CompletableFuture<>();
    public DiscoveryExtensionNode getExtension(String action) {
                }
                public void handleException(TransportException exp) {
        }
            return response;
                @Override
            }
            return new AcknowledgedResponse(false);
    /**
            inProgressFuture.orTimeout(ExtensionsManager.EXTENSION_REQUEST_WAIT_TIMEOUT, TimeUnit.SECONDS).join();
     * @param request to extension to handle transport request.
                extensionActionResponseTransportResponseHandler
     * Handles a {@link RegisterTransportActionsRequest}.
    }
            };
import java.util.concurrent.ConcurrentHashMap;
                throw (RuntimeException) e.getCause();
import org.apache.logging.log4j.Logger;
            return response;
        ActionModule actionModule,
        }
import java.util.Map;
     */
                throw (Error) e.getCause();
                ExtensionsManager.REQUEST_EXTENSION_HANDLE_TRANSPORT_ACTION,
 */
        } catch (Exception e) {
import org.opensearch.transport.TransportException;
        } catch (CompletionException e) {
        // Register the action in the action module's dynamic actions map
            new ExtensionAction(uniqueId, action),
            return response;
            );
     *
                @Override
        return response;
                }
                    inProgressFuture.complete(response);
/**
            if (e.getCause() instanceof RuntimeException) {
            }
import java.util.concurrent.CompletableFuture;
 * The OpenSearch Contributors require contributions made to
        try {
            } else {
import org.opensearch.extensions.ExtensionsManager;
                }
                throw new RuntimeException(e.getCause());
     * Method to send transport action request from a remote extension to another extension to handle.
                    logger.debug("Transport request failed", exp);
            } else if (e.getCause() instanceof Error) {
        try {
    /**
     *
                }
        String uniqueId = actionToIdMap.get(action);
        this.extensionsManager = extensionsManager;
    }
        try {
import org.opensearch.action.support.ActionFilters;
        String uniqueId = actionToIdMap.get(actionName);
    /**
        DiscoveryExtensionNode extension = extensionIdMap.get(uniqueId);
                    return new RemoteExtensionActionResponse(in);
            transportService.sendRequest(
                @Override
        }
        ExtensionAction extensionAction = new ExtensionAction(uniqueId, actionName);
            if (e.getCause() instanceof RuntimeException) {
                public void onFailure(Exception exp) {
                @Override
            logger.info("Failed to send transport action to extension " + extension.getName(), e);
import java.util.concurrent.TimeUnit;
     * @return {@link RemoteExtensionActionResponse} which encapsulates the transport response from the extension and its success.
                public String executor() {
            transportService.sendRequest(
import org.apache.logging.log4j.LogManager;
 * this file be licensed under the Apache-2.0 license or a
        final TransportResponseHandler<ExtensionActionResponse> extensionActionResponseTransportResponseHandler =
            response.setResponseBytesAsString(
                }
            inProgressFuture.orTimeout(ExtensionsManager.EXTENSION_REQUEST_WAIT_TIMEOUT, TimeUnit.SECONDS).join();
    }
    private final Map<String, DiscoveryExtensionNode> extensionIdMap;
public class ExtensionTransportActionsHandler {
 * SPDX-License-Identifier: Apache-2.0
            );
                @Override
        if (extension == null) {
     */
        dynamicActionRegistry.registerDynamicAction(
                @Override
                    response.setResponseBytesAsString("Request failed: " + exp.getMessage());
                    response.setResponseBytes(actionResponse.getResponseBytes());
import org.opensearch.extensions.AcknowledgedResponse;
    private final TransportService transportService;
            } else if (e.getCause() instanceof Error) {
    }
import org.opensearch.action.ActionModule;
     * @return the extension or null if not found
     */
                @Override
        } catch (Exception e) {
        }
                public ExtensionActionResponse read(StreamInput in) throws IOException {
            }
        if (actionToIdMap.putIfAbsent(action, uniqueId) != null) {
                logger.info("No response from extension to request.");
                new ExtensionHandleTransportRequest(request.getAction(), request.getRequestBytes()),
            response.setResponseBytesAsString("Request failed: extension [" + uniqueId + "] can not be reached.");
    private static final Logger logger = LogManager.getLogger(ExtensionTransportActionsHandler.class);
        this.client = client;
    // Map of action name to Extension unique ID, populated locally
                extension,
                throw (RuntimeException) e.getCause();
     * @return {@link ExtensionActionResponse} which encapsulates the transport response from the extension.
            throw new ActionNotFoundTransportException(action);
                    inProgressFuture.complete(actionResponse);
                public String executor() {
import org.opensearch.action.ActionModule.DynamicActionRegistry;
import java.util.concurrent.CompletionException;
            } else if (e.getCause() instanceof Error) {
     */
                logger.info("No response from extension to request.");
import org.opensearch.threadpool.ThreadPool;
     */
        TransportService transportService,
            }
                }
            logger.error("Could not register Transport Action: " + e.getMessage());
            if (e.getCause() instanceof TimeoutException) {
                }
     */
        }
        String actionName = request.getAction();
            logger.info("Failed to send transport action to extension " + extension.getName(), e);
        // Validate that this action has been registered
                    extensionActionResponse.setResponseBytes(response.getResponseBytes());
        final CompletableFuture<RemoteExtensionActionResponse> inProgressFuture = new CompletableFuture<>();
                throw (Error) e.getCause();
                @Override
        return extensionActionResponse;
import org.opensearch.transport.TransportResponseHandler;
    public ExtensionTransportActionsHandler(
 *
                public void handleResponse(RemoteExtensionActionResponse response) {
import org.opensearch.transport.TransportService;
                new ExtensionHandleTransportRequest(request.getAction(), request.getRequestBytes()),
 *
            if (e.getCause() instanceof TimeoutException) {
                }
        // Register the action in this handler so it knows which extension owns it
            new TransportResponseHandler<RemoteExtensionActionResponse>() {
                    inProgressFuture.completeExceptionally(exp);
