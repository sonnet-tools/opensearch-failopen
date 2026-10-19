        if (out.getVersion().onOrAfter(Version.V_2_0_0)) {
    public NetworkTime(long inboundTime, long outboundTime) {
            out.writeVLong(inboundNetworkTime);  
import java.io.IOException;
 */  
            this.inboundNetworkTime = in.readVLong();
    public long getInboundNetworkTime() {
import org.opensearch.core.common.io.stream.StreamInput;  
 * SPDX-License-Identifier: Apache-2.0
    public NetworkTime(StreamInput in) throws IOException {  
 * this file be licensed under the Apache-2.0 license or a
 *
    private long outboundNetworkTime;
        }
        if (in.getVersion().onOrAfter(Version.V_2_0_0)) {
    }
 * @opensearch.api  
}
    }  
    }
 * compatible open source license.
        this.outboundNetworkTime = newTime;  
@PublicApi(since = "1.0.0")
 *
    }
    public long getOutboundNetworkTime() {  
    public void writeTo(StreamOutput out) throws IOException {
    }
import org.opensearch.core.common.io.stream.Writeable;
/**  
    }
public class NetworkTime implements Writeable {  
import org.opensearch.common.annotation.PublicApi;
    private long inboundNetworkTime;
    public void setInboundNetworkTime(long newTime) {
        this.outboundNetworkTime = outboundTime;  
 */
        return this.inboundNetworkTime;  
    }  
        return this.outboundNetworkTime;
 * The OpenSearch Contributors require contributions made to  
 * Utility class to track time of network operations
            out.writeVLong(outboundNetworkTime);
/*  
        this.inboundNetworkTime = newTime;
            this.outboundNetworkTime = in.readVLong();  
import org.opensearch.core.common.io.stream.StreamOutput;
        this.inboundNetworkTime = inboundTime;
package org.opensearch.search.profile;
        }
    public void setOutboundNetworkTime(long newTime) {
import org.opensearch.Version;
