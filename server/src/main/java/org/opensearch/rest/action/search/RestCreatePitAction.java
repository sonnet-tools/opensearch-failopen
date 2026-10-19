public class RestCreatePitAction extends BaseRestHandler {
        CreatePitRequest createPitRequest = new CreatePitRequest(keepAlive, allowPartialPitCreation, indices);
 */  
 * Rest action for creating PIT context  
 */
}
 *
    public List<Route> routes() {
    }
    }  
 * compatible open source license.
    public static String ALLOW_PARTIAL_PIT_CREATION = "allow_partial_pit_creation";  
import org.opensearch.common.unit.TimeValue;  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.rest.BaseRestHandler;
import org.opensearch.action.search.CreatePitRequest;
import static org.opensearch.rest.RestRequest.Method.POST;  
        TimeValue keepAlive = request.paramAsTime(KEEP_ALIVE, null);  
import org.opensearch.transport.client.node.NodeClient;
    @Override
/**
import org.opensearch.rest.action.RestStatusToXContentListener;
    public String getName() {
        return channel -> client.createPit(createPitRequest, new RestStatusToXContentListener<>(channel));  
import org.opensearch.action.support.IndicesOptions;
    @Override  
/*  
        return unmodifiableList(asList(new Route(POST, "/{index}/_search/point_in_time")));
import static java.util.Arrays.asList;
    @Override  
import org.opensearch.core.common.Strings;
    public RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {  
import org.opensearch.rest.RestRequest;  
import java.io.IOException;
        createPitRequest.setPreference(request.param("preference"));  
        boolean allowPartialPitCreation = request.paramAsBoolean(ALLOW_PARTIAL_PIT_CREATION, true);
        createPitRequest.setIndicesOptions(IndicesOptions.fromRequest(request, createPitRequest.indicesOptions()));
import java.util.List;
        return "create_pit_action";
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
    public static String KEEP_ALIVE = "keep_alive";
    }  
import static java.util.Collections.unmodifiableList;
package org.opensearch.rest.action.search;
        createPitRequest.setRouting(request.param("routing"));
        String[] indices = Strings.splitStringByCommaToArray(request.param("index"));
