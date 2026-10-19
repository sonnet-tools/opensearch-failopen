 * this file be licensed under the Apache-2.0 license or a
        return builder.endObject();
import org.opensearch.core.xcontent.ToXContentFragment;
    public AdmissionControllerStats(AdmissionController admissionController) {
        }  
        this.rejectionCount = in.readMap(StreamInput::readString, StreamInput::readLong);
import org.opensearch.ratelimitting.admissioncontrol.controllers.AdmissionController;  
    /**
     * Writes this instance into a {@link StreamOutput}
    public Map<String, Long> rejectionCount;
import org.opensearch.core.common.io.stream.StreamInput;
        this.admissionControllerName = in.readString();
        builder.startObject();
    }
 * SPDX-License-Identifier: Apache-2.0
            builder.endObject();
     * @throws IOException if an error occurs while writing to the StreamOutput
        builder.endObject();
 * compatible open source license.
}
     */
        this.admissionControllerName = admissionController.getName();  
    @Override  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        out.writeString(this.admissionControllerName);  
                for (Map.Entry<String, Long> rejectionCountEntry : this.rejectionCount.entrySet()) {
            {  
        out.writeMap(this.rejectionCount, StreamOutput::writeString, StreamOutput::writeLong);
import java.io.IOException;
import org.opensearch.core.common.io.stream.StreamOutput;
/**
 */
 *
public class AdmissionControllerStats implements Writeable, ToXContentFragment {  
 * @opensearch.internal
import java.util.Map;  
 */  
        return admissionControllerName;  
    public void writeTo(StreamOutput out) throws IOException {
 * Class for admission controller ( such as CPU ) stats which includes rejection count for each action type  
        return rejectionCount;
    }  
import org.opensearch.core.common.io.stream.Writeable;  
 * The OpenSearch Contributors require contributions made to  
    public Map<String, Long> getRejectionCount() {  
    }  
package org.opensearch.ratelimitting.admissioncontrol.stats;
    @Override  
        {
        builder.startObject("transport");  
    }
                }  
    public AdmissionControllerStats(StreamInput in) throws IOException {  
            }
    public String admissionControllerName;
                    builder.field(rejectionCountEntry.getKey(), rejectionCountEntry.getValue());
     * @param out the {@link StreamOutput} to write to  
            builder.startObject("rejection_count");
    }
    public String getAdmissionControllerName() {
        this.rejectionCount = admissionController.getRejectionStats();
import org.opensearch.core.xcontent.XContentBuilder;
    }
/*  
