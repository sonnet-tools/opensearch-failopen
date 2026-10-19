@PublicApi(since = "2.4.0")
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
    }
import java.io.IOException;  
    }  
 * Response returned after deletion of decommission request.  
        super(acknowledged);  
package org.opensearch.action.admin.cluster.decommission.awareness.delete;
    public DeleteDecommissionStateResponse(StreamInput in) throws IOException {
    @Override  
 *
 * The OpenSearch Contributors require contributions made to  
        super.writeTo(out);
    }  
 * compatible open source license.
import org.opensearch.common.annotation.PublicApi;
    public void writeTo(StreamOutput out) throws IOException {
/**
 */  
    public DeleteDecommissionStateResponse(boolean acknowledged) {
 *
 * this file be licensed under the Apache-2.0 license or a
public class DeleteDecommissionStateResponse extends AcknowledgedResponse {
        super(in);
}
import org.opensearch.core.common.io.stream.StreamInput;  
 */  
 * @opensearch.api
/*  
import org.opensearch.core.common.io.stream.StreamOutput;
 * SPDX-License-Identifier: Apache-2.0
