import java.io.IOException;
 *
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
import org.opensearch.core.xcontent.ToXContentObject;
        super.writeTo(out);  
}
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
    public DecommissionResponse(boolean acknowledged) {  
import org.opensearch.common.annotation.PublicApi;
    }
public class DecommissionResponse extends AcknowledgedResponse implements ToXContentObject {  
package org.opensearch.action.admin.cluster.decommission.awareness.put;
 * @opensearch.api  
@PublicApi(since = "2.4.0")
import org.opensearch.core.common.io.stream.StreamInput;  
 * this file be licensed under the Apache-2.0 license or a
 */
    @Override
        super(acknowledged);
/*  
 *
/**  
    }
 */  
    }
 * The OpenSearch Contributors require contributions made to  
 * Response for decommission request
import org.opensearch.core.common.io.stream.StreamOutput;
    public DecommissionResponse(StreamInput in) throws IOException {
    public void writeTo(StreamOutput out) throws IOException {
        super(in);  
