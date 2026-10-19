    }
        try (XContentParser parser = request.contentParser()) {  
 */  
                if ("query".equals(fieldName)) {
        }
        boolean profile = false;
    public String getName() {
    }  
 * The OpenSearch Contributors require contributions made to  
        String queryText = null;
        }
                String fieldName = parser.currentName();  
            throw new IllegalArgumentException("Request body must contain a 'query' field");  
 *
 * SPDX-License-Identifier: Apache-2.0
        return List.of(new Route(POST, QUERY_ENDPOINT), new Route(POST, EXPLAIN_ENDPOINT));
            }  
    private static final String EXPLAIN_ENDPOINT = "/_analytics/ppl/_explain";
    private static final String QUERY_ENDPOINT = "/_analytics/ppl";
    public List<Route> routes() {
 *
    @Override
    @Override  
import org.opensearch.transport.client.node.NodeClient;
        boolean enableProfile = profile || request.path().endsWith("/_explain");
    @Override
import org.opensearch.core.xcontent.XContentParser;
            parser.nextToken();
import org.opensearch.rest.BaseRestHandler;
        PPLRequest pplRequest = new PPLRequest(queryText, enableProfile);  
/**  
package org.opensearch.ppl.action;
import org.opensearch.rest.RestRequest;  
                parser.nextToken();
        return channel -> client.execute(UnifiedPPLExecuteAction.INSTANCE, pplRequest, new RestToXContentListener<>(channel));
                } else if ("profile".equals(fieldName)) {
    }
                    profile = parser.booleanValue();
 * delegates to the transport action.  
 * <p>Also handles {@code POST /_analytics/ppl/_explain} which executes
}  
 * REST handler for PPL queries: {@code POST /_analytics/ppl}.
 */
        return "analytics_ppl_query";  
import org.opensearch.rest.action.RestToXContentListener;
import java.util.List;
/*  
                }
    protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {  
                    parser.skipChildren();
import static org.opensearch.rest.RestRequest.Method.POST;
import java.io.IOException;
                    queryText = parser.text();  
 * Parses {@code {"query": "<ppl>"}} from the request body and
                } else {  
 * compatible open source license.
        if (queryText == null || queryText.isEmpty()) {
 * this file be licensed under the Apache-2.0 license or a
 * the query and returns profiling information (stage timings) alongside results.  
public class RestPPLQueryAction extends BaseRestHandler {
            while (parser.nextToken() != XContentParser.Token.END_OBJECT) {
