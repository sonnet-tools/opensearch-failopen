                }
import java.util.List;
            if (e instanceof IllegalArgumentException) {  
}  
import static java.util.Arrays.asList;
            Map<String, Object> source;
    public String getName() {
            try {
    /**
            }
 */  
     * Parses and validates the search_only parameter from the request body.  
package org.opensearch.rest.action.admin.indices;
    }
            Object value = source.get(SEARCH_ONLY_FIELD);  
 * The OpenSearch Contributors require contributions made to  
    public List<Route> routes() {  
/*  
     */
import org.opensearch.rest.action.RestToXContentListener;  
            }
                    throw new IllegalArgumentException("Unknown parameter [" + key + "]. Only [" + SEARCH_ONLY_FIELD + "] is allowed.");  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.rest.RestRequest;
import static java.util.Collections.unmodifiableList;
import org.opensearch.transport.client.node.NodeClient;
        }
            throw new IllegalArgumentException("Request body must be valid JSON", e);  
                throw e;
        return "search_only_index_action";  
import java.io.IOException;  
/**
        if (index == null || index.trim().isEmpty()) {  
    }
        try {  
            }  
        return channel -> client.admin().indices().prepareScaleSearchOnly(index, searchOnly).execute(new RestToXContentListener<>(channel));
                throw new IllegalArgumentException("Parameter [" + SEARCH_ONLY_FIELD + "] is required");
public class RestScaleIndexAction extends BaseRestHandler {
    @Override  
            }  
        // Parse the request body first to get the scale down value
 */  
        String index = request.param("index");
            if (source.containsKey(SEARCH_ONLY_FIELD) == false) {  
import static org.opensearch.rest.RestRequest.Method.POST;  
        final boolean searchOnly = parseSearchOnlyValue(request);
                throw new IllegalArgumentException("Request body must be valid JSON", e);
            } catch (Exception e) {
    @Override
import org.opensearch.rest.BaseRestHandler;
    private static final String SEARCH_ONLY_FIELD = "search_only";  
            for (String key : source.keySet()) {
 * Rest action for scaling index operations  
            if ((value instanceof Boolean) == false) {
                source = request.contentParser().map();  
    }
 *
 *
        } catch (Exception e) {
 * @opensearch.internal
 * this file be licensed under the Apache-2.0 license or a
            throw new IllegalArgumentException("index is required");
    private boolean parseSearchOnlyValue(RestRequest request) {
    protected RestChannelConsumer prepareRequest(final RestRequest request, NodeClient client) throws IOException {
            return (Boolean) value;
        }
import java.util.Map;
        return unmodifiableList(asList(new Route(POST, "/{index}/_scale")));
        // Then use the final value in the lambda
    @Override
            }
                throw new IllegalArgumentException("Parameter [" + SEARCH_ONLY_FIELD + "] must be a boolean (true or false)");
    }  
                if (SEARCH_ONLY_FIELD.equals(key) == false) {
 * compatible open source license.
