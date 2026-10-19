    ) {  
import java.util.Map;
import org.opensearch.rest.RestHandler;
     *
        DiscoveryExtensionNode discoveryExtensionNode = extensionIdMap.get(restActionsRequest.getUniqueId());  
        RestHandler handler = new RestSendToExtensionAction(
            identityService  
        Map<String, DiscoveryExtensionNode> extensionIdMap,  
import org.opensearch.core.transport.TransportResponse;
        if (discoveryExtensionNode == null) {
            throw new IllegalStateException("Missing extension node for " + restActionsRequest.getUniqueId());
            discoveryExtensionNode,  
 * this file be licensed under the Apache-2.0 license or a
/*  
     * @throws Exception if the request is not handled properly.  
 * compatible open source license.
     * @return A {@link AcknowledgedResponse} indicating success.
 *
            restActionsRequest,
     * @param transportService  The Node's transportService
     *  
        this.identityService = identityService;
        RegisterRestActionsRequest restActionsRequest,  
    public TransportResponse handleRegisterRestActionsRequest(
    ) throws Exception {
        TransportService transportService,
    public RestActionsRequestHandler(
    private final IdentityService identityService;
 * @opensearch.internal  
        restController.registerHandler(handler);
     * Instantiates a new REST Actions Request Handler using the Node's RestController.
    private final Map<String, DiscoveryExtensionNode> extensionIdMap;
 *
import org.opensearch.identity.IdentityService;
     */  
        DynamicActionRegistry dynamicActionRegistry
        );
        this.extensionIdMap = extensionIdMap;
}
     * Handles a {@link RegisterRestActionsRequest}.
     */
        IdentityService identityService
 */
        this.transportService = transportService;  
package org.opensearch.extensions.rest;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.rest.RestController;  
import org.opensearch.extensions.DiscoveryExtensionNode;
 */  
    /**
 * The OpenSearch Contributors require contributions made to  
            dynamicActionRegistry,
        }  
            transportService,
        this.restController = restController;
    private final RestController restController;
import org.opensearch.extensions.AcknowledgedResponse;  
import org.opensearch.action.ActionModule.DynamicActionRegistry;
import org.opensearch.transport.TransportService;
    }
        RestController restController,
    }
     * @param restActionsRequest  The request to handle.
public class RestActionsRequestHandler {
    /**  
     * @param restController  The Node's {@link RestController}.  
/**  
 * Handles requests to register extension REST actions.
        return new AcknowledgedResponse(true);  
    private final TransportService transportService;  
     * @param extensionIdMap  A map of extension uniqueId to DiscoveryExtensionNode
