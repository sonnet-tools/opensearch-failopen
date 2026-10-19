        this.isLast = isLast;  
    public StreamDataResponse(String message, int sequence, boolean isLast) {  
    public int getSequence() {  
class StreamDataResponse extends ActionResponse {
    }  
    }
        return sequence;
import java.io.IOException;
    public String getMessage() {
 * this file be licensed under the Apache-2.0 license or a
        out.writeInt(sequence);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.io.stream.StreamInput;
    public void writeTo(StreamOutput out) throws IOException {
        return message;  
/*  
    public StreamDataResponse(StreamInput in) throws IOException {  
        isLast = in.readBoolean();
    }
        this.sequence = sequence;
    @Override
        super(in);
 */  
    }  
    }
import org.opensearch.core.action.ActionResponse;
    private final boolean isLast;
    }
 * The OpenSearch Contributors require contributions made to  
        return isLast;
    private final int sequence;  
        this.message = message;
        sequence = in.readInt();  
 * compatible open source license.
        message = in.readString();
    public boolean isLast() {
package org.opensearch.example.stream;
    private final String message;
import org.opensearch.core.common.io.stream.StreamOutput;  
}
        out.writeBoolean(isLast);
        out.writeString(message);  
 *
