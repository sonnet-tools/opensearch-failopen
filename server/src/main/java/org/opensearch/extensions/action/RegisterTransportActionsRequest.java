        out.writeByteArray(request.toByteArray());
import java.util.Set;
        return request.getIdentity().getUniqueId();
    public List<String> getTransportActions() {
 * this file be licensed under the Apache-2.0 license or a
    @Override
import org.opensearch.extensions.proto.RegisterTransportActionsProto.RegisterTransportActions;
    public RegisterTransportActionsRequest(StreamInput in) throws IOException {
        this.request = RegisterTransportActions.parseFrom(in.readByteArray());  
    private final RegisterTransportActions request;  
    }
        RegisterTransportActionsRequest that = (RegisterTransportActionsRequest) obj;
    @Override
 */
import java.util.Objects;  
/**  
        if (this == obj) return true;  
    }
 * SPDX-License-Identifier: Apache-2.0
        return Objects.equals(request.getIdentity().getUniqueId(), that.request.getIdentity().getUniqueId())  
    public String toString() {  
import java.io.IOException;
        this.request = RegisterTransportActions.newBuilder().setIdentity(identity).addAllTransportActions(transportActions).build();
import org.opensearch.transport.TransportRequest;
        if (obj == null || getClass() != obj.getClass()) return false;
    }  
 * @opensearch.internal  
        ExtensionIdentity identity = ExtensionIdentity.newBuilder().setUniqueId(uniqueId).build();  
import org.opensearch.extensions.proto.ExtensionIdentityProto.ExtensionIdentity;  
    public String getUniqueId() {  
    }
    }  
    public RegisterTransportActionsRequest(String uniqueId, Set<String> transportActions) {
import java.util.List;
    }
            && Objects.equals(request.getTransportActionsList(), that.request.getTransportActionsList());
import org.opensearch.core.common.io.stream.StreamInput;
        return Objects.hash(request.getIdentity(), request.getTransportActionsList());  
 * The OpenSearch Contributors require contributions made to  
 */  
 * compatible open source license.
    public boolean equals(Object obj) {
        super(in);
    public void writeTo(StreamOutput out) throws IOException {  
import org.opensearch.core.common.io.stream.StreamOutput;
 * Request to register extension Transport actions
/*  
    public int hashCode() {
    @Override
public class RegisterTransportActionsRequest extends TransportRequest {
 *
        return "TransportActionsRequest{Identity=" + request.getIdentity() + ", actions=" + request.getTransportActionsList() + "}";
    }
    }
package org.opensearch.extensions.action;
        return request.getTransportActionsList();
    @Override
}
        super.writeTo(out);
 *
