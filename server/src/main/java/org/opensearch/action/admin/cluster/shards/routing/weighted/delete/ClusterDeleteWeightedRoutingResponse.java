    public void writeTo(StreamOutput out) throws IOException {
 * @opensearch.api
import org.opensearch.common.annotation.PublicApi;
        super(in);
import org.opensearch.core.common.io.stream.StreamOutput;
 * compatible open source license.
public class ClusterDeleteWeightedRoutingResponse extends AcknowledgedResponse {
 * The OpenSearch Contributors require contributions made to  
    public ClusterDeleteWeightedRoutingResponse(boolean acknowledged) {
    }
 *
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
    }  
package org.opensearch.action.admin.cluster.shards.routing.weighted.delete;
    }
import java.io.IOException;  
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
 * Response from deleting weights for weighted round-robin search routing policy.  
    @Override  
/*  
 *
        super.writeTo(out);
    ClusterDeleteWeightedRoutingResponse(StreamInput in) throws IOException {
import org.opensearch.core.common.io.stream.StreamInput;  
@PublicApi(since = "2.4.0")
 */  
}
 */  
        super(acknowledged);  
/**
