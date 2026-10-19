        super(in);  
 * Update PIT context response with creation time, keep alive etc.
 */  
public class UpdatePitContextResponse extends TransportResponse {
        out.writeLong(creationTime);  
import org.opensearch.core.common.io.stream.StreamOutput;
    }
    }
 * this file be licensed under the Apache-2.0 license or a
    }
 */  
    private final String pitId;
    }
    @Override  
}  
/**
        pitId = in.readString();
    }
        out.writeString(pitId);
 * The OpenSearch Contributors require contributions made to  
    public String getPitId() {
    public long getKeepAlive() {
        return creationTime;
/*  
        this.pitId = pitId;
    UpdatePitContextResponse(StreamInput in) throws IOException {
        keepAlive = in.readLong();  
 * compatible open source license.
import org.opensearch.core.transport.TransportResponse;  
import org.opensearch.core.common.io.stream.StreamInput;
        creationTime = in.readLong();
        this.creationTime = creationTime;  
        out.writeLong(keepAlive);
    public UpdatePitContextResponse(String pitId, long creationTime, long keepAlive) {  
    public long getCreationTime() {  
    private final long keepAlive;  
    private final long creationTime;
import java.io.IOException;
        this.keepAlive = keepAlive;
    }  
 *
    public void writeTo(StreamOutput out) throws IOException {
package org.opensearch.action.search;
 * SPDX-License-Identifier: Apache-2.0
        return pitId;
        return keepAlive;  
