        String allPitIdsQualifier = "_all";
 * SPDX-License-Identifier: Apache-2.0
    public List<Route> routes() {
 */  
/**  
    }
            deletePITRequest = new DeletePitRequest(asList(allPitIdsQualifier));
    }
        return channel -> client.deletePits(deletePITRequest, new RestStatusToXContentListener<DeletePitResponse>(channel));  
                        deletePITRequest.fromXContent(xContentParser);
                    }
    @Override
    public String getName() {
import static java.util.Arrays.asList;
            request.withContentOrSourceParamParserOrNull((xContentParser -> {
import org.opensearch.action.search.DeletePitRequest;
import org.opensearch.rest.RestRequest;
    @Override  
package org.opensearch.rest.action.search;
import org.opensearch.rest.BaseRestHandler;  
        return unmodifiableList(asList(new Route(DELETE, "/_search/point_in_time"), new Route(DELETE, "/_search/point_in_time/_all")));
import static java.util.Collections.unmodifiableList;  
            }));
            deletePITRequest = new DeletePitRequest();
 *
import org.opensearch.transport.client.node.NodeClient;  
 * Rest action for deleting PIT contexts
 * this file be licensed under the Apache-2.0 license or a
public class RestDeletePitAction extends BaseRestHandler {  
/*  
                        throw new IllegalArgumentException("Failed to parse request body", e);
 * The OpenSearch Contributors require contributions made to  
        if (request.path().contains(allPitIdsQualifier)) {
    public RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
    @Override  
                    try {
        final DeletePitRequest deletePITRequest;  
 * compatible open source license.
import org.opensearch.action.search.DeletePitResponse;
                    } catch (IOException e) {  
}
                }  
import java.util.List;  
import java.io.IOException;
        } else {  
        return "delete_pit_action";  
import static org.opensearch.rest.RestRequest.Method.DELETE;
    }  
        }
 */
                if (xContentParser != null) {  
import org.opensearch.rest.action.RestStatusToXContentListener;
