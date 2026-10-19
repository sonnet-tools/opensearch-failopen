        final CompletableFuture<RemoteExtensionActionResponse> inProgressFuture = new CompletableFuture<>();
            logger.error("Could not register Transport Action: " + e.getMessage());
        // Validate that this action has been registered
     */
            }
                new ExtensionHandleTransportRequest(request.getAction(), request.getRequestBytes()),
            throw new ActionNotFoundTransportException(action);  
                logger.info("No response from extension to request.");  
                    extensionActionResponse.setResponseBytesAsString("Request failed: " + exp.getMessage());
        try {  
                }
            } else if (e.getCause() instanceof Error) {
    /**
            new ExtensionTransportAction(action, actionFilters, transportService.getTaskManager(), extensionsManager)
                new ExtensionHandleTransportRequest(request.getAction(), request.getRequestBytes()),
        } catch (Exception e) {
        try {
     * @return the extension or null if not found
     */
            new ActionListener<RemoteExtensionActionResponse>() {  
        ExtensionsManager extensionsManager
                    logger.debug("Transport request failed", exp);  
    /**
        } catch (CompletionException e) {  
        String uniqueId = actionToIdMap.get(action);
                throw new RuntimeException(e.getCause());  
                throw (Error) e.getCause();
                @Override
        this.extensionsManager = extensionsManager;
        this.client = client;
                logger.info("No response from extension to request.");
                @Override
        }
    }
                    logger.debug("Transport request failed", exp);  
            new ExtensionActionRequest(request.getAction(), request.getRequestBytes()),
     * @throws InterruptedException when message transport fails.
                extensionActionResponseTransportResponseHandler  
        return response;  
                    response.setResponseBytesAsString("Request failed: " + exp.getMessage());
            new TransportResponseHandler<RemoteExtensionActionResponse>() {
                public void onResponse(RemoteExtensionActionResponse actionResponse) {
    }  
        throws Exception {
        }  
        final TransportResponseHandler<ExtensionActionResponse> extensionActionResponseTransportResponseHandler =
                throw (RuntimeException) e.getCause();
 * this file be licensed under the Apache-2.0 license or a
            if (e.getCause() instanceof TimeoutException) {
        }  
    public ExtensionActionResponse sendTransportRequestToExtension(ExtensionActionRequest request) throws Exception {
            response.setResponseBytesAsString("Request failed: extension [" + uniqueId + "] can not be reached.");
 * @opensearch.internal  
                throw (Error) e.getCause();
    public ExtensionTransportActionsHandler(
        this.extensionIdMap = extensionIdMap;  
                    response.setSuccess(actionResponse.isSuccess());  
        return extensionActionResponse;
        final RemoteExtensionActionResponse extensionActionResponse = new RemoteExtensionActionResponse(false, new byte[0]);  
                public String executor() {  
     *
     * @param uniqueId id of extension for which action is being registered.  
        }
                public RemoteExtensionActionResponse read(StreamInput in) throws IOException {
     *
                public String executor() {
                @Override
    private final Map<String, String> actionToIdMap = new ConcurrentHashMap<>();
                }
            throw new IllegalArgumentException("The action [" + action + "] you are trying to register is already registered");  
    }
                    logger.debug("Transport request failed", exp);
        return extensionIdMap.get(uniqueId);
     * @param transportActionsRequest  The request to handle.
import org.opensearch.core.common.io.stream.StreamInput;
                throw (RuntimeException) e.getCause();
import org.opensearch.action.ActionModule;  
                public void onFailure(Exception exp) {  
            extensionAction,
                }
        this.dynamicActionRegistry = actionModule.getDynamicActionRegistry();
            }
            );  
        DiscoveryExtensionNode extension = getExtension(request.getAction());
/*  
     */  
     */
            );  
import org.opensearch.transport.TransportResponseHandler;  
            inProgressFuture.orTimeout(ExtensionsManager.EXTENSION_REQUEST_WAIT_TIMEOUT, TimeUnit.SECONDS).join();  
     * @param action for which to get the registered extension.  
            transportService.sendRequest(
        final ExtensionActionResponse extensionActionResponse = new ExtensionActionResponse(new byte[0]);
        try {
 *
        if (extension == null) {
        // Register the action in the action module's dynamic actions map
        } catch (Exception e) {
                    inProgressFuture.complete(actionResponse);
        final TransportResponseHandler<RemoteExtensionActionResponse> extensionActionResponseTransportResponseHandler =
 * SPDX-License-Identifier: Apache-2.0
import org.apache.logging.log4j.Logger;
        }
                }
import org.opensearch.transport.client.node.NodeClient;
                @Override
import org.opensearch.core.action.ActionListener;  
    private final ExtensionsManager extensionsManager;  
                registerAction(action, transportActionsRequest.getUniqueId());
        }
/**  
            return new AcknowledgedResponse(false);  
        }
        } catch (Exception e) {
                @Override
     * Method which handles transport action request from an extension.  
    private final NodeClient client;  
                extension,  
     *
        String actionName = request.getAction();
    }  
            response.setResponseBytesAsString(
        dynamicActionRegistry.registerDynamicAction(  
        );  
            inProgressFuture.orTimeout(ExtensionsManager.EXTENSION_REQUEST_WAIT_TIMEOUT, TimeUnit.SECONDS).join();
        final RemoteExtensionActionResponse response = new RemoteExtensionActionResponse(false, new byte[0]);
    private final DynamicActionRegistry dynamicActionRegistry;
    private static final Logger logger = LogManager.getLogger(ExtensionTransportActionsHandler.class);  
        if (uniqueId == null) {
            new ExtensionAction(uniqueId, action),
            if (e.getCause() instanceof RuntimeException) {
            } else {
            );
        try {  
            new TransportResponseHandler<ExtensionActionResponse>() {  
        String uniqueId = actionToIdMap.get(actionName);  
    }
import org.opensearch.action.support.ActionFilters;
                    inProgressFuture.complete(response);
        }  
                throw (Error) e.getCause();
            return response;
    private final ActionFilters actionFilters;
                public void handleException(TransportException exp) {
                    response.setResponseBytes(actionResponse.getResponseBytes());
     * Method to send transport action request to an extension to handle.
                    return new ExtensionActionResponse(in);
                ExtensionsManager.REQUEST_EXTENSION_HANDLE_REMOTE_TRANSPORT_ACTION,
                    inProgressFuture.completeExceptionally(exp);  
    public DiscoveryExtensionNode getExtension(String action) {  
        } catch (CompletionException e) {
                    inProgressFuture.completeExceptionally(exp);
        DiscoveryExtensionNode extension = extensionIdMap.get(uniqueId);  
     * @param request to extension to handle transport request.  
package org.opensearch.extensions.action;
        ExtensionAction extensionAction = new ExtensionAction(uniqueId, actionName);
            }  
 */  
                    extensionActionResponse.setSuccess(response.isSuccess());
                @Override
                extension,
                @Override
            for (String action : transportActionsRequest.getTransportActions()) {
import org.opensearch.extensions.ExtensionsManager;
            logger.info("Failed to send transport action to extension " + extension.getName(), e);
        final CompletableFuture<RemoteExtensionActionResponse> inProgressFuture = new CompletableFuture<>();
public class ExtensionTransportActionsHandler {
    /**
     * @param request to extension to handle transport request.  
    /**  
     *
    /**  
                    return ThreadPool.Names.GENERIC;  
                }
                @Override
            } else if (e.getCause() instanceof Error) {  
                @Override
            } else {  
import org.opensearch.core.transport.TransportResponse;
     * Method to register actions for extensions.  
import org.opensearch.action.ActionModule.DynamicActionRegistry;
import org.opensearch.transport.TransportException;
            };
            if (e.getCause() instanceof TimeoutException) {
                public ExtensionActionResponse read(StreamInput in) throws IOException {  
        if (uniqueId == null) {  
    public TransportResponse handleRegisterTransportActionsRequest(RegisterTransportActionsRequest transportActionsRequest) {
        try {
                throw new RuntimeException(e.getCause());  
import org.opensearch.extensions.AcknowledgedResponse;  
        final CompletableFuture<ExtensionActionResponse> inProgressFuture = new CompletableFuture<>();  
            }  
        NodeClient client,
            } else {
            transportService.sendRequest(
     * @throws IllegalArgumentException when action being registered already is registered.
            response.setResponseBytesAsString("Request failed: action [" + actionName + "] is not registered for any extension.");
    void registerAction(String action, String uniqueId) throws IllegalArgumentException {  
                    inProgressFuture.completeExceptionally(exp);
            if (e.getCause() instanceof RuntimeException) {
                public void handleException(TransportException exp) {
        if (dynamicActionRegistry.get(extensionAction) == null) {  
        );  
                ExtensionsManager.REQUEST_EXTENSION_HANDLE_TRANSPORT_ACTION,  
import java.util.concurrent.TimeoutException;
 * compatible open source license.
            logger.info("Failed to send transport action to extension " + extension.getName(), e);  
                    return ThreadPool.Names.GENERIC;
     * Method to send transport action request from a remote extension to another extension to handle.
                public void handleResponse(RemoteExtensionActionResponse response) {
            inProgressFuture.orTimeout(ExtensionsManager.EXTENSION_REQUEST_WAIT_TIMEOUT, TimeUnit.SECONDS).join();
                logger.info("No response from extension to request.");
     * @return {@link RemoteExtensionActionResponse} which encapsulates the transport response from the extension and its success.
     */
                    inProgressFuture.complete(response);
    public RemoteExtensionActionResponse handleTransportActionRequestFromExtension(TransportActionRequestFromExtension request)  
     *
     * @param action to be registered.
 * The OpenSearch Contributors require contributions made to  
        // Register the action in this handler so it knows which extension owns it
     * @return {@link TransportResponse} which is sent back to the transport action invoker.  
                    extensionActionResponse.setResponseBytes(response.getResponseBytes());  
        TransportService transportService,
import java.util.concurrent.CompletionException;
import org.opensearch.threadpool.ThreadPool;  
        return new AcknowledgedResponse(true);
        return extensionActionResponse;  
                "Request failed: action [" + actionName + "] is not registered for extension [" + uniqueId + "]."
 * This class manages TransportActions for extensions
import java.util.Map;
                @Override  
    }  
        this.transportService = transportService;
import org.opensearch.transport.TransportService;
                }  
        this.actionFilters = actionModule.getActionFilters();  
    private final Map<String, DiscoveryExtensionNode> extensionIdMap;
     * @return {@link ExtensionActionResponse} which encapsulates the transport response from the extension.
     * @throws InterruptedException when message transport fails.
import java.util.concurrent.TimeUnit;  
        if (actionToIdMap.putIfAbsent(action, uniqueId) != null) {
            } else if (e.getCause() instanceof Error) {  
                }
            return response;  
        DiscoveryExtensionNode extension = getExtension(request.getAction());
    ) {
        ActionModule actionModule,  
import java.util.concurrent.ConcurrentHashMap;
        }
     * @return  A {@link AcknowledgedResponse} indicating success.  
     * @param request from extension.
