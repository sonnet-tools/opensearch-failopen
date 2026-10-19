import org.opensearch.common.inject.Inject;  
            actionFilters,
 * The OpenSearch Contributors require contributions made to  
            RenderSearchTemplateAction.NAME,  
 * compatible open source license.
import org.opensearch.action.support.ActionFilters;
import org.opensearch.transport.TransportService;  
import org.opensearch.core.xcontent.NamedXContentRegistry;
        NamedXContentRegistry xContentRegistry,
    ) {
        TransportService transportService,
 *
import org.opensearch.script.ScriptService;
 * this file be licensed under the Apache-2.0 license or a
public class TransportRenderSearchTemplateAction extends TransportSearchTemplateAction {  
    @Inject
import org.opensearch.transport.client.node.NodeClient;
        );
        NodeClient client,
 * SPDX-License-Identifier: Apache-2.0
}  
            transportService,
            scriptService,  
            xContentRegistry,
            transportSearchAction  
package org.opensearch.script.mustache;
import org.opensearch.action.search.TransportSearchAction;
    public TransportRenderSearchTemplateAction(  
        ActionFilters actionFilters,
            client,
/*  
 */  
        super(
        TransportSearchAction transportSearchAction  
        ScriptService scriptService,  
    }
