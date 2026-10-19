package org.opensearch.analytics.stats.transport;
}  
 * {@link org.opensearch.action.support.nodes.TransportNodesAction}'s
 */  
    public AnalyticsStatsNodeRequest(StreamInput in) throws IOException {  
 * outer {@link AnalyticsStatsRequest} carries no filters today, so this  
 * request is empty too — it exists to satisfy
        super(in);
@ExperimentalApi
import org.opensearch.common.annotation.ExperimentalApi;
import java.io.IOException;
 *
    }
    public AnalyticsStatsNodeRequest() {}
public class AnalyticsStatsNodeRequest extends TransportRequest {
 */  
 *
/**
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.common.io.stream.StreamInput;
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.experimental
 * generic contract.  
 * this file be licensed under the Apache-2.0 license or a
 * Per-node request emitted by the coordinator to each fan-out target. The
 * compatible open source license.
import org.opensearch.transport.TransportRequest;  
/*  
