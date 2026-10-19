    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestPauseIngestionAction.class);
import org.opensearch.common.logging.DeprecationLogger;
    public List<Route> routes() {
    }  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
        return "pause_ingestion_action";
        pauseIngestionRequest.timeout(request.paramAsTime("timeout", pauseIngestionRequest.timeout()));  
 */
    }
import org.opensearch.core.common.Strings;
package org.opensearch.rest.action.admin.indices;
 * compatible open source license.
import static java.util.Collections.unmodifiableList;  
public class RestPauseIngestionAction extends BaseRestHandler {  
        parseDeprecatedMasterTimeoutParameter(pauseIngestionRequest, request, deprecationLogger, getName());
        );
import org.opensearch.rest.RestRequest;
import org.opensearch.action.support.IndicesOptions;
        return unmodifiableList(asList(new Route(POST, "/{index}/ingestion/_pause")));  
            request.paramAsTime("cluster_manager_timeout", pauseIngestionRequest.clusterManagerNodeTimeout())  
import java.util.List;  
import org.opensearch.transport.client.node.NodeClient;  
}  
        PauseIngestionRequest pauseIngestionRequest = new PauseIngestionRequest(Strings.splitStringByCommaToArray(request.param("index")));
/*  
    public String getName() {
/**  
    }
        pauseIngestionRequest.indicesOptions(IndicesOptions.fromRequest(request, pauseIngestionRequest.indicesOptions()));
import org.opensearch.common.annotation.PublicApi;  
 * Transport action to pause pull-based ingestion.
 *
@PublicApi(since = "3.6.0")
    @Override  
        return channel -> client.admin().indices().pauseIngestion(pauseIngestionRequest, new RestToXContentListener<>(channel));  
import org.opensearch.rest.BaseRestHandler;  
    @Override
 * @opensearch.api  
        pauseIngestionRequest.clusterManagerNodeTimeout(
import org.opensearch.rest.action.RestToXContentListener;
import org.opensearch.action.admin.indices.streamingingestion.pause.PauseIngestionRequest;
import static org.opensearch.rest.RestRequest.Method.POST;
import java.io.IOException;
    @Override
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {  
 *
 * The OpenSearch Contributors require contributions made to  
 */  
import static java.util.Arrays.asList;
