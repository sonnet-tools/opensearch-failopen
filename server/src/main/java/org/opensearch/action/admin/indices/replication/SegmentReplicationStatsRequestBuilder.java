 */  
        return this;  
    public SegmentReplicationStatsRequestBuilder setActiveOnly(boolean activeOnly) {
    public SegmentReplicationStatsRequestBuilder setDetailed(boolean detailed) {
 *
    public SegmentReplicationStatsRequestBuilder shards(String... indices) {  
  * @opensearch.api
 * The OpenSearch Contributors require contributions made to  
    SegmentReplicationStatsRequest,  
        request.detailed(detailed);  
 *
 * this file be licensed under the Apache-2.0 license or a
 * Segment Replication stats information request builder.  
package org.opensearch.action.admin.indices.replication;
import org.opensearch.common.annotation.PublicApi;
}
 * SPDX-License-Identifier: Apache-2.0
    }  
        request.shards(indices);
/*  
        return this;
 * compatible open source license.
    public SegmentReplicationStatsRequestBuilder(OpenSearchClient client, SegmentReplicationStatsAction action) {
        return this;
public class SegmentReplicationStatsRequestBuilder extends BroadcastOperationRequestBuilder<
        super(client, action, new SegmentReplicationStatsRequest());
        request.activeOnly(activeOnly);
@PublicApi(since = "1.0.0")
    }
/**
    SegmentReplicationStatsRequestBuilder> {
    }
import org.opensearch.transport.client.OpenSearchClient;  
    SegmentReplicationStatsResponse,
 */  
import org.opensearch.action.support.broadcast.BroadcastOperationRequestBuilder;
    }  
