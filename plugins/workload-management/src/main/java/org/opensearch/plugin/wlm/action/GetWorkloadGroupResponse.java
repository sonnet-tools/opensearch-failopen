        }
import org.opensearch.core.xcontent.ToXContent;  
    public void writeTo(StreamOutput out) throws IOException {  
 * Response for the get API for WorkloadGroup
        this.workloadGroups = in.readList(WorkloadGroup::new);
/*  
import org.opensearch.core.common.io.stream.StreamInput;  
import org.opensearch.core.common.io.stream.StreamOutput;
        builder.endArray();  
        builder.startObject();
    @Override
        out.writeCollection(workloadGroups);
        return workloadGroups;  
     */
    /**
/**
public class GetWorkloadGroupResponse extends ActionResponse implements ToXContent, ToXContentObject {  
        RestStatus.writeTo(out, restStatus);
     * @param workloadGroups - The WorkloadGroup list to be fetched  
 * @opensearch.experimental
 */
 *  
     */
 */  
     * Constructor for GetWorkloadGroupResponse  
        return restStatus;
 * The OpenSearch Contributors require contributions made to  
    private final RestStatus restStatus;
    private final Collection<WorkloadGroup> workloadGroups;
import org.opensearch.core.rest.RestStatus;
import org.opensearch.core.xcontent.XContentBuilder;
        this.restStatus = restStatus;
        return builder;
        for (WorkloadGroup group : workloadGroups) {  
    @Override
    }  
import java.io.IOException;
    }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
    public RestStatus getRestStatus() {  
     * workloadGroups getter  
        this.workloadGroups = workloadGroups;
 * this file be licensed under the Apache-2.0 license or a
     * @param restStatus - The rest status of the request
    }
    /**  
     */
        builder.endObject();
            group.toXContent(builder, params);
    /**
    }  
import org.opensearch.cluster.metadata.WorkloadGroup;
     * @param in - A {@link StreamInput} object
     * Constructor for GetWorkloadGroupResponse
        restStatus = RestStatus.readFrom(in);
    }  
    public GetWorkloadGroupResponse(final Collection<WorkloadGroup> workloadGroups, RestStatus restStatus) {  
 * SPDX-License-Identifier: Apache-2.0
    /**
package org.opensearch.plugin.wlm.action;
    public Collection<WorkloadGroup> getWorkloadGroups() {
import java.util.Collection;
}  
 * compatible open source license.
import org.opensearch.core.xcontent.ToXContentObject;
     * restStatus getter
 *
    public GetWorkloadGroupResponse(StreamInput in) throws IOException {  
    }  
import org.opensearch.core.action.ActionResponse;
        builder.startArray("workload_groups");
     */
