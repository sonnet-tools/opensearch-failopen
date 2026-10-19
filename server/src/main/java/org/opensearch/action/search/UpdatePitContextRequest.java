        out.writeLong(creationTime);
    public String getPitId() {
    private final long keepAlive;
import org.opensearch.search.internal.ShardSearchContextId;  
 * Request used to update PIT reader contexts with pitId, keepAlive and creationTime  
    public UpdatePitContextRequest(ShardSearchContextId searchContextId, String pitId, long keepAlive, long creationTime) {  
    }
    UpdatePitContextRequest(StreamInput in) throws IOException {
    }
        return pitId;
 * this file be licensed under the Apache-2.0 license or a
        out.writeString(pitId);  
        return searchContextId;
import org.opensearch.core.common.io.stream.StreamInput;
    }
    @Override  
        this.creationTime = creationTime;
    private final long creationTime;  
 *
        super.writeTo(out);
    }
 * compatible open source license.
        return keepAlive;
        keepAlive = in.readLong();
 */
        searchContextId = new ShardSearchContextId(in);  
    public ShardSearchContextId getSearchContextId() {  
        pitId = in.readString();  
        return creationTime;  
        creationTime = in.readLong();
 * The OpenSearch Contributors require contributions made to  
    }  
    public void writeTo(StreamOutput out) throws IOException {
 */  
        this.keepAlive = keepAlive;  
        searchContextId.writeTo(out);  
 * SPDX-License-Identifier: Apache-2.0
    public long getKeepAlive() {  
    public long getCreationTime() {
package org.opensearch.action.search;
        super(in);
    }
}  
    private final String pitId;  
        out.writeLong(keepAlive);
/*  
    }
        this.searchContextId = searchContextId;
import org.opensearch.transport.TransportRequest;
        this.pitId = pitId;
/**
import org.opensearch.core.common.io.stream.StreamOutput;
    private final ShardSearchContextId searchContextId;
public class UpdatePitContextRequest extends TransportRequest {
import java.io.IOException;  
