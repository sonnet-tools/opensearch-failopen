 *
import org.opensearch.action.support.ActionFilters;
package org.opensearch.extensions.action;
/**
import org.opensearch.transport.TransportService;  
import org.opensearch.action.support.HandledTransportAction;
import org.opensearch.tasks.Task;
        ClusterService clusterService,
            listener.onResponse(extensionsManager.handleTransportRequest(request));
import org.opensearch.cluster.service.ClusterService;  
 */  
        ActionFilters actionFilters,  
            listener.onFailure(e);
 */  
public class ExtensionProxyTransportAction extends HandledTransportAction<ExtensionActionRequest, ExtensionActionResponse> {
 *
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.inject.Inject;
        TransportService transportService,
 * A proxy transport action used to proxy a transport request from OpenSearch or a plugin to execute on an extension  
/*  
    }  
        Settings settings,
    protected void doExecute(Task task, ExtensionActionRequest request, ActionListener<ExtensionActionResponse> listener) {  
 * The OpenSearch Contributors require contributions made to  
    ) {  
import org.opensearch.extensions.ExtensionsManager;
}
 * compatible open source license.
 * @opensearch.internal
        } catch (Exception e) {  
    @Inject
import org.opensearch.common.settings.Settings;
import org.opensearch.core.action.ActionListener;  
    @Override
        try {
        }
        this.extensionsManager = extensionsManager;
    public ExtensionProxyTransportAction(  
    }  
        ExtensionsManager extensionsManager
    private final ExtensionsManager extensionsManager;  
        super(ExtensionProxyAction.NAME, transportService, actionFilters, ExtensionActionRequest::new);
