public class RestRemoteStoreStatsAction extends BaseRestHandler {
    }
 */
 * @opensearch.internal  
import java.util.List;
import org.opensearch.rest.action.RestToXContentListener;
 *
        );
        RemoteStoreStatsRequest remoteStoreStatsRequest = new RemoteStoreStatsRequest();  
import java.io.IOException;
/*  
import static java.util.Collections.unmodifiableList;  
        return unmodifiableList(  
    public String getName() {  
        String shardId = request.param("shard_id");
    }  
        String index = request.param("index");  
    @Override
        }  
    @Override
        boolean local = Objects.equals(request.param("local"), "true");
 * SPDX-License-Identifier: Apache-2.0
/**  
    @Override
 * The OpenSearch Contributors require contributions made to  
    }  
package org.opensearch.rest.action.admin.cluster;
            remoteStoreStatsRequest.shards(shardId);
 *
    public List<Route> routes() {
        return "remote_store_stats";
}
import static org.opensearch.rest.RestRequest.Method.GET;
import org.opensearch.rest.RestRequest;  
import org.opensearch.rest.BaseRestHandler;
 * this file be licensed under the Apache-2.0 license or a
        }  
            asList(new Route(GET, "/_remotestore/stats/{index}"), new Route(GET, "/_remotestore/stats/{index}/{shard_id}"))
            remoteStoreStatsRequest.indices(index);
    protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
        if (shardId != null) {
import org.opensearch.transport.client.node.NodeClient;
        remoteStoreStatsRequest.local(local);
 * Rest action for fetching remote store stats
import java.util.Objects;  
 * compatible open source license.
import static java.util.Arrays.asList;
        if (index != null) {
import org.opensearch.action.admin.cluster.remotestore.stats.RemoteStoreStatsRequest;
        return channel -> client.admin().cluster().remoteStoreStats(remoteStoreStatsRequest, new RestToXContentListener<>(channel));
 */  
