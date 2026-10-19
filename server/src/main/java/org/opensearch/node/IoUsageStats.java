    }  
        this.ioUtilisationPercent = ioUtilisationPercent;
    }
import java.io.IOException;
import java.util.Locale;  
import org.opensearch.core.common.io.stream.StreamInput;
    }  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
     *  
    public IoUsageStats(double ioUtilisationPercent) {
import org.opensearch.common.annotation.ExperimentalApi;
     *
/**
 * this file be licensed under the Apache-2.0 license or a
     * @param out the output stream to write entity content to
}
public class IoUsageStats implements Writeable, ToXContentFragment {  
    public double getIoUtilisationPercent() {  
    private double ioUtilisationPercent;
     * @param in the stream to read from
import org.opensearch.core.xcontent.XContentBuilder;  
    @Override
        return ioUtilisationPercent;
    public void setIoUtilisationPercent(double ioUtilisationPercent) {
 * compatible open source license.
    public void writeTo(StreamOutput out) throws IOException {
        builder.field("max_io_utilization_percent", String.format(Locale.ROOT, "%.1f", this.ioUtilisationPercent));
        return "IO utilization percent: " + String.format(Locale.ROOT, "%.1f", this.ioUtilisationPercent);
    public IoUsageStats(StreamInput in) throws IOException {
    public String toString() {
 */  
     */  
@ExperimentalApi
     * @throws IOException if an error occurs while reading from the StreamOutput
    @Override
    /**
import org.opensearch.core.common.io.stream.Writeable;
        this.ioUtilisationPercent = in.readDouble();
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.node;
import org.opensearch.core.common.io.stream.StreamOutput;  
        this.ioUtilisationPercent = ioUtilisationPercent;
        builder.startObject();
    }
     * Write this into the {@linkplain StreamOutput}.  
    }  
import org.opensearch.core.xcontent.ToXContentFragment;
        return builder.endObject();  
    }
 * The OpenSearch Contributors require contributions made to  
    @Override  
     */  
        out.writeDouble(this.ioUtilisationPercent);  
/*  
    }  
 *
    /**
 */
 * This class is to store tne IO Usage Stats and used to return in node stats API.  
