}
 * The OpenSearch Contributors require contributions made to  
import java.io.IOException;
/**
        super(in);  
 * Request to get all active PIT IDs from all nodes of cluster
 * compatible open source license.
    }  
    public GetAllPitNodesRequest(DiscoveryNode... concreteNodes) {
    @Inject  
public class GetAllPitNodesRequest extends BaseNodesRequest<GetAllPitNodesRequest> {
/*  
import org.opensearch.action.support.nodes.BaseNodesRequest;
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.common.annotation.PublicApi;  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.common.io.stream.StreamOutput;  
 * @opensearch.api
    public GetAllPitNodesRequest(StreamInput in) throws IOException {
    }
        super.writeTo(out);
 */  
    }  
import org.opensearch.common.inject.Inject;
package org.opensearch.action.search;
    public void writeTo(StreamOutput out) throws IOException {
 *
 */
        super(concreteNodes);
import org.opensearch.cluster.node.DiscoveryNode;
    @Override  
 *  
@PublicApi(since = "2.3.0")  
 * SPDX-License-Identifier: Apache-2.0
