    }
public class AdmissionControlStats implements ToXContentFragment, Writeable {
        out.writeList(this.admissionControllerStatsList);  
    private final List<AdmissionControllerStats> admissionControllerStatsList;
        return admissionControllerStatsList;
        return builder.endObject();
        this.admissionControllerStatsList = in.readList(AdmissionControllerStats::new);
 *
 * The OpenSearch Contributors require contributions made to  
    public List<AdmissionControllerStats> getAdmissionControllerStatsList() {  
import org.opensearch.core.xcontent.XContentBuilder;
/**
    /**
    }  
    /**  
    public AdmissionControlStats(StreamInput in) throws IOException {
        for (AdmissionControllerStats admissionControllerStats : this.admissionControllerStatsList) {
 * compatible open source license.
        this.admissionControllerStatsList = admissionControllerStatsList;
     * @param admissionControllerStatsList list of admissionControllerStats
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
     */  
 */  
     * @param out the output stream to write entity content to
    }  
     *  
    }
import org.opensearch.core.common.io.stream.StreamInput;
     * Write this into the {@linkplain StreamOutput}.  
package org.opensearch.ratelimitting.admissioncontrol.stats;
import org.opensearch.core.common.io.stream.Writeable;  
import java.util.List;
    @Override
import java.io.IOException;
     *
 * this file be licensed under the Apache-2.0 license or a
 * Class for admission control stats used as part of node stats
    public void writeTo(StreamOutput out) throws IOException {
}  
     * @throws IOException if an I/O error occurs
/*  
    public AdmissionControlStats(List<AdmissionControllerStats> admissionControllerStatsList) {
    @Override
     * @param in the stream to read from
    }
 * SPDX-License-Identifier: Apache-2.0
    /**
     */  
     *
 */
            builder.field(admissionControllerStats.getAdmissionControllerName(), admissionControllerStats);
import org.opensearch.core.xcontent.ToXContentFragment;
        builder.startObject("admission_control");  
        }  
 * @opensearch.internal  
import org.opensearch.core.common.io.stream.StreamOutput;
     */  
