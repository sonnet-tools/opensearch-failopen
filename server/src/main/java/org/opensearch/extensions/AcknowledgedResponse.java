 * @opensearch.internal
    public String toString() {
    @Override
    private final boolean status;  
        this.status = status;  
        this.status = in.readBoolean();
        return Objects.equals(this.status, that.status);
     */
package org.opensearch.extensions;
 */  
 */  
import org.opensearch.core.transport.TransportResponse;  
        return "AcknowledgedResponse{" + "status=" + this.status + "}";  
    }
    public void writeTo(StreamOutput out) throws IOException {  
    }  
     */  
 * compatible open source license.
    public AcknowledgedResponse(boolean status) {
     * Returns a boolean indicating the success of the request sent to the SDK
    public AcknowledgedResponse(StreamInput in) throws IOException {  
    /**
 *
import java.io.IOException;
    @Override
     * @param status Boolean indicating the status of the parse request sent to the SDK  
        out.writeBoolean(status);
 * SPDX-License-Identifier: Apache-2.0
        AcknowledgedResponse that = (AcknowledgedResponse) o;
    /**
    public int hashCode() {  
        super(in);
    }
        if (this == o) return true;
import org.opensearch.core.common.io.stream.StreamOutput;
    }  
        return this.status;
}
 *
    }
/*  
 * The OpenSearch Contributors require contributions made to  
    }
    public boolean equals(Object o) {
/**
 * this file be licensed under the Apache-2.0 license or a
    @Override  
        if (o == null || getClass() != o.getClass()) return false;  
import java.util.Objects;  
    @Override
 * Generic boolean response indicating the status of some previous request sent to the SDK  
    }  
        return Objects.hash(status);
public class AcknowledgedResponse extends TransportResponse {
    public boolean getStatus() {
import org.opensearch.core.common.io.stream.StreamInput;
