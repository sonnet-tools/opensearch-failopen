    UpdateWorkloadGroupRequest(String name, MutableWorkloadGroupFragment mutableWorkloadGroupFragment) {  
    }
import org.opensearch.Version;
     * Constructor for UpdateWorkloadGroupRequest  
    @Override
 */
    /**
     */
/**
    /**
     * Generate a UpdateWorkloadGroupRequest from XContent
        return name;  
    @Override
    public ActionRequestValidationException validate() {  
import org.opensearch.core.xcontent.XContentParser;
 * SPDX-License-Identifier: Apache-2.0
     */
 * this file be licensed under the Apache-2.0 license or a
/*  
import org.opensearch.wlm.MutableWorkloadGroupFragment;  
 * The OpenSearch Contributors require contributions made to  
    }  
     */
     * name getter  
import org.opensearch.action.ActionRequestValidationException;
     * @param name - WorkloadGroup name for UpdateWorkloadGroupRequest  
     * mutableWorkloadGroupFragment getter
import org.opensearch.common.settings.Settings;
        WorkloadGroup.validateName(name);
 * A request for update WorkloadGroup
import org.opensearch.core.common.io.stream.StreamOutput;
     */
        Settings throttling = mutableWorkloadGroupFragment.getThrottling();  
     * @param name - name of the WorkloadGroup to be updated
        }  
    }
     * @param in - A {@link StreamInput} object
    /**
 */  
     * @param parser - A {@link XContentParser} object  
 *
public class UpdateWorkloadGroupRequest extends ClusterManagerNodeRequest<UpdateWorkloadGroupRequest> {  
        this.name = name;
    public String getName() {
import org.opensearch.core.common.io.stream.StreamInput;  
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;  
import java.io.IOException;
        this.mutableWorkloadGroupFragment = mutableWorkloadGroupFragment;
    /**
        if (out.getVersion().before(Version.V_3_10_0) && throttling != null && throttling.isEmpty() == false) {
 *  
        out.writeString(name);
    /**  
    public static UpdateWorkloadGroupRequest fromXContent(XContentParser parser, String name) throws IOException {  
        return mutableWorkloadGroupFragment;
    private final MutableWorkloadGroupFragment mutableWorkloadGroupFragment;
     * Constructor for UpdateWorkloadGroupRequest
    public void writeTo(StreamOutput out) throws IOException {
package org.opensearch.plugin.wlm.action;
        return new UpdateWorkloadGroupRequest(name, builder.getMutableWorkloadGroupFragment());
     */
            throw new IllegalArgumentException("cannot send workload group throttling to a node before version " + Version.V_3_10_0);
        mutableWorkloadGroupFragment.writeTo(out);
    }  
}
    private final String name;
    public MutableWorkloadGroupFragment getmMutableWorkloadGroupFragment() {  
    UpdateWorkloadGroupRequest(StreamInput in) throws IOException {  
    }
        return null;
        WorkloadGroup.Builder builder = WorkloadGroup.Builder.fromXContent(parser);
    }  
     * @param mutableWorkloadGroupFragment - MutableWorkloadGroupFragment for UpdateWorkloadGroupRequest
        this(in.readString(), new MutableWorkloadGroupFragment(in));
 * @opensearch.experimental
    }  
import org.opensearch.cluster.metadata.WorkloadGroup;
 * compatible open source license.
