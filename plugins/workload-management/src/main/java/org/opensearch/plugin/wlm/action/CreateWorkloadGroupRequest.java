import org.opensearch.core.xcontent.XContentParser;  
     */
        return null;
 */  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.settings.Settings;  
        Settings throttling = workloadGroup.getMutableWorkloadGroupFragment().getThrottling();
    public static CreateWorkloadGroupRequest fromXContent(XContentParser parser) throws IOException {
}  
/*  
/**
package org.opensearch.plugin.wlm.action;
    }
        this.workloadGroup = workloadGroup;  
import java.io.IOException;  
    public ActionRequestValidationException validate() {
import org.opensearch.core.common.io.stream.StreamOutput;
    public WorkloadGroup getWorkloadGroup() {  
    @Override
import org.opensearch.cluster.metadata.WorkloadGroup;
    @Override  
 * SPDX-License-Identifier: Apache-2.0
     * @param in - A {@link StreamInput} object
        workloadGroup.writeTo(out);  
     * WorkloadGroup getter
 *           "memory" : 0.2
        WorkloadGroup.Builder builder = WorkloadGroup.Builder.fromXContent(parser);
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
     */  
    /**  
 *    "resource_limits": {
    }
     * Generate a CreateWorkloadGroupRequest from XContent
 * A request for create WorkloadGroup  
        return new CreateWorkloadGroupRequest(builder._id(UUIDs.randomBase64UUID()).updatedAt(Instant.now().getMillis()).build());  
    }  
        }
import org.opensearch.action.ActionRequestValidationException;
    /**  
import org.joda.time.Instant;
        return workloadGroup;
        super(in);
     * Constructor for CreateWorkloadGroupRequest
     */
    private final WorkloadGroup workloadGroup;
 *      }
import org.opensearch.common.UUIDs;
 *    "resiliency_mode": "enforced",
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;  
    }
     * Constructor for CreateWorkloadGroupRequest
    /**
     * @param workloadGroup - A {@link WorkloadGroup} object  
import org.opensearch.Version;
 *  }  
 *           "cpu" : 0.4,  
 *    "name": "analytics",  
public class CreateWorkloadGroupRequest extends ClusterManagerNodeRequest<CreateWorkloadGroupRequest> {
    }
            throw new IllegalArgumentException("cannot send workload group throttling to a node before version " + Version.V_3_10_0);  
    CreateWorkloadGroupRequest(StreamInput in) throws IOException {
 *
import org.opensearch.core.common.io.stream.StreamInput;
    CreateWorkloadGroupRequest(WorkloadGroup workloadGroup) {
        workloadGroup = new WorkloadGroup(in);  
        if (out.getVersion().before(Version.V_3_10_0) && throttling != null && throttling.isEmpty() == false) {
        super.writeTo(out);
 * User input schema:
     */  
 */  
 * @opensearch.experimental
    public void writeTo(StreamOutput out) throws IOException {  
    }
     * @param parser - A {@link XContentParser} object
 *
 *  {
    /**  
