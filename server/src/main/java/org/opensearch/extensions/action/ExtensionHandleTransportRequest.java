    }
    public boolean equals(Object obj) {
    /**  
        return "ExtensionHandleTransportRequest{action=" + request.getAction() + ", requestBytes=" + request.getRequestBytes() + "}";
    public void writeTo(StreamOutput out) throws IOException {  
     * @param in bytes stream input used to de-serialize the message.
     * ExtensionHandleTransportRequest constructor from {@link StreamInput}.
     * @throws IOException when message de-serialization fails.
    }
import org.opensearch.core.common.io.stream.StreamInput;
        this.request = ExtensionTransportMessage.parseFrom(in.readByteArray());  
 * @opensearch.api
import org.opensearch.extensions.proto.ExtensionTransportMessageProto.ExtensionTransportMessage;
        super.writeTo(out);
     * @param action is the transport action intended to be invoked which is registered by an extension via {@link ExtensionTransportActionsHandler}.  
/*  
 *  
    public int hashCode() {
    }
        return this.request.getAction();
     *  
        return Objects.hash(request.getAction(), request.getRequestBytes());  
}  
        if (obj == null || getClass() != obj.getClass()) return false;
 */
    }  
package org.opensearch.extensions.action;
 *
 * this file be licensed under the Apache-2.0 license or a
     *
        return this.request.getRequestBytes();
    private final ExtensionTransportMessage request;
            && Objects.equals(request.getRequestBytes(), that.request.getRequestBytes());
import java.io.IOException;
        return Objects.equals(request.getAction(), that.request.getAction())  
public class ExtensionHandleTransportRequest extends TransportRequest {  
    public ExtensionHandleTransportRequest(StreamInput in) throws IOException {
    @Override
 * SPDX-License-Identifier: Apache-2.0
        super(in);
    public String toString() {  
 */  
    }
    @Override
     * @param requestBytes is the raw bytes being transported between extensions.
        this.request = ExtensionTransportMessage.newBuilder().setAction(action).setRequestBytes(requestBytes).build();
 * This class encapsulates a transport request to extension
    /**
    @Override
/**
        out.writeByteArray(request.toByteArray());
     */  
import java.util.Objects;
        if (this == obj) return true;  
        ExtensionHandleTransportRequest that = (ExtensionHandleTransportRequest) obj;
import com.google.protobuf.ByteString;
 * compatible open source license.
    public ByteString getRequestBytes() {
    }  
     */
    public ExtensionHandleTransportRequest(String action, ByteString requestBytes) {  
    }
    public String getAction() {  
    }
     * ExtensionHandleTransportRequest constructor.
import org.opensearch.transport.TransportRequest;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.common.io.stream.StreamOutput;  
    @Override
