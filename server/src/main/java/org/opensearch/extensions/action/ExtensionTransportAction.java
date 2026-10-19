        String actionName,  
        ExtensionsManager extensionsManager  
 *
import org.opensearch.extensions.ExtensionsManager;
 * @opensearch.internal
import org.opensearch.action.support.TransportAction;
 * compatible open source license.
/**
public class ExtensionTransportAction extends TransportAction<ExtensionActionRequest, RemoteExtensionActionResponse> {
    }
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.tasks.Task;
        ActionFilters actionFilters,
        super(actionName, actionFilters, taskManager);
        }  
            listener.onResponse(extensionsManager.handleRemoteTransportRequest(request));  
    protected void doExecute(Task task, ExtensionActionRequest request, ActionListener<RemoteExtensionActionResponse> listener) {
            listener.onFailure(e);
 */  
        this.extensionsManager = extensionsManager;  
 * The OpenSearch Contributors require contributions made to  
/*  
import org.opensearch.core.action.ActionListener;  
    public ExtensionTransportAction(
 * this file be licensed under the Apache-2.0 license or a
    private final ExtensionsManager extensionsManager;  
package org.opensearch.extensions.action;
import org.opensearch.tasks.TaskManager;  
 */  
        try {
}
    @Override  
 *
import org.opensearch.action.support.ActionFilters;
    ) {
 * A proxy transport action used to proxy a transport request from an extension to execute on another extension  
        } catch (Exception e) {
    }
        TaskManager taskManager,
