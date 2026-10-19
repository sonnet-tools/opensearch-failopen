            TARGET_TIER,
 * SPDX-License-Identifier: Apache-2.0
    private static final String TARGET_TIER = "warm";
        tieringIndexRequest.timeout(request.paramAsTime("timeout", tieringIndexRequest.timeout()));
import org.opensearch.rest.RestRequest;
        tieringIndexRequest.indicesOptions(IndicesOptions.fromRequest(request, tieringIndexRequest.indicesOptions()));  
            .cluster()  
    @Override
        );
    @Override  
    }
            .execute(HotToWarmTieringAction.INSTANCE, tieringIndexRequest, new RestToXContentListener<>(channel));
 *
        return "warm_tiering_action";
import org.opensearch.rest.action.RestToXContentListener;  
            splitStringByCommaToArray(request.param("index"))  
 * @opensearch.experimental  
 */  
        tieringIndexRequest.waitForCompletion(request.paramAsBoolean("wait_for_completion", tieringIndexRequest.waitForCompletion()));
        );
import org.opensearch.transport.client.node.NodeClient;
import static java.util.Collections.singletonList;
import org.opensearch.rest.RestHandler;
import org.opensearch.common.annotation.ExperimentalApi;
}  
import org.opensearch.action.support.IndicesOptions;
        return channel -> client.admin()
    }
    public List<RestHandler.Route> routes() {
public class RestWarmTieringAction extends BaseRestHandler {  
import org.opensearch.rest.BaseRestHandler;  
 * Rest Tiering API action to move indices to warm tier
/**  
import static org.opensearch.rest.RestRequest.Method.POST;
 * The OpenSearch Contributors require contributions made to  
        final TieringIndexRequest tieringIndexRequest = new TieringIndexRequest(
        tieringIndexRequest.clusterManagerNodeTimeout(  
 * compatible open source license.
    protected BaseRestHandler.RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) {  
        return singletonList(new RestHandler.Route(POST, "/{index}/_tier/" + TARGET_TIER));  
 *
package org.opensearch.action.admin.indices.tiering;
import java.util.List;  
 */
    }  
    public String getName() {
 * this file be licensed under the Apache-2.0 license or a
@ExperimentalApi
    @Override
import static org.opensearch.core.common.Strings.splitStringByCommaToArray;  
/*  
            request.paramAsTime("cluster_manager_timeout", tieringIndexRequest.clusterManagerNodeTimeout())
