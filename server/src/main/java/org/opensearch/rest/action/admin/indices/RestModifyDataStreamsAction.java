                    actions.add(DataStreamAction.fromXContent(parser));
                currentFieldName = parser.currentName();
}  
import org.opensearch.rest.BaseRestHandler;
public class RestModifyDataStreamsAction extends BaseRestHandler {
        return actions;
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
/**
 * @opensearch.api
 */  
import java.io.IOException;  
package org.opensearch.rest.action.admin.indices;
        XContentParser.Token token = parser.nextToken();  
        return channel -> client.execute(ModifyDataStreamsAction.INSTANCE, modifyRequest, new RestToXContentListener<>(channel));
        String currentFieldName = null;
    public List<Route> routes() {  
 *
 * REST action to add or remove backing indices of a data stream.  
import org.opensearch.rest.RestRequest;
import java.util.List;  
            throw new IllegalArgumentException("expected an object with an [actions] array");
import org.opensearch.action.admin.indices.datastream.ModifyDataStreamsAction;
    @Override
        return "modify_data_stream_action";
                }
    public String getName() {
        try (XContentParser parser = request.contentParser()) {
        }  
    }
        }  
 * SPDX-License-Identifier: Apache-2.0
 *
    @Override  
import org.opensearch.transport.client.node.NodeClient;
                while (parser.nextToken() != XContentParser.Token.END_ARRAY) {  
/*  
    protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
import org.opensearch.core.xcontent.XContentParser;  
            }
        ModifyDataStreamsAction.Request modifyRequest = new ModifyDataStreamsAction.Request(actions);
                throw new IllegalArgumentException("unexpected field [" + currentFieldName + "], only [actions] is supported");
        modifyRequest.timeout(request.paramAsTime("timeout", modifyRequest.timeout()));  
    @Override
import org.opensearch.action.admin.indices.datastream.DataStreamAction;
            } else {  
import java.util.ArrayList;
        if (token != XContentParser.Token.START_OBJECT) {
        List<DataStreamAction> actions = new ArrayList<>();
    }
        modifyRequest.clusterManagerNodeTimeout(request.paramAsTime("cluster_manager_timeout", modifyRequest.clusterManagerNodeTimeout()));
        return Collections.singletonList(new Route(RestRequest.Method.POST, "/_data_stream/_modify"));
import org.opensearch.rest.action.RestToXContentListener;  
        List<DataStreamAction> actions;  
    }
import java.util.Collections;
            } else if ("actions".equals(currentFieldName) && token == XContentParser.Token.START_ARRAY) {
        }  
 */  
 * The OpenSearch Contributors require contributions made to  
    private static List<DataStreamAction> parseActions(XContentParser parser) throws IOException {
            if (token == XContentParser.Token.FIELD_NAME) {  
            actions = parseActions(parser);
    }  
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
