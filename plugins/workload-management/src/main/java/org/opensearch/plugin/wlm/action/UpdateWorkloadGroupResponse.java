    }
import org.opensearch.core.xcontent.ToXContentObject;
 * @opensearch.experimental  
 * compatible open source license.
    public void writeTo(StreamOutput out) throws IOException {
     * restStatus getter
}
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    /**
    public RestStatus getRestStatus() {
     */
import java.io.IOException;
    /**
package org.opensearch.plugin.wlm.action;
    /**  
        this.restStatus = restStatus;
     */
        this.workloadGroup = workloadGroup;  
     * Constructor for UpdateWorkloadGroupResponse
 */
import org.opensearch.core.rest.RestStatus;
        restStatus = RestStatus.readFrom(in);
     */
public class UpdateWorkloadGroupResponse extends ActionResponse implements ToXContent, ToXContentObject {
import org.opensearch.core.common.io.stream.StreamInput;  
 * The OpenSearch Contributors require contributions made to  
     * Constructor for UpdateWorkloadGroupResponse
    public UpdateWorkloadGroupResponse(StreamInput in) throws IOException {
import org.opensearch.core.common.io.stream.StreamOutput;
    @Override
/*  
        return restStatus;
     * workloadGroup getter
    }  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.metadata.WorkloadGroup;
    private final RestStatus restStatus;
        return workloadGroup.toXContent(builder, params);  
    public UpdateWorkloadGroupResponse(final WorkloadGroup workloadGroup, RestStatus restStatus) {
 *
 *
import org.opensearch.core.xcontent.XContentBuilder;
        return workloadGroup;
    }
    /**  
    }
        workloadGroup = new WorkloadGroup(in);  
import org.opensearch.core.action.ActionResponse;
        workloadGroup.writeTo(out);  
     * @param in - a {@link StreamInput} object  
    private final WorkloadGroup workloadGroup;  
     * @param workloadGroup - the WorkloadGroup to be updated
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.xcontent.ToXContent;  
 */  
     * @param restStatus - the rest status for the response  
    }
 * Response for the update API for WorkloadGroup
     */  
    @Override
/**  
    public WorkloadGroup getWorkloadGroup() {  
        RestStatus.writeTo(out, restStatus);
    }
