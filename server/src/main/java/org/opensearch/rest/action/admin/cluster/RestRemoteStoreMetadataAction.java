        String shardId = request.param("shard_id");  
        );
        String index = request.param("index");
            metadataRequest.shards(shardId);
import java.io.IOException;
 *
 * Rest action for fetching remote store metadata  
 * compatible open source license.
 */  
 * SPDX-License-Identifier: Apache-2.0
            asList(new Route(GET, "/_remotestore/metadata/{index}"), new Route(GET, "/_remotestore/metadata/{index}/{shard_id}"))  
import org.opensearch.rest.BaseRestHandler;
    }
 *
    @Override
package org.opensearch.rest.action.admin.cluster;
    @Override  
/*  
    public String getName() {
import static java.util.Collections.unmodifiableList;
    protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
        if (index != null) {  
        RemoteStoreMetadataRequest metadataRequest = new RemoteStoreMetadataRequest();
        return unmodifiableList(
        if (shardId != null) {  
        }
import org.opensearch.rest.action.RestToXContentListener;
    @Override  
 * @opensearch.internal
        }
import org.opensearch.transport.client.node.NodeClient;
import static org.opensearch.rest.RestRequest.Method.GET;  
import org.opensearch.action.admin.cluster.remotestore.metadata.RemoteStoreMetadataRequest;
    }
            metadataRequest.indices(index);
 * The OpenSearch Contributors require contributions made to  
/**
import static java.util.Arrays.asList;
import java.util.List;
public class RestRemoteStoreMetadataAction extends BaseRestHandler {
 */  
import org.opensearch.rest.RestRequest;  
 * this file be licensed under the Apache-2.0 license or a
}  
        return "remote_store_metadata";  
    public List<Route> routes() {
        return channel -> client.admin().cluster().remoteStoreMetadata(metadataRequest, new RestToXContentListener<>(channel));
    }
