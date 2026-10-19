    public String getAction() {
import java.io.IOException;  
 * @opensearch.api  
            + request.getRequestBytes()
            + "}";
            && Objects.equals(identity.getUniqueId(), that.identity.getUniqueId());  
package org.opensearch.extensions.action;
     */
    public TransportActionRequestFromExtension(String action, ByteString requestBytes, String uniqueId) {
/*  
    @Override  
import org.opensearch.core.common.io.stream.StreamInput;
    }
import java.util.Objects;
        return null;  
        return this.identity.getUniqueId();
    public TransportActionRequestFromExtension(StreamInput in) throws IOException {  
    public String toString() {
    public ByteString getRequestBytes() {
    /**  
 */  
        this.identity = ExtensionIdentity.newBuilder().setUniqueId(uniqueId).build();
            + request.getAction()  
    }
            + ", requestBytes="
        return "TransportActionRequestFromExtension{action="
        return this.request.getRequestBytes();  
        super(in);
        return Objects.hash(request.getAction(), request.getRequestBytes(), identity.getUniqueId());
    public int hashCode() {
        super.writeTo(out);
}
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.extensions.proto.ExtensionIdentityProto.ExtensionIdentity;  
    private final ExtensionTransportMessage request;
        return Objects.equals(request.getAction(), that.request.getAction())
     * TransportActionRequestFromExtension constructor from {@link StreamInput}.
    /**  
import org.opensearch.action.ActionRequestValidationException;  
     * @param requestBytes is the raw bytes being transported between extensions.
        out.writeByteArray(request.toByteArray());
    }
    public boolean equals(Object obj) {  
        return this.request.getAction();
        this.request = ExtensionTransportMessage.newBuilder().setAction(action).setRequestBytes(requestBytes).build();  
        TransportActionRequestFromExtension that = (TransportActionRequestFromExtension) obj;  
    private final ExtensionIdentity identity;  
import org.opensearch.extensions.proto.ExtensionTransportMessageProto.ExtensionTransportMessage;
 *
        if (this == obj) return true;
    @Override  
        this.request = ExtensionTransportMessage.parseFrom(in.readByteArray());  
        this.identity = ExtensionIdentity.parseFrom(in.readByteArray());
    public ActionRequestValidationException validate() {
    @Override  
    }  
            && Objects.equals(request.getRequestBytes(), that.request.getRequestBytes())
        out.writeByteArray(identity.toByteArray());  
 *
     * @param in bytes stream input used to de-serialize the message.  
 */
import org.opensearch.core.common.io.stream.StreamOutput;
     * @throws IOException when message de-serialization fails.
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
    @Override
    }  
            + ", uniqueId="  
import com.google.protobuf.ByteString;
    }
 * Transport Action Request from Extension
/**  
            + identity.getUniqueId()
     */  
     *
     *
 * The OpenSearch Contributors require contributions made to  
     * @param uniqueId to identify which extension is making a transport request call.
     * TransportActionRequestFromExtension constructor.
    public String getUniqueId() {  
 * SPDX-License-Identifier: Apache-2.0
    }
     * @param action is the transport action intended to be invoked which is registered by an extension via {@link ExtensionTransportActionsHandler}.  
        if (obj == null || getClass() != obj.getClass()) return false;
    @Override
public class TransportActionRequestFromExtension extends ActionRequest {
    }
import org.opensearch.action.ActionRequest;
    }  
    }
