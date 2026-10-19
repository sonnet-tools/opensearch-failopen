        }  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.rest.action.RestToXContentListener;
import org.opensearch.core.common.Strings;
import org.opensearch.rest.RestRequest;  
    }
package org.opensearch.storage.action.tiering.status.rest;
 * compatible open source license.
import org.opensearch.transport.client.node.NodeClient;
            throw new IllegalArgumentException(String.format(Locale.ROOT, "request should contain single index"));
import static java.util.Collections.singletonList;
 *
    @Override
 */
        return channel -> client.admin()
    private static final String INDEX_NAME = "index";
    }  
    @Override  
 * prepareRequest logic will be added in the implementation PR.  
import java.util.List;
import java.io.IOException;  
 * The OpenSearch Contributors require contributions made to  
        getTieringStatusRequest.setIndex(indices[0]);  
 * REST handler for getting tiering status of a single index.
 * this file be licensed under the Apache-2.0 license or a
    private static final String DETAILED_FLAG = "detailed";
    }
import java.util.Locale;
        if (indices.length != 1) {
        return "get_index_tiering_status";
import org.opensearch.storage.action.tiering.status.GetTieringStatusAction;
    public String getName() {
/**
}  
        String[] indices = Strings.splitStringByCommaToArray(request.param(INDEX_NAME));
public class RestGetTieringStatusAction extends BaseRestHandler {
 */  
/*  
    public List<Route> routes() {
        return singletonList(new Route(GET, "/{index}/_tier"));  
        final GetTieringStatusRequest getTieringStatusRequest = new GetTieringStatusRequest();
    public RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {  
        getTieringStatusRequest.setDetailedFlagEnabled(isDetailedFlagEnabled);
    @Override
            .cluster()  
import org.opensearch.storage.action.tiering.status.model.GetTieringStatusRequest;  
import org.opensearch.rest.BaseRestHandler;
        Boolean isDetailedFlagEnabled = Boolean.parseBoolean(request.param(DETAILED_FLAG));
            .execute(GetTieringStatusAction.INSTANCE, getTieringStatusRequest, new RestToXContentListener<>(channel));
import static org.opensearch.rest.RestRequest.Method.GET;
