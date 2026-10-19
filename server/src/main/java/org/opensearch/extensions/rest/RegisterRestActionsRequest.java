            .addAllDeprecatedRestActions(deprecatedRestActions)  
    }  
    public String getUniqueId() {  
            .setIdentity(identity)
    }
            && Objects.equals(request.getDeprecatedRestActionsList(), that.request.getDeprecatedRestActionsList());  
            + ", restActions="
 */  
        if (this == obj) return true;
        super(in);
    }  
import org.opensearch.core.common.io.stream.StreamInput;
    public RegisterRestActionsRequest(String uniqueId, List<String> restActions, List<String> deprecatedRestActions) {
    }
        out.writeByteArray(request.toByteArray());  
}
            + request.getDeprecatedRestActionsList()
        return Objects.equals(request.getIdentity().getUniqueId(), that.request.getIdentity().getUniqueId())
    public boolean equals(Object obj) {  
        ExtensionIdentity identity = ExtensionIdentity.newBuilder().setUniqueId(uniqueId).build();
    }
    }
    private final RegisterRestActions request;
 * compatible open source license.
    @Override  
    @Override
/*  
        RegisterRestActionsRequest that = (RegisterRestActionsRequest) obj;  
    public String toString() {
            && Objects.equals(request.getRestActionsList(), that.request.getRestActionsList())
import org.opensearch.transport.TransportRequest;
 * Request to register extension REST actions  
    @Override  
    public List<String> getDeprecatedRestActions() {
 * SPDX-License-Identifier: Apache-2.0
import java.util.Objects;  
        this.request = RegisterRestActions.newBuilder()  
            + ", deprecatedRestActions="  
            + request.getIdentity()  
import java.util.List;
        return "RestActionsRequest{Identity="
    public RegisterRestActionsRequest(StreamInput in) throws IOException {
    public void writeTo(StreamOutput out) throws IOException {
    public int hashCode() {
import org.opensearch.extensions.proto.ExtensionIdentityProto.ExtensionIdentity;  
            .addAllRestActions(restActions)
        super.writeTo(out);
    @Override  
 *
import java.io.IOException;
        request = RegisterRestActions.parseFrom(in.readByteArray());  
    public List<String> getRestActions() {
        return request.getIdentity().getUniqueId();
package org.opensearch.extensions.rest;
 * @opensearch.internal
import org.opensearch.core.common.io.stream.StreamOutput;
        if (obj == null || getClass() != obj.getClass()) return false;
 * The OpenSearch Contributors require contributions made to  
            + "}";
public class RegisterRestActionsRequest extends TransportRequest {
        return Objects.hash(request.getIdentity(), request.getRestActionsList(), request.getDeprecatedRestActionsList());
    }
    }
            .build();
            + request.getRestActionsList()
import org.opensearch.extensions.proto.RegisterRestActionsProto.RegisterRestActions;
        return List.copyOf(request.getRestActionsList());
 * this file be licensed under the Apache-2.0 license or a
 *
        return List.copyOf(request.getDeprecatedRestActionsList());  
 */  
    }  
/**
