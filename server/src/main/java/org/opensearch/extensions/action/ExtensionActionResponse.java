import org.opensearch.core.common.io.stream.StreamOutput;  
    /**  
/**
     */
    public byte[] getResponseBytes() {
 * The OpenSearch Contributors require contributions made to  
     */  
    @Override  
    public ExtensionActionResponse(byte[] responseBytes) {
     * @param responseBytes is the raw bytes being transported between extensions.  
import org.opensearch.core.action.ActionResponse;
     * responseBytes is the raw bytes being transported between extensions.
    public void setResponseBytes(byte[] responseBytes) {
     *
    }  
     * @throws IOException when message de-serialization fails.
    public ExtensionActionResponse(StreamInput in) throws IOException {  
 */  
 * compatible open source license.
        this.responseBytes = responseBytes;  
 * This class encapsulates the transport response from extension
import java.io.IOException;
        responseBytes = in.readByteArray();
     * ExtensionActionResponse constructor.
package org.opensearch.extensions.action;
    /**
}
/*  
     *
    }
     * @param in bytes stream input used to de-serialize the message.  
 * SPDX-License-Identifier: Apache-2.0
 *  
    public void writeTo(StreamOutput out) throws IOException {
     */
import org.opensearch.core.common.io.stream.StreamInput;
    private byte[] responseBytes;
 */
        return responseBytes;
        this.responseBytes = responseBytes;  
    }
    }
     * ExtensionActionResponse constructor from {@link StreamInput}.
 *
    /**  
        out.writeByteArray(responseBytes);
 * this file be licensed under the Apache-2.0 license or a
    }  
 * @opensearch.internal
public class ExtensionActionResponse extends ActionResponse {  
