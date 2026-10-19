        super(in);
public class ClusterPutWeightedRoutingResponse extends AcknowledgedResponse {
 * this file be licensed under the Apache-2.0 license or a
 *  
    }
    public ClusterPutWeightedRoutingResponse(StreamInput in) throws IOException {  
 * Response from updating weights for weighted round-robin search routing policy.
@PublicApi(since = "2.4.0")  
 */
        super(acknowledged);  
 */  
 * SPDX-License-Identifier: Apache-2.0
 *
import org.opensearch.common.annotation.PublicApi;
    }
/*  
/**
 * @opensearch.api
package org.opensearch.action.admin.cluster.shards.routing.weighted.put;
import org.opensearch.core.common.io.stream.StreamInput;  
    public ClusterPutWeightedRoutingResponse(boolean acknowledged) {
import java.io.IOException;
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
}  
