 * this file be licensed under the Apache-2.0 license or a
 *
    @Override
    public ActionRequestValidationException validate() {  
    public DeleteDecommissionStateRequest() {}
import org.opensearch.common.annotation.PublicApi;  
    public DeleteDecommissionStateRequest(StreamInput in) throws IOException {
    }
public class DeleteDecommissionStateRequest extends ClusterManagerNodeRequest<DeleteDecommissionStateRequest> {  
 *
 */
import java.io.IOException;
        super.writeTo(out);  
import org.opensearch.core.common.io.stream.StreamOutput;
        return null;
import org.opensearch.action.ActionRequestValidationException;
import org.opensearch.core.common.io.stream.StreamInput;
 * Request for deleting decommission request.
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;
package org.opensearch.action.admin.cluster.decommission.awareness.delete;
    public void writeTo(StreamOutput out) throws IOException {
@PublicApi(since = "2.4.0")
 * The OpenSearch Contributors require contributions made to  
    }  
/**  
 * SPDX-License-Identifier: Apache-2.0
    }
/*  
        super(in);
    @Override
 * @opensearch.api  
 * compatible open source license.
 */  
}
