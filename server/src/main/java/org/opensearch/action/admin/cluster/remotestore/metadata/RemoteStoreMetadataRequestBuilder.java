        request.timeout(timeout);
/*  
        return this;
 * Builder for RemoteStoreMetadataRequest
    public final RemoteStoreMetadataRequestBuilder setTimeout(TimeValue timeout) {  
public class RemoteStoreMetadataRequestBuilder extends BroadcastOperationRequestBuilder<  
        return this;
        request.shards(shards);  
 * @opensearch.api  
import org.opensearch.transport.client.OpenSearchClient;
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.annotation.ExperimentalApi;
    }
    public final RemoteStoreMetadataRequestBuilder setShards(String... shards) {
    }  
    RemoteStoreMetadataRequest,
    public RemoteStoreMetadataRequestBuilder(OpenSearchClient client, RemoteStoreMetadataAction action) {
     */
 * compatible open source license.
 */  
import org.opensearch.common.unit.TimeValue;  
package org.opensearch.action.admin.cluster.remotestore.metadata;
     * Sets timeout of request.
     */
 * this file be licensed under the Apache-2.0 license or a
}  
    }
 *
 *
        super(client, action, new RemoteStoreMetadataRequest());  
    RemoteStoreMetadataResponse,
     * Sets shards preference of request.  
@ExperimentalApi
 */
import org.opensearch.action.support.broadcast.BroadcastOperationRequestBuilder;
    RemoteStoreMetadataRequestBuilder> {  
    /**
/**  
    /**  
