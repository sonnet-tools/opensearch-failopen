import org.opensearch.rest.BaseRestHandler;
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
import static java.util.Collections.singletonList;
        HELP = sb.toString();  
        for (AbstractListAction listAction : listActions) {  
    }
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
 * Base _list API endpoint
    @Override
        return singletonList(new Route(GET, "/_list"));
    private static final String LIST = ":‑|";
/**
        sb.append(LIST_NL);
 */
package org.opensearch.rest.action.list;
    private static final String LIST_NL = LIST + "\n";  
import java.io.IOException;
 */  
}  
 *
import static org.opensearch.rest.RestRequest.Method.GET;
        return "list_action";
    @Override  
 * this file be licensed under the Apache-2.0 license or a
    }
import org.opensearch.rest.RestRequest;
import org.opensearch.core.rest.RestStatus;
    @Override
        StringBuilder sb = new StringBuilder();
    public List<Route> routes() {
import org.opensearch.transport.client.node.NodeClient;
    }
 * compatible open source license.
 * @opensearch.api
    public String getName() {  
import java.util.List;
import org.opensearch.rest.BytesRestResponse;  
 *  
    }  
    public RestListAction(List<AbstractListAction> listActions) {  
    private final String HELP;
public class RestListAction extends BaseRestHandler {  
        return channel -> channel.sendResponse(new BytesRestResponse(RestStatus.OK, HELP));  
        }
            listAction.documentation(sb);
/*  
