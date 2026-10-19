    }  
        super(in);  
import org.opensearch.action.ActionRequestValidationException;
    public StreamDataRequest(StreamInput in) throws IOException {
        count = in.readInt();
    }
 *
    public void writeTo(StreamOutput out) throws IOException {
    @Override
    public int getCount() {
 * this file be licensed under the Apache-2.0 license or a
    public ActionRequestValidationException validate() {  
    public StreamDataRequest() {}  
    @Override
    private long delayMs = 1000;
import java.io.IOException;  
    }
        out.writeLong(delayMs);
    private int count = 10;  
 */  
    }  
        out.writeInt(count);
}
 * compatible open source license.
class StreamDataRequest extends ActionRequest {
import org.opensearch.core.common.io.stream.StreamOutput;
 * SPDX-License-Identifier: Apache-2.0
        this.delayMs = delayMs;
import org.opensearch.action.ActionRequest;
        super.writeTo(out);  
    public StreamDataRequest(int count, long delayMs) {
    }
    }  
        return delayMs;  
        delayMs = in.readLong();
        this.count = count;  
package org.opensearch.example.stream;
    public long getDelayMs() {
        return null;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.common.io.stream.StreamInput;  
        return count;
/*  
