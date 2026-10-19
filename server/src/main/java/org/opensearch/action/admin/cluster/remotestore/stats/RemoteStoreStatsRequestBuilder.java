 * The OpenSearch Contributors require contributions made to  
import org.opensearch.transport.client.OpenSearchClient;
        request.timeout(timeout);
    }  
    public final RemoteStoreStatsRequestBuilder setTimeout(TimeValue timeout) {  
 * compatible open source license.
    /**
@PublicApi(since = "2.8.0")
 *
     * Sets shards preference of request.  
    RemoteStoreStatsRequest,
     * Sets local shards preference of request.
        return this;  
 */
    }
        super(client, action, new RemoteStoreStatsRequest());  
     * Sets timeout of request.
import org.opensearch.common.annotation.PublicApi;
    public final RemoteStoreStatsRequestBuilder setShards(String... shards) {
    /**
package org.opensearch.action.admin.cluster.remotestore.stats;
    public RemoteStoreStatsRequestBuilder(OpenSearchClient client, RemoteStoreStatsAction action) {
        request.local(local);
    RemoteStoreStatsRequestBuilder> {  
 * @opensearch.api  
 * SPDX-License-Identifier: Apache-2.0
        return this;
public class RemoteStoreStatsRequestBuilder extends BroadcastOperationRequestBuilder<  
 * Builder for RemoteStoreStatsRequest
        return this;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.unit.TimeValue;  
     */
     */
    }
/**  
        request.shards(shards);  
    }
 */  
     */  
    RemoteStoreStatsResponse,
import org.opensearch.action.support.broadcast.BroadcastOperationRequestBuilder;
 *
    public final RemoteStoreStatsRequestBuilder setLocal(boolean local) {
}
/*  
    /**  
