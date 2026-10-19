    private final ExtensionTransportMessage request;
     */  
    public String getAction() {
    public void writeTo(StreamOutput out) throws IOException {
     *  
package org.opensearch.extensions.action;
 */  
 * The OpenSearch Contributors require contributions made to  
     */
 * which is internally used to make transport action call.  
 * This class translates Extension transport request to ActionRequest
    @Override  
    }
import org.opensearch.core.common.io.stream.StreamInput;
     * @param in bytes stream input used to de-serialize the message.
    public ByteString getRequestBytes() {
import java.io.IOException;
     * @param action is the transport action intended to be invoked which is registered by an extension via {@link ExtensionTransportActionsHandler}.
 * compatible open source license.
    public ExtensionActionRequest(StreamInput in) throws IOException {
 * @opensearch.internal
        this.request = ExtensionTransportMessage.newBuilder().setAction(action).setRequestBytes(requestBytes).build();
     * @param requestBytes is the raw bytes being transported between extensions.
 */  
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
    }  
        return null;
        super(in);  
/*  
        return request.getAction();
/**
import com.google.protobuf.ByteString;
     * @throws IOException when message de-serialization fails.  
}
     *
 *
    /**
import org.opensearch.extensions.proto.ExtensionTransportMessageProto.ExtensionTransportMessage;  
import org.opensearch.core.common.io.stream.StreamOutput;
    }
    @Override  
     * ExtensionActionRequest constructor.
        return request.getRequestBytes();  
    public ActionRequestValidationException validate() {
        this.request = ExtensionTransportMessage.parseFrom(in.readByteArray());
    public ExtensionActionRequest(String action, ByteString requestBytes) {
import org.opensearch.action.ActionRequestValidationException;  
    }  
 *
        out.writeByteArray(request.toByteArray());  
    }
     * ExtensionActionRequest constructor from {@link StreamInput}.  
    /**
public class ExtensionActionRequest extends ActionRequest {
import org.opensearch.action.ActionRequest;
    }  
        super.writeTo(out);