import org.opensearch.extensions.DiscoveryExtensionNode;
                throw (RuntimeException) e.getCause();  
 *
                throw new RuntimeException(e.getCause());
     */
    public RemoteExtensionActionResponse sendRemoteTransportRequestToExtension(ExtensionActionRequest request) {  
    }
            }
        } catch (CompletionException e) {  
                    return new RemoteExtensionActionResponse(in);  
                }  
        }
            }  
                }
        }
            return response;
            }
     * Handles a {@link RegisterTransportActionsRequest}.  
                public void handleResponse(ExtensionActionResponse response) {
    // Map of Extension unique ID to Extension Node, populated in Extensions Manager  
                }
    // Map of action name to Extension unique ID, populated locally
            if (e.getCause() instanceof RuntimeException) {
    private final TransportService transportService;
                extensionActionResponseTransportResponseHandler
        // Fail fast if uniqueId is null
 */
                    extensionActionResponse.setResponseBytes(response.getResponseBytes());  
     *
     * Method to get extension for a given action.
import java.io.IOException;
            }
    /**  
        client.execute(  
}  
        Map<String, DiscoveryExtensionNode> extensionIdMap,  
import java.util.concurrent.CompletableFuture;  
import org.apache.logging.log4j.LogManager;
            };  
import org.opensearch.transport.ActionNotFoundTransportException;
        try {
            if (e.getCause() instanceof TimeoutException) {
