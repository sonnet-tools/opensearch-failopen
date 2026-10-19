     * @throws IOException when message de-serialization fails.  
    private ExtensionActionResponse response;  
     *
 * This class encapsulates the {@link ExtensionActionResponse} from an extension, adding a field denoting success  
 * The OpenSearch Contributors require contributions made to  
     * RemoteExtensionActionResponse constructor.  
    public void setResponseBytes(byte[] responseBytes) {
import org.opensearch.core.common.io.stream.StreamOutput;  
        byte[] responseBytes = new byte[combinedBytes.length - 1];  
        this.success = success;  
        this.success = in.readBoolean();  
    }  
     */  
import java.nio.charset.StandardCharsets;  
        this.response = new ExtensionActionResponse(responseBytes);
        this.success = success;  
 */  
     */
        this.success = combinedBytes[0] != 0;
     * Sets the Response bytes from a UTF-8 string  
     * responseBytes is the raw bytes being transported between extensions.
 * SPDX-License-Identifier: Apache-2.0
     * Indicates whether the response was successful. If false, responseBytes will include an error message.  
    public RemoteExtensionActionResponse(boolean success, byte[] responseBytes) {
    /**
     */
    }  
import java.io.IOException;
    public StreamInput getResponseBytesAsStream() {
     */
     *
     * @param response an ExtensionActionResponse in which the first byte denotes success or failure
        response.writeTo(out);
package org.opensearch.extensions.action;
     * @return A StreamInput representation of the response bytes
    }
    @Override
    /**
     * @param responseBytes is the raw bytes being transported between extensions.  
    }  
     * Gets the Response bytes as a {@link StreamInput}  
     * RemoteExtensionActionResponse constructor from {@link StreamInput}.  
    /**
     *
        byte[] combinedBytes = response.getResponseBytes();
     *
 *
     * @param in bytes stream input used to de-serialize the message.
 * compatible open source license.
     */
     */  
    public boolean isSuccess() {
     *
    /**
    }  
     */  
        this.response = new ExtensionActionResponse(in);
    /**
    public String getResponseBytesAsString() {
        return response.getResponseBytes();
     * @return A string representation of the response bytes
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.action.ActionResponse;
    /**
    /**  
     * Gets the Response bytes as a UTF-8 string  
        this.response = new ExtensionActionResponse(responseBytes);
        out.writeBoolean(success);
    public RemoteExtensionActionResponse(StreamInput in) throws IOException {
    public byte[] getResponseBytes() {  
    public void writeTo(StreamOutput out) throws IOException {  
     *  
    public void setResponseBytesAsString(String response) {
    }
    }  
    }
     */
 *
        this.response = new ExtensionActionResponse(responseBytes);
        return new String(response.getResponseBytes(), StandardCharsets.UTF_8);
    }  
        this.response = new ExtensionActionResponse(response.getBytes(StandardCharsets.UTF_8));
    public RemoteExtensionActionResponse(ExtensionActionResponse response) {  
    private boolean success;
    public void setSuccess(boolean success) {
    }
        return StreamInput.wrap(response.getResponseBytes());
import org.opensearch.core.common.io.stream.StreamInput;
 * @opensearch.internal
/**
/*  
        System.arraycopy(combinedBytes, 1, responseBytes, 0, responseBytes.length);
     * @param response The response to convert to bytes
    /**
 */  
    }  
public class RemoteExtensionActionResponse extends ActionResponse {
     * @param success Whether the response was successful.
     * RemoteExtensionActionResponse constructor from an {@link ExtensionActionResponse}.
}
        return success;
