    @Override
    private final WorkloadGroup workloadGroup;  
        return workloadGroup;
    public void writeTo(StreamOutput out) throws IOException {
 * @opensearch.experimental  
        this.workloadGroup = workloadGroup;  
    }
    }
    public WorkloadGroup getWorkloadGroup() {  
     * Constructor for CreateWorkloadGroupResponse
        workloadGroup.writeTo(out);  
    }
import org.opensearch.core.common.io.stream.StreamOutput;
     * @param in - A {@link StreamInput} object  
package org.opensearch.plugin.wlm.action;
/*  
        RestStatus.writeTo(out, restStatus);
     * restStatus getter
 * The OpenSearch Contributors require contributions made to  
    }
 */
 */  
/**  
import org.opensearch.core.xcontent.XContentBuilder;
    /**  
}
import org.opensearch.core.xcontent.ToXContentObject;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
     * @param workloadGroup - The WorkloadGroup to be included in the response
public class CreateWorkloadGroupResponse extends ActionResponse implements ToXContent, ToXContentObject {
    public RestStatus getRestStatus() {
 *
        workloadGroup = new WorkloadGroup(in);  
     * workloadGroup getter
    public CreateWorkloadGroupResponse(StreamInput in) throws IOException {
import org.opensearch.cluster.metadata.WorkloadGroup;
        this.restStatus = restStatus;
     */
 * Response for the create API for WorkloadGroup
        return workloadGroup.toXContent(builder, params);  
import org.opensearch.core.action.ActionResponse;
 * compatible open source license.
     */  
    public CreateWorkloadGroupResponse(final WorkloadGroup workloadGroup, RestStatus restStatus) {
     * Constructor for CreateWorkloadGroupResponse
    }
 * SPDX-License-Identifier: Apache-2.0
    @Override
        restStatus = RestStatus.readFrom(in);
import java.io.IOException;
import org.opensearch.core.rest.RestStatus;
    /**
 *
    /**
        return restStatus;
    private final RestStatus restStatus;
     */
    }  
import org.opensearch.core.common.io.stream.StreamInput;  
import org.opensearch.core.xcontent.ToXContent;  
     * @param restStatus - The restStatus for the response  
    /**  
     */
 * this file be licensed under the Apache-2.0 license or a
