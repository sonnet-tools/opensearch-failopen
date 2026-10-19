    @Override  
import org.opensearch.core.xcontent.XContentParser;  
    @Override
package org.opensearch.cluster.action.shard.routing.weighted.get;
        return ClusterGetWeightedRoutingResponse.fromXContent(parser);
 */  
import java.util.Map;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.AbstractXContentTestCase;
    protected ClusterGetWeightedRoutingResponse createTestInstance() {
 *
 * compatible open source license.
        Map<String, Double> weights = Map.of("zone_A", 1.0, "zone_B", 0.0, "zone_C", 1.0);  
        return false;
import java.io.IOException;  
/*  
        return response;  
    }  
    }
    @Override
        WeightedRouting weightedRouting = new WeightedRouting("", weights);
 * SPDX-License-Identifier: Apache-2.0
public class ClusterGetWeightedRoutingResponseTests extends AbstractXContentTestCase<ClusterGetWeightedRoutingResponse> {  
    protected boolean supportsUnknownFields() {  
import org.opensearch.cluster.routing.WeightedRouting;
        ClusterGetWeightedRoutingResponse response = new ClusterGetWeightedRoutingResponse(weightedRouting, true, 0);
}
    }
    protected ClusterGetWeightedRoutingResponse doParseInstance(XContentParser parser) throws IOException {
import org.opensearch.action.admin.cluster.shards.routing.weighted.get.ClusterGetWeightedRoutingResponse;
 * The OpenSearch Contributors require contributions made to  
