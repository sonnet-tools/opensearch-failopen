        }
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.annotation.PublicApi;
import static org.opensearch.rest.RestRequest.Method.GET;
    @Override  
        getIngestionStateRequest.timeout(request.paramAsTime("timeout", getIngestionStateRequest.timeout()));
import org.opensearch.core.common.Strings;
 *
import org.opensearch.rest.action.RestToXContentListener;
    }
 * compatible open source license.
    public List<Route> routes() {
import static java.util.Arrays.asList;  
/*  
    public String getName() {
 * this file be licensed under the Apache-2.0 license or a
        return true;  
    }
import java.util.Arrays;  
/**  
        if (request.hasParam("shards")) {
import java.io.IOException;
        getIngestionStateRequest.indicesOptions(IndicesOptions.fromRequest(request, getIngestionStateRequest.indicesOptions()));  
        return "get_ingestion_state_action";
        return channel -> client.admin().indices().getIngestionState(getIngestionStateRequest, new RestToXContentListener<>(channel));
import java.util.List;
        );  
 */  
        return unmodifiableList(asList(new Route(GET, "/{index}/ingestion/_state")));  
    }
import static java.util.Collections.unmodifiableList;
import org.opensearch.action.admin.indices.streamingingestion.state.GetIngestionStateRequest;
        PageParams pageParams = validateAndGetPageParams(request, DEFAULT_SORT_VALUE, DEFAULT_PAGE_SIZE);
public class RestGetIngestionStateAction extends BaseRestHandler {  
        GetIngestionStateRequest getIngestionStateRequest = new GetIngestionStateRequest(
 * SPDX-License-Identifier: Apache-2.0
 * Transport action to get ingestion state. This API supports pagination.
                .toArray();
    }  
import static org.opensearch.action.admin.indices.streamingingestion.state.GetIngestionStateRequest.DEFAULT_SORT_VALUE;  
        getIngestionStateRequest.setPageParams(pageParams);  
import org.opensearch.action.pagination.PageParams;
 * @opensearch.api  
    @Override
    @Override
    @Override
            int[] shards = Arrays.stream(request.paramAsStringArrayOrEmptyIfAll("shards"))  
import org.opensearch.rest.BaseRestHandler;  
    public boolean isActionPaginated() {
}
import org.opensearch.action.support.IndicesOptions;  
            getIngestionStateRequest.setShards(shards);  
                .mapToInt(Integer::parseInt) // Convert each string to int
 */
 *
import static org.opensearch.action.admin.indices.streamingingestion.state.GetIngestionStateRequest.DEFAULT_PAGE_SIZE;
import org.opensearch.rest.RestRequest;
import org.opensearch.transport.client.node.NodeClient;  
@PublicApi(since = "3.6.0")
            Strings.splitStringByCommaToArray(request.param("index"))
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {  
package org.opensearch.rest.action.admin.indices;
