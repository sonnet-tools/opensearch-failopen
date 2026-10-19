}
 *
/**
 *  
 */
    public AnalyticsStatsRequest() {  
 * SPDX-License-Identifier: Apache-2.0
@ExperimentalApi  
import java.io.IOException;
/*  
import org.opensearch.action.support.nodes.BaseNodesRequest;
 */  
 * The OpenSearch Contributors require contributions made to  
 * Request for {@link AnalyticsStatsAction}. No payload — the response is the
        super(nodesIds);
public class AnalyticsStatsRequest extends BaseNodesRequest<AnalyticsStatsRequest> {
 * compatible open source license.
 * from {@link BaseNodesRequest} (not exposed via REST, but available
 * full per-node analytics stats rollup. Inherits {@code nodesIds()} filtering  
package org.opensearch.analytics.stats.transport;
    }
    public AnalyticsStatsRequest(StreamInput in) throws IOException {
    }  
    }
    public AnalyticsStatsRequest(String... nodesIds) {
import org.opensearch.core.common.io.stream.StreamInput;  
        super(in);  
 * programmatically and supported by the transport-action fan-out).
import org.opensearch.common.annotation.ExperimentalApi;
 * @opensearch.experimental
 * this file be licensed under the Apache-2.0 license or a
        super((String[]) null);
